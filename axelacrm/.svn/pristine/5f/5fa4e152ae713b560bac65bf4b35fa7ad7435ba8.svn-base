package axela.accounting.model;

import java.io.Serializable;
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

/**
 * The persistent class for the axela_acc_voucher_type database table.
 * 
 */
@Entity
@Table(name = "axela_acc_voucher_type", catalog = "axela_1")
@NamedQuery(name = "AxelaAccVoucherType.findAll", query = "SELECT a FROM AxelaAccVoucherType a")
public class AxelaAccVoucherType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "vouchertype_id")
	private int vouchertypeId;

	@Column(name = "vouchertype_active")
	private String vouchertypeActive;

	@Column(name = "vouchertype_affects_inventory")
	private String vouchertypeAffectsInventory;

	@Column(name = "vouchertype_authorize")
	private String vouchertypeAuthorize;

	@Column(name = "vouchertype_bank_cash_customer_restriction")
	private int vouchertypeBankCashCustomerRestriction;

	@Column(name = "vouchertype_base_type")
	private int vouchertypeBaseType;

	@Column(name = "vouchertype_billing_add")
	private String vouchertypeBillingAdd;

	// public AxelaAccVoucher getAxelaAccVoucher() {
	// return axelaAccVoucher;
	// }
	//
	// public void setAxelaAccVoucher(AxelaAccVoucher axelaAccVoucher) {
	// this.axelaAccVoucher = axelaAccVoucher;
	// }

	@Column(name = "vouchertype_cashdiscount")
	private String vouchertypeCashdiscount;

	@Column(name = "vouchertype_consignee_add")
	private String vouchertypeConsigneeAdd;

	@Column(name = "vouchertype_dnd")
	private String vouchertypeDnd;

	@Column(name = "vouchertype_dob")
	private String vouchertypeDob;

	@Column(name = "vouchertype_docs")
	private String vouchertypeDocs;

	@Column(name = "vouchertype_driver_no")
	private String vouchertypeDriverNo;

	@Column(name = "vouchertype_email")
	private String vouchertypeEmail;

	@Column(name = "vouchertype_email_auto")
	private String vouchertypeEmailAuto;

	@Column(name = "vouchertype_email_enable")
	private String vouchertypeEmailEnable;

	@Lob
	@Column(name = "vouchertype_email_format")
	private String vouchertypeEmailFormat;

	@Column(name = "vouchertype_email_sub")
	private String vouchertypeEmailSub;

	@Column(name = "vouchertype_entry_date")
	private String vouchertypeEntryDate;

	@Column(name = "vouchertype_entry_id")
	private int vouchertypeEntryId;

	@Column(name = "vouchertype_gatepass")
	private String vouchertypeGatepass;

	@Column(name = "vouchertype_label")
	private String vouchertypeLabel;

	@Column(name = "vouchertype_lrno")
	private String vouchertypeLrno;

	@Column(name = "vouchertype_mobile")
	private String vouchertypeMobile;

	@Column(name = "vouchertype_modified_date")
	private String vouchertypeModifiedDate;

	@Column(name = "vouchertype_modified_id")
	private int vouchertypeModifiedId;

	@Column(name = "vouchertype_name")
	private String vouchertypeName;

	@Column(name = "vouchertype_numbering")
	private int vouchertypeNumbering;

	@Column(name = "vouchertype_prefix")
	private String vouchertypePrefix;

	@Column(name = "vouchertype_rank")
	private int vouchertypeRank;

	@Column(name = "vouchertype_ref_no_enable")
	private String vouchertypeRefNoEnable;

	@Column(name = "vouchertype_ref_no_mandatory")
	private String vouchertypeRefNoMandatory;

	@Column(name = "vouchertype_sms_auto")
	private String vouchertypeSmsAuto;

	@Column(name = "vouchertype_sms_enable")
	private String vouchertypeSmsEnable;

	@Column(name = "vouchertype_sms_format")
	private String vouchertypeSmsFormat;

	@Column(name = "vouchertype_suffix")
	private String vouchertypeSuffix;

	@Column(name = "vouchertype_tempo_no")
	private String vouchertypeTempoNo;

	@Lob
	@Column(name = "vouchertype_terms")
	private String vouchertypeTerms;

	@Column(name = "vouchertype_transporter")
	private String vouchertypeTransporter;

	@Column(name = "vouchertype_turnoverdisc")
	private String vouchertypeTurnoverdisc;

	@Column(name = "vouchertype_voucherclass_id")
	private int vouchertypeVoucherclassId;

	@Column(name = "vouchertype_zero_padding")
	private int vouchertypeZeroPadding;

	public AxelaAccVoucherType() {
	}

	public int getVouchertypeId() {
		return this.vouchertypeId;
	}

	public void setVouchertypeId(int vouchertypeId) {
		this.vouchertypeId = vouchertypeId;
	}

	public String getVouchertypeActive() {
		return this.vouchertypeActive;
	}

	public void setVouchertypeActive(String vouchertypeActive) {
		this.vouchertypeActive = vouchertypeActive;
	}

	public String getVouchertypeAffectsInventory() {
		return this.vouchertypeAffectsInventory;
	}

	public void setVouchertypeAffectsInventory(String vouchertypeAffectsInventory) {
		this.vouchertypeAffectsInventory = vouchertypeAffectsInventory;
	}

	public String getVouchertypeAuthorize() {
		return this.vouchertypeAuthorize;
	}

	public void setVouchertypeAuthorize(String vouchertypeAuthorize) {
		this.vouchertypeAuthorize = vouchertypeAuthorize;
	}

	public int getVouchertypeBankCashCustomerRestriction() {
		return this.vouchertypeBankCashCustomerRestriction;
	}

	public void setVouchertypeBankCashCustomerRestriction(int vouchertypeBankCashCustomerRestriction) {
		this.vouchertypeBankCashCustomerRestriction = vouchertypeBankCashCustomerRestriction;
	}

	public int getVouchertypeBaseType() {
		return this.vouchertypeBaseType;
	}

	public void setVouchertypeBaseType(int vouchertypeBaseType) {
		this.vouchertypeBaseType = vouchertypeBaseType;
	}

	public String getVouchertypeBillingAdd() {
		return this.vouchertypeBillingAdd;
	}

	public void setVouchertypeBillingAdd(String vouchertypeBillingAdd) {
		this.vouchertypeBillingAdd = vouchertypeBillingAdd;
	}

	public String getVouchertypeCashdiscount() {
		return this.vouchertypeCashdiscount;
	}

	public void setVouchertypeCashdiscount(String vouchertypeCashdiscount) {
		this.vouchertypeCashdiscount = vouchertypeCashdiscount;
	}

	public String getVouchertypeConsigneeAdd() {
		return this.vouchertypeConsigneeAdd;
	}

	public void setVouchertypeConsigneeAdd(String vouchertypeConsigneeAdd) {
		this.vouchertypeConsigneeAdd = vouchertypeConsigneeAdd;
	}

	public String getVouchertypeDnd() {
		return this.vouchertypeDnd;
	}

	public void setVouchertypeDnd(String vouchertypeDnd) {
		this.vouchertypeDnd = vouchertypeDnd;
	}

	public String getVouchertypeDob() {
		return this.vouchertypeDob;
	}

	public void setVouchertypeDob(String vouchertypeDob) {
		this.vouchertypeDob = vouchertypeDob;
	}

	public String getVouchertypeDocs() {
		return this.vouchertypeDocs;
	}

	public void setVouchertypeDocs(String vouchertypeDocs) {
		this.vouchertypeDocs = vouchertypeDocs;
	}

	public String getVouchertypeDriverNo() {
		return this.vouchertypeDriverNo;
	}

	public void setVouchertypeDriverNo(String vouchertypeDriverNo) {
		this.vouchertypeDriverNo = vouchertypeDriverNo;
	}

	public String getVouchertypeEmail() {
		return this.vouchertypeEmail;
	}

	public void setVouchertypeEmail(String vouchertypeEmail) {
		this.vouchertypeEmail = vouchertypeEmail;
	}

	public String getVouchertypeEmailAuto() {
		return this.vouchertypeEmailAuto;
	}

	public void setVouchertypeEmailAuto(String vouchertypeEmailAuto) {
		this.vouchertypeEmailAuto = vouchertypeEmailAuto;
	}

	public String getVouchertypeEmailEnable() {
		return this.vouchertypeEmailEnable;
	}

	public void setVouchertypeEmailEnable(String vouchertypeEmailEnable) {
		this.vouchertypeEmailEnable = vouchertypeEmailEnable;
	}

	public String getVouchertypeEmailFormat() {
		return this.vouchertypeEmailFormat;
	}

	public void setVouchertypeEmailFormat(String vouchertypeEmailFormat) {
		this.vouchertypeEmailFormat = vouchertypeEmailFormat;
	}

	public String getVouchertypeEmailSub() {
		return this.vouchertypeEmailSub;
	}

	public void setVouchertypeEmailSub(String vouchertypeEmailSub) {
		this.vouchertypeEmailSub = vouchertypeEmailSub;
	}

	public String getVouchertypeEntryDate() {
		return this.vouchertypeEntryDate;
	}

	public void setVouchertypeEntryDate(String vouchertypeEntryDate) {
		this.vouchertypeEntryDate = vouchertypeEntryDate;
	}

	public int getVouchertypeEntryId() {
		return this.vouchertypeEntryId;
	}

	public void setVouchertypeEntryId(int vouchertypeEntryId) {
		this.vouchertypeEntryId = vouchertypeEntryId;
	}

	public String getVouchertypeGatepass() {
		return this.vouchertypeGatepass;
	}

	public void setVouchertypeGatepass(String vouchertypeGatepass) {
		this.vouchertypeGatepass = vouchertypeGatepass;
	}

	public String getVouchertypeLabel() {
		return this.vouchertypeLabel;
	}

	public void setVouchertypeLabel(String vouchertypeLabel) {
		this.vouchertypeLabel = vouchertypeLabel;
	}

	public String getVouchertypeLrno() {
		return this.vouchertypeLrno;
	}

	public void setVouchertypeLrno(String vouchertypeLrno) {
		this.vouchertypeLrno = vouchertypeLrno;
	}

	public String getVouchertypeMobile() {
		return this.vouchertypeMobile;
	}

	public void setVouchertypeMobile(String vouchertypeMobile) {
		this.vouchertypeMobile = vouchertypeMobile;
	}

	public String getVouchertypeModifiedDate() {
		return this.vouchertypeModifiedDate;
	}

	public void setVouchertypeModifiedDate(String vouchertypeModifiedDate) {
		this.vouchertypeModifiedDate = vouchertypeModifiedDate;
	}

	public int getVouchertypeModifiedId() {
		return this.vouchertypeModifiedId;
	}

	public void setVouchertypeModifiedId(int vouchertypeModifiedId) {
		this.vouchertypeModifiedId = vouchertypeModifiedId;
	}

	public String getVouchertypeName() {
		return this.vouchertypeName;
	}

	public void setVouchertypeName(String vouchertypeName) {
		this.vouchertypeName = vouchertypeName;
	}

	public int getVouchertypeNumbering() {
		return this.vouchertypeNumbering;
	}

	public void setVouchertypeNumbering(int vouchertypeNumbering) {
		this.vouchertypeNumbering = vouchertypeNumbering;
	}

	public String getVouchertypePrefix() {
		return this.vouchertypePrefix;
	}

	public void setVouchertypePrefix(String vouchertypePrefix) {
		this.vouchertypePrefix = vouchertypePrefix;
	}

	public int getVouchertypeRank() {
		return this.vouchertypeRank;
	}

	public void setVouchertypeRank(int vouchertypeRank) {
		this.vouchertypeRank = vouchertypeRank;
	}

	public String getVouchertypeRefNoEnable() {
		return this.vouchertypeRefNoEnable;
	}

	public void setVouchertypeRefNoEnable(String vouchertypeRefNoEnable) {
		this.vouchertypeRefNoEnable = vouchertypeRefNoEnable;
	}

	public String getVouchertypeRefNoMandatory() {
		return this.vouchertypeRefNoMandatory;
	}

	public void setVouchertypeRefNoMandatory(String vouchertypeRefNoMandatory) {
		this.vouchertypeRefNoMandatory = vouchertypeRefNoMandatory;
	}

	public String getVouchertypeSmsAuto() {
		return this.vouchertypeSmsAuto;
	}

	public void setVouchertypeSmsAuto(String vouchertypeSmsAuto) {
		this.vouchertypeSmsAuto = vouchertypeSmsAuto;
	}

	public String getVouchertypeSmsEnable() {
		return this.vouchertypeSmsEnable;
	}

	public void setVouchertypeSmsEnable(String vouchertypeSmsEnable) {
		this.vouchertypeSmsEnable = vouchertypeSmsEnable;
	}

	public String getVouchertypeSmsFormat() {
		return this.vouchertypeSmsFormat;
	}

	public void setVouchertypeSmsFormat(String vouchertypeSmsFormat) {
		this.vouchertypeSmsFormat = vouchertypeSmsFormat;
	}

	public String getVouchertypeSuffix() {
		return this.vouchertypeSuffix;
	}

	public void setVouchertypeSuffix(String vouchertypeSuffix) {
		this.vouchertypeSuffix = vouchertypeSuffix;
	}

	public String getVouchertypeTempoNo() {
		return this.vouchertypeTempoNo;
	}

	public void setVouchertypeTempoNo(String vouchertypeTempoNo) {
		this.vouchertypeTempoNo = vouchertypeTempoNo;
	}

	public String getVouchertypeTerms() {
		return this.vouchertypeTerms;
	}

	public void setVouchertypeTerms(String vouchertypeTerms) {
		this.vouchertypeTerms = vouchertypeTerms;
	}

	public String getVouchertypeTransporter() {
		return this.vouchertypeTransporter;
	}

	public void setVouchertypeTransporter(String vouchertypeTransporter) {
		this.vouchertypeTransporter = vouchertypeTransporter;
	}

	public String getVouchertypeTurnoverdisc() {
		return this.vouchertypeTurnoverdisc;
	}

	public void setVouchertypeTurnoverdisc(String vouchertypeTurnoverdisc) {
		this.vouchertypeTurnoverdisc = vouchertypeTurnoverdisc;
	}

	public int getVouchertypeVoucherclassId() {
		return this.vouchertypeVoucherclassId;
	}

	public void setVouchertypeVoucherclassId(int vouchertypeVoucherclassId) {
		this.vouchertypeVoucherclassId = vouchertypeVoucherclassId;
	}

	public int getVouchertypeZeroPadding() {
		return this.vouchertypeZeroPadding;
	}

	public void setVouchertypeZeroPadding(int vouchertypeZeroPadding) {
		this.vouchertypeZeroPadding = vouchertypeZeroPadding;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vouchertype_voucherclass_id", referencedColumnName = "voucherclass_id", insertable = false, updatable = false)
	private AxelaAccVoucherClass axelaAccvoucherclass;

	// @OneToOne(fetch = FetchType.LAZY)(mappedBy = "axelaAccVoucherType", cascade = CascadeType.ALL)
	// @NotFound(action = NotFoundAction.IGNORE)
	// public AxelaAccVoucher axelaAccVoucher;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vouchertype_voucherclass_id", referencedColumnName = "voucherclass_id", insertable = false, updatable = false)
	private AxelaAccVoucherClass axelaAccVoucherClass;

	public AxelaAccVoucherClass getAxelaAccvoucherclass() {
		return axelaAccvoucherclass;
	}

	public void setAxelaAccvoucherclass(AxelaAccVoucherClass axelaAccvoucherclass) {
		this.axelaAccvoucherclass = axelaAccvoucherclass;
	}

	public AxelaAccVoucherClass getAxelaAccVoucherClass() {
		return axelaAccVoucherClass;
	}

	public void setAxelaAccVoucherClass(AxelaAccVoucherClass axelaAccVoucherClass) {
		this.axelaAccVoucherClass = axelaAccVoucherClass;
	}

	@OneToMany(mappedBy = "axelaAccVoucherType", cascade = CascadeType.ALL)
	private List<AxelaAccVoucher> axelaAccVoucher;

}