package axela.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.portal.model.AxelaTimezone;

public interface TimeZoneRepository extends JpaRepository<AxelaTimezone, Integer> {

	@Query("SELECT a.axelaTimezone.timezoneValue"
			+ "  FROM AxelaConfig a"
			+ " INNER JOIN a.axelaTimezone"
			+ " Where a.configId=:configId")
	public String findByTimeZoneValue(@Param("configId") int timeZoneId);

}
