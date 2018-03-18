package axela.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import axela.service.model.AxelaServiceContractType;

public interface ServiceContractTypeRepository extends JpaRepository<AxelaServiceContractType, Integer> {

	@Query("SELECT  a.contracttypeId, a.contracttypeName"
			+ " FROM AxelaServiceContractType a"
			+ " ORDER BY a.contracttypeName")
	public List<Object[]> findByContracttypeIdAndContracttypeName();

}
