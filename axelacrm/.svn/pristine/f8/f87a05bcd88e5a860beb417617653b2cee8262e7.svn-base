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
 * The persistent class for the axela_acc_delstatus database table.
 * 
 */
@Entity
@Table(name = "axela_acc_delstatus", catalog = "axela_1")
@NamedQuery(name = "AxelaAccDelstatus.findAll", query = "SELECT a FROM AxelaAccDelstatus a")
public class AxelaAccDelstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	public AxelaAccDelstatus(
			int delstatusId,
			String delstatusName,
			int delstatusRank) {
		super();
		this.delstatusId = delstatusId;
		this.delstatusName = delstatusName;
		this.delstatusRank = delstatusRank;
	}

	@Id
	@Column(name = "delstatus_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int delstatusId;

	@Column(name = "delstatus_entry_date")
	private Date delstatusEntryDate;

	@Column(name = "delstatus_entry_id")
	private int delstatusEntryId;

	@Column(name = "delstatus_modified_date")
	private Date delstatusModifiedDate;

	@Column(name = "delstatus_modified_id")
	private int delstatusModifiedId;

	@Column(name = "delstatus_name")
	private String delstatusName;

	@Column(name = "delstatus_rank")
	private int delstatusRank;

	public AxelaAccDelstatus() {
	}

	public int getDelstatusId() {
		return this.delstatusId;
	}

	public void setDelstatusId(int delstatusId) {
		this.delstatusId = delstatusId;
	}

	public Date getDelstatusEntryDate() {
		return this.delstatusEntryDate;
	}

	public void setDelstatusEntryDate(Date delstatusEntryDate) {
		this.delstatusEntryDate = delstatusEntryDate;
	}

	public int getDelstatusEntryId() {
		return this.delstatusEntryId;
	}

	public void setDelstatusEntryId(int delstatusEntryId) {
		this.delstatusEntryId = delstatusEntryId;
	}

	public Date getDelstatusModifiedDate() {
		return this.delstatusModifiedDate;
	}

	public void setDelstatusModifiedDate(Date delstatusModifiedDate) {
		this.delstatusModifiedDate = delstatusModifiedDate;
	}

	public int getDelstatusModifiedId() {
		return this.delstatusModifiedId;
	}

	public void setDelstatusModifiedId(int delstatusModifiedId) {
		this.delstatusModifiedId = delstatusModifiedId;
	}

	public String getDelstatusName() {
		return this.delstatusName;
	}

	public void setDelstatusName(String delstatusName) {
		this.delstatusName = delstatusName;
	}

	public int getDelstatusRank() {
		return this.delstatusRank;
	}

	public void setDelstatusRank(int delstatusRank) {
		this.delstatusRank = delstatusRank;
	}

}