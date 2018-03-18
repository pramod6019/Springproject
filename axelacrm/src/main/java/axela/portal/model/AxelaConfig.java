package axela.portal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the axela_config database table.
 * 
 */
@Entity
@Table(name = "axela_config", catalog = AxelaConfig.comp_db)
@NamedQuery(name = "AxelaConfig.findAll", query = "SELECT a FROM AxelaConfig a")
public class AxelaConfig implements Serializable {
	private static final long serialVersionUID = 1L;

	protected static final String comp_db = "axela_1";

	@Transient
	private String compModulePm = "";
	@Transient
	private String compSmsEnable = "";
	@Transient
	private String compEmailEnable = "";
	@Transient
	private String empEmail1 = "";
	@Transient
	private String empEmail2 = "";
	@Transient
	private String empName = "";
	@Transient
	private String empMobile1 = "";
	@Transient
	private String empMobile2 = "";
	@Transient
	private String empmail1 = "";

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "config_timezone_id", referencedColumnName = "timezone_id", insertable = false, updatable = false)
	private AxelaTimezone axelaTimezone;

	public String getConfigHelpDeskTicketCat() {
		return configHelpDeskTicketCat;
	}

	public void setConfigHelpDeskTicketCat(String configHelpDeskTicketCat) {
		this.configHelpDeskTicketCat = configHelpDeskTicketCat;
	}

	public String getConfigHelpDeskTicketRefno() {
		return configHelpDeskTicketRefno;
	}

	public void setConfigHelpDeskTicketRefno(String configHelpDeskTicketRefno) {
		this.configHelpDeskTicketRefno = configHelpDeskTicketRefno;
	}

	public String getConfigHelpdeskTicketType() {
		return configHelpdeskTicketType;
	}

	public void setConfigHelpdeskTicketType(String configHelpdeskTicketType) {
		this.configHelpdeskTicketType = configHelpdeskTicketType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "config_service_ticket_cat")
	private String configHelpDeskTicketCat;

	@Column(name = "config_service_ticket_refno")
	private String configHelpDeskTicketRefno;

	@Column(name = "config_service_ticket_type")
	private String configHelpdeskTicketType;

	public String getCompModulePm() {
		return compModulePm;
	}

	public void setCompModulePm(String compModulePm) {
		this.compModulePm = compModulePm;
	}

	public String getCompSmsEnable() {
		return compSmsEnable;
	}

	public void setCompSmsEnable(String compSmsEnable) {
		this.compSmsEnable = compSmsEnable;
	}

	public String getCompEmailEnable() {
		return compEmailEnable;
	}

	public void setCompEmailEnable(String compEmailEnable) {
		this.compEmailEnable = compEmailEnable;
	}

	public String getEmpEmail1() {
		return empEmail1;
	}

	public void setEmpEmail1(String empEmail1) {
		this.empEmail1 = empEmail1;
	}

	public String getEmpEmail2() {
		return empEmail2;
	}

	public void setEmpEmail2(String empEmail2) {
		this.empEmail2 = empEmail2;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpMobile1() {
		return empMobile1;
	}

	public void setEmpMobile1(String empMobile1) {
		this.empMobile1 = empMobile1;
	}

	public String getEmpMobile2() {
		return empMobile2;
	}

	public void setEmpMobile2(String empMobile2) {
		this.empMobile2 = empMobile2;
	}

	public String getEmpmail1() {
		return empmail1;
	}

	public void setEmpmail1(String empmail1) {
		this.empmail1 = empmail1;
	}

	@Id
	@Column(name = "config_id")
	private int configId;

	@Column(name = "config_actleadtime")
	private double configActleadtime;

	@Column(name = "config_admin_email")
	private String configAdminEmail;

	@Column(name = "config_assistance_email")
	private String configAssistanceEmail;

	@Column(name = "config_assistance_no")
	private String configAssistanceNo;

	@Column(name = "config_balance_due_email_enable")
	private String configBalanceDueEmailEnable;

	@Lob
	@Column(name = "config_balance_due_email_format")
	private String configBalanceDueEmailFormat;

	@Column(name = "config_balance_due_email_sub")
	private String configBalanceDueEmailSub;

	@Column(name = "config_balance_due_sms_enable")
	private String configBalanceDueSmsEnable;

	@Column(name = "config_balance_due_sms_format")
	private String configBalanceDueSmsFormat;

	@Column(name = "config_balance_overdue_email_enable")
	private String configBalanceOverdueEmailEnable;

	@Lob
	@Column(name = "config_balance_overdue_email_format")
	private String configBalanceOverdueEmailFormat;

	@Column(name = "config_balance_overdue_email_sub")
	private String configBalanceOverdueEmailSub;

	@Column(name = "config_balance_overdue_sms_enable")
	private String configBalanceOverdueSmsEnable;

	@Column(name = "config_balance_overdue_sms_format")
	private String configBalanceOverdueSmsFormat;

	@Column(name = "config_bill_email_enable")
	private String configBillEmailEnable;

	@Lob
	@Column(name = "config_bill_email_format")
	private String configBillEmailFormat;

	@Column(name = "config_bill_email_sub")
	private String configBillEmailSub;

	@Column(name = "config_bill_sms_enable")
	private String configBillSmsEnable;

	@Column(name = "config_bill_sms_format")
	private String configBillSmsFormat;

	@Column(name = "config_birthday_wishes")
	private String configBirthdayWishes;

	@Column(name = "config_currency_id")
	private int configCurrencyId;

	@Column(name = "config_customer_address")
	private String configCustomerAddress;

	@Column(name = "config_customer_duplicate")
	private String configCustomerDuplicate;

	@Column(name = "config_customer_dupnames")
	private String configCustomerDupnames;

	@Column(name = "config_customer_name")
	private String configCustomerName;

	@Column(name = "config_customer_sob")
	private String configCustomerSob;

	@Column(name = "config_customer_soe")
	private String configCustomerSoe;

	@Column(name = "config_dealer_jobcard_dealerexe")
	private String configDealerJobcardDealerexe;

	@Column(name = "config_dealer_jobcard_dealerexe_mandatory")
	private String configDealerJobcardDealerexeMandatory;

	@Column(name = "config_dealer_jobcard_dealerexe_title")
	private String configDealerJobcardDealerexeTitle;

	@Column(name = "config_dealer_jobcard_refno")
	private String configDealerJobcardRefno;

	@Column(name = "config_dealer_jobcard_technician")
	private String configDealerJobcardTechnician;

	@Column(name = "config_dealer_jobcard_technician_mandatory")
	private String configDealerJobcardTechnicianMandatory;

	@Column(name = "config_dealer_joborder_refno")
	private String configDealerJoborderRefno;

	@Column(name = "config_doc_formats")
	private String configDocFormats;

	@Column(name = "config_doc_size")
	private double configDocSize;

	@Column(name = "config_email_batchcount")
	private int configEmailBatchcount;

	@Column(name = "config_email_enable")
	private String configEmailEnable;

	@Column(name = "config_format_decimal")
	private int configFormatDecimal;

	@Column(name = "config_image_size")
	private double configImageSize;

	@Column(name = "config_inventory_current_stock")
	private String configInventoryCurrentStock;

	@Column(name = "config_inventory_location_name")
	private String configInventoryLocationName;

	@Column(name = "config_inventory_po_refno")
	private String configInventoryPoRefno;

	@Lob
	@Column(name = "config_invoice_desc")
	private String configInvoiceDesc;

	@Column(name = "config_invoice_email_enable")
	private String configInvoiceEmailEnable;

	@Lob
	@Column(name = "config_invoice_email_format")
	private String configInvoiceEmailFormat;

	@Column(name = "config_invoice_email_sub")
	private String configInvoiceEmailSub;

	@Column(name = "config_invoice_prefix")
	private String configInvoicePrefix;

	@Column(name = "config_invoice_reduce_current_stock")
	private String configInvoiceReduceCurrentStock;

	@Column(name = "config_invoice_sms_enable")
	private String configInvoiceSmsEnable;

	@Column(name = "config_invoice_sms_format")
	private String configInvoiceSmsFormat;

	@Lob
	@Column(name = "config_invoice_terms")
	private String configInvoiceTerms;

	@Column(name = "config_jc_delivered_email_enable")
	private String configJcDeliveredEmailEnable;

	@Lob
	@Column(name = "config_jc_delivered_email_format")
	private String configJcDeliveredEmailFormat;

	@Lob
	@Column(name = "config_jc_delivered_email_sub")
	private String configJcDeliveredEmailSub;

	@Column(name = "config_jc_delivered_sms_enable")
	private String configJcDeliveredSmsEnable;

	@Lob
	@Column(name = "config_jc_delivered_sms_format")
	private String configJcDeliveredSmsFormat;

	@Column(name = "config_jc_new_email_enable")
	private String configJcNewEmailEnable;

	@Lob
	@Column(name = "config_jc_new_email_format")
	private String configJcNewEmailFormat;

	@Lob
	@Column(name = "config_jc_new_email_sub")
	private String configJcNewEmailSub;

	@Column(name = "config_jc_new_sms_enable")
	private String configJcNewSmsEnable;

	@Lob
	@Column(name = "config_jc_new_sms_format")
	private String configJcNewSmsFormat;

	@Column(name = "config_jc_ready_email_enable")
	private String configJcReadyEmailEnable;

	@Lob
	@Column(name = "config_jc_ready_email_format")
	private String configJcReadyEmailFormat;

	@Lob
	@Column(name = "config_jc_ready_email_sub")
	private String configJcReadyEmailSub;

	@Column(name = "config_jc_ready_sms_enable")
	private String configJcReadySmsEnable;

	@Lob
	@Column(name = "config_jc_ready_sms_format")
	private String configJcReadySmsFormat;

	@Column(name = "config_lead_email_enable")
	private String configLeadEmailEnable;

	@Lob
	@Column(name = "config_lead_email_exe_format")
	private String configLeadEmailExeFormat;

	@Column(name = "config_lead_email_exe_sub")
	private String configLeadEmailExeSub;

	@Lob
	@Column(name = "config_lead_email_format")
	private String configLeadEmailFormat;

	@Column(name = "config_lead_email_sub")
	private String configLeadEmailSub;

	@Column(name = "config_lead_sms_enable")
	private String configLeadSmsEnable;

	@Column(name = "config_lead_sms_exe_format")
	private String configLeadSmsExeFormat;

	@Column(name = "config_lead_sms_format")
	private String configLeadSmsFormat;

	@Column(name = "config_mail_password")
	private String configMailPassword;

	@Column(name = "config_mail_port")
	private String configMailPort;

	@Column(name = "config_mail_server")
	private String configMailServer;

	@Column(name = "config_mail_ssl")
	private String configMailSsl;

	@Column(name = "config_mail_username")
	private String configMailUsername;

	@Lob
	@Column(name = "config_new_so_email_format")
	private String configNewSoEmailFormat;

	@Column(name = "config_new_so_email_sub")
	private String configNewSoEmailSub;

	@Column(name = "config_oppr_brochure_email_enable")
	private String configOpprBrochureEmailEnable;

	@Lob
	@Column(name = "config_oppr_brochure_email_format")
	private String configOpprBrochureEmailFormat;

	@Column(name = "config_oppr_brochure_email_sub")
	private String configOpprBrochureEmailSub;

	@Column(name = "config_oppr_email_enable")
	private String configOpprEmailEnable;

	@Lob
	@Column(name = "config_oppr_email_exe_format")
	private String configOpprEmailExeFormat;

	@Column(name = "config_oppr_email_exe_sub")
	private String configOpprEmailExeSub;

	@Lob
	@Column(name = "config_oppr_email_format")
	private String configOpprEmailFormat;

	@Column(name = "config_oppr_email_sub")
	private String configOpprEmailSub;

	@Column(name = "config_oppr_projbrochure_email_enable")
	private String configOpprProjbrochureEmailEnable;

	@Lob
	@Column(name = "config_oppr_projbrochure_email_format")
	private String configOpprProjbrochureEmailFormat;

	@Column(name = "config_oppr_projbrochure_email_sub")
	private String configOpprProjbrochureEmailSub;

	@Column(name = "config_oppr_sms_enable")
	private String configOpprSmsEnable;

	@Column(name = "config_oppr_sms_exe_format")
	private String configOpprSmsExeFormat;

	@Column(name = "config_oppr_sms_format")
	private String configOpprSmsFormat;

	@Column(name = "config_pos_bill_msg")
	private String configPosBillMsg;

	@Column(name = "config_pos_bill_width")
	private int configPosBillWidth;

	@Column(name = "config_pos_bill_zerovalue")
	private String configPosBillZerovalue;

	@Column(name = "config_pos_delivery_date")
	private String configPosDeliveryDate;

	@Column(name = "config_pos_delivery_time")
	private int configPosDeliveryTime;

	@Column(name = "config_pos_disc_update")
	private String configPosDiscUpdate;

	@Column(name = "config_pos_neg_qty")
	private String configPosNegQty;

	@Column(name = "config_pos_price_update")
	private String configPosPriceUpdate;

	@Column(name = "config_pos_printbarcode")
	private String configPosPrintbarcode;

	@Column(name = "config_pos_printcounterfoil")
	private String configPosPrintcounterfoil;

	@Column(name = "config_pos_touch")
	private String configPosTouch;

	@Column(name = "config_prod_jc_email_enable")
	private String configProdJcEmailEnable;

	@Lob
	@Column(name = "config_prod_jc_email_format")
	private String configProdJcEmailFormat;

	@Column(name = "config_prod_jc_email_sub")
	private String configProdJcEmailSub;

	@Column(name = "config_prod_joborder_refno")
	private String configProdJoborderRefno;

	@Column(name = "config_prop_actleadtime")
	private int configPropActleadtime;

	@Column(name = "config_prop_amenities_enable")
	private String configPropAmenitiesEnable;

	@Column(name = "config_prop_amenities_visible")
	private String configPropAmenitiesVisible;

	@Column(name = "config_prop_cf_enable")
	private String configPropCfEnable;

	@Column(name = "config_prop_cf_visible")
	private String configPropCfVisible;

	@Column(name = "config_prop_constspec_visible")
	private String configPropConstspecVisible;

	@Column(name = "config_prop_facilities_enable")
	private String configPropFacilitiesEnable;

	@Column(name = "config_prop_facilities_visible")
	private String configPropFacilitiesVisible;

	@Column(name = "config_prop_propsnapshot_enable")
	private String configPropPropsnapshotEnable;

	@Column(name = "config_prop_propsnapshot_visible")
	private String configPropPropsnapshotVisible;

	@Column(name = "config_prop_rentdetails_enable")
	private String configPropRentdetailsEnable;

	@Column(name = "config_prop_rentdetails_visible")
	private String configPropRentdetailsVisible;

	@Lob
	@Column(name = "config_quote_brochure_email_format")
	private String configQuoteBrochureEmailFormat;

	@Column(name = "config_quote_brochure_email_sub")
	private String configQuoteBrochureEmailSub;

	@Lob
	@Column(name = "config_quote_desc")
	private String configQuoteDesc;

	@Column(name = "config_quote_email_enable")
	private String configQuoteEmailEnable;

	@Lob
	@Column(name = "config_quote_email_exe_format")
	private String configQuoteEmailExeFormat;

	@Column(name = "config_quote_email_exe_sub")
	private String configQuoteEmailExeSub;

	@Lob
	@Column(name = "config_quote_email_format")
	private String configQuoteEmailFormat;

	@Column(name = "config_quote_email_sub")
	private String configQuoteEmailSub;

	@Column(name = "config_quote_prefix")
	private String configQuotePrefix;

	@Column(name = "config_quote_sms_enable")
	private String configQuoteSmsEnable;

	@Column(name = "config_quote_sms_format")
	private String configQuoteSmsFormat;

	@Lob
	@Column(name = "config_quote_terms")
	private String configQuoteTerms;

	@Lob
	@Column(name = "config_receipt_desc")
	private String configReceiptDesc;

	@Column(name = "config_receipt_email_enable")
	private String configReceiptEmailEnable;

	@Column(name = "config_receipt_email_format")
	private String configReceiptEmailFormat;

	@Lob
	@Column(name = "config_receipt_email_sub")
	private String configReceiptEmailSub;

	@Column(name = "config_receipt_prefix")
	private String configReceiptPrefix;

	@Column(name = "config_receipt_sms_enable")
	private String configReceiptSmsEnable;

	@Column(name = "config_receipt_sms_format")
	private String configReceiptSmsFormat;

	@Lob
	@Column(name = "config_receipt_terms")
	private String configReceiptTerms;

	@Column(name = "config_refno_enable")
	private String configRefnoEnable;

	@Column(name = "config_sales_balancepayments")
	private String configSalesBalancepayments;

	@Column(name = "config_sales_campaign")
	private String configSalesCampaign;

	@Column(name = "config_sales_enquiry_domain")
	private String configSalesEnquiryDomain;

	@Column(name = "config_sales_enquiry_thankyou_url")
	private String configSalesEnquiryThankyouUrl;

	@Column(name = "config_sales_invoice")
	private String configSalesInvoice;

	@Column(name = "config_sales_invoice_refno")
	private String configSalesInvoiceRefno;

	@Column(name = "config_sales_lead_for_oppr")
	private String configSalesLeadForOppr;

	@Column(name = "config_sales_lead_refno")
	private String configSalesLeadRefno;

	@Column(name = "config_sales_leads")
	private String configSalesLeads;

	@Column(name = "config_sales_oppr")
	private String configSalesOppr;

	@Column(name = "config_sales_oppr_budget")
	private String configSalesOpprBudget;

	@Column(name = "config_sales_oppr_for_quote")
	private String configSalesOpprForQuote;

	@Column(name = "config_sales_oppr_item")
	private String configSalesOpprItem;

	@Column(name = "config_sales_oppr_model")
	private String configSalesOpprModel;

	@Column(name = "config_sales_oppr_name")
	private String configSalesOpprName;

	@Column(name = "config_sales_oppr_project")
	private String configSalesOpprProject;

	@Column(name = "config_sales_oppr_refno")
	private String configSalesOpprRefno;

	@Column(name = "config_sales_quote")
	private String configSalesQuote;

	@Column(name = "config_sales_quote_for_so")
	private String configSalesQuoteForSo;

	@Column(name = "config_sales_quote_refno")
	private String configSalesQuoteRefno;

	@Column(name = "config_sales_receipt_refno")
	private String configSalesReceiptRefno;

	@Column(name = "config_sales_salesorder")
	private String configSalesSalesorder;

	@Column(name = "config_sales_so_for_invoice")
	private String configSalesSoForInvoice;

	@Column(name = "config_sales_so_refno")
	private String configSalesSoRefno;

	@Column(name = "config_sales_sob")
	private String configSalesSob;

	@Column(name = "config_sales_soe")
	private String configSalesSoe;

	@Column(name = "config_sales_target")
	private String configSalesTarget;

	@Column(name = "config_sales_teams")
	private String configSalesTeams;

	@Column(name = "config_service_contract")
	private String configServiceContract;

	@Column(name = "config_service_contract_refno")
	private String configServiceContractRefno;

	@Column(name = "config_service_jobcard_cat")
	private String configServiceJobcardCat;

	@Column(name = "config_service_jobcard_refno")
	private String configServiceJobcardRefno;

	@Column(name = "config_service_jobcard_serialno_mandatory")
	private String configServiceJobcardSerialnoMandatory;

	@Column(name = "config_service_jobcard_type")
	private String configServiceJobcardType;

	// @Column(name = "config_service_ticket")
	// private String configServiceTicket;
	//
	// @Column(name = "config_service_ticket_cat")
	// private String configServiceTicketCat;
	//
	// @Column(name = "config_service_ticket_refno")
	// private String configServiceTicketRefno;
	//
	// @Column(name = "config_service_ticket_type")
	// private String configServiceTicketType;

	@Column(name = "config_sms_batchcount")
	private int configSmsBatchcount;

	@Column(name = "config_sms_enable")
	private String configSmsEnable;

	@Column(name = "config_sms_url")
	private String configSmsUrl;

	@Lob
	@Column(name = "config_so_desc")
	private String configSoDesc;

	@Column(name = "config_so_email_enable")
	private String configSoEmailEnable;

	@Lob
	@Column(name = "config_so_email_exe_format")
	private String configSoEmailExeFormat;

	@Column(name = "config_so_email_exe_sub")
	private String configSoEmailExeSub;

	@Lob
	@Column(name = "config_so_email_format")
	private String configSoEmailFormat;

	@Column(name = "config_so_email_sub")
	private String configSoEmailSub;

	@Column(name = "config_so_mindownpayment")
	private int configSoMindownpayment;

	@Column(name = "config_so_prefix")
	private String configSoPrefix;

	@Column(name = "config_so_sms_enable")
	private String configSoSmsEnable;

	@Column(name = "config_so_sms_exe_format")
	private String configSoSmsExeFormat;

	@Column(name = "config_so_sms_format")
	private String configSoSmsFormat;

	@Lob
	@Column(name = "config_so_terms")
	private String configSoTerms;

	@Column(name = "config_ticket_closed_email_enable")
	private String configTicketClosedEmailEnable;

	@Lob
	@Column(name = "config_ticket_closed_email_exe_format")
	private String configTicketClosedEmailExeFormat;

	@Column(name = "config_ticket_closed_email_exe_sub")
	private String configTicketClosedEmailExeSub;

	@Lob
	@Column(name = "config_ticket_closed_email_format")
	private String configTicketClosedEmailFormat;

	@Column(name = "config_ticket_closed_email_sub")
	private String configTicketClosedEmailSub;

	@Column(name = "config_ticket_closed_sms_enable")
	private String configTicketClosedSmsEnable;

	@Column(name = "config_ticket_closed_sms_exe_format")
	private String configTicketClosedSmsExeFormat;

	@Column(name = "config_ticket_closed_sms_format")
	private String configTicketClosedSmsFormat;

	@Column(name = "config_ticket_followup_email_enable")
	private String configTicketFollowupEmailEnable;

	@Lob
	@Column(name = "config_ticket_followup_email_exe_format")
	private String configTicketFollowupEmailExeFormat;

	@Column(name = "config_ticket_followup_email_exe_sub")
	private String configTicketFollowupEmailExeSub;

	@Lob
	@Column(name = "config_ticket_followup_email_format")
	private String configTicketFollowupEmailFormat;

	@Column(name = "config_ticket_followup_email_sub")
	private String configTicketFollowupEmailSub;

	@Column(name = "config_ticket_followup_sms_enable")
	private String configTicketFollowupSmsEnable;

	@Column(name = "config_ticket_followup_sms_exe_format")
	private String configTicketFollowupSmsExeFormat;

	@Column(name = "config_ticket_followup_sms_format")
	private String configTicketFollowupSmsFormat;

	@Lob
	@Column(name = "config_ticket_jcpsf_email_format")
	private String configTicketJcpsfEmailFormat;

	@Column(name = "config_ticket_jcpsf_email_sub")
	private String configTicketJcpsfEmailSub;

	@Column(name = "config_ticket_new_email_enable")
	private String configTicketNewEmailEnable;

	@Lob
	@Column(name = "config_ticket_new_email_exe_format")
	private String configTicketNewEmailExeFormat;

	@Column(name = "config_ticket_new_email_exe_sub")
	private String configTicketNewEmailExeSub;

	@Lob
	@Column(name = "config_ticket_new_email_format")
	private String configTicketNewEmailFormat;

	@Column(name = "config_ticket_new_email_sub")
	private String configTicketNewEmailSub;

	@Column(name = "config_ticket_new_sms_enable")
	private String configTicketNewSmsEnable;

	@Column(name = "config_ticket_new_sms_exe_format")
	private String configTicketNewSmsExeFormat;

	@Column(name = "config_ticket_new_sms_format")
	private String configTicketNewSmsFormat;

	@Column(name = "config_ticket_reopen_leadtime")
	private int configTicketReopenLeadtime;

	@Column(name = "config_timezone_id")
	private int configTimezoneId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "config_currency_id", referencedColumnName = "currency_id", insertable = false, updatable = false)
	private AxelaCurrency axelaCurrency;

	// @ManyToOne
	// @JoinColumn(name = "config_timezone_id", referencedColumnName = "timezone_id", insertable = false, updatable = false)
	// private AxelaTimezone axelaTimezone;

	public AxelaConfig() {
	}

	public AxelaConfig(
			String configServiceContract,
			String configServiceTicketCat,
			String configServiceTicketType,
			String compModulePm,
			String configTicketNewSmsFormat,
			String configEmailEnable,
			String configAdminEmail,
			String configTicketNewEmailEnable,
			String configTicketNewEmailFormat,
			String configTicketNewEmailSub,
			String configTicketNewSmsEnable,
			String configTicketNewEmailExeFormat,
			String configTicketNewEmailExeSub,
			String configTicketNewSmsExeFormat,
			String compSmsEnable,
			String configSmsEnable,
			String configTicketFollowupSmsFormat,
			String compEmailEnable,
			String configServiceTicketRefno,
			String empEmail1,
			String empEmail2,
			String empName,
			String empMobile1,
			String empMobile2,
			String empmail1) {
		this.configServiceContract = configServiceContract;
		this.configHelpDeskTicketCat = configServiceTicketCat;
		this.configHelpdeskTicketType = configServiceTicketType;
		this.compModulePm = compModulePm;
		this.configTicketNewSmsFormat = configTicketNewSmsFormat;
		this.configEmailEnable = configEmailEnable;
		this.configAdminEmail = configAdminEmail;
		this.configTicketNewEmailEnable = configTicketNewEmailEnable;
		this.configTicketNewEmailFormat = configTicketNewEmailFormat;
		this.configTicketNewEmailSub = configTicketNewEmailSub;
		this.configTicketNewSmsEnable = configTicketNewSmsEnable;
		this.configTicketNewEmailExeFormat = configTicketNewEmailExeFormat;
		this.configTicketNewEmailExeSub = configTicketNewEmailExeSub;
		this.configTicketNewSmsExeFormat = configTicketNewSmsExeFormat;
		this.compSmsEnable = compSmsEnable;
		this.configSmsEnable = configSmsEnable;
		this.configTicketFollowupSmsFormat = configTicketFollowupSmsFormat;
		this.compEmailEnable = compEmailEnable;
		this.configHelpDeskTicketRefno = configServiceTicketRefno;
		this.empEmail1 = empEmail1;
		this.empEmail2 = empEmail2;
		this.empName = empName;
		this.empMobile1 = empMobile1;
		this.empMobile2 = empMobile2;
		this.empmail1 = empmail1;
	}

	public AxelaConfig(
			String configServiceContract,
			String configServiceJobcardCat,
			String configServiceJobcardType,
			String configServiceContractRefno,
			String configServiceJobcardRefno,
			String configServiceJobcardSerialnoMandatory,
			String configJcNewEmailEnable,
			String configJcNewSmsEnable,
			String configJcReadyEmailEnable,
			String configJcReadySmsEnable,
			String configJcDeliveredEmailEnable,
			String configJcDeliveredSmsEnable) {
		this.configServiceContract = configServiceContract;
		this.configServiceJobcardCat = configServiceJobcardCat;
		this.configServiceJobcardType = configServiceJobcardType;
		this.configServiceContractRefno = configServiceContractRefno;
		this.configServiceJobcardRefno = configServiceJobcardRefno;
		this.configServiceJobcardSerialnoMandatory = configServiceJobcardSerialnoMandatory;
		this.configJcNewEmailEnable = configJcNewEmailEnable;
		this.configJcNewSmsEnable = configJcNewSmsEnable;
		this.configJcReadyEmailEnable = configJcReadyEmailEnable;
		this.configJcReadySmsEnable = configJcReadySmsEnable;
		this.configJcDeliveredEmailEnable = configJcDeliveredEmailEnable;
		this.configJcDeliveredSmsEnable = configJcDeliveredSmsEnable;
	}

	public AxelaCurrency getAxelaCurrency() {
		return axelaCurrency;
	}

	public void setAxelaCurrency(AxelaCurrency axelaCurrency) {
		this.axelaCurrency = axelaCurrency;
	}

	public int getConfigId() {
		return this.configId;
	}

	public void setConfigId(int configId) {
		this.configId = configId;
	}

	public double getConfigActleadtime() {
		return this.configActleadtime;
	}

	public void setConfigActleadtime(double configActleadtime) {
		this.configActleadtime = configActleadtime;
	}

	public String getConfigAdminEmail() {
		return this.configAdminEmail;
	}

	public void setConfigAdminEmail(String configAdminEmail) {
		this.configAdminEmail = configAdminEmail;
	}

	public String getConfigAssistanceEmail() {
		return this.configAssistanceEmail;
	}

	public void setConfigAssistanceEmail(String configAssistanceEmail) {
		this.configAssistanceEmail = configAssistanceEmail;
	}

	public String getConfigAssistanceNo() {
		return this.configAssistanceNo;
	}

	public void setConfigAssistanceNo(String configAssistanceNo) {
		this.configAssistanceNo = configAssistanceNo;
	}

	public String getConfigBalanceDueEmailEnable() {
		return this.configBalanceDueEmailEnable;
	}

	public void setConfigBalanceDueEmailEnable(String configBalanceDueEmailEnable) {
		this.configBalanceDueEmailEnable = configBalanceDueEmailEnable;
	}

	public String getConfigBalanceDueEmailFormat() {
		return this.configBalanceDueEmailFormat;
	}

	public void setConfigBalanceDueEmailFormat(String configBalanceDueEmailFormat) {
		this.configBalanceDueEmailFormat = configBalanceDueEmailFormat;
	}

	public String getConfigBalanceDueEmailSub() {
		return this.configBalanceDueEmailSub;
	}

	public void setConfigBalanceDueEmailSub(String configBalanceDueEmailSub) {
		this.configBalanceDueEmailSub = configBalanceDueEmailSub;
	}

	public String getConfigBalanceDueSmsEnable() {
		return this.configBalanceDueSmsEnable;
	}

	public void setConfigBalanceDueSmsEnable(String configBalanceDueSmsEnable) {
		this.configBalanceDueSmsEnable = configBalanceDueSmsEnable;
	}

	public String getConfigBalanceDueSmsFormat() {
		return this.configBalanceDueSmsFormat;
	}

	public void setConfigBalanceDueSmsFormat(String configBalanceDueSmsFormat) {
		this.configBalanceDueSmsFormat = configBalanceDueSmsFormat;
	}

	public String getConfigBalanceOverdueEmailEnable() {
		return this.configBalanceOverdueEmailEnable;
	}

	public void setConfigBalanceOverdueEmailEnable(String configBalanceOverdueEmailEnable) {
		this.configBalanceOverdueEmailEnable = configBalanceOverdueEmailEnable;
	}

	public String getConfigBalanceOverdueEmailFormat() {
		return this.configBalanceOverdueEmailFormat;
	}

	public void setConfigBalanceOverdueEmailFormat(String configBalanceOverdueEmailFormat) {
		this.configBalanceOverdueEmailFormat = configBalanceOverdueEmailFormat;
	}

	public String getConfigBalanceOverdueEmailSub() {
		return this.configBalanceOverdueEmailSub;
	}

	public void setConfigBalanceOverdueEmailSub(String configBalanceOverdueEmailSub) {
		this.configBalanceOverdueEmailSub = configBalanceOverdueEmailSub;
	}

	public String getConfigBalanceOverdueSmsEnable() {
		return this.configBalanceOverdueSmsEnable;
	}

	public void setConfigBalanceOverdueSmsEnable(String configBalanceOverdueSmsEnable) {
		this.configBalanceOverdueSmsEnable = configBalanceOverdueSmsEnable;
	}

	public String getConfigBalanceOverdueSmsFormat() {
		return this.configBalanceOverdueSmsFormat;
	}

	public void setConfigBalanceOverdueSmsFormat(String configBalanceOverdueSmsFormat) {
		this.configBalanceOverdueSmsFormat = configBalanceOverdueSmsFormat;
	}

	public String getConfigBillEmailEnable() {
		return this.configBillEmailEnable;
	}

	public void setConfigBillEmailEnable(String configBillEmailEnable) {
		this.configBillEmailEnable = configBillEmailEnable;
	}

	public String getConfigBillEmailFormat() {
		return this.configBillEmailFormat;
	}

	public void setConfigBillEmailFormat(String configBillEmailFormat) {
		this.configBillEmailFormat = configBillEmailFormat;
	}

	public String getConfigBillEmailSub() {
		return this.configBillEmailSub;
	}

	public void setConfigBillEmailSub(String configBillEmailSub) {
		this.configBillEmailSub = configBillEmailSub;
	}

	public String getConfigBillSmsEnable() {
		return this.configBillSmsEnable;
	}

	public void setConfigBillSmsEnable(String configBillSmsEnable) {
		this.configBillSmsEnable = configBillSmsEnable;
	}

	public String getConfigBillSmsFormat() {
		return this.configBillSmsFormat;
	}

	public void setConfigBillSmsFormat(String configBillSmsFormat) {
		this.configBillSmsFormat = configBillSmsFormat;
	}

	public String getConfigBirthdayWishes() {
		return this.configBirthdayWishes;
	}

	public void setConfigBirthdayWishes(String configBirthdayWishes) {
		this.configBirthdayWishes = configBirthdayWishes;
	}

	public int getConfigCurrencyId() {
		return this.configCurrencyId;
	}

	public void setConfigCurrencyId(int configCurrencyId) {
		this.configCurrencyId = configCurrencyId;
	}

	public String getConfigCustomerAddress() {
		return this.configCustomerAddress;
	}

	public void setConfigCustomerAddress(String configCustomerAddress) {
		this.configCustomerAddress = configCustomerAddress;
	}

	public String getConfigCustomerDuplicate() {
		return this.configCustomerDuplicate;
	}

	public void setConfigCustomerDuplicate(String configCustomerDuplicate) {
		this.configCustomerDuplicate = configCustomerDuplicate;
	}

	public String getConfigCustomerDupnames() {
		return this.configCustomerDupnames;
	}

	public void setConfigCustomerDupnames(String configCustomerDupnames) {
		this.configCustomerDupnames = configCustomerDupnames;
	}

	public String getConfigCustomerName() {
		return this.configCustomerName;
	}

	public void setConfigCustomerName(String configCustomerName) {
		this.configCustomerName = configCustomerName;
	}

	public String getConfigCustomerSob() {
		return this.configCustomerSob;
	}

	public void setConfigCustomerSob(String configCustomerSob) {
		this.configCustomerSob = configCustomerSob;
	}

	public String getConfigCustomerSoe() {
		return this.configCustomerSoe;
	}

	public void setConfigCustomerSoe(String configCustomerSoe) {
		this.configCustomerSoe = configCustomerSoe;
	}

	public String getConfigDealerJobcardDealerexe() {
		return this.configDealerJobcardDealerexe;
	}

	public void setConfigDealerJobcardDealerexe(String configDealerJobcardDealerexe) {
		this.configDealerJobcardDealerexe = configDealerJobcardDealerexe;
	}

	public String getConfigDealerJobcardDealerexeMandatory() {
		return this.configDealerJobcardDealerexeMandatory;
	}

	public void setConfigDealerJobcardDealerexeMandatory(String configDealerJobcardDealerexeMandatory) {
		this.configDealerJobcardDealerexeMandatory = configDealerJobcardDealerexeMandatory;
	}

	public String getConfigDealerJobcardDealerexeTitle() {
		return this.configDealerJobcardDealerexeTitle;
	}

	public void setConfigDealerJobcardDealerexeTitle(String configDealerJobcardDealerexeTitle) {
		this.configDealerJobcardDealerexeTitle = configDealerJobcardDealerexeTitle;
	}

	public String getConfigDealerJobcardRefno() {
		return this.configDealerJobcardRefno;
	}

	public void setConfigDealerJobcardRefno(String configDealerJobcardRefno) {
		this.configDealerJobcardRefno = configDealerJobcardRefno;
	}

	public String getConfigDealerJobcardTechnician() {
		return this.configDealerJobcardTechnician;
	}

	public void setConfigDealerJobcardTechnician(String configDealerJobcardTechnician) {
		this.configDealerJobcardTechnician = configDealerJobcardTechnician;
	}

	public String getConfigDealerJobcardTechnicianMandatory() {
		return this.configDealerJobcardTechnicianMandatory;
	}

	public void setConfigDealerJobcardTechnicianMandatory(String configDealerJobcardTechnicianMandatory) {
		this.configDealerJobcardTechnicianMandatory = configDealerJobcardTechnicianMandatory;
	}

	public String getConfigDealerJoborderRefno() {
		return this.configDealerJoborderRefno;
	}

	public void setConfigDealerJoborderRefno(String configDealerJoborderRefno) {
		this.configDealerJoborderRefno = configDealerJoborderRefno;
	}

	public String getConfigDocFormats() {
		return this.configDocFormats;
	}

	public void setConfigDocFormats(String configDocFormats) {
		this.configDocFormats = configDocFormats;
	}

	public double getConfigDocSize() {
		return this.configDocSize;
	}

	public void setConfigDocSize(double configDocSize) {
		this.configDocSize = configDocSize;
	}

	public int getConfigEmailBatchcount() {
		return this.configEmailBatchcount;
	}

	public void setConfigEmailBatchcount(int configEmailBatchcount) {
		this.configEmailBatchcount = configEmailBatchcount;
	}

	public String getConfigEmailEnable() {
		return this.configEmailEnable;
	}

	public void setConfigEmailEnable(String configEmailEnable) {
		this.configEmailEnable = configEmailEnable;
	}

	public int getConfigFormatDecimal() {
		return this.configFormatDecimal;
	}

	public void setConfigFormatDecimal(int configFormatDecimal) {
		this.configFormatDecimal = configFormatDecimal;
	}

	public double getConfigImageSize() {
		return this.configImageSize;
	}

	public void setConfigImageSize(double configImageSize) {
		this.configImageSize = configImageSize;
	}

	public String getConfigInventoryCurrentStock() {
		return this.configInventoryCurrentStock;
	}

	public void setConfigInventoryCurrentStock(String configInventoryCurrentStock) {
		this.configInventoryCurrentStock = configInventoryCurrentStock;
	}

	public String getConfigInventoryLocationName() {
		return this.configInventoryLocationName;
	}

	public void setConfigInventoryLocationName(String configInventoryLocationName) {
		this.configInventoryLocationName = configInventoryLocationName;
	}

	public String getConfigInventoryPoRefno() {
		return this.configInventoryPoRefno;
	}

	public void setConfigInventoryPoRefno(String configInventoryPoRefno) {
		this.configInventoryPoRefno = configInventoryPoRefno;
	}

	public String getConfigInvoiceDesc() {
		return this.configInvoiceDesc;
	}

	public void setConfigInvoiceDesc(String configInvoiceDesc) {
		this.configInvoiceDesc = configInvoiceDesc;
	}

	public String getConfigInvoiceEmailEnable() {
		return this.configInvoiceEmailEnable;
	}

	public void setConfigInvoiceEmailEnable(String configInvoiceEmailEnable) {
		this.configInvoiceEmailEnable = configInvoiceEmailEnable;
	}

	public String getConfigInvoiceEmailFormat() {
		return this.configInvoiceEmailFormat;
	}

	public void setConfigInvoiceEmailFormat(String configInvoiceEmailFormat) {
		this.configInvoiceEmailFormat = configInvoiceEmailFormat;
	}

	public String getConfigInvoiceEmailSub() {
		return this.configInvoiceEmailSub;
	}

	public void setConfigInvoiceEmailSub(String configInvoiceEmailSub) {
		this.configInvoiceEmailSub = configInvoiceEmailSub;
	}

	public String getConfigInvoicePrefix() {
		return this.configInvoicePrefix;
	}

	public void setConfigInvoicePrefix(String configInvoicePrefix) {
		this.configInvoicePrefix = configInvoicePrefix;
	}

	public String getConfigInvoiceReduceCurrentStock() {
		return this.configInvoiceReduceCurrentStock;
	}

	public void setConfigInvoiceReduceCurrentStock(String configInvoiceReduceCurrentStock) {
		this.configInvoiceReduceCurrentStock = configInvoiceReduceCurrentStock;
	}

	public String getConfigInvoiceSmsEnable() {
		return this.configInvoiceSmsEnable;
	}

	public void setConfigInvoiceSmsEnable(String configInvoiceSmsEnable) {
		this.configInvoiceSmsEnable = configInvoiceSmsEnable;
	}

	public String getConfigInvoiceSmsFormat() {
		return this.configInvoiceSmsFormat;
	}

	public void setConfigInvoiceSmsFormat(String configInvoiceSmsFormat) {
		this.configInvoiceSmsFormat = configInvoiceSmsFormat;
	}

	public String getConfigInvoiceTerms() {
		return this.configInvoiceTerms;
	}

	public void setConfigInvoiceTerms(String configInvoiceTerms) {
		this.configInvoiceTerms = configInvoiceTerms;
	}

	public String getConfigJcDeliveredEmailEnable() {
		return this.configJcDeliveredEmailEnable;
	}

	public void setConfigJcDeliveredEmailEnable(String configJcDeliveredEmailEnable) {
		this.configJcDeliveredEmailEnable = configJcDeliveredEmailEnable;
	}

	public String getConfigJcDeliveredEmailFormat() {
		return this.configJcDeliveredEmailFormat;
	}

	public void setConfigJcDeliveredEmailFormat(String configJcDeliveredEmailFormat) {
		this.configJcDeliveredEmailFormat = configJcDeliveredEmailFormat;
	}

	public String getConfigJcDeliveredEmailSub() {
		return this.configJcDeliveredEmailSub;
	}

	public void setConfigJcDeliveredEmailSub(String configJcDeliveredEmailSub) {
		this.configJcDeliveredEmailSub = configJcDeliveredEmailSub;
	}

	public String getConfigJcDeliveredSmsEnable() {
		return this.configJcDeliveredSmsEnable;
	}

	public void setConfigJcDeliveredSmsEnable(String configJcDeliveredSmsEnable) {
		this.configJcDeliveredSmsEnable = configJcDeliveredSmsEnable;
	}

	public String getConfigJcDeliveredSmsFormat() {
		return this.configJcDeliveredSmsFormat;
	}

	public void setConfigJcDeliveredSmsFormat(String configJcDeliveredSmsFormat) {
		this.configJcDeliveredSmsFormat = configJcDeliveredSmsFormat;
	}

	public String getConfigJcNewEmailEnable() {
		return this.configJcNewEmailEnable;
	}

	public void setConfigJcNewEmailEnable(String configJcNewEmailEnable) {
		this.configJcNewEmailEnable = configJcNewEmailEnable;
	}

	public String getConfigJcNewEmailFormat() {
		return this.configJcNewEmailFormat;
	}

	public void setConfigJcNewEmailFormat(String configJcNewEmailFormat) {
		this.configJcNewEmailFormat = configJcNewEmailFormat;
	}

	public String getConfigJcNewEmailSub() {
		return this.configJcNewEmailSub;
	}

	public void setConfigJcNewEmailSub(String configJcNewEmailSub) {
		this.configJcNewEmailSub = configJcNewEmailSub;
	}

	public String getConfigJcNewSmsEnable() {
		return this.configJcNewSmsEnable;
	}

	public void setConfigJcNewSmsEnable(String configJcNewSmsEnable) {
		this.configJcNewSmsEnable = configJcNewSmsEnable;
	}

	public String getConfigJcNewSmsFormat() {
		return this.configJcNewSmsFormat;
	}

	public void setConfigJcNewSmsFormat(String configJcNewSmsFormat) {
		this.configJcNewSmsFormat = configJcNewSmsFormat;
	}

	public String getConfigJcReadyEmailEnable() {
		return this.configJcReadyEmailEnable;
	}

	public void setConfigJcReadyEmailEnable(String configJcReadyEmailEnable) {
		this.configJcReadyEmailEnable = configJcReadyEmailEnable;
	}

	public String getConfigJcReadyEmailFormat() {
		return this.configJcReadyEmailFormat;
	}

	public void setConfigJcReadyEmailFormat(String configJcReadyEmailFormat) {
		this.configJcReadyEmailFormat = configJcReadyEmailFormat;
	}

	public String getConfigJcReadyEmailSub() {
		return this.configJcReadyEmailSub;
	}

	public void setConfigJcReadyEmailSub(String configJcReadyEmailSub) {
		this.configJcReadyEmailSub = configJcReadyEmailSub;
	}

	public String getConfigJcReadySmsEnable() {
		return this.configJcReadySmsEnable;
	}

	public void setConfigJcReadySmsEnable(String configJcReadySmsEnable) {
		this.configJcReadySmsEnable = configJcReadySmsEnable;
	}

	public String getConfigJcReadySmsFormat() {
		return this.configJcReadySmsFormat;
	}

	public void setConfigJcReadySmsFormat(String configJcReadySmsFormat) {
		this.configJcReadySmsFormat = configJcReadySmsFormat;
	}

	public String getConfigLeadEmailEnable() {
		return this.configLeadEmailEnable;
	}

	public void setConfigLeadEmailEnable(String configLeadEmailEnable) {
		this.configLeadEmailEnable = configLeadEmailEnable;
	}

	public String getConfigLeadEmailExeFormat() {
		return this.configLeadEmailExeFormat;
	}

	public void setConfigLeadEmailExeFormat(String configLeadEmailExeFormat) {
		this.configLeadEmailExeFormat = configLeadEmailExeFormat;
	}

	public String getConfigLeadEmailExeSub() {
		return this.configLeadEmailExeSub;
	}

	public void setConfigLeadEmailExeSub(String configLeadEmailExeSub) {
		this.configLeadEmailExeSub = configLeadEmailExeSub;
	}

	public String getConfigLeadEmailFormat() {
		return this.configLeadEmailFormat;
	}

	public void setConfigLeadEmailFormat(String configLeadEmailFormat) {
		this.configLeadEmailFormat = configLeadEmailFormat;
	}

	public String getConfigLeadEmailSub() {
		return this.configLeadEmailSub;
	}

	public void setConfigLeadEmailSub(String configLeadEmailSub) {
		this.configLeadEmailSub = configLeadEmailSub;
	}

	public String getConfigLeadSmsEnable() {
		return this.configLeadSmsEnable;
	}

	public void setConfigLeadSmsEnable(String configLeadSmsEnable) {
		this.configLeadSmsEnable = configLeadSmsEnable;
	}

	public String getConfigLeadSmsExeFormat() {
		return this.configLeadSmsExeFormat;
	}

	public void setConfigLeadSmsExeFormat(String configLeadSmsExeFormat) {
		this.configLeadSmsExeFormat = configLeadSmsExeFormat;
	}

	public String getConfigLeadSmsFormat() {
		return this.configLeadSmsFormat;
	}

	public void setConfigLeadSmsFormat(String configLeadSmsFormat) {
		this.configLeadSmsFormat = configLeadSmsFormat;
	}

	public String getConfigMailPassword() {
		return this.configMailPassword;
	}

	public void setConfigMailPassword(String configMailPassword) {
		this.configMailPassword = configMailPassword;
	}

	public String getConfigMailPort() {
		return this.configMailPort;
	}

	public void setConfigMailPort(String configMailPort) {
		this.configMailPort = configMailPort;
	}

	public String getConfigMailServer() {
		return this.configMailServer;
	}

	public void setConfigMailServer(String configMailServer) {
		this.configMailServer = configMailServer;
	}

	public String getConfigMailSsl() {
		return this.configMailSsl;
	}

	public void setConfigMailSsl(String configMailSsl) {
		this.configMailSsl = configMailSsl;
	}

	public String getConfigMailUsername() {
		return this.configMailUsername;
	}

	public void setConfigMailUsername(String configMailUsername) {
		this.configMailUsername = configMailUsername;
	}

	public String getConfigNewSoEmailFormat() {
		return this.configNewSoEmailFormat;
	}

	public void setConfigNewSoEmailFormat(String configNewSoEmailFormat) {
		this.configNewSoEmailFormat = configNewSoEmailFormat;
	}

	public String getConfigNewSoEmailSub() {
		return this.configNewSoEmailSub;
	}

	public void setConfigNewSoEmailSub(String configNewSoEmailSub) {
		this.configNewSoEmailSub = configNewSoEmailSub;
	}

	public String getConfigOpprBrochureEmailEnable() {
		return this.configOpprBrochureEmailEnable;
	}

	public void setConfigOpprBrochureEmailEnable(String configOpprBrochureEmailEnable) {
		this.configOpprBrochureEmailEnable = configOpprBrochureEmailEnable;
	}

	public String getConfigOpprBrochureEmailFormat() {
		return this.configOpprBrochureEmailFormat;
	}

	public void setConfigOpprBrochureEmailFormat(String configOpprBrochureEmailFormat) {
		this.configOpprBrochureEmailFormat = configOpprBrochureEmailFormat;
	}

	public String getConfigOpprBrochureEmailSub() {
		return this.configOpprBrochureEmailSub;
	}

	public void setConfigOpprBrochureEmailSub(String configOpprBrochureEmailSub) {
		this.configOpprBrochureEmailSub = configOpprBrochureEmailSub;
	}

	public String getConfigOpprEmailEnable() {
		return this.configOpprEmailEnable;
	}

	public void setConfigOpprEmailEnable(String configOpprEmailEnable) {
		this.configOpprEmailEnable = configOpprEmailEnable;
	}

	public String getConfigOpprEmailExeFormat() {
		return this.configOpprEmailExeFormat;
	}

	public void setConfigOpprEmailExeFormat(String configOpprEmailExeFormat) {
		this.configOpprEmailExeFormat = configOpprEmailExeFormat;
	}

	public String getConfigOpprEmailExeSub() {
		return this.configOpprEmailExeSub;
	}

	public void setConfigOpprEmailExeSub(String configOpprEmailExeSub) {
		this.configOpprEmailExeSub = configOpprEmailExeSub;
	}

	public String getConfigOpprEmailFormat() {
		return this.configOpprEmailFormat;
	}

	public void setConfigOpprEmailFormat(String configOpprEmailFormat) {
		this.configOpprEmailFormat = configOpprEmailFormat;
	}

	public String getConfigOpprEmailSub() {
		return this.configOpprEmailSub;
	}

	public void setConfigOpprEmailSub(String configOpprEmailSub) {
		this.configOpprEmailSub = configOpprEmailSub;
	}

	public String getConfigOpprProjbrochureEmailEnable() {
		return this.configOpprProjbrochureEmailEnable;
	}

	public void setConfigOpprProjbrochureEmailEnable(String configOpprProjbrochureEmailEnable) {
		this.configOpprProjbrochureEmailEnable = configOpprProjbrochureEmailEnable;
	}

	public String getConfigOpprProjbrochureEmailFormat() {
		return this.configOpprProjbrochureEmailFormat;
	}

	public void setConfigOpprProjbrochureEmailFormat(String configOpprProjbrochureEmailFormat) {
		this.configOpprProjbrochureEmailFormat = configOpprProjbrochureEmailFormat;
	}

	public String getConfigOpprProjbrochureEmailSub() {
		return this.configOpprProjbrochureEmailSub;
	}

	public void setConfigOpprProjbrochureEmailSub(String configOpprProjbrochureEmailSub) {
		this.configOpprProjbrochureEmailSub = configOpprProjbrochureEmailSub;
	}

	public String getConfigOpprSmsEnable() {
		return this.configOpprSmsEnable;
	}

	public void setConfigOpprSmsEnable(String configOpprSmsEnable) {
		this.configOpprSmsEnable = configOpprSmsEnable;
	}

	public String getConfigOpprSmsExeFormat() {
		return this.configOpprSmsExeFormat;
	}

	public void setConfigOpprSmsExeFormat(String configOpprSmsExeFormat) {
		this.configOpprSmsExeFormat = configOpprSmsExeFormat;
	}

	public String getConfigOpprSmsFormat() {
		return this.configOpprSmsFormat;
	}

	public void setConfigOpprSmsFormat(String configOpprSmsFormat) {
		this.configOpprSmsFormat = configOpprSmsFormat;
	}

	public String getConfigPosBillMsg() {
		return this.configPosBillMsg;
	}

	public void setConfigPosBillMsg(String configPosBillMsg) {
		this.configPosBillMsg = configPosBillMsg;
	}

	public int getConfigPosBillWidth() {
		return this.configPosBillWidth;
	}

	public void setConfigPosBillWidth(int configPosBillWidth) {
		this.configPosBillWidth = configPosBillWidth;
	}

	public String getConfigPosBillZerovalue() {
		return this.configPosBillZerovalue;
	}

	public void setConfigPosBillZerovalue(String configPosBillZerovalue) {
		this.configPosBillZerovalue = configPosBillZerovalue;
	}

	public String getConfigPosDeliveryDate() {
		return this.configPosDeliveryDate;
	}

	public void setConfigPosDeliveryDate(String configPosDeliveryDate) {
		this.configPosDeliveryDate = configPosDeliveryDate;
	}

	public int getConfigPosDeliveryTime() {
		return this.configPosDeliveryTime;
	}

	public void setConfigPosDeliveryTime(int configPosDeliveryTime) {
		this.configPosDeliveryTime = configPosDeliveryTime;
	}

	public String getConfigPosDiscUpdate() {
		return this.configPosDiscUpdate;
	}

	public void setConfigPosDiscUpdate(String configPosDiscUpdate) {
		this.configPosDiscUpdate = configPosDiscUpdate;
	}

	public String getConfigPosNegQty() {
		return this.configPosNegQty;
	}

	public void setConfigPosNegQty(String configPosNegQty) {
		this.configPosNegQty = configPosNegQty;
	}

	public String getConfigPosPriceUpdate() {
		return this.configPosPriceUpdate;
	}

	public void setConfigPosPriceUpdate(String configPosPriceUpdate) {
		this.configPosPriceUpdate = configPosPriceUpdate;
	}

	public String getConfigPosPrintbarcode() {
		return this.configPosPrintbarcode;
	}

	public void setConfigPosPrintbarcode(String configPosPrintbarcode) {
		this.configPosPrintbarcode = configPosPrintbarcode;
	}

	public String getConfigPosPrintcounterfoil() {
		return this.configPosPrintcounterfoil;
	}

	public void setConfigPosPrintcounterfoil(String configPosPrintcounterfoil) {
		this.configPosPrintcounterfoil = configPosPrintcounterfoil;
	}

	public String getConfigPosTouch() {
		return this.configPosTouch;
	}

	public void setConfigPosTouch(String configPosTouch) {
		this.configPosTouch = configPosTouch;
	}

	public String getConfigProdJcEmailEnable() {
		return this.configProdJcEmailEnable;
	}

	public void setConfigProdJcEmailEnable(String configProdJcEmailEnable) {
		this.configProdJcEmailEnable = configProdJcEmailEnable;
	}

	public String getConfigProdJcEmailFormat() {
		return this.configProdJcEmailFormat;
	}

	public void setConfigProdJcEmailFormat(String configProdJcEmailFormat) {
		this.configProdJcEmailFormat = configProdJcEmailFormat;
	}

	public String getConfigProdJcEmailSub() {
		return this.configProdJcEmailSub;
	}

	public void setConfigProdJcEmailSub(String configProdJcEmailSub) {
		this.configProdJcEmailSub = configProdJcEmailSub;
	}

	public String getConfigProdJoborderRefno() {
		return this.configProdJoborderRefno;
	}

	public void setConfigProdJoborderRefno(String configProdJoborderRefno) {
		this.configProdJoborderRefno = configProdJoborderRefno;
	}

	public int getConfigPropActleadtime() {
		return this.configPropActleadtime;
	}

	public void setConfigPropActleadtime(int configPropActleadtime) {
		this.configPropActleadtime = configPropActleadtime;
	}

	public String getConfigPropAmenitiesEnable() {
		return this.configPropAmenitiesEnable;
	}

	public void setConfigPropAmenitiesEnable(String configPropAmenitiesEnable) {
		this.configPropAmenitiesEnable = configPropAmenitiesEnable;
	}

	public String getConfigPropAmenitiesVisible() {
		return this.configPropAmenitiesVisible;
	}

	public void setConfigPropAmenitiesVisible(String configPropAmenitiesVisible) {
		this.configPropAmenitiesVisible = configPropAmenitiesVisible;
	}

	public String getConfigPropCfEnable() {
		return this.configPropCfEnable;
	}

	public void setConfigPropCfEnable(String configPropCfEnable) {
		this.configPropCfEnable = configPropCfEnable;
	}

	public String getConfigPropCfVisible() {
		return this.configPropCfVisible;
	}

	public void setConfigPropCfVisible(String configPropCfVisible) {
		this.configPropCfVisible = configPropCfVisible;
	}

	public String getConfigPropConstspecVisible() {
		return this.configPropConstspecVisible;
	}

	public void setConfigPropConstspecVisible(String configPropConstspecVisible) {
		this.configPropConstspecVisible = configPropConstspecVisible;
	}

	public String getConfigPropFacilitiesEnable() {
		return this.configPropFacilitiesEnable;
	}

	public void setConfigPropFacilitiesEnable(String configPropFacilitiesEnable) {
		this.configPropFacilitiesEnable = configPropFacilitiesEnable;
	}

	public String getConfigPropFacilitiesVisible() {
		return this.configPropFacilitiesVisible;
	}

	public void setConfigPropFacilitiesVisible(String configPropFacilitiesVisible) {
		this.configPropFacilitiesVisible = configPropFacilitiesVisible;
	}

	public String getConfigPropPropsnapshotEnable() {
		return this.configPropPropsnapshotEnable;
	}

	public void setConfigPropPropsnapshotEnable(String configPropPropsnapshotEnable) {
		this.configPropPropsnapshotEnable = configPropPropsnapshotEnable;
	}

	public String getConfigPropPropsnapshotVisible() {
		return this.configPropPropsnapshotVisible;
	}

	public void setConfigPropPropsnapshotVisible(String configPropPropsnapshotVisible) {
		this.configPropPropsnapshotVisible = configPropPropsnapshotVisible;
	}

	public String getConfigPropRentdetailsEnable() {
		return this.configPropRentdetailsEnable;
	}

	public void setConfigPropRentdetailsEnable(String configPropRentdetailsEnable) {
		this.configPropRentdetailsEnable = configPropRentdetailsEnable;
	}

	public String getConfigPropRentdetailsVisible() {
		return this.configPropRentdetailsVisible;
	}

	public void setConfigPropRentdetailsVisible(String configPropRentdetailsVisible) {
		this.configPropRentdetailsVisible = configPropRentdetailsVisible;
	}

	public String getConfigQuoteBrochureEmailFormat() {
		return this.configQuoteBrochureEmailFormat;
	}

	public void setConfigQuoteBrochureEmailFormat(String configQuoteBrochureEmailFormat) {
		this.configQuoteBrochureEmailFormat = configQuoteBrochureEmailFormat;
	}

	public String getConfigQuoteBrochureEmailSub() {
		return this.configQuoteBrochureEmailSub;
	}

	public void setConfigQuoteBrochureEmailSub(String configQuoteBrochureEmailSub) {
		this.configQuoteBrochureEmailSub = configQuoteBrochureEmailSub;
	}

	public String getConfigQuoteDesc() {
		return this.configQuoteDesc;
	}

	public void setConfigQuoteDesc(String configQuoteDesc) {
		this.configQuoteDesc = configQuoteDesc;
	}

	public String getConfigQuoteEmailEnable() {
		return this.configQuoteEmailEnable;
	}

	public void setConfigQuoteEmailEnable(String configQuoteEmailEnable) {
		this.configQuoteEmailEnable = configQuoteEmailEnable;
	}

	public String getConfigQuoteEmailExeFormat() {
		return this.configQuoteEmailExeFormat;
	}

	public void setConfigQuoteEmailExeFormat(String configQuoteEmailExeFormat) {
		this.configQuoteEmailExeFormat = configQuoteEmailExeFormat;
	}

	public String getConfigQuoteEmailExeSub() {
		return this.configQuoteEmailExeSub;
	}

	public void setConfigQuoteEmailExeSub(String configQuoteEmailExeSub) {
		this.configQuoteEmailExeSub = configQuoteEmailExeSub;
	}

	public String getConfigQuoteEmailFormat() {
		return this.configQuoteEmailFormat;
	}

	public void setConfigQuoteEmailFormat(String configQuoteEmailFormat) {
		this.configQuoteEmailFormat = configQuoteEmailFormat;
	}

	public String getConfigQuoteEmailSub() {
		return this.configQuoteEmailSub;
	}

	public void setConfigQuoteEmailSub(String configQuoteEmailSub) {
		this.configQuoteEmailSub = configQuoteEmailSub;
	}

	public String getConfigQuotePrefix() {
		return this.configQuotePrefix;
	}

	public void setConfigQuotePrefix(String configQuotePrefix) {
		this.configQuotePrefix = configQuotePrefix;
	}

	public String getConfigQuoteSmsEnable() {
		return this.configQuoteSmsEnable;
	}

	public void setConfigQuoteSmsEnable(String configQuoteSmsEnable) {
		this.configQuoteSmsEnable = configQuoteSmsEnable;
	}

	public String getConfigQuoteSmsFormat() {
		return this.configQuoteSmsFormat;
	}

	public void setConfigQuoteSmsFormat(String configQuoteSmsFormat) {
		this.configQuoteSmsFormat = configQuoteSmsFormat;
	}

	public String getConfigQuoteTerms() {
		return this.configQuoteTerms;
	}

	public void setConfigQuoteTerms(String configQuoteTerms) {
		this.configQuoteTerms = configQuoteTerms;
	}

	public String getConfigReceiptDesc() {
		return this.configReceiptDesc;
	}

	public void setConfigReceiptDesc(String configReceiptDesc) {
		this.configReceiptDesc = configReceiptDesc;
	}

	public String getConfigReceiptEmailEnable() {
		return this.configReceiptEmailEnable;
	}

	public void setConfigReceiptEmailEnable(String configReceiptEmailEnable) {
		this.configReceiptEmailEnable = configReceiptEmailEnable;
	}

	public String getConfigReceiptEmailFormat() {
		return this.configReceiptEmailFormat;
	}

	public void setConfigReceiptEmailFormat(String configReceiptEmailFormat) {
		this.configReceiptEmailFormat = configReceiptEmailFormat;
	}

	public String getConfigReceiptEmailSub() {
		return this.configReceiptEmailSub;
	}

	public void setConfigReceiptEmailSub(String configReceiptEmailSub) {
		this.configReceiptEmailSub = configReceiptEmailSub;
	}

	public String getConfigReceiptPrefix() {
		return this.configReceiptPrefix;
	}

	public void setConfigReceiptPrefix(String configReceiptPrefix) {
		this.configReceiptPrefix = configReceiptPrefix;
	}

	public String getConfigReceiptSmsEnable() {
		return this.configReceiptSmsEnable;
	}

	public void setConfigReceiptSmsEnable(String configReceiptSmsEnable) {
		this.configReceiptSmsEnable = configReceiptSmsEnable;
	}

	public String getConfigReceiptSmsFormat() {
		return this.configReceiptSmsFormat;
	}

	public void setConfigReceiptSmsFormat(String configReceiptSmsFormat) {
		this.configReceiptSmsFormat = configReceiptSmsFormat;
	}

	public String getConfigReceiptTerms() {
		return this.configReceiptTerms;
	}

	public void setConfigReceiptTerms(String configReceiptTerms) {
		this.configReceiptTerms = configReceiptTerms;
	}

	public String getConfigRefnoEnable() {
		return this.configRefnoEnable;
	}

	public void setConfigRefnoEnable(String configRefnoEnable) {
		this.configRefnoEnable = configRefnoEnable;
	}

	public String getConfigSalesBalancepayments() {
		return this.configSalesBalancepayments;
	}

	public void setConfigSalesBalancepayments(String configSalesBalancepayments) {
		this.configSalesBalancepayments = configSalesBalancepayments;
	}

	public String getConfigSalesCampaign() {
		return this.configSalesCampaign;
	}

	public void setConfigSalesCampaign(String configSalesCampaign) {
		this.configSalesCampaign = configSalesCampaign;
	}

	public String getConfigSalesEnquiryDomain() {
		return this.configSalesEnquiryDomain;
	}

	public void setConfigSalesEnquiryDomain(String configSalesEnquiryDomain) {
		this.configSalesEnquiryDomain = configSalesEnquiryDomain;
	}

	public String getConfigSalesEnquiryThankyouUrl() {
		return this.configSalesEnquiryThankyouUrl;
	}

	public void setConfigSalesEnquiryThankyouUrl(String configSalesEnquiryThankyouUrl) {
		this.configSalesEnquiryThankyouUrl = configSalesEnquiryThankyouUrl;
	}

	public String getConfigSalesInvoice() {
		return this.configSalesInvoice;
	}

	public void setConfigSalesInvoice(String configSalesInvoice) {
		this.configSalesInvoice = configSalesInvoice;
	}

	public String getConfigSalesInvoiceRefno() {
		return this.configSalesInvoiceRefno;
	}

	public void setConfigSalesInvoiceRefno(String configSalesInvoiceRefno) {
		this.configSalesInvoiceRefno = configSalesInvoiceRefno;
	}

	public String getConfigSalesLeadForOppr() {
		return this.configSalesLeadForOppr;
	}

	public void setConfigSalesLeadForOppr(String configSalesLeadForOppr) {
		this.configSalesLeadForOppr = configSalesLeadForOppr;
	}

	public String getConfigSalesLeadRefno() {
		return this.configSalesLeadRefno;
	}

	public void setConfigSalesLeadRefno(String configSalesLeadRefno) {
		this.configSalesLeadRefno = configSalesLeadRefno;
	}

	public String getConfigSalesLeads() {
		return this.configSalesLeads;
	}

	public void setConfigSalesLeads(String configSalesLeads) {
		this.configSalesLeads = configSalesLeads;
	}

	public String getConfigSalesOppr() {
		return this.configSalesOppr;
	}

	public void setConfigSalesOppr(String configSalesOppr) {
		this.configSalesOppr = configSalesOppr;
	}

	public String getConfigSalesOpprBudget() {
		return this.configSalesOpprBudget;
	}

	public void setConfigSalesOpprBudget(String configSalesOpprBudget) {
		this.configSalesOpprBudget = configSalesOpprBudget;
	}

	public String getConfigSalesOpprForQuote() {
		return this.configSalesOpprForQuote;
	}

	public void setConfigSalesOpprForQuote(String configSalesOpprForQuote) {
		this.configSalesOpprForQuote = configSalesOpprForQuote;
	}

	public String getConfigSalesOpprItem() {
		return this.configSalesOpprItem;
	}

	public void setConfigSalesOpprItem(String configSalesOpprItem) {
		this.configSalesOpprItem = configSalesOpprItem;
	}

	public String getConfigSalesOpprModel() {
		return this.configSalesOpprModel;
	}

	public void setConfigSalesOpprModel(String configSalesOpprModel) {
		this.configSalesOpprModel = configSalesOpprModel;
	}

	public String getConfigSalesOpprName() {
		return this.configSalesOpprName;
	}

	public void setConfigSalesOpprName(String configSalesOpprName) {
		this.configSalesOpprName = configSalesOpprName;
	}

	public String getConfigSalesOpprProject() {
		return this.configSalesOpprProject;
	}

	public void setConfigSalesOpprProject(String configSalesOpprProject) {
		this.configSalesOpprProject = configSalesOpprProject;
	}

	public String getConfigSalesOpprRefno() {
		return this.configSalesOpprRefno;
	}

	public void setConfigSalesOpprRefno(String configSalesOpprRefno) {
		this.configSalesOpprRefno = configSalesOpprRefno;
	}

	public String getConfigSalesQuote() {
		return this.configSalesQuote;
	}

	public void setConfigSalesQuote(String configSalesQuote) {
		this.configSalesQuote = configSalesQuote;
	}

	public String getConfigSalesQuoteForSo() {
		return this.configSalesQuoteForSo;
	}

	public void setConfigSalesQuoteForSo(String configSalesQuoteForSo) {
		this.configSalesQuoteForSo = configSalesQuoteForSo;
	}

	public String getConfigSalesQuoteRefno() {
		return this.configSalesQuoteRefno;
	}

	public void setConfigSalesQuoteRefno(String configSalesQuoteRefno) {
		this.configSalesQuoteRefno = configSalesQuoteRefno;
	}

	public String getConfigSalesReceiptRefno() {
		return this.configSalesReceiptRefno;
	}

	public void setConfigSalesReceiptRefno(String configSalesReceiptRefno) {
		this.configSalesReceiptRefno = configSalesReceiptRefno;
	}

	public String getConfigSalesSalesorder() {
		return this.configSalesSalesorder;
	}

	public void setConfigSalesSalesorder(String configSalesSalesorder) {
		this.configSalesSalesorder = configSalesSalesorder;
	}

	public String getConfigSalesSoForInvoice() {
		return this.configSalesSoForInvoice;
	}

	public void setConfigSalesSoForInvoice(String configSalesSoForInvoice) {
		this.configSalesSoForInvoice = configSalesSoForInvoice;
	}

	public String getConfigSalesSoRefno() {
		return this.configSalesSoRefno;
	}

	public void setConfigSalesSoRefno(String configSalesSoRefno) {
		this.configSalesSoRefno = configSalesSoRefno;
	}

	public String getConfigSalesSob() {
		return this.configSalesSob;
	}

	public void setConfigSalesSob(String configSalesSob) {
		this.configSalesSob = configSalesSob;
	}

	public String getConfigSalesSoe() {
		return this.configSalesSoe;
	}

	public void setConfigSalesSoe(String configSalesSoe) {
		this.configSalesSoe = configSalesSoe;
	}

	public String getConfigSalesTarget() {
		return this.configSalesTarget;
	}

	public void setConfigSalesTarget(String configSalesTarget) {
		this.configSalesTarget = configSalesTarget;
	}

	public String getConfigSalesTeams() {
		return this.configSalesTeams;
	}

	public void setConfigSalesTeams(String configSalesTeams) {
		this.configSalesTeams = configSalesTeams;
	}

	public String getConfigServiceContract() {
		return this.configServiceContract;
	}

	public void setConfigServiceContract(String configServiceContract) {
		this.configServiceContract = configServiceContract;
	}

	public String getConfigServiceContractRefno() {
		return this.configServiceContractRefno;
	}

	public void setConfigServiceContractRefno(String configServiceContractRefno) {
		this.configServiceContractRefno = configServiceContractRefno;
	}

	public String getConfigServiceJobcardCat() {
		return this.configServiceJobcardCat;
	}

	public void setConfigServiceJobcardCat(String configServiceJobcardCat) {
		this.configServiceJobcardCat = configServiceJobcardCat;
	}

	public String getConfigServiceJobcardRefno() {
		return this.configServiceJobcardRefno;
	}

	public void setConfigServiceJobcardRefno(String configServiceJobcardRefno) {
		this.configServiceJobcardRefno = configServiceJobcardRefno;
	}

	public String getConfigServiceJobcardSerialnoMandatory() {
		return this.configServiceJobcardSerialnoMandatory;
	}

	public void setConfigServiceJobcardSerialnoMandatory(String configServiceJobcardSerialnoMandatory) {
		this.configServiceJobcardSerialnoMandatory = configServiceJobcardSerialnoMandatory;
	}

	public String getConfigServiceJobcardType() {
		return this.configServiceJobcardType;
	}

	public void setConfigServiceJobcardType(String configServiceJobcardType) {
		this.configServiceJobcardType = configServiceJobcardType;
	}

	// public String getConfigServiceTicket() {
	// return this.configHelpDeskTicket;
	// }

	// public void setConfigServiceTicket(String configServiceTicket) {
	// this.configServiceTicket = configServiceTicket;
	// }
	//
	// public String getConfigServiceTicketCat() {
	// return this.configServiceTicketCat;
	// }
	//
	// public void setConfigServiceTicketCat(String configServiceTicketCat) {
	// this.configServiceTicketCat = configServiceTicketCat;
	// }
	//
	// public String getConfigServiceTicketRefno() {
	// return this.configServiceTicketRefno;
	// }
	//
	// public void setConfigServiceTicketRefno(String configServiceTicketRefno) {
	// this.configServiceTicketRefno = configServiceTicketRefno;
	// }
	//
	// public String getConfigServiceTicketType() {
	// return this.configServiceTicketType;
	// }
	//
	// public void setConfigServiceTicketType(String configServiceTicketType) {
	// this.configServiceTicketType = configServiceTicketType;
	// }

	public int getConfigSmsBatchcount() {
		return this.configSmsBatchcount;
	}

	public void setConfigSmsBatchcount(int configSmsBatchcount) {
		this.configSmsBatchcount = configSmsBatchcount;
	}

	public String getConfigSmsEnable() {
		return this.configSmsEnable;
	}

	public void setConfigSmsEnable(String configSmsEnable) {
		this.configSmsEnable = configSmsEnable;
	}

	public String getConfigSmsUrl() {
		return this.configSmsUrl;
	}

	public void setConfigSmsUrl(String configSmsUrl) {
		this.configSmsUrl = configSmsUrl;
	}

	public String getConfigSoDesc() {
		return this.configSoDesc;
	}

	public void setConfigSoDesc(String configSoDesc) {
		this.configSoDesc = configSoDesc;
	}

	public String getConfigSoEmailEnable() {
		return this.configSoEmailEnable;
	}

	public void setConfigSoEmailEnable(String configSoEmailEnable) {
		this.configSoEmailEnable = configSoEmailEnable;
	}

	public String getConfigSoEmailExeFormat() {
		return this.configSoEmailExeFormat;
	}

	public void setConfigSoEmailExeFormat(String configSoEmailExeFormat) {
		this.configSoEmailExeFormat = configSoEmailExeFormat;
	}

	public String getConfigSoEmailExeSub() {
		return this.configSoEmailExeSub;
	}

	public void setConfigSoEmailExeSub(String configSoEmailExeSub) {
		this.configSoEmailExeSub = configSoEmailExeSub;
	}

	public String getConfigSoEmailFormat() {
		return this.configSoEmailFormat;
	}

	public void setConfigSoEmailFormat(String configSoEmailFormat) {
		this.configSoEmailFormat = configSoEmailFormat;
	}

	public String getConfigSoEmailSub() {
		return this.configSoEmailSub;
	}

	public void setConfigSoEmailSub(String configSoEmailSub) {
		this.configSoEmailSub = configSoEmailSub;
	}

	public int getConfigSoMindownpayment() {
		return this.configSoMindownpayment;
	}

	public void setConfigSoMindownpayment(int configSoMindownpayment) {
		this.configSoMindownpayment = configSoMindownpayment;
	}

	public String getConfigSoPrefix() {
		return this.configSoPrefix;
	}

	public void setConfigSoPrefix(String configSoPrefix) {
		this.configSoPrefix = configSoPrefix;
	}

	public String getConfigSoSmsEnable() {
		return this.configSoSmsEnable;
	}

	public void setConfigSoSmsEnable(String configSoSmsEnable) {
		this.configSoSmsEnable = configSoSmsEnable;
	}

	public String getConfigSoSmsExeFormat() {
		return this.configSoSmsExeFormat;
	}

	public void setConfigSoSmsExeFormat(String configSoSmsExeFormat) {
		this.configSoSmsExeFormat = configSoSmsExeFormat;
	}

	public String getConfigSoSmsFormat() {
		return this.configSoSmsFormat;
	}

	public void setConfigSoSmsFormat(String configSoSmsFormat) {
		this.configSoSmsFormat = configSoSmsFormat;
	}

	public String getConfigSoTerms() {
		return this.configSoTerms;
	}

	public void setConfigSoTerms(String configSoTerms) {
		this.configSoTerms = configSoTerms;
	}

	public String getConfigTicketClosedEmailEnable() {
		return this.configTicketClosedEmailEnable;
	}

	public void setConfigTicketClosedEmailEnable(String configTicketClosedEmailEnable) {
		this.configTicketClosedEmailEnable = configTicketClosedEmailEnable;
	}

	public String getConfigTicketClosedEmailExeFormat() {
		return this.configTicketClosedEmailExeFormat;
	}

	public void setConfigTicketClosedEmailExeFormat(String configTicketClosedEmailExeFormat) {
		this.configTicketClosedEmailExeFormat = configTicketClosedEmailExeFormat;
	}

	public String getConfigTicketClosedEmailExeSub() {
		return this.configTicketClosedEmailExeSub;
	}

	public void setConfigTicketClosedEmailExeSub(String configTicketClosedEmailExeSub) {
		this.configTicketClosedEmailExeSub = configTicketClosedEmailExeSub;
	}

	public String getConfigTicketClosedEmailFormat() {
		return this.configTicketClosedEmailFormat;
	}

	public void setConfigTicketClosedEmailFormat(String configTicketClosedEmailFormat) {
		this.configTicketClosedEmailFormat = configTicketClosedEmailFormat;
	}

	public String getConfigTicketClosedEmailSub() {
		return this.configTicketClosedEmailSub;
	}

	public void setConfigTicketClosedEmailSub(String configTicketClosedEmailSub) {
		this.configTicketClosedEmailSub = configTicketClosedEmailSub;
	}

	public String getConfigTicketClosedSmsEnable() {
		return this.configTicketClosedSmsEnable;
	}

	public void setConfigTicketClosedSmsEnable(String configTicketClosedSmsEnable) {
		this.configTicketClosedSmsEnable = configTicketClosedSmsEnable;
	}

	public String getConfigTicketClosedSmsExeFormat() {
		return this.configTicketClosedSmsExeFormat;
	}

	public void setConfigTicketClosedSmsExeFormat(String configTicketClosedSmsExeFormat) {
		this.configTicketClosedSmsExeFormat = configTicketClosedSmsExeFormat;
	}

	public String getConfigTicketClosedSmsFormat() {
		return this.configTicketClosedSmsFormat;
	}

	public void setConfigTicketClosedSmsFormat(String configTicketClosedSmsFormat) {
		this.configTicketClosedSmsFormat = configTicketClosedSmsFormat;
	}

	public String getConfigTicketFollowupEmailEnable() {
		return this.configTicketFollowupEmailEnable;
	}

	public void setConfigTicketFollowupEmailEnable(String configTicketFollowupEmailEnable) {
		this.configTicketFollowupEmailEnable = configTicketFollowupEmailEnable;
	}

	public String getConfigTicketFollowupEmailExeFormat() {
		return this.configTicketFollowupEmailExeFormat;
	}

	public void setConfigTicketFollowupEmailExeFormat(String configTicketFollowupEmailExeFormat) {
		this.configTicketFollowupEmailExeFormat = configTicketFollowupEmailExeFormat;
	}

	public String getConfigTicketFollowupEmailExeSub() {
		return this.configTicketFollowupEmailExeSub;
	}

	public void setConfigTicketFollowupEmailExeSub(String configTicketFollowupEmailExeSub) {
		this.configTicketFollowupEmailExeSub = configTicketFollowupEmailExeSub;
	}

	public String getConfigTicketFollowupEmailFormat() {
		return this.configTicketFollowupEmailFormat;
	}

	public void setConfigTicketFollowupEmailFormat(String configTicketFollowupEmailFormat) {
		this.configTicketFollowupEmailFormat = configTicketFollowupEmailFormat;
	}

	public String getConfigTicketFollowupEmailSub() {
		return this.configTicketFollowupEmailSub;
	}

	public void setConfigTicketFollowupEmailSub(String configTicketFollowupEmailSub) {
		this.configTicketFollowupEmailSub = configTicketFollowupEmailSub;
	}

	public String getConfigTicketFollowupSmsEnable() {
		return this.configTicketFollowupSmsEnable;
	}

	public void setConfigTicketFollowupSmsEnable(String configTicketFollowupSmsEnable) {
		this.configTicketFollowupSmsEnable = configTicketFollowupSmsEnable;
	}

	public String getConfigTicketFollowupSmsExeFormat() {
		return this.configTicketFollowupSmsExeFormat;
	}

	public void setConfigTicketFollowupSmsExeFormat(String configTicketFollowupSmsExeFormat) {
		this.configTicketFollowupSmsExeFormat = configTicketFollowupSmsExeFormat;
	}

	public String getConfigTicketFollowupSmsFormat() {
		return this.configTicketFollowupSmsFormat;
	}

	public void setConfigTicketFollowupSmsFormat(String configTicketFollowupSmsFormat) {
		this.configTicketFollowupSmsFormat = configTicketFollowupSmsFormat;
	}

	public String getConfigTicketJcpsfEmailFormat() {
		return this.configTicketJcpsfEmailFormat;
	}

	public void setConfigTicketJcpsfEmailFormat(String configTicketJcpsfEmailFormat) {
		this.configTicketJcpsfEmailFormat = configTicketJcpsfEmailFormat;
	}

	public String getConfigTicketJcpsfEmailSub() {
		return this.configTicketJcpsfEmailSub;
	}

	public void setConfigTicketJcpsfEmailSub(String configTicketJcpsfEmailSub) {
		this.configTicketJcpsfEmailSub = configTicketJcpsfEmailSub;
	}

	public String getConfigTicketNewEmailEnable() {
		return this.configTicketNewEmailEnable;
	}

	public void setConfigTicketNewEmailEnable(String configTicketNewEmailEnable) {
		this.configTicketNewEmailEnable = configTicketNewEmailEnable;
	}

	public String getConfigTicketNewEmailExeFormat() {
		return this.configTicketNewEmailExeFormat;
	}

	public void setConfigTicketNewEmailExeFormat(String configTicketNewEmailExeFormat) {
		this.configTicketNewEmailExeFormat = configTicketNewEmailExeFormat;
	}

	public String getConfigTicketNewEmailExeSub() {
		return this.configTicketNewEmailExeSub;
	}

	public void setConfigTicketNewEmailExeSub(String configTicketNewEmailExeSub) {
		this.configTicketNewEmailExeSub = configTicketNewEmailExeSub;
	}

	public String getConfigTicketNewEmailFormat() {
		return this.configTicketNewEmailFormat;
	}

	public void setConfigTicketNewEmailFormat(String configTicketNewEmailFormat) {
		this.configTicketNewEmailFormat = configTicketNewEmailFormat;
	}

	public String getConfigTicketNewEmailSub() {
		return this.configTicketNewEmailSub;
	}

	public void setConfigTicketNewEmailSub(String configTicketNewEmailSub) {
		this.configTicketNewEmailSub = configTicketNewEmailSub;
	}

	public String getConfigTicketNewSmsEnable() {
		return this.configTicketNewSmsEnable;
	}

	public void setConfigTicketNewSmsEnable(String configTicketNewSmsEnable) {
		this.configTicketNewSmsEnable = configTicketNewSmsEnable;
	}

	public String getConfigTicketNewSmsExeFormat() {
		return this.configTicketNewSmsExeFormat;
	}

	public void setConfigTicketNewSmsExeFormat(String configTicketNewSmsExeFormat) {
		this.configTicketNewSmsExeFormat = configTicketNewSmsExeFormat;
	}

	public String getConfigTicketNewSmsFormat() {
		return this.configTicketNewSmsFormat;
	}

	public void setConfigTicketNewSmsFormat(String configTicketNewSmsFormat) {
		this.configTicketNewSmsFormat = configTicketNewSmsFormat;
	}

	public int getConfigTicketReopenLeadtime() {
		return this.configTicketReopenLeadtime;
	}

	public void setConfigTicketReopenLeadtime(int configTicketReopenLeadtime) {
		this.configTicketReopenLeadtime = configTicketReopenLeadtime;
	}

	public int getConfigTimezoneId() {
		return this.configTimezoneId;
	}

	public void setConfigTimezoneId(int configTimezoneId) {
		this.configTimezoneId = configTimezoneId;
	}

	public AxelaTimezone getAxelaTimezone() {
		return axelaTimezone;
	}

	public void setAxelaTimezone(AxelaTimezone axelaTimezone) {
		this.axelaTimezone = axelaTimezone;
	}

}