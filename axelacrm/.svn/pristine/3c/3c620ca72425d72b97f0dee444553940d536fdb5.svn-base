package axela.inventory.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaTax;
@Repository
public class InventoryTaxFilterImpl {
	@PersistenceContext
	EntityManager em;
	// EntityTransaction updateoperation = null;
	public static String totalCount = "0";
	String countSql = "";

	public List<AxelaTax> findTax(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		TypedQuery<AxelaTax> typedQuery = null;

		String strSql = "SELECT NEW AxelaTax("
				+ " tax.taxId, "
				+ " tax.taxName, "
				+ " tax.taxValue )";

		sqlJoin += " FROM AxelaTax tax"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT tax.taxId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY tax.taxId "
					+ strOrderBy;
			typedQuery = em.createQuery(strSql, AxelaTax.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage);
		}
		em.close();
		return typedQuery.getResultList();
	}
}
