package axela.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import axela.inventory.model.AxelaInventoryItemType;

public interface InventoryItemTypeRepository extends JpaRepository<AxelaInventoryItemType, Long> {

}
