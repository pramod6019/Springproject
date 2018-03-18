package axela.sales.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.sales.model.AxelaSalesTarget;
import axela.sales.repository.SalesTargetRepository.targetFilterRepository;

@Repository
@Transactional(readOnly = true)
public class TargetFilterImpl extends Connect implements targetFilterRepository {

	@PersistenceContext
	EntityManager em;

	public static int targetLength = 0;

	public List<AxelaSalesTarget> findAll(String strsearch) {
		String Query = "SELECT NEW AxelaSalesTarget(a.targetId,"
				+ " COALESCE(a.targetStartdate, '') AS targetStartdate,"
				+ " COALESCE(a.targetEnddate, '') AS targetEnddate,"
				+ " COALESCE(a.targetOpprCount, 0) AS targetOpprCount,"
				+ " COALESCE(a.targetOpprCallsCount, 0) AS targetOpprCallsCount,"
				+ " COALESCE(a.targetOpprMeetingsCount, 0) AS targetOpprMeetingsCount,"
				+ " COALESCE(a.targetOpprDemosCount, 0) AS targetOpprDemosCount,"
				+ " COALESCE(a.targetOpprHotCount, 0) AS targetOpprHotCount,"
				+ " COALESCE(a.targetSoCount, 0) AS targetSoCount,"
				+ " COALESCE(a.targetSoAmount, 0) AS targetSoAmount )"
				+ " FROM AxelaSalesTarget a"
				+ " WHERE 1=1 "
				+ strsearch;

		TypedQuery<AxelaSalesTarget> typedQuery = em.createQuery(Query, AxelaSalesTarget.class);
		targetLength = em.createQuery(Query, AxelaSalesTarget.class).getResultList().size();

		em.clear();

		return typedQuery.getResultList();
	}

	public AxelaSalesTarget getTargetId(String Query) {
		AxelaSalesTarget axelaSalesTarget = new AxelaSalesTarget();
		TypedQuery<AxelaSalesTarget> typedQuery = em.createQuery(Query, AxelaSalesTarget.class);
		List list = typedQuery.getResultList();
		if (!list.isEmpty()) {
			axelaSalesTarget = typedQuery.getSingleResult();
		}
		return axelaSalesTarget;
	}
}
