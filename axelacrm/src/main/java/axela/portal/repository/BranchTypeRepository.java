package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import axela.portal.model.AxelaBranchType;

public interface BranchTypeRepository extends JpaRepository<AxelaBranchType, Integer> {

	@Query("SELECT a.branchtypeId, a.branchtypeName"
			+ " FROM AxelaBranchType a"
			+ " ORDER BY  a.branchtypeName")
	public List<Object[]> populateByBranchTypeIdAndName();
}
