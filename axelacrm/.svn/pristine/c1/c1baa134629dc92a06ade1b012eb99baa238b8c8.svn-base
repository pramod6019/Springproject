package axela.portal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the axela_module_access database table.
 * 
 */
@Entity
@Table(name = "axela_module_access", catalog = "axela")
@NamedQuery(name = "AxelaModuleAccess.findAll", query = "SELECT a FROM AxelaModuleAccess a")
public class AxelaModuleAccess implements Serializable {
	private static final long serialVersionUID = 1L;

	// access.accessId, "
	// + " access.accessModuleId, "
	// + " access.axelaModule.moduleName, "
	// + " access.accessName, "
	// + " access.accessRank, "
	// + " COALESCE(access.empaccessAccessId, 0) AS empaccessAccessId, "
	// + "	access.axelaBusinessType.businesstypeName ";
	// INNER JOIN access.axelaModule "
	// + " LEFT JOIN access.axelaEmpAccess "
	// + " LEFT JOIN access.axelaComp "
	// + " LEFT JOIN access.axelaBusinessType "
	@Transient
	private String businesstypeName;
	// @Transient
	// private int empId;
	@Transient
	private String moduleName;

	// + " moduleaccess.accessId, "
	// + " moduleaccess.accessModuleId, "
	// + " moduleaccess.axelaModule.moduleName, "
	// + " moduleaccess.accessName, "
	// + " moduleaccess.accessRank, "
	// + " access.empaccessAccessId, "// COALESCE(access.empaccessAccessId, 0) AS
	// + "	comp.axelaBusinessType.businesstypeName ) ";

	public AxelaModuleAccess(
			int accessId,
			int accessModuleId,
			String moduleName,
			String accessName,
			int accessRank,
			// int empaccessAccessId,
			String businesstypeName) {
		super();
		this.accessId = accessId;
		this.moduleName = moduleName;
		this.accessName = accessName;
		this.accessRank = accessRank;
		// this.empaccessAccessId = empaccessAccessId;
		this.businesstypeName = businesstypeName;

	}

	// access rights
	public AxelaModuleAccess(
			int accessId,
			int accessModuleId,
			String moduleName,
			int accessRank,
			String accessName,
			int empaccessAccessId,
			String businesstypeName) {
		super();
		this.accessId = accessId;
		this.accessModuleId = accessModuleId;
		this.moduleName = moduleName;
		this.accessRank = accessRank;
		this.accessName = accessName;
		this.empaccessAccessId = empaccessAccessId;
		this.businesstypeName = businesstypeName;

	}
	@Transient
	private int empaccessAccessId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "access_id")
	private int accessId;

	@Column(name = "access_entry_date")
	private String accessEntryDate;

	@Column(name = "access_entry_id")
	private int accessEntryId;

	@Column(name = "access_modified_date")
	private String accessModifiedDate;

	@Column(name = "access_modified_id")
	private int accessModifiedId;

	@Column(name = "access_module_id")
	private int accessModuleId;

	@Column(name = "access_name")
	private String accessName;

	@Column(name = "access_rank")
	private int accessRank;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "access_module_id", referencedColumnName = "module_id", insertable = false, updatable = false)
	AxelaModule axelaModule;
	//
	// @ManyToOne
	// @NotFound(action = NotFoundAction.IGNORE)
	// // empaccess_access_id=access_id "
	// @JoinColumn(name = "access_id", referencedColumnName = "empaccess_access_id", insertable = false, updatable = false)
	// AxelaEmpAccess axelaEmpAccess;

	//
	// @ManyToOne
	// @NotFound(action = NotFoundAction.IGNORE)
	// // businesstype_id = comp_businesstype_id
	// @JoinColumn(name = "comp_businesstype_id", referencedColumnName = "businesstype_id", insertable = false, updatable = false)
	// AxelaBusinessType axelaBusinessType;

	@OneToMany(mappedBy = "axelaModuleAccess")
	private List<AxelaEmpAccess> axelaEmpAccess;

	public AxelaModuleAccess() {
	}

	public List<AxelaEmpAccess> getAxelaEmpAccess() {
		return axelaEmpAccess;
	}

	public void setAxelaEmpAccess(List<AxelaEmpAccess> axelaEmpAccess) {
		this.axelaEmpAccess = axelaEmpAccess;
	}

	public int getAccessId() {
		return this.accessId;
	}

	public void setAccessId(int accessId) {
		this.accessId = accessId;
	}

	public String getAccessEntryDate() {
		return this.accessEntryDate;
	}

	public void setAccessEntryDate(String accessEntryDate) {
		this.accessEntryDate = accessEntryDate;
	}

	public int getAccessEntryId() {
		return this.accessEntryId;
	}

	public void setAccessEntryId(int accessEntryId) {
		this.accessEntryId = accessEntryId;
	}

	public String getAccessModifiedDate() {
		return this.accessModifiedDate;
	}

	public void setAccessModifiedDate(String accessModifiedDate) {
		this.accessModifiedDate = accessModifiedDate;
	}

	public int getAccessModifiedId() {
		return this.accessModifiedId;
	}

	public void setAccessModifiedId(int accessModifiedId) {
		this.accessModifiedId = accessModifiedId;
	}

	public int getAccessModuleId() {
		return this.accessModuleId;
	}

	public void setAccessModuleId(int accessModuleId) {
		this.accessModuleId = accessModuleId;
	}

	public String getAccessName() {
		return this.accessName;
	}

	public void setAccessName(String accessName) {
		this.accessName = accessName;
	}

	public int getAccessRank() {
		return this.accessRank;
	}

	public void setAccessRank(int accessRank) {
		this.accessRank = accessRank;
	}

	public String getBusinesstypeName() {
		return businesstypeName;
	}

	public void setBusinesstypeName(String businesstypeName) {
		this.businesstypeName = businesstypeName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public AxelaModule getAxelaModule() {
		return axelaModule;
	}

	public void setAxelaModule(AxelaModule axelaModule) {
		this.axelaModule = axelaModule;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public int getEmpaccessAccessId() {
		return empaccessAccessId;
	}

	public void setEmpaccessAccessId(int empaccessAccessId) {
		this.empaccessAccessId = empaccessAccessId;
	}

}