package axela.inventory.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the axela_inventory_cat_pop database table.
 * 
 */
@Entity
@Table(name = "axela_inventory_cat_pop", catalog = "axela_1")
@NamedQuery(name = "AxelaInventoryCatPop.findAll", query = "SELECT a FROM AxelaInventoryCatPop a")
public class AxelaInventoryCatPop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cat_id")
	private int catId;

	@Column(name = "cat_active")
	private String catActive;

	@Column(name = "cat_name")
	private String catName;

	@Column(name = "cat_rank")
	private int catRank;

	@OneToMany(mappedBy = "axelaInventoryCatPop")
	private List<AxelaInventoryItem> axelaInventoryItem;

	public AxelaInventoryCatPop() {
	}

	public AxelaInventoryCatPop(int catId, String catName) {
		super();
		this.catId = catId;
		this.catName = catName;
	}

	public List<AxelaInventoryItem> getAxelaInventoryItem() {
		return axelaInventoryItem;
	}

	public void setAxelaInventoryItem(List<AxelaInventoryItem> axelaInventoryItem) {
		this.axelaInventoryItem = axelaInventoryItem;
	}

	public int getCatId() {
		return this.catId;
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

	public String getCatName() {
		return this.catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public int getCatRank() {
		return this.catRank;
	}

	public void setCatRank(int catRank) {
		this.catRank = catRank;
	}

}