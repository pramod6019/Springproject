package axela.service.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import axela.customer.model.AxelaCustomer;

/**
 * The persistent class for the axela_service_contract_location database table.
 * 
 */
@Entity
@Table(name = "axela_service_contract_location", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceContractLocation.findAll", query = "SELECT a FROM AxelaServiceContractLocation a")
public class AxelaServiceContractLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Transient
	private int customerId;

	@Transient
	private String customerName;

	@Transient
	private int assetContractlocId;

	@Id
	@Column(name = "contractloc_id")
	private int contractlocId;

	@Column(name = "contractloc_address")
	private String contractlocAddress;

	@Column(name = "contractloc_city_id")
	private String contractlocCityId;

	@Column(name = "contractloc_customer_id")
	private int contractlocCustomerId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getAssetContractlocId() {
		return assetContractlocId;
	}

	public void setAssetContractlocId(int assetContractlocId) {
		this.assetContractlocId = assetContractlocId;
	}

	public AxelaCustomer getAxelaCustomer() {
		return axelaCustomer;
	}

	public void setAxelaCustomer(AxelaCustomer axelaCustomer) {
		this.axelaCustomer = axelaCustomer;
	}

	@Column(name = "contractloc_entry_date")
	private Date contractlocEntryDate;

	@Column(name = "contractloc_entry_id")
	private int contractlocEntryId;

	@Column(name = "contractloc_lat")
	private String contractlocLat;

	@Column(name = "contractloc_long")
	private String contractlocLong;

	@Column(name = "contractloc_modified_date")
	private Date contractlocModifiedDate;

	@Column(name = "contractloc_modified_id")
	private int contractlocModifiedId;

	@Column(name = "contractloc_name")
	private String contractlocName;

	@Column(name = "contractloc_notes")
	private String contractlocNotes;

	@Column(name = "contractloc_pin")
	private String contractlocPin;

	public AxelaServiceContractLocation() {
	}

	public AxelaServiceContractLocation(
			int contractlocId,
			int contractlocCustomerId,
			String contractlocName,
			String contractlocAddress,
			String contractlocPin,
			String contractlocCityId,
			String contractlocLat,
			String contractlocLong,
			String contractlocNotes,
			int contractlocEntryId,
			Date contractlocEntryDate,
			int contractlocModifiedId,
			Date contractlocModifiedDate) {
		this.contractlocId = contractlocId;
		this.contractlocCustomerId = contractlocCustomerId;
		this.contractlocName = contractlocName;
		this.contractlocAddress = contractlocAddress;
		this.contractlocPin = contractlocPin;
		this.contractlocCityId = contractlocCityId;
		this.contractlocLat = contractlocLat;
		this.contractlocLong = contractlocLong;
		this.contractlocNotes = contractlocNotes;
		this.contractlocEntryId = contractlocEntryId;
		this.contractlocEntryDate = contractlocEntryDate;
		this.contractlocModifiedId = contractlocModifiedId;
		this.contractlocModifiedDate = contractlocModifiedDate;
	}

	public AxelaServiceContractLocation(int contractlocId, int contractlocCustomerId,
			String contractlocName, String contractlocAddress,
			int customerId, String customerName, String contractlocCityId, String contractlocPin,
			String contractlocLat, String contractlocLong, String contractlocNotes,
			int assetContractlocId) {
		this.contractlocId = contractlocId;
		this.contractlocCustomerId = contractlocCustomerId;
		this.contractlocName = contractlocName;
		this.contractlocAddress = contractlocAddress;
		this.customerId = customerId;
		this.customerName = customerName;
		this.contractlocCityId = contractlocCityId;
		this.contractlocPin = contractlocPin;
		this.contractlocLat = contractlocLat;
		this.contractlocLong = contractlocLong;
		this.contractlocNotes = contractlocNotes;
		this.assetContractlocId = assetContractlocId;
	}

	public int getContractlocId() {
		return this.contractlocId;
	}

	public void setContractlocId(int contractlocId) {
		this.contractlocId = contractlocId;
	}

	public String getContractlocAddress() {
		return this.contractlocAddress;
	}

	public void setContractlocAddress(String contractlocAddress) {
		this.contractlocAddress = contractlocAddress;
	}

	public int getContractlocCustomerId() {
		return this.contractlocCustomerId;
	}

	public void setContractlocCustomerId(int contractlocCustomerId) {
		this.contractlocCustomerId = contractlocCustomerId;
	}

	public Date getContractlocEntryDate() {
		return this.contractlocEntryDate;
	}

	public void setContractlocEntryDate(Date contractlocEntryDate) {
		this.contractlocEntryDate = contractlocEntryDate;
	}

	public int getContractlocEntryId() {
		return this.contractlocEntryId;
	}

	public void setContractlocEntryId(int contractlocEntryId) {
		this.contractlocEntryId = contractlocEntryId;
	}

	public String getContractlocLat() {
		return this.contractlocLat;
	}

	public void setContractlocLat(String contractlocLat) {
		this.contractlocLat = contractlocLat;
	}

	public String getContractlocLong() {
		return this.contractlocLong;
	}

	public void setContractlocLong(String contractlocLong) {
		this.contractlocLong = contractlocLong;
	}

	public Date getContractlocModifiedDate() {
		return this.contractlocModifiedDate;
	}

	public void setContractlocModifiedDate(Date contractlocModifiedDate) {
		this.contractlocModifiedDate = contractlocModifiedDate;
	}

	public int getContractlocModifiedId() {
		return this.contractlocModifiedId;
	}

	public void setContractlocModifiedId(int contractlocModifiedId) {
		this.contractlocModifiedId = contractlocModifiedId;
	}

	public String getContractlocName() {
		return this.contractlocName;
	}

	public void setContractlocName(String contractlocName) {
		this.contractlocName = contractlocName;
	}

	public String getContractlocNotes() {
		return this.contractlocNotes;
	}

	public void setContractlocNotes(String contractlocNotes) {
		this.contractlocNotes = contractlocNotes;
	}

	public String getContractlocPin() {
		return this.contractlocPin;
	}

	public void setContractlocPin(String contractlocPin) {
		this.contractlocPin = contractlocPin;
	}

	// ==================mapping===========================
	// @OneToMany(mappedBy = "axelaServiceContractLocation", cascade = CascadeType.ALL)
	// public List<AxelaServiceContractAsset> axelaServiceContractAsset;

	public String getContractlocCityId() {
		return contractlocCityId;
	}

	public void setContractlocCityId(String contractlocCityId) {
		this.contractlocCityId = contractlocCityId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contractloc_id", referencedColumnName = "asset_contractloc_id", insertable = false, updatable = false)
	private AxelaServiceContractAsset axelaServiceContractAsset;

	// many-to-one association to AxelaEmp
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contractloc_customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
	private AxelaCustomer axelaCustomer;

}