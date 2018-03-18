package axela.pm.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.pm.model.AxelaPmMilestone;

@Repository
@Transactional(readOnly = true)
public class PmMilestoneRepositoryImpl {

	@PersistenceContext
	EntityManager em = null;

	// StrSql = "SELECT pmmilestone_id, pmmilestone_pm_id, pmmilestone_name, COALESCE(task_subject,'') AS task_subject,"
	// + " COALESCE(task_pmmilestone_id,'') AS task_pmmilestone_id, task_start_date, task_end_date,"
	// + " pmmilestone_desc, pmmilestone_rank"
	// + " FROM " + compdb(comp_id) + "axela_pm_milestone"
	// + " LEFT JOIN " + compdb(comp_id) + "axela_pm_task ON task_pmmilestone_id = pmmilestone_id"
	// // + " INNER JOIN " + compdb(comp_id) + "axela_pm_task_status ON taskstatus_id = task_taskstatus_id"
	// + " INNER JOIN " + compdb(comp_id) + "axela_pm ON pm_id = pmmilestone_pm_id"
	// + " WHERE pmmilestone_pm_id = " + pm_id + ""
	// + " GROUP BY pmmilestone_id"
	// + " ORDER BY pmmilestone_id";

	public List<AxelaPmMilestone> findmilestone(String strSearch) {
		System.out.println("queryinnnnnnnnn");
		String Query = "SELECT NEW AxelaPmMilestone("
				+ " milestone.pmmilestoneId,"
				+ " milestone.pmmilestonePmId,"
				+ " milestone.pmmilestoneName,"
				+ " COALESCE(pmtask.taskSubject, '') AS taskSubject,"
				+ " COALESCE(pmtask.taskPmmilestoneId, '') AS taskPmmilestoneId,"
				+ " pmtask.taskStartDate,"
				+ " pmtask.taskEndDate,"
				+ " milestone.pmmilestoneDesc,"
				+ " milestone.pmmilestoneRank)"
				+ " FROM AxelaPmMilestone milestone"
				+ " LEFT JOIN milestone.axelaPmTask pmtask"
				+ " JOIN milestone.axelaPm pm"
				// + " LEFT JOIN task.AxelaPmTask  AS parent on parent.taskId=task.taskParentId"
				+ " WHERE 1 = 1" + strSearch;

		System.out.println("query222222222222222========" + Query);
		TypedQuery<AxelaPmMilestone> typedQuery = em.createQuery(Query, AxelaPmMilestone.class);
		return typedQuery.getResultList();

	}

}
