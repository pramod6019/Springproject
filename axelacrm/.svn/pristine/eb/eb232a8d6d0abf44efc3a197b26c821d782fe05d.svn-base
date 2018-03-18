package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_pm_type database table.
 * 
 */
@Entity
@Table(name = "axela_pm_type", catalog = "axela_1")
@NamedQuery(name = "AxelaPmType.findAll", query = "SELECT a FROM AxelaPmType a")
public class AxelaPmType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pmtype_id", nullable = false)
	private int pmtypeId;

	@Column(name = "pmtype_entry_date")
	private String pmtypeEntryDate;

	@Column(name = "pmtype_entry_id")
	private int pmtypeEntryId;

	@Column(name = "pmtype_modified_date")
	private String pmtypeModifiedDate;

	@Column(name = "pmtype_modified_id")
	private int pmtypeModifiedId;

	@Column(name = "pmtype_name")
	private String pmtypeName;

	public int getPmtypeId() {
		return this.pmtypeId;
	}

	public void setPmtypeId(int pmtypeId) {
		this.pmtypeId = pmtypeId;
	}

	public String getPmtypeEntryDate() {
		return this.pmtypeEntryDate;
	}

	public void setPmtypeEntryDate(String pmtypeEntryDate) {
		this.pmtypeEntryDate = pmtypeEntryDate;
	}

	public int getPmtypeEntryId() {
		return this.pmtypeEntryId;
	}

	public void setPmtypeEntryId(int pmtypeEntryId) {
		this.pmtypeEntryId = pmtypeEntryId;
	}

	public String getPmtypeModifiedDate() {
		return this.pmtypeModifiedDate;
	}

	public void setPmtypeModifiedDate(String pmtypeModifiedDate) {
		this.pmtypeModifiedDate = pmtypeModifiedDate;
	}

	public int getPmtypeModifiedId() {
		return this.pmtypeModifiedId;
	}

	public void setPmtypeModifiedId(int pmtypeModifiedId) {
		this.pmtypeModifiedId = pmtypeModifiedId;
	}

	public String getPmtypeName() {
		return this.pmtypeName;
	}

	public void setPmtypeName(String pmtypeName) {
		this.pmtypeName = pmtypeName;
	}

}