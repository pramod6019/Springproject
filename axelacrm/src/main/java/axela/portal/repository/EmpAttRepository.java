package axela.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.portal.model.AxelaEmpAtt;

public interface EmpAttRepository extends JpaRepository<AxelaEmpAtt, Integer> {

	@Query("SELECT  COUNT(a.attEmpId) FROM AxelaEmpAtt a"
			+ " WHERE a.attEmpId =:empId")
	public int findByAttEmpId(@Param("empId") int empId);

}
