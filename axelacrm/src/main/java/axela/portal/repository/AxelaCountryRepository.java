package axela.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaCountry;

@Repository
public interface AxelaCountryRepository extends JpaRepository<AxelaCountry, Integer> {
	@Query("SELECT a FROM AxelaCountry a WHERE a.countryId=:id")
	public AxelaCountry findOne(@Param("id") int id);
}
