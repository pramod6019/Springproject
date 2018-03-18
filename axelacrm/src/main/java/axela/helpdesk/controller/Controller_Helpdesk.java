///sharath 
package axela.helpdesk.controller;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
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

import axela.helpdesk.service.FaqService;
import axela.helpdesk.service.HelpDeskIndexService;
import axela.helpdesk.service.ReportTicketDashboardService;
import axela.helpdesk.service.TicketCategoryService;
import axela.helpdesk.service.TicketDashService;
import axela.helpdesk.service.TicketHolidayService;
import axela.helpdesk.service.TicketQueueService;
import axela.helpdesk.service.TicketService;
import axela.helpdesk.service.TicketStatusService;
import axela.helpdesk.service.TicketTypeService;

@RestController
@RequestMapping("/helpdesk")
@CrossOrigin("*")
public class Controller_Helpdesk {
	@Autowired
	TicketTypeService ticketTypeService;

	@Autowired
	TicketStatusService ticketStatusService;

	@Autowired
	TicketCategoryService ticketCategoryService;

	@Autowired
	TicketQueueService ticketQueueService;

	@Autowired
	private TicketService ticketService;

	@Autowired
	FaqService faqService;

	@Autowired
	HelpDeskIndexService helpDeskIndexService;

	@Autowired
	TicketDashService ticketdashservice;

	@Autowired
	TicketHolidayService ticketHolidayService;

	@Autowired
	ReportTicketDashboardService reportTicketDashboardService;

	@RequestMapping("/test")
	public Map<String, String> JSONTest() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "AxelaCRM Service test successfull!");
		return map;
	}

	// add, update and delete
	@PostMapping("/ticket")
	public Map ticket(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, SQLException, ParseException {
		return ticketService.ticketService(input, request, response, session);
	}

	@PostMapping("/ticket-data")
	public Map ticketData(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return ticketService.populateData(input, session);
	}

	@PostMapping("/ticket-list")
	public Map ticketList(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		System.out.println("input=====" + input);
		return ticketService.listData(input, session);
	}

	@RequestMapping("/ticket-smartsearch")
	public Map ticketList(HttpSession session) throws JSONException {
		// response.sssssetStatus(201);
		return ticketService.populateDrSmart(session);
	}

	@PostMapping("/searchcontact")
	public Map searchContact(@RequestBody String input, HttpSession session) throws JSONException {
		return ticketService.searchContact(input, session);
	}

	@RequestMapping("/ticket-dash")
	public Map ticketdash(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		return ticketdashservice.ticketServiceUpdate(input, request, response, session);
	}

	@PostMapping("/faq")
	public Map faqService(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return faqService.faqService(input, session, response);
	}

	@RequestMapping("/faq-list")
	public Map faqList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		// response.sssssetStatus(201);
		return faqService.listData(input, session);
	}

	@PostMapping("/faq-data")
	public Map faqData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return faqService.populateData(input, session, response);
	}

	@RequestMapping("/faq-smartsearch")
	public Map faqList() throws JSONException {
		// response.sssssetStatus(201);
		return faqService.populateDrSmart();
	}

	@PostMapping("/index")
	public Map index(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return helpDeskIndexService.helpDeskIndex(input, session, response);
	}
	@PostMapping("/index-list")
	public Map indexList(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return helpDeskIndexService.ListReports();
	}

	@PostMapping("/ticketholiday")
	public Map ticketholiday(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, SQLException, ParseException {
		return ticketHolidayService.ticketHolidayService(input, request, response, session);
	}

	@PostMapping("/ticketholiday-list")
	public Map ticketholidayList(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, SQLException, ParseException {
		return ticketHolidayService.holidayList(input, session);
	}

	@PostMapping("/ticketholiday-data")
	public Map ticketholidayData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketHolidayService.populateData(input, session, response);
	}

	@PostMapping("/ticketholiday-smartsearch")
	public Map ticketholidayDrSmart(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketHolidayService.populateDrSmart(session);
	}

	// master pages start
	// helpdeskTicketQueue

	@PostMapping("/ticketqueue")
	public Map ticketqueue(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketQueueService.ticketQueueService(input, session, response);
	}
	@PostMapping("/ticketqueue-list")
	public Map ticketqueueList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketQueueService.listData(input, session, response);
	}
	@PostMapping("/ticketqueue-data")
	public Map ticketqueueData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketQueueService.populateData(input, session, response);
	}
	@PostMapping("/ticketqueue-smartsearch")
	public Map ticketqueueDrSmart(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketQueueService.populateDrSmart(session);
	}

	// helpdesk category
	@PostMapping("/helpdeskcategory")
	public Map helpdeskCategory(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketCategoryService.ticketCategoryService(input, session, response);
	}
	@PostMapping("/helpdeskcategory-list")
	public Map helpdeskCategoryList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketCategoryService.listData(input, session, response);
	}
	@PostMapping("/helpdeskcategory-data")
	public Map helpdeskCategoryData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketCategoryService.populateData(input);
	}
	@PostMapping("/helpdeskcategory-smartsearch")
	public Map helpdeskDrSmart(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketCategoryService.populateDrSmart();
	}

	// helpdesk type

	@PostMapping("/helpdesktype")
	public Map helpdeskType(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketTypeService.ticketTypeService(input, session, response);
	}
	@PostMapping("/helpdesktype-list")
	public Map helpdeskTypeList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketTypeService.listData(input, session, response);
	}
	@PostMapping("/helpdesktype-data")
	public Map helpdeskTypeData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketTypeService.populateData(input);
	}
	@PostMapping("/helpdesktype-smartsearch")
	public Map helpdeskTypeDrSmart(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketTypeService.populateDrSmart();
	}
	// helpdesk status
	@PostMapping("/helpdeskstatus")
	public Map helpdeskStatus(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketStatusService.ticketstatusservice(input, session, response);
	}
	@PostMapping("/helpdeskstatus-list")
	public Map helpdeskStatusList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketStatusService.listData(input, session, response);
	}
	@PostMapping("/helpdeskstatus-data")
	public Map helpdeskStatusData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketStatusService.populateData(input);
	}

	@PostMapping("/helpdeskstatus-smartsearch")
	public Map helpdeskStatusDrSmart(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketStatusService.populateDrSmart();
	}

	// master pages end

	// Report pages start
	@PostMapping("/report-ticket-dashboard")
	public Map ticketDashboardService(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException, UnsupportedEncodingException {
		return reportTicketDashboardService.reportTicketDashboard(input, session, response);
	}

}
