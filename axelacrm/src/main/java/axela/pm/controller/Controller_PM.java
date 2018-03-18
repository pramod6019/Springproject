//sharath 
package axela.pm.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import axela.pm.service.PmService;
import axela.pm.service.TaskDashService;
import axela.pm.service.TaskService;

@RestController
@RequestMapping("/pm")
@CrossOrigin("*")
public class Controller_PM {

	@Autowired
	PmService pmService;

	@Autowired
	TaskService taskService;

	@Autowired
	TaskDashService taskDashService;

	@RequestMapping("/test")
	public Map<String, String> JSONTest() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "AxelaCRM PM test successfull!");
		return map;
	}

	@PostMapping("/pm")
	public Map pmService(@RequestBody String input, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws JSONException, ParseException {
		// response.setStatus(201);
		System.out.println("pmmmmmmm");
		return pmService.pmService(input, request, response, session);
	}

	@PostMapping("/task")
	public Map taskService(@RequestBody String input, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws JSONException, ParseException {
		// response.setStatus(201);
		System.out.println("pmmmmmmm");
		return taskService.taskService(input, request, response, session);
	}

	@RequestMapping("/task-dash")
	public Map jobcardDash(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		return taskDashService.taskServiceUpdate(input, request, response, session);
	}

}
