package axela.app.pm.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.CachedRowSet;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.pm.model.AxelaPmTask;
import axela.pm.repository.TaskRepositoryImpl;
import axela.pm.repository.TaskStatusRepository;
@Service
public class KanbanService extends Connect {

	@Autowired
	public TaskStatusRepository taskStatusRepository;
	@Autowired
	public TaskRepositoryImpl taskRepositoryImpl;
	CachedRowSet crs = null;

	public HashMap output = null;
	Map<String, String> map = new HashMap<String, String>();
	public String exeAccess = "";
	public String requestType = "";
	public String pmId = "0";
	JSONObject inputObj = null;

	public Map KanBan(String input, HttpServletRequest request, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("input==kanban input===" + inputObj.toString(1));
		}

		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		switch (requestType) {
			case "populateData" :
				PopulateKanBan(session);
				break;
			default :
				break;
		}

		if (AppRun().equals("0")) {
			SOP("output=kanban output===" + output.toString());
		}
		return output;
	}

	public Map PopulateKanBan(HttpSession session) throws JSONException, ParseException {
		String taskstatus_name_id = "", taskstatus_id = "", taskstatusName = "";
		int count = 0;
		output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (Object[] taskStatus : taskStatusRepository.findByPopulateTaskStatus()) {
			count++;
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("name", taskStatus[1].toString());
			list.add(map);
		}
		output.put("status_name", list);

		String sort = "";
		String strOrderBy = "";
		String perPage = "0";
		String strSearch = "";
		if (!inputObj.isNull("pmId")) {
			pmId = CNumeric(inputObj.getString("pmId"));
		}
		if (!pmId.equals("0")) {
			strSearch += " AND task.taskPmId =" + pmId + "";
		}

		ArrayList<Map<String, String>> list1 = new ArrayList<Map<String, String>>();
		List<AxelaPmTask> resultSet = taskRepositoryImpl.findkanban(strSearch);
		if (resultSet != null && resultSet.size() > 0) {
			for (AxelaPmTask obj : resultSet) {
				if (!String.valueOf(obj.getTaskstatusId()).equals(taskstatus_id)) {
					List list2;
					if (output.containsKey(obj.getTaskstatusName())) {
						list2 = (ArrayList) output.get(obj.getTaskstatusName());
					} else {
						list2 = new ArrayList();
						output.put(obj.getTaskstatusName(), list2);
					}
					Map<String, String> map = new HashMap<String, String>();
					map.put("taskId", obj.getTaskId() + "");
					map.put("taskSubject", obj.getTaskSubject());
					map.put("taskTaskstatusId", obj.getTaskTaskstatusId() + "");
					map.put("taskstatusName", obj.getTaskstatusName());
					map.put("taskStartDate", strToShortDate(obj.getTaskStartDate()));
					map.put("taskEndDate", strToShortDate(obj.getTaskEndDate()));
					list2.add(map);
				}
			}

		}
		return output;
	}
}
