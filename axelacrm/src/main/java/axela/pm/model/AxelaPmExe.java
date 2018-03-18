package axela.pm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import axela.portal.model.AxelaEmp;

/**
 * The persistent class for the axela_pm_exe database table.
 * 
 */
@Entity
@Table(name = "axela_pm_exe", catalog = "axela_1")
@NamedQuery(name = "AxelaPmExe.findAll", query = "SELECT a FROM AxelaPmExe a")
public class AxelaPmExe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pmexe_id")
	private int pmexeId;

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

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	@Column(name = "pmexe_emp_id")
	private int pmexeEmpId;

	@Column(name = "pmexe_pm_id")
	private int pmexePmId;

	// + " pmexe.axelaEmp.empId,"
	// + " pmexe.axelaEmp.empName,"
	// + " pmexe.axelaEmp.empGender)"
	@Transient
	private int empId;
	@Transient
	private String empName;
	@Transient
	private int pmId;

	public AxelaPmExe(int empId, String empName, String empGender) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empGender = empGender;
	}
	@Transient
	private String empGender;

	public AxelaPmExe() {
	}

	public AxelaPmExe(int pmexeEmpId, int pmId) {
		super();
		this.pmexeEmpId = pmexeEmpId;
		this.pmId = pmId;
	}

	public int getPmexeId() {
		return this.pmexeId;
	}

	public void setPmexeId(int pmexeId) {
		this.pmexeId = pmexeId;
	}

	public int getPmexeEmpId() {
		return this.pmexeEmpId;
	}

	public void setPmexeEmpId(int pmexeEmpId) {
		this.pmexeEmpId = pmexeEmpId;
	}

	public int getPmexePmId() {
		return this.pmexePmId;
	}

	public void setPmexePmId(int pmexePmId) {
		this.pmexePmId = pmexePmId;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pmexe_pm_id", referencedColumnName = "pm_id", insertable = false, updatable = false)
	private AxelaPm axelaPm;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pmexe_emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

	public AxelaPm getAxelaPm() {
		return axelaPm;
	}

	public void setAxelaPm(AxelaPm axelaPm) {
		this.axelaPm = axelaPm;
	}

}