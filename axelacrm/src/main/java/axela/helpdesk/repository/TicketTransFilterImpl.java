package axela.helpdesk.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.helpdesk.model.AxelaHelpDeskTicketTran;
import axela.helpdesk.repository.HelpDeskTicketTransRepo.TicketTransFilter;

@Repository
@Transactional(readOnly = true)
public class TicketTransFilterImpl extends Connect implements TicketTransFilter {
	public static int listlength = 0;
	@PersistenceContext
	EntityManager em;

	public List<AxelaHelpDeskTicketTran> listFollowUpData(int ticketId) {
		SOP("coming ind");
		String query = "SELECT NEW AxelaHelpDeskTicketTran("
				+ " a.axelaHelpDeskTicket.ticketId,"
				+ " a.tickettransId,"
				+ " a.axelaHelpDeskTicket.ticketCustomerId,"
				+ " a.axelaHelpDeskTicket.ticketReportTime,"
				+ " a.tickettransFollowup,"
				+ " a.tickettransNextfollowupTime,"
				+ " a.tickettransPrivate,"
				+ " (case when a.tickettransPrivate='1' then 'Yes' else 'No' end) AS private,"
				+ " a.tickettransEntryId,"
				+ " COALESCE(CONCAT(e.empName, '(', e.empRefNo, ')'),'') AS entryBy,"
				+ " a.tickettransEntryDate, "
				+ " a.tickettransModifiedId,"
				+ " COALESCE(CONCAT(m.empName, '(', m.empRefNo, ')'),'') AS modifiedBy,"
				+ " a.tickettransModifiedDate, "
				+ " COALESCE(a.axelaHelpDeskTicket.axelaCustomer.customerName,'') AS customerName,"
				+ " a.tickettransContactEntryId,"
				+ " a.axelaHelpDeskTicket.axelaCustomer.customerId)"
				+ " FROM AxelaHelpDeskTicketTran a"
				+ " INNER JOIN a.axelaHelpDeskTicket"
				+ " LEFT JOIN a.axelaEmp e"
				+ " LEFT JOIN a.axelaEmpp m"
				+ " LEFT JOIN a.axelaHelpDeskTicket.axelaCustomer"
				// + " left JOIN axelaCustomerContact ON contactId=tickettransContactEntryId "
				+ " WHERE a.tickettransTicketId='" + ticketId + "'"
				+ " ORDER BY a.tickettransId DESC";
		SOP("query=================" + query);
		TypedQuery<AxelaHelpDeskTicketTran> typed = em.createQuery(query, AxelaHelpDeskTicketTran.class);
		em.clear();
		return typed.getResultList();
	}

}
