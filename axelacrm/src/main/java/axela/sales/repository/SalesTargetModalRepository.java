package axela.sales.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.sales.model.AxelaSalesTargetModel;

@Repository
public interface SalesTargetModalRepository extends JpaRepository<AxelaSalesTargetModel, Integer> {

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM AxelaSalesTargetModel salesTargetModel WHERE salesTargetModel.modeltargetTargetId=:modeltargetTargetId")
	int deleteByModeltargetTargetId(@Param("modeltargetTargetId") int modeltargetTargetId);

	interface SalesTargetModelFilter {

	}
}
