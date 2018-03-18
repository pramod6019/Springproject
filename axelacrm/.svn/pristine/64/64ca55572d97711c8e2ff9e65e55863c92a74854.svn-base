package axela.helpdesk.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.helpdesk.model.AxelaHelpDeskTicketTran;

@Repository
public interface HelpDeskTicketTransRepo extends JpaRepository<AxelaHelpDeskTicketTran, Integer> {

	@Transactional
	@Modifying
	@Query("DELETE FROM AxelaHelpDeskTicketTran a"
			+ " WHERE a.tickettransTicketId =:ticketId ")
	public void deleteByTickettransTicketId(@Param("ticketId") int ticketId);

	public interface TicketTransFilter {
		public List<AxelaHelpDeskTicketTran> listFollowUpData(int ticketId);
	}

}
