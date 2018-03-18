package axela.service.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.service.model.AxelaServiceJcBay;

@Repository
@Transactional(readOnly = true)
public class ServiceJcBayFilterImpl {
	@PersistenceContext
	EntityManager em;
	public static int manHoursLength = 0;
	public static String totalCount = "0";
	String countSql = "";

	public List<AxelaServiceJcBay> findAll(String jcId, String baytransEmpId, String StrSearch) {
		String Query = "SELECT NEW AxelaServiceJcBay(";
		Query += " bay.bayId,"
				+ " bay.bayName,"
				+ " trans.baytransStartTime,"
				+ " trans.baytransEndTime,"
				+ " emp.empId,"
				+ " CONCAT (emp.empName, ' (', emp.empRefNo, ')') AS empName)"
				+ " FROM  AxelaServiceJcBay bay"
				+ " INNER JOIN bay.axelaServiceJcBayTran trans"
				+ " INNER JOIN trans.axelaEmp emp"
				+ " WHERE trans.baytransJcId =" + jcId + StrSearch + ""
				+ " ORDER BY trans.baytransStartTime";
		TypedQuery<AxelaServiceJcBay> typedQuery = em.createQuery(Query, AxelaServiceJcBay.class);
		manHoursLength = em.createQuery(Query, AxelaServiceJcBay.class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}

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