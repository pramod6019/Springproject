package axela.service.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.service.model.AxelaServiceJcStatus;

@Repository
@Transactional(readOnly = false)
public class JcStatusFilterImpl {

	@PersistenceContext
	EntityManager em;
	// EntityTransaction updateoperation = null;
	public static String totalCount = "0";
	String countSql = "";

	public List<AxelaServiceJcStatus> findAllJcStatus(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaServiceJcStatus> typedQuery = new ArrayList<AxelaServiceJcStatus>();

		String strSql = "SELECT NEW AxelaServiceJcStatus("
				+ " status.jcstatusId,"
				+ " status.jcstatusName)";

		sqlJoin += " FROM AxelaServiceJcStatus status"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT status.jcstatusId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY status.jcstatusId "
					+ strOrderBy;
			typedQuery = em.createQuery(strSql, AxelaServiceJcStatus.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return typedQuery;
	}

}
