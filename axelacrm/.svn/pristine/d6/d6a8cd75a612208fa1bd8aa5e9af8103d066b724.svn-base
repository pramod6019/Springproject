package axela.service.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import axela.inventory.model.AxelaInventoryItem;

/**
 * The persistent class for the axela_service_jc_check database table.
 * 
 */
@Entity
@Table(name = "axela_service_jc_check", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceJcCheck.findAll", query = "SELECT a FROM AxelaServiceJcCheck a")
public class AxelaServiceJcCheck implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "check_id")
	private int checkId;

	@Column(name = "check_entry_date")
	private Date checkEntryDate;

	@Column(name = "check_entry_id")
	private int checkEntryId;

	@Column(name = "check_item_id")
	private int checkItemId;

	@Column(name = "check_modified_date")
	private Date checkModifiedDate;

	@Column(name = "check_modified_id")
	private int checkModifiedId;

	@Column(name = "check_name")
	private String checkName;

	@Column(name = "check_type")
	private String checkType;

	@Transient
	private int itemModelId;

	public int getItemModelId() {
		return itemModelId;
	}

	public void setItemModelId(int itemModelId) {
		this.itemModelId = itemModelId;
	}

	public AxelaServiceJcCheck() {
	}

	public AxelaServiceJcCheck(int checkId, String checkName) {
		super();
		this.checkId = checkId;
		this.checkName = checkName;
	}

	public AxelaServiceJcCheck(
			int checkItemId,
			String checkName,
			int checkEntryId,
			Date checkEntryDate,
			int checkModifiedId,
			Date checkModifiedDate,
			int itemModelId) {

		super();
		this.checkItemId = checkItemId;
		this.checkName = checkName;
		this.checkEntryId = checkEntryId;
		this.checkEntryDate = checkEntryDate;
		this.checkModifiedId = checkModifiedId;
		this.checkModifiedDate = checkModifiedDate;
		this.itemModelId = itemModelId;

	}

	public int getCheckId() {
		return this.checkId;
	}

	public void setCheckId(int checkId) {
		this.checkId = checkId;
	}

	public Date getCheckEntryDate() {
		return this.checkEntryDate;
	}

	public void setCheckEntryDate(Date checkEntryDate) {
		this.checkEntryDate = checkEntryDate;
	}

	public int getCheckEntryId() {
		return this.checkEntryId;
	}

	public void setCheckEntryId(int checkEntryId) {
		this.checkEntryId = checkEntryId;
	}

	public int getCheckItemId() {
		return this.checkItemId;
	}

	public void setCheckItemId(int checkItemId) {
		this.checkItemId = checkItemId;
	}

	public Date getCheckModifiedDate() {
		return this.checkModifiedDate;
	}

	public void setCheckModifiedDate(Date checkModifiedDate) {
		this.checkModifiedDate = checkModifiedDate;
	}

	public int getCheckModifiedId() {
		return this.checkModifiedId;
	}

	public void setCheckModifiedId(int checkModifiedId) {
		this.checkModifiedId = checkModifiedId;
	}

	public List<AxelaServiceJcCheckTran> getAxelaServiceJcCheckTran() {
		return axelaServiceJcCheckTran;
	}

	public void setAxelaServiceJcCheckTran(List<AxelaServiceJcCheckTran> axelaServiceJcCheckTran) {
		this.axelaServiceJcCheckTran = axelaServiceJcCheckTran;
	}

	public String getCheckName() {
		return this.checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public String getCheckType() {
		return this.checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "check_item_id", referencedColumnName = "item_id", insertable = false, updatable = false)
	private AxelaInventoryItem axelaInventoryItem;

	@OneToMany(mappedBy = "axelaServiceJcCheck", cascade = CascadeType.ALL)
	private List<AxelaServiceJcCheckTran> axelaServiceJcCheckTran;

}