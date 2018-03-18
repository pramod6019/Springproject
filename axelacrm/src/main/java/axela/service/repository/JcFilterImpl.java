package axela.service.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.service.model.AxelaServiceJc;
import axela.service.model.AxelaServiceJcHistory;
import axela.service.repository.JCRepository.JcFilterRepository;
//
@Repository
@Transactional(readOnly = true)
public class JcFilterImpl extends Connect implements JcFilterRepository {
	public static String totalCount = "0";
	public static Long listLength = 0L;
	@PersistenceContext
	EntityManager em;
	public static int jcLength = 0;

	@Override
	public List<AxelaServiceJc> findByProperty(String Property)
	{
		Query query = em.createQuery("SELECT a FROM AxelaServiceJc a WHERE 1=1  " + Property + "");
		return (List<AxelaServiceJc>) query.getResultList();
	}

	public List<AxelaServiceJc> findAll(String strSearch, String strOrderBy, int page, int perPage, String app) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaServiceJc> listData = new ArrayList<AxelaServiceJc>();
		String strSql = "SELECT NEW AxelaServiceJc(jc.jcId,";
		if (app.equals("yes")) {

			strSql += " '',"
					+ " '',"
					+ " jc.jcTimeIn,"
					+ " '',"
					+ " '',";

		} else {
			strSql +=
					" jc.jcActive,"
							+ " jc.jcTitle,"
							+ " jc.jcTimeIn,"
							+ " jc.jcRefno,"
							+ " jc.jcCustomerVoice,";

		}
		strSql += " COALESCE(jc.axelaServicejccat.jccatName, '') AS jcCatName,"
				// + " CONCAT('JC',a.axelaBranch.branchCode,a.jcNo) AS jcNo,"
				+ " jc.jcEmpId,"
				+ " jc.jcBranchId,"
				+ " jc.jcCustomerId,"
				+ " jc.jcContactId,"
				+ " jc.axelaCustomer.customerName,"
				+ " CONCAT(jc.axelaCustomerContact.axelaTitle.titleDesc,' ',jc.axelaCustomerContact.contactFname,' ',jc.axelaCustomerContact.contactLname) AS contactName,"
				+ " jc.axelaCustomerContact.contactEmail1,"
				+ " jc.axelaCustomerContact.contactMobile1,"
				+ " jc.axelaCustomerContact.contactEmail2,"
				+ " jc.axelaCustomerContact.contactMobile2,"
				+ " jc.axelaServicejcpriority.priorityjcName,"
				+ " jc.axelaServicejcstatus.jcstatusName,"
				+ " jc.axelaItem.axelaInventoryItemModel.modelName AS jcModelName,"
				+ " jc.jcGrandtotal,"
				+ " COALESCE(jc.axelaItem.itemName, '') AS jcItemName,"
				+ " COALESCE(jc.axelaServicejcType.jctypeName, '') AS JcTypeName,"
				+ " jc.axelaBranch.branchName AS jcBranchName,"
				+ " jc.axelaEmp.empName,"
				+ " jc.axelaBranch.branchCode,"
				+ "jc.jcAuth)";
		sqlJoin += " FROM AxelaServiceJc jc"
				+ " JOIN jc.axelaItem item"
				+ " JOIN jc.axelaBranch branch"
				+ " JOIN jc.axelaEmp emp"
				+ " JOIN jc.axelaCustomer customer"
				+ " JOIN jc.axelaCustomerContact contact"
				+ " JOIN jc.axelaCustomerContact.axelaTitle"
				+ " JOIN jc.axelaItem.axelaInventoryItemModel model"
				+ " LEFT JOIN jc.axelaServicejccat cat"
				+ " LEFT JOIN jc.axelaServicejcType type"
				+ " JOIN jc.axelaServicejcpriority priority"
				+ " JOIN jc.axelaServicejcstatus status"
				+ " WHERE 1=1 " + strSearch;
		countSql = "SELECT COUNT(DISTINCT jc.jcId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY jc.jcId"
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaServiceJc.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public AxelaServiceJc findOneForDash(int jcId) {
		String Query = "SELECT NEW AxelaServiceJc("
				+ "a.jcId,"
				+ "a.jcNo,"
				+ "a.axelaBranch.branchId AS jcBranchId,"
				+ "a.jcTimeIn,"
				+ "a.jcTimeOut,"
				+ "a.jcTimeReady,"
				+ "a.jcTimePromised,"
				+ "a.jcEmpId,"
				+ "a.axelaBranch.branchName AS jcBranchName,"
				+ "a.jcTechnicianEmpId,"
				+ "a.jcRoNo,"
				+ "a.axelaItem.itemId AS jcItemId,"
				+ "a.axelaItem.itemModelId AS itemModelId,"
				+ "a.jcJctypeId,"
				+ "a.jcJccatId,"
				+ "a.axelaServiceJcBay.bayId AS jcBayId,"
				+ "a.jcLocationId,"
				+ "a.jcTitle,"
				+ "a.jcCustomerVoice,"
				+ "a.jcAdvice,"
				+ "a.jcTerms,"
				+ "a.jcInstructions,"
				+ "a.jcCustomerId,"
				+ "a.jcContactId,"
				+ "a.jcRefno,"
				+ "a.jcSerialno,"
				+ "a.jcPriorityjcId,"
				+ "a.jcNotes,"
				+ "a.jcJcstatusId,"
				+ " a.axelaCustomer.customerName,"
				+ "a.jcCritical,"
				+ " a.axelaCustomerContact.contactTitleId AS contactTitleId,"
				+ "a.axelaCustomerContact.contactFname AS contactFname,"
				+ "a.axelaCustomerContact.contactLname AS contactLname,"
				+ "a.axelaCustomerContact.contactPhone1 AS contactPhone1,"
				+ "a.axelaCustomerContact.contactMobile1 AS contactMobile1,"
				+ "a.axelaCustomerContact.contactEmail1 AS contactEmail1,"
				+ "a.axelaCustomerContact.contactAddress AS contactAddress,"
				+ "a.axelaCustomerContact.contactPin AS contactPin,"
				+ "a.axelaCustomerContact.contactCityId AS contactCityId,"
				+ "a.jcEntryId,"
				+ "a.jcEntryDate,"
				+ "a.jcModifiedId, "
				+ "a.jcModifiedDate,"
				+ "a.jcBillAddress,"
				+ "a.jcBillCity,"
				+ "a.jcBillCountry,"
				+ "a.jcBillPin,"
				+ "a.jcBillState,"
				+ "a.jcDelAddress,"
				+ "a.jcDelCity,"
				+ "a.jcDelCountry,"
				+ "a.jcDelPin,"
				+ "a.jcDelState,"
				+ "a.jcActive)"
				+ " FROM AxelaServiceJc a"
				+ " JOIN a.axelaItem"
				+ " JOIN a.axelaBranch"
				+ " JOIN a.axelaCustomer"
				+ " JOIN a.axelaCustomerContact"
				+ " LEFT JOIN a.axelaServiceJcBay"
				+ " JOIN a.axelaItem.axelaInventoryItemModel"
				+ " WHERE a.jcId= " + jcId
				+ " GROUP BY a.jcId";
		TypedQuery<AxelaServiceJc> typedQuery = em.createQuery(Query, AxelaServiceJc.class);
		return typedQuery.getSingleResult();
	}

	public AxelaServiceJc findCustomerDetails(int jcId) {
		String Query = "SELECT NEW AxelaServiceJc(";
		Query += " Jc.jcId,"
				+ " Jc.jcEntryDate,"
				+ " Jc.jcCustomerId,"
				+ " Jc.jcContactId,"
				+ " title.titleDesc,"
				+ " Jc.axelaBranch.branchName AS jcBranchName,"
				+ " Jc.axelaCustomer.customerName,"
				+ " Jc.axelaCustomerContact.contactTitleId AS contactTitleId,"
				+ " Jc.axelaCustomerContact.contactPhone1 AS contactPhone1,"
				+ " Jc.axelaCustomerContact.contactAddress AS contactAddress,"
				+ " Jc.axelaCustomerContact.contactPin AS contactPin,"
				+ " Jc.axelaCustomerContact.contactFname AS contactFname,"
				+ " Jc.axelaCustomerContact.contactLname AS contactLname,"
				+ " Jc.axelaCustomerContact.contactMobile1 AS contactMobile1,"
				+ " Jc.axelaCustomerContact.contactEmail1 AS contactEmail1,"
				+ " Jc.axelaCustomerContact.contactMobile1 AS contactMobile2,"
				+ " Jc.axelaCustomerContact.contactEmail1 AS contactEmail2)"
				+ " FROM AxelaServiceJc Jc "
				+ " JOIN Jc.axelaEmp emp"
				+ " JOIN Jc.axelaBranch branch"
				+ " JOIN Jc.axelaCustomer customer"
				+ " JOIN Jc.axelaCustomerContact contact"
				+ " JOIN contact.axelaTitle title"
				+ " WHERE Jc.jcId = " + jcId;

		TypedQuery<AxelaServiceJc> typedQuery = em.createQuery(Query, AxelaServiceJc.class);
		return typedQuery.getSingleResult();
	}
	public List<AxelaServiceJc> findCustomerDetail(int jcId) {

		String Query = "SELECT NEW AxelaServiceJc(";
		Query += " Jc.jcId,"
				+ " Jc.jcEntryDate,"
				+ " Jc.jcCustomerId,"
				+ " Jc.jcContactId,"
				+ " title.titleDesc,"
				+ " Jc.axelaBranch.branchName AS jcBranchName,"
				+ " Jc.axelaCustomer.customerName,"
				+ " Jc.axelaCustomerContact.contactTitleId AS contactTitleId,"
				+ " Jc.axelaCustomerContact.contactPhone1 AS contactPhone1,"
				+ " Jc.axelaCustomerContact.contactAddress AS contactAddress,"
				+ " Jc.axelaCustomerContact.contactPin AS contactPin,"
				+ " Jc.axelaCustomerContact.contactFname AS contactFname,"
				+ " Jc.axelaCustomerContact.contactLname AS contactLname,"
				+ " Jc.axelaCustomerContact.contactMobile1 AS contactMobile1,"
				+ " Jc.axelaCustomerContact.contactEmail1 AS contactEmail1,"
				+ " Jc.axelaCustomerContact.contactMobile1 AS contactMobile2,"
				+ " Jc.axelaCustomerContact.contactEmail1 AS contactEmail2)"
				+ " FROM AxelaServiceJc Jc "
				+ " JOIN Jc.axelaEmp emp"
				+ " JOIN Jc.axelaBranch branch"
				+ " JOIN Jc.axelaCustomer customer"
				+ " JOIN Jc.axelaCustomerContact contact"
				+ " JOIN contact.axelaTitle title"
				+ " WHERE Jc.jcId = " + jcId;

		TypedQuery<AxelaServiceJc> typedQuery = em.createQuery(Query, AxelaServiceJc.class);
		jcLength = em.createQuery(Query, AxelaServiceJc.class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}
	public List findJcCheckList(int jcItemId, int jcId) {
		String Query = "SELECT check.checkId,"
				+ " check.checkName,"
				+ " check.checkType,"
				+ " (SELECT COUNT(check2.checkId)"
				+ " FROM AxelaServiceJcCheck check2"
				+ " WHERE check2.checkItemId =" + jcItemId + ""
				+ " AND check2.checkType = 1) AS count,"
				+ " COALESCE((SELECT CASE WHEN trans1.transJcId > 0 THEN 1 ELSE 0 END "
				+ " FROM AxelaServiceJcCheckTran trans1"
				+ " JOIN trans1.axelaServiceJcCheck"
				+ " WHERE trans1.transJcId =" + jcId + " ),0) AS checked"
				+ " FROM AxelaServiceJcCheck check"
				+ " WHERE check.checkItemId=" + jcItemId
				+ " AND check.checkType = 2"
				+ " GROUP BY check.checkId"
				+ " ORDER BY check.checkName";
		List typedQuery = em.createQuery(Query).getResultList();
		return typedQuery;
	}

	public List findPSFList(int jcId, String strSearch) {
		String Query = "SELECT customer.customerId,"
				+ " customer.customerName,"
				+ " contact.contactId,"
				+ " title.titleDesc,"
				+ " contact.contactFname,"
				+ " contact.contactLname,"
				+ " contact.contactMobile1,"
				+ " item.itemName"
				+ " FROM AxelaServiceJcPsf jcpsf "
				+ " JOIN jcpsf.axelaServiceJc jc"
				+ " JOIN jc.axelaItem item"
				+ " JOIN jc.axelaCustomer customer"
				+ " JOIN jc.axelaCustomerContact contact"
				+ " JOIN contact.axelaTitle title"
				+ " WHERE 1=1"
				+ " AND jcpsf.jcpsfJcId=" + jcId + strSearch
				+ " GROUP BY customer.customerId";
		List typedQuery = em.createQuery(Query).getResultList();
		return typedQuery;
	}
	public List<AxelaServiceJcHistory> findHistory(int jcId, String strSearch) {
		String sqlJoin = "";
		String countSql = "";
		String strOrderBy = "";

		List<AxelaServiceJcHistory> listData = new ArrayList<AxelaServiceJcHistory>();

		String strSql = "SELECT NEW AxelaServiceJcHistory( "
				+ " history.historyId,"
				+ " history.historyActiontype, "
				+ " history.historyDatetime, "
				+ " history.historyEmpId, "
				+ " history.historyJcId , "
				+ " history.historyNewvalue, "
				+ " history.axelaEmp.empName, "
				+ " history.axelaEmp.empRefNo, "
				+ " history.axelaEmp.empId, "
				+ " serviceJc.jcTitle ";

		sqlJoin += " ) FROM AxelaServiceJcHistory  history "
				+ " JOIN history.axelaServiceJc serviceJc"
				+ " JOIN serviceJc.axelaBranch "
				+ " JOIN history.axelaEmp"
				+ " WHERE 1=1 "
				+ strSearch;
		// StrSql = "select axela_service_jc_history.*, concat(emp_name,' (',emp_ref_no,')') as emp_name, emp_id, jc_title "
		// + " from " + compdb(comp_id) + "axela_service_jc_history "
		// + " inner join " + compdb(comp_id) + "axela_service_jc on jc_id = history_jc_id "
		// + " inner join " + compdb(comp_id) + "axela_branch on branch_id = jc_branch_id "
		// + " inner join " + compdb(comp_id) + "axela_emp on emp_id = history_emp_id "
		// + " where history_jc_id=" + jc_id + BranchAccess + ExeAccess + ""
		// + " order by history_id desc";
		strSql += sqlJoin
				+ " GROUP BY history.historyId "
				+ strOrderBy;
		listData = em.createQuery(strSql, AxelaServiceJcHistory.class).getResultList();;// .setFirstResult((page - 1) * perPage).setMaxResults(perPage);

		em.close();
		return listData;
	}
}
