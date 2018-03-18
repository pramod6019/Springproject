package axela.activities.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.activities.model.AxelaActivity;

@Repository
public interface ActivityRepository extends JpaRepository<AxelaActivity, Integer> {

	@Query(" SELECT activity.activityContactId"
			+ " FROM AxelaActivity activity"
			+ " WHERE activity.activityContactId = :contactId ")
	public String findContactActivity(@Param("contactId") int contactId);

	AxelaActivity findByActivityId(int activityId);

	@Query("SELECT COUNT(a.activityEmpId) FROM AxelaActivity a"
			+ " WHERE a.activityEmpId =:empId")
	public int findByActivityEmpId(@Param("empId") int empId);

}
