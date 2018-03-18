package axela.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import axela.inventory.model.AxelaInventoryItemPriceTran;

public interface InventoryItemPriceTranRepository extends JpaRepository<AxelaInventoryItemPriceTran, Integer> {

	AxelaInventoryItemPriceTran findByPricetransId(int parseInt);

}
