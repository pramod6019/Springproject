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
import axela.helpdesk.model.AxelaHelpDeskTicketStatus;
import axela.helpdesk.repository.HelpDeskTicketStatusRepository;
import axela.helpdesk.repository.TicketStatusFilterImpl;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;

@Service
public class TicketStatusService extends Connect
{

	private final static int PAGESIZE = 25;
	public String ticketstatusId = "0";
	public String ticketstatusEntryDate = "";
	public String ticketstatusEntryId = "0";
	public String ticketstatusModifiedDate = "";
	public String ticketstatusModifiedId = "0";
	public String ticketstatusName = "";
	public String ticketstatusRank = "0";
	public String requestType = "";
	public String msg = "";
	public int empId = 0;
	public int compId = 0;
	public String pageNumber = "";
	HashMap output = null;
	JSONObject inputObj = null;
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

	// @Autowired
	// public AxelaHelpDeskTicketStatus axelaHelpDeskTicketStatus;

	@Autowired
	HelpDeskTicketStatusRepository helpDeskTicketStatusRepository;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	TicketStatusFilterImpl ticketStatusFilterImpl;

	@Autowired
	PortalFilterImpl portalFilterImpl;

	public Map<String, String> ticketstatusservice(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}

		switch (requestType) {

			case "add" :
				ticketstatusId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "update" :
				ticketstatusId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "delete" :
				if (!inputObj.isNull("ticketstatusId")) {
					ticketstatusId = inputObj.getString("ticketstatusId");
				}
				if (!ticketstatusId.equals("0")) {
					deleteFields(ticketstatusId);
				}
				break;
			case "moveup" :
				if (!inputObj.isNull("ticketstatusId")) {
					ticketstatusId = inputObj.getString("ticketstatusId");
				}
				if (!ticketstatusId.equals("0")) {
					moveUp(ticketstatusId);
				}
				break;

			case "movedown" :
				if (!inputObj.isNull("ticketstatusId")) {
					ticketstatusId = inputObj.getString("ticketstatusId");
				}
				if (!ticketstatusId.equals("0")) {
					moveDown(ticketstatusId);
				}
				break;

		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("ticketstatusId")) {
			ticketstatusId = CNumeric(inputObj.getString("ticketstatusId"));
		}
		if (!inputObj.isNull("ticketstatusRank")) {
			ticketstatusRank = CNumeric(inputObj.getString("ticketstatusRank"));
		}
		if (!inputObj.isNull("ticketstatusName")) {
			ticketstatusName = PadQuotes(inputObj.getString("ticketstatusName"));
		}
		if (!inputObj.isNull("ticketstatusEntryDate")) {
			ticketstatusEntryDate = PadQuotes(inputObj.getString("ticketstatusEntryDate"));
		}
		if (!inputObj.isNull("ticketstatusModifiedId")) {
			ticketstatusModifiedId = CNumeric(inputObj.getString("ticketstatusModifiedId"));
		}
		if (!inputObj.isNull("ticketstatusModifiedDate")) {
			ticketstatusModifiedDate = PadQuotes(inputObj.getString("ticketstatusModifiedDate"));
		}
		if (!inputObj.isNull("ticketstatusEntryId")) {
			ticketstatusEntryId = CNumeric(inputObj.getString("ticketstatusEntryId"));
		}
	}

	public void validateFields() {
		System.out.println("validata=============start");
		if (ticketstatusName.equals("")) {
			msg += "Enter Ticket Status Name!";
		}

		// else {
		// List<AxelaHelpDeskTicketStatus> obj = helpDeskTicketStatusRepository.findByStatus(ticketstatus_name);
		// if (!obj.isEmpty()) {
		// msg += "<br>Similar Queue Name Found!";
		// }
		// }
	}

	public void addFields(HttpServletResponse response) throws ParseException {
		validateFields();
		AxelaHelpDeskTicketStatus axelaHelpDeskTicketStatus = null;
		if (msg.equals("")) {
			if (!ticketstatusId.equals("0")) {
				axelaHelpDeskTicketStatus = helpDeskTicketStatusRepository.findOne(Integer.parseInt(ticketstatusId));
			} else {
				axelaHelpDeskTicketStatus = new AxelaHelpDeskTicketStatus();
			}
			axelaHelpDeskTicketStatus.setTicketstatusId(Integer.parseInt(ticketstatusId));
			axelaHelpDeskTicketStatus.setTicketstatusName(ticketstatusName);
			axelaHelpDeskTicketStatus.setTicketstatusRank(Integer.parseInt(ticketstatusRank));
			if (ticketstatusId.equals("0") && requestType.equals("add")) {
				axelaHelpDeskTicketStatus.setTicketstatusEntryId(empId);
				axelaHelpDeskTicketStatus.setTicketstatusEntryDate(stringToDate(toLongDate(kknow())));
				// axelaHelpDeskTicketStatus.setTicketstatusModifiedDate("");
				axelaHelpDeskTicketStatus.setTicketstatusModifiedId(0);
			} else if (!ticketstatusId.equals("0") && requestType.equals("update")) {
				axelaHelpDeskTicketStatus.setTicketstatusModifiedId(empId);
				axelaHelpDeskTicketStatus.setTicketstatusModifiedDate(stringToDate(toLongDate(kknow())));
			}
			ticketstatusId = helpDeskTicketStatusRepository.save(axelaHelpDeskTicketStatus).getTicketstatusId() + "";
			if (!ticketstatusId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("successmsg", "Ticket Status Added Successfully!");
			} else if (!ticketstatusId.equals("0") && requestType.equals("update")) {
				output.put("successmsg", "Ticket Status Updated Successfully!!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}
	public void deleteFields(String ticketstatusId) {
		helpDeskTicketStatusRepository.delete(Integer.parseInt(ticketstatusId));
		output.put("successmsg", "Ticket Status Deleted Successfully!");
	}

	public Map populateData(String input) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		LinkedHashMap map = new LinkedHashMap();
		if (!inputObj.isNull("ticketstatusId")) {
			ticketstatusId = PadQuotes(CNumeric(inputObj.getString("ticketstatusId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!ticketstatusId.equals("0")) {
			AxelaHelpDeskTicketStatus axelaHelpDeskTicketStatus = helpDeskTicketStatusRepository.findOne(Integer.parseInt(ticketstatusId));
			if (axelaHelpDeskTicketStatus != null) {
				map.put("ticketstatusId", axelaHelpDeskTicketStatus.getTicketstatusId());
				map.put("ticketstatusName", axelaHelpDeskTicketStatus.getTicketstatusName());
				map.put("ticketstatusRank", axelaHelpDeskTicketStatus.getTicketstatusRank());
				if (axelaHelpDeskTicketStatus.getTicketstatusEntryId() != 0) {
					map.put("ticketstatusEntryId", axelaHelpDeskTicketStatus.getTicketstatusEntryId());
					map.put("ticketstatusEntryBy", empRepository.findEmpName(axelaHelpDeskTicketStatus.getTicketstatusEntryId()));
					map.put("ticketstatusEntryDate", strToShortDate(axelaHelpDeskTicketStatus.getTicketstatusEntryDate()));
				}
				if (axelaHelpDeskTicketStatus.getTicketstatusModifiedId() != 0) {
					map.put("ticketstatusModifiedId", axelaHelpDeskTicketStatus.getTicketstatusModifiedId());
					map.put("ticketstatusModifiedBy", empRepository.findEmpName(axelaHelpDeskTicketStatus.getTicketstatusModifiedId()));
					map.put("ticketstatusModifiedDate", strToShortDate(axelaHelpDeskTicketStatus.getTicketstatusModifiedDate()));
				}
				list.add(map);
			}
			output.put("populateData", list);
		}
		return output;
	}

	public Map listData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		page = 0;
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			List<AxelaHelpDeskTicketStatus> statusList = null;
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
				sortField = "ticketstatusId";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			String strOrderBy = " ORDER BY status." + sortField + " " + sortDirection;
			// System.out.println("strOrderBy=============" + strOrderBy);
			statusList = ticketStatusFilterImpl.findAllTicketStatus(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			totalCount = Integer.parseInt(ticketStatusFilterImpl.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Status Details", "ticketstatusName", "center"));
			listHeader.add(produceHeaderData("Order", "ticketstatusRank", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaHelpDeskTicketStatus obj : statusList) {
				ArrayList<String> param = new ArrayList<String>();
				ArrayList type = new ArrayList();
				ArrayList value = new ArrayList();
				ArrayList<String> actionParam = new ArrayList<String>();
				ArrayList<ArrayList> paramArr = new ArrayList<ArrayList>();
				ArrayList<String> paramSubArr = new ArrayList<String>();
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
				value.add(obj.getTicketstatusName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				type.add(true);
				type.add(true);
				value.add(String.valueOf("Up"));
				value.add(String.valueOf("Down"));
				paramSubArr.add(obj.getTicketstatusId() + "");
				paramSubArr.add("up");
				paramArr.add((ArrayList) paramSubArr.clone());
				paramSubArr.clear();
				paramSubArr.add(obj.getTicketstatusId() + "");
				paramSubArr.add("down");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				paramSubArr.clear();
				paramArr.clear();
				type.clear();
				value.clear();

				mapData.put("td", listData);
				actionParam.add("updateTicketStatus");
				actionParam.add(obj.getTicketstatusId() + "");
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
		mapBodyData.put("value", "Update Ticket Status");
		mapBodyData.put("param", actionParam);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "status.*"));
		list.add(buildSmartArr("Status ID", "numeric", "status.ticketstatusId"));
		list.add(buildSmartArr("Name", "text", "status.ticketstatusName"));
		list.add(buildSmartArr("Rank", "numeric", "status.ticketstatusRank"));
		// list.add(buildSmartArr("Entry By", "text", "status.ticketstatusId)"));
		list.add(buildSmartArr("Entry Date", "date", "status.ticketstatusEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "status.ticketstatusModifiedId"));
		list.add(buildSmartArr("Modified Date", "date", "status.ticketstatusModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

	public void moveUp(String ticketstatusId) {
		output = new LinkedHashMap();
		int tempRank;
		int delstatusRank = 0;
		delstatusRank = helpDeskTicketStatusRepository.findRankfromTickettypeId(Integer.parseInt(ticketstatusId));
		tempRank = helpDeskTicketStatusRepository.findMinRank();
		if (tempRank != 0 && delstatusRank != 0) {
			if (delstatusRank != tempRank) {
				tempRank = delstatusRank - 1;
				int updateCount1 = portalFilterImpl.updatePriority(delstatusRank, tempRank, "AxelaHelpDeskTicketStatus status", "status.ticketstatusRank");
				int updateCount2 = portalFilterImpl.updatePriorityById(delstatusRank, tempRank, "status.ticketstatusId", Integer.parseInt(ticketstatusId), "AxelaHelpDeskTicketStatus status",
						"status.ticketstatusRank");
				output.put("msg", "Ticket Status moved up successfully!");
			}
		} else {
			output.put("errormsg", "not possible");
		}
	}

	public void moveDown(String priorityopprId) {
		output = new LinkedHashMap();
		int tempRank;
		int delstatusRank = 0;
		delstatusRank = helpDeskTicketStatusRepository.findRankfromTickettypeId(Integer.parseInt(ticketstatusId));
		tempRank = helpDeskTicketStatusRepository.findMaxRank();
		if (tempRank != 0 && delstatusRank != 0) {
			if (delstatusRank != tempRank) {
				tempRank = delstatusRank + 1;
				int updateCount1 = portalFilterImpl.updatePriority(delstatusRank, tempRank, "AxelaHelpDeskTicketStatus status", "status.ticketstatusRank");
				int updateCount2 = portalFilterImpl.updatePriorityById(delstatusRank, tempRank, "status.ticketstatusId", Integer.parseInt(ticketstatusId), "AxelaHelpDeskTicketStatus status",
						"status.ticketstatusRank");
				output.put("msg", "Ticket Status moved Down successfully!");
			}
		} else {
			output.put("errormsg", "not possible");
		}
	}
}
