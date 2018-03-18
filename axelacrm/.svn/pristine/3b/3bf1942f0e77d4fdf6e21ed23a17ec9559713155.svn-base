package axela.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.service.model.AxelaServiceJcPriority;

@Repository
public interface jobCartPriorityRepository extends JpaRepository<AxelaServiceJcPriority, Integer> {

	@Query("SELECT (COALESCE(MAX(a.delstatusRank),0)+1) FROM AxelaAccDelstatus  a WHERE 1=1 ")
	public Integer findrank();

	@Query("SELECT a FROM AxelaServiceJcPriority a WHERE a.priorityjcName=:priorityjcName")
	public List<AxelaServiceJcPriority> findByPriorityName(@Param("priorityjcName") String priorityjcName);
}
