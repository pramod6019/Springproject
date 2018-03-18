package axela.pm.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import axela.customer.model.AxelaCustomer;
import axela.portal.model.AxelaPmType;
import axela.sales.model.AxelaSalesOppr;

/**
 * The persistent class for the axela_pm database table.
 * 
 */
@Entity
@Table(name = "axela_pm", catalog = "axela_1")
@NamedQuery(name = "AxelaPm.findAll", query = "SELECT a FROM AxelaPm a")
public class AxelaPm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pm_id")
	private int pmId;

	@Column(name = "pm_active")
	private String pmActive;

	@Column(name = "pm_budget")
	private BigInteger pmBudget;

	@Column(name = "pm_complete")
	private String pmComplete;

	@Column(name = "pm_complete_comments")
	private String pmCompleteComments;

	@Column(name = "pm_complete_perc")
	private int pmCompletePerc;

	@Column(name = "pm_customer_id")
	private int pmCustomerId;

	@Column(name = "pm_end_date")
	private Date pmEndDate;

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public AxelaPmStatus getAxelaPmStatus() {
		return axelaPmStatus;
	}

	public void setAxelaPmStatus(AxelaPmStatus axelaPmStatus) {
		this.axelaPmStatus = axelaPmStatus;
	}

	@Column(name = "pm_entry_date")
	private Date pmEntryDate;

	@Column(name = "pm_entry_id")
	private int pmEntryId;

	@Column(name = "pm_expense")
	private BigInteger pmExpense;

	@Column(name = "pm_modified_date")
	private Date pmModifiedDate;

	@Column(name = "pm_modified_id")
	private int pmModifiedId;

	@Column(name = "pm_notes")
	private String pmNotes;

	@Column(name = "pm_pmstatus_id")
	private int pmPmstatusId;

	@Column(name = "pm_pmtype_id")
	private int pmPmtypeId;

	@Column(name = "pm_start_date")
	private Date pmStartDate;

	@Column(name = "pm_title")
	private String pmTitle;

	@Transient
	private long todayPm;
	@Transient
	private long totalPm;
	@Transient
	private long monthPm;
	@Transient
	private String customerName;
	@Transient
	private int customerId;
	@Transient
	private String statusName;
	@Transient
	private String pmtypeName;

	public AxelaPm(long monthPm,
			long todayPm,
			long totalPm) {
		super();
		this.monthPm = monthPm;
		this.todayPm = todayPm;
		this.totalPm = totalPm;
	}

	public AxelaPm(
			int pmId,
			String pmTitle,
			String customerName,
			String pmtypeName,
			int pmCompletePerc,
			String pmActive,
			BigInteger pmBudget) {

		this.pmId = pmId;
		this.pmTitle = pmTitle;
		this.customerName = customerName;
		this.pmtypeName = pmtypeName;
		this.pmCompletePerc = pmCompletePerc;
		this.pmActive = pmActive;
		this.pmBudget = pmBudget;
	}

	public AxelaPm(
			int customerId,
			String customerName,
			String pmCompleteComments,
			int pmId,
			String pmTitle,
			String statusName,
			Date pmStartDate,
			Date pmEndDate) {

		this.customerId = customerId;
		this.customerName = customerName;
		this.pmCompleteComments = pmCompleteComments;
		this.pmId = pmId;
		this.pmTitle = pmTitle;
		this.statusName = statusName;
		this.pmStartDate = pmStartDate;
		this.pmEndDate = pmEndDate;
	}
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public long getTodayPm() {
		return todayPm;
	}

	public void setTodayPm(long todayPm) {
		this.todayPm = todayPm;
	}

	public long getTotalPm() {
		return totalPm;
	}

	public void setTotalPm(long totalPm) {
		this.totalPm = totalPm;
	}

	public long getMonthPm() {
		return monthPm;
	}

	public void setMonthPm(long monthPm) {
		this.monthPm = monthPm;
	}

	public AxelaPm() {
	}

	public int getPmId() {
		return this.pmId;
	}

	public void setPmId(int pmId) {
		this.pmId = pmId;
	}

	public String getPmActive() {
		return this.pmActive;
	}

	public void setPmActive(String pmActive) {
		this.pmActive = pmActive;
	}

	public BigInteger getPmBudget() {
		return this.pmBudget;
	}

	public void setPmBudget(BigInteger pmBudget) {
		this.pmBudget = pmBudget;
	}

	public String getPmComplete() {
		return this.pmComplete;
	}

	public void setPmComplete(String pmComplete) {
		this.pmComplete = pmComplete;
	}

	public String getPmCompleteComments() {
		return this.pmCompleteComments;
	}

	public void setPmCompleteComments(String pmCompleteComments) {
		this.pmCompleteComments = pmCompleteComments;
	}

	public int getPmCompletePerc() {
		return this.pmCompletePerc;
	}

	public void setPmCompletePerc(int pmCompletePerc) {
		this.pmCompletePerc = pmCompletePerc;
	}

	public int getPmCustomerId() {
		return this.pmCustomerId;
	}

	public void setPmCustomerId(int pmCustomerId) {
		this.pmCustomerId = pmCustomerId;
	}

	public Date getPmEndDate() {
		return this.pmEndDate;
	}

	public void setPmEndDate(Date pmEndDate) {
		this.pmEndDate = pmEndDate;
	}

	public Date getPmEntryDate() {
		return this.pmEntryDate;
	}

	public void setPmEntryDate(Date pmEntryDate) {
		this.pmEntryDate = pmEntryDate;
	}

	public int getPmEntryId() {
		return this.pmEntryId;
	}

	public void setPmEntryId(int pmEntryId) {
		this.pmEntryId = pmEntryId;
	}

	public BigInteger getPmExpense() {
		return this.pmExpense;
	}

	public void setPmExpense(BigInteger pmExpense) {
		this.pmExpense = pmExpense;
	}

	public Date getPmModifiedDate() {
		return this.pmModifiedDate;
	}

	public void setPmModifiedDate(Date pmModifiedDate) {
		this.pmModifiedDate = pmModifiedDate;
	}

	public int getPmModifiedId() {
		return this.pmModifiedId;
	}

	public void setPmModifiedId(int pmModifiedId) {
		this.pmModifiedId = pmModifiedId;
	}

	public String getPmNotes() {
		return this.pmNotes;
	}

	public void setPmNotes(String pmNotes) {
		this.pmNotes = pmNotes;
	}

	public int getPmPmstatusId() {
		return this.pmPmstatusId;
	}

	public void setPmPmstatusId(int pmPmstatusId) {
		this.pmPmstatusId = pmPmstatusId;
	}

	public int getPmPmtypeId() {
		return this.pmPmtypeId;
	}

	public void setPmPmtypeId(int pmPmtypeId) {
		this.pmPmtypeId = pmPmtypeId;
	}

	public Date getPmStartDate() {
		return this.pmStartDate;
	}

	public void setPmStartDate(Date pmStartDate) {
		this.pmStartDate = pmStartDate;
	}

	public String getPmTitle() {
		return this.pmTitle;
	}

	public void setPmTitle(String pmTitle) {
		this.pmTitle = pmTitle;
	}

	@OneToMany(mappedBy = "axelaPm", cascade = CascadeType.ALL)
	@NotFound(action = NotFoundAction.IGNORE)
	private List<AxelaSalesOppr> axelaSalesOppr;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pm_customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
	private AxelaCustomer axelaCustomer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pm_pmtype_id", referencedColumnName = "pmtype_id", insertable = false, updatable = false)
	private AxelaPmType axelaPmType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pm_pmstatus_id", referencedColumnName = "pmstatus_id", insertable = false, updatable = false)
	private AxelaPmStatus axelaPmStatus;

	@OneToMany(mappedBy = "axelaPm", cascade = CascadeType.ALL)
	@NotFound(action = NotFoundAction.IGNORE)
	private List<AxelaPmExe> axelaPmExe;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPmtypeName() {
		return pmtypeName;
	}

	public void setPmtypeName(String pmtypeName) {
		this.pmtypeName = pmtypeName;
	}

	public List<AxelaSalesOppr> getAxelaSalesOppr() {
		return axelaSalesOppr;
	}

	public void setAxelaSalesOppr(List<AxelaSalesOppr> axelaSalesOppr) {
		this.axelaSalesOppr = axelaSalesOppr;
	}

	public AxelaCustomer getAxelaCustomer() {
		return axelaCustomer;
	}

	public void setAxelaCustomer(AxelaCustomer axelaCustomer) {
		this.axelaCustomer = axelaCustomer;
	}

	public AxelaPmType getAxelaPmType() {
		return axelaPmType;
	}

	public void setAxelaPmType(AxelaPmType axelaPmType) {
		this.axelaPmType = axelaPmType;
	}

	public List<AxelaPmExe> getAxelaPmExe() {
		return axelaPmExe;
	}

	public void setAxelaPmExe(List<AxelaPmExe> axelaPmExe) {
		this.axelaPmExe = axelaPmExe;
	}

}