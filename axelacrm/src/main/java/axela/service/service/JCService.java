package axela.service.service;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Statement;
import java.text.DecimalFormat;
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
import javax.sql.rowset.CachedRowSet;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.customer.model.AxelaCustomer;
import axela.customer.model.AxelaCustomerContact;
import axela.customer.repository.CustomerContactReposiitory;
//import axela.customer.repository.CustomerContactRepository;
import axela.customer.repository.CustomerRepository;
import axela.inventory.repository.InventoryItemModelRepository;
import axela.inventory.repository.InventoryItemRepository;
import axela.portal.model.AxelaConfig;
import axela.portal.repository.BranchRepository;
import axela.portal.repository.ConfigRepository;
import axela.portal.repository.EmpRepository;
import axela.service.model.AxelaServiceJc;
import axela.service.model.AxelaServiceJcHistory;
import axela.service.repository.JCRepository;
import axela.service.repository.JcFilterImpl;
import axela.service.repository.JobcardHistoryRepository;
import axela.service.repository.ServiceJcFilterImpl;
import axela.service.repository.jcCategoryRepository;
import axela.service.repository.jcTypeRepository;
import axela.service.repository.jobCartPriorityRepository;

import com.fasterxml.jackson.annotation.JsonInclude;

@Service
@JsonInclude
public class JCService extends Connect {
	private final static int PAGESIZE = 25;
	public int jcId = 0;
	public String jcEmpId = "0";
	public String empRoleId = "0";
	public String addB = "";
	public String StrSql = "";
	public String msg = "";
	public String jcNo = "";
	public String jcTimePromised = "";
	public String jcCustomerId = "0";

	public String jcItemId = "0";
	public String jcNetamt = "0";
	public String jcDiscamt = "0";
	public String jcTotaltax = "0";

	public String selectedCustomerId = "0";
	public String jcTechnicianEmpId = "0";
	public String jcRoNo = "";
	public String jcRefno = "";
	public String jcSerialno = "";
	public String jcActive = "";
	public String jcNotes = "";
	public String jcEntryId = "0";
	public String jcModifiedId = "0";
	public String jcEntryBy = "";
	public String jcModifiedBy = "";
	public DecimalFormat deci = new DecimalFormat("0.00");
	public String BranchAccess = "";
	public String contactTitleId = "0";
	public String jcTimeIn = "";
	public String contactName = "";

	public String jcName = "";
	public String jcBillAddress = "";
	public String jcBillCity = "";
	public String jcBillState = "";
	public String jcBillCountry = "";
	public String jcBillPin = "";
	public String jcDelAddress = "";
	public String jcDelState = "";
	public String jcDelCountry = "";
	public String jcDelCity = "";
	public String jcDelPin = "";
	public String jcAmt = "0";
	public String jcServiceTax = "0";
	public String Tax = "";
	public String jcGrandtotal = "0";
	public String jcCustomerVoice = "";
	public String jcTerms = "";
	public String jcAdvice = "";
	public String jcPo = "";
	public String configServiceJobcardRefno = "";
	public String configServiceJobcardSerialnoMandatory = "";
	public String configInventoryLocationName = "";
	public String configCustomerAddress = "";
	public String configServiceJobcardType = "0";
	public String configServiceJobcardCat = "0";
	public String QueryString = "";
	public String jcContactId = "0";
	public Connection conntx = null;
	public Statement stmttx = null;
	public String itemModelId = "0";
	public String jcInstructions = "";
	public String jcJctypeId = "0";
	public String jcBranchId = "0";
	public String jcPriorityjcId = "0";
	// public String emp_branch_id = "0";
	// public String branch_name = "";
	// public String jc_jcstatus_id = "0";
	public String jcJccatId = "0";
	public String jcLocationId = "0";
	public String jcJcstatusId = "0";
	// public String comp_module_inventory = "0";
	// public String config_inventory_current_stock = "0";
	public String empFormatdate = "";
	public String formatdateDatepicker = "";
	public String empFormattime = "";
	public String formattimeTimepicker = "";
	public String empEditperm = "";
	public String configCustomerName = "";
	public String customerDisplay = "none";
	public String empUuid = "";
	public int empId = 0;
	public String theme = "";
	public String add = "";
	public String status = "";
	public String orderByField = "";
	public CachedRowSet crs = null;
	public String populatedata = "";
	public String onchange = "";
	public String requestType = "";
	public String empFormatDate = "";
	public String keyword = "", value = "";
	public int customerBranchId = 0;
	HashMap output = null;
	JSONObject inputObj = null;
	public String jcModifiedDate = "";
	public String jcTitle = "";
	public int contactId = 0;
	public int customerId = 0;
	public String jcOpen = "";
	public String jcAuth = "";
	public String jcAuthDate = "";
	public String jcCritical = "";
	public String jcEntryDate = "";
	public String jcTimeOut = "";
	public String customerName = "";
	public String jcTimeReady = "";
	public String contactFname = "";
	public String contactMobile2 = "";
	public String contactMobile1 = "";
	public String contactEmail1 = "";
	public String contactAddress = "";
	public String contactLname = "";
	public String orderType = "";
	public String contactCityId = "0";
	public String contactEmail2 = "";
	public String contactPin = "";
	private String compId;
	public String branchAccess = "";
	public String exeAccess = "";
	public String perPage = "0";
	public String sort = "";
	public String field;
	public String app = "";
	private String starttime = "";
	private String endtime = "";
	private String drBranchId = "0";
	private String startTime = "";
	private String endTime = "";
	private String branchId = "0";
	public int page = 0;
	public Date timeZone = null;

	@Autowired
	public JCRepository jcrepository;

	@Autowired
	ServiceJcFilterImpl serviceJcFilterImpl;

	@Autowired
	private JcFilterImpl jcfilter;

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private jcCategoryRepository jccategoryrepository;

	@Autowired
	private jcTypeRepository jctyperepository;

	@Autowired
	private InventoryItemRepository inventoryitemrepository;

	@Autowired
	private InventoryItemModelRepository inventoryitemmodelrepository;

	@Autowired
	private jobCartPriorityRepository jobcartpriorityrepository;

	@Autowired
	public CustomerContactReposiitory ContactRepository;

	@Autowired
	public CustomerRepository customerRepository;

	@Autowired
	public JobcardHistoryRepository jobcardhistoryrepository;

	@Autowired
	private JcFilterImpl jcFilterImpl;
	@Autowired
	EmpRepository empRepository;

	@Autowired
	public ConfigRepository axelaConfigRepository;

	public int length = 0;
	public String strSearch = "";

	public Map jobCardService(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		compId = CNumeric(GetSession("comp_id", request)) + "";
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("inputObj========ticketService==========" + inputObj.toString(1));
		}
		output = new HashMap();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		timeZone = getTimeByZone(session);
		List<AxelaConfig> axelaConfig = axelaConfigRepository.findAll();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<String, String>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for (AxelaConfig config : axelaConfig) {
			configCustomerName = config.getConfigCustomerName();
			configServiceJobcardCat = config.getConfigServiceJobcardCat();
			configCustomerAddress = config.getConfigCustomerAddress();
			configServiceJobcardType = config.getConfigServiceJobcardType();
			configServiceJobcardSerialnoMandatory = config.getConfigServiceJobcardSerialnoMandatory();

		}
		// PopulateConfigDetails(empId);
		switch (requestType) {
			case "add" : // add an jobcard.
				if (!returnPerm("emp_service_jobcard_add", session)) {
					output.put("errorPage", "Access denied. Please contact system administrator!");
					return output;
				}
				jcId = 0;
				getValues(inputObj);
				addFields(response, session);
				break;

			case "update" :// update an jobcard.
				jcId = 0;
				getValues(inputObj);
				addFields(response, session);
				break;

			case "delete" :// delete an jobcard.
				if (!returnPerm("emp_service_jobcard_delete", session)) {
					output.put("errorPage", "Access denied. Please contact system administrator!");
					return output;
				}
				if (!inputObj.isNull("jcId")) {
					jcId = Integer.parseInt(inputObj.getString("jcId"));
				}
				if (jcId != 0) {
					deleteFields(jcId);
				}
				break;

			case "landing" :// landingPage of an jobcard.
				if (!inputObj.isNull("startTime")) {
					startTime = PadQuotes(inputObj.getString("startTime"));
				}
				if (!inputObj.isNull("endTime")) {
					endTime = PadQuotes(inputObj.getString("endTime"));
				}
				String date = "";
				if (startTime.equals("") || endTime.equals("")) {
					date = sdf.format(getTimeByZone(session));
				}
				if (startTime.equals("")) {
					startTime = ReportStartdate(date, empFormatdate);
				}
				if (endTime.equals("")) {
					endTime = formatDate(date, empFormatdate);
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
		if (AppRun().equals("0")) {
			SOP("output========ticketService==========" + output);
		}
		return output;
	}
	public void getValues(JSONObject inputObj) throws JSONException, ParseException {
		if (!inputObj.isNull("contactId")) {
			contactId = Integer.parseInt(CNumeric(inputObj.getString("contactId")));
		} else {
			contactId = 0;
		}
		if (!inputObj.isNull("customerId")) {
			customerId = Integer.parseInt(CNumeric(inputObj.getString("customerId")));
		}
		if (!inputObj.isNull("jcEmpId")) {
			jcEmpId = CNumeric(inputObj.getString("jcEmpId"));
		}

		if (contactId == 0) {
			// if (!inputObj.isNull("emp_branch_id")) {
			// emp_branch_id = CNumeric(inputObj.getString("emp_branch_id"));
			// System.out.println("branch_id=================" + emp_branch_id);
			// }
			//
			// if (!inputObj.isNull("branch_name")) {
			// branch_name = PadQuotes(inputObj.getString("branch_name"));
			// }
			if (!inputObj.isNull("customerName")) {
				customerName = PadQuotes(inputObj.getString("customerName"));
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
			if (!inputObj.isNull("contactMobile1")) {
				contactMobile1 = PadQuotes(inputObj.getString("contactMobile1"));
			}
			if (!inputObj.isNull("contactEmail1")) {
				contactEmail1 = PadQuotes(inputObj.getString("contactEmail1"));
			}
			if (!inputObj.isNull("contactMobile2")) {
				contactMobile2 = PadQuotes(inputObj.getString("contactMobile2"));
			}
			if (!inputObj.isNull("contactEmail2")) {
				contactEmail2 = PadQuotes(inputObj.getString("contactEmail2"));
			}
			if (!inputObj.isNull("contactAddress")) {
				contactAddress = PadQuotes(inputObj.getString("contactAddress"));
			}
			if (!inputObj.isNull("contactPin")) {
				contactPin = PadQuotes(inputObj.getString("contactPin"));
			}
			if (!inputObj.isNull("contactCityId")) {
				contactCityId = CNumeric(PadQuotes(inputObj.getString("contactCityId")));
			}

		}

		if (!inputObj.isNull("jcId")) {
			jcId = Integer.parseInt(CNumeric(PadQuotes(inputObj.getString("jcId"))));
		}
		if (!inputObj.isNull("jcBillAddress")) {
			jcBillAddress = PadQuotes(inputObj.getString("jcBillAddress"));
		}
		if (!inputObj.isNull("jcBillCity")) {
			jcBillCity = PadQuotes(inputObj.getString("jcBillCity"));
		}
		if (!inputObj.isNull("jcBillState")) {
			jcBillState = PadQuotes(inputObj.getString("jcBillState"));
		}
		if (!inputObj.isNull("jcBillCountry")) {
			jcBillCountry = PadQuotes(inputObj.getString("jcBillCountry"));
		}
		if (!inputObj.isNull("jcBillPin")) {
			jcBillPin = PadQuotes(inputObj.getString("jcBillPin"));
		}
		if (!inputObj.isNull("jcDelAddress")) {
			jcDelAddress = PadQuotes(inputObj.getString("jcDelAddress"));
		}
		if (!inputObj.isNull("jcDelCity")) {
			jcDelCity = PadQuotes(inputObj.getString("jcDelCity"));
		}
		if (!inputObj.isNull("jcDelState")) {
			jcDelState = PadQuotes(inputObj.getString("jcDelState"));
		}
		if (!inputObj.isNull("jcDelCountry")) {
			jcDelCountry = PadQuotes(inputObj.getString("jcDelCountry"));
		}
		if (!inputObj.isNull("jcDelPin")) {
			jcDelPin = PadQuotes(inputObj.getString("jcDelPin"));
		}
		if (!inputObj.isNull("jcTitle")) {
			jcTitle = PadQuotes(inputObj.getString("jcTitle"));
		}
		// if (!inputObj.isNull("jcTitle")) {
		// jcTitle = PadQuotes(inputObj.getString("empBranchId"));
		// }
		// if (!inputObj.isNull("jc_customer_voice")) {
		// jc_customer_voice = PadQuotes(inputObj.getString("emp_branch_id"));
		// }
		if (!inputObj.isNull("jcAdvice")) {
			jcAdvice = PadQuotes(inputObj.getString("jcAdvice"));
		}
		if (!inputObj.isNull("jcTerms")) {
			jcTerms = PadQuotes(inputObj.getString("jcTerms"));
		}
		if (!inputObj.isNull("jcInstructions")) {
			jcInstructions = PadQuotes(inputObj.getString("jcInstructions"));
		}
		if (!inputObj.isNull("jcRoNo")) {
			jcRoNo = PadQuotes(inputObj.getString("jcRoNo"));
		}
		// if (!inputObj.isNull("emp_id")) {
		// emp_id = CNumeric(inputObj.getString("emp_branch_id"));
		// }
		if (!inputObj.isNull("jcTechnicianEmpId")) {
			jcTechnicianEmpId = CNumeric(inputObj.getString("jcTechnicianEmpId"));
		}
		if (!inputObj.isNull("jcRefno")) {
			jcRefno = PadQuotes(inputObj.getString("jcRefno"));
		}

		if (!inputObj.isNull("jcAuth")) {
			jcAuth = PadQuotes(inputObj.getString("jcAuth"));
		}
		if (!inputObj.isNull("jcTimeOut")) {
			jcTimeOut = PadQuotes(inputObj.getString("jcTimeOut"));
		}

		if (!inputObj.isNull("jcTimeReady")) {
			jcTimeReady = PadQuotes(inputObj.getString("jcTimeReady"));
		}
		if (!inputObj.isNull("jcAuthDate")) {
			jcAuthDate = PadQuotes(inputObj.getString("jcAuthDate"));
		}
		if (!inputObj.isNull("jcCritical")) {
			jcCritical = inputObj.getString("jcCritical");
		}
		if (!inputObj.isNull("jcOpen")) {
			jcOpen = PadQuotes(inputObj.getString("jcOpen"));
		}
		if (!inputObj.isNull("jcCustomerVoice")) {
			jcCustomerVoice = PadQuotes(inputObj.getString("jcCustomerVoice"));
		}

		if (!inputObj.isNull("jcSerialno")) {
			jcSerialno = PadQuotes(inputObj.getString("jcSerialno"));
		}
		if (!inputObj.isNull("jcJctypeId")) {
			jcJctypeId = CNumeric(inputObj.getString("jcJctypeId"));
		}
		if (!inputObj.isNull("jcBranchId")) {
			jcBranchId = CNumeric(inputObj.getString("jcBranchId"));
		}
		if (!inputObj.isNull("jcTimeIn")) {
			jcTimeIn = inputObj.getString("jcTimeIn");
		}
		if (!inputObj.isNull("jcTimePromised")) {
			jcTimePromised = inputObj.getString("jcTimePromised");
		}

		if (!inputObj.isNull("jcItemId")) {
			jcItemId = CNumeric(inputObj.getString("jcItemId"));
		}
		if (!inputObj.isNull("jcJccatId")) {
			jcJccatId = CNumeric(inputObj.getString("jcJccatId"));
		}

		if (!inputObj.isNull("jcJcstatusId")) {
			jcJcstatusId = CNumeric(inputObj.getString("jcJcstatusId"));
		}

		if (!inputObj.isNull("jcPriorityjcId")) {
			jcPriorityjcId = CNumeric(inputObj.getString("jcPriorityjcId"));
		}

		if (!inputObj.isNull("itemModelId")) {
			itemModelId = CNumeric(inputObj.getString("itemModelId"));
		}

		if (!inputObj.isNull("jcItemId")) {
			jcItemId = CNumeric(inputObj.getString("jcItemId"));
		}

		if (!inputObj.isNull("jcLocationId")) {
			jcLocationId = CNumeric(inputObj.getString("jcLocationId"));
		}

		// if (!inputObj.isNull("jc_location_id")) {
		// jc_location_id = CNumeric(inputObj.getString("emp_branch_id"));
		// }
		// axelaservicejc.setJcJcstatusId(1);

		// axelaservicejc.setJcPriorityjcId(1);
		//
		if (!inputObj.isNull("jcTimeOut")) {
			jcTimeOut = PadQuotes(inputObj.getString("jcTimeOut"));
		}
		if (!inputObj.isNull("jcEntryDate")) {
			jcEntryDate = PadQuotes(inputObj.getString("jcEntryDate"));
		}
		// if (!inputObj.isNull("jc_active")) {
		// jc_active = PadQuotes(inputObj.getString("emp_branch_id"));
		// }
		if (!inputObj.isNull("jcNotes")) {
			jcNotes = PadQuotes(inputObj.getString("jcNotes"));
		}
	}

	public void validateFields() {
		msg = "";
		if (jcTitle.equals("")) {
			msg += "<br>Enter Job Card Title!";
		}

		if (jcBranchId.equals("0")) {
			msg += "<br>Select Branch!";
		}

		// if (jcTimeIn.equals("")) {
		// msg += "<br>Enter Job Card Date!";
		// } else {
		// if (isValidDateFormat(jcTimeIn, empFormatdate + " " + empFormattime)) {
		// jcTimeIn = FormatDateStr(jcTimeIn, empFormatdate + " " + empFormattime);
		// } else {
		// jcTimeIn = jcTimeIn;
		// msg += "<br>Enter valid Job Card Date!";
		// jcTimeIn = "";
		// }
		// }
		//
		// if (jcTimePromised.equals("")) {
		// msg += "<br>Enter Promised Time!";
		// } else {
		// if (isValidDateFormat(jcTimePromised, empFormatdate + " " + empFormattime)) {
		// jcTimePromised = FormatDateStr(jcTimePromised, empFormatdate + " " + empFormattime);
		// } else {
		// jcTimePromised = jcTimePromised;
		// msg += "<br>Enter valid Promised Time!";
		// jcTimePromised = "";
		// }
		// }

		// if (!jcTimeIn.equals("") && !jcTimePromised.equals("")) {
		// if (isValidDateFormat(jcTimeIn, empFormatdate + " " + empFormattime) && isValidDateFormat(jcTimePromised, empFormatdate + " " + empFormattime)) {
		// if (Long.parseLong(jcTimeIn) > Long.parseLong(jcTimePromised)) {
		// msg += "<br>Promised Time should be greater than Job Card Date!";
		// }
		// }
		// }

		// if (jc_jcstatus_id.equals("0")) {
		// msg += "<br>Select status!";
		// }

		if (jcJcstatusId.equals("0")) {
			// jcJcstatusId = "1";
			msg += "<br>Select status!";
		}

		if (itemModelId.equals("0")) {
			msg += "<br>Select Model!";
		}

		if (jcItemId.equals("0")) {
			msg += "<br>Select Item!";
		}
		if (configServiceJobcardType.equals("1")) {
			if (jcJctypeId.equals("0")) {
				msg += "<br>Select Type!";
			}
		}
		if (configServiceJobcardCat.equals("1")) {
			if (jcJccatId.equals("0")) {
				msg += "<br>Select Category!";
			}
		}

		if (customerName.equals("") && contactId == 0) {
			msg += "<br>Enter Customer!";
		}

		if (add.equals("yes") && contactId == 0) {
			if (contactTitleId.equals("0")) {
				msg += "<br>Select Contact Title!";
			}

			if (contactFname.equals("")) {
				msg += "<br>Enter Contact First Name!";
			} else {
				contactFname = toTitleCase(contactFname);
			}

			if (!contactLname.equals("")) {
				contactLname = toTitleCase(contactLname);
			}

			if (contactMobile1.equals("")) {
				msg += "<br>Enter Mobile No.!";
			}

			if (!contactMobile1.equals("") && !IsValidMobileNo(contactMobile1)) {
				msg += "<br>Mobile1 is Invalid!";
			}

			// if (!contact_mobile2.equals("") && !IsValidMobileNo(contact_mobile2)) {
			// msg += "<br>Mobile2 is Invalid!";
			// }
			//
			// if (contact_email1.equals("") && contact_email2.equals("")) {
			// msg += "<br>Enter Email ID!";
			// }

			// if (!contact_email1.equals("")) {
			// if (!IsValidEmail(contact_email1)) {
			// msg += "<br>Email1 is invalid!";
			// } else {
			// contact_email1 = contact_email1.toLowerCase();
			// }
			// }
			//
			// if (!contact_email2.equals("")) {
			// if (!IsValidEmail(contact_email2)) {
			// msg += "<br>Email2 is invalid!";
			// } else {
			// contact_email2 = contact_email2.toLowerCase();
			// }
			// }

			// if (!contact_email1.equals("")
			// && !contact_email2.equals("")
			// && contact_email2.equals(contact_email1)) {
			// msg += "<br>Email2 is same as Email1!";
			// }

			if (configCustomerAddress.equals("1") && contactAddress.equals("")) {
				msg += "<br>Enter Contact Address!";
			}

			if (contactCityId.equals("0")) {
				msg += "<br>Select Contact City!";
			}

			if (configCustomerAddress.equals("1") && contactPin.equals("")) {
				msg += "<br>Enter Contact Pin!";
			} else if (!contactPin.equals("") && !isNumeric(contactPin)) {
				msg += "<br>Contact Pin: Enter Numeric!";
			}
		}

		if (jcSerialno.equals("") && configServiceJobcardSerialnoMandatory.equals("1")) {
			msg += "<br>Enter Serial No.!";
		} else if (!jcSerialno.equals("")) {
			if (jcSerialno.length() < 2) {
				msg += "<br>Serial No. Should be Atleast Two Characters!";
			}
		}

		// if (!jc_bill_address.equals("") || !jc_bill_city.equals("")
		// || !jc_bill_pin.equals("") || !jc_bill_state.equals("") || !jc_bill_country.equals("")) {
		// if (jc_bill_address.equals("")) {
		// msg += "<br>Enter Billing Address!";
		// }
		//
		// if (jc_bill_city.equals("")) {
		// msg += "<br>Enter Billing City!";
		// }
		//
		// if (jc_bill_pin.equals("")) {
		// msg += "<br>Enter Billing Pin!";
		// }
		//
		// if (jc_bill_state.equals("")) {
		// msg += "<br>Enter Billing State!";
		// }
		//
		// if (jc_bill_country.equals("")) {
		// msg += "<br>Enter Billing Country!";
		// }
		// }
		//
		// if (!jc_del_address.equals("") || !jc_del_city.equals("") || !jc_del_pin.equals("")
		// || !jc_del_state.equals("") || !jc_del_country.equals("")) {
		// if (jc_del_address.equals("")) {
		// msg += "<br>Enter Delivery Address!";
		// }
		//
		// if (jc_del_city.equals("")) {
		// msg += "<br>Enter Delivery City!";
		// }
		//
		// if (jc_del_pin.equals("")) {
		// msg += "<br>Enter Delivery Pin!";
		// }
		//
		// if (jc_del_state.equals("")) {
		// msg += "<br>Enter Delivery State!";
		// }
		//
		// if (jc_del_country.equals("")) {
		// msg += "<br>Enter Delivery Country!";
		// }
		// }

		if (jcCustomerVoice.equals("")) {
			msg += "<br>Enter " + configCustomerName + " Voice!";
		}

		// if (config_service_jobcard_refno.equals("1")) {
		// if (jcRefno.equals("")) {
		// msg += "<br>Enter Reference No.!";
		// } else {
		// if (!isNumeric(jcRefno)) {
		// msg += "<br>Enter Numeric Reference No.!";
		// } else if (jcRefno.length() < 2) {
		// msg += "<br>Reference No. Should be Atleast Two Digits!";
		// } else {
		// StrSql = "SELECT jc_refno FROM " + compdb(comp_id) + "axela_service_jc"
		// + " WHERE jc_branch_id = " + jc_branch_id + ""
		// + " AND jc_refno = '" + jc_refno + "'";
		// if (!ExecuteQuery(StrSql).equals("")) {
		// msg += "<br>Similar Ref No. found!";
		// }
		// }
		// }
		// }

		if (jcPriorityjcId.equals("0")) {
			msg += "<br>Select Priority!";
		}

		// if (jcLocationId.equals("0") && comp_module_inventory.equals("1")
		// && config_inventory_current_stock.equals("1")) {
		// msg += "<br>Select Select Inventory Location!";
		// }

		if (jcEmpId.equals("0")) {
			msg += "<br>Select Executive!";
		}

		if (jcTechnicianEmpId.equals("0")) {
			msg += "<br>Select Technician!";
		}

		// if (jc_jcstatus_id.equals("6")) {
		// if (!jc_ro_no.equals("") && jc_ro_no.length() < 2) {
		// msg += "<br>RO No. should be atleast Two Digits!";
		// } else {
		// StrSql = "SELECT jc_ro_no FROM axela_service_jc"
		// + " WHERE jc_branch_id = " + jc_branch_id + ""
		// + " AND jc_ro_no = '" + jc_ro_no + "'";
		// if (!ExecuteQuery(StrSql).equals("") && add.equals("yes")) {
		// msg += "<br>Similar RO No. found!";
		// }
		// }
		// // else {
		// // msg += "<br>Enter RO No.!";
		// // }
		// }
	}

	public void addFields(HttpServletResponse response, HttpSession session) throws ParseException {
		validateFields();
		output = new HashMap();
		AxelaServiceJc axelaservicejc = null;
		if (msg.equals("")) {
			SOP("jcId=======asa=========" + jcId);
			if (jcId == 0) {
				axelaservicejc = new AxelaServiceJc();
			} else {
				axelaservicejc = jcrepository.findOne(jcId);
			}
			if (contactId == 0) {
				AxelaCustomer axelaCustomer = new AxelaCustomer();
				axelaCustomer.setCustomerBranchId(0);
				axelaCustomer.setCustomerName(customerName);
				axelaCustomer.setCustomerMobile1(contactMobile1);
				axelaCustomer.setCustomerMobile2(contactMobile2);
				axelaCustomer.setCustomerEmail1(contactEmail1);
				axelaCustomer.setCustomerEntryDate(timeZone);
				axelaCustomer.setCustomerEntryId(empId);
				axelaCustomer.setCustomerModifiedId(0);
				axelaCustomer.setCustomerActive("1");
				axelaCustomer.setCustomerAddress1(contactAddress);
				axelaCustomer.setCustomerAddress2(contactAddress);
				axelaCustomer.setCustomerCityId(Integer.parseInt(contactCityId));
				axelaCustomer.setCustomerEmpId(empId);
				// axelaCustomer.setCustomerSince(stringToDate(""));
				axelaCustomer.setCustomerAddress2("");
				axelaCustomer.setCustomerArnNo("");
				axelaCustomer.setCustomerCode("");
				axelaCustomer.setCustomerEmail2("");
				axelaCustomer.setCustomerFax1("");
				axelaCustomer.setCustomerFax2("");
				axelaCustomer.setCustomerGstDocValue("");
				axelaCustomer.setCustomerGstNo("");
				// axelaCustomer.setCustomerGstRegdate("");
				axelaCustomer.setCustomerItstatusId("0");
				axelaCustomer.setCustomerLandmark("");
				axelaCustomer.setCustomerLedgertype(0);
				axelaCustomer.setCustomerMobile2("");
				axelaCustomer.setCustomerNotes("");
				axelaCustomer.setCustomerPanNo("");
				axelaCustomer.setCustomerPhone1("");
				axelaCustomer.setCustomerPhone2("");
				axelaCustomer.setCustomerPhone3("");
				axelaCustomer.setCustomerPhone4("");
				axelaCustomer.setCustomerPin("");
				axelaCustomer.setCustomerReconciliation("");
				axelaCustomer.setCustomerServiceTaxNo("");
				// axelaCustomer.setCustomerSince(stringToDate(""));
				axelaCustomer.setCustomerTax("");
				axelaCustomer.setCustomerTds("");
				axelaCustomer.setCustomerTinNo("");
				axelaCustomer.setCustomerWebsite1("");
				axelaCustomer.setCustomerWebsite2("");
				customerId = customerRepository.save(axelaCustomer).getCustomerId();
				AxelaCustomerContact axelaCustomerContact = new AxelaCustomerContact();
				axelaCustomerContact.setContactTitleId(Integer.parseInt(contactTitleId));
				axelaCustomerContact.setContactFname(contactFname);
				axelaCustomerContact.setContactLname(contactLname);
				axelaCustomerContact.setContactActive("1");
				axelaCustomerContact.setContactAddress(contactAddress);
				axelaCustomerContact.setContactAol("");
				axelaCustomerContact.setContactCityId(contactCityId);
				axelaCustomerContact.setContactCustomerId(customerId);
				axelaCustomerContact.setContactDnd("");
				// axelaCustomerContact.setContactDob(stringToDate(""));
				axelaCustomerContact.setContactEmail1(contactEmail1);
				axelaCustomerContact.setContactEmail2(contactEmail2);
				axelaCustomerContact.setContactJobtitle("");
				axelaCustomerContact.setContactLandmark("");
				axelaCustomerContact.setContactLocation("");
				axelaCustomerContact.setContactMobile1(contactMobile1);
				axelaCustomerContact.setContactMobile2(contactMobile2);
				axelaCustomerContact.setContactSkype("");
				axelaCustomerContact.setContactYahoo("");
				axelaCustomerContact.setContactPhone1("");
				axelaCustomerContact.setContactPhone2("");
				axelaCustomerContact.setContactMsn("");
				axelaCustomerContact.setContactPin(contactPin);
				axelaCustomerContact.setContactNotes("");
				axelaCustomerContact.setContactEntryDate(timeZone);
				axelaCustomerContact.setContactEntryId(empId);
				// axelaCustomerContact.setContactModifiedDate(stringToDate(""));
				axelaCustomerContact.setContactModifiedId(0);
				contactId = ContactRepository.save(axelaCustomerContact).getContactId();
			}
			axelaservicejc.setJcBranchId(Integer.parseInt(jcBranchId));
			axelaservicejc.setJcTimeIn(stringToDate(jcTimeIn));
			axelaservicejc.setJcTimePromised(stringToDate(jcTimePromised));
			axelaservicejc.setJcContactId(contactId);
			axelaservicejc.setJcCustomerId(customerId);
			axelaservicejc.setJcItemId(Integer.parseInt(jcItemId));
			axelaservicejc.setJcJctypeId(Integer.parseInt(jcJctypeId));
			axelaservicejc.setJcJccatId(Integer.parseInt(jcJccatId));
			axelaservicejc.setJcEmpId(Integer.parseInt(jcEmpId));
			axelaservicejc.setJcBillAddress(jcBillAddress);
			axelaservicejc.setJcBillCity(jcBillCity);
			axelaservicejc.setJcBillPin(jcBillPin);
			axelaservicejc.setJcBillState(jcBillState);
			axelaservicejc.setJcBillCountry(jcBillCountry);
			axelaservicejc.setJcDelAddress(jcDelAddress);
			axelaservicejc.setJcDelCity(jcDelCity);
			axelaservicejc.setJcDelPin(jcDelPin);
			axelaservicejc.setJcDelState(jcDelState);
			axelaservicejc.setJcDelCountry(jcDelCountry);
			axelaservicejc.setJcTitle(jcTitle);
			axelaservicejc.setJcAuth(jcAuth);
			axelaservicejc.setJcTimeOut(stringToDate(jcTimeOut));
			axelaservicejc.setJcTimeReady(stringToDate(jcTimeReady));
			axelaservicejc.setJcAuthDate(stringToDate(jcAuthDate));
			axelaservicejc.setJcCritical("1");
			axelaservicejc.setJcOpen(jcOpen);
			axelaservicejc.setJcCustomerVoice(jcCustomerVoice);
			axelaservicejc.setJcAdvice(jcAdvice);
			axelaservicejc.setJcTerms(jcTerms);
			axelaservicejc.setJcInstructions(jcInstructions);
			axelaservicejc.setJcRoNo(jcRoNo);
			axelaservicejc.setJcTechnicianEmpId(Integer.parseInt(jcTechnicianEmpId));
			axelaservicejc.setJcRefno(jcRefno);
			axelaservicejc.setJcSerialno(jcSerialno);
			axelaservicejc.setJcJcstatusId(Integer.parseInt(jcJcstatusId));
			// axelaservicejc.item_model_id = item_model_id;
			// axelaservicejc.jc_location_id = CNumeric(ExecuteQuery("SELECT branch_location_id FROM " + compdb(comp_id) + "axela_branch WHERE branch_id =  " + jc_branch_id + ""));
			axelaservicejc.setJcLocationId(Integer.parseInt(jcLocationId));
			axelaservicejc.setJcPriorityjcId(Integer.parseInt(jcPriorityjcId));
			axelaservicejc.setJcActive(jcActive);
			axelaservicejc.setJcNotes(jcNotes);
			if (requestType.equals("add")) {
				axelaservicejc.setJcEntryId(empId);
				axelaservicejc.setJcEntryDate(timeZone);
				axelaservicejc.setJcModifiedId(0);
			} else if (requestType.equals("update")) {
				axelaservicejc.setJcEntryId(axelaservicejc.getJcEntryId());
				axelaservicejc.setJcEntryDate(axelaservicejc.getJcEntryDate());
				axelaservicejc.setJcModifiedDate(timeZone);
				axelaservicejc.setJcModifiedId(empId);
			}
			jcId = jcrepository.save(axelaservicejc).getJcId();
			if (requestType.equals("add")) {
				AxelaServiceJcHistory axelaservicejchistory = new AxelaServiceJcHistory();
				axelaservicejchistory.setHistoryJcId(BigInteger.valueOf(jcId));
				axelaservicejchistory.setHistoryEmpId(empId);
				axelaservicejchistory.setHistoryDatetime(timeZone);
				axelaservicejchistory.setHistoryActiontype("New Jobcard");
				axelaservicejchistory.setHistoryNewvalue("New Jobcard");
				axelaservicejchistory.setHistoryOldvalue("");
				jobcardhistoryrepository.save(axelaservicejchistory);
			}
			if (jcId != 0 && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("successmsg", "Jobcard Added Successfully!<br>");
				output.put("jcId", jcId + "");
			} else if (jcId != 0 && requestType.equals("update")) {
				output.put("successmsg", "Jobcard Updated Successfully!<br>");
				output.put("jcId", jcId + "");
			}
		}
		else {
			// response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public Map<String, List> populateData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			if (!returnPerm("emp_service_jobcard_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			if (!inputObj.isNull("jcId")) {
				jcId = Integer.parseInt((inputObj.getString("jcId")));
			}
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			if (jcId != 0) {
				AxelaServiceJc serviceJc = jcFilterImpl.findOneForDash(jcId);
				HashMap map = new HashMap();
				map.put("jcId", jcId);
				map.put("jcNo", String.valueOf(serviceJc.getJcNo()));
				map.put("jcBranchId", String.valueOf(serviceJc.getJcBranchId()));
				map.put("jcTimeIn", strToLongDate(serviceJc.getJcTimeIn()));
				map.put("jcTimeOut", strToLongDate(serviceJc.getJcTimeOut()));
				map.put("jcTimeReady", strToLongDate(serviceJc.getJcTimeReady()));
				map.put("jcTimePromised", strToLongDate(serviceJc.getJcTimePromised()));
				map.put("jcEmpId", String.valueOf(serviceJc.getJcEmpId()));
				map.put("contactMobile1", String.valueOf(serviceJc.getContactMobile1()));
				map.put("itemModelId", String.valueOf(serviceJc.getItemModelId()));
				map.put("jcTechnicianEmpId", String.valueOf(serviceJc.getJcTechnicianEmpId()));
				map.put("jcRoNo", String.valueOf(serviceJc.getJcRoNo()));
				map.put("jcItemId", String.valueOf(serviceJc.getJcItemId()));
				map.put("jcJctypeId", String.valueOf(serviceJc.getJcJctypeId()));
				map.put("jcJccatId", String.valueOf(serviceJc.getJcJccatId()));
				map.put("jcBayId", String.valueOf(serviceJc.getJcBayId()));
				map.put("jcLocationId", String.valueOf(serviceJc.getJcLocationId()));
				map.put("jcTitle", String.valueOf(serviceJc.getJcTitle()));
				map.put("jcCustomerVoice", String.valueOf(serviceJc.getJcCustomerVoice()));
				map.put("jcAdvice", String.valueOf(serviceJc.getJcAdvice()));
				map.put("customerName", String.valueOf(serviceJc.getJcCustomerName()));
				map.put("jcTerms", String.valueOf(serviceJc.getJcTerms()));
				map.put("jcActive", CNumeric(serviceJc.getJcActive()));
				map.put("jcInstructions", String.valueOf(serviceJc.getJcInstructions()));
				map.put("jcCustomerId", String.valueOf(serviceJc.getJcCustomerId()));
				map.put("jcContactId", String.valueOf(serviceJc.getJcContactId()));
				map.put("jcRefno", String.valueOf(serviceJc.getJcRefno()));
				map.put("jcSerialno", String.valueOf(serviceJc.getJcSerialno()));
				map.put("jcPriorityjcId", String.valueOf(serviceJc.getJcPriorityjcId()));
				map.put("jcNotes", String.valueOf(serviceJc.getJcNotes()));
				map.put("jcJcstatusId", String.valueOf(serviceJc.getJcJcstatusId()));
				map.put("CustomerName", String.valueOf(serviceJc.getJcCustomerName()));
				map.put("contactTitleId", String.valueOf(serviceJc.getContactTitleId()));
				map.put("contactFname", String.valueOf(serviceJc.getContactFname()));
				map.put("contactLname", String.valueOf(serviceJc.getContactLname()));
				map.put("contactPhone1", String.valueOf(serviceJc.getContactPhone1()));
				map.put("contactEmail1", String.valueOf(serviceJc.getContactEmail1()));
				map.put("contactAddress", String.valueOf(serviceJc.getContactAddress()));
				map.put("contactPin", String.valueOf(serviceJc.getContactPin()));
				map.put("contactCityId", String.valueOf(serviceJc.getContactCityId()));
				map.put("jcDelAddress", String.valueOf(serviceJc.getJcDelAddress()));
				map.put("jcDelCity", String.valueOf(serviceJc.getJcDelCity()));
				map.put("jcDelCountry", String.valueOf(serviceJc.getJcDelCountry()));
				map.put("jcDelPin", String.valueOf(serviceJc.getJcDelPin()));
				map.put("jcDelState", String.valueOf(serviceJc.getJcDelState()));
				map.put("jcBillAddress", String.valueOf(serviceJc.getJcBillAddress()));
				map.put("jcBillCity", String.valueOf(serviceJc.getJcBillCity()));
				map.put("jcBillCountry", String.valueOf(serviceJc.getJcBillCountry()));
				map.put("jcBillPin", String.valueOf(serviceJc.getJcBillPin()));
				map.put("jcBillState", String.valueOf(serviceJc.getJcBillState()));
				if (serviceJc.getJcEntryId() != 0) {
					map.put("jcEntryDate", strToShortDate(serviceJc.getJcEntryDate()));
					map.put("jcEntryId", String.valueOf(serviceJc.getJcEntryId()));
					map.put("jcEntryBy", empRepository.findEmpName(serviceJc.getJcEntryId()));
				}
				if (serviceJc.getJcModifiedId() != 0) {
					map.put("jcModifiedDate", strToShortDate(serviceJc.getJcModifiedDate()));
					map.put("jcModifiedId", String.valueOf(serviceJc.getJcModifiedId()));
					map.put("jcModifiedBy", empRepository.findEmpName(serviceJc.getJcModifiedId()));
				}
				list.add(map);
			}

			output.put("populateData", list);
		}
		return output;
	}
	public void deleteFields(int jcId) {
		jcrepository.delete(jcId);
		output.put("successmsg", "Jobcard Deleted Successfully!");
	}

	public Map<String, String> populateLandingDetails(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap();
		String strSearch = "";
		long grandTotal = 0L;
		branchAccess = getSession("branchAccess", session).replaceAll("branchId", "jc.jcBranchId");
		exeAccess = getSession("exeAccess", session).replaceAll("empId", "jc.jcEmpId");
		if (!starttime.equals("")) {
			strSearch = " and substr(jc.jcEntryDate,1,8) >= substr('" + starttime + "',1,8) ";
		}
		if (!endtime.equals("")) {
			strSearch = strSearch + " and substr(jc.jcEntryDate,1,8) <= substr('" + endtime + "',1,8) ";
		}
		if (!drBranchId.equals("0")) {
			strSearch = strSearch + " and jc.jcBranchId=" + drBranchId;
		}
		strSearch = strSearch + " and jc.axelaBranch.branchActive = '1' and jc.jcActive='1'";
		strSearch += branchAccess + exeAccess;
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		LinkedHashMap map = new LinkedHashMap();
		List<Object[]> asset = serviceJcFilterImpl.findBypopulateLanding(strSearch, session);
		for (Object[] results : asset) {
			map.put("branchId", String.valueOf(results[0]));
			map.put("branchName", String.valueOf(results[1]));
			map.put("jcCount", Long.parseLong(String.valueOf(results[2])));
			grandTotal += Long.parseLong(String.valueOf(results[2]));
			list.add(map);
		}
		output.put("populateLandingDetails", list);
		output.put("grandTotal", grandTotal);
		return output;
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			if (!returnPerm("emp_service_jobcard_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			page = 0;
			inputObj = new JSONObject(input);
			requestType = "";
			field = "";
			orderType = "";
			strSearch = "";
			output = new LinkedHashMap<String, String>();
			branchAccess = "";
			exeAccess = "";
			String strOrderBy = "";
			branchAccess = getSession("branchAccess", session).replaceAll("branchId", "jc.jcBranchId");
			exeAccess = getSession("exeAccess", session).replaceAll("empId", "jc.jcEmpId");

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
				field = PadQuotes((inputObj.getString("sortField")));
			}
			if (!inputObj.isNull("pageIndex")) {
				page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
			}
			if (!inputObj.isNull("sortField")) {
				orderByField = PadQuotes((inputObj.getString("sortField")));
			}
			if (!inputObj.isNull("sortDirection")) {
				orderType = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
			}
			perPage = CNumeric(getSession("empRecperpage", session));
			if (orderType.equals("")) {
				orderType = "DESC";
			}
			if (orderByField.equals("")) {
				orderByField = "jcId";
			}
			if (orderType.equals("")) {
				orderType = "DESC";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			strOrderBy = " ORDER BY jc." + orderByField + " " + orderType + "";

			List<AxelaServiceJc> resultSet = jcfilter.findAll(strSearch, strOrderBy, page, Integer.parseInt(perPage), "no");
			String length = JcFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("ID", "jcId", "center"));
			listHeader.add(produceHeaderData("NO", "jcNo", "center"));
			listHeader.add(produceHeaderData("Jobcard", "jcTitle", "left"));
			listHeader.add(produceHeaderData("Customer", "axelaCustomer.customerName", "left"));
			listHeader.add(produceHeaderData("Date", "jcTimeIn", "center"));
			listHeader.add(produceHeaderData("Model", "axelaItem.axelaInventoryItemModel.modelName", "left"));
			listHeader.add(produceHeaderData("Item", "axelaItem.itemName", "left"));
			listHeader.add(produceHeaderData("Type", "axelaServicejcType.jctypeName", "left"));
			listHeader.add(produceHeaderData("Category", "axelaServicejccat.jccatName", "left"));
			listHeader.add(produceHeaderData("Status", "axelaServicejcstatus.jcstatusName", "center"));
			listHeader.add(produceHeaderData("Priority", "axelaServicejcpriority.priorityjcName", "center"));
			listHeader.add(produceHeaderData("Amount", "jcGrandtotal", "center"));
			listHeader.add(produceHeaderData("Executive", "axelaEmp.empName", "left"));
			listHeader.add(produceHeaderData("Branch", "axelaBranch.branchName", "left"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("right"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaServiceJc obj : resultSet) {
				ArrayList<String> paramSubArr = new ArrayList<String>();
				ArrayList<ArrayList> paramArr = new ArrayList<ArrayList>();
				ArrayList type = new ArrayList();
				ArrayList value = new ArrayList();
				HashMap<String, List<HashMap>> mapData = new HashMap<String, List<HashMap>>();
				HashMap<String, List<HashMap>> mapAction = new HashMap<String, List<HashMap>>();
				HashMap<String, List<String>> mapBodyData = new HashMap<String, List<String>>();
				List<HashMap> listData = new ArrayList<HashMap>();
				count++;

				// count
				type.add(false);
				value.add(count);
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// dash
				type.add(true);
				value.add(String.valueOf(obj.getJcId()));
				paramSubArr.add("jobcardDash");
				paramSubArr.add(obj.getJcId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				//
				type.add(false);
				value.add("JC" + (PadQuotes(String.valueOf(obj.getBranchCode()))) + (PadQuotes(String.valueOf(obj.getJcNo()))));
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				//
				type.add(false);
				type.add(false);
				type.add(false);
				type.add(false);
				type.add(false);
				value.add(obj.getJcTitle() + " ");
				if (!obj.getJcCustomerVoice().equals("")) {
					value.add(obj.getJcCustomerVoice() + " ");
				}
				if (!obj.getJcRefno().equals("")) {
					value.add("Ref.No: " + obj.getJcRefno() + " ");
				}
				if (obj.getJcActive().equals("0")) {
					value.add("[Inactive]");
				}
				if (obj.getJcAuth().equals("1")) {
					value.add("[Authorized]");
				}
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// Customer
				type.add(true);
				type.add(true);
				type.add(false);
				type.add(false);
				type.add(false);
				type.add(false);
				type.add(false);
				type.add(false);
				type.add(false);
				value.add(obj.getJcCustomerName() + " ");
				value.add(obj.getContactName() + " ");
				value.add(obj.getContactMobile1() + " ");
				value.add(obj.getContactMobile2() + " ");
				value.add(obj.getContactEmail1() + " ");
				value.add(obj.getContactEmail2() + " ");
				value.add(obj.getContactPhone1() + " ");
				value.add(obj.getContactPhone2() + " ");
				paramSubArr.add("customerList");
				paramSubArr.add(obj.getJcCustomerId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				paramSubArr.clear();
				paramSubArr.add("contactList");
				paramSubArr.add(obj.getJcContactId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				//
				// Date
				type.add(false);
				value.add(strToShortDate(obj.getJcTimeIn()));
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				//

				// item
				type.add(false);
				value.add(obj.getJcItemName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// stage
				type.add(false);
				value.add(obj.getJcModelName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				//
				type.add(false);
				value.add(obj.getJcTypeName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				//
				type.add(false);
				value.add(obj.getJcCatName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				//
				type.add(false);
				value.add(obj.getJcStatusName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				//
				type.add(false);
				value.add(obj.getJcPriorityName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				//
				type.add(false);
				value.add(obj.getJcGrandtotal() + "");
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				//
				// executive
				type.add(false);
				value.add(ExePhotoOval(obj.getJcEmpId() + ""));
				paramArr.add((ArrayList) paramSubArr.clone());
				type.add(true);
				value.add(obj.getEmpName());
				paramSubArr.add("executiveSummary");
				paramSubArr.add(obj.getJcEmpId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// branch
				type.add(true);
				value.add(obj.getJcBranchName());
				paramSubArr.add("branchSummary");
				paramSubArr.add(obj.getJcBranchId() + "");
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
				ArrayList actionParam3 = new ArrayList();
				ArrayList actionParam4 = new ArrayList();
				actionParam.add("updateJobcard");
				actionParam1.add("authorize");
				actionParam2.add("addTicket");
				actionParam3.add("printJobcard");
				actionParam4.add("emailJobcard");
				actionParam.add(PadQuotes(String.valueOf(obj.getJcId())));
				actionParam1.add(PadQuotes(String.valueOf(obj.getJcId())));
				actionParam2.add(PadQuotes(String.valueOf(obj.getJcId())));
				actionParam3.add(PadQuotes(String.valueOf(obj.getJcId())));
				actionParam4.add(PadQuotes(String.valueOf(obj.getJcId())));
				mapAction.put("td", produceActionData(actionParam, actionParam1, actionParam2, actionParam3, actionParam4));
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
	public ArrayList<HashMap> produceActionData(ArrayList<String> Param, ArrayList<String> Param1, ArrayList<String> Param2, ArrayList<String> Param3, ArrayList<String> Param4) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();

		mapBodyData.put("value", "Update Jobcard");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Authorize");
		mapBodyData.put("param", Param1);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Add Ticket");
		mapBodyData.put("param", Param2);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Print Jobcard");
		mapBodyData.put("param", Param3);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Email Jobcard");
		mapBodyData.put("param", Param4);
		listAction.add((HashMap) mapBodyData.clone());

		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();

		list.add(buildSmartArr("Keyword", "text", "jc.*"));
		list.add(buildSmartArr("JC ID", "numeric", "jc.jcId"));
		list.add(buildSmartArr("JC No.", "text", "CONCAT('JC', jc.axelaBranch.branchCode, jc.jcNo)"));
		list.add(buildSmartArr("Branch", "numeric", "jc.axelaBranch.branchName"));
		list.add(buildSmartArr("Customer ID", "numeric", "jc.axelaCustomer.customerId"));
		list.add(buildSmartArr("Contact ID", "numeric", "jc.axelaCustomerContact.contactId"));
		list.add(buildSmartArr("Customer Name", "text", "jc.axelaCustomer.customerName"));
		list.add(buildSmartArr("Contact Name", "text", "CONCAT(title_desc, ' ', jc.axelaCustomerContact.contactFname, ' ', jc.axelaCustomerContact.contactLname)"));
		list.add(buildSmartArr("Contact Mobile", "text", "CONCAT(jc.axelaCustomerContact.contactMobile1, jc.axelaCustomerContact.contactMobile2)"));
		list.add(buildSmartArr("Contact Email", "text", "CONCAT(jc.axelaCustomerContact.contactEmail1, jc.axelaCustomerContact.contactEmail2)"));
		list.add(buildSmartArr("JC Date", "date", "jc.jcTimeIn"));
		list.add(buildSmartArr("Title", "text", "jc.jcTitle"));
		list.add(buildSmartArr("Net Amount", "numeric", "jc.jcNetamt"));
		list.add(buildSmartArr("Discount", "numeric", "jc.jcDiscamt"));
		list.add(buildSmartArr("Tax", "numeric", "jc.jcTotaltax"));
		list.add(buildSmartArr("Total", "numeric", "jc.jcGrandtotal"));
		list.add(buildSmartArr("Billing Address", "text", "CONCAT(jc.jcBillAddress, jc.jcBillCity, jc.jcBillPin, jc.jcBillState, jc.jcBillCountry)"));
		list.add(buildSmartArr("Delivery Address", "text", "CONCAT(jc.jcDelAddress, jc.jcDelCity, jc.jcDelPin, jc.jcDelState, jc.jcDelCountry)"));
		list.add(buildSmartArr("RO No.", "text", "jc.jcRoNo"));
		list.add(buildSmartArr("Ref. No.", "text", "jc.jcRefno"));
		list.add(buildSmartArr("Authorized", "boolean", "jc.jcAuth"));
		// list.add(buildSmartArr("Authorized By", "text", "ServiceJc.jcAuthId IN (SELECT emp_id FROM compdb.axela_emp WHERE emp_name"});// subquery
		list.add(buildSmartArr("Authorized Date", "date", "jc.jcAuthDate"));
		list.add(buildSmartArr("Executive", "text", " jc.axelaEmp.empName"));
		list.add(buildSmartArr("Active", "boolean", "jc.jcActive"));
		list.add(buildSmartArr("Notes", "text", "jc.jcNotes"));
		// list.add(buildSmartArr("Entry By", "text", "jcEntryId IN (SELECT emp_id FROM compdb.axela_emp WHERE emp_name"});
		list.add(buildSmartArr("Entry Date", "date", "jc.jcEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "jc_modified_id IN (SELECT emp_id FROM compdb.axela_emp WHERE emp_name"});
		list.add(buildSmartArr("Modified Date", "date", "jc.jcModifiedDate"));
		// list.add(buildSmartArr("Custom Fields", "text", "jc_id IN (SELECT cftrans_row_id FROM compdb.axela_cf_trans WHERE cftrans_submodule_id = 18 and cftrans_value"));

		output.put("drSmart", list.toArray());
		return output;
	}
}
