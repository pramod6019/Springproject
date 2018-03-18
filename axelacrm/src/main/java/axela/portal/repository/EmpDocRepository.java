package axela.portal.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.portal.model.AxelaEmpDoc;

public interface EmpDocRepository extends JpaRepository<AxelaEmpDoc, Integer> {

	@Transactional
	@Modifying
	@Query("DELETE FROM AxelaEmpDoc a"
			+ " WHERE a.docEmpId =:empId")
	public int deleteByAxelaEmpDoc(@Param("empId") int empId);

}
