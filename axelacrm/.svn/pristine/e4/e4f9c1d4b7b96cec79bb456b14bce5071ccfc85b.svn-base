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

/**
 * The persistent class for the axela_inventory_stock database table.
 * 
 */
@Entity
@Table(name = "axela_inventory_stock", catalog = "axela_1")
@NamedQuery(name = "AxelaInventoryStock.findAll", query = "SELECT a FROM AxelaInventoryStock a")
public class AxelaInventoryStock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stock_id")
	private int stockId;

	@Column(name = "stock_location_id")
	private int stockLocationId;

	@Column(name = "stock_current_qty")
	private double stockCurrentQty;

	@Column(name = "stock_entry_date")
	private Date stockEntryDate;

	@Column(name = "stock_entry_id")
	private int stockEntryId;

	@Column(name = "stock_item_id")
	private int stockItemId;

	@Column(name = "stock_onhandvalue")
	private double stockOnhandvalue;

	@Column(name = "stock_reorderlevel")
	private int stockReorderlevel;

	@Column(name = "stock_stockindemand")
	private int stockStockindemand;

	@Column(name = "stock_stockinorder")
	private int stockStockinorder;

	@Column(name = "stock_unit_cost")
	private double stockUnitCost;

	@ManyToOne(fetch = FetchType.LAZY)
	// location_id = stock_location_id"
	@JoinColumn(name = "stock_location_id", referencedColumnName = "location_id", insertable = false, updatable = false)
	private AxelaInventoryLocation axelaInventoryLocation;

	public AxelaInventoryStock() {
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getStockLocationId() {
		return this.stockLocationId;
	}

	public void setStockLocationId(int stockLocationId) {
		this.stockLocationId = stockLocationId;
	}

	public double getStockCurrentQty() {
		return this.stockCurrentQty;
	}

	public void setStockCurrentQty(double stockCurrentQty) {
		this.stockCurrentQty = stockCurrentQty;
	}

	public Date getStockEntryDate() {
		return this.stockEntryDate;
	}

	public void setStockEntryDate(Date stockEntryDate) {
		this.stockEntryDate = stockEntryDate;
	}

	public int getStockEntryId() {
		return this.stockEntryId;
	}

	public void setStockEntryId(int stockEntryId) {
		this.stockEntryId = stockEntryId;
	}

	public int getStockItemId() {
		return this.stockItemId;
	}

	public void setStockItemId(int stockItemId) {
		this.stockItemId = stockItemId;
	}

	public double getStockOnhandvalue() {
		return this.stockOnhandvalue;
	}

	public void setStockOnhandvalue(double stockOnhandvalue) {
		this.stockOnhandvalue = stockOnhandvalue;
	}

	public int getStockReorderlevel() {
		return this.stockReorderlevel;
	}

	public void setStockReorderlevel(int stockReorderlevel) {
		this.stockReorderlevel = stockReorderlevel;
	}

	public int getStockStockindemand() {
		return this.stockStockindemand;
	}

	public void setStockStockindemand(int stockStockindemand) {
		this.stockStockindemand = stockStockindemand;
	}

	public int getStockStockinorder() {
		return this.stockStockinorder;
	}

	public void setStockStockinorder(int stockStockinorder) {
		this.stockStockinorder = stockStockinorder;
	}

	public double getStockUnitCost() {
		return this.stockUnitCost;
	}

	public void setStockUnitCost(double stockUnitCost) {
		this.stockUnitCost = stockUnitCost;
	}

}