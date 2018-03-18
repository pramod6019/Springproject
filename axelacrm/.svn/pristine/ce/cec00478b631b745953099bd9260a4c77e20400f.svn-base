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
 * The persistent class for the axela_helpdesk_ticket_priority database table.
 * 
 */
@Entity
@Table(name = "axela_helpdesk_ticket_priority", catalog = "axela_1")
@NamedQuery(name = "AxelaHelpDeskTicketPriority.findAll", query = "SELECT a FROM AxelaHelpDeskTicketPriority a")
public class AxelaHelpDeskTicketPriority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "priorityticket_id")
	private int priorityticketId;

	@Column(name = "priorityticket_name")
	private String priorityticketName;

	@Column(name = "priorityticket_rank")
	private int priorityticketRank;

	public AxelaHelpDeskTicketPriority() {
	}

	public int getPriorityticketId() {
		return this.priorityticketId;
	}

	public void setPriorityticketId(int priorityticketId) {
		this.priorityticketId = priorityticketId;
	}

	public String getPriorityticketName() {
		return this.priorityticketName;
	}

	public void setPriorityticketName(String priorityticketName) {
		this.priorityticketName = priorityticketName;
	}

	public int getPriorityticketRank() {

		return this.priorityticketRank;
	}

	public void setPriorityticketRank(int priorityticketRank) {
		this.priorityticketRank = priorityticketRank;
	}

}