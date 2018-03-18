package axela.service.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.service.model.AxelaServiceJcBay;

@Repository
@Transactional(readOnly = false)
public class JcBayFilterImpl {

	@PersistenceContext
	EntityManager em;
	// EntityTransaction updateoperation = null;
	public static String totalCount = "0";
	String countSql = "";

	public List<AxelaServiceJcBay> findAllJcBay(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		TypedQuery<AxelaServiceJcBay> typedQuery = null;

		String strSql = "SELECT NEW AxelaServiceJcBay("
				+ " bay.bayId,"
				+ " bay.bayBranchId,"
				+ " bay.bayName,"
				+ " bay.bayRank)";

		sqlJoin += " FROM AxelaServiceJcBay bay"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT bay.bayId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY bay.bayId "
					+ strOrderBy;
			typedQuery = em.createQuery(strSql, AxelaServiceJcBay.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage);
		}
		em.close();
		return typedQuery.getResultList();
	}
}
