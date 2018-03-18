package axela.helpdesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.helpdesk.model.AxelaHelpDeskTicketSource;
@Repository
public interface HelpDeskTicketSourceRepository extends JpaRepository<AxelaHelpDeskTicketSource, Integer> {
	@Query("SELECT"
			+ " a.ticketsourceId,"
			+ " a.ticketsourceName "
			+ " FROM AxelaHelpDeskTicketSource a"
			+ " WHERE 1 = 1 "
			+ " GROUP BY a.ticketsourceId"
			+ " ORDER BY a.ticketsourceName")
	public List<Object[]> findByTicketsourceId();

	@Query("SELECT"
			+ " a.ticketsourceName"
			+ " FROM AxelaHelpDeskTicketSource a"
			+ " WHERE a.ticketsourceId=:ticketsourceId")
	public String findByTicketSourceName(@Param("ticketsourceId") int ticketsourceId);
}
