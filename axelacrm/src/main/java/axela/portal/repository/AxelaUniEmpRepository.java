package axela.portal.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.sales.model.AxelaUniEmp;

@Repository
public interface AxelaUniEmpRepository extends JpaRepository<AxelaUniEmp, Integer> {

	@Query("SELECT a FROM AxelaUniEmp a")
	public List<AxelaUniEmp> findAll();

	@Query("SELECT a.empActive FROM AxelaEmp a WHERE a.empId=:empId")
	public String findOne(@Param("empId") int empId);

	@Query("SELECT a.empActive FROM AxelaUniEmp a WHERE a.empActive = '1' AND a.empId=:empId")
	public int findEmpactive(@Param("empId") int empId);

	@Transactional
	@Modifying
	@Query("UPDATE AxelaUniEmp a set a.empDeviceId=:empDeviceId"
			+ " WHERE a.empId=:empId")
	int findEmpdevice(@Param("empDeviceId") String empDeviceId, @Param("empId") int empId);

	public interface AxelaUniEmpFilterRepository {

	}

}
// public int findempdevice(String empDeviceId) {
// String Query = "update AxelaUniEmp a set a.empDeviceId='" + empDeviceId + "'";
// int typedQuery = em.createQuery(Query, AxelaUniEmp.class).executeUpdate();
// System.out.println("Query=================================" + Query);
// System.out.println("typedQuery=================================" + typedQuery);
// em.clear();
//
// return typedQuery;
// }