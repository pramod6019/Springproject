package axela.helpdesk.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.helpdesk.model.AxelaHelpDeskTicketQueue;

@Repository
@Transactional(readOnly = true)
public class TicketQueueFilterImpl {

	@PersistenceContext
	EntityManager em;
	// EntityTransaction updateoperation = null;
	public static String totalCount = "0";
	public static int listLength = 0;
	String countSql = "";

	public List<AxelaHelpDeskTicketQueue> findAllReportOpenQueue(String exeAccess, int currYear, int currMonth, int currDate, HttpSession session)
	{
		String Query = "SELECT NEW AxelaHelpDeskTicketQueue("
				+ " Queue.ticketqueueId,"
				+ " Queue.ticketqueueName,"
				+ " COUNT(Queue.axelaHelpDeskTicket.ticketId)  AS ticketCount)"
				+ " FROM AxelaHelpDeskTicketQueue Queue "
				+ " LEFT JOIN Queue.axelaHelpDeskTicket "
				+ " LEFT JOIN Queue.axelaHelpDeskTicket.axelaEmp "
				+ " WHERE 1=1 "
				+ " AND Queue.axelaHelpDeskTicket.ticketTicketstatusId !=3 "
				+ exeAccess
				+ " GROUP BY Queue.ticketqueueId "
				+ " ORDER BY Queue.ticketqueueName";
		TypedQuery<AxelaHelpDeskTicketQueue> typedQuery = em.createQuery(Query, AxelaHelpDeskTicketQueue.class);
		listLength = em.createQuery(Query, AxelaHelpDeskTicketQueue.class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}

	public List<AxelaHelpDeskTicketQueue> findTicketQueue(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaHelpDeskTicketQueue> typedQuery = new ArrayList<AxelaHelpDeskTicketQueue>();
		String strSql = "SELECT NEW AxelaHelpDeskTicketQueue("
				+ " queue.ticketqueueId,"
				+ " queue.ticketqueueDesc,"
				+ " queue.ticketqueueName,"
				+ " queue.ticketqueueRank)";

		sqlJoin += " FROM AxelaHelpDeskTicketQueue queue"
				+ " WHERE 1=1"
				+ strSearch;

		countSql = " SELECT COUNT(DISTINCT queue.ticketqueueId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY queue.ticketqueueId "
					+ strOrderBy;
			typedQuery = em.createQuery(strSql, AxelaHelpDeskTicketQueue.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return typedQuery;
	}
}
