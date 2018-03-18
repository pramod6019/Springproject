package axela.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaSalesOpprBrochure;

@Repository
public interface BrochureRepository extends JpaRepository<AxelaSalesOpprBrochure, Integer> {

	AxelaSalesOpprBrochure findByBrochureId(int parseInt);

	@Query("SELECT (COALESCE(MAX(brochure.brochureRank),0)+1) FROM AxelaSalesOpprBrochure brochure WHERE 1=1")
	public Integer findRank();

}
