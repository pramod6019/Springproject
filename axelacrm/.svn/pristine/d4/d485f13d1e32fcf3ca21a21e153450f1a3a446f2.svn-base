package axela.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.inventory.model.AxelaInventoryItemOption;

public interface InventoryItemOptionsRepository extends JpaRepository<AxelaInventoryItemOption, Integer> {

	@Query("SELECT COUNT(option.optionItemId) as optionItemId"
			+ " FROM AxelaInventoryItemOption option"
			+ " WHERE 1=1"
			+ " AND option.optionItemId=:optionItemId "
			+ " AND option.optionItemmasterId=:optionItemmasterId  ")
	int optionItemDetails(@Param("optionItemId") int optionItemId, @Param("optionItemmasterId") int optionItemmasterId);

	@Query("SELECT COUNT(option.optionItemId) as optionItemId"
			+ " FROM AxelaInventoryItemOption option"
			+ " WHERE 1=1"
			+ " AND option.optionItemId=:optionItemId "
			+ " AND option.optionGroupId=:optionGroupId "
			+ " AND option.optionItemmasterId=:optionItemmasterId  ")
	int optionItemdetailBygroupId(@Param("optionItemId") int optionItemId, @Param("optionGroupId") int optionGroupId, @Param("optionItemmasterId") int optionItemmasterId);

	AxelaInventoryItemOption findByOptionId(int parseInt);

}
