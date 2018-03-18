package axela.pm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import axela.pm.model.AxelaPmTaskStatus;

public interface TaskStatusRepository extends JpaRepository<AxelaPmTaskStatus, Integer> {

	@Query("SELECT status.taskstatusId,"
			+ " status.taskstatusName"
			+ " FROM AxelaPmTaskStatus status"
			+ " WHERE 1=1 "
			+ "ORDER BY status.taskstatusName")
	public List<Object[]> findByPopulateTaskStatus();
}
