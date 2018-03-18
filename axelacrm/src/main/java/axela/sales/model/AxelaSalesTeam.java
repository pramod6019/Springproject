package axela.sales.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import axela.portal.model.AxelaEmp;

/**
 * The persistent class for the axela_sales_team database table.
 * 
 */
@Entity
@Table(name = "axela_sales_team", catalog = "axela_1")
@NamedQuery(name = "AxelaSalesTeam.findAll", query = "SELECT a FROM AxelaSalesTeam a")
public class AxelaSalesTeam implements Serializable {

	private static final long serialVersionUID = 1L;
	// =================left table ===================
	@Transient
	private int empId = 0;
	@Transient
	private String empName = "";
	@Transient
	private String empRefNo = "0";
	@Transient
	private Long empCount = 0L;

	// =========================entity varriable========
	@Id
	@Column(name = "team_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int teamId;

	@Column(name = "team_branch_id")
	private int teamBranchId;

	@Column(name = "team_crm_emp_id")
	private int teamCrmEmpId;

	@Column(name = "team_emp_id")
	private int teamEmpId;

	@Column(name = "team_entry_date")
	private Date teamEntryDate;

	@Column(name = "team_entry_id")
	private int teamEntryId;

	@Column(name = "team_modified_date")
	private Date teamModifiedDate;

	@Column(name = "team_modified_id")
	private int teamModifiedId;

	@Column(name = "team_name")
	private String teamName;

	@Column(name = "team_pbf_emp_id")
	private int teamPbfEmpId;

	@Column(name = "team_psf_emp_id")
	private int teamPsfEmpId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

	@OneToMany(mappedBy = "axelaSalesTeam", fetch = FetchType.LAZY)
	private List<AxelaSalesTeamExe> axelaSalesTeamExe;

	public AxelaEmp getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(AxelaEmp axelaEmp) {
		this.axelaEmp = axelaEmp;
	}

	public List<AxelaSalesTeamExe> getAxelaSalesTeamExe() {
		return axelaSalesTeamExe;
	}

	public void setAxelaSalesTeamExe(List<AxelaSalesTeamExe> axelaSalesTeamExe) {
		this.axelaSalesTeamExe = axelaSalesTeamExe;
	}

	public AxelaSalesTeam() {
	}

	public int getTeamId() {
		return this.teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public int getTeamBranchId() {
		return this.teamBranchId;
	}

	public void setTeamBranchId(int teamBranchId) {
		this.teamBranchId = teamBranchId;
	}

	public int getTeamCrmEmpId() {
		return this.teamCrmEmpId;
	}

	public void setTeamCrmEmpId(int teamCrmEmpId) {
		this.teamCrmEmpId = teamCrmEmpId;
	}

	public int getTeamEmpId() {
		return this.teamEmpId;
	}

	public void setTeamEmpId(int teamEmpId) {
		this.teamEmpId = teamEmpId;
	}

	public Date getTeamEntryDate() {
		return this.teamEntryDate;
	}

	public void setTeamEntryDate(Date teamEntryDate) {
		this.teamEntryDate = teamEntryDate;
	}

	public int getTeamEntryId() {
		return this.teamEntryId;
	}

	public void setTeamEntryId(int teamEntryId) {
		this.teamEntryId = teamEntryId;
	}

	public Date getTeamModifiedDate() {
		return this.teamModifiedDate;
	}

	public void setTeamModifiedDate(Date teamModifiedDate) {
		this.teamModifiedDate = teamModifiedDate;
	}

	public int getTeamModifiedId() {
		return this.teamModifiedId;
	}

	public void setTeamModifiedId(int teamModifiedId) {
		this.teamModifiedId = teamModifiedId;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getTeamPbfEmpId() {
		return this.teamPbfEmpId;
	}

	public void setTeamPbfEmpId(int teamPbfEmpId) {
		this.teamPbfEmpId = teamPbfEmpId;
	}

	public int getTeamPsfEmpId() {
		return this.teamPsfEmpId;
	}

	public void setTeamPsfEmpId(int teamPsfEmpId) {
		this.teamPsfEmpId = teamPsfEmpId;
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

	public String getEmpRefNo() {
		return empRefNo;
	}

	public void setEmpRefNo(String empRefNo) {
		this.empRefNo = empRefNo;
	}

	public Long getEmpCount() {
		return empCount;
	}

	public void setEmpCount(Long empCount) {
		this.empCount = empCount;
	}

	public AxelaSalesTeam(int teamId, String teamName, int teamBranchId, String empName, int empId,
			String empRefNo, Long empCount) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.teamBranchId = teamBranchId;
		this.empName = empName;
		this.empId = empId;
		this.empRefNo = empRefNo;
		this.empCount = empCount;
		// + " a.teamId,"
		// + " a.teamName,"
		// + " a.teamBranchId,"
		// + " COALESCE(a.axelaEmp.empName,'') AS empName, "
		// + " COALESCE(a.axelaEmp.empId,'') AS empId, "
		// + " COALESCE(a.axelaEmp.empRefNo,'') AS empRefNo, "
		// + "	COUNT(a.axelaEmp.empId) AS empCount) "
	}

}