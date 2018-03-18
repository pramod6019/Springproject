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

/**
 * The persistent class for the axela_inventory_bin database table.
 * 
 */
@Entity
@Table(name = "axela_inventory_bin", catalog = "axela_1")
@NamedQuery(name = "AxelaInventoryBin.findAll", query = "SELECT a FROM AxelaInventoryBin a")
public class AxelaInventoryBin implements Serializable {
	private static final long serialVersionUID = 1L;

	// ================join variable============

	@Transient
	private long itemcount = 0;
	@Transient
	private int locationId = 0;
	@Transient
	private String locationName = "";

	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	@Transient
	private int branchId = 0;

	@Transient
	private String branchName = "";

	@Transient
	private String locationCode = "";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bin_id")
	private int binId;

	@Column(name = "bin_active")
	private String binActive;

	@Column(name = "bin_entry_date")
	private Date binEntryDate;

	@Column(name = "bin_entry_id")
	private int binEntryId;

	@Column(name = "bin_location_id")
	private int binLocationId;

	@Column(name = "bin_modified_date")
	private Date binModifiedDate;

	@Column(name = "bin_modified_id")
	private int binModifiedId;

	@Column(name = "bin_name")
	private String binName;

	@Column(name = "bin_parent_id")
	private int binParentId;

	public long getItemcount() {
		return itemcount;
	}
	public void setItemcount(long itemcount) {
		this.itemcount = itemcount;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public AxelaInventoryLocation getAxelaInventoryLocation() {
		return axelaInventoryLocation;
	}
	public void setAxelaInventoryLocation(AxelaInventoryLocation axelaInventoryLocation) {
		this.axelaInventoryLocation = axelaInventoryLocation;
	}
	public AxelaInventoryBin() {
	}
	public AxelaInventoryBin(String binName) {
		this.binName = binName;
	}

	public AxelaInventoryBin(int binId, String binName, int binLocationId, int binParentId, String binActive) {
		this.binId = binId;
		this.binName = binName;
		this.binLocationId = binLocationId;
		this.binParentId = binParentId;
		this.binActive = binActive;
	}

	public AxelaInventoryBin(int binId, String binName, int binParentId) {
		this.binId = binId;
		this.binName = binName;
		this.binParentId = binParentId;
	}

	public AxelaInventoryBin(String binName, int binParentId, int binEntryId,
			Date binEntryDate, int binModifiedId, String branchName,
			int binLocationId, Date binModifiedDate, int branchId, String locationCode, String locationName) {
		this.binName = binName;
		this.binParentId = binParentId;
		this.binEntryId = binEntryId;
		this.binEntryDate = binEntryDate;
		this.binModifiedId = binModifiedId;
		this.branchName = branchName;
		this.binLocationId = binLocationId;
		this.binModifiedDate = binModifiedDate;
		this.branchId = branchId;
		this.locationCode = locationCode;
		this.locationName = locationName;

	}

	public AxelaInventoryBin(int binId, String binName, long itemCount, int locationId, String locationName,
			int branchId, String branchName) {
		this.binId = binId;
		this.binName = binName;
		this.itemcount = itemCount;
		this.locationId = locationId;
		this.locationName = locationName;
		this.branchId = branchId;
		this.branchName = branchName;
	}

	// =============Mapping=============
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bin_location_id", referencedColumnName = "location_id", insertable = false, updatable = false)
	private AxelaInventoryLocation axelaInventoryLocation;

	// =======================================

	public int getBinId() {
		return this.binId;
	}

	public void setBinId(int binId) {
		this.binId = binId;
	}

	public String getBinActive() {
		return this.binActive;
	}

	public void setBinActive(String binActive) {
		this.binActive = binActive;
	}

	public Date getBinEntryDate() {
		return this.binEntryDate;
	}

	public void setBinEntryDate(Date binEntryDate) {
		this.binEntryDate = binEntryDate;
	}

	public int getBinEntryId() {
		return this.binEntryId;
	}

	public void setBinEntryId(int binEntryId) {
		this.binEntryId = binEntryId;
	}

	public int getBinLocationId() {
		return this.binLocationId;
	}

	public void setBinLocationId(int binLocationId) {
		this.binLocationId = binLocationId;
	}

	public Date getBinModifiedDate() {
		return this.binModifiedDate;
	}

	public void setBinModifiedDate(Date binModifiedDate) {
		this.binModifiedDate = binModifiedDate;
	}

	public int getBinModifiedId() {
		return this.binModifiedId;
	}

	public void setBinModifiedId(int binModifiedId) {
		this.binModifiedId = binModifiedId;
	}

	public String getBinName() {
		return this.binName;
	}

	public void setBinName(String binName) {
		this.binName = binName;
	}

	public int getBinParentId() {
		return this.binParentId;
	}

	public void setBinParentId(int binParentId) {
		this.binParentId = binParentId;
	}

}