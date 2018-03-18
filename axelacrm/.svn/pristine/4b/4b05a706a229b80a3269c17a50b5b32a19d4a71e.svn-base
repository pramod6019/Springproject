package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaPmType;
@Repository
public interface PmTypeRepository extends JpaRepository<AxelaPmType, Integer>
{

	@Query("SELECT type.pmtypeId,"
			+ " type.pmtypeName"
			+ " FROM AxelaPmType type"
			+ " WHERE 1=1 "
			+ "ORDER BY type.pmtypeName ")
	public List<Object[]> findByPopulatePmType();

}
