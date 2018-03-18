package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the axela_bill_loyaltycard database table.
 * 
 */
@Entity
@Table(name = "axela_bill_loyaltycard", catalog = "axela_1")
@NamedQuery(name = "AxelaBillLoyaltycard.findAll", query = "SELECT a FROM AxelaBillLoyaltycard a")
public class AxelaBillLoyaltycard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "loyaltycard_id")
	private int loyaltycardId;

	@Column(name = "loyaltycard_active")
	private String loyaltycardActive;

	@Column(name = "loyaltycard_entry_date")
	private String loyaltycardEntryDate;

	@Column(name = "loyaltycard_entry_id")
	private int loyaltycardEntryId;

	@Column(name = "loyaltycard_modified_date")
	private String loyaltycardModifiedDate;

	@Column(name = "loyaltycard_modified_id")
	private int loyaltycardModifiedId;

	@Column(name = "loyaltycard_name")
	private String loyaltycardName;

	public AxelaBillLoyaltycard() {
	}

	public int getLoyaltycardId() {
		return this.loyaltycardId;
	}

	public void setLoyaltycardId(int loyaltycardId) {
		this.loyaltycardId = loyaltycardId;
	}

	public String getLoyaltycardActive() {
		return this.loyaltycardActive;
	}

	public void setLoyaltycardActive(String loyaltycardActive) {
		this.loyaltycardActive = loyaltycardActive;
	}

	public String getLoyaltycardEntryDate() {
		return this.loyaltycardEntryDate;
	}

	public void setLoyaltycardEntryDate(String loyaltycardEntryDate) {
		this.loyaltycardEntryDate = loyaltycardEntryDate;
	}

	public int getLoyaltycardEntryId() {
		return this.loyaltycardEntryId;
	}

	public void setLoyaltycardEntryId(int loyaltycardEntryId) {
		this.loyaltycardEntryId = loyaltycardEntryId;
	}

	public String getLoyaltycardModifiedDate() {
		return this.loyaltycardModifiedDate;
	}

	public void setLoyaltycardModifiedDate(String loyaltycardModifiedDate) {
		this.loyaltycardModifiedDate = loyaltycardModifiedDate;
	}

	public int getLoyaltycardModifiedId() {
		return this.loyaltycardModifiedId;
	}

	public void setLoyaltycardModifiedId(int loyaltycardModifiedId) {
		this.loyaltycardModifiedId = loyaltycardModifiedId;
	}

	public String getLoyaltycardName() {
		return this.loyaltycardName;
	}

	public void setLoyaltycardName(String loyaltycardName) {
		this.loyaltycardName = loyaltycardName;
	}

}