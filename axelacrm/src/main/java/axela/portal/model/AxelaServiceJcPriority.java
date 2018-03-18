//package axela.portal.model;
//
//import java.io.Serializable;
//import javax.persistence.*;
//
//
///**
// * The persistent class for the axela_service_jc_priority database table.
// * 
// */
//@Entity
//@Table(name="axela_service_jc_priority")
//@NamedQuery(name="AxelaServiceJcPriority.findAll", query="SELECT a FROM AxelaServiceJcPriority a")
//public class AxelaServiceJcPriority implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@Column(name="priorityjc_id")
//	private int priorityjcId;
//
//	@Column(name="priorityjc_desc")
//	private String priorityjcDesc;
//
//	@Column(name="priorityjc_duehrs")
//	private double priorityjcDuehrs;
//
//	@Column(name="priorityjc_entry_date")
//	private String priorityjcEntryDate;
//
//	@Column(name="priorityjc_entry_id")
//	private int priorityjcEntryId;
//
//	@Column(name="priorityjc_modified_date")
//	private String priorityjcModifiedDate;
//
//	@Column(name="priorityjc_modified_id")
//	private int priorityjcModifiedId;
//
//	@Column(name="priorityjc_name")
//	private String priorityjcName;
//
//	@Column(name="priorityjc_rank")
//	private int priorityjcRank;
//
//	@Column(name="priorityjc_trigger1_hrs")
//	private double priorityjcTrigger1Hrs;
//
//	@Column(name="priorityjc_trigger2_hrs")
//	private double priorityjcTrigger2Hrs;
//
//	@Column(name="priorityjc_trigger3_hrs")
//	private double priorityjcTrigger3Hrs;
//
//	@Column(name="priorityjc_trigger4_hrs")
//	private double priorityjcTrigger4Hrs;
//
//	@Column(name="priorityjc_trigger5_hrs")
//	private double priorityjcTrigger5Hrs;
//
//	public AxelaServiceJcPriority() {
//	}
//
//	public int getPriorityjcId() {
//		return this.priorityjcId;
//	}
//
//	public void setPriorityjcId(int priorityjcId) {
//		this.priorityjcId = priorityjcId;
//	}
//
//	public String getPriorityjcDesc() {
//		return this.priorityjcDesc;
//	}
//
//	public void setPriorityjcDesc(String priorityjcDesc) {
//		this.priorityjcDesc = priorityjcDesc;
//	}
//
//	public double getPriorityjcDuehrs() {
//		return this.priorityjcDuehrs;
//	}
//
//	public void setPriorityjcDuehrs(double priorityjcDuehrs) {
//		this.priorityjcDuehrs = priorityjcDuehrs;
//	}
//
//	public String getPriorityjcEntryDate() {
//		return this.priorityjcEntryDate;
//	}
//
//	public void setPriorityjcEntryDate(String priorityjcEntryDate) {
//		this.priorityjcEntryDate = priorityjcEntryDate;
//	}
//
//	public int getPriorityjcEntryId() {
//		return this.priorityjcEntryId;
//	}
//
//	public void setPriorityjcEntryId(int priorityjcEntryId) {
//		this.priorityjcEntryId = priorityjcEntryId;
//	}
//
//	public String getPriorityjcModifiedDate() {
//		return this.priorityjcModifiedDate;
//	}
//
//	public void setPriorityjcModifiedDate(String priorityjcModifiedDate) {
//		this.priorityjcModifiedDate = priorityjcModifiedDate;
//	}
//
//	public int getPriorityjcModifiedId() {
//		return this.priorityjcModifiedId;
//	}
//
//	public void setPriorityjcModifiedId(int priorityjcModifiedId) {
//		this.priorityjcModifiedId = priorityjcModifiedId;
//	}
//
//	public String getPriorityjcName() {
//		return this.priorityjcName;
//	}
//
//	public void setPriorityjcName(String priorityjcName) {
//		this.priorityjcName = priorityjcName;
//	}
//
//	public int getPriorityjcRank() {
//		return this.priorityjcRank;
//	}
//
//	public void setPriorityjcRank(int priorityjcRank) {
//		this.priorityjcRank = priorityjcRank;
//	}
//
//	public double getPriorityjcTrigger1Hrs() {
//		return this.priorityjcTrigger1Hrs;
//	}
//
//	public void setPriorityjcTrigger1Hrs(double priorityjcTrigger1Hrs) {
//		this.priorityjcTrigger1Hrs = priorityjcTrigger1Hrs;
//	}
//
//	public double getPriorityjcTrigger2Hrs() {
//		return this.priorityjcTrigger2Hrs;
//	}
//
//	public void setPriorityjcTrigger2Hrs(double priorityjcTrigger2Hrs) {
//		this.priorityjcTrigger2Hrs = priorityjcTrigger2Hrs;
//	}
//
//	public double getPriorityjcTrigger3Hrs() {
//		return this.priorityjcTrigger3Hrs;
//	}
//
//	public void setPriorityjcTrigger3Hrs(double priorityjcTrigger3Hrs) {
//		this.priorityjcTrigger3Hrs = priorityjcTrigger3Hrs;
//	}
//
//	public double getPriorityjcTrigger4Hrs() {
//		return this.priorityjcTrigger4Hrs;
//	}
//
//	public void setPriorityjcTrigger4Hrs(double priorityjcTrigger4Hrs) {
//		this.priorityjcTrigger4Hrs = priorityjcTrigger4Hrs;
//	}
//
//	public double getPriorityjcTrigger5Hrs() {
//		return this.priorityjcTrigger5Hrs;
//	}
//
//	public void setPriorityjcTrigger5Hrs(double priorityjcTrigger5Hrs) {
//		this.priorityjcTrigger5Hrs = priorityjcTrigger5Hrs;
//	}
//
// }