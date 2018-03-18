package axela.service.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.service.model.AxelaServiceContractAssetTran;

public interface ServiceContractAssetTransRepository extends JpaRepository<AxelaServiceContractAssetTran, Integer> {

	@Transactional
	@Modifying
	@Query("DELETE FROM AxelaServiceContractAssetTran a"
			+ " WHERE a.assettransAssetId =:assetId "
			+ "	AND a.assettransContractId =:contractId")
	public void deleteByAssetTransAssetIdAndAssetTransContractId(@Param("assetId") int assetId, @Param("contractId") int contractId);

}
