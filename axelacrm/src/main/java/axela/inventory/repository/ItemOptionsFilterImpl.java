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
import axela.inventory.model.AxelaInventoryItem;
import axela.inventory.model.AxelaInventoryItemOption;
@Repository
@Transactional(readOnly = false)
public class ItemOptionsFilterImpl extends Connect {
	@PersistenceContext
	EntityManager em;
	public static String totalCount = "0";
	String countSql = "";

	public List<AxelaInventoryItemOption> findItemOptionList(String strSearch, String strOrderBy) {
		String sqlJoin = "";
		TypedQuery<AxelaInventoryItemOption> typedQuery = null;
		List<AxelaInventoryItemOption> result = new ArrayList<AxelaInventoryItemOption>();
		String strSql = "SELECT NEW AxelaInventoryItemOption("
				+ " item.itemId, "
				+ " item.itemName, "
				+ " item.itemCode, "
				+ " invgroup.groupType, "
				+ " invgroup.groupName, "
				+ " option.optionId, "
				+ " option.optionQty, "
				+ " option.optionSelect, "
				+ " option.optionValidfrom, "
				+ " option.optionValidtill ) ";
		sqlJoin += " FROM AxelaInventoryItemOption option "
				+ " INNER JOIN option.axelaInventoryItem item "// on item_id = option_item_id"
				+ " INNER JOIN option.axelaInventoryGroup invgroup "// on group_id = option_group_id"
				+ " WHERE  1=1 ";

		countSql = " SELECT COUNT(DISTINCT option.optionId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ strSearch
					+ " GROUP BY invgroup.groupName, invgroup.groupType, item.itemId"
					+ strOrderBy;
			result = em.createQuery(strSql, AxelaInventoryItemOption.class).getResultList();
		}
		em.close();
		return result;
	}

	public void updateOptionBasedOnGroupId(String strSearch, int optionSelect) {
		String sqlJoin = "";
		String countSql = "";
		Query query = null;
		String strSql = " UPDATE AxelaInventoryItemOption opt"
				+ " INNER JOIN opt.axelaInventoryGroup invgroup"// ON group_id = option_group_id"
				+ " SET "
				+ "opt.optionSelect="
				+ optionSelect
				+ " WHERE "
				+ strSearch;

		query = em.createQuery(strSql);
		int updateCount = query.executeUpdate();

	}

	public String groupTypeDetail(String strSearch) {
		String sqlJoin = "";
		TypedQuery<String> typedQuery = null;
		String result = "";
		String strSql = " SELECT "
				+ "invgroup.groupType ";

		sqlJoin += " FROM AxelaInventoryItemOption option "
				+ " INNER JOIN option.axelaInventoryGroup invgroup "// on group_id = option_group_id"
				+ " WHERE  1=1 "
				+ strSearch;

		strSql += sqlJoin
				+ strSearch;
		result = em.createQuery(strSql, String.class).getSingleResult();
		em.close();
		return result;
	}

	public List<AxelaInventoryItem> findItemDetail(String strSearch) {
		String sqlJoin = "";
		String strOrderBy = " ORDER BY item.itemName";
		TypedQuery<AxelaInventoryItem> typedQuery = null;
		List<AxelaInventoryItem> result = new ArrayList<AxelaInventoryItem>();
		String strSql = " SELECT NEW AxelaInventoryItem("
				+ " item.itemId, "
				+ " item.itemName, "
				+ " item.itemCode,"
				+ " COALESCE(catpop.catName, '') AS catName)";

		sqlJoin += "  FROM  AxelaInventoryItem item"
				+ " INNER JOIN item.axelaInventoryCatPop catpop"// on group_id = option_group_id"
				+ " WHERE  1=1 "
				+ " AND item.itemActive = 1 ";

		strSql += sqlJoin
				+ strSearch
				+ " GROUP BY item.itemId "
				+ strOrderBy;
		result = em.createQuery(strSql, AxelaInventoryItem.class).getResultList();
		em.close();
		return result;
	}
}
