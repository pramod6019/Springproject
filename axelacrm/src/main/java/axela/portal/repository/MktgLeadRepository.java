package axela.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.portal.model.AxelaMktgLead;

public interface MktgLeadRepository extends JpaRepository<AxelaMktgLead, Integer> {

	@Query("SELECT COUNT(a.leadEmpId) FROM AxelaMktgLead a"
			+ " WHERE a.leadEmpId =:empId")
	public int findByLeadEmpId(@Param("empId") int empId);

}
