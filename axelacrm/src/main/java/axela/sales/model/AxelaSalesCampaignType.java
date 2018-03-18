package axela.sales.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the axela_sales_campaign_type database table.
 * 
 */
@Entity
@Table(name = "axela_sales_campaign_type", catalog = "axela_1")
@NamedQuery(name = "AxelaSalesCampaignType.findAll", query = "SELECT a FROM AxelaSalesCampaignType a")
public class AxelaSalesCampaignType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "camptype_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int camptypeId;

	@Column(name = "camptype_desc")
	private String camptypeDesc;

	@Column(name = "camptype_entry_date")
	private Date camptypeEntryDate;

	@Column(name = "camptype_entry_id")
	private int camptypeEntryId;

	@Column(name = "camptype_modified_date")
	private Date camptypeModifiedDate;

	@Column(name = "camptype_modified_id")
	private int camptypeModifiedId;

	public AxelaSalesCampaignType() {
	}

	public AxelaSalesCampaignType(
			int camptypeId,
			String camptypeDesc) {
		super();
		this.camptypeId = camptypeId;
		this.camptypeDesc = camptypeDesc;
	}
	public AxelaSalesCampaignType(
			int camptypeId,
			String camptypeDesc,
			int camptypeEntryId,
			Date camptypeEntryDate,
			int camptypeModifiedId,
			Date camptypeModifiedDate

	) {
		this.camptypeId = camptypeId;
		this.camptypeDesc = camptypeDesc;
		this.camptypeEntryId = camptypeEntryId;
		this.camptypeEntryDate = camptypeEntryDate;
		this.camptypeModifiedId = camptypeModifiedId;
		this.camptypeModifiedDate = camptypeModifiedDate;
	}

	// one-to-many to AxelaSalesCampaign
	@OneToMany(mappedBy = "axelaSalesCampaignType")
	private List<AxelaSalesCampaign> AxelaSalesCampaign;

	public List<AxelaSalesCampaign> getAxelaSalesCampaign() {
		return AxelaSalesCampaign;
	}

	public void setAxelaSalesCampaign(List<AxelaSalesCampaign> axelaSalesCampaign) {
		AxelaSalesCampaign = axelaSalesCampaign;
	}

	public int getCamptypeId() {
		return this.camptypeId;
	}

	public void setCamptypeId(int camptypeId) {
		this.camptypeId = camptypeId;
	}

	public String getCamptypeDesc() {
		return this.camptypeDesc;
	}

	public void setCamptypeDesc(String camptypeDesc) {
		this.camptypeDesc = camptypeDesc;
	}

	public Date getCamptypeEntryDate() {
		return this.camptypeEntryDate;
	}

	public void setCamptypeEntryDate(Date camptypeEntryDate) {
		this.camptypeEntryDate = camptypeEntryDate;
	}

	public int getCamptypeEntryId() {
		return this.camptypeEntryId;
	}

	public void setCamptypeEntryId(int camptypeEntryId) {
		this.camptypeEntryId = camptypeEntryId;
	}

	public Date getCamptypeModifiedDate() {
		return this.camptypeModifiedDate;
	}

	public void setCamptypeModifiedDate(Date camptypeModifiedDate) {
		this.camptypeModifiedDate = camptypeModifiedDate;
	}

	public int getCamptypeModifiedId() {
		return this.camptypeModifiedId;
	}

	public void setCamptypeModifiedId(int camptypeModifiedId) {
		this.camptypeModifiedId = camptypeModifiedId;
	}

}