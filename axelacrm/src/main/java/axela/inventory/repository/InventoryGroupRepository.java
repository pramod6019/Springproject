package axela.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.inventory.model.AxelaInventoryGroup;
@Repository
public interface InventoryGroupRepository extends JpaRepository<AxelaInventoryGroup, Integer> {

	@Query(" SELECT invgroup.groupType "
			+ " FROM AxelaInventoryGroup invgroup "
			+ " WHERE invgroup.groupId=:groupId  ")
	String groupType(@Param("groupId") int groupId);

	@Query(" SELECT "
			+ " invgroup.groupId, "
			+ " invgroup.groupName "
			+ " FROM AxelaInventoryGroup invgroup ")
	List<Object[]> findGroupDetails();

}
