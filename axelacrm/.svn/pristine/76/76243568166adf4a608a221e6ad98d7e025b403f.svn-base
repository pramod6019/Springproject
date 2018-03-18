package axela.customer.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import axela.activities.model.AxelaActivity;
import axela.helpdesk.model.AxelaHelpDeskTicket;
import axela.portal.model.AxelaCity;
import axela.portal.model.AxelaTitle;
import axela.sales.model.AxelaSalesOppr;
import axela.service.model.AxelaServiceJc;

/**
 * The persistent class for the axela_customer_contact database table.
 * 
 */
@Entity
@Table(name = "axela_customer_contact", catalog = "axela_1")
@NamedQuery(name = "AxelaCustomerContact.findAll", query = "SELECT a FROM AxelaCustomerContact a")
public class AxelaCustomerContact implements Serializable {
	private static final long serialVersionUID = 1L;

	// ===================left Join variable================
	@Transient
	private int customerId;

	@Transient
	private String customerName;

	@Transient
	private String cityName;

	@Transient
	private String countryName;

	@Transient
	private long ticketopen;

	@Transient
	private long jcopen;

	@Transient
	private String jcSerialno;

	@Transient
	private String contactName = ""; // from AxelaTitle customerName

	@Transient
	private String contactCustomerName = ""; // from AxelaCustomer

	@Transient
	private int contactBranchId = 0; // from AxelaBranch

	@Transient
	private int opprId;

	@Transient
	private String statusName;

	@Transient
	private int customerBranchId;
	@Transient
	private int customerSoeId;
	@Transient
	private int customerSobId;

	// transient for contacts landing page
	@Transient
	private int branchId;

	@Transient
	private String branchName;

	@Transient
	private String branchCode;

	@Transient
	private Long customersCount;

	public int getOpprId() {
		return opprId;
	}

	public void setOpprId(int opprId) {
		this.opprId = opprId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public int getContactBranchId() {
		return contactBranchId;
	}

	public void setContactBranchId(int contactBranchId) {
		this.contactBranchId = contactBranchId;
	}

	@Transient
	private int TitleId;

	@Transient
	private String contactCityName = ""; // from AxelaCity

	@Transient
	private String contactStateName = "";// from AxelaState

	@Transient
	private String contactCountryName = "";// from AxelaCountry

	@Transient
	private String contactEmpName = "";// from AxelaEmp

	@Transient
	private String contactBranchName = "";// from AxelaBranch

	@Transient
	// customer dash
	private String titleDesc = "";// from AxelaBranch

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contact_id")
	private int contactId;

	@Column(name = "contact_customer_id")
	private int contactCustomerId;

	@Column(name = "contact_active")
	private String contactActive;

	@Column(name = "contact_address")
	private String contactAddress;

	@Column(name = "contact_anniversary")
	private Date contactAnniversary;

	@Column(name = "contact_aol")
	private String contactAol;

	@Column(name = "contact_city_id")
	private String contactCityId;

	@Column(name = "contact_dnd")
	private String contactDnd;

	@Column(name = "contact_dob")
	private Date contactDob;

	@Column(name = "contact_email1")
	private String contactEmail1;

	@Column(name = "contact_email2")
	private String contactEmail2;

	@Column(name = "contact_entry_date")
	private Date contactEntryDate;

	@Column(name = "contact_entry_id")
	private int contactEntryId;

	@Column(name = "contact_fname")
	private String contactFname;

	@Column(name = "contact_jobtitle")
	private String contactJobtitle;

	@Column(name = "contact_landmark")
	private String contactLandmark;

	@Column(name = "contact_lname")
	private String contactLname;

	@Column(name = "contact_location")
	private String contactLocation;

	@Column(name = "contact_mobile1")
	private String contactMobile1;

	@Column(name = "contact_mobile2")
	private String contactMobile2;

	@Column(name = "contact_modified_date")
	private Date contactModifiedDate;

	@Column(name = "contact_modified_id")
	private int contactModifiedId;

	@Column(name = "contact_msn")
	private String contactMsn;

	@Column(name = "contact_notes")
	private String contactNotes;

	@Column(name = "contact_phone1")
	private String contactPhone1;

	@Column(name = "contact_phone2")
	private String contactPhone2;

	// @Column(name = "contact_photo")
	// private Object contactPhoto;

	@Column(name = "contact_pic")
	private String contactPic;

	@Column(name = "contact_pin")
	private String contactPin;

	@Column(name = "contact_skype")
	private String contactSkype;

	@Column(name = "contact_title_id")
	private int contactTitleId;

	@Column(name = "contact_yahoo")
	private String contactYahoo;

	// bi-directional many-to-one association to AxelaCustomer
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contact_customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
	private AxelaCustomer axelaCustomers;

	// many-to-one relation with AxelaCity
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contact_city_id", referencedColumnName = "city_id", insertable = false, updatable = false)
	private AxelaCity axelaCity;

	// many-to-one relation with AxelaTitle
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contact_title_id", referencedColumnName = "title_id", insertable = false, updatable = false)
	private AxelaTitle axelaTitle;

	public List<AxelaAccVoucher> getAxelaAccVoucher() {
		return axelaAccVoucher;
	}

	public void setAxelaAccVoucher(List<AxelaAccVoucher> axelaAccVoucher) {
		this.axelaAccVoucher = axelaAccVoucher;
	}

	// bi-directional one-to-many association to AxelaServiceJc
	@OneToMany(mappedBy = "axelaCustomerContact")
	private List<AxelaServiceJc> axelaServiceJc;

	@OneToMany(mappedBy = "axelaCustomerContact")
	private List<AxelaHelpDeskTicket> axelaHelpDeskTicket;

	public List<AxelaHelpDeskTicket> getAxelaServiceTicket() {
		return axelaHelpDeskTicket;
	}

	public void setAxelaServiceTicket(List<AxelaHelpDeskTicket> axelaHelpDeskTicket) {
		this.axelaHelpDeskTicket = axelaHelpDeskTicket;
	}

	public List<AxelaServiceJc> getAxelaServiceJc() {
		return axelaServiceJc;
	}

	public void setAxelaServiceJc(List<AxelaServiceJc> axelaServiceJc) {
		this.axelaServiceJc = axelaServiceJc;
	}

	public AxelaTitle getAxelaTitle() {
		return axelaTitle;
	}

	public void setAxelaTitle(AxelaTitle axelaTitle) {
		this.axelaTitle = axelaTitle;
	}

	public AxelaCity getAxelaCity() {
		return axelaCity;
	}

	public void setAxelaCity(AxelaCity axelaCity) {
		this.axelaCity = axelaCity;
	}

	public AxelaCustomerContact() {
	}

	public int getContactId() {
		return this.contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public int getContactCustomerId() {
		return contactCustomerId;
	}

	public void setContactCustomerId(int contactCustomerId) {
		this.contactCustomerId = contactCustomerId;
	}

	public String getContactActive() {
		return this.contactActive;
	}

	public void setContactActive(String contactActive) {
		this.contactActive = contactActive;
	}

	public String getContactAddress() {
		return this.contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public Date getContactAnniversary() {
		return this.contactAnniversary;
	}

	public void setContactAnniversary(Date contactAnniversary) {
		this.contactAnniversary = contactAnniversary;
	}

	public String getContactAol() {
		return this.contactAol;
	}

	public void setContactAol(String contactAol) {
		this.contactAol = contactAol;
	}

	public String getTitleDesc() {
		return titleDesc;
	}

	public void setTitleDesc(String titleDesc) {
		this.titleDesc = titleDesc;
	}

	// constructor
	public AxelaCustomerContact(
			int contactId,
			int contactCustomerId,
			String contactCityId,
			String contactAddress,
			String contactEmail1,
			String contactEmail2,
			String contactLandmark,
			String contactMobile1,
			String contactMobile2,
			String contactPhone1,
			String contactPhone2,
			String contactPin,
			String contactName,
			String contactCustomerName,
			String contactCityName,
			String contactStateName,
			String contactCountryName,
			String contactEmpName,
			int contactBranchId,
			String contactBranchName,
			String contactActive) {
		super();
		this.contactId = contactId;
		this.contactCustomerId = contactCustomerId;
		this.contactCityId = contactCityId;
		this.contactAddress = contactAddress;
		this.contactEmail1 = contactEmail1;
		this.contactEmail2 = contactEmail2;
		this.contactLandmark = contactLandmark;
		this.contactMobile1 = contactMobile1;
		this.contactMobile2 = contactMobile2;
		this.contactPhone1 = contactPhone1;
		this.contactPhone2 = contactPhone2;
		this.contactPin = contactPin;
		this.contactName = contactName;
		this.contactCustomerName = contactCustomerName;
		this.contactCityName = contactCityName;
		this.contactStateName = contactStateName;
		this.contactCountryName = contactCountryName;
		this.contactEmpName = contactEmpName;
		this.contactBranchId = contactBranchId;
		this.contactBranchName = contactBranchName;
		this.contactActive = contactActive;
	}

	// constructor
	public AxelaCustomerContact(
			int contactId,
			String contactName,
			String contactEmail1,
			String contactEmail2,
			// + COALESCE(a.contactPhoto,'') AS contactPhoto,
			String contactMobile1,
			String contactMobile2,
			String contactJobtitle,
			String contactLocation,
			String contactPhone1,
			String contactPhone2,
			String contactNotes,
			int customerId,
			String customerName,
			String contactMsn,
			String contactActive,
			Date contactDob,
			Date contactAnniversary,
			String contactYahoo,
			String contactAol,
			String contactAddress,
			String contactPin,
			String contactLandmark,
			String cityName,
			String countryName,
			long ticketopen,
			long jcopen) {

		this.contactId = contactId;
		this.contactName = contactName;
		this.contactEmail1 = contactEmail1;
		this.contactEmail2 = contactEmail2;
		// + COALESCE(a.contactPhoto,'') AS contactPhoto,
		this.contactMobile1 = contactMobile1;
		this.contactMobile2 = contactMobile2;
		this.contactJobtitle = contactJobtitle;
		this.contactLocation = contactLocation;
		this.contactPhone1 = contactPhone1;
		this.contactPhone2 = contactPhone2;
		this.contactNotes = contactNotes;
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactMsn = contactMsn;
		this.contactActive = contactActive;
		this.contactDob = contactDob;
		this.contactAnniversary = contactAnniversary;
		this.contactYahoo = contactYahoo;
		this.contactAol = contactAol;
		this.contactAddress = contactAddress;
		this.contactPin = contactPin;
		this.contactLandmark = contactLandmark;
		this.cityName = cityName;
		this.countryName = countryName;
		this.ticketopen = ticketopen;
		this.jcopen = jcopen;

	}

	public AxelaCustomerContact(int opprId, String statusName, String contactName, String contactMobile1, int contactId, String customerName, int contactCustomerId) {
		this.opprId = opprId;
		this.statusName = statusName;
		this.contactName = contactName;
		this.contactMobile1 = contactMobile1;
		this.contactId = contactId;
		this.customerName = customerName;
		this.contactCustomerId = contactCustomerId;
	}

	public AxelaCustomerContact(
			String contactName,
			String contactEmail1,
			int contactId,
			String customerName,
			String jcSerialno,
			int contactCustomerId) {
		this.jcSerialno = jcSerialno;
		this.contactName = contactName;
		this.contactEmail1 = contactEmail1;
		this.contactId = contactId;
		this.customerName = customerName;
		this.contactCustomerId = contactCustomerId;
	}

	public AxelaCustomerContact(
			String contactName,
			int contactId,
			String customerName,
			String contactMobile1,
			String jcSerialno,
			int contactCustomerId) {
		this.jcSerialno = jcSerialno;
		this.contactName = contactName;
		this.contactMobile1 = contactMobile1;
		this.contactId = contactId;
		this.customerName = customerName;
		this.contactCustomerId = contactCustomerId;
	}

	public String getJcSerialno() {
		return jcSerialno;
	}

	public void setJcSerialno(String jcSerialno) {
		this.jcSerialno = jcSerialno;
	}

	public AxelaCustomerContact(String contactName, String contactEmail1, int contactId, String customerName, int contactCustomerId) {
		this.contactName = contactName;
		this.contactEmail1 = contactEmail1;
		this.contactId = contactId;
		this.customerName = customerName;
		this.contactCustomerId = contactCustomerId;
	}

	// for contacts landing page
	public AxelaCustomerContact(
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

	// contact birtday report page contsructor
	public AxelaCustomerContact(
			int contactId,
			String contactName,
			String contactJobtitle,
			Date contactDob,
			int customerId,
			String customerName,
			int branchId,
			String branchName,
			String branchCode) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactJobtitle = contactJobtitle;
		this.contactDob = contactDob;
		this.customerId = customerId;
		this.customerName = customerName;
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchCode = branchCode;
	}

	// contact anniversary report page
	public AxelaCustomerContact(
			int contactId,
			String contactName,
			String contactJobtitle,
			int customerId,
			Date contactAnniversary,
			String customerName,
			int branchId,
			String branchName,
			String branchCode) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactJobtitle = contactJobtitle;
		this.customerId = customerId;
		this.contactAnniversary = contactAnniversary;
		this.customerName = customerName;
		this.branchId = branchId;
		this.branchName = branchName;
		this.branchCode = branchCode;
	}

	// customer dash contrcuctor

	public AxelaCustomerContact(
			int contactId,
			int contactCustomerId,
			String titleDesc,
			String contactFname,
			String contactLname,
			String contactJobtitle,
			String contactLocation,
			String contactPhone1,
			String contactPhone2,
			String contactMobile1,
			String contactMobile2,
			Date contactAnniversary,
			String contactEmail1,
			String contactEmail2,
			String contactYahoo,
			String contactMsn,
			String contactAol,
			String contactAddress,
			String contactPin,
			String contactLandmark,
			Date contactDob,
			String contactActive,
			String cityName,
			String countryName,
			int customerId,
			String customerName,
			String branchName,
			String branchCode) {
		super();
		this.contactId = contactId;
		this.contactCustomerId = contactCustomerId;
		this.titleDesc = titleDesc;
		this.contactFname = contactFname;
		this.contactLname = contactLname;
		this.contactJobtitle = contactJobtitle;
		this.contactLocation = contactLocation;
		this.contactPhone1 = contactPhone1;
		this.contactPhone2 = contactPhone2;
		this.contactMobile1 = contactMobile1;
		this.contactMobile2 = contactMobile2;
		this.contactAnniversary = contactAnniversary;
		this.contactEmail1 = contactEmail1;
		this.contactEmail2 = contactEmail2;
		this.contactYahoo = contactYahoo;
		this.contactMsn = contactMsn;
		this.contactAol = contactAol;
		this.contactAddress = contactAddress;
		this.contactPin = contactPin;
		this.contactLandmark = contactLandmark;
		this.contactDob = contactDob;
		this.contactActive = contactActive;
		this.cityName = cityName;
		this.countryName = countryName;
		this.customerId = customerId;
		this.customerName = customerName;
		this.branchName = branchName;
		this.branchCode = branchCode;

	}
	public String getContactCityName() {
		return contactCityName;
	}

	public void setContactCityName(String contactCityName) {
		this.contactCityName = contactCityName;
	}

	public String getContactEmpName() {
		return contactEmpName;
	}

	public void setContactEmpName(String contactEmpName) {
		this.contactEmpName = contactEmpName;
	}

	public String getContactBranchName() {
		return contactBranchName;
	}

	public void setContactBranchName(String contactBranchName) {
		this.contactBranchName = contactBranchName;
	}

	public String getContactCityId() {
		return this.contactCityId;
	}

	public void setContactCityId(String contactCityId) {
		this.contactCityId = contactCityId;
	}
	public String getContactTitle() {
		return contactName;
	}

	public void setContactTitle(String contactTitle) {
		this.contactName = contactTitle;
	}

	public String getContactDnd() {
		return this.contactDnd;
	}

	public void setContactDnd(String contactDnd) {
		this.contactDnd = contactDnd;
	}

	public Date getContactDob() {
		return this.contactDob;
	}

	public void setContactDob(Date contactDob) {
		this.contactDob = contactDob;
	}

	public String getContactEmail1() {
		return this.contactEmail1;
	}

	public void setContactEmail1(String contactEmail1) {
		this.contactEmail1 = contactEmail1;
	}

	public String getContactEmail2() {
		return this.contactEmail2;
	}

	public void setContactEmail2(String contactEmail2) {
		this.contactEmail2 = contactEmail2;
	}

	public Date getContactEntryDate() {
		return this.contactEntryDate;
	}

	public void setContactEntryDate(Date contactEntryDate) {
		this.contactEntryDate = contactEntryDate;
	}

	public int getContactEntryId() {
		return this.contactEntryId;
	}

	public void setContactEntryId(int contactEntryId) {
		this.contactEntryId = contactEntryId;
	}

	public String getContactFname() {
		return this.contactFname;
	}

	public void setContactFname(String contactFname) {
		this.contactFname = contactFname;
	}

	public String getContactJobtitle() {
		return this.contactJobtitle;
	}

	public void setContactJobtitle(String contactJobtitle) {
		this.contactJobtitle = contactJobtitle;
	}

	public String getContactLandmark() {
		return this.contactLandmark;
	}

	public void setContactLandmark(String contactLandmark) {
		this.contactLandmark = contactLandmark;
	}

	public String getContactLname() {
		return this.contactLname;
	}

	public void setContactLname(String contactLname) {
		this.contactLname = contactLname;
	}

	public String getContactLocation() {
		return this.contactLocation;
	}

	public void setContactLocation(String contactLocation) {
		this.contactLocation = contactLocation;
	}

	public String getContactMobile1() {
		return this.contactMobile1;
	}

	public void setContactMobile1(String contactMobile1) {
		this.contactMobile1 = contactMobile1;
	}

	public String getContactMobile2() {
		return this.contactMobile2;
	}

	public void setContactMobile2(String contactMobile2) {
		this.contactMobile2 = contactMobile2;
	}

	public Date getContactModifiedDate() {
		return this.contactModifiedDate;
	}

	public void setContactModifiedDate(Date contactModifiedDate) {
		this.contactModifiedDate = contactModifiedDate;
	}

	public int getContactModifiedId() {
		return this.contactModifiedId;
	}

	public void setContactModifiedId(int contactModifiedId) {
		this.contactModifiedId = contactModifiedId;
	}

	public String getContactMsn() {
		return this.contactMsn;
	}

	public void setContactMsn(String contactMsn) {
		this.contactMsn = contactMsn;
	}

	public String getContactNotes() {
		return this.contactNotes;
	}

	public void setContactNotes(String contactNotes) {
		this.contactNotes = contactNotes;
	}

	public String getContactPhone1() {
		return this.contactPhone1;
	}

	public void setContactPhone1(String contactPhone1) {
		this.contactPhone1 = contactPhone1;
	}

	public String getContactPhone2() {
		return this.contactPhone2;
	}

	public void setContactPhone2(String contactPhone2) {
		this.contactPhone2 = contactPhone2;
	}

	// public Object getContactPhoto() {
	// return this.contactPhoto;
	// }
	//
	// public void setContactPhoto(Object contactPhoto) {
	// this.contactPhoto = contactPhoto;
	// }

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactCustomerName() {
		return contactCustomerName;
	}

	public void setContactCustomerName(String contactCustomerName) {
		this.contactCustomerName = contactCustomerName;
	}

	public String getContactPic() {
		return this.contactPic;
	}

	public void setContactPic(String contactPic) {
		this.contactPic = contactPic;
	}

	public String getContactPin() {
		return this.contactPin;
	}

	public void setContactPin(String contactPin) {
		this.contactPin = contactPin;
	}

	public String getContactSkype() {
		return this.contactSkype;
	}

	public void setContactSkype(String contactSkype) {
		this.contactSkype = contactSkype;
	}

	public int getContactTitleId() {
		return this.contactTitleId;
	}

	public void setContactTitleId(int contactTitleId) {
		this.contactTitleId = contactTitleId;
	}

	public String getContactYahoo() {
		return this.contactYahoo;
	}

	public void setContactYahoo(String contactYahoo) {
		this.contactYahoo = contactYahoo;
	}

	public AxelaCustomer getAxelaCustomers() {
		return axelaCustomers;
	}

	public void setAxelaCustomers(AxelaCustomer axelaCustomers) {
		this.axelaCustomers = axelaCustomers;
	}

	@OneToMany(mappedBy = "axelaCustomerContact")
	private List<AxelaSalesOppr> axelaSalesOppr;

	// public AxelaCustomer addAxelaCustomer(AxelaCustomer axelaCustomer) {
	// getAxelaCustomers().add(axelaCustomer);
	// axelaCustomer.setAxelaCustomerContact(this);
	//
	// return axelaCustomer;
	// }

	// public AxelaCustomer removeAxelaCustomer(AxelaCustomer axelaCustomer) {
	// getAxelaCustomers().remove(axelaCustomer);
	// axelaCustomer.setAxelaCustomerContact(null);
	//
	// return axelaCustomer;
	// }

	public String getContactStateName() {
		return contactStateName;
	}

	public void setContactStateName(String contactStateName) {
		this.contactStateName = contactStateName;
	}

	public String getContactCountryName() {
		return contactCountryName;
	}

	public void setContactCountryName(String contactCountryName) {
		this.contactCountryName = contactCountryName;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

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

	public long getTicketopen() {
		return ticketopen;
	}

	public void setTicketopen(long ticketopen) {
		this.ticketopen = ticketopen;
	}

	public long getJcopen() {
		return jcopen;
	}

	public void setJcopen(long jcopen) {
		this.jcopen = jcopen;
	}

	public List<AxelaSalesOppr> getAxelaSalesOppr() {
		return axelaSalesOppr;
	}
	public int getTitleId() {
		return TitleId;
	}

	public void setTitleId(int titleId) {
		TitleId = titleId;
	}

	public void setAxelaSalesOppr(List<AxelaSalesOppr> axelaSalesOppr) {
		this.axelaSalesOppr = axelaSalesOppr;
	}

	public int getCustomerBranchId() {
		return customerBranchId;
	}

	public void setCustomerBranchId(int customerBranchId) {
		this.customerBranchId = customerBranchId;
	}

	public int getCustomerSoeId() {
		return customerSoeId;
	}

	public void setCustomerSoeId(int customerSoeId) {
		this.customerSoeId = customerSoeId;
	}

	public int getCustomerSobId() {
		return customerSobId;
	}

	public void setCustomerSobId(int customerSobId) {
		this.customerSobId = customerSobId;
	}

	public List<AxelaHelpDeskTicket> getAxelaHelpDeskTicket() {
		return axelaHelpDeskTicket;
	}

	public void setAxelaHelpDeskTicket(List<AxelaHelpDeskTicket> axelaHelpDeskTicket) {
		this.axelaHelpDeskTicket = axelaHelpDeskTicket;
	}

	@OneToMany(mappedBy = "axelaCustomerContact")
	private List<AxelaAccVoucher> axelaAccVoucher;

	@OneToMany(mappedBy = "axelaCustomerContact", cascade = CascadeType.ALL)
	private List<AxelaActivity> axelaActivity;

	public List<AxelaActivity> getAxelaActivity() {
		return axelaActivity;
	}

	public void setAxelaActivity(List<AxelaActivity> axelaActivity) {
		this.axelaActivity = axelaActivity;
	}

	public AxelaCustomerContact(int contactId,
			int contactTitleId,
			String contactFname,
			String contactLname,
			String contactActive,
			String contactAddress,
			Date contactAnniversary,
			String contactAol,
			String contactCityId,
			String customerName,
			int customerBranchId,
			String contactDnd,
			Date contactDob,
			String contactMobile1,
			String contactMobile2,
			String contactPhone1,
			String contactPhone2,
			String contactEmail1,
			String contactEmail2,
			String contactJobtitle,
			int customerSoeId,
			int customerSobId,
			String contactLandmark,
			String contactLocation,
			String contactMsn,
			String contactNotes,
			String contactPin,
			String contactSkype,
			int contactEntryId,
			Date contactEntryDate,
			Date contactModifiedDate,
			int contactModifiedId,
			String contactYahoo) {
		this.contactId = contactId;
		this.contactTitleId = contactTitleId;
		this.contactFname = contactFname;
		this.contactLname = contactLname;
		this.contactActive = contactActive;
		this.contactAddress = contactAddress;
		this.contactAnniversary = contactAnniversary;
		this.contactAol = contactAol;
		this.contactCityId = contactCityId;
		this.customerName = customerName;
		this.contactDnd = contactDnd;
		this.contactDob = contactDob;
		this.contactMobile1 = contactMobile1;
		this.contactMobile2 = contactMobile2;
		this.contactPhone1 = contactPhone1;
		this.contactPhone2 = contactPhone2;
		this.contactEmail1 = contactEmail1;
		this.contactEmail2 = contactEmail2;
		this.contactJobtitle = contactJobtitle;
		this.customerBranchId = customerBranchId;
		this.customerSoeId = customerSoeId;
		this.customerSobId = customerSobId;
		this.contactLandmark = contactLandmark;
		this.contactLocation = contactLocation;
		this.contactMsn = contactMsn;
		this.contactNotes = contactNotes;
		this.contactPin = contactPin;
		this.contactSkype = contactSkype;
		this.contactEntryId = contactEntryId;
		this.contactEntryDate = contactEntryDate;
		this.contactModifiedDate = contactModifiedDate;
		this.contactModifiedId = contactModifiedId;
		this.contactYahoo = contactYahoo;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
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

	public Long getCustomersCount() {
		return customersCount;
	}

	public void setCustomersCount(Long customersCount) {
		this.customersCount = customersCount;
	}

}