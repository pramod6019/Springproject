package axela.sales.model;

import java.io.Serializable;
import java.util.List;

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
import javax.persistence.Table;

import axela.portal.model.AxelaEmp;

/**
 * The persistent class for the axela_sales_team_exe database table.
 * 
 */
@Entity
@Table(name = "axela_sales_team_exe", catalog = "axela_1")
@NamedQuery(name = "AxelaSalesTeamExe.findAll", query = "SELECT a FROM AxelaSalesTeamExe a")
public class AxelaSalesTeamExe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "teamtrans_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int teamtransId;

	public AxelaSalesTeam getAxelaSalesTeam() {
		return axelaSalesTeam;
	}

	public void setAxelaSalesTeam(AxelaSalesTeam axelaSalesTeam) {
		this.axelaSalesTeam = axelaSalesTeam;
	}

	public List<AxelaEmp> getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(List<AxelaEmp> axelaEmp) {
		this.axelaEmp = axelaEmp;
	}

	@Column(name = "teamtrans_emp_id")
	private int teamtransEmpId;

	@Column(name = "teamtrans_team_id")
	private int teamtransTeamId;

	public AxelaSalesTeamExe() {
	}

	public int getTeamtransId() {
		return this.teamtransId;
	}

	public void setTeamtransId(int teamtransId) {
		this.teamtransId = teamtransId;
	}

	public int getTeamtransEmpId() {
		return this.teamtransEmpId;
	}

	public void setTeamtransEmpId(int teamtransEmpId) {
		this.teamtransEmpId = teamtransEmpId;
	}

	public int getTeamtransTeamId() {
		return this.teamtransTeamId;
	}

	public void setTeamtransTeamId(int teamtransTeamId) {
		this.teamtransTeamId = teamtransTeamId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teamtrans_team_id", referencedColumnName = "team_id", insertable = false, updatable = false)
	private AxelaSalesTeam axelaSalesTeam;

	@OneToMany(mappedBy = "axelaSalesTeamExe")
	private List<AxelaEmp> axelaEmp;
}