package axela.service.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the axela_service_contract_asset_brand database table.
 * 
 */
@Entity
@Table(name = "axela_service_contract_asset_brand", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceContractAssetBrand.findAll", query = "SELECT a FROM AxelaServiceContractAssetBrand a")
public class AxelaServiceContractAssetBrand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "assetbrand_id")
	private int assetbrandId;

	@Column(name = "assetbrand_entry_date")
	private Date assetbrandEntryDate;

	@Column(name = "assetbrand_entry_id")
	private int assetbrandEntryId;

	@Column(name = "assetbrand_modified_date")
	private Date assetbrandModifiedDate;

	@Column(name = "assetbrand_modified_id")
	private int assetbrandModifiedId;

	@Column(name = "assetbrand_name")
	private String assetbrandName;

	public AxelaServiceContractAssetBrand() {
	}

	public AxelaServiceContractAssetBrand(
			int assetbrandId,
			String assetbrandName,
			int assetbrandEntryId,
			Date assetbrandEntryDate,
			int assetbrandModifiedId,
			Date assetbrandModifiedDate) {

		this.assetbrandId = assetbrandId;
		this.assetbrandName = assetbrandName;
		this.assetbrandEntryId = assetbrandEntryId;
		this.assetbrandEntryDate = assetbrandEntryDate;
		this.assetbrandModifiedId = assetbrandModifiedId;
		this.assetbrandModifiedDate = assetbrandModifiedDate;
	}

	public int getAssetbrandId() {
		return this.assetbrandId;
	}

	public void setAssetbrandId(int assetbrandId) {
		this.assetbrandId = assetbrandId;
	}

	public Date getAssetbrandEntryDate() {
		return this.assetbrandEntryDate;
	}

	public void setAssetbrandEntryDate(Date assetbrandEntryDate) {
		this.assetbrandEntryDate = assetbrandEntryDate;
	}

	public int getAssetbrandEntryId() {
		return this.assetbrandEntryId;
	}

	public void setAssetbrandEntryId(int assetbrandEntryId) {
		this.assetbrandEntryId = assetbrandEntryId;
	}

	public Date getAssetbrandModifiedDate() {
		return this.assetbrandModifiedDate;
	}

	public void setAssetbrandModifiedDate(Date assetbrandModifiedDate) {
		this.assetbrandModifiedDate = assetbrandModifiedDate;
	}

	public int getAssetbrandModifiedId() {
		return this.assetbrandModifiedId;
	}

	public void setAssetbrandModifiedId(int assetbrandModifiedId) {
		this.assetbrandModifiedId = assetbrandModifiedId;
	}

	public String getAssetbrandName() {
		return this.assetbrandName;
	}

	public void setAssetbrandName(String assetbrandName) {
		this.assetbrandName = assetbrandName;
	}
	@OneToMany(mappedBy = "axelaServiceContractAssetBrand")
	private List<AxelaServiceContractAsset> AxelaServiceContractAsset;

	public List<AxelaServiceContractAsset> getAxelaServiceContractAsset() {
		return AxelaServiceContractAsset;
	}

	public void setAxelaServiceContractAsset(List<AxelaServiceContractAsset> axelaServiceContractAsset) {
		AxelaServiceContractAsset = axelaServiceContractAsset;
	}
}