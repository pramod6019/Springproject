package axela.customer.controller;

import java.sql.SQLException;
import java.text.ParseException;
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
import org.springframework.web.context.request.WebRequest;

import axela.customer.service.PopulateService;
import axela.portal.service.ExecutiveService;
import axela.portal.service.PortalPopulateService;

@RestController
@RequestMapping("/customer-populate")
@CrossOrigin("*")
public class Controller_Populate {

	@Autowired
	private PopulateService populateService;

	@Autowired
	private PortalPopulateService PortalPopulateService;

	@Autowired
	private ExecutiveService executiveService;

	// @PostMapping("/crmdaysexecutivetype")
	// public Map crmDaysExecutiveType(@RequestBody String input, HttpServletResponse response) throws JSONException {
	// return populateService.populateCrmDaysExecutiveType();
	// }
	//
	// @PostMapping("/crmdaySalesType")
	// public Map crmdaySalesType(@RequestBody String input) throws JSONException {
	// return populateService.populateCrmdaySalesType(input);
	// }
	// @PostMapping("/crmdaycustomfieldtype")
	// public Map crmdayCustomFieldType(@RequestBody String input) throws JSONException {
	// return populateService.populatecrmdayCustomFieldType(input);
	// }
	// @PostMapping("/inventoryitem")
	// public Map inventoryItem(@RequestBody String input) throws JSONException {
	// return populateService.inventoryItem(input);
	// }
	// @PostMapping("/enquirybranch")
	// public Map enquiryBranch(@RequestBody String input) throws JSONException {
	// return populateService.enquiryBranch(input);
	// }
	// @PostMapping("/enquiryexecutive")
	// public Map enquiryExecutive(@RequestBody String input) throws JSONException {
	// return populateService.enquiryExecutive(input);
	// }
	@PostMapping("/campaign")
	public Map campaign(@RequestBody String input) throws JSONException {
		return populateService.populateCampaign(input);
	}

	@PostMapping("/crmfollowupexecutive")
	public Map CRMFallowUpExecutive(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateCRMFollowUpExecutive(input);
	}

	@PostMapping("/pbffollowupexecutive")
	public Map PBFFallowUpExecutive(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populatePBFFollowUpExecutive(input);
	}

	@PostMapping("/psffollowupexecutive")
	public Map PSFFallowUpExecutive(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populatePSFFOllowUpExecutive(input);
	}

	@PostMapping("/contact")
	public Map CustomerContact(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateContactTitle(input);
	}

	// team executive populate
	@PostMapping("/teambranch-executive")
	public Map populateExecutive(@RequestBody String input, HttpServletResponse response, HttpSession session) throws JSONException {
		return populateService.populateExecutives(input, session);
	}

	@PostMapping("/teamexecutives")
	public Map CustomerTeamExecutives(@RequestBody String input, HttpServletResponse response, HttpSession session) throws JSONException {
		return populateService.populateTeamExecutives(input, session);
	}

	@PostMapping("/team")
	public Map CustomerTeam(@RequestBody String input, HttpServletResponse response, HttpSession session) throws JSONException {
		return populateService.populateTeam(input, session);
	}

	@PostMapping("/stage")
	public Map CustomerStage(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateStage(input);
	}

	@PostMapping("/contract-type")
	public Map contractType() throws JSONException {
		return populateService.populateContractType();
	}

	@PostMapping("/contract-tax")
	public Map contractTax() throws JSONException {
		return populateService.populateContractTax();
	}

	@PostMapping("/contract-priority")
	public Map Priority(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.PopulatePriority();
	}

	@PostMapping("/opportunitystatus")
	public Map OpportunityStatus(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateOpportunityStatus(input);
	}

	@PostMapping("/projectmanager")
	public Map ProjectManager(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateProjectManager(input);
	}

	@PostMapping("/branch")
	public Map CustomerBranch(@RequestBody String input, HttpServletResponse response, HttpSession session) throws JSONException {
		return populateService.populateBranch(input, session);
	}

	@PostMapping("/city")
	public Map CustomerCity(WebRequest webRequest) {
		return populateService.populateCity(webRequest);
	}

	@PostMapping("/customertype")
	public Map CustomerCustomerType(@RequestBody String input, HttpServletResponse response, HttpSession session) throws JSONException {
		return populateService.populateCustomerType(session);
	}

	@PostMapping("/soe")
	public Map CustomerSoe(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateSoe();
	}

	@PostMapping("/sob")
	public Map CustomerSob(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateSob();
	}

	@PostMapping("/executive")
	public Map CustomerExecutive(@RequestBody String input, HttpServletResponse response, HttpSession session) throws JSONException {
		return populateService.populateTeamExecutives(input, session);
	}

	@PostMapping("/groups")
	public Map CustomerGroups(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateGroups(input);
	}

	@PostMapping("/status")
	public Map CustomerStatus(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateStatus();
	}

	@PostMapping("/employeecount")
	public Map CustomerEmployeeCount(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateEmployeeCount();
	}

	@PostMapping("/rateclass")
	public Map CustomerRateClass(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.PopulateRateClass(input);
	}
	@PostMapping("/rateclasstype")
	public Map RateClassType(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.PopulateRateClassType();
	}

	@PostMapping("/paymentdays")
	public Map CustomerPaymentDays(HttpServletResponse response) throws JSONException {
		return populateService.populatePaymentDays();
	}

	// portal

	// @PostMapping("/model")
	// public Map<String, String> SalesModel(@RequestBody String input) throws JSONException {
	// return populateService.populateModel(input);
	// }
	@PostMapping("/item")
	public Map SalesItem(@RequestBody String input) throws JSONException {
		return populateService.populateItem(input);
	}
	// @PostMapping("/parentuom")
	// public Map<String, String> parentUom(@RequestBody String input) throws JSONException {
	// return populateService.populateUom();
	// }
	//
	// @PostMapping("/populateeffective")
	// public Map<String, String> WfDocEffective(@RequestBody String input) throws JSONException {
	// return populateService.populateEffective();
	// }

	// inventory populate

	@PostMapping("/category")
	public Map PopulateCategory() {
		return populateService.PopulateCategory();
	}

	@PostMapping("/item-type")
	public Map populateItemType() {

		return populateService.PopulateItemType();
	}

	@PostMapping("/model")
	public Map PopulateModel() {
		return populateService.PopulateModel();
	}

	@PostMapping("/loyalty-program")
	public Map PopulateLoyalityProgram() {
		return populateService.PopulateLoyalityProgram();
	}

	@PostMapping("/durtype")
	public Map PopulateDurtype() {
		return populateService.PopulateDurtype();
	}

	@PostMapping("/queue-type")
	public Map populateItemQueue() {

		return populateService.PopulateItemQueue();
	}

	@PostMapping("/uom")
	public Map PopulateUOM() {
		return populateService.PopulateUOM();
	}

	@PostMapping("/cost-type")
	public Map PopulateCostType() {

		return populateService.PopulateCostType();
	}

	@PostMapping("/sales-rate-class")
	public Map PopulateSalesRateClass(@RequestBody String input) throws JSONException {
		return populateService.PopulateSalesRateClass(input);
	}

	@PostMapping("/amount-type")
	public Map PopulateSalesRateClass() {
		return populateService.PopulateAmountType();
	}

	@PostMapping("/discounttype")
	public Map PopulateSalesDiscountType() {
		return populateService.PopulateSalesDiscountType();
	}

	@PostMapping("/itemledger")
	public Map PopulateItemLedgers(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.PopulateItemLedgers(input, response);
	}

	@PostMapping("/salestax")
	public Map PopulatePurchaseTax() throws JSONException {
		return populateService.PopulateSalesRateTax();
	}

	@PostMapping("/purchaserateclass")
	public Map PopulatePurchaseRateClass() {
		return populateService.PopulatePurchaseRateClass();
	}
	@PostMapping("/cat-parent")
	public Map listSalesCategory1(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateCatParent(input, response);
		// return
	}

	@PostMapping("/teamaddexecutives")
	public Map Executives(@RequestBody String input, HttpServletResponse response, HttpSession session) throws JSONException {
		return populateService.populateTeamExecutives(input, session);
	}

	// @PostMapping("/location")
	// public Map QuoteLocation(@RequestBody String input, HttpServletResponse response) throws JSONException {
	// return populateService.populateQuoteLocation(input);
	//
	// }
	// =============
	@PostMapping("/campaigntype")
	public Map CampaignType(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateCampaignType(input);
	}

	@PostMapping("/branchtype")
	public Map branchType() throws JSONException {
		return PortalPopulateService.populateBranchType();
	}
	@PostMapping("/franchisee")
	public Map franchisee() throws JSONException {
		return PortalPopulateService.populateFranchisee();
	}
	// @PostMapping("/class")
	// public Map rateClass() throws JSONException {
	// return PortalPopulateService.populateClass();
	// }

	@PostMapping("/opportunitymodel")
	public Map OpportunityModel(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateOpportunityModel(input);
	}
	@PostMapping("/configdetails")
	public Map configDetails(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return populateService.populateConfigDetails(input, session);
	}

	@PostMapping("/configdetailssales")
	public Map configDetailsales(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return populateService.populateConfigDetails(input, session);
	}

	@PostMapping("/serviceconfigdetails")
	public Map configServiceDetails(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateConfigServiceDetails();
	}

	@PostMapping("/populateSourceType")
	public Map populateSourceType() throws SQLException {
		return populateService.PopulateSourceType();
	}

	@PostMapping("/ticket-priority")
	public Map populateTicketPriority(@RequestBody String input, HttpSession session) throws SQLException {
		return populateService.PopulateTicketPriority();
	}

	@PostMapping("/populateQueue")
	public Map populateQueue() throws SQLException {
		return populateService.PopulateQueue();
	}

	@PostMapping("/populateExecutive")
	public Map populateExecutive(@RequestBody String input, HttpSession session) throws JSONException, SQLException {
		return populateService.PopulateExecutive(session, input);
	}

	@PostMapping("/populateallexecutive")
	public Map populateAllExecutive(HttpSession session) throws SQLException {
		return populateService.PopulateAllExecutive(session);
	}

	@PostMapping("/populateContract")
	public Map populateContract(@RequestBody String input, HttpSession session) throws SQLException, JSONException {
		return populateService.PopulateContract(input, session);
	}

	@PostMapping("/populateproject")
	public Map populateProject(@RequestBody String input) throws SQLException, JSONException {
		return populateService.PopulateProject(input);
	}

	@PostMapping("/populateTicketCategory")
	public Map populateTicketCategory(@RequestBody String input) throws SQLException, JSONException {
		return populateService.populateTicketCategory(input);
	}

	@PostMapping("/populateTicketType")
	public Map populateTicketType() throws SQLException {
		return populateService.PopulateTicketType();
	}

	@PostMapping("/populateTicketStatus")
	public Map populateTicketStatus() throws SQLException {
		return populateService.PopulateTicketStatus();
	}

	@PostMapping("/campaignbranch")
	public Map CampaignBranch(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateCampaignBranch(input);
	}

	@PostMapping("/manager")
	public Map teamManager(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return populateService.populateManager(input, session);
	}

	// @PostMapping("/crmfollowupexecutive")
	// public Map teamCRMFollowUpExecutive(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
	// return populateService.populateCRMFollowUpExecutive(input, session);
	//
	// }
	// @PostMapping("/pbffollowupexecutive")
	// public Map teamPBFFollowUpExecutive(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
	// return populateService.populateCRMFollowUpExecutive(input, session);
	// }
	// @PostMapping("/psffollowupexecutive")
	// public Map teamPSFFollowUpExecutive(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
	// return populateService.populateCRMFollowUpExecutive(input, session);
	// }

	@PostMapping("/lostcase1")
	public Map populateLostCase1() throws SQLException {
		return populateService.PopulateLostCase1();
	}

	@PostMapping("/lostcase2")
	public Map populateLostCase2(@RequestBody String input) throws SQLException, JSONException {
		return populateService.PopulateLostCase2(input);
	}

	@PostMapping("/lostcase3")
	public Map populateLostCase3(@RequestBody String input) throws SQLException, JSONException {
		return populateService.PopulateLostCase3(input);
	}

	@PostMapping("/opprpriority")
	public Map populatePriority() throws SQLException, JSONException {
		return populateService.populatePriority();
	}

	// location

	@PostMapping("/location")
	public Map populateLocation(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateLocation(input, response);
	}

	// @PostMapping("/jobcard-location")
	// public Map populateInventoryLocation(@RequestBody String input, HttpServletResponse response) throws JSONException {
	// return populateService.PopulateInventoryLocation(input);
	// }

	// populate Parent Bin

	@PostMapping("/parent-bin")
	public Map parentBin(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.parentBin(input, response);
	}

	// sales

	@RequestMapping("/currentdate")
	public Map currentDate(@RequestBody String input) throws JSONException, ParseException {
		return populateService.populateCurrentDate(input);
	}

	@PostMapping("/followupdescription")
	public Map followupDescription(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return populateService.populateFollowupDescription(input, session);
	}

	@PostMapping("/followuptype")
	public Map followupType(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return populateService.populateFollowupType(input, session);
	}

	// activities

	@PostMapping("/activitiesexecutive")
	public Map activityExecutive(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateExecutive(input);
	}

	@PostMapping("/activitiespriority")
	public Map populatePriority(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateActivityPriority(input);
	}

	@PostMapping("/customer")
	public Map Customer(@RequestBody String input, HttpSession session) throws JSONException {
		return populateService.populateCustomer(input, session);
	}
	@PostMapping("/servicecontractlocation")
	public Map Location(@RequestBody String input, HttpSession session) throws JSONException {
		return populateService.populateServiceContractLocation(input, session);
	}
	@PostMapping("/type")
	public Map Type() throws JSONException {
		return populateService.populateType();
	}
	@PostMapping("/brand")
	public Map Brand() throws JSONException {
		return populateService.populateBrand();
	}

	@PostMapping("/ticket-source")
	public Map populateSourceType(HttpServletResponse response) throws SQLException {
		response.setStatus(201);
		return populateService.PopulateSourceType();
	}

	// @PostMapping("/ticket-priority")
	// public Map populateTicketPriority(@RequestBody String input, HttpServletResponse response) throws SQLException, JSONException {
	// response.setStatus(201);
	// return populateService.populateTicketCategory(input);
	// }

	@PostMapping("/queue")
	public Map populateQueue(HttpServletResponse response) throws SQLException {
		response.setStatus(201);
		return populateService.PopulateQueue();
	}

	// @PostMapping("/populateallexecutive")
	// public Map populateAllExecutive(HttpSession session) throws SQLException {
	// return populateService.PopulateAllExecutive(session);
	// }

	// @PostMapping("/populatecontract")
	// public Map populateContract(@RequestBody String input, HttpSession session) throws SQLException, JSONException {
	// return populateService.PopulateContract(input, session);
	// }

	// @PostMapping("/project")
	// public Map populateProject(@RequestBody String input) throws SQLException, JSONException {
	// return populateService.PopulateProject(input);
	// }

	@PostMapping("/ticket-category")
	public Map populateTicketCategory(HttpServletResponse response, @RequestBody String input) throws SQLException, JSONException {
		return populateService.populateTicketCategory(input);
	}

	@PostMapping("/faq-category")
	public Map populateFaqCategory(HttpServletResponse response, @RequestBody String input) throws SQLException, JSONException {
		return populateService.PopulateFaqCategory();
	}

	@PostMapping("/ticket-type")
	public Map populateTicketType(HttpServletResponse response) throws SQLException {
		return populateService.PopulateTicketType();
	}

	@PostMapping("/ticket-status")
	public Map populateTicketStatus(HttpServletResponse response) throws SQLException {
		return populateService.PopulateTicketStatus();
	}

	@PostMapping("/jobcardserviceadvisor")
	public Map Customerserviceadvisor(@RequestBody String input, HttpServletResponse response, HttpSession session) throws JSONException {
		return populateService.populateServiceAdvisor(input, session);
	}

	@PostMapping("/jobcardtechnician")
	public Map Customertechnicianexecutive(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateTechnicianExecutive(input);
	}

	@PostMapping("/jobcard-category")
	public Map Customercategory(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateJcCategory();
	}
	@PostMapping("/jobcard-type")
	public Map Customerjctype(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populatejcType();
	}

	@PostMapping("/jobcard-priority")
	public Map Customerjcpriority(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populatejcPriority();
	}

	@PostMapping("/jobcard-status")
	public Map jcStatus(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populatejcStatus(input);
	}

	@PostMapping("/bay")
	public Map serviceJcBay(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateBay(input);
	}

	@PostMapping("/jobcard-location")
	public Map inventoryLocation(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.PopulateInventoryLocation(input);
	}

	@PostMapping("/populatequeue")
	public Map populateFaqQueue() throws SQLException {
		return populateService.populateQueue();
	}

	@PostMapping("/ticketcategory")
	public Map PopulateTicketCategory(@RequestBody String input) throws JSONException {
		return populateService.populateTicketCategory(input);
	}

	@PostMapping("/config")
	public Map config() throws JSONException {
		return populateService.populateConfig();
	}

	@PostMapping("/customer-selectto")
	public Map CustomerIdAndName(WebRequest webRequest) throws JSONException {
		return populateService.populateCustomerSelectTo(webRequest);
	}

	@PostMapping("/effectivefrom")
	public Map populateEffectiveFrom(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return populateService.populateEffectiveFrom(input, session, response);
	}

	@PostMapping("/contractcontact")
	public Map populateContractContact(@RequestBody String input) throws JSONException {
		return populateService.populateContractContact(input);
	}

	// Pm
	@PostMapping("/project-type")
	public Map projectType(@RequestBody String input) throws JSONException {
		return populateService.populateProjectType(input);
	}

	@PostMapping("/project-status")
	public Map projectStatus(@RequestBody String input) throws JSONException {
		return populateService.populateProjectStatus(input);
	}

	@PostMapping("/task-status")
	public Map taskStatus(@RequestBody String input) throws JSONException {
		return populateService.populateTaskStatus(input);
	}

	@PostMapping("/task-priority")
	public Map taskPriority(@RequestBody String input) throws JSONException {
		return populateService.populateTaskPriority(input);
	}

	@PostMapping("task-parent")
	public Map parent(@RequestBody String input) throws JSONException {
		return populateService.PopulatetaskParent(input);
	}

	@PostMapping("/project-milestone")
	public Map pmMilestones(@RequestBody String input) throws JSONException {
		return populateService.populatePmMilestone(input);
	}

	@PostMapping("/jobtitle")
	public Map jobtitle(@RequestBody String input) throws JSONException {
		return populateService.populateJobtitle();
	}

	@PostMapping("/department")
	public Map populateDepartment(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return populateService.populateDepartment();
	}

	@PostMapping("/year")
	public Map populateyear(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return populateService.populateYear(input, session, response);
	}

	@PostMapping("/selectexecutive")
	public Map populateExecutive(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return executiveService.populateExecutive(input);
	}

	@PostMapping("/selectbranch")
	public Map populateBranch(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return executiveService.populateBranches(input);
	}

	@PostMapping("/inventory-groups")
	public Map inventoryGroups(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.populateInventoryGroups();
	}
	@PostMapping("/jcserialno")
	public Map jobcardSearch(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.jobcardSearch(input, response);
	}

	@PostMapping("/jcmobile1")
	public Map jobcardSearch1(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.jobcardSearch(input, response);
	}

	@PostMapping("/jcemail1")
	public Map jobcardSearch2(@RequestBody String input, HttpServletResponse response) throws JSONException {
		return populateService.jobcardSearch(input, response);
	}

	@PostMapping("/app-pmfilter")
	public Map pmFilter(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return populateService.populateProjectTextFields();
	}

	@PostMapping("/app-taskfilter")
	public Map taskFilter(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return populateService.populateTaskTextFields();
	}

	@PostMapping("/app-opprfilter")
	public Map opprFilter(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return populateService.populateOpprTextFields();
	}

	// App Filter Jc populate
	@PostMapping("/app-jcfilter")
	public Map jcFilter(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return populateService.populateJobCardTextFields();
	}

	// App Filter Oppr populate
	@PostMapping("/app-ticketfilter")
	public Map ticketFilter(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException {
		return populateService.populateTicketTextFields();
	}
}
