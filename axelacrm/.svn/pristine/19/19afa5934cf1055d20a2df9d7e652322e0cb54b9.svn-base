package axela.sales.service;

import java.sql.Connection;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.inventory.model.AxelaInventoryItemModel;
import axela.inventory.repository.InventoryItemModelRepository;
import axela.sales.model.AxelaSalesTarget;
import axela.sales.model.AxelaSalesTargetModel;
import axela.sales.repository.SalesTargetModalRepository;
import axela.sales.repository.SalesTargetModelFilterImpl;
import axela.sales.repository.SalesTargetRepository;
import axela.sales.repository.TargetFilterImpl;

@Service
public class SalesTargetService extends Connect {

	private int empId = 0;
	private JSONArray inputObj = null;
	private LinkedHashMap output = null;
	private String branchAccess = "";
	private String orderByField = "";
	private String exeAccess = "";
	private int page = 0;
	private String orderType = "";
	private String targetId = "0";
	private String perPage = "0";
	private String targetEmpId = "0";
	private String executiveId = "0";
	private String year = "";

	public String target_startdate = "";
	public String opprcount = "0";
	public String opprcall = "0";
	public String opprmeeting = "0";
	public String opprdemo = "0";
	public String opprhot = "0";
	public String opprso = "0";
	public String amt = "0";

	public int totalModeltargetOpprCount = 0;
	public int totalModeltargetOpprCallsCount = 0;
	public int totalModeltargetOpprMeetingsCount = 0;
	public int totalModeltargetOpprDemosCount = 0;
	public int totalModeltargetOpprHotCount = 0;
	public int totalModeltargetSoCount = 0;
	public int totalModeltargetSoAmount = 0;

	// model variable
	public String modeltargetOpprCount = "0";
	public String modeltargetModelId = "0";
	public String modeltargetOpprCallsCount = "0";
	public String modeltargetOpprMeetingsCount = "0";
	public String modeltargetOpprDemosCount = "0";
	public String modeltargetOpprHotCount = "0";
	public String modeltargetSoCount = "0";
	public String modeltargetSoAmount = "0";

	public int totalOpprCount = 0, totalOpprCallsCount = 0;
	public int totalOpprMeetingsCount = 0, totalOpprDemosCount = 0;
	public int totalOpprHotCount = 0, totalSoCount = 0;
	public int totalSoAmount = 0;
	public Connection conntx = null;
	public Statement stmttx = null;
	public String StrSearch = "";
	public String QueryString = "";
	public String month = "", monthName = "";
	public int modelCount = 0;
	public String targetmodelid = "";
	public String modelId[];
	public String modelName[];

	public String requestType = "";

	@Autowired
	SalesTargetModelFilterImpl salesTargetModelFilterImpl;

	@Autowired
	SalesTargetRepository salesTargetRepository;

	@Autowired
	TargetFilterImpl targetFilterImpl;

	@Autowired
	SalesTargetModalRepository salesTargetModalRepository;

	@Autowired
	InventoryItemModelRepository inventoryItemModelRepository;

	public Map targetService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		output = new LinkedHashMap<String, String>();
		inputObj = new JSONArray(input);

		if (AppRun().equals("0")) {
			SOP("inputObj" + inputObj.toString());
		}
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		if (empId != 0) {
			if (!inputObj.isNull(2)) {
				JSONObject requestObj = inputObj.getJSONObject(2);
				if (!requestObj.isNull("requestType")) {
					requestType = requestObj.getString("requestType");
				}
			}
			switch (requestType) {
				case "update" :// update an customer.
					List<Object[]> listAxelaInventoryItemModel = inventoryItemModelRepository.findModals();
					modelCount = listAxelaInventoryItemModel.size();
					int i = 0;
					modelId = new String[modelCount];
					modelName = new String[modelCount];
					for (Object[] axelaInventoryItemModel : listAxelaInventoryItemModel) {
						modelId[i] = PadQuotes(axelaInventoryItemModel[0] + "");
						modelName[i] = PadQuotes(axelaInventoryItemModel[1] + "");
						i++;
					}
					update(response, input, session);
					break;
			}
		}
		if (AppRun().equals("0")) {
			SOP("output" + output);
		}
		return output;
	}

	@Transactional
	void update(HttpServletResponse response, String input, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONArray(input);
		AxelaSalesTargetModel axelaSalesTargetModel = null;
		String StrSql = "";
		List<AxelaSalesTargetModel> listAxelaSalesTargetModel = new ArrayList<AxelaSalesTargetModel>();
		if (inputObj.length() != 0) {
			if (!inputObj.isNull(0)) {
				JSONObject obj1 = inputObj.getJSONObject(0);
				if (!obj1.isNull("executiveId")) {
					executiveId = obj1.getString("executiveId");
				}
				if (!obj1.isNull("targetId")) {
					targetId = obj1.getString("targetId");
				}
				if (!obj1.isNull("month")) {
					month = obj1.getString("month");
				}
				if (!obj1.isNull("year")) {
					year = obj1.getString("year");
				}
			}
			StrSql = "SELECT NEW AxelaSalesTarget(target.targetId)"
					+ " FROM AxelaSalesTarget target"
					+ " WHERE SUBSTRING(target.targetStartdate,1,7) = '" + year + "-" + doublenum(Integer.parseInt(month)) + "'"
					+ " AND SUBSTRING(target.targetEnddate,1,7) = '" + year + "-" + doublenum(Integer.parseInt(month)) + "'"
					+ " AND target.targetEmpId = " + executiveId;

			targetId = CNumeric(PadQuotes(targetFilterImpl.getTargetId(StrSql).getTargetId() + ""));
			if (!targetId.equals("0")) {
				salesTargetModalRepository.deleteByModeltargetTargetId(Integer.parseInt(targetId));
			} else {
				AddTargetFields(executiveId, year, month, session);
			}
			if (!inputObj.getJSONObject(1).equals("")) {
				JSONObject obj1 = inputObj.getJSONObject(1);
				for (int i = 0; i < modelCount; i++) {
					if (!obj1.isNull("modelId" + i)) {
						modeltargetModelId = CNumeric(obj1.getString("modelId" + i));
					}
					if (!obj1.isNull("opprCount" + i)) {
						modeltargetOpprCount = CNumeric(obj1.getString("opprCount" + i));
						totalModeltargetOpprCount += Integer.parseInt(modeltargetOpprCount);
					}
					if (!obj1.isNull("opprCalls" + i)) {
						modeltargetOpprCallsCount = CNumeric(obj1.getString("opprCalls" + i));
						totalModeltargetOpprCallsCount += Integer.parseInt(modeltargetOpprCallsCount);
					}
					if (!obj1.isNull("opprMeeting" + i)) {
						modeltargetOpprMeetingsCount = CNumeric(obj1.getString("opprMeeting" + i));
						totalModeltargetOpprMeetingsCount += Integer.parseInt(modeltargetOpprMeetingsCount);
					}
					if (!obj1.isNull("opprDemos" + i)) {
						modeltargetOpprDemosCount = CNumeric(obj1.getString("opprDemos" + i));
						totalModeltargetOpprDemosCount += Integer.parseInt(modeltargetOpprDemosCount);
					}
					if (!obj1.isNull("opprHot" + i)) {
						modeltargetOpprHotCount = CNumeric(obj1.getString("opprHot" + i));
						totalModeltargetOpprHotCount += Integer.parseInt(modeltargetOpprHotCount);
					}
					if (!obj1.isNull("opprSo" + i)) {
						modeltargetSoCount = CNumeric(obj1.getString("opprSo" + i));
						totalModeltargetSoCount += Integer.parseInt(modeltargetSoCount);
					}
					if (!obj1.isNull("opprSOAmount" + i)) {
						modeltargetSoAmount = CNumeric(obj1.getString("opprSOAmount" + i));
						totalModeltargetSoAmount += Integer.parseInt(modeltargetSoAmount);
					}
					axelaSalesTargetModel = new AxelaSalesTargetModel();
					axelaSalesTargetModel.setModeltargetTargetId(Integer.parseInt(targetId));
					axelaSalesTargetModel.setModeltargetModelId(Integer.parseInt(modeltargetModelId));
					axelaSalesTargetModel.setModeltargetOpprCount(Integer.parseInt(modeltargetOpprCount));
					axelaSalesTargetModel.setModeltargetOpprCallsCount(Integer.parseInt(modeltargetOpprCallsCount));
					axelaSalesTargetModel.setModeltargetOpprMeetingsCount(Integer.parseInt(modeltargetOpprMeetingsCount));
					axelaSalesTargetModel.setModeltargetOpprDemosCount(Integer.parseInt(modeltargetOpprDemosCount));
					axelaSalesTargetModel.setModeltargetOpprHotCount(Integer.parseInt(modeltargetOpprHotCount));
					axelaSalesTargetModel.setModeltargetSoCount(Integer.parseInt(modeltargetSoCount));
					axelaSalesTargetModel.setModeltargetSoAmount(Integer.parseInt(modeltargetSoAmount));
					listAxelaSalesTargetModel.add(axelaSalesTargetModel);
				}
			}
			salesTargetModalRepository.save(listAxelaSalesTargetModel);
			updateTarget();
			if (targetId.equals("0") && requestType.equals("update")) { // if id = 0 -> add mode else update mode
				output.put("successmsg", "Target Added Successfully!");
			} else {
				output.put("successmsg", "Target Updated Successfully!");
			}
		}
	}

	private void AddTargetFields(String executiveId, String year, String month, HttpSession session) throws ParseException {
		int day = DaysInMonth(Integer.parseInt(year), Integer.parseInt(month));
		AxelaSalesTarget axelaSalesTarget = new AxelaSalesTarget();
		axelaSalesTarget.setTargetEmpId(Integer.parseInt(executiveId));
		axelaSalesTarget.setTargetStartdate(stringToDate("01/" + Integer.parseInt(month) + "/" + year + " 00:00:00"));
		axelaSalesTarget.setTargetEnddate(stringToDate(day + "/" + Integer.parseInt(month) + "/" + year + " 00:00:00"));
		axelaSalesTarget.setTargetEntryId(empId);
		axelaSalesTarget.setTargetEntryDate(getTimeByZone(session));
		axelaSalesTarget.setTargetModifiedId(0);
		axelaSalesTarget.setTargetModifiedDate(stringToDate(""));
		salesTargetRepository.save(axelaSalesTarget);
		targetId = axelaSalesTarget.getTargetId() + "";
	}

	public void updateTarget() {
		AxelaSalesTarget axelaSalesTarget = new AxelaSalesTarget();
		axelaSalesTarget = salesTargetRepository.getOne(Integer.parseInt(targetId));
		axelaSalesTarget.setTargetOpprCount(totalModeltargetOpprCount);
		axelaSalesTarget.setTargetOpprCallsCount(totalModeltargetOpprCallsCount);
		axelaSalesTarget.setTargetOpprMeetingsCount(totalModeltargetOpprMeetingsCount);
		axelaSalesTarget.setTargetOpprDemosCount(totalModeltargetOpprDemosCount);
		axelaSalesTarget.setTargetOpprHotCount(totalModeltargetOpprHotCount);
		axelaSalesTarget.setTargetSoAmount(totalModeltargetSoAmount);
		axelaSalesTarget.setTargetSoCount(totalModeltargetSoCount);
		salesTargetRepository.save(axelaSalesTarget);
		targetId = axelaSalesTarget.getTargetId() + "";
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		int totalOpprCount = 0;
		int totalOpprCallsCount = 0;
		int totalOpprMeetingsCount = 0;
		int totalOpprDemosCount = 0;
		int totalOpprHotCount = 0;
		int totalSoCount = 0;
		double totalSoAmount = 0;
		page = 0;
		output = new LinkedHashMap();
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		JSONObject inputobj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("inputObj=======saas===SalesTargetService-list==========" + input);
		}
		ArrayList<HashMap<String, String>> actionList = new ArrayList<HashMap<String, String>>();
		output = new LinkedHashMap<String, String>();
		ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
		ArrayList<HashMap<String, String>> listdata = new ArrayList<HashMap<String, String>>();
		List<HashMap> listBody = new ArrayList<HashMap>();
		List<HashMap> listAction = new ArrayList<HashMap>();
		ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		PageRequest request = null;
		int targetId[];
		String targetStartdate[];
		String targetEnddate[];
		int targetOpprCount[];
		int targetOpprCallsCount[];
		int targetOpprMeetingsCount[];
		int targetOpprDemosCount[];
		int targetOpprHotCount[];
		int targetSoCount[];
		String targetSoAmount[];
		if (!inputobj.isNull("sortField")) {
			orderByField = PadQuotes((inputobj.getString("sortField")));
		}
		if (!inputobj.isNull("sortDirection")) {
			orderType = PadQuotes((inputobj.getString("sortDirection"))).toUpperCase();
		}
		if (!inputobj.isNull("executiveId")) {
			executiveId = CNumeric((inputobj.getString("executiveId")));
		}
		if (!inputobj.isNull("year")) {
			year = CNumeric((inputobj.getString("year")));
		}
		perPage = CNumeric(getSession("empRecperpage", session));
		if (orderType.equals("")) {
			orderType = "DESC";
		}
		if (orderByField.equals("")) {
			orderByField = "targetId";
		}
		if (perPage.equals("0")) {
			perPage = "25";
		}
		String strsearch = " AND a.targetEmpId =" + executiveId
				+ " AND SUBSTRING(a.targetStartdate, 1, 10) >= '" + year + "-01-01'"
				+ " AND SUBSTRING(a.targetEnddate, 1, 10)<= '" + year + "-12-31'"
				+ " ORDER BY a." + orderByField + " " + orderType + "";// , Integer.parseInt(page), Integer.parseInt(perPage)
		List<AxelaSalesTarget> resultSet = targetFilterImpl.findAll(strsearch);
		int length = targetFilterImpl.targetLength;
		Map<String, String> mapNavi = pageNavi(12, input, perPage);
		int count = 0;
		int ind = 0;
		int index = length;
		targetId = new int[index];
		targetStartdate = new String[index];
		targetEnddate = new String[index];
		targetOpprCount = new int[index];
		targetOpprCallsCount = new int[index];
		targetOpprMeetingsCount = new int[index];
		targetOpprDemosCount = new int[index];
		targetOpprHotCount = new int[index];
		targetSoCount = new int[index];
		targetSoAmount = new String[index];

		if (resultSet.size() != 0) {
			SOP("target-list" + resultSet.size());
			for (AxelaSalesTarget obj : resultSet) {
				targetId[ind] = obj.getTargetId();
				targetStartdate[ind] = strToShortDate((obj.getTargetStartdate()));
				targetEnddate[ind] = String.valueOf(obj.getTargetEnddate());
				targetOpprCount[ind] = obj.getTargetOpprCount();
				targetOpprCallsCount[ind] = obj.getTargetOpprCallsCount();
				targetOpprMeetingsCount[ind] = obj.getTargetOpprMeetingsCount();
				targetOpprDemosCount[ind] = obj.getTargetOpprDemosCount();
				targetOpprHotCount[ind] = obj.getTargetOpprHotCount();
				targetSoCount[ind] = obj.getTargetSoCount();
				targetSoAmount[ind] = obj.getTargetSoAmount() + "";
				ind++;
			}
			for (int i = 1; i <= 12; i++) {
				HashMap<String, String> map = new HashMap<String, String>();
				HashMap<String, String> action = new HashMap<String, String>();
				for (int j = 0; j < targetStartdate.length; j++) {
					action.put("executiveId", executiveId + "");
					action.put("year", year + "");
					action.put("month", i + "");
					HashMap<String, List<HashMap>> mapAction = new HashMap<String, List<HashMap>>();
					count = count + 1;
					map.put("#", count + "");
					StringBuilder dataString = new StringBuilder();
					dataString.append(textMonth(i - 1)).append("-").append(year);
					map.put("month", dataString.toString());
					if (targetId[j] != 0) {
						action.put("targetId", targetId[j] + "");
					} else {
						action.put("targetId", "0");
					}
					HashMap<String, List<HashMap>> mapData = new HashMap<String, List<HashMap>>();
					if (targetStartdate[j].equals("01/" + doublenum(i) + "/" + year)) {
						map.put("targetOpprCount", targetOpprCount[j] + "");
						map.put("targetOpprCallsCount", +targetOpprCallsCount[j] + "");
						map.put("targetOpprMeetingsCount", targetOpprMeetingsCount[j] + "");
						map.put("targetOpprDemosCount", targetOpprDemosCount[j] + "");
						map.put("targetOpprHotCount", targetOpprHotCount[j] + "");
						map.put("targetSoCount", targetSoCount[j] + "");
						map.put("targetSoAmount", targetSoAmount[j] + "");
						totalOpprCount += targetOpprCount[j];
						totalOpprCallsCount += targetOpprCallsCount[j];
						totalOpprMeetingsCount += targetOpprMeetingsCount[j];
						totalOpprDemosCount += targetOpprDemosCount[j];
						totalOpprHotCount += targetOpprHotCount[j];
						totalSoCount += targetSoCount[j];
						totalSoAmount += Double.parseDouble(targetSoAmount[j]);
						listdata.add(map);
						actionList.add(action);
					} else {
						SOP("targetOpprCount");
						map.put("targetOpprCount", 0 + "");
						map.put("targetOpprCallsCount", 0 + "");
						map.put("targetOpprMeetingsCount", 0 + "");
						map.put("targetOpprDemosCount", 0 + "");
						map.put("targetOpprHotCount", 0 + "");
						map.put("targetSoCount", 0 + "");
						map.put("targetSoAmount", 0 + "");
					}
				}
			}
			if (targetStartdate.length < 12) {
				for (int k = targetStartdate.length + 1; k <= 12; k++) {
					HashMap<String, String> map1 = new HashMap<String, String>();
					HashMap<String, String> action1 = new HashMap<String, String>();
					action1.put("targetId", 0 + "");
					action1.put("executiveId", executiveId + "");
					action1.put("year", year + "");
					action1.put("month", k + "");
					map1.put("#", count + "");
					StringBuilder dataString = new StringBuilder();
					dataString.append(textMonth(k - 1)).append("-").append(year);
					map1.put("month", dataString + "");
					map1.put("targetOpprCount", 0 + "");
					map1.put("targetOpprCallsCount", 0 + "");
					map1.put("targetOpprMeetingsCount", 0 + "");
					map1.put("targetOpprDemosCount", 0 + "");
					map1.put("targetOpprHotCount", 0 + "");
					map1.put("targetSoCount", 0 + "");
					map1.put("targetSoAmount", 0 + "");
					listdata.add(map1);
					actionList.add(action1);
				}
			}
		} else {
			for (int i = 1; i <= 12; i++) {
				HashMap<String, String> map = new HashMap<String, String>();
				HashMap<String, String> action = new HashMap<String, String>();
				action.put("targetId", 0 + "");
				action.put("executiveId", executiveId + "");
				action.put("year", year + "");
				action.put("month", i + "");
				map.put("#", count + "");
				StringBuilder dataString = new StringBuilder();
				dataString.append(textMonth(i - 1)).append("-").append(year);
				map.put("month", dataString + "");
				map.put("targetOpprCount", 0 + "");
				map.put("targetOpprCallsCount", 0 + "");
				map.put("targetOpprMeetingsCount", 0 + "");
				map.put("targetOpprDemosCount", 0 + "");
				map.put("targetOpprHotCount", 0 + "");
				map.put("targetSoCount", 0 + "");
				map.put("targetSoAmount", 0 + "");
				listdata.add(map);
				actionList.add(action);
			}
		}
		HashMap<String, String> map = new HashMap<String, String>();
		ArrayList<HashMap<String, String>> listDataCount = new ArrayList<HashMap<String, String>>();
		map.put("#", "");
		map.put("month", "Total:");
		map.put("totalOpprCount", totalOpprCount + "");
		map.put("totalOpprCallsCount", totalOpprCallsCount + "");
		map.put("totalOpprMeetingsCount", totalOpprMeetingsCount + "");
		map.put("totalOpprDemosCount", totalOpprDemosCount + "");
		map.put("totalOpprHotCount", totalOpprHotCount + "");
		map.put("totalSoCount", totalSoCount + "");
		map.put("totalSoAmount", totalSoAmount + "");
		listDataCount.add(map);
		output.put("targetList", listdata);
		output.put("targetCount", listDataCount);
		output.put("targetRouting", actionList);
		if (AppRun().equals("0")) {
			SOP("output==========SalesTargetService-list==========" + output.toString());
		}
		return output;
	}
	private ArrayList<HashMap> produceActionData(ArrayList<String> Param) {// , ArrayList<String> Param1, ArrayList<String> Param2) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Target");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map listModalData(String input, HttpSession session) throws JSONException {
		String StrSql = "", month = "";
		output = new LinkedHashMap<String, String>();
		JSONObject Obj = new JSONObject(input);
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		int i = 0, modelCount = 0;

		String tid[];
		String tmdlid[];
		String tsdate[];
		String tedate[];
		String topprcount[];
		String topprcall[];
		String topprmeeting[];
		String topprdemo[];
		String topprhot[];
		String topprso[];
		String topprsoamt[];
		List<Object[]> listAxelaInventoryItemModel = inventoryItemModelRepository.findModals();

		if (listAxelaInventoryItemModel.size() != 0) {
			modelCount = listAxelaInventoryItemModel.size();
			modelId = new String[modelCount];
			modelName = new String[modelCount];
			i = 0;
			for (Object[] axelaInventoryItemModel : listAxelaInventoryItemModel) {
				modelId[i] = axelaInventoryItemModel[0] + "";
				modelName[i] = axelaInventoryItemModel[1] + "";
				i++;
			}
			if (!Obj.isNull("year")) {
				year = PadQuotes((Obj.getString("year")));
			}
			if (!Obj.isNull("month")) {
				month = PadQuotes((Obj.getString("month")));
			}
			if (!Obj.isNull("executiveId")) {
				executiveId = CNumeric(PadQuotes((Obj.getString("executiveId"))));
			}
			if (!Obj.isNull("targetId")) {
				targetId = CNumeric(PadQuotes((Obj.getString("targetId"))));
			}
			int day = DaysInMonth(Integer.parseInt(year), Integer.parseInt(month));
			StrSql = " AND target.targetEmpId=" + executiveId + ""
					+ " AND SUBSTRING(target.targetStartdate, 1, 10) >= '" + year + "-" + doublenum(Integer.parseInt(month)) + "-" + "01'"
					+ " AND SUBSTRING(target.targetEnddate, 1, 10)<='" + year + "-" + doublenum(Integer.parseInt(month)) + "-" + day + "'";
			List<AxelaSalesTargetModel> listAxelaSalesTarget = salesTargetModelFilterImpl.findAll(StrSql);
			int ind = 0;
			int index = listAxelaSalesTarget.size();
			tid = new String[index];
			tmdlid = new String[index];
			tsdate = new String[index];
			tedate = new String[index];
			topprcount = new String[index];
			topprcall = new String[index];
			topprmeeting = new String[index];
			topprdemo = new String[index];
			topprhot = new String[index];
			topprso = new String[index];
			topprsoamt = new String[index];
			for (AxelaSalesTargetModel axelaSalesTargetModel : listAxelaSalesTarget) {
				tid[ind] = CNumeric(axelaSalesTargetModel.getModeltargetTargetId() + "");
				tmdlid[ind] = CNumeric(axelaSalesTargetModel.getModeltargetModelId() + "");
				tsdate[ind] = CNumeric(axelaSalesTargetModel.getTargetStartdate() + "");
				tedate[ind] = CNumeric(axelaSalesTargetModel.getTargetEnddate() + "");
				topprcount[ind] = CNumeric(axelaSalesTargetModel.getModeltargetOpprCount() + "");
				topprcall[ind] = CNumeric(axelaSalesTargetModel.getModeltargetOpprCallsCount() + "");
				topprmeeting[ind] = CNumeric(axelaSalesTargetModel.getModeltargetOpprMeetingsCount() + "");
				topprdemo[ind] = CNumeric(axelaSalesTargetModel.getModeltargetOpprDemosCount() + "");
				topprhot[ind] = CNumeric(axelaSalesTargetModel.getModeltargetOpprHotCount() + "");
				topprso[ind] = CNumeric(axelaSalesTargetModel.getModeltargetSoCount() + "");
				topprsoamt[ind] = CNumeric(axelaSalesTargetModel.getModeltargetSoAmount() + "");
				if (index != 1) {
					ind++;
				}
			}
			int count = 0;
			for (int k = 0; k < modelCount; k++) {
				count = count + 1;
				for (int j = 0; j < tmdlid.length; j++) {
					if (tmdlid[j].equals(modelId[k])) {
						targetmodelid = modelId[k];
						opprcount = topprcount[j];
						opprcall = topprcall[j];
						opprmeeting = topprmeeting[j];
						opprdemo = topprdemo[j];
						opprhot = topprhot[j];
						opprso = topprso[j];
						amt = topprsoamt[j];
						break;
					} else {
						targetmodelid = modelId[k];
						opprcount = "0";
						opprcall = "0";
						opprmeeting = "0";
						opprdemo = "0";
						opprhot = "0";
						opprso = "0";
						amt = "0";
					}
				}
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("count", count + "");
				map.put("modelId", modelId[k]);
				map.put("modelName", modelName[k]);
				map.put("opprCount", opprcount);
				map.put("opprCall", opprcall);
				map.put("opprMeeting", opprmeeting);
				map.put("opprDemo", opprdemo);
				map.put("opprHot", opprhot);
				map.put("opprSo", opprso);
				map.put("opprSOAmount", amt);
				list.add(map);
				totalOpprCount = totalOpprCount + Integer.parseInt(opprcount);
				totalOpprCallsCount = totalOpprCallsCount + Integer.parseInt(opprcall);
				totalOpprMeetingsCount = totalOpprMeetingsCount + Integer.parseInt(opprmeeting);
				totalOpprDemosCount = totalOpprDemosCount + Integer.parseInt(opprdemo);
				totalOpprHotCount = totalOpprHotCount + Integer.parseInt(opprhot);
				totalSoCount = totalSoCount + Integer.parseInt(opprso);
				totalSoAmount = totalSoAmount + (int) Double.parseDouble(amt);
			}
		}
		ArrayList<HashMap<String, String>> listTargetCount = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> totalCount = new HashMap<String, String>();
		ArrayList<String> headingList = new ArrayList<String>();
		totalCount.put("#", "");
		totalCount.put("model", "Total:");
		totalCount.put("totalOpprCount", totalOpprCount + "");
		totalCount.put("totalOpprCallsCount", totalOpprCallsCount + "");
		totalCount.put("totalOpprMeetingsCount", totalOpprMeetingsCount + "");
		totalCount.put("totalOpprDemosCount", totalOpprDemosCount + "");
		totalCount.put("totalOpprHotCount", totalOpprHotCount + "");
		totalCount.put("totalSoCount", totalSoCount + "");
		totalCount.put("totalSoAmount", totalSoAmount + "");
		listTargetCount.add(totalCount);
		HashMap<String, ArrayList<String>> heading = new HashMap<String, ArrayList<String>>();
		headingList.add("#");
		headingList.add("Model");
		headingList.add("Oppr Count");
		headingList.add("Oppr Calls");
		headingList.add("Oppr Meeting");
		headingList.add("Oppr Demos");
		headingList.add("Oppr Hot");
		headingList.add("Oppr SO");
		headingList.add("Oppr SO Amount");
		output.put("heading", headingList);
		output.put("targetPopulate", list);
		output.put("targetCount", totalCount);
		return output;
	}
}
