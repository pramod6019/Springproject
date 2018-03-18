package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import axela.portal.model.AxelaBillLoyaltycard;

public interface AxelaBillLoyaltycardRepository extends JpaRepository<AxelaBillLoyaltycard, Long> {

	@Query("SELECT a from AxelaBillLoyaltycard a WHERE a.loyaltycardId=1")
	// a where a.loyaltycardId=1 ORDER BY a.modelName
	public List<AxelaBillLoyaltycard> findBillLoyaltycard();
}
