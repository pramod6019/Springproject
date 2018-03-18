package axela.service.model;

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
 * The persistent class for the axela_service_jc_status database table.
 * 
 */
@Entity
@Table(name = "axela_service_jc_status", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceJcStatus.findAll", query = "SELECT a FROM AxelaServiceJcStatus a")
public class AxelaServiceJcStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "jcstatus_id")
	private int jcstatusId;

	@Column(name = "jcstatus_colour")
	private String jcstatusColour;

	@Column(name = "jcstatus_desc")
	private String jcstatusDesc;

	@Column(name = "jcstatus_duehrs")
	private String jcstatusDuehrs;

	@Column(name = "jcstatus_entry_date")
	private Date jcstatusEntryDate;

	@Column(name = "jcstatus_entry_id")
	private int jcstatusEntryId;

	@Column(name = "jcstatus_modified_date")
	private Date jcstatusModifiedDate;

	@Column(name = "jcstatus_modified_id")
	private int jcstatusModifiedId;

	@Column(name = "jcstatus_name")
	private String jcstatusName;

	@Column(name = "jcstatus_rank")
	private int jcstatusRank;

	@Column(name = "jcstatus_trigger1_hrs")
	private String jcstatusTrigger1Hrs;

	@Column(name = "jcstatus_trigger2_hrs")
	private String jcstatusTrigger2Hrs;

	@Column(name = "jcstatus_trigger3_hrs")
	private String jcstatusTrigger3Hrs;

	@Column(name = "jcstatus_trigger4_hrs")
	private String jcstatusTrigger4Hrs;

	@Column(name = "jcstatus_trigger5_hrs")
	private String jcstatusTrigger5Hrs;

	public AxelaServiceJcStatus() {
	}

	public AxelaServiceJcStatus(int jcstatusId, String jcstatusName) {
		super();
		this.jcstatusId = jcstatusId;
		this.jcstatusName = jcstatusName;
	}

	public int getJcstatusId() {
		return this.jcstatusId;
	}

	public void setJcstatusId(int jcstatusId) {
		this.jcstatusId = jcstatusId;
	}

	public String getJcstatusColour() {
		return this.jcstatusColour;
	}

	public void setJcstatusColour(String jcstatusColour) {
		this.jcstatusColour = jcstatusColour;
	}

	public String getJcstatusDesc() {
		return this.jcstatusDesc;
	}

	public void setJcstatusDesc(String jcstatusDesc) {
		this.jcstatusDesc = jcstatusDesc;
	}

	public String getJcstatusDuehrs() {
		return this.jcstatusDuehrs;
	}

	public void setJcstatusDuehrs(String jcstatusDuehrs) {
		this.jcstatusDuehrs = jcstatusDuehrs;
	}

	public Date getJcstatusEntryDate() {
		return this.jcstatusEntryDate;
	}

	public void setJcstatusEntryDate(Date jcstatusEntryDate) {
		this.jcstatusEntryDate = jcstatusEntryDate;
	}

	public int getJcstatusEntryId() {
		return this.jcstatusEntryId;
	}

	public void setJcstatusEntryId(int jcstatusEntryId) {
		this.jcstatusEntryId = jcstatusEntryId;
	}

	public Date getJcstatusModifiedDate() {
		return this.jcstatusModifiedDate;
	}

	public void setJcstatusModifiedDate(Date jcstatusModifiedDate) {
		this.jcstatusModifiedDate = jcstatusModifiedDate;
	}

	public int getJcstatusModifiedId() {
		return this.jcstatusModifiedId;
	}

	public void setJcstatusModifiedId(int jcstatusModifiedId) {
		this.jcstatusModifiedId = jcstatusModifiedId;
	}

	public String getJcstatusName() {
		return this.jcstatusName;
	}

	public void setJcstatusName(String jcstatusName) {
		this.jcstatusName = jcstatusName;
	}

	public int getJcstatusRank() {
		return this.jcstatusRank;
	}

	public void setJcstatusRank(int jcstatusRank) {
		this.jcstatusRank = jcstatusRank;
	}

	public String getJcstatusTrigger1Hrs() {
		return this.jcstatusTrigger1Hrs;
	}

	public void setJcstatusTrigger1Hrs(String jcstatusTrigger1Hrs) {
		this.jcstatusTrigger1Hrs = jcstatusTrigger1Hrs;
	}

	public String getJcstatusTrigger2Hrs() {
		return this.jcstatusTrigger2Hrs;
	}

	public void setJcstatusTrigger2Hrs(String jcstatusTrigger2Hrs) {
		this.jcstatusTrigger2Hrs = jcstatusTrigger2Hrs;
	}

	public String getJcstatusTrigger3Hrs() {
		return this.jcstatusTrigger3Hrs;
	}

	public void setJcstatusTrigger3Hrs(String jcstatusTrigger3Hrs) {
		this.jcstatusTrigger3Hrs = jcstatusTrigger3Hrs;
	}

	public String getJcstatusTrigger4Hrs() {
		return this.jcstatusTrigger4Hrs;
	}

	public void setJcstatusTrigger4Hrs(String jcstatusTrigger4Hrs) {
		this.jcstatusTrigger4Hrs = jcstatusTrigger4Hrs;
	}

	public String getJcstatusTrigger5Hrs() {
		return this.jcstatusTrigger5Hrs;
	}

	public void setJcstatusTrigger5Hrs(String jcstatusTrigger5Hrs) {
		this.jcstatusTrigger5Hrs = jcstatusTrigger5Hrs;
	}

}