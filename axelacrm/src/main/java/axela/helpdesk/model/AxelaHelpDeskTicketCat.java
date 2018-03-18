package axela.helpdesk.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_helpdesk_ticket_cat database table.
 * 
 */
@Entity
@Table(name = "axela_helpdesk_ticket_cat", catalog = "axela_1")
@NamedQuery(name = "AxelaHelpDeskTicketCat.findAll", query = "SELECT a FROM AxelaHelpDeskTicketCat a")
public class AxelaHelpDeskTicketCat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticketcat_id")
	private int ticketcatId;

	@Column(name = "ticketcat_entry_date")
	private Date ticketcatEntryDate;

	@Column(name = "ticketcat_entry_id")
	private int ticketcatEntryId;

	@Column(name = "ticketcat_modified_date")
	private Date ticketcatModifiedDate;

	@Column(name = "ticketcat_modified_id")
	private int ticketcatModifiedId;

	@Column(name = "ticketcat_name")
	private String ticketcatName;

	public AxelaHelpDeskTicketCat() {
	}

	public AxelaHelpDeskTicketCat(
			int ticketcatId,
			Date ticketcatEntryDate,
			int ticketcatEntryId,
			Date ticketcatModifiedDate,
			int ticketcatModifiedId,
			String ticketcatName) {
		super();
		this.ticketcatId = ticketcatId;
		this.ticketcatEntryDate = ticketcatEntryDate;
		this.ticketcatEntryId = ticketcatEntryId;
		this.ticketcatModifiedDate = ticketcatModifiedDate;
		this.ticketcatModifiedId = ticketcatModifiedId;
		this.ticketcatName = ticketcatName;
	}

	public int getTicketcatId() {
		return this.ticketcatId;
	}

	public void setTicketcatId(int ticketcatId) {
		this.ticketcatId = ticketcatId;
	}

	public Date getTicketcatEntryDate() {
		return this.ticketcatEntryDate;
	}

	public void setTicketcatEntryDate(Date ticketcatEntryDate) {
		this.ticketcatEntryDate = ticketcatEntryDate;
	}

	public int getTicketcatEntryId() {
		return this.ticketcatEntryId;
	}

	public void setTicketcatEntryId(int ticketcatEntryId) {
		this.ticketcatEntryId = ticketcatEntryId;
	}

	public Date getTicketcatModifiedDate() {
		return this.ticketcatModifiedDate;
	}

	public void setTicketcatModifiedDate(Date ticketcatModifiedDate) {
		this.ticketcatModifiedDate = ticketcatModifiedDate;
	}

	public int getTicketcatModifiedId() {
		return this.ticketcatModifiedId;
	}

	public void setTicketcatModifiedId(int ticketcatModifiedId) {
		this.ticketcatModifiedId = ticketcatModifiedId;
	}

	public String getTicketcatName() {
		return this.ticketcatName;
	}

	public void setTicketcatName(String ticketcatName) {
		this.ticketcatName = ticketcatName;
	}

}