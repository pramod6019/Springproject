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

import axela.portal.model.AxelaBranch;

/**
 * The persistent class for the axela_helpdesk_ticket_holi database table.
 * 
 */
@Entity
@Table(name = "axela_helpdesk_ticket_holi", catalog = "axela_1")
@NamedQuery(name = "AxelaHelpDeskTicketHoli.findAll", query = "SELECT a FROM AxelaHelpDeskTicketHoli a")
public class AxelaHelpDeskTicketHoli implements Serializable {
	private static final long serialVersionUID = 1L;

	@Transient
	private int branchId = 0;

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	@Transient
	private String branchname = "";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticketholi_id")
	private int ticketholiId;

	@Column(name = "ticketholi_branch_id")
	private int ticketholiBranchId;

	@Column(name = "ticketholi_date")
	private Date ticketholiDate;

	@Column(name = "ticketholi_entry_date")
	private Date ticketholiEntryDate;

	@Column(name = "ticketholi_entry_id")
	private int ticketholiEntryId;

	@Column(name = "ticketholi_modified_date")
	private Date ticketholiModifiedDate;

	@Column(name = "ticketholi_modified_id")
	private int ticketholiModifiedId;

	@Column(name = "ticketholi_name")
	private String ticketholiName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticketholi_branch_id", referencedColumnName = "branch_id", insertable = false, updatable = false)
	private AxelaBranch axelaBranch;

	public AxelaBranch getAxelaBranch() {
		return axelaBranch;
	}

	public void setAxelaBranch(AxelaBranch axelaBranch) {
		this.axelaBranch = axelaBranch;
	}

	public AxelaHelpDeskTicketHoli() {
	}

	public AxelaHelpDeskTicketHoli(
			int ticketholiId,
			String ticketholiName,
			int branchId,
			Date ticketholiDate,
			String branchname) {
		this.ticketholiId = ticketholiId;
		this.ticketholiName = ticketholiName;
		this.branchId = branchId;
		this.ticketholiDate = ticketholiDate;
		this.branchname = branchname;
	}

	public AxelaHelpDeskTicketHoli(
			int ticketholiId,
			int branchId,
			Date ticketholiDate,
			String ticketholiName,
			int ticketholiEntryId,
			Date ticketholiEntryDate,
			int ticketholiModifiedId,
			Date ticketholiModifiedDate) {
		this.ticketholiId = ticketholiId;
		this.branchId = branchId;
		this.ticketholiDate = ticketholiDate;
		this.ticketholiName = ticketholiName;
		this.ticketholiEntryId = ticketholiEntryId;
		this.ticketholiEntryDate = ticketholiEntryDate;
		this.ticketholiModifiedId = ticketholiModifiedId;
		this.ticketholiModifiedDate = ticketholiModifiedDate;
	}

	public int getTicketholiId() {
		return this.ticketholiId;
	}

	public void setTicketholiId(int ticketholiId) {
		this.ticketholiId = ticketholiId;
	}

	public int getTicketholiBranchId() {
		return this.ticketholiBranchId;
	}

	public void setTicketholiBranchId(int ticketholiBranchId) {
		this.ticketholiBranchId = ticketholiBranchId;
	}

	public Date getTicketholiDate() {
		return this.ticketholiDate;
	}

	public void setTicketholiDate(Date ticketholiDate) {
		this.ticketholiDate = ticketholiDate;
	}

	public Date getTicketholiEntryDate() {
		return this.ticketholiEntryDate;
	}

	public void setTicketholiEntryDate(Date ticketholiEntryDate) {
		this.ticketholiEntryDate = ticketholiEntryDate;
	}

	public int getTicketholiEntryId() {
		return this.ticketholiEntryId;
	}

	public void setTicketholiEntryId(int ticketholiEntryId) {
		this.ticketholiEntryId = ticketholiEntryId;
	}

	public Date getTicketholiModifiedDate() {
		return this.ticketholiModifiedDate;
	}

	public void setTicketholiModifiedDate(Date ticketholiModifiedDate) {
		this.ticketholiModifiedDate = ticketholiModifiedDate;
	}

	public int getTicketholiModifiedId() {
		return this.ticketholiModifiedId;
	}

	public void setTicketholiModifiedId(int ticketholiModifiedId) {
		this.ticketholiModifiedId = ticketholiModifiedId;
	}

	public String getTicketholiName() {
		return this.ticketholiName;
	}

	public void setTicketholiName(String ticketholiName) {
		this.ticketholiName = ticketholiName;
	}

}