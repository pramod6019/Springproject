package axela.app.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import axela.sales.model.AxelaSalesOppr;

public interface AppReportExecutiveDash extends JpaRepository<AxelaSalesOppr, Integer> {

	interface HomeOpprRepository {

	}

}
