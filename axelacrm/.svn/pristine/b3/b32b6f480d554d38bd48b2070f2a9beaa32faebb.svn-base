package axela.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.service.model.AxelaServiceJcCat;

@Repository
public interface jcCategoryRepository extends JpaRepository<AxelaServiceJcCat, Integer> {

	@Query("SELECT a FROM AxelaServiceJcCat a WHERE a.jccatName=:jccatName")
	public List<AxelaServiceJcCat> findByCategory(@Param("jccatName") String jccatName);
}
