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

import axela.activities.repository.ActivityRepository;
import axela.config.Connect;
import axela.customer.model.AxelaCustomer;
import axela.customer.model.AxelaCustomerContact;
import axela.customer.repository.CustomerContactReposiitory;
import axela.customer.repository.CustomerFilterImpl;
import axela.customer.repository.CustomerRepository;
import axela.helpdesk.repository.TicketRepository;
import axela.portal.repository.AxelaCityRepository;
import axela.portal.repository.AxelaStateRepository;
import axela.portal.repository.EmpRepository;
import axela.sales.repository.OpprRepository;
import axela.service.repository.ServiceContractRepository;
import axela.service.repository.VoucherRepository;

@Service
public class CustomerContactService extends Connect {

	public String contactId = "0";
	public String contactTitleId = "0";
	public String contactFname = "";
	public String contactLname = "";
	public String contactJobtitle = "";
	public String contactLocation = "";
	public String contactMobile1 = "";
	public String contactMobile2 = "";
	public String contactPhone1 = "";
	public String contactPhone2 = "";
	public String contactEmail1 = "";
	public String contactDnd = "";
	public String contactEmail2 = "";
	public String contactYahoo = "";
	public String contactAol = "";
	public String contactSkype = "";
	public String contactAddress = "";
	public String contactCityId = "0";
	public String cityName = "";
	public String contactPin = "";
	public String contactLandmark = "";
	public String customerSoeId = "0";
	public String customerSobId = "0";
	public String customerGroupId = "0";
	public String dobDay = "0";
	public String dobMonth = "0";
	public String anniversaryDay = "0";
	public String anniversaryMonth = "0";
	public String contactAnniversary = "";
	public int contactActive = 0;
	public String contactNotes = "";
	public String entryId = "0";
	public String entryDate = "";
	public String modified_by = "0";
	public String modified_date = "";
	public String customerName = "";
	public String contactDob = "";
	public String contactCustomerId = "0";
	public String tag = "contact";
	public String requestType = "";
	public String msg = "";
	public String pageNumber = "";
	public int empId = 0;
	public String configSalesOpprName = "";
	public String configCustomerName = "";
	public int customerBranchId = 0;
	public String BranchAccess = "";
	public String ExeAccess = "";
	public String emp_formatdate = "";
	public String property = "", value = "";
	public String contactMsn = "";
	public int len = 0;
	public String pages = "1";
	public String configCustomerAddress = "0";
	public String configCustomerSoe = "0";
	public String configCustomerSob = "0";
	public String configCustomerDupnames = "0";
	private String branchAccess = "";
	private String exeAccess = "";
	private String pageIndex = "";
	private String strSearch = "";
	private String totalCount = "0";
	private List<AxelaCustomerContact> contactList;
	private int page = 0;
	private String perPage = "0";
	private List<Object[]> citylist;
	public int compId = 0;
	public String branchId = "0";
	public String compModuleAccounting = "0";
	public String empFormatDate = "";

	public String branchIds = "";
	public String startDate = "";
	public String endDate = "";
	public String empFormatdate = "";
	HashMap output = null;
	JSONObject inputObj = null;

	@Autowired
	CustomerFilterImpl customerFilterImpl;

	@Autowired
	private VoucherRepository voucherRepository;

	@Autowired
	private OpprRepository opprRepository;

	@Autowired
	private ServiceContractRepository serviceContractRepository;

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private ActivityRepository activityRepository;

	@Autowired
	private CustomerContactReposiitory contactRepository;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	private CustomerFilterImpl customerFilter;

	@Autowired
	private AxelaCityRepository axelaCityRepository;

	@Autowired
	private AxelaStateRepository axelaStateRepository;

	@Autowired
	private CustomerRepository customerRepository;

	// @Autowired
	// private CustomerFilterImplementation customerFilterImplementation;

	public Map contactService(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		branchAccess = PadQuotes(getSession("branchAccess", session)).replaceAll("branchId", "customer.customerBranchId");
		exeAccess = PadQuotes(getSession("exeAccess", session)).replaceAll("empId", "customer.customerEmpId");
		configSalesOpprName = PadQuotes(getSession("configSalesOpprName", session));
		configCustomerName = PadQuotes(getSession("configCustomerName", session));
		branchId = CNumeric(PadQuotes(getSession("empBranchId", session)));
		compModuleAccounting = CNumeric(PadQuotes(getSession("compModuleAccounting", session)));
		empFormatDate = PadQuotes(getSession("formatdate_name", session));

		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("input========CustomerContactService===========" + inputObj.toString(1));
		}
		if (empId != 0) {
			if (!returnPerm("emp_contact_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			output = new HashMap();
			empId = Integer.parseInt(CNumeric(getSession("empId", session)));
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			PopulateConfigDetails(empId);
			System.out.println("3");

			switch (requestType) {
				case "add" :
					if (!returnPerm("emp_contact_add", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					contactId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;

				case "update" :
					if (!returnPerm("emp_contact_edit", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					contactId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;

				case "delete" :
					if (!returnPerm("emp_contact_delete", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					if (!inputObj.isNull("contactId")) {
						contactId = inputObj.getString("contactId");
					}

					if (!contactId.equals("0")) {
						deleteFields(contactId);
					}
					break;

				case "landing" :
					if (!inputObj.isNull("startDate")) {
						startDate = PadQuotes(inputObj.getString("startDate"));
					}
					if (!inputObj.isNull("endDate")) {
						endDate = PadQuotes(inputObj.getString("endDate"));
					}

					if (!inputObj.isNull("branchIds")) {
						branchIds = PadQuotes(inputObj.getString("branchIds"));
						if (!branchIds.equals("0")) {
							branchIds = PadQuotes(inputObj.getString("branchIds"));
						}
					}
					populateLandingDetails(input, session, response);
					break;

			}
			if (AppRun().equals("0")) {
				SOP("output========CustomerContactService===========" + output);
			}
		}
		return output;
	}

	public void PopulateConfigDetails(int emp_id) {
		List<Object[]> object = empRepository.findEmpId(emp_id);
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (Object[] objects : object) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("config_customer_soe", "" + objects[0]);
			configCustomerSoe = "" + objects[0];
			configCustomerSob = "" + objects[1];
			map.put("config_customer_sob", "" + objects[1]);
			configCustomerAddress = "" + objects[2];
			map.put("config_customer_address", "" + objects[2]);
			configCustomerDupnames = "" + objects[3];
			map.put("config_customer_dupnames", "" + objects[3]);
			map.put("emp_role_id", "" + objects[4]);
			configSalesOpprName = "" + objects[5];
			list.add(map);
		}
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		if (!inputObj.isNull("contactId")) {
			contactId = CNumeric(inputObj.getString("contactId"));
		}
		if (!inputObj.isNull("customerName")) {
			customerName = PadQuotes(inputObj.getString("customerName"));
		} else if (!inputObj.isNull("contactCustomerId")) {
			contactCustomerId = CNumeric(inputObj.getString("contactCustomerId"));
		}
		if (!inputObj.isNull("contactMsn")) {
			contactMsn = CNumeric(inputObj.getString("contactMsn"));
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
		if (!inputObj.isNull("contactJobtitle")) {
			contactJobtitle = PadQuotes(inputObj.getString("contactJobtitle"));
		}
		if (!inputObj.isNull("contactLocation")) {
			contactLocation = PadQuotes(inputObj.getString("contactLocation"));
		}

		if (!inputObj.isNull("contactMobile1")) {
			contactMobile1 = PadQuotes(inputObj.getString("contactMobile1"));
		}
		if (!inputObj.isNull("contactMobile2")) {
			contactMobile2 = PadQuotes(inputObj.getString("contactMobile2"));
		}
		if (!inputObj.isNull("contactPhone1")) {
			contactPhone1 = PadQuotes(inputObj.getString("contactPhone1"));
		}
		if (!inputObj.isNull("contactPhone2")) {
			contactPhone2 = PadQuotes(inputObj.getString("contactPhone2"));
		}
		if (!inputObj.isNull("contactEmail1")) {
			contactEmail1 = PadQuotes(inputObj.getString("contactEmail1"));
		}
		if (!inputObj.isNull("contactEmail2")) {
			contactEmail2 = PadQuotes(inputObj.getString("contactEmail2"));
		}
		if (!inputObj.isNull("contactYahoo")) {
			contactYahoo = PadQuotes(inputObj.getString("contactYahoo"));
		}
		if (!inputObj.isNull("contactMsn")) {
			contactMsn = PadQuotes(inputObj.getString("contactMsn"));
		}
		if (!inputObj.isNull("contactAol")) {
			contactAol = PadQuotes(inputObj.getString("contactAol"));
		}
		if (!inputObj.isNull("contactSkype")) {
			contactSkype = PadQuotes(inputObj.getString("contactSkype"));
		}
		if (!inputObj.isNull("contactAddress")) {
			contactAddress = PadQuotes(inputObj.getString("contactAddress"));
		}
		if (!inputObj.isNull("contactCityId")) {
			contactCityId = PadQuotes(inputObj.getString("contactCityId"));
		}
		if (!inputObj.isNull("cityName")) {
			cityName = PadQuotes(inputObj.getString("cityName"));
		}
		if (!inputObj.isNull("contactPin")) {
			contactPin = PadQuotes(inputObj.getString("contactPin"));
		}
		if (!inputObj.isNull("contactLandmark")) {
			contactLandmark = PadQuotes(inputObj.getString("contactLandmark"));
		}
		if (!inputObj.isNull("customerSoeId")) {
			customerSoeId = CNumeric(PadQuotes(inputObj.getString("customerSoeId")));
		}
		if (!inputObj.isNull("customerSobId")) {
			customerSobId = CNumeric(PadQuotes(inputObj.getString("customerSobId")));
		}
		if (!inputObj.isNull("contactDob")) {
			contactDob = PadQuotes(inputObj.getString("contactDob"));
		}
		if (!inputObj.isNull("customerGroupId")) {
			customerGroupId = PadQuotes(inputObj.getString("customerGroupId"));
		}
		if (!inputObj.isNull("dobDay")) {
			dobDay = PadQuotes(inputObj.getString("dobDay"));
		}
		if (!inputObj.isNull("dobMonth")) {
			dobMonth = PadQuotes(inputObj.getString("dobMonth"));
		}
		// if (!dobDay.equals("0") && !dobMonth.equals("0")) {
		// contactDob = "2012" + dobMonth + dobDay + "000000";
		// }
		if (!inputObj.isNull("anniversaryDay")) {
			anniversaryDay = PadQuotes(inputObj.getString("anniversaryDay"));
		}
		if (!inputObj.isNull("contactAnniversary")) {
			contactAnniversary = PadQuotes(inputObj.getString("contactAnniversary"));
		}
		if (!inputObj.isNull("contactAnniversary")) {
			contactAnniversary = PadQuotes(inputObj.getString("contactAnniversary"));
		}
		if (!inputObj.isNull("anniversaryMonth")) {
			anniversaryMonth = PadQuotes(inputObj.getString("anniversaryMonth"));
		}
		// if (!anniversaryDay.equals("0") && !anniversaryMonth.equals("0")) {
		// contactAnniversary = "2012" + anniversaryMonth + anniversaryDay + "000000";
		// }
		if (!inputObj.isNull("contactActive")) {
			contactActive = Integer.parseInt(inputObj.getString("contactActive"));
		}
		if (!inputObj.isNull("contactNotes")) {
			contactNotes = PadQuotes(inputObj.getString("contactNotes"));
		}
		if (!inputObj.isNull("customerBranchId")) {
			customerBranchId = Integer.parseInt(CNumeric(inputObj.getString("customerBranchId")));
		}
		if (requestType.equals("update")) {
			if (!inputObj.isNull("entryId")) {
				entryId = PadQuotes(inputObj.getString("entryId"));
			}
			if (!inputObj.isNull("entryDate")) {
				entryDate = PadQuotes(inputObj.getString("entryDate"));
			}
		}
	}

	public void checkForm() {
		msg = "";
		if (contactCustomerId.equals("0") && customerName.equals("")) {
			msg += "<br>Enter the customer Name!";
		}
		if (contactTitleId.equals("0")) {
			msg = msg + "<br>Select Title!";
		}
		if (contactFname.equals("")) {
			msg = msg + "<br>Enter the Contact Person First Name!";
		}
		if (contactLname.equals("")) {
			msg = msg + "<br>Enter the Contact Person Last Name!";
		}
		if (contactMobile1.equals("") && contactPhone1.equals("")) {
			msg = msg + "<br>Enter Either Mobile 1 or Phone 1!";
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
				msg = msg + "<br>Enter Valid Contact Mobile 2!";
			}
		}
		if (!contactMobile1.equals("") && !contactMobile2.equals("") && contactMobile1.equals(contactMobile2)) {
			msg += "<br>Mobile2 is same as Mobile1!";
		}
		if (!contactPhone1.equals("")) {
			len = contactPhone1.length();
			if (len < 7 || len > 15) {
				msg = msg + "<br>Enter Valid Contact Phone 1!";
			}
		}
		if (!contactPhone2.equals("")) {
			len = contactPhone2.length();
			if (len < 7 || len > 15) {
				msg = msg + "<br>Enter Valid Contact Phone 2!";
			}
		}
		if (!contactPhone2.equals("") && !contactPhone1.equals("") && contactPhone2.equals(contactPhone1)) {
			msg += "<br>Phone2 is same as Phone1!";
		}
		if (!contactEmail1.equals("")) {
			if (!IsValidEmail(contactEmail1)) {
				msg = msg + "<br>Email1 is invalid!";
			} else {
				contactEmail1 = contactEmail1.toLowerCase();
			}
		}
		if (!contactEmail2.equals("")) {
			if (!IsValidEmail(contactEmail2)) {
				msg = msg + "<br>Email2 is invalid!";
			} else {
				contactEmail2 = contactEmail2.toLowerCase();
			}
		}
		if (!contactEmail1.equals("")
				&& !contactEmail2.equals("")
				&& contactEmail2.equals(contactEmail1)) {
			msg = msg + "<br>Email2 is same as Email1!";
		}
		if (configCustomerAddress.equals("1") && contactAddress.equals("")) {
			msg = msg + "<br>Enter Address!";
		}
		if (contactCityId.equals("0")) {
			msg = msg + "<br>Select City!";
		}
		if (contactPin.equals("") && configCustomerAddress.equals("1")) {
			msg = msg + "<br>Enter Pin Code!";
		} else if (!contactPin.equals("") && !isNumeric(contactPin)) {
			msg = msg + "<br>Enter Numeric Pin Code!";
		}
		if ("add".equals(requestType)) {
			if (configCustomerSoe.equals("1") && customerSoeId.equals("0")) {
				msg += "<br>Select Source of Enquiry!";
			}
			if (configCustomerSob.equals("1") && customerSobId.equals("0")) {
				msg += "<br>Select Source of Business!";
			}
		}
		if (((dobDay.equals("-1")) && (!dobMonth.equals("-1"))) || ((!dobDay.equals("-1")) && (dobMonth.equals("-1")))) {
			msg += "<br>Invalid DOB!";
		}
		if (((anniversaryDay.equals("-1")) && (!anniversaryMonth.equals("-1"))) || ((!anniversaryDay.equals("-1")) && (anniversaryMonth.equals("-1")))) {
			msg += "<br>Invalid Anniversary Date!";
		}
		if (!contactEmail1.equals("")) {
			contactEmail1 = contactEmail1.toLowerCase();
		}
		if (!contactEmail2.equals("")) {
			contactEmail2 = contactEmail2.toLowerCase();
		}
	}

	public void addFields(HttpServletResponse response, HttpSession session) {
		try {
			int entryconId = 0;
			checkForm();
			if (msg.equals("")) {
				AxelaCustomerContact axelaContact = null;
				if (!contactId.equals("0")) {
					axelaContact = contactRepository.findByContactId(Integer.parseInt(contactId));
					contactCustomerId = axelaContact.getContactCustomerId() + "";
				}
				else {
					axelaContact = new AxelaCustomerContact();
				}
				if (contactCustomerId.equals("0")) {
					AxelaCustomer axelaCustomer = new AxelaCustomer();
					axelaCustomer.setCustomerBranchId(customerBranchId);
					axelaCustomer.setCustomerName(customerName);
					axelaCustomer.setCustomerMobile1(contactMobile1);
					axelaCustomer.setCustomerEmail1(contactEmail1);
					axelaCustomer.setCustomerSobId(Integer.parseInt(customerSobId));
					axelaCustomer.setCustomerSoeId(Integer.parseInt(customerSoeId));
					axelaCustomer.setCustomerEntryDate(getTimeByZone(session));
					axelaCustomer.setCustomerEntryId(empId);
					axelaCustomer.setCustomerModifiedId(0);
					axelaCustomer.setCustomerModifiedDate(getTimeByZone(session));
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
					axelaCustomer.setCustomerMobile2(contactMobile2);
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
					contactCustomerId = customerRepository.save(axelaCustomer).getCustomerId() + "";
				}

				axelaContact.setContactId(Integer.parseInt(contactId));
				axelaContact.setContactTitleId(Integer.parseInt(contactTitleId));
				axelaContact.setContactFname(contactFname);
				axelaContact.setContactLname(contactLname);
				axelaContact.setContactActive(contactActive + "");
				axelaContact.setContactAddress(contactAddress);
				axelaContact.setContactAnniversary(stringToDate((contactAnniversary)));
				axelaContact.setContactAol(contactAol);
				axelaContact.setContactCityId(contactCityId);
				axelaContact.setContactCustomerId(Integer.parseInt(contactCustomerId));
				axelaContact.setContactDnd(contactDnd);
				axelaContact.setContactDob(stringToDate(contactDob));
				axelaContact.setContactEmail1(contactEmail1);
				axelaContact.setContactEmail2(contactEmail2);
				axelaContact.setContactJobtitle(contactJobtitle);
				axelaContact.setContactLandmark(contactLandmark);
				axelaContact.setContactLocation(contactLocation);
				axelaContact.setContactMobile1(contactMobile1);
				axelaContact.setContactMobile2(contactMobile2);
				axelaContact.setContactSkype(contactSkype);
				axelaContact.setContactYahoo(contactYahoo);
				axelaContact.setContactPhone1(contactPhone1);
				axelaContact.setContactPhone2(contactPhone2);
				axelaContact.setContactMsn(contactMsn);
				axelaContact.setContactPin(contactPin);
				axelaContact.setContactNotes(contactNotes);
				if (contactId.equals("0") && requestType.equals("add")) {
					axelaContact.setContactEntryDate(getTimeByZone(session));
					axelaContact.setContactEntryId(empId);
				} else if (requestType.equals("update") && !contactId.equals("0")) {
					axelaContact.setContactModifiedId(empId);
					axelaContact.setContactModifiedDate(getTimeByZone(session));
				}
				axelaContact = contactRepository.save(axelaContact);
				if (requestType.equals("add")) { // if id = 0 -> add mode else update mode
					output.put("successmsg", "Contact Added Successfully!");
					output.put("contactId", axelaContact.getContactId());
				} else if (requestType.equals("update")) {
					output.put("successmsg", "Contact Updated Successfully!");
					output.put("contactId", axelaContact.getContactId());
				}
			} else {
				response.setStatus(400);
				output.put("errormsg", msg);
			}
		} catch (Exception ex) {
			System.out.println("AxelaCrm====" + this.getClass().getName());
			System.out.println("Error in " + new Exception().getStackTrace()[0].getMethodName() + ": " + ex);
		}
	}

	public void deleteFields(String contactId) {
		msg = "";
		String activity = PadQuotes(activityRepository.findContactActivity(Integer.parseInt(contactId)));
		if (!activity.equals("")) {
			msg += "<br>Contact is associated with Activity!";
		}
		String ticket = PadQuotes(ticketRepository.findByTicketContactId(Integer.parseInt(contactId)));
		if (!ticket.equals("")) {
			msg += "<br>Contact is associated with Ticket!";
		}
		String Contract = PadQuotes(serviceContractRepository.findContactId(Integer.parseInt(contactId)));
		if (!Contract.equals("")) {
			msg += "<br>Contact is associated with Contract!";
		}
		String oppr = PadQuotes(opprRepository.findByContact(Integer.parseInt(contactId)));
		if (!oppr.equals("")) {
			msg += "<br>Contact is associated with " + configSalesOpprName + "!";
		}
		String voucher = PadQuotes(voucherRepository.findContact(Integer.parseInt(contactId)));
		if (!voucher.equals("")) {
			msg += "<br>Contact is associated with Voucher!";
		}
		if (msg.equals("")) {
			contactRepository.delete(Integer.parseInt(contactId));
			output.put("successmsg", "Contact Deleted Successfully!");
		} else {
			output.put("errormsg", msg);
		}
	}
	public void smartarr(String keyword, String contains, String value, String condition) {
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	}

	public Map populateContactData(String input, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		output = new HashMap();
		contactId = "0";
		if (empId != 0) {
			if (!inputObj.isNull("contactId")) {
				contactId = inputObj.getString("contactId");
			}
			if (!contactId.equals("0")) {
				AxelaCustomerContact obj = customerFilter.findContactOne(Integer.parseInt(contactId));
				ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
				if (obj != null) {
					LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
					map.put("contactId", obj.getContactId() + "");
					map.put("contactTitleId", PadQuotes("" + obj.getContactTitleId()));
					map.put("contactFname", PadQuotes(obj.getContactFname()));
					map.put("contactLname", PadQuotes(obj.getContactLname()));
					map.put("contactActive", PadQuotes(Integer.parseInt(obj.getContactActive()) + ""));
					map.put("contactAddress", "" + PadQuotes(obj.getContactAddress()));
					map.put("contactAnniversary", PadQuotes(strToShortDate(obj.getContactAnniversary())));
					if (!PadQuotes((obj.getContactAnniversary()).toString()).equals("")) {
						map.put("contactanniversary", PadQuotes(obj.getContactAnniversary().toString().substring(4, 6)));
						map.put("anniversaryMonth", PadQuotes(obj.getContactAnniversary().toString().substring(6, 8)));
					}
					map.put("contactAol", PadQuotes(obj.getContactAol()));
					map.put("contactCityId", PadQuotes(obj.getContactCityId()));
					map.put("customerName", PadQuotes(obj.getCustomerName()));
					map.put("customerBranchId", PadQuotes(obj.getCustomerBranchId() + ""));
					map.put("contactCustomerId", "" + PadQuotes(obj.getContactCustomerId() + ""));
					map.put("contactDnd", PadQuotes(obj.getContactDnd()));
					map.put("contactDob", strToShortDate(obj.getContactDob()));
					if (!obj.getContactDob().equals("")) {
						map.put("contactDay", PadQuotes(obj.getContactDob().toString().substring(4, 6)));
						map.put("contactMonth", PadQuotes(obj.getContactDob().toString().substring(6, 8)));
					}
					map.put("contactMobile1", PadQuotes(obj.getContactMobile1()));
					map.put("contactMobile2", PadQuotes(obj.getContactMobile2()));
					map.put("contactPhone1", PadQuotes(obj.getContactPhone1()));
					map.put("contactPhone2", PadQuotes(obj.getContactPhone2()));
					map.put("contactEmail1", PadQuotes(obj.getContactEmail1()));
					map.put("contactEmail2", PadQuotes(obj.getContactEmail2()));
					map.put("contactJobtitle", PadQuotes(obj.getContactJobtitle()));
					map.put("customerSoeId", PadQuotes(obj.getCustomerSoeId() + ""));
					map.put("customerSobId", PadQuotes(obj.getCustomerSobId() + ""));
					map.put("contactLandmark", PadQuotes(obj.getContactLandmark()));
					map.put("contactLocation", PadQuotes(obj.getContactLocation()));
					map.put("contactMsn", PadQuotes(obj.getContactMsn()));
					map.put("contactNotes", "" + PadQuotes(obj.getContactNotes()));
					map.put("contactPin", PadQuotes(obj.getContactPin()));
					map.put("contactSkype", PadQuotes(obj.getContactSkype()));
					map.put("contactYahoo", "" + PadQuotes(obj.getContactYahoo()));
					if (obj.getContactEntryId() != 0) {
						map.put("contactEntryId", PadQuotes(obj.getContactEntryId() + ""));
						map.put("contactEntryDate", strToShortDate(obj.getContactEntryDate()));
						map.put("contactEntryBy", PadQuotes(empRepository.findByEmp(obj.getContactEntryId())));
					}
					if (obj.getContactModifiedId() != 0) {
						map.put("contactModifiedDate", PadQuotes(strToShortDate(obj.getContactModifiedDate())));
						map.put("contactModifiedId", PadQuotes(obj.getContactModifiedId() + ""));
						map.put("contactModifiedBy", empRepository.findByEmp(obj.getContactModifiedId()));
					}
					list.add(map);
					output.put("poulateData", list);
				}
			}
		} else {
			output.put("msg", "Invalid Contact ID");
		}
		if (AppRun().equals("0")) {
			SOP("populateContactData=====================" + output);
		}
		return output;
	}

	public Map listData(String input, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		output = new HashMap<String, String>();
		if (empId != 0) {
			if (!returnPerm("emp_contact_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			String orderByField = "";
			page = 0;
			String orderType = "";
			strSearch = "";
			inputObj = new JSONObject(input);
			branchAccess = getSession("branchAccess", session).replaceAll("branchId", "customers.customerBranchId");
			exeAccess = getSession("exeAccess", session).replaceAll("empId", "contactcustomerEmpId");
			List<AxelaCustomer> customerList = null;
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
			perPage = CNumeric(getSession("emp_recperpage", session));
			if (orderType.equals("")) {
				orderType = "DESC";
			}
			if (orderByField.equals("")) {
				orderByField = "contactId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (!inputObj.isNull("requestType")) {
				requestType = PadQuotes((inputObj.getString("requestType")));
			}
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			String strOrderBy = " ORDER BY contact." + orderByField + " " + orderType;
			contactList = customerFilter.findAllContacts(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			totalCount = customerFilter.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(totalCount), input, perPage);
			output.put("meta", mapNavi);
			int count = 0;

			// Start Header Data
			listHeader.add(produceHeaderData("ID", "contactId", "center"));
			listHeader.add(produceHeaderData("Contact Person", "contactFname", "center"));
			listHeader.add(produceHeaderData("Communication", "contactMobile1", "center"));
			listHeader.add(produceHeaderData("Address", "contactAddress", "center"));
			listHeader.add(produceHeaderData("Customer", "axelaCustomers.customerName", "center"));
			listHeader.add(produceHeaderData("Branch", "axelaCustomers.axelaBranch.branchName", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaCustomerContact obj : contactList) {
				ArrayList<String> param = new ArrayList<String>();
				ArrayList<String> actionParam = new ArrayList<String>();
				ArrayList<String> actionParam1 = new ArrayList<String>();
				ArrayList<String> actionParam2 = new ArrayList<String>();
				ArrayList<String> actionParam3 = new ArrayList<String>();
				ArrayList<String> actionParam4 = new ArrayList<String>();
				ArrayList<String> actionParam5 = new ArrayList<String>();
				HashMap<String, List<HashMap>> mapData = new HashMap<String, List<HashMap>>();
				HashMap<String, List<HashMap>> mapAction = new HashMap<String, List<HashMap>>();
				HashMap<String, List<String>> mapBodyData = new HashMap<String, List<String>>();
				ArrayList<String> paramSubArr = new ArrayList<String>();
				ArrayList<ArrayList> paramArr = new ArrayList<ArrayList>();
				ArrayList type = new ArrayList();
				ArrayList value = new ArrayList();
				List<HashMap> listData = new ArrayList<HashMap>();

				count++;
				// count
				type.add(false);
				value.add(count);
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// id
				type.add(false);
				value.add(obj.getContactId());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// contact person
				type.add(false);
				value.add(obj.getContactName());
				if (CNumeric(obj.getContactActive()).equals("0")) {
					type.add(false);
					value.add("<font color=\"red\">[Inactive]</font></br>");
				}
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// communication
				type.add(false);
				type.add(false);
				type.add(false);
				type.add(false);
				type.add(true);
				type.add(true);
				value.add(obj.getContactMobile1());
				value.add(obj.getContactMobile2());
				value.add(obj.getContactPhone1());
				value.add(obj.getContactPhone2());
				value.add(obj.getContactEmail1());
				value.add(obj.getContactEmail2());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();

				// address
				if (!obj.getContactAddress().equals("")) {
					type.add(false);
					value.add(PadQuotes(obj.getContactAddress() + ","));
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getContactCityName().equals("") && !obj.getContactPin().equals("")) {
					type.add(false);
					value.add(PadQuotes(obj.getContactCityName() + " - " + obj.getContactPin() + ","));
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getContactCityName().equals("") && obj.getContactPin().equals("")) {
					type.add(false);
					value.add(PadQuotes(obj.getContactCityName() + ","));
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getContactStateName().equals("")) {
					type.add(false);
					value.add(PadQuotes(obj.getContactStateName() + ", " + obj.getContactCountryName() + "."));
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getContactLandmark().equals("")) {
					type.add(false);
					value.add("Landmark: " + PadQuotes(obj.getContactLandmark()));
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();

				// client
				type.add(true);
				value.add(obj.getContactCustomerName());
				paramSubArr.add("listClients");
				paramSubArr.add(obj.getCustomerName() + "");
				paramArr.add(paramArr);
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				paramArr.clear();
				paramSubArr.clear();
				value.clear();

				// branch
				type.add(true);
				value.add(obj.getContactBranchName());
				paramSubArr.add("branchSummary");
				paramSubArr.add(obj.getContactBranchId() + "");
				paramArr.add(paramArr);
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				paramArr.clear();
				paramSubArr.clear();
				value.clear();

				mapData.put("td", listData);
				actionParam1.add("updateCustomerContact ");
				actionParam1.add(obj.getContactId() + "");
				actionParam2.add("addActivity");
				actionParam2.add(obj.getContactId() + "");
				actionParam3.add("addTicket");
				actionParam3.add(obj.getContactId() + "");
				actionParam4.add("sendSMSContact ");
				actionParam4.add(obj.getContactId() + "");
				actionParam5.add("updateImage ");
				actionParam5.add(obj.getContactId() + "");
				mapAction.put("td", produceActionData(actionParam1, actionParam2, actionParam3, actionParam4, actionParam5));
				listAction.add(mapAction);
				listBody.add(mapData);
			}
			output.put("meta", mapNavi);
			output.put("thead", listHeader);
			output.put("tdalign", listBodyAlign);
			output.put("tbody", listBody);
			output.put("action", listAction);
			if (AppRun().equals("0")) {
				SOP("output==========ContactService==========" + output.toString());
			}
		}

		return output;
	}
	private ArrayList<HashMap> produceActionData(ArrayList<String> actionParam1, ArrayList<String> actionParam2, ArrayList<String> actionParam3, ArrayList<String> actionParam4,
			ArrayList<String> actionParam5) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Contact Person");
		mapBodyData.put("param", actionParam1);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Add Activity");
		mapBodyData.put("param", actionParam2);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Add Ticket");
		mapBodyData.put("param", actionParam3);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Send SMS");
		mapBodyData.put("param", actionParam4);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Update Photo");
		mapBodyData.put("param", actionParam5);
		listAction.add((HashMap) mapBodyData.clone());

		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "activity.*"));
		list.add(buildSmartArr("Contact ID", "numeric", "contact.contactId"));
		list.add(buildSmartArr("Contact Name", "text", "contact.contactFname"));
		list.add(buildSmartArr("Client ID", "numeric", "customers.customerId"));
		list.add(buildSmartArr("Client Name", "text", "contact.customerName"));
		list.add(buildSmartArr("Branch ID", "numeric", "branch.branchId"));
		list.add(buildSmartArr("Branch Name", "text", "branch.branchName"));
		list.add(buildSmartArr("Mobile", "text", "contact.contactMobile1"));
		list.add(buildSmartArr("Phone", "text", "contact.contactPhone1"));
		list.add(buildSmartArr("Email", "text", "contact.contactEmail1)"));
		// list.add(buildSmartArr("Job Title", "text", "contact."));
		// list.add(buildSmartArr("Location", "text", "contact."));
		// list.add(buildSmartArr("Fax1", "text", "contact."));
		// list.add(buildSmartArr("Fax2", "text", "contact."));
		// list.add(buildSmartArr("Website1", "text", "contact."));
		// list.add(buildSmartArr("Website2", "text", "contact."));
		list.add(buildSmartArr("Address", "text", "contact.contactAddress"));
		list.add(buildSmartArr("Yahoo", "text", "contact.contactYahoo"));
		list.add(buildSmartArr("MSN", "text", "contact.contactMsn"));
		list.add(buildSmartArr("AOL", "text", "contact.contactAol"));
		list.add(buildSmartArr("Skype", "text", "contact.contactSkype"));
		list.add(buildSmartArr("Landmark", "text", "contact.contactLandmark"));
		// list.add(buildSmartArr("Group", "text", "contact."));
		list.add(buildSmartArr("DOB", "date", "contact.contactDob"));
		list.add(buildSmartArr("Anniversary", "date", "contact.contactAnniversary"));
		list.add(buildSmartArr("Active", "boolean", "contact.contactActive"));
		list.add(buildSmartArr("Notes", "text", "contact.contactNotes"));
		// list.add(buildSmartArr("Entry By", "numeric", "contact.contactEntryId"));
		list.add(buildSmartArr("Entry Date", "date", "contact.contactEntryDate"));
		// list.add(buildSmartArr("Modified By", "numeric", "contact.contactModifiedId"));
		list.add(buildSmartArr("Modified Date", "date", "contact.contactModifiedDate"));
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

		List<AxelaCustomerContact> contactsList = customerFilterImpl.findAllCostactsForLanding(strSearch);
		if (contactsList != null) {
			for (AxelaCustomerContact obj : contactsList) {
				data = new HashMap();
				data.put("branchId", obj.getBranchId());
				data.put("branchName", obj.getBranchName() + " (" + obj.getBranchCode() + ")");
				data.put("contactsCount", obj.getCustomersCount());
				rec.add(data);
				total += obj.getCustomersCount();
			}
			output.put("contactSummary", rec);
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