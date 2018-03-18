package axela.customer.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import axela.activities.repository.ActivityPriorityRepository;
import axela.config.Connect;
import axela.customer.model.AxelaCustomer;
import axela.customer.model.AxelaCustomerContact;
import axela.customer.model.AxelaSalesOpprStatus;
import axela.customer.repository.CustomerContactReposiitory;
import axela.customer.repository.CustomerFilterImpl;
import axela.customer.repository.CustomerRepository;
import axela.customer.repository.GroupFilterImpl;
import axela.helpdesk.model.AxelaHelpDeskTicketCat;
import axela.helpdesk.repository.AxelaTicketQueueRepository;
import axela.helpdesk.repository.AxelaTicketStatusRepository;
import axela.helpdesk.repository.FaqCatRepository;
import axela.helpdesk.repository.HelpDeskTicketCatRepository;
import axela.helpdesk.repository.HelpDeskTicketPriorityRepository;
import axela.helpdesk.repository.HelpDeskTicketSourceRepository;
import axela.helpdesk.repository.HelpDeskTicketTypeRepository;
import axela.inventory.model.AxelaInventoryBinPop;
import axela.inventory.model.AxelaInventoryCatPop;
import axela.inventory.model.AxelaInventoryItemModel;
import axela.inventory.model.AxelaInventoryItemType;
import axela.inventory.model.AxelaInventoryLocation;
import axela.inventory.model.AxelaInventoryUom;
import axela.inventory.repository.InventoryBinPopFilterImpl;
import axela.inventory.repository.InventoryCatPopFilterImp;
import axela.inventory.repository.InventoryCatRepository;
import axela.inventory.repository.InventoryGroupRepository;
import axela.inventory.repository.InventoryItemModelRepository;
import axela.inventory.repository.InventoryItemTypeRepository;
import axela.inventory.repository.InventoryLocationFilter;
import axela.inventory.repository.InventoryLocationRepository;
import axela.inventory.repository.InventoryUomRepository;
import axela.pm.model.AxelaPm;
import axela.pm.repository.PmMilestonesRepository;
import axela.pm.repository.PmStatusRepository;
import axela.pm.repository.TaskPriorityRepository;
import axela.pm.repository.TaskRepository;
import axela.pm.repository.TaskStatusRepository;
import axela.portal.model.AxelaBillLoyaltycard;
import axela.portal.model.AxelaBranch;
import axela.portal.model.AxelaCity;
import axela.portal.model.AxelaComp;
import axela.portal.model.AxelaConfig;
import axela.portal.model.AxelaCustomerItstatus;
import axela.portal.model.AxelaEmp;
import axela.portal.model.AxelaEmpcount;
import axela.portal.model.AxelaRateClass;
import axela.portal.model.AxelaSalesOpprStage;
import axela.portal.model.AxelaSob;
import axela.portal.model.AxelaTitle;
import axela.portal.model.TaxRepository;
import axela.portal.repository.AxelaAccPayDaysRepository;
import axela.portal.repository.AxelaBillLoyaltycardRepository;
import axela.portal.repository.AxelaCityRepositoryImpl;
import axela.portal.repository.AxelaCustomerGroupRepository;
import axela.portal.repository.AxelaCustomerItstatusRepository;
import axela.portal.repository.AxelaEmpcountRepository;
import axela.portal.repository.AxelaRateClassRepository;
import axela.portal.repository.AxelaSobRepository;
import axela.portal.repository.AxelaSoeRepository;
import axela.portal.repository.AxelaStateRepository;
import axela.portal.repository.AxelaTitleRepository;
import axela.portal.repository.BranchFilterImpl;
import axela.portal.repository.BranchRepository;
import axela.portal.repository.CompRepository;
import axela.portal.repository.ConfigRepository;
import axela.portal.repository.EmpDepartmentRepository;
import axela.portal.repository.EmpFilterImpl;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.ItemRepository;
import axela.portal.repository.JobtitleRepository;
import axela.portal.repository.PmFilterImpl;
import axela.portal.repository.PmRepository;
import axela.portal.repository.PmTypeRepository;
import axela.portal.repository.SalesPriorityRepository;
import axela.sales.model.AxelaSalesCampaign;
import axela.sales.model.AxelaSalesCampaignType;
import axela.sales.model.AxelaSalesOpprFollowupType;
import axela.sales.repository.FollowupDescRepository;
import axela.sales.repository.FollowupTypeRepository;
import axela.sales.repository.SalesCampaignRepository;
import axela.sales.repository.SalesCampaignTypeRepository;
import axela.sales.repository.SalesLostCase1Repository;
import axela.sales.repository.SalesLostCase2Repository;
import axela.sales.repository.SalesLostCase3Repository;
import axela.sales.repository.SalesOpprStageRepository;
import axela.sales.repository.SalesOpprStatusRepository;
import axela.sales.repository.SalesTeamRepository;
import axela.sales.repository.SalesTeamexeRepository;
import axela.sales.repository.TeamFilterImpl;
import axela.service.model.AxelaServiceJcCat;
import axela.service.model.AxelaServiceJcPriority;
import axela.service.model.AxelaServiceJcStatus;
import axela.service.model.AxelaServiceJcType;
import axela.service.repository.JcStatusRepository;
import axela.service.repository.ServiceContractAssetBrandRepository;
import axela.service.repository.ServiceContractAssetTypeRepository;
import axela.service.repository.ServiceContractImpl;
import axela.service.repository.ServiceContractLocationRepository;
import axela.service.repository.ServiceContractPriorityRepository;
import axela.service.repository.ServiceContractTypeRepository;
import axela.service.repository.ServiceJcBayRepository;
import axela.service.repository.jcCategoryRepository;
import axela.service.repository.jcTypeRepository;
import axela.service.repository.jobCartPriorityRepository;

@Service
public class PopulateService extends Connect {
	@Autowired
	AxelaSoeRepository axelaSoeRepository;

	@Autowired
	HttpServletRequest request;

	@Autowired
	SalesOpprStatusRepository salesOpprStatusRepository;

	@Autowired
	private jcCategoryRepository jccategoryrepository;

	@Autowired
	private jobCartPriorityRepository jobcartpriorityrepository;

	@Autowired
	private JcStatusRepository jcstatusrepository;

	@Autowired
	TaxRepository taxRepository;

	@Autowired
	SalesCampaignTypeRepository salesCampaignTypeRepository;

	@Autowired
	PmRepository pmRepository;

	@Autowired
	CustomerFilterImpl Customerfilterimpl;

	@Autowired
	ServiceContractPriorityRepository serviceContractPriorityRepository;

	@Autowired
	ServiceContractAssetTypeRepository serviceContractAssetTypeRepository;

	@Autowired
	ServiceContractAssetBrandRepository serviceContractAssetBrandRepository;

	@Autowired
	AxelaSobRepository axelaSobRepository;

	@Autowired
	SalesOpprStageRepository axelaSalesOpprStageRepository;

	@Autowired
	AxelaTitleRepository axelaTitleRepository;

	@Autowired
	FaqCatRepository faqCatRepository;

	@Autowired
	CustomerContactReposiitory customerContactReposiitory;

	@Autowired
	AxelaEmpcountRepository axelaEmpcountRepository;

	@Autowired
	AxelaCustomerItstatusRepository axelaCustomerItstatusRepository;

	@Autowired
	AxelaCustomerGroupRepository axelaCustomerGroupRepository;

	@Autowired
	GroupFilterImpl groupFilterImpl;

	@Autowired
	private AxelaCityRepositoryImpl axelaCityRepository;

	@Autowired
	ServiceContractLocationRepository serviceContractLocationRepository;

	// @Autowired
	// ServiceContractAssetTypeRepository serviceContractAssetTypeRepository;

	@Autowired
	private AxelaRateClassRepository axelaRateClassRepository;

	@Autowired
	private AxelaAccPayDaysRepository axelaPayDaysRepository;

	@Autowired
	private BranchRepository branchRepository;

	// @Autowired
	// private ModelRepository modelRepository;

	// @Autowired
	// private CustomerFilterImpl customerFilter;

	@Autowired
	private SalesPriorityRepository axelaSalesPriorityRepository;

	@Autowired
	private HelpDeskTicketSourceRepository serviceTicketSourceRepository;

	@Autowired
	private HelpDeskTicketTypeRepository serviceTicketTypeRepository;

	@Autowired
	private HelpDeskTicketCatRepository serviceTicketCatRepository;

	@Autowired
	private PmFilterImpl pmFilterImpl;

	@Autowired
	private SalesTeamexeRepository salesTeamexeRepository;

	@Autowired
	private HelpDeskTicketPriorityRepository serviceTicketPriorityRepository;

	@Autowired
	private AxelaTicketQueueRepository axelaTicketQueueRepository;

	@Autowired
	private ServiceContractImpl serviceContractImpl;

	@Autowired
	private EmpFilterImpl empFilterImpl;

	@Autowired
	private EmpRepository empRepository;

	@Autowired
	private AxelaTicketStatusRepository axelaTicketStatusRepository;

	@Autowired
	private ItemRepository itemrepository;

	@Autowired
	private SalesTeamRepository salesTeamRepository;

	@Autowired
	private SalesCampaignRepository salesCampaignRepository;

	@Autowired
	private ConfigRepository axelaConfigRepository;

	@Autowired
	private CompRepository axelaCompRepository;

	// inventory

	@Autowired
	InventoryItemTypeRepository inventoryItemTypeRepository;

	@Autowired
	InventoryCatRepository inventoryCatRepository;

	@Autowired
	InventoryUomRepository inventoryUomRepository;

	@Autowired
	InventoryItemModelRepository inventoryItemModelRepository;

	@Autowired
	AxelaBillLoyaltycardRepository axelaBillLoyaltycardRepository;

	@Autowired
	SalesLostCase1Repository salesLostCase1Repository;

	@Autowired
	SalesLostCase2Repository salesLostCase2Repository;

	@Autowired
	SalesLostCase3Repository salesLostCase3Repository;

	@Autowired
	private CustomerRepository customer_Repository;

	@Autowired
	InventoryCatPopFilterImp inventoryCatPopFilterImp;

	@Autowired
	TeamFilterImpl teamFilterImpl;

	@Autowired
	InventoryLocationFilter inventoryLocationFilter;

	@Autowired
	InventoryBinPopFilterImpl inventoryBinPopFilterImpl;

	@Autowired
	FollowupDescRepository followupDescriptionRepository;

	@Autowired
	FollowupTypeRepository followupTypeRepository;

	@Autowired
	ActivityPriorityRepository activityPriorityRepository;

	@Autowired
	private jcTypeRepository jctyperepository;

	@Autowired
	private ServiceJcBayRepository serviceJcBayRepository;

	@Autowired
	private InventoryLocationRepository inventoryLocationRepository;
	@Autowired
	private HelpDeskTicketCatRepository helpDeskTicketCatRepository;

	@Autowired
	CustomerFilterImpl customerFilterImpl;

	@Autowired
	EmpRepository axelaEmpRepository;

	@Autowired
	ServiceContractTypeRepository serviceContractTypeRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BranchFilterImpl branchFilterImpl;

	@Autowired
	PmTypeRepository pmTypeRepository;

	@Autowired
	PmStatusRepository pmStatusRepository;

	@Autowired
	TaskStatusRepository taskStatusRepository;

	@Autowired
	PmMilestonesRepository pmMilestonesRepository;

	@Autowired
	TaskPriorityRepository taskPriorityRepository;

	@Autowired
	EmpDepartmentRepository empDepartmentRepository;

	@Autowired
	JobtitleRepository jobtitleRepository;

	@Autowired
	InventoryGroupRepository inventoryGroupRepository;

	@Autowired
	TaskRepository taskrepository;

	JSONObject inputObj = new JSONObject();
	public String cityId = "0", customerBranchId = "0";
	public String page = "0";
	public String pages = "0";
	public String perpage = "0";
	public String sort = "";
	public String total = "0";
	public String field = "";
	public String emp_id = "0";
	public String ticketCustomerId = "0";
	public String ticketContactId = "0";
	public String contractContactId = "0";
	public String customerId = "0";
	public String assetCustomerId = "0";
	public String ticketcatId = "0";
	public String rateclassType = "";
	HashMap output = new HashMap();
	public String jcSerialno = "";

	@Autowired
	private HttpServletRequest request1;
	@Autowired
	private AxelaStateRepository axelaStateRepository;

	public String modelId = "0";

	private String opprLostcase1Id;

	private String opprLostcase2Id;

	private String contractCustomerId = "";

	// populating populateSoe
	public Map<String, List> populateSoe() {
		Map output = new HashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] soe : axelaSoeRepository.findSoe()) {
			map = new HashMap<String, String>();
			map.put("key", "" + soe[0]);
			map.put("name", "" + soe[1]);
			list.add(map);
		}
		output.put("populateSoe", list);
		if (AppRun().equals("0")) {
		}
		return output;
	}

	// populating populateSob
	public Map<String, String> populateSob() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaSob obj : axelaSobRepository.findAll()) {
			map = new HashMap<String, String>();
			map.put("key", "" + obj.getSobId());
			map.put("name", obj.getSobName());
			list.add(map);
		}
		output.put("populateSob", list);
		if (AppRun().equals("0")) {
		}
		return output;
	}

	// populating populateCustomerType
	public Map<String, String> populateCustomerType(HttpSession session) {
		String configCustomerName = PadQuotes(getSession("configCustomerName", session));
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		map.put("key", "1");
		map.put("name", configCustomerName);
		list.add(map);
		map = new HashMap<String, String>();
		map.put("key", "2");
		map.put("name", "Supplier");
		list.add(map);
		output.put("populateCustomerType", list);
		return output;
	}

	// populating populateCity
	public Map<String, String> populateCity(WebRequest webRequest) {
		String cityName = "";
		String cityId = "0";
		Map output = new LinkedHashMap();
		PageRequest request = null;
		request = new PageRequest(1, 20, Sort.Direction.ASC, "cityId");
		if (AppRun().equals("0")) {
		}
		cityName = PadQuotes(webRequest.getParameter(("cityName")));
		cityId = CNumeric(PadQuotes(webRequest.getParameter(("cityId"))));
		if (!cityId.equals("0") || !cityName.equals("")) {
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			List<AxelaCity> axelaCity = axelaCityRepository.findByCityAndName(Integer.parseInt(cityId), cityName, request);
			for (AxelaCity obj : axelaCity) {
				LinkedHashMap map = new LinkedHashMap();
				map.put("id", obj.getCityId());
				map.put("text", obj.getCityName());
				list.add(map);
			}
			output.put("results", list);
		}
		return output;

	}

	// populating populateExecutive
	public Map<String, String> populateExecutive(HttpSession session) {
		Map output = new HashMap();
		if (AppRun().equals("0")) {
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaEmp obj : empRepository.findAll()) {
			map = new HashMap<String, String>();
			map.put("key", "" + obj.getEmpId());
			map.put("name", obj.getEmpName());
			list.add(map);
		}
		output.put("selectedKey", CNumeric(getSession("empId", session)));
		output.put("populateExecutive", list);
		if (AppRun().equals("0")) {
		}
		return output;
	}

	public String jsonArrayToString(JSONArray jsonarray) throws JSONException {
		StringBuilder str = new StringBuilder();
		if (jsonarray.length() != 0) {
			str.append(jsonarray.getInt(0));
			for (int i = 1; i < jsonarray.length(); i++) {
				str.append(",").append(jsonarray.get(i));
			}
		}
		return str.toString();
	}

	// populating populateGroups
	public Map<String, String> populateGroups(String input) throws JSONException {
		Map output = new HashMap();
		String requestType = "";
		inputObj = new JSONObject(input);
		List<Object[]> group = new ArrayList<Object[]>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		String groupIds = "";
		if (!inputObj.isNull("groupIds")) {
			groupIds = PadQuotes(inputObj.getString("groupIds"));
		}
		if (!groupIds.equals("")) {
			group = groupFilterImpl.findByIdAndName(groupIds);
		} else {
			group = axelaCustomerGroupRepository.findByGroup();
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] obj : group) {
			map = new HashMap<String, String>();
			map.put("key", "" + obj[0]);
			map.put("name", obj[1] + "");
			list.add(map);
		}
		output.put("populateGroups", list);
		return output;
	}

	// populating populateStatus
	public Map<String, String> populateStatus() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaCustomerItstatus obj : axelaCustomerItstatusRepository.findAll()) {
			map = new HashMap<String, String>();
			map.put("key", "" + obj.getItstatusId());
			map.put("name", obj.getItstatusName());
			list.add(map);
		}
		output.put("populateStatus", list);
		return output;
	}

	public Map<String, String> populateEmployeeCount() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaEmpcount obj : axelaEmpcountRepository.findAll()) {
			map = new HashMap<String, String>();
			map.put("key", "" + obj.getEmpcountId());
			map.put("name", obj.getEmpcountDesc());
			list.add(map);
		}
		output.put("populateEmployeeCount", list);
		return output;
	}

	// rate class for customer
	public Map PopulateRateClass(String input) throws JSONException {
		inputObj = new JSONObject(input);
		Map output = new HashMap();
		if (!inputObj.isNull("customerBranchId")) {
			customerBranchId = CNumeric(PadQuotes(inputObj.getString("customerBranchId")));
		}
		// if (!customerBranchId.equals("0")) {
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> axelaRateClass = axelaRateClassRepository.findByRateId();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] result : axelaRateClass) {
			map = new HashMap();
			map.put("key", "" + CNumeric(PadQuotes(result[0].toString())));
			map.put("name", PadQuotes(result[1].toString()));
			list.add(map);
		}
		output.put("populateRateClass", list);
		// }
		return output;
	}

	public Map<String, String> populatePaymentDays() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> axelaPaymentDays = axelaPayDaysRepository.findPayDayId();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] result : axelaPaymentDays) {
			map = new HashMap<String, String>();
			map.put("key", "" + CNumeric(PadQuotes(result[0].toString())));
			map.put("name", CNumeric(PadQuotes(result[1].toString())));
			list.add(map);
		}
		output.put("populatePaymentDays", list);
		return output;
	}

	// full page information

	// start populate model
	public Map<String, List> populateOpportunityModel(String input) throws JSONException {
		inputObj = new JSONObject(input);
		Map output = new HashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<AxelaInventoryItemModel> axelaInventoryItemModel = new ArrayList<AxelaInventoryItemModel>();
		String modelId = "0";
		if (!inputObj.isNull("modelId")) {
			modelId = CNumeric(inputObj.getString("modelId"));
		}
		if (modelId.equals("0")) {
			axelaInventoryItemModel = inventoryItemModelRepository.findAllByOder();
		} else {
			axelaInventoryItemModel = inventoryItemModelRepository.findByModelIdOrderByModelName(Integer.parseInt(modelId));
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaInventoryItemModel axelaInventoryItemModels : axelaInventoryItemModel) {
			map = new HashMap<String, String>();
			map.put("key", "" + axelaInventoryItemModels.getModelId());
			map.put("name", axelaInventoryItemModels.getModelName());
			list.add(map);
		}
		output.put("populateOpportunityModel", list);
		return output;
	}
	// end populate model

	public Map populateItem(String input) throws JSONException {
		Map output = new HashMap();
		inputObj = new JSONObject(input);
		SOP("inputObj===============" + inputObj.toString(2));
		String modelId = "0";
		List<Object[]> inventoryItem = new ArrayList<Object[]>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!inputObj.isNull("modelId")) {
			modelId = inputObj.getString("modelId");
		}
		if (!modelId.equals("0")) {
			inventoryItem = itemrepository.findByModel(Integer.parseInt(modelId));
		} else {
			inventoryItem = itemrepository.findAllItem();
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] obj : inventoryItem) {
			map = new HashMap<String, String>();
			map.put("key", "" + obj[0]);
			map.put("name", "" + obj[1]);
			list.add(map);
		}
		output.put("key", "item.itemId");
		output.put("populateItem", list);

		if (AppRun().equals("0")) {
		}
		return output;
	}

	// Start Populate Executives
	public Map<String, String> populateTeamExecutives(String input, HttpSession session) throws JSONException {
		inputObj = new JSONObject(input);
		SOP("inputObj=========" + inputObj.toString(2));
		HashMap output = new HashMap();
		List<Object[]> axelaEmp = new ArrayList<Object[]>();
		String requestType = "";
		String branchId = "0";
		String exeAccess = getSession("exeAccess", session);
		String strSearch = "";
		String teamId = "0";
		String branchIds = "";
		String teamIds = "";
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!inputObj.isNull("teamBranchId")) {
			branchId = CNumeric(inputObj.getString("teamBranchId"));
		}
		if (!inputObj.isNull("teamId")) {
			teamId = CNumeric(inputObj.getString("teamId"));
		}
		// For Onchange Branch And Team
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (requestType.equals("filter")) {
			output.put("key", "emp.empId");
			// App Filter
			// onchange of branch
			if (!inputObj.isNull("branch.branchId")) {
				if (inputObj.get("branch.branchId") instanceof JSONArray)
					branchIds = jsonArrayToString(inputObj.getJSONArray("branch.branchId"));
			}
			if (!inputObj.isNull("branchIds")) {
				if (inputObj.get("branchIds") instanceof JSONArray)
					branchIds = jsonArrayToString(inputObj.getJSONArray("branchIds"));
			}
			// onchange of Team
			if (!inputObj.isNull("teamIds")) {
				if (inputObj.get("teamIds") instanceof JSONArray)
					teamIds = jsonArrayToString(inputObj.getJSONArray("teamIds"));
			}
		} else if (!branchId.equals("0")) {
			strSearch = " AND emp.empBranchId =" + branchId + "";
		} else if (!teamId.equals("0")) {
			strSearch = " AND exe.teamtransTeamId = " + teamId + "";
		} else if (branchIds.length() != 0) {
			strSearch = " AND emp.empBranchId IN (" + branchIds + ")";
		} else if (teamIds.length() != 0) {
			strSearch = " AND exe.teamtransTeamId IN (" + teamIds + ")";
		}
		axelaEmp = empFilterImpl.findByteam(exeAccess, strSearch);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] teamexe : axelaEmp) {
			map = new HashMap<String, String>();
			map.put("key", teamexe[0] + "");
			map.put("name", teamexe[1] + " (" + teamexe[2] + ")");
			list.add(map);
		}
		output.put("populateExecutive", list);
		if (AppRun().equals("0")) {
			SOP("inputObj=========" + output);
		}
		return output;
	}
	// End Populate Executive

	// Start Populate contact
	public Map populateContactTitle(String input) throws JSONException {
		inputObj = new JSONObject(input);
		String title_id = "0";
		List<AxelaTitle> axelaTitle = new ArrayList<AxelaTitle>();
		Map output = new HashMap();
		if (!inputObj.isNull("title_id")) {
			title_id = CNumeric(inputObj.getString("title_id"));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (title_id.equals("0")) {
			axelaTitle = axelaTitleRepository.findAll();
		} else {
			axelaTitle = axelaTitleRepository.findByTitleId(Integer.parseInt(title_id));
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaTitle title : axelaTitle) {
			map = new HashMap<String, String>();
			map.put("key", "" + title.getTitleId());
			map.put("name", title.getTitleDesc());
			list.add(map);
		}
		output.put("populateContactTitle", list);
		if (AppRun().equals("0")) {
		}
		return output;
	}
	// end Populate contact

	// Start Populate stage
	public Map<String, String> populateStage(String input) throws JSONException {
		inputObj = new JSONObject(input);
		String stage_id = "0";
		List<AxelaSalesOpprStage> axelaSalesOpprStage = new ArrayList<AxelaSalesOpprStage>();
		Map output = new HashMap();
		if (!inputObj.isNull("stage_id")) {
			stage_id = CNumeric(inputObj.getString("stage_id"));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (stage_id.equals("0")) {
			axelaSalesOpprStage = axelaSalesOpprStageRepository.findAll();
		} else {
			// axelaSalesOpprStage = axelaSalesOpprStageRepository.findByStageId(Integer.parseInt(stage_id));
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaSalesOpprStage axelaSalesOpprStages : axelaSalesOpprStage) {
			map = new HashMap<String, String>();
			map.put("key", "" + axelaSalesOpprStages.getStageId());
			map.put("name", axelaSalesOpprStages.getStageName());
			list.add(map);
		}
		output.put("populateStage", list);
		return output;
	}
	// end Populate stage

	// Start Populate Oppr_status
	public Map<String, String> populateOpportunityStatus(String input) throws JSONException {
		inputObj = new JSONObject(input);
		String status_id = "0";
		List<AxelaSalesOpprStatus> axelaSalesOpprStatus = new ArrayList<AxelaSalesOpprStatus>();
		Map output = new HashMap();
		if (!inputObj.isNull("status_id")) {
			status_id = CNumeric(inputObj.getString("status_id"));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (status_id.equals("0")) {
			axelaSalesOpprStatus = salesOpprStatusRepository.findAll();
		} else {
			axelaSalesOpprStatus = salesOpprStatusRepository.findByStatusId(Integer.parseInt(status_id));
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaSalesOpprStatus axelaSalesOpprStatuss : axelaSalesOpprStatus) {
			map = new HashMap<String, String>();
			map.put("key", "" + axelaSalesOpprStatuss.getStatusId());
			map.put("name", axelaSalesOpprStatuss.getStatusName());
			list.add(map);
		}
		output.put("populateOpportunityStatus", list);
		return output;
	}
	// end Populate Oppr_status

	// Start Populate project manager
	public Map<String, String> populateProjectManager(String input) throws JSONException {
		inputObj = new JSONObject(input);
		String pm_id = "0";
		List<AxelaPm> axelaPm = new ArrayList<AxelaPm>();
		Map output = new HashMap();
		if (!inputObj.isNull("pm_id")) {
			pm_id = CNumeric(inputObj.getString("pm_id"));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (pm_id.equals("0")) {
			axelaPm = pmRepository.findAll();
		} else {
			axelaPm = pmRepository.findByPm(Integer.parseInt(pm_id));
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaPm axelaPms : axelaPm) {
			map = new HashMap<String, String>();
			map.put("key", "" + axelaPms.getPmId());
			map.put("name", axelaPms.getPmTitle());
			list.add(map);
		}
		output.put("populateProjectManager", list);
		if (AppRun().equals("0")) {
		}
		return output;
	}
	// end Populate project manager

	// end Populate team executive
	public Map<String, String> populateOpportunityTeamExecutive(String input) throws JSONException {
		inputObj = new JSONObject(input);
		String branch_id = "0";
		String team_id = "0";

		List<AxelaEmp> axelaEmp = new ArrayList<AxelaEmp>();
		Map output = new HashMap();
		if (!inputObj.isNull("emp_id")) {
			branch_id = CNumeric(inputObj.getString("branch_id"));
			team_id = CNumeric(inputObj.getString("team_id"));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (branch_id.equals("0") && team_id.equals("0")) {
			axelaEmp = empRepository.findAll();
		} else {
			if (team_id.equals("0")) {
				// axelaEmp = empRepository.findByTeamZero(branch_id);
			} else {
				// axelaEmp = empRepository.findByTeamNonZero(branch_id,team_id);
			}
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaEmp axelaEmps : axelaEmp) {
			map = new HashMap<String, String>();
			map.put("key", "" + axelaEmps.getEmpId());
			map.put("name", axelaEmps.getEmpName() + "(" + axelaEmps.getEmpRefNo() + ")");
			list.add(map);
		}
		output.put("populateTeamExecutive", list);
		return output;
	}
	// end Populate team executive

	public Map populateTeam(String input, HttpSession session) throws JSONException {
		HashMap output = new HashMap();
		String requestType = "";
		List<Object[]> team = new ArrayList<Object[]>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		String branchId = "0";
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("branchId")) {
			branchId = inputObj.getString("branchId");
		}
		if (requestType.equals("filter")) {
			JSONArray teamIds = new JSONArray();
			if (!inputObj.isNull("teamIds")) {
				if (inputObj.get("teamIds") instanceof JSONArray)
					if (teamIds.length() != 0) {
						teamIds = inputObj.getJSONArray("teamIds");
					}
			}
			String strSearch = " AND team.teamId IN (" + jsonArrayToString(teamIds) + ")";
			team = teamFilterImpl.findByBranch(strSearch);
			output.put("key", "team.teamId");
		} else if (!branchId.equals("0")) {
			String strSearch = " AND team.teamBranchId =" + branchId;
			team = teamFilterImpl.findByBranch(strSearch);
			output.put("key", "team.teamId");
		} else {
			team = salesTeamRepository.findAllTeam();
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] salesTeam : team) {
			map = new HashMap<String, String>();
			map.put("key", "" + salesTeam[0]);
			map.put("name", salesTeam[1] + "");
			list.add(map);
		}
		output.put("populateTeam", list);
		if (AppRun().equals("0")) {
		}
		return output;

	}

	public Map<String, String> populateCampaign(String input) throws JSONException {
		List<AxelaSalesCampaign> team = salesCampaignRepository.findAll();
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaSalesCampaign campaign : team) {
			map = new HashMap<String, String>();
			map.put("key", "" + campaign.getCampaignId());
			map.put("name", campaign.getCampaignName());
			list.add(map);
		}
		output.put("populateCampaign", list);
		if (AppRun().equals("0")) {
		}
		return output;
	}

	// inventory imple methods
	public Map<String, String> PopulateItemType() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<AxelaInventoryItemType> axelaInventoryItemType = inventoryItemTypeRepository.findAll();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaInventoryItemType objects : axelaInventoryItemType) {
			map = new HashMap<String, String>();
			map.put("key", "" + objects.getItemtypeId());
			map.put("name", objects.getItemtypeName());
			list.add(map);
		}

		output.put("populateItemType", list);
		return output;
	}

	public Map<String, String> PopulateModel() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> axelaInventoryItemModel = inventoryItemModelRepository.findModals();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] objects : axelaInventoryItemModel) {
			map = new HashMap<String, String>();
			map.put("key", "" + objects[0]);
			map.put("name", "" + objects[1]);
			list.add(map);
		}
		output.put("populateModel", list);
		output.put("key", "item.itemModelId");
		return output;
	}
	public Map<String, String> PopulateLoyalityProgram() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<AxelaBillLoyaltycard> axelaBillLoyaltycard = axelaBillLoyaltycardRepository.findBillLoyaltycard();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaBillLoyaltycard objects : axelaBillLoyaltycard) {
			map = new HashMap<String, String>();
			map.put("key", "" + objects.getLoyaltycardId());
			map.put("name", objects.getLoyaltycardName());
			list.add(map);
		}
		output.put("populateLoyalityProgram", list);
		return output;
	}

	public Map<String, String> PopulateDurtype() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		map.put("key", "1");
		map.put("name", ReturnDurType(1));
		list.add(map);
		map = new HashMap<String, String>();
		map.put("key", "2");
		map.put("name", ReturnDurType(2));
		list.add(map);
		map = new HashMap<String, String>();
		map.put("key", "3");
		map.put("name", ReturnDurType(3));
		list.add(map);
		map = new HashMap<String, String>();
		map.put("key", "4");
		map.put("name", ReturnDurType(4));
		list.add(map);
		output.put("populateDurtype", list);
		return output;
	}

	public Map PopulateRateClassType() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		map.put("key", "1");
		map.put("name", "sales");
		list.add(map);
		map = new HashMap<String, String>();
		map.put("key", "2");
		map.put("name", "Purchase");
		list.add(map);
		output.put("populateRateClassType", list);
		return output;
	}

	public Map PopulateAmountType() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		map.put("key", "1");
		map.put("name", "Amount");
		list.add(map);
		map = new HashMap<String, String>();
		map.put("key", "2");
		map.put("name", "Percentage");
		list.add(map);
		output.put("populateAmountType", list);
		return output;
	}

	public Map<String, String> PopulateCategory() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> axelaInventoryCat = inventoryCatRepository.findCategory();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] objects : axelaInventoryCat) {
			map = new HashMap<String, String>();
			map.put("key", "" + objects[0]);
			map.put("name", objects[1].toString());
			list.add(map);
		}

		output.put("populateCategory", list);
		return output;
	}

	public Map<String, String> PopulateUOM() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<AxelaInventoryUom> axelaInventoryUom = inventoryUomRepository.findAll();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaInventoryUom objects : axelaInventoryUom) {
			map = new HashMap<String, String>();
			map.put("key", "" + objects.getUomId());
			map.put("name", objects.getUomName());
			list.add(map);
		}
		output.put("populateUOM", list);
		return output;
	}

	public Map<String, String> PopulateItemQueue() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		map = new HashMap<String, String>();
		map.put("key", "1");
		map.put("name", "FIFO");
		list.add(map);
		map = new HashMap<String, String>();
		map.put("key", "2");
		map.put("name", "LIFO");
		list.add(map);
		output.put("populateItemQueue", list);
		return output;
	}

	public Map<String, String> PopulateCostType() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		map = new HashMap<String, String>();
		map.put("key", "1");
		map.put("name", "Last Purchase Cost");
		list.add(map);
		map = new HashMap<String, String>();
		map.put("key", "2");
		map.put("name", "Average Cost");
		list.add(map);
		map = new HashMap<String, String>();
		map.put("key", "3");
		map.put("name", "Standard Cost");
		list.add(map);
		output.put("populateCostType", list);
		return output;
	}

	public Map<String, String> PopulateSalesDiscountType() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		map.put("Select", "0");
		map.put("Amount", "1");
		map.put("Percentage", "2");
		list.add(map);
		output.put("populateSalesDiscountType", list);
		return output;
	}

	// start populate CRM fallow_up executive
	public Map<String, List> populateCRMFollowUpExecutive(String input) throws JSONException {
		inputObj = new JSONObject(input);
		String teamBranchId = "0";

		List<Object[]> axelaEmp = new ArrayList<Object[]>();
		Map output = new HashMap<String, List>();
		if (!inputObj.isNull("teamBranchId")) {
			teamBranchId = CNumeric(inputObj.getString("teamBranchId"));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!teamBranchId.equals("0")) {
			axelaEmp = empRepository.findByTeamBranchId(Integer.parseInt(teamBranchId));
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", "0");
			map.put("name", "Select");
			list.add(map);
			for (Object[] axelaEmps : axelaEmp) {
				map = new HashMap<String, String>();
				map.put("key", axelaEmps[0] + "");
				map.put("name", axelaEmps[1] + " (" + axelaEmps[2] + ")");
				list.add(map);
			}
		}
		output.put("populateCRMFollowUpExecutive", list);
		return output;
	}
	// end populate CRM fallow_up executive

	// start populate PBF fallow_up executive
	public Map populatePBFFollowUpExecutive(String input) throws JSONException {
		inputObj = new JSONObject(input);
		String teamBranchId = "0";

		List<Object[]> axelaEmp = new ArrayList<Object[]>();
		Map output = new HashMap<String, List>();
		if (!inputObj.isNull("teamBranchId")) {
			teamBranchId = CNumeric(inputObj.getString("teamBranchId"));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!teamBranchId.equals("0")) {
			axelaEmp = empRepository.findByTeamBranchId(Integer.parseInt(teamBranchId));
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", "0");
			map.put("name", "Select");
			list.add(map);
			for (Object[] axelaEmps : axelaEmp) {
				map = new HashMap<String, String>();
				map.put("key", axelaEmps[0] + "");
				map.put("name", axelaEmps[1] + " (" + axelaEmps[2] + ")");
				list.add(map);
			}
		}
		output.put("populatePBFFollowUpExecutive", list);
		return output;
	}
	// end populate PBF fallow_up executive

	// start populate PSF fallow_up executive
	public Map populatePSFFOllowUpExecutive(String input) throws JSONException {
		inputObj = new JSONObject(input);
		String teamBranchId = "0";

		List<Object[]> axelaEmp = new ArrayList<Object[]>();
		Map output = new HashMap<String, List>();
		if (!inputObj.isNull("teamBranchId")) {
			teamBranchId = CNumeric(inputObj.getString("teamBranchId"));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!teamBranchId.equals("0")) {
			axelaEmp = empRepository.findByTeamBranchId(Integer.parseInt(teamBranchId));
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", "0");
			map.put("name", "Select");
			list.add(map);
			for (Object[] axelaEmps : axelaEmp) {
				map = new HashMap<String, String>();
				map.put("key", axelaEmps[0] + "");
				map.put("name", axelaEmps[1] + " (" + axelaEmps[2] + ")");
				list.add(map);
			}
		}
		output.put("populatePSFFollowUpExecutive", list);
		return output;
	}
	// end populate PSF fallow_up executive

	public Map<String, String> PopulatePurchaseDiscountType() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		map.put("Select", "0");
		map.put("Amount", "1");
		map.put("Percentage", "2");
		list.add(map);
		output.put("populatePurchaseDiscountType", list);
		return output;
	}

	public Map<String, String> PopulateSalesRateClass(String input) throws JSONException {
		Map output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("rateclassType")) {
			rateclassType = CNumeric(inputObj.getString("rateclassType"));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> axelaInventoryUom = axelaRateClassRepository.findBySalesRateClass(rateclassType);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] objects : axelaInventoryUom) {
			map = new HashMap<String, String>();
			map.put("key", "" + objects[0]);
			map.put("name", "" + objects[1]);
			list.add(map);
		}
		output.put("populateRateClass", list);
		return output;
	}

	public Map<String, String> PopulateSalesRateTax() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<AxelaCustomer> axelaCustomer = customer_Repository.findSalesTax();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaCustomer objects : axelaCustomer) {
			map = new HashMap<String, String>();
			map.put("key", "" + objects.getCustomerId());
			map.put("name", objects.getCustomerName());
			list.add(map);
		}
		output.put("populateSalesTax", list);
		return output;
	}

	public Map<String, String> PopulatePurchaseRateClass() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<AxelaRateClass> axelaInventoryUom = axelaRateClassRepository.findByPurchaseRateClass();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaRateClass objects : axelaInventoryUom) {
			map = new HashMap<String, String>();
			map.put("key", "" + objects.getRateclassId());
			map.put("name", objects.getRateclassName());
			list.add(map);
		}
		output.put("populatePurchaseRateClass", list);
		return output;
	}

	// public Map<String, String> PopulateItemLedgers(String input, HttpServletResponse response) throws JSONException {s}

	public Map PopulateItemLedgers(String input, HttpServletResponse response) throws JSONException {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		inputObj = new JSONObject(input);
		String itemSalesLedgerId = "1";
		if (!inputObj.isNull("itemSalesLedgerId")) {
			itemSalesLedgerId = inputObj.getString("itemSalesLedgerId");
		}
		SOP("ledger_id" + itemSalesLedgerId);
		if (!itemSalesLedgerId.equals("0") && !itemSalesLedgerId.equals("")) {
			List<AxelaCustomer> axelaCustomer = customer_Repository.findItemLedger(Integer.parseInt(itemSalesLedgerId));
			if (axelaCustomer != null) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("key", "0");
				map.put("name", "Select");
				list.add(map);
				for (AxelaCustomer objects : axelaCustomer) {
					map = new HashMap<String, String>();
					map.put("key", "" + objects.getCustomerId());
					map.put("name", PadQuotes((objects.getAxelaAccGroupPop().getAccgrouppopName()) + ":" + objects.getCustomerName()));
					list.add((HashMap<String, String>) map);

				}
				output.put("populateItemLedgers", list);
			}
		} else {

			// still pending
			output.put("erromsg", "No Data Found!");
		}
		return output;
	}

	public Map ConfigFields() {
		// TODO Auto-generated method stub
		return null;
	}

	// start populate Executive For Team Add
	public Map<String, List> populateExecutives(String input, HttpSession session) throws JSONException {
		inputObj = new JSONObject(input);
		String teamBranchId = "0";
		List<Object[]> axelaEmp = new ArrayList<Object[]>();
		HashMap output = new HashMap<String, List>();
		if (!inputObj.isNull("teamBranchId")) {
			teamBranchId = CNumeric(inputObj.getString("teamBranchId"));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!teamBranchId.equals("0")) {
			String exeAccess = PadQuotes(getSession("exeAccess", session));
			SOP("exeAccess=================" + exeAccess);
			axelaEmp = teamFilterImpl.findByTeam(Integer.parseInt(teamBranchId));
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", "0");
			map.put("name", "Select");
			list.add(map);
			for (Object[] axelaEmps : axelaEmp) {
				map = new HashMap<String, String>();
				map.put("key", axelaEmps[0] + "");
				map.put("name", axelaEmps[1] + " (" + axelaEmps[2] + ")");
				list.add(map);
			}
		}
		output.put("populateExecutive", list);
		return output;
	}

	public Map<String, String> populateCatParent(String input, HttpServletResponse response) throws JSONException {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		inputObj = new JSONObject(input);
		int catId = 0;
		String active = "";
		if (!inputObj.isNull("catId")) {
			catId = Integer.parseInt(CNumeric(inputObj.getString("catId")));
		}
		if (!inputObj.isNull("active")) {
			active = CNumeric(inputObj.getString("active"));
		}
		List<AxelaInventoryCatPop> axelaInventoryCatPop = inventoryCatPopFilterImp.findAllCatIdAndCatName(catId, active);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaInventoryCatPop catpop : axelaInventoryCatPop) {
			map = new HashMap<String, String>();
			map.put("key", "" + catpop.getCatId());
			map.put("name", catpop.getCatName());
			list.add(map);
		}
		output.put("catParent", list);
		return output;
	}

	// popualate config details

	public Map populateConfigDetails(String input, HttpSession session) throws JSONException {
		JSONObject inputobj = new JSONObject(input);
		String compId = "0";
		output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		compId = CNumeric(getSession("compId", session));
		if (!compId.equals("0")) {
			List<AxelaConfig> axelaConfig = axelaConfigRepository.findAll();
			AxelaComp axelaComp = axelaCompRepository.findOne(Integer.parseInt(compId));
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", "0");
			map.put("name", "Select");
			list.add(map);
			for (AxelaConfig config : axelaConfig) {
				map = new HashMap<String, String>();
				map.put("configSalesSoe", "" + config.getConfigSalesSoe());
				map.put("configSalesSob", config.getConfigSalesSob());
				map.put("configCustomerSob", "" + config.getConfigCustomerSob());
				map.put("configCustomerSoe", "" + config.getConfigCustomerSoe());
				map.put("configSalesCampaign", "" + config.getConfigSalesCampaign());
				map.put("configSalesOpprName", "" + config.getConfigSalesOpprName());
				map.put("configCustomerAddress", "" + config.getConfigCustomerAddress());
				map.put("configSalesOpprItem", "" + config.getConfigSalesOpprItem());
				map.put("configSalesOpprRefno", "" + config.getConfigSalesOpprRefno());
				map.put("configCustomerName", "" + config.getConfigCustomerName());
				map.put("configSalesOpprModel", "" + config.getConfigSalesOpprModel());
				map.put("configSalesOpprModel", "" + config.getConfigSalesOpprItem());
				map.put("configSalesOpprModel", "" + config.getConfigSalesOpprItem());
				map.put("configSalesOpprModel", "" + config.getConfigSalesOpprRefno());
				map.put("configInventoryLocationName", "" + config.getConfigInventoryLocationName());
				map.put("compModulePm", "" + axelaComp.getCompModulePm());
				list.add(map);
			}
		}
		output.put("populateconfigdetails", list);
		if (AppRun().equals("0")) {
		}
		return output;
	}

	public Map<String, String> PopulateSourceType() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> axelaServiceTicketSource = serviceTicketSourceRepository.findByTicketsourceId();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] results : axelaServiceTicketSource) {
			map = new HashMap<String, String>();
			map.put("key", "" + results[0].toString());
			map.put("name", results[1].toString());
			list.add(map);
		}
		output.put("populateSource", list);
		return output;

	}

	public Map<String, String> PopulateTicketPriority() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> axelaServiceTicketPriority = serviceTicketPriorityRepository.findByTicketPriority();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] results : axelaServiceTicketPriority) {
			map = new HashMap<String, String>();
			map.put("key", "" + results[0].toString());
			map.put("name", results[1].toString());
			list.add(map);
		}
		output.put("key", "ticket.axelaHelpDeskTicketPriority.priorityticketId");
		output.put("populateTicketPriority", list);
		return output;
	}

	public Map<String, String> PopulateQueue() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> axelaServiceTicketQueue = axelaTicketQueueRepository.findByQueue();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] results : axelaServiceTicketQueue) {
			map = new HashMap<String, String>();
			map.put("key", "" + results[0].toString());
			map.put("name", results[1].toString());
			list.add(map);
		}
		output.put("populateQueue", list);
		return output;

	}

	public Map<String, String> PopulateExecutive(HttpSession session, String input) throws JSONException {
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("customerBranchId")) {
			customerBranchId = CNumeric(PadQuotes(inputObj.getString("customerBranchId")));
		}
		String exeAccess = PadQuotes(getSession("exeAccess", session));
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> PopulateExecutive = empFilterImpl.findByExecutive(exeAccess, customerBranchId);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] results : PopulateExecutive) {
			map = new HashMap<String, String>();
			map.put("key", "" + results[0].toString());
			map.put("name", results[1].toString());
			list.add(map);
		}
		output.put("populateExecutive", list);
		return output;
	}
	public Map<String, String> PopulateAllExecutive(HttpSession session) {
		String exeAccess = PadQuotes(getSession("exeAccess", session));
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> PopulateAllExecutive = empFilterImpl.findByAllExecutive(exeAccess);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] results : PopulateAllExecutive) {
			map = new HashMap<String, String>();
			map.put("key", "" + results[0].toString());
			map.put("name", results[1].toString());
			list.add(map);
		}
		output.put("populateAllExecutive", list);
		return output;
	}
	public Map<String, String> PopulateContract(String input, HttpSession session) throws JSONException {
		Map output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("ticketContactId")) {
			ticketContactId = CNumeric(PadQuotes(inputObj.getString("ticketContactId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> PopulateContract = serviceContractImpl.findByContract(ticketContactId, session);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] results : PopulateContract) {
			map = new HashMap<String, String>();
			map.put("key", "" + results[0].toString());
			map.put("name", results[1].toString());
			list.add(map);
		}
		output.put("populateContract", list);
		return output;
	}
	public Map<String, String> PopulateProject(String input) throws JSONException {
		Map output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("ticketCustomerId")) {
			ticketCustomerId = CNumeric(PadQuotes(inputObj.getString("ticketCustomerId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> populateProject = pmFilterImpl.findByProject(ticketCustomerId);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] results : populateProject) {
			map = new HashMap<String, String>();
			map.put("key", "" + results[0].toString());
			map.put("name", results[1].toString());
			list.add(map);
		}
		output.put("populateProject", list);
		return output;
	}

	public Map<String, String> PopulateTicketType() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> axelaServiceTicketSource = serviceTicketTypeRepository.findByTicketTypeId();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] results : axelaServiceTicketSource) {
			map = new HashMap<String, String>();
			map.put("key", "" + results[0].toString());
			map.put("name", results[1].toString());
			list.add(map);
		}
		output.put("key", "ticket.axelaHelpDeskTicketType.tickettypeId");
		output.put("populateTickettype", list);
		return output;
	}

	public Map<String, String> PopulateTicketStatus() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> axelaServiceTicketSource = axelaTicketStatusRepository.findByTicketStatusId();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] results : axelaServiceTicketSource) {
			map = new HashMap<String, String>();
			map.put("key", "" + results[0].toString());
			map.put("name", results[1].toString());
			list.add(map);
		}
		output.put("key", "ticket.axelaHelpDeskTicketStatus.ticketstatusId");
		output.put("populateTicketstatus", list);
		return output;
	}

	// start campaign branch
	public Map<String, List> populateCampaignBranch(String input) throws JSONException {
		inputObj = new JSONObject(input);
		String branchId = "0";
		String branchIds = "";
		List<AxelaBranch> axelaBranch = new ArrayList<AxelaBranch>();
		Map output = new HashMap<String, List>();
		if (!inputObj.isNull("branchId")) {
			branchId = CNumeric(inputObj.getString("branchId"));
		}
		if (!inputObj.isNull("branchIds")) {
			branchIds = PadQuotes(inputObj.getString("branchIds"));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!branchId.equals("0")) {
			axelaBranch = branchRepository.findByOne(Integer.parseInt(branchId));
		} else if (!branchIds.equals("")) {
			String strSearch = " AND a.branchId IN (" + branchIds + ")";
			axelaBranch = branchFilterImpl.branchFilter(strSearch);
		} else if (branchId.equals("0")) {
			axelaBranch = branchRepository.findAll();
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaBranch axelaBranchs : axelaBranch) {
			map = new HashMap<String, String>();
			map.put("key", axelaBranchs.getBranchId() + "");
			map.put("name", axelaBranchs.getBranchName());
			list.add(map);
		}
		output.put("populateCampaignBranch", list);
		return output;
	}
	// end campaign branch

	// start campaign type
	public Map<String, List> populateCampaignType(String input) throws JSONException {
		inputObj = new JSONObject(input);
		String camptypeId = "0";

		List<AxelaSalesCampaignType> axelaSalesCampaignType = new ArrayList<AxelaSalesCampaignType>();
		Map output = new HashMap<String, List>();
		if (!inputObj.isNull("camptypeId")) {
			camptypeId = CNumeric(inputObj.getString("camptypeId"));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (camptypeId.equals("0")) {
			axelaSalesCampaignType = salesCampaignTypeRepository.findAll();
		} else {
			axelaSalesCampaignType = salesCampaignTypeRepository.findAll();
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaSalesCampaignType axelaSalesCampaignTypes : axelaSalesCampaignType) {
			map = new HashMap<String, String>();
			map.put("key", axelaSalesCampaignTypes.getCamptypeId() + "");
			map.put("name", axelaSalesCampaignTypes.getCamptypeDesc());
			list.add(map);
		}
		output.put("populateCampaignType", list);
		return output;
	}

	// Start populate Branch
	public Map<String, String> populateBranch(String input, HttpSession session) throws JSONException {
		inputObj = new JSONObject(input);
		String requestType = "";
		Map output = new HashMap();
		String empId = "0";
		String branchIds = "";
		List<AxelaBranch> axelaBranch = new ArrayList<AxelaBranch>();
		String strSearch = "";
		strSearch = PadQuotes(getSession("branchAccess", session));
		strSearch += PadQuotes(getSession("empAccess", session));
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (!inputObj.isNull("branchIds")) {
			branchIds = PadQuotes(inputObj.getString("branchIds"));
		}
		if (!branchIds.equals("")) {
			strSearch += " AND branch.branchId IN (" + branchIds + ")";
		}
		if (requestType.equals("filter")) {
			JSONArray franchiseeIds = new JSONArray();
			if (!inputObj.isNull("franchiseeIds")) {
				if (inputObj.get("franchiseeIds") instanceof JSONArray)
					strSearch += " AND branch.branchId IN (" + jsonArrayToString(franchiseeIds) + ")";
			}
		} else if (!requestType.equals("filter") && branchIds.equals("")) {
			output.put("selectedKey", CNumeric(getSession("empBranchId", session)));
		}
		axelaBranch = branchFilterImpl.branchFilter(strSearch);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaBranch branch : axelaBranch) {
			map = new HashMap<String, String>();
			map.put("key", "" + branch.getBranchId());
			map.put("name", branch.getBranchName());
			list.add(map);
		}
		if (requestType.equals("filter"))
			output.put("key", "branch.branchId");
		output.put("populateBranch", list);
		return output;
	}
	// end populate Branch

	// populate manager..in sales=====TEAM ADD
	public Map<String, String> populateManager(String input, HttpSession session) throws JSONException {
		SOP("inside populateManager ");
		inputObj = new JSONObject(input);
		Map output = new HashMap();
		String compId = getSession("compId", session);
		int empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		String branchId = "0";
		String teamBranchId = "0";
		String empBranchId = "0";
		if (empId != 0) {
			List<Object[]> axelaEmp = new ArrayList<Object[]>();

			if (!inputObj.isNull("branchId")) {
				branchId = CNumeric(PadQuotes(inputObj.getString("branchId")));
			}

			if (!inputObj.isNull("teamBranchId")) {
				teamBranchId = CNumeric(PadQuotes(inputObj.getString("teamBranchId")));
			}

			if (!branchId.equals("0")) {
				empBranchId = branchId;
				axelaEmp = empRepository.findByEmpBranchIds(Integer.parseInt(empBranchId));
			} else if (!teamBranchId.equals("0")) {
				empBranchId = teamBranchId;
				axelaEmp = empRepository.findByEmpBranchIds(Integer.parseInt(empBranchId));
			} else {
				axelaEmp = empRepository.findEmpDetail();
			}

			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", "0");
			map.put("name", "Select");
			list.add(map);
			for (Object[] emp : axelaEmp) {
				map = new HashMap<String, String>();
				map.put("key", "" + emp[0]);
				map.put("name", "" + emp[1] + emp[2]);
				list.add(map);
			}

			output.put("populateManager", list);
			if (AppRun().equals("0")) {
			}

		}
		return output;
	}
	// // populate CRM Follow-up Executive
	public Map populateCRMFollowUpExecutive(String input, HttpSession session) throws JSONException {
		inputObj = new JSONObject(input);
		Map output = new HashMap();
		int empId = Integer.parseInt(getSession("empId", session));
		String compId = getSession("compId", session);
		String branchAccess = getSession("branchAccess", session).replaceAll("branchId", "a.branchId");
		List<Object[]> axelaBranch = new ArrayList<Object[]>();
		String branchId = "0";
		if (!inputObj.isNull("branchId")) {
			branchId = inputObj.getString("branchId");
		}
		if (!branchId.equals("0")) {
			axelaBranch = empRepository.findByTeamBranchId(Integer.parseInt(branchId));

			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", "0");
			map.put("name", "Select");
			list.add(map);
			for (Object[] axelaEmps : axelaBranch) {
				map = new HashMap<String, String>();
				map.put("key", axelaEmps[0] + "");
				map.put("name", axelaEmps[1] + " (" + axelaEmps[2] + ")");
				list.add(map);
			}
			output.put("followUpExecutive", list);
		}

		return output;
	}

	public Map<String, String> PopulateLostCase1() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> axelaSalesOpprLostcase1 = salesLostCase1Repository.findByLastCase1();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] results : axelaSalesOpprLostcase1) {
			map = new HashMap<String, String>();
			map.put("key", "" + results[0].toString());
			map.put("name", results[1].toString());
			list.add(map);
		}
		output.put("PopulateLostCase1", list);
		return output;
	}

	public Map<String, String> PopulateLostCase2(String input) throws JSONException {
		Map output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("opprLostcase1Id")) {
			opprLostcase1Id = CNumeric(PadQuotes(inputObj.getString("opprLostcase1Id")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> axelaSalesOpprLostcase2 = salesLostCase2Repository.findByLostCase2(Integer.parseInt(opprLostcase1Id));
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] results : axelaSalesOpprLostcase2) {
			map = new HashMap<String, String>();
			map.put("key", "" + results[0].toString());
			map.put("name", results[1].toString());
			list.add(map);
		}
		output.put("PopulateLostCase2", list);
		return output;
	}

	public Map<String, String> PopulateLostCase3(String input) throws JSONException {
		Map output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("opprLostcase2Id")) {
			opprLostcase2Id = CNumeric(PadQuotes(inputObj.getString("opprLostcase2Id")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> axelaSalesOpprLostcase3 = salesLostCase3Repository.findByLastCase3(Integer.parseInt(opprLostcase2Id));
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] results : axelaSalesOpprLostcase3) {
			map = new HashMap<String, String>();
			map.put("key", "" + results[0].toString());
			map.put("name", results[1].toString());
			list.add(map);
		}
		output.put("PopulateLostCase3", list);
		return output;
	}

	public Map<String, String> populatePriority() throws JSONException {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> AxelaSalesOpprPriority = axelaSalesPriorityRepository.findByPriorityName();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] results : AxelaSalesOpprPriority) {
			map = new HashMap<String, String>();
			map.put("key", "" + results[0].toString());
			map.put("name", results[1].toString());
			list.add(map);
		}
		output.put("populatePriority", list);
		return output;
	}

	public Map<String, String> populateLocation(String input, HttpServletResponse response) throws JSONException {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		inputObj = new JSONObject(input);
		int branchId = 0;
		if (!inputObj.isNull("branchId")) {
			branchId = Integer.parseInt(CNumeric(inputObj.getString("branchId")));
		}
		if (branchId != 0) {
			List<AxelaInventoryLocation> axelaInventoryLocation = inventoryLocationFilter.populateLocation(branchId);
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", "0");
			map.put("name", "Select");
			list.add(map);
			for (AxelaInventoryLocation inventoryLocation : axelaInventoryLocation) {
				map = new HashMap<String, String>();
				map.put("key", "" + inventoryLocation.getLocationId());
				map.put("name", inventoryLocation.getLocationName() + "(" + inventoryLocation.getLocationCode() + ")");
				list.add(map);
			}
		}
		output.put("populateLocation", list);
		return output;
	}

	public Map parentBin(String input, HttpServletResponse response) throws JSONException {
		String binLocationId = "0", binActive = "0", binId = "0", StrSql = "";
		inputObj = new JSONObject(input);

		Map output = new LinkedHashMap<String, String>();

		if (!inputObj.isNull("binLocationId")) {
			binLocationId = inputObj.getString("binLocationId");
		}

		if (!inputObj.isNull("binActive")) {
			binActive = inputObj.getString("binActive");
		}

		if (!inputObj.isNull("binId")) {
			binId = inputObj.getString("binId");
		}
		if (binActive.equals("0")) {
			binActive = "1";
		}

		StrSql = "SELECT  NEW AxelaInventoryBinPop(binParent.binId, binParent.binName)"
				+ " FROM AxelaInventoryBinPop binParent"
				+ " WHERE 1=1 "
				+ " AND binParent.binLocationId = " + binLocationId + "";

		if (!binActive.equals("0")) {
			StrSql += " AND binParent.binActive = " + binActive + "";
		}

		if (!CNumeric(binId).equals("0")) {
			StrSql += " AND binParent.binId != " + binId + ""
					+ " AND binParent.binId < " + binId + "";
		}

		List<AxelaInventoryBinPop> parentBin = inventoryBinPopFilterImpl.populateParentBin(StrSql);
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaInventoryBinPop obj : parentBin) {
			map = new HashMap<String, String>();
			map.put("key", "" + obj.getBinId());
			map.put("name", obj.getBinName());
			list.add(map);
		}
		output.put("populateParentBin", list);
		return output;
	}

	public Map populateCurrentDate(String input) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		Map output = new HashMap();
		String requestType = "";
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (requestType.equals("longDate")) {
			output.put("date", strToLongDate((kknow())));
		} else {
			output.put("date", strToShortDate((kknow())));
		}
		return output;
	}

	public Map populateFollowupDescription(String input, HttpSession session) {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap map = new HashMap();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] obj : followupDescriptionRepository.findfollowupdescIdAndfollowupdescName()) {
			map = new HashMap();
			map.put("key", obj[0].toString());
			map.put("name", obj[1]);
			list.add(map);
		}
		output.put("populateFollowupDescription", list);

		return output;
	}
	public Map populateFollowupType(String input, HttpSession session) {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap map = new HashMap();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaSalesOpprFollowupType obj1 : followupTypeRepository.findAll()) {

			map = new HashMap();
			map.put("key", obj1.getFollowuptypeId() + "");
			map.put("name", obj1.getFollowuptypeName());
			list.add(map);
		}
		output.put("populateFollowupType", list);

		return output;
	}

	public Map<String, List> populateExecutive(String input) throws JSONException {
		inputObj = new JSONObject(input);
		String empId = "0";

		List<Object[]> axelaEmp = new ArrayList<Object[]>();
		Map output = new HashMap<String, List>();
		if (!inputObj.isNull("empId")) {
			empId = CNumeric(inputObj.getString("empId"));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (empId.equals("0")) {
			axelaEmp = empRepository.findAllactivity();
		} else {
			axelaEmp = empRepository.findByActivityId(Integer.parseInt(empId));
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] axelaEmps : axelaEmp) {
			map = new HashMap<String, String>();
			map.put("key", axelaEmps[0] + "");
			map.put("name", axelaEmps[1] + "");
			list.add(map);
		}
		output.put("populateExecutive", list);
		return output;
	}

	public Map<String, List> populateActivityPriority(String input) throws JSONException {
		inputObj = new JSONObject(input);
		String priorityId = "0";

		List<Object[]> axelaActivitPriority = new ArrayList<Object[]>();
		Map output = new HashMap<String, List>();
		if (!inputObj.isNull("priorityId")) {
			priorityId = inputObj.getString("priorityId");
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (priorityId.equals("0")) {
			axelaActivitPriority = activityPriorityRepository.findAllActivityPriority();
		} else {
			axelaActivitPriority = activityPriorityRepository.findByActiityPeiorityId(Integer.parseInt(priorityId));
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] axelaActivitPrioritys : axelaActivitPriority) {
			map = new HashMap<String, String>();
			map.put("key", axelaActivitPrioritys[0] + "");
			map.put("name", axelaActivitPrioritys[1] + "");
			list.add(map);
		}
		output.put("populatePriority", list);
		return output;
	}
	public Map<String, String> populateCustomer(String input, HttpSession session) throws JSONException {
		inputObj = new JSONObject(input);
		List<AxelaCustomer> axelaCustomers = new ArrayList<AxelaCustomer>();
		int compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		PageRequest request = new PageRequest(1, 10, Sort.Direction.DESC, customerId);
		Map output = new HashMap();
		// if (!inputObj.isNull("customerId")) {
		// customerId = CNumeric(PadQuotes(inputObj.getString("customerId")));
		// }
		// if (!customerId.equals("0")) {
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		List<Object[]> Customer = Customerfilterimpl.findByCustomerIdAndCustomerName(customerId);
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] results : Customer) {
			map.put("key", "" + results[0]);
			map.put("name", "" + results[1]);
			list.add(map);
			// }

			output.put("populateCustomer", list);
		}
		return output;
	}

	public Map<String, List> populateServiceContractLocation(String input, HttpSession session) throws JSONException {
		inputObj = new JSONObject(input);
		Map output = new HashMap<String, List>();
		if (!inputObj.isNull("assetCustomerId")) {
			assetCustomerId = CNumeric(PadQuotes(inputObj.getString("assetCustomerId")));
		}
		if (!assetCustomerId.equals("0")) {
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", "0");
			map.put("name", "Select");
			list.add(map);
			for (Object[] axelaservices : serviceContractLocationRepository.findByContractLocId(Integer.parseInt(assetCustomerId))) {
				map = new HashMap<String, String>();
				map.put("key", axelaservices[0].toString());
				map.put("name", axelaservices[1].toString());
				list.add(map);
			}
			output.put("populateServiceContractLocation", list);
		}
		return output;
	}
	public Map<String, List> populateType() {
		Map output = new HashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] axelatype : serviceContractAssetTypeRepository.findByContractAssetTypeId()) {
			map = new HashMap<String, String>();
			map.put("key", axelatype[0].toString());
			map.put("name", axelatype[1].toString());
			list.add(map);
		}
		output.put("populateType", list);
		return output;
	}
	public Map<String, List> populateBrand() {
		Map output = new HashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] axelabrand : serviceContractAssetBrandRepository.findByServiceContractAssetBrand()) {
			map = new HashMap<String, String>();
			map.put("key", axelabrand[0].toString());
			map.put("name", axelabrand[1].toString());
			list.add(map);
		}
		output.put("populateBrand", list);
		return output;
	}

	public Map populateConfigServiceDetails() throws JSONException {
		List<AxelaConfig> axelaConfig = axelaConfigRepository.findAll();
		HashMap output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaConfig config : axelaConfig) {
			map.put("configServiceJobcardType", "" + config.getConfigServiceJobcardType());
			map.put("configServiceJobcardCat", "" + config.getConfigServiceJobcardCat());
			map.put("configServiceJobcardRefno", "" + config.getConfigServiceJobcardRefno());
			map.put("configServiceJobcardSerialnoMandatory", "" + config.getConfigServiceJobcardSerialnoMandatory());
			map.put("configServiceTicketType", "" + config.getConfigHelpdeskTicketType());
			map.put("configServiceTicketRefno", "" + config.getConfigHelpDeskTicketRefno());
			map.put("configServiceTicketCat", "" + config.getConfigHelpDeskTicketCat());
			list.add(map);
		}

		output.put("populateConfigTicketDetails", list);
		if (AppRun().equals("0")) {
		}
		return output;
	}
	public Map<String, String> populateJcCategory() {
		HashMap output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaServiceJcCat obj : jccategoryrepository.findAll()) {
			map = new HashMap<String, String>();
			map.put("key", "" + obj.getJccatId());
			map.put("name", obj.getJccatName());
			list.add(map);
		}
		output.put("populateJcCategory", list);
		if (AppRun().equals("0")) {
			SOP("output========WS_222222222222222222222222===========" + output.toString());
		}
		return output;
	}
	public Map<String, List> populatejcType() {
		SOP("populatejcPriority");
		HashMap output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaServiceJcType JcTyp : jctyperepository.findAll()) {
			map = new HashMap<String, String>();
			map.put("key", "" + JcTyp.getJctypeId());
			map.put("name", JcTyp.getJctypeName());
			list.add(map);
		}
		output.put("populateJcType", list);
		return output;
	}

	// populating populatejobcardtype
	public Map<String, List> populatejcPriority() {
		HashMap output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaServiceJcPriority JcPriority : jobcartpriorityrepository.findAll()) {
			map = new HashMap<String, String>();
			map.put("key", "" + JcPriority.getPriorityjcId());
			map.put("name", JcPriority.getPriorityjcName());
			list.add(map);
		}
		output.put("populateJcPriority", list);
		output.put("key", "priority.priorityjcId");
		return output;
	}

	public Map<String, List> populatejcStatus(String input) throws JSONException {
		HashMap output = new HashMap();
		inputObj = new JSONObject(input);
		String requestType = "";
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<AxelaServiceJcStatus> AxelaServiceJcStatus = jcstatusrepository.findAll();
		if (requestType.equals("filter")) {
			output.put("key", "status.jcstatusId");
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaServiceJcStatus obj : AxelaServiceJcStatus) {
			map = new HashMap<String, String>();
			map.put("key", "" + obj.getJcstatusId());
			map.put("name", obj.getJcstatusName());
			list.add(map);
		}
		output.put("populateJcStatus", list);
		return output;
	}

	public Map<String, List> PopulatetaskParent(String input) throws JSONException {
		inputObj = new JSONObject(input);
		String pmId = "0";

		output = new HashMap<String, List>();
		if (!inputObj.isNull("pmId")) {
			pmId = CNumeric(inputObj.getString("pmId"));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] axelapmtask : taskrepository.findByPopulateParentTask(Integer.parseInt(pmId))) {
			map = new HashMap<String, String>();
			map.put("key", axelapmtask[0] + "");
			map.put("name", axelapmtask[1] + "");
			list.add(map);
		}
		output.put("populateTaskParent", list);
		return output;
	}

	public Map populateTechnicianExecutive(String input) throws JSONException {
		inputObj = new JSONObject(input);
		String branchId = "0";
		List<AxelaEmp> axelaEmp = new ArrayList<AxelaEmp>();
		HashMap output = new HashMap();
		if (!inputObj.isNull("branchId")) {
			branchId = CNumeric(inputObj.getString("branchId"));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!branchId.equals("0")) {
			axelaEmp = empRepository.findEmptech(Integer.parseInt(branchId));
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaEmp axelaEmps : axelaEmp) {
			map = new HashMap<String, String>();
			map.put("key", "" + axelaEmps.getEmpId());
			map.put("name", axelaEmps.getEmpName());
			list.add(map);
		}
		output.put("populateTechnicianExecutive", list);
		if (AppRun().equals("0")) {
			SOP("output========WS_jobcradaddd===========" + output.toString());
		}
		return output;
	}
	// end Populate technician executive

	// start Populate service advisor
	public Map populateServiceAdvisor(String input, HttpSession session) throws JSONException {
		inputObj = new JSONObject(input);
		String branchId = "0";
		if (!inputObj.isNull("branchId")) {
			branchId = inputObj.getString("branchId");
		}
		List<AxelaEmp> axelaEmp = new ArrayList<AxelaEmp>();
		HashMap output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!branchId.equals("0")) {
			axelaEmp = empRepository.findEmpadv(Integer.parseInt(branchId));
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaEmp axelaEmps : axelaEmp) {
			map = new HashMap<String, String>();
			map.put("key", "" + axelaEmps.getEmpId());
			map.put("name", axelaEmps.getEmpName());
			list.add(map);
		}
		output.put("populateServiceAdvisor", list);
		if (AppRun().equals("0")) {
			SOP("output========WS_11111111111111111d===========" + output.toString());
		}
		return output;
	}

	public Map<String, List> populateBay(String input) throws JSONException {
		inputObj = new JSONObject(input);
		String bayId = "0";
		String jcBranchId = "0";

		List<Object[]> axelaServiceJcBay = new ArrayList<Object[]>();
		Map output = new HashMap<String, List>();
		if (!inputObj.isNull("bayId")) {
			bayId = CNumeric(inputObj.getString("bayId"));
		}
		if (!inputObj.isNull("jcBranchId")) {
			jcBranchId = CNumeric(inputObj.getString("jcBranchId"));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (bayId.equals("0")) {
			axelaServiceJcBay = serviceJcBayRepository.findAllBay(Integer.parseInt(jcBranchId));
		} else {
			axelaServiceJcBay = serviceJcBayRepository.findAllBay(Integer.parseInt(jcBranchId));
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] axelaServiceJcBays : axelaServiceJcBay) {
			map = new HashMap<String, String>();
			map.put("key", axelaServiceJcBays[0] + "");
			map.put("name", axelaServiceJcBays[1] + "");
			list.add(map);
		}
		output.put("populateJcBays", list);
		return output;
	}

	public Map<String, List> PopulateInventoryLocation(String input) throws JSONException {
		inputObj = new JSONObject(input);
		String locationId = "0";

		List<Object[]> axelaInventoryLocation = new ArrayList<Object[]>();
		Map output = new HashMap<String, List>();
		if (!inputObj.isNull("locationId")) {
			locationId = CNumeric(inputObj.getString("locationId"));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (locationId.equals("0")) {
			axelaInventoryLocation = inventoryLocationRepository.findAllLocation();
		} else {
			axelaInventoryLocation = inventoryLocationRepository.findAllLocationById(Integer.parseInt(locationId));
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] axelaInventoryLocations : axelaInventoryLocation) {
			map = new HashMap<String, String>();
			map.put("key", axelaInventoryLocations[0] + "");
			map.put("name", axelaInventoryLocations[1] + "");
			list.add(map);
		}
		output.put("populateInventoryLocation", list);
		return output;
	}

	public Map<String, String> populateeTicketCategory(String input) throws JSONException {
		Map output = new HashMap();
		String ticketqueueId = "0";
		inputObj = new JSONObject(input);
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<AxelaHelpDeskTicketCat> axelaServiceTicketSource = new ArrayList<AxelaHelpDeskTicketCat>();// helpDeskTicketCatRepository.findByTicketcatId();
		if (!inputObj.isNull("ticketqueueId")) {
			ticketqueueId = CNumeric(PadQuotes(inputObj.getString("ticketqueueId")));
		}
		if (!ticketqueueId.equals("0")) {
			ticketcatId = ticketqueueId;
			axelaServiceTicketSource = helpDeskTicketCatRepository.findByTicketcatId(Integer.parseInt(ticketqueueId));
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", "0");
			map.put("name", "Select");
			list.add(map);
			for (AxelaHelpDeskTicketCat results : axelaServiceTicketSource) {
				map = new HashMap<String, String>();
				map.put("key", "" + results.getTicketcatId());
				map.put("name", results.getTicketcatName());
				list.add(map);
			}
		}
		output.put("populateTicketCategory", list);
		return output;
	}

	public Map<String, String> populateQueue() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> axelaServiceTicketQueue = axelaTicketQueueRepository.findByQueue();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] results : axelaServiceTicketQueue) {
			map = new HashMap<String, String>();
			map.put("key", "" + results[0].toString());
			map.put("name", results[1].toString());
			list.add(map);
		}
		output.put("populateQueue", list);
		return output;

	}

	public Map populateConfig() throws JSONException {
		List<AxelaConfig> axelaConfig = axelaConfigRepository.findAll();
		HashMap output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (AxelaConfig config : axelaConfig) {
			map.put("configCustomerName", "" + config.getConfigCustomerName());
			map.put("configSalesOpprName", "" + config.getConfigSalesOpprName());
			map.put("configInventoryLocationName", "" + config.getConfigInventoryLocationName());
			list.add(map);
		}

		output.put("populateConfig", list);
		if (AppRun().equals("0")) {
		}
		return output;
	}

	public Map<String, List> populateContractType() {
		Map output = new HashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] ContractType : serviceContractTypeRepository.findByContracttypeIdAndContracttypeName()) {
			map = new HashMap<String, String>();
			map.put("key", ContractType[0].toString());
			map.put("name", ContractType[1].toString());
			list.add(map);
		}
		output.put("populateContractType", list);
		return output;
	}

	public Map<String, String> PopulatePriority() {
		Map output = new HashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] Priority : serviceContractPriorityRepository.findByPrioritycontractIdAndPrioritycontractName()) {
			map = new HashMap<String, String>();
			map.put("key", "" + Priority[0]);
			map.put("name", "" + Priority[1]);
			list.add(map);
		}
		output.put("populatePriority", list);
		return output;
	}

	public Map<String, String> PopulateFaqCategory() {
		Map output = new HashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] Category : faqCatRepository.findByPopulateFaqCategory()) {
			map = new HashMap<String, String>();
			map.put("key", Category[0].toString());
			map.put("name", Category[1].toString());
			list.add(map);
		}
		output.put("populateFaqCategory", list);
		return output;
	}
	// ticket-category
	public Map<String, String> populateTicketCategory(String input) throws JSONException {
		Map output = new HashMap();
		inputObj = new JSONObject(input);
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<AxelaHelpDeskTicketCat> axelaServiceTicketSource = new ArrayList<AxelaHelpDeskTicketCat>();// helpDeskTicketCatRepository.findByTicketcatId();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] results : helpDeskTicketCatRepository.findByTicketcatttId()) {
			map = new HashMap<String, String>();
			map.put("key", "" + results[0]);
			map.put("name", "" + results[1]);
			list.add(map);
		}
		output.put("key", "ticket.axelaHelpDeskTicketCat.ticketcatId");
		output.put("populateTicketCategory", list);
		return output;
	}

	// customer selectTo
	public Map<String, String> populateCustomerSelectTo(WebRequest webRequest) throws JSONException {
		String customerName = "";
		String customerId = "0";
		String requestType = "";
		Map output = new LinkedHashMap();
		PageRequest request = null;
		request = new PageRequest(1, 20, Sort.Direction.ASC, "customerId");
		customerName = PadQuotes(webRequest.getParameter(("customerName")));
		customerId = CNumeric(PadQuotes(webRequest.getParameter(("customerId"))));
		if (AppRun().equals("0")) {
		}
		if (!customerId.equals("0") || !customerName.equals("")) {
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			List<AxelaCustomer> Customer = customerFilterImpl.findByIdAndName(Integer.parseInt(customerId), customerName, request);
			for (AxelaCustomer obj : Customer) {
				LinkedHashMap map = new LinkedHashMap();
				map.put("id", obj.getCustomerId());
				map.put("text", obj.getCustomerName());
				list.add(map);
			}
			if (requestType.equals("filter")) {
				output.put("key", "customer.customerId");
			}
			output.put("results", list);
		}
		return output;
	}

	public Map populateEffectiveFrom(String input, HttpSession session, HttpServletResponse response) {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap map = new HashMap();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		map.put("key", "2");
		map.put("name", "Delivery Date");
		list.add(map);
		map = new HashMap();
		map.put("key", "1");
		map.put("name", "Sales Order Date");
		list.add(map);

		output.put("populateEffectiveFrom", list);

		return output;
	}
	public Map<String, List> populateContractTax() {
		Map output = new HashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] Tax : taxRepository.findByTaxIdTaxName()) {
			map = new HashMap<String, String>();
			map.put("key", Tax[0].toString());
			map.put("name", Tax[1].toString());
			list.add(map);
		}
		output.put("populateContractTax", list);
		return output;
	}

	public Map<String, List> populateContractContact(String input) throws JSONException {
		Map output = new HashMap();
		inputObj = new JSONObject(input);
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!inputObj.isNull("contractCustomerId")) {
			contractCustomerId = CNumeric(PadQuotes(inputObj.getString("contractCustomerId")));
		}
		if (!contractCustomerId.equals("0")) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", "0");
			map.put("name", "Select");
			list.add(map);
			for (Object[] contact : customerContactReposiitory.findByContactIdAndName(Integer.parseInt(contractCustomerId))) {
				map = new HashMap<String, String>();
				map.put("key", contact[0].toString());
				map.put("name", contact[1].toString());
				list.add(map);
			}
			output.put("populateContractContact", list);
		}
		return output;
	}

	public Map<String, List> populateProjectType(String input) throws JSONException {
		HashMap output = new HashMap();
		inputObj = new JSONObject(input);
		String requestType = "";
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (requestType.equals("filter")) {
			output.put("key", "pm.pmPmtypeId");
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] pmType : pmTypeRepository.findByPopulatePmType()) {
			map = new HashMap<String, String>();
			map.put("key", pmType[0].toString());
			map.put("name", pmType[1].toString());
			list.add(map);
		}
		output.put("populateProjectType", list);
		return output;
	}

	public Map<String, List> populateProjectStatus(String input) throws JSONException {
		HashMap output = new HashMap();
		inputObj = new JSONObject(input);
		String requestType = "";
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (requestType.equals("filter")) {
			output.put("key", "pm.pmPmstatusId");
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] pmStatus : pmStatusRepository.findByPopulatePmStatus()) {
			map = new HashMap<String, String>();
			map.put("key", pmStatus[0].toString());
			map.put("name", pmStatus[1].toString());
			list.add(map);
		}
		output.put("populateProjectStatus", list);
		return output;
	}

	public Map<String, List> populateTaskStatus(String input) throws JSONException {
		HashMap output = new HashMap();
		inputObj = new JSONObject(input);
		String requestType = "";
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (requestType.equals("filter")) {
			output.put("key", "task.taskTaskstatusId");
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] taskStatus : taskStatusRepository.findByPopulateTaskStatus()) {
			map = new HashMap<String, String>();
			map.put("key", taskStatus[0].toString());
			map.put("name", taskStatus[1].toString());
			list.add(map);
		}
		output.put("populateTaskStatus", list);
		return output;
	}

	public Map<String, List> populateTaskPriority(String input) throws JSONException {
		HashMap output = new HashMap();
		inputObj = new JSONObject(input);
		String requestType = "";
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (requestType.equals("filter")) {
			output.put("key", "task.taskPrioritytaskId");
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] taskPriority : taskPriorityRepository.findByPopulateTaskPriority()) {
			map = new HashMap<String, String>();
			map.put("key", taskPriority[0].toString());
			map.put("name", taskPriority[1].toString());
			list.add(map);
		}
		output.put("populateTaskPriority", list);
		return output;
	}
	public Map<String, List> populatePmMilestone(String input) throws JSONException {
		HashMap output = new HashMap();
		inputObj = new JSONObject(input);
		String requestType = "";
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (requestType.equals("filter")) {
			output.put("key", "pm.pmmilestoneId");
		}
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] pmMilestones : pmMilestonesRepository.findByPopulatePmMilestone()) {
			map = new HashMap<String, String>();
			map.put("key", pmMilestones[0].toString());
			map.put("name", pmMilestones[1].toString());
			list.add(map);
		}
		output.put("populatePmMilestones", list);
		return output;
	}

	public Map<String, List> populateJobtitle() {
		Map output = new HashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] obj : jobtitleRepository.findAllJobTitle()) {
			map = new HashMap<String, String>();
			map.put("key", obj[0].toString());
			map.put("name", obj[1].toString());
			list.add(map);
		}
		output.put("populateJobtitle", list);
		return output;
	}

	public Map<String, List> populateDepartment() {
		Map output = new HashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] obj : empDepartmentRepository.findAllDepartment()) {
			map = new HashMap<String, String>();
			map.put("key", obj[0].toString());
			map.put("name", obj[1].toString());
			list.add(map);
		}
		output.put("populateDepartment", list);
		return output;
	}

	public Map populateYear(String input, HttpSession session, HttpServletResponse response) {
		output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		int j = 1;
		HashMap map = new HashMap();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (int i = 1971; i <= 2007; i++) {
			map = new HashMap();
			map.put("key", j);
			map.put("name", i + "");
			list.add(map);
			j++;
		}
		output.put("populateYear", list);

		return output;
	}

	public Map populateInventoryGroups() {
		Map output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap map = new HashMap();
		map.put("key", "0");
		map.put("name", "Select");
		list.add(map);
		for (Object[] obj : inventoryGroupRepository.findGroupDetails()) {
			map = new HashMap();
			map.put("key", obj[0].toString());
			map.put("name", obj[1].toString());
			list.add(map);
		}
		output.put("populateInventoryGroups", list);
		return output;
	}

	public HashMap<String, String> jobcardSearch(String input, HttpServletResponse response) throws JSONException {
		String contactMobile1 = "";
		String contactEmail = "";
		output = new LinkedHashMap<String, String>();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("contactMobile1")) {
			SOP("coming");
			contactMobile1 = inputObj.getString("contactMobile1");
			List<AxelaCustomerContact> contact = customerFilterImpl.jcsearchMobile1(contactMobile1);
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", "0");
			map.put("name", "Select");
			list.add(map);
			for (AxelaCustomerContact obj : contact) {
				map = new HashMap<String, String>();
				map.put("jcSerialno", obj.getJcSerialno());
				map.put("contactName", obj.getContactName());
				map.put("contactMobile1", obj.getContactMobile1());
				map.put("contactId", "" + obj.getContactId());
				map.put("customerName", "" + obj.getCustomerName());
				map.put("customerId", "" + obj.getContactCustomerId());
				list.add(map);
			}
			output.put("populateContactMobile1", list);
			if (AppRun().equals("0")) {
				SOP("output =========AxelajobcardlistServi mobile============== " + output);
			}
		}
		if (!inputObj.isNull("jcSerialno")) {
			jcSerialno = inputObj.getString("jcSerialno");
			List<AxelaCustomerContact> contact = customerFilterImpl.jcSerialno(jcSerialno);
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", "0");
			map.put("name", "Select");
			list.add(map);
			for (AxelaCustomerContact obj : contact) {
				map = new HashMap<String, String>();
				map.put("jcSerialno", obj.getJcSerialno());
				map.put("contactName", obj.getContactName());
				map.put("customerName", "" + obj.getCustomerName());
				map.put("customerId", "" + obj.getContactCustomerId());
				map.put("contactId", "" + obj.getContactId());
				list.add(map);
			}
			output.put("populateJcSerialno", list);
			if (AppRun().equals("0")) {
				SOP("output =========AxelajobcardlistServi srial============== " + output);
			}
		}
		if (!inputObj.isNull("contactEmail")) {
			contactEmail = inputObj.getString("contactEmail");;
			List<AxelaCustomerContact> contact = customerFilterImpl.searchEmail(contactEmail);
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", "0");
			map.put("name", "Select");
			list.add(map);
			for (AxelaCustomerContact obj : contact) {
				map = new HashMap<String, String>();
				map.put("contactName", obj.getContactName());
				map.put("customerName", "" + obj.getCustomerName());
				map.put("customerId", "" + obj.getContactCustomerId());
				map.put("contactId", "" + obj.getContactId());
				map.put("jcSerialno", obj.getJcSerialno());
				list.add(map);
			}
			output.put("contactEmail", list);
		}
		return output;
	}

	public Map populateProjectTextFields() {
		Map map = new HashMap();
		output = new HashMap();
		List list = new ArrayList();
		list.add(appBuildSmartArr("Project ID", "numeric", "pm.pmId"));
		list.add(appBuildSmartArr("Project Name", "text", "pm.pmTitle"));
		list.add(appBuildSmartArr("Start Date", "datetime", "pm.pmStartDate"));
		list.add(appBuildSmartArr("End Date", "datetime", "pm.pmEndDate"));
		list.add(appBuildSmartArr("Percentage ", "numeric", "pm.pmCompletePerc"));
		output.put("text", list);
		return output;
	}

	public Map populateTaskTextFields() {
		Map map = new HashMap();
		output = new HashMap();
		List list = new ArrayList();
		list.add(appBuildSmartArr("Task ID", "numeric", "task.taskId"));
		list.add(appBuildSmartArr("Task Name", "text", "task.taskSubject"));
		list.add(appBuildSmartArr("Start Date", "datetime", "task.taskStartDate"));
		list.add(appBuildSmartArr("End Date", "datetime", "task.taskStartDate"));
		list.add(appBuildSmartArr("Completed ", "datetime", "task.taskCompletionDate"));
		list.add(appBuildSmartArr("Percentage ", "numeric", "task.taskCompletePerc"));
		output.put("text", list);
		return output;
	}
	public Map populateOpprTextFields() {
		Map map = new HashMap();
		output = new HashMap();
		List list = new ArrayList();
		list.add(appBuildSmartArr("Opportunity ID", "numeric", "oppr.opprId"));
		list.add(appBuildSmartArr("Opportunity No", "numeric", "oppr.opprNo"));
		list.add(appBuildSmartArr("Customer ID", "numeric", "oppr.opprCustomerId"));
		list.add(appBuildSmartArr("Customer Name", "text", "customer.customerName"));
		list.add(appBuildSmartArr("Contact ID", "numeric", "oppr.opprContactId"));
		list.add(appBuildSmartArr("Contact Name", "text", "oppr.axelaCustomerContact.contactFname"));
		list.add(appBuildSmartArr("Contact Mobile", "text", "oppr.axelaCustomerContact.contactMobile1"));
		output.put("text", list);
		return output;
	}

	public Map populateJobCardTextFields() {
		Map map = new HashMap();
		output = new HashMap();
		List list = new ArrayList();
		list.add(appBuildSmartArr("Jobcard ID", "numeric", "jc.jcId"));
		list.add(appBuildSmartArr("Customer ID", "numeric", "jc.jcCustomerId"));
		list.add(appBuildSmartArr("Customer Name", "text", "customer.customerName"));
		list.add(appBuildSmartArr("Contact ID", "numeric", "jc.jcContactId"));
		list.add(appBuildSmartArr("Contact Name", "text", "contact.contactFname"));
		list.add(appBuildSmartArr("Contact Mobile", "numeric", "contact.contactMobile1"));
		output.put("text", list);
		return output;
	}

	public Map populateTicketTextFields() {
		Map map = new HashMap();
		output = new HashMap();
		List list = new ArrayList();
		list.add(appBuildSmartArr("Ticket ID", "numeric", "ticket.ticketId"));
		list.add(appBuildSmartArr("Customer ID", "numeric", "ticket.ticketCustomerId"));
		list.add(appBuildSmartArr("Customer Name", "text", "ticket.axelaCustomer.customerName"));
		list.add(appBuildSmartArr("Contact ID", "numeric", "ticket.ticketContactId"));
		list.add(appBuildSmartArr("Contact Name", "text", "ticket.axelaCustomerContact.contactFname"));
		list.add(appBuildSmartArr("Contact Mobile", "numeric", "ticket.axelaCustomerContact.contactMobile1"));
		output.put("text", list);
		return output;
	}

}
