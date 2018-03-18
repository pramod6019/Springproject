package axela.accounting.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import axela.customer.model.AxelaCustomer;
import axela.customer.model.AxelaCustomerContact;
import axela.portal.model.AxelaAccVoucherTran;
import axela.portal.model.AxelaBranch;
import axela.portal.model.AxelaEmp;

/**
 * The persistent class for the axela_acc_voucher database table.
 * 
 */
@Entity
@Table(name = "axela_acc_voucher", catalog = AxelaAccVoucher.comp_db)
@NamedQuery(name = "AxelaAccVoucher.findAll", query = "SELECT a FROM AxelaAccVoucher a")
public class AxelaAccVoucher implements Serializable {
	public static final String comp_db = "axela_1";
	private static final long serialVersionUID = 1L;

	@Transient
	private Date customerEntryDate;

	@Transient
	private String branchPrefix;

	@Transient
	private String branchSuffix;

	@Transient
	private int customerId;

	@Transient
	private String customerName;

	@Transient
	private String contactName;

	@Transient
	private String contactMobile1;

	@Transient
	private String contactEmail1;

	@Transient
	private String contactMobile2;

	@Transient
	private String contactEmail2;

	@Transient
	private String branchName;

	@Transient
	private String empName;

	@Transient
	private int voucherclassId;

	@Transient
	private String vouchertypeName;

	@Transient
	private int vouchertypeId;

	@Transient
	private String branchCode;

	@Transient
	private int vouchertypeVoucherclassId;

	@Transient
	private String titleDesc;

	@Transient
	private String contactFname;

	@Transient
	private String contactLname;

	@Transient
	private String empRefNo;

	@Transient
	private String empGender;

	@Transient
	private int empId;

	@Transient
	private String vouchertypePrefix;

	@Transient
	private String vouchertypeSuffix;

	@Transient
	private String contactPhone1;

	@Transient
	private String contactPhone2;

	@Transient
	private String vouchertypeEmailEnable;

	@Transient
	private String vouchertypeSmsEnable;

	@Transient
	private String vouchertypeDocs;

	@Transient
	private String voucherclassFile;

	private String vouchertypeMobile;

	@Transient
	private String vouchertypeEmail;

	@Transient
	private String vouchertypeDob;

	@Transient
	private String vouchertypeDnd;

	@Transient
	private String vouchertypeAffectsInventory;

	@Transient
	private String vouchertypeRefNoEnable;

	@Transient
	private String vouchertypeRefNoMandatory;

	@Transient
	private String vouchertypeTerms;

	@Transient
	private String vouchertypeEmailAuto;

	@Transient
	private String vouchertypeEmailSub;

	@Transient
	private String vouchertypeEmailFormat;

	@Transient
	private String vouchertypeSmsAuto;

	@Transient
	private String vouchertypeSmsFormat;

	@Transient
	private String configAdminEmail;

	@Transient
	private String configEmailEnable;

	@Transient
	private String configSmsEnable;

	@Transient
	private String compEmailEnable;

	@Transient
	private String compSmsEnable;

	@Transient
	private String vouchertypeBillingAdd;

	@Transient
	private String vouchertypeConsigneeAdd;

	@Transient
	private String vouchertypeTransporter;

	@Transient
	private String vouchertypeGatepass;

	@Transient
	private String vouchertypeLrno;

	@Transient
	private String vouchertypeTempoNo;

	@Transient
	private String vouchertypeDriverNo;

	@Transient
	private String vouchertypeCashdiscount;
	@Transient
	private long todayinvoices;
	@Transient
	private long todayreceipts;
	@Transient
	private long monthinvoices;
	@Transient
	private long monthreceipts;
	@Transient
	private long monthso;
	@Transient
	private long todayso;
	@Transient
	private long totalso;

	public long getMonthso() {
		return monthso;
	}

	public void setMonthso(long monthso) {
		this.monthso = monthso;
	}

	public long getTodayso() {
		return todayso;
	}

	public void setTodayso(long todayso) {
		this.todayso = todayso;
	}

	public long getTotalso() {
		return totalso;
	}

	public void setTotalso(long totalso) {
		this.totalso = totalso;
	}

	public AxelaAccVoucher(long todayinvoices, long todayreceipts, long monthinvoices,
			long monthreceipts, long monthso, long todayso, long totalso) {
		super();
		this.todayinvoices = todayinvoices;
		this.todayreceipts = todayreceipts;
		this.monthinvoices = monthinvoices;
		this.monthreceipts = monthreceipts;
		this.monthso = monthso;
		this.todayso = todayso;
		this.totalso = totalso;

	}

	public AxelaAccVoucher(
			int voucherId,
			int voucherNo,
			BigDecimal voucherAmount,
			String voucherNarration,
			Date voucherDate,
			String voucherActive,
			int voucherOpprId,
			int voucherQuoteId,
			int voucherInvoiceId,
			int voucherSoId,
			int voucherDelnoteId,
			int voucherPoId,
			String branchName,
			String branchCode,
			int voucherCustomerId,
			int voucherContactId,
			int vouchertypeVoucherclassId,
			// " COALESCE(ledger_id,'0') AS ledger_id, COALESCE(ledger_name,'') AS ledger_name,"
			String customerName,
			int voucherBranchId,
			String voucherAuthorize,
			String titleDesc,
			String contactFname,
			String contactLname,
			String contactMobile1,
			String contactMobile2,
			String contactEmail1,
			String contactEmail2,
			String empName,
			String empRefNo,
			// empPhoto,"
			String empGender,
			int empId,
			int vouchertypeId,
			String vouchertypeName,
			String vouchertypePrefix,
			String vouchertypeSuffix,
			String vouchertypeEmailEnable,
			String vouchertypeSmsEnable,
			String vouchertypeDocs,
			int voucherclassId,
			String voucherclassFile) {
		super();
		this.voucherId = voucherId;
		this.voucherNo = voucherNo;
		this.voucherAmount = voucherAmount;
		this.voucherNarration = voucherNarration;
		this.voucherDate = voucherDate;
		this.voucherActive = voucherActive;
		this.voucherOpprId = voucherOpprId;
		this.voucherQuoteId = voucherQuoteId;
		this.voucherInvoiceId = voucherInvoiceId;
		this.voucherSoId = voucherSoId;
		this.voucherDelnoteId = voucherDelnoteId;
		this.voucherPoId = voucherPoId;
		this.branchName = branchName;
		this.branchCode = branchCode;
		this.voucherCustomerId = voucherCustomerId;
		this.voucherContactId = voucherContactId;
		this.vouchertypeVoucherclassId = vouchertypeVoucherclassId;
		// this. " COALESCE(ledger_id,'0')
		this.customerName = customerName;
		this.voucherBranchId = voucherBranchId;
		this.voucherAuthorize = voucherAuthorize;
		this.titleDesc = titleDesc;
		this.contactFname = contactFname;
		this.contactLname = contactLname;
		this.contactMobile1 = contactMobile1;
		this.contactMobile2 = contactMobile2;
		this.contactEmail1 = contactEmail1;
		this.contactEmail2 = contactEmail2;
		this.empName = empName;
		this.empRefNo = empRefNo;
		// this.empPhoto= empPhoto ;
		this.empGender = empGender;
		this.empId = empId;
		this.vouchertypeId = vouchertypeId;
		this.vouchertypeName = vouchertypeName;
		this.vouchertypePrefix = vouchertypePrefix;
		this.vouchertypeSuffix = vouchertypeSuffix;
		this.vouchertypeEmailEnable = vouchertypeEmailEnable;
		this.vouchertypeSmsEnable = vouchertypeSmsEnable;
		this.vouchertypeDocs = vouchertypeDocs;
		this.voucherclassId = voucherclassId;
		this.voucherclassFile = voucherclassFile;

	}
	public Date getCustomerEntryDate() {
		return customerEntryDate;
	}

	public void setCustomerEntryDate(Date customerEntryDate) {
		this.customerEntryDate = customerEntryDate;
	}

	public String getBranchPrefix() {
		return branchPrefix;
	}

	public void setBranchPrefix(String branchPrefix) {
		this.branchPrefix = branchPrefix;
	}

	public String getBranchSuffix() {
		return branchSuffix;
	}

	public void setBranchSuffix(String branchSuffix) {
		this.branchSuffix = branchSuffix;
	}

	public String getContactPhone1() {
		return contactPhone1;
	}

	public void setContactPhone1(String contactPhone1) {
		this.contactPhone1 = contactPhone1;
	}

	public String getContactPhone2() {
		return contactPhone2;
	}

	public void setContactPhone2(String contactPhone2) {
		this.contactPhone2 = contactPhone2;
	}

	public String getVouchertypeMobile() {
		return vouchertypeMobile;
	}

	public void setVouchertypeMobile(String vouchertypeMobile) {
		this.vouchertypeMobile = vouchertypeMobile;
	}

	public String getVouchertypeEmail() {
		return vouchertypeEmail;
	}

	public void setVouchertypeEmail(String vouchertypeEmail) {
		this.vouchertypeEmail = vouchertypeEmail;
	}

	public String getVouchertypeDob() {
		return vouchertypeDob;
	}

	public void setVouchertypeDob(String vouchertypeDob) {
		this.vouchertypeDob = vouchertypeDob;
	}

	public String getVouchertypeDnd() {
		return vouchertypeDnd;
	}

	public void setVouchertypeDnd(String vouchertypeDnd) {
		this.vouchertypeDnd = vouchertypeDnd;
	}

	public String getVouchertypeAffectsInventory() {
		return vouchertypeAffectsInventory;
	}

	public void setVouchertypeAffectsInventory(String vouchertypeAffectsInventory) {
		this.vouchertypeAffectsInventory = vouchertypeAffectsInventory;
	}

	public String getVouchertypeRefNoEnable() {
		return vouchertypeRefNoEnable;
	}

	public void setVouchertypeRefNoEnable(String vouchertypeRefNoEnable) {
		this.vouchertypeRefNoEnable = vouchertypeRefNoEnable;
	}

	public String getVouchertypeRefNoMandatory() {
		return vouchertypeRefNoMandatory;
	}

	public void setVouchertypeRefNoMandatory(String vouchertypeRefNoMandatory) {
		this.vouchertypeRefNoMandatory = vouchertypeRefNoMandatory;
	}

	public String getVouchertypeTerms() {
		return vouchertypeTerms;
	}

	public void setVouchertypeTerms(String vouchertypeTerms) {
		this.vouchertypeTerms = vouchertypeTerms;
	}

	public String getVouchertypeEmailAuto() {
		return vouchertypeEmailAuto;
	}

	public void setVouchertypeEmailAuto(String vouchertypeEmailAuto) {
		this.vouchertypeEmailAuto = vouchertypeEmailAuto;
	}

	public String getVouchertypeEmailSub() {
		return vouchertypeEmailSub;
	}

	public void setVouchertypeEmailSub(String vouchertypeEmailSub) {
		this.vouchertypeEmailSub = vouchertypeEmailSub;
	}

	public String getVouchertypeEmailFormat() {
		return vouchertypeEmailFormat;
	}

	public void setVouchertypeEmailFormat(String vouchertypeEmailFormat) {
		this.vouchertypeEmailFormat = vouchertypeEmailFormat;
	}

	public String getVouchertypeSmsAuto() {
		return vouchertypeSmsAuto;
	}

	public void setVouchertypeSmsAuto(String vouchertypeSmsAuto) {
		this.vouchertypeSmsAuto = vouchertypeSmsAuto;
	}

	public String getVouchertypeSmsFormat() {
		return vouchertypeSmsFormat;
	}

	public void setVouchertypeSmsFormat(String vouchertypeSmsFormat) {
		this.vouchertypeSmsFormat = vouchertypeSmsFormat;
	}

	public String getConfigAdminEmail() {
		return configAdminEmail;
	}

	public void setConfigAdminEmail(String configAdminEmail) {
		this.configAdminEmail = configAdminEmail;
	}

	public String getConfigEmailEnable() {
		return configEmailEnable;
	}

	public void setConfigEmailEnable(String configEmailEnable) {
		this.configEmailEnable = configEmailEnable;
	}

	public String getConfigSmsEnable() {
		return configSmsEnable;
	}

	public void setConfigSmsEnable(String configSmsEnable) {
		this.configSmsEnable = configSmsEnable;
	}

	public String getCompEmailEnable() {
		return compEmailEnable;
	}

	public void setCompEmailEnable(String compEmailEnable) {
		this.compEmailEnable = compEmailEnable;
	}

	public String getCompSmsEnable() {
		return compSmsEnable;
	}

	public void setCompSmsEnable(String compSmsEnable) {
		this.compSmsEnable = compSmsEnable;
	}

	public String getVouchertypeBillingAdd() {
		return vouchertypeBillingAdd;
	}

	public void setVouchertypeBillingAdd(String vouchertypeBillingAdd) {
		this.vouchertypeBillingAdd = vouchertypeBillingAdd;
	}

	public String getVouchertypeConsigneeAdd() {
		return vouchertypeConsigneeAdd;
	}

	public void setVouchertypeConsigneeAdd(String vouchertypeConsigneeAdd) {
		this.vouchertypeConsigneeAdd = vouchertypeConsigneeAdd;
	}

	public String getVouchertypeTransporter() {
		return vouchertypeTransporter;
	}

	public void setVouchertypeTransporter(String vouchertypeTransporter) {
		this.vouchertypeTransporter = vouchertypeTransporter;
	}

	public String getVouchertypeGatepass() {
		return vouchertypeGatepass;
	}

	public void setVouchertypeGatepass(String vouchertypeGatepass) {
		this.vouchertypeGatepass = vouchertypeGatepass;
	}

	public String getVouchertypeLrno() {
		return vouchertypeLrno;
	}

	public void setVouchertypeLrno(String vouchertypeLrno) {
		this.vouchertypeLrno = vouchertypeLrno;
	}

	public String getVouchertypeTempoNo() {
		return vouchertypeTempoNo;
	}

	public void setVouchertypeTempoNo(String vouchertypeTempoNo) {
		this.vouchertypeTempoNo = vouchertypeTempoNo;
	}

	public String getVouchertypeDriverNo() {
		return vouchertypeDriverNo;
	}

	public void setVouchertypeDriverNo(String vouchertypeDriverNo) {
		this.vouchertypeDriverNo = vouchertypeDriverNo;
	}

	public String getVouchertypeCashdiscount() {
		return vouchertypeCashdiscount;
	}

	public void setVouchertypeCashdiscount(String vouchertypeCashdiscount) {
		this.vouchertypeCashdiscount = vouchertypeCashdiscount;
	}

	public String getVouchertypeTurnoverdisc() {
		return vouchertypeTurnoverdisc;
	}

	public void setVouchertypeTurnoverdisc(String vouchertypeTurnoverdisc) {
		this.vouchertypeTurnoverdisc = vouchertypeTurnoverdisc;
	}

	public short getVoucherclassAcc() {
		return voucherclassAcc;
	}

	public void setVoucherclassAcc(short voucherclassAcc) {
		this.voucherclassAcc = voucherclassAcc;
	}

	public AxelaAccVoucherType getAxelaAccVoucherType() {
		return axelaAccVoucherType;
	}

	public void setAxelaAccVoucherType(AxelaAccVoucherType axelaAccVoucherType) {
		this.axelaAccVoucherType = axelaAccVoucherType;
	}

	private String vouchertypeTurnoverdisc;

	@Id
	@Column(name = "voucher_id")
	private int voucherId;

	@Column(name = "voucher_active")
	private String voucherActive;

	@Column(name = "voucher_advance")
	private String voucherAdvance;

	@Column(name = "voucher_amount")
	private BigDecimal voucherAmount;

	@Column(name = "voucher_authorize")
	private String voucherAuthorize;

	@Column(name = "voucher_authorize_id")
	private int voucherAuthorizeId;

	@Column(name = "voucher_authorize_time")
	private Date voucherAuthorizeTime;

	@Column(name = "voucher_billing_add")
	private String voucherBillingAdd;

	@Column(name = "voucher_branch_id")
	private int voucherBranchId;

	@Column(name = "voucher_cashdiscount")
	private double voucherCashdiscount;

	@Column(name = "voucher_consignee_add")
	private String voucherConsigneeAdd;

	@Column(name = "voucher_contact_id")
	private int voucherContactId;

	@Column(name = "voucher_critical")
	private String voucherCritical;

	@Column(name = "voucher_customer_id")
	private int voucherCustomerId;

	@Column(name = "voucher_custref_date")
	private Date voucherCustrefDate;

	@Column(name = "voucher_custref_no")
	private String voucherCustrefNo;

	@Column(name = "voucher_date")
	private Date voucherDate;

	@Column(name = "voucher_dcr_id")
	private int voucherDcrId;

	@Column(name = "voucher_dcr_request_id")
	private int voucherDcrRequestId;

	@Column(name = "voucher_delivery_date")
	private Date voucherDeliveryDate;

	@Column(name = "voucher_delnote_id")
	private int voucherDelnoteId;

	@Column(name = "voucher_delstatus_id")
	private int voucherDelstatusId;

	@Column(name = "voucher_downpayment")
	private double voucherDownpayment;

	@Column(name = "voucher_driver_no")
	private String voucherDriverNo;

	@Column(name = "voucher_emp_id")
	private int voucherEmpId;

	@Column(name = "voucher_entry_date")
	private Date voucherEntryDate;

	@Column(name = "voucher_entry_id")
	private int voucherEntryId;

	@Column(name = "voucher_entry_type")
	private int voucherEntryType;

	@Column(name = "voucher_fitted")
	private String voucherFitted;

	@Column(name = "voucher_gatedate")
	private Date voucherGatedate;

	@Column(name = "voucher_gatepass")
	private String voucherGatepass;

	@Column(name = "voucher_git_id")
	private int voucherGitId;

	@Column(name = "voucher_grn_id")
	private int voucherGrnId;

	@Column(name = "voucher_grn_return_id")
	private int voucherGrnReturnId;

	@Column(name = "voucher_inactivestatus_date")
	private Date voucherInactivestatusDate;

	@Column(name = "voucher_inactivestatus_id")
	private int voucherInactivestatusId;

	@Column(name = "voucher_invoice_id")
	private int voucherInvoiceId;

	@Column(name = "voucher_jc_id")
	private int voucherJcId;

	@Column(name = "voucher_lead_id")
	private int voucherLeadId;

	@Column(name = "voucher_location_id")
	private int voucherLocationId;

	@Column(name = "voucher_lrno")
	private String voucherLrno;

	@Column(name = "voucher_modified_date")
	private Date voucherModifiedDate;

	@Column(name = "voucher_modified_id")
	private int voucherModifiedId;

	@Column(name = "voucher_narration")
	private String voucherNarration;

	@Column(name = "voucher_no")
	private int voucherNo;

	@Column(name = "voucher_notes")
	private String voucherNotes;

	@Column(name = "voucher_open")
	private String voucherOpen;

	@Column(name = "voucher_oppr_id")
	private int voucherOpprId;

	@Column(name = "voucher_paydays_id")
	private String voucherPaydaysId;

	@Column(name = "voucher_payment_date")
	private Date voucherPaymentDate;

	@Column(name = "voucher_pending")
	private String voucherPending;

	@Column(name = "voucher_po_id")
	private int voucherPoId;

	@Column(name = "voucher_preorder_id")
	private int voucherPreorderId;

	@Column(name = "voucher_promise_date")
	private Date voucherPromiseDate;

	@Column(name = "voucher_quote_id")
	private int voucherQuoteId;

	@Column(name = "voucher_rateclass_id")
	private int voucherRateclassId;

	@Column(name = "voucher_ref_customer_id")
	private int voucherRefCustomerId;

	@Column(name = "voucher_ref_no")
	private String voucherRefNo;

	@Column(name = "voucher_so_id")
	private int voucherSoId;

	@Column(name = "voucher_special")
	private String voucherSpecial;

	@Column(name = "voucher_stockadj_id")
	private int voucherStockadjId;

	@Column(name = "voucher_stocktransfer_id")
	private int voucherStocktransferId;

	@Column(name = "voucher_tag_id")
	private int voucherTagId;

	@Column(name = "voucher_tempo_no")
	private String voucherTempoNo;

	@Lob
	@Column(name = "voucher_terms")
	private String voucherTerms;

	@Column(name = "voucher_transporter")
	private String voucherTransporter;

	@Column(name = "voucher_truckspace")
	private BigDecimal voucherTruckspace;

	@Column(name = "voucher_turnoverdisc")
	private double voucherTurnoverdisc;

	@Column(name = "voucher_vehstock_id")
	private int voucherVehstockId;

	@Column(name = "voucher_vouchertype_id")
	private int voucherVouchertypeId;

	@Column(name = "voucher_warranty")
	private String voucherWarranty;

	public AxelaAccVoucher() {
	}

	public int getVoucherId() {
		return this.voucherId;
	}

	public void setVoucherId(int voucherId) {
		this.voucherId = voucherId;
	}

	public String getVoucherActive() {
		return this.voucherActive;
	}

	public void setVoucherActive(String voucherActive) {
		this.voucherActive = voucherActive;
	}

	public String getVoucherAdvance() {
		return this.voucherAdvance;
	}

	public void setVoucherAdvance(String voucherAdvance) {
		this.voucherAdvance = voucherAdvance;
	}

	public BigDecimal getVoucherAmount() {
		return this.voucherAmount;
	}

	public void setVoucherAmount(BigDecimal voucherAmount) {
		this.voucherAmount = voucherAmount;
	}

	public String getVoucherAuthorize() {
		return this.voucherAuthorize;
	}

	public void setVoucherAuthorize(String voucherAuthorize) {
		this.voucherAuthorize = voucherAuthorize;
	}

	public int getVoucherAuthorizeId() {
		return this.voucherAuthorizeId;
	}

	public void setVoucherAuthorizeId(int voucherAuthorizeId) {
		this.voucherAuthorizeId = voucherAuthorizeId;
	}

	public Date getVoucherAuthorizeTime() {
		return this.voucherAuthorizeTime;
	}

	public void setVoucherAuthorizeTime(Date voucherAuthorizeTime) {
		this.voucherAuthorizeTime = voucherAuthorizeTime;
	}

	public String getVoucherBillingAdd() {
		return this.voucherBillingAdd;
	}

	public void setVoucherBillingAdd(String voucherBillingAdd) {
		this.voucherBillingAdd = voucherBillingAdd;
	}

	public int getVoucherBranchId() {
		return this.voucherBranchId;
	}

	public void setVoucherBranchId(int voucherBranchId) {
		this.voucherBranchId = voucherBranchId;
	}

	public double getVoucherCashdiscount() {
		return this.voucherCashdiscount;
	}

	public void setVoucherCashdiscount(double voucherCashdiscount) {
		this.voucherCashdiscount = voucherCashdiscount;
	}

	public String getVoucherConsigneeAdd() {
		return this.voucherConsigneeAdd;
	}

	public void setVoucherConsigneeAdd(String voucherConsigneeAdd) {
		this.voucherConsigneeAdd = voucherConsigneeAdd;
	}

	public int getVoucherContactId() {
		return this.voucherContactId;
	}

	public void setVoucherContactId(int voucherContactId) {
		this.voucherContactId = voucherContactId;
	}

	public String getVoucherCritical() {
		return this.voucherCritical;
	}

	public void setVoucherCritical(String voucherCritical) {
		this.voucherCritical = voucherCritical;
	}

	public int getVoucherCustomerId() {
		return this.voucherCustomerId;
	}

	public void setVoucherCustomerId(int voucherCustomerId) {
		this.voucherCustomerId = voucherCustomerId;
	}

	public Date getVoucherCustrefDate() {
		return this.voucherCustrefDate;
	}

	public void setVoucherCustrefDate(Date voucherCustrefDate) {
		this.voucherCustrefDate = voucherCustrefDate;
	}

	public String getVoucherCustrefNo() {
		return this.voucherCustrefNo;
	}

	public void setVoucherCustrefNo(String voucherCustrefNo) {
		this.voucherCustrefNo = voucherCustrefNo;
	}

	public Date getVoucherDate() {
		return this.voucherDate;
	}

	public void setVoucherDate(Date voucherDate) {
		this.voucherDate = voucherDate;
	}

	public int getVoucherDcrId() {
		return this.voucherDcrId;
	}

	public void setVoucherDcrId(int voucherDcrId) {
		this.voucherDcrId = voucherDcrId;
	}

	public int getVoucherDcrRequestId() {
		return this.voucherDcrRequestId;
	}

	public void setVoucherDcrRequestId(int voucherDcrRequestId) {
		this.voucherDcrRequestId = voucherDcrRequestId;
	}

	public Date getVoucherDeliveryDate() {
		return this.voucherDeliveryDate;
	}

	public void setVoucherDeliveryDate(Date voucherDeliveryDate) {
		this.voucherDeliveryDate = voucherDeliveryDate;
	}

	public int getVoucherDelnoteId() {
		return this.voucherDelnoteId;
	}

	public void setVoucherDelnoteId(int voucherDelnoteId) {
		this.voucherDelnoteId = voucherDelnoteId;
	}

	public int getVoucherDelstatusId() {
		return this.voucherDelstatusId;
	}

	public void setVoucherDelstatusId(int voucherDelstatusId) {
		this.voucherDelstatusId = voucherDelstatusId;
	}

	public double getVoucherDownpayment() {
		return this.voucherDownpayment;
	}

	public void setVoucherDownpayment(double voucherDownpayment) {
		this.voucherDownpayment = voucherDownpayment;
	}

	public String getVoucherDriverNo() {
		return this.voucherDriverNo;
	}

	public void setVoucherDriverNo(String voucherDriverNo) {
		this.voucherDriverNo = voucherDriverNo;
	}

	public int getVoucherEmpId() {
		return this.voucherEmpId;
	}

	public void setVoucherEmpId(int voucherEmpId) {
		this.voucherEmpId = voucherEmpId;
	}

	public Date getVoucherEntryDate() {
		return this.voucherEntryDate;
	}

	public void setVoucherEntryDate(Date voucherEntryDate) {
		this.voucherEntryDate = voucherEntryDate;
	}

	public int getVoucherEntryId() {
		return this.voucherEntryId;
	}

	public void setVoucherEntryId(int voucherEntryId) {
		this.voucherEntryId = voucherEntryId;
	}

	public int getVoucherEntryType() {
		return this.voucherEntryType;
	}

	public void setVoucherEntryType(int voucherEntryType) {
		this.voucherEntryType = voucherEntryType;
	}

	public String getVoucherFitted() {
		return this.voucherFitted;
	}

	public void setVoucherFitted(String voucherFitted) {
		this.voucherFitted = voucherFitted;
	}

	public Date getVoucherGatedate() {
		return this.voucherGatedate;
	}

	public void setVoucherGatedate(Date voucherGatedate) {
		this.voucherGatedate = voucherGatedate;
	}

	public String getVoucherGatepass() {
		return this.voucherGatepass;
	}

	public void setVoucherGatepass(String voucherGatepass) {
		this.voucherGatepass = voucherGatepass;
	}

	public int getVoucherGitId() {
		return this.voucherGitId;
	}

	public void setVoucherGitId(int voucherGitId) {
		this.voucherGitId = voucherGitId;
	}

	public int getVoucherGrnId() {
		return this.voucherGrnId;
	}

	public void setVoucherGrnId(int voucherGrnId) {
		this.voucherGrnId = voucherGrnId;
	}

	public int getVoucherGrnReturnId() {
		return this.voucherGrnReturnId;
	}

	public void setVoucherGrnReturnId(int voucherGrnReturnId) {
		this.voucherGrnReturnId = voucherGrnReturnId;
	}

	public Date getVoucherInactivestatusDate() {
		return this.voucherInactivestatusDate;
	}

	public void setVoucherInactivestatusDate(Date voucherInactivestatusDate) {
		this.voucherInactivestatusDate = voucherInactivestatusDate;
	}

	public int getVoucherInactivestatusId() {
		return this.voucherInactivestatusId;
	}

	public void setVoucherInactivestatusId(int voucherInactivestatusId) {
		this.voucherInactivestatusId = voucherInactivestatusId;
	}

	public int getVoucherInvoiceId() {
		return this.voucherInvoiceId;
	}

	public void setVoucherInvoiceId(int voucherInvoiceId) {
		this.voucherInvoiceId = voucherInvoiceId;
	}

	public int getVoucherJcId() {
		return this.voucherJcId;
	}

	public void setVoucherJcId(int voucherJcId) {
		this.voucherJcId = voucherJcId;
	}

	public int getVoucherLeadId() {
		return this.voucherLeadId;
	}

	public void setVoucherLeadId(int voucherLeadId) {
		this.voucherLeadId = voucherLeadId;
	}

	public int getVoucherLocationId() {
		return this.voucherLocationId;
	}

	public void setVoucherLocationId(int voucherLocationId) {
		this.voucherLocationId = voucherLocationId;
	}

	public String getVoucherLrno() {
		return this.voucherLrno;
	}

	public void setVoucherLrno(String voucherLrno) {
		this.voucherLrno = voucherLrno;
	}

	public Date getVoucherModifiedDate() {
		return this.voucherModifiedDate;
	}

	public void setVoucherModifiedDate(Date voucherModifiedDate) {
		this.voucherModifiedDate = voucherModifiedDate;
	}

	public int getVoucherModifiedId() {
		return this.voucherModifiedId;
	}

	public void setVoucherModifiedId(int voucherModifiedId) {
		this.voucherModifiedId = voucherModifiedId;
	}

	public String getVoucherNarration() {
		return this.voucherNarration;
	}

	public void setVoucherNarration(String voucherNarration) {
		this.voucherNarration = voucherNarration;
	}

	public int getVoucherNo() {
		return this.voucherNo;
	}

	public void setVoucherNo(int voucherNo) {
		this.voucherNo = voucherNo;
	}

	public String getVoucherNotes() {
		return this.voucherNotes;
	}

	public void setVoucherNotes(String voucherNotes) {
		this.voucherNotes = voucherNotes;
	}

	public String getVoucherOpen() {
		return this.voucherOpen;
	}

	public void setVoucherOpen(String voucherOpen) {
		this.voucherOpen = voucherOpen;
	}

	public int getVoucherOpprId() {
		return this.voucherOpprId;
	}

	public void setVoucherOpprId(int voucherOpprId) {
		this.voucherOpprId = voucherOpprId;
	}

	public String getVoucherPaydaysId() {
		return this.voucherPaydaysId;
	}

	public void setVoucherPaydaysId(String voucherPaydaysId) {
		this.voucherPaydaysId = voucherPaydaysId;
	}

	public Date getVoucherPaymentDate() {
		return this.voucherPaymentDate;
	}

	public void setVoucherPaymentDate(Date voucherPaymentDate) {
		this.voucherPaymentDate = voucherPaymentDate;
	}

	public String getVoucherPending() {
		return this.voucherPending;
	}

	public void setVoucherPending(String voucherPending) {
		this.voucherPending = voucherPending;
	}

	public int getVoucherPoId() {
		return this.voucherPoId;
	}

	public void setVoucherPoId(int voucherPoId) {
		this.voucherPoId = voucherPoId;
	}

	public int getVoucherPreorderId() {
		return this.voucherPreorderId;
	}

	public void setVoucherPreorderId(int voucherPreorderId) {
		this.voucherPreorderId = voucherPreorderId;
	}

	public Date getVoucherPromiseDate() {
		return this.voucherPromiseDate;
	}

	public void setVoucherPromiseDate(Date voucherPromiseDate) {
		this.voucherPromiseDate = voucherPromiseDate;
	}

	public int getVoucherQuoteId() {
		return this.voucherQuoteId;
	}

	public void setVoucherQuoteId(int voucherQuoteId) {
		this.voucherQuoteId = voucherQuoteId;
	}

	public int getVoucherRateclassId() {
		return this.voucherRateclassId;
	}

	public void setVoucherRateclassId(int voucherRateclassId) {
		this.voucherRateclassId = voucherRateclassId;
	}

	public int getVoucherRefCustomerId() {
		return this.voucherRefCustomerId;
	}

	public void setVoucherRefCustomerId(int voucherRefCustomerId) {
		this.voucherRefCustomerId = voucherRefCustomerId;
	}

	public String getVoucherRefNo() {
		return this.voucherRefNo;
	}

	public void setVoucherRefNo(String voucherRefNo) {
		this.voucherRefNo = voucherRefNo;
	}

	public int getVoucherSoId() {
		return this.voucherSoId;
	}

	public void setVoucherSoId(int voucherSoId) {
		this.voucherSoId = voucherSoId;
	}

	public String getVoucherSpecial() {
		return this.voucherSpecial;
	}

	public void setVoucherSpecial(String voucherSpecial) {
		this.voucherSpecial = voucherSpecial;
	}

	public int getVoucherStockadjId() {
		return this.voucherStockadjId;
	}

	public void setVoucherStockadjId(int voucherStockadjId) {
		this.voucherStockadjId = voucherStockadjId;
	}

	public int getVoucherStocktransferId() {
		return this.voucherStocktransferId;
	}

	public void setVoucherStocktransferId(int voucherStocktransferId) {
		this.voucherStocktransferId = voucherStocktransferId;
	}

	public int getVoucherTagId() {
		return this.voucherTagId;
	}

	public void setVoucherTagId(int voucherTagId) {
		this.voucherTagId = voucherTagId;
	}

	public String getVoucherTempoNo() {
		return this.voucherTempoNo;
	}

	public void setVoucherTempoNo(String voucherTempoNo) {
		this.voucherTempoNo = voucherTempoNo;
	}

	public String getVoucherTerms() {
		return this.voucherTerms;
	}

	public void setVoucherTerms(String voucherTerms) {
		this.voucherTerms = voucherTerms;
	}

	public String getVoucherTransporter() {
		return this.voucherTransporter;
	}

	public void setVoucherTransporter(String voucherTransporter) {
		this.voucherTransporter = voucherTransporter;
	}

	public BigDecimal getVoucherTruckspace() {
		return this.voucherTruckspace;
	}

	public void setVoucherTruckspace(BigDecimal voucherTruckspace) {
		this.voucherTruckspace = voucherTruckspace;
	}

	public double getVoucherTurnoverdisc() {
		return this.voucherTurnoverdisc;
	}

	public void setVoucherTurnoverdisc(double voucherTurnoverdisc) {
		this.voucherTurnoverdisc = voucherTurnoverdisc;
	}

	public int getVoucherVehstockId() {
		return this.voucherVehstockId;
	}

	public void setVoucherVehstockId(int voucherVehstockId) {
		this.voucherVehstockId = voucherVehstockId;
	}

	public int getVoucherVouchertypeId() {
		return this.voucherVouchertypeId;
	}

	public void setVoucherVouchertypeId(int voucherVouchertypeId) {
		this.voucherVouchertypeId = voucherVouchertypeId;
	}

	public String getVoucherWarranty() {
		return this.voucherWarranty;
	}

	public void setVoucherWarranty(String voucherWarranty) {
		this.voucherWarranty = voucherWarranty;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "voucher_emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "voucher_branch_id", referencedColumnName = "branch_id", insertable = false, updatable = false)
	private AxelaBranch axelaBranch;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "voucher_vouchertype_id", referencedColumnName = "vouchertype_id", insertable = false, updatable = false)
	private AxelaAccVoucherType axelaAccvouchertype;

	@OneToMany(mappedBy = "axelaAccvoucher", cascade = CascadeType.ALL)
	private List<AxelaAccVoucherTran> axelaAccVoucherTran;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "voucher_customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
	private AxelaCustomer axelaCustomer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "voucher_contact_id", referencedColumnName = "contact_id", insertable = false, updatable = false)
	private AxelaCustomerContact axelaCustomerContact;
	private short voucherclassAcc;
	// @OneToOne(fetch = FetchType.LAZY)
	// @NotFound(action = NotFoundAction.IGNORE)
	// @JoinColumn(name = "voucher_contact_id", referencedColumnName = "contact_id", insertable = false, updatable = false)
	// private AxelaCustomerContact axelaCustomerContact;

	// @OneToOne(fetch = FetchType.LAZY)
	// @NotFound(action = NotFoundAction.IGNORE)
	// @JoinColumn(name = "voucher_customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
	// private AxelaCustomer axelaCustomer;

	public AxelaAccVoucher(int voucherId,
			int voucherNo,
			BigDecimal voucherAmount,
			int vouchertypeId,
			String branchInvoicePrefix,
			String branchInvoiceSuffix,
			int voucherSoId,
			int vouchertypeVoucherclassId,
			String vouchertypeName,
			String voucherAuthorize,
			String voucherActive,
			// int voucherVehstockId,
			int voucherJcId,
			int voucherCustomerId,
			String customerName,
			String customerEntryDate,
			int voucherContactId,
			String contactFname,
			String contactLname,
			String titleDesc,
			String contactMobile1,
			String contactMobile2,
			String contactPhone1,
			String contactPhone2,
			String contactEmail1,
			String contactEmail2,
			String voucherRefNo,
			String voucherNarration,
			Date voucherDate,
			String empName,
			String branchName,
			String voucherclassFile,
			int voucherEmpId) {
		this.voucherId = voucherId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public long getTodayinvoices() {
		return todayinvoices;
	}

	public void setTodayinvoices(long todayinvoices) {
		this.todayinvoices = todayinvoices;
	}

	public long getTodayreceipts() {
		return todayreceipts;
	}

	public void setTodayreceipts(long todayreceipts) {
		this.todayreceipts = todayreceipts;
	}

	public long getMonthinvoices() {
		return monthinvoices;
	}

	public void setMonthinvoices(long monthinvoices) {
		this.monthinvoices = monthinvoices;
	}

	public long getMonthreceipts() {
		return monthreceipts;
	}

	public void setMonthreceipts(long monthreceipts) {
		this.monthreceipts = monthreceipts;
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

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactMobile1() {
		return contactMobile1;
	}

	public void setContactMobile1(String contactMobile1) {
		this.contactMobile1 = contactMobile1;
	}

	public String getContactEmail1() {
		return contactEmail1;
	}

	public void setContactEmail1(String contactEmail1) {
		this.contactEmail1 = contactEmail1;
	}

	public String getContactMobile2() {
		return contactMobile2;
	}

	public void setContactMobile2(String contactMobile2) {
		this.contactMobile2 = contactMobile2;
	}

	public String getContactEmail2() {
		return contactEmail2;
	}

	public void setContactEmail2(String contactEmail2) {
		this.contactEmail2 = contactEmail2;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getVoucherclassId() {
		return voucherclassId;
	}

	public void setVoucherclassId(int voucherclassId) {
		this.voucherclassId = voucherclassId;
	}

	public String getVouchertypeName() {
		return vouchertypeName;
	}

	public void setVouchertypeName(String vouchertypeName) {
		this.vouchertypeName = vouchertypeName;
	}

	public int getVouchertypeId() {
		return vouchertypeId;
	}

	public void setVouchertypeId(int vouchertypeId) {
		this.vouchertypeId = vouchertypeId;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public int getVouchertypeVoucherclassId() {
		return vouchertypeVoucherclassId;
	}

	public void setVouchertypeVoucherclassId(int vouchertypeVoucherclassId) {
		this.vouchertypeVoucherclassId = vouchertypeVoucherclassId;
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

	public String getEmpRefNo() {
		return empRefNo;
	}

	public void setEmpRefNo(String empRefNo) {
		this.empRefNo = empRefNo;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getVouchertypePrefix() {
		return vouchertypePrefix;
	}

	public void setVouchertypePrefix(String vouchertypePrefix) {
		this.vouchertypePrefix = vouchertypePrefix;
	}

	public String getVouchertypeSuffix() {
		return vouchertypeSuffix;
	}

	public void setVouchertypeSuffix(String vouchertypeSuffix) {
		this.vouchertypeSuffix = vouchertypeSuffix;
	}

	public String getVouchertypeEmailEnable() {
		return vouchertypeEmailEnable;
	}

	public void setVouchertypeEmailEnable(String vouchertypeEmailEnable) {
		this.vouchertypeEmailEnable = vouchertypeEmailEnable;
	}

	public String getVouchertypeSmsEnable() {
		return vouchertypeSmsEnable;
	}

	public void setVouchertypeSmsEnable(String vouchertypeSmsEnable) {
		this.vouchertypeSmsEnable = vouchertypeSmsEnable;
	}

	public String getVouchertypeDocs() {
		return vouchertypeDocs;
	}

	public void setVouchertypeDocs(String vouchertypeDocs) {
		this.vouchertypeDocs = vouchertypeDocs;
	}

	public String getVoucherclassFile() {
		return voucherclassFile;
	}

	public void setVoucherclassFile(String voucherclassFile) {
		this.voucherclassFile = voucherclassFile;
	}

	public AxelaEmp getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(AxelaEmp axelaEmp) {
		this.axelaEmp = axelaEmp;
	}

	public AxelaAccVoucherType getAxelaAccvouchertype() {
		return axelaAccvouchertype;
	}

	public void setAxelaAccvouchertype(AxelaAccVoucherType axelaAccvouchertype) {
		this.axelaAccvouchertype = axelaAccvouchertype;
	}

	public List<AxelaAccVoucherTran> getAxelaAccVoucherTran() {
		return axelaAccVoucherTran;
	}

	public void setAxelaAccVoucherTran(List<AxelaAccVoucherTran> axelaAccVoucherTran) {
		this.axelaAccVoucherTran = axelaAccVoucherTran;
	}

	public AxelaCustomer getAxelaCustomer() {
		return axelaCustomer;
	}

	public void setAxelaCustomer(AxelaCustomer axelaCustomer) {
		this.axelaCustomer = axelaCustomer;
	}

	public AxelaCustomerContact getAxelaCustomerContact() {
		return axelaCustomerContact;
	}

	public void setAxelaCustomerContact(AxelaCustomerContact axelaCustomerContact) {
		this.axelaCustomerContact = axelaCustomerContact;
	}

	public AxelaBranch getAxelaBranch() {
		return axelaBranch;
	}

	public void setAxelaBranch(AxelaBranch axelaBranch) {
		this.axelaBranch = axelaBranch;
	}

	public AxelaAccVoucher(int voucherId,
			int voucherNo,
			BigDecimal voucherAmount,
			int vouchertypeId,
			String branchInvoicePrefix,
			String branchInvoiceSuffix,
			int voucherSoId,
			int vouchertypeVoucherclassId,
			String vouchertypeName,
			String voucherAuthorize,
			String voucherActive,
			int voucherJcId,
			int voucherCustomerId,
			String customerName,
			Date customerEntryDate,
			int voucherContactId,
			String contactFname,
			String contactLname,
			String titleDesc,
			String contactMobile1,
			String contactMobile2,
			String contactPhone1,
			String contactPhone2,
			String contactEmail1,
			String contactEmail2,
			String voucherRefNo,
			String voucherNarration,
			Date voucherDate,
			String empName,
			String branchName,
			String voucherclassFile,
			int voucherEmpId) {
		this.voucherId = voucherId;
		this.voucherAmount = voucherAmount;
		this.vouchertypeId = vouchertypeId;
		this.branchPrefix = branchInvoicePrefix;
		this.branchSuffix = branchInvoiceSuffix;
		this.voucherSoId = voucherSoId;
		this.vouchertypeVoucherclassId = vouchertypeVoucherclassId;
		this.vouchertypeName = vouchertypeName;
		this.voucherAuthorize = voucherAuthorize;
		this.voucherActive = voucherActive;
		this.voucherJcId = voucherJcId;
		this.voucherCustomerId = voucherCustomerId;
		this.customerName = customerName;
		this.customerEntryDate = customerEntryDate;
		this.voucherContactId = voucherContactId;
		this.contactFname = contactFname;
		this.contactLname = contactLname;
		this.titleDesc = titleDesc;
		this.contactMobile1 = contactMobile1;
		this.contactMobile2 = contactMobile2;
		this.contactPhone1 = contactPhone1;
		this.contactPhone2 = contactPhone2;
		this.contactEmail1 = contactEmail1;
		this.contactEmail2 = contactEmail2;
		this.voucherRefNo = voucherRefNo;
		this.voucherNarration = voucherNarration;
		this.voucherDate = voucherDate;
		this.empName = empName;
		this.branchName = branchName;
		this.voucherclassFile = voucherclassFile;
		this.voucherEmpId = voucherEmpId;
	}

	public AxelaAccVoucher(int voucherclassId,
			String voucherclassFile) {
		this.voucherclassId = voucherclassId;
		this.voucherclassFile = voucherclassFile;
	}

	public AxelaAccVoucher(int voucherId,
			BigDecimal voucherAmount,
			Date voucherDate,
			String voucherAuthorize,
			int customerId,
			String customerName,
			String contactName,
			String contactMobile1,
			String contactEmail1,
			String contactMobile2,
			String contactEmail2,
			String branchName,
			String empName,
			int voucherclassId,
			String vouchertypeName,
			int vouchertypeId

	) {

		super();
		this.voucherId = voucherId;
		this.voucherAmount = voucherAmount;
		this.voucherDate = voucherDate;
		this.voucherAuthorize = voucherAuthorize;
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactName = contactName;
		this.contactEmail1 = contactEmail1;
		this.contactMobile1 = contactMobile1;
		this.contactEmail2 = contactEmail2;
		this.contactMobile2 = contactMobile2;
		this.branchName = branchName;
		this.empName = empName;
		this.voucherclassId = voucherclassId;
		this.vouchertypeName = vouchertypeName;
		this.vouchertypeId = vouchertypeId;

	}

	public AxelaAccVoucher(String voucherclassFile,
			short voucherclassAcc,
			String vouchertypeName,
			String vouchertypeMobile,
			String vouchertypeEmail,
			String vouchertypeDob,
			String vouchertypeDnd,
			String vouchertypeAffectsInventory,
			String vouchertypeRefNoEnable,
			String vouchertypeRefNoMandatory,
			String vouchertypeTerms,
			String vouchertypeEmailEnable,
			String vouchertypeEmailAuto,
			String vouchertypeEmailSub,
			String vouchertypeEmailFormat,
			String vouchertypeSmsEnable,
			String vouchertypeSmsAuto,
			String vouchertypeSmsFormat,
			String configAdminEmail,
			String configEmailEnable,
			String configSmsEnable,
			String compEmailEnable,
			String compSmsEnable,
			String vouchertypeBillingAdd,
			String vouchertypeConsigneeAdd,
			String vouchertypeTransporter,
			String vouchertypeGatepass,
			String vouchertypeLrno,
			String vouchertypeTempoNo,
			String vouchertypeDriverNo,
			String vouchertypeCashdiscount,
			String vouchertypeTurnoverdisc) {
		this.voucherclassFile = voucherclassFile;
		this.voucherclassAcc = voucherclassAcc;
		this.vouchertypeName = vouchertypeName;
		this.vouchertypeMobile = vouchertypeMobile;
		this.vouchertypeEmail = vouchertypeEmail;
		this.vouchertypeDob = vouchertypeDob;
		this.vouchertypeDnd = vouchertypeDnd;
		this.vouchertypeAffectsInventory = vouchertypeAffectsInventory;
		this.vouchertypeRefNoEnable = vouchertypeRefNoEnable;
		this.vouchertypeRefNoMandatory = vouchertypeRefNoMandatory;
		this.vouchertypeTerms = vouchertypeTerms;
		this.vouchertypeEmailEnable = vouchertypeEmailEnable;
		this.vouchertypeEmailAuto = vouchertypeEmailAuto;
		this.vouchertypeEmailSub = vouchertypeEmailSub;
		this.vouchertypeEmailFormat = vouchertypeEmailFormat;
		this.vouchertypeSmsEnable = vouchertypeSmsEnable;
		this.vouchertypeSmsAuto = vouchertypeSmsAuto;
		this.vouchertypeSmsFormat = vouchertypeSmsFormat;
		this.configAdminEmail = configAdminEmail;
		this.configEmailEnable = configEmailEnable;
		this.configSmsEnable = configSmsEnable;
		this.compEmailEnable = compEmailEnable;
		this.compSmsEnable = compSmsEnable;
		this.vouchertypeBillingAdd = vouchertypeBillingAdd;
		this.vouchertypeConsigneeAdd = vouchertypeConsigneeAdd;
		this.vouchertypeTransporter = vouchertypeTransporter;
		this.vouchertypeGatepass = vouchertypeGatepass;
		this.vouchertypeLrno = vouchertypeLrno;
		this.vouchertypeTempoNo = vouchertypeTempoNo;
		this.vouchertypeDriverNo = vouchertypeDriverNo;
		this.vouchertypeCashdiscount = vouchertypeCashdiscount;
		this.vouchertypeTurnoverdisc = vouchertypeTurnoverdisc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "voucher_vouchertype_id", referencedColumnName = "vouchertype_id", insertable = false, updatable = false)
	private AxelaAccVoucherType axelaAccVoucherType;
}