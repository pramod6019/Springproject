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
 * The persistent class for the axela_emp_access database table.
 * 
 */
@Entity
@Table(name = "axela_emp_access", catalog = "axela_1")
@NamedQuery(name = "AxelaEmpAccess.findAll", query = "SELECT a FROM AxelaEmpAccess a")
public class AxelaEmpAccess implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "empaccess_id")
	private int empaccessId;

	@Column(name = "empaccess_access_id")
	private int empaccessAccessId;

	@Column(name = "empaccess_emp_id")
	private int empaccessEmpId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empaccess_emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empaccess_access_id", referencedColumnName = "access_id", insertable = false, updatable = false)
	private AxelaModuleAccess axelaModuleAccess;

	public AxelaEmpAccess() {
	}

	public AxelaEmp getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(AxelaEmp axelaEmp) {
		this.axelaEmp = axelaEmp;
	}

	public AxelaModuleAccess getAxelaModuleAccess() {
		return axelaModuleAccess;
	}

	public void setAxelaModuleAccess(AxelaModuleAccess axelaModuleAccess) {
		this.axelaModuleAccess = axelaModuleAccess;
	}

	public int getEmpaccessId() {
		return this.empaccessId;
	}

	public void setEmpaccessId(int empaccessId) {
		this.empaccessId = empaccessId;
	}

	public int getEmpaccessAccessId() {
		return this.empaccessAccessId;
	}

	public void setEmpaccessAccessId(int empaccessAccessId) {
		this.empaccessAccessId = empaccessAccessId;
	}

	public int getEmpaccessEmpId() {
		return this.empaccessEmpId;
	}

	public void setEmpaccessEmpId(int empaccessEmpId) {
		this.empaccessEmpId = empaccessEmpId;
	}

}