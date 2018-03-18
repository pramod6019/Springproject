package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_asset_insur database table.
 * 
 */
@Entity
@Table(name = "axela_asset_insur", catalog = "axela_1")
@NamedQuery(name = "AxelaAssetInsur.findAll", query = "SELECT a FROM AxelaAssetInsur a")
public class AxelaAssetInsur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "insur_id")
	private int insurId;

	@Column(name = "insur_active")
	private String insurActive;

	@Column(name = "insur_amt")
	private double insurAmt;

	@Column(name = "insur_branch_id")
	private int insurBranchId;

	@Column(name = "insur_company")
	private String insurCompany;

	@Column(name = "insur_customer_id")
	private int insurCustomerId;

	@Column(name = "insur_date")
	private String insurDate;

	@Lob
	@Column(name = "insur_desc")
	private String insurDesc;

	@Column(name = "insur_end_date")
	private String insurEndDate;

	@Column(name = "insur_entry_date")
	private String insurEntryDate;

	@Column(name = "insur_entry_id")
	private int insurEntryId;

	@Column(name = "insur_insurtype_id")
	private int insurInsurtypeId;

	@Column(name = "insur_modified_date")
	private String insurModifiedDate;

	@Column(name = "insur_modified_id")
	private int insurModifiedId;

	@Column(name = "insur_notes")
	private String insurNotes;

	@Column(name = "insur_policy_name")
	private String insurPolicyName;

	@Column(name = "insur_policy_no")
	private String insurPolicyNo;

	@Column(name = "insur_refno")
	private String insurRefno;

	@Column(name = "insur_start_date")
	private String insurStartDate;

	@Lob
	@Column(name = "insur_terms")
	private String insurTerms;

	@Column(name = "insur_title")
	private String insurTitle;

	public AxelaAssetInsur() {
	}

	public int getInsurId() {
		return this.insurId;
	}

	public void setInsurId(int insurId) {
		this.insurId = insurId;
	}

	public String getInsurActive() {
		return this.insurActive;
	}

	public void setInsurActive(String insurActive) {
		this.insurActive = insurActive;
	}

	public double getInsurAmt() {
		return this.insurAmt;
	}

	public void setInsurAmt(double insurAmt) {
		this.insurAmt = insurAmt;
	}

	public int getInsurBranchId() {
		return this.insurBranchId;
	}

	public void setInsurBranchId(int insurBranchId) {
		this.insurBranchId = insurBranchId;
	}

	public String getInsurCompany() {
		return this.insurCompany;
	}

	public void setInsurCompany(String insurCompany) {
		this.insurCompany = insurCompany;
	}

	public int getInsurCustomerId() {
		return this.insurCustomerId;
	}

	public void setInsurCustomerId(int insurCustomerId) {
		this.insurCustomerId = insurCustomerId;
	}

	public String getInsurDate() {
		return this.insurDate;
	}

	public void setInsurDate(String insurDate) {
		this.insurDate = insurDate;
	}

	public String getInsurDesc() {
		return this.insurDesc;
	}

	public void setInsurDesc(String insurDesc) {
		this.insurDesc = insurDesc;
	}

	public String getInsurEndDate() {
		return this.insurEndDate;
	}

	public void setInsurEndDate(String insurEndDate) {
		this.insurEndDate = insurEndDate;
	}

	public String getInsurEntryDate() {
		return this.insurEntryDate;
	}

	public void setInsurEntryDate(String insurEntryDate) {
		this.insurEntryDate = insurEntryDate;
	}

	public int getInsurEntryId() {
		return this.insurEntryId;
	}

	public void setInsurEntryId(int insurEntryId) {
		this.insurEntryId = insurEntryId;
	}

	public int getInsurInsurtypeId() {
		return this.insurInsurtypeId;
	}

	public void setInsurInsurtypeId(int insurInsurtypeId) {
		this.insurInsurtypeId = insurInsurtypeId;
	}

	public String getInsurModifiedDate() {
		return this.insurModifiedDate;
	}

	public void setInsurModifiedDate(String insurModifiedDate) {
		this.insurModifiedDate = insurModifiedDate;
	}

	public int getInsurModifiedId() {
		return this.insurModifiedId;
	}

	public void setInsurModifiedId(int insurModifiedId) {
		this.insurModifiedId = insurModifiedId;
	}

	public String getInsurNotes() {
		return this.insurNotes;
	}

	public void setInsurNotes(String insurNotes) {
		this.insurNotes = insurNotes;
	}

	public String getInsurPolicyName() {
		return this.insurPolicyName;
	}

	public void setInsurPolicyName(String insurPolicyName) {
		this.insurPolicyName = insurPolicyName;
	}

	public String getInsurPolicyNo() {
		return this.insurPolicyNo;
	}

	public void setInsurPolicyNo(String insurPolicyNo) {
		this.insurPolicyNo = insurPolicyNo;
	}

	public String getInsurRefno() {
		return this.insurRefno;
	}

	public void setInsurRefno(String insurRefno) {
		this.insurRefno = insurRefno;
	}

	public String getInsurStartDate() {
		return this.insurStartDate;
	}

	public void setInsurStartDate(String insurStartDate) {
		this.insurStartDate = insurStartDate;
	}

	public String getInsurTerms() {
		return this.insurTerms;
	}

	public void setInsurTerms(String insurTerms) {
		this.insurTerms = insurTerms;
	}

	public String getInsurTitle() {
		return this.insurTitle;
	}

	public void setInsurTitle(String insurTitle) {
		this.insurTitle = insurTitle;
	}

}