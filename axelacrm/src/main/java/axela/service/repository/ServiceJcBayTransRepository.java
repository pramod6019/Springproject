package axela.service.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.service.model.AxelaServiceJcBayTran;

public interface ServiceJcBayTransRepository extends JpaRepository<AxelaServiceJcBayTran, Integer> {

	@Transactional
	@Modifying
	@Query("UPDATE AxelaServiceJcBayTran tran"
			+ " SET"
			+ " tran.baytransEndTime =:baytransEndTime"
			+ " WHERE tran.baytransEndTime = '1971-01-01 01:01:01'"
			+ " AND tran.baytransEmpId =:baytransEmpId")
	public int updateByBaytransEndTime(@Param("baytransEmpId") int baytransEmpId, @Param("baytransEndTime") Date baytransEndTime);

}
