package axela.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.portal.model.AxelaHoli;

public interface AxelaholiRepository extends JpaRepository<AxelaHoli, Integer> {

	@Query("SELECT COUNT(a.holiBranchId) FROM AxelaHoli a"
			+ " WHERE a.holiBranchId =:branchId")
	public int findByholiBranchId(@Param("branchId") int branchId);
}
