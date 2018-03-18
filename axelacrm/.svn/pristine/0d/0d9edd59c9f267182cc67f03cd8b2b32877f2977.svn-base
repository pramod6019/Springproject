package axela.service.repository;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.service.model.AxelaServiceContract;

@Repository
public interface ServiceContractRepository extends JpaRepository<AxelaServiceContract, Integer> {

	@Query("SELECT"
			+ " a.contractTitle"
			+ " FROM AxelaServiceContract a"
			+ " WHERE a.contractId =:contractId")
	public String findByTitle(@Param("contractId") int contractId);

	@Query("SELECT"
			+ " a.contractCustomerId"
			+ " FROM AxelaServiceContract a"
			+ " WHERE a.contractCustomerId=:contractCustomerId")
	public String findById(@Param("contractCustomerId") int contractCustomerId);

	@Query("SELECT COUNT(a.contractId) FROM AxelaServiceContract a"
			+ " WHERE  a.contractId =:contractId")
	public int findBycontractId(@Param("contractId") int contractId);

	@Query("SELECT"
			+ " count(a.contractCustomerId)"
			+ " FROM AxelaServiceContract a"
			+ " WHERE a.contractCustomerId=:customerId")
	public int findByCountId(@Param("customerId") int customerId);

	@Query("SELECT a.contractRefno FROM AxelaServiceContract a "
			+ " where a.contractBranchId =:contractBranchId "
			+ " AND a.contractRefno =:contractRefno")
	public List<AxelaServiceContract> findByContractRefno(@Param("contractBranchId") Integer contractBranchId, @Param("contractRefno") String contractRefno);

	// @Query("SELECT"
	// + " count(a.contractCustomerId)"
	// + " FROM AxelaServiceContract a"
	// + " WHERE a.contractCustomerId=:customerId")
	// public int findById(@Param("customerId") int customerId);

	// @Query("SELECT a.contractRefno FROM AxelaServiceContract a "
	// + " where a.contractBranchId =:contractBranchId "
	// + " AND a.contractRefno =:contractRefno")
	// public String findByContractRefno(@Param("contractBranchId") Integer contractBranchId, @Param("contractRefno") String contractRefno);

	@Query("SELECT"
			+ " a.contractId"
			+ " FROM AxelaServiceContract a"
			+ " WHERE a.contractId=:contractId")
	public String findByContractId(@Param("contractId") int contractId);

	// @Query("SELECT"
	// + " CONCAT(a.contractTitle, ' (', DATE_FORMAT(a.contractStartDate, '%d/%m/%Y'), '-', DATE_FORMAT(a.contractEndDate, '%d/%m/%Y'), ')') "
	// + " FROM AxelaServiceContract a"
	// + " INNER JOIN a.axelaServiceContractAsset b"
	// + " WHERE b.assetId =:assetId")
	// public String findByContract(@Param("assetId") int assetId);

	@Query("SELECT COUNT(a.contractEmpId) FROM AxelaServiceContract a"
			+ " WHERE a.contractEmpId =:empId")
	public int findByContractEmpId(@Param("empId") int empId);

	@Query("SELECT COUNT(a.contractBranchId) FROM AxelaServiceContract a"
			+ " WHERE a.contractBranchId =:branchId")
	public int findByContractBranchId(@Param("branchId") int branchId);

	@Query("SELECT"
			+ " contract.contractContactId"
			+ " FROM AxelaServiceContract contract"
			+ " WHERE contract.contractContactId=:contactId")
	public String findContactId(@Param("contactId") int contactId);

	@Query("SELECT(COALESCE(MAX(contract.contractRefno),'')) "
			+ " FROM AxelaServiceContract contract "
			+ " where contract.contractBranchId =:contractBranchId"
			+ " AND contract.contractRefno =:contractRefno")
	public String findByReferenceno(@Param("contractBranchId") int contractBranchId, @Param("contractRefno") String contractRefno);

	@Query("SELECT(COALESCE(MAX(contract.contractRefno),'')) "
			+ " FROM AxelaServiceContract contract "
			+ " where contract.contractBranchId =:contractBranchId"
			+ " AND contract.contractRefno =:contractRefno"
			+ " AND contract.contractId !=:contractId")
	public String findByReferencenoAndId(@Param("contractBranchId") int contractBranchId, @Param("contractRefno") String contractRefno, @Param("contractId") int contractId);

	public interface ServiceContractRepositoryFilter {
		public List<AxelaServiceContract> populateByContract(@Param("ContractId") String ContractId, HttpSession session);
		public List<Object[]> findByContract(@Param("ticketContactId") String ticketContactId, HttpSession session);
	}
}
