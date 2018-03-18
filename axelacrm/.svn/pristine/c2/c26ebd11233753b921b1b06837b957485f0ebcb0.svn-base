package axela.customer.model;

import java.math.BigDecimal;
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

import axela.accounting.model.AxelaAccVoucher;
import axela.inventory.model.AxelaInventoryItemPrice;
import axela.portal.model.AxelaAccGroupPop;
import axela.portal.model.AxelaBranch;
import axela.portal.model.AxelaCity;
import axela.portal.model.AxelaEmp;
import axela.portal.model.AxelaEmpcount;
import axela.portal.model.AxelaSob;
import axela.portal.model.AxelaSoe;
import axela.sales.model.AxelaSalesOppr;
import axela.service.model.AxelaServiceContract;
import axela.service.model.AxelaServiceContractAsset;
import axela.service.model.AxelaServiceJc;

/**
 * The persistent class for the axela_customer database table.
 * 
 */
@Entity
@Table(name = "axela_customer", catalog = AxelaCustomer.comp_db)
@NamedQuery(name = "AxelaCustomer.findAll", query = "SELECT a FROM AxelaCustomer a")
public class AxelaCustomer {
	public static final String comp_db = "axela_1";
	// =========================================LEFT JOIN variables=================================
	@Transient
	private String customerCityName = ""; // from AxelaCity

	@Transient
	private String customerStateName = "";// from AxelaState

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getCustomerStateName() {
		return customerStateName;
	}
	@Transient
	public int branchId;

	public void setCustomerStateName(String customerStateName) {
		this.customerStateName = customerStateName;
	}

	public String getCustomerCountryName() {
		return customerCountryName;
	}

	public void setCustomerCountryName(String customerCountryName) {
		this.customerCountryName = customerCountryName;
	}

	@Transient
	private String customerCountryName = "";// from AxelaCountry
	@Transient
	private String customerSoeName = "";// from AxelaSoe
	@Transient
	private String customerSobName = "";// from AxelaSob
	@Transient
	private String customerEmpName = "";// from AxelaEmp
	@Transient
	private String customerBranchName = "";// from AxelaBranch
	@Transient
	private long customerContactCount = 0;// from AxelaCustomerContact

	// recent customer landing page
	@Transient
	private BigDecimal voucherAmount;//

	// customer summary langing page
	@Transient
	private String branchName;

	@Transient
	private String branchCode;

	@Transient
	private Long customersCount;

	@Transient
	private Long voucherAmounts;

	// customer dash
	@Transient
	private String cityName;

	@Transient
	private String countryName;

	@Transient
	private String empName;

	// =========================================Entity variables====================================

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id", nullable = false)
	private int customerId;

	@Column(name = "customer_accgroup_id")
	private int customerAccgroupId;

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

	public Long getCustomersCount() {
		return customersCount;
	}

	public void setCustomersCount(Long customersCount) {
		this.customersCount = customersCount;
	}

	@Column(name = "customer_active")
	private String customerActive;

	@Column(name = "customer_address1")
	private String customerAddress1;

	@Column(name = "customer_address2")
	private String customerAddress2;

	@Column(name = "customer_arn_no")
	private String customerArnNo;

	@Column(name = "customer_branch_id")
	private int customerBranchId;

	@Column(name = "customer_city_id")
	private int customerCityId;

	@Column(name = "customer_code")
	private String customerCode;

	@Column(name = "customer_credit_limit")
	private double customerCreditLimit;

	@Column(name = "customer_curr_bal")
	private double customerCurrBal;

	@Column(name = "customer_disc_perc")
	private double customerDiscPerc;

	@Column(name = "customer_email1")
	private String customerEmail1;

	@Column(name = "customer_email2")
	private String customerEmail2;

	@Column(name = "customer_emp_id")
	private int customerEmpId;

	@Column(name = "customer_empcount_id")
	private int customerEmpcountId;

	@Column(name = "customer_entry_date")
	private Date customerEntryDate;

	@Column(name = "customer_entry_id")
	private int customerEntryId;

	@Column(name = "customer_fax1")
	private String customerFax1;

	@Column(name = "customer_fax2")
	private String customerFax2;

	@Column(name = "customer_itstatus_id")
	private String customerItstatusId = "";

	// @Column(customer_name = "customer_gst_doc")
	// private Object customerGstDoc;

	@Column(name = "customer_gst_doc_value")
	private String customerGstDocValue;

	@Column(name = "customer_gst_no")
	private String customerGstNo;

	@Column(name = "customer_gst_regdate")
	private Date customerGstRegdate;

	@Column(name = "customer_landmark")
	private String customerLandmark;

	@Column(name = "customer_ledgertype")
	private int customerLedgertype;

	@Column(name = "customer_mobile1")
	private String customerMobile1;

	@Column(name = "customer_mobile2")
	private String customerMobile2;

	@Column(name = "customer_modified_date")
	private Date customerModifiedDate;

	@Column(name = "customer_modified_id")
	private int customerModifiedId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_notes")
	private String customerNotes;

	// @Column(name = "customer_open_bal")
	// private double customerOpenBal;

	@Column(name = "customer_pan_no")
	private String customerPanNo;

	@Column(name = "customer_paydays_id")
	private int customerPaydaysId;

	@Column(name = "customer_phone1")
	private String customerPhone1;

	@Column(name = "customer_phone2")
	private String customerPhone2;

	@Column(name = "customer_phone3")
	private String customerPhone3;

	@Column(name = "customer_phone4")
	private String customerPhone4;

	@Column(name = "customer_pin")
	private String customerPin;

	@Column(name = "customer_rate")
	private double customerRate;

	@Column(name = "customer_rateclass_id")
	private int customerRateclassId;

	@Column(name = "customer_reconciliation")
	private String customerReconciliation;

	@Column(name = "customer_round")
	private short customerRound;

	@Column(name = "customer_service_tax_no")
	private String customerServiceTaxNo;

	@Column(name = "customer_since")
	private Date customerSince;

	@Column(name = "customer_sob_id")
	private int customerSobId;

	@Column(name = "customer_soe_id")
	private int customerSoeId;

	@Column(name = "customer_tax")
	private String customerTax;

	@Column(name = "customer_taxcat_id")
	private int customerTaxcatId;

	@Column(name = "customer_taxtype_id")
	private int customerTaxtypeId;

	@Column(name = "customer_tds")
	private String customerTds;

	@Column(name = "customer_tin_no")
	private String customerTinNo;

	@Column(name = "customer_type")
	private int customerType;

	@Column(name = "customer_user_entry_date")
	private Date customerUserEntryDate;

	@Column(name = "customer_user_modified_date")
	private Date customerUserModifiedDate;

	@Column(name = "customer_website1")
	private String customerWebsite1;

	@Column(name = "customer_website2")
	private String customerWebsite2;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	// =========================================Constructor====================================

	public AxelaCustomer() {

	}

	// @OneToMany(mappedBy = "axelaCustomers", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// private List<AxelaCustomerContact> axelaCustomerContact;

	public AxelaCustomer(int customerId, String customerName, String customerActive, double customerCurrBal, String customerMobile1, String customerMobile2, String customerPhone1,
			String customerPhone2, String customerPhone3, String customerPhone4, String customerEmail1, String customerFax1, String customerFax2, String customerEmail2, String customerWebsite1,
			String customerWebsite2, String customerAddress1, String customerAddress2, String customerPin, String customerLandmark, int customerType, String customerCityName,
			String customerStateName, String customerCountryName, String customerSoeName,
			String customerSobName, String customerEmpName, String customerBranchName, long customerContactCount) {

		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerActive = customerActive;
		this.customerCurrBal = customerCurrBal;
		this.customerMobile1 = customerMobile1;
		this.customerMobile2 = customerMobile2;
		this.customerPhone1 = customerPhone1;
		this.customerPhone2 = customerPhone2;
		this.customerPhone3 = customerPhone3;
		this.customerPhone4 = customerPhone4;
		this.customerEmail1 = customerEmail1;
		this.customerEmail2 = customerEmail2;
		this.customerFax1 = customerFax1;
		this.customerFax2 = customerFax2;
		this.customerWebsite1 = customerWebsite1;
		this.customerWebsite2 = customerWebsite2;
		this.customerAddress1 = customerAddress1;
		this.customerAddress2 = customerAddress2;
		this.customerPin = customerPin;
		this.customerLandmark = customerLandmark;
		this.customerType = customerType; // Upto here from AxelaCustomer
		this.customerCityName = customerCityName; // from AxelaCity
		this.customerStateName = customerStateName;// from AxelaState
		this.customerCountryName = customerCountryName;// from AxelaCountry
		this.customerSoeName = customerSoeName;// from AxelaSoe
		this.customerSobName = customerSobName;// from AxelaSob
		this.customerEmpName = customerEmpName;// from AxelaEmp
		this.customerBranchName = customerBranchName;// from AxelaBranch
		this.customerContactCount = customerContactCount;// from AxelaCustomerContact
	}

	// recent customer landing page
	public AxelaCustomer(int customerId,
			String customerName,
			BigDecimal voucherAmount) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.voucherAmount = voucherAmount;
	}

	// customer summary landing page
	// + " customer.customerId,"
	// + " customer.branchName,"
	// + " customer.branchCode,"
	// + " COUNT(customer.customerId)"
	public AxelaCustomer(
			int customerId,
			String customerName,
			double customerCurrBal) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerCurrBal = customerCurrBal;

	}

	// top customer over due report page

	public AxelaCustomer(
			int branchId,
			String branchName,
			String branchCode,
			Long customersCount) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchCode = branchCode;
		this.customersCount = customersCount;

	}

	// customer dash
	public AxelaCustomer(
			String branchName,
			String branchCode,
			int branchId,
			String customerAddress1,
			String customerLandmark,
			String customerPhone1,
			String customerPhone2,
			String customerPhone3,
			String customerEmail1,
			int customerEmpId,
			String customerWebsite1,
			String customerWebsite2,
			String customerPin,
			String customerNotes,
			String customerActive,
			String cityName,
			String countryName,
			String empName)

	{
		super();
		this.branchName = branchName;
		this.branchCode = branchCode;
		this.branchId = branchId;
		this.customerAddress1 = customerAddress1;
		this.customerLandmark = customerLandmark;
		this.customerPhone1 = customerPhone1;
		this.customerPhone2 = customerPhone2;
		this.customerPhone3 = customerPhone3;
		this.customerEmail1 = customerEmail1;
		this.customerEmpId = customerEmpId;
		this.customerWebsite1 = customerWebsite1;
		this.customerWebsite2 = customerWebsite2;
		this.customerPin = customerPin;
		this.customerNotes = customerNotes;
		this.customerActive = customerActive;
		this.cityName = cityName;
		this.countryName = countryName;
		this.empName = empName;

	}
	// =========================================Entity Relationships====================================

	// many-to-one association to AxelaEmp
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

	// ManyToOne realtion with axelasoe
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_soe_id", referencedColumnName = "soe_id", insertable = false, updatable = false)
	private AxelaSoe axelaSoe;

	// ManyToOne realtion with axelasob
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_sob_id", referencedColumnName = "sob_id", insertable = false, updatable = false)
	private AxelaSob axelaSob;

	// many-to-one realtion with Axela_City
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_city_id", referencedColumnName = "city_id", insertable = false, updatable = false)
	private AxelaCity axelaCity;

	// many-to-one realtion with AxelaBranch
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_branch_id", referencedColumnName = "branch_id", insertable = false, updatable = false)
	private AxelaBranch axelaBranch;

	// many-to-one realtion with AxelaEmpCount
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_empcount_id", referencedColumnName = "empcount_id", insertable = false, updatable = false)
	private AxelaEmpcount axelaEmpcount;

	public List<AxelaSalesOppr> getAxelaSalesOppr() {
		return axelaSalesOppr;
	}

	public void setAxelaSalesOppr(List<AxelaSalesOppr> axelaSalesOppr) {
		this.axelaSalesOppr = axelaSalesOppr;
	}

	@OneToMany(mappedBy = "axelaCustomers")
	private List<AxelaCustomerContact> axelaCustomerContact;

	@OneToMany(mappedBy = "axelaCustomers")
	private List<AxelaServiceContractAsset> axelaServiceContractAsset;

	@OneToMany(mappedBy = "axelaCustomers")
	private List<AxelaServiceContract> axelaServiceContract;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_accgroup_id", referencedColumnName = "accgrouppop_id", insertable = false, updatable = false)
	private AxelaAccGroupPop axelaAccGroupPop;

	@OneToMany(mappedBy = "axelaCustomer")
	private List<AxelaSalesOppr> axelaSalesOppr;

	@OneToMany(mappedBy = "axelaCustomer")
	private List<AxelaInventoryItemPrice> axelaInventoryItemPrice;

	@OneToMany(mappedBy = "axelaCustomer")
	private List<AxelaAccVoucher> axelaAccVoucher;
	// bi-directional many-to-one association to AxelaCustomerDoc
	// @ManyToOne
	// @JoinColumn(customer_name = "customer_id", referencedColumnName = "doc_customer_id")
	// private AxelaCustomerDoc axelaCustomerDoc;

	// bi-directional many-to-one association to AxelaCustomerItstatus
	// @ManyToOne
	// @JoinColumn(customer_name = "customer_itstatus_id")
	// private AxelaCustomerItstatus axelaCustomerItstatus;

	// =========================================Entity setters and getters====================================

	public List<AxelaServiceContractAsset> getAxelaServiceContractAsset() {
		return axelaServiceContractAsset;
	}

	public void setAxelaServiceContractAsset(List<AxelaServiceContractAsset> axelaServiceContractAsset) {
		this.axelaServiceContractAsset = axelaServiceContractAsset;
	}

	public List<AxelaServiceContract> getAxelaServiceContract() {
		return axelaServiceContract;
	}

	public void setAxelaServiceContract(List<AxelaServiceContract> axelaServiceContract) {
		this.axelaServiceContract = axelaServiceContract;
	}

	// public List<AxelaCustomerContact> getAxelaCustomerContact() {
	// return axelaCustomerContact;
	// }

	// public void setAxelaCustomerContact(List<AxelaCustomerContact> axelaCustomerContact) {
	// this.axelaCustomerContact = axelaCustomerContact;
	// }

	public AxelaAccGroupPop getAxelaAccGroupPop() {
		return axelaAccGroupPop;
	}

	public void setAxelaAccGroupPop(AxelaAccGroupPop axelaAccGroupPop) {
		this.axelaAccGroupPop = axelaAccGroupPop;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCustomerAccgroupId() {
		return this.customerAccgroupId;
	}

	public void setCustomerAccgroupId(int customerAccgroupId) {
		this.customerAccgroupId = customerAccgroupId;
	}

	public String getCustomerActive() {
		return this.customerActive;
	}

	public void setCustomerActive(String customerActive) {
		this.customerActive = customerActive;
	}

	public String getCustomerAddress1() {
		return this.customerAddress1;
	}

	public void setCustomerAddress1(String customerAddress1) {
		this.customerAddress1 = customerAddress1;
	}

	public String getCustomerAddress2() {
		return this.customerAddress2;
	}

	public void setCustomerAddress2(String customerAddress2) {
		this.customerAddress2 = customerAddress2;
	}

	public String getCustomerArnNo() {
		return this.customerArnNo;
	}

	public void setCustomerArnNo(String customerArnNo) {
		this.customerArnNo = customerArnNo;
	}

	public int getCustomerBranchId() {
		return this.customerBranchId;
	}

	public void setCustomerBranchId(int customerBranchId) {
		this.customerBranchId = customerBranchId;
	}

	public int getCustomerCityId() {
		return this.customerCityId;
	}

	public void setCustomerCityId(int customerCityId) {
		this.customerCityId = customerCityId;
	}

	public String getCustomerCode() {
		return this.customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public double getCustomerCreditLimit() {
		return this.customerCreditLimit;
	}

	public void setCustomerCreditLimit(double customerCreditLimit) {
		this.customerCreditLimit = customerCreditLimit;
	}

	public double getCustomerCurrBal() {
		return this.customerCurrBal;
	}

	public void setCustomerCurrBal(double customerCurrBal) {
		this.customerCurrBal = customerCurrBal;
	}

	public double getCustomerDiscPerc() {
		return this.customerDiscPerc;
	}

	public void setCustomerDiscPerc(double customerDiscPerc) {
		this.customerDiscPerc = customerDiscPerc;
	}

	public String getCustomerEmail1() {
		return this.customerEmail1;
	}

	public void setCustomerEmail1(String customerEmail1) {
		this.customerEmail1 = customerEmail1;
	}

	public String getCustomerEmail2() {
		return this.customerEmail2;
	}

	public void setCustomerEmail2(String customerEmail2) {
		this.customerEmail2 = customerEmail2;
	}

	public int getCustomerEmpId() {
		return this.customerEmpId;
	}

	public void setCustomerEmpId(int customerEmpId) {
		this.customerEmpId = customerEmpId;
	}

	public int getCustomerEmpcountId() {
		return this.customerEmpcountId;
	}

	public void setCustomerEmpcountId(int customerEmpcountId) {
		this.customerEmpcountId = customerEmpcountId;
	}

	public Date getCustomerEntryDate() {
		return this.customerEntryDate;
	}

	public void setCustomerEntryDate(Date customerEntryDate) {
		this.customerEntryDate = customerEntryDate;
	}

	public int getCustomerEntryId() {
		return this.customerEntryId;
	}

	public void setCustomerEntryId(int customerEntryId) {
		this.customerEntryId = customerEntryId;
	}

	public String getCustomerFax1() {
		return this.customerFax1;
	}

	public void setCustomerFax1(String customerFax1) {
		this.customerFax1 = customerFax1;
	}

	public String getCustomerFax2() {
		return this.customerFax2;
	}

	public void setCustomerFax2(String customerFax2) {
		this.customerFax2 = customerFax2;
	}

	// public Object getCustomerGstDoc() {
	// return this.customerGstDoc;
	// }
	//
	// public void setCustomerGstDoc(Object customerGstDoc) {
	// this.customerGstDoc = customerGstDoc;
	// }

	public String getCustomerGstDocValue() {
		return this.customerGstDocValue;
	}

	public void setCustomerGstDocValue(String customerGstDocValue) {
		this.customerGstDocValue = customerGstDocValue;
	}

	public String getCustomerGstNo() {
		return this.customerGstNo;
	}

	public void setCustomerGstNo(String customerGstNo) {
		this.customerGstNo = customerGstNo;
	}

	public Date getCustomerGstRegdate() {
		return this.customerGstRegdate;
	}

	public void setCustomerGstRegdate(Date customerGstRegdate) {
		this.customerGstRegdate = customerGstRegdate;
	}

	public String getCustomerLandmark() {
		return this.customerLandmark;
	}

	public void setCustomerLandmark(String customerLandmark) {
		this.customerLandmark = customerLandmark;
	}

	public int getCustomerLedgertype() {
		return this.customerLedgertype;
	}

	public void setCustomerLedgertype(int customerLedgertype) {
		this.customerLedgertype = customerLedgertype;
	}

	public String getCustomerMobile1() {
		return this.customerMobile1;
	}

	public void setCustomerMobile1(String customerMobile1) {
		this.customerMobile1 = customerMobile1;
	}

	public String getCustomerMobile2() {
		return this.customerMobile2;
	}

	public void setCustomerMobile2(String customerMobile2) {
		this.customerMobile2 = customerMobile2;
	}

	public Date getCustomerModifiedDate() {
		return this.customerModifiedDate;
	}

	public void setCustomerModifiedDate(Date customerModifiedDate) {
		this.customerModifiedDate = customerModifiedDate;
	}

	public int getCustomerModifiedId() {
		return this.customerModifiedId;
	}

	public void setCustomerModifiedId(int customerModifiedId) {
		this.customerModifiedId = customerModifiedId;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNotes() {
		return this.customerNotes;
	}

	public void setCustomerNotes(String customerNotes) {
		this.customerNotes = customerNotes;
	}

	// public double getCustomerOpenBal() {
	// return this.customerOpenBal;
	// }
	//
	// // public void setCustomerOpenBal(double customerOpenBal) {
	// this.customerOpenBal = customerOpenBal;
	// }

	public String getCustomerPanNo() {
		return this.customerPanNo;
	}

	public void setCustomerPanNo(String customerPanNo) {
		this.customerPanNo = customerPanNo;
	}

	public int getCustomerPaydaysId() {
		return this.customerPaydaysId;
	}

	public void setCustomerPaydaysId(int customerPaydaysId) {
		this.customerPaydaysId = customerPaydaysId;
	}

	public String getCustomerPhone1() {
		return this.customerPhone1;
	}

	public void setCustomerPhone1(String customerPhone1) {
		this.customerPhone1 = customerPhone1;
	}

	public String getCustomerPhone2() {
		return this.customerPhone2;
	}

	public void setCustomerPhone2(String customerPhone2) {
		this.customerPhone2 = customerPhone2;
	}

	public String getCustomerPhone3() {
		return this.customerPhone3;
	}

	public void setCustomerPhone3(String customerPhone3) {
		this.customerPhone3 = customerPhone3;
	}

	public String getCustomerPhone4() {
		return this.customerPhone4;
	}

	public void setCustomerPhone4(String customerPhone4) {
		this.customerPhone4 = customerPhone4;
	}

	public String getCustomerPin() {
		return this.customerPin;
	}

	public void setCustomerPin(String customerPin) {
		this.customerPin = customerPin;
	}

	public double getCustomerRate() {
		return this.customerRate;
	}

	public void setCustomerRate(double customerRate) {
		this.customerRate = customerRate;
	}

	public int getCustomerRateclassId() {
		return this.customerRateclassId;
	}

	public void setCustomerRateclassId(int customerRateclassId) {
		this.customerRateclassId = customerRateclassId;
	}

	public String getCustomerReconciliation() {
		return this.customerReconciliation;
	}

	public void setCustomerReconciliation(String customerReconciliation) {
		this.customerReconciliation = customerReconciliation;
	}

	public short getCustomerRound() {
		return this.customerRound;
	}

	public void setCustomerRound(short customerRound) {
		this.customerRound = customerRound;
	}

	public String getCustomerServiceTaxNo() {
		return this.customerServiceTaxNo;
	}

	public void setCustomerServiceTaxNo(String customerServiceTaxNo) {
		this.customerServiceTaxNo = customerServiceTaxNo;
	}

	public Date getCustomerSince() {
		return this.customerSince;
	}

	public void setCustomerSince(Date customerSince) {
		this.customerSince = customerSince;
	}

	public int getCustomerSobId() {
		return this.customerSobId;
	}

	public void setCustomerSobId(int customerSobId) {
		this.customerSobId = customerSobId;
	}

	public int getCustomerSoeId() {
		return this.customerSoeId;
	}

	public void setCustomerSoeId(int customerSoeId) {
		this.customerSoeId = customerSoeId;
	}

	public String getCustomerTax() {
		return this.customerTax;
	}

	public void setCustomerTax(String customerTax) {
		this.customerTax = customerTax;
	}

	public int getCustomerTaxcatId() {
		return this.customerTaxcatId;
	}

	public void setCustomerTaxcatId(int customerTaxcatId) {
		this.customerTaxcatId = customerTaxcatId;
	}

	public int getCustomerTaxtypeId() {
		return this.customerTaxtypeId;
	}

	public void setCustomerTaxtypeId(int customerTaxtypeId) {
		this.customerTaxtypeId = customerTaxtypeId;
	}

	public String getCustomerTds() {
		return this.customerTds;
	}

	public void setCustomerTds(String customerTds) {
		this.customerTds = customerTds;
	}

	public String getCustomerTinNo() {
		return this.customerTinNo;
	}

	public void setCustomerTinNo(String customerTinNo) {
		this.customerTinNo = customerTinNo;
	}
	public int getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(int customerType) {
		this.customerType = customerType;
	}

	public Date getCustomerUserEntryDate() {
		return this.customerUserEntryDate;
	}

	public void setCustomerUserEntryDate(Date customerUserEntryDate) {
		this.customerUserEntryDate = customerUserEntryDate;
	}

	public Date getCustomerUserModifiedDate() {
		return this.customerUserModifiedDate;
	}

	public void setCustomerUserModifiedDate(Date customerUserModifiedDate) {
		this.customerUserModifiedDate = customerUserModifiedDate;
	}

	public String getCustomerWebsite1() {
		return this.customerWebsite1;
	}

	public void setCustomerWebsite1(String customerWebsite1) {
		this.customerWebsite1 = customerWebsite1;
	}

	public String getCustomerWebsite2() {
		return this.customerWebsite2;
	}

	public void setCustomerWebsite2(String customerWebsite2) {
		this.customerWebsite2 = customerWebsite2;
	}

	// public AxelaCustomerDoc getAxelaCustomerDoc() {
	// return this.axelaCustomerDoc;
	// }

	// public void setAxelaCustomerDoc(AxelaCustomerDoc axelaCustomerDoc) {
	// this.axelaCustomerDoc = axelaCustomerDoc;
	// }

	// public AxelaCustomerItstatus getAxelaCustomerItstatus() {
	// return this.axelaCustomerItstatus;
	// }

	// public void setAxelaCustomerItstatus(AxelaCustomerItstatus axelaCustomerItstatus) {
	// this.axelaCustomerItstatus = axelaCustomerItstatus;
	// }
	public AxelaEmp getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(AxelaEmp axelaEmp) {
		this.axelaEmp = axelaEmp;
	}
	public AxelaBranch getAxelaBranch() {
		return axelaBranch;
	}

	public void setAxelaBranch(AxelaBranch axelaBranch) {
		this.axelaBranch = axelaBranch;
	}
	public AxelaSoe getAxelaSoe() {
		return axelaSoe;
	}

	public void setAxelaSoe(AxelaSoe axelaSoe) {
		this.axelaSoe = axelaSoe;
	}

	public AxelaSob getAxelaSob() {
		return axelaSob;
	}

	public void setAxelaSob(AxelaSob axelaSob) {
		this.axelaSob = axelaSob;
	}

	public AxelaEmpcount getAxelaEmpcount() {
		return axelaEmpcount;
	}

	public void setAxelaEmpcount(AxelaEmpcount axelaEmpcount) {
		this.axelaEmpcount = axelaEmpcount;
	}

	public String getCustomerCityName() {
		return customerCityName;
	}

	public void setCustomerCityName(String customerCityName) {
		this.customerCityName = customerCityName;
	}

	public String getCustomerSoeName() {
		return customerSoeName;
	}

	public void setCustomerSoeName(String customerSoeName) {
		this.customerSoeName = customerSoeName;
	}

	public String getCustomerSobName() {
		return customerSobName;
	}

	public void setCustomerSobName(String customerSobName) {
		this.customerSobName = customerSobName;
	}

	public String getCustomerEmpName() {
		return customerEmpName;
	}

	public void setCustomerEmpName(String customerEmpName) {
		this.customerEmpName = customerEmpName;
	}

	public String getCustomerBranchName() {
		return customerBranchName;
	}

	public void setCustomerBranchName(String customerBranchName) {
		this.customerBranchName = customerBranchName;
	}

	public long getCustomerContactCount() {
		return customerContactCount;
	}

	public void setCustomerContactCount(long customerContactCount) {
		this.customerContactCount = customerContactCount;
	}
	public String getCustomerItstatusId() {
		return customerItstatusId;
	}

	public void setCustomerItstatusId(String customerItstatusId) {
		this.customerItstatusId = customerItstatusId;
	}

	public AxelaCity getAxelaCity() {
		return axelaCity;
	}

	public void setAxelaCity(AxelaCity axelaCity) {
		this.axelaCity = axelaCity;
	}

	@OneToMany(mappedBy = "axelaCustomer")
	private List<AxelaServiceJc> axelaServiceJc;

	public List<AxelaServiceJc> getAxelaServiceJc() {
		return axelaServiceJc;
	}

	public void setAxelaServiceJc(List<AxelaServiceJc> axelaServiceJc) {
		this.axelaServiceJc = axelaServiceJc;
	}

	public AxelaCustomer(int customerType,
			String customerName,
			String customerCode,
			int customerBranchId,
			String customerMobile1,
			String customerMobile2,
			String customerPhone1,
			String customerPhone2,
			String customerPhone3,
			String customerPhone4,
			String customerFax1,
			String customerFax2,
			String customerEmail1,
			String customerEmail2,
			String customerWebsite1,
			String customerWebsite2,
			String customerGstNo,
			Date customerGstRegdate,
			String customerArnNo,
			String customerItstatusId,
			String customerAddress1,
			String customerLandmark,
			int customerCityId,
			String customerPin,
			String customerTinNo,
			String customerServiceTaxNo,
			String customerTds,
			String customerPanNo,
			int customerSoeId,
			int customerSobId,
			int customerRateclassId,
			double customerCreditLimit,
			double customerDiscPerc,
			Date customerSince,
			int customerEmpcountId,
			int customerPaydaysId,
			int customerEmpId,
			int customerAccgroupId,
			String customerActive,
			String customerNotes,
			int customerId,
			int customerEntryId,
			int customerModifiedId,
			Date customerEntryDate,
			Date customerModifiedDate) {
		this.customerType = customerType;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerCode = customerCode;
		this.customerBranchId = customerBranchId;
		this.customerMobile1 = customerMobile1;
		this.customerMobile2 = customerMobile2;
		this.customerPhone1 = customerPhone1;
		this.customerPhone2 = customerPhone2;
		this.customerPhone3 = customerPhone3;
		this.customerPhone4 = customerPhone4;
		this.customerFax1 = customerFax1;
		this.customerFax2 = customerFax2;
		this.customerEmail1 = customerEmail1;
		this.customerEmail2 = customerEmail2;
		this.customerWebsite1 = customerWebsite1;
		this.customerWebsite2 = customerWebsite2;
		this.customerGstNo = customerGstNo;
		this.customerGstRegdate = customerGstRegdate;
		this.customerArnNo = customerArnNo;
		this.customerItstatusId = customerItstatusId;
		this.customerAddress1 = customerAddress1;
		this.customerLandmark = customerLandmark;
		this.customerCityId = customerCityId;
		this.customerPin = customerPin;
		this.customerTinNo = customerTinNo;
		this.customerServiceTaxNo = customerServiceTaxNo;
		this.customerTds = customerTds;
		this.customerPanNo = customerPanNo;
		this.customerSoeId = customerSoeId;
		this.customerSobId = customerSobId;
		this.customerRateclassId = customerRateclassId;
		this.customerCreditLimit = customerCreditLimit;
		this.customerDiscPerc = customerDiscPerc;
		this.customerSince = customerSince;
		this.customerEmpcountId = customerEmpcountId;
		this.customerType = customerType;
		this.customerPaydaysId = customerPaydaysId;
		this.customerEmpId = customerEmpId;
		this.customerAccgroupId = customerAccgroupId;
		this.customerActive = customerActive;
		this.customerNotes = customerNotes;
		this.customerId = customerId;
		this.customerEntryId = customerEntryId;
		this.customerModifiedId = customerModifiedId;
		this.customerEntryDate = customerEntryDate;
		this.customerModifiedDate = customerModifiedDate;
	}

	public BigDecimal getVoucherAmount() {
		return voucherAmount;
	}

	public void setVoucherAmount(BigDecimal voucherAmount) {
		this.voucherAmount = voucherAmount;
	}

	public List<AxelaCustomerContact> getAxelaCustomerContact() {
		return axelaCustomerContact;
	}

	public void setAxelaCustomerContact(List<AxelaCustomerContact> axelaCustomerContact) {
		this.axelaCustomerContact = axelaCustomerContact;
	}

	public List<AxelaAccVoucher> getAxelaAccVoucher() {
		return axelaAccVoucher;
	}

	public void setAxelaAccVoucher(List<AxelaAccVoucher> axelaAccVoucher) {
		this.axelaAccVoucher = axelaAccVoucher;
	}

	public Long getVoucherAmounts() {
		return voucherAmounts;
	}

	public void setVoucherAmounts(Long voucherAmounts) {
		this.voucherAmounts = voucherAmounts;
	}

	public List<AxelaInventoryItemPrice> getAxelaInventoryItemPrice() {
		return axelaInventoryItemPrice;
	}

	public void setAxelaInventoryItemPrice(List<AxelaInventoryItemPrice> axelaInventoryItemPrice) {
		this.axelaInventoryItemPrice = axelaInventoryItemPrice;
	}

}