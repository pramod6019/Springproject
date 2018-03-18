package axela.portal.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.portal.model.AxelaEmp;

@Repository
@Transactional(readOnly = true)
public class ExecutivesFilterImpl extends Connect {

	@PersistenceContext
	EntityManager em;
	public static String totalCount = "0";
	public static Long listLength = 0L;

	public List<AxelaEmp> findAllExecutives(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaEmp> listData = new ArrayList<AxelaEmp>();
		String strSql = "SELECT New AxelaEmp("
				+ " emp.empId,"
				+ " emp.empName,"
				+ " emp.empRefNo,"
				+ " emp.empLandmark,"
				+ " emp.empAddress, "
				+ " emp.empCityId,"
				+ " city.cityName,"
				+ " state.stateName,"
				+ " emp.empPhone1,"
				+ " emp.empPhone2,"
				+ " emp.empMobile1,"
				+ " emp.empMobile2,"
				+ " emp.empEmail1,"
				+ " emp.empEmail2,"
				+ " country.countryName,"
				+ " emp.empStructureId,"
				+ " emp.empPin,"
				// + " emp.empPhoto,"
				+ " emp.empGender,"
				+ " emp.empActive,"
				+ " role.roleName,"
				+ " branch.branchName,"
				+ " branch.branchId,"
				+ " branch.branchCode,"
				+ " jobtitle.jobtitleDesc"
				+ ")";
		sqlJoin += " FROM AxelaEmp emp"
				+ " JOIN emp.axelaEmpRole role" // for AxelaEmpRole
				+ " JOIN emp.axelaCity city"// for AxelaCity
				+ " LEFT JOIN emp.axelaJobtitle jobtitle"// for AxelaJobtitle
				+ " LEFT JOIN emp.axelaBranch branch"// for AxelaBranch
				+ " JOIN city.axelaState state"// for AxelaState
				+ " JOIN state.axelaCountry country"// for AxelaCountry
				+ " WHERE 1=1 "
				+ strSearch;
		countSql = "SELECT COUNT(DISTINCT emp.empId)" + sqlJoin;

		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		System.out.println("totalCount======================" + totalCount);
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY emp.empId "
					+ strOrderBy;
			System.out.println("strSql====================" + strSql);
			listData = em.createQuery(strSql, AxelaEmp.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;

	}

}
