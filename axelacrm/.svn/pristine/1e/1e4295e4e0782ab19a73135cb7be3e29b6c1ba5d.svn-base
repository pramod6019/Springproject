package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_empcount database table.
 * 
 */
@Entity
@Table(name = "axela_empcount", catalog = "axela_1")
@NamedQuery(name = "AxelaEmpcount.findAll", query = "SELECT a FROM AxelaEmpcount a")
public class AxelaEmpcount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "empcount_id")
	private int empcountId;

	@Column(name = "empcount_desc")
	private String empcountDesc;

	public AxelaEmpcount() {
	}

	public int getEmpcountId() {
		return this.empcountId;
	}

	public void setEmpcountId(int empcountId) {
		this.empcountId = empcountId;
	}

	public String getEmpcountDesc() {
		return this.empcountDesc;
	}

	public void setEmpcountDesc(String empcountDesc) {
		this.empcountDesc = empcountDesc;
	}
}