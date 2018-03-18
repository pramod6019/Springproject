package axela.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.inventory.model.AxelaInventoryLocation;

public interface InventoryLocationRepository extends JpaRepository<AxelaInventoryLocation, Integer> {

	public AxelaInventoryLocation findByLocationCode(String locationCode);

	@Query(" SELECT location.locationId, location.locationName"
			+ " FROM AxelaInventoryLocation location "
			+ " ORDER BY location.locationName ")
	List<Object[]> findAllLocation();

	@Query(" SELECT location.locationName, location.locationId "
			+ " FROM AxelaInventoryLocation location"
			+ " WHERE location.locationId=:locationId "
			+ " ORDER BY location.locationName ")
	List<Object[]> findAllLocationById(@Param("locationId") int locationId);

	interface InventoryLocationFilterRepository {

	}
	@Query(" SELECT location.locationBranchId"
			+ " FROM AxelaInventoryLocation location"
			+ " WHERE location.locationId =:locationId")
	public int getBranchId(@Param("locationId") int locationId);
}
