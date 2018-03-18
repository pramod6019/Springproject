package axela.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.portal.model.AxelaCustomerGroup;

public interface AxelaCustomerGroupRepository extends JpaRepository<AxelaCustomerGroup, Integer> {

	@Query("SELECT a.groupDesc FROM AxelaCustomerGroup a WHERE a.groupId=:gropuId")
	public String findByGroupId(@Param("gropuId") int gropuId);

	@Query("SELECT group.groupId,group.groupDesc FROM AxelaCustomerGroup group")
	public List<Object[]> findByGroup();
}
