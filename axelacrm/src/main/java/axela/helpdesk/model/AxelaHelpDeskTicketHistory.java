package axela.helpdesk.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the axela_helpdesk_ticket_history database table.
 * 
 */
@Entity
@Table(name = "axela_helpdesk_ticket_history", catalog = "axela_1")
@NamedQuery(name = "AxelaHelpDeskTicketHistory.findAll", query = "SELECT a FROM AxelaHelpDeskTicketHistory a")
public class AxelaHelpDeskTicketHistory implements Serializable {
	private static final long serialVersionUID = 1L;

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

	@Column(name = "history_ticket_id")
	private BigInteger historyTicketId;

	@Transient
	private String empName;

	@Transient
	private String empRefNo;

	public AxelaHelpDeskTicketHistory() {
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

	public BigInteger getHistoryTicketId() {
		return this.historyTicketId;
	}

	public void setHistoryTicketId(BigInteger historyTicketId) {
		this.historyTicketId = historyTicketId;
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

	public AxelaHelpDeskTicketHistory(String historyId,
			String historyActiontype,
			Date historyDatetime,
			int historyEmpId,
			String historyNewvalue,
			String historyOldvalue,
			BigInteger historyTicketId

	) {
		this.historyId = historyId;
		this.historyActiontype = historyActiontype;
		this.historyDatetime = historyDatetime;
		this.historyEmpId = historyEmpId;
		this.historyNewvalue = historyNewvalue;
		this.historyOldvalue = historyOldvalue;
		this.historyTicketId = historyTicketId;
	}

}