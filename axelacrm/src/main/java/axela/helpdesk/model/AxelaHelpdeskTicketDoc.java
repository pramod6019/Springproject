package axela.helpdesk.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_helpdesk_ticket_docs database table.
 * 
 */
@Entity
@Table(name = "axela_helpdesk_ticket_docs", catalog = "axela_1")
@NamedQuery(name = "AxelaHelpdeskTicketDoc.findAll", query = "SELECT a FROM AxelaHelpdeskTicketDoc a")
public class AxelaHelpdeskTicketDoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "doc_id")
	private int docId;

	@Lob
	@Column(name = "doc_data")
	private byte[] docData;

	@Column(name = "doc_entry_date")
	private String docEntryDate;

	@Column(name = "doc_entry_id")
	private int docEntryId;

	@Column(name = "doc_modified_date")
	private String docModifiedDate;

	@Column(name = "doc_modified_id")
	private int docModifiedId;

	@Column(name = "doc_remarks")
	private String docRemarks;

	@Column(name = "doc_ticket_id")
	private int docTicketId;

	@Column(name = "doc_title")
	private String docTitle;

	@Column(name = "doc_value")
	private String docValue;

	public AxelaHelpdeskTicketDoc() {
	}

	public int getDocId() {
		return this.docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public byte[] getDocData() {
		return this.docData;
	}

	public void setDocData(byte[] docData) {
		this.docData = docData;
	}

	public String getDocEntryDate() {
		return this.docEntryDate;
	}

	public void setDocEntryDate(String docEntryDate) {
		this.docEntryDate = docEntryDate;
	}

	public int getDocEntryId() {
		return this.docEntryId;
	}

	public void setDocEntryId(int docEntryId) {
		this.docEntryId = docEntryId;
	}

	public String getDocModifiedDate() {
		return this.docModifiedDate;
	}

	public void setDocModifiedDate(String docModifiedDate) {
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

	public int getDocTicketId() {
		return this.docTicketId;
	}

	public void setDocTicketId(int docTicketId) {
		this.docTicketId = docTicketId;
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