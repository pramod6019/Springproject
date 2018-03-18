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
 * The persistent class for the axela_bill_counter database table.
 * 
 */
@Entity
@Table(name = "axela_bill_counter", catalog = "axela_1")
@NamedQuery(name = "AxelaBillCounter.findAll", query = "SELECT a FROM AxelaBillCounter a")
public class AxelaBillCounter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "counter_id")
	private int counterId;

	@Column(name = "counter_branch_id")
	private int counterBranchId;

	@Column(name = "counter_entry_date")
	private String counterEntryDate;

	@Column(name = "counter_entry_id")
	private int counterEntryId;

	@Column(name = "counter_modified_date")
	private String counterModifiedDate;

	@Column(name = "counter_modified_id")
	private int counterModifiedId;

	@Column(name = "counter_name")
	private String counterName;

	public AxelaBillCounter() {
	}

	public int getCounterId() {
		return this.counterId;
	}

	public void setCounterId(int counterId) {
		this.counterId = counterId;
	}

	public int getCounterBranchId() {
		return this.counterBranchId;
	}

	public void setCounterBranchId(int counterBranchId) {
		this.counterBranchId = counterBranchId;
	}

	public String getCounterEntryDate() {
		return this.counterEntryDate;
	}

	public void setCounterEntryDate(String counterEntryDate) {
		this.counterEntryDate = counterEntryDate;
	}

	public int getCounterEntryId() {
		return this.counterEntryId;
	}

	public void setCounterEntryId(int counterEntryId) {
		this.counterEntryId = counterEntryId;
	}

	public String getCounterModifiedDate() {
		return this.counterModifiedDate;
	}

	public void setCounterModifiedDate(String counterModifiedDate) {
		this.counterModifiedDate = counterModifiedDate;
	}

	public int getCounterModifiedId() {
		return this.counterModifiedId;
	}

	public void setCounterModifiedId(int counterModifiedId) {
		this.counterModifiedId = counterModifiedId;
	}

	public String getCounterName() {
		return this.counterName;
	}

	public void setCounterName(String counterName) {
		this.counterName = counterName;
	}

}