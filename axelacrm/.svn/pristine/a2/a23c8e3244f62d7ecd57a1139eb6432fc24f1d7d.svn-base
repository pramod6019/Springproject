package axela.helpdesk.service;

import java.math.BigInteger;
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
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.customer.model.AxelaCustomerContact;
import axela.customer.repository.CustomerFilterImpl;
import axela.helpdesk.model.AxelaHelpDeskTicket;
import axela.helpdesk.model.AxelaHelpDeskTicketHistory;
import axela.helpdesk.model.AxelaHelpDeskTicketQueue;
import axela.helpdesk.repository.AxelaTicketQueueRepository;
import axela.helpdesk.repository.HelpDeskTicketDocRepository;
import axela.helpdesk.repository.HelpDeskTicketRepository;
import axela.helpdesk.repository.HelpDeskTicketTransRepo;
import axela.helpdesk.repository.HelpDeskTickethistoryRepository;
import axela.helpdesk.repository.TicketRepository;
import axela.helpdesk.repository.TicketRepositoryImpl;
import axela.portal.model.AxelaConfig;
import axela.portal.repository.EmpRepository;
import axela.service.repository.ServiceContractAssetRepository;
import axela.service.repository.ServiceContractRepository;

@Service
public class TicketService extends Connect {

	@Autowired
	public TicketRepository ticketRepository;

	@Autowired
	public EmpRepository empRepository;

	@Autowired
	public AxelaTicketQueueRepository axelaTicketQueueRepository;

	@Autowired
	private TicketRepositoryImpl ticketRepositoryImpl;

	@Autowired
	private ServiceContractAssetRepository serviceContractAssetRepository;

	@Autowired
	private CustomerFilterImpl customerFilterImpl;

	@Autowired
	private ServiceContractRepository serviceContractRepository;

	@Autowired
	public HelpDeskTickethistoryRepository serviceTickethistoryRepository;

	@Autowired
	private HelpDeskTicketRepository serviceTicketRepository;

	@Autowired
	HelpDeskTicketDocRepository helpDeskTicketDocRepository;

	@Autowired
	HelpDeskTicketTransRepo helpDeskTicketTransRepo;

	HashMap output = null;
	JSONObject inputObj = null;
	public String exeAccess = "", contractTitle = "", assetName = "";
	public int empId = 0;
	public String requestType = "";
	public String ticketEmpId = "0";
	public String ticketParentId = "0";
	public String ticketContactId = "0";
	public String ticketCustomerId = "0";
	public String ticketJcId = "0";
	public String contractId = "0";
	public String ticketAssetId = "0";
	public String ticketTicketqueueId = "0";
	public String ticketqueueIds = "0";
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
	public String ticketDesc = "0";
	public Date ticketDueTime = null;
	public String ticketTrigger2Hrs = "0";
	public String ticketTrigger3Hrs = "0";
	public String ticketNotes = "";
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
	public String sort = "";
	public String sortField = "";
	public int pageSize = 0;
	public String sortDirection = "";
	public int length = 0;
	public String compModulePm = "";
	public long closetime = 0;
	public String empFormatdate = "";
	public String empFormattime = "";
	public String elapsedclosetime = "";
	public String total = "";
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
	public String strSearch = "";
	public String ticketReopenedComments = "";
	public int ticketReopenedEmpId = 0;
	public String ticketReopenedTime = "";
	public String txtSearch = "";
	public String configCustomerName = "";
	public String orderType = "";
	public String perPage = "0";
	public String orderByField = "";
	public int page = 0;
	public String field = "";
	public String group = "";
	public String drBranchId = "0";
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
	public Date timeZone = null;

	public Map ticketService(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, SQLException, ParseException {
		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("inputObj========ticketService==========" + inputObj.toString(1));
		}
		timeZone = getTimeByZone(session);
		output = new HashMap<String, String>();
		exeAccess = PadQuotes(getSession("exeAccess", session));
		branchAccess = PadQuotes(getSession("branchAccess", session));
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		ticketEmpId = "1";
		empFormatdate = PadQuotes(getSession("formatdateName", session));
		empFormattime = PadQuotes(getSession("formattimeName", session));
		if (ticketTicketqueueId.equals("0")) {
			ticketTicketqueueId = ticketqueueIds;
		}
		if (!contractId.equals("0")) {
			contractTitle = PadQuotes(serviceContractRepository.findByTitle(Integer.parseInt(contractId)));
		}
		if (!ticketAssetId.equals("0")) {
			assetName = PadQuotes(serviceContractAssetRepository.findByAssetName(Integer.parseInt(ticketAssetId)));
		}
		if (!ticketContactId.equals("0") || !ticketJcId.equals("0")) {
			PopulateContactDetails();
		}

		if ((!ticketContactId.equals("0") || !ticketJcId.equals("0")) && ticketCustomerId.equals("0")) {
			// response.sendRedirect(response.encodeRedirectURL("../portal/error.jsp?msg=Invalid Contact!"));
		}
		//
		if (ticketTicketstatusId.equals("0")) {
			ticketTicketstatusId = "1";
		}

		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (empId != 0) {
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			PopulateConfigDetails(Integer.parseInt(ticketEmpId), empId);
			switch (requestType) {
				case "add" : // add a ticket.
					if (!returnPerm("emp_ticket_add", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					ticketId = 0;
					ticketReportTime = getTimeByZone(session);
					getValues(inputObj);
					addFields(response, session);
					break;

				case "update" :// update a ticket.
					ticketId = 0;
					getValues(inputObj);
					addFields(response, session);
					break;

				case "ticketDash" :
					addFields(response, session);
					break;

				case "delete" : // delete a ticket.
					if (!returnPerm("emp_ticket_delete", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					if (!inputObj.isNull("ticketId")) {
						ticketId = Integer.parseInt(CNumeric(PadQuotes(inputObj.getString("ticketId"))));
					}
					if (ticketId != 0) {
						deleteFields(ticketId);
					}
					break;

				case "landing" : // landingPage of a ticket.
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
		ticketId = 0;
		ticketEmpId = "0";
		ticketSubject = "";
		ticketRefno = "";
		ticketDesc = "";
		ticketPriorityticketId = "0";
		ticketTicketsourceId = "0";

		if (!inputObj.isNull("ticketId")) {
			ticketId = Integer.parseInt(CNumeric(PadQuotes(inputObj.getString("ticketId"))));
		}

		if (!inputObj.isNull("ticketEmpId")) {
			ticketEmpId = CNumeric(PadQuotes(inputObj.getString("ticketEmpId")));
		}

		if (!inputObj.isNull("ticketParentId")) {
			ticketParentId = CNumeric(PadQuotes(inputObj.getString("ticketParentId")));
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

	public void validateFields() throws NumberFormatException, ParseException {
		msg = "";
		if (!contractId.equals("0")) {
			ticketContractId = contractId;
		}
		if (ticketSubject.equals("")) {
			msg = msg + "<br>Enter Subject!";
		} else if (ticketSubject.length() < 5) {
			msg = msg + "<br>Subject should have atleast five characters!";
		}
		if (ticketTicketsourceId.equals("0")) {
			msg = msg + "<br>Select Source!";
		}
		if (ticketPriorityticketId.equals("0")) {
			msg = msg + "<br>Select Ticket Priority!";
		}
		if (ticketTicketqueueId.equals("0")) {
			msg = msg + "<br>Select Queue!";
		}
		if (ticketEmpId.equals("0")) {
			msg = msg + "<br>Select Executive!";
		}
		if (!ticketTicketqueueId.equals("0")) {
			String duehrs = "0", businessHrs = "", starttime = "", endtime = "", sun = "", mon = "", tue = "", wed = "", thu = "", fri = "", sat = "";

			AxelaHelpDeskTicketQueue axelaHelpDeskTicketQueue = axelaTicketQueueRepository.findBYTicketQueueId(Integer.parseInt(ticketTicketqueueId));
			duehrs = ConvertHoursToMins((axelaHelpDeskTicketQueue.getTicketqueueDuehrs() + "").replace(".", ":")) + "";
			businessHrs = axelaHelpDeskTicketQueue.getTicketqueueBusinessHrs();
			starttime = String.valueOf(axelaHelpDeskTicketQueue.getTicketqueueStarttime());
			endtime = String.valueOf(axelaHelpDeskTicketQueue.getTicketqueueEndtime());
			sun = axelaHelpDeskTicketQueue.getTicketqueueSun();
			mon = axelaHelpDeskTicketQueue.getTicketqueueMon();
			tue = axelaHelpDeskTicketQueue.getTicketqueueTue();
			wed = axelaHelpDeskTicketQueue.getTicketqueueWed();
			thu = axelaHelpDeskTicketQueue.getTicketqueueThu();
			fri = axelaHelpDeskTicketQueue.getTicketqueueFri();
			sat = axelaHelpDeskTicketQueue.getTicketqueueSat();
			ticketqueueTrigger1Hrs = ConvertHoursToMins(String.valueOf(axelaHelpDeskTicketQueue.getTicketqueueTrigger1Hrs()).replace(".", ":")) + "";
			ticketqueueTrigger2Hrs = ConvertHoursToMins(String.valueOf(axelaHelpDeskTicketQueue.getTicketqueueTrigger2Hrs()).replace(".", ":")) + "";
			ticketqueueTrigger3Hrs = ConvertHoursToMins(String.valueOf(axelaHelpDeskTicketQueue.getTicketqueueTrigger3Hrs()).replace(".", ":")) + "";
			ticketqueueTrigger4Hrs = ConvertHoursToMins(String.valueOf(axelaHelpDeskTicketQueue.getTicketqueueTrigger4Hrs()).replace(".", ":")) + "";
			ticketqueueTrigger5Hrs = ConvertHoursToMins(String.valueOf(axelaHelpDeskTicketQueue.getTicketqueueTrigger5Hrs()).replace(".", ":")) + "";
			if (businessHrs.equals("1")) {
				ArrayList public_holidate = publicHolidays(ticketReportTime, customerBranchId, String.valueOf(compId));
				if (!duehrs.equals("0")) {
					ticketDueTime = stringToDate(DueTime(sdf.format(ticketReportTime), duehrs,
							Double.parseDouble(starttime), Double.parseDouble(endtime),
							sun, mon, tue, wed, thu, fri, sat, public_holidate));
				} else {
					ticketDueTime = ticketReportTime;
				}
				// *** start- ticket_trigger_hrs
				if (!ticketqueueTrigger1Hrs.equals("0")) {
					ticketTrigger1Hrs = DueTime(sdf.format(ticketReportTime), ticketqueueTrigger1Hrs,
							Double.parseDouble(starttime), Double.parseDouble(endtime), sun, mon, tue, wed, thu, fri, sat, public_holidate);
				} else {
					ticketTrigger1Hrs = "";
				}

				if (!ticketqueueTrigger1Hrs.equals("0")) {
					ticketTrigger2Hrs = DueTime(sdf.format(ticketReportTime), ticketqueueTrigger2Hrs,
							Double.parseDouble(starttime), Double.parseDouble(endtime), sun, mon, tue, wed, thu, fri, sat, public_holidate);
				} else {
					ticketTrigger2Hrs = "";
				}

				if (!ticketqueueTrigger1Hrs.equals("0")) {
					ticketTrigger3Hrs = DueTime(sdf.format(ticketReportTime), ticketqueueTrigger3Hrs,
							Double.parseDouble(starttime), Double.parseDouble(endtime), sun, mon, tue, wed, thu, fri, sat, public_holidate);
				} else {
					ticketTrigger3Hrs = "";
				}

				if (!ticketqueueTrigger1Hrs.equals("0")) {
					ticketTrigger4Hrs = DueTime(sdf.format(ticketReportTime), ticketqueueTrigger4Hrs,
							Double.parseDouble(starttime), Double.parseDouble(endtime), sun, mon, tue, wed, thu, fri, sat, public_holidate);
				} else {
					ticketTrigger4Hrs = "";
				}

				if (!ticketqueueTrigger1Hrs.equals("0")) {
					ticketTrigger5Hrs = DueTime(sdf.format(ticketReportTime), ticketqueueTrigger5Hrs,
							Double.parseDouble(starttime), Double.parseDouble(endtime), sun, mon, tue, wed, thu, fri, sat, public_holidate);
				} else {
					ticketTrigger5Hrs = "";
				}
				// *** eof- ticket_trigger_hrs
			} else {
				if (!duehrs.equals("0")) {
					ticketDueTime = addHoursDate(ticketReportTime, 0, Double.parseDouble(duehrs), 0);

				} else {

					ticketDueTime = ticketReportTime;
				}

				if (!ticketqueueTrigger1Hrs.equals("0")) {

					ticketTrigger1Hrs = toLongDate(addHoursDate(ticketReportTime, 0, Double.parseDouble(ticketqueueTrigger1Hrs), 0));
				} else {
					ticketTrigger1Hrs = "";
				}
				if (!ticketqueueTrigger2Hrs.equals("0")) {
					ticketTrigger2Hrs = toLongDate(addHoursDate(ticketReportTime, 0, Double.parseDouble(ticketqueueTrigger2Hrs), 0));
				} else {
					ticketTrigger2Hrs = "";
				}
				if (!ticketqueueTrigger3Hrs.equals("0")) {
					ticketTrigger3Hrs = toLongDate(addHoursDate(ticketReportTime, 0, Double.parseDouble(ticketqueueTrigger3Hrs), 0));
				} else {
					ticketTrigger3Hrs = "";
				}
				if (!ticketqueueTrigger4Hrs.equals("0")) {
					ticketTrigger4Hrs = toLongDate(addHoursDate(ticketReportTime, 0, Double.parseDouble(ticketqueueTrigger4Hrs), 0));
				} else {
					ticketTrigger4Hrs = "";
				}
				if (!ticketqueueTrigger5Hrs.equals("0")) {
					ticketTrigger5Hrs = toLongDate(addHoursDate(ticketReportTime, 0, Double.parseDouble(ticketqueueTrigger5Hrs), 0));
				} else {
					ticketTrigger5Hrs = "";
				}

			}
		}
		if (configServiceTicketRefno.equals("1")) {

			if (ticketRefno.equals("")) {
				msg += "<br>Enter Reference No.!";
			} else {
				if (requestType.equals("add")) {
					if (!isNumeric(ticketRefno)) {
						msg += "<br>Enter Numeric Reference No.!";
					} else if (ticketRefno.length() < 2) {
						msg += "<br>Reference No. Should be Atleast Two Digits!";
					} else {
						StrSql = serviceTicketRepository.findByTicketRefNo(ticketRefno);
						if (!PadQuotes(StrSql).equals("")) {
							msg += "<br>Similar Ref No. found!";
						}
					}
				}
			}
		}
		if (ticketDesc.equals("")) {
			msg = msg + "<br>Enter Description!";
		} else if (ticketDesc.length() < 5) {
			msg = msg + "<br>Description should have atleast five characters!";
		}
	}

	public void addFields(HttpServletResponse response, HttpSession session) throws SQLException, ParseException {
		output = new HashMap();
		validateFields();
		AxelaHelpDeskTicket axelaHelpDeskTicket = null;
		if (msg.equals("")) {
			if (ticketId != 0) {
				axelaHelpDeskTicket = ticketRepository.findOne(ticketId);
			} else {
				axelaHelpDeskTicket = new AxelaHelpDeskTicket();
			}
			axelaHelpDeskTicket.setTicketParentId(Integer.parseInt(ticketParentId));
			axelaHelpDeskTicket.setTicketCustomerId(Integer.parseInt(ticketCustomerId));
			axelaHelpDeskTicket.setTicketContactId(Integer.parseInt(ticketContactId));
			axelaHelpDeskTicket.setTicketOpprId(Integer.parseInt(ticketOpprId));
			axelaHelpDeskTicket.setTicketSoId(Integer.parseInt(ticketSoId));
			axelaHelpDeskTicket.setTicketCrmId(Integer.parseInt(ticketCrmId));
			axelaHelpDeskTicket.setTicketJcSerialno(ticketJcSerialno);
			axelaHelpDeskTicket.setTicketJcId(Integer.parseInt(ticketJcId));
			axelaHelpDeskTicket.setTicketJcpsfId(Integer.parseInt(ticketJcpsfId));
			axelaHelpDeskTicket.setTicketContractId(Integer.parseInt(ticketContractId));
			axelaHelpDeskTicket.setTicketAssetId(Integer.parseInt(ticketAssetId));
			axelaHelpDeskTicket.setTicketPmId(Integer.parseInt(ticketPmId));
			axelaHelpDeskTicket.setTicketTicketsourceId(Integer.parseInt(ticketTicketsourceId));
			axelaHelpDeskTicket.setTicketReportTime(ticketReportTime);
			axelaHelpDeskTicket.setTicketClosedComments(ticketClosedComments);
			axelaHelpDeskTicket.setTicketTicketstatusId(Integer.parseInt(ticketTicketstatusId));
			axelaHelpDeskTicket.setTicketTicketcatId(Integer.parseInt(ticketTicketcatId));
			axelaHelpDeskTicket.setTicketTickettypeId(Integer.parseInt(ticketTickettypeId));
			axelaHelpDeskTicket.setTicketPriorityticketId(Integer.parseInt(ticketPriorityticketId));
			axelaHelpDeskTicket.setTicketTicketqueueId(Integer.parseInt(ticketTicketqueueId));
			axelaHelpDeskTicket.setTicketSubject(ticketSubject);
			axelaHelpDeskTicket.setTicketDesc(ticketDesc);
			axelaHelpDeskTicket.setTicketReopenedComments(ticketReopenedComments);
			axelaHelpDeskTicket.setTicketReopenedEmpId(ticketReopenedEmpId);
			axelaHelpDeskTicket.setTicketReopenedTime(stringToDate(ticketReopenedTime));
			axelaHelpDeskTicket.setTicketLoggerMobile(ticketLoggerMobile);
			axelaHelpDeskTicket.setTicketLoggerName(ticketLoggerName);
			axelaHelpDeskTicket.setTicketLoggerPhone(ticketLoggerPhone);
			axelaHelpDeskTicket.setTicketLoggerTitleId(ticketLoggerTitleId);
			axelaHelpDeskTicket.setTicketLoggerJobtitle(ticketLoggerJobtitle);
			axelaHelpDeskTicket.setTicketLoggerEmail(ticketLoggerEmail);
			// axelaHelpDeskTicket.setTicketContactEntryDate(getTimeByZone(session));
			// axelaHelpDeskTicket.setTicketClosedTime(stringToDate(ticketClosedTime));
			axelaHelpDeskTicket.setTicketEmpId(Integer.parseInt(ticketEmpId));
			axelaHelpDeskTicket.setTicketDueTime(ticketDueTime);
			axelaHelpDeskTicket.setTicketTrigger1Hrs(stringToDate(ticketTrigger1Hrs));
			axelaHelpDeskTicket.setTicketTrigger2Hrs(stringToDate(ticketTrigger2Hrs));
			axelaHelpDeskTicket.setTicketTrigger3Hrs(stringToDate(ticketTrigger3Hrs));
			axelaHelpDeskTicket.setTicketTrigger4Hrs(stringToDate(ticketTrigger4Hrs));
			axelaHelpDeskTicket.setTicketTrigger5Hrs(stringToDate(ticketTrigger5Hrs));
			axelaHelpDeskTicket.setTicketNotes(ticketNotes);
			axelaHelpDeskTicket.setTicketTrigger(Integer.parseInt(ticketTrigger));
			axelaHelpDeskTicket.setTicketRefno(ticketRefno);
			axelaHelpDeskTicket.setTicketRead(ticketRead);
			if (requestType.equals("add")) {
				axelaHelpDeskTicket.setTicketEntryDate(timeZone);
				axelaHelpDeskTicket.setTicketEntryId(empId);
				axelaHelpDeskTicket.setTicketModifiedId(0);
				axelaHelpDeskTicket.setTicketModifiedDate(stringToDate(""));
			} else {
				axelaHelpDeskTicket.setTicketEntryDate(axelaHelpDeskTicket.getTicketEntryDate());
				axelaHelpDeskTicket.setTicketEntryId(axelaHelpDeskTicket.getTicketEntryId());
				axelaHelpDeskTicket.setTicketModifiedId(empId);
				axelaHelpDeskTicket.setTicketModifiedDate(timeZone);
			}
			ticketId = ticketRepository.save(axelaHelpDeskTicket).getTicketId();
			if (ticketId != 0 && requestType.equals("add")) {
				output.put("successmsg", "Ticket Added Successfully!");
				output.put("ticketId", ticketId + "");
			} else if (ticketId != 0 && requestType.equals("update")) {
				output.put("successmsg", "Ticket Updated Successfully!");
				output.put("ticketId", ticketId + "");
			}
			AxelaHelpDeskTicketHistory axelaHelpDeskTicketHistory = new AxelaHelpDeskTicketHistory();
			axelaHelpDeskTicketHistory.setHistoryTicketId(BigInteger.valueOf(axelaHelpDeskTicket.getTicketId()));
			axelaHelpDeskTicketHistory.setHistoryEmpId(Integer.parseInt(ticketEmpId));
			axelaHelpDeskTicketHistory.setHistoryDatetime(getTimeByZone(session));
			axelaHelpDeskTicketHistory.setHistoryActiontype("NEW_TICKET");
			axelaHelpDeskTicketHistory.setHistoryOldvalue("");
			axelaHelpDeskTicketHistory.setHistoryNewvalue("New ticket added");
			serviceTickethistoryRepository.save(axelaHelpDeskTicketHistory);

			if (ticketId != 0) {
				if (!contactEmail2.equals("") && !contactEmail1.equals("")) {
					sendContactEmail = contactEmail1 + "," + contactEmail2;
				} else if (!contactEmail1.equals("")) {
					sendContactEmail = contactEmail1;
				} else if (!contactEmail2.equals("")) {
					sendContactEmail = contactEmail2;
				}
				if (compEmailEnable.equals("1")
						&& configEmailEnable.equals("1")
						&& !configAdminEmail.equals("")
						&& configTicketNewEmailEnable.equals("1")) {
					if (!sendContactEmail.equals("")
							&& !configTicketNewEmailFormat.equals("")
							&& !configTicketNewEmailSub.equals("")) {
						SendEmail();
					}

					if (!empEmailFormail.equals("")
							&& !configTicketNewEmailExeFormat.equals("")
							&& !configTicketNewEmailExeSub.equals("")) {
						if (!ticketEmpId.equals(ticketEntryId) && !entryempEmail.equals("")) {
							empEmailFormail = empEmailFormail + "," + entryempEmail;
						}
						if (ticketCrmId.equals("0") && ticketJcpsfId.equals("0")) {
							SendEmailToExecutive();
						}

						SendEmailToExecutive();
					}
				}
				if (compSmsEnable.equals("1") && configSmsEnable.equals("1") && configTicketNewSmsEnable.equals("1")) {
					if (!configTicketNewSmsFormat.equals("")) {
						if (!contactMobile1.equals("")) {
							SendSMS(contactMobile1);
						}
						if (!contactMobile2.equals("")) {
							SendSMS(contactMobile2);
						}
					}
					if (!configTicketNewSmsExeFormat.equals("")) {
						if (!empMobile1.equals("")) {
							SendSMSToExecutive(empMobile1);
						}
						if (!empMobile2.equals("")) {
							SendSMSToExecutive(empMobile2);
						}
					}

				}

			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}
	public void deleteFields(int ticketId) {
		if (msg.equals("")) {
			helpDeskTicketDocRepository.deleteByDocTicketId(ticketId);
			helpDeskTicketTransRepo.deleteByTickettransTicketId(ticketId);
			ticketRepository.delete(ticketId);
			output.put("successmsg", "Ticket Deleted Successfully!");
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
		branchAccess = getSession("branchAccess", session).replaceAll("branchId", "ticket.axelaCustomers.customerBranchId");
		exeAccess = getSession("exeAccess", session).replaceAll("empId", "ticket.axelaEmp.EmpId");
		if (!starttime.equals("")) {
			strSearch = " and substr(ticket.ticketEntryDate,1,8) >= substr('" + starttime + "',1,8) ";
		}
		if (!endtime.equals("")) {
			strSearch = strSearch + " and substr(ticket.ticketEntryDate,1,8) <= substr('" + endtime + "',1,8) ";
		}
		if (!drBranchId.equals("0")) {
			strSearch = strSearch + " and ticket.axelaCustomer.customerBranchId=" + drBranchId;
			strSearch = strSearch + " and ticket.axelaCustomer..axelaBranch.branchActive = '1'";
		}

		if (!msg.equals("")) {
			msg = "<br>Error!" + msg;
		}
		strSearch += branchAccess + "" + exeAccess + "";
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> contract = ticketRepositoryImpl.findTicketSummary(strSearch, session);
		for (Object[] results : contract) {
			LinkedHashMap map = new LinkedHashMap<String, String>();
			map.put("branchId", String.valueOf(results[0]));
			map.put("branchName", String.valueOf(results[1]));
			map.put("ticketCount", Long.parseLong(String.valueOf(results[2])));
			grandTotal += Long.parseLong(String.valueOf(results[2]));
			list.add(map);
		}
		output.put("populateLandingDetails", list);
		output.put("grandTotal", grandTotal);
		return output;
	}

	public Map<String, String> populateData(String input, HttpSession session) throws JSONException, ParseException {
		exeAccess = PadQuotes(getSession("exeAccess", session));
		branchAccess = PadQuotes(getSession("branchAccess", session));
		empFormatdate = PadQuotes(getSession("formatdateName", session));
		empFormattime = PadQuotes(getSession("formattimeName", session));
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, String>();
		if (empId != 0) {
			if (!returnPerm("emp_ticket_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
			if (!inputObj.isNull("ticketId")) {
				ticketId = Integer.parseInt(CNumeric(PadQuotes(inputObj.getString("ticketId"))));
			}
			if (ticketId != 0) {
				List<AxelaHelpDeskTicket> axelaServiceTicket = ticketRepositoryImpl.populateData(ticketId, branchAccess, exeAccess);
				for (AxelaHelpDeskTicket obj : axelaServiceTicket) {
					map.put("ticketId", PadQuotes(String.valueOf(Integer.parseInt(PadQuotes(String.valueOf(obj.getTicketId()))))));
					map.put("customerBranchId", PadQuotes(String.valueOf(obj.getCustomerBranchId())));
					map.put("ticketContactId", PadQuotes(String.valueOf(obj.getTicketContactId())));
					map.put("ticketCustomerId", PadQuotes(String.valueOf(obj.getTicketCustomerId())));
					map.put("ticketParentId", PadQuotes(String.valueOf(obj.getTicketParentId())));
					map.put("customerName", PadQuotes(String.valueOf(obj.getCustomerName())));
					map.put("contactName", PadQuotes(String.valueOf(obj.getContactName())));
					map.put("ticketTicketstatusId", PadQuotes(String.valueOf(obj.getTicketTicketstatusId())));
					map.put("ticketTicketcatId", PadQuotes(String.valueOf(obj.getTicketTicketcatId())));
					map.put("ticketTickettypeId", PadQuotes(String.valueOf(obj.getTicketTickettypeId())));
					map.put("ticketPmId", PadQuotes(String.valueOf(obj.getTicketPmId())));
					map.put("ticketContractId", PadQuotes(String.valueOf(obj.getTicketContractId())));
					map.put("ticketSubject", PadQuotes(String.valueOf(obj.getTicketSubject())));
					map.put("ticketDesc", PadQuotes(String.valueOf(obj.getTicketDesc())));
					map.put("ticketEmpId", PadQuotes(String.valueOf(obj.getTicketEmpId())));
					map.put("ticketRead", PadQuotes(String.valueOf(obj.getTicketRead())));
					if (ticketRead.equals("0") && empId == Integer.parseInt(ticketEmpId)) {
						ticketRepository.updateByTicketId(ticketId);
					}
					map.put("ticketNotes", PadQuotes(String.valueOf(obj.getTicketNotes())));
					map.put("ticketRefno", PadQuotes(String.valueOf(obj.getTicketRefno())));
					map.put("ticketTicketsourceId", PadQuotes(String.valueOf(obj.getTicketTicketsourceId())));
					map.put("ticketTicketqueueId", PadQuotes(String.valueOf(obj.getTicketTicketqueueId())));
					map.put("ticketPriorityticketId", PadQuotes(String.valueOf(obj.getTicketPriorityticketId())));
					map.put("ticketReportTime", strToLongDate(obj.getTicketReportTime()));
					map.put("ticketDueTime", PadQuotes(strToLongDate(obj.getTicketDueTime())));
					if (obj.getTicketEntryId() != 0) {
						map.put("ticketEntryDate", strToShortDate(obj.getTicketEntryDate()));
						map.put("ticketEntryId", String.valueOf(obj.getTicketEntryId()));
						map.put("ticketEntryBy", empRepository.findEmpName(Integer.parseInt(String.valueOf(obj.getTicketEntryId()))));
					}
					if (obj.getTicketModifiedId() != 0) {
						map.put("ticketModifiedDate", strToShortDate(obj.getTicketModifiedDate()));
						map.put("ticketModifiedId", String.valueOf(obj.getTicketModifiedId()));
						map.put("ticketModifiedBy", empRepository.findEmpName(Integer.parseInt(String.valueOf(obj.getTicketModifiedId()))));
					}
					list.add(map);
				}
				output.put("populateData", list);
			}
		}
		return output;
	}
	public void PopulateConfigDetails(int ticketEmpId, int empId) {
		List<AxelaConfig> obj = ticketRepositoryImpl.findAllByPopulateConfig(ticketEmpId, empId);

		for (AxelaConfig axelaConfig : obj) {
			configServiceContract = PadQuotes(axelaConfig.getConfigServiceContract());
			// configServiceTicketCat = PadQuotes(axelaConfig.getConfigHelpDeskTicketCat());
			// configServiceTicketType = PadQuotes(axelaConfig.getConfigHelpdeskTicketType());
			compModulePm = PadQuotes(axelaConfig.getCompModulePm());
			configTicketNewSmsFormat = PadQuotes(axelaConfig.getConfigTicketNewSmsFormat());
			configEmailEnable = PadQuotes(axelaConfig.getConfigEmailEnable());
			configAdminEmail = PadQuotes(axelaConfig.getConfigAdminEmail());
			configTicketNewEmailEnable = PadQuotes(axelaConfig.getConfigTicketNewEmailEnable());
			configTicketNewEmailFormat = PadQuotes(axelaConfig.getConfigTicketNewEmailFormat());
			configTicketNewEmailSub = PadQuotes(axelaConfig.getConfigTicketNewEmailSub());
			configTicketNewSmsEnable = PadQuotes(axelaConfig.getConfigTicketNewSmsEnable());
			configTicketNewEmailExeFormat = PadQuotes(axelaConfig.getConfigTicketNewEmailExeFormat());
			configTicketNewEmailExeSub = PadQuotes(axelaConfig.getConfigTicketNewEmailExeSub());
			configTicketNewSmsExeFormat = PadQuotes(axelaConfig.getConfigTicketNewSmsExeFormat());
			compSmsEnable = PadQuotes(axelaConfig.getCompSmsEnable());
			configSmsEnable = PadQuotes(axelaConfig.getConfigSmsEnable());
			configTicketFollowupSmsFormat = PadQuotes(axelaConfig.getConfigTicketFollowupSmsFormat());
			compEmailEnable = PadQuotes(axelaConfig.getCompEmailEnable());
			// configServiceTicketRefno = PadQuotes(axelaConfig.getConfigHelpDeskTicketRefno());
			empEmail1 = PadQuotes(axelaConfig.getEmpEmail1());
			empEmail2 = PadQuotes(axelaConfig.getEmpEmail2());
			empName = PadQuotes(axelaConfig.getEmpName());
			if (!empEmail2.equals("")) {
				empEmailFormail = empEmail1 + "," + empEmail2;
			} else {
				empEmailFormail = empEmail1;
			}
			entryempEmail = PadQuotes(axelaConfig.getEmpmail1());
		}
	}

	public Map<String, String> listData(String input, HttpSession session) throws JSONException, ParseException {
		output = new LinkedHashMap<String, String>();
		sortField = "";
		pageIndex = 0;
		pageSize = 0;
		sortDirection = "";
		String strOrderBy = "";
		String strSearch = "";
		requestType = "";
		page = 0;
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		perPage = CNumeric(getSession("empRecperpage", session));
		configCustomerName = getSession("configCustomerName", session);
		if (empId != 0) {
			if (!returnPerm("emp_ticket_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			branchAccess = getSession("branchAccess", session).replaceAll("branchId", "ticket.axelaCustomer.customerBranchId");
			pageIndex = Integer.parseInt(CNumeric(PadQuotes(getSession("empRecperpage", session))));
			List<AxelaHelpDeskTicket> axelaHelpDeskTicket = null;
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			if (!inputObj.isNull("sortField")) {
				orderByField = PadQuotes((inputObj.getString("sortField")));
			}
			if (!inputObj.isNull("requestType")) {
				requestType = PadQuotes((inputObj.getString("requestType")));
			}
			if (!inputObj.isNull("group")) {
				group = CNumeric(PadQuotes((inputObj.getString("group"))));
			}
			if (!inputObj.isNull("pageIndex")) {
				page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
			}
			if (!inputObj.isNull("sortDirection")) {
				orderType = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
			}
			perPage = "25";// CNumeric(getSession("emp_recperpage", session));
			if (orderType.equals("")) {
				orderType = "DESC";
			}
			if (orderByField.equals("")) {
				orderByField = "ticketId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			strOrderBy = " ORDER BY ticket." + orderByField + " " + orderType + "";
			axelaHelpDeskTicket = ticketRepositoryImpl.findAll(strSearch, strOrderBy, page, Integer.parseInt(perPage), "no");
			String length = ticketRepositoryImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			output.put("meta", mapNavi);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("ID", "ticketId", "center"));
			listHeader.add(produceHeaderData("Ticket", "ticketSubject", "center"));
			listHeader.add(produceHeaderData(configCustomerName + " Name", "axelaCustomer.customerName", "center"));
			listHeader.add(produceHeaderData("Report Time", "ticketReportTime", "center"));
			listHeader.add(produceHeaderData("Due Time", "ticketDueTime", "center"));
			listHeader.add(produceHeaderData("Status", "ticketTicketstatusId", "center"));
			listHeader.add(produceHeaderData("Priority", "ticketPriorityticketId", "center"));
			listHeader.add(produceHeaderData("level", "ticketTrigger", "center"));
			listHeader.add(produceHeaderData("Category", "ticketTicketcatId", "center"));
			if (configServiceTicketType.equals("1")) {
				listHeader.add(produceHeaderData("Type", "ticketTickettypeId", "center"));
			}
			if (configServiceTicketCat.equals("1")) {
				listHeader.add(produceHeaderData("Queue", "ticketTicketqueueId", "center"));
			}
			listHeader.add(produceHeaderData("Contract", "ticketContractId", "center"));
			listHeader.add(produceHeaderData("Asset", "ticketAssetId", "center"));
			listHeader.add(produceHeaderData("Executive", "ticketEmpId", "center"));
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
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaHelpDeskTicket obj : axelaHelpDeskTicket) {
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
				value.add(String.valueOf(obj.getTicketId()));
				paramSubArr.add("ticketDash");
				paramSubArr.add(obj.getTicketId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// Ticket
				if (!obj.getTicketSubject().equals("0")) {
					type.add(true);
					value.add(String.valueOf(obj.getTicketSubject()));
					paramSubArr.add("ticketDash");
					paramSubArr.add(obj.getTicketId() + "");
					paramArr.add((ArrayList) paramSubArr.clone());
					paramSubArr.clear();
				}
				if (!obj.getTicketJcSerialno().equals("0")) {
					type.add(true);
					value.add(String.valueOf("JC Serial No.:" + obj.getTicketJcSerialno()));
					paramSubArr.add("ticketDash");
					paramSubArr.add(obj.getTicketJcSerialno() + "");
					paramArr.add((ArrayList) paramSubArr.clone());
					paramSubArr.clear();
				}
				if (obj.getTicketJcId() != 0) {
					type.add(true);
					value.add(String.valueOf("JC ID:" + obj.getTicketJcId()));
					paramSubArr.add("jobcardList");
					paramSubArr.add(obj.getTicketJcId() + "");
					paramArr.add((ArrayList) paramSubArr.clone());
					paramSubArr.clear();
				}
				if (obj.getTicketJcpsfId() != 0) {
					type.add(true);
					value.add(String.valueOf("JCPSF ID:" + obj.getTicketJcpsfId()));
					paramSubArr.add("jobcardDash");
					paramSubArr.add(obj.getTicketJcpsfId() + "");
					paramArr.add((ArrayList) paramSubArr.clone());
					paramSubArr.clear();
				}
				if (obj.getTicketOpprId() != 0) {
					type.add(true);
					value.add(String.valueOf("Oppr ID: " + obj.getTicketOpprId()));
					paramSubArr.add("opportynityList");
					paramSubArr.add(obj.getTicketOpprId() + "");
					paramArr.add((ArrayList) paramSubArr.clone());
					paramSubArr.clear();
				}
				if (obj.getTicketCrmId() != 0) {
					type.add(true);
					value.add(String.valueOf("CRM ID: " + obj.getTicketCrmId()));
					paramSubArr.add("opportynityDash");
					paramSubArr.add(obj.getTicketCrmId() + "");
					paramArr.add((ArrayList) paramSubArr.clone());
					paramSubArr.clear();
				}
				if (obj.getTicketSoId() != 0) {
					type.add(true);
					value.add(String.valueOf("SO ID: " + obj.getTicketSoId()));
					paramSubArr.add("voucherList");
					paramSubArr.add(obj.getTicketSoId() + "");
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// Customer
				if (!PadQuotes(String.valueOf(obj.getTicketContactId())).equals("0") && !PadQuotes(String.valueOf(obj.getTicketCustomerId())).equals("0")) {
					type.add(true);
					value.add(obj.getCustomerName());
					paramSubArr.add("customerList");
					paramSubArr.add(obj.getCustomerId() + "");
					paramArr.add((ArrayList) paramSubArr.clone());
					paramSubArr.clear();
					paramArr.clear();
					type.add(true);
					value.add(obj.getContactName());
					paramSubArr.add("contactList");
					paramSubArr.add(obj.getTicketContactId() + "");
					paramArr.add((ArrayList) paramSubArr.clone());
					paramArr.clear();
					paramSubArr.clear();
				}
				if (!obj.getContactMobile1().equals("") && !obj.getContactMobile2().equals("") && !obj.getContactEmail1().equals("") && !obj.getContactEmail2().equals("")) {
					type.add(false);
					type.add(false);
					type.add(false);
					type.add(false);
					type.add(false);
					value.add(obj.getContactMobile1());
					value.add(obj.getContactMobile2());
					value.add(obj.getContactEmail1());
					value.add(obj.getContactEmail2());
				}
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// ReportTime
				type.add(false);
				SOP("obj.getTicketReportTime().toString()=================" + obj.getTicketReportTime());
				value.add(sdf.format(obj.getTicketReportTime()));
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// DueTime
				String dueTime = "";
				if (obj.getTicketClosedTime() != null) {
					closetime = Long.parseLong(sdf1.format(obj.getTicketClosedTime()));
				} else {
					closetime = Long.parseLong(sdf1.format(kknow()));
				}
				if (obj.getTicketDueTime() != null) {
					if (closetime >= Long.parseLong(sdf1.format(obj.getTicketDueTime()))) {
						type.add(false);
						value.add("<font color=#ff0000>" + " " + sdf.format(obj.getTicketDueTime()));
					} else {
						type.add(false);
						value.add("<font color=blue>" + " " + sdf.format(obj.getTicketDueTime()));
					}
					listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
				}

				// Status
				if (PadQuotes(String.valueOf(obj.getTicketstatusId())).equals("3")) {
					type.add(false);
					value.add(obj.getTicketstatusName());
					listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
				} else {
					type.add(false);
					value.add(obj.getTicketstatusName());
					listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
				}

				type.add(false);
				value.add(obj.getPriorityticketName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				type.add(false);
				value.add(obj.getTicketTrigger());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				if (configServiceTicketCat.equals("1")) {
					type.add(false);
					value.add(obj.getTicketcatName());
					listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
				}
				if (configServiceTicketType.equals("1")) {
					type.add(false);
					value.add(obj.getTickettypeName());
					listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
				}
				type.add(false);
				value.add(obj.getTicketqueueName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// contractList
				if (obj.getTicketContractId() != 0) {
					type.add(false);
					value.add(obj.getTicketContractId() + " " + obj.getContractTitle());
					paramSubArr.add("contractList");
					paramSubArr.add(PadQuotes(String.valueOf(obj.getTicketContractId())));
					paramArr.add((ArrayList) paramSubArr.clone());
				}
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// assetList
				if (obj.getTicketAssetId() != 0) {
					type.add(true);
					value.add(obj.getTicketAssetId() + " " + obj.getAssetName());
					paramSubArr.add("assetList");
					paramSubArr.add(PadQuotes(String.valueOf(obj.getTicketAssetId())));
					paramArr.add((ArrayList) paramSubArr.clone());
					paramSubArr.clear();
				}
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// executive
				type.add(false);
				value.add(ExePhotoOval(obj.getTicketEmpId() + ""));
				paramArr.add((ArrayList) paramSubArr.clone());
				type.add(true);
				value.add(obj.getEmpName());
				paramSubArr.add("executiveSummary");
				paramSubArr.add(obj.getTicketEmpId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// End Body data
				mapData.put("td", listData);
				ArrayList actionParam = new ArrayList();
				actionParam.add("updateticket");
				actionParam.add(PadQuotes(String.valueOf(obj.getTicketId())));
				actionParam.add(PadQuotes(String.valueOf(obj.getTicketContractId())));
				// End Body data
				mapData.put("td", listData);
				mapAction.put("td", produceActionData(actionParam));
				listAction.add(mapAction);
				listBody.add(mapData);
			}
			output.put("meta", mapNavi);
			output.put("thead", listHeader);
			output.put("tdalign", listBodyAlign);
			output.put("tbody", listBody);
			output.put("action", listAction);
			if (AppRun().equals("0")) {
				SOP("output==========TicketService==========" + output.toString());
			}
		}
		return output;
	}
	private ArrayList<HashMap> produceActionData(ArrayList<String> Param) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Ticket");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	protected void SendEmail() throws SQLException {
		String emailmsg, sub;
		emailmsg = (configTicketNewEmailFormat);
		sub = (configTicketNewEmailSub);

		emailmsg = "replace('" + emailmsg + "','[TICKETID]',ticketId)";
		emailmsg = "replace(" + emailmsg + ",'[TICKETSUBJECT]',ticketSubject)";
		emailmsg = "replace(" + emailmsg + ",'[TICKETSTATUS]',ticketstatusName)";
		emailmsg = "replace(" + emailmsg + ",'[TICKETTIME]',DATE_FORMAT(ticketReportTime,'%d/%m/%Y %H:%i'))";
		emailmsg = "replace(" + emailmsg + ",'[DUETIME]',DATE_FORMAT(ticketDueTime,'%d/%m/%Y %H:%i'))";
		emailmsg = "replace(" + emailmsg + ",'[QUEUE]',ticketqueueName)";
		emailmsg = "replace(" + emailmsg + ",'[PRIORITY]',priorityticketName)";
		emailmsg = "replace(" + emailmsg + ",'[EXENAME]',empName)";
		emailmsg = "replace(" + emailmsg + ",'[EXEJOBTITLE]',jobtitleDesc)";
		emailmsg = "replace(" + emailmsg + ",'[EXEEMAIL1]',empEmail1)";
		emailmsg = "replace(" + emailmsg + ",'[EXEEMAIL2]',empEmail2)";
		emailmsg = "replace(" + emailmsg + ",'[EXEMOBILE1]',empMobile1)";
		emailmsg = "replace(" + emailmsg + ",'[EXEMOBILE2]',empMobile2)";
		emailmsg = "replace(" + emailmsg + ",'[EXEPHONE1]',empPhone1)";
		emailmsg = "replace(" + emailmsg + ",'[CONTACTID]',ticketContactId)";
		emailmsg = "replace(" + emailmsg + ",'[CONTACTNAME]',concat(titleDesc, ' ', contactFname,' ', contactLname))";
		emailmsg = "replace(" + emailmsg + ",'[CONTACTMOBILE1]',contactMobile1)";
		emailmsg = "replace(" + emailmsg + ",'[CONTACTEMAIL1]',contactEmail1)";
		emailmsg = "replace(" + emailmsg + ",'[CUSTOMERID]',ticketCustomerId)";
		emailmsg = "replace(" + emailmsg + ",'[CUSTOMERNAME]',customerName)";
		emailmsg = "replace(" + emailmsg + ",'[FOLLOWUPDESC]',coalesce(tickettransFollowup, ''))";

		sub = "replace('" + sub + "','[TICKETID]',ticketId)";
		sub = "replace(" + sub + ",'[TICKETSUBJECT]',ticketSubject)";
		sub = "replace(" + sub + ",'[TICKETSTATUS]',ticketstatusName)";
		sub = "replace(" + sub + ",'[TICKETTIME]',DATE_FORMAT(ticketReportTime,'%d/%m/%Y %H:%i'))";
		sub = "replace(" + sub + ",'[DUETIME]',DATE_FORMAT(ticketDueTime,'%d/%m/%Y %H:%i'))";
		sub = "replace(" + sub + ",'[QUEUE]',ticketqueueName)";
		sub = "replace(" + sub + ",'[PRIORITY]',priorityticketName)";
		sub = "replace(" + sub + ",'[EXENAME]',empName)";
		sub = "replace(" + sub + ",'[EXEJOBTITLE]',jobtitleDesc)";
		sub = "replace(" + sub + ",'[EXEEMAIL1]',empEmail1)";
		sub = "replace(" + sub + ",'[EXEEMAIL2]',empEmail2)";
		sub = "replace(" + sub + ",'[EXEMOBILE1]',empMobile1)";
		sub = "replace(" + sub + ",'[EXEMOBILE2]',empMobile2)";
		sub = "replace(" + sub + ",'[EXEPHONE1]',empPhone1)";
		sub = "replace(" + sub + ",'[CONTACTID]',ticketContactId)";
		sub = "replace(" + sub + ",'[CONTACTNAME]',concat(titleDesc, ' ', contactFname,' ', contactLname))";
		sub = "replace(" + sub + ",'[CONTACTMOBILE1]',contactMobile1)";
		sub = "replace(" + sub + ",'[CONTACTEMAIL1]',contactEmail1)";
		sub = "replace(" + sub + ",'[CUSTOMERID]',ticketCustomerId)";
		sub = "replace(" + sub + ",'[CUSTOMERNAME]',customerName)";
		sub = "replace(" + sub + ",'[FOLLOWUPDESC]',coalesce(tickettransFollowup, ''))";
	}

	protected void SendSMS(String contactMobile) throws SQLException {
		String smsmsg = (configTicketNewSmsFormat);

		smsmsg = "replace('" + smsmsg + "','[TICKETID]',ticketId)";
		smsmsg = "replace(" + smsmsg + ",'[TICKETSUBJECT]',ticketSubject)";
		smsmsg = "replace(" + smsmsg + ",'[TICKETSTATUS]',ticketstatusName)";
		smsmsg = "replace(" + smsmsg + ",'[TICKETTIME]',DATE_FORMAT(ticketReportTime,'%d/%m/%Y %H:%i'))";
		smsmsg = "replace(" + smsmsg + ",'[DUETIME]',DATE_FORMAT(ticketDueTime,'%d/%m/%Y %H:%i'))";
		smsmsg = "replace(" + smsmsg + ",'[QUEUE]',ticketqueueName)";
		smsmsg = "replace(" + smsmsg + ",'[PRIORITY]',priorityticketName)";
		smsmsg = "replace(" + smsmsg + ",'[EXENAME]',empName)";
		smsmsg = "replace(" + smsmsg + ",'[EXEJOBTITLE]',jobtitleDesc)";
		smsmsg = "replace(" + smsmsg + ",'[EXEEMAIL1]',empEmail1)";
		smsmsg = "replace(" + smsmsg + ",'[EXEEMAIL2]',empEmail2)";
		smsmsg = "replace(" + smsmsg + ",'[EXEMOBILE1]',empMobile1)";
		smsmsg = "replace(" + smsmsg + ",'[EXEMOBILE2]',empMobile2)";
		smsmsg = "replace(" + smsmsg + ",'[EXEPHONE1]',empPhone1)";
		smsmsg = "replace(" + smsmsg + ",'[FOLLOWUPDESC]',coalesce(tickettransFollowup, ''))";
		smsmsg = "replace(" + smsmsg + ",'[CONTACTID]',ticketContactId)";
		smsmsg = "replace(" + smsmsg + ",'[CONTACTNAME]',concat(titleDesc, ' ', contactFname,' ', contactLname))";
		smsmsg = "replace(" + smsmsg + ",'[CONTACTMOBILE1]',contactMobile1)";
		smsmsg = "replace(" + smsmsg + ",'[CONTACTEMAIL1]',contactEmail1)";
		smsmsg = "replace(" + smsmsg + ",'[CUSTOMERID]',ticketCustomerId)";
		smsmsg = "replace(" + smsmsg + ",'[CUSTOMERNAME]',customerName)";

	}

	protected void SendEmailToExecutive() throws SQLException {
		String emailmsg = "", sub = "";

		emailmsg = (configTicketNewEmailExeFormat);
		sub = (configTicketNewEmailExeSub);

		sub = "replace('" + sub + "','[TICKETID]',ticketId)";
		sub = "replace(" + sub + ",'[TICKETSUBJECT]',ticketSubject)";
		sub = "replace(" + sub + ",'[TICKETSTATUS]',ticketstatusName)";
		sub = "replace(" + sub + ",'[TICKETTIME]',DATE_FORMAT(ticketReportTime,'%d/%m/%Y %H:%i'))";
		sub = "replace(" + sub + ",'[DUETIME]',DATE_FORMAT(ticketDueTime,'%d/%m/%Y %H:%i'))";
		sub = "replace(" + sub + ",'[QUEUE]',ticketqueueName)";
		sub = "replace(" + sub + ",'[PRIORITY]',priorityticketName)";
		sub = "replace(" + sub + ",'[TICKETOWNER]',o.empName)";
		sub = "replace(" + sub + ",'[EXENAME]',s.empName)";
		sub = "replace(" + sub + ",'[EXEJOBTITLE]',jobtitleDesc)";
		sub = "replace(" + sub + ",'[EXEEMAIL1]',s.empEmail1)";
		sub = "replace(" + sub + ",'[EXEEMAIL2]',s.empEmail2)";
		sub = "replace(" + sub + ",'[EXEMOBILE1]',s.empMobile1)";
		sub = "replace(" + sub + ",'[EXEMOBILE2]',s.empMobile2)";
		sub = "replace(" + sub + ",'[EXEPHONE1]',s.empPhone1)";
		sub = "replace(" + sub + ",'[FOLLOWUPDESC]',coalesce(tickettransFollowup, ''))";

		emailmsg = "replace('" + emailmsg + "','[TICKETID]',ticketId)";
		emailmsg = "replace(" + emailmsg + ",'[TICKETSUBJECT]',ticketSubject)";
		emailmsg = "replace(" + emailmsg + ",'[TICKETSTATUS]',ticketstatusName)";
		emailmsg = "replace(" + emailmsg + ",'[TICKETTIME]',DATE_FORMAT(ticketReportTime,'%d/%m/%Y %H:%i'))";
		emailmsg = "replace(" + emailmsg + ",'[DUETIME]',DATE_FORMAT(ticketDueTime,'%d/%m/%Y %H:%i'))";
		emailmsg = "replace(" + emailmsg + ",'[QUEUE]',ticketqueueName)";
		emailmsg = "replace(" + emailmsg + ",'[PRIORITY]',priorityticketName)";
		emailmsg = "replace(" + emailmsg + ",'[TICKETOWNER]',o.empName)";
		emailmsg = "replace(" + emailmsg + ",'[EXENAME]',s.empName)";
		emailmsg = "replace(" + emailmsg + ",'[EXEJOBTITLE]',jobtitleDesc)";
		emailmsg = "replace(" + emailmsg + ",'[EXEEMAIL1]',s.empEmail1)";
		emailmsg = "replace(" + emailmsg + ",'[EXEEMAIL2]',s.empEmail2)";
		emailmsg = "replace(" + emailmsg + ",'[EXEMOBILE1]',s.empMobile1)";
		emailmsg = "replace(" + emailmsg + ",'[EXEMOBILE2]',s.empMobile2)";
		emailmsg = "replace(" + emailmsg + ",'[EXEPHONE1]',s.empPhone1)";
		emailmsg = "replace(" + emailmsg + ",'[FOLLOWUPDESC]',coalesce(tickettransFollowup, ''))";

	}

	protected void SendSMSToExecutive(String empMobile) throws SQLException {
		String smsmsg = (configTicketNewSmsExeFormat);

		smsmsg = "replace('" + smsmsg + "','[TICKETID]',ticketId)";
		smsmsg = "replace(" + smsmsg + ",'[TICKETSUBJECT]',ticketSubject)";
		smsmsg = "replace(" + smsmsg + ",'[TICKETSTATUS]',ticketstatusName)";
		smsmsg = "replace(" + smsmsg + ",'[TICKETTIME]',DATE_FORMAT(ticketReportTime,'%d/%m/%Y %H:%i'))";
		smsmsg = "replace(" + smsmsg + ",'[DUETIME]',DATE_FORMAT(ticketDueTime,'%d/%m/%Y %H:%i'))";
		smsmsg = "replace(" + smsmsg + ",'[QUEUE]',ticketqueueName)";
		smsmsg = "replace(" + smsmsg + ",'[PRIORITY]',priorityticketName)";
		smsmsg = "replace(" + smsmsg + ",'[TICKETOWNER]',o.empName)";
		smsmsg = "replace(" + smsmsg + ",'[EXENAME]',s.empName)";
		smsmsg = "replace(" + smsmsg + ",'[EXEJOBTITLE]',jobtitleDesc)";
		smsmsg = "replace(" + smsmsg + ",'[EXEEMAIL1]',s.empEmail1)";
		smsmsg = "replace(" + smsmsg + ",'[EXEEMAIL2]',s.empEmail2)";
		smsmsg = "replace(" + smsmsg + ",'[EXEMOBILE1]',s.empMobile1)";
		smsmsg = "replace(" + smsmsg + ",'[EXEMOBILE2]',s.empMobile2)";
		smsmsg = "replace(" + smsmsg + ",'[EXEPHONE1]',s.empPhone1)";
		smsmsg = "replace(" + smsmsg + ",'[FOLLOWUPDESC]',coalesce(tickettransFollowup, ''))";

	}

	public void PopulateContactDetails() throws SQLException {
		List<Object[]> obj = customerFilterImpl.findByContactDetails(Integer.parseInt(ticketJcId), Integer.parseInt(ticketContactId));
		for (Object[] results : obj) {
			ticketContactId = PadQuotes(results[0].toString());
			ticketCustomerId = PadQuotes(results[1].toString());
			customerName = PadQuotes(results[2].toString());
			customerBranchId = PadQuotes(results[3].toString());
			contactEmail1 = PadQuotes(results[4].toString());
			contactEmail2 = PadQuotes(results[5].toString());
			contactMobile1 = PadQuotes(results[6].toString());
			contactMobile2 = PadQuotes(results[7].toString());
			contactName = PadQuotes(results[8].toString());
		}
	}
	public Map<String, String> searchContact(String input, HttpSession session) throws JSONException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, String>();
		txtSearch = "";
		sortField = "";
		sortDirection = "";
		length = 0;
		pageIndex = 0;
		String active = "";
		pageSize = 10;
		int count = 0;
		configCustomerName = PadQuotes(getSession("configCustomerName", session));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		if (!inputObj.isNull("sortField")) {
			sortField = PadQuotes((inputObj.getString("sortField")));
		}
		if (!inputObj.isNull("pageSize")) {
			pageSize = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageSize")))));
		}
		if (!inputObj.isNull("pageIndex")) {
			pageIndex = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
		}
		if (!inputObj.isNull("sortDirection")) {
			sortDirection = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
		}
		if (pageSize == 0) {
			pageSize = 10;
		}
		pageIndex = pageIndex + 1;
		if (sortDirection.equals("")) {
			sortDirection = "ASC";
		}
		if (sortField.equals("")) {
			sortField = "contactId";
		}
		strSearch = " ORDER BY a." + sortField + " " + sortDirection;
		if (!inputObj.isNull("txtSearch")) {
			txtSearch = PadQuotes(inputObj.getString("txtSearch"));
			if (txtSearch.contains("-")) {
				txtSearch = txtSearch.replace("-", "");
			}
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			// Start Header Data
			listHeader.add(produceHeaderData("#", "Sl.no", "center"));
			listHeader.add(produceHeaderData("Customer", "axelaCustomers.customerId", "left"));
			listHeader.add(produceHeaderData("Contact Person", "contactId", "left"));
			listHeader.add(produceHeaderData("Communication", "Communication", "left"));
			listHeader.add(produceHeaderData("Address", "Address", "left"));
			listHeader.add(produceHeaderData("Open Status", "Open Status", "left"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			// End Body Align

			StringBuilder dataString = null;
			Map<String, String> mapNavi = pageNavi(length, input, String.valueOf(pageSize));
			output.put("meta", mapNavi);
			List<AxelaCustomerContact> axelaCustomerContact = customerFilterImpl.findByTxtSearch(txtSearch, strSearch, pageIndex, pageSize);
			for (AxelaCustomerContact obj : axelaCustomerContact) {
				ArrayList<String> param = new ArrayList<String>();
				ArrayList<String> actionParam = new ArrayList<String>();
				ArrayList<String> actionParam1 = new ArrayList<String>();
				ArrayList<String> actionParam2 = new ArrayList<String>();
				ArrayList<String> actionParam3 = new ArrayList<String>();
				HashMap<String, List<HashMap>> mapData = new HashMap<String, List<HashMap>>();
				HashMap<String, List<HashMap>> mapAction = new HashMap<String, List<HashMap>>();
				HashMap<String, List<String>> mapBodyData = new HashMap<String, List<String>>();
				List<HashMap> listData = new ArrayList<HashMap>();

				count++;

				// Start Body data

				if (obj.getContactActive().equals("0")) {
					active = " <font color=red><b>[Inactive]</b></font>";
				} else {
					active = "";
				}
				actionParam.add("addticket");
				actionParam.add(PadQuotes(String.valueOf(obj.getContactId())));
				actionParam.add(PadQuotes("yes"));
				actionParam1.add("listticket");
				actionParam1.add(PadQuotes("yes"));
				actionParam1.add(PadQuotes("yes"));
				actionParam1.add(PadQuotes("ticket"));
				actionParam2.add("addcontract");
				actionParam2.add(PadQuotes("yes"));
				actionParam2.add(PadQuotes(String.valueOf(obj.getContactId())));
				actionParam3.add("listcontract");
				actionParam3.add(PadQuotes("yes"));
				// End Body data
				mapData.put("td", listData);
				mapAction.put("td", produceActionDataForTextSearch(actionParam, actionParam1, actionParam2, actionParam3));
				listAction.add(mapAction);
				listBody.add(mapData);
			}
			output.put("meta", mapNavi);
			output.put("thead", listHeader);
			output.put("tdalign", listBodyAlign);
			output.put("tbody", listBody);
			output.put("action", listAction);
			if (AppRun().equals("0")) {
			}
		}
		return output;
	}

	private ArrayList<HashMap> produceActionDataForTextSearch(ArrayList<String> Param, ArrayList<String> Param1, ArrayList<String> Param2, ArrayList<String> Param3) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Add Ticket");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "List Ticket");
		mapBodyData.put("param", Param1);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Add Contract");
		mapBodyData.put("param", Param2);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "List Contract");
		mapBodyData.put("param", Param3);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart(HttpSession session) {
		configCustomerName = getSession("configCustomerName", session);
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "ticket.*"));
		list.add(buildSmartArr("Ticket ID", "numeric", "ticket.ticketId"));
		list.add(buildSmartArr("Contract ID", "numeric", "ticket.ticketContactId"));
		list.add(buildSmartArr("Asset ID", "numeric", "ticket.ticketAssetId"));
		list.add(buildSmartArr("Asset Serial No.", "text", "ticket.ticketAssetId"));
		list.add(buildSmartArr("Source", "text", "ticket.ticketTicketsourceId"));
		list.add(buildSmartArr("Status", "text", "ticket.ticketstatusName"));
		list.add(buildSmartArr(configCustomerName + " ID", "numeric", "ticket.axelaCustomer.customerId"));
		list.add(buildSmartArr("Contact ID", "numeric", "ticket.axelaCustomerContact.contactId"));
		list.add(buildSmartArr("JC ID", "numeric", "ticket.ticketJcId"));
		list.add(buildSmartArr(configCustomerName + " Name", "text", "ticket.axelaCustomer.customerName"));
		list.add(buildSmartArr("Contact Name", "text",
				"CONCAT(ticket.axelaCustomerContact.axelaTitle.titleDesc, ' ', ticket.axelaCustomerContact.contactFname, ' ', ticket.axelaCustomerContact.contactLname)"));
		list.add(buildSmartArr("Mobile", "text", "CONCAT(REPLACE(ticket.axelaCustomerContact.contactMobile1,'-',''),REPLACE(ticket.axelaCustomerContact.contactMobile2,'-',''))"));
		list.add(buildSmartArr("Phone", "text", "CONCAT(REPLACE(ticket.axelaCustomerContact.contactPhone1,'-',''),REPLACE(ticket.axelaCustomerContact.contactPhone2,'-','')"));
		list.add(buildSmartArr("Queue", "text", "ticket.axelaHelpDeskTicketQueue.ticketqueueName"));
		list.add(buildSmartArr("Category", "text", "ticket.axelaHelpDeskTicketCat.ticketcatName"));
		list.add(buildSmartArr("Type", "text", "ticket.axelaHelpDeskTicketType.tickettypeName"));
		list.add(buildSmartArr("Priority", "text", "ticket.axelaHelpDeskTicketPriority.priorityticketName"));
		list.add(buildSmartArr("Executive", "text", "ticket.axelaEmp.empName"));
		list.add(buildSmartArr("Subject", "text", "ticket.ticketSubject"));
		list.add(buildSmartArr("Description", "text", "ticket.ticketDesc"));
		list.add(buildSmartArr("Notes", "text", "ticket.ticketNotes"));
		// list.add(buildSmartArr("Entry By", "text", "ticket.ticketEntryId"));
		list.add(buildSmartArr("Entry Date", "date", "ticket.ticketEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "ticket.ticketModifiedId"));
		list.add(buildSmartArr("Modified Date", "Date", "ticket.ticketModifiedDate"));
		// list.add(buildSmartArr("Custom Fields", "text", "ticket_id"));
		output.put("drSmart", list.toArray());
		return output;
	}

}
