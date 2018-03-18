package axela.portal.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import axela.portal.model.AxelaBranch;

@Repository
public class BranchFilterImpl {

	@PersistenceContext
	EntityManager em;
	public List<AxelaBranch> branchFilter(String strSearch) {
		List listData = new ArrayList<AxelaBranch>();
		String strSql = "SELECT NEW AxelaBranch(branch.branchId, branch.branchName,branch.branchFranchiseeId) FROM AxelaBranch branch "
				+ " WHERE branch.branchActive = '1' "
				+ strSearch;
		listData = em.createQuery(strSql, AxelaBranch.class).getResultList();
		return listData;
	}

}
