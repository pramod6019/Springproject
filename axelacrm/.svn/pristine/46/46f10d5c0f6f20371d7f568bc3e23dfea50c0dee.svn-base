package axela.activities.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import axela.activities.repository.ActivityFilterImpl;
import axela.activities.service.ActivitiesService;
import axela.activities.service.ActivityStatusService;
import axela.activities.service.ActivityTypeService;

@RestController
@RequestMapping("/activities")
@CrossOrigin("*")
public class Controller_activities {

	@Autowired
	ActivityTypeService activityTypeService;

	@Autowired
	ActivityStatusService activitystatusservice;

	@Autowired
	ActivitiesService activitiesService;

	@Autowired
	ActivityFilterImpl activityFilterImpl;

	@RequestMapping("/test")
	public Map<String, String> JSONTest() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "Activities test successfull!");
		return map;
	}

	// master pages start

	@PostMapping("/activitystatus")
	public Map activityStatus(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		System.out.println("soe");
		return activitystatusservice.activityStatusService(input, session, response);
	}
	@PostMapping("/activitystatus-data")
	public Map activitystatusPopulateData(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return activitystatusservice.populateData(input);
	}
	@RequestMapping("/activitystatus-list")
	public Map activitystatusList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return activitystatusservice.listData(input, session);
	}
	@RequestMapping("/activitystatus-smartsearch")
	public Map activitystatusSmartList() throws JSONException {
		return activitystatusservice.populateDrSmart();
	}

	@PostMapping("/activitytype")
	public Map activitytype(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return activityTypeService.activityType(input, session, response);
	}
	@PostMapping("/activitytype-data")
	public Map activitytypepopulateData(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return activityTypeService.populateData(input);
	}
	@RequestMapping("/activitytype-list")
	public Map activitytypeList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return activityTypeService.listData(input, session);
	}
	@RequestMapping("/activitytype-smartsearch")
	public Map activityTypeServiceSmartList() throws JSONException {
		return activityTypeService.populateDrSmart();
	}

	// master pages end

	@PostMapping("/activities-list")
	public Map activitiesList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return activitiesService.listData(input, session);
	}

	@PostMapping("/activities")
	public Map<String, String> c(@RequestBody String input, HttpSession session, HttpServletResponse response) throws Exception {
		return activitiesService.activityService(input, session, response);
	}

	@PostMapping("/activities-data")
	public Map populateActivityData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return activitiesService.populateData(input, session);
	}

	@PostMapping("/activities-smartsearch")
	public Map activitiesSmartSearch(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return activitiesService.populateDrSmart();
	}

	@PostMapping("/activities-calender")
	public void activitiesCalender(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		activityFilterImpl.findAllActivityOpprFollowup("");
	}
}
