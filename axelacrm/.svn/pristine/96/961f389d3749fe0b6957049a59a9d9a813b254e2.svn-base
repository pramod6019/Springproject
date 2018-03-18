package axela.helpdesk.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.helpdesk.model.AxelaHelpDeskTicketFaq;
import axela.helpdesk.repository.FaqFilterImpl;
import axela.helpdesk.repository.FaqRepository;

@Service
public class FAQ extends Connect {

	@Autowired
	FaqFilterImpl faqFilterImpl;

	@Autowired
	FaqRepository faqRepository;

	public String msg = "";
	public String startTime = "";
	public String endTime = "";
	public String empId = "0";
	public String StrHTML = "";
	public String strSearch = "";
	public String smart = "";
	public String strSql = "";
	public String compId = "0";
	public String branchId = "0";
	public String drBranchId = "0";
	public String param1 = "";
	public String param2 = "";
	public String param3 = "";
	public String branchAccess = "";
	public String exeAccess = "";
	public String refreshForm = "";
	public String exportPerm = "";
	public String enableSearch = "1";
	public String reportURL = "";
	public String formatdateDatepicker = "", empFormatdate = "";
	public String ListLink = "<a href=jobcard-list.jsp?smart=yes>Click here to List Job Cards</a>";
	HashMap output = null;
	JSONObject inputObj = null;
	public String starttime = "";
	public String endtime = "";

	public Map<String, String> contractService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException, ServletException, IOException {
		// CheckSession(request, response);
		compId = CNumeric(getSession("compId", session));
		empId = CNumeric(getSession("empId", session));
		branchId = CNumeric(getSession("empBranchId", session));
		branchAccess = getSession("branchAccess", session);
		exeAccess = getSession("exeAccess", session);
		if (!inputObj.isNull("smart")) {
			smart = PadQuotes(inputObj.getString("smart"));
		}
		empFormatdate = getSession("formatdateName", session);
		formatdateDatepicker = getSession("formatdateDatepicker", session);

		if (!smart.equals("yes")) {
			getValues(session);
			validateFields();
			populateData(input, session, response);
		}
		return output;
	}

	protected void getValues(HttpSession session) throws ServletException, IOException, ParseException, JSONException {
		if (!inputObj.isNull("startTime")) {
			startTime = PadQuotes(inputObj.getString("startTime"));
		}
		if (!inputObj.isNull("endTime")) {
			endTime = PadQuotes(inputObj.getString("endTime"));
		}
		String date = "";
		if (startTime.equals("") || endTime.equals("")) {
			date = getTimeByZone(session).toString();
		}
		if (startTime.equals("")) {
			startTime = ReportStartdate(date, empFormatdate);
		}
		if (endTime.equals("")) {
			endTime = formatDate(date, empFormatdate);
		}

		if (branchId.equals("0")) {
			if (!inputObj.isNull("drBranchId")) {
				drBranchId = PadQuotes(inputObj.getString("drBranchId"));
			}
			if (drBranchId.equals("")) {
				drBranchId = "0";
			}
		} else {
			drBranchId = branchId;
		}
	}

	protected void validateFields() throws ParseException {
		msg = "";
		if (startTime.equals("")) {
			msg = msg + "Select Start Date!<br>";
		} else {
			if (isValidDateFormat(startTime, empFormatdate)) {
				starttime = formatDateStr(startTime, empFormatdate);
			} else {
				msg = msg + "<br>Enter Valid Start Date!";
			}
		}

		if (endTime.equals("")) {
			msg = msg + "Select End Date!<br>";
		} else {
			if (isValidDateFormat(endTime, empFormatdate)) {
				endtime = formatDateStr(endTime, empFormatdate);
				if (!startTime.equals("") && !endTime.equals("") && Long.parseLong(starttime) > Long.parseLong(endtime)) {
					msg = msg + "Start Date should be less than End date!";
				}
			} else {
				msg = msg + "<br>Enter Valid End Date!";
			}
		}
	}
	public Map<String, String> populateData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap();
		String strSearch = "";
		long grandTotal = 0L;
		branchAccess = getSession("branchAccess", session).replaceAll("branchId", "ticket.axelaCustomers.customerBranchId");
		exeAccess = getSession("exeAccess", session).replaceAll("empId", "ticket.axelaEmp.EmpId");
		if (!starttime.equals("")) {
			strSearch = " and substr(faq.ticketfaqEntryDate,1,8) >= substr('" + starttime + "',1,8) ";
		}
		if (!endtime.equals("")) {
			strSearch = strSearch + " and substr(faq.ticketfaqEntryDate,1,8) <= substr('" + endtime + "',1,8) ";
		}
		if (!msg.equals("")) {
			msg = "<br>Error!" + msg;
		}
		strSearch += branchAccess + "" + exeAccess + "";
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<AxelaHelpDeskTicketFaq> contract = faqFilterImpl.findFaqSummary(strSearch, session);
		for (AxelaHelpDeskTicketFaq results : contract) {
			LinkedHashMap map = new LinkedHashMap<String, String>();
			map.put("Total", results.getTotal());
			map.put("Active", results.getActive());
			map.put("Inactive", results.getInactive());
			list.add(map);
		}
		output.put("populateData", list);
		return output;
	}
}
