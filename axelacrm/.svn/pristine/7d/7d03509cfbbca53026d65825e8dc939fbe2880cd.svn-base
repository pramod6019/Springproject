package axela.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.portal.model.AxelaEmpLeave;

public interface EmpLeaveRepository extends JpaRepository<AxelaEmpLeave, Integer> {

	@Query("SELECT COUNT(a.leaveEmpId) FROM AxelaEmpLeave a"
			+ " WHERE a.leaveEmpId =:empId")
	public int findByLeaveEmpId(@Param("empId") int empId);

}
