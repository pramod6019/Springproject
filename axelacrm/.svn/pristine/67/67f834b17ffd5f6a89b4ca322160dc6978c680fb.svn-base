package axela.inventory.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.inventory.model.AxelaInventoryCat;
import axela.inventory.repository.InventoryCatRepository.InventoryCatFilterRepository;

@Repository
@Transactional(readOnly = true)
public class InventoryCatFilterImp extends Connect implements InventoryCatFilterRepository {

	@PersistenceContext
	EntityManager em;

	public static int itemLength = 0;
	public static String totalCount = "0";
	public static int catLength = 0;

	public List<AxelaInventoryCat> findAll(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaInventoryCat> listData = new ArrayList<AxelaInventoryCat>();
		String strSql = "SELECT NEW AxelaInventoryCat("
				+ " cat.catId,"
				+ " cat.catName,"
				+ " (SELECT COUNT(item.itemId) FROM AxelaInventoryItem item WHERE cat.catId = item.itemCatId) AS itemcount)";
		sqlJoin += " FROM AxelaInventoryCat cat"
				+ " WHERE 1=1" + strSearch;
		countSql = "SELECT COUNT(DISTINCT cat.catId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY cat.catId"
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaInventoryCat.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public List<AxelaInventoryCat> findItemName(String query) {

		String Query = "SELECT NEW AxelaInventoryCat("
				+ " a.catName)"
				+ " FROM AxelaInventoryCat a"
				+ " WHERE 1=1"
				+ " " + query;
		TypedQuery<AxelaInventoryCat> typedQuery = em.createQuery(Query, AxelaInventoryCat.class);
		return typedQuery.getResultList();
	}

	public List<AxelaInventoryCat> findCategoryAssociatedwitChild(String catId) {
		String Query = "SELECT NEW AxelaInventoryCat("
				+ " cat.catId)"
				+ " FROM AxelaInventoryCat cat"
				+ " WHERE 1=1"
				+ " AND cat.catParentId!=0"
				+ " AND cat.catId=" + catId;
		TypedQuery<AxelaInventoryCat> typedQuery = em.createQuery(Query, AxelaInventoryCat.class);
		return typedQuery.getResultList();
	}

	public List<AxelaInventoryCat> UpdateCatPop(String strSearch) {
		Query query = em.createQuery(strSearch);
		em.clear();
		return query.getResultList();
	}

	public List<AxelaInventoryCat> GetCatName(String strSearch) {
		Query query = em.createQuery(strSearch);
		em.clear();
		return query.getResultList();
	}
}
