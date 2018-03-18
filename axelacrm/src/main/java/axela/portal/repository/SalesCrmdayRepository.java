package axela.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaSalesCrmday;
@Repository
public interface SalesCrmdayRepository extends JpaRepository<AxelaSalesCrmday, Integer>{

}
