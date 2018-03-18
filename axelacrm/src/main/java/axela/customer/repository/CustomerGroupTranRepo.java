package axela.customer.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.customer.model.AxelaCustomerGroupTran;

@Repository
public interface CustomerGroupTranRepo extends JpaRepository<AxelaCustomerGroupTran, Integer> {

	@Query("SELECT a.transTransgroupId  FROM AxelaCustomerGroupTran a WHERE a.transCustomerId=:customerId")
	public List<Integer> findByCustomerId(@Param("customerId") int customerId);

	@Transactional
	@Modifying
	@Query("DELETE FROM AxelaCustomerGroupTran a WHERE a.transCustomerId=:customerId")
	public void deleteByCustomer(@Param("customerId") int customerId);
}
