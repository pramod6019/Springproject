package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the axela_acc_group database table.
 * 
 */
@Entity
@Table(name = "axela_acc_group", catalog = "axela_1")
@NamedQuery(name = "AxelaAccGroup.findAll", query = "SELECT a FROM AxelaAccGroup a")
public class AxelaAccGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "accgroup_id")
	private int accgroupId;

	@Column(name = "accgroup_affects_gross")
	private int accgroupAffectsGross;

	@Column(name = "accgroup_alie")
	private int accgroupAlie;

	@Column(name = "accgroup_entry_date")
	private String accgroupEntryDate;

	@Column(name = "accgroup_entry_id")
	private int accgroupEntryId;

	@Column(name = "accgroup_modified_date")
	private String accgroupModifiedDate;

	@Column(name = "accgroup_modified_id")
	private int accgroupModifiedId;

	@Column(name = "accgroup_name")
	private String accgroupName;

	@Column(name = "accgroup_notes")
	private String accgroupNotes;

	@Column(name = "accgroup_parent_id")
	private int accgroupParentId;

	// bi-directional one-to-one association to AxelaAccGroupPop
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "axelaAccGroup")
	private AxelaAccGroupPop axelaAccGroupPop;

	public AxelaAccGroup() {
	}

	public int getAccgroupId() {
		return this.accgroupId;
	}

	public void setAccgroupId(int accgroupId) {
		this.accgroupId = accgroupId;
	}

	public int getAccgroupAffectsGross() {
		return this.accgroupAffectsGross;
	}

	public void setAccgroupAffectsGross(int accgroupAffectsGross) {
		this.accgroupAffectsGross = accgroupAffectsGross;
	}

	public int getAccgroupAlie() {
		return this.accgroupAlie;
	}

	public void setAccgroupAlie(int accgroupAlie) {
		this.accgroupAlie = accgroupAlie;
	}

	public String getAccgroupEntryDate() {
		return this.accgroupEntryDate;
	}

	public void setAccgroupEntryDate(String accgroupEntryDate) {
		this.accgroupEntryDate = accgroupEntryDate;
	}

	public int getAccgroupEntryId() {
		return this.accgroupEntryId;
	}

	public void setAccgroupEntryId(int accgroupEntryId) {
		this.accgroupEntryId = accgroupEntryId;
	}

	public String getAccgroupModifiedDate() {
		return this.accgroupModifiedDate;
	}

	public void setAccgroupModifiedDate(String accgroupModifiedDate) {
		this.accgroupModifiedDate = accgroupModifiedDate;
	}

	public int getAccgroupModifiedId() {
		return this.accgroupModifiedId;
	}

	public void setAccgroupModifiedId(int accgroupModifiedId) {
		this.accgroupModifiedId = accgroupModifiedId;
	}

	public String getAccgroupName() {
		return this.accgroupName;
	}

	public void setAccgroupName(String accgroupName) {
		this.accgroupName = accgroupName;
	}

	public String getAccgroupNotes() {
		return this.accgroupNotes;
	}

	public void setAccgroupNotes(String accgroupNotes) {
		this.accgroupNotes = accgroupNotes;
	}

	public int getAccgroupParentId() {
		return this.accgroupParentId;
	}

	public void setAccgroupParentId(int accgroupParentId) {
		this.accgroupParentId = accgroupParentId;
	}

	public AxelaAccGroupPop getAxelaAccGroupPop() {
		return this.axelaAccGroupPop;
	}

	public void setAxelaAccGroupPop(AxelaAccGroupPop axelaAccGroupPop) {
		this.axelaAccGroupPop = axelaAccGroupPop;
	}

}