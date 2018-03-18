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
 * The persistent class for the axela_sales_oppr_destination database table.
 * 
 */
@Entity
@Table(name = "axela_sales_oppr_destination", catalog = "axela_1")
@NamedQuery(name = "AxelaSalesOpprDestination.findAll", query = "SELECT a FROM AxelaSalesOpprDestination a")
public class AxelaSalesOpprDestination implements Serializable {
	private static final long serialVersionUID = 1L;

	public AxelaSalesOpprDestination(
			int destinationId,
			String destinationName) {
		super();
		this.destinationId = destinationId;
		this.destinationName = destinationName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "destination_id")
	private int destinationId;

	@Column(name = "destination_entry_date")
	private Date destinationEntryDate;

	@Column(name = "destination_entry_id")
	private int destinationEntryId;

	@Column(name = "destination_modified_date")
	private Date destinationModifiedDate;

	@Column(name = "destination_modified_id")
	private int destinationModifiedId;

	@Column(name = "destination_name")
	private String destinationName;

	public AxelaSalesOpprDestination() {
	}

	public int getDestinationId() {
		return this.destinationId;
	}

	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}

	public Date getDestinationEntryDate() {
		return this.destinationEntryDate;
	}

	public void setDestinationEntryDate(Date destinationEntryDate) {
		this.destinationEntryDate = destinationEntryDate;
	}

	public int getDestinationEntryId() {
		return this.destinationEntryId;
	}

	public void setDestinationEntryId(int destinationEntryId) {
		this.destinationEntryId = destinationEntryId;
	}

	public Date getDestinationModifiedDate() {
		return this.destinationModifiedDate;
	}

	public void setDestinationModifiedDate(Date destinationModifiedDate) {
		this.destinationModifiedDate = destinationModifiedDate;
	}

	public int getDestinationModifiedId() {
		return this.destinationModifiedId;
	}

	public void setDestinationModifiedId(int destinationModifiedId) {
		this.destinationModifiedId = destinationModifiedId;
	}

	public String getDestinationName() {
		return this.destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

}