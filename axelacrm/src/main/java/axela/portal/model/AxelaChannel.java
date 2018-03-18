//package axela.portal.model;
//
//import java.io.Serializable;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Id;
//import javax.persistence.Lob;
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
///**
// * The persistent class for the axela_channel database table.
// * 
// */
//@Entity
//@Table(name = "axela_channel", catalog = AxelaChannel.comp_db)
//@NamedQuery(name = "AxelaChannel.findAll", query = "SELECT a FROM AxelaChannel a")
//public class AxelaChannel implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	protected static final String comp_db = "axela";
//
//	@Id
//	@Column(name = "channel_id")
//	private int channelId;
//
//	@Column(name = "channel_active")
//	private String channelActive;
//
//	@Column(name = "channel_address")
//	private String channelAddress;
//
//	@Column(name = "channel_city_id")
//	private int channelCityId;
//
//	@Column(name = "channel_currbal")
//	private double channelCurrbal;
//
//	@Column(name = "channel_domain")
//	private String channelDomain;
//
//	@Column(name = "channel_email_support")
//	private String channelEmailSupport;
//
//	@Column(name = "channel_email1")
//	private String channelEmail1;
//
//	@Column(name = "channel_email2")
//	private String channelEmail2;
//
//	@Column(name = "channel_entry_date")
//	private String channelEntryDate;
//
//	@Column(name = "channel_entry_id")
//	private int channelEntryId;
//
//	@Column(name = "channel_invoice_new_email_enable")
//	private String channelInvoiceNewEmailEnable;
//
//	@Lob
//	@Column(name = "channel_invoice_new_email_format")
//	private String channelInvoiceNewEmailFormat;
//
//	@Lob
//	@Column(name = "channel_invoice_new_email_sub")
//	private String channelInvoiceNewEmailSub;
//
//	@Column(name = "channel_landmark")
//	private String channelLandmark;
//
//	@Column(name = "channel_logo")
//	private String channelLogo;
//
//	@Column(name = "channel_mail_password")
//	private String channelMailPassword;
//
//	@Column(name = "channel_mail_port")
//	private String channelMailPort;
//
//	@Column(name = "channel_mail_server")
//	private String channelMailServer;
//
//	@Column(name = "channel_mail_ssl")
//	private String channelMailSsl;
//
//	@Column(name = "channel_mail_username")
//	private String channelMailUsername;
//
//	@Column(name = "channel_mobile_support")
//	private String channelMobileSupport;
//
//	@Column(name = "channel_mobile1")
//	private String channelMobile1;
//
//	@Column(name = "channel_mobile2")
//	private String channelMobile2;
//
//	@Column(name = "channel_modified_channel_date")
//	private String channelModifiedChannelDate;
//
//	@Column(name = "channel_modified_channeluser_id")
//	private int channelModifiedChanneluserId;
//
//	@Column(name = "channel_modified_date")
//	private String channelModifiedDate;
//
//	@Column(name = "channel_modified_id")
//	private int channelModifiedId;
//
//	@Column(name = "channel_name")
//	private String channelName;
//
//	@Lob
//	@Column(name = "channel_notes")
//	private String channelNotes;
//
//	@Column(name = "channel_order_expiry_email_enable")
//	private String channelOrderExpiryEmailEnable;
//
//	@Lob
//	@Column(name = "channel_order_expiry_email_format")
//	private String channelOrderExpiryEmailFormat;
//
//	@Lob
//	@Column(name = "channel_order_expiry_email_sub")
//	private String channelOrderExpiryEmailSub;
//
//	@Column(name = "channel_order_new_email_enable")
//	private String channelOrderNewEmailEnable;
//
//	@Lob
//	@Column(name = "channel_order_new_email_format")
//	private String channelOrderNewEmailFormat;
//
//	@Lob
//	@Column(name = "channel_order_new_email_sub")
//	private String channelOrderNewEmailSub;
//
//	@Column(name = "channel_phone1")
//	private String channelPhone1;
//
//	@Column(name = "channel_phone2")
//	private String channelPhone2;
//
//	@Lob
//	@Column(name = "channel_pic")
//	private byte[] channelPic;
//
//	@Column(name = "channel_pin")
//	private String channelPin;
//
//	@Column(name = "channel_product")
//	private String channelProduct;
//
//	@Column(name = "channel_quote_new_email_enable")
//	private String channelQuoteNewEmailEnable;
//
//	@Lob
//	@Column(name = "channel_quote_new_email_format")
//	private String channelQuoteNewEmailFormat;
//
//	@Lob
//	@Column(name = "channel_quote_new_email_sub")
//	private String channelQuoteNewEmailSub;
//
//	@Column(name = "channel_receipt_new_email_enable")
//	private String channelReceiptNewEmailEnable;
//
//	@Lob
//	@Column(name = "channel_receipt_new_email_format")
//	private String channelReceiptNewEmailFormat;
//
//	@Lob
//	@Column(name = "channel_receipt_new_email_sub")
//	private String channelReceiptNewEmailSub;
//
//	@Column(name = "channel_self_branding")
//	private String channelSelfBranding;
//
//	@Column(name = "channel_self_support")
//	private String channelSelfSupport;
//
//	@Column(name = "channel_sms_url")
//	private String channelSmsUrl;
//
//	@Column(name = "channel_stax")
//	private double channelStax;
//
//	@Column(name = "channel_ticket_channeluser_id")
//	private int channelTicketChanneluserId;
//
//	@Column(name = "channel_type_id")
//	private int channelTypeId;
//
//	@Column(name = "channel_user_id")
//	private int channelUserId;
//
//	@Column(name = "channel_website1")
//	private String channelWebsite1;
//
//	// bi-directional many-to-one association to AxelaComp
//	@OneToMany(mappedBy = "axelaChannel")
//	private List<AxelaComp> axelaComps;
//
//	public AxelaChannel() {
//	}
//
//	public int getChannelId() {
//		return this.channelId;
//	}
//
//	public void setChannelId(int channelId) {
//		this.channelId = channelId;
//	}
//
//	public String getChannelActive() {
//		return this.channelActive;
//	}
//
//	public void setChannelActive(String channelActive) {
//		this.channelActive = channelActive;
//	}
//
//	public String getChannelAddress() {
//		return this.channelAddress;
//	}
//
//	public void setChannelAddress(String channelAddress) {
//		this.channelAddress = channelAddress;
//	}
//
//	public int getChannelCityId() {
//		return this.channelCityId;
//	}
//
//	public void setChannelCityId(int channelCityId) {
//		this.channelCityId = channelCityId;
//	}
//
//	public double getChannelCurrbal() {
//		return this.channelCurrbal;
//	}
//
//	public void setChannelCurrbal(double channelCurrbal) {
//		this.channelCurrbal = channelCurrbal;
//	}
//
//	public String getChannelDomain() {
//		return this.channelDomain;
//	}
//
//	public void setChannelDomain(String channelDomain) {
//		this.channelDomain = channelDomain;
//	}
//
//	public String getChannelEmailSupport() {
//		return this.channelEmailSupport;
//	}
//
//	public void setChannelEmailSupport(String channelEmailSupport) {
//		this.channelEmailSupport = channelEmailSupport;
//	}
//
//	public String getChannelEmail1() {
//		return this.channelEmail1;
//	}
//
//	public void setChannelEmail1(String channelEmail1) {
//		this.channelEmail1 = channelEmail1;
//	}
//
//	public String getChannelEmail2() {
//		return this.channelEmail2;
//	}
//
//	public void setChannelEmail2(String channelEmail2) {
//		this.channelEmail2 = channelEmail2;
//	}
//
//	public String getChannelEntryDate() {
//		return this.channelEntryDate;
//	}
//
//	public void setChannelEntryDate(String channelEntryDate) {
//		this.channelEntryDate = channelEntryDate;
//	}
//
//	public int getChannelEntryId() {
//		return this.channelEntryId;
//	}
//
//	public void setChannelEntryId(int channelEntryId) {
//		this.channelEntryId = channelEntryId;
//	}
//
//	public String getChannelInvoiceNewEmailEnable() {
//		return this.channelInvoiceNewEmailEnable;
//	}
//
//	public void setChannelInvoiceNewEmailEnable(String channelInvoiceNewEmailEnable) {
//		this.channelInvoiceNewEmailEnable = channelInvoiceNewEmailEnable;
//	}
//
//	public String getChannelInvoiceNewEmailFormat() {
//		return this.channelInvoiceNewEmailFormat;
//	}
//
//	public void setChannelInvoiceNewEmailFormat(String channelInvoiceNewEmailFormat) {
//		this.channelInvoiceNewEmailFormat = channelInvoiceNewEmailFormat;
//	}
//
//	public String getChannelInvoiceNewEmailSub() {
//		return this.channelInvoiceNewEmailSub;
//	}
//
//	public void setChannelInvoiceNewEmailSub(String channelInvoiceNewEmailSub) {
//		this.channelInvoiceNewEmailSub = channelInvoiceNewEmailSub;
//	}
//
//	public String getChannelLandmark() {
//		return this.channelLandmark;
//	}
//
//	public void setChannelLandmark(String channelLandmark) {
//		this.channelLandmark = channelLandmark;
//	}
//
//	public String getChannelLogo() {
//		return this.channelLogo;
//	}
//
//	public void setChannelLogo(String channelLogo) {
//		this.channelLogo = channelLogo;
//	}
//
//	public String getChannelMailPassword() {
//		return this.channelMailPassword;
//	}
//
//	public void setChannelMailPassword(String channelMailPassword) {
//		this.channelMailPassword = channelMailPassword;
//	}
//
//	public String getChannelMailPort() {
//		return this.channelMailPort;
//	}
//
//	public void setChannelMailPort(String channelMailPort) {
//		this.channelMailPort = channelMailPort;
//	}
//
//	public String getChannelMailServer() {
//		return this.channelMailServer;
//	}
//
//	public void setChannelMailServer(String channelMailServer) {
//		this.channelMailServer = channelMailServer;
//	}
//
//	public String getChannelMailSsl() {
//		return this.channelMailSsl;
//	}
//
//	public void setChannelMailSsl(String channelMailSsl) {
//		this.channelMailSsl = channelMailSsl;
//	}
//
//	public String getChannelMailUsername() {
//		return this.channelMailUsername;
//	}
//
//	public void setChannelMailUsername(String channelMailUsername) {
//		this.channelMailUsername = channelMailUsername;
//	}
//
//	public String getChannelMobileSupport() {
//		return this.channelMobileSupport;
//	}
//
//	public void setChannelMobileSupport(String channelMobileSupport) {
//		this.channelMobileSupport = channelMobileSupport;
//	}
//
//	public String getChannelMobile1() {
//		return this.channelMobile1;
//	}
//
//	public void setChannelMobile1(String channelMobile1) {
//		this.channelMobile1 = channelMobile1;
//	}
//
//	public String getChannelMobile2() {
//		return this.channelMobile2;
//	}
//
//	public void setChannelMobile2(String channelMobile2) {
//		this.channelMobile2 = channelMobile2;
//	}
//
//	public String getChannelModifiedChannelDate() {
//		return this.channelModifiedChannelDate;
//	}
//
//	public void setChannelModifiedChannelDate(String channelModifiedChannelDate) {
//		this.channelModifiedChannelDate = channelModifiedChannelDate;
//	}
//
//	public int getChannelModifiedChanneluserId() {
//		return this.channelModifiedChanneluserId;
//	}
//
//	public void setChannelModifiedChanneluserId(int channelModifiedChanneluserId) {
//		this.channelModifiedChanneluserId = channelModifiedChanneluserId;
//	}
//
//	public String getChannelModifiedDate() {
//		return this.channelModifiedDate;
//	}
//
//	public void setChannelModifiedDate(String channelModifiedDate) {
//		this.channelModifiedDate = channelModifiedDate;
//	}
//
//	public int getChannelModifiedId() {
//		return this.channelModifiedId;
//	}
//
//	public void setChannelModifiedId(int channelModifiedId) {
//		this.channelModifiedId = channelModifiedId;
//	}
//
//	public String getChannelName() {
//		return this.channelName;
//	}
//
//	public void setChannelName(String channelName) {
//		this.channelName = channelName;
//	}
//
//	public String getChannelNotes() {
//		return this.channelNotes;
//	}
//
//	public void setChannelNotes(String channelNotes) {
//		this.channelNotes = channelNotes;
//	}
//
//	public String getChannelOrderExpiryEmailEnable() {
//		return this.channelOrderExpiryEmailEnable;
//	}
//
//	public void setChannelOrderExpiryEmailEnable(String channelOrderExpiryEmailEnable) {
//		this.channelOrderExpiryEmailEnable = channelOrderExpiryEmailEnable;
//	}
//
//	public String getChannelOrderExpiryEmailFormat() {
//		return this.channelOrderExpiryEmailFormat;
//	}
//
//	public void setChannelOrderExpiryEmailFormat(String channelOrderExpiryEmailFormat) {
//		this.channelOrderExpiryEmailFormat = channelOrderExpiryEmailFormat;
//	}
//
//	public String getChannelOrderExpiryEmailSub() {
//		return this.channelOrderExpiryEmailSub;
//	}
//
//	public void setChannelOrderExpiryEmailSub(String channelOrderExpiryEmailSub) {
//		this.channelOrderExpiryEmailSub = channelOrderExpiryEmailSub;
//	}
//
//	public String getChannelOrderNewEmailEnable() {
//		return this.channelOrderNewEmailEnable;
//	}
//
//	public void setChannelOrderNewEmailEnable(String channelOrderNewEmailEnable) {
//		this.channelOrderNewEmailEnable = channelOrderNewEmailEnable;
//	}
//
//	public String getChannelOrderNewEmailFormat() {
//		return this.channelOrderNewEmailFormat;
//	}
//
//	public void setChannelOrderNewEmailFormat(String channelOrderNewEmailFormat) {
//		this.channelOrderNewEmailFormat = channelOrderNewEmailFormat;
//	}
//
//	public String getChannelOrderNewEmailSub() {
//		return this.channelOrderNewEmailSub;
//	}
//
//	public void setChannelOrderNewEmailSub(String channelOrderNewEmailSub) {
//		this.channelOrderNewEmailSub = channelOrderNewEmailSub;
//	}
//
//	public String getChannelPhone1() {
//		return this.channelPhone1;
//	}
//
//	public void setChannelPhone1(String channelPhone1) {
//		this.channelPhone1 = channelPhone1;
//	}
//
//	public String getChannelPhone2() {
//		return this.channelPhone2;
//	}
//
//	public void setChannelPhone2(String channelPhone2) {
//		this.channelPhone2 = channelPhone2;
//	}
//
//	public byte[] getChannelPic() {
//		return this.channelPic;
//	}
//
//	public void setChannelPic(byte[] channelPic) {
//		this.channelPic = channelPic;
//	}
//
//	public String getChannelPin() {
//		return this.channelPin;
//	}
//
//	public void setChannelPin(String channelPin) {
//		this.channelPin = channelPin;
//	}
//
//	public String getChannelProduct() {
//		return this.channelProduct;
//	}
//
//	public void setChannelProduct(String channelProduct) {
//		this.channelProduct = channelProduct;
//	}
//
//	public String getChannelQuoteNewEmailEnable() {
//		return this.channelQuoteNewEmailEnable;
//	}
//
//	public void setChannelQuoteNewEmailEnable(String channelQuoteNewEmailEnable) {
//		this.channelQuoteNewEmailEnable = channelQuoteNewEmailEnable;
//	}
//
//	public String getChannelQuoteNewEmailFormat() {
//		return this.channelQuoteNewEmailFormat;
//	}
//
//	public void setChannelQuoteNewEmailFormat(String channelQuoteNewEmailFormat) {
//		this.channelQuoteNewEmailFormat = channelQuoteNewEmailFormat;
//	}
//
//	public String getChannelQuoteNewEmailSub() {
//		return this.channelQuoteNewEmailSub;
//	}
//
//	public void setChannelQuoteNewEmailSub(String channelQuoteNewEmailSub) {
//		this.channelQuoteNewEmailSub = channelQuoteNewEmailSub;
//	}
//
//	public String getChannelReceiptNewEmailEnable() {
//		return this.channelReceiptNewEmailEnable;
//	}
//
//	public void setChannelReceiptNewEmailEnable(String channelReceiptNewEmailEnable) {
//		this.channelReceiptNewEmailEnable = channelReceiptNewEmailEnable;
//	}
//
//	public String getChannelReceiptNewEmailFormat() {
//		return this.channelReceiptNewEmailFormat;
//	}
//
//	public void setChannelReceiptNewEmailFormat(String channelReceiptNewEmailFormat) {
//		this.channelReceiptNewEmailFormat = channelReceiptNewEmailFormat;
//	}
//
//	public String getChannelReceiptNewEmailSub() {
//		return this.channelReceiptNewEmailSub;
//	}
//
//	public void setChannelReceiptNewEmailSub(String channelReceiptNewEmailSub) {
//		this.channelReceiptNewEmailSub = channelReceiptNewEmailSub;
//	}
//
//	public String getChannelSelfBranding() {
//		return this.channelSelfBranding;
//	}
//
//	public void setChannelSelfBranding(String channelSelfBranding) {
//		this.channelSelfBranding = channelSelfBranding;
//	}
//
//	public String getChannelSelfSupport() {
//		return this.channelSelfSupport;
//	}
//
//	public void setChannelSelfSupport(String channelSelfSupport) {
//		this.channelSelfSupport = channelSelfSupport;
//	}
//
//	public String getChannelSmsUrl() {
//		return this.channelSmsUrl;
//	}
//
//	public void setChannelSmsUrl(String channelSmsUrl) {
//		this.channelSmsUrl = channelSmsUrl;
//	}
//
//	public double getChannelStax() {
//		return this.channelStax;
//	}
//
//	public void setChannelStax(double channelStax) {
//		this.channelStax = channelStax;
//	}
//
//	public int getChannelTicketChanneluserId() {
//		return this.channelTicketChanneluserId;
//	}
//
//	public void setChannelTicketChanneluserId(int channelTicketChanneluserId) {
//		this.channelTicketChanneluserId = channelTicketChanneluserId;
//	}
//
//	public int getChannelTypeId() {
//		return this.channelTypeId;
//	}
//
//	public void setChannelTypeId(int channelTypeId) {
//		this.channelTypeId = channelTypeId;
//	}
//
//	public int getChannelUserId() {
//		return this.channelUserId;
//	}
//
//	public void setChannelUserId(int channelUserId) {
//		this.channelUserId = channelUserId;
//	}
//
//	public String getChannelWebsite1() {
//		return this.channelWebsite1;
//	}
//
//	public void setChannelWebsite1(String channelWebsite1) {
//		this.channelWebsite1 = channelWebsite1;
//	}
//	public List<AxelaComp> getAxelaComps() {
//		return this.axelaComps;
//	}
//
//	public void setAxelaComps(List<AxelaComp> axelaComps) {
//		this.axelaComps = axelaComps;
//	}
//	//
//	// public AxelaComp addAxelaComp(AxelaComp axelaComp) {
//	// getAxelaComps().add(axelaComp);
//	// axelaComp.setAxelaChannel(this);
//	//
//	// return axelaComp;
//	// }
//	//
//	// public AxelaComp removeAxelaComp(AxelaComp axelaComp) {
//	// getAxelaComps().remove(axelaComp);
//	// axelaComp.setAxelaChannel(null);
//	//
//	// return axelaComp;
//	// }
//
// }