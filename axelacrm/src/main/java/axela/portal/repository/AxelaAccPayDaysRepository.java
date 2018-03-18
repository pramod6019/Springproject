package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import axela.portal.model.AxelaAccPayday;

public interface AxelaAccPayDaysRepository extends JpaRepository<AxelaAccPayday, Integer> {

	@Query("SELECT a.paydaysId, a.paydaysDays"
			+ " FROM AxelaAccPayday a"
			+ " GROUP BY paydaysId"
			+ " ORDER BY paydaysId")
	public List<Object[]> findPayDayId();
}
