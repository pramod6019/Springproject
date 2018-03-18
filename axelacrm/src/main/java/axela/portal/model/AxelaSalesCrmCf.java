package axela.portal.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the axela_sales_crm_cf database table.
 * 
 */
@Entity
@Table(name="axela_sales_crm_cf",catalog="axela_1")
@NamedQuery(name="AxelaSalesCrmCf.findAll", query="SELECT a FROM AxelaSalesCrmCf a")
public class AxelaSalesCrmCf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="crmcf_id")
	private int crmcfId;

	@Column(name="crmcf_active")
	private String crmcfActive;

	@Column(name="crmcf_cftype_id")
	private int crmcfCftypeId;

	@Column(name="crmcf_crmdays_id")
	private int crmcfCrmdaysId;

	@Column(name="crmcf_entry_date")
	private String crmcfEntryDate;

	@Column(name="crmcf_entry_id")
	private int crmcfEntryId;

	@Column(name="crmcf_fieldref")
	private String crmcfFieldref;

	@Column(name="crmcf_instruction")
	private String crmcfInstruction;

	@Column(name="crmcf_length_max")
	private int crmcfLengthMax;

	@Column(name="crmcf_length_min")
	private int crmcfLengthMin;

	@Column(name="crmcf_mandatory")
	private String crmcfMandatory;

	@Column(name="crmcf_modified_date")
	private String crmcfModifiedDate;

	@Column(name="crmcf_modified_id")
	private int crmcfModifiedId;

	@Column(name="crmcf_numeric")
	private String crmcfNumeric;

	@Column(name="crmcf_option")
	private String crmcfOption;

	@Column(name="crmcf_print")
	private String crmcfPrint;

	@Column(name="crmcf_rank")
	private int crmcfRank;

	@Column(name="crmcf_refcrmcf_id")
	private int crmcfRefcrmcfId;

	@Column(name="crmcf_refcrmdays_id")
	private int crmcfRefcrmdaysId;

	@Column(name="crmcf_title")
	private String crmcfTitle;

	@Column(name="crmcf_unique")
	private String crmcfUnique;

	@Column(name="crmcf_voc")
	private String crmcfVoc;

	public AxelaSalesCrmCf() {
	}

	public int getCrmcfId() {
		return this.crmcfId;
	}

	public void setCrmcfId(int crmcfId) {
		this.crmcfId = crmcfId;
	}

	public String getCrmcfActive() {
		return this.crmcfActive;
	}

	public void setCrmcfActive(String crmcfActive) {
		this.crmcfActive = crmcfActive;
	}

	public int getCrmcfCftypeId() {
		return this.crmcfCftypeId;
	}

	public void setCrmcfCftypeId(int crmcfCftypeId) {
		this.crmcfCftypeId = crmcfCftypeId;
	}

	public int getCrmcfCrmdaysId() {
		return this.crmcfCrmdaysId;
	}

	public void setCrmcfCrmdaysId(int crmcfCrmdaysId) {
		this.crmcfCrmdaysId = crmcfCrmdaysId;
	}

	public String getCrmcfEntryDate() {
		return this.crmcfEntryDate;
	}

	public void setCrmcfEntryDate(String crmcfEntryDate) {
		this.crmcfEntryDate = crmcfEntryDate;
	}

	public int getCrmcfEntryId() {
		return this.crmcfEntryId;
	}

	public void setCrmcfEntryId(int crmcfEntryId) {
		this.crmcfEntryId = crmcfEntryId;
	}

	public String getCrmcfFieldref() {
		return this.crmcfFieldref;
	}

	public void setCrmcfFieldref(String crmcfFieldref) {
		this.crmcfFieldref = crmcfFieldref;
	}

	public String getCrmcfInstruction() {
		return this.crmcfInstruction;
	}

	public void setCrmcfInstruction(String crmcfInstruction) {
		this.crmcfInstruction = crmcfInstruction;
	}

	public int getCrmcfLengthMax() {
		return this.crmcfLengthMax;
	}

	public void setCrmcfLengthMax(int crmcfLengthMax) {
		this.crmcfLengthMax = crmcfLengthMax;
	}

	public int getCrmcfLengthMin() {
		return this.crmcfLengthMin;
	}

	public void setCrmcfLengthMin(int crmcfLengthMin) {
		this.crmcfLengthMin = crmcfLengthMin;
	}

	public String getCrmcfMandatory() {
		return this.crmcfMandatory;
	}

	public void setCrmcfMandatory(String crmcfMandatory) {
		this.crmcfMandatory = crmcfMandatory;
	}

	public String getCrmcfModifiedDate() {
		return this.crmcfModifiedDate;
	}

	public void setCrmcfModifiedDate(String crmcfModifiedDate) {
		this.crmcfModifiedDate = crmcfModifiedDate;
	}

	public int getCrmcfModifiedId() {
		return this.crmcfModifiedId;
	}

	public void setCrmcfModifiedId(int crmcfModifiedId) {
		this.crmcfModifiedId = crmcfModifiedId;
	}

	public String getCrmcfNumeric() {
		return this.crmcfNumeric;
	}

	public void setCrmcfNumeric(String crmcfNumeric) {
		this.crmcfNumeric = crmcfNumeric;
	}

	public String getCrmcfOption() {
		return this.crmcfOption;
	}

	public void setCrmcfOption(String crmcfOption) {
		this.crmcfOption = crmcfOption;
	}

	public String getCrmcfPrint() {
		return this.crmcfPrint;
	}

	public void setCrmcfPrint(String crmcfPrint) {
		this.crmcfPrint = crmcfPrint;
	}

	public int getCrmcfRank() {
		return this.crmcfRank;
	}

	public void setCrmcfRank(int crmcfRank) {
		this.crmcfRank = crmcfRank;
	}

	public int getCrmcfRefcrmcfId() {
		return this.crmcfRefcrmcfId;
	}

	public void setCrmcfRefcrmcfId(int crmcfRefcrmcfId) {
		this.crmcfRefcrmcfId = crmcfRefcrmcfId;
	}

	public int getCrmcfRefcrmdaysId() {
		return this.crmcfRefcrmdaysId;
	}

	public void setCrmcfRefcrmdaysId(int crmcfRefcrmdaysId) {
		this.crmcfRefcrmdaysId = crmcfRefcrmdaysId;
	}

	public String getCrmcfTitle() {
		return this.crmcfTitle;
	}

	public void setCrmcfTitle(String crmcfTitle) {
		this.crmcfTitle = crmcfTitle;
	}

	public String getCrmcfUnique() {
		return this.crmcfUnique;
	}

	public void setCrmcfUnique(String crmcfUnique) {
		this.crmcfUnique = crmcfUnique;
	}

	public String getCrmcfVoc() {
		return this.crmcfVoc;
	}

	public void setCrmcfVoc(String crmcfVoc) {
		this.crmcfVoc = crmcfVoc;
	}

}