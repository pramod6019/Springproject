//package axela.sales.model;
//
//import java.io.Serializable;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.NotFound;
//import org.hibernate.annotations.NotFoundAction;
//
///**
// * The persistent class for the axela_sales_oppr_status database table.
// * 
// */
//@Entity
//@Table(name = "axela_sales_oppr_status")
//@NamedQuery(name = "AxelaSalesOpprStatus.findAll", query = "SELECT a FROM AxelaSalesOpprStatus a")
//public class AxelaSalesOpprStatus implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@Column(name = "status_id")
//	private int statusId;
//
//	@Column(name = "status_name")
//	private String statusName;
//
//	public AxelaSalesOpprStatus() {
//	}
//
//	public int getStatusId() {
//		return this.statusId;
//	}
//
//	public void setStatusId(int statusId) {
//		this.statusId = statusId;
//	}
//
//	public String getStatusName() {
//		return this.statusName;
//	}
//
//	public void setStatusName(String statusName) {
//		this.statusName = statusName;
//	}
//	@OneToMany(mappedBy = "axelaSalesOpprStatus", cascade = CascadeType.ALL)
//	@NotFound(action = NotFoundAction.IGNORE)
//	private List<AxelaSalesOppr> axelaSalesOppr;
// }