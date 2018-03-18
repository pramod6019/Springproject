package axela.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.service.model.AxelaServiceJc;

@Repository
public interface JCRepository extends JpaRepository<AxelaServiceJc, Integer> {

	// @Query("SELECT"
	// + " a.jcId"
	// + " FROM AxelaServiceJc a"
	// + " WHERE a.jcId=:jcId")
	// public int findByOne(@Param("jcId") int jcId);

	@Query("SELECT a FROM AxelaServiceJc a")
	public List<AxelaServiceJc> findAll();

	public AxelaServiceJc findByjcId(int jcId);

	@Query("SELECT COUNT(a.jcEmpId) FROM AxelaServiceJc a"
			+ " WHERE a.jcEmpId =:empId")
	public int findById(@Param("empId") int empId);

	public AxelaServiceJc findOne(@Param("jcId") int jcId);
	// public AxelaServiceJc findByjcId(int jcId);

	@Query("SELECT COUNT(a.jcBranchId) FROM AxelaServiceJc a"
			+ " WHERE a.jcBranchId =:branchId ")
	public int findByJcBranchId(@Param("branchId") int branchId);

	public interface JcFilterRepository {

		public List<AxelaServiceJc> findByProperty(String Property);

	}
}
