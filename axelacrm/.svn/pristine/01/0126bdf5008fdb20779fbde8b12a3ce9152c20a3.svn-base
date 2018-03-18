package axela.inventory.model;

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

import axela.customer.model.AxelaCustomer;
import axela.portal.model.AxelaRateClass;

/**
 * The persistent class for the axela_inventory_item_price database table.
 * 
 */
@Entity
@Table(name = "axela_inventory_item_price", catalog = "axela_1")
@NamedQuery(name = "AxelaInventoryItemPrice.findAll", query = "SELECT a FROM AxelaInventoryItemPrice a")
public class AxelaInventoryItemPrice implements Serializable {
	@Override
	public String toString() {
		return "AxelaInventoryItemPrice [itemCode=" + itemCode + ", itemName=" + itemName + ", rateclassName=" + rateclassName + ", priceId=" + priceId + ", priceActive=" + priceActive
				+ ", priceAmt=" + priceAmt + ", priceCustomerPrice=" + priceCustomerPrice + ", priceDealerexeComm=" + priceDealerexeComm + ", priceDesc=" + priceDesc + ", priceDisc=" + priceDisc
				+ ", priceDiscType=" + priceDiscType + ", priceDiscount1CustomerId=" + priceDiscount1CustomerId + ", priceEffectiveFrom=" + priceEffectiveFrom + ", priceEntryDate=" + priceEntryDate
				+ ", priceEntryId=" + priceEntryId + ", priceExeComm=" + priceExeComm + ", priceItemId=" + priceItemId + ", priceMargin=" + priceMargin + ", priceModifiedDate=" + priceModifiedDate
				+ ", priceModifiedId=" + priceModifiedId + ", priceRateclassId=" + priceRateclassId + ", priceSalesCustomerId=" + priceSalesCustomerId + ", priceTax1Id=" + priceTax1Id
				+ ", priceTax2Id=" + priceTax2Id + ", priceTax3Id=" + priceTax3Id + ", priceTechnicianComm=" + priceTechnicianComm + ", priceVariable=" + priceVariable + ", axelaInventoryItem="
				+ axelaInventoryItem + ", axelaCustomer=" + axelaCustomer + ", axelaCustomer2=" + axelaCustomer2 + ", axelaCustomer3=" + axelaCustomer3 + ", axelaRateClass=" + axelaRateClass + "]";
	}

	private static final long serialVersionUID = 1L;
	@Transient
	private long countPriceItemId;
	@Transient
	private String itemCode;

	@Transient
	private String itemName;

	@Transient
	private String rateclassName;

	@Transient
	private String rateclassType;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "price_id")
	private int priceId;

	@Column(name = "price_active")
	private String priceActive;

	@Column(name = "price_amt")
	private double priceAmt;

	@Column(name = "price_customer_price")
	private double priceCustomerPrice;

	@Column(name = "price_dealerexe_comm")
	private double priceDealerexeComm;

	@Column(name = "price_desc")
	private String priceDesc;

	@Column(name = "price_disc")
	private double priceDisc;

	@Column(name = "price_disc_type")
	private int priceDiscType;

	@Column(name = "price_discount1_customer_id")
	private int priceDiscount1CustomerId;

	@Column(name = "price_effective_from")
	private Date priceEffectiveFrom;

	@Column(name = "price_entry_date")
	private Date priceEntryDate;

	@Column(name = "price_entry_id")
	private int priceEntryId;

	@Column(name = "price_exe_comm")
	private double priceExeComm;

	@Column(name = "price_item_id")
	private int priceItemId;

	@Column(name = "price_margin")
	private double priceMargin;

	@Column(name = "price_modified_date")
	private Date priceModifiedDate;

	@Column(name = "price_modified_id")
	private int priceModifiedId;

	@Column(name = "price_rateclass_id")
	private int priceRateclassId;

	@Column(name = "price_sales_customer_id")
	private int priceSalesCustomerId;

	@Column(name = "price_tax1_id")
	private int priceTax1Id;

	@Column(name = "price_tax2_id")
	private int priceTax2Id;

	@Column(name = "price_tax3_id")
	private int priceTax3Id;

	@Column(name = "price_technician_comm")
	private double priceTechnicianComm;

	@Column(name = "price_variable")
	private String priceVariable;

	public AxelaInventoryItemPrice() {
	}

	public AxelaInventoryItemPrice(
			int priceId,
			int priceItemId,
			String itemCode,
			String itemName,
			String rateclassName,
			double priceDisc,
			double priceAmt,
			String priceActive,
			int priceDiscType) {
		this.priceId = priceId;
		this.priceItemId = priceItemId;
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.rateclassName = rateclassName;
		this.priceDisc = priceDisc;
		this.priceAmt = priceAmt;
		this.priceActive = priceActive;
		this.priceDiscType = priceDiscType;
	}

	// ================mapping========================

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "price_item_id", referencedColumnName = "item_id", insertable = false, updatable = false)
	private AxelaInventoryItem axelaInventoryItem;

	public AxelaInventoryItemPrice(
			int priceId,
			String priceActive,
			double priceAmt,
			String priceDesc,
			double priceDisc,
			int priceDiscType,
			Date priceEffectiveFrom,
			Date priceEntryDate,
			int priceEntryId,
			int priceItemId,
			double priceMargin,
			Date priceModifiedDate,
			int priceModifiedId,
			int priceRateclassId,
			String priceVariable,
			String rateclassType) {
		super();
		this.priceId = priceId;
		this.priceActive = priceActive;
		this.priceAmt = priceAmt;
		this.priceDesc = priceDesc;
		this.priceDisc = priceDisc;
		this.priceDiscType = priceDiscType;
		this.priceEffectiveFrom = priceEffectiveFrom;
		this.priceEntryDate = priceEntryDate;
		this.priceEntryId = priceEntryId;
		this.priceItemId = priceItemId;
		this.priceMargin = priceMargin;
		this.priceModifiedDate = priceModifiedDate;
		this.priceModifiedId = priceModifiedId;
		this.priceRateclassId = priceRateclassId;
		this.priceVariable = priceVariable;
		this.rateclassType = rateclassType;
	}

	public AxelaInventoryItemPrice(long countPriceItemId) {
		super();
		this.countPriceItemId = countPriceItemId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	// tax1.customer_id = price_tax1_id"
	@JoinColumn(name = "price_tax1_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
	private AxelaCustomer axelaCustomer;

	@ManyToOne(fetch = FetchType.LAZY)
	// tax1.customer_id = price_tax1_id"
	@JoinColumn(name = "price_tax2_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
	private AxelaCustomer axelaCustomer2;

	@ManyToOne(fetch = FetchType.LAZY)
	// tax1.customer_id = price_tax1_id"
	@JoinColumn(name = "price_tax3_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
	private AxelaCustomer axelaCustomer3;

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getRateclassName() {
		return rateclassName;
	}

	public void setRateclassName(String rateclassName) {
		this.rateclassName = rateclassName;
	}

	// public AxelaInventoryItem getAxelaInventoryItem() {
	// return axelaInventoryItem;
	// }
	//
	// public void setAxelaInventoryItem(AxelaInventoryItem axelaInventoryItem) {
	// this.axelaInventoryItem = axelaInventoryItem;
	// }

	public AxelaRateClass getAxelaRateClass() {
		return axelaRateClass;
	}

	public void setAxelaRateClass(AxelaRateClass axelaRateClass) {
		this.axelaRateClass = axelaRateClass;
	}

	// One to One association to AxelaInventoryUom
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "price_rateclass_id", referencedColumnName = "rateclass_id", insertable = false, updatable = false)
	private AxelaRateClass axelaRateClass;

	// //////=========================

	public int getPriceId() {
		return this.priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	public String getPriceActive() {
		return this.priceActive;
	}

	public void setPriceActive(String priceActive) {
		this.priceActive = priceActive;
	}

	public double getPriceAmt() {
		return this.priceAmt;
	}

	public void setPriceAmt(double priceAmt) {
		this.priceAmt = priceAmt;
	}

	public double getPriceCustomerPrice() {
		return this.priceCustomerPrice;
	}

	public void setPriceCustomerPrice(double priceCustomerPrice) {
		this.priceCustomerPrice = priceCustomerPrice;
	}

	public double getPriceDealerexeComm() {
		return this.priceDealerexeComm;
	}

	public void setPriceDealerexeComm(double priceDealerexeComm) {
		this.priceDealerexeComm = priceDealerexeComm;
	}

	public String getPriceDesc() {
		return this.priceDesc;
	}

	public void setPriceDesc(String priceDesc) {
		this.priceDesc = priceDesc;
	}

	public double getPriceDisc() {
		return this.priceDisc;
	}

	public void setPriceDisc(double priceDisc) {
		this.priceDisc = priceDisc;
	}

	public int getPriceDiscType() {
		return this.priceDiscType;
	}

	public void setPriceDiscType(int priceDiscType) {
		this.priceDiscType = priceDiscType;
	}

	public int getPriceDiscount1CustomerId() {
		return this.priceDiscount1CustomerId;
	}

	public void setPriceDiscount1CustomerId(int priceDiscount1CustomerId) {
		this.priceDiscount1CustomerId = priceDiscount1CustomerId;
	}

	public Date getPriceEffectiveFrom() {
		return this.priceEffectiveFrom;
	}

	public void setPriceEffectiveFrom(Date priceEffectiveFrom) {
		this.priceEffectiveFrom = priceEffectiveFrom;
	}

	public Date getPriceEntryDate() {
		return this.priceEntryDate;
	}

	public void setPriceEntryDate(Date priceEntryDate) {
		this.priceEntryDate = priceEntryDate;
	}

	public int getPriceEntryId() {
		return this.priceEntryId;
	}

	public void setPriceEntryId(int priceEntryId) {
		this.priceEntryId = priceEntryId;
	}

	public double getPriceExeComm() {
		return this.priceExeComm;
	}

	public void setPriceExeComm(double priceExeComm) {
		this.priceExeComm = priceExeComm;
	}

	public int getPriceItemId() {
		return this.priceItemId;
	}

	public void setPriceItemId(int priceItemId) {
		this.priceItemId = priceItemId;
	}

	public double getPriceMargin() {
		return this.priceMargin;
	}

	public void setPriceMargin(double priceMargin) {
		this.priceMargin = priceMargin;
	}

	public Date getPriceModifiedDate() {
		return this.priceModifiedDate;
	}

	public void setPriceModifiedDate(Date priceModifiedDate) {
		this.priceModifiedDate = priceModifiedDate;
	}

	public int getPriceModifiedId() {
		return this.priceModifiedId;
	}

	public void setPriceModifiedId(int priceModifiedId) {
		this.priceModifiedId = priceModifiedId;
	}

	public int getPriceRateclassId() {
		return this.priceRateclassId;
	}

	public void setPriceRateclassId(int priceRateclassId) {
		this.priceRateclassId = priceRateclassId;
	}

	public int getPriceSalesCustomerId() {
		return this.priceSalesCustomerId;
	}

	public void setPriceSalesCustomerId(int priceSalesCustomerId) {
		this.priceSalesCustomerId = priceSalesCustomerId;
	}

	public int getPriceTax1Id() {
		return this.priceTax1Id;
	}

	public void setPriceTax1Id(int priceTax1Id) {
		this.priceTax1Id = priceTax1Id;
	}

	public int getPriceTax2Id() {
		return this.priceTax2Id;
	}

	public void setPriceTax2Id(int priceTax2Id) {
		this.priceTax2Id = priceTax2Id;
	}

	public int getPriceTax3Id() {
		return this.priceTax3Id;
	}

	public void setPriceTax3Id(int priceTax3Id) {
		this.priceTax3Id = priceTax3Id;
	}

	public double getPriceTechnicianComm() {
		return this.priceTechnicianComm;
	}

	public void setPriceTechnicianComm(double priceTechnicianComm) {
		this.priceTechnicianComm = priceTechnicianComm;
	}

	public String getPriceVariable() {
		return this.priceVariable;
	}

	public void setPriceVariable(String priceVariable) {
		this.priceVariable = priceVariable;
	}

	public long getCountPriceItemId() {
		return countPriceItemId;
	}

	public void setCountPriceItemId(long countPriceItemId) {
		this.countPriceItemId = countPriceItemId;
	}

	public String getRateclassType() {
		return rateclassType;
	}

	public void setRateclassType(String rateclassType) {
		this.rateclassType = rateclassType;
	}

}