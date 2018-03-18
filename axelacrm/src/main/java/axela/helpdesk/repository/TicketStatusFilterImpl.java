package axela.helpdesk.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.helpdesk.model.AxelaHelpDeskTicketStatus;

@Repository
@Transactional(readOnly = true)
public class TicketStatusFilterImpl extends Connect {

	@PersistenceContext
	EntityManager em;
	// EntityTransaction updateoperation = null;
	public static String totalCount = "0";
	public static int listLength = 0;
	String countSql = "";

	public List<AxelaHelpDeskTicketStatus> findAllTicketStatus(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaHelpDeskTicketStatus> typedQuery = new ArrayList<AxelaHelpDeskTicketStatus>();

		String strSql = "SELECT NEW AxelaHelpDeskTicketStatus("
				+ " status.ticketstatusId,"
				+ " status.ticketstatusEntryDate,"
				+ " status.ticketstatusEntryId,"
				+ " status.ticketstatusModifiedDate,"
				+ " status.ticketstatusModifiedId,"
				+ " status.ticketstatusName,"
				+ " status.ticketstatusRank)";

		sqlJoin += " FROM AxelaHelpDeskTicketStatus status"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT status.ticketstatusId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY status.ticketstatusId "
					+ strOrderBy;
			typedQuery = em.createQuery(strSql, AxelaHelpDeskTicketStatus.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return typedQuery;
	}
	public List<AxelaHelpDeskTicketStatus> findAllReportTime(String exeAccess, int currYear, int currMonth, int currDate, HttpSession session)
	{
		String Query = "SELECT NEW AxelaHelpDeskTicketStatus("
				+ " status.ticketstatusId,"
				+ " status.ticketstatusName,"
				+ " COUNT(status.axelaHelpDeskTicket.ticketId)  AS ticketCount)"
				+ " FROM AxelaHelpDeskTicketStatus status "
				+ " LEFT JOIN status.axelaHelpDeskTicket "
				+ " LEFT JOIN status.axelaHelpDeskTicket.axelaEmp "
				+ " WHERE 1=1 "
				+ " AND SUBSTRING(status.axelaHelpDeskTicket.ticketReportTime,1,10)= '" + currYear + "-" + doublenum(currMonth + 1) + "-" + doublenum(currDate) + "'"
				+ exeAccess
				+ " GROUP BY status.ticketstatusId "
				+ " ORDER BY status.ticketstatusName";
		TypedQuery<AxelaHelpDeskTicketStatus> typedQuery = em.createQuery(Query, AxelaHelpDeskTicketStatus.class);
		listLength = em.createQuery(Query, AxelaHelpDeskTicketStatus.class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}

	public List<AxelaHelpDeskTicketStatus> findAllClosedTime(String exeAccess, int currYear, int currMonth, int currDate, HttpSession session)
	{
		String Query = "SELECT NEW AxelaHelpDeskTicketStatus("
				+ " status.ticketstatusId,"
				+ " status.ticketstatusName,"
				+ " COUNT(status.axelaHelpDeskTicket.ticketId)  AS ticketCount)"
				+ " FROM AxelaHelpDeskTicketStatus status "
				+ " LEFT JOIN status.axelaHelpDeskTicket "
				+ " LEFT JOIN status.axelaHelpDeskTicket.axelaEmp "
				+ " WHERE 1=1 "
				+ " AND SUBSTRING(status.axelaHelpDeskTicket.ticketClosedTime,1,10)= '" + currYear + "-" + doublenum(currMonth + 1) + "-" + doublenum(currDate) + "'"
				+ exeAccess
				+ " GROUP BY status.ticketstatusId "
				+ " ORDER BY status.ticketstatusName";
		TypedQuery<AxelaHelpDeskTicketStatus> typedQuery = em.createQuery(Query, AxelaHelpDeskTicketStatus.class);
		listLength = em.createQuery(Query, AxelaHelpDeskTicketStatus.class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}

	public List<AxelaHelpDeskTicketStatus> findAllReportOpen(String exeAccess, int currYear, int currMonth, int currDate, HttpSession session)
	{
		String Query = "SELECT NEW AxelaHelpDeskTicketStatus("
				+ " status.ticketstatusId,"
				+ " status.ticketstatusName,"
				+ " COUNT(status.axelaHelpDeskTicket.ticketId)  AS ticketCount)"
				+ " FROM AxelaHelpDeskTicketStatus status "
				+ " LEFT JOIN status.axelaHelpDeskTicket "
				+ " LEFT JOIN status.axelaHelpDeskTicket.axelaEmp "
				+ " WHERE 1=1 "
				+ " AND status.axelaHelpDeskTicket.ticketTicketstatusId !=3 "
				+ exeAccess
				+ " GROUP BY status.ticketstatusId "
				+ " ORDER BY status.ticketstatusName";
		TypedQuery<AxelaHelpDeskTicketStatus> typedQuery = em.createQuery(Query, AxelaHelpDeskTicketStatus.class);
		listLength = em.createQuery(Query, AxelaHelpDeskTicketStatus.class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}
}
