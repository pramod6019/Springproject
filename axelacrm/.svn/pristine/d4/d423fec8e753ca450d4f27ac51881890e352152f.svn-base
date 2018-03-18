package axela.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.service.model.AxelaServiceContractService;

public interface ServiceContractServiceRepository extends JpaRepository<AxelaServiceContractService, Integer> {

	@Query("SELECT COUNT(a.serviceContractId)"
			+ " FROM AxelaServiceContractService a"
			+ " WHERE a.serviceContractId =:contractId")
	public int findById(@Param("contractId") int contractId);

	@Query("SELECT COUNT(a.serviceEmpId)"
			+ " FROM AxelaServiceContractService a"
			+ " WHERE a.serviceEmpId =:empId ")
	public int findByServiceEmpId(@Param("empId") int empId);

}
