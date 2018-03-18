package axela.sales.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.portal.model.AxelaBranch;
import axela.sales.model.AxelaSalesCampaign;
@Repository
@Transactional(readOnly = true)
public class CampaignFilterImpl extends Connect {
	@PersistenceContext
	EntityManager em;
	public static String totalCount = "0";
	public static Long listLength = 0L;

	public List<AxelaBranch> findAllByBranch(String branchAccess) {
		Query query = em.createQuery("SELECT a FROM AxelaBranch a WHERE a.branchActive = '1' " + branchAccess);
		return (List<AxelaBranch>) query.getResultList();
	}

	public int length(String branchAccess, String exeAccess, String sort, String field) {
		Query query = em.createQuery("SELECT a FROM AxelaCustomer a WHERE 1=1 AND a.customerType !='0'" + branchAccess + exeAccess + " ORDER BY a." + field + " " + sort);
		em.clear();
		return (int) query.getResultList().size();
	}

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
	// // end campaign list
	//
	//
	//

	public List<AxelaSalesCampaign> findAllCampaign(String strSearch, String strOrderBy, int page, int perPage) {

		String sqlJoin = "";
		String countSql = "";
		List<AxelaSalesCampaign> listData = new ArrayList<AxelaSalesCampaign>();
		String strSql = "SELECT NEW AxelaSalesCampaign("
				+ " campaign.campaignId,"
				+ " campaign.campaignName,"
				+ " campaign.axelaSalesCampaignType.camptypeId,"
				+ " campaign.axelaSalesCampaignType.camptypeDesc,"
				+ " campaign.campaignDesc,"
				+ " campaign.campaignActive,"
				+ " campaign.campaignStartdate,"
				+ " campaign.campaignEnddate,"
				+ " (SELECT COUNT(b.opprId)"
				+ " FROM AxelaSalesOppr b"
				+ " WHERE b.opprCampaignId = campaign.campaignId) AS campaignOpprcount)";
		sqlJoin += " FROM AxelaSalesCampaign campaign"
				+ " JOIN campaign.axelaSalesCampaignType type"
				+ " JOIN campaign.axelaSalesCampaignBranch campaignBranch"
				+ " JOIN campaignBranch.axelaBranch branch"
				+ " WHERE 1=1 "
				+ strSearch;
		countSql = "SELECT COUNT(DISTINCT campaign.campaignId)" + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		System.out.println("totalCount======================" + totalCount);
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY campaign.campaignId "
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaSalesCampaign.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
		// end campaign list
	}

	public List<Object[]> findCampaignLandingDetails(String StrSearch) {

		String strSql = " SELECT campaign.campaignStartdate as campaignStartDate,"
				+ " COUNT(DISTINCT campaign.campaignId) as campaignCount "
				+ " FROM AxelaSalesCampaign campaign"
				+ " JOIN campaign.axelaSalesCampaignBranch campaignBranch"
				+ " JOIN campaignBranch.axelaBranch branch"
				+ " where 1=1"
				+ StrSearch
				+ " GROUP BY campaign_id"
				+ " ORDER BY campaign_startdate";
		List<Object[]> list = em.createQuery(strSql, Object[].class).getResultList();
		em.clear();
		return list;
	}
}
