package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaSoe;
@Repository
public interface SoeRepository extends JpaRepository<AxelaSoe, Integer> {
	List<AxelaSoe> findBySoeName(String soeName);

	AxelaSoe findBySoeId(int parseInt);

	@Query("SELECT soe.soeId,soe.soeName FROM AxelaSoe soe ")
	List<Object[]> findSoe();

	@Query("SELECT soe.soeId,soe.soeName FROM AxelaSoe soe WHERE 1=1 AND soe.soeId !=:soeId AND soe.soeName=:soeName")
	List<AxelaSoe> findSoeName(@Param("soeId") int soeId, @Param("soeName") String soeName);

}
