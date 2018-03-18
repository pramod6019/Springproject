package axela.customer.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.springframework.stereotype.Service;

import axela.accounting.repository.AccVoucherRepository;
import axela.config.Connect;
import axela.customer.model.AxelaCustomer;
import axela.customer.model.AxelaCustomerGroupTran;
import axela.customer.repository.CustomerContactReposiitory;
import axela.customer.repository.CustomerFilterImpl;
import axela.customer.repository.CustomerGroupTranRepo;
import axela.customer.repository.CustomerRepository;
import axela.helpdesk.repository.HelpDeskTicketRepository;
import axela.portal.model.AxelaCustomerItstatus;
import axela.portal.repository.AssetInsuranceRepository;
import axela.portal.repository.AxelaCityRepository;
import axela.portal.repository.AxelaCountryRepository;
import axela.portal.repository.AxelaCustomerGroupRepository;
import axela.portal.repository.AxelaCustomerItstatusRepository;
import axela.portal.repository.AxelaSobRepository;
import axela.portal.repository.AxelaSoeRepository;
import axela.portal.repository.AxelaStateRepository;
import axela.portal.repository.BranchRepository;
import axela.portal.repository.CustomerDocsRepository;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.InventoryPoDataRepository;
import axela.portal.repository.PmRepository;
import axela.sales.repository.OpprRepository;
import axela.service.repository.AssetRepository;
import axela.service.repository.ServiceContractRepository;

@Service
public class CustomerService extends Connect {

	public String customerId = "0";
	public String customerName = "";
	public String customerCode = "";
	public String customerMobile1 = "";
	public String customerMobile2 = "";
	public String customerPhone1 = "";
	public String customerPhone2 = "";
	public String customerPhone3 = "";
	public String customerPhone4 = "";
	public String customerFax1 = "";
	public String customerFax2 = "";
	public String customerEmail1 = "";
	public String customerEmail2 = "";
	public String customerWebsite1 = "";
	public String customerWebsite2 = "";
	public String customerGstNo = "";
	public String customerGstRegdate = "";
	public String customerGstDocValue = "";
	public String customerArnNo = "";
	public String customerItstatusId = "0";
	public String itstatusId = "0";
	public String customerAddress1 = "";
	public String customerAddress2 = "";
	public String configCustomerAddress = "";
	public String customerCityId = "0";
	public String customerPin = "";
	public String customerLandmark = "";
	public String customerTds = "0";
	public String customerPanNo = "";
	public String customerTinNo = "";
	public String customerServiceTaxNo = "";
	public String customerCreditLimit = "0.00";
	public String customerPaydaysId = "0";
	public String customerDiscPerc = "0.00";
	public String customerSoeId = "0";
	public String customerEmpcountId = "0";
	public String customerRateclassId = "0";
	public String customerReconciliation = "";
	public String customerEmpId = "0";
	public String customerTax = "";
	public String customerSince = "";
	public String customerActive = "0";
	public String customerTypeId = "0";
	public String customerNotes = "";
	public String entryBy = "0";
	public String customerUserEntryDate = "";
	public String customerUserModifiedDate = "";
	public String entryDate = "";
	public String modifiedBy = "0";
	public String modifiedDate = "";
	public String configCustomerDupnames = "0";
	public String configCustomerSoe = "0";
	public String configCustomerSob = "0";
	public String compModuleAccounting = "0";
	public String empRoleId = "0";
	public String tag = "";
	public String requestType = "";
	public String msg = "";
	public int page = 0;
	public String perPage = "0";
	public String orderType = "";
	public int empId = 0;
	public int compId = 0;
	public String orderByField = "";
	// configuration
	public String configSalesOpprName = "";
	public String configCustomerName = "";
	public String branchId = "0";
	public String branchAccess = "";
	public String ExeAccess = "";
	public String empFormatDate = "";
	public String keyword = "", value = "";
	public int customerBranchId = 0;
	public JSONArray customerGroupId;
	public String customerGroupIds[] = null;
	private String exeAccess;
	public String length = "";
	public String strSearch = "";
	public String StrSql = "";
	// landing
	public String branchIds = "";
	public String startDate = "";
	public String endDate = "";
	public String empFormatdate = "";

	LinkedHashMap output = null;
	JSONObject inputObj = null;

	@Autowired
	CustomerFilterImpl customerFilterImpl;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerGroupTranRepo customerGroupTranRepo;

	@Autowired
	private AxelaCustomerGroupRepository axelaCustomerGroupRepository;

	@Autowired
	private AssetRepository assetRepository;

	@Autowired
	private InventoryPoDataRepository inventoryPoDataRepository;

	@Autowired
	private HelpDeskTicketRepository serviceTicketRepository;

	@Autowired
	private CustomerDocsRepository customerDocsRepository;

	@Autowired
	private AssetInsuranceRepository assetInsuranceRepository;

	@Autowired
	private ServiceContractRepository serviceContractRepository;

	@Autowired
	private AccVoucherRepository accVoucherRepository;

	@Autowired
	private PmRepository pmRepository;

	@Autowired
	private OpprRepository opprRepository;

	@Autowired
	private CustomerContactReposiitory customerContactReposiitory;

	@Autowired
	private CustomerFilterImpl customerFilter;

	@Autowired
	private EmpRepository empRepository;

	@Autowired
	private AxelaCustomerItstatusRepository axelaCustomerItstatusRepository;

	@Autowired
	private AxelaCityRepository axelaCityRepository;

	@Autowired
	private AxelaStateRepository axelaStateRepository;

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private AxelaSoeRepository axelaSoeRepository;

	@Autowired
	private AxelaSobRepository axelaSobRepository;

	@Autowired
	private AxelaCountryRepository axelaCountryRepository;

	public Map customerService(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, NumberFormatException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		branchAccess = PadQuotes(getSession("branchAccess", session)).replaceAll("branchId", "customer.customerBranchId");
		exeAccess = PadQuotes(getSession("exeAccess", session)).replaceAll("empId", "customer.customerEmpId");
		configSalesOpprName = PadQuotes(getSession("configSalesOpprName", session));
		configCustomerName = PadQuotes(getSession("configCustomerName", session));
		branchId = CNumeric(PadQuotes(getSession("empBranchId", session)));
		compModuleAccounting = CNumeric(PadQuotes(getSession("compModuleAccounting", session)));
		empFormatDate = PadQuotes(getSession("formatdateDatepicker", session));

		inputObj = new JSONObject(input);
		if (empId != 0) {
			output = new LinkedHashMap();
			if (!returnPerm("emp_customer_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			tag = PadQuotes(getSession("configCustomerName", session));
			requestType = "";

			populateConfigDetails(session);
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			switch (requestType) {
				case "add" : // add an customer.
					if (!returnPerm("emp_customer_add", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					customerId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "update" :// update an customer.
					if (!returnPerm("emp_customer_edit", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					customerId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "delete" :// delete an customer.
					if (!returnPerm("emp_customer_delete", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					if (!inputObj.isNull("customerId")) {
						customerId = CNumeric(PadQuotes(inputObj.getString("customerId")));
					}
					if (!inputObj.isNull("tag")) {
						tag = PadQuotes(inputObj.getString("tag"));
					}
					if (!customerId.equals("0")) {
						deleteFields(customerId);
					}
					break;

				case "landing" :
					if (!inputObj.isNull("startDate")) {
						startDate = PadQuotes(inputObj.getString("startDate"));
					}
					if (!inputObj.isNull("endDate")) {
						endDate = PadQuotes(inputObj.getString("endDate"));
					}

					if (!branchId.equals("0")) {
						branchId = PadQuotes(inputObj.getString("branchId"));
					}
					populateLandingDetails(input, session, response);
					break;

			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("customerId")) {
			customerId = CNumeric(inputObj.getString("customerId"));
		}
		if (!inputObj.isNull("customerName")) {
			customerName = PadQuotes(inputObj.getString("customerName"));
		}
		if (!inputObj.isNull("customerCode")) {
			customerCode = PadQuotes(inputObj.getString("customerCode"));
		}
		if (!inputObj.isNull("customerBranchId")) {
			customerBranchId = Integer.parseInt(CNumeric(inputObj.getString("customerBranchId")));
		}
		if (!inputObj.isNull("customerGroupId")) {
			if (inputObj.get("customerGroupId") instanceof JSONArray)
				customerGroupId = inputObj.getJSONArray("customerGroupId");
		}
		if (!inputObj.isNull("customerMobile1")) {
			customerMobile1 = PadQuotes(inputObj.getString("customerMobile1"));
		}
		if (!inputObj.isNull("customerMobile2")) {
			customerMobile2 = PadQuotes(inputObj.getString("customerMobile2"));
		}
		if (!inputObj.isNull("customerPhone1")) {
			customerPhone1 = PadQuotes(inputObj.getString("customerPhone1"));
		}
		if (!inputObj.isNull("customerPhone2")) {
			customerPhone2 = PadQuotes(inputObj.getString("customerPhone2"));
		}
		if (!inputObj.isNull("customerPhone3")) {
			customerPhone3 = PadQuotes(inputObj.getString("customerPhone3"));
		}
		if (!inputObj.isNull("customerPhone4")) {
			customerPhone4 = PadQuotes(inputObj.getString("customerPhone4"));
		}
		if (!inputObj.isNull("customerFax1")) {
			customerFax1 = PadQuotes(inputObj.getString("customerFax1"));
		}
		if (!inputObj.isNull("customerFax2")) {
			customerFax2 = PadQuotes(inputObj.getString("customerFax2"));
		}
		if (!inputObj.isNull("customerEmail1")) {
			customerEmail1 = PadQuotes(inputObj.getString("customerEmail1"));
		}
		if (!inputObj.isNull("customerEmail2")) {
			customerEmail2 = PadQuotes(inputObj.getString("customerEmail2"));
		}
		if (!inputObj.isNull("customerWebsite1")) {
			customerWebsite1 = PadQuotes(inputObj.getString("customerWebsite1"));
		}
		if (!inputObj.isNull("customerWebsite2")) {
			customerWebsite2 = PadQuotes(inputObj.getString("customerWebsite2"));
		}
		if (!inputObj.isNull("customerGstNo")) {
			customerGstNo = inputObj.getString("customerGstNo");
		}
		if (!inputObj.isNull("customerGstRegdate")) {
			customerGstRegdate = (PadQuotes(inputObj.getString("customerGstRegdate")));
		}
		if (!inputObj.isNull("customerArnNo")) {
			customerArnNo = PadQuotes(inputObj.getString("customerArnNo"));
		}
		if (!inputObj.isNull("customerItstatusId")) {
			customerItstatusId = CNumeric(PadQuotes(inputObj.getString("customerItstatusId")));
		}
		if (!inputObj.isNull("itstatusId")) {
			itstatusId = CNumeric(inputObj.getString("itstatusId"));
		}
		if (!inputObj.isNull("customerAddress1")) {
			customerAddress1 = PadQuotes(inputObj.getString("customerAddress1"));
		}
		if (!inputObj.isNull("customerAddress2")) {
			customerAddress2 = PadQuotes(inputObj.getString("customerAddress2"));
		}
		if (!inputObj.isNull("customerCityId")) {
			customerCityId = CNumeric(inputObj.getString("customerCityId"));
		}
		if (!inputObj.isNull("customerPin")) {
			customerPin = PadQuotes(inputObj.getString("customerPin"));
		}
		if (!inputObj.isNull("customerLandmark")) {
			customerLandmark = PadQuotes(inputObj.getString("customerLandmark"));
		}
		if (!inputObj.isNull("customerTds")) {
			customerTds = CNumeric(inputObj.getString("customerTds"));
		}
		if (!inputObj.isNull("customerPanNo")) {
			customerPanNo = PadQuotes(inputObj.getString("customerPanNo"));
		}
		if (!inputObj.isNull("customerTinNo")) {
			customerTinNo = CNumeric(inputObj.getString("customerTinNo"));
		}
		if (!inputObj.isNull("customerServiceTaxNo")) {
			customerServiceTaxNo = CNumeric(inputObj.getString("customerServiceTaxNo"));
		}
		if (!inputObj.isNull("customerCreditLimit")) {
			customerCreditLimit = CNumeric(inputObj.getString("customerCreditLimit"));
		}
		if (!inputObj.isNull("customerPaydaysId")) {
			customerPaydaysId = CNumeric(inputObj.getString("customerPaydaysId"));
		}
		if (!inputObj.isNull("customerDiscPerc")) {
			customerDiscPerc = CNumeric(inputObj.getString("customerDiscPerc"));
		}
		if (!inputObj.isNull("customerSoeId")) {
			customerSoeId = CNumeric(inputObj.getString("customerSoeId"));
		}
		if (!inputObj.isNull("customerSoeId")) {
			customerSoeId = CNumeric(inputObj.getString("customerSoeId"));
		}
		if (!inputObj.isNull("customerEmpcountId")) {
			customerEmpcountId = CNumeric(inputObj.getString("customerEmpcountId"));
		}
		if (!inputObj.isNull("customerRateclassId")) {
			customerRateclassId = CNumeric(inputObj.getString("customerRateclassId"));
		}
		if (!inputObj.isNull("customerEmpId")) {
			customerEmpId = CNumeric(inputObj.getString("customerEmpId"));
		}
		if (!inputObj.isNull("customerSince")) {
			customerSince = PadQuotes(inputObj.getString("customerSince"));
		}
		if (!inputObj.isNull("customerActive")) {
			customerActive = inputObj.getString("customerActive");
		}
		if (!inputObj.isNull("customerType")) {
			customerTypeId = CNumeric(inputObj.getString("customerType"));
		}
		if (!inputObj.isNull("customerNotes")) {
			customerNotes = PadQuotes(inputObj.getString("customerNotes"));
		}
		if (customerNotes.length() > 5000) {
			customerNotes = customerNotes.substring(0, 4999);
		}
		if (!inputObj.isNull("tag")) {
			tag = PadQuotes(inputObj.getString("tag"));
		}
		if (!inputObj.isNull("configCustomerAddress")) {
			configCustomerAddress = PadQuotes(inputObj.getString("configCustomerAddress"));
		}
		if (!inputObj.isNull("configCustomerDupnames")) {
			configCustomerDupnames = CNumeric(inputObj.getString("configCustomerDupnames"));
		}
		if (!inputObj.isNull("configCustomerSoe")) {
			configCustomerSoe = CNumeric(inputObj.getString("configCustomerSoe"));
		}
		if (!inputObj.isNull("configCustomerSob")) {
			configCustomerSob = CNumeric(inputObj.getString("configCustomerSob"));
		}
		if (!inputObj.isNull("compModuleAccounting")) {
			compModuleAccounting = CNumeric(inputObj.getString("compModuleAccounting"));
		}
		if (!inputObj.isNull("empRoleId")) {
			empRoleId = CNumeric(inputObj.getString("empRoleId"));
		}

	}
	public void validateFields() {

		String axelaCustomer = "";
		if (customerName.equals("")) {
			msg += "Enter " + tag + " Name!";
		} else {
			if (requestType.equals("add") && configCustomerDupnames.equals("0")) {
				axelaCustomer = customerRepository.findByCustomerName(customerName);
			} else if (requestType.equals("update") && configCustomerDupnames.equals("0")) {
				axelaCustomer = customerRepository.findByNameAndId(Integer.parseInt(customerId), customerName);
			}
			if (!axelaCustomer.isEmpty()) {
				msg += "Similar " + tag + " Found!";
			}
		}

		if (!customerCode.equals("")) {
			if (!requestType.equals("update")) {
				axelaCustomer = PadQuotes(customerRepository.findByCustomerCode(customerCode));

				if (!axelaCustomer.equals("")) {
					if (axelaCustomer.equals(customerCode)) {
						msg += "<br>Similar " + tag + " Code found!";
					}
				}
			}

		}
		if (customerMobile1.equals("") && customerPhone1.equals("")) {
			msg += "<br>Enter Either Mobile 1 or Phone 1!";
		}
		if (!customerMobile1.equals("") && !IsValidMobileNo(customerMobile1)) {
			msg += "<br>Mobile1 is Invalid!";
		}
		if (!customerMobile2.equals("") && !IsValidMobileNo(customerMobile2)) {
			msg += "<br>Mobile2 is Invalid!";
		}
		if (!customerMobile1.equals("")
				&& !customerMobile2.equals("")
				&& customerMobile1.equals(customerMobile2)) {
			msg += "<br>Mobile2 is same as Mobile1!";
		}
		if (!customerPhone1.equals("")) {
			if (!IsValidPhoneNo(customerPhone1)) {
				msg += "<br>Enter valid Phone1!";
			}
		}
		if (!customerPhone2.equals("")) {
			if (!IsValidPhoneNo(customerPhone2)) {
				msg += "<br>Enter valid Phone2!";
			}
		}
		if (!customerPhone3.equals("") && !IsValidPhoneNo(customerPhone3)) {
			msg += "<br>Enter valid Phone3!";
		}

		if (!customerPhone4.equals("") && !IsValidPhoneNo(customerPhone4)) {
			msg += "<br>Enter valid Phone4!";
		}
		if (!customerPhone1.equals("")
				&& !customerPhone2.equals("")
				&& customerPhone1.equals(customerPhone2)) {
			msg += "<br>Phone2 is same as Phone1!";
		}

		if (!customerPhone1.equals("")
				&& !customerPhone3.equals("")
				&& customerPhone1.equals(customerPhone3)) {
			msg += "<br>Phone3 is same as Phone1!";
		}
		if (!customerPhone1.equals("")
				&& !customerPhone4.equals("")
				&& customerPhone1.equals(customerPhone4)) {
			msg += "<br>Phone4 is same as Phone1!";
		}
		if (!customerPhone2.equals("")
				&& !customerPhone3.equals("")
				&& customerPhone2.equals(customerPhone3)) {
			msg += "<br>Phone3 is same as Phone2!";
		}
		if (!customerPhone2.equals("")
				&& !customerPhone4.equals("")
				&& customerPhone2.equals(customerPhone4)) {
			msg += "<br>Phone4 is same as Phone2!";
		}
		if (!customerPhone3.equals("")
				&& !customerPhone4.equals("")
				&& customerPhone3.equals(customerPhone4)) {
			msg += "<br>Phone4 is same as Phone3!";
		}
		if (!customerEmail1.equals("")) {
			if (!IsValidEmail(customerEmail1)) {
				msg += "<br>Email 1 is invalid!";
			} else {
				customerEmail1 = customerEmail1.toLowerCase();
			}
		}
		if (!customerEmail2.equals("")) {
			if (!IsValidEmail(customerEmail2)) {
				msg += "<br>Email 2 is invalid!";
			} else {
				customerEmail2 = customerEmail2.toLowerCase();
			}
		}
		if (!customerEmail1.equals("")
				&& !customerEmail2.equals("")
				&& customerEmail2.equals(customerEmail1)) {
			msg += "<br>Email2 is same as Email1!";
		}
		if (!customerWebsite1.equals("")) {
			customerWebsite1 = WebValidate(customerWebsite1);
		}
		if (!customerWebsite2.equals("")) {
			customerWebsite2 = WebValidate(customerWebsite2);
		}
		if (!customerWebsite1.equals("") && !customerWebsite2.equals("") && customerWebsite2.equals(customerWebsite1)) {
			msg += "<br>Website 2 is same as Website 1!";
		}
		if (!customerGstNo.equals("") && !customerGstNo.matches("\\d{2}[a-zA-Z]{5}\\d{4}[a-zA-Z]{1}[a-zA-Z0-9]{3}")) {
			msg = msg + "<br>Enter Valid GST No !";
		}
		if (!customerGstRegdate.equals("") && !isValidDateFormatShort(customerGstRegdate)) {
			msg = msg + "<br>Enter Valid GST Date!";
		}
		if (!customerSince.equals("") && !isValidDateFormatShort(customerSince)) {
			msg = msg + "<br>Enter Valid Client Since Date!";
		}
		if (!customerArnNo.equals("") && !customerArnNo.matches("[a-zA-Z]{2}\\d{6}\\d{6}")) {
			msg = msg + "<br>Enter Valid ARN No !";

		}
		if (customerItstatusId.equals("0")) {
			msg = msg + "<br>Select Status!";
		}

		if (configCustomerAddress.equals("1")) {
			if (customerAddress1.equals("")) {
				msg += "<br>Enter Address!";
			}
		}
		if (customerCityId.equals("0")) {
			msg += "<br>Select City!";
		}
		if (customerPin.equals("") && configCustomerAddress.equals("1")) {
			msg += "<br>Enter Pin Code!";
		} else if (!customerPin.equals("") && !isNumeric(customerPin)) {
			msg += "<br>Pin Code: Enter Numeric!";
		}
		if (!customerTds.equals("0")) {
			if (customerPanNo.equals("")) {
				msg = msg + "<br>Enter Pan Number!";
			}
			else if (!customerPanNo.equals("") && !customerPanNo.matches("[A-Z]{5}\\d{4}[A-Z]{1}")) {
				msg = msg + "<br>Pan Number Invalid!";
			}
		}
		if (configCustomerSoe.equals("1") && customerSoeId.equals("0")) {
			msg += "<br>Select Source of Enquiry!";
		}
		if (configCustomerSob.equals("1") && customerSoeId.equals("0")) {
			msg += "<br>Select Source of Business!";
		}
		if (customerTypeId.equals("0")) {
			msg += "<br>Select Type!";
		}
		if (compModuleAccounting.equals("1")) {
			if (customerPaydaysId.equals("0")) {
				msg += "<br>Select Payment Days!";
			}

			if (Double.parseDouble(customerDiscPerc) > 99.00) {
				msg += "<br>Discount Percentage can't be greater than 99.00!";
			}
		}
		if (customerEmpId.equals("0")) {
			msg += "<br>Select Executive!";
		}

		if (!customerEmail1.equals("")) {
			customerEmail1 = customerEmail1.toLowerCase();
		}

		if (!customerEmail2.equals("")) {
			customerEmail2 = customerEmail2.toLowerCase();
		}
	}

	public void addFields(HttpServletResponse response) throws NumberFormatException, JSONException, ParseException {
		int entryId = 0;
		validateFields();
		AxelaCustomer axelaCustomer = null;
		if (msg.equals("")) {
			if (!customerId.equals("0")) {
				axelaCustomer = customerRepository.findOne(Integer.parseInt(customerId));
			} else {
				axelaCustomer = new AxelaCustomer();
			}
			axelaCustomer.setCustomerName(customerName);
			axelaCustomer.setCustomerCode(customerCode);
			axelaCustomer.setCustomerMobile1(customerMobile1);
			axelaCustomer.setCustomerMobile2(customerMobile2);
			axelaCustomer.setCustomerPhone1(customerPhone1);
			axelaCustomer.setCustomerPhone2(customerPhone2);
			axelaCustomer.setCustomerPhone3(customerPhone3);
			axelaCustomer.setCustomerPhone4(customerPhone4);
			axelaCustomer.setCustomerFax1(customerFax1);
			axelaCustomer.setCustomerFax2(customerFax2);
			axelaCustomer.setCustomerEmail1(customerEmail1);
			axelaCustomer.setCustomerEmail2(customerEmail2);
			axelaCustomer.setCustomerWebsite1(customerWebsite1);
			axelaCustomer.setCustomerWebsite2(customerWebsite2);
			axelaCustomer.setCustomerGstNo(customerGstNo);
			axelaCustomer.setCustomerGstRegdate(stringToDate(customerGstRegdate));
			axelaCustomer.setCustomerGstDocValue(customerGstDocValue);
			axelaCustomer.setCustomerArnNo(customerArnNo);
			axelaCustomer.setCustomerItstatusId(customerItstatusId);
			axelaCustomer.setCustomerAddress1(customerAddress1);
			axelaCustomer.setCustomerAddress2(customerAddress2);
			axelaCustomer.setCustomerCityId(Integer.parseInt(customerCityId));
			axelaCustomer.setCustomerPin(customerPin);
			axelaCustomer.setCustomerLandmark(customerLandmark);
			axelaCustomer.setCustomerTds(customerTds);
			axelaCustomer.setCustomerPanNo(customerPanNo);
			axelaCustomer.setCustomerTinNo(customerTinNo);
			axelaCustomer.setCustomerServiceTaxNo(customerServiceTaxNo);
			axelaCustomer.setCustomerCreditLimit(Double.parseDouble(customerCreditLimit));
			axelaCustomer.setCustomerPaydaysId(Integer.parseInt(customerPaydaysId));
			axelaCustomer.setCustomerDiscPerc(Double.parseDouble(customerDiscPerc));
			axelaCustomer.setCustomerSoeId(Integer.parseInt(customerSoeId));
			axelaCustomer.setCustomerSobId(Integer.parseInt(customerSoeId));
			axelaCustomer.setCustomerEmpcountId(Integer.parseInt(customerEmpcountId));
			axelaCustomer.setCustomerRateclassId(Integer.parseInt(customerRateclassId));
			axelaCustomer.setCustomerReconciliation(customerReconciliation);
			axelaCustomer.setCustomerEmpId(Short.parseShort(customerEmpId));
			axelaCustomer.setCustomerTax(customerTax);
			axelaCustomer.setCustomerSince(stringToDate(customerSince));
			axelaCustomer.setCustomerActive(customerActive);
			axelaCustomer.setCustomerType(Integer.parseInt(customerTypeId));
			axelaCustomer.setCustomerUserEntryDate(stringToDate(""));
			axelaCustomer.setCustomerUserModifiedDate(stringToDate(""));
			axelaCustomer.setCustomerBranchId(customerBranchId);
			if (customerTypeId.equals("1")) {
				axelaCustomer.setCustomerAccgroupId(32);
			}
			else if (customerTypeId.equals("2")) {
				axelaCustomer.setCustomerAccgroupId(31);
			}
			axelaCustomer.setCustomerNotes(customerNotes);
			if (requestType.equals("add") && customerId.equals("0")) {
				axelaCustomer.setCustomerEntryId((empId));
				axelaCustomer.setCustomerEntryDate(kknow());
			} else if (requestType.equals("update") && !customerId.equals("0")) {
				axelaCustomer.setCustomerModifiedId(empId);
				axelaCustomer.setCustomerModifiedDate(kknow());
			}
			customerId = CNumeric(customerRepository.save(axelaCustomer).getCustomerId() + "");
			if (!customerId.equals("0")) { // if id = 0 -> add mode else update mode
				if (requestType.equals("update")) {
					customerGroupTranRepo.deleteByCustomer(Integer.parseInt(customerId));
				}
				if (customerGroupId.length() > 0) {
					for (int i = 0; i < customerGroupId.length(); i++) {
						AxelaCustomerGroupTran axelaCustomerGroupTran = new AxelaCustomerGroupTran();
						axelaCustomerGroupTran.setTransCustomerId(Integer.parseInt(customerId));
						axelaCustomerGroupTran.setTransTransgroupId(Integer.valueOf(customerGroupId.get(i) + ""));
						customerGroupTranRepo.save(axelaCustomerGroupTran);
					}
				}
			}
			if (!customerId.equals("0") && requestType.equals("add")) {
				output.put("customerId", customerId);
				if (customerTypeId.equals("1")) {
					output.put("successmsg", "Added Successfully!");
				} else if (customerTypeId.equals("2")) {
					output.put("successmsg", "Added Successfully!");
				}
			} else if (!customerId.equals("0") && requestType.equals("update")) {
				output.put("customerId", customerId);
				if (customerTypeId.equals("1")) {
					output.put("successmsg", "Updated Successfully!");
				} else if (customerTypeId.equals("2")) {
					output.put("successmsg", "Updated Successfully!");
				}
			}
		} else {
			output.put("errormsg", msg);
		}
	}
	public void deleteFields(String customerId) {
		// check for contacts
		StrSql = CNumeric(PadQuotes(String.valueOf(customerContactReposiitory.findById(Integer.parseInt(customerId)))));
		if (StrSql.equals(customerId)) {
			msg += "<br>" + tag + " is associated with Contact!";
		}
		// check for project
		StrSql = CNumeric(PadQuotes(pmRepository.findById(Integer.parseInt(customerId))));
		if (StrSql.equals(customerId)) {
			msg += "<br>" + tag + " is associated with Project!";
		}
		// check for sales
		StrSql = CNumeric(PadQuotes(String.valueOf(opprRepository.findByCustomerId(Integer.parseInt(customerId)))));
		if (StrSql.equals(customerId)) {
			msg += "<br>" + tag + " is associated with " + configSalesOpprName + "!";
		}
		// / Check voucher
		StrSql = CNumeric(PadQuotes(String.valueOf(accVoucherRepository.findById(Integer.parseInt(customerId)))));
		if (StrSql.equals(customerId)) {
			msg += "<br>" + tag + " is associated with Voucher!";
		}
		// check for tickets
		StrSql = CNumeric(PadQuotes(String.valueOf(serviceContractRepository.findById(Integer.parseInt(customerId)))));
		if (StrSql.equals(customerId)) {
			msg += "<br>" + tag + " is associated with Contract!";
		}
		StrSql = CNumeric(PadQuotes(String.valueOf(serviceTicketRepository.findById(Integer.parseInt(customerId)))));
		if (StrSql.equals(customerId)) {
			msg += "<br>" + tag + " is associated with Ticket!";
		}
		// StrSql = CNumeric(PadQuotes(String.valueOf(assetInsuranceRepository.findById(Integer.parseInt(customerId)))));
		// if (StrSql.equals(customerId)) {
		// msg += "<br>" + tag + " is associated with Insurance!";
		// }
		StrSql = CNumeric(PadQuotes(String.valueOf(inventoryPoDataRepository.findById(Integer.parseInt(customerId)))));
		if (StrSql.equals(customerId)) {
			msg += "<br>" + tag + " is associated with PO Data!";
		}
		// StrSql = CNumeric(PadQuotes(String.valueOf(assetRepository.findById(Integer.parseInt(customerId)))));
		// if (StrSql.equals(customerId)) {
		// msg += "<br>" + tag + " is associated with Asset!";
		// }
		if (msg.equals("")) {
			customerDocsRepository.deleteById(Integer.parseInt(customerId));
			customerContactReposiitory.deleteById(Integer.parseInt(customerId));
			customerRepository.deleteById(Integer.parseInt(customerId));
			output.put("successmsg", " Deleted Successfully!");
		} else {
			output.put("msg", msg);
		}
	}

	public Map<String, String> populateConfigDetails(HttpSession session) {
		output = new LinkedHashMap<String, String>();
		int emp_id = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		List<Object[]> object = empRepository.findEmpId(emp_id);
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (Object[] objects : object) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("configCustomerSoe", "" + objects[0]);
			configCustomerSoe = objects[0] + "";
			map.put("configCustomerSob", "" + objects[1]);
			configCustomerSob = objects[1] + "";
			map.put("configCustomerAddress", "" + objects[2]);
			configCustomerAddress = objects[2] + "";
			map.put("configCustomerDupnames", "" + objects[3]);
			configCustomerDupnames = objects[3] + "";
			map.put("empRoleId", "" + objects[4]);
			empRoleId = objects[4] + "";
			list.add(map);
		}
		output.put("populateConfigDetails", list.toString());
		return output;
	}

	public Map<String, String> populateCustomerFields(String input, HttpSession session) throws JSONException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, String>();
		if (!inputObj.isNull("customerId")) {
			int customerId = Integer.parseInt(CNumeric(PadQuotes(inputObj.getString("customerId"))));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (AxelaCustomerItstatus obj : axelaCustomerItstatusRepository.findAll()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", "" + obj.getItstatusId());
			map.put("name", obj.getItstatusName());
			list.add(map);
		}
		output.put("populateItStatus", list);
		return output;
	}

	public Map<String, String> populateData(String input, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, String>();
		String customerType = "";
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			if (!returnPerm("emp_customer_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			tag = PadQuotes(getSession("configCustomerName", session));
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			LinkedHashMap map = new LinkedHashMap();
			if (!inputObj.isNull("customerId")) {
				customerId = CNumeric(inputObj.getString("customerId"));
			}
			if (!customerId.equals("0")) {
				AxelaCustomer customer = customerFilter.findCustomerOne(Integer.parseInt(customerId));
				if (customer != null) {
					if (String.valueOf(customer.getCustomerType()).equals("1")) {
						customerType = "Customer";
					} else if (String.valueOf(customer.getCustomerType()).equals("2" + "")) {
						customerType = "Supplier";
					} else {
						customerType = "";
					}
					map.put("customerId", String.valueOf(customer.getCustomerId()));
					map.put("customerName", String.valueOf(customer.getCustomerName()));
					map.put("customerCode", customer.getCustomerCode());
					map.put("customerBranchId", "" + customer.getCustomerBranchId());
					map.put("customerMobile1", customer.getCustomerMobile1());
					map.put("customerMobile2", customer.getCustomerMobile2());
					map.put("customerPhone1", customer.getCustomerPhone1());
					map.put("customerPhone2", customer.getCustomerPhone2());
					map.put("customerPhone3", customer.getCustomerPhone3());
					map.put("customerPhone4", customer.getCustomerPhone4());
					map.put("customerFax1", customer.getCustomerFax1());
					map.put("customerFax2", customer.getCustomerFax2());
					map.put("customerEmail1", customer.getCustomerEmail1());
					map.put("customerEmail2", customer.getCustomerEmail2());
					map.put("customerWebsite1", customer.getCustomerWebsite1());
					map.put("customerWebsite2", customer.getCustomerWebsite2());
					map.put("customerGstNo", customer.getCustomerGstNo());
					map.put("customerGstRegdate", strToShortDate(customer.getCustomerGstRegdate()));
					map.put("customerArnNo", customer.getCustomerArnNo());
					map.put("customerItstatusId", customer.getCustomerItstatusId());
					map.put("customerAddress1", customer.getCustomerAddress1());
					map.put("customerLandmark", customer.getCustomerLandmark());
					map.put("customerCityId", "" + customer.getCustomerCityId());
					map.put("customerPin", "" + customer.getCustomerPin());
					map.put("customerTinNo", customer.getCustomerTinNo());
					map.put("customerServiceTaxNo", customer.getCustomerServiceTaxNo());
					map.put("customerTds", Integer.parseInt(customer.getCustomerTds()) + "");
					map.put("customerPanNo", PadQuotes(customer.getCustomerPanNo()));
					map.put("customerSoeId", "" + customer.getCustomerSoeId());
					map.put("customerSobId", "" + customer.getCustomerSobId());
					map.put("customerRateclassId", "" + customer.getCustomerRateclassId());
					map.put("customerCreditLimit", "" + customer.getCustomerCreditLimit());
					map.put("customerDiscPerc", "" + customer.getCustomerDiscPerc());
					map.put("customerSince", strToShortDate(customer.getCustomerSince()));
					map.put("customerEmpcountId", "" + customer.getCustomerEmpcountId());
					map.put("customerType", "" + customer.getCustomerType());
					map.put("customerPaydaysId", "" + customer.getCustomerPaydaysId());
					map.put("customerEmpId", "" + customer.getCustomerEmpId());
					map.put("customerAccGroupId", "" + customer.getCustomerAccgroupId());
					map.put("customerActive", Integer.parseInt(customer.getCustomerActive()) + "");
					map.put("customerNotes", "" + customer.getCustomerNotes());
					List<Integer> groupId = customerGroupTranRepo.findByCustomerId(customer.getCustomerId());
					StringBuilder dataString = new StringBuilder();
					if (!groupId.isEmpty()) {
						dataString = dataString.append(groupId.get(0));
						for (int i = 1; i <= groupId.size() - 1; ++i) {
							String groupname = PadQuotes(groupId.get(i) + "");
							dataString = dataString.append(",").append(groupname);
						}
					}
					map.put("groupIds", dataString.toString());
					if (customer.getCustomerEntryId() != 0) {
						map.put("customerEntryId", customer.getCustomerEntryId() + "");
						map.put("customerEntryBy", PadQuotes(empRepository.findByEmp(customer.getCustomerEntryId())));
						map.put("customerEntryDate", strToShortDate(customer.getCustomerEntryDate()));
					}
					if (customer.getCustomerModifiedId() != 0) {
						map.put("customerModifiedDate", strToShortDate(customer.getCustomerModifiedDate()));
						map.put("customerModifiedId", customer.getCustomerModifiedId() + "");
						map.put("customerModifiedBy", PadQuotes(empRepository.findByEmp(customer.getCustomerModifiedId())));
					}
					list.add(map);
					output.put("populateData", list);
				}
			}
		}
		return output;
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			if (!returnPerm("emp_customer_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			configCustomerName = PadQuotes(getSession("configCustomerName", session));
			orderByField = "";
			orderType = "";
			page = 0;
			String strSearch = "";
			String strOrderBy = "";
			String requestType = "";
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			branchAccess = getSession("branchAccess", session).replaceAll("branchId", "customer.customerBranchId");
			exeAccess = getSession("exeAccess", session).replaceAll("empId", "customer.customerEmpId");
			perPage = CNumeric(PadQuotes(getSession("empRecperpage", session)));
			String customerType = "";
			List<AxelaCustomer> customerList = new ArrayList<AxelaCustomer>();
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
			if (!inputObj.isNull("sortDirection")) {
				orderType = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
			}
			if (!inputObj.isNull("tag")) {
				tag = PadQuotes((inputObj.getString("tag")));
			}
			perPage = CNumeric(getSession("empRecperpage", session));
			if (perPage.equals("0")) {
				perPage = "12";
			}
			if (orderType.equals("")) {
				orderType = "DESC";
			}
			if (orderByField.equals("")) {
				orderByField = "customerId";
			}
			page++;
			if (!inputObj.isNull("requestType")) {
				requestType = PadQuotes((inputObj.getString("requestType")));
			}
			if (requestType.equals("filter")) {
				strSearch += buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			strOrderBy = " ORDER BY customer." + orderByField + " " + orderType;
			customerList = customerFilter.findAll(strSearch, strOrderBy, page, Integer.parseInt(perPage), tag);
			length = customerFilter.totalCount + "";
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("ID", "customerId", "center"));
			listHeader.add(produceHeaderData("Name", "customerName", "center"));
			listHeader.add(produceHeaderData("Contacts", "customerMobile1", "center"));
			listHeader.add(produceHeaderData("Address", "customerAddress1", "center"));
			listHeader.add(produceHeaderData("Type", "customerType", "center"));
			listHeader.add(produceHeaderData("Current Bal", "customerCurrBal", "center"));
			listHeader.add(produceHeaderData("Executive", "axelaEmp.empName", "center"));
			listHeader.add(produceHeaderData("Branch", "axelaBranch.branchName", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("right"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));

			// End Body Align

			StringBuilder dataString = null;
			for (AxelaCustomer obj : customerList) {
				ArrayList<String> paramSubArr = new ArrayList<String>();
				ArrayList<ArrayList> paramArr = new ArrayList<ArrayList>();
				ArrayList type = new ArrayList();
				ArrayList value = new ArrayList();
				HashMap<String, List<HashMap>> mapData = new HashMap<String, List<HashMap>>();
				HashMap<String, List<HashMap>> mapAction = new HashMap<String, List<HashMap>>();
				HashMap<String, List<String>> mapBodyData = new HashMap<String, List<String>>();
				List<HashMap> listData = new ArrayList<HashMap>();
				count++;
				if (String.valueOf(obj.getCustomerType()).equals("1")) {
					customerType = configCustomerName;
				} else if (String.valueOf(obj.getCustomerType()).equals("2")) {
					customerType = " Supplier";
				} else {
					customerType = "";
				}
				// Start Body data
				// count
				type.add(true);
				value.add(count);
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// ID
				type.add(true);
				value.add(PadQuotes(String.valueOf(obj.getCustomerId())));
				paramSubArr.add("customerDash");
				paramSubArr.add(obj.getCustomerId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// customerDash
				type.add(true);
				value.add(PadQuotes(String.valueOf(obj.getCustomerName())));
				paramSubArr.add("customerDash");
				paramSubArr.add(obj.getCustomerId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// customerMobile
				if (!obj.getCustomerMobile1().equals("")) {
					type.add(false);
					value.add(PadQuotes(obj.getCustomerMobile1()));
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getCustomerMobile2().equals("")) {
					type.add(false);
					value.add(PadQuotes(obj.getCustomerMobile2()));
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getCustomerPhone1().equals("")) {
					type.add(false);
					value.add(PadQuotes(obj.getCustomerPhone1()));
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getCustomerPhone2().equals("")) {
					type.add(false);
					value.add(PadQuotes(obj.getCustomerPhone2()));
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getCustomerEmail1().equals("")) {
					type.add(false);
					value.add("<a href=\"mailto:" + obj.getCustomerEmail1() + ">" + obj.getCustomerEmail1() + "</a> ");
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getCustomerEmail2().equals("")) {
					type.add(false);
					value.add("<a href=\"mailto:" + obj.getCustomerEmail2() + ">" + obj.getCustomerEmail2() + "</a> ");
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getCustomerWebsite1().equals("")) {
					type.add(false);
					value.add("<a href=http://" + PadQuotes(obj.getCustomerWebsite1()) + ">");
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getCustomerWebsite2().equals("")) {
					type.add(false);
					value.add("<a href=http://" + PadQuotes(obj.getCustomerWebsite2()) + ">");
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// address
				if (!obj.getCustomerAddress1().equals("")) {
					type.add(false);
					value.add(PadQuotes(obj.getCustomerAddress1() + ","));
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getCustomerCityName().equals("") && !obj.getCustomerPin().equals("")) {
					type.add(false);
					value.add(PadQuotes(obj.getCustomerCityName() + " - " + obj.getCustomerPin() + ","));
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getCustomerCityName().equals("") && obj.getCustomerPin().equals("")) {
					type.add(false);
					value.add(PadQuotes(obj.getCustomerCityName() + ","));
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getCustomerStateName().equals("")) {
					type.add(false);
					value.add(PadQuotes(obj.getCustomerStateName() + ", " + obj.getCustomerCountryName() + "."));
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// Customer Type
				type.add(false);
				value.add(PadQuotes(customerType + ""));
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// customer bal
				type.add(false);
				value.add(PadQuotes(obj.getCustomerCurrBal() + ""));
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// executive
				type.add(false);
				value.add(ExePhotoOval(obj.getCustomerEmpId() + ""));
				paramArr.add((ArrayList) paramSubArr.clone());
				type.add(true);
				value.add(PadQuotes(obj.getCustomerEmpName() + ""));
				paramArr.add((ArrayList) paramSubArr.clone());
				paramSubArr.add("executiveSummary");
				paramSubArr.add(obj.getCustomerEmpId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// branchName
				type.add(true);
				value.add(PadQuotes(obj.getCustomerBranchName() + ""));
				paramSubArr.add("branchSummary");
				paramSubArr.add(obj.getCustomerBranchId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// End Body data
				// ArrayList actionParam = new ArrayList();
				mapData.put("td", listData);
				ArrayList actionParam = new ArrayList();
				ArrayList actionParam1 = new ArrayList();
				ArrayList actionParam2 = new ArrayList();
				ArrayList actionParam3 = new ArrayList();
				ArrayList actionParam4 = new ArrayList();
				ArrayList actionParam5 = new ArrayList();
				actionParam.add("Update " + tag);
				actionParam1.add("Update GST Document");
				actionParam2.add("Add Contact");
				actionParam3.add("List Contact");
				actionParam4.add("List Document");
				actionParam5.add("List Project");
				actionParam.add(PadQuotes(String.valueOf(obj.getCustomerId())));
				actionParam1.add(PadQuotes(String.valueOf(obj.getCustomerId())));
				actionParam2.add(PadQuotes(String.valueOf(obj.getCustomerId())));
				actionParam3.add(PadQuotes(String.valueOf(obj.getCustomerId())));
				actionParam4.add(PadQuotes(String.valueOf(obj.getCustomerId())));
				mapAction.put("td", produceActionData(actionParam, actionParam1, actionParam2, actionParam3, actionParam4, actionParam5, tag));
				listAction.add(mapAction);
				listBody.add(mapData);
			}
			output.put("meta", mapNavi);
			output.put("thead", listHeader);
			output.put("tdalign", listBodyAlign);
			output.put("tbody", listBody);
			output.put("action", listAction);
			if (AppRun().equals("0")) {
				SOP("output==========CustomerService==========" + output.toString());
			}
		}
		return output;
	}
	private ArrayList<HashMap> produceActionData(ArrayList<String> Param, ArrayList<String> Param1, ArrayList<String> Param2, ArrayList<String> Param3, ArrayList<String> Param4,
			ArrayList<String> Param5, String tag) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		if (tag.equals("Supplier")) {
			mapBodyData.put("value", "Update Supplier");
		} else {
			mapBodyData.put("value", "Update " + configCustomerName);
		}
		mapBodyData.put("routingLink", "/customerupdate");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Update GST Document");
		mapBodyData.put("routingLink", "/customergstdocumentupdate");
		mapBodyData.put("param", Param1);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Add Contact");
		mapBodyData.put("routingLink", "/customercontactupdate");
		mapBodyData.put("param", Param2);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "List Contact");
		mapBodyData.put("routingLink", "/contactlist");
		mapBodyData.put("param", Param3);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "List Document");
		mapBodyData.put("routingLink", "/contactlist");
		mapBodyData.put("param", Param4);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "List Project");
		mapBodyData.put("routingLink", "/contactlist");
		mapBodyData.put("param", Param5);
		listAction.add((HashMap) mapBodyData.clone());

		return listAction;
	}

	public Map populateDrSmart(HttpSession session) {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		String customerName = getSession("configCustomerName", session);
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "customer.*"));
		list.add(buildSmartArr(customerName + " ID", "numeric", "customer.customerId"));
		list.add(buildSmartArr(customerName, " text", "customer.customerName"));
		list.add(buildSmartArr("Code", "text", "customer.customerCode"));
		list.add(buildSmartArr("Branch ID", "numeric", "customer.branchId"));
		list.add(buildSmartArr("Branch Name", "text", "customer.branchName"));
		list.add(buildSmartArr("Mobile", "text", "concat(REPLACE(customer.customerMobile1,'-',''),REPLACE(customer.customerMobile2,'-',''))"));
		list.add(buildSmartArr("Phone", "text",
				"concat(REPLACE(customer.customerPhone1,'-',''),REPLACE(customer.customerPhone2,'-',''),REPLACE(customer.customerPhone3,'-',''),REPLACE(customer.customerPhone4,'-',''))"));
		list.add(buildSmartArr("Email", "text", "concat(customer.customerEmail1, customer.customerEmail2)"));
		list.add(buildSmartArr("Fax1", "text", "customer.customerFax1"));
		list.add(buildSmartArr("Fax2", "text", "customer.customerFax2"));
		list.add(buildSmartArr("Website1", "text", "customer.customerWebsite1"));
		list.add(buildSmartArr("Website2", "text", "customer.customerWebsite2"));
		list.add(buildSmartArr("Address", "text", "CONCAT(customer.customerAddress1, ', ', customer.cityName, ' - ', customer.customerPin, ', ', customer.stateName, ', ', customer.countryName, '.')"));
		list.add(buildSmartArr("Landmark", "text", "customer.customerLandmark"));
		list.add(buildSmartArr("Pan Number", "text", "customer.customerPanNo"));
		list.add(buildSmartArr("Tin Number", "text", "customer.customerTinNo"));
		list.add(buildSmartArr("Service Tax No.", "text", "customer.customerServiceTaxNo"));
		// list.add(buildSmartArr("Employee Count", "text", "customer_empcount_id IN (SELECT empcount_id FROM compdb.axela_empcount WHERE empcount_desc"));
		list.add(buildSmartArr("Customer Since", "date", "customer.customerSince"));
		list.add(buildSmartArr("Current Balance", "numeric", "customer.customerCurrBal"));
		list.add(buildSmartArr("Executive", "text", "customer.axelaEmp.empName"));
		list.add(buildSmartArr("Active", "boolean", "customer.customerActive"));
		// list.add(buildSmartArr("Groups", "text", "customer_id IN (SELECT trans_customer_id FROM axela_customer_group_trans"
		// + " INNER JOIN axela_customer_group ON group_id = trans_group_id WHERE group_desc"));
		list.add(buildSmartArr("Notes", "text", "customer.customerNotes"));
		// list.add(buildSmartArr("Entry By", "text", "customerEntryId in (select empId from compdb.axela_emp where emp_name"));
		list.add(buildSmartArr("Entry Date", "date", "customer.customerEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "customerModifiedId in (select emp_id from compdb.axela_emp where emp_name"));
		list.add(buildSmartArr("Modified Date", "date", "customer.customerModifiedDate"));
		// list.add(buildSmartArr("Custom Fields", "text", "customer_id IN (SELECT cftrans_row_id FROM compdb.axela_cf_trans WHERE cftrans_submodule_id = 1 and cftrans_value"));
		output.put("drSmart", list.toArray());
		return output;
	}

	public Map<String, String> populateLandingDetails(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List rec = new ArrayList();;
		String startDate = "";
		String endDate = "";
		String date = "";
		int total = 0;
		Map data = null;

		if (!inputObj.isNull("startDate")) {
			startDate = PadQuotes(inputObj.getString("startDate"));
		}
		if (!inputObj.isNull("endDate")) {
			endDate = PadQuotes(inputObj.getString("endDate"));
		}

		if (startDate.equals("") || endDate.equals("")) {
			date = sdf.format(getTimeByZone(session));
		}
		if (startDate.equals("")) {
			startDate = ReportStartdate(date, empFormatdate);
		}
		if (endDate.equals("")) {
			endDate = formatDate(date, empFormatdate);
		}

		if (!startDate.equals("")) {
			strSearch = " AND customer.customerEntryDate  >= " + compableDateToString(startDate);
		}
		if (!endDate.equals("")) {
			strSearch += " AND customer.customerEntryDate  <= " + compableDateToString(endDate);
		}

		if (!inputObj.isNull("branchIds")) {
			if (inputObj.get("branchIds") instanceof JSONArray) {
				branchIds = jsonArrayToString(inputObj.getJSONArray("branchIds"));
			}
			if (!branchIds.equals("")) {
				strSearch += " AND branch.branchId IN (" + branchIds + ")";
			}
		}

		strSearch += branchAccess
				+ " AND customer.customerActive=1"
				+ " AND branch.branchActive=1";

		List<AxelaCustomer> customerList = customerFilterImpl.findAllCustomersForLanding(strSearch);
		if (customerList != null) {
			for (AxelaCustomer obj : customerList) {
				data = new HashMap();
				data.put("branchId", obj.getBranchId());
				data.put("branchName", obj.getBranchName() + " (" + obj.getBranchCode() + ")");
				data.put("customersCount", obj.getCustomersCount());
				rec.add(data);
				total += obj.getCustomersCount();
			}
			output.put("customerSummary", rec);
			output.put("total", total);

		} else {
			output.put("errormsg", msg);
		}
		return output;
	}

	public String compableDateToString(String date) {
		String data = "";
		String[] arr = date.split("/");
		for (int i = arr.length - 1; i >= 0; i--) {
			data += arr[i];
		}
		return data + "000000";
	}

	public String jsonArrayToString(JSONArray jsonarray) throws JSONException {
		StringBuilder str = new StringBuilder();
		if (jsonarray.length() > 1) {
			str.append(jsonarray.getInt(0));
			SOP("jsonarray.length()" + jsonarray.length());
			for (int i = 1; i < jsonarray.length(); i++) {
				str.append(",").append(jsonarray.getInt(i));
			}
		} else if (jsonarray.length() == 1) {
			str.append(jsonarray.getInt(0));
		}
		return str.toString();
	}

}