package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.portal.model.AxelaEmpBranch;

@Repository
public interface EmpBranchrepository extends JpaRepository<AxelaEmpBranch, Integer> {

	@Transactional
	@Modifying
	@Query("DELETE FROM AxelaEmpBranch a WHERE a.empId=:empId")
	void deletebyEmpId(@Param("empId") int empId);

	@Query("SELECT a.empEmpbranchId "
			+ " FROM  AxelaEmpBranch a "
			+ " WHERE a.empId =:empId ")
	List findByEmpBranchId(@Param("empId") int empId);

}
