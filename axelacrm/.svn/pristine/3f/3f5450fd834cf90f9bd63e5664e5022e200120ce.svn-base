package axela.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import axela.sales.model.AxelaSalesOpprLostcase1;

@Repository
public interface SalesLostCase1Repository extends JpaRepository<AxelaSalesOpprLostcase1, Integer> {

	// @Query("SELECT"
	// + " a.ticketstatusId,"
	// + " a.ticketstatusName "
	// + " FROM AxelaServiceTicketStatus a"
	// + " WHERE 1 = 1 "
	// + " GROUP BY a.ticketstatusId"
	// + " ORDER BY a.ticketstatusName")
	// public List<Object[]> findByTicketStatusId();

	@Query(value = "SELECT "
			+ " a.lostcase1Id,"
			+ " a.lostcase1Name "
			+ " FROM AxelaSalesOpprLostcase1 a"
			+ " WHERE 1 = 1 "
			+ " GROUP BY a.lostcase1Id"
			+ " ORDER BY a.lostcase1Name")
	List<Object[]> findByLastCase1();

}
