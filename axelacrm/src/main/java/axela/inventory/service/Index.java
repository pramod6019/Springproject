package axela.inventory.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.inventory.repository.InventoryIndexImpl;
import axela.service.model.AxelaModuleReport;
@Service
public class Index extends Connect {

	@Autowired
	private InventoryIndexImpl inventoryIndexImpl;

	HashMap output = null;
	JSONObject inputObj = null;

	public Map ListReports(String input, HttpSession session) throws JSONException {
		List<AxelaModuleReport> listReport = inventoryIndexImpl.findInventoryListReport();
		output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (AxelaModuleReport resultRepot : listReport) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("reportName", resultRepot.getReportName());
			map.put("reportUrl", resultRepot.getReportUrl());
			list.add(map);
		}
		output.put("populateListReports", list);
		return output;

	}

	// StringBuilder Str = new StringBuilder();

	// try {
	// CachedRowSet rs = processQuery(StrSql, 0);
	// if (rs.isBeforeFirst()) {
	// Str.append("<div class=\"table-responsive\">\n");
	// Str.append("<table class=\"table table-responsive\" data-filter=\"#filter\">\n");
	// while (rs.next()) {
	// Str.append("<tr>");
	// Str.append("<td><a href=" + rs.getString("report_url") + " target=_blank >" + rs.getString("report_name") + "</a></td>");
	// Str.append("</tr>");
	// }
	// Str.append("</table>\n");
	// Str.append("</div>\n");
	// } else {
	// Str.append("<b><font color=red><b>No Reports found!</b></font>");
	// }
	// rs.close();
	// } catch (Exception ex) {
	// SOPError(this.getClass().getName());
	// SOPError("Error in " + new Exception().getStackTrace()[0].getMethodName() + ": " + ex);
	// return "";
	// }
	// return Str.toString();

	// public String CampaignSummary(HttpServletRequest request) {
	// int issuedCount = 0;
	// int enqcount = 0;
	// StringBuilder Str = new StringBuilder();
	// int count = 0;
	//
	// try {
	// StrSql = " SELECT campaign_id, campaign_name, campaign_startdate, campaign_enddate, "
	// + " COALESCE((SELECT COUNT(oppr_id) "
	// + " FROM " + compdb(comp_id) + "axela_sales_oppr "
	// + " WHERE  oppr_campaign_id = campaign_id" + " ),0)  AS enqcount"
	// + " FROM " + compdb(comp_id) + "axela_sales_campaign"
	// + " WHERE campaign_active='1' "
	// + " AND campaign_startdate<" + gettimebyzonesql(comp_id, ToLongDate(kknow())) + " AND campaign_enddate>" + gettimebyzonesql(comp_id, ToLongDate(kknow()));
	// StrSql = StrSql + " GROUP BY campaign_id ORDER BY campaign_name";
	//
	// // // SOP("strsql in LmsSummary---" + StrSqlBreaker(StrSql));
	// // CachedRowSet rs = processQuery(StrSql, 0);
	// // Str.append("<table border=1 cellspacing=0 cellpadding=0 class=\"listtable\">");
	// // Str.append("<tr align=center>\n");
	// // Str.append("<th>#</th>\n");
	// // Str.append("<th>Campaign</th>\n");
	// // Str.append("<th>Date</th>\n");
	// // Str.append("<th>Enquiry</th>\n");
	// // Str.append("</tr>\n");
	// // while (rs.next()) {
	// // count = count + 1;
	// // // issuedCount = issuedCount + rs.getInt("itemscount");
	// // enqcount = enqcount + rs.getInt("enqcount");
	// // Str.append("<tr>\n");
	// // Str.append("<td valign=top align=center><b>" + count + ".</b></td>\n");
	// // Str.append("<td valign=top align=left><a href=campaign-list.jsp?campaign_id=" + rs.getString("campaign_id") + ">" + rs.getString("campaign_name") + "</a></td>\n");
	// // Str.append("<td valign=top align=center>" + strToShortDate(rs.getString("campaign_startdate")) + " - " + strToShortDate(rs.getString("campaign_enddate")) + "</td>");
	// // Str.append("<td valign=top align=right>" + rs.getString("enqcount") + "</td>");
	// // Str.append("</tr>");
	// // }
	// // rs.close();
	// // Str.append("<tr>\n");
	// // Str.append("<td align=right>&nbsp;</td>\n");
	// // Str.append("<td align=right>&nbsp;</td>\n");
	// // Str.append("<td align=right><b>Total:</b></td>\n");
	// // Str.append("<td align=right><b>" + enqcount + "</b></td>\n");
	// // Str.append("</tr></table>");
	// // return Str.toString();
	// } catch (Exception ex) {
	// SOPError(this.getClass().getName());
	// SOPError("Error in " + new Exception().getStackTrace()[0].getMethodName() + ": " + ex);
	// return "";
	// }
	// }

}
