package axela.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.helpdesk.model.AxelaHelpDeskTicketType;

@Repository
public interface AxelaTicketTypeRepository extends JpaRepository<AxelaHelpDeskTicketType, Integer> {
	@Query("SELECT a FROM AxelaHelpDeskTicketType a WHERE a.tickettypeId=:id")
	public AxelaHelpDeskTicketType findOne(@Param("id") int id);
}
