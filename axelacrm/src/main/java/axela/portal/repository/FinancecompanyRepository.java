package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.portal.model.AxelaFinanceComp;

public interface FinancecompanyRepository extends JpaRepository<AxelaFinanceComp, Integer> {

	AxelaFinanceComp findByFincompId(int parseInt);

	List<AxelaFinanceComp> findByFincompName(String fincompName);

	@Query("SELECT comp.fincompId,comp.fincompName FROM AxelaFinanceComp comp WHERE 1=1 AND comp.fincompId !=:fincompId AND comp.fincompName=:fincompName")
	List<AxelaFinanceComp> findFincompName(@Param("fincompId") int fincompId, @Param("fincompName") String fincompName);

}
