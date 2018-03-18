package axela.customer.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.customer.model.AxelaCustomer;

@Repository
public interface CustomerRepository extends JpaRepository<AxelaCustomer, Integer> {

	@Query("SELECT a FROM AxelaCustomer a")
	public List<AxelaCustomer> findAll();

	public AxelaCustomer findByCustomerId(int customerId);

	@Transactional
	@Modifying
	@Query("DELETE FROM AxelaCustomer a WHERE a.customerId=:customerId")
	public void deleteById(@Param("customerId") int customerId);

	@Query("SELECT a.customerName"
			+ " FROM AxelaCustomer a"
			+ " WHERE a.customerName=:customerName"
			+ " GROUP BY a.customerName")
	public String findByCustomerName(@Param("customerName") String customerName);

	@Query("SELECT COUNT(a.customerEmpId) FROM AxelaCustomer a"
			+ " WHERE a.customerEmpId =:empId ")
	public int findByCustomerEmpId(@Param("empId") int empId);

	@Query("SELECT"
			+ " a.customerCode"
			+ " FROM AxelaCustomer a"
			+ " WHERE a.customerCode=:customerCode")
	public String findByCustomerCode(@Param("customerCode") String customerCode);

	@Query(value = "select a from AxelaCustomer a WHERE customerTaxtypeId=2 AND customerActive=1 AND customerTax=1 GROUP BY a.customerId ORDER BY customerName", nativeQuery = false)
	List<AxelaCustomer> findSalesTax();

	@Query(value = "SELECT a"
			+ " FROM AxelaCustomer a"
			+ " WHERE a.customerId=:customerId", nativeQuery = false)
	List<AxelaCustomer> findItemLedger(@Param("customerId") int customerID);

	@Query("SELECT count(a.customerBranchId) FROM AxelaCustomer a"
			+ " WHERE a.customerBranchId =:branchId")
	public int findByCustomerBranchId(@Param("branchId") int branchId);

	@Query("SELECT customer FROM AxelaCustomer customer"
			+ " WHERE customer.customerId=:customerId"
			+ " OR customer.customerName LIKE %:customerName%"
			+ " GROUP BY customer.customerId"
			+ " ORDER BY customer.customerName")
	List<AxelaCustomer> findByIdAndName(@Param("customerId") int customerId, @Param("customerName") String customerName, Pageable pageAble);

	// Custom implementation for CustomerRepository
	public interface CustomerFilterRepository {
		// public List<AxelaCustomerContact> findByTxtSearch(String txtSearch, String strSearch, int page, int pageSize);
		// public List<AxelaBranch> findAllByBranch(String branchAccess);

	}

	@Query("SELECT customer.customerName FROM AxelaCustomer customer  WHERE 1=1 AND customer.customerId!=:customerId AND customer.customerName=:customerName")
	public String findByNameAndId(@Param("customerId") int customerId, @Param("customerName") String customerName);
}
