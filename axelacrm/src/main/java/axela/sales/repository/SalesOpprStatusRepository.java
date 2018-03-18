package axela.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import axela.customer.model.AxelaSalesOpprStatus;

public interface SalesOpprStatusRepository extends JpaRepository<AxelaSalesOpprStatus, Integer> {

	@Query("SELECT status.statusName "
			+ " FROM AxelaSalesOpprStatus status"
			+ " ORDER BY status.statusId")
	public List<String> findStatusName();

	@Query("SELECT status.statusName "
			+ " FROM AxelaSalesOpprStatus status"
			+ " WHERE status.statusId!=2"
			+ " ORDER BY status.statusId")
	public List<String> findStatus();

	List<AxelaSalesOpprStatus> findByStatusId(int statusId);
}
