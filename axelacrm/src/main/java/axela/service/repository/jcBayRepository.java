package axela.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.service.model.AxelaServiceJcBay;

@Repository
public interface jcBayRepository extends JpaRepository<AxelaServiceJcBay, Integer> {

	@Query("SELECT a FROM AxelaServiceJcBay a WHERE a.bayName =:bayName")
	public List<AxelaServiceJcBay> findByBayName(@Param("bayName") String bayName);

	@Query("SELECT bay.bayRank FROM AxelaServiceJcBay bay WHERE 1=1 AND bay.bayId=:bayId ")
	public Integer findRankfromBayId(@Param("bayId") int bayId);

	@Query("SELECT MAX(bay.bayRank) as max1 FROM AxelaServiceJcBay bay WHERE 1=1 ")
	public Integer findMaxRank();

	@Query("SELECT MIN(bay.bayRank) as min1 FROM AxelaServiceJcBay bay WHERE 1=1 ")
	public Integer findMinRank();
}
