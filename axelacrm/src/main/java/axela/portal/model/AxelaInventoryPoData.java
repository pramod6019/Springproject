package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_inventory_po_data database table.
 * 
 */
@Entity
@Table(name = "axela_inventory_po_data", catalog = "axela_1")
@NamedQuery(name = "AxelaInventoryPoData.findAll", query = "SELECT a FROM AxelaInventoryPoData a")
public class AxelaInventoryPoData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "podata_id")
	private int podataId;

	@Column(name = "podata_entry_date")
	private String podataEntryDate;

	@Column(name = "podata_entry_id")
	private int podataEntryId;

	@Column(name = "podata_item_id")
	private int podataItemId;

	@Column(name = "podata_minorderqty")
	private int podataMinorderqty;

	@Column(name = "podata_modified_date")
	private String podataModifiedDate;

	@Column(name = "podata_modified_id")
	private int podataModifiedId;

	@Column(name = "podata_supplier_code")
	private String podataSupplierCode;

	@Column(name = "podata_supplier_id")
	private int podataSupplierId;

	@Column(name = "podata_supplier_uom_id")
	private int podataSupplierUomId;

	public AxelaInventoryPoData() {
	}

	public int getPodataId() {
		return this.podataId;
	}

	public void setPodataId(int podataId) {
		this.podataId = podataId;
	}

	public String getPodataEntryDate() {
		return this.podataEntryDate;
	}

	public void setPodataEntryDate(String podataEntryDate) {
		this.podataEntryDate = podataEntryDate;
	}

	public int getPodataEntryId() {
		return this.podataEntryId;
	}

	public void setPodataEntryId(int podataEntryId) {
		this.podataEntryId = podataEntryId;
	}

	public int getPodataItemId() {
		return this.podataItemId;
	}

	public void setPodataItemId(int podataItemId) {
		this.podataItemId = podataItemId;
	}

	public int getPodataMinorderqty() {
		return this.podataMinorderqty;
	}

	public void setPodataMinorderqty(int podataMinorderqty) {
		this.podataMinorderqty = podataMinorderqty;
	}

	public String getPodataModifiedDate() {
		return this.podataModifiedDate;
	}

	public void setPodataModifiedDate(String podataModifiedDate) {
		this.podataModifiedDate = podataModifiedDate;
	}

	public int getPodataModifiedId() {
		return this.podataModifiedId;
	}

	public void setPodataModifiedId(int podataModifiedId) {
		this.podataModifiedId = podataModifiedId;
	}

	public String getPodataSupplierCode() {
		return this.podataSupplierCode;
	}

	public void setPodataSupplierCode(String podataSupplierCode) {
		this.podataSupplierCode = podataSupplierCode;
	}

	public int getPodataSupplierId() {
		return this.podataSupplierId;
	}

	public void setPodataSupplierId(int podataSupplierId) {
		this.podataSupplierId = podataSupplierId;
	}

	public int getPodataSupplierUomId() {
		return this.podataSupplierUomId;
	}

	public void setPodataSupplierUomId(int podataSupplierUomId) {
		this.podataSupplierUomId = podataSupplierUomId;
	}

}