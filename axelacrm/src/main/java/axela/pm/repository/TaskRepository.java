package axela.pm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.pm.model.AxelaPmTask;

@Repository
public interface TaskRepository extends JpaRepository<AxelaPmTask, Integer> {

	AxelaPmTask findByTaskId(int parseInt);

	@Query("SELECT pmtask.taskId,"
			+ " pmtask.taskSubject"
			+ " FROM AxelaPmTask pmtask"
			+ " where pmtask.taskPmId=:pmId")
	public List<Object[]> findByPopulateParentTask(@Param("pmId") int pmId);

	interface TaskRepositoryFilter {

	}

}
