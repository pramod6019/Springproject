package axela.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.sales.model.AxelaSalesOppr;

@Repository
public interface OpprRepository extends JpaRepository<AxelaSalesOppr, Integer> {

	@Query("SELECT COUNT(a.opprCustomerId)"
			+ " FROM AxelaSalesOppr a"
			+ " WHERE a.opprCustomerId=:customerId")
	public int findById(@Param("customerId") int customerId);

	@Query("SELECT COUNT(a.opprEmpId) FROM AxelaSalesOppr a"
			+ " WHERE a.opprEmpId =:empId")
	public int findByOpprEmpId(@Param("empId") int empId);

	@Query("SELECT a.opprCustomerId"
			+ " FROM AxelaSalesOppr a"
			+ " WHERE a.opprCustomerId=:customerId")
	public String findByCustomerId(@Param("customerId") int customerId);

	@Query("SELECT a.opprRefno"
			+ " FROM AxelaSalesOppr a"
			+ " WHERE a.opprBranchId=:branchId"
			+ " AND opprRefno=:opprRefno")
	public String findByOpprRefno(@Param("branchId") String branchId, @Param("opprRefno") String opprRefno);

	// @Query("SELECT a FROM AxelaSalesOppr a WHERE opprId=:opprId")
	public AxelaSalesOppr findOne(@Param("opprId") int opprId);

	@Query("SELECT"
			+ " (COALESCE(MAX(a.opprId),0)) AS opprId"
			+ " FROM AxelaSalesOppr a"
			+ " WHERE a.opprId=:opprId")
	public int findByOppprId(@Param("opprId") int opprId);

	@Query("SELECT COUNT(a.opprBranchId) FROM AxelaSalesOppr a"
			+ " WHERE a.opprBranchId =:branchId")
	public int findByOpprBranchId(@Param("branchId") int branchId);

	@Query("SELECT (COALESCE(MAX(a.opprNo),0)+1) FROM AxelaSalesOppr a WHERE 1=1 ")
	public Integer findOpprNo();

	@Query("SELECT Oppr.opprContactId"
			+ " FROM AxelaSalesOppr Oppr"
			+ " WHERE Oppr.opprContactId=:contactId")
	public String findByContact(@Param("contactId") int contactId);

	public interface OpprDashRepository {

	}
	@Query("SELECT COUNT(model.opprModelId) FROM AxelaSalesOppr model"
			+ " WHERE model.opprModelId =:opprModelId")
	public int opprModelCheking(@Param("opprModelId") int opprModelId);
}