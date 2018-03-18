package axela.service.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.service.model.AxelaServiceJcPriority;

@Repository
@Transactional(readOnly = false)
public class JcPriorityFilterImpl {

	@PersistenceContext
	EntityManager em;
	// EntityTransaction updateoperation = null;
	public static String totalCount = "0";
	String countSql = "";

	public List<AxelaServiceJcPriority> findAllJcPriority(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaServiceJcPriority> typedQuery = new ArrayList<AxelaServiceJcPriority>();

		String strSql = "SELECT NEW AxelaServiceJcPriority("
				+ " Priority.priorityjcId,"
				+ " Priority.priorityjcDesc,"
				+ " Priority.priorityjcName)";

		sqlJoin += " FROM AxelaServiceJcPriority Priority"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT Priority.priorityjcId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY Priority.priorityjcId "
					+ strOrderBy;
			typedQuery = em.createQuery(strSql, AxelaServiceJcPriority.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return typedQuery;
	}
}
