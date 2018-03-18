package axela.pm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import axela.pm.model.AxelaPmTaskPriority;

public interface TaskPriorityRepository extends JpaRepository<AxelaPmTaskPriority, Integer> {

	@Query("SELECT priority.prioritytaskId,"
			+ " priority.prioritytaskName"
			+ " FROM AxelaPmTaskPriority priority"
			+ " WHERE 1=1 "
			+ "ORDER BY priority.prioritytaskName")
	public List<Object[]> findByPopulateTaskPriority();

}
