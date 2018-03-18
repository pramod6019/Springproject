package axela.app.pm.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
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
import axela.customer.repository.PmTaskRepository;
import axela.pm.model.AxelaPm;
import axela.pm.model.AxelaPmExe;
import axela.pm.model.AxelaPmMilestone;
import axela.pm.model.AxelaPmTask;
import axela.pm.model.AxelaPmTaskDoc;
import axela.pm.repository.PmExeRepository;
import axela.pm.repository.PmMilestoneRepositoryImpl;
import axela.pm.repository.PmMilestonesRepository;
import axela.portal.repository.PmFilterImpl;

@Service
public class AppPmDashService extends Connect {

	@Autowired
	public PmFilterImpl pmFilterImpl;

	@Autowired
	public PmTaskRepository pmTaskRepository;

	@Autowired
	public PmMilestonesRepository pmMilestonesRepository;

	@Autowired
	public PmMilestoneRepositoryImpl pmMilestoneRepositoryImpl;

	@Autowired
	public PmExeRepository pmExeRepository;

	JSONObject inputObj = null;
	public String requestType = "";
	public HashMap output = null;
	public String tab = "0";
	public String pmId = "0";
	public int executiveId = 0;
	public int empId = 0;
	public String pmexeEmpId = "0";

	public Map pmDash(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("inputObj==========ticketDashService==========" + inputObj.toString(1));
		}
		output = new HashMap();
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		if (!inputObj.isNull("tab")) {
			tab = inputObj.getString("tab");
		}
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		// if (!inputObj.isNull("pmId")) {
		// pmId = Integer.parseInt(inputObj.getString("pmId"));
		// }
		SOP("tab=========" + tab);
		if (tab.equals("1")) {
			// Project Overview
			switch (requestType) {
				case "populateData" :

					if (!inputObj.isNull("pmId")) {
						pmId = CNumeric(inputObj.getString("pmId"));
					}
					if (!pmId.equals("0")) {
						HashMap total = new HashMap();
						total.putAll(PopulateProjectDetails());
						total.putAll(ProjectCompletePrec());
						total.putAll(PopulateProjectExecutives());
						return total;
					}
				case "deletemembers" :
					if (!inputObj.isNull("pmId")) {
						pmId = CNumeric(inputObj.getString("pmId"));
					}
					if (!pmId.equals("0")) {
						List<AxelaPmExe> resultSet = pmFilterImpl.findProjectExe(Integer.parseInt(pmId));
						for (AxelaPmExe obj : resultSet) {
							pmexeEmpId = obj.getPmexeEmpId() + "";
						}
						if ((pmexeEmpId.equals(empId) || empId == 1)) {
							SOP("inside condition");
							executiveId = empId;
							deleteMembers();
						}
					}
			}
		} else if (tab.equals("2")) {
			switch (requestType) {
				case "populateData" :
					PopulateTaskSummary(input, session);
					break;
				default :
					break;
			}
		}
		else if (tab.equals("3")) {
			switch (requestType) {
				case "populateData" :
					if (!inputObj.isNull("pmId")) {
						pmId = CNumeric(inputObj.getString("pmId"));
					}
					PopulateMilestone(session);
					break;
				default :
					break;
			}
		}
		else if (tab.equals("4")) {
			switch (requestType) {
				case "populateData" :
					if (!inputObj.isNull("pmId")) {
						pmId = CNumeric(inputObj.getString("pmId"));
					}
					PopulateProjectDoc();
					break;

				case "add" :
					break;
				default :
					break;
			}
		}
		return output;
	}

	public void deleteMembers()
	{
		pmExeRepository.findPmExe(executiveId, Integer.parseInt(pmId));

		output.put("successmsg", "Member Deleted Successfully");
	}

	public Map PopulateProjectDoc() throws JSONException, ParseException {
		output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (AxelaPmTaskDoc obj : pmFilterImpl.findProjectDoc(Integer.parseInt(pmId))) {
			HashMap map = new HashMap();
			map.put("taskSubject", obj.getTaskSubject());
			map.put("docTaskId", obj.getDocTaskId());
			map.put("docRemarks", obj.getDocRemarks());
			map.put("docId", obj.getDocId());
			map.put("docTitle", obj.getDocTitle());
			list.add(map);
		}
		output.put("populateProjectDoc", list);
		return output;
	}

	public Map PopulateProjectDetails() throws JSONException, ParseException {
		output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (AxelaPm obj : pmFilterImpl.findProjectDetails(Integer.parseInt(pmId))) {
			HashMap map = new HashMap();
			map.put("customerId", obj.getCustomerId());
			map.put("customerName", obj.getCustomerName());
			map.put("pmStartDate", strToLongDate(obj.getPmStartDate()));
			map.put("pmEndDate", strToLongDate(obj.getPmEndDate()));
			map.put("pmId", obj.getPmId());
			map.put("pmTitle", obj.getPmTitle());
			map.put("pmCompleteComments", PadQuotes(obj.getPmCompleteComments()));
			list.add(map);
		}
		output.put("populateProjectDetails", list);
		return output;
	}

	public Map PopulateProjectExecutives() throws JSONException, ParseException {
		output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (AxelaPmExe obj : pmFilterImpl.findProjectExecutives(Integer.parseInt(pmId))) {
			HashMap map = new HashMap();
			map.put("empId", obj.getEmpId());
			map.put("empName", obj.getEmpName());
			map.put("empGender", obj.getEmpGender());
			list.add(map);
		}
		output.put("populateProjectExecutives", list);
		return output;
	}

	public void PopulateTaskSummary(String input, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		int notStarted = 0, notStartedcount = 0, inProgress = 0, testing = 0, awaitingFeedBack = 0, complete = 0;
		int myNotStarted = 0, myInProgress = 0, myTesting = 0, myAwaitingFeedBack = 0, myComplete = 0;
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		SOP("empIDdd=11================" + empId);
		Map<String, String> map = new HashMap<String, String>();
		output = new HashMap();
		if (!inputObj.isNull("pmId")) {
			pmId = CNumeric(inputObj.getString("pmId"));
		}
		List<Object[]> tasksum = pmTaskRepository.findTaskpmId(Integer.parseInt(pmId));
		for (Object[] result : tasksum) {
			switch (result[0].toString()) {
				case "1" :
					if (result[1].equals(empId)) {
						myNotStarted++;
						notStarted++;
					}
					break;
				case "2" :
					if (result[1].equals(empId)) {
						myInProgress++;
						inProgress++;
					}
					break;
				case "3" :
					if (result[1].equals(empId)) {
						myTesting++;
						testing++;
					}
					break;
				case "4" :
					if (result[1].equals(empId)) {
						myAwaitingFeedBack++;
						awaitingFeedBack++;
					}
					break;
				case "5" :
					if (result[1].equals(empId)) {
						myComplete++;
						complete++;
					}
					break;
			}
		}
		map.put("mynotstarted", myNotStarted + "");
		map.put("myinprogress", myInProgress + "");
		map.put("mytesting", myTesting + "");
		map.put("myawaitingfeedback", myAwaitingFeedBack + "");
		map.put("mycomplete", myComplete + "");
		map.put("notstarted", notStarted + "");
		map.put("inprogress", inProgress + "");
		map.put("testing", testing + "");
		map.put("awaitingfeedback", awaitingFeedBack + "");
		map.put("complete", complete + "");
		output.put("populatetasksummary", map);
	}

	public Map ProjectCompletePrec() throws JSONException, ParseException {
		String pm_completed = "0";
		int count = 0, task_complete_perc_sum = 0;
		output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (AxelaPmTask obj : pmFilterImpl.findProjectCompletePerc(Integer.parseInt(pmId))) {
			HashMap map = new HashMap();
			task_complete_perc_sum += obj.getTaskCompletePerc();
			count++;
			if (task_complete_perc_sum != 0) {
				SOP("inside");
				pm_completed = task_complete_perc_sum / count + "";
			}
			output.put("pmCompletedPerc", pm_completed);
		}
		return output;
	}

	public Map PopulateMilestone(HttpSession session) throws JSONException, ParseException {
		String taskstatus_name_id = "", milestone_id = "", taskstatusName = "";
		int count = 0;
		output = new HashMap();
		if (!inputObj.isNull("pmId")) {
			pmId = CNumeric(inputObj.getString("pmId"));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (Object[] pmmilestone : pmMilestonesRepository.findByPopulateMilestone(Integer.parseInt(pmId))) {
			count++;
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("name", pmmilestone[1].toString());
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
			strSearch += " AND milestone.pmmilestonePmId =" + pmId + "";
		}

		ArrayList<Map<String, String>> list1 = new ArrayList<Map<String, String>>();
		List<AxelaPmMilestone> resultSet = pmMilestoneRepositoryImpl.findmilestone(strSearch);
		if (resultSet != null && resultSet.size() > 0) {
			for (AxelaPmMilestone obj : resultSet) {
				if (!String.valueOf(obj.getPmmilestoneId()).equals(milestone_id)) {
					List list2;
					if (output.containsKey(obj.getPmmilestoneName())) {
						list2 = (ArrayList) output.get(obj.getPmmilestoneName());
					} else {
						list2 = new ArrayList();
						output.put(obj.getPmmilestoneName(), list2);
					}
					Map<String, String> map = new HashMap<String, String>();
					map.put("pmmilestoneId", obj.getPmmilestoneId() + "");
					map.put("pmmilestonePmId", obj.getPmmilestonePmId() + "");
					map.put("taskPmmilestoneId", obj.getTaskPmmilestoneId() + "");
					map.put("taskSubject", obj.getTaskSubject());
					map.put("taskStartDate", strToShortDate(obj.getTaskStartDate()));
					map.put("taskEndDate", strToShortDate(obj.getTaskEndDate()));
					map.put("pmmilestoneName", obj.getPmmilestoneName());
					map.put("pmmilestoneDesc", obj.getPmmilestoneDesc());
					map.put("pmmilestoneRank", obj.getPmmilestoneRank() + "");
					list2.add(map);
				}
			}

		}
		return output;
	}
}
