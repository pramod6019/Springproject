//package axela.portal.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import axela.inventory.model.AxelaInventoryItem;
//@Repository
//public interface InventoryItemRepository extends JpaRepository<AxelaInventoryItem, Integer> {
//	@Query("SELECT a FROM AxelaInventoryItem a WHERE a.itemId =:itemId")
//	List<AxelaInventoryItem> findByItemId(@Param("itemId") int itemId);
//
// }
