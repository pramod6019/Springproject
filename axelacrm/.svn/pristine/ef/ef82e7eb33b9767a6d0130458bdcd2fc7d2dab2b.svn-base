package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaAccDelstatus;

@Repository
public interface DelStatusRepository extends JpaRepository<AxelaAccDelstatus, Integer> {

	@Query("SELECT (COALESCE(MAX(a.delstatusRank),0)+1) FROM AxelaAccDelstatus  a WHERE 1=1 ")
	public Integer findrank();

	public AxelaAccDelstatus findByDelstatusId(int parseInt);

	public List<AxelaAccDelstatus> findByDelstatusName(String delstatusName);

	@Query("SELECT delstatus.delstatusId,delstatus.delstatusName FROM AxelaAccDelstatus delstatus WHERE 1=1 AND delstatus.delstatusId !=:delstatusId AND delstatus.delstatusName=:delstatusName")
	public List<AxelaAccDelstatus> findDelstatusName(@Param("delstatusId") int delstatusId, @Param("delstatusName") String delstatusName);

	@Query("SELECT delstatus.delstatusRank FROM AxelaAccDelstatus delstatus WHERE 1=1 AND delstatus.delstatusId=:delstatusId ")
	public Integer findRankfromPriorityId(@Param("delstatusId") int delstatusId);

	@Query("SELECT MAX(delstatus.delstatusRank) as max1 FROM AxelaAccDelstatus delstatus WHERE 1=1 ")
	public Integer findMaxRank();

	@Query("SELECT MIN(delstatus.delstatusRank) as min1 FROM AxelaAccDelstatus delstatus WHERE 1=1 ")
	public Integer findMinRank();
}
