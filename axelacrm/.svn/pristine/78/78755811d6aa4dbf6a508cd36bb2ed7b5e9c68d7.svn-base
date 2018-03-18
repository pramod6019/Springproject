package axela.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.pm.model.AxelaPmTask;

@Repository
public interface PmTaskRepository extends JpaRepository<AxelaPmTask, Integer> {

	@Query("SELECT COUNT(a.taskEmpId) FROM AxelaPmTask a"
			+ " WHERE a.taskEmpId =:empId")
	public int findBytaskEmpId(@Param("empId") int empId);

	@Query("SELECT a.taskTaskstatusId, a.taskEmpId"
			+ " FROM AxelaPmTask a"
			+ " WHERE a.taskPmId =:pmId")
	public List<Object[]> findTaskpmId(@Param("pmId") int pmId);

}
