package axela.service.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.service.model.AxelaServiceContract;
import axela.service.repository.ServiceContractRepository.ServiceContractRepositoryFilter;

@Repository
@Transactional(readOnly = true)
public class ServiceContractImpl extends Connect implements ServiceContractRepositoryFilter {
	@PersistenceContext
	EntityManager em;
	public static String totalCount = "0";
	public static int listLength = 0;
	public String requestType = "";
	public String result = "";

	public List<Object[]> findByContract(String ticketContactId, HttpSession session) {
		String compId = PadQuotes(getSession("compId", session));
		String Query = "SELECT"
				+ " a.contractId,"
				+ " a.contractTitle,"
				+ " a.contractStartDate,"
				+ " a.contractEndDate"
				+ " FROM AxelaServiceContract a"
				+ " WHERE 1=1"
				+ " AND a.contractActive=1"
				+ " and a.contractContactId=" + ticketContactId + ""
				+ " AND  a.contractStartDate<=" + gettimebyzonesql(compId, toLongDate(kknow()))
				+ " AND a.contractEndDate>=" + gettimebyzonesql(compId, toLongDate(kknow())) + " "
				+ " GROUP BY a.contractId "
				+ " ORDER BY a.contractTitle";
		TypedQuery<Object[]> typedQuery = em.createQuery(Query, Object[].class);
		return typedQuery.getResultList();

	}

	public int length(String branchAccess, String exeAccess, String sort, String field) {
		Query query = em.createQuery("SELECT a FROM AxelaServiceContract a WHERE 1=1 AND contract.contractId !='0'" + branchAccess + exeAccess + " ORDER BY contract." + field + " " + sort);
		em.clear();
		return (int) query.getResultList().size();
	}
	public List<AxelaServiceContract> findAll(String strSearch, String strOrderBy, int page, int perPage)
	{
		String sqlJoin = "";
		String countSql = "";
		List<AxelaServiceContract> listData = new ArrayList<AxelaServiceContract>();
		String strSql = "SELECT NEW AxelaServiceContract("
				+ " contract.contractId,"
				+ " contract.contractBranchId,"
				+ " branch.branchId,"
				+ " contact.contactId,"
				+ " contract.contractTicketqueueId, "
				+ " COALESCE(contract.contractTitle, '') AS contractTitle,"
				+ " CONCAT(branch.branchName, ' (', branch.branchCode, ')') AS branchName,"
				+ " contract.contractTax,"
				+ " contract.contractNo,"
				+ " CONCAT('CONT', branch.branchCode, contract.contractNo) AS contractno,"
				+ " customers.customerId,"
				+ " customers.customerName,"
				+ " contract.contractDate,"
				+ " contract.contractRefno,"
				+ " contract.contractNetamt,"
				+ " type.contracttypeName,"
				+ " contract.contractCustomerId,"
				+ " contract.contractContactId,"
				+ " contract.contractStartDate,"
				+ " contract.contractEndDate,"
				+ " contract.contractAmt,"
				+ " contract.contractDesc,"
				+ " contract.contractTerms,"
				+ " contract.contractNotes,"
				+ " contract.contractGrandtotal,"
				+ " CONCAT(title.titleDesc, ' ',contact.contactFname, ' ', contact.contactLname) AS contactName,"
				+ " COALESCE(contact.contactMobile1,'') AS contactMobile1,"
				+ " COALESCE(contact.contactMobile2,'') AS contactMobile2,"
				+ " COALESCE(contact.contactEmail1,'') AS contactEmail1,"
				+ " COALESCE(contact.contactEmail2,'') AS contactEmail2,"
				+ " emp.empId,"
				+ " COALESCE(CONCAT(emp.empName, ' (', emp.empRefNo, ')')) AS empName,"
				+ " emp.empGender,"
				+ " contract.contractEntryId,"
				+ " contract.contractEntryDate,"
				+ " contract.contractModifiedId,"
				+ " contract.contractModifiedDate,"
				+ " contract.contractActive)";
		sqlJoin += " FROM   AxelaServiceContract contract"
				+ " INNER JOIN  contract.axelaBranch branch"
				+ " INNER JOIN  contract.axelaServiceContractType type"
				+ " INNER JOIN  contract.axelaEmp emp"
				+ " INNER JOIN  contract.axelaCustomerContact contact"
				+ " INNER JOIN  contract.axelaCustomers customers"
				+ " INNER JOIN  contact.axelaTitle title"
				+ " WHERE 1 = 1 "
				+ " AND contract.contractId !='0' " + strSearch;
		countSql = "SELECT COUNT(DISTINCT contract.contractId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY contract.contractId"
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaServiceContract.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public List<AxelaServiceContract> populateByContract(String contractId, HttpSession session)
	{
		String Query = "SELECT NEW AxelaServiceContract("
				+ " a.contractBranchId,"
				+ " a.contractContracttypeId,"
				+ " a.contractDate,"
				+ " a.contractStartDate,"
				+ " a.contractEndDate,"
				+ " a.contractTitle,"
				+ " a.contractContactId,"
				+ " a.contractTicketqueueId,"
				+ " a.contractAmt,"
				+ " a.contractTaxId,"
				+ " a.contractDiscamt,"
				+ " a.contractNetamt,"
				+ " a.contractGrandtotal,"
				+ " a.contractTax,"
				+ " a.contractBillAddress,"
				+ " a.contractBillCity,"
				+ " a.contractBillPin,"
				+ " a.contractBillState,"
				+ " a.contractBillCountry,"
				+ " a.contractServiceAddress,"
				+ " a.contractServiceCity,"
				+ " a.contractServicePin,"
				+ " a.contractServiceState,"
				+ " a.contractServiceCountry,"
				+ " a.contractDesc,"
				+ " a.contractTerms,"
				+ " a.contractEmpId,"
				+ " a.contractPo,"
				+ " a.contractPrioritycontractId,"
				+ " a.contractRefno,"
				+ " a.contractActive,"
				+ " a.contractNotes,"
				+ " a.contractEntryDate,"
				+ " a.contractEntryId,"
				+ " a.contractModifiedDate,"
				+ " a.contractModifiedId,"
				+ " a.axelaCustomerContact.axelaTitle.titleId,"
				+ " a.axelaCustomerContact.axelaTitle.titleDesc,"
				+ " a.axelaCustomerContact.contactFname,"
				+ " a.axelaCustomerContact.contactLname,"
				+ " a.axelaCustomerContact.contactMobile1,"
				+ " a.axelaCustomerContact.contactPhone1,"
				+ " a.axelaCustomerContact.contactEmail1,"
				+ " a.axelaCustomerContact.contactPin,"
				+ " a.axelaCustomerContact.contactId,"
				+ " a.axelaCustomerContact.contactCityId,"
				+ " a.axelaCustomers.customerId,"
				+ " a.axelaCustomers.customerName,"
				+ " a.axelaCustomerContact.contactAddress)"
				+ " FROM AxelaServiceContract a"
				+ " INNER JOIN a.axelaBranch "
				+ " INNER JOIN a.axelaServiceContractType "
				+ " INNER JOIN a.axelaCustomerContact "
				+ " INNER JOIN a.axelaCustomers "
				+ " INNER JOIN a.axelaCustomerContact.axelaTitle"
				+ " WHERE 1 = 1"
				+ " AND a.contractId=" + contractId;
		TypedQuery<AxelaServiceContract> typedQuery = (TypedQuery<AxelaServiceContract>) em.createQuery(Query);
		return typedQuery.getResultList();
	}

	public List<Object[]> findBypopulateLanding(String strSearch, HttpSession session)
	{
		String Query = " SELECT contract.axelaBranch.branchId,"
				+ " CONCAT(contract.axelaBranch.branchName,' (', contract.axelaBranch.branchCode, ')') AS branchName,"
				+ " COUNT(contract.contractId) AS contractCount "
				+ " FROM  AxelaServiceContract contract"
				+ " INNER JOIN contract.axelaBranch "
				+ " INNER JOIN contract.axelaServiceContractType "
				+ " INNER JOIN contract.axelaEmp "
				+ " INNER JOIN contract.axelaCustomerContact "
				+ " INNER JOIN contract.axelaCustomers "
				+ " INNER JOIN contract.axelaCustomerContact.axelaTitle "
				+ " WHERE 1 = 1 "
				+ strSearch + ""
				+ " GROUP BY contract.axelaBranch.branchId"
				+ " ORDER BY contract.axelaBranch.branchName";
		TypedQuery<Object[]> typedQuery = em.createQuery(Query, Object[].class);
		listLength = em.createQuery(Query, Object[].class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}
}
