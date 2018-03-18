package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_comp_type database table.
 * 
 */
@Entity
@Table(name = "axela_comp_type", catalog = "axela")
@NamedQuery(name = "AxelaCompType.findAll", query = "SELECT a FROM AxelaCompType a")
public class AxelaCompType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "type_id")
	private int typeId;

	@Column(name = "type_entry_date")
	private String typeEntryDate;

	@Column(name = "type_entry_id")
	private int typeEntryId;

	@Column(name = "type_modified_date")
	private String typeModifiedDate;

	@Column(name = "type_modified_id")
	private int typeModifiedId;

	@Column(name = "type_name")
	private String typeName;

	public AxelaCompType() {
	}

	public int getTypeId() {
		return this.typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeEntryDate() {
		return this.typeEntryDate;
	}

	public void setTypeEntryDate(String typeEntryDate) {
		this.typeEntryDate = typeEntryDate;
	}

	public int getTypeEntryId() {
		return this.typeEntryId;
	}

	public void setTypeEntryId(int typeEntryId) {
		this.typeEntryId = typeEntryId;
	}

	public String getTypeModifiedDate() {
		return this.typeModifiedDate;
	}

	public void setTypeModifiedDate(String typeModifiedDate) {
		this.typeModifiedDate = typeModifiedDate;
	}

	public int getTypeModifiedId() {
		return this.typeModifiedId;
	}

	public void setTypeModifiedId(int typeModifiedId) {
		this.typeModifiedId = typeModifiedId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}