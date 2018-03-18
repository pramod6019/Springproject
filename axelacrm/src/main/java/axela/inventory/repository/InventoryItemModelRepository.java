package axela.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.inventory.model.AxelaInventoryItemModel;

public interface InventoryItemModelRepository extends JpaRepository<AxelaInventoryItemModel, Integer> {

	@Query("SELECT model.modelId,model.modelName"
			+ " FROM AxelaInventoryItemModel model"
			+ " ORDER BY model.modelName")
	List<Object[]> findModals();

	List<AxelaInventoryItemModel> findByModelActiveLikeOrderByModelName(String ModelActive);

	@Query(value = "SELECT m from AxelaInventoryItemModel m  WHERE m.modelActive='1' ORDER  BY m.modelName ", nativeQuery = false)
	List<AxelaInventoryItemModel> findAllByOder();

	@Query(value = "SELECT m from AxelaInventoryItemModel m  WHERE m.modelActive='1' AND m.modelId=:modelId ORDER  BY m.modelName ", nativeQuery = false)
	List<AxelaInventoryItemModel> findByModelIdOrderByModelName(@Param("modelId") int modelId);

	@Query("SELECT a FROM AxelaInventoryItemModel a WHERE a.modelId=:id AND a.modelActive='1' ORDER BY modelName")
	public AxelaInventoryItemModel findOne(@Param("id") int id);

	@Query("SELECT a FROM AxelaInventoryItemModel a WHERE a.modelName =:modelName")
	public List<AxelaInventoryItemModel> findByName(@Param("modelName") String modelName);

	public List<AxelaInventoryItemModel> findByModelName(String modelName);

	@Query("SELECT a.modelName FROM AxelaInventoryItemModel a WHERE a.modelId =:modelId")
	public String findByModelName(@Param("modelId") int modelId);
	interface InventoryItemModelFilterRepository {

	}
	AxelaInventoryItemModel findByModelId(int parseInt);

	@Query("SELECT model.modelId,model.modelName FROM AxelaInventoryItemModel model WHERE 1=1 AND model.modelId !=:modelId AND model.modelName=:modelName")
	List<AxelaInventoryItemModel> findModelName(@Param("modelId") int modelId, @Param("modelName") String modelName);
}
