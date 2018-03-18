package axela.service.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.service.model.AxelaServiceContractPriority;

@Repository
@Transactional(readOnly = true)
public class ContractPriorityFilterImpl {

	@PersistenceContext
	EntityManager em;
	// EntityTransaction updateoperation = null;
	public static String totalCount = "0";
	String countSql = "";

	public List<AxelaServiceContractPriority> findAllContractPriority(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaServiceContractPriority> typedQuery = new ArrayList<AxelaServiceContractPriority>();

		String strSql = "SELECT NEW AxelaServiceContractPriority("
				+ " Priority.contractpriorityId,"
				+ " Priority.contractpriorityBusinessHrs,"
				+ " Priority.contractpriorityDesc,"
				+ " Priority.contractpriorityDuehrs,"
				+ " Priority.contractpriorityEntryDate,"
				+ " Priority.contractpriorityEntryId,"
				+ " Priority.contractpriorityModifiedDate,"
				+ " Priority.contractpriorityModifiedId,"
				+ " Priority.contractpriorityName,"
				+ " Priority.contractpriorityRank,"
				+ " Priority.contractpriorityTrigger1Hrs,"
				+ " Priority.contractpriorityTrigger2Hrs,"
				+ " Priority.contractpriorityTrigger3Hrs,"
				+ " Priority.contractpriorityTrigger4Hrs,"
				+ " Priority.contractpriorityTrigger5Hrs )";

		sqlJoin += " FROM AxelaServiceContractPriority Priority"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT Priority.contractpriorityId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY Priority.contractpriorityId "
					+ strOrderBy;
			typedQuery = em.createQuery(strSql, AxelaServiceContractPriority.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return typedQuery;
	}
}
