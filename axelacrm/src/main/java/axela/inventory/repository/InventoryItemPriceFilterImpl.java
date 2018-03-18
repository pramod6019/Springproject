package axela.inventory.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.inventory.model.AxelaInventoryItemPrice;
import axela.inventory.repository.InventoryItemPriceRepository.InventoryItemPriceFilter;

@Repository
@Transactional
public class InventoryItemPriceFilterImpl extends Connect implements InventoryItemPriceFilter {
	@PersistenceContext
	EntityManager em;
	public static String totalCount = "0";
	String countSql = "";

	public List<AxelaInventoryItemPrice> findAll(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		TypedQuery<AxelaInventoryItemPrice> typedQuery = null;
		List<AxelaInventoryItemPrice> result = new ArrayList<AxelaInventoryItemPrice>();
		String strSql = " SELECT NEW AxelaInventoryItemPrice( "
				+ " itemPrice.priceId,"
				+ " itemPrice.priceItemId,"
				+ " itemPrice.axelaInventoryItem.itemCode,"
				+ " itemPrice.axelaInventoryItem.itemName, "
				+ " itemPrice.axelaRateClass.rateclassName, "
				+ " itemPrice.priceDisc, "
				+ " itemPrice.priceAmt, "
				+ " itemPrice.priceActive,"
				+ " itemPrice.priceDiscType ) ";

		sqlJoin += " FROM AxelaInventoryItemPrice itemPrice "
				+ " JOIN itemPrice.axelaInventoryItem "
				+ " JOIN itemPrice.axelaRateClass "
				+ " WHERE 1=1";

		countSql = "SELECT COUNT(DISTINCT itemPrice.priceId) " + sqlJoin + strSearch;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ strSearch
					+ " GROUP BY itemPrice.priceId "
					+ strOrderBy;
			result = em.createQuery(strSql, AxelaInventoryItemPrice.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return result;
	}

	public Long findItemPriceDate(String strSearch) {
		String sqlJoin = "";
		String strOrderBy = "";
		TypedQuery<AxelaInventoryItemPrice> typedQuery = null;
		Long result = 0L;
		String strSql = "SELECT "
				+ " (COUNT(itemPrice.priceItemId)) AS countPriceItemId ";

		sqlJoin += " FROM AxelaInventoryItemPrice itemPrice "
				+ " WHERE 1=1";

		strOrderBy += " ORDER BY "
				+ " itemPrice.priceId ";

		strSql += sqlJoin
				+ strSearch;
		result = em.createQuery(strSql, Long.class).getSingleResult();
		// }
		em.close();
		return result;
	}

	public List<AxelaInventoryItemPrice> findPopulateData(int priceId) {
		String sqlJoin = "";
		String strSearch = "";
		String strOrderBy = "";
		TypedQuery<AxelaInventoryItemPrice> typedQuery = null;
		List<AxelaInventoryItemPrice> result = new ArrayList<AxelaInventoryItemPrice>();
		String strSql = " SELECT NEW AxelaInventoryItemPrice ( "
				+ " itemPrice.priceId, "
				+ " itemPrice.priceActive, "
				+ " itemPrice.priceAmt, "
				+ " itemPrice.priceDesc, "
				+ " itemPrice.priceDisc, "
				+ " itemPrice.priceDiscType, "
				+ " itemPrice.priceEffectiveFrom, "
				+ " itemPrice.priceEntryDate, "
				+ " itemPrice.priceEntryId, "
				+ " itemPrice.priceItemId, "
				+ " itemPrice.priceMargin, "
				+ " itemPrice.priceModifiedDate, "
				+ " itemPrice.priceModifiedId, "
				+ " itemPrice.priceRateclassId, "
				+ " itemPrice.priceVariable, "
				+ " rateClass.rateclassType)";

		sqlJoin += " FROM AxelaInventoryItemPrice itemPrice "
				+ " JOIN itemPrice.axelaRateClass rateClass"
				+ " WHERE 1=1";

		strSearch += " AND itemPrice.priceId= "
				+ priceId;
		strOrderBy += " ORDER BY "
				+ " itemPrice.priceId ";

		countSql = "SELECT COUNT(DISTINCT itemPrice.priceId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ strSearch;
			result = em.createQuery(strSql, AxelaInventoryItemPrice.class).getResultList();
		}
		em.close();
		return result;
	}

	public AxelaInventoryItemPrice findUpdateDetail(int priceId) {
		String sqlJoin = "";
		String strSearch = "";
		String strOrderBy = "";
		TypedQuery<AxelaInventoryItemPrice> typedQuery = null;
		AxelaInventoryItemPrice result = new AxelaInventoryItemPrice();
		String strSql = " SELECT NEW AxelaInventoryItemPrice ( "
				+ " itemPrice.priceId, "
				+ " itemPrice.priceActive, "
				+ " itemPrice.priceAmt, "
				+ " itemPrice.priceDesc, "
				+ " itemPrice.priceDisc, "
				+ " itemPrice.priceDiscType, "
				+ " itemPrice.priceEffectiveFrom, "
				+ " itemPrice.priceEntryDate, "
				+ " itemPrice.priceEntryId, "
				+ " itemPrice.priceItemId, "
				+ " itemPrice.priceMargin, "
				+ " itemPrice.priceModifiedDate, "
				+ " itemPrice.priceModifiedId, "
				+ " itemPrice.priceRateclassId, "
				+ " itemPrice.priceVariable, "
				+ " rateClass.rateclassType)";

		sqlJoin += " FROM AxelaInventoryItemPrice itemPrice "
				+ " JOIN itemPrice.axelaRateClass rateClass"
				+ " WHERE 1=1";

		strSearch += " AND itemPrice.priceId= "
				+ priceId;
		strOrderBy += " ORDER BY "
				+ " itemPrice.priceId ";

		countSql = "SELECT COUNT(DISTINCT itemPrice.priceId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ strSearch;
			result = em.createQuery(strSql, AxelaInventoryItemPrice.class).getSingleResult();
		}
		em.close();
		return result;
	}
}
