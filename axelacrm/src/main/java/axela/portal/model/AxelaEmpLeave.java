package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_emp_leave database table.
 * 
 */
@Entity
@Table(name = "axela_emp_leave", catalog = "axela_1")
@NamedQuery(name = "AxelaEmpLeave.findAll", query = "SELECT a FROM AxelaEmpLeave a")
public class AxelaEmpLeave implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "leave_id")
	private int leaveId;

	@Column(name = "leave_auth")
	private String leaveAuth;

	@Column(name = "leave_auth_emp_id")
	private int leaveAuthEmpId;

	@Column(name = "leave_auth_end_date")
	private String leaveAuthEndDate;

	@Column(name = "leave_auth_notes")
	private String leaveAuthNotes;

	@Column(name = "leave_auth_start_date")
	private String leaveAuthStartDate;

	@Column(name = "leave_emp_id")
	private int leaveEmpId;

	@Column(name = "leave_end_date")
	private String leaveEndDate;

	@Column(name = "leave_entry_date")
	private String leaveEntryDate;

	@Column(name = "leave_entry_id")
	private int leaveEntryId;

	@Column(name = "leave_modified_date")
	private String leaveModifiedDate;

	@Column(name = "leave_modified_id")
	private int leaveModifiedId;

	@Column(name = "leave_reason")
	private String leaveReason;

	@Column(name = "leave_start_date")
	private String leaveStartDate;

	public AxelaEmpLeave() {
	}

	public int getLeaveId() {
		return this.leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public String getLeaveAuth() {
		return this.leaveAuth;
	}

	public void setLeaveAuth(String leaveAuth) {
		this.leaveAuth = leaveAuth;
	}

	public int getLeaveAuthEmpId() {
		return this.leaveAuthEmpId;
	}

	public void setLeaveAuthEmpId(int leaveAuthEmpId) {
		this.leaveAuthEmpId = leaveAuthEmpId;
	}

	public String getLeaveAuthEndDate() {
		return this.leaveAuthEndDate;
	}

	public void setLeaveAuthEndDate(String leaveAuthEndDate) {
		this.leaveAuthEndDate = leaveAuthEndDate;
	}

	public String getLeaveAuthNotes() {
		return this.leaveAuthNotes;
	}

	public void setLeaveAuthNotes(String leaveAuthNotes) {
		this.leaveAuthNotes = leaveAuthNotes;
	}

	public String getLeaveAuthStartDate() {
		return this.leaveAuthStartDate;
	}

	public void setLeaveAuthStartDate(String leaveAuthStartDate) {
		this.leaveAuthStartDate = leaveAuthStartDate;
	}

	public int getLeaveEmpId() {
		return this.leaveEmpId;
	}

	public void setLeaveEmpId(int leaveEmpId) {
		this.leaveEmpId = leaveEmpId;
	}

	public String getLeaveEndDate() {
		return this.leaveEndDate;
	}

	public void setLeaveEndDate(String leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}

	public String getLeaveEntryDate() {
		return this.leaveEntryDate;
	}

	public void setLeaveEntryDate(String leaveEntryDate) {
		this.leaveEntryDate = leaveEntryDate;
	}

	public int getLeaveEntryId() {
		return this.leaveEntryId;
	}

	public void setLeaveEntryId(int leaveEntryId) {
		this.leaveEntryId = leaveEntryId;
	}

	public String getLeaveModifiedDate() {
		return this.leaveModifiedDate;
	}

	public void setLeaveModifiedDate(String leaveModifiedDate) {
		this.leaveModifiedDate = leaveModifiedDate;
	}

	public int getLeaveModifiedId() {
		return this.leaveModifiedId;
	}

	public void setLeaveModifiedId(int leaveModifiedId) {
		this.leaveModifiedId = leaveModifiedId;
	}

	public String getLeaveReason() {
		return this.leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public String getLeaveStartDate() {
		return this.leaveStartDate;
	}

	public void setLeaveStartDate(String leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}

}