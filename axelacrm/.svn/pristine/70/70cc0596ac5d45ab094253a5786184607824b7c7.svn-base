package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaActivityStatus;
@Repository
public interface ActivityStatusRepository extends JpaRepository<AxelaActivityStatus, Integer> {
	public List<AxelaActivityStatus> findAll();

	public AxelaActivityStatus findByStatusId(int parseInt);

	public List<AxelaActivityStatus> findByStatusDesc(String statusDesc);

	@Query("SELECT status.statusId,status.statusDesc FROM AxelaActivityStatus status WHERE 1=1 AND status.statusId !=:statusId AND status.statusDesc=:statusDesc")
	public List<AxelaActivityStatus> findStatusDesc(@Param("statusId") int statusId, @Param("statusDesc") String statusDesc);
}
