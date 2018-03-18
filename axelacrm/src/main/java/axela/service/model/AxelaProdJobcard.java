package axela.service.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_prod_jobcard database table.
 * 
 */
@Entity
@Table(name = "axela_prod_jobcard", catalog = "axela_1")
@NamedQuery(name = "AxelaProdJobcard.findAll", query = "SELECT a FROM AxelaProdJobcard a")
public class AxelaProdJobcard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "jobcard_id")
	private int jobcardId;

	@Column(name = "jobcard_active")
	private String jobcardActive;

	@Column(name = "jobcard_actual_endtime")
	private String jobcardActualEndtime;

	@Column(name = "jobcard_actual_starttime")
	private String jobcardActualStarttime;

	@Column(name = "jobcard_branch_id")
	private int jobcardBranchId;

	@Column(name = "jobcard_disc")
	private double jobcardDisc;

	@Column(name = "jobcard_emp_id")
	private int jobcardEmpId;

	@Column(name = "jobcard_endtime")
	private String jobcardEndtime;

	@Column(name = "jobcard_entry_date")
	private String jobcardEntryDate;

	@Column(name = "jobcard_entry_id")
	private int jobcardEntryId;

	@Lob
	@Column(name = "jobcard_instruction")
	private String jobcardInstruction;

	@Column(name = "jobcard_item_id")
	private int jobcardItemId;

	@Column(name = "jobcard_joborder_id")
	private int jobcardJoborderId;

	@Column(name = "jobcard_location_id")
	private int jobcardLocationId;

	@Column(name = "jobcard_machine_id")
	private int jobcardMachineId;

	@Column(name = "jobcard_modified_date")
	private String jobcardModifiedDate;

	@Column(name = "jobcard_modified_id")
	private int jobcardModifiedId;

	@Column(name = "jobcard_no")
	private int jobcardNo;

	@Column(name = "jobcard_notes")
	private String jobcardNotes;

	@Column(name = "jobcard_price")
	private double jobcardPrice;

	@Column(name = "jobcard_qty")
	private int jobcardQty;

	@Column(name = "jobcard_refno")
	private String jobcardRefno;

	@Column(name = "jobcard_stage_id")
	private int jobcardStageId;

	@Column(name = "jobcard_starttime")
	private String jobcardStarttime;

	@Column(name = "jobcard_tax1")
	private double jobcardTax1;

	@Column(name = "jobcard_tax1_id")
	private int jobcardTax1Id;

	@Column(name = "jobcard_tax1_rate")
	private double jobcardTax1Rate;

	@Column(name = "jobcard_tax2")
	private double jobcardTax2;

	@Column(name = "jobcard_tax2_id")
	private int jobcardTax2Id;

	@Column(name = "jobcard_tax2_rate")
	private double jobcardTax2Rate;

	@Column(name = "jobcard_tax3")
	private double jobcardTax3;

	@Column(name = "jobcard_tax3_id")
	private int jobcardTax3Id;

	@Column(name = "jobcard_tax3_rate")
	private double jobcardTax3Rate;

	@Column(name = "jobcard_total")
	private double jobcardTotal;

	@Column(name = "jobcard_trigger")
	private int jobcardTrigger;

	@Column(name = "jobcard_type_id")
	private int jobcardTypeId;

	public AxelaProdJobcard() {
	}

	public int getJobcardId() {
		return this.jobcardId;
	}

	public void setJobcardId(int jobcardId) {
		this.jobcardId = jobcardId;
	}

	public String getJobcardActive() {
		return this.jobcardActive;
	}

	public void setJobcardActive(String jobcardActive) {
		this.jobcardActive = jobcardActive;
	}

	public String getJobcardActualEndtime() {
		return this.jobcardActualEndtime;
	}

	public void setJobcardActualEndtime(String jobcardActualEndtime) {
		this.jobcardActualEndtime = jobcardActualEndtime;
	}

	public String getJobcardActualStarttime() {
		return this.jobcardActualStarttime;
	}

	public void setJobcardActualStarttime(String jobcardActualStarttime) {
		this.jobcardActualStarttime = jobcardActualStarttime;
	}

	public int getJobcardBranchId() {
		return this.jobcardBranchId;
	}

	public void setJobcardBranchId(int jobcardBranchId) {
		this.jobcardBranchId = jobcardBranchId;
	}

	public double getJobcardDisc() {
		return this.jobcardDisc;
	}

	public void setJobcardDisc(double jobcardDisc) {
		this.jobcardDisc = jobcardDisc;
	}

	public int getJobcardEmpId() {
		return this.jobcardEmpId;
	}

	public void setJobcardEmpId(int jobcardEmpId) {
		this.jobcardEmpId = jobcardEmpId;
	}

	public String getJobcardEndtime() {
		return this.jobcardEndtime;
	}

	public void setJobcardEndtime(String jobcardEndtime) {
		this.jobcardEndtime = jobcardEndtime;
	}

	public String getJobcardEntryDate() {
		return this.jobcardEntryDate;
	}

	public void setJobcardEntryDate(String jobcardEntryDate) {
		this.jobcardEntryDate = jobcardEntryDate;
	}

	public int getJobcardEntryId() {
		return this.jobcardEntryId;
	}

	public void setJobcardEntryId(int jobcardEntryId) {
		this.jobcardEntryId = jobcardEntryId;
	}

	public String getJobcardInstruction() {
		return this.jobcardInstruction;
	}

	public void setJobcardInstruction(String jobcardInstruction) {
		this.jobcardInstruction = jobcardInstruction;
	}

	public int getJobcardItemId() {
		return this.jobcardItemId;
	}

	public void setJobcardItemId(int jobcardItemId) {
		this.jobcardItemId = jobcardItemId;
	}

	public int getJobcardJoborderId() {
		return this.jobcardJoborderId;
	}

	public void setJobcardJoborderId(int jobcardJoborderId) {
		this.jobcardJoborderId = jobcardJoborderId;
	}

	public int getJobcardLocationId() {
		return this.jobcardLocationId;
	}

	public void setJobcardLocationId(int jobcardLocationId) {
		this.jobcardLocationId = jobcardLocationId;
	}

	public int getJobcardMachineId() {
		return this.jobcardMachineId;
	}

	public void setJobcardMachineId(int jobcardMachineId) {
		this.jobcardMachineId = jobcardMachineId;
	}

	public String getJobcardModifiedDate() {
		return this.jobcardModifiedDate;
	}

	public void setJobcardModifiedDate(String jobcardModifiedDate) {
		this.jobcardModifiedDate = jobcardModifiedDate;
	}

	public int getJobcardModifiedId() {
		return this.jobcardModifiedId;
	}

	public void setJobcardModifiedId(int jobcardModifiedId) {
		this.jobcardModifiedId = jobcardModifiedId;
	}

	public int getJobcardNo() {
		return this.jobcardNo;
	}

	public void setJobcardNo(int jobcardNo) {
		this.jobcardNo = jobcardNo;
	}

	public String getJobcardNotes() {
		return this.jobcardNotes;
	}

	public void setJobcardNotes(String jobcardNotes) {
		this.jobcardNotes = jobcardNotes;
	}

	public double getJobcardPrice() {
		return this.jobcardPrice;
	}

	public void setJobcardPrice(double jobcardPrice) {
		this.jobcardPrice = jobcardPrice;
	}

	public int getJobcardQty() {
		return this.jobcardQty;
	}

	public void setJobcardQty(int jobcardQty) {
		this.jobcardQty = jobcardQty;
	}

	public String getJobcardRefno() {
		return this.jobcardRefno;
	}

	public void setJobcardRefno(String jobcardRefno) {
		this.jobcardRefno = jobcardRefno;
	}

	public int getJobcardStageId() {
		return this.jobcardStageId;
	}

	public void setJobcardStageId(int jobcardStageId) {
		this.jobcardStageId = jobcardStageId;
	}

	public String getJobcardStarttime() {
		return this.jobcardStarttime;
	}

	public void setJobcardStarttime(String jobcardStarttime) {
		this.jobcardStarttime = jobcardStarttime;
	}

	public double getJobcardTax1() {
		return this.jobcardTax1;
	}

	public void setJobcardTax1(double jobcardTax1) {
		this.jobcardTax1 = jobcardTax1;
	}

	public int getJobcardTax1Id() {
		return this.jobcardTax1Id;
	}

	public void setJobcardTax1Id(int jobcardTax1Id) {
		this.jobcardTax1Id = jobcardTax1Id;
	}

	public double getJobcardTax1Rate() {
		return this.jobcardTax1Rate;
	}

	public void setJobcardTax1Rate(double jobcardTax1Rate) {
		this.jobcardTax1Rate = jobcardTax1Rate;
	}

	public double getJobcardTax2() {
		return this.jobcardTax2;
	}

	public void setJobcardTax2(double jobcardTax2) {
		this.jobcardTax2 = jobcardTax2;
	}

	public int getJobcardTax2Id() {
		return this.jobcardTax2Id;
	}

	public void setJobcardTax2Id(int jobcardTax2Id) {
		this.jobcardTax2Id = jobcardTax2Id;
	}

	public double getJobcardTax2Rate() {
		return this.jobcardTax2Rate;
	}

	public void setJobcardTax2Rate(double jobcardTax2Rate) {
		this.jobcardTax2Rate = jobcardTax2Rate;
	}

	public double getJobcardTax3() {
		return this.jobcardTax3;
	}

	public void setJobcardTax3(double jobcardTax3) {
		this.jobcardTax3 = jobcardTax3;
	}

	public int getJobcardTax3Id() {
		return this.jobcardTax3Id;
	}

	public void setJobcardTax3Id(int jobcardTax3Id) {
		this.jobcardTax3Id = jobcardTax3Id;
	}

	public double getJobcardTax3Rate() {
		return this.jobcardTax3Rate;
	}

	public void setJobcardTax3Rate(double jobcardTax3Rate) {
		this.jobcardTax3Rate = jobcardTax3Rate;
	}

	public double getJobcardTotal() {
		return this.jobcardTotal;
	}

	public void setJobcardTotal(double jobcardTotal) {
		this.jobcardTotal = jobcardTotal;
	}

	public int getJobcardTrigger() {
		return this.jobcardTrigger;
	}

	public void setJobcardTrigger(int jobcardTrigger) {
		this.jobcardTrigger = jobcardTrigger;
	}

	public int getJobcardTypeId() {
		return this.jobcardTypeId;
	}

	public void setJobcardTypeId(int jobcardTypeId) {
		this.jobcardTypeId = jobcardTypeId;
	}

}