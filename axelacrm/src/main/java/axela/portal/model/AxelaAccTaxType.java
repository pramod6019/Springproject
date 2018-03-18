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
 * The persistent class for the axela_acc_tax_type database table.
 * 
 */
@Entity
@Table(name = "axela_acc_tax_type", catalog = "axela_1")
@NamedQuery(name = "AxelaAccTaxType.findAll", query = "SELECT a FROM AxelaAccTaxType a")
public class AxelaAccTaxType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "taxtype_id")
	private int taxtypeId;

	@Column(name = "taxtype_name")
	private String taxtypeName;

	public AxelaAccTaxType() {
	}

	public int getTaxtypeId() {
		return this.taxtypeId;
	}

	public void setTaxtypeId(int taxtypeId) {
		this.taxtypeId = taxtypeId;
	}

	public String getTaxtypeName() {
		return this.taxtypeName;
	}

	public void setTaxtypeName(String taxtypeName) {
		this.taxtypeName = taxtypeName;
	}

}