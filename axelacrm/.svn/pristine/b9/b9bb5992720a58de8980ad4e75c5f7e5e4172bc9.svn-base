package axela.pm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import axela.pm.model.AxelaPmStatus;

public interface PmStatusRepository extends JpaRepository<AxelaPmStatus, Integer> {

	@Query("SELECT status.pmstatusId,"
			+ " status.pmstatusName"
			+ " FROM AxelaPmStatus status"
			+ " WHERE 1=1 "
			+ "ORDER BY status.pmstatusName")
	public List<Object[]> findByPopulatePmStatus();

}
