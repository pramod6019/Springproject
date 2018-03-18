package axela.sales.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.portal.model.AxelaBranch;
import axela.sales.model.AxelaSalesTeam;
import axela.sales.repository.SalesTeamRepository.TeamSalesFilterRepository;
@Repository
@Transactional(readOnly = true)
public class TeamFilterImpl extends Connect implements TeamSalesFilterRepository {

	public static String totalCount = "0";
	public static Long listLength = 0L;

	@PersistenceContext
	EntityManager em;

	public List<AxelaBranch> findAllByBranch(String branchAccess) {
		Query query = em.createQuery("SELECT a FROM AxelaBranch a WHERE a.branchActive = '1' " + branchAccess);
		return (List<AxelaBranch>) query.getResultList();
	}

	public int length(String branchAccess, String exeAccess, String sort, String field) {
		Query query = em.createQuery("SELECT a FROM AxelaCustomer a WHERE 1=1 AND a.customerType !='0'" + branchAccess + exeAccess + " ORDER BY a." + field + " " + sort);
		em.clear();
		return (int) query.getResultList().size();
	}

	public List<AxelaSalesTeam> findAll(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaSalesTeam> listData = new ArrayList<AxelaSalesTeam>();
		String strSql = "SELECT NEW AxelaSalesTeam(";

		strSql += " team.teamId,"
				+ " team.teamName,"
				+ " team.teamBranchId,"
				+ " COALESCE(team.axelaEmp.empName,'') AS empName,"
				+ " COALESCE(team.axelaEmp.empId,'') AS empId, "
				+ " COALESCE(team.axelaEmp.empRefNo,'') AS empRefNo,"
				+ "	COUNT(team.axelaEmp.empId) AS empCount) ";

		sqlJoin += " FROM AxelaSalesTeam team "
				+ " JOIN team.axelaEmp "
				+ " LEFT JOIN team.axelaSalesTeamExe "
				+ " LEFT JOIN team.axelaEmp "
				+ " WHERE 1=1 "
				+ strSearch;

		countSql = "SELECT COUNT(DISTINCT team.teamId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY team.teamId "
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaSalesTeam.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public List<Object[]> findByTeam(int teamBranchId) {
		String Query = "SELECT empId, empName, empRefNo"
				+ " FROM AxelaEmp"
				+ " WHERE empSales = 1"
				+ " AND (empBranchId = " + teamBranchId + ""
				+ " OR empId = 1 "
				+ " OR empId IN (SELECT empbr.empId FROM AxelaEmpBranch empbr"
				+ " WHERE empbr.axelaEmp.empId = empbr.empId"
				+ " AND empbr.empBranchId = " + teamBranchId + " ))"
				+ " ORDER BY empName";
		TypedQuery<Object[]> typedQuery = em.createQuery(Query, Object[].class);
		em.clear();
		return typedQuery.getResultList();
	}

	public List<AxelaBranch> findData(String branchAccess) {
		String Query = "SELECT new AxelaBranch( a.branchId, a.branchName, a.branchCode )"
				+ " FROM AxelaBranch a"
				+ "	WHERE 1=1"
				+ " AND a.branchActive=1 "
				+ branchAccess
				+ " ORDER BY a.branchName";
		TypedQuery<AxelaBranch> typedQuery = em.createQuery(Query, AxelaBranch.class);
		em.clear();
		return typedQuery.getResultList();
	}

	public List<Object[]> findByBranch(String strSearch) {
		String strSql = "SELECT team.teamId, team.teamName"
				+ " FROM AxelaSalesTeam team"
				+ "	WHERE 1=1"
				+ strSearch
				+ " ORDER BY team.teamName";
		TypedQuery<Object[]> typedQuery = em.createQuery(strSql, Object[].class);
		em.clear();
		return typedQuery.getResultList();
	}

	public List<Object[]> findTeamLandingDetails(String strSearch) {
		String strSql = "SELECT team.teamId, team.teamName,"
				+ " team.teamBranchId, team.teamEmpId,"
				+ " CONCAT(emp.empName,' (',emp.empRefNo,')') AS empName,"
				+ " COUNT(teamExe.teamtransEmpId) as empcount"
				+ " FROM AxelaSalesTeam team"
				+ " JOIN team.axelaSalesTeamExe teamExe"
				+ " JOIN team.axelaEmp emp"
				+ " where 1=1"
				+ " GROUP BY team.teamId"
				+ " ORDER BY team.teamName";
		List<Object[]> list = em.createQuery(strSql, Object[].class).getResultList();
		em.clear();
		return list;
	}
}
