package axela.helpdesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import axela.helpdesk.model.AxelaFaqCat;

public interface FaqCatRepository extends JpaRepository<AxelaFaqCat, Integer> {

	@Query("SELECT cat.catId,"
			+ "cat.catName"
			+ " FROM AxelaFaqCat cat"
			+ " where 1=1 "
			+ "order by cat.catName ")
	public List<Object[]> findByPopulateFaqCategory();

}
