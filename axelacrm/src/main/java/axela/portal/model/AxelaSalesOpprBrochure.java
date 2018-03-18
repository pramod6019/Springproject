package axela.portal.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Table;
import javax.persistence.Transient;

import axela.inventory.model.AxelaInventoryItem;

/**
 * The persistent class for the axela_sales_oppr_brochure database table.
 * 
 */
@Entity
@Table(name = "axela_sales_oppr_brochure", catalog = "axela_1")
@NamedQuery(name = "AxelaSalesOpprBrochure.findAll", query = "SELECT a FROM AxelaSalesOpprBrochure a")
public class AxelaSalesOpprBrochure implements Serializable {
	private static final long serialVersionUID = 1L;

	public AxelaSalesOpprBrochure(
			int brochureId,
			long brochureLengthData,
			String brochureTitle,
			int brochureBranchId,
			String brochureValue,
			int brochureItemId,
			int itemModelId,
			String itemName,
			String modelName,
			String modelOrder) {
		super();
		this.brochureId = brochureId;
		this.brochureLengthData = brochureLengthData;
		this.brochureTitle = brochureTitle;
		this.brochureBranchId = brochureBranchId;
		this.brochureValue = brochureValue;
		this.brochureItemId = brochureItemId;
		this.itemModelId = itemModelId;
		this.itemName = itemName;
		this.modelName = modelName;
		this.modelOrder = modelOrder;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	// on item_id= brochure_item_id"
	@JoinColumn(name = "brochure_item_id", referencedColumnName = "item_id", insertable = false, updatable = false)
	private AxelaInventoryItem axelaInventoryItem;

	@Transient
	int itemModelId;
	@Transient
	long brochureLengthData;

	@Transient
	String itemName;

	@Transient
	String modelName;

	@Transient
	String modelOrder;

	@Id
	@Column(name = "brochure_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int brochureId;

	@Column(name = "brochure_branch_id")
	private int brochureBranchId;

	@Lob
	@Column(name = "brochure_data")
	private byte[] brochureData;

	@Column(name = "brochure_entry_date")
	private Date brochureEntryDate;

	@Column(name = "brochure_entry_id")
	private int brochureEntryId;

	@Column(name = "brochure_item_id")
	private int brochureItemId;

	@Column(name = "brochure_modified_date")
	private Date brochureModifiedDate;

	@Column(name = "brochure_modified_id")
	private int brochureModifiedId;

	@Column(name = "brochure_rank")
	private int brochureRank;

	@Column(name = "brochure_title")
	private String brochureTitle;

	@Column(name = "brochure_value")
	private String brochureValue;

	public AxelaSalesOpprBrochure() {
	}

	public int getBrochureId() {
		return this.brochureId;
	}

	public void setBrochureId(int brochureId) {
		this.brochureId = brochureId;
	}

	public int getBrochureBranchId() {
		return this.brochureBranchId;
	}

	public void setBrochureBranchId(int brochureBranchId) {
		this.brochureBranchId = brochureBranchId;
	}

	public byte[] getBrochureData() {
		return this.brochureData;
	}

	public void setBrochureData(byte[] brochureData) {
		this.brochureData = brochureData;
	}

	public Date getBrochureEntryDate() {
		return this.brochureEntryDate;
	}

	public void setBrochureEntryDate(Date brochureEntryDate) {
		this.brochureEntryDate = brochureEntryDate;
	}

	public int getBrochureEntryId() {
		return this.brochureEntryId;
	}

	public void setBrochureEntryId(int brochureEntryId) {
		this.brochureEntryId = brochureEntryId;
	}

	public int getBrochureItemId() {
		return this.brochureItemId;
	}

	public void setBrochureItemId(int brochureItemId) {
		this.brochureItemId = brochureItemId;
	}

	public Date getBrochureModifiedDate() {
		return this.brochureModifiedDate;
	}

	public void setBrochureModifiedDate(Date brochureModifiedDate) {
		this.brochureModifiedDate = brochureModifiedDate;
	}

	public int getBrochureModifiedId() {
		return this.brochureModifiedId;
	}

	public void setBrochureModifiedId(int brochureModifiedId) {
		this.brochureModifiedId = brochureModifiedId;
	}

	public int getBrochureRank() {
		return this.brochureRank;
	}

	public void setBrochureRank(int brochureRank) {
		this.brochureRank = brochureRank;
	}

	public String getBrochureTitle() {
		return this.brochureTitle;
	}

	public void setBrochureTitle(String brochureTitle) {
		this.brochureTitle = brochureTitle;
	}

	public String getBrochureValue() {
		return this.brochureValue;
	}

	public void setBrochureValue(String brochureValue) {
		this.brochureValue = brochureValue;
	}

	public int getItemModelId() {
		return itemModelId;
	}

	public void setItemModelId(int itemModelId) {
		this.itemModelId = itemModelId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelOrder() {
		return modelOrder;
	}

	public void setModelOrder(String modelOrder) {
		this.modelOrder = modelOrder;
	}

	public long getBrochureLengthData() {
		return brochureLengthData;
	}

	public void setBrochureLengthData(long brochureLengthData) {
		this.brochureLengthData = brochureLengthData;
	}

}