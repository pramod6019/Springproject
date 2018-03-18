package axela.service.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.service.model.AxelaModuleReport;

@Repository
@Transactional(readOnly = true)
public class ModuleReportFilterImpl extends Connect {
	@PersistenceContext
	EntityManager em;
	public static int listLength = 0;
	public List<AxelaModuleReport> findAll()
	{
		TypedQuery<AxelaModuleReport> typedQuery = null;
		String strSql = "SELECT NEW AxelaModuleReport("
				+ " report.reportId,"
				+ " report.reportName,"
				+ " report.reportUrl)"
				+ " FROM AxelaModuleReport report"
				+ " INNER JOIN report.axelaModule"
				+ " WHERE report.reportModuleId = 8"
				+ " AND report.reportModuledisplay = 1"
				+ " AND report.reportActive = 1"
				+ " ORDER BY report.reportRank";
		typedQuery = em.createQuery(strSql, AxelaModuleReport.class);
		listLength = em.createQuery(strSql, AxelaModuleReport.class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}
}
