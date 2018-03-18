package axela.inventory.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.inventory.model.AxelaInventorySalescatTran;

public interface InventorySalescatTransRepository extends JpaRepository<AxelaInventorySalescatTran, Integer> {

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM AxelaInventorySalescatTran salescatTrans WHERE salescatTrans.transSalescatId=:transSalescatId")
	int deleteByTransSalescatId(@Param("transSalescatId") int transSalescatId);

}
