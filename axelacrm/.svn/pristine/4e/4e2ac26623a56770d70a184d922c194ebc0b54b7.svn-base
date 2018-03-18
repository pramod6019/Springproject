package axela.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.inventory.model.AxelaInventoryCat;

public interface InventoryCatRepository extends JpaRepository<AxelaInventoryCat, Integer> {

	@Query("SELECT a.catName FROM AxelaInventoryCat a WHERE 1 = 1 AND a.catParentId=:catParentId AND a.catName =:catName ")
	public List<AxelaInventoryCat> findByCatName(@Param("catParentId") Integer catParentId, @Param("catName") String catName);

	@Query("SELECT a.catId,a.catName FROM AxelaInventoryCat a ")
	public List<Object[]> findCategory();

	@Query("SELECT "
			+ " cat.catId, "
			+ " cat.catName, "
			+ " cat.catParentId,"
			+ " cat.catActive"
			+ " FROM AxelaInventoryCat cat "
			+ " where cat.catParentId =:catParentId "
			+ " order by cat.catName ")
	public List<Object[]> findByCatParentId(@Param("catParentId") int catParentId);

	interface InventoryCatFilterRepository {

	}

	@Query("SELECT cat.catId,"
			+ " cat.catName,"
			+ " cat.catParentId"
			+ " FROM AxelaInventoryCat cat"
			+ " WHERE cat.catId =:catId")
	public List<Object[]> findByCatId(@Param("catId") int catId);

	@Query("SELECT COUNT(cat.catParentId) AS optionItemId  FROM AxelaInventoryCat cat WHERE 1=1 AND cat.catParentId=:catParentId")
	public int findAssociationCatParentId(@Param("catParentId") int catParentId);

}
