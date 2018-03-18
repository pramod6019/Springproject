package axela.helpdesk.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * The persistent class for the axela_faq_cat database table.
 * 
 */
@Entity
@Table(name = "axela_faq_cat", catalog = "axela_1")
@NamedQuery(name = "AxelaFaqCat.findAll", query = "SELECT a FROM AxelaFaqCat a")
public class AxelaFaqCat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cat_id")
	private int catId;

	@Column(name = "cat_entry_date")
	private String catEntryDate;

	@Column(name = "cat_entry_id")
	private int catEntryId;

	@Column(name = "cat_modified_date")
	private String catModifiedDate;

	@Column(name = "cat_modified_id")
	private int catModifiedId;

	@Column(name = "cat_name")
	private String catName;

	@OneToMany(mappedBy = "axelaFaqCat", cascade = CascadeType.ALL)
	@NotFound(action = NotFoundAction.IGNORE)
	private List<AxelaFaq> axelaFaq;

	public AxelaFaqCat() {
	}

	public int getCatId() {
		return this.catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatEntryDate() {
		return this.catEntryDate;
	}

	public void setCatEntryDate(String catEntryDate) {
		this.catEntryDate = catEntryDate;
	}

	public int getCatEntryId() {
		return this.catEntryId;
	}

	public void setCatEntryId(int catEntryId) {
		this.catEntryId = catEntryId;
	}

	public String getCatModifiedDate() {
		return this.catModifiedDate;
	}

	public void setCatModifiedDate(String catModifiedDate) {
		this.catModifiedDate = catModifiedDate;
	}

	public int getCatModifiedId() {
		return this.catModifiedId;
	}

	public void setCatModifiedId(int catModifiedId) {
		this.catModifiedId = catModifiedId;
	}

	public String getCatName() {
		return this.catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

}