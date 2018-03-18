package axela.service.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the axela_service_jc_cat database table.
 * 
 */
@Entity
@Table(name = "axela_service_jc_cat", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceJcCat.findAll", query = "SELECT a FROM AxelaServiceJcCat a")
public class AxelaServiceJcCat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "jccat_id")
	private int jccatId;

	@Column(name = "jccat_entry_date")
	private Date jccatEntryDate;

	@Column(name = "jccat_entry_id")
	private int jccatEntryId;

	@Column(name = "jccat_modified_date")
	private Date jccatModifiedDate;

	@Column(name = "jccat_modified_id")
	private int jccatModifiedId;

	@Column(name = "jccat_name")
	private String jccatName;

	public AxelaServiceJcCat() {
	}

	public AxelaServiceJcCat(int jccatId, Date jccatEntryDate, int jccatEntryId, Date jccatModifiedDate, int jccatModifiedId, String jccatName) {
		super();
		this.jccatId = jccatId;
		this.jccatEntryDate = jccatEntryDate;
		this.jccatEntryId = jccatEntryId;
		this.jccatModifiedDate = jccatModifiedDate;
		this.jccatModifiedId = jccatModifiedId;
		this.jccatName = jccatName;
	}

	public int getJccatId() {
		return this.jccatId;
	}

	public void setJccatId(int jccatId) {
		this.jccatId = jccatId;
	}

	public Date getJccatEntryDate() {
		return this.jccatEntryDate;
	}

	public void setJccatEntryDate(Date jccatEntryDate) {
		this.jccatEntryDate = jccatEntryDate;
	}

	public int getJccatEntryId() {
		return this.jccatEntryId;
	}

	public void setJccatEntryId(int jccatEntryId) {
		this.jccatEntryId = jccatEntryId;
	}

	public Date getJccatModifiedDate() {
		return this.jccatModifiedDate;
	}

	public void setJccatModifiedDate(Date jccatModifiedDate) {
		this.jccatModifiedDate = jccatModifiedDate;
	}

	public int getJccatModifiedId() {
		return this.jccatModifiedId;
	}

	public void setJccatModifiedId(int jccatModifiedId) {
		this.jccatModifiedId = jccatModifiedId;
	}

	public String getJccatName() {
		return this.jccatName;
	}

	public void setJccatName(String jccatName) {
		this.jccatName = jccatName;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jccat_id", referencedColumnName = "jc_jccat_id", insertable = false, updatable = false)
	private AxelaServiceJcCat axelaServicejccat;

}