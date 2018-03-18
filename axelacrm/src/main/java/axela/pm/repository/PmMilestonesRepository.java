package axela.pm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.pm.model.AxelaPmMilestone;

public interface PmMilestonesRepository extends JpaRepository<AxelaPmMilestone, Integer> {

	AxelaPmMilestone findByPmmilestoneId(int parseInt);

	@Query("SELECT milestone.pmmilestoneId,"
			+ " milestone.pmmilestoneName"
			+ " FROM AxelaPmMilestone milestone"
			+ " WHERE 1=1 "
			+ "ORDER BY milestone.pmmilestoneName")
	public List<Object[]> findByPopulatePmMilestone();

	@Query("SELECT milestone.pmmilestoneId,"
			+ " milestone.pmmilestoneName,"
			+ " milestone.pmmilestonePmId"
			+ " FROM AxelaPmMilestone milestone"
			+ " WHERE milestone.pmmilestonePmId=:pmId"
			+ " GROUP BY milestone.pmmilestonePmId"
			+ " ORDER BY milestone.pmmilestoneName")
	public List<Object[]> findByPopulateMilestone(@Param("pmId") int pmId);

}
