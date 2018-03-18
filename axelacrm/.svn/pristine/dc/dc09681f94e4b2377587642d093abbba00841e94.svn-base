package axela.portal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the axela_rate_class database table.
 * 
 */
@Entity
@Table(name = "axela_rate_class", catalog = "axela_1")
@NamedQuery(name = "AxelaRateClass.findAll", query = "SELECT a FROM AxelaRateClass a")
public class AxelaRateClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rateclass_id")
	private int rateclassId;

	@Column(name = "rateclass_name")
	private String rateclassName;

	@Column(name = "rateclass_type")
	private String rateclassType;

	@OneToMany(mappedBy = "axelaRateClass")
	private List<AxelaBranch> axelaBranch;

	public AxelaRateClass() {
	}

	public int getRateclassId() {
		return this.rateclassId;
	}

	public void setRateclassId(int rateclassId) {
		this.rateclassId = rateclassId;
	}

	public List<AxelaBranch> getAxelaBranch() {
		return axelaBranch;
	}

	public void setAxelaBranch(List<AxelaBranch> axelaBranch) {
		this.axelaBranch = axelaBranch;
	}

	public String getRateclassName() {
		return this.rateclassName;
	}

	public void setRateclassName(String rateclassName) {
		this.rateclassName = rateclassName;
	}

	public String getRateclassType() {
		return this.rateclassType;
	}

	public void setRateclassType(String rateclassType) {
		this.rateclassType = rateclassType;
	}

}