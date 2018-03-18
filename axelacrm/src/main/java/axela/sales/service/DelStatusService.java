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
import axela.portal.model.AxelaAccDelstatus;
import axela.portal.repository.DelStatusRepository;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;

@Service
public class DelStatusService extends Connect {

	@Autowired
	DelStatusRepository delstatusrepository;
	@Autowired
	EmpRepository empRepository;
	@Autowired
	PortalFilterImpl portalFilterImpl;

	public String delstatusId = "0";
	public String delstatusEntryDate = "";
	public String delstatusEntryId = "0";
	public String delstatusModifiedDate = "";
	public String delstatusModifiedId = "0";
	public String delstatusName = "";
	public String delstatusRank = "0";
	public String requestType = "";
	public String msg = "";
	public String pageNumber = "";
	public int empId = 0;
	public int compId = 0;
	public int page = 0;
	public String perpage = "0";
	public String sort = "";
	public String field = "";
	public static int length = 0;
	public String branchAccess = "";
	public String perPage = "0";
	public String strSearch = "";
	public String orderType = "";
	public String orderByField = "";
	public String strOrderBy = "";

	HashMap output = null;
	JSONObject inputObj = null;

	public Map delStatusService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
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
					delstatusId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "update" :// update
					delstatusId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "delete" :// delete
					if (!inputObj.isNull("delstatusId")) {
						delstatusId = inputObj.getString("delstatusId");
					}
					if (!delstatusId.equals("0")) {
						deleteFields(delstatusId);
					}
					break;

				case "moveup" :// cheking for move up
					if (!inputObj.isNull("delstatusId")) {
						delstatusId = inputObj.getString("delstatusId");
					}
					if (!delstatusId.equals("0")) {
						moveUp(delstatusId);
					}
					break;

				case "movedown" :// cheking for move down
					if (!inputObj.isNull("delstatusId")) {
						delstatusId = inputObj.getString("delstatusId");
					}
					if (!delstatusId.equals("0")) {
						moveDown(delstatusId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("delstatusId")) {
			delstatusId = CNumeric(inputObj.getString("delstatusId"));
		}
		if (!inputObj.isNull("delstatusName")) {
			delstatusName = PadQuotes(inputObj.getString("delstatusName"));
		}
	}

	public void validateFields() {
		if (delstatusId.equals("")) {
			msg += "Enter Delivery status!";
		} else {
			List<AxelaAccDelstatus> obj = null;
			if (requestType.equals("add")) {
				obj = delstatusrepository.findByDelstatusName(delstatusName);
			}
			else if (requestType.equals("update")) {
				obj = delstatusrepository.findDelstatusName(Integer.parseInt(delstatusId), delstatusName);
			}
			if (!obj.isEmpty()) {
				msg += "<br>Similar Delivery Status Name found!";
			}
		}
	}

	public void addFields(HttpServletResponse response) throws ParseException {
		validateFields();
		output = new HashMap();
		if (msg.equals("")) {
			AxelaAccDelstatus axelaaccdelstatus = null;
			if (!delstatusId.equals("0")) {
				axelaaccdelstatus = delstatusrepository.findByDelstatusId(Integer.parseInt(delstatusId));
			} else {
				axelaaccdelstatus = new AxelaAccDelstatus();
			}
			axelaaccdelstatus.setDelstatusId(Integer.parseInt(delstatusId));
			axelaaccdelstatus.setDelstatusName(delstatusName);
			axelaaccdelstatus.setDelstatusRank(delstatusrepository.findrank());
			if (delstatusId.equals("0") && requestType.equals("add")) {
				axelaaccdelstatus.setDelstatusEntryId(empId);
				axelaaccdelstatus.setDelstatusEntryDate(stringToDate(toLongDate(kknow())));
				// axelaaccdelstatus.setDelstatusModifiedDate("");
				axelaaccdelstatus.setDelstatusModifiedId(0);
			} else if (!delstatusId.equals("0") && requestType.equals("update")) {
				axelaaccdelstatus.setDelstatusModifiedId(empId);
				axelaaccdelstatus.setDelstatusModifiedDate(stringToDate(toLongDate(kknow())));
			}
			String delstatusId = delstatusrepository.save(axelaaccdelstatus).getDelstatusId() + "";
			if (!delstatusId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("delstatusId", delstatusId);
				output.put("successmsg", "Delivery Status Added Successfully!");
			} else if (!delstatusId.equals("0") && requestType.equals("update")) {
				output.put("delstatusId", delstatusId);
				output.put("successmsg", "Delivery Status Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String delstatusId) {
		delstatusrepository.delete(Integer.parseInt(delstatusId));
		output.put("successmsg", "Delivery Status Deleted Successfully!");
	}

	public Map populateData(String input) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("delstatusId")) {
			delstatusId = PadQuotes(CNumeric(inputObj.getString("delstatusId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!delstatusId.equals("0")) {
			AxelaAccDelstatus delstatus = delstatusrepository.findByDelstatusId(Integer.parseInt(delstatusId));
			HashMap map = new HashMap();
			map.put("delstatusId", delstatusId);
			map.put("delstatusName", String.valueOf(delstatus.getDelstatusName()));
			if (delstatus.getDelstatusEntryId() != 0) {
				map.put("delstatusEntryDate", strToShortDate(delstatus.getDelstatusEntryDate()));
				map.put("delstatusEntryId", String.valueOf(delstatus.getDelstatusEntryId()));
				map.put("delstatusEntryBy", empRepository.findEmpName(delstatus.getDelstatusEntryId()));
			}
			if (delstatus.getDelstatusModifiedId() != 0) {
				map.put("delstatusModifiedDate", strToShortDate(delstatus.getDelstatusModifiedDate()));
				map.put("delstatusModifiedId", String.valueOf(delstatus.getDelstatusModifiedId()));
				map.put("delstatusModifiedBy", empRepository.findEmpName(delstatus.getDelstatusModifiedId()));
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
				orderByField = "delstatusRank";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strOrderBy = " ORDER BY delstatus." + orderByField + " " + orderType + "";
			List<AxelaAccDelstatus> resultSet = portalFilterImpl.findDelstatus(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			String length = portalFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Delivery Status Details", "delstatusName", "center"));
			listHeader.add(produceHeaderData("Order", "delstatusRank", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaAccDelstatus obj : resultSet) {
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
				value.add(String.valueOf(obj.getDelstatusName()));
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// order details
				type.add(true);
				type.add(true);
				value.add(String.valueOf("up"));
				value.add(String.valueOf("down"));
				paramSubArr.add(obj.getDelstatusId() + "");
				paramSubArr.add("up");
				paramArr.add((ArrayList) paramSubArr.clone());
				paramSubArr.clear();
				paramSubArr.add(obj.getDelstatusId() + "");
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
				actionParam.add("updateDelstatus");
				actionParam.add(PadQuotes(String.valueOf(obj.getDelstatusId())));
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
		mapBodyData.put("value", "Update Delivery Status");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "delstatus.*"));
		list.add(buildSmartArr("Delstatus ID", "numeric", "delstatus.delstatusId"));
		list.add(buildSmartArr("Delstatus Name", "text", "delstatus.delstatusName"));
		list.add(buildSmartArr("Delstatus Rank", "numeric", "delstatus.delstatusRank"));
		// list.add(buildSmartArr("Entry By", "text", "delstatus_entry_id in (select emp_id from compdb.axela_emp where emp_name"));
		list.add(buildSmartArr("Entry Date", "date", "delstatus.delstatusEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "delstatus_modified_id in (select emp_id from compdb.axela_emp where emp_name"));
		list.add(buildSmartArr("Modified Date", "date", "delstatus.delstatusModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

	public void moveUp(String delstatusId) {

		output = new LinkedHashMap();
		int tempRank;
		int delstatusRank = 0;
		delstatusRank = delstatusrepository.findRankfromPriorityId(Integer.parseInt(delstatusId));
		tempRank = delstatusrepository.findMinRank();
		if (tempRank != 0 && delstatusRank != 0) {
			if (delstatusRank != tempRank) {
				tempRank = delstatusRank - 1;
				int updateCount1 = portalFilterImpl.updatePriority(delstatusRank, tempRank, "AxelaAccDelstatus delstatus", "delstatus.delstatusRank");
				int updateCount2 = portalFilterImpl.updatePriorityById(delstatusRank, tempRank, "delstatus.delstatusId", Integer.parseInt(delstatusId), "AxelaAccDelstatus delstatus",
						"delstatus.delstatusRank");
				output.put("moveUp", "Delivery status moved up successfully!");
			}
		} else {
			output.put("errormsg", "not possible");
		}
	}

	public void moveDown(String delstatusId) {
		output = new LinkedHashMap();
		int tempRank;
		int delstatusRank = 0;
		delstatusRank = delstatusrepository.findRankfromPriorityId(Integer.parseInt(delstatusId));
		tempRank = delstatusrepository.findMaxRank();
		if (tempRank != 0 && delstatusRank != 0) {
			if (delstatusRank != tempRank) {
				tempRank = delstatusRank + 1;
				int updateCount1 = portalFilterImpl.updatePriority(delstatusRank, tempRank, "AxelaAccDelstatus delstatus", "delstatus.delstatusRank");
				int updateCount2 = portalFilterImpl.updatePriorityById(delstatusRank, tempRank, "delstatus.delstatusId", Integer.parseInt(delstatusId), "AxelaAccDelstatus delstatus",
						"delstatus.delstatusRank");
				output.put("moveDown", "Delivery status moved Down successfully!");
			}
		} else {
			output.put("errormsg", "not possible");
		}
	}
}
