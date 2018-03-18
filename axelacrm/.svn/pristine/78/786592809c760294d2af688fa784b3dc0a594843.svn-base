package axela.sales.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_sales_oppr_followup_type database table.
 * 
 */
@Entity
@Table(name = "axela_sales_oppr_followup_type", catalog = "axela_1")
@NamedQuery(name = "AxelaSalesOpprFollowupType.findAll", query = "SELECT a FROM AxelaSalesOpprFollowupType a")
public class AxelaSalesOpprFollowupType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "followuptype_id")
	private int followuptypeId;

	@Column(name = "followuptype_name")
	private String followuptypeName;

	public AxelaSalesOpprFollowupType() {
	}

	public int getFollowuptypeId() {
		return this.followuptypeId;
	}

	public void setFollowuptypeId(int followuptypeId) {
		this.followuptypeId = followuptypeId;
	}

	public String getFollowuptypeName() {
		return this.followuptypeName;

	}

	public void setFollowuptypeName(String followuptypeName) {
		this.followuptypeName = followuptypeName;
	}

}