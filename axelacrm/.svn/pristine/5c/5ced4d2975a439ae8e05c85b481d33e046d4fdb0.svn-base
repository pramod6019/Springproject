package axela.portal.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import axela.customer.repository.CustomerFilterImpl;
import axela.helpdesk.service.TicketCategoryService;
import axela.helpdesk.service.TicketStatusService;
import axela.helpdesk.service.TicketTypeService;
import axela.inventory.repository.InventoryFilterImp;
import axela.portal.repository.EmpFilterImpl;
import axela.portal.repository.PortalFilterImpl;
import axela.portal.service.BranchService;
import axela.portal.service.CustomerConfigService;
import axela.portal.service.ExecutiveAccessService;
import axela.portal.service.ExecutiveService;
import axela.portal.service.ItemGroupService;
import axela.portal.service.SigninService;
import axela.portal.service.SystemThemeService;
import axela.portal.service.ThumbnailService;
import axela.portal.service.TypeService;
import axela.sales.service.CampaignService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/portal")
@CrossOrigin("*")
public class Controller_Portal {

	@Autowired
	ExecutiveService executiveService;

	@Autowired
	ExecutiveAccessService executiveAccessService;

	@Autowired
	EmpFilterImpl empFilterImpl;

	@Autowired
	PortalFilterImpl portalFilterImpl;

	@Autowired
	TicketCategoryService ticketCategoryService;

	@Autowired
	TicketStatusService ticketStatusService;

	@Autowired
	CustomerFilterImpl customerFilterImpl;

	@Autowired
	ThumbnailService thumbnailService;

	@Autowired
	SigninService loginService;

	@Autowired
	public HttpSession session;

	@Autowired
	public ItemGroupService itemgroupservice;

	@Autowired
	public CampaignService campaignService;

	@Autowired
	TicketTypeService ticketTypeService;

	@Autowired
	public TypeService typeservice;

	@Autowired
	public BranchService branchService;

	@Autowired
	CustomerConfigService customerConfigService;

	@Autowired
	SystemThemeService systemThemeService;

	@Autowired
	InventoryFilterImp inventoryFilterImp;

	@GetMapping("/test")
	public Map<String, String> JSONTest() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "AxelaCRM Portal Module Test Successfull!");
		return map;
	}

	@PostMapping("/signin")
	public Map<String, String> signin(@RequestBody String input, SessionStatus status, HttpSession session) throws Exception {
		return loginService.SigninService(input);
	}

	@GetMapping("/checksession")
	public Map success(HttpSession session, HttpServletResponse response) {
		Map<String, String> map = new HashMap<String, String>();
		if (session.isNew()) {
			session.invalidate();
			response.setStatus(400);
		} else {
			response.setStatus(200);
			map.put("session", "ok");
		}
		System.out.println("session====success==========" + session.getId());
		System.out.println("session====user_name==========" + session.getAttribute("user_name"));
		return map;
	}

	// @PostMapping("/signin-test")
	// public void signinTest(@RequestBody String input, SessionStatus status, HttpSession session) throws JSONException {
	// System.out.println("session=====signin-test=======portal=====" + session.getId());
	// }

	// @RequestMapping(value = "/signin-test", method = RequestMethod.POST)
	// public String signinTest(Model model, HttpServletResponse response, @RequestBody String input, HttpSession session) throws JSONException, UnknownHostException {
	// return loginService.SigninTest(input, session, model);
	// }

	@GetMapping("/signout")
	public Map<String, String> logoutTest(@RequestParam("access_token") String access_token, SessionStatus status, HttpSession session) throws JSONException {
		return loginService.SignOut(status, session);
	}

	@RequestMapping("/thumbnail")
	public byte[] getImage(WebRequest webrequest, HttpServletResponse response, HttpSession session) throws Exception {
		// System.out.println("session===get-image=====");
		return thumbnailService.imagedata(webrequest, response, session);

	}
	@PostMapping("/branch")
	public Map<String, String> branch(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return branchService.branchService(input, session, response);
	}

	@PostMapping("/branch-data")
	public Map contractData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return branchService.populateBranchData(input, session, response);
	}

	@PostMapping("/branch-list")
	public Map branchList(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return branchService.listData(input, session);
	}

	@PostMapping("/branch-smartsearch")
	public Map branchDataDrSmartSearch() throws JSONException {
		return branchService.populateDrSmart();
	}

	@PostMapping("/tickettype")
	public Map tickettype(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketTypeService.ticketTypeService(input, session, response);
	}
	@PostMapping("/tickettype-list")
	public Map tickettypeList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketTypeService.listData(input, session, response);
	}
	@PostMapping("/tickettype-data")
	public Map tickettypeData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return ticketTypeService.populateData(input);
	}

	@PostMapping("/tickettype-smartsearch")
	public Map tickettypeDataDrSmartSearch() throws JSONException {
		return ticketTypeService.populateDrSmart();
	}

	// @PostMapping("/crmdays")
	// public Map crmdays(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
	// return salesCrmdayService.salesCrmdayService(input, session, response);
	// }
	// @PostMapping("/crmdays-data")
	// public Map crmdaysData(@RequestBody String input, HttpSession session) throws JSONException {
	// return brochureservice.populateData(input);
	// }
	// @RequestMapping("/crmdays-list")
	// public Map crmdaysList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
	// return salesCrmdayService.listData(input, session);
	// }

	@PostMapping("/systemtheme")
	public Map systemTheme(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return systemThemeService.systemThemeService(input, session, response);
	}

	@PostMapping("/config-customer")
	public Map configCustomer(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return customerConfigService.customerConfigService(input, session, response);
	}
	@PostMapping("/config-customer-data")
	public Map customerData(@RequestBody String input, HttpSession session) throws JSONException {
		return customerConfigService.populateData(input);
	}

	@PostMapping("/accessrights")
	public List accessrights(@RequestBody String input, HttpSession session) throws JSONException {
		return executiveAccessService.listData(input, session);
	}

	@PostMapping("/accessrights-update")
	public Map accessrightsUpdate(@RequestBody String input, HttpSession session) throws JSONException {
		return executiveAccessService.updateExecutive(input, session);
	}

	@PostMapping("/executive")
	public Map<String, String> executive(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return executiveService.executiveService(input, session, response);
	}

	@PostMapping("/executive-data")
	public Map populateData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return executiveService.populateData(input, session, response);
	}

	@PostMapping("/executive-list")
	public Map listData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return executiveService.listData(input, session);
	}

	@PostMapping("/executive-smartsearch")
	public Map executiveSmartSearch(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return executiveService.populateDrSmart();
	}

	
	@PostMapping("/executive-summary")
	public Map executiveSummary(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return executiveService.executiveSummary(input);
	}

}
