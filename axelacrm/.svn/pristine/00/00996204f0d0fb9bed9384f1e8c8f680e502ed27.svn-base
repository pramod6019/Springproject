package axela.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.service.model.AxelaServiceContractPriority;

@Repository
public interface ServiceContractPriorityRepository extends JpaRepository<AxelaServiceContractPriority, Integer> {

	@Query("SELECT priority.contractpriorityRank FROM AxelaServiceContractPriority priority WHERE 1=1 AND priority.contractpriorityId=:contractpriorityId ")
	Integer findRankfromContractPriorityId(@Param("contractpriorityId") int contractpriorityId);

	@Query("SELECT MIN(priority.contractpriorityRank) as min1 FROM AxelaServiceContractPriority priority WHERE 1=1 ")
	Integer findMinRank();

	@Query("Select(coalesce(max(priority.contractpriorityRank),0)+1) from AxelaServiceContractPriority priority where 1=1")
	Integer findMaxRank();

	@Query("SELECT"
			+ " a.contractpriorityId,"
			+ " a.contractpriorityName"
			+ " FROM AxelaServiceContractPriority a"
			+ " group by a.contractpriorityId"
			+ " order by a.contractpriorityRank")
	public List<Object[]> findByPrioritycontractIdAndPrioritycontractName();

}
