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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the axela_franchisee database table.
 * 
 */
@Entity
@Table(name = "axela_franchisee", catalog = "axela_1")
@NamedQuery(name = "AxelaFranchisee.findAll", query = "SELECT a FROM AxelaFranchisee a")
public class AxelaFranchisee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "franchisee_id")
	private int franchiseeId;

	@Column(name = "franchisee_active")
	private String franchiseeActive;

	@Column(name = "franchisee_add")
	private String franchiseeAdd;

	@Column(name = "franchisee_city_id")
	private int franchiseeCityId;

	@Column(name = "franchisee_contact")
	private String franchiseeContact;

	@Column(name = "franchisee_email1")
	private String franchiseeEmail1;

	@Column(name = "franchisee_email2")
	private String franchiseeEmail2;

	@Column(name = "franchisee_entry_date")
	private String franchiseeEntryDate;

	@Column(name = "franchisee_entry_id")
	private int franchiseeEntryId;

	@Column(name = "franchisee_franchiseetype_id")
	private int franchiseeFranchiseetypeId;

	@Column(name = "franchisee_mobile1")
	private String franchiseeMobile1;

	@Column(name = "franchisee_mobile2")
	private String franchiseeMobile2;

	@Column(name = "franchisee_modified_date")
	private String franchiseeModifiedDate;

	@Column(name = "franchisee_modified_id")
	private int franchiseeModifiedId;

	@Column(name = "franchisee_name")
	private String franchiseeName;

	@Lob
	@Column(name = "franchisee_notes")
	private String franchiseeNotes;

	@Column(name = "franchisee_phone1")
	private String franchiseePhone1;

	@Column(name = "franchisee_phone2")
	private String franchiseePhone2;

	@Column(name = "franchisee_pin")
	private String franchiseePin;

	@Column(name = "franchisee_url")
	private String franchiseeUrl;

	@OneToMany(mappedBy = "axelaFranchisee")
	private List<AxelaBranch> axelaBranch;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "franchisee_franchiseetype_id ", referencedColumnName = "franchiseetype_id", insertable = false, updatable = false)
	private AxelaFranchiseeType axelaFranchiseeType;

	public AxelaFranchisee() {
	}

	public int getFranchiseeId() {
		return this.franchiseeId;
	}

	public void setFranchiseeId(int franchiseeId) {
		this.franchiseeId = franchiseeId;
	}

	public String getFranchiseeActive() {
		return this.franchiseeActive;
	}

	public void setFranchiseeActive(String franchiseeActive) {
		this.franchiseeActive = franchiseeActive;
	}

	public List<AxelaBranch> getAxelaBranch() {
		return axelaBranch;
	}

	public void setAxelaBranch(List<AxelaBranch> axelaBranch) {
		this.axelaBranch = axelaBranch;
	}

	public String getFranchiseeAdd() {
		return this.franchiseeAdd;
	}

	public void setFranchiseeAdd(String franchiseeAdd) {
		this.franchiseeAdd = franchiseeAdd;
	}

	public int getFranchiseeCityId() {
		return this.franchiseeCityId;
	}

	public void setFranchiseeCityId(int franchiseeCityId) {
		this.franchiseeCityId = franchiseeCityId;
	}

	public String getFranchiseeContact() {
		return this.franchiseeContact;
	}

	public void setFranchiseeContact(String franchiseeContact) {
		this.franchiseeContact = franchiseeContact;
	}

	public String getFranchiseeEmail1() {
		return this.franchiseeEmail1;
	}

	public void setFranchiseeEmail1(String franchiseeEmail1) {
		this.franchiseeEmail1 = franchiseeEmail1;
	}

	public String getFranchiseeEmail2() {
		return this.franchiseeEmail2;
	}

	public void setFranchiseeEmail2(String franchiseeEmail2) {
		this.franchiseeEmail2 = franchiseeEmail2;
	}

	public AxelaFranchiseeType getAxelaFranchiseeType() {
		return axelaFranchiseeType;
	}

	public void setAxelaFranchiseeType(AxelaFranchiseeType axelaFranchiseeType) {
		this.axelaFranchiseeType = axelaFranchiseeType;
	}

	public String getFranchiseeEntryDate() {
		return this.franchiseeEntryDate;
	}

	public void setFranchiseeEntryDate(String franchiseeEntryDate) {
		this.franchiseeEntryDate = franchiseeEntryDate;
	}

	public int getFranchiseeEntryId() {
		return this.franchiseeEntryId;
	}

	public void setFranchiseeEntryId(int franchiseeEntryId) {
		this.franchiseeEntryId = franchiseeEntryId;
	}

	public int getFranchiseeFranchiseetypeId() {
		return this.franchiseeFranchiseetypeId;
	}

	public void setFranchiseeFranchiseetypeId(int franchiseeFranchiseetypeId) {
		this.franchiseeFranchiseetypeId = franchiseeFranchiseetypeId;
	}

	public String getFranchiseeMobile1() {
		return this.franchiseeMobile1;
	}

	public void setFranchiseeMobile1(String franchiseeMobile1) {
		this.franchiseeMobile1 = franchiseeMobile1;
	}

	public String getFranchiseeMobile2() {
		return this.franchiseeMobile2;
	}

	public void setFranchiseeMobile2(String franchiseeMobile2) {
		this.franchiseeMobile2 = franchiseeMobile2;
	}

	public String getFranchiseeModifiedDate() {
		return this.franchiseeModifiedDate;
	}

	public void setFranchiseeModifiedDate(String franchiseeModifiedDate) {
		this.franchiseeModifiedDate = franchiseeModifiedDate;
	}

	public int getFranchiseeModifiedId() {
		return this.franchiseeModifiedId;
	}

	public void setFranchiseeModifiedId(int franchiseeModifiedId) {
		this.franchiseeModifiedId = franchiseeModifiedId;
	}

	public String getFranchiseeName() {
		return this.franchiseeName;
	}

	public void setFranchiseeName(String franchiseeName) {
		this.franchiseeName = franchiseeName;
	}

	public String getFranchiseeNotes() {
		return this.franchiseeNotes;
	}

	public void setFranchiseeNotes(String franchiseeNotes) {
		this.franchiseeNotes = franchiseeNotes;
	}

	public String getFranchiseePhone1() {
		return this.franchiseePhone1;
	}

	public void setFranchiseePhone1(String franchiseePhone1) {
		this.franchiseePhone1 = franchiseePhone1;
	}

	public String getFranchiseePhone2() {
		return this.franchiseePhone2;
	}

	public void setFranchiseePhone2(String franchiseePhone2) {
		this.franchiseePhone2 = franchiseePhone2;
	}

	public String getFranchiseePin() {
		return this.franchiseePin;
	}

	public void setFranchiseePin(String franchiseePin) {
		this.franchiseePin = franchiseePin;
	}

	public String getFranchiseeUrl() {
		return this.franchiseeUrl;
	}

	public void setFranchiseeUrl(String franchiseeUrl) {
		this.franchiseeUrl = franchiseeUrl;
	}

}