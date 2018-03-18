package axela.inventory.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.inventory.model.AxelaInventoryItemModel;
import axela.inventory.repository.InventoryItemModelRepository.InventoryItemModelFilterRepository;

@Repository
@Transactional(readOnly = true)
public class InventoryItemModelFilterImp extends Connect implements InventoryItemModelFilterRepository {

	@PersistenceContext
	EntityManager em;
	public static String totalCount = "0";
	public static int itemModalLength = 0;

	public List<AxelaInventoryItemModel> findAll(String strSearch, String strOrderBy, int page, int perPage) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaInventoryItemModel> listData = new ArrayList<AxelaInventoryItemModel>();
		String strSql = "SELECT NEW AxelaInventoryItemModel("
				+ " itemModel.modelId,"
				+ " itemModel.modelName,"
				+ " itemModel.modelActive)";
		sqlJoin += " FROM AxelaInventoryItemModel itemModel"
				+ " WHERE 1=1"
				+ " AND itemModel.modelId !=0" + strSearch;
		countSql = "SELECT COUNT(DISTINCT itemModel.modelId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY itemModel.modelId"
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaInventoryItemModel.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
		}
		em.close();
		return listData;
	}
}
