package axela.sales.service;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
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
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import axela.accounting.model.AxelaAccVoucher;
import axela.config.Connect;
import axela.customer.repository.CustomerFilterImpl;
import axela.inventory.repository.InventoryItemRepository;
import axela.portal.model.AxelaConfig;
import axela.portal.repository.ConfigRepository;
import axela.portal.repository.EmpRepository;
import axela.sales.model.AxelaSalesCrm;
import axela.sales.model.AxelaSalesOppr;
import axela.sales.model.AxelaSalesOpprDoc;
import axela.sales.model.AxelaSalesOpprFollowup;
import axela.sales.model.AxelaSalesOpprHistory;
import axela.sales.repository.CrmFilterImplemention;
import axela.sales.repository.OpprFilterImpl;
import axela.sales.repository.OpprFollowUpFilterImpl;
import axela.sales.repository.OpprHistoryRepository;
import axela.sales.repository.OpprRepository;
import axela.sales.repository.SalesLostCase2Repository;
import axela.sales.repository.SalesLostCase3Repository;
import axela.sales.repository.SalesOpprDocRepository;
import axela.sales.repository.SalesOpprFollowUpRepository;
import axela.service.repository.VoucherRepositoryImpl;

@Service
public class OpprDashService extends Connect {
	public String configSalesOpprRefno = "";
	public String configSalesOpprBudget = "";
	public String configSalesOpprProject = "";
	public String configSalesOpprModel = "";
	public String configSalesCampaign = "";
	public String configSalesSob = "";
	public String configSalesSoe = "";
	public String configSalesOpprItem = "";
	public String empFormatdate = "";
	public String empOpportunityEdit = "";
	public String configCustomerAddress = "";
	public String configCustomerName = "";
	public String configSalesLeadForOppr = "";
	public String configSalesOpprName = "";
	public String configCustomerDupnames = "";
	public int empId = 0;
	public String tab = "0";
	public int opprId = 0;

	public JSONObject inputObj = null;
	public HashMap output = null;
	public String requestType = "";

	@Autowired
	InventoryItemRepository inventoryItemRepository;

	@Autowired
	SalesOpprDocRepository salesOpprDocRepository;

	@Autowired
	CrmFilterImplemention crmFilterImplemention;

	@Autowired
	public ConfigRepository axelaConfigRepository;

	@Autowired
	public OpprRepository opprRepository;

	@Autowired
	public EmpRepository empRepository;

	@Autowired
	public SalesLostCase2Repository salesLostCase2Repository;

	@Autowired
	public SalesLostCase3Repository salesLostCase3Repository;

	@Autowired
	public OpprHistoryRepository opprHistoryRepository;

	@Autowired
	public OpprFilterImpl opprFilterImpl;

	@Autowired
	public SalesOpprFollowUpRepository salesOpprFollowUpRepository;

	@Autowired
	public OpprFollowUpFilterImpl opprFollowUpFilterImpl;

	@Autowired
	public CustomerFilterImpl customerFilterImpl;

	@Autowired
	public VoucherRepositoryImpl voucherRepositoryImpl;

	private String opprDate = "";
	public String msg = "";
	private String opprDat = "";
	private Object opprEdit;
	private String branchAccess;
	private String exeAccess;
	private String empFormatDate = "";
	private String opprStatusDesc = "";
	private int opprLostcase1Id = 0;
	private int opprLostcase2Id = 0;
	private int opprLostcase3Id = 0;
	private int followupOpprId = 0;
	private int followupEmpId = 0;
	private String followupFollowupTime = "";
	private int followupFollowuptypeId = 0;
	private String followupDesc = "";
	private String followupModifiedTime = "";
	private int followupModifiedId = 0;
	private int followupFeedbacktypeId = 0;
	private int historyOpprId = 0;
	private int crmFollowupOpprId = 0;
	private int customerOpprId = 0;
	public String successmsg = "";
	private String strSearch = "";
	private int voucherOpprId = 0;

	public Map opprServiceUpdate(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("inputObj==========OpprDashService==========" + inputObj.toString(1));
		}
		output = new HashMap();
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		SOP("empId====================" + empId);
		// if (empId != 0) {
		List<AxelaConfig> axelaConfig = axelaConfigRepository.findAll();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		for (AxelaConfig config : axelaConfig) {
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
		if (!inputObj.isNull("tab")) {
			tab = inputObj.getString("tab");
		}
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}

		switch (tab) {
			case "1" : // opportunity Details
				switch (requestType) {
					case "populateData" :
						populateOpprData(input, session, response);
						break;

					case "update" :
						dashFieldUpdate(input, request, response, session);
						break;
				}
				break;

			case "2" :// opportunity FollowUp.
				switch (requestType) {

					case "populateData" :
						// followup and customer Details
						if (!inputObj.isNull("followupOpprId")) {
							followupOpprId = Integer.parseInt(inputObj.getString("followupOpprId"));
						}
						if (followupOpprId != 0) {
							populateFollowUpList();
						}
						break;

					case "add" :
						opprFollowUpAdd(input, session);
						break;

					case "update" :
						opprFollowUpUpdate(input, session);
						break;
				}
				break;

			case "3" :// opportunity CRM FollowUp.
				switch (requestType) {
					case "populateData" :
						// CRM followup and customer Details
						if (!inputObj.isNull("crmFollowupOpprId")) {
							crmFollowupOpprId = Integer.parseInt(CNumeric(PadQuotes(inputObj.getString("crmFollowupOpprId"))));
						}
						if (crmFollowupOpprId != 0) {
							listPsfDetails();
						}
						break;
				}
				break;

			case "4" :// opportunity Customer.
				switch (requestType) {
					case "populateData" :
						if (!inputObj.isNull("customerOpprId")) {
							customerOpprId = Integer.parseInt(inputObj.getString("customerOpprId"));
						}
						if (customerOpprId != 0) {
							populateCustomerDetail();
						}
						break;
				}
				break;

			case "5" :// opportunity Voucher list.
				switch (requestType) {
					case "populateData" :
						if (!inputObj.isNull("voucherOpprId")) {
							voucherOpprId = Integer.parseInt(PadQuotes(CNumeric(inputObj.getString("voucherOpprId"))));
						}
						if (voucherOpprId != 0) {
							populateVoucherList(input);
						}
						break;
				}

			case "10" :// opportunity Document.
				switch (requestType) {
					case "populateData" :
						if (!inputObj.isNull("historyOpprId")) {
							historyOpprId = Integer.parseInt(inputObj.getString("historyOpprId"));
						}
						if (historyOpprId != 0) {
							populateHistory();
						}
						break;
				}
				break;
		}
		// }
		SOP("output================" + output);
		return output;
	}

	// Start Of Populate Opportunity Data
	public Map<String, String> populateOpprData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		SOP("inputObj==populateOpprData====" + inputObj);
		// AxelaSalesOppr axelaSalesOppr = null;
		Map map = new LinkedHashMap<String, String>();
		ArrayList list = new ArrayList();
		output = new HashMap<String, String>();

		if (!inputObj.isNull("opprId")) {
			opprId = Integer.parseInt(PadQuotes(CNumeric(inputObj.getString("opprId"))));
		}
		SOP("opprId=============" + opprId);
		if (opprId != 0) {
			AxelaSalesOppr axelaSalesOppr = opprFilterImpl.findOne(opprId);
			if (axelaSalesOppr != null) {
				map.put("contactId", axelaSalesOppr.getOpprContactId() + "");
				map.put("customerId", axelaSalesOppr.getOpprCustomerId() + "");
				map.put("opprDate", strToShortDate(axelaSalesOppr.getOpprDate()));
				map.put("opprCloseDate", strToShortDate(axelaSalesOppr.getOpprCloseDate()));
				map.put("opprProjectId", axelaSalesOppr.getOpprProjectId() + "");
				map.put("opprStatusDesc", axelaSalesOppr.getOpprStatusDesc());
				if (axelaSalesOppr.getOpprAvpresent().equals("0")) {
					map.put("opprAvpresent", false);
				} else {
					map.put("opprAvpresent", true);
				}
				// map.put("opprManagerAssist", axelaSalesOppr.getOpprManagerAssist());
				if (axelaSalesOppr.getOpprManagerAssist().equals("0")) {
					map.put("opprManagerAssist", false);
				} else {
					map.put("opprManagerAssist", true);
				}
				map.put("opprContactId", axelaSalesOppr.getOpprContactId() + "");
				map.put("opprEmpId", axelaSalesOppr.getOpprEmpId() + "");
				map.put("opprLostcase1Id", axelaSalesOppr.getOpprLostcase1Id() + "");
				map.put("opprLostcase2Id", axelaSalesOppr.getOpprLostcase2Id() + "");
				map.put("opprLostcase3Id", axelaSalesOppr.getOpprLostcase3Id() + "");
				map.put("opprNotes", axelaSalesOppr.getOpprNotes());
				map.put("opprPriorityopprId", axelaSalesOppr.getOpprPriorityopprId() + "");
				map.put("opprStatusId", axelaSalesOppr.getOpprStatusId() + "");
				map.put("opprStageId", axelaSalesOppr.getOpprStageId() + "");
				map.put("opprModelId", axelaSalesOppr.getOpprModelId() + "");
				map.put("opprDesc", axelaSalesOppr.getOpprDesc());
				map.put("opprBranchId", axelaSalesOppr.getOpprBranchId() + "");
				map.put("opprId", axelaSalesOppr.getOpprId() + "");
				map.put("opprtypeName", PadQuotes(axelaSalesOppr.getOpprtypeName()));
				map.put("opprTitle", axelaSalesOppr.getOpprTitle());
				map.put("customerName", axelaSalesOppr.getCustomerName());
				map.put("contactTitleId", axelaSalesOppr.getContactTitleId() + "");
				map.put("contactName", "." + axelaSalesOppr.getContactFname() + axelaSalesOppr.getContactLname());
				map.put("contactFname", axelaSalesOppr.getContactFname());
				map.put("contactLname", axelaSalesOppr.getContactLname());
				map.put("contactMobile1", axelaSalesOppr.getContactMobile1());
				map.put("contactMobile2", axelaSalesOppr.getContactMobile2());
				map.put("contactPhone1", axelaSalesOppr.getContactPhone1());
				map.put("contactPhone2", axelaSalesOppr.getContactPhone2());
				map.put("contactEmail1", axelaSalesOppr.getContactEmail1());
				map.put("contactEmail2", axelaSalesOppr.getContactEmail2());
				map.put("contactAddress", axelaSalesOppr.getContactAddress());
				map.put("contactCityId", axelaSalesOppr.getContactCityId() + "");
				map.put("contactPin", axelaSalesOppr.getContactPin());
				map.put("branchName", axelaSalesOppr.getBranchName());
				map.put("branchCode", axelaSalesOppr.getBranchCode());
				map.put("opprTeamId", axelaSalesOppr.getOpprTeamId() + "");
				map.put("opprItemId", axelaSalesOppr.getOpprItemId() + "");
				map.put("opprPmId", axelaSalesOppr.getOpprPmId() + "");
				map.put("opprSobId", axelaSalesOppr.getOpprSobId() + "");
				map.put("opprSoeId", axelaSalesOppr.getOpprSoeId() + "");
				map.put("opprCampaignId", axelaSalesOppr.getOpprCampaignId() + "");
				map.put("opprRefno", axelaSalesOppr.getOpprRefno());
				map.put("opprEntryId", axelaSalesOppr.getOpprEntryId() + "");
				map.put("opprEntryBy", empRepository.findEmpName(axelaSalesOppr.getOpprEntryId()));
				map.put("opprEntryDate", strToShortDate(axelaSalesOppr.getOpprEntryDate()));
				if (axelaSalesOppr.getOpprModifiedId() != 0) {
					map.put("opprModifiedId", axelaSalesOppr.getOpprModifiedId() + "");
					map.put("opprModifiedDate", strToShortDate(axelaSalesOppr.getOpprModifiedDate()));
					map.put("opprModifiedBy", empRepository.findEmpName(axelaSalesOppr.getOpprModifiedId()));
				}
				list.add(map);
				output.put("populateOpprData", list);
			} else {
				output.put("msg", "Invalid Opportunity ID");
			}
		} else {
			output.put("msg", "Invalid Opportunity ID");
			response.setStatus(400);
		}
		return output;
	}
	// End Of Populate Opportunity Data

	// Start Dash Page Update
	// Dash Page
	public void dashFieldUpdate(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		System.out.println("inputObj==dashFieldUpdate==" + inputObj.toString(2));
		AxelaSalesOppr axelaSalesOppr = null;
		empFormatDate = PadQuotes(getSession("formattimeName", session));
		empId = Integer.parseInt(getSession("empId", session));
		String name = "";
		String value = "";
		OpprFilterImpl opprDash = null;
		output = new HashMap<String, String>();

		if (!inputObj.isNull("opprId")) {
			opprId = Integer.parseInt(inputObj.getString("opprId"));

		}
		if (!inputObj.isNull("name")) {
			name = PadQuotes(inputObj.getString("name"));
		}
		if (!inputObj.isNull("value")) {
			value = PadQuotes(inputObj.getString("value"));
		}
		if (!inputObj.isNull("opprStatusDesc")) {
			opprStatusDesc = inputObj.getString("opprStatusDesc");
		}
		if (!inputObj.isNull("opprStatusDesc")) {
			opprStatusDesc = inputObj.getString("opprStatusDesc");
		}
		if (!inputObj.isNull("opprLostcase1Id")) {
			opprLostcase1Id = Integer.parseInt(CNumeric(PadQuotes(inputObj.getString("opprLostcase1Id"))));
		}
		if (!inputObj.isNull("opprLostcase2Id")) {
			opprLostcase2Id = Integer.parseInt(CNumeric(PadQuotes(inputObj.getString("opprLostcase2Id"))));
		}
		if (!inputObj.isNull("opprLostcase3Id")) {
			opprLostcase3Id = Integer.parseInt(CNumeric(PadQuotes(inputObj.getString("opprLostcase3Id"))));
		}
		if (opprId != 0) {
			axelaSalesOppr = opprRepository.findOne(opprId);
			opprDate = strToShortDate(axelaSalesOppr.getOpprDate());
			if (!name.equals("") && !value.equals("")) {
				AxelaSalesOpprHistory axelaSalesOpprHistory = new AxelaSalesOpprHistory();
				axelaSalesOpprHistory.setHistoryOpprId(BigInteger.valueOf(opprId));
				axelaSalesOpprHistory.setHistoryEmpId(empId);
				axelaSalesOpprHistory.setHistoryDatetime(stringToDate(toLongDate(kknow())));
				if (name.equals("opprCloseDate")) {
					// History table Update
					msg = "";
					if (!isValidDateFormat(value, empFormatDate)) {
						msg = "Enter Valid Close Date!";
					} else {
						if (!opprDat.equals("") && !value.equals("") && Long.parseLong(formatDateStr(opprDat, empFormatDate)) > Long.parseLong(formatDateStr(value, empFormatDate))) {
							msg += "Closing Date can't be less than the Date!<br>";
						}
					}
					if (msg.equals("")) {
						axelaSalesOpprHistory.setHistoryActiontype("CLOSING DATE");
						axelaSalesOpprHistory.setHistoryNewvalue(value);
						axelaSalesOpprHistory.setHistoryOldvalue(strToLongDate(axelaSalesOppr.getOpprCloseDate()));
						// Oppr table Update
						axelaSalesOppr.setOpprCloseDate(stringToDate(convertLongDate(value)));
						successmsg += "Close Date Updated!<br>";
					}
				}
				if (name.equals("opprTitle")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("TITLE");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(PadQuotes(axelaSalesOppr.getOpprTitle()));
					// Oppr table Update
					axelaSalesOppr.setOpprTitle(value);
					successmsg = "Title Updated!";
				}

				if (name.equals("opprDesc")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("OPPR DESCRIPTION");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(axelaSalesOppr.getOpprDesc());
					// Oppr table Update
					axelaSalesOppr.setOpprDesc(value);
					successmsg = "Description Updated!";
				}
				if (name.equals("opprEmpId")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("EXECUTIVE");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(empRepository.findEmpName((axelaSalesOppr.getOpprEmpId())));
					// Oppr table Update
					axelaSalesOppr.setOpprEmpId(Integer.parseInt(value));
					successmsg = "Executive Updated!";
				}
				if (name.equals("opprModelId")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("MODEL");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(axelaSalesOppr.getAxelaInventoryItem().getAxelaInventoryItemModel().getModelName());
					// Oppr table Update
					axelaSalesOppr.setOpprModelId(Integer.parseInt(value));
					successmsg = "Model Updated!";
				}
				if (name.equals("opprItemId")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("ITEM");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					SOP("axelaSalesOppr.getOpprItemId()==============" + axelaSalesOppr.getOpprItemId());
					axelaSalesOpprHistory.setHistoryOldvalue(axelaSalesOppr.getOpprItemId() + "");
					// Oppr table Update
					axelaSalesOppr.setOpprItemId(Integer.parseInt(value));
					successmsg = "Item Updated!";
				}

				if (name.equals("opprAvpresent")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("AV PRESENTATION");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(axelaSalesOppr.getOpprAvpresent());
					// Oppr table Update
					axelaSalesOppr.setOpprAvpresent(value);
					successmsg = "AV Presentation Updated!";
				}

				if (name.equals("opprManagerAssist")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("OPPR MANAGER ASSIST");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(axelaSalesOppr.getOpprManagerAssist());
					// Oppr table Update
					axelaSalesOppr.setOpprManagerAssist(value);
					successmsg = "Manager Assistance Updated!";
				}

				if (name.equals("customerName")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("CUSTOMER NAME");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(axelaSalesOppr.getAxelaCustomer().getCustomerName());
					// Oppr table Update
					axelaSalesOppr.getAxelaCustomer().setCustomerName(value);
					successmsg = "Customer Updated!";
				}

				if (name.equals("contactTitleId")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("CONTACT TITLE");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(String.valueOf(axelaSalesOppr.getAxelaCustomerContact().getContactTitleId()));
					// Oppr table Update
					axelaSalesOppr.getAxelaCustomerContact().setContactTitleId(Integer.parseInt(value));
					successmsg = "Contact Title Updated!";
				}

				if (name.equals("contactFname")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("CONTACT FIRST NAME");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(axelaSalesOppr.getAxelaCustomerContact().getContactFname());
					// Oppr table Update
					axelaSalesOppr.getAxelaCustomerContact().setContactFname(value);
					successmsg = "Contact FirstName Updated!";
				}

				if (name.equals("contactLname")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("CONTACT LAST NAME");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(axelaSalesOppr.getAxelaCustomerContact().getContactLname());
					// Oppr table Update
					axelaSalesOppr.getAxelaCustomerContact().setContactLname(value);
					successmsg = "Contact LastName Updated!";
				}

				if (name.equals("contactMobile1")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("CONTACT MOBILE1");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(axelaSalesOppr.getAxelaCustomerContact().getContactMobile1());
					// Oppr table Update
					axelaSalesOppr.getAxelaCustomerContact().setContactMobile1(value);
					successmsg = "Contact Mobile1 Updated!";
				}

				if (name.equals("contactMobile2")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("CONTACT MOBILE2");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(axelaSalesOppr.getAxelaCustomerContact().getContactMobile2());
					// Oppr table Update
					axelaSalesOppr.getAxelaCustomerContact().setContactMobile2(value);
					successmsg = "Contact Mobile2 Updated!";
				}

				if (name.equals("contactPhone1")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("CONTACT PHONE1");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(axelaSalesOppr.getAxelaCustomerContact().getContactPhone1());
					// Oppr table Update
					axelaSalesOppr.getAxelaCustomerContact().setContactPhone1(value);
					successmsg = "Contact Phone1 Updated!";
				}

				if (name.equals("contactPhone2")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("CONTACT PHONE2");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(axelaSalesOppr.getAxelaCustomerContact().getContactPhone2());
					// Oppr table Update
					axelaSalesOppr.getAxelaCustomerContact().setContactPhone2(value);
					successmsg = "Contact Phone2 Updated!";
				}

				if (name.equals("contactEmail1")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("CONTACT EMAIL1");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(axelaSalesOppr.getAxelaCustomerContact().getContactEmail1());
					// Oppr table Update
					axelaSalesOppr.getAxelaCustomerContact().setContactEmail1(value);
					successmsg = "Contact Email1 Updated!";
				}
				if (name.equals("contactEmail2")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("CONTACT EMAIL2");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(axelaSalesOppr.getAxelaCustomerContact().getContactEmail2());
					// Oppr table Update
					axelaSalesOppr.getAxelaCustomerContact().setContactEmail2(value);
					successmsg = "Contact Email2 Updated!";
				}

				if (name.equals("contactAddress")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("CONTACT ADDRESS");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(axelaSalesOppr.getAxelaCustomerContact().getContactAddress());
					// Oppr table Update
					axelaSalesOppr.getAxelaCustomerContact().setContactAddress(value);
					successmsg = "Contact Address Updated!";
				}

				if (name.equals("contactCityId")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("CONTACT CITY");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(String.valueOf(axelaSalesOppr.getAxelaCustomerContact().getAxelaCity().getCityId()));
					// Oppr table Update
					axelaSalesOppr.getAxelaCustomerContact().getAxelaCity().setCityId(Integer.parseInt(value));
					successmsg = "Contact Address Updated!";
				}

				if (name.equals("contactPin")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("CONTACT PIN");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(axelaSalesOppr.getAxelaCustomerContact().getContactPin());
					// Oppr table Update
					axelaSalesOppr.getAxelaCustomerContact().setContactPin(value);
					successmsg = "Contact Pin Updated!";
				}

				if (name.equals("opprStageId")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("OPPR STAGE");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(String.valueOf(axelaSalesOppr.getOpprStageId()));
					// Oppr table Update
					axelaSalesOppr.setOpprStageId(Integer.parseInt(value));
					successmsg = "Stage Updated!";
				}

				if (name.equals("opprStatusId")) {
					String statusMsg = "";
					// History table Update
					opprEdit = CNumeric(PadQuotes(empRepository.findByempCloseOppr(empId)));
					if (String.valueOf(axelaSalesOppr.getOpprStageId()).equals("1") && value.equals("2")) {
						statusMsg = "Update Permission Denied!";
					} else if ((value.equals("3") || value.equals("4")) && opprEdit.equals("0")) {
						statusMsg += "Update Permission Denied!<br>";
					} else {
						if (opprStatusDesc.equals("")) {
							statusMsg += "Enter Status Description!<br>";
						}
						if (opprLostcase1Id == 0) {
							statusMsg += "Select Lost Case 1!<br>";
						}

						if (salesLostCase2Repository.findById(opprLostcase1Id) != 0) {
							if (opprLostcase2Id == 0) {
								statusMsg += "Select Lost Case 2!<br>";
							}
						}

						if (salesLostCase3Repository.findById(opprLostcase2Id) != 0) {
							if (opprLostcase3Id == 0) {
								statusMsg += "Select Lost Case 3!<br>";
							}
						}
						statusMsg = statusMsg;
					}
					if (statusMsg.equals("")) {
						axelaSalesOpprHistory.setHistoryActiontype("OPPR STATUS");
						axelaSalesOpprHistory.setHistoryNewvalue(value);
						axelaSalesOpprHistory.setHistoryOldvalue(String.valueOf(axelaSalesOppr.getOpprStageId()));
						// Oppr table Update
						axelaSalesOppr.setOpprStatusId(Integer.parseInt(value));
						axelaSalesOppr.setOpprStatusDesc(opprStatusDesc);
						axelaSalesOppr.setOpprLostcase1Id(opprLostcase1Id);
						axelaSalesOppr.setOpprLostcase2Id(opprLostcase2Id);
						axelaSalesOppr.setOpprLostcase3Id(opprLostcase3Id);
						statusMsg = "Status Updated!";
						opprRepository.save(axelaSalesOppr);
						opprHistoryRepository.save(axelaSalesOpprHistory);
						output.put("statusMsg", statusMsg);
					}
					SOP("statusMsg======" + statusMsg);
					output.put("msg", statusMsg);
				}
				if (name.equals("opprStatusDesc")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("STATUS DESCRIPTION");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(axelaSalesOppr.getOpprStatusDesc());
					// Oppr table Update
					axelaSalesOppr.setOpprStatusDesc(value);
					successmsg = "Status Description Updated!";
				}
				if (name.equals("opprPriorityopprId")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("OPPR PRIORITY");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(String.valueOf(axelaSalesOppr.getOpprPriorityopprId()));
					// Oppr table Update
					axelaSalesOppr.setOpprPriorityopprId(Integer.parseInt(value));
					successmsg = "Priority Updated!";
				}
				if (name.equals("opprProjectId")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("OPPR PROJECT");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(String.valueOf(axelaSalesOppr.getOpprProjectId()));
					// Oppr table Update
					axelaSalesOppr.setOpprProjectId(Integer.parseInt(value));
					successmsg = "Project Updated!";
				}
				if (name.equals("opprNotes")) {
					// History table Update
					axelaSalesOpprHistory.setHistoryActiontype("OPPR NOTES");
					axelaSalesOpprHistory.setHistoryNewvalue(value);
					axelaSalesOpprHistory.setHistoryOldvalue(axelaSalesOppr.getOpprNotes());
					// Oppr table Update
					axelaSalesOppr.setOpprNotes(value);
					successmsg = "Oppr Notes Updated!";
				}

				System.out.println("msg===232323===" + msg);
				if (!name.equals("opprStatusId")) {
					if (msg.equals("")) {
						opprRepository.save(axelaSalesOppr);
						opprHistoryRepository.save(axelaSalesOpprHistory);
						output.put("msg", successmsg);
					} else {
						output.put("msg", msg);
					}
				}
			}
		} else {
			output.put("msg", "Invalid Opportunity ID");
			response.setStatus(400);
		}

	}
	// End Dash Page Update

	// start Follow up Add
	private void opprFollowUpAdd(String input, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		empId = 0;
		followupFollowupTime = "";
		followupFollowuptypeId = 0;
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		if (empId != 0) {
			if (AppRun().equals("0")) {
				SOP("opprFollowUpAdd=================" + inputObj.toString(2));
			}
			int followupId = 0;
			if (!inputObj.isNull("followupOpprId")) {
				followupOpprId = Integer.parseInt(CNumeric(inputObj.getString("followupOpprId")));
			}
			if (followupOpprId != 0) {
				if (!inputObj.isNull("followupFollowupTime")) {
					followupFollowupTime = PadQuotes(inputObj.getString("followupFollowupTime"));
				}
				if (!inputObj.isNull("followupFollowuptypeId")) {
					followupFollowuptypeId = Integer.parseInt(PadQuotes(inputObj.getString("followupFollowuptypeId")));
				}
				validateFollowUp();
				if (msg.equals("")) {
					AxelaSalesOpprFollowup axelaSalesOpprFollowup = new AxelaSalesOpprFollowup();
					axelaSalesOpprFollowup.setFollowupOpprId(followupOpprId);
					axelaSalesOpprFollowup.setFollowupEmpId(empId);
					axelaSalesOpprFollowup.setFollowupFollowupTime(stringToDate(convertShortDateToStr(followupFollowupTime)));
					axelaSalesOpprFollowup.setFollowupFollowuptypeId(followupFollowuptypeId);
					axelaSalesOpprFollowup.setFollowupDesc("");
					axelaSalesOpprFollowup.setFollowupEntryId(empId);
					axelaSalesOpprFollowup.setFollowupEntryTime(stringToDate(toLongDate(kknow())));
					axelaSalesOpprFollowup.setFollowupModifiedId(0);
					axelaSalesOpprFollowup.setFollowupModifiedTime(stringToDate(""));
					followupId = salesOpprFollowUpRepository.save(axelaSalesOpprFollowup).getFollowupId();
					if (followupId != 0) {
						output.put("successmsg", "FollowUp Added SuccessFully!");
						output.put("followupId", followupId);
					}
				}
			} else {
				output.put("errormsg", "InValid Opportunity Id!");
			}
		}
	}
	// End Follow up Add

	// start Follow up Update
	@Query
	private void opprFollowUpUpdate(String input, HttpSession session) throws NumberFormatException, JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		if (empId != 0) {
			inputObj = new JSONObject(input);
			Object followUpId = "0";
			if (AppRun().equals("0")) {
				SOP("opprFollowUpUpdate=================" + inputObj.toString(2));
			}
			if (!inputObj.isNull("followupOpprId")) {
				followupOpprId = Integer.parseInt(CNumeric(inputObj.getString("followupOpprId")));
			}
			if (!inputObj.isNull("followupDesc")) {
				followupDesc = PadQuotes(inputObj.getString("followupDesc"));
			}
			if (!inputObj.isNull("followupFeedbacktypeId")) {
				followupFeedbacktypeId = Integer.parseInt(CNumeric(inputObj.getString("followupFeedbacktypeId")));
			}
			if (followupOpprId != 0) {
				followUpId = salesOpprFollowUpRepository.updateFollowUp(followupOpprId);
				SOP("followUpId============" + followUpId);
				if (followUpId != null) {
					AxelaSalesOpprFollowup axelaSalesOpprFollowup = salesOpprFollowUpRepository.findOne(salesOpprFollowUpRepository.FindFollowUpId(followupOpprId));
					axelaSalesOpprFollowup.setFollowupDesc(followupDesc);
					axelaSalesOpprFollowup.setFollowupFeedbacktypeId(followupFeedbacktypeId);
					axelaSalesOpprFollowup.setFollowupModifiedId(empId);
					axelaSalesOpprFollowup.setFollowupModifiedTime(stringToDate(toLongDate(kknow())));
					followUpId = salesOpprFollowUpRepository.save(axelaSalesOpprFollowup).getFollowupId();
				}
				opprFollowUpAdd(input, session);
			}
			if (AppRun().equals("0")) {
				SOP("opprFollowUpAdd=================" + inputObj.toString(2));
			}
		}
	}
	// End Follow up Update

	private void validateFollowUp() {
		if (followupFollowuptypeId == 0) {
			msg = "SELECT Follow Up Type";
		}
		if (requestType.equals("update")) {
			if (followupFeedbacktypeId == 0 && followupDesc.equals("")) {
				msg = "Enter Feedback!";
			}
		}
	}

	private Map populateFollowUpList() throws JSONException, ParseException {
		AxelaSalesOpprFollowup opprFollowUp = new AxelaSalesOpprFollowup();
		opprFollowUp = opprFollowUpFilterImpl.findCustomerDetails(followupOpprId);
		Map map = new HashMap();
		output = new HashMap();
		List list = new ArrayList();
		map.put("customerName", opprFollowUp.getCustomerName());
		map.put("customerId", opprFollowUp.getCustomerId() + "");
		map.put("contactId", opprFollowUp.getContactId() + "");
		map.put("contactName", opprFollowUp.getTitleDesc() + "." + opprFollowUp.getContactFname() + opprFollowUp.getContactLname());
		map.put("modelName", opprFollowUp.getModelName());
		map.put("itemName", opprFollowUp.getItemName());
		map.put("contactMobile1", opprFollowUp.getContactMobile1());
		output.put("customerDetails", map);

		map = new HashMap();
		int count = 0;
		for (AxelaSalesOpprFollowup result : opprFollowUpFilterImpl.findFollowup(followupOpprId)) {
			count++;
			map = new HashMap();
			map.put("slno", count);
			map.put("followupId", result.getFollowupId());
			map.put("followupTime", strToLongDate(result.getFollowupFollowupTime()));
			map.put("followupType", result.getFollowuptypeName());
			map.put("followupDesc", result.getFollowupDesc());
			map.put("followupEmpName", result.getOpprEmpName());
			map.put("followupEmpId", result.getOpprEmpId());
			map.put("followupEntryId", result.getFollowupEntryId());
			map.put("followupEntryBy", PadQuotes(empRepository.findEmpName(result.getFollowupEntryId())));
			map.put("followupEntryDate", strToLongDate(result.getFollowupEntryTime()));
			if (result.getFollowupModifiedId() != 0) {
				map.put("followupModifiedDate", strToLongDate(result.getFollowupModifiedTime()));
				map.put("followupModifiedId", result.getFollowupModifiedId());
				map.put("followupModifiedBy", PadQuotes(empRepository.findEmpName(result.getFollowupModifiedId())));
			} else {
				map.put("followupModifiedDate", "");
				map.put("followupModifiedId", "");
				map.put("followupModifiedBy", "");
			}
			list.add(map);
		}
		output.put("followUpList", list);
		if (salesOpprFollowUpRepository.updateFollowUp(followupOpprId) != null) {
			output.put("status", "update");
		} else {
			output.put("status", "add");
		}
		SOP(new JSONObject(output).toString(2) + "");
		return output;
	}

	private Map populateHistory() throws ParseException {
		output = new HashMap();
		// List<AxelaSalesOpprHistory> obj = null;
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

		for (AxelaSalesOpprHistory obj : opprFilterImpl.findHistory(historyOpprId)) {
			HashMap map = new HashMap();
			map.put("historyDatetime", strToLongDate(obj.getHistoryDatetime()));
			map.put("historyEmpName", obj.getEmpName());
			map.put("historyActiontype", obj.getHistoryActiontype());
			map.put("historyNewvalue", obj.getHistoryNewvalue());
			map.put("historyOldvalue", obj.getHistoryOldvalue());
			list.add(map);
		}
		output.put("OpprHistory", list);

		return output;
	}

	public Map<String, List> findDocs() {
		output = new LinkedHashMap<String, List>();
		opprId = 1;
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		if (opprId != 0) {
			AxelaSalesOpprDoc axelaSalesOpprDoc = salesOpprDocRepository.findDoc(opprId);
			if (axelaSalesOpprDoc != null) {
				map.put("docId", String.valueOf(axelaSalesOpprDoc.getDocId()));
				map.put("docValue", String.valueOf(axelaSalesOpprDoc.getDocValue()));
				map.put("docTitle", String.valueOf(axelaSalesOpprDoc.getDocTitle()));
				map.put("docRemarks", String.valueOf(axelaSalesOpprDoc.getDocRemarks()));
				map.put("docCount", String.valueOf(salesOpprDocRepository.findDocCount(opprId)));
			}
			list.add(map);
			output.put("opprDocList", list);
		}
		return output;
	}

	public Map<String, List> listPsfDetails() throws JSONException, ParseException {

		output = new LinkedHashMap<String, List>();
		List list = new ArrayList();
		Map map = new HashMap();

		AxelaSalesOpprFollowup opprFollowUp = new AxelaSalesOpprFollowup();
		opprFollowUp = opprFollowUpFilterImpl.findCustomerDetails(crmFollowupOpprId);
		map.put("customerName", opprFollowUp.getCustomerName());
		map.put("customerId", opprFollowUp.getCustomerId() + "");
		map.put("contactId", opprFollowUp.getContactId() + "");
		map.put("contactMobile1", opprFollowUp.getContactMobile1());
		map.put("contactName", opprFollowUp.getTitleDesc() + "." + opprFollowUp.getContactFname() + opprFollowUp.getContactLname());
		map.put("modelName", opprFollowUp.getModelName());
		map.put("itemName", opprFollowUp.getItemName());
		output.put("customerDetails", map);

		if (salesOpprFollowUpRepository.findCrmFollowUp(crmFollowupOpprId) != null) {
			List<AxelaSalesCrm> axelaSalesCrm = crmFilterImplemention.findPsfDetails(crmFollowupOpprId);
			if (axelaSalesCrm != null) {
				for (AxelaSalesCrm obj : axelaSalesCrm) {
					map = new HashMap();
					map.put("crmId", obj.getCrmId());
					map.put("crmOppId", obj.getCrmOppId());
					map.put("crmFollowupTime", strToLongDate(obj.getCrmFollowupTime()));
					map.put("crmSoId", obj.getCrmSoId());
					map.put("crmDesc", obj.getCrmDesc());
					map.put("crmEntryTime", strToLongDate(obj.getCrmEntryTime()));
					map.put("crmEntryId", obj.getCrmEntryId());
					map.put("crmEntryBy", empRepository.findEmpName(obj.getCrmEntryId()));
					map.put("crmModifiedId", obj.getCrmModifiedId());
					map.put("crmModifiedBy", empRepository.findEmpName(obj.getCrmModifiedId()));
					map.put("crmModifiedTime", obj.getCrmModifiedTime());
					map.put("crmfeedbacktypeName", obj.getCrmfeedbacktypeName());
					map.put("empName", obj.getEmpName());
					map.put("crmdaysDesc", obj.getCrmdaysDesc());
					map.put("crmdaysDaycount", obj.getCrmdaysDaycount());
					map.put("crmEmpId", obj.getCrmEmpId());
					map.put("crmtypeName", obj.getCrmtypeName());
					map.put("crmtypeId", obj.getCrmtypeId());
					list.add(map);
				}
				output.put("crmFollowUpList", list);
			}
		}
		else {
			output.put("msg", "No CRM Records Found!");
		}
		return output;

	}
	private Map populateContact(int customerId) throws JSONException {
		output = new HashMap();

		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

		for (AxelaSalesOppr obj : opprFilterImpl.findContact(customerId)) {
			HashMap map = new HashMap();
			map.put("contactId", obj.getContactId());
			map.put("contactName", obj.getTitleDesc() + "." + obj.getContactFname() + obj.getContactLname());
			map.put("contactMobile1", obj.getContactMobile1()); // + "<br>" + obj.getContactMobile2() + "<br>" + obj.getContactEmail1() + "<br>" + obj.getContactEmail1());
			map.put("contactMobile2", obj.getContactMobile2());
			map.put("contactEmail1", obj.getContactEmail1());
			map.put("contactEmail1", obj.getContactEmail1());
			map.put("contactAddress", obj.getContactAddress());
			list.add(map);
		}
		output.put("opprContactList", list);
		return output;

	}

	private Map populateCustomerDetail() throws JSONException, ParseException {
		output = new HashMap();
		// List<AxelaSalesOpprHistory> obj = null;
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		int contactId = 0;
		for (AxelaSalesOppr obj : opprFilterImpl.findCustomerDetail(customerOpprId)) {
			HashMap map = new HashMap();
			contactId = obj.getOpprContactId();// obj.getCustomerId
			map.put("customerId", contactId);
			map.put("customerName", obj.getCustomerName());
			map.put("customerMobile", obj.getCustomerMobile1());
			map.put("customerMobile2", obj.getCustomerMobile2());
			map.put("customerAddress", obj.getCustomerAddress1());
			map.put("customerAddress", obj.getCustomerAddress2());
			map.put("customerLandmark", obj.getCustomerLandmark());
			map.put("executive", empRepository.findEmpName(empId));
			map.put("branchName", obj.getBranchName());
			map.put("customerSince", strToLongDate(obj.getCustomerSince()));
			map.put("customerActive", obj.getCustomerActive());
			map.put("customerNotes", obj.getCustomerNotes());
			list.add(map);
		}
		populateContact(contactId);
		SOP("populateCustomerDetail=========================" + contactId);
		output.put("populateCustomerDetail", list);

		return output;
	}

	private Map populateVoucherList(String input) throws NumberFormatException, JSONException, ParseException {
		output = new LinkedHashMap<String, List>();
		List list = new ArrayList();
		Map map = new HashMap();

		System.out.println("populateVoucherList================");
		inputObj = new JSONObject(input);
		String voucherClassId = "0";

		if (!inputObj.isNull("voucherClassId")) {
			voucherClassId = PadQuotes(CNumeric(inputObj.getString("voucherClassId")));
		}
		strSearch = " AND voucher.voucherOpprId=" + voucherOpprId
				+ " AND type.vouchertypeVoucherclassId=" + voucherClassId
				+ " GROUP BY voucher.voucherId ORDER BY voucher.voucherId ";

		List<AxelaAccVoucher> voucherList = voucherRepositoryImpl.findAllVoucher(strSearch);
		for (AxelaAccVoucher obj : voucherList) {
			map.put("vouchertypeName", obj.getVouchertypeName());
			map.put("voucherId", obj.getVoucherId() + "");
			map.put("voucherNo", obj.getVoucherNo() + "");
			map.put("voucherAmount", obj.getVoucherAmount() + "");
			map.put("voucherNarration", obj.getVoucherNarration());
			// map.put("voucherDate", strToShortDate(stringToDate(obj.getVoucherDate())));
			map.put("voucherActive", obj.getVoucherActive());
			map.put("voucherOpprId", obj.getVoucherOpprId() + "");
			map.put("voucherQuoteId", obj.getVoucherQuoteId() + "");
			map.put("voucherInvoiceId", obj.getVoucherInvoiceId() + "");
			map.put("voucherSoId", obj.getVoucherSoId() + "");
			map.put("voucherDelnoteId", obj.getVoucherDelnoteId() + "");
			map.put("voucherPoId", obj.getVoucherPoId() + "");
			map.put("branchName", obj.getBranchName());
			map.put("branchCode", obj.getBranchCode());
			map.put("voucherCustomerId", obj.getVoucherCustomerId() + "");
			map.put("voucherContactId", obj.getVoucherContactId() + "");
			map.put("vouchertypeVoucherclassId", obj.getVouchertypeVoucherclassId() + "");
			// " COALESCE(ledger_id,'0') AS ledger_id, COALESCE(ledger_name,'') AS ledger_name,"
			map.put("customerName", obj.getCustomerName());
			map.put("voucherBranchId", obj.getVoucherBranchId() + "");
			map.put("voucherAuthorize", obj.getVoucherAuthorize());
			map.put("titleDesc", obj.getTitleDesc());
			map.put("contactFname", obj.getContactFname());
			map.put("contactLname", obj.getContactLname());
			map.put("contactMobile1", obj.getContactMobile1());
			map.put("contactMobile2", obj.getContactMobile2());
			map.put("contactEmail1", obj.getContactEmail1());
			map.put("contactEmail2", obj.getContactEmail2());
			map.put("empName", obj.getEmpName());
			map.put("empRefNo", obj.getEmpRefNo());
			// empPhoto,"
			map.put("empGender", obj.getEmpGender());
			map.put("empId", obj.getEmpId() + "");
			// empId
			map.put("vouchertypeId", obj.getVouchertypeId() + "");
			map.put("vouchertypeName", obj.getVouchertypeName());
			map.put("vouchertypePrefix", obj.getVouchertypePrefix());
			map.put("vouchertypeSuffix", obj.getVouchertypeSuffix());
			map.put("vouchertypeEmailEnable", obj.getVouchertypeEmailEnable());
			map.put("vouchertypeSmsEnable", obj.getVouchertypeSmsEnable());
			map.put("vouchertypeDocs", obj.getVouchertypeDocs());
			map.put("voucherclassId", obj.getVoucherclassId() + "");
			map.put("voucherclassFile", obj.getVoucherclassFile());
			list.add(map);
		}
		output.put("quoteList", list);
		return output;
	}
}
