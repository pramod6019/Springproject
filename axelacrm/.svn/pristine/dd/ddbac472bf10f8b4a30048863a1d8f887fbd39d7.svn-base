package axela.inventory.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.inventory.model.AxelaInventoryBinPop;
import axela.inventory.repository.InventoryBinPopRepository.InventoryBinPopFilterRepository;

@Repository
@Transactional(readOnly = true)
public class InventoryBinPopFilterImpl extends Connect implements InventoryBinPopFilterRepository {

	@PersistenceContext
	EntityManager em;

	// public List<AxelaInventoryBinPop> populateParentBin(String strSql) {
	// TypedQuery<AxelaInventoryBinPop> typedQuery = em.createQuery(strSql, AxelaInventoryBinPop.class);
	// return typedQuery.getResultList();
	// }

	public List<AxelaInventoryBinPop> populateParentBin(String strSearch) {
		Query query = em.createQuery(strSearch);
		em.clear();
		return query.getResultList();
	}
}
