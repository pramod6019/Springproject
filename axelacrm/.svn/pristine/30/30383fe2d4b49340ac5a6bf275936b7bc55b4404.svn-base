package axela.inventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_inventory_item_price_trans database table.
 * 
 */
@Entity
@Table(name = "axela_inventory_item_price_trans", catalog = "axela_1")
@NamedQuery(name = "AxelaInventoryItemPriceTran.findAll", query = "SELECT a FROM AxelaInventoryItemPriceTran a")
public class AxelaInventoryItemPriceTran implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pricetrans_id")
	private int pricetransId;

	@Column(name = "pricetrans_amt")
	private double pricetransAmt;

	@Column(name = "pricetrans_item_id")
	private int pricetransItemId;

	@Column(name = "pricetrans_price_id")
	private int pricetransPriceId;

	public AxelaInventoryItemPriceTran() {
	}

	public int getPricetransId() {
		return this.pricetransId;
	}

	public void setPricetransId(int pricetransId) {
		this.pricetransId = pricetransId;
	}

	public double getPricetransAmt() {
		return this.pricetransAmt;
	}

	public void setPricetransAmt(double pricetransAmt) {
		this.pricetransAmt = pricetransAmt;
	}

	public int getPricetransItemId() {
		return this.pricetransItemId;
	}

	public void setPricetransItemId(int pricetransItemId) {
		this.pricetransItemId = pricetransItemId;
	}

	public int getPricetransPriceId() {
		return this.pricetransPriceId;
	}

	public void setPricetransPriceId(int pricetransPriceId) {
		this.pricetransPriceId = pricetransPriceId;
	}

}