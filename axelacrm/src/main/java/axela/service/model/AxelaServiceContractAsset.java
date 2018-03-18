package axela.service.model;

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

import axela.customer.model.AxelaCustomer;

/**
 * The persistent class for the axela_service_contract_asset database table.
 * 
 */

@Entity
@Table(name = "axela_service_contract_asset", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceContractAsset.findAll", query = "SELECT a FROM AxelaServiceContractAsset a")
public class AxelaServiceContractAsset implements Serializable {
	private static final long serialVersionUID = 1L;

	// =========================================INNER JOIN variables=================================
	@Transient
	private int assetBranchId = 0; // From AxelaBranch

	@Transient
	private String assetBranchName = "";// from AxelaBranch

	@Transient
	private int customerId = 0; // AxelaCustomer

	@Transient
	private String customerName = ""; // AxelaCustomer

	@Transient
	private String contractlocName = ""; // AxelaServiceContractLocation

	@Transient
	private String assetBrandname = ""; // AxelaServiceContractAssetBrand

	@Transient
	private String contractassettypeName = "";// AxelaServiceContractAssetType

	@Transient
	private int contactId = 0; // AxelacustomerContact

	@Transient
	private int assettransAssetId = 0;

	// =========================================Entity variables====================================

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "asset_id")
	private int assetId;

	@Column(name = "asset_assetbrand_id")
	private int assetAssetbrandId;

	@Column(name = "asset_contractassettype_id")
	private int assetContractassettypeId;

	@Column(name = "asset_contractloc_id")
	private int assetContractlocId;

	@Column(name = "asset_customer_id")
	private int assetCustomerId;

	@Column(name = "asset_desc")
	private String assetDesc;

	@Column(name = "asset_entry_date")
	private Date assetEntryDate;

	@Column(name = "asset_entry_id")
	private int assetEntryId;

	@Column(name = "asset_modified_date")
	private Date assetModifiedDate;

	@Column(name = "asset_modified_id")
	private int assetModifiedId;

	@Column(name = "asset_name")
	private String assetName;

	@Column(name = "asset_notes")
	private String assetNotes;

	@Column(name = "asset_purchase_date")
	private Date assetPurchaseDate;

	@Column(name = "asset_serial")
	private String assetSerial;

	@Column(name = "asset_tag")
	private String assetTag;

	// =========================================Constructor====================================

	public AxelaServiceContractAsset() {

	}

	public AxelaServiceContractAsset(int assetId, String assetName, String assetSerial, String assetTag,
			int assetCustomerId, int contactId, int assetBranchId, String assetBranchName, int customerId,
			String customerName, String contractassettypeName, String assetBrandname, int assetContractlocId,
			String contractlocName)
	{
		super();
		this.assetId = assetId;
		this.assetName = assetName;
		this.assetSerial = assetSerial;
		this.assetTag = assetTag;
		this.assetCustomerId = assetCustomerId;
		this.contactId = contactId;
		this.assetBranchId = assetBranchId;
		this.assetBranchName = assetBranchName;
		this.customerId = customerId;
		this.customerName = customerName;
		this.contractassettypeName = contractassettypeName;
		this.assetBrandname = assetBrandname;
		this.assetContractlocId = assetContractlocId;
		this.contractlocName = contractlocName;
	}
	// =========================================Entity Relationships====================================

	@OneToMany(mappedBy = "axelaServiceContractAsset")
	private List<AxelaServiceContractAssetTran> axelaServiceContractAssetTran;

	// @OneToMany(mappedBy = "axelaServiceContractAsset")
	// public List<AxelaServiceContract> axelaServiceContract;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "asset_customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
	private AxelaCustomer axelaCustomers;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "asset_contractassettype_id", referencedColumnName = "contractassettype_id", insertable = false, updatable = false)
	private AxelaServiceContractAssetType axelaServiceContractAssetType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "asset_assetbrand_id", referencedColumnName = "assetbrand_id", insertable = false, updatable = false)
	private AxelaServiceContractAssetBrand axelaServiceContractAssetBrand;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "asset_contractloc_id", referencedColumnName = "location_id", insertable = false, updatable = false)
	private AxelaLocation axelaLocation;

	@OneToMany(mappedBy = "axelaServiceContractAsset")
	private List<AxelaServiceContractLocation> axelaServiceContractLocation;

	// @ManyToOne
	// @JoinColumn(name = "asset_contractloc_id", referencedColumnName = "contractloc_id", insertable = false, updatable = false)
	// public AxelaServiceContractLocation axelaServiceContractLocation;

	// =========================================Entity setters and getters==================================== public AxelaCustomer getAxelaCustomer() {
	public AxelaCustomer getAxelaCustomer() {
		return axelaCustomers;
	}

	public void setAxelaCustomer(AxelaCustomer axelaCustomers) {
		this.axelaCustomers = axelaCustomers;
	}

	public List<AxelaServiceContractAssetTran> getAxelaServiceContractAssetTran() {
		return axelaServiceContractAssetTran;
	}

	public void setAxelaServiceContractAssetTran(List<AxelaServiceContractAssetTran> axelaServiceContractAssetTran) {
		this.axelaServiceContractAssetTran = axelaServiceContractAssetTran;
	}
	public AxelaServiceContractAssetType getAxelaServiceContractAssetType() {
		return axelaServiceContractAssetType;
	}

	public void setAxelaServiceContractAssetType(AxelaServiceContractAssetType axelaServiceContractAssetType) {
		this.axelaServiceContractAssetType = axelaServiceContractAssetType;
	}

	public AxelaServiceContractAssetBrand getAxelaServiceContractAssetBrand() {
		return axelaServiceContractAssetBrand;
	}

	public void setAxelaServiceContractAssetBrand(AxelaServiceContractAssetBrand axelaServiceContractAssetBrand) {
		this.axelaServiceContractAssetBrand = axelaServiceContractAssetBrand;
	}

	// public AxelaServiceContractLocation getAxelaServiceContractLocation() {
	// return axelaServiceContractLocation;
	// }
	//
	// public void setAxelaServiceContractLocation(AxelaServiceContractLocation axelaServiceContractLocation) {
	// this.axelaServiceContractLocation = axelaServiceContractLocation;
	// }

	public int getAssetBranchId() {
		return assetBranchId;
	}

	public void setAssetBranchId(int assetBranchId) {
		this.assetBranchId = assetBranchId;
	}

	public String getAssetBranchName() {
		return assetBranchName;
	}

	public void setAssetBranchName(String assetBranchName) {
		this.assetBranchName = assetBranchName;
	}

	public int getcustomerId() {
		return customerId;
	}

	public void setcustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getcustomerName() {
		return customerName;
	}

	public void setcustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContractlocName() {
		return contractlocName;
	}

	public void setContractlocName(String contractlocName) {
		this.contractlocName = contractlocName;
	}

	public String getAssetBrandname() {
		return assetBrandname;
	}

	public void setAssetBrandname(String assetBrandname) {
		this.assetBrandname = assetBrandname;
	}

	public String getContractassettypeName() {
		return contractassettypeName;
	}

	public void setContractassettypeName(String contractassettypeName) {
		this.contractassettypeName = contractassettypeName;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public int getAssetId() {
		return this.assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public int getAssetAssetbrandId() {
		return this.assetAssetbrandId;
	}

	public void setAssetAssetbrandId(int assetAssetbrandId) {
		this.assetAssetbrandId = assetAssetbrandId;
	}

	public int getAssetContractassettypeId() {
		return this.assetContractassettypeId;
	}

	public void setAssetContractassettypeId(int assetContractassettypeId) {
		this.assetContractassettypeId = assetContractassettypeId;
	}

	public int getAssetContractlocId() {
		return this.assetContractlocId;
	}

	public void setAssetContractlocId(int assetContractlocId) {
		this.assetContractlocId = assetContractlocId;
	}

	public int getAssetCustomerId() {
		return this.assetCustomerId;
	}

	public void setAssetCustomerId(int assetCustomerId) {
		this.assetCustomerId = assetCustomerId;
	}

	public String getAssetDesc() {
		return this.assetDesc;
	}

	public void setAssetDesc(String assetDesc) {
		this.assetDesc = assetDesc;
	}

	public Date getAssetEntryDate() {
		return this.assetEntryDate;
	}

	public void setAssetEntryDate(Date assetEntryDate) {
		this.assetEntryDate = assetEntryDate;
	}

	public int getAssetEntryId() {
		return this.assetEntryId;
	}

	public void setAssetEntryId(int assetEntryId) {
		this.assetEntryId = assetEntryId;
	}

	public Date getAssetModifiedDate() {
		return this.assetModifiedDate;
	}

	public void setAssetModifiedDate(Date assetModifiedDate) {
		this.assetModifiedDate = assetModifiedDate;
	}

	public int getAssetModifiedId() {
		return this.assetModifiedId;
	}

	public void setAssetModifiedId(int assetModifiedId) {
		this.assetModifiedId = assetModifiedId;
	}

	public String getAssetName() {
		return this.assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetNotes() {
		return this.assetNotes;
	}

	public void setAssetNotes(String assetNotes) {
		this.assetNotes = assetNotes;
	}

	public Date getAssetPurchaseDate() {
		return this.assetPurchaseDate;
	}

	public void setAssetPurchaseDate(Date assetPurchaseDate) {
		this.assetPurchaseDate = assetPurchaseDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public AxelaCustomer getAxelaCustomers() {
		return axelaCustomers;
	}

	public void setAxelaCustomers(AxelaCustomer axelaCustomers) {
		this.axelaCustomers = axelaCustomers;
	}

	public AxelaLocation getAxelaLocation() {
		return axelaLocation;
	}

	public void setAxelaLocation(AxelaLocation axelaLocation) {
		this.axelaLocation = axelaLocation;
	}

	public List<AxelaServiceContractLocation> getAxelaServiceContractLocation() {
		return axelaServiceContractLocation;
	}

	public void setAxelaServiceContractLocation(List<AxelaServiceContractLocation> axelaServiceContractLocation) {
		this.axelaServiceContractLocation = axelaServiceContractLocation;
	}

	public String getAssetSerial() {
		return this.assetSerial;
	}

	public void setAssetSerial(String assetSerial) {
		this.assetSerial = assetSerial;
	}

	public String getAssetTag() {
		return this.assetTag;
	}

	public void setAssetTag(String assetTag) {
		this.assetTag = assetTag;
	}
	public int getAssettransAssetId() {
		return assettransAssetId;
	}

	public void setAssettransAssetId(int assettransAssetId) {
		this.assettransAssetId = assettransAssetId;
	}

}