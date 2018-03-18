package axela.helpdesk.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.helpdesk.model.AxelaHelpdeskTicketDoc;

public interface HelpDeskTicketDocRepository extends JpaRepository<AxelaHelpdeskTicketDoc, Integer> {

	@Transactional
	@Modifying
	@Query("DELETE FROM AxelaHelpdeskTicketDoc a"
			+ " WHERE a.docTicketId =:ticketId ")
	public void deleteByDocTicketId(@Param("ticketId") int ticketId);

	@Query("SELECT doc.docId,"
			+ " COALESCE(OCTET_LENGTH(doc.docData), 0) AS docData,"
			+ " doc.docValue,"
			+ " doc.docTitle,"
			+ " doc.docRemarks "
			+ " FROM AxelaHelpdeskTicketDoc doc "
			+ " WHERE doc.docTicketId =:ticketId ")
	List<Object[]> findJobCardDocs(@Param("ticketId") int ticketId);
}
