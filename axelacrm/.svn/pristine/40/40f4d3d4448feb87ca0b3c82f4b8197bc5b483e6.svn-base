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
 * The persistent class for the axela_pm_status database table.
 * 
 */
@Entity
@Table(name = "axela_pm_status", catalog = "axela_1")
@NamedQuery(name = "AxelaPmStatus.findAll", query = "SELECT a FROM AxelaPmStatus a")
public class AxelaPmStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pmstatus_id")
	private int pmstatusId;

	@Column(name = "pmstatus_name")
	private String pmstatusName;

	public AxelaPmStatus() {
	}

	public int getPmstatusId() {
		return this.pmstatusId;
	}

	public void setPmstatusId(int pmstatusId) {
		this.pmstatusId = pmstatusId;
	}

	public String getPmstatusName() {
		return this.pmstatusName;
	}

	public void setPmstatusName(String pmstatusName) {
		this.pmstatusName = pmstatusName;
	}

}