package axela.inventory.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import axela.config.Connect;
import axela.inventory.model.AxelaInventoryItem;
@Repository
@Transactional
public class ReportCurrentStockImpl extends Connect {
	@PersistenceContext
	EntityManager em;

	public List<AxelaInventoryItem> reportCurrentStockDetail(String strSearch, String strOrderBy, int page, int perpage) {

		String sqlJoin = "";
		List<AxelaInventoryItem> reportResult = new ArrayList<AxelaInventoryItem>();
		String strSql = " SELECT NEW AxelaInventoryItem ( "
				+ " stock.stockStockinorder, "
				+ " stock.stockStockindemand, "
				+ " stock.stockUnitCost, "
				+ " stock.stockOnhandvalue, "
				+ " loc.locationName, "
				+ " stock.stockCurrentQty, "
				+ " stock.stockReorderlevel, "
				+ " uom.uomName, "
				+ " item.itemId, "
				+ " item.itemCode, "
				+ " item.itemEoq, "
				+ " item.itemName ) ";

		sqlJoin += " FROM  AxelaInventoryItem item "
				+ " INNER JOIN item.axelaInventoryCat pop "// ON cat_id = item_cat_id"
				+ " INNER JOIN item.axelaInventoryUom uom"// ON item_uom_id = uom_id"
				+ " INNER JOIN item.axelaInventoryStock stock"// ON stock_item_id = item_id"
				+ " INNER JOIN stock.axelaInventoryLocation loc"// ON stock_location_id = location_id"
				+ " INNER JOIN loc.axelaBranch branch"// ON branch_id = location_branch_id"
				+ " WHERE item.itemActive = 1 ";

		strSql += sqlJoin
				+ strSearch + " "
				+ " GROUP BY item.itemId"
				+ strOrderBy;
		// SOP("strSql==reportCurrentStockDetail==" + strSql);
		reportResult = em.createQuery(strSql, AxelaInventoryItem.class).setFirstResult((page - 1) * perpage).setMaxResults(perpage).getResultList();
		em.close();
		return reportResult;

	}
}
