package axela.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaAssetInsur;
@Repository
public interface AssetInsuranceRepository extends JpaRepository<AxelaAssetInsur, Integer> {

	@Query("SELECT"
			+ " COUNT(a.insurCustomerId)"
			+ " FROM AxelaAssetInsur a"
			+ " WHERE a.insurCustomerId=:customerId")
	public int findById(@Param("customerId") int customerId);
}
