package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaJobtitle;

@Repository
public interface JobtitleRepository extends JpaRepository<AxelaJobtitle, Integer> {

	@Query("SELECT jobtitle.jobtitleId, jobtitle.jobtitleDesc"
			+ " FROM AxelaJobtitle jobtitle")
	public List<Object[]> findAllJobTitle();

}
