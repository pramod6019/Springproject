package axela.pm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the axela_pm_milestone database table.
 * 
 */
@Entity
@Table(name = "axela_pm_milestone", catalog = "axela_1")
@NamedQuery(name = "AxelaPmMilestone.findAll", query = "SELECT a FROM AxelaPmMilestone a")
public class AxelaPmMilestone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pmmilestone_id")
	private int pmmilestoneId;

	@Column(name = "pmmilestone_active")
	private String pmmilestoneActive;

	@Column(name = "pmmilestone_desc")
	private String pmmilestoneDesc;

	public String getTaskSubject() {
		return taskSubject;
	}

	public void setTaskSubject(String taskSubject) {
		this.taskSubject = taskSubject;
	}

	public int getTaskPmmilestoneId() {
		return taskPmmilestoneId;
	}

	public void setTaskPmmilestoneId(int taskPmmilestoneId) {
		this.taskPmmilestoneId = taskPmmilestoneId;
	}

	public Date getTaskStartDate() {
		return taskStartDate;
	}

	public void setTaskStartDate(Date taskStartDate) {
		this.taskStartDate = taskStartDate;
	}

	public Date getTaskEndDate() {
		return taskEndDate;
	}

	public void setTaskEndDate(Date taskEndDate) {
		this.taskEndDate = taskEndDate;
	}

	@Column(name = "pmmilestone_due_date")
	private Date pmmilestoneDueDate;

	@Column(name = "pmmilestone_entry_date")
	private Date pmmilestoneEntryDate;

	@Column(name = "pmmilestone_entry_id")
	private int pmmilestoneEntryId;

	@Column(name = "pmmilestone_modified_date")
	private Date pmmilestoneModifiedDate;

	@Column(name = "pmmilestone_modified_id")
	private int pmmilestoneModifiedId;

	@Column(name = "pmmilestone_name")
	private String pmmilestoneName;

	@Column(name = "pmmilestone_pm_id")
	private int pmmilestonePmId;

	@Column(name = "pmmilestone_rank")
	private int pmmilestoneRank;

	@Transient
	private String taskSubject;

	@Transient
	private int taskPmmilestoneId;

	@Transient
	private Date taskStartDate;

	@Transient
	private Date taskEndDate;

	public AxelaPmMilestone(int pmmilestoneId, int pmmilestonePmId, String pmmilestoneName,
			String taskSubject, int taskPmmilestoneId,
			Date taskStartDate, Date taskEndDate, String pmmilestoneDesc, int pmmilestoneRank) {
		super();
		this.pmmilestoneId = pmmilestoneId;
		this.pmmilestonePmId = pmmilestonePmId;
		this.pmmilestoneName = pmmilestoneName;
		this.taskSubject = taskSubject;
		this.taskPmmilestoneId = taskPmmilestoneId;
		this.taskStartDate = taskStartDate;
		this.taskEndDate = taskEndDate;
		this.pmmilestoneDesc = pmmilestoneDesc;
		this.pmmilestoneRank = pmmilestoneRank;
	}

	public AxelaPmMilestone() {
	}

	// String Query = "SELECT NEW AxelaPmMilestone("
	// + " milestone.pmmilestoneId,"
	// + " milestone.pmmilestonePmId,"
	// + " milestone.pmmilestoneName,"
	// + " COALESCE(pmtask.taskSubject, '') AS taskSubject,"
	// + " COALESCE(pmtask.taskPmmilestoneId, '') AS taskPmmilestoneId,"
	// + " milestone.taskStartDate,"
	// + " milestone.taskEndDate,"
	// + " milestone.pmmilestoneDesc,"
	// + " milestone.pmmilestoneRank)"
	// + " FROM AxelaPmMilestone milestone"
	// + " LEFT JOIN task.axelaPmTask pmtask"
	// + " JOIN task.axelaPm pm"
	// // + " LEFT JOIN task.AxelaPmTask  AS parent on parent.taskId=task.taskParentId"
	// + " WHERE 1 = 1" + strSearch;

	public int getPmmilestoneId() {
		return this.pmmilestoneId;
	}

	public void setPmmilestoneId(int pmmilestoneId) {
		this.pmmilestoneId = pmmilestoneId;
	}

	public String getPmmilestoneActive() {
		return this.pmmilestoneActive;
	}

	public void setPmmilestoneActive(String pmmilestoneActive) {
		this.pmmilestoneActive = pmmilestoneActive;
	}

	public String getPmmilestoneDesc() {
		return this.pmmilestoneDesc;
	}

	public void setPmmilestoneDesc(String pmmilestoneDesc) {
		this.pmmilestoneDesc = pmmilestoneDesc;
	}

	public Date getPmmilestoneDueDate() {
		return this.pmmilestoneDueDate;
	}

	public void setPmmilestoneDueDate(Date pmmilestoneDueDate) {
		this.pmmilestoneDueDate = pmmilestoneDueDate;
	}

	public Date getPmmilestoneEntryDate() {
		return this.pmmilestoneEntryDate;
	}

	public void setPmmilestoneEntryDate(Date pmmilestoneEntryDate) {
		this.pmmilestoneEntryDate = pmmilestoneEntryDate;
	}

	public int getPmmilestoneEntryId() {
		return this.pmmilestoneEntryId;
	}

	public void setPmmilestoneEntryId(int pmmilestoneEntryId) {
		this.pmmilestoneEntryId = pmmilestoneEntryId;
	}

	public Date getPmmilestoneModifiedDate() {
		return this.pmmilestoneModifiedDate;
	}

	public void setPmmilestoneModifiedDate(Date pmmilestoneModifiedDate) {
		this.pmmilestoneModifiedDate = pmmilestoneModifiedDate;
	}

	public int getPmmilestoneModifiedId() {
		return this.pmmilestoneModifiedId;
	}

	public void setPmmilestoneModifiedId(int pmmilestoneModifiedId) {
		this.pmmilestoneModifiedId = pmmilestoneModifiedId;
	}

	public String getPmmilestoneName() {
		return this.pmmilestoneName;
	}

	public void setPmmilestoneName(String pmmilestoneName) {
		this.pmmilestoneName = pmmilestoneName;
	}

	public int getPmmilestonePmId() {
		return this.pmmilestonePmId;
	}

	public void setPmmilestonePmId(int pmmilestonePmId) {
		this.pmmilestonePmId = pmmilestonePmId;
	}

	public int getPmmilestoneRank() {
		return this.pmmilestoneRank;
	}

	public void setPmmilestoneRank(int pmmilestoneRank) {
		this.pmmilestoneRank = pmmilestoneRank;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pmmilestone_pm_id", referencedColumnName = "pm_id", insertable = false, updatable = false)
	private AxelaPm axelaPm;

	@OneToMany(mappedBy = "axelaPmMilestone", cascade = CascadeType.ALL)
	private List<AxelaPmTask> axelaPmTask;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "task_taskstatus_id", referencedColumnName = "taskstatus_id", insertable = false, updatable = false)
	private AxelaPmTaskStatus axelaPmTaskStatus;

}