package axela.service.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.service.model.AxelaServiceContract;

@Repository
@Transactional(readOnly = true)
public class ContractFilterImpl extends Connect {

	@PersistenceContext
	EntityManager em;
	public static int listLength = 0;

	public int length(String branchAccess, String exeAccess, String sort, String field) {
		Query query = em.createQuery("SELECT a FROM AxelaServiceContract a WHERE 1=1 AND a.contractId !='0'" + branchAccess + exeAccess + " ORDER BY a." + field + " " + sort);
		em.clear();
		return (int) query.getResultList().size();
	}
	public List<AxelaServiceContract> findAll(String strSearch, int page, int perpage)
	{
		String Query = "SELECT NEW AxelaServiceContract("
				+ " a.contractId,"
				+ " a.contractBranchId,"
				+ " a.axelaBranch.branchId,"
				+ " a.axelaCustomerContact.contactId,"
				+ " a.contractTicketqueueId, "
				+ " COALESCE(a.contractTitle,'') AS contractTitle,"
				+ " CONCAT(a.axelaBranch.branchName, ' (', a.axelaBranch.branchCode, ')') AS branchName,"
				+ " a.contractTax,"
				+ " a.contractNo,"
				+ "CONCAT('CONT', branch_code, contract_no) AS contractno,"
				+ " a.axelaCustomers.customerName,"
				+ " a.contractDate,"
				+ " a.contractRefno,"
				+ " a.contractNetamt,"
				+ " a.axelaServiceContractType.contracttypeName,"
				+ " a.contractCustomerId,"
				+ " a.contractContactId,"
				+ " a.contractStartDate,"
				+ " a.contractEndDate,"
				+ " a.contractGrandtotal,"
				+ " CONCAT(a.axelaCustomerContact.axelaTitle.titleDesc, ' ',a.axelaCustomerContact.contactFname, ' ', a.axelaCustomerContact.contactLname) AS contactName,"
				+ " COALESCE(a.axelaCustomerContact.contactMobile1,'') AS contactMobile1,"
				+ " COALESCE(a.axelaCustomerContact.contactMobile2,'') AS contactMobile2,"
				+ " COALESCE(a.axelaCustomerContact.contactEmail1,'') AS contactEmail1,"
				+ " COALESCE(a.axelaCustomerContact.contactEmail2,'') AS contactEmail2,"
				+ " a.axelaEmp.empId,"
				+ " COALESCE(CONCAT(a.axelaEmp.empName, ' (', a.axelaEmp.empRefNo, ')')) AS empName,"
				+ " a.axelaEmp.empGender,"
				+ " a.contractActive)"
				+ " FROM   AxelaServiceContract a "
				+ " INNER JOIN  a.axelaBranch "
				+ " INNER JOIN  a.axelaServiceContractType "
				+ " INNER JOIN  a.axelaEmp "
				+ " INNER JOIN  a.axelaCustomerContact "
				+ " INNER JOIN  a.axelaCustomers "
				+ " INNER JOIN  a.axelaCustomerContact.axelaTitle "
				+ " WHERE 1 = 1 "
				+ " AND a.contractId !='0' " + strSearch;
		TypedQuery<AxelaServiceContract> typedQuery = em.createQuery(Query, AxelaServiceContract.class).setFirstResult((page - 1) * perpage).setMaxResults(perpage);
		listLength = em.createQuery(Query, AxelaServiceContract.class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}
}
