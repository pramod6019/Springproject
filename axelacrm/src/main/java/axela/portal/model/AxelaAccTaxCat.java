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
 * The persistent class for the axela_acc_tax_cat database table.
 * 
 */
@Entity
@Table(name = "axela_acc_tax_cat", catalog = "axela_1")
@NamedQuery(name = "AxelaAccTaxCat.findAll", query = "SELECT a FROM AxelaAccTaxCat a")
public class AxelaAccTaxCat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "taxcat_id")
	private int taxcatId;

	@Column(name = "taxcat_name")
	private String taxcatName;

	public AxelaAccTaxCat() {
	}

	public int getTaxcatId() {
		return this.taxcatId;
	}

	public void setTaxcatId(int taxcatId) {
		this.taxcatId = taxcatId;
	}

	public String getTaxcatName() {
		return this.taxcatName;
	}

	public void setTaxcatName(String taxcatName) {
		this.taxcatName = taxcatName;
	}

}