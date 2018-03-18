package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * The persistent class for the axela_comp database table.
 * 
 */
@Entity
@Table(name = "axela_comp", catalog = "axela_1")
@NamedQuery(name = "AxelaComp.findAll", query = "SELECT a FROM AxelaComp a")
@Where(clause = "comp_active='1'")
public class AxelaComp implements Serializable {
	private static final long serialVersionUID = 1L;
	protected static final String comp_db = "axela_1";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "comp_id")
	private int compId;

	@Column(name = "comp_active")
	private String compActive;

	@Column(name = "comp_address")
	private String compAddress;

	@Column(name = "comp_branch_count")
	private int compBranchCount;

	@Column(name = "comp_businesstype_id")
	private int compBusinesstypeId;

	@Column(name = "comp_channel_entry_date")
	private String compChannelEntryDate;

	@Column(name = "comp_channel_entry_id")
	private int compChannelEntryId;

	@Column(name = "comp_channel_id")
	private int compChannelId;

	@Column(name = "comp_channel_modified_date")
	private String compChannelModifiedDate;

	@Column(name = "comp_channel_modified_id")
	private int compChannelModifiedId;

	@Column(name = "comp_channeluser_id")
	private int compChanneluserId;

	@Column(name = "comp_city_id")
	private int compCityId;

	@Column(name = "comp_contact")
	private String compContact;

	@Column(name = "comp_currbal")
	private double compCurrbal;

	@Column(name = "comp_deliverymode_id")
	private int compDeliverymodeId;

	@Column(name = "comp_email_enable")
	private String compEmailEnable;

	@Column(name = "comp_email1")
	private String compEmail1;

	@Column(name = "comp_email2")
	private String compEmail2;

	@Column(name = "comp_entry_date")
	private String compEntryDate;

	@Column(name = "comp_entry_id")
	private int compEntryId;

	@Column(name = "comp_executive_count")
	private int compExecutiveCount;

	@Column(name = "comp_export_count")
	private int compExportCount;

	@Column(name = "comp_franchisee_count")
	private int compFranchiseeCount;

	@Column(name = "comp_landmark")
	private String compLandmark;

	@Column(name = "comp_logo")
	private String compLogo;

	@Column(name = "comp_mobile1")
	private String compMobile1;

	@Column(name = "comp_mobile2")
	private String compMobile2;

	@Column(name = "comp_modified_date")
	private String compModifiedDate;

	@Column(name = "comp_modified_id")
	private int compModifiedId;

	@Column(name = "comp_module_accounting")
	private String compModuleAccounting;

	@Column(name = "comp_module_activity")
	private String compModuleActivity;

	@Column(name = "comp_module_asset")
	private String compModuleAsset;

	@Column(name = "comp_module_customer")
	private String compModuleCustomer;

	@Column(name = "comp_module_hcm")
	private String compModuleHcm;

	@Column(name = "comp_module_inventory")
	private String compModuleInventory;

	@Column(name = "comp_module_invoice")
	private String compModuleInvoice;

	@Column(name = "comp_module_marketing")
	private String compModuleMarketing;

	@Column(name = "comp_module_payroll")
	private String compModulePayroll;

	@Column(name = "comp_module_pm")
	private String compModulePm;

	@Column(name = "comp_module_portal")
	private String compModulePortal;

	@Column(name = "comp_module_pos")
	private String compModulePos;

	@Column(name = "comp_module_productcatalogue")
	private String compModuleProductcatalogue;

	@Column(name = "comp_module_production")
	private String compModuleProduction;

	@Column(name = "comp_module_sales")
	private String compModuleSales;

	@Column(name = "comp_module_service")
	private String compModuleService;

	@Column(name = "comp_module_helpdesk")
	private String compModuleHelpdesk;

	public String getCompModuleHelpdesk() {
		return compModuleHelpdesk;
	}

	public void setCompModuleHelpdesk(String compModuleHelpdesk) {
		this.compModuleHelpdesk = compModuleHelpdesk;
	}

	@Column(name = "comp_module_social")
	private String compModuleSocial;

	@Column(name = "comp_module_website")
	private String compModuleWebsite;

	@Column(name = "comp_name")
	private String compName;

	@Column(name = "comp_notes")
	private String compNotes;

	@Column(name = "comp_order_id")
	private int compOrderId;

	@Column(name = "comp_phone1")
	private String compPhone1;

	@Column(name = "comp_phone2")
	private String compPhone2;

	@Column(name = "comp_phone3")
	private String compPhone3;

	@Column(name = "comp_phone4")
	private String compPhone4;

	@Lob
	@Column(name = "comp_pic")
	private byte[] compPic;

	@Column(name = "comp_pin")
	private String compPin;

	@Column(name = "comp_prioritycomp_id")
	private int compPrioritycompId;

	@Column(name = "comp_sms_enable")
	private String compSmsEnable;

	@Column(name = "comp_subdomain")
	private String compSubdomain;

	@Column(name = "comp_title_id")
	private int compTitleId;

	@Column(name = "comp_type_id")
	private int compTypeId;

	@Column(name = "comp_website1")
	private String compWebsite1;

	@Column(name = "comp_website2")
	private String compWebsite2;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comp_businesstype_id", referencedColumnName = "businesstype_id", insertable = false, updatable = false)
	private AxelaBusinessType axelaBusinessType;

	// @ManyToOne
	// @JoinColumn(name = "comp_channel_id", referencedColumnName = "channel_id", insertable = false, updatable = false)
	// private AxelaChannel axelaChannel;
	//
	public AxelaComp() {
	}

	//
	// public AxelaChannel getAxelaChannel() {
	// return axelaChannel;
	// }
	//
	// public void setAxelaChannel(AxelaChannel axelaChannel) {
	// this.axelaChannel = axelaChannel;
	// }

	public AxelaBusinessType getAxelaBusinessType() {
		return axelaBusinessType;
	}

	public void setAxelaBusinessType(AxelaBusinessType axelaBusinessType) {
		this.axelaBusinessType = axelaBusinessType;
	}

	public int getCompId() {
		return this.compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public String getCompActive() {
		return this.compActive;
	}

	public void setCompActive(String compActive) {
		this.compActive = compActive;
	}

	public String getCompAddress() {
		return this.compAddress;
	}

	public void setCompAddress(String compAddress) {
		this.compAddress = compAddress;
	}

	public int getCompBranchCount() {
		return this.compBranchCount;
	}

	public void setCompBranchCount(int compBranchCount) {
		this.compBranchCount = compBranchCount;
	}

	public int getCompBusinesstypeId() {
		return this.compBusinesstypeId;
	}

	public void setCompBusinesstypeId(int compBusinesstypeId) {
		this.compBusinesstypeId = compBusinesstypeId;
	}

	public String getCompChannelEntryDate() {
		return this.compChannelEntryDate;
	}

	public void setCompChannelEntryDate(String compChannelEntryDate) {
		this.compChannelEntryDate = compChannelEntryDate;
	}

	public int getCompChannelEntryId() {
		return this.compChannelEntryId;
	}

	public void setCompChannelEntryId(int compChannelEntryId) {
		this.compChannelEntryId = compChannelEntryId;
	}

	public int getCompChannelId() {
		return this.compChannelId;
	}

	public void setCompChannelId(int compChannelId) {
		this.compChannelId = compChannelId;
	}

	public String getCompChannelModifiedDate() {
		return this.compChannelModifiedDate;
	}

	public void setCompChannelModifiedDate(String compChannelModifiedDate) {
		this.compChannelModifiedDate = compChannelModifiedDate;
	}

	public int getCompChannelModifiedId() {
		return this.compChannelModifiedId;
	}

	public void setCompChannelModifiedId(int compChannelModifiedId) {
		this.compChannelModifiedId = compChannelModifiedId;
	}

	public int getCompChanneluserId() {
		return this.compChanneluserId;
	}

	public void setCompChanneluserId(int compChanneluserId) {
		this.compChanneluserId = compChanneluserId;
	}

	public int getCompCityId() {
		return this.compCityId;
	}

	public void setCompCityId(int compCityId) {
		this.compCityId = compCityId;
	}

	public String getCompContact() {
		return this.compContact;
	}

	public void setCompContact(String compContact) {
		this.compContact = compContact;
	}

	public double getCompCurrbal() {
		return this.compCurrbal;
	}

	public void setCompCurrbal(double compCurrbal) {
		this.compCurrbal = compCurrbal;
	}

	public int getCompDeliverymodeId() {
		return this.compDeliverymodeId;
	}

	public void setCompDeliverymodeId(int compDeliverymodeId) {
		this.compDeliverymodeId = compDeliverymodeId;
	}

	public String getCompEmailEnable() {
		return this.compEmailEnable;
	}

	public void setCompEmailEnable(String compEmailEnable) {
		this.compEmailEnable = compEmailEnable;
	}

	public String getCompEmail1() {
		return this.compEmail1;
	}

	public void setCompEmail1(String compEmail1) {
		this.compEmail1 = compEmail1;
	}

	public String getCompEmail2() {
		return this.compEmail2;
	}

	public void setCompEmail2(String compEmail2) {
		this.compEmail2 = compEmail2;
	}

	public String getCompEntryDate() {
		return this.compEntryDate;
	}

	public void setCompEntryDate(String compEntryDate) {
		this.compEntryDate = compEntryDate;
	}

	public int getCompEntryId() {
		return this.compEntryId;
	}

	public void setCompEntryId(int compEntryId) {
		this.compEntryId = compEntryId;
	}

	public int getCompExecutiveCount() {
		return this.compExecutiveCount;
	}

	public void setCompExecutiveCount(int compExecutiveCount) {
		this.compExecutiveCount = compExecutiveCount;
	}

	public int getCompExportCount() {
		return this.compExportCount;
	}

	public void setCompExportCount(int compExportCount) {
		this.compExportCount = compExportCount;
	}

	public int getCompFranchiseeCount() {
		return this.compFranchiseeCount;
	}

	public void setCompFranchiseeCount(int compFranchiseeCount) {
		this.compFranchiseeCount = compFranchiseeCount;
	}

	public String getCompLandmark() {
		return this.compLandmark;
	}

	public void setCompLandmark(String compLandmark) {
		this.compLandmark = compLandmark;
	}

	public String getCompLogo() {
		return this.compLogo;
	}

	public void setCompLogo(String compLogo) {
		this.compLogo = compLogo;
	}

	public String getCompMobile1() {
		return this.compMobile1;
	}

	public void setCompMobile1(String compMobile1) {
		this.compMobile1 = compMobile1;
	}

	public String getCompMobile2() {
		return this.compMobile2;
	}

	public void setCompMobile2(String compMobile2) {
		this.compMobile2 = compMobile2;
	}

	public String getCompModifiedDate() {
		return this.compModifiedDate;
	}

	public void setCompModifiedDate(String compModifiedDate) {
		this.compModifiedDate = compModifiedDate;
	}

	public int getCompModifiedId() {
		return this.compModifiedId;
	}

	public void setCompModifiedId(int compModifiedId) {
		this.compModifiedId = compModifiedId;
	}

	public String getCompModuleAccounting() {
		return this.compModuleAccounting;
	}

	public void setCompModuleAccounting(String compModuleAccounting) {
		this.compModuleAccounting = compModuleAccounting;
	}

	public String getCompModuleActivity() {
		return this.compModuleActivity;
	}

	public void setCompModuleActivity(String compModuleActivity) {
		this.compModuleActivity = compModuleActivity;
	}

	public String getCompModuleAsset() {
		return this.compModuleAsset;
	}

	public void setCompModuleAsset(String compModuleAsset) {
		this.compModuleAsset = compModuleAsset;
	}

	public String getCompModuleCustomer() {
		return this.compModuleCustomer;
	}

	public void setCompModuleCustomer(String compModuleCustomer) {
		this.compModuleCustomer = compModuleCustomer;
	}

	public String getCompModuleHcm() {
		return this.compModuleHcm;
	}

	public void setCompModuleHcm(String compModuleHcm) {
		this.compModuleHcm = compModuleHcm;
	}

	public String getCompModuleInventory() {
		return this.compModuleInventory;
	}

	public void setCompModuleInventory(String compModuleInventory) {
		this.compModuleInventory = compModuleInventory;
	}

	public String getCompModuleInvoice() {
		return this.compModuleInvoice;
	}

	public void setCompModuleInvoice(String compModuleInvoice) {
		this.compModuleInvoice = compModuleInvoice;
	}

	public String getCompModuleMarketing() {
		return this.compModuleMarketing;
	}

	public void setCompModuleMarketing(String compModuleMarketing) {
		this.compModuleMarketing = compModuleMarketing;
	}

	public String getCompModulePayroll() {
		return this.compModulePayroll;
	}

	public void setCompModulePayroll(String compModulePayroll) {
		this.compModulePayroll = compModulePayroll;
	}

	public String getCompModulePm() {
		return this.compModulePm;
	}

	public void setCompModulePm(String compModulePm) {
		this.compModulePm = compModulePm;
	}

	public String getCompModulePortal() {
		return this.compModulePortal;
	}

	public void setCompModulePortal(String compModulePortal) {
		this.compModulePortal = compModulePortal;
	}

	public String getCompModulePos() {
		return this.compModulePos;
	}

	public void setCompModulePos(String compModulePos) {
		this.compModulePos = compModulePos;
	}

	public String getCompModuleProductcatalogue() {
		return this.compModuleProductcatalogue;
	}

	public void setCompModuleProductcatalogue(String compModuleProductcatalogue) {
		this.compModuleProductcatalogue = compModuleProductcatalogue;
	}

	public String getCompModuleProduction() {
		return this.compModuleProduction;
	}

	public void setCompModuleProduction(String compModuleProduction) {
		this.compModuleProduction = compModuleProduction;
	}

	public String getCompModuleSales() {
		return this.compModuleSales;
	}

	public void setCompModuleSales(String compModuleSales) {
		this.compModuleSales = compModuleSales;
	}

	public String getCompModuleService() {
		return this.compModuleService;
	}

	public void setCompModuleService(String compModuleService) {
		this.compModuleService = compModuleService;
	}

	public String getCompModuleSocial() {
		return this.compModuleSocial;
	}

	public void setCompModuleSocial(String compModuleSocial) {
		this.compModuleSocial = compModuleSocial;
	}

	public String getCompModuleWebsite() {
		return this.compModuleWebsite;
	}

	public void setCompModuleWebsite(String compModuleWebsite) {
		this.compModuleWebsite = compModuleWebsite;
	}

	public String getCompName() {
		return this.compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompNotes() {
		return this.compNotes;
	}

	public void setCompNotes(String compNotes) {
		this.compNotes = compNotes;
	}

	public int getCompOrderId() {
		return this.compOrderId;
	}

	public void setCompOrderId(int compOrderId) {
		this.compOrderId = compOrderId;
	}

	public String getCompPhone1() {
		return this.compPhone1;
	}

	public void setCompPhone1(String compPhone1) {
		this.compPhone1 = compPhone1;
	}

	public String getCompPhone2() {
		return this.compPhone2;
	}

	public void setCompPhone2(String compPhone2) {
		this.compPhone2 = compPhone2;
	}

	public String getCompPhone3() {
		return this.compPhone3;
	}

	public void setCompPhone3(String compPhone3) {
		this.compPhone3 = compPhone3;
	}

	public String getCompPhone4() {
		return this.compPhone4;
	}

	public void setCompPhone4(String compPhone4) {
		this.compPhone4 = compPhone4;
	}

	public byte[] getCompPic() {
		return this.compPic;
	}

	public void setCompPic(byte[] compPic) {
		this.compPic = compPic;
	}

	public String getCompPin() {
		return this.compPin;
	}

	public void setCompPin(String compPin) {
		this.compPin = compPin;
	}

	public int getCompPrioritycompId() {
		return this.compPrioritycompId;
	}

	public void setCompPrioritycompId(int compPrioritycompId) {
		this.compPrioritycompId = compPrioritycompId;
	}

	public String getCompSmsEnable() {
		return this.compSmsEnable;
	}

	public void setCompSmsEnable(String compSmsEnable) {
		this.compSmsEnable = compSmsEnable;
	}

	public String getCompSubdomain() {
		return this.compSubdomain;
	}

	public void setCompSubdomain(String compSubdomain) {
		this.compSubdomain = compSubdomain;
	}

	public int getCompTitleId() {
		return this.compTitleId;
	}

	public void setCompTitleId(int compTitleId) {
		this.compTitleId = compTitleId;
	}

	public int getCompTypeId() {
		return this.compTypeId;
	}

	public void setCompTypeId(int compTypeId) {
		this.compTypeId = compTypeId;
	}

	public String getCompWebsite1() {
		return this.compWebsite1;
	}

	public void setCompWebsite1(String compWebsite1) {
		this.compWebsite1 = compWebsite1;
	}

	public String getCompWebsite2() {
		return this.compWebsite2;
	}

	public void setCompWebsite2(String compWebsite2) {
		this.compWebsite2 = compWebsite2;
	}

}