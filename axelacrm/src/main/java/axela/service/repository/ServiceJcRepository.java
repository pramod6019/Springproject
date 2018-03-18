package axela.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.service.model.AxelaServiceJc;

public interface ServiceJcRepository extends JpaRepository<AxelaServiceJc, Integer> {

	@Query("SELECT"
			+ " branch.branchName "
			+ "FROM AxelaServiceJc jc"
			+ " INNER JOIN jc.axelaBranch branch"
			+ " WHERE jc.jcId=:jcId")
	public String findByJcBranchId(@Param("jcId") String jcId);

	@Query("SELECT NEW AxelaServiceJc("
			+ " jc.jcBranchId,"
			+ " jc.jcTimeReady,"
			+ " COALESCE((SELECT emp.empId FROM AxelaEmp emp WHERE emp.empId =:baytransEmpId), 0) AS empId)"
			+ " FROM AxelaServiceJc jc"
			+ " WHERE jc.jcId =:baytransJcId")
	public List<AxelaServiceJc> findByJcBranchIdAndJcTimeReady(@Param("baytransJcId") int baytransJcId, @Param("baytransEmpId") int baytransEmpId);

}
