package axela.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.inventory.model.AxelaInventoryBin;
@Repository
public interface InventoryBinRepository extends JpaRepository<AxelaInventoryBin, Integer> {

	List<AxelaInventoryBin> findBybinParentId(int binParentId);

	interface InventoryBinFilterRepository {

	}

	@Query("SELECT"
			+ " bin.binId,"
			+ " bin.binName,"
			+ " bin.binLocationId,"
			+ " bin.binParentId,"
			+ " bin.binActive"
			+ " FROM  AxelaInventoryBin bin"
			+ " WHERE bin.binParentId =:binParentId "
			+ " ORDER BY bin.binName")
	List<Object[]> findByBinParentId(@Param("binParentId") int binParentId);

}
