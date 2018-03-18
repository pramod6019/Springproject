package axela.sales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.sales.model.AxelaSalesOpprLostcase2;

@Repository
public interface SalesLostCase2Repository extends JpaRepository<AxelaSalesOpprLostcase2, Integer> {

	@Query(value = "SELECT COUNT(a.lostcase2Id) FROM AxelaSalesOpprLostcase2 a WHERE a.lostcase2Lostcase1Id=:lostcase1Id")
	int findById(@Param("lostcase1Id") int lostcase1Id);

	@Query(value = "SELECT"
			+ " a.lostcase2Id ,"
			+ " a.lostcase2Name "
			+ " FROM AxelaSalesOpprLostcase2 a"
			+ " WHERE 1 = 1 AND a.lostcase2Lostcase1Id=:Lostcase1Id"
			+ " ORDER BY a.lostcase2Name")
	List<Object[]> findByLostCase2(@Param("Lostcase1Id") int Lostcase1Id);

}
