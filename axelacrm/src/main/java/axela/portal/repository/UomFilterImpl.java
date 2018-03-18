package axela.portal.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.inventory.model.AxelaInventoryUom;

@Repository
@Transactional(readOnly = true)
public class UomFilterImpl extends Connect {
	@PersistenceContext
	EntityManager em;
	public static String totalCount = "0";
	public static int listLength = 0;
	public List<AxelaInventoryUom> findAll(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		TypedQuery<AxelaInventoryUom> typedQuery = null;

		String strSql = "SELECT NEW AxelaInventoryUom("
				+ " uom.uomId,"
				+ " uom.uomName,"
				+ " uom.uomRatio,"
				+ " uom.uomParentId,"
				+ " uom.uomShortname,"
				+ " COALESCE((SELECT uom.uomName FROM AxelaInventoryUom uom"
				+ " WHERE uom.uomId =uom.uomParentId), '') AS uomParentName)";
		sqlJoin += " FROM AxelaInventoryUom uom"
				+ " WHERE 1 = 1"
				+ strSearch;
		countSql = "SELECT COUNT(DISTINCT uom.uomId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ strSearch
					+ " GROUP BY uom.uomId "
					+ strOrderBy;
			typedQuery = em.createQuery(strSql, AxelaInventoryUom.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage);
		}
		em.close();
		return typedQuery.getResultList();
	}

	public List<AxelaInventoryUom> findAllpopulate(int uomId) {
		String sqlJoin = "";
		String countSql = "";
		TypedQuery<AxelaInventoryUom> typedQuery = null;

		String Query = "SELECT NEW AxelaInventoryUom("
				+ " uom.uomId,"
				+ " uom.uomName,"
				+ " uom.uomShortname,"
				+ " uom.uomParentId,"
				+ " uom.uomRatio,"
				+ " uom.uomEntryId,"
				+ " uom.uomEntryDate,"
				+ " uom.uomModifiedId,"
				+ " uom.uomModifiedDate)"
				+ " FROM AxelaInventoryUom uom"
				+ " WHERE uomId =" + uomId;
		typedQuery = em.createQuery(Query, AxelaInventoryUom.class);
		listLength = em.createQuery(Query, AxelaInventoryUom.class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}
}
