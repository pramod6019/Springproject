package axela.portal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_tax database table.
 * 
 */
@Entity
@Table(name = "axela_tax", catalog = "axela_1")
@NamedQuery(name = "AxelaTax.findAll", query = "SELECT a FROM AxelaTax a")
public class AxelaTax implements Serializable {
	private static final long serialVersionUID = 1L;

	public AxelaTax(
			int taxId,
			String taxName,
			double taxValue) {
		super();
		this.taxId = taxId;
		this.taxName = taxName;
		this.taxValue = taxValue;
	}

	@Id
	@Column(name = "tax_id")
	private int taxId;

	@Column(name = "tax_entry_date")
	private Date taxEntryDate;

	@Column(name = "tax_entry_id")
	private int taxEntryId;

	@Column(name = "tax_modified_date")
	private Date taxModifiedDate;

	@Column(name = "tax_modified_id")
	private int taxModifiedId;

	@Column(name = "tax_name")
	private String taxName;

	@Column(name = "tax_value")
	private double taxValue;

	public AxelaTax() {
	}

	public int getTaxId() {
		return this.taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public Date getTaxEntryDate() {
		return this.taxEntryDate;
	}

	public void setTaxEntryDate(Date taxEntryDate) {
		this.taxEntryDate = taxEntryDate;
	}

	public int getTaxEntryId() {
		return this.taxEntryId;
	}

	public void setTaxEntryId(int taxEntryId) {
		this.taxEntryId = taxEntryId;
	}

	public Date getTaxModifiedDate() {
		return this.taxModifiedDate;
	}

	public void setTaxModifiedDate(Date taxModifiedDate) {
		this.taxModifiedDate = taxModifiedDate;
	}

	public int getTaxModifiedId() {
		return this.taxModifiedId;
	}

	public void setTaxModifiedId(int taxModifiedId) {
		this.taxModifiedId = taxModifiedId;
	}

	public String getTaxName() {
		return this.taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}

	public double getTaxValue() {
		return this.taxValue;
	}

	public void setTaxValue(double taxValue) {
		this.taxValue = taxValue;
	}

}