package axela.portal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * The persistent class for the axela_state database table.
 * 
 */
@Entity
@Table(name = "axela_state", catalog = "axela")
@NamedQuery(name = "AxelaState.findAll", query = "SELECT a FROM AxelaState a")
public class AxelaState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "state_id")
	private int stateId;

	@Column(name = "state_country_id")
	private int stateCountryId;

	@Column(name = "state_entry_date")
	private String stateEntryDate;

	@Column(name = "state_entry_id")
	private int stateEntryId;

	@Column(name = "state_latitude")
	private double stateLatitude;

	@Column(name = "state_longitude")
	private double stateLongitude;

	@Column(name = "state_modified_date")
	private String stateModifiedDate;

	@Column(name = "state_modified_id")
	private int stateModifiedId;

	@Column(name = "state_name")
	private String stateName;

	// bi-directional one-to-many association to AxelaCustomerContact
	@OneToMany(mappedBy = "axelaState", cascade = CascadeType.ALL)
	private List<AxelaCity> axelaCity;

	// many-to-one realtion with AxelaCountry
	@ManyToOne(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "state_country_id", referencedColumnName = "country_id", insertable = false, updatable = false)
	private AxelaCountry axelaCountry;

	public AxelaCountry getAxelaCountry() {
		return axelaCountry;
	}

	public void setAxelaCountry(AxelaCountry axelaCountry) {
		this.axelaCountry = axelaCountry;
	}

	public List<AxelaCity> getAxelaCity() {
		return axelaCity;
	}

	public void setAxelaCity(List<AxelaCity> axelaCity) {
		this.axelaCity = axelaCity;
	}

	public AxelaState() {
	}

	public int getStateId() {
		return this.stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getStateCountryId() {
		return this.stateCountryId;
	}

	public void setStateCountryId(int stateCountryId) {
		this.stateCountryId = stateCountryId;
	}

	public String getStateEntryDate() {
		return this.stateEntryDate;
	}

	public void setStateEntryDate(String stateEntryDate) {
		this.stateEntryDate = stateEntryDate;
	}

	public int getStateEntryId() {
		return this.stateEntryId;
	}

	public void setStateEntryId(int stateEntryId) {
		this.stateEntryId = stateEntryId;
	}

	public double getStateLatitude() {
		return this.stateLatitude;
	}

	public void setStateLatitude(double stateLatitude) {
		this.stateLatitude = stateLatitude;
	}

	public double getStateLongitude() {
		return this.stateLongitude;
	}

	public void setStateLongitude(double stateLongitude) {
		this.stateLongitude = stateLongitude;
	}

	public String getStateModifiedDate() {
		return this.stateModifiedDate;
	}

	public void setStateModifiedDate(String stateModifiedDate) {
		this.stateModifiedDate = stateModifiedDate;
	}

	public int getStateModifiedId() {
		return this.stateModifiedId;
	}

	public void setStateModifiedId(int stateModifiedId) {
		this.stateModifiedId = stateModifiedId;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}