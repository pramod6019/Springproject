package axela.sales.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_sales_target database table.
 * 
 */
@Entity
@Table(name = "axela_sales_target", catalog = "axela_1")
@NamedQuery(name = "AxelaSalesTarget.findAll", query = "SELECT a FROM AxelaSalesTarget a")
public class AxelaSalesTarget implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "target_id")
	private int targetId;

	@Column(name = "target_emp_id")
	private int targetEmpId;

	@Column(name = "target_enddate")
	private Date targetEnddate;

	@Column(name = "target_entry_date")
	private Date targetEntryDate;

	@Column(name = "target_entry_id")
	private int targetEntryId;

	@Column(name = "target_modified_date")
	private Date targetModifiedDate;

	@Column(name = "target_modified_id")
	private int targetModifiedId;

	@Column(name = "target_oppr_calls_count")
	private int targetOpprCallsCount;

	@Column(name = "target_oppr_count")
	private int targetOpprCount;

	@Column(name = "target_oppr_demos_count")
	private int targetOpprDemosCount;

	@Column(name = "target_oppr_hot_count")
	private int targetOpprHotCount;

	@Column(name = "target_oppr_meetings_count")
	private int targetOpprMeetingsCount;

	@Column(name = "target_so_amount")
	private double targetSoAmount;

	public AxelaSalesTarget(int targetId) {
		this.targetId = targetId;

	}
	public AxelaSalesTarget(int targetId,
			Date targetStartdate,
			Date targetEnddate,
			int targetOpprCount,
			int targetOpprCallsCount,
			int targetOpprMeetingsCount,
			int targetOpprDemosCount,
			int targetOpprHotCount,
			int targetSoCount,
			double targetSoAmount) {

		super();
		this.targetId = targetId;
		this.targetStartdate = targetStartdate;
		this.targetEnddate = targetEnddate;
		this.targetOpprCount = targetOpprCount;
		this.targetOpprCallsCount = targetOpprCallsCount;
		this.targetOpprMeetingsCount = targetOpprMeetingsCount;
		this.targetOpprDemosCount = targetOpprDemosCount;
		this.targetOpprHotCount = targetOpprHotCount;
		this.targetSoCount = targetSoCount;
		this.targetSoAmount = targetSoAmount;

	}

	@Column(name = "target_so_count")
	private int targetSoCount;

	@Column(name = "target_startdate")
	private Date targetStartdate;

	public AxelaSalesTarget() {
	}

	public int getTargetId() {
		return this.targetId;
	}

	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}

	public int getTargetEmpId() {
		return this.targetEmpId;
	}

	public void setTargetEmpId(int targetEmpId) {
		this.targetEmpId = targetEmpId;
	}

	public Date getTargetEnddate() {
		return this.targetEnddate;
	}

	public void setTargetEnddate(Date targetEnddate) {
		this.targetEnddate = targetEnddate;
	}

	public Date getTargetEntryDate() {
		return this.targetEntryDate;
	}

	public void setTargetEntryDate(Date targetEntryDate) {
		this.targetEntryDate = targetEntryDate;
	}

	public int getTargetEntryId() {
		return this.targetEntryId;
	}

	public void setTargetEntryId(int targetEntryId) {
		this.targetEntryId = targetEntryId;
	}

	public Date getTargetModifiedDate() {
		return this.targetModifiedDate;
	}

	public void setTargetModifiedDate(Date targetModifiedDate) {
		this.targetModifiedDate = targetModifiedDate;
	}

	public int getTargetModifiedId() {
		return this.targetModifiedId;
	}

	public void setTargetModifiedId(int targetModifiedId) {
		this.targetModifiedId = targetModifiedId;
	}

	public int getTargetOpprCallsCount() {
		return this.targetOpprCallsCount;
	}

	public void setTargetOpprCallsCount(int targetOpprCallsCount) {
		this.targetOpprCallsCount = targetOpprCallsCount;
	}

	public int getTargetOpprCount() {
		return this.targetOpprCount;
	}

	public void setTargetOpprCount(int targetOpprCount) {
		this.targetOpprCount = targetOpprCount;
	}

	public int getTargetOpprDemosCount() {
		return this.targetOpprDemosCount;
	}

	public void setTargetOpprDemosCount(int targetOpprDemosCount) {
		this.targetOpprDemosCount = targetOpprDemosCount;
	}

	public int getTargetOpprHotCount() {
		return this.targetOpprHotCount;
	}

	public void setTargetOpprHotCount(int targetOpprHotCount) {
		this.targetOpprHotCount = targetOpprHotCount;
	}

	public int getTargetOpprMeetingsCount() {
		return this.targetOpprMeetingsCount;
	}

	public void setTargetOpprMeetingsCount(int targetOpprMeetingsCount) {
		this.targetOpprMeetingsCount = targetOpprMeetingsCount;
	}

	public double getTargetSoAmount() {
		return this.targetSoAmount;
	}

	public void setTargetSoAmount(double targetSoAmount) {
		this.targetSoAmount = targetSoAmount;
	}

	public int getTargetSoCount() {
		return this.targetSoCount;
	}

	public void setTargetSoCount(int targetSoCount) {
		this.targetSoCount = targetSoCount;
	}

	public Date getTargetStartdate() {
		return this.targetStartdate;
	}

	public void setTargetStartdate(Date targetStartdate) {
		this.targetStartdate = targetStartdate;
	}

}