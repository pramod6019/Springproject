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

import org.springframework.stereotype.Component;

/**
 * The persistent class for the axela_sales_oppr_stage database table.
 * 
 */
@Entity
@Table(name = "axela_sales_oppr_stage", catalog = "axela_1")
@NamedQuery(name = "AxelaSalesOpprStage.findAll", query = "SELECT a FROM AxelaSalesOpprStage a")
@Component
public class AxelaSalesOpprStage implements Serializable {

	public AxelaSalesOpprStage(
			int stageId,
			String stageName,
			short stageProbability) {
		super();
		this.stageId = stageId;
		this.stageName = stageName;
		this.stageProbability = stageProbability;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stage_id")
	private int stageId;

	@Column(name = "stage_entry_date")
	private Date stageEntryDate;

	@Column(name = "stage_entry_id")
	private int stageEntryId;

	@Column(name = "stage_modified_date")
	private Date stageModifiedDate;

	@Column(name = "stage_modified_id")
	private int stageModifiedId;

	@Column(name = "stage_name")
	private String stageName;

	@Column(name = "stage_probability")
	private short stageProbability;

	@Column(name = "stage_rank")
	private int stageRank;

	public AxelaSalesOpprStage() {
	}

	public int getStageId() {
		return this.stageId;
	}

	public void setStageId(int stageId) {
		this.stageId = stageId;
	}

	public Date getStageEntryDate() {
		return this.stageEntryDate;
	}

	public void setStageEntryDate(Date stageEntryDate) {
		this.stageEntryDate = stageEntryDate;
	}

	public int getStageEntryId() {
		return this.stageEntryId;
	}

	public void setStageEntryId(int stageEntryId) {
		this.stageEntryId = stageEntryId;
	}

	public Date getStageModifiedDate() {
		return this.stageModifiedDate;
	}

	public void setStageModifiedDate(Date stageModifiedDate) {
		this.stageModifiedDate = stageModifiedDate;
	}

	public int getStageModifiedId() {
		return this.stageModifiedId;
	}

	public void setStageModifiedId(int stageModifiedId) {
		this.stageModifiedId = stageModifiedId;
	}

	public String getStageName() {
		return this.stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public short getStageProbability() {
		return this.stageProbability;
	}

	public void setStageProbability(short stageProbability) {
		this.stageProbability = stageProbability;
	}

	public int getStageRank() {
		return this.stageRank;
	}

	public void setStageRank(int stageRank) {
		this.stageRank = stageRank;
	}

}