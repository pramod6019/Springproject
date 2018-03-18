package axela.sales.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import axela.sales.model.AxelaSalesOppr;
import axela.sales.model.AxelaSalesOpprHistory;
import axela.sales.repository.OpprRepository.OpprDashRepository;

@Repository
public class OpprFilterImpl implements OpprDashRepository {

	public static String totalCount = "0";

	@PersistenceContext
	EntityManager em;

	public List<AxelaSalesOppr> findAll(String strSearch, String strOrderBy, int page, int perPage, String app) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaSalesOppr> listData = new ArrayList<AxelaSalesOppr>();
		String strSql = "SELECT NEW AxelaSalesOppr("
				+ " oppr.opprEmpId,"
				+ " oppr.opprId,"
				+ " oppr.axelaEmp.empName,"
				+ " COALESCE(oppr.axelaInventoryItem.itemName, '') AS itemName,"
				+ " oppr.axelaSalesOpprStatus.statusName,"
				+ " COALESCE(oppr.axelaSalesOpprStage.stageName, '') AS opprStageName,"
				+ " oppr.opprDate,"
				+ " CONCAT(oppr.axelaCustomerContact.axelaTitle.titleDesc, '', oppr.axelaCustomerContact.contactFname, '', oppr.axelaCustomerContact.contactLname) AS contactName,"
				+ " COALESCE(oppr.axelaCustomerContact.contactMobile1, '') AS contactMobile1,"
				+ " COALESCE(oppr.axelaCustomerContact.contactMobile2, '') AS contactMobile2,"
				+ " COALESCE(oppr.axelaCustomerContact.contactPhone1, '') AS contactPhone1,"
				+ " COALESCE(oppr.axelaCustomerContact.contactPhone2, '') AS contactPhone2,"
				+ " COALESCE(oppr.axelaCustomerContact.contactEmail2, '') AS contactEmail2,"
				+ " COALESCE(oppr.axelaCustomerContact.contactEmail1, '') AS contactEmail1,";
		if (app.equals("yes")) {
			strSql += " '',"
					+ " 0,"
					+ " 0,"
					+ " oppr.opprCloseDate,"
					+ " '',"
					+ " '',"
					+ " 0,"
					+ " 0,"
					+ " '',"
					+ " '',"
					+ " '',"
					+ " 0)";
		} else {
			strSql += " oppr.axelaBranch.branchCode,"
					+ " oppr.opprNo,"
					+ " oppr.opprBranchId,"
					+ " oppr.opprCloseDate,"
					+ " oppr.opprTitle,"
					+ " oppr.opprDesc,"
					+ " oppr.opprItemId,"
					+ " oppr.opprCustomerId,"
					+ " COALESCE(oppr.axelaCustomer.customerName, '') AS customerName,"
					+ " oppr.axelaBranch.branchName,"
					+ " oppr.opprRefno,"
					+ " oppr.opprContactId)";
		}
		sqlJoin += " FROM AxelaSalesOppr oppr"
				+ " JOIN oppr.axelaBranch branch"
				+ " JOIN oppr.axelaSalesOpprStatus status"
				+ " JOIN oppr.axelaSalesOpprStage stage"
				+ " JOIN oppr.axelaCustomer customer"
				+ " JOIN oppr.axelaCustomerContact.axelaTitle contact"
				+ " JOIN oppr.axelaEmp emp"
				+ " LEFT JOIN oppr.axelaInventoryItem item"
				+ " WHERE 1=1"
				+ strSearch;
		countSql = "SELECT COUNT(DISTINCT oppr.opprId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY oppr.opprId"
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaSalesOppr.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
			// listData = typedQuery.getResultList();
		}
		em.close();
		return listData;
	}

	public AxelaSalesOppr findOne(int opprId) {
		String Query = "SELECT NEW AxelaSalesOppr("
				+ " a.opprPmId,"
				+ " a.opprCampaignId,"
				+ " a.opprCustomerId,"
				+ " a.opprProjectId,"
				+ " a.opprStatusDesc,"
				+ " a.opprAvpresent,"
				+ " a.opprManagerAssist,"
				+ " a.opprContactId,"
				+ " a.opprEmpId,"
				+ " a.opprLostcase1Id,"
				+ " a.opprLostcase2Id,"
				+ " a.opprLostcase3Id,"
				+ " a.opprNotes,"
				+ " a.opprPriorityopprId,"
				+ " a.opprStatusId,"
				+ " a.opprStageId,"
				+ " a.opprDesc,"
				+ " a.opprId,"
				+ " a.opprModelId,"
				+ " a.opprDate,"
				+ " a.opprCloseDate,"
				+ " a.opprTeamId,"
				+ " a.opprItemId,"
				+ " a.opprSoeId,"
				+ " a.opprSobId,"
				+ " a.opprBranchId,"
				+ " a.axelaSalesOpprType.opprtypeName,"
				+ " a.opprTitle,"
				+ " a.axelaCustomer.customerName,"
				+ " a.axelaCustomerContact.contactTitleId,"
				+ " a.axelaCustomerContact.contactFname,"
				+ " a.axelaCustomerContact.contactLname,"
				+ " a.axelaCustomerContact.contactMobile1,"
				+ " a.axelaCustomerContact.contactMobile2,"
				+ " a.axelaCustomerContact.contactPhone1,"
				+ " a.axelaCustomerContact.contactPhone2,"
				+ " a.axelaCustomerContact.contactEmail1,"
				+ " a.axelaCustomerContact.contactEmail2,"
				+ " a.axelaCustomerContact.contactAddress,"
				+ " a.axelaCustomerContact.contactCityId,"
				+ " a.axelaCustomerContact.contactPin,"
				+ " a.axelaBranch.branchName,"
				+ " a.axelaBranch.branchCode,"
				+ " a.opprEntryId,"
				+ " a.opprEntryDate,"
				+ " a.opprModifiedId,"
				+ " a.opprModifiedDate)"
				+ " FROM AxelaSalesOppr a"
				+ " JOIN a.axelaCustomer "
				+ " JOIN a.axelaCustomerContact "
				+ " JOIN a.axelaEmp"
				+ " LEFT JOIN a.axelaSalesOpprType "
				+ " JOIN a.axelaBranch "
				+ " WHERE a.opprId= " + opprId
				+ " GROUP BY a.opprId";
		// SOP("StrSql in PopulateFields======" + Query);
		TypedQuery<AxelaSalesOppr> typedQuery = em.createQuery(Query, AxelaSalesOppr.class);
		return typedQuery.getSingleResult();
	}

	public List<AxelaSalesOpprHistory> findHistory(int opprId) {
		String strSearch = "";
		String sqlJoin = "";
		String countSql = "";
		String Query = "SELECT NEW AxelaSalesOpprHistory(";
		Query += " a.historyId,"
				+ " a.historyActiontype,"
				+ " a.historyDatetime,"
				+ " a.historyEmpId,"
				+ " a.historyNewvalue,"
				+ " a.historyOldvalue,"
				+ " a.historyOpprId,"
				+ " a.axelaSalesOppr.opprTitle,"
				+ " a.axelaEmp.empId,"
				+ " a.axelaEmp.empRefNo,"
				+ " a.axelaEmp.empName "
				+ " )";
		sqlJoin = " FROM AxelaSalesOpprHistory a "
				+ " JOIN a.axelaSalesOppr b "
				+ " JOIN b.axelaBranch "
				+ " JOIN a.axelaEmp  "
				+ " WHERE a.historyOpprId =" + opprId
				+ strSearch;
		countSql = "SELECT COUNT(a.historyId) ";
		TypedQuery<AxelaSalesOpprHistory> typedQuery = em.createQuery(Query, AxelaSalesOpprHistory.class);
		totalCount = (Long) em.createQuery(countSql + sqlJoin).getResultList().get(0) + "";
		// listLength = em.createQuery(Query, AxelaSalesOpprHistory.class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}

	public List<AxelaSalesOppr> findCustomerDetail(int opprId) {
		String Query = "SELECT NEW AxelaSalesOppr(";
		String sqlJoin = "";
		String countSql = "";
		Query += "  a.opprContactId,"
				+ " a.axelaCustomer.customerId,"
				+ " a.axelaCustomer.customerName,"
				+ " a.axelaCustomer.customerAddress1,"
				+ " a.axelaCustomer.customerAddress2,"
				+ " a.axelaCustomer.customerLandmark,"
				+ " a.axelaCustomer.customerMobile1,"
				+ " a.axelaCustomer.customerMobile2,"
				+ " a.axelaCustomer.customerSince,"
				+ " a.axelaCustomer.customerActive,"
				+ " a.axelaCustomer.customerNotes,"
				+ " b.axelaBranch.branchName"
				+ " ) ";
		sqlJoin = "FROM AxelaSalesOppr a "
				+ " JOIN a.axelaCustomer b "
				+ " JOIN b.axelaBranch "
				+ " WHERE a.opprId = " + opprId;
		countSql = "SELECT COUNT(a.opprContactId) ";
		TypedQuery<AxelaSalesOppr> typedQuery = em.createQuery(Query, AxelaSalesOppr.class);
		totalCount = (Long) em.createQuery(countSql + sqlJoin).getResultList().get(0) + "";
		// listLength = em.createQuery(Query, AxelaSalesOppr.class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}

	public List<AxelaSalesOppr> findContact(int customerId) {
		String Query = "SELECT NEW AxelaSalesOppr(";
		String sqlJoin = "";
		String countSql = "";
		Query += "  a.axelaCustomerContact.axelaTitle.titleDesc,"
				+ " a.axelaCustomerContact.contactId ,"
				+ " a.axelaCustomerContact.contactMobile1,"
				+ " a.axelaCustomerContact.contactMobile2,"
				+ " a.axelaCustomerContact.contactEmail1,"
				+ " a.axelaCustomerContact.contactEmail2,"
				+ " a.axelaCustomerContact.contactFname,"
				+ " a.axelaCustomerContact.contactLname,"
				+ " a.axelaCustomerContact.contactAddress "
				+ " "
				// int contactId,
				// String contactMobile1,
				// String contactMobile2,
				// String contactEmail1,
				// String contactEmail2,
				// String contactFname,
				// String contactLname,
				// String contactAddress
				+ " )";
		sqlJoin = " FROM AxelaSalesOppr a "
				// + " JOIN a.axelaCustomer  "
				+ " JOIN a.axelaCustomerContact "
				+ " WHERE a.axelaCustomerContact.contactCustomerId = " + customerId;
		countSql = "SELECT COUNT(a.contactId) ";
		TypedQuery<AxelaSalesOppr> typedQuery = em.createQuery(Query, AxelaSalesOppr.class);
		totalCount = (Long) em.createQuery(countSql + sqlJoin).getResultList().get(0) + "";
		// listLength = em.createQuery(Query, AxelaSalesOppr.class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}

	public List<Object[]> findOpprLandingDetails(String StrSearch) {

		String strSql = " SELECT branch.branchId,"
				+ " CONCAT(branch.branchName,' (', branch.branchCode, ')') as branchName, "
				+ " COUNT(oppr.opprId) AS opprCount "
				+ " FROM  AxelaSalesOppr oppr"
				+ " JOIN oppr.axelaBranch branch"
				+ " where 1=1 "
				+ StrSearch
				+ " GROUP BY branch.branchId"
				+ " ORDER BY branch.branchName";
		List<Object[]> list = em.createQuery(strSql, Object[].class).getResultList();
		em.clear();
		return list;
	}
}
