package axela.inventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the axela_inventory_bin_pop database table.
 * 
 */
@Entity
@Table(name = "axela_inventory_bin_pop", catalog = "axela_1")
@NamedQuery(name = "AxelaInventoryBinPop.findAll", query = "SELECT a FROM AxelaInventoryBinPop a")
public class AxelaInventoryBinPop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bin_id")
	private int binId;

	@Column(name = "bin_active")
	private String binActive;

	@Column(name = "bin_location_id")
	private int binLocationId;

	@Column(name = "bin_name")
	private String binName;

	@Column(name = "bin_rank")
	private int binRank;

	@ManyToOne(fetch = FetchType.LAZY)
	// location_id = bin_location_id" relation based on
	@JoinColumn(name = "bin_location_id", referencedColumnName = "location_id", insertable = false, updatable = false)
	private AxelaInventoryLocation axelaInventoryLocation;
	@OneToOne
	// bin_id = bin_parent_id" relation based on
	@JoinColumn(name = "bin_id", referencedColumnName = "bin_parent_id", insertable = false, updatable = false)
	private AxelaInventoryBin axelaInventoryBin;

	public AxelaInventoryBinPop() {
	}

	public AxelaInventoryBinPop(int binId, String binName) {
		this.binId = binId;
		this.binName = binName;
	}
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

	public int getBinLocationId() {
		return this.binLocationId;
	}

	public void setBinLocationId(int binLocationId) {
		this.binLocationId = binLocationId;
	}

	public String getBinName() {
		return this.binName;
	}

	public void setBinName(String binName) {
		this.binName = binName;
	}

	public int getBinRank() {
		return this.binRank;
	}

	public void setBinRank(int binRank) {
		this.binRank = binRank;
	}

}