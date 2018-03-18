package axela.service.model;

import java.util.Date;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import axela.customer.model.AxelaCustomer;
import axela.customer.model.AxelaCustomerContact;
import axela.inventory.model.AxelaInventoryItem;
import axela.portal.model.AxelaBranch;
import axela.portal.model.AxelaEmp;

/**
 * The persistent class for the axela_service_jc database table.
 * 
 */
@Entity
@Table(name = "axela_service_jc", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceJc.findAll", query = "SELECT a FROM AxelaServiceJc a")
public class AxelaServiceJc {
	private static final long serialVersionUID = 1L;
	// =========================================LEFT JOIN variables=================================
	@Transient
	private String jcTypeName = "";
	@Transient
	private String branchCode = "";
	@Transient
	private String jcCatName = "";//
	@Transient
	private String jcPriorityName = "";//
	@Transient
	private String jcStatusName = "";//
	@Transient
	private String jcModelName = "";//
	@Transient
	private String jcItemName = "";//
	@Transient
	private String jcCustomerName = "";//
	@Transient
	private String jcBranchName = "";//
	@Transient
	private String titleDesc = "";
	@Transient
	private int empId = 0;
	@Transient
	private int itemModelId = 0;
	@Transient
	private long jcCount = 0L;
	@Transient
	private double jcTotal = 0.0;

	// =========================================Entity variables====================================

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "jc_id")
	private int jcId;

	@Column(name = "jc_active")
	private String jcActive;

	@Lob
	@Column(name = "jc_advice")
	private String jcAdvice;

	@Column(name = "jc_auth")
	private String jcAuth;

	@Column(name = "jc_auth_date")
	private Date jcAuthDate;

	@Column(name = "jc_auth_id")
	private int jcAuthId;

	@Column(name = "jc_bay_id")
	private int jcBayId;

	@Column(name = "jc_bill_address")
	private String jcBillAddress;

	@Column(name = "jc_bill_city")
	private String jcBillCity;

	@Column(name = "jc_bill_country")
	private String jcBillCountry;

	@Column(name = "jc_bill_pin")
	private String jcBillPin;

	@Column(name = "jc_bill_state")
	private String jcBillState;

	@Column(name = "jc_branch_id")
	private int jcBranchId;

	@Column(name = "jc_contact_id")
	private int jcContactId;

	@Column(name = "jc_critical")
	private String jcCritical;

	@Column(name = "jc_customer_id")
	private int jcCustomerId;

	@Lob
	@Column(name = "jc_customer_voice")
	private String jcCustomerVoice;

	@Column(name = "jc_del_address")
	private String jcDelAddress;

	@Column(name = "jc_del_city")
	private String jcDelCity;

	@Column(name = "jc_del_country")
	private String jcDelCountry;

	@Column(name = "jc_del_pin")
	private String jcDelPin;

	@Column(name = "jc_del_state")
	private String jcDelState;

	@Column(name = "jc_discamt")
	private double jcDiscamt;

	@Column(name = "jc_emp_id")
	private int jcEmpId;

	@Column(name = "jc_entry_date")
	private Date jcEntryDate;

	@Column(name = "jc_entry_id")
	private int jcEntryId;

	@Column(name = "jc_grandtotal")
	private double jcGrandtotal;

	@Lob
	@Column(name = "jc_instructions")
	private String jcInstructions;

	@Column(name = "jc_item_id")
	private int jcItemId;

	@Column(name = "jc_jccat_id")
	private int jcJccatId;

	@Column(name = "jc_jcstatus_id")
	private int jcJcstatusId;

	@Column(name = "jc_jctype_id")
	private int jcJctypeId;

	@Column(name = "jc_location_id")
	private int jcLocationId;

	@Column(name = "jc_modified_date")
	private Date jcModifiedDate;

	@Column(name = "jc_modified_id")
	private int jcModifiedId;

	@Column(name = "jc_netamt")
	private double jcNetamt;

	@Column(name = "jc_no")
	private int jcNo;

	@Lob
	@Column(name = "jc_notes")
	private String jcNotes;

	@Column(name = "jc_open")
	private String jcOpen;

	@Column(name = "jc_priority_trigger")
	private int jcPriorityTrigger;

	@Column(name = "jc_priorityjc_id")
	private int jcPriorityjcId;

	@Column(name = "jc_refno")
	private String jcRefno;

	@Column(name = "jc_ro_no")
	private String jcRoNo;

	@Column(name = "jc_serialno")
	private String jcSerialno;

	@Column(name = "jc_status_trigger")
	private int jcStatusTrigger;

	@Column(name = "jc_technician_emp_id")
	private int jcTechnicianEmpId;

	@Lob
	@Column(name = "jc_terms")
	private String jcTerms;

	@Column(name = "jc_time_in")
	private Date jcTimeIn;

	@Column(name = "jc_time_out")
	private Date jcTimeOut;

	@Column(name = "jc_time_promised")
	private Date jcTimePromised;

	@Column(name = "jc_time_ready")
	private Date jcTimeReady;

	@Column(name = "jc_title")
	private String jcTitle;

	@Column(name = "jc_totaltax")
	private double jcTotaltax;

	@Transient
	private String contactFname = "";
	@Transient
	private String contactLname = "";
	@Transient
	private String contactName = "";
	@Transient
	private int contactTitleId = 0;

	public String getContactFname() {
		return contactFname;
	}

	public void setContactFname(String contactFname) {
		this.contactFname = contactFname;
	}

	public String getContactEmail1() {
		return contactEmail1;
	}

	public void setContactEmail1(String contactEmail1) {
		this.contactEmail1 = contactEmail1;
	}

	public String getContactMobile1() {
		return contactMobile1;
	}

	public void setContactMobile1(String contactMobile1) {
		this.contactMobile1 = contactMobile1;
	}

	@Transient
	private String contactEmail1 = "";
	@Transient
	private String contactMobile1 = "";
	@Transient
	private String contactPhone1 = "";
	@Transient
	private String contactPhone2 = "";

	@Transient
	private String contactAddress = "";
	@Transient
	private String contactEmail2 = "";
	@Transient
	private String contactMobile2 = "";
	@Transient
	private String contactPin = "";
	@Transient
	private String contactCityId = "";

	public String getContactPhone1() {
		return contactPhone1;
	}

	public void setContactPhone1(String contactPhone1) {
		this.contactPhone1 = contactPhone1;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactPin() {
		return contactPin;
	}

	public void setContactPin(String contactPin) {
		this.contactPin = contactPin;
	}

	@Transient
	private String empName = "";
	public long getMonthjc() {
		return monthjc;
	}

	public void setMonthjc(long monthjc) {
		this.monthjc = monthjc;
	}

	public long getTodayjc() {
		return todayjc;
	}

	public void setTodayjc(long todayjc) {
		this.todayjc = todayjc;
	}

	public long getTotaljc() {
		return totaljc;
	}

	public void setTotaljc(long totaljc) {
		this.totaljc = totaljc;
	}

	@Transient
	private long monthjc;
	@Transient
	private long todayjc;
	@Transient
	private long totaljc;
	@Transient
	private long level1jc;
	@Transient
	private long level2jc;
	@Transient
	private long level3jc;
	@Transient
	private long level4jc;
	@Transient
	private long level5jc;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getJcTypeName() {
		return jcTypeName;
	}

	public void setJcTypeName(String jcTypeName) {
		this.jcTypeName = jcTypeName;
	}

	public String getJcCatName() {
		return jcCatName;
	}

	public void setJcCatName(String jcCatName) {
		this.jcCatName = jcCatName;
	}

	public String getJcPriorityName() {
		return jcPriorityName;
	}

	public void setJcPriorityName(String jcPriorityName) {
		this.jcPriorityName = jcPriorityName;
	}

	public String getJcStatusName() {
		return jcStatusName;
	}

	public void setJcStatusName(String jcStatusName) {
		this.jcStatusName = jcStatusName;
	}

	public String getJcModelName() {
		return jcModelName;
	}

	public void setJcModelName(String jcModelName) {
		this.jcModelName = jcModelName;
	}

	public String getJcItemName() {
		return jcItemName;
	}

	public void setJcItemName(String jcItemName) {
		this.jcItemName = jcItemName;
	}

	public String getJcCustomerName() {
		return jcCustomerName;
	}

	public void setJcCustomerName(String jcCustomerName) {
		this.jcCustomerName = jcCustomerName;
	}

	public String getJcBranchName() {
		return jcBranchName;
	}

	public void setJcBranchName(String jcBranchName) {
		this.jcBranchName = jcBranchName;
	}

	public AxelaServiceJc() {

	}
	public AxelaServiceJc(
			int jcId,
			String jcActive,
			String jcTitle,
			Date jcTimeIn,
			String jcRefno,
			String jcCustomerVoice,
			String jcCatName,
			// int jcNo,
			int jcEmpId,
			int jcBranchId,
			int jcCustomerId,
			int jcContactId,
			String jcCustomerName,
			String contactName,
			String contactEmail1,
			String contactMobile1,
			String contactEmail2,
			String contactMobile2,
			String jcPriorityName,
			String jcStatusName,
			String jcModelName,
			double jcGrandtotal,
			String jcItemName,
			String jcTypeName,
			String jcBranchName,
			String empName,
			String branchCode,
			String jcAuth

	) {
		// " a.jcActive,"
		// + " a.jcTitle,"
		// + " a.jcTimeIn,"
		// + " a.jcRefno,"
		// + " a.jcCustomerVoice,";
		super();
		this.jcId = jcId;
		this.jcActive = jcActive;
		this.jcTitle = jcTitle;
		this.jcTimeIn = jcTimeIn;
		this.jcRefno = jcRefno;
		this.jcCustomerVoice = jcCustomerVoice;
		this.jcCatName = jcCatName;
		this.jcEmpId = jcEmpId;
		this.jcBranchId = jcBranchId;
		this.jcCustomerId = jcCustomerId;
		this.jcContactId = jcContactId;
		// this.jcNo = Integer.parseInt(jcNo);
		this.jcNo = jcNo;
		this.jcCustomerName = jcCustomerName;
		this.contactName = contactName;
		this.contactEmail1 = contactEmail1;
		this.contactMobile1 = contactMobile1;
		this.contactEmail2 = contactEmail2;
		this.contactMobile2 = contactMobile2;
		this.jcPriorityName = jcPriorityName;
		this.jcStatusName = jcStatusName;
		this.jcModelName = jcModelName;
		this.jcGrandtotal = jcGrandtotal;
		this.jcItemName = jcItemName;
		this.jcTypeName = jcTypeName;
		this.jcBranchName = jcBranchName;
		this.empName = empName;
		this.branchCode = branchCode;
		this.jcAuth = jcAuth;

	}
	public AxelaServiceJc(long monthjc,
			long todayjc, long totaljc, long level1jc,
			long level2jc, long level3jc, long level4jc, long level5jc) {
		super();
		this.monthjc = monthjc;
		this.todayjc = todayjc;
		this.totaljc = totaljc;
		this.level1jc = level1jc;
		this.level2jc = level2jc;
		this.level3jc = level3jc;
		this.level4jc = level4jc;
		this.level5jc = level5jc;

	}

	public AxelaServiceJc(
			int empId,
			String empName,
			long jcCount,
			double jcTotal) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.jcCount = jcCount;
		this.jcTotal = jcTotal;
	}

	public AxelaServiceJc(
			int jcId,
			int jcNo,
			int jcBranchId,
			Date jcTimeIn,
			Date jcTimeOut,
			Date jcTimeReady,
			Date jcTimePromised,
			int jcEmpId,
			String jcBranchName,
			int jcTechnicianEmpId,
			String jcRoNo,
			int jcItemId,
			int itemModelId,
			int jcJctypeId,
			int jcJccatId,
			int jcBayId,
			int jcLocationId,
			String jcTitle,
			String jcCustomerVoice,
			String jcAdvice,
			String jcTerms,
			String jcInstructions,
			int jcCustomerId,
			int jcContactId,
			String jcRefno,
			String jcSerialno,
			int jcPriorityjcId,
			String jcNotes,
			int jcJcstatusId,
			String jcCustomerName,
			String jcCritical,
			int contactTitleId,
			String contactFname,
			String contactLname,
			String contactPhone1,
			String contactMobile1,
			String contactEmail1,
			String contactAddress,
			String contactPin,
			String contactCityId,
			int jcEntryId,
			Date jcEntryDate,
			int jcModifiedId,
			Date jcModifiedDate,
			String jcBillAddress,
			String jcBillCity,
			String jcBillCountry,
			String jcBillPin,
			String jcBillState,
			String jcDelAddress,
			String jcDelCity,
			String jcDelCountry,
			String jcDelPin,
			String jcDelState,
			String jcActive) {
		super();
		this.jcId = jcId;
		this.jcNo = jcNo;
		this.jcBranchId = jcBranchId;
		this.jcTimeIn = jcTimeIn;
		this.jcTimeOut = jcTimeOut;
		this.jcTimeReady = jcTimeReady;
		this.jcTimePromised = jcTimePromised;
		this.jcEmpId = jcEmpId;
		this.jcBranchName = jcBranchName;
		this.jcTechnicianEmpId = jcTechnicianEmpId;
		this.jcRoNo = jcRoNo;
		this.jcItemId = jcItemId;
		this.itemModelId = itemModelId;
		this.jcJctypeId = jcJctypeId;
		this.jcJccatId = jcJccatId;
		this.jcBayId = jcBayId;
		this.jcLocationId = jcLocationId;
		this.jcTitle = jcTitle;
		this.jcCustomerVoice = jcCustomerVoice;
		this.jcAdvice = jcAdvice;
		this.jcTerms = jcTerms;
		this.jcInstructions = jcInstructions;
		this.jcCustomerId = jcCustomerId;
		this.jcContactId = jcContactId;
		this.jcRefno = jcRefno;
		this.jcSerialno = jcSerialno;
		this.jcPriorityjcId = jcPriorityjcId;
		this.jcNotes = jcNotes;
		this.jcJcstatusId = jcJcstatusId;
		this.jcCustomerName = jcCustomerName;
		this.jcCritical = jcCritical;
		this.contactTitleId = contactTitleId;
		this.contactFname = contactFname;
		this.contactLname = contactLname;
		this.contactPhone1 = contactPhone1;
		this.contactMobile1 = contactMobile1;
		this.contactEmail1 = contactEmail1;
		this.contactAddress = contactAddress;
		this.contactPin = contactPin;
		this.contactCityId = contactCityId;
		this.jcEntryId = jcEntryId;
		this.jcEntryDate = jcEntryDate;
		this.jcModifiedId = jcModifiedId;
		this.jcModifiedDate = jcModifiedDate;
		this.jcBillAddress = jcBillAddress;
		this.jcBillCity = jcBillCity;
		this.jcBillCountry = jcBillCountry;
		this.jcBillPin = jcBillPin;
		this.jcBillState = jcBillState;
		this.jcDelAddress = jcDelAddress;
		this.jcDelCity = jcDelCity;
		this.jcDelCountry = jcDelCountry;
		this.jcDelPin = jcDelPin;
		this.jcDelState = jcDelState;
		this.jcActive = jcActive;
	}

	public int getItemModelId() {
		return itemModelId;
	}

	public void setItemModelId(int itemModelId) {
		this.itemModelId = itemModelId;
	}

	public AxelaServiceJc(
			int jcId,
			Date jcEntryDate,
			int jcCustomerId,
			int jcContactId,
			String titleDesc,
			String jcBranchName,
			String jcCustomerName,
			int contactTitleId,
			String contactPhone1,
			String contactAddress,
			String contactPin,
			String contactFname,
			String contactLname,
			String contactMobile1,
			String contactEmail1,
			String contactMobile2,
			String contactEmail2

	) {
		super();
		this.jcId = jcId;
		this.jcEntryDate = jcEntryDate;
		this.jcCustomerId = jcCustomerId;
		this.jcContactId = jcContactId;
		this.titleDesc = titleDesc;
		this.jcBranchName = jcBranchName;
		this.jcCustomerName = jcCustomerName;
		this.contactTitleId = contactTitleId;
		this.contactPhone1 = contactPhone1;
		this.contactAddress = contactAddress;
		this.contactPin = contactPin;
		this.contactFname = contactFname;
		this.contactLname = contactLname;
		this.contactMobile1 = contactMobile1;
		this.contactEmail1 = contactEmail1;
		this.contactMobile2 = contactMobile2;
		this.contactEmail2 = contactEmail2;
	}

	public AxelaServiceJc(
			int jcBranchId,
			Date jcTimeReady,
			int empId) {
		super();
		this.jcBranchId = jcBranchId;
		this.jcTimeReady = jcTimeReady;
		this.empId = empId;
	}

	public String getTitleDesc() {
		return titleDesc;
	}

	public void setTitleDesc(String titleDesc) {
		this.titleDesc = titleDesc;
	}

	public String getContactPhone2() {
		return contactPhone2;
	}

	public void setContactPhone2(String contactPhone2) {
		this.contactPhone2 = contactPhone2;
	}

	public AxelaCustomer getAxelaCustomer() {
		return axelaCustomer;
	}

	public void setAxelaCustomer(AxelaCustomer axelaCustomer) {
		this.axelaCustomer = axelaCustomer;
	}

	// end constructor for opportunity dash board populate
	public String getContactCityId() {
		return contactCityId;
	}

	public void setContactCityId(String contactCityId) {
		this.contactCityId = contactCityId;
	}

	public int getContactTitleId() {
		return contactTitleId;
	}

	public void setContactTitleId(int contactTitleId) {
		this.contactTitleId = contactTitleId;
	}

	public long getLevel2jc() {
		return level2jc;
	}

	public void setLevel2jc(long level2jc) {
		this.level2jc = level2jc;
	}

	public long getLevel3jc() {
		return level3jc;
	}

	public void setLevel3jc(long level3jc) {
		this.level3jc = level3jc;
	}

	public long getLevel4jc() {
		return level4jc;
	}

	public void setLevel4jc(long level4jc) {
		this.level4jc = level4jc;
	}

	public long getLevel5jc() {
		return level5jc;
	}

	public void setLevel5jc(long level5jc) {
		this.level5jc = level5jc;
	}

	public long getLevel1jc() {
		return level1jc;
	}

	public void setLevel1jc(long level1jc) {
		this.level1jc = level1jc;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getContactEmail2() {
		return contactEmail2;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public void setContactEmail2(String contactEmail2) {
		this.contactEmail2 = contactEmail2;
	}

	public String getContactMobile2() {
		return contactMobile2;
	}

	public void setContactMobile2(String contactMobile2) {
		this.contactMobile2 = contactMobile2;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactLname() {
		return contactLname;
	}

	public void setContactLname(String contactLname) {
		this.contactLname = contactLname;
	}

	public int getJcId() {
		return this.jcId;
	}

	public void setJcId(int jcId) {
		this.jcId = jcId;
	}

	public String getJcActive() {
		return this.jcActive;
	}

	public void setJcActive(String jcActive) {
		this.jcActive = jcActive;
	}

	public String getJcAdvice() {
		return this.jcAdvice;
	}

	public void setJcAdvice(String jcAdvice) {
		this.jcAdvice = jcAdvice;
	}

	public String getJcAuth() {
		return this.jcAuth;
	}

	public void setJcAuth(String jcAuth) {
		this.jcAuth = jcAuth;
	}

	public Date getJcAuthDate() {
		return this.jcAuthDate;
	}

	public void setJcAuthDate(Date jcAuthDate) {
		this.jcAuthDate = jcAuthDate;
	}

	public int getJcAuthId() {
		return this.jcAuthId;
	}

	public void setJcAuthId(int jcAuthId) {
		this.jcAuthId = jcAuthId;
	}

	public int getJcBayId() {
		return this.jcBayId;
	}

	public void setJcBayId(int jcBayId) {
		this.jcBayId = jcBayId;
	}

	public String getJcBillAddress() {
		return this.jcBillAddress;
	}

	public void setJcBillAddress(String jcBillAddress) {
		this.jcBillAddress = jcBillAddress;
	}

	public String getJcBillCity() {
		return this.jcBillCity;
	}

	public void setJcBillCity(String jcBillCity) {
		this.jcBillCity = jcBillCity;
	}

	public String getJcBillCountry() {
		return this.jcBillCountry;
	}

	public void setJcBillCountry(String jcBillCountry) {
		this.jcBillCountry = jcBillCountry;
	}

	public String getJcBillPin() {
		return this.jcBillPin;
	}

	public void setJcBillPin(String jcBillPin) {
		this.jcBillPin = jcBillPin;
	}

	public String getJcBillState() {
		return this.jcBillState;
	}

	public void setJcBillState(String jcBillState) {
		this.jcBillState = jcBillState;
	}

	public int getJcBranchId() {
		return this.jcBranchId;
	}

	public void setJcBranchId(int jcBranchId) {
		this.jcBranchId = jcBranchId;
	}

	public int getJcContactId() {
		return this.jcContactId;
	}

	public void setJcContactId(int jcContactId) {
		this.jcContactId = jcContactId;
	}

	public String getJcCritical() {
		return this.jcCritical;
	}

	public void setJcCritical(String jcCritical) {
		this.jcCritical = jcCritical;
	}

	public int getJcCustomerId() {
		return this.jcCustomerId;
	}

	public void setJcCustomerId(int jcCustomerId) {
		this.jcCustomerId = jcCustomerId;
	}

	public String getJcCustomerVoice() {
		return this.jcCustomerVoice;
	}

	public void setJcCustomerVoice(String jcCustomerVoice) {
		this.jcCustomerVoice = jcCustomerVoice;
	}

	public String getJcDelAddress() {
		return this.jcDelAddress;
	}

	public void setJcDelAddress(String jcDelAddress) {
		this.jcDelAddress = jcDelAddress;
	}

	public String getJcDelCity() {
		return this.jcDelCity;
	}

	public void setJcDelCity(String jcDelCity) {
		this.jcDelCity = jcDelCity;
	}

	public String getJcDelCountry() {
		return this.jcDelCountry;
	}

	public void setJcDelCountry(String jcDelCountry) {
		this.jcDelCountry = jcDelCountry;
	}

	public String getJcDelPin() {
		return this.jcDelPin;
	}

	public void setJcDelPin(String jcDelPin) {
		this.jcDelPin = jcDelPin;
	}

	public String getJcDelState() {
		return this.jcDelState;
	}

	public void setJcDelState(String jcDelState) {
		this.jcDelState = jcDelState;
	}

	public double getJcDiscamt() {
		return this.jcDiscamt;
	}

	public void setJcDiscamt(double jcDiscamt) {
		this.jcDiscamt = jcDiscamt;
	}

	public int getJcEmpId() {
		return this.jcEmpId;
	}

	public void setJcEmpId(int jcEmpId) {
		this.jcEmpId = jcEmpId;
	}

	public Date getJcEntryDate() {
		return this.jcEntryDate;
	}

	public void setJcEntryDate(Date jcEntryDate) {
		this.jcEntryDate = jcEntryDate;
	}

	public int getJcEntryId() {
		return this.jcEntryId;
	}

	public void setJcEntryId(int jcEntryId) {
		this.jcEntryId = jcEntryId;
	}

	public double getJcGrandtotal() {
		return this.jcGrandtotal;
	}

	public void setJcGrandtotal(double jcGrandtotal) {
		this.jcGrandtotal = jcGrandtotal;
	}

	public String getJcInstructions() {
		return this.jcInstructions;
	}

	public void setJcInstructions(String jcInstructions) {
		this.jcInstructions = jcInstructions;
	}

	public int getJcItemId() {
		return this.jcItemId;
	}

	public void setJcItemId(int jcItemId) {
		this.jcItemId = jcItemId;
	}

	public int getJcJccatId() {
		return this.jcJccatId;
	}

	public void setJcJccatId(int jcJccatId) {
		this.jcJccatId = jcJccatId;
	}

	public int getJcJcstatusId() {
		return this.jcJcstatusId;
	}

	public void setJcJcstatusId(int jcJcstatusId) {
		this.jcJcstatusId = jcJcstatusId;
	}

	public int getJcJctypeId() {
		return this.jcJctypeId;
	}

	public void setJcJctypeId(int jcJctypeId) {
		this.jcJctypeId = jcJctypeId;
	}

	public int getJcLocationId() {
		return this.jcLocationId;
	}

	public void setJcLocationId(int jcLocationId) {
		this.jcLocationId = jcLocationId;
	}

	public Date getJcModifiedDate() {
		return this.jcModifiedDate;
	}

	public void setJcModifiedDate(Date jcModifiedDate) {
		this.jcModifiedDate = jcModifiedDate;
	}

	public int getJcModifiedId() {
		return this.jcModifiedId;
	}

	public void setJcModifiedId(int jcModifiedId) {
		this.jcModifiedId = jcModifiedId;
	}

	public double getJcNetamt() {
		return this.jcNetamt;
	}

	public void setJcNetamt(double jcNetamt) {
		this.jcNetamt = jcNetamt;
	}

	public int getJcNo() {
		return this.jcNo;
	}

	public void setJcNo(int jcNo) {
		this.jcNo = jcNo;
	}

	public String getJcNotes() {
		return this.jcNotes;
	}

	public void setJcNotes(String jcNotes) {
		this.jcNotes = jcNotes;
	}

	public String getJcOpen() {
		return this.jcOpen;
	}

	public void setJcOpen(String jcOpen) {
		this.jcOpen = jcOpen;
	}

	public int getJcPriorityTrigger() {
		return this.jcPriorityTrigger;
	}

	public void setJcPriorityTrigger(int jcPriorityTrigger) {
		this.jcPriorityTrigger = jcPriorityTrigger;
	}

	public int getJcPriorityjcId() {
		return this.jcPriorityjcId;
	}

	public void setJcPriorityjcId(int jcPriorityjcId) {
		this.jcPriorityjcId = jcPriorityjcId;
	}

	public String getJcRefno() {
		return this.jcRefno;
	}

	public void setJcRefno(String jcRefno) {
		this.jcRefno = jcRefno;
	}

	public String getJcRoNo() {
		return this.jcRoNo;
	}

	public void setJcRoNo(String jcRoNo) {
		this.jcRoNo = jcRoNo;
	}

	public String getJcSerialno() {
		return this.jcSerialno;
	}

	public void setJcSerialno(String jcSerialno) {
		this.jcSerialno = jcSerialno;
	}

	public int getJcStatusTrigger() {
		return this.jcStatusTrigger;
	}

	public void setJcStatusTrigger(int jcStatusTrigger) {
		this.jcStatusTrigger = jcStatusTrigger;
	}

	public int getJcTechnicianEmpId() {
		return this.jcTechnicianEmpId;
	}

	public void setJcTechnicianEmpId(int jcTechnicianEmpId) {
		this.jcTechnicianEmpId = jcTechnicianEmpId;
	}

	public String getJcTerms() {
		return this.jcTerms;
	}

	public void setJcTerms(String jcTerms) {
		this.jcTerms = jcTerms;
	}

	public Date getJcTimeIn() {
		return this.jcTimeIn;
	}

	public void setJcTimeIn(Date jcTimeIn) {
		this.jcTimeIn = jcTimeIn;
	}

	public Date getJcTimeOut() {
		return this.jcTimeOut;
	}

	public void setJcTimeOut(Date jcTimeOut) {
		this.jcTimeOut = jcTimeOut;
	}

	public Date getJcTimePromised() {
		return this.jcTimePromised;
	}

	public void setJcTimePromised(Date jcTimePromised) {
		this.jcTimePromised = jcTimePromised;
	}

	public Date getJcTimeReady() {
		return this.jcTimeReady;
	}

	public void setJcTimeReady(Date jcTimeReady) {
		this.jcTimeReady = jcTimeReady;
	}

	public String getJcTitle() {
		return this.jcTitle;
	}

	public void setJcTitle(String jcTitle) {
		this.jcTitle = jcTitle;
	}

	public double getJcTotaltax() {
		return this.jcTotaltax;
	}

	public void setJcTotaltax(double jcTotaltax) {
		this.jcTotaltax = jcTotaltax;
	}
	// =========================================Entity Relationships====================================

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jc_bay_id", referencedColumnName = "bay_id", insertable = false, updatable = false)
	private AxelaServiceJcBay axelaServiceJcBay;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jc_jccat_id", referencedColumnName = "jccat_id", insertable = false, updatable = false)
	private AxelaServiceJcCat axelaServicejccat;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jc_id", referencedColumnName = "baytrans_jc_id", insertable = false, updatable = false)
	private AxelaServiceJcBayTran axelaServiceJcBayTran;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jc_priorityjc_id", referencedColumnName = "priorityjc_id", insertable = false, updatable = false)
	private AxelaServiceJcPriority axelaServicejcpriority;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jc_jcstatus_id", referencedColumnName = "jcstatus_id", insertable = false, updatable = false)
	private AxelaServiceJcStatus axelaServicejcstatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jc_jctype_id", referencedColumnName = "jctype_id", insertable = false, updatable = false)
	private AxelaServiceJcType axelaServicejcType;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jc_item_id", referencedColumnName = "item_id", insertable = false, updatable = false)
	private AxelaInventoryItem axelaItem;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jc_contact_id", referencedColumnName = "contact_id", insertable = false, updatable = false)
	private AxelaCustomerContact axelaCustomerContact;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jc_customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
	private AxelaCustomer axelaCustomer;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jc_branch_id", referencedColumnName = "branch_id", insertable = false, updatable = false)
	private AxelaBranch axelaBranch;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jc_emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

	public AxelaServiceJcCat getAxelaServicejccat() {
		return axelaServicejccat;
	}

	public void setAxelaServicejccat(AxelaServiceJcCat axelaServicejccat) {
		this.axelaServicejccat = axelaServicejccat;
	}

	public AxelaServiceJcPriority getAxelaServicejcpriority() {
		return axelaServicejcpriority;
	}

	public void setAxelaServicejcpriority(AxelaServiceJcPriority axelaServicejcpriority) {
		this.axelaServicejcpriority = axelaServicejcpriority;
	}

	public AxelaServiceJcStatus getAxelaServicejcstatus() {
		return axelaServicejcstatus;
	}

	public void setAxelaServicejcstatus(AxelaServiceJcStatus axelaServicejcstatus) {
		this.axelaServicejcstatus = axelaServicejcstatus;
	}

	public AxelaServiceJcType getAxelaServicejcType() {
		return axelaServicejcType;
	}

	public void setAxelaServicejcType(AxelaServiceJcType axelaServicejcType) {
		this.axelaServicejcType = axelaServicejcType;
	}

	public AxelaInventoryItem getAxelaitem() {
		return axelaItem;
	}

	public void setAxelaitem(AxelaInventoryItem axelaitem) {
		this.axelaItem = axelaitem;
	}

	public AxelaCustomerContact getAxelaCustomerContact() {
		return axelaCustomerContact;
	}

	public void setAxelaCustomerContact(AxelaCustomerContact axelaCustomerContact) {
		this.axelaCustomerContact = axelaCustomerContact;
	}

	public long getJcCount() {
		return jcCount;
	}

	public void setJcCount(long jcCount) {
		this.jcCount = jcCount;
	}

	public double getJcTotal() {
		return jcTotal;
	}

	public void setJcTotal(double jcTotal) {
		this.jcTotal = jcTotal;
	}
}