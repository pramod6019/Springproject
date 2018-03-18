package axela.portal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_activity_status database table.
 * 
 */
@Entity
@Table(name = "axela_activity_status", catalog = "axela_1")
@NamedQuery(name = "AxelaActivityStatus.findAll", query = "SELECT a FROM AxelaActivityStatus a")
public class AxelaActivityStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "status_id")
	private int statusId;

	@Column(name = "status_desc")
	private String statusDesc;

	@Column(name = "status_entry_date")
	private Date statusEntryDate;

	@Column(name = "status_entry_id")
	private int statusEntryId;

	@Column(name = "status_modified_date")
	private Date statusModifiedDate;

	@Column(name = "status_modified_id")
	private int statusModifiedId;

	public AxelaActivityStatus() {
	}

	public int getStatusId() {
		return this.statusId;
	}

	public void setStatusId(int statusId2) {
		this.statusId = statusId2;
	}

	public String getStatusDesc() {
		return this.statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public Date getStatusEntryDate() {
		return this.statusEntryDate;
	}

	public void setStatusEntryDate(Date statusEntryDate) {
		this.statusEntryDate = statusEntryDate;
	}

	public int getStatusEntryId() {
		return this.statusEntryId;
	}

	public void setStatusEntryId(int statusEntryId) {
		this.statusEntryId = statusEntryId;
	}

	public Date getStatusModifiedDate() {
		return this.statusModifiedDate;
	}

	public void setStatusModifiedDate(Date statusModifiedDate) {
		this.statusModifiedDate = statusModifiedDate;
	}

	public int getStatusModifiedId() {
		return this.statusModifiedId;
	}

	public void setStatusModifiedId(int statusModifiedId) {
		this.statusModifiedId = statusModifiedId;
	}

	public AxelaActivityStatus(
			int statusId,
			String statusDesc) {
		super();
		this.statusId = statusId;
		this.statusDesc = statusDesc;
	}

}