package axela.service.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import axela.accounting.model.AxelaAccVoucher;
@Repository
public interface VoucherRepository extends JpaRepository<AxelaAccVoucher, Integer> {

	@Query("SELECT a FROM AxelaAccVoucher a")
	public List<AxelaAccVoucher> findAll();

	@Query("SELECT voucher.voucherContactId "
			+ " FROM AxelaAccVoucher voucher"
			+ " WHERE voucher.voucherContactId=:contactId")
	public String findContact(@Param("contactId") int contactId);

	@Query("SELECT NEW AxelaAccVoucher(voucherClass.voucherclassId , voucherClass.voucherclassFile)"
			+ " FROM AxelaAccVoucherClass voucherClass"
			+ " JOIN voucherClass.axelaAccVoucherType type"
			+ " WHERE type.vouchertypeId = :vouchertypeId")
	public AxelaAccVoucher findVoucherClassFile(@Param("vouchertypeId") int vouchertypeId);

	@Query("SELECT location.locationId"
			+ " FROM AxelaInventoryLocation location"
			+ " WHERE location.locationBranchId =:branchId")
	public List findLocation(@Param("branchId") int branchId);

	@Query("SELECT voucher.voucherPaymentDate FROM "
			+ " AxelaAccVoucher voucher"
			+ " WHERE voucher.voucherSoId =:voucherSoId")
	public Date findPaymentDate(@Param("voucherSoId") int voucherSoId);

	@Query("SELECT NEW AxelaAccVoucher(voucherClass.voucherclassFile, voucherClass.voucherclassAcc, type.vouchertypeName,"
			+ " type.vouchertypeMobile,  type.vouchertypeEmail, type.vouchertypeDob,"
			+ " type.vouchertypeDnd, type.vouchertypeAffectsInventory,"
			+ " type.vouchertypeRefNoEnable, type.vouchertypeRefNoMandatory,"
			+ " type.vouchertypeTerms,"
			+ " COALESCE(type.vouchertypeEmailEnable, '') AS vouchertypeEmailEnable,"
			+ " COALESCE(type.vouchertypeEmailAuto, '') AS vouchertypeEmailAuto,"
			+ " COALESCE(type.vouchertypeEmailSub, '') AS vouchertypeEmailSub,"
			+ " COALESCE(type.vouchertypeEmailFormat, '') AS vouchertypeEmailFormat,"
			+ " COALESCE(type.vouchertypeSmsEnable, '') AS vouchertypeSmsEnable,"
			+ " COALESCE(type.vouchertypeSmsAuto, '') AS vouchertypeSmsAuto,"
			+ " COALESCE(type.vouchertypeSmsFormat, '') AS vouchertypeSmsFormat,"
			+ " config.configAdminEmail, config.configEmailEnable, config.configSmsEnable,"
			+ " comp.compEmailEnable, comp.compSmsEnable,"
			+ " type.vouchertypeBillingAdd, type.vouchertypeConsigneeAdd,"
			+ " type.vouchertypeTransporter, type.vouchertypeGatepass, type.vouchertypeLrno,"
			+ " type.vouchertypeTempoNo, type.vouchertypeDriverNo,"
			+ " type.vouchertypeCashdiscount, type.vouchertypeTurnoverdisc)"
			+ " FROM AxelaConfig config,"
			+ " AxelaComp comp,"
			+ " AxelaAccVoucherType type"
			+ " JOIN type.axelaAccVoucherClass voucherClass,"
			+ " AxelaEmp emp"
			+ " LEFT JOIN emp.axelaBranch branch ON (branch.branchId=:branchId)"
			+ " WHERE emp.empId =:empId"
			+ " AND voucherClass.voucherclassId =:voucherclassId"
			+ " AND type.vouchertypeId =:vouchertypeId"
			+ " AND type.vouchertypeActive = 1"
			+ " AND branch.branchId =:branchId")
	public AxelaAccVoucher findConfig(@Param("empId") int empId, @Param("voucherclassId") int voucherclassId,
			@Param("vouchertypeId") int vouchertypeId, @Param("branchId") int branchId);

	public interface VoucherFilterRepository {

	}

}
