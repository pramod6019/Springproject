package axela.service.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.helpdesk.model.AxelaHelpDeskTicketFaqService;
import axela.helpdesk.repository.HelpDeskTicketFaqServiceRepository.CatagoriesFilterRepository;
import axela.portal.model.AxelaBranch;

@Repository
@Transactional(readOnly = true)
public class CatagoriesFilterImpl extends Connect implements CatagoriesFilterRepository {
	@PersistenceContext
	EntityManager em;
	public static int listLength = 0;

	public List<AxelaBranch> findAllByBranch(String branchAccess) {
		Query query = em.createQuery("SELECT a FROM AxelaBranch a WHERE a.branchActive = '1' " + branchAccess);
		return (List<AxelaBranch>) query.getResultList();
	}

	public List<AxelaHelpDeskTicketFaqService> findAllCaragories(String strSearch, int page, int perpage) {
		String Query = "SELECT NEW AxelaServiceTicketFaqService("
				+ " a.faqserviceId,"
				+ " a.faqserviceName,"
				+ " a.axelaServiceTicketQueue.ticketqueueName,"
				+ " (SELECT COUNT(a.faqserviceId)"
				+ " FROM AxelaServiceTicketFaqService a) AS faqserviceCount)"
				+ " FROM AxelaServiceTicketFaqService a"
				+ " JOIN a.axelaServiceTicketQueue "
				+ " WHERE 1=1 " + strSearch;
		TypedQuery<AxelaHelpDeskTicketFaqService> typedQuery = em.createQuery(Query, AxelaHelpDeskTicketFaqService.class).setFirstResult((page - 1) * perpage).setMaxResults(perpage);
		listLength = em.createQuery(Query, AxelaHelpDeskTicketFaqService.class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}
	// end campaign list

}
