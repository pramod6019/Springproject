package axela.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import axela.sales.model.AxelaSalesOpprHistory;

@Repository
public interface OpprHistoryRepository extends JpaRepository<AxelaSalesOpprHistory, Integer> {

}
