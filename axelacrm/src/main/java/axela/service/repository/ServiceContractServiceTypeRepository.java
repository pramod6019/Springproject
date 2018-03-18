package axela.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.service.model.AxelaServiceContractServiceType;

@Repository
public interface ServiceContractServiceTypeRepository extends JpaRepository<AxelaServiceContractServiceType, Integer> {

	List<AxelaServiceContractServiceType> findByServicetypeName(String servicetypeName);
	//
	@Query("SELECT type.servicetypeId,type.servicetypeName FROM AxelaServiceContractServiceType type WHERE 1=1 AND type.servicetypeId !=:servicetypeId AND type.servicetypeName=:servicetypeName")
	List<AxelaServiceContractServiceType> findServicetypeName(@Param("servicetypeId") int servicetypeId, @Param("servicetypeName") String servicetypeName);
	//
	// AxelaServiceContractServiceType findByServicetypeId(int parseInt);
	//

}
