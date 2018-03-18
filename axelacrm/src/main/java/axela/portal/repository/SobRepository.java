package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaSob;
@Repository
public interface SobRepository extends JpaRepository<AxelaSob, Integer> {

	public List<AxelaSob> findAll();

	public List<AxelaSob> findBySobName(String sobName);

	public AxelaSob findBySobId(int parseInt);

	@Query("SELECT sob.sobId,sob.sobName FROM AxelaSob sob WHERE 1=1 AND sob.sobId !=:sobId AND sob.sobName=:sobName")
	public List<AxelaSob> findSobName(@Param("sobId") int sobId, @Param("sobName") String sobName);
}
