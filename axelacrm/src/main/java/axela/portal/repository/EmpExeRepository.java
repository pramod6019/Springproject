package axela.portal.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.portal.model.AxelaEmpExe;

public interface EmpExeRepository extends JpaRepository<AxelaEmpExe, Integer> {

	@Transactional
	@Modifying
	@Query("DELETE FROM AxelaEmpExe a"
			+ " WHERE a.empexeEmpId =:empexeEmpId")
	public void deleteByEmpId(@Param("empexeEmpId") int empexeEmpId);

	@Query("SELECT a.empexeExeId "
			+ " FROM  AxelaEmpExe a "
			+ " WHERE a.empexeEmpId =:empexeEmpId ")
	public List findByEmpexeId(@Param("empexeEmpId") int empexeEmpId);

}
