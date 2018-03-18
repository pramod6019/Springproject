package axela.sales.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.metamodel.Metamodel;

import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaSoe;

@Repository
public class SalesSOEImplFilter {

	@PersistenceContext
	EntityManager em;
	public static Metamodel model;

	public List<Object[]> SoeDashEnquirySummary(String StrStage, String StrStatus, String strSearch) {
		List<Object[]> listData = new ArrayList<Object[]>();
		String strSql = " SELECT  soe.soeName, "
				+ " " + StrStage + ""
				+ " " + StrStatus + " "
				+ "	 COUNT(DISTINCT oppr.opprId) AS Total"
				+ " FROM AxelaSoe soe"
				+ " JOIN soe.axelaSalesOppr oppr"
				+ " JOIN oppr.axelaEmp emp"
				+ " JOIN oppr.axelaBranch branch"
				+ " JOIN oppr.axelaSalesOpprStage stage"
				+ " JOIN oppr.axelaSalesOpprStatus opprstatus"
				+ " LEFT JOIN emp.axelaSalesTeamExe teamExe"
				+ " LEFT JOIN teamExe.axelaSalesTeam team"
				+ " WHERE 1 = 1 "
				+ strSearch
				+ " GROUP BY soe.soeId"
				+ " ORDER BY soe.soeName ";
		TypedQuery<Object[]> typedQuery = em.createQuery(strSql, Object[].class);
		em.clear();
		return typedQuery.getResultList();
	}

	public List<AxelaSoe> SoeDashPieChart(String EnquirySearch) {
		List<AxelaSoe> listData = new ArrayList<AxelaSoe>();
		String strSql = " SELECT NEW AxelaSoe(soe.soeId, soe.soeName, COUNT(DISTINCT oppr.opprId) AS Total) "
				+ " FROM AxelaSoe soe"
				+ " JOIN soe.axelaSalesOppr oppr"
				+ " JOIN oppr.axelaEmp emp"
				+ " JOIN oppr.axelaBranch branch"
				+ " JOIN oppr.axelaSalesOpprStage stage"
				+ " JOIN oppr.axelaSalesOpprStatus opprstatus"
				+ " LEFT JOIN emp.axelaSalesTeamExe teamExe"
				+ " LEFT JOIN teamExe.axelaSalesTeam team"
				+ " WHERE 1 = 1 "
				+ EnquirySearch + ""
				+ " GROUP BY soe.soeId"
				+ " ORDER BY soe.soeName ";
		TypedQuery<AxelaSoe> typedQuery = em.createQuery(strSql, AxelaSoe.class);
		em.clear();
		return typedQuery.getResultList();
	}
}
