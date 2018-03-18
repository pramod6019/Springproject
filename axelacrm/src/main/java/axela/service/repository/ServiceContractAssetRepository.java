package axela.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.service.model.AxelaServiceContractAsset;

@Repository
public interface ServiceContractAssetRepository extends JpaRepository<AxelaServiceContractAsset, Integer> {

	@Query("SELECT a.assetName "
			+ "FROM AxelaServiceContractAsset a "
			+ "WHERE a.assetId =:ticketAssetId")
	public String findByAssetName(@Param("ticketAssetId") int ticketAssetId);

	@Query("SELECT asset.assetSerial"
			+ " FROM AxelaServiceContractAsset asset "
			+ " INNER JOIN asset.axelaServiceContractAssetTran tran"
			+ " WHERE tran.assettransAssetId =:contractId"
			+ " AND asset.assetSerial =:assetSerial")
	public Object findBySerial(@Param("contractId") int contractId, @Param("assetSerial") String assetSerial);

	@Query("SELECT asset.assetSerial"
			+ " FROM AxelaServiceContractAsset asset "
			+ " INNER JOIN asset.axelaServiceContractAssetTran tran"
			+ " WHERE tran.assettransAssetId =:contractId"
			+ " AND asset.assetSerial !=:assetSerial "
			+ " AND asset.assetId !=:assetId ")
	public Object findBySerialUpdate(@Param("contractId") int contractId, @Param("assetSerial") String assetSerial, @Param("assetId") int assetId);

	@Query("SELECT a.empRoleId FROM AxelaEmp a"
			+ " WHERE a.empId =:empId ")
	public int findEmpId(@Param("empId") int empId);

	@Query("SELECT COUNT(a.assetCustomerId) FROM AxelaServiceContractAsset a"
			+ " WHERE a.assetCustomerId =:CustomerId")
	public int findById(@Param("CustomerId") int CustomerId);

	@Query("SELECT(COALESCE(MAX(asset.assetContractlocId),0))"
			+ " FROM AxelaServiceContractAsset asset"
			+ " WHERE asset.assetContractlocId =:contractlocId")
	public int findByAssetContractlocId(@Param("contractlocId") int contractlocId);

}
