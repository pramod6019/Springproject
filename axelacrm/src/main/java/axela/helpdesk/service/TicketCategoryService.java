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
import axela.helpdesk.model.AxelaHelpDeskTicketCat;
import axela.helpdesk.repository.AxelaTicketCategoryRepository;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;

@Service
public class TicketCategoryService extends Connect
{

	private final static int PAGESIZE = 25;
	public String ticketcatId = "0";
	public String ticketcatEntryDate = "";
	public String ticketcatEntryId = "0";
	public String ticketcatModifiedDate = "";
	public String ticketcatModifiedId = "0";
	public String ticketcatName = "";
	public String requestType = "";
	public String msg = "";
	public int empId = 0;
	public int compId = 0;
	public String strSearch = "";
	public String branchAccess = "";
	public String exeAccess = "";
	public String sortField = "";
	public String sortDirection = "";
	public int page = 0;
	public String perPage = "0";
	public int totalCount = 0;

	public String pageNumber = "";
	HashMap output = null;
	JSONObject inputObj = null;

	@Autowired
	private AxelaTicketCategoryRepository axelaTicketCategoryRepository;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	PortalFilterImpl portalFilterImpl;

	public Map<String, String> ticketCategoryService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}

		switch (requestType) {

			case "add" :
				ticketcatId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "update" :
				ticketcatId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "delete" :
				if (!inputObj.isNull("ticketcatId")) {
					ticketcatId = inputObj.getString("ticketcatId");
				}
				if (!ticketcatId.equals("0")) {
					deleteFields(ticketcatId);
				}
				break;
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("ticketcatId")) {
			ticketcatId = CNumeric(inputObj.getString("ticketcatId"));
		}
		if (!inputObj.isNull("ticketcatName")) {
			ticketcatName = PadQuotes(inputObj.getString("ticketcatName"));
		}
		if (!inputObj.isNull("ticketcatEntryDate")) {
			ticketcatEntryDate = PadQuotes(inputObj.getString("ticketcatEntryDate"));
		}
		if (!inputObj.isNull("ticketcatEntryId")) {
			ticketcatEntryId = PadQuotes(inputObj.getString("ticketcatEntryId"));
		}
		if (!inputObj.isNull("ticketcatModifiedDate")) {
			ticketcatModifiedDate = PadQuotes(inputObj.getString("ticketcatModifiedDate"));
		}
		if (!inputObj.isNull("ticketcatModifiedId")) {
			ticketcatModifiedId = PadQuotes(inputObj.getString("ticketcatModifiedId"));
		}
	}

	public void validateFields() {
		if (ticketcatName.equals("")) {
			msg += "Enter Ticket Category Name!";
		}
	}

	public void addFields(HttpServletResponse response) throws ParseException {
		validateFields();
		output = new HashMap();
		if (msg.equals("")) {
			AxelaHelpDeskTicketCat axelaHelpDeskTicketCat = null;
			if (!ticketcatId.equals("0")) {
				axelaHelpDeskTicketCat = axelaTicketCategoryRepository.findOne(Integer.parseInt(ticketcatId));
			} else {
				axelaHelpDeskTicketCat = new AxelaHelpDeskTicketCat();
			}
			axelaHelpDeskTicketCat.setTicketcatId(Integer.parseInt(ticketcatId));
			axelaHelpDeskTicketCat.setTicketcatName(ticketcatName);
			if (ticketcatId.equals("0") && requestType.equals("add")) {
				axelaHelpDeskTicketCat.setTicketcatEntryId(empId);
				axelaHelpDeskTicketCat.setTicketcatEntryDate(stringToDate(toLongDate(kknow())));
				// axelaHelpDeskTicketCat.setTicketcatModifiedDate("");
				axelaHelpDeskTicketCat.setTicketcatModifiedId(0);
			} else if (!ticketcatId.equals("0") && requestType.equals("update")) {
				axelaHelpDeskTicketCat.setTicketcatModifiedId(empId);
				axelaHelpDeskTicketCat.setTicketcatModifiedDate(stringToDate(toLongDate(kknow())));
			}
			ticketcatId = axelaTicketCategoryRepository.save(axelaHelpDeskTicketCat).getTicketcatId() + "";
			if (!ticketcatId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("successmsg", "Ticket Category Added Successfully!");
			} else if (!ticketcatId.equals("0") && requestType.equals("update")) {
				output.put("successmsg", "Ticket Category Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}
	public void deleteFields(String ticketcatId) {
		axelaTicketCategoryRepository.delete(Integer.parseInt(ticketcatId));
		output.put("successmsg", "Ticket Category Deleted Successfully!");
	}

	public Map populateData(String input) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("ticketcatId")) {
			ticketcatId = PadQuotes(CNumeric(inputObj.getString("ticketcatId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!ticketcatId.equals("0")) {
			AxelaHelpDeskTicketCat axelaHelpDeskTicketCat = axelaTicketCategoryRepository.findOne(Integer.parseInt(ticketcatId));
			HashMap map = new HashMap();
			map.put("ticketcatName", axelaHelpDeskTicketCat.getTicketcatName());
			if (axelaHelpDeskTicketCat.getTicketcatEntryId() != 0) {
				map.put("ticketcatEntryDate", strToShortDate(axelaHelpDeskTicketCat.getTicketcatEntryDate()));
				map.put("ticketcatEntryBy", empRepository.findEmpName(axelaHelpDeskTicketCat.getTicketcatEntryId()));
				map.put("ticketcatEntryId", axelaHelpDeskTicketCat.getTicketcatEntryId());
			}
			if (axelaHelpDeskTicketCat.getTicketcatModifiedId() != 0) {
				map.put("ticketcatModifiedDate", strToShortDate(axelaHelpDeskTicketCat.getTicketcatEntryDate()));
				map.put("ticketcatModifiedBy", empRepository.findEmpName(axelaHelpDeskTicketCat.getTicketcatModifiedId()));
				map.put("ticketcatModifiedId", axelaHelpDeskTicketCat.getTicketcatModifiedId());
			}
			list.add(map);
		}
		output.put("populateData", list);
		return output;
	}

	public Map listData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		page = 0;
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			perPage = CNumeric(getSession("empRecperpage", session));
			List<AxelaHelpDeskTicketCat> categoryList = null;
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
				sortField = "ticketcatId";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			String strOrderBy = " ORDER BY cat." + sortField + " " + sortDirection;
			System.out.println("strOrderBy=============" + strOrderBy);
			categoryList = portalFilterImpl.findAllTicketCategory(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			totalCount = Integer.parseInt(PortalFilterImpl.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Queue Details", "ticketcatName", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaHelpDeskTicketCat obj : categoryList) {
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
				value.add(obj.getTicketcatName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				mapData.put("td", listData);
				actionParam.add("updateTicketCategory");
				actionParam.add(obj.getTicketcatId() + "");
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
		mapBodyData.put("value", "Update Ticket Category");
		mapBodyData.put("param", actionParam);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "cat.*"));
		list.add(buildSmartArr("Category ID", "numeric", "cat.ticketcatId"));
		list.add(buildSmartArr("Category Name", "text", "cat.ticketcatName"));
		// list.add(buildSmartArr("Entry By", "text", "cat.ticketcatEntryId)"));
		list.add(buildSmartArr("Entry Date", "date", "cat.ticketcatEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "cat.ticketcatModifiedId"));
		list.add(buildSmartArr("Modified Date", "date", "cat.ticketcatModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

}
