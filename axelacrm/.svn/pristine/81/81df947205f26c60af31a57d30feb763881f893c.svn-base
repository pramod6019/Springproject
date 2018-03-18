package axela.service.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.service.model.AxelaServiceJc;
@Repository
@Transactional(readOnly = true)
public class ServiceJcFilterImpl extends Connect {
	@PersistenceContext
	EntityManager em;
	public static String totalCount = "0";
	public static int listLength = 0;

	public List<AxelaServiceJc> findBypopulate(String baytransJcId, HttpSession session)
	{
		String Query = "SELECT NEW AxelaServiceJc("
				+ " jc.jcBranchId,"
				+ " jc.jcTimeReady,"
				+ " COALESCE((SELECT emp.empId FROM axelaEmp emp  WHERE emp.empId =jc.axelaServiceJcBayTran.baytransEmpId ), 0) AS empId"
				+ " FROM AxelaServiceJc jc"
				+ " INNER JOIN jc.axelaServiceJcBayTran "
				+ " INNER JOIN jc.axelaServiceJcBay "
				+ " WHERE jc.jcId = " + baytransJcId;
		TypedQuery<AxelaServiceJc> typedQuery = em.createQuery(Query, AxelaServiceJc.class);
		listLength = em.createQuery(Query, AxelaServiceJc.class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}

	public int findByBayTransEmpId(String baytransJcId, String baytransBayId)
	{
		String Query = "SELECT jc.axelaServiceJcBayTran.baytransEmpId"
				+ " FROM AxelaServiceJc jc"
				+ " INNER JOIN jc.axelaServiceJcBayTran "
				+ " INNER JOIN jc.axelaServiceJcBay "
				+ " WHERE jc.axelaServiceJcBayTran.baytransJcId = " + baytransJcId
				+ " AND jc.axelaServiceJcBayTran.baytransEndTime = '' "
				+ " AND jc.axelaServiceJcBayTran.baytransBayId = " + baytransBayId
				+ " ";
		int typedQuery = em.createQuery(Query, Object[].class).getFirstResult();
		em.clear();
		return typedQuery;
	}
	public List<Object[]> findBypopulateLanding(String strSearch, HttpSession session)
	{
		String Query = "SELECT jc.axelaBranch.branchId,"
				+ " CONCAT(jc.axelaBranch.branchName, ' (', jc.axelaBranch.branchCode, ')') AS branchName,"
				+ " COUNT(DISTINCT jc.jcId) AS jccount "
				+ " FROM AxelaServiceJc jc "
				+ " INNER JOIN jc.axelaCustomer "
				+ " INNER JOIN jc.axelaCustomerContact "
				+ " INNER JOIN jc.axelaCustomerContact.axelaTitle "
				+ " INNER JOIN jc.axelaBranch"
				+ " INNER JOIN jc.axelaEmp "
				+ " INNER JOIN jc.axelaItem "
				+ " INNER JOIN jc.axelaItem.axelaInventoryItemModel "
				+ " LEFT JOIN jc.axelaServicejcType"
				+ " LEFT JOIN jc.axelaServicejccat"
				+ " INNER JOIN jc.axelaServicejcpriority"
				+ " INNER JOIN jc.axelaServicejcstatus"
				+ " WHERE 1 = 1"
				+ strSearch + ""
				+ " GROUP BY jc.axelaBranch.branchId"
				+ " ORDER BY jc.axelaBranch.branchName";
		TypedQuery<Object[]> typedQuery = em.createQuery(Query, Object[].class);
		listLength = em.createQuery(Query, Object[].class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}

	public List<AxelaServiceJc> findAllJobCardExecutiveReport(String strSearch, String franchiseeId)
	{
		String sqlJoin = "";
		String countSql = "";
		TypedQuery<AxelaServiceJc> typedQuery = null;
		String strSql = "SELECT NEW AxelaServiceJc( "
				+ "jc.axelaEmp.empId,"
				+ "jc.axelaEmp.empName,"
				+ " COUNT(jc.jcId) AS jcCount,"
				+ " SUM(jc.jcGrandtotal) as jcTotal)"
				+ " FROM AxelaServiceJc jc"
				+ " INNER JOIN jc.axelaEmp";

		if (!franchiseeId.equals("0"))
		{
			strSql += " INNER JOIN jc.axelaBranch"
					+ " INNER JOIN jc.axelaBranch.axelaFranchisee";
		}

		strSql += " WHERE 1 = 1 AND jc.axelaEmp.empService = 1 " + strSearch + ""
				+ " GROUP BY jc.axelaEmp.empId"
				+ " ORDER BY jc.axelaEmp.empName";
		typedQuery = em.createQuery(strSql, AxelaServiceJc.class);
		listLength = em.createQuery(strSql, AxelaServiceJc.class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}

	public List<AxelaServiceJc> findAllTechnicianDetailsReport(String strSearch, String franchiseeId)
	{
		String sqlJoin = "";
		String countSql = "";
		TypedQuery<AxelaServiceJc> typedQuery = null;
		String strSql = "SELECT NEW AxelaServiceJc( "
				+ "jc.axelaEmp.empId,"
				+ "jc.axelaEmp.empName,"
				+ " COUNT(jc.jcId) AS jcCount,"
				+ " SUM(jc.jcGrandtotal) as jcTotal)"
				+ " FROM AxelaServiceJc jc"
				+ " INNER JOIN jc.axelaEmp";

		if (!franchiseeId.equals("0"))
		{
			strSql += " INNER JOIN jc.axelaBranch"
					+ " INNER JOIN jc.axelaBranch.axelaFranchisee";
		}

		strSql += " WHERE 1 = 1 AND jc.axelaEmp.empTechnician = 1 " + strSearch + ""
				+ " GROUP BY jc.axelaEmp.empId"
				+ " ORDER BY jc.axelaEmp.empName";
		typedQuery = em.createQuery(strSql, AxelaServiceJc.class);
		listLength = em.createQuery(strSql, AxelaServiceJc.class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}
}
