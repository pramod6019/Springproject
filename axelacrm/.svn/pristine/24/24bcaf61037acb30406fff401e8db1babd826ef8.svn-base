package axela.helpdesk.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the axela_helpdesk_ticket_queue database table.
 * 
 */
@Entity
@Table(name = "axela_helpdesk_ticket_queue", catalog = "axela_1")
@NamedQuery(name = "AxelaHelpDeskTicketQueue.findAll", query = "SELECT a FROM AxelaHelpDeskTicketQueue a")
public class AxelaHelpDeskTicketQueue implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticketqueue_id")
	private int ticketqueueId;

	@Column(name = "ticketqueue_business_hrs")
	private String ticketqueueBusinessHrs;

	@Column(name = "ticketqueue_desc")
	private String ticketqueueDesc;

	@Column(name = "ticketqueue_duehrs")
	private double ticketqueueDuehrs;

	@Column(name = "ticketqueue_endtime")
	private double ticketqueueEndtime;

	@Column(name = "ticketqueue_entry_date")
	private Date ticketqueueEntryDate;

	@Column(name = "ticketqueue_entry_id")
	private int ticketqueueEntryId;

	@Column(name = "ticketqueue_fri")
	private String ticketqueueFri;

	@Column(name = "ticketqueue_modified_date")
	private Date ticketqueueModifiedDate;

	@Column(name = "ticketqueue_modified_id")
	private int ticketqueueModifiedId;

	@Column(name = "ticketqueue_mon")
	private String ticketqueueMon;

	@Column(name = "ticketqueue_name")
	private String ticketqueueName;

	@Column(name = "ticketqueue_rank")
	private int ticketqueueRank;

	@Column(name = "ticketqueue_sat")
	private String ticketqueueSat;

	@Column(name = "ticketqueue_starttime")
	private double ticketqueueStarttime;

	@Column(name = "ticketqueue_sun")
	private String ticketqueueSun;

	@Column(name = "ticketqueue_thu")
	private String ticketqueueThu;

	@Column(name = "ticketqueue_trigger1_hrs")
	private double ticketqueueTrigger1Hrs;

	@Column(name = "ticketqueue_trigger2_hrs")
	private double ticketqueueTrigger2Hrs;

	@Column(name = "ticketqueue_trigger3_hrs")
	private double ticketqueueTrigger3Hrs;

	@Column(name = "ticketqueue_trigger4_hrs")
	private double ticketqueueTrigger4Hrs;

	@Column(name = "ticketqueue_trigger5_hrs")
	private double ticketqueueTrigger5Hrs;

	@Column(name = "ticketqueue_tue")
	private String ticketqueueTue;

	@Column(name = "ticketqueue_wed")
	private String ticketqueueWed;
	@Transient
	private long ticketCount;

	public AxelaHelpDeskTicketQueue() {
	}

	public AxelaHelpDeskTicketQueue(Double ticketqueueDuehrs,
			String ticketqueueBusinessHrs,
			Double ticketqueueStarttime,
			Double ticketqueueEndtime,
			String ticketqueueSun,
			String ticketqueueMon,
			String ticketqueueTue,
			String ticketqueueWed,
			String ticketqueueThu,
			String ticketqueueFri,
			String ticketqueueSat,
			Double ticketqueueTrigger1Hrs,
			Double ticketqueueTrigger2Hrs,
			Double ticketqueueTrigger3Hrs,
			Double ticketqueueTrigger4Hrs,
			Double ticketqueueTrigger5Hrs) {

		this.ticketqueueDuehrs = ticketqueueDuehrs;
		this.ticketqueueBusinessHrs = ticketqueueBusinessHrs;
		this.ticketqueueStarttime = ticketqueueStarttime;
		this.ticketqueueEndtime = ticketqueueEndtime;
		this.ticketqueueSun = ticketqueueSun;
		this.ticketqueueMon = ticketqueueMon;
		this.ticketqueueTue = ticketqueueTue;
		this.ticketqueueWed = ticketqueueWed;
		this.ticketqueueThu = ticketqueueThu;
		this.ticketqueueFri = ticketqueueFri;
		this.ticketqueueSat = ticketqueueSat;
		this.ticketqueueTrigger1Hrs = ticketqueueTrigger1Hrs;
		this.ticketqueueTrigger2Hrs = ticketqueueTrigger2Hrs;
		this.ticketqueueTrigger3Hrs = ticketqueueTrigger3Hrs;
		this.ticketqueueTrigger4Hrs = ticketqueueTrigger4Hrs;
		this.ticketqueueTrigger5Hrs = ticketqueueTrigger5Hrs;
	}

	public AxelaHelpDeskTicketQueue(
			int ticketqueueId,
			String ticketqueueName,
			long ticketCount) {

		this.ticketqueueId = ticketqueueId;
		this.ticketqueueName = ticketqueueName;
		this.ticketCount = ticketCount;
	}

	public AxelaHelpDeskTicketQueue(
			int ticketqueueId,
			String ticketqueueDesc,
			String ticketqueueName,
			int ticketqueueRank) {

		this.ticketqueueId = ticketqueueId;
		this.ticketqueueDesc = ticketqueueDesc;
		this.ticketqueueName = ticketqueueName;
		this.ticketqueueRank = ticketqueueRank;
	}

	public AxelaHelpDeskTicketQueue(
			String ticketqueueName,
			String ticketqueueDesc,
			Double ticketqueueDuehrs,
			Double ticketqueueTrigger1Hrs,
			Double ticketqueueTrigger2Hrs,
			Double ticketqueueTrigger3Hrs,
			Double ticketqueueTrigger4Hrs,
			Double ticketqueueTrigger5Hrs,
			String ticketqueueBusinessHrs,
			Double ticketqueueStarttime,
			Double ticketqueueEndtime,
			String ticketqueueSun,
			String ticketqueueMon,
			String ticketqueueTue,
			String ticketqueueWed,
			String ticketqueueThu,
			String ticketqueueFri,
			String ticketqueueSat,
			int ticketqueueEntryId,
			Date ticketqueueEntryDate,
			int ticketqueueModifiedId,
			Date ticketqueueModifiedDate) {
		this.ticketqueueName = ticketqueueName;
		this.ticketqueueDesc = ticketqueueDesc;
		this.ticketqueueDuehrs = ticketqueueDuehrs;
		this.ticketqueueTrigger1Hrs = ticketqueueTrigger1Hrs;
		this.ticketqueueTrigger2Hrs = ticketqueueTrigger2Hrs;
		this.ticketqueueTrigger3Hrs = ticketqueueTrigger3Hrs;
		this.ticketqueueTrigger4Hrs = ticketqueueTrigger4Hrs;
		this.ticketqueueTrigger5Hrs = ticketqueueTrigger5Hrs;
		this.ticketqueueBusinessHrs = ticketqueueBusinessHrs;
		this.ticketqueueStarttime = ticketqueueStarttime;
		this.ticketqueueEndtime = ticketqueueEndtime;
		this.ticketqueueSun = ticketqueueSun;
		this.ticketqueueMon = ticketqueueMon;
		this.ticketqueueTue = ticketqueueTue;
		this.ticketqueueWed = ticketqueueWed;
		this.ticketqueueThu = ticketqueueThu;
		this.ticketqueueFri = ticketqueueFri;
		this.ticketqueueSat = ticketqueueSat;
		this.ticketqueueEntryId = ticketqueueEntryId;
		this.ticketqueueEntryDate = ticketqueueEntryDate;
		this.ticketqueueModifiedId = ticketqueueModifiedId;
		this.ticketqueueModifiedDate = ticketqueueModifiedDate;

	}

	// one-to-many retation to AxelaServiceTicketFaqService
	@OneToMany(mappedBy = "axelaHelpDeskTicketQueue")
	private List<AxelaHelpDeskTicketFaqService> axelaHelpDeskTicketFaqService;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ticketqueue_id", referencedColumnName = "ticket_ticketqueue_id", insertable = false, updatable = false)
	private AxelaHelpDeskTicket axelaHelpDeskTicket;

	public List<AxelaHelpDeskTicketFaqService> getAxelaServiceTicketFaqService() {
		return axelaHelpDeskTicketFaqService;
	}

	public void setAxelaServiceTicketFaqService(List<AxelaHelpDeskTicketFaqService> axelaHelpDeskTicketFaqService) {
		this.axelaHelpDeskTicketFaqService = axelaHelpDeskTicketFaqService;
	}
	public int getTicketqueueId() {
		return this.ticketqueueId;
	}

	public void setTicketqueueId(int ticketqueueId) {
		this.ticketqueueId = ticketqueueId;
	}

	public String getTicketqueueBusinessHrs() {
		return this.ticketqueueBusinessHrs;
	}

	public void setTicketqueueBusinessHrs(String ticketqueueBusinessHrs) {
		this.ticketqueueBusinessHrs = ticketqueueBusinessHrs;
	}

	public String getTicketqueueDesc() {
		return this.ticketqueueDesc;
	}

	public void setTicketqueueDesc(String ticketqueueDesc) {
		this.ticketqueueDesc = ticketqueueDesc;
	}

	public double getTicketqueueDuehrs() {
		return this.ticketqueueDuehrs;
	}

	public void setTicketqueueDuehrs(double ticketqueueDuehrs) {
		this.ticketqueueDuehrs = ticketqueueDuehrs;
	}

	public double getTicketqueueEndtime() {
		return this.ticketqueueEndtime;
	}

	public void setTicketqueueEndtime(double ticketqueueEndtime) {
		this.ticketqueueEndtime = ticketqueueEndtime;
	}

	public Date getTicketqueueEntryDate() {
		return this.ticketqueueEntryDate;
	}

	public void setTicketqueueEntryDate(Date ticketqueueEntryDate) {
		this.ticketqueueEntryDate = ticketqueueEntryDate;
	}

	public int getTicketqueueEntryId() {
		return this.ticketqueueEntryId;
	}

	public void setTicketqueueEntryId(int ticketqueueEntryId) {
		this.ticketqueueEntryId = ticketqueueEntryId;
	}

	public String getTicketqueueFri() {
		return this.ticketqueueFri;
	}

	public void setTicketqueueFri(String ticketqueueFri) {
		this.ticketqueueFri = ticketqueueFri;
	}

	public Date getTicketqueueModifiedDate() {
		return this.ticketqueueModifiedDate;
	}

	public void setTicketqueueModifiedDate(Date ticketqueueModifiedDate) {
		this.ticketqueueModifiedDate = ticketqueueModifiedDate;
	}

	public int getTicketqueueModifiedId() {
		return this.ticketqueueModifiedId;
	}

	public void setTicketqueueModifiedId(int ticketqueueModifiedId) {
		this.ticketqueueModifiedId = ticketqueueModifiedId;
	}

	public String getTicketqueueMon() {
		return this.ticketqueueMon;
	}

	public void setTicketqueueMon(String ticketqueueMon) {
		this.ticketqueueMon = ticketqueueMon;
	}

	public String getTicketqueueName() {
		return this.ticketqueueName;
	}

	public void setTicketqueueName(String ticketqueueName) {
		this.ticketqueueName = ticketqueueName;
	}

	public int getTicketqueueRank() {
		return this.ticketqueueRank;
	}

	public void setTicketqueueRank(int ticketqueueRank) {
		this.ticketqueueRank = ticketqueueRank;
	}

	public String getTicketqueueSat() {
		return this.ticketqueueSat;
	}

	public void setTicketqueueSat(String ticketqueueSat) {
		this.ticketqueueSat = ticketqueueSat;
	}

	public double getTicketqueueStarttime() {
		return this.ticketqueueStarttime;
	}

	public void setTicketqueueStarttime(double ticketqueueStarttime) {
		this.ticketqueueStarttime = ticketqueueStarttime;
	}

	public String getTicketqueueSun() {
		return this.ticketqueueSun;
	}

	public void setTicketqueueSun(String ticketqueueSun) {
		this.ticketqueueSun = ticketqueueSun;
	}

	public String getTicketqueueThu() {
		return this.ticketqueueThu;
	}

	public void setTicketqueueThu(String ticketqueueThu) {
		this.ticketqueueThu = ticketqueueThu;
	}

	public double getTicketqueueTrigger1Hrs() {
		return this.ticketqueueTrigger1Hrs;
	}

	public void setTicketqueueTrigger1Hrs(double ticketqueueTrigger1Hrs) {
		this.ticketqueueTrigger1Hrs = ticketqueueTrigger1Hrs;
	}

	public double getTicketqueueTrigger2Hrs() {
		return this.ticketqueueTrigger2Hrs;
	}

	public void setTicketqueueTrigger2Hrs(double ticketqueueTrigger2Hrs) {
		this.ticketqueueTrigger2Hrs = ticketqueueTrigger2Hrs;
	}

	public double getTicketqueueTrigger3Hrs() {
		return this.ticketqueueTrigger3Hrs;
	}

	public void setTicketqueueTrigger3Hrs(double ticketqueueTrigger3Hrs) {
		this.ticketqueueTrigger3Hrs = ticketqueueTrigger3Hrs;
	}

	public double getTicketqueueTrigger4Hrs() {
		return this.ticketqueueTrigger4Hrs;
	}

	public void setTicketqueueTrigger4Hrs(double ticketqueueTrigger4Hrs) {
		this.ticketqueueTrigger4Hrs = ticketqueueTrigger4Hrs;
	}

	public double getTicketqueueTrigger5Hrs() {
		return this.ticketqueueTrigger5Hrs;
	}

	public void setTicketqueueTrigger5Hrs(double ticketqueueTrigger5Hrs) {
		this.ticketqueueTrigger5Hrs = ticketqueueTrigger5Hrs;
	}

	public String getTicketqueueTue() {
		return this.ticketqueueTue;
	}

	public void setTicketqueueTue(String ticketqueueTue) {
		this.ticketqueueTue = ticketqueueTue;
	}

	public String getTicketqueueWed() {
		return this.ticketqueueWed;
	}

	public void setTicketqueueWed(String ticketqueueWed) {
		this.ticketqueueWed = ticketqueueWed;
	}

	public long getTicketCount() {
		return ticketCount;
	}

	public void setTicketCount(long ticketCount) {
		this.ticketCount = ticketCount;
	}

}