package axela.app.helpdesk.service;

import java.sql.SQLException;
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
import org.springframework.stereotype.Component;

import axela.config.Connect;
import axela.customer.repository.CustomerFilterImpl;
import axela.helpdesk.model.AxelaHelpDeskTicket;
import axela.helpdesk.repository.AxelaTicketQueueRepository;
import axela.helpdesk.repository.HelpDeskTicketRepository;
import axela.helpdesk.repository.HelpDeskTicketTransRepo;
import axela.helpdesk.repository.HelpDeskTickethistoryRepository;
import axela.helpdesk.repository.ServiceTicketHoliImpl;
import axela.helpdesk.repository.TicketRepository;
import axela.helpdesk.repository.TicketRepositoryImpl;
import axela.helpdesk.repository.TicketTransFilterImpl;
import axela.helpdesk.service.TicketDashService;
import axela.helpdesk.service.TicketService;
import axela.portal.repository.EmpRepository;
import axela.service.model.AxelaServiceJc;
import axela.service.repository.ServiceContractAssetRepository;
import axela.service.repository.ServiceContractRepository;
@Component
public class AppTicketService extends Connect {
	public String strSearch = "";
	@Autowired
	public TicketRepository ticketRepository;

	@Autowired
	private AxelaTicketQueueRepository axelaTicketQueueRepository;

	@Autowired
	private TicketRepositoryImpl ticketRepositoryImpl;

	@Autowired
	private ServiceContractAssetRepository serviceContractAssetRepository;

	@Autowired
	private CustomerFilterImpl customerFilterImpl;

	@Autowired
	private ServiceContractRepository serviceContractRepository;

	@Autowired
	private HelpDeskTickethistoryRepository serviceTickethistoryRepository;

	@Autowired
	private HelpDeskTicketRepository serviceTicketRepository;

	@Autowired
	public EmpRepository axelaEmpRepository;

	@Autowired
	private ServiceTicketHoliImpl serviceTicketHoliImpl;

	@Autowired
	public TicketTransFilterImpl ticketTransFilterImpl;

	@Autowired
	public HelpDeskTicketTransRepo helpdeskTicketTransRepo;

	private final static int PAGESIZE = 25;
	public String pages = "1", sort = "DESC", field = "jcId", total = "100";
	HashMap output = null;
	public String exeAccess = "", contractTitle = "", assetName = "";
	public int empId = 0;
	public String requestType = "", ticketEmpId = "0", ticketParentId = "0", ticketContactId = "0", ticketCustomerId = "0", ticketJcId = "0", contractId = "0", ticketAssetId = "0",
			ticketTicketqueueId = "0", ticketqueueIds = "0";
	public String branchAccess = "";
	public String msg = "";
	public String StrSql = "";
	public String configServiceTicketRefno = "";
	public int ticketId = 0;
	public String ticketOpprId = "0";
	public String ticketSoId = "0";
	public String ticketCrmId = "0";
	public String ticketJcSerialno = "0";
	public String ticketJcpsfId = "0";
	public String ticketContractId = "0";
	public String ticketPmId = "0";
	public String ticketTicketsourceId = "0";
	public Date ticketReportTime;
	public String ticketTicketstatusId = "0";
	public String ticketTicketcatId = "0";
	public String ticketTickettypeId = "0";
	public String ticketPriorityticketId = "0";
	public String ticketSubject = "0";
	public String ticketClosedTime = "";
	public String ticketClosedComments = "";
	public String ticketDesc = "";
	public Date ticketDueTime = null;
	public String ticketTrigger2Hrs = "0";
	public String ticketTrigger3Hrs = "0";
	public String ticketNotes = "0";
	public String ticketTrigger = "0";
	public String ticketRefno = "0";
	public String ticketRead = "0";
	public int ticketEntryId = 0;
	public String ticketEntryDate = "0";
	public String ticketTrigger1Hrs = "0";
	public String empEmail1 = "";
	public String empEmail2 = "";
	public String empMobile1 = "";
	public String empMobile2 = "";
	public String empEmailFormail = "";
	public String entryempEmail = "";
	public String contactName = "";
	public String contactMobile1 = "";
	public String contactMobile2 = "";
	public String contactEmail1 = "";
	public String contactEmail2 = "";
	public String compEmailEnable = "";
	public String compSmsEnable = "";
	public String configServiceContract = "";
	public String configServiceTicketCat = "";
	public String configServiceTicketType = "";
	public String configAdminEmail = "";
	public String configEmailEnable = "";
	public String configSmsEnable = "";
	public String configTicketNewEmailEnable = "";
	public String configTicketNewEmailFormat = "";
	public String configTicketNewEmailSub = "";
	public String configTicketNewEmailExeSub = "";
	public String configTicketNewEmailExeFormat = "";
	public String configTicketNewSmsEnable = "";
	public String configTicketNewSmsFormat = "";
	public String configTicketNewSmsExeFormat = "";
	public String sendContactEmail = "";
	public String ticketqueueTrigger1Hrs = "";
	public String ticketqueueTrigger2Hrs = "";
	public String ticketqueueTrigger3Hrs = "";
	public String ticketqueueTrigger4Hrs = "";
	public String ticketqueueTrigger5Hrs = "";
	public int compId = 0;
	public String customerBranchId = "";
	public String ticketTrigger4Hrs = "0";
	public String ticketTrigger5Hrs = "0";
	public int pageIndex = 0;
	public String starttime = "";
	public String endtime = "";
	public String sortField = "";
	public int pageSize = 0;
	public String sortDirection = "";
	public int length = 0;
	public String compModulePm = "";
	public long closetime = 0;
	public String empFormatdate = "";
	public String empFormattime = "";
	public String elapsedclosetime = "";
	public String customerName = "";
	public String configTicketFollowupSmsFormat = "";
	public String empName = "";
	public String ticketContactEntryDate = "";
	public String ticketLoggerEmail = "";
	public String ticketLoggerJobtitle = "";
	public String ticketLoggerMobile = "";
	public String ticketLoggerName = "";
	public String ticketLoggerPhone = "";
	public int ticketLoggerTitleId = 0;
	public String ticketModifiedDate = "";
	public int ticketModifiedId = 0;
	public String ticketReopenedComments = "";
	public int ticketReopenedEmpId = 0;
	public String ticketReopenedTime = "";
	public String txtSearch = "";
	public String configCustomerName = "";
	public String orderType = "";
	public String perPage = "0";
	public String orderByField = "";
	public int page = 0;
	public String group = "";
	public String drBranchId = "0";
	JSONObject inputObj = null;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
	public Date timeZone = null;

	ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
	public Map<String, String> ticketAdd(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, SQLException, ParseException {
		if (AppRun().equals("0")) {
			SOP("input==WS_Ticket_Add===" + input);
		}

		inputObj = new JSONObject(input);
		output = new LinkedHashMap();
		exeAccess = GetSession("ExeAccess", request);
		branchAccess = GetSession("BranchAccess", request);
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		// PopulateConfigDetails(Integer.parseInt(ticketEmpId), empId);
		switch (requestType) {
			case "add" : // add an customer.WS_Ticket_Add
				ticketEmpId = String.valueOf(empId);
				ticketReportTime = getTimeByZone(session);
				getValues(inputObj);
				timeZone = getTimeByZone(session);
				addFields(response, session);
				break;
		}
		if (AppRun().equals("0")) {
			SOP("output========WS_Ticket_Add===========" + output.toString());
		}
		return output;

	}

	public void getValues(JSONObject inputObj) throws JSONException {
		ticketCustomerId = "0";
		ticketContactId = "0";
		customerName = "";
		contactName = "";
		contactMobile1 = "";
		ticketTicketqueueId = "0";
		ticketId = 0;
		ticketEmpId = "0";
		ticketParentId = "0";
		ticketCustomerId = "0";
		ticketContactId = "0";
		ticketSubject = "";
		ticketRefno = "";
		ticketDesc = "";
		ticketTicketcatId = "0";
		ticketTickettypeId = "0";
		ticketPmId = "0";
		ticketTicketsourceId = "0";
		ticketPriorityticketId = "0";
		if (!inputObj.isNull("customerName")) {
			customerName = PadQuotes(inputObj.getString("customerName"));
		}
		if (!inputObj.isNull("customerName")) {
			customerName = PadQuotes(inputObj.getString("customerName"));
		}
		if (!inputObj.isNull("contactMobile1")) {
			contactMobile1 = PadQuotes(inputObj.getString("contactMobile1"));
		}
		if (!inputObj.isNull("ticketId")) {
			ticketId = Integer.parseInt(CNumeric(PadQuotes(inputObj.getString("ticketId"))));
		}

		if (!inputObj.isNull("ticketEmpId")) {
			ticketEmpId = CNumeric(PadQuotes(inputObj.getString("ticketEmpId")));
		}

		if (!inputObj.isNull("ticketParentId")) {
			ticketParentId = CNumeric(PadQuotes(inputObj.getString("ticketParentId")));
		}
		if (!inputObj.isNull("ticketCustomerId")) {
			ticketCustomerId = CNumeric(PadQuotes(inputObj.getString("ticketCustomerId")));
		}
		if (!inputObj.isNull("ticketContactId")) {
			ticketContactId = CNumeric(PadQuotes(inputObj.getString("ticketContactId")));
		}
		if (!inputObj.isNull("ticketSubject")) {
			ticketSubject = PadQuotes(inputObj.getString("ticketSubject"));
		}

		if (!inputObj.isNull("ticketRefno")) {
			ticketRefno = PadQuotes(inputObj.getString("ticketRefno"));
		}

		if (!inputObj.isNull("ticketDesc")) {
			ticketDesc = PadQuotes(inputObj.getString("ticketDesc"));
		}

		if (!inputObj.isNull("ticketTicketcatId")) {
			ticketTicketcatId = CNumeric(PadQuotes(inputObj.getString("ticketTicketcatId")));
		}

		if (!inputObj.isNull("ticketTickettypeId")) {
			ticketTickettypeId = CNumeric(PadQuotes(inputObj.getString("ticketTickettypeId")));
		}

		if (!inputObj.isNull("ticketPmId")) {
			ticketPmId = CNumeric(PadQuotes(inputObj.getString("ticketPmId")));
		}

		if (!inputObj.isNull("ticketTicketsourceId")) {
			ticketTicketsourceId = CNumeric(PadQuotes(inputObj.getString("ticketTicketsourceId")));
		}

		if (!inputObj.isNull("ticketPriorityticketId")) {
			ticketPriorityticketId = CNumeric(PadQuotes(inputObj.getString("ticketPriorityticketId")));
		}

		if (!inputObj.isNull("ticketTicketqueueId")) {
			ticketTicketqueueId = CNumeric(PadQuotes(inputObj.getString("ticketTicketqueueId")));
		}

		if (empId == Integer.parseInt(ticketEmpId)) {
			ticketRead = "1";
		} else {
			ticketRead = "0";
		}
		ticketTrigger = "0";
	}

	public void addFields(HttpServletResponse response, HttpSession session) throws SQLException, ParseException {
		TicketService ticket = new TicketService();
		// Start ticket details
		ticket.ticketParentId = ticketParentId;
		ticket.ticketCustomerId = ticketCustomerId;
		ticket.customerBranchId = customerBranchId;
		ticket.ticketContactId = ticketContactId;
		ticket.ticketOpprId = ticketOpprId;
		ticket.ticketSoId = ticketSoId;
		ticket.ticketCrmId = ticketCrmId;
		ticket.ticketJcSerialno = ticketJcSerialno;
		ticket.ticketJcId = ticketJcId;
		ticket.ticketJcpsfId = ticketJcpsfId;
		ticket.ticketContractId = ticketContractId;
		ticket.ticketAssetId = ticketAssetId;
		ticket.ticketPmId = ticketPmId;
		ticket.ticketTicketsourceId = ticketTicketsourceId;
		ticket.ticketReportTime = ticketReportTime;
		ticket.ticketClosedComments = ticketClosedComments;
		ticket.ticketTicketstatusId = "1";
		// ticket.timeZone = timeZone;
		ticket.ticketTicketcatId = ticketTicketcatId;
		ticket.ticketTickettypeId = ticketTickettypeId;
		ticket.ticketPriorityticketId = ticketPriorityticketId;
		ticket.ticketTicketqueueId = ticketTicketqueueId;
		ticket.ticketSubject = ticketSubject;
		ticket.ticketDesc = ticketDesc;
		ticket.ticketReopenedComments = ticketReopenedComments;
		ticket.ticketReopenedEmpId = ticketReopenedEmpId;
		ticket.ticketReopenedTime = ticketReopenedTime;
		ticket.ticketLoggerMobile = ticketLoggerMobile;
		ticket.ticketLoggerName = ticketLoggerName;
		ticket.ticketLoggerPhone = ticketLoggerPhone;
		ticket.ticketLoggerTitleId = ticketLoggerTitleId;
		ticket.ticketLoggerJobtitle = ticketLoggerJobtitle;
		ticket.ticketLoggerEmail = ticketLoggerEmail;
		ticket.ticketContactEntryDate = ticketContactEntryDate;
		ticket.ticketClosedTime = ticketClosedTime;
		ticket.ticketEmpId = ticketEmpId;
		ticket.ticketDueTime = ticketDueTime;
		ticket.ticketModifiedDate = ticketModifiedDate;
		ticket.ticketModifiedId = ticketModifiedId;
		ticket.ticketTrigger1Hrs = ticketTrigger1Hrs;
		ticket.ticketTrigger2Hrs = ticketTrigger2Hrs;
		ticket.ticketTrigger3Hrs = ticketTrigger3Hrs;
		ticket.ticketTrigger4Hrs = ticketTrigger4Hrs;
		ticket.ticketTrigger5Hrs = ticketTrigger5Hrs;
		ticket.ticketqueueTrigger1Hrs = ticketqueueTrigger1Hrs;
		ticket.ticketqueueTrigger2Hrs = ticketqueueTrigger2Hrs;
		ticket.ticketqueueTrigger3Hrs = ticketqueueTrigger3Hrs;
		ticket.ticketqueueTrigger4Hrs = ticketqueueTrigger4Hrs;
		ticket.ticketqueueTrigger5Hrs = ticketqueueTrigger5Hrs;
		ticket.ticketNotes = ticketNotes;
		ticket.ticketTrigger = ticketTrigger;
		ticket.ticketEntryId = ticketEntryId;
		ticket.ticketRefno = ticketRefno;
		ticket.ticketRead = ticketRead;
		ticket.ticketEntryId = ticketEntryId;
		ticket.ticketEntryDate = ticketEntryDate;
		ticket.requestType = requestType;
		ticket.ticketRepository = ticketRepository;
		ticket.axelaTicketQueueRepository = axelaTicketQueueRepository;
		ticket.serviceTickethistoryRepository = serviceTickethistoryRepository;
		ticket.timeZone = timeZone;
		ticket.addFields(response, session);
		ticketId = ticket.ticketId;
		msg = ticket.msg;
		if (ticketId != 0 && msg.equals("")) {
			output.put("successmsg", "Ticket Added Successfully");
			output.put("ticketId", ticketId);
		} else {
			response.setStatus(201);
			output.put("errormsg", msg);
		}
	}

	public Map<String, List> listData(String input, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws JSONException, ParseException {
		// String pageIndex = "";
		String sort = "";
		String strOrderBy = "";
		String perPage = "0";
		inputObj = new JSONObject(input);
		requestType = "";
		strSearch = "";

		output = new HashMap<String, List>();
		List<AxelaHelpDeskTicket> ticketlist = null;
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		// pageIndex = CNumeric(PadQuotes(inputObj.getString("pageIndex")));
		List<AxelaServiceJc> ticket = new ArrayList<AxelaServiceJc>();
		// PageRequest request = new PageRequest(Integer.parseInt(pageIndex) - 1, PAGESIZE, Sort.Direction.DESC, "ticketId");
		int page = 0;
		if (!inputObj.isNull("pageIndex")) {
			page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
		}
		perPage = CNumeric(getSession("emp_recperpage", session));

		perPage = CNumeric(getSession("emp_recperpage", session));
		if (sort.equals("")) {
			sort = "DESC";
		}
		if (strOrderBy.equals("")) {
			strOrderBy = "ticketId";
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

		strOrderBy = " ORDER BY ticket." + strOrderBy + " " + sort + "";
		// strSearch = branchAccess + exeAccess + " ORDER BY a." + field + " " + sort + "";
		ticketlist = ticketRepositoryImpl.findAll(strSearch, strOrderBy, page, Integer.parseInt(perPage), "yes");
		if (ticketlist != null && ticketlist.size() > 0) {
			for (AxelaHelpDeskTicket result : ticketlist) {
				map.clear();
				map.put("ticketId", CNumeric(String.valueOf(result.getTicketId())));
				map.put("contactMobile1", PadQuotes(result.getContactMobile1()));
				map.put("contactMobile2", PadQuotes(result.getContactMobile2()));
				map.put("contactEmail2", PadQuotes(result.getContactEmail2()));
				map.put("contactMobile2", PadQuotes(result.getContactMobile2()));
				map.put("contactName", PadQuotes(result.getContactName()));
				map.put("empName", PadQuotes(result.getEmpName()));
				map.put("ticketStatusName", PadQuotes(result.getTicketstatusName()));
				map.put("ticketClosedTime", PadQuotes(strToShortDate(result.getTicketClosedTime())));
				map.put("ticketReportTime", PadQuotes(strToShortDate(result.getTicketReportTime())));
				list.add((HashMap<String, String>) map.clone());

			}
			output.put("listdata", list);
			response.setStatus(201);
		}
		else
		{
			output.put("msg", "No Records Found!");
		}
		if (AppRun().equals("0")) {
			SOP("output =========AxelaticketlistService listData============== " + output);
		}
		return output;

	}

	public Map<String, String> ticketDashpage(String input, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws JSONException, ParseException {
		output = new HashMap();
		TicketDashService ticketdashservice = new TicketDashService();
		ticketdashservice.ticketRepositoryImpl = ticketRepositoryImpl;
		ticketdashservice.ticketRepository = ticketRepository;
		ticketdashservice.helpdeskTicketTransRepo = helpdeskTicketTransRepo;
		ticketdashservice.ticketTransFilterImpl = ticketTransFilterImpl;
		ticketdashservice.serviceTickethistoryRepository = serviceTickethistoryRepository;
		ticketdashservice.axelaEmpRepository = axelaEmpRepository;
		ticketdashservice.ticketServiceUpdate(input, request, response, session);
		output = ticketdashservice.output;
		return output;
	}
}
