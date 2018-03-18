package axela.inventory.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the axela_inventory_uom database table.
 * 
 */
@Entity
@Table(name = "axela_inventory_uom", catalog = "axela_1")
@NamedQuery(name = "AxelaInventoryUom.findAll", query = "SELECT a FROM AxelaInventoryUom a")
public class AxelaInventoryUom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Transient
	private String uomParentName;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uom_id")
	private int uomId;

	@Column(name = "uom_entry_date")
	private Date uomEntryDate;

	@Column(name = "uom_entry_id")
	private int uomEntryId;

	@Column(name = "uom_modified_date")
	private Date uomModifiedDate;

	@Column(name = "uom_modified_id")
	private int uomModifiedId;

	@Column(name = "uomName")
	private String uomName;

	@Column(name = "uomParentId")
	private int uomParentId;

	@Column(name = "uomRatio")
	private double uomRatio;

	@Column(name = "uomShortname")
	private String uomShortname;

	public AxelaInventoryUom() {
	}

	public AxelaInventoryUom(
			int uomId,
			String uomName,
			double uomRatio,
			int uomParentId,
			String uomParentName,
			String uomShortname) {
		super();
		this.uomId = uomId;
		this.uomName = uomName;
		this.uomRatio = uomRatio;
		this.uomParentId = uomParentId;
		this.uomParentName = uomParentName;
		this.uomShortname = uomShortname;
	}

	public AxelaInventoryUom(
			int uomId,
			String uomName,
			String uomShortname,
			int uomParentId,
			double uomRatio,
			int uomEntryId,
			Date uomEntryDate,
			int uomModifiedId,
			Date uomModifiedDate) {
		super();
		this.uomId = uomId;
		this.uomEntryDate = uomEntryDate;
		this.uomEntryId = uomEntryId;
		this.uomModifiedDate = uomModifiedDate;
		this.uomModifiedId = uomModifiedId;
		this.uomName = uomName;
		this.uomParentId = uomParentId;
		this.uomRatio = uomRatio;
		this.uomShortname = uomShortname;
	}

	public int getUomId() {
		return this.uomId;
	}

	public void setUomId(int uomId) {
		this.uomId = uomId;
	}

	public Date getUomEntryDate() {
		return this.uomEntryDate;
	}

	public void setUomEntryDate(Date uomEntryDate) {
		this.uomEntryDate = uomEntryDate;
	}

	public int getUomEntryId() {
		return this.uomEntryId;
	}

	public void setUomEntryId(int uomEntryId) {
		this.uomEntryId = uomEntryId;
	}

	public Date getUomModifiedDate() {
		return this.uomModifiedDate;
	}

	public void setUomModifiedDate(Date uomModifiedDate) {
		this.uomModifiedDate = uomModifiedDate;
	}

	public int getUomModifiedId() {
		return this.uomModifiedId;
	}

	public void setUomModifiedId(int uomModifiedId) {
		this.uomModifiedId = uomModifiedId;
	}

	public String getUomName() {
		return this.uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	public int getUomParentId() {
		return this.uomParentId;
	}

	public void setUomParentId(int uomParentId) {
		this.uomParentId = uomParentId;
	}

	public double getUomRatio() {
		return this.uomRatio;
	}

	public void setUomRatio(double uomRatio) {
		this.uomRatio = uomRatio;
	}

	public String getUomParentName() {
		return uomParentName;
	}

	public void setUomParentName(String uomParentName) {
		this.uomParentName = uomParentName;
	}

	public String getUomShortname() {
		return this.uomShortname;
	}

	public void setUomShortname(String uomShortname) {
		this.uomShortname = uomShortname;
	}

}