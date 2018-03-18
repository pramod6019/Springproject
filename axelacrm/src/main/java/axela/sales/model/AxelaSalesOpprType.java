package axela.sales.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the axela_sales_oppr_type database table.
 * 
 */
@Entity
@Table(name = "axela_sales_oppr_type", catalog = "axela_1")
@NamedQuery(name = "AxelaSalesOpprType.findAll", query = "SELECT a FROM AxelaSalesOpprType a")
public class AxelaSalesOpprType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "opprtype_id")
	private int opprtypeId;

	@Column(name = "opprtype_name")
	private String opprtypeName;

	public AxelaSalesOpprType() {
	}

	public int getOpprtypeId() {
		return this.opprtypeId;
	}

	public void setOpprtypeId(int opprtypeId) {
		this.opprtypeId = opprtypeId;
	}

	public String getOpprtypeName() {
		return this.opprtypeName;
	}

	public void setOpprtypeName(String opprtypeName) {
		this.opprtypeName = opprtypeName;
	}

	@OneToMany(mappedBy = "axelaSalesOpprType", cascade = CascadeType.ALL)
	private List<AxelaSalesOppr> axelaSalesOppr;

	public List<AxelaSalesOppr> getAxelaSalesOppr() {
		return axelaSalesOppr;
	}

	public void setAxelaSalesOppr(List<AxelaSalesOppr> axelaSalesOppr) {
		this.axelaSalesOppr = axelaSalesOppr;
	}

}