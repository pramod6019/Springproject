package axela.portal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the axela_sales_crm_type database table.
 * 
 */
@Entity
@Table(name = "axela_sales_crm_type", catalog = "axela")
@NamedQuery(name = "AxelaSalesCrmType.findAll", query = "SELECT a FROM AxelaSalesCrmType a")
public class AxelaSalesCrmType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "crmtype_id")
	private int crmtypeId;

	@Column(name = "crmtype_entry_date")
	private String crmtypeEntryDate;

	@Column(name = "crmtype_entry_id")
	private int crmtypeEntryId;

	@Column(name = "crmtype_modified_date")
	private String crmtypeModifiedDate;

	@Column(name = "crmtype_modified_id")
	private int crmtypeModifiedId;

	@Column(name = "crmtype_name")
	private String crmtypeName;

	@OneToMany(mappedBy = "axelaSalesCrmType")
	List<AxelaSalesCrmday> axelaSalesCrmday;

	public List<AxelaSalesCrmday> getAxelaSalesCrmday() {
		return axelaSalesCrmday;
	}

	public void setAxelaSalesCrmday(List<AxelaSalesCrmday> axelaSalesCrmday) {
		this.axelaSalesCrmday = axelaSalesCrmday;
	}

	public AxelaSalesCrmType() {
	}

	public int getCrmtypeId() {
		return this.crmtypeId;
	}

	public void setCrmtypeId(int crmtypeId) {
		this.crmtypeId = crmtypeId;
	}

	public String getCrmtypeEntryDate() {
		return this.crmtypeEntryDate;
	}

	public void setCrmtypeEntryDate(String crmtypeEntryDate) {
		this.crmtypeEntryDate = crmtypeEntryDate;
	}

	public int getCrmtypeEntryId() {
		return this.crmtypeEntryId;
	}

	public void setCrmtypeEntryId(int crmtypeEntryId) {
		this.crmtypeEntryId = crmtypeEntryId;
	}

	public String getCrmtypeModifiedDate() {
		return this.crmtypeModifiedDate;
	}

	public void setCrmtypeModifiedDate(String crmtypeModifiedDate) {
		this.crmtypeModifiedDate = crmtypeModifiedDate;
	}

	public int getCrmtypeModifiedId() {
		return this.crmtypeModifiedId;
	}

	public void setCrmtypeModifiedId(int crmtypeModifiedId) {
		this.crmtypeModifiedId = crmtypeModifiedId;
	}

	public String getCrmtypeName() {
		return this.crmtypeName;
	}

	public void setCrmtypeName(String crmtypeName) {
		this.crmtypeName = crmtypeName;
	}

}