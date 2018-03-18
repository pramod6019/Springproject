package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaCfType;
@Repository
public interface SalesCrmCfTypeRepository extends JpaRepository<AxelaCfType, Integer> {

	//List<AxelaCfType> findByCrmcftypeId(int parseInt);

	List<AxelaCfType> findByCftypeId(int parseInt);

}
