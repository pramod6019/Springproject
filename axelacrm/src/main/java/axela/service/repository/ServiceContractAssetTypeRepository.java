package axela.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import axela.service.model.AxelaServiceContractAssetType;

public interface ServiceContractAssetTypeRepository extends JpaRepository<AxelaServiceContractAssetType, Integer> {

	@Query("SELECT a.contractassettypeId, a.contractassettypeName"
			+ " FROM  AxelaServiceContractAssetType a "
			+ " ORDER BY a.contractassettypeName")
	public List<Object[]> findByContractAssetTypeId();
}
