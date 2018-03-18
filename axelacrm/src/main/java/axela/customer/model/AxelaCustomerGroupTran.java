package axela.customer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_customer_group_trans database table.
 * 
 */
@Entity
@Table(name = "axela_customer_group_trans", catalog = "axela_1")
@NamedQuery(name = "AxelaCustomerGroupTran.findAll", query = "SELECT a FROM AxelaCustomerGroupTran a")
public class AxelaCustomerGroupTran implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trans_group_id")
	private int transGroupId;

	@Column(name = "trans_customer_id")
	private int transCustomerId;

	@Column(name = "trans_transgroup_id")
	private int transTransgroupId;

	public AxelaCustomerGroupTran() {
	}

	public int getTransGroupId() {
		return this.transGroupId;
	}

	public void setTransGroupId(int transGroupId) {
		this.transGroupId = transGroupId;
	}

	public int getTransCustomerId() {
		return this.transCustomerId;
	}

	public void setTransCustomerId(int transCustomerId) {
		this.transCustomerId = transCustomerId;
	}

	public int getTransTransgroupId() {
		return this.transTransgroupId;
	}

	public void setTransTransgroupId(int transTransgroupId) {
		this.transTransgroupId = transTransgroupId;
	}

}