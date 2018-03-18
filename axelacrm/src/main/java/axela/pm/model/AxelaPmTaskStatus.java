package axela.pm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_pm_task_status database table.
 * 
 */
@Entity
@Table(name = "axela_pm_task_status", catalog = "axela_1")
@NamedQuery(name = "AxelaPmTaskStatus.findAll", query = "SELECT a FROM AxelaPmTaskStatus a")
public class AxelaPmTaskStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "taskstatus_id")
	private int taskstatusId;

	@Column(name = "taskstatus_name")
	private String taskstatusName;

	public AxelaPmTaskStatus() {
	}

	public int getTaskstatusId() {
		return this.taskstatusId;
	}

	public void setTaskstatusId(int taskstatusId) {
		this.taskstatusId = taskstatusId;
	}

	public String getTaskstatusName() {
		return this.taskstatusName;
	}

	public void setTaskstatusName(String taskstatusName) {
		this.taskstatusName = taskstatusName;
	}

}