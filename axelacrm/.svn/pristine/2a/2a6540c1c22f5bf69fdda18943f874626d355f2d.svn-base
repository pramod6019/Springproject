package axela.helpdesk.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.helpdesk.model.AxelaHelpDeskTicketHoli;
import axela.helpdesk.repository.HelpDeskTicketHoliRepository.TicketHoliRepositoryFilter;

@Repository
@Transactional(readOnly = true)
public class ServiceTicketHoliImpl extends Connect implements TicketHoliRepositoryFilter {
	public static int listLength = 0;

	@PersistenceContext
	EntityManager em;

	public List<AxelaHelpDeskTicketHoli> findAllHoli(String strSearch, int page, int perpage) {
		String Query = "SELECT New AxelaHelpDeskTicketHoli("
				+ " a.ticketholiId,"
				+ " COALESCE(a.ticketholiName,'') AS ticketholiName,"
				+ " COALESCE(a.axelaBranch.branchId,0) AS branchId ,"
				+ " COALESCE(a.ticketholiDate,'') AS ticketholiDate,"
				+ " COALESCE(CONCAT(a.axelaBranch.branchName, ' (',a.axelaBranch.branchCode, ')'),'') AS branchname)"
				+ " FROM AxelaHelpDeskTicketHoli a"
				+ " INNER JOIN a.axelaBranch"
				+ " WHERE 1 = 1 "
				+ " GROUP BY a.ticketholiId " + strSearch;
		TypedQuery<AxelaHelpDeskTicketHoli> typedQuery = em.createQuery(Query, AxelaHelpDeskTicketHoli.class).setFirstResult((page - 1) * perpage).setMaxResults(perpage);
		listLength = em.createQuery(Query, AxelaHelpDeskTicketHoli.class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();

	}
}
