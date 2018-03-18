package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_currency database table.
 * 
 */
@Entity
@Table(name = "axela_currency", catalog = "axela")
@NamedQuery(name = "AxelaCurrency.findAll", query = "SELECT a FROM AxelaCurrency a")
public class AxelaCurrency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "currency_id")
	private int currencyId;

	@Column(name = "currency_country")
	private String currencyCountry;

	@Column(name = "currency_entry_date")
	private String currencyEntryDate;

	@Column(name = "currency_entry_id")
	private int currencyEntryId;

	@Column(name = "currency_modified_date")
	private String currencyModifiedDate;

	@Column(name = "currency_modified_id")
	private int currencyModifiedId;

	@Column(name = "currency_name")
	private String currencyName;

	@Column(name = "currency_symbol")
	private String currencySymbol;

	public AxelaCurrency() {
	}

	public int getCurrencyId() {
		return this.currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyCountry() {
		return this.currencyCountry;
	}

	public void setCurrencyCountry(String currencyCountry) {
		this.currencyCountry = currencyCountry;
	}

	public String getCurrencyEntryDate() {
		return this.currencyEntryDate;
	}

	public void setCurrencyEntryDate(String currencyEntryDate) {
		this.currencyEntryDate = currencyEntryDate;
	}

	public int getCurrencyEntryId() {
		return this.currencyEntryId;
	}

	public void setCurrencyEntryId(int currencyEntryId) {
		this.currencyEntryId = currencyEntryId;
	}

	public String getCurrencyModifiedDate() {
		return this.currencyModifiedDate;
	}

	public void setCurrencyModifiedDate(String currencyModifiedDate) {
		this.currencyModifiedDate = currencyModifiedDate;
	}

	public int getCurrencyModifiedId() {
		return this.currencyModifiedId;
	}

	public void setCurrencyModifiedId(int currencyModifiedId) {
		this.currencyModifiedId = currencyModifiedId;
	}

	public String getCurrencyName() {
		return this.currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getCurrencySymbol() {
		return this.currencySymbol;
	}

	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

}