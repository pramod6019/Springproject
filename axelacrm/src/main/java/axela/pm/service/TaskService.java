package axela.pm.service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.pm.model.AxelaPmTask;
import axela.pm.repository.TaskRepository;
import axela.portal.repository.ConfigRepository;
@Service
public class TaskService extends Connect
{
	@Autowired
	public TaskRepository taskRepository;

	@Autowired
	public ConfigRepository axelaConfigRepository;

	public int taskId = 0;
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
	public String taskEndDate = "";
	public String taskBudget = "0";
	public String taskCompletionDate = "";
	public String taskPmmilestoneId = "0";
	public String taskCompletePerc = "0";
	public String taskExpense = "0";
	public String pmCustomerId = "0";
	public String pmPmstatusId = "0";
	public String taskTaskstatusId = "0";
	public String pmId = "0";
	public String pmEndDate = "";
	public String taskSubject = "";
	public String pmExpense = "0";
	public String pmNotes = "";
	public String pmStartDate = "";
	public String pmPmtypeId = "0";
	public String taskParentId = "0";
	public String taskEmpId = "0";
	public String taskPrioritytaskId = "0";
	public String pmTitle = "";
	public String configCustomerName = "";
	public String taskStartDate = "";
	public String taskActive = "";
	public String task_completion_date = "";
	public String taskNotes = "";
	HashMap output = null;
	JSONObject inputObj = null;

	public Map taskService(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		SOP("paaaaaa");
		inputObj = new JSONObject(input);
		output = new HashMap();
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		perPage = getSession("perPage", session);
		perPage = CNumeric(getSession("empRecperpage", session));
		if (empId != 0) {
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}

			switch (requestType) {
				case "add" :
					taskId = 0;
					SOP("paaaaaa22222");
					getValues(inputObj);
					addFields(response, request);
					break;

				case "update" :
					taskId = 0;
					getValues(inputObj);
					addFields(response, request);
					break;

				case "delete" :
					if (!inputObj.isNull("taskId")) {
						taskId = Integer.parseInt(inputObj.getString("taskId"));
					}
					if (taskId != 0) {
						deleteFields(taskId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("taskPmmilestoneId")) {
			taskPmmilestoneId = CNumeric(inputObj.getString("taskPmmilestoneId"));
		}
		if (!inputObj.isNull("taskSubject")) {
			taskSubject = PadQuotes(inputObj.getString("taskSubject"));
		}
		if (!inputObj.isNull("taskTaskstatusId")) {
			taskTaskstatusId = CNumeric(inputObj.getString("taskTaskstatusId"));
		}
		if (!inputObj.isNull("taskEmpId")) {
			taskEmpId = CNumeric(inputObj.getString("taskEmpId"));
		}
		if (!inputObj.isNull("taskBudget")) {
			taskBudget = PadQuotes(inputObj.getString("taskBudget"));
		}
		if (!inputObj.isNull("taskParentId")) {
			taskParentId = CNumeric(inputObj.getString("taskParentId"));
		}
		if (!inputObj.isNull("pmId")) {
			pmId = CNumeric(inputObj.getString("pmId"));
		}
		if (!inputObj.isNull("taskStartDate")) {
			taskStartDate = PadQuotes(inputObj.getString("taskStartDate"));
		}
		if (!inputObj.isNull("taskEndDate")) {
			taskEndDate = PadQuotes(inputObj.getString("taskEndDate"));
		}
		if (!inputObj.isNull("task_completion_date")) {
			task_completion_date = PadQuotes(inputObj.getString("task_completion_date"));
		}

		if (!inputObj.isNull("taskCompletePerc")) {
			taskCompletePerc = CNumeric(inputObj.getString("taskCompletePerc"));
		}
		if (!inputObj.isNull("taskActive")) {
			taskActive = PadQuotes(inputObj.getString("taskActive"));
		}
		if (!inputObj.isNull("taskPrioritytaskId")) {
			taskPrioritytaskId = CNumeric(inputObj.getString("taskPrioritytaskId"));
		}
		if (!inputObj.isNull("taskNotes")) {
			taskNotes = PadQuotes(inputObj.getString("taskNotes"));
		}

	}

	protected void CheckForm(HttpServletRequest request) {
		msg = "";

		// if (update.equals("yes") && updateB.equals("Update Task")) {
		// StrSql = "SELECT count(task_id)"
		// + " FROM " + compdb(comp_id) + "axela_pm_task"
		// + " WHERE task_parent_id = " + task_id;
		// String task_count = ExecuteQuery(StrSql);
		// if (!task_count.equals("0")) {
		// msg = "<br>Can not change Project!";
		// }
		// }

		if (taskSubject.equals("")) {
			msg += "<br>Enter Subject!";
		}

		// if (!task_subject.equals("")) {
		// StrSql = "SELECT task_subject"
		// + " FROM " + compdb(comp_id) + "axela_pm_task"
		// + " WHERE task_subject = '" + task_subject + "'"
		// + " AND task_pm_id = " + pm_id;
		// empvalue = ExecuteQuery("SELECT emp_name"
		// + " FROM " + compdb(comp_id) + "axela_pm_task"
		// + " INNER JOIN " + compdb(comp_id) + "axela_emp ON emp_id = task_emp_id"
		// + " WHERE task_subject = '" + task_subject + "'"
		// + " AND task_pm_id = " + pm_id);
		// if (update.equals("yes")) {
		// StrSql += " AND task_id != " + task_id + "";
		// empvalue += " AND task_id != " + task_id + "";
		// }
		//
		// if (!ExecuteQuery(StrSql).equals("")) {
		// msg += "<br>Similar Task found to employee " + empvalue + "!";
		// }
		// }

		if (taskEmpId.equals("0")) {
			msg += "<br>Select Executive!";
		}
		if (taskPrioritytaskId.equals("0") || taskPrioritytaskId.equals("")) {
			msg += "<br>Select Priority!";
		}

		if (taskBudget.equals("")) {
			msg += "<br>Enter Budget!";
		}

		if (taskStartDate.equals("")) {
			msg += "<br>Select Start Date!";
		}
		// else {
		// if (isValidDateFormat(taskStartDate, empFormatDate)) {
		// taskStartDate = FormatDateStr(taskStartDate, emp_formatdate);
		// } else {
		// msg += "<br>Enter Valid start Date!";
		// }
		// }

		if (taskEndDate.equals("")) {
			msg += "<br>Select Deadline!";
		}
		// else {
		// if (isValidDateFormat(taskenddate, emp_formatdate)) {
		// task_end_date = FormatDateStr(taskenddate, emp_formatdate);
		// } else {
		// msg += "<br>Enter Valid Deadline!";
		// }
		// }
		if (!taskCompletePerc.equals("100")) {
			if (!taskCompletionDate.equals("")) {
				msg += "<br>Task Completed is not equal to 100%!";
			}
		}

		if (Integer.parseInt(taskCompletePerc) > 100) {
			msg += "<br>Task Completed should be less than or equal to 100%!";
		}

		// if (taskCompletePerc.equals("100")) {
		// if (taskCompletionDate.equals("")) {
		// msg += "<br>Select Completion Date!";
		// } else {
		// if (isValidDateFormat(taskcompletiondate, emp_formatdate)) {
		// task_completion_date = FormatDateStr(taskcompletiondate, emp_formatdate);
		// } else {
		// msg += "<br>Enter Valid Completion Date!";
		// }
		// }
		//
		// if (!taskstartdate.equals("") && !taskcompletiondate.equals("") && isValidDateFormat(taskstartdate, emp_formatdate) && isValidDateFormat(taskcompletiondate, emp_formatdate)) {
		// if (Long.parseLong(FormatDateStr(taskcompletiondate, emp_formatdate)) < Long.parseLong(FormatDateStr(taskstartdate, emp_formatdate))) {
		// msg += "<br>Task Completion Date should be Greater than or equal to Task Start date!";
		// }
		// }
		// }
		//
		// if (!taskstartdate.equals("") && !taskenddate.equals("") && isValidDateFormat(taskstartdate, emp_formatdate) && isValidDateFormat(taskenddate, emp_formatdate)) {
		// if (Long.parseLong(FormatDateStr(taskstartdate, emp_formatdate)) > Long.parseLong(FormatDateStr(taskenddate, emp_formatdate))) {
		// msg += "<br>Task Start Date should be less than Task Deadline!";
		// } else {
		// StrSql = "SELECT pm_start_date, pm_end_date"
		// + " FROM " + compdb(comp_id) + "axela_pm"
		// + " WHERE pm_id = " + pm_id + "";
		//
		// CachedRowSet crs = processQuery(StrSql, 0);
		// while (crs.next()) {
		// pm_start_date = crs.getString("pm_start_date");
		// pm_end_date = crs.getString("pm_end_date");
		// }
		// crs.close();
		//
		// if (!pm_start_date.equals("") && isValidDateFormat(FormatDate(pm_start_date, emp_formatdate), emp_formatdate)) {
		// if (Long.parseLong(FormatDateStr(taskstartdate, emp_formatdate)) < Long.parseLong(pm_start_date)) {
		// msg += "<br>Task Start Date should be greater than or equal to Project Start Date: " + strToShortDate(pm_start_date) + "!";
		// }
		// }
		//
		// if (!pm_end_date.equals("") && isValidDateFormatShort(strToShortDate(pm_end_date))) {
		// if (Long.parseLong(ConvertShortDateToStr(taskenddate)) > Long.parseLong(pm_end_date)) {
		// msg += "<br>Task Deadline should be less than or equal to Project Deadline: " + strToShortDate(pm_end_date) + "!";
		// }
		// }
		// }
		// }
		//
		// if (!task_complete_perc.equals("") && !isNumeric(task_complete_perc)) {
		// msg += "<br>Enter Numeric value for task completion!";
		// }
		//
		// msg += CustomFieldValidate("5", task_id, comp_id, request);

	}

	public void addFields(HttpServletResponse response, HttpServletRequest request) throws JSONException, ParseException {
		// validateFields();
		output = new HashMap();
		AxelaPmTask axelaPmTask = null;
		if (msg.equals("")) {
			if (taskId == 0) {
				axelaPmTask = new AxelaPmTask();
			} else {
				axelaPmTask = taskRepository.findByTaskId(taskId);
			}
			axelaPmTask.setTaskId(taskId);
			axelaPmTask.setTaskActive(taskActive);
			axelaPmTask.setTaskBudget(Integer.parseInt(taskBudget));
			axelaPmTask.setTaskCompletePerc(Integer.parseInt(taskCompletePerc));
			axelaPmTask.setTaskCompletionDate(stringToDate(taskCompletionDate));
			axelaPmTask.setTaskEmpId(empId);
			axelaPmTask.setTaskTaskstatusId(Integer.parseInt(taskTaskstatusId));
			axelaPmTask.setTaskPmmilestoneId(Integer.parseInt(taskPmmilestoneId));
			axelaPmTask.setTaskPrioritytaskId(Integer.parseInt(taskPrioritytaskId));
			axelaPmTask.setTaskStartDate(stringToDate(taskStartDate));
			axelaPmTask.setTaskSubject(taskSubject);
			axelaPmTask.setTaskNotes(taskNotes);
			axelaPmTask.setTaskEndDate(stringToDate(taskEndDate));
			axelaPmTask.setTaskExpense(Integer.parseInt(taskExpense));
			axelaPmTask.setPmTitle(pmTitle);
			if (requestType.equals("add")) {
				axelaPmTask.setTaskEntryDate(stringToDate(""));
				axelaPmTask.setTaskEntryId(empId);
			} else if (requestType.equals("update")) {
				axelaPmTask.setTaskModifiedId(empId);
				axelaPmTask.setTaskModifiedDate(kknow());
			}
			taskId = taskRepository.save(axelaPmTask).getTaskId();
			if (taskId != 0 && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("successmsg", "Task Added Successfully!<br>");
				output.put("taskId", taskId + "");
			} else if (taskId != 0 && requestType.equals("update")) {
				output.put("successmsg", "Task Updated Successfully!<br>");
				output.put("taskId", taskId + "");
			}

		}
		else {
			// response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(int taskId) {
		taskRepository.delete(taskId);
		output.put("successmsg", "Project Deleted Successfully!");
	}

	// public Map populateData(String input) throws JSONException, ParseException {
	// output = new HashMap();
	// inputObj = new JSONObject(input);
	// if (!inputObj.isNull("camptypeId")) {
	// camptypeId = PadQuotes(CNumeric(inputObj.getString("camptypeId")));
	// }
	// ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	// if (!camptypeId.equals("0")) {
	// AxelaSalesCampaignType axelaSalesCampaignType = salesCampaignTypeRepository.findByCamptypeId(Integer.parseInt(camptypeId));
	// HashMap map = new HashMap();
	// map.put("camptypeId", camptypeId);
	// map.put("camptypeDesc", String.valueOf(axelaSalesCampaignType.getCamptypeDesc()));
	// if (axelaSalesCampaignType.getCamptypeEntryId() != 0) {
	// map.put("camptypeEntryDate", strToShortDate(axelaSalesCampaignType.getCamptypeEntryDate()));
	// map.put("camptypeEntryId", String.valueOf(axelaSalesCampaignType.getCamptypeEntryId()));
	// map.put("camptypeEntryBy", empRepository.findEmpName(axelaSalesCampaignType.getCamptypeEntryId()));
	// }
	// if (axelaSalesCampaignType.getCamptypeModifiedId() != 0) {
	// map.put("camptypeModifiedDate", strToShortDate(axelaSalesCampaignType.getCamptypeModifiedDate()));
	// map.put("camptypeModifiedId", String.valueOf(axelaSalesCampaignType.getCamptypeModifiedId()));
	// map.put("camptypeModifiedBy", empRepository.findEmpName(axelaSalesCampaignType.getCamptypeModifiedId()));
	// }
	// list.add(map);
	// output.put("populateData", list);
	// }
	// return output;
	// }

	// public Map listData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
	// page = 0;
	// empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
	// if (empId != 0) {
	// inputObj = new JSONObject(input);
	// output = new LinkedHashMap<String, String>();
	// ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
	// List<HashMap> listBody = new ArrayList<HashMap>();
	// List<HashMap> listAction = new ArrayList<HashMap>();
	// ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
	// ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	// PageRequest request = null;
	//
	// if (!inputObj.isNull("requestType")) {
	// requestType = PadQuotes((inputObj.getString("requestType")));
	// }
	// if (!inputObj.isNull("sortField")) {
	// orderByField = PadQuotes((inputObj.getString("sortField")));
	// }
	// if (!inputObj.isNull("pageIndex")) {
	// page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
	// }
	// if (!inputObj.isNull("sortDirection")) {
	// orderType = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
	// }
	// perPage = CNumeric(getSession("empRecperpage", session));
	// if (orderType.equals("")) {
	// orderType = "DESC";
	// }
	// if (orderByField.equals("")) {
	// orderByField = "camptypeId";
	// }
	// if (perPage.equals("0")) {
	// perPage = "25";
	// }
	// page++;
	// if (requestType.equals("filter")) {
	// strSearch = buildSmartSearch(input);
	// }
	//
	// strOrderBy = " ORDER BY type." + orderByField + " " + orderType + "";
	// List<AxelaSalesCampaignType> resultSet = portalFilterImpl.findAllCampaignType(strSearch, strOrderBy, page, Integer.parseInt(perPage));
	// String length = portalFilterImpl.totalCount;
	// Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
	// int count = 0;
	// // Start Header Data
	// listHeader.add(produceHeaderData("Campaign Type Details", "camptypeDesc", "center"));
	// // End Header Data
	//
	// // Start Body Align
	// listBodyAlign.add(produceBodyAlign("center"));
	// listBodyAlign.add(produceBodyAlign("left"));
	// // End Body Align
	//
	// StringBuilder dataString = null;
	// for (AxelaSalesCampaignType obj : resultSet) {
	// ArrayList<String> param = new ArrayList<String>();
	// ArrayList type = new ArrayList();
	// ArrayList value = new ArrayList();
	// ArrayList<String> actionParam = new ArrayList<String>();
	// ArrayList<ArrayList> paramArr = new ArrayList<ArrayList>();
	// HashMap<String, List<HashMap>> mapData = new HashMap<String, List<HashMap>>();
	// HashMap<String, List<HashMap>> mapAction = new HashMap<String, List<HashMap>>();
	// HashMap<String, List<String>> mapBodyData = new HashMap<String, List<String>>();
	// List<HashMap> listData = new ArrayList<HashMap>();
	// count++;
	//
	// type.add(false);
	// value.add(count);
	// listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
	// type.clear();
	// value.clear();
	//
	// type.add(false);
	// value.add(obj.getCamptypeDesc());
	// listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
	// type.clear();
	// value.clear();
	//
	// mapData.put("td", listData);
	// actionParam.add("updateCampaignType");
	// actionParam.add(obj.getCamptypeId() + "");
	// mapAction.put("td", produceActionData(actionParam));
	//
	// listAction.add(mapAction);
	// listBody.add(mapData);
	// }
	// output.put("meta", mapNavi);
	// output.put("thead", listHeader);
	// output.put("tdalign", listBodyAlign);
	// output.put("tbody", listBody);
	// output.put("action", listAction);
	// }
	// return output;
	// }
	//
	// private ArrayList<HashMap> produceActionData(ArrayList<String> actionParam) {
	// ArrayList<HashMap> listAction = new ArrayList<HashMap>();
	// HashMap mapBodyData = new HashMap();
	// mapBodyData.put("value", "Update Campaign Type");
	// mapBodyData.put("param", actionParam);
	// listAction.add((HashMap) mapBodyData.clone());
	// return listAction;
	// }
	//
	// public Map populateDrSmart() {
	// ArrayList<HashMap> list = new ArrayList<HashMap>();
	// output = new LinkedHashMap();
	// list.add(buildSmartArr("Keyword", "text", "type.*"));
	// list.add(buildSmartArr("Camptype ID", "numeric", "type.camptypeId"));
	// list.add(buildSmartArr("Camptype Desc", "text", "type.camptypeDesc"));
	// list.add(buildSmartArr("Entry By", "text", "type.camptypeEntryId)"));
	// list.add(buildSmartArr("Entry Date", "date", "type.camptypeEntryDate"));
	// list.add(buildSmartArr("Modified By", "text", "type.camptypeModifiedId"));
	// list.add(buildSmartArr("Modified Date", "date", "type.camptypeModifiedDate"));
	// output.put("drSmart", list.toArray());
	// return output;
	// }

}
