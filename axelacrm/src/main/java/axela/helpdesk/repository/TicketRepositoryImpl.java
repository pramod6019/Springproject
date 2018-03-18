package axela.helpdesk.repository;

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
import axela.helpdesk.model.AxelaHelpDeskTicket;
import axela.helpdesk.model.AxelaHelpDeskTicketHistory;
import axela.helpdesk.model.AxelaHelpDeskTicketHoli;
import axela.helpdesk.repository.TicketRepository.TicketRepositoryFilter;
import axela.portal.model.AxelaConfig;

@Repository
@Transactional(readOnly = true)
public class TicketRepositoryImpl extends Connect implements TicketRepositoryFilter {
	public static String totalCount = "0";
	public static int listLength = 0;
	public long Length = 0L;
	@PersistenceContext
	EntityManager em;

	public List<AxelaConfig> findAllByPopulateConfig(int ticketEmpId, int empId) {
		Query query = em.createQuery("SELECT NEW AxelaConfig("
				+ "a.configServiceContract,"
				+ " a.configHelpDeskTicketCat,"
				+ " a.configHelpdeskTicketType,"
				+ " b.compModulePm,"
				+ " a.configTicketNewSmsFormat,"
				+ " a.configEmailEnable,"
				+ " a.configAdminEmail,"
				+ " a.configTicketNewEmailEnable,"
				+ " a.configTicketNewEmailFormat,"
				+ " a.configTicketNewEmailSub,"
				+ " a.configTicketNewSmsEnable,"
				+ " a.configTicketNewEmailExeFormat,"
				+ " a.configTicketNewEmailExeSub,"
				+ " a.configTicketNewSmsExeFormat,"
				+ " b.compSmsEnable,"
				+ " a.configSmsEnable,"
				+ " a.configTicketFollowupSmsFormat,"
				+ " b.compEmailEnable,"
				+ " a.configHelpDeskTicketRefno,"
				+ " COALESCE(ticketemp.empEmail1,'') AS empEmail1,"
				+ " COALESCE(ticketemp.empEmail2,'') AS empEmail2,"
				+ " COALESCE(ticketemp.empName,'') AS empName,"
				+ " COALESCE(ticketemp.empMobile1,'') AS empMobile1,"
				+ " COALESCE(ticketemp.empMobile2,'') AS empMobile2,"
				+ " COALESCE(ticketentry.empEmail1,'') AS entryempEmail)"
				+ " FROM AxelaConfig a,AxelaComp b,"
				+ " AxelaEmp ticketemp,"
				+ " AxelaEmp ticketentry"
				+ " WHERE ticketemp.empId = '" + ticketEmpId + "'"
				+ " AND ticketentry.empId = '" + empId + "'");
		return query.getResultList();
	}

	public AxelaHelpDeskTicket findTicket(int ticketId) {
		String Query = "SELECT NEW AxelaHelpDeskTicket("
				+ " a.ticketId,"
				+ " a.ticketEntryDate)"
				+ " FROM AxelaHelpDeskTicket a"
				+ " WHERE a.ticketId=" + ticketId;

		TypedQuery<AxelaHelpDeskTicket> typedQuery = em.createQuery(Query, AxelaHelpDeskTicket.class);
		return typedQuery.getSingleResult();
	}

	public List<AxelaHelpDeskTicket> PopulateFields(int ticketParentId, String branchAccess, String exeAccess) {
		String Query = "SELECT a,"
				+ " COALESCE(CONCAT(a.axelaTitle.titleDesc,' ',a.axelaCustomerContact.contactFname,' ',a.axelaCustomerContact.contactLname),'') as contactName, "
				+ " COALESCE(a.axelaCustomer.customerName,'') as customerName,"
				+ " COALESCE(a.axelaCustomer.customerBranchId, 0) as customerBranchId "
				+ " FROM AxelaHelpDeskTicket a"
				+ " INNER JOIN a.axelaEmp"
				+ " LEFT JOIN a.axelaCustomerContact"
				+ " LEFT JOIN a.axelaCustomer"
				+ " LEFT JOIN a.axelaBranch" + branchAccess
				+ " LEFT JOIN a.axelaTitle"
				+ " WHERE a.ticketId=" + ticketParentId + exeAccess;

		TypedQuery<AxelaHelpDeskTicket> typedQuery = em.createQuery(Query, AxelaHelpDeskTicket.class);
		return typedQuery.getResultList();
	}

	public List<AxelaHelpDeskTicket> findAll(String strSearch, String strOrderBy, int page, int perPage, String app) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaHelpDeskTicket> listData = new ArrayList<AxelaHelpDeskTicket>();
		String strSql = "SELECT NEW AxelaHelpDeskTicket(" + " ticket.ticketId,";
		if (app.equals("yes")) {
			strSql += " 0,"
					+ " 0,"
					+ " 0,"
					+ " 'null',"
					+ " 'null',"
					+ " 'null',"
					+ " 0,"
					+ " 0,"
					+ " 0,"
					+ " 0,"
					+ " 0,";
		} else {
			strSql += " ticket.ticketOpprId,"
					+ " ticket.ticketSoId,"
					+ " ticket.ticketCrmId,"
					+ " ticket.ticketSubject,"
					+ " ticket.ticketDesc,"
					+ " ticket.ticketJcSerialno,"
					+ " ticket.ticketJcId,"
					+ " ticket.ticketJcpsfId,"
					+ " ticket.ticketCustomerId,"
					+ " ticket.ticketContactId,"
					+ " ticket.ticketTrigger,";
		}

		strSql += " COALESCE(ticket.axelaCustomer.customerId, 0) AS customerId,"
				+ " COALESCE(ticket.axelaCustomer.customerName, '') AS customerName,"
				+ " COALESCE(ticket.axelaHelpDeskTicketCat.ticketcatName, '') AS ticketcatName,"
				+ " COALESCE(ticket.axelaHelpDeskTicketType.tickettypeName, '') AS tickettypeName,"
				+ " ticket.axelaHelpDeskTicketPriority.priorityticketName,"
				+ " ticket.axelaHelpDeskTicketPriority.priorityticketId,"
				+ " COALESCE(CONCAT(ticket.axelaCustomerContact.axelaTitle.titleDesc, ' ', ticket.axelaCustomerContact.contactFname, ' ', ticket.axelaCustomerContact.contactLname), '') AS contactName,"
				+ " COALESCE(ticket.axelaCustomerContact.contactMobile1, '') AS contactMobile1,"
				+ " COALESCE(ticket.axelaCustomerContact.contactMobile2, '') AS contactMobile2,"
				+ " COALESCE(ticket.axelaCustomerContact.contactEmail1, '') AS contactEmail1,"
				+ " COALESCE(ticket.axelaCustomerContact.contactEmail2,'') AS contactEmail2,"
				+ " ticket.axelaHelpDeskTicketStatus.ticketstatusId,"
				+ " ticket.axelaHelpDeskTicketStatus.ticketstatusName,"
				+ " ticket.axelaEmp.empId,"
				+ " COALESCE(ticket.axelaHelpDeskTicketQueue.ticketqueueName,'') AS ticketqueueName,"
				+ " CONCAT(ticket.axelaEmp.empName, ' (', ticket.axelaEmp.empRefNo, ')') AS empName,"
				// + " OCTET_LENGTH(COALESCE (a.axelaEmp.empPhoto, '0')) AS empPhoto,"
				+ " ticket.axelaEmp.empGender,"
				+ " ticket.ticketReportTime,"
				+ " ticket.ticketDueTime,"
				+ " ticket.ticketClosedTime,"
				+ " ticket.ticketContractId,"
				+ " ticket.ticketAssetId,"
				+ " COALESCE(ticket.axelaServiceContract.contractTitle, '') AS contractTitle,"
				+ " COALESCE(ticket.axelaServiceContractAsset.assetName, '') AS assetName)";
		sqlJoin += " FROM AxelaHelpDeskTicket ticket"
				+ " INNER JOIN ticket.axelaEmp emp"
				+ " INNER JOIN ticket.axelaHelpDeskTicketSource"
				+ " INNER JOIN ticket.axelaHelpDeskTicketStatus"
				+ " LEFT JOIN ticket.axelaHelpDeskTicketQueue"
				+ " INNER JOIN ticket.axelaHelpDeskTicketPriority"
				+ " LEFT JOIN ticket.axelaCustomerContact"
				+ " LEFT JOIN ticket.axelaCustomer"
				+ " LEFT JOIN ticket.axelaCustomerContact.axelaTitle"
				+ " LEFT JOIN ticket.axelaCustomer.axelaBranch"
				+ " LEFT JOIN ticket.axelaHelpDeskTicketCat"
				+ " LEFT JOIN ticket.axelaHelpDeskTicketType"
				+ " LEFT JOIN ticket.axelaServiceContract"
				+ " LEFT JOIN ticket.axelaServiceContractAsset"
				+ " LEFT JOIN ticket.axelaSalesOppr"
				+ " WHERE 1 = 1" + strSearch;
		countSql = "SELECT COUNT(DISTINCT ticket.ticketId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY ticket.ticketId"
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaHelpDeskTicket.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public AxelaHelpDeskTicket findOneForDash(int ticketId, String branchAccess, String exeAccess) {
		String Query = "SELECT NEW AxelaHelpDeskTicket("
				+ " a.ticketId,"
				+ " a.ticketContactId,"
				+ " a.ticketCustomerId,"
				+ " a.ticketJcId,"
				+ " a.ticketParentId,"
				+ " a.ticketTicketstatusId,"
				+ " a.ticketTicketcatId,"
				+ " a.ticketTickettypeId,"
				+ " a.ticketPmId,"
				+ " a.ticketContractId,"
				+ " a.ticketAssetId,"
				+ " a.ticketSubject,"
				+ " a.ticketDesc,"
				+ " a.ticketClosedTime,"
				+ " a.ticketClosedComments,"
				+ " a.ticketEmpId,"
				+ " a.ticketRead,"
				+ " a.ticketRefno,"
				+ " a.ticketJcpsfId,"
				+ " a.ticketTicketsourceId,"
				+ " a.ticketReportTime,"
				+ " a.ticketTicketqueueId,"
				+ " a.ticketPriorityticketId,"
				+ " a.ticketDueTime,"
				+ " a.ticketEntryId,"
				+ " a.ticketEntryDate,"
				+ " a.ticketJcSerialno,"
				+ " COALESCE(a.axelaCustomerContact.contactId, 0) AS contactId,"
				+ " COALESCE(CONCAT(a.axelaCustomerContact.axelaTitle.titleDesc,' ',a.axelaCustomerContact.contactFname,' ',a.axelaCustomerContact.contactLname),'') AS contactName,"
				+ " COALESCE(a.axelaCustomerContact.contactEmail1, '') AS contactEmail1,"
				+ " COALESCE(a.axelaCustomerContact.contactEmail2, '') AS contactEmail2,"
				+ " COALESCE(a.axelaCustomerContact.contactMobile1, '') AS contactMobile1,"
				+ " COALESCE(a.axelaCustomerContact.contactMobile2, '') AS contactMobile2, "
				+ " COALESCE(a.axelaCustomer.customerName,'') AS customerName,"
				+ " COALESCE(a.axelaCustomer.customerBranchId, 0) AS customerBranchId, "
				+ " COALESCE(a.axelaServiceContract.contractTitle, '') AS contractTitle,"
				+ " COALESCE(a.axelaServiceContract.contractStartDate,'') AS contractStartDate, "
				+ " COALESCE(a.axelaServiceContract.contractEndDate,'') AS contractEndDate,"
				+ " COALESCE(a.axelaServiceContractAsset.assetName, '') AS assetName, "
				+ " COALESCE(tran.tickettransContactEntryId,'') AS tickettransContactEntryId,"
				+ " COALESCE(a.axelaServiceJcPsf.jcpsfFollowupTime,'') AS jcpsfFollowupTime,"
				+ " COALESCE(CONCAT(psf.empName,' (', psf.empRefNo,')'),'') AS psfempName, "
				+ " COALESCE(CONCAT( a.axelaServiceJcPsf.axelaServiceJcPsfday.psfdaysDaycount, ' (', a.axelaServiceJcPsf.axelaServiceJcPsfday.psfdaysDesc,')'),'') AS psfdaysDaycount,"
				+ " a.ticketReopenedEmpId,"
				+ " a.axelaEmp.empName,"
				+ " a.axelaEmp.empMobile1,"
				+ " a.axelaEmp.empEmail1,"
				+ " a.axelaEmp.empMobile2,"
				+ " a.axelaEmp.empEmail2)"
				+ " FROM AxelaHelpDeskTicket a"
				+ " INNER JOIN a.axelaEmp"
				+ " LEFT JOIN a.axelaHelpDeskTicketQueue"
				+ " LEFT JOIN a.axelaCustomerContact"
				+ " LEFT JOIN a.axelaCustomer"
				+ " LEFT JOIN a.axelaCustomer.axelaBranch"
				+ " LEFT JOIN a.axelaCustomerContact.axelaTitle"
				+ " LEFT JOIN a.axelaServiceJcPsf"
				+ " LEFT JOIN a.axelaServiceJcPsf.axelaEmp psf"
				+ " LEFT JOIN a.axelaServiceJcPsf.axelaServiceJcPsfday"
				+ " LEFT JOIN a.axelaServiceContract"
				+ " LEFT JOIN a.axelaServiceContractAsset"
				+ " LEFT JOIN a.axelaHelpDeskTicketTran tran"
				+ " WHERE a.ticketId=" + ticketId + exeAccess
				+ " GROUP by a.ticketId";

		TypedQuery<AxelaHelpDeskTicket> typedQuery = em.createQuery(Query, AxelaHelpDeskTicket.class);
		return typedQuery.getSingleResult();
	}

	public List<AxelaHelpDeskTicket> populateData(int ticketId, String branchAccess, String exeAccess) {
		String Query = "SELECT NEW AxelaHelpDeskTicket("
				+ " a.ticketId,"
				+ " a.ticketContactId,"
				+ " a.ticketCustomerId,"
				+ " a.ticketJcId,"
				+ " a.ticketParentId,"
				+ " a.ticketTicketstatusId,"
				+ " a.ticketTicketcatId,"
				+ " a.ticketTickettypeId,"
				+ " a.ticketPmId,"
				+ " a.ticketContractId,"
				+ " a.ticketAssetId,"
				+ " a.ticketSubject,"
				+ " a.ticketDesc,"
				+ " a.ticketClosedTime,"
				+ " a.ticketClosedComments,"
				+ " a.ticketEmpId,"
				+ " a.ticketRead,"
				+ " a.ticketRefno,"
				+ " a.ticketJcpsfId,"
				+ " a.ticketTicketsourceId,"
				+ " a.ticketReportTime,"
				+ " a.ticketTicketqueueId,"
				+ " a.ticketPriorityticketId,"
				+ " a.ticketDueTime,"
				+ " a.ticketEntryId,"
				+ " a.ticketEntryDate,"
				+ " a.ticketJcSerialno,"
				+ " COALESCE(a.axelaCustomerContact.contactId, 0) AS contactId,"
				+ " COALESCE(CONCAT(a.axelaCustomerContact.axelaTitle.titleDesc,' ',a.axelaCustomerContact.contactFname,' ',a.axelaCustomerContact.contactLname),'') AS contactName,"
				+ " COALESCE(a.axelaCustomerContact.contactEmail1, '') AS contactEmail1,"
				+ " COALESCE(a.axelaCustomerContact.contactEmail2, '') AS contactEmail2,"
				+ " COALESCE(a.axelaCustomerContact.contactMobile1, '') AS contactMobile1,"
				+ " COALESCE(a.axelaCustomerContact.contactMobile2, '') AS contactMobile2, "
				+ " COALESCE(a.axelaCustomer.customerName,'') AS customerName,"
				+ " COALESCE(a.axelaCustomer.customerBranchId, 0) AS customerBranchId, "
				+ " COALESCE(a.axelaServiceContract.contractTitle, '') AS contractTitle,"
				+ " COALESCE(a.axelaServiceContract.contractStartDate,'') AS contractStartDate, "
				+ " COALESCE(a.axelaServiceContract.contractEndDate,'') AS contractEndDate,"
				+ " COALESCE(a.axelaServiceContractAsset.assetName, '') AS assetName, "
				+ " COALESCE(tran.tickettransContactEntryId,'') AS tickettransContactEntryId,"
				+ " COALESCE(a.axelaServiceJcPsf.jcpsfFollowupTime,'') AS jcpsfFollowupTime,"
				+ " COALESCE(CONCAT(psf.empName,' (', psf.empRefNo,')'),'') AS psfempName, "
				+ " COALESCE(CONCAT( a.axelaServiceJcPsf.axelaServiceJcPsfday.psfdaysDaycount, ' (', a.axelaServiceJcPsf.axelaServiceJcPsfday.psfdaysDesc,')'),'') AS psfdaysDaycount,"
				+ " a.ticketReopenedEmpId,"
				+ " a.axelaEmp.empName,"
				+ " a.axelaEmp.empMobile1,"
				+ " a.axelaEmp.empEmail1,"
				+ " a.axelaEmp.empMobile2,"
				+ " a.axelaEmp.empEmail2,"
				+ " a.ticketModifiedId,"
				+ " a.ticketModifiedDate)"
				+ " FROM AxelaHelpDeskTicket a"
				+ " INNER JOIN a.axelaEmp"
				+ " LEFT JOIN a.axelaHelpDeskTicketQueue"
				+ " LEFT JOIN a.axelaCustomerContact"
				+ " LEFT JOIN a.axelaCustomer"
				+ " LEFT JOIN a.axelaCustomer.axelaBranch"
				+ " LEFT JOIN a.axelaCustomerContact.axelaTitle"
				+ " LEFT JOIN a.axelaServiceJcPsf"
				+ " LEFT JOIN a.axelaServiceJcPsf.axelaEmp psf"
				+ " LEFT JOIN a.axelaServiceJcPsf.axelaServiceJcPsfday"
				+ " LEFT JOIN a.axelaServiceContract"
				+ " LEFT JOIN a.axelaServiceContractAsset"
				+ " LEFT JOIN a.axelaHelpDeskTicketTran tran"
				+ " WHERE a.ticketId=" + ticketId + exeAccess;

		TypedQuery<AxelaHelpDeskTicket> typedQuery = em.createQuery(Query, AxelaHelpDeskTicket.class);
		em.clear();
		return typedQuery.getResultList();
	}

	public List<AxelaHelpDeskTicketHistory> findHistory(int ticketId) {
		String strSearch = "";
		String sqlJoin = "";
		String countSql = "";
		String Query = "SELECT NEW AxelaHelpDeskTicketHistory(";
		Query += " a.historyId,"
				+ " a.historyActiontype,"
				+ " a.historyDatetime,"
				+ " a.historyEmpId,"
				+ " a.historyNewvalue,"
				+ " a.historyOldvalue,"
				+ " a.historyTicketId)"
				+ " FROM AxelaHelpDeskTicketHistory a"
				+ " WHERE a.historyTicketId =" + ticketId
				+ strSearch;
		TypedQuery<AxelaHelpDeskTicketHistory> typedQuery = em.createQuery(Query, AxelaHelpDeskTicketHistory.class);
		em.clear();
		return typedQuery.getResultList();
	}

	public List<Object[]> findTicketSummary(String strSearch, HttpSession session)
	{
		String Query = " SELECT COALESCE(ticket.axelaCustomer.axelaBranch.branchId,0) as branchId,"
				+ " COALESCE(CONCAT(ticket.axelaCustomer.axelaBranch.branchName,' (',ticket.axelaCustomer.axelaBranch.branchCode, ')'),'Head Office') as branchName, "
				+ " count(ticket.ticketId) as ticketcount"
				+ " from  AxelaHelpDeskTicket ticket"
				+ " INNER JOIN ticket.axelaEmp"
				+ " INNER JOIN ticket.axelaHelpDeskTicketStatus"
				+ " INNER JOIN ticket.axelaHelpDeskTicketQueue"
				+ " INNER JOIN ticket.axelaHelpDeskTicketPriority"
				+ " LEFT JOIN ticket.axelaCustomerContact"
				+ " LEFT JOIN ticket.axelaCustomer"
				+ " LEFT JOIN ticket.axelaCustomerContact"
				+ " LEFT JOIN ticket.axelaCustomer.axelaBranch"
				+ " LEFT JOIN ticket.axelaHelpDeskTicketCat"
				+ " LEFT JOIN ticket.axelaHelpDeskTicketType"
				+ " where 1 = 1 " + strSearch + " "
				+ " GROUP BY ticket.axelaCustomer.axelaBranch.branchId"
				+ " ORDER BY ticket.axelaCustomer.axelaBranch.branchName";
		TypedQuery<Object[]> typedQuery = em.createQuery(Query, Object[].class);
		listLength = em.createQuery(Query, Object[].class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}

	public List<AxelaHelpDeskTicket> findCustomer(int ticketId) {
		String Query = "SELECT NEW AxelaHelpDeskTicket("
				+ " a.ticketCustomerId,"
				+ " a.ticketSubject,"
				+ " COALESCE(a.axelaCustomer.customerName,'') AS customerName,"
				+ " a.axelaCustomer.customerAddress1,"
				+ " a.axelaCustomer.customerPhone2,"
				+ " a.axelaCustomer.customerPhone3,"
				+ " a.axelaCustomer.customerPhone4,"
				+ " a.axelaCustomer.customerMobile1,"
				+ " a.axelaCustomer.customerMobile2,"
				+ " a.axelaCustomer.customerFax1,"
				+ " a.axelaCustomer.customerFax2,"
				+ " a.axelaCustomer.customerEmail1,"
				+ " a.axelaCustomer.customerEmail2,"
				+ " a.axelaCustomer.customerEmpId,"
				+ " a.axelaCustomer.customerWebsite1,"
				+ " a.axelaCustomer.customerWebsite2,"
				+ " a.axelaCustomer.customerPin,"
				+ " a.axelaCustomer.customerNotes,"
				+ " a.axelaCustomerContact.contactActive,"
				+ " COALESCE(a.axelaCustomer.axelaCity.cityName, '') AS cityName,"
				+ " COALESCE(a.axelaCustomer.axelaCity.axelaState.stateName, '') AS stateName,"
				+ " COALESCE(a.axelaCustomer.axelaCity.axelaState.axelaCountry.countryName, '') AS countryName)"
				+ " FROM AxelaHelpDeskTicket a"
				+ " INNER JOIN a.axelaEmp"
				+ " INNER JOIN a.axelaCustomer"
				+ " INNER JOIN a.axelaCustomer.axelaBranch"
				+ " INNER JOIN a.axelaCustomerContact.axelaTitle"
				+ " INNER JOIN a.axelaCustomerContact"
				+ " LEFT JOIN  a.axelaCustomer.axelaCity"
				+ " LEFT JOIN  a.axelaCustomer.axelaCity.axelaState"
				+ " LEFT JOIN  a.axelaCustomer.axelaCity.axelaState.axelaCountry"
				+ " LEFT JOIN  a.axelaCustomerContact.axelaCity"
				+ " LEFT JOIN  a.axelaCustomerContact.axelaCity.axelaState"
				+ " LEFT JOIN  a.axelaCustomerContact.axelaCity.axelaState.axelaCountry"
				+ " WHERE a.ticketId=" + ticketId;

		TypedQuery<AxelaHelpDeskTicket> typedQuery = em.createQuery(Query, AxelaHelpDeskTicket.class);
		em.clear();
		return typedQuery.getResultList();
	}

	public List<AxelaHelpDeskTicket> findSummary(int ticketId) {
		String Query = "SELECT NEW AxelaHelpDeskTicket("
				+ " a.ticketId,"
				+ " a.ticketRead,"
				+ " a.ticketClosedTime,"
				+ " a.ticketDueTime,"
				+ " a.ticketTrigger,"
				+ " a.ticketDesc,"
				+ " a.ticketReportTime,"
				+ " a.axelaEmp.empId AS ticketClosedEmpId,"
				+ " a.ticketClosedComments,"
				+ " a.ticketNotes,"
				+ " a.axelaEmp.empId AS ticketReopenedEmpId,"
				+ " a.ticketReopenedComments,"
				+ " a.ticketReopenedTime,"
				+ " a.ticketPriorityticketId,"
				+ " priority.priorityticketName,"
				+ " a.ticketSubject,"
				+ " a.ticketEmpId,"
				+ " a.ticketEntryId,"
				+ " a.ticketEntryDate,"
				+ " a.ticketModifiedId,"
				+ " a.ticketModifiedDate,"
				+ " a.ticketTicketsourceId,"
				+ " source.ticketsourceName,"
				+ " a.ticketTicketstatusId,"
				+ " status.ticketstatusName,"
				+ " a.ticketTicketqueueId,"
				+ " queue.ticketqueueName,"
				+ " a.ticketTickettypeId,"
				+ " type.tickettypeName,"
				+ " CONCAT(emp.empName, '(', emp.empRefNo, ')') AS closedBy)"
				+ " FROM AxelaHelpDeskTicket a"
				+ " INNER JOIN a.axelaEmp emp"
				+ " INNER JOIN a.axelaHelpDeskTicketSource source"
				+ " INNER JOIN a.axelaHelpDeskTicketStatus status"
				+ " INNER JOIN a.axelaHelpDeskTicketQueue queue"
				+ " INNER JOIN a.axelaHelpDeskTicketPriority priority"
				+ " LEFT JOIN a.axelaHelpDeskTicketType type"
				+ " LEFT JOIN a.axelaEmp"
				+ " WHERE a.ticketId=" + ticketId;

		TypedQuery<AxelaHelpDeskTicket> typedQuery = em.createQuery(Query, AxelaHelpDeskTicket.class);
		em.clear();
		return typedQuery.getResultList();
	}
	public List<AxelaHelpDeskTicketHoli> findAllHoli(String strSearch, String strOrderBy, int page, int perpage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaHelpDeskTicketHoli> listData = new ArrayList<AxelaHelpDeskTicketHoli>();
		String strSql = "SELECT New AxelaHelpDeskTicketHoli("
				+ " holi.ticketholiId,"
				+ " COALESCE(holi.ticketholiName,'') AS ticketholiName,"
				+ " COALESCE(holi.axelaBranch.branchId,0) AS branchId ,"
				+ " COALESCE(holi.ticketholiDate,'') AS ticketholiDate,"
				+ " COALESCE(CONCAT(holi.axelaBranch.branchName, ' (',holi.axelaBranch.branchCode, ')'),'') AS branchname)";
		sqlJoin += " FROM AxelaHelpDeskTicketHoli holi"
				+ " INNER JOIN holi.axelaBranch"
				+ " WHERE 1 = 1" + strSearch;
		countSql = "SELECT COUNT(DISTINCT holi.ticketholiId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY holi.ticketholiId"
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaHelpDeskTicketHoli.class).setFirstResult((page - 1) * perpage).setMaxResults(perpage).getResultList();
		}
		em.close();
		return listData;
	}
	public List<AxelaHelpDeskTicketHoli> populateHolidayData(String ticketholiId, HttpSession session) {
		String Query = "SELECT New AxelaHelpDeskTicketHoli("
				+ " holi.ticketholiId,"
				+ " holi.ticketholiBranchId,"
				+ " holi.ticketholiDate,"
				+ " holi.ticketholiName,"
				+ " holi.ticketholiEntryId,"
				+ " holi.ticketholiEntryDate,"
				+ " holi.ticketholiModifiedId,"
				+ " holi.ticketholiModifiedDate)"
				+ " FROM AxelaHelpDeskTicketHoli holi"
				+ " INNER JOIN holi.axelaBranch"
				+ " WHERE 1 = 1"
				+ " AND holi.ticketholiId = " + ticketholiId + "";
		TypedQuery<AxelaHelpDeskTicketHoli> typedQuery = em.createQuery(Query, AxelaHelpDeskTicketHoli.class);
		em.clear();
		return typedQuery.getResultList();
	}

	public Long findDayOneTicket(String exeAccess, int currYear, int currMonth, int currDate, HttpSession session)
	{
		String Query = "SELECT"
				+ " COUNT(ticket.ticketId)"
				+ " FROM AxelaHelpDeskTicket ticket"
				+ " INNER JOIN ticket.axelaEmp "
				+ " WHERE substring(ticket.ticketReportTime,1,10)='" + currYear + "-" + doublenum(currMonth + 1) + "-" + doublenum(currDate) + "'"
				+ "" + exeAccess;
		// TypedQuery<Object[]> typedQuery = em.createQuery(Query, Object[].class);
		Length = em.createQuery(Query, Long.class).getFirstResult();
		System.out.println("Length==========================" + Length);
		em.clear();
		return Length;
	}

	public Long findDayTwoTicket(String exeAccess, int currYear, int currMonth, int currDate, HttpSession session)
	{
		String Query = "SELECT"
				+ " COUNT(ticket.ticketId)"
				+ " FROM AxelaHelpDeskTicket ticket"
				+ " INNER JOIN ticket.axelaEmp "
				+ " WHERE substring(ticket.ticketReportTime,1,10)='" + currYear + "-" + doublenum(currMonth + 1) + "-" + doublenum(currDate) + "'"
				+ "" + exeAccess;
		Length = em.createQuery(Query, Long.class).getFirstResult();
		em.clear();
		return Length;
	}

	public Long findDayThreeTicket(String exeAccess, int currYear, int currMonth, int currDate, HttpSession session)
	{
		String Query = "SELECT"
				+ " COUNT(ticket.ticketId)"
				+ " FROM AxelaHelpDeskTicket ticket"
				+ " INNER JOIN ticket.axelaEmp "
				+ " WHERE substring(ticket.ticketReportTime,1,10)='" + currYear + "-" + doublenum(currMonth + 1) + "-" + doublenum(currDate) + "'"
				+ "" + exeAccess;
		Length = em.createQuery(Query, Long.class).getFirstResult();
		em.clear();
		return Length;
	}

	public Long findDayFourTicket(String exeAccess, int currYear, int currMonth, int currDate, HttpSession session)
	{
		String Query = "SELECT"
				+ " COUNT(ticket.ticketId)"
				+ " FROM AxelaHelpDeskTicket ticket"
				+ " INNER JOIN ticket.axelaEmp "
				+ " WHERE substring(ticket.ticketReportTime,1,10)='" + currYear + "-" + doublenum(currMonth + 1) + "-" + doublenum(currDate) + "'"
				+ "" + exeAccess;
		Length = em.createQuery(Query, Long.class).getFirstResult();
		em.clear();
		return Length;
	}

	public Long findDayFiveTicket(String exeAccess, int currYear, int currMonth, int currDate, HttpSession session)
	{
		String Query = "SELECT"
				+ " COUNT(ticket.ticketId)"
				+ " FROM AxelaHelpDeskTicket ticket"
				+ " INNER JOIN ticket.axelaEmp "
				+ " WHERE substring(ticket.ticketReportTime,1,10)='" + currYear + "-" + doublenum(currMonth + 1) + "-" + doublenum(currDate) + "'"
				+ "" + exeAccess;
		Length = em.createQuery(Query, Long.class).getFirstResult();
		em.clear();
		return Length;
	}

	public Long findDaySixTicket(String exeAccess, int currYear, int currMonth, int currDate, HttpSession session)
	{
		String Query = "SELECT"
				+ " COUNT(ticket.ticketId)"
				+ " FROM AxelaHelpDeskTicket ticket"
				+ " INNER JOIN ticket.axelaEmp "
				+ " WHERE substring(ticket.ticketReportTime,1,10)='" + currYear + "-" + doublenum(currMonth + 1) + "-" + doublenum(currDate) + "'"
				+ "" + exeAccess;
		Length = em.createQuery(Query, Long.class).getFirstResult();
		em.clear();
		return Length;
	}

	public Long findDaySevenTicket(String exeAccess, int currYear, int currMonth, int currDate, HttpSession session)
	{
		String Query = "SELECT"
				+ " COUNT(ticket.ticketId)"
				+ " FROM AxelaHelpDeskTicket ticket"
				+ " INNER JOIN ticket.axelaEmp "
				+ " WHERE substring(ticket.ticketReportTime,1,10)='" + currYear + "-" + doublenum(currMonth + 1) + "-" + doublenum(currDate) + "'"
				+ "" + exeAccess;
		Length = em.createQuery(Query, Long.class).getFirstResult();
		em.clear();
		return Length;
	}

	public Long findWeekTicket(String exeAccess, String endWeek, String startWeek, HttpSession session)
	{
		String Query = "SELECT"
				+ " COUNT(ticket.ticketId)"
				+ " FROM AxelaHelpDeskTicket ticket "
				+ " INNER JOIN ticket.axelaEmp"
				+ " WHERE 1=1 AND (SUBSTRING(ticket.ticketReportTime,1,10)>='" + endWeek + "' and substring(ticket.ticketReportTime,1,10)<'" + startWeek + "')"
				+ "" + exeAccess;
		Length = em.createQuery(Query, Long.class).getSingleResult();
		System.out.println("Length22222222222" + Length);
		em.clear();
		return Length;
	}

	public Long findMonthTicket(String exeAccess, String endMonth, String startMonth, HttpSession session)
	{
		String Query = "SELECT"
				+ " COUNT(ticket.ticketId)"
				+ " FROM AxelaHelpDeskTicket ticket "
				+ " INNER JOIN ticket.axelaEmp"
				+ " WHERE 1=1 AND (SUBSTRING(ticket.ticketReportTime,1,10)>='" + endMonth + "' and substring(ticket.ticketReportTime,1,10)<'" + startMonth + "')"
				+ "" + exeAccess;
		Length = em.createQuery(Query, Long.class).getSingleResult();
		System.out.println("Length22222222222" + Length);
		em.clear();
		return Length;
	}
	public Long findQuatorTicket(String exeAccess, int currYear, String quarter, HttpSession session)
	{
		String Query = "SELECT COUNT(ticket.ticketId)"
				+ " FROM  AxelaHelpDeskTicket ticket"
				+ " INNER JOIN ticket.axelaEmp"
				+ " WHERE 1=1 AND (SUBSTRING(ticket.ticketReportTime,1,4)='" + currYear + "' and substring(ticket.ticketReportTime,5,2) " + quarter + ")"
				+ "" + exeAccess;
		Length = em.createQuery(Query, Long.class).getSingleResult();
		System.out.println("Length22222222222" + Length);
		em.clear();
		return Length;
	}
}
