package axela.sales.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import axela.sales.model.AxelaSalesTargetModel;
import axela.sales.repository.SalesTargetModalRepository.SalesTargetModelFilter;

@Repository
public class SalesTargetModelFilterImpl implements SalesTargetModelFilter {
	public static int targetLength = 0;

	@PersistenceContext
	EntityManager em;

	public List<AxelaSalesTargetModel> findAll(String strsearch) {

		String Query = "SELECT NEW AxelaSalesTargetModel(targetModal.modeltargetTargetId,"
				+ " targetModal.modeltargetModelId,"
				+ " COALESCE(target.targetStartdate, '') AS targetStartdate,"
				+ " COALESCE(target.targetEnddate, '') AS targetEnddate,"
				+ " COALESCE(targetModal.modeltargetOpprCount, 0) AS modeltargetOpprCount,"
				+ " COALESCE(targetModal.modeltargetOpprCallsCount, 0) AS modeltargetOpprCallsCount,"
				+ " COALESCE(targetModal.modeltargetOpprMeetingsCount, 0) AS modeltargetOpprMeetingsCount,"
				+ " COALESCE(targetModal.modeltargetOpprDemosCount, 0) AS modeltargetOpprDemosCount,"
				+ " COALESCE(targetModal.modeltargetOpprHotCount, 0) AS modeltargetOpprHotCount,"
				+ " COALESCE(targetModal.modeltargetSoCount, 0) AS modeltargetSoCount,"
				+ " COALESCE(targetModal.modeltargetSoAmount, 0) AS modeltargetSoAmount )"
				+ " FROM AxelaSalesTargetModel targetModal"
				+ " join targetModal.axelaSalesTarget target"
				+ " WHERE 1=1 "
				+ strsearch;

		TypedQuery<AxelaSalesTargetModel> typedQuery = em.createQuery(Query, AxelaSalesTargetModel.class);
		em.close();
		return typedQuery.getResultList();
	}

}
