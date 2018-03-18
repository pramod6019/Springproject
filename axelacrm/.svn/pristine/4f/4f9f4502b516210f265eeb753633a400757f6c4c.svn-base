package axela.service.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the axela_service_jc_type database table.
 * 
 */
@Entity
@Table(name = "axela_service_jc_type", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceJcType.findAll", query = "SELECT a FROM AxelaServiceJcType a")
public class AxelaServiceJcType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "jctype_id")
	private int jctypeId;

	@Column(name = "jctype_entry_date")
	private Date jctypeEntryDate;

	@Column(name = "jctype_entry_id")
	private int jctypeEntryId;

	@Column(name = "jctype_modified_date")
	private Date jctypeModifiedDate;

	@Column(name = "jctype_modified_id")
	private int jctypeModifiedId;

	@Column(name = "jctype_name")
	private String jctypeName;

	public AxelaServiceJcType() {
	}

	public AxelaServiceJcType(
			int jctypeId,
			Date jctypeEntryDate,
			int jctypeEntryId,
			Date jctypeModifiedDate,
			int jctypeModifiedId,
			String jctypeName) {
		super();
		this.jctypeId = jctypeId;
		this.jctypeEntryDate = jctypeEntryDate;
		this.jctypeEntryId = jctypeEntryId;
		this.jctypeModifiedDate = jctypeModifiedDate;
		this.jctypeModifiedId = jctypeModifiedId;
		this.jctypeName = jctypeName;
	}

	public int getJctypeId() {
		return this.jctypeId;
	}

	public void setJctypeId(int jctypeId) {
		this.jctypeId = jctypeId;
	}

	public Date getJctypeEntryDate() {
		return this.jctypeEntryDate;
	}

	public void setJctypeEntryDate(Date jctypeEntryDate) {
		this.jctypeEntryDate = jctypeEntryDate;
	}

	public int getJctypeEntryId() {
		return this.jctypeEntryId;
	}

	public void setJctypeEntryId(int jctypeEntryId) {
		this.jctypeEntryId = jctypeEntryId;
	}

	public Date getJctypeModifiedDate() {
		return this.jctypeModifiedDate;
	}

	public void setJctypeModifiedDate(Date jctypeModifiedDate) {
		this.jctypeModifiedDate = jctypeModifiedDate;
	}

	public int getJctypeModifiedId() {
		return this.jctypeModifiedId;
	}

	public void setJctypeModifiedId(int jctypeModifiedId) {
		this.jctypeModifiedId = jctypeModifiedId;
	}

	public String getJctypeName() {
		return this.jctypeName;
	}

	public void setJctypeName(String jctypeName) {
		this.jctypeName = jctypeName;
	}

	@OneToMany(mappedBy = "axelaServicejcType")
	private List<AxelaServiceJc> axelaServiceJc;

}