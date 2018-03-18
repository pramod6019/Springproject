package axela.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.customer.model.AxelaCustomer;

@Repository
public interface Customer_Repository extends JpaRepository<AxelaCustomer, Integer> {

	@Query("SELECT a FROM AxelaCustomer a")
	public List<AxelaCustomer> findAll();

	// @Query("SELECT a FROM AxelaCustomer a WHERE  a." + property + "='" + value + "'" + branchAccess + exeAccess);

	// @Query(value = " SELECT empexe_id FROM axela_emp_exe WHERE empexe_emp_id=:empId", nativeQuery = true)

	@Query(value = "SELECT a"
			+ " FROM AxelaCustomer a"
			+ " WHERE a.customerId=:customerId", nativeQuery = false)
	List<AxelaCustomer> findItemLedger(@Param("customerId") int customerID);

	@Query(value = "select a from AxelaCustomer a WHERE customerTaxtypeId=2 AND customerActive=1 AND customerTax=1 GROUP BY a.customerId ORDER BY customerName", nativeQuery = false)
	List<AxelaCustomer> findSalesTax();

	// @Query(value =
	// "SELECT config_customer_soe, config_customer_sob, config_customer_address, config_customer_dupnames, emp_role_id FROM axela_2.axela_config, axela_2.axela_emp, axela_2.axela_comp WHERE emp_id In (?1) ",
	// nativeQuery = true)
	// List<Object[]> findEmpIdList(List empId);
	//
	// @Query(value =
	// "SELECT config_customer_soe, config_customer_sob, config_customer_address, config_customer_dupnames, emp_role_id FROM axela_2.axela_config, axela_2.axela_emp, axela_2.axela_comp WHERE emp_id =?1 ",
	// nativeQuery = true)
	// List<Object[]> findEmpId(int empId);
	//
	// @Query(value = "select a from AxelaCustomer a Inner Join ", nativeQuery = false)
	// List<AxelaCustomer> findExecutive();

	interface CustomerFilterRepository {

	}

}