package axela.helpdesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.helpdesk.model.AxelaHelpDeskTicketType;
@Repository
public interface HelpDeskTicketTypeRepository extends JpaRepository<AxelaHelpDeskTicketType, Integer> {
	@Query("SELECT"
			+ " a.tickettypeId,"
			+ " a.tickettypeName "
			+ " FROM AxelaHelpDeskTicketType a"
			+ " WHERE 1 = 1 "
			+ " GROUP BY a.tickettypeId"
			+ " ORDER BY a.tickettypeName")
	public List<Object[]> findByTicketTypeId();

	@Query("SELECT"
			+ " a.tickettypeName"
			+ " FROM AxelaHelpDeskTicketType a"
			+ " WHERE a.tickettypeId=:tickettypeId")
	public String findByType(@Param("tickettypeId") int tickettypeId);
}
