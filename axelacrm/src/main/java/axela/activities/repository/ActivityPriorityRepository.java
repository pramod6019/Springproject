package axela.activities.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.activities.model.AxelaActivityPriority;

@Repository
public interface ActivityPriorityRepository extends JpaRepository<AxelaActivityPriority, Integer> {
	@Query(value = "SELECT e.priorityId,e.priorityName "
			+ " FROM AxelaActivityPriority e", nativeQuery = false)
	List<Object[]> findAllActivityPriority();

	@Query(value = "SELECT e.priorityId,e.priorityName "
			+ " FROM AxelaActivityPriority e"
			+ " WHERE e.priorityId=:priorityId"
			+ " ORDER BY e.priorityName", nativeQuery = false)
	List<Object[]> findByActiityPeiorityId(@Param("priorityId") int priorityId);

}
