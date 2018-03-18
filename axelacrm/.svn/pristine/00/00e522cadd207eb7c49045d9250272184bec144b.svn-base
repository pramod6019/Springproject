package axela.portal.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.portal.model.AxelaEmp;

@Repository
public interface SigninRepository extends JpaRepository<AxelaEmp, Long> {

	Connect cnt = new Connect();

	AxelaEmp findByEmpEmail1AndEmpUpass(String empEmail1, String empUpass) throws Exception;

	AxelaEmp findByEmpId(int emp_id);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM AxelaEmpUser  WHERE axelaEmp.empId=:empId", nativeQuery = false)
	int deleteUserByEmpId(@Param("empId") int empId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE  AxelaEmpLog "
			+ " SET logSignoutTime =:time, "
			+ " logRemoteHost=:iP, "
			+ " logRemoteAgent=:hostName"
			+ " WHERE axelaEmp.empId=:empId"
			+ " AND COALESCE(logSignoutTime,'')=''")
	int addUserByEmpId(@Param("empId") int empId, @Param("time") Date time, @Param("iP") String IP, @Param("hostName") String hostName);

	// exeAccess
	@Query(value = " SELECT empexeId FROM AxelaEmpExe WHERE empexeEmpId=:empId", nativeQuery = false)
	String[] getEmpExeIds(@Param("empId") int empId);

	// branchAccess
	@Query(value = " SELECT emp_branch_id FROM axela_emp_branch"
			+ " WHERE emp_id=:empId", nativeQuery = true)
	String[] getBranchIds(@Param("empId") int empId);

}