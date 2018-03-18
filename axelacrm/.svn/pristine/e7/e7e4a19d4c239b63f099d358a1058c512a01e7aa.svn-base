package axela.portal.model;

import java.io.Serializable;
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

import axela.customer.model.AxelaCustomer;
import axela.customer.model.AxelaCustomerContact;
import axela.sales.model.AxelaSalesOppr;

/**
 * The persistent class for the axela_city database table.
 * 
 */
@Entity
@Table(name = "axela_city", catalog = "axela")
@NamedQuery(name = "AxelaCity.findAll", query = "SELECT a FROM AxelaCity a")
public class AxelaCity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "city_id")
	private int cityId;

	@Column(name = "city_entry_date")
	private String cityEntryDate;

	@Column(name = "city_entry_id")
	private int cityEntryId;

	@Column(name = "city_latitude")
	private double cityLatitude;

	@Column(name = "city_longitude")
	private double cityLongitude;

	@Column(name = "city_modified_date")
	private String cityModifiedDate;

	@Column(name = "city_modified_id")
	private int cityModifiedId;

	@Column(name = "city_name")
	private String cityName;

	@Column(name = "city_state_id")
	private int cityStateId;

	// one-to-many relation with AxelaCustomer
	@OneToMany(mappedBy = "axelaCity")
	private List<AxelaSalesOppr> axelaSalesOppr;

	@OneToMany(mappedBy = "axelaCity")
	private List<AxelaCustomer> axelaCustomers;

	@OneToMany(mappedBy = "axelaCity")
	private List<AxelaBranch> axelaBranch;

	// many-to-one realtion with Axela_State
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_state_id", referencedColumnName = "state_id", insertable = false, updatable = false)
	private AxelaState axelaState;

	// one-to-many relation with AxelaCustomerContact
	@OneToMany(mappedBy = "axelaCity")
	private List<AxelaCustomerContact> axelaCustomercontact;

	@OneToMany(mappedBy = "axelaCity")
	private List<AxelaEmp> axelaEmp;

	public List<AxelaEmp> getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(List<AxelaEmp> axelaEmp) {
		this.axelaEmp = axelaEmp;
	}

	public List<AxelaCustomerContact> getAxelaCustomercontact() {
		return axelaCustomercontact;
	}

	public void setAxelaCustomercontact(List<AxelaCustomerContact> axelaCustomercontact) {
		this.axelaCustomercontact = axelaCustomercontact;
	}

	public AxelaState getAxelaState() {
		return axelaState;
	}

	public void setAxelaState(AxelaState axelaState) {
		this.axelaState = axelaState;
	}

	public List<AxelaCustomer> getAxelaCustomers() {
		return axelaCustomers;
	}

	public void setAxelaCustomers(List<AxelaCustomer> axelaCustomers) {
		this.axelaCustomers = axelaCustomers;
	}

	public AxelaCity() {
	}

	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public List<AxelaBranch> getAxelaBranch() {
		return axelaBranch;
	}

	public void setAxelaBranch(List<AxelaBranch> axelaBranch) {
		this.axelaBranch = axelaBranch;
	}

	public String getCityEntryDate() {
		return this.cityEntryDate;
	}

	public void setCityEntryDate(String cityEntryDate) {
		this.cityEntryDate = cityEntryDate;
	}

	public int getCityEntryId() {
		return this.cityEntryId;
	}

	public void setCityEntryId(int cityEntryId) {
		this.cityEntryId = cityEntryId;
	}

	public double getCityLatitude() {
		return this.cityLatitude;
	}

	public void setCityLatitude(double cityLatitude) {
		this.cityLatitude = cityLatitude;
	}

	public double getCityLongitude() {
		return this.cityLongitude;
	}

	public void setCityLongitude(double cityLongitude) {
		this.cityLongitude = cityLongitude;
	}

	public String getCityModifiedDate() {
		return this.cityModifiedDate;
	}

	public void setCityModifiedDate(String cityModifiedDate) {
		this.cityModifiedDate = cityModifiedDate;
	}

	public int getCityModifiedId() {
		return this.cityModifiedId;
	}

	public void setCityModifiedId(int cityModifiedId) {
		this.cityModifiedId = cityModifiedId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getCityStateId() {
		return this.cityStateId;
	}

	public void setCityStateId(int cityStateId) {
		this.cityStateId = cityStateId;
	}

}