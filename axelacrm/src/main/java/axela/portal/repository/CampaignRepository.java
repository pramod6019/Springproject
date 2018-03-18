package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.sales.model.AxelaSalesCampaign;
@Repository
public interface CampaignRepository extends JpaRepository<AxelaSalesCampaign, Integer> {

	// List<AxelaSalesCampaignBranch> findByCamptransBranchIdOrderByCampaignName(
	// int parseInt);
	// @Query("SELECT aa.campaignId, aa.campaignName,aa.campaignStartdate,aa.campaignEnddate FROM AxelaSalesCampaign aa INNER JOIN AxelaSalesCampaignBranch a WHERE aa.campaignId =: a.camptransBranchId ")//WHERE
	// aa.camptransBranchId=:camptransBranchId ")//GROUP BY aa.campaignId ORDER BY aa.campaignName")
	// List<AxelaSalesCampaignBranch> findByCamptransBranchId(@Param("camptransBranchId")int camptransBranchId);

	@Query("SELECT b.campaignId, b.campaignName, SUBSTRING(b.campaignStartdate,1,8), SUBSTRING(b.campaignEnddate,1,8)"
			+ " FROM AxelaSalesCampaignBranch  a,AxelaSalesCampaign b"
			+ "  WHERE b.campaignActive=1 AND a.camptransBranchId=b.campaignId AND a.camptransBranchId=?1  "
			+ "GROUP BY b.campaignName"
			+ " ORDER BY b.campaignId")
	List<Object[]> findAllCampaign(@Param("camptransBranchId") int camptransBranchId);
	// List<AxelaSalesCampaignBranch> findByCamptransBranchId(//
	// String camptrans_branch_id);

}
