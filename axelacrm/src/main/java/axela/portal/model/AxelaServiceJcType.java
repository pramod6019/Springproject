//package axela.portal.model;
//
//import java.io.Serializable;
//import javax.persistence.*;
//
//
///**
// * The persistent class for the axela_service_jc_type database table.
// * 
// */
//@Entity
//@Table(name="axela_service_jc_type")
//@NamedQuery(name="AxelaServiceJcType.findAll", query="SELECT a FROM AxelaServiceJcType a")
//public class AxelaServiceJcType implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@Column(name="jctype_id")
//	private int jctypeId;
//
//	@Column(name="jctype_entry_date")
//	private String jctypeEntryDate;
//
//	@Column(name="jctype_entry_id")
//	private int jctypeEntryId;
//
//	@Column(name="jctype_modified_date")
//	private String jctypeModifiedDate;
//
//	@Column(name="jctype_modified_id")
//	private int jctypeModifiedId;
//
//	@Column(name="jctype_name")
//	private String jctypeName;
//
//	public AxelaServiceJcType() {
//	}
//
//	public int getJctypeId() {
//		return this.jctypeId;
//	}
//
//	public void setJctypeId(int jctypeId) {
//		this.jctypeId = jctypeId;
//	}
//
//	public String getJctypeEntryDate() {
//		return this.jctypeEntryDate;
//	}
//
//	public void setJctypeEntryDate(String jctypeEntryDate) {
//		this.jctypeEntryDate = jctypeEntryDate;
//	}
//
//	public int getJctypeEntryId() {
//		return this.jctypeEntryId;
//	}
//
//	public void setJctypeEntryId(int jctypeEntryId) {
//		this.jctypeEntryId = jctypeEntryId;
//	}
//
//	public String getJctypeModifiedDate() {
//		return this.jctypeModifiedDate;
//	}
//
//	public void setJctypeModifiedDate(String jctypeModifiedDate) {
//		this.jctypeModifiedDate = jctypeModifiedDate;
//	}
//
//	public int getJctypeModifiedId() {
//		return this.jctypeModifiedId;
//	}
//
//	public void setJctypeModifiedId(int jctypeModifiedId) {
//		this.jctypeModifiedId = jctypeModifiedId;
//	}
//
//	public String getJctypeName() {
//		return this.jctypeName;
//	}
//
//	public void setJctypeName(String jctypeName) {
//		this.jctypeName = jctypeName;
//	}
//
// }