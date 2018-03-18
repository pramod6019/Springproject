package axela.accounting.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the axela_acc_voucher_class database table.
 * 
 */
@Entity
@Table(name = "axela_acc_voucher_class", catalog = "axela")
@NamedQuery(name = "AxelaAccVoucherClass.findAll", query = "SELECT a FROM AxelaAccVoucherClass a")
public class AxelaAccVoucherClass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "voucherclass_id")
	private int voucherclassId;

	@Column(name = "voucherclass_acc")
	private short voucherclassAcc;

	@Column(name = "voucherclass_active")
	private String voucherclassActive;

	@Column(name = "voucherclass_ai")
	private short voucherclassAi;

	@Column(name = "voucherclass_desc")
	private String voucherclassDesc;

	@Column(name = "voucherclass_file")
	private String voucherclassFile;

	@Column(name = "voucherclass_income")
	private short voucherclassIncome;

	@Column(name = "voucherclass_inventory_traffic")
	private short voucherclassInventoryTraffic;

	@Column(name = "voucherclass_name")
	private String voucherclassName;

	@Column(name = "voucherclass_notes")
	private String voucherclassNotes;

	@Column(name = "voucherclass_rank")
	private int voucherclassRank;

	public AxelaAccVoucherClass() {
	}

	public int getVoucherclassId() {
		return this.voucherclassId;
	}

	public void setVoucherclassId(int voucherclassId) {
		this.voucherclassId = voucherclassId;
	}

	public short getVoucherclassAcc() {
		return this.voucherclassAcc;
	}

	public void setVoucherclassAcc(short voucherclassAcc) {
		this.voucherclassAcc = voucherclassAcc;
	}

	public String getVoucherclassActive() {
		return this.voucherclassActive;
	}

	public void setVoucherclassActive(String voucherclassActive) {
		this.voucherclassActive = voucherclassActive;
	}

	public short getVoucherclassAi() {
		return this.voucherclassAi;
	}

	public void setVoucherclassAi(short voucherclassAi) {
		this.voucherclassAi = voucherclassAi;
	}

	public String getVoucherclassDesc() {
		return this.voucherclassDesc;
	}

	public void setVoucherclassDesc(String voucherclassDesc) {
		this.voucherclassDesc = voucherclassDesc;
	}

	public String getVoucherclassFile() {
		return this.voucherclassFile;
	}

	public void setVoucherclassFile(String voucherclassFile) {
		this.voucherclassFile = voucherclassFile;
	}

	public short getVoucherclassIncome() {
		return this.voucherclassIncome;
	}

	public void setVoucherclassIncome(short voucherclassIncome) {
		this.voucherclassIncome = voucherclassIncome;
	}

	public short getVoucherclassInventoryTraffic() {
		return this.voucherclassInventoryTraffic;
	}

	public void setVoucherclassInventoryTraffic(short voucherclassInventoryTraffic) {
		this.voucherclassInventoryTraffic = voucherclassInventoryTraffic;
	}

	public String getVoucherclassName() {
		return this.voucherclassName;
	}

	public void setVoucherclassName(String voucherclassName) {
		this.voucherclassName = voucherclassName;
	}

	public String getVoucherclassNotes() {
		return this.voucherclassNotes;
	}

	public void setVoucherclassNotes(String voucherclassNotes) {
		this.voucherclassNotes = voucherclassNotes;
	}

	public int getVoucherclassRank() {
		return this.voucherclassRank;
	}

	public void setVoucherclassRank(int voucherclassRank) {
		this.voucherclassRank = voucherclassRank;
	}

	// manju

	@OneToMany(mappedBy = "axelaAccVoucherClass", cascade = CascadeType.ALL)
	private List<AxelaAccVoucherType> axelaAccVoucherType;

	public List<AxelaAccVoucherType> getAxelaAccVoucherType() {
		return axelaAccVoucherType;
	}

	public void setAxelaAccVoucherType(List<AxelaAccVoucherType> axelaAccVoucherType) {
		this.axelaAccVoucherType = axelaAccVoucherType;
	}

}