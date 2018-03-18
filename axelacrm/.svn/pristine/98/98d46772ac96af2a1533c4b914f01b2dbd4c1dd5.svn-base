package axela.portal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the axela_emp_role database table.
 * 
 */
@Entity
@Table(name = "axela_emp_role", catalog = "axela_1")
@NamedQuery(name = "AxelaEmpRole.findAll", query = "SELECT a FROM AxelaEmpRole a")
public class AxelaEmpRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	private int roleId;

	@Column(name = "role_name")
	private String roleName;

	public List<AxelaEmp> getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(List<AxelaEmp> axelaEmp) {
		this.axelaEmp = axelaEmp;
	}

	public AxelaEmpRole() {
	}

	@OneToMany(mappedBy = "axelaEmpRole")
	private List<AxelaEmp> axelaEmp;

	public int getRoleId() {
		return this.roleId;
	}

	public void setRoleId(int roleId) {

		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}