package axela.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.sales.model.AxelaSalesTarget;

//@Repository
public interface SalesTargetRepository extends JpaRepository<AxelaSalesTarget, Integer> {

	@Query("SELECT COUNT(a.targetEmpId) FROM AxelaSalesTarget a"
			+ " WHERE a.targetEmpId =:empId")
	public int findByTargetEmpId(@Param("empId") int empId);

	public interface targetFilterRepository {

	}
}
