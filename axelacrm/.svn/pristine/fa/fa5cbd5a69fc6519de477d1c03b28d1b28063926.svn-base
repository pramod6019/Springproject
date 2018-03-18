package axela.helpdesk.service;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.helpdesk.model.AxelaHelpDeskTicketQueue;
import axela.helpdesk.model.AxelaHelpDeskTicketStatus;
import axela.helpdesk.repository.TicketQueueFilterImpl;
import axela.helpdesk.repository.TicketRepositoryImpl;
import axela.helpdesk.repository.TicketStatusFilterImpl;

@Service
public class ReportTicketDashboardService extends Connect {

	@Autowired
	TicketStatusFilterImpl ticketStatusFilterImpl;

	@Autowired
	TicketQueueFilterImpl ticketQueueFilterImpl;

	@Autowired
	private TicketRepositoryImpl ticketRepositoryImpl;

	public String ticketId = "0";
	public String empId = "0";
	public String msg = "";
	public String strSql = "";
	public String exeAccess = "";
	public String branchAccess = "";
	public String ticketsToday = "";
	public String closedToday = "";
	public String openTickets = "";
	public String Queues = "";
	public String day1Name = "", day1 = "", day2Name = "", day2 = "", day3Name = "", day3 = "", day4Name = "", day4 = "", day5Name = "", day5 = "", day6Name = "", day6 = "", day7Name = "", day7 = "",
			day8Name = "", day8 = "";
	public String cday1Name = "", cday1 = "", cday2Name = "", cday2 = "", cday3Name = "", cday3 = "", cday4Name = "", cday4 = "", cday5Name = "", cday5 = "", cday6Name = "", cday6 = "",
			cday7Name = "", cday7 = "";
	public int week1, week2, week3, week4;
	public String logWeek1, logWeek2, logWeek3, logWeek4;
	public String closeWeek1, closeWeek2, closeWeek3, closeWeek4;
	public String month1, month2, month3, month4;
	public String logMonth1, logMonth2, logMonth3, logMonth4;
	public String closeMonth1, closeMonth2, closeMonth3, closeMonth4;
	public String qur1, qur2, qur3, qur4, quarter;
	public String logQur1, logQur2, logQur3, logQur4;
	public String closeQur1, closeQur2, closeQur3, closeQur4;
	public String compId = "0";
	public JSONObject inputObj = null;
	public String requestType = "";
	public Map output = new HashMap();
	public String strSearch = "";
	public long count = 0L;
	public long count1 = 0L;
	public long count2 = 0L;
	public long count3 = 0L;
	public String day1name = "";
	public String day2name = "";
	public String day3name = "";
	public String day4name = "";
	public String day5name = "";
	public String day6name = "";
	public String day7name = "";

	public Map reportTicketDashboard(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException, UnsupportedEncodingException {
		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("inputObj========ticketReportService==========" + inputObj.toString(1));
		}
		compId = CNumeric(getSession("compId", session));
		empId = CNumeric(getSession("empId", session));
		exeAccess = getSession("ExeAccess", session);
		if (!empId.equals("0")) {
			if (!returnPerm("emp_report_access, emp_mis_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			Stats(session);
		} else {
			output.put("errormsg", msg);
		}
		if (AppRun().equals("0")) {
			SOP("inputObj========ticketReportService==========" + output);
		}
		return output;
	}

	public void Stats(HttpSession session) throws UnsupportedEncodingException {

		ArrayList<HashMap<String, String>> listt = new ArrayList<HashMap<String, String>>();
		String startWeek, endWeek, startMonth, endMonth;
		StringBuilder StrTicketsToday = new StringBuilder();
		StringBuilder StrClosedToday = new StringBuilder();
		StringBuilder StrOpenTickets = new StringBuilder();
		StringBuilder StrQueues = new StringBuilder();

		Calendar cal = Calendar.getInstance();
		int currMonth = cal.get(cal.MONTH);
		int currYear = cal.get(cal.YEAR);
		int currDate = cal.get(cal.DATE);

		// -----------------------------Logged Today-----------------------------------------------------------------------------
		List<AxelaHelpDeskTicketStatus> status = ticketStatusFilterImpl.findAllReportTime(exeAccess, currYear, currMonth, currDate, session);
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (AxelaHelpDeskTicketStatus results : status) {
			LinkedHashMap map = new LinkedHashMap<String, String>();
			map.put("ticketstatusName", results.getTicketstatusName());
			map.put("ticketstatusId", results.getTicketstatusId());
			count = count + results.getTicketCount();
			list.add(map);
		}
		output.put("TotalReportTicket", count);
		output.put("populateTicketReportStatus", list);

		List<AxelaHelpDeskTicketStatus> status1 = ticketStatusFilterImpl.findAllClosedTime(exeAccess, currYear, currMonth, currDate, session);
		ArrayList<HashMap<String, String>> list1 = new ArrayList<HashMap<String, String>>();
		for (AxelaHelpDeskTicketStatus results : status1) {
			LinkedHashMap map1 = new LinkedHashMap<String, String>();
			map1.put("ticketstatusName", results.getTicketstatusName());
			map1.put("ticketstatusId", results.getTicketstatusId());
			count1 = count1 + results.getTicketCount();
			list1.add(map1);
		}
		output.put("TotalClosedTicket", count1);
		output.put("populateTicketClosedStatus", list1);

		List<AxelaHelpDeskTicketStatus> status2 = ticketStatusFilterImpl.findAllReportOpen(exeAccess, currYear, currMonth, currDate, session);
		ArrayList<HashMap<String, String>> list2 = new ArrayList<HashMap<String, String>>();
		for (AxelaHelpDeskTicketStatus results : status2) {
			LinkedHashMap map2 = new LinkedHashMap<String, String>();
			map2.put("ticketstatusName", results.getTicketstatusName());
			map2.put("ticketstatusId", results.getTicketstatusId());
			count2 = count2 + results.getTicketCount();
			list2.add(map2);
		}
		output.put("TotalReportOpenStatus", count2);
		output.put("populateTotalOpenRecordStatus", list2);

		List<AxelaHelpDeskTicketQueue> status3 = ticketQueueFilterImpl.findAllReportOpenQueue(exeAccess, currYear, currMonth, currDate, session);
		ArrayList list3 = new ArrayList<HashMap<String, String>>();
		for (AxelaHelpDeskTicketQueue results : status3) {
			LinkedHashMap map3 = new LinkedHashMap<String, String>();
			map3.put("ticketstatusName", results.getTicketqueueName());
			map3.put("ticketstatusId", results.getTicketqueueId());
			count3 = count3 + results.getTicketCount();
			list3.add(map3);
		}
		output.put("TotalReportQueueOpen", count3);
		output.put("populateTotalOpenRecordQueue", list3);
		// -----------------------------Logged Days----------------------------------------------------------------------------
		cal = Calendar.getInstance();
		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		currDate = cal.get(cal.DATE);
		day1name = "" + currDate + " " + textMonth(currMonth);
		Long status4 = ticketRepositoryImpl.findDayOneTicket(exeAccess, currYear, currMonth, currDate, session);
		SOP("status4==========" + status4);
		LinkedHashMap map = new LinkedHashMap<String, String>();
		map.put("count", status4);
		map.put("dayName", day1name);
		listt.add(map);

		cal.add(cal.DATE, -1);
		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		currDate = cal.get(cal.DATE);
		cal.set(currYear, currMonth, currDate);
		day2name = "" + currDate + " " + textMonth(currMonth);
		Long status5 = ticketRepositoryImpl.findDayTwoTicket(exeAccess, currYear, currMonth, currDate, session);
		SOP("status5==========" + status5);
		ArrayList<HashMap<String, String>> list5 = new ArrayList<HashMap<String, String>>();
		LinkedHashMap map1 = new LinkedHashMap<String, String>();
		map1.put("count", status5);
		map1.put("dayName", day2name);
		listt.add(map1);

		cal.add(cal.DATE, -1);
		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		currDate = cal.get(cal.DATE);
		cal.set(currYear, currMonth, currDate);
		day3name = "" + currDate + " " + textMonth(currMonth);
		Long status6 = ticketRepositoryImpl.findDayThreeTicket(exeAccess, currYear, currMonth, currDate, session);
		ArrayList<HashMap<String, String>> list6 = new ArrayList<HashMap<String, String>>();
		LinkedHashMap map2 = new LinkedHashMap<String, String>();
		map2.put("count", status6);
		map2.put("dayName", day3name);
		listt.add(map2);

		cal.add(cal.DATE, -1);
		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		currDate = cal.get(cal.DATE);
		cal.set(currYear, currMonth, currDate);
		day4name = "" + currDate + " " + textMonth(currMonth);
		Long status7 = ticketRepositoryImpl.findDayFourTicket(exeAccess, currYear, currMonth, currDate, session);
		LinkedHashMap map3 = new LinkedHashMap<String, String>();
		ArrayList<HashMap<String, String>> list7 = new ArrayList<HashMap<String, String>>();
		map3.put("count", status7);
		map3.put("dayName", day4name);
		listt.add(map3);

		cal.add(cal.DATE, -1);
		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		currDate = cal.get(cal.DATE);
		cal.set(currYear, currMonth, currDate);
		day5name = "" + currDate + " " + textMonth(currMonth);
		Long status8 = ticketRepositoryImpl.findDayFiveTicket(exeAccess, currYear, currMonth, currDate, session);
		LinkedHashMap map4 = new LinkedHashMap<String, String>();
		ArrayList<HashMap<String, String>> list8 = new ArrayList<HashMap<String, String>>();
		map4.put("count", status8);
		map4.put("dayName", day5name);
		listt.add(map4);

		cal.add(cal.DATE, -1);
		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		currDate = cal.get(cal.DATE);
		cal.set(currYear, currMonth, currDate);
		day6name = "" + currDate + " " + textMonth(currMonth);
		Long status9 = ticketRepositoryImpl.findDaySixTicket(exeAccess, currYear, currMonth, currDate, session);
		LinkedHashMap map5 = new LinkedHashMap<String, String>();
		ArrayList<HashMap<String, String>> list9 = new ArrayList<HashMap<String, String>>();
		map5.put("count", status9);
		map5.put("dayName", day6name);
		listt.add(map5);

		cal.add(cal.DATE, -1);
		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		currDate = cal.get(cal.DATE);
		cal.set(currYear, currMonth, currDate);
		day7name = "" + currDate + " " + textMonth(currMonth);
		Long status10 = ticketRepositoryImpl.findDaySevenTicket(exeAccess, currYear, currMonth, currDate, session);
		LinkedHashMap map6 = new LinkedHashMap<String, String>();
		ArrayList<HashMap<String, String>> list10 = new ArrayList<HashMap<String, String>>();
		map6.put("count", status10);
		map6.put("dayName", day7name);
		listt.add(map6);
		output.put("day", listt);
		// -----------------------------Logged Weeks-----------------------------------------------------------------------------
		ArrayList<HashMap<String, String>> list11 = new ArrayList<HashMap<String, String>>();
		cal = Calendar.getInstance();
		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		currDate = cal.get(cal.DATE);

		startWeek = currYear + "-" + doublenum(currMonth + 1) + "-" + doublenum(currDate + 7 - cal.get(cal.DAY_OF_WEEK));
		SOP("startWeek==========" + startWeek);
		week1 = cal.get(cal.WEEK_OF_YEAR);

		cal.add(cal.DATE, -cal.get(cal.DAY_OF_WEEK) + 2);
		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		currDate = cal.get(cal.DATE);
		endWeek = currYear + "-" + doublenum(currMonth + 1) + "-" + doublenum(currDate);
		SOP("endWeek==========" + endWeek);
		cal.set(currYear, currMonth, currDate);
		Long status11 = ticketRepositoryImpl.findWeekTicket(exeAccess, endWeek, startWeek, session);
		SOP("status11==========" + status11);
		LinkedHashMap map7 = new LinkedHashMap<String, String>();
		map7.put("count", status11);
		map7.put("weekName", "Week " + week1);
		list11.add(map7);

		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		currDate = cal.get(cal.DATE);
		startWeek = currYear + "-" + doublenum(currMonth + 1) + "-" + doublenum(currDate);
		cal.add(cal.DATE, -7);
		week2 = cal.get(cal.WEEK_OF_YEAR);
		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		currDate = cal.get(cal.DATE);
		endWeek = currYear + "-" + doublenum(currMonth + 1) + "-" + doublenum(currDate);
		cal.set(currYear, currMonth, currDate);
		Long status12 = ticketRepositoryImpl.findWeekTicket(exeAccess, endWeek, startWeek, session);
		LinkedHashMap map8 = new LinkedHashMap<String, String>();
		map8.put("count", status12);
		map8.put("weekName", "Week " + week2);
		list11.add(map8);

		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		currDate = cal.get(cal.DATE);
		startWeek = currYear + "-" + doublenum(currMonth + 1) + "-" + doublenum(currDate);
		cal.add(cal.DATE, -7);
		week3 = cal.get(cal.WEEK_OF_YEAR);
		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		currDate = cal.get(cal.DATE);
		endWeek = currYear + "-" + doublenum(currMonth + 1) + "-" + doublenum(currDate);
		cal.set(currYear, currMonth, currDate);
		Long status13 = ticketRepositoryImpl.findWeekTicket(exeAccess, endWeek, startWeek, session);
		LinkedHashMap map9 = new LinkedHashMap<String, String>();
		map9.put("count", status13);
		map9.put("weekName", "Week " + week3);
		list11.add(map9);

		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		currDate = cal.get(cal.DATE);
		startWeek = currYear + "-" + doublenum(currMonth + 1) + "-" + doublenum(currDate);
		cal.add(cal.DATE, -7);
		week4 = cal.get(cal.WEEK_OF_YEAR);
		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		currDate = cal.get(cal.DATE);
		endWeek = currYear + "-" + doublenum(currMonth + 1) + "-" + doublenum(currDate);
		cal.set(currYear, currMonth, currDate);
		Long status14 = ticketRepositoryImpl.findWeekTicket(exeAccess, endWeek, startWeek, session);
		LinkedHashMap map10 = new LinkedHashMap<String, String>();
		map10.put("count", status14);
		map10.put("weekName", "Week " + week4);
		list11.add(map10);
		output.put("week", list11);
		// -----------------------------Logged Months-----------------------------------------------------------------------------
		ArrayList<HashMap<String, String>> list12 = new ArrayList<HashMap<String, String>>();
		cal = Calendar.getInstance();
		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		startMonth = currYear + "-" + doublenum(currMonth + 2) + "-" + doublenum(1);
		month1 = textMonth(currMonth) + " " + currYear;
		cal.add(cal.MONTH, -1);
		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		endMonth = currYear + "-" + doublenum(currMonth + 2) + "-" + doublenum(1);
		cal.set(currYear, currMonth, 1);
		Long status15 = ticketRepositoryImpl.findMonthTicket(exeAccess, endMonth, startMonth, session);
		LinkedHashMap map11 = new LinkedHashMap<String, String>();
		map11.put("count", status15);
		map11.put("monthName", month1);
		list12.add(map11);

		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		startMonth = currYear + "-" + doublenum(currMonth + 2) + "-" + doublenum(1);
		month2 = textMonth(currMonth) + " " + currYear;
		cal.add(cal.MONTH, -1);
		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		endMonth = currYear + "-" + doublenum(currMonth + 2) + "-" + doublenum(1);
		cal.set(currYear, currMonth, 1);
		Long status16 = ticketRepositoryImpl.findMonthTicket(exeAccess, endMonth, startMonth, session);
		LinkedHashMap map12 = new LinkedHashMap<String, String>();
		map12.put("count", status16);
		map12.put("monthName", month2);
		list12.add(map12);

		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		startMonth = currYear + "-" + doublenum(currMonth + 2) + "-" + doublenum(1);
		month3 = textMonth(currMonth) + " " + currYear;
		cal.add(cal.MONTH, -1);
		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		endMonth = currYear + "-" + doublenum(currMonth + 2) + "-" + doublenum(1);
		cal.set(currYear, currMonth, 1);
		Long status17 = ticketRepositoryImpl.findMonthTicket(exeAccess, endMonth, startMonth, session);
		ArrayList<HashMap<String, String>> list17 = new ArrayList<HashMap<String, String>>();
		LinkedHashMap map13 = new LinkedHashMap<String, String>();
		map13.put("count", status17);
		map13.put("monthName", month3);
		list12.add(map13);

		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		startMonth = currYear + "-" + doublenum(currMonth + 2) + "-" + doublenum(1);
		month4 = textMonth(currMonth) + " " + currYear;
		cal.add(cal.MONTH, -1);
		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		endMonth = currYear + "-" + doublenum(currMonth + 1) + "-" + doublenum(1);
		cal.set(currYear, currMonth, 1);
		Long status18 = ticketRepositoryImpl.findMonthTicket(exeAccess, endMonth, startMonth, session);
		LinkedHashMap map14 = new LinkedHashMap<String, String>();
		map14.put("count", status18);
		map14.put("monthName", month4);
		list12.add(map14);
		output.put("month", list12);
		// -----------------------------Logged Quarter-----------------------------------------------------------------------------
		ArrayList<HashMap<String, String>> list13 = new ArrayList<HashMap<String, String>>();
		cal = Calendar.getInstance();
		currMonth = cal.get(cal.MONTH);
		currYear = cal.get(cal.YEAR);
		cal.set(currYear, currMonth, 1);
		if (currMonth >= 0 && currMonth <= 2) {
			qur1 = currYear + " Qtr 1 ";
			quarter = "between 1 and 3";
		}
		if (currMonth >= 3 && currMonth <= 5) {
			qur1 = currYear + " Qtr 2 ";
			quarter = "between 4 and 6";
		}
		if (currMonth >= 6 && currMonth <= 8) {
			qur1 = currYear + " Qtr 3 ";
			quarter = "between 7 and 9";
		}
		if (currMonth >= 9 && currMonth <= 11) {
			qur1 = currYear + " Qtr 4 ";
			quarter = "between 10 and 12";
		}
		Long status19 = ticketRepositoryImpl.findQuatorTicket(exeAccess, currYear, quarter, session);
		LinkedHashMap map15 = new LinkedHashMap<String, String>();
		map15.put("count", status19);
		map15.put("qtrName", qur1);
		list13.add(map15);

		cal.add(cal.MONTH, -3);
		currMonth = cal.get(cal.MONTH);
		if (currMonth == -1) {
			currMonth = 11;
			currYear = currYear - 1;
		} else {
			currYear = cal.get(cal.YEAR);
		}
		cal.set(currYear, currMonth, 1);

		if (currMonth >= 0 && currMonth <= 2) {
			qur2 = currYear + " Qtr 1 ";
			quarter = "between 1 and 3";
		}
		if (currMonth >= 3 && currMonth <= 5) {
			qur2 = currYear + " Qtr 2 ";
			quarter = "between 4 and 6";
		}
		if (currMonth >= 6 && currMonth <= 8) {
			qur2 = currYear + " Qtr 3 ";
			quarter = "between 7 and 9";
		}
		if (currMonth >= 9 && currMonth <= 11) {
			qur2 = currYear + " Qtr 4 ";
			quarter = "between 10 and 12";
		}
		Long status20 = ticketRepositoryImpl.findQuatorTicket(exeAccess, currYear, quarter, session);
		LinkedHashMap map16 = new LinkedHashMap<String, String>();
		map16.put("count", status20);
		map16.put("qtrName", qur2);
		list13.add(map16);

		cal.add(cal.MONTH, -3);
		currMonth = cal.get(cal.MONTH);
		if (currMonth == -1) {
			currMonth = 11;
			currYear = currYear - 1;
		} else {
			currYear = cal.get(cal.YEAR);
		}
		cal.set(currYear, currMonth, 1);

		if (currMonth >= 0 && currMonth <= 2) {
			qur3 = currYear + " Qtr 1 ";
			quarter = "between 1 and 3";
		}
		if (currMonth >= 3 && currMonth <= 5) {
			qur3 = currYear + " Qtr 2 ";
			quarter = "between 4 and 6";
		}
		if (currMonth >= 6 && currMonth <= 8) {
			qur3 = currYear + " Qtr 3 ";
			quarter = "between 7 and 9";
		}
		if (currMonth >= 9 && currMonth <= 11) {
			qur3 = currYear + " Qtr 4 ";
			quarter = "between 10 and 12";
		}
		Long status21 = ticketRepositoryImpl.findQuatorTicket(exeAccess, currYear, quarter, session);
		LinkedHashMap map17 = new LinkedHashMap<String, String>();
		map17.put("count", status21);
		map17.put("qtrName", qur3);
		list13.add(map17);

		cal.add(cal.MONTH, -3);
		currMonth = cal.get(cal.MONTH);
		if (currMonth == -1) {
			currMonth = 11;
			currYear = currYear - 1;
		} else {
			currYear = cal.get(cal.YEAR);
		}
		cal.set(currYear, currMonth, 1);

		if (currMonth >= 0 && currMonth <= 2) {
			qur4 = currYear + " Qtr 1 ";
			quarter = "between 1 and 3";
		}
		if (currMonth >= 3 && currMonth <= 5) {
			qur4 = currYear + " Qtr 2 ";
			quarter = "between 4 and 6";
		}
		if (currMonth >= 6 && currMonth <= 8) {
			qur4 = currYear + " Qtr 3 ";
			quarter = "between 7 and 9";
		}
		if (currMonth >= 9 && currMonth <= 11) {
			qur4 = currYear + " Qtr 4 ";
			quarter = "between 10 and 12";
		}
		Long status22 = ticketRepositoryImpl.findQuatorTicket(exeAccess, currYear, quarter, session);
		LinkedHashMap map18 = new LinkedHashMap<String, String>();
		map18.put("count", status22);
		map18.put("qtrName", qur4);
		list13.add(map18);
		output.put("quarter", list13);
	}
}
