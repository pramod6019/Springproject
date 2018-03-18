package axela.portal.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaCustomerDoc;
@Repository
public interface CustomerDocsRepository extends JpaRepository<AxelaCustomerDoc, Integer> {

	@Transactional
	@Modifying
	@Query("DELETE"
			+ " FROM AxelaCustomerDoc a"
			+ " WHERE a.docCustomerId =:customerId")
	public void deleteById(@Param("customerId") int customerId);
}
