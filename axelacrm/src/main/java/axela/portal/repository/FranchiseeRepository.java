package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaFranchisee;

@Repository
public interface FranchiseeRepository extends JpaRepository<AxelaFranchisee, Integer> {

	@Query("SELECT franchisee.franchiseeId, franchisee.franchiseeName"
			+ " FROM AxelaFranchisee franchisee"
			+ " ORDER BY franchisee.franchiseeName")
	public List<Object[]> populateByfranchiseeIdAndFranchiseeName();

	@Query("SELECT COUNT(franchisee.franchiseeId)"
			+ " FROM AxelaFranchisee franchisee")
	public int populateByfranchiseeId();

}
