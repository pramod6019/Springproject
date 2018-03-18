package axela.inventory.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.inventory.model.AxelaInventoryCatPop;
import axela.inventory.repository.InventoryCatPopRepository.InventoryCatPopFilterRepository;

@Repository
@Transactional(readOnly = true)
public class InventoryCatPopFilterImp extends Connect implements InventoryCatPopFilterRepository {

	@PersistenceContext
	EntityManager em;

	public List<AxelaInventoryCatPop> findAllCatIdAndCatName(int catId, String active) {

		String Query = "SELECT NEW AxelaInventoryCatPop("
				+ " a.catId,"
				+ " a.catName)"
				+ " FROM AxelaInventoryCatPop a"
				+ " WHERE 1=1";
		if (!active.equals("")) {
			Query += " AND catActive = " + active + "";
		}
		if (catId != 0) {
			Query += " AND catId != " + catId + "";
		}
		Query += " AND a.catId !=0"
				+ " ORDER BY a.catRank";
		TypedQuery<AxelaInventoryCatPop> typedQuery = em.createQuery(Query, AxelaInventoryCatPop.class);
		em.clear();
		return typedQuery.getResultList();
	}
}
