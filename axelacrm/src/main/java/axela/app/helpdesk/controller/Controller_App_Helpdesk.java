package axela.app.helpdesk.controller;

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

import axela.app.helpdesk.service.AppTicketService;

@RestController
@RequestMapping("/app-helpdesk")
@Scope("request")
public class Controller_App_Helpdesk {

	@Autowired
	AppTicketService ticketservice;

	@RequestMapping("/")
	public Map<String, String> test() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "AxelaCRM App Service test successfull!");
		return map;
	}

	@PostMapping("/ticket")
	public Map ticketUpdate(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, SQLException, ParseException {
		return ticketservice.ticketAdd(input, request, response, session);
	}

	@RequestMapping("/ticket-list")
	public Map TicketList(@RequestBody String input, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws Exception {
		return ticketservice.listData(input, session, response, request);
	}

	@RequestMapping("/ticket-dash")
	public Map jobcardDash(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, SQLException, ParseException {
		return ticketservice.ticketDashpage(input, session, response, request);
	}

}
