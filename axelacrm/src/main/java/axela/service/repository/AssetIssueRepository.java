package axela.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.service.model.AxelaAssetIssue;

public interface AssetIssueRepository extends JpaRepository<AxelaAssetIssue, Integer> {

	@Query("SELECT COUNT(a.issueEmpId) FROM AxelaAssetIssue a"
			+ " WHERE a.issueEmpId =:empId ")
	public int findByIssueEmpId(@Param("empId") int empId);

}
