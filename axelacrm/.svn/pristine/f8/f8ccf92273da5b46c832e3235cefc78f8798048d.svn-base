package axela.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.sales.model.AxelaSalesOpprFollowupDesc;

@Repository
public interface FollowupDescRepository extends JpaRepository<AxelaSalesOpprFollowupDesc, Integer> {

	@Query(" SELECT "
			+ " a.followupdescId, "
			+ " a.followupdescName "
			+ " FROM   AxelaSalesOpprFollowupDesc a "
			+ " ORDER BY a.followupdescName ")
	List<Object[]> findfollowupdescIdAndfollowupdescName();

	AxelaSalesOpprFollowupDesc findByFollowupdescId(int parseInt);

	List<AxelaSalesOpprFollowupDesc> findByFollowupdescName(String followupdescName);

	@Query(" SELECT "
			+ " followupDesc.followupdescId,"
			+ " followupDesc.followupdescName "
			+ " FROM AxelaSalesOpprFollowupDesc followupDesc "
			+ " WHERE 1=1 "
			+ " AND followupDesc.followupdescId !=:followupdescId "
			+ " AND followupDesc.followupdescName=:followupdescName ")
	List<AxelaSalesOpprFollowupDesc> findFollowupdescName(@Param("followupdescId") int followupdescId, @Param("followupdescName") String followupdescName);

}
