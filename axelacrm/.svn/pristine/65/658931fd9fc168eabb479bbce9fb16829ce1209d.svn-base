package axela.app.service.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
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
import javax.sql.rowset.CachedRowSet;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import axela.config.Connect;
import axela.customer.model.AxelaCustomerContact;
import axela.customer.repository.CustomerContactReposiitory;
import axela.customer.repository.CustomerFilterImpl;
import axela.customer.repository.CustomerRepository;
import axela.portal.repository.ConfigRepository;
import axela.portal.repository.EmpRepository;
import axela.service.model.AxelaServiceJc;
import axela.service.repository.JCRepository;
import axela.service.repository.JCRepository.JcFilterRepository;
import axela.service.repository.JcFilterImpl;
import axela.service.repository.JobcardHistoryRepository;
import axela.service.repository.JobcardImgRepository;
import axela.service.service.JCService;
import axela.service.service.JobcardDashService;

@Component
public class JobCardAppService extends Connect {
	public int jcId = 0;
	public String jcEmpId = "0";
	public String addB = "";
	public String StrSql = "";
	public String msg = "";
	public String jcTimePromised = "";
	public String jcItemId = "0";
	public String jcTechnicianEmpId = "0";
	public String jcRoNo = "";
	public String jcRefno = "";
	public String jcSerialno = "";
	public String jcActive = "";
	public String jcNotes = "";
	public String entry_by = "";
	public DecimalFormat deci = new DecimalFormat("0.00");
	public String BranchAccess = "";
	public int contactId = 0;
	public int customerId = 0;
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
	public String Tax = "";
	public String jc_grandtotal = "0";
	public String jcCustomerVoice = "";
	public String jcTerms = "";
	public String jcAdvice = "";
	public String QueryString = "";
	public Connection conntx = null;
	public Statement stmttx = null;
	public String jcInstructions = "";
	public String jcJctypeId = "0";
	public String jcBranchId = "0";
	public String jcPriorityjcId = "0";
	public String jcJccatId = "0";
	public String jcLocationId = "0";
	public String jcJcstatusId = "0";
	public String empEditperm = "";
	public String emp_uuid = "";
	public int empId = 0;
	public String theme = "";
	public String add = "";
	public String status = "";
	public String day = "";
	public String month = "";
	public String year = "";
	public CachedRowSet crs = null;
	public String populatedata = "";
	public String onchange = "";
	public String requesttype = "";
	public String empFormatDate = "";
	public String keyword = "", value = "";
	public int customerBranchId = 0;
	HashMap output = null;
	JSONObject inputObj = null;
	public String jctimepromised = "";
	public String jcModifiedDate = "";
	public String jcTitle = "";
	public String jctimein = "";
	public String jcOpen = "";
	public String jcAuth = "";
	public String jcAuthDate = "";
	public String jcCritical = "";
	public String jcTimeOut = "";
	public String customerName = "";
	public String contactName = "";
	public String jcTimeReady = "";
	public String contactFname = "";
	public String contactMobile2 = "";
	public String contactMobile1 = "";
	public String contactEmail1 = "";
	public String contactAddress = "";
	public String contactLname = "";
	public String contactCityId = "";
	public String contactEmail2 = "";
	public String contactPin = "";
	private int compId;
	public String branchAccess = "";
	public String exeAccess = "";
	public String page = "0";
	public String executiveIds = "";
	public String branchIds = "";
	public String modelIds = "";
	public String itemIds = "";
	public String statusIds = "";
	public String priorityIds = "";
	public String jcCustomerId = "0";
	public String jcContactId = "0";
	public String requestType = "";
	public String strSearch = "";
	public String app = "";
	public String itemModelId = "0";
	public String contactTitleId = "0";
	public Date timeZone = null;
	@Autowired
	JCRepository jcRepository;

	@Autowired
	private JcFilterImpl jcfilter;

	@Autowired
	JcFilterRepository jcfilterrepository;

	@Autowired
	private CustomerContactReposiitory ContactRepository;

	@Autowired
	CustomerFilterImpl customerFilterImpl;

	@Autowired
	public EmpRepository axelaEmpRepository;

	@Autowired
	public JobcardHistoryRepository jobcardhistoryrepository;

	@Autowired
	public JobcardImgRepository jobcardImgRepository;

	@Autowired
	public ConfigRepository axelaConfigRepository;

	@Autowired
	public CustomerRepository customerRepository;
	private final static int PAGESIZE = 25;
	public String pages = "1", sort = "DESC", field = "jcId", total = "100";
	LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
	public Map<String, String> jobcardAdd(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, SQLException, ParseException {
		if (AppRun().equals("0")) {
			SOP("input==WS_jobcadrt_Add===" + input);
		}

		inputObj = new JSONObject(input);
		output = new LinkedHashMap();
		exeAccess = GetSession("ExeAccess", request);
		branchAccess = GetSession("BranchAccess", request);
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));

		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (empId != 0) {
			switch (requestType) {
				case "add" : // add jobcard.
					timeZone = getTimeByZone(session);
					getValues(inputObj);
					addFields(response, session);
					break;

				case "dash" :// jobcard dash.
					if (!inputObj.isNull("jcId")) {
						jcId = Integer.parseInt(CNumeric(inputObj.getString("jcId")));
					}
					if (jcId != 0) {
						jcDashPage(input, session, response, request);
					}
					break;
			}
			if (AppRun().equals("0")) {
				SOP("output========WS_jobcradaddd===========" + output.toString());
			}
		} else
		{
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			output.put("response", response);

		}

		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		executiveIds = "";
		branchIds = "";
		modelIds = "";
		itemIds = "";
		statusIds = "";
		jcId = 0;
		priorityIds = "";
		jcCustomerId = "0";
		jcContactId = "0";
		customerName = "";
		contactName = "";
		contactFname = "";
		contactLname = "";
		contactMobile1 = "";
		if (!inputObj.isNull("contactId")) {
			contactId = Integer.parseInt(CNumeric(inputObj.getString("contactId")));
		}
		// else {
		// contactId = 0;
		// }
		if (!inputObj.isNull("customerId")) {
			customerId = Integer.parseInt(CNumeric(inputObj.getString("customerId")));
		}
		// if (jcContactId.equals("0")) {
		// if (!inputObj.isNull("emp_branch_id")) {
		// emp_branch_id = CNumeric(inputObj.getString("emp_branch_id"));
		// System.out.println("branch_id=================" + emp_branch_id);
		// }
		//
		// if (!inputObj.isNull("branch_name")) {
		// branch_name = PadQuotes(inputObj.getString("branch_name"));
		// }
		if (contactId == 0) {
			if (!inputObj.isNull("customerName")) {
				customerName = PadQuotes(inputObj.getString("customerName"));
			}
			if (!inputObj.isNull("contactName")) {
				contactName = PadQuotes(inputObj.getString("contactFname") + inputObj.getString("contactLname"));
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
				contactCityId = CNumeric(inputObj.getString("contactCityId"));
			}

			if (!inputObj.isNull("contactTitleId")) {
				contactTitleId = CNumeric(inputObj.getString("contactTitleId"));
			}
		}
		if (!inputObj.isNull("jcId")) {
			jcId = inputObj.getInt("jcId");
		}
		// if (!inputObj.isNull("contactId")) {
		// contactId = CNumeric(inputObj.getString("contactId"));
		// }
		// if (!inputObj.isNull("customer_id")) {
		// customer_id = CNumeric(inputObj.getString("emp_branch_id"));
		// }

		// processfilter
		if (!inputObj.isNull("priorityIds")) {
			priorityIds = PadQuotes(inputObj.getString("priorityIds"));
		}

		if (!inputObj.isNull("branchIds")) {
			branchIds = PadQuotes(inputObj.getString("branchIds"));
		}
		if (!inputObj.isNull("modelIds")) {
			modelIds = PadQuotes(inputObj.getString("modelIds"));
		}
		if (!inputObj.isNull("statusIds")) {
			statusIds = PadQuotes(inputObj.getString("statusIds"));
		}
		if (!inputObj.isNull("executiveIds")) {
			executiveIds = PadQuotes(inputObj.getString("executiveIds"));
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

		if (!inputObj.isNull("jcBranchId")) {
			jcBranchId = CNumeric(inputObj.getString("jcBranchId"));
		}
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

		if (!inputObj.isNull("jcTimeReady")) {
			jcTimeReady = PadQuotes(inputObj.getString("jcTimeReady"));
		}
		if (!inputObj.isNull("jcAuthDate")) {
			jcAuthDate = PadQuotes(inputObj.getString("jcAuthDate"));
		}

		if (!inputObj.isNull("jcSerialno")) {
			jcSerialno = PadQuotes(inputObj.getString("jcSerialno"));
		}
		if (!inputObj.isNull("jcJctypeId")) {
			jcJctypeId = CNumeric(inputObj.getString("jcJctypeId"));
		}
		// s

		if (!inputObj.isNull("jcContactId")) {
			jcContactId = CNumeric(inputObj.getString("jcContactId"));
		}
		if (!inputObj.isNull("jcCustomerId")) {
			jcCustomerId = CNumeric(inputObj.getString("jcCustomerId"));
		}
		if (!inputObj.isNull("jcJccatId")) {
			jcJccatId = CNumeric(inputObj.getString("jcJccatId"));
		}
		if (!inputObj.isNull("itemModelId")) {
			itemModelId = CNumeric(inputObj.getString("itemModelId"));
		}

		if (!inputObj.isNull("jcItemId")) {
			jcItemId = CNumeric(inputObj.getString("jcItemId"));
		}

		if (!inputObj.isNull("jcEmpId")) {
			jcEmpId = CNumeric(inputObj.getString("jcEmpId"));
		}

		// if (!inputObj.isNull("jc_location_id")) {
		// jc_location_id = CNumeric(inputObj.getString("emp_branch_id"));
		// }

		if (!inputObj.isNull("jcTimeOut")) {
			jcTimeOut = PadQuotes(inputObj.getString("jcTimeOut"));
		}
		if (!inputObj.isNull("jcCustomerVoice")) {
			jcCustomerVoice = PadQuotes(inputObj.getString("jcCustomerVoice"));
		}
		// if (!inputObj.isNull("jc_active")) {
		// jc_active = PadQuotes(inputObj.getString("emp_branch_id"));
		// }
		if (!inputObj.isNull("jcNotes")) {
			jcNotes = PadQuotes(inputObj.getString("jcNotes"));
		}
	}

	public void addFields(HttpServletResponse response, HttpSession session) throws ParseException {
		JCService jobcard = new JCService();
		jobcard.contactId = contactId;
		jobcard.customerName = customerName;
		jobcard.contactMobile1 = contactMobile1;
		jobcard.contactEmail1 = contactEmail1;
		jobcard.contactEmail2 = contactEmail2;
		jobcard.contactFname = contactFname;
		jobcard.contactLname = contactLname;
		jobcard.contactAddress = contactAddress;
		jobcard.timeZone = timeZone;
		jobcard.contactCityId = "1";
		jobcard.jcTitle = "New Job Card";
		jobcard.jcPriorityjcId = "1";
		jobcard.jcActive = "1";
		jobcard.jcJcstatusId = "1";
		jobcard.customerId = customerId;
		jobcard.contactPin = contactPin;
		jobcard.contactTitleId = contactTitleId;
		jobcard.jcEmpId = jcEmpId;
		jobcard.jcBranchId = jcBranchId;
		jobcard.jcItemId = jcItemId;
		jobcard.itemModelId = itemModelId;
		jobcard.jcJctypeId = jcJctypeId;
		jobcard.jcJccatId = jcJccatId;
		jobcard.jcBillAddress = jcBillAddress;
		jobcard.jcBillCity = jcBillCity;
		jobcard.jcBillPin = jcBillPin;
		jobcard.jcBillState = jcBillState;
		jobcard.jcBillCountry = jcBillCountry;
		jobcard.jcDelAddress = jcDelAddress;
		jobcard.jcDelCity = jcDelCity;
		jobcard.jcDelPin = jcDelPin;
		jobcard.jcDelState = jcDelState;
		jobcard.jcDelCountry = jcDelCountry;
		jobcard.jcAuth = jcAuth;
		jobcard.jcTimeOut = jcTimeOut;
		jobcard.jcTimeReady = jcTimeReady;
		jobcard.jcAuthDate = jcAuthDate;
		jobcard.jcCritical = jcCritical;
		// jobcard.jcEntryDate = jcEntryDate;
		jobcard.empId = empId;
		jobcard.jcTechnicianEmpId = jcTechnicianEmpId;
		jobcard.jcOpen = jcOpen;
		jobcard.jcCustomerVoice = jcCustomerVoice;
		jobcard.jcAdvice = jcAdvice;
		jobcard.jcTerms = jcTerms;
		jobcard.jcInstructions = jcInstructions;
		jobcard.jcRoNo = jcRoNo;
		jobcard.jcSerialno = jcSerialno;
		jobcard.jcLocationId = jcLocationId;
		jobcard.jcNotes = jcNotes;
		jobcard.requestType = requestType;
		jobcard.customerRepository = customerRepository;
		jobcard.ContactRepository = ContactRepository;
		jobcard.jcrepository = jcRepository;
		jobcard.jobcardhistoryrepository = jobcardhistoryrepository;
		jobcard.timeZone = timeZone;
		jobcard.jobcardhistoryrepository = jobcardhistoryrepository;
		jobcard.addFields(response, session);
		String msg = jobcard.msg;
		if (msg.equals("")) {
			output.put("successmsg", "Jobcard Added Successfully!");
			output.put("jcId", jobcard.jcId);
		} else {
			response.setStatus(201);
			output.put("errormsg", msg);
		}
	}

	public Map<String, List> listData(String input, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws JSONException, ParseException {
		if (AppRun().equals("0")) {
			SOP("input==WS_Jobacrd===" + input);
		}

		String sort = "";
		String strOrderBy = "";
		String perPage = "0";
		inputObj = new JSONObject(input);
		requestType = "";
		String strSearch = "";
		output = new HashMap<String, List>();
		List<AxelaServiceJc> jobcardlist = null;
		branchAccess = getSession("branchAccess", session).replaceAll("branchId", "jc.jcBranchId");
		exeAccess = getSession("exeAccess", session).replaceAll("empId", "jc.jcEmpId");
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<AxelaServiceJc> jobcard = new ArrayList<AxelaServiceJc>();
		int page = 0;
		if (!inputObj.isNull("pageIndex")) {
			page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
		}
		perPage = CNumeric(getSession("emp_recperpage", session));
		if (sort.equals("")) {
			sort = "DESC";
		}
		if (strOrderBy.equals("")) {
			strOrderBy = "jcId";
		}
		if (perPage.equals("0")) {
			perPage = "25";
		}
		page++;
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (requestType.equals("filter")) {
			SOP("insiderequest");
			strSearch += appBuildSmartSearch(input);
		}
		strSearch += branchAccess + exeAccess;
		strOrderBy = " ORDER BY jc." + strOrderBy + " " + sort + "";
		jobcardlist = jcfilter.findAll(strSearch, strOrderBy, page, Integer.parseInt(perPage), "yes");
		String totalCount = jcfilter.totalCount;
		if (!totalCount.equals("0")) {
			for (AxelaServiceJc result : jobcardlist) {
				map.clear();
				map.put("jcId", CNumeric(String.valueOf(result.getJcId())));
				map.put("jcTimeIn", PadQuotes(strToShortDate(result.getJcTimeIn())));
				map.put("jcStatusName", PadQuotes(result.getJcStatusName()));
				map.put("contactName", PadQuotes(result.getContactName()));
				map.put("customerName", PadQuotes(result.getJcCustomerName()));
				map.put("contactEmail1", PadQuotes(result.getContactEmail1()));
				map.put("contactMobile1", PadQuotes(result.getContactMobile1()));
				map.put("contactEmail2", PadQuotes(result.getContactEmail2()));
				map.put("contactMobile2", PadQuotes(result.getContactMobile2()));
				map.put("jcGrandtotal", PadQuotes(result.getJcGrandtotal() + ""));
				map.put("itemName", PadQuotes(result.getJcItemName()));
				map.put("empName", PadQuotes(result.getEmpName()));
				map.put("branchName", PadQuotes(result.getJcBranchName()));
				list.add((HashMap<String, String>) map.clone());
			}
			output.put("listData", list);
			response.setStatus(201);
		}
		else
		{
			output.put("msg", "No Records Found!");
		}
		if (AppRun().equals("0")) {
			SOP("output =========AxelajobcardlistService listData============== " + output);
		}
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
			for (AxelaCustomerContact obj : contact) {
				HashMap<String, String> map = new HashMap<String, String>();
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
			for (AxelaCustomerContact obj : contact) {
				HashMap<String, String> map = new HashMap<String, String>();
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
			for (AxelaCustomerContact obj : contact) {
				HashMap<String, String> map = new HashMap<String, String>();
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

	public Map<String, String> populateJcData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		JobcardDashService jobcarddashservice = new JobcardDashService();
		jobcarddashservice.jcfilterimpl = jcfilter;
		// jobcarddashservice.axelaEmpRepository = axelaEmpRepository;
		jobcarddashservice.populateJobcardData(input, session, response);
		output = jobcarddashservice.output;
		return output;
	}

	public Map<String, String> jcDashPage(String input, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws JSONException, ParseException {
		output = new HashMap();
		SOP("inside jobcard dash");
		JobcardDashService jobcarddashservice = new JobcardDashService();
		jobcarddashservice.jcfilterimpl = jcfilter;
		jobcarddashservice.jcRepository = jcRepository;
		jobcarddashservice.axelaEmpRepository = axelaEmpRepository;
		jobcarddashservice.axelaConfigRepository = axelaConfigRepository;
		jobcarddashservice.jobcardHistoryRepository = jobcardhistoryrepository;
		jobcarddashservice.jobcardImgRepository = jobcardImgRepository;
		jobcarddashservice.jobcardServiceUpdate(input, request, response, session);
		output = jobcarddashservice.output;
		SOP("output============uj " + output);
		return output;
	}
}
