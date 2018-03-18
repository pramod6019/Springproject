package axela.portal.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.portal.model.AxelaCity;
import axela.portal.repository.AxelaCityRepository.CityRepoFilter;
@Repository
@Transactional(readOnly = true)
public class AxelaCityRepositoryImpl extends Connect implements CityRepoFilter {
	@PersistenceContext
	EntityManager em;

	@Override
	public List<AxelaCity> findByCityAndName(int cityId, String cityName, Pageable pageAble) {
		String query = "SELECT"
				+ " a"
				+ " FROM AxelaCity a"
				+ " WHERE 1=1";
		if (cityId != 0) {
			query += " AND a.cityId=" + cityId;
		}
		if (!cityName.equals("")) {
			query += " AND a.cityName LIKE '%" + cityName + "%'";
		}
		query += " GROUP BY a.cityId"
				+ " ORDER BY a.cityName";
		TypedQuery<AxelaCity> typed = em.createQuery(query, AxelaCity.class).setFirstResult((1 - 1) * 10).setMaxResults(10);
		return typed.getResultList();
	}
}
