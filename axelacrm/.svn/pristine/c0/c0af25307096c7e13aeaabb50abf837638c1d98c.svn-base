package axela.inventory.model;
//shekespeare
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
import javax.persistence.Transient;

import axela.sales.model.AxelaSalesOppr;
import axela.service.model.AxelaServiceJcCheck;

/**
 * The persistent class for the axela_inventory_item database table.
 * 
 */
@Entity
@Table(name = "axela_inventory_item", catalog = "axela_1")
@NamedQuery(name = "AxelaInventoryItem.findAll", query = "SELECT a FROM AxelaInventoryItem a")
public class AxelaInventoryItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Transient
	private int stockStockinorder;
	@Transient
	private int stockStockindemand;
	@Transient
	private double stockUnitCost;
	@Transient
	private double stockOnhandvalue;
	@Transient
	private String locationName;
	@Transient
	private double taxRate1;
	@Transient
	private double taxRate2;
	@Transient
	private double taxRate3;
	@Transient
	private int locationBranchId;
	@Transient
	private int stockLocationId;
	@Transient
	private int stockItemId;
	@Transient
	private double stockCurrentQty;
	@Transient
	private int stockReorderlevel;
	@Transient
	private int rateclassId;
	@Transient
	private String rateclassName;
	@Transient
	private double priceAmt;
	@Transient
	private int priceItemId;
	@Transient
	private String priceVariable;
	@Transient
	private double priceDisc;
	@Transient
	private int priceDiscType;
	@Transient
	private String uomShortname;
	@Transient
	private Date priceEffectiveFrom;
	@Transient
	private String priceDesc;
	@Transient
	private int priceRateclassId;

	@Transient
	private int locationId;

	// =========================================LEFT JOIN variables=================================
	@Transient
	private String modelName = ""; // from axelaInventoryItemModel
	@Transient
	private String uomName = "";// from axelaInventoryUom
	@Transient
	private String catName = "";// from AxelaInventoryCatPop
	@Transient
	private int catId = 0;// from AxelaInventoryCatPop
	// =========================================Entity variables====================================

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_active")
	private String itemActive;

	@Column(name = "item_batchno")
	private String itemBatchno;

	@Column(name = "item_big_desc")
	private String itemBigDesc;

	@Column(name = "item_cat_id")
	private int itemCatId;

	@Column(name = "item_code")
	private String itemCode;

	@Column(name = "item_costtype_id")
	private int itemCosttypeId;

	@Column(name = "item_durcount")
	private int itemDurcount;

	@Column(name = "item_durtype")
	private int itemDurtype;

	@Column(name = "item_entry_date")
	private Date itemEntryDate;

	@Column(name = "item_entry_id")
	private int itemEntryId;

	@Column(name = "item_eoq")
	private int itemEoq;

	@Column(name = "item_featured")
	private String itemFeatured;

	@Column(name = "item_img")
	private String itemImg;

	@Column(name = "item_itemtype_id")
	private int itemItemtypeId;

	@Column(name = "item_laundry_process_id")
	private int itemLaundryProcessId;

	@Column(name = "item_loyaltycard_id")
	private int itemLoyaltycardId;

	@Column(name = "item_model_id")
	private int itemModelId;

	@Column(name = "item_modified_date")
	private Date itemModifiedDate;

	@Column(name = "item_modified_id")
	private int itemModifiedId;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "item_nonstock")
	private String itemNonstock;

	@Column(name = "item_notes")
	private String itemNotes;

	@Column(name = "item_perishable")
	private String itemPerishable;

	@Lob
	@Column(name = "item_pic")
	private byte[] itemPic;

	@Column(name = "item_purchase_ledger_id")
	private int itemPurchaseLedgerId;

	@Column(name = "item_purchasediscount_ledger_id")
	private int itemPurchasediscountLedgerId;

	@Column(name = "item_purchasetax1_ledger_id")
	private int itemPurchasetax1LedgerId;

	@Column(name = "item_purchasetax2_aftertax1")
	private int itemPurchasetax2Aftertax1;

	@Column(name = "item_purchasetax2_ledger_id")
	private int itemPurchasetax2LedgerId;

	@Column(name = "item_purchasetax3_aftertax2")
	private int itemPurchasetax3Aftertax2;

	@Column(name = "item_purchasetax3_ledger_id")
	private int itemPurchasetax3LedgerId;

	@Column(name = "item_reorder_auto")
	private String itemReorderAuto;

	@Column(name = "item_reorder_leaddays")
	private int itemReorderLeaddays;

	@Column(name = "item_sales_ledger_id")
	private int itemSalesLedgerId;

	@Column(name = "item_salesdiscount_ledger_id")
	private int itemSalesdiscountLedgerId;

	@Column(name = "item_salestax1_ledger_id")
	private int itemSalestax1LedgerId;

	@Column(name = "item_salestax2_aftertax1")
	private int itemSalestax2Aftertax1;

	@Column(name = "item_salestax2_ledger_id")
	private int itemSalestax2LedgerId;

	@Column(name = "item_salestax3_aftertax2")
	private int itemSalestax3Aftertax2;

	@Column(name = "item_salestax3_ledger_id")
	private int itemSalestax3LedgerId;

	@Column(name = "item_serial")
	private String itemSerial;

	@Column(name = "item_small_desc")
	private String itemSmallDesc;

	@Column(name = "item_stock")
	private String itemStock;

	@Column(name = "item_ticketqueue_id")
	private int itemTicketqueueId;

	@Column(name = "item_uom_id")
	private int itemUomId;

	public AxelaInventoryItem() {
	}

	public AxelaInventoryItem(int itemId) {
		this.itemId = itemId;
	}

	public AxelaInventoryItem(int itemId,
			int loctionId) {
		this.itemId = itemId;
		this.locationId = loctionId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public AxelaInventoryItem(
			int itemId,
			String itemName,
			String itemCode,
			String itemImg,
			int itemItemtypeId,
			String itemSmallDesc,
			String itemActive,
			int itemEoq,
			String modelName,
			String uomName,
			String catName,
			int catId) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCode = itemCode;
		this.itemImg = itemImg;
		this.itemItemtypeId = itemItemtypeId;
		this.itemSmallDesc = itemSmallDesc;
		this.itemActive = itemActive;
		this.itemEoq = itemEoq;
		this.modelName = modelName;
		this.uomName = uomName;
		this.catName = catName;
		this.catId = catId;
	}

	// =========================================Entity Relationships====================================

	public AxelaInventoryItem(
			int rateclassId,
			String rateclassName,
			double priceAmt,
			int priceItemId,
			String priceVariable,
			double priceDisc,
			int priceDiscType,
			String uomShortname,
			Date priceEffectiveFrom,
			String priceDesc,
			int priceRateclassId,
			int itemId,
			String itemCode,
			String itemName,
			double taxRate1,
			double taxRate2,
			double taxRate3) {
		super();
		this.rateclassId = rateclassId;
		this.rateclassName = rateclassName;
		this.priceAmt = priceAmt;
		this.priceItemId = priceItemId;
		this.priceVariable = priceVariable;
		this.priceDisc = priceDisc;
		this.priceDiscType = priceDiscType;
		this.uomShortname = uomShortname;
		this.priceEffectiveFrom = priceEffectiveFrom;
		this.priceDesc = priceDesc;
		this.priceRateclassId = priceRateclassId;
		this.itemId = itemId;
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.taxRate1 = taxRate1;
		this.taxRate2 = taxRate2;
		this.taxRate3 = taxRate3;
	}

	public AxelaInventoryItem(
			int locationBranchId,
			int stockLocationId,
			int stockItemId,
			double stockCurrentQty,
			int stockReorderlevel,
			String uomName,
			int catId,
			String catName,
			int itemId,
			String itemCode,
			String itemName) {
		super();
		this.locationBranchId = locationBranchId;
		this.stockLocationId = stockLocationId;
		this.stockItemId = stockItemId;
		this.stockCurrentQty = stockCurrentQty;
		this.stockReorderlevel = stockReorderlevel;
		this.uomName = uomName;
		this.catId = catId;
		this.catName = catName;
		this.itemId = itemId;
		this.itemCode = itemCode;
		this.itemName = itemName;
	}

	public AxelaInventoryItem(
			int stockStockinorder,
			int stockStockindemand,
			double stockUnitCost,
			double stockOnhandvalue,
			String locationName,
			double stockCurrentQty,
			int stockReorderlevel,
			String uomName,
			int itemId,
			String itemCode,
			int itemEoq,
			String itemName) {
		super();
		this.stockStockinorder = stockStockinorder;
		this.stockStockindemand = stockStockindemand;
		this.stockUnitCost = stockUnitCost;
		this.stockOnhandvalue = stockOnhandvalue;
		this.locationName = locationName;
		this.stockCurrentQty = stockCurrentQty;
		this.stockReorderlevel = stockReorderlevel;
		this.uomName = uomName;
		this.itemId = itemId;
		this.itemCode = itemCode;
		this.itemEoq = itemEoq;
		this.itemName = itemName;
	}

	public AxelaInventoryItem(
			int itemId,
			String itemName,
			String itemCode,
			String catName) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCode = itemCode;
		this.catName = catName;
	}

	// One to One association to AxelaInventoryItemType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_itemtype_id", referencedColumnName = "itemtype_id", insertable = false, updatable = false)
	private AxelaInventoryItemType axelaInventoryItemType;

	// One to One association to AxelaInventoryUom
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_uom_id", referencedColumnName = "uom_id", insertable = false, updatable = false)
	private AxelaInventoryUom axelaInventoryUom;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_model_id", referencedColumnName = "model_id", insertable = false, updatable = false)
	private AxelaInventoryItemModel axelaInventoryItemModel;

	// One to One association to AxelaInventoryCatPop
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_cat_id", referencedColumnName = "cat_id", insertable = false, updatable = false)
	private AxelaInventoryCatPop axelaInventoryCatPop;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_cat_id", referencedColumnName = "cat_id", insertable = false, updatable = false)
	private AxelaInventoryCat axelaInventoryCat;

	// @ManyToOne(fetch = FetchType.LAZY)
	// ON price_item_id = item_id"
	@OneToMany
	@JoinColumn(name = "price_item_id", referencedColumnName = "item_id", insertable = false, updatable = false)
	private List<AxelaInventoryItemPrice> axelaInventoryItemPrice;

	// @ManyToOne(fetch = FetchType.LAZY)
	// ON stock_item_id = item_id"
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "stock_item_id", referencedColumnName = "item_id", insertable = false, updatable = false)
	private List<AxelaInventoryStock> axelaInventoryStock;

	// One to One association to AxelaInventorySalescatTran

	@OneToMany(mappedBy = "axelaInventoryItem")
	private List<AxelaInventorySalescatTran> axelaInventorySalescatTran;

	@OneToMany(mappedBy = "axelaInventoryItem")
	private List<AxelaSalesOppr> axelaSalesOppr;

	@OneToMany(mappedBy = "axelaInventoryItem")
	private List<AxelaServiceJcCheck> axelaServiceJcCheck;

	// =========================================Entity setters and getters====================================

	public List<AxelaSalesOppr> getAxelaSalesOppr() {
		return axelaSalesOppr;
	}

	public void setAxelaSalesOppr(List<AxelaSalesOppr> axelaSalesOppr) {
		this.axelaSalesOppr = axelaSalesOppr;
	}

	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemActive() {
		return this.itemActive;
	}

	public void setItemActive(String itemActive) {
		this.itemActive = itemActive;
	}

	public String getItemBatchno() {
		return this.itemBatchno;
	}

	public void setItemBatchno(String itemBatchno) {
		this.itemBatchno = itemBatchno;
	}

	public String getItemBigDesc() {
		return this.itemBigDesc;
	}

	public void setItemBigDesc(String itemBigDesc) {
		this.itemBigDesc = itemBigDesc;
	}

	public int getItemCatId() {
		return this.itemCatId;
	}

	public void setItemCatId(int itemCatId) {
		this.itemCatId = itemCatId;
	}

	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public int getItemCosttypeId() {
		return this.itemCosttypeId;
	}

	public void setItemCosttypeId(int itemCosttypeId) {
		this.itemCosttypeId = itemCosttypeId;
	}

	public int getItemDurcount() {
		return this.itemDurcount;
	}

	public void setItemDurcount(int itemDurcount) {
		this.itemDurcount = itemDurcount;
	}

	public int getItemDurtype() {
		return this.itemDurtype;
	}

	public void setItemDurtype(int itemDurtype) {
		this.itemDurtype = itemDurtype;
	}

	public Date getItemEntryDate() {
		return this.itemEntryDate;
	}

	public void setItemEntryDate(Date itemEntryDate) {
		this.itemEntryDate = itemEntryDate;
	}

	public int getItemEntryId() {
		return this.itemEntryId;
	}

	public void setItemEntryId(int itemEntryId) {
		this.itemEntryId = itemEntryId;
	}

	public int getItemEoq() {
		return this.itemEoq;
	}

	public void setItemEoq(int itemEoq) {
		this.itemEoq = itemEoq;
	}

	public String getItemFeatured() {
		return this.itemFeatured;
	}

	public void setItemFeatured(String itemFeatured) {
		this.itemFeatured = itemFeatured;
	}

	public String getItemImg() {
		return this.itemImg;
	}

	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public int getItemItemtypeId() {
		return this.itemItemtypeId;
	}

	public void setItemItemtypeId(int itemItemtypeId) {
		this.itemItemtypeId = itemItemtypeId;
	}

	public int getItemLaundryProcessId() {
		return this.itemLaundryProcessId;
	}

	public void setItemLaundryProcessId(int itemLaundryProcessId) {
		this.itemLaundryProcessId = itemLaundryProcessId;
	}

	public int getItemLoyaltycardId() {
		return this.itemLoyaltycardId;
	}

	public void setItemLoyaltycardId(int itemLoyaltycardId) {
		this.itemLoyaltycardId = itemLoyaltycardId;
	}

	public int getItemModelId() {
		return this.itemModelId;
	}

	public void setItemModelId(int itemModelId) {
		this.itemModelId = itemModelId;
	}

	public Date getItemModifiedDate() {
		return this.itemModifiedDate;
	}

	public void setItemModifiedDate(Date itemModifiedDate) {
		this.itemModifiedDate = itemModifiedDate;
	}

	public int getItemModifiedId() {
		return this.itemModifiedId;
	}

	public void setItemModifiedId(int itemModifiedId) {
		this.itemModifiedId = itemModifiedId;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemNonstock() {
		return this.itemNonstock;
	}

	public void setItemNonstock(String itemNonstock) {
		this.itemNonstock = itemNonstock;
	}

	public String getItemNotes() {
		return this.itemNotes;
	}

	public void setItemNotes(String itemNotes) {
		this.itemNotes = itemNotes;
	}

	public String getItemPerishable() {
		return this.itemPerishable;
	}

	public void setItemPerishable(String itemPerishable) {
		this.itemPerishable = itemPerishable;
	}

	public byte[] getItemPic() {
		return this.itemPic;
	}

	public void setItemPic(byte[] itemPic) {
		this.itemPic = itemPic;
	}

	public int getItemPurchaseLedgerId() {
		return this.itemPurchaseLedgerId;
	}

	public void setItemPurchaseLedgerId(int itemPurchaseLedgerId) {
		this.itemPurchaseLedgerId = itemPurchaseLedgerId;
	}

	public int getItemPurchasediscountLedgerId() {
		return this.itemPurchasediscountLedgerId;
	}

	public void setItemPurchasediscountLedgerId(int itemPurchasediscountLedgerId) {
		this.itemPurchasediscountLedgerId = itemPurchasediscountLedgerId;
	}

	public int getItemPurchasetax1LedgerId() {
		return this.itemPurchasetax1LedgerId;
	}

	public void setItemPurchasetax1LedgerId(int itemPurchasetax1LedgerId) {
		this.itemPurchasetax1LedgerId = itemPurchasetax1LedgerId;
	}

	public int getItemPurchasetax2Aftertax1() {
		return this.itemPurchasetax2Aftertax1;
	}

	public void setItemPurchasetax2Aftertax1(int itemPurchasetax2Aftertax1) {
		this.itemPurchasetax2Aftertax1 = itemPurchasetax2Aftertax1;
	}

	public int getItemPurchasetax2LedgerId() {
		return this.itemPurchasetax2LedgerId;
	}

	public void setItemPurchasetax2LedgerId(int itemPurchasetax2LedgerId) {
		this.itemPurchasetax2LedgerId = itemPurchasetax2LedgerId;
	}

	public int getItemPurchasetax3Aftertax2() {
		return this.itemPurchasetax3Aftertax2;
	}

	public void setItemPurchasetax3Aftertax2(int itemPurchasetax3Aftertax2) {
		this.itemPurchasetax3Aftertax2 = itemPurchasetax3Aftertax2;
	}

	public int getItemPurchasetax3LedgerId() {
		return this.itemPurchasetax3LedgerId;
	}

	public void setItemPurchasetax3LedgerId(int itemPurchasetax3LedgerId) {
		this.itemPurchasetax3LedgerId = itemPurchasetax3LedgerId;
	}

	public String getItemReorderAuto() {
		return this.itemReorderAuto;
	}

	public void setItemReorderAuto(String itemReorderAuto) {
		this.itemReorderAuto = itemReorderAuto;
	}

	public int getItemReorderLeaddays() {
		return this.itemReorderLeaddays;
	}

	public void setItemReorderLeaddays(int itemReorderLeaddays) {
		this.itemReorderLeaddays = itemReorderLeaddays;
	}

	public int getItemSalesLedgerId() {
		return this.itemSalesLedgerId;
	}

	public void setItemSalesLedgerId(int itemSalesLedgerId) {
		this.itemSalesLedgerId = itemSalesLedgerId;
	}

	public int getItemSalesdiscountLedgerId() {
		return this.itemSalesdiscountLedgerId;
	}

	public void setItemSalesdiscountLedgerId(int itemSalesdiscountLedgerId) {
		this.itemSalesdiscountLedgerId = itemSalesdiscountLedgerId;
	}

	public int getItemSalestax1LedgerId() {
		return this.itemSalestax1LedgerId;
	}

	public void setItemSalestax1LedgerId(int itemSalestax1LedgerId) {
		this.itemSalestax1LedgerId = itemSalestax1LedgerId;
	}

	public int getItemSalestax2Aftertax1() {
		return this.itemSalestax2Aftertax1;
	}

	public void setItemSalestax2Aftertax1(int itemSalestax2Aftertax1) {
		this.itemSalestax2Aftertax1 = itemSalestax2Aftertax1;
	}

	public int getItemSalestax2LedgerId() {
		return this.itemSalestax2LedgerId;
	}

	public void setItemSalestax2LedgerId(int itemSalestax2LedgerId) {
		this.itemSalestax2LedgerId = itemSalestax2LedgerId;
	}

	public int getItemSalestax3Aftertax2() {
		return this.itemSalestax3Aftertax2;
	}

	public void setItemSalestax3Aftertax2(int itemSalestax3Aftertax2) {
		this.itemSalestax3Aftertax2 = itemSalestax3Aftertax2;
	}

	public int getItemSalestax3LedgerId() {
		return this.itemSalestax3LedgerId;
	}

	public void setItemSalestax3LedgerId(int itemSalestax3LedgerId) {
		this.itemSalestax3LedgerId = itemSalestax3LedgerId;
	}

	public String getItemSerial() {
		return this.itemSerial;
	}

	public void setItemSerial(String itemSerial) {
		this.itemSerial = itemSerial;
	}

	public String getItemSmallDesc() {
		return this.itemSmallDesc;
	}

	public void setItemSmallDesc(String itemSmallDesc) {
		this.itemSmallDesc = itemSmallDesc;
	}

	public String getItemStock() {
		return this.itemStock;
	}

	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}

	public int getItemTicketqueueId() {
		return this.itemTicketqueueId;
	}

	public void setItemTicketqueueId(int itemTicketqueueId) {
		this.itemTicketqueueId = itemTicketqueueId;
	}

	public int getItemUomId() {
		return this.itemUomId;
	}

	public void setItemUomId(int itemUomId) {
		this.itemUomId = itemUomId;
	}

	public AxelaInventoryCatPop getAxelaInventoryCatPop() {
		return axelaInventoryCatPop;
	}

	public void setAxelaInventoryCatPop(AxelaInventoryCatPop axelaInventoryCatPop) {
		this.axelaInventoryCatPop = axelaInventoryCatPop;
	}

	// public AxelaInventorySalescatTran getAxelaInventorySalescatTran() {
	// return axelaInventorySalescatTran;
	// }
	//
	// public void setAxelaInventorySalescatTran(AxelaInventorySalescatTran axelaInventorySalescatTran) {
	// this.axelaInventorySalescatTran = axelaInventorySalescatTran;
	// }

	public AxelaInventoryItemType getAxelaInventoryItemType() {
		return axelaInventoryItemType;
	}

	public void setAxelaInventoryItemType(AxelaInventoryItemType axelaInventoryItemType) {
		this.axelaInventoryItemType = axelaInventoryItemType;
	}

	public AxelaInventoryUom getAxelaInventoryUom() {
		return axelaInventoryUom;
	}

	public void setAxelaInventoryUom(AxelaInventoryUom axelaInventoryUom) {
		this.axelaInventoryUom = axelaInventoryUom;
	}

	public AxelaInventoryItemModel getAxelaInventoryItemModel() {
		return axelaInventoryItemModel;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public AxelaInventoryCat getAxelaInventoryCat() {
		return axelaInventoryCat;
	}

	public void setAxelaInventoryCat(AxelaInventoryCat axelaInventoryCat) {
		this.axelaInventoryCat = axelaInventoryCat;
	}

	public void setAxelaInventoryItemModel(AxelaInventoryItemModel axelaInventoryItemModel) {
		this.axelaInventoryItemModel = axelaInventoryItemModel;
	}

	public int getLocationBranchId() {
		return locationBranchId;
	}

	public void setLocationBranchId(int locationBranchId) {
		this.locationBranchId = locationBranchId;
	}

	public int getStockLocationId() {
		return stockLocationId;
	}

	public void setStockLocationId(int stockLocationId) {
		this.stockLocationId = stockLocationId;
	}

	public int getStockItemId() {
		return stockItemId;
	}

	public void setStockItemId(int stockItemId) {
		this.stockItemId = stockItemId;
	}

	public double getStockCurrentQty() {
		return stockCurrentQty;
	}

	public void setStockCurrentQty(double stockCurrentQty) {
		this.stockCurrentQty = stockCurrentQty;
	}

	public int getStockReorderlevel() {
		return stockReorderlevel;
	}

	public void setStockReorderlevel(int stockReorderlevel) {
		this.stockReorderlevel = stockReorderlevel;
	}

	public int getRateclassId() {
		return rateclassId;
	}

	public void setRateclassId(int rateclassId) {
		this.rateclassId = rateclassId;
	}

	public String getRateclassName() {
		return rateclassName;
	}

	public void setRateclassName(String rateclassName) {
		this.rateclassName = rateclassName;
	}

	public double getPriceAmt() {
		return priceAmt;
	}

	public void setPriceAmt(double priceAmt) {
		this.priceAmt = priceAmt;
	}

	public int getPriceItemId() {
		return priceItemId;
	}

	public void setPriceItemId(int priceItemId) {
		this.priceItemId = priceItemId;
	}

	public String getPriceVariable() {
		return priceVariable;
	}

	public void setPriceVariable(String priceVariable) {
		this.priceVariable = priceVariable;
	}

	public double getPriceDisc() {
		return priceDisc;
	}

	public void setPriceDisc(double priceDisc) {
		this.priceDisc = priceDisc;
	}

	public int getPriceDiscType() {
		return priceDiscType;
	}

	public void setPriceDiscType(int priceDiscType) {
		this.priceDiscType = priceDiscType;
	}

	public String getUomShortname() {
		return uomShortname;
	}

	public void setUomShortname(String uomShortname) {
		this.uomShortname = uomShortname;
	}

	public Date getPriceEffectiveFrom() {
		return priceEffectiveFrom;
	}

	public void setPriceEffectiveFrom(Date priceEffectiveFrom) {
		this.priceEffectiveFrom = priceEffectiveFrom;
	}

	public String getPriceDesc() {
		return priceDesc;
	}

	public void setPriceDesc(String priceDesc) {
		this.priceDesc = priceDesc;
	}

	public int getPriceRateclassId() {
		return priceRateclassId;
	}

	public void setPriceRateclassId(int priceRateclassId) {
		this.priceRateclassId = priceRateclassId;
	}

	public List<AxelaInventorySalescatTran> getAxelaInventorySalescatTran() {
		return axelaInventorySalescatTran;
	}

	public void setAxelaInventorySalescatTran(List<AxelaInventorySalescatTran> axelaInventorySalescatTran) {
		this.axelaInventorySalescatTran = axelaInventorySalescatTran;
	}
	public double getTaxRate1() {
		return taxRate1;
	}

	public void setTaxRate1(double taxRate1) {
		this.taxRate1 = taxRate1;
	}

	public double getTaxRate2() {
		return taxRate2;
	}

	public void setTaxRate2(double taxRate2) {
		this.taxRate2 = taxRate2;
	}

	public double getTaxRate3() {
		return taxRate3;
	}

	public void setTaxRate3(double taxRate3) {
		this.taxRate3 = taxRate3;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public int getStockStockinorder() {
		return stockStockinorder;
	}

	public void setStockStockinorder(int stockStockinorder) {
		this.stockStockinorder = stockStockinorder;
	}

	public int getStockStockindemand() {
		return stockStockindemand;
	}

	public void setStockStockindemand(int stockStockindemand) {
		this.stockStockindemand = stockStockindemand;
	}

	public double getStockUnitCost() {
		return stockUnitCost;
	}

	public void setStockUnitCost(double stockUnitCost) {
		this.stockUnitCost = stockUnitCost;
	}

	public double getStockOnhandvalue() {
		return stockOnhandvalue;
	}

	public void setStockOnhandvalue(double stockOnhandvalue) {
		this.stockOnhandvalue = stockOnhandvalue;
	}

	public List<AxelaInventoryStock> getAxelaInventoryStock() {
		return axelaInventoryStock;
	}

	public void setAxelaInventoryStock(List<AxelaInventoryStock> axelaInventoryStock) {
		this.axelaInventoryStock = axelaInventoryStock;
	}

}