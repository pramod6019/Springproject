package axela.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.inventory.model.AxelaInventoryGroup;

public interface AxelaItemGroupRepository extends JpaRepository<AxelaInventoryGroup, Integer> {

	@Query("SELECT a.groupName FROM AxelaInventoryGroup a WHERE a.groupName=:groupName")
	public List<AxelaInventoryGroup> findByGroupName(@Param("groupName") String groupName);

	@Query("SELECT (COALESCE(MAX(a.delstatusRank),0)+1) FROM AxelaAccDelstatus  a WHERE 1=1 ")
	public Integer findrank();

}
