package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_jobtitle database table.
 * 
 */
@Entity
@Table(name = "axela_jobtitle", catalog = "axela_1")
@NamedQuery(name = "AxelaJobtitle.findAll", query = "SELECT a FROM AxelaJobtitle a")
public class AxelaJobtitle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "jobtitle_id")
	private String jobtitleId;

	@Column(name = "jobtitle_desc")
	private String jobtitleDesc;

	@Column(name = "jobtitle_entry_date")
	private String jobtitleEntryDate;

	@Column(name = "jobtitle_entry_id")
	private int jobtitleEntryId;

	@Column(name = "jobtitle_modified_date")
	private String jobtitleModifiedDate;

	@Column(name = "jobtitle_modified_id")
	private int jobtitleModifiedId;

	// bi-directional many-to-many association to AxelaEmpBranch
	// @ManyToMany
	// @JoinColumn(name="jobtitle_id", referencedColumnName="emp_branch_id")
	// private List<AxelaEmpBranch> axelaEmpBranches;

	public AxelaJobtitle() {
	}

	public String getJobtitleId() {
		return this.jobtitleId;
	}

	public void setJobtitleId(String jobtitleId) {
		this.jobtitleId = jobtitleId;
	}

	public String getJobtitleDesc() {
		return this.jobtitleDesc;
	}

	public void setJobtitleDesc(String jobtitleDesc) {
		this.jobtitleDesc = jobtitleDesc;
	}

	public String getJobtitleEntryDate() {
		return this.jobtitleEntryDate;
	}

	public void setJobtitleEntryDate(String jobtitleEntryDate) {
		this.jobtitleEntryDate = jobtitleEntryDate;
	}

	public int getJobtitleEntryId() {
		return this.jobtitleEntryId;
	}

	public void setJobtitleEntryId(int jobtitleEntryId) {
		this.jobtitleEntryId = jobtitleEntryId;
	}

	public String getJobtitleModifiedDate() {
		return this.jobtitleModifiedDate;
	}

	public void setJobtitleModifiedDate(String jobtitleModifiedDate) {
		this.jobtitleModifiedDate = jobtitleModifiedDate;
	}

	public int getJobtitleModifiedId() {
		return this.jobtitleModifiedId;
	}

	public void setJobtitleModifiedId(int jobtitleModifiedId) {
		this.jobtitleModifiedId = jobtitleModifiedId;
	}

	// public List<AxelaEmpBranch> getAxelaEmpBranches() {
	// return this.axelaEmpBranches;
	// }
	//
	// public void setAxelaEmpBranches(List<AxelaEmpBranch> axelaEmpBranches) {
	// this.axelaEmpBranches = axelaEmpBranches;
	// }

}