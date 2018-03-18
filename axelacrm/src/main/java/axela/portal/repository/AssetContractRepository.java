package axela.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.service.model.AxelaAssetContract;

public interface AssetContractRepository extends JpaRepository<AxelaAssetContract, Integer> {

	@Query("SELECT COUNT(a.contractBranchId) FROM AxelaAssetContract a"
			+ " WHERE a.contractBranchId =:branchId")
	public int findByContractbranchId(@Param("branchId") int branchId);
}
