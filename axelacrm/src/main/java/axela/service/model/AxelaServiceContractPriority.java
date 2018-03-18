package axela.service.model;

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
 * The persistent class for the axela_service_contract_priority database table.
 * 
 */
@Entity
@Table(name = "axela_service_contract_priority", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceContractPriority.findAll", query = "SELECT a FROM AxelaServiceContractPriority a")
public class AxelaServiceContractPriority implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contractpriority_id")
	private int contractpriorityId;

	@Column(name = "contractpriority_business_hrs")
	private String contractpriorityBusinessHrs;

	@Column(name = "contractpriority_desc")
	private String contractpriorityDesc;

	@Column(name = "contractpriority_duehrs")
	private String contractpriorityDuehrs;

	@Column(name = "contractpriority_endtime")
	private double contractpriorityEndtime;

	@Column(name = "contractpriority_entry_date")
	private Date contractpriorityEntryDate;

	@Column(name = "contractpriority_entry_id")
	private int contractpriorityEntryId;

	@Column(name = "contractpriority_fri")
	private String contractpriorityFri;

	@Column(name = "contractpriority_modified_date")
	private Date contractpriorityModifiedDate;

	@Column(name = "contractpriority_modified_id")
	private int contractpriorityModifiedId;

	@Column(name = "contractpriority_mon")
	private String contractpriorityMon;

	@Column(name = "contractpriority_name")
	private String contractpriorityName;

	@Column(name = "contractpriority_rank")
	private int contractpriorityRank;

	@Column(name = "contractpriority_sat")
	private String contractprioritySat;

	@Column(name = "contractpriority_starttime")
	private double contractpriorityStarttime;

	@Column(name = "contractpriority_sun")
	private String contractprioritySun;

	@Column(name = "contractpriority_thu")
	private String contractpriorityThu;

	@Column(name = "contractpriority_trigger1_hrs")
	private String contractpriorityTrigger1Hrs;

	@Column(name = "contractpriority_trigger2_hrs")
	private String contractpriorityTrigger2Hrs;

	@Column(name = "contractpriority_trigger3_hrs")
	private String contractpriorityTrigger3Hrs;

	@Column(name = "contractpriority_trigger4_hrs")
	private String contractpriorityTrigger4Hrs;

	@Column(name = "contractpriority_trigger5_hrs")
	private String contractpriorityTrigger5Hrs;

	@Column(name = "contractpriority_tue")
	private String contractpriorityTue;

	@Column(name = "contractpriority_wed")
	private String contractpriorityWed;

	public AxelaServiceContractPriority() {
	}

	public AxelaServiceContractPriority(
			int contractpriorityId,
			String contractpriorityBusinessHrs,
			String contractpriorityDesc,
			String contractpriorityDuehrs,
			Date contractpriorityEntryDate,
			int contractpriorityEntryId,
			Date contractpriorityModifiedDate,
			int contractpriorityModifiedId,
			String contractpriorityName,
			int contractpriorityRank,
			String contractpriorityTrigger1Hrs,
			String contractpriorityTrigger2Hrs,
			String contractpriorityTrigger3Hrs,
			String contractpriorityTrigger4Hrs,
			String contractpriorityTrigger5Hrs) {
		super();
		this.contractpriorityId = contractpriorityId;
		this.contractpriorityBusinessHrs = contractpriorityBusinessHrs;
		this.contractpriorityDesc = contractpriorityDesc;
		this.contractpriorityDuehrs = contractpriorityDuehrs;
		this.contractpriorityEntryDate = contractpriorityEntryDate;
		this.contractpriorityEntryId = contractpriorityEntryId;
		this.contractpriorityModifiedDate = contractpriorityModifiedDate;
		this.contractpriorityModifiedId = contractpriorityModifiedId;
		this.contractpriorityName = contractpriorityName;
		this.contractpriorityRank = contractpriorityRank;
		this.contractpriorityTrigger1Hrs = contractpriorityTrigger1Hrs;
		this.contractpriorityTrigger2Hrs = contractpriorityTrigger2Hrs;
		this.contractpriorityTrigger3Hrs = contractpriorityTrigger3Hrs;
		this.contractpriorityTrigger4Hrs = contractpriorityTrigger4Hrs;
		this.contractpriorityTrigger5Hrs = contractpriorityTrigger5Hrs;
	}

	public int getContractpriorityId() {
		return this.contractpriorityId;
	}

	public void setContractpriorityId(int contractpriorityId) {
		this.contractpriorityId = contractpriorityId;
	}

	public String getContractpriorityBusinessHrs() {
		return this.contractpriorityBusinessHrs;
	}

	public void setContractpriorityBusinessHrs(String contractpriorityBusinessHrs) {
		this.contractpriorityBusinessHrs = contractpriorityBusinessHrs;
	}

	public String getContractpriorityDesc() {
		return this.contractpriorityDesc;
	}

	public void setContractpriorityDesc(String contractpriorityDesc) {
		this.contractpriorityDesc = contractpriorityDesc;
	}

	public String getContractpriorityDuehrs() {
		return this.contractpriorityDuehrs;
	}

	public void setContractpriorityDuehrs(String contractpriorityDuehrs) {
		this.contractpriorityDuehrs = contractpriorityDuehrs;
	}

	public double getContractpriorityEndtime() {
		return this.contractpriorityEndtime;
	}

	public void setContractpriorityEndtime(double contractpriorityEndtime) {
		this.contractpriorityEndtime = contractpriorityEndtime;
	}

	public Date getContractpriorityEntryDate() {
		return this.contractpriorityEntryDate;
	}

	public void setContractpriorityEntryDate(Date contractpriorityEntryDate) {
		this.contractpriorityEntryDate = contractpriorityEntryDate;
	}

	public int getContractpriorityEntryId() {
		return this.contractpriorityEntryId;
	}

	public void setContractpriorityEntryId(int contractpriorityEntryId) {
		this.contractpriorityEntryId = contractpriorityEntryId;
	}

	public String getContractpriorityFri() {
		return this.contractpriorityFri;
	}

	public void setContractpriorityFri(String contractpriorityFri) {
		this.contractpriorityFri = contractpriorityFri;
	}

	public Date getContractpriorityModifiedDate() {
		return this.contractpriorityModifiedDate;
	}

	public void setContractpriorityModifiedDate(Date contractpriorityModifiedDate) {
		this.contractpriorityModifiedDate = contractpriorityModifiedDate;
	}

	public int getContractpriorityModifiedId() {
		return this.contractpriorityModifiedId;
	}

	public void setContractpriorityModifiedId(int contractpriorityModifiedId) {
		this.contractpriorityModifiedId = contractpriorityModifiedId;
	}

	public String getContractpriorityMon() {
		return this.contractpriorityMon;
	}

	public void setContractpriorityMon(String contractpriorityMon) {
		this.contractpriorityMon = contractpriorityMon;
	}

	public String getContractpriorityName() {
		return this.contractpriorityName;
	}

	public void setContractpriorityName(String contractpriorityName) {
		this.contractpriorityName = contractpriorityName;
	}

	public int getContractpriorityRank() {
		return this.contractpriorityRank;
	}

	public void setContractpriorityRank(int contractpriorityRank) {
		this.contractpriorityRank = contractpriorityRank;
	}

	public String getContractprioritySat() {
		return this.contractprioritySat;
	}

	public void setContractprioritySat(String contractprioritySat) {
		this.contractprioritySat = contractprioritySat;
	}

	public double getContractpriorityStarttime() {
		return this.contractpriorityStarttime;
	}

	public void setContractpriorityStarttime(double contractpriorityStarttime) {
		this.contractpriorityStarttime = contractpriorityStarttime;
	}

	public String getContractprioritySun() {
		return this.contractprioritySun;
	}

	public void setContractprioritySun(String contractprioritySun) {
		this.contractprioritySun = contractprioritySun;
	}

	public String getContractpriorityThu() {
		return this.contractpriorityThu;
	}

	public void setContractpriorityThu(String contractpriorityThu) {
		this.contractpriorityThu = contractpriorityThu;
	}

	public String getContractpriorityTrigger1Hrs() {
		return this.contractpriorityTrigger1Hrs;
	}

	public void setContractpriorityTrigger1Hrs(String contractpriorityTrigger1Hrs) {
		this.contractpriorityTrigger1Hrs = contractpriorityTrigger1Hrs;
	}

	public String getContractpriorityTrigger2Hrs() {
		return this.contractpriorityTrigger2Hrs;
	}

	public void setContractpriorityTrigger2Hrs(String contractpriorityTrigger2Hrs) {
		this.contractpriorityTrigger2Hrs = contractpriorityTrigger2Hrs;
	}

	public String getContractpriorityTrigger3Hrs() {
		return this.contractpriorityTrigger3Hrs;
	}

	public void setContractpriorityTrigger3Hrs(String contractpriorityTrigger3Hrs) {
		this.contractpriorityTrigger3Hrs = contractpriorityTrigger3Hrs;
	}

	public String getContractpriorityTrigger4Hrs() {
		return this.contractpriorityTrigger4Hrs;
	}

	public void setContractpriorityTrigger4Hrs(String contractpriorityTrigger4Hrs) {
		this.contractpriorityTrigger4Hrs = contractpriorityTrigger4Hrs;
	}

	public String getContractpriorityTrigger5Hrs() {
		return this.contractpriorityTrigger5Hrs;
	}

	public void setContractpriorityTrigger5Hrs(String contractpriorityTrigger5Hrs) {
		this.contractpriorityTrigger5Hrs = contractpriorityTrigger5Hrs;
	}

	public String getContractpriorityTue() {
		return this.contractpriorityTue;
	}

	public void setContractpriorityTue(String contractpriorityTue) {
		this.contractpriorityTue = contractpriorityTue;
	}

	public String getContractpriorityWed() {
		return this.contractpriorityWed;
	}

	public void setContractpriorityWed(String contractpriorityWed) {
		this.contractpriorityWed = contractpriorityWed;
	}

}