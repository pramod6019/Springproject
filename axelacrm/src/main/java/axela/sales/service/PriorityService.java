package axela.sales.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.customer.model.AxelaCustomer;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;
import axela.portal.repository.SalesPriorityRepository;
import axela.sales.model.AxelaSalesOpprPriority;
import axela.sales.repository.OpprRepository;

@Service
public class PriorityService extends Connect
{

	@Autowired
	private SalesPriorityRepository salespriorityrepository;
	@Autowired
	private EmpRepository empRepository;
	@Autowired
	PortalFilterImpl portalFilterImpl;
	@Autowired
	OpprRepository opprRepository;

	public String priorityopprId = "0";
	public String priorityopprDesc = "";
	public String priorityopprDuehrs = "0.0";
	public String priorityopprEntryDate = "";
	public String priorityopprEntryId = "0";
	public String priorityopprModifiedDate = "";
	public String priorityopprModifiedId = "0";
	public String priorityopprName = "";
	public String priorityopprRank = "";
	public String priorityopprTrigger1Hrs = "0.0";
	public String priorityopprTrigger2Hrs = "0.0";
	public String priorityopprTrigger3Hrs = "0.0";
	public String priorityopprTrigger4Hrs = "0.0";
	public String priorityopprTrigger5Hrs = "0.0";
	public String requestType = "";
	public String msg = "";
	public String pageNumber = "";
	public int empId = 0;
	public int compId = 0;
	public int page = 0;
	public String perpage = "0";
	public String sort = "";
	public String field = "";
	public String branchAccess = "";
	public String perPage = "0";
	public String strSearch = "";
	public String orderType = "";
	public String orderByField = "";
	public String strOrderBy = "";
	public String configSalesOpprName;
	HashMap output = null;
	JSONObject inputObj = null;

	public Map<String, String> priorityService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		perPage = getSession("perPage", session);
		perPage = CNumeric(getSession("empRecperpage", session));
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new HashMap();
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			switch (requestType) {

				case "add" : // add
					priorityopprId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "update" :// update
					priorityopprId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "delete" :// delete
					if (!inputObj.isNull("priorityopprId")) {
						priorityopprId = inputObj.getString("priorityopprId");
					}
					if (!priorityopprId.equals("0")) {
						deleteFields(priorityopprId);
					}
					break;

				case "moveup" :// cheking for move up
					if (!inputObj.isNull("priorityopprId")) {
						priorityopprId = inputObj.getString("priorityopprId");
					}
					if (!priorityopprId.equals("0")) {
						moveUp(priorityopprId);
					}
					break;

				case "movedown" :// cheking for move down
					if (!inputObj.isNull("priorityopprId")) {
						priorityopprId = inputObj.getString("priorityopprId");
					}
					if (!priorityopprId.equals("0")) {
						moveDown(priorityopprId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("priorityopprId")) {
			priorityopprId = CNumeric(inputObj.getString("priorityopprId"));
		}
		if (!inputObj.isNull("priorityopprDesc")) {
			priorityopprDesc = PadQuotes(inputObj.getString("priorityopprDesc"));
		}
		if (!inputObj.isNull("priorityopprDuehrs")) {
			priorityopprDuehrs = PadQuotes(inputObj.getString("priorityopprDuehrs"));
		}
		if (!inputObj.isNull("priorityopprName")) {
			priorityopprName = PadQuotes(inputObj.getString("priorityopprName"));
		}
		if (!inputObj.isNull("priorityopprTrigger1Hrs")) {
			priorityopprTrigger1Hrs = CNumeric(inputObj.getString("priorityopprTrigger1Hrs"));
		}
		if (!inputObj.isNull("priorityopprTrigger2Hrs")) {
			priorityopprTrigger2Hrs = CNumeric(inputObj.getString("priorityopprTrigger2Hrs"));
		}
		if (!inputObj.isNull("priorityopprTrigger3Hrs")) {
			priorityopprTrigger3Hrs = CNumeric(inputObj.getString("priorityopprTrigger3Hrs"));
		}
		if (!inputObj.isNull("priorityopprTrigger4Hrs")) {
			priorityopprTrigger4Hrs = CNumeric(inputObj.getString("priorityopprTrigger4Hrs"));
		}
		if (!inputObj.isNull("priorityopprTrigger5Hrs")) {
			priorityopprTrigger5Hrs = CNumeric(inputObj.getString("priorityopprTrigger5Hrs"));
		}
	}

	public void validateFields() {
		List<AxelaSalesOpprPriority> obj = null;
		if (priorityopprName.equals("")) {
			msg += "Enter name!";
		} else {
			if (requestType.equals("add")) {
				obj = salespriorityrepository.findByPriorityopprName(priorityopprName);
			}
			else if (requestType.equals("update")) {
				obj = salespriorityrepository.findPriorityopprName(Integer.parseInt(priorityopprId), priorityopprName);
			}
			if (!obj.isEmpty()) {
				msg += "<br>Similar Priority found!";
			}
		}
		if (priorityopprDesc.equals("")) {
			msg += "Enter description!";
		}
		if (priorityopprDuehrs.equals("0.0")) {
			msg += "Enter duehrs!";
		}
	}

	public void addFields(HttpServletResponse response) throws ParseException {
		validateFields();
		output = new HashMap();
		if (msg.equals("")) {
			AxelaSalesOpprPriority axelasalesopprpriority = null;
			if (!priorityopprId.equals("0")) {
				axelasalesopprpriority = salespriorityrepository.findByPriorityopprId(Integer.parseInt(priorityopprId));
			} else {
				axelasalesopprpriority = new AxelaSalesOpprPriority();
			}
			axelasalesopprpriority.setPriorityopprId(Integer.parseInt(priorityopprId));
			axelasalesopprpriority.setPriorityopprDesc(priorityopprDesc);
			axelasalesopprpriority.setPriorityopprDuehrs(priorityopprDuehrs);
			axelasalesopprpriority.setPriorityopprName(priorityopprName);
			axelasalesopprpriority.setPriorityopprRank(salespriorityrepository.findrank());
			axelasalesopprpriority.setPriorityopprTrigger1Hrs(priorityopprTrigger1Hrs);
			axelasalesopprpriority.setPriorityopprTrigger2Hrs(priorityopprTrigger2Hrs);
			axelasalesopprpriority.setPriorityopprTrigger3Hrs(priorityopprTrigger3Hrs);
			axelasalesopprpriority.setPriorityopprTrigger4Hrs(priorityopprTrigger4Hrs);
			axelasalesopprpriority.setPriorityopprTrigger5Hrs(priorityopprTrigger5Hrs);
			if (priorityopprId.equals("0") && requestType.equals("add")) {
				axelasalesopprpriority.setPriorityopprEntryId(empId);
				axelasalesopprpriority.setPriorityopprEntryDate(stringToDate(toLongDate(kknow())));
				axelasalesopprpriority.setPriorityopprModifiedId(0);
			} else if (!priorityopprId.equals("0") && requestType.equals("update")) {
				axelasalesopprpriority.setPriorityopprModifiedId(empId);
				axelasalesopprpriority.setPriorityopprModifiedDate(stringToDate(toLongDate(kknow())));
			}
			String priorityopprId = salespriorityrepository.save(axelasalesopprpriority).getPriorityopprId() + "";
			if (!priorityopprId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("priorityopprId", priorityopprId);
				output.put("successmsg", "Priority Added Successfully!!");
			} else if (!priorityopprId.equals("0") && requestType.equals("update")) {
				output.put("priorityopprId", priorityopprId);
				output.put("successmsg", "Priority Updated Successfully!!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String priorityopprId) {
		msg = "";
		if (!priorityopprId.equals("")) {
			int OpprPriorityopprIdFromDb = opprRepository.findByOppprId(Integer.parseInt(priorityopprId));
			if (OpprPriorityopprIdFromDb != 0) {
				msg = msg + "<br>Priority is associated with " + configSalesOpprName + "!";
			}
		}
		if (priorityopprId.equals("1")) {
			msg = "<br>First record cannot be deleted ";
		}
		if (msg.equals("")) {
			salespriorityrepository.delete(Integer.parseInt(priorityopprId));
			output.put("successmsg", "Priority Deleted Successfully!");
		} else {
			output.put("errormsg", msg);
		}
	}

	public Map populateData(String input) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("priorityopprId")) {
			priorityopprId = PadQuotes(CNumeric(inputObj.getString("priorityopprId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!priorityopprId.equals("0")) {
			AxelaSalesOpprPriority salesOpprPriority = salespriorityrepository.findByPriorityopprId(Integer.parseInt(priorityopprId));
			HashMap map = new HashMap();
			map.put("priorityopprId", priorityopprId);
			map.put("priorityopprName", String.valueOf(salesOpprPriority.getPriorityopprName()));
			map.put("priorityopprDesc", String.valueOf(salesOpprPriority.getPriorityopprDesc()));
			map.put("priorityopprDuehrs", String.valueOf(salesOpprPriority.getPriorityopprDuehrs()));
			map.put("priorityopprTrigger1Hrs", String.valueOf(salesOpprPriority.getPriorityopprTrigger1Hrs()));
			map.put("priorityopprTrigger2Hrs", String.valueOf(salesOpprPriority.getPriorityopprTrigger2Hrs()));
			map.put("priorityopprTrigger3Hrs", String.valueOf(salesOpprPriority.getPriorityopprTrigger3Hrs()));
			map.put("priorityopprTrigger4Hrs", String.valueOf(salesOpprPriority.getPriorityopprTrigger4Hrs()));
			map.put("priorityopprTrigger5Hrs", String.valueOf(salesOpprPriority.getPriorityopprTrigger5Hrs()));
			if (salesOpprPriority.getPriorityopprEntryId() != 0) {
				map.put("priorityopprEntryDate", strToShortDate(salesOpprPriority.getPriorityopprEntryDate()));
				map.put("priorityopprEntryId", String.valueOf(salesOpprPriority.getPriorityopprEntryId()));
				map.put("priorityopprEntryBy", empRepository.findEmpName(salesOpprPriority.getPriorityopprEntryId()));
			}
			if (salesOpprPriority.getPriorityopprModifiedId() != 0) {
				map.put("priorityopprModifiedDate", strToShortDate(salesOpprPriority.getPriorityopprModifiedDate()));
				map.put("priorityopprModifiedId", String.valueOf(salesOpprPriority.getPriorityopprModifiedId()));
				map.put("priorityopprModifiedBy", empRepository.findEmpName(salesOpprPriority.getPriorityopprModifiedId()));
			}
			list.add(map);
		}
		output.put("populateData", list);
		return output;
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		String strSearch = "";
		String strOrderBy = "";
		if (empId != 0) {
			page = 0;
			output = new LinkedHashMap<String, String>();
			String customerType = "";
			List<AxelaCustomer> customerList = null;
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			PageRequest request = null;
			if (!inputObj.isNull("requestType")) {
				requestType = PadQuotes((inputObj.getString("requestType")));
			}
			if (!inputObj.isNull("sortField")) {
				orderByField = PadQuotes((inputObj.getString("sortField")));
			}
			if (!inputObj.isNull("pageIndex")) {
				page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
			}
			if (!inputObj.isNull("sortDirection")) {
				orderType = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
			}
			perPage = CNumeric(getSession("empRecperpage", session));
			if (orderType.equals("")) {
				orderType = "DESC";
			}
			if (orderByField.equals("")) {
				orderByField = "priorityopprRank";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strOrderBy = " ORDER BY priority." + orderByField + " " + orderType + "";
			List<AxelaSalesOpprPriority> resultSet = portalFilterImpl.findPriorityopprDetail(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			String length = portalFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Priority Details", "priorityopprName", "center"));
			listHeader.add(produceHeaderData("Order", "priorityopprRank", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaSalesOpprPriority obj : resultSet) {
				ArrayList<String> paramSubArr = new ArrayList<String>();
				ArrayList paramArr = new ArrayList();
				ArrayList type = new ArrayList();
				ArrayList value = new ArrayList();
				HashMap<String, List<HashMap>> mapData = new HashMap<String, List<HashMap>>();
				HashMap<String, List<HashMap>> mapAction = new HashMap<String, List<HashMap>>();
				HashMap<String, List<String>> mapBodyData = new HashMap<String, List<String>>();
				List<HashMap> listData = new ArrayList<HashMap>();
				count++;
				// Start Body data

				// count
				type.add(false);
				value.add(count);
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// details.
				type.add(false);
				value.add(String.valueOf(obj.getPriorityopprName()));
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// order details
				type.add(true);
				type.add(true);
				value.add(String.valueOf("up"));
				value.add(String.valueOf("down"));
				paramSubArr.add(obj.getPriorityopprId() + "");
				paramSubArr.add("up");
				paramArr.add((ArrayList) paramSubArr.clone());
				paramSubArr.clear();
				paramSubArr.add(obj.getPriorityopprId() + "");
				paramSubArr.add("down");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				paramSubArr.clear();
				paramArr.clear();
				type.clear();
				value.clear();
				// End Body data
				mapData.put("td", listData);
				ArrayList actionParam = new ArrayList();
				actionParam.add("updatePriority");
				actionParam.add(PadQuotes(String.valueOf(obj.getPriorityopprId())));
				mapAction.put("td", produceActionData(actionParam));
				listAction.add(mapAction);
				listBody.add(mapData);
			}
			output.put("meta", mapNavi);
			output.put("action", listAction);
			output.put("tdalign", listBodyAlign);
			output.put("thead", listHeader);
			output.put("tbody", listBody);
		}
		return output;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<HashMap> produceActionData(ArrayList<String> Param) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Priority");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "priority.*"));
		list.add(buildSmartArr("ID", "numeric", "priority.priorityopprId"));
		list.add(buildSmartArr("Name", "text", "priority.priorityopprName"));
		list.add(buildSmartArr("Desc", "text", "priority.priorityopprDesc"));
		list.add(buildSmartArr("Rank", "numeric", "priority.priorityopprRank"));
		list.add(buildSmartArr("DueHrs", "numeric", "priority.priorityopprDuehrs"));
		list.add(buildSmartArr("Trigger1", "numeric", "priority.priorityopprTrigger1Hrs"));
		list.add(buildSmartArr("Trigger2", "numeric", "priority.priorityopprTrigger2Hrs"));
		list.add(buildSmartArr("Trigger3", "numeric", "priority.priorityopprTrigger3Hrs"));
		list.add(buildSmartArr("Trigger4", "numeric", "priority.priorityopprTrigger4Hrs"));
		list.add(buildSmartArr("Trigger5", "numeric", "priority.priorityopprTrigger5Hrs"));
		// list.add(buildSmartArr("Entry By", "text", "priorityoppr_entry_id in (select emp_id from compdb.axela_emp where emp_name"));
		list.add(buildSmartArr("Entry Date", "date", "priority.priorityopprEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "priorityoppr_modified_id in (select emp_id from compdb.axela_emp where emp_name"));
		list.add(buildSmartArr("Modified Date", "date", "priority.priorityopprModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

	public void moveUp(String priorityopprId) {
		output = new LinkedHashMap();
		int tempRank;
		int delstatusRank = 0;
		delstatusRank = salespriorityrepository.findRankfromPriorityId(Integer.parseInt(priorityopprId));
		tempRank = salespriorityrepository.findMinRank();
		if (tempRank != 0 && delstatusRank != 0) {
			if (delstatusRank != tempRank) {
				tempRank = delstatusRank - 1;
				int updateCount1 = portalFilterImpl.updatePriority(delstatusRank, tempRank, "AxelaSalesOpprPriority priority", "priority.priorityopprRank");
				int updateCount2 = portalFilterImpl.updatePriorityById(delstatusRank, tempRank, "priority.priorityopprId", Integer.parseInt(priorityopprId), "AxelaSalesOpprPriority priority",
						"priority.priorityopprRank");
				output.put("msg", "Priority moved up successfully!");
			}
		} else {
			output.put("errormsg", "not possible");
		}
	}

	public void moveDown(String priorityopprId) {
		output = new LinkedHashMap();
		int tempRank;
		int delstatusRank = 0;
		delstatusRank = salespriorityrepository.findRankfromPriorityId(Integer.parseInt(priorityopprId));
		tempRank = salespriorityrepository.findMaxRank();
		if (tempRank != 0 && delstatusRank != 0) {
			if (delstatusRank != tempRank) {
				tempRank = delstatusRank + 1;
				int updateCount1 = portalFilterImpl.updatePriority(delstatusRank, tempRank, "AxelaSalesOpprPriority priority", "priority.priorityopprRank");
				int updateCount2 = portalFilterImpl.updatePriorityById(delstatusRank, tempRank, "priority.priorityopprId", Integer.parseInt(priorityopprId), "AxelaSalesOpprPriority priority",
						"priority.priorityopprRank");
				output.put("msg", "Priority moved Down successfully!");
			}
		} else {
			output.put("errormsg", "not possible");
		}
	}
}
