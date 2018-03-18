package axela.inventory.model;

import java.io.Serializable;

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

/**
 * The persistent class for the axela_inventory_bin_items database table.
 * 
 */
@Entity
@Table(name = "axela_inventory_bin_items", catalog = "axela_1")
@NamedQuery(name = "AxelaInventoryBinItem.findAll", query = "SELECT a FROM AxelaInventoryBinItem a")
public class AxelaInventoryBinItem implements Serializable {

	private static final long serialVersionUID = 1L;
	// ======================join variable=============
	@Transient
	private String binName;
	@Transient
	private int itemId;
	@Transient
	private int modelId;
	@Transient
	private String modelName;
	@Transient
	private String itemName;
	@Transient
	private String itemCode;
	@Transient
	private int binId;
	@Transient
	private int branchId;
	@Transient
	private String branchCode;
	@Transient
	private String branchName;
	@Transient
	private int locationId;
	@Transient
	private String locationCode;
	@Transient
	private String locationName;

	@Id
	@Column(name = "binitem_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int binitemId;

	@Column(name = "binitem_bin_id")
	private int binitemBinId;

	@Column(name = "binitem_item_id")
	private int binitemItemId;

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public AxelaInventoryBinItem() {
	}

	public AxelaInventoryBinItem(
			int binitemId,
			int binitemBinId,
			String binName,
			int binId,
			int binitemItemId,
			int itemId,
			int modelId,
			String modelName,
			String itemName,
			String itemCode) {
		this.binitemId = binitemId;
		this.binitemBinId = binitemBinId;
		this.binName = binName;
		this.binId = binId;
		this.binitemItemId = binitemItemId;
		this.itemId = itemId;
		this.modelId = modelId;
		this.modelName = modelName;
		this.itemName = itemName;
		this.itemCode = itemCode;
	}

	// =========================mapping====================

	public AxelaInventoryBinItem(
			String binName,
			int itemId,
			int modelId,
			String itemName,
			String itemCode,
			int branchId,
			String branchCode,
			String branchName,
			int locationId,
			String locationCode,
			String locationName,
			int binitemId,
			int binitemBinId,
			int binitemItemId) {
		super();
		this.binName = binName;
		this.itemId = itemId;
		this.modelId = modelId;
		this.itemName = itemName;
		this.itemCode = itemCode;
		this.branchId = branchId;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.locationId = locationId;
		this.locationCode = locationCode;
		this.locationName = locationName;
		this.binitemId = binitemId;
		this.binitemBinId = binitemBinId;
		this.binitemItemId = binitemItemId;
	}

	public AxelaInventoryBinItem(
			String binName,
			String branchCode,
			String branchName,
			String locationCode,
			String locationName) {
		super();
		this.binName = binName;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.locationCode = locationCode;
		this.locationName = locationName;
	}

	// One to One association to AxelaInventoryItemType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "binitem_item_id", referencedColumnName = "item_id", insertable = false, updatable = false)
	private AxelaInventoryItem axelaInventoryItem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "binitem_bin_id", referencedColumnName = "bin_id", insertable = false, updatable = false)
	private AxelaInventoryBinPop axelaInventoryBinPop;

	// =============================

	public int getBinitemBinId() {
		return this.binitemBinId;
	}

	public void setBinitemBinId(int binitemBinId) {
		this.binitemBinId = binitemBinId;
	}

	public String getBinName() {
		return binName;
	}

	public void setBinName(String binName) {
		this.binName = binName;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getModelId() {
		return modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getBinitemId() {
		return binitemId;
	}

	public void setBinitemId(int binitemId) {
		this.binitemId = binitemId;
	}

	public AxelaInventoryItem getAxelaInventoryItem() {
		return axelaInventoryItem;
	}

	public void setAxelaInventoryItem(AxelaInventoryItem axelaInventoryItem) {
		this.axelaInventoryItem = axelaInventoryItem;
	}

	public AxelaInventoryBinPop getAxelaInventoryBinPop() {
		return axelaInventoryBinPop;
	}

	public void setAxelaInventoryBinPop(AxelaInventoryBinPop axelaInventoryBinPop) {
		this.axelaInventoryBinPop = axelaInventoryBinPop;
	}

	public int getBinitemItemId() {
		return this.binitemItemId;
	}

	public void setBinitemItemId(int binitemItemId) {
		this.binitemItemId = binitemItemId;
	}

	public int getBinId() {
		return binId;
	}

	public void setBinId(int binId) {
		this.binId = binId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

}