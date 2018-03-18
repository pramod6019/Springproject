package axela.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.inventory.model.AxelaInventoryBinItem;

public interface InventoryBinItemRepository extends JpaRepository<AxelaInventoryBinItem, Long> {

	@Query("SELECT COUNT(itemOption.binitemItemId) AS binitemItemId"
			+ "  FROM AxelaInventoryBinItem itemOption"
			+ " WHERE 1=1"
			+ " AND itemOption.binitemItemId=:binitemItemId")
	int findBybinitemItemId(@Param("binitemItemId") int binitemItemId);

	List<AxelaInventoryBinItem> findBybinitemBinId(int binitemBinId);

	public interface InventoryBinItemFilterRepository {

	}

}
