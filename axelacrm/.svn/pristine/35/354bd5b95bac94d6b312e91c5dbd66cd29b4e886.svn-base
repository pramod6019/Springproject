package axela.service.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the axela_location database table.
 * 
 */
@Entity
@Table(name = "axela_location", catalog = "axela_1")
@NamedQuery(name = "AxelaLocation.findAll", query = "SELECT a FROM AxelaLocation a")
public class AxelaLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "location_id")
	private int locationId;

	@Column(name = "location_entry_date")
	private String locationEntryDate;

	@Column(name = "location_entry_id")
	private int locationEntryId;

	@Column(name = "location_modified_date")
	private String locationModifiedDate;

	@Column(name = "location_modified_id")
	private int locationModifiedId;

	@Column(name = "location_name")
	private String locationName;

	@Column(name = "location_pin")
	private String locationPin;

	@Column(name = "location_zone_id")
	private int locationZoneId;

	public AxelaLocation() {
	}
	@OneToMany(mappedBy = "axelaLocation")
	private List<AxelaServiceContractAsset> axelaServiceContractAsset;

	public List<AxelaServiceContractAsset> getAxelaServiceContractAsset() {
		return axelaServiceContractAsset;
	}

	public void setAxelaServiceContractAsset(List<AxelaServiceContractAsset> axelaServiceContractAsset) {
		this.axelaServiceContractAsset = axelaServiceContractAsset;
	}

	public int getLocationId() {
		return this.locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationEntryDate() {
		return this.locationEntryDate;
	}

	public void setLocationEntryDate(String locationEntryDate) {
		this.locationEntryDate = locationEntryDate;
	}

	public int getLocationEntryId() {
		return this.locationEntryId;
	}

	public void setLocationEntryId(int locationEntryId) {
		this.locationEntryId = locationEntryId;
	}

	public String getLocationModifiedDate() {
		return this.locationModifiedDate;
	}

	public void setLocationModifiedDate(String locationModifiedDate) {
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

	public String getLocationPin() {
		return this.locationPin;
	}

	public void setLocationPin(String locationPin) {
		this.locationPin = locationPin;
	}

	public int getLocationZoneId() {
		return this.locationZoneId;
	}

	public void setLocationZoneId(int locationZoneId) {
		this.locationZoneId = locationZoneId;
	}

}