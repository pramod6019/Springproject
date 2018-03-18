package axela.portal.model;

import java.io.Serializable;
import java.util.Date;
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
 * The persistent class for the axela_branch_type database table.
 * 
 */
@Entity
@Table(name = "axela_branch_type", catalog = "axela_1")
@NamedQuery(name = "AxelaBranchType.findAll", query = "SELECT a FROM AxelaBranchType a")
public class AxelaBranchType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "branchtype_id")
	private int branchtypeId;

	@Column(name = "branchtype_entry_date")
	private Date branchtypeEntryDate;

	@Column(name = "branchtype_entry_id")
	private int branchtypeEntryId;

	@Column(name = "branchtype_modified_date")
	private Date branchtypeModifiedDate;

	@Column(name = "branchtype_modified_id")
	private int branchtypeModifiedId;

	@Column(name = "branchtype_name")
	private String branchtypeName;

	@OneToMany(mappedBy = "axelaBranchType")
	private List<AxelaBranch> axelaBranch;

	public AxelaBranchType() {
	}

	public int getBranchtypeId() {
		return this.branchtypeId;
	}

	public void setBranchtypeId(int branchtypeId) {
		this.branchtypeId = branchtypeId;
	}

	public List<AxelaBranch> getAxelaBranch() {
		return axelaBranch;
	}

	public void setAxelaBranch(List<AxelaBranch> axelaBranch) {
		this.axelaBranch = axelaBranch;
	}

	public Date getBranchtypeEntryDate() {
		return this.branchtypeEntryDate;
	}

	public void setBranchtypeEntryDate(Date branchtypeEntryDate) {
		this.branchtypeEntryDate = branchtypeEntryDate;
	}

	public int getBranchtypeEntryId() {
		return this.branchtypeEntryId;
	}

	public void setBranchtypeEntryId(int branchtypeEntryId) {
		this.branchtypeEntryId = branchtypeEntryId;
	}

	public Date getBranchtypeModifiedDate() {
		return this.branchtypeModifiedDate;
	}

	public void setBranchtypeModifiedDate(Date branchtypeModifiedDate) {
		this.branchtypeModifiedDate = branchtypeModifiedDate;
	}

	public int getBranchtypeModifiedId() {
		return this.branchtypeModifiedId;
	}

	public void setBranchtypeModifiedId(int branchtypeModifiedId) {
		this.branchtypeModifiedId = branchtypeModifiedId;
	}

	public String getBranchtypeName() {
		return this.branchtypeName;
	}

	public void setBranchtypeName(String branchtypeName) {
		this.branchtypeName = branchtypeName;
	}

}