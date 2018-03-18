//sharath 
package axela.sales.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import axela.config.Connect;
import axela.sales.repository.SalesTeamRepository;
import axela.sales.repository.TeamFilterImpl;
import axela.sales.service.BrochureService;
import axela.sales.service.CampaignService;
import axela.sales.service.CampaignTypeService;
import axela.sales.service.DelStatusService;
import axela.sales.service.DestinationService;
import axela.sales.service.FinancecompanyService;
import axela.sales.service.FollowupDescService;
import axela.sales.service.OpprDashService;
import axela.sales.service.OpprService;
import axela.sales.service.PriorityService;
import axela.sales.service.ReportSOEDashService;
import axela.sales.service.SalesDashBoardService;
import axela.sales.service.SalesTargetService;
import axela.sales.service.SobService;
import axela.sales.service.SoeService;
import axela.sales.service.StageService;
import axela.sales.service.TeamService;
import axela.sales.service.WFDocService;

@RestController
@RequestMapping("/sales")
@CrossOrigin("*")
@Transactional
public class Controller_Sales {

	@Autowired
	private OpprService opprService;

	@Autowired
	public ReportSOEDashService reportSOEDashService;

	@Autowired
	private CampaignService campainService;

	@Autowired
	private TeamService teamService;

	@Autowired
	private SalesTargetService salesTargetService;

	@Autowired
	public OpprDashService opprDashService;

	@Autowired
	SoeService soeservice;

	@Autowired
	StageService stageservice;

	@Autowired
	SobService sobservice;

	@Autowired
	DestinationService destinationservice;

	@Autowired
	PriorityService priorityservice;

	@Autowired
	DelStatusService delstatusservice;

	@Autowired
	WFDocService wfdocservice;

	@Autowired
	FinancecompanyService financecompanyService;

	@Autowired
	BrochureService brochureservice;

	@Autowired
	public FollowupDescService followupdescservice;

	@Autowired
	public TeamFilterImpl teamFilterImpl;

	@Autowired
	public SalesDashBoardService salesDashBoardService;

	@Autowired
	public CampaignTypeService campaigntypeservice;

	@RequestMapping("/test")
	public Map<String, String> JSONTest() throws ParseException {

		// teamFilterImpl.findByTeam(1);
		Map<String, String> map = new HashMap<String, String>();
		Connect connect = new Connect();
		connect.stringToDate("");
		map.put("message", "AxelaCRM Sales test successfull!");
		return map;
	}

	@RequestMapping("/sales-dashboard")
	public Map salesDashBoard(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		return salesDashBoardService.SalesIndex(session, request, response, input);
	}

	@RequestMapping("/opportunity")
	public Map customerUpdate(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		return opprService.opprServiceUpdate(input, request, response, session);
	}

	@PostMapping("/opportunity-search")
	public Map opportunitySearch(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return opprService.opportunitySearch(input, response);
	}

	@RequestMapping("/opportunity-data")
	public Map opportunityData(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		return opprService.populateData(input, session, response);
	}

	@RequestMapping("/opportunity-dash")
	public Map opportunityDash(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		return opprDashService.opprServiceUpdate(input, request, response, session);
	}

	@RequestMapping("/opportunity-list")
	public Map opportunityList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return opprService.listData(input, session);
	}

	@RequestMapping("/opportunity-smartsearch")
	public Map opportunitySmartSearch(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException {
		return opprService.populateDrSmart(session);
	}

	@RequestMapping("/target-list")
	public Map tagetList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return salesTargetService.listData(input, session);
	}

	@PostMapping("/target-model-list")
	public Map tagetModalList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return salesTargetService.listModalData(input, session);
	}

	@PostMapping("/sales-target")
	public Map saleTarget(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return salesTargetService.targetService(input, session, response);
	}

	@RequestMapping("/team-list")
	public Map teamList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return teamService.listData(input, session);
	}

	@PostMapping("/team")
	public Map salesTeam(@RequestBody String input, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws JSONException, ParseException {
		return teamService.salesTeam(input, session, request, response);
	}

	@PostMapping("/team-data")
	public Map teamPopulateData(@RequestBody String input, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws JSONException, ParseException {
		return teamService.populateData(input);
	}

	@PostMapping("/campaign-list")
	public Map salesCampainList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return campainService.listData(input, session);
	}

	@PostMapping("/campaign")
	public Map campaign(@RequestBody String input, HttpSession session, HttpServletResponse response) throws Exception {
		return campainService.campaignService(input, session, response);
	}

	@PostMapping("/campaign-data")
	public Map salesCampainData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return campainService.populateData(input, session);
	}

	// report pages

	@PostMapping("/report-soedash")
	public Map salesSoeDash(@RequestBody String input, HttpServletRequest request, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return reportSOEDashService.opprServiceUpdate(input, request, response, session);
	}

	// Sales master pages

	@PostMapping("/soe")
	public Map soe(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return soeservice.soeService(input, session, response);
	}

	@RequestMapping("/soe-list")
	public Map soeList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return soeservice.listData(input, session);
	}

	@PostMapping("/soe-data")
	public Map populateData(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return soeservice.populateData(input);
	}

	@RequestMapping("/soe-smartsearch")
	public Map soeSmartList() throws JSONException {
		return soeservice.populateDrSmart();
	}

	@PostMapping("/sob")
	public Map sob(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return sobservice.sobService(input, session, response);
	}

	@RequestMapping("/sob-list")
	public Map sobList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return sobservice.listData(input, session);
	}

	@PostMapping("/sob-data")
	public Map sobpopulateData(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return sobservice.populateData(input);
	}

	@RequestMapping("/sob-smartsearch")
	public Map sobSmartList() throws JSONException {
		return sobservice.populateDrSmart();
	}

	@PostMapping("/campaigntype")
	public Map campaignType(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return campaigntypeservice.campaignTypeService(input, session, response);
	}

	@PostMapping("/campaigntype-data")
	public Map campaignTypeData(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return campaigntypeservice.populateData(input);
	}

	@RequestMapping("/campaigntype-list")
	public Map campaignTypeList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return campaigntypeservice.listData(input, session, response);
	}

	@RequestMapping("/campaigntype-smartsearch")
	public Map campaignTypeSmartList() throws JSONException {
		return campaigntypeservice.populateDrSmart();
	}

	@PostMapping("/stage")
	public Map stage(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return stageservice.stageService(input, session, response);
	}

	@PostMapping("/stage-data")
	public Map stageData(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return stageservice.populateData(input);
	}

	@RequestMapping("/stage-list")
	public Map stageList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return stageservice.listData(input, session);
	}

	@RequestMapping("/stage-smartsearch")
	public Map stageSmartList() throws JSONException {
		return stageservice.populateDrSmart();
	}

	@PostMapping("/destination")
	public Map destination(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return destinationservice.DestinationService(input, session, response);
	}

	@PostMapping("/destination-data")
	public Map destinationpopulateData(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return destinationservice.populateData(input);
	}

	@RequestMapping("/destination-list")
	public Map destinationList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return destinationservice.listData(input, session);
	}

	@RequestMapping("/destination-smartsearch")
	public Map destinationServiceSmartList() throws JSONException {
		return destinationservice.populateDrSmart();
	}

	@PostMapping("/delstatus")
	public Map delstatus(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return delstatusservice.delStatusService(input, session, response);
	}

	@PostMapping("/delstatus-data")
	public Map delstatuspopulateData(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return delstatusservice.populateData(input);
	}

	@RequestMapping("/delstatus-list")
	public Map delstatusList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return delstatusservice.listData(input, session);
	}

	@RequestMapping("/delstatus-smartsearch")
	public Map delstatusServiceSmartList() throws JSONException {
		return delstatusservice.populateDrSmart();
	}

	@PostMapping("/head")
	public Map head(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return financecompanyService.financecompanyService(input, session, response);
	}

	@PostMapping("/head-data")
	public Map headpopulateData(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return financecompanyService.populateData(input);
	}

	@RequestMapping("/head-list")
	public Map headList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return financecompanyService.listData(input, session);
	}

	@RequestMapping("/head-smartsearch")
	public Map headServiceSmartList() throws JSONException {
		return financecompanyService.populateDrSmart();
	}

	@PostMapping("/priority")
	public Map priority(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return priorityservice.priorityService(input, session, response);
	}

	@PostMapping("/priority-data")
	public Map priorityData(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return priorityservice.populateData(input);
	}

	@RequestMapping("/priority-list")
	public Map priorityList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return priorityservice.listData(input, session);
	}

	@RequestMapping("/priority-smartsearch")
	public Map prioritySmartList() throws JSONException {
		return priorityservice.populateDrSmart();
	}

	@PostMapping("/brochure")
	public Map brochure(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return brochureservice.brochureService(input, session, response);
	}

	@PostMapping("/brochure-data")
	public Map brochureData(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return brochureservice.populateData(input);
	}

	@RequestMapping("/brochure-list")
	public Map brochureList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return brochureservice.listData(input, session);
	}

	@RequestMapping("/brochure-smartsearch")
	public Map brochureSmartList() throws JSONException {
		LinkedHashMap output = new LinkedHashMap();
		return output;
	}

	@PostMapping("/wfdoc")
	public Map wfdoc(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return wfdocservice.wfdocService(input, session, response);
	}

	@PostMapping("/wfdoc-data")
	public Map wfdocData(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return wfdocservice.populateData(input);
	}

	@RequestMapping("/wfdoc-list")
	public Map wfdocList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return wfdocservice.listData(input, session);
	}

	@RequestMapping("/wfdoc-smartsearch")
	public Map wfdocSmartList() throws JSONException {
		return wfdocservice.populateDrSmart();
	}

	@PostMapping("/followupdesc")
	public Map followupdesc(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return followupdescservice.followupDescService(input, session, response);
	}

	@PostMapping("/followupdesc-data")
	public Map followupdescData(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return followupdescservice.populateData(input);
	}

	@RequestMapping("/followupdesc-list")
	public Map followupdescList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return followupdescservice.listData(input, session);
	}

	@RequestMapping("/followupdesc-smartsearch")
	public Map followupdescSmartList() throws JSONException {
		return followupdescservice.populateDrSmart();
	}
}
