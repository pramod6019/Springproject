package axela.portal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;

import axela.accounting.model.AxelaAccVoucher;
import axela.activities.model.AxelaActivity;
import axela.sales.model.AxelaSalesCrm;
import axela.sales.model.AxelaSalesOppr;
import axela.sales.model.AxelaSalesTeamExe;
import axela.service.model.AxelaServiceJcBayTran;
/**
 * The persistent class for the axela_emp database table.
 * 
 */
@Entity
@Table(name = "axela_emp", catalog = "axela_1")
@NamedQuery(name = "AxelaEmp.findAll", query = "SELECT a FROM AxelaEmp a")
// @Where(clause = "emp_active='1'")
public class AxelaEmp implements Serializable {
	private static final long serialVersionUID = 1L;

	// ====================== start traniesnt ========================
	@Transient
	private String roleName;
	@Transient
	private String branchName;
	@Transient
	private int branchId;

	// @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// private List<AxelaEmpRole> roles;

	public String getRoleName() {
		return roleName;
	}

	// public List<AxelaEmpRole> getRoles() {
	// return roles;
	// }
	//
	// public void setRoles(List<AxelaEmpRole> roles) {
	// this.roles = roles;
	// }

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getJobtitleDesc() {
		return jobtitleDesc;
	}

	public void setJobtitleDesc(String jobtitleDesc) {
		this.jobtitleDesc = jobtitleDesc;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Transient
	private String branchCode;
	@Transient
	private String jobtitleDesc;
	@Transient
	private String countryName;
	@Transient
	private String cityName;
	@Transient
	private String stateName;
	// ====================== end traniesnt ========================

	protected static final String comp_db = "axela_1";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private int empId;

	@Column(name = "emp_active")
	private String empActive;

	@Column(name = "emp_address")
	private String empAddress;

	@Column(name = "emp_all_branches")
	private String empAllBranches;

	@Column(name = "emp_all_exe")
	private String empAllExe;

	@Column(name = "emp_area_id")
	private byte empAreaId;

	@Column(name = "emp_role_id")
	private String empRoleId;

	public String getEmpRoleId() {
		return empRoleId;
	}

	public void setEmpRoleId(String empRoleId) {
		this.empRoleId = empRoleId;
	}

	@Column(name = "emp_bank_accholdername")
	private String empBankAccholdername;

	@Column(name = "emp_bank_accno")
	private String empBankAccno;

	@Column(name = "emp_bank_branchname")
	private String empBankBranchname;

	@Column(name = "emp_bank_name")
	private String empBankName;

	@Column(name = "emp_bill_discountupdate")
	private String empBillDiscountupdate;

	@Column(name = "emp_bill_priceupdate")
	private String empBillPriceupdate;

	@Column(name = "emp_certification")
	private String empCertification;

	@Column(name = "emp_city_id")
	private int empCityId;

	@Column(name = "emp_close_oppr")
	private String empCloseOppr;

	@Column(name = "emp_copy_access")
	private String empCopyAccess;

	@Column(name = "emp_crm")
	private String empCrm;

	@Column(name = "emp_date_of_join")
	private Date empDateOfJoin;

	@Column(name = "emp_date_of_relieve")
	private Date empDateOfRelieve;

	@Column(name = "emp_dealer_jc_exe")
	private String empDealerJcExe;

	@Column(name = "emp_department_id")
	private String empDepartmentId;

	@Column(name = "emp_dealer_jc_technician")
	private String empDealerJcTechnician;

	@Column(name = "emp_device_fcmtoken")
	private String empDeviceFcmtoken;

	@Column(name = "emp_device_id")
	private String empDeviceId;

	@Column(name = "emp_device_os")
	private String empDeviceOs;

	@Column(name = "emp_dispensary_id")
	private int empDispensaryId;

	@Column(name = "emp_dob")
	private Date empDob;

	@Column(name = "emp_email_password")
	private String empEmailPassword;

	@Column(name = "emp_email_port")
	private String empEmailPort;

	@Column(name = "emp_email_server")
	private String empEmailServer;

	@Column(name = "emp_email_ssl")
	private String empEmailSsl;

	@Column(name = "emp_email_tls")
	private String empEmailTls;

	@Column(name = "emp_email_username")
	private String empEmailUsername;

	@Email
	@Column(name = "emp_email1")
	private String empEmail1;

	@Column(name = "emp_email2")
	private String empEmail2;

	@Column(name = "emp_entry_date")
	private Date empEntryDate;

	@Column(name = "emp_entry_id")
	private int empEntryId;

	@Column(name = "emp_esi_no")
	private String empEsiNo;

	@Column(name = "emp_export_access")
	private String empExportAccess;

	@Column(name = "emp_formatdate_id")
	private byte empFormatdateId;

	@Column(name = "emp_formatdigit_id")
	private byte empFormatdigitId;

	@Column(name = "emp_formattime_id")
	private byte empFormattimeId;

	@Column(name = "emp_gender")
	private String empGender;

	@Column(name = "emp_invoice_discountupdate")
	private String empInvoiceDiscountupdate;

	@Column(name = "emp_invoice_priceupdate")
	private String empInvoicePriceupdate;

	@Column(name = "emp_ip_access")
	private String empIpAccess;

	@Column(name = "emp_jc_discountupdate")
	private String empJcDiscountupdate;

	@Column(name = "emp_jc_priceupdate")
	private String empJcPriceupdate;

	@Column(name = "emp_jobtitle_id")
	private int empJobtitleId;

	@Column(name = "emp_landmark")
	private String empLandmark;

	@Column(name = "emp_married")
	private String empMarried;

	@Column(name = "emp_mis_access")
	private String empMisAccess;

	@Column(name = "emp_mobile1")
	private String empMobile1;

	@Column(name = "emp_mobile2")
	private String empMobile2;

	@Column(name = "emp_modified_date")
	private Date empModifiedDate;

	@Column(name = "emp_modified_id")
	private int empModifiedId;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "emp_notes")
	private String empNotes;

	@Column(name = "emp_pf_no")
	private int empPfNo;

	@Column(name = "emp_pf_no_dept_file")
	private int empPfNoDeptFile;

	@Column(name = "emp_phone1")
	private String empPhone1;

	@Column(name = "emp_phone2")
	private String empPhone2;

	// @Column(name = "emp_photo")
	// private Object empPhoto;
	//
	// @Column(name = "emp_pic")
	// private Object empPic;

	@Column(name = "emp_pin")
	private String empPin;

	@Column(name = "emp_prbranch_id")
	private int empPrbranchId;

	@Column(name = "emp_priorityactivity_level1")
	private String empPriorityactivityLevel1;

	@Column(name = "emp_priorityactivity_level2")
	private String empPriorityactivityLevel2;

	@Column(name = "emp_priorityactivity_level3")
	private String empPriorityactivityLevel3;

	@Column(name = "emp_priorityactivity_level4")
	private String empPriorityactivityLevel4;

	@Column(name = "emp_priorityactivity_level5")
	private String empPriorityactivityLevel5;

	@Column(name = "emp_prioritybalance_level1")
	private String empPrioritybalanceLevel1;

	@Column(name = "emp_prioritybalance_level2")
	private String empPrioritybalanceLevel2;

	@Column(name = "emp_prioritybalance_level3")
	private String empPrioritybalanceLevel3;

	@Column(name = "emp_prioritybalance_level4")
	private String empPrioritybalanceLevel4;

	@Column(name = "emp_prioritybalance_level5")
	private String empPrioritybalanceLevel5;

	@Column(name = "emp_priorityjc_level1")
	private String empPriorityjcLevel1;

	@Column(name = "emp_priorityjc_level2")
	private String empPriorityjcLevel2;

	@Column(name = "emp_priorityjc_level3")
	private String empPriorityjcLevel3;

	@Column(name = "emp_priorityjc_level4")
	private String empPriorityjcLevel4;

	@Column(name = "emp_priorityjc_level5")
	private String empPriorityjcLevel5;

	@Column(name = "emp_priorityoppr_level1")
	private String empPriorityopprLevel1;

	@Column(name = "emp_priorityoppr_level2")
	private String empPriorityopprLevel2;

	@Column(name = "emp_priorityoppr_level3")
	private String empPriorityopprLevel3;

	@Column(name = "emp_priorityoppr_level4")
	private String empPriorityopprLevel4;

	@Column(name = "emp_priorityoppr_level5")
	private String empPriorityopprLevel5;

	@Column(name = "emp_priorityopprfollowup_level1")
	private String empPriorityopprfollowupLevel1;

	@Column(name = "emp_priorityopprfollowup_level2")
	private String empPriorityopprfollowupLevel2;

	@Column(name = "emp_priorityopprfollowup_level3")
	private String empPriorityopprfollowupLevel3;

	@Column(name = "emp_priorityopprfollowup_level4")
	private String empPriorityopprfollowupLevel4;

	@Column(name = "emp_priorityopprfollowup_level5")
	private String empPriorityopprfollowupLevel5;

	@Column(name = "emp_priorityproject_level1")
	private String empPriorityprojectLevel1;

	@Column(name = "emp_priorityproject_level2")
	private String empPriorityprojectLevel2;

	@Column(name = "emp_priorityproject_level3")
	private String empPriorityprojectLevel3;

	@Column(name = "emp_priorityproject_level4")
	private String empPriorityprojectLevel4;

	@Column(name = "emp_priorityproject_level5")
	private String empPriorityprojectLevel5;

	@Column(name = "emp_prioritytask_level1")
	private String empPrioritytaskLevel1;

	@Column(name = "emp_prioritytask_level2")
	private String empPrioritytaskLevel2;

	@Column(name = "emp_prioritytask_level3")
	private String empPrioritytaskLevel3;

	@Column(name = "emp_prioritytask_level4")
	private String empPrioritytaskLevel4;

	@Column(name = "emp_prioritytask_level5")
	private String empPrioritytaskLevel5;

	@Column(name = "emp_priorityticket_level1")
	private String empPriorityticketLevel1;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "emp_photo")
	private byte[] empPhoto;

	@Column(name = "emp_priorityticket_level2")
	private String empPriorityticketLevel2;

	@Column(name = "emp_priorityticket_level3")
	private String empPriorityticketLevel3;

	@Column(name = "emp_priorityticket_level4")
	private String empPriorityticketLevel4;

	@Column(name = "emp_priorityticket_level5")
	private String empPriorityticketLevel5;

	@Column(name = "emp_prod_jc_exe")
	private String empProdJcExe;

	@Column(name = "emp_qualification")
	private String empQualification;

	@Column(name = "emp_quote_discountupdate")
	private String empQuoteDiscountupdate;

	@Column(name = "emp_quote_priceupdate")
	private String empQuotePriceupdate;

	@Column(name = "emp_reason_of_leaving")
	private String empReasonOfLeaving;

	@Column(name = "emp_recperpage")
	private byte empRecperpage;

	@Column(name = "emp_ref_no")
	private String empRefNo;

	@Column(name = "emp_report_access")
	private String empReportAccess;

	@Column(name = "emp_sal_calc_from")
	private Date empSalCalcFrom;

	@Column(name = "emp_sales")
	private String empSales;

	@Column(name = "emp_service")
	private String empService;

	@Column(name = "emp_service_psf")
	private String empServicePsf;

	@Column(name = "emp_sex")
	private String empSex;

	@Column(name = "emp_so_discountupdate")
	private String empSoDiscountupdate;

	@Column(name = "emp_so_priceupdate")
	private String empSoPriceupdate;

	@Column(name = "emp_branch_id")
	private int empBranchId;

	//
	@Column(name = "emp_status")
	private String empStatus;

	@Column(name = "emp_structure_id")
	private int empStructureId;

	@Column(name = "emp_technician")
	private String empTechnician;

	@Column(name = "emp_theme_id")
	private byte empThemeId;

	@Column(name = "emp_ticket_close")
	private String empTicketClose;

	@Column(name = "emp_ticket_owner")
	private String empTicketOwner;

	@Column(name = "emp_timeout")
	private int empTimeout;

	@Column(name = "emp_uname")
	private String empUname;

	@Column(name = "emp_upass")
	private String empUpass;

	@Column(name = "emp_uuid")
	private String empUuid;

	// bi-directional many-to-one association to AxelaBranch
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_branch_id", referencedColumnName = "branch_id", insertable = false, updatable = false)
	private AxelaBranch axelaBranch;

	public AxelaEmpRole getAxelaEmpRole() {
		return axelaEmpRole;
	}

	public void setAxelaEmpRole(AxelaEmpRole axelaEmpRole) {
		this.axelaEmpRole = axelaEmpRole;
	}

	public AxelaCity getAxelaCity() {
		return axelaCity;
	}

	public void setAxelaCity(AxelaCity axelaCity) {
		this.axelaCity = axelaCity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_jobtitle_id", insertable = false, updatable = false)
	private AxelaJobtitle axelaJobtitle;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_formatdate_id", referencedColumnName = "formatdate_id", insertable = false, updatable = false)
	private AxelaFormatdate axelaFormatdate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_formattime_id", referencedColumnName = "formattime_id", insertable = false, updatable = false)
	private AxelaFormattime axelaFormattime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_formatdigit_id", referencedColumnName = "formatdigit_id", insertable = false, updatable = false)
	private AxelaFormatdigit axelaFormatdigit;

	// for executive
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_role_id", referencedColumnName = "role_id", insertable = false, updatable = false)
	private AxelaEmpRole axelaEmpRole;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_city_id", referencedColumnName = "city_id", insertable = false, updatable = false)
	private AxelaCity axelaCity;

	// // bi-directional many-to-one association to AxelaEmpAccess
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_id", referencedColumnName = "empaccess_emp_id", insertable = false, updatable = false)
	private AxelaEmpAccess axelaEmpAccess;

	@OneToMany(mappedBy = "axelaEmp")
	private List<AxelaEmpAccess> axelaEmpAccesss;

	@OneToMany(mappedBy = "axelaEmp")
	private List<AxelaEmpExe> axelaEmpExe;

	//
	// directional many-to-one association to AxelaEmpBranch
	// @OneToMany(mappedBy = "axelaEmp")
	// private List<AxelaEmpBranch> axelaEmpBranches;

	// // bi-directional many-to-one association to AxelaEmpDepartment
	// @OneToMany(mappedBy = "axelaEmp")
	// private List<AxelaEmpDepartment> axelaEmpDepartments;
	//
	// // bi-directional many-to-one association to AxelaEmpDoc
	// @OneToMany(mappedBy = "axelaEmp")
	// private List<AxelaEmpDoc> axelaEmpDocs;
	//
	// //bi-directional many-to-one association to AxelaEmpExe
	// @OneToMany(mappedBy="axelaEmp")
	// private List<AxelaEmpExe> axelaEmpExes;

	public List<AxelaEmpExe> getAxelaEmpExe() {
		return axelaEmpExe;
	}

	public void setAxelaEmpExe(List<AxelaEmpExe> axelaEmpExe) {
		this.axelaEmpExe = axelaEmpExe;
	}

	public List<AxelaActivity> getAxelaActivity() {
		return axelaActivity;
	}

	public void setAxelaActivity(List<AxelaActivity> axelaActivity) {
		this.axelaActivity = axelaActivity;
	}

	public List<AxelaEmpBranch> getAxelaEmpBranch() {
		return axelaEmpBranch;
	}

	public void setAxelaEmpBranch(List<AxelaEmpBranch> axelaEmpBranch) {
		this.axelaEmpBranch = axelaEmpBranch;
	}

	// bi-directional many-to-one association to AxelaEmpLeave
	// @OneToMany(mappedBy = "axelaEmp")
	// private List<AxelaEmpLeave> axelaEmpLeaves;
	//
	// bi-directional many-to-one association to AxelaEmpLog
	@OneToMany(mappedBy = "axelaEmp")
	private List<AxelaEmpLog> axelaEmpLogs;

	// bi-directional many-to-one association to AxelaEmpRole

	// @JoinTable(name = "axela_emp_role", joinColumns = @JoinColumn(name = "emp_role_id"))
	// private Set<AxelaEmpRole> axelaEmpRole;
	//
	// bi-directional many-to-one association to AxelaEmpUser
	// @OneToMany(mappedBy = "axelaEmp")
	// private List<AxelaEmpUser> axelaEmpUsers;

	public AxelaJobtitle getAxelaJobtitle() {
		return axelaJobtitle;
	}

	public AxelaFormatdate getAxelaFormatdate() {
		return axelaFormatdate;
	}

	public void setAxelaFormatdate(AxelaFormatdate axelaFormatdate) {
		this.axelaFormatdate = axelaFormatdate;
	}

	public AxelaFormattime getAxelaFormattime() {
		return axelaFormattime;
	}

	public void setAxelaFormattime(AxelaFormattime axelaFormattime) {
		this.axelaFormattime = axelaFormattime;
	}

	public AxelaFormatdigit getAxelaFormatdigit() {
		return axelaFormatdigit;
	}

	public void setAxelaFormatdigit(AxelaFormatdigit axelaFormatdigit) {
		this.axelaFormatdigit = axelaFormatdigit;
	}

	public void setAxelaJobtitle(AxelaJobtitle axelaJobtitle) {
		this.axelaJobtitle = axelaJobtitle;
	}

	public AxelaEmp() {
	}
	public AxelaEmp(int empId) {
		this.empId = empId;
	}

	public AxelaEmp(
			int empId,
			String empName) {
		this.empId = empId;
		this.empName = empName;
	}
	// contructor for Business Manager Executive list
	public AxelaEmp(
			int empId,
			String empName,
			String empRefNo,
			String empLandmark,
			String empAddress,
			int empCityId,
			String cityName,
			String stateName,
			String empPhone1,
			String empPhone2,
			String empMobile1,
			String empMobile2,
			String empEmail1,
			String empEmail2,
			String countryName,
			int empStructureId,
			String empPin,
			// // String empPhoto,
			String empGender,
			String empActive,
			String roleName,
			String branchName,
			int branchId,
			String branchCode,
			String jobtitleDesc) {
		this.empId = empId;
		this.empName = empName;
		this.empRefNo = empRefNo;
		this.empLandmark = empLandmark;
		this.empAddress = empAddress;
		this.empCityId = empCityId;
		this.cityName = cityName;
		this.stateName = stateName;
		this.empPhone1 = empPhone1;
		this.empPhone2 = empPhone2;
		this.empMobile1 = empMobile1;
		this.empMobile2 = empMobile2;
		this.empEmail1 = empEmail1;
		this.empEmail2 = empEmail2;
		this.countryName = countryName;
		this.empStructureId = empStructureId;
		this.empPin = empPin;
		// this.empPhoto=empPhoto;
		this.empGender = empGender;
		this.empActive = empActive;
		this.roleName = roleName;
		this.branchName = branchName;
		this.branchId = branchId;
		this.branchCode = branchCode;
		this.jobtitleDesc = jobtitleDesc;

	}

	// access rights
	public AxelaEmp(
			String empExportAccess,
			String empReportAccess,
			String empMisAccess,
			String empCopyAccess) {
		super();
		this.empExportAccess = empExportAccess;
		this.empReportAccess = empReportAccess;
		this.empMisAccess = empMisAccess;
		this.empCopyAccess = empCopyAccess;
	}

	// executive summary
	public AxelaEmp(
			int empId,
			String empName,
			String empRefNo,
			String empSex,
			Date empDob,
			String empMobile1,
			String empEmail1,
			String empStatus,
			String empAddress,
			String empPin,
			String empMarried,
			String jobtitleDesc,
			String cityName,
			String stateName,
			String countryName) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empRefNo = empRefNo;
		this.empSex = empSex;
		this.empDob = empDob;
		this.empMobile1 = empMobile1;
		this.empEmail1 = empEmail1;
		this.empStatus = empStatus;
		this.empAddress = empAddress;
		this.empPin = empPin;
		this.empMarried = empMarried;
		this.jobtitleDesc = jobtitleDesc;
		this.cityName = cityName;
		this.stateName = stateName;
		this.countryName = countryName;
	}

	public List<AxelaEmpAccess> getAxelaEmpAccesss() {
		return axelaEmpAccesss;
	}

	public void setAxelaEmpAccesss(List<AxelaEmpAccess> axelaEmpAccesss) {
		this.axelaEmpAccesss = axelaEmpAccesss;
	}

	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	// public Set<AxelaEmpRole> getEmp_role_id() {
	// return axelaEmpRole;
	// }

	public String getEmpActive() {
		return this.empActive;
	}

	public void setEmpActive(String empActive) {
		this.empActive = empActive;
	}

	public String getEmpAddress() {
		return this.empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpAllBranches() {
		return this.empAllBranches;
	}

	public void setEmpAllBranches(String empAllBranches) {
		this.empAllBranches = empAllBranches;
	}

	public String getEmpAllExe() {
		return this.empAllExe;
	}

	public void setEmpAllExe(String empAllExe) {
		this.empAllExe = empAllExe;
	}

	public byte getEmpAreaId() {
		return this.empAreaId;
	}

	public void setEmpAreaId(byte empAreaId) {
		this.empAreaId = empAreaId;
	}

	public String getEmpBankAccholdername() {
		return this.empBankAccholdername;
	}

	public void setEmpBankAccholdername(String empBankAccholdername) {
		this.empBankAccholdername = empBankAccholdername;
	}

	public String getEmpBankAccno() {
		return this.empBankAccno;
	}

	public void setEmpBankAccno(String empBankAccno) {
		this.empBankAccno = empBankAccno;
	}

	public String getEmpBankBranchname() {
		return this.empBankBranchname;
	}

	public void setEmpBankBranchname(String empBankBranchname) {
		this.empBankBranchname = empBankBranchname;
	}

	public String getEmpBankName() {
		return this.empBankName;
	}

	public void setEmpBankName(String empBankName) {
		this.empBankName = empBankName;
	}

	public String getEmpBillDiscountupdate() {
		return this.empBillDiscountupdate;
	}

	public void setEmpBillDiscountupdate(String empBillDiscountupdate) {
		this.empBillDiscountupdate = empBillDiscountupdate;
	}

	public String getEmpBillPriceupdate() {
		return this.empBillPriceupdate;
	}

	public void setEmpBillPriceupdate(String empBillPriceupdate) {
		this.empBillPriceupdate = empBillPriceupdate;
	}

	public String getEmpCertification() {
		return this.empCertification;
	}

	public void setEmpCertification(String empCertification) {
		this.empCertification = empCertification;
	}

	public int getEmpCityId() {
		return this.empCityId;
	}

	public void setEmpCityId(int empCityId) {
		this.empCityId = empCityId;
	}

	public String getEmpCloseOppr() {
		return this.empCloseOppr;
	}

	public void setEmpCloseOppr(String empCloseOppr) {
		this.empCloseOppr = empCloseOppr;
	}

	public String getEmpCopyAccess() {
		return this.empCopyAccess;
	}

	public void setEmpCopyAccess(String empCopyAccess) {
		this.empCopyAccess = empCopyAccess;
	}

	public String getEmpCrm() {
		return this.empCrm;
	}

	public void setEmpCrm(String empCrm) {
		this.empCrm = empCrm;
	}

	public Date getEmpDateOfJoin() {
		return this.empDateOfJoin;
	}

	public void setEmpDateOfJoin(Date empDateOfJoin) {
		this.empDateOfJoin = empDateOfJoin;
	}

	public Date getEmpDateOfRelieve() {
		return this.empDateOfRelieve;
	}

	public void setEmpDateOfRelieve(Date empDateOfRelieve) {
		this.empDateOfRelieve = empDateOfRelieve;
	}

	public String getEmpDealerJcExe() {
		return this.empDealerJcExe;
	}

	public void setEmpDealerJcExe(String empDealerJcExe) {
		this.empDealerJcExe = empDealerJcExe;
	}

	public String getEmpDealerJcTechnician() {
		return this.empDealerJcTechnician;
	}

	public void setEmpDealerJcTechnician(String empDealerJcTechnician) {
		this.empDealerJcTechnician = empDealerJcTechnician;
	}

	public String getEmpDeviceFcmtoken() {
		return this.empDeviceFcmtoken;
	}

	public void setEmpDeviceFcmtoken(String empDeviceFcmtoken) {
		this.empDeviceFcmtoken = empDeviceFcmtoken;
	}

	public String getEmpDeviceId() {
		return this.empDeviceId;
	}

	public void setEmpDeviceId(String empDeviceId) {
		this.empDeviceId = empDeviceId;
	}

	public String getEmpDeviceOs() {
		return this.empDeviceOs;
	}

	public void setEmpDeviceOs(String empDeviceOs) {
		this.empDeviceOs = empDeviceOs;
	}

	public int getEmpDispensaryId() {
		return this.empDispensaryId;
	}

	public void setEmpDispensaryId(int empDispensaryId) {
		this.empDispensaryId = empDispensaryId;
	}

	public Date getEmpDob() {
		return this.empDob;
	}

	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}

	public String getEmpEmailPassword() {
		return this.empEmailPassword;
	}

	public void setEmpEmailPassword(String empEmailPassword) {
		this.empEmailPassword = empEmailPassword;
	}

	public String getEmpEmailPort() {
		return this.empEmailPort;
	}

	public void setEmpEmailPort(String empEmailPort) {
		this.empEmailPort = empEmailPort;
	}

	public String getEmpEmailServer() {
		return this.empEmailServer;
	}

	public void setEmpEmailServer(String empEmailServer) {
		this.empEmailServer = empEmailServer;
	}

	public String getEmpEmailSsl() {
		return this.empEmailSsl;
	}

	public void setEmpEmailSsl(String empEmailSsl) {
		this.empEmailSsl = empEmailSsl;
	}

	public String getEmpEmailTls() {
		return this.empEmailTls;
	}

	public void setEmpEmailTls(String empEmailTls) {
		this.empEmailTls = empEmailTls;
	}

	public String getEmpEmailUsername() {
		return this.empEmailUsername;
	}

	public void setEmpEmailUsername(String empEmailUsername) {
		this.empEmailUsername = empEmailUsername;
	}

	public String getEmpEmail1() {
		return this.empEmail1;
	}

	public void setEmpEmail1(String empEmail1) {
		this.empEmail1 = empEmail1;
	}

	public String getEmpEmail2() {
		return this.empEmail2;
	}

	public void setEmpEmail2(String empEmail2) {
		this.empEmail2 = empEmail2;
	}

	public Date getEmpEntryDate() {
		return this.empEntryDate;
	}

	public void setEmpEntryDate(Date empEntryDate) {
		this.empEntryDate = empEntryDate;
	}

	public int getEmpEntryId() {
		return this.empEntryId;
	}

	public void setEmpEntryId(int empEntryId) {
		this.empEntryId = empEntryId;
	}

	public String getEmpEsiNo() {
		return this.empEsiNo;
	}

	public void setEmpEsiNo(String empEsiNo) {
		this.empEsiNo = empEsiNo;
	}

	public String getEmpExportAccess() {
		return this.empExportAccess;
	}

	public void setEmpExportAccess(String empExportAccess) {
		this.empExportAccess = empExportAccess;
	}

	public byte getEmpFormatdateId() {
		return this.empFormatdateId;
	}

	public void setEmpFormatdateId(byte empFormatdateId) {
		this.empFormatdateId = empFormatdateId;
	}

	public byte getEmpFormatdigitId() {
		return this.empFormatdigitId;
	}

	public void setEmpFormatdigitId(byte empFormatdigitId) {
		this.empFormatdigitId = empFormatdigitId;
	}

	public byte getEmpFormattimeId() {
		return this.empFormattimeId;
	}

	public void setEmpFormattimeId(byte empFormattimeId) {
		this.empFormattimeId = empFormattimeId;
	}

	public String getEmpGender() {
		return this.empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public String getEmpInvoiceDiscountupdate() {
		return this.empInvoiceDiscountupdate;
	}

	public void setEmpInvoiceDiscountupdate(String empInvoiceDiscountupdate) {
		this.empInvoiceDiscountupdate = empInvoiceDiscountupdate;
	}

	public String getEmpInvoicePriceupdate() {
		return this.empInvoicePriceupdate;
	}

	public void setEmpInvoicePriceupdate(String empInvoicePriceupdate) {
		this.empInvoicePriceupdate = empInvoicePriceupdate;
	}

	public String getEmpIpAccess() {
		return this.empIpAccess;
	}

	public void setEmpIpAccess(String empIpAccess) {
		this.empIpAccess = empIpAccess;
	}

	public String getEmpJcDiscountupdate() {
		return this.empJcDiscountupdate;
	}

	public void setEmpJcDiscountupdate(String empJcDiscountupdate) {
		this.empJcDiscountupdate = empJcDiscountupdate;
	}

	public String getEmpJcPriceupdate() {
		return this.empJcPriceupdate;
	}

	public void setEmpJcPriceupdate(String empJcPriceupdate) {
		this.empJcPriceupdate = empJcPriceupdate;
	}

	public int getEmpJobtitleId() {
		return this.empJobtitleId;
	}

	public void setEmpJobtitleId(int empJobtitleId) {
		this.empJobtitleId = empJobtitleId;
	}

	public String getEmpLandmark() {
		return this.empLandmark;
	}

	public void setEmpLandmark(String empLandmark) {
		this.empLandmark = empLandmark;
	}

	public String getEmpMarried() {
		return this.empMarried;
	}

	public void setEmpMarried(String empMarried) {
		this.empMarried = empMarried;
	}

	public String getEmpMisAccess() {
		return this.empMisAccess;
	}

	public void setEmpMisAccess(String empMisAccess) {
		this.empMisAccess = empMisAccess;
	}

	public String getEmpMobile1() {
		return this.empMobile1;
	}

	public void setEmpMobile1(String empMobile1) {
		this.empMobile1 = empMobile1;
	}

	public String getEmpMobile2() {
		return this.empMobile2;
	}

	public void setEmpMobile2(String empMobile2) {
		this.empMobile2 = empMobile2;
	}

	public Date getEmpModifiedDate() {
		return this.empModifiedDate;
	}

	public void setEmpModifiedDate(Date empModifiedDate) {
		this.empModifiedDate = empModifiedDate;
	}

	public int getEmpModifiedId() {
		return this.empModifiedId;
	}

	public void setEmpModifiedId(int empModifiedId) {
		this.empModifiedId = empModifiedId;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNotes() {
		return this.empNotes;
	}

	public void setEmpNotes(String empNotes) {
		this.empNotes = empNotes;
	}

	public int getEmpPfNo() {
		return this.empPfNo;
	}

	public void setEmpPfNo(int empPfNo) {
		this.empPfNo = empPfNo;
	}

	public int getEmpPfNoDeptFile() {
		return this.empPfNoDeptFile;
	}

	public void setEmpPfNoDeptFile(int empPfNoDeptFile) {
		this.empPfNoDeptFile = empPfNoDeptFile;
	}

	public String getEmpPhone1() {
		return this.empPhone1;
	}

	public void setEmpPhone1(String empPhone1) {
		this.empPhone1 = empPhone1;
	}

	public String getEmpPhone2() {
		return this.empPhone2;
	}

	public void setEmpPhone2(String empPhone2) {
		this.empPhone2 = empPhone2;
	}

	// public Object getEmpPhoto() {
	// return this.empPhoto;
	// }

	// public void setEmpPhoto(Object empPhoto) {
	// this.empPhoto = empPhoto;
	// }
	//
	// public Object getEmpPic() {
	// return this.empPic;
	// }

	// public void setEmpPic(Object empPic) {
	// this.empPic = empPic;
	// }

	public String getEmpPin() {
		return this.empPin;
	}

	public void setEmpPin(String empPin) {
		this.empPin = empPin;
	}

	public int getEmpPrbranchId() {
		return this.empPrbranchId;
	}

	public void setEmpPrbranchId(int empPrbranchId) {
		this.empPrbranchId = empPrbranchId;
	}

	public String getEmpPriorityactivityLevel1() {
		return this.empPriorityactivityLevel1;
	}

	public void setEmpPriorityactivityLevel1(String empPriorityactivityLevel1) {
		this.empPriorityactivityLevel1 = empPriorityactivityLevel1;
	}

	public String getEmpPriorityactivityLevel2() {
		return this.empPriorityactivityLevel2;
	}

	public void setEmpPriorityactivityLevel2(String empPriorityactivityLevel2) {
		this.empPriorityactivityLevel2 = empPriorityactivityLevel2;
	}

	public String getEmpPriorityactivityLevel3() {
		return this.empPriorityactivityLevel3;
	}

	public void setEmpPriorityactivityLevel3(String empPriorityactivityLevel3) {
		this.empPriorityactivityLevel3 = empPriorityactivityLevel3;
	}

	public String getEmpPriorityactivityLevel4() {
		return this.empPriorityactivityLevel4;
	}

	public void setEmpPriorityactivityLevel4(String empPriorityactivityLevel4) {
		this.empPriorityactivityLevel4 = empPriorityactivityLevel4;
	}

	public String getEmpPriorityactivityLevel5() {
		return this.empPriorityactivityLevel5;
	}

	public void setEmpPriorityactivityLevel5(String empPriorityactivityLevel5) {
		this.empPriorityactivityLevel5 = empPriorityactivityLevel5;
	}

	public String getEmpPrioritybalanceLevel1() {
		return this.empPrioritybalanceLevel1;
	}

	public void setEmpPrioritybalanceLevel1(String empPrioritybalanceLevel1) {
		this.empPrioritybalanceLevel1 = empPrioritybalanceLevel1;
	}

	public String getEmpPrioritybalanceLevel2() {
		return this.empPrioritybalanceLevel2;
	}

	public void setEmpPrioritybalanceLevel2(String empPrioritybalanceLevel2) {
		this.empPrioritybalanceLevel2 = empPrioritybalanceLevel2;
	}

	public String getEmpPrioritybalanceLevel3() {
		return this.empPrioritybalanceLevel3;
	}

	public void setEmpPrioritybalanceLevel3(String empPrioritybalanceLevel3) {
		this.empPrioritybalanceLevel3 = empPrioritybalanceLevel3;
	}

	public String getEmpPrioritybalanceLevel4() {
		return this.empPrioritybalanceLevel4;
	}

	public void setEmpPrioritybalanceLevel4(String empPrioritybalanceLevel4) {
		this.empPrioritybalanceLevel4 = empPrioritybalanceLevel4;
	}

	public String getEmpPrioritybalanceLevel5() {
		return this.empPrioritybalanceLevel5;
	}

	public void setEmpPrioritybalanceLevel5(String empPrioritybalanceLevel5) {
		this.empPrioritybalanceLevel5 = empPrioritybalanceLevel5;
	}

	public String getEmpPriorityjcLevel1() {
		return this.empPriorityjcLevel1;
	}

	public void setEmpPriorityjcLevel1(String empPriorityjcLevel1) {
		this.empPriorityjcLevel1 = empPriorityjcLevel1;
	}

	public String getEmpPriorityjcLevel2() {
		return this.empPriorityjcLevel2;
	}

	public void setEmpPriorityjcLevel2(String empPriorityjcLevel2) {
		this.empPriorityjcLevel2 = empPriorityjcLevel2;
	}

	public String getEmpPriorityjcLevel3() {
		return this.empPriorityjcLevel3;
	}

	public void setEmpPriorityjcLevel3(String empPriorityjcLevel3) {
		this.empPriorityjcLevel3 = empPriorityjcLevel3;
	}

	public String getEmpPriorityjcLevel4() {
		return this.empPriorityjcLevel4;
	}

	public void setEmpPriorityjcLevel4(String empPriorityjcLevel4) {
		this.empPriorityjcLevel4 = empPriorityjcLevel4;
	}

	public String getEmpPriorityjcLevel5() {
		return this.empPriorityjcLevel5;
	}

	public void setEmpPriorityjcLevel5(String empPriorityjcLevel5) {
		this.empPriorityjcLevel5 = empPriorityjcLevel5;
	}

	public String getEmpPriorityopprLevel1() {
		return this.empPriorityopprLevel1;
	}

	public void setEmpPriorityopprLevel1(String empPriorityopprLevel1) {
		this.empPriorityopprLevel1 = empPriorityopprLevel1;
	}

	public String getEmpPriorityopprLevel2() {
		return this.empPriorityopprLevel2;
	}

	public void setEmpPriorityopprLevel2(String empPriorityopprLevel2) {
		this.empPriorityopprLevel2 = empPriorityopprLevel2;
	}

	public String getEmpPriorityopprLevel3() {
		return this.empPriorityopprLevel3;
	}

	public void setEmpPriorityopprLevel3(String empPriorityopprLevel3) {
		this.empPriorityopprLevel3 = empPriorityopprLevel3;
	}

	public String getEmpPriorityopprLevel4() {
		return this.empPriorityopprLevel4;
	}

	public void setEmpPriorityopprLevel4(String empPriorityopprLevel4) {
		this.empPriorityopprLevel4 = empPriorityopprLevel4;
	}

	public String getEmpPriorityopprLevel5() {
		return this.empPriorityopprLevel5;
	}

	public void setEmpPriorityopprLevel5(String empPriorityopprLevel5) {
		this.empPriorityopprLevel5 = empPriorityopprLevel5;
	}

	public String getEmpPriorityopprfollowupLevel1() {
		return this.empPriorityopprfollowupLevel1;
	}

	public void setEmpPriorityopprfollowupLevel1(String empPriorityopprfollowupLevel1) {
		this.empPriorityopprfollowupLevel1 = empPriorityopprfollowupLevel1;
	}

	public String getEmpPriorityopprfollowupLevel2() {
		return this.empPriorityopprfollowupLevel2;
	}

	public void setEmpPriorityopprfollowupLevel2(String empPriorityopprfollowupLevel2) {
		this.empPriorityopprfollowupLevel2 = empPriorityopprfollowupLevel2;
	}

	public String getEmpPriorityopprfollowupLevel3() {
		return this.empPriorityopprfollowupLevel3;
	}

	public void setEmpPriorityopprfollowupLevel3(String empPriorityopprfollowupLevel3) {
		this.empPriorityopprfollowupLevel3 = empPriorityopprfollowupLevel3;
	}

	public String getEmpPriorityopprfollowupLevel4() {
		return this.empPriorityopprfollowupLevel4;
	}

	public void setEmpPriorityopprfollowupLevel4(String empPriorityopprfollowupLevel4) {
		this.empPriorityopprfollowupLevel4 = empPriorityopprfollowupLevel4;
	}

	public String getEmpPriorityopprfollowupLevel5() {
		return this.empPriorityopprfollowupLevel5;
	}

	public void setEmpPriorityopprfollowupLevel5(String empPriorityopprfollowupLevel5) {
		this.empPriorityopprfollowupLevel5 = empPriorityopprfollowupLevel5;
	}

	public String getEmpPriorityprojectLevel1() {
		return this.empPriorityprojectLevel1;
	}

	public void setEmpPriorityprojectLevel1(String empPriorityprojectLevel1) {
		this.empPriorityprojectLevel1 = empPriorityprojectLevel1;
	}

	public String getEmpPriorityprojectLevel2() {
		return this.empPriorityprojectLevel2;
	}

	public void setEmpPriorityprojectLevel2(String empPriorityprojectLevel2) {
		this.empPriorityprojectLevel2 = empPriorityprojectLevel2;
	}

	public String getEmpPriorityprojectLevel3() {
		return this.empPriorityprojectLevel3;
	}

	public void setEmpPriorityprojectLevel3(String empPriorityprojectLevel3) {
		this.empPriorityprojectLevel3 = empPriorityprojectLevel3;
	}

	public String getEmpPriorityprojectLevel4() {
		return this.empPriorityprojectLevel4;
	}

	public void setEmpPriorityprojectLevel4(String empPriorityprojectLevel4) {
		this.empPriorityprojectLevel4 = empPriorityprojectLevel4;
	}

	public String getEmpPriorityprojectLevel5() {
		return this.empPriorityprojectLevel5;
	}

	public void setEmpPriorityprojectLevel5(String empPriorityprojectLevel5) {
		this.empPriorityprojectLevel5 = empPriorityprojectLevel5;
	}

	public String getEmpPrioritytaskLevel1() {
		return this.empPrioritytaskLevel1;
	}

	public void setEmpPrioritytaskLevel1(String empPrioritytaskLevel1) {
		this.empPrioritytaskLevel1 = empPrioritytaskLevel1;
	}

	public String getEmpPrioritytaskLevel2() {
		return this.empPrioritytaskLevel2;
	}

	public void setEmpPrioritytaskLevel2(String empPrioritytaskLevel2) {
		this.empPrioritytaskLevel2 = empPrioritytaskLevel2;
	}

	public String getEmpPrioritytaskLevel3() {
		return this.empPrioritytaskLevel3;
	}

	public void setEmpPrioritytaskLevel3(String empPrioritytaskLevel3) {
		this.empPrioritytaskLevel3 = empPrioritytaskLevel3;
	}

	public String getEmpPrioritytaskLevel4() {
		return this.empPrioritytaskLevel4;
	}

	public void setEmpPrioritytaskLevel4(String empPrioritytaskLevel4) {
		this.empPrioritytaskLevel4 = empPrioritytaskLevel4;
	}

	public String getEmpPrioritytaskLevel5() {
		return this.empPrioritytaskLevel5;
	}

	public void setEmpPrioritytaskLevel5(String empPrioritytaskLevel5) {
		this.empPrioritytaskLevel5 = empPrioritytaskLevel5;
	}

	public String getEmpPriorityticketLevel1() {
		return this.empPriorityticketLevel1;
	}

	public void setEmpPriorityticketLevel1(String empPriorityticketLevel1) {
		this.empPriorityticketLevel1 = empPriorityticketLevel1;
	}

	public String getEmpPriorityticketLevel2() {
		return this.empPriorityticketLevel2;
	}

	public void setEmpPriorityticketLevel2(String empPriorityticketLevel2) {
		this.empPriorityticketLevel2 = empPriorityticketLevel2;
	}

	public String getEmpPriorityticketLevel3() {
		return this.empPriorityticketLevel3;
	}

	public void setEmpPriorityticketLevel3(String empPriorityticketLevel3) {
		this.empPriorityticketLevel3 = empPriorityticketLevel3;
	}

	public String getEmpPriorityticketLevel4() {
		return this.empPriorityticketLevel4;
	}

	public void setEmpPriorityticketLevel4(String empPriorityticketLevel4) {
		this.empPriorityticketLevel4 = empPriorityticketLevel4;
	}

	public String getEmpPriorityticketLevel5() {
		return this.empPriorityticketLevel5;
	}

	public void setEmpPriorityticketLevel5(String empPriorityticketLevel5) {
		this.empPriorityticketLevel5 = empPriorityticketLevel5;
	}

	public String getEmpDepartmentId() {
		return empDepartmentId;
	}

	public void setEmpDepartmentId(String empDepartmentId) {
		this.empDepartmentId = empDepartmentId;
	}

	public String getEmpProdJcExe() {
		return this.empProdJcExe;
	}

	public void setEmpProdJcExe(String empProdJcExe) {
		this.empProdJcExe = empProdJcExe;
	}

	public String getEmpQualification() {
		return this.empQualification;
	}

	public void setEmpQualification(String empQualification) {
		this.empQualification = empQualification;
	}

	public String getEmpQuoteDiscountupdate() {
		return this.empQuoteDiscountupdate;
	}

	public void setEmpQuoteDiscountupdate(String empQuoteDiscountupdate) {
		this.empQuoteDiscountupdate = empQuoteDiscountupdate;
	}

	public String getEmpQuotePriceupdate() {
		return this.empQuotePriceupdate;
	}

	public void setEmpQuotePriceupdate(String empQuotePriceupdate) {
		this.empQuotePriceupdate = empQuotePriceupdate;
	}

	public String getEmpReasonOfLeaving() {
		return this.empReasonOfLeaving;
	}

	public void setEmpReasonOfLeaving(String empReasonOfLeaving) {
		this.empReasonOfLeaving = empReasonOfLeaving;
	}

	public byte getEmpRecperpage() {
		return this.empRecperpage;
	}

	public void setEmpRecperpage(byte empRecperpage) {
		this.empRecperpage = empRecperpage;
	}

	public String getEmpRefNo() {
		return this.empRefNo;
	}

	public void setEmpRefNo(String empRefNo) {
		this.empRefNo = empRefNo;
	}

	public String getEmpReportAccess() {
		return this.empReportAccess;
	}

	public void setEmpReportAccess(String empReportAccess) {
		this.empReportAccess = empReportAccess;
	}

	public Date getEmpSalCalcFrom() {
		return this.empSalCalcFrom;
	}

	public void setEmpSalCalcFrom(Date empSalCalcFrom) {
		this.empSalCalcFrom = empSalCalcFrom;
	}

	public String getEmpSales() {
		return this.empSales;
	}

	public void setEmpSales(String empSales) {
		this.empSales = empSales;
	}

	public String getEmpService() {
		return this.empService;
	}

	public void setEmpService(String empService) {
		this.empService = empService;
	}

	public String getEmpServicePsf() {
		return this.empServicePsf;
	}

	public void setEmpServicePsf(String empServicePsf) {
		this.empServicePsf = empServicePsf;
	}

	public String getEmpSex() {
		return this.empSex;
	}

	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}

	public String getEmpSoDiscountupdate() {
		return this.empSoDiscountupdate;
	}

	public void setEmpSoDiscountupdate(String empSoDiscountupdate) {
		this.empSoDiscountupdate = empSoDiscountupdate;
	}

	public String getEmpSoPriceupdate() {
		return this.empSoPriceupdate;
	}

	public void setEmpSoPriceupdate(String empSoPriceupdate) {
		this.empSoPriceupdate = empSoPriceupdate;
	}

	public String getEmpStatus() {
		return this.empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public int getEmpStructureId() {
		return this.empStructureId;
	}

	public void setEmpStructureId(int empStructureId) {
		this.empStructureId = empStructureId;
	}

	public String getEmpTechnician() {
		return this.empTechnician;
	}

	public void setEmpTechnician(String empTechnician) {
		this.empTechnician = empTechnician;
	}

	public byte getEmpThemeId() {
		return this.empThemeId;
	}

	public void setEmpThemeId(byte empThemeId) {
		this.empThemeId = empThemeId;
	}

	public String getEmpTicketClose() {
		return this.empTicketClose;
	}

	public void setEmpTicketClose(String empTicketClose) {
		this.empTicketClose = empTicketClose;
	}

	public String getEmpTicketOwner() {
		return this.empTicketOwner;
	}

	public void setEmpTicketOwner(String empTicketOwner) {
		this.empTicketOwner = empTicketOwner;
	}

	public int getEmpTimeout() {
		return this.empTimeout;
	}

	public void setEmpTimeout(int empTimeout) {
		this.empTimeout = empTimeout;
	}

	public String getEmpUname() {
		return this.empUname;
	}

	public void setEmpUname(String empUname) {
		this.empUname = empUname;
	}

	public String getEmpUpass() {
		return this.empUpass;
	}

	public void setEmpUpass(String empUpass) {
		this.empUpass = empUpass;
	}

	public String getEmpUuid() {
		return this.empUuid;
	}

	public void setEmpUuid(String empUuid) {
		this.empUuid = empUuid;
	}

	public AxelaBranch getAxelaBranch() {
		return this.axelaBranch;
	}

	public void setAxelaBranch(AxelaBranch axelaBranch) {
		this.axelaBranch = axelaBranch;
	}

	public AxelaEmpAccess getAxelaEmpAccess() {
		return this.axelaEmpAccess;
	}

	public void setAxelaEmpAccess(AxelaEmpAccess axelaEmpAccesses) {
		this.axelaEmpAccess = axelaEmpAccesses;
	}
	//
	// public AxelaEmpAccess addAxelaEmpAccess(AxelaEmpAccess axelaEmpAccess) {
	// getAxelaEmpAccesses().add(axelaEmpAccess);
	// axelaEmpAccess.setAxelaEmp(this);
	//
	// return axelaEmpAccess;
	// }
	//
	// public AxelaEmpAccess removeAxelaEmpAccess(AxelaEmpAccess axelaEmpAccess) {
	// getAxelaEmpAccesses().remove(axelaEmpAccess);
	// axelaEmpAccess.setAxelaEmp(null);
	//
	// return axelaEmpAccess;
	// }
	//
	// public List<AxelaEmpBranch> getAxelaEmpBranches() {
	// return this.axelaEmpBranches;
	// }

	// public void setAxelaEmpBranches(List<AxelaEmpBranch> axelaEmpBranches) {
	// this.axelaEmpBranches = axelaEmpBranches;
	// }

	// public AxelaEmpBranch addAxelaEmpBranch(AxelaEmpBranch axelaEmpBranch) {
	// getAxelaEmpBranches().add(axelaEmpBranch);
	// axelaEmpBranch.setAxelaEmp(this);
	//
	// return axelaEmpBranch;
	// }
	//
	// public AxelaEmpBranch removeAxelaEmpBranch(AxelaEmpBranch axelaEmpBranch) {
	// getAxelaEmpBranches().remove(axelaEmpBranch);
	// axelaEmpBranch.setAxelaEmp(null);
	//
	// return axelaEmpBranch;
	// }

	// public List<AxelaEmpDepartment> getAxelaEmpDepartments() {
	// return this.axelaEmpDepartments;
	// }
	//
	// public void setAxelaEmpDepartments(List<AxelaEmpDepartment> axelaEmpDepartments) {
	// this.axelaEmpDepartments = axelaEmpDepartments;
	// }
	//
	// public AxelaEmpDepartment addAxelaEmpDepartment(AxelaEmpDepartment axelaEmpDepartment) {
	// getAxelaEmpDepartments().add(axelaEmpDepartment);
	// axelaEmpDepartment.setAxelaEmp(this);
	//
	// return axelaEmpDepartment;
	// }
	//
	// public AxelaEmpDepartment removeAxelaEmpDepartment(AxelaEmpDepartment axelaEmpDepartment) {
	// getAxelaEmpDepartments().remove(axelaEmpDepartment);
	// axelaEmpDepartment.setAxelaEmp(null);
	//
	// return axelaEmpDepartment;
	// }
	//
	// public List<AxelaEmpDoc> getAxelaEmpDocs() {
	// return this.axelaEmpDocs;
	// }
	//
	// public void setAxelaEmpDocs(List<AxelaEmpDoc> axelaEmpDocs) {
	// this.axelaEmpDocs = axelaEmpDocs;
	// }
	//
	// public AxelaEmpDoc addAxelaEmpDoc(AxelaEmpDoc axelaEmpDoc) {
	// getAxelaEmpDocs().add(axelaEmpDoc);
	// axelaEmpDoc.setAxelaEmp(this);
	//
	// return axelaEmpDoc;
	// }
	//
	// public AxelaEmpDoc removeAxelaEmpDoc(AxelaEmpDoc axelaEmpDoc) {
	// getAxelaEmpDocs().remove(axelaEmpDoc);
	// axelaEmpDoc.setAxelaEmp(null);
	//
	// return axelaEmpDoc;
	// }

	// public List<AxelaEmpExe> getAxelaEmpExes() {
	// return this.axelaEmpExes;
	// }

	// public void setAxelaEmpExes(List<AxelaEmpExe> axelaEmpExes) {
	// this.axelaEmpExes = axelaEmpExes;
	// }

	// public AxelaEmpExe addAxelaEmpExe(AxelaEmpExe axelaEmpExe) {
	// getAxelaEmpExes().add(axelaEmpExe);
	// axelaEmpExe.setAxelaEmp(this);
	//
	// return axelaEmpExe;
	// }
	//
	// public AxelaEmpExe removeAxelaEmpExe(AxelaEmpExe axelaEmpExe) {
	// getAxelaEmpExes().remove(axelaEmpExe);
	// axelaEmpExe.setAxelaEmp(null);
	//
	// return axelaEmpExe;
	// }

	// public List<AxelaEmpLeave> getAxelaEmpLeaves() {
	// return this.axelaEmpLeaves;
	// }
	//
	// public void setAxelaEmpLeaves(List<AxelaEmpLeave> axelaEmpLeaves) {
	// this.axelaEmpLeaves = axelaEmpLeaves;
	// }
	//
	// public AxelaEmpLeave addAxelaEmpLeave(AxelaEmpLeave axelaEmpLeave) {
	// getAxelaEmpLeaves().add(axelaEmpLeave);
	// axelaEmpLeave.setAxelaEmp(this);
	//
	// return axelaEmpLeave;
	// }
	//
	// public AxelaEmpLeave removeAxelaEmpLeave(AxelaEmpLeave axelaEmpLeave) {
	// getAxelaEmpLeaves().remove(axelaEmpLeave);
	// axelaEmpLeave.setAxelaEmp(null);
	//
	// return axelaEmpLeave;
	// }
	//
	public List<AxelaEmpLog> getAxelaEmpLogs() {
		return this.axelaEmpLogs;
	}

	public void setAxelaEmpLogs(List<AxelaEmpLog> axelaEmpLogs) {
		this.axelaEmpLogs = axelaEmpLogs;
	}

	public int getEmpBranchId() {
		return empBranchId;
	}

	public void setEmpBranchId(int empBranchId) {
		this.empBranchId = empBranchId;
	}

	public byte[] getEmpPhoto() {
		return empPhoto;
	}

	public void setEmpPhoto(byte[] empPhoto) {
		this.empPhoto = empPhoto;
	}
	//
	// public AxelaEmpLog addAxelaEmpLog(AxelaEmpLog axelaEmpLog) {
	// getAxelaEmpLogs().add(axelaEmpLog);
	// axelaEmpLog.setAxelaEmp(this);
	//
	// return axelaEmpLog;
	// }
	//
	// public AxelaEmpLog removeAxelaEmpLog(AxelaEmpLog axelaEmpLog) {
	// getAxelaEmpLogs().remove(axelaEmpLog);
	// axelaEmpLog.setAxelaEmp(null);
	//
	// return axelaEmpLog;
	// }
	//
	// public AxelaEmpRole getAxelaEmpRole() {
	// return this.axelaEmpRole;
	// }
	//
	// public void setAxelaEmpRole(AxelaEmpRole axelaEmpRole) {
	// this.axelaEmpRole = axelaEmpRole;
	// }
	//
	// public List<AxelaEmpUser> getAxelaEmpUsers() {
	// return this.axelaEmpUsers;
	// }
	//
	// public void setAxelaEmpUsers(List<AxelaEmpUser> axelaEmpUsers) {
	// this.axelaEmpUsers = axelaEmpUsers;
	// }
	//
	// public AxelaEmpUser addAxelaEmpUser(AxelaEmpUser axelaEmpUser) {
	// getAxelaEmpUsers().add(axelaEmpUser);
	// axelaEmpUser.setAxelaEmp(this);
	//
	// return axelaEmpUser;
	// }
	//
	// public AxelaEmpUser removeAxelaEmpUser(AxelaEmpUser axelaEmpUser) {
	// getAxelaEmpUsers().remove(axelaEmpUser);
	// axelaEmpUser.setAxelaEmp(null);
	//
	// return axelaEmpUser;
	// }

	@OneToMany(mappedBy = "axelaEmp")
	private List<AxelaSalesOppr> axelaSalesOppr;

	public List<AxelaSalesOppr> getAxelaSalesOppr() {
		return axelaSalesOppr;
	}

	public void setAxelaSalesOppr(List<AxelaSalesOppr> axelaSalesOppr) {
		this.axelaSalesOppr = axelaSalesOppr;
	}

	@OneToMany(mappedBy = "axelaEmp")
	private List<AxelaAccVoucher> axelaAccVoucher;

	public List<AxelaAccVoucher> getAxelaAccVoucher() {
		return axelaAccVoucher;
	}

	public void setAxelaAccVoucher(List<AxelaAccVoucher> axelaAccVoucher) {
		this.axelaAccVoucher = axelaAccVoucher;
	}

	public List<AxelaSalesCrm> getAxelaSalesCrm() {
		return axelaSalesCrm;
	}

	public void setAxelaSalesCrm(List<AxelaSalesCrm> axelaSalesCrm) {
		this.axelaSalesCrm = axelaSalesCrm;
	}

	@OneToMany(mappedBy = "axelaEmp")
	private List<AxelaSalesCrm> axelaSalesCrm;

	@OneToMany(mappedBy = "axelaEmp")
	private List<AxelaServiceJcBayTran> axelaServiceJcBayTran;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_id", referencedColumnName = "teamtrans_emp_id", insertable = false, updatable = false)
	private AxelaSalesTeamExe axelaSalesTeamExe;

	public AxelaSalesTeamExe getAxelaSalesTeamExe() {
		return axelaSalesTeamExe;
	}

	public void setAxelaSalesTeamExe(AxelaSalesTeamExe axelaSalesTeamExe) {
		this.axelaSalesTeamExe = axelaSalesTeamExe;
	}

	public List<AxelaServiceJcBayTran> getAxelaServiceJcBayTran() {
		return axelaServiceJcBayTran;
	}

	public void setAxelaServiceJcBayTran(List<AxelaServiceJcBayTran> axelaServiceJcBayTran) {
		this.axelaServiceJcBayTran = axelaServiceJcBayTran;
	}
	@OneToMany(mappedBy = "axelaEmp")
	private List<AxelaActivity> axelaActivity;

	@OneToMany(mappedBy = "axelaEmp")
	private List<AxelaEmpBranch> axelaEmpBranch;
}
//
