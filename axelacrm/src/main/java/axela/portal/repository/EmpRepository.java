package axela.portal.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.config.Connect;
import axela.portal.model.AxelaBranch;
import axela.portal.model.AxelaEmp;

@Repository
public interface EmpRepository extends JpaRepository<AxelaEmp, Integer> {

	Optional<AxelaEmp> findByEmpName(String username);

	Connect cnt = new Connect();
	public AxelaEmp findByEmpUnameAndEmpUpass(String empUname, String empUpass);

	@Query("SELECT"
			+ " a.configCustomerSoe,"
			+ " a.configCustomerSob,"
			+ " a.configCustomerAddress,"
			+ " a.configCustomerDupnames,"
			+ " b.empRoleId"
			+ " FROM AxelaConfig a,"
			+ " AxelaEmp b,"
			+ " AxelaComp c"
			+ " WHERE b.empId In (?1) ")
	public List<Object[]> findEmpIdList(List empId);

	@Query("SELECT"
			+ " a.configCustomerSoe,"
			+ " a.configCustomerSob,"
			+ " a.configCustomerAddress,"
			+ " a.configCustomerDupnames,"
			+ " b.empRoleId,"
			+ " a.configSalesOpprName"
			+ " FROM AxelaConfig a,"
			+ " AxelaEmp b,"
			+ " AxelaComp c"
			+ " WHERE b.empId =:empId")
	public List<Object[]> findEmpId(@Param("empId") int empId);

	@Query("SELECT a FROM AxelaEmp a WHERE a.empId=:id")
	public AxelaEmp findOne(@Param("id") int id);

	// start technician executive
	@Query(value = "SELECT NEW AxelaEmp("
			+ " e.empId,"
			+ " CONCAT(e.empName, ' (', e.empRefNo, ')') AS empName)"
			+ " FROM AxelaEmp e"
			+ " WHERE e.empTechnician = 1"
			+ " AND (e.empBranchId =:branchId "
			+ " OR e.empId = 1"
			+ " OR e.empId IN (SELECT empbr.empId"
			+ " FROM  AxelaEmpBranch empbr"
			+ " WHERE empbr.empId=e.empId "
			+ " AND empbr.empBranchId =:branchId)"
			+ "))"
			+ " GROUP BY e.empId"
			+ " ORDER BY e.empName")
	List<AxelaEmp> findEmptech(@Param("branchId") int branchId);
	// end technician executive

	// start service advisor
	@Query(value = "SELECT NEW AxelaEmp("
			+ " e.empId,"
			+ " e.empName)"
			+ " FROM AxelaEmp e"
			+ " WHERE e.empActive = 1"
			+ " AND   e.empService = 1"
			+ " AND e.empBranchId=:branchId"
			+ " ORDER BY e.empName")
	List<AxelaEmp> findEmpadv(@Param("branchId") int branchId);

	@Query(value = "SELECT NEW AxelaEmp("
			+ " e.empId,"
			+ " e.empName)"
			+ " FROM AxelaEmp e"
			+ " WHERE e.empActive = 1"
			+ " AND   e.empService = 1"
			+ " ORDER BY e.empName")
	List<AxelaEmp> findByBranchId();
	// end service advisor

	// start populate manager
	@Query(value = "SELECT e "
			+ " FROM AxelaEmp e"
			+ " WHERE e.empBranchId =:drBranchId"
			+ " ORDER BY e.empName", nativeQuery = false)
	List<AxelaEmp> findAllByDrBranchId(@Param("drBranchId") String drBranchId);

	@Query(value = "SELECT e "
			+ " FROM AxelaEmp e"
			+ " WHERE e.empBranchId =:teamBranchId"
			+ " ORDER BY e.empName", nativeQuery = false)
	List<AxelaEmp> findAllByTeamBranchId(@Param("teamBranchId") String teamBranchId);
	// start populate manager

	// start populate CRM/PBF/PSF/ fallow up executive
	@Query(value = "SELECT e.empId, e.empName, e.empRefNo"
			+ " FROM  AxelaEmp e"
			+ " WHERE e.empSales = 1"
			+ " AND (e.empBranchId =:teamBranchId"
			+ " OR e.empId = 1"
			+ " OR e.empId IN (SELECT empbr.empId"
			+ " FROM AxelaEmpBranch empbr"
			+ " WHERE e.empId = empbr.empId"
			+ " AND empbr.empBranchId =:teamBranchId))"
			+ " ORDER BY e.empName", nativeQuery = false)
	List<Object[]> findByTeamBranchId(@Param("teamBranchId") int teamBranchId);
	// start populate CRM/PBF/PSF fallow up executiv e

	@Query("SELECT a.empName, a.empId"
			+ " FROM AxelaEmp a"
			+ " where 1=1 and a.empActive = '1' and a.empService = '1'"
			+ " order by a.empName")
	public List<Object[]> findByEmpNameAndEmpId();

	@Query("SELECT a.empRefNo FROM AxelaEmp a"
			+ " WHERE a.empRefNo =:empRefNo")
	public String findByEmpRefNo(@Param("empRefNo") String empRefNo);

	@Query("SELECT a.empRefNo FROM AxelaEmp a"
			+ " WHERE a.empRefNo =:empRefNo"
			+ " AND a.empId !=:empId")
	public String findByEmpRefNoById(@Param("empRefNo") String empRefNo, @Param("empId") int empId);

	@Query("SELECT a.empMobile1"
			+ " FROM AxelaEmp a"
			+ " WHERE a.empMobile1 =:empMobile1"
			+ " AND a.empId !=:empId")
	public String findByEmpMobile(@Param("empMobile1") String empMobile1, @Param("empId") int empId);

	@Query("SELECT a.empId "
			+ " FROM AxelaEmp a "
			+ " WHERE "
			+ " a.empEmail1 =:empEmail1"
			+ " OR a.empEmail2 =:empEmail1")
	public String findByEmpEmail1(@Param("empEmail1") String empEmail1);

	@Query("SELECT a.empId "
			+ " FROM AxelaEmp a "
			+ " WHERE "
			+ " (a.empEmail1 =:empEmail1"
			+ " OR a.empEmail2 =:empEmail1)"
			+ " AND a.empId!=:empId")
	public String findByEmpEmail1WithId(@Param("empEmail1") String empEmail1, @Param("empId") int empId);

	@Query("SELECT a.empId "
			+ " FROM AxelaEmp a "
			+ " WHERE "
			+ " a.empEmail1 =:empEmail2"
			+ " OR a.empEmail2 =:empEmail2")
	public String findByEmpEmail2(@Param("empEmail2") String empEmail2);

	@Query("SELECT a.empId "
			+ " FROM AxelaEmp a "
			+ " WHERE "
			+ " (a.empEmail1 =:empEmail2"
			+ " OR a.empEmail2 =:empEmail2)"
			+ " AND a.empId!=:empId")
	public String findByEmpEmail2WithId(@Param("empEmail2") String empEmail, @Param("empId") int empId);

	@Query("SELECT COUNT(a.empBranchId) FROM AxelaEmp a"
			+ " WHERE a.empBranchId =:branchId")
	public int findByEmpBranchId(@Param("branchId") int branchId);

	@Query("SELECT COALESCE(MAX(a.empId), 0) + 1 AS empId"
			+ " FROM AxelaEmp a")
	public int findMaxEmpId();

	@Query("SELECT a.empName "
			+ " FROM AxelaEmp a "
			+ " WHERE "
			+ " a.empId=:ticketfaqEntryId ")
	String findEmpName(@Param("ticketfaqEntryId") int teamEntryId);

	AxelaEmp findByEmpId(int parseInt);

	@Query(value = "SELECT e.empCloseOppr FROM AxelaEmp e WHERE empId=:empId")
	String findByempCloseOppr(@Param("empId") int empId);

	@Query("SELECT a.empId FROM AxelaEmp a WHERE a.empId=:empId")
	public int findOneById(@Param("empId") int empId);

	@Query(" SELECT empId, empName,empRefNo "
			+ " FROM AxelaEmp "
			+ " WHERE empBranchId=:empBranchId "
			+ " ORDER BY empName ")
	List<Object[]> findByEmpBranchIds(@Param("empBranchId") int empBranchId);

	@Query(" SELECT empId, empName,empRefNo "
			+ " FROM AxelaEmp "
			+ " ORDER BY empName ")
	List<Object[]> findEmpDetail();

	@Query("SELECT a FROM AxelaBranch a WHERE a.branchId=:branchId ORDER By a.branchName")
	public List<AxelaBranch> findByOne(@Param("branchId") int branchId);

	@Query(value = "SELECT e.empId,e.empName "
			+ " FROM AxelaEmp e"
			+ " ORDER BY e.empName", nativeQuery = false)
	List<Object[]> findAllactivity();

	@Query(value = "SELECT e.empId,e.empName "
			+ " FROM AxelaEmp e"
			+ " WHERE e.empId=:empId"
			+ " ORDER BY e.empName", nativeQuery = false)
	List<Object[]> findByActivityId(@Param("empId") int empId);

	@Transactional
	@Modifying
	@Query("UPDATE AxelaEmp emp set emp.empPhoto=:empPhoto"
			+ " WHERE emp.empId=:empId")
	int updateExePhoto(@Param("empPhoto") byte[] empPhoto, @Param("empId") int empId);

	@Transactional
	@Modifying
	@Query("UPDATE AxelaEmp emp set emp.empStatus=:empStatus"
			+ " WHERE emp.empId=:empId")
	int updateExestatus(@Param("empStatus") String empStatus, @Param("empId") int empId);

	@Query(value = "SELECT e.empStatus FROM AxelaEmp e WHERE empId=:empId")
	String findEmpstatus(@Param("empId") int empId);

	@Query(" SELECT CONCAT(empName,' (',empRefNo,')') "
			+ " FROM AxelaEmp "
			+ " WHERE empId=:empId "
			+ " ORDER BY empId ")
	String findByEmp(@Param("empId") int empId);

	public interface EmpRepositoryFilter {
		public List<Object[]> findByAllExecutive(@Param("exeAccess") String exeAccess);
		public List<Object[]> findByExecutive(@Param("exeAccess") String exeAccess, @Param("customerBranchId") String customerBranchId);

	}

	@Query(" SELECT  emp.empId,emp.empName,emp.empRefNo"
			+ " FROM AxelaEmp emp "
			+ " WHERE  emp.empActive = '1' "
			+ " AND emp.empId!=:empId"
			+ " ORDER BY emp.empName ")
	public List<Object[]> findExe(@Param("empId") int empId);

}