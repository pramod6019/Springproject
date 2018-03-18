package axela.sales.model;

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
 * The persistent class for the axela_sales_oppr_followup_desc database table.
 * 
 */
@Entity
@Table(name = "axela_sales_oppr_followup_desc", catalog = "axela_1")
@NamedQuery(name = "AxelaSalesOpprFollowupDesc.findAll", query = "SELECT a FROM AxelaSalesOpprFollowupDesc a")
public class AxelaSalesOpprFollowupDesc implements Serializable {
	private static final long serialVersionUID = 1L;

	public AxelaSalesOpprFollowupDesc(
			int followupdescId,
			String followupdescName) {
		super();
		this.followupdescId = followupdescId;
		this.followupdescName = followupdescName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "followupdesc_id")
	private int followupdescId;

	@Column(name = "followupdesc_entry_date")
	private Date followupdescEntryDate;

	@Column(name = "followupdesc_entry_id")
	private int followupdescEntryId;

	@Column(name = "followupdesc_modified_date")
	private Date followupdescModifiedDate;

	@Column(name = "followupdesc_modified_id")
	private int followupdescModifiedId;

	@Column(name = "followupdesc_name")
	private String followupdescName;

	public AxelaSalesOpprFollowupDesc() {
	}

	public int getFollowupdescId() {
		return this.followupdescId;
	}

	public void setFollowupdescId(int followupdescId) {
		this.followupdescId = followupdescId;
	}

	public Date getFollowupdescEntryDate() {
		return this.followupdescEntryDate;
	}

	public void setFollowupdescEntryDate(Date followupdescEntryDate) {
		this.followupdescEntryDate = followupdescEntryDate;
	}

	public int getFollowupdescEntryId() {
		return this.followupdescEntryId;
	}

	public void setFollowupdescEntryId(int followupdescEntryId) {
		this.followupdescEntryId = followupdescEntryId;
	}

	public Date getFollowupdescModifiedDate() {
		return this.followupdescModifiedDate;
	}

	public void setFollowupdescModifiedDate(Date followupdescModifiedDate) {
		this.followupdescModifiedDate = followupdescModifiedDate;
	}

	public int getFollowupdescModifiedId() {
		return this.followupdescModifiedId;
	}

	public void setFollowupdescModifiedId(int followupdescModifiedId) {
		this.followupdescModifiedId = followupdescModifiedId;
	}

	public String getFollowupdescName() {
		return this.followupdescName;
	}

	public void setFollowupdescName(String followupdescName) {
		this.followupdescName = followupdescName;
	}

}