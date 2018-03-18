package axela.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.sales.model.AxelaSalesCampaign;

@Repository
public interface SalesCampaignRepository extends JpaRepository<AxelaSalesCampaign, Integer> {

	// @Query("SELECT a FROM AxelaSalesCampaign a WHERE a.campaignStartdate")
	public List<AxelaSalesCampaign> findAll();

	@Query("SELECT COALESCE(campaign.campaignCampaigntypeId,0) AS campaignCampaigntypeId FROM AxelaSalesCampaign campaign WHERE campaign.campaignCampaigntypeId =:campaignCampaigntypeId ")
	public Integer findDataBycamptypeId(@Param("campaignCampaigntypeId") int campaignCampaigntypeId);

	public AxelaSalesCampaign findByCampaignId(int parseInt);
}
