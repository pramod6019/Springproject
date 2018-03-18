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

import axela.customer.model.AxelaCustomer;

/**
 * The persistent class for the axela_emp_exe database table.
 * 
 */
@Entity
@Table(name = "axela_emp_exe", catalog = AxelaCustomer.comp_db)
@NamedQuery(name = "AxelaEmpExe.findAll", query = "SELECT a FROM AxelaEmpExe a")
public class AxelaEmpExe implements Serializable {
	public static final String comp_db = "axela_1";
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "empexe_id")
	private int empexeId;

	@Column(name = "empexe_emp_id")
	private int empexeEmpId;

	@Column(name = "empexe_exe_id")
	private int empexeExeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empexe_emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

	public AxelaEmp getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(AxelaEmp axelaEmp) {
		this.axelaEmp = axelaEmp;
	}

	public int getEmpexeExeId() {
		return empexeExeId;
	}

	public void setEmpexeExeId(int empexeExeId) {
		this.empexeExeId = empexeExeId;
	}

	public AxelaEmpExe() {
	}

	public int getEmpexeEmpId() {
		return this.empexeEmpId;
	}

	public void setEmpexeEmpId(int empexeEmpId) {
		this.empexeEmpId = empexeEmpId;
	}

	public int getEmpexeId() {
		return this.empexeId;
	}

	public void setEmpexeId(int empexeId) {
		this.empexeId = empexeId;
	}

}