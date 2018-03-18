package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.sales.model.AxelaSalesOpprPriority;

@Repository
public interface SalesPriorityRepository extends JpaRepository<AxelaSalesOpprPriority, Integer> {
	@Query("SELECT (COALESCE(MAX(a.priorityopprRank),0)+1) FROM AxelaSalesOpprPriority  a WHERE 1=1 ")
	public Integer findrank();

	public AxelaSalesOpprPriority findByPriorityopprId(int parseInt);

	@Query("SELECT"
			+ " (COALESCE(MAX(a.priorityopprId),0)) AS priorityopprId"
			+ " FROM AxelaSalesOpprPriority a"
			+ " WHERE a.priorityopprId=:priorityopprId")
	public int findByOpprPriorityopprId(@Param("priorityopprId") int priorityopprId);

	public List<AxelaSalesOpprPriority> findByPriorityopprName(String priorityopprName);

	@Query("SELECT a.priorityopprId, a.priorityopprName FROM AxelaSalesOpprPriority a ")
	List<Object[]> findByPriorityName();

	@Query("SELECT priority.priorityopprId,priority.priorityopprName FROM AxelaSalesOpprPriority priority WHERE 1=1 AND priority.priorityopprId !=:priorityopprId AND priority.priorityopprName=:priorityopprName")
	public List<AxelaSalesOpprPriority> findPriorityopprName(@Param("priorityopprId") int priorityopprId, @Param("priorityopprName") String priorityopprName);

	@Query("SELECT priority.priorityopprRank FROM AxelaSalesOpprPriority priority WHERE 1=1 AND priority.priorityopprId=:priorityopprId ")
	public Integer findRankfromPriorityId(@Param("priorityopprId") int priorityopprId);

	@Query("SELECT MIN(priority.priorityopprRank) as min1 FROM AxelaSalesOpprPriority priority WHERE 1=1 ")
	public Integer findMinRank();

	@Query("SELECT MAX(priority.priorityopprRank) as max1 FROM AxelaSalesOpprPriority priority WHERE 1=1 ")
	public Integer findMaxRank();
}
