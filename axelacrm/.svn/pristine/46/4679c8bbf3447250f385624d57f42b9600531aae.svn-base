package axela.portal.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the axela_business_type database table.
 * 
 */
@Entity
@Table(name = "axela_business_type", catalog = "axela")
@NamedQuery(name = "AxelaBusinessType.findAll", query = "SELECT a FROM AxelaBusinessType a")
public class AxelaBusinessType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "businesstype_id")
	private int businesstypeId;

	@Column(name = "businesstype_entry_date")
	private String businesstypeEntryDate;

	@Column(name = "businesstype_entry_id")
	private int businesstypeEntryId;

	@Column(name = "businesstype_modified_date")
	private String businesstypeModifiedDate;

	@Column(name = "businesstype_modified_id")
	private int businesstypeModifiedId;

	@Column(name = "businesstype_name")
	private String businesstypeName;

	@OneToMany(mappedBy = "axelaBusinessType")
	private List<AxelaComp> axelaComp;

	public AxelaBusinessType() {
	}

	public List<AxelaComp> getAxelaComp() {
		return axelaComp;
	}

	public void setAxelaComp(List<AxelaComp> axelaComp) {
		this.axelaComp = axelaComp;
	}

	public int getBusinesstypeId() {
		return this.businesstypeId;
	}

	public void setBusinesstypeId(int businesstypeId) {
		this.businesstypeId = businesstypeId;
	}

	public String getBusinesstypeEntryDate() {
		return this.businesstypeEntryDate;
	}

	public void setBusinesstypeEntryDate(String businesstypeEntryDate) {
		this.businesstypeEntryDate = businesstypeEntryDate;
	}

	public int getBusinesstypeEntryId() {
		return this.businesstypeEntryId;
	}

	public void setBusinesstypeEntryId(int businesstypeEntryId) {
		this.businesstypeEntryId = businesstypeEntryId;
	}

	public String getBusinesstypeModifiedDate() {
		return this.businesstypeModifiedDate;
	}

	public void setBusinesstypeModifiedDate(String businesstypeModifiedDate) {
		this.businesstypeModifiedDate = businesstypeModifiedDate;
	}

	public int getBusinesstypeModifiedId() {
		return this.businesstypeModifiedId;
	}

	public void setBusinesstypeModifiedId(int businesstypeModifiedId) {
		this.businesstypeModifiedId = businesstypeModifiedId;
	}

	public String getBusinesstypeName() {
		return this.businesstypeName;
	}

	public void setBusinesstypeName(String businesstypeName) {
		this.businesstypeName = businesstypeName;
	}

}