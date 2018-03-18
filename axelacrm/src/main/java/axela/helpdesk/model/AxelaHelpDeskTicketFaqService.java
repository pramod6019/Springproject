package axela.helpdesk.model;

import java.io.Serializable;
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

/**
 * The persistent class for the axela_helpdesk_ticket_faq_service database table.
 * 
 */
@Entity
@Table(name = "axela_helpdesk_ticket_faq_service", catalog = "axela_1")
@NamedQuery(name = "AxelaHelpDeskTicketFaqService.findAll", query = "SELECT a FROM AxelaHelpDeskTicketFaqService a")
public class AxelaHelpDeskTicketFaqService implements Serializable {

	private static final long serialVersionUID = 1L;

	// tranient prpoperty
	@Transient
	private String ticketqueueName;

	@Transient
	private long faqserviceCount = 0;

	public String getTicketqueueName() {
		return ticketqueueName;
	}

	public void setTicketqueueName(String ticketqueueName) {
		this.ticketqueueName = ticketqueueName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "faqservice_id")
	private int faqserviceId;

	@Column(name = "faqservice_name")
	private String faqserviceName;

	@Column(name = "faqservice_ticketqueue_id")
	private int faqserviceTicketqueueId;

	public AxelaHelpDeskTicketFaqService() {
	}

	public AxelaHelpDeskTicketFaqService(int faqserviceId, String faqserviceName, String ticketqueueName, long faqserviceCount) {
		super();
		this.faqserviceId = faqserviceId;
		this.faqserviceName = faqserviceName;
		this.ticketqueueName = ticketqueueName;
		this.faqserviceCount = faqserviceCount;
	}

	// many-to-one association to AxelaServiceTicketQueue
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "faqservice_ticketqueue_id", referencedColumnName = "ticketqueue_id", insertable = false, updatable = false)
	private AxelaHelpDeskTicketQueue axelaHelpDeskTicketQueue;

	public AxelaHelpDeskTicketQueue getAxelaServiceTicketQueue() {
		return axelaHelpDeskTicketQueue;
	}

	public void setAxelaServiceTicketQueue(AxelaHelpDeskTicketQueue axelaHelpDeskTicketQueue) {
		this.axelaHelpDeskTicketQueue = axelaHelpDeskTicketQueue;
	}
	public int getFaqserviceId() {
		return this.faqserviceId;
	}

	public void setFaqserviceId(int faqserviceId) {
		this.faqserviceId = faqserviceId;
	}

	public String getFaqserviceName() {
		return this.faqserviceName;
	}

	public void setFaqserviceName(String faqserviceName) {
		this.faqserviceName = faqserviceName;
	}

	public int getFaqserviceTicketqueueId() {
		return this.faqserviceTicketqueueId;
	}

	public void setFaqserviceTicketqueueId(int faqserviceTicketqueueId) {
		this.faqserviceTicketqueueId = faqserviceTicketqueueId;
	}

	@OneToMany(mappedBy = "axelaHelpDeskTicketFaqService")
	private List<AxelaHelpDeskTicketFaq> axelaHelpDeskTicketFaq;

	// @ManyToOne
	// @NotFound(action = NotFoundAction.IGNORE)
	// @JoinColumn(name = "faqhelpdesk_ticketqueue_id", referencedColumnName = "ticketqueue_id", insertable = false, updatable = false)
	// private AxelaServiceTicketQueue axelaServiceTicketQueue;

	public List<AxelaHelpDeskTicketFaq> getAxelaServiceTicketFaq() {
		return axelaHelpDeskTicketFaq;
	}

	// public AxelaServiceTicketQueue getAxelaServiceTicketQueue() {
	// return axelaServiceTicketQueue;
	// }

	public void setAxelaServiceTicketFaq(List<AxelaHelpDeskTicketFaq> axelaHelpDeskTicketFaq) {
		this.axelaHelpDeskTicketFaq = axelaHelpDeskTicketFaq;
	}

	// public void setAxelaServiceTicketQueue(AxelaServiceTicketQueue axelaServiceTicketQueue) {
	// this.axelaServiceTicketQueue = axelaServiceTicketQueue;
	// }
}