package axela.sales.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Transient;

/**
 * The persistent class for the axela_sales_target_model database table.
 * 
 */
@Entity
@Table(name = "axela_sales_target_model", catalog = "axela_1")
@NamedQuery(name = "AxelaSalesTargetModel.findAll", query = "SELECT a FROM AxelaSalesTargetModel a")
public class AxelaSalesTargetModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Transient
	private Date targetStartdate;

	@Transient
	private Date targetEnddate;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "modeltarget_id")
	private int modeltargetId;

	@Column(name = "modeltarget_model_id")
	private int modeltargetModelId;

	@Column(name = "modeltarget_oppr_calls_count")
	private int modeltargetOpprCallsCount;

	@Column(name = "modeltarget_oppr_count")
	private int modeltargetOpprCount;

	@Column(name = "modeltarget_oppr_demos_count")
	private int modeltargetOpprDemosCount;

	@Column(name = "modeltarget_oppr_hot_count")
	private int modeltargetOpprHotCount;

	@Column(name = "modeltarget_oppr_meetings_count")
	private int modeltargetOpprMeetingsCount;

	@Column(name = "modeltarget_so_amount")
	private double modeltargetSoAmount;

	@Column(name = "modeltarget_so_count")
	private int modeltargetSoCount;

	@Column(name = "modeltarget_target_id")
	private int modeltargetTargetId;

	public AxelaSalesTargetModel() {
	}

	public AxelaSalesTargetModel(int modeltargetTargetId,
			int modeltargetModelId,
			Date targetStartdate,
			Date targetEnddate,
			int modeltargetOpprCount,
			int modeltargetOpprCallsCount,
			int modeltargetOpprMeetingsCount,
			int modeltargetOpprDemosCount,
			int modeltargetOpprHotCount,
			int modeltargetSoCount,
			double modeltargetSoAmount) {
		this.modeltargetTargetId = modeltargetTargetId;
		this.modeltargetModelId = modeltargetModelId;
		this.targetStartdate = targetStartdate;
		this.targetEnddate = targetEnddate;
		this.modeltargetOpprCount = modeltargetOpprCount;
		this.modeltargetOpprCallsCount = modeltargetOpprCallsCount;
		this.modeltargetOpprMeetingsCount = modeltargetOpprMeetingsCount;
		this.modeltargetOpprDemosCount = modeltargetOpprDemosCount;
		this.modeltargetOpprHotCount = modeltargetOpprHotCount;
		this.modeltargetSoCount = modeltargetSoCount;
		this.modeltargetSoAmount = modeltargetSoAmount;
	}

	public int getModeltargetId() {
		return this.modeltargetId;
	}

	public void setModeltargetId(int modeltargetId) {
		this.modeltargetId = modeltargetId;
	}

	public int getModeltargetModelId() {
		return this.modeltargetModelId;
	}

	public void setModeltargetModelId(int modeltargetModelId) {
		this.modeltargetModelId = modeltargetModelId;
	}

	public int getModeltargetOpprCallsCount() {
		return this.modeltargetOpprCallsCount;
	}

	public void setModeltargetOpprCallsCount(int modeltargetOpprCallsCount) {
		this.modeltargetOpprCallsCount = modeltargetOpprCallsCount;
	}

	public int getModeltargetOpprCount() {
		return this.modeltargetOpprCount;
	}

	public void setModeltargetOpprCount(int modeltargetOpprCount) {
		this.modeltargetOpprCount = modeltargetOpprCount;
	}

	public int getModeltargetOpprDemosCount() {
		return this.modeltargetOpprDemosCount;
	}

	public void setModeltargetOpprDemosCount(int modeltargetOpprDemosCount) {
		this.modeltargetOpprDemosCount = modeltargetOpprDemosCount;
	}

	public int getModeltargetOpprHotCount() {
		return this.modeltargetOpprHotCount;
	}

	public void setModeltargetOpprHotCount(int modeltargetOpprHotCount) {
		this.modeltargetOpprHotCount = modeltargetOpprHotCount;
	}

	public int getModeltargetOpprMeetingsCount() {
		return this.modeltargetOpprMeetingsCount;
	}

	public void setModeltargetOpprMeetingsCount(int modeltargetOpprMeetingsCount) {
		this.modeltargetOpprMeetingsCount = modeltargetOpprMeetingsCount;
	}

	public double getModeltargetSoAmount() {
		return this.modeltargetSoAmount;
	}

	public void setModeltargetSoAmount(double modeltargetSoAmount) {
		this.modeltargetSoAmount = modeltargetSoAmount;
	}

	public int getModeltargetSoCount() {
		return this.modeltargetSoCount;
	}

	public Date getTargetStartdate() {
		return targetStartdate;
	}

	public void setTargetStartdate(Date targetStartdate) {
		this.targetStartdate = targetStartdate;
	}

	public Date getTargetEnddate() {
		return targetEnddate;
	}

	public void setTargetEnddate(Date targetEnddate) {
		this.targetEnddate = targetEnddate;
	}

	public void setModeltargetSoCount(int modeltargetSoCount) {
		this.modeltargetSoCount = modeltargetSoCount;
	}

	public int getModeltargetTargetId() {
		return this.modeltargetTargetId;
	}

	public void setModeltargetTargetId(int modeltargetTargetId) {
		this.modeltargetTargetId = modeltargetTargetId;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modeltarget_target_id", referencedColumnName = "target_id", insertable = false, updatable = false)
	private AxelaSalesTarget axelaSalesTarget;

}