package axela.customer.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class GroupFilterImpl {

	@PersistenceContext
	EntityManager em;

	public List<Object[]> findByIdAndName(String groupIds) {
		String query = "SELECT group.groupId,group.groupDesc"
				+ " FROM AxelaCustomerGroup group"
				+ " WHERE group.groupId IN (" + groupIds + ")";
		List list = em.createQuery(query).getResultList();
		return list;
	}
}
