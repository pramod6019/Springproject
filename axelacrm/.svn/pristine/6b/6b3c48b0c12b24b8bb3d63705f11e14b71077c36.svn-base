package axela.service.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.portal.repository.CompRepository;
import axela.service.model.AxelaServiceJc;
import axela.service.repository.ServiceJcFilterImpl;

@Service
public class ReportJobCardProductivityService extends Connect {

	@Autowired
	CompRepository compRepository;

	@Autowired
	ServiceJcFilterImpl serviceJcFilterImpl;

	public static String msg = "";
	public String startDate = "";
	public String endDate = "";
	public String startTime = "";
	public String endTime = "";
	public String empId = "0", compId = "0", branchId = "0";
	public String teamIds = "", exeIds = "", modelIds = "", psfdaysIds = "", drBranchIds = "";
	public String teamId = "0", exeId = "0", modelId = "0";
	public String strHTML = "", strClosedHTML = "", strSearch = "";
	public String branchAccess = "", drBranchId = "0";
	public String enquirySearch = "";
	public String exeAccess = "";
	public String chartData = "";
	public String perPage = "0";
	public int chartDataTotal = 0;
	public String noChart = "";
	public int totalRecords = 0;
	public String strSql = "";
	public String teamJoin = "";
	public String jcCatId = "0";
	public JSONObject inputObj = null;
	public String requestType = "";
	public Map output = new HashMap();
	public String jcCatIds = "";
	// public String crmfollowupdays_id = "";
	public String psfdaysId = "0";
	public String empAllExe = "";
	public String jcStatusIds = "";
	public String jcStatusId = "0";
	public String jcTypeIds = "";
	public String jcTypeId = "0";
	public String franchiseeId = "0";
	public String franchiseeIds = "";
	public String compFranchiseeCount = "", compBranchCount = "";
	public String branchIds = "";

	public Map reportJobCardProductivityDash(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("inputObj========ticketService==========" + inputObj.toString(1));
		}
		strSearch = "";
		requestType = "";
		branchAccess = PadQuotes(getSession("branchAccess", session)).replaceAll("branchId", "branch.customerBranchId");
		exeAccess = PadQuotes(getSession("exeAccess", session)).replaceAll("empId", "customer.customerEmpId");
		empId = CNumeric(PadQuotes(getSession("empId", session)));
		compId = CNumeric(PadQuotes(getSession("compId", session)));
		if (!empId.equals("0")) {
			if (!returnPerm("emp_mis_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			branchId = CNumeric(getSession("empBranchId", session));
			branchAccess = getSession("BranchAccess", session);
			exeAccess = getSession("ExeAccess", session);
			empAllExe = CNumeric(getSession("emp_all_exe", session));

			compFranchiseeCount = String.valueOf(compRepository.findByFranchiseeCount());
			compBranchCount = String.valueOf(compRepository.findByBranchCount());
			getValues(inputObj);
			validateFields();
			if (msg.equals("")) {
				if (!jcStatusId.equals("0")) {
					strSearch += " AND jc.jcJcstatusId IN (" + jcStatusId + ")";
				}

				if (!franchiseeId.equals("0")) {
					strSearch = strSearch + " AND jc.axelaBranch.branchFranchiseeId IN (" + franchiseeIds + ")";
				}

				if (!jcTypeId.equals("0")) {
					strSearch += " AND jc.jcJctypeId IN (" + jcTypeId + ")";
				}

				if (!drBranchId.equals("0")) {
					strSearch += " AND jc.axelaBranch.branchId IN (" + drBranchId + ")";
				}

				if (!jcCatId.equals("0")) {
					strSearch += " AND jc.jcJccatId IN (" + jcCatId + ")";
				}
				if (!startDate.equals("") && !endDate.equals("")) {
					strSearch = strSearch + " AND ( jc.jcTimeIn >= substr('" + startDate + "',1,10) "
							+ " OR jc.jcTimeIn <= substr('" + endDate + "',1,10))";
				}
				ListJobCardExecutive(strSearch);
				TechnicianDetails(strSearch);
			} else {
				output.put("errormsg", msg);
			}
		}
		if (AppRun().equals("0")) {
			SOP("inputObj========ticketService==========" + output);
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException, ParseException {
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

		if (!inputObj.isNull("branchIds")) {
			if (inputObj.get("branchIds") instanceof JSONArray)
				branchIds = jsonArrayToString(inputObj.getJSONArray("branchIds"));
		}

		if (!inputObj.isNull("jcStatusIds")) {
			if (inputObj.get("jcStatusIds") instanceof JSONArray)
				jcStatusIds = jsonArrayToString(inputObj.getJSONArray("jcStatusIds"));
		}

		if (!inputObj.isNull("jcTypeIds")) {
			if (inputObj.get("jcTypeIds") instanceof JSONArray)
				jcTypeIds = jsonArrayToString(inputObj.getJSONArray("jcTypeIds"));
		}

		if (!inputObj.isNull("jcCatIds")) {
			if (inputObj.get("jcCatIds") instanceof JSONArray)
				jcCatIds = jsonArrayToString(inputObj.getJSONArray("jcCatIds"));
		}
	}

	public void validateFields() throws ParseException {
		msg = "";
		if (startDate.equals("")) {
			msg = msg + "Select Start Date!";
		}
		if (!startDate.equals("")) {
			if (!isValidDateFormatShort(startDate)) {
				msg = msg + "Enter Valid Start Date!";
				startDate = "";
			}
		}
		if (endDate.equals("")) {
			msg = msg + "Select End Date!";
		}
		if (!endDate.equals("")) {
			if (isValidDateFormatShort(endDate)) {
				if (!startDate.equals("") && !endDate.equals("")) {
					if (stringToDate(startDate).after(stringToDate(endDate))) {
						msg = msg + "Start Date should be less than End date!";
					}
				}
			} else {
				msg = msg + "Enter Valid End Date!";
				endDate = "";
			}
		}
	}

	public Map ListJobCardExecutive(String strSearch) throws JSONException {
		List list = new ArrayList();
		int count = 0;
		List<AxelaServiceJc> jc = serviceJcFilterImpl.findAllJobCardExecutiveReport(strSearch, String.valueOf(franchiseeIds));
		for (AxelaServiceJc axelaServiceJc : jc) {
			count++;
			Map map = new HashMap();
			map.put("count", count);
			map.put("empId", axelaServiceJc.getEmpId());
			map.put("empName", axelaServiceJc.getEmpName());
			map.put("jcCount", axelaServiceJc.getJcCount());
			map.put("jcTotal", axelaServiceJc.getJcTotal());
			list.add(map);
		}
		output.put("listJobCardExecutive", list);
		return output;
	}

	public Map TechnicianDetails(String strSearch) throws JSONException {
		List list = new ArrayList();
		int count = 0;
		List<AxelaServiceJc> jc = serviceJcFilterImpl.findAllTechnicianDetailsReport(strSearch, String.valueOf(franchiseeIds));
		for (AxelaServiceJc axelaServiceJc : jc) {
			count++;
			Map map = new HashMap();
			map.put("count", count);
			map.put("empId", axelaServiceJc.getEmpId());
			map.put("empName", axelaServiceJc.getEmpName());
			map.put("jcCount", axelaServiceJc.getJcCount());
			map.put("jcTotal", axelaServiceJc.getJcTotal());
			list.add(map);
		}
		output.put("technicianDetails", list);
		return output;
	}

	public String compableDateToString(String date) {
		String data = "";
		String[] arr = date.split("/");
		for (int i = arr.length - 1; i >= 0; i--) {
			data += arr[i];
		}
		return data + "000000";
	}

	public String jsonArrayToString(JSONArray jsonarray) throws JSONException {
		StringBuilder str = new StringBuilder();
		if (jsonarray.length() > 1) {
			str.append(jsonarray.getInt(0));
			for (int i = 1; i < jsonarray.length(); i++) {
				str.append(",").append(jsonarray.getInt(i));
			}
		} else if (jsonarray.length() == 1) {
			str.append(jsonarray.getInt(0));
		}
		return str.toString();
	}
}
