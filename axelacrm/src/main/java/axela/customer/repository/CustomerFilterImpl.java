package axela.customer.repository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.customer.model.AxelaCustomer;
import axela.customer.model.AxelaCustomerContact;
import axela.customer.repository.CustomerRepository.CustomerFilterRepository;
import axela.portal.model.AxelaBranch;
import axela.service.model.AxelaModuleReport;

@Repository
@Transactional(readOnly = true)
public class CustomerFilterImpl implements CustomerFilterRepository {
	@PersistenceContext
	EntityManager em;
	public static String totalCount = "0";
	public static int listContactLength = 0;
	public static int listLength = 0;

	public List<AxelaBranch> findAllByBranch(String branchAccess) {
		Query query = em.createQuery("SELECT a FROM AxelaBranch a WHERE a.branchActive = '1' " + branchAccess);
		return (List<AxelaBranch>) query.getResultList();
	}

	public int length(String branchAccess, String exeAccess, String sort, String field) {
		Query query = em.createQuery("SELECT a FROM AxelaCustomer a WHERE 1=1 AND a.customerType !='0'" + branchAccess + exeAccess + " ORDER BY a." + field + " " + sort);
		em.clear();
		return (int) query.getResultList().size();
	}

	public AxelaCustomer findCustomerOne(int customerId) {
		AxelaCustomer list = new AxelaCustomer();
		String strSql = "SELECT NEW AxelaCustomer("
				+ " customer.customerType,"
				+ " customer.customerName,"
				+ " customer.customerCode,"
				+ " customer.customerBranchId,"
				+ " customer.customerMobile1,"
				+ " customer.customerMobile2,"
				+ " customer.customerPhone1,"
				+ " customer.customerPhone2,"
				+ " customer.customerPhone3,"
				+ " customer.customerPhone4,"
				+ " customer.customerFax1,"
				+ " customer.customerFax2,"
				+ " customer.customerEmail1,"
				+ " customer.customerEmail2,"
				+ " customer.customerWebsite1,"
				+ " customer.customerWebsite2,"
				+ " customer.customerGstNo,"
				+ " customer.customerGstRegdate,"
				+ " customer.customerArnNo,"
				+ " customer.customerItstatusId,"
				+ " customer.customerAddress1,"
				+ " customer.customerLandmark,"
				+ " customer.customerCityId,"
				+ " customer.customerPin,"
				+ " customer.customerTinNo,"
				+ " customer.customerServiceTaxNo,"
				+ " customer.customerTds,"
				+ " customer.customerPanNo,"
				+ " customer.customerSoeId,"
				+ " customer.customerSobId,"
				+ " customer.customerRateclassId,"
				+ " customer.customerCreditLimit,"
				+ " customer.customerDiscPerc,"
				+ " customer.customerSince,"
				+ " customer.customerEmpcountId,"
				+ " customer.customerPaydaysId,"
				+ " customer.customerEmpId,"
				+ " customer.customerAccgroupId,"
				+ " customer.customerActive,"
				+ " customer.customerNotes,"
				+ " customer.customerId,"
				+ " customer.customerEntryId,"
				+ " customer.customerModifiedId,"
				+ " customer.customerEntryDate,"
				+ " customer.customerModifiedDate"
				+ " )"
				+ " FROM AxelaCustomer customer"
				+ " JOIN customer.axelaCity"
				+ " LEFT JOIN customer.axelaBranch"
				+ " LEFT JOIN customer.axelaEmp"
				+ " WHERE customer.customerId=" + customerId;
		list = em.createQuery(strSql, AxelaCustomer.class).getSingleResult();
		return list;
	}

	public List<AxelaCustomer> findAll(String strSearch, String strOrderBy, int page, int perPage, String tag) {
		String countSql = "";
		String sqlJoin = "";
		TypedQuery<AxelaCustomer> typedQuery = null;
		List<AxelaCustomer> listData = new ArrayList<AxelaCustomer>();
		String strSql = "SELECT NEW AxelaCustomer("
				+ " customer.customerId,"
				+ " customer.customerName,"
				+ " customer.customerActive,"
				+ " customer.customerCurrBal,"
				+ " customer.customerMobile1,"
				+ " customer.customerMobile2,"
				+ " customer.customerPhone1,"
				+ " customer.customerPhone2,"
				+ " customer.customerPhone3,"
				+ " customer.customerPhone4,"
				+ " customer.customerEmail1,"
				+ " customer.customerEmail2,"
				+ " customer.customerFax1,"
				+ " customer.customerFax2,"
				+ " customer.customerWebsite1,"
				+ " customer.customerWebsite2,"
				+ " customer.customerAddress1,"
				+ " customer.customerAddress2,"
				+ " customer.customerPin,"
				+ " customer.customerLandmark,"
				+ " customer.customerType,"
				+ " COALESCE(customer.axelaCity.cityName, '') AS cityName,"
				+ " COALESCE(customer.axelaCity.axelaState.stateName, '') AS stateName,"
				+ " COALESCE(customer.axelaCity.axelaState.axelaCountry.countryName, '') AS countryName,"
				+ " COALESCE(customer.axelaSoe.soeName, '') AS soeName,"
				+ " COALESCE(customer.axelaSob.sobName, '') AS sobName,"
				+ " COALESCE(customer.axelaEmp.empName, '') AS empName,"
				+ " COALESCE(customer.axelaBranch.branchName, '') AS branchName,"
				+ " (SELECT DISTINCT(COUNT(b.contactId))"
				+ " FROM AxelaCustomerContact b"
				+ " WHERE b.contactCustomerId = customer.customerId) AS contactcount)";

		sqlJoin = " FROM AxelaCustomer customer"
				+ " LEFT JOIN customer.axelaSoe"
				+ " LEFT JOIN customer.axelaSob"
				+ " LEFT JOIN customer.axelaCity"
				+ " LEFT JOIN customer.axelaCity.axelaState"
				+ " LEFT JOIN customer.axelaCity.axelaState.axelaCountry"
				+ " LEFT JOIN customer.axelaEmp"
				+ " LEFT JOIN customer.axelaBranch"
				+ " WHERE 1=1"
				+ " AND customer.customerType !='0' ";
		if (tag.toLowerCase().equals("supplier")) {
			sqlJoin += " AND customer.customerType='2'";
		} else {
			sqlJoin += " AND customer.customerType='1'";
		}
		countSql = "SELECT COUNT(DISTINCT customer.customerId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ strSearch
					+ " GROUP BY customer.customerId"
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaCustomer.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.clear();
		return listData;
	}

	public List<AxelaCustomerContact> findAllContacts(String strSearch, String strOrderBy, int page, int perpage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaCustomerContact> listData = new ArrayList<AxelaCustomerContact>();
		String strSql = "SELECT NEW AxelaCustomerContact("
				+ " contact.contactId,"
				+ " contact.contactCustomerId,"
				+ " contact.contactCityId,"
				+ " contact.contactAddress,"
				+ " contact.contactEmail1,"
				+ " contact.contactEmail2,"
				+ " contact.contactLandmark,"
				+ " contact.contactMobile1,"
				+ " contact.contactMobile2,"
				+ " contact.contactPhone1,"
				+ " contact.contactPhone2,"
				+ " contact.contactPin,"
				+ " CONCAT(contact.axelaTitle.titleDesc, ' ', contact.contactFname, ' ', contact.contactLname) AS contactName,"
				// + " COALESCE(contact.axelaServiceJc.jcSerialno, '') AS jcSerialno,"
				+ " COALESCE(customers.customerName, '') AS customerName,"
				+ " COALESCE(city.cityName, '') AS cityName,"
				+ " COALESCE(state.stateName, '') AS stateName,"
				+ " COALESCE(state.axelaCountry.countryName, '') AS countryName,"
				+ " COALESCE(customers.axelaEmp.empName, '') AS empName,"
				+ " COALESCE(customers.axelaBranch.branchId, '') AS branchId,"
				+ " COALESCE(customers.axelaBranch.branchName, '') AS branchName,"
				+ " contact.contactActive)";

		sqlJoin = " FROM AxelaCustomerContact contact"
				+ " JOIN contact.axelaTitle title"
				+ " JOIN contact.axelaCustomers customers"
				+ " JOIN contact.axelaCity city"
				+ " JOIN city.axelaState state"
				+ " JOIN state.axelaCountry country"
				+ " LEFT JOIN contact.axelaServiceJc"
				+ " LEFT JOIN customers.axelaEmp"
				+ " LEFT JOIN customers.axelaBranch branch"
				+ " WHERE 1=1"
				+ "" + strSearch;

		countSql = "SELECT COUNT(DISTINCT contact.contactId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY contact.contactId"
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaCustomerContact.class).setFirstResult((page - 1) * perpage).setMaxResults(perpage).getResultList();
		}
		em.clear();
		return listData;
	}

	public List<Object[]> findByCustomerIdAndCustomerName(String customerId) {
		String Query = "SELECT a.customerId,a.customerName "
				+ " FROM  AxelaCustomer a"
				+ " WHERE 1=1";
		if (!customerId.equals("0")) {
			Query += " AND a.customerId=" + customerId;
		}

		Query += " GROUP BY customerId"
				+ " ORDER BY customerName";
		TypedQuery<Object[]> typedQuery = em.createQuery(Query, Object[].class);
		listLength = em.createQuery(Query, Object[].class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}

	public List<Object[]> findByCustomerContactId(String contactMobile1, String contactPhone1, String contactEmail1)
	{
		String Query = "SELECT a.contactCustomerId,"
				+ " a.contactId"
				+ " FROM AxelaCustomerContact a"
				+ " where";
		if (!contactMobile1.equals("")) {
			Query += " a.contactMobile1 = '" + contactMobile1 + "'";
		}
		if ((!contactMobile1.equals("") && !contactPhone1.equals("")) || (!contactMobile1.equals("") && !contactEmail1.equals(""))) {
			Query += " or";
		}
		if (!contactPhone1.equals("")) {
			Query += " a.contactPhone1 = '" + contactPhone1 + "'";
		}
		if (!contactPhone1.equals("") && !contactEmail1.equals("")) {
			Query += " or";
		}
		if (!contactEmail1.equals("")) {
			Query += " a.contactEmail1 = '" + contactEmail1 + "'";
		}
		TypedQuery<Object[]> typedQuery = em.createQuery(Query, Object[].class);
		listLength = em.createQuery(Query, Object[].class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}

	public List<Object[]> findByContactDetails(int ticketJcId, int ticketContactId) {
		String Query = "SELECT "
				+ " a.axelaCustomers.customerName,"
				+ " a.axelaCustomers.customerId,"
				+ " a.axelaCustomers.customerBranchId,"
				+ " a.contactId,"
				+ " CONCAT(a.axelaTitle.titleDesc,' ',a.contactFname,' ',a.contactLname) AS contactName,"
				+ " a.contactEmail1,"
				+ " a.contactEmail2,"
				+ " a.contactMobile1,"
				+ " a.contactMobile2"
				+ " FROM AxelaCustomerContact a"
				+ " INNER JOIN a.axelaCustomers"
				+ " INNER JOIN a.axelaTitle";
		if (ticketJcId != 0) {
			Query += " INNER JOIN a.axelaServiceJc";
		}
		Query += " WHERE 1=1";
		if (ticketContactId != 0) {
			Query += " AND a.contactId=" + ticketContactId + "";
		}
		if (ticketJcId != 0) {
			Query += " AND a.axelaServiceJc.jcId=" + ticketJcId + "";
		}
		TypedQuery<Object[]> typedQuery = em.createQuery(Query, Object[].class);
		return typedQuery.getResultList();

	}

	public List<AxelaCustomerContact> findByTxtSearch(String txtSearch, String strSearch, int page, int pageSize) {
		Query Query = em.createQuery("SELECT New AxelaCustomerContact("
				+ " a.contactId,"
				+ " concat(a.axelaTitle.titleDesc, ' ', a.contactFname, ' ', a.contactLname) AS contactName,"
				+ " a.contactEmail1,"
				+ " a.contactEmail2,"
				// + " COALESCE(a.contactPhoto,'') AS contactPhoto,"
				+ " a.contactMobile1,"
				+ " a.contactMobile2,"
				+ " a.contactJobtitle,"
				+ " a.contactLocation,"
				+ " a.contactPhone1,"
				+ " a.contactPhone2,"
				+ " a.contactNotes,"
				+ " a.axelaCustomers.customerId,"
				+ " a.axelaCustomers.customerName,"
				+ " a.contactMsn,"
				+ " a.contactActive,"
				+ " a.contactDob,"
				+ " a.contactAnniversary,"
				+ " a.contactYahoo,"
				+ " a.contactAol,"
				+ " a.contactAddress,"
				+ " a.contactPin,"
				+ " a.contactLandmark,"
				+ " a.axelaCity.cityName,"
				+ " a.axelaCity.axelaState.axelaCountry.countryName,"
				+ " (SELECT count(b.ticketId)"
				+ " FROM AxelaHelpDeskTicket b"
				+ " WHERE b.ticketCustomerId = a.axelaCustomers.customerId and b.ticketTicketstatusId!=3) AS ticketopen, "
				+ " (SELECT count(c.jcId)"
				+ " FROM AxelaServiceJc c"
				+ " WHERE c.jcCustomerId = a.axelaCustomers.customerId AND c.jcJcstatusId!=5 AND c.jcJcstatusId!=6) AS jcopen)"
				+ " FROM AxelaCustomerContact a"
				+ " INNER JOIN a.axelaCustomers"
				+ " INNER JOIN a.axelaTitle"
				+ " LEFT JOIN a.axelaCity"
				+ " LEFT JOIN a.axelaCity.axelaState"
				+ " LEFT JOIN a.axelaCity.axelaState.axelaCountry"
				+ " WHERE (a.axelaCustomers.customerId like '%" + txtSearch + "%' OR a.axelaCustomers.customerName like '%" + txtSearch + "%'"
				+ " OR a.contactId like '%" + txtSearch + "%' OR concat(a.contactFname, a.contactLname) like '%" + txtSearch + "%'"
				+ " OR REPLACE(a.contactMobile1,'-','') LIKE '%" + txtSearch + "%' OR REPLACE(a.contactMobile2,'-','') like '%" + txtSearch + "%'"
				+ " OR REPLACE(a.contactPhone1,'-','') LIKE '%" + txtSearch + "%' OR REPLACE(a.contactPhone2,'-','') like '%" + txtSearch + "%'"
				+ " OR a.contactEmail1 like '%" + txtSearch + "%' OR a.contactEmail2 like '%" + txtSearch + "%'"
				+ " OR a.contactNotes like '%" + txtSearch + "%' OR a.contactJobtitle like '%" + txtSearch + "%'"
				+ " OR a.contactLocation like '%" + txtSearch + "%' "
				+ " OR a.contactDob like '%" + txtSearch + "%' OR a.contactAddress like '%" + txtSearch + "%'"
				+ " OR a.contactPin like '%" + txtSearch + "%' OR a.contactLandmark like '%" + txtSearch + "%'"
				+ " OR a.axelaCity.cityName like '%" + txtSearch + "%' OR a.axelaCity.axelaState.axelaCountry.countryName like '%" + txtSearch + "%')"
				+ " GROUP BY a.contactId " + strSearch).setFirstResult((page - 1) * pageSize).setMaxResults(pageSize);
		em.clear();
		return Query.getResultList();
	}

	public List<AxelaCustomerContact> searchMobile(String contactMobile) {
		Query Query = em.createQuery("SELECT New AxelaCustomerContact("
				+ " salesOpper.opprId,"
				+ " status.statusName,"
				+ " CONCAT(title.titleDesc,' ', contact.contactFname,' ',contact.contactLname) AS contactName,"
				+ " contact.contactMobile1,"
				+ " contact.contactId,"
				+ " contact.axelaCustomers.customerName,"
				+ " contact.contactCustomerId) "
				+ " FROM AxelaCustomerContact contact"
				+ " JOIN contact.axelaSalesOppr salesOpper"
				+ " JOIN salesOpper.axelaSalesOpprStatus status"
				+ " JOIN contact.axelaTitle title"
				+ " JOIN contact.axelaCustomers"
				+ " WHERE (contact.contactMobile1 Like '%" + contactMobile + "%' OR contact.contactMobile2 Like '%" + contactMobile + "%')"
				+ " ORDER BY salesOpper.opprStatusId, salesOpper.opprId DESC"
				+ " ").setFirstResult(0).setMaxResults(10);
		em.clear();
		return Query.getResultList();
	}

	public List<AxelaCustomerContact> searchEmail(String contactEmail) {
		Query Query = em.createQuery("SELECT New AxelaCustomerContact("
				+ " concat(title.titleDesc,' ', contact.contactFname,' ',contact.contactLname) as contactName,"
				+ " contact.contactEmail1,contact.contactId,"
				+ " contact.axelaCustomers.customerName,"
				+ " ServiceJc.jcSerialno,"
				+ " contact.contactCustomerId)"
				+ " FROM AxelaCustomerContact contact"
				+ " JOIN contact.axelaServiceJc ServiceJc"
				+ " JOIN contact.axelaTitle title"
				+ " JOIN contact.axelaCustomers"
				+ " WHERE (contact.contactEmail1 Like '%" + contactEmail + "%' OR contact.contactEmail2 Like '%" + contactEmail + "%')"
				+ " order by contact.contactFname").setFirstResult(0).setMaxResults(10);
		em.clear();
		return Query.getResultList();
	}

	public List<AxelaCustomerContact> jcSerialno(String jcSerialno) {
		Query Query = em.createQuery("SELECT New AxelaCustomerContact("
				+ " concat(title.titleDesc,' ', contact.contactFname,' ',contact.contactLname) as contactName,"
				+ " contact.contactEmail1,"
				+ " contact.contactId,"
				+ " contact.axelaCustomers.customerName,"
				+ " ServiceJc.jcSerialno,"
				+ " contact.contactCustomerId)"
				+ " FROM AxelaCustomerContact contact"
				+ " JOIN contact.axelaServiceJc ServiceJc"
				+ " JOIN contact.axelaTitle title"
				+ " JOIN contact.axelaCustomers"
				+ " WHERE (ServiceJc.jcSerialno Like '%" + jcSerialno + "%' )"
				+ " order by contact.contactFname").setFirstResult(0).setMaxResults(10);
		em.clear();
		return Query.getResultList();
	}

	public List<AxelaCustomerContact> jcsearchMobile1(String contactMobile1) {
		Query Query = em.createQuery("SELECT New AxelaCustomerContact("
				+ " CONCAT(title.titleDesc,' ', contact.contactFname,' ',contact.contactLname) AS contactName,"
				+ " contact.contactId,"
				+ " contact.axelaCustomers.customerName,"
				+ " contact.contactMobile1,"
				+ " ServiceJc.jcSerialno,"
				+ " contact.contactCustomerId) "
				+ " FROM AxelaCustomerContact contact"
				+ " JOIN contact.axelaServiceJc ServiceJc"
				+ " JOIN contact.axelaTitle title"
				+ " JOIN contact.axelaCustomers"
				+ " WHERE (contact.contactMobile1 Like '%" + contactMobile1 + "%')"
				+ " order by contact.contactFname").setFirstResult(0).setMaxResults(10);
		em.clear();
		return Query.getResultList();
	}

	public AxelaCustomerContact findContactOne(int contactId) {
		AxelaCustomerContact list = new AxelaCustomerContact();
		String strSql = "SELECT NEW AxelaCustomerContact("
				+ "  contact.contactId,"
				+ "  contact.contactTitleId,"
				+ "  contact.contactFname,"
				+ "  contact.contactLname,"
				+ "  contact.contactActive,"
				+ "  contact.contactAddress,"
				+ "  contact.contactAnniversary,"
				+ "  contact.contactAol,"
				+ "  contact.contactCityId,"
				+ "  contact.axelaCustomers.customerName,"
				+ "  contact.axelaCustomers.customerBranchId,"
				+ "  contact.contactDnd,"
				+ "  contact.contactDob,"
				+ "  contact.contactMobile1,"
				+ "  contact.contactMobile2,"
				+ "  contact.contactPhone1,"
				+ "  contact.contactPhone2,"
				+ "  contact.contactEmail1,"
				+ "  contact.contactEmail2,"
				+ "  contact.contactJobtitle,"
				+ "  contact.axelaCustomers.customerSoeId,"
				+ "  contact.axelaCustomers.customerSobId,"
				+ "  contact.contactLandmark,"
				+ "  contact.contactLocation,"
				+ "  contact.contactMsn,"
				+ "  contact.contactNotes,"
				+ "  contact.contactPin,"
				+ "  contact.contactSkype,"
				+ "  contact.contactEntryId,"
				+ "  contact.contactEntryDate,"
				+ "  contact.contactModifiedDate,"
				+ "  contact.contactModifiedId,"
				+ "  contact.contactYahoo)"
				+ " FROM AxelaCustomerContact contact"
				+ " JOIN contact.axelaCustomers customer"
				+ " JOIN contact.axelaCity"
				+ " LEFT JOIN customer.axelaBranch"
				+ " LEFT JOIN customer.axelaEmp"
				+ " WHERE contact.contactId=" + contactId;
		list = em.createQuery(strSql, AxelaCustomerContact.class).getSingleResult();
		return list;
	}

	public List<AxelaCustomer> findByIdAndName(int customerId, String customerName, Pageable pageAble) {
		String query = "SELECT"
				+ " customer"
				+ " FROM AxelaCustomer customer"
				+ " WHERE 1=1";
		if (customerId != 0) {
			query += " AND customer.customerId=" + customerId;
		}
		if (!customerName.equals("")) {
			query += " AND customer.customerName LIKE '%" + customerName + "%'";
		}
		query += " GROUP BY customer.customerId"
				+ " ORDER BY customer.customerName";
		TypedQuery<AxelaCustomer> typed = em.createQuery(query, AxelaCustomer.class).setFirstResult((1 - 1) * 10).setMaxResults(10);
		return typed.getResultList();
	}

	// reccent customer landing page
	public List<AxelaCustomer> findAllRecentCustomer(String strSearch) {
		String sqlJoin = "";
		String countSql = "1";
		List<AxelaCustomer> listData = new ArrayList<AxelaCustomer>();
		String strSql = "SELECT NEW AxelaCustomer("
				+ " customer.customerId,"
				+ " customer.customerName,"
				+ " COALESCE(sum(voucher.voucherAmount),0) AS voucherAmount)"
				+ " FROM AxelaCustomer customer"
				+ " JOIN customer.axelaAccVoucher voucher"
				+ " JOIN voucher.axelaAccVoucherType voucherType"
				+ " WHERE 1=1"
				+ " AND customer.customerActive=1"
				+ " AND voucher.voucherActive=1"
				+ " AND voucherType.vouchertypeActive=1"
				+ " AND (voucherType.vouchertypeVoucherclassId = 6 OR voucherType.vouchertypeVoucherclassId = 7)"
				+ " GROUP BY customer.customerId "
				+ " ORDER BY customer.customerEntryDate DESC"
				+ "" + strSearch;
		listData = em.createQuery(strSql, AxelaCustomer.class).getResultList();

		em.clear();
		System.out.println("listData=======" + listData);
		return listData;
	}

	public List<AxelaCustomer> findAllTopCustomer(String strSearch) {
		String sqlJoin = "";
		String countSql = "1";
		List<AxelaCustomer> listData = new ArrayList<AxelaCustomer>();
		String strSql = "SELECT NEW AxelaCustomer("
				+ " customer.customerId,"
				+ " customer.customerName,"
				+ " COALESCE(sum(voucher.voucherAmount),0) AS voucherAmount)"
				+ " FROM AxelaCustomer customer"
				+ " JOIN customer.axelaAccVoucher voucher"
				+ " JOIN voucher.axelaAccVoucherType voucherType"
				+ " WHERE 1=1"
				+ " AND customer.customerActive=1"
				+ " AND voucher.voucherActive=1"
				+ " AND voucherType.vouchertypeActive=1"
				+ " AND (voucherType.vouchertypeVoucherclassId = 6 OR voucherType.vouchertypeVoucherclassId = 7)"
				// + " AND SUBSTR(voucher.voucherDate,1,8) > SUBSTR('" + date + "',1,8)"
				+ " GROUP BY customer.customerId "
				+ " ORDER BY voucher.voucherAmount DESC"
				+ "" + strSearch;
		listData = em.createQuery(strSql, AxelaCustomer.class).getResultList();

		em.clear();
		System.out.println("listData=======" + listData);
		return listData;
	}

	String sqlJoin = "";
	public List<AxelaCustomer> findAllCustomersForLanding(String strSearch) throws ParseException {
		String countSql = "1";
		List<AxelaCustomer> listData = new ArrayList<AxelaCustomer>();
		String strSql = "SELECT NEW AxelaCustomer("
				+ " branch.branchId,"
				+ " branch.branchName,"
				+ " branch.branchCode,"
				+ " COUNT(customer.customerId))"
				+ " FROM AxelaCustomer customer"
				+ " JOIN customer.axelaBranch branch"
				+ " JOIN customer.axelaCity city"
				+ " JOIN city.axelaState state"
				+ " JOIN state.axelaCountry country"
				+ " LEFT JOIN customer.axelaSoe soe"
				+ " LEFT JOIN customer.axelaSob sob"
				+ " LEFT JOIN customer.axelaEmpcount empcount"
				+ " WHERE 1=1 "
				+ strSearch
				// + " AND SUBSTR(customer.customerEntryDate,1,8) > SUBSTR('" + stringToDate(startdate) + "',1,8)"
				+ " GROUP BY branch.branchId "
				+ " ORDER BY branch.branchName";
		System.out.println("strSql========================" + strSql);

		listData = em.createQuery(strSql, AxelaCustomer.class).getResultList();

		em.clear();
		System.out.println("listData=======" + listData);
		return listData;
	}

	public List<AxelaCustomerContact> findAllCostactsForLanding(String strSearch) throws ParseException {
		String countSql = "1";
		List<AxelaCustomerContact> listData = new ArrayList<AxelaCustomerContact>();
		String strSql = "SELECT NEW AxelaCustomerContact("
				+ " branch.branchId,"
				+ " branch.branchName,"
				+ " branch.branchCode,"
				+ " COUNT(contact.contactId))"
				+ " FROM AxelaCustomerContact contact"
				+ " JOIN contact.axelaCustomers customer"
				+ " JOIN customer.axelaBranch branch"
				+ " WHERE 1=1 "
				+ strSearch
				// + " AND SUBSTR(customer.customerEntryDate,1,8) > SUBSTR('" + stringToDate(startdate) + "',1,8)"
				+ " GROUP BY branch.branchId "
				+ " ORDER BY branch.branchName";
		System.out.println("strSql========================" + strSql);

		listData = em.createQuery(strSql, AxelaCustomerContact.class).getResultList();

		em.clear();
		System.out.println("listData=======" + listData);
		return listData;
	}

	// top customer report page start

	// sales order segment start
	public List<AxelaCustomer> findAllSales(String strSearch) throws ParseException {
		List<AxelaCustomer> listData = new ArrayList<AxelaCustomer>();
		String strSql = "SELECT NEW AxelaCustomer("
				+ " customer.customerId,"
				+ " customer.customerName,"
				+ " sum(voucher.voucherAmount))"
				+ " FROM AxelaCustomer customer"
				+ " JOIN customer.axelaAccVoucher voucher"
				+ " JOIN voucher.axelaAccVoucherType vouchertype"
				+ " JOIN voucher.axelaBranch branch"
				+ " JOIN voucher.axelaEmp emp"
				+ " JOIN emp.axelaSalesTeamExe exe" // checking join
				+ " JOIN exe.axelaSalesTeam team " // checking join
				+ " WHERE 1=1 "
				+ " AND vouchertype.vouchertypeVoucherclassId = 4 AND customer.customerActive=1"
				+ strSearch
				// + " AND SUBSTR(customer.customerEntryDate,1,8) > SUBSTR('" + stringToDate(startdate) + "',1,8)"
				+ " GROUP BY customer.customerId "
				+ " ORDER BY voucher.voucherAmount DESC";
		listData = em.createQuery(strSql, AxelaCustomer.class).getResultList();
		em.clear();
		return listData;
	}
	// sales order segment end

	// incoice segment start
	public List<AxelaCustomer> findAllInvoice(String strSearch) throws ParseException {
		String countSql = "1";
		List<AxelaCustomer> listData = new ArrayList<AxelaCustomer>();
		String strSql = "SELECT NEW AxelaCustomer("
				+ " customer.customerId,"
				+ " customer.customerName,"
				+ " sum(voucher.voucherAmount))"
				+ " FROM AxelaCustomer customer"
				+ " JOIN customer.axelaAccVoucher voucher"
				+ " JOIN voucher.axelaAccVoucherType vouchertype"
				+ " JOIN voucher.axelaBranch branch"
				+ " JOIN voucher.axelaEmp emp"
				+ " JOIN emp.axelaSalesTeamExe exe" // checking join
				+ " JOIN exe.axelaSalesTeam team " // checking join
				+ " WHERE 1=1 "
				+ " AND vouchertype.vouchertypeVoucherclassId = 6 AND customer.customerActive=1"
				+ strSearch
				// + " AND SUBSTR(customer.customerEntryDate,1,8) > SUBSTR('" + stringToDate(startdate) + "',1,8)"
				+ " GROUP BY customer.customerId "
				+ " ORDER BY voucher.voucherAmount DESC";
		System.out.println("strSql=========22222222222==================" + strSql);
		listData = em.createQuery(strSql, AxelaCustomer.class).getResultList();

		em.clear();
		System.out.println("listData=======" + listData);
		return listData;
	}
	// incoice segment end

	// Receipt Segment start
	public List<AxelaCustomer> findAllReciepts(String strSearch) throws ParseException {
		String countSql = "1";
		List<AxelaCustomer> listData = new ArrayList<AxelaCustomer>();
		String strSql = "SELECT NEW AxelaCustomer("
				+ " customer.customerId,"
				+ " customer.customerName,"
				+ " sum(voucher.voucherAmount))"
				+ " FROM AxelaCustomer customer"
				+ " JOIN customer.axelaAccVoucher voucher"
				+ " JOIN voucher.axelaAccVoucherType vouchertype"
				+ " JOIN voucher.axelaBranch branch"
				+ " JOIN voucher.axelaEmp emp"
				+ " JOIN emp.axelaSalesTeamExe exe" // checking join
				+ " JOIN exe.axelaSalesTeam team " // checking join
				+ " WHERE 1=1 "
				+ " AND vouchertype.vouchertypeVoucherclassId = 9 AND customer.customerActive=1"
				+ strSearch
				// + " AND SUBSTR(customer.customerEntryDate,1,8) > SUBSTR('" + stringToDate(startdate) + "',1,8)"
				+ " GROUP BY customer.customerId "
				+ " ORDER BY voucher.voucherAmount DESC";
		listData = em.createQuery(strSql, AxelaCustomer.class).getResultList();

		em.clear();
		System.out.println("listData=======" + listData);
		return listData;
	}
	// Receipt Segment end

	// top customer overdue report page start
	public List<AxelaCustomer> findAllTopCustomerOverdues(String strSearch) throws ParseException {
		String countSql = "1";
		List<AxelaCustomer> listData = new ArrayList<AxelaCustomer>();
		String strSql = "SELECT NEW AxelaCustomer("
				+ " customer.customerId,"
				+ " customer.customerName,"
				+ " sum(customer.customerCurrBal))"
				+ " FROM AxelaCustomer customer"
				+ " JOIN customer.axelaBranch branch"
				+ " JOIN customer.axelaEmp emp"
				+ " WHERE 1=1 "
				+ " AND customer.customerCurrBal < 0"
				+ strSearch
				// + " AND SUBSTR(customer.customerEntryDate,1,8) > SUBSTR('" + stringToDate(startdate) + "',1,8)"
				+ " GROUP BY customer.customerId "
				+ " ORDER BY customer.customerCurrBal ASC";
		listData = em.createQuery(strSql, AxelaCustomer.class).getResultList();
		em.clear();
		return listData;
	}
	// top customer overdue report page end

	// top customer pending report page start
	public List<AxelaCustomer> findAllTopCustomersPending(String strSearch) throws ParseException {
		String countSql = "1";
		List<AxelaCustomer> listData = new ArrayList<AxelaCustomer>();
		String strSql = "SELECT NEW AxelaCustomer("
				+ " customer.customerId,"
				+ " customer.customerName,"
				+ " sum(customer.customerCurrBal))"
				+ " FROM AxelaCustomer customer"
				+ " JOIN customer.axelaBranch branch"
				+ " JOIN customer.axelaEmp emp"
				+ " WHERE 1=1 "
				+ " AND customer.customerCurrBal > 0"
				+ strSearch
				// + " AND SUBSTR(customer.customerEntryDate,1,8) > SUBSTR('" + stringToDate(startdate) + "',1,8)"
				+ " GROUP BY customer.customerId "
				+ " ORDER BY customer.customerCurrBal ASC";
		listData = em.createQuery(strSql, AxelaCustomer.class).getResultList();
		em.clear();
		return listData;
	}
	// top customer pending report page end

	// conyacy birthday report pagestart
	public List<AxelaCustomerContact> findAllContactBithday(String strSearch) throws ParseException {
		String countSql = "1";
		List<AxelaCustomerContact> listData = new ArrayList<AxelaCustomerContact>();
		String strSql = "SELECT NEW AxelaCustomerContact("
				+ " contact.contactId,"
				+ " COALESCE(CONCAT(title.titleDesc, ' ', contact.contactFname, ' ', contact.contactLname,''), '') AS contactName,"
				+ " contact.contactJobtitle,"
				+ " contact.contactDob,"
				+ " customer.customerId,"
				+ " customer.customerName,"
				+ " branch.branchId,"
				+ " branch.branchName,"
				+ " branch.branchCode)"
				+ " FROM AxelaCustomerContact contact"
				+ " JOIN contact.axelaTitle title"
				+ " JOIN contact.axelaCustomers customer"
				+ " JOIN customer.axelaBranch branch"
				+ " WHERE 1=1 "
				+ strSearch
				// + " AND SUBSTR(customer.customerEntryDate,1,8) > SUBSTR('" + stringToDate(startdate) + "',1,8)"
				+ " GROUP BY contact.contactId "
				+ " ORDER BY contact.contactDob ASC";
		listData = em.createQuery(strSql, AxelaCustomerContact.class).getResultList();
		em.clear();
		return listData;
	}
	// contact birthday report page end

	// contact anniversary report page start
	public List<AxelaCustomerContact> findAllContactAnniversary(String strSearch) throws ParseException {
		String countSql = "1";
		List<AxelaCustomerContact> listData = new ArrayList<AxelaCustomerContact>();
		String strSql = "SELECT NEW AxelaCustomerContact("
				+ " contact.contactId,"
				+ " COALESCE(CONCAT(title.titleDesc, ' ', contact.contactFname, ' ', contact.contactLname,''), '') AS contactName,"
				+ " contact.contactJobtitle,"
				+ " customer.customerId,"
				+ " contact.contactAnniversary,"
				+ " customer.customerName,"
				+ " branch.branchId,"
				+ " branch.branchName,"
				+ " branch.branchCode)"
				+ " FROM AxelaCustomerContact contact"
				+ " JOIN contact.axelaTitle title"
				+ " JOIN contact.axelaCustomers customer"
				+ " JOIN customer.axelaBranch branch"
				+ " WHERE 1=1 "
				+ strSearch
				// + " AND SUBSTR(customer.customerEntryDate,1,8) > SUBSTR('" + stringToDate(startdate) + "',1,8)"
				+ " GROUP BY contact.contactId "
				+ " ORDER BY contact.contactDob ASC";
		listData = em.createQuery(strSql, AxelaCustomerContact.class).getResultList();
		em.clear();
		return listData;
	}
	// contact anniversary report page end

	// top customer report page end

	// customer dash start
	public AxelaCustomer findAllDashCustomerDetail(String strSearch, int customerId) throws ParseException {
		String countSql = "1";
		AxelaCustomer listData = new AxelaCustomer();
		String strSql = "SELECT NEW AxelaCustomer("
				+ " branch.branchName,"
				+ " branch.branchCode,"
				+ " branch.branchId,"
				+ " customer.customerAddress1,"
				+ " customer.customerLandmark,"
				+ " customer.customerPhone1,"
				+ " customer.customerPhone2,"
				+ " customer.customerPhone3,"
				+ " customer.customerEmail1,"
				+ " customer.customerEmpId,"
				+ " customer.customerWebsite1,"
				+ " customer.customerWebsite2,"
				+ " customer.customerPin,"
				+ " customer.customerNotes,"
				+ " customer.customerActive,"
				+ " city.cityName,"
				+ " country.countryName,"
				+ " emp.empName)"
				+ " FROM AxelaCustomer customer"
				+ " JOIN customer.axelaBranch branch"
				+ " JOIN customer.axelaCity city"
				+ " JOIN city.axelaState state"
				+ " JOIN state.axelaCountry country"
				+ " LEFT JOIN customer.axelaEmp emp"
				+ " WHERE 1=1 "
				+ " AND customer.customerId=" + customerId
				+ strSearch
				+ " GROUP BY customer.customerId"
				// + " AND SUBSTR(customer.customerEntryDate,1,8) > SUBSTR('" + stringToDate(startdate) + "',1,8)"
				+ " ORDER BY customer.customerCurrBal ASC";
		listData = em.createQuery(strSql, AxelaCustomer.class).getSingleResult();
		em.clear();
		return listData;
	}

	public List<AxelaCustomerContact> findAllDashContactList(String strSearch, int customerId) throws ParseException {
		String countSql = "1";
		List<AxelaCustomerContact> listData = new ArrayList<AxelaCustomerContact>();
		String strSql = "SELECT NEW AxelaCustomerContact("
				+ " contact.contactId,"
				+ " contact.contactCustomerId,"
				+ " title.titleDesc,"
				+ " contact.contactFname,"
				+ " contact.contactLname,"
				+ " contact.contactJobtitle,"
				+ " contact.contactLocation,"
				+ " contact.contactPhone1,"
				+ " contact.contactPhone2,"
				+ " contact.contactMobile1,"
				+ " contact.contactMobile2,"
				+ " contact.contactAnniversary,"
				+ " contact.contactEmail1,"
				+ " contact.contactEmail2,"
				+ " contact.contactYahoo,"
				+ " contact.contactMsn,"
				+ " contact.contactAol,"
				+ " contact.contactAddress,"
				+ " contact.contactPin,"
				+ " contact.contactLandmark,"
				+ " contact.contactDob,"
				+ " contact.contactActive,"
				+ " city.cityName,"
				+ " country.countryName,"
				+ " customer.customerId,"
				+ " customer.customerName,"
				+ " branch.branchName,"
				+ " branch.branchCode)"
				+ " FROM AxelaCustomerContact contact"
				+ " JOIN contact.axelaTitle title"
				+ " JOIN contact.axelaCustomers customer"
				+ " JOIN customer.axelaBranch branch"
				+ " JOIN contact.axelaCity city"
				+ " JOIN city.axelaState state"
				+ " JOIN state.axelaCountry country"
				+ " WHERE 1=1 "
				+ " AND contact.contactCustomerId=" + customerId
				+ strSearch
				+ " ORDER BY contact.contactId DESC";
		listData = em.createQuery(strSql, AxelaCustomerContact.class).getResultList();
		em.clear();
		return listData;
	}

	public List<Object[]> findAllDashCustomerDetailsList(String strSearch, int customerId) throws ParseException {
		String Query =
				"SELECT "
						+ "COALESCE("
						+ " (SELECT COUNT(DISTINCT contact.contactId) FROM  AxelaCustomerContact contact"
						+ " WHERE contact.contactCustomerId = customer.customerId),'') AS contactcount,"

						+ " (CASE WHEN comp.compModulePm = 1 THEN "
						+ "COALESCE("
						+ "(SELECT COUNT(pm.pmId)  FROM AxelaPm pm"
						+ " WHERE pm.pmCustomerId = customer.customerId), '') "
						+ " END) AS projectcount, "

						+ " (CASE WHEN comp.compModuleSales = 1 THEN "
						+ " COALESCE("
						+ " (SELECT CONCAT(COUNT(oppr.opprId), '-', SUM(oppr.opprBudgetSyscal))"
						+ " FROM AxelaSalesOppr oppr"
						+ " WHERE oppr.opprCustomerId = customer.customerId), '')"
						+ " END) AS opprcount,"

						+ " (CASE WHEN comp.compModuleSales = 1 THEN "
						+ " COALESCE("
						+ " (SELECT CONCAT(COUNT(voucher.voucherId), '-', SUM(voucher.voucherAmount))"
						+ " FROM AxelaAccVoucher voucher"
						+ " join voucher.axelaAccVoucherType type"
						+ " where type.vouchertypeVoucherclassId = 101 AND voucher.voucherCustomerId = customer.customerId), '')"
						+ " END) AS quotecount,"

						+ " (CASE WHEN comp.compModuleSales = 1 THEN "
						+ " COALESCE("
						+ " (SELECT CONCAT(COUNT(voucher.voucherId), '-', SUM(voucher.voucherAmount))"
						+ " FROM AxelaAccVoucher voucher"
						+ " join voucher.axelaAccVoucherType type"
						+ " where type.vouchertypeVoucherclassId = 114 AND voucher.voucherCustomerId = customer.customerId), '')"
						+ " END) AS socount,"

						+ " (CASE WHEN comp.compModuleSales = 1 THEN "
						+ " COALESCE("
						+ " (SELECT CONCAT(COUNT(voucher.voucherId), '-', SUM(voucher.voucherAmount))"
						+ " FROM AxelaAccVoucher voucher"
						+ " join voucher.axelaAccVoucherType type"
						+ " where type.vouchertypeVoucherclassId = 102 AND voucher.voucherCustomerId = customer.customerId), '')"
						+ " END) AS invoicecount, "

						+ " (CASE WHEN comp.compModuleSales = 1 THEN "
						+ " COALESCE("
						+ " (SELECT CONCAT(COUNT(voucher.voucherId), '-', SUM(voucher.voucherAmount))"
						+ " FROM AxelaAccVoucher voucher"
						+ " join voucher.axelaAccVoucherType type"
						+ " where type.vouchertypeVoucherclassId = 105 AND voucher.voucherCustomerId = customer.customerId), '')"
						+ " END) AS receiptcount, "

						+ " (CASE WHEN comp.compModuleService = 1 THEN "
						+ " COALESCE("
						+ " (SELECT COUNT(ticket.ticketId)"
						+ " FROM AxelaHelpDeskTicket ticket"
						+ " WHERE ticket.ticketCustomerId = customer.customerId), '') "
						+ " END) AS ticketcount, "

						+ " (CASE WHEN comp.compModuleService = 1 THEN "
						+ " COALESCE("
						+ " (SELECT CONCAT(COUNT(contract.contractId), '-', SUM(contract.contractGrandtotal))"
						+ " FROM AxelaServiceContract contract"
						+ " WHERE contract.contractCustomerId = customer.customerId), '')"
						+ " END) AS servicecontractcount,"

						+ " (CASE WHEN comp.compModuleSales = 1 THEN "
						+ " COALESCE("
						+ " (SELECT CONCAT(COUNT(voucher.voucherId), '-', SUM(voucher.voucherAmount))"
						+ " from AxelaAccVoucher voucher"
						+ " join voucher.axelaAccVoucherType type"
						+ " where type.vouchertypeVoucherclassId = 103 AND voucher.voucherCustomerId = customer.customerId), '')"
						+ " END) AS billcount,"

						+ " (CASE WHEN comp.compModuleAsset = 1 THEN "
						+ " COALESCE("
						+ " (SELECT CONCAT(COUNT(contract.contractId), '-', SUM(contract.contractAmt))"
						+ " FROM AxelaAssetContract contract"
						+ " WHERE contract.contractCustomerId = customer.customerId), '')"
						+ " END) AS assetcontractcount "

						+ " FROM AxelaComp comp,"
						+ " AxelaCustomer customer"
						+ " WHERE customer.customerId = " + customerId + "";

		TypedQuery<Object[]> typedQuery = em.createQuery(Query, Object[].class);
		return typedQuery.getResultList();

	}
	// customer dash end

	// customer report url
	public List<AxelaModuleReport> findModuleUrls()
	{
		List<AxelaModuleReport> typedQuery = null;
		String strSql = "SELECT NEW AxelaModuleReport("
				+ " report.reportId,"
				+ " report.reportName,"
				+ " report.reportUrl)"
				+ " FROM AxelaModuleReport report"
				+ " INNER JOIN report.axelaModule"
				+ " WHERE report.reportModuleId = 2"
				+ " AND report.reportModuledisplay = 1"
				+ " AND report.reportActive = 1"
				+ " ORDER BY report.reportRank";
		typedQuery = em.createQuery(strSql, AxelaModuleReport.class).getResultList();
		em.clear();
		return typedQuery;
	}
}
