package axela.app.pm.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
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
import axela.pm.repository.TaskRepositoryImpl;
import axela.pm.service.TaskService;
@Service
public class AppTaskService extends Connect {

	@Autowired
	public TaskRepositoryImpl taskRepositoryImpl;

	@Autowired
	public TaskRepository taskRepository;

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
	public String exeAccess = "";
	HashMap output = null;
	JSONObject inputObj = null;
	LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

	public Map<String, String> taskAdd(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, SQLException, ParseException {
		if (AppRun().equals("0")) {
			SOP("input==WS_jobcadrt_Add===" + input);
		}

		inputObj = new JSONObject(input);
		output = new LinkedHashMap();
		exeAccess = GetSession("ExeAccess", request);
		branchAccess = GetSession("BranchAccess", request);
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));

		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (empId != 0) {
			switch (requestType) {
				case "add" : //
					getValues(inputObj);
					addFields(response, request);
					break;

				case "dash" :// Oppr Dash.
					if (!inputObj.isNull("taskId")) {
						taskId = Integer.parseInt(CNumeric(inputObj.getString("opprId")));
					}
					if (taskId != 0) {
						// opprDashPage(input, session, response, request);
					}
					break;
			}
		}
		else
		{
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
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
		if (!inputObj.isNull("taskCompletionDate")) {
			taskCompletionDate = PadQuotes(inputObj.getString("taskCompletionDate"));
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

	public void addFields(HttpServletResponse response, HttpServletRequest request) throws SQLException, JSONException, ParseException {
		TaskService task = new TaskService();
		task.taskPmmilestoneId = taskPmmilestoneId;
		task.taskSubject = taskSubject;
		task.taskTaskstatusId = taskTaskstatusId;
		task.taskEmpId = taskEmpId;
		task.taskBudget = taskBudget;
		task.taskParentId = taskParentId;
		task.pmId = pmId;
		task.taskStartDate = taskStartDate;
		task.empId = empId;
		task.requestType = requestType;
		task.taskEndDate = taskEndDate;
		task.taskCompletionDate = taskCompletionDate;
		task.taskActive = taskActive;
		task.taskCompletePerc = taskCompletePerc;
		task.taskPrioritytaskId = taskPrioritytaskId;
		task.taskNotes = taskNotes;
		task.taskCompletePerc = taskCompletePerc;
		task.taskRepository = taskRepository;
		task.addFields(response, request);
		String msg = task.msg;
		if (msg.equals("")) {
			output.put("successmsg", "Task Added Successfully!");
			output.put("taskId", task.taskId + "");
		} else {
			response.setStatus(201);
			output.put("errormsg", msg);
		}
	}
	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		String sort = "";
		String strOrderBy = "";
		String perPage = "0";
		String strSearch = "";
		pmId = "0";
		inputObj = new JSONObject(input);

		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		// if (empId.equals("0")) {
		output = new LinkedHashMap<String, String>();
		exeAccess = getSession("exeAccess", session).replaceAll("empId", "task.taskEmpId");
		int page = 0;
		if (!inputObj.isNull("pageIndex")) {
			page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
		}
		perPage = CNumeric(getSession("empRecperpage", session));
		if (sort.equals("")) {
			sort = "DESC";
		}
		if (strOrderBy.equals("")) {
			strOrderBy = "taskId";
		}
		if (perPage.equals("0")) {
			perPage = "25";
		}
		page++;
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (requestType.equals("filter")) {
			strSearch += appBuildSmartSearch(input);
		}
		if (!inputObj.isNull("pmId")) {
			pmId = CNumeric(inputObj.getString("pmId"));
		}
		if (!pmId.equals("0") && pmId != "") {
			strSearch += " AND task.taskPmId =" + pmId + "";
		}
		strSearch += exeAccess;
		strOrderBy = " ORDER BY task." + strOrderBy + " " + sort + "";
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
		List<AxelaPmTask> resultSet = taskRepositoryImpl.findAll(strSearch, strOrderBy, page, Integer.parseInt(perPage), "yes");
		String totalCount = taskRepositoryImpl.totalCount;
		if (!totalCount.equals("0")) {
			for (AxelaPmTask obj : resultSet) {
				map.clear();
				map.put("taskId", obj.getTaskId() + "");
				map.put("taskSubject", obj.getTaskSubject());
				map.put("pmTitle", PadQuotes(obj.getPmTitle()));
				map.put("taskBudget", obj.getTaskBudget() + "");
				map.put("empName", obj.getEmpName());
				map.put("taskCompletePerc", obj.getTaskCompletePerc() + "");
				list.add((HashMap<String, String>) map.clone());
			}
			output.put("listData", list);

		}
		else
		{
			output.put("msg", "No Records Found!");
		}
		if (AppRun().equals("0")) {
			SOP("output =========Axela listData============== " + output);
		}
		return output;
	}
}
