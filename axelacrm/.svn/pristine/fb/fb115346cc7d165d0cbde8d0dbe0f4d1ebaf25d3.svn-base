package axela.service.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.service.model.AxelaServiceContractLocation;
import axela.service.repository.ServiceContractLocationRepository.ServiceContractLocationFilterRepository;

@Repository
@Transactional(readOnly = true)
public class ServiceContractLocationFilterImpl extends Connect implements ServiceContractLocationFilterRepository {
	@PersistenceContext
	EntityManager em;
	public static int listLength = 0;
	public static String totalCount = "0";
	public static int contractLocationLength = 0;

	public List<AxelaServiceContractLocation> findAll(String strSearch, String strOrderBy, int page, int perPage)
	{
		String sqlJoin = "";
		String countSql = "";
		List<AxelaServiceContractLocation> axelaServiceContractLocation = new ArrayList<AxelaServiceContractLocation>();
		{
			String strSql = "SELECT NEW AxelaServiceContractLocation("
					+ " contractLocation.contractlocId,"
					+ " contractLocation.contractlocCustomerId,"
					+ " contractLocation.contractlocName,"
					+ " contractLocation.contractlocAddress,"
					+ " contractLocation.axelaCustomer.customerId,"
					+ " contractLocation.axelaCustomer.customerName,"
					+ " contractLocation.contractlocCityId,"
					+ " contractLocation.contractlocPin,"
					+ " contractLocation.contractlocLat,"
					+ " contractLocation.contractlocLong,"
					+ " contractLocation.contractlocNotes,"
					+ " COALESCE(contractLocation.axelaServiceContractAsset.assetContractlocId, '0') AS assetContractlocId)";
			sqlJoin += " FROM AxelaServiceContractLocation contractLocation"
					+ " LEFT JOIN contractLocation.axelaCustomer"
					+ " LEFT JOIN contractLocation.axelaServiceContractAsset"
					+ " WHERE 1=1" + strSearch;
			countSql = "SELECT COUNT(DISTINCT contractLocation.contractlocId) " + sqlJoin;
			totalCount = em.createQuery(countSql).getResultList().get(0) + "";
			if (!totalCount.equals("0")) {
				strSql += sqlJoin
						+ " GROUP BY contractLocation.contractlocId "
						+ strOrderBy;
				axelaServiceContractLocation = em.createQuery(strSql, AxelaServiceContractLocation.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
			}
			em.close();
			return axelaServiceContractLocation;
		}
	}
	public List<AxelaServiceContractLocation> findBypopulate(String contractlocId)
	{
		String Query = "SELECT NEW AxelaServiceContractLocation("
				+ " location.contractlocId,"
				+ " location.contractlocCustomerId,"
				+ " location.contractlocName,"
				+ " location.contractlocAddress,"
				+ " location.contractlocPin,"
				+ " location.contractlocCityId,"
				+ " location.contractlocLat,"
				+ " location.contractlocLong,"
				+ " location.contractlocNotes,"
				+ "	location.contractlocEntryId,"
				+ " location.contractlocEntryDate,"
				+ "	location.contractlocModifiedId,"
				+ " location.contractlocModifiedDate)"
				+ " FROM AxelaServiceContractLocation location"
				+ " WHERE location.contractlocId = " + contractlocId + "";

		TypedQuery<AxelaServiceContractLocation> typedQuery = em.createQuery(Query, AxelaServiceContractLocation.class);
		listLength = em.createQuery(Query, AxelaServiceContractLocation.class).getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}
}
