package axela.helpdesk.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.helpdesk.model.AxelaHelpDeskTicketHoli;
import axela.helpdesk.repository.HelpDeskTicketHoliRepository;
import axela.helpdesk.repository.TicketRepositoryImpl;
import axela.portal.repository.EmpRepository;

@Service
public class TicketHolidayService extends Connect {

	@Autowired
	HelpDeskTicketHoliRepository helpDeskTicketHoliRepository;

	@Autowired
	TicketRepositoryImpl ticketRepositoryImpl;

	@Autowired
	EmpRepository empRepository;

	HashMap output = null;
	JSONObject inputObj = null;
	public String msg = "";
	public String compId = "0";
	public String StrSql = "";
	public String empId = "0";
	public String empRoleId = "0";
	public String branchId = "0";
	public String branchAccess = "";
	public String ticketholiId = "0";
	public int page = 0;
	public String ticketholiBranchId = "0";
	public String ticketholiName = "";
	public String ticketholiDate = "";
	public String holidaydate = "";
	public String ticketholiEntryId = "0";
	public String ticketholiEntryDate = "";
	public String ticketholiModifiedId = "0";
	public String ticketholiModifiedDate = "";
	public String entryId = "";
	public String entryDate = "";
	public String modifiedId = "";
	public String modifiedDate = "";
	public String strOrderBy = "";
	public String strHTML = "";
	public String empFormatdate = "";
	public String formatdateDatepicker = "";
	public String empFormattime = "";
	public String requestType = "";
	private String perPage = "";
	private String exeAccess = "";
	private String orderByField = "";
	private String orderType = "";
	public int totalCount = 0;
	public String group = "";
	SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

	public Map ticketHolidayService(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, SQLException, ParseException {
		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("inputObj========ticketHolidayService==========" + inputObj.toString(1));
		}
		compId = CNumeric(getSession("compId", session));
		empId = CNumeric(getSession("empId", session));
		empRoleId = CNumeric(getSession("empRoleId", session));
		branchId = CNumeric(getSession("empBranchId", session));
		branchAccess = getSession("branchAccess", session) + "";
		exeAccess = getSession("exeAccess", session) + "";
		empFormatdate = getSession("formatdateName", session);
		formatdateDatepicker = getSession("formatdateDatepicker", session);
		empFormattime = getSession("formattimeName", session);
		output = new HashMap<String, String>();

		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (!empId.equals("0")) {
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			switch (requestType) {
				case "add" : // add a ticket.
					ticketholiId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;

				case "update" :// update a ticket.
					ticketholiId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;

				case "delete" : // delete a ticketholi.
					if (!inputObj.isNull("ticketholiId")) {
						ticketholiId = CNumeric(PadQuotes(inputObj.getString("ticketholiId")));
					}
					if (!ticketholiId.equals("0")) {
						deleteFields(ticketholiId);
					}
					break;
			}
		}
		if (AppRun().equals("0")) {
			SOP("output========ticketHolidayService==========" + output);
		}
		return output;
	}

	private void getValues(JSONObject inputObj) throws JSONException {
		if (!inputObj.isNull("ticketholiId")) {
			ticketholiId = PadQuotes(inputObj.getString("ticketholiId"));
		}

		if (!inputObj.isNull("ticketholiBranchId")) {
			ticketholiBranchId = CNumeric(PadQuotes(inputObj.getString("ticketholiBranchId")));
		}

		if (!inputObj.isNull("ticketholiName")) {
			ticketholiName = PadQuotes(inputObj.getString("ticketholiName"));
		}

		if (!inputObj.isNull("ticketholiDate")) {
			ticketholiDate = PadQuotes(inputObj.getString("ticketholiDate"));
		}

		if (!inputObj.isNull("entryDate")) {
			entryDate = PadQuotes(inputObj.getString("entryDate"));
		}

		if (!inputObj.isNull("modifiedDate")) {
			modifiedDate = PadQuotes(inputObj.getString("modifiedDate"));
		}

		if (!inputObj.isNull("entryId")) {
			entryId = PadQuotes(inputObj.getString("entryId"));
		}

		if (!inputObj.isNull("modifiedId")) {
			modifiedId = PadQuotes(inputObj.getString("modifiedId"));
		}
	}

	public void validateFields() throws NumberFormatException, ParseException {
		msg = "";
		if (ticketholiBranchId.equals("0")) {
			msg += "<br>Select Branch!";
		}

		if (ticketholiName.equals("")) {
			msg += "<br>Enter Name!";
		}

		if (ticketholiDate.equals("")) {
			msg += "<br>Select Holiday Date!";
		} else {
			if (!isValidDateFormat(ticketholiDate, empFormatdate)) {
				ticketholiDate = holidaydate;
				msg += "<br>Enter Valid Holiday Date!";
				holidaydate = "";
			}
		}
		if (!ticketholiName.equals("") && !ticketholiDate.equals("") && isValidDateFormat(ticketholiDate, empFormatdate)) {
			SOP("ticketholiName=====555555555========" + ticketholiName);
			SOP("ticketholiDate========4444444444=====" + ticketholiDate);
			List<AxelaHelpDeskTicketHoli> holi = helpDeskTicketHoliRepository.findTicketHoliNameAndDate(ticketholiName, stringToDate(ticketholiDate), Integer.parseInt(ticketholiId));
			SOP("holi=======" + holi);
			if (!holi.isEmpty()) {
				msg += "<br>Similar Holiday Name and Date is Found!";
			}
		}
	}
	public void addFields(HttpServletResponse response, HttpSession session) throws ParseException {
		validateFields();
		AxelaHelpDeskTicketHoli axelaHelpDeskTicketHoli = null;
		if (msg.equals("")) {
			if (!ticketholiId.equals("0")) {
				axelaHelpDeskTicketHoli = helpDeskTicketHoliRepository.findOne(Integer.parseInt(ticketholiId));
			} else {
				axelaHelpDeskTicketHoli = new AxelaHelpDeskTicketHoli();
			}
			axelaHelpDeskTicketHoli.setTicketholiBranchId(Integer.parseInt(ticketholiBranchId));
			axelaHelpDeskTicketHoli.setTicketholiName(ticketholiName);
			axelaHelpDeskTicketHoli.setTicketholiDate(stringToDate(ticketholiDate));
			if (requestType.equals("add")) {
				axelaHelpDeskTicketHoli.setTicketholiEntryDate(getTimeByZone(session));
				axelaHelpDeskTicketHoli.setTicketholiEntryId(Integer.parseInt(empId));
				axelaHelpDeskTicketHoli.setTicketholiModifiedId(0);
			} else {
				axelaHelpDeskTicketHoli.setTicketholiEntryDate(axelaHelpDeskTicketHoli.getTicketholiEntryDate());
				axelaHelpDeskTicketHoli.setTicketholiEntryId(axelaHelpDeskTicketHoli.getTicketholiEntryId());
				axelaHelpDeskTicketHoli.setTicketholiModifiedId(Integer.parseInt(empId));
				axelaHelpDeskTicketHoli.setTicketholiModifiedDate(getTimeByZone(session));
			}
			AxelaHelpDeskTicketHoli result = null;
			result = helpDeskTicketHoliRepository.save(axelaHelpDeskTicketHoli);
			if (result != null && requestType.equals("add")) {
				output.put("successmsg", "Ticket Holiday Added Successfully!");
				output.put("ticketholiId", result.getTicketholiId() + "");
			} else if (result != null && requestType.equals("update")) {
				output.put("successmsg", "Ticket Holiday Updated Successfully!");
				output.put("ticketholiId", result.getTicketholiId() + "");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String ticketholiId) {
		helpDeskTicketHoliRepository.delete(Integer.parseInt(ticketholiId));
		output.put("successmsg", "TicketHoliday Deleted Successfully!");
	}

	public Map<String, String> populateData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, String>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		AxelaHelpDeskTicketHoli axelaHelpDeskTicketHoli = new AxelaHelpDeskTicketHoli();
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		if (!inputObj.isNull("ticketholiId")) {
			ticketholiId = CNumeric(PadQuotes(inputObj.getString("ticketholiId")));
		}
		if (!ticketholiId.equals("0")) {
			List<AxelaHelpDeskTicketHoli> holi = ticketRepositoryImpl.populateHolidayData(ticketholiId, session);
			for (AxelaHelpDeskTicketHoli results : holi) {
				map.put("ticketholiId", CNumeric(results.getTicketholiId() + ""));
				map.put("ticketholiBranchId", CNumeric(results.getBranchId() + ""));
				map.put("ticketholiDate", sdf.format(results.getTicketholiDate()));
				map.put("ticketholiName", PadQuotes(results.getTicketholiName() + ""));
				if (results.getTicketholiEntryId() != 0) {
					map.put("ticketholiEntryDate", strToShortDate(results.getTicketholiEntryDate()));
					map.put("ticketholiEntryId", String.valueOf(results.getTicketholiEntryId()));
					map.put("ticketholiEntryBy", empRepository.findEmpName(Integer.parseInt(String.valueOf(results.getTicketholiEntryId()))));
				}
				if (results.getTicketholiModifiedId() != 0) {
					map.put("ticketholiModifiedDate", strToShortDate(results.getTicketholiModifiedDate()));
					map.put("ticketholiModifiedId", String.valueOf(results.getTicketholiModifiedId()));
					map.put("ticketholiModifiedBy", empRepository.findEmpName(Integer.parseInt(String.valueOf(results.getTicketholiModifiedId()))));
				}
				list.add(map);
			}
			output.put("populateData", list);
		}
		return output;
	}

	public Map<String, String> holidayList(String input, HttpSession session) throws JSONException, ParseException {
		String strOrderBy = "";
		String strSearch = "";
		page = 0;
		compId = CNumeric(getSession("compId", session));
		empId = CNumeric(getSession("empId", session));
		perPage = CNumeric(getSession("empRecperpage", session));
		empFormatdate = PadQuotes(getSession("formatdateName", session));
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, String>();
		List<AxelaHelpDeskTicketHoli> holiList = null;
		ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
		List<HashMap> listBody = new ArrayList<HashMap>();
		List<HashMap> listAction = new ArrayList<HashMap>();
		ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!inputObj.isNull("sortField")) {
			orderByField = PadQuotes((inputObj.getString("sortField")));
		}
		if (!inputObj.isNull("pageIndex")) {
			page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
		}
		if (!inputObj.isNull("group")) {
			group = CNumeric(PadQuotes((inputObj.getString("group"))));
		}
		if (!inputObj.isNull("requestType")) {
			requestType = PadQuotes((inputObj.getString("requestType")));
		}
		if (!inputObj.isNull("sortDirection")) {
			orderType = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
		}
		perPage = "25";
		if (perPage.equals("0")) {
			perPage = "25";
		}

		if (orderType.equals("")) {
			orderType = "DESC";
		}
		if (orderByField.equals("")) {
			orderByField = "ticketholiDate";
		}
		page++;
		if (requestType.equals("filter")) {
			strSearch = buildSmartSearch(input);
		}
		strSearch += branchAccess + exeAccess;
		strOrderBy = " ORDER BY holi." + orderByField + " " + orderType + "";
		holiList = ticketRepositoryImpl.findAllHoli(strSearch, strOrderBy, page, Integer.parseInt(perPage));
		totalCount = Integer.parseInt(ticketRepositoryImpl.totalCount);
		Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
		int count = 0;
		// Start Header Data
		listHeader.add(produceHeaderData("ID", "ticketholiId", "center"));
		listHeader.add(produceHeaderData("Name", "ticketholiName", "left"));
		listHeader.add(produceHeaderData("Branch", "axelaBranch.branchId", "left"));
		listHeader.add(produceHeaderData("Date", "ticketholiDate", "center"));
		// End Header Data

		// Start Body Align
		listBodyAlign.add(produceBodyAlign("center"));
		listBodyAlign.add(produceBodyAlign("center"));
		listBodyAlign.add(produceBodyAlign("left"));
		listBodyAlign.add(produceBodyAlign("left"));
		listBodyAlign.add(produceBodyAlign("center"));
		listBodyAlign.add(produceBodyAlign("left"));
		// End Body Align
		StringBuilder dataString = null;
		for (AxelaHelpDeskTicketHoli obj : holiList) {
			ArrayList<String> paramSubArr = new ArrayList<String>();
			ArrayList<ArrayList> paramArr = new ArrayList<ArrayList>();
			ArrayList type = new ArrayList();
			ArrayList value = new ArrayList();
			HashMap<String, List<HashMap>> mapData = new HashMap<String, List<HashMap>>();
			HashMap<String, List<HashMap>> mapAction = new HashMap<String, List<HashMap>>();
			HashMap<String, List<String>> mapBodyData = new HashMap<String, List<String>>();
			List<HashMap> listData = new ArrayList<HashMap>();
			count++;
			// Start Body data
			// count
			type.add(false);
			value.add(count);
			listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
			type.clear();
			value.clear();
			// ID
			type.add(false);
			value.add(obj.getTicketholiId());
			listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
			type.clear();
			value.clear();
			// Name
			type.add(false);
			value.add(obj.getTicketholiName());
			listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
			type.clear();
			value.clear();
			// Branch
			type.add(true);
			value.add(obj.getBranchname());
			paramSubArr.add("branchSummary");
			paramSubArr.add(obj.getBranchId() + "");
			paramArr.add((ArrayList) paramSubArr.clone());
			listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
			type.clear();
			value.clear();
			paramArr.clear();
			paramSubArr.clear();
			// Date
			type.add(false);
			value.add(obj.getTicketholiDate().toString());
			listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
			type.clear();
			value.clear();
			// End Body data
			mapData.put("td", listData);
			ArrayList<String> actionParam = new ArrayList<String>();
			actionParam.add("updateholiday");
			actionParam.add(PadQuotes(String.valueOf(obj.getTicketholiId())));
			mapAction.put("td", produceActionDataForHoli(actionParam));
			listAction.add(mapAction);
			listBody.add(mapData);
		}
		output.put("meta", mapNavi);
		output.put("thead", listHeader);
		output.put("tdalign", listBodyAlign);
		output.put("tbody", listBody);
		output.put("action", listAction);
		if (AppRun().equals("0")) {
		}
		return output;
	}

	private ArrayList<HashMap> produceActionDataForHoli(ArrayList<String> Param) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Holiday");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart(HttpSession session) {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "holi.*"));
		list.add(buildSmartArr("Holiday ID", "numeric", "holi.ticketholiId"));
		list.add(buildSmartArr("Holiday Name", "text", "holi.ticketholiName"));
		list.add(buildSmartArr("Branch ID", "text", "holi.axelaBranch.branchId"));
		list.add(buildSmartArr("Branch Name", "text", "CONCAT(holi.axelaBranch.branchName, ' (',holi.axelaBranch.branchCode, ')')"));
		list.add(buildSmartArr("Holiday Date", "text", "holi.ticketholiDate"));
		// list.add(buildSmartArr("Entry By", "text", "ticketholi_entry_id IN (SELECT emp_id FROM compdb.axela_emp WHERE emp_name"));
		list.add(buildSmartArr("Entry Date", "date", "holi.ticketholiEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "ticketholi_modified_id IN (SELECT emp_id FROM compdb.axela_emp WHERE emp_name"));
		list.add(buildSmartArr("Modified Date", "date", "holi.ticketholiModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}
}
