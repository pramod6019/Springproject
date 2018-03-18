package axela.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import axela.service.model.AxelaModuleReport;

public interface HelpDeskModuleReportRepository extends JpaRepository<AxelaModuleReport, Integer> {

}
