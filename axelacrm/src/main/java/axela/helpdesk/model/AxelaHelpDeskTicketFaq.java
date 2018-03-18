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
 * The persistent class for the axela_helpdesk_ticket_faq database table.
 * 
 */
@Entity
@Table(name = "axela_helpdesk_ticket_faq", catalog = "axela_1")
@NamedQuery(name = "AxelaHelpDeskTicketFaq.findAll", query = "SELECT a FROM AxelaHelpDeskTicketFaq a")
public class AxelaHelpDeskTicketFaq implements Serializable {

	private static final long serialVersionUID = 1L;
	@Transient
	private int faqserviceId;

	@Transient
	private int ticketqueueId;
	@Transient
	private long ticketfaqCount;
	@Transient
	private String faqserviceName;
	@Transient
	private String ticketqueueName;
	@Transient
	private int faqserviceTicketqueueId;
	@Transient
	private long total;
	@Transient
	private long active;
	@Transient
	private long inactive;

	@Id
	@Column(name = "ticketfaq_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ticketfaqId;

	@Column(name = "ticketfaq_active")
	private String ticketfaqActive;

	@Column(name = "ticketfaq_answer")
	private String ticketfaqAnswer;

	@Column(name = "ticketfaq_entry_date")
	private Date ticketfaqEntryDate;

	@Column(name = "ticketfaq_entry_id")
	private int ticketfaqEntryId;

	@Column(name = "ticketfaq_faqservice_id")
	private int ticketfaqFaqserviceId;

	@Column(name = "ticketfaq_modified_date")
	private Date ticketfaqModifiedDate;

	@Column(name = "ticketfaq_modified_id")
	private int ticketfaqModifiedId;

	@Column(name = "ticketfaq_question")
	private String ticketfaqQuestion;

	@ManyToOne(fetch = FetchType.LAZY)
	// faqservice_id = ticketfaq_faqservice_id "
	@JoinColumn(name = "ticketfaq_faqservice_id", referencedColumnName = "faqservice_id", insertable = false, updatable = false)
	private AxelaHelpDeskTicketFaqService axelaHelpDeskTicketFaqService;

	// @OneToOne(fetch = FetchType.LAZY)
	// @NotFound(action = NotFoundAction.IGNORE)
	// // ticketqueue_id = faqhelpdesk_ticketqueue_id
	// @JoinColumn(name = "faqhelpdesk_ticketqueue_id", referencedColumnName = "ticketqueue_id", insertable = false, updatable = false)
	// private AxelaServiceTicketQueue axelaServiceTicketQueue;

	public AxelaHelpDeskTicketFaq() {
	}

	public int getTicketfaqId() {
		return this.ticketfaqId;
	}

	public void setTicketfaqId(int ticketfaqId) {
		this.ticketfaqId = ticketfaqId;
	}

	public String getTicketfaqActive() {
		return this.ticketfaqActive;
	}

	public void setTicketfaqActive(String ticketfaqActive) {
		this.ticketfaqActive = ticketfaqActive;
	}

	public String getTicketfaqAnswer() {
		return this.ticketfaqAnswer;
	}

	public void setTicketfaqAnswer(String ticketfaqAnswer) {
		this.ticketfaqAnswer = ticketfaqAnswer;
	}

	public Date getTicketfaqEntryDate() {
		return this.ticketfaqEntryDate;
	}

	public void setTicketfaqEntryDate(Date ticketfaqEntryDate) {
		this.ticketfaqEntryDate = ticketfaqEntryDate;
	}

	public int getTicketfaqEntryId() {
		return this.ticketfaqEntryId;
	}

	public void setTicketfaqEntryId(int ticketfaqEntryId) {
		this.ticketfaqEntryId = ticketfaqEntryId;
	}

	public int getTicketfaqFaqserviceId() {
		return this.ticketfaqFaqserviceId;
	}

	public void setTicketfaqFaqserviceId(int ticketfaqFaqserviceId) {
		this.ticketfaqFaqserviceId = ticketfaqFaqserviceId;
	}

	public Date getTicketfaqModifiedDate() {
		return this.ticketfaqModifiedDate;
	}

	public void setTicketfaqModifiedDate(Date ticketfaqModifiedDate) {
		this.ticketfaqModifiedDate = ticketfaqModifiedDate;
	}

	public int getTicketfaqModifiedId() {
		return this.ticketfaqModifiedId;
	}

	public void setTicketfaqModifiedId(int ticketfaqModifiedId) {
		this.ticketfaqModifiedId = ticketfaqModifiedId;
	}

	public String getTicketfaqQuestion() {
		return this.ticketfaqQuestion;
	}

	public void setTicketfaqQuestion(String ticketfaqQuestion) {
		this.ticketfaqQuestion = ticketfaqQuestion;
	}

	public int getFaqserviceId() {
		return faqserviceId;
	}

	public void setFaqserviceId(int faqserviceId) {
		this.faqserviceId = faqserviceId;
	}

	public int getTicketqueueId() {
		return ticketqueueId;
	}

	public void setTicketqueueId(int ticketqueueId) {
		this.ticketqueueId = ticketqueueId;
	}
	public String getFaqserviceName() {
		return faqserviceName;
	}

	public String getTicketqueueName() {
		return ticketqueueName;
	}

	public void setFaqserviceName(String faqserviceName) {
		this.faqserviceName = faqserviceName;
	}

	public void setTicketqueueName(String ticketqueueName) {
		this.ticketqueueName = ticketqueueName;
	}

	public int getFaqserviceTicketqueueId() {
		return faqserviceTicketqueueId;
	}

	public void setFaqserviceTicketqueueId(int faqserviceTicketqueueId) {
		this.faqserviceTicketqueueId = faqserviceTicketqueueId;
	}

	public long getTicketfaqCount() {
		return ticketfaqCount;
	}

	public void setTicketfaqCount(long ticketfaqCount) {
		this.ticketfaqCount = ticketfaqCount;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getActive() {
		return active;
	}

	public void setActive(long active) {
		this.active = active;
	}

	public long getInactive() {
		return inactive;
	}

	public void setInactive(int inactive) {
		this.inactive = inactive;
	}

	public AxelaHelpDeskTicketFaqService getAxelaServiceTicketFaqService() {
		return axelaHelpDeskTicketFaqService;
	}

	public void setAxelaServiceTicketFaqService(AxelaHelpDeskTicketFaqService axelaHelpDeskTicketFaqService) {
		this.axelaHelpDeskTicketFaqService = axelaHelpDeskTicketFaqService;
	}

	// public AxelaServiceTicketQueue getAxelaServiceTicketQueue() {
	// return axelaServiceTicketQueue;
	// }
	//
	// public void setAxelaServiceTicketQueue(AxelaServiceTicketQueue axelaServiceTicketQueue) {
	// this.axelaServiceTicketQueue = axelaServiceTicketQueue;
	// }

	public AxelaHelpDeskTicketFaq(
			int ticketfaqId,
			String ticketfaqQuestion,
			String ticketfaqAnswer,
			String ticketfaqActive,
			int ticketfaqFaqserviceId,
			int faqserviceTicketqueueId,
			String faqserviceName,
			String ticketqueueName,
			int ticketfaqEntryId,
			Date ticketfaqEntryDate,
			int ticketfaqModifiedId,
			Date ticketfaqModifiedDate) {
		super();
		this.ticketfaqId = ticketfaqId;
		this.ticketfaqQuestion = ticketfaqQuestion;
		this.ticketfaqAnswer = ticketfaqAnswer;
		this.ticketfaqActive = ticketfaqActive;
		this.ticketfaqFaqserviceId = ticketfaqFaqserviceId;
		this.faqserviceTicketqueueId = faqserviceTicketqueueId;
		this.faqserviceName = faqserviceName;
		this.ticketqueueName = ticketqueueName;
		this.ticketfaqEntryId = ticketfaqEntryId;
		this.ticketfaqEntryDate = ticketfaqEntryDate;
		this.ticketfaqModifiedId = ticketfaqModifiedId;
		this.ticketfaqModifiedDate = ticketfaqModifiedDate;
	}

	public AxelaHelpDeskTicketFaq(
			int ticketfaqId,
			String ticketfaqActive,
			String ticketfaqAnswer,
			String ticketfaqQuestion,
			String faqserviceName,
			String ticketqueueName) {

		super();
		this.ticketfaqId = ticketfaqId;
		this.ticketfaqActive = ticketfaqActive;
		this.ticketfaqAnswer = ticketfaqAnswer;
		this.ticketfaqQuestion = ticketfaqQuestion;
		this.faqserviceName = faqserviceName;
		this.ticketqueueName = ticketqueueName;
	}

	public AxelaHelpDeskTicketFaq(
			long total,
			long active,
			long inactive) {

		super();
		this.total = total;
		this.active = active;
		this.inactive = inactive;
	}

}