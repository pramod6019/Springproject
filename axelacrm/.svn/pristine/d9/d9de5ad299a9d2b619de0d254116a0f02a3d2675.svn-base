package axela.helpdesk.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.helpdesk.model.AxelaHelpDeskTicketHoli;

@Repository
public interface HelpDeskTicketHoliRepository extends JpaRepository<AxelaHelpDeskTicketHoli, Integer> {

	@Query("SELECT holi.ticketholiName, holi.ticketholiDate"
			+ " FROM AxelaHelpDeskTicketHoli holi"
			+ " WHERE holi.ticketholiName =:ticketholiName "
			+ " AND holi.ticketholiDate =:ticketholiDate"
			+ " AND holi.ticketholiId !=:ticketholiId")
	public List<AxelaHelpDeskTicketHoli> findTicketHoliNameAndDate(@Param("ticketholiName") String ticketholiName, @Param("ticketholiDate") Date ticketholiDate,
			@Param("ticketholiId") int ticketholiId);

	public interface TicketHoliRepositoryFilter {
		public List<AxelaHelpDeskTicketHoli> findAllHoli(String strSearch, int page, int perpage);
	}

}
