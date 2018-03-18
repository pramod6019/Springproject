//package axela.portal.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
//
///**
// * The persistent class for the axela_inventory_cat database table.
// * 
// */
//@Entity
//@Table(name = "axela_inventory_cat", catalog = "axela_1")
//@NamedQuery(name = "AxelaInventoryCat.findAll", query = "SELECT a FROM AxelaInventoryCat a")
//public class AxelaInventoryCat implements Serializable {
//	private static final long serialVersionUID = 1L;
//	@Id
//	@Column(name = "cat_id")
//	private int catId;
//	@Column(name = "cat_active")
//	private String catActive;
//	@Column(name = "cat_entry_date")
//	private String catEntryDate;
//	@Column(name = "cat_entry_id")
//	private int catEntryId;
//	@Column(name = "cat_modified_date")
//	private String catModifiedDate;
//	@Column(name = "cat_modified_id")
//	private int catModifiedId;
//	@Column(name = "cat_name")
//	private String catName;
//	@Column(name = "cat_parent_id")
//	private int catParentId;
//
//	public AxelaInventoryCat() {
//	}
//
//	public int getCatId() {
//		return this.catId;
//	}
//
//	public void setCatId(int catId) {
//		this.catId = catId;
//	}
//
//	public String getCatActive() {
//		return this.catActive;
//	}
//
//	public void setCatActive(String catActive) {
//		this.catActive = catActive;
//	}
//
//	public String getCatEntryDate() {
//		return this.catEntryDate;
//	}
//
//	public void setCatEntryDate(String catEntryDate) {
//		this.catEntryDate = catEntryDate;
//	}
//
//	public int getCatEntryId() {
//		return this.catEntryId;
//	}
//
//	public void setCatEntryId(int catEntryId) {
//		this.catEntryId = catEntryId;
//	}
//
//	public String getCatModifiedDate() {
//		return this.catModifiedDate;
//	}
//
//	public void setCatModifiedDate(String catModifiedDate) {
//		this.catModifiedDate = catModifiedDate;
//	}
//
//	public int getCatModifiedId() {
//		return this.catModifiedId;
//	}
//
//	public void setCatModifiedId(int catModifiedId) {
//		this.catModifiedId = catModifiedId;
//	}
//
//	public String getCatName() {
//		return this.catName;
//	}
//
//	public void setCatName(String catName) {
//		this.catName = catName;
//	}
//
//	public int getCatParentId() {
//		return this.catParentId;
//	}
//
//	public void setCatParentId(int catParentId) {
//		this.catParentId = catParentId;
//	}
//
// }