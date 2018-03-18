package axela.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.inventory.model.AxelaInventoryItemOption;

public interface InventoryItemOptionRepository extends JpaRepository<AxelaInventoryItemOption, Integer> {
	@Query("SELECT COUNT(itemOption.optionItemId) AS optionItemId "
			+ " FROM AxelaInventoryItemOption itemOption"
			+ " WHERE 1=1"
			+ " AND itemOption.optionItemId=:optionItemId")
	int findByOptionItemId(@Param("optionItemId") int optionItemId);

}
