package axela.inventory.repository;

import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import axela.config.Connect;
import axela.inventory.model.AxelaInventoryItem;
import axela.service.model.AxelaModuleReport;
@Repository
public class InventoryIndexImpl extends Connect {
	@PersistenceContext
	EntityManager em;
	public List<AxelaModuleReport> findInventoryListReport() {
		String sqlJoin = "";
		String countSql = "";
		String strOrderBy = "";
		String strSearch = "";
		TypedQuery<AxelaModuleReport> typedQuery = null;

		String strSql = " SELECT NEW AxelaModuleReport ( "
				+ " report.reportName, "
				+ " report.reportUrl )";
		strSearch += " WHERE 1=1 "
				+ " AND report.reportModuleId = 9 "
				+ " AND report.reportModuledisplay = 1 "
				+ " AND report.reportActive = 1";

		sqlJoin += " FROM AxelaModuleReport report"
				+ " INNER JOIN report.axelaModule "
				+ strSearch;

		strOrderBy += " ORDER BY report.reportRank";

		strSql += sqlJoin
				+ " GROUP BY report.reportId "
				+ strOrderBy;
		typedQuery = em.createQuery(strSql, AxelaModuleReport.class);
		em.close();
		return typedQuery.getResultList();
	}

	public List<AxelaInventoryItem> findPriceBookReport(String strSearch, String strOrderBy, HttpSession session, String compId, String rateclassId, String itemId) throws ParseException {
		String sqlJoin = "";
		String countSql = "";
		TypedQuery<AxelaInventoryItem> typedQuery = null;

		String strSql = " SELECT NEW AxelaInventoryItem ( "
				+ " price.axelaRateClass.rateclassId, "
				+ " price.axelaRateClass.rateclassName, "
				+ " price.priceAmt, "
				+ " price.priceItemId,"
				+ " price.priceVariable, "// IF(price.priceVariable = 1, 'Yes', 'No') AS
				+ " price.priceDisc, "
				+ " price.priceDiscType, "
				+ " item.axelaInventoryUom.uomShortname, "
				+ " price.priceEffectiveFrom, "
				+ " price.priceDesc, "
				+ " price.priceRateclassId, "
				+ " item.itemId, "
				+ " item.itemCode, "
				+ " item.itemName, "
				+ " COALESCE(tax1.customerRate, 0) AS taxRate1, "
				+ " COALESCE(tax2.customerRate, 0) AS taxRate2, "
				+ " COALESCE(tax3.customerRate, 0) AS taxRate3 ) ";
		strSearch += " WHERE 1=1 "
				+ " AND price.priceItemId = " + itemId
				+ " AND price.priceRateclassId = " + rateclassId + ""
				+ " AND price.priceEffectiveFrom <= '" + dateToString(getTimeByZone(session)) + "'"// (compId, toLongDate(kknow())) + ""
				+ " AND price.priceAmt != 0 "
				+ " AND price.priceActive = 1 ";

		sqlJoin += " FROM AxelaInventoryItem item "
				+ " INNER JOIN item.axelaInventoryCatPop "
				+ " INNER JOIN item.axelaInventoryItemPrice price"
				+ " INNER JOIN price.axelaRateClass "
				+ " INNER JOIN item.axelaInventoryUom "
				+ " INNER JOIN item.axelaInventoryStock "
				+ " LEFT JOIN price.axelaCustomer tax1 "// ON tax1.customer_id = price_tax1_id"
				+ " LEFT JOIN price.axelaCustomer2 tax2 "// ON tax2.customer_id = price_tax2_id"
				+ " LEFT JOIN price.axelaCustomer3 tax3 "// ON tax3.customer_id = price_tax3_id"
				+ " LEFT JOIN item.axelaInventoryItemModel "
				+ strSearch;

		strOrderBy += " ORDER BY price.priceEffectiveFrom,item.itemName";

		strSql += sqlJoin
				+ " GROUP BY item.itemId "
				+ strOrderBy;
		typedQuery = em.createQuery(strSql, AxelaInventoryItem.class);
		em.close();
		return typedQuery.getResultList();

	}
}
