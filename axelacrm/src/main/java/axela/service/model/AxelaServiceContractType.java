package axela.service.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the axela_service_contract_type database table.
 * 
 */
@Entity
@Table(name = "axela_service_contract_type", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceContractType.findAll", query = "SELECT a FROM AxelaServiceContractType a")
public class AxelaServiceContractType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "contracttype_id")
	private int contracttypeId;

	@Column(name = "contracttype_entry_date")
	private Date contracttypeEntryDate;

	@Column(name = "contracttype_entry_id")
	private int contracttypeEntryId;

	@Column(name = "contracttype_modified_date")
	private Date contracttypeModifiedDate;

	@Column(name = "contracttype_modified_id")
	private int contracttypeModifiedId;

	@Column(name = "contracttype_name")
	private String contracttypeName;

	public AxelaServiceContractType() {
	}

	public AxelaServiceContractType(
			int contracttypeId,
			String contracttypeName,
			int contracttypeEntryId,
			Date contracttypeEntryDate,
			int contracttypeModifiedId,
			Date contracttypeModifiedDate) {
		super();
		this.contracttypeId = contracttypeId;
		this.contracttypeEntryDate = contracttypeEntryDate;
		this.contracttypeEntryId = contracttypeEntryId;
		this.contracttypeModifiedDate = contracttypeModifiedDate;
		this.contracttypeModifiedId = contracttypeModifiedId;
		this.contracttypeName = contracttypeName;
	}

	@OneToMany(mappedBy = "axelaServiceContractType", cascade = CascadeType.ALL)
	private List<AxelaServiceContract> axelaServiceContract;

	public List<AxelaServiceContract> getAxelaServiceContract() {
		return axelaServiceContract;
	}

	public void setAxelaServiceContract(List<AxelaServiceContract> axelaServiceContract) {
		this.axelaServiceContract = axelaServiceContract;
	}

	public int getContracttypeId() {
		return this.contracttypeId;
	}

	public void setContracttypeId(int contracttypeId) {
		this.contracttypeId = contracttypeId;
	}

	public Date getContracttypeEntryDate() {
		return this.contracttypeEntryDate;
	}

	public void setContracttypeEntryDate(Date contracttypeEntryDate) {
		this.contracttypeEntryDate = contracttypeEntryDate;
	}

	public int getContracttypeEntryId() {
		return this.contracttypeEntryId;
	}

	public void setContracttypeEntryId(int contracttypeEntryId) {
		this.contracttypeEntryId = contracttypeEntryId;
	}

	public Date getContracttypeModifiedDate() {
		return this.contracttypeModifiedDate;
	}

	public void setContracttypeModifiedDate(Date contracttypeModifiedDate) {
		this.contracttypeModifiedDate = contracttypeModifiedDate;
	}

	public int getContracttypeModifiedId() {
		return this.contracttypeModifiedId;
	}

	public void setContracttypeModifiedId(int contracttypeModifiedId) {
		this.contracttypeModifiedId = contracttypeModifiedId;
	}

	public String getContracttypeName() {
		return this.contracttypeName;
	}

	public void setContracttypeName(String contracttypeName) {
		this.contracttypeName = contracttypeName;
	}

}