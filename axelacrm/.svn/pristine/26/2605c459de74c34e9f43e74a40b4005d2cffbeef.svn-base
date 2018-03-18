package axela.service.model;

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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import axela.customer.model.AxelaCustomer;
import axela.customer.model.AxelaCustomerContact;
import axela.portal.model.AxelaBranch;
import axela.portal.model.AxelaEmp;

/**
 * The persistent class for the axela_service_contract database table.
 * 
 */
@Entity
@Table(name = "axela_service_contract", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceContract.findAll", query = "SELECT a FROM AxelaServiceContract a")
public class AxelaServiceContract implements Serializable {
	private static final long serialVersionUID = 1L;

	// =========================================INNER JOIN variables=================================

	@Transient
	private int assetBranchId = 0; // From AxelaBranch

	@Transient
	private String assetBranchName = ""; // From AxelaBranch

	@Transient
	private String customerName = ""; // From AxelaCustomer

	@Transient
	private int customerId = 0; // From AxelaCustomer

	@Transient
	private String contactName = ""; // From AxelaCustomerContact

	@Transient
	private String contactPin = ""; // From AxelaCustomerContact

	@Transient
	private String contactAddress = ""; // From AxelaCustomerContact

	@Transient
	private String contactFirstName = ""; // From AxelaCustomerContact

	@Transient
	private String contactLastName = ""; // From AxelaCustomerContact

	@Transient
	private int contactId = 0; // AxelacustomerContact

	@Transient
	private String contactMobile1 = ""; // AxelacustomerContact

	@Transient
	private String contactPhone1 = ""; // AxelacustomerContact

	@Transient
	private int contracttypeId = 0; // AxelacustomerContact

	@Transient
	private String contracttypeName = ""; // AxelacustomerContact

	@Transient
	private String contactMobile2 = "";// AxelacustomerContact

	@Transient
	private String contactEmail1 = ""; // AxelacustomerContact

	@Transient
	private String contactEmail2 = ""; // AxelacustomerContact

	@Transient
	private String empName = ""; // AxelaEmp

	@Transient
	private int empId = 0; // AxelaEmp

	@Transient
	private String empGender = ""; // AxelaEmp

	@Transient
	private String empPhoto = "";

	@Transient
	private String contractno = "";

	@Transient
	private String titleId = "0";

	@Transient
	private String titleDesc = "";

	@Transient
	private String contactFname = "";

	@Transient
	private String contactLname = "";

	@Transient
	private String contactCityId = "";

	@Transient
	private long monthContract;
	@Transient
	private long todayContract;
	@Transient
	private long totalContract;

	public AxelaServiceContract(long monthContract,
			long todayContract) {
		super();
		this.monthContract = monthContract;
		this.todayContract = todayContract;
	}

	public long getMonthContract() {
		return monthContract;
	}

	public void setMonthContract(long monthContract) {
		this.monthContract = monthContract;
	}

	public long getTodayContract() {
		return todayContract;
	}

	public void setTodayContract(long todayContract) {
		this.todayContract = todayContract;
	}

	public long getTotalContract() {
		return totalContract;
	}

	public void setTotalContract(long totalContract) {
		this.totalContract = totalContract;
	}

	// =========================================Entity variables====================================

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contract_id")
	private int contractId;

	@Column(name = "contract_active")
	private String contractActive;

	@Column(name = "contract_amt")
	private double contractAmt;

	@Column(name = "contract_bill_address")
	private String contractBillAddress;

	@Column(name = "contract_bill_city")
	private String contractBillCity;

	@Column(name = "contract_bill_country")
	private String contractBillCountry;

	@Column(name = "contract_bill_pin")
	private String contractBillPin;

	@Column(name = "contract_bill_state")
	private String contractBillState;

	@Column(name = "contract_branch_id")
	private int contractBranchId;

	@Column(name = "contract_contact_id")
	private int contractContactId;

	@Column(name = "contract_contracttype_id")
	private int contractContracttypeId;

	@Column(name = "contract_customer_id")
	private int contractCustomerId;

	@Column(name = "contract_date")
	private Date contractDate;

	@Lob
	@Column(name = "contract_desc")
	private String contractDesc;

	@Column(name = "contract_discamt")
	private double contractDiscamt;

	@Column(name = "contract_emp_id")
	private int contractEmpId;

	@Column(name = "contract_end_date")
	private Date contractEndDate;

	@Column(name = "contract_entry_date")
	private Date contractEntryDate;

	@Column(name = "contract_entry_id")
	private int contractEntryId;

	@Column(name = "contract_grandtotal")
	private double contractGrandtotal;

	@Column(name = "contract_modified_date")
	private Date contractModifiedDate;

	@Column(name = "contract_modified_id")
	private int contractModifiedId;

	@Column(name = "contract_netamt")
	private double contractNetamt;

	@Column(name = "contract_no")
	private int contractNo;

	@Column(name = "contract_notes")
	private String contractNotes;

	@Column(name = "contract_po")
	private String contractPo;

	@Column(name = "contract_prioritycontract_id")
	private int contractPrioritycontractId;

	@Column(name = "contract_refno")
	private String contractRefno;

	@Column(name = "contract_service_address")
	private String contractServiceAddress;

	@Column(name = "contract_service_city")
	private String contractServiceCity;

	@Column(name = "contract_service_country")
	private String contractServiceCountry;

	@Column(name = "contract_service_pin")
	private String contractServicePin;

	@Column(name = "contract_service_state")
	private String contractServiceState;

	@Column(name = "contract_so_id")
	private int contractSoId;

	@Column(name = "contract_start_date")
	private Date contractStartDate;

	@Column(name = "contract_tax")
	private double contractTax;

	@Column(name = "contract_tax_id")
	private int contractTaxId;

	@Lob
	@Column(name = "contract_terms")
	private String contractTerms;

	@Column(name = "contract_ticketqueue_id")
	private int contractTicketqueueId;

	@Column(name = "contract_title")
	private String contractTitle;

	// =========================================Constructor====================================
	public AxelaServiceContract() {

	}

	public AxelaServiceContract(
			int contractId,
			int contractBranchId,
			int assetBranchId,
			int contactId,
			int contractTicketqueueId,
			String contractTitle,
			String assetBranchName,
			double contractTax,
			int contractNo,
			String contractno,
			int customerId,
			String customerName,
			Date contractDate,
			String contractRefno,
			double contractNetamt,
			String contracttypeName,
			int contractCustomerId,
			int contractContactId,
			Date contractStartDate,
			Date contractEndDate,
			double contractAmt,
			String contractDesc,
			String contractTerms,
			String contractNotes,
			double contractGrandtotal,
			String contactName,
			String contactMobile1,
			String contactMobile2,
			String contactEmail1,
			String contactEmail2,
			int empId,
			String empName,
			String empGender,
			int contractEntryId,
			Date contractEntryDate,
			int contractModifiedId,
			Date contractModifiedDate,
			String contractActive)
	{
		super();
		this.contractId = contractId;
		this.contractBranchId = contractBranchId;
		this.assetBranchId = assetBranchId;
		this.contactId = contactId;
		this.contractTicketqueueId = contractTicketqueueId;
		this.contractTitle = contractTitle;
		this.assetBranchName = assetBranchName;
		this.contractTax = contractTax;
		this.contractno = contractno;
		this.customerId = customerId;
		this.customerName = customerName;
		this.contractDate = contractDate;
		this.contractRefno = contractRefno;
		this.contractNetamt = contractNetamt;
		this.contracttypeName = contracttypeName;
		this.contractCustomerId = contractCustomerId;
		this.contractContactId = contractContactId;
		this.contractStartDate = contractStartDate;
		this.contractEndDate = contractEndDate;
		this.contractAmt = contractAmt;
		this.contractDesc = contractDesc;
		this.contractTerms = contractTerms;
		this.contractNotes = contractNotes;
		this.contractGrandtotal = contractGrandtotal;
		this.contactName = contactName;
		this.contactMobile1 = contactMobile1;
		this.contactMobile2 = contactMobile2;
		this.contactEmail1 = contactEmail1;
		this.contactEmail2 = contactEmail2;
		this.empId = empId;
		this.empName = empName;
		// this.empPhoto = empPhoto;
		this.empGender = empGender;
		this.contractEntryId = contractEntryId;
		this.contractEntryDate = contractEntryDate;
		this.contractModifiedId = contractModifiedId;
		this.contractModifiedDate = contractModifiedDate;
		this.contractActive = contractActive;
	}

	public AxelaServiceContract(
			int contractBranchId,
			int contractContracttypeId,
			Date contractDate,
			Date contractStartDate,
			Date contractEndDate,
			String contractTitle,
			int contractContactId,
			int contractTicketqueueId,
			double contractAmt,
			int contractTaxId,
			double contractDiscamt,
			double contractNetamt,
			double contractGrandtotal,
			double contractTax,
			String contractBillAddress,
			String contractBillCity,
			String contractBillPin,
			String contractBillState,
			String contractBillCountry,
			String contractServiceAddress,
			String contractServiceCity,
			String contractServicePin,
			String contractServiceState,
			String contractServiceCountry,
			String contractDesc,
			String contractTerms,
			int contractEmpId,
			String contractPo,
			int contractPrioritycontractId,
			String contractRefno,
			String contractActive,
			String contractNotes,
			Date contractEntryDate,
			int contractEntryId,
			Date contractModifiedDate,
			int contractModifiedId,
			int titleId,
			String titleDesc,
			String contactFname,
			String contactLname,
			String contactMobile1,
			String contactPhone1,
			String contactEmail1,
			String contactPin,
			int contactId,
			String contactCityId,
			int customerId,
			String customerName,
			String contactAddress) {
		super();
		this.contractActive = contractActive;
		this.contractAmt = contractAmt;
		this.contractBillAddress = contractBillAddress;
		this.contractBillCity = contractBillCity;
		this.contractBillCountry = contractBillCountry;
		this.contractBillPin = contractBillPin;
		this.contractBillState = contractBillState;
		this.contractBranchId = contractBranchId;
		this.contractContactId = contractContactId;
		this.contractContracttypeId = contractContracttypeId;
		this.contractDate = contractDate;
		this.contractDesc = contractDesc;
		this.contractDiscamt = contractDiscamt;
		this.contractEmpId = contractEmpId;
		this.contractEndDate = contractEndDate;
		this.contractGrandtotal = contractGrandtotal;
		this.contractNetamt = contractNetamt;
		this.contractNotes = contractNotes;
		this.contractEntryDate = contractEntryDate;
		this.contractEntryId = contractEntryId;
		this.contractModifiedDate = contractModifiedDate;
		this.contractModifiedId = contractModifiedId;
		this.contractPo = contractPo;
		this.contractPrioritycontractId = contractPrioritycontractId;
		this.contractRefno = contractRefno;
		this.contractServiceAddress = contractServiceAddress;
		this.contractServiceCity = contractServiceCity;
		this.contractServiceCountry = contractServiceCountry;
		this.contractServicePin = contractServicePin;
		this.contractServiceState = contractServiceState;
		this.contractStartDate = contractStartDate;
		this.contractTax = contractTax;
		this.contractTaxId = contractTaxId;
		this.contractTerms = contractTerms;
		this.contractTicketqueueId = contractTicketqueueId;
		this.contractTitle = contractTitle;
		this.titleId = String.valueOf(titleId);
		this.titleDesc = titleDesc;
		this.contactFname = contactFname;
		this.contactLname = contactLname;
		this.contactMobile1 = contactMobile1;
		this.contactPhone1 = contactPhone1;
		this.contactEmail1 = contactEmail1;
		this.contactPin = contactPin;
		this.contactId = contactId;
		this.contactCityId = contactCityId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactAddress = contactAddress;
	}

	// =========================================Entity Relationships====================================

	@OneToMany(mappedBy = "axelaServiceContract")
	private List<AxelaServiceContractAssetTran> axelaServiceContractAssetTran;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contract_branch_id", referencedColumnName = "branch_id", insertable = false, updatable = false)
	private AxelaBranch axelaBranch;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contract_contracttype_id", referencedColumnName = "contracttype_id", insertable = false, updatable = false)
	private AxelaServiceContractType axelaServiceContractType;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "contract_id", referencedColumnName = "asset_customer_id", insertable = false, updatable = false)
	// public AxelaServiceContractAsset axelaServiceContractAsset;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contract_emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contract_contact_id", referencedColumnName = "contact_id", insertable = false, updatable = false)
	private AxelaCustomerContact axelaCustomerContact;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contract_customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
	private AxelaCustomer axelaCustomers;

	// @ManyToOne
	// @NotFound(action = NotFoundAction.IGNORE)
	// @JoinColumn(name = "contact_title_id", referencedColumnName = "title_id", insertable = false, updatable = false)
	// public AxelaTitle axelaTitle;

	// =========================================Entity setters and getters====================================

	// public AxelaServiceContractAsset getAxelaServiceContractAsset() {
	// return axelaServiceContractAsset;
	// }
	//
	// public void setAxelaServiceContractAsset(AxelaServiceContractAsset axelaServiceContractAsset) {
	// this.axelaServiceContractAsset = axelaServiceContractAsset;
	// }

	// public AxelaTitle getAxelaTitle() {
	// return axelaTitle;
	// }
	//
	// public void setAxelaTitle(AxelaTitle axelaTitle) {
	// this.axelaTitle = axelaTitle;
	// }

	public int getContractId() {
		return this.contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public String getContractActive() {
		return this.contractActive;
	}

	public void setContractActive(String contractActive) {
		this.contractActive = contractActive;
	}

	public List<AxelaServiceContractAssetTran> getAxelaServiceContractAssetTran() {
		return axelaServiceContractAssetTran;
	}

	public void setAxelaServiceContractAssetTran(List<AxelaServiceContractAssetTran> axelaServiceContractAssetTran) {
		this.axelaServiceContractAssetTran = axelaServiceContractAssetTran;
	}

	public double getContractAmt() {
		return this.contractAmt;
	}

	public void setContractAmt(double contractAmt) {
		this.contractAmt = contractAmt;
	}

	public String getContactPhone1() {
		return contactPhone1;
	}

	public void setContactPhone1(String contactPhone1) {
		this.contactPhone1 = contactPhone1;
	}

	public String getContractBillAddress() {
		return this.contractBillAddress;
	}

	public void setContractBillAddress(String contractBillAddress) {
		this.contractBillAddress = contractBillAddress;
	}

	public String getContractBillCity() {
		return this.contractBillCity;
	}

	public void setContractBillCity(String contractBillCity) {
		this.contractBillCity = contractBillCity;
	}

	public String getContractBillCountry() {
		return this.contractBillCountry;
	}

	public void setContractBillCountry(String contractBillCountry) {
		this.contractBillCountry = contractBillCountry;
	}

	public String getContractBillPin() {
		return this.contractBillPin;
	}

	public void setContractBillPin(String contractBillPin) {
		this.contractBillPin = contractBillPin;
	}

	public String getContractBillState() {
		return this.contractBillState;
	}

	public void setContractBillState(String contractBillState) {
		this.contractBillState = contractBillState;
	}

	public String getContactFirstName() {
		return contactFirstName;
	}

	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	public int getContractBranchId() {
		return this.contractBranchId;
	}

	public void setContractBranchId(int contractBranchId) {
		this.contractBranchId = contractBranchId;
	}

	public int getContractContactId() {
		return this.contractContactId;
	}

	public void setContractContactId(int contractContactId) {
		this.contractContactId = contractContactId;
	}

	public int getContractContracttypeId() {
		return this.contractContracttypeId;
	}

	public void setContractContracttypeId(int contractContracttypeId) {
		this.contractContracttypeId = contractContracttypeId;
	}

	public String getContracttypeName() {
		return contracttypeName;
	}

	public void setContracttypeName(String contracttypeName) {
		this.contracttypeName = contracttypeName;
	}

	public int getContractCustomerId() {
		return this.contractCustomerId;
	}

	public void setContractCustomerId(int contractCustomerId) {
		this.contractCustomerId = contractCustomerId;
	}

	public Date getContractDate() {
		return this.contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	public String getContractDesc() {
		return this.contractDesc;
	}

	public void setContractDesc(String contractDesc) {
		this.contractDesc = contractDesc;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public double getContractDiscamt() {
		return this.contractDiscamt;
	}

	public void setContractDiscamt(double contractDiscamt) {
		this.contractDiscamt = contractDiscamt;
	}

	public String getTitleDesc() {
		return titleDesc;
	}

	public void setTitleDesc(String titleDesc) {
		this.titleDesc = titleDesc;
	}

	public int getContractEmpId() {
		return this.contractEmpId;
	}

	public void setContractEmpId(int contractEmpId) {
		this.contractEmpId = contractEmpId;
	}

	public Date getContractEndDate() {
		return this.contractEndDate;
	}

	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	public Date getContractEntryDate() {
		return this.contractEntryDate;
	}

	public void setContractEntryDate(Date contractEntryDate) {
		this.contractEntryDate = contractEntryDate;
	}

	public int getContractEntryId() {
		return this.contractEntryId;
	}

	public void setContractEntryId(int contractEntryId) {
		this.contractEntryId = contractEntryId;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public double getContractGrandtotal() {
		return this.contractGrandtotal;
	}

	public String getContractno() {
		return contractno;
	}

	public void setContractno(String contractno) {
		this.contractno = contractno;
	}

	public void setContractGrandtotal(double contractGrandtotal) {
		this.contractGrandtotal = contractGrandtotal;
	}

	public Date getContractModifiedDate() {
		return this.contractModifiedDate;
	}

	public void setContractModifiedDate(Date contractModifiedDate) {
		this.contractModifiedDate = contractModifiedDate;
	}

	public int getContractModifiedId() {
		return this.contractModifiedId;
	}

	public void setContractModifiedId(int contractModifiedId) {
		this.contractModifiedId = contractModifiedId;
	}

	public double getContractNetamt() {
		return this.contractNetamt;
	}

	public void setContractNetamt(double contractNetamt) {
		this.contractNetamt = contractNetamt;
	}

	public int getContractNo() {
		return this.contractNo;
	}

	public void setContractNo(int contractNo) {
		this.contractNo = contractNo;
	}

	public String getContractNotes() {
		return this.contractNotes;
	}

	public void setContractNotes(String contractNotes) {
		this.contractNotes = contractNotes;
	}

	public String getContractPo() {
		return this.contractPo;
	}

	public void setContractPo(String contractPo) {
		this.contractPo = contractPo;
	}

	public int getContractPrioritycontractId() {
		return this.contractPrioritycontractId;
	}

	public void setContractPrioritycontractId(int contractPrioritycontractId) {
		this.contractPrioritycontractId = contractPrioritycontractId;
	}

	public String getContractRefno() {
		return this.contractRefno;
	}

	public void setContractRefno(String contractRefno) {
		this.contractRefno = contractRefno;
	}

	public String getContractServiceAddress() {
		return this.contractServiceAddress;
	}

	public void setContractServiceAddress(String contractServiceAddress) {
		this.contractServiceAddress = contractServiceAddress;
	}

	public String getContractServiceCity() {
		return this.contractServiceCity;
	}

	public void setContractServiceCity(String contractServiceCity) {
		this.contractServiceCity = contractServiceCity;
	}

	public String getContractServiceCountry() {
		return this.contractServiceCountry;
	}

	public void setContractServiceCountry(String contractServiceCountry) {
		this.contractServiceCountry = contractServiceCountry;
	}

	public String getContractServicePin() {
		return this.contractServicePin;
	}

	public void setContractServicePin(String contractServicePin) {
		this.contractServicePin = contractServicePin;
	}

	public String getContractServiceState() {
		return this.contractServiceState;
	}

	public void setContractServiceState(String contractServiceState) {
		this.contractServiceState = contractServiceState;
	}

	public int getContractSoId() {
		return this.contractSoId;
	}

	public void setContractSoId(int contractSoId) {
		this.contractSoId = contractSoId;
	}

	public Date getContractStartDate() {
		return this.contractStartDate;
	}

	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public double getContractTax() {
		return this.contractTax;
	}

	public void setContractTax(double contractTax) {
		this.contractTax = contractTax;
	}

	public int getContractTaxId() {
		return this.contractTaxId;
	}

	public void setContractTaxId(int contractTaxId) {
		this.contractTaxId = contractTaxId;
	}

	public String getContractTerms() {
		return this.contractTerms;
	}

	public void setContractTerms(String contractTerms) {
		this.contractTerms = contractTerms;
	}

	public int getContractTicketqueueId() {
		return this.contractTicketqueueId;
	}

	public void setContractTicketqueueId(int contractTicketqueueId) {
		this.contractTicketqueueId = contractTicketqueueId;
	}

	public String getContractTitle() {
		return this.contractTitle;
	}

	public void setContractTitle(String contractTitle) {
		this.contractTitle = contractTitle;
	}

	public int getAssetBranchId() {
		return assetBranchId;
	}

	public void setAssetBranchId(int assetBranchId) {
		this.assetBranchId = assetBranchId;
	}

	public String getAssetBranchName() {
		return assetBranchName;
	}

	public void setAssetBranchName(String assetBranchName) {
		this.assetBranchName = assetBranchName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getContactMobile1() {
		return contactMobile1;
	}

	public void setContactMobile1(String contactMobile1) {
		this.contactMobile1 = contactMobile1;
	}

	public int getContracttypeId() {
		return contracttypeId;
	}

	public void setContracttypeId(int contracttypeId) {
		this.contracttypeId = contracttypeId;
	}

	public String getContactMobile2() {
		return contactMobile2;
	}

	public void setContactMobile2(String contactMobile2) {
		this.contactMobile2 = contactMobile2;
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

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
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

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public AxelaBranch getAxelaBranch() {
		return axelaBranch;
	}

	public void setAxelaBranch(AxelaBranch axelaBranch) {
		this.axelaBranch = axelaBranch;
	}

	public AxelaServiceContractType getAxelaServiceContractType() {
		return axelaServiceContractType;
	}

	public void setAxelaServiceContractType(AxelaServiceContractType axelaServiceContractType) {
		this.axelaServiceContractType = axelaServiceContractType;
	}

	public AxelaEmp getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(AxelaEmp axelaEmp) {
		this.axelaEmp = axelaEmp;
	}

	public AxelaCustomerContact getAxelaCustomerContact() {
		return axelaCustomerContact;
	}

	public void setAxelaCustomerContact(AxelaCustomerContact axelaCustomerContact) {
		this.axelaCustomerContact = axelaCustomerContact;
	}

	public AxelaCustomer getAxelaCustomers() {
		return axelaCustomers;
	}

	public void setAxelaCustomers(AxelaCustomer axelaCustomers) {
		this.axelaCustomers = axelaCustomers;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getContactCityId() {
		return contactCityId;
	}

	public String getContactPin() {
		return contactPin;
	}

	public void setContactPin(String contactPin) {
		this.contactPin = contactPin;
	}

	public void setContactCityId(String contactCityId) {
		this.contactCityId = contactCityId;
	}
}