package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_mktg_lead database table.
 * 
 */
@Entity
@Table(name = "axela_mktg_lead", catalog = "axela_1")
@NamedQuery(name = "AxelaMktgLead.findAll", query = "SELECT a FROM AxelaMktgLead a")
public class AxelaMktgLead implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lead_id")
	private int leadId;

	@Column(name = "lead_active")
	private String leadActive;

	@Column(name = "lead_anniversary")
	private String leadAnniversary;

	@Column(name = "lead_branch_id")
	private int leadBranchId;

	@Column(name = "lead_company")
	private String leadCompany;

	@Column(name = "lead_date")
	private String leadDate;

	@Column(name = "lead_dob")
	private String leadDob;

	@Column(name = "lead_email")
	private String leadEmail;

	@Column(name = "lead_emp_id")
	private int leadEmpId;

	@Column(name = "lead_empcount_id")
	private short leadEmpcountId;

	@Column(name = "lead_entry_date")
	private String leadEntryDate;

	@Column(name = "lead_entry_id")
	private int leadEntryId;

	@Column(name = "lead_fname")
	private String leadFname;

	@Column(name = "lead_jobtitle")
	private String leadJobtitle;

	@Column(name = "lead_leadsob_id")
	private int leadLeadsobId;

	@Column(name = "lead_leadsoe_id")
	private int leadLeadsoeId;

	@Column(name = "lead_lname")
	private String leadLname;

	@Column(name = "lead_mobile")
	private String leadMobile;

	@Column(name = "lead_modified_date")
	private String leadModifiedDate;

	@Column(name = "lead_modified_id")
	private int leadModifiedId;

	@Column(name = "lead_phone")
	private String leadPhone;

	@Column(name = "lead_refno")
	private String leadRefno;

	@Column(name = "lead_req")
	private String leadReq;

	@Column(name = "lead_title_id")
	private int leadTitleId;

	@Column(name = "lead_website")
	private String leadWebsite;

	@Column(name = "lead_website_date")
	private String leadWebsiteDate;

	@Column(name = "lead_website_ip")
	private String leadWebsiteIp;

	public AxelaMktgLead() {
	}

	public int getLeadId() {
		return this.leadId;
	}

	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}

	public String getLeadActive() {
		return this.leadActive;
	}

	public void setLeadActive(String leadActive) {
		this.leadActive = leadActive;
	}

	public String getLeadAnniversary() {
		return this.leadAnniversary;
	}

	public void setLeadAnniversary(String leadAnniversary) {
		this.leadAnniversary = leadAnniversary;
	}

	public int getLeadBranchId() {
		return this.leadBranchId;
	}

	public void setLeadBranchId(int leadBranchId) {
		this.leadBranchId = leadBranchId;
	}

	public String getLeadCompany() {
		return this.leadCompany;
	}

	public void setLeadCompany(String leadCompany) {
		this.leadCompany = leadCompany;
	}

	public String getLeadDate() {
		return this.leadDate;
	}

	public void setLeadDate(String leadDate) {
		this.leadDate = leadDate;
	}

	public String getLeadDob() {
		return this.leadDob;
	}

	public void setLeadDob(String leadDob) {
		this.leadDob = leadDob;
	}

	public String getLeadEmail() {
		return this.leadEmail;
	}

	public void setLeadEmail(String leadEmail) {
		this.leadEmail = leadEmail;
	}

	public int getLeadEmpId() {
		return this.leadEmpId;
	}

	public void setLeadEmpId(int leadEmpId) {
		this.leadEmpId = leadEmpId;
	}

	public short getLeadEmpcountId() {
		return this.leadEmpcountId;
	}

	public void setLeadEmpcountId(short leadEmpcountId) {
		this.leadEmpcountId = leadEmpcountId;
	}

	public String getLeadEntryDate() {
		return this.leadEntryDate;
	}

	public void setLeadEntryDate(String leadEntryDate) {
		this.leadEntryDate = leadEntryDate;
	}

	public int getLeadEntryId() {
		return this.leadEntryId;
	}

	public void setLeadEntryId(int leadEntryId) {
		this.leadEntryId = leadEntryId;
	}

	public String getLeadFname() {
		return this.leadFname;
	}

	public void setLeadFname(String leadFname) {
		this.leadFname = leadFname;
	}

	public String getLeadJobtitle() {
		return this.leadJobtitle;
	}

	public void setLeadJobtitle(String leadJobtitle) {
		this.leadJobtitle = leadJobtitle;
	}

	public int getLeadLeadsobId() {
		return this.leadLeadsobId;
	}

	public void setLeadLeadsobId(int leadLeadsobId) {
		this.leadLeadsobId = leadLeadsobId;
	}

	public int getLeadLeadsoeId() {
		return this.leadLeadsoeId;
	}

	public void setLeadLeadsoeId(int leadLeadsoeId) {
		this.leadLeadsoeId = leadLeadsoeId;
	}

	public String getLeadLname() {
		return this.leadLname;
	}

	public void setLeadLname(String leadLname) {
		this.leadLname = leadLname;
	}

	public String getLeadMobile() {
		return this.leadMobile;
	}

	public void setLeadMobile(String leadMobile) {
		this.leadMobile = leadMobile;
	}

	public String getLeadModifiedDate() {
		return this.leadModifiedDate;
	}

	public void setLeadModifiedDate(String leadModifiedDate) {
		this.leadModifiedDate = leadModifiedDate;
	}

	public int getLeadModifiedId() {
		return this.leadModifiedId;
	}

	public void setLeadModifiedId(int leadModifiedId) {
		this.leadModifiedId = leadModifiedId;
	}

	public String getLeadPhone() {
		return this.leadPhone;
	}

	public void setLeadPhone(String leadPhone) {
		this.leadPhone = leadPhone;
	}

	public String getLeadRefno() {
		return this.leadRefno;
	}

	public void setLeadRefno(String leadRefno) {
		this.leadRefno = leadRefno;
	}

	public String getLeadReq() {
		return this.leadReq;
	}

	public void setLeadReq(String leadReq) {
		this.leadReq = leadReq;
	}

	public int getLeadTitleId() {
		return this.leadTitleId;
	}

	public void setLeadTitleId(int leadTitleId) {
		this.leadTitleId = leadTitleId;
	}

	public String getLeadWebsite() {
		return this.leadWebsite;
	}

	public void setLeadWebsite(String leadWebsite) {
		this.leadWebsite = leadWebsite;
	}

	public String getLeadWebsiteDate() {
		return this.leadWebsiteDate;
	}

	public void setLeadWebsiteDate(String leadWebsiteDate) {
		this.leadWebsiteDate = leadWebsiteDate;
	}

	public String getLeadWebsiteIp() {
		return this.leadWebsiteIp;
	}

	public void setLeadWebsiteIp(String leadWebsiteIp) {
		this.leadWebsiteIp = leadWebsiteIp;
	}

}