package axela.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.helpdesk.model.AxelaHelpDeskTicketFaq;

@Repository
public interface FaqRepository extends JpaRepository<AxelaHelpDeskTicketFaq, Integer> {

	@Query("SELECT"
			+ " COUNT(a.ticketfaqQuestion)"
			+ " FROM AxelaHelpDeskTicketFaq a"
			+ " WHERE a.ticketfaqQuestion =:ticketfaqQuestion")
	public int findByTicketQuetion(@Param("ticketfaqQuestion") String ticketfaqQuestion);

	@Query("SELECT"
			+ " COUNT(a.ticketfaqQuestion)"
			+ " FROM AxelaHelpDeskTicketFaq a"
			+ " WHERE a.ticketfaqQuestion =:ticketfaqQuestion"
			+ " AND a.ticketfaqId!=:ticketfaqId")
	public String findByTicketId(@Param("ticketfaqQuestion") String ticketfaqQuestion, @Param("ticketfaqId") int ticketfaqId);

}
