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
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import axela.portal.model.AxelaCrmFeedbacktype;
import axela.portal.model.AxelaEmp;
import axela.portal.model.AxelaSalesCrmday;

/**
 * The persistent class for the axela_sales_crm database table.
 * 
 */
@Entity
@Table(name = "axela_sales_crm", catalog = "axela_1")
@NamedQuery(name = "AxelaSalesCrm.findAll", query = "SELECT a FROM AxelaSalesCrm a")
public class AxelaSalesCrm implements Serializable {
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
	private String contactMobile1;
	@Transient
	private String itemName;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "crm_id")
	private int crmId;

	@Column(name = "crm_cancelreason_id")
	private int crmCancelreasonId;

	@Column(name = "crm_crmconcern_id")
	private int crmCrmconcernId;

	@Column(name = "crm_crmdays_id")
	private int crmCrmdaysId;

	@Column(name = "crm_crmfeedbacktype_id")
	private int crmCrmfeedbacktypeId;

	@Column(name = "crm_crmfollowupid")
	private int crmCrmfollowupid;

	@Column(name = "crm_desc")
	private String crmDesc;

	@Column(name = "crm_email1")
	private String crmEmail1;

	@Column(name = "crm_email2")
	private String crmEmail2;

	@Column(name = "crm_emp_id")
	private int crmEmpId;

	@Column(name = "crm_entry_id")
	private int crmEntryId;

	@Column(name = "crm_entry_time")
	private Date crmEntryTime;

	@Column(name = "crm_followup_time")
	private Date crmFollowupTime;

	@Column(name = "crm_lostcase1_id")
	private int crmLostcase1Id;

	@Column(name = "crm_lostcase2_id")
	private int crmLostcase2Id;

	@Column(name = "crm_lostcase3_id")
	private int crmLostcase3Id;

	@Column(name = "crm_mobile1")
	private String crmMobile1;

	@Column(name = "crm_mobile2")
	private String crmMobile2;

	@Column(name = "crm_modified_id")
	private int crmModifiedId;

	@Column(name = "crm_modified_time")
	private Date crmModifiedTime;

	@Column(name = "crm_oppr_id")
	private int crmOpprId;

	@Column(name = "crm_psffollowupid")
	private int crmPsffollowupid;

	@Column(name = "crm_refcrmdays_id")
	private int crmRefcrmdaysId;

	@Column(name = "crm_satisfied")
	private int crmSatisfied;

	@Column(name = "crm_so_id")
	private int crmSoId;

	@Column(name = "crm_ticket_emp_id")
	private int crmTicketEmpId;

	@Column(name = "crm_trigger")
	private int crmTrigger;

	public AxelaSalesCrm() {
	}

	public AxelaSalesCrm(int crmId,
			int crmOppId,
			Date crmFollowupTime,
			int crmSoId,
			String crmDesc,
			Date crmEntryTime,
			int crmEntryId,
			int crmModifiedId,
			Date crmModifiedTime,
			String crmfeedbacktypeName,
			String empName,
			int crmdaysDaycount,
			String crmdaysDesc,
			int crmEmpId,
			String crmtypeName,
			int crmtypeId) {
		super();
		this.crmId = crmId;
		this.crmOppId = crmOppId;
		this.crmFollowupTime = crmFollowupTime;
		this.crmSoId = crmSoId;
		this.crmDesc = crmDesc;
		this.crmEntryTime = crmEntryTime;
		this.crmEntryId = crmEntryId;
		this.crmModifiedId = crmModifiedId;
		this.crmModifiedTime = crmModifiedTime;
		this.crmfeedbacktypeName = crmfeedbacktypeName;
		this.empName = empName;
		this.crmdaysDaycount = crmdaysDaycount;
		this.crmdaysDesc = crmdaysDesc;
		this.crmEmpId = crmEmpId;
		this.crmtypeName = crmtypeName;
		this.crmtypeId = crmtypeId;
	}
	public int getCustomerId() {
		return customerId;
	}
	@Transient
	private int crmOppId;

	@Transient
	private String crmfeedbacktypeName;

	@Transient
	private String empName;

	@Transient
	private int crmdaysDaycount;

	@Transient
	private String crmdaysDesc;

	@Transient
	private String crmtypeName;

	@Transient
	private int crmtypeId;

	public int getCrmOppId() {
		return crmOppId;
	}

	public void setCrmOppId(int crmOppId) {
		this.crmOppId = crmOppId;
	}

	public String getCrmfeedbacktypeName() {
		return crmfeedbacktypeName;
	}

	public void setCrmfeedbacktypeName(String crmfeedbacktypeName) {
		this.crmfeedbacktypeName = crmfeedbacktypeName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getCrmdaysDaycount() {
		return crmdaysDaycount;
	}

	public void setCrmdaysDaycount(int crmdaysDaycount) {
		this.crmdaysDaycount = crmdaysDaycount;
	}

	public String getCrmdaysDesc() {
		return crmdaysDesc;
	}

	public void setCrmdaysDesc(String crmdaysDesc) {
		this.crmdaysDesc = crmdaysDesc;
	}

	public String getCrmtypeName() {
		return crmtypeName;
	}

	public void setCrmtypeName(String crmtypeName) {
		this.crmtypeName = crmtypeName;
	}

	public int getCrmtypeId() {
		return crmtypeId;
	}

	public void setCrmtypeId(int crmtypeId) {
		this.crmtypeId = crmtypeId;
	}

	public AxelaCrmFeedbacktype getAxelaCrmFeedbacktype() {
		return axelaCrmFeedbacktype;
	}

	public void setAxelaCrmFeedbacktype(AxelaCrmFeedbacktype axelaCrmFeedbacktype) {
		this.axelaCrmFeedbacktype = axelaCrmFeedbacktype;
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

	public String getContactMobile1() {
		return contactMobile1;
	}

	public void setContactMobile1(String contactMobile1) {
		this.contactMobile1 = contactMobile1;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public AxelaSalesOppr getAxelaSalesOppr() {
		return axelaSalesOppr;
	}

	public void setAxelaSalesOppr(AxelaSalesOppr axelaSalesOppr) {
		this.axelaSalesOppr = axelaSalesOppr;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "crm_oppr_id", referencedColumnName = "oppr_id", insertable = false, updatable = false)
	private AxelaSalesOppr axelaSalesOppr;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "crm_crmdays_id", referencedColumnName = "crmdays_id", insertable = false, updatable = false)
	private AxelaSalesCrmday axelaSalesCrmday;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "crm_crmfeedbacktype_id", referencedColumnName = "crmfeedbacktype_id", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	private AxelaCrmFeedbacktype axelaCrmFeedbacktype;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "crm_emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	private AxelaEmp axelaEmp;

	public AxelaEmp getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(AxelaEmp axelaEmp) {
		this.axelaEmp = axelaEmp;
	}

	public AxelaSalesCrmday getAxelaSalesCrmday() {
		return axelaSalesCrmday;
	}

	public void setAxelaSalesCrmday(AxelaSalesCrmday axelaSalesCrmday) {
		this.axelaSalesCrmday = axelaSalesCrmday;
	}

	public int getCrmId() {
		return this.crmId;
	}

	public void setCrmId(int crmId) {
		this.crmId = crmId;
	}

	public int getCrmCancelreasonId() {
		return this.crmCancelreasonId;
	}

	public void setCrmCancelreasonId(int crmCancelreasonId) {
		this.crmCancelreasonId = crmCancelreasonId;
	}

	public int getCrmCrmconcernId() {
		return this.crmCrmconcernId;
	}

	public void setCrmCrmconcernId(int crmCrmconcernId) {
		this.crmCrmconcernId = crmCrmconcernId;
	}

	public int getCrmCrmdaysId() {
		return this.crmCrmdaysId;
	}

	public void setCrmCrmdaysId(int crmCrmdaysId) {
		this.crmCrmdaysId = crmCrmdaysId;
	}

	public int getCrmCrmfeedbacktypeId() {
		return this.crmCrmfeedbacktypeId;
	}

	public void setCrmCrmfeedbacktypeId(int crmCrmfeedbacktypeId) {
		this.crmCrmfeedbacktypeId = crmCrmfeedbacktypeId;
	}

	public int getCrmCrmfollowupid() {
		return this.crmCrmfollowupid;
	}

	public void setCrmCrmfollowupid(int crmCrmfollowupid) {
		this.crmCrmfollowupid = crmCrmfollowupid;
	}

	public String getCrmDesc() {
		return this.crmDesc;
	}

	public void setCrmDesc(String crmDesc) {
		this.crmDesc = crmDesc;
	}

	public String getCrmEmail1() {
		return this.crmEmail1;
	}

	public void setCrmEmail1(String crmEmail1) {
		this.crmEmail1 = crmEmail1;
	}

	public String getCrmEmail2() {
		return this.crmEmail2;
	}

	public void setCrmEmail2(String crmEmail2) {
		this.crmEmail2 = crmEmail2;
	}

	public int getCrmEmpId() {
		return this.crmEmpId;
	}

	public void setCrmEmpId(int crmEmpId) {
		this.crmEmpId = crmEmpId;
	}

	public int getCrmEntryId() {
		return this.crmEntryId;
	}

	public void setCrmEntryId(int crmEntryId) {
		this.crmEntryId = crmEntryId;
	}

	public Date getCrmEntryTime() {
		return this.crmEntryTime;
	}

	public void setCrmEntryTime(Date crmEntryTime) {
		this.crmEntryTime = crmEntryTime;
	}

	public Date getCrmFollowupTime() {
		return this.crmFollowupTime;
	}

	public void setCrmFollowupTime(Date crmFollowupTime) {
		this.crmFollowupTime = crmFollowupTime;
	}

	public int getCrmLostcase1Id() {
		return this.crmLostcase1Id;
	}

	public void setCrmLostcase1Id(int crmLostcase1Id) {
		this.crmLostcase1Id = crmLostcase1Id;
	}

	public int getCrmLostcase2Id() {
		return this.crmLostcase2Id;
	}

	public void setCrmLostcase2Id(int crmLostcase2Id) {
		this.crmLostcase2Id = crmLostcase2Id;
	}

	public int getCrmLostcase3Id() {
		return this.crmLostcase3Id;
	}

	public void setCrmLostcase3Id(int crmLostcase3Id) {
		this.crmLostcase3Id = crmLostcase3Id;
	}

	public String getCrmMobile1() {
		return this.crmMobile1;
	}

	public void setCrmMobile1(String crmMobile1) {
		this.crmMobile1 = crmMobile1;
	}

	public String getCrmMobile2() {
		return this.crmMobile2;
	}

	public void setCrmMobile2(String crmMobile2) {
		this.crmMobile2 = crmMobile2;
	}

	public int getCrmModifiedId() {
		return this.crmModifiedId;
	}

	public void setCrmModifiedId(int crmModifiedId) {
		this.crmModifiedId = crmModifiedId;
	}

	public Date getCrmModifiedTime() {
		return this.crmModifiedTime;
	}

	public void setCrmModifiedTime(Date crmModifiedTime) {
		this.crmModifiedTime = crmModifiedTime;
	}

	public int getCrmOpprId() {
		return this.crmOpprId;
	}

	public void setCrmOpprId(int crmOpprId) {
		this.crmOpprId = crmOpprId;
	}

	public int getCrmPsffollowupid() {
		return this.crmPsffollowupid;
	}

	public void setCrmPsffollowupid(int crmPsffollowupid) {
		this.crmPsffollowupid = crmPsffollowupid;
	}

	public int getCrmRefcrmdaysId() {
		return this.crmRefcrmdaysId;
	}

	public void setCrmRefcrmdaysId(int crmRefcrmdaysId) {
		this.crmRefcrmdaysId = crmRefcrmdaysId;
	}

	public int getCrmSatisfied() {
		return this.crmSatisfied;
	}

	public void setCrmSatisfied(int crmSatisfied) {
		this.crmSatisfied = crmSatisfied;
	}

	public int getCrmSoId() {
		return this.crmSoId;
	}

	public void setCrmSoId(int crmSoId) {
		this.crmSoId = crmSoId;
	}

	public int getCrmTicketEmpId() {
		return this.crmTicketEmpId;
	}

	public void setCrmTicketEmpId(int crmTicketEmpId) {
		this.crmTicketEmpId = crmTicketEmpId;
	}

	public int getCrmTrigger() {
		return this.crmTrigger;
	}

	public void setCrmTrigger(int crmTrigger) {
		this.crmTrigger = crmTrigger;
	}

}