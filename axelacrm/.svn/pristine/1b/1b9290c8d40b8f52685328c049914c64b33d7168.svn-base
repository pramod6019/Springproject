package axela.app.sales.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import axela.accounting.model.AxelaAccVoucher;
import axela.app.sales.repository.HomeSalesRepository.HomeOpprRepository;
import axela.config.ConnectDate;
import axela.helpdesk.model.AxelaHelpDeskTicket;
import axela.pm.model.AxelaPm;
import axela.pm.model.AxelaPmTask;
import axela.sales.model.AxelaSalesOppr;
import axela.service.model.AxelaServiceContract;
import axela.service.model.AxelaServiceJc;

@Repository
public class HomeSalesFilterImpl extends ConnectDate implements HomeOpprRepository {

	@PersistenceContext
	EntityManager em;
	// opportunity
	public List<AxelaSalesOppr> findSalesCount(int empId, String currentDate, String branchId) {

		String strSql = "SELECT NEW AxelaSalesOppr("
				+ " COALESCE(SUM(CASE WHEN SUBSTRING(oppr.opprEntryDate,1,7) =  SUBSTRING('" + currentDate + "',1,7) THEN 1 ELSE  0 END),0 )AS monthopportunities,"
				+ " COALESCE(SUM(CASE WHEN SUBSTRING(oppr.opprEntryDate,1,10) = SUBSTRING('" + currentDate + "',1,10)THEN 1 ELSE  0 END),0) AS todayopportunities,"
				+ " COALESCE(SUM(CASE WHEN(oppr.opprStatusId=1)THEN 1 ELSE  0 END),0) AS totalopportunities,"
				+ " (SELECT COUNT(oppr.opprId)"
				+ " FROM AxelaSalesOppr oppr,AxelaSalesOpprFollowup followup"
				+ " WHERE oppr.opprStatusId =1"
				+ " AND oppr.opprId =followup.followupOpprId"
				+ " AND followup.followupTrigger = 1"
				// + " AND oppr.opprEmpId = " + empId
				+ ") AS level1oppr,"
				+ "(SELECT COUNT(oppr.opprId)"
				+ " FROM AxelaSalesOppr oppr,AxelaSalesOpprFollowup followup"
				+ " WHERE oppr.opprStatusId =1"
				+ " AND oppr.opprId =followup.followupOpprId"
				+ " AND followup.followupTrigger = 2"
				// + " AND oppr.opprEmpId = " + empId
				+ ") AS level2oppr,"
				+ "(SELECT COUNT(oppr.opprId)"
				+ " FROM AxelaSalesOppr oppr,AxelaSalesOpprFollowup followup"
				+ " WHERE oppr.opprStatusId =1"
				+ " AND oppr.opprId =followup.followupOpprId"
				+ " AND followup.followupTrigger = 3"
				// + " AND oppr.opprEmpId = " + empId
				+ ") AS level3oppr,"
				+ "(SELECT COUNT(oppr.opprId)"
				+ " FROM AxelaSalesOppr oppr,AxelaSalesOpprFollowup followup"
				+ " WHERE oppr.opprStatusId =1"
				+ " AND oppr.opprId =followup.followupOpprId"
				+ " AND followup.followupTrigger = 4"
				// + " AND oppr.opprEmpId = " + empId
				+ ") AS level4oppr,"
				+ "(SELECT COUNT(oppr.opprId)"
				+ " FROM AxelaSalesOppr oppr,AxelaSalesOpprFollowup followup"
				+ " WHERE oppr.opprStatusId =1"
				+ " AND oppr.opprId =followup.followupOpprId"
				+ " AND followup.followupTrigger = 5"
				// + " AND oppr.opprEmpId = " + empId
				+ ") AS level5oppr)";
		String sqlJoin = " FROM AxelaSalesOppr oppr";
		if (!branchId.equals("0")) {
			sqlJoin += " JOIN oppr.axelaBranch ";
		}
		strSql += sqlJoin;
		strSql += " WHERE 1=1";
		if (empId != 1) {
			strSql += " AND oppr.opprEmpId=" + empId;
		}
		if (!branchId.equals("0")) {
			strSql += " AND oppr.opprBranchId =" + branchId;
		}
		TypedQuery<AxelaSalesOppr> typedQuery = em.createQuery(strSql, AxelaSalesOppr.class);
		em.clear();
		return typedQuery.getResultList();
	}

	// contract
	public List<AxelaServiceContract> findContractCount(int empId, String currentDate, String branchId) {
		String strSql = "SELECT NEW AxelaServiceContract("
				+ " COALESCE(SUM(CASE WHEN SUBSTRING(contract.contractDate,1,7) =  SUBSTRING('" + currentDate + "',1,7) THEN 1 ELSE  0 END),0 )AS monthContract,"
				+ " COALESCE(SUM(CASE WHEN SUBSTRING(contract.contractDate,1,10) = SUBSTRING('" + currentDate + "',1,10)THEN 1 ELSE  0 END),0) AS todayContract)";
		String sqlJoin = " FROM AxelaServiceContract contract";

		if (!branchId.equals("0")) {
			sqlJoin += " JOIN contract.axelaBranch ";
		}
		strSql += sqlJoin;
		strSql += " WHERE 1=1";
		if (empId != 1) {
			strSql += " AND contract.contractEmpId=" + empId;
		}
		if (!branchId.equals("0")) {
			strSql += " AND contract.contractBranchId =" + branchId;
		}
		TypedQuery<AxelaServiceContract> typedQuery = em.createQuery(strSql, AxelaServiceContract.class);
		em.clear();
		return typedQuery.getResultList();
	}

	// jobcard
	public List<AxelaServiceJc> findjobcardCount(int empId, String currentDate, String branchId) {
		String strSql = "SELECT NEW AxelaServiceJc("
				+ " COALESCE(SUM(CASE WHEN SUBSTRING(Jc.jcEntryDate,1,7) = SUBSTRING('" + currentDate + "',1,7)THEN 1 ELSE  0 END),0 ) AS monthjc,"
				+ " COALESCE(SUM(CASE WHEN SUBSTRING(Jc.jcEntryDate,1,10) = SUBSTRING('" + currentDate + "',1,10)THEN 1 ELSE  0 END),0 ) AS todayjc,"
				+ " COALESCE(SUM(CASE WHEN(Jc.jcJcstatusId NOT IN (5,6))THEN 1 ELSE  0 END),0) AS totaljc,"
				// + " COALESCE(SUM(IF(jc_priorityjc_id=1,1,0)),0) AS totalhotjc,"
				+ " (SELECT COUNT(jcId)"
				+ " FROM AxelaServiceJc Jc"
				+ " WHERE jcJcstatusId NOT IN (5,6)"
				+ " AND jcPriorityTrigger = 1"
				+ " AND jcEmpId = " + empId
				+ ") AS level1jc,"
				+ "(SELECT COUNT(jcId)"
				+ " FROM AxelaServiceJc Jc"
				+ " WHERE jcJcstatusId = 1"
				+ " AND jcPriorityTrigger = 2"
				+ " AND jcEmpId = " + empId
				+ ") AS level2jc,"
				+ "(SELECT COUNT(jcId)"
				+ " FROM AxelaServiceJc Jc"
				+ " WHERE jcJcstatusId NOT IN (5,6)"
				+ " AND jcPriorityTrigger = 3"
				+ " AND jcEmpId = " + empId
				+ ") AS level3jc,"
				+ "(SELECT COUNT(jcId)"
				+ " FROM AxelaServiceJc Jc"
				+ " WHERE jcJcstatusId NOT IN (5,6)"
				+ " AND jcPriorityTrigger = 4"
				+ " AND jcEmpId = " + empId
				+ ") AS level4jc,"
				+ "(SELECT COUNT(jcId)"
				+ " FROM AxelaServiceJc Jc"
				+ " WHERE jcJcstatusId NOT IN (5,6)"
				+ " AND jcPriorityTrigger = 5"
				+ " AND jcEmpId = " + empId
				+ ") AS level5jc)";
		String sqlJoin = "FROM AxelaServiceJc Jc";
		if (!branchId.equals("0")) {
			sqlJoin += " JOIN Jc.axelaBranch ";
		}
		strSql += sqlJoin;
		strSql += " WHERE 1=1";
		if (empId != 1) {
			strSql += " AND Jc.jcEmpId=" + empId;
		}
		if (!branchId.equals("0")) {
			strSql += " AND Jc.jcBranchId =" + branchId;
		}

		TypedQuery<AxelaServiceJc> typedQuery = em.createQuery(strSql, AxelaServiceJc.class);
		em.clear();
		return typedQuery.getResultList();
	}

	// ticket
	public List<AxelaHelpDeskTicket> findticketCount(int empId, String currentDate, String branchId) {
		String strSql = "SELECT NEW AxelaHelpDeskTicket("
				+ " COALESCE(SUM(CASE WHEN SUBSTRING(ticket.ticketEntryDate,1,7) = SUBSTRING('" + currentDate + "',1,7)THEN 1 ELSE  0 END),0 ) AS monthticket,"
				+ " COALESCE(SUM(CASE WHEN SUBSTRING(ticket.ticketEntryDate,1,10) = SUBSTRING('" + currentDate + "',1,10)THEN 1 ELSE  0 END),0 ) AS todayticket,"
				+ " COALESCE(SUM(CASE WHEN(ticket.ticketTicketstatusId NOT IN (5,6))THEN 1 ELSE  0 END),0) AS totalticket,"
				+ " COALESCE(SUM(CASE WHEN SUBSTRING(ticket.ticketEntryDate,1,7) = SUBSTRING('" + currentDate + "',1,7) AND ticket.ticketTicketstatusId =2 THEN 1 ELSE  0 END),0 ) AS todayOpenticket,"
				+ " COALESCE(SUM(CASE WHEN SUBSTRING(ticket.ticketEntryDate,1,10) = SUBSTRING('" + currentDate
				+ "',1,10) AND ticket.ticketTicketstatusId =2 THEN 1 ELSE  0 END),0 ) AS monthOpenticket,"
				+ " (SELECT COUNT(ticketId)"
				+ " FROM AxelaHelpDeskTicket ticket"
				+ " WHERE ticketTicketstatusId NOT IN (3,4,6)"
				+ " AND ticketTrigger = 1"
				+ " AND ticketEmpId = " + empId
				+ ") AS level1ticket,"
				+ " (SELECT COUNT(ticketId)"
				+ " FROM  AxelaHelpDeskTicket ticket"
				+ " WHERE ticketTicketstatusId NOT IN (3,4,6)"
				+ " AND ticketTrigger = 2"
				+ " AND ticketEmpId = " + empId
				+ ") AS level2ticket,"
				+ " (SELECT COUNT(ticketId)"
				+ " FROM AxelaHelpDeskTicket ticket"
				+ " WHERE ticketTicketstatusId NOT IN (3,4,6)"
				+ " AND ticketTrigger = 3"
				+ " AND ticketEmpId  = " + empId
				+ ") AS level3ticket,"
				+ " (SELECT COUNT(ticketId)"
				+ " FROM  AxelaHelpDeskTicket ticket"
				+ " WHERE ticketTicketstatusId NOT IN (3,4,6)"
				+ " AND ticketTrigger = 4"
				+ " AND ticketEmpId  = " + empId
				+ ") AS level4ticket,"
				+ " (SELECT COUNT(ticketId)"
				+ " FROM AxelaHelpDeskTicket ticket"
				+ " WHERE ticketTicketstatusId NOT IN (3,4,6)"
				+ " AND ticketTrigger = 5"
				+ " AND ticketEmpId   = " + empId
				+ ") AS level5ticket)";
		String sqlJoin = " FROM AxelaHelpDeskTicket ticket";
		// if (!branchId.equals("0")) {
		// sqlJoin += " JOIN ticket.axelaBranch ";
		// }
		strSql += sqlJoin;
		strSql += " WHERE 1=1";
		if (empId != 1) {
			strSql += " AND ticket.ticketEmpId=" + empId;
		}
		TypedQuery<AxelaHelpDeskTicket> typedQuery = em.createQuery(strSql, AxelaHelpDeskTicket.class);
		em.clear();
		return typedQuery.getResultList();
	}

	public List<AxelaAccVoucher> findacccountCount(int empId, String currentDate, String branchId) {
		String strSql = "SELECT NEW AxelaAccVoucher("
				+ " COALESCE(SUM(CASE WHEN SUBSTRING(voucher.voucherDate,1,10) =  SUBSTRING('" + currentDate + "',1,10)AND  voucher.voucherVouchertypeId = 6 THEN 1 ELSE  0 END),0 )AS todayinvoices,"
				+ " COALESCE(SUM(CASE WHEN SUBSTRING(voucher.voucherDate,1,10) =  SUBSTRING('" + currentDate + "',1,10)AND  voucher.voucherVouchertypeId  = 9 THEN 1 ELSE  0 END),0 )AS todayreceipts,"
				+ " COALESCE(SUM(CASE WHEN SUBSTRING(voucher.voucherDate,1,7) =  SUBSTRING('" + currentDate + "',1,7)AND  voucher.voucherVouchertypeId = 6 THEN 1 ELSE  0 END),0 )AS monthinvoices,"
				+ " COALESCE(SUM(CASE WHEN SUBSTRING(voucher.voucherDate,1,7) =  SUBSTRING('" + currentDate + "',1,7)AND  voucher.voucherVouchertypeId  = 9 THEN 1 ELSE  0 END),0 )AS monthreceipts,"
				+ " COALESCE(SUM(CASE WHEN SUBSTRING(voucher.voucherDate,1,7) =  SUBSTRING('" + currentDate + "',1,7)AND  voucher.voucherVouchertypeId  = 4 THEN 1 ELSE  0 END),0 )AS monthso,"
				+ " COALESCE(SUM(CASE WHEN SUBSTRING(voucher.voucherDate,1,10) =  SUBSTRING('" + currentDate + "',1,10)AND  voucher.voucherVouchertypeId  = 4 THEN 1 ELSE  0 END),0 )AS todayso,"
				+ " COALESCE(SUM(CASE WHEN(voucher.voucherVouchertypeId =4)THEN 1 ELSE  0 END),0) AS totalso)";
		String sqlJoin = " FROM AxelaAccVoucher voucher";

		if (!branchId.equals("0")) {
			sqlJoin += " JOIN voucher.axelaBranch ";
		}
		strSql += sqlJoin;

		strSql += " WHERE 1=1"
				+ " AND voucher.voucherActive = 1";
		if (empId != 1) {
			strSql += " AND voucher.voucherEmpId=" + empId;
		}
		if (!branchId.equals("0")) {
			strSql += " AND voucher.voucherBranchId =" + branchId;
		}
		TypedQuery<AxelaAccVoucher> typedQuery = em.createQuery(strSql, AxelaAccVoucher.class);
		em.clear();
		return typedQuery.getResultList();
	}

	public List<AxelaPm> findpmCount(int empId, String currentDate, String branchId) {
		String strSql = "SELECT NEW AxelaPm("
				+ " COALESCE(SUM(CASE WHEN SUBSTRING(pm.pmEntryDate,1,7) = SUBSTRING('" + currentDate + "',1,7) THEN 1 ELSE  0 END),0)AS monthPm,"
				+ " COALESCE(SUM(CASE WHEN SUBSTRING(pm.pmEntryDate,1,10) = SUBSTRING('" + currentDate + "',1,10)THEN 1 ELSE  0 END),0) AS todayPm,"
				+ " COALESCE(SUM(CASE WHEN(pm.pmPmstatusId=1)THEN 1 ELSE  0 END),0) AS totalPm)"
				+ " FROM AxelaPm pm";
		TypedQuery<AxelaPm> typedQuery = em.createQuery(strSql, AxelaPm.class);
		em.clear();
		return typedQuery.getResultList();
	}

	public List<AxelaPmTask> findTaskCount(int empId, String currentDate, String branchId) {
		String strSql = "SELECT NEW AxelaPmTask("
				+ " COALESCE(SUM(CASE WHEN SUBSTRING(task.taskEntryDate,1,7) = SUBSTRING('" + currentDate + "',1,7)THEN 1 ELSE  0 END),0) AS monthTask,"
				+ " COALESCE(SUM(CASE WHEN SUBSTRING(task.taskEntryDate,1,10) = SUBSTRING('" + currentDate + "',1,10)THEN 1 ELSE  0 END),0) AS todayTask,"
				+ " COALESCE(SUM(CASE WHEN(task.taskTaskstatusId NOT IN (5,6))THEN 1 ELSE  0 END),0) AS totalTask)";
		// + " COALESCE(SUM(IF(jc_priorityjc_id=1,1,0)),0) AS totalhotjc,"
		// + " (SELECT COUNT(jcId)"
		// + " FROM AxelaServiceJc Jc"
		// + " WHERE jcJcstatusId NOT IN (5,6)"
		// + " AND jcPriorityTrigger = 1"
		// + " AND jcEmpId = " + empId
		// + ") AS level1jc,"
		// + "(SELECT COUNT(jcId)"
		// + " FROM AxelaServiceJc Jc"
		// + " WHERE jcJcstatusId = 1"
		// + " AND jcPriorityTrigger = 2"
		// + " AND jcEmpId = " + empId
		// + ") AS level2jc,"
		// + "(SELECT COUNT(jcId)"
		// + " FROM AxelaServiceJc Jc"
		// + " WHERE jcJcstatusId NOT IN (5,6)"
		// + " AND jcPriorityTrigger = 3"
		// + " AND jcEmpId = " + empId
		// + ") AS level3jc,"
		// + "(SELECT COUNT(jcId)"
		// + " FROM AxelaServiceJc Jc"
		// + " WHERE jcJcstatusId NOT IN (5,6)"
		// + " AND jcPriorityTrigger = 4"
		// + " AND jcEmpId = " + empId
		// + ") AS level4jc,"
		// + "(SELECT COUNT(jcId)"
		// + " FROM AxelaServiceJc Jc"
		// + " WHERE jcJcstatusId NOT IN (5,6)"
		// + " AND jcPriorityTrigger = 5"
		// + " AND jcEmpId = " + empId
		// + ") AS level5jc)";
		String sqlJoin = "FROM AxelaPmTask task";
		strSql += sqlJoin;
		strSql += " WHERE 1=1";
		if (empId != 1) {
			strSql += " AND task.taskEmpId=" + empId;
		}
		TypedQuery<AxelaPmTask> typedQuery = em.createQuery(strSql, AxelaPmTask.class);
		em.clear();
		return typedQuery.getResultList();
	}

}
