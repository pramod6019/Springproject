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
 * The persistent class for the axela_finance_comp database table.
 * 
 */
@Entity
@Table(name = "axela_finance_comp", catalog = "axela_1")
@NamedQuery(name = "AxelaFinanceComp.findAll", query = "SELECT a FROM AxelaFinanceComp a")
public class AxelaFinanceComp implements Serializable {
	private static final long serialVersionUID = 1L;

	public AxelaFinanceComp(
			int fincompId,
			String fincompName) {
		super();
		this.fincompId = fincompId;
		this.fincompName = fincompName;
	}

	@Id
	@Column(name = "fincomp_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fincompId;

	@Column(name = "fincomp_active")
	private String fincompActive;

	@Column(name = "fincomp_entry_date")
	private Date fincompEntryDate;

	@Column(name = "fincomp_entry_id")
	private int fincompEntryId;

	@Column(name = "fincomp_modified_date")
	private Date fincompModifiedDate;

	@Column(name = "fincomp_modified_id")
	private int fincompModifiedId;

	@Column(name = "fincomp_name")
	private String fincompName;

	public AxelaFinanceComp() {
	}

	public int getFincompId() {
		return this.fincompId;
	}

	public void setFincompId(int fincompId) {
		this.fincompId = fincompId;
	}

	public String getFincompActive() {
		return this.fincompActive;
	}

	public void setFincompActive(String fincompActive) {
		this.fincompActive = fincompActive;
	}

	public Date getFincompEntryDate() {
		return this.fincompEntryDate;
	}

	public void setFincompEntryDate(Date fincompEntryDate) {
		this.fincompEntryDate = fincompEntryDate;
	}

	public int getFincompEntryId() {
		return this.fincompEntryId;
	}

	public void setFincompEntryId(int fincompEntryId) {
		this.fincompEntryId = fincompEntryId;
	}

	public Date getFincompModifiedDate() {
		return this.fincompModifiedDate;
	}

	public void setFincompModifiedDate(Date fincompModifiedDate) {
		this.fincompModifiedDate = fincompModifiedDate;
	}

	public int getFincompModifiedId() {
		return this.fincompModifiedId;
	}

	public void setFincompModifiedId(int fincompModifiedId) {
		this.fincompModifiedId = fincompModifiedId;
	}

	public String getFincompName() {
		return this.fincompName;
	}

	public void setFincompName(String fincompName) {
		this.fincompName = fincompName;
	}

}