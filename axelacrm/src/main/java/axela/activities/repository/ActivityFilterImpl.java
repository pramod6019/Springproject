package axela.activities.repository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.activities.model.AxelaActivity;
import axela.config.Connect;

@Repository
@Transactional(readOnly = true)
public class ActivityFilterImpl {
	@PersistenceContext
	EntityManager em;
	public static String totalCount = "0";
	public static Long listLength = 0L;

	public List<AxelaActivity> findAllActivities(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaActivity> listData = new ArrayList<AxelaActivity>();

		String strSql = "SELECT NEW AxelaActivity("
				+ " activity.activityId,"
				+ " activity.activityEmpId,"
				+ " activity.activityContactId, "
				+ " activity.activityTitle,"
				+ " activity.activityStartDatetime,"
				+ " activity.activityEndDatetime,"
				+ " activity.activityContactPerson,"
				+ " activity.activityPhone1,"
				+ " activity.activityPhone2,"
				+ " activity.activityVenue,"
				+ " activity.activityRemarks,"
				+ " activity.activityDesc,"
				+ " activity.activityEntryDatetime, "
				+ " activity.activityModifiedDatetime,"
				+ " activity.activityFeedbackEntryId,"
				+ " activity.activityFeedbackEntryDatetime,"
				+ " activity.activityRemarksEntryId,"
				+ " activity.activityRemarksEntryDatetime,"
				+ " priority.priorityName,"
				+ " type.activitytypeName,"
				+ " COALESCE(status.statusDesc, '') AS statusDesc,"
				+ " COALESCE(activity.axelaCustomerContact.contactId, 0) AS contactI,"
				+ " COALESCE(activity.axelaCustomerContact.axelaTitle.titleDesc, ' ') AS titleDesc,"
				+ " COALESCE(activity.axelaCustomerContact.contactFname, ' ') AS contactFname,"
				+ " COALESCE(activity.axelaCustomerContact.contactLname, '') AS contactLname,"
				+ " activity.activityFeedback,"
				+ " emp.empId,"
				+ " emp.empName,"
				+ " emp.empRefNo"
				+ ")";
		sqlJoin += " FROM AxelaActivity activity"
				+ " JOIN activity.axelaActivityType type "
				+ " JOIN activity.axelaEmp emp"
				+ " JOIN activity.axelaActivityPriority priority"
				+ " LEFT JOIN activity.axelaActivityStatus status"
				+ " LEFT JOIN activity.axelaCustomerContact.axelaTitle contact"
				// + " LEFT JOIN contact.axelaTitle title"
				+ " WHERE 1 = 1 "
				+ strSearch;
		countSql = "SELECT COUNT(DISTINCT activity.activityId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY activity.activityId "
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaActivity.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public List<AxelaActivity> activityFollowupData(String activityEmpId, String strSearch) {
		List<AxelaActivity> listData = new ArrayList<AxelaActivity>();
		String strSql = "SELECT NEW AxelaActivity("
				+ " CONCAT( followup.followupFollowupTime ,'')AS startTime,"
				+ " CONCAT( followup.followupFollowupTime, '') AS endTime,"
				+ " CONCAT(oppr.axelaCustomerContact.contactFname, '', oppr.axelaCustomerContact.contactLname) AS title,"
				+ " CONCAT((CASE WHEN(followup.followupDesc != '')THEN CONCAT( 'Feedback: ', followup.followupDesc, '<br>' ) ELSE '' END),"
				+ " (CASE WHEN(CONCAT(oppr.axelaCustomerContact.contactFname, ' ', oppr.axelaCustomerContact.contactLname ) != '')THEN (CONCAT('Contact: ', (CONCAT( oppr.axelaCustomerContact.contactFname, ' ', oppr.axelaCustomerContact.contactLname, '<br>' ))))ELSE '' END),"
				+ " (CASE WHEN(oppr.axelaCustomerContact.contactMobile1 != '')THEN (CONCAT('Mobile: ', oppr.axelaCustomerContact.contactMobile1))ELSE '' END )) AS description,"
				+ " oppr.opprId AS activityId,"
				+ " 'opprfollowup' AS type,"
				+ " followup.followupDesc AS feedback,"
				+ " oppr.axelaCustomerContact.contactMobile1"
				+ " )"
				+ " FROM AxelaSalesOpprFollowup followup"
				+ " JOIN followup.axelaSalesOppr oppr"
				+ " JOIN followup.axelaSalesOpprFollowupType"
				+ " JOIN oppr.axelaCustomerContact"
				+ " WHERE followup.followupEmpId = "
				+ activityEmpId
				+ strSearch
				+ " ORDER BY startTime";
		listData = em.createQuery(strSql, AxelaActivity.class).getResultList();
		return listData;
	}
	public List<AxelaActivity> activityBirthDayData(String activityEmpId, String startDate, String strSearch) throws ParseException {
		List<AxelaActivity> listData = new ArrayList<AxelaActivity>();
		Connect connect = new Connect();
		String strSql = "SELECT NEW AxelaActivity("
				+ " CONCAT('" + connect.dateToString(connect.stringToDate(startDate)) + "','') AS startTime,"
				+ " CONCAT(contact.contactDob,'') AS endTime,"
				+ " CONCAT( contact.axelaTitle.titleDesc, ' ', contact.contactFname, ' ', contact.contactLname ) AS title,"
				+ " ('Status: Birthday') AS description,"
				+ " contact.contactId AS activityId,"
				+ " ('birthday') AS type,"
				+ " '' AS feedback,"
				+ " contact.contactMobile1"
				+ " )"
				+ " FROM AxelaCustomerContact contact"
				+ " JOIN contact.axelaCustomers"
				+ " JOIN contact.axelaTitle"
				+ " WHERE 1 = 1 AND contact.contactDob != ''"
				+ strSearch
				+ " ORDER BY startTime"
				+ " ";
		listData = em.createQuery(strSql, AxelaActivity.class).getResultList();
		return listData;
	}

	// activity calender start
	public List<Object[]> findAllActivityEvent(String strSearch) {
		String strSql = "SELECT activity.activityId,"// 1
				+ " activity.activityStartDatetime,"// 2
				+ " activity.activityEndDatetime,"// 3
				+ " activity.activityTitle,"// 4
				+ " CONCAT((CASE WHEN(activity.activityDesc!='') THEN activity.activityDesc END),"// 5
				+ " (CASE WHEN(type.activitytypeName!='') THEN CONCAT('Type: ',type.activitytypeName) END),"// 6
				+ " (CASE WHEN(priority.priorityName!='') THEN CONCAT('Priority: ',priority.priorityName) END),"// 7
				+ " (CASE WHEN(activity.activityContactPerson!='') THEN CONCAT('Contact: ',activity.activityContactPerson) END),"// 8
				+ " (CASE WHEN(activity.activityPhone1!='') THEN activity.activityPhone1 END),"// 9
				+ " (CASE WHEN(activity.activityPhone2!='') THEN activity.activityPhone2 END),"// 10
				+ " (CASE WHEN(activity.activityFeedback!='') THEN CONCAT('Feedback: ',activity.activityFeedback) END),"// 11
				+ " (CASE WHEN(activity.activityRemarks!='') THEN CONCAT('Remarks: ', activity.activityRemarks) END)),"// 12
				+ " '' AS feedback,"// 13
				+ " 'activity' AS type"// 14
				+ " FROM AxelaActivity activity "
				+ " JOIN activity.axelaActivityType type"
				+ " JOIN activity.axelaActivityPriority priority"
				+ " WHERE 1 = 1 "
				+ strSearch;
		System.out.println("strSearch================" + strSearch);
		TypedQuery<Object[]> typedQuery = em.createQuery(strSql, Object[].class);
		return typedQuery.getResultList();
	}

	public List<Object[]> findAllActivityOpprFollowup(String strSearch) {
		String strSql = "SELECT followup.followupOpprId,"// 1
				+ " followup.followupFollowupTime,"// 2
				+ " followup.followupFollowupTime,"// 3
				+ " CONCAT(contact.contactFname,contact.contactLname) as title,"// 4
				+ " CONCAT((CASE WHEN(followuptype.followuptypeName!='') THEN followuptype.followuptypeName END),"// 5
				+ " (CASE WHEN(followup.followupDesc!='') THEN  CONCAT('Feedback: ', followup.followupDesc) END),"// 6
				+ " (CASE WHEN(CONCAT(contact.contactFname,'',contact.contactLname)!='') THEN CONCAT(contact.contactFname, contact.contactLname) END),"// 7
				+ " (CASE WHEN(contact.contactMobile1!='') THEN CONCAT('Mobile: ',contact.contactMobile1) END)),"// 8
				+ " followup.followupDesc AS feedback,"// 9
				+ " 'oppr' AS type"// 10
				+ " FROM AxelaSalesOpprFollowup followup "
				+ " JOIN followup.axelaEmp empName"
				+ " JOIN followup.axelaEmp empEntryName"
				+ " JOIN followup.axelaSalesOppr oppr"
				+ " JOIN followup.axelaSalesOpprFollowupType followuptype"
				+ " JOIN oppr.axelaCustomerContact contact"
				+ " WHERE 1 = 1 "
				+ strSearch;
		TypedQuery<Object[]> typedQuery = em.createQuery(strSql, Object[].class);
		return typedQuery.getResultList();
	}

	public List<Object[]> findAllActivityBirthday(String strSearch) {
		String strSql = "SELECT contact.contactId,"// 1
				+ " '20171010000000',"// 2
				+ " contact.contactDob,"// 3
				+ " CONCAT(title.titleDesc,'',contact.contactFname,'',contact.contactLname)AS title,"// 4
				+ " (CASE WHEN(contact.contactJobtitle!='') THEN contact.contactJobtitle END),"// 5
				+ " '' AS feedback,"// 6
				+ " 'birthday' as type"// 7
				+ " FROM AxelaCustomerContact contact "
				+ " JOIN contact.axelaCustomers customer"
				+ " JOIN contact.axelaTitle title"
				+ " WHERE 1 = 1 "
				+ strSearch;
		System.out.println("strSearch================" + strSearch);
		TypedQuery<Object[]> typedQuery = em.createQuery(strSql, Object[].class);
		return typedQuery.getResultList();
	}

	// activity calender end

}
