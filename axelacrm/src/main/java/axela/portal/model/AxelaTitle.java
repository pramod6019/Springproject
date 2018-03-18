package axela.portal.model;

import java.io.Serializable;
import java.util.Date;
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

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import axela.customer.model.AxelaCustomerContact;

/**
 * The persistent class for the axela_title database table.
 * 
 */
@Entity
@Table(name = "axela_title", catalog = "axela_1")
@NamedQuery(name = "AxelaTitle.findAll", query = "SELECT a FROM AxelaTitle a")
public class AxelaTitle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "title_id")
	private int titleId;

	@Column(name = "title_desc")
	private String titleDesc;

	@Column(name = "title_entry_date")
	private Date titleEntryDate;

	@Column(name = "title_entry_id")
	private int titleEntryId;

	@Column(name = "title_gender")
	private String titleGender;

	// bi-directional one-to-many association to AxelaCustomerContact
	@OneToMany(mappedBy = "axelaTitle", cascade = CascadeType.ALL)
	@NotFound(action = NotFoundAction.IGNORE)
	private List<AxelaCustomerContact> axelaCustomerContact;

	public List<AxelaCustomerContact> getAxelaCustomerContact() {
		return axelaCustomerContact;
	}

	public void setAxelaCustomerContact(List<AxelaCustomerContact> axelaCustomerContact) {
		this.axelaCustomerContact = axelaCustomerContact;
	}

	@Column(name = "title_modified_date")
	private Date titleModifiedDate;

	@Column(name = "title_modified_id")
	private int titleModifiedId;

	@Column(name = "title_rank")
	private int titleRank;

	public AxelaTitle(
			int titleId,
			String titleGender,
			String titleDesc,
			int titleRank,
			int titleEntryId,
			Date titleEntryDate,
			int titleModifiedId,
			Date titleModifiedDate) {
		this.titleId = titleId;
		this.titleGender = titleGender;
		this.titleDesc = titleDesc;
		this.titleRank = titleRank;
		this.titleEntryId = titleEntryId;
		this.titleEntryDate = titleEntryDate;
		this.titleModifiedId = titleModifiedId;
		this.titleModifiedDate = titleModifiedDate;
	}

	public AxelaTitle() {
	}

	public int getTitleId() {
		return this.titleId;
	}

	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}

	public String getTitleDesc() {
		return this.titleDesc;
	}

	public void setTitleDesc(String titleDesc) {
		this.titleDesc = titleDesc;
	}

	public Date getTitleEntryDate() {
		return this.titleEntryDate;
	}

	public void setTitleEntryDate(Date titleEntryDate) {
		this.titleEntryDate = titleEntryDate;
	}

	public int getTitleEntryId() {
		return this.titleEntryId;
	}

	public void setTitleEntryId(int titleEntryId) {
		this.titleEntryId = titleEntryId;
	}

	public String getTitleGender() {
		return this.titleGender;
	}

	public void setTitleGender(String titleGender) {
		this.titleGender = titleGender;
	}

	public Date getTitleModifiedDate() {
		return this.titleModifiedDate;
	}

	public void setTitleModifiedDate(Date titleModifiedDate) {
		this.titleModifiedDate = titleModifiedDate;
	}

	public int getTitleModifiedId() {
		return this.titleModifiedId;
	}

	public void setTitleModifiedId(int titleModifiedId) {
		this.titleModifiedId = titleModifiedId;
	}

	public int getTitleRank() {
		return this.titleRank;
	}

	public void setTitleRank(int titleRank) {
		this.titleRank = titleRank;
	}

}