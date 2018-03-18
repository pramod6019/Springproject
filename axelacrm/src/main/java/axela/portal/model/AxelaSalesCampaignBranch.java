package axela.portal.model;

import java.io.Serializable;

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

import axela.sales.model.AxelaSalesCampaign;

/**
 * The persistent class for the axela_sales_campaign_branch database table.
 * 
 */
@Entity
@Table(name = "axela_sales_campaign_branch", catalog = "axela_1")
@NamedQuery(name = "AxelaSalesCampaignBranch.findAll", query = "SELECT a FROM AxelaSalesCampaignBranch a")
public class AxelaSalesCampaignBranch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "camptrans_id")
	private int camptransId;

	@Column(name = "camptrans_branch_id")
	private int camptransBranchId;

	@Column(name = "camptrans_campaign_id")
	private int camptransCampaignId;

	public AxelaSalesCampaignBranch() {

	}

	// many-to-one relation to AxelaSalesCampaign
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "camptrans_campaign_id", referencedColumnName = "campaign_id", insertable = false, updatable = false)
	private AxelaSalesCampaign axelaSalesCampaign;

	// many-to-one relation to AxelaBranch
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "camptrans_branch_id", referencedColumnName = "branch_id", insertable = false, updatable = false)
	private AxelaBranch axelaBranch;

	public AxelaSalesCampaign getAxelaSalesCampaign() {
		return axelaSalesCampaign;
	}

	public void setAxelaSalesCampaign(AxelaSalesCampaign axelaSalesCampaign) {
		this.axelaSalesCampaign = axelaSalesCampaign;
	}

	public AxelaBranch getAxelaBranch() {
		return axelaBranch;
	}

	public void setAxelaBranch(AxelaBranch axelaBranch) {
		this.axelaBranch = axelaBranch;
	}

	public int getCamptransId() {
		return camptransId;
	}

	public void setCamptransId(int camptransId) {
		this.camptransId = camptransId;
	}

	public int getCamptransBranchId() {
		return camptransBranchId;
	}

	public void setCamptransBranchId(int camptransBranchId) {
		this.camptransBranchId = camptransBranchId;
	}

	public int getCamptransCampaignId() {
		return camptransCampaignId;
	}

	public void setCamptransCampaignId(int camptransCampaignId) {
		this.camptransCampaignId = camptransCampaignId;
	}

}