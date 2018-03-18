package axela.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaSob;

@Repository
public interface AxelaSobRepository extends JpaRepository<AxelaSob, Integer> {
	@Query("SELECT a FROM AxelaSob a WHERE a.sobId=:id")
	public AxelaSob findOne(@Param("id") int id);

}
