package axela.portal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import axela.accounting.model.AxelaAccVoucher;
import axela.customer.model.AxelaCustomer;
import axela.sales.model.AxelaSalesOppr;
import axela.service.model.AxelaServiceContract;

/**
 * The persistent class for the axela_branch database table.
 * 
 */
@Entity
@Table(name = "axela_branch", catalog = "axela_1")
@NamedQuery(name = "AxelaBranch.findAll", query = "SELECT a FROM AxelaBranch a")
public class AxelaBranch implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "axelaBranch")
	private List<AxelaAccVoucher> axelaAccVoucher;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branch_branchtype_id", referencedColumnName = "branchtype_id", insertable = false, updatable = false)
	private AxelaBranchType axelaBranchType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branch_city_id", referencedColumnName = "city_id", insertable = false, updatable = false)
	private AxelaCity axelaCity;

	// one-to-many relation with axelacustomer
	@OneToMany(mappedBy = "axelaBranch")
	private List<AxelaCustomer> axelacustomer;

	// one-to-many relation with axelacustomer
	@OneToMany(mappedBy = "axelaBranch")
	private List<AxelaCustomer> axelacustomers;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branch_franchisee_id", referencedColumnName = "franchisee_id", insertable = false, updatable = false)
	private AxelaFranchisee axelaFranchisee;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branch_rateclass_id", referencedColumnName = "rateclass_id", insertable = false, updatable = false)
	private AxelaRateClass axelaRateClass;

	@OneToMany(mappedBy = "axelaBranch")
	private List<AxelaSalesOppr> axelaSalesOppr;

	@OneToMany(mappedBy = "axelaBranch")
	private List<AxelaServiceContract> axelaServiceContract;

	@Id
	@Column(name = "branch_id")
	private int branchId;

	@Column(name = "branch_active")
	private String branchActive;

	@Column(name = "branch_add")
	private String branchAdd;

	@Column(name = "branch_bill_footer")
	private String branchBillFooter;

	@Column(name = "branch_bill_header")
	private String branchBillHeader;

	@Column(name = "branch_bill_prefix")
	private String branchBillPrefix;

	@Column(name = "branch_branchtype_id")
	private int branchBranchtypeId;

	@Column(name = "branch_city_id")
	private int branchCityId;

	@Column(name = "branch_code")
	private String branchCode;

	@Column(name = "branch_cst")
	private String branchCst;

	@Column(name = "branch_email1")
	private String branchEmail1;

	@Column(name = "branch_email2")
	private String branchEmail2;

	@Column(name = "branch_entry_date")
	private Date branchEntryDate;

	@Column(name = "branch_entry_id")
	private int branchEntryId;

	@Column(name = "branch_franchisee_id")
	private int branchFranchiseeId;

	@Column(name = "branch_gst")
	private String branchGst;

	@Lob
	@Column(name = "branch_invoice_desc")
	private String branchInvoiceDesc;

	@Column(name = "branch_invoice_name")
	private String branchInvoiceName;

	@Column(name = "branch_invoice_prefix")
	private String branchInvoicePrefix;

	@Column(name = "branch_invoice_suffix")
	private String branchInvoiceSuffix;

	@Lob
	@Column(name = "branch_invoice_terms")
	private String branchInvoiceTerms;

	@Column(name = "branch_jc_prefix")
	private String branchJcPrefix;

	@Column(name = "branch_location_id")
	private int branchLocationId;

	@Column(name = "branch_mail_password")
	private String branchMailPassword;

	@Column(name = "branch_mail_port")
	private String branchMailPort;

	@Column(name = "branch_mail_server")
	private String branchMailServer;

	@Column(name = "branch_mail_ssl")
	private String branchMailSsl;

	@Column(name = "branch_mail_username")
	private String branchMailUsername;

	@Column(name = "branch_mobile1")
	private String branchMobile1;

	@Column(name = "branch_mobile2")
	private String branchMobile2;

	@Column(name = "branch_modified_date")
	private Date branchModifiedDate;

	@Column(name = "branch_modified_id")
	private int branchModifiedId;

	@Column(name = "branch_name")
	private String branchName;

	@Column(name = "branch_notes")
	private String branchNotes;

	@Column(name = "branch_pan_no")
	private String branchPanNo;

	@Column(name = "branch_phone1")
	private String branchPhone1;

	@Column(name = "branch_phone2")
	private String branchPhone2;

	@Column(name = "branch_pin")
	private String branchPin;

	@Lob
	@Column(name = "branch_quote_desc")
	private String branchQuoteDesc;

	@Lob
	@Column(name = "branch_quote_terms")
	private String branchQuoteTerms;

	@Column(name = "branch_rateclass_id")
	private int branchRateclassId;

	@Lob
	@Column(name = "branch_receipt_desc")
	private String branchReceiptDesc;

	@Column(name = "branch_receipt_prefix")
	private String branchReceiptPrefix;

	@Column(name = "branch_receipt_suffix")
	private String branchReceiptSuffix;

	@Column(name = "branch_service_tax_no")
	private String branchServiceTaxNo;

	@Lob
	@Column(name = "branch_so_desc")
	private String branchSoDesc;

	@Column(name = "branch_so_prefix")
	private String branchSoPrefix;

	@Lob
	@Column(name = "branch_so_terms")
	private String branchSoTerms;

	@Column(name = "branch_tan_no")
	private String branchTanNo;

	@Column(name = "branch_tin_no")
	private String branchTinNo;

	@Column(name = "branch_vat")
	private String branchVat;

	public AxelaBranch() {
	}

	public int getBranchId() {
		return this.branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchActive() {
		return this.branchActive;
	}

	public void setBranchActive(String branchActive) {
		this.branchActive = branchActive;
	}

	public String getBranchAdd() {
		return this.branchAdd;
	}

	public void setBranchAdd(String branchAdd) {
		this.branchAdd = branchAdd;
	}

	public String getBranchBillFooter() {
		return this.branchBillFooter;
	}

	public void setBranchBillFooter(String branchBillFooter) {
		this.branchBillFooter = branchBillFooter;
	}

	public String getBranchBillHeader() {
		return this.branchBillHeader;
	}

	public void setBranchBillHeader(String branchBillHeader) {
		this.branchBillHeader = branchBillHeader;
	}

	public String getBranchBillPrefix() {
		return this.branchBillPrefix;
	}

	public void setBranchBillPrefix(String branchBillPrefix) {
		this.branchBillPrefix = branchBillPrefix;
	}

	public int getBranchBranchtypeId() {
		return this.branchBranchtypeId;
	}

	public void setBranchBranchtypeId(int branchBranchtypeId) {
		this.branchBranchtypeId = branchBranchtypeId;
	}

	public int getBranchCityId() {
		return this.branchCityId;
	}

	public void setBranchCityId(int branchCityId) {
		this.branchCityId = branchCityId;
	}

	public String getBranchCode() {
		return this.branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchCst() {
		return this.branchCst;
	}

	public void setBranchCst(String branchCst) {
		this.branchCst = branchCst;
	}

	public String getBranchEmail1() {
		return this.branchEmail1;
	}

	public void setBranchEmail1(String branchEmail1) {
		this.branchEmail1 = branchEmail1;
	}

	public String getBranchEmail2() {
		return this.branchEmail2;
	}

	public void setBranchEmail2(String branchEmail2) {
		this.branchEmail2 = branchEmail2;
	}

	public Date getBranchEntryDate() {
		return this.branchEntryDate;
	}

	public void setBranchEntryDate(Date branchEntryDate) {
		this.branchEntryDate = branchEntryDate;
	}

	public int getBranchEntryId() {
		return this.branchEntryId;
	}

	public void setBranchEntryId(int branchEntryId) {
		this.branchEntryId = branchEntryId;
	}

	public int getBranchFranchiseeId() {
		return this.branchFranchiseeId;
	}

	public void setBranchFranchiseeId(int branchFranchiseeId) {
		this.branchFranchiseeId = branchFranchiseeId;
	}

	public String getBranchGst() {
		return this.branchGst;
	}

	public void setBranchGst(String branchGst) {
		this.branchGst = branchGst;
	}

	public String getBranchInvoiceDesc() {
		return this.branchInvoiceDesc;
	}

	public void setBranchInvoiceDesc(String branchInvoiceDesc) {
		this.branchInvoiceDesc = branchInvoiceDesc;
	}

	public String getBranchInvoiceName() {
		return this.branchInvoiceName;
	}

	public void setBranchInvoiceName(String branchInvoiceName) {
		this.branchInvoiceName = branchInvoiceName;
	}

	public String getBranchInvoicePrefix() {
		return this.branchInvoicePrefix;
	}

	public void setBranchInvoicePrefix(String branchInvoicePrefix) {
		this.branchInvoicePrefix = branchInvoicePrefix;
	}

	public String getBranchInvoiceSuffix() {
		return this.branchInvoiceSuffix;
	}

	public void setBranchInvoiceSuffix(String branchInvoiceSuffix) {
		this.branchInvoiceSuffix = branchInvoiceSuffix;
	}

	public String getBranchInvoiceTerms() {
		return this.branchInvoiceTerms;
	}

	public void setBranchInvoiceTerms(String branchInvoiceTerms) {
		this.branchInvoiceTerms = branchInvoiceTerms;
	}

	public String getBranchJcPrefix() {
		return this.branchJcPrefix;
	}

	public void setBranchJcPrefix(String branchJcPrefix) {
		this.branchJcPrefix = branchJcPrefix;
	}

	public int getBranchLocationId() {
		return this.branchLocationId;
	}

	public void setBranchLocationId(int branchLocationId) {
		this.branchLocationId = branchLocationId;
	}

	public String getBranchMailPassword() {
		return this.branchMailPassword;
	}

	public void setBranchMailPassword(String branchMailPassword) {
		this.branchMailPassword = branchMailPassword;
	}

	public String getBranchMailPort() {
		return this.branchMailPort;
	}

	public void setBranchMailPort(String branchMailPort) {
		this.branchMailPort = branchMailPort;
	}

	public String getBranchMailServer() {
		return this.branchMailServer;
	}

	public void setBranchMailServer(String branchMailServer) {
		this.branchMailServer = branchMailServer;
	}

	public String getBranchMailSsl() {
		return this.branchMailSsl;
	}

	public void setBranchMailSsl(String branchMailSsl) {
		this.branchMailSsl = branchMailSsl;
	}

	public String getBranchMailUsername() {
		return this.branchMailUsername;
	}

	public void setBranchMailUsername(String branchMailUsername) {
		this.branchMailUsername = branchMailUsername;
	}

	public String getBranchMobile1() {
		return this.branchMobile1;
	}

	public void setBranchMobile1(String branchMobile1) {
		this.branchMobile1 = branchMobile1;
	}

	public String getBranchMobile2() {
		return this.branchMobile2;
	}

	public void setBranchMobile2(String branchMobile2) {
		this.branchMobile2 = branchMobile2;
	}

	public Date getBranchModifiedDate() {
		return this.branchModifiedDate;
	}

	public void setBranchModifiedDate(Date branchModifiedDate) {
		this.branchModifiedDate = branchModifiedDate;
	}

	public int getBranchModifiedId() {
		return this.branchModifiedId;
	}

	public void setBranchModifiedId(int branchModifiedId) {
		this.branchModifiedId = branchModifiedId;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchNotes() {
		return this.branchNotes;
	}

	public void setBranchNotes(String branchNotes) {
		this.branchNotes = branchNotes;
	}

	public String getBranchPanNo() {
		return this.branchPanNo;
	}

	public void setBranchPanNo(String branchPanNo) {
		this.branchPanNo = branchPanNo;
	}

	public String getBranchPhone1() {
		return this.branchPhone1;
	}

	public void setBranchPhone1(String branchPhone1) {
		this.branchPhone1 = branchPhone1;
	}

	public String getBranchPhone2() {
		return this.branchPhone2;
	}

	public void setBranchPhone2(String branchPhone2) {
		this.branchPhone2 = branchPhone2;
	}

	public String getBranchPin() {
		return this.branchPin;
	}

	public void setBranchPin(String branchPin) {
		this.branchPin = branchPin;
	}

	public String getBranchQuoteDesc() {
		return this.branchQuoteDesc;
	}

	public void setBranchQuoteDesc(String branchQuoteDesc) {
		this.branchQuoteDesc = branchQuoteDesc;
	}

	public String getBranchQuoteTerms() {
		return this.branchQuoteTerms;
	}

	public void setBranchQuoteTerms(String branchQuoteTerms) {
		this.branchQuoteTerms = branchQuoteTerms;
	}

	public int getBranchRateclassId() {
		return this.branchRateclassId;
	}

	public void setBranchRateclassId(int branchRateclassId) {
		this.branchRateclassId = branchRateclassId;
	}

	public String getBranchReceiptDesc() {
		return this.branchReceiptDesc;
	}

	public void setBranchReceiptDesc(String branchReceiptDesc) {
		this.branchReceiptDesc = branchReceiptDesc;
	}

	public String getBranchReceiptPrefix() {
		return this.branchReceiptPrefix;
	}

	public void setBranchReceiptPrefix(String branchReceiptPrefix) {
		this.branchReceiptPrefix = branchReceiptPrefix;
	}

	public String getBranchReceiptSuffix() {
		return this.branchReceiptSuffix;
	}

	public void setBranchReceiptSuffix(String branchReceiptSuffix) {
		this.branchReceiptSuffix = branchReceiptSuffix;
	}

	public String getBranchServiceTaxNo() {
		return this.branchServiceTaxNo;
	}

	public void setBranchServiceTaxNo(String branchServiceTaxNo) {
		this.branchServiceTaxNo = branchServiceTaxNo;
	}

	public String getBranchSoDesc() {
		return this.branchSoDesc;
	}

	public void setBranchSoDesc(String branchSoDesc) {
		this.branchSoDesc = branchSoDesc;
	}

	public String getBranchSoPrefix() {
		return this.branchSoPrefix;
	}

	public void setBranchSoPrefix(String branchSoPrefix) {
		this.branchSoPrefix = branchSoPrefix;
	}

	public String getBranchSoTerms() {
		return this.branchSoTerms;
	}

	public void setBranchSoTerms(String branchSoTerms) {
		this.branchSoTerms = branchSoTerms;
	}

	public String getBranchTanNo() {
		return this.branchTanNo;
	}

	public void setBranchTanNo(String branchTanNo) {
		this.branchTanNo = branchTanNo;
	}

	public String getBranchTinNo() {
		return this.branchTinNo;
	}

	public void setBranchTinNo(String branchTinNo) {
		this.branchTinNo = branchTinNo;
	}

	public String getBranchVat() {
		return this.branchVat;
	}

	public void setBranchVat(String branchVat) {
		this.branchVat = branchVat;
	}

	public AxelaBranch(int branchId,
			String branchName) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
	}

	public AxelaBranch(int branchId,
			String branchName, int branchFranchiseeId) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchFranchiseeId = branchFranchiseeId;
	}

	public AxelaBranch(int branchId, String branchCode, String branchName) {
		super();
		this.branchId = branchId;
		this.branchCode = branchCode;
		this.branchName = branchName;
	}

	public AxelaBranch(
			int branchId,
			String branchName,
			String branchActive,
			int franchiseetypeId,
			String branchEmail1,
			String branchEmail2,
			String branchPhone1,
			String branchPhone2,
			String branchMobile1,
			String branchMobile2,
			String rateclassName,
			String branchAdd,
			String cityName,
			String branchPin,
			String branchPanNo,
			String branchTanNo,
			String branchTinNo,
			String branchServiceTaxNo,
			String branchCode,
			String franchiseeName,
			int franchiseeId,
			String branchNotes)
	{
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchActive = branchActive;
		this.franchiseetypeId = franchiseetypeId;
		this.branchEmail1 = branchEmail1;
		this.branchEmail2 = branchEmail2;
		this.branchPhone1 = branchPhone1;
		this.branchPhone2 = branchPhone2;
		this.branchMobile1 = branchMobile1;
		this.branchMobile2 = branchMobile2;
		this.rateclassName = rateclassName;
		this.branchAdd = branchAdd;
		this.cityName = cityName;
		this.branchPin = branchPin;
		this.branchPanNo = branchPanNo;
		this.branchTanNo = branchTanNo;
		this.branchTinNo = branchTinNo;
		this.branchServiceTaxNo = branchServiceTaxNo;
		this.branchCode = branchCode;
		this.franchiseeName = franchiseeName;
		this.franchiseeId = franchiseeId;
		this.branchNotes = branchNotes;
	}

	public List<AxelaAccVoucher> getAxelaAccVoucher() {
		return axelaAccVoucher;
	}

	public void setAxelaAccVoucher(List<AxelaAccVoucher> axelaAccVoucher) {
		this.axelaAccVoucher = axelaAccVoucher;
	}

	public AxelaBranchType getAxelaBranchType() {
		return axelaBranchType;
	}

	public void setAxelaBranchType(AxelaBranchType axelaBranchType) {
		this.axelaBranchType = axelaBranchType;
	}

	public AxelaCity getAxelaCity() {
		return axelaCity;
	}

	public void setAxelaCity(AxelaCity axelaCity) {
		this.axelaCity = axelaCity;
	}

	public List<AxelaCustomer> getAxelacustomer() {
		return axelacustomer;
	}

	public void setAxelacustomer(List<AxelaCustomer> axelacustomer) {
		this.axelacustomer = axelacustomer;
	}

	public List<AxelaCustomer> getAxelacustomers() {
		return axelacustomers;
	}

	public void setAxelacustomers(List<AxelaCustomer> axelacustomers) {
		this.axelacustomers = axelacustomers;
	}

	public AxelaFranchisee getAxelaFranchisee() {
		return axelaFranchisee;
	}

	public void setAxelaFranchisee(AxelaFranchisee axelaFranchisee) {
		this.axelaFranchisee = axelaFranchisee;
	}

	public AxelaRateClass getAxelaRateClass() {
		return axelaRateClass;
	}

	public void setAxelaRateClass(AxelaRateClass axelaRateClass) {
		this.axelaRateClass = axelaRateClass;
	}

	public List<AxelaSalesOppr> getAxelaSalesOppr() {
		return axelaSalesOppr;
	}

	public void setAxelaSalesOppr(List<AxelaSalesOppr> axelaSalesOppr) {
		this.axelaSalesOppr = axelaSalesOppr;
	}

	public List<AxelaServiceContract> getAxelaServiceContract() {
		return axelaServiceContract;
	}

	public void setAxelaServiceContract(List<AxelaServiceContract> axelaServiceContract) {
		this.axelaServiceContract = axelaServiceContract;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getFranchiseeId() {
		return franchiseeId;
	}

	public void setFranchiseeId(int franchiseeId) {
		this.franchiseeId = franchiseeId;
	}

	public String getFranchiseeName() {
		return franchiseeName;
	}

	public void setFranchiseeName(String franchiseeName) {
		this.franchiseeName = franchiseeName;
	}

	public int getFranchiseetypeId() {
		return franchiseetypeId;
	}

	public void setFranchiseetypeId(int franchiseetypeId) {
		this.franchiseetypeId = franchiseetypeId;
	}

	public String getRateclassName() {
		return rateclassName;
	}

	public void setRateclassName(String rateclassName) {
		this.rateclassName = rateclassName;
	}

	@Transient
	private String cityName = ""; // From AxelaCity

	// =========================================Entity Relationships====================================

	// =========================================INNER JOIN variables=================================
	@Transient
	private int franchiseeId = 0; // From AxelaFranchisee

	@Transient
	private String franchiseeName = ""; // From AxelaFranchisee

	@Transient
	private int franchiseetypeId = 0; // From AxelaFranchiseeType

	@Transient
	private String rateclassName = ""; // From AxelaRateClass

}