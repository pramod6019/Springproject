package axela.portal.model;

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

/**
 * The persistent class for the axela_emp_log database table.
 * 
 */
@Entity
@Table(name = "axela_emp_log", catalog = AxelaEmpLog.comp_db)
@NamedQuery(name = "AxelaEmpLog.findAll", query = "SELECT a FROM AxelaEmpLog a")
public class AxelaEmpLog implements Serializable {
	private static final long serialVersionUID = 1L;
	protected static final String comp_db = "axela_1";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "log_id")
	private String logId;

	@Column(name = "log_emp_id")
	private int logEmpId;

	@Column(name = "log_attemptcount")
	private byte logAttemptcount;

	@Column(name = "log_comp_id")
	private int logCompId;

	@Column(name = "log_remote_agent")
	private String logRemoteAgent;

	@Column(name = "log_remote_host")
	private String logRemoteHost;

	@Column(name = "log_session_id")
	private String logSessionId;

	@Column(name = "log_signin_time")
	private Date logSigninTime;

	@Column(name = "log_signout_time")
	private Date logSignoutTime;

	// bi-directional many-to-one association to AxelaEmp
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "log_emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

	public AxelaEmpLog() {
	}

	public String getLogId() {
		return this.logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public byte getLogAttemptcount() {
		return this.logAttemptcount;
	}

	public void setLogAttemptcount(byte logAttemptcount) {
		this.logAttemptcount = logAttemptcount;
	}

	public int getLogCompId() {
		return this.logCompId;
	}

	public void setLogCompId(int logCompId) {
		this.logCompId = logCompId;
	}

	public String getLogRemoteAgent() {
		return this.logRemoteAgent;
	}

	public void setLogRemoteAgent(String logRemoteAgent) {
		this.logRemoteAgent = logRemoteAgent;
	}

	public String getLogRemoteHost() {
		return this.logRemoteHost;
	}

	public void setLogRemoteHost(String logRemoteHost) {
		this.logRemoteHost = logRemoteHost;
	}

	public String getLogSessionId() {
		return this.logSessionId;
	}

	public void setLogSessionId(String logSessionId) {
		this.logSessionId = logSessionId;
	}

	public Date getLogSigninTime() {
		return this.logSigninTime;
	}

	public void setLogSigninTime(Date logSigninTime) {
		this.logSigninTime = logSigninTime;
	}

	public Date getLogSignoutTime() {
		return this.logSignoutTime;
	}

	public void setLogSignoutTime(Date logSignoutTime) {
		this.logSignoutTime = logSignoutTime;
	}

	public AxelaEmp getAxelaEmp() {
		return this.axelaEmp;
	}

	public void setAxelaEmp(AxelaEmp axelaEmp) {
		this.axelaEmp = axelaEmp;
	}
	public int getLogEmpId() {
		return logEmpId;
	}

	public void setLogEmpId(int logEmpId) {
		this.logEmpId = logEmpId;
	}

}