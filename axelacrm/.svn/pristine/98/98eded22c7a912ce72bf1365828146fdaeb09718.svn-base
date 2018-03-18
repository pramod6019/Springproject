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
 * The persistent class for the axela_pm_task_priority database table.
 * 
 */
@Entity
@Table(name = "axela_pm_task_priority", catalog = "axela_1")
@NamedQuery(name = "AxelaPmTaskPriority.findAll", query = "SELECT a FROM AxelaPmTaskPriority a")
public class AxelaPmTaskPriority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prioritytask_id")
	private int prioritytaskId;

	@Column(name = "prioritytask_name")
	private String prioritytaskName;

	@Column(name = "prioritytask_rank")
	private int prioritytaskRank;

	public AxelaPmTaskPriority() {
	}

	public int getPrioritytaskId() {
		return this.prioritytaskId;
	}

	public void setPrioritytaskId(int prioritytaskId) {
		this.prioritytaskId = prioritytaskId;
	}

	public String getPrioritytaskName() {
		return this.prioritytaskName;
	}

	public void setPrioritytaskName(String prioritytaskName) {
		this.prioritytaskName = prioritytaskName;
	}

	public int getPrioritytaskRank() {
		return this.prioritytaskRank;
	}

	public void setPrioritytaskRank(int prioritytaskRank) {
		this.prioritytaskRank = prioritytaskRank;
	}

}