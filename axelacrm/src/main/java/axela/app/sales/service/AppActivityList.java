package axela.app.sales.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.activities.model.AxelaActivity;
import axela.activities.repository.ActivityFilterImpl;
import axela.config.Connect;

@Service
public class AppActivityList extends Connect {

	@Autowired
	private ActivityFilterImpl activityFilterImpl;

	private String startDate = "";
	private String activityEmpId = "";
	private String type = "";

	Map output = new HashMap();

	public Map ActivityList(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		JSONObject inputObj = new JSONObject(input);
		startDate = "";
		activityEmpId = "";
		type = "";
		if (!inputObj.isNull("activityEmpId")) {
			activityEmpId = PadQuotes(inputObj.getString("activityEmpId"));
		}
		if (!inputObj.isNull("startDate")) {
			startDate = inputObj.getString("startDate");
			SOP("startDate=====================" + stringToDate(startDate) + "");
		}
		if (!inputObj.isNull("type")) {
			type = PadQuotes(inputObj.getString("type"));
		}
		populateListData();
		return output;
	}

	private void populateListData() throws ParseException {
		Map map = new HashMap();
		List<Map> list = new ArrayList<Map>();
		String strFollowupSearch = "";
		String strContactSearch = "";
		if (type.equals("day")) {
			strFollowupSearch = " AND SUBSTRING(followup.followupFollowupTime, 1, 10) = SUBSTRING('" + dateToString(stringToDate(startDate)) + "', 1, 10)";
			strContactSearch = " AND SUBSTRING(contact.contactDob,  6, 5) = SUBSTRING('" + dateToString(stringToDate(startDate)) + "',  6, 5)";
		} else if (type.equals("month")) {
			strFollowupSearch = " AND SUBSTRING(followup.followupFollowupTime, 1, 8) >= SUBSTRING('" + dateToString(stringToDate(startDate)) + "', 1, 8)"
					+ " AND SUBSTRING(followup.followupFollowupTime, 1, 8) <= SUBSTRING('" + dateToString(stringToDate(startDate)) + "', 1, 8)";

			strContactSearch = " AND SUBSTRING(contact.contactDob, 6, 5) >= SUBSTRING('" + dateToString(stringToDate(startDate)) + "',  6, 5)"
					+ " AND SUBSTRING(contact.contactDob, 6, 5) <= SUBSTRING('" + dateToString(stringToDate(startDate)) + "',  6, 5)";
		}
		List<AxelaActivity> result = activityFilterImpl.activityFollowupData(activityEmpId, strFollowupSearch);
		for (AxelaActivity obj : result) {
			map = new HashMap();
			map.put("startTime", strToShortDate(obj.getStartTime()));
			map.put("endTime", strToShortDate(obj.getEndTime()));
			map.put("title", obj.getTitle());
			map.put("description", obj.getDescription());
			map.put("activityId", obj.getActivityId() + "");
			map.put("type", obj.getType());
			map.put("feedback", obj.getFeedback());
			map.put("contactMobile1", obj.getContactMobile1());
			list.add(map);
		}
		result = activityFilterImpl.activityBirthDayData(activityEmpId, startDate, strContactSearch);
		for (AxelaActivity obj : result) {
			map = new HashMap<String, String>();
			map.put("startTime", obj.getStartTime());
			map.put("endTime", obj.getEndTime());
			map.put("title", obj.getTitle());
			map.put("description", obj.getDescription());
			map.put("activityId", obj.getActivityId() + "");
			map.put("type", obj.getType());
			map.put("feedback", obj.getFeedback());
			map.put("contactMobile1", obj.getContactMobile1());
			list.add(map);
		}
		System.out.println("listdata======================" + list);
		output.put("listdata", list);
	}
}
