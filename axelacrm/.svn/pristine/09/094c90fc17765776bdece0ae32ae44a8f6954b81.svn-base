package axela.helpdesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.helpdesk.model.AxelaHelpDeskTicketPriority;
@Repository
public interface HelpDeskTicketPriorityRepository extends JpaRepository<AxelaHelpDeskTicketPriority, Integer> {

	@Query("SELECT"
			+ " a.priorityticketId,"
			+ " a.priorityticketName "
			+ " FROM AxelaHelpDeskTicketPriority a"
			+ " WHERE 1 = 1 "
			+ " GROUP BY a.priorityticketId"
			+ " ORDER BY a.priorityticketName")
	public List<Object[]> findByTicketPriority();

	@Query("Select"
			+ " a.priorityticketName"
			+ " FROM AxelaHelpDeskTicketPriority a"
			+ " WHERE a.priorityticketId=:priorityticketId")
	public String findByPriorityId(@Param("priorityticketId") int priorityticketId);

}
