package axela.sales.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.portal.model.AxelaSoe;
import axela.portal.repository.CompRepository;
import axela.sales.repository.SalesOpprStageRepository;
import axela.sales.repository.SalesOpprStatusRepository;
import axela.sales.repository.SalesSOEImplFilter;

@Service
public class ReportSOEDashService extends Connect {

	Map output = null;
	JSONObject inputObj = null;
	int empId = 0;
	private int branchId = 0;
	private String branchAccess = "";
	private String ExeAccess = "";
	private String empAllExe = "";
	private String msg = "";
	private String startDate = "";
	private String endDate = "";

	public String branchName = "";
	private String franchiseeIds = "";
	private String exeIds = "";
	private String teamIds = "";
	private String modelIds = "";
	private String branchIds = "";
	private String requestType = "";
	String strSearch = "";

	@Autowired
	public SalesOpprStageRepository salesOpprStageRepository;

	@Autowired
	public SalesSOEImplFilter salesSOEImplFilter;

	@Autowired
	public SalesOpprStatusRepository salesOpprStatusRepository;

	@Autowired
	public CompRepository compRepository;

	public Map opprServiceUpdate(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("inputObj==========OpprDashService==========" + inputObj.toString(1));
		}
		strSearch = "";
		requestType = "";
		int franchiseeCount = 0;
		output = new HashMap();
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		// if (empId != 0) {
		if (!inputObj.isNull("requestType")) {
			requestType = PadQuotes(inputObj.getString("requestType"));
		}
		if (requestType.equals("count")) {
			output.put("branchCount", getSession("branchCount", session));
			output.put("franchiseeCount", getSession("franchiseeCount", session));
		} else {
			branchId = Integer.parseInt(CNumeric(getSession("branchId", session)));
			branchAccess = PadQuotes(getSession("BranchAccess", session));
			ExeAccess = PadQuotes(getSession("ExeAccess", session));
			empAllExe = PadQuotes(getSession("empAllExe", session));
			getValues();
			validateFollowUp();
			if (msg.equals("")) {
				if (!startDate.equals("")) {
					strSearch += " AND SUBSTRING(oppr.opprDate, 1, 8) >= SUBSTRING('" + dateToString(stringToDate(startDate)) + "', 1, 10)";
				}
				if (!endDate.equals("")) {
					strSearch += " AND SUBSTRING(oppr.opprDate, 1, 8) <= SUBSTRING('" + dateToString(stringToDate(endDate)) + "', 1, 10)";
				}
				if (!franchiseeIds.equals("")) {
					strSearch += " AND branch.branchFranchiseeId IN (" + franchiseeIds + ")";
				}
				if (!branchIds.equals("")) {
					strSearch += " AND branch.branchId IN (" + branchIds + ")";
				}
				if (!teamIds.equals("")) {
					strSearch += " AND team.teamId IN (" + teamIds + ")";
				}
				if (!exeIds.equals("")) {
					strSearch += " AND oppr.opprEmpId IN (" + exeIds + ")";
				}
				if (!modelIds.equals("")) {
					strSearch += " AND oppr.opprModelId IN (" + modelIds + ")";
				}
				opprSummary();
				preparePieChart();
				opprCloseSummary();
			} else {
				output.put("errormsg", msg);
			}

			// }
		}
		return output;
	}

	public String jsonArrayToString(JSONArray jsonarray) throws JSONException {
		StringBuilder str = new StringBuilder();
		if (jsonarray.length() > 1) {
			str.append(jsonarray.getInt(0));
			SOP("jsonarray.length()" + jsonarray.length());
			for (int i = 1; i < jsonarray.length(); i++) {
				str.append(",").append(jsonarray.getInt(i));
			}
		} else if (jsonarray.length() == 1) {
			str.append(jsonarray.getInt(0));
		}
		return str.toString();
	}
	public void getValues() throws JSONException {
		if (!inputObj.isNull("startDate")) {
			startDate = PadQuotes(inputObj.getString("startDate"));
		}
		if (!inputObj.isNull("endDate")) {
			endDate = PadQuotes(inputObj.getString("endDate"));
		}
		if (!inputObj.isNull("franchiseeIds")) {
			if (inputObj.get("franchiseeIds") instanceof JSONArray)
				franchiseeIds = jsonArrayToString(inputObj.getJSONArray("franchiseeIds"));
		}
		if (!inputObj.isNull("exeIds")) {
			if (inputObj.get("exeIds") instanceof JSONArray)
				exeIds = jsonArrayToString(inputObj.getJSONArray("exeIds"));
		}
		if (!inputObj.isNull("teamIds")) {
			if (inputObj.get("teamIds") instanceof JSONArray)
				teamIds = jsonArrayToString(inputObj.getJSONArray("teamIds"));
		}
		if (!inputObj.isNull("modelIds")) {
			if (inputObj.get("modelIds") instanceof JSONArray)
				modelIds = jsonArrayToString(inputObj.getJSONArray("modelIds"));
		}
		if (!inputObj.isNull("branchIds")) {
			if (inputObj.get("branchIds") instanceof JSONArray)
				branchIds = jsonArrayToString(inputObj.getJSONArray("branchIds"));
		}
	}

	public void validateFollowUp() throws ParseException {
		msg = "";
		if (startDate.equals("")) {
			msg = msg + " Select Start Date!";
		}
		if (endDate.equals("")) {
			msg = msg + " Select End Date!";
		}
		if (!endDate.equals("")) {
			if (!startDate.equals("") && !endDate.equals("") && (stringToDate(startDate).compareTo(stringToDate(endDate)) > 0)) {
				msg = msg + " Start Date should be less than End date!";
			}
		}

	}

	public void opprSummary() {
		List<String> result = salesOpprStageRepository.findStageName();
		StringBuilder strStage = new StringBuilder();
		StringBuilder strStatus = new StringBuilder();
		String coloumName = null;
		int i = 0;
		coloumName = " SOE ,";
		for (String obj : result) {
			coloumName += obj + ",";
			strStage.append(" COALESCE (SUM(CASE WHEN stage.stageName = '").append(obj).append("' THEN  1 ELSE 0 END), 0) , ");
		}
		result = salesOpprStatusRepository.findStatusName();
		for (String obj : result) {
			coloumName += obj + ",";
			strStatus.append(" COALESCE (SUM(CASE WHEN opprstatus.statusName = '").append(obj).append("' THEN 1 ELSE 0 END), 0) , ");
		}
		String coloum[] = coloumName.split(",");
		List<Object[]> resultEnquirySummary = salesSOEImplFilter.SoeDashEnquirySummary(strStage.toString(), strStatus.toString(), strSearch);
		List list = new ArrayList();
		for (int j = 0; j <= coloum.length - 1; j++) {
			list.add(coloum[j]);
		}
		output.put("OpprSummaryHeader", ((ArrayList) list).clone());
		Map map = new LinkedHashMap();
		list = new ArrayList();
		for (Object[] obj : resultEnquirySummary) {
			List opprList = new ArrayList();
			for (int j = 0; j <= coloum.length - 1; j++) {
				// map.put(coloum[j], obj[j]);
				opprList.add(obj[j]);
			}
			map.put("td", opprList);
			list.add(map);
		}
		output.put("opprSummary", list);
	}

	private void opprCloseSummary() {
		List<String> result = salesOpprStageRepository.findStageName();
		StringBuilder strStage = new StringBuilder();
		StringBuilder strStatus = new StringBuilder();
		String coloumName = null;
		int i = 0;
		coloumName = " SOE ,";
		for (String obj : result) {
			coloumName += obj + ",";
			strStage.append(" COALESCE (SUM(CASE WHEN stage.stageName = '").append(obj).append("' THEN  1 ELSE 0 END), 0) , ");
		}
		result = salesOpprStatusRepository.findStatus();
		for (String obj : result) {
			coloumName += obj + ",";
			strStatus.append(" COALESCE (SUM(CASE WHEN opprstatus.statusName = '").append(obj).append("' THEN 1 ELSE 0 END), 0) , ");
		}
		strSearch += " AND opprstatus.statusId > 2";
		List<Object[]> opprCloseSummary = salesSOEImplFilter.SoeDashEnquirySummary(strStage.toString(), strStatus.toString(), strSearch);
		String coloum[] = coloumName.split(",");
		List list = new ArrayList();
		for (int j = 0; j <= coloum.length - 1; j++) {
			list.add(coloum[j]);
		}
		output.put("opprCloseSummaryHeader", ((ArrayList) list).clone());
		Map map = new LinkedHashMap();
		list = new ArrayList();
		for (Object[] obj : opprCloseSummary) {
			List opprList = new ArrayList();
			for (int j = 0; j <= coloum.length - 1; j++) {
				// map.put(coloum[j], obj[j]);
				opprList.add(obj[j]);
			}
			map.put("td", opprList);
			list.add(map);
		}
		output.put("opprCloseSummary", list);
	}

	private void preparePieChart() {
		Long total = 0l;
		List list = new ArrayList();
		List<AxelaSoe> result = salesSOEImplFilter.SoeDashPieChart(strSearch);
		for (AxelaSoe axelaSoe : result) {
			Map map = new HashMap();
			map.put("title", axelaSoe.getSoeName());
			total += axelaSoe.getTotal();
			map.put("value", axelaSoe.getTotal());
			list.add(map);
		}
		output.put("total", total);
		output.put("data", list);
	}

}
