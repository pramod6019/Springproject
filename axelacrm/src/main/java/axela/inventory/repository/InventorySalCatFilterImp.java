package axela.inventory.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.inventory.model.AxelaInventorySalescat;
import axela.inventory.repository.InventorySalescatRepository.InventorySalescatFilterRepository;

@Repository
@Transactional(readOnly = true)
public class InventorySalCatFilterImp extends Connect implements InventorySalescatFilterRepository {

	@PersistenceContext
	EntityManager em;

	public static int saleCatLength = 0;

	public List<AxelaInventorySalescat> findAll(String strSearch, int page, int perpage) {

		String Query = "SELECT NEW AxelaInventorySalescat("
				+ " salescat.salescatId,"
				+ " salescat.salescatName,"
				+ " (SELECT COUNT(salescattrans.transItemId) FROM AxelaInventorySalescatTran salescattrans WHERE salescat.salescatId = salescattrans.transSalescatId) AS itemcount)"
				+ " FROM AxelaInventorySalescat salescat"
				+ " WHERE 1=1"
				+ " AND salescat.salescatId !=0" + strSearch;
		TypedQuery<AxelaInventorySalescat> typedQuery = em.createQuery(Query, AxelaInventorySalescat.class).setFirstResult((page - 1) * perpage).setMaxResults(perpage);
		TypedQuery<AxelaInventorySalescat> listLength = em.createQuery(Query, AxelaInventorySalescat.class);
		saleCatLength = listLength.getResultList().size();
		em.clear();
		return typedQuery.getResultList();
	}

}
