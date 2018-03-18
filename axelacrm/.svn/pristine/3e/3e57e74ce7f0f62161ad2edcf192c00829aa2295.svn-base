package axela.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import axela.service.model.AxelaServiceContractAssetBrand;

public interface ServiceContractAssetBrandRepository extends JpaRepository<AxelaServiceContractAssetBrand, Integer> {

	@Query("SELECT a.assetbrandId, a.assetbrandName"
			+ " FROM AxelaServiceContractAssetBrand a "
			+ " ORDER BY a.assetbrandName")
	public List<Object[]> findByServiceContractAssetBrand();
}
