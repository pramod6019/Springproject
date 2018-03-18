package axela.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.inventory.model.AxelaInventoryItem;
@Repository
public interface InventoryItemRepository extends JpaRepository<AxelaInventoryItem, Integer> {

	AxelaInventoryItem findByitemId(int itemId);

	@Query("SELECT a from AxelaInventoryItem a,AxelaInventoryItemType b where a.itemItemtypeId=b.itemtypeId")
	List<AxelaInventoryItem> findAll();

	@Query("SELECT item.itemId FROM AxelaInventoryItem item WHERE 1=1 AND item.itemName=:itemName")
	List<AxelaInventoryItem> findItemName(@Param("itemName") String itemName);

	List<AxelaInventoryItem> findByItemName(String itemName);

	List<AxelaInventoryItem> findByItemCatId(int itemCatId);

	AxelaInventoryItem findByItemCodeAndItemId(String itemCode, int itemId) throws Exception;

	@Query("SELECT b.compBusinesstypeId, b.compModuleAccounting, c.empRoleId, a.configInventoryCurrentStock FROM AxelaConfig a, AxelaComp b, AxelaEmp c WHERE c.empId =?1 ")
	List<Object[]> findInventoryItemConfigFields(int empId);

	@Query("SELECT count(item.itemItemtypeId)"
			+ "  FROM AxelaInventoryItem item"
			+ " WHERE item.itemId=:priceItemId")
	String findItemItemtypeId(@Param("priceItemId") int itemId);
	// Custom implementation for InventoryItemRepository
	public interface InventoryFilterRepository {

		List<AxelaInventoryItem> findAllItem();

	}
	List<AxelaInventoryItem> findByItemId(int itemId);

	char[] findByitemUomId(int parseInt);

	@Query("SELECT COUNT(item.itemModelId) FROM "
			+ "AxelaInventoryItem item"
			+ " WHERE item.itemModelId =:modelId ")
	int itemModelchecking(@Param("modelId") int modelId);

	@Query("SELECT item.itemId,item.itemName FROM AxelaInventoryItem item WHERE 1=1 AND item.itemId!=:itemId AND item.itemName=:itemName")
	List<AxelaInventoryItem> findItemName(@Param("itemId") int itemId, @Param("itemName") String itemName);

	List<AxelaInventoryItem> findByItemCode(String itemCode);

	@Query("SELECT item.itemId,item.itemCode FROM AxelaInventoryItem item WHERE 1=1 AND item.itemId!=:itemId AND item.itemCode=:itemCode")
	List<AxelaInventoryItem> findItemCode(@Param("itemId") int itemId, @Param("itemCode") String itemCode);

	@Query("SELECT item FROM AxelaInventoryItem item WHERE item.itemId=:itemId")
	AxelaInventoryItem findByItemIdDetail(@Param("itemId") int itemId);

	@Query("SELECT COALESCE(CASE WHEN item.itemCode != '' THEN  CONCAT(item.itemName, ' (', item.itemCode, ')') ELSE  item.itemName END)"
			+ " FROM AxelaInventoryItem item "
			+ " WHERE item.itemId =:priceItemId "
			+ "ORDER BY item.itemName")
	public String findByItemCodeDetail(@Param("priceItemId") int priceItemId);

	@Query("SELECT item.itemName"
			+ " FROM AxelaInventoryItem item"
			+ " WHERE 1=1"
			+ " AND item.itemId=:itemId")
	String findItemNameAndId(@Param("itemId") int itemId);

}
