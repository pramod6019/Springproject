package axela.sales.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.sales.model.AxelaSalesTeamExe;

public interface SalesTeamexeRepository extends JpaRepository<AxelaSalesTeamExe, Integer> {

	@Query("SELECT teamExe.teamtransEmpId "
			+ " FROM  AxelaSalesTeamExe teamExe "
			+ " WHERE teamExe.teamtransTeamId =:teamtransTeamId ")
	List<Object> findByTeamtransId(@Param("teamtransTeamId") int teamtransTeamId);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM AxelaSalesTeamExe a WHERE a.teamtransTeamId=:teamId")
	void deletebyTeamId(@Param("teamId") int teamId);

	@Query("SELECT a.teamtransTeamId  FROM  AxelaSalesTeamExe a WHERE a.teamtransEmpId =:teamtransEmpId")
	int findByEmpTeamId(@Param("teamtransEmpId") int teamtransEmpId);

	@Query("SELECT a.teamtransTeamId  FROM  AxelaSalesTeamExe a WHERE a.teamtransEmpId =:teamtransEmpId")
	int findEmpIds(@Param("teamtransEmpId") int teamtransEmpId);
}
