package axela.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.service.model.AxelaProdJobcard;

public interface ProdJobCardRepository extends JpaRepository<AxelaProdJobcard, Integer> {

	@Query("SELECT COUNT(a.jobcardEmpId) FROM AxelaProdJobcard a"
			+ " where a.jobcardEmpId =:empId")
	public int findByjobCardEmpId(@Param("empId") int empId);

	@Query("SELECT COUNT(a.jobcardBranchId) FROM AxelaProdJobcard a"
			+ " WHERE jobcard_branch_id =:branchId")
	public int findByjobCardBranchId(@Param("branchId") int branchId);

}
