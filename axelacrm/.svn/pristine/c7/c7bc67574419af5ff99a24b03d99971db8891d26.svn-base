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
 * The persistent class for the axela_acc_paydays database table.
 * 
 */
@Entity
@Table(name = "axela_acc_paydays", catalog = "axela_1")
@NamedQuery(name = "AxelaAccPayday.findAll", query = "SELECT a FROM AxelaAccPayday a")
public class AxelaAccPayday implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "paydays_id")
	private int paydaysId;

	@Column(name = "paydays_days")
	private int paydaysDays;

	@Column(name = "paydays_entry_date")
	private String paydaysEntryDate;

	@Column(name = "paydays_entry_id")
	private int paydaysEntryId;

	@Column(name = "paydays_modified_date")
	private String paydaysModifiedDate;

	@Column(name = "paydays_modified_id")
	private int paydaysModifiedId;

	@Column(name = "paydays_name")
	private String paydaysName;

	public AxelaAccPayday() {
	}

	public int getPaydaysId() {
		return this.paydaysId;
	}

	public void setPaydaysId(int paydaysId) {
		this.paydaysId = paydaysId;
	}

	public int getPaydaysDays() {
		return this.paydaysDays;
	}

	public void setPaydaysDays(int paydaysDays) {
		this.paydaysDays = paydaysDays;
	}

	public String getPaydaysEntryDate() {
		return this.paydaysEntryDate;
	}

	public void setPaydaysEntryDate(String paydaysEntryDate) {
		this.paydaysEntryDate = paydaysEntryDate;
	}

	public int getPaydaysEntryId() {
		return this.paydaysEntryId;
	}

	public void setPaydaysEntryId(int paydaysEntryId) {
		this.paydaysEntryId = paydaysEntryId;
	}

	public String getPaydaysModifiedDate() {
		return this.paydaysModifiedDate;
	}

	public void setPaydaysModifiedDate(String paydaysModifiedDate) {
		this.paydaysModifiedDate = paydaysModifiedDate;
	}

	public int getPaydaysModifiedId() {
		return this.paydaysModifiedId;
	}

	public void setPaydaysModifiedId(int paydaysModifiedId) {
		this.paydaysModifiedId = paydaysModifiedId;
	}

	public String getPaydaysName() {
		return this.paydaysName;
	}

	public void setPaydaysName(String paydaysName) {
		this.paydaysName = paydaysName;
	}

}