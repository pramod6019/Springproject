package axela.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import axela.portal.model.AxelaAccVoucherTran;

public interface AccVoucherTranRepository extends JpaRepository<AxelaAccVoucherTran, Integer> {

	@Query("SELECT COUNT(itemOption.vouchertransId) AS optionItemId"
			+ "  FROM AxelaAccVoucherTran itemOption"
			+ " WHERE 1=1"
			+ " AND itemOption.vouchertransId=:vouchertransId")
	public int findByvouchertransItemId(@Param("vouchertransId") int vouchertransItemId);

}
