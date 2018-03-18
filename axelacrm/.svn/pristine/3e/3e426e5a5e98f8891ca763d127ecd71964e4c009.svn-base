package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_formattime database table.
 * 
 */
@Entity
@Table(name = "axela_formattime", catalog = "axela")
@NamedQuery(name = "AxelaFormattime.findAll", query = "SELECT a FROM AxelaFormattime a")
public class AxelaFormattime implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "formattime_id")
	private int formattimeId;

	@Column(name = "formattime_name")
	private String formattimeName;

	@Column(name = "formattime_timepicker")
	private String formattimeTimepicker;

	public AxelaFormattime() {
	}

	public int getFormattimeId() {
		return this.formattimeId;
	}

	public void setFormattimeId(int formattimeId) {
		this.formattimeId = formattimeId;
	}

	public String getFormattimeName() {
		return this.formattimeName;
	}

	public void setFormattimeName(String formattimeName) {
		this.formattimeName = formattimeName;
	}

	public String getFormattimeTimepicker() {
		return this.formattimeTimepicker;
	}

	public void setFormattimeTimepicker(String formattimeTimepicker) {
		this.formattimeTimepicker = formattimeTimepicker;
	}

}