package axela.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.service.model.AxelaServiceContractLocation;

@Repository
public interface ServiceContractLocationRepository extends JpaRepository<AxelaServiceContractLocation, Integer> {

	@Query("SELECT a.contractlocId, a.contractlocName "
			+ " FROM AxelaServiceContractLocation a "
			+ " WHERE a.contractlocCustomerId=:assetCustomerId"
			+ " GROUP BY a.contractlocId "
			+ " ORDER BY a.contractlocName")
	public List<Object[]> findByContractLocId(@Param("assetCustomerId") int assetCustomerId);

	interface ServiceContractLocationFilterRepository {

	}

}
