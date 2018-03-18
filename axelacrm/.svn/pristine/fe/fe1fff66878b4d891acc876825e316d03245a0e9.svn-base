package axela.inventory.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.inventory.model.AxelaInventoryBinItem;
import axela.inventory.repository.InventoryBinItemRepository.InventoryBinItemFilterRepository;

@Repository
@Transactional(readOnly = true)
public class InventoryBinItemFilterImp extends Connect implements InventoryBinItemFilterRepository {

	@PersistenceContext
	EntityManager em;
	public static String totalCount = "0";
	public static int binItemLength = 0;
	public static int targetLength = 0;

	public List<AxelaInventoryBinItem> findAll(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaInventoryBinItem> listData = new ArrayList<AxelaInventoryBinItem>();
		String strSql = "SELECT NEW AxelaInventoryBinItem("
				+ " binItem.binitemId,"
				+ " binItem.binitemBinId,"
				+ " binItem.axelaInventoryBinPop.binName,"
				+ " binItem.axelaInventoryBinPop.binId,"
				+ " binItem.binitemItemId,"
				+ " binItem.axelaInventoryItem.itemId,"
				+ " binItem.axelaInventoryItem.axelaInventoryItemModel.modelId,"
				+ " binItem.axelaInventoryItem.axelaInventoryItemModel.modelName,"
				+ " binItem.axelaInventoryItem.itemName,"
				+ " binItem.axelaInventoryItem.itemCode)";
		sqlJoin += " FROM AxelaInventoryBinItem binItem"
				+ " WHERE 1=1" + strSearch;
		countSql = "SELECT COUNT(DISTINCT binItem.binitemBinId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY binItem.binitemBinId"
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaInventoryBinItem.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public List<AxelaInventoryBinItem> findPopulateDataBinItem(int binitemBinId, String strSearch) {
		String sqlJoin = "";
		String countSql = "";
		String strOrderBy = " ORDER BY binItem.binitemBinId ";
		List<AxelaInventoryBinItem> listData = new ArrayList<AxelaInventoryBinItem>();
		String strSql = "SELECT NEW AxelaInventoryBinItem ( "
				+ " binPop.binName, "
				+ " item.itemId, "
				+ " model.modelId, "
				+ " item.itemName, "
				+ " item.itemCode, "
				+ " branch.branchId, "
				+ " branch.branchCode, "
				+ " branch.branchName, "
				+ " location.locationId,"
				+ " location.locationCode,"
				+ " location.locationName,"
				+ " binItem.binitemId,"
				+ " binItem.binitemBinId,"
				+ " binItem.binitemItemId ) ";

		sqlJoin += " FROM AxelaInventoryBinItem binItem "
				+ " INNER JOIN binItem.axelaInventoryItem item "
				+ " INNER JOIN item.axelaInventoryItemModel model"
				+ " INNER JOIN binItem.axelaInventoryBinPop binPop "
				+ " INNER JOIN binPop.axelaInventoryLocation location "
				+ " INNER JOIN location.axelaBranch branch"
				+ " WHERE 1=1 AND "
				+ " binItem.binitemBinId= "
				+ binitemBinId
				+ strSearch;
		countSql = "SELECT COUNT(DISTINCT binItem.binitemBinId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY binItem.binitemBinId "
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaInventoryBinItem.class).getResultList();
		}
		em.close();
		return listData;
	}

	public Long getItemDetail(String strSearch) {
		String sqlJoin = "";
		String countSql = "";
		String strSql = "SELECT "
				+ "  COUNT(binItem.binitemItemId)AS binitemItemId ";

		sqlJoin += " FROM AxelaInventoryBinItem binItem "
				+ " WHERE 1=1  "
				+ strSearch;

		strSql += sqlJoin;
		Long binItem = em.createQuery(strSql, Long.class).getSingleResult();
		em.close();
		return binItem;

	}

	public List<AxelaInventoryBinItem> findBinDetail(int binitemBinId) {
		String sqlJoin = "";
		String countSql = "";
		String strOrderBy = " ORDER BY binItem.binitemBinId ";
		List<AxelaInventoryBinItem> listData = new ArrayList<AxelaInventoryBinItem>();
		String strSql = "SELECT NEW AxelaInventoryBinItem ( "
				+ " binPop.binName, "
				+ " branch.branchCode, "
				+ " branch.branchName, "
				+ " location.locationCode,"
				+ " location.locationName)";

		sqlJoin += " FROM AxelaInventoryBinItem binItem "
				+ " INNER JOIN binItem.axelaInventoryItem item "
				+ " INNER JOIN item.axelaInventoryItemModel model"
				+ " INNER JOIN binItem.axelaInventoryBinPop binPop "
				+ " INNER JOIN binPop.axelaInventoryLocation location "
				+ " INNER JOIN location.axelaBranch branch"
				+ " WHERE 1=1 AND "
				+ " binItem.binitemBinId= "
				+ binitemBinId;
		strSql += sqlJoin
				+ " GROUP BY binItem.binitemBinId "
				+ strOrderBy;
		listData = em.createQuery(strSql, AxelaInventoryBinItem.class).getResultList();
		em.close();
		return listData;
	}
}