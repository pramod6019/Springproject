package axela.portal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the axela_franchisee_type database table.
 * 
 */
@Entity
@Table(name = "axela_franchisee_type", catalog = "axela_1")
@NamedQuery(name = "AxelaFranchiseeType.findAll", query = "SELECT a FROM AxelaFranchiseeType a")
public class AxelaFranchiseeType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "franchiseetype_id")
	private int franchiseetypeId;

	@Column(name = "franchiseetype_entry_date")
	private String franchiseetypeEntryDate;

	@Column(name = "franchiseetype_entry_id")
	private int franchiseetypeEntryId;

	@Column(name = "franchiseetype_modified_date")
	private String franchiseetypeModifiedDate;

	@Column(name = "franchiseetype_modified_id")
	private int franchiseetypeModifiedId;

	@Column(name = "franchiseetype_name")
	private String franchiseetypeName;

	@OneToMany(mappedBy = "axelaFranchiseeType", cascade = CascadeType.ALL)
	private List<AxelaFranchisee> axelaFranchisee;

	public AxelaFranchiseeType() {
	}

	public int getFranchiseetypeId() {
		return this.franchiseetypeId;
	}

	public void setFranchiseetypeId(int franchiseetypeId) {
		this.franchiseetypeId = franchiseetypeId;
	}

	public String getFranchiseetypeEntryDate() {
		return this.franchiseetypeEntryDate;
	}

	public void setFranchiseetypeEntryDate(String franchiseetypeEntryDate) {
		this.franchiseetypeEntryDate = franchiseetypeEntryDate;
	}

	public int getFranchiseetypeEntryId() {
		return this.franchiseetypeEntryId;
	}

	public void setFranchiseetypeEntryId(int franchiseetypeEntryId) {
		this.franchiseetypeEntryId = franchiseetypeEntryId;
	}

	public String getFranchiseetypeModifiedDate() {
		return this.franchiseetypeModifiedDate;
	}

	public void setFranchiseetypeModifiedDate(String franchiseetypeModifiedDate) {
		this.franchiseetypeModifiedDate = franchiseetypeModifiedDate;
	}

	public List<AxelaFranchisee> getAxelaFranchisee() {
		return axelaFranchisee;
	}

	public void setAxelaFranchisee(List<AxelaFranchisee> axelaFranchisee) {
		this.axelaFranchisee = axelaFranchisee;
	}

	public int getFranchiseetypeModifiedId() {
		return this.franchiseetypeModifiedId;
	}

	public void setFranchiseetypeModifiedId(int franchiseetypeModifiedId) {
		this.franchiseetypeModifiedId = franchiseetypeModifiedId;
	}

	public String getFranchiseetypeName() {
		return this.franchiseetypeName;
	}

	public void setFranchiseetypeName(String franchiseetypeName) {
		this.franchiseetypeName = franchiseetypeName;
	}

}