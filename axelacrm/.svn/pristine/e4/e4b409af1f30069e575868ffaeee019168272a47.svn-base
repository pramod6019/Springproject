package axela.service.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_service_jc_check_trans database table.
 * 
 */
@Entity
@Table(name = "axela_service_jc_check_trans", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceJcCheckTran.findAll", query = "SELECT a FROM AxelaServiceJcCheckTran a")
public class AxelaServiceJcCheckTran implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trans_jc_id")
	private int transJcId;

	@Column(name = "trans_check_id")
	private String transCheckId;

	@Column(name = "trans_check_entry_date")
	private String transCheckEntryDate;

	public int getTransJcId() {
		return transJcId;
	}

	public void setTransJcId(int transJcId) {
		this.transJcId = transJcId;
	}

	public String getTransCheckId() {
		return transCheckId;
	}

	public void setTransCheckId(String transCheckId) {
		this.transCheckId = transCheckId;
	}

	@Column(name = "trans_check_entry_id")
	private int transCheckEntryId;

	public AxelaServiceJcCheckTran() {
	}

	public String getTransCheckEntryDate() {
		return this.transCheckEntryDate;
	}

	public void setTransCheckEntryDate(String transCheckEntryDate) {
		this.transCheckEntryDate = transCheckEntryDate;
	}

	public AxelaServiceJcCheck getAxelaServiceJcCheck() {
		return axelaServiceJcCheck;
	}

	public void setAxelaServiceJcCheck(AxelaServiceJcCheck axelaServiceJcCheck) {
		this.axelaServiceJcCheck = axelaServiceJcCheck;
	}

	public int getTransCheckEntryId() {
		return this.transCheckEntryId;
	}

	public void setTransCheckEntryId(int transCheckEntryId) {
		this.transCheckEntryId = transCheckEntryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trans_check_id", referencedColumnName = "check_id", insertable = false, updatable = false)
	private AxelaServiceJcCheck axelaServiceJcCheck;

}