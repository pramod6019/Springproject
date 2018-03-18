package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.inventory.model.AxelaInventoryItem;

@Repository
public interface ItemRepository extends JpaRepository<AxelaInventoryItem, Integer> {

	@Query("SELECT a.itemId,a.itemName FROM AxelaInventoryItem a where a.itemActive=1")
	public List<Object[]> findAllItem();

	@Query("SELECT a.itemId,a.itemName FROM AxelaInventoryItem a WHERE a.itemActive=1 AND a.itemModelId=:id")
	public List<Object[]> findByModel(@Param("id") int id);

	@Query("SELECT a FROM AxelaInventoryItem a WHERE a.itemActive=1 AND a.itemName=:itemName")
	public List<AxelaInventoryItem> findByItemName(@Param("itemName") String itemName);

	@Query("SELECT a FROM  AxelaInventoryItem a WHERE a.itemCode =:itemCode")
	public List<AxelaInventoryItem> findByItemcode(@Param("itemCode") String itemCode);
}
