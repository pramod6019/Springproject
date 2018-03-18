package axela.sales.model;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import axela.portal.model.AxelaEmp;

/**
 * The persistent class for the axela_sales_oppr_followup database table.
 * 
 */
@Entity
@Table(name = "axela_sales_oppr_followup", catalog = "axela_1")
@NamedQuery(name = "AxelaSalesOpprFollowup.findAll", query = "SELECT a FROM AxelaSalesOpprFollowup a")
public class AxelaSalesOpprFollowup implements Serializable {
	public String getContactMobile1() {
		return contactMobile1;
	}

	public void setContactMobile1(String contactMobile1) {
		this.contactMobile1 = contactMobile1;
	}

	private static final long serialVersionUID = 1L;

	@Transient
	private int customerId;
	@Transient
	private String customerName;
	@Transient
	private int contactId;
	@Transient
	private String titleDesc;
	@Transient
	private String contactFname;
	@Transient
	private String contactLname;
	@Transient
	private String modelName;
	@Transient
	private String itemName;
	@Transient
	private String followuptypeName;
	@Transient
	private int opprEmpId;
	@Transient
	private String opprEmpName;
	@Transient
	private String followupEmpName;
	@Transient
	private String contactMobile1;

	public String getFollowupEmpName() {
		return followupEmpName;
	}

	public void setFollowupEmpName(String followupEmpName) {
		this.followupEmpName = followupEmpName;
	}

	public String getFollowuptypeName() {
		return followuptypeName;
	}

	public void setFollowuptypeName(String followuptypeName) {
		this.followuptypeName = followuptypeName;
	}

	public int getOpprEmpId() {
		return opprEmpId;
	}

	public void setOpprEmpId(int opprEmpId) {
		this.opprEmpId = opprEmpId;
	}

	public String getOpprEmpName() {
		return opprEmpName;
	}

	public void setOpprEmpName(String opprEmpName) {
		this.opprEmpName = opprEmpName;
	}

	@Id
	@Column(name = "followup_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int followupId;

	@Column(name = "followup_desc")
	private String followupDesc;

	@Column(name = "followup_emp_id")
	private int followupEmpId;

	@Column(name = "followup_entry_id")
	private int followupEntryId;

	@Column(name = "followup_entry_time")
	private Date followupEntryTime;

	@Column(name = "followup_feedbacktype_id")
	private int followupFeedbacktypeId;

	@Column(name = "followup_followup_time")
	private Date followupFollowupTime;

	@Column(name = "followup_followuptype_id")
	private int followupFollowuptypeId;

	@Column(name = "followup_modified_id")
	private int followupModifiedId;

	@Column(name = "followup_modified_time")
	private Date followupModifiedTime;

	@Column(name = "followup_notify")
	private int followupNotify;

	@Column(name = "followup_oppr_id")
	private int followupOpprId;

	@Column(name = "followup_trigger")
	private int followupTrigger;

	public AxelaSalesOpprFollowup() {
	}

	public AxelaSalesOpprFollowup(
			int customerId,
			String customerName,
			int contactId,
			String titleDesc,
			String contactFname,
			String contactLname,
			String contactMobile1,
			String modelName,
			String itemName) {

		super();
		this.contactMobile1 = contactMobile1;
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactId = contactId;
		this.titleDesc = titleDesc;
		this.contactFname = contactFname;
		this.contactLname = contactLname;
		this.modelName = modelName;
		this.itemName = itemName;
	}

	public AxelaSalesOpprFollowup(
			int followupId,
			int followupOpprId,
			Date followupFollowupTime,
			String followupDesc,
			Date followupEntryTime,
			int followupEntryId,
			String followuptypeName,
			int followupModifiedId,
			int opprEmpId,
			String opprEmpName) {
		this.followupId = followupId;
		this.followupOpprId = followupOpprId;
		this.followupFollowupTime = followupFollowupTime;
		this.followupDesc = followupDesc;
		this.followupEntryTime = followupEntryTime;
		this.followupEntryId = followupEntryId;
		this.followuptypeName = followuptypeName;
		this.opprEmpId = opprEmpId;
		this.opprEmpName = opprEmpName;
		this.followupModifiedId = followupModifiedId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getFollowupId() {
		return this.followupId;
	}

	public void setFollowupId(int followupId) {
		this.followupId = followupId;
	}

	public String getFollowupDesc() {
		return this.followupDesc;
	}

	public void setFollowupDesc(String followupDesc) {
		this.followupDesc = followupDesc;
	}

	public int getFollowupEmpId() {
		return this.followupEmpId;
	}

	public void setFollowupEmpId(int followupEmpId) {
		this.followupEmpId = followupEmpId;
	}

	public int getFollowupEntryId() {
		return this.followupEntryId;
	}

	public void setFollowupEntryId(int followupEntryId) {
		this.followupEntryId = followupEntryId;
	}

	public Date getFollowupEntryTime() {
		return this.followupEntryTime;
	}

	public void setFollowupEntryTime(Date followupEntryTime) {
		this.followupEntryTime = followupEntryTime;
	}

	public int getFollowupFeedbacktypeId() {
		return this.followupFeedbacktypeId;
	}

	public void setFollowupFeedbacktypeId(int followupFeedbacktypeId) {
		this.followupFeedbacktypeId = followupFeedbacktypeId;
	}

	public Date getFollowupFollowupTime() {
		return this.followupFollowupTime;
	}

	public void setFollowupFollowupTime(Date followupFollowupTime) {
		this.followupFollowupTime = followupFollowupTime;
	}

	public int getFollowupFollowuptypeId() {
		return this.followupFollowuptypeId;
	}

	public void setFollowupFollowuptypeId(int followupFollowuptypeId) {
		this.followupFollowuptypeId = followupFollowuptypeId;
	}

	public int getFollowupModifiedId() {
		return this.followupModifiedId;
	}

	public void setFollowupModifiedId(int followupModifiedId) {
		this.followupModifiedId = followupModifiedId;
	}

	public Date getFollowupModifiedTime() {
		return this.followupModifiedTime;
	}

	public void setFollowupModifiedTime(Date followupModifiedTime) {
		this.followupModifiedTime = followupModifiedTime;
	}

	public int getFollowupNotify() {
		return this.followupNotify;
	}

	public void setFollowupNotify(int followupNotify) {
		this.followupNotify = followupNotify;
	}

	public int getFollowupOpprId() {
		return this.followupOpprId;
	}

	public void setFollowupOpprId(int followupOpprId) {
		this.followupOpprId = followupOpprId;
	}

	public int getFollowupTrigger() {
		return this.followupTrigger;
	}

	public void setFollowupTrigger(int followupTrigger) {
		this.followupTrigger = followupTrigger;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "followup_oppr_id", referencedColumnName = "oppr_id", insertable = false, updatable = false)
	private AxelaSalesOppr axelaSalesOppr;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getTitleDesc() {
		return titleDesc;
	}

	public void setTitleDesc(String titleDesc) {
		this.titleDesc = titleDesc;
	}

	public String getContactFname() {
		return contactFname;
	}

	public void setContactFname(String contactFname) {
		this.contactFname = contactFname;
	}

	public String getContactLname() {
		return contactLname;
	}

	public void setContactLname(String contactLname) {
		this.contactLname = contactLname;
	}

	public AxelaEmp getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(AxelaEmp axelaEmp) {
		this.axelaEmp = axelaEmp;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "followup_followuptype_id", referencedColumnName = "followuptype_id", insertable = false, updatable = false)
	private AxelaSalesOpprFollowupType axelaSalesOpprFollowupType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "followup_emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

	public AxelaSalesOppr getAxelaSalesOppr() {
		return axelaSalesOppr;
	}

	public void setAxelaSalesOppr(AxelaSalesOppr axelaSalesOppr) {
		this.axelaSalesOppr = axelaSalesOppr;
	}

	public AxelaSalesOpprFollowupType getAxelaSalesOpprFollowupType() {
		return axelaSalesOpprFollowupType;
	}

	public void setAxelaSalesOpprFollowupType(AxelaSalesOpprFollowupType axelaSalesOpprFollowupType) {
		this.axelaSalesOpprFollowupType = axelaSalesOpprFollowupType;
	}

}