package axela.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.service.model.AxelaServiceJcType;

@Repository
public interface jcTypeRepository extends JpaRepository<AxelaServiceJcType, Integer> {

	@Query("SELECT a FROM AxelaServiceJcType a WHERE a.jctypeName=:jctypeName")
	public List<AxelaServiceJcType> findByTypeName(@Param("jctypeName") String jctypeName);
}
