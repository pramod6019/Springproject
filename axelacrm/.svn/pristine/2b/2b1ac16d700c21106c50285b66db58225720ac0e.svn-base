package axela.inventory.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.inventory.model.AxelaInventoryLocation;
import axela.inventory.repository.InventoryLocationRepository.InventoryLocationFilterRepository;
@Repository
@Transactional(readOnly = true)
public class InventoryLocationFilter implements InventoryLocationFilterRepository {
	@PersistenceContext
	EntityManager em;
	public static String totalCount = "0";
	public static int locationLength = 0;
	public List<AxelaInventoryLocation> findLocationName(String query) {

		String Query = "SELECT NEW AxelaInventoryLocation("
				+ " location.locationName)"
				+ " FROM AxelaInventoryLocation location"
				+ " WHERE 1=1" + query;
		TypedQuery<AxelaInventoryLocation> typedQuery = em.createQuery(Query, AxelaInventoryLocation.class);
		return typedQuery.getResultList();
	}

	// findAll(strSearch, Integer.parseInt(CNumeric(page)), Integer.parseInt(CNumeric(perPage)));

	public List<AxelaInventoryLocation> findAll(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaInventoryLocation> listData = new ArrayList<AxelaInventoryLocation>();
		String strSql = "SELECT NEW AxelaInventoryLocation("
				+ " location.locationId,"
				+ " location.locationName,"
				+ " location.locationPhone1,"
				+ " location.locationPhone2,"
				+ " CONCAT(location.axelaBranch.branchName, ' (', location.axelaBranch.branchCode, ')') AS branchName,"
				+ " location.locationMobile1,"
				+ " location.locationMobile2,"
				+ " location.locationAddress,"
				+ " location.axelaBranch.branchId,"
				+ " location.axelaCity.cityName,"
				+ " location.axelaCity.axelaState.stateName,"
				+ " location.axelaCity.axelaState.axelaCountry.countryName,"
				+ " location.locationPin)";
		sqlJoin += " FROM AxelaInventoryLocation location"
				+ " WHERE 1=1" + strSearch;
		countSql = "SELECT COUNT(DISTINCT location.locationId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY location.locationId"
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaInventoryLocation.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}

	public List<AxelaInventoryLocation> findLocationCode(String query) {

		String Query = "SELECT NEW AxelaInventoryLocation("
				+ " location.locationCode)"
				+ " FROM AxelaInventoryLocation location"
				+ " WHERE 1=1" + query;
		TypedQuery<AxelaInventoryLocation> typedQuery = em.createQuery(Query, AxelaInventoryLocation.class);
		return typedQuery.getResultList();
	}

	public List<AxelaInventoryLocation> populateFields(int locationId) {
		TypedQuery<AxelaInventoryLocation> typedQuery = null;
		List<AxelaInventoryLocation> result = new ArrayList<AxelaInventoryLocation>();
		String Query = "SELECT NEW AxelaInventoryLocation("
				+ " location.locationBranchId,"
				+ " location.locationName,"
				+ " location.locationCode,"
				+ " location.locationPhone1,"
				+ " location.locationPhone2,"
				+ " location.locationMobile1,"
				+ " location.locationMobile2,"
				+ " location.locationAddress,"
				+ " location.locationCityId,"
				+ " location.locationPin,"
				+ " location.locationEntryId,"
				+ " location.locationEntryDate,"
				+ " location.locationModifiedId,"
				+ " location.locationModifiedDate)"
				+ " FROM AxelaInventoryLocation location"
				+ " WHERE location.locationId=" + locationId;
		result = em.createQuery(Query, AxelaInventoryLocation.class).getResultList();
		if (result != null && !result.isEmpty()) {
			return result;
		} else {
			result = new ArrayList<AxelaInventoryLocation>();
			return result;
		}
	}

	// populate Location

	public List<AxelaInventoryLocation> populateLocation(int branchId) {

		String Query = "SELECT NEW AxelaInventoryLocation("
				+ " location.locationId,"
				+ " location.locationName,"
				+ " location.locationCode)"
				+ " FROM AxelaInventoryLocation location"
				+ " WHERE 1=1"
				+ " AND location.locationBranchId=" + branchId
				+ " GROUP BY location.locationId"
				+ " ORDER BY location.locationName";
		TypedQuery<AxelaInventoryLocation> typedQuery = em.createQuery(Query, AxelaInventoryLocation.class);
		return typedQuery.getResultList();
	}
}
