package axela.sales.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_sales_oppr_lostcase3 database table.
 * 
 */
@Entity
@Table(name = "axela_sales_oppr_lostcase3", catalog = "axela_1")
@NamedQuery(name = "AxelaSalesOpprLostcase3.findAll", query = "SELECT a FROM AxelaSalesOpprLostcase3 a")
public class AxelaSalesOpprLostcase3 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "lostcase3_id")
	private int lostcase3Id;

	@Column(name = "lostcase3_entry_date")
	private Date lostcase3EntryDate;

	@Column(name = "lostcase3_entry_id")
	private int lostcase3EntryId;

	@Column(name = "lostcase3_lostcase2_id")
	private int lostcase3Lostcase2Id;

	@Column(name = "lostcase3_modified_date")
	private Date lostcase3ModifiedDate;

	@Column(name = "lostcase3_modified_id")
	private int lostcase3ModifiedId;

	@Column(name = "lostcase3_name")
	private String lostcase3Name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lostcase3_lostcase2_id", referencedColumnName = "lostcase2_lostcase1_id", insertable = false, updatable = false)
	private AxelaSalesOpprLostcase2 axelaSalesOpprLostcase2;

	public AxelaSalesOpprLostcase3() {
	}

	public int getLostcase3Id() {
		return this.lostcase3Id;
	}

	public AxelaSalesOpprLostcase2 getAxelaSalesOpprLostcase2() {
		return axelaSalesOpprLostcase2;
	}

	public void setAxelaSalesOpprLostcase2(AxelaSalesOpprLostcase2 axelaSalesOpprLostcase2) {
		this.axelaSalesOpprLostcase2 = axelaSalesOpprLostcase2;
	}

	public void setLostcase3Id(int lostcase3Id) {
		this.lostcase3Id = lostcase3Id;
	}

	public Date getLostcase3EntryDate() {
		return this.lostcase3EntryDate;
	}

	public void setLostcase3EntryDate(Date lostcase3EntryDate) {
		this.lostcase3EntryDate = lostcase3EntryDate;
	}

	public int getLostcase3EntryId() {
		return this.lostcase3EntryId;
	}

	public void setLostcase3EntryId(int lostcase3EntryId) {
		this.lostcase3EntryId = lostcase3EntryId;
	}

	public int getLostcase3Lostcase2Id() {
		return this.lostcase3Lostcase2Id;
	}

	public void setLostcase3Lostcase2Id(int lostcase3Lostcase2Id) {
		this.lostcase3Lostcase2Id = lostcase3Lostcase2Id;
	}

	public Date getLostcase3ModifiedDate() {
		return this.lostcase3ModifiedDate;
	}

	public void setLostcase3ModifiedDate(Date lostcase3ModifiedDate) {
		this.lostcase3ModifiedDate = lostcase3ModifiedDate;
	}

	public int getLostcase3ModifiedId() {
		return this.lostcase3ModifiedId;
	}

	public void setLostcase3ModifiedId(int lostcase3ModifiedId) {
		this.lostcase3ModifiedId = lostcase3ModifiedId;
	}

	public String getLostcase3Name() {
		return this.lostcase3Name;
	}

	public void setLostcase3Name(String lostcase3Name) {
		this.lostcase3Name = lostcase3Name;
	}

}