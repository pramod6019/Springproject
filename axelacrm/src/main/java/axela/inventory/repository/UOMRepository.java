package axela.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.inventory.model.AxelaInventoryUom;

@Repository
public interface UOMRepository extends JpaRepository<AxelaInventoryUom, Integer> {

	@Query("SELECT(COALESCE(MAX(a.uomName),0))"
			+ " FROM AxelaInventoryUom a"
			+ " WHERE a.uomName=:uomName"
			+ " AND a.uomId!=:uomId")
	public String findByUomName(@Param("uomName") String uomName, @Param("uomId") int uomId);

	@Query("SELECT (COALESCE(MAX(Uom.uomParentId),0))"
			+ " FROM AxelaInventoryUom Uom"
			+ " WHERE Uom.uomParentId=:uomId")
	public int findByUomParentId(@Param("uomId") int uomId);

}
