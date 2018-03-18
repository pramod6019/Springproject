package axela.sales.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import axela.portal.model.AxelaComp;

/**
 * The persistent class for the axela_uni_emp database table.
 * 
 */
@Entity
@Table(name = "axela_uni_emp", catalog = "axela")
@NamedQuery(name = "AxelaUniEmp.findAll", query = "SELECT a FROM AxelaUniEmp a")
public class AxelaUniEmp implements Serializable {
	public String getCompModulePm() {
		return compModulePm;
	}

	public void setCompModulePm(String compModulePm) {
		this.compModulePm = compModulePm;
	}

	private static final long serialVersionUID = 1L;

	@Transient
	private String compActive = "";
	@Transient
	private String compName = "";
	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	@Transient
	private String compModuleSales = "";
	@Transient
	private String compModuleHelpdesk = "";
	@Transient
	private String compModuleService = "";
	@Transient
	private String compModuleAccounting = "";
	@Transient
	private String compModulePm = "";

	@Id
	@Column(name = "emp_id")
	private int empId;

	@Column(name = "comp_id")
	private int compId;

	@Column(name = "emp_active")
	private String empActive;

	@Column(name = "emp_all_exe")
	private String empAllExe;

	@Column(name = "emp_branch_id")
	private int empBranchId;

	@Column(name = "emp_device_fcmtoken")
	private String empDeviceFcmtoken;

	@Column(name = "emp_device_id")
	private String empDeviceId;

	@Column(name = "emp_device_os")
	private String empDeviceOs;

	@Column(name = "emp_email1")
	private String empEmail1;

	@Column(name = "emp_entry_date")
	private String empEntryDate;

	@Column(name = "emp_entry_id")
	private int empEntryId;

	@Column(name = "emp_ip_access")
	private String empIpAccess;

	@Column(name = "emp_modified_date")
	private String empModifiedDate;

	@Column(name = "emp_modified_id")
	private int empModifiedId;

	@Column(name = "emp_name")
	private String empName;

	@Column(name = "emp_recperpage")
	private byte empRecperpage;

	@Column(name = "emp_role_id")
	private int empRoleId;

	@Column(name = "emp_sales")
	private String empSales;

	@Column(name = "emp_upass")
	private String empUpass;

	@Column(name = "emp_uuid")
	private String empUuid;

	public AxelaUniEmp() {
	}
	// Query += "a.empName,"
	// + "a.empEmail1,"
	// + "a.empUpass,"
	// + "a.empUuid,"
	// + "a.empAllExe,"
	// + "a.axelaComp.compId,"
	// + "a.empDeviceId,"
	// + "a.empActive,"
	// + "a.axelaComp.compActive,"
	// + "a.axelaComp.compModuleSales,"
	// + "a.axelaComp.compModulePm,"
	// + "a.axelaComp.compModuleService,"
	// + "a.axelaComp.compModuleAccounting,"
	// + " FROM AxelaUniEmp a"
	// + " INNER JOIN a.axelaComp"
	// + " WHERE emp_email1=" + signinid + " AND emp_upass=" + password;

	public AxelaUniEmp(int empId,
			String empName, String empEmail1, String empUpass, String empUuid, String empAllExe, int compId, String compName, String empDeviceId, String empActive, String compActive,
			String compModuleSales, String compModuleHelpdesk, String compModuleService, String compModuleAccounting, String compModulePm, int empRoleId) {
		this.empId = empId;
		this.empName = empName;
		this.empEmail1 = empEmail1;
		this.empUpass = empUpass;
		this.empUuid = empUuid;
		this.compId = compId;
		this.compName = compName;
		this.empDeviceId = empDeviceId;
		this.empActive = empActive;
		this.compActive = compActive;
		this.compModuleSales = compModuleSales;
		this.compModuleHelpdesk = compModuleHelpdesk;
		this.compModuleService = compModuleService;
		this.compModuleAccounting = compModuleAccounting;
		this.compModulePm = compModulePm;
		this.empRoleId = empRoleId;

	}

	public String getCompActive() {
		return compActive;
	}

	public void setCompActive(String compActive) {
		this.compActive = compActive;
	}

	public String getCompModuleSales() {
		return compModuleSales;
	}

	public void setCompModuleSales(String compModuleSales) {
		this.compModuleSales = compModuleSales;
	}

	// public String getCompModulePm() {
	// return compModulePm;
	// }
	//
	// public void setCompModulePm(String compModulePm) {
	// this.compModulePm = compModulePm;
	// }

	public String getCompModuleService() {
		return compModuleService;
	}

	public String getCompModuleHelpdesk() {
		return compModuleHelpdesk;
	}

	public void setCompModuleHelpdesk(String compModuleHelpdesk) {
		this.compModuleHelpdesk = compModuleHelpdesk;
	}

	public void setCompModuleService(String compModuleService) {
		this.compModuleService = compModuleService;
	}

	public String getCompModuleAccounting() {
		return compModuleAccounting;
	}

	public void setCompModuleAccounting(String compModuleAccounting) {
		this.compModuleAccounting = compModuleAccounting;
	}

	public int getempId() {
		return this.empId;
	}

	public void setempId(int empId) {
		this.empId = empId;
	}

	public int getcompId() {
		return this.compId;
	}

	public void setcompId(int compId) {
		this.compId = compId;
	}

	public String getEmpActive() {
		return this.empActive;
	}

	public void setEmpActive(String empActive) {
		this.empActive = empActive;
	}

	public String getEmpAllExe() {
		return this.empAllExe;
	}

	public void setEmpAllExe(String empAllExe) {
		this.empAllExe = empAllExe;
	}

	public int getEmpBranchId() {
		return this.empBranchId;
	}

	public void setEmpBranchId(int empBranchId) {
		this.empBranchId = empBranchId;
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

	public String getEmpEmail1() {
		return this.empEmail1;
	}

	public void setEmpEmail1(String empEmail1) {
		this.empEmail1 = empEmail1;
	}

	public String getEmpEntryDate() {
		return this.empEntryDate;
	}

	public void setEmpEntryDate(String empEntryDate) {
		this.empEntryDate = empEntryDate;
	}

	public int getEmpEntryId() {
		return this.empEntryId;
	}

	public void setEmpEntryId(int empEntryId) {
		this.empEntryId = empEntryId;
	}

	public String getEmpIpAccess() {
		return this.empIpAccess;
	}

	public void setEmpIpAccess(String empIpAccess) {
		this.empIpAccess = empIpAccess;
	}

	public String getEmpModifiedDate() {
		return this.empModifiedDate;
	}

	public void setEmpModifiedDate(String empModifiedDate) {
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

	public byte getEmpRecperpage() {
		return this.empRecperpage;
	}

	public void setEmpRecperpage(byte empRecperpage) {
		this.empRecperpage = empRecperpage;
	}

	public int getEmpRoleId() {
		return this.empRoleId;
	}

	public void setEmpRoleId(int empRoleId) {
		this.empRoleId = empRoleId;
	}

	public String getEmpSales() {
		return this.empSales;
	}

	public void setEmpSales(String empSales) {
		this.empSales = empSales;
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

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comp_id", referencedColumnName = "comp_id", insertable = false, updatable = false)
	private AxelaComp axelaComp;

}