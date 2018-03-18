package axela.inventory.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.inventory.model.AxelaInventoryItem;
import axela.inventory.model.AxelaInventoryLocation;
import axela.inventory.model.AxelaInventoryStock;
import axela.inventory.repository.InventoryItemRepository.InventoryFilterRepository;

@Repository
@Transactional(readOnly = true)
public class InventoryFilterImp extends Connect implements InventoryFilterRepository {

	@PersistenceContext
	EntityManager em;
	public static String totalCount = "0";
	public static int itemLength = 0;

	public static int catLength = 0;

	@Override
	public List<AxelaInventoryItem> findAllItem() {
		String str = "SELECT a FROM AxelaInventoryItem  ";
		Query query = em.createQuery("SELECT a.itemId,a.itemBigDesc FROM AxelaInventoryItem a");
		em.clear();
		return query.getResultList();
	}

	// for sales category finding active item
	public List<AxelaInventoryItem> findItemId(String strSearch) {
		Query query = em.createQuery("SELECT NEW AxelaInventoryItem("
				+ " item.itemId)"
				+ " FROM AxelaInventoryItem item"
				+ " INNER JOIN item.axelaInventorySalescatTran salescatTrans"
				+ " WHERE item.itemActive=1"
				+ " " + strSearch
				+ " ORDER BY item.itemName");
		em.clear();
		return query.getResultList();
	}

	public List<AxelaInventoryItem> findItems() {
		String Query = "SELECT NEW AxelaInventoryItem("
				+ " item.itemId,"
				+ " item.itemName)"
				+ " FROM AxelaInventoryItem item"
				+ " WHERE item.itemActive=1"
				+ " ORDER BY itemName";
		TypedQuery<AxelaInventoryItem> typedQuery = em.createQuery(Query, AxelaInventoryItem.class);
		return typedQuery.getResultList();
	}

	public List<AxelaInventoryItem> findAll(String strSearch, String strOrderBy, String StrJoin, int page, int perpage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaInventoryItem> listData = new ArrayList<AxelaInventoryItem>();
		String strSql = "SELECT NEW AxelaInventoryItem("
				+ " item.itemId,"
				+ " item.itemName,"
				+ " item.itemCode,"
				+ " item.itemImg,"
				+ " item.itemItemtypeId,"
				+ " item.itemSmallDesc,"
				+ " item.itemActive,"
				+ " item.itemEoq,"
				+ " COALESCE(item.axelaInventoryItemModel.modelName, '') AS modelName,"
				+ " COALESCE(item.axelaInventoryUom.uomName, '') AS uomName,"
				+ " COALESCE(item.axelaInventoryCat.catName, '') AS catName,"
				+ " item.axelaInventoryCat.catId)";
		sqlJoin += " FROM AxelaInventoryItem item"
				+ " LEFT JOIN item.axelaInventoryItemModel"
				+ " LEFT JOIN item.axelaInventoryUom"
				+ " JOIN item.axelaInventoryItemType"
				+ " JOIN item.axelaInventoryCat "
				+ " " + StrJoin + ""
				+ " WHERE 1=1" + strSearch;
		countSql = "SELECT COUNT(DISTINCT item.itemId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY item.itemId"
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaInventoryItem.class).setFirstResult((page - 1) * perpage).setMaxResults(perpage).getResultList();
		}
		em.close();
		return listData;
	}

	@Transactional
	public void checkStock(int itemId) {
		List<AxelaInventoryLocation> listData = new ArrayList<AxelaInventoryLocation>();
		String Query = "SELECT NEW AxelaInventoryLocation(location.locationId) FROM AxelaInventoryLocation location";
		TypedQuery<AxelaInventoryLocation> typedQuery = em.createQuery(Query, AxelaInventoryLocation.class);
		listData = typedQuery.getResultList();
		em.setFlushMode(FlushModeType.COMMIT);
		int batchSize = 30;
		int i = 1;
		for (AxelaInventoryLocation axelaInventoryLocation : listData) {
			AxelaInventoryStock axelaInventoryStock = new AxelaInventoryStock();
			axelaInventoryStock.setStockLocationId(axelaInventoryLocation.getLocationId());
			axelaInventoryStock.setStockItemId(itemId);
			em.persist(axelaInventoryStock);
			if (i % batchSize == 0 || listData.size() == i) {
				em.flush();
				em.clear();
			}
			i++;
		}
	}

}
