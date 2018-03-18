package axela.service.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_asset_contract database table.
 * 
 */
@Entity
@Table(name = "axela_asset_contract", catalog = "axela_1")
@NamedQuery(name = "AxelaAssetContract.findAll", query = "SELECT a FROM AxelaAssetContract a")
public class AxelaAssetContract implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "contract_id")
	private int contractId;

	@Column(name = "contract_active")
	private String contractActive;

	@Column(name = "contract_amt")
	private double contractAmt;

	@Column(name = "contract_branch_id")
	private int contractBranchId;

	@Column(name = "contract_contracttype_id")
	private int contractContracttypeId;

	@Column(name = "contract_customer_id")
	private int contractCustomerId;

	@Column(name = "contract_date")
	private String contractDate;

	@Lob
	@Column(name = "contract_desc")
	private String contractDesc;

	@Column(name = "contract_end_date")
	private String contractEndDate;

	@Column(name = "contract_entry_date")
	private String contractEntryDate;

	@Column(name = "contract_entry_id")
	private int contractEntryId;

	@Column(name = "contract_modified_date")
	private String contractModifiedDate;

	@Column(name = "contract_modified_id")
	private int contractModifiedId;

	@Column(name = "contract_no")
	private int contractNo;

	@Column(name = "contract_notes")
	private String contractNotes;

	@Column(name = "contract_po")
	private String contractPo;

	@Column(name = "contract_refno")
	private String contractRefno;

	@Column(name = "contract_start_date")
	private String contractStartDate;

	@Lob
	@Column(name = "contract_terms")
	private String contractTerms;

	@Column(name = "contract_title")
	private String contractTitle;

	public AxelaAssetContract() {
	}

	public int getContractId() {
		return this.contractId;
	}

	public void setContractId(int contractId) {
		this.contractId = contractId;
	}

	public String getContractActive() {
		return this.contractActive;
	}

	public void setContractActive(String contractActive) {
		this.contractActive = contractActive;
	}

	public double getContractAmt() {
		return this.contractAmt;
	}

	public void setContractAmt(double contractAmt) {
		this.contractAmt = contractAmt;
	}

	public int getContractBranchId() {
		return this.contractBranchId;
	}

	public void setContractBranchId(int contractBranchId) {
		this.contractBranchId = contractBranchId;
	}

	public int getContractContracttypeId() {
		return this.contractContracttypeId;
	}

	public void setContractContracttypeId(int contractContracttypeId) {
		this.contractContracttypeId = contractContracttypeId;
	}

	public int getContractCustomerId() {
		return this.contractCustomerId;
	}

	public void setContractCustomerId(int contractCustomerId) {
		this.contractCustomerId = contractCustomerId;
	}

	public String getContractDate() {
		return this.contractDate;
	}

	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}

	public String getContractDesc() {
		return this.contractDesc;
	}

	public void setContractDesc(String contractDesc) {
		this.contractDesc = contractDesc;
	}

	public String getContractEndDate() {
		return this.contractEndDate;
	}

	public void setContractEndDate(String contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public String getContractEntryDate() {
		return this.contractEntryDate;
	}

	public void setContractEntryDate(String contractEntryDate) {
		this.contractEntryDate = contractEntryDate;
	}

	public int getContractEntryId() {
		return this.contractEntryId;
	}

	public void setContractEntryId(int contractEntryId) {
		this.contractEntryId = contractEntryId;
	}

	public String getContractModifiedDate() {
		return this.contractModifiedDate;
	}

	public void setContractModifiedDate(String contractModifiedDate) {
		this.contractModifiedDate = contractModifiedDate;
	}

	public int getContractModifiedId() {
		return this.contractModifiedId;
	}

	public void setContractModifiedId(int contractModifiedId) {
		this.contractModifiedId = contractModifiedId;
	}

	public int getContractNo() {
		return this.contractNo;
	}

	public void setContractNo(int contractNo) {
		this.contractNo = contractNo;
	}

	public String getContractNotes() {
		return this.contractNotes;
	}

	public void setContractNotes(String contractNotes) {
		this.contractNotes = contractNotes;
	}

	public String getContractPo() {
		return this.contractPo;
	}

	public void setContractPo(String contractPo) {
		this.contractPo = contractPo;
	}

	public String getContractRefno() {
		return this.contractRefno;
	}

	public void setContractRefno(String contractRefno) {
		this.contractRefno = contractRefno;
	}

	public String getContractStartDate() {
		return this.contractStartDate;
	}

	public void setContractStartDate(String contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public String getContractTerms() {
		return this.contractTerms;
	}

	public void setContractTerms(String contractTerms) {
		this.contractTerms = contractTerms;
	}

	public String getContractTitle() {
		return this.contractTitle;
	}

	public void setContractTitle(String contractTitle) {
		this.contractTitle = contractTitle;
	}

}