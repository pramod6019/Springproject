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
@Repository
@Transactional
public class InventoryReorderFilterImp extends Connect {
	@PersistenceContext
	EntityManager em;
	// EntityTransaction updateoperation = null;
	public static String totalCount = "0";
	String countSql = "";

	public List<AxelaInventoryItem> findReorderLevel(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		TypedQuery<AxelaInventoryItem> typedQuery = null;
		List<AxelaInventoryItem> result = new ArrayList<AxelaInventoryItem>();
		String strSql = " SELECT NEW AxelaInventoryItem ( "
				+ " COALESCE(location.locationBranchId, 0) AS locationBranchId, "
				+ " COALESCE(stock.stockLocationId, 0) AS stockLocationId, "
				+ " COALESCE(stock.stockItemId, 0) AS stockItemId, "
				+ " COALESCE(stock.stockCurrentQty, 0) AS stockCurrentQty, "
				+ " COALESCE(stock.stockReorderlevel, 0) AS stockReorderlevel, "
				+ " item.axelaInventoryUom.uomName, "
				+ " item.axelaInventoryCatPop.catId, "
				+ "  item.axelaInventoryCatPop.catName, "
				+ " item.itemId, "
				+ " item.itemCode, "
				+ " item.itemName ) ";

		sqlJoin += " FROM AxelaInventoryItem item "
				+ " INNER JOIN item.axelaInventoryUom "// ON uom_id = item_uom_id"
				+ " LEFT JOIN item.axelaInventoryStock  stock " // ON stock_item_id = item_id"
				+ " LEFT JOIN stock.axelaInventoryLocation  location "// ON location_id = stock_location_id"
				+ " LEFT JOIN location.axelaBranch "// ON branch_id = location_branch_id"
				+ " LEFT JOIN item.axelaInventoryCatPop "// ON cat_id = item_cat_id"
				+ " WHERE 1=1 "
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT stock.stockLocationId)" + sqlJoin;
		totalCount = CNumeric(em.createQuery(countSql).getResultList().get(0) + "");
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY "
					+ " item.axelaInventoryCatPop.catId, "
					+ " item.itemId "
					+ strOrderBy;
			result = em.createQuery(strSql, AxelaInventoryItem.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return result;
	}

	public int updateStock(String strSearch, int stockReorderlevel) {
		String sqlJoin = "";
		String countSql = "";
		Query query = null;
		String strSql = " UPDATE AxelaInventoryStock stock "
				+ " SET "
				+ " stock.stockReorderlevel = "
				+ stockReorderlevel
				+ " "
				+ strSearch;

		query = em.createQuery(strSql);
		// int updateCount = query.executeUpdate();
		return query.executeUpdate();
	}
}
