package axela.service.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import axela.portal.model.AxelaModule;

/**
 * The persistent class for the axela_module_report database table.
 * 
 */
@Entity
@Table(name = "axela_module_report", catalog = "axela")
@NamedQuery(name = "AxelaModuleReport.findAll", query = "SELECT a FROM AxelaModuleReport a")
public class AxelaModuleReport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "report_id")
	private int reportId;

	@Column(name = "report_active")
	private String reportActive;

	@Column(name = "report_entry_date")
	private String reportEntryDate;

	@Column(name = "report_entry_id")
	private int reportEntryId;

	@Column(name = "report_misdisplay")
	private String reportMisdisplay;

	@Column(name = "report_modified_date")
	private String reportModifiedDate;

	@Column(name = "report_modified_id")
	private int reportModifiedId;

	@Column(name = "report_module_id")
	private int reportModuleId;

	@Column(name = "report_moduledisplay")
	private String reportModuledisplay;

	@Column(name = "report_name")
	private String reportName;

	@Column(name = "report_rank")
	private int reportRank;

	@Column(name = "report_url")
	private String reportUrl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "report_module_id", referencedColumnName = "module_id", insertable = false, updatable = false)
	private AxelaModule axelaModule;

	public AxelaModuleReport() {
	}
	public AxelaModuleReport(
			int reportId,
			String reportName,
			String reportUrl) {
		super();
		this.reportId = reportId;
		this.reportName = reportName;
		this.reportUrl = reportUrl;
	}
	public AxelaModuleReport(
			String reportName,
			String reportUrl) {
		super();
		this.reportName = reportName;
		this.reportUrl = reportUrl;
	}

	public int getReportId() {
		return this.reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getReportActive() {
		return this.reportActive;
	}

	public void setReportActive(String reportActive) {
		this.reportActive = reportActive;
	}

	public String getReportEntryDate() {
		return this.reportEntryDate;
	}

	public void setReportEntryDate(String reportEntryDate) {
		this.reportEntryDate = reportEntryDate;
	}

	public int getReportEntryId() {
		return this.reportEntryId;
	}

	public void setReportEntryId(int reportEntryId) {
		this.reportEntryId = reportEntryId;
	}

	public String getReportMisdisplay() {
		return this.reportMisdisplay;
	}

	public void setReportMisdisplay(String reportMisdisplay) {
		this.reportMisdisplay = reportMisdisplay;
	}

	public String getReportModifiedDate() {
		return this.reportModifiedDate;
	}

	public void setReportModifiedDate(String reportModifiedDate) {
		this.reportModifiedDate = reportModifiedDate;
	}

	public int getReportModifiedId() {
		return this.reportModifiedId;
	}

	public void setReportModifiedId(int reportModifiedId) {
		this.reportModifiedId = reportModifiedId;
	}

	public int getReportModuleId() {
		return this.reportModuleId;
	}

	public void setReportModuleId(int reportModuleId) {
		this.reportModuleId = reportModuleId;
	}

	public String getReportModuledisplay() {
		return this.reportModuledisplay;
	}

	public void setReportModuledisplay(String reportModuledisplay) {
		this.reportModuledisplay = reportModuledisplay;
	}

	public String getReportName() {
		return this.reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public int getReportRank() {
		return this.reportRank;
	}

	public void setReportRank(int reportRank) {
		this.reportRank = reportRank;
	}

	public String getReportUrl() {
		return this.reportUrl;
	}

	public void setReportUrl(String reportUrl) {
		this.reportUrl = reportUrl;
	}

}