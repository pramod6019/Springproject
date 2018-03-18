package axela.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import axela.inventory.model.AxelaInventoryStock;

public interface InventoryReOrderRepository extends JpaRepository<AxelaInventoryStock, Integer> {

	AxelaInventoryStock findByStockLocationId(int parseInt);

	AxelaInventoryStock findByStockId(int parseInt);

}
