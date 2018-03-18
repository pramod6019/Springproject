package axela.service.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import axela.portal.model.AxelaEmp;

/**
 * The persistent class for the axela_service_jc_history database table.
 * 
 */
@Entity
@Table(name = "axela_service_jc_history", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceJcHistory.findAll", query = "SELECT a FROM AxelaServiceJcHistory a")
public class AxelaServiceJcHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Transient
	private String jcTitle;

	@Transient
	private String empName;

	@Transient
	private String empRefNo;

	@Transient
	private int empId;

	public AxelaServiceJcHistory(

			String historyId,
			String historyActiontype,
			Date historyDatetime,
			int historyEmpId,
			BigInteger historyJcId,
			String historyNewvalue,
			String jcTitle,
			String empName,
			int empId,
			String empRefNo) {

		super();
		this.historyId = historyId;
		this.historyActiontype = historyActiontype;
		this.historyDatetime = historyDatetime;
		this.historyEmpId = historyEmpId;
		this.historyJcId = historyJcId;
		this.historyNewvalue = historyNewvalue;
		this.jcTitle = jcTitle;
		this.empName = empName;
		this.empId = empId;
		this.empRefNo = empRefNo;

	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "history_id")
	private String historyId;

	@Column(name = "history_actiontype")
	private String historyActiontype;

	@Column(name = "history_datetime")
	private Date historyDatetime;

	@Column(name = "history_emp_id")
	private int historyEmpId;

	@Column(name = "history_jc_id")
	private BigInteger historyJcId;

	@Lob
	@Column(name = "history_newvalue")
	private String historyNewvalue;

	@Lob
	@Column(name = "history_oldvalue")
	private String historyOldvalue;

	// "axela_service_jc on jc_id = history_jc_id "
	// "axela_branch on branch_id = jc_branch_id "
	// "axela_emp on emp_id = history_emp_id "

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "history_jc_id", referencedColumnName = "jc_id", insertable = false, updatable = false)
	private AxelaServiceJc axelaServiceJc;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "history_emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

	public AxelaServiceJcHistory() {
	}

	public String getHistoryId() {
		return this.historyId;
	}

	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}

	public String getHistoryActiontype() {
		return this.historyActiontype;
	}

	public void setHistoryActiontype(String historyActiontype) {
		this.historyActiontype = historyActiontype;
	}

	public Date getHistoryDatetime() {
		return this.historyDatetime;
	}

	public void setHistoryDatetime(Date historyDatetime) {
		this.historyDatetime = historyDatetime;
	}

	public int getHistoryEmpId() {
		return this.historyEmpId;
	}

	public void setHistoryEmpId(int historyEmpId) {
		this.historyEmpId = historyEmpId;
	}

	public BigInteger getHistoryJcId() {
		return this.historyJcId;
	}

	public void setHistoryJcId(BigInteger historyJcId) {
		this.historyJcId = historyJcId;
	}

	public String getHistoryNewvalue() {
		return this.historyNewvalue;
	}

	public void setHistoryNewvalue(String historyNewvalue) {
		this.historyNewvalue = historyNewvalue;
	}

	public String getHistoryOldvalue() {
		return this.historyOldvalue;

	}
	public void setHistoryOldvalue(String historyOldvalue) {
		this.historyOldvalue = historyOldvalue;
	}

	public String getJcTitle() {
		return jcTitle;
	}

	public void setJcTitle(String jcTitle) {
		this.jcTitle = jcTitle;
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

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public AxelaServiceJc getAxelaServiceJc() {
		return axelaServiceJc;
	}

	public void setAxelaServiceJc(AxelaServiceJc axelaServiceJc) {
		this.axelaServiceJc = axelaServiceJc;
	}

	public AxelaEmp getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(AxelaEmp axelaEmp) {
		this.axelaEmp = axelaEmp;
	}

}