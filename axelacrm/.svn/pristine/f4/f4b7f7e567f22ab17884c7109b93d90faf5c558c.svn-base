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
 * The persistent class for the axela_inventory_salescat database table.
 * 
 */

@Entity
@Table(name = "axela_inventory_salescat", catalog = "axela_1")
@NamedQuery(name = "AxelaInventorySalescat.findAll", query = "SELECT a FROM AxelaInventorySalescat a")
public class AxelaInventorySalescat implements Serializable {
	private static final long serialVersionUID = 1L;

	// =========================================LEFT JOIN variables=================================
	@Transient
	private long itemCount = 0; // from axelaInventoryItemModel

	// ========================================================

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "salescat_id")
	private int salescatId;

	@Column(name = "salescat_entry_date")
	private Date salescatEntryDate;

	@Column(name = "salescat_entry_id")
	private int salescatEntryId;

	@Column(name = "salescat_modified_date")
	private Date salescatModifiedDate;

	@Column(name = "salescat_modified_id")
	private int salescatModifiedId;

	@Column(name = "salescat_name")
	private String salescatName;

	// ================================

	public long getItemCount() {
		return itemCount;
	}

	public void setItemCount(long itemCount) {
		this.itemCount = itemCount;
	}

	public AxelaInventorySalescat() {
	}

	public AxelaInventorySalescat(int salescatId, String salescatName, long itemCount) {
		super();
		this.salescatId = salescatId;
		this.salescatName = salescatName;
		this.itemCount = itemCount;
	}

	// =========================================Entity Relationships====================================

	@OneToMany(mappedBy = "axelaInventorySalescat")
	private List<AxelaInventorySalescatTran> axelaInventorySalescatTran;

	// =========================================Entity setters and getters====================================
	public int getSalescatId() {
		return this.salescatId;
	}

	public void setSalescatId(int salescatId) {
		this.salescatId = salescatId;
	}

	public Date getSalescatEntryDate() {
		return this.salescatEntryDate;
	}

	public void setSalescatEntryDate(Date salescatEntryDate) {
		this.salescatEntryDate = salescatEntryDate;
	}

	public int getSalescatEntryId() {
		return this.salescatEntryId;
	}

	public void setSalescatEntryId(int salescatEntryId) {
		this.salescatEntryId = salescatEntryId;
	}

	public Date getSalescatModifiedDate() {
		return this.salescatModifiedDate;
	}

	public void setSalescatModifiedDate(Date salescatModifiedDate) {
		this.salescatModifiedDate = salescatModifiedDate;
	}

	public int getSalescatModifiedId() {
		return this.salescatModifiedId;
	}

	public void setSalescatModifiedId(int salescatModifiedId) {
		this.salescatModifiedId = salescatModifiedId;
	}

	public String getSalescatName() {
		return this.salescatName;
	}

	public void setSalescatName(String salescatName) {
		this.salescatName = salescatName;
	}

}