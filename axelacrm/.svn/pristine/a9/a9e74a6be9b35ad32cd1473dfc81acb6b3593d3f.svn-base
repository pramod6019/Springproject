//package axela.customer.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.Lob;
//import javax.persistence.ManyToOne;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//
///**
// * The persistent class for the axela_service_jc database table.
// * 
// */
//@Entity
//@Table(name = "axela_service_jc", catalog = "axela_1")
//@NamedQuery(name = "AxelaServiceJc.findAll", query = "SELECT a FROM AxelaServiceJc a")
//public class AxelaServiceJc implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "jc_id")
//	private int jcId;
//
//	@Column(name = "jc_active")
//	private String jcActive;
//
//	@Lob
//	@Column(name = "jc_advice")
//	private String jcAdvice;
//
//	@Column(name = "jc_auth")
//	private String jcAuth;
//
//	@Column(name = "jc_auth_date")
//	private String jcAuthDate;
//
//	@Column(name = "jc_auth_id")
//	private int jcAuthId;
//
//	@Column(name = "jc_bay_id")
//	private int jcBayId;
//
//	@Column(name = "jc_bill_address")
//	private String jcBillAddress;
//
//	@Column(name = "jc_bill_city")
//	private String jcBillCity;
//
//	@Column(name = "jc_bill_country")
//	private String jcBillCountry;
//
//	// many-to-one relation with AxelaCustomerContact
//	@ManyToOne
//	@JoinColumn(name = "jc_contact_id", referencedColumnName = "contact_id", insertable = false, updatable = false)
//	private AxelaCustomerContact axelaCustomerContact;
//
//	public AxelaCustomerContact getAxelaCustomerContact() {
//		return axelaCustomerContact;
//	}
//
//	public void setAxelaCustomerContact(AxelaCustomerContact axelaCustomerContact) {
//		this.axelaCustomerContact = axelaCustomerContact;
//	}
//
//	@Column(name = "jc_bill_pin")
//	private String jcBillPin;
//
//	@Column(name = "jc_bill_state")
//	private String jcBillState;
//
//	@Column(name = "jc_branch_id")
//	private int jcBranchId;
//
//	@Column(name = "jc_contact_id")
//	private int jcContactId;
//
//	@Column(name = "jc_critical")
//	private String jcCritical;
//
//	@Column(name = "jc_customer_id")
//	private int jcCustomerId;
//
//	@Lob
//	@Column(name = "jc_customer_voice")
//	private String jcCustomerVoice;
//
//	@Column(name = "jc_del_address")
//	private String jcDelAddress;
//
//	@Column(name = "jc_del_city")
//	private String jcDelCity;
//
//	@Column(name = "jc_del_country")
//	private String jcDelCountry;
//
//	@Column(name = "jc_del_pin")
//	private String jcDelPin;
//
//	@Column(name = "jc_del_state")
//	private String jcDelState;
//
//	@Column(name = "jc_discamt")
//	private double jcDiscamt;
//
//	@Column(name = "jc_emp_id")
//	private int jcEmpId;
//
//	@Column(name = "jc_entry_date")
//	private String jcEntryDate;
//
//	@Column(name = "jc_entry_id")
//	private int jcEntryId;
//
//	@Column(name = "jc_grandtotal")
//	private double jcGrandtotal;
//
//	@Lob
//	@Column(name = "jc_instructions")
//	private String jcInstructions;
//
//	@Column(name = "jc_item_id")
//	private int jcItemId;
//
//	@Column(name = "jc_jccat_id")
//	private int jcJccatId;
//
//	@Column(name = "jc_jcstatus_id")
//	private int jcJcstatusId;
//
//	@Column(name = "jc_jctype_id")
//	private int jcJctypeId;
//
//	@Column(name = "jc_location_id")
//	private int jcLocationId;
//
//	@Column(name = "jc_modified_date")
//	private String jcModifiedDate;
//
//	@Column(name = "jc_modified_id")
//	private int jcModifiedId;
//
//	@Column(name = "jc_netamt")
//	private double jcNetamt;
//
//	@Column(name = "jc_no")
//	private int jcNo;
//
//	@Lob
//	@Column(name = "jc_notes")
//	private String jcNotes;
//
//	@Column(name = "jc_open")
//	private String jcOpen;
//
//	@Column(name = "jc_priority_trigger")
//	private int jcPriorityTrigger;
//
//	@Column(name = "jc_priorityjc_id")
//	private int jcPriorityjcId;
//
//	@Column(name = "jc_refno")
//	private String jcRefno;
//
//	@Column(name = "jc_ro_no")
//	private String jcRoNo;
//
//	@Column(name = "jc_serialno")
//	private String jcSerialno;
//
//	@Column(name = "jc_status_trigger")
//	private int jcStatusTrigger;
//
//	@Column(name = "jc_technician_emp_id")
//	private int jcTechnicianEmpId;
//
//	@Lob
//	@Column(name = "jc_terms")
//	private String jcTerms;
//
//	@Column(name = "jc_time_in")
//	private String jcTimeIn;
//
//	@Column(name = "jc_time_out")
//	private String jcTimeOut;
//
//	@Column(name = "jc_time_promised")
//	private String jcTimePromised;
//
//	@Column(name = "jc_time_ready")
//	private String jcTimeReady;
//
//	@Column(name = "jc_title")
//	private String jcTitle;
//
//	@Column(name = "jc_totaltax")
//	private double jcTotaltax;
//
//	public AxelaServiceJc() {
//	}
//
//	public int getJcId() {
//		return this.jcId;
//	}
//
//	public void setJcId(int jcId) {
//		this.jcId = jcId;
//	}
//
//	public String getJcActive() {
//		return this.jcActive;
//	}
//
//	public void setJcActive(String jcActive) {
//		this.jcActive = jcActive;
//	}
//
//	public String getJcAdvice() {
//		return this.jcAdvice;
//	}
//
//	public void setJcAdvice(String jcAdvice) {
//		this.jcAdvice = jcAdvice;
//	}
//
//	public String getJcAuth() {
//		return this.jcAuth;
//	}
//
//	public void setJcAuth(String jcAuth) {
//		this.jcAuth = jcAuth;
//	}
//
//	public String getJcAuthDate() {
//		return this.jcAuthDate;
//	}
//
//	public void setJcAuthDate(String jcAuthDate) {
//		this.jcAuthDate = jcAuthDate;
//	}
//
//	public int getJcAuthId() {
//		return this.jcAuthId;
//	}
//
//	public void setJcAuthId(int jcAuthId) {
//		this.jcAuthId = jcAuthId;
//	}
//
//	public int getJcBayId() {
//		return this.jcBayId;
//	}
//
//	public void setJcBayId(int jcBayId) {
//		this.jcBayId = jcBayId;
//	}
//
//	public String getJcBillAddress() {
//		return this.jcBillAddress;
//	}
//
//	public void setJcBillAddress(String jcBillAddress) {
//		this.jcBillAddress = jcBillAddress;
//	}
//
//	public String getJcBillCity() {
//		return this.jcBillCity;
//	}
//
//	public void setJcBillCity(String jcBillCity) {
//		this.jcBillCity = jcBillCity;
//	}
//
//	public String getJcBillCountry() {
//		return this.jcBillCountry;
//	}
//
//	public void setJcBillCountry(String jcBillCountry) {
//		this.jcBillCountry = jcBillCountry;
//	}
//
//	public String getJcBillPin() {
//		return this.jcBillPin;
//	}
//
//	public void setJcBillPin(String jcBillPin) {
//		this.jcBillPin = jcBillPin;
//	}
//
//	public String getJcBillState() {
//		return this.jcBillState;
//	}
//
//	public void setJcBillState(String jcBillState) {
//		this.jcBillState = jcBillState;
//	}
//
//	public int getJcBranchId() {
//		return this.jcBranchId;
//	}
//
//	public void setJcBranchId(int jcBranchId) {
//		this.jcBranchId = jcBranchId;
//	}
//
//	public int getJcContactId() {
//		return this.jcContactId;
//	}
//
//	public void setJcContactId(int jcContactId) {
//		this.jcContactId = jcContactId;
//	}
//
//	public String getJcCritical() {
//		return this.jcCritical;
//	}
//
//	public void setJcCritical(String jcCritical) {
//		this.jcCritical = jcCritical;
//	}
//
//	public int getJcCustomerId() {
//		return this.jcCustomerId;
//	}
//
//	public void setJcCustomerId(int jcCustomerId) {
//		this.jcCustomerId = jcCustomerId;
//	}
//
//	public String getJcCustomerVoice() {
//		return this.jcCustomerVoice;
//	}
//
//	public void setJcCustomerVoice(String jcCustomerVoice) {
//		this.jcCustomerVoice = jcCustomerVoice;
//	}
//
//	public String getJcDelAddress() {
//		return this.jcDelAddress;
//	}
//
//	public void setJcDelAddress(String jcDelAddress) {
//		this.jcDelAddress = jcDelAddress;
//	}
//
//	public String getJcDelCity() {
//		return this.jcDelCity;
//	}
//
//	public void setJcDelCity(String jcDelCity) {
//		this.jcDelCity = jcDelCity;
//	}
//
//	public String getJcDelCountry() {
//		return this.jcDelCountry;
//	}
//
//	public void setJcDelCountry(String jcDelCountry) {
//		this.jcDelCountry = jcDelCountry;
//	}
//
//	public String getJcDelPin() {
//		return this.jcDelPin;
//	}
//
//	public void setJcDelPin(String jcDelPin) {
//		this.jcDelPin = jcDelPin;
//	}
//
//	public String getJcDelState() {
//		return this.jcDelState;
//	}
//
//	public void setJcDelState(String jcDelState) {
//		this.jcDelState = jcDelState;
//	}
//
//	public double getJcDiscamt() {
//		return this.jcDiscamt;
//	}
//
//	public void setJcDiscamt(double jcDiscamt) {
//		this.jcDiscamt = jcDiscamt;
//	}
//
//	public int getJcEmpId() {
//		return this.jcEmpId;
//	}
//
//	public void setJcEmpId(int jcEmpId) {
//		this.jcEmpId = jcEmpId;
//	}
//
//	public String getJcEntryDate() {
//		return this.jcEntryDate;
//	}
//
//	public void setJcEntryDate(String jcEntryDate) {
//		this.jcEntryDate = jcEntryDate;
//	}
//
//	public int getJcEntryId() {
//		return this.jcEntryId;
//	}
//
//	public void setJcEntryId(int jcEntryId) {
//		this.jcEntryId = jcEntryId;
//	}
//
//	public double getJcGrandtotal() {
//		return this.jcGrandtotal;
//	}
//
//	public void setJcGrandtotal(double jcGrandtotal) {
//		this.jcGrandtotal = jcGrandtotal;
//	}
//
//	public String getJcInstructions() {
//		return this.jcInstructions;
//	}
//
//	public void setJcInstructions(String jcInstructions) {
//		this.jcInstructions = jcInstructions;
//	}
//
//	public int getJcItemId() {
//		return this.jcItemId;
//	}
//
//	public void setJcItemId(int jcItemId) {
//		this.jcItemId = jcItemId;
//	}
//
//	public int getJcJccatId() {
//		return this.jcJccatId;
//	}
//
//	public void setJcJccatId(int jcJccatId) {
//		this.jcJccatId = jcJccatId;
//	}
//
//	public int getJcJcstatusId() {
//		return this.jcJcstatusId;
//	}
//
//	public void setJcJcstatusId(int jcJcstatusId) {
//		this.jcJcstatusId = jcJcstatusId;
//	}
//
//	public int getJcJctypeId() {
//		return this.jcJctypeId;
//	}
//
//	public void setJcJctypeId(int jcJctypeId) {
//		this.jcJctypeId = jcJctypeId;
//	}
//
//	public int getJcLocationId() {
//		return this.jcLocationId;
//	}
//
//	public void setJcLocationId(int jcLocationId) {
//		this.jcLocationId = jcLocationId;
//	}
//
//	public String getJcModifiedDate() {
//		return this.jcModifiedDate;
//	}
//
//	public void setJcModifiedDate(String jcModifiedDate) {
//		this.jcModifiedDate = jcModifiedDate;
//	}
//
//	public int getJcModifiedId() {
//		return this.jcModifiedId;
//	}
//
//	public void setJcModifiedId(int jcModifiedId) {
//		this.jcModifiedId = jcModifiedId;
//	}
//
//	public double getJcNetamt() {
//		return this.jcNetamt;
//	}
//
//	public void setJcNetamt(double jcNetamt) {
//		this.jcNetamt = jcNetamt;
//	}
//
//	public int getJcNo() {
//		return this.jcNo;
//	}
//
//	public void setJcNo(int jcNo) {
//		this.jcNo = jcNo;
//	}
//
//	public String getJcNotes() {
//		return this.jcNotes;
//	}
//
//	public void setJcNotes(String jcNotes) {
//		this.jcNotes = jcNotes;
//	}
//
//	public String getJcOpen() {
//		return this.jcOpen;
//	}
//
//	public void setJcOpen(String jcOpen) {
//		this.jcOpen = jcOpen;
//	}
//
//	public int getJcPriorityTrigger() {
//		return this.jcPriorityTrigger;
//	}
//
//	public void setJcPriorityTrigger(int jcPriorityTrigger) {
//		this.jcPriorityTrigger = jcPriorityTrigger;
//	}
//
//	public int getJcPriorityjcId() {
//		return this.jcPriorityjcId;
//	}
//
//	public void setJcPriorityjcId(int jcPriorityjcId) {
//		this.jcPriorityjcId = jcPriorityjcId;
//	}
//
//	public String getJcRefno() {
//		return this.jcRefno;
//	}
//
//	public void setJcRefno(String jcRefno) {
//		this.jcRefno = jcRefno;
//	}
//
//	public String getJcRoNo() {
//		return this.jcRoNo;
//	}
//
//	public void setJcRoNo(String jcRoNo) {
//		this.jcRoNo = jcRoNo;
//	}
//
//	public String getJcSerialno() {
//		return this.jcSerialno;
//	}
//
//	public void setJcSerialno(String jcSerialno) {
//		this.jcSerialno = jcSerialno;
//	}
//
//	public int getJcStatusTrigger() {
//		return this.jcStatusTrigger;
//	}
//
//	public void setJcStatusTrigger(int jcStatusTrigger) {
//		this.jcStatusTrigger = jcStatusTrigger;
//	}
//
//	public int getJcTechnicianEmpId() {
//		return this.jcTechnicianEmpId;
//	}
//
//	public void setJcTechnicianEmpId(int jcTechnicianEmpId) {
//		this.jcTechnicianEmpId = jcTechnicianEmpId;
//	}
//
//	public String getJcTerms() {
//		return this.jcTerms;
//	}
//
//	public void setJcTerms(String jcTerms) {
//		this.jcTerms = jcTerms;
//	}
//
//	public String getJcTimeIn() {
//		return this.jcTimeIn;
//	}
//
//	public void setJcTimeIn(String jcTimeIn) {
//		this.jcTimeIn = jcTimeIn;
//	}
//
//	public String getJcTimeOut() {
//		return this.jcTimeOut;
//	}
//
//	public void setJcTimeOut(String jcTimeOut) {
//		this.jcTimeOut = jcTimeOut;
//	}
//
//	public String getJcTimePromised() {
//		return this.jcTimePromised;
//	}
//
//	public void setJcTimePromised(String jcTimePromised) {
//		this.jcTimePromised = jcTimePromised;
//	}
//
//	public String getJcTimeReady() {
//		return this.jcTimeReady;
//	}
//
//	public void setJcTimeReady(String jcTimeReady) {
//		this.jcTimeReady = jcTimeReady;
//	}
//
//	public String getJcTitle() {
//		return this.jcTitle;
//	}
//
//	public void setJcTitle(String jcTitle) {
//		this.jcTitle = jcTitle;
//	}
//
//	public double getJcTotaltax() {
//		return this.jcTotaltax;
//	}
//
//	public void setJcTotaltax(double jcTotaltax) {
//		this.jcTotaltax = jcTotaltax;
//	}
//
// }