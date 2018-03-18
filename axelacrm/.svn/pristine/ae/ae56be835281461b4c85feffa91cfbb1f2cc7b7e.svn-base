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

/**
 * The persistent class for the axela_helpdesk_ticket_status database table.
 * 
 */
@Entity
@Table(name = "axela_helpdesk_ticket_status", catalog = "axela_1")
@NamedQuery(name = "AxelaHelpDeskTicketStatus.findAll", query = "SELECT a FROM AxelaHelpDeskTicketStatus a")
public class AxelaHelpDeskTicketStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticketstatus_id")
	private int ticketstatusId;

	@Column(name = "ticketstatus_entry_date")
	private Date ticketstatusEntryDate;

	@Column(name = "ticketstatus_entry_id")
	private int ticketstatusEntryId;

	@Column(name = "ticketstatus_modified_date")
	private Date ticketstatusModifiedDate;

	@Column(name = "ticketstatus_modified_id")
	private int ticketstatusModifiedId;

	@Column(name = "ticketstatus_name")
	private String ticketstatusName;

	@Column(name = "ticketstatus_rank")
	private int ticketstatusRank;

	@Transient
	private long ticketCount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticketstatus_id", referencedColumnName = "ticket_ticketstatus_id", insertable = false, updatable = false)
	private AxelaHelpDeskTicket axelaHelpDeskTicket;

	public AxelaHelpDeskTicketStatus() {
	}

	public AxelaHelpDeskTicketStatus(
			int ticketstatusId,
			Date ticketstatusEntryDate,
			int ticketstatusEntryId,
			Date ticketstatusModifiedDate,
			int ticketstatusModifiedId,
			String ticketstatusName,
			int ticketstatusRank) {
		super();
		this.ticketstatusId = ticketstatusId;
		this.ticketstatusEntryDate = ticketstatusEntryDate;
		this.ticketstatusEntryId = ticketstatusEntryId;
		this.ticketstatusModifiedDate = ticketstatusModifiedDate;
		this.ticketstatusModifiedId = ticketstatusModifiedId;
		this.ticketstatusName = ticketstatusName;
		this.ticketstatusRank = ticketstatusRank;
	}

	public AxelaHelpDeskTicketStatus(
			int ticketstatusId,
			String ticketstatusName,
			long ticketCount) {
		super();
		this.ticketstatusId = ticketstatusId;
		this.ticketstatusName = ticketstatusName;
		this.ticketCount = ticketCount;
	}

	public int getTicketstatusId() {
		return this.ticketstatusId;
	}

	public void setTicketstatusId(int ticketstatusId) {
		this.ticketstatusId = ticketstatusId;
	}

	public Date getTicketstatusEntryDate() {
		return this.ticketstatusEntryDate;
	}

	public void setTicketstatusEntryDate(Date ticketstatusEntryDate) {
		this.ticketstatusEntryDate = ticketstatusEntryDate;
	}

	public int getTicketstatusEntryId() {
		return this.ticketstatusEntryId;
	}

	public void setTicketstatusEntryId(int ticketstatusEntryId) {
		this.ticketstatusEntryId = ticketstatusEntryId;
	}

	public Date getTicketstatusModifiedDate() {
		return this.ticketstatusModifiedDate;
	}

	public void setTicketstatusModifiedDate(Date ticketstatusModifiedDate) {
		this.ticketstatusModifiedDate = ticketstatusModifiedDate;
	}

	public int getTicketstatusModifiedId() {
		return this.ticketstatusModifiedId;
	}

	public void setTicketstatusModifiedId(int ticketstatusModifiedId) {
		this.ticketstatusModifiedId = ticketstatusModifiedId;
	}

	public String getTicketstatusName() {
		return this.ticketstatusName;
	}

	public void setTicketstatusName(String ticketstatusName) {
		this.ticketstatusName = ticketstatusName;
	}

	public int getTicketstatusRank() {
		return this.ticketstatusRank;
	}

	public void setTicketstatusRank(int ticketstatusRank) {
		this.ticketstatusRank = ticketstatusRank;
	}

	public long getTicketCount() {
		return ticketCount;
	}

	public void setTicketCount(long ticketCount) {
		this.ticketCount = ticketCount;
	}

}