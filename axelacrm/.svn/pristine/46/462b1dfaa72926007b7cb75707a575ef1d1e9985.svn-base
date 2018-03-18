package axela.service.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_service_jc_img database table.
 * 
 */
@Entity
@Table(name = "axela_service_jc_img", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceJcImg.findAll", query = "SELECT a FROM AxelaServiceJcImg a")
public class AxelaServiceJcImg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "img_id")
	private int imgId;

	@Column(name = "img_entry_date")
	private Date imgEntryDate;

	@Column(name = "img_entry_id")
	private int imgEntryId;

	@Column(name = "img_jc_id")
	private int imgJcId;

	@Column(name = "img_modified_date")
	private Date imgModifiedDate;

	@Column(name = "img_modified_id")
	private int imgModifiedId;

	@Lob
	@Column(name = "img_pic")
	private byte[] imgPic;

	@Column(name = "img_rank")
	private int imgRank;

	@Column(name = "img_title")
	private String imgTitle;

	@Column(name = "img_value")
	private String imgValue;

	public AxelaServiceJcImg() {
	}

	public int getImgId() {
		return this.imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public Date getImgEntryDate() {
		return this.imgEntryDate;
	}

	public void setImgEntryDate(Date imgEntryDate) {
		this.imgEntryDate = imgEntryDate;
	}

	public int getImgEntryId() {
		return this.imgEntryId;
	}

	public void setImgEntryId(int imgEntryId) {
		this.imgEntryId = imgEntryId;
	}

	public int getImgJcId() {
		return this.imgJcId;
	}

	public void setImgJcId(int imgJcId) {
		this.imgJcId = imgJcId;
	}

	public Date getImgModifiedDate() {
		return this.imgModifiedDate;
	}

	public void setImgModifiedDate(Date imgModifiedDate) {
		this.imgModifiedDate = imgModifiedDate;
	}

	public int getImgModifiedId() {
		return this.imgModifiedId;
	}

	public void setImgModifiedId(int imgModifiedId) {
		this.imgModifiedId = imgModifiedId;
	}

	public byte[] getImgPic() {
		return this.imgPic;
	}

	public void setImgPic(byte[] imgPic) {
		this.imgPic = imgPic;
	}

	public int getImgRank() {
		return this.imgRank;
	}

	public void setImgRank(int imgRank) {
		this.imgRank = imgRank;
	}

	public String getImgTitle() {
		return this.imgTitle;
	}

	public void setImgTitle(String imgTitle) {
		this.imgTitle = imgTitle;
	}

	public String getImgValue() {
		return this.imgValue;
	}

	public void setImgValue(String imgValue) {
		this.imgValue = imgValue;
	}

}