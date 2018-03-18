package axela.portal.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.portal.model.AxelaCity;

public interface AxelaCityRepository extends JpaRepository<AxelaCity, Integer> {

	// @Modifying
	// @Query(value = "SELECT city.city_id cityId,COALESCE(CONCAT(country.country_name,' - ', state.state_name, ' - ', city.city_name), '') cityName "
	// + " FROM axela_city city"
	// + " INNER JOIN axela_state state on state.state_id=city.city_state_id"
	// + " INNER JOIN axela_country country on country.country_id = state.state_country_id", nativeQuery = true)
	List<AxelaCity> findAll();

	@Query("SELECT a FROM AxelaCity a WHERE a.cityId=:id")
	public AxelaCity findOne(@Param("id") int id);

	public interface CityRepoFilter {
		List<AxelaCity> findByCityAndName(@Param("cityStateId") int cityId, @Param("cityName") String cityName, Pageable pageAble);
	}
}