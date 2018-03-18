package axela.service.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_service_contract_service database table.
 * 
 */
@Entity
@Table(name = "axela_service_contract_service", catalog = "axela_1")
@NamedQuery(name = "AxelaServiceContractService.findAll", query = "SELECT a FROM AxelaServiceContractService a")
public class AxelaServiceContractService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "service_id")
	private int serviceId;

	@Column(name = "service_contract_id")
	private int serviceContractId;

	@Column(name = "service_desc")
	private String serviceDesc;

	@Column(name = "service_emp_id")
	private int serviceEmpId;

	@Column(name = "service_entry_date")
	private String serviceEntryDate;

	@Column(name = "service_entry_id")
	private int serviceEntryId;

	@Column(name = "service_modified_date")
	private String serviceModifiedDate;

	@Column(name = "service_modified_id")
	private int serviceModifiedId;

	@Column(name = "service_queue_id")
	private int serviceQueueId;

	@Column(name = "service_servicetype_id")
	private int serviceServicetypeId;

	@Column(name = "service_time")
	private String serviceTime;

	public AxelaServiceContractService() {
	}

	public int getServiceId() {
		return this.serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public int getServiceContractId() {
		return this.serviceContractId;
	}

	public void setServiceContractId(int serviceContractId) {
		this.serviceContractId = serviceContractId;
	}

	public String getServiceDesc() {
		return this.serviceDesc;
	}

	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}

	public int getServiceEmpId() {
		return this.serviceEmpId;
	}

	public void setServiceEmpId(int serviceEmpId) {
		this.serviceEmpId = serviceEmpId;
	}

	public String getServiceEntryDate() {
		return this.serviceEntryDate;
	}

	public void setServiceEntryDate(String serviceEntryDate) {
		this.serviceEntryDate = serviceEntryDate;
	}

	public int getServiceEntryId() {
		return this.serviceEntryId;
	}

	public void setServiceEntryId(int serviceEntryId) {
		this.serviceEntryId = serviceEntryId;
	}

	public String getServiceModifiedDate() {
		return this.serviceModifiedDate;
	}

	public void setServiceModifiedDate(String serviceModifiedDate) {
		this.serviceModifiedDate = serviceModifiedDate;
	}

	public int getServiceModifiedId() {
		return this.serviceModifiedId;
	}

	public void setServiceModifiedId(int serviceModifiedId) {
		this.serviceModifiedId = serviceModifiedId;
	}

	public int getServiceQueueId() {
		return this.serviceQueueId;
	}

	public void setServiceQueueId(int serviceQueueId) {
		this.serviceQueueId = serviceQueueId;
	}

	public int getServiceServicetypeId() {
		return this.serviceServicetypeId;
	}

	public void setServiceServicetypeId(int serviceServicetypeId) {
		this.serviceServicetypeId = serviceServicetypeId;
	}

	public String getServiceTime() {
		return this.serviceTime;
	}

	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}

}