package axela.helpdesk.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import axela.portal.model.AxelaEmp;

/**
 * The persistent class for the axela_helpdesk_ticket_trans database table.
 * 
 */
// sujan
@Entity
@Table(name = "axela_helpdesk_ticket_trans", catalog = "axela_1")
@NamedQuery(name = "AxelaHelpDeskTicketTran.findAll", query = "SELECT a FROM AxelaHelpDeskTicketTran a")
public class AxelaHelpDeskTicketTran implements Serializable {
	private static final long serialVersionUID = 1L;

	@Transient
	private int ticketId = 0;
	@Transient
	private int ticketCustomerId = 0;
	@Transient
	private String privatee;
	@Transient
	private String entryBy = "0";
	@Transient
	private String modifiedBy = "0";
	@Transient
	private String customerName = "";
	@Transient
	private int customerId = 0;
	@Transient
	private Date ticketReportTime = null;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tickettrans_id")
	private int tickettransId;

	@Column(name = "tickettrans_contact_entry_date")
	private Date tickettransContactEntryDate;

	@Column(name = "tickettrans_contact_entry_id")
	private int tickettransContactEntryId;

	@Column(name = "tickettrans_entry_date")
	private Date tickettransEntryDate;

	@Column(name = "tickettrans_entry_id")
	private int tickettransEntryId;

	@Column(name = "tickettrans_followup")
	private String tickettransFollowup;

	@Column(name = "tickettrans_modified_date")
	private Date tickettransModifiedDate;

	@Column(name = "tickettrans_modified_id")
	private int tickettransModifiedId;

	@Column(name = "tickettrans_nextfollowup_time")
	private Date tickettransNextfollowupTime;

	@Column(name = "tickettrans_private")
	private String tickettransPrivate;

	@Column(name = "tickettrans_ticket_id")
	private int tickettransTicketId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tickettrans_ticket_id", referencedColumnName = "ticket_id", insertable = false, updatable = false)
	private AxelaHelpDeskTicket axelaHelpDeskTicket;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tickettrans_entry_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tickettrans_modified_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmpp;

	public AxelaEmp getAxelaEmpp() {
		return axelaEmpp;
	}

	public AxelaHelpDeskTicketTran(
			int ticketId,
			int tickettransId,
			int ticketCustomerId,
			Date ticketReportTime,
			String tickettransFollowup,
			Date tickettransNextfollowupTime,
			String tickettransPrivate,
			String privatee,
			int tickettransEntryId,
			String entryBy,
			Date tickettransEntryDate,
			int tickettransModifiedId,
			String modifiedBy,
			Date tickettransModifiedDate,
			String customerName,
			int tickettransContactEntryId,
			int customerId) {

		this.ticketId = ticketId;
		this.tickettransId = tickettransId;
		this.ticketCustomerId = ticketCustomerId;
		this.ticketReportTime = ticketReportTime;
		this.tickettransFollowup = tickettransFollowup;
		this.tickettransNextfollowupTime = tickettransNextfollowupTime;
		this.tickettransPrivate = tickettransPrivate;
		this.privatee = privatee;
		this.tickettransEntryId = tickettransEntryId;
		this.entryBy = entryBy;
		this.tickettransEntryDate = tickettransEntryDate;
		this.tickettransModifiedId = tickettransModifiedId;
		this.modifiedBy = modifiedBy;
		this.tickettransModifiedDate = tickettransModifiedDate;
		this.customerName = customerName;
		this.tickettransContactEntryId = tickettransContactEntryId;
		this.customerId = customerId;

	}
	public Date getTicketReportTime() {
		return ticketReportTime;
	}

	public void setTicketReportTime(Date ticketReportTime) {
		this.ticketReportTime = ticketReportTime;
	}

	public void setAxelaEmpp(AxelaEmp axelaEmpp) {
		this.axelaEmpp = axelaEmpp;
	}

	public AxelaEmp getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(AxelaEmp axelaEmp) {
		this.axelaEmp = axelaEmp;
	}
	public AxelaHelpDeskTicket getAxelaServiceTicket() {
		return axelaHelpDeskTicket;
	}

	public void setAxelaServiceTicket(AxelaHelpDeskTicket axelaHelpDeskTicket) {
		this.axelaHelpDeskTicket = axelaHelpDeskTicket;
	}

	public AxelaHelpDeskTicketTran() {
	}

	public int getTickettransId() {
		return this.tickettransId;
	}

	public void setTickettransId(int tickettransId) {
		this.tickettransId = tickettransId;
	}

	public Date getTickettransContactEntryDate() {
		return this.tickettransContactEntryDate;
	}

	public void setTickettransContactEntryDate(Date tickettransContactEntryDate) {
		this.tickettransContactEntryDate = tickettransContactEntryDate;
	}

	public int getTickettransContactEntryId() {
		return this.tickettransContactEntryId;
	}

	public void setTickettransContactEntryId(int tickettransContactEntryId) {
		this.tickettransContactEntryId = tickettransContactEntryId;
	}

	public Date getTickettransEntryDate() {
		return this.tickettransEntryDate;
	}

	public void setTickettransEntryDate(Date tickettransEntryDate) {
		this.tickettransEntryDate = tickettransEntryDate;
	}

	public int getTickettransEntryId() {
		return this.tickettransEntryId;
	}

	public void setTickettransEntryId(int tickettransEntryId) {
		this.tickettransEntryId = tickettransEntryId;
	}

	public String getTickettransFollowup() {
		return this.tickettransFollowup;
	}

	public void setTickettransFollowup(String tickettransFollowup) {
		this.tickettransFollowup = tickettransFollowup;
	}

	public Date getTickettransModifiedDate() {
		return this.tickettransModifiedDate;
	}

	public void setTickettransModifiedDate(Date tickettransModifiedDate) {
		this.tickettransModifiedDate = tickettransModifiedDate;
	}

	public int getTickettransModifiedId() {
		return this.tickettransModifiedId;
	}

	public void setTickettransModifiedId(int tickettransModifiedId) {
		this.tickettransModifiedId = tickettransModifiedId;
	}

	public Date getTickettransNextfollowupTime() {
		return this.tickettransNextfollowupTime;
	}

	public void setTickettransNextfollowupTime(Date tickettransNextfollowupTime) {
		this.tickettransNextfollowupTime = tickettransNextfollowupTime;
	}

	public String getTickettransPrivate() {
		return this.tickettransPrivate;
	}

	public void setTickettransPrivate(String tickettransPrivate) {
		this.tickettransPrivate = tickettransPrivate;
	}

	public int getTickettransTicketId() {
		return this.tickettransTicketId;
	}

	public void setTickettransTicketId(int tickettransTicketId) {
		this.tickettransTicketId = tickettransTicketId;
	}
	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getTicketCustomerId() {
		return ticketCustomerId;
	}

	public void setTicketCustomerId(int ticketCustomerId) {
		this.ticketCustomerId = ticketCustomerId;
	}

	public String getPrivatee() {
		return privatee;
	}

	public void setPrivatee(String privatee) {
		this.privatee = privatee;
	}

	public String getEntryBy() {
		return entryBy;
	}

	public void setEntryBy(String entryBy) {
		this.entryBy = entryBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}