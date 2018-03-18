package axela.app.sales.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import axela.app.sales.repository.HomeSalesRepository.HomeOpprRepository;

public class AppReportExecutiveDashImpl implements HomeOpprRepository {

	@PersistenceContext
	EntityManager em;

	public String findexeopprCount(int empId, String strSearch, String currentDate, String branchId) {

		String Query = "SELECT COALESCE(COUNT(a.opprId),"
				+ " a.axelaEmp.empId,"
				+ " a.axelaBranch.branchId"
				+ ", 0) AS opportunities"
				+ " FROM AxelaSalesOppr a "
				+ " JOIN a.axelaEmp"
				+ " JOIN a.axelaBranch"
				+ " WHERE SUBSTRING(a.opprDate,1,6)= SUBSTRING('" + currentDate + "',1,6)";
		Query += " AND a.opprEmpId=" + empId;
		System.out.println("Query=================" + Query);
		String typedQuery = em.createQuery(Query).getResultList().get(0) + "";
		em.clear();
		return typedQuery;
	}

	public String findexejcCount(int empId, String strSearch, String currentDate, String branchId) {
		String Query = "SELECT COALESCE(COUNT(a.jcId),"
				+ " a.axelaEmp.empId,"
				+ " a.axelaBranch.branchId"
				+ ", 0) AS jobcard"
				+ " FROM AxelaServiceJc a "
				+ " JOIN a.axelaEmp"
				+ " JOIN a.axelaBranch"
				+ " WHERE 1=1"
				+ " AND SUBSTRING(a.jcTimeIn,1,6)= SUBSTRING('" + currentDate + "',1,6)";
		Query += " AND a.jcEmpId=" + empId;
		System.out.println("Query=================" + Query);
		String typedQuery = em.createQuery(Query).getResultList().get(0) + "";
		em.clear();
		return typedQuery;
	}

	public String findexeticketCount(int empId, String strSearch, String currentDate, String branchId) {

		String Query = "SELECT COALESCE(COUNT(a.ticketId),"
				+ " a.axelaEmp.empId"
				+ ", 0) AS Ticket"
				+ " FROM AxelaHelpDeskTicket a "
				+ " JOIN a.axelaEmp"
				+ " WHERE 1=1"
				+ " AND SUBSTRING(a.ticketReportTime,1,6)= SUBSTRING('" + currentDate + "',1,6)";
		Query += " AND a.ticketEmpId=" + empId;
		System.out.println("Query=================" + Query);
		String typedQuery = em.createQuery(Query).getResultList().get(0) + "";
		em.clear();
		return typedQuery;
	}

}
