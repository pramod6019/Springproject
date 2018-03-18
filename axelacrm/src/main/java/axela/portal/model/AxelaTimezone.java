package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the axela_timezone database table.
 * 
 */
@Entity
@Table(name = "axela_timezone", catalog = "axela")
@NamedQuery(name = "AxelaTimezone.findAll", query = "SELECT a FROM AxelaTimezone a")
public class AxelaTimezone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "timezone_id")
	private int timezoneId;

	@Column(name = "timezone_entry_date")
	private String timezoneEntryDate;

	@Column(name = "timezone_entry_id")
	private int timezoneEntryId;

	@Column(name = "timezone_modified_date")
	private String timezoneModifiedDate;

	@Column(name = "timezone_modified_id")
	private int timezoneModifiedId;

	@Column(name = "timezone_name")
	private String timezoneName;

	@Column(name = "timezone_value")
	private int timezoneValue;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "timezone_id", referencedColumnName = "config_timezone_id", insertable = false, updatable = false)
	private AxelaConfig axelaConfig;

	public AxelaTimezone() {
	}

	public int getTimezoneId() {
		return this.timezoneId;
	}

	public void setTimezoneId(int timezoneId) {
		this.timezoneId = timezoneId;
	}

	public String getTimezoneEntryDate() {
		return this.timezoneEntryDate;
	}

	public void setTimezoneEntryDate(String timezoneEntryDate) {
		this.timezoneEntryDate = timezoneEntryDate;
	}

	public int getTimezoneEntryId() {
		return this.timezoneEntryId;
	}

	public void setTimezoneEntryId(int timezoneEntryId) {
		this.timezoneEntryId = timezoneEntryId;
	}

	public String getTimezoneModifiedDate() {
		return this.timezoneModifiedDate;
	}

	public void setTimezoneModifiedDate(String timezoneModifiedDate) {
		this.timezoneModifiedDate = timezoneModifiedDate;
	}

	public int getTimezoneModifiedId() {
		return this.timezoneModifiedId;
	}

	public void setTimezoneModifiedId(int timezoneModifiedId) {
		this.timezoneModifiedId = timezoneModifiedId;
	}

	public String getTimezoneName() {
		return this.timezoneName;
	}

	public void setTimezoneName(String timezoneName) {
		this.timezoneName = timezoneName;
	}

	public int getTimezoneValue() {
		return this.timezoneValue;
	}

	public void setTimezoneValue(int timezoneValue) {
		this.timezoneValue = timezoneValue;
	}

}