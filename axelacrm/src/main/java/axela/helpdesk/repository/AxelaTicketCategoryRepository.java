package axela.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.helpdesk.model.AxelaHelpDeskTicketCat;

@Repository
public interface AxelaTicketCategoryRepository extends JpaRepository<AxelaHelpDeskTicketCat, Integer> {

	@Query("SELECT a FROM AxelaHelpDeskTicketCat a WHERE a.ticketcatId=:id")
	public AxelaHelpDeskTicketCat findOne(@Param("id") int id);
}
