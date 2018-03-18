package axela.portal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_customer_docs database table.
 * 
 */
@Entity
@Table(name = "axela_customer_docs", catalog = "axela_1")
@NamedQuery(name = "AxelaCustomerDoc.findAll", query = "SELECT a FROM AxelaCustomerDoc a")
public class AxelaCustomerDoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "doc_id")
	private int docId;

	@Column(name = "doc_customer_id")
	private int docCustomerId;

	@Lob
	@Column(name = "doc_data")
	private byte[] docData;

	@Column(name = "doc_entry_date")
	private Date docEntryDate;

	@Column(name = "doc_entry_id")
	private int docEntryId;

	@Column(name = "doc_modified_date")
	private Date docModifiedDate;

	@Column(name = "doc_modified_id")
	private int docModifiedId;

	@Column(name = "doc_remarks")
	private String docRemarks;

	@Column(name = "doc_title")
	private String docTitle;

	@Column(name = "doc_value")
	private String docValue;

	public AxelaCustomerDoc() {
	}

	public int getDocId() {
		return this.docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public int getDocCustomerId() {
		return this.docCustomerId;
	}

	public void setDocCustomerId(int docCustomerId) {
		this.docCustomerId = docCustomerId;
	}

	public byte[] getDocData() {
		return this.docData;
	}

	public void setDocData(byte[] docData) {
		this.docData = docData;
	}

	public Date getDocEntryDate() {
		return this.docEntryDate;
	}

	public void setDocEntryDate(Date docEntryDate) {
		this.docEntryDate = docEntryDate;
	}

	public int getDocEntryId() {
		return this.docEntryId;
	}

	public void setDocEntryId(int docEntryId) {
		this.docEntryId = docEntryId;
	}

	public Date getDocModifiedDate() {
		return this.docModifiedDate;
	}

	public void setDocModifiedDate(Date docModifiedDate) {
		this.docModifiedDate = docModifiedDate;
	}

	public int getDocModifiedId() {
		return this.docModifiedId;
	}

	public void setDocModifiedId(int docModifiedId) {
		this.docModifiedId = docModifiedId;
	}

	public String getDocRemarks() {
		return this.docRemarks;
	}

	public void setDocRemarks(String docRemarks) {
		this.docRemarks = docRemarks;
	}

	public String getDocTitle() {
		return this.docTitle;
	}

	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
	}

	public String getDocValue() {
		return this.docValue;
	}

	public void setDocValue(String docValue) {
		this.docValue = docValue;
	}

}