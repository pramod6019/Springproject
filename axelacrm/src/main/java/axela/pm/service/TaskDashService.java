package axela.pm.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import axela.pm.repository.TaskRepositoryImpl;
import axela.portal.repository.EmpRepository;
@Service
public class TaskDashService extends Connect {
	@Autowired
	public TaskRepositoryImpl taskRepositoryImpl;

	@Autowired
	public EmpRepository axelaEmpRepository;
	public int empId = 0;
	public String tab = "0";
	public int taskId = 0;
	private String compId = "0";

	public JSONObject inputObj = null;
	public HashMap output = null;
	public String requestType = "";
	private String msg = "";
	private String branchAccess;
	private String exeAccess;
	private String empFormatDate = "";
	public String empFormattime = "";

	public Map taskServiceUpdate(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("inputObj==========jcDashService==========" + inputObj.toString(1));
		}
		requestType = "";
		output = new HashMap();
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		SOP("empId===================" + empId);
		if (empId != 0) {

			if (!inputObj.isNull("tab")) {
				tab = inputObj.getString("tab");
			}
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			switch (tab) {
				case "1" : // jobcard Details
					switch (requestType) {
						case "populateData" :
							if (!inputObj.isNull("taskId")) {
								taskId = Integer.parseInt(inputObj.getString("taskId"));
							}

							populateTaskData(input, session, response);
							break;

						case "update" :
							// dashFieldUpdate(input, request, response, session);
							break;
					}
					break;
			// case "2" :// jobcard Customer.
			// switch (requestType) {
			// case "populateData" :
			// if (!inputObj.isNull("jcId")) {
			// jcId = Integer.parseInt(inputObj.getString("jcId"));
			// }
			// populateCustomerDetails(jcId);
			// populateCustomerDetail();
			// break;
			// }
			// break;

			}
		}
		else
		{
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			output.put("response", response);

		}

		return output;
	}

	public Map<String, String> populateTaskData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		Map map = new LinkedHashMap<String, String>();
		ArrayList list = new ArrayList();
		if (!inputObj.isNull("taskId")) {
			taskId = Integer.parseInt(PadQuotes(CNumeric(inputObj.getString("taskId"))));
		}
		if (taskId != 0) {
			AxelaPmTask axelaPmTask = taskRepositoryImpl.findOneForDash(taskId);
			if (axelaPmTask != null) {
				map.put("taskId", axelaPmTask.getTaskId() + "");
				map.put("pmId", axelaPmTask.getPmId() + "");
				map.put("pmTitle", axelaPmTask.getPmTitle() + "");
				map.put("taskParentId", axelaPmTask.getTaskParentId() + "");
				map.put("taskSubject", axelaPmTask.getTaskSubject());
				map.put("taskEmpId", axelaPmTask.getTaskEmpId() + "");
				map.put("taskBudget", axelaPmTask.getTaskBudget() + "");
				map.put("taskStartDate", strToShortDate(axelaPmTask.getTaskStartDate()));
				map.put("taskEndDate", strToShortDate(axelaPmTask.getTaskEndDate()));
				map.put("taskCompletionDate", strToShortDate(axelaPmTask.getTaskCompletionDate()));
				map.put("taskCompletePerc", axelaPmTask.getTaskCompletePerc() + "");
				map.put("taskActive", axelaPmTask.getTaskActive() + "");
				map.put("taskNotes", axelaPmTask.getTaskNotes());
				map.put("taskEntryId", axelaPmTask.getTaskEntryId() + "");
				map.put("taskEntryBy", PadQuotes(axelaEmpRepository.findEmpName(axelaPmTask.getTaskEntryId())));
				map.put("taskEntryDate", strToLongDate(axelaPmTask.getTaskEntryDate()));
				if (axelaPmTask.getTaskModifiedId() != 0) {
					map.put("taskModifiedId", axelaPmTask.getTaskModifiedId() + "");
					map.put("taskModifiedDate", strToShortDate(axelaPmTask.getTaskModifiedDate()));
					map.put("taskModifiedBy", axelaEmpRepository.findEmpName(axelaPmTask.getTaskModifiedId()));
				}
				list.add(map);
				output.put("populateTaskData", list);
			} else {

				output.put("msg", "Invalid Jobcard ID");
			}
		}
		else {
			output.put("msg", "Invalid Task ID");
			response.setStatus(400);
		}
		return output;
	}

}
