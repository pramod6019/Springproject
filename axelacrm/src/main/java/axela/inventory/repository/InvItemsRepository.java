package axela.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.inventory.model.AxelaInventoryItemModel;

@Repository
public interface InvItemsRepository extends JpaRepository<AxelaInventoryItemModel, Integer> {

	@Query("SELECT a.modelName,a.modelId FROM AxelaInventoryItemModel a WHERE a.modelName=:modelName AND a.modelId=:modelId")
	public List<AxelaInventoryItemModel> findByItemName(@Param("modelName") String modelName, @Param("modelId") Integer modelId);
}
