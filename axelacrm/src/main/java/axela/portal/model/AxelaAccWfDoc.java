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
 * The persistent class for the axela_acc_wf_docs database table.
 * 
 */
@Entity
@Table(name = "axela_acc_wf_docs", catalog = "axela_1")
@NamedQuery(name = "AxelaAccWfDoc.findAll", query = "SELECT a FROM AxelaAccWfDoc a")
public class AxelaAccWfDoc implements Serializable {
	public AxelaAccWfDoc(
			int docId,
			int docDaynos,
			int docEffective,
			String docWfTitle) {
		super();
		this.docId = docId;
		this.docDaynos = docDaynos;
		this.docEffective = docEffective;
		this.docWfTitle = docWfTitle;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "doc_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int docId;

	@Column(name = "doc_daynos")
	private int docDaynos;

	@Column(name = "doc_effective")
	private int docEffective;

	@Column(name = "doc_entry_date")
	private Date docEntryDate;

	@Column(name = "doc_entry_id")
	private int docEntryId;

	@Column(name = "doc_modified_date")
	private Date docModifiedDate;

	@Column(name = "doc_modified_id")
	private int docModifiedId;

	@Column(name = "doc_wf_title")
	private String docWfTitle;

	public AxelaAccWfDoc() {
	}

	public int getDocId() {
		return this.docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public int getDocDaynos() {
		return this.docDaynos;
	}

	public void setDocDaynos(int docDaynos) {
		this.docDaynos = docDaynos;
	}

	public int getDocEffective() {
		return this.docEffective;
	}

	public void setDocEffective(int docEffective) {
		this.docEffective = docEffective;
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

	public String getDocWfTitle() {
		return this.docWfTitle;
	}

	public void setDocWfTitle(String docWfTitle) {
		this.docWfTitle = docWfTitle;
	}

}