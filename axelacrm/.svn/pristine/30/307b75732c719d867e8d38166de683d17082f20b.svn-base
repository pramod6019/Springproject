package axela.helpdesk.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.helpdesk.model.AxelaHelpDeskTicketType;
import axela.helpdesk.repository.HelpDeskTicketTypeRepository;
import axela.portal.model.AxelaEmp;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;

@Service
public class TicketTypeService extends Connect
{

	private final static int PAGESIZE = 25;
	public String tickettypeId = "0";
	public String tickettypeEntryDate = "";
	public String tickettypeEntryId = "0";
	public String tickettypeModifiedDate = "";
	public String tickettypeModifiedId = "0";
	public String tickettypeName = "";
	public String requestType = "";
	public String msg = "";
	public String pageNumber = "";
	public int empId = 0;
	public String sortField = "";
	public String sortDirection = "";
	public int page = 0;
	public String perPage = "0";
	String branches = "";
	public String strSearch = "";
	public String branchAccess = "";
	public String exeAccess = "";
	public int length = 0;
	public int totalCount = 0;
	HashMap output = null;
	int compId = 0;

	JSONObject inputObj = null;

	@Autowired
	private axela.helpdesk.repository.AxelaTicketTypeRepository axelaTicketTypeRepository;

	@Autowired
	HelpDeskTicketTypeRepository helpDeskTicketTypeRepository;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	PortalFilterImpl portalFilterImpl;

	public Map<String, String> ticketTypeService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		switch (requestType) {
			case "add" :
				tickettypeId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "update" :
				tickettypeId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "delete" :
				if (!inputObj.isNull("tickettypeId")) {
					tickettypeId = inputObj.getString("tickettypeId");
				}
				if (!tickettypeId.equals("0")) {
					deleteFields(tickettypeId);
				}
				break;

		}
		return output;
	}
	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("tickettypeId")) {
			tickettypeId = CNumeric(inputObj.getString("tickettypeId"));
		}
		if (!inputObj.isNull("tickettypeName")) {
			tickettypeName = PadQuotes(inputObj.getString("tickettypeName"));
		}
		if (!inputObj.isNull("tickettypeEntryDate")) {
			tickettypeEntryDate = PadQuotes(inputObj.getString("tickettypeEntryDate"));
		}
		if (!inputObj.isNull("tickettypeModifiedId")) {
			tickettypeModifiedId = CNumeric(inputObj.getString("tickettypeModifiedId"));
		}
		if (!inputObj.isNull("tickettypeModifiedDate")) {
			tickettypeModifiedDate = PadQuotes(inputObj.getString("tickettypeModifiedDate"));
		}
		if (!inputObj.isNull("tickettypeEntryId")) {
			tickettypeEntryId = CNumeric(inputObj.getString("tickettypeEntryId"));
		}
	}

	public void checkForm() {
		if (tickettypeName.equals("")) {
			msg += "Enter Ticket Type Name!";
		}
	}

	public void addFields(HttpServletResponse response) throws ParseException {
		checkForm();
		AxelaHelpDeskTicketType axelaHelpDeskTicketType = null;
		if (msg.equals("")) {
			if (!tickettypeId.equals("0")) {
				axelaHelpDeskTicketType = helpDeskTicketTypeRepository.findOne(Integer.parseInt(tickettypeId));
			} else {
				axelaHelpDeskTicketType = new AxelaHelpDeskTicketType();
			}
			axelaHelpDeskTicketType.setTickettypeId(Integer.parseInt(tickettypeId));
			axelaHelpDeskTicketType.setTickettypeName(tickettypeName);
			if (tickettypeId.equals("0") && requestType.equals("add")) {
				axelaHelpDeskTicketType.setTickettypeEntryId(empId);
				axelaHelpDeskTicketType.setTickettypeEntryDate(stringToDate(toLongDate(kknow())));
				axelaHelpDeskTicketType.setTickettypeModifiedId(0);
				// axelaHelpDeskTicketType.setTickettypeModifiedDate("");
			} else if (!tickettypeId.equals("0") && requestType.equals("update")) {
				axelaHelpDeskTicketType.setTickettypeModifiedId(empId);
				axelaHelpDeskTicketType.setTickettypeModifiedDate(stringToDate(toLongDate(kknow())));
			}

			tickettypeId = helpDeskTicketTypeRepository.save(axelaHelpDeskTicketType).getTickettypeId() + "";
			if (tickettypeId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("successmsg", "Ticket Type Added  Successfully!");
			} else if (!tickettypeId.equals("0") && requestType.equals("update")) {
				output.put("successmsg", "Ticket Type Updated Successfully!");
			}
		} else {
			response.setStatus(400);
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String tickettypeId) {
		helpDeskTicketTypeRepository.delete(Integer.parseInt(tickettypeId));
		output.put("successmsg", "Ticket Type Deleted Successfully!");
	}

	public Map<String, List> populateData(String input) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		LinkedHashMap map = new LinkedHashMap();
		if (!inputObj.isNull("tickettypeId")) {
			tickettypeId = CNumeric(PadQuotes(inputObj.getString("tickettypeId")));
		}
		if (!tickettypeId.equals("0")) {
			AxelaHelpDeskTicketType axelaHelpDeskTicketType = helpDeskTicketTypeRepository.findOne(Integer.parseInt(tickettypeId));
			if (axelaHelpDeskTicketType != null) {
				map.put("tickettypeName", axelaHelpDeskTicketType.getTickettypeName());
				AxelaEmp axelaEmp = empRepository.findByEmpId(axelaHelpDeskTicketType.getTickettypeId());
				if (axelaHelpDeskTicketType.getTickettypeEntryId() != 0) {
					map.put("tickettypeEntryId", axelaHelpDeskTicketType.getTickettypeEntryId());
					map.put("tickettypeEntryBy", axelaEmp.getEmpName());
					map.put("tickettypeEntryDate", strToShortDate(axelaHelpDeskTicketType.getTickettypeEntryDate()));
				}
				if (axelaHelpDeskTicketType.getTickettypeModifiedId() != 0) {
					map.put("tickettypeModifiedId", axelaHelpDeskTicketType.getTickettypeModifiedId());
					map.put("tickettypeModifiedBy", axelaEmp.getEmpName());
					map.put("tickettypeModifiedDate", strToShortDate(axelaHelpDeskTicketType.getTickettypeModifiedDate()));
				}
				list.add(map);
				output.put("populateData", list);
			}
		}
		return output;
	}

	public Map listData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		page = 0;
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			List<AxelaHelpDeskTicketType> ticketTypeList = null;
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			PageRequest request = null;
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			if (!inputObj.isNull("sortField")) {
				sortField = PadQuotes((inputObj.getString("sortField")));
			}
			if (!inputObj.isNull("pageIndex")) {
				page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
			}
			if (!inputObj.isNull("sortDirection")) {
				sortDirection = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
			}
			// perPage = CNumeric(getSession("emp_recperpage", session));
			if (perPage.equals("0")) {
				perPage = "25";
			}
			if (sortDirection.equals("")) {
				sortDirection = "DESC";
			}
			if (sortField.equals("")) {
				sortField = "tickettypeId";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			String strOrderBy = " ORDER BY type." + sortField + " " + sortDirection;
			ticketTypeList = portalFilterImpl.findAllTicketType(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			totalCount = Integer.parseInt(PortalFilterImpl.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Ticket Type Details", "tickettypeName", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaHelpDeskTicketType obj : ticketTypeList) {
				ArrayList<String> param = new ArrayList<String>();
				ArrayList type = new ArrayList();
				ArrayList value = new ArrayList();
				ArrayList<String> actionParam = new ArrayList<String>();
				ArrayList<ArrayList> paramArr = new ArrayList<ArrayList>();
				HashMap<String, List<HashMap>> mapData = new HashMap<String, List<HashMap>>();
				HashMap<String, List<HashMap>> mapAction = new HashMap<String, List<HashMap>>();
				HashMap<String, List<String>> mapBodyData = new HashMap<String, List<String>>();
				List<HashMap> listData = new ArrayList<HashMap>();
				count++;

				type.add(false);
				value.add(count);
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				type.add(false);
				value.add(obj.getTickettypeName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				mapData.put("td", listData);
				actionParam.add("updateTicketType");
				actionParam.add(obj.getTickettypeId() + "");
				mapAction.put("td", produceActionData(actionParam));

				listAction.add(mapAction);
				listBody.add(mapData);
			}
			output.put("meta", mapNavi);
			output.put("thead", listHeader);
			output.put("tdalign", listBodyAlign);
			output.put("tbody", listBody);
			output.put("action", listAction);
			if (AppRun().equals("0")) {
				SOP("output==========Service==========" + output.toString());
			}
		}
		return output;
	}
	private ArrayList<HashMap> produceActionData(ArrayList<String> actionParam) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Ticket Type");
		mapBodyData.put("param", actionParam);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "type.*"));
		list.add(buildSmartArr("Type ID", "numeric", "type.tickettypeId"));
		list.add(buildSmartArr("Type Name", "text", "type.tickettypeName"));
		// list.add(buildSmartArr("Entry By", "text", "type.tickettypeEntryId)"));
		list.add(buildSmartArr("Entry Date", "date", "type.tickettypeEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "type.tickettypeModifiedId"));
		list.add(buildSmartArr("Modified Date", "date", "type.tickettypeModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

}
