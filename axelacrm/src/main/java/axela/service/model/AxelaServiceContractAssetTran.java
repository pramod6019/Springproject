package axela.service.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_service_contract_asset_trans database table.
 * 
 */
@Entity
@Table(name = "axela_service_contract_asset_trans", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceContractAssetTran.findAll", query = "SELECT a FROM AxelaServiceContractAssetTran a")
public class AxelaServiceContractAssetTran implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "assettrans_id")
	private int assettransId;

	@Column(name = "assettrans_asset_id")
	private int assettransAssetId;

	@Column(name = "assettrans_contract_id")
	private int assettransContractId;

	@Column(name = "assettrans_modified_date")
	private String assettransModifiedDate;

	@Column(name = "assettrans_modified_id")
	private int assettransModifiedId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assettrans_asset_id", referencedColumnName = "asset_id", insertable = false, updatable = false)
	private AxelaServiceContractAsset axelaServiceContractAsset;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assettrans_contract_id", referencedColumnName = "contract_id", insertable = false, updatable = false)
	private AxelaServiceContract axelaServiceContract;

	public AxelaServiceContractAsset getAxelaServiceContractAsset() {
		return axelaServiceContractAsset;
	}

	public void setAxelaServiceContractAsset(AxelaServiceContractAsset axelaServiceContractAsset) {
		this.axelaServiceContractAsset = axelaServiceContractAsset;
	}

	public AxelaServiceContractAssetTran() {
	}

	public int getAssettransId() {
		return this.assettransId;
	}

	public void setAssettransId(int assettransId) {
		this.assettransId = assettransId;
	}

	public int getAssettransAssetId() {
		return this.assettransAssetId;
	}

	public void setAssettransAssetId(int assettransAssetId) {
		this.assettransAssetId = assettransAssetId;
	}

	public int getAssettransContractId() {
		return this.assettransContractId;
	}

	public void setAssettransContractId(int assettransContractId) {
		this.assettransContractId = assettransContractId;
	}

	public String getAssettransModifiedDate() {
		return this.assettransModifiedDate;
	}

	public void setAssettransModifiedDate(String assettransModifiedDate) {
		this.assettransModifiedDate = assettransModifiedDate;
	}

	public int getAssettransModifiedId() {
		return this.assettransModifiedId;
	}

	public void setAssettransModifiedId(int assettransModifiedId) {
		this.assettransModifiedId = assettransModifiedId;
	}
}