package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_emp_branch database table.
 * 
 */
@Entity
@Table(name = "axela_emp_branch", catalog = "axela_1")
@NamedQuery(name = "AxelaEmpBranch.findAll", query = "SELECT a FROM AxelaEmpBranch a")
public class AxelaEmpBranch implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_branch_id")
	private int empBranchId;

	@Column(name = "emp_empbranch_id", nullable = false)
	private int empEmpbranchId;

	@Column(name = "emp_id", nullable = false)
	private int empId;

	public int getEmpEmpbranchId() {
		return empEmpbranchId;
	}

	public void setEmpEmpbranchId(int empEmpbranchId) {
		this.empEmpbranchId = empEmpbranchId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_branch_id", referencedColumnName = "branch_id", insertable = false, updatable = false)
	private AxelaBranch axelaBranch;

	public AxelaBranch getAxelaBranch() {
		return axelaBranch;
	}

	public void setAxelaBranch(AxelaBranch axelaBranch) {
		this.axelaBranch = axelaBranch;
	}

	public AxelaEmp getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(AxelaEmp axelaEmp) {
		this.axelaEmp = axelaEmp;
	}

	public AxelaEmpBranch() {
	}

	public int getEmpBranchId() {
		return this.empBranchId;
	}

	public void setEmpBranchId(int empBranchId) {
		this.empBranchId = empBranchId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	// public int getEmpId() {
	// return this.empId;
	// }
	//
	// public void setEmpId(int empId) {
	// this.empId = empId;
	// }

}