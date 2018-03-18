package axela.accounting.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import axela.accounting.model.AxelaAccVoucher;

@Repository
public class VoucherFilterImpl {

	public static String totalCount = "0";

	@PersistenceContext
	EntityManager em;

	public List<AxelaAccVoucher> findAll(String voucherTypeId, String strSearch, String strOrderBy, int page, int perPage, String app) {
		String sqlJoin = "";
		String countSql = "";
		String strSql = "";
		List<AxelaAccVoucher> listData = new ArrayList<AxelaAccVoucher>();
		strSql = "SELECT NEW AxelaAccVoucher(voucher.voucherId,"
				+ " voucher.voucherNo,"
				+ " voucher.voucherAmount,";
		// if (voucherTypeId.equals("4")) {
		strSql += " voucher.voucherVouchertypeId,"
				+ " branch.branchInvoicePrefix,"
				+ " branch.branchInvoiceSuffix,";
		// }
		// if (voucherTypeId.equals("")) {
		// strSql += " voucher.voucherVouchertypeId,"
		// + " branch.branchReceiptPrefix,"
		// + " branch.branchReceiptsuffix,";
		// }
		// if (voucherTypeId.equals("")) {
		// strSql += " voucher.voucherVouchertypeId,"
		// + " voucher.branchBillPrefix"
		// + " ''";
		// }
		// if (voucherTypeId.equals("")) {
		// strSql += " voucher.voucherVouchertypeId,"
		// + " voucher.vouchertypePrefix,"
		// + " voucher.vouchertypeSuffix";
		// }
		strSql += " voucher.voucherSoId,"
				+ " type.vouchertypeVoucherclassId,"
				+ " type.vouchertypeName,"
				+ " voucher.voucherAuthorize,"
				+ " voucher.voucherActive,"
				+ " voucher.voucherJcId,"
				+ " voucher.voucherCustomerId,"
				+ " customer.customerName,"
				+ " customer.customerEntryDate,"
				+ " voucher.voucherContactId,"
				+ " contact.contactFname,"
				+ " contact.contactLname,"
				+ " contact.axelaTitle.titleDesc,"
				+ " contact.contactMobile1,"
				+ " contact.contactMobile2,"
				+ " contact.contactPhone1,"
				+ " contact.contactPhone2,"
				+ " contact.contactEmail1,"
				+ " contact.contactEmail2,"
				+ " voucher.voucherRefNo,"
				+ " voucher.voucherNarration,"
				+ " voucher.voucherDate,"
				+ " emp.empName,"
				+ " branch.branchName,"
				+ " voucherClass.voucherclassFile,"
				+ " voucher.voucherEmpId"
				+ " )";
		sqlJoin = " FROM AxelaAccVoucher voucher "
				+ " JOIN voucher.axelaAccVoucherTran voucherTran "
				+ " JOIN voucher.axelaAccvouchertype type"
				+ " JOIN type.axelaAccVoucherClass voucherClass"
				+ " LEFT JOIN voucher.axelaCustomer customer"
				+ " LEFT JOIN voucher.axelaEmp emp"
				+ " LEFT JOIN voucher.axelaBranch branch"
				+ " LEFT JOIN voucher.axelaCustomerContact contact"
				+ " WHERE 1=1 "
				+ strSearch;
		countSql = "SELECT COUNT( DISTINCT voucher.voucherId) " + sqlJoin;
		// System.out.println("strSql=============" + countSql);
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY voucher.voucherId"
					+ strOrderBy;
			System.out.println("strSql=============" + strSql);
			listData = em.createQuery(strSql, AxelaAccVoucher.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.clear();
		return listData;
	}
}
