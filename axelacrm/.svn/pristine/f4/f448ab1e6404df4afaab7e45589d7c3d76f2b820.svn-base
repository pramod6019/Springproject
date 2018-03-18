package axela.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.portal.model.AxelaNewsBranch;

public interface NewsBranchRepository extends JpaRepository<AxelaNewsBranch, Integer> {

	@Query("SELECT COUNT(a.newsBranchId) FROM AxelaNewsBranch a"
			+ " WHERE a.newsBranchId =:branchId")
	public int findByNewsBranchId(@Param("branchId") int branchId);
}
