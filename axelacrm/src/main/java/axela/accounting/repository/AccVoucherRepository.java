package axela.accounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.accounting.model.AxelaAccVoucher;
@Repository
public interface AccVoucherRepository extends JpaRepository<AxelaAccVoucher, Integer> {

	@Query("SELECT"
			+ " a.voucherCustomerId"
			+ " FROM AxelaAccVoucher a"
			+ " WHERE a.voucherCustomerId=:customerId")
	public String findById(@Param("customerId") int customerId);

	@Query("SELECT COUNT(a.voucherEmpId) FROM AxelaAccVoucher a"
			+ " WHERE a.voucherEmpId =:empId")
	public int findByVoucherEmpId(@Param("empId") int empId);

	@Query("SELECT COUNT(a.voucherBranchId) FROM AxelaAccVoucher a"
			+ " WHERE a.voucherBranchId  =:branchId")
	public int findByVoucherBranchId(@Param("branchId") int branchId);

	@Query("SELECT COUNT(a.voucherBranchId) FROM AxelaAccVoucher a"
			+ " WHERE a.voucherBranchId  =:branchId"
			+ "	AND a.voucherVouchertypeId = 4 ")
	public int findByVoucherVouchertypeId(@Param("branchId") int branchId);

	@Query("SELECT COUNT(a.voucherBranchId) FROM AxelaAccVoucher a"
			+ " WHERE a.voucherBranchId = 9 "
			+ " AND  a.voucherBranchId =:branchId")
	public int findByReciept(@Param("branchId") int branchId);

	@Query("SELECT COUNT(a.voucherBranchId) FROM AxelaAccVoucher a"
			+ " WHERE  a.voucherBranchId = 15 "
			+ " AND  a.voucherBranchId =:branchId")
	public int findByPayment(@Param("branchId") int branchId);

	@Query("SELECT COUNT(a.voucherBranchId) FROM AxelaAccVoucher a"
			+ " WHERE  a.voucherBranchId = 7 "
			+ " AND   a.voucherBranchId =:branchId")
	public int findByBill(@Param("branchId") int branchId);
}
