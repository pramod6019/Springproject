package axela.helpdesk.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_helpdesk_ticket_type database table.
 * 
 */
@Entity
@Table(name = "axela_helpdesk_ticket_type", catalog = "axela_1")
@NamedQuery(name = "AxelaHelpDeskTicketType.findAll", query = "SELECT a FROM AxelaHelpDeskTicketType a")
public class AxelaHelpDeskTicketType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tickettype_id")
	private int tickettypeId;

	@Column(name = "tickettype_entry_date")
	private Date tickettypeEntryDate;

	@Column(name = "tickettype_entry_id")
	private int tickettypeEntryId;

	@Column(name = "tickettype_modified_date")
	private Date tickettypeModifiedDate;

	@Column(name = "tickettype_modified_id")
	private int tickettypeModifiedId;

	@Column(name = "tickettype_name")
	private String tickettypeName;

	public AxelaHelpDeskTicketType() {
	}

	public AxelaHelpDeskTicketType(
			int tickettypeId,
			String tickettypeName,
			int tickettypeEntryId,
			Date tickettypeEntryDate,
			int tickettypeModifiedId,
			Date tickettypeModifiedDate) {
		super();
		this.tickettypeId = tickettypeId;
		this.tickettypeEntryDate = tickettypeEntryDate;
		this.tickettypeEntryId = tickettypeEntryId;
		this.tickettypeModifiedDate = tickettypeModifiedDate;
		this.tickettypeModifiedId = tickettypeModifiedId;
		this.tickettypeName = tickettypeName;
	}

	public int getTickettypeId() {
		return this.tickettypeId;
	}

	public void setTickettypeId(int tickettypeId) {
		this.tickettypeId = tickettypeId;
	}

	public Date getTickettypeEntryDate() {
		return this.tickettypeEntryDate;
	}

	public void setTickettypeEntryDate(Date tickettypeEntryDate) {
		this.tickettypeEntryDate = tickettypeEntryDate;
	}

	public int getTickettypeEntryId() {
		return this.tickettypeEntryId;
	}

	public void setTickettypeEntryId(int tickettypeEntryId) {
		this.tickettypeEntryId = tickettypeEntryId;
	}

	public Date getTickettypeModifiedDate() {
		return this.tickettypeModifiedDate;
	}

	public void setTickettypeModifiedDate(Date tickettypeModifiedDate) {
		this.tickettypeModifiedDate = tickettypeModifiedDate;
	}

	public int getTickettypeModifiedId() {
		return this.tickettypeModifiedId;
	}

	public void setTickettypeModifiedId(int tickettypeModifiedId) {
		this.tickettypeModifiedId = tickettypeModifiedId;
	}

	public String getTickettypeName() {
		return this.tickettypeName;
	}

	public void setTickettypeName(String tickettypeName) {
		this.tickettypeName = tickettypeName;
	}

}