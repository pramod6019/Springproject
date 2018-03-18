package axela.portal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import axela.service.model.AxelaModuleReport;

/**
 * The persistent class for the axela_module database table.
 * 
 */
@Entity
@Table(name = "axela_module", catalog = "axela")
@NamedQuery(name = "AxelaModule.findAll", query = "SELECT a FROM AxelaModule a")
public class AxelaModule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "module_id")
	private int moduleId;

	@Column(name = "module_entry_date")
	private String moduleEntryDate;

	@Column(name = "module_entry_id")
	private int moduleEntryId;

	@Column(name = "module_modified_date")
	private String moduleModifiedDate;

	@Column(name = "module_modified_id")
	private int moduleModifiedId;

	@Column(name = "module_name")
	private String moduleName;

	@Column(name = "module_rank")
	private int moduleRank;

	@OneToMany(mappedBy = "axelaModule", cascade = CascadeType.ALL)
	private List<AxelaModuleReport> axelaModuleReport;

	public AxelaModule() {
	}

	public int getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleEntryDate() {
		return this.moduleEntryDate;
	}

	public void setModuleEntryDate(String moduleEntryDate) {
		this.moduleEntryDate = moduleEntryDate;
	}

	public int getModuleEntryId() {
		return this.moduleEntryId;
	}

	public void setModuleEntryId(int moduleEntryId) {
		this.moduleEntryId = moduleEntryId;
	}

	public String getModuleModifiedDate() {
		return this.moduleModifiedDate;
	}

	public void setModuleModifiedDate(String moduleModifiedDate) {
		this.moduleModifiedDate = moduleModifiedDate;
	}

	public int getModuleModifiedId() {
		return this.moduleModifiedId;
	}

	public void setModuleModifiedId(int moduleModifiedId) {
		this.moduleModifiedId = moduleModifiedId;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public int getModuleRank() {
		return this.moduleRank;
	}

	public void setModuleRank(int moduleRank) {
		this.moduleRank = moduleRank;
	}

}