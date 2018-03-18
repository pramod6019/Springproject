package axela.service.model;

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

import axela.portal.model.AxelaEmp;

/**
 * The persistent class for the axela_service_jc_psf database table.
 * 
 */
@Entity
@Table(name = "axela_service_jc_psf", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceJcPsf.findAll", query = "SELECT a FROM AxelaServiceJcPsf a")
public class AxelaServiceJcPsf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "jcpsf_id")
	private int jcpsfId;

	@Column(name = "jcpsf_crmfeedbacktype_id")
	private int jcpsfCrmfeedbacktypeId;

	@Column(name = "jcpsf_desc")
	private String jcpsfDesc;

	@Column(name = "jcpsf_email1")
	private String jcpsfEmail1;

	@Column(name = "jcpsf_email2")
	private String jcpsfEmail2;

	@Column(name = "jcpsf_emp_id")
	private int jcpsfEmpId;

	@Column(name = "jcpsf_entry_id")
	private int jcpsfEntryId;

	@Column(name = "jcpsf_entry_time")
	private String jcpsfEntryTime;

	@Column(name = "jcpsf_followup_time")
	private Date jcpsfFollowupTime;

	@Column(name = "jcpsf_jc_id")
	private int jcpsfJcId;

	@Column(name = "jcpsf_jcpsfconcern_id")
	private int jcpsfJcpsfconcernId;

	@Column(name = "jcpsf_mobile1")
	private String jcpsfMobile1;

	@Column(name = "jcpsf_mobile2")
	private String jcpsfMobile2;

	@Column(name = "jcpsf_modified_id")
	private int jcpsfModifiedId;

	@Column(name = "jcpsf_modified_time")
	private String jcpsfModifiedTime;

	@Column(name = "jcpsf_nextfollowuptime")
	private String jcpsfNextfollowuptime;

	@Column(name = "jcpsf_psfdays_id")
	private int jcpsfPsfdaysId;

	@Column(name = "jcpsf_satisfied")
	private int jcpsfSatisfied;

	@Column(name = "jcpsf_ticket_emp_id")
	private int jcpsfTicketEmpId;

	@Column(name = "jcpsf_trigger")
	private int jcpsfTrigger;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jcpsf_psfdays_id", referencedColumnName = "psfdays_id", insertable = false, updatable = false)
	private AxelaServiceJcPsfday axelaServiceJcPsfday;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jcpsf_emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

	public AxelaEmp getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(AxelaEmp axelaEmp) {
		this.axelaEmp = axelaEmp;
	}

	public AxelaServiceJcPsfday getAxelaServiceJcPsfday() {
		return axelaServiceJcPsfday;
	}

	public void setAxelaServiceJcPsfday(AxelaServiceJcPsfday axelaServiceJcPsfday) {
		this.axelaServiceJcPsfday = axelaServiceJcPsfday;
	}

	public AxelaServiceJcPsf() {
	}

	public int getJcpsfId() {
		return this.jcpsfId;
	}

	public void setJcpsfId(int jcpsfId) {
		this.jcpsfId = jcpsfId;
	}

	public int getJcpsfCrmfeedbacktypeId() {
		return this.jcpsfCrmfeedbacktypeId;
	}

	public void setJcpsfCrmfeedbacktypeId(int jcpsfCrmfeedbacktypeId) {
		this.jcpsfCrmfeedbacktypeId = jcpsfCrmfeedbacktypeId;
	}

	public String getJcpsfDesc() {
		return this.jcpsfDesc;
	}

	public void setJcpsfDesc(String jcpsfDesc) {
		this.jcpsfDesc = jcpsfDesc;
	}

	public String getJcpsfEmail1() {
		return this.jcpsfEmail1;
	}

	public void setJcpsfEmail1(String jcpsfEmail1) {
		this.jcpsfEmail1 = jcpsfEmail1;
	}

	public String getJcpsfEmail2() {
		return this.jcpsfEmail2;
	}

	public void setJcpsfEmail2(String jcpsfEmail2) {
		this.jcpsfEmail2 = jcpsfEmail2;
	}

	public int getJcpsfEmpId() {
		return this.jcpsfEmpId;
	}

	public void setJcpsfEmpId(int jcpsfEmpId) {
		this.jcpsfEmpId = jcpsfEmpId;
	}

	public int getJcpsfEntryId() {
		return this.jcpsfEntryId;
	}

	public void setJcpsfEntryId(int jcpsfEntryId) {
		this.jcpsfEntryId = jcpsfEntryId;
	}

	public String getJcpsfEntryTime() {
		return this.jcpsfEntryTime;
	}

	public void setJcpsfEntryTime(String jcpsfEntryTime) {
		this.jcpsfEntryTime = jcpsfEntryTime;
	}

	public Date getJcpsfFollowupTime() {
		return this.jcpsfFollowupTime;
	}

	public void setJcpsfFollowupTime(Date jcpsfFollowupTime) {
		this.jcpsfFollowupTime = jcpsfFollowupTime;
	}

	public int getJcpsfJcId() {
		return this.jcpsfJcId;
	}

	public void setJcpsfJcId(int jcpsfJcId) {
		this.jcpsfJcId = jcpsfJcId;
	}

	public int getJcpsfJcpsfconcernId() {
		return this.jcpsfJcpsfconcernId;
	}

	public void setJcpsfJcpsfconcernId(int jcpsfJcpsfconcernId) {
		this.jcpsfJcpsfconcernId = jcpsfJcpsfconcernId;
	}

	public String getJcpsfMobile1() {
		return this.jcpsfMobile1;
	}

	public void setJcpsfMobile1(String jcpsfMobile1) {
		this.jcpsfMobile1 = jcpsfMobile1;
	}

	public String getJcpsfMobile2() {
		return this.jcpsfMobile2;
	}

	public void setJcpsfMobile2(String jcpsfMobile2) {
		this.jcpsfMobile2 = jcpsfMobile2;
	}

	public int getJcpsfModifiedId() {
		return this.jcpsfModifiedId;
	}

	public void setJcpsfModifiedId(int jcpsfModifiedId) {
		this.jcpsfModifiedId = jcpsfModifiedId;
	}

	public String getJcpsfModifiedTime() {
		return this.jcpsfModifiedTime;
	}

	public void setJcpsfModifiedTime(String jcpsfModifiedTime) {
		this.jcpsfModifiedTime = jcpsfModifiedTime;
	}

	public String getJcpsfNextfollowuptime() {
		return this.jcpsfNextfollowuptime;
	}

	public void setJcpsfNextfollowuptime(String jcpsfNextfollowuptime) {
		this.jcpsfNextfollowuptime = jcpsfNextfollowuptime;
	}

	public int getJcpsfPsfdaysId() {
		return this.jcpsfPsfdaysId;
	}

	public void setJcpsfPsfdaysId(int jcpsfPsfdaysId) {
		this.jcpsfPsfdaysId = jcpsfPsfdaysId;
	}

	public int getJcpsfSatisfied() {
		return this.jcpsfSatisfied;
	}

	public void setJcpsfSatisfied(int jcpsfSatisfied) {
		this.jcpsfSatisfied = jcpsfSatisfied;
	}

	public int getJcpsfTicketEmpId() {
		return this.jcpsfTicketEmpId;
	}

	public void setJcpsfTicketEmpId(int jcpsfTicketEmpId) {
		this.jcpsfTicketEmpId = jcpsfTicketEmpId;
	}

	public int getJcpsfTrigger() {
		return this.jcpsfTrigger;
	}

	public void setJcpsfTrigger(int jcpsfTrigger) {
		this.jcpsfTrigger = jcpsfTrigger;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jcpsf_jc_id", referencedColumnName = "jc_id", insertable = false, updatable = false)
	private AxelaServiceJc axelaServiceJc;

	public AxelaServiceJc getAxelaServiceJc() {
		return axelaServiceJc;
	}

	public void setAxelaServiceJc(AxelaServiceJc axelaServiceJc) {
		this.axelaServiceJc = axelaServiceJc;
	}

}