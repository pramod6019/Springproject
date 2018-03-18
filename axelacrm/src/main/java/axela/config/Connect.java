//sharath
package axela.config;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Multipart;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import axela.portal.model.AxelaComp;
import axela.portal.model.AxelaConfig;
import axela.portal.model.AxelaEmp;
import axela.portal.repository.CompRepository;
import axela.portal.repository.ConfigFilterImpl;
import axela.portal.repository.ConfigRepository;
import axela.portal.repository.EmpFilterImpl;
import axela.portal.repository.SigninRepository;
import axela.portal.repository.TimeZoneRepository;
import axela.portal.service.SigninService;
//import org.apache.commons.io.IOUtils;
//import org.apache.commons.io.output.ByteArrayOutputStream;
//import org.apache.commons.lang3.StringEscapeUtils;
//import org.codehaus.jettison.json.JSONException;
//import org.codehaus.jettison.json.JSONObject;

@Component
@Service
public class Connect extends ConnectDate {

	@Autowired
	SigninRepository signinrepository;

	@Autowired
	CompRepository axelacomprepository;

	@Autowired
	ConfigRepository configRepository;

	@Autowired
	SigninService signinService;

	@Autowired
	private ConfigFilterImpl configFilterImpl;

	@Autowired
	public EmpFilterImpl empFilterImpl;

	@Autowired
	TimeZoneRepository timeZoneRepository;

	public static String ClientName = "Emax";
	public static String ClientTeam = "Team Emax";
	public static String AppName = "Axela CRM";
	public static String ReportFooter = "Copyright &copy; " + ClientName
			+ ". All rights reserved.";
	public Connection conn;
	public Statement stmt;
	// public DbConnectionBroker myBroker;
	public static String ImageFormats = ".jpg, .jpeg, .gif, .png";
	public String StrProp = "";

	public static String jsver = "1.24";
	DecimalFormat df = new DecimalFormat("0.00");
	public BufferedImage bufferedImage = null;
	private String ImgWidth = "";

	public Connect() {
		// SOP("In connect class");
	}

	public String AppRun() {
		String State = "0";
		State = new axela.config.AppState().AppRunState();
		return State;
	}

	public Date kknow() {
		Date date;
		if (AppRun().equals("1")) {
			date = addHoursDate(new Date(), 0, 0, -330);
		} else {
			date = addHoursDate(new Date(), 0, 0, -330);
		}
		// System.out.println("Date Kknow()=====" + date);
		return date;
	}
	public Date adminkknow() {
		Date date;
		if (AppRun().equals("1")) {
			date = addHoursDate(new Date(), 0, 0, 0);
		} else {
			date = addHoursDate(new Date(), 0, 0, 0);
		}
		return date;
	}

	public Connection connectDB() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/ConnectDB");
			conn = ds.getConnection();

			// SOP("con==========" + conn);
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError(new Exception().getStackTrace()[0].getMethodName() + " : " + ex);
		}
		// SOP("connection returned......");
		return conn;
	}

	public String AppURL() {
		String url;
		if (AppRun().equals("1")) {
			url = "http://demo.axelacrm.in/axelacrm";
		} else {
			url = "http://192.168.0.15:6010/axelacrm";
		}
		return url;
	}

	public String WSUrl() {
		String url = "";
		if (AppRun().equals("1")) {
			url = "http://demo.axelacrm.in/axelacrm";
		} else {
			url = "http://192.168.0.15:6010/axelacrm";
		}
		return url;
	}

	public String MediaPath() {
		String path;
		if (AppRun().equals("1")) {
			path = "c:/media/axela";
			path = "//var/media/axela";
		} else {
			path = getClass().getClassLoader().getResource("").getPath();
			path = path.substring(0, path.indexOf("."));
			path = path + "axela/media";
		}
		return path;
	}

	public String HelpImagePath() {
		String path;
		if (AppRun().equals("1")) {
			path = MediaPath() + "/helpimage/";
		} else {
			path = MediaPath() + "/helpimage/";
		}
		return path;
	}

	public String ChannelQuotePath() {
		String path;
		if (AppRun().equals("1")) {
			path = MediaPath() + "/channelquote/";
		} else {
			path = MediaPath() + "/channelquote/";
		}
		return path;
	}

	public String TemplatePath() {
		String path;
		if (AppRun().equals("1")) {
			path = MediaPath() + "/template/";
		} else {
			path = MediaPath() + "/template/";
		}
		return path;
	}

	public String CachePath(String comp_id) {
		String path;
		if (AppRun().equals("1")) {
			path = MediaPath() + "/cache/axela_" + comp_id + "/";
		} else {
			path = MediaPath() + "/cache/axela_" + comp_id + "/";
		}
		return path;
	}

	public String ExeImportPath(String comp_id) {
		String path;
		if (AppRun().equals("1")) {
			path = CachePath(comp_id) + "/exeimport/";
		} else {
			path = CachePath(comp_id) + "/exeimport/";
		}
		return path;
	}

	public String CustomerImportPath(String comp_id) {
		String path;
		if (AppRun().equals("1")) {
			path = CachePath(comp_id) + "/customerimport/";
		} else {
			path = CachePath(comp_id) + "/customerimport/";
		}
		return path;
	}

	public String TempPath() {
		String path;
		if (AppRun().equals("1")) {
			path = MediaPath() + "/temp/";
		} else {
			path = MediaPath() + "/temp/";
		}
		return path;
	}

	public String LeadImportPath(String comp_id) {
		String path;
		if (AppRun().equals("1")) {
			path = CachePath(comp_id) + "/leadimport/";
		} else {
			path = CachePath(comp_id) + "/leadimport/";
		}
		return path;
	}

	public String LimitRecords(int totalrecords, String pagecurrent) {
		int StartRec = 0;
		int EndRec = 0;
		int recperpage = 25;
		StartRec = ((Integer.parseInt(pagecurrent) - 1) * recperpage) + 1;
		EndRec = ((Integer.parseInt(pagecurrent) - 1) * recperpage)
				+ recperpage;
		return " limit " + (StartRec - 1) + ", " + recperpage + "";

	}

	public String CompImageSize(String comp_id) {
		return ExecuteQuery("SELECT config_image_size FROM " + compdb(comp_id)
				+ "axela_config");
	}

	public String ImageSize(String comp_id) {
		return ExecuteQuery("Select config_image_size from " + compdb(comp_id)
				+ "axela_config ");
	}

	public String maindb() {
		return "axela_";
	}

	public String compdb(String id) {
		return "axela_" + id + ".";
	}

	public Date getTimeByZone(HttpSession session) throws ParseException {
		int hours = 0;
		int minute = 0;
		double days = 0.0;
		String output = "";
		minute = Integer.parseInt(PadQuotes(getSession("timeZoneValue", session)));
		hours = minute / 60;
		minute = minute - hours * 60;
		if (String.valueOf(hours).length() == 1) {
			output = "0" + hours;
		}
		else {
			output = hours + "";
		}
		if (String.valueOf(minute).length() == 1) {
			output = output + "0" + minute;
		}
		else {
			output = output + minute;
		}
		output = output + "00";
		Date date = kknow();
		Date date1 = addHoursDate(date, days, hours, minute);
		return date1;
	}

	public Date gettimebyzone(String comp_id) throws ParseException {
		Date str = null;
		// str = configFilterImpl.gettimebyzone(session);
		return str;
	}

	public String gettimebyzonesql(String comp_id, String time) {
		String str = "";
		str = "(SELECT DATE_FORMAT(DATE_ADD('" + time + "', INTERVAL timezone_value MINUTE), '%Y%m%d%H%i%s') AS time"
				+ " FROM " + compdb(comp_id) + "axela_config"
				+ " INNER JOIN axela." + maindb() + "timezone ON timezone_id = config_timezone_id)";

		return str;
	}

	public String ReportStartdate(String time, String toformat) throws ParseException {
		String date = "";

		if (AppRun().equals("1")) {
			date = formatDate(time, toformat);
		} else {
			date = formatDate(toLongDate(addHoursDate(stringToDate(time), -30, 0, 0)), toformat);
		}
		return date;
	}

	public String ReportStartdate() throws ParseException {
		ConnectDate cdate = new ConnectDate();
		String date;
		if (AppRun().equals("1")) {
			date = cdate.strToShortDate(new SimpleDateFormat("dd/MM/yyyy").parse(cdate.toShortDate(kknow())));
		} else {
			date = cdate.strToShortDate(new SimpleDateFormat("dd/MM/yyyy").parse(cdate.toShortDate(cdate.addHoursDate(kknow(), -30, 0, 0))));
		}
		return date;
	}

	public void SOP(String Str) {
		if (AppRun().equals("0")) {
			System.out.println(Str);
		}
	}

	public void SOPInfo(String Str) {
		if (AppRun().equals("0")) {
			SOP(Str);
		} else {
			final Logger logger = Logger.getLogger(this.getClass());
			logger.info(Str);
		}
	}

	public void SOPError(String Str) {
		if (AppRun().equals("0")) {
			SOP(Str);
		} else {
			final Logger logger = Logger.getLogger(this.getClass());
			logger.error(Str);
		}
	}

	public ResultSet processQuery(String strSQL) {
		ResultSet rsq = null;
		try {
			conn = connectDB();
			stmt = conn.createStatement();
			rsq = stmt.executeQuery(strSQL);
			return (rsq);
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			return null;
		} finally {
			// try {
			// if (stmt != null) {
			// stmt.close();
			// }
			// if (rsq != null) {
			// rsq.close();
			// }
			// } catch (Exception ex) {
			// SOPError( this.getClass().getName());
			// SOPError("Error in " + new
			// Exception().getStackTrace()[0].getMethodName() + " : " + ex);
			// }
			// // The connection is returned to the Broker
			// myBroker.freeConnection(conn);
			// myBroker.destroy();
		}
	}

	public CachedRowSet processQuery(String StrSQL, int minutes) {
		ResultSet rspq = null;
		try {
			conn = connectDB();
			stmt = conn.createStatement();
			// SOP("ProcessQuery strSQL---"+strSQL);
			rspq = stmt.executeQuery(StrSQL);
			CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
			// CachedRowSet crs = null;
			// crs.setMetaData((RowSetMetaData) rspq.getMetaData());
			crs.populate(rspq);
			return (crs);
		} catch (SQLException ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			return null;
		} finally {
			try {
				if (rspq != null) {
					rspq.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				SOPError(this.getClass().getName());
				SOPError("Error in "
						+ new Exception().getStackTrace()[0].getMethodName()
						+ " : " + ex);
			}
		}
	}

	public CachedRowSet processPrepQuery(String StrSql,
			Map<Integer, Object> qparams, int minutes) {
		ResultSet rspq = null;
		try {
			conn = connectDB();
			// SOP("processPrepQuery strSQL---" + strSQL);
			PreparedStatement stmt = conn.prepareStatement(StrSql);
			for (Integer key : qparams.keySet()) {
				stmt.setObject(key, qparams.get(key));
			}
			rspq = stmt.executeQuery();
			CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
			// CachedRowSet crs = null;
			crs.populate(rspq);
			return (crs);
		} catch (SQLException ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			return null;
		} finally {
			try {
				if (rspq != null) {
					rspq.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				SOPError(this.getClass().getName());
				SOPError("Error in "
						+ new Exception().getStackTrace()[0].getMethodName()
						+ " : " + ex);
			}
		}
	}

	public int updateQuery(String strSQL) {
		int rsq;
		try {
			conn = connectDB();
			stmt = conn.createStatement();
			rsq = stmt.executeUpdate(strSQL);
			return (rsq);
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			return 0;
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception ex) {
				SOPError(this.getClass().getName());
				SOPError("Error in "
						+ new Exception().getStackTrace()[0].getMethodName()
						+ " : " + ex);
			}
		}
	}

	public String ExecuteQuery(String strSQL) {
		ResultSet rsexeq = null;
		String res = "";
		try {
			conn = connectDB();
			stmt = conn.createStatement();
			rsexeq = stmt.executeQuery(strSQL);
			while (rsexeq.next()) {
				res = rsexeq.getString(1);
			}
			return res;
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			return "0";
		} finally {
			try {
				if (rsexeq != null) {
					rsexeq.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception ex) {
				SOPError(this.getClass().getName());
				SOPError("Error in "
						+ new Exception().getStackTrace()[0].getMethodName()
						+ " : " + ex);
			}
			// The connection is returned to the Broker
			//
		}
	}

	public String PopulateExecutives(String emp_id, String comp_id) {
		StringBuilder Str = new StringBuilder();
		String StrSql = "";
		try {

			StrSql = "SELECT emp_id, CONCAT(emp_name, ' (', emp_ref_no, ')') AS emp_name"
					+ " FROM  " + compdb(comp_id) + "axela_emp"
					+ " WHERE emp_active = 1"
					+ " GROUP BY emp_id"
					+ " ORDER BY emp_name";
			CachedRowSet crs = processQuery(StrSql, 0);
			// SOP("StrSql===PopulateExecutives==" + StrSql);
			Str.append("<select name=\"dr_executive\" id=\"dr_executive\" class=\"form-control\">");
			Str.append("<option value=\"0\">Select Executive</option>\n");
			while (crs.next()) {
				Str.append("<option value=").append(crs.getString("emp_id"));
				Str.append(Selectdrop((int) crs.getDouble("emp_id"), emp_id));
				Str.append(">").append(crs.getString("emp_name"))
						.append("</option>\n");
			}
			Str.append("</select>");
			crs.close();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
			return "";
		}
		return Str.toString();
	}

	public String PopulateExecutives(String emp_id, String branch_id, String comp_id) {
		StringBuilder Str = new StringBuilder();
		String StrSql = "";
		try {
			Str.append("<select name=\"dr_executive\" id=\"dr_executive\" class=\"form-control\">");
			Str.append("<option value=\"0\">Select Executive</option>\n");
			StrSql = "SELECT emp_id, CONCAT(emp_name, ' (', emp_ref_no, ')') AS emp_name"
					+ " FROM  " + compdb(comp_id) + "axela_emp"
					+ " WHERE emp_active = 1";
			if (!branch_id.equals("")) {
				StrSql += " AND emp_branch_id = " + branch_id;
			}
			StrSql += " GROUP BY emp_id"
					+ " ORDER BY emp_name";
			CachedRowSet crs = processQuery(StrSql, 0);
			// SOP("StrSql===PopulateExecutives==" + StrSql);
			while (crs.next()) {
				Str.append("<option value=").append(crs.getString("emp_id"));
				Str.append(Selectdrop((int) crs.getDouble("emp_id"), emp_id));
				Str.append(">").append(crs.getString("emp_name"))
						.append("</option>\n");
			}
			Str.append("</select>");
			crs.close();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
			return "";
		}
		return Str.toString();
	}

	public void CopySalesItemToCart(HttpServletRequest request,
			String emp_id, String cart_session_id, String voucher_so_id,
			String voucher_vouchertype_id, String status) throws Exception {

		CachedRowSet crs = null;
		int rowcount = 1, optionid = 0;
		double tax_value[] = new double[3];
		String msg = "", rateclass_id = "0";
		try {
			String StrSql = "";
			String comp_id = CNumeric(GetSession("comp_id", request));

			StrSql = "DELETE FROM " + compdb(comp_id) + "axela_acc_cart"
					+ " WHERE 1=1" + ""
					+ " AND cart_vouchertype_id = " + voucher_vouchertype_id + ""
					+ " AND cart_emp_id = " + emp_id + ""
					+ " AND cart_session_id = " + cart_session_id
					+ " AND SUBSTR(cart_time,1,8) < SUBSTR(" + toShortDate(kknow()) + ",1,8)";
			updateQuery(StrSql);

			StrSql = "SELECT rateclass_id"
					+ " FROM " + compdb(comp_id) + "axela_sales_so"
					+ " INNER JOIN " + compdb(comp_id) + "axela_branch ON branch_id = voucher_branch_id"
					+ " INNER JOIN " + compdb(comp_id) + "axela_rate_class ON rateclass_id = branch_rateclass_id"
					+ " WHERE so_id = " + voucher_so_id;
			rateclass_id = CNumeric(ExecuteQuery(StrSql));

			StrSql = "SELECT COALESCE(price_id, 0) AS price_id,"
					+ " COALESCE(price_rateclass_id, 0) AS price_rateclass_id,"
					+ " soitem_item_id, item_name,"
					+ " soitem_qty, soitem_price, soitem_disc,"
					+ " COALESCE (tax1.customer_id, 0) AS tax_id1,"
					+ " COALESCE (tax1.customer_rate, 0) AS tax_value1,"
					// + "	COALESCE (tax1.tax_customer_id, 0) AS tax_customer_id1,"
					+ "	COALESCE (price_tax2_after_tax1, 0 ) AS price_tax2_after_tax1,"
					+ " COALESCE (tax2.customer_id, 0) AS tax_id2,"
					+ " COALESCE (tax2.customer_rate, 0) AS tax_value2,"
					// + "	COALESCE (tax2.tax_customer_id, 0) AS tax_customer_id2,"
					+ "	COALESCE (price_tax3_after_tax2, 0 ) AS price_tax3_after_tax2,"
					+ " COALESCE (tax3.customer_id, 0) AS tax_id3,"
					+ " COALESCE (tax3.customer_rate, 0) AS tax_value3,"
					// + "	COALESCE (tax3.tax_customer_id, 0) AS tax_customer_id3,"
					+ " soitem_total, item_alt_uom_id,"
					+ " COALESCE(price_sales_customer_id, 0) AS price_sales_customer_id,"
					+ " COALESCE(price_discount1_customer_id, 0) AS price_discount1_customer_id"
					+ " FROM " + compdb(comp_id) + "axela_sales_so_item"
					+ " INNER JOIN " + compdb(comp_id) + "axela_sales_so ON so_id = soitem_so_id"
					+ " INNER JOIN " + compdb(comp_id) + "axela_inventory_item ON item_id = soitem_item_id"
					+ " LEFT JOIN " + compdb(comp_id) + "axela_inventory_item_price ON price_item_id = item_id"
					+ " AND price_effective_from = ( SELECT price_effective_from"
					+ " FROM " + compdb(comp_id) + "axela_inventory_item_price"
					+ " WHERE price_item_id = item_id"
					+ " AND price_effective_from <= ( SELECT quote_date "
					+ "	FROM " + compdb(comp_id) + "axela_sales_quote"
					+ " WHERE quote_id = so_quote_id )"
					+ " ORDER BY price_effective_from DESC LIMIT 1 )"
					+ "	LEFT JOIN " + compdb(comp_id) + "axela_rate_class ON rateclass_id = ( SELECT branch_rateclass_id"
					+ " FROM " + compdb(comp_id) + "axela_branch WHERE branch_id = voucher_branch_id )"
					+ " AND rateclass_id = price_rateclass_id"
					+ " LEFT JOIN " + compdb(comp_id) + "axela_customer tax1 ON tax1.customer_id = price_tax1_id"
					+ " LEFT JOIN " + compdb(comp_id) + "axela_customer tax2 ON tax2.customer_id = price_tax2_id"
					+ " LEFT JOIN " + compdb(comp_id) + "axela_customer tax3 ON tax3.customer_id = price_tax3_id"
					+ " WHERE"
					+ " so_id = " + voucher_so_id;

			// SOP("main Query====" + StrSql);

			crs = processQuery(StrSql, 0);

			while (crs.next()) {
				if ((crs.getString("price_rateclass_id").equals(rateclass_id)) ||
						(crs.getString("price_id").equals("0") && crs.getString("price_rateclass_id").equals("0"))) {
					optionid = rowcount;
					if (!crs.getString("tax_id1").equals("0")) {
						// Tax value for tax_value1
						tax_value[0] = (crs.getDouble("tax_value1") * crs.getDouble("soitem_total")) / 100;
					}

					if (!crs.getString("tax_id2").equals("0")) {
						// Tax value for tax_value2
						if (crs.getString("price_tax2_after_tax1").equals("1")) {
							tax_value[1] = (crs.getDouble("tax_value2") * (crs.getDouble("soitem_total") + tax_value[0])) / 100;
						} else {
							tax_value[1] = (crs.getDouble("tax_value2") * crs.getDouble("soitem_total")) / 100;
						}
					}

					if (!crs.getString("tax_id3").equals("0")) {
						// Tax value for tax_value3
						if (crs.getString("price_tax3_after_tax2").equals("1")) {
							tax_value[2] = (crs.getDouble("tax_value3") * (crs.getDouble("soitem_total") + tax_value[1])) / 100;
						} else {
							tax_value[2] = (crs.getDouble("tax_value3") * crs.getDouble("soitem_total")) / 100;
						}
					}

					// This Query will insert row for main item into cart...

					StrSql = "INSERT INTO " + compdb(comp_id) + "axela_acc_cart"
							+ " (cart_voucher_id,"
							+ " cart_vouchertype_id,"
							+ " cart_emp_id,"
							+ " cart_session_id,"
							+ " cart_multivoucher_id,"
							+ " cart_customer_id,"
							+ " cart_location_id,"
							+ " cart_item_id,"
							+ " cart_rowcount,"
							+ " cart_option_id,"
							+ " cart_qty,"
							+ " cart_price,"
							+ " cart_netprice,"
							+ " cart_unit_cost,"
							+ " cart_amount,"
							+ " cart_discountamount,"
							+ " cart_alt_qty,"
							+ " cart_alt_uom_id,"
							+ " cart_time,"
							+ " cart_dc)"
							+ " values("
							+ " 0," // cart_voucher_id
							+ " " + voucher_vouchertype_id + ","
							+ " " + emp_id + ","
							+ " " + cart_session_id + ","
							+ " 0," // cart_multivoucher_id
							+ " " + crs.getString("price_sales_customer_id") + "," // cart_customer_id
							+ " 0," // cart_location_id
							+ "	" + crs.getString("soitem_item_id") + ","
							+ " " + rowcount + "," // cart_rowcount
							+ " 0," // cart_option_id
							+ "	" + crs.getString("soitem_qty") + ","
							+ "	" + crs.getString("soitem_price") + ","
							+ "	" + crs.getString("soitem_total") + ","
							+ "	" + crs.getString("soitem_price") + ","
							+ "	" + crs.getDouble("soitem_price") * crs.getDouble("soitem_qty") + ","
							+ "	" + crs.getString("soitem_disc") + ","
							+ "	" + crs.getString("soitem_qty") + ","
							+ "	" + crs.getString("item_alt_uom_id") + ","
							+ " " + toLongDate(kknow()) + ","
							+ " 0" // cart_dc
							+ ")";
					// SOP("StrSql =insert==main item=== " +
					// StrSqlBreaker(StrSql));
					updateQuery(StrSql);

					double discount_perc = 0.00;
					if (crs.getDouble("soitem_disc") > 0) {
						if (!crs.getString("soitem_price").equals("0.0")) {
							discount_perc = (double) ((crs.getDouble("soitem_disc") / crs.getDouble("soitem_price")) * 100);
						}
					}

					// This Query will insert row for item Discount into cart...

					StrSql = "INSERT INTO " + compdb(comp_id) + "axela_acc_cart "
							+ "( cart_voucher_id,"
							+ " cart_vouchertype_id,"
							+ " cart_emp_id,"
							+ " cart_session_id,"
							+ " cart_multivoucher_id,"
							+ " cart_customer_id,"
							+ " cart_location_id,"
							+ " cart_item_id,"
							+ " cart_discount,"
							+ " cart_discount_perc,"
							+ " cart_rowcount,"
							+ " cart_option_id,"
							+ " cart_qty,"
							+ " cart_price,"
							+ " cart_amount,"
							+ " cart_time,"
							+ " cart_dc )"
							+ "values( "
							+ " 0," // cart_voucher_id
							+ " " + voucher_vouchertype_id + ","
							+ " " + emp_id + ","
							+ " " + cart_session_id + ","
							+ " 0," // cart_multivoucher_id
							+ " " + crs.getString("price_discount1_customer_id") + "," // cart_customer_id
							+ " 0," // cart_location_id
							+ "	" + crs.getString("soitem_item_id") + ","
							+ " 1," // cart_discount
							+ " " + discount_perc + ","
							+ " " + rowcount + ","
							+ " " + optionid + ","
							+ " 0," // cart_dc
							+ "	" + crs.getString("soitem_disc") + "," // cart_price
							+ "	" + crs.getString("soitem_disc") + ","// cart_amount
							+ " " + toLongDate(kknow()) + "," // cart_time
							+ "1)";

					// SOP("StrSql =insert==disc=== " + StrSqlBreaker(StrSql));

					updateQuery(StrSql);
					// Tax
					for (int i = 1, j = 0; i <= 3; i++, j++) {

						if (!crs.getString("tax_id" + i).equals("0")) {
							StrSql = "INSERT INTO " + compdb(comp_id) + "axela_acc_cart "
									+ "( cart_voucher_id,"
									+ " cart_vouchertype_id,"
									+ " cart_emp_id,"
									+ " cart_session_id,"
									+ " cart_multivoucher_id,"
									+ " cart_customer_id,"
									+ " cart_location_id,"
									+ " cart_item_id,"
									+ " cart_tax,"
									+ " cart_tax_id,"
									+ " cart_rowcount,"
									+ " cart_option_id,"
									+ " cart_price,"
									+ " cart_amount,"
									+ " cart_time,"
									+ " cart_dc )"
									+ " values("
									+ " 0," // cart_voucher_id
									+ " " + voucher_vouchertype_id + ","
									+ " " + emp_id + ","
									+ " " + cart_session_id + ","
									+ " 0," // cart_multivoucher_id
									+ " " + crs.getString("tax_customer_id" + i) + "," // cart_customer_id
									+ " 0," // cart_location_id
									+ "	" + crs.getString("soitem_item_id") + ","
									+ "	1," // cart_tax
									+ "	" + crs.getString("tax_id" + i) + ","
									+ " " + rowcount + ","
									+ " " + optionid + ","
									+ "	" + tax_value[j] + ",";
							if (crs.getDouble("tax_value" + i) > 0) {
								StrSql += " " + (tax_value[j] * (crs.getDouble("soitem_qty"))) + ",";
							} else {
								StrSql += " 0,";
							}
							StrSql += " " + toLongDate(kknow()) + "," + "0)";
							// SOP("StrSql==Tax==" + StrSql);
							updateQuery(StrSql);
						}
					}
					// SOP("StrSql==Tax==" + StrSql);
					// updateQuery(StrSql);
					rowcount++;
				}
			}
		} catch (Exception e) {

			msg = "<br>Transaction Error!";
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ ": " + e);
		}
	}

	public void CopyVoucherTransToCart(HttpServletRequest request,
			String emp_id, String cart_session_id, String voucher_id,
			String voucher_vouchertype_id, String status) {
		String StrSql = "";
		// SOP("voucher_vouchertype_id==========================" + voucher_vouchertype_id);
		String comp_id = CNumeric(GetSession("comp_id", request));
		StrSql = "DELETE FROM " + compdb(comp_id) + "axela_acc_cart"
				+ " WHERE 1=1"
				+ " AND cart_vouchertype_id = " + voucher_vouchertype_id + ""
				+ " AND cart_emp_id = " + emp_id + ""
				+ " AND cart_session_id = " + cart_session_id
				+ " AND SUBSTR(cart_time,1,8) < SUBSTR(" + toShortDate(kknow()) + ",1,8)";
		updateQuery(StrSql);

		StrSql = "SELECT ";
		if (status.equals("Add")) {
			StrSql += " 0,";
		} else if (status.equals("Update")) {
			StrSql += " " + voucher_id + ",";
		}

		StrSql += " " + voucher_vouchertype_id + " ,"
				+ " " + emp_id + ","
				+ " " + cart_session_id + ","
				+ " vouchertrans_multivoucher_id,"
				+ " vouchertrans_customer_id,"
				+ " vouchertrans_location_id,"
				+ " vouchertrans_item_id,"
				+ " vouchertrans_discount,"
				+ " vouchertrans_discount_perc,"
				+ " vouchertrans_tax,"
				// + " vouchertrans_tax_id,"
				+ " vouchertrans_rowcount,"
				+ " vouchertrans_option_id,"
				+ " vouchertrans_option_group,"
				+ " vouchertrans_item_batch_id,"
				+ " vouchertrans_item_serial,"
				+ " vouchertrans_qty,"
				+ " vouchertrans_truckspace,"
				+ " vouchertrans_price,"
				+ " vouchertrans_netprice,"
				+ " vouchertrans_unit_cost,"
				+ " vouchertrans_amount,"
				+ " vouchertrans_discountamount,"
				+ " vouchertrans_taxamount,"
				+ " vouchertrans_supplier_code,"
				+ " vouchertrans_alt_qty,"
				+ " vouchertrans_alt_uom_id,"
				+ " vouchertrans_delivery_date,"
				+ " " + toLongDate(kknow()) + ","
				+ " vouchertrans_dc"
				+ " FROM " + " " + compdb(comp_id) + "axela_acc_voucher_trans"
				+ " INNER JOIN " + " " + compdb(comp_id) + "axela_acc_voucher ON voucher_id = vouchertrans_voucher_id"
				+ " WHERE vouchertrans_item_id != 0"
				+ " AND vouchertrans_voucher_id = " + voucher_id + "";
		SOP("StrSql =select== item tax disc=== " + StrSqlBreaker(StrSql));
		StrSql = "INSERT INTO  " + (comp_id) + "axela_acc_cart"
				+ " (cart_voucher_id,"
				+ " cart_vouchertype_id,"
				+ " cart_emp_id,"
				+ " cart_session_id,"
				+ " cart_multivoucher_id,"
				+ " cart_customer_id,"
				+ " cart_location_id,"
				+ " cart_item_id,"
				+ " cart_discount,"
				+ " cart_discount_perc,"
				+ " cart_tax,"
				// + " cart_tax_id,"
				+ " cart_rowcount,"
				+ " cart_option_id,"
				+ " cart_option_group,"
				+ " cart_item_batch_id,"
				+ " cart_item_serial,"
				+ " cart_qty,"
				+ " cart_truckspace,"
				+ " cart_price,"
				+ " cart_netprice,"
				+ " cart_unit_cost,"
				+ " cart_amount,"
				+ " cart_discountamount,"
				+ " cart_taxamount,"
				+ " cart_supplier_code,"
				+ " cart_alt_qty,"
				+ " cart_alt_uom_id,"
				+ " cart_delivery_date,"
				+ " cart_time,"
				+ " cart_dc)" + " "
				+ StrSql + "";
		// SOP("StrSql =insert= item tax disc=== " + StrSqlBreaker(StrSql));
		updateQuery(StrSql);

		StrSql = "SELECT ";
		if (status.equals("Add")) {
			StrSql += " 0,";
		} else if (status.equals("Update")) {
			StrSql += " " + voucher_id + ",";
		}

		StrSql += " " + voucher_vouchertype_id + " ,"
				+ " " + emp_id + ","
				+ " " + cart_session_id + ","
				+ " vouchertrans_multivoucher_id,"
				+ " vouchertrans_customer_id,"
				+ " vouchertrans_location_id,"
				+ " vouchertrans_item_id,"
				+ " vouchertrans_discount,"
				+ " vouchertrans_discount_perc,"
				+ " vouchertrans_tax,"
				// + " vouchertrans_tax_id,"
				+ " vouchertrans_rowcount,"
				+ " vouchertrans_option_id,"
				+ " vouchertrans_option_group,"
				+ " vouchertrans_item_batch_id,"
				+ " vouchertrans_item_serial,"
				+ " vouchertrans_qty,"
				+ " vouchertrans_truckspace,"
				+ " vouchertrans_price,"
				+ " vouchertrans_netprice,"
				+ " vouchertrans_unit_cost,"
				+ " vouchertrans_amount,"
				+ " vouchertrans_supplier_code,"
				+ " vouchertrans_alt_qty,"
				+ " vouchertrans_alt_uom_id,"
				+ " vouchertrans_delivery_date,"
				+ " " + toLongDate(kknow()) + ","
				+ " vouchertrans_dc"
				+ " FROM " + " " + compdb(comp_id)
				+ "axela_acc_voucher_trans"
				+ " INNER JOIN " + " " + compdb(comp_id)
				+ "axela_acc_voucher ON voucher_id = vouchertrans_voucher_id"
				+ " WHERE  vouchertrans_tax_id !=0"
				+ " AND vouchertrans_item_id = 0"
				+ " AND vouchertrans_voucher_id = " + voucher_id + "";
		// SOP("StrSql =select=bs tax=== " + StrSqlBreaker(StrSql));
		StrSql = "INSERT INTO  " + compdb(comp_id) + "axela_acc_cart"
				+ " (cart_voucher_id,"
				+ " cart_vouchertype_id,"
				+ " cart_emp_id,"
				+ " cart_session_id,"
				+ " cart_multivoucher_id,"
				+ " cart_customer_id,"
				+ " cart_location_id,"
				+ " cart_item_id,"
				+ " cart_discount,"
				+ " cart_discount_perc,"
				+ " cart_tax,"
				// + " cart_tax_id,"
				+ " cart_rowcount,"
				+ " cart_option_id,"
				+ " cart_option_group,"
				+ " cart_item_batch_id,"
				+ " cart_item_serial,"
				+ " cart_qty,"
				+ " cart_truckspace,"
				+ " cart_price,"
				+ " cart_netprice,"
				+ " cart_unit_cost,"
				+ " cart_amount,"
				+ " cart_supplier_code,"
				+ " cart_alt_qty,"
				+ " cart_alt_uom_id,"
				+ " cart_delivery_date,"
				+ " cart_time,"
				+ " cart_dc)" + " " + StrSql + "";
		// SOP("StrSql =insert==bs tax=== " +
		// StrSqlBreaker(StrSql));
		updateQuery(StrSql);
	}

	public void CopyJCTransToCart(HttpServletRequest request,
			String emp_id, String cart_session_id, String voucher_id,
			String voucher_vouchertype_id, String status) {
		String StrSql = "";
		String comp_id = CNumeric(GetSession("comp_id", request));
		StrSql = "DELETE FROM " + compdb(comp_id) + "axela_acc_cart"
				+ " WHERE 1=1"
				+ " AND cart_voucher_id = " + voucher_id + ""
				+ " AND cart_emp_id = " + emp_id + "";
		// + " AND cart_session_id = " + cart_session_id
		// + " AND SUBSTR(cart_time,1,8) < SUBSTR(" + toShortDate(kknow()) + ",1,8)";
		SOP("StrSql==Delete==" + StrSql);
		updateQuery(StrSql);
		StrSql = "SELECT ";
		if (status.equals("Add")) {
			StrSql += " 0,";
		} else if (status.equals("Update")) {
			StrSql += " " + voucher_id + ",";
		}

		StrSql += " " + voucher_vouchertype_id + " ,"
				+ " " + emp_id + ","
				+ " " + cart_session_id + ","
				+ " jctrans_multivoucher_id,"
				+ " jctrans_customer_id,"
				+ " jctrans_location_id,"
				+ " jctrans_item_id,"
				+ " jctrans_discount,"
				+ " jctrans_discount_perc,"
				+ " jctrans_tax,"
				// + " jctrans_tax_id,"
				+ " jctrans_rowcount,"
				+ " jctrans_option_id,"
				+ " jctrans_option_group,"
				+ " jctrans_item_batch_id,"
				+ " jctrans_item_serial,"
				+ " jctrans_qty,"
				+ " jctrans_truckspace,"
				+ " jctrans_price,"
				+ " jctrans_netprice,"
				+ " jctrans_unit_cost,"
				+ " jctrans_amount,"
				+ " jctrans_discountamount,"
				+ " jctrans_taxamount,"
				+ " jctrans_supplier_code,"
				+ " jctrans_alt_qty,"
				+ " jctrans_alt_uom_id,"
				+ " jctrans_delivery_date,"
				+ " " + toLongDate(kknow()) + ","
				+ " jctrans_dc"
				+ " FROM " + " " + compdb(comp_id) + "axela_service_jc_trans"
				+ " INNER JOIN " + " " + compdb(comp_id) + "axela_service_jc ON jc_id = jctrans_jc_id"
				+ " WHERE jctrans_item_id != 0"
				+ " AND jctrans_jc_id = " + voucher_id + "";
		// SOP("StrSql =select== item tax disc=== " + StrSqlBreaker(StrSql));
		StrSql = "INSERT INTO  " + compdb(comp_id) + "axela_acc_cart"
				+ " (cart_voucher_id,"
				+ " cart_vouchertype_id,"
				+ " cart_emp_id,"
				+ " cart_session_id,"
				+ " cart_multivoucher_id,"
				+ " cart_customer_id,"
				+ " cart_location_id,"
				+ " cart_item_id,"
				+ " cart_discount,"
				+ " cart_discount_perc,"
				+ " cart_tax,"
				// + " cart_tax_id,"
				+ " cart_rowcount,"
				+ " cart_option_id,"
				+ " cart_option_group,"
				+ " cart_item_batch_id,"
				+ " cart_item_serial,"
				+ " cart_qty,"
				+ " cart_truckspace,"
				+ " cart_price,"
				+ " cart_netprice,"
				+ " cart_unit_cost,"
				+ " cart_amount,"
				+ " cart_discountamount,"
				+ " cart_taxamount,"
				+ " cart_supplier_code,"
				+ " cart_alt_qty,"
				+ " cart_alt_uom_id,"
				+ " cart_delivery_date,"
				+ " cart_time,"
				+ " cart_dc)" + " "
				+ StrSql + "";
		// SOP("StrSql =insert= item tax disc=== " + StrSqlBreaker(StrSql));
		updateQuery(StrSql);

		StrSql = "SELECT ";
		if (status.equals("Add")) {
			StrSql += " 0,";
		} else if (status.equals("Update")) {
			StrSql += " " + voucher_id + ",";
		}

		StrSql += " " + voucher_vouchertype_id + " ,"
				+ " " + emp_id + ","
				+ " " + cart_session_id + ","
				+ " jctrans_multivoucher_id,"
				+ " jctrans_customer_id,"
				+ " jctrans_location_id,"
				+ " jctrans_item_id,"
				+ " jctrans_discount,"
				+ " jctrans_discount_perc,"
				+ " jctrans_tax,"
				// + " jctrans_tax_id,"
				+ " jctrans_rowcount,"
				+ " jctrans_option_id,"
				+ " jctrans_option_group,"
				+ " jctrans_item_batch_id,"
				+ " jctrans_item_serial,"
				+ " jctrans_qty,"
				+ " jctrans_truckspace,"
				+ " jctrans_price,"
				+ " jctrans_netprice,"
				+ " jctrans_unit_cost,"
				+ " jctrans_amount,"
				+ " jctrans_supplier_code,"
				+ " jctrans_alt_qty,"
				+ " jctrans_alt_uom_id,"
				+ " jctrans_delivery_date,"
				+ " " + toLongDate(kknow()) + ","
				+ " jctrans_dc"
				+ " FROM " + " " + compdb(comp_id) + "axela_service_jc_trans"
				+ " INNER JOIN " + " " + compdb(comp_id) + "axela_service_jc ON jc_id = jctrans_jc_id"
				+ " WHERE  jctrans_tax_id !=0"
				+ " AND jctrans_item_id = 0"
				+ " AND jctrans_jc_id = " + voucher_id + "";
		// SOP("StrSql =select=bs tax=== " + StrSqlBreaker(StrSql));
		StrSql = "INSERT INTO  " + compdb(comp_id) + "axela_acc_cart"
				+ " (cart_voucher_id,"
				+ " cart_vouchertype_id,"
				+ " cart_emp_id,"
				+ " cart_session_id,"
				+ " cart_multivoucher_id,"
				+ " cart_customer_id,"
				+ " cart_location_id,"
				+ " cart_item_id,"
				+ " cart_discount,"
				+ " cart_discount_perc,"
				+ " cart_tax,"
				// + " cart_tax_id,"
				+ " cart_rowcount,"
				+ " cart_option_id,"
				+ " cart_option_group,"
				+ " cart_item_batch_id,"
				+ " cart_item_serial,"
				+ " cart_qty,"
				+ " cart_truckspace,"
				+ " cart_price,"
				+ " cart_netprice,"
				+ " cart_unit_cost,"
				+ " cart_amount,"
				+ " cart_supplier_code,"
				+ " cart_alt_qty,"
				+ " cart_alt_uom_id,"
				+ " cart_delivery_date,"
				+ " cart_time,"
				+ " cart_dc)"
				+ " " + StrSql + "";
		// SOP("StrSql =insert==bs tax=== " + StrSqlBreaker(StrSql));
		updateQuery(StrSql);
	}

	public String ExecutePrepQuery(String StrSql, Map<Integer, Object> qparams, int minutes) {
		ResultSet rsexeq = null;
		String res = "";
		try {
			conn = connectDB();
			PreparedStatement stmt = conn.prepareStatement(StrSql);
			for (Integer key : qparams.keySet()) {
				stmt.setObject(key, qparams.get(key));
			}
			rsexeq = stmt.executeQuery();
			while (rsexeq.next()) {
				res = rsexeq.getString(1);
			}
			return res;
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			return "0";
		} finally {
			try {
				if (rsexeq != null) {
					rsexeq.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception ex) {
				SOPError(this.getClass().getName());
				SOPError("Error in "
						+ new Exception().getStackTrace()[0].getMethodName()
						+ " : " + ex);
			}
			// The connection is returned to the Broker
			//
		}
	}

	public String UpdateQueryReturnID(String strSQL) {
		ResultSet rs = null;
		PreparedStatement stmtGetLastID = null, pstmt = null;
		String res = "0";
		try {
			conn = connectDB();
			pstmt = conn.prepareStatement(strSQL);
			pstmt.executeUpdate();
			stmtGetLastID = conn.prepareStatement("SELECT LAST_INSERT_ID()");
			rs = stmtGetLastID.executeQuery();
			while (rs.next()) {
				res = rs.getString(1);
			}
			return res;
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			return "0";
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmtGetLastID != null) {
					stmtGetLastID.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception ex) {
				SOPError(this.getClass().getName());
				SOPError("Error in "
						+ new Exception().getStackTrace()[0].getMethodName()
						+ " : " + ex);
			}
		}
	}

	public String PadQuotes(String str) {
		if (str != null) {
			String str1 = str.trim();
			str1 = str1.replace("'", "&#39;");
			// str1=str1.replace("\n","\\\n");
			return str1;
		} else {
			return "";
		}
	}

	public String CheckNull(Object obj) {
		if (obj == null) {
			return "";
		} else {
			return obj.toString();
		}
	}

	public String JSONPadQuotes(String output) {
		if (!output.equals("")) {
			// output = output.replace("\\r", "");
			// output = output.replace("\\n", "");
			output = output.replaceAll("\\\\", "");
			output = output.replace("[\"", "[");
			output = output.replace("\"]", "]");
			output = output.replace("\"{", "{");
			output = output.replace("}\"", "}");
		}
		return output;
	}

	public String JSONListPadQuotes(String output) {
		if (!output.equals("")) {
			output = output.replaceAll("\\\\", "");
			output = output.replace("\"[", "[");
			output = output.replace("]\"", "]");
			output = output.replace("\"{", "{");
			output = output.replace("}\"", "}");
		}
		return output;
	}

	public String ReversePadQuotes(String str) {
		if (str != null) {
			String str1 = str.trim();

			str1 = str1.replace("&#039", "'");
			// str1=str1.replace("\n","\\\n");
			return str1;
		} else {
			return "";
		}
	}

	public String StrSqlBreaker(String StrSql) {
		String str = StrSql;
		if (!str.equals("")) {
			str = str.replace(" SELECT ", "\nSELECT ");
			str = str.replace(" FROM ", "\nFROM ");
			str = str.replace(" COALESCE", "\nCOALESCE");
			str = str.replace(" CONCAT", "\nCONCAT");
			str = str.replace(" IF", "\nIF");
			str = str.replace(" UNION", "\nUNION");
			str = str.replace(" INNER ", "\nINNER ");
			str = str.replace(" LEFT ", "\nLEFT ");
			str = str.replace(" WHERE ", "\nWHERE ");
			str = str.replace(" GROUP ", "\nGROUP ");
			str = str.replace(" HAVING ", "\nHAVING ");
			str = str.replace(" ORDER ", "\nORDER ");
			str = str.replace(" LIMIT ", "\nLIMIT ");
		}
		return str;
	}

	public Map<String, String> pageNavi(int length, String input, String pageSize) throws JSONException {
		JSONObject inputObj = new JSONObject(input);
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		HashMap output = new HashMap();
		String pageIndex = "0";
		String sortDirection = "";
		String sortField = "";
		if (!inputObj.isNull("pageIndex")) {
			pageIndex = CNumeric(PadQuotes(inputObj.getString("pageIndex")));
		}
		if (!inputObj.isNull("sortDirection")) {
			sortDirection = PadQuotes(inputObj.getString("sortDirection"));
		}
		if (!inputObj.isNull("sortField")) {
			sortField = PadQuotes(inputObj.getString("sortField"));
		}
		map.put("pageIndex", pageIndex);
		map.put("pageSize", pageSize);
		map.put("length", String.valueOf(length));
		map.put("sortField", sortField);
		map.put("sortDirection", sortDirection);
		return map;
	}

	public String PageNaviJson(String PageURL, int PageCurrent, int PageCount, int PageListSize) {
		String PageNavi = "<div><ul class=\"pagination\">";
		PageNavi += "&nbsp;";
		for (int i = (PageListSize * (Math.abs(((PageCurrent - 1) / PageListSize)))) + 1; i <= (PageListSize *
				(Math.abs((PageCurrent - 1) / PageListSize))) + PageListSize; i++) {
			if (i > PageCount) {
				break;
			}
			if (i == PageCurrent) {
				PageNavi += "<li><a><font color='red'>" + i + "</font></a></li>";
			} else {
				PageNavi += "<li onclick='TableAjaxCall(\"" + PageURL + i + "&pagenavi=yes\")'><a>" + i + "</a></li>";// <a href='" + PageURL +
																														// i + "'>" + i
				// + "</a>
			}
		}
		return PageNavi;
	}

	// public String smartArrToJson(String[][] smartarr) throws JSONException {
	// Gson gson = new Gson();
	// JSONObject output = new JSONObject(); //
	// ArrayList<String> smart = new ArrayList<String>();
	// ArrayList<String> list = new ArrayList<String>();
	// // ArrayList<String> listfeild = new ArrayList<String>();
	// HashMap<String, String> map = new HashMap<String, String>();
	//
	// for (int i = 0; i < 2; i++) {
	// for (int j = 0; j < smartarr.length; j++) {
	// smart.add(smartarr[j][i]);
	// }
	// SOP("smart=====" + smart);
	// map.put("key", StringEscapeUtils.unescapeJava((gson.toJson(smart))));
	// SOP("map=====" + map);
	// list.add(StringEscapeUtils.unescapeJava(gson.toJson(map)));
	// SOP("list====" + list);
	// smart.clear();
	// }
	// output.put("smartarr", list);
	// SOP("JSONListPadQuotes(output.toString())===" + JSONPadQuotes(output.toString()));
	// return JSONListPadQuotes(output.toString());
	// }

	public String PageNaviJS(String PageURL, int PageCurrent, int PageCount,
			int PageListSize) {
		String PageNavi = "";
		PageNavi += "Page No.&nbsp;";
		for (int i = (PageListSize * (Math
				.abs(((PageCurrent - 1) / PageListSize)))) + 1; i <= (PageListSize * (Math
				.abs((PageCurrent - 1) / PageListSize))) + PageListSize; i++) {
			if (i > PageCount) {
				break;
			}
			if (i == PageCurrent) {
				PageNavi += "<font color='red'>" + i + "</font>&nbsp;&nbsp;";
			} else {
				PageNavi += "<a href='" + PageURL + "(" + i + ")'>" + i
						+ "</a>&nbsp;&nbsp;";
			}
		}
		return PageNavi;
	}

	public String Selectdrop(int idvalue, String dropid) {
		try {
			if (!(dropid == null) && !(dropid.equals(""))) {
				if (idvalue == Integer.parseInt(dropid)) {
					return " selected";
				}
			}
			return " ";
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			return " ";
		}
	}

	public String StrSelectdrop(String value, String dropid) {
		try {
			if (!(dropid == null) && !(dropid.equals(""))) {
				if (value.equals(dropid)) {
					return " selected";
				}
			}
			return " ";
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			return " ";
		}
	}

	public String ArrSelectdrop(int idvalue, String[] dropid) {
		try {
			if ((dropid != null)) {
				for (int i = 0; i < dropid.length; i++) {
					if (dropid[i] != null) {
						if (idvalue == Integer.parseInt(dropid[i])) {
							return " selected";
						}
					}
				}
			}
			return " ";
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			return " ";
		}
	}

	public String[] StrSelectMultipleSerialize(HttpServletRequest request, String name) {
		try {
			String str = "";
			if ((name != null && name != "")) {
				int i = request.getParameterMap().get(name).length;
				for (int j = 0; j < i; j++) {
					str += request.getParameterMap().get(name)[j] + ",";
				}
				if (str != "") {
					str = CleanArrVal(str);
				}
			}
			return str.split(",");
		} catch (Exception ex) {
			return null;
		}
	}

	public String ArrSelectCheck(int idvalue, String[] dropid) {
		try {
			if ((dropid != null)) {
				for (int i = 0; i < dropid.length; i++) {
					if (dropid[i] != null) {
						if (idvalue == Integer.parseInt(dropid[i])) {
							return " Checked";
						}
					}
				}
			}
			return " ";
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			return " ";
		}
	}

	public String PopulateCheck(String checkid) {
		try {
			if (!(checkid == null) && (checkid.equals("1"))) {
				return "Checked ";
			}
			return " ";
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			return " ";
		}
	}

	// to return the checkbox value
	public String CheckBoxValue(String checkBox) {
		if (checkBox.equals("on")) {
			checkBox = "1";
		} else {
			checkBox = "0";
		}
		return checkBox;
	}

	public boolean isNumeric(String s) {
		String validChars = "0123456789.";
		boolean isNumeric = true;
		for (int i = 0; i < s.length() && isNumeric; i++) {
			char c = s.charAt(i);
			if (validChars.indexOf(c) == -1) {
				isNumeric = false;
			} else {
				isNumeric = true;
			}
		}
		return isNumeric;
	}

	public boolean isNumericNeg(String s) {
		String validChars = "0123456789-";
		boolean isNumeric = true;
		for (int i = 0; i < s.length() && isNumeric; i++) {
			char c = s.charAt(i);
			if (validChars.indexOf(c) == -1) {
				isNumeric = false;
			} else {
				isNumeric = true;
			}
		}
		return isNumeric;
	}

	// public void rsClose(ResultSet rs) {
	// try {
	// if (rs != null) {
	// rs.close();
	// }
	// if (stmt != null) {
	// stmt.close();
	// }
	// // //The connection is returned to the Broker
	// myBroker.freeConnection(conn);
	// myBroker.destroy();
	// } catch (Exception ex) {
	// SOPError(this.getClass().getName());
	// SOPError("Error in "
	// + new Exception().getStackTrace()[0].getMethodName()
	// + " : " + ex);
	// }
	// }

	public boolean isFloat(String number) {
		if (!number.equals("")) {
			if (number.contains("-")) {
				if ((number.indexOf("-") != number.lastIndexOf("-"))
						|| (number.indexOf("-") != 0)) {
					return false;
				}
			}

			if (number.contains(".")) {
				if ((number.indexOf(".") != number.lastIndexOf("."))
						|| number.lastIndexOf(".") == number.length() - 1) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

	public String CNumeric(String s) {
		if (s.equals("")) {
			return "0";
		} else if (isNumeric(s)) {
			return s;
		} else {
			return "0";
		}
	}

	public String doublenum(int fNum) {
		String doublenum;
		if (fNum > 9) {
			doublenum = "" + fNum;
		} else {
			doublenum = "0" + fNum;
		}
		return doublenum;
	}

	public String triplenum(int fNum) {
		String triplenum;
		if (fNum > 99) {
			triplenum = "" + fNum;
		} else if (fNum > 9) {
			triplenum = "0" + fNum;
		} else {
			triplenum = "00" + fNum;
		}
		return triplenum;
	}

	public String getIP(HttpServletRequest request) {
		String IP = "";
		if (request.getHeader("x-forwarded-for") != null) {
			IP = request.getHeader("x-forwarded-for").toString();
		}
		if (request.getRemoteHost() != null && IP.equals("")) {
			IP = request.getRemoteHost().toString();
		}
		return IP;
	}

	public void CheckSession(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (GetSession("emp_id", request).equals("")) {
				if (AppRun().equals("1")) {
					response.sendRedirect(response.encodeRedirectURL("../portal/index.jsp?msg=Your session has expired."));
				} else {
					// Assigned to emp_id = 2
					// response.sendRedirect(response.encodeRedirectURL("../portal/index.jsp?msg=Your session has expired."));
					AssignSession("1", "2", "1", "1", "10", 100, "1", request);
				}
			}
		} catch (Exception e) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + e);
		}
	}

	public void CheckAppSession(String emp_uuid, String comp_id,
			HttpServletRequest request) {
		try {
			HttpSession session = request.getSession(true);
			if (CNumeric(GetSession("emp_id", request) + "").equals("0") && !emp_uuid.equals("")) {
				String StrSql = " SELECT emp_id, emp_branch_id,"
						+ " emp_role_id, emp_all_exe,"
						+ " emp_recperpage, emp_timeout "
						+ " FROM " + compdb(comp_id) + "axela_emp "
						+ " WHERE 1=1 AND emp_uuid='" + emp_uuid + "'";
				// SOP("StrSql=====checkappsession====" + StrSql);
				CachedRowSet crs = processQuery(StrSql, 0);
				while (crs.next()) {
					AssignSession(crs.getString("emp_id"), crs.getString("emp_branch_id"), crs.getString("emp_role_id"),
							crs.getString("emp_all_exe"), crs.getString("emp_recperpage"), 20, comp_id, request);

					// StrSql = ("INSERT INTO " + compdb(comp_id)
					// + "axela_emp_app_log" + " (applog_emp_id,"
					// + " applog_remote_agent," + " applog_attemptcount,"
					// + " applog_signin_time) " + " VALUES" + " ("
					// + crs.getString("emp_id") + "," + " ''," + " '0',"
					// + " '" + toLongDate(kknow()) + "')");
					// updateQuery(StrSql);
				}
				crs.close();
			}
		} catch (Exception e) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + e);
		}
	}

	public void CheckAdminSession(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			HttpSession session = request.getSession(true);
			// SOP("session ======= " +
			// session.getAttribute("user_id"));
			if (session.getAttribute("user_id") == null) {
				if (AppRun().equals("1")) {
					response.sendRedirect(response.encodeRedirectURL("index.jsp?msg=Your session has expired."));
				} else {
					// response.sendRedirect(response.encodeRedirectURL("index.jsp?msg=Your session has expired."));
					AssignAdminSession("1", 1, "10", request);
				}
			}
		} catch (Exception e) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + e);
		}
	}

	public void CheckChannelSession(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			HttpSession session = request.getSession(true);
			if (session.getAttribute("channeluser_id") == null) {
				if (AppRun().equals("1")) {
					response.sendRedirect(response.encodeRedirectURL("../channel/index.jsp?msg=Your session has expired."));
				} else {
					// response.sendRedirect(response.encodeRedirectURL("../channel/index.jsp?msg=Your session has expired."));
					AssignChannelSession("1", 1, "1", "1", "Emax Technology", "10", request);
				}
			}
		} catch (Exception e) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + e);
		}
	}

	public void AssignSession(String emp_id, String branch_id, String role_id,
			String emp_all_exe, String recperpage, int emp_timeout,
			String comp_id, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession(true);
			session.setAttribute("comp_id", comp_id);
			session.setAttribute("emp_id", emp_id);
			// session.setAttribute("usersession_id", session.getId())
			String accountingmodule = "";
			Map setMap;
			if (session.getAttribute("sessionMap") == null) {
				setMap = new HashMap();
				session.setAttribute("sessionMap", setMap);
			}
			setMap = (Map) session.getAttribute("sessionMap");
			setMap.put("emp_id", emp_id);

			setMap.put("emp_branch_id", branch_id);
			setMap.put("emp_role_id", role_id);
			setMap.put("emp_recperpage", recperpage);
			setMap.put("comp_id", comp_id);
			session.setMaxInactiveInterval(emp_timeout * 60);
			if (!branch_id.equals("0")) {
				setMap.put("BranchAccess", " AND (branch_id = " + branch_id + ")");
			} else if (role_id.equals("1") && branch_id.equals("0")) {
				setMap.put("BranchAccess", "");
			} else if (!role_id.equals("1") && branch_id.equals("0")) {
				String StrSql = "SELECT emp_branch_id"
						+ " FROM " + compdb(comp_id) + "axela_emp_branch"
						+ " INNER JOIN " + compdb(comp_id) + "axela_branch ON branch_id = emp_branch_id"
						+ " WHERE branch_active = 1"
						+ " AND emp_id = " + emp_id + "";
				SOP("assign===" + StrSqlBreaker(StrSql));;
				CachedRowSet crs = processQuery(StrSql, 0);
				String Str = "";
				if (crs.isBeforeFirst()) {
					while (crs.next()) {
						if (crs.isFirst()) {
							Str += " branch_id = " + crs.getString("emp_branch_id");
						} else {
							Str += " OR branch_id = " + crs.getString("emp_branch_id");
						}
					}
				} else {
					Str += "0";
				}
				setMap.put("BranchAccess", " AND (" + Str + ")");
			}

			if (emp_id.equals("1") || emp_all_exe.equals("1")) {
				setMap.put("ExeAccess", "");
			} else {
				String StrSql = "SELECT empexe_id FROM " + compdb(comp_id) + "axela_emp_exe" + " WHERE empexe_emp_id = " + emp_id + "";
				CachedRowSet crs = processQuery(StrSql, 0);
				String Str = " ";
				if (crs.isBeforeFirst()) {
					while (crs.next()) {
						Str += " OR emp_id = " + crs.getString("empexe_id");
					}
				}
				setMap.put("ExeAccess", " AND (emp_id = " + emp_id + Str + ")");
			}

			// Start Module Access
			String StrSql = "SELECT emp_name,  jobtitle_desc, emp_role_id, emp_photo,"
					+ " emp_gender, emp_mis_access, emp_copy_access,"
					+ " channel_logo, channel_name, channel_self_branding, channel_self_support,"
					+ " comp_pic, comp_name, comp_module_activity, comp_module_customer, comp_module_pm,"
					+ " comp_module_marketing, comp_module_sales, comp_module_pos, comp_module_service,"
					+ " comp_module_inventory, comp_module_invoice, comp_module_accounting,"
					+ " comp_module_production, comp_module_asset,comp_module_hcm,comp_module_payroll, comp_module_social,"
					+ " comp_module_website, comp_module_productcatalogue, comp_module_portal,"
					+ " comp_businesstype_id, comp_email_enable, comp_sms_enable, config_customer_name,"
					+ " config_sales_oppr_name, config_inventory_current_stock,"
					+ " config_inventory_location_name, config_format_decimal," + " currency_name,"
					+ " currency_symbol, currency_country, formatdate_name, formatdate_datepicker,"
					+ " formattime_name, formattime_timepicker, formatdigit_id"
					+ " FROM " + compdb(comp_id) + "axela_emp"
					+ " INNER JOIN " + compdb(comp_id) + "axela_jobtitle ON jobtitle_id = emp_jobtitle_id,"
					+ " " + compdb(comp_id) + "axela_comp,"
					+ " " + compdb(comp_id) + "axela_config,"
					+ " " + maindb() + "channel,"
					+ " " + maindb() + "currency,"
					+ " " + maindb() + "formatdate,"
					+ " " + maindb() + "formattime,"
					+ " " + maindb() + "formatdigit"
					+ " WHERE emp_active = '1'"
					+ " AND emp_id = " + emp_id + ""
					+ " AND comp_id = " + comp_id + ""
					+ " AND comp_active = '1'"
					+ " AND channel_id = comp_channel_id"
					+ " AND config_currency_id = currency_id"
					+ " AND emp_formatdate_id = formatdate_id"
					+ " AND emp_formattime_id = formattime_id"
					+ " AND emp_formatdigit_id = formatdigit_id";
			SOP("StrSql = " + StrSqlBreaker(StrSql));
			CachedRowSet crs = processQuery(StrSql, 0);

			while (crs.next()) {
				setMap.put("emp_name", crs.getString("emp_name"));
				setMap.put("emp_jobtitle", crs.getString("jobtitle_desc"));
				setMap.put("emp_gender", crs.getString("emp_gender"));
				setMap.put("emp_mis_access", crs.getString("emp_mis_access"));
				setMap.put("emp_copy_access", crs.getString("emp_copy_access"));
				if (!crs.getString("emp_photo").equals("")) {
					setMap.put("emp_photo", "emp_photo");
				}
				if (!crs.getString("comp_pic").equals("")) {
					setMap.put("comp_logo", "../Thumbnail.do?image_type2=comp");
				}
				setMap.put("comp_name", crs.getString("comp_name"));
				setMap.put("comp_module_activity", crs.getString("comp_module_activity"));
				setMap.put("comp_module_customer", crs.getString("comp_module_customer"));
				setMap.put("comp_module_production", crs.getString("comp_module_production"));
				setMap.put("comp_module_marketing", crs.getString("comp_module_marketing"));
				setMap.put("comp_module_sales", crs.getString("comp_module_sales"));
				setMap.put("comp_module_pos", crs.getString("comp_module_pos"));
				setMap.put("comp_module_service", crs.getString("comp_module_service"));
				setMap.put("comp_module_inventory", crs.getString("comp_module_inventory"));
				setMap.put("comp_module_invoice", crs.getString("comp_module_invoice"));
				setMap.put("comp_module_accounting", crs.getString("comp_module_accounting"));
				accountingmodule = crs.getString("comp_module_accounting");
				setMap.put("comp_module_pm", crs.getString("comp_module_pm"));
				setMap.put("comp_module_asset", crs.getString("comp_module_asset"));
				setMap.put("comp_module_hcm", crs.getString("comp_module_hcm"));
				setMap.put("comp_module_payroll", crs.getString("comp_module_payroll"));
				setMap.put("comp_module_social", crs.getString("comp_module_social"));
				setMap.put("comp_module_website", crs.getString("comp_module_website"));
				setMap.put("comp_module_productcatalogue", crs.getString("comp_module_productcatalogue"));
				setMap.put("comp_module_portal", crs.getString("comp_module_portal"));
				setMap.put("comp_businesstype_id", crs.getString("comp_businesstype_id"));
				setMap.put("comp_sms_enable", crs.getString("comp_sms_enable"));
				setMap.put("comp_email_enable", crs.getString("comp_email_enable"));
				setMap.put("currency_name", crs.getString("currency_name"));
				setMap.put("config_customer_name", crs.getString("config_customer_name"));
				setMap.put("config_sales_oppr_name", crs.getString("config_sales_oppr_name"));
				setMap.put("config_inventory_current_stock", crs.getString("config_inventory_current_stock"));
				setMap.put("config_inventory_location_name", crs.getString("config_inventory_location_name"));
				setMap.put("config_format_decimal", crs.getString("config_format_decimal"));
				setMap.put("currency_symbol", crs.getString("currency_symbol"));
				setMap.put("currency_country", crs.getString("currency_country"));
				setMap.put("formatdate_name", crs.getString("formatdate_name"));
				setMap.put("formatdate_datepicker", crs.getString("formatdate_datepicker"));
				setMap.put("formattime_name", crs.getString("formattime_name").replace("tt", ""));
				setMap.put("formattime_timepicker", crs.getString("formattime_timepicker"));
				setMap.put("formatdigit_id", crs.getString("formatdigit_id"));
			}
			crs.close();
			// // End Module Access
			// // Accounting Module
			if (accountingmodule.equals("1")) {
				BuildAccMenuLinks(comp_id, request);
			}

			// // End Accounting Module
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
		}
	}

	// new assignsession1 method for springboot
	public void assignSession(String empId, String branchId, String roleId,
			String empAllExe, String recperpage, int empTimeout,
			String compId, HttpSession session) {
		session.setAttribute("compId", compId);
		session.setAttribute("empId", empId);
		String accountingmodule = "";
		Map<String, String> setMap;
		if (session.getAttribute("sessionMap") == null) {
			setMap = new HashMap();
			session.setAttribute("sessionMap", setMap);
		}
		setMap = (Map) session.getAttribute("sessionMap");
		setMap.put("empId", empId);
		setMap.put("empBranchId", branchId);
		setMap.put("empRoleId", roleId);
		setMap.put("empRecperpage", recperpage);
		setMap.put("compId", compId);
		((HttpSession) session).setMaxInactiveInterval(empTimeout * 60);
		if (!branchId.equals("0")) {
			setMap.put("branchAccess", " AND (branchId = " + branchId + ")");
		} else if (roleId.equals("1") && branchId.equals("0")) {
			setMap.put("branchAccess", "");
		} else if (!roleId.equals("1") && branchId.equals("0")) {
			String Str = "";
			int count = 0;
			String[] empbranchids = signinrepository.getBranchIds(Integer.parseInt(empId));
			for (int i = 0; i < empbranchids.length; i++) {
				if (count >= 1) {
					Str += " OR branchId = " + empbranchids[i];
				} else {
					Str += " branchId = " + empbranchids[i];
				}
				count++;
			}
			if (count == 0) {
				Str = "0";
			}
			setMap.put("branchAccess", " AND (" + Str + ")");
		}
		if (empId.equals("1") || empAllExe.equals("1")) {
			setMap.put("exeAccess", "");
		} else {
			int count = 0;
			String Str = "";
			String[] empeids = signinrepository.getEmpExeIds(Integer.parseInt(empId));
			for (int i = 0; i < empeids.length; i++) {
				count++;
				Str += " OR empId = " + empeids[i];
			}
			if (count == 0) {
				Str = "0";
			}
			setMap.put("exeAccess", " AND (empId = " + empId + Str + ")");
		}
		AxelaEmp axelaEmp = signinrepository.findByEmpId(Integer.parseInt(empId));
		setMap.put("empName", axelaEmp.getEmpUname());
		setMap.put("empJobtitle", axelaEmp.getAxelaJobtitle().getJobtitleDesc());
		setMap.put("empGender", axelaEmp.getEmpGender());
		setMap.put("empMisAccess", axelaEmp.getEmpMisAccess());
		setMap.put("empAopyAccess", axelaEmp.getEmpCopyAccess());
		// if (!axelaEmp.getEmpPhoto().equals("")) {
		// setMap.put("empPhoto", axelaEmp.getEmpPhoto());
		// }

		// // Hav to check
		// if (!crs.getString("compPic").equals("")) {
		// setMap.put("compLogo", "../Thumbnail.do?imageType2=comp");
		// }

		// comp details
		AxelaComp axelaComp = new AxelaComp();
		axelaComp = axelacomprepository.findOne(Integer.parseInt(compId));
		setMap.put("compName", axelaComp.getCompName());
		setMap.put("franchiseeCount", axelaComp.getCompFranchiseeCount() + "");
		setMap.put("branchCount", axelaComp.getCompBranchCount() + "");
		setMap.put("compModuleActivity", axelaComp.getCompActive());
		setMap.put("compModuleCustomer", axelaComp.getCompModuleCustomer());
		setMap.put("compModuleProduction", axelaComp.getCompModuleProduction());
		setMap.put("compModuleMarketing", axelaComp.getCompModuleMarketing());
		setMap.put("compModuleSales", axelaComp.getCompModuleSales());
		setMap.put("compModulePos", axelaComp.getCompModulePos());
		setMap.put("compModuleService", axelaComp.getCompModuleService());
		setMap.put("compModuleHelpdesk", axelaComp.getCompModuleHelpdesk());
		setMap.put("compModuleInventory", axelaComp.getCompModuleInventory());
		setMap.put("compModuleInvoice", axelaComp.getCompModuleInvoice());
		setMap.put("compModuleAccounting", axelaComp.getCompModuleAccounting());
		accountingmodule = axelaComp.getCompModuleAccounting();
		setMap.put("compModulePm", axelaComp.getCompModulePm());
		setMap.put("compModuleAsset", axelaComp.getCompModuleAsset());
		setMap.put("compModuleHcm", axelaComp.getCompModuleHcm());
		setMap.put("compModulePayroll", axelaComp.getCompModulePayroll());
		setMap.put("compModuleSocial", axelaComp.getCompModuleSocial());
		setMap.put("compModuleWebsite", axelaComp.getCompModuleWebsite());
		setMap.put("compModuleProductcatalogue", axelaComp.getCompModuleProductcatalogue());
		setMap.put("compModulePortal", axelaComp.getCompModulePortal());
		setMap.put("compBusinesstypeId", axelaComp.getCompBusinesstypeId() + "");
		setMap.put("compSmsEnable", axelaComp.getCompSmsEnable());
		setMap.put("compEmailEnable", axelaComp.getCompEmailEnable());
		// config details
		for (AxelaConfig axelaConfig : configRepository.findAll()) {
			setMap.put("configCustomerName", axelaConfig.getConfigCustomerName());
			setMap.put("configSalesOpprName", axelaConfig.getConfigSalesOpprName());
			setMap.put("configInventoryCurrentStock", axelaConfig.getConfigInventoryCurrentStock());
			setMap.put("configInventoryLocationName", axelaConfig.getConfigInventoryLocationName());
			setMap.put("configFormatDecimal", axelaConfig.getConfigFormatDecimal() + "");
			setMap.put("currencySymbol", axelaConfig.getAxelaCurrency().getCurrencySymbol());
			setMap.put("currencyCountry", axelaConfig.getAxelaCurrency().getCurrencyCountry());
			setMap.put("currencyName", axelaConfig.getAxelaCurrency().getCurrencyName());
			setMap.put("timeZoneValue", timeZoneRepository.findByTimeZoneValue(axelaConfig.getConfigId()));
		}
		// format details
		setMap.put("formatdateDatepicker", axelaEmp.getAxelaFormatdate().getFormatdateDatepicker());
		setMap.put("formattimeName", axelaEmp.getAxelaFormattime().getFormattimeName().replace("tt", ""));
		setMap.put("formattimeTimepicker", axelaEmp.getAxelaFormattime().getFormattimeTimepicker());
		setMap.put("formatdigitId", axelaEmp.getAxelaFormatdigit().getFormatdigitId() + "");
		setMap.put("formatdateName", axelaEmp.getAxelaFormatdate().getFormatdateName());
		// if (accountingmodule.equals("1")) {
		// BuildAccMenuLinks(compId, session);
		// }
		// End Accounting Module

	}
	public void BuildAccMenuLinks(String comp_id, HttpServletRequest request) {
		StringBuilder accincomelink = new StringBuilder();
		StringBuilder accexpenselink = new StringBuilder();
		StringBuilder accaddlink = new StringBuilder();
		int temp = 0;
		int count = 0;
		StringBuilder ul = new StringBuilder();
		StringBuilder li = new StringBuilder();
		try {
			String StrSql = "SELECT voucherclass_id, vouchertype_id, vouchertype_name, voucherclass_income, voucherclass_file"
					+ " FROM " + compdb(comp_id) + "axela_acc_voucher_type"
					+ " INNER JOIN axela.axela_acc_voucher_class on voucherclass_id = vouchertype_voucherclass_id"
					+ " WHERE vouchertype_active = 1"
					+ " AND voucherclass_active = 1"
					+ " AND voucherclass_income !=0"
					+ " ORDER BY voucherclass_id, voucherclass_income, vouchertype_rank";
			CachedRowSet accrs = processQuery(StrSql, 0);
			while (accrs.next()) {
				if (accrs.getString("voucherclass_income").equals("1")) {
					accincomelink.append("<li class=\"inline-menu\"><a href=\"../accounting/"
							+ accrs.getString("voucherclass_file") + "-update.jsp?add=yes")
							.append("&voucherclass_id=").append(accrs.getString("voucherclass_id"));
					accincomelink.append("&vouchertype_id=" + accrs.getString("vouchertype_id") + "\">Add "
							+ accrs.getString("vouchertype_name") + "</a></li>\n");
					// accincomelink.append("<li><a href=\"../accounting/voucher-list.jsp?all=yes&vouchertype_id="
					// + accrs.getString("vouchertype_id") + "\">List " +
					// accrs.getString("vouchertype_name") + "</a></li>\n");
				}
				if (accrs.getString("voucherclass_income").equals("2")) {
					accexpenselink.append("<li class=\"inline-menu\"><a href=\"../accounting/"
							+ accrs.getString("voucherclass_file") + "-update.jsp?add=yes")
							.append("&voucherclass_id=").append(accrs.getString("voucherclass_id"));
					accexpenselink.append("&vouchertype_id=" + accrs.getString("vouchertype_id") + "\">Add "
							+ accrs.getString("vouchertype_name") + "</a></li>\n");
					// accexpenselink.append("<li><a href=\"../accounting/voucher-list.jsp?all=yes&vouchertype_id="
					// + accrs.getString("vouchertype_id") + "\">List " +
					// accrs.getString("vouchertype_name") + "</a></li>\n");
				}
			}
			accrs.close();
			// / Build Add Link Menu
			accaddlink.append("" + "<div style=\"text-align:center\">"
					+ "<li><a href=\"#\" style=\"text-decoration:underline\">Add Voucher...</a>"
					+ "<ul style=\"text-align:left\">"
					+ "<li><a href=\"#\">Income</a>"
					+ "<ul>" + accincomelink + "</ul>" + "</li>"
					+ "<li><a href=\"#\">Expense</a>"
					+ "<ul>" + accexpenselink + "</ul>" + "</li>" + "</ul>"
					+ "</li>" + "</div>" + "");

			if (!accincomelink.toString().equals("")) {
				SetSession("accincomelink", accincomelink.toString().trim(), request);
			}
			if (!accexpenselink.toString().equals("")) {
				SetSession("accexpenselink", accexpenselink.toString().trim(), request);
			}
			if (!accaddlink.toString().equals("")) {
				SetSession("accaddlink", "" + accaddlink.toString().trim() + "", request);
			}
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
		}
	}

	public String GetSession(String key, HttpServletRequest request) {
		String sessionvalue = "";
		HttpSession session = request.getSession(true);
		Map getMap = (Map) session.getAttribute("sessionMap");
		if (getMap != null) {
			sessionvalue = getMap.get(key) + "";
		}
		if (sessionvalue.equals("null")) {
			sessionvalue = "";
		}
		return sessionvalue;
	}

	// getsession1 method for springboot
	public String getSession(String key, HttpSession session) {
		String sessionvalue = "";
		Map getMap = (Map) session.getAttribute("sessionMap");
		if (getMap != null) {
			sessionvalue = getMap.get(key) + "";
		}
		if (key.equals("empRecperPage") && sessionvalue.equals("null")) {
			sessionvalue = "10";
		}
		if (sessionvalue.equals("null")) {
			sessionvalue = "";
		}
		return sessionvalue;
	}

	public void SetSession(String key, String value, HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		Map setMap;
		if (session.getAttribute("sessionMap") == null) {
			setMap = new HashMap();
			session.setAttribute("sessionMap", setMap);
		}
		setMap = (Map) session.getAttribute("sessionMap");
		setMap.put(key, value);
	}

	// setsession1 method for springboot
	public void setSession(String key, String value, HttpSession session) {
		Map setMap;
		if (session.getAttribute("sessionMap") == null) {
			setMap = new HashMap();
			session.setAttribute("sessionMap", setMap);
		}
		setMap = (Map) session.getAttribute("sessionMap");
		setMap.put(key, value);
	}

	public String ReturnCustomerCurrBalance(String customer_id, String comp_id,
			String vouchertype_id) {
		String str = "";
		if (!CNumeric(customer_id).equals("0")) {
			String StrSql = "SELECT"
					+ " @currentbal_amount:= COALESCE(customer_curr_bal, 0) AS currentbal_amount,"
					+ " COALESCE (customer_credit_limit, 0) AS customer_credit_limit,"
					+ " customer_type,"
					+ " COALESCE(( SELECT COUNT(voucher_id)" + " FROM " + compdb(comp_id) + "axela_acc_voucher"
					+ " INNER JOIN " + compdb(comp_id) + "axela_acc_voucher_trans ON vouchertrans_voucher_id = voucher_id"
					+ " INNER JOIN " + compdb(comp_id) + "axela_customer sub ON sub.customer_id = voucher_customer_id AND sub.customer_type = 1"
					+ " WHERE 1=1"
					+ " AND sub.customer_id = customer_id"
					+ " AND voucher_vouchertype_id = 15 "
					+ " AND vouchertrans_paymode_id > 1"
					+ " ),0) AS cheqreturn,"
					+ " @pdcnotcleared:=COALESCE (( SELECT SUM(voucher_amount)"
					+ " FROM" + " " + compdb(comp_id) + "axela_acc_voucher"
					+ " INNER JOIN " + compdb(comp_id) + "axela_acc_voucher_trans ON vouchertrans_voucher_id = voucher_id"
					+ " INNER JOIN " + compdb(comp_id) + "axela_customer sub ON sub.customer_id = voucher_customer_id"
					+ " AND sub.customer_type = 1"
					+ " WHERE 1 = 1"
					+ " AND sub.customer_id = customer_id"
					+ " AND voucher_vouchertype_id = 9"
					+ " AND vouchertrans_paymode_id = 2"
					+ " AND SUBSTR(vouchertrans_cheque_date,1,8) > SUBSTR(" + toShortDate(kknow()) + ",1,8)" + " ),"
					+ " 0"
					+ " ) AS pdcnotcleared,"
					+ " CAST((@currentbal_amount+@pdcnotcleared) AS DECIMAL(15,2)) AS totalbalance"
					+ " FROM " + compdb(comp_id) + "axela_customer"
					+ " WHERE customer_id = " + CNumeric(customer_id)
					+ " GROUP BY customer_id"
					+ " ORDER BY customer_id";

			CachedRowSet crs = processQuery(StrSql, 0);
			try {
				while (crs.next()) {
					str += "<b>Curr. Bal.: " + IndFormat("" + df.format(crs.getDouble("currentbal_amount"))) + "</b>";
					str += "<br><b>Total. Bal.: " + IndFormat("" + df.format(crs.getDouble("totalbalance"))) + "</b>";
					if (!crs.getString("customer_type").equals("0")) {
						str += "<br><b>Credit Limit: " + IndFormat("" + crs.getDouble("customer_credit_limit")) + "</b>";
					}
					if (vouchertype_id.equals("5") || vouchertype_id.equals("4") || vouchertype_id.equals("3")
							|| vouchertype_id.equals("6") || vouchertype_id.equals("12") || vouchertype_id.equals("10")
							|| vouchertype_id.equals("20") || vouchertype_id.equals("21")) {
						if (crs.getInt("cheqreturn") > 0) {
							str += " <br><font color='red'><b>Cheque Return</b></font>";
						}
						str += " <br><a href='#' name='allinvoice'" + " id='allinvoice' onclick='showlocallinvoice("
								+ customer_id + "," + comp_id + ");'><b>All Invoice</b></a>";
					}
				}
			} catch (Exception ex) {
				SOPError(this.getClass().getName());
				SOPError("Error in "
						+ new Exception().getStackTrace()[0].getMethodName()
						+ ": " + ex);
			}
		}
		return str;
	}

	// public void AppReturnCustomerCurrBalance(String customer_id, String comp_id,
	// String vouchertype_id, JSONObject output) throws JSONException {
	// String str = "";
	// Gson gson = new Gson();
	// ArrayList<String> list = new ArrayList<String>();
	// Map<String, String> map = new HashMap<String, String>();
	// if (!CNumeric(customer_id).equals("0")) {
	// String StrSql = "SELECT"
	// + " @currentbal_amount:= COALESCE(customer_curr_bal, 0) AS currentbal_amount,"
	// + " COALESCE (customer_credit_limit, 0) AS customer_credit_limit,"
	// + " customer_type,"
	// + " COALESCE(( SELECT COUNT(voucher_id)" + " FROM " + compdb(comp_id) + "axela_acc_voucher"
	// + " INNER JOIN " + compdb(comp_id) + "axela_acc_voucher_trans ON vouchertrans_voucher_id = voucher_id"
	// + " INNER JOIN " + compdb(comp_id) + "axela_customer sub ON sub.customer_id = voucher_customer_id AND sub.customer_type = 1"
	// + " WHERE 1=1"
	// + " AND sub.customer_id = customer_id"
	// + " AND voucher_vouchertype_id = 15 "
	// + " AND vouchertrans_paymode_id > 1"
	// + " ),0) AS cheqreturn,"
	// + " @pdcnotcleared:=COALESCE (( SELECT SUM(voucher_amount)"
	// + " FROM" + " " + compdb(comp_id) + "axela_acc_voucher"
	// + " INNER JOIN " + compdb(comp_id) + "axela_acc_voucher_trans ON vouchertrans_voucher_id = voucher_id"
	// + " INNER JOIN " + compdb(comp_id) + "axela_customer sub ON sub.customer_id = voucher_customer_id"
	// + " AND sub.customer_type = 1"
	// + " WHERE 1 = 1"
	// + " AND sub.customer_id = customer_id"
	// + " AND voucher_vouchertype_id = 9"
	// + " AND vouchertrans_paymode_id = 2"
	// + " AND SUBSTR(vouchertrans_cheque_date,1,8) > SUBSTR(" + toShortDate(kknow()) + ",1,8)" + " ),"
	// + " 0"
	// + " ) AS pdcnotcleared,"
	// + " CAST((@currentbal_amount+@pdcnotcleared) AS DECIMAL(15,2)) AS totalbalance"
	// + " FROM " + compdb(comp_id) + "axela_customer"
	// + " WHERE customer_id = " + CNumeric(customer_id)
	// + " GROUP BY customer_id"
	// + " ORDER BY customer_id";
	// SOP("StrSql==currbal==" + StrSql);
	//
	// CachedRowSet crs = processQuery(StrSql, 0);
	// try {
	// while (crs.next()) {
	// map.put("currentbal_amount", IndFormat("" + df.format(crs.getDouble("currentbal_amount"))));
	// map.put("totalbalance", IndFormat("" + df.format(crs.getDouble("totalbalance"))));
	// // if (!crs.getString("customer_type").equals("0")) {
	//
	// map.put("customer_credit_limit", IndFormat("" + crs.getDouble("customer_credit_limit")));
	// // }
	// if (vouchertype_id.equals("5") || vouchertype_id.equals("114") || vouchertype_id.equals("3")
	// || vouchertype_id.equals("6") || vouchertype_id.equals("12") || vouchertype_id.equals("10")
	// || vouchertype_id.equals("20") || vouchertype_id.equals("21")) {
	// if (crs.getInt("cheqreturn") > 0) {
	// map.put("msg", "Cheque Return");
	// }
	// // str += " <br><a href='#' name='allinvoice'"
	// // + " id='allinvoice' onclick='showlocallinvoice(" + customer_id + "," + comp_id + ");'><b>All Invoice</b></a>";
	// }
	// list.add(gson.toJson(map));
	// }
	// output.put("customercurrbalance", list);
	// } catch (Exception ex) {
	// SOPError(" Aster===" + this.getClass().getName());
	// SOPError("Error in " + new Exception().getStackTrace()[0].getMethodName() + ": " + ex);
	// }
	// }
	// }

	public void AssignAdminSession(String id, int role_id, String recperpage,
			HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.setAttribute("user_id", id);
		session.setAttribute("user_role_id", role_id);
		session.setAttribute("user_recperpage", recperpage);

		Map setMap;
		if (session.getAttribute("sessionMap") == null) {
			setMap = new HashMap();
			session.setAttribute("sessionMap", setMap);
		}
		setMap = (Map) session.getAttribute("sessionMap");
		setMap.put("formatdate_name", "dd/MM/yyyy");
		setMap.put("formatdate_datepicker", "dd/mm/yyyy");
		setMap.put("formattime_name", "HH:mm");
		setMap.put("formattime_timepicker", "HH:mm");

		session.setMaxInactiveInterval(30 * 60);
	}

	public void AssignChannelSession(String channeluser_id, int role_id,
			String channeluser_all_exe, String channeluser_channel_id,
			String channel_name, String recperpage, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession(true);

			session.setAttribute("channeluser_id", channeluser_id);
			session.setAttribute("channeluser_role_id", role_id);
			session.setAttribute("channeluser_channel_id",
					channeluser_channel_id);
			session.setAttribute("channel_name", channel_name);
			session.setAttribute("channeluser_recperpage", recperpage);
			session.setMaxInactiveInterval(30 * 60);

			if (role_id == 1 || channeluser_all_exe.equals("1")) {
				session.setAttribute("ChanneluserExeAccess", "");
			} else {
				String StrSql = "SELECT channeluserexe_exe_id"
						+ " FROM " + maindb() + "channel_user_exe"
						+ " WHERE channeluserexe_channeluser_id = " + channeluser_id + "";
				CachedRowSet crs = processQuery(StrSql, 0);

				String Str = " ";
				if (crs.isBeforeFirst()) {
					while (crs.next()) {
						Str += " OR channeluser_id = " + crs.getString("channeluserexe_exe_id");
					}
				}
				crs.close();

				session.setAttribute("ChanneluserExeAccess", " AND (channeluser_id = " + channeluser_id + Str + ")");
			}

			Map setMap;
			if (session.getAttribute("sessionMap") == null) {
				setMap = new HashMap();
				session.setAttribute("sessionMap", setMap);
			}
			setMap = (Map) session.getAttribute("sessionMap");
			setMap.put("formatdate_name", "dd/MM/yyyy");
			setMap.put("formatdate_datepicker", "dd/mm/yyyy");
			setMap.put("formattime_name", "HH:mm");
			setMap.put("formattime_timepicker", "HH:mm");

		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
		}
	}

	/**
	 * @param fieldName
	 * @param session
	 * @return
	 */

	public boolean returnPerm(String fieldName, HttpSession session) {
		String CheckPerm = "", msg = "", strSearch = "", empId = "";
		empId = CNumeric(getSession("empId", session));
		if (!empId.equals("1")) {
			String field[] = fieldName.split(",");
			for (int i = 0; i < field.length; i++) {
				if ((PadQuotes(field[i]).equals("emp_role_id"))
						|| (PadQuotes(field[i]).equals("emp_export_access"))
						|| (field[i].equals("1"))
						|| (PadQuotes(field[i]).equals("emp_report_access"))
						|| (PadQuotes(field[i]).equals("emp_mis_access"))) {
					strSearch += " " + field[i] + " = 1 OR ";

				} else {
					strSearch += " moduleAccess.accessName = '" + field[i].trim() + "' OR ";
				}
			}
			strSearch = "AND (" + strSearch.substring(0, strSearch.lastIndexOf("OR")) + ")";
			boolean result = empFilterImpl.findCheckPerm(strSearch, Integer.parseInt(empId));
			SOP("result==================" + result);
			return result;
		} else {
			return true;
		}
	}

	public boolean checkPerm(String fieldName, HttpSession session) {
		String CheckPerm = "", msg = "", strSearch = "", empId = "";
		empId = CNumeric(getSession("empId", session));
		if (!empId.equals("1")) {
			String field[] = fieldName.split(",");
			for (int i = 0; i < field.length; i++) {
				if ((PadQuotes(field[i]).equals("emp_role_id"))
						|| (PadQuotes(field[i]).equals("emp_export_access"))
						|| (field[i].equals("1"))
						|| (PadQuotes(field[i]).equals("emp_report_access"))
						|| (PadQuotes(field[i]).equals("emp_mis_access"))) {
					strSearch += " " + field[i] + " = 1 OR ";

				} else {
					strSearch += " moduleAccess.accessName = '" + field[i].trim() + "' OR ";
				}
			}
			strSearch = "AND (" + strSearch.substring(0, strSearch.lastIndexOf("OR")) + ")";
			boolean result = empFilterImpl.findCheckPerm(strSearch, Integer.parseInt(empId));
			SOP("result==================" + result);
			return result;
		} else {
			return true;
		}
	}

	// public void CheckPerm(String comp_id, String fieldname,
	// HttpServletRequest request, HttpServletResponse response) {
	// String CheckPerm = "", msg = "", fieldn_name = "", emp_id = "";
	// try {
	// emp_id = CNumeric(GetSession("emp_id", request));
	// if (emp_id.equals("0")) {
	// if (AppRun().equals("1")) {
	// response.sendRedirect(response.encodeRedirectURL("../portal/index.jsp?msg=Your session has expired."));
	// } else {
	// // response.sendRedirect(response.encodeRedirectURL("../portal/index.jsp?msg=Your session has expired."));
	// AssignSession("2", "2", "1", "1", "10", 100, "1", request);
	// CheckPerm("1", fieldname, request, response);
	// }
	// } else if (!emp_id.equals("1")) {
	// String field[] = fieldname.split(",");
	// for (int i = 0; i < field.length; i++) {
	// // emp_export_access emp_report_access emp_mis_access
	// if ((PadQuotes(field[i]).equals("emp_role_id"))
	// || (PadQuotes(field[i]).equals("emp_export_access"))
	// || (field[i].equals("1"))
	// || (PadQuotes(field[i]).equals("emp_report_access"))
	// || (PadQuotes(field[i]).equals("emp_mis_access"))) {
	// fieldn_name += " " + field[i] + " = 1 OR ";
	//
	// } else {
	// fieldn_name += " access_name = '" + field[i].trim() + "' OR ";
	// }
	// }
	// String Strsql = "SELECT emp_id"
	// + " FROM " + compdb(comp_id) + "axela_emp"
	// + " LEFT JOIN " + compdb(comp_id) + "axela_emp_access ON empaccess_emp_id = emp_id"
	// + " LEFT JOIN " + maindb().substring(0, maindb().length() - 1) + "." + "axela_module_access ON access_id = empaccess_access_id"
	// + " WHERE emp_id = " + emp_id + ""
	// + " AND (" + fieldn_name.substring(0, fieldn_name.lastIndexOf("OR")) + ")"
	// + " GROUP BY emp_id";
	// // SOP("Strsql==CheckPerm==" + Strsql);
	// CheckPerm = ExecuteQuery(Strsql);
	// if (CheckPerm.equals("")) {
	// msg = "msg=Access denied. Please contact system administrator!";
	// response.sendRedirect("../portal/error.jsp?" + msg);
	// }
	// }
	// } catch (Exception ex) {
	// SOPError(this.getClass().getName());
	// SOPError("Error in "
	// + new Exception().getStackTrace()[0].getMethodName()
	// + " : " + ex);
	// }
	// }

	public String CheckAdminPerm(String fieldname, HttpServletRequest request,
			HttpServletResponse response) {
		String CheckAdminPerm, msg = "";
		try {
			HttpSession session = request.getSession(true);
			CheckAdminPerm = ExecuteQuery("SELECT " + fieldname + " FROM axela_comp_user" + " WHERE user_id = " + session.getAttribute("user_id"));
			if (CheckAdminPerm.equals("0")) {
				msg = "msg=Access denied. Please contact system administrator!";
				response.sendRedirect("error.jsp?" + msg);
			}
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
		}
		return msg;
	}

	public String CheckChannelPerm(String fieldname,
			HttpServletRequest request, HttpServletResponse response) {
		String CheckAdminPerm, msg = "";
		try {
			HttpSession session = request.getSession(true);
			CheckAdminPerm = ExecuteQuery("SELECT COALESCE(" + fieldname + ", 0) FROM axela_channel_user"
					+ " WHERE channeluser_id = " + session.getAttribute("channeluser_id"));
			if (CheckAdminPerm.equals("0")) {
				msg = "msg=Access denied. Please contact system administrator!";
				response.sendRedirect("error.jsp?" + msg);
			}
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
		}
		return msg;
	}

	// public String ReturnPerm(String comp_id, String fieldname,
	// HttpServletRequest request) {
	// String CheckPerm = "1", msg = "", fieldn_name = "", emp_id = "";
	// try {
	// emp_id = CNumeric(GetSession("emp_id", request));
	// if (!emp_id.equals("1")) {
	// String field[] = fieldname.split(",");
	// for (int i = 0; i < field.length; i++) {
	// // emp_export_access emp_report_access emp_mis_access
	// if (field[i].equals("emp_role_id")
	// || field[i].equals("emp_export_access")
	// || field[i].equals("emp_report_access")
	// || field[i].equals("emp_mis_access")) {
	// fieldn_name += " " + field[i] + " = 1 OR ";
	// } else {
	// fieldn_name += " access_name = '" + field[i] + "' OR ";
	// }
	// }
	// String Strsql = "SELECT emp_id"
	// + " FROM " + compdb(comp_id) + "axela_emp"
	// + " LEFT JOIN " + compdb(comp_id) + "axela_emp_access ON empaccess_emp_id = emp_id"
	// + " LEFT JOIN " + maindb().substring(0, maindb().length() - 1) + "." + "axela_module_access ON access_id = empaccess_access_id"
	// + " WHERE emp_id = " + CNumeric(GetSession("emp_id", request)) + ""
	// + " AND (" + fieldn_name.substring(0, fieldn_name.lastIndexOf("OR")) + ")"
	// + " GROUP BY emp_id";
	// CheckPerm = ExecuteQuery(Strsql);
	// if (!CheckPerm.equals("")) {
	// CheckPerm = "1";
	// } else {
	// CheckPerm = "0";
	// }
	// }
	// } catch (Exception ex) {
	// CheckPerm = "0";
	// SOPError(this.getClass().getName());
	// SOPError("Error in "
	// + new Exception().getStackTrace()[0].getMethodName()
	// + " : " + ex);
	// }
	// return CheckPerm;
	// }

	// public String ReturnPerm(String comp_id, String fieldname,
	// HttpServletRequest request, HttpServletResponse response) {
	// String perm = "", emp_id="";
	// try {
	// HttpSession session = request.getSession(true);
	// emp_id = CNumeric(PadQuotes(session.getAttribute("emp_id") + ""));
	// if (!emp_id.equals("1")) {
	// //emp_export_access emp_report_access emp_mis_access
	// if (fieldname.equals("emp_export_access") ||
	// fieldname.equals("emp_report_access") ||
	// fieldname.equals("emp_mis_access")) {
	// fieldname = " " + fieldname + "= 1 ";
	// } else {
	// fieldname = " access_name='" + fieldname + "' ";
	// }
	// }
	// String Strsql = "Select emp_id "
	// + " from " + compdb(comp_id) + "axela_emp "
	// + " left JOIN " + compdb(comp_id) +
	// "axela_emp_access on empaccess_emp_id=emp_id "
	// + " left JOIN "+maindb().substring(0, maindb().length() - 1) +
	// "."+"axela_module_access on access_id=empaccess_access_id "
	// + " WHERE emp_id=" + session.getAttribute("emp_id") + " AND " + fieldname
	// + " "
	// + " GROUP BY emp_id";
	// perm = ExecuteQuery(Strsql);
	// // SOP("ReturnPerm : "+perm);
	// } catch (Exception ex) {
	// SOP( this.getClass().getName());
	// SOPError("Error in " + new
	// Exception().getStackTrace()[0].getMethodName() + " : " + ex);
	// }
	// return perm;
	// }

	public String ReturnAdminPerm(String fieldname, HttpServletRequest request,
			HttpServletResponse response) {
		String perm = "";
		try {
			HttpSession session = request.getSession(true);
			perm = ExecuteQuery("SELECT " + fieldname + " FROM axela_comp_user"
					+ " WHERE user_id = " + session.getAttribute("user_id"));
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
		}
		return perm;
	}

	public String ReturnChannelPerm(String fieldname,
			HttpServletRequest request, HttpServletResponse response) {
		String perm = "";
		try {
			HttpSession session = request.getSession(true);
			perm = ExecuteQuery("SELECT " + fieldname + " FROM axela_channel_user"
					+ " WHERE channeluser_id = " + session.getAttribute("channeluser_id"));
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in " + new Exception().getStackTrace()[0].getMethodName() + " : " + ex);
		}
		return perm;
	}

	public String ExePhotoOval(String empId) {
		String img = "<img style='width:55px; height:55px; border-radius: 50%;' src='" + WSUrl() + "/portal/thumbnail?imgId=" + empId + "&type=empImg&width=80&height=80'";
		if (AppRun().equals("1")) {
			img += " onerror=\"this.src='../../../../../axelacrm/assets/admin-ifx/executive.png'\" />";
		} else {
			img += " onerror=\"this.src='../../../../../assets/admin-ifx/executive.png'\" />";
		}
		return img;

	}

	public String Exename1(String comp_id, int exeid) {
		if (exeid != 0) {
			return ExecuteQuery("SELECT CONCAT('<a href=../portal/executive-summary.jsp?emp_id=', emp_id, '>', emp_name, ' (', emp_ref_no, ')', '</a>') AS exe"
					+ " FROM axela_" + comp_id + ".axela_emp"
					+ " WHERE emp_id = " + exeid);
		} else {
			return "---";
		}
	}

	public String Exename(String comp_id, int exeid) {
		String emp_name = "", emp_gender = "", emp_id = "";
		long emp_photo = 0;
		if (exeid != 0) {
			try {
				String StrSql = "SELECT CONCAT('<a class=exec_align href=../portal/executive-summary.jsp?emp_id=', emp_id, '>', emp_name, ' (', emp_ref_no, ')', '</a>') AS exe_name,"
						+ " emp_gender, emp_id,"
						+ " OCTET_LENGTH(COALESCE (emp_photo, '0')) AS emp_photo"
						+ " FROM axela_" + comp_id + ".axela_emp"
						+ " WHERE emp_id = " + exeid + "";
				// SOP("StrSql===" + StrSql);
				CachedRowSet crs = processQuery(StrSql, 0);

				while (crs.next()) {
					emp_name = crs.getString("exe_name");
					emp_id = crs.getString("emp_id");
					emp_photo = crs.getLong("emp_photo");
					emp_gender = crs.getString("emp_gender");
				}
				crs.close();
			} catch (Exception ex) {
				SOPError(this.getClass().getName());
				SOPError("Error in " + new Exception().getStackTrace()[0].getMethodName() + " : " + ex);
			}
			// return ExePhotoOval(emp_photo, emp_gender, "50", emp_id) + "</br>" + emp_name;
			return emp_name;
		} else {
			return "---";
		}
	}

	public String AdminExename(int exeid) {
		if (exeid != 0) {
			return ExecuteQuery("SELECT CONCAT('<a href=../adminpanel/user-list.jsp?user_id="
					+ exeid + ">', user_name, '</a>') AS exe"
					+ " FROM axela_comp_user" + " WHERE user_id = " + exeid);
		} else {
			return "No Executive found!";
		}
	}

	public String ChannelExename(int exeid) {
		if (exeid != 0) {
			return ExecuteQuery("SELECT CONCAT('<a href=../channel/channel-user-list.jsp?channeluser_id="
					+ exeid + ">', channeluser_name, '</a>') AS exe"
					+ " FROM axela_channel_user"
					+ " WHERE channeluser_id = " + exeid);
		} else {
			return "No Executive found!";
		}
	}

	public String ExenameHeader(String comp_id, int exeid) {
		if (exeid != 0) {
			return ExecuteQuery("SELECT CONCAT('<b>', emp_name, '</b><br>(', role_name, ')')"
					+ " FROM " + compdb(comp_id) + "axela_emp"
					+ " INNER JOIN " + compdb(comp_id) + "axela_emp_role ON role_id = emp_jobtitle_id"
					+ " WHERE emp_id = " + exeid);
		} else {
			return "No Executive found!";
		}

	}

	public String ChannelusernameHeader(String channel_id, int channeluserid) {
		if (channeluserid != 0) {
			return ExecuteQuery("SELECT CONCAT('<b>', channeluser_name, '</b><br>(', channeluser_jobtitle, ')')"
					+ " FROM axela_channel_user"
					+ " WHERE channeluser_channel_id = " + channel_id + ""
					+ " AND channeluser_id = " + channeluserid);
		} else {
			return "No Executive found!";
		}
	}

	public String UsernameHeader(int userid) {
		if (userid != 0) {
			return ExecuteQuery("SELECT CONCAT('<b>', user_name, '</b><br>(', user_jobtitle, ')')"
					+ " FROM axela_comp_user" + " WHERE user_id = " + userid);
		} else {
			return "No Executive found!";
		}
	}

	public String ReturnConfig(String fieldname, String comp_id) {
		String perm = ExecuteQuery("SELECT " + fieldname + " FROM " + compdb(comp_id) + "axela_comp" + " WHERE comp_id = " + comp_id);
		return perm;
	}

	public String WebValidate(String strWeb) {
		if (strWeb.startsWith("http://")) {
			strWeb = strWeb.substring(7);
		} else if (strWeb.startsWith("http:/")) {
			strWeb = strWeb.substring(6);
		} else if (strWeb.startsWith("http:")) {
			strWeb = strWeb.substring(5);
		} else if (strWeb.startsWith("http")) {
			strWeb = strWeb.substring(4);
		}
		return strWeb;
	}

	public static boolean IsValidBranchCode(String code) {
		boolean isvalid = true;
		Pattern p = Pattern.compile("[^A-Za-z0-9]");
		Matcher m = p.matcher(code);
		if (m.find() || code.contains(" ")) {
			isvalid = false;
		}
		return isvalid;
	}

	public static boolean IsValidSubdomain(String code) {
		String exp = "^[a-z0-9-]{2,100}$";
		boolean isvalid = false;
		CharSequence inputstr = code;
		Pattern pattern = Pattern.compile(exp);
		Matcher matcher = pattern.matcher(inputstr);
		if (matcher.matches()) {
			isvalid = true;
		}
		return isvalid;
	}

	public static boolean IsValidURL(String url) {
		String exp = "^[\\w\\.-]+\\.([\\w\\-]+\\.)+[A-Z]{2,4}$";
		boolean isvalid = false;
		CharSequence inputstr = url;
		Pattern pattern = Pattern.compile(exp, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputstr);
		if (matcher.matches()) {
			isvalid = true;
		}
		return isvalid;
	}

	public static boolean IsValidEmail(String email) {
		String exp = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,10}$";
		boolean isvalid = false;
		CharSequence inputstr = email;
		Pattern pattern = Pattern.compile(exp, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputstr);
		if (matcher.matches()) {
			isvalid = true;
		}
		return isvalid;
	}

	public boolean IsValidMobileNo(String mobileno) {
		try {
			boolean isvalid = false;
			if (mobileno.equals("")) {
				return true;
			}
			// SOP("mob="+mobileno);
			// SOP("mob88="+mobileno.replaceAll("[^-]", ""));
			if (mobileno.replaceAll("[^-]", "").length() != 1) {
				return isvalid;
			} else if (mobileno.length() > 15) {
				return isvalid;
			} else {
				String[] str = mobileno.split("-");
				if (str.length == 2) {
					if (str[0].equals("") || str[1].equals("")) {
						return isvalid;
					} else if (str.length > 1 && (str[0].length() < 1 || str[0].length() > 3) || Long.parseLong(str[0]) == 0) {
						return isvalid;
					} else if (str.length > 1 && (str[1].length() < 7 || str[1].length() > 10) || Long.parseLong(str[1]) == 0) {
						return isvalid;
					} else {
						isvalid = true;
					}
				} else {
					return isvalid;
				}
			}
			return isvalid;
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			return false;
		}
	}

	public boolean IsValidPhoneNo(String phoneno) {
		boolean isvalid = false;
		if (phoneno.equals("")) {
			return true;
		}
		if (phoneno.replaceAll("[^-]", "").length() != 2) {
			return isvalid;
		} else if (phoneno.length() > 14) {
			return isvalid;
		} else {
			String[] str = phoneno.split("-");
			if (str[0].equals("") || str[1].equals("") || str[2].equals("")) {
				return isvalid;
			} else if (str.length > 1 && (str[0].length() < 1 || str[0].length() > 3) || Long.parseLong(str[0]) == 0) {
				return isvalid;
			} else if (str.length > 1 && (str[1].length() < 1 || str[1].length() > 5) || Long.parseLong(str[1]) == 0) {
				return isvalid;
			} else if (str.length > 1 && (str[2].length() < 1 || str[2].length() > 8) || Long.parseLong(str[2]) == 0) {
				return isvalid;
			} else {
				isvalid = true;
			}
		}
		return isvalid;
	}

	public String IsValidUsername(String Username) {
		String msg = "";
		Pattern p = Pattern.compile("[^A-Za-z0-9_]");
		Matcher m = p.matcher(Username);
		if (m.find() || Username.contains(" ") || Username.length() <= 3) {
			msg = msg + "4 to 20 characters(A-Z a-z 0-9 no spaces)";
		}
		return msg;
	}

	public String ReplaceStr(String str, String pattern, String replace) {
		int s = 0;
		int e = 0;
		String lStr = str.toLowerCase();
		String lPattern = pattern.toLowerCase();
		StringBuilder result = new StringBuilder();
		while ((e = lStr.indexOf(lPattern, s)) >= 0) {
			result.append(str.substring(s, e));
			result.append(replace);
			s = e + pattern.length();
		}
		result.append(str.substring(s));
		return result.toString().trim();
	}

	public String toTitleCase(String str) {
		StringBuilder sb = new StringBuilder();
		str = str.toLowerCase();
		StringTokenizer strTitleCase = new StringTokenizer(str);
		while (strTitleCase.hasMoreTokens()) {
			String s = strTitleCase.nextToken();
			int scount = strTitleCase.countTokens();
			if (!s.substring(0, 1).equals("(")) {
				sb.append(s.replaceFirst(s.substring(0, 1), s.substring(0, 1)
						.toUpperCase()));
			} else {
				sb.append(s);
			}
			if (scount != 0) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	public String SplitPhoneNo(String number, int parm, String type) {
		String output = "";
		String[] arrystr = number.split("-");
		String code = arrystr[0];
		int l = arrystr.length;
		int count = l - 1;
		for (int i = 1; i <= count; i++) {
			int param = parm;
			String s = arrystr[i];
			StringBuilder sb = new StringBuilder(s);
			int len = sb.length();
			int a = param;
			while (len > param) {
				// sb.insert(param, ' ');
				param += a + 1;
				len++;
			}
			output += "-" + sb.toString();
		}
		code = code + output;
		if (!type.equals("")) {
			code = code + " (" + type + ")";
		}
		return code;
	}

	public void ErrorEmail(Exception errorMsg) {
		try {
			String msg = "";
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			errorMsg.printStackTrace(pw);

			String fromemail = "info@unisolonline.com";
			String toemail = "info@unisolonline.com";
			String subject = "Error in " + AppName + " - " + ClientName;
			msg = msg + "------\r\n" + sw.toString() + "------\r\n";
			msg = "<font  face=\"Verdana, Arial, Helvetica, sans-serif\">"
					+ msg + "</font>";
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
		}
	}

	// public void postMail(String to, String cc, String bcc, String from, String subject, String mess, String attach, String comp_id)
	// throws MessagingException {
	// try {// Get system properties
	// byte[] data = null;
	// Session mailSession = null;
	// Properties props = System.getProperties();
	// if (AppRun().equals("1")) {
	//
	// // Setup mail server
	// props.put("mail.transport.protocol", "smtp");
	// props.put("mail.smtp.port", "25");
	// props.put("mail.smtp.host", "mycampus.local");
	// props.put("mail.smtp.auth", "true");
	//
	// mailSession = Session.getInstance(props, new Authenticator() {
	//
	// public PasswordAuthentication getPasswordAuthentication() {
	// return new PasswordAuthentication(
	// "support@mycampus.local", "support");
	// }
	// });
	// } else {
	// props.put("mail.smtp.host", "192.168.0.10");
	// mailSession = Session.getInstance(props, null);
	//
	// // props.put("mail.transport.protocol", "smtp");
	// // props.put("mail.smtp.port", "25");
	// // props.put("mail.smtp.host", "mail.emax.in");
	// // props.put("mail.smtp.auth", "true");
	// // // Get session
	// // mailSession = Session.getInstance(props,
	// // new Authenticator() {
	// // public PasswordAuthentication getPasswordAuthentication() {
	// // return new PasswordAuthentication("vijay@emax.in",
	// // "Vanilla");}
	// // });
	// }
	// // SOP("session===="+session);
	// // Define message
	// MimeMessage message = new MimeMessage(mailSession);
	// message.setFrom(new InternetAddress(from));
	// // SOP("from==="+from);
	//
	// if (!to.equals("")) {
	// // message.addRecipient(Message.RecipientType.CC,new
	// // InternetAddress(cc));
	// ArrayList recipientsArray = new ArrayList();
	// StringTokenizer st = new StringTokenizer(to, ",");
	// while (st.hasMoreTokens()) {
	// recipientsArray.add(st.nextToken());
	// }
	// int sizeTo = recipientsArray.size();
	// InternetAddress[] addressTo = new InternetAddress[sizeTo];
	// for (int i = 0; i < sizeTo; i++) {
	// addressTo[i] = new InternetAddress(recipientsArray.get(i)
	// .toString());
	// }
	// message.setRecipients(Message.RecipientType.TO, addressTo);
	// }
	// if (!cc.equals("")) {
	// // message.addRecipient(Message.RecipientType.CC,new
	// // InternetAddress(cc));
	// ArrayList recipientsArray = new ArrayList();
	// StringTokenizer st = new StringTokenizer(cc, ",");
	// while (st.hasMoreTokens()) {
	// recipientsArray.add(st.nextToken());
	// }
	// int sizeTo = recipientsArray.size();
	// InternetAddress[] addressTo = new InternetAddress[sizeTo];
	// for (int i = 0; i < sizeTo; i++) {
	// addressTo[i] = new InternetAddress(recipientsArray.get(i)
	// .toString());
	// }
	// message.setRecipients(Message.RecipientType.CC, addressTo);
	// }
	//
	// if (!bcc.equals("")) {
	// // message.addRecipient(Message.RecipientType.CC,new
	// // InternetAddress(cc));
	// ArrayList recipientsArray = new ArrayList();
	// StringTokenizer st = new StringTokenizer(bcc, ",");
	// while (st.hasMoreTokens()) {
	// recipientsArray.add(st.nextToken());
	// }
	// int sizeTo = recipientsArray.size();
	// InternetAddress[] addressTo = new InternetAddress[sizeTo];
	// for (int i = 0; i < sizeTo; i++) {
	// addressTo[i] = new InternetAddress(recipientsArray.get(i)
	// .toString());
	// }
	// message.setRecipients(Message.RecipientType.BCC, addressTo);
	// // message.addRecipient(Message.RecipientType.BCC,new
	// // InternetAddress(bcc));
	// }
	// message.setSubject(subject);
	//
	// // create the message part
	// Multipart multipart = new MimeMultipart();
	// // SOP("multipart===="+multipart);
	// // fill message
	// MimeBodyPart messageBodyPart = new MimeBodyPart();
	// messageBodyPart.setContent(mess, "text/html");
	// multipart.addBodyPart(messageBodyPart);
	//
	// if (!attach.equals("")) {
	// attach = attach.replace("/", "\\");
	// String[] filepath = attach.split(";");
	// for (int j = 0; j < filepath.length; j++) {
	// // SOP("filepath===" + filepath);
	// String[] filename = filepath[j].split(",");
	//
	// data = attach.getBytes(filename[j]);
	// // SOP("attach=attach===" + attach);
	// messageBodyPart = new MimeBodyPart();
	// javax.activation.DataSource source = new FileDataSource(filename[0]);
	// messageBodyPart.setDataHandler(new DataHandler(source));
	// messageBodyPart.setFileName(filename[1]);
	// multipart.addBodyPart(messageBodyPart);
	// }
	// }
	//
	// if (mess.contains("cid:one.png")) {
	// messageBodyPart = new MimeBodyPart();
	// javax.activation.DataSource fds = new FileDataSource(TemplatePath()
	// + "one.png");
	// messageBodyPart.setDataHandler(new DataHandler(fds));
	// messageBodyPart.setDisposition(MimeBodyPart.INLINE);
	// messageBodyPart.setHeader("Content-ID", "<one.png>");
	// multipart.addBodyPart(messageBodyPart);
	// }
	//
	// // Put parts in message
	// message.setContent(multipart);
	// message.setSentDate(new Date());
	// // Send the message
	// Transport.send(message);
	// SOP("AxelaCRM Email: " + to);
	// } catch (Exception ex) {
	// SOPError(this.getClass().getName());
	// SOPError("Error in "
	// + new Exception().getStackTrace()[0].getMethodName()
	// + " : " + ex);
	// }
	// }

	// public void SendMail(final String to, final String cc, final String bcc,
	// final String from, final String fromname, final String subject,
	// final String mess, final String attach, final String adminemail,
	// final String mailserver, final String mailusername,
	// final String mailpassword, final String mailport,
	// final String mailssl) throws MessagingException {
	//
	// Thread t = new Thread(new Runnable() {
	//
	// public void run() {
	//
	// try {// Get system properties
	// // SOP("executed....");
	// Session mailSession = null;
	//
	// Properties props = System.getProperties();
	// if (AppRun().equals("1")) {
	// // Setup mail server
	// props.put("mail.smtp.host", mailserver);
	// props.put("mail.smtp.port", mailport);
	// props.put("mail.smtp.auth", "true");
	// props.put("mail.transport.protocol", "smtp");
	// if (mailssl.equals("1")) {
	// props.put("mail.smtp.socketFactory.port", mailport);
	// props.put("mail.smtp.socketFactory.class",
	// "javax.net.ssl.SSlSocketFactory");
	// }
	// mailSession = Session.getInstance(props,
	// new Authenticator() {
	//
	// public PasswordAuthentication getPasswordAuthentication() {
	// return new PasswordAuthentication(
	// mailusername, mailpassword);
	// }
	// });
	// } else {
	// props.put("mail.smtp.host", "192.168.0.10");
	// mailSession = Session.getInstance(props, null);
	// }
	// // SOP("session===="+session);
	// // Define message
	// MimeMessage message = new MimeMessage(mailSession);
	// if (fromname.equals("")) {
	// message.setFrom(new InternetAddress(adminemail));
	// } else {
	// message.setFrom(new InternetAddress(adminemail,
	// fromname));
	// }
	// // SOP("from==="+from);
	//
	// InternetAddress[] addressTo = null;
	// if (!to.equals("")) {
	// // message.addRecipient(Message.RecipientType.CC,new
	// // InternetAddress(cc));
	// ArrayList recipientsArray = new ArrayList();
	// StringTokenizer st = new StringTokenizer(to, ",");
	// while (st.hasMoreTokens()) {
	// recipientsArray.add(st.nextToken());
	// }
	// int sizeTo = recipientsArray.size();
	// addressTo = new InternetAddress[sizeTo];
	// for (int i = 0; i < sizeTo; i++) {
	// addressTo[i] = new InternetAddress(recipientsArray
	// .get(i).toString());
	// }
	// message.setRecipients(Message.RecipientType.TO,
	// addressTo);
	// }
	// if (!cc.equals("")) {
	// // message.addRecipient(Message.RecipientType.CC,new
	// // InternetAddress(cc));
	// ArrayList recipientsArray = new ArrayList();
	// StringTokenizer st = new StringTokenizer(cc, ",");
	// while (st.hasMoreTokens()) {
	// recipientsArray.add(st.nextToken());
	// }
	// int sizeTo = recipientsArray.size();
	// InternetAddress[] addressCC = new InternetAddress[sizeTo];
	// for (int i = 0; i < sizeTo; i++) {
	// addressCC[i] = new InternetAddress(recipientsArray
	// .get(i).toString());
	// }
	// message.setRecipients(Message.RecipientType.CC,
	// addressCC);
	// }
	//
	// if (!bcc.equals("")) {
	// // message.addRecipient(Message.RecipientType.CC,new
	// // InternetAddress(cc));
	// ArrayList recipientsArray = new ArrayList();
	// StringTokenizer st = new StringTokenizer(bcc, ",");
	// while (st.hasMoreTokens()) {
	// recipientsArray.add(st.nextToken());
	// }
	// int sizeTo = recipientsArray.size();
	// InternetAddress[] addressBCC = new InternetAddress[sizeTo];
	// for (int i = 0; i < sizeTo; i++) {
	// addressBCC[i] = new InternetAddress(recipientsArray
	// .get(i).toString());
	// }
	// message.setRecipients(Message.RecipientType.BCC,
	// addressBCC);
	// // message.addRecipient(Message.RecipientType.BCC,new
	// // InternetAddress(bcc));
	// }
	// message.setSubject(subject);
	//
	// // create the message part
	// Multipart multipart = new MimeMultipart();
	// // SOP("multipart===="+multipart);
	// // fill message
	// MimeBodyPart messageBodyPart = new MimeBodyPart();
	// messageBodyPart.setContent(mess, "text/html");
	// multipart.addBodyPart(messageBodyPart);
	//
	// if (!attach.equals("")) {
	// String attachment = attach.replace("/", "\\");
	// String[] filepath = attachment.split(";");
	// for (int j = 0; j < filepath.length; j++) {
	// String[] filename = filepath[j].split(",");
	// messageBodyPart = new MimeBodyPart();
	// javax.activation.DataSource source = new FileDataSource(filename[0]);
	// messageBodyPart.setDataHandler(new DataHandler(
	// source));
	// messageBodyPart.setFileName(filename[1]);
	// multipart.addBodyPart(messageBodyPart);
	// }
	// }
	//
	// // Put parts in message
	// message.setContent(multipart);
	// message.setReplyTo(InternetAddress.parse(from));
	// message.setSentDate(adminkknow());
	// // Send the message
	// Transport.send(message);
	// SOP("AxelaCRM SendMail: " + to);
	// } catch (Exception ex) {
	// SOPError(
	// this.getClass().getName());
	// SOPError("Error in "
	// + new Exception().getStackTrace()[0]
	// .getMethodName() + " : " + ex);
	// }
	//
	// }
	// });
	// t.start();
	// }

	public String Filename(String filepath) {
		String name = "";
		if (AppRun().equals("1")) {
			name = filepath.substring(filepath.lastIndexOf("/"));
		} else {
			name = filepath.substring(filepath.lastIndexOf("/"));
		}
		name = name.replace("/", "");
		name = name.replace("/", "");
		return name;
	}

	public String fileext(String filename) {
		String exts = "";
		exts = filename.substring(filename.lastIndexOf(".")).toLowerCase();
		return exts;
	}

	public String PaymentMode(int id) {
		String str = "InValid";
		switch (id) {
			case 1 :
				str = "Cash";
				break;
			case 2 :
				str = "Cheque/DD";
				break;
			case 3 :
				str = "Credit Card";
				break;
			case 4 :
				str = "Payment Gateway";
				break;
		}
		return str;
	}

	public String IPNo(String ipno) {
		int pos1 = ipno.indexOf(".") + 1;
		String ip1 = ipno.substring(0, pos1 - 1);
		String ip2 = ipno.substring(pos1, ipno.length()); // 168.0.2
		String ip3 = ip2.substring(ip2.indexOf(".") + 1, ip2.length());// 0.2
		String ip4 = ip3.substring(ip3.indexOf(".") + 1, ip3.length()); // 2

		ip2 = ip2.substring(0, ip2.indexOf(".")); // 168
		ip3 = ip3.substring(0, ip3.indexOf("."));

		int ipTot = (Integer.parseInt(ip1) * (256 * 256 * 256))
				+ (Integer.parseInt(ip2) * (256 * 256))
				+ (Integer.parseInt(ip3) * (256)) + Integer.parseInt(ip4);
		return ipTot + "";
	}

	public static String GenPass(int size) {
		StringBuilder s = new StringBuilder(size);
		for (int i = 0; i < size; i++) {
			s.append(RandomValue());
		}
		return s.toString();
	}

	public static String RandomValue() {
		Random ran = new Random();
		int no = ran.nextInt(62) + 1;

		switch (no) {
			case 1 :
				return "a";
			case 2 :
				return "b";
			case 3 :
				return "c";
			case 4 :
				return "d";
			case 5 :
				return "e";
			case 6 :
				return "f";
			case 7 :
				return "g";
			case 8 :
				return "h";
			case 9 :
				return "i";
			case 10 :
				return "j";
			case 11 :
				return "k";
			case 12 :
				return "l";
			case 13 :
				return "m";
			case 14 :
				return "n";
			case 15 :
				return "o";
			case 16 :
				return "p";
			case 17 :
				return "q";
			case 18 :
				return "r";
			case 19 :
				return "s";
			case 20 :
				return "t";
			case 21 :
				return "u";
			case 22 :
				return "v";
			case 23 :
				return "w";
			case 24 :
				return "x";
			case 25 :
				return "y";
			case 26 :
				return "z";
			case 27 :
				return "A";
			case 28 :
				return "B";
			case 29 :
				return "C";
			case 30 :
				return "D";
			case 31 :
				return "E";
			case 32 :
				return "F";
			case 33 :
				return "G";
			case 34 :
				return "H";
			case 35 :
				return "I";
			case 36 :
				return "J";
			case 37 :
				return "K";
			case 38 :
				return "L";
			case 39 :
				return "M";
			case 40 :
				return "N";
			case 41 :
				return "O";
			case 42 :
				return "P";
			case 43 :
				return "Q";
			case 44 :
				return "R";
			case 45 :
				return "S";
			case 46 :
				return "T";
			case 47 :
				return "U";
			case 48 :
				return "V";
			case 49 :
				return "W";
			case 50 :
				return "X";
			case 51 :
				return "Y";
			case 52 :
				return "Z";
			case 53 :
				return "0";
			case 54 :
				return "1";
			case 55 :
				return "2";
			case 56 :
				return "3";
			case 57 :
				return "4";
			case 58 :
				return "5";
			case 59 :
				return "6";
			case 60 :
				return "7";
			case 61 :
				return "8";
			case 62 :
				return "9";
			default :
				return "....";
		}
	}

	public static String CalServiceTax(String Fee, String tax_rate1) {
		// Given Fee=100; Tax=12.36%
		// Returns 12.36
		double taxcomp1 = 0.00, taxcomp2 = 0.00, taxcomp3 = 0.00;
		DecimalFormat deci = new DecimalFormat("#.##");
		taxcomp1 = Double.parseDouble(Fee) * Double.parseDouble(tax_rate1)
				/ 100;
		return deci.format(taxcomp1);
	}

	public static String CalDiscountamount(String Total, String Tax) {
		// Given Fee=5000; Tax=12.36%
		// Returns 4450
		DecimalFormat deci = new DecimalFormat("#.##");
		double DiscountedTax = Double.parseDouble(Total) * Double.parseDouble(Tax) / 100; // DiscountedTax=618
		double DiscountedTotal = Double.parseDouble(Total) + DiscountedTax; // DiscountedFee=5618
		double Taxout = (Double.parseDouble(Total) * DiscountedTax) / DiscountedTotal; // Taxout=550
		return deci.format(Double.parseDouble(Total) - Taxout);
	}

	public static String CalPrincipleServiceTax(String Fee, String Tax) {
		// Given Fee=100; Tax=12.36%
		// Returns 123.6
		DecimalFormat deci = new DecimalFormat("#.##");
		double taxcomp = Double.parseDouble(Fee) * Double.parseDouble(Tax) / 100;
		double PrincipleFee = Double.parseDouble(Fee) + taxcomp;
		return deci.format(PrincipleFee);

	}

	public static String CalPrincipleComp(String Fee, String Tax) {
		// Given Fee=5000; Tax=12.36%
		// Returns 4450
		DecimalFormat deci = new DecimalFormat("#.##");
		double DiscountedTax = Double.parseDouble(Fee) * Double.parseDouble(Tax) / 100; // DiscountedTax=618
		double DiscountedFee = Double.parseDouble(Fee) + DiscountedTax; // DiscountedFee=5618
		double Taxout = (Double.parseDouble(Fee) * DiscountedTax) / DiscountedFee; // Taxout=550
		return deci.format(Double.parseDouble(Fee) - Taxout);
	}

	public static String CalServiceTaxComp(String Fee, String Tax) {
		// Given Fee=5000; Tax=10%
		// Returns 500
		if (Fee.equals("") || Fee.equals("0")) {
			return "0";
		}
		DecimalFormat deci = new DecimalFormat("#.##");
		double DiscountedTax = Double.parseDouble(Fee) * Double.parseDouble(Tax) / 100; // DiscountedTax=500
		double DiscountedFee = Double.parseDouble(Fee) + DiscountedTax; // DiscountedFee=5500
		double Taxout = (Double.parseDouble(Fee) * DiscountedTax) / DiscountedFee; // Taxout=500
		return deci.format(Taxout);
	}

	public String CalculateTax(String Fee, String Tax)// CalculateTax
	{
		// Given Fee=5000; Tax=12.36%
		String DiscountedTax = Double.toString((Double.parseDouble(Fee) * Double.parseDouble(Tax)) / 100);// DiscountedTax=618
		return DiscountedTax;
	}

	public String PopulateTotalAmount(String Fee, String Tax)// PopulateTotalAmount
	{
		// Given Fee=5000; Tax=12.36% ; Courseware=1500
		double DiscountedTax1 = (Double.parseDouble(Fee) * Double.parseDouble(Tax)) / 100;// DiscountedTax=618
		double TotalAmount = Math.round(Double.parseDouble(Fee) + DiscountedTax1);// TotalAmount=7118
		String TotalAmount1 = Double.toString(TotalAmount);
		return TotalAmount1;
	}

	public String PopulateTotal(String Fee, String Tax)// PopulateTotalAmount
	{
		double TotalAmount = Math.round(Double.parseDouble(Fee) + Double.parseDouble(Tax));// TotalAmount=7118
		String TotalAmount1 = new BigDecimal(TotalAmount).toString();
		return TotalAmount1;
	}

	public int FileSize(File file) throws IOException {
		long length = file.length();
		byte[] bytes = new byte[(int) length];
		int offset = 0;
		int numRead = 0;
		try {
			InputStream is = new FileInputStream(file);
			while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}
			is.close();
		} catch (Exception e) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + e);
		}
		return offset;
	}

	// //////////file size to MB,GB.....///////////////
	public String ConvertFileSizeToBytes(int size) throws IOException {
		String str = "";
		if (size < 1024) {
			str = (size) + " Bytes";
		}
		if (size > 1024 && size < 1048576) {
			str = (size / 1024) + " KB";
		}
		if (size > 1048576 && size < 1073741824) {
			str = (size / 1048576) + " MB";
		}
		if (size > 1073741824) {
			str = (size / 1073741824) + " GB";
		}
		return str;
	}

	// Indian Rupee Format

	public String IndFormat(String val) {
		String negative = "";
		if (val.contains("-")) {
			val = val.replace("-", "");
			negative = "-";
		}
		double d = Double.parseDouble(val);
		String val1 = Math.round(d) + "";
		StringBuilder sb = new StringBuilder(val1 + "");
		int len = sb.length();
		if (len < 4) {
			return negative + sb.toString();
		}
		int cp = len - 3;
		sb.insert(cp, ',');
		if (len < 6) {
			return negative + sb.toString();
		}

		while (cp > 2) {
			cp -= 2;
			sb.insert(cp, ',');
		}
		return negative + sb.toString();
	}

	public String getOpprCode(String comp_id, String branch_id) {
		String code = "";
		String maxenqcode = "";
		try {
			maxenqcode = ExecuteQuery("SELECT oppr_no FROM " + compdb(comp_id) + "axela_sales_oppr"
					+ " WHERE oppr_branch_id = " + branch_id + "" + " ORDER by oppr_id DESC" + " LIMIT 1");
			if (!maxenqcode.equals("0") && !maxenqcode.equals("") && maxenqcode.contains("OPR")) {
				String[] str = maxenqcode.split("OPR");
				String newcode = str[1];
				newcode = triplenum(Integer.parseInt(newcode) + 1);
				code = "OPR" + newcode;
			} else {
				code = "OPR001";
			}
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
		}
		return code;
	}

	public String getQuoteCode(String comp_id, String branch_id) {
		String code = "";
		String maxinvoicecode = "";
		try {
			maxinvoicecode = ExecuteQuery("SELECT quote_no FROM " + compdb(comp_id) + "axela_invoice_quote"
					+ " WHERE quote_branch_id = " + branch_id + "" + " ORDER by quote_id DESC" + " LIMIT 1");
			if (!maxinvoicecode.equals("0") && !maxinvoicecode.equals("") && maxinvoicecode.contains("QT")) {
				String[] str = maxinvoicecode.split("QT");
				String newcode = str[1];
				newcode = triplenum(Integer.parseInt(newcode) + 1);
				code = "QT" + newcode;
			} else {
				code = "QT001";
			}
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
		}
		return code;
	}
	public String CleanArrVal(String arr) {
		if (!arr.equals("")) {
			arr = arr.substring(0, arr.length() - 1);
		}
		return arr;
	}
	public String getSOCode(String comp_id, String branch_id) {
		String code = "";
		String maxinvoicecode = "";
		try {
			maxinvoicecode = ExecuteQuery("SELECT so_no FROM " + compdb(comp_id) + "axela_sales_so"
					+ " WHERE voucher_branch_id = " + branch_id + "" + " ORDER by so_id DESC" + " LIMIT 1");
			if (!maxinvoicecode.equals("0") && !maxinvoicecode.equals("") && maxinvoicecode.contains("SO")) {
				String[] str = maxinvoicecode.split("SO");
				String newcode = str[1];
				newcode = triplenum(Integer.parseInt(newcode) + 1);
				code = "SO" + newcode;
			} else {
				code = "SO001";
			}
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
		}
		return code;
	}

	public String getInvoiceCode(String comp_id, String branch_id) {
		String code = "";
		String maxinvoicecode = "";
		try {
			maxinvoicecode = ExecuteQuery("SELECT invoice_no FROM " + compdb(comp_id) + "axela_invoice"
					+ " WHERE invoice_branch_id = " + branch_id + "" + " ORDER BY invoice_id DESC" + " LIMIT 1");
			if (!maxinvoicecode.equals("0") && !maxinvoicecode.equals("") && maxinvoicecode.contains("INV")) {
				String[] str = maxinvoicecode.split("INV");
				String newcode = str[1];
				newcode = triplenum(Integer.parseInt(newcode) + 1);
				code = "INV" + newcode;
			} else {
				code = "INV001";
			}

		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
		}
		return code;
	}

	public String getReceiptCode(String comp_id, String branch_id) {
		String code = "";
		String maxreceiptcode = "";
		try {
			maxreceiptcode = ExecuteQuery("SELECT receipt_no FROM " + compdb(comp_id) + "axela_invoice_receipt"
					+ " WHERE receipt_branch_id = " + branch_id + "" + " ORDER BY receipt_id DESC" + " LIMIT 1");
			if (!maxreceiptcode.equals("0") && !maxreceiptcode.equals("") && maxreceiptcode.contains("RCT")) {
				String[] str = maxreceiptcode.split("RCT");
				String newcode = str[1];
				newcode = triplenum(Integer.parseInt(newcode) + 1);
				code = "RCT" + newcode;
			} else {
				code = "RCT001";
			}
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
		}
		return code;
	}

	public String getContractCode(String comp_id, String branch_id) {
		String code = "";
		String maxinvoicecode = "";
		try {
			maxinvoicecode = ExecuteQuery("SELECT contract_no FROM " + compdb(comp_id) + "axela_service_contract"
					+ " WHERE contract_branch_id = " + branch_id + "" + " ORDER BY contract_id DESC" + " LIMIT 1");
			if (!maxinvoicecode.equals("0") && !maxinvoicecode.equals("") && maxinvoicecode.contains("CT")) {
				String[] str = maxinvoicecode.split("CT");
				String newcode = str[1];
				newcode = triplenum(Integer.parseInt(newcode) + 1);
				code = "CT" + newcode;
			} else {
				code = "CT001";
			}
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
		}
		return code;
	}

	public String PopulateFranchisee(String[] franchisee_ids, HttpServletRequest request) {
		StringBuilder stringval = new StringBuilder();
		HttpSession session = request.getSession(true);
		String comp_id = CNumeric(GetSession("comp_id", request));
		try {
			String StrSql = "SELECT franchisee_id, franchisee_name"
					+ " FROM " + compdb(comp_id) + "axela_franchisee"
					+ " GROUP BY franchisee_id"
					+ " ORDER BY franchisee_name";
			// SOP("StrSql==franchisee=" + StrSql);
			CachedRowSet rs = processQuery(StrSql, 0);
			stringval.append("<select name=\"dr_franchisee_id\" id=\"dr_franchisee_id\" class=\"form-control multiselect-dropdown\" size=\"10\" multiple=\"multiple\">\n");
			// Str.append("<option value=\"0\"> Select </option>\n");
			while (rs.next()) {
				stringval.append("<option value=").append(rs.getString("franchisee_id"));
				stringval.append(ArrSelectdrop(rs.getInt("franchisee_id"), franchisee_ids));
				stringval.append(">").append(rs.getString("franchisee_name")).append(" (").append(rs.getString("franchisee_id")).append(")</option>\n");
			}
			stringval.append("</select>");
			rs.close();
			return stringval.toString();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in " + new Exception().getStackTrace()[0].getMethodName() + ": " + ex);
			return "";
		}
	}

	public String PopulateBranch(String[] branch_ids, String franchisee_id, String param, String branch_type, HttpServletRequest request) {
		String BranchAccess = "";
		StringBuilder stringval = new StringBuilder();
		HttpSession session = request.getSession(true);
		BranchAccess = GetSession("BranchAccess", request);
		String comp_id = CNumeric(GetSession("comp_id", request));
		// SOP("branch_ids-----///----------" + franchisee_id);
		try {
			String SqlStr = "SELECT branch_id, branch_name, branch_code"
					+ " FROM " + compdb(comp_id) + "axela_branch"
					+ " WHERE branch_active = 1 ";
			if (!franchisee_id.equals("")) {
				SqlStr += " AND branch_franchisee_id IN (" + franchisee_id + ")";
			}
			if (!branch_type.equals("")) {
				SqlStr += "	AND branch_branchtype_id IN (" + branch_type + ")";
			}
			SqlStr += BranchAccess + ""
					+ " ORDER BY branch_branchtype_id, branch_name";
			// SOP("SqlStr=branch==" + SqlStr);
			CachedRowSet crs = processQuery(SqlStr, 0);
			stringval.append("<select name=\"dr_branch_id\" id=\"dr_branch_id\" size=\"10\" class=\"form-control multiselect-dropdown\" multiple=\"multiple\" >");
			if (param.equals("")) {
				stringval.append("<option value =0>Select Branch</option>");
			} else if (param.equals("all")) {
				// stringval.append("<option value =0>All Branches</option>");
			} else {
				stringval.append("<option value =0>").append(param).append("</option>");
			}
			while (crs.next()) {
				stringval.append("<option value=").append(crs.getString("branch_id")).append("");
				stringval.append(ArrSelectdrop(crs.getInt("branch_id"), branch_ids));
				stringval.append(">").append(crs.getString("branch_name")).append(" (").append(crs.getString("branch_code")).append(")</option>\n");
			}
			stringval.append("</select>");
			crs.close();
			return stringval.toString();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in " + new Exception().getStackTrace()[0].getMethodName() + " : " + ex);
			return "";
		}
	}
	public String PopulateBranch(String branch_id, String param, HttpServletRequest request) {
		// (String branch_id, String param,
		// HttpServletRequest request) {
		String BranchAccess = "";
		StringBuilder stringval = new StringBuilder();
		BranchAccess = GetSession("BranchAccess", request);
		String comp_id = CNumeric(GetSession("comp_id", request));
		try {
			String StrSql = "SELECT branch_id, branch_name, branch_code"
					+ " FROM " + compdb(comp_id) + "axela_branch"
					+ " WHERE branch_active = '1' "
					+ BranchAccess + ""
					+ " ORDER BY branch_name";
			// SOP("branch===" + StrSqlBreaker(StrSql));
			CachedRowSet crs = processQuery(StrSql, 0);
			stringval.append("<select name='dr_branch_id' id='dr_branch_id' class='selectbox form-control'>");
			SOP("param===" + param);
			if (param.equals("")) {
				stringval.append("<option value=0>Select</option>\n");
			} else if (param.equals("all")) {
				stringval.append("<option value=0>All Branches</option>\n");
			} else {
				stringval.append("<option value=0>").append(param).append("</option>\n");
			}
			while (crs.next()) {
				stringval.append("<option value=").append(crs.getString("branch_id"));
				stringval.append(StrSelectdrop(crs.getString("branch_id"), branch_id));
				stringval.append(">").append(crs.getString("branch_name"));
				stringval.append(" (").append(crs.getString("branch_code")).append(")</option>\n");
			}
			stringval.append("</select>");
			crs.close();
			return stringval.toString();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			ErrorEmail(ex);
			return "";
		}
	}

	public String PopulateBranch(String branch_id, String param, String branch_type, HttpServletRequest request) {
		String BranchAccess = "";
		StringBuilder stringval = new StringBuilder();
		HttpSession session = request.getSession(true);
		BranchAccess = GetSession("BranchAccess", request);
		String comp_id = CNumeric(GetSession("comp_id", request));
		try {
			String SqlStr = "SELECT branch_id, branch_name, branch_code"
					+ " FROM " + compdb(comp_id) + "axela_branch"
					+ " WHERE branch_active = 1 ";
			if (!branch_type.equals("")) {
				SqlStr += "	AND branch_branchtype_id IN (" + branch_type + ")";
			}
			SqlStr += BranchAccess + ""
					+ " ORDER BY branch_branchtype_id, branch_name";
			// SOP("SqlStr===" + SqlStr);
			CachedRowSet crs = processQuery(SqlStr, 0);
			stringval.append("<select name='dr_branch_id' id='dr_branch_id' class='multiselect-dropdown form-control'  multiple=\"multiple\">");
			if (param.equals("")) {
				stringval.append("<option value =0>Select Branch</option>");
			} else if (param.equals("all")) {
				stringval.append("<option value =0>All Branches</option>");
			} else {
				stringval.append("<option value =0>").append(param).append("</option>");
			}
			while (crs.next()) {
				stringval.append("<option value=").append(crs.getString("branch_id")).append("");
				stringval.append(StrSelectdrop(crs.getString("branch_id"), branch_id));
				stringval.append(">").append(crs.getString("branch_name")).append(" (").append(crs.getString("branch_code")).append(")</option>\n");
			}
			stringval.append("</select>");
			crs.close();
			return stringval.toString();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			return "";
		}
	}

	public String PopulateBranchHead(String branch_id, String comp_id,
			HttpServletRequest request) {
		String BranchAccess = "";
		String emp_role_id = "";
		StringBuilder stringval = new StringBuilder();
		BranchAccess = GetSession("BranchAccess", request);
		emp_role_id = CNumeric(GetSession("emp_role_id", request));
		try {
			String StrSql = "SELECT branch_id, branch_name, branch_code"
					+ " FROM " + compdb(comp_id) + "axela_branch"
					+ " WHERE branch_active = '1'" + BranchAccess + ""
					+ " ORDER BY branch_name ";

			CachedRowSet crs = processQuery(StrSql, 0);

			stringval.append("<option value=-1").append(StrSelectdrop("-1", branch_id)).append(">All Branches</option>\n");
			if (emp_role_id.equals("1")) {
				stringval.append("<option value=0").append(StrSelectdrop("0", branch_id)).append(">Head Office</option>\n");
			}
			while (crs.next()) {
				stringval.append("<option value=").append(crs.getString("branch_id"));
				stringval.append(StrSelectdrop(crs.getString("branch_id"), branch_id));
				stringval.append(">").append(crs.getString("branch_name")).append(" (");
				stringval.append(crs.getString("branch_code")).append(")</option>\n");
			}
			crs.close();
			return stringval.toString();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			ErrorEmail(ex);
			return "";
		}
	}

	public String PopulateMainCity(String city_id) {
		StringBuilder Str = new StringBuilder();
		try {
			String StrSql = "SELECT city_id,"
					+ " CONCAT(city_name, ' - ', state_name) AS city_name"
					+ " FROM " + maindb() + "city"
					+ " INNER JOIN " + maindb() + "state ON state_id = city_state_id" + " WHERE 1 = 1";
			if (!city_id.equals("")) {
				StrSql += " AND city_id = " + city_id + "";
			}
			StrSql += " OR city_name = 'Bangalore'"
					+ " OR city_name = 'Delhi'"
					+ " OR city_name = 'Noida'"
					+ " OR city_name = 'Gurgaon'"
					+ " ORDER BY city_name"
					+ " LIMIT 15";
			CachedRowSet crs = processQuery(StrSql, 0);

			Str.append("<option value=\"0\">Select</option>\n");
			while (crs.next()) {
				Str.append("<option value=").append(crs.getString("city_id"));
				Str.append(StrSelectdrop(crs.getString("city_id"), city_id));
				Str.append(">").append(crs.getString("city_name")).append("</option>\n");
			}
			crs.close();
			return Str.toString();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
			return "";
		}
	}

	public String PopulateChannel(String channel_id, HttpServletRequest request) {
		StringBuilder stringval = new StringBuilder();
		try {
			String StrSql = "SELECT channel_id, channel_name"
					+ " FROM axela_channel"
					+ " WHERE channel_active = '1'"
					+ " ORDER BY channel_name";

			CachedRowSet crs = processQuery(StrSql, 0);

			stringval.append("<option value=0>All Channels</option>");
			while (crs.next()) {
				stringval.append("<option value=").append(crs.getString("channel_id"));
				stringval.append(StrSelectdrop(crs.getString("channel_id"), channel_id));
				stringval.append(">").append(crs.getString("channel_name")).append(" (");
				stringval.append(crs.getString("channel_id")).append(")</option> \n");
			}
			crs.close();
			return stringval.toString();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			ErrorEmail(ex);
			return "";
		}
	}

	public String PopulateChannelUser(String channeluser_id, String channel_id,
			HttpServletRequest request) {
		StringBuilder stringval = new StringBuilder();
		try {
			String StrSql = "SELECT channeluser_id, channeluser_name"
					+ " FROM axela_channel_user"
					+ " WHERE channeluser_active = '1'"
					+ " AND channeluser_channel_id = " + channel_id + ""
					+ " ORDER BY channeluser_name";
			CachedRowSet rs = processQuery(StrSql, 0);

			stringval.append("<option value=0>All Users</option>");
			while (rs.next()) {
				stringval.append("<option value=").append(rs.getString("channeluser_id"));
				stringval.append(StrSelectdrop(rs.getString("channeluser_id"), channeluser_id));
				stringval.append(">").append(rs.getString("channeluser_name")).append(" (");
				stringval.append(rs.getString("channeluser_id")).append(")</option> \n");
			}
			return stringval.toString();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			ErrorEmail(ex);
			return "";
		}
	}

	public void getcompsession(HttpServletRequest request, HttpServletResponse response) {
		try {
			String servername = PadQuotes(request.getServerName() + "");
			// SOP("servername===" + servername);
			String comp_id = "";
			if (servername.equals("localhost")) {
				servername = "localhost.localhost";
			}

			String StrSql = "SELECT comp_id FROM axela_comp"
					+ " INNER JOIN axela_channel ON channel_id = comp_channel_id"
					+ " INNER JOIN axela_order ON order_comp_id = comp_id"
					+ " WHERE comp_active = 1"
					+ " AND channel_active = 1"
					+ " AND order_active = 1"
					+ " AND CONCAT(comp_subdomain, '.', channel_domain) = '" + servername + "'"
					+ " AND SUBSTR(order_startdate, 1, 8) <= SUBSTR('" + toShortDate(kknow()) + "', 1, 8)"
					+ " AND SUBSTR(order_enddate, 1, 8) >= SUBSTR('" + toShortDate(kknow()) + "', 1, 8)";
			// SOP("StrSql==" + StrSql);
			Class.forName("com.mysql.jdbc.Driver");

			// conn = DriverManager.getConnection(
			// "jdbc:mysql://192.168.0.10:3306/axela_2", "clusttech-basavaraj",
			// "clusttech-basavaraj");
			//
			// System.out.println("Connection Sucess");
			// CachedRowSet crs = (CachedRowSet) conn.prepareStatement(StrSql);
			comp_id = PadQuotes(ExecuteQuery(StrSql));
			// while (crs.next()) {
			// comp_id = crs.getString("comp_id");
			// }
			// comp_id = "2016";
			if (AppRun().equals("0")) {
				comp_id = "2";
			}
			if (!servername.equals("") && !comp_id.equals("")) {
				SetSession("comp_id", comp_id, request);
			} else {
				response.sendRedirect(response.encodeRedirectURL("access.jsp?msg=Please contact Administrator!"));
			}
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
		}
	}

	public String getcomplogo(String comp_id) {
		String comp_logo = "";
		String StrSql = "SELECT comp_id, comp_name"
				+ " FROM " + maindb() + "comp"
				+ " WHERE comp_id = " + comp_id + "";
		try {
			CachedRowSet crs = processQuery(StrSql, 0);
			while (crs.next()) {
				if (!crs.getString("comp_logo").equals("")) {
					comp_logo = "<img src=../Thumbnail.do?image_type2=comp&comp_id"
							+ crs.getString("comp_id") + "&width=250 alt=" + crs.getString("comp_name") + ">";
				} else {
					comp_logo = "<b>" + crs.getString("comp_name") + "</b>";
				}
			}
			crs.close();
			return comp_logo;
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			return "";
		}
	}

	public String getAdminlogo(String comp_id) {
		String comp_logo = "";
		String StrSql = "SELECT comp_logo, comp_name"
				+ " FROM axela_comp"
				+ " WHERE comp_id = " + comp_id + "";
		try {

			CachedRowSet crs = processQuery(StrSql, 0);
			while (crs.next()) {
				if (!crs.getString("comp_logo").equals("")) {
					comp_logo = "<img src=../Thumbnail.do?complogo="
							+ crs.getString("comp_logo") + "&width=250 alt="
							+ crs.getString("comp_name") + ">";
				} else {
					comp_logo = "<b>" + crs.getString("comp_name") + "</b>";
				}
			}
			crs.close();
			return comp_logo;
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			ErrorEmail(ex);
			return "";
		}
	}

	public String getChannellogo(String channel_id) {
		String channel_logo = "";
		String StrSql = "SELECT channel_logo, channel_name FROM axela_channel"
				+ " WHERE channel_id = " + channel_id + "";
		try {

			CachedRowSet crs = processQuery(StrSql, 0);
			while (crs.next()) {
				if (!crs.getString("channel_logo").equals("")) {
					channel_logo = "<img src=../Thumbnail.do?channellogo="
							+ crs.getString("channel_logo") + "&width=250 alt="
							+ crs.getString("channel_name") + ">";
				} else {
					channel_logo = "<b>" + crs.getString("channel_name") + "</b>";
				}
			}
			crs.close();
			return channel_logo;
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			ErrorEmail(ex);
			return "";
		}
	}

	public boolean CheckActTime(Date starttime, String comp_id) {
		String comp_actleadtime = "";
		comp_actleadtime = ExecuteQuery("SELECT comp_actleadtime FROM "
				+ compdb(comp_id) + "axela_comp" + " WHERE comp_id = " + comp_id);
		double BufferTime = Double.parseDouble(comp_actleadtime);
		Date acttime = addHoursDate(kknow(), 0, BufferTime, 0);
		if (starttime.after(acttime)) {
			return true;
		} else {
			return false;
		}
	}

	public String isHoliday(String comp_id, String batch_branch_id, String date) {
		// date must be in yyyyMMddHHmmss format
		String result = "";
		String StrSql = "";
		try {
			StrSql = "SELECT holi_name, holitype_name"
					+ " FROM " + compdb(comp_id) + "axela_holi"
					+ " INNER JOIN axela_holi_type ON holitype_id = holi_holitype_id"
					+ " WHERE holi_date = '" + toShortDate(stringToDate(date)) + "'"
					+ " AND (holi_branch_id = 0"
					+ " OR holi_branch_id = " + batch_branch_id + ")";

			CachedRowSet crs = processQuery(StrSql, 0);
			if (crs.isBeforeFirst()) {
				while (crs.next()) {
					result += crs.getString("holi_name") + " (" + crs.getString("holitype_name") + ")<br>";
				}
			}
			crs.close();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			ErrorEmail(ex);
		}
		return result;
	}

	public String getPercentage(long numerator, long denominator) {
		DecimalFormat deci = new DecimalFormat("#.##");
		String str = "0";
		if (denominator != 0 && numerator > 0) {
			str = deci.format((numerator * 100) / denominator);
		}
		return str;
	}

	public String getPercentage(int numerator, int denominator) {
		DecimalFormat deci = new DecimalFormat("#.##");
		String str = "0";
		if (denominator != 0 && numerator > 0) {
			str = deci.format((numerator * 100) / denominator);
		}
		return str;
	}

	public String getPercentage(double numerator, double denominator) {
		DecimalFormat deci = new DecimalFormat("#.##");
		String str = "0";
		if (denominator != 0 && numerator > 0) {
			str = deci.format((numerator * 100) / denominator);
		}
		return str;
	}

	public String TextDate(int id) {
		switch (id) {
			case 01 :
				return "First";

			case 02 :
				return "Second";

			case 03 :
				return "Third";

			case 04 :
				return "Fourth";

			case 05 :
				return "Fifth";

			case 06 :
				return "Sixth";

			case 07 :
				return "Seventh";

			case 8 :
				return "Eighth";

			case 9 :
				return "Nineth";

			case 10 :
				return "Tenth";

			case 11 :
				return "Eleventh";

			case 12 :
				return "Twelfth";

			case 13 :
				return "Thirteenth";

			case 14 :
				return "Fourteenth";

			case 15 :
				return "Fifteenth";

			case 16 :
				return "Sixteenth";

			case 17 :
				return "Seventeenth";

			case 18 :
				return "Eighteenth";

			case 19 :
				return "Ninteenth";

			case 20 :
				return "Twentieth";

			case 21 :
				return "Twenty First";

			case 22 :
				return "Twenty Second";

			case 23 :
				return "Twenty Third";

			case 24 :
				return "Twenty Fourth";

			case 25 :
				return "Twenty Fifth";

			case 26 :
				return "Twenty Sixth";

			case 27 :
				return "Twenty Seventh";

			case 28 :
				return "Twenty Eighth";

			case 29 :
				return "Twenty Nineth";

			case 30 :
				return "Thirtieth";

			case 31 :
				return "Thirty First";

			default :
				return null;
		}
	}

	public String Dob_To_Word(String date) {
		String[] dates = date.split("/");
		String day = dates[0];
		String month = dates[1];
		String year = dates[2];
		// Dob_To_Word num=new Dob_To_Word();
		return TextDate(Integer.parseInt(day)) + " "
				+ textMonth(Integer.parseInt(month) - 1) + ", "
				+ IndianCurrencyFormatToWord(Integer.parseInt(year));
	}

	public int ReturnSmsCredit(int length) {
		int count = 0, inc = 307;
		for (count = 3; length >= 0; count++) {
			if (length <= 160) {
				return 1;
			}
			if (length >= 161 && length <= 306) {
				return 2;
			}
			if (length >= inc && length <= inc + 152) {
				return count;
			}
			inc = inc + 153;
		}
		return count;
	}

	public String cal_date(String startdate, String enddate) {
		String start[] = startdate.split("/");
		int d1 = Integer.parseInt(start[0]);
		int m1 = Integer.parseInt(start[1]);
		int y1 = Integer.parseInt(start[2]);

		String end[] = enddate.split("/");
		int d2 = Integer.parseInt(end[0]);
		int m2 = Integer.parseInt(end[1]);
		int y2 = Integer.parseInt(end[2]);

		int day_odd[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int d = d2 - d1, mon = m2 - 2;
		if ((m2 - 2) < 0) {
			mon = 11;
		}

		int m = m2 - m1, y = y2 - y1;
		String str = "";

		if (y2 < y1) {
			str = "Invalid date";
		} else if (y == 0) {
			if (m < 0 || (m == 0 && d < 0)) {
				str = "Invalid date";
			}
		}

		if (str.equals("")) {
			if (y2 % 4 == 0) {
				day_odd[1] = 29;
			}

			if (m > 0) {
				if (d < 0) {
					m--;
					d = day_odd[mon] - d1 + d2;
				}
			}

			if (m == 0) {
				if (d < 0 && y > 0) {
					m = 11;
					y--;
					d = day_odd[mon] - d1 + d2;
				}
			}

			if (m < 0 && y > 0) {
				m = 12 - (m1 - m2);
				y--;
				if (d < 0) {
					m--;
					d = day_odd[mon] - d1 + d2;
				} else if (d > 0) {
					d = d2 - d1;
				}
			}

			if (y != 0) {
				if (y == 1) {
					str = str + y + " Year ";

				} else {
					str = y + " Years ";
				}
			}

			if (m != 0) {
				if (m == 1) {
					str = str + m + " Month ";
				} else {
					str = str + m + " Months ";
				}
			}

			if (d != 0) {
				if (d == 1) {
					str = str + d + " Day";
				} else {
					str = str + d + " Days";
				}
			}

			if (y == 0 && m == 0 && d == 0) {
				str = "0 Days";
			}
		}
		return str;
	}

	// public String unescapehtml(String str) {
	// return StringEscapeUtils.unescapeHtml4(str);
	// }

	// public boolean isUniqueEmail(String comp_id, String email, String
	// customer_id) {
	// String StrSql = "";
	// boolean isUnique = true;
	// try {
	// StrSql = "select customer_id from " + compdb(comp_id) +
	// "axela_customer WHERE 1=1 ";
	// if (!customer_id.equals("")) {
	// StrSql = StrSql + " AND customer_id != " + customer_id;
	// }
	// StrSql = StrSql + " AND (customer_email1 = '" + email +
	// "' or  customer_email2 = '" + email + "') ";
	// // SOP("StrSql----"+StrSql);
	// CachedRowSet rs = processQuery(StrSql, 0);
	// if (rs.isBeforeFirst()) {
	// isUnique = false;
	// }
	// return isUnique;
	// } catch (Exception ex) {
	// SOPError(ex);
	// ErrorEmail(ex);
	// return false;
	// }
	// }
	public boolean IsUniqueCompPhone(String phone, String comp_id,
			String channel_id) {
		boolean isUnique = true;
		String StrSql = "";
		try {
			StrSql = "SELECT comp_id"
					+ " FROM axela_comp"
					+ " WHERE comp_channel_id = " + channel_id + "";
			if (!comp_id.equals("0")) {
				StrSql = StrSql + " AND comp_id!=" + comp_id + "";
			}
			StrSql = StrSql + " AND (comp_phone1='" + phone
					+ "' OR comp_phone2='" + phone + "'"
					+ " OR comp_phone3='" + phone
					+ "' OR comp_phone4='" + phone + "')";
			// SOP("StrSql = " + StrSql);

			CachedRowSet crs = processQuery(StrSql, 0);
			if (crs.isBeforeFirst()) {
				isUnique = false;
			}
			crs.close();

		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
		}
		return isUnique;
	}

	public boolean IsUniqueCompMobile(String mobile, String comp_id,
			String channel_id) {
		boolean isUnique = true;
		String StrSql = "";
		try {
			StrSql = "SELECT comp_id"
					+ " FROM axela_comp"
					+ " WHERE comp_channel_id = " + channel_id + "";
			if (!comp_id.equals("0")) {
				StrSql = StrSql + " AND comp_id!=" + comp_id + "";
			}
			StrSql = StrSql + " AND (comp_mobile1='" + mobile
					+ "' OR comp_mobile2='" + mobile + "')";
			CachedRowSet crs = processQuery(StrSql, 0);
			if (crs.isBeforeFirst()) {
				isUnique = false;
			}
			crs.close();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
			return false;
		}
		return isUnique;
	}

	public boolean isUniqueCompUrl(String comp_id, String comp_url_portal,
			String id) {
		String StrSql = "";
		boolean isUnique = true;
		try {
			StrSql = "SELECT comp_id FROM " + compdb(comp_id) + "axela_comp"
					+ " WHERE 1 = 1";
			if (!id.equals("")) {
				StrSql += " AND comp_id != " + id + "";
			}
			StrSql += " AND (comp_url_portal = '" + comp_url_portal + "'"
					+ " OR comp_url_mobile = '" + comp_url_portal + "')";
			CachedRowSet crs = processQuery(StrSql, 0);
			if (crs.isBeforeFirst()) {
				isUnique = false;
			}
			crs.close();
			return isUnique;
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			return false;
		}
	}

	public boolean isUniqueCompEmail(String email, String comp_id,
			String channel_id) {
		String StrSql = "";
		boolean isUnique = true;
		try {
			StrSql = "SELECT comp_id FROM axela_comp"
					+ " WHERE comp_channel_id = " + CNumeric(channel_id) + "";
			if (!CNumeric(comp_id).equals("0")) {
				StrSql += " AND comp_id != " + comp_id + "";
			}
			StrSql += " AND (comp_email1 = '" + email + "'"
					+ " OR comp_email2 = '" + email + "')";
			CachedRowSet crs = processQuery(StrSql, 0);
			if (crs.isBeforeFirst()) {
				isUnique = false;
			}
			crs.close();
			return isUnique;
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			return false;
		}
	}

	public boolean isUniqueChannelEmail(String email, String id) {
		String StrSql = "";
		boolean isUnique = true;
		try {
			StrSql = "SELECT channel_id FROM axela_channel" + " WHERE 1 = 1";
			if (!id.equals("")) {
				StrSql += " AND channel_id != " + id + "";
			}
			StrSql += " AND (channel_email1 = '" + email + "'"
					+ " OR channel_email2 = '" + email + "')";
			CachedRowSet crs = processQuery(StrSql, 0);
			if (crs.isBeforeFirst()) {
				isUnique = false;
			}
			crs.close();
			return isUnique;
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			ErrorEmail(ex);
			return false;
		}
	}

	public boolean isUniqueChannelPhone(String phone, String channel_id) {
		String StrSql = "";
		boolean isUnique = true;
		try {
			StrSql = "SELECT channel_id" + " FROM axela_channel"
					+ " WHERE 1 = 1";
			if (!channel_id.equals("0")) {
				StrSql += " AND channel_id != " + channel_id + "";
			}
			StrSql += " AND (channel_phone1 = '" + phone + "'"
					+ " OR channel_phone2 = '" + phone + "')";
			// SOP("StrSql = " + StrSql);
			CachedRowSet crs = processQuery(StrSql, 0);
			if (crs.isBeforeFirst()) {
				isUnique = false;
			}
			crs.close();
			return isUnique;
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			ErrorEmail(ex);
			return false;
		}
	}

	public boolean isUniqueChannelMobile(String mobile, String channel_id) {
		String StrSql = "";
		boolean isUnique = true;
		try {
			StrSql = "SELECT channel_id" + " FROM axela_channel"
					+ " WHERE 1 = 1";
			if (!channel_id.equals("0")) {
				StrSql += " AND channel_id != " + channel_id + "";
			}
			StrSql += " AND (channel_mobile1 = '" + mobile + "'"
					+ " OR channel_mobile2 = '" + mobile + "')";
			// SOP("StrSql = " + StrSql);
			CachedRowSet crs = processQuery(StrSql, 0);
			if (crs.isBeforeFirst()) {
				isUnique = false;
			}
			crs.close();
			return isUnique;
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			ErrorEmail(ex);
			return false;
		}
	}

	public boolean isUniqueChannelUserMobile(String mobile,
			String channeluser_id, String channel_id) {
		String StrSql = "";
		boolean isUnique = true;
		try {
			StrSql = "SELECT channeluser_mobile" + " FROM axela_channel_user"
					+ " WHERE 1 = 1" + " AND channeluser_channel_id = "
					+ channel_id + "";
			if (!channeluser_id.equals("0")) {
				StrSql += " AND channeluser_id != " + channeluser_id + "";
			}
			StrSql += " AND channeluser_mobile = '" + mobile + "'";
			// SOP("StrSql = " + StrSql);
			CachedRowSet crs = processQuery(StrSql, 0);
			if (crs.isBeforeFirst()) {
				isUnique = false;
			}
			crs.close();
			return isUnique;
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			ErrorEmail(ex);
			return false;
		}
	}

	public boolean isUniqueChannelUserPhone(String phone,
			String channeluser_id, String channel_id) {
		String StrSql = "";
		boolean isUnique = true;
		try {
			StrSql = "SELECT channeluser_phone" + " FROM axela_channel_user"
					+ " WHERE 1 = 1" + " AND channeluser_channel_id = "
					+ channel_id + "";
			if (!channeluser_id.equals("0")) {
				StrSql += " AND channeluser_id != " + channeluser_id + "";
			}
			StrSql += " AND channeluser_phone = '" + phone + "'";
			CachedRowSet crs = processQuery(StrSql, 0);
			if (crs.isBeforeFirst()) {
				isUnique = false;
			}
			crs.close();
			return isUnique;
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			ErrorEmail(ex);
			return false;
		}
	}

	public boolean isUniqueChannelUserEmail(String email,
			String channeluser_id, String channel_id) {
		String StrSql = "";
		boolean isUnique = true;
		try {
			StrSql = "SELECT channeluser_id" + " FROM axela_channel_user"
					+ " WHERE 1 = 1" + " AND channeluser_channel_id = "
					+ channel_id + "";
			if (!channeluser_id.equals("0")) {
				StrSql += " AND channeluser_id != " + channeluser_id + "";
			}
			StrSql += " AND (channeluser_email1 = '" + email + "'"
					+ " OR channeluser_email2 = '" + email + "')";
			// SOP("StrSql = " + StrSql);
			CachedRowSet crs = processQuery(StrSql, 0);
			if (crs.isBeforeFirst()) {
				isUnique = false;
			}
			crs.close();
			return isUnique;
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			ErrorEmail(ex);
			return false;
		}
	}

	public String ReturnDurType(int id) {
		String str = "InValid";
		switch (id) {
			case 1 :
				str = "Day(s)";
				break;
			case 2 :
				str = "Week(s)";
				break;
			case 3 :
				str = "Month(s)";
				break;
			case 4 :
				str = "Year(s)";
				break;
		}
		return str;
	}

	public String PopulateCategoryPop(String id, String comp_id, String cat_id,
			String active) {
		StringBuilder Str = new StringBuilder();
		String StrSql = "";
		try {
			StrSql = "SELECT cat_id, cat_name"
					+ " FROM " + compdb(comp_id) + "axela_inventory_cat_pop"
					+ " LEFT JOIN " + compdb(comp_id) + "axela_inventory_item ON item_cat_id = cat_id"
					+ " WHERE 1 = 1";

			if (!active.equals("")) {
				StrSql += " AND cat_active = " + active + "";
			}
			if (!cat_id.equals("")) {
				StrSql += " AND cat_id != " + cat_id + "";
			}
			StrSql += " GROUP BY cat_id" + " ORDER BY cat_rank";
			CachedRowSet crs = processQuery(StrSql, 0);

			while (crs.next()) {
				Str.append("<option value=").append(crs.getString("cat_id"));
				Str.append(StrSelectdrop(crs.getString("cat_id"), id));
				Str.append(">").append(crs.getString("cat_name")).append(":</option>\n");
			}
			crs.close();
			return Str.toString();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			return "";
		}
	}

	// / To be deleted
	public String IndDecimalFormat(String val) {
		String deci = "";
		String negative = "";
		if (val.contains("-")) {
			val = val.replace("-", "");
			negative = "-";
		}
		if (val.contains(".")) {
			deci = val.substring(val.indexOf("."));
		}
		double d = Double.parseDouble(val);
		d = Math.floor(d);
		String val1 = Math.round(d) + "";
		StringBuilder sb = new StringBuilder(val1 + "");
		int len = sb.length();
		if (len < 4) {
			return negative + sb.toString() + deci;
		}
		int cp = len - 3;
		sb.insert(cp, ',');
		if (len < 6) {
			return negative + sb.toString() + deci;
		}

		while (cp > 2) {
			cp -= 2;
			sb.insert(cp, ',');
		}
		return negative + sb.toString() + deci;
	}

	public String CurrencyFormat(String val, String decimal_format, String digit_format) {
		String deci = "";
		String negative = "";
		int len = 0, cp = 0;
		decimal_format = CNumeric(decimal_format);
		digit_format = CNumeric(digit_format);

		if (val.contains("-")) {
			val = val.replace("-", "");
			negative = "-";
		}

		if (val.contains(".")) {
			deci = val.substring(val.indexOf("."));
		}

		// No. of digits after decimal
		if (!deci.equals("")) {
			if (decimal_format.equals("0")) {
				deci = "";
			} else if (decimal_format.equals("1")) {
				deci = new DecimalFormat("0.0").format(Double.parseDouble(deci));
			} else if (decimal_format.equals("2")) {
				deci = new DecimalFormat("0.00").format(Double.parseDouble(deci));
			} else if (decimal_format.equals("3")) {
				deci = new DecimalFormat("0.000").format(Double.parseDouble(deci));
			}

			if (deci.contains("0.")) {
				deci = deci.replace("0.", ".");
			}
		}

		StringBuilder sb = new StringBuilder(Math.round(Math.floor(Double.parseDouble(val))) + "");
		len = sb.length();

		// Digits format
		if (digit_format.equals("1")) {
			// / Indian Format
			if (len < 4) {
				return negative + sb.toString() + deci;
			}
			cp = len - 3;
			sb.insert(cp, ',');
			if (len < 6) {
				return negative + sb.toString() + deci;
			}

			while (cp > 2) {
				cp -= 2;
				sb.insert(cp, ',');
			}
			return negative + sb.toString() + deci;

		} else if (digit_format.equals("2")) {
			// / European Format
			if (len < 4) {
				return negative + sb.toString() + deci;
			}
			cp = len - 3;
			sb.insert(cp, ',');
			if (len < 7) {
				return negative + sb.toString() + deci;
			}

			while (cp > 3) {
				cp -= 3;
				sb.insert(cp, ',');
			}
			return negative + sb.toString() + deci;

		} else if (digit_format.equals("3")) {
			// / Non Standard Format
			if (len < 4) {
				return negative + sb.toString() + deci;
			}
			cp = len - 3;
			sb.insert(cp, ',');
			return negative + sb.toString() + deci;

		} else if (digit_format.equals("4")) {
			// / Plain Format
			return negative + sb.toString() + deci;

		} else if (digit_format.equals("0")) {
			return "";
		}
		return negative + sb.toString() + deci;
	}

	public String CurrencyFormatWord(String val, String digit_format) {
		String currencyword = "";
		if (digit_format.equals("1")) {
			// Indian Format
			currencyword = IndianCurrencyFormatToWord(Long.parseLong(CNumeric(val)));
		} else {
			// American Format
			currencyword = AmericanCurrencyFormatToWord(val);
		}
		return currencyword;
	}

	static String[] b = {" hundred", " thousand", " lakh", " crore"};
	static String[] a = {"", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine"};
	static String[] c = {" ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen"};
	static String[] d = {" twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety"};
	String str = "";

	public String CompDB(String Str) {
		return Str;
	}

	public String IndianCurrencyFormatToWord(long num) {
		str = "";
		if (num == 0) {
			return "zero";
		}
		int c = 1;
		long rm;
		while (num != 0) {
			switch (c) {
				case 1 :
					rm = num % 100;
					IndianPass((int) rm);
					if (num > 100 && num % 100 != 0) {
						IndianDisplay(" AND");
					}
					num /= 100;
					break;
				case 2 :
					rm = num % 10;
					if (rm != 0) {
						IndianDisplay("");
						IndianDisplay(b[0]);
						IndianDisplay("");
						IndianPass((int) rm);
					}
					num /= 10;
					break;
				case 3 :
					rm = num % 100;
					if (rm != 0) {
						IndianDisplay("");
						IndianDisplay(b[1]);
						IndianDisplay("");
						IndianPass((int) rm);
					}
					num /= 100;
					break;
				case 4 :
					rm = num % 100;
					if (rm != 0) {
						IndianDisplay("");
						IndianDisplay(b[2]);
						IndianDisplay("");
						IndianPass((int) rm);
					}
					num /= 100;
					break;
				case 5 :
					rm = num % 100;
					if (rm != 0) {
						IndianDisplay("");
						IndianDisplay(b[3]);
						IndianDisplay("");
						IndianPass((int) rm);
					}
					num /= 100;
					break;
			}// end switch
			c++;
		}// end while
		return str;
	}// end method

	public void IndianPass(int num) {
		int rm, q;
		if (num < 10) {
			IndianDisplay(a[num]);
		} else if (num > 9 && num < 20) {
			IndianDisplay(c[num - 10]);
		} else if (num > 19) {
			rm = num % 10;
			if (rm == 0) {
				q = num / 10;
				IndianDisplay(d[q - 2]);
			} else {
				q = num / 10;
				IndianDisplay(a[rm]);
				IndianDisplay("");
				IndianDisplay(d[q - 2]);
			}
		}
	}

	public void IndianDisplay(String s) {
		String t;
		t = str;
		str = s;
		str += t;
	}

	// AmericanCurrencyFormat Variables
	private final String[] UNITS = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
			"thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	/**
	 * Holds the tens places *
	 */
	private final String[] TENS = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninty"};
	/**
	 * Covers max value of Long *
	 */
	private final String[] THOUSANDS = {"", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion", "sextillion"};

	public String AmericanCurrencyFormatToWord(String amount) {
		long number = Long.parseLong(CNumeric(amount));
		StringBuilder sb = new StringBuilder();
		if (number == 0) {
			return "zero";
		}

		// Negative numbers
		// if (number < 0) {
		// sb.append("negative ");
		// number = Math.abs(number);
		// }
		// Log keeps track of which Thousands place we're in
		long log = 1000000000000000000L, sub = number;
		int i = 7;
		do {
			// This is the 1-999 subset of the current thousand's place
			sub = number / log;
			// Cut down number for the next loop
			number = number % log;
			// Cut down log for the next loop
			log = log / 1000;
			i--; // tracks the big number place
			if (sub != 0) {
				// If this thousandths place is not 0 (that's okay, just skip)
				// tack it on
				sb.append(hundredsInWords((int) sub));
				sb.append(" ");
				sb.append(THOUSANDS[i]);

				if (number != 0) {
					sb.append(" ");
				}
			}
		} while (number != 0);
		return sb.toString();
	}

	private String hundredsInWords(int n) {
		if (n < 1 || n > 999) {
			throw new AssertionError(n); // Use assersion errors in private
											// methods only!
		}
		StringBuilder sb = new StringBuilder();

		// Handle the "hundred", with a special provision for x01-x09
		if (n > 99) {
			sb.append(UNITS[(n / 100) - 1]);
			sb.append(" hundred");
			n = n % 100;

			if (n != 0) {
				sb.append(" ");
			}

			if (n < 10) {
				sb.append("AND ");
			}
		}

		// Handle the special cases AND the tens place at the same time.
		if (n > 19) {
			sb.append(TENS[(n / 10) - 1]);
			n = n % 10;
			if (n != 0) {
				sb.append(" ");
			}
		}
		// This is the ones pla
		if (n > 0) {
			sb.append(UNITS[n - 1]);
		}
		return sb.toString();
	}

	public void LedgerCurrBalance(String comp_id, String ledger_id, HttpServletRequest request) throws ParseException {
		String StrSql = "";
		double currbalance = 0.00;
		comp_id = CNumeric(GetSession("comp_id", request));
		// Taken from Ledger_Check getreconciledata()
		StrSql = "SELECT (ledger_op_balance + "
				+ " (SELECT COALESCE((SUM(IF(vouchertrans_dc=1,vouchertrans_amount,0)) - SUM(if(vouchertrans_dc=0,vouchertrans_amount,0))),0)"
				+ " FROM " + compdb(comp_id) + "axela_acc_voucher"
				+ " INNER JOIN " + compdb(comp_id) + "axela_acc_voucher_trans ON vouchertrans_voucher_id = voucher_id"
				+ " WHERE voucher_active = 1"
				+ " AND vouchertrans_ledger_id = ledger_id"
				+ " AND SUBSTR(voucher_date ,1,8) < SUBSTR(" + convertShortDateToStr(stringToDate(gettimebyzone(comp_id).toString()).toString()) + ",1,8) )) AS openingbal"
				+ " FROM " + compdb(comp_id) + "axela_acc_ledger"
				+ " WHERE 1 = 1"
				+ " AND ledger_id = " + ledger_id
				+ " GROUP BY ledger_id";
		currbalance += Double.parseDouble(ExecuteQuery(StrSql));

		StrSql = "UPDATE ";
		updateQuery(StrSql);
	}

	public void ChannelCurrBalance(String channel_id) throws SQLException {
		String StrSql = "";
		StrSql = "UPDATE " + maindb() + "channel"
				+ " SET channel_currbal = (COALESCE((SELECT COALESCE(SUM(payment_amt), 0)"
				+ " FROM " + maindb() + "channel_payment"
				+ " WHERE payment_active = 1"
				+ " AND payment_channel_id = channel_id), 0)" + " -"
				+ " COALESCE((SELECT COALESCE(SUM(order_costprice), 0)"
				+ " FROM " + maindb() + "order"
				+ " WHERE order_active = 1"
				+ " AND order_process = 1"
				+ " AND order_channel_id = channel_id), 0))";
		if (!channel_id.equals("0")) {
			StrSql += " WHERE channel_id = " + channel_id + "";
		}
		updateQuery(StrSql);
	}

	public void CompCurrBalance(String comp_id) throws SQLException {
		String StrSql = "UPDATE " + maindb() + "comp"
				+ " SET comp_currbal = (COALESCE((SELECT COALESCE(SUM(receipt_amount), 0)"
				+ " FROM " + maindb() + "channel_receipt"
				+ " WHERE receipt_active = 1"
				+ " AND receipt_comp_id = comp_id), 0)" + " -"
				+ " COALESCE((SELECT COALESCE(SUM(invoice_total), 0)"
				+ " FROM " + maindb() + "channel_invoice"
				+ " WHERE invoice_active = 1"
				+ " AND invoice_comp_id = comp_id), 0))";
		if (!comp_id.equals("0")) {
			StrSql += " WHERE comp_id = " + comp_id + "";
		}
		updateQuery(StrSql);
	}

	public String RetrunSelectArrVal(HttpServletRequest request, String name) {
		String arr = "";
		String[] strArr = request.getParameterValues(name);
		try {
			if (strArr != null && strArr.length > 0) {
				for (int i = 0; i < strArr.length; i++) {
					arr += strArr[i] + ",";
				}
				arr = arr.substring(0, arr.length() - 1);
			}
			return arr;
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			return "";
		}
	}

	public String PopulateExportFormat(String exporttype) {
		String export = "";
		if (exporttype.equals("")) {
			exporttype = "xlsx";
		}
		if (exporttype.equals("PDF")) {
			export = export + "<option value = pdf" + StrSelectdrop("pdf", exporttype) + ">PDF</option>\n";
		} else {
			export = export + "<option value = xlsx" + StrSelectdrop("xlsx", exporttype) + ">MS Excel</option>\n";
			export = export + "<option value = html" + StrSelectdrop("html", exporttype) + ">HTML</option>\n";
		}

		return export;
	}

	public int CheckCurrentId(int d) {
		int n = d, sum = 0;
		while (d > 0) {
			int p = d % 10;
			sum += p;
			d = d / 10;
			if ((sum > 9) && (d == 0)) {
				d = sum;
				sum = 0;
			}
		}
		if ((sum == 8) || (sum == 4)) {
			n++;
		}
		return n;
	}

	public String ConstructPropName(String prop_id, String prop_br, String prop_coveredarea, String prop_plotarea,
			String type_name, String location_name, String prop_trans, String prop_projname, String ahrefStatus) {
		StrProp = "";
		DecimalFormat decimalformat = new DecimalFormat("#.##");
		if (prop_trans.equals("1")) {
			prop_trans = "for Sale";
		} else {
			prop_trans = "<b>for Rent</b>";
		}
		if (!prop_br.equals("") && !prop_br.equals("0")) {
			StrProp += prop_br + " BHK, ";
		}
		if (!prop_coveredarea.equals("0")) {
			StrProp += "" + IndFormat(prop_coveredarea) + " Sft, ";
		}
		if (prop_coveredarea.equals("0") && !prop_plotarea.equals("0")) {
			if (Float.valueOf(prop_plotarea.trim()).floatValue() > 43560) {
				StrProp += decimalformat.format(Float.valueOf(prop_plotarea.trim()).floatValue() / 43560) + " Acres, ";
			} else {
				StrProp += IndFormat(prop_plotarea) + " Sft, ";
			}
		}
		StrProp += type_name + " in " + location_name + " ";
		StrProp += " " + prop_trans + " (" + prop_id + ")";
		if (!prop_projname.equals("")) {
			StrProp += "<br>" + prop_projname;
		}
		if (!StrProp.equals("")) {
			StrProp = "<b>" + StrProp + "</b>";
		}
		if (ahrefStatus.equals("1")) {
			StrProp = "<a href=property-list.jsp?prop_id=" + prop_id + " target=_blank>" + StrProp + "</a>";
		}
		if (ahrefStatus.equals("2")) {
			StrProp = "<a href=\"javascript:WinPop('property-summary.jsp?prop_id=" + prop_id + "',"
					+ " 'propsummary', '0', '50', '800', '600')\">" + StrProp + "</a>";
		}
		return StrProp;
	}

	public String Floorno(String num) {
		String Str = "";
		if (num.equals("-2")) {
			Str = "II Basement";
		} else if (num.equals("-1")) {
			Str = "I Basement";
		} else if (num.equals("0")) {
			Str = "Ground Floor";
		} else if (num.equals("0.5")) {
			Str = "Mezzanine Floor";
		} else {
			Str = num + " Floor";
		}
		return Str;
	}

	public String PopulateCategory(String p_id, String prodcat_parent_id, String prodcat_id, String active, String comp_id) {
		String Str = "", StrSql = "", catname = "";
		try {
			StrSql = "SELECT prodcat_id, prodcat_name, prodcat_parent_id"
					+ " FROM axela_prod_cat"
					+ " WHERE prodcat_parent_id = " + p_id + ""
					+ " AND prodcat_id != " + prodcat_id + "";

			if (!active.equals("")) {
				StrSql += " AND prodcat_active='" + active + "'";
			}
			StrSql += " ORDER BY prodcat_name";
			CachedRowSet crs = processQuery(StrSql, 0);
			while (crs.next()) {
				if (crs.getString("prodcat_parent_id").equals("0")) {
					catname = crs.getString("prodcat_name");
				} else {
					catname = PopulateCategoryStr(crs.getString("prodcat_id"), comp_id);
				}
				p_id = crs.getString("prodcat_id");
				Str = Str + "<option value=" + crs.getString("prodcat_id") + StrSelectdrop(crs.getString("prodcat_id"),
						prodcat_parent_id) + ">" + catname + ":</option>\n";
				Str = Str + PopulateCategory(p_id, prodcat_parent_id, prodcat_id, active, comp_id);
			}
			crs.close();
			return Str;
		} catch (Exception ex) {
			SOPError("error n PopulateCategory: " + ex);
			ErrorEmail(ex);
			return "";
		}
	}

	public String PopulateGroupStr(String prodgroup_id, String comp_id) {
		String StrSql = "", prodgroup_name = "", parent_id = "0";
		try {
			if (!prodgroup_id.equals("") && !prodgroup_id.equals("0")) {
				StrSql = "SELECT accgroup_id, accgroup_name, accgroup_parent_id"
						+ " FROM " + compdb(comp_id) + "axela_acc_group"
						+ " WHERE accgroup_id = " + prodgroup_id + "";
				CachedRowSet crs = processQuery(StrSql, 0);
				while (crs.next()) {

					prodgroup_name = prodgroup_name + crs.getString("accgroup_name");
					parent_id = crs.getString("accgroup_parent_id");

					if (!parent_id.equals("0")) {
						while (!parent_id.equals("0")) {
							StrSql = "SELECT accgroup_id, accgroup_name, accgroup_parent_id"
									+ " FROM " + compdb(comp_id) + "axela_acc_group"
									+ " WHERE accgroup_id = " + parent_id;
							CachedRowSet crs1 = processQuery(StrSql, 0);
							while (crs1.next()) {
								prodgroup_name = crs1.getString("accgroup_name") + " > " + prodgroup_name;
								parent_id = crs1.getString("accgroup_parent_id");
							}
							crs1.close();
						}
					}
				}
				crs.close();
			}
			return prodgroup_name;
		} catch (Exception ex) {
			SOPError("error n PopulateCategoryStr: " + ex);
			ErrorEmail(ex);
			return "";
		}
	}

	public String PopulateCategoryStr(String prodcat_id, String comp_id) {
		String StrSql = "", prodcat_name = "", parent_id = "0";
		try {
			if (!prodcat_id.equals("") && !prodcat_id.equals("0")) {
				StrSql = "SELECT cat_id, cat_name, cat_parent_id"
						+ " FROM " + compdb(comp_id) + "axela_inventory_cat"
						+ " WHERE cat_id = " + prodcat_id + "";
				CachedRowSet crs = processQuery(StrSql, 0);
				while (crs.next()) {

					prodcat_name = prodcat_name + crs.getString("cat_name");
					parent_id = crs.getString("cat_parent_id");

					if (!parent_id.equals("0")) {
						while (!parent_id.equals("0")) {
							StrSql = "SELECT cat_id, cat_name, cat_parent_id"
									+ " FROM " + compdb(comp_id) + "axela_inventory_cat"
									+ " WHERE cat_id = " + parent_id;
							CachedRowSet crs1 = processQuery(StrSql, 0);
							while (crs1.next()) {
								prodcat_name = crs1.getString("cat_name") + " > " + prodcat_name;
								parent_id = crs1.getString("cat_parent_id");
							}
							crs1.close();
						}
					}
				}
				crs.close();
			}
			return prodcat_name;
		} catch (Exception ex) {
			SOPError("error n PopulateCategoryStr: " + ex);
			ErrorEmail(ex);
			return "";
		}
	}

	public void UpdateCurrentValue(String comp_id, String asset_id) {
		String StrSql = "";
		try {
			StrSql = "UPDATE " + compdb(comp_id) + "axela_asset"
					+ " LEFT JOIN " + compdb(comp_id) + "axela_asset_valuation ON value_asset_id = asset_id"
					+ " AND value_date = (SELECT MAX(value_date) AS value_date"
					+ " FROM " + compdb(comp_id) + "axela_asset_valuation"
					+ " WHERE value_asset_id = asset_id)"
					+ " SET asset_curr_value = COALESCE(value_amt, asset_value)"
					+ " WHERE 1 = 1";
			if (!asset_id.equals("0")) {
				StrSql += " AND asset_id = " + asset_id + " ";
			}
			updateQuery(StrSql);
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in " + new Exception().getStackTrace()[0].getMethodName() + ": " + ex);
		}
	}

	public static boolean IsValidCode(String code) {
		boolean isvalid = true;
		Pattern p = Pattern.compile("[^A-Za-z0-9]");
		Matcher m = p.matcher(code);
		if (m.find() || code.contains(" ")) {
			isvalid = false;
		}
		return isvalid;
	}

	public void CustomerCurrBalance(String customer_id, String comp_id) {
		String StrSql = "", query = "";
		if (customer_id.equals("0")) {
			query = "";
		} else {
			query = " WHERE customer_id = " + customer_id + "";
		}

		StrSql = "UPDATE " + compdb(comp_id) + "axela_customer"
				+ " SET customer_curr_bal = ((SELECT COALESCE(SUM(receipt_amount), 0)"
				+ " FROM " + compdb(comp_id) + "axela_invoice_receipt"
				+ " WHERE receipt_active = 1"
				+ " AND receipt_customer_id = customer_id)" + " -" + " (SELECT COALESCE(SUM(invoice_grandtotal), 0)"
				+ " FROM " + compdb(comp_id) + "axela_invoice"
				+ " WHERE invoice_active = 1"
				+ " AND invoice_customer_id = customer_id)" + " +" + " (SELECT COALESCE(SUM(po_grandtotal), 0)"
				+ " FROM " + compdb(comp_id) + "axela_inventory_po"
				+ " WHERE po_active = 1" + " AND po_supplier_id = customer_id)" + " -" + " (SELECT COALESCE(SUM(payment_amount), 0)"
				+ " FROM " + compdb(comp_id) + "axela_invoice_payment"
				+ " WHERE payment_active = 1"
				+ " AND payment_customer_id = customer_id)" + " +" + " (SELECT COALESCE(SUM(receipt_amount), 0)"
				+ " FROM " + compdb(comp_id) + "axela_bill_receipt"
				+ " WHERE receipt_active = 1"
				+ " AND receipt_customer_id = customer_id)" + " -" + " (SELECT COALESCE(SUM(billmode_amount), 0)"
				+ " FROM " + compdb(comp_id) + "axela_bill_mode_trans"
				+ " INNER JOIN " + compdb(comp_id) + "axela_bill ON billmode_bill_id = bill_id"
				+ " WHERE bill_active = 1" + " AND billmode_mode_id = 100"
				+ " AND bill_customer_id = customer_id))" + "" + query + "";
		updateQuery(StrSql);
	}

	public String GridLink(String label, String field, String ordernavi, String ordertype) {
		StringBuilder Str = new StringBuilder();
		Str.append("<a href=").append(ordernavi).append("&orderby=").append(field).append("&ordertype=");
		Str.append(ordertype).append(">").append(label).append("</a>");
		return Str.toString();
	}

	public String GetTheme(HttpServletRequest request) {
		String theme = "1";
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if ((cookie.getName()).compareTo("axelatheme") == 0) {
					theme = cookie.getValue();
				}
			}
		}
		return theme;
	}

	public String GetAdminTheme(HttpServletRequest request) {
		String theme = "1";
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if ((cookie.getName()).compareTo("axelaadmintheme") == 0) {
					theme = cookie.getValue();
				}
			}
		}
		return theme;
	}

	public String GetChannelTheme(HttpServletRequest request) {
		String theme = "1";
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if ((cookie.getName()).compareTo("axelachanneltheme") == 0) {
					theme = cookie.getValue();
				}
			}
		}
		return theme;
	}

	public void CheckStockLocation(String comp_id, String item_id,
			String location_id) {
		String StrSql = "";
		StrSql = "DELETE FROM " + compdb(comp_id) + "axela_inventory_stock"
				+ " WHERE 1 = 1";
		if (!item_id.equals("0")) {
			StrSql += " AND stock_item_id = " + item_id;
		}
		if (!location_id.equals("0")) {
			StrSql += " AND stock_location_id = " + location_id;
		}
		// SOPInfo("StrSql==stockdelloc==" + StrSqlBreaker(StrSql));
		updateQuery(StrSql);

		StrSql = "INSERT INTO " + compdb(comp_id) + "axela_inventory_stock"
				+ " ("
				+ "	stock_item_id,"
				+ " stock_location_id"
				+ "	)"
				+ " SELECT item_id, location_id"
				+ " FROM (SELECT item_id, location_id"
				+ " FROM  " + compdb(comp_id) + "axela_inventory_item," + " " + compdb(comp_id) + "axela_inventory_location"
				+ " WHERE item_active = 1" + " AND item_stock = 1";
		if (!item_id.equals("0")) {
			StrSql += " AND item_id = " + item_id;
		}
		StrSql += ") AS item"
				+ " LEFT JOIN " + compdb(comp_id) + "axela_inventory_stock"
				+ " ON CONCAT(stock_item_id," + " stock_location_id) = CONCAT(item_id, location_id)";
		// + " WHERE stock_location_id IS NULL";
		// SOPInfo("StrSql==stockloc==" + StrSqlBreaker(StrSql));
		updateQuery(StrSql);
	}

	// To calculate inventory current stock or our current stock
	public void CalCurrentStock(String comp_id, String item_id, String location_id) {
		try {
			String StrSql = "UPDATE " + "" + compdb(comp_id) + "axela_inventory_stock"
					+ " INNER JOIN " + "" + compdb(comp_id) + "axela_inventory_item ON item_id = stock_item_id"
					+ " SET stock_current_qty = \n" + " @stockcount:= \n"
					+ " COALESCE((SELECT SUM(IF(voucherclass_inventory_traffic = 1, vouchertrans_qty, -vouchertrans_qty))\n"
					+ " FROM  " + "" + compdb(comp_id) + "axela_acc_voucher_trans\n"
					+ " INNER JOIN  " + "" + compdb(comp_id) + "axela_acc_voucher ON voucher_id = vouchertrans_voucher_id\n"
					+ " INNER JOIN  " + "" + compdb(comp_id) + "axela_acc_voucher_type ON vouchertype_id = voucher_vouchertype_id\n"
					+ " INNER JOIN axela.axela_acc_voucher_class ON voucherclass_id = vouchertype_voucherclass_id\n"
					+ " WHERE vouchertrans_item_id = stock_item_id \n"
					+ " AND vouchertrans_location_id = stock_location_id \n"
					+ " AND vouchertype_affects_inventory = 1 AND voucher_active = 1),0)"
					+ " WHERE item_active = 1"
					+ " AND item_stock = 1";

			if (!item_id.equals("")) {
				StrSql += item_id;
			}

			if (!CNumeric(location_id).equals("0")) {
				StrSql += " AND stock_location_id = " + location_id + "";
			}
			// SOPInfo("StrSql===calcurrentstock===" + StrSqlBreaker(StrSql));
			updateQuery(StrSql);
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
		}
	}

	// public InputStream resizeImage(InputStream inputstream, String width, String format) {
	// try {
	// if (!width.equals("")) {
	// byte[] data = IOUtils.toByteArray(inputstream);
	// if (data != null) {
	// // SOPInfo("before bufferedImage reader===" + data);
	// bufferedImage = ImageIO.read(new ByteArrayInputStream(data));
	// // SOPInfo("bufferedImage======" + bufferedImage);
	// if (bufferedImage != null) {
	// // Calculate the target width and height
	// float scale = 1;
	// int targetWidth = 0;
	// int targetHeight = 0;
	// ImgWidth = PadQuotes(width);
	// targetWidth = (int) (bufferedImage.getWidth(null) * scale);
	// targetHeight = (int) (bufferedImage.getHeight(null) * scale);
	// if (ImgWidth == null || ImgWidth.equals("")) {
	// ImgWidth = targetWidth + "";
	// }
	// if (targetWidth > Integer.parseInt(ImgWidth) && !ImgWidth.equals("0")) {
	// targetHeight = Integer.parseInt(ImgWidth) * targetHeight / targetWidth;
	// targetWidth = Integer.parseInt(ImgWidth);
	// }
	// bufferedImage = createResizedCopy(bufferedImage, targetWidth, targetHeight);
	// ByteArrayOutputStream bios = new ByteArrayOutputStream();
	// ImageIO.write(bufferedImage, format, bios);
	// inputstream = new ByteArrayInputStream(bios.toByteArray());
	// }
	// }
	// }
	// } catch (IOException ex) {
	// SOPError("Terracle===" + this.getClass().getName());
	// SOPError("Error in " + new Exception().getStackTrace()[0].getMethodName() + " : " + ex);
	// return null;
	// }
	//
	// return inputstream;
	// }
	// BufferedImage createResizedCopy(Image originalImage, int scaledWidth, int scaledHeight) {
	// BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_RGB);
	// Graphics2D g = scaledBI.createGraphics();
	// g.setComposite(AlphaComposite.Src);
	// g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
	// // g.createHeadlessSmoothBufferedImage(originalImage, 0, scaledWidth, scaledHeight, null);
	// g.dispose();
	// return scaledBI;
	// }

	public void CopyVoucherTransToCartCheck(HttpServletRequest request,
			String emp_id, String cart_session_id, String voucher_id,
			String voucher_vouchertype_id, String comp_id) throws SQLException {
		String msg = "";
		// SOP("voucher_vouchertype_id===" + voucher_vouchertype_id);
		// SOP("cart_session_id===" + cart_session_id);
		String StrSql = "";
		String vouchertrans_voucher_id = "0";
		String vouchertrans_multivoucher_id = "0";
		String vouchertrans_customer_id = "0";
		String vouchertrans_location_id = "0";
		String vouchertrans_item_id = "0";
		String vouchertrans_discount = "0.00", vouchertrans_discount_perc = "0.00";
		String vouchertrans_tax = "0.00";
		String vouchertrans_rowcount = "0";
		String vouchertrans_option_id = "0";
		String vouchertrans_option_group = "";
		String vouchertrans_item_batch_id = "0";
		String vouchertrans_item_serial = "", vouchertrans_tax_id = "0";
		double vouchertrans_qty = 0.00;
		double vouchertrans_truckspace = 0.00;
		double vouchertrans_price = 0.00;
		double vouchertrans_netprice = 0.00;
		double vouchertrans_unit_cost = 0.00;
		double vouchertrans_amount = 0.00;
		double vouchertrans_discountamount = 0.00;
		double vouchertrans_taxamount = 0.00;
		String vouchertrans_supplier_code = "";
		double vouchertrans_alt_qty = 0.00;
		String vouchertrans_alt_uom_id = "0";
		String vouchertrans_delivery_date = "";
		String vouchertrans_dc = "", vouchertrans_convfactor = "1";
		String uom_ratio = "0";
		String uom_parent_id = "0";
		double mul_ratio = 0.00;
		double cart_uom_ratio = 0.00;
		String ratio = "0.00";
		Connection conntx = null;
		Statement stmttx = null;
		try {
			conntx = connectDB();
			conntx.setAutoCommit(false);
			stmttx = conntx.createStatement();

			StrSql = "DELETE FROM " + compdb(comp_id) + "axela_acc_cart"
					+ " WHERE 1=1"
					+ " AND cart_vouchertype_id = " + voucher_vouchertype_id + ""
					+ " AND cart_emp_id = " + emp_id + ""
					+ " AND cart_session_id = " + cart_session_id
					+ " AND SUBSTR(cart_time,1,8) < SUBSTR(" + toShortDate(kknow()) + ",1,8)";
			stmttx.addBatch(StrSql);

			StrSql = "SELECT vouchertrans_multivoucher_id, vouchertrans_customer_id,"
					+ " vouchertrans_location_id, vouchertrans_item_id,"
					+ " vouchertrans_discount, vouchertrans_discount_perc,"
					+ " vouchertrans_tax, vouchertrans_tax_id,"
					+ " vouchertrans_rowcount, vouchertrans_option_id,"
					+ " vouchertrans_option_group, vouchertrans_item_batch_id,"
					+ " vouchertrans_item_serial, vouchertrans_qty,"
					+ " vouchertrans_truckspace, vouchertrans_price,"
					+ " vouchertrans_netprice," + " vouchertrans_unit_cost,"
					+ " vouchertrans_amount," + " vouchertrans_discountamount,"
					+ " vouchertrans_taxamount,"
					+ " vouchertrans_supplier_code," + " vouchertrans_alt_qty,"
					+ " vouchertrans_alt_uom_id,"
					+ " COALESCE(@uom_ratio := (SELECT uom_ratio"
					+ " FROM " + compdb(comp_id) + "axela_inventory_uom"
					+ " WHERE uom_id = vouchertrans_alt_uom_id), 0) AS uom_ratio,"
					+ " COALESCE(@uom_parent_id := (SELECT uom_parent_id"
					+ " FROM " + compdb(comp_id) + "axela_inventory_uom"
					+ " WHERE uom_id = vouchertrans_alt_uom_id), 0) AS uom_parent_id,"
					+ " vouchertrans_delivery_date,"
					+ " " + toLongDate(kknow()) + ","
					+ " vouchertrans_dc"
					+ " FROM " + " " + compdb(comp_id) + "axela_acc_voucher_trans"
					+ " INNER JOIN " + " " + compdb(comp_id) + "axela_acc_voucher ON voucher_id = vouchertrans_voucher_id"
					+ " WHERE 1=1 "
					+ " AND (vouchertrans_item_id !=0 || (vouchertrans_tax_id !=0 && vouchertrans_item_id = 0))"
					+ " AND vouchertrans_voucher_id = " + voucher_id + "";
			// SOP("StrSql==vouchertrans123==" + StrSql);
			CachedRowSet crs1 = processQuery(StrSql, 0);
			while (crs1.next()) {
				vouchertrans_multivoucher_id = crs1.getString("vouchertrans_multivoucher_id");
				vouchertrans_customer_id = crs1.getString("vouchertrans_customer_id");
				vouchertrans_location_id = crs1.getString("vouchertrans_location_id");
				vouchertrans_item_id = crs1.getString("vouchertrans_item_id");
				vouchertrans_discount = crs1.getString("vouchertrans_discount");
				vouchertrans_discount_perc = crs1.getString("vouchertrans_discount_perc");
				vouchertrans_tax = crs1.getString("vouchertrans_tax");
				vouchertrans_tax_id = crs1.getString("vouchertrans_tax_id");
				vouchertrans_rowcount = crs1.getString("vouchertrans_rowcount");
				vouchertrans_option_id = crs1.getString("vouchertrans_option_id");
				vouchertrans_option_group = crs1.getString("vouchertrans_option_group");
				vouchertrans_item_batch_id = crs1.getString("vouchertrans_item_batch_id");
				vouchertrans_item_serial = crs1.getString("vouchertrans_item_serial");
				vouchertrans_qty = crs1.getDouble("vouchertrans_qty");
				vouchertrans_truckspace = crs1.getDouble("vouchertrans_truckspace");
				vouchertrans_price = crs1.getDouble("vouchertrans_price");
				vouchertrans_netprice = crs1.getDouble("vouchertrans_netprice");
				vouchertrans_unit_cost = crs1.getDouble("vouchertrans_unit_cost");
				vouchertrans_amount = crs1.getDouble("vouchertrans_amount");
				vouchertrans_discountamount = crs1.getDouble("vouchertrans_discountamount");
				vouchertrans_taxamount = crs1.getDouble("vouchertrans_taxamount");
				vouchertrans_supplier_code = crs1.getString("vouchertrans_supplier_code");
				vouchertrans_alt_qty = crs1.getDouble("vouchertrans_alt_qty");
				vouchertrans_alt_uom_id = crs1.getString("vouchertrans_alt_uom_id");
				uom_ratio = crs1.getString("uom_ratio");
				uom_parent_id = crs1.getString("uom_parent_id");
				vouchertrans_delivery_date = crs1.getString("vouchertrans_delivery_date");
				vouchertrans_dc = crs1.getString("vouchertrans_dc");
				if (!vouchertrans_rowcount.equals("0") && vouchertrans_option_id.equals("0")) {
					if (!uom_ratio.equals("")) {
						cart_uom_ratio = Double.parseDouble(uom_ratio);
					}
					mul_ratio = 0.00;
					StrSql = "SELECT COALESCE(@ratio:=(IF (vouchertrans_discount = 0 && vouchertrans_tax = 0,"
							+ " (COALESCE (" + vouchertrans_alt_qty + ",0)"// From voucher qty
							+ " -";
					// purchase...
					// Uom_ratio or uom_parent_id we are taking only for
					// purchase side transaction...
					// we are converting eg Boxes(uom_id) To Pcs(uom_parent_id)
					// Eg: box*10(1Box=10Pcs) If 10 Box*10 means 10Boxes =
					// 100pcs
					// while taking mul_ratio divide (To voucher Qty) by
					// (uom_ratio)
					if (voucher_vouchertype_id.equals("20")) { // TO
																// voucher
																// GRN
																// qty
						// SOP("voucher_vouchertype_id=grn=="+voucher_vouchertype_id);
						StrSql += " (COALESCE ((SELECT sum(vouchertrans_alt_qty)"
								+ " FROM " + compdb(comp_id) + "axela_acc_voucher_trans"
								+ " INNER JOIN " + compdb(comp_id) + "axela_acc_voucher git ON git.voucher_id = vouchertrans_voucher_id"
								+ " WHERE git.voucher_po_id  = " + voucher_id + ""
								+ " AND vouchertrans_item_id = " + vouchertrans_item_id + ""
								+ " AND vouchertrans_rowcount = " + vouchertrans_rowcount + ""
								+ " AND vouchertrans_option_id = " + vouchertrans_option_id + ""
								+ " AND voucher_vouchertype_id = " + voucher_vouchertype_id + "" + " ),0)/ (" + cart_uom_ratio + ") )";

					} else if (voucher_vouchertype_id.equals("21")) { // To purchase invoice QTY.
						StrSql += " (COALESCE ((SELECT sum(vouchertrans_alt_qty)"
								+ " FROM " + compdb(comp_id) + "axela_acc_voucher_trans"
								+ " INNER JOIN " + compdb(comp_id) + "axela_acc_voucher grn ON grn.voucher_id = vouchertrans_voucher_id"
								+ " WHERE grn.voucher_grn_id  = " + voucher_id + ""
								+ " AND vouchertrans_item_id = " + vouchertrans_item_id + ""
								+ " AND vouchertrans_rowcount = " + vouchertrans_rowcount + ""
								+ " AND vouchertrans_option_id = " + vouchertrans_option_id + ""
								+ " AND voucher_vouchertype_id = " + voucher_vouchertype_id + "" + " ),0) / (" + cart_uom_ratio + "))";

					} else if (voucher_vouchertype_id.equals("24")) { // TO voucher Purchase Return qty
						StrSql += " (COALESCE ((SELECT sum(vouchertrans_alt_qty)"
								+ " FROM " + compdb(comp_id) + "axela_acc_voucher_trans"
								+ " INNER JOIN " + compdb(comp_id) + "axela_acc_voucher grn_return ON grn_return.voucher_id = vouchertrans_voucher_id"
								+ " WHERE grn_return.voucher_grn_return_id  = " + voucher_id + ""
								+ " AND vouchertrans_item_id = " + vouchertrans_item_id + ""
								+ " AND vouchertrans_rowcount = " + vouchertrans_rowcount + ""
								+ " AND vouchertrans_option_id = " + vouchertrans_option_id + ""
								+ " AND voucher_vouchertype_id = " + voucher_vouchertype_id + "" + " ),0) / (" + cart_uom_ratio + "))";
					} else if (voucher_vouchertype_id.equals("6")) { // To sales invoice Qty.
						StrSql += " COALESCE ((SELECT sum(vouchertrans_alt_qty)"
								+ " FROM " + compdb(comp_id) + "axela_acc_voucher_trans"
								+ " INNER JOIN " + compdb(comp_id) + "axela_acc_voucher delnote ON delnote.voucher_id = vouchertrans_voucher_id"
								+ " WHERE delnote.voucher_delnote_id  = " + voucher_id + ""
								+ " AND vouchertrans_item_id = " + vouchertrans_item_id + ""
								+ " AND vouchertrans_rowcount = " + vouchertrans_rowcount + ""
								+ " AND vouchertrans_option_id = " + vouchertrans_option_id + ""
								+ " AND voucher_vouchertype_id = " + voucher_vouchertype_id + "" + " ),0)";

					} else if (voucher_vouchertype_id.equals("23")) { // To Voucher SR qty.
						StrSql += " COALESCE ((SELECT sum(vouchertrans_alt_qty)"
								+ " FROM " + compdb(comp_id) + "axela_acc_voucher_trans"
								+ " INNER JOIN " + compdb(comp_id) + "axela_acc_voucher dcr ON dcr.voucher_id = vouchertrans_voucher_id"
								+ " WHERE dcr.voucher_dcr_id  = " + voucher_id + ""
								+ " AND vouchertrans_item_id = " + vouchertrans_item_id + ""
								+ " AND vouchertrans_rowcount = " + vouchertrans_rowcount + ""
								+ " AND vouchertrans_option_id = " + vouchertrans_option_id + ""
								+ " AND voucher_vouchertype_id = " + voucher_vouchertype_id + "" + " ),0)";// TO voucher qty
					}
					StrSql += " ) ,vouchertrans_alt_qty)),0)"
							+ " /"
							+ " COALESCE((IF (vouchertrans_discount = 0 && vouchertrans_tax = 0,"
							+ " COALESCE (" + vouchertrans_alt_qty + ",0)" + " , vouchertrans_alt_qty)), 0.000000)"
							+ " FROM " + " " + compdb(comp_id) + "axela_acc_voucher_trans"
							+ " INNER JOIN " + compdb(comp_id) + "axela_acc_voucher ON voucher_id = vouchertrans_voucher_id"
							+ " WHERE vouchertrans_item_id != 0"
							+ " AND vouchertrans_voucher_id = " + voucher_id + ""
							// + " AND voucher_vouchertype_id = " + voucher_vouchertype_id + ""
							+ " LIMIT 1";
					// SOP("StrSql====ratio===" + StrSql);
					ratio = ExecuteQuery(StrSql);
					if (!ratio.equals("0.0000000000")) {
						mul_ratio = Double.parseDouble(ratio);
					}
					if (mul_ratio > 0.0) {
						StrSql = "INSERT INTO " + compdb(comp_id) + "axela_acc_cart"
								+ " (cart_voucher_id,"
								+ " cart_vouchertype_id,"
								+ " cart_multivoucher_id,"
								+ " cart_customer_id," + " cart_emp_id,"
								+ " cart_session_id," + " cart_location_id,"
								+ " cart_item_id," + " cart_discount,"
								+ " cart_discount_perc," + " cart_tax,"
								+ " cart_tax_id," + " cart_rowcount,"
								+ " cart_option_id," + " cart_option_group,"
								+ " cart_item_serial," + " cart_item_batch_id,"
								+ " cart_price," + " cart_qty,"
								+ " cart_truckspace," + " cart_netprice,"
								+ " cart_amount," + " cart_discountamount,"
								+ " cart_taxamount," + " cart_unit_cost,"
								+ " cart_alt_qty," + " cart_alt_uom_id,"
								+ " cart_convfactor," + " cart_time,"
								+ " cart_dc)" + " VALUES" + " ( 0 ," + " "
								+ voucher_vouchertype_id + "," + " "
								+ vouchertrans_multivoucher_id + "," + " "
								+ vouchertrans_customer_id + "," + " " + emp_id
								+ "," + " " + cart_session_id + "," + " '"
								+ vouchertrans_location_id + "'," + " "
								+ vouchertrans_item_id + "," + " '0',"
								+ " 0.0," + " '0'," + " " + vouchertrans_tax_id
								+ "," + " " + vouchertrans_rowcount + "," + " "
								+ vouchertrans_option_id + "," + " ''," + " '"
								+ CNumeric(vouchertrans_item_serial) + "',"
								+ " " + vouchertrans_item_batch_id + ",";
						// if (ratio.equals("0.000000")) {
						// StrSql += " " + (mul_ratio * vouchertrans_price)
						// + ",";
						// } else {
						StrSql += " " + vouchertrans_price + ",";
						// }
						// if ((vouchertrans_qty + "").equals(mul_ratio + "")) {
						// SOP("comming");
						// mul_ratio = 1.0;
						// }
						StrSql += " " + (mul_ratio * vouchertrans_qty) + ","
								+ " " + (mul_ratio * vouchertrans_truckspace)
								+ "," + " "
								+ (mul_ratio * vouchertrans_netprice) + ","
								+ " " + (mul_ratio * vouchertrans_amount) + ","
								+ " "
								+ (mul_ratio * vouchertrans_discountamount)
								+ "," + " "
								+ (mul_ratio * vouchertrans_taxamount) + ","
								+ " " + vouchertrans_unit_cost + ",";

						if (voucher_vouchertype_id.equals("10")) {
							// SOP("vouchertrans_alt_qty==="+vouchertrans_alt_qty);
							// SOP("mul_ratio==="+mul_ratio);
							StrSql += " "
									+ (mul_ratio * vouchertrans_alt_qty * cart_uom_ratio)
									+ ",";
							if (!CNumeric(uom_parent_id).equals("0")) {
								StrSql += " " + uom_parent_id + ",";
							} else {
								StrSql += " " + vouchertrans_alt_uom_id + ",";
							}
						} else {
							StrSql += " " + (mul_ratio * vouchertrans_alt_qty)
									+ "," + " " + vouchertrans_alt_uom_id + ",";
						}
						StrSql += vouchertrans_convfactor + "," + " "
								+ toLongDate(kknow()) + "," + " '"
								+ vouchertrans_dc + "'" + " )";

						// SOP("StrSql==cart main item="
						// +StrSqlBreaker(StrSql));
						// StrSql=compdb(StrSql);
						stmttx.addBatch(StrSql);
					}
				}

				// SOP("mul_ratio==="+mul_ratio);
				// SOP("vouchertrans_amount==="+vouchertrans_amount);
				if (!vouchertrans_rowcount.equals("0")
						&& !vouchertrans_option_id.equals("0")) {
					if (mul_ratio > 0.0) {
						StrSql = "INSERT INTO " + compdb(comp_id)
								+ "axela_acc_cart" + " (cart_voucher_id,"
								+ " cart_vouchertype_id,"
								+ " cart_multivoucher_id,"
								+ " cart_customer_id," + " cart_emp_id,"
								+ " cart_session_id," + " cart_location_id,"
								+ " cart_item_id," + " cart_discount,"
								+ " cart_discount_perc," + " cart_tax,"
								+ " cart_tax_id," + " cart_rowcount,"
								+ " cart_option_id," + " cart_option_group,"
								+ " cart_item_serial," + " cart_item_batch_id,"
								+ " cart_price," + " cart_qty,"
								+ " cart_truckspace," + " cart_netprice,"
								+ " cart_amount," + " cart_unit_cost,"
								+ " cart_alt_qty," + " cart_alt_uom_id,"
								+ " cart_convfactor," + " cart_time,"
								+ " cart_dc)" + " VALUES" + " ( 0," + " "
								+ voucher_vouchertype_id + "," + " "
								+ vouchertrans_multivoucher_id + "," + " "
								+ vouchertrans_customer_id + "," + " " + emp_id
								+ "," + " " + cart_session_id + "," + " '"
								+ vouchertrans_location_id + "'," + " "
								+ vouchertrans_item_id + "," + " '"
								+ vouchertrans_discount + "'," + " "
								+ vouchertrans_discount_perc + "," + " '"
								+ vouchertrans_tax + "'," + " "
								+ vouchertrans_tax_id + " ," + " "
								+ vouchertrans_rowcount + "," + " "
								+ vouchertrans_option_id + "," + " '',"
								+ " ''," + " 0,";
						StrSql += " " + vouchertrans_price + ",";
						StrSql += " 0.00," + " 0.00," + " 0.00," + " "
								+ (mul_ratio * vouchertrans_amount) + ","
								+ " 0.00," + " 0.00," + " 0," + " 1," + " "
								+ toLongDate(kknow()) + "," + " '"
								+ vouchertrans_dc + "'" + " )";
						// SOP("StrSql==disc tax=" + StrSqlBreaker(StrSql));
						stmttx.addBatch(StrSql);
					}
				}
				// bill sundry tax ...
				if (vouchertrans_rowcount.equals("0")
						&& vouchertrans_option_id.equals("0")
						&& !vouchertrans_tax_id.equals("0")) {
					if (mul_ratio > 0.0) {
						StrSql = "INSERT INTO " + compdb(comp_id)
								+ "axela_acc_cart" + " (cart_customer_id,"
								+ " cart_vouchertype_id," + " cart_emp_id,"
								+ " cart_session_id," + " cart_location_id,"
								+ " cart_item_id," + " cart_discount,"
								+ " cart_discount_perc," + " cart_tax,"
								+ " cart_tax_id," + " cart_rowcount,"
								+ " cart_option_id," + " cart_option_group,"
								+ " cart_item_serial," + " cart_item_batch_id,"
								+ " cart_price," + " cart_qty,"
								+ " cart_truckspace," + " cart_netprice,"
								+ " cart_amount," + " cart_unit_cost,"
								+ " cart_alt_qty," + " cart_alt_uom_id,"
								+ " cart_convfactor," + " cart_time,"
								+ " cart_dc)" + " VALUES" + " ("
								+ vouchertrans_customer_id + "," + " "
								+ voucher_vouchertype_id + "," + " " + emp_id
								+ "," + " " + cart_session_id + "," + " '"
								+ vouchertrans_location_id + "'," + " "
								+ vouchertrans_item_id + "," + " '"
								+ vouchertrans_discount + "'," + " 0.0," + " '"
								+ vouchertrans_tax + "'," + " "
								+ vouchertrans_tax_id + " ," + " "
								+ vouchertrans_rowcount + "," + " "
								+ vouchertrans_option_id + "," + " '',"
								+ " ''," + " 0,";
						StrSql += " " + vouchertrans_price + ",";
						StrSql += " 0.00," + " 0.00,"
								+ " 0.00,"
								+ " "
								// + (mul_ratio * vouchertrans_amount)
								+ (vouchertrans_amount) + "," + " 0.00,"
								+ " 0.00," + " 0," + " 1," + " "
								+ toLongDate(kknow()) + "," + " '"
								+ vouchertrans_dc + "'" + " )";
						// SOP("StrSql==bill sundry tax=" +
						// StrSqlBreaker(StrSql));
						stmttx.addBatch(StrSql);
					}
				}

			}
			stmttx.executeBatch();
			conntx.commit();
			crs1.close();
		} catch (Exception e) {
			if (conntx.isClosed()) {
				SOPError("connection is closed...");
			}
			if (!conntx.isClosed() && conntx != null) {
				conntx.rollback();
				SOPError("connection rollback...");
			}
			msg = "<br>Transaction Error!";
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ e);
		} finally {
			conntx.setAutoCommit(true);
			if (stmttx != null && !stmttx.isClosed()) {
				stmttx.close();
			}
			if (conntx != null && !conntx.isClosed()) {
				conntx.close();
			}
		}
	}
	public String ReturnBranchids(String principalid, String comp_id) {
		StringBuilder sb = new StringBuilder();
		try {
			if (!principalid.equals("")) {
				String StrSql = "SELECT branch_id " + " FROM "
						+ compdb(comp_id) + "axela_branch"
						+ " WHERE branch_brand_id in (" + principalid + ")"
						+ " AND branch_active = 1" + " ORDER BY branch_id ";
				CachedRowSet crs = processQuery(StrSql, 0);
				while (crs.next()) {
					sb.append(crs.getString("branch_id"));
					sb.append(",");
				}
				crs.close();
			}
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
			return "";
		}
		if (!sb.toString().equals("")) {
			return sb.toString().substring(0, sb.toString().lastIndexOf(","));
		} else {
			return "";
		}
	}

	// To update unit cost
	public void CalUnitcost(String comp_id, String item_id, String location_id) {
		try {

			String StrSql = "UPDATE "
					+ compdb(comp_id)
					+ "axela_inventory_stock\n"
					+ " INNER JOIN "
					+ compdb(comp_id)
					+ "axela_inventory_item on item_id = stock_item_id\n"
					+ " INNER JOIN "
					+ compdb(comp_id)
					+ "axela_acc_voucher_trans on vouchertrans_location_id = stock_location_id \n"
					// + ", " + compdb(comp_id) + "axela_config, " +
					// compdb(comp_id) + "axela_comp "
					+ " AND vouchertrans_item_id = stock_item_id\n"
					+ " SET \n"
					+ " stock_unit_cost = @unitcost:=if(1 = 1,\n"
					+ " coalesce((\n"
					+ " select vouchertrans_unit_cost\n"
					+ " from "
					+ compdb(comp_id)
					+ "axela_acc_voucher_trans\n"
					+ " INNER JOIN "
					+ compdb(comp_id)
					+ "axela_acc_voucher on voucher_id = vouchertrans_voucher_id \n"
					+ " INNER JOIN  "
					+ compdb(comp_id)
					+ "axela_acc_voucher_type on vouchertype_id = voucher_vouchertype_id \n"
					+ " where vouchertrans_item_id = stock_item_id and voucher_active = 1 and voucher_vouchertype_id = 108 and vouchertrans_discount =0 \n"
					+ " and vouchertrans_tax = 0 AND vouchertrans_item_id !=0\n"
					+ " group by vouchertrans_id\n"
					+ " order by voucher_date desc, vouchertrans_id desc  limit 1 ), 0), 0)\n"
					+ " stock_onhandvalue = (@unitcost*stock_current_qty)"
					+ " where item_active = 1 and item_stock = 1 ";

			if (!CNumeric(item_id).equals("0")) {
				StrSql += " AND stock_item_id = " + item_id + "";
			}

			if (!CNumeric(location_id).equals("0")) {
				StrSql += " AND stock_location_id = " + location_id + "";
			}
			// SOP("StrSql===calcunitcost===" + StrSqlBreaker(StrSql));
			updateQuery(StrSql);
			// SOP("update");
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
		}
	}

	public void CalCurrentStockVoucher(String comp_id, String voucher_id) {
		String item_id = "";
		String location_id = "0";
		String StrSql = "SELECT DISTINCT vouchertrans_location_id, vouchertrans_item_id"
				+ " FROM "
				+ compdb(comp_id)
				+ "axela_acc_voucher_trans"
				+ " INNER JOIN "
				+ compdb(comp_id)
				+ "axela_acc_voucher ON voucher_id  = vouchertrans_voucher_id"
				+ " WHERE vouchertrans_voucher_id = "
				+ voucher_id
				+ " AND vouchertrans_discount = 0"
				+ " AND vouchertrans_tax = 0"
				+ " AND vouchertrans_rowcount != 0";
		// SOP("StrSql===CalCurrentStockVoucher=="+StrSqlBreaker(StrSql));
		ResultSet rs = processQuery(StrSql);
		try {
			if (rs.isBeforeFirst()) {
				item_id += " AND (";
				while (rs.next()) {
					location_id = rs.getString("vouchertrans_location_id");
					item_id += " OR stock_item_id = "
							+ rs.getString("vouchertrans_item_id");
				}
				item_id += " }";
			}
			rs.close();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
		}

		CalCurrentStock(comp_id, item_id, location_id);
	}

	public String GetCurrentStock(String comp_id, String item_id,
			String location_id, String toDate) {
		String strToDate = "";
		if (!toDate.equals("")) {
			strToDate = " strToDate < " + toDate + "";
		}

		String StrSql = "SELECT stock_current_qty = ((SELECT COALESCE(SUM(grn_qty), 0)" // GRN
																						// Items
				+ " FROM "
				+ compdb(comp_id)
				+ "axela_inventory_grn"
				+ " INNER JOIN "
				+ compdb(comp_id)
				+ "axela_inventory_po ON po_id = grn_po_id"
				+ " WHERE grn_item_id = stock_item_id"
				+ strToDate.replace("strToDate", "grn_delivery_date")
				+ ""
				+ " AND grn_location_id = stock_location_id"
				+ " AND po_active = 1)"
				// Purchase Returns Items
				+ " -"
				+ " (SELECT COALESCE(SUM(return_qty), 0)"
				+ " FROM "
				+ compdb(comp_id)
				+ "axela_inventory_purchasereturn"
				+ " INNER JOIN "
				+ compdb(comp_id)
				+ "axela_inventory_po ON po_id = return_po_id"
				+ " WHERE return_item_id = stock_item_id"
				+ strToDate.replace("strToDate", "return_date")
				+ ""
				+ " AND return_location_id = stock_location_id"
				+ " AND po_active = 1)"
				// Service Job Card Items
				+ " -"
				+ " (SELECT COALESCE(SUM(jcitem_qty), 0)"
				+ " FROM "
				+ compdb(comp_id)
				+ "axela_service_jc_item"
				+ " INNER JOIN "
				+ compdb(comp_id)
				+ "axela_service_jc ON jc_id = jcitem_jc_id"
				+ " WHERE jcitem_item_id = stock_item_id"
				+ strToDate.replace("strToDate", "jc_time_out")
				+ ""
				+ " AND jc_location_id = stock_location_id"
				+ " AND jc_active = 1)"
				// Invoice Items
				+ " -"
				+ " IF(config_invoice_reduce_current_stock = 1,"
				+ " (SELECT COALESCE(SUM(invoiceitem_qty), 0)"
				+ " FROM "
				+ compdb(comp_id)
				+ "axela_invoice_item"
				+ " INNER JOIN "
				+ compdb(comp_id)
				+ "axela_invoice ON invoice_id = invoiceitem_invoice_id"
				+ " WHERE invoiceitem_item_id = stock_item_id"
				+ strToDate.replace("strToDate", "invoice_date")
				+ ""
				+ " AND invoice_location_id = stock_location_id"
				+ " AND invoice_active = 1), 0)"
				// Dealer Job Card Items
				+ " -"
				+ " (SELECT COALESCE(SUM(jcitem_qty), 0)"
				+ " FROM "
				+ compdb(comp_id)
				+ "axela_dealer_jobcard_item"
				+ " INNER JOIN "
				+ compdb(comp_id)
				+ "axela_dealer_jobcard ON jobcard_id = jcitem_jobcard_id"
				+ " WHERE jcitem_item_id = stock_item_id"
				+ strToDate.replace("strToDate", "invoice_date")
				+ ""
				+ " AND jobcard_location_id = stock_location_id"
				+ " AND jobcard_active = 1)"
				// Production Job Card BOM Items
				+ " +"
				+ " (SELECT COALESCE(SUM(jobcarditem_qty), 0)"
				+ " FROM "
				+ compdb(comp_id)
				+ "axela_prod_jobcard_item"
				+ " INNER JOIN "
				+ compdb(comp_id)
				+ "axela_prod_jobcard ON jobcard_id = jobcarditem_jobcard_id"
				// + " AND jobcard_actual_starttime != ''"
				// + " AND jobcard_actual_endtime != ''"
				+ " WHERE jobcarditem_item_id = stock_item_id"
				+ strToDate.replace("strToDate", "jobcard_starttime")
				+ ""
				+ " AND jobcard_location_id = stock_location_id"
				+ " AND jobcard_active = 1)"
				// Production Job Card Main Item
				+ " +"
				+ " (SELECT COALESCE(SUM(jobcard_qty), 0)"
				+ " FROM "
				+ compdb(comp_id)
				+ "axela_prod_jobcard"
				+ " WHERE jobcard_item_id = stock_item_id"
				+ strToDate.replace("strToDate", "jobcard_starttime")
				+ ""
				+ " AND jobcard_location_id = stock_location_id"
				+ " AND jobcard_actual_starttime != ''"
				+ " AND jobcard_actual_endtime != ''"
				+ " AND jobcard_active = 1)"
				// Delivery Note Items
				+ " -"
				+ " (SELECT COALESCE(SUM(dlnote_total_qty), 0)"
				+ " FROM "
				+ compdb(comp_id)
				+ "axela_inventory_deliverynote"
				+ " INNER JOIN "
				+ compdb(comp_id)
				+ "axela_inventory_deliverynote_items ON dlitem_dlnote_id = dlnote_id"
				+ " INNER JOIN "
				+ compdb(comp_id)
				+ "axela_sales_so ON so_id = dlnote_so_id"
				+ " WHERE dlitem_item_id = stock_item_id"
				+ strToDate.replace("strToDate", "dlnote_time")
				+ ""
				+ " AND dlitem_location_id = stock_location_id"
				+ " AND so_active = 1)"
				// Sales Return Items
				+ " +"
				+ " (SELECT COALESCE(SUM(return_qty), 0)"
				+ " FROM "
				+ compdb(comp_id)
				+ "axela_inventory_salesreturn"
				+ " INNER JOIN "
				+ compdb(comp_id)
				+ "axela_sales_so ON so_id = return_so_id"
				+ " WHERE return_item_id = stock_item_id"
				+ strToDate.replace("strToDate", "return_date")
				+ ""
				+ " AND return_location_id = stock_location_id"
				+ " AND so_active = 1)"
				// Stock Dispatch items
				+ " -"
				+ " (SELECT COALESCE(SUM(dispatchtrans_qty), 0)"
				+ " FROM "
				+ compdb(comp_id)
				+ "axela_inventory_dispatch"
				+ " INNER JOIN "
				+ compdb(comp_id)
				+ "axela_inventory_dispatch_trans ON dispatchtrans_dispatch_id = dispatch_id"
				+ " INNER JOIN "
				+ compdb(comp_id)
				+ "axela_inventory_item ON item_id = dispatchtrans_item_id"
				+ " WHERE dispatchtrans_item_id = stock_item_id"
				+ strToDate.replace("strToDate", "dispatch_dispatch_time")
				+ ""
				+ " AND dispatch_source_location_id = stock_location_id)"
				// Stock Receipt items
				+ " +"
				+ " (SELECT COALESCE(SUM(receipttrans_qty), 0)"
				+ " FROM "
				+ compdb(comp_id)
				+ "axela_inventory_receipt"
				+ " INNER JOIN "
				+ compdb(comp_id)
				+ "axela_inventory_receipt_trans ON receipttrans_receipt_id = dispatchreceipt_id"
				+ " INNER JOIN "
				+ compdb(comp_id)
				+ "axela_inventory_item ON item_id = receipttrans_item_id"
				+ " WHERE receipttrans_item_id = stock_item_id"
				+ strToDate
						.replace("strToDate", "dispatchreceipt_receipt_time")
				+ ""
				+ " AND dispatchreceipt_location_id = stock_location_id)"
				// OfferBOM Qty for Bomtype REDUCE
				+ " -"
				+ " (SELECT COALESCE(SUM(offeritem_qty), 0)"
				+ " FROM "
				+ compdb(comp_id)
				+ "axela_inventory_offer_items"
				+ " INNER JOIN "
				+ compdb(comp_id)
				+ "axela_inventory_offer ON offer_id = offeritem_offer_id"
				+ " WHERE offeritem_add = 2"
				+ " AND offeritem_item_id = stock_item_id"
				+ strToDate.replace("strToDate", "offer_date")
				+ ""
				+ " AND offer_location_id = stock_location_id)"
				// OfferBOM Qty for Bomtype ADD
				+ " +"
				+ " (SELECT COALESCE(SUM(offeritem_qty), 0)"
				+ " FROM "
				+ compdb(comp_id)
				+ "axela_inventory_offer_items"
				+ " INNER JOIN "
				+ compdb(comp_id)
				+ "axela_inventory_offer ON offer_id = offeritem_offer_id"
				+ " WHERE offeritem_add = 1"
				+ " AND offeritem_item_id = stock_item_id"
				+ strToDate.replace("strToDate", "offer_date")
				+ ""
				+ " AND offer_location_id = stock_location_id)"
				// Offer Main Item Qty
				+ " +"
				+ " (SELECT COALESCE(SUM(offer_qty), 0)"
				+ " FROM "
				+ compdb(comp_id)
				+ "axela_inventory_offer"
				+ " WHERE offer_item_id = stock_item_id"
				+ strToDate.replace("strToDate", "offer_date")
				+ ""
				+ " AND offer_location_id = stock_location_id)"
				// Adjustment Qty
				+ " +"
				+ " (SELECT COALESCE(SUM(adj_qty), 0)"
				+ " FROM "
				+ compdb(comp_id)
				+ "axela_inventory_adj"
				+ " WHERE adj_item_id = stock_item_id"
				+ strToDate.replace("strToDate", "adj_entry_date")
				+ ""
				+ " AND adj_location_id = stock_location_id))"
				+ " FROM "
				+ compdb(comp_id)
				+ "axela_inventory_stock"
				+ " INNER JOIN "
				+ compdb(comp_id)
				+ "axela_inventory_item ON item_id = stock_item_id,"
				+ " "
				+ compdb(comp_id)
				+ "axela_config,"
				+ " "
				+ compdb(comp_id)
				+ "axela_comp"
				+ " WHERE item_active = 1"
				+ " AND item_stock = 1";
		if (!item_id.equals("0")) {
			StrSql += " AND stock_item_id = " + item_id + "";
		}

		if (!location_id.equals("0")) {
			StrSql += " AND stock_location_id = " + location_id + "";
		}
		return ExecuteQuery(StrSql);
	}

	public String AccessDenied() {
		String msg = "../portal/error.jsp?msg=Access denied. Please contact system administrator!";
		return msg;
	}

	/*
	 * Added on 8th April 2013
	 */

	// ******************** Due time calculation *********************
	public String DueTime(String report_time, String duehours,
			double starttime, double endtime, String Sun, String Mon,
			String Tue, String Wed, String Thu, String Fri, String Sat,
			ArrayList public_holidate) throws ParseException {
		Date mydate = null;
		int duehrs_in_mins = 0;
		int days_toadd = 0;
		int mins_toadd = 0;
		// SOP("public_holidate's = " + public_holidate);
		// SOP("report_time = " + report_time);
		// SOP("duehours = " + duehours);
		// ********************************************************************************************************************
		// converting duehrs to minutes
		SOP("111");
		if (duehours.contains(":")) {
			duehrs_in_mins = GetMinsFromTime(duehours);
		} else {
			// SOP("duehours in connect===" + Integer.parseInt(duehours));
			// SOP("coming in connect...");
			int duehours1 = (int) Double.parseDouble(duehours);
			// SOP("iiiiiiiiii+++++" + i);
			duehrs_in_mins = duehours1 * 60;
			// SOP("coming in connect...1");
		}
		SOP("222");
		// SOP("duehrs_in_mins = " + duehrs_in_mins);
		mins_toadd = duehrs_in_mins;
		// ********************************************************************************************************************
		// calculating login time

		String str_starttime = Double.toString(starttime);

		String split_start_time[] = str_starttime.split("\\.");
		SOP("333");
		split_start_time[0] = doublenum(Integer.parseInt(split_start_time[0]));
		if (split_start_time[1].length() < 2) {
			split_start_time[1] = split_start_time[1] + "0";
		}
		SOP("444");
		// calculating logoff time
		String str_endtime = Double.toString(endtime);
		String split_end_time[] = str_endtime.split("\\.");
		SOP("555");
		split_end_time[0] = doublenum(Integer.parseInt(split_end_time[0]));
		if (split_end_time[1].length() < 2) {
			split_end_time[1] = split_end_time[1] + "0";
		}
		// ********************************************************************************************************************
		Date added_date = stringToDate(report_time);
		SOP("666");
		// if report time is b4 start time

		SOP("report_time==" + report_time);
		SOP("report_time=11, 13=" + report_time.substring(11, 13));
		SOP("report_time=14, 16=" + report_time.substring(14, 16));

		SOP("report_time==111" + split_start_time[0] + "." + split_start_time[1]);

		if (Double.parseDouble(report_time.substring(11, 13) + "." + report_time.substring(14, 16)) < (Double.parseDouble(split_start_time[0] + "." + split_start_time[1]))) {
			// SOP("Case 1 ********* ");
			SOP("777");
			report_time = report_time.substring(0, 8) + split_start_time[0]
					+ split_start_time[1] + "00";
			mydate = stringToDate(report_time);
			if (!CheckHolidate(mydate, public_holidate, Sun, Mon, Tue, Wed,
					Thu, Fri, Sat).equals("0")) {
				while (CheckHolidate(mydate, public_holidate, Sun, Mon, Tue,
						Wed, Thu, Fri, Sat).equals("1")) {
					mydate = addHoursDate(mydate, 1, 0, 0);
				}
				SOP("888");
				report_time = toLongDate(added_date);
				report_time = report_time.substring(0, 8) + split_start_time[0]
						+ split_start_time[1] + "00";
				added_date = stringToDate(report_time);
			}
		} // if report time is after end time

		else if (Double.parseDouble(report_time.substring(11, 13) + "."
				+ report_time.substring(14, 16)) > (Double
				.parseDouble(split_end_time[0] + "." + split_end_time[1]))) {
			// SOP("Case 2 ********* ");
			SOP("999");
			mydate = addHoursDate(stringToDate(report_time), 1, 0, 0);
			if (!CheckHolidate(mydate, public_holidate, Sun, Mon, Tue, Wed,
					Thu, Fri, Sat).equals("0")) {
				while (CheckHolidate(mydate, public_holidate, Sun, Mon, Tue,
						Wed, Thu, Fri, Sat).equals("1")) {
					mydate = addHoursDate(mydate, 1, 0, 0);
				}
				report_time = toLongDate(mydate);
				report_time = report_time.substring(0, 8) + split_start_time[0]
						+ split_start_time[1] + "00";
				added_date = stringToDate(report_time);
			} else {
				SOP("1111");
				report_time = toLongDate(mydate);
				report_time = report_time.substring(0, 8) + split_start_time[0]
						+ split_start_time[1] + "00";
				added_date = stringToDate(report_time);
			}
			SOP("2222");
		} // if report time is b/w (start - end) time
		else if (Double.parseDouble(report_time.substring(11, 13) + "." + report_time.substring(14, 16)) < (Double.parseDouble(split_end_time[0] + "." + split_end_time[1]))
				&& Double.parseDouble(report_time.substring(11, 13) + "." + report_time.substring(14, 16)) > (Double.parseDouble(split_start_time[0] + "." + split_start_time[1]))) {
			// SOP("Case 3 ********* ");

			if (!CheckHolidate(added_date, public_holidate, Sun, Mon, Tue, Wed,
					Thu, Fri, Sat).equals("0")) {
				while (CheckHolidate(added_date, public_holidate, Sun, Mon,
						Tue, Wed, Thu, Fri, Sat).equals("1")) {
					added_date = addHoursDate(added_date, 1, 0, 0);
				}
				report_time = toLongDate(added_date);
				report_time = report_time.substring(0, 8) + split_start_time[0]
						+ split_start_time[1] + "00";
				added_date = stringToDate(report_time);
			}
		}
		SOP("3333");
		// ********************************************************************************************************************
		// adding minutes (duehrs in mins)
		if (mins_toadd == 0) {
			report_time = toLongDate(added_date);
			report_time = report_time.substring(0, 8) + split_end_time[0]
					+ split_end_time[1] + "00";
			added_date = stringToDate(report_time);
		} else if (mins_toadd != 0) {
			int remaining_mins = 0;
			int end_hrs = GetMinsFromTime(split_end_time[0] + "."
					+ split_end_time[1]);
			String due_starttime = toLongDate(added_date).substring(11, 13)
					+ "." + toLongDate(added_date).substring(14, 16);
			int report_added_time = GetMinsFromTime(due_starttime);
			double time_diff = end_hrs - report_added_time;
			remaining_mins = mins_toadd;
			SOP("4444");
			if (time_diff >= mins_toadd) {
				added_date = addHoursDate(stringToDate(toLongDate(added_date)),
						0, 0, mins_toadd);
				remaining_mins = 0;
			} else {
				added_date = addHoursDate(stringToDate(toLongDate(added_date)),
						0, 0, time_diff);
				mydate = added_date;
				mins_toadd = (int) (mins_toadd - time_diff);
				SOP("5555");
				// -----------------------------------------------------------------------------------------------------
				// loop until there are no minutes to add
				while (remaining_mins != 0) {
					// SOP("inside while loop remaining_mins  = "
					// + remaining_mins + "-------------");

					days_toadd = 1;
					String day = "0";
					int min = mins_toadd;
					String c, d = "";

					// ------------------------------------------------------------------------------------------------
					// check holidays while adding mins on next day
					while (min != 0) {
						String publicholi_check = "";
						mydate = addHoursDate(stringToDate(toLongDate(mydate)),
								1, 0, 0);

						for (int j = 1; j <= public_holidate.size(); j++) {
							c = toLongDate(mydate).substring(0, 8);
							d = (String) public_holidate.get(j - 1);
							d = d.substring(0, 8);
							if (c.equals(d)) {
								days_toadd = days_toadd + 1;
								publicholi_check = "no";
							}
						}
						SOP("6666");
						if (!publicholi_check.equals("no")) {
							int y = returnDayOfWeek(mydate);
							if (y == 1) {
								days_toadd = days_toadd + Integer.parseInt(Sun);
								day = Sun;
							} else if (y == 2) {
								days_toadd = days_toadd + Integer.parseInt(Mon);
								day = Mon;
							} else if (y == 3) {
								days_toadd = days_toadd + Integer.parseInt(Tue);
								day = Tue;
							} else if (y == 4) {
								days_toadd = days_toadd + Integer.parseInt(Wed);
								day = Wed;
							} else if (y == 5) {
								days_toadd = days_toadd + Integer.parseInt(Thu);
								day = Thu;
							} else if (y == 6) {
								days_toadd = days_toadd + Integer.parseInt(Fri);
								day = Fri;
							} else if (y == 7) {
								days_toadd = days_toadd + Integer.parseInt(Sat);
								day = Sat;
							}
							if (day.equals("0")) {
								min = 0;
							}
						}
					}
					SOP("7777");
					// ---------------------------------------------------------------------------------------------
					// adding days (holidays)
					added_date = addHoursDate(
							stringToDate(toLongDate(added_date)), days_toadd,
							0, 0);

					// ''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
					// calculate remaining minutes
					report_time = toLongDate(added_date);
					report_time = report_time.substring(0, 8)
							+ split_start_time[0] + split_start_time[1] + "00";
					String next_day = report_time.substring(11, 13) + "."
							+ report_time.substring(14, 16);
					int nextday_time = GetMinsFromTime(next_day);
					time_diff = end_hrs - nextday_time;

					if (time_diff >= mins_toadd) {
						// SOP("Match 1 ------------");
						added_date = addHoursDate(stringToDate(report_time), 0,
								0, mins_toadd);
						remaining_mins = 0;
					} else {

						// SOP("Match 2 ------------");
						added_date = addHoursDate(stringToDate(report_time), 0,
								0, time_diff);
						mins_toadd = mins_toadd - ((int) time_diff);
						remaining_mins = mins_toadd;
						if (remaining_mins < 0) {
							remaining_mins = 0;
						}
					}
					SOP("8888");
					// ''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
				}
				// ------------------------------------------------------------------------------------------------
			}
		}
		SOP("9999");
		// ********************************************************************************************************************
		if (!CheckHolidate(added_date, public_holidate, Sun, Mon, Tue, Wed,
				Thu, Fri, Sat).equals("0")) {
			while (CheckHolidate(added_date, public_holidate, Sun, Mon, Tue,
					Wed, Thu, Fri, Sat).equals("1")) {
				added_date = addHoursDate(added_date, 1, 0, 0);
			}
		}
		SOP("11111");
		// ********************************************************************************************************************
		return toLongDate(added_date).toString();
	}
	public double convert(double x) {
		String ze = x + "";
		x = Double.parseDouble(ze);
		String split_ze[] = ze.split("/.");

		double y = Math.floor(x);
		// float z = (float) (12.34 - 12);
		// x = (12.34 - 12.00);
		y = y * 60;
		y = y + Integer.parseInt(split_ze[1] + "0");
		return y;

	}

	public String CheckHolidate(Date mydate, ArrayList holi_date, String sun,
			String mon, String tue, String wed, String thu, String fri,
			String sat) {
		String holi = "0", publicholi_date = "";
		Date strdate = mydate;
		int x = returnDayOfWeek(strdate);
		for (int i = 1; i <= holi_date.size(); i++) {
			// if (strdate.equals(holi_date.get(i - 1))) {
			if ((strdate.toString().substring(0, 8) + "000000").equals(holi_date
					.get(i - 1))) {
				holi = "1";
				publicholi_date = "no";
			}
		}
		if (!publicholi_date.equals("no")) {
			if (x == 1 && sun.equals("1")) {
				holi = "1";
			} else if (x == 2 && mon.equals("1")) {
				holi = "1";
			} else if (x == 3 && tue.equals("1")) {
				holi = "1";
			} else if (x == 4 && wed.equals("1")) {
				holi = "1";
			} else if (x == 5 && thu.equals("1")) {
				holi = "1";
			} else if (x == 6 && fri.equals("1")) {
				holi = "1";
			} else if (x == 7 && sat.equals("1")) {
				holi = "1";
			}
		}
		return holi;
	}

	// ******************** DELAY-TIME calculation *********************
	public String DelayTime(Date duetime, String closetime, double starttime,
			double endtime, String Sun, String Mon, String Tue, String Wed,
			String Thu, String Fri, String Sat, ArrayList public_holidate) throws ParseException {

		String delaytime = "";
		Date added_date = null;
		int count = 0;
		long hours = 0;
		long wh_hrs = 0;
		long wh_mins = 0;

		// String dtime = cdate.splitHour(duetime);
		// String ctime = cdate.splitHour(closetime);
		// String dmin = cdate.splitMin(duetime);
		// String cmin = cdate.splitMin(closetime);
		// SOP("public_holidate's = " + public_holidate);
		// SOP("duetime   = " + duetime);
		// SOP("closetime = " + closetime);
		// SOP("dtime = " + dtime);
		// SOP("ctime = " + ctime);
		// SOP("dmin = " + dmin);
		// SOP("cmin = " + cmin);
		// ********************************************************************************************************************
		// calculating login time
		String str_starttime = Double.toString(starttime);
		String split_start_time[] = str_starttime.split("/.");

		split_start_time[0] = doublenum(Integer.parseInt(split_start_time[0]));
		if (split_start_time[1].length() < 2) {
			split_start_time[1] = split_start_time[1] + "0";
		}

		// calculating logoff time
		String str_endtime = Double.toString(endtime);
		String split_end_time[] = str_endtime.split("/.");

		split_end_time[0] = doublenum(Integer.parseInt(split_end_time[0]));
		if (split_end_time[1].length() < 2) {
			split_end_time[1] = split_end_time[1] + "0";
		}
		// SOP("split_start_time[0] = " + split_start_time[0]);
		// SOP("split_start_time[1] = " + split_start_time[1]);
		// SOP("split_end_time[0] = " + split_end_time[0]);
		// SOP("split_end_time[1] = " + split_end_time[1]);

		// ********************************************************************************************************************
		if ((Double.parseDouble(closetime.toString().substring(8, 10) + "."
				+ closetime.toString().substring(10, 12))) > (Double
				.parseDouble(split_end_time[0] + "." + split_end_time[1]))) {
			// SOP("close time is greater");
			closetime = closetime.toString().substring(0, 8) + split_end_time[0] + split_end_time[1] + "00";
		}
		if ((Double.parseDouble(closetime.toString().substring(8, 10) + "."
				+ closetime.toString().substring(10, 12))) < (Double
				.parseDouble(split_start_time[0] + "." + split_start_time[1]))) {
			// SOP("close time is lesser");
			closetime = closetime.substring(0, 8) + split_start_time[0] + split_start_time[1] + "00";
		}
		// SOP("closetime 2 = " + closetime);
		String dtime = splitHour(duetime);
		String ctime = splitHour(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(closetime));
		String dmin = splitMin(duetime);
		String cmin = splitMin(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(closetime));
		// ********************************************************************************************************************
		// calculating no of days to be added
		int days = (int) getDaysBetween(duetime, new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(closetime));
		added_date = duetime;

		for (int i = 1; i <= days; i++) {
			added_date = addHoursDate(added_date, 1, 0, 0);
			if (CheckHolidate(added_date, public_holidate, Sun, Mon, Tue, Wed,
					Thu, Fri, Sat).equals("1")) {
				count++;
			}
		}
		long diff_in_days = days - count;
		// SOP("diff_in_days = " + diff_in_days);

		// ********************************************************************************************************************
		// calculating working hours
		wh_hrs = Long.parseLong(split_end_time[0])
				- Long.parseLong(split_start_time[0]);

		if ((duetime.toString().substring(0, 8)).equals((closetime.toString().substring(0, 8)))) {
			wh_mins = 0;
		} else {
			wh_mins = Long.parseLong(split_end_time[1])
					- Long.parseLong(split_start_time[1]);
		}
		if (wh_hrs < 0) {
			wh_hrs = -wh_hrs;
		}
		if (wh_mins < 0) {
			wh_mins = -wh_mins;
		}
		// SOP("wh_hrs = " + wh_hrs);
		// SOP("wh_mins = " + wh_mins);

		// ********************************************************************************************************************
		Date mydate = duetime;
		double new_mins = 0;
		long days_in_hrs = 0, new_hrs = 0;
		long hrs = 0;

		// ****** if due time < report time
		if ((Double.parseDouble(closetime.toString().substring(8, 10) + "."
				+ closetime.toString().substring(10, 12))) < (Double.parseDouble(duetime.toString().substring(8, 10) + "." + duetime.toString().substring(10, 12)))) {
			// SOP("case 1 ******");
			// ------------------------------------------------------------------------------------------------------------
			// ****** if days to add = 0
			if (diff_in_days == 0) {
				new_hrs = (long) (Double.parseDouble(dtime + "." + dmin) - Double
						.parseDouble(split_end_time[0] + "."
								+ split_end_time[1]));
				// new_hrs = Long.parseLong(dtime) -
				// Long.parseLong(split_end_time[0]);
				// new_hrs = Double.parseDouble(dtime+"."+dmin) -
				// Double.parseDouble(split_end_time[0]+"."+split_end_time[1]);
				// new_hrs = Double.parseDouble(rtime + "." + rmin) -
				// Double.parseDouble(split_end_time[0] + "." +
				// split_end_time[1]);
				if (!duetime.toString().substring(6, 8).equals(closetime.toString().substring(6, 8))) {
					hrs = (Long.parseLong(closetime.toString().substring(8, 10)) - Long
							.parseLong(split_start_time[0]));
				}
			} // ------------------------------------------------------------------------------------------------------------
				// ****** if days to add > 0
			else {
				days_in_hrs = (diff_in_days) * wh_hrs;
				// SOP("days_in_hrs = " + days_in_hrs);
				new_hrs = (long) (Double.parseDouble(dtime) - Double
						.parseDouble(ctime));
				// new_hrs = Double.parseDouble(dtime) -
				// Double.parseDouble(ctime);
				// SOP("new_hrs = " + new_hrs);

				if (new_hrs != 0) {
					new_hrs = (long) (Double.parseDouble(dtime + "." + dmin) - Double
							.parseDouble(split_end_time[0] + "."
									+ split_end_time[1]));
					// new_hrs = Double.parseDouble(dtime) -
					// Double.parseDouble(split_end_time[0]);
					hrs = (Long.parseLong(split_start_time[0]) - Long
							.parseLong(ctime));
				}
				// days_in_hrs = (diff_in_days) * wh_hrs;
				// // SOP("days_in_hrs = " + days_in_hrs);
				// while (diff_in_days > 0) {
				// new_hrs = Double.parseDouble(dtime) -
				// Double.parseDouble(ctime);
				// // new_hrs = Double.parseDouble(dtime + "." + dmin) -
				// Double.parseDouble(split_end_time[0] + "." +
				// split_end_time[1]);
				// // new_mins = Double.parseDouble(dmin) -
				// Double.parseDouble(split_end_time[1]);
				// diff_in_days = diff_in_days - 1;
				// }
			}
			// ------------------------------------------------------------------------------------------------------------
			hours = (long) new_hrs;
			if (hours < 0) {
				hours = -hours;
			}
			if (hrs < 0) {
				hrs = -hrs;
			}
			hours = hours + days_in_hrs;
			hours = hours + hrs;
		} // ------------------------------------------------------------------------------------------------------------
			// if due time >= report time
		else {
			// SOP("case 2 ******");
			if (diff_in_days > 0) {
				hours = (diff_in_days) * wh_hrs;
				long diff_in_hrs = (long) (Double.parseDouble(dtime + "."
						+ dmin) - Double.parseDouble(ctime + "." + cmin));
				// long diff_in_hrs = Long.parseLong(dtime) -
				// Long.parseLong(ctime);
				if (diff_in_hrs < 0) {
					diff_in_hrs = -diff_in_hrs;
				}
				hours = hours + diff_in_hrs;
			}
			if (diff_in_days == 0) {
				hours = (long) (Double.parseDouble(dtime + "." + dmin) - Double
						.parseDouble(ctime + "." + cmin));
				// hours = Long.parseLong(dtime) - Long.parseLong(ctime);
				if (hours < 0) {
					hours = -hours;
				}
			}
		}
		// SOP("hours = " + hours);

		// ********************************************************************************************************************
		// calculating mins to add
		long diff_in_min = Long.parseLong(dmin) - Long.parseLong(cmin);
		if (diff_in_min < 0) {
			diff_in_min = -diff_in_min;
		}
		// SOP("diff_in_min = " + diff_in_min);
		long a = hours;
		long b = diff_in_min - wh_mins;
		int hr_count = 0;
		while (b >= 60) {
			if (hr_count == 0) {
				hr_count++;
			}
			b = b - 60;
			if (b >= 60) {
				hr_count++;
			}
		}
		b = b + (long) new_mins;
		a = a + hr_count;
		// int x = (int) b;

		// String y = doublenum(x);
		// SOP("y= " + y);
		// if (Integer.parseInt(y) >= 30) {
		// a = a + 1;
		// }
		// SOP("mins finally = " + b);
		// SOP("hours finally = " + a);
		// delaytime = a + "." + doublenum(x);
		delaytime = a + "";

		// ********************************************************************************************************************
		// SOP("delaytime is......" + delaytime);
		return delaytime;
	}

	public String DelayTimeWithoutBhrs(String date1, String date2) {
		String value = "";
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Date d1 = null, d2 = null;
		try {
			date1 = fmt1tofmt2(strToLongDate(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(date1)));
			date2 = fmt1tofmt2(strToLongDate(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(date2)));
			d1 = format.parse(date1);
			d2 = format.parse(date2);

			long diff = d2.getTime() - d1.getTime();
			long days = diff / (24 * 60 * 60 * 1000) % 60;
			long hours = diff / (60 * 60 * 1000) % 24;
			long mins = diff / (60 * 1000) % 60;

			if (days < 0) {
				days = -days;
			}
			if (hours < 0) {
				hours = -hours;
			}
			if (mins < 0) {
				mins = -mins;
			}
			hours = hours + (days * 24);
			// int x = (int) mins;
			// String y = doublenum(x);
			// if (Integer.parseInt(y) >= 30) {
			// hours = hours + 1;
			// }
			value = hours + "";
			// value =
			// Math.floor(Double.parseDouble(hours+"."+doublenum(x)))+"";
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
		}
		return value;
	}

	public String CheckSpecialCharacters(String doc_title) {
		String msg = "";
		Pattern p = Pattern.compile("[^a-z 0-9]", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(doc_title);
		Boolean b = m.find();
		if (b) {
			msg = msg + "<br>Special Characters not allowed";
			return msg;
		} else {
			return "";
		}
	}

	/* ===Added on 3rd May 2013 Saiman ==== */
	public double DurtoMin(double x) {
		String ze = x + "";
		x = Double.parseDouble(ze);
		String split_ze[] = ze.split("/.");
		double y = Math.floor(x);
		y = y * 60;
		y = y + Integer.parseInt(split_ze[1] + "0");
		return y;
	}

	public int GetMinsFromTime(String duehrs) {
		duehrs = duehrs.replaceAll(":", ".");
		String split_hrs_mins[] = duehrs.split("\\.");
		String mins, hrs = "";
		hrs = split_hrs_mins[0];
		mins = split_hrs_mins[1];
		if (mins.length() < 2) {
			mins = mins + "0";
		}
		int ret_min = Integer.parseInt(hrs) * 60;
		ret_min = ret_min + Integer.parseInt(mins);
		return ret_min;
	}

	public ArrayList publicHolidays(Date holi_start_time, String branch_id,
			String comp_id) throws ParseException {

		ArrayList holi_date = null;
		if (branch_id.equals("0") | branch_id.equals("")) {
			holi_date = new ArrayList();
			return holi_date;
		} else {
			CachedRowSet crs = null;
			String ticketholi_limit_date = addDayMonthYear(holi_start_time, 100, 0, 0, 0);
			try {
				String StrSql = "SELECT ticketholi_date" + " from "
						+ compdb(comp_id) + "axela_service_ticket_holi"
						+ " WHERE ticketholi_branch_id = " + branch_id
						+ " AND SUBSTR(ticketholi_date, 1, 8) >= SUBSTR('"
						+ holi_start_time + "', 1, 8)"
						+ " AND ticketholi_date <= '"
						+ convertShortDateToStr(ticketholi_limit_date) + "'"
						+ " ORDER BY ticketholi_date";
				// SOP("publicHolidays StrSql = " + StrSql);
				crs = processQuery(StrSql, 0);
				holi_date = new ArrayList();
				while (crs.next()) {
					holi_date.add(crs.getString("ticketholi_date"));
				}
				crs.close();
			} catch (Exception ex) {
				SOPError(this.getClass().getName());
				SOPError("Error in "
						+ new Exception().getStackTrace()[0].getMethodName()
						+ ": " + ex);
			} finally {

				return holi_date;
			}
		}
	}

	public ArrayList publicAdminHolidays(Date holi_start_time) throws ParseException {
		ArrayList holi_date = null;
		holi_date = new ArrayList();
		String holi_limit_date = addDayMonthYear(holi_start_time, 100, 0, 0, 0);
		try {
			String StrSql = "SELECT holi_date" + " FROM " + maindb()
					+ "ticket_holi" + " WHERE 1 = 1"
					+ " AND SUBSTR(holi_date, 1, 8) >= SUBSTR('"
					+ holi_start_time + "', 1, 8)" + " AND holi_date <= '"
					+ convertShortDateToStr(holi_limit_date) + "'"
					+ " ORDER BY holi_date";
			// SOP("StrSql==="+StrSqlBreaker(StrSql));
			CachedRowSet crs = processQuery(StrSql, 0);
			holi_date = new ArrayList();
			while (crs.next()) {
				holi_date.add(crs.getString("holi_date"));
			}
			crs.close();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
		} finally {

			return holi_date;
		}
	}

	public double ConverttoMinutes(double x) {
		String ze = x + "";
		x = Double.parseDouble(ze);
		String split_ze[] = ze.split("\\.");
		int y = Integer.parseInt(split_ze[0]) * 60;
		if (!split_ze[1].equals("")) {
			y = y + Integer.parseInt(split_ze[1]);
		}
		return y;

	}

	public String ConvertArea(Double area, float ratio, String update) {
		DecimalFormat df = new DecimalFormat("0.00");
		String res = "";
		if (ratio == 0) {
			ratio = 1;
		}
		if (update.equals("display")) {
			res = df.format(Math.abs(area * ratio)).replace(".00", "");
		} else if (update.equals("price display")) {
			res = df.format(Math.abs(area / ratio)).replace(".00", "");
		} else if (update.equals("price")) {
			res = df.format(Math.abs(area / ratio)).replace(".00", "");
			res = IndDecimalFormat(res);
		} else if (update.equals("")) {
			res = df.format(Math.abs(area * ratio)).replace(".00", "");
			res = IndDecimalFormat(res);
		}
		return res;
	}

	public String PropertyPrice(double price) {
		DecimalFormat df = new DecimalFormat("0.00");
		String value = "";
		if (price >= 10000000) {
			price = Double.valueOf(df.format(Math.abs(price / 10000000)));
			if (price < 2) {
				value = IndDecimalFormat(df.format(price)).replace(".00", "")
						+ " Crore";
			} else {
				value = IndDecimalFormat(df.format(price)).replace(".00", "")
						+ " Crores";
			}
		} else if (price >= 100000) {
			price = Double.valueOf(df.format(Math.abs(price / 100000)));
			if (price < 2) {
				value = IndDecimalFormat(df.format(price)).replace(".00", "")
						+ " Lac";
			} else {
				value = IndDecimalFormat(df.format(price)).replace(".00", "")
						+ " Lacs";
			}
		} else {
			value = IndFormat(price + "");
		}
		return value;
	}

	public String getBranchName(String branch_id, String comp_id) {
		if (!branch_id.equals("0")) {
			return ExecuteQuery("SELECT CONCAT('<a href=../portal/branch-summary.jsp?branch_id=',branch_id,'>', branch_name, ' (',branch_code,')','</a>') AS branch_name"
					+ " FROM "
					+ compdb(comp_id)
					+ "axela_branch"
					+ " WHERE branch_id = " + branch_id);
		} else {
			return "No Branch found!";
		}
	}

	public String getActiveBranchID(String emp_id, String comp_id) {
		String branch_id = "0";
		if (emp_id.equals("1")) {
			branch_id = ExecuteQuery("SELECT branch_id FROM " + compdb(comp_id)
					+ "axela_branch" + " WHERE branch_active = '1'"
					+ " LIMIT 1");
		} else if (!emp_id.equals("1")) {
			branch_id = ExecuteQuery("SELECT emp_branch_id FROM "
					+ compdb(comp_id) + "axela_emp_branch" + " INNER JOIN "
					+ compdb(comp_id)
					+ "axela_branch ON branch_id = emp_branch_id"
					+ " WHERE branch_active = '1'" + " AND emp_id = " + emp_id
					+ "" + " LIMIT 1");
			// SOP("branch_id = " + branch_id);
		}
		return CNumeric(branch_id);
	}
	public String getActiveBranchID(HttpServletRequest request, String emp_id) {
		String branch_id = "0";
		String comp_id = CNumeric(GetSession("comp_id", request) + "");
		// if (emp_id.equals("1")) {
		branch_id = ExecuteQuery("SELECT branch_id" + " FROM "
				+ compdb(comp_id) + "axela_branch"
				+ " WHERE branch_active = '1'" + " LIMIT 1");
		// }
		// else if (!emp_id.equals("1")) {
		// branch_id = ExecuteQuery("SELECT emp_branch_id FROM "
		// + "axela_emp_branch" + " INNER JOIN "
		// + "axela_branch ON branch_id = emp_branch_id"
		// + " WHERE branch_active = '1'"
		// + " AND branch_company_id = "+company_id
		// + " AND emp_id = " + emp_id
		// + "" + " LIMIT 1");
		// // SOPError("branch_id = " + branch_id);
		// }
		return CNumeric(branch_id);
	}
	public boolean IsValidMobileNo11(String mobileno) { // modified by aJIt
		try {
			boolean isvalid = false;
			if (mobileno.equals("")) {
				return true;
			}
			if (mobileno.replaceAll("[^-]", "").length() != 1) {
				return isvalid;
			} else {
				String[] str = mobileno.split("-");
				if (str.length == 2) {
					if (str[0].equals("") || str[1].equals("")) {
						return isvalid;
					}
					else if (((str[0].length() + str[1].length()) > 12) || ((str[0].length() + str[1].length()) < 7)) {
						return isvalid;
					}
					else if (str[0].equals("91")) {
						if (mobileno.length() != 13) {
							return isvalid;
						}
					}
					isvalid = true;
				}
			}
			return isvalid;
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName()
					+ " : " + ex);
			return false;
		}
	}

	public boolean IsValidPhoneNo11(String phoneno) {
		boolean isvalid = false;
		if (phoneno.equals("")) {
			return true;
		}
		if (phoneno.replaceAll("[^-]", "").length() != 2) {
			return isvalid;
		} else {
			String[] str = phoneno.split("-");
			if (str[0].equals("") || str[1].equals("") || str[2].equals("")) {
				return isvalid;
			}
			else if (((str[0].length() + str[1].length() + str[2].length()) > 12) || ((str[0].length() + str[1].length() + str[2].length()) < 7)) {
				return isvalid;
			}
			else if (str[0].equals("91")) {
				if (phoneno.length() != 14) {
					return isvalid;
				}
			}
			isvalid = true;
		}
		return isvalid;
	}

	public String CustomFieldView(String submodule_id, String row_id, String colspan, String comp_id, HttpServletRequest request) {
		StringBuilder Str = new StringBuilder();
		String emp_formatdate = GetSession("formatdate_name", request);
		String formatdate_datepicker = GetSession("formatdate_datepicker", request);
		String formattime_timepicker = GetSession("formattime_timepicker", request);
		String emp_formattime = GetSession("formattime_name", request);
		String fieldvalue = "";
		submodule_id = CNumeric(submodule_id);
		row_id = CNumeric(row_id);
		CachedRowSet crs = null;
		try {
			String StrSql = "SELECT customfield_id, customfield_title, customfield_cftype_id,"
					+ " customfield_numeric, customfield_length_min, customfield_length_max,"
					+ " customfield_option, customfield_unique, customfield_mandatory, customfield_instruction,"
					+ " COALESCE(cftrans_row_id, 0) AS cftrans_row_id, COALESCE(cftrans_value, '') AS cftrans_value"
					+ " FROM " + compdb(comp_id) + "axela_cf"
					+ " LEFT JOIN " + compdb(comp_id) + "axela_cf_trans ON cftrans_customfield_id = customfield_id"
					+ " AND cftrans_row_id = " + row_id + ""
					+ " WHERE customfield_active = 1"
					+ " AND customfield_submodule_id = " + submodule_id
					+ " ORDER BY customfield_rank";
			// SOP("StrSql===========" + StrSql);
			crs = processQuery(StrSql, 0);

			if (crs.isBeforeFirst()) {
				while (crs.next()) {
					// Get Field Value
					if (PadQuotes(request.getParameter("customfieldsubmit")).equals("yes")) {
						fieldvalue = PadQuotes(request.getParameter("customfield_id-" + (crs.getString("customfield_id"))));
						if (crs.getString("customfield_cftype_id").equals("3")) {
							// Check Box
							if (fieldvalue.equals("on")) {
								fieldvalue = CheckBoxValue(PadQuotes(request.getParameter("customfield_id-" + (crs.getString("customfield_id")))));
							}
						}
					} else {
						fieldvalue = crs.getString("cftrans_value");
						if (crs.getString("customfield_cftype_id").equals("5")) {
							// Date
							if (!fieldvalue.equals("")) {
								fieldvalue = formatDate(fieldvalue, emp_formatdate);
							}
						} else if (crs.getString("customfield_cftype_id").equals("6")) {
							// Date Time
							if (!fieldvalue.equals("")) {
								fieldvalue = formatDate(fieldvalue, emp_formatdate + " " + emp_formattime);
							}
						}
					}

					if (submodule_id.equals("4") || submodule_id.equals("5") || submodule_id.equals("17") ||
							submodule_id.equals("18") || submodule_id.equals("19") || submodule_id.equals("20") ||
							submodule_id.equals("37")) {
						Str.append("<div class=\"form-element6\">");
						Str.append("<label>\n");
					} else if (crs.getString("customfield_cftype_id").equals("3")) {
						// Check Box
						Str.append("<div class=\"form-element6 form-element-margin\">");
						Str.append("<label>\n");
					} else {
						Str.append("<div class=\"form-element6\">");
						Str.append("<label>");
					}

					Str.append(crs.getString("customfield_title"));
					if (crs.getString("customfield_mandatory").equals("1")) {
						Str.append("<font color=\"#ff0000\">*</font>");
					}
					Str.append(":</label>\n");

					if (crs.getString("customfield_cftype_id").equals("1")) {
						// Text Box
						Str.append("<input name=customfield_id-").append(crs.getString("customfield_id"))
								.append(" id=customfield_id-").append(crs.getString("customfield_id"))
								.append(" type=\"text\" class=\"form-control\" size=50 maxlength=").append(crs.getString("customfield_length_max"))
								.append(" value=\"").append(fieldvalue).append("\"");
						if (crs.getString("customfield_numeric").equals("1")) {
							Str.append(" onKeyUp=\"toInteger('customfield_id-").append(crs.getString("customfield_id")).append("','custom')\"");
						}
						Str.append("/>");
					} else if (crs.getString("customfield_cftype_id").equals("2")) {
						// Text Area
						Str.append("<textarea name=customfield_id-").append(crs.getString("customfield_id"))
								.append(" id=customfield_id-").append(crs.getString("customfield_id"))
								.append(" cols=\"70\" rows=\"6\" class=\"form-control\"")
								.append(" onKeyUp=\"charcount('").append("customfield_id-").append(crs.getString("customfield_id"))
								.append("', 'span_customfield_id-").append(crs.getString("customfield_id"))
								.append("','<font color=red>({CHAR} characters left)</font>',").append(crs.getString("customfield_length_max")).append(")\">").append(fieldvalue);
						Str.append("</textarea>");
						Str.append(" <span id=\"span_customfield_id-").append(crs.getString("customfield_id")).append("\"> (").append(crs.getString("customfield_length_max"))
								.append(" Characters)</span>");
					} else if (crs.getString("customfield_cftype_id").equals("3")) {
						// Check Box
						Str.append("<input id=customfield_id-").append(crs.getString("customfield_id")).append(" type=\"checkbox\" ")
								.append(" name=customfield_id-").append(crs.getString("customfield_id")).append(" ").append(PopulateCheck(fieldvalue)).append("/>");
					} else if (crs.getString("customfield_cftype_id").equals("4") || crs.getString("customfield_cftype_id").equals("0")) {
						// Drop Down
						Str.append("<select name=customfield_id-").append(crs.getString("customfield_id"))
								.append(" id=customfield_id-").append(crs.getString("customfield_id"))
								.append(" class=form-control>\n");
						String[] option = crs.getString("customfield_option").split("\\r\\n");
						Str.append("<option value=\"\">Select</option>\n");// this is the drop down item
						for (int i = 1; i <= option.length; i++) {
							Str.append("<option" + " value=\"").append(option[i - 1]).append("\" ")
									.append(StrSelectdrop(option[i - 1], fieldvalue))
									.append(">").append(option[i - 1]).append("</option>\n");
						}
						Str.append("</select>");
					} else if (crs.getString("customfield_cftype_id").equals("5")) {
						// Date
						Str.append("<input name=customfield_id-").append(crs.getString("customfield_id"))
								.append(" id=customfield_id-").append(crs.getString("customfield_id"))
								.append(" type=text class='form-control customfield-date datepicker' size=12 maxlength=10");
						Str.append(" value=\"").append(fieldvalue).append("\"").append("/>");
					} else if (crs.getString("customfield_cftype_id").equals("6")) {
						// Date Time
						Str.append("<input name=customfield_id-").append(crs.getString("customfield_id"))
								.append(" id=customfield_id-").append(crs.getString("customfield_id"))
								.append(" type=text  class='form-control datetimepicker' size=18 maxlength=16")
								.append(" value=\"").append(fieldvalue).append("\"").append("/>");
					} else if (crs.getString("customfield_cftype_id").equals("7")) {
						// Time
						Str.append("<input name=customfield_id-").append(crs.getString("customfield_id"))
								.append(" id=customfield_id-").append(crs.getString("customfield_id"))
								.append(" type=text class='form-control shorttimepicker' size=7 maxlength=5")
								.append(" value=\"").append(fieldvalue).append("\"");
						Str.append("/>");
					}
					if (!crs.getString("customfield_instruction").equals("")) {
						Str.append("<br>").append(crs.getString("customfield_instruction"));
					}

					Str.append("</div>\n");

				}
				Str.append("<input type=hidden name=customfieldsubmit value=yes>\n");
			}
			return Str.toString();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
			return "";
		}
	}

	// public JSONObject PopulateAppCustomFieldView(String submodule_id, String row_id, String colspan, String comp_id, JSONObject output) {
	// try {
	// String fieldvalue = "";
	// String crmcf_option = "";
	// String[] option = null;
	// CachedRowSet crs = null;
	// ArrayList<String> list = new ArrayList<String>();
	// Map<String, String> map = new HashMap<String, String>();
	// Gson gson = new Gson();
	// String StrSql = "SELECT customfield_id, customfield_title, customfield_cftype_id,"
	// + " customfield_numeric, customfield_length_min, customfield_length_max,"
	// + " customfield_option, customfield_unique, customfield_mandatory, customfield_instruction,"
	// + " COALESCE(cftrans_row_id, 0) AS cftrans_row_id,"
	// + " COALESCE(cftrans_value, '') AS cftrans_value"
	// + " FROM " + compdb(comp_id) + "axela_cf"
	// + " LEFT JOIN " + compdb(comp_id) + "axela_cf_trans ON cftrans_customfield_id = customfield_id"
	// + " AND cftrans_row_id = " + row_id + ""
	// + " WHERE customfield_active = 1"
	// + " AND customfield_submodule_id = " + submodule_id + ""
	// + " ORDER BY customfield_rank";
	// SOP("StrSql==========PopulateAppCustomFieldView============" + StrSql);
	// crs = processQuery(StrSql, 0);
	// if (crs.isBeforeFirst()) {
	// while (crs.next()) {
	// map.put("customfield_id", crs.getString("customfield_id"));
	// map.put("customfield_title", unescapehtml(crs.getString("customfield_title")));
	// map.put("customfield_cftype_id", crs.getString("customfield_cftype_id"));
	// map.put("customfield_numeric", crs.getString("customfield_numeric"));
	// map.put("customfield_length_min", crs.getString("customfield_length_min"));
	// map.put("customfield_length_max", crs.getString("customfield_length_max"));
	// map.put("customfield_option", crs.getString("customfield_option"));
	// map.put("customfield_unique", crs.getString("customfield_unique"));
	// map.put("customfield_mandatory", crs.getString("customfield_mandatory"));
	// map.put("customfield_instruction", crs.getString("customfield_instruction"));
	// map.put("customfield_unique", crs.getString("customfield_unique"));
	// if (crs.getString("customfield_id").equals("5")) {
	// fieldvalue = strToShortDate(fieldvalue);
	// }
	// if (crs.getString("customfield_id").equals("6")) {
	// fieldvalue = strToLongDate(fieldvalue);
	// }
	// list.add(gson.toJson(map));
	// }
	// /*
	// * else { map.put("customfield_id", "0"); map.put("customfield_title", "Select"); list.add(gson.toJson(map)); }
	// */
	// map.clear();
	// output.put("populateappcustomfieldview", list);
	// list.clear();
	// crs.close();
	// }
	// } catch (Exception ex) {
	// SOPError(this.getClass().getName());
	// SOPError("Error in " + new Exception().getStackTrace()[0].getMethodName() + ": " + ex);
	// }
	// return output;
	// }

	// public JSONObject AppCustomFieldViewDash(String submodule_id, String comp_id, JSONObject input) {
	//
	// String fieldvalue = "";
	// String crmcf_option = "";
	// String[] option = null;
	// CachedRowSet crs = null;
	// ArrayList<String> list = new ArrayList<String>();
	// Map<String, String> map = new HashMap<String, String>();
	// Gson gson = new Gson();
	// try {
	// String StrSql = "SELECT customfield_id, customfield_title, customfield_cftype_id,"
	// + " customfield_numeric, customfield_length_min, customfield_length_max,"
	// + " customfield_option, customfield_unique, customfield_mandatory, customfield_instruction,"
	// + " COALESCE(cftrans_row_id, 0) AS cftrans_row_id, COALESCE(cftrans_value, '') AS cftrans_value"
	// + " FROM "
	// + compdb(comp_id)
	// + "axela_cf"
	// + " LEFT JOIN "
	// + compdb(comp_id)
	// + "axela_cf_trans ON cftrans_customfield_id = customfield_id"
	// + " WHERE customfield_active = 1"
	// + " AND customfield_submodule_id = "
	// + submodule_id
	// + " GROUP BY customfield_id"
	// + " ORDER BY customfield_rank";
	// SOP("StrSql ==========-------- " + StrSql);
	// crs = processQuery(StrSql, 0);
	//
	// if (crs.isBeforeFirst()) {
	// while (crs.next()) {
	//
	// map.put("customfield_id", crs.getString("customfield_id"));
	// map.put("customfield_title", crs.getString("customfield_title"));
	// map.put("customfield_cftype_id", crs.getString("customfield_cftype_id"));
	// map.put("customfield_numeric", crs.getString("customfield_numeric"));
	// map.put("customfield_length_min", crs.getString("customfield_length_min"));
	// map.put("customfield_length_max", crs.getString("customfield_length_max"));
	// map.put("customfield_option", crs.getString("customfield_option"));
	// map.put("customfield_unique", crs.getString("customfield_unique"));
	// map.put("customfield_mandatory", crs.getString("customfield_mandatory"));
	// map.put("customfield_instruction", crs.getString("customfield_instruction"));
	// map.put("cftrans_value", crs.getString("cftrans_value"));
	// fieldvalue = crs.getString("cftrans_value");
	//
	// if (crs.getString("customfield_cftype_id").equals("5")) {
	// fieldvalue = strToShortDate(fieldvalue);
	// }
	// if (crs.getString("customfield_cftype_id").equals("6")) {
	// fieldvalue = strToLongDate(fieldvalue);
	// }
	// // Drop down
	// if (crs.getString("customfield_cftype_id").equals("4")) {
	// option = crs.getString("customfield_option").split("\\r\\n");
	// for (int i = 0; i < option.length; i++) {
	// crmcf_option += option[i] + "/";
	// }
	// }
	// map.put("customfield_option", crmcf_option);
	// map.put("fieldvalue", fieldvalue);
	// list.add(gson.toJson(map));
	// }
	// map.clear();
	// input.put("customfielddash", list);
	// list.clear();
	// crs.close();
	// }
	// } catch (Exception ex) {
	// SOPError(this.getClass().getName());
	// SOPError("Error in "
	// + new Exception().getStackTrace()[0].getMethodName() + ": "
	// + ex);
	// } finally {
	// return input;
	// }
	// }

	public String CustomFieldValidate(String submodule_id, String row_id,
			String comp_id, HttpServletRequest request) {
		StringBuilder Str = new StringBuilder();
		String emp_formatdate = GetSession("formatdate_name", request);
		String emp_formattime = GetSession("formattime_name", request);
		String fieldvalue = "";
		submodule_id = CNumeric(submodule_id);
		row_id = CNumeric(row_id);
		CachedRowSet crs = null;
		try {
			String StrSql = "SELECT customfield_id, customfield_title, customfield_cftype_id,"
					+ " customfield_numeric, customfield_length_min, customfield_length_max,"
					+ " customfield_option, customfield_unique, customfield_mandatory"
					+ " FROM "
					+ compdb(comp_id)
					+ "axela_cf"
					+ " WHERE customfield_active = 1"
					+ " AND customfield_submodule_id = "
					+ submodule_id
					+ ""
					+ " ORDER BY customfield_rank";
			crs = processQuery(StrSql, 0);
			if (crs.isBeforeFirst()) {

				while (crs.next()) {
					// / Get Field Value
					if (PadQuotes(request.getParameter("customfieldsubmit"))
							.equals("yes")) {
						fieldvalue = PadQuotes(request
								.getParameter("customfield_id-"
										+ (crs.getString("customfield_id"))));
						if (crs.getString("customfield_cftype_id").equals("3")) {
							if (fieldvalue.equals("on")) {
								fieldvalue = CheckBoxValue(PadQuotes(request
										.getParameter("customfield_id-"
												+ (crs.getString("customfield_id")))));
							}
						}
						// SOP("fieldvalue = " + fieldvalue);
						if (fieldvalue.equals("")
								&& crs.getString("customfield_mandatory")
										.equals("1")) {
							// / For Text Field AND Text Area
							if (crs.getString("customfield_cftype_id").equals(
									"1")
									|| crs.getString("customfield_cftype_id")
											.equals("2")) {
								Str.append("<br>")
										.append(crs
												.getString("customfield_title"))
										.append(" is blank!");
							}
							// / For Drop Down AND Date Time
							if (crs.getString("customfield_cftype_id").equals(
									"4")
									|| crs.getString("customfield_cftype_id")
											.equals("5")
									|| crs.getString("customfield_cftype_id")
											.equals("6")
									|| crs.getString("customfield_cftype_id")
											.equals("7")) {
								Str.append("<br>Select ")
										.append(crs
												.getString("customfield_title"))
										.append("!");
							}
						}
						// / For Date
						if (!fieldvalue.equals("")
								&& crs.getString("customfield_cftype_id")
										.equals("5")) {
							if (!isValidDateFormat(fieldvalue, emp_formatdate)) {
								Str.append("<br>Enter Valid ")
										.append(crs
												.getString("customfield_title"))
										.append("!");
							}
						}
						// / For Date Time
						if (!fieldvalue.equals("")
								&& crs.getString("customfield_cftype_id")
										.equals("6")) {
							if (!isValidDateFormat(fieldvalue, emp_formatdate
									+ " " + emp_formattime)) {
								Str.append("<br>Enter Valid ")
										.append(crs
												.getString("customfield_title"))
										.append("!");
							}
						}
						// / Minimum Length
						// / For Text Field AND Text Area
						if (crs.getString("customfield_cftype_id").equals("1")
								|| crs.getString("customfield_cftype_id")
										.equals("2")) {
							if (crs.getInt("customfield_length_min") > 0
									&& fieldvalue.length() < crs
											.getInt("customfield_length_min")) {
								Str.append("<br>Enter a minimum of ")
										.append(crs
												.getString("customfield_length_min"))
										.append(" Characters for ")
										.append(crs
												.getString("customfield_title"))
										.append("!");
							}
						}
						// / Maximum Length
						if (fieldvalue.length() > crs
								.getInt("customfield_length_max")) {
							fieldvalue = fieldvalue.substring(0,
									crs.getInt("customfield_length_max") - 1);
						}
						// / Check Unique Field
						if (!fieldvalue.equals("")
								&& crs.getString("customfield_unique").equals(
										"1")) {
							StrSql = "SELECT cftrans_id" + " FROM "
									+ compdb(comp_id) + "axela_cf_trans"
									+ " WHERE cftrans_submodule_id = "
									+ submodule_id
									+ " AND cftrans_customfield_id = "
									+ crs.getString("customfield_id")
									+ " AND cftrans_row_id != " + row_id + ""
									+ " AND cftrans_value = '" + fieldvalue
									+ "'";
							if (!ExecuteQuery(StrSql).equals("")) {
								Str.append("<br>")
										.append(crs
												.getString("customfield_title"))
										.append(" is not unique!");
							}
						}
					}
				}
			}
			return Str.toString();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
			return "";
		}
	}

	public void CustomFieldUpdate(String submodule_id, String row_id,
			String comp_id, String update, HttpServletRequest request)
			throws Exception {
		String fieldvalue = "";
		String emp_formatdate = GetSession("formatdate_name", request);
		String emp_formattime = GetSession("formattime_name", request);
		submodule_id = CNumeric(submodule_id);
		row_id = CNumeric(row_id);
		String StrSql = "";
		Connection conntx = null;
		Statement stmttx = null;
		CachedRowSet crs = null;
		if (!row_id.equals("0")) {
			StrSql = "DELETE FROM " + compdb(comp_id) + "axela_cf_trans"
					+ " WHERE cftrans_submodule_id = " + submodule_id + ""
					+ " AND cftrans_row_id = " + row_id + "";
			updateQuery(StrSql);

			if (PadQuotes(request.getParameter("customfieldsubmit")).equals(
					"yes")
					&& update.equals("yes")) {
				try {
					conntx = connectDB();
					conntx.setAutoCommit(false);
					stmttx = conntx.createStatement();

					StrSql = "SELECT customfield_id, customfield_title, customfield_cftype_id, customfield_numeric, customfield_length_min, customfield_length_max,"
							+ " customfield_option, customfield_unique, customfield_mandatory, customfield_instruction "
							+ " FROM "
							+ compdb(comp_id)
							+ "axela_cf"
							+ " WHERE customfield_active = 1 AND customfield_submodule_id = "
							+ submodule_id + " ORDER BY customfield_rank";
					// SOP("CustomFieldUpdate StrSql==="+StrSqlBreaker(StrSql));
					crs = processQuery(StrSql, 0);

					while (crs.next()) {
						// / Get Field Value
						fieldvalue = PadQuotes(request
								.getParameter("customfield_id-"
										+ (crs.getString("customfield_id"))));
						if (crs.getString("customfield_cftype_id").equals("3")) {
							if (fieldvalue.equals("on")) {
								fieldvalue = CheckBoxValue(PadQuotes(request
										.getParameter("customfield_id-"
												+ (crs.getString("customfield_id")))));
							}
						} else if (crs.getString("customfield_cftype_id")
								.equals("5")) {
							if (!fieldvalue.equals("")) {
								fieldvalue = formatDateStr(
										PadQuotes(request
												.getParameter("customfield_id-"
														+ (crs.getString("customfield_id")))),
										emp_formatdate);
							}
						} else if (crs.getString("customfield_cftype_id")
								.equals("6")) {
							if (!fieldvalue.equals("")) {
								fieldvalue = formatDateStr(
										PadQuotes(request
												.getParameter("customfield_id-"
														+ (crs.getString("customfield_id")))),
										emp_formatdate + " " + emp_formattime);
							}
						}
						StrSql = "INSERT INTO " + compdb(comp_id)
								+ "axela_cf_trans"
								+ " (cftrans_customfield_id,"
								+ " cftrans_submodule_id," + " cftrans_row_id,"
								+ " cftrans_value)" + " VALUES" + " ("
								+ crs.getString("customfield_id") + "," + " "
								+ submodule_id + "," + " " + row_id + ","
								+ " '" + fieldvalue + "')";
						// SOP("StrSql = " + StrSql);
						stmttx.addBatch(StrSql);
					}
					crs.close();
					stmttx.executeBatch();
					conntx.commit();

				} catch (Exception ex) {
					if (conntx.isClosed()) {
						SOPError("conn is closed.....");
					}
					if (!conntx.isClosed() && conntx != null) {
						conntx.rollback();
						SOPError(this.getClass().getName());
						SOPError("Error in "
								+ new Exception().getStackTrace()[0]
										.getMethodName() + ": " + ex);
					}
					// msg = "<br>Transaction Error!";
				} finally {
					stmttx.close();

					if (conntx != null && !conntx.isClosed()) {
						conntx.close();
					}
				}
			}
		}
	}

	// public void AppCustomFieldUpdate(String submodule_id, String row_id,
	// String comp_id, String update, HttpServletRequest request, JSONObject input)
	// throws Exception {
	// String fieldvalue = "";
	// String emp_formatdate = GetSession("formatdate_name", request);
	// String emp_formattime = GetSession("formattime_name", request);
	// submodule_id = CNumeric(submodule_id);
	// row_id = CNumeric(row_id);
	// String StrSql = "";
	// Connection conntx = null;
	// Statement stmttx = null;
	// CachedRowSet crs = null;
	// if (!row_id.equals("0")) {
	// StrSql = "DELETE FROM " + compdb(comp_id) + "axela_cf_trans"
	// + " WHERE cftrans_submodule_id = " + submodule_id + ""
	// + " AND cftrans_row_id = " + row_id + "";
	// updateQuery(StrSql);
	// try {
	// conntx = connectDB();
	// conntx.setAutoCommit(false);
	// stmttx = conntx.createStatement();
	//
	// StrSql = "SELECT customfield_id, customfield_title, customfield_cftype_id, customfield_numeric, customfield_length_min, customfield_length_max,"
	// + " customfield_option, customfield_unique, customfield_mandatory, customfield_instruction "
	// + " FROM "
	// + compdb(comp_id)
	// + "axela_cf"
	// + " WHERE customfield_active = 1 AND customfield_submodule_id = "
	// + submodule_id + " ORDER BY customfield_rank";
	// SOP("APPCustomFieldUpdate StrSql===" + StrSqlBreaker(StrSql));
	// crs = processQuery(StrSql, 0);
	//
	// while (crs.next()) {
	// // / Get Field Value
	// if (!input.isNull("customfield_id-" + (crs.getString("customfield_id")))) {
	// fieldvalue = PadQuotes(((String) input.get("customfield_id-" + (crs.getString("customfield_id")))));
	// }
	// if (crs.getString("customfield_cftype_id").equals("5")) {
	// if (!fieldvalue.equals("")) {
	// fieldvalue = convertShortDateToStr(fieldvalue);
	// }
	// } else if (crs.getString("customfield_cftype_id").equals("6")) {
	// if (!fieldvalue.equals("")) {
	// fieldvalue = convertLongDateToStr(fieldvalue);
	// }
	// }
	// SOP("=======fieldvalue ===" + StrSqlBreaker(StrSql));
	// StrSql = "INSERT INTO " + compdb(comp_id)
	// + "axela_cf_trans"
	// + " (cftrans_customfield_id,"
	// + " cftrans_submodule_id," + " cftrans_row_id,"
	// + " cftrans_value)" + " VALUES" + " ("
	// + crs.getString("customfield_id") + "," + " "
	// + submodule_id + "," + " " + row_id + ","
	// + " '" + fieldvalue + "')";
	// SOP("CustStrSql = " + StrSql);
	// stmttx.addBatch(StrSql);
	// }
	// crs.close();
	// stmttx.executeBatch();
	// conntx.commit();
	//
	// } catch (Exception ex) {
	// if (conntx.isClosed()) {
	// SOPError("conn is closed.....");
	// }
	// if (!conntx.isClosed() && conntx != null) {
	// conntx.rollback();
	// SOPError(this.getClass().getName());
	// SOPError("Error in "
	// + new Exception().getStackTrace()[0]
	// .getMethodName() + ": " + ex);
	// }
	// // msg = "<br>Transaction Error!";
	// } finally {
	// stmttx.close();
	//
	// if (conntx != null && !conntx.isClosed()) {
	// conntx.close();
	// }
	// }
	// }
	// }

	// public JSONObject AppCustomFieldupdateDash(String submodule_id, String name, String value, HttpServletRequest request, String oppr_id, JSONObject input) {
	//
	// String StrSql = "";
	// String comp_id = "";
	// String emp_id = "";
	// String emp_formatdate = GetSession("formatdate_name", request);
	// String emp_formattime = GetSession("formattime_name", request);
	// String history_oldvalue = "", history_actiontype = "", history_newvalue = "", msg = "";
	// Connection conntx = null;
	// Statement stmttx = null;
	// CachedRowSet crs = null;
	// if (!oppr_id.equals("0")) {
	// try {
	// comp_id = CNumeric(GetSession("comp_id", request));
	// emp_id = CNumeric(GetSession("emp_id", request));
	// conntx = connectDB();
	// conntx.setAutoCommit(false);
	// stmttx = conntx.createStatement();
	//
	// StrSql = "SELECT customfield_id, customfield_title, customfield_cftype_id, customfield_numeric, customfield_length_min, customfield_length_max,"
	// + " customfield_option, customfield_unique, customfield_mandatory, customfield_instruction "
	// + " FROM "
	// + compdb(comp_id)
	// + "axela_cf"
	// + " WHERE customfield_active = 1 AND customfield_submodule_id = "
	// + submodule_id + " ORDER BY customfield_rank";
	// SOP("CustomFieldUpdate StrSql===" + StrSqlBreaker(StrSql));
	// crs = processQuery(StrSql, 0);
	// if (crs.isBeforeFirst()) {
	// while (crs.next()) {
	// SOP("crs.getString======value====" + value);
	// SOP("crs.getString======name====" + name);
	// if (name.equals("customfield-" + (crs.getString("customfield_id")))) {
	// if (!value.equals("") || (crs.getString("customfield_mandatory").equals("0") && value.equals(""))) {
	// value = value.replaceAll("nbsp", "&");
	// if (crs.getString("customfield_cftype_id").equals("5")) {
	// if (!value.equals("")) {
	// value = formatDateStr(value, emp_formatdate);
	// }
	// } else if (crs.getString("customfield_cftype_id").equals("6")) {
	// if (!value.equals("")) {
	// value = formatDateStr(value, emp_formatdate + " " + emp_formattime);
	// }
	// }
	// SOP("name==========" + name);
	// SOP("value==========" + value); // /////////// FOR HISTORY OLD VALUE
	// // /////////// FOR HISTORY OLD VALUE
	// SOP("Select cftrans_value from "
	// + compdb(comp_id)
	// + "axela_cf_trans WHERE "
	// + " AND cftrans_customfield_id = "
	// + crs.getString("customfield_id"));
	// history_oldvalue = ExecuteQuery("Select cftrans_value from "
	// + compdb(comp_id)
	// + "axela_cf_trans WHERE 1=1"
	// + " AND cftrans_customfield_id = "
	// + crs.getString("customfield_id"));
	//
	// if (crs.getString("customfield_cftype_id").equals("5")) {
	// if (!history_oldvalue.equals("")) {
	// history_oldvalue = formatDate(history_oldvalue, emp_formatdate);
	// }
	// } else if (crs.getString("customfield_cftype_id").equals("6")) {
	// if (!history_oldvalue.equals("")) {
	// history_oldvalue = formatDate(history_oldvalue, emp_formatdate + " " + emp_formattime);
	// }
	// }
	//
	// StrSql = "DELETE FROM " + compdb(comp_id)
	// + "axela_cf_trans"
	// + " WHERE cftrans_submodule_id = "
	// + submodule_id + ""
	// + " AND cftrans_customfield_id = "
	// + crs.getString("customfield_id") + "";
	// SOP("StrSql delete= " + StrSql);
	// updateQuery(StrSql);
	// StrSql = "INSERT INTO " + compdb(comp_id)
	// + "axela_cf_trans"
	// + " (cftrans_customfield_id,"
	// + " cftrans_submodule_id,"
	// + " cftrans_value)" + " VALUES" + " ("
	// + crs.getString("customfield_id") + "," + " "
	// + submodule_id + ","
	// + " '" + value + "')";
	// SOP("StrSql =INSERT " + StrSql);
	// updateQuery(StrSql);
	//
	// // /////////// FOR HISTORY NEW VALUE
	// history_newvalue = "";
	// if (crs.getString("customfield_cftype_id").equals("5")) {
	// if (!value.equals("")) {
	// history_newvalue = formatDate(value, emp_formatdate);
	// }
	// } else if (crs.getString("customfield_cftype_id")
	// .equals("6")) {
	// if (!value.equals("")) {
	// history_newvalue = formatDate(value, emp_formatdate + " " + emp_formattime);
	// }
	// } else {
	// history_newvalue = value;
	// }
	//
	// history_actiontype = crs.getString("customfield_title");
	//
	// StrSql = "INSERT into "
	// + compdb(comp_id)
	// + "axela_sales_oppr_history"
	// + " (history_oppr_id,"
	// + " history_emp_id,"
	// + " history_datetime,"
	// + " history_actiontype,"
	// + " history_oldvalue,"
	// + " history_newvalue)"
	// + " values ("
	// + " '" + oppr_id + "','"
	// + emp_id
	// + "',"
	// + " "
	// + gettimebyzonesql(comp_id, toLongDate(kknow()))
	// + "," + " '" + history_actiontype + "'," + " '"
	// + history_oldvalue + "'," + " '"
	// + history_newvalue + "')";
	// SOP("StrSql====hist===" + StrSql);
	// updateQuery(StrSql);
	// msg = crs.getString("customfield_title")
	// + " updated!";
	// } else {
	// msg = "Enter " + crs.getString("customfield_title")
	// + "!";
	// }
	// input.put("msg", msg);
	// }
	// }
	// }
	// crs.close();
	// } catch (Exception ex) {
	// SOPError(this.getClass().getName());
	// SOPError("Error in "
	// + new Exception().getStackTrace()[0].getMethodName() + ": "
	// + ex);
	// } finally {
	// return input;
	// }
	// }
	// return input;
	// }

	public String CRMCustomFieldView(String comp_id, String crm_id,
			String colspan, HttpServletRequest request) {
		StringBuilder Str = new StringBuilder();
		String fieldvalue = "";
		CachedRowSet crs = null;
		try {
			String StrSql = "SELECT crmcf_id, crmcf_title, crmcf_cftype_id,"
					+ " crmcf_numeric, crmcf_length_min, crmcf_length_max,"
					+ " crmcf_option, crmcf_unique, crmcf_mandatory, crmcf_instruction, crmcf_voc,"
					+ " crmcf_fieldref, COALESCE(crmcftrans_value, '') as crmcftransvalue, COALESCE(crmcftrans_value, '') AS crmcftrans_value,"
					+ " COALESCE(crmcftrans_voc, '') AS crmcftrans_voc,"
					+ " crm_oppr_id, crm_so_id"
					+ " FROM " + compdb(comp_id) + "axela_sales_crm"
					+ " INNER JOIN " + compdb(comp_id) + "axela_sales_crmdays ON crmdays_id = crm_crmdays_id"
					+ " INNER JOIN " + compdb(comp_id) + "axela_sales_crm_cf ON crmcf_crmdays_id = crmdays_id"
					+ " LEFT JOIN " + compdb(comp_id) + "axela_sales_crm_trans ON crmcftrans_crmcf_id = crmcf_id"
					// + " LEFT JOIN " + compdb(comp_id) +
					// "axela_sales_oppr ON oppr_id = crm_oppr_id"
					+ " AND crmcftrans_crm_id = " + crm_id + ""
					+ " WHERE crmcf_active = 1 AND crm_id = " + crm_id + ""
					+ " GROUP BY crmcf_id" + " ORDER BY crmcf_rank";
			// SOP("CRMCustomFieldView---------in connect class------" + StrSqlBreaker(StrSql));
			crs = processQuery(StrSql, 0);

			if (crs.isBeforeFirst()) {
				while (crs.next()) {
					// / Get Field Value
					if (PadQuotes(request.getParameter("customfieldsubmit")).equals("yes")) {
						fieldvalue = PadQuotes(request.getParameter("crmcf_id-" + (crs.getString("crmcf_id"))));
						if (crs.getString("crmcf_cftype_id").equals("3")) {
							if (fieldvalue.equals("on")) {
								fieldvalue = CheckBoxValue(PadQuotes(request.getParameter("crmcf_id-" + (crs.getString("crmcf_id")))));
							}
						}
					} else {
						if (crs.getString("crmcftransvalue") != null && !crs.getString("crmcf_fieldref").equals(""))
							fieldvalue = ReturnFieldRef(comp_id, crs.getString("crmcf_fieldref"), crs.getString("crm_oppr_id"), crs.getString("crm_so_id"));
						else
							fieldvalue = crs.getString("crmcftrans_value");
						if (crs.getString("crmcf_cftype_id").equals("5")) {
							if (!fieldvalue.equals("")) {
								fieldvalue = strToShortDate(new SimpleDateFormat("dd/MM/yyyy").parse(fieldvalue));
							}
						} else if (crs.getString("crmcf_cftype_id").equals("6")) {
							if (!fieldvalue.equals("")) {
								fieldvalue = strToLongDate(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(fieldvalue));
							}
						}
					}
					Str.append("<div class=form-group>");
					Str.append("<label class=\"control-label col-md-4\">").append(crs.getString("crmcf_title"));
					if (crs.getString("crmcf_mandatory").equals("1")) {
						Str.append("<font color=\"#ff0000\">*</font>");
					}
					Str.append(":</label>");
					Str.append("<div class=\"col-md-6 col-xs-12\">");
					// Str.append("<td valign=top align=left");
					// if (!colspan.equals("0")) {
					// Str.append(" colspan=").append(colspan);
					// }
					// Str.append(">\n");

					// / Start Form Fields
					// / Start Text Field
					if (crs.getString("crmcf_cftype_id").equals("1")) {
						// Str.append("<input name=crmcf_id-").append(crs.getString("crmcf_id")).append(" id=crmcf_id-").append(crs.getString("crmcf_id"));
						// Str.append(" type=text class=form-control size=50 maxlength=").append(crs.getString("crmcf_length_max"));
						// Str.append(" value=\"").append(fieldvalue).append("\"");
						// if (crs.getString("crmcf_numeric").equals("1")) {
						// Str.append(" onKeyUp=\"toInteger('crmcf_id-").append(crs.getString("crmcf_id")).append("','custom')\"");
						// }
						// Str.append("/>");

						Str.append("<input name=crmcf_id-").append(crs.getString("crmcf_id")).append(" id=crmcf_id-").append(crs.getString("crmcf_id"));
						Str.append(" type=text class=form-control size=50 maxlength=").append(crs.getString("crmcf_length_max"));
						Str.append(" value=\"").append(fieldvalue).append("\"");
						if (crs.getString("crmcf_numeric").equals("1")) {
							Str.append(" onKeyUp=\"toInteger('crmcf_id-").append(crs.getString("crmcf_id")).append("','custom')\"");
						}
						Str.append("/>");
					} // / End Text Field
						// / Start Text Area
					else if (crs.getString("crmcf_cftype_id").equals("2")) {
						Str.append("<textarea name=crmcf_id-").append(crs.getString("crmcf_id")).append(" id=crmcf_id-").append(crs.getString("crmcf_id"));
						Str.append(" cols=\"70\" rows=\"5\" class=\"form-control\" onKeyUp=\"charcount('").append("crmcf_id-").append(crs.getString("crmcf_id"));
						Str.append("', 'span_crmcf_id-").append(crs.getString("crmcf_id"));
						Str.append("','<font color=red>({CHAR} characters left)</font>',").append(crs.getString("crmcf_length_max"));
						Str.append(")\">").append(fieldvalue).append("</textarea>");
						Str.append(" <span id=\"span_crmcf_id-").append(crs.getString("crmcf_id")).append("\"> (").append(crs.getString("crmcf_length_max")).append(" Characters)</span>");
					} // / End Text Area
						// / Start Check Box
					else if (crs.getString("crmcf_cftype_id").equals("3")) {
						Str.append("<input id=crmcf_id-").append(crs.getString("crmcf_id")).append(" type=\"checkbox\"");
						Str.append(" name=crmcf_id-").append(crs.getString("crmcf_id")).append(" ").append(PopulateCheck(fieldvalue)).append("/>");
					} // / End Check Box
						// / Start Drop Down
					else if (crs.getString("crmcf_cftype_id").equals("4")) {
						Str.append("<select name=crmcf_id-").append(crs.getString("crmcf_id")).append(" id=crmcf_id-").append(crs.getString("crmcf_id"));
						Str.append(" class=form-control>\n");
						String[] option = crs.getString("crmcf_option").split("\\r\\n");
						Str.append("<option value=\"\">Select</option>\n");
						for (int i = 1; i <= option.length; i++) {
							Str.append("<option" + " value=\"").append(option[i - 1]).append("\" ");
							Str.append(StrSelectdrop(option[i - 1], fieldvalue));
							Str.append(">").append(option[i - 1]).append("</option>\n");
						}
						Str.append("</select>");
						// SOP("Str--------" + Str.toString());
					} // / End Drop Down
						// / Start Date Text Box
					else if (crs.getString("crmcf_cftype_id").equals("5")) {
						// / Start Jquery Date Picker Function
						// SOP("dp 333");
						Str.append("<script type=text/javascript>\n");
						Str.append("$(function()").append("{\n");
						Str.append("$('").append("#crmcf_id-").append(crs.getString("crmcf_id")).append("')").append(".datepicker({\n");
						Str.append("showButtonPanel: true,\n");
						Str.append("dateFormat: ").append("'").append("dd/mm/yy").append("'\n");
						Str.append("});\n");
						Str.append("});\n");
						Str.append("</script>\n");
						// / End Jquery Date Picker Function
						Str.append("<input name=crmcf_id-")
								.append(crs.getString("crmcf_id")).append(" id=crmcf_id-").append(crs.getString("crmcf_id"));
						Str.append(" type=text class=\"form-control datepicker\" size=12 maxlength=10");
						Str.append(" value=\"").append(fieldvalue).append("\"").append(" value=\"\"");
						Str.append("/>");
					} // / End Date Text Box
						// / Start DateTime Text Box
					else if (crs.getString("crmcf_cftype_id").equals("6")) {
						// / Start Jquery DateTime Picker Function
						Str.append("<script type=text/javascript>\n");
						Str.append("$(function()").append("{\n");
						Str.append("$('").append("#crmcf_id-").append(crs.getString("crmcf_id")).append("')").append(".datetimepicker({\n");
						Str.append("showButtonPanel: true,\n");
						Str.append("dateFormat: ").append("'").append("dd/mm/yy").append("',\n");
						Str.append("timeFormat: ").append("'").append("HH:mm").append("'\n");
						Str.append("});\n");
						Str.append("});\n");
						Str.append("</script>\n");
						// / End Jquery DateTime Picker Function
						Str.append("<input name=crmcf_id-")
								.append(crs.getString("crmcf_id")).append(" id=crmcf_id-").append(crs.getString("crmcf_id"));
						Str.append(" type=text class=\"form-control date form_datetime\" size=18 maxlength=16");
						Str.append(" value=\"").append(fieldvalue).append("\"").append("data-date-format=\"dd/mm/yyyy HH:mm\" value=\"\"");
						Str.append("/>");
					} // / End DateTime Text Box
						// / Start Time Text Box
					else if (crs.getString("crmcf_cftype_id").equals("7")) {
						// / Start Jquery Time Picker Function
						Str.append("<script type=text/javascript>\n");
						Str.append("$(function()").append("{\n");
						Str.append("$('").append("#crmcf_id-").append(crs.getString("crmcf_id")).append("')").append(".timepicker({\n");
						Str.append("showButtonPanel: true,\n");
						// Str.append("dateFormat: ").append("'hh:mm'\n");
						Str.append("});\n");
						Str.append("});\n");
						Str.append("</script>\n");
						// / End Jquery Time Picker Function
						Str.append("<input name=crmcf_id-").append(crs.getString("crmcf_id")).append(" id=crmcf_id-").append(crs.getString("crmcf_id"));
						Str.append(" type=text class=form-control size=7 maxlength=5");
						Str.append(" value=\"").append(fieldvalue).append("\"");
						Str.append("/>");
					}
					// / End Time Text Box
					// / End Form Fields
					if (!crs.getString("crmcf_instruction").equals("")) {
						Str.append("<br>").append(crs.getString("crmcf_instruction"));
					}
					// // Display Voc
					if (crs.getString("crmcf_voc").equals("1")) {
						Str.append("<br>VOC:<textarea name=crmcftrans_voc-").append(crs.getString("crmcf_id")).append(" id=crmcftrans_voc-").append(crs.getString("crmcf_id"));
						Str.append(" cols=\"70\" rows=\"5\" class=\"form-control\" onKeyUp=\"charcount('").append("crmcftrans_voc-").append(crs.getString("crmcf_id"));
						Str.append("', 'span_crmcftrans_voc-").append(crs.getString("crmcf_id"));
						Str.append("','<font color=red>({CHAR} characters left)</font>',8000)\">").append(crs.getString("crmcftrans_voc")).append("</textarea>");
						Str.append(" <span id=\"span_crmcftrans_voc-").append(crs.getString("crmcf_id")).append("\"> (8000 Characters)</span>");
					}
					Str.append("</div>");
					Str.append("</div>");
					// Str.append("</td>\n");
					// Str.append("</tr>\n");
				}
				Str.append("<input type=hidden name=customfieldsubmit value=yes>\n");
				// Str.append("</table>\n");
			}
			crs.close();
			return Str.toString();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
			return "";
		}
	}

	// public JSONObject AppCRMCustomFieldView(String comp_id, String crm_id, HttpServletRequest request, JSONObject input) {
	// String fieldvalue = "";
	// String crmcf_option = "";
	// String[] option = null;
	// CachedRowSet crs = null;
	// ArrayList<String> list = new ArrayList<String>();
	// Map<String, String> map = new HashMap<String, String>();
	// Gson gson = new Gson();
	// try {
	// String StrSql = "SELECT crmcf_id, crmcf_title, crmcf_cftype_id,"
	// + " crmcf_numeric, crmcf_length_min, crmcf_length_max,"
	// + " crmcf_option, crmcf_unique, crmcf_mandatory, crmcf_instruction, crmcf_voc,"
	// + " crmcf_fieldref, COALESCE(crmcftrans_value, '') as crmcftransvalue, COALESCE(crmcftrans_value, '') AS crmcftrans_value,"
	// + " COALESCE(crmcftrans_voc, '') AS crmcftrans_voc,"
	// + " crm_oppr_id, crm_so_id"
	// + " FROM " + compdb(comp_id) + "axela_sales_crm"
	// + " INNER JOIN " + compdb(comp_id) + "axela_sales_crmdays ON crmdays_id = crm_crmdays_id"
	// + " INNER JOIN " + compdb(comp_id) + "axela_sales_crm_cf ON crmcf_crmdays_id = crmdays_id"
	// + " LEFT JOIN " + compdb(comp_id) + "axela_sales_crm_trans ON crmcftrans_crmcf_id = crmcf_id"
	// // + " LEFT JOIN " + compdb(comp_id) +
	// // "axela_sales_oppr ON oppr_id = crm_oppr_id"
	// + " AND crmcftrans_crm_id = " + crm_id + ""
	// + " WHERE crmcf_active = 1 AND crm_id = " + crm_id + ""
	// + " GROUP BY crmcf_id" + " ORDER BY crmcf_rank";
	// SOP("CRMCustomFieldView---------in connect class------" + StrSqlBreaker(StrSql));
	// crs = processQuery(StrSql, 0);
	//
	// if (crs.isBeforeFirst()) {
	// while (crs.next()) {
	// map.put("crmcf_id", crs.getString("crmcf_id"));
	// map.put("crmcf_title", crs.getString("crmcf_title"));
	// map.put("crmcf_numeric", crs.getString("crmcf_numeric"));
	// map.put("crmcf_length_min", crs.getString("crmcf_length_min"));
	// map.put("crmcf_length_max", crs.getString("crmcf_length_max"));
	// map.put("crmcf_cftype_id", crs.getString("crmcf_cftype_id"));
	// map.put("crmcf_option", crs.getString("crmcf_option"));
	// map.put("crmcf_unique", crs.getString("crmcf_unique"));
	// map.put("crmcf_mandatory", crs.getString("crmcf_mandatory"));
	// map.put("crmcf_instruction", crs.getString("crmcf_instruction"));
	// map.put("crmcf_voc", crs.getString("crmcf_voc"));
	// map.put("crmcf_fieldref", crs.getString("crmcf_fieldref"));
	// map.put("crmcftransvalue", crs.getString("crmcftransvalue"));
	// map.put("crmcftrans_value", crs.getString("crmcftrans_value"));
	// map.put("crmcftrans_voc", crs.getString("crmcftrans_voc"));
	// map.put("crm_oppr_id", crs.getString("crm_oppr_id"));
	// map.put("crm_so_id", crs.getString("crm_so_id"));
	// fieldvalue = crs.getString("crmcftrans_value");
	//
	// if (crs.getString("crmcf_cftype_id").equals("5")) {
	// fieldvalue = strToShortDate(fieldvalue);
	// }
	// if (crs.getString("crmcf_cftype_id").equals("6")) {
	// fieldvalue = strToLongDate(fieldvalue);
	// }
	// // Drop down
	// if (crs.getString("crmcf_cftype_id").equals("4")) {
	// option = crs.getString("crmcf_option").split("\\r\\n");
	// for (int i = 0; i < option.length; i++) {
	// crmcf_option += option[i] + "/";
	// }
	// }
	// map.put("customfield_option", crmcf_option);
	// map.put("fieldvalue", fieldvalue);
	// }
	// }
	// crs.close();
	// } catch (Exception ex) {
	// SOPError(this.getClass().getName());
	// SOPError("Error in " + new Exception().getStackTrace()[0].getMethodName() + ": " + ex);
	// }
	// return input;
	// }

	public void CRMCustomFieldUpdate(String comp_id, String crm_id,
			String update, HttpServletRequest request) throws Exception {
		String fieldvalue = "";
		String fieldvoc = "";
		// String emp_formatdate = GetSession("formatdate_name", request);
		// String emp_formattime = GetSession("formattime_name", request);
		crm_id = CNumeric(crm_id);
		String StrSql = "";
		Connection conntx = null;
		Statement stmttx = null;
		CachedRowSet crs = null;
		if (!crm_id.equals("0")) {
			StrSql = "DELETE FROM " + compdb(comp_id) + "axela_sales_crm_trans"
					+ " WHERE crmcftrans_crm_id = " + crm_id + "";
			updateQuery(StrSql);

			if (PadQuotes(request.getParameter("customfieldsubmit")).equals(
					"yes")
					&& update.equals("yes")) {
				try {
					conntx = connectDB();
					conntx.setAutoCommit(false);
					stmttx = conntx.createStatement();

					StrSql = "SELECT crmcf_id, crmcf_title, crmcf_cftype_id, crmcf_numeric, crmcf_length_min, crmcf_length_max,"
							+ " crmcf_option, crmcf_unique, crmcf_mandatory, crmcf_voc, crmcf_instruction, crm_oppr_id "
							+ " FROM " + compdb(comp_id) + "axela_sales_crm"
							+ " INNER JOIN " + compdb(comp_id) + "axela_sales_crmdays ON crmdays_id = crm_crmdays_id"
							+ " INNER JOIN " + compdb(comp_id) + "axela_sales_crm_cf ON crmcf_crmdays_id = crmdays_id"
							+ " WHERE crmcf_active = 1"
							+ " AND crm_id = " + crm_id + ""
							+ " GROUP BY crmcf_id"
							+ " ORDER BY crmcf_rank";
					// SOPError("CustomFieldUpdate StrSql==="+StrSqlBreaker(StrSql));
					crs = processQuery(StrSql, 0);

					while (crs.next()) {
						// / Get Field Value
						fieldvalue = PadQuotes(request.getParameter("crmcf_id-" + (crs.getString("crmcf_id"))));

						fieldvoc = PadQuotes(request.getParameter("crmcftrans_voc-" + (crs.getString("crmcf_id"))));
						if (crs.getString("crmcf_cftype_id").equals("3")) {
							if (fieldvalue.equals("on")) {
								fieldvalue = CheckBoxValue(PadQuotes(request.getParameter("crmcf_id-" + (crs.getString("crmcf_id")))));
							}
						} else if (crs.getString("crmcf_cftype_id").equals("5")) {
							if (!fieldvalue.equals("")) {
								fieldvalue = convertShortDateToStr(PadQuotes(request.getParameter("crmcf_id-" + (crs.getString("crmcf_id")))));
							}
						} else if (crs.getString("crmcf_cftype_id").equals("6")) {
							if (!fieldvalue.equals("")) {
								fieldvalue = convertLongDateToStr((PadQuotes(request.getParameter("crmcf_id-" + (crs.getString("crmcf_id"))))));
							}
						}

						// SOP("fieldvalue====="+fieldvalue);
						StrSql = "INSERT INTO " + compdb(comp_id) + "axela_sales_crm_trans"
								+ " (crmcftrans_crmcf_id,"
								+ " crmcftrans_crm_id,"
								+ " crmcftrans_value,"
								+ " crmcftrans_voc)"
								+ " VALUES"
								+ " ("
								+ crs.getString("crmcf_id") + ","
								+ " " + crm_id + ","
								+ " '" + fieldvalue + "', "
								+ " '" + fieldvoc + "')";
						// SOP("StrSql===ssss = " + StrSql);
						stmttx.addBatch(StrSql);
					}
					crs.close();
					stmttx.executeBatch();
					conntx.commit();

				} catch (Exception ex) {
					if (conntx.isClosed()) {
						SOPError("conn is closed.....");
					}
					if (!conntx.isClosed() && conntx != null) {
						conntx.rollback();
						SOPError(this.getClass().getName());
						SOPError("Error in "
								+ new Exception().getStackTrace()[0]
										.getMethodName() + ": " + ex);
					}
					// msg = "<br>Transaction Error!";
				} finally {
					conntx.setAutoCommit(true);
					stmttx.close();
					if (conntx != null && !conntx.isClosed()) {
						conntx.close();
					}
				}
			}
		}
	}

	public String CRMCustomFieldValidate(String comp_id, String crm_id,
			String colspan, HttpServletRequest request) {
		StringBuilder Str = new StringBuilder();
		String fieldvalue = "";
		String fieldvoc = "";
		crm_id = CNumeric(crm_id);
		CachedRowSet crs = null;
		try {
			String StrSql = "SELECT crmcf_id, crmcf_title, crmcf_cftype_id,"
					+ " crmcf_numeric, crmcf_length_min, crmcf_length_max, crmcf_voc,"
					+ " crmcf_option, crmcf_unique, crmcf_mandatory"
					+ " FROM " + compdb(comp_id) + "axela_sales_crm"
					+ " INNER JOIN " + compdb(comp_id) + "axela_sales_crmdays ON crmdays_id = crm_crmdays_id"
					+ " INNER JOIN " + compdb(comp_id) + "axela_sales_crm_cf ON crmcf_crmdays_id = crmdays_id"
					+ " LEFT JOIN " + compdb(comp_id) + "axela_sales_crm_trans ON crmcftrans_crmcf_id = crmcf_id"
					+ " AND crmcftrans_crm_id = " + crm_id + ""
					+ " WHERE crmcf_active = 1" + " AND crm_id = " + crm_id
					+ "" + " GROUP BY crmcf_id " + " ORDER BY crmcf_rank";
			// SOP("StrSql===cf==" + StrSql);
			crs = processQuery(StrSql, 0);
			if (crs.isBeforeFirst()) {

				while (crs.next()) {
					// / Get Field Value
					if (PadQuotes(request.getParameter("customfieldsubmit")).equals("yes")) {
						fieldvalue = PadQuotes(request.getParameter("crmcf_id-" + (crs.getString("crmcf_id"))));
						fieldvoc = PadQuotes(request.getParameter("crmcftrans_voc-" + (crs.getString("crmcf_id"))));
						if (crs.getString("crmcf_cftype_id").equals("3")) {
							if (fieldvalue.equals("on")) {
								fieldvalue = CheckBoxValue(PadQuotes(request.getParameter("crmcf_id-" + (crs.getString("crmcf_id")))));
							}
						}
						// SOPError("fieldvalue = " + fieldvalue);
						if (fieldvalue.equals("") && crs.getString("crmcf_mandatory").equals("1")) {
							// / For Text Field AND Text Area
							if (crs.getString("crmcf_cftype_id").equals("1") || crs.getString("crmcf_cftype_id").equals("2")) {
								Str.append("<br>").append(crs.getString("crmcf_title")).append(" is blank!");
							}
							// / For Drop Down AND Date Time
							if (crs.getString("crmcf_cftype_id").equals("4") || crs.getString("crmcf_cftype_id").equals("5") || crs.getString("crmcf_cftype_id").equals("6")
									|| crs.getString("crmcf_cftype_id").equals("7")) {
								Str.append("<br>Select ").append(crs.getString("crmcf_title")).append("!");
							}
						}
						// / For Date
						if (!fieldvalue.equals("") && crs.getString("crmcf_cftype_id").equals("5")) {
							if (!isValidDateFormatLong(fieldvalue)) {
								Str.append("<br>Enter Valid ").append(crs.getString("crmcf_title")).append("!");
							}
						}
						// / For Date Time
						if (!fieldvalue.equals("") && crs.getString("crmcf_cftype_id").equals("6")) {
							if (!isValidDateFormatLong(fieldvalue)) {
								Str.append("<br>Enter Valid ").append(crs.getString("crmcf_title")).append("!");
							}
						}
						// / Minimum Length
						// / For Text Field AND Text Area
						if (crs.getString("crmcf_cftype_id").equals("1") || crs.getString("crmcf_cftype_id").equals("2")) {
							if (crs.getInt("crmcf_length_min") > 0 && fieldvalue.length() < crs.getInt("crmcf_length_min")) {
								Str.append("<br>Enter a minimum of ").append(crs.getString("crmcf_length_min")).append(" Characters for ").append(crs.getString("crmcf_title")).append("!");
							}
						}
						// For voc text field
						if ((crs.getString("crmcf_cftype_id").equals("1") || crs.getString("crmcf_cftype_id").equals("2")) && crs.getString("crmcf_voc").equals("1")) {
							if (crs.getInt("crmcf_length_min") > 0 && fieldvoc.length() < crs.getInt("crmcf_length_min")) {
								Str.append("<br>Enter a minimum of voc ").append(crs.getString("crmcf_length_min")).append(" Characters for ").append(crs.getString("crmcf_title")).append("!");
							}
						}
						// / Maximum Length
						if (fieldvalue.length() > crs.getInt("crmcf_length_max")) {
							fieldvalue = fieldvalue.substring(0, crs.getInt("crmcf_length_max") - 1);
						}
						// / Check Unique Field
						if (!fieldvalue.equals("") && crs.getString("crmcf_unique").equals("1")) {
							StrSql = "SELECT cftrans_id" + " FROM " + "" + compdb(comp_id) + "axela_sales_crm_trans"
									+ " WHERE cftrans_crmcf_id = " + crs.getString("crmcf_id")
									+ " AND cftrans_value = '" + fieldvalue + "'";
							if (!ExecuteQuery(StrSql).equals("")) {
								Str.append("<br>").append(crs.getString("crmcf_title")).append(" is not unique!");
							}
						}
					}
				}
			}
			crs.close();
			return Str.toString();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
			return "";
		}
	}

	public String ReturnFieldRef(String comp_id, String crmcf_fieldref,
			String oppr_id, String voucher_id) {
		String StrSql = "", crmcffieldref = "";
		StrSql = "SELECT COALESCE(" + crmcf_fieldref + ",'')"
				+ " FROM " + compdb(comp_id) + "axela_sales_oppr"
				+ " INNER JOIN " + compdb(comp_id) + "axela_customer ON customer_id = oppr_customer_id"
				+ " INNER JOIN " + compdb(comp_id) + "axela_customer_contact ON contact_id = oppr_contact_id"
				// + " LEFT JOIN " + compdb(comp_id) + "axela_sales_quote ON quote_oppr_id = oppr_id"
				+ " LEFT JOIN " + compdb(comp_id) + "axela_acc_voucher ON voucher_oppr_id = oppr_id"
				+ " LEFT JOIN " + compdb(comp_id) + "axela_inventory_item_model ON model_id = oppr_model_id"
				+ " LEFT JOIN " + compdb(comp_id) + "axela_inventory_item ON item_id = oppr_item_id"
				// + " LEFT JOIN " + compdb(comp_id) + "axela_sales_oppr_add_buyertype ON buyertype_id = oppr_buyertype_id "
				+ " WHERE 1=1" + " AND oppr_id = " + oppr_id + "";
		// SOP("StrSql---ReturnFieldRef------" + StrSql);
		if (!voucher_id.equals("0")) {
			StrSql += " AND voucher_id = " + voucher_id + "";
		}
		StrSql += " GROUP BY oppr_id" + " LIMIT 1";
		crmcffieldref = ExecuteQuery(StrSql);
		return crmcffieldref;
	}

	public String ClickToCall(String callno, String comp_id) {
		String checkno = "";
		// SOP("comp_id-------------" + comp_id);
		if (comp_id.equals("1009")) {
			callno = callno.replace("-", "");
			// checkno = "<a href=\"javascript:clicktocall_1009("
			// + checkno
			// +
			// ");\" title=\"Click To Call\"><img src=\"../admin-ifx/icon-phone.png\" align=\"bottom\"></a>";
			checkno = "&nbsp;<a href=\"../portal/clicktocall-1009.jsp?callno=" + callno + "\" data-target=\"#Hintclicktocall\" data-toggle=\"modal\">"
					+ "<img src=\"../admin-ifx/icon-phone.png\" align=\"bottom\"></a>";
		}
		return checkno;
	}

	// ////FOR DISPLAYING IN DASH PAGE
	public String CustomFieldViewDash(String submodule_id, String row_id,
			String colspan, String comp_id, HttpServletRequest request) {
		StringBuilder Str = new StringBuilder();
		String emp_formatdate = GetSession("formatdate_name", request);
		String formatdate_datepicker = GetSession("formatdate_datepicker",
				request);
		String formattime_timepicker = GetSession("formattime_timepicker",
				request);
		String emp_formattime = GetSession("formattime_name", request);
		String fieldvalue = "";
		submodule_id = CNumeric(submodule_id);
		row_id = CNumeric(row_id);
		CachedRowSet crs = null;
		try {
			String StrSql = "SELECT customfield_id, customfield_title, customfield_cftype_id,"
					+ " customfield_numeric, customfield_length_min, customfield_length_max,"
					+ " customfield_option, customfield_unique, customfield_mandatory, customfield_instruction,"
					+ " COALESCE(cftrans_row_id, 0) AS cftrans_row_id, COALESCE(cftrans_value, '') AS cftrans_value"
					+ " FROM "
					+ compdb(comp_id)
					+ "axela_cf"
					+ " LEFT JOIN "
					+ compdb(comp_id)
					+ "axela_cf_trans ON cftrans_customfield_id = customfield_id"
					+ " AND cftrans_row_id = "
					+ row_id
					+ ""
					+ " WHERE customfield_active = 1"
					+ " AND customfield_submodule_id = "
					+ submodule_id
					+ " ORDER BY customfield_rank";
			SOP("StrSql = " + StrSql);
			crs = processQuery(StrSql, 0);

			if (crs.isBeforeFirst()) {
				while (crs.next()) {
					// / Get Field Value
					if (PadQuotes(request.getParameter("customfieldsubmit"))
							.equals("yes")) {
						fieldvalue = PadQuotes(request
								.getParameter("customfield_id-"
										+ (crs.getString("customfield_id"))));
						if (crs.getString("customfield_cftype_id").equals("3")) {

							if (fieldvalue.equals("on")) {
								fieldvalue = CheckBoxValue(PadQuotes(request
										.getParameter("customfield_id-"
												+ (crs.getString("customfield_id")))));
							}
						}
					} else {
						fieldvalue = crs.getString("cftrans_value");
						if (crs.getString("customfield_cftype_id").equals("3")) {
							if (fieldvalue.equals("on")) {
								fieldvalue = CheckBoxValue(PadQuotes(request
										.getParameter("customfield_id-"
												+ (crs.getString("customfield_id")))));
							}
						} else if (crs.getString("customfield_cftype_id")
								.equals("5")) {
							if (!fieldvalue.equals("")) {
								fieldvalue = formatDate(fieldvalue,
										emp_formatdate);
							}
						} else if (crs.getString("customfield_cftype_id")
								.equals("6")) {
							if (!fieldvalue.equals("")) {
								fieldvalue = formatDate(fieldvalue,
										emp_formatdate + " " + emp_formattime);
							}
						}
					}
					Str.append("<div class=\"form-element6\"><label>");
					Str.append(crs.getString("customfield_title"));
					if (crs.getString("customfield_mandatory").equals("1")) {
						Str.append("<font color=\"#ff0000\">*</font>");
					}
					Str.append(":&nbsp;</label>\n");
					// Str.append("<div class=\"form-element6\" >");
					// if (!colspan.equals("0")) {
					// Str.append(" colspan=").append(colspan);
					// }
					// Str.append(">\n");
					// / Start Form Fields
					// / Start Text Field
					if (crs.getString("customfield_cftype_id").equals("1")) {
						Str.append("<input name=customfield_id-")
								.append(crs.getString("customfield_id"))
								.append(" id=customfield_id-")
								.append(crs.getString("customfield_id"));
						Str.append(
								" type=text class=form-control size=50 maxlength=")
								.append(crs.getString("customfield_length_max"));
						Str.append(" value=\"").append(fieldvalue).append("\"");
						if (crs.getString("customfield_numeric").equals("1")) {
							Str.append(" onKeyUp=\"toInteger('customfield_id-")
									.append(crs.getString("customfield_id"))
									.append("','custom');\"");
						}
						Str.append(" onchange=\"SecurityCheck('customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("',this,'hint_customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("')\"");

						Str.append("/>");
						Str.append(
								"<div class=\"hint\" id=hint_customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("></div>");
					} // / End Text Field
						// / Start Text Area
					else if (crs.getString("customfield_cftype_id").equals("2")) {
						Str.append("<textarea name=customfield_id-")
								.append(crs.getString("customfield_id"))
								.append(" id=customfield_id-")
								.append(crs.getString("customfield_id"));
						Str.append(
								" cols=\"70\" rows=\"5\" class=\"form-control\" onKeyUp=\"charcount('")
								.append("customfield_id-")
								.append(crs.getString("customfield_id"));
						Str.append("', 'span_customfield_id-").append(
								crs.getString("customfield_id"));
						Str.append(
								"','<font color=red>({CHAR} characters left)</font>',")
								.append(crs.getString("customfield_length_max"));
						Str.append(")\"");
						Str.append(" onchange=\"SecurityCheck('customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("',this,'hint_customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("')\"");
						Str.append(">").append(fieldvalue)
								.append("</textarea>");

						Str.append(" <span id=\"span_customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("\"> (")
								.append(crs.getString("customfield_length_max"))
								.append(" Characters)</span>");
						Str.append(
								"<div class=\"hint\" id=hint_customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("></div>");
					} // / End Text Area
						// / Start Check Box
					else if (crs.getString("customfield_cftype_id").equals("3")) {
						Str.append("<div class=\"txt-align\"><input id=customfield_id-")
								.append(crs.getString("customfield_id"))
								.append(" type=\"checkbox\"");
						Str.append(" name=customfield_id-")
								.append(crs.getString("customfield_id"))
								.append(" ").append(PopulateCheck(fieldvalue));
						Str.append(" onClick=\"SecurityCheck('customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("',this,'hint_customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("')\"");
						Str.append("/></div");
						Str.append(
								"<div class=\"hint\" id=hint_customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("></div>");
					} // / End Check Box
						// / Start Drop Down

					else if (crs.getString("customfield_cftype_id").equals("4") || crs.getString("customfield_cftype_id").equals("1")) {
						Str.append("<select name=customfield_id-")
								.append(crs.getString("customfield_id"))
								.append(" id=customfield_id-")
								.append(crs.getString("customfield_id"));
						Str.append(" class=form-control");
						Str.append(" onchange=\"SecurityCheck('customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("',this,'hint_customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("')\"");
						Str.append(">\n");
						String[] option = crs.getString("customfield_option")
								.split("\\r\\n");
						Str.append("<option value=\"\">Select</option>\n");
						for (int i = 1; i <= option.length; i++) {
							Str.append("<option" + " value=\"")
									.append(option[i - 1]).append("\" ");
							Str.append(StrSelectdrop(option[i - 1], fieldvalue));
							Str.append(">").append(option[i - 1])
									.append("</option>\n");
						}
						Str.append("</select>");
						Str.append(
								"<div class=\"hint\" id=hint_customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("></div>");
					} // / End Drop Down
						// / Start Date Text Box
					else if (crs.getString("customfield_cftype_id").equals("5")) {
						// / Start Jquery Date Picker Function
						// Str.append("<script type=text/javascript>\n");
						// Str.append("$(function()").append("{\n");
						// Str.append("$('").append("#customfield_id-")
						// .append(crs.getString("customfield_id"))
						// .append("')").append(".datepicker({\n");
						// Str.append("showButtonPanel: true,\n");
						// Str.append("dateFormat: ").append("'")
						// .append(formatdate_datepicker).append("'\n");
						// Str.append("});\n");
						// Str.append("});\n");
						// Str.append("</script>\n");
						// / End Jquery Date Picker Function
						Str.append("<input name=customfield_id-")
								.append(crs.getString("customfield_id"))
								.append(" id=customfield_id-")
								.append(crs.getString("customfield_id"));
						Str.append(" type=text class='form-control customfield-date1 datepicker ' size=12 maxlength=10");
						Str.append(" value=\"").append(fieldvalue).append("\"");
						Str.append(" onchange=\"SecurityCheck('customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("',this,'hint_customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("')\"");
						Str.append("/>");
						Str.append(
								"<div class=\"hint\" id=hint_customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("></div>");
					} // / End Date Text Box
						// / Start DateTime Text Box
					else if (crs.getString("customfield_cftype_id").equals("6")) {
						// / Start Jquery DateTime Picker Function
						Str.append("<script type=text/javascript>\n");
						Str.append("$(function()").append("{\n");
						Str.append("$('").append("#customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("')").append(".datetimepicker({\n");
						Str.append("showButtonPanel: true,\n");
						Str.append("dateFormat: ").append("'")
								.append(formatdate_datepicker).append("',\n");
						Str.append("timeFormat: ").append("'")
								.append(formattime_timepicker).append("'\n");
						Str.append("});\n");
						Str.append("});\n");
						Str.append("</script>\n");
						// / End Jquery DateTime Picker Function
						Str.append("<input name=customfield_id-")
								.append(crs.getString("customfield_id"))
								.append(" id=customfield_id-")
								.append(crs.getString("customfield_id"));
						Str.append(" type=text class='form-control datetimepicker'size=20 maxlength=20");
						Str.append(" value=\"").append(fieldvalue).append("\"");
						Str.append(" onchange=\"SecurityCheck('customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("',this,'hint_customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("')\"");
						Str.append("/>");
						Str.append(
								"<div class=\"hint\" id=hint_customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("></div>");
					} // / End DateTime Text Box
						// / Start Time Text Box

					else if (crs.getString("customfield_cftype_id").equals("7")) {
						// / Start Jquery Time Picker Function
						Str.append("<script type=text/javascript>\n");
						Str.append("$(function()").append("{\n");
						Str.append("$('").append("#customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("')").append(".timepicker({\n");
						Str.append("showButtonPanel: true,\n");
						// Str.append("dateFormat: ").append("'hh:mm'\n");
						Str.append("});\n");
						Str.append("});\n");
						Str.append("</script>\n");
						// / End Jquery Time Picker Function
						Str.append("<input name=customfield_id-")
								.append(crs.getString("customfield_id"))
								.append(" id=customfield_id-")
								.append(crs.getString("customfield_id"));
						Str.append(" type=text class='form-control shorttimepicker' size=7 maxlength=5");
						Str.append(" value=\"").append(fieldvalue).append("\"");
						Str.append(" onchange=\"SecurityCheck('customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("',this,'hint_customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("')\"");
						Str.append("/>");

					}
					// / End Time Text Box
					// / End Form Fields
					if (!crs.getString("customfield_instruction").equals("")) {
						Str.append("<br>").append(
								crs.getString("customfield_instruction"));
					}

					Str.append("</div>");
					// Str.append("</div>");
				}

				Str.append("<input type=hidden name=customfieldsubmit value=yes>\n");
				// Str.append("</table>\n");
			}
			crs.close();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
		} finally {
			return Str.toString();
		}
	}

	// ////FOR UPDATING IN DASH PAGE
	public String CustomFieldUpdateDash(String submodule_id, String row_id, String comp_id, String name, String value,
			HttpServletRequest request) throws Exception {
		String emp_formatdate = GetSession("formatdate_name", request);
		String emp_formattime = GetSession("formattime_name", request);
		submodule_id = CNumeric(submodule_id);
		row_id = CNumeric(row_id);
		String StrSql = "", StrHTML = "";
		try {
			StrSql = "SELECT customfield_id, customfield_title, customfield_cftype_id, customfield_numeric, customfield_length_min, customfield_length_max,"
					+ " customfield_option, customfield_unique, customfield_mandatory, customfield_instruction "
					+ " FROM "
					+ compdb(comp_id)
					+ "axela_cf"
					+ " WHERE customfield_active = 1 AND customfield_submodule_id = "
					+ submodule_id + " ORDER BY customfield_rank";
			// SOP("CustomFieldUpdate StrSql==="+StrSqlBreaker(StrSql));
			CachedRowSet crs = processQuery(StrSql, 0);

			while (crs.next()) {
				if (name.equals("customfield_id-"
						+ (crs.getString("customfield_id")))) {
					if (!value.equals("")
							|| (crs.getString("customfield_mandatory").equals(
									"0") && value.equals(""))) {
						value = value.replaceAll("nbsp", "&");
						if (crs.getString("customfield_cftype_id").equals("5")) {
							if (!value.equals("")) {
								value = formatDateStr(value, emp_formatdate);
							}
						} else if (crs.getString("customfield_cftype_id")
								.equals("6")) {
							if (!value.equals("")) {
								value = formatDateStr(value, emp_formatdate
										+ " " + emp_formattime);
							}
						}
						// /////////// FOR HISTORY OLD VALUE
						String history_oldvalue = ExecuteQuery("Select cftrans_value from "
								+ compdb(comp_id)
								+ "axela_cf_trans WHERE cftrans_row_id="
								+ row_id
								+ ""
								+ " AND cftrans_customfield_id = "
								+ crs.getString("customfield_id"));

						if (crs.getString("customfield_cftype_id").equals("5")) {
							if (!history_oldvalue.equals("")) {
								history_oldvalue = formatDate(history_oldvalue,
										emp_formatdate);
							}
						} else if (crs.getString("customfield_cftype_id")
								.equals("6")) {
							if (!history_oldvalue.equals("")) {
								history_oldvalue = formatDate(history_oldvalue,
										emp_formatdate + " " + emp_formattime);
							}
						}

						StrSql = "DELETE FROM " + compdb(comp_id)
								+ "axela_cf_trans"
								+ " WHERE cftrans_submodule_id = "
								+ submodule_id + "" + " AND cftrans_row_id = "
								+ row_id + ""
								+ " AND cftrans_customfield_id = "
								+ crs.getString("customfield_id") + "";
						// SOP("StrSql delete= " + StrSql);
						updateQuery(StrSql);
						StrSql = "INSERT INTO " + compdb(comp_id)
								+ "axela_cf_trans"
								+ " (cftrans_customfield_id,"
								+ " cftrans_submodule_id," + " cftrans_row_id,"
								+ " cftrans_value)" + " VALUES" + " ("
								+ crs.getString("customfield_id") + "," + " "
								+ submodule_id + "," + " " + row_id + ","
								+ " '" + value + "')";
						// SOP("StrSql = " + StrSql);
						updateQuery(StrSql);

						// /////////// FOR HISTORY NEW VALUE
						String history_newvalue = "";
						if (crs.getString("customfield_cftype_id").equals("5")) {
							if (!value.equals("")) {
								history_newvalue = formatDate(value,
										emp_formatdate);
							}
						} else if (crs.getString("customfield_cftype_id")
								.equals("6")) {
							if (!value.equals("")) {
								history_newvalue = formatDate(value,
										emp_formatdate + " " + emp_formattime);
							}
						} else {
							history_newvalue = value;
						}

						String history_actiontype = crs
								.getString("customfield_title");

						StrSql = "INSERT into "
								+ compdb(comp_id)
								+ "axela_sales_oppr_history"
								+ " (history_oppr_id,"
								+ " history_emp_id,"
								+ " history_datetime,"
								+ " history_actiontype,"
								+ " history_oldvalue,"
								+ " history_newvalue)"
								+ " values ("
								+ " '"
								+ row_id
								+ "',"
								+ " '"
								+ CNumeric(GetSession("emp_id", request))
								+ "',"
								+ " "
								+ gettimebyzonesql(comp_id, toLongDate(kknow()))
								+ "," + " '" + history_actiontype + "'," + " '"
								+ history_oldvalue + "'," + " '"
								+ history_newvalue + "')";
						updateQuery(StrSql);
						StrHTML = crs.getString("customfield_title")
								+ " updated!";
					} else {
						StrHTML = "Enter " + crs.getString("customfield_title")
								+ "!";
					}
				}
			}
			crs.close();

		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
		}
		return StrHTML;
	}

	public String CustomFieldExport(String submodule_id, String primary_key,
			String comp_id) {
		StringBuilder Str = new StringBuilder();
		String StrSql = "", cftrans_value = "";
		try {
			StrSql = "SELECT customfield_title, customfield_cftype_id, customfield_id"
					+ " FROM "
					+ compdb(comp_id)
					+ "axela_cf"
					+ " WHERE customfield_submodule_id = "
					+ CNumeric(submodule_id)
					+ ""
					+ " AND customfield_active = 1"
					+ " AND customfield_print = 1"
					+ " ORDER BY customfield_rank";
			CachedRowSet crs = processQuery(StrSql, 0);

			if (crs.isBeforeFirst()) {
				while (crs.next()) {
					if (crs.getString("customfield_cftype_id").equals("3")) {
						cftrans_value = "IF(cftrans_value = 1, 'Yes', 'No')";
					} else if (crs.getString("customfield_cftype_id").equals(
							"5")) {
						cftrans_value = "COALESCE(DATE_FORMAT(cftrans_value, '%d/%m/%Y'), '')";
					} else if (crs.getString("customfield_cftype_id").equals(
							"6")) {
						cftrans_value = "COALESCE(DATE_FORMAT(cftrans_value, '%d/%m/%Y %H:%i'), '')";
					} else {
						cftrans_value = "cftrans_value";
					}

					Str.append(" COALESCE((SELECT ").append(cftrans_value);
					Str.append(" FROM ").append(compdb(comp_id))
							.append("axela_cf_trans");
					Str.append(" WHERE cftrans_row_id = ").append(primary_key);
					Str.append(" AND cftrans_customfield_id = ").append(
							crs.getString("customfield_id"));
					Str.append("), '') AS '")
							.append(crs.getString("customfield_title"))
							.append("',");
				}
			}
			crs.close();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
		} finally {
			return Str.toString();
		}
	}

	public ArrayList<String> getModules(HttpServletRequest request) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			String StrSql = "SELECT DISTINCT COLUMN_NAME FROM information_schema.COLUMNS"
					+ " WHERE table_schema = 'axela'"
					+ " AND table_name = 'axela_comp'"
					+ " AND COLUMN_NAME LIKE 'comp_module_%';";
			CachedRowSet crs = processQuery(StrSql, 0);

			while (crs.next()) {
				list.add(crs.getString("COLUMN_NAME"));
			}
			crs.close();

			SetSession("modules", list.toString(), request);
			return list;
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
			return list;
		}
	}

	public String getCompModules(String comp_id, HttpServletRequest request) {
		String StrArr = "", innerarray = "";
		try {
			ArrayList<String> list = null;
			String module = GetSession("modules", request);
			if (module.equals("")) {
				list = getModules(request);
			} else {
				module = ReplaceStr(module, "[", "");
				module = ReplaceStr(module, "]", "");
				module = ReplaceStr(module, " ", "");
				list = new ArrayList<String>(Arrays.asList(module.split(",")));
			}

			String StrSql = "SELECT * FROM axela_comp" + " WHERE comp_id = "
					+ comp_id + "";
			CachedRowSet crs = processQuery(StrSql, 0);

			int count = 0;
			String[] parts = null;
			while (crs.next()) {
				for (int i = 0; i < list.size(); i++) {
					if (crs.getString(list.get(i)).equals("1")) {
						count++;
						parts = list.get(i).split("comp_module_");
						if (count == 1) {
							innerarray = " AND (LCASE(module_name) = '"
									+ parts[1] + "'";
						} else {
							innerarray += " OR LCASE(module_name) = '"
									+ parts[1] + "'";
						}
					}
				}
			}

			if (!innerarray.equals("")) {
				StrArr += innerarray + ")";
			}
			crs.close();
			return StrArr;
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
			return "";
		}
	}

	public void DeleteDocs(String StrSql, String path) {
		String filename = "";
		try {
			CachedRowSet rs = processQuery(StrSql, 0);
			while (rs.next()) {
				filename = rs.getString("file");
				if (!filename.equals("") && filename != null) {
					File f = new File(path + filename);
					if (f.exists()) {
						f.delete();
					}
				}
			}
			rs.close();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
		}
	}

	public String CartSessionId() {
		String key = "", possible = "0123456789";
		for (int i = 0; i < 9; i++) {
			key += possible.charAt((int) Math.floor(Math.random()
					* possible.length()));
		}
		return key;
	}

	// In update mode, copy all the items for that particular voucher-
	// -to the cart table by creating a new session

	public void CopyVoucherTransToCart(HttpServletRequest request,
			String emp_id, String voucher_id, String comp_id) {
		String StrSql = "";
		StrSql = "DELETE FROM " + compdb(comp_id) + "axela_acc_cart"
				+ " WHERE cart_voucher_id = " + voucher_id + "";
		updateQuery(StrSql);

		StrSql = "SELECT" + " vouchertrans_voucher_id,"
				+ " voucher_vouchertype_id," + " "
				+ emp_id
				+ ","
				+ " "
				+ emp_id
				+ ","
				+ " vouchertrans_ledger_id,"
				+ " vouchertrans_location_id,"
				+ " vouchertrans_item_id,"
				+ " vouchertrans_discount,"
				+ " vouchertrans_tax,"
				+ " vouchertrans_tax_id,"
				+ " vouchertrans_rowcount,"
				+ " vouchertrans_option_id,"
				+ " vouchertrans_option_group,"
				+ " vouchertrans_item_batch_id,"
				+ " vouchertrans_item_serial,"
				+ " vouchertrans_qty,"
				+ " vouchertrans_price,"
				+ " vouchertrans_netprice,"
				+ " vouchertrans_unit_cost,"
				+ " vouchertrans_amount,"
				+ " vouchertrans_supplier_code,"
				+ " vouchertrans_supplier_qty,"
				+ " vouchertrans_supplier_uom_id,"
				+ " vouchertrans_delivery_date,"
				+ " "
				+ gettimebyzonesql(comp_id, toLongDate(kknow()))
				+ ","
				+ " vouchertrans_dc"
				+ " FROM "
				+ compdb(comp_id)
				+ "axela_acc_voucher_trans"
				+ " INNER JOIN "
				+ compdb(comp_id)
				+ "axela_acc_voucher on voucher_id = vouchertrans_voucher_id"
				+ " WHERE vouchertrans_item_id != 0"
				+ " AND vouchertrans_voucher_id = " + voucher_id + "";
		// SOP("StrSql ==copy to cart=== " +
		// StrSqlBreaker(StrSql));

		StrSql = "INSERT INTO " + compdb(comp_id) + "axela_acc_cart"
				+ " (cart_voucher_id," + " cart_vouchertype_id,"
				+ " cart_emp_id," + " cart_session_id," + " cart_ledger_id,"
				+ " cart_location_id," + " cart_item_id," + " cart_discount,"
				+ " cart_tax," + " cart_tax_id," + " cart_rowcount,"
				+ " cart_option_id," + " cart_option_group,"
				+ " cart_item_batch_id," + " cart_item_serial," + " cart_qty,"
				+ " cart_price," + " cart_netprice," + " cart_unit_cost,"
				+ " cart_amount," + " cart_supplier_code,"
				+ " cart_supplier_qty," + " cart_supplier_uom_id,"
				+ " cart_delivery_date," + " cart_time," + " cart_dc)" + " "
				+ StrSql + "";
		updateQuery(StrSql);
	}

	// public String ListVouchers(String vouchertype_voucherclass_id,
	// String strfilter, String comp_id) {
	// StringBuilder Str = new StringBuilder();
	// Map<Integer, Object> prepmap = new HashMap<>();
	// String StrSql = "SELECT voucher_id, voucher_no, voucher_amount, voucher_narration,voucher_date, voucher_active,"
	// + " voucher_oppr_id, voucher_quote_id, voucher_invoice_id, voucher_so_id, voucher_delnote_id, voucher_po_id,"
	// + " CONCAT(branch_name, ' (', branch_code, ')') AS branch_name, voucher_customer_id, voucher_contact_id,"
	// + " vouchertype_voucherclass_id,"
	// // + " COALESCE(ledger_id,'0') AS ledger_id, COALESCE(ledger_name,'') AS ledger_name,"
	// + " COALESCE(customer_name,'') AS customer_name, voucher_branch_id, voucher_authorize,"
	// + " COALESCE(CONCAT(title_desc ,' ', contact_fname,' ', contact_lname),'') AS contact_name,"
	// +
	// " COALESCE(contact_mobile1,'') AS contact_mobile1, COALESCE(contact_mobile2,'') AS contact_mobile2, COALESCE(contact_email1,'') AS contact_email1, COALESCE(contact_email2,'') AS contact_email2,"
	// + " COALESCE(CONCAT(emp_name, ' (', emp_ref_no, ')')) AS emp_name, COALESCE(emp_photo,'') AS emp_photo, COALESCE(emp_gender,'') AS emp_gender,"
	// + " COALESCE(emp_id,'') AS emp_id, vouchertype_id, vouchertype_name, vouchertype_prefix, vouchertype_suffix,"
	// + " vouchertype_email_enable, vouchertype_sms_enable, vouchertype_docs, voucherclass_id, voucherclass_file"
	// + " FROM "
	// + compdb(comp_id)
	// + "axela_acc_voucher"
	// + " INNER JOIN "
	// + compdb(comp_id)
	// + "axela_acc_voucher_type ON vouchertype_id = voucher_vouchertype_id"
	// + " INNER JOIN axela_acc_voucher_class ON voucherclass_id = vouchertype_voucherclass_id"
	// // + " LEFT JOIN "
	// // + compdb(comp_id)
	// // + "axela_acc_ledger ON ledger_id = voucher_ledger_id "
	// + " LEFT JOIN "
	// + compdb(comp_id)
	// + "axela_customer ON customer_id = voucher_customer_id"
	// + " LEFT JOIN "
	// + compdb(comp_id)
	// + "axela_customer_contact ON contact_id = voucher_contact_id"
	// + " LEFT JOIN "
	// + compdb(comp_id)
	// + "axela_title ON title_id = contact_title_id"
	// + " LEFT JOIN "
	// + compdb(comp_id)
	// + "axela_emp ON emp_id = voucher_emp_id"
	// + " LEFT JOIN "
	// + compdb(comp_id)
	// + "axela_branch ON branch_id = voucher_branch_id"
	// + " WHERE 1 = 1";
	// SOP("vouchertype_voucherclass_id = " + vouchertype_voucherclass_id);
	// if (!CNumeric(vouchertype_voucherclass_id).equals("0")) {
	// StrSql += " AND vouchertype_voucherclass_id = "
	// + vouchertype_voucherclass_id + " ";
	// }
	// StrSql += strfilter + " group by voucher_id "
	// + " order by voucher_id desc ";
	// // SOP("StrSql = " + StrSqlBreaker(StrSql));
	// try {
	// CachedRowSet rs = processPrepQuery(StrSql, prepmap, 0);
	// // Str.append(DisplayVoucherList(rs, 0, vouchertype_voucherclass_id));
	// rs.close();
	// } catch (Exception ex) {
	// SOPError(this.getClass().getName());
	// SOPError("Error in "
	// + new Exception().getStackTrace()[0].getMethodName() + ": "
	// + ex);
	// }
	// return Str.toString();
	// }

	// //for displaying voucher list
	// public String DisplayVoucherList(CachedRowSet rs, int StartRec, String voucherclass_id) {
	// Map<Integer, Object> prepmap = new HashMap<>();
	// StringBuilder Str = new StringBuilder();
	// try {
	//
	// String voucherclass_name = ExecuteQuery("SELECT voucherclass_name FROM " + maindb() + "acc_voucher_class WHERE voucherclass_id=" + voucherclass_id);
	// int count = 0;
	// if (rs.isBeforeFirst()) {
	// prepmap.clear();
	// if (StartRec != 0) {
	// count = StartRec - 1;
	// }
	// Str.append("<div class=\"table-responsive table-bordered\">\n");
	// Str.append("\n<table class=\"table table-bordered table-hover \" data-filter=\"#filter\">");
	// Str.append("<thead>");
	// Str.append("<tr align=center>\n");
	// Str.append("<th data-hide=\"phone,tablet\" data-ignore=\"true\">#</th>\n");
	// Str.append("<th data-toggle=\"true\"><span class=\"footable-toggle\"></span>ID</th>\n");
	// Str.append("<th data-hide=\"phone\">No.</th>\n");
	// Str.append("<th>Voucher</th>");
	// // Str.append("<th>Ledger</th>");
	// Str.append("<th data-hide=\"phone,tablet\">Customer</th>");
	// Str.append("<th data-hide=\"phone,tablet\">Date</th>\n");
	// Str.append("<th data-hide=\"phone,tablet\">Narration</th>\n");
	// Str.append("<th data-hide=\"phone\">Amount</th>\n");
	// Str.append("<th data-hide=\"phone,tablet\">Executive</th>\n");
	// Str.append("<th data-hide=\"phone,tablet\">Branch</th>\n");
	// Str.append("<th data-hide=\"phone,tablet\">Actions</th>\n");
	// Str.append("</tr>\n");
	// Str.append("</thead>\n");
	// while (rs.next()) {
	// SOP(rs.getString("vouchertype_name"));
	// count++;
	// Str.append("<tr>\n<td valign=top align=center >").append(count).append("</td>\n");
	// Str.append("<td valign=top align=center nowrap>");
	// Str.append(rs.getString("voucher_id")).append("");
	// Str.append("</td>");
	//
	// Str.append("<td valign=top align=left><a href='../accounting/voucher-list.jsp?voucher_id="
	// + rs.getString("voucher_id") + "'>");
	// Str.append(rs.getString("vouchertype_prefix")).append(rs.getString("voucher_no"))
	// .append(rs.getString("vouchertype_suffix")).append("</a> </td>\n");
	//
	// Str.append("<td valign=top align=left>");
	//
	// SOP("vouchertype_voucherclass_id==" + rs.getString("vouchertype_voucherclass_id"));
	// if (rs.getString("vouchertype_voucherclass_id").equals("4")) {
	// Str.append("<a href='../sales/salesorder-dash.jsp?voucher_id=" + rs.getString("voucher_id") + "'>")
	// .append(rs.getString("vouchertype_name")).append("</a>");
	// } else {
	//
	// Str.append(rs.getString("vouchertype_name"));
	// }
	// if (rs.getString("voucher_authorize").equals("1")) {
	// Str.append("<br><font color=\"#ff0000\">[Authorized]</font>");
	// }
	// if (rs.getString("voucher_active").equals("0")) {
	// Str.append("<br><font color=\"#ff0000\">[Inactive]</font>");
	// }
	// Str.append("</td>\n");
	//
	// // Str.append("<td valign=top align=left>");
	// // if (!rs.getString("ledger_id").equals("0")
	// // && !rs.getString("ledger_name").equals("")) {
	// // Str.append("<a href='ledger-list.jsp?ledger_id="
	// // + rs.getString("ledger_id") + "'>"
	// // + rs.getString("ledger_name") + " ("
	// // + rs.getString("ledger_id") + ")</a>");
	// // }
	// // Str.append("</td>\n");
	//
	// Str.append("<td valign=top align=left><a href='../customer/customer-list.jsp?customer_id="
	// + rs.getString("voucher_customer_id") + "'>");
	// if (!rs.getString("voucher_contact_id").equals("0")) {
	// Str.append("<a href='../customer/customer-contact-list.jsp?contact_id="
	// + rs.getString("voucher_contact_id") + "'>");
	// Str.append(rs.getString("contact_name")).append("</a>");
	//
	// if (!rs.getString("contact_mobile1").equals("")) {
	// Str.append("<br>").append(SplitPhoneNo(rs.getString("contact_mobile1"), 5, "M"));
	// }
	// if (!rs.getString("contact_mobile2").equals("")) {
	// Str.append("<br>").append(SplitPhoneNo(rs.getString("contact_mobile2"), 5, "M"));
	// }
	//
	// if (!rs.getString("contact_email1").equals("")) {
	// Str.append("<br><a href=mailto:").append(rs.getString("contact_email1")).append(">");
	// Str.append(rs.getString("contact_email1")).append("</a>");
	// }
	//
	// if (!rs.getString("contact_email2").equals("")) {
	// Str.append("<br><a href=mailto:").append(rs.getString("contact_email2")).append(">");
	// Str.append(rs.getString("contact_email2")).append("</a>");
	// }
	// }
	// Str.append("</td>\n");
	//
	// Str.append("<td valign=top align=center>");
	// Str.append(strToShortDate(rs.getDate("voucher_date")));
	// Str.append("</td>\n");
	// Str.append("<td valign=top align=left>");
	// Str.append(rs.getString("voucher_narration"));
	// Str.append("</td>\n");
	// Str.append("<td valign=top align=right>");
	// Str.append(rs.getString("voucher_amount"));
	// Str.append("</td>\n");
	// if (!rs.getString("emp_id").equals("0")) {
	// Str.append("<td valign=\"top\" align=\"center\">");
	// if (rs.getLong("emp_photo") != 0) {
	// Str.append(ExePhotoOval(rs.getLong("emp_photo"), rs.getString("emp_gender"), "50", rs.getString("emp_id")));
	// Str.append("<a href=\"../portal/executive-summary.jsp?emp_id=")
	// .append(rs.getString("emp_id")).append("\">");
	// Str.append(rs.getString("emp_name")).append("</a>");
	// }
	// Str.append("</td>\n");
	// }
	//
	// Str.append("<td valign=top align=left><a href='../portal/branch-summary.jsp?branch_id="
	// + rs.getString("voucher_branch_id") + "'>");
	// if (!rs.getString("voucher_branch_id").equals("0")) {
	// Str.append(rs.getString("branch_name")).append("</a>");
	// }
	// Str.append("</td>\n");
	//
	// Str.append("<td valign=\"top\" align=\"left\">");
	// if (rs.getString("vouchertype_id").equals("7")) {
	// Str.append("<a href=\"../inventory/" + rs.getString("voucherclass_file")
	// + "-update.jsp?update=yes&voucher_id=").append(rs.getString("voucher_id"));
	// Str.append("&vouchertype_id=").append(rs.getString("vouchertype_id"));
	// Str.append("\">Update " + rs.getString("vouchertype_name") + "</a>");
	// } else {
	// Str.append("<a href=\"../accounting/" + rs.getString("voucherclass_file")
	// + "-update.jsp?update=yes&voucher_id=").append(rs.getString("voucher_id"));
	// Str.append("&vouchertype_id=").append(rs.getString("vouchertype_id"));
	// Str.append("\">Update " + rs.getString("vouchertype_name") + "</a>");
	// }
	// Str.append("<br/><a href=\"../accounting/" + "voucher" + "-authorize.jsp?voucher_id=")
	// .append(rs.getString("voucher_id"));
	// Str.append("&vouchertype_id=").append(rs.getString("vouchertype_id"));
	// Str.append("\">Authorize </a>");
	// Str.append("<br/><a href=\"" + "salesorder-payment-track.jsp?voucher_id=")
	// .append(rs.getString("voucher_id"));
	// Str.append("&vouchertype_id=").append(rs.getString("vouchertype_id"));
	// Str.append("\">Payment Track</a>");
	// if (rs.getString("vouchertype_id").equals("20")) {
	// Str.append("<br/><a href=\"../accounting/grn-update.jsp?add=yes&voucher_po_id=")
	// .append(rs.getString("voucher_id")).append("&vouchertype_id=1");
	// Str.append("\">Add GRN</a>");
	// Str.append("<br/><a href=\"../accounting/voucher-list.jsp?voucher_po_id=")
	// .append(rs.getString("voucher_id")).append("&vouchertype_id=1");
	// Str.append("\">List GRN</a>");
	// }
	// if (rs.getString("vouchertype_id").equals("1")) {
	// Str.append("<br/><a href=\"../accounting/purchasereturn-update.jsp?add=yes&voucher_grn_id=")
	// .append(rs.getString("voucher_id")).append("&vouchertype_id=2&voucher_po_id=")
	// .append(rs.getString("voucher_po_id"));
	// Str.append("\">Add Purchase Return</a>");
	// Str.append("<br/><a href=\"../accounting/voucher-list.jsp?voucher_grn_id=")
	// .append(rs.getString("voucher_id")).append("&vouchertype_id=2");
	// Str.append("\">List Purchase Return</a>");
	// }
	//
	// if (rs.getString("vouchertype_id").equals("4")) {
	// Str.append("<br/><a href=\"../accounting/deliverynote-update.jsp?add=yes&vouchertype_id=3&voucher_so_id=")
	// .append(rs.getString("voucher_id"));
	// Str.append("\">Add Delivery Note</a>");
	// Str.append("<br/><a href=\"../accounting/voucher-list.jsp?voucher_so_id=")
	// .append(rs.getString("voucher_id")).append("&vouchertype_id=3");
	// Str.append("\">List Delivery Notes</a>");
	// }
	// if (rs.getString("vouchertype_id").equals("3")) {
	// Str.append("<br/><a href=\"../accounting/salesreturn-update.jsp?add=yes&voucher_delnote_id=")
	// .append(rs.getString("voucher_id")).append("&vouchertype_id=4&voucher_so_id=")
	// .append(rs.getString("voucher_so_id"));
	// Str.append("\">Add Sales Return</a>");
	// Str.append("<br/><a href=\"../accounting/voucher-list.jsp?voucher_delnote_id=")
	// .append(rs.getString("voucher_id")).append("&vouchertype_id=4");
	// Str.append("\">List Sales Returns</a>");
	// Str.append("<br/><a href=\"../accounting/invoice-update.jsp?add=yes&voucher_delnote_id=")
	// .append(rs.getString("voucher_id")).append("&vouchertype_id=102&voucher_so_id=")
	// .append(rs.getString("voucher_so_id"));
	// Str.append("\">Add Invoice</a>");
	// }
	//
	// if (rs.getString("vouchertype_email_enable").equals("1")) {
	// Str.append("</br><a href=\"../accounting/" + "voucher" + "-email.jsp?update=yes&voucher_id=")
	// .append(rs.getString("voucher_id"));
	// // Str.append("&vouchertype_id=").append(rs.getString("vouchertype_id"));
	// Str.append("\">Send " + "Email" + "</a>");
	// }
	// if (rs.getString("vouchertype_sms_enable").equals("1")) {
	// Str.append("</br><a href=\"../accounting/" + "voucher" + "-sms.jsp?update=yes&voucher_id=")
	// .append(rs.getString("voucher_id")).append("\">Send " + "SMS" + "</a>");
	// }
	// if (rs.getString("vouchertype_docs").equals("1")) {
	// Str.append("</br><a href=\"../accounting/" + "voucher" + "-doc-list.jsp?update=yes&voucher_id=")
	// .append(rs.getString("voucher_id"));
	// Str.append("\">List " + "Documents" + "</a>");
	// }
	//
	// Str.append("<br><a href='../accounting/report-ledgerstatement.jsp?all=yes&voucher_id=").append(rs.getString("voucher_id"))
	// .append("&txt_startdate=").append(rs.getString("voucher_date"))
	// .append("&voucherclass_id=").append(rs.getString("voucherclass_id"))
	// .append("&voucherclass_id=").append(rs.getString("voucherclass_id"))
	// .append("&vouchertype_id=").append(rs.getString("vouchertype_id")).append("' target='_blank'>Ledger Statement</a>");
	//
	// Str.append("</br><a target='_blank' href=\"../accounting/" + rs.getString("voucherclass_file")
	// + "-print.jsp?voucher_id=").append(rs.getString("voucher_id"));
	// Str.append("&vouchertype_id=").append(rs.getString("vouchertype_id"));
	// Str.append("\">Print " + rs.getString("vouchertype_name") + "</a>");
	//
	// Str.append("</td>\n");
	// Str.append("</tr>\n");
	// }
	// Str.append("</tbody></table></div>\n");
	// } else {
	// if (StartRec == 0) {
	// Str.append("<br><br><br><br><center><font color=red><b>No " + voucherclass_name + "(s) Found!</b></font></center><br><br>");
	// }
	// }
	// rs.close();
	// } catch (Exception ex) {
	// SOPError(this.getClass().getName());
	// SOPError("Error in "
	// + new Exception().getStackTrace()[0].getMethodName() + ": "
	// + ex);
	// }
	// return Str.toString();
	// }

	public String DisplayVoucherList(CachedRowSet crs, int StartRec,
			String ordernavi, String ordertype) {

		double customer_credit_limit = 0.00;
		String voucher_amount = "";
		Map<Integer, Object> prepmap = new HashMap<>();
		StringBuilder Str = new StringBuilder();
		try {
			int count = 0;
			if (crs.isBeforeFirst()) {
				prepmap.clear();
				if (StartRec != 0) {
					count = StartRec - 1;
				}
				Str.append("<div class=\"table-responsive table-bordered\">\n");
				Str.append("<table class=\"table table-bordered table-hover table-responsive\" data-filter=\"#filter\">\n");
				Str.append("<thead>");
				Str.append("<tr >\n");
				Str.append("<th data-hide=\"phone,tablet\" data-ignore=\"true\">#</th>\n");
				Str.append(
						"<th data-toggle=\"true\" ><span class=\"footable-toggle\"></span>")
						.append(GridLink("ID", "voucher_id", ordernavi,
								ordertype)).append("</th>\n");
				Str.append("<th data-hide=\"phone\">")
						.append(GridLink("No.", "voucher_no", ordernavi,
								ordertype)).append("</th>\n");
				Str.append("<th>")
						.append(GridLink("Voucher", "vouchertype_name",
								ordernavi, ordertype)).append("</th>\n");
				Str.append("<th>")
						.append(GridLink("Ledger", "customer_name", ordernavi,
								ordertype)).append("</th>\n");
				Str.append("<th data-hide=\"phone,tablet\">")
						.append(GridLink("Customer", "customer_name",
								ordernavi, ordertype)).append("</th>\n");
				Str.append("<th data-hide=\"phone,tablet\">")
						.append(GridLink("Ref. No.", "voucher_ref_no",
								ordernavi, ordertype)).append("</th>\n");
				Str.append("<th data-hide=\"phone,tablet\">")
						.append(GridLink("Narration", "voucher_narration",
								ordernavi, ordertype)).append("</th>\n");
				Str.append("<th data-hide=\"phone,tablet\">")
						.append(GridLink("Date", "voucher_date", ordernavi,
								ordertype)).append("</th>\n");
				Str.append("<th data-hide=\"phone,tablet\">")
						.append(GridLink("Amount", "voucher_amount", ordernavi,
								ordertype)).append("</th>\n");
				Str.append("<th data-hide=\"phone,tablet\">")
						.append(GridLink("Executive", "emp_name", ordernavi,
								ordertype)).append("</th>\n");
				Str.append("<th data-hide=\"phone,tablet\">")
						.append(GridLink("Branch", "branch_name", ordernavi,
								ordertype)).append("</th>\n");
				Str.append("<th data-hide=\"phone,tablet\">Actions</th>\n");
				Str.append("</tr>\n");
				Str.append("</thead>\n"
						+ "<tbody>\n");
				while (crs.next()) {
					customer_credit_limit = Double.parseDouble(CNumeric(crs
							.getString("customercreditlimit")));

					voucher_amount = df.format(crs.getDouble("voucher_amount"));
					count++;
					Str.append("<tr>\n<td>")
							.append(count).append("</td>\n");

					Str.append("<td align=\"center\" nowrap>");

					Str.append("<a href=\"javascript:remote=window.open('../sales/salesorder-dash.jsp?voucher_id=")
							.append(crs.getString("voucher_id")).append("','voucherdash','');remote.focus();\">");

					Str.append(crs.getString("voucher_id")).append("");
					Str.append("</td>");
					Str.append("<td align=\"center\">")
							.append("<div onmouseover=\"populatevoucherstatus('")
							.append(crs.getString("vouchertype_id") + "','"
									+ crs.getString("voucher_id") + "'")
							.append(");\" >");
					if (crs.getString("vouchertype_id").equals("4")) {
						Str.append("<a href=\"javascript:remote=window.open('../sales/salesorder-dash.jsp?voucher_id=")
								.append(crs.getString("voucher_id")).append("','voucherdash','');remote.focus();\">");
					} else {
						Str.append("<a href='../accounting/voucher-list.jsp?voucher_id="
								+ crs.getString("voucher_id") + "'>");
					}

					Str.append(crs.getString("vouchertype_prefix"))
							.append(crs.getString("voucher_no"))
							.append(crs.getString("vouchertype_suffix"))
							.append("</a>").append("</div>");
					// Str.append("<div id=\"followup_").append(
					// crs.getString("voucher_id")).append("\" >").append("</div>");
					Str.append("<div id=\"followup_")
							.append(crs.getString("voucher_id")).append("\">")
							.append("</div>");
					Str.append("</td>\n");

					Str.append("<td>");
					if (crs.getString("vouchertype_voucherclass_id").equals("4")) {
						// SOP("insiede iffff");
						Str.append(
								"<a href='../sales/salesorder-dash.jsp?voucherclass_id=4&vouchertype_id=4&voucher_id="
										+ crs.getString("voucher_id") + "'>")
								.append(crs.getString("vouchertype_name"))
								.append("</a>");

						// for oppr info
						if (!crs.getString("voucher_oppr_id").equals("0")) {
							Str.append("<br><a href=\"../sales/oppr-list.jsp?oppr_id=").append(crs.getString("voucher_oppr_id")).append("\">Enquiry ID: ");
							Str.append(crs.getString("voucher_oppr_id")).append("</a>");
						}
						// for quote info
						if (!crs.getString("voucher_quote_id").equals("0")) {
							Str.append("<br><a href=\"voucher-list.jsp?voucherclass_id=5&vouchertype_id=5&voucher_id=").append(crs.getString("voucher_quote_id")).append("\">Quote ID: ");
							Str.append(crs.getString("voucher_quote_id")).append("</a><br>");
						}

					} else {
						// SOP("insiede elseeeeee");
						if (crs.getString("vouchertype_id").equals("9")
								|| crs.getString("vouchertype_id").equals("15")) {
							if (crs.getString("paymodeid").equals("1")) {
								Str.append("Cash ");
							} else if (crs.getString("paymodeid").equals("2")) {
								Str.append("Bank ");
							}
						}

						Str.append(crs.getString("vouchertype_name"));

						if (!crs.getString("voucher_oppr_id").equals("0")) {
							Str.append("<br><a href=\"../sales/oppr-list.jsp?oppr_id=").append(crs.getString("voucher_oppr_id")).append("\">Enquiry ID: ");
							Str.append(crs.getString("voucher_oppr_id")).append("</a><br>");
						}

					}
					if (crs.getString("voucher_authorize").equals("1")) {
						Str.append("<br><font color=\"#ff0000\">[Authorized]</font>");
					}
					if (crs.getString("voucher_active").equals("0")) {
						Str.append("<br><font color=\"#ff0000\">[Inactive]</font>");
					}
					Str.append("</td>\n");

					Str.append("<td>");
					if (crs.getString("vouchertype_id").equals("9")
							|| crs.getString("vouchertype_id").equals("10")
							|| crs.getString("vouchertype_id").equals("11")
							|| crs.getString("vouchertype_id").equals("15")
							|| crs.getString("vouchertype_id").equals("16")
							|| crs.getString("vouchertype_id").equals("19")
							|| crs.getString("vouchertype_id").equals("18")) {
						Str.append("<div onmouseover=\"populatefollowup('");
						Str.append(
								crs.getString("customer_id") + "','"
										+ crs.getString("voucher_id") + "'")
								.append(") \">");
					}
					if (!crs.getString("customer_id").equals("0")
							&& !crs.getString("customer_name").equals("")) {
						// Str.append("<a href='../accounting/report-ledgerstatement.jsp?customer_id="
						// + crs.getString("customer_id")
						// + "'>"
						// + crs.getString("customer_name"));
						Str.append("<a href='../accounting/report-ledgerstatement.jsp?all=yes"
								+ "&ledger=" + crs.getString("customer_id")
								+ "' targer='_blank'>"
								+ crs.getString("customer_name")
								+ " (" + crs.getString("customer_code") + ")</a><br>");
						// if (!crs.getString("customer_code").equals(""))
						// {
						// Str.append(" (" + crs.getString("customer_code") + ")");
						// }
						Str.append("</a><br>");

					}
					// Str.append("<a href=\"javascript:remote=window.open('../sales/enquiry-dash.jsp?customer_id=")
					// .append(crs.getString("customer_id")).append("','opprdash','');remote.focus();\">");
					// Str.append("Follow-up=>");
					// Str.append("</a>");
					Str.append("</div>");
					Str.append("<div id=\"followup_")
							.append(crs.getString("customer_id")).append("\">")
							.append("</div>");
					// if (customer_credit_limit > 0) {
					// Str.append("<br>Credit Limit : " + IndFormat("" +
					// customer_credit_limit));
					// }
					Str.append("</td>");

					Str.append("<td>");
					Str.append(DisplayCustomer(
							crs.getString("voucher_customer_id"),
							crs.getString("customer_name"),
							crs.getString("voucher_contact_id"),
							crs.getString("title_desc"),
							crs.getString("contact_fname"),
							crs.getString("contact_lname"),
							crs.getString("contact_mobile1"),
							crs.getString("contact_mobile2"),
							crs.getString("contact_phone1"),
							crs.getString("contact_phone2"),
							crs.getString("contact_email1"),
							crs.getString("contact_email2")));
					Str.append("</td>\n");
					Str.append("<td>");
					Str.append(crs.getString("voucher_ref_no"));
					Str.append("</td>\n");
					Str.append("<td>");
					Str.append(crs.getString("voucher_narration"));
					Str.append("</td>\n");

					Str.append("<td>");
					Str.append(strToShortDate(crs.getDate("voucher_date")));
					Str.append("</td>\n");

					Str.append("<td align=\"right\">");
					Str.append(voucher_amount);
					Str.append("</td>\n");

					if (!crs.getString("emp_id").equals("0")) {
						Str.append("<td>");
						if (!crs.getString("emp_id").equals("")) {
							// Str.append(ExePhotoOval(crs.getString("emp_photo"),
							// crs.getString("emp_sex"), "50"));
							Str.append(
									"<a href=\"../portal/executive-summary.jsp?emp_id=")
									.append(crs.getString("emp_id"))
									.append("\">");
							Str.append(crs.getString("emp_name")).append("</a>");
						}
						Str.append("</td>\n");
					}

					Str.append("<td><a href='../portal/branch-summary.jsp?branch_id="
							+ crs.getString("voucher_branch_id") + "'>");
					if (!crs.getString("voucher_branch_id").equals("0")) {
						Str.append(crs.getString("branch_name")).append("</a>");
					}
					Str.append("</td>\n");
					// // actions column
					Str.append("<td nowrap>");
					if (crs.getString("vouchertype_id").equals("3")) {
						Str.append(
								"<a href=\"../inventory/"
										+ crs.getString("voucherclass_file")
										+ "-update.jsp?update=yes&voucher_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=")
								.append(crs.getString("voucherclass_id"));
						Str.append("&vouchertype_id=").append(
								crs.getString("vouchertype_id"));
						Str.append("\">Update "
								+ crs.getString("vouchertype_name") + "</a>");
					} else if (crs.getString("vouchertype_id").equals("1")
							|| crs.getString("vouchertype_id").equals("2")) {
						Str.append(
								"<a href=\"../accounting/po-update.jsp?update=yes&voucher_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=")
								.append(crs.getString("voucherclass_id"));
						Str.append("&vouchertype_id=").append(
								crs.getString("vouchertype_id"));
						Str.append("\">Update "
								+ crs.getString("vouchertype_name") + "</a>");
					} else {
						Str.append(
								"<a data-target=#Hintclicktocall80 data-toggle=modal href=\"../accounting/"
										+ crs.getString("voucherclass_file")
										+ "-update.jsp?update=yes&voucher_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=")
								.append(crs.getString("voucherclass_id"));
						Str.append("&vouchertype_id=").append(
								crs.getString("vouchertype_id"));
						Str.append("\">Update "
								+ crs.getString("vouchertype_name") + "</a>");
					}
					Str.append(
							"<br/><a href=\"../accounting/" + "voucher"
									+ "-authorize.jsp?voucher_id=")
							.append(crs.getString("voucher_id"))
							.append("&voucherclass_id=")
							.append(crs.getString("voucherclass_id"));
					Str.append("&vouchertype_id=").append(
							crs.getString("vouchertype_id"));
					Str.append("\">Authorize </a>");

					// quote
					if (crs.getString("vouchertype_id").equals("5")) {
						if (!CNumeric(crs.getString("voucher_authorize")).equals("0")) {

							Str.append(
									"<br/><a href=\"../accounting/quote-print.jsp?dr_report=quote-print&voucher_id=")
									.append(crs.getString("voucher_id"));
							Str.append("&voucherclass_id=5").append(
									"&vouchertype_id=5");
							Str.append("\">Print Quote</a>");

						}
						Str.append(
								"<br/><a href=\"../accounting/quote-email.jsp?voucher_id=")
								.append(crs.getString("voucher_id"));
						Str.append("&voucherclass_id=5").append(
								"&vouchertype_id=5");
						Str.append("\">Email Quote</a>");
						Str.append(
								"<br/><a href=\"../accounting/"
										+ crs.getString("voucherclass_file")
										+ "-update.jsp?add=yes&voucher_quote_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=4");
						Str.append("&vouchertype_id=4");
						Str.append("\">Add Sales Order</a>");
						Str.append(
								"<br/><a href=\"../accounting/voucher-list.jsp?voucher_quote_id=")
								.append(crs.getString("voucher_id"));
						Str.append("&voucherclass_id=4").append(
								"&vouchertype_id=4");
						Str.append("\">List Sales Order</a>");
					}

					// sales order
					if (crs.getString("vouchertype_id").equals("4")) {
						Str.append(
								"<br/><a href=\"../accounting/"
										+ crs.getString("voucherclass_file")
										+ "-update.jsp?add=yes&voucher_so_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=6")
								.append("&vouchertype_id=6")
								.append("&vouchertrans_customer_id=")
								.append(crs.getString("voucher_customer_id"))
								.append("&span_cont_id=")
								.append(crs.getString("voucher_contact_id"));
						Str.append("\">Add Sales Invoice</a>");
						Str.append("<br/><a href=\"../accounting/voucher-list.jsp?voucher_so_id=").append(crs.getString("voucher_id"));
						Str.append("&customer_id=").append(crs.getString("voucher_customer_id"));
						Str.append("&voucherclass_id=6").append("&vouchertype_id=6");
						Str.append("\">List Sales Invoice</a>");
					}
					// GIT
					if (crs.getString("vouchertype_id").equals("10")) {
						Str.append("<br/><a href=\"../accounting/"
								// + crs.getString("voucherclass_file")
								+ "po-update.jsp?add=yes&voucher_git_id=");
						Str.append(crs.getString("voucher_id")).append(
								"&voucherclass_id=20");
						Str.append("&vouchertype_id=20");
						Str.append("\">Add GRN</a>");
						Str.append(
								"<br/><a href=\"../accounting/voucher-list.jsp?voucher_git_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=20")
								.append("&vouchertype_id=20");
						Str.append("\">List GRNs</a>");
					}
					// grn
					if (crs.getString("vouchertype_id").equals("20")) {
						// purchase invoice
						Str.append(
								"<br/><a href=\"../accounting/"
										+ crs.getString("voucherclass_file")
										+ "-update.jsp?add=yes")
								.append("&voucherclass_id=21")
								.append("&vouchertype_id=21&voucher_grn_id=")
								.append(crs.getString("voucher_id"));
						Str.append("\">Add Purchase Invoice</a>");
						Str.append(
								"<br/><a href=\"../accounting/voucher-list.jsp?voucher_grn_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=21")
								.append("&vouchertype_id=21");
						Str.append("\">List Purchase Invoices</a>");

						// purchase return
						Str.append(
								"<br/><a href=\"../accounting/returns-update.jsp?add=yes&voucher_grn_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=24");
						Str.append("&vouchertype_id=24");
						Str.append("\">Add Purchase Return</a>");
						Str.append(
								"<br/><a href=\"../accounting/voucher-list.jsp?voucher_grn_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=24");
						Str.append("&vouchertype_id=24");
						Str.append("\">List Purchase Returns</a>");
					}

					if (crs.getString("vouchertype_id").equals("3")) {
						// Sales Invoice
						Str.append(
								"<br/><a href=\"../accounting/"
										+ crs.getString("voucherclass_file")
										+ "-update.jsp?add=yes&voucher_delnote_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=6")
								.append("&vouchertype_id=6");
						Str.append("\">Add Sales Invoice</a>");
						Str.append(
								"<br/><a href=\"../accounting/voucher-list.jsp?voucher_delnote_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=6")
								.append("&vouchertype_id=6");
						Str.append("\">List Sales Invoices</a>");
						// Sales Return
						Str.append(
								"<br/><a href=\"../accounting/"
										+ crs.getString("voucherclass_file")
										+ "-update.jsp?add=yes&voucher_delnote_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=23")// 116
								.append("&vouchertype_id=23");
						Str.append("\">Add Sales Return</a>");
						Str.append(
								"<br/><a href=\"../accounting/voucher-list.jsp?voucher_delnote_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=23")
								.append("&vouchertype_id=23");
						Str.append("\">List Sales Returns</a>");

					}
					// Invoice
					if (crs.getString("vouchertype_id").equals("6")) {
						Str.append(
								"<br/><a href=\"../accounting/receipt-update.jsp?add=yes&ledger=")
								.append(crs.getString("voucher_customer_id"))
								.append("&voucherclass_id=9")
								.append("&vouchertype_id=9")
								.append("&voucher_invoice_id=")
								.append(crs.getString("voucher_id"));
						if (!crs.getString("voucher_so_id").equals("0")) {
							Str.append("&voucher_so_id=").append(crs.getString("voucher_so_id"));
						} else if (!crs.getString("voucher_jc_id").equals("0")) {
							Str.append("&voucher_jc_id=").append(crs.getString("voucher_jc_id"));
						}
						Str.append("\">Add Receipt</a>");
						Str.append(
								"<br/><a href=\"../accounting/voucher-list.jsp?voucher_invoice_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=9")
								.append("&vouchertype_id=9");
						Str.append("\">List Receipts</a>");
					}

					if (crs.getString("vouchertype_id").equals("25")) {
						// user can not add "Delivery Note" for "Sales invoice"
						// if there is "Sales order" for that "Sales invoice"
						Str.append(
								"<br/><a href=\"../accounting/returns-update.jsp?add=yes&voucher_delnote_id=")
								.append(crs.getString("voucher_id")).append("&voucherclass_id=23")
								.append("&vouchertype_id=23")
								.append("&vouchertrans_customer_id=")
								.append(crs.getString("voucher_customer_id"))
								.append("&span_cont_id=")
								.append(crs.getString("voucher_contact_id"))
								.append("&voucher_rateclass_id=")
								.append(crs.getString("voucher_rateclass_id"))
								.append("&branch_id=")
								.append(crs.getString("voucher_branch_id"))
								.append("\">Add Sales Return</a>");

						Str.append(
								"<br/><a href=\"../accounting/voucher-list.jsp?voucher_delnote_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=23")
								.append("&vouchertype_id=23");
						Str.append("\">List Sales Return</a>");
					}

					// Delivery Note
					if (crs.getString("vouchertype_id").equals("6")) {
						// user can not add "Delivery Note" for "Sales invoice"
						// if there is "Sales order" for that "Sales invoice"
						if (crs.getString("voucher_so_id").equals("0")) {
							Str.append(
									"<br/><a href=\"../accounting/so-update.jsp?add=yes&voucher_invoice_id=")
									.append(crs.getString("voucher_id")).append("&voucherclass_id=25")
									.append("&vouchertype_id=25")
									.append("&vouchertrans_customer_id=")
									.append(crs.getString("voucher_customer_id"))
									.append("&span_cont_id=")
									.append(crs.getString("voucher_contact_id"))
									.append("&voucher_rateclass_id=")
									.append(crs.getString("voucher_rateclass_id"))
									.append("&branch_id=")
									.append(crs.getString("voucher_branch_id"))
									.append("\">Add Delivery Note</a>");

							Str.append(
									"<br/><a href=\"../accounting/voucher-list.jsp?voucher_invoice_id=")
									.append(crs.getString("voucher_id"))
									.append("&voucherclass_id=25")
									.append("&vouchertype_id=25");
							Str.append("\">List Delivery Note</a>");

						}

					}
					// DCR Request
					if (crs.getString("vouchertype_id").equals("12")) {
						Str.append(
								"<br/><a href=\"../accounting/"
										+ crs.getString("voucherclass_file")
										+ "-update.jsp?add=yes&voucher_po_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=20")
								.append("&vouchertype_id=20");
						Str.append("\">Add GRN</a>");
						Str.append(
								"<br/><a href=\"../accounting/voucher-list.jsp?voucher_po_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=20")
								.append("&vouchertype_id=20");
						Str.append("\">List GRN</a>");
					}
					// DCR
					if (crs.getString("vouchertype_id").equals("4")) {
						Str.append(
								"<br/><a href=\"../accounting/"
										+ "returns-update.jsp?add=yes&voucher_dcr_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=23")// 116
								.append("&vouchertype_id=23");
						Str.append("\">Add Sales Return</a>");
						Str.append(
								"<br/><a href=\"../accounting/voucher-list.jsp?voucher_dcr_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=23")
								.append("&vouchertype_id=23");
						Str.append("\">List Sales Returns</a>");
					}
					// grn return
					if (crs.getString("vouchertype_id").equals("2")) {
						Str.append(
								"<br/><a href=\"../accounting/"
										+ crs.getString("voucherclass_file")
										+ "-update.jsp?add=yes&voucher_grn_return_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=24")
								.append("&vouchertype_id=24");
						Str.append("\">Add Purchase Return</a>");
						Str.append(
								"<br/><a href=\"../accounting/voucher-list.jsp?voucher_grn_return_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=24")
								.append("&vouchertype_id=24");
						Str.append("\">List Purchase Return</a>");
					}
					if (crs.getString("vouchertype_email_enable").equals("1")) {
						Str.append(
								"</br><a href=\"" + "voucher"
										+ "-email.jsp?update=yes&voucher_id=")
								.append(crs.getString("voucher_id"));
						Str.append("\">Send " + "Email" + "</a>");
					}
					if (crs.getString("vouchertype_sms_enable").equals("1")) {
						Str.append(
								"</br><a href=\"" + "voucher"
										+ "-sms.jsp?update=yes&voucher_id=")
								.append(crs.getString("voucher_id"));
						Str.append("\">Send " + "SMS" + "</a>");
					}
					if (crs.getString("vouchertype_docs").equals("1")) {
						Str.append(
								"</br><a href=\""
										+ "voucher"
										+ "-doc-list.jsp?update=yes&voucher_id=")
								.append(crs.getString("voucher_id"))
								.append("&vouchertype_id=")
								.append(crs.getString("vouchertype_id"));
						Str.append("\">List " + "Documents" + "</a>");
					}
					Str.append("<br><a href='../accounting/report-ledgerstatement.jsp?all=yes&voucher_id=").append(crs.getString("voucher_id"))
							.append("&txt_startdate=").append(crs.getString("voucher_date"))
							.append("&voucherclass_id=").append(crs.getString("voucherclass_id"))
							.append("&voucherclass_id=").append(crs.getString("voucherclass_id"))
							.append("&vouchertype_id=").append(crs.getString("vouchertype_id")).append("' target='_blank'>Ledger Statement</a>");
					if (crs.getString("vouchertype_id").equals("9") && !CNumeric(crs.getString("voucher_authorize")).equals("0")) {
						Str.append(
								"</br><a target='_blank' href=\""
										+ crs.getString("voucherclass_file")

										+ "-print.jsp?voucher_id=")
								.append(crs.getString("voucher_id"))
								.append("&voucherclass_id=")
								.append(crs.getString("voucherclass_id"));
						Str.append("&vouchertype_id=").append(
								crs.getString("vouchertype_id")).append("&dr_report=")
								.append(ReplaceStr(crs.getString("vouchertype_name").toLowerCase(), " ", ""))
								.append("-print")
								.append("&dr_format=").append("pdf")
								.append("&voucher_authorize=").append(crs.getString("voucher_authorize"));
						Str.append("\">Print " + crs.getString("vouchertype_name")
								+ "</a>");
					}
					// else if (!crs.getString("vouchertype_id").equals("9")) {
					// Str.append(
					// "</br><a target='_blank' href=\""
					// + crs.getString("voucherclass_file")
					//
					// + "-print.jsp?voucher_id=")
					// .append(crs.getString("voucher_id"))
					// .append("&voucherclass_id=")
					// .append(crs.getString("voucherclass_id"));
					// Str.append("&vouchertype_id=").append(
					// crs.getString("vouchertype_id")).append("&dr_report=")
					// .append(ReplaceStr(crs.getString("vouchertype_name").toLowerCase(), " ", ""))
					// .append("-print")
					// .append("&dr_format=").append("pdf");
					// Str.append("\">Print " + crs.getString("vouchertype_name")
					// + "</a>");
					// }

					Str.append("</td>\n");
					Str.append("</tr>\n");

				}
			} else {
				if (StartRec == 0) {
					Str.append("<br><br><br><br><font color=red><b>No Voucher(s) Found!</b></font><br><br>");
				}
			}
			crs.close();
			Str.append("</tbody></table></div>\n");
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
		}
		return Str.toString();
	}
	public String DisplayCustomer(String customer_id, String customer_name,
			String contact_id, String title, String contact_fname,
			String contact_lname, String contact_mobile1,
			String contact_mobile2, String contact_phone1,
			String contact_phone2, String contact_email1, String contact_email2) {
		StringBuilder Str = new StringBuilder();
		Str.append("<a href='../customer/customer-list.jsp?customer_id="
				+ customer_id + "'>");
		Str.append(customer_name).append("</a>").append("<br>");
		if (!contact_id.equals("0")) {
			Str.append("<a href='../customer/customer-contact-list.jsp?contact_id="
					+ contact_id + "'>");
			Str.append(title + " " + contact_fname + contact_lname).append(
					"</a>");

			if (!contact_mobile1.equals("")) {
				Str.append("<br>")
						.append(SplitPhoneNo(contact_mobile1, 5, "M"));
			}
			if (!contact_mobile2.equals("")) {
				Str.append("<br>")
						.append(SplitPhoneNo(contact_mobile2, 5, "M"));
			}
			if (!contact_phone1.equals("")) {
				Str.append("<br>").append(SplitPhoneNo(contact_phone1, 2, "L"));
			}
			if (!contact_phone2.equals("")) {
				Str.append("<br>").append(SplitPhoneNo(contact_phone2, 2, "L"));
			}
			if (!contact_email1.equals("")) {
				Str.append("<br><a href=mailto:").append(contact_email1)
						.append(">");
				Str.append(contact_email1).append("</a>");
			}
			if (!contact_email2.equals("")) {
				Str.append("<br><a href=mailto:").append(contact_email2)
						.append(">");
				Str.append(contact_email2).append("</a>");
			}
		}
		return Str.toString();
	}

	public double ClosingStock(String date, String comp_id) {
		double closingstock = 0.00;
		String StrSql = "";
		// StrSql = " SELECT "
		// + " SUM(vouchertrans_qty)*stock_unit_cost AS total\n"
		// + " FROM " + compdb(comp_id) + "axela_acc_voucher_trans  \n"
		// + " INNER JOIN " + compdb(comp_id) +
		// "axela_acc_voucher ON voucher_id = vouchertrans_voucher_id\n"
		// + " INNER JOIN " + compdb(comp_id) +
		// "axela_inventory_stock ON stock_item_id = vouchertrans_item_id\n" //
		// + " WHERE 1=1\n"
		// + " AND SUBSTR(voucher_date,1,8) <= SUBSTR(" + date + ",1,8)\n"
		// + " GROUP BY vouchertrans_item_id,vouchertrans_location_id\n"
		// + " HAVING total != 0";
		StrSql = " SELECT sum(stock_current_qty*stock_unit_cost) AS total"
				+ " FROM " + compdb(comp_id) + "axela_inventory_stock"
				+ " GROUP BY stock_item_id, stock_location_id"
				+ " HAVING total >0";
		// SOP("StrSql====closing=="+StrSqlBreaker(StrSql));
		CachedRowSet rs = processQuery(StrSql, 0);
		try {
			while (rs.next()) {
				closingstock += rs.getDouble("total");
			}
			// SOP("closingstock===" + closingstock);
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
		}
		return closingstock;
	}

	// PSF Custom field view method
	public String PSFCustomFieldView(String comp_id, String jcpsf_id,
			String colspan, HttpServletRequest request) {
		StringBuilder Str = new StringBuilder();
		String fieldvalue = "";
		CachedRowSet crs = null;
		try {
			String StrSql = "SELECT jcpsfcf_id, jcpsfcf_title, jcpsfcf_cftype_id,"
					+ " jcpsfcf_numeric, jcpsfcf_length_min, jcpsfcf_length_max,"
					+ " jcpsfcf_option, jcpsfcf_unique, jcpsfcf_mandatory, jcpsfcf_instruction, jcpsfcf_voc,"
					+ " jcpsfcf_fieldref, COALESCE(jcpsfcftrans_value, '') as jcpsfcftransvalue, COALESCE(jcpsfcftrans_value, '') AS jcpsfcftrans_value,"
					+ " COALESCE(jcpsfcftrans_voc, '') AS jcpsfcftrans_voc"
					+ " FROM "
					+ compdb(comp_id)
					+ "axela_service_jc_psf"
					+ " INNER JOIN "
					+ compdb(comp_id)
					+ "axela_service_jc_psfdays ON psfdays_id = jcpsf_psfdays_id"
					+ " INNER JOIN "
					+ compdb(comp_id)
					+ "axela_service_jc_psf_cf ON jcpsfcf_psfdays_id = psfdays_id"
					+ " LEFT JOIN "
					+ compdb(comp_id)
					+ "axela_service_jc_psf_trans ON jcpsfcftrans_jcpsfcf_id = jcpsfcf_id"
					+ " AND jcpsfcftrans_jcpsf_id = "
					+ jcpsf_id
					+ ""
					+ " WHERE jcpsfcf_active = 1 AND jcpsf_id = "
					+ jcpsf_id
					+ "" + " GROUP BY jcpsfcf_id" + " ORDER BY jcpsfcf_rank";
			// SOP("--in connect class------"+StrSqlBreaker(StrSql));
			crs = processQuery(StrSql, 0);

			if (crs.isBeforeFirst()) {
				while (crs.next()) {
					// / Get Field Value
					if (PadQuotes(request.getParameter("customfieldsubmit"))
							.equals("yes")) {
						fieldvalue = PadQuotes(request
								.getParameter("jcpsfcf_id-"
										+ (crs.getString("jcpsfcf_id"))));
						if (crs.getString("jcpsfcf_cftype_id").equals("3")) {
							if (fieldvalue.equals("on")) {
								fieldvalue = CheckBoxValue(PadQuotes(request
										.getParameter("jcpsfcf_id-"
												+ (crs.getString("jcpsfcf_id")))));
							}
						}
					} else {
						if (crs.getString("jcpsfcftransvalue") == null
								&& !crs.getString("jcpsfcf_fieldref").equals(""))
							fieldvalue = crs.getString("jcpsfcf_fieldref");
						// fieldvalue = ReturnFieldRef(comp_id,
						// crs.getString("jcpsfcf_fieldref"),
						// crs.getString("crm_enquiry_id"),
						// crs.getString("crm_so_id"));
						else
							fieldvalue = crs.getString("jcpsfcftrans_value");
						if (crs.getString("jcpsfcf_cftype_id").equals("5")) {
							if (!fieldvalue.equals("")) {
								fieldvalue = strToShortDate(new SimpleDateFormat("dd/MM/yyyy").parse(fieldvalue));
							}
						} else if (crs.getString("jcpsfcf_cftype_id")
								.equals("6")) {
							if (!fieldvalue.equals("")) {
								fieldvalue = strToLongDate(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(fieldvalue));
							}
						}
					}
					Str.append("<tr>\n");
					Str.append("<td valign=\"top\" align=\"right\">");
					Str.append(crs.getString("jcpsfcf_title"));
					if (crs.getString("jcpsfcf_mandatory").equals("1")) {
						Str.append("<font color=\"#ff0000\">*</font>");
					}
					Str.append(":</td>\n");
					Str.append("<td valign=top align=left");
					if (!colspan.equals("0")) {
						Str.append(" colspan=").append(colspan);
					}
					Str.append(">\n");
					// / Start Form Fields
					// / Start Text Field
					if (crs.getString("jcpsfcf_cftype_id").equals("1")) {
						Str.append("<input name=jcpsfcf_id-")
								.append(crs.getString("jcpsfcf_id"))
								.append(" id=jcpsfcf_id-")
								.append(crs.getString("jcpsfcf_id"));
						Str.append(
								" type=text class=form-control size=50 maxlength=")
								.append(crs.getString("jcpsfcf_length_max"));
						Str.append(" value=\"").append(fieldvalue).append("\"");
						if (crs.getString("jcpsfcf_numeric").equals("1")) {
							Str.append(" onKeyUp=\"toInteger('jcpsfcf_id-")
									.append(crs.getString("jcpsfcf_id"))
									.append("','custom')\"");
						}
						Str.append("/>");
					} // / End Text Field
						// / Start Text Area
					else if (crs.getString("jcpsfcf_cftype_id").equals("2")) {
						Str.append("<textarea name=jcpsfcf_id-")
								.append(crs.getString("jcpsfcf_id"))
								.append(" id=jcpsfcf_id-")
								.append(crs.getString("jcpsfcf_id"));
						Str.append(
								" cols=\"70\" rows=\"5\" class=\"form-control\" onKeyUp=\"charcount('")
								.append("jcpsfcf_id-")
								.append(crs.getString("jcpsfcf_id"));
						Str.append("', 'span_jcpsfcf_id-").append(
								crs.getString("jcpsfcf_id"));
						Str.append(
								"','<font color=red>({CHAR} characters left)</font>',")
								.append(crs.getString("jcpsfcf_length_max"));
						Str.append(")\">").append(fieldvalue)
								.append("</textarea>");
						Str.append(" <span id=\"span_jcpsfcf_id-")
								.append(crs.getString("jcpsfcf_id"))
								.append("\"> (")
								.append(crs.getString("jcpsfcf_length_max"))
								.append(" Characters)</span>");
					} // / End Text Area
						// / Start Check Box
					else if (crs.getString("jcpsfcf_cftype_id").equals("3")) {
						Str.append("<input id=jcpsfcf_id-")
								.append(crs.getString("jcpsfcf_id"))
								.append(" type=\"checkbox\"");
						Str.append(" name=jcpsfcf_id-")
								.append(crs.getString("jcpsfcf_id")).append(" ")
								.append(PopulateCheck(fieldvalue)).append("/>");
					} // / End Check Box
						// / Start Drop Down
					else if (crs.getString("jcpsfcf_cftype_id").equals("4")) {
						Str.append("<select name=jcpsfcf_id-")
								.append(crs.getString("jcpsfcf_id"))
								.append(" id=jcpsfcf_id-")
								.append(crs.getString("jcpsfcf_id"));
						Str.append(" class=form-control>\n");
						String[] option = crs.getString("jcpsfcf_option").split(
								"\\r\\n");
						Str.append("<option value=\"\">Select</option>\n");
						for (int i = 1; i <= option.length; i++) {
							Str.append("<option" + " value=\"")
									.append(option[i - 1]).append("\" ");
							Str.append(StrSelectdrop(option[i - 1], fieldvalue));
							Str.append(">").append(option[i - 1])
									.append("</option>\n");
						}
						Str.append("</select>");
					} // / End Drop Down
						// / Start Date Text Box
					else if (crs.getString("jcpsfcf_cftype_id").equals("5")) {
						// / Start Jquery Date Picker Function
						SOP("dp 444");
						Str.append("<script type=text/javascript>\n");
						Str.append("$(function()").append("{\n");
						Str.append("$('").append("#jcpsfcf_id-")
								.append(crs.getString("jcpsfcf_id"))
								.append("')").append(".datepicker({\n");
						Str.append("showButtonPanel: true,\n");
						Str.append("dateFormat: ").append("'")
								.append("dd/mm/yy").append("'\n");
						Str.append("});\n");
						Str.append("});\n");
						Str.append("</script>\n");
						// / End Jquery Date Picker Function
						Str.append("<input name=jcpsfcf_id-")
								.append(crs.getString("jcpsfcf_id"))
								.append(" id=jcpsfcf_id-")
								.append(crs.getString("jcpsfcf_id"));
						Str.append(" type=text class=form-control size=12 maxlength=10");
						Str.append(" value=\"").append(fieldvalue).append("\"").append("class=\"form-control datepicker\"")
								.append(" value=\"\"");
						Str.append("/>");
					} // / End Date Text Box
						// / Start DateTime Text Box
					else if (crs.getString("jcpsfcf_cftype_id").equals("6")) {
						SOP("dp6666");
						// / Start Jquery DateTime Picker Function
						Str.append("<script type=text/javascript>\n");
						Str.append("$(function()").append("{\n");
						Str.append("$('").append("#jcpsfcf_id-")
								.append(crs.getString("jcpsfcf_id"))
								.append("')").append(".datetimepicker({\n");
						Str.append("showButtonPanel: true,\n");
						Str.append("dateFormat: ").append("'")
								.append("dd/mm/yy").append("',\n");
						Str.append("timeFormat: ").append("'").append("HH:mm")
								.append("'\n");
						Str.append("});\n");
						Str.append("});\n");
						Str.append("</script>\n");
						// / End Jquery DateTime Picker Function
						Str.append("<input name=jcpsfcf_id-")
								.append(crs.getString("jcpsfcf_id"))
								.append(" id=jcpsfcf_id-")
								.append(crs.getString("jcpsfcf_id"));
						Str.append(" type=text class=form-control size=18 maxlength=16");
						Str.append(" value=\"").append(fieldvalue).append("\"").append("class=\"form-control date-picker\"")
								.append("data-date-format=\"dd/mm/yyyy HH:mm\" value=\"\"");;
						Str.append("/>");
					} // / End DateTime Text Box
						// / Start Time Text Box
					else if (crs.getString("jcpsfcf_cftype_id").equals("7")) {
						// / Start Jquery Time Picker Function
						Str.append("<script type=text/javascript>\n");
						Str.append("$(function()").append("{\n");
						Str.append("$('").append("#jcpsfcf_id-")
								.append(crs.getString("jcpsfcf_id"))
								.append("')").append(".timepicker({\n");
						Str.append("showButtonPanel: true,\n");
						// Str.append("dateFormat: ").append("'hh:mm'\n");
						Str.append("});\n");
						Str.append("});\n");
						Str.append("</script>\n");
						// / End Jquery Time Picker Function
						Str.append("<input name=jcpsfcf_id-")
								.append(crs.getString("jcpsfcf_id"))
								.append(" id=jcpsfcf_id-")
								.append(crs.getString("jcpsfcf_id"));
						Str.append(" type=text class=form-control size=7 maxlength=5");
						Str.append(" value=\"").append(fieldvalue).append("\"");
						Str.append("/>");
					}
					// / End Time Text Box
					// / End Form Fields
					if (!crs.getString("jcpsfcf_instruction").equals("")) {
						Str.append("<br>").append(
								crs.getString("jcpsfcf_instruction"));
					}
					// // Display Voc
					if (crs.getString("jcpsfcf_voc").equals("1")) {
						Str.append("<br>VOC:<textarea name=jcpsfcftrans_voc-")
								.append(crs.getString("jcpsfcf_id"))
								.append(" id=jcpsfcftrans_voc-")
								.append(crs.getString("jcpsfcf_id"));
						Str.append(
								" cols=\"70\" rows=\"5\" class=\"form-control\" onKeyUp=\"charcount('")
								.append("jcpsfcftrans_voc-")
								.append(crs.getString("jcpsfcf_id"));
						Str.append("', 'span_jcpsfcftrans_voc-").append(
								crs.getString("jcpsfcf_id"));
						Str.append(
								"','<font color=red>({CHAR} characters left)</font>',8000)\">")
								.append(crs.getString("jcpsfcftrans_voc"))
								.append("</textarea>");
						Str.append(" <span id=\"span_jcpsfcftrans_voc-")
								.append(crs.getString("jcpsfcf_id"))
								.append("\"> (8000 Characters)</span>");
					}
					Str.append("</td>\n");
					Str.append("</tr>\n");
				}
				Str.append("<input type=hidden name=customfieldsubmit value=yes>\n");
				// Str.append("</table>\n");
			}
			crs.close();
			return Str.toString();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
			return "";
		}
	}

	public String PSFCustomFieldValidate(String comp_id, String jcpsf_id,
			String colspan, HttpServletRequest request) {
		StringBuilder Str = new StringBuilder();
		String fieldvalue = "";
		String fieldvoc = "";
		jcpsf_id = CNumeric(jcpsf_id);
		CachedRowSet crs = null;
		try {
			String StrSql = "SELECT jcpsfcf_id, jcpsfcf_title, jcpsfcf_cftype_id,"
					+ " jcpsfcf_numeric, jcpsfcf_length_min, jcpsfcf_length_max, jcpsfcf_voc,"
					+ " jcpsfcf_option, jcpsfcf_unique, jcpsfcf_mandatory"
					+ " FROM "
					+ compdb(comp_id)
					+ "axela_service_jc_psf"
					+ " INNER JOIN "
					+ compdb(comp_id)
					+ "axela_service_jc_psfdays ON psfdays_id = jcpsf_psfdays_id"
					+ " INNER JOIN "
					+ compdb(comp_id)
					+ "axela_service_jc_psf_cf ON jcpsfcf_psfdays_id = psfdays_id"
					+ " LEFT JOIN "
					+ compdb(comp_id)
					+ "axela_service_jc_psf_trans ON jcpsfcftrans_jcpsfcf_id = jcpsfcf_id"
					+ " AND jcpsfcftrans_jcpsf_id = "
					+ jcpsf_id
					+ ""
					+ " WHERE jcpsfcf_active = 1"
					+ " AND jcpsf_id = "
					+ jcpsf_id
					+ ""
					+ " GROUP BY jcpsfcf_id "
					+ " ORDER BY jcpsfcf_rank";
			// SOP("StrSql===cf=="+StrSql);
			crs = processQuery(StrSql, 0);
			if (crs.isBeforeFirst()) {

				while (crs.next()) {
					// / Get Field Value
					if (PadQuotes(request.getParameter("customfieldsubmit"))
							.equals("yes")) {
						fieldvalue = PadQuotes(request
								.getParameter("jcpsfcf_id-"
										+ (crs.getString("jcpsfcf_id"))));
						fieldvoc = PadQuotes(request
								.getParameter("jcpsfcftrans_voc-"
										+ (crs.getString("jcpsfcf_id"))));
						if (crs.getString("jcpsfcf_cftype_id").equals("3")) {
							if (fieldvalue.equals("on")) {
								fieldvalue = CheckBoxValue(PadQuotes(request
										.getParameter("jcpsfcf_id-"
												+ (crs.getString

														("jcpsfcf_id")))));
							}
						}
						// SOPError("fieldvalue = " + fieldvalue);
						if (fieldvalue.equals("")
								&& crs.getString("jcpsfcf_mandatory")
										.equals("1")) {
							// / For Text Field AND Text Area
							if (crs.getString("jcpsfcf_cftype_id").equals("1")
									|| crs.getString("jcpsfcf_cftype_id")
											.equals("2")) {
								Str.append("<br>")
										.append(crs.getString("jcpsfcf_title"))
										.append(" is blank!");
							}
							// / For Drop Down AND Date Time
							if (crs.getString("jcpsfcf_cftype_id").equals("4")
									|| crs.getString("jcpsfcf_cftype_id")
											.equals("5")
									|| crs.getString("jcpsfcf_cftype_id")
											.equals("6")
									|| crs.getString("jcpsfcf_cftype_id")
											.equals("7")) {
								Str.append("<br>Select ")
										.append(crs.getString("jcpsfcf_title"))
										.append("!");
							}
						}
						// / For Date
						if (!fieldvalue.equals("")
								&& crs.getString("jcpsfcf_cftype_id")
										.equals("5")) {
							if (!isValidDateFormatLong(fieldvalue)) {
								Str.append("<br>Enter Valid ")
										.append(crs.getString("jcpsfcf_title"))
										.append("!");
							}
						}
						// / For Date Time
						if (!fieldvalue.equals("")
								&& crs.getString("jcpsfcf_cftype_id")
										.equals("6")) {
							if (!isValidDateFormatLong(fieldvalue)) {
								Str.append("<br>Enter Valid ")
										.append(crs.getString("jcpsfcf_title"))
										.append("!");
							}
						}
						// / Minimum Length
						// / For Text Field AND Text Area
						if (crs.getString("jcpsfcf_cftype_id").equals("1")
								|| crs.getString("jcpsfcf_cftype_id")
										.equals("2")) {
							if (crs.getInt("jcpsfcf_length_min") > 0
									&& fieldvalue.length() <

									crs.getInt("jcpsfcf_length_min")) {
								Str.append("<br>Enter a minimum of ")
										.append(crs
												.getString("jcpsfcf_length_min"))
										.append(" Characters for ").append

										(crs.getString("jcpsfcf_title"))
										.append("!");
							}
						}
						// For voc text field
						if ((crs.getString("jcpsfcf_cftype_id").equals("1") || crs
								.getString("jcpsfcf_cftype_id").equals("2")) &&

								crs.getString("jcpsfcf_voc").equals("1")) {
							if (crs.getInt("jcpsfcf_length_min") > 0
									&& fieldvoc.length() <

									crs.getInt("jcpsfcf_length_min")) {
								Str.append("<br>Enter a minimum of voc ")
										.append(crs
												.getString("jcpsfcf_length_min"))
										.append(" Characters for ").append

										(crs.getString("jcpsfcf_title"))
										.append("!");
							}
						}
						// / Maximum Length
						if (fieldvalue.length() > crs
								.getInt("jcpsfcf_length_max")) {
							fieldvalue = fieldvalue.substring(0,
									crs.getInt("jcpsfcf_length_max") - 1);
						}
						// / Check Unique Field
						if (!fieldvalue.equals("")
								&& crs.getString("jcpsfcf_unique").equals("1")) {
							StrSql = "SELECT cftrans_id" + " FROM " + ""
									+ compdb(comp_id) + "axela_sales_crm_trans"
									+ " WHERE cftrans_jcpsfcf_id = "
									+ crs.getString("jcpsfcf_id")
									+ " AND cftrans_value = '" + fieldvalue
									+ "'";
							if (!ExecuteQuery(StrSql).equals("")) {
								Str.append("<br>")
										.append(crs.getString("jcpsfcf_title"))
										.append(" is not unique!");
							}
						}
					}
				}
			}
			crs.close();
			return Str.toString();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
			return "";
		}
	}

	public void PSFCustomFieldUpdate(String comp_id, String jcpsf_id,
			String update, HttpServletRequest request) throws Exception {
		String fieldvalue = "";
		String fieldvoc = "";
		// String emp_formatdate = GetSession("formatdate_name", request);
		// String emp_formattime = GetSession("formattime_name", request);
		jcpsf_id = CNumeric(jcpsf_id);
		String StrSql = "";
		Connection conntx = null;
		Statement stmttx = null;
		CachedRowSet crs = null;
		if (!jcpsf_id.equals("0")) {
			StrSql = "DELETE FROM " + compdb(comp_id)
					+ "axela_service_jc_psf_trans"
					+ " WHERE jcpsfcftrans_jcpsf_id = " + jcpsf_id + "";
			updateQuery(StrSql);

			if (PadQuotes(request.getParameter("customfieldsubmit")).equals(
					"yes")
					&& update.equals("yes")) {
				try {
					conntx = connectDB();
					conntx.setAutoCommit(false);
					stmttx = conntx.createStatement();

					StrSql = "SELECT jcpsfcf_id, jcpsfcf_title, jcpsfcf_cftype_id, jcpsfcf_numeric, jcpsfcf_length_min, jcpsfcf_length_max,"
							+ " jcpsfcf_option, jcpsfcf_unique, jcpsfcf_mandatory, jcpsfcf_voc, jcpsfcf_instruction "
							+ " FROM "
							+ compdb(comp_id)
							+ "axela_service_jc_psf"
							+ " INNER JOIN "
							+ compdb(comp_id)
							+ "axela_service_jc_psfdays ON psfdays_id = jcpsf_psfdays_id"
							+ " INNER JOIN "
							+ compdb(comp_id)
							+ "axela_service_jc_psf_cf ON jcpsfcf_psfdays_id = psfdays_id"
							+ " WHERE jcpsfcf_active = 1"
							+ " AND jcpsf_id = "
							+ jcpsf_id
							+ ""
							+ " GROUP BY jcpsfcf_id"
							+ " ORDER BY jcpsfcf_rank";
					// SOPError("CustomFieldUpdate StrSql==="+StrSqlBreaker(StrSql));
					crs = processQuery(StrSql, 0);

					while (crs.next()) {
						// / Get Field Value
						fieldvalue = PadQuotes(request
								.getParameter("jcpsfcf_id-"
										+ (crs.getString("jcpsfcf_id"))));
						fieldvoc = PadQuotes(request
								.getParameter("jcpsfcftrans_voc-"
										+ (crs.getString("jcpsfcf_id"))));
						if (crs.getString("jcpsfcf_cftype_id").equals("3")) {
							if (fieldvalue.equals("on")) {
								fieldvalue = CheckBoxValue(PadQuotes(request
										.getParameter("jcpsfcf_id-"
												+ (crs.getString("jcpsfcf_id")))));
							}
						} else if (crs.getString("jcpsfcf_cftype_id")
								.equals("5")) {
							if (!fieldvalue.equals("")) {
								fieldvalue = convertShortDateToStr(PadQuotes(request
										.getParameter("jcpsfcf_id-"
												+ (crs.getString("jcpsfcf_id")))));
							}
						} else if (crs.getString("jcpsfcf_cftype_id")
								.equals("6")) {
							if (!fieldvalue.equals("")) {
								fieldvalue = convertLongDateToStr((PadQuotes(request
										.getParameter("jcpsfcf_id-"
												+ (crs.getString("jcpsfcf_id"))))));
							}
						}

						// SOP("fieldvalue====="+fieldvalue);
						StrSql = "INSERT INTO " + compdb(comp_id)
								+ "axela_service_jc_psf_trans"
								+ " (jcpsfcftrans_jcpsfcf_id,"
								+ " jcpsfcftrans_jcpsf_id,"
								+ " jcpsfcftrans_value," + " jcpsfcftrans_voc)"
								+ " VALUES" + " (" + crs.getString("jcpsfcf_id")
								+ "," + " " + jcpsf_id + "," + " '"
								+ fieldvalue + "', " + " '" + fieldvoc + "')";
						// SOP("StrSql===ssss = " + StrSql);
						stmttx.addBatch(StrSql);
					}
					crs.close();
					stmttx.executeBatch();
					conntx.commit();

				} catch (Exception ex) {
					if (conntx.isClosed()) {
						SOPError("conn is closed.....");
					}
					if (!conntx.isClosed() && conntx != null) {
						conntx.rollback();
						SOPError(this.getClass().getName());
						SOPError("Error in "
								+ new Exception().getStackTrace()[0]
										.getMethodName() + ": " + ex);
					}
					// msg = "<br>Transaction Error!";
				} finally {
					conntx.setAutoCommit(true);
					stmttx.close();
					if (conntx != null && !conntx.isClosed()) {
						conntx.close();
					}
				}
			}
		}
	}

	public String AppCustomFieldView(String submodule_id, String row_id,
			String colspan, String comp_id, HttpServletRequest request) {
		StringBuilder Str = new StringBuilder();
		String emp_formatdate = GetSession("formatdate_name", request);
		String formatdate_datepicker = GetSession("formatdate_datepicker", request);
		String formattime_timepicker = GetSession("formattime_timepicker", request);
		String emp_formattime = GetSession("formattime_name", request);
		String fieldvalue = "";
		submodule_id = CNumeric(submodule_id);
		row_id = CNumeric(row_id);
		CachedRowSet crs = null;
		try {
			String StrSql = "SELECT customfield_id, customfield_title, customfield_cftype_id,"
					+ " customfield_numeric, customfield_length_min, customfield_length_max,"
					+ " customfield_option, customfield_unique, customfield_mandatory, customfield_instruction,"
					+ " COALESCE(cftrans_row_id, 0) AS cftrans_row_id, COALESCE(cftrans_value, '') AS cftrans_value"
					+ " FROM " + compdb(comp_id) + "axela_cf"
					+ " LEFT JOIN " + compdb(comp_id) + "axela_cf_trans ON cftrans_customfield_id = customfield_id" + " AND cftrans_row_id = " + row_id + ""
					+ " WHERE customfield_active = 1"
					+ " AND customfield_submodule_id = "
					+ submodule_id
					+ " ORDER BY customfield_rank";
			// SOP("StrSql===========" + StrSql);
			crs = processQuery(StrSql, 0);
			if (crs.isBeforeFirst()) {
				while (crs.next()) {
					// / Get Field Value
					if (PadQuotes(request.getParameter("customfieldsubmit")).equals("yes")) {
						fieldvalue = PadQuotes(request.getParameter("customfield_id-" + (crs.getString("customfield_id"))));
						if (crs.getString("customfield_cftype_id").equals("3")) {
							if (fieldvalue.equals("on")) {
								fieldvalue = CheckBoxValue(PadQuotes(request.getParameter("customfield_id-" + (crs.getString("customfield_id")))));
							}
						}
					} else {
						fieldvalue = crs.getString("cftrans_value");
						if (crs.getString("customfield_cftype_id").equals("5")) {
							if (!fieldvalue.equals("")) {
								fieldvalue = formatDate(fieldvalue, emp_formatdate);
							}
						} else if (crs.getString("customfield_cftype_id").equals("6")) {
							if (!fieldvalue.equals("")) {
								fieldvalue = formatDate(fieldvalue, emp_formatdate + " " + emp_formattime);
							}
						}
					}
					if (submodule_id.equals("37")) {
						Str.append("<div class=\"form-group form-md-line-input\"><label class=\"control-label\">");
					}
					else if (submodule_id.equals("17") || submodule_id.equals("19") || submodule_id.equals("20") || submodule_id.equals("5") || submodule_id.equals("18") || submodule_id.equals("4")) {
						Str.append("<div class=\"form-group form-md-line-input \">\n");
						Str.append("<label class=\"control-label\">\n");
					}
					else if (crs.getString("customfield_cftype_id").equals("3")) {
						Str.append("<div class=\"form-group form-md-line-input \">\n");
						Str.append("<label class=\"control-label\">\n");
					}

					else {
						Str.append("<div class=\"form-group form-md-line-input\"><label class=\"control-label\">");
					}

					Str.append(crs.getString("customfield_title"));
					if (crs.getString("customfield_mandatory").equals("1")) {
						Str.append("<font color=\"#ff0000\">*</font>");
					}
					Str.append(":</label>\n");
					// / Start Form Field
					// / Start Text Field
					if (crs.getString("customfield_cftype_id").equals("1")) {
						Str.append("<input name=customfield_id-").append(crs.getString("customfield_id"))
								.append(" id=customfield_id-").append(crs.getString("customfield_id"));
						Str.append(" type=\"text\" class=\"form-control\" size=50 maxlength=").append(crs.getString("customfield_length_max"));
						Str.append(" value=\"").append(fieldvalue).append("\"");

						if (crs.getString("customfield_numeric").equals("1")) {
							Str.append(" onKeyUp=\"toInteger('customfield_id-")
									.append(crs.getString("customfield_id"))
									.append("','custom')\"");
						}
						Str.append("/>");
					} // / End Text Field
						// / Start Text Area
					// / Start Text Area
					else if (crs.getString("customfield_cftype_id").equals("2")) {
						// Str.append("<div class=\"col-md-6 col-xs-12 col-sm-10\">");
						Str.append("<textarea name=customfield_id-")
								.append(crs.getString("customfield_id"))
								.append(" id=customfield_id-")
								.append(crs.getString("customfield_id"))
								.append(" cols=\"70\" rows=\"5\" class=\"form-control\" onKeyUp=\"charcount('")
								.append("customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("', 'span_customfield_id-").append(
										crs.getString("customfield_id"))
								.append("','<font color=red>({CHAR} characters left)</font>',")
								.append(crs.getString("customfield_length_max"))
								.append(")\">").append(fieldvalue)
								.append("</textarea>")
								.append(" <span id=\"span_customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("\"> (")
								.append(crs.getString("customfield_length_max"))
								.append(" Characters)</span>");
					}

					// / End Text Area
					// / Start Check Box
					else if (crs.getString("customfield_cftype_id").equals("3")) {
						// Str.append("<div class=\"col-md-6 col-xs-8 col-sm-10 txt-align \">");
						Str.append("<input id=customfield_id-")
								.append(crs.getString("customfield_id"))
								.append(" type=\"checkbox\" ")
								.append(" name=customfield_id-")
								.append(crs.getString("customfield_id"))
								.append(" ").append(PopulateCheck(fieldvalue))
								.append("/>");
					} // / End Check Box
						// / Start Drop Down
					else if (crs.getString("customfield_cftype_id").equals("4") || crs.getString("customfield_cftype_id").equals("0")) {
						SOP("date picker 1");
						// Str.append("<div class=\"col-md-6 col-xs-12 col-sm-10\">");
						Str.append("<select name=customfield_id-")
								.append(crs.getString("customfield_id"))
								.append(" id=customfield_id-")
								.append(crs.getString("customfield_id"))
								.append(" class='form-control' >\n");
						String[] option = crs.getString("customfield_option")
								.split("\\r\\n");
						Str.append("<option value=\"\">Select</option>\n");// this is the drop down item
						for (int i = 1; i <= option.length; i++) {
							Str.append("<option" + " value=\"")
									.append(option[i - 1]).append("\" ")
									.append(StrSelectdrop(option[i - 1], fieldvalue))
									.append(">").append(option[i - 1])
									.append("</option>\n");
						}
						Str.append("</select>");
					} // / End Drop Down
						// / Start Date Text Box
					else if (crs.getString("customfield_cftype_id").equals("5")) {
						// / Start Jquery Date Picker Function
						// Str.append("<script type=text/javascript>\n");
						// Str.append("$(function()").append("{\n");
						// Str.append("$('").append("#customfield_id-")
						// .append(crs.getString("customfield_id"))
						// .append("')").append(".datepicker({\n");
						// Str.append("showButtonPanel: true,\n");
						// Str.append("dateFormat: ")
						// .append("dd/mm/yy").append("\n");
						// Str.append("});\n");
						// Str.append("});\n");
						// Str.append("</script>\n");
						// / End Jquery Date Picker Function
						// Str.append("<div class=\"col-md-6 col-xs-12 col-sm-10\">");
						Str.append("<input name=customfield_id-")
								.append(crs.getString("customfield_id"))
								.append(" id=customfield_id-")
								.append(crs.getString("customfield_id"))
								.append(" type=text class='form-control customfield-date datepicker' size=12 maxlength=10")
								.append(" value=\"").append(fieldvalue).append("\"")
								.append("/>");
					} // / End Date Text Box
						// / Start DateTime Text Box
					else if (crs.getString("customfield_cftype_id").equals("6")) {
						// / Start Jquery DateTime Picker Function
						// Str.append("<div class=\"col-md-6 col-xs-12 col-sm-10\">");
						Str.append("<script type=text/javascript>\n")
								.append("$(function()").append("{\n")
								.append("$('").append("#customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("')").append(".datetimepicker({\n")
								// .append(" class=\"form-control date form_datetime date-picker\">\n");
								.append("showButtonPanel: true,\n")
								.append("dateFormat: ").append("'")
								.append(formatdate_datepicker).append("',\n")
								.append("timeFormat: ").append("'")
								.append(formattime_timepicker).append("'\n")
								.append("});\n")
								.append("});\n")
								.append("</script>\n");

						// / End Jquery DateTime Picker Function
						Str.append("<input name=customfield_id-")
								.append(crs.getString("customfield_id"))
								.append(" id=customfield_id-")
								.append(crs.getString("customfield_id"))
								.append(" type=text class=\"form-control date form_datetime datepicker\" size=18 maxlength=16")
								.append(" value=\"").append(fieldvalue).append("\"")
								.append("/>");
					} // / End DateTime Text Box
						// / Start Time Text Box
					else if (crs.getString("customfield_cftype_id").equals("7")) {
						// / Start Jquery Time Picker Function
						// Str.append("<div class=\"col-md-6 col-xs-12 col-sm-10\">");
						Str.append("<script type=text/javascript>\n")
								.append("$(function()").append("{\n")
								.append("$('").append("#customfield_id-")
								.append(crs.getString("customfield_id"))
								.append("')").append(".timepicker({\n")
								.append("showButtonPanel: true,\n")
								// Str.append("dateFormat: ").append("'hh:mm'\n");
								.append("});\n")
								.append("});\n")
								.append("</script>\n");
						// / End Jquery Time Picker Function
						Str.append("<input name=customfield_id-")
								.append(crs.getString("customfield_id"))
								.append(" id=customfield_id-")
								.append(crs.getString("customfield_id"))
								.append(" type=text class=form-control size=7 maxlength=5")
								.append(" value=\"").append(fieldvalue).append("\"")
								.append("/>");
					}
					// / End Time Text Box
					// / End Form Fields
					if (!crs.getString("customfield_instruction").equals("")) {
						Str.append("<br>").append(
								crs.getString("customfield_instruction"));
					}
					Str.append("</div>");
				}
				Str.append("<input type=hidden name=customfieldsubmit value=yes>\n");
				// Str.append("</table>\n");
			}
			return Str.toString();
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
			return "";
		}
	}

	public String FormatBr(String br) {
		if (br.endsWith(".0")) {
			return br.substring(0, br.length() - 2);
		} else {
			return br;
		}
	}

	public String buildSmartSearch(String input) throws JSONException, ParseException {
		JSONObject inputObj = new JSONObject(input);
		String array1 = "";
		String array2 = "";
		String array3 = "";
		String array4 = "";
		String array5 = "";
		JSONArray arrays1 = new JSONArray();
		JSONArray arrays2 = new JSONArray();
		JSONArray arrays3 = new JSONArray();
		JSONArray arrays4 = new JSONArray();
		JSONArray arrays5 = new JSONArray();
		String strSearch = "AND ";

		inputObj = inputObj.getJSONObject("smartParam");
		if (!inputObj.isNull("drSmart1")) {
			arrays1 = inputObj.getJSONArray("drSmart1");
		}
		if (!inputObj.isNull("drSmart2")) {
			arrays2 = inputObj.getJSONArray("drSmart2");
		}
		if (!inputObj.isNull("txtSmart1")) {
			arrays3 = inputObj.getJSONArray("txtSmart1");
		}
		if (!inputObj.isNull("drSmart3")) {
			arrays4 = inputObj.getJSONArray("drSmart3");
		}
		if (!inputObj.isNull("txtSmart2")) {
			arrays5 = inputObj.getJSONArray("txtSmart2");
		}
		if (arrays1.length() == arrays2.length() && arrays2.length() == arrays3.length() && arrays3.length() == arrays4.length()) {
			for (int i = 0; i <= arrays1.length() - 1; ++i) {
				if (arrays1.get(i).equals("a.*")) {

				}
				if (((String) arrays2.get(i)).contains("-text")) {
					if (arrays2.get(i).equals("0-text")) {
						strSearch += " " + arrays1.get(i) + " LIKE '%" + arrays3.get(i) + "%'";
					}
					if (arrays2.get(i).equals("1-text")) {
						strSearch += " " + arrays1.get(i) + " NOT LIKE '%" + arrays3.get(i) + "%'";
					}
					if (arrays2.get(i).equals("2-text")) {
						strSearch += " " + arrays1.get(i) + "='" + arrays3.get(i) + "'";
					}
					if (arrays2.get(i).equals("3-text")) {
						strSearch += " " + arrays1.get(i) + "<>'" + arrays3.get(i) + "'";
					}
					if (arrays2.get(i).equals("4-text")) {
						strSearch += " " + arrays1.get(i) + " LIKE '" + arrays3.get(i) + "%'";
					}
					if (arrays2.get(i).equals("5-text")) {
						strSearch += " " + arrays1.get(i) + " NOT LIKE '" + arrays3.get(i) + "%'";
					}
					if (arrays2.get(i).equals("6-text")) {
						strSearch += " " + arrays1.get(i) + " LIKE '%" + arrays3.get(i) + "'";
					}
					if (arrays2.get(i).equals("7-text")) {
						strSearch += " " + arrays1.get(i) + " NOT LIKE '%" + arrays3.get(i) + "'";
					}
					if (arrays2.get(i).equals("8-text")) {
						strSearch += " " + arrays1.get(i) + "='" + arrays3.get(i) + "'";
					}
					if (arrays2.get(i).equals("9-text")) {
						strSearch += " " + arrays1.get(i) + "!='" + arrays3.get(i) + "'";
					}
					if (((String) arrays1.get(i)).contains("SELECT")) {
						strSearch += ")";
					}
				} else if (((String) arrays2.get(i)).contains("-numeric")) {
					if (arrays2.get(i).equals("0-numeric")) {
						strSearch += " " + arrays1.get(i) + "=" + arrays3.get(i);
					}
					if (arrays2.get(i).equals("1-numeric")) {
						strSearch += " " + arrays1.get(i) + "<>" + arrays3.get(i);
					}
					if (arrays2.get(i).equals("2-numeric")) {
						strSearch += " " + arrays1.get(i) + "<" + arrays3.get(i);
					}
					if (arrays2.get(i).equals("3-numeric")) {
						strSearch += " " + arrays1.get(i) + "<='" + arrays3.get(i) + "'";
					}
					if (arrays2.get(i).equals("4-numeric")) {
						strSearch += " " + arrays1.get(i) + ">" + arrays3.get(i);
					}
					if (arrays2.get(i).equals("5-numeric")) {
						strSearch += " " + arrays1.get(i) + ">=" + arrays3.get(i);
					}
					if (arrays2.get(i).equals("6-numeric")) {
						strSearch += " " + arrays1.get(i) + " BETWEEN " + arrays3.get(i);
					}
					if (arrays2.get(i).equals("7-numeric")) {
						strSearch += " " + arrays1.get(i) + " NOT BETWEEN " + arrays3.get(i);
					}
					if (((String) arrays1.get(i)).contains("SELECT")) {
						strSearch += ")";
					}
				} else if (((String) arrays2.get(i)).contains("-date")) {
					if (arrays2.get(i).equals("0-date")) {
						strSearch += " " + arrays1.get(i) + "='" + arrays3.get(i) + "'";
					}
					if (arrays2.get(i).equals("1-date")) {
						strSearch += " " + arrays1.get(i) + "<>'" + arrays3.get(i) + "'";
					}
					if (arrays2.get(i).equals("2-date")) {
						strSearch += " " + arrays1.get(i) + "<'" + arrays3.get(i) + "'";
					}
					if (arrays2.get(i).equals("3-date")) {
						strSearch += " " + arrays1.get(i) + "<='" + arrays3.get(i) + "'";
					}
					if (arrays2.get(i).equals("4-date")) {
						strSearch += " " + arrays1.get(i) + ">'" + arrays3.get(i) + "'";
					}
					if (arrays2.get(i).equals("5-date")) {
						strSearch += " " + arrays1.get(i) + ">='" + arrays3.get(i) + "'";
					}
					if (arrays2.get(i).equals("6-date")) {
						strSearch += " " + arrays1.get(i) + " BETWEEN" + arrays3.get(i) + " AND " + convertLongDateToStr(arrays5.get(i) + "");
					}
					if (arrays2.get(i).equals("7-date")) {
						strSearch += " " + arrays1.get(i) + " NOT BETWEEN " + arrays3.get(i) + " AND " + convertLongDateToStr(arrays5.get(i) + "");
					}
					if (arrays2.get(i).equals("8-date")) {
						strSearch += " " + arrays1.get(i) + "=''";
					}
					if (arrays2.get(i).equals("9-date")) {
						strSearch += " " + arrays1.get(i) + "!=''";
					}
					if (((String) arrays1.get(i)).contains("SELECT")) {
						strSearch += ")";
					}
				} else if (((String) arrays2.get(i)).contains("-boolean")) {
					if (arrays2.get(i).equals("0-boolean")) {
						strSearch += " " + arrays1.get(i) + "='" + arrays3.get(i) + "'";
					}
					if (((String) arrays1.get(i)).contains("SELECT")) {
						strSearch += ")";
					}
				}
				if (!arrays2.get(i).equals("")) {
					if (arrays4.length() < arrays1.length() && arrays4.length() > i) {
						strSearch += " " + arrays4.get(i);
					} else if (arrays4.length() == arrays1.length() && arrays4.length() - 1 > i) {
						strSearch += " " + arrays4.get(i);
					}
				}
			}
			SOP("strSearch==================" + strSearch);
		} else {
			strSearch += "1=1";
		}
		return strSearch;
	}

	// For Mobile App
	public StringBuilder appBuildSmartSearch(String input) throws JSONException {
		StringBuilder str = new StringBuilder();
		JSONObject inputObj = new JSONObject(input);
		if (inputObj.has("multiSelect")) {
			JSONArray multiselect = inputObj.getJSONArray("multiSelect");
			for (int i = 0; i < multiselect.length(); i++) {
				String entity = (String) multiselect.getJSONObject(i).get("key");
				String value = (String) multiselect.getJSONObject(i).get("value");
				str.append(" AND ").append(entity).append(" IN (").append(value).append(")");
			}
		}
		if (inputObj.has("text")) {
			JSONArray text = inputObj.getJSONArray("text");
			for (int i = 0; i < text.length(); i++) {
				String entity = (String) text.getJSONObject(i).get("key");
				String value = (String) text.getJSONObject(i).get("value");
				str.append(" AND ").append(entity).append(" = '").append(value).append("' ");
			}
		}
		return str;
	}

	public HashMap produceBodyData(boolean route, ArrayList type, ArrayList value
			, ArrayList ParamArr) {
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("route", route);// hyper link is true/false
		mapBodyData.put("type", type);// hyper link Array
		mapBodyData.put("value", value);// list Data
		mapBodyData.put("paramArr", ParamArr);// hyper link parameter Array
		return mapBodyData;
	}

	public HashMap buildSmartArr(String key, String type, String entity) {
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("key", entity + "-" + type);// entity name and type
		mapBodyData.put("name", key);// value
		return mapBodyData;

	}

	// for Mobile App
	public Map appBuildSmartArr(String label, String type, String entity) {
		Map map = new HashMap();
		map.put("entity", entity);
		map.put("label", label);
		map.put("type", type);
		return map;
	}

	// List Page Methods
	public HashMap<String, String> produceHeaderData(String fieldName, String sortheader, String align) {
		HashMap<String, String> mapHeadAlign = new HashMap<String, String>();
		mapHeadAlign.put("feildName", fieldName);// Name Of the Field
		mapHeadAlign.put("sortHeader", sortheader);// Sorting type(asc,Desc)
		mapHeadAlign.put("align", align);// Alignment of the Field
		return mapHeadAlign;
	}

	public HashMap<String, String> produceBodyAlign(String align) {
		HashMap<String, String> mapHeadAlign = new HashMap<String, String>();
		mapHeadAlign.put("align", align);// Alignment of the Field
		return mapHeadAlign;
	}

}
