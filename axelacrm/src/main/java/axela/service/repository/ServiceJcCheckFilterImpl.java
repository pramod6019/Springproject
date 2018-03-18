package axela.service.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.service.model.AxelaServiceJcCheck;

@Repository
@Transactional(readOnly = true)
public class ServiceJcCheckFilterImpl {
	@PersistenceContext
	EntityManager em;
	public static String totalCount = "0";

	public List<AxelaServiceJcCheck> findAllJcCheck(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaServiceJcCheck> typedQuery = new ArrayList<AxelaServiceJcCheck>();

		String strSql = "SELECT NEW AxelaServiceJcCheck( jccheck.checkId, jccheck.checkName)";

		sqlJoin += " FROM AxelaServiceJcCheck jccheck"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT jccheck.checkId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY jccheck.checkId"
					+ strOrderBy;
			typedQuery = em.createQuery(strSql, AxelaServiceJcCheck.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return typedQuery;
	}
}