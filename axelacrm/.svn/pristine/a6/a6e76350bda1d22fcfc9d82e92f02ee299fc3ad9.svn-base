package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the axela_acc_group_pop database table.
 * 
 */
@Entity
@Table(name = "axela_acc_group_pop", catalog = "axela_1")
@NamedQuery(name = "AxelaAccGroupPop.findAll", query = "SELECT a FROM AxelaAccGroupPop a")
public class AxelaAccGroupPop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "accgrouppop_id")
	private int accgrouppopId;

	@Column(name = "accgrouppop_alie")
	private int accgrouppopAlie;

	@Column(name = "accgrouppop_name")
	private String accgrouppopName;

	@Column(name = "accgrouppop_rank")
	private int accgrouppopRank;

	// bi-directional one-to-one association to AxelaAccGroup
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accgrouppop_id")
	private AxelaAccGroup axelaAccGroup;

	public AxelaAccGroupPop() {
	}

	public int getAccgrouppopId() {
		return this.accgrouppopId;
	}

	public void setAccgrouppopId(int accgrouppopId) {
		this.accgrouppopId = accgrouppopId;
	}

	public int getAccgrouppopAlie() {
		return this.accgrouppopAlie;
	}

	public void setAccgrouppopAlie(int accgrouppopAlie) {
		this.accgrouppopAlie = accgrouppopAlie;
	}

	public String getAccgrouppopName() {
		return this.accgrouppopName;
	}

	public void setAccgrouppopName(String accgrouppopName) {
		this.accgrouppopName = accgrouppopName;
	}

	public int getAccgrouppopRank() {
		return this.accgrouppopRank;
	}

	public void setAccgrouppopRank(int accgrouppopRank) {
		this.accgrouppopRank = accgrouppopRank;
	}

	public AxelaAccGroup getAxelaAccGroup() {
		return this.axelaAccGroup;
	}

	public void setAxelaAccGroup(AxelaAccGroup axelaAccGroup) {
		this.axelaAccGroup = axelaAccGroup;
	}

}