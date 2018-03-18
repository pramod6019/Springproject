package axela.helpdesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.helpdesk.model.AxelaHelpDeskTicketQueue;

@Repository
public interface AxelaTicketQueueRepository extends JpaRepository<AxelaHelpDeskTicketQueue, Integer> {

	@Query("SELECT a FROM AxelaHelpDeskTicketQueue a WHERE a.ticketqueueId=:id")
	public List<AxelaHelpDeskTicketQueue> findAll(@Param("id") int id);

	@Query("SELECT"
			+ " (COALESCE(MAX(Queue.ticketqueueName),''))"
			+ " FROM AxelaHelpDeskTicketQueue Queue"
			+ " WHERE Queue.ticketqueueName=:ticketqueueName")
	public String findByticketqueueName(@Param("ticketqueueName") String ticketqueueName);

	@Query("SELECT "
			+ " (COALESCE(MAX(Queue.ticketqueueName),''))"
			+ " FROM AxelaHelpDeskTicketQueue Queue"
			+ " WHERE 1=1"
			+ " AND Queue.ticketqueueId!=:ticketqueueId"
			+ " AND Queue.ticketqueueName=:ticketqueueName")
	public String findByNameAndId(@Param("ticketqueueId") int ticketqueueId, @Param("ticketqueueName") String ticketqueueName);

	@Query("SELECT (COALESCE(max(a.ticketqueueRank),0)+1)  FROM  AxelaHelpDeskTicketQueue   a WHERE 1=1")
	public Integer findRank();

	@Query("SELECT Queue.ticketqueueRank"
			+ " FROM AxelaHelpDeskTicketQueue Queue"
			+ " WHERE 1=1 AND Queue.ticketqueueId=:ticketqueueId ")
	Integer findRankfromTicketQueueId(@Param("ticketqueueId") int ticketqueueId);

	@Query("SELECT MIN(Queue.ticketqueueRank)"
			+ " AS min1 FROM AxelaHelpDeskTicketQueue Queue"
			+ " WHERE 1=1 ")
	Integer findMinRank();

	@Query("SELECT MAX(Queue.ticketqueueRank) as max1 FROM AxelaHelpDeskTicketQueue Queue WHERE 1=1 ")
	Integer findMaxRank();

	@Query("SELECT NEW AxelaHelpDeskTicketQueue("
			+ " a.ticketqueueDuehrs,"
			+ " a.ticketqueueBusinessHrs,"
			+ " a.ticketqueueStarttime,"
			+ " a.ticketqueueEndtime,"
			+ " a.ticketqueueSun,"
			+ " a.ticketqueueMon,"
			+ " a.ticketqueueTue,"
			+ " a.ticketqueueWed,"
			+ " a.ticketqueueThu,"
			+ " a.ticketqueueFri,"
			+ " a.ticketqueueSat,"
			+ " a.ticketqueueTrigger1Hrs,"
			+ " a.ticketqueueTrigger2Hrs,"
			+ " a.ticketqueueTrigger3Hrs,"
			+ " a.ticketqueueTrigger4Hrs,"
			+ " a.ticketqueueTrigger5Hrs)"
			+ " FROM AxelaHelpDeskTicketQueue a"
			+ " WHERE ticketqueueId=:ticketTicketqueueId")
	public AxelaHelpDeskTicketQueue findBYTicketQueueId(@Param("ticketTicketqueueId") int ticketTicketqueueId);

	@Query("SELECT"
			+ " a.ticketqueueId,"
			+ " a.ticketqueueName"
			+ " FROM AxelaHelpDeskTicketQueue a"
			+ " WHERE 1 = 1"
			+ " GROUP BY a.ticketqueueId"
			+ " ORDER BY a.ticketqueueName")
	public List<Object[]> findByQueue();

	@Query("SELECT NEW AxelaHelpDeskTicketQueue("
			+ " queue.ticketqueueName,"
			+ " queue.ticketqueueDesc,"
			+ " queue.ticketqueueDuehrs,"
			+ " queue.ticketqueueTrigger1Hrs,"
			+ " queue.ticketqueueTrigger2Hrs,"
			+ " queue.ticketqueueTrigger3Hrs,"
			+ " queue.ticketqueueTrigger4Hrs,"
			+ " queue.ticketqueueTrigger5Hrs,"
			+ " queue.ticketqueueBusinessHrs,"
			+ " queue.ticketqueueStarttime,"
			+ " queue.ticketqueueEndtime,"
			+ " queue.ticketqueueSun,"
			+ " queue.ticketqueueMon,"
			+ " queue.ticketqueueTue,"
			+ " queue.ticketqueueWed,"
			+ " queue.ticketqueueThu,"
			+ " queue.ticketqueueFri,"
			+ " queue.ticketqueueSat,"
			+ " queue.ticketqueueEntryId,"
			+ " queue.ticketqueueEntryDate,"
			+ " queue.ticketqueueModifiedId,"
			+ " queue.ticketqueueModifiedDate)"
			+ " FROM AxelaHelpDeskTicketQueue queue"
			+ " WHERE queue.ticketqueueId =:ticketqueueId")
	public List<AxelaHelpDeskTicketQueue> populateData(@Param("ticketqueueId") int ticketqueueId);
}
