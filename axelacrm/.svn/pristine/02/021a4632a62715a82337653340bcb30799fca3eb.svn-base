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

import org.hibernate.annotations.Where;

/**
 * The persistent class for the axela_inventory_item_type database table.
 * 
 */
@Entity
@Table(name = "axela_inventory_item_type", catalog = "axela_1")
@Where(clause = "itemtype_id!=0")
@NamedQuery(name = "AxelaInventoryItemType.findAll", query = "SELECT a FROM AxelaInventoryItemType a")
public class AxelaInventoryItemType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "itemtype_id")
	private int itemtypeId;

	@Column(name = "itemtype_name")
	private String itemtypeName;

	@OneToMany(mappedBy = "axelaInventoryItemType")
	private List<AxelaInventoryItem> axelaInventoryItem;

	public List<AxelaInventoryItem> getAxelaInventoryItem() {
		return axelaInventoryItem;
	}

	public void setAxelaInventoryItem(List<AxelaInventoryItem> axelaInventoryItem) {
		this.axelaInventoryItem = axelaInventoryItem;
	}

	public AxelaInventoryItemType() {
	}

	public int getItemtypeId() {
		return this.itemtypeId;
	}

	public void setItemtypeId(int itemtypeId) {
		this.itemtypeId = itemtypeId;
	}

	public String getItemtypeName() {
		return this.itemtypeName;
	}

	public void setItemtypeName(String itemtypeName) {
		this.itemtypeName = itemtypeName;
	}

}