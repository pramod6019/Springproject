package axela.inventory.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the axela_inventory_cat database table.
 * 
 */
@Entity
@Table(name = "axela_inventory_cat", catalog = "axela_1")
@NamedQuery(name = "AxelaInventoryCat.findAll", query = "SELECT a.catId,a.catName FROM AxelaInventoryCat a")
public class AxelaInventoryCat implements Serializable {
	private static final long serialVersionUID = 1L;

	// =========================================LEFT JOIN variables=================================

	@Transient
	private long itemCount; // from axelaInventoryItemModel

	//

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cat_id")
	private int catId;

	@Column(name = "cat_active")
	private String catActive;

	@Column(name = "cat_entry_date")
	private Date catEntryDate;

	@Column(name = "cat_entry_id")
	private int catEntryId;

	@Column(name = "cat_modified_date")
	private Date catModifiedDate;

	@Column(name = "cat_modified_id")
	private int catModifiedId;

	@Column(name = "cat_name")
	private String catName;

	@Column(name = "cat_parent_id")
	private int catParentId;

	//
	// @OneToMany
	// @NotFound(action = NotFoundAction.IGNORE)
	// @JoinColumn(name = "cat_id", referencedColumnName = "item_cat_id", insertable = false, updatable = false)
	// private List<AxelaInventoryItem> axelaInventoryItem;

	public AxelaInventoryCat() {
	}

	public AxelaInventoryCat(int catId) {
		this.catId = catId;
	}

	public AxelaInventoryCat(String catName) {
		this.catName = catName;
	}

	public AxelaInventoryCat(
			int catId,
			String catName,
			long itemCount) {
		this.catId = catId;
		this.catName = catName;
		this.itemCount = itemCount;
	}

	// =========================================Entity Relationships====================================

	@OneToMany(mappedBy = "axelaInventoryCat")
	private List<AxelaInventoryItem> axelaInventoryItem;

	// =========================================Entity setters and getters====================================

	public int getCatId() {
		return this.catId;
	}

	public long getItemCount() {
		return itemCount;
	}

	public void setItemCount(long itemCount) {
		this.itemCount = itemCount;
	}

	public List<AxelaInventoryItem> getAxelaInventoryItem() {
		return axelaInventoryItem;
	}

	public void setAxelaInventoryItem(List<AxelaInventoryItem> axelaInventoryItem) {
		this.axelaInventoryItem = axelaInventoryItem;
	}

	public AxelaInventoryCat(
			int catId,
			String catActive,
			String catName,
			int catParentId) {
		super();
		this.catId = catId;
		this.catActive = catActive;
		this.catName = catName;
		this.catParentId = catParentId;
	}

	public AxelaInventoryCat(
			int catId,
			String catName,
			int catParentId) {
		super();
		this.catId = catId;
		this.catName = catName;
		this.catParentId = catParentId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatActive() {
		return this.catActive;
	}

	public void setCatActive(String catActive) {
		this.catActive = catActive;
	}

	public Date getCatEntryDate() {
		return this.catEntryDate;
	}

	public void setCatEntryDate(Date catEntryDate) {
		this.catEntryDate = catEntryDate;
	}

	public int getCatEntryId() {
		return this.catEntryId;
	}

	public void setCatEntryId(int catEntryId) {
		this.catEntryId = catEntryId;
	}

	public Date getCatModifiedDate() {
		return this.catModifiedDate;
	}

	public void setCatModifiedDate(Date catModifiedDate) {
		this.catModifiedDate = catModifiedDate;
	}

	public int getCatModifiedId() {
		return this.catModifiedId;
	}

	public void setCatModifiedId(int catModifiedId) {
		this.catModifiedId = catModifiedId;
	}

	public String getCatName() {
		return this.catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public int getCatParentId() {
		return this.catParentId;
	}

	public void setCatParentId(int catParentId) {
		this.catParentId = catParentId;
	}

}