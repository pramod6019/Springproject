package axela.pm.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.pm.model.AxelaPmTask;

@Repository
@Transactional(readOnly = true)
public class TaskRepositoryImpl {

	public static String totalCount = "0";

	@PersistenceContext
	EntityManager em = null;
	public List<AxelaPmTask> findAll(String strSearch, String strOrderBy, int page, int perPage, String app) {
		String sqlJoin = "";
		String countSql = "";
		List<AxelaPmTask> listData = new ArrayList<AxelaPmTask>();
		String strSql = "SELECT NEW AxelaPmTask("
				+ " task.taskSubject,"
				+ " task.taskId,"
				+ " task.axelaPm.pmTitle,"
				+ " task.taskPmId,"
				+ " task.taskEmpId,"
				+ " task.taskStartDate,"
				+ " task.taskEndDate,"
				+ " task.taskCompletionDate,"
				+ " task.taskCompletePerc,"
				+ " task.taskActive,"
				+ " task.axelaEmp.empName,"
				+ " task.taskNotes,"
				+ " task.taskExpense,"
				+ " task.taskBudget)";
		sqlJoin += " FROM AxelaPmTask task"
				+ " JOIN task.axelaEmp"
				+ " LEFT JOIN task.axelaPm"
				// + " LEFT JOIN task.AxelaPmTask  AS parent on parent.taskId=task.taskParentId"
				+ " WHERE 1 = 1" + strSearch;
		countSql = "SELECT COUNT(DISTINCT task.taskId) " + sqlJoin;
		totalCount = em.createQuery(countSql).getResultList().get(0) + "";
		if (!totalCount.equals("0")) {
			strSql += sqlJoin
					+ " GROUP BY task.taskId"
					+ strOrderBy;
			listData = em.createQuery(strSql, AxelaPmTask.class).setFirstResult((page - 1) * perPage).setMaxResults(perPage).getResultList();
			// listData = typedQuery.getResultList();
		}
		em.close();
		return listData;
	}

	// StrSql = "SELECT task_id, pm_id, task_parent_id, task_subject, task_emp_id, task_budget,"
	// + " task_start_date, task_end_date, task_completion_date, task_complete_perc,"
	// + " task_active, task_notes, task_entry_id, task_entry_date, task_modified_id, task_modified_date,"
	// + " pm_title"
	// + " FROM " + compdb(comp_id) + "axela_pm_task"
	// + " LEFT JOIN " + compdb(comp_id) + "axela_pm on  task_pm_id = pm_id"
	// + " WHERE task_id=" + task_id + BranchAccess + ExeAccess + " "
	// + " group by task_id ";

	public AxelaPmTask findOneForDash(int taskId) {
		System.out.println("queryinnnnnnnnn");
		String Query = "SELECT NEW AxelaPmTask("
				+ " task.taskId,"
				+ " task.axelaPm.pmId,"
				+ " task.taskParentId,"
				+ " task.taskSubject,"
				+ " task.taskEmpId,"
				+ " task.taskBudget,"
				+ " task.taskStartDate,"
				+ " task.taskEndDate,"
				+ " task.taskCompletionDate,"
				+ " task.taskCompletePerc,"
				+ " task.taskActive,"
				+ " task.taskNotes,"
				+ " task.taskEntryId,"
				+ " task.taskEntryDate,"
				+ " task.taskModifiedId,"
				+ " task.taskModifiedDate,"
				+ " task.axelaPm.pmTitle)"
				+ " FROM AxelaPmTask task"
				+ " LEFT JOIN task.axelaPm"
				+ " WHERE task.taskId= " + taskId;
		System.out.println("query222222222222222========" + Query);
		TypedQuery<AxelaPmTask> typedQuery = em.createQuery(Query, AxelaPmTask.class);
		return typedQuery.getSingleResult();
	}
	public List<AxelaPmTask> findkanban(String strSearch) {
		System.out.println("queryinnnnnnnnn");
		String Query = "SELECT NEW AxelaPmTask("
				+ " task.taskId,"
				+ " task.taskEndDate,"
				+ " task.taskStartDate,"
				+ " task.axelaPmTaskStatus.taskstatusName,"
				+ " task.taskSubject,"
				+ " task.axelaPmTaskStatus.taskstatusId,"
				+ " task.taskTaskstatusId)"
				+ " FROM AxelaPmTask task"
				+ " JOIN task.axelaEmp"
				+ " JOIN task.axelaPmTaskStatus"
				// + " LEFT JOIN task.AxelaPmTask  AS parent on parent.taskId=task.taskParentId"
				+ " WHERE 1 = 1" + strSearch;

		System.out.println("query222222222222222========" + Query);
		TypedQuery<AxelaPmTask> typedQuery = em.createQuery(Query, AxelaPmTask.class);
		return typedQuery.getResultList();

	}
}
