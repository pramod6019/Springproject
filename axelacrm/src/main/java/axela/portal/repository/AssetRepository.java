//package axela.portal.repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import axela.portal.model.AxelaAsset;
//@Repository
//public interface AssetRepository extends JpaRepository<AxelaAsset, Integer> {
//	@Query("SELECT"
//			+ " a.assetSupplierCustomerId"
//			+ " FROM AxelaAsset a"
//			+ " WHERE a.assetSupplierCustomerId=:customerId")
//	public String findById(@Param("customerId") String customerId);
// }
