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
 * The persistent class for the axela_sob database table.
 * 
 */
@Entity
@Table(name = "axela_sob", catalog = "axela_1")
@NamedQuery(name = "AxelaSob.findAll", query = "SELECT a FROM AxelaSob a")
public class AxelaSob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sob_id", nullable = false)
	private int sobId;

	public AxelaSob(
			int sobId,
			String sobName) {
		super();
		this.sobId = sobId;
		this.sobName = sobName;
	}

	@Column(name = "sob_entry_date")
	private Date sobEntryDate;

	@Column(name = "sob_entry_id")
	private int sobEntryId;

	@Column(name = "sob_modified_date")
	private Date sobModifiedDate;

	@Column(name = "sob_modified_id")
	private int sobModifiedId;

	@Column(name = "sob_name")
	private String sobName;

	public AxelaSob() {
	}

	public int getSobId() {
		return this.sobId;
	}

	public void setSobId(int sobId) {
		this.sobId = sobId;
	}

	public Date getSobEntryDate() {
		return this.sobEntryDate;
	}

	public void setSobEntryDate(Date sobEntryDate) {
		this.sobEntryDate = sobEntryDate;
	}

	public int getSobEntryId() {
		return this.sobEntryId;
	}

	public void setSobEntryId(int sobEntryId) {
		this.sobEntryId = sobEntryId;
	}

	public Date getSobModifiedDate() {
		return this.sobModifiedDate;
	}

	public void setSobModifiedDate(Date sobModifiedDate) {
		this.sobModifiedDate = sobModifiedDate;
	}

	public int getSobModifiedId() {
		return this.sobModifiedId;
	}

	public void setSobModifiedId(int sobModifiedId) {
		this.sobModifiedId = sobModifiedId;
	}

	public String getSobName() {
		return this.sobName;
	}

	public void setSobName(String sobName) {
		this.sobName = sobName;
	}

}