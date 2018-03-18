package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_emp_att database table.
 * 
 */
@Entity
@Table(name = "axela_emp_att", catalog = "axela_1")
@NamedQuery(name = "AxelaEmpAtt.findAll", query = "SELECT a FROM AxelaEmpAtt a")
public class AxelaEmpAtt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "att_id")
	private int attId;

	@Column(name = "att_day")
	private String attDay;

	@Column(name = "att_emp_id")
	private int attEmpId;

	@Column(name = "att_entry_date")
	private String attEntryDate;

	@Column(name = "att_entry_id")
	private int attEntryId;

	@Column(name = "att_status_id")
	private int attStatusId;

	public AxelaEmpAtt() {
	}

	public int getAttId() {
		return this.attId;
	}

	public void setAttId(int attId) {
		this.attId = attId;
	}

	public String getAttDay() {
		return this.attDay;
	}

	public void setAttDay(String attDay) {
		this.attDay = attDay;
	}

	public int getAttEmpId() {
		return this.attEmpId;
	}

	public void setAttEmpId(int attEmpId) {
		this.attEmpId = attEmpId;
	}

	public String getAttEntryDate() {
		return this.attEntryDate;
	}

	public void setAttEntryDate(String attEntryDate) {
		this.attEntryDate = attEntryDate;
	}

	public int getAttEntryId() {
		return this.attEntryId;
	}

	public void setAttEntryId(int attEntryId) {
		this.attEntryId = attEntryId;
	}

	public int getAttStatusId() {
		return this.attStatusId;
	}

	public void setAttStatusId(int attStatusId) {
		this.attStatusId = attStatusId;
	}

}