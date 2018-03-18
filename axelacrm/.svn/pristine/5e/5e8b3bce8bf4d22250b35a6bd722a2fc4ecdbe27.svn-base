package axela.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaInventoryPoData;
@Repository
public interface InventoryPoDataRepository extends JpaRepository<AxelaInventoryPoData, Integer> {
	@Query("SELECT"
			+ " COUNT(a.podataSupplierId)"
			+ " FROM AxelaInventoryPoData a"
			+ " WHERE a.podataSupplierId=:customerId")
	public int findById(@Param("customerId") int customerId);
}
