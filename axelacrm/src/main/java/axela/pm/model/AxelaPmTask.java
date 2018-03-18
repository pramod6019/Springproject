package axela.pm.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import axela.portal.model.AxelaEmp;

/**
 * The persistent class for the axela_pm_task database table.
 * 
 */
@Entity
@Table(name = "axela_pm_task", catalog = "axela_1")
@NamedQuery(name = "AxelaPmTask.findAll", query = "SELECT a FROM AxelaPmTask a")
public class AxelaPmTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id")
	private int taskId;

	public String getPmTitle() {
		return pmTitle;
	}

	public void setPmTitle(String pmTitle) {
		this.pmTitle = pmTitle;
	}

	public AxelaPm getAxelaPm() {
		return axelaPm;
	}

	public void setAxelaPm(AxelaPm axelaPm) {
		this.axelaPm = axelaPm;
	}

	public AxelaEmp getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(AxelaEmp axelaEmp) {
		this.axelaEmp = axelaEmp;
	}

	@Column(name = "task_active")
	private String taskActive;

	@Column(name = "task_budget")
	private int taskBudget;

	@Column(name = "task_complete_perc")
	private int taskCompletePerc;

	@Column(name = "task_completion_date")
	private Date taskCompletionDate;

	@Column(name = "task_emp_id")
	private int taskEmpId;

	@Column(name = "task_end_date")
	private Date taskEndDate;

	@Column(name = "task_entry_date")
	private Date taskEntryDate;

	@Column(name = "task_entry_id")
	private int taskEntryId;

	@Column(name = "task_expense")
	private int taskExpense;

	@Column(name = "task_modified_date")
	private Date taskModifiedDate;

	@Column(name = "task_modified_id")
	private int taskModifiedId;

	@Column(name = "task_notes")
	private String taskNotes;

	@Column(name = "task_parent_id")
	private int taskParentId;

	@Column(name = "task_pm_id")
	private int taskPmId;

	@Column(name = "task_pmmilestone_id")
	private int taskPmmilestoneId;

	@Column(name = "task_prioritytask_id")
	private int taskPrioritytaskId;

	@Column(name = "task_start_date")
	private Date taskStartDate;

	@Column(name = "task_subject")
	private String taskSubject;

	@Column(name = "task_taskstatus_id")
	private int taskTaskstatusId;

	@Transient
	private long todayTask;
	@Transient
	private long totalTask;
	@Transient
	private long monthTask;
	@Transient
	private String pmTitle;
	@Transient
	private String empName;
	@Transient
	private String pmCompleteComments;
	@Transient
	private String taskstatusName;
	@Transient
	private int pmId;

	public int getTaskstatusId() {
		return taskstatusId;
	}

	public void setTaskstatusId(int taskstatusId) {
		this.taskstatusId = taskstatusId;
	}

	@Transient
	private int taskstatusId;

	public AxelaPmTask(int taskId, int pmId, int taskParentId, String taskSubject, int taskEmpId,
			int taskBudget, Date taskStartDate, Date taskEndDate,
			Date taskCompletionDate, int taskCompletePerc, String taskActive,
			String taskNotes,
			int taskEntryId,
			Date taskEntryDate,
			int taskModifiedId,
			Date taskModifiedDate,
			String pmTitle) {
		super();
		this.taskId = taskId;
		this.pmId = pmId;
		this.taskParentId = taskParentId;
		this.taskSubject = taskSubject;
		this.taskEmpId = taskEmpId;
		this.taskBudget = taskBudget;
		this.taskStartDate = taskStartDate;
		this.taskEndDate = taskEndDate;
		this.taskCompletePerc = taskCompletePerc;
		this.taskCompletionDate = taskCompletionDate;
		this.taskActive = taskActive;
		this.taskNotes = taskNotes;
		this.taskEntryId = taskEntryId;
		this.taskEntryDate = taskEntryDate;
		this.taskModifiedId = taskModifiedId;
		this.taskModifiedDate = taskModifiedDate;
		this.pmTitle = pmTitle;
	}

	public int getPmId() {
		return pmId;
	}

	public void setPmId(int pmId) {
		this.pmId = pmId;
	}

	public String getPmCompleteComments() {
		return pmCompleteComments;
	}

	public void setPmCompleteComments(String pmCompleteComments) {
		this.pmCompleteComments = pmCompleteComments;
	}

	public long getTodayTask() {
		return todayTask;
	}

	public void setTodayTask(long todayTask) {
		this.todayTask = todayTask;
	}

	public long getTotalTask() {
		return totalTask;
	}

	public void setTotalTask(long totalTask) {
		this.totalTask = totalTask;
	}

	public long getMonthTask() {
		return monthTask;
	}

	public void setMonthTask(long monthTask) {
		this.monthTask = monthTask;
	}

	public AxelaPmTask(int taskCompletePerc) {
		super();
		this.taskCompletePerc = taskCompletePerc;
	}
	// String Query = "SELECT NEW AxelaPmTask("
	// + " task.taskId,"
	// + " task.axelapm.pmId,"
	// + " task.taskParentId,"
	// + " task.taskSubject,"
	// + " task.taskEmpId,"
	// + " task.taskBudget,"
	// + " task.taskStartDate,"
	// + " task.taskEndDate,"
	// + " task.taskCompletionDate,"
	// + " task.taskCompletePerc,"
	// + " task.taskActive,"
	// + " task.taskNotes,"
	// + " task.taskEntryId,"
	// + " task.taskEntryDate,"
	// + " task.taskModifiedId,"
	// + " task.taskModifiedDate,"

	public AxelaPmTask(
			String taskSubject,
			int taskId,
			String pmTitle,
			int taskPmId,
			int taskEmpId,
			Date taskStartDate,
			Date taskEndDate,
			Date taskCompletionDate,
			int taskCompletePerc,
			String taskActive,
			String empName,
			String taskNotes,
			int taskExpense,
			int taskBudget) {

		this.taskSubject = taskSubject;
		this.taskId = taskId;
		this.pmTitle = pmTitle;
		this.taskPmId = taskPmId;
		this.taskEmpId = taskEmpId;
		this.taskStartDate = taskStartDate;
		this.taskEndDate = taskEndDate;
		this.taskCompletionDate = taskCompletionDate;
		this.taskCompletePerc = taskCompletePerc;
		this.taskActive = taskActive;
		this.empName = empName;
		this.taskNotes = taskNotes;
		this.taskExpense = taskExpense;
		this.taskBudget = taskBudget;
	}

	public AxelaPmTask(long todayTask, long totalTask, long monthTask) {
		super();
		this.todayTask = todayTask;
		this.totalTask = totalTask;
		this.monthTask = monthTask;
	}

	// String Query = "SELECT NEW AxelaPmTask("
	// + " task.taskSubject,"
	// + " task.taskId,"
	// + " task.taskTaskstatusId,"
	// + " task.axelaPmTaskStatus.taskstatusName,"
	// + " task.taskStartDate,"
	// + " task.taskEndDate)"
	// + " FROM AxelaPmTask task"
	// + " JOIN task.axelaEmp"
	// + " JOIN task.axelaPmTaskStatus"

	public String getEmpName() {
		return empName;
	}

	public String getTaskstatusName() {
		return taskstatusName;
	}

	public void setTaskstatusName(String taskstatusName) {
		this.taskstatusName = taskstatusName;
	}

	public AxelaPmTask(int taskId, Date taskEndDate, Date taskStartDate, String taskstatusName,
			String taskSubject, int taskstatusId, int taskTaskstatusId) {
		super();
		this.taskId = taskId;
		this.taskEndDate = taskEndDate;
		this.taskStartDate = taskStartDate;
		this.taskstatusName = taskstatusName;
		this.taskSubject = taskSubject;
		this.taskstatusId = taskstatusId;
		this.taskTaskstatusId = taskTaskstatusId;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public AxelaPmTask() {
	}

	public int getTaskId() {
		return this.taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskActive() {
		return this.taskActive;
	}

	public void setTaskActive(String taskActive) {
		this.taskActive = taskActive;
	}

	public int getTaskBudget() {
		return this.taskBudget;
	}

	public void setTaskBudget(int taskBudget) {
		this.taskBudget = taskBudget;
	}

	public int getTaskCompletePerc() {
		return this.taskCompletePerc;
	}

	public void setTaskCompletePerc(int taskCompletePerc) {
		this.taskCompletePerc = taskCompletePerc;
	}

	public Date getTaskCompletionDate() {
		return this.taskCompletionDate;
	}

	public void setTaskCompletionDate(Date taskCompletionDate) {
		this.taskCompletionDate = taskCompletionDate;
	}

	public int getTaskEmpId() {
		return this.taskEmpId;
	}

	public void setTaskEmpId(int taskEmpId) {
		this.taskEmpId = taskEmpId;
	}

	public Date getTaskEndDate() {
		return this.taskEndDate;
	}

	public void setTaskEndDate(Date taskEndDate) {
		this.taskEndDate = taskEndDate;
	}

	public Date getTaskEntryDate() {
		return this.taskEntryDate;
	}

	public void setTaskEntryDate(Date taskEntryDate) {
		this.taskEntryDate = taskEntryDate;
	}

	public int getTaskEntryId() {
		return this.taskEntryId;
	}

	public void setTaskEntryId(int taskEntryId) {
		this.taskEntryId = taskEntryId;
	}

	public int getTaskExpense() {
		return this.taskExpense;
	}

	public void setTaskExpense(int taskExpense) {
		this.taskExpense = taskExpense;
	}

	public Date getTaskModifiedDate() {
		return this.taskModifiedDate;
	}

	public void setTaskModifiedDate(Date taskModifiedDate) {
		this.taskModifiedDate = taskModifiedDate;
	}

	public int getTaskModifiedId() {
		return this.taskModifiedId;
	}

	public void setTaskModifiedId(int taskModifiedId) {
		this.taskModifiedId = taskModifiedId;
	}

	public String getTaskNotes() {
		return this.taskNotes;
	}

	public void setTaskNotes(String taskNotes) {
		this.taskNotes = taskNotes;
	}

	public int getTaskParentId() {
		return this.taskParentId;
	}

	public void setTaskParentId(int taskParentId) {
		this.taskParentId = taskParentId;
	}

	public int getTaskPmId() {
		return this.taskPmId;
	}

	public void setTaskPmId(int taskPmId) {
		this.taskPmId = taskPmId;
	}

	public int getTaskPmmilestoneId() {
		return this.taskPmmilestoneId;
	}

	public void setTaskPmmilestoneId(int taskPmmilestoneId) {
		this.taskPmmilestoneId = taskPmmilestoneId;
	}

	public int getTaskPrioritytaskId() {
		return this.taskPrioritytaskId;
	}

	public void setTaskPrioritytaskId(int taskPrioritytaskId) {
		this.taskPrioritytaskId = taskPrioritytaskId;
	}

	public Date getTaskStartDate() {
		return this.taskStartDate;
	}

	public void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	public String getTaskSubject() {
		return this.taskSubject;
	}

	public void setTaskSubject(String taskSubject) {
		this.taskSubject = taskSubject;
	}

	public int getTaskTaskstatusId() {
		return this.taskTaskstatusId;
	}

	public void setTaskTaskstatusId(int taskTaskstatusId) {
		this.taskTaskstatusId = taskTaskstatusId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "task_pm_id", referencedColumnName = "pm_id", insertable = false, updatable = false)
	private AxelaPm axelaPm;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "task_pmmilestone_id", referencedColumnName = "pmmilestone_id", insertable = false, updatable = false)
	private AxelaPmMilestone axelaPmMilestone;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "task_taskstatus_id", referencedColumnName = "taskstatus_id", insertable = false, updatable = false)
	private AxelaPmTaskStatus axelaPmTaskStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "task_emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

}