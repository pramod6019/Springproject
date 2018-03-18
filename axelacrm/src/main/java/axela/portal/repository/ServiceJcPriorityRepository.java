package axela.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.service.model.AxelaServiceJcPriority;

@Repository
public interface ServiceJcPriorityRepository extends JpaRepository<AxelaServiceJcPriority, Integer> {

	@Query("SELECT priority.priorityjcRank FROM AxelaServiceJcPriority priority WHERE 1=1 AND priority.priorityjcId=:priorityjcId ")
	public Integer findRankfromPriorityjcId(@Param("priorityjcId") int priorityjcId);

	@Query("SELECT MAX(priority.priorityjcRank) as max1 FROM AxelaServiceJcPriority priority WHERE 1=1 ")
	public Integer findMaxRank();

	@Query("SELECT MIN(priority.priorityjcRank) as min1 FROM AxelaServiceJcPriority priority WHERE 1=1 ")
	public Integer findMinRank();

}
