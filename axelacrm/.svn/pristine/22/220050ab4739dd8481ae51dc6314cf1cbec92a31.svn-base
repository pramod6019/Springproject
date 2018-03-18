package axela.pm.service;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
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
import axela.pm.model.AxelaPm;
import axela.pm.model.AxelaPmExe;
import axela.pm.repository.PmExeRepository;
import axela.portal.model.AxelaConfig;
import axela.portal.repository.ConfigRepository;
import axela.portal.repository.PmRepository;
@Service
public class PmService extends Connect
{
	@Autowired
	public PmRepository pmRepository;

	@Autowired
	public ConfigRepository axelaConfigRepository;

	@Autowired
	public PmExeRepository pmexerepository;

	public int pmId = 0;
	public String customerId = "0";
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
	public String pmActive = "";
	public String pmBudget = "0";
	public String pmComplete = "";
	public String pmCompleteComments = "";
	public String pmCompletePerc = "0";
	public String pmCustomerId = "0";
	public String pmPmstatusId = "0";
	public String pmEndDate = "";
	public String pmExpense = "0";
	public String pmNotes = "";
	public String pmStartDate = "";
	public String pmPmtypeId = "0";
	public String pmTitle = "";
	public JSONArray pmexeEmpIds = new JSONArray();
	public String configCustomerName = "";
	HashMap output = null;
	JSONObject inputObj = null;

	public Map pmService(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		SOP("paaaaaa");
		inputObj = new JSONObject(input);
		output = new HashMap();
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		perPage = getSession("perPage", session);
		perPage = CNumeric(getSession("empRecperpage", session));
		if (empId != 0) {
			List<AxelaConfig> axelaConfig = axelaConfigRepository.findAll();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map = new HashMap<String, String>();
			for (AxelaConfig config : axelaConfig) {
				configCustomerName = config.getConfigCustomerName();

			}
			SOP("paaaaaa1111111");

			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}

			switch (requestType) {
				case "add" :
					pmId = 0;
					SOP("paaaaaa22222");
					getValues(inputObj);
					addFields(response, request);
					break;

				case "update" :
					pmId = 0;
					getValues(inputObj);
					addFields(response, request);
					break;

				case "delete" :
					if (!inputObj.isNull("pmId")) {
						pmId = Integer.parseInt(inputObj.getString("pmId"));
					}
					if (pmId != 0) {
						deleteFields(pmId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("customerId")) {
			customerId = CNumeric(inputObj.getString("customerId"));
		}
		if (!inputObj.isNull("pmTitle")) {
			pmTitle = PadQuotes(inputObj.getString("pmTitle"));
		}
		if (!inputObj.isNull("pmPmtypeId")) {
			pmPmtypeId = CNumeric(inputObj.getString("pmPmtypeId"));
		}
		if (!inputObj.isNull("pmPmstatusId")) {
			pmPmstatusId = CNumeric(inputObj.getString("pmPmstatusId"));
		}
		if (!inputObj.isNull("pmBudget")) {
			pmBudget = PadQuotes(inputObj.getString("pmBudget"));
		}
		if (!inputObj.isNull("pmStartDate")) {
			pmStartDate = PadQuotes(inputObj.getString("pmStartDate"));
		}
		if (!inputObj.isNull("pmEndDate")) {
			pmEndDate = PadQuotes(inputObj.getString("pmEndDate"));
		}
		// if (!inputObj.isNull("pmexeEmpIds")) {
		// if (inputObj.get("branchIds") instanceof JSONArray)
		// pmexeEmpIds = jsonArrayToString(inputObj.getJSONArray("pmexeEmpIds"));
		// }
		if (!inputObj.isNull("pmexeEmpIds")) {
			if (inputObj.get("pmexeEmpIds") instanceof JSONArray)
				pmexeEmpIds = inputObj.getJSONArray("pmexeEmpIds");
		}

		if (!inputObj.isNull("pmComplete")) {
			pmComplete = PadQuotes(inputObj.getString("pmComplete"));
		}
		if (!inputObj.isNull("pmActive")) {
			pmActive = PadQuotes(inputObj.getString("pmActive"));
		}
		if (!inputObj.isNull("pmCompleteComments")) {
			pmCompleteComments = PadQuotes(inputObj.getString("pmCompleteComments"));
		}
		if (!inputObj.isNull("pmNotes")) {
			pmNotes = PadQuotes(inputObj.getString("pmNotes"));
		}
	}

	public void validateFields() {
		msg = "";
		if (pmTitle.equals("")) {
			msg += "<br>Enter Project Title!";
		}

		if (customerId.equals("0")) {
			customerId = pmCustomerId;
		}

		if (customerId.equals("") || customerId.equals("0")) {
			msg += "<br>Select " + configCustomerName + "!";
		}

		if (pmPmtypeId.equals("0")) {
			msg += "<br>Select Type!";
		}

		if (pmBudget.equals("")) {
			msg += "<br>Enter Budget!";
		}

		if (pmStartDate.equals("")) {
			msg += "<br>Select Start Date!";
		}
		// else {
		// if (isValidDateFormatShort(pmStartDate)) {
		// pmStartDate = pmStartDate;
		// } else {
		// msg += "<br>Enter Valid start Date!";
		// }
		// }

		if (pmEndDate.equals("")) {
			msg += "<br>Select Deadline!";
		}
		// else {
		// if (isValidDateFormatShort(pmEndDate)) {
		// pmEndDate = pmEndDate;
		// } else {
		// msg += "<br>Enter Valid Deadline!";
		// }
		// }

		// if (!pmStartDate.equals("") && !pmEndDate.equals("") && isValidDateFormat(pmStartDate, empFormatdate) && isValidDateFormat(pmenddate, emp_formatdate)) {
		// if (Long.parseLong(formatDateStr(pmstartdate, emp_formatdate)) > Long.parseLong(FormatDateStr(pmenddate, emp_formatdate))) {
		// msg += "<br>Start Date should be less than Deadline!";
		// } else {
		// if (update.equals("yes") && updateB.equals("yes")) {
		// StrSql = "SELECT task_id"
		// + " FROM " + compdb(comp_id) + "axela_pm_task"
		// + " WHERE task_pm_id = " + pm_id + "";
		// if (!ExecuteQuery(StrSql).equals("")) {
		// StrSql = "SELECT MIN(task_start_date) AS task_start_date"
		// + " FROM " + compdb(comp_id) + "axela_pm_task"
		// + " WHERE task_pm_id = " + pm_id + "";
		// task_start_date = ExecuteQuery(StrSql);
		//
		// StrSql = "SELECT MAX(task_end_date) AS task_end_date"
		// + " FROM " + compdb(comp_id) + "axela_pm_task"
		// + " WHERE task_pm_id = " + pm_id + "";
		// task_end_date = ExecuteQuery(StrSql);
		//
		// if (!task_start_date.equals("") && isValidDateFormat(FormatDate(task_start_date, emp_formatdate), emp_formatdate)) {
		// if (Long.parseLong((task_start_date)) < Long.parseLong(FormatDateStr(pmstartdate, emp_formatdate))) {
		// msg += "<br>Project Start Date Should be less than Task Start Date: " + FormatDate(task_start_date, emp_formatdate) + "!";
		// }
		// }
		//
		// if (!task_end_date.equals("") && isValidDateFormat(FormatDate(task_end_date, emp_formatdate), emp_formatdate)) {
		// if (Long.parseLong((task_end_date)) > Long.parseLong(FormatDateStr(pmenddate, emp_formatdate))) {
		// msg += "<br>Project Deadline should be greater than Task Deadline: " + FormatDate(task_end_date, emp_formatdate) + "!";
		// }
		// }
		// }
		// }
		// }
		// }

		if (pmPmstatusId.equals("0")) {
			msg += "<br>Select Status!";
		}

		int count = 0, task_complete_perc_sum = 0;
		// StrSql = "SELECT task_complete_perc"
		// + " FROM " + compdb(comp_id) + "axela_pm_task"
		// + "  WHERE task_pm_id = " + pm_id;
		// SOP("StrSql task completed==" + StrSql);
		// CachedRowSet crs = processQuery(StrSql, 0);
		String pm_completed = "0";
		// if (crs.isBeforeFirst()) {
		// while (crs.next()) {
		// task_complete_perc_sum += Integer.parseInt(crs.getString("task_complete_perc"));
		// count++;
		// }
		// pm_completed = task_complete_perc_sum / count + "";
		// }
		// else {
		// pm_completed = "0";
		// }
		if (pmPmstatusId.equals("5") && !pmComplete.equals("1")) {
			if (pm_completed.equals("100")) {
				msg += "<br> Complete should be checked !";
			}
			else {
				msg += "<br>Project cannot be Finished.Pending Tasks are found for this Project!";
			}
		}
		// else if (pmComplete.equals("1") && !pmPmstatusId.equals("5")) {
		// if (pm_completed.equals("100")) {
		// msg += "<br> Project status should be finished!";
		// }
		// else {
		// msg += "<br>Project cannot be Complete.Pending Tasks are found for this Project!";
		// }
		//
		// }
		// else if (pmComplete.equals("1") && pmPmstatusId.equals("5")) {
		// if (!pm_completed.equals("100")) {
		// msg += "<br>Project Status cannot be finished.Pending Tasks are found for this Project!";
		// }
		// }

		if (pmCompleteComments.length() > 8000) {
			pmCompleteComments = pmCompleteComments.substring(0, 7999);
		}
	}

	public void addFields(HttpServletResponse response, HttpServletRequest request) throws JSONException, ParseException {
		validateFields();
		output = new HashMap();
		AxelaPm axelaPm = null;
		if (msg.equals("")) {
			if (pmId == 0) {
				axelaPm = new AxelaPm();
			} else {
				axelaPm = pmRepository.findByPmId(pmId);
			}
			axelaPm.setPmId(pmId);
			axelaPm.setPmActive(pmActive);
			BigInteger budget = new BigInteger(pmBudget);
			axelaPm.setPmBudget(budget);
			axelaPm.setPmComplete(pmComplete);
			axelaPm.setPmCompleteComments(pmCompleteComments);
			axelaPm.setPmCompletePerc(Integer.parseInt(pmCompletePerc));
			axelaPm.setPmCustomerId(Integer.parseInt(pmCustomerId));
			axelaPm.setPmEndDate(stringToDate(pmEndDate));
			BigInteger expense = new BigInteger(pmExpense);
			axelaPm.setPmExpense(expense);
			axelaPm.setPmNotes(pmNotes);
			axelaPm.setPmPmstatusId(Integer.parseInt(pmPmstatusId));
			axelaPm.setPmPmtypeId(Integer.parseInt(pmPmtypeId));
			axelaPm.setPmStartDate(stringToDate(pmStartDate));
			axelaPm.setPmTitle(pmTitle);

			if (requestType.equals("add")) {
				axelaPm.setPmEntryId(empId);
				axelaPm.setPmEntryDate(kknow());
			} else if (requestType.equals("update")) {
				axelaPm.setPmModifiedId(empId);
				axelaPm.setPmModifiedDate(kknow());
			}
			pmId = pmRepository.save(axelaPm).getPmId();
			SOP("pmId=111111111111111111==" + pmId);
			if (pmexeEmpIds.length() > 0) {
				SOP("asasaasas");
				for (int i = 0; i < pmexeEmpIds.length(); i++) {
					AxelaPmExe axelapmexe = new AxelaPmExe();
					axelapmexe.setPmexePmId(pmId);
					axelapmexe.setPmexeId(empId);
					axelapmexe.setPmexeEmpId(Integer.valueOf(pmexeEmpIds.get(i) + ""));
					pmexerepository.save(axelapmexe);
				}
			}
			if (pmId != 0 && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("successmsg", "Project Added Successfully!");
				output.put("pmId", pmId + "");
			} else if (pmId != 0 && requestType.equals("update")) {
				output.put("successmsg", "Project Updated Successfully!");
				output.put("pmId", pmId + "");
			}

		}
		else {
			// response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(int pmId) {
		pmRepository.delete(pmId);
		output.put("successmsg", "Project Deleted Successfully!");
	}

}
