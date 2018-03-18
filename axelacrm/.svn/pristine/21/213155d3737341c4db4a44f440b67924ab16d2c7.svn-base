package axela.portal.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import axela.customer.model.AxelaCustomer;

/**
 * The persistent class for the axela_emp_department database table.
 * 
 */
@Entity
@Table(name = "axela_emp_department", catalog = AxelaCustomer.comp_db)
@NamedQuery(name = "AxelaEmpDepartment.findAll", query = "SELECT a FROM AxelaEmpDepartment a")
public class AxelaEmpDepartment implements Serializable {
	public static final String comp_db = "axela_1";
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "department_id")
	private int departmentId;

	@Column(name = "department_entry_date")
	private Timestamp departmentEntryDate;

	@Column(name = "department_entry_id")
	private int departmentEntryId;

	@Column(name = "department_modified_date")
	private Timestamp departmentModifiedDate;

	@Column(name = "department_modified_id")
	private int departmentModifiedId;

	@Column(name = "department_name")
	private String departmentName;

	public AxelaEmpDepartment() {
	}

	public int getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public Timestamp getDepartmentEntryDate() {
		return this.departmentEntryDate;
	}

	public void setDepartmentEntryDate(Timestamp departmentEntryDate) {
		this.departmentEntryDate = departmentEntryDate;
	}

	public int getDepartmentEntryId() {
		return this.departmentEntryId;
	}

	public void setDepartmentEntryId(int departmentEntryId) {
		this.departmentEntryId = departmentEntryId;
	}

	public Timestamp getDepartmentModifiedDate() {
		return this.departmentModifiedDate;
	}

	public void setDepartmentModifiedDate(Timestamp departmentModifiedDate) {
		this.departmentModifiedDate = departmentModifiedDate;
	}

	public int getDepartmentModifiedId() {
		return this.departmentModifiedId;
	}

	public void setDepartmentModifiedId(int departmentModifiedId) {
		this.departmentModifiedId = departmentModifiedId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}