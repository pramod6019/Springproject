package axela.inventory.repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.inventory.model.AxelaInventoryStock;

@Repository
@Transactional
public class InventoryStocklFilterImp extends Connect {

	@PersistenceContext
	EntityManager em;
	@Autowired
	StockRepository stockRepository;

	public Map updateQueryChecking(String Query) {
		Map output = output = new LinkedHashMap();
		int stockItemId = 0;
		int stockLocationId = 0;
		int resutantStockItemId = 0;
		SOP("updateQuery============111111111");
		String StrSql = "", itemId = "1", locationId = "1";
		SOP("updateQuery============222222");
		String subStrSql1 =
				// " SELECT "
				// + " item.itemId, "
				// + " location.locationId "
				// + " FROM "
				// + " ( "
				" SELECT "
						+ "	item.itemId, "
						+ " location.locationId"
						+ " FROM "
						+ "	AxelaInventoryItem item, "
						+ " AxelaInventoryLocation location "
						+ " LEFT JOIN item.axelaInventoryStock stock "
						+ " WHERE "
						+ "	item.itemActive = 1 "
						+ " AND item.itemStock = 1 ";
		List<Object[]> resultItemAndLocation = em.createQuery(subStrSql1).getResultList();
		for (Object[] obj : resultItemAndLocation) {
			stockItemId = (int) obj[0];
			stockLocationId = (int) obj[1];
		}
		if (stockItemId != 0 && stockLocationId != 0) {
			AxelaInventoryStock axelaInventoryStock = null;
			axelaInventoryStock = stockRepository.findOne(stockItemId);
			if (axelaInventoryStock != null) {
				// axelaInventoryStock = new AxelaInventoryStock();
				axelaInventoryStock.setStockItemId(stockItemId);
				axelaInventoryStock.setStockLocationId(stockLocationId);
				resutantStockItemId = stockRepository.save(axelaInventoryStock).getStockItemId();
			}
		}
		if (resutantStockItemId != 0) {
			output.put("successmsg", "Successfully Updated");
		} else {
			output.put("errormsg", "Resutant Stock Item(s) Are Empty");
		}

		// + " ) AS item "

		// + " CONCAT( "
		// + "	stock_item_id, "
		// + " stock_location_id "
		// + " ) = CONCAT(item_id, location_id) ";

		//
		// "SELECT item.itemId, location.locationId"
		// + " FROM AxelaInventoryItem item,AxelaInventoryLocation location"
		// + " WHERE item.itemActive = 1" + " AND item.itemStock = 1";
		SOP("updateQuery============333333");
		// List<Object[]> listSubStrSql1 = em.createQuery(subStrSql1).getResultList();
		// for (Object[] objects : listSubStrSql1) {
		// itemId = objects[0].toString();
		// locationId = objects[1].toString();
		// }

		StrSql = "INSERT INTO AxelaInventoryStock stock"
				+ " ("
				+ "	stock.stockItemId,"
				+ " stock.stockLocationId "
				// + " values "
				+ "	) VALUES ( "
				+ itemId
				+ ","
				+ locationId
				+ " )";
		// if (!itemId.equals("0")) {
		// StrSql += " AND item.itemId = " + itemId;
		// }
		StrSql += " ";// ") AS item1)";
		// + " LEFT JOIN AxelaInventoryStock stock"
		// + " ON CONCAT(stock.stockItemd," + " stock.stockLocation_id) = CONCAT(item.itemId, location.locationId)";
		return output;
	}
}
