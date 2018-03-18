package axela.portal.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.portal.repository.AxelaUniEmpRepository.AxelaUniEmpFilterRepository;
import axela.sales.model.AxelaUniEmp;
@Repository
@Transactional(readOnly = true)
public class AxelaUniEmpRepositoryImpl implements AxelaUniEmpFilterRepository {
	@PersistenceContext
	EntityManager em;

	public int findempdevice(String empDeviceId) {
		String Query = "update AxelaUniEmp a set a.empDeviceId='" + empDeviceId + "'";
		int typedQuery = em.createQuery(Query, AxelaUniEmp.class).executeUpdate();
		System.out.println("Query=================================" + Query);
		System.out.println("typedQuery=================================" + typedQuery);
		em.clear();

		return typedQuery;
	}
	// map.put("emp_active", CNumeric(ExecuteQuery("SELECT emp_active"
	// + " FROM  axela_uni_emp"
	// + " WHERE emp_id = " + emp_id)));

	// public int length(String branchAccess, String exeAccess, String sort, String field) {
	// Query query = em.createQuery("SELECT a FROM AxelaCustomer a WHERE 1=1 AND a.customerType !='0'" + branchAccess + exeAccess + " ORDER BY a." + field + " " + sort);
	// em.clear();
	// return (int) query.getResultList().size();
	// }

	public List<AxelaUniEmp> findAll(String signinid, String password) {
		String Query = "SELECT NEW AxelaUniEmp(" + "a.empId,";
		Query += "a.empName,"
				+ "a.empEmail1,"
				+ "a.empUpass,"
				+ "a.empUuid,"
				+ "a.empAllExe,"
				+ "a.compId,"
				+ "a.axelaComp.compName,"
				+ "a.empDeviceId,"
				+ "a.empActive,"
				+ "a.axelaComp.compActive,"
				+ "a.axelaComp.compModuleSales,"
				+ "a.axelaComp.compModuleHelpdesk,"
				+ "a.axelaComp.compModuleService,"
				+ "a.axelaComp.compModuleAccounting,"
				+ "a.axelaComp.compModulePm,"
				+ "a.empRoleId)"
				+ " FROM AxelaUniEmp a"
				+ " INNER JOIN a.axelaComp"
				+ " WHERE emp_email1='" + signinid + "' AND emp_upass='" + password + "'";
		System.out.println("Query===ssaa=sssss===============" + Query);
		TypedQuery<AxelaUniEmp> typedQuery = em.createQuery(Query, AxelaUniEmp.class);

		em.clear();
		return typedQuery.getResultList();
	}
}