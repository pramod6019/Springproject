package axela.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaSalesOpprStage;
@Repository
public interface SalesOpprStageRepository extends JpaRepository<AxelaSalesOpprStage, Integer> {

	@Query("SELECT stage.stageName "
			+ " FROM AxelaSalesOpprStage stage"
			+ " ORDER BY stage.stageRank")
	public List<String> findStageName();

	@Query("SELECT (COALESCE(MAX(a.stageRank),0)+1) FROM AxelaSalesOpprStage  a WHERE 1=1")
	public Integer findrank();

	AxelaSalesOpprStage findByStageId(int parseInt);

	public List<AxelaSalesOpprStage> findByStageName(String stageName);

	@Query("SELECT stage.stageId,stage.stageName FROM AxelaSalesOpprStage stage WHERE 1=1 AND stage.stageId !=:stageId AND stage.stageName=:stageName")
	public List<AxelaSalesOpprStage> findStageName(@Param("stageId") int stageId, @Param("stageName") String stageName);

	@Query("SELECT stage.stageRank FROM AxelaSalesOpprStage stage WHERE 1=1 AND stage.stageId =:stageId")
	public Integer findRankfromStageId(@Param("stageId") int stageId);

	@Query("SELECT MAX(stage.stageRank) as min1 FROM AxelaSalesOpprStage stage WHERE 1=1 ")
	public Integer findMinRank();

	@Query("SELECT MIN(stage.stageRank) as max1 FROM AxelaSalesOpprStage stage WHERE 1=1 ")
	public Integer findMaxRank();

}
