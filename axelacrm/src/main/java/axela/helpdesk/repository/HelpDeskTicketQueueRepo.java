package axela.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.helpdesk.model.AxelaHelpDeskTicketQueue;

@Repository
public interface HelpDeskTicketQueueRepo extends JpaRepository<AxelaHelpDeskTicketQueue, Integer> {

	@Query("SELECT"
			+ " a.ticketqueueName"
			+ " FROM AxelaHelpDeskTicketQueue a"
			+ " WHERE a.ticketqueueId=:ticketqueueId")
	public String findByQueue(@Param("ticketqueueId") int ticketqueueId);
}
