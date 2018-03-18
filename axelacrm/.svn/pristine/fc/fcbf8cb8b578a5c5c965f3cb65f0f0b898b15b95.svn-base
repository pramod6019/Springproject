package axela.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.service.model.AxelaServiceJcStatus;

@Repository
public interface JcStatusRepository extends JpaRepository<AxelaServiceJcStatus, Integer> {

	@Query("SELECT a FROM AxelaServiceJcStatus a WHERE a.jcstatusName=:jcstatusName")
	public List<AxelaServiceJcStatus> findByStatusName(@Param("jcstatusName") String jcstatusName);

	@Query("SELECT (COALESCE(MAX(a.delstatusRank),0)+1) FROM AxelaAccDelstatus  a WHERE 1=1 ")
	public Integer findrank();

	@Query("SELECT status.jcstatusRank FROM AxelaServiceJcStatus status WHERE 1=1 AND status.jcstatusId=:jcstatusId ")
	public Integer findRankfromJcstatusId(@Param("jcstatusId") int jcstatusId);

	@Query("SELECT MAX(status.jcstatusRank) as max1 FROM AxelaServiceJcStatus status WHERE 1=1 ")
	public Integer findMaxRank();

	@Query("SELECT MIN(status.jcstatusRank) as min1 FROM AxelaServiceJcStatus status WHERE 1=1 ")
	public Integer findMinRank();

	@Query("SELECT a"
			+ " FROM AxelaServiceJcStatus a"
			+ " WHERE a.jcstatusId=:id")
	public AxelaServiceJcStatus findOne(@Param("id") int id);

}
