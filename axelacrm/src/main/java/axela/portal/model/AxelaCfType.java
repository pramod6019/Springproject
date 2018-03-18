package axela.portal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the axela_cf_type database table.
 * 
 */
@Entity
@Table(name="axela_cf_type",catalog="axela")
@NamedQuery(name="AxelaCfType.findAll", query="SELECT a FROM AxelaCfType a")
public class AxelaCfType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cftype_id")
	private int cftypeId;

	@Column(name="cftype_name")
	private String cftypeName;

	public AxelaCfType() {
	}

	public int getCftypeId() {
		return this.cftypeId;
	}

	public void setCftypeId(int cftypeId) {
		this.cftypeId = cftypeId;
	}

	public String getCftypeName() {
		return this.cftypeName;
	}

	public void setCftypeName(String cftypeName) {
		this.cftypeName = cftypeName;
	}

}