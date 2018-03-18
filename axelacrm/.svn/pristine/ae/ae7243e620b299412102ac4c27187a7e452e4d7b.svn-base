package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_formatdate database table.
 * 
 */
@Entity
@Table(name = "axela_formatdate", catalog = "axela")
@NamedQuery(name = "AxelaFormatdate.findAll", query = "SELECT a FROM AxelaFormatdate a")
public class AxelaFormatdate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "formatdate_id")
	private int formatdateId;

	@Column(name = "formatdate_datepicker")
	private String formatdateDatepicker;

	@Column(name = "formatdate_name")
	private String formatdateName;

	public AxelaFormatdate() {
	}

	public int getFormatdateId() {
		return this.formatdateId;
	}

	public void setFormatdateId(int formatdateId) {
		this.formatdateId = formatdateId;
	}

	public String getFormatdateDatepicker() {
		return this.formatdateDatepicker;
	}

	public void setFormatdateDatepicker(String formatdateDatepicker) {
		this.formatdateDatepicker = formatdateDatepicker;
	}

	public String getFormatdateName() {
		return this.formatdateName;
	}

	public void setFormatdateName(String formatdateName) {
		this.formatdateName = formatdateName;
	}

}