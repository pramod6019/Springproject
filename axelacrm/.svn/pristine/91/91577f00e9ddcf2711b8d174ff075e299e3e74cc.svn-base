package axela.service.model;

import java.io.Serializable;
import java.util.Date;

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

import axela.portal.model.AxelaEmp;

/**
 * The persistent class for the axela_service_jc_bay_trans database table.
 * 
 */
@Entity
@Table(name = "axela_service_jc_bay_trans", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceJcBayTran.findAll", query = "SELECT a FROM AxelaServiceJcBayTran a")
public class AxelaServiceJcBayTran implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "baytrans_id")
	private int baytransId;

	@Column(name = "baytrans_bay_id")
	private int baytransBayId;

	@Column(name = "baytrans_emp_id")
	private int baytransEmpId;

	@Column(name = "baytrans_end_entry_id")
	private int baytransEndEntryId;

	@Column(name = "baytrans_end_time")
	private Date baytransEndTime;

	@Column(name = "baytrans_jc_id")
	private int baytransJcId;

	@Column(name = "baytrans_start_entry_id")
	private int baytransStartEntryId;

	@Column(name = "baytrans_start_time")
	private Date baytransStartTime;

	// =========================================Entity Relationship====================================

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "baytrans_bay_id", referencedColumnName = "bay_id", insertable = false, updatable = false)
	private AxelaServiceJcBay axelaServiceJcBay;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "baytrans_emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

	// @OneToMany(mappedBy = "axelaServiceJcBayTran")
	// private List<AxelaServiceJc> axelaServiceJc;

	public AxelaServiceJcBayTran() {
	}

	public int getBaytransId() {
		return this.baytransId;
	}

	public void setBaytransId(int baytransId) {
		this.baytransId = baytransId;
	}

	public int getBaytransBayId() {
		return this.baytransBayId;
	}

	public void setBaytransBayId(int baytransBayId) {
		this.baytransBayId = baytransBayId;
	}

	public int getBaytransEmpId() {
		return this.baytransEmpId;
	}

	public void setBaytransEmpId(int baytransEmpId) {
		this.baytransEmpId = baytransEmpId;
	}

	public int getBaytransEndEntryId() {
		return this.baytransEndEntryId;
	}

	public void setBaytransEndEntryId(int baytransEndEntryId) {
		this.baytransEndEntryId = baytransEndEntryId;
	}

	public Date getBaytransEndTime() {
		return this.baytransEndTime;
	}

	public void setBaytransEndTime(Date baytransEndTime) {
		this.baytransEndTime = baytransEndTime;
	}

	public int getBaytransJcId() {
		return this.baytransJcId;
	}

	public void setBaytransJcId(int baytransJcId) {
		this.baytransJcId = baytransJcId;
	}

	public AxelaServiceJcBay getAxelaServiceJcBay() {
		return axelaServiceJcBay;
	}

	public void setAxelaServiceJcBay(AxelaServiceJcBay axelaServiceJcBay) {
		this.axelaServiceJcBay = axelaServiceJcBay;
	}

	public AxelaEmp getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(AxelaEmp axelaEmp) {
		this.axelaEmp = axelaEmp;
	}

	public int getBaytransStartEntryId() {
		return this.baytransStartEntryId;
	}

	public void setBaytransStartEntryId(int baytransStartEntryId) {
		this.baytransStartEntryId = baytransStartEntryId;
	}

	public Date getBaytransStartTime() {
		return this.baytransStartTime;
	}

	public void setBaytransStartTime(Date baytransStartTime) {
		this.baytransStartTime = baytransStartTime;
	}

}