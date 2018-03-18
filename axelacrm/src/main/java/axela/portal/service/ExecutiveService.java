package axela.portal.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import axela.accounting.repository.AccVoucherRepository;
import axela.activities.repository.ActivityRepository;
import axela.config.Connect;
import axela.customer.repository.CustomerRepository;
import axela.customer.repository.PmTaskRepository;
import axela.helpdesk.repository.HelpDeskTicketRepository;
import axela.portal.model.AxelaEmp;
import axela.portal.model.AxelaEmpAccess;
import axela.portal.model.AxelaEmpBranch;
import axela.portal.model.AxelaEmpExe;
import axela.portal.repository.BranchRepository;
import axela.portal.repository.CompRepository;
import axela.portal.repository.EmpAccessRepository;
import axela.portal.repository.EmpAttRepository;
import axela.portal.repository.EmpBranchrepository;
import axela.portal.repository.EmpDepartmentRepository;
import axela.portal.repository.EmpDocRepository;
import axela.portal.repository.EmpExeRepository;
import axela.portal.repository.EmpLeaveRepository;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.ExecutivesFilterImpl;
import axela.portal.repository.MktgLeadRepository;
import axela.portal.repository.PortalFilterImpl;
import axela.sales.repository.OpprRepository;
import axela.sales.repository.SalesTargetRepository;
import axela.sales.repository.SalesTeamRepository;
import axela.service.repository.AssetIssueRepository;
import axela.service.repository.JCRepository;
import axela.service.repository.ProdJobCardRepository;
import axela.service.repository.ServiceContractRepository;
import axela.service.repository.ServiceContractServiceRepository;

@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Service
public class ExecutiveService extends Connect {
	public static int branchelength = 0;
	public static int exeLength = 0;
	public String dropMonth = "";
	public String dropDay = "";
	public String dropYear = "";
	public String empAllBranches = "0";
	public JSONArray empAllBranch;
	public String allexe = "0";
	public JSONArray empAllExecutive;
	private final static int PAGESIZE = 25;
	public String empId = "0";
	public String empActive = "1";
	public String msg = "";
	public String empAddress = "";
	public String empAllExe = "";
	public String empAreaId = "0";
	public String empRoleId = "0";
	public String empBankAccholdername = "";
	public String empBankAccno = "";
	public String empBankBranchname = "";
	public String empBankName = "";
	public String empBillDiscountupdate = "";
	public String empBillPriceupdate = "";
	public String empCertification = "";
	public String empCityId = "0";
	public String empCloseOppr = "";
	public String empCopyAccess = "";
	public String empCrm = "";
	public String empDateOfJoin = "";
	public String empDateOfRelieve = "";
	public String empDealerJcExe = "";
	public String empDealerJcTechnician = "";
	public String empDeviceFcmtoken = "";
	public String empDeviceId = "";
	public String empDeviceOs = "";
	public String empDispensaryId = "0";
	public String empDob = "";
	public String dateOfJoin = "";
	public String empEmailPassword = "";
	public String empEmailPort = "";
	public String empEmailServer = "";
	public String empEmailSsl = "";
	public String empEmailTls = "";
	public String empEmailUsername = "";
	public String empEmail1 = "";
	public String empEmail2 = "";
	public String empEntryDate = "";
	public String empEntryId = "0";
	public String empEsiNo = "";
	public String empExportAccess = "";
	public String empFormatdateId = "1";
	public String empFormatdigitId = "1";
	public String empFormattimeId = "1";
	public String empGender = "";
	public String empInvoiceDiscountupdate = "";
	public String empInvoicePriceupdate = "";
	public String empIpAccess = "";
	public String empJcDiscountupdate = "";
	public String empJcPriceupdate = "";
	public String empLandmark = "";
	public String empMarried = "";
	public String empMisAccess = "";
	public String empMobile1 = "";
	public String empMobile2 = "";
	public String empModifiedDate = "";
	public String empModifiedId = "0";
	public String empName = "";
	public String empPfNo = "0";
	public String empPfNoDeptFile = "0";
	public String empPhone1 = "";
	public String empPhone2 = "";
	public String empDepartmentId = "0";
	@Lob
	@Basic(fetch = FetchType.LAZY)
	public String empPhoto = "0";
	public String empPin = "";
	public String empPrbranchId = "0";
	public String empPriorityactivityLevel1 = "0";
	public String empPriorityactivityLevel2 = "0";
	public String empPriorityactivityLevel3 = "0";
	public String empPriorityactivityLevel4 = "0";
	public String empPriorityactivityLevel5 = "0";
	public String empPrioritybalanceLevel1 = "0";
	public String empPrioritybalanceLevel2 = "0";
	public String empPrioritybalanceLevel3 = "0";
	public String empPrioritybalanceLevel4 = "0";
	public String empPrioritybalanceLevel5 = "0";
	public String empPriorityjcLevel1 = "0";
	public String empPriorityjcLevel2 = "0";
	public String empPriorityjcLevel3 = "0";
	public String empPriorityjcLevel4 = "0";
	public String empPriorityjcLevel5 = "0";
	public String empPriorityopprLevel1 = "0";
	public String empPriorityopprLevel2 = "0";
	public String empPriorityopprLevel3 = "0";
	public String empPriorityopprLevel4 = "0";
	public String empPriorityopprLevel5 = "0";
	public String empPriorityopprfollowupLevel1 = "0";
	public String empPriorityopprfollowupLevel2 = "0";
	public String empPriorityopprfollowupLevel3 = "0";
	public String empPriorityopprfollowupLevel4 = "0";
	public String empPriorityopprfollowupLevel5 = "0";
	public String empPriorityprojectLevel1 = "0";
	public String empPriorityprojectLevel2 = "0";
	public String empPriorityprojectLevel3 = "0";
	public String empPriorityprojectLevel4 = "0";
	public String empPriorityprojectLevel5 = "0";
	public String empPrioritytaskLevel1 = "0";
	public String empPrioritytaskLevel2 = "0";
	public String empPrioritytaskLevel3 = "0";
	public String empPrioritytaskLevel4 = "0";
	public String empPrioritytaskLevel5 = "0";
	public String empPriorityticketLevel1 = "0";
	public String empPriorityticketLevel2 = "0";
	public String empPriorityticketLevel3 = "0";
	public String empPriorityticketLevel4 = "0";
	public String empPriorityticketLevel5 = "0";
	public String empProdJcExe = "";
	public String empQualification = "";
	public String empQuoteDiscountupdate = "";
	public String empQuotePriceupdate = "";
	public String empReasonOfLeaving = "";
	public String empRecperpage = "0";
	public String empRefNo = "";
	public String empReportAccess = "";
	public String empSalCalcFrom = "";
	public String empSales = "";
	public String empService = "";
	public String empServicePsf = "";
	public String empSex = "";
	public String empSoDiscountupdate = "";
	public String empSoPriceupdate = "";
	public String empBranchId = "0";
	public String empJobtitleId = "0";
	public String empStructureId = "0";
	public String empTechnician = "";
	public String empThemeId = "0";
	public String empTicketClose = "";
	public String empTicketOwner = "";
	public String empTimeout = "0";
	public String empUname = "";
	public String empUpass = "";
	public String empUuid = "";
	public String compId = "0";
	private String StrSql = "";
	private String tag = "Employee";
	public String empFormatdate = "";
	public String empFormattime = "";
	public String formatdateDatepicker = "";
	public String configCustomerName = "";
	public String empsessionId = "0";
	public String branchAccess = "";
	public String dateOfRelieve = "";
	public String configSalesOpprName = "";
	public String empSessionId = "0";
	public String requestType = "";
	public String exeAccess = "";
	public String empNotes = "";
	public String empEmpBranchId = "0";

	// =====update access rights
	public String empaccessAccessId = "0";

	public String sortField = "";
	public String sortDirection = "";
	public int pageIndex = 0;
	public String perPage = "0";
	public String strSearch = "";
	public String length = "0";
	HashMap output = null;
	JSONObject inputObj = null;

	@Autowired
	PortalFilterImpl portalFilterImpl;

	@Autowired
	BranchRepository branchRepository;

	@Autowired
	EmpDepartmentRepository empDepartmentRepository;

	@Autowired
	EmpRepository axelaEmpRepository;

	@Autowired
	ActivityRepository activityRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	PmTaskRepository pmTaskRepository;

	@Autowired
	MktgLeadRepository mktgLeadRepository;

	@Autowired
	OpprRepository opprRepository;

	@Autowired
	AccVoucherRepository accVoucherRepository;

	@Autowired
	SalesTargetRepository salesTargetRepository;

	@Autowired
	SalesTeamRepository salesTeamRepository;

	@Autowired
	HelpDeskTicketRepository serviceTicketRepository;

	@Autowired
	JCRepository jCRepository;

	@Autowired
	ServiceContractRepository serviceContractRepository;

	@Autowired
	ServiceContractServiceRepository serviceContractServiceRepository;

	@Autowired
	ProdJobCardRepository prodJobCardRepository;

	@Autowired
	AssetIssueRepository assetIssueRepository;

	@Autowired
	EmpLeaveRepository empLeaveRepository;

	@Autowired
	EmpAttRepository EmpAttRepository;

	@Autowired
	EmpAccessRepository empAccessRepository;

	@Autowired
	EmpExeRepository empExeRepository;

	@Autowired
	EmpDocRepository empDocRepository;

	@Autowired
	EmpBranchrepository empBranchrepository;

	@Autowired
	ExecutivesFilterImpl executivesFilterImpl;

	@Autowired
	CompRepository axelaCompRepository;

	public Map<String, String> executiveService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empSessionId = (CNumeric(PadQuotes(getSession("empId", session))));
		compId = (CNumeric(PadQuotes(getSession("compId", session))));
		configSalesOpprName = getSession("configSalesOpprName", session);
		branchAccess = getSession("branchAccess", session);
		exeAccess = getSession("exeAccess", session);
		empFormatdate = PadQuotes(getSession("formatdateName", session));
		SOP("empFormatdate---------" + empFormatdate);
		formatdateDatepicker = getSession("formatdateDatepicker", session);
		empFormattime = getSession("formattimeName", session);
		configCustomerName = getSession("configCustomerName", session);
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		// PopulateConfigDetails();

		if (!empSessionId.equals("0") && !compId.equals("0")) {
			switch (requestType) {

				case "add" : // add an soe.
					if (!returnPerm("emp_role_id, emp_executive_add", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					empId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;

				case "update" :// update an customer.
					if (!returnPerm("emp_role_id, emp_executive_edit", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					empId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;

				case "delete" :// delete an customer.
					if (!returnPerm("emp_role_id, emp_executive_delete", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					if (!inputObj.isNull("empId")) {
						empId = CNumeric(PadQuotes(inputObj.getString("empId")));
					}
					if (!empId.equals("0")) {
						deleteFields(empId);
					}
					break;

				case "landing" :
					populateLandingDetails(input, session, response);
					break;

			}

		}
		return output;

	}
	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("empId")) {
			empId = CNumeric(PadQuotes(inputObj.getString("empId")));
		}

		if (!inputObj.isNull("empAllBranch")) {
			if (inputObj.get("empAllBranch") instanceof JSONArray)
				empAllBranch = inputObj.getJSONArray("empAllBranch");
		}

		if (!inputObj.isNull("empAllExecutive")) {
			if (inputObj.get("empAllExecutive") instanceof JSONArray)
				empAllExecutive = inputObj.getJSONArray("empAllExecutive");
		}
		if (!inputObj.isNull("empAllBranches")) {
			empAllBranches = inputObj.getString("empAllBranches");
		}

		if (!inputObj.isNull("allexe")) {
			allexe = inputObj.getString("allexe");
		}
		if (!inputObj.isNull("empActive")) {
			empActive = inputObj.getString("empActive");
		}
		if (!inputObj.isNull("empAddress")) {
			empAddress = PadQuotes(inputObj.getString("empAddress"));
		}

		if (!inputObj.isNull("empAllExe")) {
			empAllExe = inputObj.getString("empAllExe");
		}
		if (!inputObj.isNull("empAreaId")) {
			empAreaId = CNumeric(PadQuotes(inputObj.getString("empAreaId")));
		}
		if (!inputObj.isNull("empRoleId")) {
			empRoleId = CNumeric(PadQuotes(inputObj.getString("empRoleId")));
		}

		if (!inputObj.isNull("dateOfJoin")) {
			dateOfJoin = CNumeric(PadQuotes(inputObj.getString("dateOfJoin")));
		}
		if (!inputObj.isNull("empBankAccholdername")) {
			empBankAccholdername = PadQuotes(inputObj.getString("empBankAccholdername"));
		}
		if (!inputObj.isNull("empBankAccno")) {
			empBankAccno = PadQuotes(inputObj.getString("empBankAccno"));
		}
		if (!inputObj.isNull("empBankBranchname")) {
			empBankBranchname = PadQuotes(inputObj.getString("empBankBranchname"));
		}
		if (!inputObj.isNull("empBankName")) {
			empBankName = PadQuotes(inputObj.getString("empBankName"));
		}
		if (!inputObj.isNull("empBillDiscountupdate")) {
			empBillDiscountupdate = inputObj.getString("empBillDiscountupdate");
		}
		if (!inputObj.isNull("empBillPriceupdate")) {
			empBillPriceupdate = inputObj.getString("empBillPriceupdate");
		}
		if (!inputObj.isNull("empCertification")) {
			empCertification = PadQuotes(inputObj.getString("empCertification"));
		}
		if (!inputObj.isNull("empCityId")) {
			empCityId = CNumeric(PadQuotes(inputObj.getString("empCityId")));
		}
		if (!inputObj.isNull("empCloseOppr")) {
			empCloseOppr = inputObj.getString("empCloseOppr");
		}
		if (!inputObj.isNull("empCopyAccess")) {
			empCopyAccess = inputObj.getString("empCopyAccess");
		}
		if (!inputObj.isNull("empCrm")) {
			empCrm = inputObj.getString("empCrm");
		}
		if (!inputObj.isNull("empDateOfJoin")) {
			empDateOfJoin = PadQuotes(inputObj.getString("empDateOfJoin"));
		}
		if (!inputObj.isNull("empDateOfRelieve")) {
			empDateOfRelieve = PadQuotes(inputObj.getString("empDateOfRelieve"));
		}
		if (!inputObj.isNull("empDealerJcExe")) {
			empDealerJcExe = PadQuotes(inputObj.getString("empDealerJcExe"));
		}
		if (!inputObj.isNull("empDealerJcTechnician")) {
			empDealerJcTechnician = PadQuotes(inputObj.getString("empDealerJcTechnician"));
		}
		if (!inputObj.isNull("empDeviceFcmtoken")) {
			empDeviceFcmtoken = PadQuotes(inputObj.getString("empDeviceFcmtoken"));
		}
		if (!inputObj.isNull("empDeviceId")) {
			empDeviceId = CNumeric(PadQuotes(inputObj.getString("empDeviceId")));
		}
		if (!inputObj.isNull("empDeviceOs")) {
			empDeviceOs = CNumeric(PadQuotes(inputObj.getString("empDeviceOs")));
		}
		if (!inputObj.isNull("empDispensaryId")) {
			empDispensaryId = CNumeric(PadQuotes(inputObj.getString("empDispensaryId")));
		}
		if (!inputObj.isNull("empDob")) {
			empDob = CNumeric(inputObj.getString("empDob"));
		}
		if (!inputObj.isNull("empEmailPassword")) {
			empEmailPassword = PadQuotes(inputObj.getString("empEmailPassword"));
		}
		if (!inputObj.isNull("empEmailPort")) {
			empEmailPort = PadQuotes(inputObj.getString("empEmailPort"));
		}
		if (!inputObj.isNull("empEmailServer")) {
			empEmailServer = PadQuotes(inputObj.getString("empEmailServer"));
		}
		if (!inputObj.isNull("empEmailSsl")) {
			empEmailSsl = PadQuotes(inputObj.getString("empEmailSsl"));
		}
		if (!inputObj.isNull("empEmailTls")) {
			empEmailTls = PadQuotes(inputObj.getString("empEmailTls"));
		}
		if (!inputObj.isNull("empEmailUsername")) {
			empEmailUsername = PadQuotes(inputObj.getString("empEmailUsername"));
		}
		if (!inputObj.isNull("empEmail1")) {
			empEmail1 = PadQuotes(inputObj.getString("empEmail1"));
		}
		if (!inputObj.isNull("empEmail2")) {
			empEmail2 = PadQuotes(inputObj.getString("empEmail2"));
		}
		if (!inputObj.isNull("empEntryDate")) {
			empEntryDate = PadQuotes(inputObj.getString("empEntryDate"));
		}
		if (!inputObj.isNull("empEntryId")) {
			empEntryId = CNumeric(PadQuotes(inputObj.getString("empEntryId")));
		}
		if (!inputObj.isNull("empEsiNo")) {
			empEsiNo = PadQuotes(inputObj.getString("empEsiNo"));
		}
		if (!inputObj.isNull("empExportAccess")) {
			empExportAccess = inputObj.getString("empExportAccess");
		}
		if (!inputObj.isNull("empFormatdateId")) {
			empFormatdateId = CNumeric(PadQuotes(inputObj.getString("empFormatdateId")));
		}
		if (!inputObj.isNull("empFormatdigitId")) {
			empFormatdigitId = CNumeric(PadQuotes(inputObj.getString("empFormatdigitId")));
		}

		if (!inputObj.isNull("empJobtitleId")) {
			empJobtitleId = CNumeric(PadQuotes(inputObj.getString("empJobtitleId")));
		}

		if (!inputObj.isNull("empFormattimeId")) {
			empFormattimeId = CNumeric(PadQuotes(inputObj.getString("empFormattimeId")));
		}
		if (!inputObj.isNull("empGender")) {
			empGender = PadQuotes(inputObj.getString("empGender"));
		}
		if (!inputObj.isNull("empInvoiceDiscountupdate")) {
			empInvoiceDiscountupdate = inputObj.getString("empInvoiceDiscountupdate");
		}
		if (!inputObj.isNull("empInvoicePriceupdate")) {
			empInvoicePriceupdate = inputObj.getString("empInvoicePriceupdate");
		}
		if (!inputObj.isNull("empIpAccess")) {
			empIpAccess = PadQuotes(inputObj.getString("empIpAccess"));
		}
		if (!inputObj.isNull("empJcDiscountupdate")) {
			empJcDiscountupdate = inputObj.getString("empJcDiscountupdate");
		}
		if (!inputObj.isNull("empJcPriceupdate")) {
			empJcPriceupdate = inputObj.getString("empJcPriceupdate");
		}

		if (!inputObj.isNull("empLandmark")) {
			empLandmark = PadQuotes(inputObj.getString("empLandmark"));
		}
		if (!inputObj.isNull("empMarried")) {
			empMarried = PadQuotes(inputObj.getString("empMarried"));
		}
		if (!inputObj.isNull("empMisAccess")) {
			empMisAccess = inputObj.getString("empMisAccess");
		}
		if (!inputObj.isNull("empMobile1")) {
			empMobile1 = PadQuotes(inputObj.getString("empMobile1"));
		}
		if (!inputObj.isNull("empMobile2")) {
			empMobile2 = PadQuotes(inputObj.getString("empMobile2"));
		}
		if (!inputObj.isNull("empModifiedDate")) {
			empModifiedDate = PadQuotes(inputObj.getString("empModifiedDate"));
		}
		if (!inputObj.isNull("empModifiedId")) {
			empModifiedId = PadQuotes(inputObj.getString("empModifiedId"));
		}
		if (!inputObj.isNull("empName")) {
			empName = PadQuotes(inputObj.getString("empName"));
		}
		if (!inputObj.isNull("empPfNo")) {
			empPfNo = CNumeric(PadQuotes(inputObj.getString("empPfNo")));
		}
		if (!inputObj.isNull("empPfNoDeptFile")) {
			empPfNoDeptFile = PadQuotes(inputObj.getString("empPfNoDeptFile"));
		}
		if (!inputObj.isNull("empPhone1")) {
			empPhone1 = PadQuotes(inputObj.getString("empPhone1"));
		}
		if (!inputObj.isNull("empPhone2")) {
			empPhone2 = PadQuotes(inputObj.getString("empPhone2"));
		}
		if (!inputObj.isNull("empPhoto")) {
			empPhoto = PadQuotes(inputObj.getString("empPhoto"));
		}
		if (!inputObj.isNull("empPin")) {
			empPin = PadQuotes(inputObj.getString("empPin"));
		}
		if (!inputObj.isNull("empPrbranchId")) {
			empPrbranchId = CNumeric(PadQuotes(inputObj.getString("empPrbranchId")));
		}
		if (!inputObj.isNull("empPriorityactivityLevel1")) {
			empPriorityactivityLevel1 = inputObj.getString("empPriorityactivityLevel1");
		}
		if (!inputObj.isNull("empPriorityactivityLevel2")) {
			empPriorityactivityLevel2 = inputObj.getString("empPriorityactivityLevel2");
		}
		if (!inputObj.isNull("empPriorityactivityLevel3")) {
			empPriorityactivityLevel3 = inputObj.getString("empPriorityactivityLevel3");
		}
		if (!inputObj.isNull("empPriorityactivityLevel4")) {
			empPriorityactivityLevel4 = inputObj.getString("empPriorityactivityLevel4");
		}
		if (!inputObj.isNull("empPriorityactivityLevel5")) {
			empPriorityactivityLevel5 = inputObj.getString("empPriorityactivityLevel5");
		}
		if (!inputObj.isNull("empPrioritybalanceLevel1")) {
			empPrioritybalanceLevel1 = inputObj.getString("empPrioritybalanceLevel1");
		}
		if (!inputObj.isNull("empPrioritybalanceLevel2")) {
			empPrioritybalanceLevel2 = inputObj.getString("empPrioritybalanceLevel2");
		}
		if (!inputObj.isNull("empPrioritybalanceLevel3")) {
			empPrioritybalanceLevel3 = inputObj.getString("empPrioritybalanceLevel3");
		}
		if (!inputObj.isNull("empPrioritybalanceLevel4")) {
			empPrioritybalanceLevel4 = inputObj.getString("empPrioritybalanceLevel4");
		}
		if (!inputObj.isNull("empPrioritybalanceLevel5")) {
			empPrioritybalanceLevel5 = inputObj.getString("empPrioritybalanceLevel5");
		}
		if (!inputObj.isNull("empPriorityjcLevel1")) {
			empPriorityjcLevel1 = inputObj.getString("empPriorityjcLevel1");
		}
		if (!inputObj.isNull("empPriorityjcLevel2")) {
			empPriorityjcLevel2 = inputObj.getString("empPriorityjcLevel2");
		}
		if (!inputObj.isNull("empPriorityjcLevel3")) {
			empPriorityjcLevel3 = inputObj.getString("empPriorityjcLevel3");
		}
		if (!inputObj.isNull("empPriorityjcLevel4")) {
			empPriorityjcLevel4 = inputObj.getString("empPriorityjcLevel4");
		}
		if (!inputObj.isNull("empPriorityjcLevel5")) {
			empPriorityjcLevel5 = inputObj.getString("empPriorityjcLevel5");
		}
		if (!inputObj.isNull("empPriorityopprLevel1")) {
			empPriorityopprLevel1 = inputObj.getString("empPriorityopprLevel1");
		}
		if (!inputObj.isNull("empPriorityopprLevel2")) {
			empPriorityopprLevel2 = inputObj.getString("empPriorityopprLevel2");
		}
		if (!inputObj.isNull("empPriorityopprLevel3")) {
			empPriorityopprLevel3 = inputObj.getString("empPriorityopprLevel3");
		}
		if (!inputObj.isNull("empPriorityopprLevel4")) {
			empPriorityopprLevel4 = inputObj.getString("empPriorityopprLevel4");
		}
		if (!inputObj.isNull("empPriorityopprLevel5")) {
			empPriorityopprLevel5 = inputObj.getString("empPriorityopprLevel5");
		}
		if (!inputObj.isNull("empPriorityopprfollowupLevel1")) {
			empPriorityopprfollowupLevel1 = inputObj.getString("empPriorityopprfollowupLevel1");
		}
		if (!inputObj.isNull("empPriorityopprfollowupLevel2")) {
			empPriorityopprfollowupLevel2 = inputObj.getString("empPriorityopprfollowupLevel2");
		}
		if (!inputObj.isNull("empPriorityopprfollowupLevel3")) {
			empPriorityopprfollowupLevel3 = inputObj.getString("empPriorityopprfollowupLevel3");
		}
		if (!inputObj.isNull("empPriorityopprfollowupLevel4")) {
			empPriorityopprfollowupLevel4 = inputObj.getString("empPriorityopprfollowupLevel4");
		}
		if (!inputObj.isNull("empPriorityopprfollowupLevel5")) {
			empPriorityopprfollowupLevel5 = inputObj.getString("empPriorityopprfollowupLevel5");
		}
		if (!inputObj.isNull("empPriorityprojectLevel1")) {
			empPriorityprojectLevel1 = inputObj.getString("empPriorityprojectLevel1");
		}
		if (!inputObj.isNull("empPriorityprojectLevel2")) {
			empPriorityprojectLevel2 = inputObj.getString("empPriorityprojectLevel2");
		}
		if (!inputObj.isNull("empPriorityprojectLevel3")) {
			empPriorityprojectLevel3 = inputObj.getString("empPriorityprojectLevel3");
		}
		if (!inputObj.isNull("empPriorityprojectLevel4")) {
			empPriorityprojectLevel4 = inputObj.getString("empPriorityprojectLevel4");
		}
		if (!inputObj.isNull("empPriorityprojectLevel5")) {
			empPriorityprojectLevel5 = inputObj.getString("empPriorityprojectLevel5");
		}
		if (!inputObj.isNull("empPrioritytaskLevel1")) {
			empPrioritytaskLevel1 = inputObj.getString("empPrioritytaskLevel1");
		}
		if (!inputObj.isNull("empPrioritytaskLevel2")) {
			empPrioritytaskLevel2 = inputObj.getString("empPrioritytaskLevel2");
		}
		if (!inputObj.isNull("empPrioritytaskLevel3")) {
			empPrioritytaskLevel3 = inputObj.getString("empPrioritytaskLevel3");
		}
		if (!inputObj.isNull("empPrioritytaskLevel4")) {
			empPrioritytaskLevel4 = inputObj.getString("empPrioritytaskLevel4");
		}
		if (!inputObj.isNull("empPrioritytaskLevel5")) {
			empPrioritytaskLevel5 = inputObj.getString("empPrioritytaskLevel5");
		}
		if (!inputObj.isNull("empPriorityticketLevel1")) {
			empPriorityticketLevel1 = inputObj.getString("empPriorityticketLevel1");
		}
		if (!inputObj.isNull("empPriorityticketLevel2")) {
			empPriorityticketLevel2 = inputObj.getString("empPriorityticketLevel2");
		}
		if (!inputObj.isNull("empPriorityticketLevel3")) {
			empPriorityticketLevel3 = inputObj.getString("empPriorityticketLevel3");
		}
		if (!inputObj.isNull("empPriorityticketLevel4")) {
			empPriorityticketLevel4 = inputObj.getString("empPriorityticketLevel4");
		}
		if (!inputObj.isNull("empPriorityticketLevel5")) {
			empPriorityticketLevel5 = inputObj.getString("empPriorityticketLevel5");
		}
		if (!inputObj.isNull("empProdJcExe")) {
			empProdJcExe = inputObj.getString("empPriorityticketLevel5");
		}
		if (!inputObj.isNull("empQualification")) {
			empQualification = PadQuotes(inputObj.getString("empQualification"));
		}
		if (!inputObj.isNull("empQuoteDiscountupdate")) {
			empQuoteDiscountupdate = inputObj.getString("empQuoteDiscountupdate");
		}

		if (!inputObj.isNull("empDepartmentId")) {
			empDepartmentId = CNumeric((PadQuotes(inputObj.getString("empDepartmentId"))));
		}
		if (!inputObj.isNull("empQuotePriceupdate")) {
			empQuotePriceupdate = inputObj.getString("empQuotePriceupdate");
		}
		if (!inputObj.isNull("empReasonOfLeaving")) {
			empReasonOfLeaving = PadQuotes(inputObj.getString("empReasonOfLeaving"));
		}
		if (!inputObj.isNull("empRefNo")) {
			empRefNo = PadQuotes(inputObj.getString("empRefNo"));
		}
		if (!inputObj.isNull("empReportAccess")) {
			empReportAccess = inputObj.getString("empReportAccess");
		}
		if (!inputObj.isNull("empSalCalcFrom")) {
			empSalCalcFrom = PadQuotes(inputObj.getString("empSalCalcFrom"));
		}
		if (!inputObj.isNull("empSales")) {
			empSales = inputObj.getString("empSales");
		}
		if (!inputObj.isNull("empService")) {
			empService = inputObj.getString("empService");
		}
		if (!inputObj.isNull("empServicePsf")) {
			empServicePsf = inputObj.getString("empServicePsf");
		}
		if (!inputObj.isNull("empSex")) {
			empSex = PadQuotes(inputObj.getString("empSex"));
		}
		if (!inputObj.isNull("empSoDiscountupdate")) {
			empSoDiscountupdate = inputObj.getString("empSoDiscountupdate");
		}
		if (!inputObj.isNull("empSoPriceupdate")) {
			empSoPriceupdate = inputObj.getString("empSoPriceupdate");
		}

		if (!inputObj.isNull("empNotes")) {
			empNotes = inputObj.getString("empNotes");
		}
		if (!inputObj.isNull("empBranchId")) {
			empBranchId = inputObj.getString("empBranchId");
		}
		if (!inputObj.isNull("empStructureId")) {
			empStructureId = inputObj.getString("empStructureId");
		}
		if (!inputObj.isNull("empTechnician")) {
			empTechnician = inputObj.getString("empTechnician");
		}
		if (!inputObj.isNull("empThemeId")) {
			empThemeId = CNumeric(PadQuotes(inputObj.getString("empThemeId")));
		}
		if (!inputObj.isNull("empTicketClose")) {
			empTicketClose = inputObj.getString("empTicketClose");
		}
		if (!inputObj.isNull("empTicketOwner")) {
			empTicketOwner = inputObj.getString("empTicketOwner");
		}
		if (!inputObj.isNull("empTimeout")) {
			empTimeout = PadQuotes(inputObj.getString("empTimeout"));
		}
		if (!inputObj.isNull("empUname")) {
			empUname = PadQuotes(inputObj.getString("empUname"));
		}
		if (!inputObj.isNull("empUpass")) {
			empUpass = PadQuotes(inputObj.getString("empUpass"));
		}
		if (!inputObj.isNull("empUuid")) {
			empUuid = PadQuotes((inputObj.getString("empUuid")));
		}

		if (!inputObj.isNull("dropDay")) {
			dropDay = PadQuotes((inputObj.getString("dropDay")));
		}

		if (!inputObj.isNull("dropMonth")) {
			dropMonth = PadQuotes((inputObj.getString("dropMonth")));
		}

		if (!inputObj.isNull("dropYear")) {
			dropYear = PadQuotes((inputObj.getString("dropYear")));
		}

		// multiple select====all branches===
		if (!inputObj.isNull("empEmpBranchId")) {
			JSONArray inputArray = inputObj.getJSONArray("empEmpBranchId");
			for (int i = 0; i < inputArray.length(); i++) {
				empEmpBranchId += inputArray.getString(i) + ",";
			}
			if (empEmpBranchId.length() > 0) {
				empEmpBranchId = empEmpBranchId.substring(0, empEmpBranchId.length());
			}
		}
		if (!inputObj.isNull("empaccessAccessId")) {
			JSONArray inputArray = inputObj.getJSONArray("empaccessAccessId");
			for (int i = 0; i < inputArray.length(); i++) {
				empaccessAccessId += inputArray.getString(i) + ",";
			}
			if (empaccessAccessId.length() > 0) {
				empaccessAccessId = empaccessAccessId.substring(0, empaccessAccessId.length());
			}
		}

		if (AppRun().equals("0")) {
			SOP("inputObj==========TeamService==========" + inputObj.toString());
		}

	}

	public void validateFields() throws ParseException {
		msg = "";
		if (empId.equals("1")) {
			empRoleId = "1";
			empBranchId = "0";
			empMisAccess = "1";
			empExportAccess = "1";
			empReportAccess = "1";
			empActive = "1";
		}

		if (empName.equals("")) {
			msg += "<br>Enter Name!";
		}

		if (empRefNo.equals("")) {
			msg += "<br>Enter Ref.No!";
		} else
		{
			String axelaEmp = "";
			if (requestType.equals("add")) {
				axelaEmp = PadQuotes(axelaEmpRepository.findByEmpRefNo(empRefNo));
			} else if (requestType.equals("update")) {
				axelaEmp = PadQuotes(axelaEmpRepository.findByEmpRefNoById(empRefNo, Integer.parseInt(empId)));
			}
			if (!axelaEmp.isEmpty()) {
				msg += "<br>Similar " + "Ref.No" + " found!";
			}
		}

		if (empRoleId.equals("0")) {
			msg += "<br>Select Role!";
		} else {
			if (empRoleId.equals("1") && !empBranchId.equals("-1") && !empBranchId.equals("0")) {
				msg += "<br>Select Head Office branch for Administrator Role!";
			}
		}

		if (empDepartmentId.equals("0")) {
			msg += "<br>Select Department!";
		}

		if (empJobtitleId.equals("0")) {
			msg += "<br>Select Job Title!";
		}

		if (empMarried.equals("0")) {
			msg += "<br>Select Marital Status!";
		}

		if (empGender.equals("0")) {
			msg += "<br>Select Gender!";
		}
		if (empPhone1.equals("") && empMobile1.equals("")) {
			msg += "<br>Enter either Mobile No. or Phone No.!";
		}

		if (!empMobile1.equals("")) {
			if (IsValidMobileNo(empMobile1)) {
				String EmpMobile = "";
				EmpMobile = PadQuotes(axelaEmpRepository.findByEmpMobile(empMobile1, Integer.parseInt(empId)));
				if (EmpMobile.equals(empMobile1)) {
					msg += "<br>Similiar Mobile1 found!";
				}
			} else {
				msg += "<br>Enter valid Mobile1!";
			}
		}

		if (!empMobile2.equals("") && !IsValidMobileNo(empMobile2)) {
			msg += "<br>Enter valid Mobile2!";
		}

		if (empEmail1.equals("")) {
			msg += "<br>Enter Email1!";
		} else {
			empEmail1 = empEmail1.toLowerCase();
			if (IsValidEmail(empEmail1) == false) {
				msg += "<br>Invalid Email1";
			} else {
				String StrSql = "0";
				if (requestType.equals("add")) {
					StrSql = CNumeric(PadQuotes(String.valueOf(axelaEmpRepository.findByEmpEmail1(empEmail1))));
				}
				if (requestType.equals("update")) {
					StrSql = CNumeric(PadQuotes(String.valueOf(axelaEmpRepository.findByEmpEmail1WithId(empEmail1, Integer.parseInt(empId)))));
				}
				if (!StrSql.equals("0")) {
					msg = msg + "<br>Similar Email1 Found";
				}
			}
		}

		if (!empEmail2.equals("")) {
			empEmail2 = empEmail2.toLowerCase();
			if (IsValidEmail(empEmail2) == false) {
				msg += "<br>Invalid Email2";
			} else if (!empEmail1.equals("") && empEmail1.equals(empEmail2)) {
				msg = msg + "<br>Email2 is same as Email1!";
			} else {
				String StrSql = "0";
				if (requestType.equals("add")) {
					StrSql = CNumeric(PadQuotes(String.valueOf(axelaEmpRepository.findByEmpEmail2(empEmail1))));
				}
				if (requestType.equals("update")) {
					StrSql = CNumeric(PadQuotes(axelaEmpRepository.findByEmpEmail2WithId(empEmail2, Integer.parseInt(empId))));
					System.out.println("StrSql=123=========" + StrSql);
				}
				if (!StrSql.equals("0")) {
					msg = msg + "<br>Similar Email2 Found";
				}
			}
		}

		if (empAddress.equals("")) {
			msg += "<br>Enter Address!";
		}

		if (empCityId.equals("")) {
			msg += "<br>Enter City!";
		}

		if (empPin.equals("")) {
			msg += "<br>Enter Pin/Zip!";
		} else if (!isNumeric(empPin)) {
			msg += "<br>Pin: Enter Numeric!";
		}
		if (empBranchId.equals("-1")) {
			msg += "<br>Select Branch!";
		}

		if (empId.equals("1") && empActive.equals("0")) {
			msg += "<br>Adminsitrator can't be Inactive!";
		}

		String[] str = new String[10];
		if (!empIpAccess.equals("")) {
			str = empIpAccess.split(" ");
			for (int i = 0; i < str.length - 1; i++) {
				if (!str[i].endsWith(",")) {
					msg += "<br>Invalid IP Access!";
				}
			}

			if (str[str.length - 1].contains(",")) {
				msg += "<br>Invalid IP Access!";
			}
		}

		if (empDateOfJoin.equals("")) {
			msg += "<br>Enter Join Date!";
		} else {
			if (!isValidDateFormat(empDateOfJoin, empFormatdate)) {
				msg += "<br>Enter Valid Join Date!";
			} else {
				empDateOfJoin = formatDateStr(empDateOfJoin, empFormatdate);
			}
		}
		if (!empDateOfRelieve.equals("")) {
			if (!isValidDateFormat(empDateOfRelieve, empFormatdate)) {
				msg += "<br>Enter Valid Relieve Date!";
			} else {
				empDateOfRelieve = formatDateStr(empDateOfRelieve, empFormatdate);
				if (isValidDateFormat(dateOfJoin, empFormatdate) && !empDateOfJoin.equals("")) {
					empDateOfJoin = formatDateStr(empDateOfJoin, empFormatdate);
					if (Long.parseLong(empDateOfRelieve) < Long.parseLong(empDateOfJoin)) {
						msg += "<br>Relieve Date should be greater than Join Date!";
					}
				}
			}
		}

		if (empNotes.length() > 8000) {
			empNotes = empNotes.substring(0, 7999);
		}

		// if (!dropYear.equals("0") || !dropMonth.equals("0") || !dropDay.equals("0")) {
		// if (dropYear.equals("0")) {
		// msg += "<br>DOB: Select Year!";
		// }
		//
		// if (dropMonth.equals("0")) {
		// msg += "<br>DOB: Select Month!";
		// }
		//
		// if (dropDay.equals("0")) {
		// msg += "<br>DOB: Select Day!";
		// }
		//
		// if (!dropYear.equals("0") && !dropMonth.equals("0") && !dropDay.equals("0")) {
		// empDob = dropYear + doublenum(Integer.parseInt(dropMonth)) + doublenum(Integer.parseInt(dropDay)) + "000000";
		// if (!isValidDateFormatShort(doublenum(Integer.parseInt(dropDay)) + "/" + doublenum(Integer.parseInt(dropMonth)) + "/" + dropYear)) {
		// msg += "<br>DOB: Select Valid Date!";
		// }
		// }
		// }

	}
	public void addFields(HttpServletResponse response, HttpSession session) throws ParseException, NumberFormatException, JSONException {
		validateFields();
		// String empEmpBranchIdFromdb = null;
		// String empexeExeIdFromdb = null;
		AxelaEmp axelaEmp = null;
		AxelaEmpBranch empBranch = null;
		AxelaEmpExe empExe = null;
		AxelaEmpAccess empAccess = null;
		if (msg.equals("")) {
			if (!empId.equals("0")) {
				axelaEmp = axelaEmpRepository.findOne(Integer.parseInt(empId));
			} else {
				axelaEmp = new AxelaEmp();
			}
			if (requestType.equals("add")) {
				axelaEmp.setEmpId(CheckCurrentId(axelaEmpRepository.findMaxEmpId()));
			}

			axelaEmp.setEmpUuid(empUuid);
			axelaEmp.setEmpName(empName);
			axelaEmp.setEmpPhoto((empPhoto.getBytes()));
			axelaEmp.setEmpUname(empUname);
			axelaEmp.setEmpRoleId(empRoleId);
			axelaEmp.setEmpDepartmentId(empDepartmentId);
			axelaEmp.setEmpUpass(empUpass);
			axelaEmp.setEmpRefNo(empRefNo);
			axelaEmp.setEmpJobtitleId(Integer.parseInt(empJobtitleId));
			axelaEmp.setEmpGender(empGender);
			axelaEmp.setEmpDob(stringToDate(dobAddUtil(dropDay, dropMonth, dropYear)));
			axelaEmp.setEmpMarried(empMarried);
			axelaEmp.setEmpQualification(empQualification);
			axelaEmp.setEmpCertification(empCertification);
			axelaEmp.setEmpPhone1(empPhone1);
			axelaEmp.setEmpPhone2(empPhone2);
			axelaEmp.setEmpMobile1(empMobile1);
			axelaEmp.setEmpMobile2(empMobile2);
			axelaEmp.setEmpEmail1(empEmail1);
			axelaEmp.setEmpEmail2(empEmail2);
			axelaEmp.setEmpAddress(empAddress);
			axelaEmp.setEmpCityId(Integer.parseInt(empCityId));
			axelaEmp.setEmpPin(empPin);
			axelaEmp.setEmpDeviceFcmtoken(empDeviceFcmtoken);
			axelaEmp.setEmpLandmark(empLandmark);
			axelaEmp.setEmpActive(empActive);
			axelaEmp.setEmpBranchId(Integer.parseInt(empBranchId));
			axelaEmp.setEmpSales(empSales);
			axelaEmp.setEmpCloseOppr(empCloseOppr);
			axelaEmp.setEmpBillPriceupdate(empBillPriceupdate);
			axelaEmp.setEmpBillDiscountupdate(empBillDiscountupdate);
			axelaEmp.setEmpSoPriceupdate(empSoPriceupdate);
			axelaEmp.setEmpSoDiscountupdate(empSoDiscountupdate);
			axelaEmp.setEmpQuotePriceupdate(empQuotePriceupdate);
			axelaEmp.setEmpQuoteDiscountupdate(empQuoteDiscountupdate);
			axelaEmp.setEmpProdJcExe(empProdJcExe);
			axelaEmp.setEmpService(empService);
			axelaEmp.setEmpTechnician(empTechnician);
			axelaEmp.setEmpServicePsf(empServicePsf);
			axelaEmp.setEmpCrm(empCrm);
			axelaEmp.setEmpJcPriceupdate(empJcPriceupdate);
			axelaEmp.setEmpJcDiscountupdate(empJcDiscountupdate);
			axelaEmp.setEmpDeviceId(empDeviceId);
			axelaEmp.setEmpDeviceOs(empDeviceOs);
			axelaEmp.setEmpEmailPassword(empEmailPassword);
			axelaEmp.setEmpEmailPort(empEmailPort);
			axelaEmp.setEmpEmailServer(empEmailServer);
			axelaEmp.setEmpEmailSsl(empEmailSsl);
			axelaEmp.setEmpEmailTls(empEmailTls);
			axelaEmp.setEmpEmailUsername(empEmailUsername);
			axelaEmp.setEmpIpAccess(empIpAccess);
			axelaEmp.setEmpTicketOwner(empTicketOwner);
			axelaEmp.setEmpTicketClose(empTicketClose);
			axelaEmp.setEmpMisAccess(empMisAccess);
			axelaEmp.setEmpSex(empSex);
			axelaEmp.setEmpExportAccess(empExportAccess);
			axelaEmp.setEmpReportAccess(empReportAccess);
			axelaEmp.setEmpCopyAccess(empCopyAccess);
			axelaEmp.setEmpPriorityactivityLevel1(empPriorityactivityLevel1);
			axelaEmp.setEmpPriorityactivityLevel2(empPriorityactivityLevel2);
			axelaEmp.setEmpPriorityactivityLevel3(empPriorityactivityLevel3);
			axelaEmp.setEmpPriorityactivityLevel4(empPriorityactivityLevel4);
			axelaEmp.setEmpPriorityactivityLevel5(empPriorityactivityLevel5);
			axelaEmp.setEmpPriorityprojectLevel1(empPriorityprojectLevel1);
			axelaEmp.setEmpPriorityprojectLevel2(empPriorityprojectLevel2);
			axelaEmp.setEmpPriorityprojectLevel3(empPriorityprojectLevel3);
			axelaEmp.setEmpPriorityprojectLevel4(empPriorityprojectLevel4);
			axelaEmp.setEmpPriorityprojectLevel5(empPriorityprojectLevel5);
			axelaEmp.setEmpPrioritytaskLevel1(empPrioritytaskLevel1);
			axelaEmp.setEmpPrioritytaskLevel2(empPrioritytaskLevel2);
			axelaEmp.setEmpPrioritytaskLevel3(empPrioritytaskLevel3);
			axelaEmp.setEmpPrioritytaskLevel4(empPrioritytaskLevel4);
			axelaEmp.setEmpPrioritytaskLevel5(empPrioritytaskLevel5);
			axelaEmp.setEmpPriorityopprfollowupLevel1(empPriorityopprfollowupLevel1);
			axelaEmp.setEmpPriorityopprfollowupLevel2(empPriorityopprfollowupLevel2);
			axelaEmp.setEmpPriorityopprfollowupLevel3(empPriorityopprfollowupLevel3);
			axelaEmp.setEmpPriorityopprfollowupLevel4(empPriorityopprfollowupLevel4);
			axelaEmp.setEmpPriorityopprfollowupLevel5(empPriorityopprfollowupLevel5);
			axelaEmp.setEmpPriorityopprLevel1(empPriorityopprLevel1);
			axelaEmp.setEmpPriorityopprLevel2(empPriorityopprLevel2);
			axelaEmp.setEmpPriorityopprLevel3(empPriorityopprLevel3);
			axelaEmp.setEmpPriorityopprLevel4(empPriorityopprLevel4);
			axelaEmp.setEmpPriorityopprLevel5(empPriorityopprLevel5);
			axelaEmp.setEmpPrioritybalanceLevel1(empPrioritybalanceLevel1);
			axelaEmp.setEmpPrioritybalanceLevel2(empPrioritybalanceLevel2);
			axelaEmp.setEmpPrioritybalanceLevel3(empPrioritybalanceLevel3);
			axelaEmp.setEmpPrioritybalanceLevel4(empPrioritybalanceLevel4);
			axelaEmp.setEmpPrioritybalanceLevel5(empPrioritybalanceLevel5);
			axelaEmp.setEmpPriorityjcLevel1(empPriorityjcLevel1);
			axelaEmp.setEmpPriorityjcLevel2(empPriorityjcLevel2);
			axelaEmp.setEmpPriorityjcLevel3(empPriorityjcLevel3);
			axelaEmp.setEmpPriorityjcLevel4(empPriorityjcLevel4);
			axelaEmp.setEmpPriorityjcLevel5(empPriorityjcLevel5);
			axelaEmp.setEmpPriorityticketLevel1(empPriorityticketLevel1);
			axelaEmp.setEmpPriorityticketLevel2(empPriorityticketLevel2);
			axelaEmp.setEmpPriorityticketLevel3(empPriorityticketLevel3);
			axelaEmp.setEmpPriorityticketLevel4(empPriorityticketLevel4);
			axelaEmp.setEmpPriorityticketLevel5(empPriorityticketLevel5);
			axelaEmp.setEmpPrbranchId(Integer.parseInt(empBranchId));
			axelaEmp.setEmpDealerJcExe(empDealerJcExe);
			axelaEmp.setEmpDealerJcTechnician(empDealerJcTechnician);
			axelaEmp.setEmpStructureId(Integer.parseInt(empStructureId));
			axelaEmp.setEmpSalCalcFrom(stringToDate(empSalCalcFrom));
			axelaEmp.setEmpEsiNo(empEsiNo);
			axelaEmp.setEmpDispensaryId(Integer.parseInt(empDispensaryId));
			axelaEmp.setEmpPfNo(Integer.parseInt(empPfNo));
			axelaEmp.setEmpPfNoDeptFile(Integer.parseInt(empPfNoDeptFile));

			axelaEmp.setEmpAllExe(empAllExe);
			axelaEmp.setEmpAllBranches(empAllBranches);

			axelaEmp.setEmpInvoicePriceupdate(empInvoicePriceupdate);
			axelaEmp.setEmpInvoiceDiscountupdate(empInvoiceDiscountupdate);
			axelaEmp.setEmpBankName(empBankName);
			axelaEmp.setEmpBankBranchname(empBankBranchname);
			axelaEmp.setEmpBankAccno(empBankAccno);
			axelaEmp.setEmpBankAccholdername(empBankAccholdername);
			axelaEmp.setEmpDateOfJoin(stringToDate(empDateOfJoin));
			axelaEmp.setEmpDateOfRelieve(stringToDate(empDateOfRelieve));
			axelaEmp.setEmpReasonOfLeaving(empReasonOfLeaving);
			axelaEmp.setEmpNotes(empNotes);
			axelaEmp.setEmpFormatdateId(Byte.parseByte(empFormatdateId));
			axelaEmp.setEmpFormatdigitId(Byte.parseByte(empFormatdigitId));
			axelaEmp.setEmpFormattimeId(Byte.parseByte(empFormattimeId));
			axelaEmp.setEmpThemeId(Byte.parseByte("1"));
			axelaEmp.setEmpEntryId(Integer.parseInt(empSessionId));
			axelaEmp.setEmpRecperpage(Byte.parseByte(empRecperpage));
			axelaEmp.setEmpAreaId(Byte.parseByte(empAreaId));
			axelaEmp.setEmpEntryDate(stringToDate(empEntryDate));
			axelaEmp.setEmpStatus("");

			if (empId.equals("0") && requestType.equals("add")) {
				axelaEmp.setEmpEntryDate(getTimeByZone(session));
				axelaEmp.setEmpEntryId(Integer.parseInt(empSessionId));
				axelaEmp.setEmpModifiedId(0);
			} else {
				axelaEmp.setEmpModifiedId(Integer.parseInt(empSessionId));
				axelaEmp.setEmpModifiedDate(getTimeByZone(session));
			}
			AxelaEmp result = null;
			empId = axelaEmpRepository.save(axelaEmp).getEmpId() + "";

			if (requestType.equals("update")) {
				SOP("update mode for executive=========1111==");
				if (!empId.equals("0")) {
					empBranchrepository.deletebyEmpId(Integer.parseInt(empId));
					empExeRepository.deleteByEmpId(Integer.parseInt(empId));
					empAccessRepository.deleteByEmpId(Integer.parseInt(empId));
				}
			}

			if (empAllBranches.equals("0")) {
				if (empAllBranch.length() > 0) {
					for (int i = 0; i < empAllBranch.length(); i++) {
						if (empAllBranch.get(i) != null && !(empAllBranch.get(i)).equals("")) {
							empBranch = new AxelaEmpBranch();
							empBranch.setEmpId(Integer.parseInt(empId));
							empBranch.setEmpEmpbranchId(Integer.valueOf((empAllBranch.get(i) + "")));
							empBranchrepository.save(empBranch);
						}
					}
				}
			}

			if (empAllExe.equals("0")) {
				if (empAllExecutive.length() > 0) {
					for (int i = 0; i < empAllExecutive.length(); i++) {
						if (empAllExecutive.get(i) != null && !(empAllExecutive.get(i)).equals("")) {
							empExe = new AxelaEmpExe();
							empExe.setEmpexeEmpId(Integer.parseInt(empId));
							empExe.setEmpexeExeId(Integer.valueOf((empAllExecutive.get(i) + "")));
							empExeRepository.save(empExe);
						}
					}
				}
			}

			if (!empId.equals("0") && requestType.equals("add")) {
				output.put("successmsg", "Executive Added Successfully!");
				output.put("empId", empId);
			} else if (!empId.equals("0") && requestType.equals("update")) {
				output.put("successmsg", "Executive Updated Successfully!");
				output.put("empId", empId);
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}
	public void deleteFields(String empId) {

		if (empId.equals(1)) {
			msg += "<br>Cannot Delete Administrator!";
		}
		// association for Activity
		StrSql = CNumeric(PadQuotes(String.valueOf(activityRepository.findByActivityEmpId(Integer.parseInt(empId)))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with Activity!";
		}
		// association for configCustomerName
		StrSql = CNumeric(PadQuotes(String.valueOf(customerRepository.findByCustomerEmpId(Integer.parseInt(empId)))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + "is associated with " + configCustomerName + "!";
		}
		// association for Task
		StrSql = CNumeric(PadQuotes(String.valueOf(pmTaskRepository.findBytaskEmpId(Integer.parseInt(empId)))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with Task!";
		}
		// association for Lead
		StrSql = CNumeric(PadQuotes(String.valueOf(mktgLeadRepository.findByLeadEmpId(Integer.parseInt(empId)))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + "  is associated with Lead!";
		}
		// association for configSalesOpprName
		StrSql = CNumeric(PadQuotes(String.valueOf(opprRepository.findByOpprEmpId(Integer.parseInt(empId)))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + "  is associated with " + configSalesOpprName + "!";
		}
		// association for Voucher
		StrSql = CNumeric(PadQuotes(String.valueOf(accVoucherRepository.findByVoucherEmpId(Integer.parseInt(empId)))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + "  is associated with  Voucher !";
		}
		// association for Target
		StrSql = CNumeric(PadQuotes(String.valueOf(salesTargetRepository.findByTargetEmpId(Integer.parseInt(empId)))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + "  is associated with  Target !";
		}
		// association for Team
		StrSql = CNumeric(PadQuotes(String.valueOf(salesTeamRepository.findByTeamEmpId(Integer.parseInt(empId)))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + "  is associated with  Team !";
		}
		// association for Ticket
		StrSql = CNumeric(PadQuotes(String.valueOf(serviceTicketRepository.findByTicketId(Integer.parseInt(empId)))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + "  is associated with  Ticket !";
		}
		// association for Job Card
		StrSql = CNumeric(PadQuotes(String.valueOf(jCRepository.findById(Integer.parseInt(empId)))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + "  is associated with  Job Card !";
		}
		// association for Contract
		StrSql = CNumeric(PadQuotes(String.valueOf(serviceContractRepository.findByContractEmpId(Integer.parseInt(empId)))));
		SOP("StrSql=====2323232323232323232323======" + StrSql);
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + "  is associated with  Contract !";
		}
		// association for Contract Service
		StrSql = CNumeric(PadQuotes(String.valueOf(serviceContractServiceRepository.findByServiceEmpId(Integer.parseInt(empId)))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + "  is associated with  Contract Service !";
		}
		// association for Production Job Card
		StrSql = CNumeric(PadQuotes(String.valueOf(prodJobCardRepository.findByjobCardEmpId(Integer.parseInt(empId)))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + "  is associated with  Production Job Card !";
		}
		// association for Asset Issue
		StrSql = CNumeric(PadQuotes(String.valueOf(assetIssueRepository.findByIssueEmpId(Integer.parseInt(empId)))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + "  is associated with   Asset Issue !";
		}
		// association for Employee Leave
		StrSql = CNumeric(PadQuotes(String.valueOf(empLeaveRepository.findByLeaveEmpId(Integer.parseInt(empId)))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + "  is associated with  Employee Leave !";
		}
		// association for Employee Attendance
		StrSql = CNumeric(PadQuotes(String.valueOf(EmpAttRepository.findByAttEmpId(Integer.parseInt(empId)))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + "  is associated with  Emplyoee Attendance !";
		}

		if (msg.equals("")) {
			axelaEmpRepository.delete(Integer.parseInt(empId));
			empAccessRepository.deleteByEmpId(Integer.parseInt(empId));
			empExeRepository.deleteByEmpId(Integer.parseInt(empId));
			empDocRepository.deleteByAxelaEmpDoc(Integer.parseInt(empId));
			output.put("successmsg", "Executive Deleted Successfully!");
			if (AppRun().equals("0")) {
				SOP("output==========executiveService==========" + output.toString());
			}

		}
		else {
			output.put("msg", msg);
			msg = "";
		}
	}
	public Map populateData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		output = new HashMap<String, String>();
		inputObj = new JSONObject(input);
		AxelaEmp axelaEmp = null;
		if (!inputObj.isNull("empId")) {
			empId = CNumeric(inputObj.getString("empId"));
		}
		if (AppRun().equals("0")) {
			SOP("inputObj==========executiveService==========" + inputObj.toString());
		}

		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap map = new HashMap();
		if (!empId.equals("0")) {
			AxelaEmp emp = axelaEmpRepository.findByEmpId(Integer.parseInt(empId));

			map.put("empAddress", String.valueOf(emp.getEmpAddress()));
			map.put("empActive", emp.getEmpActive());
			map.put("empAllBranches", emp.getEmpAllBranches());
			map.put("empAllExe", emp.getEmpAllExe());
			map.put("empAreaId", String.valueOf(emp.getEmpAreaId()));
			map.put("empRoleId", String.valueOf(emp.getEmpRoleId()));
			map.put("empBankAccholdername", String.valueOf(emp.getEmpBankAccholdername()));
			map.put("empBankAccno", String.valueOf(emp.getEmpBankAccno()));
			map.put("empBankBranchname", String.valueOf(emp.getEmpBankBranchname()));
			map.put("empBankName", String.valueOf(emp.getEmpBankName()));
			map.put("empBillDiscountupdate", emp.getEmpBillDiscountupdate());
			map.put("empBillPriceupdate", emp.getEmpBillPriceupdate());
			map.put("empCertification", String.valueOf(emp.getEmpCertification()));
			map.put("empCloseOppr", emp.getEmpCloseOppr());
			map.put("empCopyAccess", emp.getEmpCopyAccess());
			map.put("empCrm", emp.getEmpCrm());
			if ((strToShortDate(emp.getEmpDateOfJoin()).contains("01/01/1971"))) {
				map.put("empDateOfJoin", "");
			} else {
				map.put("empDateOfJoin", strToShortDate(emp.getEmpDateOfJoin()) + "");
			}
			if ((strToShortDate(emp.getEmpDateOfRelieve()).contains("01/01/1971"))) {
				map.put("empDateOfRelieve", "");
			} else {
				map.put("empDateOfRelieve", strToShortDate(emp.getEmpDateOfRelieve()) + "");
			}
			map.put("empDealerJcExe", emp.getEmpDealerJcExe());
			map.put("empDealerJcTechnician", emp.getEmpDealerJcTechnician());
			map.put("empDeviceFcmtoken", String.valueOf(emp.getEmpDeviceFcmtoken()));
			map.put("empDeviceId", String.valueOf(emp.getEmpDeviceId()));
			map.put("empDeviceOs", String.valueOf(emp.getEmpDeviceOs()));
			map.put("empDispensaryId", String.valueOf(emp.getEmpDispensaryId()));
			map.put("empDob", String.valueOf(emp.getEmpDob()));
			map.put("empEmailPassword", String.valueOf(emp.getEmpEmailPassword()));
			map.put("empEmailPort", String.valueOf(emp.getEmpEmailPort()));
			map.put("empEmailServer", String.valueOf(emp.getEmpEmailServer()));
			map.put("empEmailSsl", String.valueOf(emp.getEmpEmailSsl()));
			map.put("empEmailTls", String.valueOf(emp.getEmpEmailTls()));
			map.put("empEmailUsername", String.valueOf(emp.getEmpEmailUsername()));
			map.put("empEmail1", String.valueOf(emp.getEmpEmail1()));
			map.put("empEmail2", String.valueOf(emp.getEmpEmail2()));
			map.put("empEsiNo", String.valueOf(emp.getEmpEsiNo()));
			map.put("empExportAccess", emp.getEmpExportAccess());
			map.put("empFormatdateId", String.valueOf(emp.getEmpFormatdateId()));
			map.put("empFormatdigitId", String.valueOf(emp.getEmpFormatdigitId()));
			map.put("empFormattimeId", String.valueOf(emp.getEmpFormattimeId()));
			map.put("empGender", String.valueOf(emp.getEmpGender()));
			map.put("empInvoiceDiscountupdate", emp.getEmpInvoiceDiscountupdate());
			map.put("empInvoicePriceupdate", emp.getEmpInvoicePriceupdate());
			map.put("empIpAccess", String.valueOf(emp.getEmpIpAccess()));
			map.put("empCityId", String.valueOf(emp.getEmpCityId()));

			map.put("empJcDiscountupdate", emp.getEmpJcDiscountupdate());
			map.put("empJcPriceupdate", emp.getEmpJcPriceupdate());
			map.put("empLandmark", String.valueOf(emp.getEmpLandmark()));
			map.put("empMarried", String.valueOf(emp.getEmpMarried()));
			map.put("empMisAccess", emp.getEmpMisAccess());
			map.put("empMobile1", String.valueOf(emp.getEmpMobile1()));
			map.put("empMobile2", String.valueOf(emp.getEmpMobile2()));
			map.put("empName", String.valueOf(emp.getEmpName()));
			map.put("empPfNo", String.valueOf(emp.getEmpPfNo()));
			map.put("empPfNoDeptFile", String.valueOf(emp.getEmpPfNoDeptFile()));
			map.put("empPhone1", String.valueOf(emp.getEmpPhone1()));
			map.put("empPhone2", String.valueOf(emp.getEmpPhone2()));
			map.put("empPhone2", String.valueOf(emp.getEmpPhone2()));
			map.put("empDepartmentId", String.valueOf(emp.getEmpDepartmentId()));
			map.put("empPhoto", String.valueOf(emp.getEmpPhoto()));
			map.put("empPin", String.valueOf(emp.getEmpPin()));
			map.put("empPrbranchId", String.valueOf(emp.getEmpPrbranchId()));
			map.put("empPriorityactivityLevel1", emp.getEmpPriorityactivityLevel1());
			map.put("empPriorityactivityLevel2", emp.getEmpPriorityactivityLevel2());
			map.put("empPriorityactivityLevel3", emp.getEmpPriorityactivityLevel3());
			map.put("empPriorityactivityLevel4", emp.getEmpPriorityactivityLevel4());
			map.put("empPriorityactivityLevel5", emp.getEmpPriorityactivityLevel5());
			map.put("empPrioritybalanceLevel1", emp.getEmpPrioritybalanceLevel1());
			map.put("empPrioritybalanceLevel2", emp.getEmpPrioritybalanceLevel2());
			map.put("empPrioritybalanceLevel3", emp.getEmpPrioritybalanceLevel3());
			map.put("empPrioritybalanceLevel4", emp.getEmpPrioritybalanceLevel4());
			map.put("empPrioritybalanceLevel5", emp.getEmpPrioritybalanceLevel5());
			map.put("empPriorityjcLevel1", emp.getEmpPriorityjcLevel1());
			map.put("empPriorityjcLevel2", emp.getEmpPriorityjcLevel2());
			map.put("empPriorityjcLevel3", emp.getEmpPriorityjcLevel3());
			map.put("empPriorityjcLevel4", emp.getEmpPriorityjcLevel4());
			map.put("empPriorityjcLevel5", emp.getEmpPriorityjcLevel5());
			map.put("empPriorityopprLevel1", emp.getEmpPriorityopprLevel1());
			map.put("empPriorityopprLevel2", emp.getEmpPriorityopprLevel2());
			map.put("empPriorityopprLevel3", emp.getEmpPriorityopprLevel3());
			map.put("empPriorityopprLevel4", emp.getEmpPriorityopprLevel4());
			map.put("empPriorityopprLevel5", emp.getEmpPriorityopprLevel5());
			map.put("empPriorityopprfollowupLevel1", emp.getEmpPriorityopprfollowupLevel1());
			map.put("empPriorityopprfollowupLevel2", emp.getEmpPriorityopprfollowupLevel2());
			map.put("empPriorityopprfollowupLevel3", emp.getEmpPriorityopprfollowupLevel3());
			map.put("empPriorityopprfollowupLevel4", emp.getEmpPriorityopprfollowupLevel4());
			map.put("empPriorityopprfollowupLevel5", emp.getEmpPriorityopprfollowupLevel5());
			map.put("empPriorityprojectLevel1", emp.getEmpPriorityprojectLevel1());
			map.put("empPriorityprojectLevel2", emp.getEmpPriorityprojectLevel2());
			map.put("empPriorityprojectLevel3", emp.getEmpPriorityprojectLevel3());
			map.put("empPriorityprojectLevel4", emp.getEmpPriorityprojectLevel4());
			map.put("empPriorityprojectLevel5", emp.getEmpPriorityprojectLevel5());
			map.put("empPrioritytaskLevel1", emp.getEmpPrioritytaskLevel1());
			map.put("empPrioritytaskLevel2", emp.getEmpPrioritytaskLevel2());
			map.put("empPrioritytaskLevel3", emp.getEmpPrioritytaskLevel3());
			map.put("empPrioritytaskLevel4", emp.getEmpPrioritytaskLevel4());
			map.put("empPrioritytaskLevel5", emp.getEmpPrioritytaskLevel5());
			map.put("empPriorityticketLevel1", emp.getEmpPriorityticketLevel1());
			map.put("empPriorityticketLevel2", emp.getEmpPriorityticketLevel2());
			map.put("empPriorityticketLevel3", emp.getEmpPriorityticketLevel3());
			map.put("empPriorityticketLevel4", emp.getEmpPriorityticketLevel4());
			map.put("empPriorityticketLevel5", emp.getEmpPriorityticketLevel5());

			map.put("empProdJcExe", String.valueOf(emp.getEmpProdJcExe()));
			map.put("empQualification", String.valueOf(emp.getEmpQualification()));
			map.put("empQuoteDiscountupdate", String.valueOf(emp.getEmpQuoteDiscountupdate()));
			map.put("empQuotePriceupdate", String.valueOf(emp.getEmpQuotePriceupdate()));
			map.put("empReasonOfLeaving", String.valueOf(emp.getEmpReasonOfLeaving()));
			map.put("empRecperpage", String.valueOf(emp.getEmpRecperpage()));
			map.put("empRefNo", String.valueOf(emp.getEmpRefNo()));
			map.put("empReportAccess", String.valueOf(emp.getEmpReportAccess()));
			map.put("empSalCalcFrom", strToShortDate(emp.getEmpSalCalcFrom()));
			map.put("empSales", emp.getEmpSales());
			map.put("empService", String.valueOf(emp.getEmpService()));
			map.put("empServicePsf", emp.getEmpServicePsf());
			map.put("empSex", String.valueOf(emp.getEmpSex()));
			map.put("empSoDiscountupdate", String.valueOf(emp.getEmpSoDiscountupdate()));
			map.put("empSoPriceupdate", String.valueOf(emp.getEmpSoPriceupdate()));
			map.put("empBranchId", String.valueOf(emp.getEmpBranchId()));
			map.put("empJobtitleId", String.valueOf(emp.getEmpJobtitleId()));
			map.put("empStructureId", String.valueOf(emp.getEmpStructureId()));
			map.put("empTechnician", emp.getEmpTechnician());
			map.put("empThemeId", String.valueOf(emp.getEmpThemeId()));
			map.put("empTicketClose", emp.getEmpTicketClose());
			map.put("empTicketOwner", emp.getEmpTicketOwner());
			map.put("empTimeout", String.valueOf(emp.getEmpTimeout()));
			map.put("empUname", String.valueOf(emp.getEmpUname()));
			map.put("empUpass", String.valueOf(emp.getEmpUpass()));
			map.put("empUuid", String.valueOf(emp.getEmpUuid()));
			map.put("empNotes", String.valueOf(emp.getEmpNotes()));
			if ((strToShortDate(emp.getEmpDob()).contains("01/01/1971"))) {

				map.put("dropDay", "");
				map.put("dropMonth", "");
				map.put("dropYear", "");

			} else {
				map.put("dropDay", splitDate(emp.getEmpDob()));
				map.put("dropMonth", splitMonth(emp.getEmpDob()));
				map.put("dropYear", splitYear(emp.getEmpDob()));
			}

			if (emp.getEmpEntryId() != 0) {
				map.put("empEntryDate", strToShortDate(emp.getEmpEntryDate()));
				map.put("empEntryId", String.valueOf(emp.getEmpEntryId()));
				map.put("empEntryBy", axelaEmpRepository.findEmpName(emp.getEmpEntryId()));
			}
			if (emp.getEmpModifiedId() != 0) {
				map.put("empModifiedDate", strToShortDate(emp.getEmpModifiedDate()));
				map.put("empModifiedId", String.valueOf(emp.getEmpModifiedId()));
				map.put("empModifiedBy", axelaEmpRepository.findEmpName(emp.getEmpModifiedId()));
			}

			// branch ids
			if (emp.getEmpAllBranches().equals("0")) {
				List empBranch = empBranchrepository.findByEmpBranchId(Integer.parseInt(empId));
				System.out.println("empBranch======" + empBranch);
				StringBuilder dataString = new StringBuilder();
				if (!empBranch.isEmpty()) {
					dataString = dataString.append(empBranch.get(0));
					for (int i = 1; i <= empBranch.size() - 1; ++i) {
						String branchNAme = PadQuotes(empBranch.get(i) + "");
						dataString = dataString.append(",").append(branchNAme);
					}
				}
				map.put("empAllBranch", dataString.toString());
			}

			// exe ids
			if (emp.getEmpAllExe().equals("0")) {
				List empexe = empExeRepository.findByEmpexeId(Integer.parseInt(empId));
				StringBuilder dataString = new StringBuilder();
				if (!empexe.isEmpty()) {
					dataString = dataString.append(empexe.get(0));
					for (int i = 1; i <= empexe.size() - 1; ++i) {
						String exename = PadQuotes(empexe.get(i) + "");
						dataString = dataString.append(",").append(exename);
					}
				}
				map.put("empAllExecutive", dataString.toString());
			}

			List empAccess = empAccessRepository.findByEmpaccessEmpId(Integer.parseInt(empId));
			StringBuilder dataString = new StringBuilder();
			if (!empAccess.isEmpty()) {
				dataString = dataString.append(empAccess.get(0));
				for (int i = 1; i <= empAccess.size() - 1; ++i) {
					String empaccess = PadQuotes(empAccess.get(i) + "");
					dataString = dataString.append(",").append(empaccess);
				}
			}
			map.put("empaccess", dataString.toString());

		}
		list.add(map);
		output.put("populateData", list);
		if (AppRun().equals("0")) {
			SOP("output==========executiveService==========" + output.toString());
		}
		return output;
	}
	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		empId = CNumeric(PadQuotes(getSession("empId", session)));
		if (!empId.equals("0")) {
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			List<AxelaEmp> executivesList = null;
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			PageRequest request = null;
			String strOrderBy = "";

			if (!inputObj.isNull("sortField")) {
				sortField = PadQuotes((inputObj.getString("sortField")));
			}
			if (!inputObj.isNull("pageIndex")) {
				pageIndex = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
			}
			if (!inputObj.isNull("sortDirection")) {
				sortDirection = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
			}
			perPage = CNumeric(getSession("empRecperpage", session));
			if (perPage.equals("0")) {
				perPage = "25";
			}
			if (sortDirection.equals("")) {
				sortDirection = "DESC";
			}
			if (sortField.equals("")) {
				sortField = "empId";
			}
			pageIndex++;
			System.out.println("1111111111111111111111");
			if (!inputObj.isNull("requestType")) {
				requestType = PadQuotes((inputObj.getString("requestType")));
			}
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			// strOrderBy = " ORDER BY customer." + sortField + " " + sortDirection;
			strSearch += branchAccess + exeAccess;
			strOrderBy = " ORDER BY emp." + sortField + " " + sortDirection;
			executivesList = executivesFilterImpl.findAllExecutives(strSearch, strOrderBy, pageIndex, Integer.parseInt(perPage));
			length = executivesFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;

			// Start Header Data
			listHeader.add(produceHeaderData("ID", "empId", "center"));
			listHeader.add(produceHeaderData("Executive Details", "empName", "center"));
			listHeader.add(produceHeaderData("Contact", "empMobile1", "center"));
			listHeader.add(produceHeaderData("Address", "empAddress", "center"));
			listHeader.add(produceHeaderData("Branch", "axelaBranch.branchName", "center"));

			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaEmp obj : executivesList) {

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
				value.add(PadQuotes(String.valueOf(obj.getEmpId())));
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// executive detail
				type.add(false);
				value.add(ExePhotoOval(obj.getEmpId() + ""));
				paramArr.add((ArrayList) paramSubArr.clone());
				type.add(false);
				value.add(PadQuotes(String.valueOf(obj.getEmpName())));
				paramArr.add((ArrayList) paramSubArr.clone());
				type.add(false);
				value.add(PadQuotes(String.valueOf("Ref. No.: " + obj.getEmpRefNo())));
				paramArr.add((ArrayList) paramSubArr.clone());
				type.add(false);
				value.add(PadQuotes(String.valueOf("Role: " + obj.getRoleName())));
				paramArr.add((ArrayList) paramSubArr.clone());
				type.add(false);
				value.add(PadQuotes(String.valueOf("Job Title: " + obj.getJobtitleDesc())));
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();

				// contact
				if (!obj.getEmpMobile1().equals("")) {
					type.add(false);
					value.add(obj.getEmpMobile1());
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getEmpMobile2().equals("")) {
					type.add(false);
					value.add(obj.getEmpMobile2());
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getEmpPhone1().equals("")) {
					type.add(false);
					value.add(obj.getEmpPhone1());
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getEmpPhone2().equals("")) {
					type.add(false);
					value.add(obj.getEmpPhone2());
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getEmpEmail1().equals("")) {
					type.add(false);
					value.add("<a href=\"mailto:" + obj.getEmpEmail1() + ">" + obj.getEmpEmail1() + "</a> ");
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				if (!obj.getEmpEmail2().equals("")) {
					type.add(false);
					value.add("<a href=\"mailto:" + obj.getEmpEmail2() + ">" + obj.getEmpEmail2() + "</a> ");
					paramArr.add((ArrayList) paramSubArr.clone());
				}

				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();

				// address
				type.add(false);
				value.add(PadQuotes(obj.getEmpAddress() + ","));
				paramArr.add((ArrayList) paramSubArr.clone());
				type.add(false);
				value.add(PadQuotes(obj.getCityName() + " - " + obj.getEmpPin() + ","));
				paramArr.add((ArrayList) paramSubArr.clone());
				type.add(false);
				value.add(PadQuotes(obj.getStateName() + ", " + obj.getCountryName() + "."));
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();

				// branch
				type.add(true);
				value.add(PadQuotes(obj.getBranchName() + " (" + obj.getBranchCode() + ")"));
				paramSubArr.add("branchSummary");
				paramSubArr.add(obj.getBranchId() + "");
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
				actionParam.add("updateExecutive");
				actionParam1.add("accessRights");
				actionParam2.add("listDocuments");
				actionParam3.add("updatePhoto");
				actionParam4.add("updateEmailSettings");
				actionParam.add(CNumeric(PadQuotes(String.valueOf(obj.getEmpId()))));
				actionParam1.add(CNumeric(PadQuotes(String.valueOf(obj.getEmpId()))));
				actionParam2.add(CNumeric(PadQuotes(String.valueOf(obj.getEmpId()))));
				actionParam3.add(CNumeric(PadQuotes(String.valueOf(obj.getEmpId()))));
				actionParam4.add(CNumeric(PadQuotes(String.valueOf(obj.getEmpId()))));
				mapAction.put("td", produceActionData(actionParam, actionParam1, actionParam2, actionParam3, actionParam4));
				listAction.add(mapAction);
				listBody.add(mapData);

			}

			output.put("meta", mapNavi);
			output.put("action", listAction);
			output.put("tbody", listBody);
			output.put("tdalign", listBodyAlign);
			output.put("thead", listHeader);
			output.put("tbody", listBody);

			if (AppRun().equals("0")) {
				SOP("output==========CampaignService==========" + output.toString());
			}
		}
		return output;
	}

	private ArrayList<HashMap> produceActionData(ArrayList<String> actionParam1, ArrayList<String> actionParam2, ArrayList<String> actionParam3, ArrayList<String> actionParam4,
			ArrayList<String> actionParam5) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Executive Update");
		mapBodyData.put("param", actionParam1);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Access Rights");
		mapBodyData.put("param", actionParam2);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "List Documents");
		mapBodyData.put("param", actionParam3);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Update Photo");
		mapBodyData.put("param", actionParam4);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Email Settings");
		mapBodyData.put("param", actionParam5);
		listAction.add((HashMap) mapBodyData.clone());
		SOP("mapBodyData================================" + mapBodyData);
		return listAction;
	}
	public Map populateConfigDetails(HttpSession session) {
		output = new HashMap();
		// List<Integer> obj = null;
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (int obj1 : axelaCompRepository.findCompanyTypeId()) {
			HashMap map = new HashMap();
			map.put("compBusinesstypeId", obj1);
			list.add(map);
		}
		output.put("populateConfigDetails", list);
		return output;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		//
		output = new LinkedHashMap();

		list.add(buildSmartArr("Keyword", "text", "emp.*"));
		list.add(buildSmartArr("ID", "numeric", "emp.empId"));
		list.add(buildSmartArr("Name", "text", "emp.empName"));
		list.add(buildSmartArr("User Name", "text", "emp.empUname"));
		list.add(buildSmartArr("Role ID", "numeric", "emp.empRoleId"));
		list.add(buildSmartArr("Department ID", "numeric", "emp.empDepartmentId"));
		list.add(buildSmartArr("User Password", "text", "emp.empUpass"));
		list.add(buildSmartArr("Reference No.", "text", "emp.empRefNo"));
		list.add(buildSmartArr("Job Title", "text", "axelaJobtitle.jobtitleDesc"));
		list.add(buildSmartArr("Gender", "boolean", "emp.empGender"));
		list.add(buildSmartArr("DOB", "date", "emp.empDob"));
		list.add(buildSmartArr("Marital Status", "boolean", "emp.empMarried"));
		list.add(buildSmartArr("Qualification", "text", "emp.empQualification"));
		list.add(buildSmartArr("Certification", "text", "emp.empCertification"));
		list.add(buildSmartArr("Phone1", "text", "emp.empPhone1"));
		list.add(buildSmartArr("Phone2", "text", "emp.empPhone2"));
		list.add(buildSmartArr("Mobile1", "text", "emp.empMobile1"));
		list.add(buildSmartArr("Mobile2", "text", "emp.empMobile2"));
		list.add(buildSmartArr("Email1", "text", "emp.empEmail1"));
		list.add(buildSmartArr("Email2", "text", "emp.empEmail2"));
		// list.add(buildSmartArr("Full Address", "text", "CONCAT(empSddress, ', ', empCityId, ' - ', empPin)"));
		list.add(buildSmartArr("City", "text", "emp.empCityId"));
		list.add(buildSmartArr("Pin/Zip", "numeric", "emp.empPin"));
		// list.add(buildSmartArr("State", "text", "empState"));
		// list.add(buildSmartArr("Country", "text", "empCountry"));
		list.add(buildSmartArr("Landmark", "text", "emp.empLandmark"));
		list.add(buildSmartArr("Active", "boolean", "emp.empActive"));
		list.add(buildSmartArr("Branch ID", "numeric", "emp.empBranchId"));
		list.add(buildSmartArr("Executive", "boolean", "emp.empAllExe"));
		list.add(buildSmartArr("Sales", "boolean", "emp.empSales"));
		list.add(buildSmartArr("Bill Price Update", "boolean", "emp.empBillPriceupdate"));
		list.add(buildSmartArr("Bill Discount Update", "boolean", "emp.empBillDiscountupdate"));
		list.add(buildSmartArr("Quote Price Update", "boolean", "emp.empQuotePriceupdate"));
		list.add(buildSmartArr("Quote Discount Update", "boolean", "emp.empQuoteDiscountupdate"));
		list.add(buildSmartArr("SO Price Update", "boolean", "emp.empSoPriceupdate"));
		list.add(buildSmartArr("SO Discount Update", "boolean", "emp.empSoDiscountupdate"));
		list.add(buildSmartArr("Invoice Price Update", "boolean", "emp.empInvoicePriceupdate"));
		list.add(buildSmartArr("Invoice Discount Update", "boolean", "emp.empInvoiceDiscountupdate"));
		list.add(buildSmartArr("Service", "boolean", "emp.empService"));
		// list.add(buildSmartArr("SC Price Update", "boolean", "empScPriceupdate"));
		// list.add(buildSmartArr("SC Discount Update", "boolean", "empScDiscountupdate"));
		list.add(buildSmartArr("Ticket Owner", "boolean", "emp.empTicketOwner"));
		list.add(buildSmartArr("Ticket Close", "boolean", "emp.empTicketClose"));
		list.add(buildSmartArr("MIS", "boolean", "emp.empMisAccess"));
		list.add(buildSmartArr("Reports Access", "boolean", "emp.empReportAccess"));
		list.add(buildSmartArr("Export Reports", "boolean", "emp.empExportAccess"));
		list.add(buildSmartArr("Copy Access", "boolean", "emp.empCopyAccess"));
		// list.add(buildSmartArr("Driver", "boolean", "empDriver"));
		// list.add(buildSmartArr("Presser", "boolean", "empPresser"));
		// list.add(buildSmartArr("Presser Rate", "numeric", "empPresserRate"));
		list.add(buildSmartArr("Priority Activity Level1", "boolean", "emp.empPriorityactivityLevel1"));
		list.add(buildSmartArr("Priority Activity Level2", "boolean", "emp.empPriorityactivityLevel2"));
		list.add(buildSmartArr("Priority Activity Level3", "boolean", "emp.empPriorityactivityLevel3"));
		list.add(buildSmartArr("Priority Activity Level4", "boolean", "emp.empPriorityactivityLevel4"));
		list.add(buildSmartArr("Priority Activity Level5", "boolean", "emp.empPriorityactivityLevel5"));
		list.add(buildSmartArr("Priority Project Level1", "boolean", "emp.empPriorityprojectLevel1"));
		list.add(buildSmartArr("Priority Project Level2", "boolean", "emp.empPriorityprojectLevel2"));
		list.add(buildSmartArr("Priority Project Level3", "boolean", "emp.empPriorityprojectLevel3"));
		list.add(buildSmartArr("Priority Project Level4", "boolean", "emp.empPriorityprojectLevel4"));
		list.add(buildSmartArr("Priority Project Level5", "boolean", "emp.empPriorityprojectLevel5"));
		list.add(buildSmartArr("Priority Task Level1", "boolean", "emp.empPrioritytaskLevel1"));
		list.add(buildSmartArr("Priority Task Level2", "boolean", "emp.empPrioritytaskLevel2"));
		list.add(buildSmartArr("Priority Task Level3", "boolean", "emp.empPrioritytaskLevel3"));
		list.add(buildSmartArr("Priority Task Level4", "boolean", "emp.empPrioritytaskLevel4"));
		list.add(buildSmartArr("Priority Task Level5", "boolean", "emp.empPrioritytaskLevel5"));
		list.add(buildSmartArr("Priority Opprfollowup Level1", "boolean", "emp.empPriorityopprfollowupLevel1"));
		list.add(buildSmartArr("Priority Opprfollowup Level2", "boolean", "emp.empPriorityopprfollowupLevel2"));
		list.add(buildSmartArr("Priority Opprfollowup Level3", "boolean", "emp.empPriorityopprfollowupLevel3"));
		list.add(buildSmartArr("Priority Opprfollowup Level4", "boolean", "emp.empPriorityopprfollowupLevel4"));
		list.add(buildSmartArr("Priority Opprfollowup Level5", "boolean", "emp.empPriorityopprfollowupLevel5"));
		list.add(buildSmartArr("Priorityoppr Level1", "boolean", "emp.empPriorityopprLevel1"));
		list.add(buildSmartArr("Priorityoppr Level2", "boolean", "emp.empPriorityopprLevel2"));
		list.add(buildSmartArr("Priorityoppr Level3", "boolean", "emp.empPriorityopprLevel3"));
		list.add(buildSmartArr("Priorityoppr Level4", "boolean", "emp.empPriorityopprLevel4"));
		list.add(buildSmartArr("Priorityoppr Level5", "boolean", "emp.empPriorityopprLevel5"));
		list.add(buildSmartArr("Priority Balance Level1", "boolean", "emp.empPrioritybalanceLevel1"));
		list.add(buildSmartArr("Priority Balance Level2", "boolean", "emp.empPrioritybalanceLevel2"));
		list.add(buildSmartArr("Priority Balance Level3", "boolean", "emp.empPrioritybalanceLevel3"));
		list.add(buildSmartArr("Priority Balance Level4", "boolean", "emp.empPrioritybalanceLevel4"));
		list.add(buildSmartArr("Priority Balance Level5", "boolean", "emp.empPrioritybalanceLevel5"));
		list.add(buildSmartArr("Priority Ticket Level1", "boolean", "emp.empPriorityticketLevel1"));
		list.add(buildSmartArr("Priority Ticket Level2", "boolean", "emp.empPriorityticketLevel2"));
		list.add(buildSmartArr("Priority Ticket Level3", "boolean", "emp.empPriorityticketLevel3"));
		list.add(buildSmartArr("Priority Ticket Level4", "boolean", "emp.empPriorityticketLevel4"));
		list.add(buildSmartArr("Priority Ticket Level5", "boolean", "emp.empPriorityticketLevel5"));
		list.add(buildSmartArr("IP Access", "numeric", "emp.empIpAccess"));
		list.add(buildSmartArr("Prbranch ID", "numeric", "emp.empPrbranchId"));
		list.add(buildSmartArr("Structure ID", "numeric", "emp.empStructureId"));
		list.add(buildSmartArr("Sal Calc From", "boolean", "emp.empSalCalcFrom"));
		list.add(buildSmartArr("Esi No", "boolean", "emp.empEsiNo"));
		list.add(buildSmartArr("Dispensary ID", "numeric", "emp.empDispensaryId"));
		list.add(buildSmartArr("PF NO", "numeric", "emp.empPfNo"));
		list.add(buildSmartArr("Pf No Dept File", "numeric", "emp.empPfNoDeptFile"));
		list.add(buildSmartArr("Date of Join", "date", "emp.empDateOfJoin"));
		list.add(buildSmartArr("Date of Relieve", "date", "emp.empDateOfRelieve"));
		list.add(buildSmartArr("Reason of Leaving", "text", "emp.empReasonOfLeaving"));
		list.add(buildSmartArr("Notes", "text", "emp.empNotes"));
		// list.add(buildSmartArr("Entry By", "text", "emp_entry_id IN (SELECT empId FROM compdb.axelaEmp WHERE empName"));
		list.add(buildSmartArr("Entry Date", "date", "emp.empEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "empModifiedId IN (SELECT empId FROM compdb.axelaEmp WHERE empName"));
		list.add(buildSmartArr("Modified Date", "date", "emp.empModifiedDate"));

		output.put("drSmart", list.toArray());
		return output;
	}

	public Map<String, List> populateDepartment() {
		Map output = new HashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (Object[] obj : empDepartmentRepository.findAllDepartment()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", obj[0].toString());
			map.put("name", obj[1].toString());
			list.add(map);
		}
		output.put("populateDepartment", list);
		return output;
	}

	public Map<String, List> populateExecutive(String input) throws JSONException {

		Map output = new HashMap();
		String requestType = "";
		inputObj = new JSONObject(input);
		List<Object[]> exe = null;
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		String allexe = "";
		if (!inputObj.isNull("allexe")) {
			allexe = PadQuotes(inputObj.getString("allexe"));
		}
		if (!allexe.equals("")) {
			exe = portalFilterImpl.findAllEmpByIdAndName(allexe);
		} else {
			exe = axelaEmpRepository.findExe(Integer.parseInt(empSessionId));
		}
		for (Object[] obj : exe) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", "" + obj[0]);
			map.put("name", obj[1] + " (" + obj[1] + ")");
			list.add(map);
		}
		output.put("populateExecutive", list);
		return output;
	}

	public Map<String, List> populateBranches(String input) throws JSONException {
		Map output = new HashMap();
		String flag = "0";
		String requestType = "";
		inputObj = new JSONObject(input);
		List<Object[]> branch = null;
		ArrayList list = new ArrayList();
		String allBranche = "";
		if (!inputObj.isNull("allBranche")) {
			allBranche = PadQuotes(inputObj.getString("allBranche"));
		}
		if (!allBranche.equals("")) {
			branch = portalFilterImpl.findByIdAndName(allBranche);
		} else {
			branch = branchRepository.findAllBranches();
			flag = "1";
		}
		if (flag.equals("1")) {
			ArrayList list1 = new ArrayList();
			HashMap<String, String> branch1 = new HashMap<String, String>();
			branch1.put("key", "0");
			branch1.put("name", "Head Office");
			list.add(branch1);
		}
		for (Object[] obj : branch) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", "" + obj[0]);
			map.put("name", obj[1] + " (" + obj[1] + ")");
			list.add(map);
		}
		output.put("populateBranch", list);
		return output;
	}

	public String dobAddUtil(String dropDay, String dropMonth, String dropYear) {
		String dob = "";
		if (!dropMonth.equals("") && dropMonth != null) {
			dob += dropDay + "/";
		} else {
			dob += "01/";
		}
		if (!dropDay.equals("") && dropDay != null) {
			dob += dropMonth + "/";
		} else {
			dob += "01/";
		}
		if (!dropYear.equals("") && dropYear != null) {
			dob += dropYear;
		} else {
			dob += "1971";
		}

		return dob;
	}

	public Map populateLandingDetails(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		JSONArray typeIds = null;
		JSONArray branchIds = null;
		String strSearch = "";
		String typeId = "";
		String branchId = "";
		String empId = "0";
		Map map = null;
		Map count = null;
		List al = null;
		Set convrtr = null;
		Map output = null;
		int grandTotal = 0;
		int grandActive = 0;
		int grandInactive = 0;
		inputObj = new JSONObject(input);
		empId = CNumeric(PadQuotes(getSession("empId", session)));
		if (!inputObj.isNull("typeIds")) {
			if (inputObj.get("typeIds") instanceof JSONArray)
				typeIds = inputObj.getJSONArray("typeIds");
			for (int i = 0; i < typeIds.length(); i++) {
				typeId += typeIds.getString(i) + ",";
			}
			if (typeId.length() > 0) {
				typeId = typeId.substring(0, typeId.length());
			}
		}

		if (!inputObj.isNull("branchIds")) {
			if (inputObj.get("branchIds") instanceof JSONArray)
				branchIds = inputObj.getJSONArray("typeIds");
			for (int i = 0; i < typeIds.length(); i++) {
				branchId += typeIds.getString(i) + ",";
			}
			if (branchId.length() > 0) {
				branchId = typeId.substring(0, branchId.length());
			}
		}

		if (!branchId.equals("")) {
			strSearch = " AND branch.branchId in (" + branchId + ") ";;
		}
		if (!typeId.equals("")) {
			strSearch += " AND branch.branchBranchtypeId in (" + typeId + ") ";
		}
		al = new ArrayList();
		output = new HashMap();
		map = new HashMap();
		count = new HashMap();

		// status start
		// ================================================
		List<Object[]> status1 = portalFilterImpl.findAllExecutiveStatus1("");
		if (status1 != null) {
			for (Object[] objects : status1) {
				grandTotal = Integer.parseInt(objects[0] + "");
				grandActive = Integer.parseInt(objects[1] + "");
				grandInactive = Integer.parseInt(objects[2] + "");
			}
		}
		List<Object[]> status2 = portalFilterImpl.findAllExecutiveStatus2("");
		if (status2 != null) {
			for (Object[] objects : status2) {
				grandTotal += Integer.parseInt(objects[0] + "");
				grandActive += Integer.parseInt(objects[1] + "");
				grandInactive += Integer.parseInt(objects[2] + "");
			}
		}

		count.put("grandTotal", grandTotal + "");
		count.put("grandActive", grandActive + "");
		count.put("grandInactive", grandInactive + "");
		map.put("status", count);

		// ================================================
		// status end

		// summary start
		// ==================================================
		al = new ArrayList();
		List<Object[]> summary1 = portalFilterImpl.findAllExecutiveSummary1();
		if (summary1 != null) {
			for (Object[] objects : summary1) {
				List data = new ArrayList();
				data.add(objects[0]);
				data.add(objects[1]);
				data.add(objects[2]);
				data.add(objects[3]);
				al.add(data);
			}
		}

		List<Object[]> summary2 = portalFilterImpl.findAllExecutiveSummary2("");
		if (summary2 != null) {
			for (Object[] objects : summary2) {
				List data = new ArrayList();
				data.add(objects[0]);
				data.add(objects[1]);
				data.add(objects[2]);
				data.add(objects[3]);
				al.add(data);
			}
		}
		List<Object[]> summary3 = portalFilterImpl.findAllExecutiveSummary3("");
		if (summary3 != null) {
			for (Object[] objects : summary3) {
				List data = new ArrayList();
				data.add(objects[0]);
				data.add(objects[1]);
				data.add(objects[2]);
				data.add(objects[3]);
				al.add(data);
			}
		}
		convrtr = new HashSet(al);
		map.put("summary", convrtr);
		// =================================
		// summary end
		output.put("landingDetails", map);
		return output;
	}

	public Map executiveSummary(String input) throws ParseException, JSONException {
		inputObj = new JSONObject(input);
		String empId = "0";
		if (!inputObj.isNull("empId")) {
			empId = inputObj.getString("empId");
		}
		Map map = new HashMap();
		List rec = new ArrayList();
		Map data = null;
		String address = "";
		Map output = new HashMap();
		AxelaEmp axelaEmp = portalFilterImpl.findExecutiveSummary(empId);
		if (axelaEmp != null) {
			map.put("exeImgUrl", ExePhotoOval(axelaEmp.getEmpId() + ""));
			map.put("empNAme", axelaEmp.getEmpName());
			map.put("empRefNo", axelaEmp.getEmpRefNo());
			map.put("jobtitleDesc", axelaEmp.getJobtitleDesc());
			if (axelaEmp.getEmpSex().equals("1"))
			{
				map.put("empSex", "Female");
			} else {
				map.put("empSex", "Male");
			}
			map.put("empDob", strToShortDate(axelaEmp.getEmpDob()));
			if (axelaEmp.getEmpMarried().equals("1"))
			{
				map.put("empMarried", "Unmarried");
			} else {
				map.put("empMarried", "Married");
			}
			map.put("empMobile1", axelaEmp.getEmpMobile1());
			map.put("empEmail1", axelaEmp.getEmpEmail1());
			if (!axelaEmp.getEmpAddress().equals("")) {

			}
			if (!axelaEmp.getEmpAddress().equals("")) {
				address += axelaEmp.getEmpAddress() + ",";
			}
			if (!axelaEmp.getCityName().equals("")) {
				address += axelaEmp.getCityName();
			}
			if (!axelaEmp.getEmpPin().equals("")) {
				address += "-" + axelaEmp.getEmpPin() + ",";
			}
			if (!axelaEmp.getStateName().equals("")) {
				address += axelaEmp.getStateName() + ",";
			}
			if (!axelaEmp.getCountryName().equals("")) {
				address += axelaEmp.getCountryName() + ".";
			}
			map.put("address", address);
			map.put("empStatus", axelaEmp.getEmpStatus());
			List<Object[]> obj = portalFilterImpl.executiveSummaryReportingExes(empId);
			if (obj.size() != 0) {
				for (Object[] objects : obj) {
					data = new HashMap();
					data.put("name", objects[0]);
					data.put("id", objects[1]);
					rec.add(data);
				}
				map.put("exeForReporting", rec);

			} else {
				map.put("forReporting", "---");
			}

		}
		output.put("populateExecutiveSummary", map);
		return output;
	}
}
