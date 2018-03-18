package axela.sales.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import axela.sales.model.AxelaSalesCrm;

@Repository
public class CrmFilterImplemention {

	@PersistenceContext
	EntityManager em;

	public List<AxelaSalesCrm> findPsfDetails(int opprId) {
		String Query = " SELECT NEW AxelaSalesCrm ( crm.crmId, crm.crmOpprId, crm.crmFollowupTime, crm.crmSoId, crm.crmDesc, "
				+ " crm.crmEntryTime, crm.crmEntryId, crm.crmModifiedId, "
				+ " COALESCE(crm.crmModifiedTime,'') AS crmModifiedTime, "
				+ " COALESCE(type.crmfeedbacktypeName, '') AS crmfeedbacktypeName,"
				// + " coalesce(CONCAT(e.emp_name,' (',e.emp_ref_no,')'),'') AS entry_by, "
				// + " coalesce(CONCAT(m.emp_name,' (',m.emp_ref_no,')'),'') AS modified_by, "
				+ " COALESCE(CONCAT(emp.empName,' (',emp.empRefNo,')'),'') AS empName,"
				+ " crmday.crmdaysDaycount, crmday.crmdaysDesc, crm.crmEmpId, crmType.crmtypeName, crmType.crmtypeId )"
				+ " FROM AxelaSalesCrm crm"
				+ " JOIN crm.axelaSalesOppr oppr"
				+ " JOIN crm.axelaSalesCrmday crmday"
				+ " JOIN oppr.axelaEmp emp"
				+ " LEFT JOIN crm.axelaCrmFeedbacktype type"
				+ " JOIN crmday.axelaSalesCrmType crmType"
				+ " WHERE 1=1"
				+ " AND crm.crmOpprId=" + opprId;
		System.out.println("Query===============" + Query);
		TypedQuery<AxelaSalesCrm> typedQuery = em.createQuery(Query, AxelaSalesCrm.class);
		return typedQuery.getResultList();
	}

	public List<Object[]> findCrmField(int opprId, String date, String strSearch) {
		String Query = "SELECT  " + opprId + ""
				+ "," + 1 + ","
				+ " crmdays.crmdaysId,"
				+ " DATE_FORMAT("
				// + "DATE_ADD(("
				+ "" + date + ","
				// + " INTERVAL (crmdays.crmdaysDaycount-1 DAY)),"
				+ " '%Y%m%d%H%i%s')"
				+ " FROM AxelaSalesOppr oppr,AxelaSalesCrmday crmdays"
				+ " WHERE crmdays.crmdaysCrmtypeId=1 "
				+ " AND oppr.opprId = " + opprId + strSearch;
		List<Object[]> typedQuery = em.createQuery(Query).getResultList();
		return typedQuery;
	}
}
