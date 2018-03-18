package axela.service.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.accounting.model.AxelaAccVoucher;
import axela.service.repository.VoucherRepository.VoucherFilterRepository;
@Repository
@Transactional(readOnly = true)
public class VoucherRepositoryImpl implements VoucherFilterRepository {
	@PersistenceContext
	EntityManager em;
	public static int listLength = 0;

	public List<AxelaAccVoucher> findAllVoucher(String strSearch) {
		String Query = " SELECT NEW AxelaAccVoucher ( "
				+ " voucher.voucherId, "
				+ " voucher.voucherNo, "
				+ " voucher.voucherAmount,"
				+ " COALESCE(voucher.voucherNarration,'') AS voucherNarration, "
				+ " voucher.voucherDate, "
				+ " voucher.voucherActive, "
				+ " voucher.voucherOpprId, "
				+ " voucher.voucherQuoteId, "
				+ " voucher.voucherInvoiceId, "
				+ " voucher.voucherSoId, "
				+ " voucher.voucherDelnoteId, "
				+ " voucher.voucherPoId, "
				+ " branch.branchName, "
				+ " branch.branchCode, "
				+ " voucher.voucherCustomerId, "
				+ " voucher.voucherContactId, "
				+ " type.vouchertypeVoucherclassId,"
				// + " COALESCE(ledger_id,'0') AS ledger_id, COALESCE(ledger_name,'') AS ledger_name,"
				+ " COALESCE(customer.customerName,'') AS customerName, "
				+ " voucher.voucherBranchId,"
				+ " voucher.voucherAuthorize, "
				+ " COALESCE(title.titleDesc,'') AS titleDesc,"
				+ " COALESCE(contact.contactFname,'') AS contactFname,"
				+ " COALESCE(contact.contactLname,'') AS contactLname, "
				+ " COALESCE(contact.contactMobile1,'') AS contactMobile1,"
				+ " COALESCE(contact.contactMobile2,'') AS contactMobile2,"
				+ " COALESCE(contact.contactEmail1,'') AS contactEmail1,"
				+ " COALESCE(contact.contactEmail2,'') AS contactEmail2,"
				+ " COALESCE(emps.empName,'') AS empName,"
				+ " COALESCE(emps.empRefNo,'') AS empRefNo,"
				// + " empPhoto,"
				+ " COALESCE(emps.empGender,'') AS empGender, "
				+ " COALESCE(emps.empId,'0') AS empId,"
				+ " type.vouchertypeId, "
				+ " type.vouchertypeName, "
				+ " type.vouchertypePrefix, "
				+ " type.vouchertypeSuffix, "
				+ " type.vouchertypeEmailEnable,"
				+ " type.vouchertypeSmsEnable, "
				+ " type.vouchertypeDocs, "
				+ " voucherClass.voucherclassId,"
				+ " voucherClass.voucherclassFile "
				+ " ) FROM AxelaAccVoucher voucher "
				+ " INNER JOIN voucher.axelaAccVoucherType type"
				+ " LEFT JOIN voucher.axelaCustomerContact contact"
				+ " JOIN type.axelaAccVoucherClass voucherClass"
				// + " LEFT JOIN a.axelaAccVoucherTran.axelaInventoryitem"
				+ " LEFT JOIN voucher.axelaCustomer customer"
				+ " LEFT JOIN contact.axelaTitle title"
				+ " LEFT JOIN voucher.axelaBranch branch"
				+ " LEFT JOIN voucher.axelaEmp emps"
				+ " WHERE 1 = 1"
				+ strSearch;
		TypedQuery<AxelaAccVoucher> typedQuery = em.createQuery(Query, AxelaAccVoucher.class);
		em.clear();
		return typedQuery.getResultList();
	}
}
