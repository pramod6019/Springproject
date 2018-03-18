package axela.helpdesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.helpdesk.model.AxelaHelpDeskTicketStatus;

@Repository
public interface AxelaTicketStatusRepository extends JpaRepository<AxelaHelpDeskTicketStatus, Integer> {

	@Query("SELECT a FROM AxelaHelpDeskTicketStatus a WHERE a.ticketstatusId=:id")
	public List<AxelaHelpDeskTicketStatus> findAll(@Param("id") int id);

	@Query("SELECT a FROM AxelaHelpDeskTicketStatus a WHERE a.ticketstatusName=:ticketstatusName")
	public List<AxelaHelpDeskTicketStatus> findByticketstatusName(@Param("ticketstatusName") String ticketstatusName);

	@Query("SELECT (COALESCE(max(a.ticketstatusRank),0)+1)  FROM  AxelaHelpDeskTicketStatus   a WHERE 1=1")
	public Integer findrank();

	@Query("SELECT"
			+ " a.ticketstatusId,"
			+ " a.ticketstatusName "
			+ " FROM AxelaHelpDeskTicketStatus a"
			+ " WHERE 1 = 1 "
			+ " GROUP BY a.ticketstatusId"
			+ " ORDER BY a.ticketstatusName")
	public List<Object[]> findByTicketStatusId();

}
