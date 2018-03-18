package axela.portal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import axela.sales.model.AxelaSalesCrm;

/**
 * The persistent class for the axela_crm_feedbacktype database table.
 * 
 */
@Entity
@Table(name = "axela_crm_feedbacktype", catalog = "axela")
@NamedQuery(name = "AxelaCrmFeedbacktype.findAll", query = "SELECT a FROM AxelaCrmFeedbacktype a")
public class AxelaCrmFeedbacktype implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "crmfeedbacktype_id")
	private int crmfeedbacktypeId;

	@Column(name = "crmfeedbacktype_entry_date")
	private String crmfeedbacktypeEntryDate;

	@Column(name = "crmfeedbacktype_entry_id")
	private int crmfeedbacktypeEntryId;

	@Column(name = "crmfeedbacktype_modified_date")
	private String crmfeedbacktypeModifiedDate;

	@Column(name = "crmfeedbacktype_modified_id")
	private int crmfeedbacktypeModifiedId;

	@Column(name = "crmfeedbacktype_name")
	private String crmfeedbacktypeName;

	public AxelaCrmFeedbacktype() {
	}

	public int getCrmfeedbacktypeId() {
		return this.crmfeedbacktypeId;
	}

	public void setCrmfeedbacktypeId(int crmfeedbacktypeId) {
		this.crmfeedbacktypeId = crmfeedbacktypeId;
	}

	public String getCrmfeedbacktypeEntryDate() {
		return this.crmfeedbacktypeEntryDate;
	}

	public void setCrmfeedbacktypeEntryDate(String crmfeedbacktypeEntryDate) {
		this.crmfeedbacktypeEntryDate = crmfeedbacktypeEntryDate;
	}

	public int getCrmfeedbacktypeEntryId() {
		return this.crmfeedbacktypeEntryId;
	}

	public void setCrmfeedbacktypeEntryId(int crmfeedbacktypeEntryId) {
		this.crmfeedbacktypeEntryId = crmfeedbacktypeEntryId;
	}

	public String getCrmfeedbacktypeModifiedDate() {
		return this.crmfeedbacktypeModifiedDate;
	}

	public void setCrmfeedbacktypeModifiedDate(String crmfeedbacktypeModifiedDate) {
		this.crmfeedbacktypeModifiedDate = crmfeedbacktypeModifiedDate;
	}

	public int getCrmfeedbacktypeModifiedId() {
		return this.crmfeedbacktypeModifiedId;
	}

	public void setCrmfeedbacktypeModifiedId(int crmfeedbacktypeModifiedId) {
		this.crmfeedbacktypeModifiedId = crmfeedbacktypeModifiedId;
	}

	public String getCrmfeedbacktypeName() {
		return this.crmfeedbacktypeName;
	}

	public void setCrmfeedbacktypeName(String crmfeedbacktypeName) {

		this.crmfeedbacktypeName = crmfeedbacktypeName;
	}

	@OneToMany(mappedBy = "axelaCrmFeedbacktype", cascade = CascadeType.ALL)
	private List<AxelaSalesCrm> axelaSalesCrm;

}