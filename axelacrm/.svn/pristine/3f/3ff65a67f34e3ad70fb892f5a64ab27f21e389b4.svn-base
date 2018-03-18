package axela.helpdesk.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_helpdesk_ticket_source database table.
 * 
 */
@Entity
@Table(name = "axela_helpdesk_ticket_source", catalog = "axela_1")
@NamedQuery(name = "AxelaHelpDeskTicketSource.findAll", query = "SELECT a FROM AxelaHelpDeskTicketSource a")
public class AxelaHelpDeskTicketSource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticketsource_id")
	private int ticketsourceId;

	@Column(name = "ticketsource_name")
	private String ticketsourceName;

	@Column(name = "ticketsource_rank")
	private int ticketsourceRank;

	public AxelaHelpDeskTicketSource() {
	}

	public int getTicketsourceId() {
		return this.ticketsourceId;
	}

	public void setTicketsourceId(int ticketsourceId) {
		this.ticketsourceId = ticketsourceId;
	}

	public String getTicketsourceName() {
		return this.ticketsourceName;
	}

	public void setTicketsourceName(String ticketsourceName) {
		this.ticketsourceName = ticketsourceName;
	}

	public int getTicketsourceRank() {
		return this.ticketsourceRank;
	}

	public void setTicketsourceRank(int ticketsourceRank) {
		this.ticketsourceRank = ticketsourceRank;
	}

}