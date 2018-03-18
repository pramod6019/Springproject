package axela.pm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the axela_pm_task_docs database table.
 * 
 */
@Entity
@Table(name = "axela_pm_task_docs", catalog = "axela_1")
@NamedQuery(name = "AxelaPmTaskDoc.findAll", query = "SELECT a FROM AxelaPmTaskDoc a")
public class AxelaPmTaskDoc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
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

	@Column(name = "doc_task_id")
	private int docTaskId;

	@Column(name = "doc_title")
	private String docTitle;

	@Column(name = "doc_value")
	private String docValue;

	@Transient
	private String taskSubject;

	@Transient
	private int taskId;

	public AxelaPmTaskDoc(int docTaskId, int docId, String docTitle, String taskSubject, String docRemarks, int taskId) {
		super();
		this.docTaskId = docTaskId;
		this.docId = docId;
		this.docTitle = docTitle;
		this.taskSubject = taskSubject;
		this.docRemarks = docRemarks;
		this.taskId = taskId;
	}

	public AxelaPmTaskDoc() {
	}

	public int getDocId() {
		return this.docId;
	}

	public String getTaskSubject() {
		return taskSubject;
	}

	public void setTaskSubject(String taskSubject) {
		this.taskSubject = taskSubject;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
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

	public int getDocTaskId() {
		return this.docTaskId;
	}

	public void setDocTaskId(int docTaskId) {
		this.docTaskId = docTaskId;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doc_task_id", referencedColumnName = "task_id", insertable = false, updatable = false)
	private AxelaPmTask axelaPmTask;

}