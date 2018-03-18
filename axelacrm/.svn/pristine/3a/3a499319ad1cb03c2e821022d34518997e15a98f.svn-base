package axela.sales.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import axela.portal.model.AxelaSalesCampaignBranch;

/**
 * The persistent class for the axela_sales_campaign database table.
 * 
 */
@Entity
@Table(name = "axela_sales_campaign", catalog = "axela_1")
@NamedQuery(name = "AxelaSalesCampaign.findAll", query = "SELECT a FROM AxelaSalesCampaign a")
public class AxelaSalesCampaign implements Serializable {
	private static final long serialVersionUID = 1L;
	// ====================== start traniesnt ========================
	@Transient
	private int camptypeId;
	@Transient
	private String camptypeDesc;
	@Transient
	private long campaignOpprcount = 0;
	// ====================== end traniesnt ========================

	@Id
	@Column(name = "campaign_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int campaignId;

	@Column(name = "campaign_active")
	private String campaignActive;

	@Column(name = "campaign_budget")
	private int campaignBudget;

	@Column(name = "campaign_campaigntype_id")
	private int campaignCampaigntypeId;

	@Column(name = "campaign_desc")
	private String campaignDesc;

	// @Temporal(TemporalType.DATE)
	@Column(name = "campaign_enddate")
	private Date campaignEnddate;

	@Column(name = "campaign_entry_date", insertable = false)
	private Date campaignEntryDate;

	@Column(name = "campaign_entry_id")
	private int campaignEntryId;

	// @javax.persistence.Temporal(TemporalType.TIMESTAMP)
	@Column(name = "campaign_modified_date", insertable = false)
	private Date campaignModifiedDate;

	@Column(name = "campaign_modified_id")
	private int campaignModifiedId;

	@Column(name = "campaign_name")
	private String campaignName;

	@Column(name = "campaign_notes")
	private String campaignNotes;

	// @Temporal(TemporalType.DATE)
	@Column(name = "campaign_startdate")
	private Date campaignStartdate;

	// =========================================Constructor====================================
	public AxelaSalesCampaign() {

	}

	public AxelaSalesCampaign(int campaignId, String campaignName, int camptypeId,
			String camptypeDesc, String campaignDesc, String campaignActive,
			Date campaignStartdate, Date campaignEnddate, long campaignOpprcount) {
		super();
		this.campaignId = campaignId;
		this.campaignName = campaignName;
		this.camptypeId = camptypeId;
		this.camptypeDesc = camptypeDesc;
		this.campaignDesc = campaignDesc;
		this.campaignActive = campaignActive;
		this.campaignStartdate = campaignStartdate;
		this.campaignEnddate = campaignEnddate;
		this.campaignOpprcount = campaignOpprcount;

	}

	// many-to-one association to AxelaSalesCampaignType
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "campaign_campaigntype_id", referencedColumnName = "camptype_id", insertable = false, updatable = false)
	private AxelaSalesCampaignType axelaSalesCampaignType;

	// one-to-many retation to AxelaSalesCampaignBranch
	@OneToMany(mappedBy = "axelaSalesCampaign")
	private List<AxelaSalesCampaignBranch> axelaSalesCampaignBranch;

	public int getCamptypeId() {
		return camptypeId;
	}

	public void setCamptypeId(int camptypeId) {
		this.camptypeId = camptypeId;
	}

	public String getCamptypeDesc() {
		return camptypeDesc;
	}

	public void setCamptypeDesc(String camptypeDesc) {
		this.camptypeDesc = camptypeDesc;
	}

	public long getCampaignOpprcount() {
		return campaignOpprcount;
	}

	public void setCampaignOpprcount(long campaignOpprcount) {
		this.campaignOpprcount = campaignOpprcount;
	}

	public List<AxelaSalesCampaignBranch> getAxelaSalesCampaignBranch() {
		return axelaSalesCampaignBranch;
	}

	public void setAxelaSalesCampaignBranch(List<AxelaSalesCampaignBranch> axelaSalesCampaignBranch) {
		this.axelaSalesCampaignBranch = axelaSalesCampaignBranch;
	}

	public AxelaSalesCampaignType getAxelaSalesCampaignType() {
		return axelaSalesCampaignType;
	}

	public void setAxelaSalesCampaignType(AxelaSalesCampaignType axelaSalesCampaignType) {
		this.axelaSalesCampaignType = axelaSalesCampaignType;
	}

	public int getCampaignId() {
		return this.campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}

	public String getCampaignActive() {
		return this.campaignActive;
	}

	public void setCampaignActive(String campaignActive) {
		this.campaignActive = campaignActive;
	}

	public int getCampaignBudget() {
		return this.campaignBudget;
	}

	public void setCampaignBudget(int campaignBudget) {
		this.campaignBudget = campaignBudget;
	}

	public int getCampaignCampaigntypeId() {
		return this.campaignCampaigntypeId;
	}

	public void setCampaignCampaigntypeId(int campaignCampaigntypeId) {
		this.campaignCampaigntypeId = campaignCampaigntypeId;
	}

	public String getCampaignDesc() {
		return this.campaignDesc;
	}

	public void setCampaignDesc(String campaignDesc) {
		this.campaignDesc = campaignDesc;
	}

	public Date getCampaignEnddate() {
		return this.campaignEnddate;
	}

	public void setCampaignEnddate(Date campaignEnddate) {
		this.campaignEnddate = campaignEnddate;
	}

	public Date getCampaignEntryDate() {
		return this.campaignEntryDate;
	}

	public void setCampaignEntryDate(Date campaignEntryDate) {
		this.campaignEntryDate = campaignEntryDate;
	}

	public int getCampaignEntryId() {
		return this.campaignEntryId;
	}

	public void setCampaignEntryId(int campaignEntryId) {
		this.campaignEntryId = campaignEntryId;
	}

	public Date getCampaignModifiedDate() {
		return this.campaignModifiedDate;
	}

	public void setCampaignModifiedDate(Date campaignModifiedDate) {
		this.campaignModifiedDate = campaignModifiedDate;
	}

	public int getCampaignModifiedId() {
		return this.campaignModifiedId;
	}

	public void setCampaignModifiedId(int campaignModifiedId) {
		this.campaignModifiedId = campaignModifiedId;
	}

	public String getCampaignName() {
		return this.campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getCampaignNotes() {
		return this.campaignNotes;
	}

	public void setCampaignNotes(String campaignNotes) {
		this.campaignNotes = campaignNotes;
	}

	public Date getCampaignStartdate() {
		return this.campaignStartdate;
	}

	public void setCampaignStartdate(Date campaignStartdate) {
		this.campaignStartdate = campaignStartdate;
	}

}