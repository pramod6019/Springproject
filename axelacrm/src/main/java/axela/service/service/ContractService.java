package axela.service.service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import axela.helpdesk.repository.HelpDeskTicketRepository;
import axela.portal.model.TaxRepository;
import axela.portal.repository.ConfigRepository;
import axela.portal.repository.EmpRepository;
import axela.service.model.AxelaServiceContract;
import axela.service.repository.ServiceContractAssetRepository;
import axela.service.repository.ServiceContractDocRepository;
import axela.service.repository.ServiceContractImpl;
import axela.service.repository.ServiceContractRepository;
import axela.service.repository.ServiceContractServiceRepository;

@Service
public class ContractService extends Connect {

	@Autowired
	ServiceContractRepository serviceContractRepository;

	@Autowired
	HelpDeskTicketRepository helpDeskTicketRepository;

	@Autowired
	CustomerContactReposiitory customerContactReposiitory;

	@Autowired
	CustomerFilterImpl customerFilterImpl;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ServiceContractServiceRepository serviceContractServiceRepository;

	@Autowired
	ServiceContractDocRepository serviceContractDocRepository;

	@Autowired
	ServiceContractAssetRepository serviceContractAssetRepository;

	@Autowired
	EmpRepository axelaEmpRepository;

	@Autowired
	ServiceContractImpl contractFilterImpl;

	@Autowired
	ConfigRepository axelaConfigRepository;

	@Autowired
	TaxRepository taxRepository;

	@Autowired
	ServiceContractImpl serviceContractImpl;

	private final static int PAGESIZE = 25;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public int empId = 0;
	public String empRoleId = "0";
	public String msg = "";
	public String contractId = "0";
	public String branchId = "0";
	public String contractBranchId = "0";
	public String contractTypeId = "0";
	public String contractTaxId = "0";
	public String contractNo = "0";
	public Date contractDate = null;
	public Date contractdate = null;
	public Date contractStartDate = null;
	public Date contractstartdate = null;
	public Date contractEndDate = null;
	public Date contractenddate = null;
	public String contractPrioritycontractId = "0";
	public String contractEmpId = "0";
	public String contractRefno = "";
	public String contractActive = "";
	public String contractNotes = "";
	public String contractEntryId = "0";
	public String contractEntryDate = "";
	public String contractModifiedId = "0";
	public String contractModifiedDate = "";
	public String entryBy = "";
	public String entryDate = "";
	public String modifiedBy = "";
	public String modifiedDate = "";
	public DecimalFormat deci = new DecimalFormat("0.00");
	public String BranchAccess = "";
	public String compId = "0";
	public String contractCustomerId = "0";
	public String customerName = "";
	public String contractContactId = "0";
	public String contactTitleId = "0";
	public String contactFname = "";
	public String contactLname = "";
	public String contactName = "";
	public String contactMobile1 = "";
	public String contactEmail1 = "";
	public String contactPhone1 = "";
	public String contactAddress = "";
	public String contactPin = "";
	public String contactCityId = "0";
	public String linkCustomerName = "";
	public String configCustomerName = "";
	public String linkContactName = "";
	public String contractTitle = "";
	public String contractBillAddress = "";
	public String contractBillCity = "";
	public String contractBillState = "";
	public String contractBillCountry = "";
	public String contractBillPin = "";
	public String contractShipAddress = "";
	public String contractShipState = "";
	public String contractShipCountry = "";
	public String contractShipCity = "";
	public String contractShipPin = "";
	public String contractAmt = "0";
	public String contractDiscamt = "0";
	public String contractServiceTax = "0";
	public String contractNetamt = "0";
	public String contractTax = "0";
	public String contractGrandtotal = "0";
	public String contractDesc = "";
	public String contractTerms = "";
	public String contractPo = "";
	public String customerMobile1 = "";
	public String customerPhone1 = "";
	public String customerEmail1 = "";
	public String customerAddress1 = "";
	public String customerAddress2 = "";
	public String customerArnNo = "";
	public String customerCityId = "0";
	public String customerPin = "";
	public String customerEmpId = "0";
	public String customerSince = "";
	public String customerActive = "";
	public String customerNotes = "";
	public String customerEntryId = "0";
	public String customerEntryDate = "";
	public String configServiceContractRefno = "";
	public String contractContracttypeId = "0";
	public String configCustomerAddress = "0";
	public String contractServiceAddress = "";
	public String contractServiceCity = "";
	public String contractServicePin = "";
	public String contractServiceState = "";
	public String contractServiceCountry = "";
	public String QueryString = "";
	public String contactId = "0";
	public String branchAccess = "";
	public String exeAccess = "";
	public int page = 0;
	public String perPage = "0";
	public int totalCount = 0;
	public DecimalFormat dF = new DecimalFormat("0.00");
	public String contactNotes = "";
	public String contactActive = "";
	public String contactEntryId = "0";
	public String contactEntryDate = "";
	public String contactCustomerId = "0";
	public String customerId = "0";
	public String contractTicketqueueId = "0";
	public String customerCode = "";
	public String customerEmail2 = "";
	public String customerFax1 = "";
	public String customerFax2 = "";
	public String customerGstDocValue = "";
	public String customerGstNo = "";
	public String customerGstRegdate = "";
	public String customerItstatusId = "0";
	public String customerLandmark = "";
	public String customerMobile2 = "";
	public String customerModifiedDate = "";
	public String CustomerModifiedId = "0";
	public String customerPanNo = "0";
	public String customerPhone2 = "";
	public String customerPhone3 = "";
	public String customerPhone4 = "";
	public String customerReconciliation = "";
	public String customerServiceTaxNo = "0";
	public String customerTax = "";
	public String customerTds = "";
	public String customerTinNo = "0";
	public String customerUserEntryDate = "";
	public String customerUserModifiedDate = "";
	public String customerWebsite1 = "";
	public String customerWebsite2 = "";
	public String contactAnniversary = "";
	public String contactAol = "";
	public String contactDnd = "";
	public String contactDob = "";
	public String contactEmail2 = "";
	public String contactPhone2 = "";
	public String contactMobile2 = "";
	public String contactJobtitle = "";
	public String contactLandmark = "";
	public String contactLocation = "";
	public String Tax = "";
	public String contactModifiedDate = "";
	public String ContactModifiedId = "0";
	public String contactMsn = "";
	public String contactSkype = "";
	public String contactYahoo = "";
	public String ContractModifiedId = "0";
	public String StrSql = "";
	public String tag = "Contract";
	public String orderByField = "";
	public String orderType = "";
	public String contactemail1 = "";
	public String empFormatdate = "";
	public String requestType = "";
	public String formatdateDatepicker = "";
	public String empFormattime = "";
	public String group = "";
	private String starttime = "";
	private String endtime = "";
	private String drBranchId = "";
	private String startTime = "";
	private String endTime = "";
	HashMap output = null;
	JSONObject inputObj = null;

	public Map contractsService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = (CNumeric(PadQuotes(getSession("compId", session))));
		branchId = CNumeric(getSession("empBranchId", session));
		BranchAccess = PadQuotes(getSession("BranchAccess", session));
		empFormatdate = PadQuotes(getSession("formatdateName", session));
		formatdateDatepicker = PadQuotes(getSession("formatdateDatepicker", session));
		empFormattime = PadQuotes(getSession("formattimeName", session));
		configCustomerName = PadQuotes(getSession("configCustomerName", session));
		contractDate = stringToDate(formatDate(getTimeByZone(session).toString(), empFormatdate));
		contractStartDate = stringToDate(formatDate((compId), empFormatdate));
		contractEndDate = stringToDate(formatDate(getTimeByZone(session).toString(), empFormatdate));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("inputObj========ticketService==========" + inputObj.toString(1));
		}
		output = new HashMap<String, String>();
		if (empId != 0) {
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			populateConfigDetails(input, response);
			switch (requestType) {
				case "add" : // add an soe.
					if (!returnPerm("emp_contract_add", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					contractId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;
				case "update" :// update an customer.
					contractId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;
				case "delete" :// delete an customer.
					if (!returnPerm("emp_contract_delete", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					if (!inputObj.isNull("contractId")) {
						contractId = CNumeric(PadQuotes(inputObj.getString("contractId")));
					}
					if (!contractId.equals("0")) {
						deleteFields(Integer.parseInt(contractId));
					}
					break;
				case "landing" :// delete an customer.
					if (!inputObj.isNull("startTime")) {
						startTime = PadQuotes(inputObj.getString("startTime"));
					}
					if (!inputObj.isNull("endTime")) {
						endTime = PadQuotes(inputObj.getString("endTime"));
					}
					String date = "";
					if (startTime.equals("") || endTime.equals("")) {
					}
					date = sdf.format(getTimeByZone(session));
					if (startTime.equals("")) {
						startTime = ReportStartdate(date, empFormatdate);
					}
					if (endTime.equals("")) {
						endTime = formatDate(date, empFormatdate).toString();
					}
					if (branchId.equals("0")) {
						if (!inputObj.isNull("drBranchId")) {
							drBranchId = PadQuotes(inputObj.getString("drBranchId"));
						}
						if (drBranchId.equals("")) {
							drBranchId = "0";
						}
					} else {
						drBranchId = branchId;
					}
					populateLandingDetails(input, session, response);
					break;
			}
		}
		if (AppRun().equals("0")) {
			SOP("output========ticketService==========" + output);
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException, ParseException {
		msg = "";
		contactEmail1 = "";
		if (!inputObj.isNull("contactNotes")) {
			contactNotes = PadQuotes(inputObj.getString("contactNotes"));
		}
		if (!inputObj.isNull("contractAmt")) {
			contractAmt = CNumeric(PadQuotes(inputObj.getString("contractAmt")));
		}
		if (!inputObj.isNull("contactActive")) {
			contactActive = PadQuotes(inputObj.getString("contactActive"));
		}
		if (!inputObj.isNull("customerAddress2")) {
			customerAddress2 = PadQuotes(inputObj.getString("customerAddress2"));
		}
		if (!inputObj.isNull("contactEntryId")) {
			contactEntryId = CNumeric(PadQuotes(inputObj.getString("contactEntryId")));
		}
		if (!inputObj.isNull("contactEntryDate")) {
			contactEntryDate = PadQuotes(inputObj.getString("contactEntryDate"));
		}
		if (!inputObj.isNull("contactCustomerId")) {
			contactCustomerId = CNumeric(inputObj.getString("contactCustomerId"));
		}
		if (!inputObj.isNull("customerMobile1")) {
			customerMobile1 = PadQuotes(inputObj.getString("customerMobile1"));
		}
		if (!inputObj.isNull("contractContracttypeId")) {
			contractContracttypeId = PadQuotes(inputObj.getString("contractContracttypeId"));
		}
		if (!inputObj.isNull("customerPhone1")) {
			customerPhone1 = PadQuotes(inputObj.getString("customerPhone1"));
		}
		if (!inputObj.isNull("customerEmail1")) {
			customerEmail1 = PadQuotes(inputObj.getString("customerEmail1"));
		}
		if (!inputObj.isNull("customerAddress1")) {
			customerAddress1 = PadQuotes(inputObj.getString("customerAddress1"));
		}
		if (!inputObj.isNull("customerCityId")) {
			customerCityId = CNumeric(inputObj.getString("customerCityId"));
		}
		if (!inputObj.isNull("customerPin")) {
			customerPin = PadQuotes(inputObj.getString("customerPin"));
		}
		if (!inputObj.isNull("customerEmpId")) {
			customerEmpId = CNumeric(inputObj.getString("customerEmpId"));
		}
		if (!inputObj.isNull("customerSince")) {
			customerSince = PadQuotes(inputObj.getString("customerSince"));
		}
		if (!inputObj.isNull("customerActive")) {
			customerActive = PadQuotes(inputObj.getString("customerActive"));
		}
		if (customerNotes.length() > 5000) {
			customerNotes = customerNotes.substring(0, 4999);
		}
		if (!inputObj.isNull("customerEntryId")) {
			customerEntryId = PadQuotes(inputObj.getString("customerEntryId"));
		}
		if (!inputObj.isNull("contractActive")) {
			contractActive = inputObj.getString("contractActive");
		}
		if (!inputObj.isNull("customerEntryDate")) {
			customerEntryDate = PadQuotes(inputObj.getString("customerEntryDate"));
		}
		if (!inputObj.isNull("contractId")) {
			contractId = CNumeric(inputObj.getString("contractId"));
		}
		if (!inputObj.isNull("contractBranchId")) {
			contractBranchId = CNumeric(PadQuotes(inputObj.getString("contractBranchId")));
		}
		if (!inputObj.isNull("contractTypeId")) {
			contractTypeId = CNumeric(inputObj.getString("contractTypeId"));
		}
		if (!inputObj.isNull("contractTaxId")) {
			contractTaxId = CNumeric(inputObj.getString("contractTaxId"));
		}
		if (!inputObj.isNull("contractNo")) {
			contractNo = PadQuotes(inputObj.getString("contractNo"));
		}
		if (!inputObj.isNull("contractDate")) {
			contractDate = stringToDate(inputObj.getString("contractDate"));
		}
		if (!inputObj.isNull("contractStartDate")) {
			contractStartDate = stringToDate(PadQuotes(inputObj.getString("contractStartDate")));
		}
		if (!inputObj.isNull("contractEndDate")) {
			contractEndDate = stringToDate(PadQuotes(inputObj.getString("contractEndDate")));
		}
		if (!inputObj.isNull("contractPrioritycontractId")) {
			contractPrioritycontractId = CNumeric(inputObj.getString("contractPrioritycontractId"));
		}
		if (!inputObj.isNull("contractEmpId")) {
			contractEmpId = CNumeric(inputObj.getString("contractEmpId"));
		}
		if (!inputObj.isNull("contractRefno")) {
			contractRefno = PadQuotes(inputObj.getString("contractRefno"));
		}
		// if (!inputObj.isNull("contractActive")) {
		// contractActive = PadQuotes(inputObj.getString("contractActive"));
		// }
		if (!inputObj.isNull("contractNotes")) {
			contractNotes = PadQuotes(inputObj.getString("contractNotes"));
			if (contractNotes.length() > 5000) {
				contractNotes = contractNotes.substring(0, 4999);
			}
		}
		if (!inputObj.isNull("contractEntryId")) {
			contractEntryId = CNumeric(inputObj.getString("contractEntryId"));
		}
		if (!inputObj.isNull("contractEntryDate")) {
			contractEntryDate = PadQuotes(inputObj.getString("contractEntryDate"));
		}

		if (!inputObj.isNull("contractModifiedId")) {
			contractModifiedId = CNumeric(inputObj.getString("contractModifiedId"));
		}
		if (!inputObj.isNull("contractModifiedDate")) {
			contractModifiedDate = PadQuotes(inputObj.getString("contractModifiedDate"));
		}

		if (!inputObj.isNull("entryBy")) {
			entryBy = CNumeric(inputObj.getString("entryBy"));
		}
		if (!inputObj.isNull("entryDate")) {
			entryDate = PadQuotes(inputObj.getString("entryDate"));
		}
		if (!inputObj.isNull("modifiedBy")) {
			modifiedBy = CNumeric(inputObj.getString("modifiedBy"));
		}
		if (!inputObj.isNull("modifiedDate")) {
			modifiedDate = PadQuotes(inputObj.getString("modifiedDate"));
		}
		if (!inputObj.isNull("contractCustomerId")) {
			contractCustomerId = CNumeric(inputObj.getString("contractCustomerId"));
		}
		if (!inputObj.isNull("customerName")) {
			customerName = PadQuotes(inputObj.getString("customerName"));
		}
		if (!inputObj.isNull("contractContactId")) {
			contractContactId = CNumeric(inputObj.getString("contractContactId"));
		}
		if (!inputObj.isNull("contactTitleId")) {
			contactTitleId = CNumeric(inputObj.getString("contactTitleId"));
		}
		if (!inputObj.isNull("contactFname")) {
			contactFname = PadQuotes(inputObj.getString("contactFname"));
		}
		if (!inputObj.isNull("contactLname")) {
			contactLname = PadQuotes(inputObj.getString("contactLname"));
		}
		if (!inputObj.isNull("contactName")) {
			contactName = PadQuotes(inputObj.getString("contactName"));
		}
		if (!inputObj.isNull("contactMobile1")) {
			contactMobile1 = PadQuotes(inputObj.getString("contactMobile1"));
		}
		if (!inputObj.isNull("contactEmail1")) {
			contactEmail1 = PadQuotes(inputObj.getString("contactEmail1"));
		}
		if (!inputObj.isNull("contactPhone1")) {
			contactPhone1 = PadQuotes(inputObj.getString("contactPhone1"));
		}
		if (!inputObj.isNull("contactAddress")) {
			contactAddress = PadQuotes(inputObj.getString("contactAddress"));
		}
		if (!inputObj.isNull("contactPin")) {
			contactPin = PadQuotes(inputObj.getString("contactPin"));
		}
		if (!inputObj.isNull("contactCityId")) {
			contactCityId = CNumeric(inputObj.getString("contactCityId"));
		}
		if (!inputObj.isNull("linkCustomerName")) {
			linkCustomerName = PadQuotes(inputObj.getString("linkCustomerName"));
		}
		if (!inputObj.isNull("linkContactName")) {
			linkContactName = PadQuotes(inputObj.getString("linkContactName"));
		}
		if (!inputObj.isNull("contractTitle")) {
			contractTitle = PadQuotes(inputObj.getString("contractTitle"));
		}
		if (!inputObj.isNull("contractBillAddress")) {
			contractBillAddress = PadQuotes(inputObj.getString("contractBillAddress"));
		}
		if (!inputObj.isNull("contractBillCity")) {
			contractBillCity = PadQuotes(inputObj.getString("contractBillCity"));
		}
		if (!inputObj.isNull("contractBillState")) {
			contractBillState = PadQuotes(inputObj.getString("contractBillState"));
		}
		if (!inputObj.isNull("contractBillCountry")) {
			contractBillCountry = PadQuotes(inputObj.getString("contractBillCountry"));
		}
		if (!inputObj.isNull("contractBillPin")) {
			contractBillPin = PadQuotes(inputObj.getString("contractBillPin"));
		}
		if (!inputObj.isNull("contractServiceAddress")) {
			contractServiceAddress = PadQuotes(inputObj.getString("contractServiceAddress"));
		}
		if (!inputObj.isNull("contractServiceCity")) {
			contractServiceCity = PadQuotes(inputObj.getString("contractServiceCity"));
		}
		if (!inputObj.isNull("contractServiceCountry")) {
			contractServiceCountry = PadQuotes(inputObj.getString("contractServiceCountry"));
		}
		if (!inputObj.isNull("contractServiceState")) {
			contractServiceState = PadQuotes(inputObj.getString("contractServiceState"));
		}
		if (!inputObj.isNull("contractServicePin")) {
			contractServicePin = PadQuotes(inputObj.getString("contractServicePin"));
		}
		if (!contractAmt.equals("0") && !contractAmt.equals("0.0") && !contractAmt.equals("")) {
			if (!inputObj.isNull("contractDiscamt")) {
				contractDiscamt = PadQuotes(inputObj.getString("contractDiscamt"));
			}
			if (!inputObj.isNull("contractNetamt")) {
				contractNetamt = PadQuotes(inputObj.getString("contractNetamt"));
			}
			if (!inputObj.isNull("contractServiceTax")) {
				contractServiceTax = PadQuotes(inputObj.getString("contractServiceTax"));
			}
			if (!inputObj.isNull("contractGrandtotal")) {
				contractGrandtotal = PadQuotes(inputObj.getString("contractGrandtotal"));
			}
		} else {
			contractDiscamt = "0";
			contractNetamt = "0";
			contractServiceTax = "0";
			contractGrandtotal = "0";
		}
		if (!inputObj.isNull("contractTax")) {
			contractTax = PadQuotes(inputObj.getString("contractTax"));
		}
		if (!inputObj.isNull("contractDesc")) {
			contractDesc = PadQuotes(inputObj.getString("contractDesc"));
		}
		if (!inputObj.isNull("contractTerms")) {
			contractTerms = PadQuotes(inputObj.getString("contractTerms"));
		}
		if (!inputObj.isNull("contractPo")) {
			contractPo = PadQuotes(inputObj.getString("contractPo"));
		}
		if (!inputObj.isNull("contractPrioritycontractId")) {
			contractPrioritycontractId = CNumeric(inputObj.getString("contractPrioritycontractId"));
		}
		if (!inputObj.isNull("contractTicketqueueId")) {
			contractTicketqueueId = CNumeric(inputObj.getString("contractTicketqueueId"));
		}
	}
	public void validateFields() throws ParseException {
		msg = "";
		if (contractBranchId.equals("0")) {
			msg = msg + "<br>Select Branch!";
		}
		if (contractDate.equals("")) {
			msg += "<br>Select Contract Date!";
		}
		if (!contractDate.equals("")) {
			if (isValidDateFormat(sdf.format(contractDate), empFormatdate)) {
				contractDate = stringToDate(formatDateStr(sdf.format(contractDate), empFormatdate));
			} else {
				contractDate = contractdate;
				msg += "<br>Enter Valid Contract Date!";
			}
		}
		if (contractContracttypeId.equals("0")) {
			msg = msg + "<br>Select Contract Type!";
		}
		if (contractStartDate.equals("")) {
			msg += "<br>Select Start Date!";
		} else if (isValidDateFormat(sdf.format(contractStartDate), empFormatdate)) {
			contractStartDate = stringToDate(formatDateStr(sdf.format(contractStartDate), empFormatdate));
		} else {
			contractStartDate = contractstartdate;
			msg += "<br>Enter Valid Start Date!";
		}
		if (contractEndDate.equals("")) {
			msg = msg + "<br>Select End Date!";
		} else if (isValidDateFormat(sdf.format(contractEndDate), empFormatdate)) {
			contractEndDate = stringToDate(formatDateStr(sdf.format(contractEndDate), empFormatdate));
		} else {
			contractEndDate = contractenddate;
			msg = msg + "<br>Enter Valid End Date!";
		}
		// if (!contractEndDate.equals("") && !contractStartDate.equals("")
		// && isValidDateFormat(strToLongDate(contractStartDate), empFormatdate) && isValidDateFormat(strToLongDate(contractEndDate), empFormatdate)) {
		// if (contractenddate.before(contractstartdate)) {
		// msg = msg + "<br>End Date Should be greater than Start Date!";
		// }
		// }
		// if (requestType.equals("add") && contactId.equals("0")) {
		if (requestType.equals("add") && contractContactId.equals("0")) {
			if (contactTitleId.equals("0")) {
				msg = msg + "<br>Select Title!";
			}
			if (contactFname.equals("")) {
				msg = msg + "<br>Enter the First Name!";
			} else {
				contactFname = toTitleCase(contactFname);
			}
			if (!contactLname.equals("")) {
				contactLname = toTitleCase(contactLname);
			}
			if (!contactemail1.equals("")) {
				if (!IsValidEmail(contactemail1)) {
					msg += "<br>Enter Valid Contact Email!";
				} else {
					contactemail1 = contactemail1.toLowerCase();
				}
			}
			if (configCustomerAddress.equals("1") && contactAddress.equals("")) {
				msg += "<br>Enter Contact Address!";
			}
			if (contactCityId.equals("")) {
				msg += "<br>Select Contact City!";
			}
			if (configCustomerAddress.equals("1") && contactPin.equals("")) {
				msg += "<br>Enter Contact Pin!";
			} else if (!contactPin.equals("") && !isNumeric(contactPin)) {
				msg += "<br>Contact Pin: Enter Numeric!";
			}
		}
		if (!contractAmt.equals("0") && !contractAmt.equals("0.0") && contractAmt.equals("")) {
			if (contractTaxId.equals("0")) {
				msg += "<br>Select Tax!";
			}
		}
		if (!contractAmt.equals("0") && !contractAmt.equals("0.0") && contractAmt.equals("")) {
			if (Double.parseDouble(contractDiscamt) > Double.parseDouble(contractAmt)) {
				msg += "<br>Amount Should be greater Discount amount!";
			}
		}
		if (!contractBillAddress.equals("") || !contractBillCity.equals("") || !contractBillPin.equals("") || !contractBillState.equals("") || !contractBillCountry.equals("")) {
			if (contractBillAddress.equals("")) {
				msg += "<br>Enter Billing Address!";
			}
			if (contractBillCity.equals("")) {
				msg += "<br>Enter Billing City!";
			}
			if (contractBillPin.equals("")) {
				msg += "<br>Enter Billing Pin!";
			}
			if (contractBillState.equals("")) {
				msg += "<br>Enter Billing State!";
			}
			if (contractBillCountry.equals("")) {
				msg += "<br>Enter Billing Country!";
			}
		}
		if (!contractServiceAddress.equals("") || !contractServiceCity.equals("") || !contractServicePin.equals("") || !contractServiceState.equals("") || !contractServiceCountry.equals("")) {
			if (contractServiceAddress.equals("")) {
				msg += "<br>Enter Service Address!";
			}
			if (contractServiceCity.equals("")) {
				msg += "<br>Enter Service City!";
			}
			if (contractServicePin.equals("")) {
				msg = msg + "<br>Enter Service Pin!";
			}
			if (contractServiceState.equals("")) {
				msg = msg + "<br>Enter Service State!";
			}
			if (contractServiceCountry.equals("")) {
				msg = msg + "<br>Enter Service Country!";
			}
		}
		if (configServiceContractRefno.equals("1")) {
			if (contractRefno.equals("")) {
				msg = msg + "<br>Enter Reference No.!";
			} else if (contractRefno.length() < 2) {
				msg = msg + "<br>Reference No. Should be Atleast Two Digits!";
			}
		}
		if (!contractRefno.equals("")) {
			String getcontractRefno = "";
			getcontractRefno = serviceContractRepository.findByReferenceno(Integer.parseInt(contractBranchId), contractRefno);
			if (requestType.equals("update")) {
				getcontractRefno = serviceContractRepository.findByReferencenoAndId(Integer.parseInt(contractBranchId), getcontractRefno, Integer.parseInt(contractId));
			}
			if (!getcontractRefno.equals("")) {
				msg = msg + "<br>Similar Reference No. Found! ";
			}
		}
		if (contractPrioritycontractId.equals("0")) {
			msg = msg + "<br>Select Priority!";
		}
		if (contractEmpId.equals("0")) {
			msg = msg + "<br>Select Executive!";
		}
		if (contractTicketqueueId.equals("0")) {
			msg = msg + "<br>Select Department!";
		}
	}

	public void addFields(HttpServletResponse response, HttpSession session) throws ParseException {
		validateFields();
		AxelaServiceContract axelaServiceContract = null;
		AxelaCustomer axelaCustomer = null;
		AxelaCustomerContact axelaCustomerContact = null;
		List<Object[]> contract;
		if (msg.equals("")) {
			if (!contractId.equals("0")) {
				axelaServiceContract = serviceContractRepository.findOne(Integer.parseInt(contractId));
			} else {
				axelaServiceContract = new AxelaServiceContract();
			}
			if (!contractAmt.equals("0")) {
				contractNetamt = Double.parseDouble(contractAmt) - Double.parseDouble(contractDiscamt) + "";
				Tax = CNumeric(taxRepository.findTaxValue(Integer.parseInt(contractTaxId)));
				contractServiceTax = deci.format(Double.parseDouble(CalServiceTax(contractNetamt, Tax)));
				contractGrandtotal = PopulateTotal1(contractNetamt, contractServiceTax);
			}
			if (contactId.equals("0")) {
				if (!contactMobile1.equals("") || !contactPhone1.equals("") || !contactEmail1.equals("")) {
					contract = customerFilterImpl.findByCustomerContactId(contactMobile1, contactPhone1, contactEmail1);
				}
			}
			if (contractContactId.equals("0") && contractCustomerId.equals("0")) {
				axelaCustomer = new AxelaCustomer();
				axelaCustomer.setCustomerBranchId(Integer.parseInt(branchId));
				axelaCustomer.setCustomerName(customerName);
				axelaCustomer.setCustomerMobile1(customerMobile1);
				axelaCustomer.setCustomerMobile2(customerMobile2);
				axelaCustomer.setCustomerPhone1(customerPhone1);
				axelaCustomer.setCustomerEmail1(customerEmail1);
				axelaCustomer.setCustomerEmail2(customerEmail2);
				axelaCustomer.setCustomerWebsite1(customerWebsite1);
				axelaCustomer.setCustomerWebsite2(customerWebsite2);
				axelaCustomer.setCustomerAddress1(customerAddress1);
				axelaCustomer.setCustomerAddress2(customerAddress2);
				axelaCustomer.setCustomerFax1(customerFax1);
				axelaCustomer.setCustomerPanNo(customerPanNo);
				axelaCustomer.setCustomerServiceTaxNo(customerServiceTaxNo);
				axelaCustomer.setCustomerModifiedId(Integer.parseInt(CustomerModifiedId));
				axelaCustomer.setCustomerFax2(customerFax2);
				axelaCustomer.setCustomerReconciliation(customerReconciliation);;
				axelaCustomer.setCustomerItstatusId(customerItstatusId);
				axelaCustomer.setCustomerGstNo(customerGstNo);
				axelaCustomer.setCustomerPhone2(customerPhone2);
				axelaCustomer.setCustomerPhone3(customerPhone3);
				axelaCustomer.setCustomerPhone4(customerPhone4);
				axelaCustomer.setCustomerLandmark(customerLandmark);
				axelaCustomer.setCustomerTinNo(customerTinNo);
				axelaCustomer.setCustomerGstDocValue(customerGstDocValue);
				axelaCustomer.setCustomerTax(customerTax);
				axelaCustomer.setCustomerCode(customerCode);
				axelaCustomer.setCustomerArnNo(customerArnNo);
				axelaCustomer.setCustomerTds(customerTds);
				axelaCustomer.setCustomerCityId(Integer.parseInt(customerCityId));
				axelaCustomer.setCustomerPin(customerPin);
				axelaCustomer.setCustomerEmpId(Short.parseShort(customerEmpId));
				axelaCustomer.setCustomerActive(customerActive);
				axelaCustomer.setCustomerNotes(customerNotes);
				axelaCustomer.setCustomerEntryId(Integer.parseInt(customerEntryId));
				axelaCustomer.setCustomerEntryDate(stringToDate(""));
				axelaCustomer.setCustomerMobile1(customerMobile1);
				customerRepository.save(axelaCustomer);
				axelaCustomerContact = new AxelaCustomerContact();
				axelaCustomerContact.setContactCustomerId(Integer.parseInt(contactCustomerId));
				axelaCustomerContact.setContactDob(stringToDate(contactDob));
				axelaCustomerContact.setContactTitleId(Integer.parseInt(contactTitleId));
				axelaCustomerContact.setContactAnniversary(stringToDate(contactAnniversary));
				axelaCustomerContact.setContactFname(contactFname);
				axelaCustomerContact.setContactAol(contactAol);
				axelaCustomerContact.setContactLocation(contactLocation);
				axelaCustomerContact.setContactLname(contactLname);
				axelaCustomerContact.setContactSkype(contactSkype);
				axelaCustomerContact.setContactMobile1(contactMobile1);
				axelaCustomerContact.setContactPhone1(contactPhone1);
				axelaCustomerContact.setContactEmail1(contactEmail1);
				axelaCustomerContact.setContactAddress(contactAddress);
				axelaCustomerContact.setContactCityId(contactCityId);
				axelaCustomerContact.setContactPin(contactPin);
				axelaCustomerContact.setContactYahoo(contactYahoo);
				axelaCustomerContact.setContactDnd(contactDnd);
				axelaCustomerContact.setContactNotes(contactNotes);
				axelaCustomerContact.setContactMsn(contactMsn);
				axelaCustomerContact.setContactActive(contactActive);
				axelaCustomerContact.setContactEntryId(Integer.parseInt(contactEntryId));
				axelaCustomerContact.setContactEmail2(contactEmail2);
				axelaCustomerContact.setContactPhone2(contactPhone2);
				axelaCustomerContact.setContactMobile2(contactMobile2);
				axelaCustomerContact.setContactLandmark(contactLandmark);
				axelaCustomerContact.setContactJobtitle(contactJobtitle);
				axelaCustomerContact.setContactModifiedId(Integer.parseInt(ContactModifiedId));
				customerContactReposiitory.save(axelaCustomerContact);
			}
			axelaServiceContract.setContractId(Integer.parseInt(contractId));
			axelaServiceContract.setContractNo(Integer.parseInt(contractNo));
			axelaServiceContract.setContractBranchId(Integer.parseInt(contractBranchId));
			axelaServiceContract.setContractContracttypeId(Integer.parseInt(contractContracttypeId));
			axelaServiceContract.setContractDate(contractDate);
			axelaServiceContract.setContractStartDate(contractStartDate);
			axelaServiceContract.setContractEndDate(contractEndDate);
			axelaServiceContract.setContractTitle(contractTitle);
			axelaServiceContract.setContractCustomerId(Integer.parseInt(contractCustomerId));
			axelaServiceContract.setContractContactId(Integer.parseInt(contractContactId));
			axelaServiceContract.setContractTaxId(Integer.parseInt(contractTaxId));
			if (!contractAmt.equals("0")) {
				axelaServiceContract.setContractAmt(Double.parseDouble(contractAmt));
				axelaServiceContract.setContractDiscamt(Double.parseDouble(contractDiscamt));
				axelaServiceContract.setContractNetamt(Double.parseDouble(contractNetamt));
				axelaServiceContract.setContractTax(Double.parseDouble(contractTax));
				axelaServiceContract.setContractGrandtotal(Double.parseDouble(contractGrandtotal));
			}
			axelaServiceContract.setContractBillAddress(contractBillAddress);
			axelaServiceContract.setContractBillCity(contractBillCity);
			axelaServiceContract.setContractBillPin(contractBillPin);
			axelaServiceContract.setContractBillState(contractBillState);
			axelaServiceContract.setContractBillCountry(contractBillCountry);
			axelaServiceContract.setContractServiceAddress(contractServiceAddress);
			axelaServiceContract.setContractServiceCity(contractServiceCity);
			axelaServiceContract.setContractServicePin(contractServicePin);
			axelaServiceContract.setContractServiceState(contractServiceState);
			axelaServiceContract.setContractServiceCountry(contractServiceCountry);
			axelaServiceContract.setContractDesc(contractDesc);
			axelaServiceContract.setContractTerms(contractTerms);
			axelaServiceContract.setContractEmpId(Integer.parseInt(contractEmpId));
			axelaServiceContract.setContractPo(contractPo);
			axelaServiceContract.setContractPrioritycontractId(Integer.parseInt(contractPrioritycontractId));
			axelaServiceContract.setContractRefno(contractRefno);
			axelaServiceContract.setContractTicketqueueId(Integer.parseInt(contractTicketqueueId));
			axelaServiceContract.setContractActive(contractActive);
			axelaServiceContract.setContractNotes(contractNotes);
			if (requestType.equals("add")) {
				axelaServiceContract.setContractEntryDate(getTimeByZone(session));
				axelaServiceContract.setContractEntryId(empId);
				axelaServiceContract.setContractModifiedId(0);
			} else if (requestType.equals("update")) {
				axelaServiceContract.setContractEntryDate(axelaServiceContract.getContractEntryDate());
				axelaServiceContract.setContractEntryId(axelaServiceContract.getContractEntryId());
				axelaServiceContract.setContractModifiedId(empId);
				axelaServiceContract.setContractModifiedDate(getTimeByZone(session));
			}
			AxelaServiceContract result = null;
			result = serviceContractRepository.save(axelaServiceContract);
			if (result != null && requestType.equals("add")) {
				output.put("successmsg", "Contract Added Successfully!");
				output.put("contractId", result.getContractId() + "");
			} else if (result != null && requestType.equals("update")) {
				output.put("successmsg", "Contract Updated Successfully!");
				output.put("contractId", result.getContractId() + "");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}
	public String PopulateTotal1(String Fee, String Tax) {// PopulateTotalAmount{
		double TotalAmount = Double.parseDouble(Fee) + Double.parseDouble(Tax);// TotalAmount=7118
		String TotalAmount1 = Double.toString(TotalAmount);
		return TotalAmount1;
	}

	public Map<String, String> populateContractData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, String>();
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			if (!returnPerm("emp_contract_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			AxelaServiceContract axelaServiceContract = new AxelaServiceContract();
			LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
			if (!inputObj.isNull("contractId")) {
				contractId = CNumeric(PadQuotes(inputObj.getString("contractId")));
			}
			if (!contractId.equals("0")) {
				List<AxelaServiceContract> contract = contractFilterImpl.populateByContract(contractId, session);
				for (AxelaServiceContract results : contract) {
					map.put("contractId", String.valueOf(results.getContractId()));
					map.put("contractBranchId", String.valueOf(results.getContractBranchId()));
					map.put("contractContracttypeId", String.valueOf(results.getContractContracttypeId()));
					map.put("contractDate", "" + strToShortDate(results.getContractDate()));
					map.put("contractStartDate", "" + strToShortDate(results.getContractStartDate()));
					map.put("contractEndDate", "" + strToShortDate(results.getContractEndDate()));
					map.put("contractTitle", "" + results.getContractTitle());
					map.put("contractContactId", "" + results.getContractContactId());
					map.put("contractTicketqueueId", String.valueOf(results.getContractTicketqueueId()));
					map.put("contractAmt", String.valueOf(results.getContractAmt()));
					map.put("contractTaxId", String.valueOf(results.getContractTaxId()));
					map.put("contractDiscamt", String.valueOf(results.getContractDiscamt()));
					map.put("contractNetamt", String.valueOf(results.getContractNetamt()));
					map.put("contractGrandtotal", String.valueOf(results.getContractGrandtotal()));
					map.put("contractTax", String.valueOf(results.getContractTax()));
					map.put("contractBillAddress", String.valueOf(results.getContractBillAddress()));
					map.put("contractBillCity", "" + results.getContractBillCity());
					map.put("contractBillPin", "" + results.getContractBillPin());
					map.put("contractBillState", "" + results.getContractBillState());
					map.put("contractBillCountry", "" + results.getContractBillCountry());
					map.put("contractServiceAddress", "" + results.getContractServiceAddress());
					map.put("contractServiceCity", "" + results.getContractServiceCity());
					map.put("contractServicePin", "" + results.getContractServicePin());
					map.put("contractServiceState", "" + results.getContractServiceState());
					map.put("contractServiceCountry", "" + results.getContractServiceCountry());
					map.put("contractDesc", "" + results.getContractDesc());
					map.put("contractTerms", "" + results.getContractTerms());
					map.put("contractEmpId", String.valueOf(results.getContractEmpId()));
					map.put("contractPo", "" + results.getContractPo());
					map.put("contractPrioritycontractId", String.valueOf(results.getContractPrioritycontractId()));
					map.put("contractRefno", "" + results.getContractRefno());
					map.put("contractActive", "" + results.getContractActive());
					map.put("contractNotes", results.getContractNotes());
					map.put("contactTitleId", String.valueOf(results.getTitleId()));
					map.put("titleDesc", "" + results.getTitleDesc());
					map.put("contactFname", "" + results.getContactFname());
					map.put("contactLname", "" + String.valueOf(results.getContactLname()));
					map.put("contactMobile", "" + String.valueOf(results.getContactMobile1()));
					map.put("contactPhone1", "" + results.getContactPhone1());
					map.put("contactEmail1", "" + results.getContactEmail1());
					map.put("contactPin", "" + results.getContactPin());
					map.put("contractContactId", String.valueOf(results.getContactId()));
					map.put("contactCityId", String.valueOf(results.getContactCityId()));
					map.put("contactAddress", String.valueOf(results.getContactAddress()));
					map.put("contactCustomerId", String.valueOf(results.getCustomerId()));
					map.put("customerName", "" + results.getCustomerName());
					if (results.getContractEntryId() != 0) {
						map.put("contractEntryDate", strToShortDate(results.getContractEndDate()));
						map.put("contractEntryId", String.valueOf(results.getContractEntryId()));
						map.put("contractEntryBy", axelaEmpRepository.findByEmp(Integer.parseInt(String.valueOf(results.getContractEntryId()))));
					}
					if (results.getContractModifiedId() != 0) {
						map.put("contractModifiedDate", strToShortDate(results.getContractModifiedDate()));
						map.put("contractModifiedId", String.valueOf(results.getContractModifiedId()));
						map.put("contractModifiedBy", axelaEmpRepository.findByEmp(Integer.parseInt(String.valueOf(results.getContractModifiedId()))));
					}
					list.add(map);
				}
				output.put("populateData", list);
			}
		}
		return output;
	}
	public Map populateContractDetails(String input, HttpServletResponse response) throws JSONException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, String>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!inputObj.isNull("contractContactId")) {
			contractContactId = CNumeric(PadQuotes(inputObj.getString("contractContactId")));
		}
		if (!contractContactId.equals("0")) {
			for (Object[] contact : customerContactReposiitory.populateByContactDetails(Integer.parseInt((contractContactId)))) {
				HashMap<String, String> map = new HashMap<String, String>();
				// map.put("contractCustomerId", "" + contact[0]);
				// map.put("contractContactId", "" + contact[1]);
				map.put("customerName", "" + contact[2]);
				map.put("contactName", "" + contact[3]);
				// map.put("contactEmail1", "" + contact[4]);
				// map.put("contactMobile1", "" + contact[5]);
				list.add(map);
			}
			output.put("populateContractDetails", list);
		}
		return output;
	}

	public Map populateConfigDetails(String input, HttpServletResponse response) throws JSONException {
		List<Object[]> AxelaConfig = new ArrayList<Object[]>();
		output = new LinkedHashMap<String, String>();
		AxelaConfig = axelaConfigRepository.findByConfigServiceContractRefno(empId);
		for (Object[] config : AxelaConfig) {
			configServiceContractRefno = config[0] + "";
			configCustomerAddress = config[1] + "";
		}
		return output;
	}
	public void deleteFields(int contractId) {
		// association for Asset
		StrSql = CNumeric(PadQuotes(String.valueOf(serviceContractAssetRepository.findById(contractId))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with Asset!";
		}
		// association for Service
		StrSql = CNumeric(PadQuotes(String.valueOf(serviceContractServiceRepository.findById(contractId))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with Service!";
		}
		if (msg.equals("")) {
			int axelaServiceContractDoc = serviceContractDocRepository.findById(contractId);
			AxelaServiceContract axelaServiceContract = serviceContractRepository.findOne(contractId);
			if (axelaServiceContractDoc != 0) {
				serviceContractDocRepository.delete(axelaServiceContractDoc);
			}
			serviceContractRepository.delete(contractId);
			output.put("successmsg", "Contract Deleted Successfully!");
		}
		else {
			output.put("errormsg", msg);
			msg = "";
		}
	}

	public Map<String, String> populateLandingDetails(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap();
		String strSearch = "";
		long grandTotal = 0L;
		branchAccess = getSession("branchAccess", session).replaceAll("branchId", "contract.axelaBranch.BranchId");
		exeAccess = getSession("exeAccess", session).replaceAll("empId", "contract.axelaEmp.EmpId");
		if (!startTime.equals("")) {
			strSearch = " and substr(contract.contractEntryDate,1,8) >= substr('" + starttime + "',1,8) ";
		}
		if (!endTime.equals("")) {
			strSearch = strSearch + " and substr(contract.contractEntryDate,1,8) <= substr('" + endtime + "',1,8) ";
		}
		if (!drBranchId.equals("0")) {
			strSearch = strSearch + " and contract.axelaBranch.BranchId=" + drBranchId;
		}
		strSearch = strSearch + " and contract.axelaBranch.branchActive = '1' and contract.contractActive='1'";
		strSearch += branchAccess + exeAccess;
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> contract = serviceContractImpl.findBypopulateLanding(strSearch, session);
		for (Object[] results : contract) {
			LinkedHashMap map = new LinkedHashMap<String, String>();
			map.put("branchId", String.valueOf(results[0]));
			map.put("branchName", String.valueOf(results[1]));
			map.put("contractCount", Long.parseLong(String.valueOf(results[2])));
			grandTotal += Long.parseLong(String.valueOf(results[2]));
			list.add(map);
		}
		output.put("populateData", list);
		output.put("grandTotal", grandTotal);
		return output;
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		Date startDate = null;
		Date endDate = null;
		String jcTerm = "";
		page = 0;
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = CNumeric(PadQuotes(getSession("compId", session)));
		perPage = CNumeric(getSession("empRecperpage", session));
		configCustomerName = getSession("configCustomerName", session);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String strOrderBy = "";
		String strSearch = "";
		configCustomerName = getSession("configCustomerName", session);
		requestType = "";
		if (empId != 0) {
			if (!returnPerm("emp_contract_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			branchAccess = getSession("branchAccess", session).replaceAll("branchId", "contract.contractBranchId");
			empFormatdate = PadQuotes(getSession("formatdateName", session));
			exeAccess = getSession("exeAccess", session).replaceAll("exeAccess", "contract.contractEmpId");
			List<AxelaServiceContract> contractList = null;
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			PageRequest request = null;
			if (!inputObj.isNull("sortField")) {
				orderByField = PadQuotes((inputObj.getString("sortField")));
			}
			if (!inputObj.isNull("pageIndex")) {
				page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
			}
			if (!inputObj.isNull("group")) {
				group = CNumeric(PadQuotes((inputObj.getString("group"))));
			}
			if (!inputObj.isNull("sortDirection")) {
				orderType = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
			}
			if (!inputObj.isNull("contractId")) {
				contractId = PadQuotes((inputObj.getString("contractId")));
			}
			if (!inputObj.isNull("customerId")) {
				customerId = PadQuotes((inputObj.getString("customerId")));
			}
			perPage = "25";

			if (perPage.equals("0")) {
				perPage = "25";
			}
			if (orderType.equals("")) {
				orderType = "DESC";
			}
			if (!inputObj.isNull("requestType")) {
				requestType = PadQuotes((inputObj.getString("requestType")));
			}
			if (orderByField.equals("")) {
				orderByField = "contract.contractId";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			strOrderBy = " ORDER BY " + orderByField + " " + orderType + "";
			contractList = contractFilterImpl.findAll(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			totalCount = Integer.parseInt(contractFilterImpl.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData(configCustomerName + " ID", "contract.contractId", "center"));
			listHeader.add(produceHeaderData("No.", "contract.contractNo", "left"));
			listHeader.add(produceHeaderData("Contract", "contract.contractTitle", "left"));
			listHeader.add(produceHeaderData(configCustomerName, "customers.customerName", "left"));
			listHeader.add(produceHeaderData("Type", "type.contracttypeName", "left"));
			listHeader.add(produceHeaderData("Term", "contract.contractTerms", "left"));
			listHeader.add(produceHeaderData("Amount", "contract.contractAmt", "left"));
			listHeader.add(produceHeaderData("Executive", "emp.empId", "left"));
			listHeader.add(produceHeaderData("Branch", "branch.branchName", "left"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaServiceContract obj : contractList) {
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
				// ID
				type.add(false);
				value.add(obj.getContractId());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// contractNo
				type.add(false);
				value.add(obj.getContractno());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// contract
				type.add(false);
				value.add(obj.getContractTitle() + " ");
				if (!obj.getContractRefno().equals("") && configServiceContractRefno.equals("1")) {
					type.add(false);
					value.add("Ref. No.: " + (PadQuotes(obj.getContractRefno())));
				}
				if (obj.getContractActive().equals("0")) {
					type.add(false);
					value.add("<font color=red><br>[Inactive]</font>");
				}
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// client
				type.add(true);
				value.add(String.valueOf(obj.getCustomerName()));
				paramSubArr.add("customerList");
				paramSubArr.add(obj.getCustomerId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				paramSubArr.clear();
				type.add(true);
				value.add(String.valueOf(obj.getContactName()));
				paramSubArr.add("customerContactList");
				paramSubArr.add(obj.getContactId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				paramSubArr.clear();
				if (!obj.getContactMobile1().equals("")) {
					type.add(false);
					value.add(PadQuotes(String.valueOf(obj.getContactMobile1())));

				}
				if (!obj.getContactMobile2().equals("")) {
					type.add(false);
					value.add(PadQuotes(String.valueOf(obj.getContactMobile2())));
				}
				if (!obj.getContactEmail1().equals("")) {
					type.add(true);
					value.add(PadQuotes(String.valueOf(obj.getContactEmail1())));
				}
				if (!obj.getContactEmail2().equals("")) {
					type.add(true);
					value.add(PadQuotes(String.valueOf(obj.getContactEmail2())));
				}
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// Type
				type.add(false);
				value.add(obj.getContracttypeName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Term
				if (!obj.getContractStartDate().equals("")) {
					jcTerm = formatDate(strToShortDate(obj.getContractStartDate()), empFormatdate) + formatDate(strToShortDate(obj.getContractEndDate()), empFormatdate);
				}
				Date today = getTimeByZone(session);
				Date startdate = obj.getContractStartDate();
				Date enddate = obj.getContractEndDate();
				if (startdate.after(today)) {
					jcTerm = jcTerm + "<br><font color=blue>[Future Contract]</font>";
				} else if (enddate.before(today)) {
					jcTerm = jcTerm + "<br><font color=red>[Expired Contract]</font>";
				}
				type.add(false);
				value.add(jcTerm);
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Amount
				type.add(false);
				value.add("Net Total: " + PadQuotes(IndDecimalFormat(dF.format(obj.getContractAmt()))));
				if (!String.valueOf(obj.getContractTax()).equals("0")) {
					type.add(false);
					value.add("<b>Service Tax: " + PadQuotes(IndDecimalFormat(dF.format(((obj.getContractTax()))))) + "</b>");
				}
				type.add(false);
				value.add("<b>Total: " + PadQuotes(IndDecimalFormat(dF.format(obj.getContractGrandtotal()))) + "</b>");
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Executive
				type.add(false);
				value.add(ExePhotoOval(obj.getEmpId() + ""));
				paramArr.add((ArrayList) paramSubArr.clone());
				type.add(true);
				value.add(obj.getEmpName());
				paramSubArr.add("executiveSummary");
				paramSubArr.add(obj.getEmpId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// Branch
				type.add(true);
				value.add(obj.getAssetBranchName());
				paramSubArr.add("branchSummary");
				paramSubArr.add(obj.getAssetBranchId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();

				// End Body Data
				mapData.put("td", listData);
				ArrayList<String> actionParam = new ArrayList<String>();
				ArrayList<String> actionParam1 = new ArrayList<String>();
				ArrayList<String> actionParam2 = new ArrayList<String>();
				ArrayList<String> actionParam3 = new ArrayList<String>();
				actionParam.add("updateContract");
				actionParam.add(PadQuotes(String.valueOf(obj.getContractId())));
				actionParam1.add("listDocument");
				actionParam1.add(PadQuotes(String.valueOf(obj.getContractId())));
				actionParam2.add("listAsset");
				actionParam2.add(PadQuotes(String.valueOf(obj.getContractId())));
				actionParam2.add(PadQuotes(String.valueOf(obj.getContractCustomerId())));
				actionParam3.add("listTicket");
				actionParam3.add(PadQuotes(String.valueOf(obj.getContractId())));
				actionParam3.add(PadQuotes(String.valueOf(obj.getCustomerId())));
				actionParam3.add(PadQuotes(String.valueOf(obj.getContactId())));
				actionParam3.add(PadQuotes(String.valueOf(obj.getContractTicketqueueId())));
				mapAction.put("td", produceActionData(actionParam, actionParam1, actionParam2, actionParam3));
				listAction.add(mapAction);
				listBody.add(mapData);
			}
			output.put("meta", mapNavi);
			output.put("thead", listHeader);
			output.put("tdalign", listBodyAlign);
			output.put("tbody", listBody);
			output.put("action", listAction);
			if (AppRun().equals("0")) {
				SOP("output==========ContractService==========" + output.toString());
			}
		}
		return output;
	}
	private ArrayList<HashMap> produceActionData(ArrayList<String> Param, ArrayList<String> Param1, ArrayList<String> Param2, ArrayList<String> Param3) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Contract");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "List Document");
		mapBodyData.put("param", Param1);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "List Asset");
		mapBodyData.put("param", Param2);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "List Ticket");
		mapBodyData.put("param", Param3);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart(HttpSession session) {
		String customerName = getSession("configCustomerName", session);
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "contract.*"));
		list.add(buildSmartArr("Contract ID", "numeric", "contract.contractId"));
		list.add(buildSmartArr("Type Name", "text", "contract.contracttypeName"));
		list.add(buildSmartArr("Contract No", "text", "CONCAT('CONT', branch.branchCode,contract.contractNo)"));
		list.add(buildSmartArr("Contract Date", "date", "contract.contractDate"));
		list.add(buildSmartArr("Branch Name", "text", "CONCAT(branch.branchName, ' (', branch.branchCode, ')')"));
		list.add(buildSmartArr(customerName + "ID", "numeric", "customers.customerId"));
		list.add(buildSmartArr(customerName + "Customer Name", "text", "customers.customerName"));
		list.add(buildSmartArr("Contract Start Date", "date", "contract.contractStartDate"));
		list.add(buildSmartArr("Contact Name", "text", "CONCAT(title.titleDesc, ' ',contact.contactFname, ' ', contact.contactLname)"));
		list.add(buildSmartArr("Contact Mobile", "text", "CONCAT(REPLACE(contact.contactMobile1, '-', ''), REPLACE(contact.contactMobile2, '-', ''))"));
		list.add(buildSmartArr("Contact Email", "text", "CONCAT(contact.contactEmail1, contact.contactEmail2)"));
		list.add(buildSmartArr("Contract End Date", "date", "contract.contractEndDate"));
		list.add(buildSmartArr("Title", "text", "COALESCE(contract.contractTitle,'')"));
		list.add(buildSmartArr("Billing Address", "text", "contract.contractBillAddress"));
		list.add(buildSmartArr("Billing City", "text", "contract.contractBillCity"));
		list.add(buildSmartArr("Billing Pin", "text", "contract.contractBillPin"));
		list.add(buildSmartArr("Billing State", "text", "contract.contractBillState"));
		list.add(buildSmartArr("Billing Country", "text", "contract.contractBillCountry"));
		list.add(buildSmartArr("Service Address", "text", "contract.contractServiceAddress"));
		list.add(buildSmartArr("Service City", "text", "contract.contractServiceCity"));
		list.add(buildSmartArr("Service Pin", "text", "contract.contractServicePin"));
		list.add(buildSmartArr("Service State", "text", "contract.contractServiceState"));
		list.add(buildSmartArr("Service Country", "text", "contract.contractServiceCountry"));
		list.add(buildSmartArr("Description", "text", "contract.contractDesc"));
		list.add(buildSmartArr("Terms", "text", "contract.contractTerms"));
		list.add(buildSmartArr("Executive", "text", "COALESCE(CONCAT(emp.empName, ' (', emp.empRefNo, ')'))"));
		list.add(buildSmartArr("Reference No", "text", "contract.contractRefno"));
		list.add(buildSmartArr("Active", "boolean", "contract.contractActive"));
		list.add(buildSmartArr("Notes", "text", "contract.contractNotes"));
		// list.add(buildSmartArr("Entry By", "text", "contract.contractEntryId"));
		list.add(buildSmartArr("Entry Date", "date", "contract.contractEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "contract.contractModifiedId"));
		list.add(buildSmartArr("Modified Date", "date", "contract.contractModifiedDate"));
		// list.add((buildSmartArr("Custom Fields", "text", "contract_id IN (SELECT cftrans_row_id FROM compdb.axela_cf_trans WHERE cftrans_submodule_id = 14 and cftrans_value"));
		output.put("drSmart", list.toArray());
		return output;
	}
}
