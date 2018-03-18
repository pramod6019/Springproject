package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaSoe;

@Repository
public interface AxelaSoeRepository extends JpaRepository<AxelaSoe, Integer> {
	@Query("SELECT a FROM AxelaSoe a WHERE a.soeId=:id")
	public AxelaSoe findOne(@Param("id") int id);

	@Query("SELECT a.soeId, a.soeName FROM AxelaSoe a ")
	public List<Object[]> findSoe();
}
