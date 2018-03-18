///sharath 
package axela.service.controller;

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

import axela.helpdesk.service.TicketService;
import axela.service.service.AssetBrandService;
import axela.service.service.AssetService;
import axela.service.service.AssetTypeService;
import axela.service.service.CatagoriesService;
import axela.service.service.ContractLocationService;
import axela.service.service.ContractPriorityService;
import axela.service.service.ContractService;
import axela.service.service.ContractServiceTypeService;
import axela.service.service.ContractTypeService;
import axela.service.service.JCService;
import axela.service.service.JobCardCategoryService;
import axela.service.service.JobCardCheckListService;
import axela.service.service.JobCardPriorityService;
import axela.service.service.JobCardStatusService;
import axela.service.service.JobCardTypeService;
import axela.service.service.JobcardDashService;
import axela.service.service.ManHourService;
import axela.service.service.ReportJobCardProductivityService;
import axela.service.service.ServiceConfigService;
import axela.service.service.ServiceIndex;

@RestController
@RequestMapping("/service")
@CrossOrigin("*")
public class Controller_Service {
	@Autowired
	ContractServiceTypeService contractServiceTypeService;

	@Autowired
	ContractTypeService contractTypeService;

	@Autowired
	ContractPriorityService contractPriorityService;

	@Autowired
	AssetBrandService assetBrandService;

	@Autowired
	AssetTypeService assetTypeService;

	@Autowired
	public JobCardCategoryService jobcartcategoryservice;

	@Autowired
	public JobCardTypeService jobcarttypeservice;

	@Autowired
	public JobCardPriorityService jobCardPriorityService;

	@Autowired
	public JobCardStatusService jobCartStatusService;

	@Autowired
	private TicketService ticketService;

	@Autowired
	public AssetService assetservice;

	@Autowired
	ContractLocationService contractLocationService;

	@Autowired
	CatagoriesService catagoriesService;

	@Autowired
	public ContractService contractService;

	@Autowired
	ManHourService manHourService;

	@Autowired
	JCService jCService;

	@Autowired
	JobcardDashService jobcarddashservice;

	@Autowired
	ServiceIndex serviceIndex;

	@Autowired
	JobCardCheckListService jobCardCheckListService;

	@Autowired
	ReportJobCardProductivityService reportJobCardProductivityService;

	@Autowired
	public ServiceConfigService serviceConfigService;

	// @Autowired
	// ReportMonitoringBoardService reportMonitoringBoardService;

	@RequestMapping("/test")
	public Map<String, String> JSONTest() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "AxelaCRM Service test successfull!");
		return map;
	}

	// add, update and delete
	@PostMapping("/ticket")
	public Map<String, String> ticket(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, SQLException, ParseException {
		return ticketService.ticketService(input, request, response, session);
	}

	@PostMapping("/ticket-list")
	public Map ticketList(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return ticketService.listData(input, session);
	}

	@PostMapping("/asset")
	public Map asset(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return assetservice.assetsService(input, session, response);
	}

	@PostMapping("/asset-data")
	public Map assetData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return assetservice.populateAssetData(input, session, response);
	}

	@RequestMapping("/asset-smartsearch")
	public Map assetSmartSearch(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException {
		return assetservice.populateDrSmart(session);
	}

	@PostMapping("/asset-list")
	public Map assetList(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return assetservice.listData(input, session);
	}

	@PostMapping("/searchcontact")
	public Map searchContact(@RequestBody String input, HttpSession session) throws JSONException {
		return ticketService.searchContact(input, session);
	}

	@PostMapping("/holiday-list")
	public Map holidayList(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return ticketService.listData(input, session);
	}

	@PostMapping("/contract")
	public Map contract(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return contractService.contractsService(input, session, response);
	}

	@PostMapping("/contract-list")
	public Map contractList(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return contractService.listData(input, session);
	}

	@PostMapping("/contact-customerdetails")
	public Map contractDetails(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return contractService.populateContractDetails(input, response);
	}

	@RequestMapping("/contract-smartsearch")
	public Map opportunitySmartSearch(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException {
		return contractService.populateDrSmart(session);
	}

	@PostMapping("/contract-data")
	public Map contractData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return contractService.populateContractData(input, session, response);
	}

	@PostMapping("/location-list")
	public Map ContractLocationList(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return contractLocationService.listData(input, session);
	}

	@PostMapping("/categories-list")
	public Map serviceCategoriesList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return catagoriesService.listData(input, session);
	}

	@RequestMapping("/jobcard-list")
	public Map jobcardList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return jCService.listData(input, session);
	}
	@PostMapping("/jobcard")
	public Map jobcardService(@RequestBody String input, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws JSONException, ParseException {
		return jCService.jobCardService(input, request, response, session);
	}

	@RequestMapping("/jobcard-dash")
	public Map jobcardDash(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		return jobcarddashservice.jobcardServiceUpdate(input, request, response, session);
	}

	@PostMapping("/jobcard-data")
	public Map jobcardData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		System.out.println("==inside=111111====jobcardData=========");
		return jCService.populateData(input, session, response);
	}

	@RequestMapping("/jobcard-smartsearch")
	public Map jobcardsmartSearch() throws JSONException {
		// response.sssssetStatus(201);
		return jCService.populateDrSmart();
	}

	@PostMapping("/contractlocation")
	public Map locationDetails(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return contractLocationService.locationService(input, session, response);
	}

	@PostMapping("/contractlocation-list")
	public Map locationList(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return contractLocationService.listData(input, session);
	}

	@PostMapping("/contractlocation-data")
	public Map locationData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return contractLocationService.populateData(input, session, response);
	}

	@RequestMapping("/contractlocation-smartsearch")
	public Map contractlocationSmartSearch(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException {
		return contractLocationService.populateDrSmart(session);
	}

	@PostMapping("/manhours")
	public Map<String, String> manhours(@RequestBody String input, HttpServletResponse response, HttpSession session) throws JSONException, SQLException, ParseException {
		response.setStatus(201);
		return manHourService.manHoursService(input, session, response);
	}

	@PostMapping("/populate-user")
	public Map<String, String> user(@RequestBody String input, HttpServletResponse response, HttpSession session) throws JSONException, SQLException, ParseException {
		response.setStatus(201);
		return jobcarddashservice.PopulateUser(input, session);
	}

	@PostMapping("/index")
	public Map index(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return serviceIndex.serviceIndex(input, session, response);
	}

	@PostMapping("/service-dashboard-list")
	public Map indexList(@RequestBody String input, HttpSession session) throws JSONException, ParseException {
		return serviceIndex.populateDashBoardDetails();
	}
	// @PostMapping("/reportmonitoringboard")
	// public Map reportmonitoringboard(@RequestBody String input, HttpServletResponse response, HttpSession session, HttpServletRequest request) throws JSONException, ParseException,
	// ServletException,
	// IOException {
	// return reportMonitoringBoardService.reportmonitoringboardService(input, session, response, request);
	// }

	// master pages start

	@PostMapping("/config-service")
	public Map configService(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return serviceConfigService.serviceConfigService(input, session, response);
	}

	@PostMapping("/config-service-data")
	public Map configServiceData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return serviceConfigService.populateData(input, session, response);
	}

	@PostMapping("/jccategory")
	public Map ticketcategory(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return jobcartcategoryservice.jcCategoryService(input, session, response);
	}

	@PostMapping("/jccategory-list")
	public Map ticketcategoryList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return jobcartcategoryservice.listData(input, session, response);
	}

	@PostMapping("/jccategory-data")
	public Map ticketcategoryData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return jobcartcategoryservice.populateData(input);
	}
	@PostMapping("/jccategory-smartsearch")
	public Map ticketcategoryDataDrSmartSearch() throws JSONException {
		return jobcartcategoryservice.populateDrSmart();
	}

	@PostMapping("/jctype")
	public Map jobtype(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return jobcarttypeservice.jcTypeService(input, session, response);
	}

	@PostMapping("/jctype-list")
	public Map jobtypeList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return jobcarttypeservice.listData(input, session, response);
	}

	@PostMapping("/jctype-data")
	public Map jobtypeData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return jobcarttypeservice.populateData(input);
	}

	@PostMapping("/jctype-smartsearch")
	public Map populateDrSmart() throws JSONException, ParseException {
		return jobcarttypeservice.populateDrSmart();
	}

	// jc priority
	@PostMapping("/jcpriority")
	public Map jcPriority(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return jobCardPriorityService.jcPriorityService(input, session, response);
	}

	@PostMapping("/jcpriority-list")
	public Map jcPriorityList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return jobCardPriorityService.listData(input, session, response);
	}

	@PostMapping("/jcpriority-data")
	public Map jcPriorityData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return jobCardPriorityService.populateData(input);
	}

	// jc status
	@PostMapping("/jcstatus")
	public Map jobcardstatus(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return jobCartStatusService.jcStatusService(input, session, response);
	}

	@PostMapping("/jcstatus-list")
	public Map jobcardstatusList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return jobCartStatusService.listData(input, session, response);
	}

	@PostMapping("/jcstatus-data")
	public Map jobcardstatusData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return jobCartStatusService.populateData(input);
	}

	@PostMapping("/assettype")
	public Map assettype(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return assetTypeService.assetTypeService(input, session, response);
	}

	@PostMapping("/assettype-list")
	public Map assettypeList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return assetTypeService.listData(input, session, response);
	}

	@PostMapping("/assettype-data")
	public Map assettypeData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return assetTypeService.populateData(input);
	}

	@PostMapping("/assettype-smartsearch")
	public Map assettypeDataDrSmartSearch() throws JSONException {
		return assetTypeService.populateDrSmart();
	}

	@PostMapping("/assetbrand")
	public Map assetBrand(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return assetBrandService.assetBrand(input, session, response);
	}

	@PostMapping("/assetbrand-list")
	public Map assetBrandList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return assetBrandService.listData(input, session, response);
	}

	@PostMapping("/assetbrand-data")
	public Map assetBrandData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return assetBrandService.populateData(input);
	}

	@PostMapping("/assetbrand-smartsearch")
	public Map assetbrandDataDrSmartSearch() throws JSONException {
		return assetBrandService.populateDrSmart();
	}

	// service contact priority
	@PostMapping("/contractpriority")
	public Map contractPriority(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return contractPriorityService.contractPriorityService(input, session, response);
	}

	@PostMapping("/contractpriority-list")
	public Map contractPriorityList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return contractPriorityService.listData(input, session, response);
	}

	@PostMapping("/contractpriority-data")
	public Map contractPriorityData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return contractPriorityService.populateData(input);
	}

	@RequestMapping("/contractpriority-smartsearch")
	public Map contractPriorityList(HttpSession session) throws JSONException {
		// response.sssssetStatus(201);
		return contractPriorityService.populateDrSmart();
	}

	@PostMapping("/contracttype")
	public Map contracttype(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return contractTypeService.contractTypeService(input, session, response);
	}

	@PostMapping("/contracttype-list")
	public Map contracttypeList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return contractTypeService.listData(input, session, response);
	}

	@PostMapping("/contracttype-data")
	public Map contracttypeData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return contractTypeService.populateData(input);
	}

	@PostMapping("/contracttype-smartsearch")
	public Map contracttypeDataDrSmartSearch() throws JSONException {
		return contractTypeService.populateDrSmart();
	}

	@PostMapping("/contractservicetype")
	public Map contractservicetype(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return contractServiceTypeService.contractServiceTypeService(input, session, response);
	}

	@PostMapping("/contractservicetype-list")
	public Map contractservicetypeList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return contractServiceTypeService.listData(input, session);
	}

	@PostMapping("/contractservicetype-data")
	public Map contractservicetypeData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return contractServiceTypeService.populateData(input);
	}

	@PostMapping("/contractservicetype-smartsearch")
	public Map contractservicetypeDataDrSmartSearch() throws JSONException {
		return contractServiceTypeService.populateDrSmart();
	}

	@PostMapping("/jcchecklist")
	public Map jobcardCheck(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return jobCardCheckListService.jcCheckListService(input, session, response);
	}

	@RequestMapping("/jcchecklist-list")
	public Map jobcardCheckList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return jobCardCheckListService.listData(input, session, response);
	}

	@PostMapping("/jcchecklist-data")
	public Map jobcardCheckData(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return jobCardCheckListService.populateData(input);
	}
	// master pages end

	// Report Page Start
	@PostMapping("/report-jobcardproductivity")
	public Map jobcardproductivityService(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		return reportJobCardProductivityService.reportJobCardProductivityDash(input, session, response);
	}

}
