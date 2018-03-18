package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.portal.model.AxelaRateClass;

public interface AxelaRateClassRepository extends JpaRepository<AxelaRateClass, Integer> {

	@Query("SELECT a.rateclassId,a.rateclassName"
			+ " FROM AxelaRateClass a WHERE 1=1"
			+ " AND rateclassType = 1 GROUP BY rateclassId"
			+ " ORDER BY rateclassName")
	public List<Object[]> findByRateId();

	@Query("SELECT a.rateclassId, a.rateclassName"
			+ " FROM AxelaRateClass a"
			+ " ORDER BY a.rateclassName")
	public List<Object[]> populateByRateclassIdAndRateClassName();

	@Query("SELECT a.rateclassId,a.rateclassName from AxelaRateClass a WHERE a.rateclassType=:rateclassType GROUP BY a.rateclassId ORDER BY a.rateclassName")
	public List<Object[]> findBySalesRateClass(@Param("rateclassType") String rateclassType);

	@Query("SELECT a from AxelaRateClass a WHERE a.rateclassType=1 GROUP BY a.rateclassId ORDER BY a.rateclassName")
	public List<AxelaRateClass> findByPurchaseRateClass();
}
