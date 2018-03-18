package axela.helpdesk.model;

import java.io.Serializable;

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

/**
 * The persistent class for the axela_faq database table.
 * 
 */
@Entity
@Table(name = "axela_faq", catalog = "axela_1")
@NamedQuery(name = "AxelaFaq.findAll", query = "SELECT a FROM AxelaFaq a")
public class AxelaFaq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "faq_id")
	private int faqId;

	@Column(name = "faq_active")
	private String faqActive;

	@Column(name = "faq_answer")
	private String faqAnswer;

	@Column(name = "faq_cat_id")
	private int faqCatId;

	@Column(name = "faq_entry_date")
	private String faqEntryDate;

	@Column(name = "faq_entry_id")
	private int faqEntryId;

	@Column(name = "faq_modified_date")
	private String faqModifiedDate;

	@Column(name = "faq_modified_id")
	private int faqModifiedId;

	@Column(name = "faq_question")
	private String faqQuestion;

	@Column(name = "faq_rank")
	private int faqRank;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "faq_cat_id", referencedColumnName = "cat_id", insertable = false, updatable = false)
	private AxelaFaqCat axelaFaqCat;

	public AxelaFaq() {
	}

	public int getFaqId() {
		return this.faqId;
	}

	public void setFaqId(int faqId) {
		this.faqId = faqId;
	}

	public String getFaqActive() {
		return this.faqActive;
	}

	public void setFaqActive(String faqActive) {
		this.faqActive = faqActive;
	}

	public String getFaqAnswer() {
		return this.faqAnswer;
	}

	public void setFaqAnswer(String faqAnswer) {
		this.faqAnswer = faqAnswer;
	}

	public int getFaqCatId() {
		return this.faqCatId;
	}

	public void setFaqCatId(int faqCatId) {
		this.faqCatId = faqCatId;
	}

	public String getFaqEntryDate() {
		return this.faqEntryDate;
	}

	public void setFaqEntryDate(String faqEntryDate) {
		this.faqEntryDate = faqEntryDate;
	}

	public int getFaqEntryId() {
		return this.faqEntryId;
	}

	public void setFaqEntryId(int faqEntryId) {
		this.faqEntryId = faqEntryId;
	}

	public String getFaqModifiedDate() {
		return this.faqModifiedDate;
	}

	public void setFaqModifiedDate(String faqModifiedDate) {
		this.faqModifiedDate = faqModifiedDate;
	}

	public int getFaqModifiedId() {
		return this.faqModifiedId;
	}

	public void setFaqModifiedId(int faqModifiedId) {
		this.faqModifiedId = faqModifiedId;
	}

	public String getFaqQuestion() {
		return this.faqQuestion;
	}

	public void setFaqQuestion(String faqQuestion) {
		this.faqQuestion = faqQuestion;
	}

	public int getFaqRank() {
		return this.faqRank;
	}

	public void setFaqRank(int faqRank) {
		this.faqRank = faqRank;
	}

}