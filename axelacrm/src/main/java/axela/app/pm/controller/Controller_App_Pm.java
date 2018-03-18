package axela.app.pm.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import axela.app.pm.service.AppPmDashService;
import axela.app.pm.service.AppPmMilestoneService;
import axela.app.pm.service.AppPmService;
import axela.app.pm.service.AppTaskService;
import axela.app.pm.service.KanbanService;

@RestController
@RequestMapping("/app-pm")
@Scope("request")
public class Controller_App_Pm {
	@Autowired
	AppPmService appPmService;

	@Autowired
	AppTaskService appTaskService;

	@Autowired
	AppPmDashService appPmDashService;

	@Autowired
	KanbanService kanbanService;

	@Autowired
	AppPmMilestoneService appPmMilestoneService;

	@RequestMapping("/")
	public Map<String, String> test() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "AxelaCRM App Service test successfull!");
		return map;
	}

	@RequestMapping("/pm-list")
	public Map pmList(@RequestBody String input, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
		return appPmService.listData(input, session, response);
	}

	@RequestMapping("/task-list")
	public Map taskList(@RequestBody String input, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
		return appTaskService.listData(input, session);
	}

	@PostMapping("/pm")
	public Map pmUpdate(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, SQLException, ParseException {
		response.setStatus(201);
		return appPmService.pmAdd(input, request, response, session);
	}

	@PostMapping("/task")
	public Map taskUpdate(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, SQLException, ParseException {
		response.setStatus(201);
		return appTaskService.taskAdd(input, request, response, session);
	}

	@PostMapping("/pmmilestone")
	public Map pmmUpdate(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, SQLException, ParseException {
		response.setStatus(201);
		return appPmMilestoneService.pmmService(input, request, response, session);
	}

	@PostMapping("/pm-dash")
	public Map pmDash(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, SQLException, ParseException {
		response.setStatus(201);
		return appPmDashService.pmDash(input, request, response, session);
	}

	@PostMapping("/pm-kanban")
	public Map createprojectkanban(@RequestBody String input, HttpServletRequest request, HttpSession session) throws Exception {
		return kanbanService.KanBan(input, request, session);
	}
}
