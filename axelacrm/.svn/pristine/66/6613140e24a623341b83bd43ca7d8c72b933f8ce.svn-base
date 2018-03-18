package axela.sales.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import axela.config.Connect;
import axela.sales.model.AxelaSalesOpprFollowup;

@Repository
public class OpprFollowUpFilterImpl extends Connect {

	@PersistenceContext
	EntityManager em;

	public static int listLength = 0;

	// // start campaign list
	// public List<AxelaSalesCampaign> findAllCampaign(String strSearch, int page, int perpage) {
	// String Query = "SELECT NEW AxelaSalesCampaign("
	// + " a.campaignId,"
	// + " a.campaignName,"
	// + " a.axelaSalesCampaignType.camptypeId,"
	// + " a.axelaSalesCampaignType.camptypeDesc,"
	// + " a.campaignDesc,"
	// + " a.campaignActive,"
	// + " a.campaignStartdate,"
	// + " a.campaignEnddate,"
	// + " (SELECT COUNT(b.opprId)"
	// + " FROM AxelaSalesOppr b"
	// + " WHERE b.opprCampaignId = a.campaignId) AS campaignOpprcount)"
	// + " FROM AxelaSalesCampaign a"
	// + " JOIN a.axelaSalesCampaignType "
	// + " JOIN a.axelaSalesCampaignBranch b"
	// + " JOIN b.axelaBranch"
	// + " WHERE 1=1 " + strSearch;
	// TypedQuery<AxelaSalesCampaign> typedQuery = em.createQuery(Query, AxelaSalesCampaign.class).setFirstResult((page - 1) * perpage).setMaxResults(perpage);
	// listLength = em.createQuery(Query, AxelaSalesCampaign.class).getResultList().size();
	// em.clear();
	// return typedQuery.getResultList();
	// }

	public AxelaSalesOpprFollowup findCustomerDetails(int opprId) {
		String Query = "SELECT NEW AxelaSalesOpprFollowup("
				+ " customer.customerId, "
				+ " customer.customerName, "
				+ " contact.contactId, "
				+ " title.titleDesc, "
				+ " contact.contactFname,"
				+ " contact.contactLname,"
				+ " contact.contactMobile1,"
				+ " model.modelName,"
				+ " item.itemName)"
				+ " FROM AxelaSalesOpprFollowup followup"
				+ " JOIN followup.axelaSalesOppr oppr"
				+ " JOIN oppr.axelaInventoryItem item"
				+ " JOIN item.axelaInventoryItemModel model"
				+ " JOIN oppr.axelaCustomer customer"
				+ " JOIN oppr.axelaCustomerContact contact"
				+ " JOIN contact.axelaTitle title"
				+ " WHERE followup.followupOpprId =" + opprId
				+ " GROUP BY customer.customerId";

		TypedQuery<AxelaSalesOpprFollowup> typedQuery = em.createQuery(Query, AxelaSalesOpprFollowup.class);
		return typedQuery.getSingleResult();
	}

	public List<AxelaSalesOpprFollowup> findFollowup(int opprId) {
		String Query = "SELECT NEW AxelaSalesOpprFollowup("
				+ " followup.followupId, "
				+ " followup.followupOpprId, "
				+ " followup.followupFollowupTime, "
				+ " followup.followupDesc, "
				+ " followup.followupEntryTime, "
				+ " followup.followupEntryId, "
				+ " followupType.followuptypeName, "
				+ " followup.followupModifiedId,"
				+ " exe.empId,"
				+ " exe.empName"
				+ " )"
				+ " FROM AxelaSalesOpprFollowup followup"
				+ " JOIN followup.axelaSalesOppr oppr"
				+ " JOIN oppr.axelaBranch"
				+ " JOIN oppr.axelaEmp exe"
				+ " JOIN followup.axelaEmp entry"
				+ " JOIN followup.axelaSalesOpprFollowupType followupType"
				+ " WHERE 1 = 1 AND followup.followupOpprId = " + opprId
				+ " ORDER BY followup.followupId ";

		TypedQuery<AxelaSalesOpprFollowup> typedQuery = em.createQuery(Query, AxelaSalesOpprFollowup.class);
		return typedQuery.getResultList();

	}

}
