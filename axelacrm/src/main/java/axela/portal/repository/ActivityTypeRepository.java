package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaActivityType;
@Repository
public interface ActivityTypeRepository extends JpaRepository<AxelaActivityType, Integer> {

	AxelaActivityType findByActivitytypeId(int parseInt);

	@Query("SELECT (COALESCE(MAX(type.activitytypeRank),0)+1) FROM AxelaActivityType type WHERE 1=1")
	public Integer findRank();

	List<AxelaActivityType> findByActivitytypeName(String activitytypeName);

	@Query("SELECT  type.activitytypeId ,type.activitytypeName FROM AxelaActivityType type WHERE 1=1 AND type.activitytypeId !=:activitytypeId AND type.activitytypeName=:activitytypeName")
	List<AxelaActivityType> findActivitytypeName(@Param("activitytypeId") int activitytypeId, @Param("activitytypeName") String activitytypeName);

	@Query("SELECT type.activitytypeRank FROM AxelaActivityType type WHERE 1=1 AND type.activitytypeId=:activitytypeId ")
	Integer findRankfromActivitytypeId(@Param("activitytypeId") int activitytypeId);

	@Query("SELECT MIN(type.activitytypeRank) as min1 FROM AxelaActivityType type WHERE 1=1 ")
	Integer findMinRank();

	@Query("SELECT MAX(type.activitytypeRank) as max1 FROM AxelaActivityType type WHERE 1=1 ")
	Integer findMaxRank();

}
