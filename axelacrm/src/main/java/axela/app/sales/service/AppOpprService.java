package axela.app.sales.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.customer.repository.CustomerContactReposiitory;
import axela.customer.repository.CustomerRepository;
import axela.inventory.repository.InventoryItemModelRepository;
import axela.portal.model.AxelaConfig;
import axela.portal.repository.ConfigRepository;
import axela.portal.repository.EmpRepository;
import axela.sales.model.AxelaSalesOppr;
import axela.sales.repository.OpprFilterImpl;
import axela.sales.repository.OpprFollowUpFilterImpl;
import axela.sales.repository.OpprHistoryRepository;
import axela.sales.repository.OpprRepository;
import axela.sales.repository.SalesLostCase2Repository;
import axela.sales.repository.SalesLostCase3Repository;
import axela.sales.repository.SalesOpprFollowUpRepository;
import axela.sales.service.OpprDashService;
import axela.sales.service.OpprService;

@Service
public class AppOpprService extends Connect {

	public JSONObject inputObj = null;
	public HashMap output = null;
	public String requestType = "";
	public int opprContactId = 0;
	public String customerName = "";
	public String titleId = "0";
	public String contactFname = "";
	public String contactLname = "";
	public String contactMobile1 = "";
	public String contactEmail1 = "";
	public String contactAddress = "";
	public String contactPin = "";
	public String opprBranchId = "0";
	public String opprEmpId = "0";
	public String opprModelId = "0";
	public String opprItemId = "0";
	public String opprTeamId = "0";
	public String opprSoeId = "0";
	public String opprSobId = "0";
	public String opprCampaignId = "0";
	public String opprPmId = "0";
	public String opprRefno = "";
	public String empId = "0";
	public String opprTitle = "";
	public String msg = "";
	public String opprCloseDate = "";

	public String configSalesOpprName = "";
	public String configCustomerDupnames = "";
	public String configSalesLeadForOppr = "";
	public String configSalesOpprRefno = "";
	public String configSalesOpprBudget = "";
	public String configSalesOpprProject = "";
	public String configSalesOpprModel = "";
	public String configSalesCampaign = "";
	public String configSalesSob = "";
	public String configSalesSoe = "";
	public String configSalesOpprItem = "";
	public String configCustomerAddress = "";
	public String configCustomerName = "";
	public Date timeZone = null;

	@Autowired
	public OpprFollowUpFilterImpl opprFollowUpFilterImpl;

	@Autowired
	public ConfigRepository axelaConfigRepository;

	@Autowired
	public EmpRepository empRepository;

	@Autowired
	public OpprRepository opprRepository;

	@Autowired
	public CustomerContactReposiitory customerContactRepository;

	@Autowired
	public OpprFilterImpl opprFilterImpl;

	@Autowired
	public CustomerContactReposiitory ContactRepository;

	@Autowired
	public CustomerRepository customerRepository;

	@Autowired
	public OpprHistoryRepository opprHistoryRepository;

	@Autowired
	public OpprFilterImpl opprDash;

	@Autowired
	SalesLostCase2Repository salesLostCase2Repository;

	@Autowired
	SalesLostCase3Repository salesLostCase3Repository;

	@Autowired
	SalesOpprFollowUpRepository salesOpprFollowUpRepository;

	@Autowired
	public InventoryItemModelRepository inventoryItemModelRepository;

	public int opprId = 0;
	public String branchAccess;
	public String exeAccess;
	private String opprCustomerId = "0";
	public String empFormatDate = "";
	public String empFormatTime = "";
	LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

	public Map opprServiceUpdate(String input, HttpServletResponse response, HttpServletRequest request, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("inputObj==========opprServiceUpdate====App======" + inputObj.toString(1));
		}
		output = new HashMap();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (!inputObj.isNull("empId")) {
			empId = inputObj.getString("empId");
		}
		empFormatDate = PadQuotes(getSession("formatdateDatepicker", session));
		empFormatTime = PadQuotes(getSession("formattimeTimepicker", session));
		List<AxelaConfig> axelaConfig = axelaConfigRepository.findAll();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		for (AxelaConfig config : axelaConfig) {
			configCustomerDupnames = config.getConfigCustomerDupnames();
			configCustomerName = config.getConfigCustomerName();
			configSalesLeadForOppr = config.getConfigSalesLeadForOppr();
			configSalesOpprName = config.getConfigSalesOpprName();
			configCustomerAddress = config.getConfigCustomerAddress();
			configSalesOpprRefno = config.getConfigSalesOpprRefno();
			configSalesOpprBudget = config.getConfigSalesOpprBudget();
			configSalesOpprProject = config.getConfigSalesOpprProject();
			configSalesOpprModel = config.getConfigSalesOpprModel();
			configSalesOpprItem = config.getConfigSalesOpprItem();
			configSalesLeadForOppr = config.getConfigSalesLeadForOppr();
			configSalesCampaign = config.getConfigSalesCampaign();
			configSalesSoe = config.getConfigSalesSoe();
			configSalesSob = config.getConfigSalesSob();
		}
		switch (requestType) {
			case "add" : // add an Oppr.
				timeZone = getTimeByZone(session);
				getValues(inputObj);
				addFields(response);
				break;

			case "dash" :// Oppr Dash.
				if (!inputObj.isNull("opprId")) {
					opprId = Integer.parseInt(CNumeric(inputObj.getString("opprId")));
				}
				if (opprId != 0) {
					opprDashPage(input, session, response, request);
				}
				break;
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		if (!inputObj.isNull("contactId")) {
			opprContactId = Integer.parseInt(CNumeric((String) inputObj.get("contactId")));
		}
		if (!inputObj.isNull("customerId")) {
			opprCustomerId = CNumeric((String) inputObj.get("customerId"));
		}
		if (opprContactId == 0) {
			if (!inputObj.isNull("customerName")) {
				customerName = PadQuotes((String) inputObj.get("customerName"));
			}
			if (!inputObj.isNull("titleId")) {
				titleId = CNumeric((String) inputObj.get("titleId"));
			}
			if (!inputObj.isNull("contactFname")) {
				contactFname = PadQuotes((String) inputObj.get("contactFname"));
			}
			if (!inputObj.isNull("contactLname")) {
				contactLname = PadQuotes((String) inputObj.get("contactLname"));
			}
			if (!inputObj.isNull("contactMobile1")) {
				contactMobile1 = PadQuotes((String) inputObj.get("contactMobile1"));
			}
			if (!inputObj.isNull("contactEmail1")) {
				contactEmail1 = PadQuotes((String) inputObj.get("contactEmail1"));
			}
			if (!inputObj.isNull("contactAddress")) {
				contactAddress = PadQuotes((String) inputObj.get("contactAddress"));
			}
			if (!inputObj.isNull("contactPin")) {
				contactPin = PadQuotes((String) inputObj.get("contactPin"));
			}
		}
		if (!inputObj.isNull("opprBranchId")) {
			opprBranchId = CNumeric((String) inputObj.get("opprBranchId"));
		}
		if (!inputObj.isNull("opprEmpId")) {
			opprEmpId = CNumeric(((String) inputObj.get("opprEmpId")));
		}
		if (!inputObj.isNull("opprModelId")) {
			opprModelId = CNumeric((String) inputObj.get("opprModelId"));
		}
		if (!inputObj.isNull("opprItemId")) {
			opprItemId = CNumeric((String) inputObj.get("opprItemId"));
		}
		if (!inputObj.isNull("opprTeamId")) {
			opprTeamId = CNumeric((String) inputObj.get("opprTeamId"));
		}
		if (!inputObj.isNull("opprSoeId")) {
			opprSoeId = CNumeric((String) inputObj.get("opprSoeId"));
		}
		if (!inputObj.isNull("opprSobId")) {
			opprSobId = CNumeric((String) inputObj.get("opprSobId"));
		}
		if (!inputObj.isNull("opprCampaignId")) {
			opprCampaignId = CNumeric((String) inputObj.get("opprCampaignId"));
		}
		if (!inputObj.isNull("opprCloseDate")) {
			opprCloseDate = PadQuotes((String) inputObj.get("opprCloseDate"));
		}
		if (!inputObj.isNull("opprPmId")) {
			opprPmId = CNumeric((String) inputObj.get("opprPmId"));
		}
		if (!inputObj.isNull("opprRefno")) {
			opprRefno = PadQuotes((String) inputObj.get("opprRefno"));
		}
		if (!inputObj.isNull("opprTitle")) {
			opprTitle = PadQuotes((String) inputObj.get("opprTitle"));
		}

	}

	public void addFields(HttpServletResponse response) throws ParseException {
		OpprService opprService = new OpprService();
		opprService.salesOpprFollowUpRepository = salesOpprFollowUpRepository;
		opprService.inventoryItemModelRepository = inventoryItemModelRepository;
		opprService.configCustomerDupnames = configCustomerDupnames;
		opprService.configSalesOpprName = configSalesOpprName;
		opprService.contactId = opprContactId;
		opprService.opprBranchId = opprBranchId;
		opprService.customerName = contactFname + contactLname;
		opprService.contactFname = contactFname;
		opprService.contactLname = contactLname;
		opprService.contactMobile1 = contactMobile1;
		opprService.contactMobile2 = "";
		opprService.contactEmail1 = contactEmail1;
		opprService.contactEmail2 = "";
		opprService.opprSobId = opprSobId;
		opprService.opprSoeId = opprSoeId;
		opprService.opprTitle = opprTitle;
		opprService.contactAddress = contactAddress;
		opprService.contactPin = contactPin;
		opprService.customerId = opprCustomerId;
		opprService.titleId = titleId;
		opprService.opprEmpId = opprEmpId;
		opprService.empFormatDate = empFormatDate;
		opprService.empFormatTime = empFormatTime;
		opprService.opprCloseDate = dateToStringapp(timeZone);
		opprService.opprModelId = opprModelId;
		opprService.opprItemId = opprItemId;
		opprService.opprTeamId = opprTeamId;
		opprService.opprSoeId = opprSoeId;
		opprService.opprSobId = opprSobId;
		opprService.opprCampaignId = opprCampaignId;
		opprService.opprPmId = opprPmId;
		opprService.opprRefno = opprRefno;
		opprService.empId = Integer.parseInt(empId);
		opprService.opprEmpId = opprEmpId;
		opprService.opprRepository = opprRepository;
		opprService.customerContactRepository = customerContactRepository;
		opprService.customerRepository = customerRepository;
		opprService.opprHistoryRepository = opprHistoryRepository;
		opprService.salesOpprFollowUpRepository = salesOpprFollowUpRepository;
		opprService.requestType = requestType;
		opprService.contactCityId = "1";
		opprService.opprStatusId = 1;
		opprService.opprStageId = 1;
		opprService.timeZone = timeZone;
		opprService.addFields(response);
		String msg = opprService.msg;
		if (msg.equals("")) {
			output.put("successmsg", "Opportunity Added Successfully!");
			output.put("opprId", opprService.opprId);
		} else {
			output.put("errormsg", msg);
		}
	}

	public String dateToStringapp(Date dateTime) {
		String sy = "";
		if (dateTime != null) {
			sy = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dateTime);
		}
		return sy;
	}

	public Map listData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		String sort = "";
		String strOrderBy = "";
		String perPage = "0";
		String strSearch = "";
		inputObj = new JSONObject(input);
		String empUuid = "";
		if (!inputObj.isNull("emp_id")) {
			empId = CNumeric(inputObj.getString("emp_id"));
		}
		if (!inputObj.isNull("emp_uuid")) {
			empUuid = PadQuotes(inputObj.getString("emp_uuid"));
		}
		empId = CNumeric(PadQuotes(getSession("empId", session)));
		if (!empId.equals("0")) {
			output = new LinkedHashMap<String, String>();
			branchAccess = getSession("branchAccess", session).replaceAll("branchId", "oppr.opprBranchId");
			exeAccess = getSession("exeAccess", session).replaceAll("empId", "oppr.opprEmpId");
			int page = 0;
			if (!inputObj.isNull("pageIndex")) {
				page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
			}
			perPage = CNumeric(getSession("empRecperpage", session));
			if (sort.equals("")) {
				sort = "DESC";
			}
			if (strOrderBy.equals("")) {
				strOrderBy = "opprId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			if (requestType.equals("filter")) {
				strSearch += appBuildSmartSearch(input);
			} else {
				strSearch += " AND oppr.opprStatusId=1";
			}
			strSearch += branchAccess + exeAccess;
			strOrderBy = " ORDER BY oppr." + strOrderBy + " " + sort + "";
			ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
			List<AxelaSalesOppr> resultSet = opprDash.findAll(strSearch, strOrderBy, page, Integer.parseInt(perPage), "yes");
			String totalCount = opprFilterImpl.totalCount;
			SOP("totalCount==sales====================" + totalCount);
			if (!totalCount.equals("0")) {
				for (AxelaSalesOppr obj : resultSet) {
					map.clear();
					map.put("opprId", obj.getOpprId() + "");
					map.put("empName", obj.getEmpName());
					map.put("itemName", obj.getItemName());
					map.put("stageName", obj.getOpprStageName());
					map.put("statusName", obj.getOpprStatusName());
					map.put("opprDate", strToShortDate(obj.getOpprDate()));
					map.put("contactName", obj.getContactName());
					map.put("contactMobile1", obj.getContactMobile1());
					map.put("contactMobile2", obj.getContactMobile2());
					map.put("contactEmail1", obj.getContactEmail1());
					map.put("contactEmail2", obj.getContactEmail2());
					list.add((HashMap<String, String>) map.clone());
				}
				output.put("listData", list);
				response.setStatus(201);
			} else {
				output.put("msg", "No Records Found!");
			}
			if (AppRun().equals("0")) {
				SOP("output =========Axela listData============== " + output);
			}
		}
		return output;
	}

	public Map<String, String> populateOpprData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		OpprDashService opprServiceUpdate = new OpprDashService();
		opprServiceUpdate.opprFilterImpl = opprFilterImpl;
		opprServiceUpdate.populateOpprData(input, session, response);
		output = opprServiceUpdate.output;
		return output;
	}

	public Map<String, String> opprDashPage(String input, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws JSONException, ParseException {
		output = new HashMap();
		OpprDashService opprDashService = new OpprDashService();
		opprDashService.opprFilterImpl = opprFilterImpl;
		opprDashService.axelaConfigRepository = axelaConfigRepository;
		opprDashService.opprRepository = opprRepository;
		opprDashService.empRepository = empRepository;
		opprDashService.salesLostCase2Repository = salesLostCase2Repository;
		opprDashService.salesLostCase3Repository = salesLostCase3Repository;
		opprDashService.opprHistoryRepository = opprHistoryRepository;
		opprDashService.opprFilterImpl = opprFilterImpl;
		opprDashService.msg = msg;
		opprDashService.opprFollowUpFilterImpl = opprFollowUpFilterImpl;
		opprDashService.salesOpprFollowUpRepository = salesOpprFollowUpRepository;
		opprDashService.opprServiceUpdate(input, request, response, session);
		output = opprDashService.output;
		return output;
	}
}
