package axela.inventory.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.inventory.model.AxelaInventoryItemPrice;

public interface InventoryItemPriceRepository extends JpaRepository<AxelaInventoryItemPrice, Integer> {

	public interface InventoryItemPriceFilter {

	}

	@Transactional
	@Modifying
	@Query("DELETE FROM AxelaInventoryItemPrice itemPrice"
			+ " WHERE itemPrice.priceItemId=:priceItemId")
	public void deleteByItemId(@Param("priceItemId") int priceItemId);

	@Query("SELECT itemPrice FROM AxelaInventoryItemPrice itemPrice WHERE 1=1 AND itemPrice.priceItemId=:priceItemId")
	AxelaInventoryItemPrice findByItemId(@Param("priceItemId") int priceItemId);

	@Query("SELECT COUNT(itemPrice.priceItemId) AS optionItemId"
			+ " FROM AxelaInventoryItemPrice itemPrice"
			+ " WHERE 1=1"
			+ " AND itemPrice.priceItemId=:priceItemId")
	int findPriceDataBasedOnItemId(@Param("priceItemId") int priceItemId);

}
