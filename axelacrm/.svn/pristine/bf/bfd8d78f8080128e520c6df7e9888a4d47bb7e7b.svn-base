package axela.helpdesk.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import axela.customer.model.AxelaCustomer;
import axela.customer.model.AxelaCustomerContact;
import axela.portal.model.AxelaEmp;
import axela.sales.model.AxelaSalesOppr;
import axela.service.model.AxelaServiceContract;
import axela.service.model.AxelaServiceContractAsset;
import axela.service.model.AxelaServiceJcPsf;

/**
 * The persistent class for the axela_helpdesk_ticket database table.
 * 
 */
@Entity
@Table(name = "axela_helpdesk_ticket", catalog = "axela_1")
@NamedQuery(name = "AxelaHelpDeskTicket.findAll", query = "SELECT a FROM AxelaHelpDeskTicket a")
public class AxelaHelpDeskTicket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticket_id")
	private int ticketId;

	@Column(name = "ticket_asset_id")
	private int ticketAssetId;

	@Column(name = "ticket_closed_comments")
	private String ticketClosedComments;

	@Column(name = "ticket_closed_emp_id")
	private int ticketClosedEmpId;

	@Column(name = "ticket_closed_time")
	private Date ticketClosedTime;

	@Column(name = "ticket_contact_entry_date")
	private Date ticketContactEntryDate;

	@Column(name = "ticket_contact_entry_id")
	private int ticketContactEntryId;

	@Column(name = "ticket_contact_id")
	private int ticketContactId;

	@Column(name = "ticket_contract_id")
	private int ticketContractId;

	@Column(name = "ticket_crm_id")
	private int ticketCrmId;

	@Column(name = "ticket_customer_id")
	private int ticketCustomerId;

	@Column(name = "ticket_desc")
	private String ticketDesc;

	@Column(name = "ticket_due_time")
	private Date ticketDueTime;

	@Column(name = "ticket_emp_id")
	private int ticketEmpId;

	public long getMonthticket() {
		return monthticket;
	}

	public void setMonthticket(long monthticket) {
		this.monthticket = monthticket;
	}

	public long getTodayticket() {
		return todayticket;
	}

	public void setTodayticket(long todayticket) {
		this.todayticket = todayticket;
	}

	public long getTotalticket() {
		return totalticket;
	}

	public void setTotalticket(long totalticket) {
		this.totalticket = totalticket;
	}

	@Column(name = "ticket_entry_date")
	private Date ticketEntryDate;

	@Column(name = "ticket_entry_id")
	private int ticketEntryId;

	@Column(name = "ticket_jc_id")
	private int ticketJcId;

	@Column(name = "ticket_jc_serialno")
	private String ticketJcSerialno;

	@Column(name = "ticket_jcpsf_id")
	private int ticketJcpsfId;

	@Column(name = "ticket_logger_email")
	private String ticketLoggerEmail;

	@Column(name = "ticket_logger_jobtitle")
	private String ticketLoggerJobtitle;

	@Column(name = "ticket_logger_mobile")
	private String ticketLoggerMobile;

	@Column(name = "ticket_logger_name")
	private String ticketLoggerName;

	@Column(name = "ticket_logger_phone")
	private String ticketLoggerPhone;

	@Column(name = "ticket_logger_title_id")
	private int ticketLoggerTitleId;

	@Column(name = "ticket_modified_date")
	private Date ticketModifiedDate;

	@Column(name = "ticket_modified_id")
	private int ticketModifiedId;

	@Column(name = "ticket_notes")
	private String ticketNotes;

	@Column(name = "ticket_oppr_id")
	private int ticketOpprId;

	@Column(name = "ticket_parent_id")
	private int ticketParentId;

	@Column(name = "ticket_pm_id")
	private int ticketPmId;

	@Column(name = "ticket_priorityticket_id")
	private int ticketPriorityticketId;

	@Column(name = "ticket_read")
	private String ticketRead;

	@Column(name = "ticket_refno")
	private String ticketRefno;

	@Column(name = "ticket_reopened_comments")
	private String ticketReopenedComments;

	@Column(name = "ticket_reopened_emp_id")
	private int ticketReopenedEmpId;

	@Column(name = "ticket_reopened_time")
	private Date ticketReopenedTime;

	@Column(name = "ticket_report_time")
	private Date ticketReportTime;

	@Column(name = "ticket_service_id")
	private int ticketServiceId;

	@Column(name = "ticket_so_id")
	private int ticketSoId;

	@Column(name = "ticket_subject")
	private String ticketSubject;

	@Column(name = "ticket_ticketcat_id")
	private int ticketTicketcatId;

	@Column(name = "ticket_ticketqueue_id")
	private int ticketTicketqueueId;

	@Column(name = "ticket_ticketsource_id")
	private int ticketTicketsourceId;

	@Column(name = "ticket_ticketstatus_id")
	private int ticketTicketstatusId;

	@Column(name = "ticket_tickettype_id")
	private int ticketTickettypeId;

	@Column(name = "ticket_trigger")
	private int ticketTrigger;

	@Column(name = "ticket_trigger1_hrs")
	private Date ticketTrigger1Hrs;

	@Column(name = "ticket_trigger2_hrs")
	private Date ticketTrigger2Hrs;

	@Column(name = "ticket_trigger3_hrs")
	private Date ticketTrigger3Hrs;

	@Column(name = "ticket_trigger4_hrs")
	private Date ticketTrigger4Hrs;

	@Column(name = "ticket_trigger5_hrs")
	private Date ticketTrigger5Hrs;

	@Transient
	private String closedBy;

	@Transient
	private int customerId;

	@Transient
	private long day1;

	@Transient
	private long day2;

	@Transient
	private long day3;

	@Transient
	private long day4;

	@Transient
	private long day5;

	@Transient
	private long day6;

	@Transient
	private long day7;

	@Transient
	private long logWeek1;

	@Transient
	private String customerAddress1;
	@Transient
	private String customerPhone2;
	@Transient
	private String customerPhone3;
	@Transient
	private String customerPhone4;
	@Transient
	private String customerMobile1;
	@Transient
	private String customerMobile2;
	@Transient
	private String customerFax1;
	@Transient
	private String customerFax2;
	@Transient
	private String customerEmail1;
	@Transient
	private String customerEmail2;
	@Transient
	private int customerEmpId;
	@Transient
	private String customerWebsite1;
	@Transient
	private String customerWebsite2;
	@Transient
	private String customerPin;
	@Transient
	private String customerNotes;
	@Transient
	private String contactActive;
	@Transient
	private String cityName;
	@Transient
	private String stateName;
	@Transient
	private String countryName;
	@Transient
	private String ticketsourceName;

	public String getCustomerAddress1() {
		return customerAddress1;
	}

	public void setCustomerAddress1(String customerAddress1) {
		this.customerAddress1 = customerAddress1;
	}

	public String getCustomerPhone2() {
		return customerPhone2;
	}

	public void setCustomerPhone2(String customerPhone2) {
		this.customerPhone2 = customerPhone2;
	}

	public String getCustomerPhone3() {
		return customerPhone3;
	}

	public void setCustomerPhone3(String customerPhone3) {
		this.customerPhone3 = customerPhone3;
	}

	public String getCustomerPhone4() {
		return customerPhone4;
	}

	public void setCustomerPhone4(String customerPhone4) {
		this.customerPhone4 = customerPhone4;
	}

	public String getCustomerMobile1() {
		return customerMobile1;
	}

	public void setCustomerMobile1(String customerMobile1) {
		this.customerMobile1 = customerMobile1;
	}

	public String getCustomerMobile2() {
		return customerMobile2;
	}

	public void setCustomerMobile2(String customerMobile2) {
		this.customerMobile2 = customerMobile2;
	}

	public String getCustomerFax1() {
		return customerFax1;
	}

	public void setCustomerFax1(String customerFax1) {
		this.customerFax1 = customerFax1;
	}

	public String getCustomerFax2() {
		return customerFax2;
	}

	public void setCustomerFax2(String customerFax2) {
		this.customerFax2 = customerFax2;
	}

	public String getCustomerEmail1() {
		return customerEmail1;
	}

	public void setCustomerEmail1(String customerEmail1) {
		this.customerEmail1 = customerEmail1;
	}

	public String getCustomerEmail2() {
		return customerEmail2;
	}

	public void setCustomerEmail2(String customerEmail2) {
		this.customerEmail2 = customerEmail2;
	}

	public int getCustomerEmpId() {
		return customerEmpId;
	}

	public void setCustomerEmpId(int customerEmpId) {
		this.customerEmpId = customerEmpId;
	}

	public String getCustomerWebsite2() {
		return customerWebsite2;
	}

	public void setCustomerWebsite2(String customerWebsite2) {
		this.customerWebsite2 = customerWebsite2;
	}

	public String getCustomerPin() {
		return customerPin;
	}

	public void setCustomerPin(String customerPin) {
		this.customerPin = customerPin;
	}

	public String getCustomerNotes() {
		return customerNotes;
	}

	public void setCustomerNotes(String customerNotes) {
		this.customerNotes = customerNotes;
	}

	public String getContactActive() {
		return contactActive;
	}

	public void setContactActive(String contactActive) {
		this.contactActive = contactActive;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Transient
	private String customerName;
	@Transient
	private int assetId;
	@Transient
	private String ticketcatName;
	@Transient
	private String tickettypeName;
	@Transient
	private String priorityticketName;
	@Transient
	private int priorityticketId;
	@Transient
	private String contactName;
	@Transient
	private String contactMobile1;
	@Transient
	private String contactEmail1;
	@Transient
	private String contactMobile2;
	@Transient
	private String contactEmail2;
	@Transient
	private int ticketstatusId;
	@Transient
	private String ticketstatusName;
	@Transient
	private int empId;
	@Transient
	private String ticketqueueName;
	@Transient
	private String empName;
	@Transient
	private String empPhoto;
	@Transient
	private String empGender;
	@Transient
	private String contractTitle;
	@Transient
	private String assetName;
	@Transient
	private long monthticket;
	@Transient
	private long todayticket;
	@Transient
	private long totalticket;
	@Transient
	private long level1ticket;
	@Transient
	private long todayOpenticket;
	@Transient
	private long monthOpenticket;
	public long getLevel1ticket() {
		return level1ticket;
	}

	public void setLevel1ticket(long level1ticket) {
		this.level1ticket = level1ticket;
	}

	public long getLevel2ticket() {
		return level2ticket;
	}

	public void setLevel2ticket(long level2ticket) {
		this.level2ticket = level2ticket;
	}

	public long getLevel3ticket() {
		return level3ticket;
	}

	public void setLevel3ticket(long level3ticket) {
		this.level3ticket = level3ticket;
	}

	public long getLevel4ticket() {
		return level4ticket;
	}

	public void setLevel4ticket(long level4ticket) {
		this.level4ticket = level4ticket;
	}

	public long getLevel5ticket() {
		return level5ticket;
	}

	public void setLevel5ticket(long level5ticket) {
		this.level5ticket = level5ticket;
	}

	@Transient
	private long level2ticket;
	@Transient
	private long level3ticket;
	@Transient
	private long level4ticket;
	@Transient
	private long level5ticket;
	@Transient
	private String contactId;
	@Transient
	private String customerBranchId;
	@Transient
	private Date contractStartDate;
	@Transient
	private Date contractEndDate;
	@Transient
	private String tickettransContactEntryId;
	@Transient
	private Date jcpsfFollowupTime;
	@Transient
	private String psfempName;
	@Transient
	private String psfdaysDaycount;
	@Transient
	private String empMobile1;
	@Transient
	private String empEmail1;
	@Transient
	private String empMobile2;
	@Transient
	private String empEmail2;

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getCustomerBranchId() {
		return customerBranchId;
	}

	public void setCustomerBranchId(String customerBranchId) {
		this.customerBranchId = customerBranchId;
	}

	public Date getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public Date getContractEndDate() {
		return contractEndDate;
	}

	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public String getTickettransContactEntryId() {
		return tickettransContactEntryId;
	}

	public void setTickettransContactEntryId(String tickettransContactEntryId) {
		this.tickettransContactEntryId = tickettransContactEntryId;
	}

	public Date getJcpsfFollowupTime() {
		return jcpsfFollowupTime;
	}

	public void setJcpsfFollowupTime(Date jcpsfFollowupTime) {
		this.jcpsfFollowupTime = jcpsfFollowupTime;
	}

	public String getPsfempName() {
		return psfempName;
	}

	public void setPsfempName(String psfempName) {
		this.psfempName = psfempName;
	}

	public String getPsfdaysDaycount() {
		return psfdaysDaycount;
	}

	public void setPsfdaysDaycount(String psfdaysDaycount) {
		this.psfdaysDaycount = psfdaysDaycount;
	}

	public String getEmpMobile1() {
		return empMobile1;
	}

	public void setEmpMobile1(String empMobile1) {
		this.empMobile1 = empMobile1;
	}

	public String getEmpEmail1() {
		return empEmail1;
	}

	public void setEmpEmail1(String empEmail1) {
		this.empEmail1 = empEmail1;
	}

	public String getEmpMobile2() {
		return empMobile2;
	}

	public void setEmpMobile2(String empMobile2) {
		this.empMobile2 = empMobile2;
	}

	public String getEmpEmail2() {
		return empEmail2;
	}

	public void setEmpEmail2(String empEmail2) {
		this.empEmail2 = empEmail2;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getTicketcatName() {
		return ticketcatName;
	}

	public void setTicketcatName(String ticketcatName) {
		this.ticketcatName = ticketcatName;
	}

	public String getTickettypeName() {
		return tickettypeName;
	}

	public void setTickettypeName(String tickettypeName) {
		this.tickettypeName = tickettypeName;
	}

	public String getPriorityticketName() {
		return priorityticketName;
	}

	public void setPriorityticketName(String priorityticketName) {
		this.priorityticketName = priorityticketName;
	}

	public int getPriorityticketId() {
		return priorityticketId;
	}

	public void setPriorityticketId(int priorityticketId) {
		this.priorityticketId = priorityticketId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactMobile1() {
		return contactMobile1;
	}

	public void setContactMobile1(String contactMobile1) {
		this.contactMobile1 = contactMobile1;
	}

	public String getContactEmail1() {
		return contactEmail1;
	}

	public void setContactEmail1(String contactEmail1) {
		this.contactEmail1 = contactEmail1;
	}

	public String getContactMobile2() {
		return contactMobile2;
	}

	public void setContactMobile2(String contactMobile2) {
		this.contactMobile2 = contactMobile2;
	}

	public String getContactEmail2() {
		return contactEmail2;
	}

	public void setContactEmail2(String contactEmail2) {
		this.contactEmail2 = contactEmail2;
	}

	public int getTicketstatusId() {
		return ticketstatusId;
	}

	public void setTicketstatusId(int ticketstatusId) {
		this.ticketstatusId = ticketstatusId;
	}

	public String getTicketstatusName() {
		return ticketstatusName;
	}

	public void setTicketstatusName(String ticketstatusName) {
		this.ticketstatusName = ticketstatusName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getTicketqueueName() {
		return ticketqueueName;
	}

	public void setTicketqueueName(String ticketqueueName) {
		this.ticketqueueName = ticketqueueName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPhoto() {
		return empPhoto;
	}

	public void setEmpPhoto(String empPhoto) {
		this.empPhoto = empPhoto;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public String getContractTitle() {
		return contractTitle;
	}

	public void setContractTitle(String contractTitle) {
		this.contractTitle = contractTitle;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public AxelaHelpDeskTicket() {
	}

	public AxelaHelpDeskTicket(
			int ticketId,
			int customerBranchId,
			int ticketContactId,
			int ticketCustomerId,
			int ticketParentId,
			String customerName,
			String contactName,
			int ticketTicketstatusId,
			int ticketTicketcatId,
			int ticketTickettypeId,
			int ticketPmId,
			int ticketContractId,
			String ticketSubject,
			String ticketDesc,
			int ticketEmpId,
			String ticketRead,
			String ticketNotes,
			int ticketTicketsourceId,
			int ticketTicketqueueId,
			int ticketPriorityticketId,
			Date ticketDueTime,
			String ticketRefno,
			int ticketAssetId,
			int assetId,
			String assetName,
			Date ticketReportTime,
			int ticketEntryId,
			int ticketModifiedId,
			Date ticketEntryDate,
			Date ticketModifiedDate) {
		super();
		this.ticketId = ticketId;
		this.customerBranchId = String.valueOf(customerBranchId);
		this.ticketContactId = ticketContactId;
		this.ticketCustomerId = ticketCustomerId;
		this.ticketParentId = ticketParentId;
		this.customerName = customerName;
		this.contactName = contactName;
		this.ticketTicketstatusId = ticketTicketstatusId;
		this.ticketTicketcatId = ticketTicketcatId;
		this.ticketTickettypeId = ticketTickettypeId;
		this.ticketPmId = ticketPmId;
		this.ticketContractId = ticketContractId;
		this.ticketSubject = ticketSubject;
		this.ticketDesc = ticketDesc;
		this.ticketEmpId = ticketEmpId;
		this.ticketRead = ticketRead;
		this.ticketNotes = ticketNotes;
		this.ticketTicketsourceId = ticketTicketsourceId;
		this.ticketTicketqueueId = ticketTicketqueueId;
		this.ticketPriorityticketId = ticketPriorityticketId;
		this.ticketDueTime = ticketDueTime;
		this.ticketRefno = ticketRefno;
		this.ticketAssetId = ticketAssetId;
		this.assetId = assetId;
		this.assetName = assetName;
		this.ticketReportTime = ticketReportTime;
		this.ticketEntryId = ticketEntryId;
		this.ticketModifiedId = ticketModifiedId;
		this.ticketEntryDate = ticketEntryDate;
		this.ticketModifiedDate = ticketModifiedDate;
	}

	public AxelaHelpDeskTicket(int ticketId, Date ticketEntryDate) {
		super();
		this.ticketId = ticketId;
		this.ticketEntryDate = ticketEntryDate;
	}

	public AxelaHelpDeskTicket(
			int ticketId,
			int ticketOpprId,
			int ticketSoId,
			int ticketCrmId,
			String ticketSubject,
			String ticketDesc,
			String ticketJcSerialno,
			int ticketJcId,
			int ticketJcpsfId,
			int ticketCustomerId,
			int ticketContactId,
			int ticketTrigger,
			int customerId,
			String customerName,
			String ticketcatName,
			String tickettypeName,
			String priorityticketName,
			int priorityticketId,
			String contactName,
			String contactMobile1,
			String contactMobile2,
			String contactEmail1,
			String contactEmail2,
			int ticketstatusId,
			String ticketstatusName,
			int empId,
			String ticketqueueName,
			String empName,
			// String empPhoto,
			String empGender,
			Date ticketReportTime,
			Date ticketDueTime,
			Date ticketClosedTime,
			int ticketContractId,
			int ticketAssetId,
			String contractTitle,
			String assetName) {
		this.ticketId = ticketId;
		this.ticketOpprId = ticketOpprId;
		this.ticketSoId = ticketSoId;
		this.ticketCrmId = ticketCrmId;
		this.ticketSubject = ticketSubject;
		this.ticketDesc = ticketDesc;
		this.ticketJcSerialno = ticketJcSerialno;
		this.ticketJcId = ticketJcId;
		this.ticketJcpsfId = ticketJcpsfId;
		this.ticketCustomerId = ticketCustomerId;
		this.ticketContactId = ticketContactId;
		this.ticketTrigger = ticketTrigger;
		this.customerId = customerId;
		this.customerName = customerName;
		this.ticketcatName = ticketcatName;
		this.tickettypeName = tickettypeName;
		this.priorityticketName = priorityticketName;
		this.priorityticketId = priorityticketId;
		this.contactName = contactName;
		this.contactMobile1 = contactMobile1;
		this.contactMobile2 = contactMobile2;
		this.contactEmail1 = contactEmail1;
		this.contactEmail2 = contactEmail2;
		this.ticketstatusId = ticketstatusId;
		this.ticketstatusName = ticketstatusName;
		this.empId = empId;
		this.ticketqueueName = ticketqueueName;
		this.empName = empName;
		// this.empPhoto = empPhoto;
		this.empGender = empGender;
		this.ticketReportTime = ticketReportTime;
		this.ticketDueTime = ticketDueTime;
		this.ticketClosedTime = ticketClosedTime;
		this.ticketContractId = ticketContractId;
		this.ticketAssetId = ticketAssetId;
		this.contractTitle = contractTitle;
		this.assetName = assetName;
	}

	public AxelaHelpDeskTicket(long monthticket,
			long todayticket,
			long totalticket,
			long level1ticket,
			long level2ticket,
			long level3ticket,
			long level4ticket,
			long level5ticket,
			long todayOpenticket,
			long monthOpenticket) {
		super();
		this.monthticket = monthticket;
		this.todayticket = todayticket;
		this.totalticket = totalticket;
		this.level1ticket = level1ticket;
		this.level2ticket = level2ticket;
		this.level3ticket = level3ticket;
		this.level4ticket = level4ticket;
		this.level5ticket = level5ticket;
		this.todayOpenticket = todayOpenticket;
		this.monthOpenticket = monthOpenticket;

	}

	public long getMonthOpenticket() {
		return monthOpenticket;
	}

	public void setMonthOpenticket(long monthOpenticket) {
		this.monthOpenticket = monthOpenticket;
	}

	public long getTodayOpenticket() {
		return todayOpenticket;
	}

	public void setTodayOpenticket(long todayOpenticket) {
		this.todayOpenticket = todayOpenticket;
	}

	public String getClosedBy() {
		return closedBy;
	}

	public void setClosedBy(String closedBy) {
		this.closedBy = closedBy;
	}

	public AxelaHelpDeskTicket(
			int contactId,
			String contactName,
			String contactEmail1,
			String contactEmail2,
			String contactMobile1,
			String contactMobile2,
			String customerName,
			int customerBranchId,
			String contractTitle,
			Date contractStartDate,
			Date contractEndDate,
			String assetName,
			int tickettransContactEntryId,
			Date jcpsfFollowupTime,
			String psfempName,
			String psfdaysDaycount,
			int ticketReopenedEmpId,
			String empName,
			String empMobile1,
			String empEmail1,
			String empMobile2,
			String empEmail2) {

		this.contactId = String.valueOf(contactId);
		this.contactName = contactName;
		this.contactEmail1 = contactEmail1;
		this.contactEmail2 = contactEmail2;
		this.contactMobile1 = contactMobile1;
		this.contactMobile2 = contactMobile2;
		this.customerName = customerName;
		this.customerBranchId = String.valueOf(customerBranchId);
		this.contractTitle = contractTitle;
		this.contractStartDate = contractStartDate;
		this.contractEndDate = contractEndDate;
		this.assetName = assetName;
		this.tickettransContactEntryId = String.valueOf(tickettransContactEntryId);
		this.jcpsfFollowupTime = jcpsfFollowupTime;
		this.psfempName = psfempName;
		this.psfdaysDaycount = psfdaysDaycount;
		this.ticketReopenedEmpId = ticketReopenedEmpId;
		this.empName = empName;
		this.empMobile1 = empMobile1;
		this.empEmail1 = empEmail1;
		this.empMobile2 = empMobile2;
		this.empEmail2 = empEmail2;

	}

	public AxelaHelpDeskTicket(
			int ticketId,
			int ticketContactId,
			int ticketCustomerId,
			int ticketJcId,
			int ticketParentId,
			int ticketTicketstatusId,
			int ticketTicketcatId,
			int ticketTickettypeId,
			int ticketPmId,
			int ticketContractId,
			int ticketAssetId,
			String ticketSubject,
			String ticketDesc,
			Date ticketClosedTime,
			String ticketClosedComments,
			int ticketEmpId,
			String ticketRead,
			String ticketRefno,
			int ticketJcpsfId,
			int ticketTicketsourceId,
			Date ticketReportTime,
			int ticketTicketqueueId,
			int ticketPriorityticketId,
			Date ticketDueTime,
			int ticketEntryId,
			Date ticketEntryDate,
			String ticketJcSerialno,
			int contactId,
			String contactName,
			String contactEmail1,
			String contactEmail2,
			String contactMobile1,
			String contactMobile2,
			String customerName,
			int customerBranchId,
			String contractTitle,
			Date contractStartDate,
			Date contractEndDate,
			String assetName,
			int tickettransContactEntryId,
			Date jcpsfFollowupTime,
			String psfempName,
			String psfdaysDaycount,
			int ticketReopenedEmpId,
			String empName,
			String empMobile1,
			String empEmail1,
			String empMobile2,
			String empEmail2) {

		this.ticketId = ticketId;
		this.ticketContactId = ticketContactId;
		this.ticketCustomerId = ticketCustomerId;
		this.ticketJcId = ticketJcId;
		this.ticketParentId = ticketJcId;
		this.ticketTicketstatusId = ticketTicketstatusId;
		this.ticketTicketcatId = ticketTicketcatId;
		this.ticketTickettypeId = ticketTickettypeId;
		this.ticketPmId = ticketPmId;
		this.ticketContractId = ticketContractId;
		this.ticketAssetId = ticketAssetId;
		this.ticketSubject = ticketSubject;
		this.ticketDesc = ticketDesc;
		this.ticketClosedTime = ticketClosedTime;
		this.ticketClosedComments = ticketClosedComments;
		this.ticketEmpId = ticketEmpId;
		this.ticketRead = ticketRead;
		this.ticketRefno = ticketRefno;
		this.ticketJcpsfId = ticketJcpsfId;
		this.ticketTicketsourceId = ticketTicketsourceId;
		this.ticketReportTime = ticketReportTime;
		this.ticketTicketqueueId = ticketTicketqueueId;
		this.ticketPriorityticketId = ticketPriorityticketId;
		this.ticketDueTime = ticketDueTime;
		this.ticketEntryId = ticketEntryId;
		this.ticketEntryDate = ticketEntryDate;
		this.ticketJcSerialno = ticketJcSerialno;
		this.contactId = String.valueOf(contactId);
		this.contactName = contactName;
		this.contactEmail1 = contactEmail1;
		this.contactEmail2 = contactEmail2;
		this.contactMobile1 = contactMobile1;
		this.contactMobile2 = contactMobile2;
		this.customerName = customerName;
		this.customerBranchId = String.valueOf(customerBranchId);
		this.contractTitle = contractTitle;
		this.contractStartDate = contractStartDate;
		this.contractEndDate = contractEndDate;
		this.assetName = assetName;
		this.tickettransContactEntryId = String.valueOf(tickettransContactEntryId);
		this.jcpsfFollowupTime = jcpsfFollowupTime;
		this.psfempName = psfempName;
		this.psfdaysDaycount = psfdaysDaycount;
		this.ticketReopenedEmpId = ticketReopenedEmpId;
		this.empName = empName;
		this.empMobile1 = empMobile1;
		this.empEmail1 = empEmail1;
		this.empMobile2 = empMobile2;
		this.empEmail2 = empEmail2;
		// this.ticketModifiedId = ticketModifiedId;
		// this.ticketModifiedDate = ticketModifiedDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_emp_Id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_ticketsource_id", referencedColumnName = "ticketsource_id", insertable = false, updatable = false)
	private AxelaHelpDeskTicketSource axelaHelpDeskTicketSource;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_ticketstatus_id", referencedColumnName = "ticketstatus_id", insertable = false, updatable = false)
	private AxelaHelpDeskTicketStatus axelaHelpDeskTicketStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_ticketqueue_id", referencedColumnName = "ticketqueue_id", insertable = false, updatable = false)
	private AxelaHelpDeskTicketQueue axelaHelpDeskTicketQueue;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_priorityticket_id", referencedColumnName = "priorityticket_id", insertable = false, updatable = false)
	private AxelaHelpDeskTicketPriority axelaHelpDeskTicketPriority;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_contact_id", referencedColumnName = "contact_id", insertable = false, updatable = false)
	private AxelaCustomerContact axelaCustomerContact;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
	private AxelaCustomer axelaCustomer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_ticketcat_id", referencedColumnName = "ticketcat_id", insertable = false, updatable = false)
	private AxelaHelpDeskTicketCat axelaHelpDeskTicketCat;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_tickettype_id", referencedColumnName = "tickettype_id", insertable = false, updatable = false)
	private AxelaHelpDeskTicketType axelaHelpDeskTicketType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_contract_id", referencedColumnName = "contract_id", insertable = false, updatable = false)
	private AxelaServiceContract axelaServiceContract;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_asset_id", referencedColumnName = "asset_id", insertable = false, updatable = false)
	private AxelaServiceContractAsset axelaServiceContractAsset;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_oppr_id", referencedColumnName = "oppr_id", insertable = false, updatable = false)
	private AxelaSalesOppr axelaSalesOppr;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_jcpsf_id", referencedColumnName = "jcpsf_id", insertable = false, updatable = false)
	private AxelaServiceJcPsf axelaServiceJcPsf;

	@OneToMany(mappedBy = "axelaHelpDeskTicket")
	private List<AxelaHelpDeskTicketTran> axelaHelpDeskTicketTran;

	public AxelaServiceJcPsf getAxelaServiceJcPsf() {
		return axelaServiceJcPsf;
	}

	public void setAxelaServiceJcPsf(AxelaServiceJcPsf axelaServiceJcPsf) {
		this.axelaServiceJcPsf = axelaServiceJcPsf;
	}

	public List<AxelaHelpDeskTicketTran> getAxelaServiceTicketTran() {
		return axelaHelpDeskTicketTran;
	}

	public void setAxelaServiceTicketTran(List<AxelaHelpDeskTicketTran> axelaHelpDeskTicketTran) {
		this.axelaHelpDeskTicketTran = axelaHelpDeskTicketTran;
	}

	public AxelaSalesOppr getAxelaSalesOppr() {
		return axelaSalesOppr;
	}

	public void setAxelaSalesOppr(AxelaSalesOppr axelaSalesOppr) {
		this.axelaSalesOppr = axelaSalesOppr;
	}

	public AxelaServiceContractAsset getAxelaServiceContractAsset() {
		return axelaServiceContractAsset;
	}

	public void setAxelaServiceContractAsset(AxelaServiceContractAsset axelaServiceContractAsset) {
		this.axelaServiceContractAsset = axelaServiceContractAsset;
	}

	public AxelaServiceContract getAxelaServiceContract() {
		return axelaServiceContract;
	}

	public void setAxelaServiceContract(AxelaServiceContract axelaServiceContract) {
		this.axelaServiceContract = axelaServiceContract;
	}

	public AxelaHelpDeskTicketType getAxelaServiceTicketType() {
		return axelaHelpDeskTicketType;
	}

	public void setAxelaServiceTicketType(AxelaHelpDeskTicketType axelaHelpDeskTicketType) {
		this.axelaHelpDeskTicketType = axelaHelpDeskTicketType;
	}

	public AxelaHelpDeskTicketCat getAxelaServiceTicketCat() {
		return axelaHelpDeskTicketCat;
	}

	public void setAxelaServiceTicketCat(AxelaHelpDeskTicketCat axelaHelpDeskTicketCat) {
		this.axelaHelpDeskTicketCat = axelaHelpDeskTicketCat;
	}

	public AxelaCustomer getAxelaCustomer() {
		return axelaCustomer;
	}

	public void setAxelaCustomer(AxelaCustomer axelaCustomer) {
		this.axelaCustomer = axelaCustomer;
	}

	public AxelaCustomerContact getAxelaCustomerContact() {
		return axelaCustomerContact;
	}

	public void setAxelaCustomerContact(AxelaCustomerContact axelaCustomerContact) {
		this.axelaCustomerContact = axelaCustomerContact;
	}

	public AxelaHelpDeskTicketPriority getAxelaServiceTicketPriority() {
		return axelaHelpDeskTicketPriority;
	}

	public void setAxelaServiceTicketPriority(AxelaHelpDeskTicketPriority axelaHelpDeskTicketPriority) {
		this.axelaHelpDeskTicketPriority = axelaHelpDeskTicketPriority;
	}

	public AxelaHelpDeskTicketQueue getAxelaServiceTicketQueue() {
		return axelaHelpDeskTicketQueue;
	}

	public void setAxelaServiceTicketQueue(AxelaHelpDeskTicketQueue axelaHelpDeskTicketQueue) {
		this.axelaHelpDeskTicketQueue = axelaHelpDeskTicketQueue;
	}

	public AxelaHelpDeskTicketStatus getAxelaServiceTicketStatus() {
		return axelaHelpDeskTicketStatus;
	}

	public void setAxelaServiceTicketStatus(AxelaHelpDeskTicketStatus axelaHelpDeskTicketStatus) {
		this.axelaHelpDeskTicketStatus = axelaHelpDeskTicketStatus;
	}

	public AxelaHelpDeskTicketSource getAxelaServiceTicketSource() {
		return axelaHelpDeskTicketSource;
	}

	public void setAxelaServiceTicketSource(AxelaHelpDeskTicketSource axelaHelpDeskTicketSource) {
		this.axelaHelpDeskTicketSource = axelaHelpDeskTicketSource;
	}

	public AxelaEmp getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(AxelaEmp axelaEmp) {
		this.axelaEmp = axelaEmp;
	}

	public int getTicketId() {
		return this.ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getTicketAssetId() {
		return this.ticketAssetId;
	}

	public void setTicketAssetId(int ticketAssetId) {
		this.ticketAssetId = ticketAssetId;
	}

	public String getTicketClosedComments() {
		return this.ticketClosedComments;
	}

	public void setTicketClosedComments(String ticketClosedComments) {
		this.ticketClosedComments = ticketClosedComments;
	}

	public int getTicketClosedEmpId() {
		return this.ticketClosedEmpId;
	}

	public void setTicketClosedEmpId(int ticketClosedEmpId) {
		this.ticketClosedEmpId = ticketClosedEmpId;
	}

	public Date getTicketClosedTime() {
		return this.ticketClosedTime;
	}

	public void setTicketClosedTime(Date ticketClosedTime) {
		this.ticketClosedTime = ticketClosedTime;
	}

	public Date getTicketContactEntryDate() {
		return this.ticketContactEntryDate;
	}

	public void setTicketContactEntryDate(Date ticketContactEntryDate) {
		this.ticketContactEntryDate = ticketContactEntryDate;
	}

	public int getTicketContactEntryId() {
		return this.ticketContactEntryId;
	}

	public void setTicketContactEntryId(int ticketContactEntryId) {
		this.ticketContactEntryId = ticketContactEntryId;
	}

	public int getTicketContactId() {
		return this.ticketContactId;
	}

	public void setTicketContactId(int ticketContactId) {
		this.ticketContactId = ticketContactId;
	}

	public int getTicketContractId() {
		return this.ticketContractId;
	}

	public void setTicketContractId(int ticketContractId) {
		this.ticketContractId = ticketContractId;
	}

	public int getTicketCrmId() {
		return this.ticketCrmId;
	}

	public void setTicketCrmId(int ticketCrmId) {
		this.ticketCrmId = ticketCrmId;
	}

	public int getTicketCustomerId() {
		return this.ticketCustomerId;
	}

	public void setTicketCustomerId(int ticketCustomerId) {
		this.ticketCustomerId = ticketCustomerId;
	}

	public String getTicketDesc() {
		return this.ticketDesc;
	}

	public void setTicketDesc(String ticketDesc) {
		this.ticketDesc = ticketDesc;
	}

	public Date getTicketDueTime() {
		return this.ticketDueTime;
	}

	public void setTicketDueTime(Date ticketDueTime) {
		this.ticketDueTime = ticketDueTime;
	}

	public int getTicketEmpId() {
		return this.ticketEmpId;
	}

	public void setTicketEmpId(int ticketEmpId) {
		this.ticketEmpId = ticketEmpId;
	}

	public Date getTicketEntryDate() {
		return this.ticketEntryDate;
	}

	public void setTicketEntryDate(Date ticketEntryDate) {
		this.ticketEntryDate = ticketEntryDate;
	}

	public int getTicketEntryId() {
		return this.ticketEntryId;
	}

	public void setTicketEntryId(int ticketEntryId) {
		this.ticketEntryId = ticketEntryId;
	}

	public int getTicketJcId() {
		return this.ticketJcId;
	}

	public void setTicketJcId(int ticketJcId) {
		this.ticketJcId = ticketJcId;
	}

	public String getTicketJcSerialno() {
		return this.ticketJcSerialno;
	}

	public void setTicketJcSerialno(String ticketJcSerialno) {
		this.ticketJcSerialno = ticketJcSerialno;
	}

	public int getTicketJcpsfId() {
		return this.ticketJcpsfId;
	}

	public void setTicketJcpsfId(int ticketJcpsfId) {
		this.ticketJcpsfId = ticketJcpsfId;
	}

	public String getTicketLoggerEmail() {
		return this.ticketLoggerEmail;
	}

	public void setTicketLoggerEmail(String ticketLoggerEmail) {
		this.ticketLoggerEmail = ticketLoggerEmail;
	}

	public String getTicketLoggerJobtitle() {
		return this.ticketLoggerJobtitle;
	}

	public void setTicketLoggerJobtitle(String ticketLoggerJobtitle) {
		this.ticketLoggerJobtitle = ticketLoggerJobtitle;
	}

	public String getTicketLoggerMobile() {
		return this.ticketLoggerMobile;
	}

	public void setTicketLoggerMobile(String ticketLoggerMobile) {
		this.ticketLoggerMobile = ticketLoggerMobile;
	}

	public String getTicketLoggerName() {
		return this.ticketLoggerName;
	}

	public void setTicketLoggerName(String ticketLoggerName) {
		this.ticketLoggerName = ticketLoggerName;
	}

	public String getTicketLoggerPhone() {
		return this.ticketLoggerPhone;
	}

	public void setTicketLoggerPhone(String ticketLoggerPhone) {
		this.ticketLoggerPhone = ticketLoggerPhone;
	}

	public int getTicketLoggerTitleId() {
		return this.ticketLoggerTitleId;
	}

	public void setTicketLoggerTitleId(int ticketLoggerTitleId) {
		this.ticketLoggerTitleId = ticketLoggerTitleId;
	}

	public Date getTicketModifiedDate() {
		return this.ticketModifiedDate;
	}

	public void setTicketModifiedDate(Date ticketModifiedDate) {
		this.ticketModifiedDate = ticketModifiedDate;
	}

	public int getTicketModifiedId() {
		return this.ticketModifiedId;
	}

	public void setTicketModifiedId(int ticketModifiedId) {
		this.ticketModifiedId = ticketModifiedId;
	}

	public String getTicketNotes() {
		return this.ticketNotes;
	}

	public void setTicketNotes(String ticketNotes) {
		this.ticketNotes = ticketNotes;
	}

	public int getTicketOpprId() {
		return this.ticketOpprId;
	}

	public void setTicketOpprId(int ticketOpprId) {
		this.ticketOpprId = ticketOpprId;
	}

	public int getTicketParentId() {
		return this.ticketParentId;
	}

	public void setTicketParentId(int ticketParentId) {
		this.ticketParentId = ticketParentId;
	}

	public int getTicketPmId() {
		return this.ticketPmId;
	}

	public void setTicketPmId(int ticketPmId) {
		this.ticketPmId = ticketPmId;
	}

	public int getTicketPriorityticketId() {
		return this.ticketPriorityticketId;
	}

	public void setTicketPriorityticketId(int ticketPriorityticketId) {
		this.ticketPriorityticketId = ticketPriorityticketId;
	}

	public String getTicketRead() {
		return this.ticketRead;
	}

	public void setTicketRead(String ticketRead) {
		this.ticketRead = ticketRead;
	}

	public String getTicketRefno() {
		return this.ticketRefno;
	}

	public void setTicketRefno(String ticketRefno) {
		this.ticketRefno = ticketRefno;
	}

	public String getTicketReopenedComments() {
		return this.ticketReopenedComments;
	}

	public void setTicketReopenedComments(String ticketReopenedComments) {
		this.ticketReopenedComments = ticketReopenedComments;
	}

	public int getTicketReopenedEmpId() {
		return this.ticketReopenedEmpId;
	}

	public void setTicketReopenedEmpId(int ticketReopenedEmpId) {
		this.ticketReopenedEmpId = ticketReopenedEmpId;
	}

	public Date getTicketReopenedTime() {
		return this.ticketReopenedTime;
	}

	public void setTicketReopenedTime(Date ticketReopenedTime) {
		this.ticketReopenedTime = ticketReopenedTime;
	}

	public Date getTicketReportTime() {
		return this.ticketReportTime;
	}

	public void setTicketReportTime(Date ticketReportTime) {
		this.ticketReportTime = ticketReportTime;
	}

	public int getTicketServiceId() {
		return this.ticketServiceId;
	}

	public void setTicketServiceId(int ticketServiceId) {
		this.ticketServiceId = ticketServiceId;
	}

	public int getTicketSoId() {
		return this.ticketSoId;
	}

	public void setTicketSoId(int ticketSoId) {
		this.ticketSoId = ticketSoId;
	}

	public String getTicketSubject() {
		return this.ticketSubject;
	}

	public void setTicketSubject(String ticketSubject) {
		this.ticketSubject = ticketSubject;
	}

	public int getTicketTicketcatId() {
		return this.ticketTicketcatId;
	}

	public void setTicketTicketcatId(int ticketTicketcatId) {
		this.ticketTicketcatId = ticketTicketcatId;
	}

	public int getTicketTicketqueueId() {
		return this.ticketTicketqueueId;
	}

	public void setTicketTicketqueueId(int ticketTicketqueueId) {
		this.ticketTicketqueueId = ticketTicketqueueId;
	}

	public int getTicketTicketsourceId() {
		return this.ticketTicketsourceId;
	}

	public void setTicketTicketsourceId(int ticketTicketsourceId) {
		this.ticketTicketsourceId = ticketTicketsourceId;
	}

	public int getTicketTicketstatusId() {
		return this.ticketTicketstatusId;
	}

	public void setTicketTicketstatusId(int ticketTicketstatusId) {
		this.ticketTicketstatusId = ticketTicketstatusId;
	}

	public int getTicketTickettypeId() {
		return this.ticketTickettypeId;
	}

	public void setTicketTickettypeId(int ticketTickettypeId) {
		this.ticketTickettypeId = ticketTickettypeId;
	}

	public int getTicketTrigger() {
		return this.ticketTrigger;
	}

	public void setTicketTrigger(int ticketTrigger) {
		this.ticketTrigger = ticketTrigger;
	}

	public Date getTicketTrigger1Hrs() {
		return this.ticketTrigger1Hrs;
	}

	public void setTicketTrigger1Hrs(Date ticketTrigger1Hrs) {
		this.ticketTrigger1Hrs = ticketTrigger1Hrs;
	}

	public Date getTicketTrigger2Hrs() {
		return this.ticketTrigger2Hrs;
	}

	public void setTicketTrigger2Hrs(Date ticketTrigger2Hrs) {
		this.ticketTrigger2Hrs = ticketTrigger2Hrs;
	}

	public Date getTicketTrigger3Hrs() {
		return this.ticketTrigger3Hrs;
	}

	public void setTicketTrigger3Hrs(Date ticketTrigger3Hrs) {
		this.ticketTrigger3Hrs = ticketTrigger3Hrs;
	}

	public Date getTicketTrigger4Hrs() {
		return this.ticketTrigger4Hrs;
	}

	public void setTicketTrigger4Hrs(Date ticketTrigger4Hrs) {
		this.ticketTrigger4Hrs = ticketTrigger4Hrs;
	}

	public Date getTicketTrigger5Hrs() {
		return this.ticketTrigger5Hrs;
	}

	public void setTicketTrigger5Hrs(Date ticketTrigger5Hrs) {
		this.ticketTrigger5Hrs = ticketTrigger5Hrs;
	}

	public long getDay1() {
		return day1;
	}

	public void setDay1(long day1) {
		this.day1 = day1;
	}

	public long getDay2() {
		return day2;
	}

	public void setDay2(long day2) {
		this.day2 = day2;
	}

	public long getDay3() {
		return day3;
	}

	public void setDay3(long day3) {
		this.day3 = day3;
	}

	public long getDay4() {
		return day4;
	}

	public void setDay4(long day4) {
		this.day4 = day4;
	}

	public long getDay5() {
		return day5;
	}

	public void setDay5(long day5) {
		this.day5 = day5;
	}

	public long getDay6() {
		return day6;
	}

	public void setDay6(long day6) {
		this.day6 = day6;
	}

	public long getDay7() {
		return day7;
	}

	public void setDay7(long day7) {
		this.day7 = day7;
	}

	public long getLogWeek1() {
		return logWeek1;
	}

	public void setLogWeek1(long logWeek1) {
		this.logWeek1 = logWeek1;
	}

	public String getTicketsourceName() {
		return ticketsourceName;
	}

	public void setTicketsourceName(String ticketsourceName) {
		this.ticketsourceName = ticketsourceName;
	}

	public AxelaHelpDeskTicket(
			int ticketId,
			String ticketRead,
			Date ticketClosedTime,
			Date ticketDueTime,
			int ticketTrigger,
			String ticketDesc,
			Date ticketReportTime,
			int ticketClosedEmpId,
			String ticketClosedComments,
			String ticketNotes,
			int ticketReopenedEmpId,
			String ticketReopenedComments,
			Date ticketReopenedTime,
			int ticketPriorityticketId,
			String priorityticketName,
			String ticketSubject,
			int ticketEmpId,
			int ticketEntryId,
			Date ticketEntryDate,
			int ticketModifiedId,
			Date ticketModifiedDate,
			int ticketTicketsourceId,
			String ticketsourceName,
			int ticketTicketstatusId,
			String ticketstatusName,
			int ticketTicketqueueId,
			String ticketqueueName,
			int ticketTickettypeId,
			String tickettypeName,
			String closedBy) {

		this.ticketId = ticketId;
		this.ticketRead = ticketRead;
		this.ticketClosedTime = ticketClosedTime;
		this.ticketDueTime = ticketDueTime;
		this.ticketTrigger = ticketTrigger;
		this.ticketDesc = ticketDesc;
		this.ticketReportTime = ticketReportTime;
		this.ticketClosedEmpId = ticketClosedEmpId;
		this.ticketClosedComments = ticketClosedComments;
		this.ticketNotes = ticketNotes;
		this.ticketReopenedEmpId = ticketReopenedEmpId;
		this.ticketReopenedComments = ticketReopenedComments;
		this.ticketReopenedTime = ticketReopenedTime;
		this.ticketPriorityticketId = ticketPriorityticketId;
		this.priorityticketName = priorityticketName;
		this.ticketSubject = ticketSubject;
		this.ticketEmpId = ticketEmpId;
		this.ticketEntryId = ticketEntryId;
		this.ticketEntryDate = ticketEntryDate;
		this.ticketModifiedId = ticketModifiedId;
		this.ticketModifiedDate = ticketModifiedDate;
		this.ticketTicketsourceId = ticketTicketsourceId;
		this.ticketsourceName = ticketsourceName;
		this.ticketTicketstatusId = ticketTicketstatusId;
		this.ticketstatusName = ticketstatusName;
		this.ticketTicketqueueId = ticketTicketqueueId;
		this.ticketqueueName = ticketqueueName;
		this.ticketTickettypeId = ticketTickettypeId;
		this.tickettypeName = tickettypeName;
		this.closedBy = closedBy;

	}

	public AxelaHelpDeskTicket(
			int ticketCustomerId,
			String ticketSubject,
			String customerName,
			String customerAddress1,
			String customerPhone2,
			String customerPhone3,
			String customerPhone4,
			String customerMobile1,
			String customerMobile2,
			String customerFax1,
			String customerFax2,
			String customerEmail1,
			String customerEmail2,
			int customerEmpId,
			String customerWebsite1,
			String customerWebsite2,
			String customerPin,
			String customerNotes,
			String contactActive,
			String cityName,
			String stateName,
			String countryName

	) {

		this.ticketCustomerId = ticketCustomerId;
		this.ticketSubject = ticketSubject;
		this.customerName = customerName;
		this.customerAddress1 = customerAddress1;
		this.customerPhone2 = customerPhone2;
		this.customerPhone3 = customerPhone3;
		this.customerPhone4 = customerPhone4;
		this.customerMobile1 = customerMobile1;
		this.customerMobile2 = customerMobile2;
		this.customerFax1 = customerFax1;
		this.customerFax2 = customerFax2;
		this.customerEmail1 = customerEmail1;
		this.customerEmail2 = customerEmail2;
		this.customerEmpId = customerEmpId;
		this.customerWebsite1 = customerWebsite1;
		this.customerWebsite2 = customerWebsite2;
		this.customerPin = customerPin;
		this.customerNotes = customerNotes;
		this.contactActive = contactActive;
		this.cityName = cityName;
		this.stateName = stateName;
		this.countryName = countryName;

	}
}