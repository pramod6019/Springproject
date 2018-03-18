package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaSalesCrmType;

@Repository
public interface SalesCrmTypeRepository extends JpaRepository<AxelaSalesCrmType, Integer>{

	//List<AxelaSalesCrmType> findByCrmTypeId(int parseInt);

	List<AxelaSalesCrmType> findByCrmtypeId(int parseInt);

}
