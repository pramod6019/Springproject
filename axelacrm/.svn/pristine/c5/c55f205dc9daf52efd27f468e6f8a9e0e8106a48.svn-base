package axela.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.portal.model.AxelaEmp;

@Repository
public interface Signin_Repository extends JpaRepository<AxelaEmp, Long> {

	Connect cnt = new Connect();

	// After 'findBy' The suffix shuld be Entity field name and first letter shuld be camel caps
	AxelaEmp findByEmpEmail1AndEmpUpass(String empEmail1, String empUpass);

	// To delete data from emp_user table
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM AxelaEmpUser  WHERE axelaEmp.empId=:empId", nativeQuery = false)
	int deleteByEmpId(@Param("empId") int empId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE  AxelaEmpLog "
			+ " SET logSignoutTime =:time,"
			+ " logRemoteHost=:iP,"
			+ " logRemoteAgent=:hostName"
			+ " WHERE axelaEmp.empId=:empId"
			+ " AND logSignoutTime=''", nativeQuery = false)
	int updateByEmpId(@Param("empId") int empId, @Param("time") String time, @Param("iP") String IP, @Param("hostName") String hostName);

	// To insert data into log table
	@Transactional
	@Modifying
	@Query(value = " INSERT INTO axela_emp_log"
			+ "(log_emp_id,"
			+ " log_signin_time,"
			+ " log_session_id,"
			+ " log_remote_host,"
			+ " log_remote_agent,"
			+ " log_attemptcount)"
			+ " VALUES("
			+ " :empId,"
			+ " :time,"
			+ " :logSessionId,"
			+ " :logRemoteHost,"
			+ " :logRemoteAgent,"
			+ " :logAttemptcount)", nativeQuery = true)
	int saveLog(@Param("empId") int empId, @Param("time") String time, @Param("logSessionId") String userJsessionid, @Param("logRemoteHost") String logRemoteHost,
			@Param("logRemoteAgent") String logRemoteAgent,
			@Param("logAttemptcount") int logAttemptcount);

	// Inserting data to user table
	@Transactional
	@Modifying
	@Query(value = " INSERT INTO axela_emp_user"
			+ "(user_jsessionid,user_emp_id, user_logintime,user_ip,user_agent)"
			+ " VALUES(:userJsessionid,:empId, :time,:logRemoteHost,:logRemoteAgent)", nativeQuery = true)
	int saveUser(@Param("empId") int empId, @Param("time") String time, @Param("logRemoteHost") String logRemoteHost, @Param("logRemoteAgent") String logRemoteAgent,
			@Param("userJsessionid") String userJsessionid);
}