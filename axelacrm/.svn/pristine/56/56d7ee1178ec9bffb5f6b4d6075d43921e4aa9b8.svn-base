package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaEmpDepartment;

@Repository
public interface EmpDepartmentRepository extends JpaRepository<AxelaEmpDepartment, Integer> {

	@Query("SELECT department.departmentId, department.departmentName"
			+ " FROM AxelaEmpDepartment department")
	public List<Object[]> findAllDepartment();

}
