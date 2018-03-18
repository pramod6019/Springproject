package axela.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import axela.inventory.model.AxelaInventoryCatPop;

public interface InventoryCatPopRepository extends JpaRepository<AxelaInventoryCatPop, Integer> {

	interface InventoryCatPopFilterRepository {

	}

	AxelaInventoryCatPop findByCatId(int parseInt);

	@Query("SELECT (COALESCE(MAX(cat.catRank),0)+1) FROM AxelaInventoryCatPop cat WHERE 1=1")
	public Integer findRank();
}
