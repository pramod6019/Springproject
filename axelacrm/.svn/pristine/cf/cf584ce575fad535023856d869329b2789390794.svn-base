package axela.portal.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import axela.accounting.model.AxelaAccVoucher;
import axela.inventory.model.AxelaInventoryItem;

/**
 * The persistent class for the axela_acc_voucher_trans database table.
 * 
 */
@Entity
@Table(name = "axela_acc_voucher_trans", catalog = "axela_1")
@NamedQuery(name = "AxelaAccVoucherTran.findAll", query = "SELECT a FROM AxelaAccVoucherTran a")
public class AxelaAccVoucherTran implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "vouchertrans_id")
	private int vouchertransId;

	@Column(name = "vouchertrans_amount")
	private BigDecimal vouchertransAmount;

	@Column(name = "vouchertrans_cheque_bank")
	private String vouchertransChequeBank;

	@Column(name = "vouchertrans_cheque_branch")
	private String vouchertransChequeBranch;

	@Column(name = "vouchertrans_cheque_date")
	private String vouchertransChequeDate;

	@Column(name = "vouchertrans_cheque_no")
	private String vouchertransChequeNo;

	@Column(name = "vouchertrans_convfactor")
	private int vouchertransConvfactor;

	@Column(name = "vouchertrans_dc")
	private String vouchertransDc;

	@Column(name = "vouchertrans_delivery_date")
	private String vouchertransDeliveryDate;

	@Column(name = "vouchertrans_discount")
	private String vouchertransDiscount;

	@Column(name = "vouchertrans_item_batch_id")
	private int vouchertransItemBatchId;

	@Column(name = "vouchertrans_item_id")
	private int vouchertransItemId;

	@Column(name = "vouchertrans_item_serial")
	private String vouchertransItemSerial;

	// @Column(name = "vouchertrans_ledger_id")
	// private int vouchertransLedgerId;

	@Column(name = "vouchertrans_location_id")
	private int vouchertransLocationId;

	@Column(name = "vouchertrans_netprice")
	private double vouchertransNetprice;

	@Column(name = "vouchertrans_option_group")
	private String vouchertransOptionGroup;

	@Column(name = "vouchertrans_option_id")
	private int vouchertransOptionId;

	@Column(name = "vouchertrans_paymode_id")
	private int vouchertransPaymodeId;

	@Column(name = "vouchertrans_price")
	private double vouchertransPrice;

	@Column(name = "vouchertrans_qty")
	private double vouchertransQty;

	@Column(name = "vouchertrans_reconciliation")
	private String vouchertransReconciliation;

	@Column(name = "vouchertrans_reconciliation_date")
	private String vouchertransReconciliationDate;

	@Column(name = "vouchertrans_reconciliation_emp_id")
	private int vouchertransReconciliationEmpId;

	@Column(name = "vouchertrans_rowcount")
	private int vouchertransRowcount;

	@Column(name = "vouchertrans_supplier_code")
	private String vouchertransSupplierCode;

	// @Column(name = "vouchertrans_supplier_qty")
	// private double vouchertransSupplierQty;

	// @Column(name = "vouchertrans_supplier_uom_id")
	// private int vouchertransSupplierUomId;

	@Column(name = "vouchertrans_tax")
	private String vouchertransTax;

	@Column(name = "vouchertrans_tax_id")
	private int vouchertransTaxId;

	@Column(name = "vouchertrans_time")
	private String vouchertransTime;

	@Column(name = "vouchertrans_unit_cost")
	private double vouchertransUnitCost;

	@Column(name = "vouchertrans_voucher_id")
	private int vouchertransVoucherId;

	public AxelaAccVoucherTran() {
	}

	public int getVouchertransId() {
		return this.vouchertransId;
	}

	public void setVouchertransId(int vouchertransId) {
		this.vouchertransId = vouchertransId;
	}

	public BigDecimal getVouchertransAmount() {
		return this.vouchertransAmount;
	}

	public void setVouchertransAmount(BigDecimal vouchertransAmount) {
		this.vouchertransAmount = vouchertransAmount;
	}

	public String getVouchertransChequeBank() {
		return this.vouchertransChequeBank;
	}

	public void setVouchertransChequeBank(String vouchertransChequeBank) {
		this.vouchertransChequeBank = vouchertransChequeBank;
	}

	public String getVouchertransChequeBranch() {
		return this.vouchertransChequeBranch;
	}

	public void setVouchertransChequeBranch(String vouchertransChequeBranch) {
		this.vouchertransChequeBranch = vouchertransChequeBranch;
	}

	public String getVouchertransChequeDate() {
		return this.vouchertransChequeDate;
	}

	public void setVouchertransChequeDate(String vouchertransChequeDate) {
		this.vouchertransChequeDate = vouchertransChequeDate;
	}

	public String getVouchertransChequeNo() {
		return this.vouchertransChequeNo;
	}

	public void setVouchertransChequeNo(String vouchertransChequeNo) {
		this.vouchertransChequeNo = vouchertransChequeNo;
	}

	public int getVouchertransConvfactor() {
		return this.vouchertransConvfactor;
	}

	public void setVouchertransConvfactor(int vouchertransConvfactor) {
		this.vouchertransConvfactor = vouchertransConvfactor;
	}

	public String getVouchertransDc() {
		return this.vouchertransDc;
	}

	public void setVouchertransDc(String vouchertransDc) {
		this.vouchertransDc = vouchertransDc;
	}

	public String getVouchertransDeliveryDate() {
		return this.vouchertransDeliveryDate;
	}

	public void setVouchertransDeliveryDate(String vouchertransDeliveryDate) {
		this.vouchertransDeliveryDate = vouchertransDeliveryDate;
	}

	public String getVouchertransDiscount() {
		return this.vouchertransDiscount;
	}

	public void setVouchertransDiscount(String vouchertransDiscount) {
		this.vouchertransDiscount = vouchertransDiscount;
	}

	public int getVouchertransItemBatchId() {
		return this.vouchertransItemBatchId;
	}

	public void setVouchertransItemBatchId(int vouchertransItemBatchId) {
		this.vouchertransItemBatchId = vouchertransItemBatchId;
	}

	public int getVouchertransItemId() {
		return this.vouchertransItemId;
	}

	public void setVouchertransItemId(int vouchertransItemId) {
		this.vouchertransItemId = vouchertransItemId;
	}

	public String getVouchertransItemSerial() {
		return this.vouchertransItemSerial;
	}

	public void setVouchertransItemSerial(String vouchertransItemSerial) {
		this.vouchertransItemSerial = vouchertransItemSerial;
	}

	public int getVouchertransLocationId() {
		return this.vouchertransLocationId;
	}

	public void setVouchertransLocationId(int vouchertransLocationId) {
		this.vouchertransLocationId = vouchertransLocationId;
	}

	public double getVouchertransNetprice() {
		return this.vouchertransNetprice;
	}

	public void setVouchertransNetprice(double vouchertransNetprice) {
		this.vouchertransNetprice = vouchertransNetprice;
	}

	public String getVouchertransOptionGroup() {
		return this.vouchertransOptionGroup;
	}

	public void setVouchertransOptionGroup(String vouchertransOptionGroup) {
		this.vouchertransOptionGroup = vouchertransOptionGroup;
	}

	public int getVouchertransOptionId() {
		return this.vouchertransOptionId;
	}

	public void setVouchertransOptionId(int vouchertransOptionId) {
		this.vouchertransOptionId = vouchertransOptionId;
	}

	public int getVouchertransPaymodeId() {
		return this.vouchertransPaymodeId;
	}

	public void setVouchertransPaymodeId(int vouchertransPaymodeId) {
		this.vouchertransPaymodeId = vouchertransPaymodeId;
	}

	public double getVouchertransPrice() {
		return this.vouchertransPrice;
	}

	public void setVouchertransPrice(double vouchertransPrice) {
		this.vouchertransPrice = vouchertransPrice;
	}

	public double getVouchertransQty() {
		return this.vouchertransQty;
	}

	public void setVouchertransQty(double vouchertransQty) {
		this.vouchertransQty = vouchertransQty;
	}

	public String getVouchertransReconciliation() {
		return this.vouchertransReconciliation;
	}

	public void setVouchertransReconciliation(String vouchertransReconciliation) {
		this.vouchertransReconciliation = vouchertransReconciliation;
	}

	public String getVouchertransReconciliationDate() {
		return this.vouchertransReconciliationDate;
	}

	public void setVouchertransReconciliationDate(String vouchertransReconciliationDate) {
		this.vouchertransReconciliationDate = vouchertransReconciliationDate;
	}

	public int getVouchertransReconciliationEmpId() {
		return this.vouchertransReconciliationEmpId;
	}

	public void setVouchertransReconciliationEmpId(int vouchertransReconciliationEmpId) {
		this.vouchertransReconciliationEmpId = vouchertransReconciliationEmpId;
	}

	public int getVouchertransRowcount() {
		return this.vouchertransRowcount;
	}

	public void setVouchertransRowcount(int vouchertransRowcount) {
		this.vouchertransRowcount = vouchertransRowcount;
	}

	public String getVouchertransSupplierCode() {
		return this.vouchertransSupplierCode;
	}

	public void setVouchertransSupplierCode(String vouchertransSupplierCode) {
		this.vouchertransSupplierCode = vouchertransSupplierCode;
	}

	public String getVouchertransTax() {
		return this.vouchertransTax;
	}

	public void setVouchertransTax(String vouchertransTax) {
		this.vouchertransTax = vouchertransTax;
	}

	public int getVouchertransTaxId() {
		return this.vouchertransTaxId;
	}

	public void setVouchertransTaxId(int vouchertransTaxId) {
		this.vouchertransTaxId = vouchertransTaxId;
	}

	public String getVouchertransTime() {
		return this.vouchertransTime;
	}

	public void setVouchertransTime(String vouchertransTime) {
		this.vouchertransTime = vouchertransTime;
	}

	public double getVouchertransUnitCost() {
		return this.vouchertransUnitCost;
	}

	public void setVouchertransUnitCost(double vouchertransUnitCost) {
		this.vouchertransUnitCost = vouchertransUnitCost;
	}

	public int getVouchertransVoucherId() {
		return this.vouchertransVoucherId;
	}

	public void setVouchertransVoucherId(int vouchertransVoucherId) {
		this.vouchertransVoucherId = vouchertransVoucherId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vouchertrans_item_id", referencedColumnName = "item_id", insertable = false, updatable = false)
	private AxelaInventoryItem axelaInventoryitem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vouchertrans_voucher_id", referencedColumnName = "voucher_id", insertable = false, updatable = false)
	private AxelaAccVoucher axelaAccvoucher;

}