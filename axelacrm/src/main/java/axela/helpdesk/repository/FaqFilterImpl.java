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
import axela.helpdesk.model.AxelaHelpDeskTicketFaq;
@Repository
@Transactional(readOnly = true)
public class FaqFilterImpl extends Connect {
	@PersistenceContext
	EntityManager em;
	public static String totalCount = "0";
	public static int listLength = 0;

	public List<AxelaHelpDeskTicketFaq> findAllpopulate(String strSearch) {
		String sqlJoin = "";
		String countSql = "";
		TypedQuery<AxelaHelpDeskTicketFaq> typedQuery = null;

		String strSql = "SELECT NEW AxelaHelpDeskTicketFaq("
				+ "ticketFaq.ticketfaqId, "
				+ " ticketFaq.ticketfaqQuestion, "
				+ " ticketFaq.ticketfaqAnswer, "
				+ " ticketFaq.ticketfaqActive, "
				+ " ticketFaq.ticketfaqFaqserviceId,"
				+ " faqService.faqserviceTicketqueueId,"
				+ " faqService.faqserviceName , "
				+ " faqService.axelaHelpDeskTicketQueue.ticketqueueName,"
				+ " ticketFaq.ticketfaqEntryId,"
				+ " ticketFaq.ticketfaqEntryDate,"
				+ " ticketFaq.ticketfaqModifiedId,"
				+ " ticketFaq.ticketfaqModifiedDate)";

		sqlJoin += " FROM AxelaHelpDeskTicketFaq  ticketFaq "
				+ " JOIN ticketFaq.axelaHelpDeskTicketFaqService faqService"
				+ " JOIN faqService.axelaHelpDeskTicketQueue "
				+ " WHERE 1=1 "
				+ strSearch;

		strSql += sqlJoin
				+ strSearch
				+ " GROUP BY ticketFaq.ticketfaqId ";
		typedQuery = em.createQuery(strSql, AxelaHelpDeskTicketFaq.class);// .setFirstResult((page - 1) * perPage).setMaxResults(perPage);
		em.close();
		return typedQuery.getResultList();
	}

	public List<AxelaHelpDeskTicketFaq> findFaqDetails(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaHelpDeskTicketFaq> typedQuery = new ArrayList<AxelaHelpDeskTicketFaq>();

		String strSql = "SELECT NEW AxelaHelpDeskTicketFaq("
				+ " ticketFaq.ticketfaqId,"
				+ " ticketFaq.ticketfaqActive,"
				+ " ticketFaq.ticketfaqQuestion,"
				+ " ticketFaq.ticketfaqAnswer,"
				+ " faqService.faqserviceName,"
				+ " faqService.axelaHelpDeskTicketQueue.ticketqueueName)";

		sqlJoin += " FROM AxelaHelpDeskTicketFaq  ticketFaq "
				+ " JOIN ticketFaq.axelaHelpDeskTicketFaqService faqService"
				+ " JOIN faqService.axelaHelpDeskTicketQueue "
				+ " WHERE 1=1 "
				+ strSearch;

		countSql = "SELECT COUNT(DISTINCT ticketFaq.ticketfaqId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ strSearch
					+ " GROUP BY ticketFaq.ticketfaqId "
					+ strOrderBy;
			typedQuery = em.createQuery(strSql, AxelaHelpDeskTicketFaq.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return typedQuery;
	}
	public List<AxelaHelpDeskTicketFaq> findFaqSummary(String strSearch, HttpSession session)
	{
		String Query = "SELECT NEW AxelaHelpDeskTicketFaq("
				+ " (SELECT COUNT(faq.ticketfaqId)"
				+ " FROM AxelaHelpDeskTicketFaq faq"
				+ " WHERE 1=1"
				+ strSearch
				+ ") AS total,"
				+ " (SELECT COUNT(faq.ticketfaqId)"
				+ " FROM AxelaHelpDeskTicketFaq faq"
				+ " WHERE faq.ticketfaqActive = '1'"
				+ strSearch
				+ ") AS active,"
				+ " (SELECT COUNT(faq.ticketfaqId)"
				+ " FROM AxelaHelpDeskTicketFaq faq"
				+ " WHERE faq.ticketfaqActive = '0'"
				+ strSearch
				+ ") AS inactive)"
				+ " FROM AxelaHelpDeskTicketFaq faq"
				+ " WHERE 1 = 1";
		TypedQuery<AxelaHelpDeskTicketFaq> typedQuery = em.createQuery(Query, AxelaHelpDeskTicketFaq.class);
		listLength = em.createQuery(Query, AxelaHelpDeskTicketFaq.class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}
}
