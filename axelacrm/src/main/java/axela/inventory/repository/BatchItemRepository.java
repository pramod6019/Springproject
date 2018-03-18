package axela.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.inventory.model.AxelaInventoryBatch;

@Repository
public interface BatchItemRepository extends JpaRepository<AxelaInventoryBatch, Integer> {

	@Query("SELECT a.batchNo FROM AxelaInventoryBatch a WHERE a.batchNo=:batchNo AND a.batchId=:batchId")
	public List<AxelaInventoryBatch> findBybatchno(@Param("batchNo") String batchNo);
}
