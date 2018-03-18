package axela.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.sales.model.AxelaSalesTeam;

@Repository
public interface SalesTeamRepository extends JpaRepository<AxelaSalesTeam, Integer> {

	// @Query("SELECT empId, empName, empRefNo"
	// + " FROM AxelaEmp"
	// + " WHERE empSales = 1"
	// + " AND (empBranchId = :teamBranchId "
	// + " OR empId = 1 "
	// + " OR empId IN (SELECT empbr.empId FROM AxelaEmpBranch empbr"
	// + " WHERE AxelaEmp.empId = empbr.empId"
	// + " AND empbr.empBranchId = :teamBranchId ))"
	// + " ORDER BY empName")
	// List<Object[]> findByTeam(@Param("teamBranchId") int teamBranchId);

	@Query("SELECT a.teamId FROM AxelaSalesTeam a"
			+ " WHERE a.teamName=:teamName"
			+ " AND a.teamBranchId=:teamBranchId"
			+ " GROUP BY a.teamBranchId")
	Object findByTeamNameAndTeamBranchId(@Param("teamName") String teamName, @Param("teamBranchId") int teamBranchId);

	AxelaSalesTeam findByTeamId(int teamId);

	@Query("SELECT a.teamId,a.teamName FROM AxelaSalesTeam a")
	List<AxelaSalesTeam> findAll();

	// @Query("SELECT teamCrmEmpId"
	// + " FROM AxelaSalesTeam a"
	// + " JOIN a.axelaSalesTeamExe "
	// + " WHERE a.teamBranchId=:branchId"
	// + " AND a.teamtransEmpId=:teamtransEmpId")
	// int findByTeamEmpId(@Param("branchId") int branchId, @Param("teamtransEmpId") int teamtransEmpId);

	public interface TeamSalesFilterRepository {

	}
	@Query("SELECT a.teamId,a.teamName FROM AxelaSalesTeam a ")
	List<Object[]> findAllTeam();

	@Query("SELECT a.teamId,a.teamName FROM AxelaSalesTeam a ")
	List<Object[]> findByTeamBranchId(int teamBranchId);

	@Query("SELECT a.teamId,a.teamName FROM AxelaSalesTeam a WHERE a.teamId!=:teamId AND a.teamName=:teamName")
	List<AxelaSalesTeam> findByTeamIdAndTeamName(@Param("teamId") int teamId, @Param("teamName") String teamName);

	@Query(value = "SELECT CASE WHEN crmdays.crmdaysExeType = 1 THEN team.teamCrmEmpId WHEN crmdays.crmdaysExeType = 2 "
			+ " THEN oppr.opprEmpId WHEN crmdays.crmdaysExeType = 3 THEN team.teamEmpId END FROM AxelaSalesTeam team,AxelaSalesCrmday crmdays,AxelaSalesOppr oppr"
			+ " JOIN  team.axelaSalesTeamExe exe "
			// + " JOIN team.axelaBranch branch"
			// + " JOIN  branch.axelaSalesOppr oppr"
			+ " WHERE  team.teamBranchId=oppr.opprBranchId"
			+ " AND  team.teamBranchId =oppr.opprBranchId"
			+ " AND exe.teamtransEmpId = oppr.opprEmpId "
			+ "")
	List<Integer> findForCrmFields();

	// @Query("SELECT teamCrmEmpId"
	// + " FROM AxelaSalesTeam a"
	// + " JOIN a.axelaSalesTeamExe "
	// + " WHERE a.teamBranchId=:branchId"
	// + " AND a.teamtransEmpId=:teamtransEmpId")
	// int findByTeamEmpId(@Param("branchId") int branchId, @Param("teamtransEmpId") int teamtransEmpId);

	@Query("SELECT COUNT(a.teamEmpId) FROM AxelaSalesTeam a"
			+ " WHERE a.teamEmpId =:empId")
	public int findByTeamEmpId(@Param("empId") int empId);

}
