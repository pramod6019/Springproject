package axela.portal.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.pm.model.AxelaPm;
import axela.pm.model.AxelaPmExe;
import axela.pm.model.AxelaPmTask;
import axela.pm.model.AxelaPmTaskDoc;

@Repository
@Transactional(readOnly = true)
public class PmFilterImpl {

	public static String totalCount = "0";
	@PersistenceContext
	EntityManager em;

	public List<Object[]> findByProject(@Param("ticketCustomerId") String ticketCustomerId) {
		String Query = "SELECT "
				+ " a.pmId,"
				+ " a.pmTitle,"
				+ " a.pmStartDate,"
				+ " a.pmEndDate"
				+ " FROM AxelaPm a"
				+ " WHERE 1=1 and a.pmActive=1";
		if (!ticketCustomerId.equals("") && !ticketCustomerId.equals("0")) {
			Query += " AND a.pmCustomerId=" + ticketCustomerId + " ";
		}
		Query += " GROUP BY a.pmId "
				+ " ORDER BY a.pmTitle ";
		TypedQuery<Object[]> typedQuery = em.createQuery(Query, Object[].class);
		return typedQuery.getResultList();
	}
	public List<AxelaPm> findAll(String strSearch, String strOrderBy, int page, int perPage, String app) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaPm> listData = new ArrayList<AxelaPm>();
		TypedQuery<AxelaPm> typedQuery = null;
		String strSql = "SELECT NEW AxelaPm("
				+ " pm.pmId,"
				+ " pm.pmTitle,"
				+ " pm.axelaCustomer.customerName,"
				+ " pm.axelaPmType.pmtypeName,"
				+ " pm.pmCompletePerc,"
				+ " pm.pmActive,"
				+ " pm.pmBudget)";
		sqlJoin += " FROM AxelaPm pm"
				+ " JOIN pm.axelaCustomer customer"
				+ " JOIN pm.axelaPmType"
				+ " LEFT JOIN pm.axelaPmExe"
				+ " WHERE 1 = 1"
				+ strSearch;
		// + " ORDER BY pm.pmId";
		countSql = "SELECT COUNT(DISTINCT pm.pmId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY pm.pmId"
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaPm.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
			// listData = typedQuery.getResultList();
		}
		em.close();
		return listData;
	}

	public List<AxelaPm> findProjectDetails(int pmId) {
		String Query = "SELECT NEW AxelaPm("
				+ " pm.axelaCustomer.customerId,"
				+ " pm.axelaCustomer.customerName,"
				+ " pm.pmCompleteComments,"
				+ " pm.pmId,"
				+ " pm.pmTitle,"
				+ " pm.axelaPmStatus.pmstatusName,"
				+ " pm.pmStartDate,"
				+ " pm.pmEndDate)"
				+ " FROM AxelaPm pm"
				+ " JOIN pm.axelaCustomer"
				+ " JOIN pm.axelaPmStatus"
				+ " WHERE pm.pmId=" + pmId;
		TypedQuery<AxelaPm> typedQuery = em.createQuery(Query, AxelaPm.class);
		return typedQuery.getResultList();
	}

	public List<AxelaPmTask> findProjectCompletePerc(int pmId) {
		String Query = "SELECT NEW AxelaPmTask("
				+ " task.taskCompletePerc)"
				+ " FROM AxelaPmTask task"
				+ " JOIN task.axelaPm"
				+ " WHERE task.taskPmId=" + pmId;
		TypedQuery<AxelaPmTask> typedQuery = em.createQuery(Query, AxelaPmTask.class);
		return typedQuery.getResultList();
	}

	public List<AxelaPmExe> findProjectExecutives(int pmId) {
		String Query = "SELECT NEW AxelaPmExe("
				+ " pmexe.axelaEmp.empId,"
				+ " pmexe.axelaEmp.empName,"
				+ " pmexe.axelaEmp.empGender)"
				+ " FROM AxelaPmExe pmexe"
				+ " JOIN pmexe.axelaEmp"
				+ " WHERE pmexe.pmexeEmpId=" + pmId;
		TypedQuery<AxelaPmExe> typedQuery = em.createQuery(Query, AxelaPmExe.class);
		return typedQuery.getResultList();
	}

	public List<AxelaPmExe> findProjectExe(int pmId) {
		String Query = "SELECT NEW AxelaPmExe("
				+ " pmexe.pmexeEmpId,"
				+ " pmexe.axelaPm.pmId)"
				+ " FROM AxelaPmExe pmexe"
				+ " JOIN pmexe.axelaPm"
				+ " WHERE pmexe.pmexeEmpId=" + pmId;
		TypedQuery<AxelaPmExe> typedQuery = em.createQuery(Query, AxelaPmExe.class);
		return typedQuery.getResultList();
	}

	public List<AxelaPmTaskDoc> findProjectDoc(int pmId) {
		String Query = "SELECT NEW AxelaPmTaskDoc("
				+ " taskdoc.docTaskId,"
				+ " taskdoc.docId,"
				+ " taskdoc.docTitle,"
				+ " taskdoc.axelaPmTask.taskSubject,"
				+ " taskdoc.docRemarks,"
				+ " taskdoc.axelaPmTask.taskId)"
				+ " FROM AxelaPmTaskDoc taskdoc"
				+ " JOIN taskdoc.axelaPmTask"
				+ " JOIN taskdoc.axelaPmTask.axelaPm"
				+ " WHERE taskdoc.axelaPmTask.taskPmId=" + pmId;
		TypedQuery<AxelaPmTaskDoc> typedQuery = em.createQuery(Query, AxelaPmTaskDoc.class);
		return typedQuery.getResultList();
	}

}
