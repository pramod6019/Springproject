//package axela.portal.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//
///**
// * The persistent class for the axela_sales_campaign_type database table.
// * 
// */
//@Entity
//@Table(name = "axela_sales_campaign_type", catalog = "axela_1")
//@NamedQuery(name = "AxelaSalesCampaignType.findAll", query = "SELECT a FROM AxelaSalesCampaignType a")
//public class AxelaSalesCampaignType implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@Column(name = "camptype_id")
//	private String camptypeId;
//
//	@Column(name = "camptype_desc")
//	private String camptypeDesc;
//
//	@Column(name = "camptype_entry_date")
//	private String camptypeEntryDate;
//
//	@Column(name = "camptype_entry_id")
//	private int camptypeEntryId;
//
//	@Column(name = "camptype_modified_date")
//	private String camptypeModifiedDate;
//
//	@Column(name = "camptype_modified_id")
//	private int camptypeModifiedId;
//
//	public AxelaSalesCampaignType() {
//	}
//
//	public String getCamptypeId() {
//		return this.camptypeId;
//	}
//
//	public void setCamptypeId(String camptypeId) {
//		this.camptypeId = camptypeId;
//	}
//
//	public String getCamptypeDesc() {
//		return this.camptypeDesc;
//	}
//
//	public void setCamptypeDesc(String camptypeDesc) {
//		this.camptypeDesc = camptypeDesc;
//	}
//
//	public String getCamptypeEntryDate() {
//		return this.camptypeEntryDate;
//	}
//
//	public void setCamptypeEntryDate(String camptypeEntryDate) {
//		this.camptypeEntryDate = camptypeEntryDate;
//	}
//
//	public int getCamptypeEntryId() {
//		return this.camptypeEntryId;
//	}
//
//	public void setCamptypeEntryId(int camptypeEntryId) {
//		this.camptypeEntryId = camptypeEntryId;
//	}
//
//	public String getCamptypeModifiedDate() {
//		return this.camptypeModifiedDate;
//	}
//
//	public void setCamptypeModifiedDate(String camptypeModifiedDate) {
//		this.camptypeModifiedDate = camptypeModifiedDate;
//	}
//
//	public int getCamptypeModifiedId() {
//		return this.camptypeModifiedId;
//	}
//
//	public void setCamptypeModifiedId(int camptypeModifiedId) {
//		this.camptypeModifiedId = camptypeModifiedId;
//	}
//
// }