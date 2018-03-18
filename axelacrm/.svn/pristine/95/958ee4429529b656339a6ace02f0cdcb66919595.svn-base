package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.portal.model.AxelaConfig;

public interface ConfigRepository extends JpaRepository<AxelaConfig, Integer> {

	AxelaConfig findOne(int parseInt);

	@Query("SELECT a.configServiceContractRefno,"
			+ " a.configCustomerAddress,"
			+ " c.empRoleId"
			+ " FROM AxelaConfig a,"
			+ " AxelaComp b,"
			+ "AxelaEmp c "
			+ " WHERE c.empId =:empId")
	public List<Object[]> findByConfigServiceContractRefno(@Param("empId") int empId);

	public interface ConfigFilter {
	}

	@Query("SELECT "
			+ "config.configInventoryCurrentStock,"
			+ " config.configInventoryPoRefno,"
			+ " config.configInventoryLocationName"
			+ " FROM AxelaConfig config")
	List<Object[]> findInventoryConfigDetails();

	@Query("SELECT "
			+ " details "
			+ " FROM AxelaConfig details")
	AxelaConfig findAllInventoryUpdate();

	@Query("SELECT New AxelaConfig("
			+ " config.configServiceContract,"
			+ " config.configServiceJobcardCat,"
			+ " config.configServiceJobcardType,"
			+ " config.configServiceContractRefno,"
			+ " config.configServiceJobcardRefno,"
			+ " config.configServiceJobcardSerialnoMandatory,"
			+ " config.configJcNewEmailEnable,"
			+ " config.configJcNewSmsEnable,"
			+ " config.configJcReadyEmailEnable,"
			+ " config.configJcReadySmsEnable,"
			+ " config.configJcDeliveredEmailEnable,"
			+ " config.configJcDeliveredSmsEnable)"
			+ " FROM AxelaConfig config "
			+ " WHERE 1=1 ")
	public List<AxelaConfig> findByServiceConfig();

}
