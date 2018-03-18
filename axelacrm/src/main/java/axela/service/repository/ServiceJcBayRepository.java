package axela.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.service.model.AxelaServiceJcBay;

@Repository
public interface ServiceJcBayRepository extends JpaRepository<AxelaServiceJcBay, Integer> {

	@Query(" SELECT  bay.bayId, bay.bayName "
			+ " FROM AxelaServiceJcBay bay "
			+ " WHERE bay.bayBranchId=:jcBranchId"
			+ " AND bay.bayActive=1 "
			+ " AND bay.bayOpen=1 "
			+ " ORDER BY bay.bayRank")
	List<Object[]> findAllBay(@Param("jcBranchId") int jcBranchId);

	// findAllBayById
	// @Query(" SELECT bay.bayName, bay.bayId "
	// + " FROM AxelaServiceJcBay bay "
	// + " WHERE bay.bayBranchId=:jcBranchId"
	// + " AND bay.bayActive=1 "
	// + " AND bay.bayOpen=1"
	// + " AND bay. "
	// + " ORDER BY bay.bayRank")
	// List<Object[]> findAllBayById(@Param("bayId") int bayId,@Param("jcBranchId") int jcBranchId);

}
