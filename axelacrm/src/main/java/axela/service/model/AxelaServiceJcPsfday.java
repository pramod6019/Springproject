package axela.service.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_service_jc_psfdays database table.
 * 
 */
@Entity
@Table(name = "axela_service_jc_psfdays", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceJcPsfday.findAll", query = "SELECT a FROM AxelaServiceJcPsfday a")
public class AxelaServiceJcPsfday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "psfdays_id")
	private int psfdaysId;

	@Column(name = "psfdays_active")
	private String psfdaysActive;

	@Column(name = "psfdays_contactable_email_enable")
	private String psfdaysContactableEmailEnable;

	@Lob
	@Column(name = "psfdays_contactable_email_exe_format")
	private String psfdaysContactableEmailExeFormat;

	@Column(name = "psfdays_contactable_email_exe_sub")
	private String psfdaysContactableEmailExeSub;

	@Lob
	@Column(name = "psfdays_contactable_email_format")
	private String psfdaysContactableEmailFormat;

	@Column(name = "psfdays_contactable_email_sub")
	private String psfdaysContactableEmailSub;

	@Column(name = "psfdays_contactable_sms_enable")
	private String psfdaysContactableSmsEnable;

	@Column(name = "psfdays_contactable_sms_exe_format")
	private String psfdaysContactableSmsExeFormat;

	@Column(name = "psfdays_contactable_sms_format")
	private String psfdaysContactableSmsFormat;

	@Column(name = "psfdays_daycount")
	private int psfdaysDaycount;

	@Column(name = "psfdays_desc")
	private String psfdaysDesc;

	@Column(name = "psfdays_dissatisfied_email_enable")
	private String psfdaysDissatisfiedEmailEnable;

	@Lob
	@Column(name = "psfdays_dissatisfied_email_exe_format")
	private String psfdaysDissatisfiedEmailExeFormat;

	@Column(name = "psfdays_dissatisfied_email_exe_sub")
	private String psfdaysDissatisfiedEmailExeSub;

	@Lob
	@Column(name = "psfdays_dissatisfied_email_format")
	private String psfdaysDissatisfiedEmailFormat;

	@Column(name = "psfdays_dissatisfied_email_sub")
	private String psfdaysDissatisfiedEmailSub;

	@Column(name = "psfdays_dissatisfied_sms_enable")
	private String psfdaysDissatisfiedSmsEnable;

	@Column(name = "psfdays_dissatisfied_sms_exe_format")
	private String psfdaysDissatisfiedSmsExeFormat;

	@Column(name = "psfdays_dissatisfied_sms_format")
	private String psfdaysDissatisfiedSmsFormat;

	@Column(name = "psfdays_emp_id")
	private String psfdaysEmpId;

	@Column(name = "psfdays_entry_date")
	private String psfdaysEntryDate;

	@Column(name = "psfdays_entry_id")
	private int psfdaysEntryId;

	@Column(name = "psfdays_exe_type")
	private int psfdaysExeType;

	@Column(name = "psfdays_jccat_id")
	private int psfdaysJccatId;

	@Column(name = "psfdays_modified_date")
	private String psfdaysModifiedDate;

	@Column(name = "psfdays_modified_id")
	private int psfdaysModifiedId;

	@Column(name = "psfdays_noncontactable_email_enable")
	private String psfdaysNoncontactableEmailEnable;

	@Lob
	@Column(name = "psfdays_noncontactable_email_exe_format")
	private String psfdaysNoncontactableEmailExeFormat;

	@Column(name = "psfdays_noncontactable_email_exe_sub")
	private String psfdaysNoncontactableEmailExeSub;

	@Lob
	@Column(name = "psfdays_noncontactable_email_format")
	private String psfdaysNoncontactableEmailFormat;

	@Column(name = "psfdays_noncontactable_email_sub")
	private String psfdaysNoncontactableEmailSub;

	@Column(name = "psfdays_noncontactable_sms_enable")
	private String psfdaysNoncontactableSmsEnable;

	@Column(name = "psfdays_noncontactable_sms_exe_format")
	private String psfdaysNoncontactableSmsExeFormat;

	@Column(name = "psfdays_noncontactable_sms_format")
	private String psfdaysNoncontactableSmsFormat;

	@Column(name = "psfdays_satisfied_email_enable")
	private String psfdaysSatisfiedEmailEnable;

	@Lob
	@Column(name = "psfdays_satisfied_email_exe_format")
	private String psfdaysSatisfiedEmailExeFormat;

	@Column(name = "psfdays_satisfied_email_exe_sub")
	private String psfdaysSatisfiedEmailExeSub;

	@Lob
	@Column(name = "psfdays_satisfied_email_format")
	private String psfdaysSatisfiedEmailFormat;

	@Column(name = "psfdays_satisfied_email_sub")
	private String psfdaysSatisfiedEmailSub;

	@Column(name = "psfdays_satisfied_sms_enable")
	private String psfdaysSatisfiedSmsEnable;

	@Column(name = "psfdays_satisfied_sms_exe_format")
	private String psfdaysSatisfiedSmsExeFormat;

	@Column(name = "psfdays_satisfied_sms_format")
	private String psfdaysSatisfiedSmsFormat;

	@Column(name = "psfdays_script")
	private String psfdaysScript;

	public AxelaServiceJcPsfday() {
	}

	public int getPsfdaysId() {
		return this.psfdaysId;
	}

	public void setPsfdaysId(int psfdaysId) {
		this.psfdaysId = psfdaysId;
	}

	public String getPsfdaysActive() {
		return this.psfdaysActive;
	}

	public void setPsfdaysActive(String psfdaysActive) {
		this.psfdaysActive = psfdaysActive;
	}

	public String getPsfdaysContactableEmailEnable() {
		return this.psfdaysContactableEmailEnable;
	}

	public void setPsfdaysContactableEmailEnable(String psfdaysContactableEmailEnable) {
		this.psfdaysContactableEmailEnable = psfdaysContactableEmailEnable;
	}

	public String getPsfdaysContactableEmailExeFormat() {
		return this.psfdaysContactableEmailExeFormat;
	}

	public void setPsfdaysContactableEmailExeFormat(String psfdaysContactableEmailExeFormat) {
		this.psfdaysContactableEmailExeFormat = psfdaysContactableEmailExeFormat;
	}

	public String getPsfdaysContactableEmailExeSub() {
		return this.psfdaysContactableEmailExeSub;
	}

	public void setPsfdaysContactableEmailExeSub(String psfdaysContactableEmailExeSub) {
		this.psfdaysContactableEmailExeSub = psfdaysContactableEmailExeSub;
	}

	public String getPsfdaysContactableEmailFormat() {
		return this.psfdaysContactableEmailFormat;
	}

	public void setPsfdaysContactableEmailFormat(String psfdaysContactableEmailFormat) {
		this.psfdaysContactableEmailFormat = psfdaysContactableEmailFormat;
	}

	public String getPsfdaysContactableEmailSub() {
		return this.psfdaysContactableEmailSub;
	}

	public void setPsfdaysContactableEmailSub(String psfdaysContactableEmailSub) {
		this.psfdaysContactableEmailSub = psfdaysContactableEmailSub;
	}

	public String getPsfdaysContactableSmsEnable() {
		return this.psfdaysContactableSmsEnable;
	}

	public void setPsfdaysContactableSmsEnable(String psfdaysContactableSmsEnable) {
		this.psfdaysContactableSmsEnable = psfdaysContactableSmsEnable;
	}

	public String getPsfdaysContactableSmsExeFormat() {
		return this.psfdaysContactableSmsExeFormat;
	}

	public void setPsfdaysContactableSmsExeFormat(String psfdaysContactableSmsExeFormat) {
		this.psfdaysContactableSmsExeFormat = psfdaysContactableSmsExeFormat;
	}

	public String getPsfdaysContactableSmsFormat() {
		return this.psfdaysContactableSmsFormat;
	}

	public void setPsfdaysContactableSmsFormat(String psfdaysContactableSmsFormat) {
		this.psfdaysContactableSmsFormat = psfdaysContactableSmsFormat;
	}

	public int getPsfdaysDaycount() {
		return this.psfdaysDaycount;
	}

	public void setPsfdaysDaycount(int psfdaysDaycount) {
		this.psfdaysDaycount = psfdaysDaycount;
	}

	public String getPsfdaysDesc() {
		return this.psfdaysDesc;
	}

	public void setPsfdaysDesc(String psfdaysDesc) {
		this.psfdaysDesc = psfdaysDesc;
	}

	public String getPsfdaysDissatisfiedEmailEnable() {
		return this.psfdaysDissatisfiedEmailEnable;
	}

	public void setPsfdaysDissatisfiedEmailEnable(String psfdaysDissatisfiedEmailEnable) {
		this.psfdaysDissatisfiedEmailEnable = psfdaysDissatisfiedEmailEnable;
	}

	public String getPsfdaysDissatisfiedEmailExeFormat() {
		return this.psfdaysDissatisfiedEmailExeFormat;
	}

	public void setPsfdaysDissatisfiedEmailExeFormat(String psfdaysDissatisfiedEmailExeFormat) {
		this.psfdaysDissatisfiedEmailExeFormat = psfdaysDissatisfiedEmailExeFormat;
	}

	public String getPsfdaysDissatisfiedEmailExeSub() {
		return this.psfdaysDissatisfiedEmailExeSub;
	}

	public void setPsfdaysDissatisfiedEmailExeSub(String psfdaysDissatisfiedEmailExeSub) {
		this.psfdaysDissatisfiedEmailExeSub = psfdaysDissatisfiedEmailExeSub;
	}

	public String getPsfdaysDissatisfiedEmailFormat() {
		return this.psfdaysDissatisfiedEmailFormat;
	}

	public void setPsfdaysDissatisfiedEmailFormat(String psfdaysDissatisfiedEmailFormat) {
		this.psfdaysDissatisfiedEmailFormat = psfdaysDissatisfiedEmailFormat;
	}

	public String getPsfdaysDissatisfiedEmailSub() {
		return this.psfdaysDissatisfiedEmailSub;
	}

	public void setPsfdaysDissatisfiedEmailSub(String psfdaysDissatisfiedEmailSub) {
		this.psfdaysDissatisfiedEmailSub = psfdaysDissatisfiedEmailSub;
	}

	public String getPsfdaysDissatisfiedSmsEnable() {
		return this.psfdaysDissatisfiedSmsEnable;
	}

	public void setPsfdaysDissatisfiedSmsEnable(String psfdaysDissatisfiedSmsEnable) {
		this.psfdaysDissatisfiedSmsEnable = psfdaysDissatisfiedSmsEnable;
	}

	public String getPsfdaysDissatisfiedSmsExeFormat() {
		return this.psfdaysDissatisfiedSmsExeFormat;
	}

	public void setPsfdaysDissatisfiedSmsExeFormat(String psfdaysDissatisfiedSmsExeFormat) {
		this.psfdaysDissatisfiedSmsExeFormat = psfdaysDissatisfiedSmsExeFormat;
	}

	public String getPsfdaysDissatisfiedSmsFormat() {
		return this.psfdaysDissatisfiedSmsFormat;
	}

	public void setPsfdaysDissatisfiedSmsFormat(String psfdaysDissatisfiedSmsFormat) {
		this.psfdaysDissatisfiedSmsFormat = psfdaysDissatisfiedSmsFormat;
	}

	public String getPsfdaysEmpId() {
		return this.psfdaysEmpId;
	}

	public void setPsfdaysEmpId(String psfdaysEmpId) {
		this.psfdaysEmpId = psfdaysEmpId;
	}

	public String getPsfdaysEntryDate() {
		return this.psfdaysEntryDate;
	}

	public void setPsfdaysEntryDate(String psfdaysEntryDate) {
		this.psfdaysEntryDate = psfdaysEntryDate;
	}

	public int getPsfdaysEntryId() {
		return this.psfdaysEntryId;
	}

	public void setPsfdaysEntryId(int psfdaysEntryId) {
		this.psfdaysEntryId = psfdaysEntryId;
	}

	public int getPsfdaysExeType() {
		return this.psfdaysExeType;
	}

	public void setPsfdaysExeType(int psfdaysExeType) {
		this.psfdaysExeType = psfdaysExeType;
	}

	public int getPsfdaysJccatId() {
		return this.psfdaysJccatId;
	}

	public void setPsfdaysJccatId(int psfdaysJccatId) {
		this.psfdaysJccatId = psfdaysJccatId;
	}

	public String getPsfdaysModifiedDate() {
		return this.psfdaysModifiedDate;
	}

	public void setPsfdaysModifiedDate(String psfdaysModifiedDate) {
		this.psfdaysModifiedDate = psfdaysModifiedDate;
	}

	public int getPsfdaysModifiedId() {
		return this.psfdaysModifiedId;
	}

	public void setPsfdaysModifiedId(int psfdaysModifiedId) {
		this.psfdaysModifiedId = psfdaysModifiedId;
	}

	public String getPsfdaysNoncontactableEmailEnable() {
		return this.psfdaysNoncontactableEmailEnable;
	}

	public void setPsfdaysNoncontactableEmailEnable(String psfdaysNoncontactableEmailEnable) {
		this.psfdaysNoncontactableEmailEnable = psfdaysNoncontactableEmailEnable;
	}

	public String getPsfdaysNoncontactableEmailExeFormat() {
		return this.psfdaysNoncontactableEmailExeFormat;
	}

	public void setPsfdaysNoncontactableEmailExeFormat(String psfdaysNoncontactableEmailExeFormat) {
		this.psfdaysNoncontactableEmailExeFormat = psfdaysNoncontactableEmailExeFormat;
	}

	public String getPsfdaysNoncontactableEmailExeSub() {
		return this.psfdaysNoncontactableEmailExeSub;
	}

	public void setPsfdaysNoncontactableEmailExeSub(String psfdaysNoncontactableEmailExeSub) {
		this.psfdaysNoncontactableEmailExeSub = psfdaysNoncontactableEmailExeSub;
	}

	public String getPsfdaysNoncontactableEmailFormat() {
		return this.psfdaysNoncontactableEmailFormat;
	}

	public void setPsfdaysNoncontactableEmailFormat(String psfdaysNoncontactableEmailFormat) {
		this.psfdaysNoncontactableEmailFormat = psfdaysNoncontactableEmailFormat;
	}

	public String getPsfdaysNoncontactableEmailSub() {
		return this.psfdaysNoncontactableEmailSub;
	}

	public void setPsfdaysNoncontactableEmailSub(String psfdaysNoncontactableEmailSub) {
		this.psfdaysNoncontactableEmailSub = psfdaysNoncontactableEmailSub;
	}

	public String getPsfdaysNoncontactableSmsEnable() {
		return this.psfdaysNoncontactableSmsEnable;
	}

	public void setPsfdaysNoncontactableSmsEnable(String psfdaysNoncontactableSmsEnable) {
		this.psfdaysNoncontactableSmsEnable = psfdaysNoncontactableSmsEnable;
	}

	public String getPsfdaysNoncontactableSmsExeFormat() {
		return this.psfdaysNoncontactableSmsExeFormat;
	}

	public void setPsfdaysNoncontactableSmsExeFormat(String psfdaysNoncontactableSmsExeFormat) {
		this.psfdaysNoncontactableSmsExeFormat = psfdaysNoncontactableSmsExeFormat;
	}

	public String getPsfdaysNoncontactableSmsFormat() {
		return this.psfdaysNoncontactableSmsFormat;
	}

	public void setPsfdaysNoncontactableSmsFormat(String psfdaysNoncontactableSmsFormat) {
		this.psfdaysNoncontactableSmsFormat = psfdaysNoncontactableSmsFormat;
	}

	public String getPsfdaysSatisfiedEmailEnable() {
		return this.psfdaysSatisfiedEmailEnable;
	}

	public void setPsfdaysSatisfiedEmailEnable(String psfdaysSatisfiedEmailEnable) {
		this.psfdaysSatisfiedEmailEnable = psfdaysSatisfiedEmailEnable;
	}

	public String getPsfdaysSatisfiedEmailExeFormat() {
		return this.psfdaysSatisfiedEmailExeFormat;
	}

	public void setPsfdaysSatisfiedEmailExeFormat(String psfdaysSatisfiedEmailExeFormat) {
		this.psfdaysSatisfiedEmailExeFormat = psfdaysSatisfiedEmailExeFormat;
	}

	public String getPsfdaysSatisfiedEmailExeSub() {
		return this.psfdaysSatisfiedEmailExeSub;
	}

	public void setPsfdaysSatisfiedEmailExeSub(String psfdaysSatisfiedEmailExeSub) {
		this.psfdaysSatisfiedEmailExeSub = psfdaysSatisfiedEmailExeSub;
	}

	public String getPsfdaysSatisfiedEmailFormat() {
		return this.psfdaysSatisfiedEmailFormat;
	}

	public void setPsfdaysSatisfiedEmailFormat(String psfdaysSatisfiedEmailFormat) {
		this.psfdaysSatisfiedEmailFormat = psfdaysSatisfiedEmailFormat;
	}

	public String getPsfdaysSatisfiedEmailSub() {
		return this.psfdaysSatisfiedEmailSub;
	}

	public void setPsfdaysSatisfiedEmailSub(String psfdaysSatisfiedEmailSub) {
		this.psfdaysSatisfiedEmailSub = psfdaysSatisfiedEmailSub;
	}

	public String getPsfdaysSatisfiedSmsEnable() {
		return this.psfdaysSatisfiedSmsEnable;
	}

	public void setPsfdaysSatisfiedSmsEnable(String psfdaysSatisfiedSmsEnable) {
		this.psfdaysSatisfiedSmsEnable = psfdaysSatisfiedSmsEnable;
	}

	public String getPsfdaysSatisfiedSmsExeFormat() {
		return this.psfdaysSatisfiedSmsExeFormat;
	}

	public void setPsfdaysSatisfiedSmsExeFormat(String psfdaysSatisfiedSmsExeFormat) {
		this.psfdaysSatisfiedSmsExeFormat = psfdaysSatisfiedSmsExeFormat;
	}

	public String getPsfdaysSatisfiedSmsFormat() {
		return this.psfdaysSatisfiedSmsFormat;
	}

	public void setPsfdaysSatisfiedSmsFormat(String psfdaysSatisfiedSmsFormat) {
		this.psfdaysSatisfiedSmsFormat = psfdaysSatisfiedSmsFormat;
	}

	public String getPsfdaysScript() {
		return this.psfdaysScript;
	}

	public void setPsfdaysScript(String psfdaysScript) {
		this.psfdaysScript = psfdaysScript;
	}

}