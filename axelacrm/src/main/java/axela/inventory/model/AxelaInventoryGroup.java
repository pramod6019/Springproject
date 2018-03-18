package axela.inventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_inventory_group database table.
 * 
 */
@Entity
@Table(name = "axela_inventory_group", catalog = "axela_1")
@NamedQuery(name = "AxelaInventoryGroup.findAll", query = "SELECT a FROM AxelaInventoryGroup a")
public class AxelaInventoryGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "group_id")
	private int groupId;

	@Column(name = "group_active")
	private String groupActive;

	@Column(name = "group_desc")
	private String groupDesc;

	@Column(name = "group_entry_date")
	private String groupEntryDate;

	@Column(name = "group_entry_id")
	private int groupEntryId;

	@Column(name = "group_img")
	private String groupImg;

	@Column(name = "group_modified_date")
	private String groupModifiedDate;

	@Column(name = "group_modified_id")
	private int groupModifiedId;

	@Column(name = "group_name")
	private String groupName;

	@Column(name = "group_rank")
	private int groupRank;

	@Column(name = "group_type")
	private int groupType;

	public AxelaInventoryGroup() {
	}

	public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupActive() {
		return this.groupActive;
	}

	public void setGroupActive(String groupActive) {
		this.groupActive = groupActive;
	}

	public String getGroupDesc() {
		return this.groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	public String getGroupEntryDate() {
		return this.groupEntryDate;
	}

	public void setGroupEntryDate(String groupEntryDate) {
		this.groupEntryDate = groupEntryDate;
	}

	public int getGroupEntryId() {
		return this.groupEntryId;
	}

	public void setGroupEntryId(int groupEntryId) {
		this.groupEntryId = groupEntryId;
	}

	public String getGroupImg() {
		return this.groupImg;
	}

	public void setGroupImg(String groupImg) {
		this.groupImg = groupImg;
	}

	public String getGroupModifiedDate() {
		return this.groupModifiedDate;
	}

	public void setGroupModifiedDate(String groupModifiedDate) {
		this.groupModifiedDate = groupModifiedDate;
	}

	public int getGroupModifiedId() {
		return this.groupModifiedId;
	}

	public void setGroupModifiedId(int groupModifiedId) {
		this.groupModifiedId = groupModifiedId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getGroupRank() {
		return this.groupRank;
	}

	public void setGroupRank(int groupRank) {
		this.groupRank = groupRank;
	}

	public int getGroupType() {
		return this.groupType;
	}

	public void setGroupType(int groupType) {
		this.groupType = groupType;
	}

}