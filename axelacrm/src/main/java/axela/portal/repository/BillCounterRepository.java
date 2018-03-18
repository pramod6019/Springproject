package axela.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.portal.model.AxelaBillCounter;

public interface BillCounterRepository extends JpaRepository<AxelaBillCounter, Integer> {

	@Query("SELECT COUNT(a.counterBranchId) FROM AxelaBillCounter a"
			+ " WHERE a.counterBranchId =:branchId")
	public int findByCounterBranchId(@Param("branchId") int branchId);

}
