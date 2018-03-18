package axela.activities.model;

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

import axela.customer.model.AxelaCustomer;
import axela.customer.model.AxelaCustomerContact;
import axela.portal.model.AxelaActivityStatus;
import axela.portal.model.AxelaActivityType;
import axela.portal.model.AxelaEmp;
import axela.sales.model.AxelaSalesOpprFollowup;

/**
 * The persistent class for the axela_activity database table.
 * 
 */
@Entity
@Table(name = "axela_activity", catalog = AxelaCustomer.comp_db)
@NamedQuery(name = "AxelaActivity.findAll", query = "SELECT a FROM AxelaActivity a")
public class AxelaActivity implements Serializable {
	public static final String comp_db = "axela_1";
	private static final long serialVersionUID = 1L;

	@Transient
	private int empId;
	@Transient
	private String empName;
	@Transient
	private String empRefNo;
	@Transient
	private Date startTime;

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getContactMobile1() {
		return contactMobile1;
	}

	public void setContactMobile1(String contactMobile1) {
		this.contactMobile1 = contactMobile1;
	}

	@Transient
	private String priorityName;
	@Transient
	private String activitytypeName;
	@Transient
	private String statusDesc;
	@Transient
	private int contactId;
	@Transient
	private String titleDesc;
	@Transient
	private String contactFname;
	@Transient
	private String contactLname;

	@Transient
	private Date endTime;
	@Transient
	private String title;
	@Transient
	private String description;
	@Transient
	private String type;
	@Transient
	private String feedback;
	@Transient
	private String contactMobile1;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "activity_id")
	private int activityId;

	@Column(name = "activity_activitytype_id")
	private int activityActivitytypeId;

	@Column(name = "activity_contact_id")
	private int activityContactId;

	@Column(name = "activity_contact_person")
	private String activityContactPerson;

	@Column(name = "activity_desc")
	private String activityDesc;

	@Column(name = "activity_emp_id")
	private int activityEmpId;

	@Column(name = "activity_end_datetime")
	private Date activityEndDatetime;

	@Column(name = "activity_entry_datetime")
	private Date activityEntryDatetime;

	@Column(name = "activity_entry_id")
	private int activityEntryId;

	@Column(name = "activity_feedback")
	private String activityFeedback;

	@Column(name = "activity_feedback_entry_datetime")
	private Date activityFeedbackEntryDatetime;

	@Column(name = "activity_feedback_entry_id")
	private int activityFeedbackEntryId;

	@Column(name = "activity_modified_datetime")
	private Date activityModifiedDatetime;

	@Column(name = "activity_modified_id")
	private int activityModifiedId;

	@Column(name = "activity_phone1")
	private String activityPhone1;

	@Column(name = "activity_phone2")
	private String activityPhone2;

	@Column(name = "activity_priority_id")
	private int activityPriorityId;

	@Column(name = "activity_remarks")
	private String activityRemarks;

	@Column(name = "activity_remarks_entry_datetime")
	private Date activityRemarksEntryDatetime;

	@Column(name = "activity_remarks_entry_id")
	private int activityRemarksEntryId;

	@Column(name = "activity_reminder")
	private String activityReminder;

	@Column(name = "activity_reminder_set")
	private String activityReminderSet;

	@Column(name = "activity_start_datetime")
	private Date activityStartDatetime;

	@Column(name = "activity_status_id")
	private int activityStatusId;

	@Column(name = "activity_title")
	private String activityTitle;

	@Column(name = "activity_trigger")
	private int activityTrigger;

	@Column(name = "activity_venue")
	private String activityVenue;

	public AxelaActivity() {
	}

	public AxelaActivity(

			int activityId,
			int activityEmpId,
			int activityContactId,
			String activityTitle,
			Date activityStartDatetime,
			Date activityEndDatetime,
			String activityContactPerson,
			String activityPhone1,
			String activityPhone2,
			String activityVenue,
			String activityRemarks,
			String activityDesc,
			Date activityEntryDatetime,
			Date activityModifiedDatetime,
			int activityFeedbackEntryId,
			Date activityFeedbackEntryDatetime,
			int activityRemarksEntryId,
			Date activityRemarksEntryDatetime,
			String priorityName,
			String activitytypeName,
			String statusDesc,
			int contactId,
			String titleDesc,
			String contactFname,
			String contactLname,
			String activityFeedback,
			int empId,
			String empName,
			String empRefNo)
	{
		this.activityId = activityId;
		this.activityEmpId = activityEmpId;
		this.activityContactId = activityContactId;
		this.activityTitle = activityTitle;
		this.activityStartDatetime = activityStartDatetime;
		this.activityEndDatetime = activityEndDatetime;
		this.activityContactPerson = activityContactPerson;
		this.activityPhone1 = activityPhone1;
		this.activityPhone2 = activityPhone2;
		this.activityVenue = activityVenue;
		this.activityRemarks = activityRemarks;
		this.activityDesc = activityDesc;
		this.activityEntryDatetime = activityEntryDatetime;
		this.activityModifiedDatetime = activityModifiedDatetime;
		this.activityFeedbackEntryId = activityFeedbackEntryId;
		this.activityFeedbackEntryDatetime = activityFeedbackEntryDatetime;
		this.activityRemarksEntryId = activityRemarksEntryId;
		this.activityRemarksEntryDatetime = activityRemarksEntryDatetime;
		this.priorityName = priorityName;
		this.activitytypeName = activitytypeName;
		this.statusDesc = statusDesc;
		this.contactId = contactId;
		this.titleDesc = titleDesc;
		this.contactFname = contactFname;
		this.contactLname = contactLname;
		this.activityFeedback = activityFeedback;
		this.empId = empId;
		this.empName = empName;
		this.empRefNo = empRefNo;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpRefNo() {
		return empRefNo;
	}

	public void setEmpRefNo(String empRefNo) {
		this.empRefNo = empRefNo;
	}

	public String getPriorityName() {
		return priorityName;
	}

	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}

	public String getActivitytypeName() {
		return activitytypeName;
	}

	public void setActivitytypeName(String activitytypeName) {
		this.activitytypeName = activitytypeName;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getTitleDesc() {
		return titleDesc;
	}

	public void setTitleDesc(String titleDesc) {
		this.titleDesc = titleDesc;
	}

	public String getContactFname() {
		return contactFname;
	}

	public void setContactFname(String contactFname) {
		this.contactFname = contactFname;
	}

	public String getContactLname() {
		return contactLname;
	}

	public void setContactLname(String contactLname) {
		this.contactLname = contactLname;
	}

	public int getActivityId() {
		return this.activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public int getActivityActivitytypeId() {
		return this.activityActivitytypeId;
	}

	public void setActivityActivitytypeId(int activityActivitytypeId) {
		this.activityActivitytypeId = activityActivitytypeId;
	}

	public int getActivityContactId() {
		return this.activityContactId;
	}

	public void setActivityContactId(int activityContactId) {
		this.activityContactId = activityContactId;
	}

	public String getActivityContactPerson() {
		return this.activityContactPerson;
	}

	public void setActivityContactPerson(String activityContactPerson) {
		this.activityContactPerson = activityContactPerson;
	}

	public String getActivityDesc() {
		return this.activityDesc;
	}

	public void setActivityDesc(String activityDesc) {
		this.activityDesc = activityDesc;
	}

	public int getActivityEmpId() {
		return this.activityEmpId;
	}

	public void setActivityEmpId(int activityEmpId) {
		this.activityEmpId = activityEmpId;
	}

	public Date getActivityEndDatetime() {
		return this.activityEndDatetime;
	}

	public void setActivityEndDatetime(Date activityEndDatetime) {
		this.activityEndDatetime = activityEndDatetime;
	}

	public Date getActivityEntryDatetime() {
		return this.activityEntryDatetime;
	}

	public void setActivityEntryDatetime(Date activityEntryDatetime) {
		this.activityEntryDatetime = activityEntryDatetime;
	}

	public int getActivityEntryId() {
		return this.activityEntryId;
	}

	public void setActivityEntryId(int activityEntryId) {
		this.activityEntryId = activityEntryId;
	}

	public String getActivityFeedback() {
		return this.activityFeedback;
	}

	public void setActivityFeedback(String activityFeedback) {
		this.activityFeedback = activityFeedback;
	}

	public Date getActivityFeedbackEntryDatetime() {
		return this.activityFeedbackEntryDatetime;
	}

	public void setActivityFeedbackEntryDatetime(Date activityFeedbackEntryDatetime) {
		this.activityFeedbackEntryDatetime = activityFeedbackEntryDatetime;
	}

	public int getActivityFeedbackEntryId() {
		return this.activityFeedbackEntryId;
	}

	public void setActivityFeedbackEntryId(int activityFeedbackEntryId) {
		this.activityFeedbackEntryId = activityFeedbackEntryId;
	}

	public Date getActivityModifiedDatetime() {
		return this.activityModifiedDatetime;
	}

	public void setActivityModifiedDatetime(Date activityModifiedDatetime) {
		this.activityModifiedDatetime = activityModifiedDatetime;
	}

	public int getActivityModifiedId() {
		return this.activityModifiedId;
	}

	public void setActivityModifiedId(int activityModifiedId) {
		this.activityModifiedId = activityModifiedId;
	}

	public String getActivityPhone1() {
		return this.activityPhone1;
	}

	public void setActivityPhone1(String activityPhone1) {
		this.activityPhone1 = activityPhone1;
	}

	public String getActivityPhone2() {
		return this.activityPhone2;
	}

	public void setActivityPhone2(String activityPhone2) {
		this.activityPhone2 = activityPhone2;
	}

	public int getActivityPriorityId() {
		return this.activityPriorityId;
	}

	public void setActivityPriorityId(int activityPriorityId) {
		this.activityPriorityId = activityPriorityId;
	}

	public String getActivityRemarks() {
		return this.activityRemarks;
	}

	public void setActivityRemarks(String activityRemarks) {
		this.activityRemarks = activityRemarks;
	}

	public Date getActivityRemarksEntryDatetime() {
		return this.activityRemarksEntryDatetime;
	}

	public void setActivityRemarksEntryDatetime(Date activityRemarksEntryDatetime) {
		this.activityRemarksEntryDatetime = activityRemarksEntryDatetime;
	}

	public int getActivityRemarksEntryId() {
		return this.activityRemarksEntryId;
	}

	public void setActivityRemarksEntryId(int activityRemarksEntryId) {
		this.activityRemarksEntryId = activityRemarksEntryId;
	}

	public String getActivityReminder() {
		return this.activityReminder;
	}

	public void setActivityReminder(String activityReminder) {
		this.activityReminder = activityReminder;
	}

	public String getActivityReminderSet() {
		return this.activityReminderSet;
	}

	public void setActivityReminderSet(String activityReminderSet) {
		this.activityReminderSet = activityReminderSet;
	}

	public Date getActivityStartDatetime() {
		return this.activityStartDatetime;
	}

	public void setActivityStartDatetime(Date activityStartDatetime) {
		this.activityStartDatetime = activityStartDatetime;
	}

	public int getActivityStatusId() {
		return this.activityStatusId;
	}

	public void setActivityStatusId(int activityStatusId) {
		this.activityStatusId = activityStatusId;
	}

	public String getActivityTitle() {
		return this.activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}

	public int getActivityTrigger() {
		return this.activityTrigger;
	}

	public void setActivityTrigger(int activityTrigger) {
		this.activityTrigger = activityTrigger;
	}

	public String getActivityVenue() {
		return this.activityVenue;
	}

	public void setActivityVenue(String activityVenue) {
		this.activityVenue = activityVenue;
	}

	@Transient
	private AxelaSalesOpprFollowup axelaSalesOpprFollowup;

	public AxelaSalesOpprFollowup getAxelaSalesOpprFollowup() {
		return axelaSalesOpprFollowup;
	}

	public void setAxelaSalesOpprFollowup(AxelaSalesOpprFollowup axelaSalesOpprFollowup) {
		this.axelaSalesOpprFollowup = axelaSalesOpprFollowup;
	}

	// activity
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "activity_activitytype_id", referencedColumnName = "activitytype_id", insertable = false, updatable = false)
	private AxelaActivityType axelaActivityType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "activity_emp_id", referencedColumnName = "emp_id", insertable = false, updatable = false)
	private AxelaEmp axelaEmp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "activity_priority_id", referencedColumnName = "priority_id", insertable = false, updatable = false)
	private AxelaActivityPriority axelaActivityPriority;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "activity_status_id", referencedColumnName = "status_id", insertable = false, updatable = false)
	private AxelaActivityStatus axelaActivityStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "activity_contact_id", referencedColumnName = "contact_id", insertable = false, updatable = false)
	private AxelaCustomerContact axelaCustomerContact;

	public AxelaActivityType getAxelaActivityType() {
		return axelaActivityType;
	}

	public void setAxelaActivityType(AxelaActivityType axelaActivityType) {
		this.axelaActivityType = axelaActivityType;
	}

	public AxelaEmp getAxelaEmp() {
		return axelaEmp;
	}

	public void setAxelaEmp(AxelaEmp axelaEmp) {
		this.axelaEmp = axelaEmp;
	}

	public AxelaActivityPriority getAxelaActivityPriority() {
		return axelaActivityPriority;
	}

	public void setAxelaActivityPriority(AxelaActivityPriority axelaActivityPriority) {
		this.axelaActivityPriority = axelaActivityPriority;
	}

	public AxelaActivityStatus getAxelaActivityStatus() {
		return axelaActivityStatus;
	}

	public void setAxelaActivityStatus(AxelaActivityStatus axelaActivityStatus) {
		this.axelaActivityStatus = axelaActivityStatus;
	}

	public AxelaCustomerContact getAxelaCustomerContact() {
		return axelaCustomerContact;
	}

	public void setAxelaCustomerContact(AxelaCustomerContact axelaCustomerContact) {
		this.axelaCustomerContact = axelaCustomerContact;
	}

	public AxelaActivity(Date startTime,
			Date endTime,
			String title,
			String description,
			int activityId,
			String type,
			String feedback,
			String contactMobile1) {
		super();

		this.startTime = startTime;
		this.endTime = endTime;
		this.title = title;
		this.description = description;
		this.activityId = activityId;
		this.type = type;
		this.feedback = feedback;
		this.contactMobile1 = contactMobile1;
	}
}