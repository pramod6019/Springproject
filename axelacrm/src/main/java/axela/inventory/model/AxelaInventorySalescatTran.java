package axela.inventory.model;

import java.io.Serializable;

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

/**
 * The primary key class for the axela_inventory_salescat_trans database table.
 * 
 */
@Entity
@Table(name = "axela_inventory_salescat_trans", catalog = "axela_1")
@NamedQuery(name = "AxelaInventorySalescatTran.findAll", query = "SELECT a FROM AxelaInventorySalescatTran a")
public class AxelaInventorySalescatTran implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trans_id")
	private int transId;

	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}

	@Column(name = "trans_salescat_id")
	private int transSalescatId;

	@Column(name = "trans_item_id")
	private int transItemId;

	public AxelaInventorySalescatTran() {
	}
	public int getTransSalescatId() {
		return this.transSalescatId;
	}
	public void setTransSalescatId(int transSalescatId) {
		this.transSalescatId = transSalescatId;
	}
	public int getTransItemId() {
		return this.transItemId;
	}
	public void setTransItemId(int transItemId) {
		this.transItemId = transItemId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trans_item_id", referencedColumnName = "item_id", insertable = false, updatable = false)
	private AxelaInventoryItem axelaInventoryItem;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trans_salescat_id", referencedColumnName = "salescat_id", insertable = false, updatable = false)
	private AxelaInventorySalescat axelaInventorySalescat;

	// mapping
	// @OneToMany(mappedBy = "axelaInventorySalescatTran")
	// private List<AxelaInventorySalescatTran> axelaInventorySalescatTran;
	// =================================
}