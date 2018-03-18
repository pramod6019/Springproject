package axela.sales.model;

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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import axela.portal.model.AxelaEmp;

/**
 * The persistent class for the axela_sales_oppr_history database table.
 * 
 */
@Entity
@Table(name = "axela_sales_oppr_history", catalog = "axela_1")
@NamedQuery(name = "AxelaSalesOpprHistory.findAll", query = "SELECT a FROM AxelaSalesOpprHistory a")
public class AxelaSalesOpprHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Transient
	private String opprTitle;
	@Transient
	private int empId;
	@Transient
	private String empRefNo;
	@Transient
	private String empName;

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

	@Lob
	@Column(name = "history_newvalue")
	private String historyNewvalue;

	@Lob
	@Column(name = "history_oldvalue")
	private String historyOldvalue;

	@Column(name = "history_oppr_id")
	private BigInteger historyOpprId;

	@ManyToOne(fetch = FetchType.LAZY)
	// oppr_id = history_oppr_id "
	@JoinColumn(name = "history_oppr_id", referencedColumnName = "oppr_id", insertable = false, updatable = false)
	private AxelaSalesOppr axelaSalesOppr;

	@ManyToOne(fetch = FetchType.LAZY)
	// emp_id = history_emp_id"
	@JoinColumn(name = "history_emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

	public AxelaSalesOpprHistory(String historyId,
			String historyActiontype,
			Date historyDatetime,
			int historyEmpId,
			String historyNewvalue,
			String historyOldvalue,
			BigInteger historyOpprId,
			String opprTitle,
			int empId,
			String empRefNo,
			String empName

	) {
		this.historyId = historyId;
		this.historyActiontype = historyActiontype;
		this.historyDatetime = historyDatetime;
		this.historyEmpId = historyEmpId;
		this.historyNewvalue = historyNewvalue;
		this.historyOldvalue = historyOldvalue;
		this.historyOpprId = historyOpprId;
		this.opprTitle = opprTitle;
		this.empId = empId;
		this.empRefNo = empRefNo;
		this.empName = empName;

	}

	public AxelaSalesOppr getAxelaSalesOppr() {
		return axelaSalesOppr;
	}

	public void setAxelaSalesOppr(AxelaSalesOppr axelaSalesOppr) {
		this.axelaSalesOppr = axelaSalesOppr;
	}

	public AxelaEmp getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(AxelaEmp axelaEmp) {
		this.axelaEmp = axelaEmp;
	}

	public String getOpprTitle() {
		return opprTitle;
	}

	public void setOpprTitle(String opprTitle) {
		this.opprTitle = opprTitle;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpRefNo() {
		return empRefNo;
	}

	public void setEmpRefNo(String empRefNo) {
		this.empRefNo = empRefNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public AxelaSalesOpprHistory() {
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

	public BigInteger getHistoryOpprId() {
		return this.historyOpprId;
	}

	public void setHistoryOpprId(BigInteger historyOpprId) {
		this.historyOpprId = historyOpprId;
	}

}