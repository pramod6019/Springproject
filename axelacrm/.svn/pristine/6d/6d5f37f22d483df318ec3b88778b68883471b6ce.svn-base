package axela.inventory.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import axela.portal.model.AxelaBranch;
import axela.portal.model.AxelaCity;

/**
 * The persistent class for the axela_inventory_location database table.
 * 
 */
@Entity
@Table(name = "axela_inventory_location", catalog = "axela_1")
@NamedQuery(name = "AxelaInventoryLocation.findAll", query = "SELECT a FROM AxelaInventoryLocation a")
public class AxelaInventoryLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	// ===============left join variable===================

	@Transient
	private String branchName;
	@Transient
	private int branchId;
	@Transient
	private String cityName;
	@Transient
	private String stateName;
	@Transient
	private String countryName;

	// =========================
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "location_id")
	private int locationId;

	@Column(name = "location_address")
	private String locationAddress;

	@Column(name = "location_branch_id")
	private int locationBranchId;

	@Column(name = "location_city_id")
	private int locationCityId;

	@Column(name = "location_code")
	private String locationCode;

	@Column(name = "location_entry_date")
	private Date locationEntryDate;

	@Column(name = "location_entry_id")
	private int locationEntryId;

	@Column(name = "location_mobile1")
	private String locationMobile1;

	@Column(name = "location_mobile2")
	private String locationMobile2;

	@Column(name = "location_modified_date")
	private Date locationModifiedDate;

	@Column(name = "location_modified_id")
	private int locationModifiedId;

	@Column(name = "location_name")
	private String locationName;

	@Column(name = "location_phone1")
	private String locationPhone1;

	@Column(name = "location_phone2")
	private String locationPhone2;

	@Column(name = "location_pin")
	private String locationPin;

	// / ==============getting query data===============
	public AxelaInventoryLocation() {
	}

	public AxelaInventoryLocation(String locationName) {
		this.locationName = locationName;
	}

	public AxelaInventoryLocation(int locationId, String locationName, String locationPhone1, String locationPhone2, String branchName, String locationMobile1
			, String locationMobile2, String locationAddress, int branchId, String cityName,
			String stateName, String countryName, String locationPin) {
		this.locationId = locationId;
		this.locationName = locationName;
		this.locationPhone1 = locationPhone1;
		this.locationPhone2 = locationPhone2;
		this.branchName = branchName;
		this.locationMobile1 = locationMobile1;
		this.locationMobile2 = locationMobile2;
		this.locationAddress = locationAddress;
		this.branchId = branchId;
		this.cityName = cityName;
		this.stateName = stateName;
		this.countryName = countryName;
		this.locationPin = locationPin;
	}
	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public AxelaBranch getAxelaBranch() {
		return axelaBranch;
	}

	public void setAxelaBranch(AxelaBranch axelaBranch) {
		this.axelaBranch = axelaBranch;
	}

	public AxelaCity getAxelaCity() {
		return axelaCity;
	}

	public void setAxelaCity(AxelaCity axelaCity) {
		this.axelaCity = axelaCity;
	}

	public AxelaInventoryLocation(int locationId, String locationName, String locationCode) {
		this.locationId = locationId;
		this.locationName = locationName;
		this.locationCode = locationCode;
	}

	public AxelaInventoryLocation(int locationBranchId, String locationName, String locationCode,
			String locationPhone1, String locationPhone2, String locationMobile1,
			String locationMobile2, String locationAddress, int locationCityId,
			String locationPin, int locationEntryId, Date locationEntryDate,
			int locationModifiedId, Date locationModifiedDate) {
		this.locationBranchId = locationBranchId;
		this.locationName = locationName;
		this.locationCode = locationCode;
		this.locationPhone1 = locationPhone1;
		this.locationPhone2 = locationPhone2;
		this.locationMobile1 = locationMobile1;
		this.locationMobile2 = locationMobile2;
		this.locationAddress = locationAddress;
		this.locationCityId = locationCityId;
		this.locationPin = locationPin;
		this.locationEntryId = locationEntryId;
		this.locationEntryDate = locationEntryDate;
		this.locationModifiedId = locationModifiedId;
		this.locationModifiedDate = locationModifiedDate;

	}
	// ============Mapping================
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_branch_id", referencedColumnName = "branch_id", insertable = false, updatable = false)
	private AxelaBranch axelaBranch;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_city_id", referencedColumnName = "city_id", insertable = false, updatable = false)
	private AxelaCity axelaCity;

	@OneToMany(mappedBy = "axelaInventoryLocation")
	private List<AxelaInventoryStock> axelaInventoryStock;

	@OneToMany(mappedBy = "axelaInventoryLocation")
	private List<AxelaInventoryBinPop> axelaInventoryBinPop;

	// =======================================
	public int getLocationId() {
		return this.locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationAddress() {
		return this.locationAddress;
	}

	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}

	public int getLocationBranchId() {
		return this.locationBranchId;
	}

	public void setLocationBranchId(int locationBranchId) {
		this.locationBranchId = locationBranchId;
	}

	public int getLocationCityId() {
		return this.locationCityId;
	}

	public void setLocationCityId(int locationCityId) {
		this.locationCityId = locationCityId;
	}

	public String getLocationCode() {
		return this.locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public Date getLocationEntryDate() {
		return this.locationEntryDate;
	}

	public void setLocationEntryDate(Date locationEntryDate) {
		this.locationEntryDate = locationEntryDate;
	}

	public int getLocationEntryId() {
		return this.locationEntryId;
	}

	public void setLocationEntryId(int locationEntryId) {
		this.locationEntryId = locationEntryId;
	}

	public String getLocationMobile1() {
		return this.locationMobile1;
	}

	public void setLocationMobile1(String locationMobile1) {
		this.locationMobile1 = locationMobile1;
	}

	public String getLocationMobile2() {
		return this.locationMobile2;
	}

	public void setLocationMobile2(String locationMobile2) {
		this.locationMobile2 = locationMobile2;
	}

	public Date getLocationModifiedDate() {
		return this.locationModifiedDate;
	}

	public void setLocationModifiedDate(Date locationModifiedDate) {
		this.locationModifiedDate = locationModifiedDate;
	}

	public int getLocationModifiedId() {
		return this.locationModifiedId;
	}

	public void setLocationModifiedId(int locationModifiedId) {
		this.locationModifiedId = locationModifiedId;
	}

	public String getLocationName() {
		return this.locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationPhone1() {
		return this.locationPhone1;
	}

	public void setLocationPhone1(String locationPhone1) {
		this.locationPhone1 = locationPhone1;
	}

	public String getLocationPhone2() {
		return this.locationPhone2;
	}

	public void setLocationPhone2(String locationPhone2) {
		this.locationPhone2 = locationPhone2;
	}

	public String getLocationPin() {
		return this.locationPin;
	}

	public void setLocationPin(String locationPin) {
		this.locationPin = locationPin;
	}

}