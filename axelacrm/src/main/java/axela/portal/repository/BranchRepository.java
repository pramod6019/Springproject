package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.portal.model.AxelaBranch;

public interface BranchRepository extends JpaRepository<AxelaBranch, Integer> {

	public AxelaBranch findByBranchId(int branchId);
	// @Query("SELECT a FROM AxelaBranch a WHERE a.branchActive = '1' #{#branchAccess}")
	// List<AxelaBranch> findAll(@Param("branchAccess") String branchAccess);

	@Query("SELECT a FROM AxelaBranch a "
			+ "WHERE a.branchId=:id"
			+ " AND a.branchActive='1'")
	public AxelaBranch findOne(@Param("id") int id);
	@Query("select b.branchId,b.branchName"
			+ " from AxelaBranch b"
			+ " where b.branchActive = 1")
	public List<AxelaBranch> getActiveBranches();

	@Query("SELECT a.branchName FROM AxelaBranch a"
			+ " WHERE a.branchName =:branchName"
			+ " AND a.branchId !=:branchId")
	public List<AxelaBranch> findByBranchName(@Param("branchName") String branchName, @Param("branchId") int branchId);

	@Query("SELECT a.branchCode FROM AxelaBranch a"
			+ " WHERE a.branchCode =:branchCode"
			+ " AND a.branchId !=:branchId")
	public List<AxelaBranch> findByBranchCode(@Param("branchCode") String branchName, @Param("branchId") int branchId);

	@Query("SELECT COALESCE(MAX(a.branchId), 0) + 1 AS branchId"
			+ " FROM AxelaBranch a")
	public int findMaxBranchId();

	@Query("SELECT a FROM AxelaBranch a WHERE a.branchId=:branchId ORDER By a.branchName")
	public List<AxelaBranch> findByOne(@Param("branchId") int branchId);

	@Query("SELECT COUNT(a.branchId)"
			+ " FROM AxelaBranch a"
			+ " WHERE a.branchActive = 1")
	public int populateBybranchId();

	@Query("SELECT CONCAT(branch.branchName,' (',branch.branchCode, ')')"
			+ " FROM AxelaBranch branch"
			+ " WHERE branch.branchId=:jcJcbranchId")
	public String findByBranchName(@Param("jcJcbranchId") String jcJcbranchId);

	@Query("SELECT a.branchId,a.branchName FROM AxelaBranch a ")
	List<AxelaBranch> findAllBranch();

	@Query("SELECT a.branchName FROM AxelaBranch a WHERE a.branchId=:branchId")
	public String findBranchName(@Param("branchId") int branchId);

	@Query("SELECT branch.branchId,branch.branchName,branch.branchCode FROM AxelaBranch branch ORDER BY branch.branchName ")
	public List<Object[]> findAllBranches();

}
