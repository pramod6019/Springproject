package axela.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import axela.service.model.AxelaModuleReport;

@Repository
public interface ModuleReportRepository extends JpaRepository<AxelaModuleReport, Integer> {

	@Query("SELECT report.reportId, report.reportName, report.reportUrl"
			+ " FROM AxelaModuleReport report"
			+ " JOIN report.axelaModule"
			+ " WHERE report.reportModuleId = 6"
			+ " AND report.reportModuledisplay = 1"
			+ " AND report.reportActive = 1"
			+ " ORDER BY report.reportRank")
	public List<Object[]> findListReports();
}
