package axela.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.helpdesk.model.AxelaHelpDeskTicketStatus;

public interface HelpDeskTicketStatusRepository extends JpaRepository<AxelaHelpDeskTicketStatus, Integer> {

	@Query("SELECT"
			+ " a.ticketstatusName"
			+ " FROM AxelaHelpDeskTicketStatus a"
			+ " WHERE a.ticketstatusId=:ticketstatusId")
	public String findByStatus(@Param("ticketstatusId") int ticketstatusId);

	@Query("SELECT status.ticketstatusRank FROM AxelaHelpDeskTicketStatus status WHERE 1=1 AND status.ticketstatusId=:ticketstatusId ")
	public Integer findRankfromTickettypeId(@Param("ticketstatusId") int ticketstatusId);

	@Query("SELECT MAX(status.ticketstatusRank) as max1 FROM AxelaHelpDeskTicketStatus status WHERE 1=1 ")
	public Integer findMaxRank();

	@Query("SELECT MIN(status.ticketstatusRank) as min1 FROM AxelaHelpDeskTicketStatus status WHERE 1=1 ")
	public Integer findMinRank();
}
