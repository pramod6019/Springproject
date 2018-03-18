package axela.inventory.model;

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
 * The persistent class for the axela_inventory_item_model database table.
 * 
 */
@Entity
@Table(name = "axela_inventory_item_model", catalog = "axela_1")
@NamedQuery(name = "AxelaInventoryItemModel.findAll", query = "SELECT a FROM AxelaInventoryItemModel a ORDER BY a.modelName ASC")
public class AxelaInventoryItemModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "model_id")
	private int modelId;

	@Column(name = "model_active")
	private String modelActive;

	@Column(name = "model_desc")
	private String modelDesc;

	@Column(name = "model_entry_date")
	private Date modelEntryDate;

	@Column(name = "model_entry_id")
	private int modelEntryId;

	@Column(name = "model_modified_date")
	private Date modelModifiedDate;

	@Column(name = "model_modified_id")
	private int modelModifiedId;

	@Column(name = "model_name")
	private String modelName;

	public AxelaInventoryItemModel() {
	}

	public AxelaInventoryItemModel(int modelId, String modelName, String modelActive) {
		this.modelId = modelId;
		this.modelName = modelName;
		this.modelActive = modelActive;
	}

	public int getModelId() {
		return this.modelId;
	}

	public void setModelId(int modelId) {
		this.modelId = modelId;
	}

	public String getModelActive() {
		return this.modelActive;
	}

	public void setModelActive(String modelActive) {
		this.modelActive = modelActive;
	}

	public String getModelDesc() {
		return this.modelDesc;
	}

	public void setModelDesc(String modelDesc) {
		this.modelDesc = modelDesc;
	}

	public Date getModelEntryDate() {
		return this.modelEntryDate;
	}

	public void setModelEntryDate(Date modelEntryDate) {
		this.modelEntryDate = modelEntryDate;
	}

	public int getModelEntryId() {
		return this.modelEntryId;
	}

	public void setModelEntryId(int modelEntryId) {
		this.modelEntryId = modelEntryId;
	}

	public Date getModelModifiedDate() {
		return this.modelModifiedDate;
	}

	public void setModelModifiedDate(Date modelModifiedDate) {
		this.modelModifiedDate = modelModifiedDate;
	}

	public int getModelModifiedId() {
		return this.modelModifiedId;
	}

	public void setModelModifiedId(int modelModifiedId) {
		this.modelModifiedId = modelModifiedId;
	}

	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

}