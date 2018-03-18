package axela.sales.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import axela.customer.model.AxelaCustomer;
import axela.customer.model.AxelaCustomerContact;
import axela.customer.model.AxelaSalesOpprStatus;
import axela.inventory.model.AxelaInventoryItem;
import axela.pm.model.AxelaPm;
import axela.portal.model.AxelaBranch;
import axela.portal.model.AxelaCity;
import axela.portal.model.AxelaEmp;
import axela.portal.model.AxelaSalesOpprStage;

@Entity
@Table(name = "axela_sales_oppr", catalog = AxelaCustomer.comp_db)
@NamedQuery(name = "AxelaSalesOppr.findAll", query = "SELECT a FROM AxelaSalesOppr a")
public class AxelaSalesOppr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Transient
	private long monthOpportunities;
	@Transient
	private long todayOpportunities;
	@Transient
	private long totalOpportunities;
	@Transient
	private String contactMobile1;
	@Transient
	private String customerName;
	@Transient
	private String contactName;
	@Transient
	private int contactId;
	@Transient
	private String contactMobile2;
	@Transient
	private String contactPhone1;
	@Transient
	private String contactPhone2;
	@Transient
	private String branchCode;
	@Transient
	private String empName;
	@Transient
	private String contactEmail1;
	@Transient
	private String contactEmail2;
	@Transient
	private String itemName;
	@Transient
	private String opprStatusName;
	@Transient
	private String opprStageName;
	@Transient
	private String pmName;
	@Transient
	private String opprCampaignName;
	@Transient
	private String modelName;
	@Transient
	private String branchName;

	// dash traniesnt
	@Transient
	private String opprtypeName;
	@Transient
	private int contactTitleId;
	@Transient
	private String contactFname;
	@Transient
	private String contactLname;
	@Transient
	private String contactAddress;
	@Transient
	private String contactCityId;
	@Transient
	private String contactPin;

	@Transient
	private int customerId;
	@Transient
	private String customerAddress1;
	@Transient
	private String customerAddress2;
	@Transient
	private String customerLandmark;
	@Transient
	private String customerMobile1;
	@Transient
	private String customerMobile2;
	@Transient
	private Date customerSince;
	@Transient
	private String customerActive;
	@Transient
	private String customerNotes;
	@Transient
	private String titleDesc;

	public void setMonthOpportunities(long monthopportunities) {
		this.monthOpportunities = monthopportunities;
	}

	public long getTodayOpportunities() {
		return todayOpportunities;
	}

	public void setTodayOpportunities(long todayopportunities) {
		this.todayOpportunities = todayopportunities;
	}

	public long getTotalOpportunities() {
		return totalOpportunities;
	}

	public void setTotalOpportunities(long totalopportunities) {
		this.totalOpportunities = totalopportunities;
	}
	@Transient
	private long level1oppr;
	@Transient
	private long level2oppr;
	@Transient
	private long level3oppr;
	@Transient
	private long level4oppr;
	@Transient
	private long level5oppr;

	public long getMonthOpportunities() {
		return monthOpportunities;
	}

	public AxelaSalesOppr(long monthOpportunities, long todayOpportunities, long totalOpportunities,
			long level1oppr, long level2oppr, long level3oppr, long level4oppr, long level5oppr) {
		super();
		this.monthOpportunities = monthOpportunities;
		this.todayOpportunities = todayOpportunities;
		this.totalOpportunities = totalOpportunities;
		this.level1oppr = level1oppr;
		this.level2oppr = level2oppr;
		this.level3oppr = level3oppr;
		this.level4oppr = level4oppr;
		this.level5oppr = level5oppr;
	}

	public long getLevel1oppr() {
		return level1oppr;
	}

	public void setLevel1oppr(long level1oppr) {
		this.level1oppr = level1oppr;
	}

	public long getLevel2oppr() {
		return level2oppr;
	}

	public void setLevel2oppr(long level2oppr) {
		this.level2oppr = level2oppr;
	}

	public long getLevel3oppr() {
		return level3oppr;
	}

	public void setLevel3oppr(long level3oppr) {
		this.level3oppr = level3oppr;
	}

	public long getLevel4oppr() {
		return level4oppr;
	}

	public void setLevel4oppr(long level4oppr) {
		this.level4oppr = level4oppr;
	}

	public long getLevel5oppr() {
		return level5oppr;
	}

	public void setLevel5oppr(long level5oppr) {
		this.level5oppr = level5oppr;
	}
	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactFname) {
		this.contactName = contactFname;
	}
	public String getOpprNumber() {
		return branchCode;
	}

	public void setOpprNumber(String opprNumber) {
		this.branchCode = opprNumber;
	}

	public String getContactMobile1() {
		return contactMobile1;
	}

	public void setContactMobile1(String contactMobile1) {
		this.contactMobile1 = contactMobile1;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactMobile2() {
		return contactMobile2;
	}

	public void setContactMobile2(String contactMobile2) {
		this.contactMobile2 = contactMobile2;
	}

	public String getContactPhone1() {
		return contactPhone1;
	}

	public void setContactPhone1(String contactPhone1) {
		this.contactPhone1 = contactPhone1;
	}

	public String getContactPhone2() {
		return contactPhone2;
	}

	public void setContactPhone2(String contactPhone2) {
		this.contactPhone2 = contactPhone2;
	}

	public String getContactEmail1() {
		return contactEmail1;
	}

	public void setContactEmail1(String contactEmail1) {
		this.contactEmail1 = contactEmail1;
	}

	public String getContactEmail2() {
		return contactEmail2;
	}

	public void setContactEmail2(String contactEmail2) {
		this.contactEmail2 = contactEmail2;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getOpprStatusName() {
		return opprStatusName;
	}

	public void setOpprStatusName(String opprStatusName) {
		this.opprStatusName = opprStatusName;
	}

	public String getOpprStageName() {
		return opprStageName;
	}

	public void setOpprStageName(String opprStageName) {
		this.opprStageName = opprStageName;
	}

	public String getPmName() {
		return pmName;
	}

	public void setPmName(String pmName) {
		this.pmName = pmName;
	}

	public String getOpprCampaignName() {
		return opprCampaignName;
	}

	public void setOpprCampaignName(String opprCampaignName) {
		this.opprCampaignName = opprCampaignName;
	}

	public AxelaSalesCampaign getAxelaSalesCampaign() {
		return axelaSalesCampaign;
	}

	public void setAxelaSalesCampaign(AxelaSalesCampaign axelaSalesCampaign) {
		this.axelaSalesCampaign = axelaSalesCampaign;
	}

	public AxelaSalesOppr(int opprEmpId, int opprId, String empName, String itemName,
			String opprStatusName, String opprStageName, Date opprDate,
			String contactName, String contactMobile1, String contactMobile2,
			String contactPhone1, String contactPhone2, String contactEmail2,
			String contactEmail1, String branchCode, int opprNo, int opprBranchId,
			Date opprCloseDate, String opprTitle, String opprDesc, int opprItemId,
			int opprCustomerId, String customerName, String branchName, String opprRefno,
			int opprContactId) {
		super();
		this.opprEmpId = opprEmpId;
		this.opprRefno = opprRefno;
		this.opprId = opprId;
		this.branchCode = branchCode;
		this.opprNo = opprNo;
		this.opprBranchId = opprBranchId;
		this.opprDate = opprDate;
		this.opprCloseDate = opprCloseDate;
		this.opprTitle = opprTitle;
		this.opprDesc = opprDesc;
		this.empName = empName;
		this.opprItemId = opprItemId;
		this.opprCustomerId = opprCustomerId;
		this.customerName = customerName;
		this.contactName = contactName;
		this.contactMobile1 = contactMobile1;
		this.contactMobile2 = contactMobile2;
		this.contactPhone1 = contactPhone1;
		this.contactPhone2 = contactPhone2;
		this.contactEmail1 = contactEmail1;
		this.contactEmail2 = contactEmail2;
		this.itemName = itemName;
		this.opprStatusName = opprStatusName;
		this.opprStageName = opprStageName;
		this.branchName = branchName;
		this.opprContactId = opprContactId;
	}
	public String getOpprtypeName() {
		return opprtypeName;
	}

	public void setOpprtypeName(String opprtypeName) {
		this.opprtypeName = opprtypeName;
	}

	public int getContactTitleId() {
		return contactTitleId;
	}

	public void setContactTitleId(int contactTitleId) {
		this.contactTitleId = contactTitleId;
	}

	public String getContactFname() {
		return contactFname;
	}

	public void setContactFname(String contactFname) {
		this.contactFname = contactFname;
	}

	public String getContactLname() {
		return contactLname;
	}

	public void setContactLname(String contactLname) {
		this.contactLname = contactLname;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactCityId() {
		return contactCityId;
	}

	public void setContactCityId(String contactCityId) {
		this.contactCityId = contactCityId;
	}

	public String getContactPin() {
		return contactPin;
	}

	public void setContactPin(String contactPin) {
		this.contactPin = contactPin;
	}

	// start constructor for opportunity dash board populate
	public AxelaSalesOppr(int opprPmId, int opprCampaignId, int opprCustomerId, int opprProjectId,
			String opprStatusDesc, String opprAvpresent, String opprManagerAssist, int opprContactId,
			int opprEmpId, int opprLostcase1Id, int opprLostcase2Id, int opprLostcase3Id,
			String opprNotes, int opprPriorityopprId, int opprStatusId, int opprStageId,
			String opprDesc, int opprId, int opprModelId, Date opprDate, Date opprCloseDate,
			int opprTeamId, int opprItemId, int opprSoeId, int opprSobId, int opprBranchId,
			String opprtypeName, String opprTitle, String customerName, int contactTitleId,
			String contactFname, String contactLname, String contactMobile1, String contactMobile2,
			String contactPhone1, String contactPhone2, String contactEmail1, String contactEmail2,
			String contactAddress, String contactCityId, String contactPin, String branchName,
			String branchCode, int opprEntryId, Date opprEntryDate, int opprModifiedId, Date opprModifiedDate) {
		super();
		this.opprPmId = opprPmId;
		this.opprCampaignId = opprCampaignId;
		this.opprProjectId = opprProjectId;
		this.opprStatusDesc = opprStatusDesc;
		this.opprAvpresent = opprAvpresent;
		this.opprManagerAssist = opprManagerAssist;
		this.opprCustomerId = opprCustomerId;
		this.opprContactId = opprContactId;
		this.opprEmpId = opprEmpId;
		this.opprLostcase1Id = opprLostcase1Id;
		this.opprLostcase2Id = opprLostcase2Id;
		this.opprLostcase3Id = opprLostcase3Id;
		this.opprNotes = opprNotes;
		this.opprPriorityopprId = opprPriorityopprId;
		this.opprStatusId = opprStatusId;
		this.opprStageId = opprStageId;
		this.opprDesc = opprDesc;
		this.opprId = opprId;
		this.opprModelId = opprModelId;
		this.opprDate = opprDate;
		this.opprCloseDate = opprCloseDate;
		this.opprTeamId = opprTeamId;
		this.opprItemId = opprItemId;
		this.opprSoeId = opprSoeId;
		this.opprSobId = opprSobId;
		this.opprBranchId = opprBranchId;
		this.opprtypeName = opprtypeName;
		this.opprTitle = opprTitle;
		this.customerName = customerName;
		this.contactTitleId = contactTitleId;
		this.contactFname = contactFname;
		this.contactLname = contactLname;
		this.contactMobile1 = contactMobile1;
		this.contactMobile2 = contactMobile2;
		this.contactPhone1 = contactPhone1;
		this.contactPhone2 = contactPhone2;
		this.contactEmail1 = contactEmail1;
		this.contactEmail2 = contactEmail2;
		this.contactAddress = contactAddress;
		this.contactCityId = contactCityId;
		this.contactPin = contactPin;
		this.branchName = branchName;
		this.branchCode = branchCode;
		this.opprEntryId = opprEntryId;
		this.opprEntryDate = opprEntryDate;
		this.opprModifiedId = opprModifiedId;
		this.opprModifiedDate = opprModifiedDate;

	}

	public AxelaSalesOppr(int opprContactId, int customerId, String customerName,
			String customerAddress1, String customerAddress2, String customerLandmark,
			String customerMobile1, String customerMobile2, Date customerSince,
			String customerActive, String customerNotes, String branchName) {
		super();
		this.opprContactId = opprContactId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress1 = customerAddress1;
		this.customerAddress2 = customerAddress2;
		this.customerLandmark = customerLandmark;
		this.customerMobile1 = customerMobile1;
		this.customerMobile2 = customerMobile2;
		this.customerSince = customerSince;
		this.customerActive = customerActive;
		this.customerNotes = customerNotes;
		this.branchName = branchName;
		// customerId, "
		// + " a.axelaCustomer.customerName, "
		// + " a.customerAddress1, "
		// + " a.customerAddress2, "
		// + " a.customerLandmark, "
		// + " a.customerMobile1, "
		// + " a.customerMobile2, "
		// + " a.customerSince,"
		// + " a.customerActive, "
		// + " a.customerNotes, "
		// + " b.axelaBranch.branchName"
	}
	// end constructor for opportunity dash board populate

	public AxelaSalesOppr(String titleDesc, int contactId, String contactMobile1,
			String contactMobile2, String contactEmail1, String contactEmail2,
			String contactFname, String contactLname, String contactAddress) {
		super();
		this.titleDesc = titleDesc;
		this.contactId = contactId;
		this.contactMobile1 = contactMobile1;
		this.contactMobile2 = contactMobile2;
		this.contactEmail1 = contactEmail1;
		this.contactEmail2 = contactEmail2;
		this.contactFname = contactFname;
		this.contactLname = contactLname;
		this.contactAddress = contactAddress;
	}
	public String getTitleDesc() {
		return titleDesc;
	}

	public void setTitleDesc(String titleDesc) {
		this.titleDesc = titleDesc;
	}

	public AxelaCity getAxelaCity() {
		return axelaCity;
	}

	public void setAxelaCity(AxelaCity axelaCity) {
		this.axelaCity = axelaCity;
	}

	// ===================================================================
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "oppr_id")
	private int opprId;

	@Column(name = "oppr_avpresent")
	private String opprAvpresent;

	@Column(name = "oppr_bath")
	private int opprBath;

	@Column(name = "oppr_br")
	private BigDecimal opprBr;

	@Column(name = "oppr_branch_id")
	private int opprBranchId;

	@Column(name = "oppr_budget")
	private int opprBudget;

	@Column(name = "oppr_budget_syscal")
	private String opprBudgetSyscal;

	@Column(name = "oppr_campaign_id")
	private int opprCampaignId;

	@Column(name = "oppr_city_id")
	private int opprCityId;

	@Column(name = "oppr_close_date")
	private Date opprCloseDate;

	@Column(name = "oppr_contact_id")
	private int opprContactId;

	@Column(name = "oppr_coveredarea")
	private double opprCoveredarea;

	@Column(name = "oppr_customer_id")
	private int opprCustomerId;

	@Column(name = "oppr_date")
	private Date opprDate;

	@Column(name = "oppr_desc")
	private String opprDesc;

	@Column(name = "oppr_emp_id")
	private int opprEmpId;

	@Column(name = "oppr_entry_date")
	private Date opprEntryDate;

	@Column(name = "oppr_entry_id")
	private int opprEntryId;

	@Column(name = "oppr_item_id")
	private int opprItemId;

	@Column(name = "oppr_lead_id")
	private int opprLeadId;

	@Column(name = "oppr_location_id")
	private int opprLocationId;

	@Column(name = "oppr_lostcase1_id")
	private int opprLostcase1Id;

	@Column(name = "oppr_lostcase2_id")
	private int opprLostcase2Id;

	@Column(name = "oppr_lostcase3_id")
	private int opprLostcase3Id;

	@Column(name = "oppr_manager_assist")
	private String opprManagerAssist;

	@Column(name = "oppr_model_id")
	private int opprModelId;

	@Column(name = "oppr_modified_date")
	private Date opprModifiedDate;

	@Column(name = "oppr_modified_id")
	private int opprModifiedId;

	@Column(name = "oppr_no")
	private int opprNo;

	@Column(name = "oppr_notes")
	private String opprNotes;

	@Column(name = "oppr_opprtype_id")
	private int opprOpprtypeId;

	@Column(name = "oppr_plotarea")
	private double opprPlotarea;

	@Column(name = "oppr_pm_id")
	private int opprPmId;

	@Column(name = "oppr_priorityoppr_id")
	private int opprPriorityopprId;

	@Column(name = "oppr_project_id")
	private int opprProjectId;

	@Column(name = "oppr_proptype_id")
	private int opprProptypeId;

	@Column(name = "oppr_refno")
	private String opprRefno;

	@Column(name = "oppr_sob_id")
	private int opprSobId;

	@Column(name = "oppr_soe_id")
	private int opprSoeId;

	@Column(name = "oppr_stage_id")
	private int opprStageId;

	@Column(name = "oppr_status_date")
	private Date opprStatusDate;

	@Column(name = "oppr_status_desc")
	private String opprStatusDesc;

	@Column(name = "oppr_status_id")
	private int opprStatusId;

	@Column(name = "oppr_study")
	private String opprStudy;

	@Column(name = "oppr_team_id")
	private int opprTeamId;

	@Column(name = "oppr_title")
	private String opprTitle;

	@Column(name = "oppr_travel_adults")
	private int opprTravelAdults;

	@Column(name = "oppr_travel_children")
	private int opprTravelChildren;

	@Column(name = "oppr_travel_fromdate")
	private Date opprTravelFromdate;

	@Column(name = "oppr_travel_rooms")
	private int opprTravelRooms;

	@Column(name = "oppr_travel_todate")
	private Date opprTravelTodate;

	@Column(name = "oppr_traveltype_id")
	private int opprTraveltypeId;

	@Column(name = "oppr_trigger")
	private short opprTrigger;

	public AxelaSalesOppr() {
	}

	public int getOpprId() {
		return this.opprId;
	}

	public void setOpprId(int opprId) {
		this.opprId = opprId;
	}

	public String getOpprAvpresent() {
		return this.opprAvpresent;
	}

	public void setOpprAvpresent(String opprAvpresent) {
		this.opprAvpresent = opprAvpresent;
	}

	public int getOpprBath() {
		return this.opprBath;
	}

	public void setOpprBath(int opprBath) {
		this.opprBath = opprBath;
	}

	public BigDecimal getOpprBr() {
		return this.opprBr;
	}

	public void setOpprBr(BigDecimal opprBr) {
		this.opprBr = opprBr;
	}

	public int getOpprBranchId() {
		return this.opprBranchId;
	}

	public void setOpprBranchId(int opprBranchId) {
		this.opprBranchId = opprBranchId;
	}

	public int getOpprBudget() {
		return this.opprBudget;
	}

	public void setOpprBudget(int opprBudget) {
		this.opprBudget = opprBudget;
	}

	public String getOpprBudgetSyscal() {
		return this.opprBudgetSyscal;
	}

	public void setOpprBudgetSyscal(String opprBudgetSyscal) {
		this.opprBudgetSyscal = opprBudgetSyscal;
	}

	public int getOpprCampaignId() {
		return this.opprCampaignId;
	}

	public void setOpprCampaignId(int opprCampaignId) {
		this.opprCampaignId = opprCampaignId;
	}

	public int getOpprCityId() {
		return this.opprCityId;
	}

	public void setOpprCityId(int opprCityId) {
		this.opprCityId = opprCityId;
	}

	public Date getOpprCloseDate() {
		return this.opprCloseDate;
	}

	public void setOpprCloseDate(Date opprCloseDate) {
		this.opprCloseDate = opprCloseDate;
	}

	public int getOpprContactId() {
		return this.opprContactId;
	}

	public void setOpprContactId(int opprContactId) {
		this.opprContactId = opprContactId;
	}

	public double getOpprCoveredarea() {
		return this.opprCoveredarea;
	}

	public void setOpprCoveredarea(double opprCoveredarea) {
		this.opprCoveredarea = opprCoveredarea;
	}

	public int getOpprCustomerId() {
		return this.opprCustomerId;
	}

	public void setOpprCustomerId(int opprCustomerId) {
		this.opprCustomerId = opprCustomerId;
	}

	public Date getOpprDate() {
		return this.opprDate;
	}

	public void setOpprDate(Date opprDate) {
		this.opprDate = opprDate;
	}

	public String getOpprDesc() {
		return this.opprDesc;
	}

	public void setOpprDesc(String opprDesc) {
		this.opprDesc = opprDesc;
	}

	public int getOpprEmpId() {
		return this.opprEmpId;
	}

	public void setOpprEmpId(int opprEmpId) {
		this.opprEmpId = opprEmpId;
	}

	public Date getOpprEntryDate() {
		return this.opprEntryDate;
	}

	public void setOpprEntryDate(Date opprEntryDate) {
		this.opprEntryDate = opprEntryDate;
	}

	public int getOpprEntryId() {
		return this.opprEntryId;
	}

	public void setOpprEntryId(int opprEntryId) {
		this.opprEntryId = opprEntryId;
	}

	public int getOpprItemId() {
		return this.opprItemId;
	}

	public void setOpprItemId(int opprItemId) {
		this.opprItemId = opprItemId;
	}

	public int getOpprLeadId() {
		return this.opprLeadId;
	}

	public void setOpprLeadId(int opprLeadId) {
		this.opprLeadId = opprLeadId;
	}

	public int getOpprLocationId() {
		return this.opprLocationId;
	}

	public void setOpprLocationId(int opprLocationId) {
		this.opprLocationId = opprLocationId;
	}

	public int getOpprLostcase1Id() {
		return this.opprLostcase1Id;
	}

	public void setOpprLostcase1Id(int opprLostcase1Id) {
		this.opprLostcase1Id = opprLostcase1Id;
	}

	public int getOpprLostcase2Id() {
		return this.opprLostcase2Id;
	}

	public void setOpprLostcase2Id(int opprLostcase2Id) {
		this.opprLostcase2Id = opprLostcase2Id;
	}

	public int getOpprLostcase3Id() {
		return this.opprLostcase3Id;
	}

	public void setOpprLostcase3Id(int opprLostcase3Id) {
		this.opprLostcase3Id = opprLostcase3Id;
	}

	public String getOpprManagerAssist() {
		return this.opprManagerAssist;
	}

	public void setOpprManagerAssist(String opprManagerAssist) {
		this.opprManagerAssist = opprManagerAssist;
	}

	public int getOpprModelId() {
		return this.opprModelId;
	}

	public void setOpprModelId(int opprModelId) {
		this.opprModelId = opprModelId;
	}

	public Date getOpprModifiedDate() {
		return this.opprModifiedDate;
	}

	public void setOpprModifiedDate(Date opprModifiedDate) {
		this.opprModifiedDate = opprModifiedDate;
	}

	public int getOpprModifiedId() {
		return this.opprModifiedId;
	}

	public void setOpprModifiedId(int opprModifiedId) {
		this.opprModifiedId = opprModifiedId;
	}

	public int getOpprNo() {
		return this.opprNo;
	}

	public void setOpprNo(int opprNo) {
		this.opprNo = opprNo;
	}

	public String getOpprNotes() {
		return this.opprNotes;
	}

	public void setOpprNotes(String opprNotes) {
		this.opprNotes = opprNotes;
	}

	public int getOpprOpprtypeId() {
		return this.opprOpprtypeId;
	}

	public void setOpprOpprtypeId(int opprOpprtypeId) {
		this.opprOpprtypeId = opprOpprtypeId;
	}

	public double getOpprPlotarea() {
		return this.opprPlotarea;
	}

	public void setOpprPlotarea(double opprPlotarea) {
		this.opprPlotarea = opprPlotarea;
	}

	public int getOpprPmId() {
		return this.opprPmId;
	}

	public void setOpprPmId(int opprPmId) {
		this.opprPmId = opprPmId;
	}

	public int getOpprPriorityopprId() {
		return this.opprPriorityopprId;
	}

	public void setOpprPriorityopprId(int opprPriorityopprId) {
		this.opprPriorityopprId = opprPriorityopprId;
	}

	public int getOpprProjectId() {
		return this.opprProjectId;
	}

	public void setOpprProjectId(int opprProjectId) {
		this.opprProjectId = opprProjectId;
	}

	public int getOpprProptypeId() {
		return this.opprProptypeId;
	}

	public void setOpprProptypeId(int opprProptypeId) {
		this.opprProptypeId = opprProptypeId;
	}

	public String getOpprRefno() {
		return this.opprRefno;
	}

	public void setOpprRefno(String opprRefno) {
		this.opprRefno = opprRefno;
	}

	public int getOpprSobId() {
		return this.opprSobId;
	}

	public void setOpprSobId(int opprSobId) {
		this.opprSobId = opprSobId;
	}

	public int getOpprSoeId() {
		return this.opprSoeId;
	}

	public void setOpprSoeId(int opprSoeId) {
		this.opprSoeId = opprSoeId;
	}

	public int getOpprStageId() {
		return this.opprStageId;
	}

	public void setOpprStageId(int opprStageId) {
		this.opprStageId = opprStageId;
	}

	public Date getOpprStatusDate() {
		return this.opprStatusDate;
	}

	public void setOpprStatusDate(Date opprStatusDate) {
		this.opprStatusDate = opprStatusDate;
	}

	public String getOpprStatusDesc() {
		return this.opprStatusDesc;
	}

	public void setOpprStatusDesc(String opprStatusDesc) {
		this.opprStatusDesc = opprStatusDesc;
	}

	public int getOpprStatusId() {
		return this.opprStatusId;
	}

	public void setOpprStatusId(int opprStatusId) {
		this.opprStatusId = opprStatusId;
	}

	public String getOpprStudy() {
		return this.opprStudy;
	}

	public void setOpprStudy(String opprStudy) {
		this.opprStudy = opprStudy;
	}

	public int getOpprTeamId() {
		return this.opprTeamId;
	}

	public void setOpprTeamId(int opprTeamId) {
		this.opprTeamId = opprTeamId;
	}

	public String getOpprTitle() {
		return this.opprTitle;
	}

	public void setOpprTitle(String opprTitle) {
		this.opprTitle = opprTitle;
	}

	public int getOpprTravelAdults() {
		return this.opprTravelAdults;
	}

	public void setOpprTravelAdults(int opprTravelAdults) {
		this.opprTravelAdults = opprTravelAdults;
	}

	public int getOpprTravelChildren() {
		return this.opprTravelChildren;
	}

	public void setOpprTravelChildren(int opprTravelChildren) {
		this.opprTravelChildren = opprTravelChildren;
	}

	public Date getOpprTravelFromdate() {
		return this.opprTravelFromdate;
	}

	public void setOpprTravelFromdate(Date opprTravelFromdate) {
		this.opprTravelFromdate = opprTravelFromdate;
	}

	public int getOpprTravelRooms() {
		return this.opprTravelRooms;
	}

	public void setOpprTravelRooms(int opprTravelRooms) {
		this.opprTravelRooms = opprTravelRooms;
	}

	public Date getOpprTravelTodate() {
		return this.opprTravelTodate;
	}

	public void setOpprTravelTodate(Date opprTravelTodate) {
		this.opprTravelTodate = opprTravelTodate;
	}

	public int getOpprTraveltypeId() {
		return this.opprTraveltypeId;
	}

	public void setOpprTraveltypeId(int opprTraveltypeId) {
		this.opprTraveltypeId = opprTraveltypeId;
	}

	public short getOpprTrigger() {
		return this.opprTrigger;
	}

	public void setOpprTrigger(short opprTrigger) {
		this.opprTrigger = opprTrigger;
	}

	public AxelaBranch getAxelaBranch() {
		return axelaBranch;
	}

	public void setAxelaBranch(AxelaBranch axelaBranch) {
		this.axelaBranch = axelaBranch;
	}

	public AxelaCustomer getAxelaCustomer() {
		return axelaCustomer;
	}

	public void setAxelaCustomer(AxelaCustomer axelaCustomer) {
		this.axelaCustomer = axelaCustomer;
	}

	public AxelaCustomerContact getAxelaCustomerContact() {
		return axelaCustomerContact;
	}

	public void setAxelaCustomerContact(AxelaCustomerContact axelaCustomerContact) {
		this.axelaCustomerContact = axelaCustomerContact;
	}

	public AxelaEmp getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(AxelaEmp axelaEmp) {
		this.axelaEmp = axelaEmp;
	}

	public AxelaInventoryItem getAxelaInventoryItem() {
		return axelaInventoryItem;
	}

	public void setAxelaInventoryItem(AxelaInventoryItem axelaInventoryItem) {
		this.axelaInventoryItem = axelaInventoryItem;
	}

	public AxelaSalesOpprStage getAxelaSalesOpprStage() {
		return axelaSalesOpprStage;
	}

	public void setAxelaSalesOpprStage(AxelaSalesOpprStage axelaSalesOpprStage) {
		this.axelaSalesOpprStage = axelaSalesOpprStage;
	}

	public AxelaSalesOpprStatus getAxelaSalesOpprStatus() {
		return axelaSalesOpprStatus;
	}

	public void setAxelaSalesOpprStatus(AxelaSalesOpprStatus axelaSalesOpprStatus) {
		this.axelaSalesOpprStatus = axelaSalesOpprStatus;
	}

	public AxelaSalesOpprType getAxelaSalesOpprType() {
		return axelaSalesOpprType;
	}

	public void setAxelaSalesOpprType(AxelaSalesOpprType axelaSalesOpprType) {
		this.axelaSalesOpprType = axelaSalesOpprType;
	}

	public AxelaPm getAxelaPm() {
		return axelaPm;
	}

	public void setAxelaPm(AxelaPm axelaPm) {
		this.axelaPm = axelaPm;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oppr_pm_id", referencedColumnName = "pm_id", insertable = false, updatable = false)
	private AxelaPm axelaPm;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oppr_status_id", referencedColumnName = "status_id", insertable = false, updatable = false)
	private AxelaSalesOpprStatus axelaSalesOpprStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oppr_stage_id", referencedColumnName = "stage_id", insertable = false, updatable = false)
	private AxelaSalesOpprStage axelaSalesOpprStage;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oppr_branch_id", referencedColumnName = "branch_id", insertable = false, updatable = false)
	private AxelaBranch axelaBranch;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oppr_customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
	private AxelaCustomer axelaCustomer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oppr_contact_id", referencedColumnName = "contact_id", insertable = false, updatable = false)
	private AxelaCustomerContact axelaCustomerContact;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oppr_emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oppr_item_id", referencedColumnName = "item_id", insertable = false, updatable = false)
	private AxelaInventoryItem axelaInventoryItem;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oppr_opprtype_id", referencedColumnName = "opprtype_id", insertable = false, updatable = false)
	private AxelaSalesOpprType axelaSalesOpprType;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oppr_campaign_id", referencedColumnName = "campaign_id", insertable = false, updatable = false)
	private AxelaSalesCampaign axelaSalesCampaign;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "oppr_city_id", referencedColumnName = "city_id", insertable = false, updatable = false)
	private AxelaCity axelaCity;

	public String getCustomerAddress1() {
		return customerAddress1;
	}

	public void setCustomerAddress1(String customerAddress1) {
		this.customerAddress1 = customerAddress1;
	}

	public String getCustomerAddress2() {
		return customerAddress2;
	}

	public void setCustomerAddress2(String customerAddress2) {
		this.customerAddress2 = customerAddress2;
	}

	public String getCustomerLandmark() {
		return customerLandmark;
	}

	public void setCustomerLandmark(String customerLandmark) {
		this.customerLandmark = customerLandmark;
	}

	public String getCustomerMobile1() {
		return customerMobile1;
	}

	public void setCustomerMobile1(String customerMobile1) {
		this.customerMobile1 = customerMobile1;
	}

	public String getCustomerMobile2() {
		return customerMobile2;
	}

	public void setCustomerMobile2(String customerMobile2) {
		this.customerMobile2 = customerMobile2;
	}

	public Date getCustomerSince() {
		return customerSince;
	}

	public void setCustomerSince(Date customerSince) {
		this.customerSince = customerSince;
	}

	public String getCustomerActive() {
		return customerActive;
	}

	public void setCustomerActive(String customerActive) {
		this.customerActive = customerActive;
	}

	public String getCustomerNotes() {
		return customerNotes;
	}

	public void setCustomerNotes(String customerNotes) {
		this.customerNotes = customerNotes;
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}