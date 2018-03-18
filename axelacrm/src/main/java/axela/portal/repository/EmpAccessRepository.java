package axela.portal.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.portal.model.AxelaEmpAccess;

public interface EmpAccessRepository extends JpaRepository<AxelaEmpAccess, Integer> {

	@Transactional
	@Modifying
	@Query("DELETE FROM AxelaEmpAccess a"
			+ " WHERE a.empaccessEmpId=:empId")
	public void deleteByEmpId(@Param("empId") int empId);

	@Query("SELECT access.empaccessAccessId "
			+ " FROM  AxelaEmpAccess access "
			+ " WHERE access.empaccessEmpId =:empaccessEmpId ")
	public List findByEmpaccessEmpId(@Param("empaccessEmpId") int empaccessEmpId);
}
