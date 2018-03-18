package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.inventory.model.AxelaInventoryCat;

public interface AxelaInventoryCatRepository extends JpaRepository<AxelaInventoryCat, Integer> {

	@Query("SELECT a FROM AxelaInventoryCat a WHERE a.catParentId=:catParentId AND a.catName=:catName")
	public List<AxelaInventoryCat> findByCatName(@Param("catParentId") Integer catParentId, @Param("catName") String catName);
}
