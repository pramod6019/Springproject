package axela.helpdesk.service;

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
import axela.customer.repository.CustomerContactReposiitory;
import axela.helpdesk.model.AxelaHelpDeskTicket;
import axela.helpdesk.model.AxelaHelpDeskTicketHistory;
import axela.helpdesk.model.AxelaHelpDeskTicketTran;
import axela.helpdesk.repository.AxelaTicketQueueRepository;
import axela.helpdesk.repository.HelpDeskTicketCatRepository;
import axela.helpdesk.repository.HelpDeskTicketDocRepository;
import axela.helpdesk.repository.HelpDeskTicketPriorityRepository;
import axela.helpdesk.repository.HelpDeskTicketQueueRepo;
import axela.helpdesk.repository.HelpDeskTicketSourceRepository;
import axela.helpdesk.repository.HelpDeskTicketStatusRepository;
import axela.helpdesk.repository.HelpDeskTicketTransRepo;
import axela.helpdesk.repository.HelpDeskTicketTypeRepository;
import axela.helpdesk.repository.HelpDeskTickethistoryRepository;
import axela.helpdesk.repository.TicketRepository;
import axela.helpdesk.repository.TicketRepositoryImpl;
import axela.helpdesk.repository.TicketTransFilterImpl;
import axela.portal.repository.ConfigFilterImpl;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PmRepository;
import axela.service.repository.ServiceContractAssetRepository;
import axela.service.repository.ServiceContractRepository;

@Service
public class TicketDashService extends Connect {
	JSONObject inputObj = null;
	public String requestType = "";

	@Autowired
	public TicketRepositoryImpl ticketRepositoryImpl;

	@Autowired
	public TicketRepository ticketRepository;

	@Autowired
	public TicketTransFilterImpl ticketTransFilterImpl;

	@Autowired
	private ConfigFilterImpl configFilterImpl;

	@Autowired
	public HelpDeskTickethistoryRepository serviceTickethistoryRepository;

	@Autowired
	private AxelaTicketQueueRepository axelaTicketQueueRepository;

	@Autowired
	private HelpDeskTicketSourceRepository serviceTicketSourceRepository;

	@Autowired
	private HelpDeskTicketStatusRepository helpDeskTicketStatusRepository;

	@Autowired
	private HelpDeskTicketPriorityRepository serviceTicketPriorityRepository;

	@Autowired
	public EmpRepository axelaEmpRepository;

	@Autowired
	private HelpDeskTicketQueueRepo serviceTicketQueueRepo;

	@Autowired
	private HelpDeskTicketTypeRepository serviceTicketTypeRepository;

	@Autowired
	private HelpDeskTicketCatRepository serviceTicketCatRepository;

	@Autowired
	private ServiceContractRepository serviceContractRepository;

	@Autowired
	private ServiceContractAssetRepository serviceContractAssetRepository;

	@Autowired
	private CustomerContactReposiitory customerContactReposiitory;

	@Autowired
	private PmRepository pmRepository;

	@Autowired
	public HelpDeskTicketTransRepo helpdeskTicketTransRepo;

	@Autowired
	public HelpDeskTickethistoryRepository helpDeskTickethistoryRepository;

	@Autowired
	public HelpDeskTicketDocRepository helpDeskTicketDocRepository;

	public int ticketId = 0;
	public int historyTicketId = 0;
	public String exeAccess = "";
	public String branchAccess = "";
	public String empFormattime = "";
	public String empFormatdate = "";
	public String ticketRead = "0";
	public int empId = 0;
	public String ticketEmpId = "0";
	public String empEmailFormail = "";
	public String ticketTrigger = "";
	public String ticketTicketqueueId = "0";
	public String ticketPriorityticketId = "0";
	public String ticketTicketsourceId = "0";
	public String ticketPmId = "0";
	public String ticketTickettypeId = "0";
	public String ticketTicketcatId = "0";
	public String ticketDesc = "";
	public String ticketRefno = "";
	public String ticketSubject = "";
	public String ticketParentId = "0";
	public int ticketEntryId = 1;
	public String configServiceTicketRefno = "";
	public String configServiceTicketCat = "";
	public String configServiceTicketType = "";
	public String configServiceContract = "";
	public String configTicketFollowupEmailEnable = "";
	public int empRoleId = 0;
	public String compModulePm = "";
	public String configTicketFollowupEmailSub = "";
	public String configTicketFollowupEmailExeSub = "";
	public String configTicketFollowupEmailFormat = "";
	public String configTicketFollowupEmailExeFormat = "";
	public String configTicketFollowupSmsFormat = "";
	public String configTicketFollowupSmsEnable = "";
	public String configAdminEmail = "";
	public String configTicketFollowupSmsExeFormat = "";
	public String configEmailEnable = "";
	public String configSmsEnable = "";
	public String compSmsEnable = "";
	public String compEmailEnable = "";
	public String entryempEmail = "";
	public String empEmail = "";
	public String name = "";
	public String value = "";
	public String msg = "";
	public String StrSql = "";
	public String compId = "";
	public String ticketqueueTrigger1Hrs = "";
	public String ticketqueueTrigger2Hrs = "";
	public String ticketqueueTrigger3Hrs = "";
	public String ticketqueueTrigger4Hrs = "";
	public String ticketqueueTrigger5Hrs = "";
	public String customerBranchId = "";
	public String ticketTrigger1Hrs = "0";
	public String ticketTrigger2Hrs = "0";
	public String ticketTrigger3Hrs = "0";
	public String ticketTrigger4Hrs = "0";
	public String ticketTrigger5Hrs = "0";
	public String ticketDueTime = "";
	public String configTicketNewEmailEnable = "0";
	public String configTicketNewEmailExeFormat = "";
	public String ticketReportTime = "";
	public String status = "";
	public String comment = "";
	public String configTicketClosedEmailEnable = "";
	public String configTicketClosedEmailSub = "";
	public String configTicketClosedEmailFormat = "";
	public String configTicketClosedEmailExeSub = "";
	public String configTicketClosedEmailExeFormat = "";
	public String configTicketClosedSmsEnable = "";
	public String configTicketClosedSmsFormat = "";
	public String configTicketClosedSmsExeFormat = "";
	public String contactEmail1 = "";
	public String contactEmail2 = "";
	public String sendContactEmail = "";
	public String contactMobile1 = "";
	public String contactMobile2 = "";
	public String empMobile1 = "";
	public String empMobile2 = "";
	public String contactName = "";
	public String contactAddress = "";
	public String contactId = "";
	public String contract = "";
	public String deletecontract = "";
	public String contractId = "0";
	public String tab = "0";
	public String asset = "";
	public String assetcontract = "";
	public String deleteasset = "";
	public String assetId = "";
	public HashMap output = null;
	public String empFormatDate = "";
	public String tickettransFollowup = "";
	public String tickettransPrivate = "";
	public String tickettransNextfollowupTime = "";
	public Map ticketServiceUpdate(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("inputObj==========ticketDashService==========" + inputObj.toString(1));
		}
		output = new HashMap();
		if (!inputObj.isNull("tab")) {
			tab = inputObj.getString("tab");
		}
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}

		switch (tab) {
			case "1" : // ticket Details
				switch (requestType) {
					case "populateData" :
						populateTicketDetails(input);
						populateTicketData(input, session, response);
						break;

					case "update" :
						dashFieldUpdate(input, request, response, session);
						break;
				}
				break;

			case "2" :// ticket FollowUp.
				switch (requestType) {
					case "populateData" :
						if (!inputObj.isNull("ticketId")) {
							ticketId = Integer.parseInt(inputObj.getString("ticketId"));
						}
						populateTicketDetails(input);
						if (ticketId != 0) {
							ListFollowupData(ticketId, session, response);
						}
						break;
					case "add" :
						ticketFollowUpAdd(input, session);
						break;
				}
				break;

			case "3" :// ticket Client.
				switch (requestType) {
					case "populateData" :
						if (!inputObj.isNull("ticketId")) {
							ticketId = Integer.parseInt(inputObj.getString("ticketId"));
						}
						if (ticketId != 0) {
							populateCustomer(ticketId);
							ContactInfo(ticketId);
						}
						break;
				}
				break;

			case "4" :// ticket documents.
				switch (requestType) {
					case "populateData" :
						if (!inputObj.isNull("ticketId")) {
							ticketId = Integer.parseInt(inputObj.getString("ticketId"));
						}
						if (ticketId != 0) {
							populateJcDocs(session);
						}
						break;
				}
				break;
			case "5" :// ticket History.
				switch (requestType) {
					case "populateData" :
						if (!inputObj.isNull("ticketId")) {
							historyTicketId = Integer.parseInt(inputObj.getString("ticketId"));
						}
						if (historyTicketId != 0) {
							populateHistory(historyTicketId);
						}
						break;
				}
				break;
			case "6" :// ticket Summary.
				switch (requestType) {
					case "populateData" :
						if (!inputObj.isNull("ticketId")) {
							ticketId = Integer.parseInt(inputObj.getString("ticketId"));
						}
						if (ticketId != 0) {
							populateSummary(ticketId);
						}
						break;
				}
				break;
		}

		// }
		return output;
	}

	protected void validateFollowUp() {
		msg = "";
		if (tickettransFollowup.equals("")) {
			msg = msg + "<br>Enter Description!";
		}
		if (tickettransNextfollowupTime.equals("")) {
			msg = msg + "<br>Next Follow-up Time!";
		}
		// else {
		// if (!isValidDateFormatLong(tickettransNextfollowupTime)) {
		// msg = msg + "<br>Enter Valid Next Follow-up Time!";
		// }
		// }

	}
	private void ticketFollowUpAdd(String input, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		empId = 0;
		tickettransFollowup = "";
		tickettransNextfollowupTime = "";
		tickettransPrivate = "";

		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		if (empId != 0) {
			if (AppRun().equals("0")) {
				SOP("opprFollowUpAdd=================" + inputObj.toString(2));
			}
			int followupId = 0;
			if (!inputObj.isNull("ticketId")) {
				ticketId = Integer.parseInt(CNumeric(inputObj.getString("ticketId")));
			}
			if (ticketId != 0) {
				if (!inputObj.isNull("tickettransFollowup")) {
					tickettransFollowup = PadQuotes(inputObj.getString("tickettransFollowup"));
				}
				if (!inputObj.isNull("tickettransNextfollowupTime")) {
					tickettransNextfollowupTime = PadQuotes(inputObj.getString("tickettransNextfollowupTime"));
				}
				if (!inputObj.isNull("tickettransPrivate")) {
					String tickettransPrivate1;
					tickettransPrivate1 = String.valueOf(inputObj.get("tickettransPrivate"));
					if (tickettransPrivate1.equals("true")) {
						tickettransPrivate = "1";
					} else {
						tickettransPrivate = "0";
					}
				}
				validateFollowUp();
				if (msg.equals("")) {
					AxelaHelpDeskTicketTran axelaSalesOpprFollowup = new AxelaHelpDeskTicketTran();
					axelaSalesOpprFollowup.setTickettransTicketId(ticketId);
					axelaSalesOpprFollowup.setTickettransFollowup(tickettransFollowup);
					axelaSalesOpprFollowup.setTickettransNextfollowupTime(stringToDate(tickettransNextfollowupTime));
					axelaSalesOpprFollowup.setTickettransContactEntryDate(stringToDate(""));
					axelaSalesOpprFollowup.setTickettransPrivate(tickettransPrivate);
					axelaSalesOpprFollowup.setTickettransContactEntryId(1);
					axelaSalesOpprFollowup.setTickettransEntryId(empId);
					axelaSalesOpprFollowup.setTickettransEntryDate(stringToDate(toLongDate(kknow())));
					axelaSalesOpprFollowup.setTickettransModifiedId(0);
					axelaSalesOpprFollowup.setTickettransModifiedDate(stringToDate(""));
					followupId = helpdeskTicketTransRepo.save(axelaSalesOpprFollowup).getTickettransId();
					if (followupId != 0) {
						output.put("successmsg", "FollowUp Added Successfully!");
						output.put("followupId", followupId);
					}
				}
				else {
					output.put("errormsg", msg);
				}
			}
		}
	}

	public void populateTicketDetails(String input) throws JSONException, ParseException {
		SOP("inside normal dash");
		inputObj = new JSONObject(input);
		Map map = new HashMap();
		if (!inputObj.isNull("ticketId")) {
			ticketId = Integer.parseInt(PadQuotes(CNumeric(inputObj.getString("ticketId"))));
		}
		List list = new ArrayList();
		AxelaHelpDeskTicket ticket = new AxelaHelpDeskTicket();
		ticket = ticketRepositoryImpl.findTicket(ticketId);
		map.put("ticketId", ticket.getTicketId() + "");
		map.put("ticketEntryDate", strToShortDate(ticket.getTicketEntryDate()));
		list.add(map);
		output.put("populateDetail", list);

	}

	public Map<String, String> populateTicketData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		SOP("inputObj==populatejcData====" + inputObj);
		// AxelaSalesOppr axelaSalesOppr = null;
		Map map = new LinkedHashMap<String, String>();
		ArrayList list = new ArrayList();

		if (!inputObj.isNull("ticketId")) {
			ticketId = Integer.parseInt(PadQuotes(CNumeric(inputObj.getString("ticketId"))));
		}
		if (ticketId != 0) {
			AxelaHelpDeskTicket axelaHelpDeskTicket = ticketRepositoryImpl.findOneForDash(ticketId, branchAccess, exeAccess);
			if (axelaHelpDeskTicket != null) {
				map.put("ticketId", String.valueOf(axelaHelpDeskTicket.getTicketId()));
				map.put("customerBranchId", String.valueOf(axelaHelpDeskTicket.getCustomerBranchId()));
				map.put("ticketContactId", String.valueOf(axelaHelpDeskTicket.getTicketContactId()));
				map.put("ticketCustomerId", String.valueOf(axelaHelpDeskTicket.getTicketCustomerId()));
				map.put("ticketJcId", String.valueOf(axelaHelpDeskTicket.getTicketJcId()));
				map.put("ticketParentId", String.valueOf(axelaHelpDeskTicket.getTicketParentId()));
				map.put("ticketTicketstatusId", String.valueOf(axelaHelpDeskTicket.getTicketTicketstatusId()));
				map.put("ticketTicketcatId", String.valueOf(axelaHelpDeskTicket.getTicketTicketcatId()));
				map.put("ticketTickettypeId", String.valueOf(axelaHelpDeskTicket.getTicketTickettypeId()));
				map.put("ticketPmId", String.valueOf(axelaHelpDeskTicket.getTicketPmId()));
				map.put("ticketContractId", String.valueOf(axelaHelpDeskTicket.getContractTitle()));
				map.put("contractTitle", String.valueOf(axelaHelpDeskTicket.getTicketContractId()));
				// axelaHelpDeskTicket.getContractTitle() + " (" + formatDate(axelaHelpDeskTicket.getContractStartDate(), empFormatdate) + "-"
				// + formatDate(axelaHelpDeskTicket.getContractEndDate(), empFormatdate
				// + ")"));
				map.put("ticketAssetId ", String.valueOf(axelaHelpDeskTicket.getTicketAssetId()));
				map.put("assetName", axelaHelpDeskTicket.getAssetName() + " (" + axelaHelpDeskTicket.getTicketAssetId() + ")");
				map.put("ticketSubject", axelaHelpDeskTicket.getTicketSubject());
				map.put("ticketDesc", axelaHelpDeskTicket.getTicketDesc());
				map.put("ticketClosedTime", strToLongDate(axelaHelpDeskTicket.getTicketClosedTime()));
				// map.put("closedDate", formatDate(axelaHelpDeskTicket.getTicketClosedTime(), empFormatdate));
				map.put("ticketClosedComments", axelaHelpDeskTicket.getTicketClosedComments());
				map.put("ticketEmpId", String.valueOf(axelaHelpDeskTicket.getTicketEmpId()));
				ticketEmpId = CNumeric(PadQuotes(axelaHelpDeskTicket.getTicketEmpId() + ""));
				map.put("ticketRead", axelaHelpDeskTicket.getTicketRead());
				ticketRead = axelaHelpDeskTicket.getTicketRead();
				map.put("ticketRefno", axelaHelpDeskTicket.getTicketRefno());
				map.put("ticketJcpsfId", CNumeric(PadQuotes(String.valueOf("ticketJcpsfId"))));
				if (ticketRead.equals("0") && empId == Integer.parseInt(ticketEmpId)) {
					AxelaHelpDeskTicket serviceTicket = new AxelaHelpDeskTicket();
					serviceTicket = ticketRepository.findOne(ticketId);
					serviceTicket.setTicketRead("1");
					ticketRepository.save(serviceTicket);
				}
				map.put("ticketTicketsourceId", String.valueOf(axelaHelpDeskTicket.getTicketTicketsourceId()));
				map.put("ticketReportTime", strToLongDate(axelaHelpDeskTicket.getTicketReportTime()));
				// map.put("reporttime", formatDate(axelaHelpDeskTicket.getTicketReportTime(), empFormatdate + " " + empFormattime));
				map.put("ticketTicketqueueId", String.valueOf(axelaHelpDeskTicket.getTicketTicketqueueId()));
				map.put("ticketPriorityticketId", String.valueOf(axelaHelpDeskTicket.getTicketPriorityticketId()));
				map.put("ticketDueTime", strToLongDate(axelaHelpDeskTicket.getTicketDueTime()));
				map.put("duedate", strToLongDate(axelaHelpDeskTicket.getTicketDueTime()));
				// map.put("ticketEntryId", axelaHelpDeskTicket.getTicketEntryId() + "");
				map.put("ticketEntryBy", PadQuotes(axelaEmpRepository.findEmpName(axelaHelpDeskTicket.getTicketEntryId())));
				map.put("ticketEntryDate", strToLongDate(axelaHelpDeskTicket.getTicketEntryDate()));
				map.put("tickettransContactEntryId", PadQuotes(axelaHelpDeskTicket.getTickettransContactEntryId()));
				map.put("ticketReopenedEmpId", String.valueOf(axelaHelpDeskTicket.getTicketReopenedEmpId()));
				map.put("empName", axelaHelpDeskTicket.getEmpName());
				map.put("empEmail1", axelaHelpDeskTicket.getEmpEmail1());
				map.put("empEmail2", axelaHelpDeskTicket.getEmpEmail2());
				if (!axelaHelpDeskTicket.getEmpEmail2().equals("")) {
					empEmailFormail = axelaHelpDeskTicket.getEmpEmail1() + "," + axelaHelpDeskTicket.getEmpEmail2();
				} else {
					empEmailFormail = axelaHelpDeskTicket.getEmpEmail1();
				}
				map.put("empMobile1", axelaHelpDeskTicket.getEmpMobile1());
				map.put("empMobile2", axelaHelpDeskTicket.getEmpMobile2());
				map.put("contactEmail1", axelaHelpDeskTicket.getContactEmail1());
				map.put("contactEmail2", axelaHelpDeskTicket.getContactEmail2());
				map.put("contactMobile1", axelaHelpDeskTicket.getContactMobile1());
				map.put("contactMobile2", axelaHelpDeskTicket.getContactMobile2());
				map.put("contactName", axelaHelpDeskTicket.getContactName());
				map.put("contactId", CNumeric(PadQuotes(axelaHelpDeskTicket.getContactId())));
				map.put("jcpsfFollowupTime", strToShortDate(axelaHelpDeskTicket.getJcpsfFollowupTime()));
				map.put("psfempName", axelaHelpDeskTicket.getPsfempName());
				map.put("psfdaysDaycount", axelaHelpDeskTicket.getPsfdaysDaycount());
				map.put("ticketJcSerialno", axelaHelpDeskTicket.getTicketJcSerialno());
				list.add(map);
				output.put("populateTicketData", list);
			} else {
				output.put("msg", "Invalid Ticket ID");
			}
		} else {
			output.put("msg", "Invalid Ticket ID");
			response.setStatus(400);
		}
		return output;

	}
	public void dashFieldUpdate(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		AxelaHelpDeskTicket axelaserviceticket = null;
		empFormatDate = PadQuotes(getSession("formattimeName", session));
		// empId = Integer.parseInt(getSession("empId", session));
		String name = "";
		String value = "";
		TicketRepositoryImpl ticketdash = null;
		output = new HashMap<String, String>();
		if (!inputObj.isNull("ticketId")) {
			ticketId = Integer.parseInt(inputObj.getString("ticketId"));
		}
		SOP("ticketId========" + ticketId);
		if (!inputObj.isNull("name")) {
			name = PadQuotes(inputObj.getString("name"));
		}
		SOP("name========" + name);
		if (!inputObj.isNull("value")) {
			value = PadQuotes(inputObj.getString("value"));
		}
		SOP("value========" + value);

		if (ticketId != 0) {
			axelaserviceticket = ticketRepository.findOne(ticketId);
			if (!name.equals("") && !value.equals("")) {
				AxelaHelpDeskTicketHistory axelaservicetickethistory = new AxelaHelpDeskTicketHistory();
				axelaservicetickethistory.setHistoryTicketId(BigInteger.valueOf(ticketId));
				axelaservicetickethistory.setHistoryEmpId(empId);
				axelaservicetickethistory.setHistoryDatetime(stringToDate(toLongDate(kknow())));
				if (name.equals("ticketSubject")) {

					// if (value.length() < 5) {
					// msg = "Subject Should be Atleast five Digits!";
					// } else {
					// String historyOldvalue = PadQuotes(ticketRepository.findBySubject(ticketId));
					// ticketRepository.updateByTicketSub(ticketId, value);
					axelaservicetickethistory.setHistoryActiontype("TICKET SUBJECT");
					axelaservicetickethistory.setHistoryOldvalue(axelaserviceticket.getTicketSubject());
					axelaservicetickethistory.setHistoryNewvalue(value);
					axelaserviceticket.setTicketSubject(value);
					msg = "Subject Updated!";

					// }
				}

				if (name.equals("ticketDesc")) {
					// if (value.length() < 5) {
					// msg = "Description Should be Atleast five Digits!";
					// } else {

					axelaservicetickethistory.setHistoryActiontype("TICKET DESCRIPTION");
					axelaservicetickethistory.setHistoryOldvalue(axelaserviceticket.getTicketDesc());
					axelaservicetickethistory.setHistoryNewvalue(value);
					axelaserviceticket.setTicketDesc(value);
					msg = "Description Updated!";
					// }
				}

				if (name.equals("ticketClosedComments")) {
					// if (value.length() < 5) {
					// msg = "Description Should be Atleast five Digits!";
					// } else {

					axelaservicetickethistory.setHistoryActiontype("TICKET CLOSED COMMENTS");
					axelaservicetickethistory.setHistoryOldvalue(axelaserviceticket.getTicketClosedComments());
					axelaservicetickethistory.setHistoryNewvalue(value);
					axelaserviceticket.setTicketClosedComments(value);
					msg = "Closed Comments Updated!";
					// }
				}

				if (name.equals("ticketReportTime")) {
					// if (!isValidDateFormat(value, empFormatDate)) {
					// msg = "Enter Valid Close Date!";
					// }
					// if (msg.equals("")) {
					axelaservicetickethistory.setHistoryActiontype("TICKET REPORT TIME");
					axelaservicetickethistory.setHistoryOldvalue(strToLongDate(axelaserviceticket.getTicketReportTime()));
					axelaservicetickethistory.setHistoryNewvalue(value);
					axelaserviceticket.setTicketReportTime(stringToDate(value));
					msg = "Report Time Updated!";
					// }
				}

				if (name.equals("ticketTicketsourceId")) {
					axelaservicetickethistory.setHistoryActiontype("TICKET SOURCE");
					axelaservicetickethistory.setHistoryOldvalue(String.valueOf(axelaserviceticket.getTicketTicketsourceId()));
					axelaservicetickethistory.setHistoryNewvalue(value);
					axelaserviceticket.setTicketTicketsourceId(Integer.parseInt(value));
					msg = "Source Updated!";
				}

				if (name.equals("ticketPriorityticketId")) {

					axelaservicetickethistory.setHistoryActiontype("TICKET PRIORITY");
					axelaservicetickethistory.setHistoryOldvalue(String.valueOf(axelaserviceticket.getTicketPriorityticketId()));
					axelaservicetickethistory.setHistoryNewvalue(value);
					axelaserviceticket.setTicketPriorityticketId(Integer.parseInt(value));
					msg = "Priority Updated!";
				}

				if (name.equals("ticketTicketqueueId")) {

					axelaservicetickethistory.setHistoryActiontype("TICKET QUEUES");
					axelaservicetickethistory.setHistoryOldvalue(String.valueOf(axelaserviceticket.getTicketTicketqueueId()));
					axelaservicetickethistory.setHistoryNewvalue(value);
					axelaserviceticket.setTicketTicketqueueId(Integer.parseInt(value));
					msg = "Queue Updated!";

				}

				if (name.equals("ticketRefno")) {
					// value = value.replaceAll("nbsp", "&");
					// if (!isNumeric(value)) {
					// msg = "<font color=\"red\">Enter Numeric Reference No.!";
					// } else if (isNumeric(value) && value.length() < 2) {
					// msg = "<font color=\"red\">Reference No. should be atleast Two Digits!";
					// } else {
					// // StrSql = PadQuotes(ticketRepository.findByRefNo(ticketId, value));
					// if (!StrSql.equals("")) {
					// msg = "<font color=\"red\">Similar Ref No. found!";
					//
					axelaservicetickethistory.setHistoryActiontype("TICKET REFNO");
					axelaservicetickethistory.setHistoryOldvalue(axelaserviceticket.getTicketRefno());
					axelaservicetickethistory.setHistoryNewvalue(value);
					axelaserviceticket.setTicketRefno(value);
					msg = "Ref. No. Updated!";
				}
				//
				// if (name.equals("ticketPriorityticketId")) {
				// if (!value.equals("0") && !value.equals("")) {
				// // String historyOldvalue = PadQuotes(ticketRepository.findByTicketPriorityId(ticketId));
				// // if (historyOldvalue == null) {
				// // historyOldvalue = "";
				// // }
				// // ticketRepository.updateByPriority(ticketId, Integer.parseInt(value));
				// axelaservicetickethistory.setHistoryTicketId(BigInteger.valueOf(ticketId));
				// axelaservicetickethistory.setHistoryEmpId(empId);
				// axelaservicetickethistory.setHistoryActiontype("TICKET PRIORITY");
				// // axelaServiceTicketHistory.setHistoryOldvalue(historyOldvalue);
				// axelaservicetickethistory.setHistoryNewvalue(value);
				// axelaserviceticket.setTicketPriorityticketId(Integer.parseInt(value));
				// msg = "Ticket Priority updated!";
				// }
				//
				// }
				//
				// if (name.equals("ticketEmpId")) {
				// if (!value.equals("0") && !value.equals("")) {
				// // String ticketClose = CNumeric(PadQuotes(axelaEmpRepository.findByEmpTicket(empId)));
				// // if (ticketClose.equals("0")) {
				// // msg = "Update Permission Denied!";
				// // }
				// // String historyOldvalue = PadQuotes(ticketRepository.findByEmpId(ticketId));
				// // if (!historyOldvalue.equals("")) {
				// // historyOldvalue = ticketRepository.findByTicketEmpId(ticketId);
				// // } else {
				// // historyOldvalue = "No Executives Found";
				// // }
				// // ticketRepository.updateByTicketEmp(ticketId, value);
				// // PopulateConfigDetails();
				// if (compEmailEnable.equals("1")
				// && configEmailEnable.equals("1")
				// && !configAdminEmail.equals("") && configTicketNewEmailEnable.equals("1")) {
				// if (!configTicketNewEmailExeFormat.equals("")) {
				// empEmailFormail = "";
				// // empEmailFormail = axelaEmpRepository.findByEmpEmail(Integer.parseInt(value));
				// if (!value.equals(ticketEntryId) && !entryempEmail.equals("")) {
				// empEmailFormail = empEmailFormail + "," + entryempEmail;
				// }
				// // SOP("1111111------------"+empEmailFormail);
				// // SendEmailToExecutive1();
				// }
				// }
				//
				// String historyNewvalue = PadQuotes(String.valueOf(axelaEmpRepository.findByEmpId(Integer.parseInt(value))));
				// if (!historyNewvalue.equals("")) {
				// // historyNewvalue = ticketRepository.findByTicketEmpId(ticketId);
				// } else {
				// historyNewvalue = "No Executives Found";
				// }
				// axelaservicetickethistory.setHistoryTicketId(BigInteger.valueOf(ticketId));
				// axelaservicetickethistory.setHistoryEmpId(empId);
				// axelaservicetickethistory.setHistoryActiontype("TICKET EXECUTIVES");
				// // axelaServiceTicketHistory.setHistoryOldvalue(historyOldvalue);
				// axelaservicetickethistory.setHistoryNewvalue(value);
				// axelaserviceticket.setTicketEmpId(Integer.parseInt(value));
				// msg = "Ticket Executive updated!";
				// }
				//
				// }
				//
				// if (name.equals("ticketTicketqueueId")) {
				// if (!value.equals("0") && !value.equals("")) {
				// // String historyOldvalue = ticketRepository.findByTicketQueue(ticketId);
				// // ticketRepository.updateByQueue(ticketId, Integer.parseInt(value));
				// axelaservicetickethistory.setHistoryTicketId(BigInteger.valueOf(ticketId));
				// axelaservicetickethistory.setHistoryEmpId(empId);
				// axelaservicetickethistory.setHistoryActiontype("TICKET QUEUES");
				// // axelaServiceTicketHistory.setHistoryOldvalue(historyOldvalue);
				// axelaservicetickethistory.setHistoryNewvalue(value);
				// axelaserviceticket.setTicketqueueName(value);
				// msg = "Ticket Queue updated!";
				// // historyOldvalue = strToLongDate(ticketRepository.findByDueTime(ticketId));
				// // due time
				// String duehrs = "", businessHrs = "", starttime = "", endtime = "", sun = "", mon = "", tue = "", wed = "", thu = "", fri = "", sat = "";
				// String ticketDueTime = "";
				// AxelaServiceTicketQueue axelaServiceTicketQueue = axelaTicketQueueRepository.findBYTicketQueueId(Integer.parseInt(ticketTicketqueueId));
				// duehrs = ConvertHoursToMins(String.valueOf(axelaServiceTicketQueue.getTicketqueueDuehrs())) + "";
				// businessHrs = axelaServiceTicketQueue.getTicketqueueBusinessHrs();
				// starttime = String.valueOf(axelaServiceTicketQueue.getTicketqueueStarttime());
				// endtime = String.valueOf(axelaServiceTicketQueue.getTicketqueueEndtime());
				// sun = axelaServiceTicketQueue.getTicketqueueSun();
				// mon = axelaServiceTicketQueue.getTicketqueueMon();
				// tue = axelaServiceTicketQueue.getTicketqueueTue();
				// wed = axelaServiceTicketQueue.getTicketqueueWed();
				// thu = axelaServiceTicketQueue.getTicketqueueThu();
				// fri = axelaServiceTicketQueue.getTicketqueueFri();
				// sat = axelaServiceTicketQueue.getTicketqueueSat();
				// ticketqueueTrigger1Hrs = ConvertHoursToMins(String.valueOf(axelaServiceTicketQueue.getTicketqueueTrigger1Hrs())) + "";
				// ticketqueueTrigger2Hrs = ConvertHoursToMins(String.valueOf(axelaServiceTicketQueue.getTicketqueueTrigger2Hrs())) + "";
				// ticketqueueTrigger3Hrs = ConvertHoursToMins(String.valueOf(axelaServiceTicketQueue.getTicketqueueTrigger3Hrs())) + "";
				// ticketqueueTrigger4Hrs = ConvertHoursToMins(String.valueOf(axelaServiceTicketQueue.getTicketqueueTrigger4Hrs())) + "";
				// ticketqueueTrigger5Hrs = ConvertHoursToMins(String.valueOf(axelaServiceTicketQueue.getTicketqueueTrigger5Hrs())) + "";
				// if (businessHrs.equals("1")) {
				// ArrayList publicHolidate = publicHolidays(ticketReportTime, customerBranchId, compId);
				// if (!duehrs.equals("0")) {
				// ticketDueTime = DueTime(ticketReportTime, duehrs,
				// Double.parseDouble(starttime), Double.parseDouble(endtime),
				// sun, mon, tue, wed, thu, fri, sat, publicHolidate);
				// } else {
				// ticketDueTime = ticketReportTime;
				// }
				// // *** start- ticket_trigger_hrs
				// if (!ticketqueueTrigger1Hrs.equals("0")) {
				// ticketTrigger1Hrs = DueTime(ticketReportTime, ticketqueueTrigger1Hrs,
				// Double.parseDouble(starttime), Double.parseDouble(endtime), sun, mon, tue, wed, thu, fri, sat, publicHolidate);
				// } else {
				// ticketTrigger1Hrs = "";
				// }
				// if (!ticketqueueTrigger2Hrs.equals("0")) {
				// ticketTrigger2Hrs = DueTime(ticketReportTime, ticketqueueTrigger2Hrs,
				// Double.parseDouble(starttime), Double.parseDouble(endtime), sun, mon, tue, wed, thu, fri, sat, publicHolidate);
				// } else {
				// ticketTrigger2Hrs = "";
				// }
				// if (!ticketqueueTrigger3Hrs.equals("0")) {
				// ticketTrigger3Hrs = DueTime(ticketReportTime, ticketqueueTrigger3Hrs,
				// Double.parseDouble(starttime), Double.parseDouble(endtime), sun, mon, tue, wed, thu, fri, sat, publicHolidate);
				// } else {
				// ticketTrigger3Hrs = "";
				// }
				// if (!ticketqueueTrigger4Hrs.equals("0")) {
				// ticketTrigger4Hrs = DueTime(ticketReportTime, ticketqueueTrigger4Hrs,
				// Double.parseDouble(starttime), Double.parseDouble(endtime), sun, mon, tue, wed, thu, fri, sat, publicHolidate);
				// } else {
				// ticketTrigger4Hrs = "";
				// }
				// if (!ticketqueueTrigger5Hrs.equals("0")) {
				// ticketTrigger5Hrs = DueTime(ticketReportTime, ticketqueueTrigger5Hrs,
				// Double.parseDouble(starttime), Double.parseDouble(endtime), sun, mon, tue, wed, thu, fri, sat, publicHolidate);
				// } else {
				// ticketTrigger5Hrs = "";
				// }
				// // *** eof- ticket_trigger_hrs
				// } else {
				// if (!duehrs.equals("0")) {
				// ticketDueTime = ToLongDate(AddHoursDate(StringToDate(ticketReportTime), 0, Double.parseDouble(duehrs), 0));
				// } else {
				// ticketDueTime = ticketReportTime;
				// }
				// if (!ticketqueueTrigger1Hrs.equals("0")) {
				// ticketTrigger1Hrs = ToLongDate(AddHoursDate(StringToDate(ticketReportTime), 0, Double.parseDouble(ticketqueueTrigger1Hrs), 0));
				// } else {
				// ticketTrigger1Hrs = "";
				// }
				// if (!ticketqueueTrigger2Hrs.equals("0")) {
				// ticketTrigger2Hrs = ToLongDate(AddHoursDate(StringToDate(ticketReportTime), 0, Double.parseDouble(ticketqueueTrigger2Hrs), 0));
				// } else {
				// ticketTrigger2Hrs = "";
				// }
				// if (!ticketqueueTrigger3Hrs.equals("0")) {
				// ticketTrigger3Hrs = ToLongDate(AddHoursDate(StringToDate(ticketReportTime), 0, Double.parseDouble(ticketqueueTrigger3Hrs), 0));
				// } else {
				// ticketTrigger3Hrs = "";
				// }
				// if (!ticketqueueTrigger4Hrs.equals("0")) {
				// ticketTrigger4Hrs = ToLongDate(AddHoursDate(StringToDate(ticketReportTime), 0, Double.parseDouble(ticketqueueTrigger4Hrs), 0));
				// } else {
				// ticketTrigger4Hrs = "";
				// }
				// if (!ticketqueueTrigger5Hrs.equals("0")) {
				// ticketTrigger5Hrs = ToLongDate(AddHoursDate(StringToDate(ticketReportTime), 0, Double.parseDouble(ticketqueueTrigger5Hrs), 0));
				// } else {
				// ticketTrigger5Hrs = "";
				// }
				// }
				//
				// // end due time
				// // ticketRepository.updateByDueTime(ticketId, ticketTrigger1Hrs, ticketTrigger2Hrs, ticketTrigger3Hrs, ticketTrigger4Hrs, ticketTrigger5Hrs);
				// axelaservicetickethistory.setHistoryTicketId(BigInteger.valueOf(ticketId));
				// axelaservicetickethistory.setHistoryEmpId(empId);
				// axelaservicetickethistory.setHistoryActiontype("TICKET DUE TIME");
				// // axelaServiceTicketHistory.setHistoryOldvalue(historyOldvalue);
				// axelaservicetickethistory.setHistoryNewvalue(value);
				// axelaserviceticket.setTicketDueTime(value);
				// msg = msg + "<br>Due Date updated!"
				// + "<input type=hidden name=duedate id=duedate value= '" + strToLongDate(ticketDueTime) + "'>";
				// }
				//
				// }
				//
				// if (name.equals("ticketTicketstatusId") || name.equals("txtComments")) {
				// if (!inputObj.isNull("status")) {
				// status = PadQuotes(inputObj.getString("status"));
				// }
				// if (!inputObj.isNull("comment")) {
				// comment = PadQuotes(inputObj.getString("comment"));
				// }
				// if (status.equals("3")) {
				// value = status;
				// // String historyOldvalue = ticketRepository.findByStatusName(ticketId);
				// if (!comment.equals("")) {
				// if (comment.length() < 5) {
				// msg = "Close Summary Should be Atleast five Digits!";
				// } else {
				// // ticketRepository.updateByIds(ticketId, gettimebyzone("1"), empId, Integer.parseInt(value));
				//
				// axelaservicetickethistory.setHistoryTicketId(BigInteger.valueOf(ticketId));
				// axelaservicetickethistory.setHistoryEmpId(empId);
				// axelaservicetickethistory.setHistoryActiontype("TICKET STATUS");
				// // axelaServiceTicketHistory.setHistoryOldvalue(historyOldvalue);
				// axelaservicetickethistory.setHistoryNewvalue(value);
				// axelaserviceticket.setTicketstatusId(Integer.parseInt(value));
				// msg = "Ticket Status updated!<br>";
				// value = comment;
				// value = value.replaceAll("nbsp", "&");
				// // historyOldvalue = ticketRepository.findByComments(ticketId);
				// // ticketRepository.updateByComments(ticketId, value);
				// axelaservicetickethistory.setHistoryTicketId(BigInteger.valueOf(ticketId));
				// axelaservicetickethistory.setHistoryEmpId(empId);
				// axelaservicetickethistory.setHistoryActiontype("TICKET CLOSED SUMMARY");
				// // axelaServiceTicketHistory.setHistoryOldvalue(historyOldvalue);
				// axelaservicetickethistory.setHistoryNewvalue(value);
				// axelaserviceticket.setTicketClosedComments(value);
				// msg = msg + "Close Summary updated!";
				// // PopulateConfigDetails();
				// ContactInfo();
				// if (!contactEmail2.equals("") && !contactEmail1.equals("")) {
				// sendContactEmail = contactEmail1 + "," + contactEmail2;
				// } else if (!contactEmail1.equals("")) {
				// sendContactEmail = contactEmail1;
				// } else if (!contactEmail2.equals("")) {
				// sendContactEmail = contactEmail2;
				// }
				// if (compEmailEnable.equals("1")
				// && configEmailEnable.equals("1")
				// && !configAdminEmail.equals("")
				// && configTicketClosedEmailEnable.equals("1")) {
				// if (!sendContactEmail.equals("")
				// && !configTicketClosedEmailFormat.equals("")
				// && !configTicketClosedEmailSub.equals("")) {
				// SendEmail();
				// }
				// if (!empEmailFormail.equals("")
				// && !configTicketClosedEmailExeSub.equals("")
				// && !configTicketClosedEmailExeFormat.equals("")) {
				// SendEmailToExecutive();
				// }
				// }
				// if (compSmsEnable.equals("1") && configSmsEnable.equals("1") && configTicketClosedSmsEnable.equals("1")) {
				// if (!configTicketClosedSmsFormat.equals("")) {
				// if (!contactMobile1.equals("")) {
				// SendSMS(contactMobile1);
				// }
				// if (!contactMobile2.equals("")) {
				// SendSMS(contactMobile2);
				// }
				// }
				// if (!configTicketClosedSmsExeFormat.equals("")) {
				// if (!empMobile1.equals("")) {
				// SendSMSToExecutive(empMobile1);
				// }
				// if (!empMobile2.equals("")) {
				// SendSMSToExecutive(empMobile2);
				// }
				// }
				// }
				// }
				// } else {
				// msg = "Enter Close Summary!";
				// }
				// } else if (!status.equals("3") && !status.equals("") && name.equals("ticketTicketstatusId")) {
				// status = status.replaceAll("nbsp", "&");
				// // String historyOldvalue = ticketRepository.findByStatusName(ticketId);
				// if (status.equals("4") || status.equals("5")) {
				// msg = "Update Permission Denied!";
				// }
				// // ticketRepository.updateByStatusId(ticketId, Integer.parseInt(status));
				// // String historyNewvalue = ticketRepository.findByStatusName(ticketId);
				// axelaservicetickethistory.setHistoryTicketId(BigInteger.valueOf(ticketId));
				// axelaservicetickethistory.setHistoryEmpId(empId);
				// axelaservicetickethistory.setHistoryActiontype("TICKET STATUS");
				// // axelaServiceTicketHistory.setHistoryOldvalue(historyOldvalue);
				// axelaservicetickethistory.setHistoryNewvalue(value);
				// axelaserviceticket.setTicketstatusId(Integer.parseInt(value));
				// msg = "Ticket Status updated!";
				// } else if (!status.equals("3") && name.equals("txtComments")) {
				// value = comment;
				// value = value.replaceAll("nbsp", "&");
				// // String historyOldvalue = ticketRepository.findByComments(ticketId);
				// // ticketRepository.updateByComments(ticketId, value);
				// axelaservicetickethistory.setHistoryTicketId(BigInteger.valueOf(ticketId));
				// axelaservicetickethistory.setHistoryEmpId(empId);
				// axelaservicetickethistory.setHistoryActiontype("TICKET CLOSED SUMMARY");
				// // axelaServiceTicketHistory.setHistoryOldvalue(historyOldvalue);
				// axelaservicetickethistory.setHistoryNewvalue(value);
				// axelaserviceticket.setTicketClosedComments(value);
				// msg = "Close Summary updated!";
				// }
				// }
				//
				// if (name.equals("ticketRefno")) {
				// value = value.replaceAll("nbsp", "&");
				// if (!isNumeric(value)) {
				// msg = "<font color=\"red\">Enter Numeric Reference No.!";
				// } else if (isNumeric(value) && value.length() < 2) {
				// msg = "<font color=\"red\">Reference No. should be atleast Two Digits!";
				// } else {
				// // StrSql = PadQuotes(ticketRepository.findByRefNo(ticketId, value));
				// if (!StrSql.equals("")) {
				// msg = "<font color=\"red\">Similar Ref No. found!";
				// } else {
				// // String historyOldvalue = ticketRepository.findByTicketRefNo(ticketId);
				// // ticketRepository.updateByTicketRefNo(ticketId, value);
				// axelaservicetickethistory.setHistoryTicketId(BigInteger.valueOf(ticketId));
				// axelaservicetickethistory.setHistoryEmpId(empId);
				// axelaservicetickethistory.setHistoryActiontype("TICKET REFNO");
				// // axelaServiceTicketHistory.setHistoryOldvalue(historyOldvalue);
				// axelaservicetickethistory.setHistoryNewvalue(value);
				// axelaserviceticket.setTicketRefno(value);
				// msg = "Ref. No. updated!";
				// }
				// }
				// }
				//

				if (name.equals("ticketTickettypeId")) {

					axelaservicetickethistory.setHistoryActiontype("TICKET TYPE");
					axelaservicetickethistory.setHistoryOldvalue(String.valueOf(axelaserviceticket.getTicketTickettypeId()));
					axelaservicetickethistory.setHistoryNewvalue(value);
					axelaserviceticket.setTicketTickettypeId(Integer.parseInt(value));
					msg = "Type Updated!";
				}

				if (name.equals("ticketTicketcatId")) {

					axelaservicetickethistory.setHistoryActiontype("TICKET CATEGORY");
					axelaservicetickethistory.setHistoryOldvalue(String.valueOf(axelaserviceticket.getTicketTicketcatId()));
					axelaservicetickethistory.setHistoryNewvalue(value);
					axelaserviceticket.setTicketTicketcatId(Integer.parseInt(value));
					msg = "Category Updated!";
				}

				if (name.equals("ticketTicketstatusId")) {

					axelaservicetickethistory.setHistoryActiontype("TICKET STATUS");
					axelaservicetickethistory.setHistoryOldvalue(String.valueOf(axelaserviceticket.getTicketTicketstatusId()));
					axelaservicetickethistory.setHistoryNewvalue(value);
					axelaserviceticket.setTicketTicketstatusId(Integer.parseInt(value));
					msg = "Status Updated!";
				}

				if (name.equals("ticketEmpId")) {

					axelaservicetickethistory.setHistoryActiontype("TICKET EXECUTIVE");
					axelaservicetickethistory.setHistoryOldvalue(String.valueOf(axelaserviceticket.getTicketEmpId()));
					axelaservicetickethistory.setHistoryNewvalue(value);
					axelaserviceticket.setTicketEmpId(Integer.parseInt(value));
					msg = "Executive Updated!";
				}

				if (name.equals("ticketPmId")) {
					axelaservicetickethistory.setHistoryActiontype("TICKET PROJECT");
					axelaservicetickethistory.setHistoryOldvalue(String.valueOf(axelaserviceticket.getTicketPmId()));
					axelaservicetickethistory.setHistoryNewvalue(value);
					axelaserviceticket.setTicketPmId(Integer.parseInt(value));
					msg = "Project Updated!";
				}

				// if (!inputObj.isNull("contract")) {
				// contract = PadQuotes(inputObj.getString("contract"));
				// if (contract.equals("yes")) {
				// if (!value.equals("")) {
				// value = value.replaceAll("nbsp", "&");
				// // String historyOldvalue = ticketRepository.findByContractId(ticketId);
				// // ticketRepository.updateByContractId(ticketId, Integer.parseInt(value));
				// // String historyNewvalue = serviceContractRepository.findByContractId(Integer.parseInt(value));
				// axelaservicetickethistory.setHistoryTicketId(BigInteger.valueOf(ticketId));
				// axelaservicetickethistory.setHistoryEmpId(empId);
				// axelaservicetickethistory.setHistoryActiontype("TICKET CONTRACT");
				// // axelaServiceTicketHistory.setHistoryOldvalue(historyOldvalue);
				// axelaservicetickethistory.setHistoryNewvalue(value);
				// axelaserviceticket.setTicketContactId(Integer.parseInt(value));
				// msg = "Contract updated!";
				// }
				//
				// }
				// }
				//
				// if (!inputObj.isNull("deletecontract")) {
				// deletecontract = PadQuotes(inputObj.getString("deletecontract"));
				// }
				// if (!inputObj.isNull("contractId")) {
				// contractId = CNumeric(PadQuotes(inputObj.getString("contractId")));
				// }
				// if (deletecontract.equals("yes") && !contractId.equals("")) {
				// // String historyOldvalue = ticketRepository.findByContractId(ticketId);
				// // ticketRepository.updateByContract(ticketId);
				// String historyNewvalue = "0";
				// String historyActiontype = "CONTRACT ID DELETED";
				// AxelaServiceTicketHistory axelaServiceTicketHistory = new AxelaServiceTicketHistory();
				// axelaServiceTicketHistory.setHistoryTicketId(BigInteger.valueOf(ticketId));
				// axelaServiceTicketHistory.setHistoryEmpId(empId);
				// axelaServiceTicketHistory.setHistoryDatetime(gettimebyzone("1"));
				// axelaServiceTicketHistory.setHistoryActiontype(historyActiontype);
				// // axelaServiceTicketHistory.setHistoryOldvalue(historyOldvalue);
				// axelaServiceTicketHistory.setHistoryNewvalue(historyNewvalue);
				// serviceTickethistoryRepository.save(axelaServiceTicketHistory);
				// msg = "Contract deleted!";
				// }
				//
				// if (!inputObj.isNull("asset")) {
				// asset = PadQuotes(inputObj.getString("asset"));
				// }
				// if (asset.equals("yes")) {
				// if (!value.equals("")) {
				// value = value.replaceAll("nbsp", "&");
				// // String historyOldvalue = ticketRepository.findByAssetId(ticketId);
				// // ticketRepository.updateByAsset(ticketId, Integer.parseInt(value));
				// // String historyNewvalue = String.valueOf(serviceContractAssetRepository.findByAsset(Integer.parseInt(value)));
				// axelaservicetickethistory.setHistoryTicketId(BigInteger.valueOf(ticketId));
				// axelaservicetickethistory.setHistoryEmpId(empId);
				// axelaservicetickethistory.setHistoryActiontype("TICKET ASSET ID");
				// // axelaServiceTicketHistory.setHistoryOldvalue(historyOldvalue);
				// axelaservicetickethistory.setHistoryNewvalue(value);
				// axelaserviceticket.setTicketAssetId(Integer.parseInt(value));
				// msg = "Asset updated!";
				// // String historyOldvalue1 = ticketRepository.findByContractId(ticketId);
				// // String assetContractId = CNumeric(PadQuotes(String.valueOf(serviceContractAssetRepository.findByAssetContract(Integer.parseInt(value)))));
				// // ticketRepository.updateByAssetContractId(ticketId, Integer.parseInt(assetContractId));
				// // String historyNewvalue1 = CNumeric(PadQuotes(String.valueOf(serviceContractAssetRepository.findByAssetContract(Integer.parseInt(value)))));
				// axelaservicetickethistory.setHistoryEmpId(empId);
				// axelaservicetickethistory.setHistoryActiontype("TICKET CONTRACT ID");
				// // axelaServiceTicketHistory.setHistoryOldvalue(historyOldvalue);
				// axelaservicetickethistory.setHistoryNewvalue(value);
				// axelaserviceticket.setTicketContractId(Integer.parseInt(value));
				// msg = msg + "<br>Contract updated!";
				// } else {
				// msg = "Select Asset!";
				// }
				// }
				//
				// if (!inputObj.isNull("assetcontract")) {
				// assetcontract = PadQuotes(inputObj.getString("assetcontract"));
				// }
				// if (assetcontract.equals("yes")) {
				// // String contractTitle = serviceContractRepository.findByContract(Integer.parseInt(value));
				// // String contractId = CNumeric(PadQuotes(String.valueOf(serviceContractAssetRepository.findByAssetContract(Integer.parseInt(value)))));
				// // msg = "<b><a href=../service/contract-list.jsp?contractId=" + contractId + ">" + contractTitle + "</a></b>";
				// }
				//
				// if (!inputObj.isNull("deleteasset")) {
				// deleteasset = PadQuotes(inputObj.getString("deleteasset"));
				// }
				// if (!inputObj.isNull("assetId")) {
				// assetId = PadQuotes(inputObj.getString("assetId"));
				// }
				// if (deleteasset.equals("yes") && !assetId.equals("")) {
				// // String historyOldvalue = ticketRepository.findByAssetId(ticketId);
				// // ticketRepository.updateByContractId(ticketId, 0);
				// String historyNewvalue = "0";
				// String historyActiontype = "ASSET ID DELETED";
				// AxelaServiceTicketHistory axelaServiceTicketHistory = new AxelaServiceTicketHistory();
				// axelaServiceTicketHistory.setHistoryTicketId(BigInteger.valueOf(ticketId));
				// axelaServiceTicketHistory.setHistoryEmpId(empId);
				// axelaServiceTicketHistory.setHistoryDatetime(gettimebyzone("1"));
				// axelaServiceTicketHistory.setHistoryActiontype(historyActiontype);
				// // axelaServiceTicketHistory.setHistoryOldvalue(historyOldvalue);
				// axelaServiceTicketHistory.setHistoryNewvalue(historyNewvalue);
				// serviceTickethistoryRepository.save(axelaServiceTicketHistory);
				// msg = "Asset deleted!";
				// }

				ticketRepository.save(axelaserviceticket);
				serviceTickethistoryRepository.save(axelaservicetickethistory);
				output.put("msg", msg);
			}
		} else {
			output.put("msg", "Invalid TICKET  ID");
			response.setStatus(400);
		}
	}
	private void SendSMSToExecutive(String empMobile22) {

	}
	private void SendSMS(String contactMobile12) {

	}
	private void SendEmailToExecutive() {

	}
	private void SendEmail() {

	}
	public void ListChildTickets() {
		// List<Object[]> listChild = ticketRepository.listChild(ticketId);
		// for (Object[] results : listChild) {
		// if (!results[1].toString().equals("")) {
		//
		// } else {
		//
		// }
		// }
	}
	// if (rs.isBeforeFirst()) {
	// while (rs.next()) {
	// if (!rs.getString("customerId").equals("")) {
	// Str.append("<b><a href=ticket-dash.jsp?ticketId=").append(rs.getString("ticketId")).append(">").append(rs.getString("ticketId")).append("</a></b><br>");
	// } else {
	// Str.append("<b><a href=ticket-dash.jsp?ticketId=").append(rs.getString("ticketId")).append(">").append(rs.getString("ticketId")).append("</a></b><br>");
	// }
	// }

	public void getValues(String input) throws JSONException {
		inputObj = new JSONObject(input);

		// if (!inputObj.isNull("tab")) {
		// tab = Integer.parseInt(CNumeric(PadQuotes(inputObj.getString("tab"))));
		// }

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

	// public void PopulateConfigDetails() {
	// // List<AxelaConfig> axelaConfig = configFilterImpl.populateConfigDetails(ticketEntryId, empId);
	// for (AxelaConfig obj : axelaConfig) {
	// configServiceTicketRefno = PadQuotes(obj.getConfigServiceContractRefno());
	// configServiceContract = PadQuotes(obj.getConfigServiceContract());
	// configServiceTicketCat = PadQuotes(obj.getConfigServiceTicketCat());
	// configServiceTicketType = PadQuotes(obj.getConfigServiceTicketType());
	// compModulePm = PadQuotes(obj.getCompModulePm());
	// empRoleId = Integer.parseInt(CNumeric(PadQuotes(String.valueOf(obj.getEmpRoleId()))));
	// configTicketFollowupEmailEnable = PadQuotes(obj.getConfigTicketFollowupEmailEnable());
	// configTicketFollowupEmailSub = PadQuotes(obj.getConfigTicketFollowupEmailSub());
	// configTicketFollowupEmailFormat = PadQuotes(obj.getConfigTicketFollowupEmailFormat());
	// configTicketFollowupEmailExeSub = PadQuotes(obj.getConfigTicketFollowupEmailExeSub());
	// configTicketFollowupEmailExeFormat = PadQuotes(obj.getConfigTicketFollowupEmailExeFormat());
	// configTicketFollowupSmsEnable = PadQuotes(obj.getConfigTicketFollowupSmsEnable());
	// configTicketFollowupSmsFormat = PadQuotes(obj.getConfigTicketFollowupSmsFormat());
	// configTicketFollowupSmsExeFormat = PadQuotes(obj.getConfigTicketFollowupSmsExeFormat());
	// configAdminEmail = PadQuotes(obj.getConfigAdminEmail());
	// configEmailEnable = PadQuotes(obj.getConfigEmailEnable());
	// configSmsEnable = PadQuotes(obj.getConfigSmsEnable());
	// compSmsEnable = PadQuotes(obj.getCompSmsEnable());
	// compEmailEnable = PadQuotes(obj.getCompEmailEnable());
	// // entryempEmail = PadQuotes(obj.getEntryempEmail());
	// // empEmail = PadQuotes(obj.getEmpEmail());
	// }
	// // }
	// public Map populateCustomerDetail() throws JSONException {
	// output = new HashMap();
	// // List<AxelaSalesOpprHistory> obj = null;
	// ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	// for (AxelaServiceJc obj : jcfilterimpl.findCustomerDetail(jcId)) {
	// HashMap map = new HashMap();
	// map.put("jcId", obj.getJcId());
	// map.put("jcEntryDate", strToShortDate(obj.getJcEntryDate()));
	// map.put("branchName", obj.getJcBranchName());
	// map.put("customerName", obj.getJcCustomerName());
	// map.put("contactPhone1", obj.getContactPhone1());
	// map.put("contactAddress", obj.getContactAddress());
	// map.put("contactPin", obj.getContactPin());
	// map.put("contactName", obj.getContactTitleId() + obj.getContactFname() + obj.getContactLname());
	// map.put("contactMobile1", obj.getContactMobile1());
	// map.put("contactEmail1", obj.getContactEmail1());
	// map.put("contactMobile2", obj.getContactMobile2());
	// map.put("contactEmail2", obj.getContactEmail2());
	// list.add(map);
	// }
	//
	// output.put("populateCustomerDetail", list);
	//
	// return output;
	// }
	// map.put("ticket_id", rs.getString("ticket_id"));
	// map.put("tickettrans_nextfollowup_time", FormatDate(rs.getString("tickettrans_nextfollowup_time"), emp_formatdate + " " + emp_formattime));
	// map.put("tickettrans_id", rs.getString("tickettrans_id"));
	// map.put("ticket_customer_id", ticket_customer_id);
	// map.put("tickettrans_followup", rs.getString("tickettrans_followup"));
	// map.put("tickettrans_private", rs.getString("tickettrans_private"));
	// map.put("tickettrans_modified_id", rs.getString("tickettrans_modified_id"));
	// map.put("tickettrans_modified_date", rs.getString("tickettrans_modified_date"));
	// map.put("modified_by", rs.getString("modified_by"));
	// map.put("tickettrans_entry_date", rs.getString("tickettrans_entry_date"));
	// map.put("tickettrans_entry_id", rs.getString("tickettrans_entry_id"));
	// map.put("entry_by", rs.getString("entry_by"));

	// public Map populateCustomerDetail() throws JSONException {
	// output = new HashMap();
	// // List<AxelaSalesOpprHistory> obj = null;
	// ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	// for (AxelaServiceJc obj : jcfilterimpl.findCustomerDetail(jcId)) {
	// HashMap map = new HashMap();
	// map.put("jcId", obj.getJcId());
	// map.put("jcEntryDate", strToShortDate(obj.getJcEntryDate()));
	// map.put("branchName", obj.getJcBranchName());
	// map.put("customerName", obj.getJcCustomerName());
	// map.put("contactPhone1", obj.getContactPhone1());
	// map.put("contactAddress", obj.getContactAddress());
	// map.put("contactPin", obj.getContactPin());
	// map.put("contactName", obj.getContactTitleId() + obj.getContactFname() + obj.getContactLname());
	// map.put("contactMobile1", obj.getContactMobile1());
	// map.put("contactEmail1", obj.getContactEmail1());
	// map.put("contactMobile2", obj.getContactMobile2());
	// map.put("contactEmail2", obj.getContactEmail2());
	// list.add(map);
	// }
	//
	// output.put("populateCustomerDetail", list);
	//
	// return output;
	// }
	public Map ListFollowupData(int ticketId, HttpSession session, HttpServletResponse response) throws JSONException {
		SOP("ticketId============" + ticketId);
		int count = 0;
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (AxelaHelpDeskTicketTran obj : ticketTransFilterImpl.listFollowUpData(ticketId)) {
			count++;
			HashMap map = new HashMap();
			map.put("count", count);
			map.put("ticketId", obj.getTicketId());
			map.put("tickettransNextfollowupTime", dateToString(obj.getTickettransNextfollowupTime()));
			map.put("tickettransId", obj.getTickettransId());
			map.put("ticketCustomerId", obj.getTicketCustomerId());
			map.put("ticketCustomerId", obj.getTickettransFollowup());
			map.put("tickettransPrivate", obj.getTickettransPrivate());
			map.put("tickettransFollowup", obj.getTickettransFollowup());
			map.put("tickettransModifiedDate", dateToString(obj.getTickettransModifiedDate()));
			map.put("tickettransEntryDate", dateToString(obj.getTickettransEntryDate()));
			map.put("tickettransEntryId", obj.getTickettransEntryId());
			map.put("entryBy", obj.getEntryBy());
			map.put("modifiedBy", obj.getModifiedBy());
			list.add(map);
		}
		output.put("populateListFollowup", list);
		return output;
	}

	public Map populateHistory(int historyTicketId) throws JSONException, ParseException {
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (AxelaHelpDeskTicketHistory obj : ticketRepositoryImpl.findHistory(historyTicketId)) {
			HashMap map = new HashMap();
			map.put("historyId", obj.getHistoryId());
			map.put("historyActiontype", obj.getHistoryActiontype());
			map.put("historyDatetime", strToLongDate(obj.getHistoryDatetime()));
			map.put("historyEmpId", obj.getHistoryEmpId());
			map.put("historyTicketId", obj.getHistoryTicketId());
			map.put("historyNewvalue", obj.getHistoryNewvalue());
			map.put("historyOldvalue", obj.getHistoryOldvalue());
			map.put("empName", obj.getEmpRefNo() + obj.getEmpName());
			list.add(map);
		}
		output.put("populateHistory", list);
		return output;
	}

	public Map populateSummary(int ticketId) throws JSONException {
		output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (AxelaHelpDeskTicket obj : ticketRepositoryImpl.findSummary(ticketId))
		{
			HashMap map = new HashMap();
			map.put("ticketId", obj.getTicketId());
			map.put("ticketSubject", obj.getTicketSubject());
			map.put("ticketDesc", obj.getTicketDesc());
			map.put("ticketStatusName", obj.getTicketstatusName());
			map.put("ticketStatusId", obj.getTicketstatusId());
			map.put("ticketDepartment", obj.getTicketqueueName());
			map.put("ticketDepartmentId", obj.getTicketTicketqueueId());
			map.put("level", obj.getTicketTrigger());
			map.put("priorityId", obj.getTicketPriorityticketId());
			map.put("priorityName", obj.getPriorityticketName());
			map.put("reportTime", dateToString(obj.getTicketReportTime()));
			map.put("dueTime", dateToString(obj.getTicketDueTime()));
			map.put("executive", axelaEmpRepository.findEmpName(obj.getTicketEmpId()));
			map.put("typeId", obj.getTicketTickettypeId());
			map.put("typeName", obj.getTickettypeName());
			map.put("sourceId", obj.getTicketTicketsourceId());
			map.put("sourceName", obj.getTicketsourceName());
			map.put("closedComments", obj.getTicketClosedComments());
			map.put("closedBy", obj.getClosedBy());
			map.put("closedTime", dateToString(obj.getTicketClosedTime()));
			map.put("notes", obj.getTicketNotes());
			map.put("entryBy", axelaEmpRepository.findEmpName(obj.getTicketEntryId()));
			map.put("entryDate", dateToString(obj.getTicketEntryDate()));
			map.put("modifiedBy", axelaEmpRepository.findEmpName(obj.getTicketModifiedId()));
			map.put("modifiedDate", dateToString(obj.getTicketModifiedDate()));
			list.add(map);
		}
		output.put("populateData", list);
		return output;
	}

	public Map populateCustomer(int ticketId) throws JSONException {
		SOP("coming===========");
		output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (AxelaHelpDeskTicket obj : ticketRepositoryImpl.findCustomer(ticketId))
		{
			HashMap map = new HashMap();
			map.put("customerPhone2", obj.getCustomerPhone2());
			map.put("customerPhone3", obj.getCustomerPhone3());
			map.put("customerPhone4", obj.getCustomerPhone4());
			map.put("address", obj.getCustomerAddress1());
			map.put("customerPin", obj.getCustomerPin());
			map.put("cityName", obj.getCityName());
			map.put("countryName", obj.getCountryName());
			map.put("customerMobile1", obj.getCustomerMobile1());
			map.put("customerMobile2", obj.getCustomerMobile2());
			map.put("customerEmail1", obj.getCustomerEmail1());
			map.put("customerEmail2", obj.getCustomerEmail2());
			map.put("customerNotes", obj.getCustomerNotes());
			map.put("customerName", obj.getCustomerName());
			list.add(map);
		}
		output.put("populateCustomer", list);

		return output;
	}

	public Map ContactInfo(int ticketId) throws JSONException {
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (Object[] axelaCustomerContact : customerContactReposiitory.findByTicket(ticketId))
		{
			HashMap map = new HashMap();
			map.put("contactId", axelaCustomerContact[0]);
			map.put("contactName", axelaCustomerContact[1]);
			map.put("contactEmail1", axelaCustomerContact[2]);// .getContactEmail1());
			map.put("contactEmail2", axelaCustomerContact[3] + "");// .getContactEmail2());
			map.put("contactMobile1", axelaCustomerContact[4] + "");// .getContactMobile1());
			map.put("contactMobile2", axelaCustomerContact[5] + "");// .getContactMobile2());
			map.put("contactAddress", axelaCustomerContact[6] + "");// .getContactAddress());
			list.add(map);
		}
		output.put("populateContact", list);
		return output;
	}

	public Map populateJcDocs(HttpSession session) throws JSONException {
		output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (Object[] obj : helpDeskTicketDocRepository.findJobCardDocs(ticketId)) {
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
	// public void ContactInfo() {
	// AxelaCustomerContact axelaCustomerContact = customerContactReposiitory.findByTicket(ticketId);
	// if (axelaCustomerContact != null) {
	// contactEmail1 = axelaCustomerContact.getContactEmail1();
	// contactEmail2 = axelaCustomerContact.getContactEmail2();
	// contactMobile1 = axelaCustomerContact.getContactMobile1();
	// contactMobile2 = axelaCustomerContact.getContactMobile2();
	// contactName = axelaCustomerContact.getContactName();
	// contactAddress = axelaCustomerContact.getContactAddress();
	// contactId = CNumeric(PadQuotes(String.valueOf(axelaCustomerContact.getContactId())));
	// }
	// }
}
