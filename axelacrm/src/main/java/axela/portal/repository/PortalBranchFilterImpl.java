package axela.portal.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.portal.model.AxelaBranch;
@Repository
@Transactional(readOnly = true)
public class PortalBranchFilterImpl extends Connect {
	@PersistenceContext
	EntityManager em;
	public static String totalCount = "0";
	public static Long listLength = 0L;
	// public int length(String branchAccess, String exeAccess, String sort, String field) {
	// Query query = em.createQuery("SELECT a FROM AxelaBranch a WHERE 1=1 AND a.branchId !='0'" + branchAccess + exeAccess + " ORDER BY a." + field + " " + sort);
	// em.clear();
	// return (int) query.getResultList().size();
	// }

	public List<AxelaBranch> findAll(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaBranch> listData = new ArrayList<AxelaBranch>();
		String strSql = "SELECT NEW AxelaBranch("
				+ " branch.branchId,"
				+ " branch.branchName,"
				+ " branch.branchActive,"
				+ " franchiseeType.franchiseetypeId,"
				+ " branch.branchEmail1,"
				+ " branch.branchEmail2,"
				+ " branch.branchPhone1,"
				+ " branch.branchPhone2,"
				+ " branch.branchMobile1,"
				+ " branch.branchMobile2,"
				+ " rateClass.rateclassName,"
				+ " branch.branchAdd,"
				+ " city.cityName,"
				+ " branch.branchPin,"
				+ " branch.branchPanNo,"
				+ " branch.branchTanNo,"
				+ " branch.branchTinNo,"
				+ " branch.branchServiceTaxNo,"
				+ " branch.branchCode,"
				+ " franchisee.franchiseeName,"
				+ "franchisee.franchiseeId,"
				+ " branch.branchNotes)";
		sqlJoin += " FROM AxelaBranch branch"
				+ " INNER JOIN branch.axelaFranchisee franchisee"
				+ " INNER JOIN franchisee.axelaFranchiseeType franchiseeType "
				+ " INNER JOIN branch.axelaRateClass rateClass "
				+ " INNER JOIN branch.axelaCity city"
				+ " LEFT  JOIN branch.axelaBranchType branchType "
				+ " WHERE 1 = 1"
				+ " AND branch.branchId !='0' " + strSearch;
		countSql = "SELECT COUNT(DISTINCT branch.branchId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY branch.branchId"
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaBranch.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

}
