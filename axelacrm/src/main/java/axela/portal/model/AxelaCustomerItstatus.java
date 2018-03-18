package axela.portal.model;

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
 * The persistent class for the axela_customer_itstatus database table.
 * 
 */
@Entity
@Table(name = "axela_customer_itstatus", catalog = "axela_1")
@NamedQuery(name = "AxelaCustomerItstatus.findAll", query = "SELECT a FROM AxelaCustomerItstatus a")
public class AxelaCustomerItstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "itstatus_id")
	private int itstatusId;

	@Column(name = "itstatus_entry_date")
	private Date itstatusEntryDate;

	@Column(name = "itstatus_entry_id")
	private int itstatusEntryId;

	@Column(name = "itstatus_modified_date")
	private Date itstatusModifiedDate;

	@Column(name = "itstatus_modified_id")
	private int itstatusModifiedId;

	@Column(name = "itstatus_name")
	private String itstatusName;

	public AxelaCustomerItstatus() {
	}

	public int getItstatusId() {
		return this.itstatusId;
	}

	public void setItstatusId(int itstatusId) {
		this.itstatusId = itstatusId;
	}

	public Date getItstatusEntryDate() {
		return this.itstatusEntryDate;
	}

	public void setItstatusEntryDate(Date itstatusEntryDate) {
		this.itstatusEntryDate = itstatusEntryDate;
	}

	public int getItstatusEntryId() {
		return this.itstatusEntryId;
	}

	public void setItstatusEntryId(int itstatusEntryId) {
		this.itstatusEntryId = itstatusEntryId;
	}

	public Date getItstatusModifiedDate() {
		return this.itstatusModifiedDate;
	}

	public void setItstatusModifiedDate(Date itstatusModifiedDate) {
		this.itstatusModifiedDate = itstatusModifiedDate;
	}

	public int getItstatusModifiedId() {
		return this.itstatusModifiedId;
	}

	public void setItstatusModifiedId(int itstatusModifiedId) {
		this.itstatusModifiedId = itstatusModifiedId;
	}

	public String getItstatusName() {
		return this.itstatusName;
	}

	public void setItstatusName(String itstatusName) {
		this.itstatusName = itstatusName;
	}

}