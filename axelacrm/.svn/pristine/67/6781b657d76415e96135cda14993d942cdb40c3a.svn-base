package axela.portal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_customer_group database table.
 * 
 */
@Entity
@Table(name = "axela_customer_group", catalog = "axela_1")
@NamedQuery(name = "AxelaCustomerGroup.findAll", query = "SELECT a FROM AxelaCustomerGroup a")
public class AxelaCustomerGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "group_id")
	private int groupId;

	@Column(name = "group_desc")
	private String groupDesc;

	@Column(name = "group_entry_date")
	private Date groupEntryDate;

	@Column(name = "group_entry_id")
	private int groupEntryId;

	@Column(name = "group_modified_date")
	private Date groupModifiedDate;

	@Column(name = "group_modified_id")
	private int groupModifiedId;

	public AxelaCustomerGroup() {
	}

	public AxelaCustomerGroup(
			int groupId,
			String groupDesc,
			int groupEntryId,
			Date groupEntryDate,
			int groupModifiedId,
			Date groupModifiedDate) {
		this.groupId = groupId;
		this.groupDesc = groupDesc;
		this.groupEntryId = groupEntryId;
		this.groupEntryDate = groupEntryDate;
		this.groupModifiedId = groupModifiedId;
		this.groupModifiedDate = groupModifiedDate;
	}

	public int getGroupId() {
		return this.groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupDesc() {
		return this.groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	public Date getGroupEntryDate() {
		return this.groupEntryDate;
	}

	public void setGroupEntryDate(Date groupEntryDate) {
		this.groupEntryDate = groupEntryDate;
	}

	public int getGroupEntryId() {
		return this.groupEntryId;
	}

	public void setGroupEntryId(int groupEntryId) {
		this.groupEntryId = groupEntryId;
	}

	public Date getGroupModifiedDate() {
		return this.groupModifiedDate;
	}

	public void setGroupModifiedDate(Date groupModifiedDate) {
		this.groupModifiedDate = groupModifiedDate;
	}

	public int getGroupModifiedId() {
		return this.groupModifiedId;
	}

	public void setGroupModifiedId(int groupModifiedId) {
		this.groupModifiedId = groupModifiedId;
	}

}