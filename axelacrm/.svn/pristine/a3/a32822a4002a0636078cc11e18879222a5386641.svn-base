package axela.portal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import axela.sales.model.AxelaSalesOppr;
import axela.sales.model.AxelaSalesTeam;

/**
 * The persistent class for the axela_soe database table.
 * 
 */
@Entity
@Table(name = "axela_soe", catalog = "axela_1")
@NamedQuery(name = "AxelaSoe.findAll", query = "SELECT a FROM AxelaSoe a")
public class AxelaSoe implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "soe_id", nullable = false)
	private int soeId;

	@Column(name = "soe_entry_date")
	private Date soeEntryDate;

	@Column(name = "soe_entry_id")
	private int soeEntryId;

	@Column(name = "soe_modified_date")
	private Date soeModifiedDate;

	@Column(name = "soe_modified_id")
	private int soeModifiedId;

	@Column(name = "soe_name")
	private String soeName;

	public AxelaSoe() {
	}

	public int getSoeId() {
		return this.soeId;
	}

	public void setSoeId(int soeId) {
		this.soeId = soeId;
	}

	public Date getSoeEntryDate() {
		return this.soeEntryDate;
	}

	public void setSoeEntryDate(Date soeEntryDate) {
		this.soeEntryDate = soeEntryDate;
	}

	public int getSoeEntryId() {
		return this.soeEntryId;
	}

	public void setSoeEntryId(int soeEntryId) {
		this.soeEntryId = soeEntryId;
	}

	public Date getSoeModifiedDate() {
		return this.soeModifiedDate;
	}

	public void setSoeModifiedDate(Date soeModifiedDate) {
		this.soeModifiedDate = soeModifiedDate;
	}

	public int getSoeModifiedId() {
		return this.soeModifiedId;
	}

	public void setSoeModifiedId(int soeModifiedId) {
		this.soeModifiedId = soeModifiedId;
	}

	public String getSoeName() {
		return this.soeName;
	}

	@Transient
	Long Total;

	public AxelaSoe(
			int soeId,
			String soeName,
			Long Total) {
		this.soeId = soeId;
		this.soeName = soeName;
		this.Total = Total;
	}
	@Transient
	public AxelaSalesTeam axelaSalesTeam;

	public Long getTotal() {
		return Total;
	}

	public void setTotal(Long total) {
		Total = total;
	}

	public AxelaSalesTeam getAxelaSalesTeam() {
		return axelaSalesTeam;
	}

	public void setAxelaSalesTeam(AxelaSalesTeam axelaSalesTeam) {
		this.axelaSalesTeam = axelaSalesTeam;
	}

	@OneToMany
	@JoinColumn(name = "oppr_soe_id", referencedColumnName = "soe_id", insertable = false, updatable = false)
	private List<AxelaSalesOppr> axelaSalesOppr;

	public void setSoeName(String soeName) {
		this.soeName = soeName;
	}
	public AxelaSoe(
			int soeId,
			String soeName) {
		super();
		this.soeId = soeId;
		this.soeName = soeName;
	}
}