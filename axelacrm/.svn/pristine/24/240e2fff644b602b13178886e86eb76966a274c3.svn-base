package axela.service.service;

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
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.portal.model.AxelaConfig;
import axela.portal.repository.ConfigRepository;
import axela.portal.repository.EmpFilterImpl;
import axela.portal.repository.EmpRepository;
import axela.service.model.AxelaServiceJc;
import axela.service.model.AxelaServiceJcBay;
import axela.service.model.AxelaServiceJcHistory;
import axela.service.repository.JCRepository;
import axela.service.repository.JcFilterImpl;
import axela.service.repository.JobcardHistoryRepository;
import axela.service.repository.JobcardImgRepository;
import axela.service.repository.ServiceJcBayFilterImpl;
import axela.service.repository.ServiceJcDocRepository;

@Service
// @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class JobcardDashService extends Connect {
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
	public int jcId = 0;
	private String compId = "0";

	public JSONObject inputObj = null;
	public HashMap output = null;
	public String requestType = "";

	@Autowired
	public ConfigRepository axelaConfigRepository;

	@Autowired
	public JCRepository jcRepository;

	@Autowired
	public EmpRepository axelaEmpRepository;

	@Autowired
	public JobcardImgRepository jobcardImgRepository;

	@Autowired
	public JobcardHistoryRepository jobcardHistoryRepository;

	@Autowired
	public JcFilterImpl jcfilterimpl;

	@Autowired
	public ServiceJcDocRepository serviceJcDoc;

	@Autowired
	public ServiceJcBayFilterImpl serviceJcBayFilterImpl;
	
	@Autowired
	public EmpFilterImpl empFilterImpl;

	private String msg = "";
	private String branchAccess;
	private String exeAccess;
	private String empFormatDate = "";
	public String empFormattime = "";
	private String baytransEmpId = "0";
	private String StrSearch = "";

	public Map jobcardServiceUpdate(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("inputObj==========jcDashService==========" + inputObj.toString(1));
		}
		requestType = "";
		output = new HashMap();
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		SOP("empId===================" + empId);
		if (empId != 0) {
			if (empId != 0) {
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
					case "1" : // jobcard Details
						switch (requestType) {
							case "populateData" :
								if (!inputObj.isNull("jcId")) {
									jcId = Integer.parseInt(inputObj.getString("jcId"));
								}
								populateCustomerDetails(jcId);
								populateJobcardData(input, session, response);
								break;

							case "update" :
								dashFieldUpdate(input, request, response, session);
								break;
						}
						break;
					case "2" :// jobcard Customer.
						switch (requestType) {
							case "populateData" :
								if (!inputObj.isNull("jcId")) {
									jcId = Integer.parseInt(inputObj.getString("jcId"));
								}
								populateCustomerDetails(jcId);
								populateCustomerDetail();
								break;
						}
						break;
					case "5" :// jobcard Image.
						switch (requestType) {
							case "populateData" :
								if (!inputObj.isNull("jcId")) {
									jcId = Integer.parseInt(inputObj.getString("jcId"));
								}
								populateCustomerDetails(jcId);
								populateListImgDetail(jcId);
								break;
						}
						break;
					case "4" :// jobcard Checklist.
						switch (requestType) {
							case "populateData" :
								if (!inputObj.isNull("jcId")) {
									jcId = Integer.parseInt(inputObj.getString("jcId"));
								}
								populateCustomerDetails(jcId);
								populateCheckList();
								break;
						}
						break;
					case "8" :// jobcard Psf.
						switch (requestType) {
							case "populateData" :
								if (!inputObj.isNull("jcId")) {
									jcId = Integer.parseInt(inputObj.getString("jcId"));
								}
								populateCustomerDetails(jcId);
								populateDashPSF(jcId, session);
								break;
						}
						break;
					case "6" :// jobcard documents.
						switch (requestType) {
							case "populateData" :
								if (!inputObj.isNull("jcId")) {
									jcId = Integer.parseInt(inputObj.getString("jcId"));
								}
								populateJcDocs(session);
								break;
						}
						break;
					case "7" : // manHours Details
						switch (requestType) {
							case "populateData" :
								if (!inputObj.isNull("jcId")) {
									jcId = Integer.parseInt(inputObj.getString("jcId"));
								}
								PopulateUser(String.valueOf(jcId), session);
								break;
							case "onchange" :
								if (!inputObj.isNull("baytransEmpId")) {
									baytransEmpId = inputObj.getString("baytransEmpId");
								}
								if (!inputObj.isNull("jcId")) {
									jcId = Integer.parseInt(inputObj.getString("jcId"));
								}
								populateManHours(String.valueOf(jcId), baytransEmpId, compId, session);
								break;
						}
						break;
					case "9" :// jobcard History.
						switch (requestType) {
							case "populateData" :
								if (!inputObj.isNull("jcId")) {
									jcId = Integer.parseInt(inputObj.getString("jcId"));
								}
								populateHistory(session);
								break;
						}

				}
			}
			else
			{
				// output.put("msg", "Invalid Jobcard ID");
				// output.put("msg", "Invalid Jobcard ID");
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				output.put("response", response);

			}
		}
		return output;
	}
	// Start Of Populate jobcard Data
	public Map<String, String> populateJobcardData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		SOP("inputObj==populatejcData====" + inputObj);
		Map map = new LinkedHashMap<String, String>();
		ArrayList list = new ArrayList();
		if (!inputObj.isNull("jcId")) {
			jcId = Integer.parseInt(PadQuotes(CNumeric(inputObj.getString("jcId"))));
		}
		if (jcId != 0) {
			AxelaServiceJc axelaservicejc = jcfilterimpl.findOneForDash(jcId);
			if (axelaservicejc != null) {
				map.put("jcId", axelaservicejc.getJcId() + "");
				map.put("jcNo", axelaservicejc.getJcNo() + "");
				map.put("jcBranchId", axelaservicejc.getJcBranchId() + "");
				map.put("jcTimeIn", strToShortDate(axelaservicejc.getJcTimeIn()));
				map.put("jcTimeOut", strToShortDate(axelaservicejc.getJcTimeOut()));
				map.put("jcTimeReady", strToShortDate(axelaservicejc.getJcTimeReady()));
				map.put("jcTimePromised", strToShortDate(axelaservicejc.getJcTimePromised()));
				map.put("jcEmpId", axelaservicejc.getJcEmpId() + "");
				map.put("jcTechnicianEmpId", axelaservicejc.getJcTechnicianEmpId() + "");
				map.put("jcRoNo", axelaservicejc.getJcRoNo());
				map.put("itemModelId", String.valueOf(axelaservicejc.getItemModelId()));
				map.put("jcItemId", axelaservicejc.getJcItemId() + "");
				map.put("jcJctypeId", axelaservicejc.getJcJctypeId() + "");
				map.put("jcJccatId", axelaservicejc.getJcJccatId() + "");
				map.put("jcBayId", axelaservicejc.getJcBayId() + "");
				map.put("jcLocationId", axelaservicejc.getJcLocationId() + "");
				map.put("jcTitle", axelaservicejc.getJcTitle());
				map.put("jcCustomerVoice", axelaservicejc.getJcCustomerVoice());
				map.put("jcAdvice", axelaservicejc.getJcAdvice());
				map.put("jcTerms", axelaservicejc.getJcTerms());
				map.put("jcInstructions", axelaservicejc.getJcInstructions());
				map.put("jcCustomerId", axelaservicejc.getJcCustomerId() + "");
				map.put("jcContactId", axelaservicejc.getJcContactId() + "");
				map.put("jcRefno", axelaservicejc.getJcRefno());
				map.put("jcSerialno", PadQuotes(axelaservicejc.getJcSerialno()));
				map.put("jcPriorityjcId", axelaservicejc.getJcPriorityjcId() + "");
				map.put("jcNotes", axelaservicejc.getJcNotes());
				map.put("jcJcstatusId", axelaservicejc.getJcJcstatusId() + "");
				map.put("customerName", axelaservicejc.getJcCustomerName());
				map.put("jcCritical", axelaservicejc.getJcCritical());
				map.put("contactTitleId", axelaservicejc.getContactTitleId() + "");
				map.put("contactFname", axelaservicejc.getContactFname());
				map.put("contactLname", axelaservicejc.getContactLname());
				map.put("contactPhone1", axelaservicejc.getContactPhone1());
				map.put("contactMobile1", axelaservicejc.getContactMobile1());
				map.put("contactEmail1", axelaservicejc.getContactEmail1());
				map.put("contactAddress", axelaservicejc.getContactAddress());
				map.put("contactPin", axelaservicejc.getContactPin());
				// // + " jc.axelaBranch.branchName AS jcBranchName,"
				map.put("branchName", PadQuotes(axelaservicejc.getJcBranchName()));
				map.put("contactCityId", axelaservicejc.getContactCityId());
				map.put("jcEntryId", axelaservicejc.getJcEntryId() + "");
				map.put("jcEntryBy", PadQuotes(axelaEmpRepository.findEmpName(axelaservicejc.getJcEntryId())));
				map.put("JcEntryDate", strToLongDate(axelaservicejc.getJcEntryDate()));
				if (axelaservicejc.getJcModifiedId() != 0) {
					map.put("jcModifiedId", axelaservicejc.getJcModifiedId() + "");
					map.put("jcModifiedDate", strToShortDate(axelaservicejc.getJcModifiedDate()));
					map.put("jcModifiedBy", axelaEmpRepository.findEmpName(axelaservicejc.getJcModifiedId()));
				}
				list.add(map);
				output.put("populateJobcardData", list);
			} else {

				output.put("msg", "Invalid Jobcard ID");
			}
		}
		else {
			output.put("msg", "Invalid Jobcard ID");
			response.setStatus(400);
		}
		return output;
	}

	public void dashFieldUpdate(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		AxelaServiceJc axelaservicejc = null;
		empFormattime = PadQuotes(getSession("formattimeName", session));
		empFormatDate = PadQuotes(getSession("formatdateName", session));
		empId = Integer.parseInt(getSession("empId", session));
		String name = "";
		String value = "";
		JcFilterImpl jobcardDash = null;
		output = new HashMap<String, String>();
		if (!inputObj.isNull("jcId")) {
			jcId = Integer.parseInt(inputObj.getString("jcId"));
		}
		SOP("jcId========" + jcId);
		if (!inputObj.isNull("name")) {
			name = PadQuotes(inputObj.getString("name"));
		}
		SOP("name========" + name);
		if (!inputObj.isNull("value")) {
			value = PadQuotes(inputObj.getString("value"));
		}
		SOP("value========" + value);

		if (jcId != 0) {
			axelaservicejc = jcRepository.findOne(jcId);
			if (!name.equals("") && !value.equals("")) {
				AxelaServiceJcHistory axelaservicejchistory = new AxelaServiceJcHistory();
				axelaservicejchistory.setHistoryJcId(BigInteger.valueOf(jcId));
				axelaservicejchistory.setHistoryEmpId(empId);
				axelaservicejchistory.setHistoryDatetime(stringToDate(toLongDate(kknow())));
				if (name.equals("customerName")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("CUSTOMER NAME");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(axelaservicejc.getAxelaCustomer().getCustomerName());
					axelaservicejc.getAxelaCustomer().setCustomerName(value);
					msg = "Customer Updated!";
				}

				if (name.equals("contactTitle")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("CONTACT TITLE");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(String.valueOf(axelaservicejc.getAxelaCustomerContact().getContactTitleId()));
					axelaservicejc.getAxelaCustomerContact().setContactTitleId(Integer.parseInt(value));
					msg = "Contact Title Updated!";
				}
				if (name.equals("contactFname")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("CONTACT FIRST NAME");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(axelaservicejc.getAxelaCustomerContact().getContactFname());
					axelaservicejc.getAxelaCustomerContact().setContactFname(value);
					msg = "Contact FirstName Updated!";
				}

				if (name.equals("contactLname")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("CONTACT LAST NAME");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(axelaservicejc.getAxelaCustomerContact().getContactLname());
					axelaservicejc.getAxelaCustomerContact().setContactLname(value);
					msg = "Contact LastName Updated!";
				}

				if (name.equals("contactMobile1")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("CONTACT MOBILE1");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(axelaservicejc.getAxelaCustomerContact().getContactMobile1());
					axelaservicejc.getAxelaCustomerContact().setContactMobile1(value);
					msg = "Contact Mobile1 Updated!";
				}

				if (name.equals("contactMobile2")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("CONTACT MOBILE2");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(axelaservicejc.getAxelaCustomerContact().getContactMobile2());
					axelaservicejc.getAxelaCustomerContact().setContactMobile2(value);
					msg = "Contact Mobile2 Updated!";
				}

				if (name.equals("contactPhone1")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("CONTACT PHONE1");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(axelaservicejc.getAxelaCustomerContact().getContactPhone1());
					axelaservicejc.getAxelaCustomerContact().setContactPhone1(value);
					msg = "Contact Phone1 Updated!";
				}

				if (name.equals("contactPhone2")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("CONTACT PHONE2");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(axelaservicejc.getAxelaCustomerContact().getContactPhone2());
					axelaservicejc.getAxelaCustomerContact().setContactPhone2(value);
					msg = "Contact Phone2 Updated!";
				}

				if (name.equals("contactEmail1")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("CONTACT EMAIL1");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(axelaservicejc.getAxelaCustomerContact().getContactEmail1());
					axelaservicejc.getAxelaCustomerContact().setContactEmail1(value);
					msg = "Contact Email1 Updated!";
				}
				if (name.equals("contactEmail2")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("CONTACT EMAIL2");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(axelaservicejc.getAxelaCustomerContact().getContactEmail2());
					axelaservicejc.getAxelaCustomerContact().setContactEmail2(value);
					msg = "Contact Email2 Updated!";
				}

				if (name.equals("contactAddress")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("CONTACT ADDRESS");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(axelaservicejc.getAxelaCustomerContact().getContactAddress());
					axelaservicejc.getAxelaCustomerContact().setContactAddress(value);
					msg = "Contact Address Updated!";
				}

				if (name.equals("contactCityId")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("CONTACT CITY");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(String.valueOf(axelaservicejc.getAxelaCustomerContact().getAxelaCity().getCityId()));
					axelaservicejc.getAxelaCustomerContact().getAxelaCity().setCityId(Integer.parseInt(value));
					msg = "Contact Address Updated!";
				}

				if (name.equals("contactPin")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("CONTACT PIN");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(axelaservicejc.getAxelaCustomerContact().getContactPin());
					axelaservicejc.getAxelaCustomerContact().setContactPin(value);
					msg = "Contact Pin Updated!";
				}

				if (name.equals("itemModelId")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("MODEL");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(String.valueOf(axelaservicejc.getAxelaitem().getItemModelId()));
					axelaservicejc.getAxelaitem().setItemModelId(Integer.parseInt(value));
					msg = "Model Updated!";
				}

				if (name.equals("jcNotes")) {
					SOP("inside Jcnotes");
					// History table Update
					axelaservicejchistory.setHistoryActiontype("NOTES");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(axelaservicejc.getJcNotes());
					axelaservicejc.setJcNotes(value);
					msg = "Jobcard Notes Updated!";
				}

				SOP("job card===========" + inputObj);
				if (name.equals("jcTitle")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("TITLE");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(PadQuotes(axelaservicejc.getJcTitle()));
					axelaservicejc.setJcTitle(value);
					msg = "Jobcard Title Updated!";
				}

				if (name.equals("jcInstructions")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("INSTRUCTIONS");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(PadQuotes(axelaservicejc.getJcInstructions()));
					axelaservicejc.setJcInstructions(value);
					msg = "Jobcard Instructions Updated!";
				}

				if (name.equals("jcRefno")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("JOBCARD REFNO");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(axelaservicejc.getJcRefno());
					axelaservicejc.setJcRefno(value);
					msg = "Jobcard Refno Updated!";
				}

				if (name.equals("jcSerialno")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("JOBCARD SERIALNO");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(axelaservicejc.getJcSerialno());
					axelaservicejc.setJcSerialno(value);
					msg = "Jobcard Serial Updated!";
				}

				if (name.equals("jcRoNo")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("JOBCARD RONO");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(axelaservicejc.getJcRoNo());
					axelaservicejc.setJcRoNo(value);
					msg = "RO No. Updated!!";
				}

				if (name.equals("jcPriorityJcId")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("PRIORITY");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(String.valueOf(axelaservicejc.getJcPriorityjcId()));
					axelaservicejc.setJcPriorityjcId(Integer.parseInt(value));
					msg = "Priority Updated!";
				}

				if (name.equals("jcLocationId")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("LOCATION");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(String.valueOf(axelaservicejc.getJcLocationId()));
					axelaservicejc.setJcLocationId(Integer.parseInt(value));
					msg = "Location Updated!";
				}
				if (name.equals("jcTechnicianEmpId")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("TECHNICIAN");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(String.valueOf(axelaservicejc.getJcTechnicianEmpId()));
					axelaservicejc.setJcTechnicianEmpId(Integer.parseInt(value));
					msg = "Technician Updated!";
				}
				if (name.equals("jcCritical")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("CRITICAL");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(axelaservicejc.getJcCritical());
					axelaservicejc.setJcCritical(value);
					msg = "Cricital Updated!";
				}

				if (name.equals("jcEmpId")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("EXECUTIVE");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(String.valueOf(axelaservicejc.getJcEmpId()));
					axelaservicejc.setJcEmpId(Integer.parseInt(value));
					msg = "Executice Updated!";
				}

				if (name.equals("jcAdvice")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("SERVICE ADVICE");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(String.valueOf(axelaservicejc.getJcAdvice()));
					axelaservicejc.setJcAdvice(value);
					msg = "Service Advice Updated!";
				}

				if (name.equals("jcTerms")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("TERMS");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(String.valueOf(axelaservicejc.getJcTerms()));
					axelaservicejc.setJcTerms(value);
					msg = "Terms Updated!";
				}

				if (name.equals("jcInstructions")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("INSTRUCTIONS");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(String.valueOf(axelaservicejc.getJcInstructions()));
					axelaservicejc.setJcInstructions(value);
					msg = "Instructions Updated!";
				}

				if (name.equals("jcCustomerVoice")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("CUSTOMER VOICE");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(axelaservicejc.getJcCustomerVoice());
					axelaservicejc.setJcCustomerVoice(value);
					msg = "CustomerVoice Updated!";
				}

				if (name.equals("jcJctypeId")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("TYPE");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(String.valueOf(axelaservicejc.getJcJctypeId()));
					axelaservicejc.setJcJctypeId(Integer.parseInt(value));
					msg = "Type Updated!";
				}

				if (name.equals("jcJccatId")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("CATEGORY");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(String.valueOf(axelaservicejc.getJcJccatId()));
					axelaservicejc.setJcJccatId(Integer.parseInt(value));
					msg = "Category Updated!";
				}

				if (name.equals("jcItemId")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("ITEM");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(String.valueOf(axelaservicejc.getJcItemId()));
					axelaservicejc.setJcItemId(Integer.parseInt(value));
					msg = "Item Updated!";
				}

				if (name.equals("jcBayId")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("BAY");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(String.valueOf(axelaservicejc.getJcBayId()));
					axelaservicejc.setJcBayId(Integer.parseInt(value));
					msg = "Bay Updated!";
				}

				if (name.equals("jcJcstatusId")) {
					// History table Update
					axelaservicejchistory.setHistoryActiontype("STATUS");
					axelaservicejchistory.setHistoryNewvalue(value);
					axelaservicejchistory.setHistoryOldvalue(String.valueOf(axelaservicejc.getJcJcstatusId()));
					axelaservicejc.setJcJcstatusId(Integer.parseInt(value));
					msg = "Status Updated!";
				}

				if (name.equals("jcTimePromised")) {
					if (!isValidDateFormat(value, empFormatDate)) {
						msg = "Enter Valid Close Date!";
					}
					if (msg.equals("")) {
						axelaservicejchistory.setHistoryActiontype("PROMISED TIME");
						axelaservicejchistory.setHistoryNewvalue(value);
						axelaservicejchistory.setHistoryOldvalue(strToLongDate(axelaservicejc.getJcTimePromised()));
						axelaservicejc.setJcTimePromised(stringToDate(convertLongDate(value)));
						msg += "Promised Time Updated!<br>";
					}
				}
				jcRepository.save(axelaservicejc);
				jobcardHistoryRepository.save(axelaservicejchistory);
				output.put("msg", msg);
			}
		} else {
			output.put("msg", "Invalid Jobcard ID");
			response.setStatus(400);
		}
	}

	public Map populateCustomerDetails(int jcId) throws JSONException, ParseException {
		SOP("inside normal dash");
		Map map = new HashMap();
		output = new HashMap();
		List list = new ArrayList();
		AxelaServiceJc jobcard = new AxelaServiceJc();
		jobcard = jcfilterimpl.findCustomerDetails(jcId);
		map.put("customerName", jobcard.getJcCustomerName());
		map.put("customerId", jobcard.getJcCustomerId() + "");
		map.put("contactId", jobcard.getJcContactId() + "");
		map.put("contactName", jobcard.getTitleDesc() + "." + jobcard.getContactFname() + jobcard.getContactLname());
		map.put("branchName", jobcard.getJcBranchName());
		map.put("jcEntryDate", dateToString(jobcard.getJcEntryDate()));
		map.put("contactMobile1", jobcard.getContactMobile1());
		list.add(map);
		output.put("populateDetail", list);
		return output;
	}

	public Map populateCustomerDetail() throws JSONException, ParseException {
		Map map = new HashMap();
		List list = new ArrayList();
		map = new HashMap();
		int count = 0;
		for (AxelaServiceJc obj : jcfilterimpl.findCustomerDetail(jcId)) {
			count++;
			map = new HashMap();
			map.put("jcId", obj.getJcId());
			map.put("jcEntryDate", strToShortDate(obj.getJcEntryDate()));
			map.put("branchName", obj.getJcBranchName());
			map.put("customerName", obj.getJcCustomerName());
			map.put("contactPhone1", obj.getContactPhone1());
			map.put("contactAddress", obj.getContactAddress());
			map.put("contactPin", obj.getContactPin());
			map.put("contactName", obj.getTitleDesc() + obj.getContactFname() + " " + obj.getContactLname());
			map.put("contactMobile1", obj.getContactMobile1());
			map.put("contactEmail1", obj.getContactEmail1());
			map.put("contactMobile2", obj.getContactMobile2());
			map.put("contactEmail2", obj.getContactEmail2());
			list.add(map);
		}
		output.put("populateCustomerDetail", list);
		return output;
	}

	public Map populateListImgDetail(int jcId) throws JSONException {
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (Object[] results : jobcardImgRepository.findjcId(jcId)) {
			HashMap map = new HashMap();
			map.put("imgId", "" + results[0].toString());
			map.put("imgValue", "" + results[1].toString());
			map.put("imgTitle", "" + results[2].toString());
			map.put("imgUrl", WSUrl() + "/portal/thumbnail?imgId=" + results[0].toString() + "&type=jcimg");
			list.add(map);
		}
		output.put("populateImgDetail", list);
		return output;
	}

	public Map<String, List> populateCheckList() throws JSONException {
		List<Object[]> axelaServiceJcCheck = null;
		output = new HashMap();
		HashMap map = null;
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		axelaServiceJcCheck = jcfilterimpl.findJcCheckList(1, 2);
		for (Object[] obj : axelaServiceJcCheck) {
			map = new HashMap();
			map.put("checkId", obj[0]);
			map.put("checkName", obj[1]);
			map.put("checkType", obj[2]);
			map.put("count", obj[3]);
			map.put("checked", obj[4]);
			list.add(map);
		}
		output.put("populateCheckList", list);
		return output;
	}

	public Map<String, List> populateDashPSF(int jcId, HttpSession session) throws JSONException {
		List<Object[]> axelaServiceJcPsf = null;
		branchAccess = getSession("branchAccess", session).replaceAll("branchId", "jc.jcBranchId");
		output = new HashMap();
		String strSearch = branchAccess;
		HashMap map = null;
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		axelaServiceJcPsf = jcfilterimpl.findPSFList(jcId, strSearch);
		for (Object[] obj : axelaServiceJcPsf) {
			map = new HashMap();
			map.put("customerId", obj[0].toString());
			map.put("customerName", obj[1].toString());
			map.put("contactId", obj[2].toString());
			map.put("contacts", obj[3].toString() + obj[4].toString() + obj[5].toString());
			map.put("contactMobile1", obj[6].toString());
			map.put("itemName", obj[7].toString());
			list.add(map);
		}
		output.put("populatePsf", list);
		return output;
	}

	public Map populateHistory(HttpSession session) throws JSONException {
		output = new HashMap();
		// List<AxelaSalesOpprHistory> obj = null;
		branchAccess = getSession("branchAccess", session);
		exeAccess = getSession("branchAccess", session);
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		String Strsearch = " AND history.historyJcId=" + jcId + branchAccess + exeAccess;
		for (AxelaServiceJcHistory obj : jcfilterimpl.findHistory(jcId, Strsearch)) {
			HashMap map = new HashMap();
			map.put("historyId", obj.getHistoryId());
			map.put("historyActiontype", obj.getHistoryActiontype());
			map.put("historyDatetime", obj.getHistoryDatetime());
			map.put("historyEmpId", obj.getHistoryEmpId());
			map.put("historyJcId", obj.getHistoryJcId());
			map.put("historyNewvalue", obj.getHistoryNewvalue());
			map.put("empName", obj.getEmpRefNo() + obj.getEmpName());
			map.put("empId", obj.getEmpId());
			map.put("jcTitle", obj.getJcTitle());
			list.add(map);
		}
		output.put("populateHistory", list);
		return output;
	}

	public Map populateManHours(String jcId, String baytransEmpId, String compId, HttpSession session) throws JSONException, ParseException {
		output = new HashMap();
		int hrs = 0;
		int mins = 0;
		String StrSearch = "";
		long total = 0L;
		long total1 = 0L;
		long grandTotal = 0L;
		String endtime = "";
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!baytransEmpId.equals("0")) {
			StrSearch = " AND emp.empId = " + baytransEmpId + "";
		}

		for (AxelaServiceJcBay obj : serviceJcBayFilterImpl.findAll(jcId, baytransEmpId, StrSearch)) {
			HashMap map = new HashMap();
			HashMap map1 = new HashMap();
			map.put("bayId", obj.getBayId());
			map.put("bayName", obj.getBayName());
			// Since FormatDate() Is Not Working So I Am Using strToShortDate
			map.put("bayTransStartTime", strToShortDate(obj.getBaytransStartTime()));
			map.put("bayTransEndTime", strToShortDate(obj.getBaytransEndTime()));
			map.put("EmpId", obj.getEmpId());
			map.put("EmpName", obj.getEmpName() + obj.getEmpRefNo());
			if (!obj.getBaytransEndTime().equals("")) {
				endtime = dateToStringStr(obj.getBaytransEndTime());
			} else {
				endtime = dateToStringStr(getTimeByZone(session));
			}
			hrs = +(int) getHoursBetween(obj.getBaytransStartTime(), stringToDate(endtime));
			mins = +(int) getMinBetween(obj.getBaytransStartTime(), stringToDate(endtime));
			total += (hrs * 60) + mins;
			map.put("jcManHours", ConvertMintoHrsMins(hrs * 60) + mins);
			map1.put("branchName", obj.getBayBranchId());
			grandTotal += total;
			list.add(map);
		}
		output.put("grandTotal", ConvertMintoHrsMins(grandTotal));
		output.put("populateManHours", list);

		return output;
	}

	public Map populateJcDocs(HttpSession session) throws JSONException {
		output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (Object[] obj : serviceJcDoc.findJobCardDocs(jcId)) {
			HashMap map = new HashMap();
			map.put("docId", obj[0]);
			map.put("docData", obj[1]);
			map.put("docValue", obj[2]);
			map.put("docTitle", obj[3]);
			map.put("docRemarks", obj[4]);
			list.add(map);
		}
		output.put("populateJcDocs", list);
		return output;
	}

	public Map PopulateUser(String jcId, HttpSession session) throws JSONException {
		output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (Object[] obj : empFilterImpl.findByUser(jcId)) {
			HashMap map = new HashMap();
			map.put("key", obj[0]);
			map.put("name", obj[1]);
			list.add(map);
		}
		output.put("populateUser", list);
		return output;
	}
}
