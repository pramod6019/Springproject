package axela.sales.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaSalesCampaignBranch;

@Repository
public interface SalesCampaignBranchRepository extends JpaRepository<AxelaSalesCampaignBranch, Integer> {

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM AxelaSalesCampaignBranch a WHERE a.camptransCampaignId=:campaignId")
	int deletebyCampId(@Param("campaignId") int campaignId);

	@Query(value = "SELECT b FROM AxelaSalesCampaignBranch b WHERE b.camptransCampaignId=:campaignId")
	List<AxelaSalesCampaignBranch> findBranch(@Param("campaignId") int campaignId);
}
