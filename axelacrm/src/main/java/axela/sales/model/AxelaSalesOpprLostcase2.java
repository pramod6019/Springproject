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
 * The persistent class for the axela_sales_oppr_lostcase2 database table.
 * 
 */
@Entity
@Table(name = "axela_sales_oppr_lostcase2", catalog = "axela_1")
@NamedQuery(name = "AxelaSalesOpprLostcase2.findAll", query = "SELECT a FROM AxelaSalesOpprLostcase2 a")
public class AxelaSalesOpprLostcase2 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "lostcase2_id")
	private int lostcase2Id;

	@Column(name = "lostcase2_entry_date")
	private Date lostcase2EntryDate;

	@Column(name = "lostcase2_entry_id")
	private int lostcase2EntryId;

	@Column(name = "lostcase2_lostcase1_id")
	private int lostcase2Lostcase1Id;

	@Column(name = "lostcase2_modified_date")
	private Date lostcase2ModifiedDate;

	@Column(name = "lostcase2_modified_id")
	private int lostcase2ModifiedId;

	@Column(name = "lostcase2_name")
	private String lostcase2Name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lostcase2_lostcase1_id", referencedColumnName = "lostcase1_id", insertable = false, updatable = false)
	private AxelaSalesOpprLostcase1 axelaSalesOpprLostcase1;

	public AxelaSalesOpprLostcase2() {
	}

	public int getLostcase2Id() {
		return this.lostcase2Id;
	}

	public AxelaSalesOpprLostcase1 getAxelaSalesOpprLostcase1() {
		return axelaSalesOpprLostcase1;
	}

	public void setAxelaSalesOpprLostcase1(AxelaSalesOpprLostcase1 axelaSalesOpprLostcase1) {
		this.axelaSalesOpprLostcase1 = axelaSalesOpprLostcase1;
	}

	public void setLostcase2Id(int lostcase2Id) {
		this.lostcase2Id = lostcase2Id;
	}

	public Date getLostcase2EntryDate() {
		return this.lostcase2EntryDate;
	}

	public void setLostcase2EntryDate(Date lostcase2EntryDate) {
		this.lostcase2EntryDate = lostcase2EntryDate;
	}

	public int getLostcase2EntryId() {
		return this.lostcase2EntryId;
	}

	public void setLostcase2EntryId(int lostcase2EntryId) {
		this.lostcase2EntryId = lostcase2EntryId;
	}

	public int getLostcase2Lostcase1Id() {
		return this.lostcase2Lostcase1Id;
	}

	public void setLostcase2Lostcase1Id(int lostcase2Lostcase1Id) {
		this.lostcase2Lostcase1Id = lostcase2Lostcase1Id;
	}

	public Date getLostcase2ModifiedDate() {
		return this.lostcase2ModifiedDate;
	}

	public void setLostcase2ModifiedDate(Date lostcase2ModifiedDate) {
		this.lostcase2ModifiedDate = lostcase2ModifiedDate;
	}

	public int getLostcase2ModifiedId() {
		return this.lostcase2ModifiedId;
	}

	public void setLostcase2ModifiedId(int lostcase2ModifiedId) {
		this.lostcase2ModifiedId = lostcase2ModifiedId;
	}

	public String getLostcase2Name() {
		return this.lostcase2Name;
	}

	public void setLostcase2Name(String lostcase2Name) {
		this.lostcase2Name = lostcase2Name;
	}

}