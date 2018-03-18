package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_formatdigit database table.
 * 
 */
@Entity
@Table(name = "axela_formatdigit", catalog = "axela")
@NamedQuery(name = "AxelaFormatdigit.findAll", query = "SELECT a FROM AxelaFormatdigit a")
public class AxelaFormatdigit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "formatdigit_id")
	private int formatdigitId;

	@Column(name = "formatdigit_name")
	private String formatdigitName;

	public AxelaFormatdigit() {
	}

	public int getFormatdigitId() {
		return this.formatdigitId;
	}

	public void setFormatdigitId(int formatdigitId) {
		this.formatdigitId = formatdigitId;
	}

	public String getFormatdigitName() {
		return this.formatdigitName;
	}

	public void setFormatdigitName(String formatdigitName) {
		this.formatdigitName = formatdigitName;
	}

}