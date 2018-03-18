package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_holi database table.
 * 
 */
@Entity
@Table(name = "axela_holi", catalog = "axela_1")
@NamedQuery(name = "AxelaHoli.findAll", query = "SELECT a FROM AxelaHoli a")
public class AxelaHoli implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "holi_id")
	private int holiId;

	@Column(name = "holi_branch_id")
	private int holiBranchId;

	@Column(name = "holi_entry_date")
	private String holiEntryDate;

	@Column(name = "holi_entry_id")
	private int holiEntryId;

	@Column(name = "holi_fromdate")
	private String holiFromdate;

	@Column(name = "holi_holitype_id")
	private int holiHolitypeId;

	@Column(name = "holi_modified_date")
	private String holiModifiedDate;

	@Column(name = "holi_modified_id")
	private int holiModifiedId;

	@Column(name = "holi_name")
	private String holiName;

	@Column(name = "holi_todate")
	private String holiTodate;

	public AxelaHoli() {
	}

	public int getHoliId() {
		return this.holiId;
	}

	public void setHoliId(int holiId) {
		this.holiId = holiId;
	}

	public int getHoliBranchId() {
		return this.holiBranchId;
	}

	public void setHoliBranchId(int holiBranchId) {
		this.holiBranchId = holiBranchId;
	}

	public String getHoliEntryDate() {
		return this.holiEntryDate;
	}

	public void setHoliEntryDate(String holiEntryDate) {
		this.holiEntryDate = holiEntryDate;
	}

	public int getHoliEntryId() {
		return this.holiEntryId;
	}

	public void setHoliEntryId(int holiEntryId) {
		this.holiEntryId = holiEntryId;
	}

	public String getHoliFromdate() {
		return this.holiFromdate;
	}

	public void setHoliFromdate(String holiFromdate) {
		this.holiFromdate = holiFromdate;
	}

	public int getHoliHolitypeId() {
		return this.holiHolitypeId;
	}

	public void setHoliHolitypeId(int holiHolitypeId) {
		this.holiHolitypeId = holiHolitypeId;
	}

	public String getHoliModifiedDate() {
		return this.holiModifiedDate;
	}

	public void setHoliModifiedDate(String holiModifiedDate) {
		this.holiModifiedDate = holiModifiedDate;
	}

	public int getHoliModifiedId() {
		return this.holiModifiedId;
	}

	public void setHoliModifiedId(int holiModifiedId) {
		this.holiModifiedId = holiModifiedId;
	}

	public String getHoliName() {
		return this.holiName;
	}

	public void setHoliName(String holiName) {
		this.holiName = holiName;
	}

	public String getHoliTodate() {
		return this.holiTodate;
	}

	public void setHoliTodate(String holiTodate) {
		this.holiTodate = holiTodate;
	}

}