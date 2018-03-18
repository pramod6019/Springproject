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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the axela_emp_user database table.
 * 
 */
@Entity
@Table(name = "axela_emp_user", catalog = "axela_1")
@NamedQuery(name = "AxelaEmpUser.findAll", query = "SELECT a FROM AxelaEmpUser a")
public class AxelaEmpUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "user_agent")
	private String userAgent;

	@Column(name = "user_emp_id")
	private int userEmpId;

	@Column(name = "user_ip")
	private String userIp;

	@Column(name = "user_jsessionid")
	private String userJsessionid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "user_logintime")
	private Date userLogintime;

	public AxelaEmpUser() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserAgent() {
		return this.userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public int getUserEmpId() {
		return this.userEmpId;
	}

	public void setUserEmpId(int userEmpId) {
		this.userEmpId = userEmpId;
	}

	public String getUserIp() {
		return this.userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getUserJsessionid() {
		return this.userJsessionid;
	}

	public void setUserJsessionid(String userJsessionid) {
		this.userJsessionid = userJsessionid;
	}

	public Date getUserLogintime() {
		return this.userLogintime;
	}

	public void setUserLogintime(Date userLogintime) {
		this.userLogintime = userLogintime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

}