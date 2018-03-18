package axela.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.service.model.AxelaServiceJcCheck;

@Repository
public interface ServiceJcCheckRepository extends JpaRepository<AxelaServiceJcCheck, Integer> {

	@Query("SELECT new AxelaServiceJcCheck( "
			+ " check.checkItemId,"
			+ " check.checkName,"
			+ " check.checkEntryId,"
			+ " check.checkEntryDate,"
			+ " check.checkModifiedId,"
			+ " check.checkModifiedDate,"
			+ " item.itemModelId)"
			+ " FROM AxelaServiceJcCheck check"
			+ " INNER JOIN check.axelaInventoryItem item"
			+ " WHERE check.checkId =:checkId")
	public AxelaServiceJcCheck findByCheckId(@Param("checkId") int checkId);

	@Query("SELECT jccheck.checkName"
			+ " FROM AxelaServiceJcCheck jccheck"
			+ " WHERE jccheck.checkName=:checkName"
			+ " GROUP BY jccheck.checkName")
	public String findByCheckName(@Param("checkName") String checkName);

	@Query("SELECT jccheck.checkId,"
			+ " jccheck.checkName"
			+ " FROM AxelaServiceJcCheck jccheck"
			+ " WHERE 1=1"
			+ " AND jccheck.checkId !=:checkId"
			+ " AND jccheck.checkName=:checkName")
	public List<AxelaServiceJcCheck> findJcCheckNameExcludingCurrentId(@Param("checkId") int checkId, @Param("checkName") String checkName);
}
