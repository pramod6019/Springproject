package axela.service.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_service_contract_service_type database table.
 * 
 */
@Entity
@Table(name = "axela_service_contract_service_type", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceContractServiceType.findAll", query = "SELECT a FROM AxelaServiceContractServiceType a")
public class AxelaServiceContractServiceType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "servicetype_id")
	private int servicetypeId;

	@Column(name = "servicetype_entry_date")
	private Date servicetypeEntryDate;

	@Column(name = "servicetype_entry_id")
	private int servicetypeEntryId;

	@Column(name = "servicetype_modified_date")
	private Date servicetypeModifiedDate;

	@Column(name = "servicetype_modified_id")
	private int servicetypeModifiedId;

	@Column(name = "servicetype_name")
	private String servicetypeName;

	public AxelaServiceContractServiceType() {
	}

	public AxelaServiceContractServiceType(
			int servicetypeId,
			Date servicetypeEntryDate,
			int servicetypeEntryId,
			Date servicetypeModifiedDate,
			int servicetypeModifiedId,
			String servicetypeName) {
		super();
		this.servicetypeId = servicetypeId;
		this.servicetypeEntryDate = servicetypeEntryDate;
		this.servicetypeEntryId = servicetypeEntryId;
		this.servicetypeModifiedDate = servicetypeModifiedDate;
		this.servicetypeModifiedId = servicetypeModifiedId;
		this.servicetypeName = servicetypeName;
	}

	public int getServicetypeId() {
		return this.servicetypeId;
	}

	public void setServicetypeId(int servicetypeId) {
		this.servicetypeId = servicetypeId;
	}

	public Date getServicetypeEntryDate() {
		return this.servicetypeEntryDate;
	}

	public void setServicetypeEntryDate(Date servicetypeEntryDate) {
		this.servicetypeEntryDate = servicetypeEntryDate;
	}

	public int getServicetypeEntryId() {
		return this.servicetypeEntryId;
	}

	public void setServicetypeEntryId(int servicetypeEntryId) {
		this.servicetypeEntryId = servicetypeEntryId;
	}

	public Date getServicetypeModifiedDate() {
		return this.servicetypeModifiedDate;
	}

	public void setServicetypeModifiedDate(Date servicetypeModifiedDate) {
		this.servicetypeModifiedDate = servicetypeModifiedDate;
	}

	public int getServicetypeModifiedId() {
		return this.servicetypeModifiedId;
	}

	public void setServicetypeModifiedId(int servicetypeModifiedId) {
		this.servicetypeModifiedId = servicetypeModifiedId;
	}

	public String getServicetypeName() {
		return this.servicetypeName;
	}

	public void setServicetypeName(String servicetypeName) {
		this.servicetypeName = servicetypeName;
	}

}