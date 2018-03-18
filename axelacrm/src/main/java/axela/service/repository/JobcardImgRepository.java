package axela.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.service.model.AxelaServiceJcImg;

@Repository
public interface JobcardImgRepository extends JpaRepository<AxelaServiceJcImg, Integer> {

	@Query("SELECT"
			+ " a.imgId,"
			+ " a.imgValue,"
			+ " a.imgTitle"
			+ " FROM AxelaServiceJcImg a"
			+ " WHERE a.imgJcId=:jcId")
	List<Object[]> findjcId(@Param("jcId") int jcId);
}
