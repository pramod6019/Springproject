package axela.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaState;

@Repository
public interface AxelaStateRepository extends JpaRepository<AxelaState, Integer> {

	@Query("SELECT a FROM AxelaState a WHERE a.stateId=:id")
	public AxelaState findOne(@Param("id") int id);
}
