package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.pm.model.AxelaPm;

@Repository
public interface PmRepository extends JpaRepository<AxelaPm, Integer> {
	@Query(value = "SELECT p from  AxelaPm p WHERE p.pmActive = '1' AND pmId=:pmId GROUP BY p.pmId ORDER BY p.pmTitle", nativeQuery = false)
	List<AxelaPm> findByPm(@Param("pmId") int pmId);

	@Query(value = "SELECT p from  AxelaPm p WHERE p.pmActive = '1' ORDER BY p.pmTitle", nativeQuery = false)
	List<AxelaPm> findAll();

	@Query("SELECT"
			+ " a.pmCustomerId"
			+ " FROM AxelaPm a"
			+ " WHERE a.pmCustomerId=:customerId")
	public String findById(@Param("customerId") int customerId);

	AxelaPm findByPmId(int parseInt);

}
