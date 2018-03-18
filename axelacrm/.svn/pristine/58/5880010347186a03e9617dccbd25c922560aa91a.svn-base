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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the axela_inventory_item_option database table.
 * 
 */
@Entity
@Table(name = "axela_inventory_item_option", catalog = "axela_1")
@NamedQuery(name = "AxelaInventoryItemOption.findAll", query = "SELECT a FROM AxelaInventoryItemOption a")
public class AxelaInventoryItemOption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Transient
	private int itemId;

	@Transient
	private String itemName;

	@Transient
	private String itemCode;

	@Transient
	private int groupType;

	@Transient
	private String groupName;

	@Column(name = "option_group_id")
	private int optionGroupId;
	@Id
	@Column(name = "option_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int optionId;

	@Column(name = "option_item_id")
	private int optionItemId;

	@Column(name = "option_itemmaster_id")
	private int optionItemmasterId;

	@Column(name = "option_qty")
	private int optionQty;

	@Column(name = "option_select")
	private String optionSelect;

	@Column(name = "option_validfrom")
	private Date optionValidfrom;

	@Column(name = "option_validtill")
	private Date optionValidtill;

	@ManyToOne(fetch = FetchType.LAZY)
	// on group_id = option_group_id"
	@JoinColumn(name = "option_group_id", referencedColumnName = "group_id", insertable = false, updatable = false)
	private AxelaInventoryGroup axelaInventoryGroup;

	@OneToOne(fetch = FetchType.LAZY)
	// on item_id = option_item_id"
	@JoinColumn(name = "option_item_id", referencedColumnName = "item_id", insertable = false, updatable = false)
	private AxelaInventoryItem axelaInventoryItem;

	public AxelaInventoryItemOption() {
	}

	public AxelaInventoryItemOption(
			int itemId,
			String itemName,
			String itemCode,
			int groupType,
			String groupName,
			int optionId,
			int optionQty,
			String optionSelect,
			Date optionValidfrom,
			Date optionValidtill) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemCode = itemCode;
		this.groupType = groupType;
		this.groupName = groupName;
		this.optionId = optionId;
		this.optionQty = optionQty;
		this.optionSelect = optionSelect;
		this.optionValidfrom = optionValidfrom;
		this.optionValidtill = optionValidtill;
	}

	public int getOptionGroupId() {
		return this.optionGroupId;
	}

	public void setOptionGroupId(int optionGroupId) {
		this.optionGroupId = optionGroupId;
	}

	public int getOptionId() {
		return this.optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public int getOptionItemId() {
		return this.optionItemId;
	}

	public void setOptionItemId(int optionItemId) {
		this.optionItemId = optionItemId;
	}

	public int getOptionItemmasterId() {
		return this.optionItemmasterId;
	}

	public void setOptionItemmasterId(int optionItemmasterId) {
		this.optionItemmasterId = optionItemmasterId;
	}

	public int getOptionQty() {
		return this.optionQty;
	}

	public void setOptionQty(int optionQty) {
		this.optionQty = optionQty;
	}

	public String getOptionSelect() {
		return this.optionSelect;
	}

	public void setOptionSelect(String optionSelect) {
		this.optionSelect = optionSelect;
	}

	public Date getOptionValidfrom() {
		return this.optionValidfrom;
	}

	public void setOptionValidfrom(Date optionValidfrom) {
		this.optionValidfrom = optionValidfrom;
	}

	public Date getOptionValidtill() {
		return this.optionValidtill;
	}

	public void setOptionValidtill(Date optionValidtill) {
		this.optionValidtill = optionValidtill;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public int getGroupType() {
		return groupType;
	}

	public void setGroupType(int groupType) {
		this.groupType = groupType;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}