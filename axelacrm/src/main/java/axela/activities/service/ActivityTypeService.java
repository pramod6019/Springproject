package axela.activities.service;

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
import axela.portal.model.AxelaActivityType;
import axela.portal.repository.ActivityTypeRepository;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;
@Service
public class ActivityTypeService extends Connect
{

	@Autowired
	private ActivityTypeRepository activitytyperepository;
	@Autowired
	private EmpRepository empRepository;
	@Autowired
	PortalFilterImpl portalFilterImpl;

	public String activitytypeId = "0";
	public String activitytypeDesc = "";
	public String activitytypeDuehrs = "0.0";
	public String activitytypeEntryDate = "";
	public String activitytypeEntryId = "0";
	public String activitytypeModifiedDate = "";
	public String activitytypeModifiedId = "0";
	public String activitytypeName = "";
	public String activitytypeRank = "0";
	public String activitytypeTrigger1Hrs = "0.0";
	public String activitytypeTrigger2Hrs = "0.0";
	public String activitytypeTrigger3Hrs = "0.0";
	public String activitytypeTrigger4Hrs = "0.0";
	public String activitytypeTrigger5Hrs = "0.0";
	public int resultRank = 0;
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

	public Map activityType(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
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
					activitytypeId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;

				case "update" :// update
					activitytypeId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;

				case "delete" :// delete
					if (!inputObj.isNull("activitytypeId")) {
						activitytypeId = inputObj.getString("activitytypeId");
					}
					if (!activitytypeId.equals("0")) {
						deleteFields(activitytypeId);
					}
					break;

				case "moveup" :// cheking for move up
					if (!inputObj.isNull("activitytypeId")) {
						activitytypeId = inputObj.getString("activitytypeId");
					}
					if (!activitytypeId.equals("0")) {
						moveUp(activitytypeId);
					}
					break;

				case "movedown" :// cheking for move down
					if (!inputObj.isNull("activitytypeId")) {
						activitytypeId = inputObj.getString("activitytypeId");
					}
					if (!activitytypeId.equals("0")) {
						moveDown(activitytypeId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("activitytypeId")) {
			activitytypeId = CNumeric(inputObj.getString("activitytypeId"));
		}

		if (!inputObj.isNull("activitytypeDesc")) {
			activitytypeDesc = PadQuotes(inputObj.getString("activitytypeDesc"));
		}
		if (!inputObj.isNull("activitytypeDuehrs")) {
			activitytypeDuehrs = PadQuotes(inputObj.getString("activitytypeDuehrs"));
		}
		if (!inputObj.isNull("activitytypeName")) {
			activitytypeName = PadQuotes(inputObj.getString("activitytypeName"));
		}
		if (!inputObj.isNull("activitytypeTrigger1Hrs")) {
			activitytypeTrigger1Hrs = CNumeric(inputObj.getString("activitytypeTrigger1Hrs"));
		}
		if (!inputObj.isNull("activitytypeTrigger2Hrs")) {
			activitytypeTrigger2Hrs = CNumeric(inputObj.getString("activitytypeTrigger2Hrs"));
		}
		if (!inputObj.isNull("activitytypeTrigger3Hrs")) {
			activitytypeTrigger3Hrs = CNumeric(inputObj.getString("activitytypeTrigger3Hrs"));
		}
		if (!inputObj.isNull("activitytypeTrigger4Hrs")) {
			activitytypeTrigger4Hrs = CNumeric(inputObj.getString("activitytypeTrigger4Hrs"));
		}
		if (!inputObj.isNull("activitytypeTrigger5Hrs")) {
			activitytypeTrigger5Hrs = CNumeric(inputObj.getString("activitytypeTrigger5Hrs"));
		}
	}

	public void validatefields() {
		if (activitytypeDesc.equals("")) {
			msg += "Enter Activity Type Desc!";
		} else {
			List<AxelaActivityType> obj = null;
			if (requestType.equals("add")) {
				obj = activitytyperepository.findByActivitytypeName(activitytypeName);
			}
			else if (requestType.equals("update")) {
				obj = activitytyperepository.findActivitytypeName(Integer.parseInt(activitytypeId), activitytypeName);
			}
			if (!obj.isEmpty()) {
				msg += "<br>Similar Activity Type Name found!";
			}
		}
	}

	public void addFields(HttpServletResponse response, HttpSession session) throws ParseException {
		validatefields();
		if (msg.equals("")) {
			AxelaActivityType axelaactivitytype = null;
			if (!activitytypeId.equals("0")) {
				axelaactivitytype = activitytyperepository.findByActivitytypeId(Integer.parseInt(activitytypeId));
			} else {
				axelaactivitytype = new AxelaActivityType();
			}
			axelaactivitytype.setActivitytypeId(Integer.parseInt(activitytypeId));
			axelaactivitytype.setActivitytypeDesc(activitytypeDesc);
			axelaactivitytype.setActivitytypeDuehrs(activitytypeDuehrs);
			axelaactivitytype.setActivitytypeName(activitytypeName);
			axelaactivitytype.setActivitytypeRank(activitytyperepository.findRank());
			axelaactivitytype.setActivitytypeTrigger1Hrs(activitytypeTrigger1Hrs);
			axelaactivitytype.setActivitytypeTrigger2Hrs(activitytypeTrigger2Hrs);
			axelaactivitytype.setActivitytypeTrigger3Hrs(activitytypeTrigger3Hrs);
			axelaactivitytype.setActivitytypeTrigger4Hrs(activitytypeTrigger4Hrs);
			axelaactivitytype.setActivitytypeTrigger5Hrs(activitytypeTrigger5Hrs);
			if (activitytypeId.equals("0") && requestType.equals("add")) {
				axelaactivitytype.setActivitytypeEntryId(empId);
				axelaactivitytype.setActivitytypeEntryDate(getTimeByZone(session));
				// axelaactivitytype.setActivitytypeModifiedDate("");
				axelaactivitytype.setActivitytypeModifiedId(0);
			} else if (!activitytypeId.equals("0") && requestType.equals("update")) {
				axelaactivitytype.setActivitytypeModifiedId(empId);
				axelaactivitytype.setActivitytypeModifiedDate(getTimeByZone(session));
			}
			String activitytypeId = activitytyperepository.save(axelaactivitytype).getActivitytypeId() + "";
			if (!activitytypeId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("activitytypeId", activitytypeId);
				output.put("successmsg", "Activity Type Added Successfully!");
			} else if (!activitytypeId.equals("0") && requestType.equals("update")) {
				output.put("activitytypeId", activitytypeId);
				output.put("successmsg", "Activity Type Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String activitytypeId) {
		activitytyperepository.delete(Integer.parseInt(activitytypeId));
		output.put("successmsg", "Activity Type Deleted Successfully!");
	}

	public Map populateData(String input) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("activitytypeId")) {
			activitytypeId = PadQuotes(CNumeric(inputObj.getString("activitytypeId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!activitytypeId.equals("0")) {
			AxelaActivityType activityType = activitytyperepository.findByActivitytypeId(Integer.parseInt(activitytypeId));
			HashMap map = new HashMap();
			map.put("activitytypeId", activitytypeId);
			map.put("activitytypeName", String.valueOf(activityType.getActivitytypeName()));
			map.put("activitytypeDesc", String.valueOf(activityType.getActivitytypeDesc()));
			map.put("activitytypeRank", String.valueOf(activityType.getActivitytypeRank()));
			map.put("activitytypeDuehrs", String.valueOf(activityType.getActivitytypeDuehrs()));
			map.put("activitytypeTrigger1Hrs", String.valueOf(activityType.getActivitytypeTrigger1Hrs()));
			map.put("activitytypeTrigger2Hrs", String.valueOf(activityType.getActivitytypeTrigger2Hrs()));
			map.put("activitytypeTrigger3Hrs", String.valueOf(activityType.getActivitytypeTrigger3Hrs()));
			map.put("activitytypeTrigger4Hrs", String.valueOf(activityType.getActivitytypeTrigger4Hrs()));
			map.put("activitytypeTrigger5Hrs", String.valueOf(activityType.getActivitytypeTrigger5Hrs()));
			if (activityType.getActivitytypeEntryId() != 0) {
				map.put("activitytypeEntryDate", strToShortDate(activityType.getActivitytypeEntryDate()));
				map.put("activitytypeEntryId", String.valueOf(activityType.getActivitytypeEntryId()));
				map.put("activitytypeEntryBy", empRepository.findEmpName(activityType.getActivitytypeEntryId()));
			}
			if (activityType.getActivitytypeModifiedId() != 0) {
				map.put("activitytypeModifiedDate", strToShortDate(activityType.getActivitytypeModifiedDate()));
				map.put("activitytypeModifiedId", String.valueOf(activityType.getActivitytypeModifiedId()));
				map.put("activitytypeModifiedBy", empRepository.findEmpName(activityType.getActivitytypeModifiedId()));
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
		requestType = "";
		if (empId != 0) {
			page = 0;
			output = new LinkedHashMap<String, String>();
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
				orderByField = "activitytypeRank";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strOrderBy = " ORDER BY type." + orderByField + " " + orderType + "";
			List<AxelaActivityType> resultSet = portalFilterImpl.findActivitytype(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			String length = portalFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("ID", "activitytypeId", "center"));
			listHeader.add(produceHeaderData("Type Details", "activitytypeName", "center"));
			listHeader.add(produceHeaderData("Order", "activitytypeRank", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaActivityType obj : resultSet) {
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

				// ID
				type.add(false);
				value.add(obj.getActivitytypeId());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// details.
				type.add(false);
				value.add(String.valueOf(obj.getActivitytypeName()));
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// order details
				type.add(true);
				type.add(true);
				value.add(String.valueOf("up"));
				value.add(String.valueOf("down"));
				paramSubArr.add(obj.getActivitytypeId() + "");
				paramSubArr.add("up");
				paramArr.add((ArrayList) paramSubArr.clone());
				paramSubArr.clear();
				paramSubArr.add(obj.getActivitytypeId() + "");
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
				actionParam.add("updateActivityType");
				actionParam.add(PadQuotes(String.valueOf(obj.getActivitytypeId())));
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
		mapBodyData.put("value", "Update Activity Type");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "type.*"));
		list.add(buildSmartArr("Type ID", "numeric", "type.activitytypeId"));
		list.add(buildSmartArr("Name", "text", "type.activitytypeName"));
		list.add(buildSmartArr("Desc", "text", "type.activitytypeDesc"));
		list.add(buildSmartArr("Rank", "numeric", "type.activitytypeRank"));
		list.add(buildSmartArr("DueHrs", "numeric", "type.activitytypeDuehrs"));
		list.add(buildSmartArr("Trigger1", "numeric", "type.activitytypeTrigger1Hrs"));
		list.add(buildSmartArr("Trigger2", "numeric", "type.activitytypeTrigger2Hrs"));
		list.add(buildSmartArr("Trigger3", "numeric", "type.activitytypeTrigger3Hrs"));
		list.add(buildSmartArr("Trigger4", "numeric", "type.activitytypeTrigger4Hrs"));
		list.add(buildSmartArr("Trigger5", "numeric", "type.activitytypeTrigger5Hrs"));
		// list.add(buildSmartArr("Entry By", "text", "type.activitytypeEntryId in (select emp_id from compdb.axela_emp where emp_name"));
		list.add(buildSmartArr("Entry Date", "date", "type.activitytypeEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "type.activitytypeModifiedId in (select empId from compdb.axelaEmp where empName"));
		list.add(buildSmartArr("Modified Date", "date", "type.activitytypeModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

	public void moveUp(String activitytypeId) {
		output = new LinkedHashMap();
		int tempRank;
		int delstatusRank = 0;
		delstatusRank = activitytyperepository.findRankfromActivitytypeId(Integer.parseInt(activitytypeId));
		tempRank = activitytyperepository.findMinRank();
		if (tempRank != 0 && delstatusRank != 0) {
			if (delstatusRank != tempRank) {
				tempRank = delstatusRank - 1;
				int updateCount1 = portalFilterImpl.updatePriority(delstatusRank, tempRank, "AxelaActivityType type", "type.activitytypeRank");
				int updateCount2 = portalFilterImpl.updatePriorityById(delstatusRank, tempRank, "type.activitytypeId", Integer.parseInt(activitytypeId), "AxelaActivityType type",
						"type.activitytypeRank");
				output.put("msg", "Activity Type  moved up successfully!");
			}
		} else {
			output.put("errormsg", "not possible");
		}
	}

	public void moveDown(String activitytypeId) {
		output = new LinkedHashMap();
		int tempRank;
		int delstatusRank = 0;
		delstatusRank = activitytyperepository.findRankfromActivitytypeId(Integer.parseInt(activitytypeId));
		tempRank = activitytyperepository.findMaxRank();
		if (tempRank != 0 && delstatusRank != 0) {
			if (delstatusRank != tempRank) {
				tempRank = delstatusRank + 1;
				int updateCount1 = portalFilterImpl.updatePriority(delstatusRank, tempRank, "AxelaActivityType type", "type.activitytypeRank");
				int updateCount2 = portalFilterImpl.updatePriorityById(delstatusRank, tempRank, "type.activitytypeId", Integer.parseInt(activitytypeId), "AxelaActivityType type",
						"type.activitytypeRank");
				output.put("msg", "Activity Type moved Down successfully!");
			}
		} else {
			output.put("errormsg", "not possible");
		}
	}
}
