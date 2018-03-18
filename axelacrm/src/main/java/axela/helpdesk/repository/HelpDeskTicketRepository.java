package axela.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.helpdesk.model.AxelaHelpDeskTicket;
@Repository
public interface HelpDeskTicketRepository extends JpaRepository<AxelaHelpDeskTicket, Integer> {

	@Query("SELECT"
			+ " COUNT(a.ticketCustomerId)"
			+ " FROM AxelaHelpDeskTicket a"
			+ " WHERE a.ticketCustomerId=:customerId")
	public int findById(@Param("customerId") int customerId);

	@Query("SELECT"
			+ " a.ticketId"
			+ " FROM AxelaHelpDeskTicket a"
			+ " WHERE a.ticketId=:ticketId")
	public int findByOne(@Param("ticketId") int ticketId);

	@Query("SELECT"
			+ " a.ticketRefno"
			+ " FROM AxelaHelpDeskTicket a"
			+ " WHERE 1=1"
			+ " AND a.ticketRefno = :ticketRefNo")
	public String findByTicketRefNo(@Param("ticketRefNo") String ticketRefNo);

	@Query("SELECT"
			+ " COUNT(a.ticketEmpId)"
			+ " FROM AxelaHelpDeskTicket a"
			+ " WHERE a.ticketEmpId=:empId")
	public int findByTicketId(@Param("empId") int empId);

}
