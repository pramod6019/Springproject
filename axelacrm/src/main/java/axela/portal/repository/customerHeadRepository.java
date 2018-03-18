package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaFinanceComp;

@Repository
public interface customerHeadRepository extends JpaRepository<AxelaFinanceComp, Integer> {

	@Query("SELECT a FROM AxelaFinanceComp a WHERE a.fincompName=:fincompName")
	public List<AxelaFinanceComp> findByName(@Param("fincompName") String fincompName);
}
