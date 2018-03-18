package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaModule;

@Repository
public interface ModuleRepository extends JpaRepository<AxelaModule, Integer> {

	@Query(value = "SELECT CONCAT('compModule',module.moduleName) FROM AxelaModule module")
	List<String> FindAllModuleNames();

	@Query(value = "SELECT module.moduleName FROM AxelaModule module")
	List<String> FindAllOnlyModuleNames();

}
