package axela.sales.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.customer.model.AxelaCustomer;
import axela.customer.model.AxelaCustomerContact;
import axela.customer.repository.CustomerContactReposiitory;
import axela.customer.repository.CustomerFilterImpl;
import axela.customer.repository.CustomerRepository;
import axela.inventory.repository.InventoryItemModelRepository;
import axela.portal.model.AxelaConfig;
import axela.portal.repository.BranchRepository;
import axela.portal.repository.ConfigRepository;
import axela.portal.repository.EmpRepository;
import axela.sales.model.AxelaSalesCrm;
import axela.sales.model.AxelaSalesOppr;
import axela.sales.model.AxelaSalesOpprFollowup;
import axela.sales.model.AxelaSalesOpprHistory;
import axela.sales.repository.CrmFilterImplemention;
import axela.sales.repository.OpprFilterImpl;
import axela.sales.repository.OpprHistoryRepository;
import axela.sales.repository.OpprRepository;
import axela.sales.repository.SalesCrmRepository;
import axela.sales.repository.SalesLostCase2Repository;
import axela.sales.repository.SalesLostCase3Repository;
import axela.sales.repository.SalesOpprFollowUpRepository;
import axela.sales.repository.SalesTeamRepository;

@Service
public class OpprService extends Connect {

	public JSONObject inputObj = null;
	public HashMap output = null;
	public String requestType = "";
	public String StrSql = "";
	public int len = 0;
	public String branchAccess = "";
	public String exeAccess = "";
	public int page = 0;
	public String perpage = "0";
	public String orderType = "";
	public String orderByField = "";
	public String msg = "";

	public String customerId = "0";
	public String customerName = "";
	public String titleId = "0";

	public int contactId = 0;
	public String contactFname = "";
	public String contactLname = "";
	public String contactMobile1 = "";
	public String contactMobile2 = "";
	private String contactJobtitle = "";
	private String contactPhone1 = "";
	private String contactPhone2 = "";
	public String contactEmail1 = "";
	public String contactEmail2 = "";
	public String contactAddress = "";
	public String contactPin = "";
	public String contactCityId = "0";

	public int opprId = 0;
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
	public String opprDate = "";
	public String opprCloseDate = "";
	public String opprTitle = "";
	public String opprDesc = "";
	public String opprStatusDesc = "";
	public String opprLostcase1Id = "0";
	public String opprLostcase2Id = "0";
	public String opprLostcase3Id = "0";
	private BigDecimal opprBr = BigDecimal.ZERO;
	private String opprBudgetSyscal = "";
	private String opprManagerAssist = "";
	private String opprNotes = "";
	private String opprStatusDate = "";
	private String opprStudy = "0";
	public int opprStageId = 0;
	public int opprStatusId = 0;
	private int opprPriorityopprId = 0;
	private String opprAvpresent;

	public String perPage = "0";
	public int empId = 0;

	public String branchId = "0";
	public String branchName = "";

	public String leadId = "0";

	public int CompBusinesstypeId = 0;
	public String jobTitle = "";

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

	public String empFormatTime = "";
	public String empFormatDate = "";
	public String empOpportunityEdit = "";

	public int crmEmpId = 0;
	public String name = "";
	public String value = "";

	private String opprEdit = "0";
	public Date timeZone = null;
	private String startDate = "";
	private String endDate = "";

	@Autowired
	public OpprRepository opprRepository;

	@Autowired
	CustomerFilterImpl customerFilterImpl;

	@Autowired
	public CustomerContactReposiitory customerContactRepository;

	@Autowired
	public CustomerRepository customerRepository;

	@Autowired
	public OpprHistoryRepository opprHistoryRepository;

	@Autowired
	public ConfigRepository axelaConfigRepository;

	// @Autowired
	// public CompRepository compRepository;

	@Autowired
	public BranchRepository branchRepository;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	public OpprFilterImpl opprFilterImpl;

	@Autowired
	public InventoryItemModelRepository inventoryItemModelRepository;

	@Autowired
	SalesLostCase2Repository salesLostCase2Repository;

	@Autowired
	SalesLostCase3Repository salesLostCase3Repository;

	@Autowired
	SalesTeamRepository salesTeamRepository;

	@Autowired
	public SalesOpprFollowUpRepository salesOpprFollowUpRepository;

	@Autowired
	CrmFilterImplemention crmFilterImplemention;

	@Autowired
	SalesCrmRepository salesCrmRepository;

	@Transactional
	public Map opprServiceUpdate(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new HashMap();
		if (AppRun().equals("0")) {
			SOP("inputObj==========opprServiceUpdate==========" + inputObj.toString(1));
		}
		empId = 1;// Integer.parseInt(CNumeric(getSession("empId", session)));
		// if (empId != 0) {
		contactEmail2 = "";
		contactEmail1 = "";
		// if (!returnPerm("emp_opportunity_access", session)) {
		// output.put("errorPage", "Access denied. Please contact system administrator!");
		// return output;
		// }
		timeZone = getTimeByZone(session);
		branchAccess = getSession("branchAccess", session).replaceAll("branchId", "oppr.opprBranchId");
		exeAccess = getSession("exeAccess", session).replaceAll("empId", "oppr.opprEmpId");
		empFormatDate = PadQuotes(getSession("formatdateDatepicker", session));
		empFormatTime = PadQuotes(getSession("formattimeTimepicker", session));
		requestType = "";
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (!inputObj.isNull("empId")) {
			empId = Integer.parseInt(inputObj.getString("empId"));
		}
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
		// List<AxelaComp> axelaComp = compRepository.findAll();
		// for (AxelaComp comp : axelaComp) {
		// CompBusinesstypeId = comp.getCompBusinesstypeId();
		// }
		switch (requestType) {
			case "add" : // add an customer.
				if (!returnPerm("emp_opportunity_add", session)) {
					output.put("errorPage", "Access denied. Please contact system administrator!");
					return output;
				}
				opprId = 0;
				opprStatusId = 1;
				opprStageId = 1;
				getValues(inputObj, session);
				addFields(response);
				break;

			case "update" :// update an customer.
				if (!returnPerm("emp_opportunity_edit", session)) {
					output.put("errorPage", "Access denied. Please contact system administrator!");
					return output;
				}
				opprId = 0;
				getValues(inputObj, session);
				addFields(response);
				break;

			case "delete" :// delete an customer.
				if (!returnPerm("emp_opportunity_delete", session)) {
					output.put("errorPage", "Access denied. Please contact system administrator!");
					return output;
				}
				if (!inputObj.isNull("opprId")) {
					opprId = Integer.parseInt(inputObj.getString("opprId"));
				}
				if (opprId != 0) {
					deleteFields(opprId);
				}
				break;

			case "landing" :// landing page an customer.
				populateLandingDetails(input);
				break;

		}
		// } else {
		// if (AppRun().equals("0")) {
		// output.put("msg", "session Out!!");
		// }
		// }
		return output;
	}

	public void getValues(JSONObject inputObj, HttpSession session) throws JSONException {
		if (!inputObj.isNull("opprId")) {
			opprId = Integer.parseInt(CNumeric((String) inputObj.get("opprId")));
		}
		if (!inputObj.isNull("contactId")) {
			contactId = Integer.parseInt(CNumeric((String) inputObj.get("contactId")));
		}
		if (!inputObj.isNull("customerId")) {
			customerId = CNumeric((String) inputObj.get("customerId"));
		}
		if (!inputObj.isNull("leadId")) {
			leadId = CNumeric((String) inputObj.get("leadId"));
		}
		if (contactId == 0) {
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
			if (!inputObj.isNull("jobTitle")) {
				jobTitle = PadQuotes((String) inputObj.get("jobTitle"));
			}
			if (!inputObj.isNull("contactMobile1")) {
				contactMobile1 = PadQuotes((String) inputObj.get("contactMobile1"));
			}
			if (!inputObj.isNull("contactMobile2")) {
				contactMobile2 = PadQuotes((String) inputObj.get("contactMobile2"));
			}

			if (!inputObj.isNull("contactPhone1")) {
				contactPhone1 = PadQuotes((String) inputObj.get("contactPhone1"));
			}
			if (!inputObj.isNull("contactPhone2")) {
				contactPhone2 = PadQuotes((String) inputObj.get("contactPhone2"));
			}
			if (!inputObj.isNull("contactEmail1")) {
				contactEmail1 = PadQuotes((String) inputObj.get("contactEmail1"));
			}

			if (!inputObj.isNull("contactEmail2")) {
				contactEmail2 = PadQuotes((String) inputObj.get("contactEmail2"));
			}
			if (!inputObj.isNull("contactAddress")) {
				contactAddress = PadQuotes((String) inputObj.get("contactAddress"));
			}
			if (!inputObj.isNull("contactPin")) {
				contactPin = PadQuotes((String) inputObj.get("contactPin"));
			}
			if (!inputObj.isNull("contactCityId")) {
				contactCityId = PadQuotes((String) inputObj.get("contactCityId"));
			}
		}
		if (!inputObj.isNull("opprDate")) {
			opprDate = PadQuotes((String) inputObj.get("opprDate"));
		}
		if (!inputObj.isNull("opprCloseDate")) {
			opprCloseDate = PadQuotes((String) inputObj.get("opprCloseDate"));
		}
		if (!inputObj.isNull("opprTitle")) {
			opprTitle = PadQuotes((String) inputObj.get("opprTitle"));
		}
		if (!inputObj.isNull("opprDesc")) {
			opprDesc = PadQuotes((String) inputObj.get("opprDesc"));
		}
		if (!inputObj.isNull("opprBranchId")) {
			opprBranchId = CNumeric((String) inputObj.get("opprBranchId"));
		}
		if (opprBranchId.equals("0")) {
			opprBranchId = CNumeric(getSession("empBranchId", session));
		}
		if (empId == 1 && opprBranchId.equals("0")) {
			opprBranchId = "1";
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
		if (!inputObj.isNull("opprManagerAssist")) {
			String opprManagerAssist1;
			opprManagerAssist1 = String.valueOf(inputObj.get("opprManagerAssist"));
			if (opprManagerAssist1.equals("true")) {
				opprManagerAssist = "1";
			} else {
				opprManagerAssist = "0";
			}
		}
		if (!inputObj.isNull("opprAvpresent")) {
			String opprAvpresent1;
			opprAvpresent1 = String.valueOf(inputObj.get("opprAvpresent"));
			if (opprAvpresent1.equals("true")) {
				opprAvpresent = "1";
			} else {
				opprAvpresent = "0";
			}
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
		if (!inputObj.isNull("opprPmId")) {
			opprPmId = CNumeric((String) inputObj.get("opprPmId"));
		}
		if (!inputObj.isNull("opprRefno")) {
			opprRefno = PadQuotes((String) inputObj.get("opprRefno"));
		}
		if (!inputObj.isNull("opprNotes")) {
			opprNotes = PadQuotes((String) inputObj.get("opprNotes"));
		}
		if (!inputObj.isNull("opprStageId")) {
			opprStageId = Integer.parseInt(CNumeric((String) inputObj.get("opprStageId")));
		}
		if (!inputObj.isNull("opprStatusId")) {
			opprStatusId = Integer.parseInt(CNumeric((String) inputObj.get("opprStatusId")));
		}
		if (!inputObj.isNull("opprStatusDesc")) {
			opprStatusDesc = PadQuotes((String) inputObj.get("opprStatusDesc"));
		}
		if (!inputObj.isNull("opprPriorityopprId")) {
			opprPriorityopprId = Integer.parseInt(CNumeric((String) inputObj.get("opprPriorityopprId")));
		}
	}

	public void validateFields() throws ParseException {
		msg = "";
		String custname = "";
		if (leadId.equals("0")) {
			if (configSalesLeadForOppr.equals("1")) {
				msg += "<br>Add lead before adding " + configSalesOpprName + "!";
			}
		}
		if (customerName.equals("")) {
			custname = (contactFname + " " + contactLname).trim();
			customerName = toTitleCase(custname);
		} else {
			custname = toTitleCase(customerName);
			customerName = custname;
		}

		if (contactId == 0) {
			if (!customerName.equals("") && configCustomerDupnames.equals("0")) {
				if (customerRepository.findByCustomerName(customerName) != null) {
					msg += "<br>Similar Customer found!";
				}
			}
			if (titleId.equals("0")) {
				msg = msg + "<br>Select Title!";
			}

			if (contactFname.equals("")) {
				msg += "<br>Enter the Contact Person Name!";
			} else {
				contactFname = toTitleCase(contactFname);
			}

			if (!contactLname.equals("")) {
				contactLname = toTitleCase(contactLname);
			}

			if (contactMobile1.equals("") && contactPhone1.equals("") && contactEmail1.equals("")) {
				msg += "<br>Enter Contact Mobile 1 or Phone 1 or Email 1!";
			}
			if (!contactMobile1.equals("")) {
				len = contactMobile1.length();

				if (len < 7 || len > 15) {
					msg = msg + "<br>Enter Valid Contact Mobile 1!";
				}
			}

			if (!contactMobile2.equals("")) {
				len = contactMobile2.length();
				if (len < 7 || len > 15) {
					msg += "<br>Enter Valid Contact Mobile 2!";
				}
			}
			if (!contactPhone1.equals("")) {
				len = contactPhone1.length();
				if (len < 7 || len > 15) {
					msg += "<br>Enter Valid Contact Phone 1!";
				} else {
					customerContactRepository.findContactPhone(contactPhone1);
					if (customerContactRepository.findContactPhone(contactPhone1).length != 0) {
						msg += "<br>Similar Phone  Found!";
					}
				}
			}
			if (!contactPhone2.equals("")) {
				len = contactPhone2.length();
				if (len < 7 || len > 15) {
					msg += "<br>Enter Valid Contact Phone 2!";
				}
				else {
					customerContactRepository.findContactPhone(contactPhone2);
					if (customerContactRepository.findContactPhone(contactPhone2).length != 0) {
						msg += "<br>Similar Phone  Found!";
					}
				}
			}
			if (!contactEmail1.equals("")) {
				if (!IsValidEmail(contactEmail1)) {
					msg += "<br>Enter Valid Contact Email 1!";
				} else {
					if (customerContactRepository.findContactEmail(contactEmail1).length != 0) {
						msg += "<br>Similar Email 1 Found!!";
					}
					contactEmail1 = contactEmail1.toLowerCase();

				}
			}
			if (!contactEmail2.equals("")) {
				if (!IsValidEmail(contactEmail2)) {
					msg = msg + "<br>Enter valid Contact Email 2!";
				} else {
					if (customerContactRepository.findContactEmail(contactEmail2).length != 0) {
						msg += "<br>Similar Email 2 Found!!";
					}
					contactEmail2 = contactEmail2.toLowerCase();

				}
			}
			if (contactAddress.equals("") && configCustomerAddress.equals("1")) {
				msg += "<br>Enter Contact Address!";
			} else {
				contactAddress = toTitleCase(contactAddress);
			}

			if (contactCityId.equals("0")) {
				msg += "<br>Select Contact City!";
			}
			if (contactPin.equals("") && configCustomerAddress.equals("1")) {
				msg += "<br>Enter Contact Pin!";
			} else if (!isNumeric(contactPin)) {
				msg += "<br>Contact Pin: Enter Numeric!";
			}
		}
		if (empOpportunityEdit.equals("1")) {
			if (opprDate.equals("")) {
				msg += "<br>Select " + configSalesOpprName + " Date!";
			} else {
				if (!isValidDateFormat(opprDate, empFormatDate)) {
					msg = msg + "<br>Enter Valid " + configSalesOpprName + " Date!";
				}
			}
		}
		if (opprCloseDate.equals("")) {
			msg = msg + "<br>Enter Closed Date!";
		} else {
			if (!isValidDateFormat(opprCloseDate, empFormatDate)) {
				msg = msg + "<br>Enter Valid " + configSalesOpprName + " Date!";
			}
		}

		if (opprTitle.equals("")) {
			if (!opprModelId.equals("0")) {
				String itemModel = inventoryItemModelRepository.findByModelName(Integer.parseInt(opprModelId));

				if (!itemModel.equals("")) {
					opprTitle = "New " + itemModel;
				} else {
					opprTitle = "New Enquiry";
				}
			} else {
				opprTitle = "New Enquiry";
			}
		} else {
			if (opprTitle.length() < 3) {
				msg = msg + "<br>Enter Complete " + configSalesOpprName + " Title!";
			}
		}
		if (configSalesOpprModel.equals("1")) {
			if (opprModelId.equals("0")) {
				msg += "<br>Select Model!";
			}
		}
		if (configSalesOpprItem.equals("1")) {
			if (opprItemId.equals("0")) {
				msg += "<br>Select Item!";
			}
		}

		if (opprEmpId.equals("0")) {
			msg += "<br>Select Executive!";
		}
		if (configSalesSoe.equals("1")) {
			if (opprSoeId.equals("0")) {
				msg += "<br>Select Source of Enquiry!";
			}
		}
		if (configSalesSob.equals("1")) {
			if (opprSobId.equals("0")) {
				msg += "<br>Select Source of Bussiness!";
			}
		}
		if (configSalesCampaign.equals("1")) {
			if (opprCampaignId.equals("0")) {
				msg += "<br>Select Campaign!";
			}
		}
		if (configSalesOpprRefno.equals("1")) {
			if (opprRefno.equals("")) {
				msg += "<br>Enter " + configSalesOpprName + " Reference No.!";
			} else {
				if (opprRefno.length() < 2) {
					msg += "<br>" + configSalesOpprName + " Reference No. Should be Atleast Two Digits!";
				}
				if (!opprBranchId.equals("0")) {
					if (!opprRepository.findByOpprRefno(opprBranchId, opprRefno).equals("")) {
						msg += "<br>Similar " + configSalesOpprName + " Reference No. found!";
					}
				}
			}
		}

		// if (!opprBranchId.equals("0")) {
		// if (!opprEmpId.equals("0")) {
		// crmEmpId = salesTeamRepository.findByTeamEmpId(Integer.parseInt(opprBranchId), Integer.parseInt(opprEmpId));
		// }
		// }
	}

	public void deleteFields(int opprId) {
		opprRepository.delete(opprId);
		output.put("successmsg", "Opportunity Deleted Successfully!");
	}

	@Transactional
	public void addFields(HttpServletResponse response) throws ParseException {
		SOP("addFields");
		validateFields();
		SOP("validateFields");
		output = new HashMap();
		AxelaSalesOppr axelaSalesOppr = null;
		if (msg.equals("")) {
			if (opprId == 0) {
				SOP("addd");
				axelaSalesOppr = new AxelaSalesOppr();
			} else {
				axelaSalesOppr = opprRepository.findOne(opprId);
			}
			if (contactId == 0) {
				if (customerId.equals("0") || (!customerId.equals("0") && configCustomerDupnames.equals("1"))) {
					AxelaCustomer axelaCustomer = new AxelaCustomer();
					axelaCustomer.setCustomerBranchId(Integer.parseInt(opprBranchId));
					axelaCustomer.setCustomerName(customerName);
					axelaCustomer.setCustomerMobile1(contactMobile1);
					axelaCustomer.setCustomerMobile2(contactMobile2);
					axelaCustomer.setCustomerEmail1(contactEmail1);
					axelaCustomer.setCustomerSobId(Integer.parseInt(opprSobId));
					axelaCustomer.setCustomerSoeId(Integer.parseInt(opprSoeId));
					axelaCustomer.setCustomerEntryDate(timeZone);
					axelaCustomer.setCustomerEntryId(empId);
					axelaCustomer.setCustomerModifiedId(0);
					axelaCustomer.setCustomerModifiedDate(stringToDate(""));
					axelaCustomer.setCustomerActive("1");
					axelaCustomer.setCustomerAddress1(contactAddress);
					axelaCustomer.setCustomerAddress2("");
					axelaCustomer.setCustomerArnNo("");
					axelaCustomer.setCustomerCode("");
					axelaCustomer.setCustomerEmail2(contactEmail2);
					axelaCustomer.setCustomerFax1("");
					axelaCustomer.setCustomerFax2("");
					axelaCustomer.setCustomerGstDocValue("");
					axelaCustomer.setCustomerGstNo("");
					axelaCustomer.setCustomerGstRegdate(stringToDate(""));
					axelaCustomer.setCustomerItstatusId("0");
					axelaCustomer.setCustomerLandmark("");
					axelaCustomer.setCustomerLedgertype(0);
					axelaCustomer.setCustomerNotes("");
					axelaCustomer.setCustomerPanNo("");
					axelaCustomer.setCustomerPhone1("");
					axelaCustomer.setCustomerPhone2("");
					axelaCustomer.setCustomerPhone3("");
					axelaCustomer.setCustomerPhone4("");
					axelaCustomer.setCustomerPin(contactPin);
					axelaCustomer.setCustomerReconciliation("");
					axelaCustomer.setCustomerServiceTaxNo("");
					axelaCustomer.setCustomerSince(stringToDate(""));
					axelaCustomer.setCustomerTax("");
					axelaCustomer.setCustomerTds("");
					axelaCustomer.setCustomerTinNo("");
					axelaCustomer.setCustomerUserEntryDate(stringToDate(""));
					axelaCustomer.setCustomerUserModifiedDate(stringToDate(""));
					axelaCustomer.setCustomerWebsite1("");
					axelaCustomer.setCustomerWebsite2("");
					customerId = customerRepository.save(axelaCustomer).getCustomerId() + "";
				}
				// SOP("customerId=====================" + customerId);
				AxelaCustomerContact axelaCustomerContact = new AxelaCustomerContact();
				axelaCustomerContact.setContactTitleId(Integer.parseInt(titleId));
				axelaCustomerContact.setContactFname(contactFname);
				axelaCustomerContact.setContactLname(contactLname);
				axelaCustomerContact.setContactActive("1");
				axelaCustomerContact.setContactJobtitle(contactJobtitle);
				axelaCustomerContact.setContactAddress(contactAddress);
				axelaCustomerContact.setContactAnniversary(stringToDate(""));
				axelaCustomerContact.setContactAol("");
				axelaCustomerContact.setContactCityId(contactCityId);
				axelaCustomerContact.setContactCustomerId(Integer.parseInt(customerId));
				axelaCustomerContact.setContactDnd("");
				axelaCustomerContact.setContactDob(stringToDate(""));
				axelaCustomerContact.setContactEmail1(contactEmail1);
				axelaCustomerContact.setContactEmail2(contactEmail2);
				axelaCustomerContact.setContactJobtitle("");
				axelaCustomerContact.setContactLandmark("");
				axelaCustomerContact.setContactLocation("");
				axelaCustomerContact.setContactMobile1(contactMobile1);
				axelaCustomerContact.setContactMobile2(contactMobile2);
				axelaCustomerContact.setContactSkype("");
				axelaCustomerContact.setContactYahoo("");
				axelaCustomerContact.setContactPhone1(contactPhone1);
				axelaCustomerContact.setContactPhone2(contactPhone2);
				axelaCustomerContact.setContactMsn("");
				axelaCustomerContact.setContactPin(contactPin);
				axelaCustomerContact.setContactNotes("");
				axelaCustomerContact.setContactEntryDate((timeZone));
				axelaCustomerContact.setContactEntryId(empId);
				axelaCustomerContact.setContactModifiedDate(stringToDate(""));
				axelaCustomerContact.setContactModifiedId(Integer.parseInt("0"));
				contactId = customerContactRepository.save(axelaCustomerContact).getContactId();
				// SOP("contactId======================" + contactId);
			}
			axelaSalesOppr.setOpprAvpresent(opprAvpresent);
			axelaSalesOppr.setOpprCustomerId(Integer.parseInt(customerId));
			axelaSalesOppr.setOpprContactId(contactId);
			axelaSalesOppr.setOpprDesc(opprDesc);
			axelaSalesOppr.setOpprNo(opprRepository.findOpprNo());
			axelaSalesOppr.setOpprTitle(opprTitle);
			axelaSalesOppr.setOpprBranchId(Integer.parseInt(opprBranchId));
			axelaSalesOppr.setOpprEmpId(Integer.parseInt(opprEmpId));
			axelaSalesOppr.setOpprModelId(Integer.parseInt(opprModelId));
			axelaSalesOppr.setOpprItemId(Integer.parseInt(opprItemId));
			axelaSalesOppr.setOpprTeamId(Integer.parseInt(opprTeamId));
			axelaSalesOppr.setOpprSoeId(Integer.parseInt(opprSoeId));
			axelaSalesOppr.setOpprSobId(Integer.parseInt(opprSobId));
			axelaSalesOppr.setOpprStageId(opprStageId);
			axelaSalesOppr.setOpprCampaignId(Integer.parseInt(opprCampaignId));
			axelaSalesOppr.setOpprPmId(Integer.parseInt(opprPmId));
			axelaSalesOppr.setOpprRefno(opprRefno);
			axelaSalesOppr.setOpprCityId(Integer.parseInt(contactCityId));
			axelaSalesOppr.setOpprAvpresent("");
			axelaSalesOppr.setOpprBr(opprBr);// BigDecimal.ZERO
			axelaSalesOppr.setOpprBudgetSyscal(opprBudgetSyscal);
			axelaSalesOppr.setOpprCloseDate(stringToDate(opprCloseDate));
			axelaSalesOppr.setOpprDate(stringToDate(opprDate));
			axelaSalesOppr.setOpprManagerAssist(opprManagerAssist);
			axelaSalesOppr.setOpprStatusId(opprStatusId);
			axelaSalesOppr.setOpprPriorityopprId(opprPriorityopprId);
			axelaSalesOppr.setOpprNotes(opprNotes);
			axelaSalesOppr.setOpprStatusDate(stringToDate((opprStatusDate)));
			axelaSalesOppr.setOpprStatusDesc(opprStatusDesc);
			axelaSalesOppr.setOpprStudy(opprStudy);
			axelaSalesOppr.setOpprTravelTodate(stringToDate(""));
			axelaSalesOppr.setOpprTravelFromdate(stringToDate(""));
			if (requestType.equals("add")) {
				axelaSalesOppr.setOpprEntryId(empId);
				axelaSalesOppr.setOpprEntryDate(timeZone);
				axelaSalesOppr.setOpprModifiedDate(stringToDate(""));
				axelaSalesOppr.setOpprModifiedId(0);
			} else if (requestType.equals("update")) {
				axelaSalesOppr.setOpprEntryId(axelaSalesOppr.getOpprEntryId());
				axelaSalesOppr.setOpprEntryDate(axelaSalesOppr.getOpprEntryDate());
				axelaSalesOppr.setOpprModifiedDate(timeZone);
				axelaSalesOppr.setOpprModifiedId(empId);
			}
			opprId = opprRepository.save(axelaSalesOppr).getOpprId();
			// SOP("axelaSalesOppr.getOpprId())========================" + opprId);
			if (requestType.equals("add")) {
				AxelaSalesOpprHistory axelaSalesOpprHistory = new AxelaSalesOpprHistory();
				axelaSalesOpprHistory.setHistoryOpprId(BigInteger.valueOf(opprId));
				axelaSalesOpprHistory.setHistoryEmpId(empId);
				axelaSalesOpprHistory.setHistoryDatetime(timeZone);
				axelaSalesOpprHistory.setHistoryActiontype("New Enquiry");
				axelaSalesOpprHistory.setHistoryNewvalue("New Enquiry");
				axelaSalesOpprHistory.setHistoryOldvalue("");
				opprHistoryRepository.save(axelaSalesOpprHistory);

				AxelaSalesOpprFollowup axelaSalesOpprFollowup = new AxelaSalesOpprFollowup();
				axelaSalesOpprFollowup.setFollowupOpprId(opprId);
				axelaSalesOpprFollowup.setFollowupEmpId(empId);
				axelaSalesOpprFollowup.setFollowupFollowupTime(timeZone);
				axelaSalesOpprFollowup.setFollowupFollowuptypeId(1);
				axelaSalesOpprFollowup.setFollowupDesc("");
				axelaSalesOpprFollowup.setFollowupEntryId(empId);
				axelaSalesOpprFollowup.setFollowupEntryTime(timeZone);
				axelaSalesOpprFollowup.setFollowupModifiedId(0);
				axelaSalesOpprFollowup.setFollowupModifiedTime(stringToDate(""));
				salesOpprFollowUpRepository.save(axelaSalesOpprFollowup);
				// addCrmFallowUp();
			}
			if (opprId != 0 && requestType.equals("add")) {
				output.put("successmsg", "Opportunity Added Successfully!");
				output.put("opprId", opprId + "");
			} else if (opprId != 0 && requestType.equals("update")) {
				output.put("successmsg", "Opportunity Updated Successfully!");
				output.put("opprId", opprId + "");
			}

		} else {
			response.setStatus(200); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public Map populateData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		Map map = new HashMap();
		ArrayList list = new ArrayList();
		output = new HashMap();
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		if (empId != 0) {
			if (!returnPerm("emp_opportunity_edit", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			if (!inputObj.isNull("opprId")) {
				opprId = Integer.parseInt(PadQuotes(CNumeric(inputObj.getString("opprId"))));
			}
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
					map.put("contactFname", axelaSalesOppr.getContactFname());
					map.put("contactLname", axelaSalesOppr.getContactLname());
					map.put("contactMobile1", axelaSalesOppr.getContactMobile1());
					map.put("contactMobile2", axelaSalesOppr.getContactMobile2());
					map.put("contactPhone1", axelaSalesOppr.getContactPhone1());
					map.put("contactPhone2", axelaSalesOppr.getContactPhone2());
					map.put("contactEmail1", axelaSalesOppr.getContactEmail1());
					map.put("contactEmail2", axelaSalesOppr.getContactEmail2());
					map.put("contactAddress", axelaSalesOppr.getContactAddress());
					map.put("contactCityId", axelaSalesOppr.getContactCityId());
					map.put("contactPin", axelaSalesOppr.getContactPin());
					map.put("branchName", axelaSalesOppr.getBranchName());
					map.put("branchCode", axelaSalesOppr.getBranchCode());
					map.put("opprTeamId", axelaSalesOppr.getOpprTeamId() + "");
					map.put("opprItemId", axelaSalesOppr.getOpprItemId() + "");
					map.put("opprPmId", axelaSalesOppr.getOpprPmId() + "");
					map.put("opprSobId", axelaSalesOppr.getOpprSobId() + "");
					map.put("opprSoeId", axelaSalesOppr.getOpprSoeId() + "");
					map.put("opprCampaignId", axelaSalesOppr.getOpprCampaignId() + "");
					map.put("opprRefno", PadQuotes(axelaSalesOppr.getOpprRefno()));
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
		}
		return output;
	}

	// End Of Populate Opportunity Data
	@SuppressWarnings({"unused", "rawtypes", "unchecked"})
	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		String customerName = getSession("configCustomerName", session);
		String configSalesOpprName = getSession("configSalesOpprName", session);
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		String strSearch = "";
		String strOrderBy = "";
		String requestType = "";
		output = new LinkedHashMap<String, String>();
		if (empId != 0) {
			if (!returnPerm("emp_opportunity_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			page = 0;
			branchAccess = getSession("branchAccess", session).replaceAll("branchId", "oppr.opprBranchId");
			exeAccess = getSession("exeAccess", session).replaceAll("empId", "oppr.opprEmpId");
			String customerType = "";
			List<AxelaCustomer> customerList = null;
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			PageRequest request = null;
			if (!inputObj.isNull("requestType")) {
				requestType = PadQuotes((inputObj.getString("requestType")));
			}
			if (!inputObj.isNull("sortField")) {
				orderByField = PadQuotes((inputObj.getString("sortField")));
			}
			if (!inputObj.isNull("pageIndex")) {
				page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
			}
			if (!inputObj.isNull("sortDirection")) {
				orderType = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
			}
			perPage = CNumeric(getSession("empRecperpage", session));
			if (orderType.equals("")) {
				orderType = "DESC";
			}
			if (orderByField.equals("")) {
				orderByField = "opprId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}

			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			} else {
				strSearch += " AND oppr.opprStatusId=1";
			}
			strSearch += branchAccess + exeAccess;
			strOrderBy = " ORDER BY oppr." + orderByField + " " + orderType + "";
			List<AxelaSalesOppr> resultSet = opprFilterImpl.findAll(strSearch, strOrderBy, page, Integer.parseInt(perPage), "no");
			String totalCount = opprFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(totalCount), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("ID", "opprId", "center"));
			listHeader.add(produceHeaderData("No.", "opprNo", "center"));
			listHeader.add(produceHeaderData(configSalesOpprName, "opprRefNo", "center"));
			listHeader.add(produceHeaderData("Date", "opprDate", "center"));
			listHeader.add(produceHeaderData(customerName, "axelaCustomer.customerName", "center"));
			listHeader.add(produceHeaderData("Item", ".itemName", "center"));
			listHeader.add(produceHeaderData("Stage", "axelaSalesOpprStage.stageName", "center"));
			listHeader.add(produceHeaderData("Status", "axelaSalesOpprStatus.statusName", "center"));
			listHeader.add(produceHeaderData("Executive", "axelaEmp.empName", "center"));
			listHeader.add(produceHeaderData("Branch", "axelaBranch.branchName", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaSalesOppr obj : resultSet) {
				ArrayList<String> paramSubArr = new ArrayList<String>();
				ArrayList<ArrayList> paramArr = new ArrayList<ArrayList>();
				ArrayList type = new ArrayList();
				ArrayList value = new ArrayList();
				HashMap<String, List<HashMap>> mapData = new HashMap<String, List<HashMap>>();
				HashMap<String, List<HashMap>> mapAction = new HashMap<String, List<HashMap>>();
				HashMap<String, List<String>> mapBodyData = new HashMap<String, List<String>>();
				List<HashMap> listData = new ArrayList<HashMap>();
				count++;
				// Start Body data
				// count
				type.add(false);
				value.add(count);
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// ID.
				type.add(true);
				value.add(String.valueOf(obj.getOpprId()));
				paramSubArr.add("opportunityDash");
				paramSubArr.add(obj.getOpprId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();

				// Oppr NO
				type.add(false);
				value.add(String.valueOf(obj.getOpprBranchId()) + String.valueOf(obj.getOpprNo()));
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// Opportunity
				type.add(false);
				value.add(obj.getOpprTitle());
				paramSubArr.add(obj.getOpprId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();

				// Date
				type.add(false);
				value.add(strToShortDate(obj.getOpprCloseDate()));
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// Customer
				if (!obj.getCustomerName().equals("")) {
					type.add(true);
					value.add(obj.getCustomerName());
					paramSubArr.add("customerList");
					paramSubArr.add(obj.getOpprCustomerId() + "");
					paramArr.add((ArrayList) paramSubArr.clone());
					paramSubArr.clear();
				}
				if (!obj.getContactName().equals("")) {
					type.add(true);
					value.add(obj.getContactName());
					paramSubArr.add("contactList");
					paramSubArr.add(obj.getOpprContactId() + "");
					paramArr.add((ArrayList) paramSubArr.clone());
					paramSubArr.clear();
				}
				if (!obj.getContactMobile1().equals("")) {
					type.add(false);
					value.add(obj.getContactMobile1());
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getContactMobile2().equals("")) {
					type.add(false);
					value.add(obj.getContactMobile2());
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getContactPhone1().equals("")) {
					type.add(false);
					value.add(obj.getContactPhone1());
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getContactPhone2().equals("")) {
					type.add(false);
					value.add(obj.getContactPhone2());
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getContactEmail1().equals("")) {
					type.add(false);
					value.add("<a href=\"mailto:" + obj.getContactEmail1() + ">" + obj.getContactEmail1() + "</a> ");
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getContactEmail2().equals("")) {
					type.add(false);
					value.add("<a href=\"mailto:" + obj.getContactEmail2() + ">" + obj.getContactEmail1() + "</a> ");
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();

				// item
				type.add(false);
				value.add(obj.getItemName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// stage
				type.add(false);
				value.add(obj.getOpprStageName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// status
				type.add(false);
				value.add(obj.getOpprStatusName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();

				// executive
				type.add(false);
				type.add(true);
				value.add(ExePhotoOval(obj.getOpprEmpId() + ""));
				value.add(obj.getEmpName());
				paramArr.add((ArrayList) paramSubArr.clone());
				paramSubArr.add("executiveSummary");
				paramSubArr.add(obj.getOpprEmpId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();

				// branch
				type.add(true);
				value.add(obj.getBranchName());
				paramSubArr.add("branchSummary");
				paramSubArr.add(obj.getOpprBranchId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();

				// End Body data
				mapData.put("td", listData);
				ArrayList actionParam = new ArrayList();
				ArrayList actionParam1 = new ArrayList();
				ArrayList actionParam2 = new ArrayList();
				actionParam.add("updateOpportunity");
				actionParam1.add("addQuote");
				actionParam2.add("addSalesOrder");
				actionParam.add(PadQuotes(String.valueOf(obj.getOpprId())));
				actionParam1.add(PadQuotes(String.valueOf(obj.getOpprId())));
				actionParam1.add("5");
				actionParam1.add("5");
				actionParam2.add(PadQuotes(String.valueOf(obj.getOpprId())));
				actionParam2.add("4");
				actionParam2.add("4");
				mapAction.put("td", produceActionData(actionParam, actionParam1, actionParam2));
				listAction.add(mapAction);
				listBody.add(mapData);
			}
			output.put("meta", mapNavi);
			output.put("action", listAction);
			output.put("tdalign", listBodyAlign);
			output.put("thead", listHeader);
			output.put("tbody", listBody);
		}
		return output;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<HashMap> produceActionData(ArrayList<String> Param, ArrayList<String> Param1, ArrayList<String> Param2) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Opportunity");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Add Quote");
		mapBodyData.put("param", Param1);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Add Sales Order");
		mapBodyData.put("param", Param2);
		listAction.add((HashMap) mapBodyData.clone());

		return listAction;
	}

	public HashMap<String, String> opportunitySearch(String input, HttpServletResponse response) throws JSONException {
		String contactMobile = "";
		String contactEmail = "";
		output = new LinkedHashMap<String, String>();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("contactMobile")) {
			SOP("coming");
			contactMobile = inputObj.getString("contactMobile");
			List<AxelaCustomerContact> contact = customerFilterImpl.searchMobile(contactMobile);
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			for (AxelaCustomerContact obj : contact) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("opprId", "" + obj.getOpprId());
				map.put("statusName", "" + obj.getStatusName());
				map.put("contactName", "" + obj.getContactName());
				map.put("contactMobile1", "" + obj.getContactMobile1());
				map.put("contactId", "" + obj.getContactId());
				map.put("customerName", "" + obj.getCustomerName());
				map.put("customerId", "" + obj.getContactCustomerId());
				list.add(map);
			}
			output.put("contactMobile", list);
		}
		if (!inputObj.isNull("contactEmail")) {
			contactEmail = inputObj.getString("contactEmail");;
			List<AxelaCustomerContact> contact = customerFilterImpl.searchEmail(contactEmail);
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			for (AxelaCustomerContact obj : contact) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("contactName", obj.getContactName());
				map.put("contactId", "" + obj.getContactId());
				map.put("contactEmail", "" + obj.getContactEmail1());
				map.put("customerName", "" + obj.getCustomerName());
				map.put("customerId", "" + obj.getContactCustomerId());
				list.add(map);
			}
			output.put("contactEmail", list);

		}
		return output;
	}

	public Map populateDrSmart(HttpSession session) {
		String customerName = getSession("configCustomerName", session);
		String configSalesOpprName = getSession("configSalesOpprName", session);
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "oppr.*"));
		list.add(buildSmartArr(configSalesOpprName + "ID", "numeric", "oppr.opprId"));
		list.add(buildSmartArr("Opportunity No", "numeric", "oppr.opprNo"));
		list.add(buildSmartArr("Branch ID", "numeric", "oppr.opprBranchId"));
		list.add(buildSmartArr("Branch Name", "text", "branch.branchName"));
		list.add(buildSmartArr(customerName + " ID", "numeric", "oppr.opprCustomerId"));
		list.add(buildSmartArr("Contact ID", "numeric", "oppr.opprContactId"));
		list.add(buildSmartArr("Contact Name", "text", "oppr.axelaCustomerContact.contactName"));
		list.add(buildSmartArr("Mobile", "text", "CONCAT(REPLACE(oppr.axelaCustomerContact.contactMobile1,'-',''),REPLACE(oppr.axelaCustomerContact.contactMobile2,'-',''))"));
		list.add(buildSmartArr("Phone", "text", "CONCAT(REPLACE(oppr.axelaCustomerContact.contactPhone1,'-',''),REPLACE(oppr.axelaCustomerContact.contactPhone2,'-','')"));
		list.add(buildSmartArr("Email", "text", "CONCAT(oppr.axelaCustomerContact.contactEmail1, oppr.axelaCustomerContact.contactEmail2)"));
		list.add(buildSmartArr("Descripition", "text", "oppr.opprDesc"));
		list.add(buildSmartArr("Date", "Date", "oppr.opprDate"));
		list.add(buildSmartArr("Close Date", "Date", "oppr.opprCloseDate"));
		list.add(buildSmartArr("AV Presentation", "boolean", "oppr.opprAvpresent"));
		list.add(buildSmartArr("Manager Assistance", "boolean", "oppr.opprManagerAssistance"));
		list.add(buildSmartArr("Status", "text", "oppr.axelaSalesOpprStatus.statusName"));
		list.add(buildSmartArr("Stage", "text", "oppr.axelaSalesOpprStage.stageName"));
		output.put("drSmart", list.toArray());
		return output;
	}

	// add custom crm fallowup
	public void addCrmFallowUp() throws ParseException {
		String crmId = "";
		String crmOpprId = "0";
		String crmSoId = "0";
		String crmCrmdaysId = "0";
		String crmRefcrmdaysId = "0";
		String crmCrmfollowupid = "0";
		String crmPsffollowupid = "0";
		String crmFollowupTime = "";
		String crmMobile1 = "";
		String crmMobile2 = "";
		String crmEmail1 = "";
		String crmEmail2 = "";
		String crmLostcase1Id = "0";
		String crmLostcase2Id = "0";
		String crmLostcase3Id = "0";
		String crmCancelreasonId = "0";
		String crmCrmfeedbacktypeId = "0";
		String crmDesc = "";
		String crmSatisfied = "";
		String crmCrmconcernId = "0";
		String crmTicketEmpId = "0";
		String crmEntryId = "0";
		String crmEntryTime = "";
		String crmModifiedId = "0";
		String crmModifiedTime = "";
		String crmTrigger = "";
		String crmtype = "";
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		String crmEmpid = "";
		String crmCrmdaysid = "";
		String inputDate = addDayMonthYear(stringToDate("2017-04-28 15:20:29"), -1, 0, 0, 0);

		output = new LinkedHashMap();
		List<Integer> axelaSalesTeam = salesTeamRepository.findForCrmFields();
		opprEmpId = String.valueOf(axelaSalesTeam.get(0));
		if (crmtype.equals("new")) {
			StrSql += " AND crmdays.crmdaysLostfollowup=0 AND crmdays.crmdaysTestdrivefollowup=0 AND crmdays.crmdaysHomevisitfollowup=0";
		} else if (crmtype.equals("lost")) {
			StrSql += " AND crmdays.crmdaysLostfollowup=1 AND crmdays.crmdaysTestdrivefollowup=0 AND crmdays.crmdaysHomevisitfollowup=0";
		} else if (crmtype.equals("testdrive")) {
			StrSql += " AND crmdays.crmdaysLostfollowup=0 AND crmdays.crmdaysTestdrivefollowup=1 AND crmdays.crmdaysHomevisitfollowup=0";
		} else if (crmtype.equals("homevisit")) {
			StrSql += " AND crmdays.crmdaysLostfollowup=0 AND crmdays.crmdaysTestdrivefollowup=0 AND crmdays.crmdaysHomevisitfollowup=1";
		}

		List<Object[]> axelaSalesOppr = crmFilterImplemention.findCrmField(17, inputDate, StrSql);
		for (Object[] obj : axelaSalesOppr) {
			crmOpprId = String.valueOf(obj[0]);
			crmEmpid = String.valueOf(obj[1]);
			crmCrmdaysid = String.valueOf(obj[2]);
			crmFollowupTime = String.valueOf(obj[3]);
		}
		AxelaSalesCrm axelaSalesCrm = new AxelaSalesCrm();
		axelaSalesCrm.setCrmOpprId(Integer.parseInt(crmOpprId));
		axelaSalesCrm.setCrmEmpId(Integer.parseInt(crmEmpid));
		axelaSalesCrm.setCrmCrmdaysId(Integer.parseInt(crmCrmdaysid));
		axelaSalesCrm.setCrmFollowupTime(stringToDate(crmFollowupTime));
		axelaSalesCrm.setCrmSoId(0);
		axelaSalesCrm.setCrmRefcrmdaysId(0);
		axelaSalesCrm.setCrmMobile1("");
		axelaSalesCrm.setCrmMobile2("");
		axelaSalesCrm.setCrmEmail1("");
		axelaSalesCrm.setCrmEmail2("");
		axelaSalesCrm.setCrmLostcase1Id(0);
		axelaSalesCrm.setCrmLostcase2Id(0);
		axelaSalesCrm.setCrmLostcase3Id(0);
		axelaSalesCrm.setCrmCancelreasonId(0);
		axelaSalesCrm.setCrmDesc("");
		axelaSalesCrm.setCrmEntryId(empId);
		axelaSalesCrm.setCrmEntryTime(kknow());
		String savingId = salesCrmRepository.save(axelaSalesCrm).getCrmId() + "";
	}

	private void populateLandingDetails(String input) throws ParseException, JSONException {
		msg = "";
		startDate = "";
		endDate = "";
		opprBranchId = "0";
		output = new HashMap<String, String>();
		String strSearch = "";
		JSONObject inputJson = new JSONObject(input);
		if (!AppRun().equals(1)) {
			SOP("populateLandingDetails===========================" + inputJson.toString(1));
		}
		if (!inputJson.isNull("startDate")) {
			startDate = PadQuotes(inputJson.getString("startDate"));
		}
		if (!inputJson.isNull("endDate")) {
			endDate = PadQuotes(inputJson.getString("endDate"));
		}
		if (!inputJson.isNull("opprBranchId")) {
			opprBranchId = PadQuotes(inputJson.getString("opprBranchId"));
		}
		landingValidation();
		if (msg.equals("")) {
			if (!startDate.equals("")) {
				strSearch += " AND SUBSTRING(oppr.opprDate,1,10) >= SUBSTRING('" + dateToString(stringToDate(startDate)) + "',1,10) ";
			}
			if (!endDate.equals("")) {
				strSearch += " AND SUBSTRING(oppr.opprDate,1,10) <= SUBSTRING('" + dateToString(stringToDate(endDate)) + "',1,10) ";
			}
			if (!opprBranchId.equals("0")) {
				strSearch += " AND oppr.opprBranchId=" + opprBranchId;
			}
			strSearch += " AND branch.branchActive = '1'"
					+ branchAccess + exeAccess;
			List<Object[]> result = opprFilterImpl.findOpprLandingDetails(strSearch);
			List list = new ArrayList<Map>();
			int total = 0;
			for (Object[] obj : result) {
				Map map = new HashMap<String, String>();
				map.put("branchId", obj[0]);
				map.put("branchName", obj[1]);
				map.put("opprCount", obj[2]);
				total += Integer.parseInt(obj[2] + "");
				list.add(map);
			}
			output.put("total", total + "");
			output.put("populateLandingDetails", list);
		} else {
			output.put("errormsg", msg);
		}
	}
	private void landingValidation() throws ParseException {

		if (startDate.equals("")) {
			msg = msg + "<br>Select Start Date!";
		}
		if (!startDate.equals("")) {
			if (isValidDateFormat(startDate, empFormatDate)) {
				// startDate = formatDateStr(startDate, empFormatDate + " " + empFormatTime);
			} else {
				msg = msg + "<br>Enter Valid Start Date!";
			}
		}
		if (endDate.equals("")) {
			msg = msg + "<br>Select End Date!";
		}
		if (!endDate.equals("")) {
			if (isValidDateFormat(endDate, empFormatDate)) {
				// endDate = formatDateStr(endDate, empFormatDate + " " + empFormatTime);
			} else {
				msg = msg + "<br>Enter Valid End Date!";
			}
		}
		if (msg.equals("")) {
			if (!startDate.equals("") && !endDate.equals("")) {
				if (stringToDate(startDate).compareTo(stringToDate(endDate)) > 0) {
					msg = msg + "<br>Start Date should be less than End date!";
				}
			}
		}
	}
}
