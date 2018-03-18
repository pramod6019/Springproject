package axela.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.sales.model.AxelaSalesOpprLostcase3;

@Repository
public interface SalesLostCase3Repository extends JpaRepository<AxelaSalesOpprLostcase3, Integer> {
	@Query(value = "SELECT COUNT(a.lostcase3Id) FROM AxelaSalesOpprLostcase3 a WHERE a.lostcase3Lostcase2Id=:lostcase2Lostcase1Id")
	int findById(@Param("lostcase2Lostcase1Id") int lostcase2Id);

	@Query(value = "SELECT"
			+ " a.lostcase3Id ,"
			+ " a.lostcase3Name "
			+ " FROM AxelaSalesOpprLostcase3 a"
			+ " WHERE 1=1 AND a.lostcase3Lostcase2Id=:lostcase2Id"
			+ " GROUP BY a.lostcase3Id"
			+ " ORDER BY a.lostcase3Name")
	List<Object[]> findByLastCase3(@Param("lostcase2Id") int lostcase2Id);
}
