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
import axela.service.model.AxelaServiceContractAsset;

@Repository
@Transactional(readOnly = true)
public class AssetFilterImpl extends Connect {
	@PersistenceContext
	EntityManager em;
	public static String totalCount = "0";
	public static int listLength = 0;

	public int length(String branchAccess, String sort, String field) {
		Query query = em.createQuery("SELECT a FROM AxelaServiceContractAsset a WHERE 1=1 AND a.assetId !='0'" + branchAccess + " ORDER BY a." + field + " " + sort);
		em.clear();
		return (int) query.getResultList().size();
	}

	public List<AxelaServiceContractAsset> findAll(String strSearch, String strOrderBy, int page, int perPage)
	{
		SOP("strSearch=========" + strSearch);
		String sqlJoin = "";
		String countSql = "";
		List<AxelaServiceContractAsset> typedQuery = new ArrayList<AxelaServiceContractAsset>();
		String strSql = "SELECT NEW AxelaServiceContractAsset("
				+ "asset.assetId,"
				+ " asset.assetName,"
				+ " asset.assetSerial,"
				+ " asset.assetTag,"
				+ " asset.assetCustomerId,"
				+ " COALESCE(contact.contactId,'')  AS contactId,"
				+ " branch.branchId,"
				+ " branch.branchName,"
				+ " customers.customerId,"
				+ " customers.customerName,"
				+ " type.contractassettypeName,"
				+ " brand.assetbrandName,"
				+ " asset.assetContractlocId,"
				+ " location.contractlocName)";
		sqlJoin += " FROM AxelaServiceContractAsset asset"
				+ " INNER JOIN asset.axelaCustomers customers"
				+ " INNER JOIN customers.axelaCustomerContact contact"
				+ " INNER JOIN asset.axelaServiceContractAssetType type"
				+ " INNER JOIN asset.axelaServiceContractAssetBrand brand"
				+ " INNER JOIN customers.axelaBranch branch"
				+ " INNER JOIN asset.axelaServiceContractLocation location"
				+ " WHERE 1 = 1"
				+ " AND asset.assetId !='0' ";
		if (!strSearch.equals("")) {
			sqlJoin += strSearch;
		}
		countSql = "SELECT COUNT(DISTINCT asset.assetId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		SOP("totalCount=========" + totalCount);
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY asset.assetId"
					+ strOrderBy;
			typedQuery = em.createQuery(strSql, AxelaServiceContractAsset.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return typedQuery;
	}
	public List<Object[]> findBypopulate(String assetId, HttpSession session)
	{
		String Query = "SELECT "
				+ "a.assetCustomerId,"
				+ " a.assetContractlocId,"
				+ " a.assetName,"
				+ " a.assetContractassettypeId,"
				+ " a.assetAssetbrandId,"
				+ " a.assetSerial,"
				+ " a.assetTag,"
				+ " a.assetDesc,"
				+ " a.assetPurchaseDate,"
				+ " a.assetNotes,"
				+ " a.axelaCustomers.customerName,"
				+ " a.axelaLocation.locationName,"
				+ " a.axelaServiceContractAssetType.contractassettypeName,"
				+ " a.assetAssetbrandId,"
				+ " a.axelaServiceContractAssetBrand.assetbrandName,"
				+ " a.assetTag,"
				+ " a.assetSerial,"
				+ " a.assetModifiedDate,"
				+ " a.assetEntryId,"
				+ " a.assetEntryDate,"
				+ " a.assetModifiedId"
				+ " FROM AxelaServiceContractAsset a"
				+ " LEFT JOIN  a.axelaLocation "
				+ " INNER JOIN a.axelaCustomers "
				+ " INNER JOIN a.axelaServiceContractAssetType "
				+ " INNER JOIN a.axelaServiceContractAssetBrand "
				+ " WHERE a.assetId=" + assetId;
		TypedQuery<Object[]> typedQuery = em.createQuery(Query, Object[].class);
		listLength = em.createQuery(Query, Object[].class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}

	public List<Object[]> findAssetSummary(String strSearch, HttpSession session)
	{
		String Query = " SELECT CONCAT(asset.axelaCustomers.axelaBranch.branchName,' (', asset.axelaCustomers.axelaBranch.branchCode, ')') AS branchName,"
				+ " asset.axelaCustomers.axelaBranch.branchId,"
				+ " COUNT(asset.assetId) AS assetCount"
				+ " FROM AxelaServiceContractAsset asset"
				+ " INNER JOIN asset.axelaCustomers"
				+ " INNER JOIN asset.axelaServiceContractAssetType"
				+ " INNER JOIN asset.axelaServiceContractAssetBrand"
				+ " INNER JOIN asset.axelaCustomers.axelaBranch"
				+ " INNER JOIN asset.axelaServiceContractLocation"
				+ " WHERE 1 = 1 " + strSearch + " "
				+ " GROUP BY asset.axelaCustomers.axelaBranch.branchId"
				+ " ORDER BY asset.axelaCustomers.axelaBranch.branchName";
		TypedQuery<Object[]> typedQuery = em.createQuery(Query, Object[].class);
		listLength = em.createQuery(Query, Object[].class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}
}