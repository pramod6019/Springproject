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

import axela.activities.model.AxelaActivity;
import axela.activities.repository.ActivityFilterImpl;
import axela.activities.repository.ActivityRepository;
import axela.config.Connect;
import axela.portal.model.AxelaEmp;
import axela.portal.repository.EmpRepository;

@Service
public class ActivitiesService extends Connect {

	public String listpage = "";
	public String add = "";
	public String update = "";
	public String addB = "";
	public String updateB = "";
	public String deleteB = "";
	public String status = "";
	public String msg = "";
	public String StrSql = "";
	public int empId = 0;
	public String empRole = "";
	public String compId = "0";
	public String contactId = "0";
	public String activityId = "0", tabs = "";
	public String activityActivitytypeId = "0";
	public String listExecutives = "";
	public String activityPriorityId = "0";
	public String activityContactId = "0";
	public String[] activityEmpIdl;
	public String activityEmpId = "0";
	public String activityStartDatetime = "";
	public String startDatetime = "";
	public String activityEndDatetime = "";
	public String activityReminder = "";
	public String activityReminderSet = "";
	public String activityContactPerson = "";
	public String activityTitle = "";
	public String activityDesc = "";
	public String activityPhone1 = "";
	public String activityPhone2 = "";
	public String activityVenue = "";
	public String activityStatusId = "";
	public String activityFeedback = "";
	public String activityRemarks = "";
	public String activityEntryId = "0";
	public String activityEntryDatetime = "";
	public String activityModifiedId = "0";
	public String activityModifiedDatetime = "";
	public String activityFeedbackEntryId = "0";
	public String activityFeedbackEntryDatetime = "";
	public String activityRemarksEntryId = "0";
	public String activityRemarksEntryDatetime = "";
	public String endDatetime = "";
	public String entryBy = "";
	public String entryDate = "";
	public String modifiedBy = "";
	public String modifiedDate = "";
	public String client = "";
	public String date = "";
	public String StartHour = "";
	public String data = "";
	public String ExeAccess = "";
	public String empPop = "";
	public String QueryString = "";
	public String min = "";
	public String hour = "";
	public String empFormatdate = "";
	public String empFormattime = "";
	public String strSearch = "";
	public String branchAccess = "";
	public String exeAccess = "";
	public int totalCount = 0;

	HashMap output = null;
	JSONObject inputObj = null;
	public String requestType = "";
	public String sortField = "";
	public String sortDirection = "DESC";
	public String perPage = "";
	public int page = 0;

	@Autowired
	ActivityRepository activityRepository;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	ActivityFilterImpl activityFilterImpl;

	public Map<String, String> activityService(String input, HttpSession session, HttpServletResponse response) throws Exception {
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		compId = CNumeric(getSession("compId", session));
		empFormatdate = getSession("formatdateName", session);
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (empId != 0) {
			if (!returnPerm("emp_activity_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			switch (requestType) {
				case "add" :
					if (!returnPerm("emp_activity_add", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					activityId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;

				case "update" :
					if (!returnPerm("emp_activity_edit", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					activityId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;

				case "delete" :
					if (!returnPerm("emp_activity_delete", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					if (!inputObj.isNull("activityId")) {
						activityId = PadQuotes(inputObj.getString("activityId"));
					}
					if (!activityId.equals("0")) {
						deleteFields(activityId);
					}
					break;
			}
		}
		return output;

	}

	protected void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("activityEmpId")) {
			activityEmpId = inputObj.getString("activityEmpId");
		}
		if (!inputObj.isNull("activityId")) {
			activityId = inputObj.getString("activityId");
		}
		if (!inputObj.isNull("activityActivitytypeId")) {
			activityActivitytypeId = inputObj.getString("activityActivitytypeId");
		}

		if (!inputObj.isNull("activityTitle")) {
			activityTitle = inputObj.getString("activityTitle");
		}
		if (!inputObj.isNull("activityDesc")) {
			activityDesc = inputObj.getString("activityDesc");
		}

		if (!inputObj.isNull("activityPriorityId")) {
			activityPriorityId = inputObj.getString("activityPriorityId");
		}

		if (!inputObj.isNull("activityPhone1")) {
			activityPhone1 = inputObj.getString("activityPhone1");
		}
		if (!inputObj.isNull("activityPhone2")) {
			activityPhone2 = inputObj.getString("activityPhone2");
		}
		if (!inputObj.isNull("activityVenue")) {
			activityVenue = inputObj.getString("activityVenue");
		}
		if (!inputObj.isNull("activityStatusId")) {
			activityStatusId = inputObj.getString("activityStatusId");
		}
		if (!inputObj.isNull("client")) {
			client = inputObj.getString("client");
		}
		if (!inputObj.isNull("activityContactId")) {
			activityContactId = inputObj.getString("activityContactId");
		}
		if (!inputObj.isNull("contactId")) {
			contactId = inputObj.getString("contactId");
		}
		if (!inputObj.isNull("activityContactId")) {
			activityContactId = inputObj.getString("activityContactId");
		}

		if (!inputObj.isNull("entryBy")) {
			entryBy = inputObj.getString("entryBy");
		}
		if (!inputObj.isNull("entryDate")) {
			entryDate = inputObj.getString("entryDate");
		}
		if (!inputObj.isNull("modifiedBy")) {
			modifiedBy = inputObj.getString("modifiedBy");
		}
		if (!inputObj.isNull("modifiedDate")) {
			modifiedDate = inputObj.getString("modifiedDate");
		}
		if (!inputObj.isNull("activityStartDatetime")) {
			activityStartDatetime = inputObj.getString("activityStartDatetime");
		}
		if (!inputObj.isNull("activityEndDatetime")) {
			activityEndDatetime = inputObj.getString("activityEndDatetime");
		}
		if (!inputObj.isNull("activityContactPerson")) {
			activityContactPerson = inputObj.getString("activityContactPerson");
		}
	}

	protected void validateFields() {
		msg = "";
		if (activityEmpId.equals("")) {
			msg += "<br>Select Executive!";
		}
		if (activityActivitytypeId.equals("0")) {
			msg += "<br>Select Type!";
		}
		if (activityTitle.equals("")) {
			msg += "<br>Enter Title!";
		}

		if (activityStartDatetime.equals("0")) {
			msg += "<br>Select Start Time!";
		}
		if (!activityStartDatetime.equals("")) {
			if (!isValidDateFormatLong(activityEndDatetime)) {
				msg += "<br>Enter Valid Start Time!";
			}
		}
		if (activityEndDatetime.equals("")) {
			msg += "<br>Select End Time!";
		}

		if (activityPriorityId.equals("0") && !activityPriorityId.equals("")) {
			msg += "<br>Select Priority!";
		}
		if (activityContactId.equals("") || activityContactId.equals("0")) {
			if (activityPhone1.equals("")) {
				msg += "<br>Enter Phone no.!";
			}
		}
	}

	protected void addFields(HttpServletResponse response, HttpSession session) throws ParseException {
		AxelaActivity axelaActivity = null;
		validateFields();
		if (msg.equals("")) {
			if (!activityId.equals("0")) {
				axelaActivity = activityRepository.findOne(Integer.parseInt(activityId));
			} else {
				axelaActivity = new AxelaActivity();
			}
			axelaActivity.setActivityEmpId(Integer.parseInt(activityEmpId));
			axelaActivity.setActivityActivitytypeId(Integer.parseInt(activityActivitytypeId));
			axelaActivity.setActivityTitle(activityTitle);
			axelaActivity.setActivityDesc(activityDesc);
			axelaActivity.setActivityPriorityId(Integer.parseInt(activityPriorityId));
			axelaActivity.setActivityContactId(Integer.parseInt(activityContactId));
			axelaActivity.setActivityContactPerson(activityContactPerson);
			axelaActivity.setActivityPhone1(activityPhone1);
			axelaActivity.setActivityPhone2(activityPhone2);
			axelaActivity.setActivityVenue(activityVenue);
			axelaActivity.setActivityStatusId(0);
			axelaActivity.setActivityFeedback(activityFeedback);
			axelaActivity.setActivityRemarks(activityRemarks);
			axelaActivity.setActivityFeedbackEntryId(Integer.parseInt(activityFeedbackEntryId));
			axelaActivity.setActivityFeedbackEntryDatetime(stringToDate(activityFeedbackEntryDatetime));
			axelaActivity.setActivityRemarksEntryDatetime(stringToDate(activityRemarksEntryDatetime));
			axelaActivity.setActivityTrigger(0);
			axelaActivity.setActivityReminder(activityReminder);
			axelaActivity.setActivityReminderSet(activityReminderSet);
			axelaActivity.setActivityStartDatetime(stringToDate(activityStartDatetime));
			axelaActivity.setActivityEndDatetime(stringToDate(activityEndDatetime));
			if (requestType.equals("add")) {
				axelaActivity.setActivityEntryId(empId);;
				axelaActivity.setActivityEntryDatetime(getTimeByZone(session));
				axelaActivity.setActivityModifiedId(0);
				// axelaActivity.setActivityModifiedDatetime("");
			} else if (requestType.equals("update")) {
				axelaActivity.setActivityModifiedId(empId);
				axelaActivity.setActivityModifiedDatetime(getTimeByZone(session));
			}
			activityId = activityRepository.save(axelaActivity).getActivityId() + "";
			if (!activityId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("successmsg", "Activity Added Successfully!");
			} else if (!activityId.equals("0") && requestType.equals("update")) {
				output.put("successmsg", "Activity Updated Successfully!");
			}
		} else {
			response.setStatus(400);
			output.put("errormsg", msg);
		}
	}
	public void deleteFields(String activityId) throws JSONException {
		activityRepository.delete(Integer.parseInt(activityId));
		output.put("successmsg", "Activity Deleted Successfully!");
	}

	public Map<String, List> populateData(String input, HttpSession session) throws JSONException, ParseException {
		requestType = "";
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, List>();
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		LinkedHashMap map = new LinkedHashMap();
		if (empId != 0) {
			if (!returnPerm("emp_activity_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			if (!inputObj.isNull("activityId")) {
				activityId = (inputObj.getString("activityId"));
			}
			if (!activityId.equals("0")) {
				AxelaActivity axelaActivity = activityRepository.findByActivityId(Integer.parseInt(activityId));
				if (axelaActivity != null) {
					map.put("activityId", axelaActivity.getActivityId() + "");
					map.put("activityActivitytypeId", axelaActivity.getActivityActivitytypeId() + "");
					map.put("activityPriorityId", axelaActivity.getActivityPriorityId() + "");
					map.put("activityEmpId", axelaActivity.getActivityEmpId() + "");
					map.put("activityContactId", axelaActivity.getActivityContactId() + "");
					map.put("activityTitle", axelaActivity.getActivityTitle());
					map.put("activityDesc", axelaActivity.getActivityDesc());
					map.put("activityStartDatetime", strToLongDate(axelaActivity.getActivityStartDatetime()));
					map.put("activityEndDatetime", strToLongDate(axelaActivity.getActivityEndDatetime()));
					map.put("activityReminder", axelaActivity.getActivityReminder());
					map.put("activityReminderSet", axelaActivity.getActivityReminderSet());
					map.put("activityContactPerson", axelaActivity.getActivityContactPerson());
					map.put("activityPhone1", axelaActivity.getActivityPhone1());
					map.put("activityPhone2", axelaActivity.getActivityPhone2());
					map.put("activityVenue", axelaActivity.getActivityVenue());
					map.put("activityStatusId", axelaActivity.getActivityStatusId() + "");
					map.put("activityFeedback", axelaActivity.getActivityFeedback());
					map.put("activityRemarks", axelaActivity.getActivityFeedback());
					map.put("activityFeedbackEntryId", axelaActivity.getActivityFeedbackEntryId() + "");
					map.put("activityFeedbackEntryDatetime", strToShortDate(axelaActivity.getActivityFeedbackEntryDatetime()));
					map.put("activityRemarksEntryId", axelaActivity.getActivityFeedbackEntryId() + "");
					map.put("activityRemarksEntryDatetime", strToShortDate(axelaActivity.getActivityRemarksEntryDatetime()));
					map.put("activityTrigger", axelaActivity.getActivityTrigger() + "");
					AxelaEmp axelaEmp = empRepository.findByEmpId(axelaActivity.getActivityEntryId());
					if (axelaActivity.getActivityEntryId() != 0) {
						map.put("activityEntryBy", axelaEmp.getEmpName() + " (" + axelaEmp.getEmpRefNo() + ")");
						map.put("activityEntryId", axelaActivity.getActivityEntryId() + "");
						map.put("activityEntryDate", strToLongDate(axelaActivity.getActivityEntryDatetime()));
					}
					if (axelaActivity.getActivityModifiedId() != 0) {
						map.put("activityModifiedBy", axelaEmp.getEmpName() + " (" + axelaEmp.getEmpRefNo() + ")");
						map.put("activityModifiedId", axelaActivity.getActivityModifiedId() + "");
						map.put("activityModifiedDate", strToLongDate(axelaActivity.getActivityModifiedDatetime()));
					}
					list.add(map);
					output.put("populateData", list);
				}
			}
		}
		return output;
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			if (!returnPerm("emp_activity_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			requestType = "";
			strSearch = "";
			page = 0;
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			List<AxelaActivity> activityList = null;
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			PageRequest request = null;
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			if (!inputObj.isNull("sortField")) {
				sortField = PadQuotes((inputObj.getString("sortField")));
			}
			if (!inputObj.isNull("pageIndex")) {
				page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
			}
			if (!inputObj.isNull("sortDirection")) {
				sortDirection = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
			}
			perPage = CNumeric(getSession("emp_recperpage", session));
			if (perPage.equals("0")) {
				perPage = "25";
			}
			if (sortDirection.equals("")) {
				sortDirection = "DESC";
			}
			if (sortField.equals("")) {
				sortField = "activityId";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			String strOrderBy = " ORDER BY activity." + sortField + " " + sortDirection;
			activityList = activityFilterImpl.findAllActivities(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			totalCount = Integer.parseInt(activityFilterImpl.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;

			// Start Header Data
			listHeader.add(produceHeaderData("ID", "activityId", "center"));
			listHeader.add(produceHeaderData("Type", "axelaActivityType.activitytypeName", "center"));
			listHeader.add(produceHeaderData("Title", "activityTitle", "center"));
			listHeader.add(produceHeaderData("Description", "activityDesc", "center"));
			listHeader.add(produceHeaderData("Status", "axelaActivityStatus.statusDesc", "center"));
			listHeader.add(produceHeaderData("Feedback", "activityFeedback", "center"));
			listHeader.add(produceHeaderData("Remark", "activityRemarks", "center"));
			listHeader.add(produceHeaderData("Executive", "axelaEmp.empName", "center"));
			listHeader.add(produceHeaderData("Start Time", "activityStartDatetime", "center"));
			listHeader.add(produceHeaderData("End Time", "activityEndDatetime", "center"));
			listHeader.add(produceHeaderData("Priority", "axelaActivityPriority.priorityName", "center"));
			listHeader.add(produceHeaderData("Contact", "activityPhone1", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));// serial
			listBodyAlign.add(produceBodyAlign("center"));// id
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaActivity obj : activityList) {
				ArrayList<String> param = new ArrayList<String>();
				ArrayList<String> actionParam1 = new ArrayList<String>();
				ArrayList<String> actionParam2 = new ArrayList<String>();
				ArrayList<String> actionParam3 = new ArrayList<String>();
				ArrayList<String> paramSubArr = new ArrayList<String>();
				ArrayList<ArrayList> paramArr = new ArrayList<ArrayList>();
				ArrayList type = new ArrayList();
				ArrayList value = new ArrayList();
				HashMap<String, List<HashMap>> mapData = new HashMap<String, List<HashMap>>();
				HashMap<String, List<HashMap>> mapAction = new HashMap<String, List<HashMap>>();
				HashMap<String, List<String>> mapBodyData = new HashMap<String, List<String>>();
				List<HashMap> listData = new ArrayList<HashMap>();
				count++;

				// #
				type.add(false);
				value.add(count);
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// ID
				type.add(false);
				value.add(obj.getActivityId());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// type
				type.add(false);
				value.add(obj.getActivitytypeName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// title
				type.add(true);
				value.add(obj.getActivityTitle());
				paramSubArr.add("activity");
				paramSubArr.add(strToShortDate(obj.getActivityStartDatetime()));
				paramArr.add(paramArr);
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				paramArr.clear();
				paramSubArr.clear();
				value.clear();

				// desc
				type.add(false);
				value.add(obj.getActivityDesc());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// status
				type.add(false);
				value.add(obj.getStatusDesc());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// feedback
				type.add(false);
				value.add(obj.getActivityFeedback());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// remark
				type.add(false);
				value.add(obj.getActivityRemarks());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// executive
				type.add(false);
				type.add(true);
				value.add("<img style='width:55px; height:55px; border-radius: 50%;' src='" + WSUrl() + "/portal/thumbnail?imgId=" + obj.getEmpId() + "&type=empImg&width=80&height=80'/>");
				value.add(obj.getEmpName() + " (" + obj.getEmpRefNo() + ")");
				paramSubArr.add("executiveSummary");
				paramSubArr.add(obj.getEmpId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				paramArr.clear();
				paramSubArr.clear();
				value.clear();

				// start tome
				type.add(false);
				value.add(strToLongDate(obj.getActivityStartDatetime()));
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// end time
				type.add(false);
				value.add(strToLongDate(obj.getActivityEndDatetime()));
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// priority
				type.add(false);
				value.add(obj.getPriorityName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				type.add(false);
				type.add(false);
				type.add(false);
				value.add(obj.getActivityContactPerson());
				value.add(obj.getActivityPhone1());
				value.add(obj.getActivityPhone2());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// End Body data

				mapData.put("td", listData);
				actionParam1.add("updateActivity");
				actionParam1.add(obj.getActivityId() + "");
				actionParam2.add("updateRemark");
				actionParam2.add(obj.getActivityId() + "");
				actionParam3.add("updateFeedback");
				actionParam3.add(obj.getActivityId() + "");
				mapAction.put("td", produceActionData(actionParam1, actionParam2, actionParam3));
				listAction.add(mapAction);
				listBody.add(mapData);
			}
			output.put("meta", mapNavi);
			output.put("thead", listHeader);
			output.put("tdalign", listBodyAlign);
			output.put("tbody", listBody);
			output.put("action", listAction);
			if (AppRun().equals("0")) {
				SOP("output==========ActivitiesService==========" + output.toString());
			}
		}
		return output;
	}

	private ArrayList<HashMap> produceActionData(ArrayList<String> actionParam1, ArrayList<String> actionParam2, ArrayList<String> actionParam3) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Activity");
		mapBodyData.put("param", actionParam1);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Update Remarks");
		mapBodyData.put("param", actionParam2);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Update Feedback");
		mapBodyData.put("param", actionParam3);
		listAction.add((HashMap) mapBodyData.clone());

		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		//

		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "activity.*"));
		list.add(buildSmartArr("Activity Id", "numeric", "activity.activityId"));
		list.add(buildSmartArr("Type", "text", "type.activitytypeName"));
		list.add(buildSmartArr("Priority", "text", "priority.priorityName"));
		list.add(buildSmartArr("Executive", "text", "emp.empName"));
		list.add(buildSmartArr("Contact", "text", ""));
		list.add(buildSmartArr("Title", "text", "activity.activityTitle"));
		list.add(buildSmartArr("Description", "text", "activity.activityDesc"));
		list.add(buildSmartArr("Start Time", "date", "activity.activityStartDatetime"));
		list.add(buildSmartArr("End Time", "date", "activity.activityEndDatetime)"));
		list.add(buildSmartArr("Phone1", "text", "activity.activityPhone1"));
		list.add(buildSmartArr("Phone2", "text", "activity.activityPhone2"));
		list.add(buildSmartArr("Venue", "text", "activity.activityVenue"));
		list.add(buildSmartArr("Status", "text", "activity.statusDesc"));
		list.add(buildSmartArr("Feedback", "text", "activity.activityFeedback"));
		list.add(buildSmartArr("Remarks", "text", "activity.activityRemarks"));
		// list.add(buildSmartArr("Entry Id", "numeric", "activity.activityEntryId"));
		list.add(buildSmartArr("Entry Date", "date", "activity.activityEntryDatetime"));
		// list.add(buildSmartArr("Modified Id", "numeric", "activity.activityModifiedId"));
		list.add(buildSmartArr("Modified Date", "date", "activity.activityModifiedDatetime"));
		list.add(buildSmartArr("Feedback Entry Id", "numeric", "activity.activityFeedbackEntryId"));
		list.add(buildSmartArr("Feedback Entry Date", "date", "activity.activityFeedbackEntryDatetime"));
		list.add(buildSmartArr("Remarks Entry Id", "numeric", "activity.activityRemarksEntryId"));
		list.add(buildSmartArr("Remarks Entry Date", "date", "activity.activityRemarksEntryDatetime"));
		output.put("drSmart", list.toArray());
		return output;
	}
}
