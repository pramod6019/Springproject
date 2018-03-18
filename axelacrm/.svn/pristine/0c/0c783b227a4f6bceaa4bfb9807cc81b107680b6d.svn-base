package axela.activities.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the axela_activity_priority database table.
 * 
 */
@Entity
@Table(name = "axela_activity_priority")
@NamedQuery(name = "AxelaActivityPriority.findAll", query = "SELECT a FROM AxelaActivityPriority a")
public class AxelaActivityPriority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "priority_id")
	private int priorityId;

	@Column(name = "priority_name")
	private String priorityName;

	public AxelaActivityPriority() {
	}

	public int getPriorityId() {
		return this.priorityId;
	}

	public void setPriorityId(int priorityId) {
		this.priorityId = priorityId;
	}

	public List<AxelaActivity> getAxelaActivity() {
		return axelaActivity;
	}

	public void setAxelaActivity(List<AxelaActivity> axelaActivity) {
		this.axelaActivity = axelaActivity;
	}

	public String getPriorityName() {
		return this.priorityName;
	}

	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}

	// activity
	@OneToMany(mappedBy = "axelaActivityPriority", cascade = CascadeType.ALL)
	private List<AxelaActivity> axelaActivity;

}