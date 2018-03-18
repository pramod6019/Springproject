package axela.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.service.model.AxelaServiceContractDoc;

public interface ServiceContractDocRepository extends JpaRepository<AxelaServiceContractDoc, Integer> {

	@Query("SELECT COUNT(a.docContractId) FROM AxelaServiceContractDoc a"
			+ " WHERE a.docContractId =:docContractId")
	public int findById(@Param("docContractId") int docContractId);

}
