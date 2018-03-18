package axela.portal.model;

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
 * The persistent class for the axela_activity_type database table.
 * 
 */
@Entity
@Table(name = "axela_activity_type", catalog = "axela_1")
@NamedQuery(name = "AxelaActivityType.findAll", query = "SELECT a FROM AxelaActivityType a")
public class AxelaActivityType implements Serializable {
	private static final long serialVersionUID = 1L;
	public AxelaActivityType(
			int activitytypeId,
			String activitytypeDesc,
			String activitytypeName,
			int activitytypeRank) {
		super();
		this.activitytypeId = activitytypeId;
		this.activitytypeDesc = activitytypeDesc;
		this.activitytypeName = activitytypeName;
		this.activitytypeRank = activitytypeRank;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "activitytype_id")
	private int activitytypeId;

	@Column(name = "activitytype_desc")
	private String activitytypeDesc;

	@Column(name = "activitytype_duehrs")
	private String activitytypeDuehrs;

	@Column(name = "activitytype_entry_date")
	private Date activitytypeEntryDate;

	@Column(name = "activitytype_entry_id")
	private int activitytypeEntryId;

	@Column(name = "activitytype_modified_date")
	private Date activitytypeModifiedDate;

	@Column(name = "activitytype_modified_id")
	private int activitytypeModifiedId;

	@Column(name = "activitytype_name")
	private String activitytypeName;

	@Column(name = "activitytype_rank")
	private int activitytypeRank;

	@Column(name = "activitytype_trigger1_hrs")
	private String activitytypeTrigger1Hrs;

	@Column(name = "activitytype_trigger2_hrs")
	private String activitytypeTrigger2Hrs;

	@Column(name = "activitytype_trigger3_hrs")
	private String activitytypeTrigger3Hrs;

	@Column(name = "activitytype_trigger4_hrs")
	private String activitytypeTrigger4Hrs;

	@Column(name = "activitytype_trigger5_hrs")
	private String activitytypeTrigger5Hrs;

	public AxelaActivityType() {
	}

	public int getActivitytypeId() {
		return activitytypeId;
	}

	public void setActivitytypeId(int activitytypeId) {
		this.activitytypeId = activitytypeId;
	}

	public String getActivitytypeDesc() {
		return activitytypeDesc;
	}

	public void setActivitytypeDesc(String activitytypeDesc) {
		this.activitytypeDesc = activitytypeDesc;
	}

	public String getActivitytypeDuehrs() {
		return activitytypeDuehrs;
	}

	public void setActivitytypeDuehrs(String activitytypeDuehrs) {
		this.activitytypeDuehrs = activitytypeDuehrs;
	}

	public Date getActivitytypeEntryDate() {
		return activitytypeEntryDate;
	}

	public void setActivitytypeEntryDate(Date activitytypeEntryDate) {
		this.activitytypeEntryDate = activitytypeEntryDate;
	}

	public int getActivitytypeEntryId() {
		return activitytypeEntryId;
	}

	public void setActivitytypeEntryId(int activitytypeEntryId) {
		this.activitytypeEntryId = activitytypeEntryId;
	}

	public Date getActivitytypeModifiedDate() {
		return activitytypeModifiedDate;
	}

	public void setActivitytypeModifiedDate(Date activitytypeModifiedDate) {
		this.activitytypeModifiedDate = activitytypeModifiedDate;
	}

	public int getActivitytypeModifiedId() {
		return activitytypeModifiedId;
	}

	public void setActivitytypeModifiedId(int activitytypeModifiedId) {
		this.activitytypeModifiedId = activitytypeModifiedId;
	}

	public String getActivitytypeName() {
		return activitytypeName;
	}

	public void setActivitytypeName(String activitytypeName) {
		this.activitytypeName = activitytypeName;
	}

	public int getActivitytypeRank() {
		return activitytypeRank;
	}

	public void setActivitytypeRank(int activitytypeRank) {
		this.activitytypeRank = activitytypeRank;
	}

	public String getActivitytypeTrigger1Hrs() {
		return activitytypeTrigger1Hrs;
	}

	public void setActivitytypeTrigger1Hrs(String activitytypeTrigger1Hrs) {
		this.activitytypeTrigger1Hrs = activitytypeTrigger1Hrs;
	}

	public String getActivitytypeTrigger2Hrs() {
		return activitytypeTrigger2Hrs;
	}

	public void setActivitytypeTrigger2Hrs(String activitytypeTrigger2Hrs) {
		this.activitytypeTrigger2Hrs = activitytypeTrigger2Hrs;
	}

	public String getActivitytypeTrigger3Hrs() {
		return activitytypeTrigger3Hrs;
	}

	public void setActivitytypeTrigger3Hrs(String activitytypeTrigger3Hrs) {
		this.activitytypeTrigger3Hrs = activitytypeTrigger3Hrs;
	}

	public String getActivitytypeTrigger4Hrs() {
		return activitytypeTrigger4Hrs;
	}

	public void setActivitytypeTrigger4Hrs(String activitytypeTrigger4Hrs) {
		this.activitytypeTrigger4Hrs = activitytypeTrigger4Hrs;
	}

	public String getActivitytypeTrigger5Hrs() {
		return activitytypeTrigger5Hrs;
	}

	public void setActivitytypeTrigger5Hrs(String activitytypeTrigger5Hrs) {
		this.activitytypeTrigger5Hrs = activitytypeTrigger5Hrs;
	}

}