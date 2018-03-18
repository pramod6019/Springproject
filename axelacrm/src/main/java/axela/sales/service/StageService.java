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
import axela.portal.model.AxelaSalesOpprStage;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;
import axela.sales.repository.OpprRepository;
import axela.sales.repository.SalesOpprStageRepository;
@Service
public class StageService extends Connect
{
	@Autowired
	private SalesOpprStageRepository salesOpprstagerepository;
	@Autowired
	OpprRepository opprRepository;
	@Autowired
	EmpRepository empRepository;
	@Autowired
	PortalFilterImpl portalFilterImpl;

	public String stageId = "0";
	public String stageName = "";
	public String stageProbability = "0";
	public String stageRank = "0";
	public String stageEntryId = "0";
	public String stageEntryDate = "";
	public String stageModifiedId = "0";
	public String stageModifiedDate = "";
	public String requestType = "";
	public String pageNumber = "";
	public int empId = 0;
	public int compId = 0;
	public String msg = "";
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
	public String configSalesOpprName = "";
	public String opprStageId = "0";

	HashMap output = null;
	JSONObject inputObj = null;

	public Map stageService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
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
					stageId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "update" :// update
					stageId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "delete" :// delete .
					if (!inputObj.isNull("stageId")) {
						stageId = inputObj.getString("stageId");
					}
					if (!stageId.equals("0")) {
						deleteFields(stageId);
					}
					break;

				case "moveup" :// cheking for move up
					if (!inputObj.isNull("stageId")) {
						stageId = inputObj.getString("stageId");
					}
					if (!stageId.equals("0")) {
						moveUp(stageId);
					}
					break;

				case "movedown" :// cheking for move down
					if (!inputObj.isNull("stageId")) {
						stageId = inputObj.getString("stageId");
					}
					if (!stageId.equals("0")) {
						moveDown(stageId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("stageId")) {
			stageId = CNumeric(inputObj.getString("stageId"));
		}
		if (!inputObj.isNull("stageName")) {
			stageName = PadQuotes(inputObj.getString("stageName"));
		}
		if (!inputObj.isNull("stageProbability")) {
			stageProbability = CNumeric(inputObj.getString("stageProbability"));
		}
	}

	public void validateFields() {
		List<AxelaSalesOpprStage> obj = null;
		if (stageName.equals("")) {
			msg += "Enter Stage  Name!";
		} else {

			if (requestType.equals("add")) {
				obj = salesOpprstagerepository.findByStageName(stageName);
			}
			else if (requestType.equals("update")) {
				obj = salesOpprstagerepository.findStageName(Integer.parseInt(stageId), stageName);
			}
			if (!obj.isEmpty()) {
				msg += "<br>Similar Stage Name found!";
			}
		}
		if (stageProbability.equals("")) {
			msg += "Enter Stage Probability!";
		}
		if (!stageProbability.equals("")) {
			if (Integer.parseInt(stageProbability) < 0) {
				msg = msg + "<br>Stage probability cannot be less than zero! ";
			}
			if (Integer.parseInt(stageProbability) > 100) {
				msg = msg + "<br>Stage probability cannot be greater than hundred! ";
			}
		}
	}

	public void addFields(HttpServletResponse response) throws ParseException {
		validateFields();
		output = new HashMap();
		if (msg.equals("")) {
			AxelaSalesOpprStage axelasalesopprStage = null;
			if (!stageId.equals("0")) {
				axelasalesopprStage = salesOpprstagerepository.findByStageId(Integer.parseInt(stageId));
			} else {
				axelasalesopprStage = new AxelaSalesOpprStage();
			}
			axelasalesopprStage.setStageId(Integer.parseInt(stageId));
			axelasalesopprStage.setStageName(stageName);
			axelasalesopprStage.setStageProbability(Short.parseShort(stageProbability));
			axelasalesopprStage.setStageRank(salesOpprstagerepository.findrank());
			if (stageId.equals("0") && requestType.equals("add")) {
				axelasalesopprStage.setStageEntryId(empId);
				axelasalesopprStage.setStageEntryDate(stringToDate(toLongDate(kknow())));
				axelasalesopprStage.setStageModifiedId(0);
			} else if (!stageId.equals("0") && requestType.equals("update")) {
				axelasalesopprStage.setStageModifiedId(empId);
				axelasalesopprStage.setStageModifiedDate(stringToDate(toLongDate(kknow())));
			}
			String stageId = salesOpprstagerepository.save(axelasalesopprStage).getStageId() + "";
			if (!stageId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("stageId", stageId);
				output.put("successmsg", "Stage Added Successfully!");
			} else if (!stageId.equals("0") && requestType.equals("update")) {
				output.put("stageId", stageId);
				output.put("successmsg", "Stage Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String stageId) {
		msg = "";
		if (!stageId.equals("")) {
			opprStageId = stageId;
			Integer opprStageIdFromDb = opprRepository.findByOppprId(Integer.parseInt(stageId));
			if (opprStageIdFromDb != null && opprStageIdFromDb != 0) {
				msg = msg + "<br>Stage is associated with " + configSalesOpprName + "!";
			}
		}
		if (stageId.equals("1")) {
			msg = msg + "<br>Stage Cannot Be Deleted! ";
		}
		if (msg.equals("")) {
			salesOpprstagerepository.delete(Integer.parseInt(stageId));
			output.put("successmsg", "Stage Deleted Successfully!");
		} else {
			output.put("errormsg", msg);
		}
	}

	public Map populateData(String input) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("stageId")) {
			stageId = PadQuotes(CNumeric(inputObj.getString("stageId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!stageId.equals("0")) {
			AxelaSalesOpprStage stage = salesOpprstagerepository.findByStageId(Integer.parseInt(stageId));
			HashMap map = new HashMap();
			map.put("stageId", stageId);
			map.put("stageName", String.valueOf(stage.getStageName()));
			map.put("stageProbability", String.valueOf(stage.getStageProbability()));
			if (stage.getStageEntryId() != 0) {
				map.put("stageEntryDate", strToShortDate(stage.getStageEntryDate()));
				map.put("stageEntryId", String.valueOf(stage.getStageEntryId()));
				map.put("stageEntryBy", empRepository.findEmpName(stage.getStageEntryId()));
			}
			if (stage.getStageModifiedId() != 0) {
				map.put("stageModifiedDate", strToShortDate(stage.getStageModifiedDate()));
				map.put("stageModifiedId", String.valueOf(stage.getStageModifiedId()));
				map.put("stageModifiedBy", empRepository.findEmpName(stage.getStageModifiedId()));
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
				orderByField = "stageRank";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strOrderBy = " ORDER BY stage." + orderByField + " " + orderType + "";
			List<AxelaSalesOpprStage> resultSet = portalFilterImpl.findStage(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			String length = portalFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Stage Details", "stageName", "center"));
			listHeader.add(produceHeaderData("Probability", "stageProbability", "center"));
			listHeader.add(produceHeaderData("Order", "stageRank", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaSalesOpprStage obj : resultSet) {
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
				value.add(String.valueOf(obj.getStageName()));
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				type.add(false);
				value.add(String.valueOf(obj.getStageProbability()));
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// order details
				type.add(true);
				type.add(true);
				value.add(String.valueOf("up"));
				value.add(String.valueOf("down"));
				paramSubArr.add(obj.getStageId() + "");
				paramSubArr.add("up");
				paramArr.add((ArrayList) paramSubArr.clone());
				paramSubArr.clear();
				paramSubArr.add(obj.getStageId() + "");
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
				actionParam.add("updateStage");
				actionParam.add(PadQuotes(String.valueOf(obj.getStageId())));
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
		mapBodyData.put("value", "Update Stage");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "stage.*"));
		list.add(buildSmartArr("Stage ID", "numeric", "stage.stageId"));
		list.add(buildSmartArr("Stage Name", "text", "stage.stageName"));
		list.add(buildSmartArr("Stage Probability", "numeric", "stage.stageProbability"));
		list.add(buildSmartArr("Stage Rank", "numeric", "stage.stageRank"));
		// list.add(buildSmartArr("Entry By", "text", "stage_entry_id in (select emp_id from compdb.axela_emp where emp_name"},
		list.add(buildSmartArr("Entry Date", "date", "stage.stageEntryDate"));
		// /list.add(buildSmartArr("Modified By", "text", "stage_modified_id in (select emp_id from compdb.axela_emp where emp_name"},
		list.add(buildSmartArr("Modified Date", "date", "stage.stageModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

	public void moveUp(String stageId) {
		output = new LinkedHashMap();
		int tempRank;
		int delstatusRank = 0;
		delstatusRank = salesOpprstagerepository.findRankfromStageId(Integer.parseInt(stageId));
		tempRank = salesOpprstagerepository.findMinRank();
		if (tempRank != 0 && delstatusRank != 0) {
			if (delstatusRank != tempRank) {
				tempRank = delstatusRank - 1;
				int updateCount1 = portalFilterImpl.updatePriority(delstatusRank, tempRank, "AxelaSalesOpprStage stage", "stage.stageRank ");
				int updateCount2 = portalFilterImpl.updatePriorityById(delstatusRank, tempRank, "stage.stageId", Integer.parseInt(stageId), "AxelaSalesOpprStage stage",
						"stage.stageRank");
				output.put("msg", "Stage moved up successfully!");
			}
		} else {
			output.put("errormsg", "Something Went Wrong Please Check Again!");
		}
	}

	public void moveDown(String stageId) {
		output = new LinkedHashMap();
		int tempRank;
		int delstatusRank = 0;
		delstatusRank = salesOpprstagerepository.findRankfromStageId(Integer.parseInt(stageId));
		tempRank = salesOpprstagerepository.findMaxRank();
		if (tempRank != 0 && delstatusRank != 0) {
			if (delstatusRank != tempRank) {
				tempRank = delstatusRank + 1;
				int updateCount1 = portalFilterImpl.updatePriority(delstatusRank, tempRank, "AxelaSalesOpprStage stage", "stage.stageRank ");
				int updateCount2 = portalFilterImpl.updatePriorityById(delstatusRank, tempRank, "stage.stageId", Integer.parseInt(stageId), "AxelaSalesOpprStage stage",
						"stage.stageRank");
				output.put("msg", "Stage moved Down successfully!");
			}
		} else {
			output.put("errormsg", "Something Went Wrong Please Check Again!");
		}
	}

}