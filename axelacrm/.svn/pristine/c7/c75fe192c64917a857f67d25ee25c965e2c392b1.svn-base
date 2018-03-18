package axela.portal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the axela_country database table.
 * 
 */
@Entity
@Table(name = "axela_country", catalog = "axela")
@NamedQuery(name = "AxelaCountry.findAll", query = "SELECT a FROM AxelaCountry a")
public class AxelaCountry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "country_id")
	private int countryId;

	@Column(name = "country_active")
	private String countryActive;

	@Column(name = "country_capital")
	private String countryCapital;

	@Column(name = "country_code")
	private String countryCode;

	@Column(name = "country_currency")
	private String countryCurrency;

	@Column(name = "country_currency_symbol")
	private String countryCurrencySymbol;

	@Column(name = "country_desc")
	private String countryDesc;

	@Column(name = "country_entry_date")
	private String countryEntryDate;

	// one-to-many relation with axelastate
	@OneToMany(mappedBy = "axelaCountry", cascade = CascadeType.ALL)
	private List<AxelaState> axelaState;

	public List<AxelaState> getAxelaState() {
		return axelaState;
	}

	public void setAxelaState(List<AxelaState> axelaState) {
		this.axelaState = axelaState;
	}

	@Column(name = "country_entry_id")
	private int countryEntryId;

	@Column(name = "country_ex_rate")
	private double countryExRate;

	@Column(name = "country_featured")
	private String countryFeatured;

	@Column(name = "country_isd_code")
	private String countryIsdCode;

	@Column(name = "country_latitude")
	private double countryLatitude;

	@Column(name = "country_longitude")
	private double countryLongitude;

	@Column(name = "country_modified_date")
	private String countryModifiedDate;

	@Column(name = "country_modified_id")
	private int countryModifiedId;

	@Column(name = "country_name")
	private String countryName;

	@Column(name = "country_regions")
	private int countryRegions;

	public AxelaCountry() {
	}

	public int getCountryId() {
		return this.countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryActive() {
		return this.countryActive;
	}

	public void setCountryActive(String countryActive) {
		this.countryActive = countryActive;
	}

	public String getCountryCapital() {
		return this.countryCapital;
	}

	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryCurrency() {
		return this.countryCurrency;
	}

	public void setCountryCurrency(String countryCurrency) {
		this.countryCurrency = countryCurrency;
	}

	public String getCountryCurrencySymbol() {
		return this.countryCurrencySymbol;
	}

	public void setCountryCurrencySymbol(String countryCurrencySymbol) {
		this.countryCurrencySymbol = countryCurrencySymbol;
	}

	public String getCountryDesc() {
		return this.countryDesc;
	}

	public void setCountryDesc(String countryDesc) {
		this.countryDesc = countryDesc;
	}

	public String getCountryEntryDate() {
		return this.countryEntryDate;
	}

	public void setCountryEntryDate(String countryEntryDate) {
		this.countryEntryDate = countryEntryDate;
	}

	public int getCountryEntryId() {
		return this.countryEntryId;
	}

	public void setCountryEntryId(int countryEntryId) {
		this.countryEntryId = countryEntryId;
	}

	public double getCountryExRate() {
		return this.countryExRate;
	}

	public void setCountryExRate(double countryExRate) {
		this.countryExRate = countryExRate;
	}

	public String getCountryFeatured() {
		return this.countryFeatured;
	}

	public void setCountryFeatured(String countryFeatured) {
		this.countryFeatured = countryFeatured;
	}

	public String getCountryIsdCode() {
		return this.countryIsdCode;
	}

	public void setCountryIsdCode(String countryIsdCode) {
		this.countryIsdCode = countryIsdCode;
	}

	public double getCountryLatitude() {
		return this.countryLatitude;
	}

	public void setCountryLatitude(double countryLatitude) {
		this.countryLatitude = countryLatitude;
	}

	public double getCountryLongitude() {
		return this.countryLongitude;
	}

	public void setCountryLongitude(double countryLongitude) {
		this.countryLongitude = countryLongitude;
	}

	public String getCountryModifiedDate() {
		return this.countryModifiedDate;
	}

	public void setCountryModifiedDate(String countryModifiedDate) {
		this.countryModifiedDate = countryModifiedDate;
	}

	public int getCountryModifiedId() {
		return this.countryModifiedId;
	}

	public void setCountryModifiedId(int countryModifiedId) {
		this.countryModifiedId = countryModifiedId;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getCountryRegions() {
		return this.countryRegions;
	}

	public void setCountryRegions(int countryRegions) {
		this.countryRegions = countryRegions;
	}

}