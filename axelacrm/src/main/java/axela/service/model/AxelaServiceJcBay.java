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
import javax.persistence.Transient;

/**
 * The persistent class for the axela_service_jc_bay database table.
 * 
 */
@Entity
@Table(name = "axela_service_jc_bay", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceJcBay.findAll", query = "SELECT a FROM AxelaServiceJcBay a")
public class AxelaServiceJcBay implements Serializable {
	private static final long serialVersionUID = 1L;

	// =========================================INNER JOIN variables=================================

	@Transient
	private Date baytransStartTime;

	@Transient
	private Date baytransEndTime;

	@Transient
	private int empId = 0;

	@Transient
	private String empName = "";

	@Transient
	private String empRefNo = "";

	@Transient
	private String branchName = "";

	// =========================================Entity variables=================================

	@Id
	@Column(name = "bay_id")
	private int bayId;

	@Column(name = "bay_active")
	private String bayActive;

	@Column(name = "bay_branch_id")
	private int bayBranchId;

	@Column(name = "bay_entry_date")
	private Date bayEntryDate;

	@Column(name = "bay_entry_id")
	private int bayEntryId;

	@Column(name = "bay_modified_date")
	private Date bayModifiedDate;

	@Column(name = "bay_modified_id")
	private int bayModifiedId;

	@Column(name = "bay_name")
	private String bayName;

	@Column(name = "bay_notes")
	private String bayNotes;

	@Column(name = "bay_open")
	private String bayOpen;

	@Column(name = "bay_rank")
	private int bayRank;

	// ========================================Constructor==============================================
	public AxelaServiceJcBay() {
	}

	public AxelaServiceJcBay(
			int bayId,
			String bayName,
			Date baytransStartTime,
			Date baytransEndTime,
			int empId,
			String empName) {
		super();
		this.bayId = bayId;
		this.bayName = bayName;
		this.baytransStartTime = baytransStartTime;
		this.baytransEndTime = baytransEndTime;
		this.empId = empId;
		this.empName = empName;

	}

	// =========================================Entity Relationships====================================

	@OneToMany(mappedBy = "axelaServiceJcBay")
	private List<AxelaServiceJcBayTran> axelaServiceJcBayTran;

	public List<AxelaServiceJcBayTran> getAxelaServiceJcBayTran() {
		return axelaServiceJcBayTran;
	}

	public void setAxelaServiceJcBayTran(List<AxelaServiceJcBayTran> axelaServiceJcBayTran) {
		this.axelaServiceJcBayTran = axelaServiceJcBayTran;
	}

	public int getBayId() {
		return this.bayId;
	}

	public void setBayId(int bayId) {
		this.bayId = bayId;
	}

	public String getBayActive() {
		return this.bayActive;
	}

	public void setBayActive(String bayActive) {
		this.bayActive = bayActive;
	}

	public int getBayBranchId() {
		return this.bayBranchId;
	}

	public void setBayBranchId(int bayBranchId) {
		this.bayBranchId = bayBranchId;
	}

	public String getEmpRefNo() {
		return empRefNo;
	}

	public void setEmpRefNo(String empRefNo) {
		this.empRefNo = empRefNo;
	}

	public Date getBayEntryDate() {
		return this.bayEntryDate;
	}

	public void setBayEntryDate(Date bayEntryDate) {
		this.bayEntryDate = bayEntryDate;
	}

	public int getBayEntryId() {
		return this.bayEntryId;
	}

	public void setBayEntryId(int bayEntryId) {
		this.bayEntryId = bayEntryId;
	}

	public Date getBayModifiedDate() {
		return this.bayModifiedDate;
	}

	public void setBayModifiedDate(Date bayModifiedDate) {
		this.bayModifiedDate = bayModifiedDate;
	}

	public Date getBaytransStartTime() {
		return baytransStartTime;
	}

	public void setBaytransStartTime(Date baytransStartTime) {
		this.baytransStartTime = baytransStartTime;
	}

	public Date getBaytransEndTime() {
		return baytransEndTime;
	}

	public void setBaytransEndTime(Date baytransEndTime) {
		this.baytransEndTime = baytransEndTime;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getBayModifiedId() {
		return this.bayModifiedId;
	}

	public void setBayModifiedId(int bayModifiedId) {
		this.bayModifiedId = bayModifiedId;
	}

	public String getBayName() {
		return this.bayName;
	}

	public void setBayName(String bayName) {
		this.bayName = bayName;
	}

	public String getBayNotes() {
		return this.bayNotes;
	}

	public void setBayNotes(String bayNotes) {
		this.bayNotes = bayNotes;
	}

	public String getBayOpen() {
		return this.bayOpen;
	}

	public void setBayOpen(String bayOpen) {
		this.bayOpen = bayOpen;
	}

	public int getBayRank() {
		return this.bayRank;
	}

	public void setBayRank(int bayRank) {
		this.bayRank = bayRank;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public AxelaServiceJcBay(int bayId, int bayBranchId, String bayName, int bayRank) {
		super();
		this.bayId = bayId;
		this.bayBranchId = bayBranchId;
		this.bayName = bayName;
		this.bayRank = bayRank;
	}

}