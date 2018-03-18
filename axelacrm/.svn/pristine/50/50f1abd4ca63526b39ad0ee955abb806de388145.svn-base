package axela.inventory.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.inventory.model.AxelaInventoryBin;
import axela.inventory.repository.InventoryBinRepository.InventoryBinFilterRepository;

@Repository
@Transactional(readOnly = true)
public class InventoryBinFilterImp extends Connect implements InventoryBinFilterRepository {

	@PersistenceContext
	EntityManager em;
	public static String totalCount = "0";
	public static int binLength = 0;

	public List<AxelaInventoryBin> UpdateBinPop(String strSearch) {
		Query query = em.createQuery(strSearch);
		em.clear();
		return query.getResultList();
	}

	public List<AxelaInventoryBin> GetBinName(String strSearch) {
		Query query = em.createQuery(strSearch);
		em.clear();
		return query.getResultList();
	}

	public List<AxelaInventoryBin> populateField(String strSearch) {
		List<AxelaInventoryBin> populateResult = new ArrayList<AxelaInventoryBin>();
		String Query = "SELECT NEW AxelaInventoryBin("
				+ " bin.binName,"
				+ " bin.binParentId,"
				+ " bin.binEntryId,"
				+ " bin.binEntryDate,"
				+ " bin.binModifiedId,"
				+ " CONCAT(branch.branchName, ' (', branch.branchCode, ')') AS branchName,"
				+ " location.locationId,"
				+ " bin.binModifiedDate,"
				+ " branch.branchId,"
				+ " location.locationCode,"
				+ " location.locationName)"
				// + " IF(location.locationCode != '', CONCAT(location.locationName, ' (', location.locationCode, ')'), location.locationName) AS locationName)"
				+ " FROM AxelaInventoryBin bin"
				+ " JOIN bin.axelaInventoryLocation location"
				+ " JOIN location.axelaBranch branch"
				+ " WHERE 1=1 " + strSearch;
		// TypedQuery<AxelaInventoryBin> typedQuery
		populateResult = em.createQuery(Query, AxelaInventoryBin.class).getResultList();
		return populateResult;
	}

	public List<AxelaInventoryBin> findAll(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaInventoryBin> listData = new ArrayList<AxelaInventoryBin>();
		String strSql = "SELECT NEW AxelaInventoryBin("
				+ " bin.binId,"
				+ " bin.binName,"
				+ " (SELECT COUNT(binItem.binitemItemId) FROM AxelaInventoryBinItem binItem WHERE binItem.binitemBinId = bin.binId) AS itemcount,"
				+ " bin.axelaInventoryLocation.locationId,"
				+ " bin.axelaInventoryLocation.locationName,"
				+ " bin.axelaInventoryLocation.axelaBranch.branchId,"
				+ " bin.axelaInventoryLocation.axelaBranch.branchName)";
		sqlJoin += " FROM AxelaInventoryBin bin"
				+ " WHERE 1=1" + strSearch;
		countSql = "SELECT COUNT(DISTINCT bin.binId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY bin.binId"
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaInventoryBin.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public List<AxelaInventoryBin> findBinName(String strSearch) {
		String Query = "SELECT NEW AxelaInventoryBin("
				+ " bin.binName)"
				+ " FROM AxelaInventoryBin bin"
				+ " WHERE 1=1"
				+ strSearch;
		TypedQuery<AxelaInventoryBin> typedQuery = em.createQuery(Query, AxelaInventoryBin.class);
		em.clear();
		return typedQuery.getResultList();
	}
}
