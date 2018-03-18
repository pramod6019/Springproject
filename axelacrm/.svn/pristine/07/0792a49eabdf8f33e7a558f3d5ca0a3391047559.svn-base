package axela.pm.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.pm.model.AxelaPmExe;

@Repository
public interface PmExeRepository extends JpaRepository<AxelaPmExe, Integer> {

	@Transactional
	@Modifying
	@Query("DELETE  FROM AxelaPmExe a WHERE a.pmexePmId=:pmId"
			+ " AND a.pmexeEmpId=:executiveId")
	int findPmExe(@Param("executiveId") int executiveId, @Param("pmId") int pmId);

	interface TaskRepositoryFilter {

	}

}
