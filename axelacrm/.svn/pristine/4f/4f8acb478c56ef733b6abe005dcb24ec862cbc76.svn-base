package axela.app.service.controller;

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

import axela.app.service.service.JobCardAppService;
import axela.app.service.service.WS_VoucherService;

@RestController
@RequestMapping("/app-service")
@Scope("request")
public class Controller_App_Service {

	@Autowired
	JobCardAppService jobCardService;

	@Autowired
	WS_VoucherService VoucherService;

	@RequestMapping("/")
	public Map<String, String> test() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "AxelaCRM App Service test successfull!");
		return map;
	}

	@PostMapping("/jobcard")
	public Map jobcardUpdate(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, SQLException, ParseException {
		response.setStatus(201);
		return jobCardService.jobcardAdd(input, request, response, session);
	}

	@PostMapping("/jcserialno")
	public Map jobcardSearch(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return jobCardService.jobcardSearch(input, response);
	}

	@PostMapping("/jcmobile1")
	public Map jobcardSearch1(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return jobCardService.jobcardSearch(input, response);
	}

	@PostMapping("/jcemail1")
	public Map jobcardSearch2(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return jobCardService.jobcardSearch(input, response);
	}

	@RequestMapping("/jobcard-list")
	public Map JobCartList(@RequestBody String input, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
		return jobCardService.listData(input, session, response, request);
	}

	@RequestMapping("/jobcard-dash")
	public Map jobcardDash(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, SQLException, ParseException {
		return jobCardService.jcDashPage(input, session, response, request);
	}
	@RequestMapping("/voucher-list")
	public Map VoucherList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws Exception {
		return VoucherService.listData(input, session, response);
	}
}
