package axela.portal.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.portal.model.AxelaEmp;
import axela.portal.repository.EmpRepository.EmpRepositoryFilter;

@Repository
@Transactional
public class EmpFilterImpl implements EmpRepositoryFilter {
	@PersistenceContext
	EntityManager em;

	public List<Object[]> findByAllExecutive(String exeAccess) {
		String Query = "SELECT"
				+ " a.empName,"
				+ " a.empRefNo,"
				+ " a.empId "
				+ " FROM AxelaEmp a"
				+ " WHERE 1=1"
				+ " AND a.empActive = '1'"
				+ " AND a.empTicketOwner = 1 " + exeAccess
				+ " GROUP BY a.empId "
				+ " ORDER BY a.empName";
		TypedQuery<Object[]> typedQuery = em.createQuery(Query, Object[].class);
		return typedQuery.getResultList();
	}

	public List<Object[]> findByExecutive(String exeAccess, String customerBranchId) {
		String Query = "SELECT"
				+ " a.empId,"
				+ " CONCAT(a.empName,' (',a.empRefNo,')') as empName"
				+ " from AxelaEmp a"
				+ " where 1=1"
				+ " AND a.empTicketOwner = '1'"
				+ " AND a.empActive='1' "
				+ " AND (a.empBranchId = " + customerBranchId
				+ " OR a.empId = 1 "
				+ " OR a.empId in (select empbr.empId from AxelaEmpBranch empbr "
				+ " WHERE a.empId=empbr.empId"
				+ " AND empbr.empBranchId=" + customerBranchId + "))"
				+ exeAccess
				+ " group by a.empId  "
				+ " order by a.empName";
		TypedQuery<Object[]> typedQuery = em.createQuery(Query, Object[].class);
		return typedQuery.getResultList();
	}

	public List<Object[]> findByteam(String exeAccess, String strSearch) {
		String Query = "SELECT"
				+ " emp.empId,"
				+ " emp.empName,"
				+ " emp.empRefNo"
				+ " FROM AxelaEmp emp"
				+ " LEFT JOIN emp.axelaSalesTeamExe exe"
				+ " WHERE 1=1"
				+ " AND emp.empActive= 1"
				+ strSearch
				+ exeAccess
				+ " group by emp.empId  "
				+ " order by emp.empName";
		TypedQuery<Object[]> typedQuery = em.createQuery(Query, Object[].class);
		return typedQuery.getResultList();
	}

	// connect class checkperm method
	public boolean findCheckPerm(String strSearch, int empId) {
		String Query = "SELECT emp.empId"
				+ " FROM AxelaEmp emp"
				+ " LEFT JOIN emp.axelaEmpAccess empAccess"
				+ " LEFT JOIN empAccess.axelaModuleAccess moduleAccess"
				+ " WHERE 1=1"
				+ " AND emp.empActive = '1'"
				+ " AND emp.empId = " + empId
				+ strSearch
				+ " GROUP BY emp.empId";
		System.out.println("Query=================" + Query);
		TypedQuery<Integer> typedQuery = em.createQuery(Query, Integer.class);
		em.clear();
		typedQuery.getFirstResult();
		return typedQuery.getResultList().size() != 0 ? true : false;
	}

	public AxelaEmp findTopAccess(int empId) {
		String Query = "SELECT NEW AxelaEmp("
				+ " emp.empExportAccess,"
				+ " emp.empReportAccess,"
				+ " emp.empMisAccess,"
				+ " emp.empCopyAccess)"
				+ " FROM AxelaEmp emp"
				+ " WHERE emp.empId=" + empId;

		return em.createQuery(Query, AxelaEmp.class).getSingleResult();

	}

	public List<Object[]> findByUser(String jcId) {
		String Query = "SELECT"
				+ " emp.empId,"
				+ " CONCAT(emp.empName,' (',emp.empRefNo,')') AS empName"
				+ " FROM AxelaEmp emp"
				+ " INNER JOIN emp.axelaServiceJcBayTran tran"
				+ " WHERE tran.baytransJcId =" + jcId
				+ " GROUP BY emp.empId"
				+ " ORDER BY emp.empName";
		TypedQuery<Object[]> typedQuery = em.createQuery(Query, Object[].class);
		return typedQuery.getResultList();
	}

}