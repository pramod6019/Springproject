package axela.helpdesk.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.helpdesk.model.AxelaHelpDeskTicket;
@Repository
public interface TicketRepository extends JpaRepository<AxelaHelpDeskTicket, Integer> {
	// Custom implementation for TicketRepository
	@Transactional
	@Modifying
	@Query("UPDATE"
			+ " AxelaHelpDeskTicket a SET a.ticketRead='1' WHERE a.ticketId=:ticketId")
	public void updateByTicketId(@Param("ticketId") int ticketId);

	@Query("SELECT a FROM AxelaHelpDeskTicket a WHERE ticketId=:ticketId")
	public AxelaHelpDeskTicket findOne(@Param("ticketId") int ticketId);

	@Query("SELECT COALESCE(a.ticketAssetId,'') AS ticketAssetId"
			+ " FROM AxelaHelpDeskTicket a"
			+ " WHERE a.ticketAssetId =:assetId")
	public String findByTicketAssetId(@Param("assetId") int assetId);

	@Query("SELECT COALESCE(ticket.ticketContactId,'') AS ticketContactId"
			+ " FROM AxelaHelpDeskTicket ticket"
			+ " WHERE ticket.ticketContactId =:contactId")
	public String findByTicketContactId(@Param("contactId") int contactId);

	@Query("SELECT ticket.ticketTicketqueueId"
			+ " FROM AxelaHelpDeskTicket ticket"
			+ " WHERE ticketTicketqueueId =:ticketqueueId")
	public String findByTicketQueueId(@Param("ticketqueueId") int ticketqueueId);

	public interface TicketRepositoryFilter {
		// public List<AxelaHelpDeskTicket> populateData(int ticketId, String branchAccess, String exeAccess);
		// public List<AxelaConfig> findAllByPopulateConfig(int ticketEmpId, int empId);

	}

}
