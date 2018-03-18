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
 * The persistent class for the axela_service_contract_asset_type database table.
 * 
 */
@Entity
@Table(name = "axela_service_contract_asset_type", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceContractAssetType.findAll", query = "SELECT a FROM AxelaServiceContractAssetType a")
public class AxelaServiceContractAssetType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "contractassettype_id")
	private int contractassettypeId;

	@Column(name = "contractassettype_entry_date")
	private Date contractassettypeEntryDate;

	@Column(name = "contractassettype_entry_id")
	private int contractassettypeEntryId;

	@Column(name = "contractassettype_modified_date")
	private Date contractassettypeModifiedDate;

	@Column(name = "contractassettype_modified_id")
	private int contractassettypeModifiedId;

	@Column(name = "contractassettype_name")
	private String contractassettypeName;

	@OneToMany(mappedBy = "axelaServiceContractAssetType")
	private List<AxelaServiceContractAsset> axelaServiceContractAsset;

	public AxelaServiceContractAssetType() {
	}
	public AxelaServiceContractAssetType(
			int contractassettypeId,
			String contractassettypeName,
			int contractassettypeEntryId,
			Date contractassettypeEntryDate,
			int contractassettypeModifiedId,
			Date contractassettypeModifiedDate)
	{
		this.contractassettypeId = contractassettypeId;
		this.contractassettypeName = contractassettypeName;
		this.contractassettypeEntryId = contractassettypeEntryId;
		this.contractassettypeEntryDate = contractassettypeEntryDate;
		this.contractassettypeModifiedId = contractassettypeModifiedId;
		this.contractassettypeModifiedDate = contractassettypeModifiedDate;
	}

	public int getContractassettypeId() {
		return this.contractassettypeId;
	}

	public void setContractassettypeId(int contractassettypeId) {
		this.contractassettypeId = contractassettypeId;
	}

	public Date getContractassettypeEntryDate() {
		return this.contractassettypeEntryDate;
	}

	public void setContractassettypeEntryDate(Date contractassettypeEntryDate) {
		this.contractassettypeEntryDate = contractassettypeEntryDate;
	}

	public int getContractassettypeEntryId() {
		return this.contractassettypeEntryId;
	}

	public void setContractassettypeEntryId(int contractassettypeEntryId) {
		this.contractassettypeEntryId = contractassettypeEntryId;
	}

	public Date getContractassettypeModifiedDate() {
		return this.contractassettypeModifiedDate;
	}

	public void setContractassettypeModifiedDate(Date contractassettypeModifiedDate) {
		this.contractassettypeModifiedDate = contractassettypeModifiedDate;
	}

	public int getContractassettypeModifiedId() {
		return this.contractassettypeModifiedId;
	}

	public void setContractassettypeModifiedId(int contractassettypeModifiedId) {
		this.contractassettypeModifiedId = contractassettypeModifiedId;
	}

	public String getContractassettypeName() {
		return this.contractassettypeName;
	}

	public void setContractassettypeName(String contractassettypeName) {
		this.contractassettypeName = contractassettypeName;
	}

	public List<AxelaServiceContractAsset> getAxelaServiceContractAsset() {
		return axelaServiceContractAsset;
	}

	public void setAxelaServiceContractAsset(List<AxelaServiceContractAsset> axelaServiceContractAsset) {
		this.axelaServiceContractAsset = axelaServiceContractAsset;
	}

}