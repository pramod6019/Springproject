package axela.inventory.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.inventory.model.AxelaInventoryBinPop;

@Repository
public interface InventoryBinPopRepository extends JpaRepository<AxelaInventoryBinPop, Integer> {

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM AxelaInventoryBinPop")
	int deleteAllBinPop();

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM AxelaInventoryBinPop binpop WHERE binpop.binId=:binId")
	int deleteByBinId(@Param("binId") int binId);

	interface InventoryBinPopFilterRepository {

	}
}
