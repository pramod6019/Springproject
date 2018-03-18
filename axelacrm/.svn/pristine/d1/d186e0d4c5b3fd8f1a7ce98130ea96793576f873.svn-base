package axela.helpdesk.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.helpdesk.model.AxelaHelpDeskTicketCat;
@Repository
public interface HelpDeskTicketCatRepository extends JpaRepository<AxelaHelpDeskTicketCat, Integer> {

	@Query("SELECT"
			+ " a.ticketcatId,"
			+ " a.ticketcatName "
			+ " FROM AxelaHelpDeskTicketCat a "
			+ " WHERE 1 = 1 "
			+ " GROUP BY a.ticketcatId"
			+ " ORDER BY a.ticketcatName")
	public List<AxelaHelpDeskTicketCat> findTicketcatId();

	@Query("SELECT"
			+ " a.ticketcatName"
			+ " FROM AxelaHelpDeskTicketCat a"
			+ " WHERE a.ticketcatId=:ticketcatId")
	public String findByTicketCatId(@Param("ticketcatId") int ticketcatId);

	@Query("SELECT"
			+ " a.ticketcatId,"
			+ " a.ticketcatName "
			+ " FROM AxelaHelpDeskTicketCat a"
			+ " WHERE 1 = 1 "
			+ " GROUP BY a.ticketcatId"
			+ " ORDER BY a.ticketcatName")
	public List<Object[]> findByTicketcatttId();

	@Modifying
	@Transactional
	public List<AxelaHelpDeskTicketCat> findByTicketcatId(int i);

}
