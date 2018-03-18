package axela.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.sales.model.AxelaSalesOpprFollowup;

public interface SalesOpprFollowUpRepository extends JpaRepository<AxelaSalesOpprFollowup, Integer> {

	@Query("SELECT COALESCE(a.followupOpprId,0) AS followupOpprId"
			+ " FROM AxelaSalesOpprFollowup a "
			+ " WHERE followupDesc='' AND followupOpprId=:followupOpprId")
	Object updateFollowUp(@Param("followupOpprId") int followupOpprId);

	@Query("SELECT COALESCE(a.followupId,0) AS followupId"
			+ " FROM AxelaSalesOpprFollowup a "
			+ " WHERE followupDesc='' AND followupOpprId=:followupOpprId")
	int FindFollowUpId(@Param("followupOpprId") int followupOpprId);

	@Query("SELECT COALESCE(a.crmOpprId,0) AS crmOpprId"
			+ " FROM AxelaSalesCrm a "
			+ " WHERE crmOpprId=:crmOpprId")
	Object findCrmFollowUp(@Param("crmOpprId") int crmOpprId);

	// @Query(value = "UPDATE AxelaSalesOpprFollowup"
	// + " SET followupDesc=:followupDesc ,"
	// + " followupModifiedTime=212121212121,"
	// + " followupModifiedId=:2"
	// + " WHERE followupDesc='' AND followupOpprId=:followupOpprId")
	// int updateFollowUp(@Param("followupDesc") String followupDesc, @Param("followupOpprId") int followupOpprId);
}
