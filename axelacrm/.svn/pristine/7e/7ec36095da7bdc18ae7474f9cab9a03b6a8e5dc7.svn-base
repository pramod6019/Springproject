package axela.customer.controller;

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

import axela.customer.service.CustomerContactService;
import axela.customer.service.CustomerIndexService;
import axela.customer.service.CustomerService;
import axela.customer.service.GroupService;
import axela.customer.service.ReportContactAnniversaryService;
import axela.customer.service.ReportContactBirthdayService;
import axela.customer.service.ReportTopCustomersOverdueService;
import axela.customer.service.ReportTopCustomersPendingService;
import axela.customer.service.ReportTopCustomersService;
import axela.customer.service.TitleService;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class Controller_Customer {

	@Autowired
	ReportContactAnniversaryService reportContactAnniversaryService;

	@Autowired
	ReportContactBirthdayService reportContactBirthdayService;

	@Autowired
	ReportTopCustomersPendingService reportTopCustomersPendingService;

	@Autowired
	ReportTopCustomersOverdueService reportTopCustomersOverdueService;

	@Autowired
	ReportTopCustomersService reportTopCustomersService;

	@Autowired
	CustomerIndexService customerIndexService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	CustomerContactService customerContactService;

	@Autowired
	TitleService titleService;

	@Autowired
	GroupService groupService;

	@RequestMapping("/test")
	public Map<String, String> JSONTest(HttpSession session) {
		System.out.println("test");
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "AxelaCRM Customer test successfull!");
		return map;
	}

	// Customer add, update and delete
	@RequestMapping("/customer")
	public Map Customer(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, NumberFormatException, ParseException {
		System.out.println("controller input=============== ");
		System.out.println(input);
		return customerService.customerService(input, request, response, session);
	}

	// Populate Customer Data Based On customer Id
	@RequestMapping("/customer-data")
	public Map CustomerCustomerData(@RequestBody String input, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		return customerService.populateData(input, session);
	}

	// To Get Customer_List
	@RequestMapping("/customer-list")
	public Map CustomerList(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return customerService.listData(input, session);
	}

	// To Customer Smart Search
	@RequestMapping("/customer-smartsearch")
	public Map populateDrSmart(HttpSession session) {
		return customerService.populateDrSmart(session);
	}

	@RequestMapping("/contact")
	public Map contactUpdate(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		System.out.println("input==================");
		return customerContactService.contactService(input, request, response, session);
	}

	@RequestMapping("/contact-list")
	public Map CustomerContactList(@RequestBody String input, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		return customerContactService.listData(input, response, session);
	}

	@RequestMapping("/contact-data")
	public Map CustomerContactData(@RequestBody String input, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		return customerContactService.populateContactData(input, response, session);
	}

	@RequestMapping("/contact-smartsearch")
	public Map contactSmartsearch(@RequestBody String input, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		return customerContactService.populateDrSmart();
	}

	@PostMapping("/group")
	public Map<String, String> group(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return groupService.groupService(input, session, response);
	}

	@PostMapping("/group-list")
	public Map groupList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return groupService.listData(input, session, response);
	}
	@PostMapping("/group-data")
	public Map groupData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return groupService.populateData(input);
	}

	@PostMapping("/group-smartsearch")
	public Map groupDataDrSmartSearch() throws JSONException {
		return groupService.populateDrSmart();
	}

	@PostMapping("/title")
	public Map<String, String> title(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		System.out.println("title");
		return titleService.titleService(input, session, response);
	}

	@PostMapping("/title-list")
	public Map titleList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return titleService.listData(input, session, response);
	}

	@PostMapping("/title-data")
	public Map populateTitleList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return titleService.populateData(input);
	}

	@PostMapping("/title-smartsearch")
	public Map titleDataDrSmartSearch() throws JSONException {
		return titleService.populateDrSmart();
	}

	// report pages start
	@PostMapping("/report-topcustomers")
	public Map topCustomersService(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return reportTopCustomersService.reportTopCustomersDash(input, session, response);
	}

	@PostMapping("/report-topcustomersoverdue")
	public Map topcustomersoverdue(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return reportTopCustomersOverdueService.reportTopCustomersOverdueService(input, session, response);
	}

	@PostMapping("/report-topcustomerspending")
	public Map topcustomerspending(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return reportTopCustomersPendingService.reportTopCustomersPendingService(input, session, response);
	}

	@PostMapping("/report-contactbirthday")
	public Map contactbirthday(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return reportContactBirthdayService.reportTopCustomersDash(input, session, response);
	}

	@PostMapping("/report-contactanniversary")
	public Map contactanniversary(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return reportContactAnniversaryService.reportContactAnniversaryService(input, session, response);
	}

	// report pages end

	// // customer dash start
	// @PostMapping("/customerdash")
	// public List customerDash(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
	// return customerDashService.customerDashService(input, session, response);
	// }
	// customer dash end

	@PostMapping("/customerindex")
	public Map customerIndex(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return customerIndexService.customerIndexService(input, session);
	}

}
