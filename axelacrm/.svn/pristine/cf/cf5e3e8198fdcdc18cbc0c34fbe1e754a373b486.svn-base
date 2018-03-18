package axela.portal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import axela.sales.model.AxelaSalesCrm;

/**
 * The persistent class for the axela_sales_crmdays database table.
 * 
 */
@Entity
@Table(name = "axela_sales_crmdays", catalog = "axela_1")
@NamedQuery(name = "AxelaSalesCrmday.findAll", query = "SELECT a FROM AxelaSalesCrmday a")
public class AxelaSalesCrmday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "crmdays_id")
	private int crmdaysId;

	// @ManyToOne
	// @JoinColumn(name = "crm_crmfeedbacktype_id", referencedColumnName = "crmtype_id")
	// @NotFound(action = NotFoundAction.IGNORE)
	// private AxelaSalesCrmType axelaSalesCrmType;

	@Column(name = "crmdays_active")
	private String crmdaysActive;

	@Column(name = "crmdays_contactable_email_enable")
	private String crmdaysContactableEmailEnable;

	@Lob
	@Column(name = "crmdays_contactable_email_exe_format")
	private String crmdaysContactableEmailExeFormat;

	@Column(name = "crmdays_contactable_email_exe_sub")
	private String crmdaysContactableEmailExeSub;

	@Lob
	@Column(name = "crmdays_contactable_email_format")
	private String crmdaysContactableEmailFormat;

	@Column(name = "crmdays_contactable_email_sub")
	private String crmdaysContactableEmailSub;

	@Column(name = "crmdays_contactable_sms_enable")
	private String crmdaysContactableSmsEnable;

	@Column(name = "crmdays_contactable_sms_exe_format")
	private String crmdaysContactableSmsExeFormat;

	@Column(name = "crmdays_contactable_sms_format")
	private String crmdaysContactableSmsFormat;

	@Column(name = "crmdays_crmtype_id")
	private int crmdaysCrmtypeId;

	@Column(name = "crmdays_daycount")
	private int crmdaysDaycount;

	@Column(name = "crmdays_desc")
	private String crmdaysDesc;

	@Column(name = "crmdays_dissatisfied_email_enable")
	private String crmdaysDissatisfiedEmailEnable;

	@Lob
	@Column(name = "crmdays_dissatisfied_email_exe_format")
	private String crmdaysDissatisfiedEmailExeFormat;

	@Column(name = "crmdays_dissatisfied_email_exe_sub")
	private String crmdaysDissatisfiedEmailExeSub;

	@Lob
	@Column(name = "crmdays_dissatisfied_email_format")
	private String crmdaysDissatisfiedEmailFormat;

	@Column(name = "crmdays_dissatisfied_email_sub")
	private String crmdaysDissatisfiedEmailSub;

	@Column(name = "crmdays_dissatisfied_sms_enable")
	private String crmdaysDissatisfiedSmsEnable;

	@Column(name = "crmdays_dissatisfied_sms_exe_format")
	private String crmdaysDissatisfiedSmsExeFormat;

	@Column(name = "crmdays_dissatisfied_sms_format")
	private String crmdaysDissatisfiedSmsFormat;

	@Column(name = "crmdays_entry_date")
	private String crmdaysEntryDate;

	@Column(name = "crmdays_entry_id")
	private int crmdaysEntryId;

	@Column(name = "crmdays_exe_type")
	private int crmdaysExeType;

	@Column(name = "crmdays_homevisitfollowup")
	private String crmdaysHomevisitfollowup;

	@Column(name = "crmdays_lostfollowup")
	private String crmdaysLostfollowup;

	@Column(name = "crmdays_modified_date")
	private String crmdaysModifiedDate;

	@Column(name = "crmdays_modified_id")
	private int crmdaysModifiedId;

	@Column(name = "crmdays_noncontactable_email_enable")
	private String crmdaysNoncontactableEmailEnable;

	@Lob
	@Column(name = "crmdays_noncontactable_email_exe_format")
	private String crmdaysNoncontactableEmailExeFormat;

	@Column(name = "crmdays_noncontactable_email_exe_sub")
	private String crmdaysNoncontactableEmailExeSub;

	@Lob
	@Column(name = "crmdays_noncontactable_email_format")
	private String crmdaysNoncontactableEmailFormat;

	@Column(name = "crmdays_noncontactable_email_sub")
	private String crmdaysNoncontactableEmailSub;

	@Column(name = "crmdays_noncontactable_sms_enable")
	private String crmdaysNoncontactableSmsEnable;

	@Column(name = "crmdays_noncontactable_sms_exe_format")
	private String crmdaysNoncontactableSmsExeFormat;

	@Column(name = "crmdays_noncontactable_sms_format")
	private String crmdaysNoncontactableSmsFormat;

	@Column(name = "crmdays_refcrmdays_id")
	private int crmdaysRefcrmdaysId;

	@Column(name = "crmdays_satisfied_email_enable")
	private String crmdaysSatisfiedEmailEnable;

	@Lob
	@Column(name = "crmdays_satisfied_email_exe_format")
	private String crmdaysSatisfiedEmailExeFormat;

	@Column(name = "crmdays_satisfied_email_exe_sub")
	private String crmdaysSatisfiedEmailExeSub;

	@Lob
	@Column(name = "crmdays_satisfied_email_format")
	private String crmdaysSatisfiedEmailFormat;

	@Column(name = "crmdays_satisfied_email_sub")
	private String crmdaysSatisfiedEmailSub;

	@Column(name = "crmdays_satisfied_sms_enable")
	private String crmdaysSatisfiedSmsEnable;

	@Column(name = "crmdays_satisfied_sms_exe_format")
	private String crmdaysSatisfiedSmsExeFormat;

	@Column(name = "crmdays_satisfied_sms_format")
	private String crmdaysSatisfiedSmsFormat;

	@Column(name = "crmdays_script")
	private String crmdaysScript;

	@Column(name = "crmdays_so_inactive")
	private String crmdaysSoInactive;

	public List<AxelaSalesCrm> getAxelaSalesCrm() {
		return axelaSalesCrm;
	}

	public void setAxelaSalesCrm(List<AxelaSalesCrm> axelaSalesCrm) {
		this.axelaSalesCrm = axelaSalesCrm;
	}

	@Column(name = "crmdays_testdrivefollowup")
	private String crmdaysTestdrivefollowup;

	@Column(name = "crmdays_waitingperiod")
	private String crmdaysWaitingperiod;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "crmdays_crmtype_id", referencedColumnName = "crmtype_id", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	private AxelaSalesCrmType axelaSalesCrmType;

	@OneToMany(mappedBy = "axelaSalesCrmday", cascade = CascadeType.ALL)
	private List<AxelaSalesCrm> axelaSalesCrm;

	public AxelaSalesCrmType getAxelaSalesCrmType() {
		return axelaSalesCrmType;
	}

	public void setAxelaSalesCrmType(AxelaSalesCrmType axelaSalesCrmType) {
		this.axelaSalesCrmType = axelaSalesCrmType;
	}

	public AxelaSalesCrmday() {
	}

	public String getCrmdaysActive() {
		return this.crmdaysActive;
	}

	public void setCrmdaysActive(String crmdaysActive) {
		this.crmdaysActive = crmdaysActive;
	}

	public String getCrmdaysContactableEmailEnable() {
		return this.crmdaysContactableEmailEnable;
	}

	public void setCrmdaysContactableEmailEnable(String crmdaysContactableEmailEnable) {
		this.crmdaysContactableEmailEnable = crmdaysContactableEmailEnable;
	}

	public String getCrmdaysContactableEmailExeFormat() {
		return this.crmdaysContactableEmailExeFormat;
	}

	public void setCrmdaysContactableEmailExeFormat(String crmdaysContactableEmailExeFormat) {
		this.crmdaysContactableEmailExeFormat = crmdaysContactableEmailExeFormat;
	}

	public String getCrmdaysContactableEmailExeSub() {
		return this.crmdaysContactableEmailExeSub;
	}

	public void setCrmdaysContactableEmailExeSub(String crmdaysContactableEmailExeSub) {
		this.crmdaysContactableEmailExeSub = crmdaysContactableEmailExeSub;
	}

	public String getCrmdaysContactableEmailFormat() {
		return this.crmdaysContactableEmailFormat;
	}

	public void setCrmdaysContactableEmailFormat(String crmdaysContactableEmailFormat) {
		this.crmdaysContactableEmailFormat = crmdaysContactableEmailFormat;
	}

	public String getCrmdaysContactableEmailSub() {
		return this.crmdaysContactableEmailSub;
	}

	public void setCrmdaysContactableEmailSub(String crmdaysContactableEmailSub) {
		this.crmdaysContactableEmailSub = crmdaysContactableEmailSub;
	}

	public String getCrmdaysContactableSmsEnable() {
		return this.crmdaysContactableSmsEnable;
	}

	public void setCrmdaysContactableSmsEnable(String crmdaysContactableSmsEnable) {
		this.crmdaysContactableSmsEnable = crmdaysContactableSmsEnable;
	}

	public String getCrmdaysContactableSmsExeFormat() {
		return this.crmdaysContactableSmsExeFormat;
	}

	public void setCrmdaysContactableSmsExeFormat(String crmdaysContactableSmsExeFormat) {
		this.crmdaysContactableSmsExeFormat = crmdaysContactableSmsExeFormat;
	}

	public String getCrmdaysContactableSmsFormat() {
		return this.crmdaysContactableSmsFormat;
	}

	public void setCrmdaysContactableSmsFormat(String crmdaysContactableSmsFormat) {
		this.crmdaysContactableSmsFormat = crmdaysContactableSmsFormat;
	}

	public int getCrmdaysCrmtypeId() {
		return this.crmdaysCrmtypeId;
	}

	public void setCrmdaysCrmtypeId(int crmdaysCrmtypeId) {
		this.crmdaysCrmtypeId = crmdaysCrmtypeId;
	}

	public int getCrmdaysDaycount() {
		return this.crmdaysDaycount;
	}

	public void setCrmdaysDaycount(int crmdaysDaycount) {
		this.crmdaysDaycount = crmdaysDaycount;
	}

	public String getCrmdaysDesc() {
		return this.crmdaysDesc;
	}

	public void setCrmdaysDesc(String crmdaysDesc) {
		this.crmdaysDesc = crmdaysDesc;
	}

	public String getCrmdaysDissatisfiedEmailEnable() {
		return this.crmdaysDissatisfiedEmailEnable;
	}

	public void setCrmdaysDissatisfiedEmailEnable(String crmdaysDissatisfiedEmailEnable) {
		this.crmdaysDissatisfiedEmailEnable = crmdaysDissatisfiedEmailEnable;
	}

	public String getCrmdaysDissatisfiedEmailExeFormat() {
		return this.crmdaysDissatisfiedEmailExeFormat;
	}

	public void setCrmdaysDissatisfiedEmailExeFormat(String crmdaysDissatisfiedEmailExeFormat) {
		this.crmdaysDissatisfiedEmailExeFormat = crmdaysDissatisfiedEmailExeFormat;
	}

	public String getCrmdaysDissatisfiedEmailExeSub() {
		return this.crmdaysDissatisfiedEmailExeSub;
	}

	public void setCrmdaysDissatisfiedEmailExeSub(String crmdaysDissatisfiedEmailExeSub) {
		this.crmdaysDissatisfiedEmailExeSub = crmdaysDissatisfiedEmailExeSub;
	}

	public String getCrmdaysDissatisfiedEmailFormat() {
		return this.crmdaysDissatisfiedEmailFormat;
	}

	public void setCrmdaysDissatisfiedEmailFormat(String crmdaysDissatisfiedEmailFormat) {
		this.crmdaysDissatisfiedEmailFormat = crmdaysDissatisfiedEmailFormat;
	}

	public String getCrmdaysDissatisfiedEmailSub() {
		return this.crmdaysDissatisfiedEmailSub;
	}

	public void setCrmdaysDissatisfiedEmailSub(String crmdaysDissatisfiedEmailSub) {
		this.crmdaysDissatisfiedEmailSub = crmdaysDissatisfiedEmailSub;
	}

	public String getCrmdaysDissatisfiedSmsEnable() {
		return this.crmdaysDissatisfiedSmsEnable;
	}

	public void setCrmdaysDissatisfiedSmsEnable(String crmdaysDissatisfiedSmsEnable) {
		this.crmdaysDissatisfiedSmsEnable = crmdaysDissatisfiedSmsEnable;
	}

	public String getCrmdaysDissatisfiedSmsExeFormat() {
		return this.crmdaysDissatisfiedSmsExeFormat;
	}

	public void setCrmdaysDissatisfiedSmsExeFormat(String crmdaysDissatisfiedSmsExeFormat) {
		this.crmdaysDissatisfiedSmsExeFormat = crmdaysDissatisfiedSmsExeFormat;
	}

	public String getCrmdaysDissatisfiedSmsFormat() {
		return this.crmdaysDissatisfiedSmsFormat;
	}

	public void setCrmdaysDissatisfiedSmsFormat(String crmdaysDissatisfiedSmsFormat) {
		this.crmdaysDissatisfiedSmsFormat = crmdaysDissatisfiedSmsFormat;
	}

	public String getCrmdaysEntryDate() {
		return this.crmdaysEntryDate;
	}

	public void setCrmdaysEntryDate(String crmdaysEntryDate) {
		this.crmdaysEntryDate = crmdaysEntryDate;
	}

	public int getCrmdaysEntryId() {
		return this.crmdaysEntryId;
	}

	public void setCrmdaysEntryId(int crmdaysEntryId) {
		this.crmdaysEntryId = crmdaysEntryId;
	}

	public int getCrmdaysExeType() {
		return this.crmdaysExeType;
	}

	public void setCrmdaysExeType(int crmdaysExeType) {
		this.crmdaysExeType = crmdaysExeType;
	}

	public String getCrmdaysHomevisitfollowup() {
		return this.crmdaysHomevisitfollowup;
	}

	public void setCrmdaysHomevisitfollowup(String crmdaysHomevisitfollowup) {
		this.crmdaysHomevisitfollowup = crmdaysHomevisitfollowup;
	}

	public int getCrmdaysId() {
		return this.crmdaysId;
	}

	public void setCrmdaysId(int crmdaysId) {
		this.crmdaysId = crmdaysId;
	}

	public String getCrmdaysLostfollowup() {
		return this.crmdaysLostfollowup;
	}

	public void setCrmdaysLostfollowup(String crmdaysLostfollowup) {
		this.crmdaysLostfollowup = crmdaysLostfollowup;
	}

	public String getCrmdaysModifiedDate() {
		return this.crmdaysModifiedDate;
	}

	public void setCrmdaysModifiedDate(String crmdaysModifiedDate) {
		this.crmdaysModifiedDate = crmdaysModifiedDate;
	}

	public int getCrmdaysModifiedId() {
		return this.crmdaysModifiedId;
	}

	public void setCrmdaysModifiedId(int crmdaysModifiedId) {
		this.crmdaysModifiedId = crmdaysModifiedId;
	}

	public String getCrmdaysNoncontactableEmailEnable() {
		return this.crmdaysNoncontactableEmailEnable;
	}

	public void setCrmdaysNoncontactableEmailEnable(String crmdaysNoncontactableEmailEnable) {
		this.crmdaysNoncontactableEmailEnable = crmdaysNoncontactableEmailEnable;
	}

	public String getCrmdaysNoncontactableEmailExeFormat() {
		return this.crmdaysNoncontactableEmailExeFormat;
	}

	public void setCrmdaysNoncontactableEmailExeFormat(String crmdaysNoncontactableEmailExeFormat) {
		this.crmdaysNoncontactableEmailExeFormat = crmdaysNoncontactableEmailExeFormat;
	}

	public String getCrmdaysNoncontactableEmailExeSub() {
		return this.crmdaysNoncontactableEmailExeSub;
	}

	public void setCrmdaysNoncontactableEmailExeSub(String crmdaysNoncontactableEmailExeSub) {
		this.crmdaysNoncontactableEmailExeSub = crmdaysNoncontactableEmailExeSub;
	}

	public String getCrmdaysNoncontactableEmailFormat() {
		return this.crmdaysNoncontactableEmailFormat;
	}

	public void setCrmdaysNoncontactableEmailFormat(String crmdaysNoncontactableEmailFormat) {
		this.crmdaysNoncontactableEmailFormat = crmdaysNoncontactableEmailFormat;
	}

	public String getCrmdaysNoncontactableEmailSub() {
		return this.crmdaysNoncontactableEmailSub;
	}

	public void setCrmdaysNoncontactableEmailSub(String crmdaysNoncontactableEmailSub) {
		this.crmdaysNoncontactableEmailSub = crmdaysNoncontactableEmailSub;
	}

	public String getCrmdaysNoncontactableSmsEnable() {
		return this.crmdaysNoncontactableSmsEnable;
	}

	public void setCrmdaysNoncontactableSmsEnable(String crmdaysNoncontactableSmsEnable) {
		this.crmdaysNoncontactableSmsEnable = crmdaysNoncontactableSmsEnable;
	}

	public String getCrmdaysNoncontactableSmsExeFormat() {
		return this.crmdaysNoncontactableSmsExeFormat;
	}

	public void setCrmdaysNoncontactableSmsExeFormat(String crmdaysNoncontactableSmsExeFormat) {
		this.crmdaysNoncontactableSmsExeFormat = crmdaysNoncontactableSmsExeFormat;
	}

	public String getCrmdaysNoncontactableSmsFormat() {
		return this.crmdaysNoncontactableSmsFormat;
	}

	public void setCrmdaysNoncontactableSmsFormat(String crmdaysNoncontactableSmsFormat) {
		this.crmdaysNoncontactableSmsFormat = crmdaysNoncontactableSmsFormat;
	}

	public int getCrmdaysRefcrmdaysId() {
		return this.crmdaysRefcrmdaysId;
	}

	public void setCrmdaysRefcrmdaysId(int crmdaysRefcrmdaysId) {
		this.crmdaysRefcrmdaysId = crmdaysRefcrmdaysId;
	}

	public String getCrmdaysSatisfiedEmailEnable() {
		return this.crmdaysSatisfiedEmailEnable;
	}

	public void setCrmdaysSatisfiedEmailEnable(String crmdaysSatisfiedEmailEnable) {
		this.crmdaysSatisfiedEmailEnable = crmdaysSatisfiedEmailEnable;
	}

	public String getCrmdaysSatisfiedEmailExeFormat() {
		return this.crmdaysSatisfiedEmailExeFormat;
	}

	public void setCrmdaysSatisfiedEmailExeFormat(String crmdaysSatisfiedEmailExeFormat) {
		this.crmdaysSatisfiedEmailExeFormat = crmdaysSatisfiedEmailExeFormat;
	}

	public String getCrmdaysSatisfiedEmailExeSub() {
		return this.crmdaysSatisfiedEmailExeSub;
	}

	public void setCrmdaysSatisfiedEmailExeSub(String crmdaysSatisfiedEmailExeSub) {
		this.crmdaysSatisfiedEmailExeSub = crmdaysSatisfiedEmailExeSub;
	}

	public String getCrmdaysSatisfiedEmailFormat() {
		return this.crmdaysSatisfiedEmailFormat;
	}

	public void setCrmdaysSatisfiedEmailFormat(String crmdaysSatisfiedEmailFormat) {
		this.crmdaysSatisfiedEmailFormat = crmdaysSatisfiedEmailFormat;
	}

	public String getCrmdaysSatisfiedEmailSub() {
		return this.crmdaysSatisfiedEmailSub;
	}

	public void setCrmdaysSatisfiedEmailSub(String crmdaysSatisfiedEmailSub) {
		this.crmdaysSatisfiedEmailSub = crmdaysSatisfiedEmailSub;
	}

	public String getCrmdaysSatisfiedSmsEnable() {
		return this.crmdaysSatisfiedSmsEnable;
	}

	public void setCrmdaysSatisfiedSmsEnable(String crmdaysSatisfiedSmsEnable) {
		this.crmdaysSatisfiedSmsEnable = crmdaysSatisfiedSmsEnable;
	}

	public String getCrmdaysSatisfiedSmsExeFormat() {
		return this.crmdaysSatisfiedSmsExeFormat;
	}

	public void setCrmdaysSatisfiedSmsExeFormat(String crmdaysSatisfiedSmsExeFormat) {
		this.crmdaysSatisfiedSmsExeFormat = crmdaysSatisfiedSmsExeFormat;
	}

	public String getCrmdaysSatisfiedSmsFormat() {
		return this.crmdaysSatisfiedSmsFormat;
	}

	public void setCrmdaysSatisfiedSmsFormat(String crmdaysSatisfiedSmsFormat) {
		this.crmdaysSatisfiedSmsFormat = crmdaysSatisfiedSmsFormat;
	}

	public String getCrmdaysScript() {
		return this.crmdaysScript;
	}

	public void setCrmdaysScript(String crmdaysScript) {
		this.crmdaysScript = crmdaysScript;
	}

	public String getCrmdaysSoInactive() {
		return this.crmdaysSoInactive;
	}

	public void setCrmdaysSoInactive(String crmdaysSoInactive) {
		this.crmdaysSoInactive = crmdaysSoInactive;
	}

	public String getCrmdaysTestdrivefollowup() {
		return this.crmdaysTestdrivefollowup;
	}

	public void setCrmdaysTestdrivefollowup(String crmdaysTestdrivefollowup) {
		this.crmdaysTestdrivefollowup = crmdaysTestdrivefollowup;
	}

	public String getCrmdaysWaitingperiod() {
		return this.crmdaysWaitingperiod;
	}

	public void setCrmdaysWaitingperiod(String crmdaysWaitingperiod) {
		this.crmdaysWaitingperiod = crmdaysWaitingperiod;
	}

}