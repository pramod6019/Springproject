package axela.sales.service;

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
import axela.customer.model.AxelaCustomer;
import axela.portal.model.AxelaSob;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;
import axela.portal.repository.SobRepository;
@Service
public class SobService extends Connect
{
	@Autowired
	SobRepository sobRepository;
	@Autowired
	EmpRepository empRepository;
	@Autowired
	PortalFilterImpl portalFilterImpl;

	public String sobId = "0";
	public String sobEntryDate = "";
	public String sobEntryId = "0";
	public String sobModifiedDate = "";
	public String sobModifiedId = "0";
	public String sobName = "";
	public String requestType = "";
	public String msg = "";
	public String pageNumber = "";
	public int empId = 0;
	public int compId = 0;
	public int page = 0;
	public String perpage = "0";
	public String sort = "";
	public String field = "";
	public static int length = 0;
	public String branchAccess = "";
	public String perPage = "0";
	public String strSearch = "";
	public String orderType = "";
	public String orderByField = "";
	public String strOrderBy = "";

	HashMap output = null;
	JSONObject inputObj = null;

	public Map<String, String> sobService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		perPage = getSession("perPage", session);
		perPage = CNumeric(getSession("empRecperpage", session));
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new HashMap();
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			switch (requestType) {

				case "add" : // add
					SOP("coming ");
					sobId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "update" :// update
					sobId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "delete" :// delete
					if (!inputObj.isNull("sobId")) {
						sobId = inputObj.getString("sobId");
					}
					if (!sobId.equals("0")) {
						deleteFields(sobId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("sobId")) {
			sobId = CNumeric(inputObj.getString("sobId"));
		}
		if (!inputObj.isNull("sobName")) {
			sobName = PadQuotes(inputObj.getString("sobName"));
		}
	}

	public void validateFields() {
		if (sobName.equals("")) {
			msg += "Enter Sob Name!";
		} else {
			List<AxelaSob> obj = null;
			if (requestType.equals("add")) {
				obj = sobRepository.findBySobName(sobName);
			}
			else if (requestType.equals("update")) {
				obj = sobRepository.findSobName(Integer.parseInt(sobId), sobName);
			}
			if (!obj.isEmpty()) {
				msg += "<br>Similar SOB found!";
			}
		}
	}

	public void addFields(HttpServletResponse response) throws ParseException {
		validateFields();
		if (msg.equals("")) {
			AxelaSob axelaSob = null;
			if (!sobId.equals("0")) {
				axelaSob = sobRepository.findBySobId(Integer.parseInt(sobId));
			} else {
				axelaSob = new AxelaSob();
			}
			axelaSob.setSobId(Integer.parseInt(sobId));
			axelaSob.setSobName(sobName);
			if (sobId.equals("0") && requestType.equals("add")) {
				axelaSob.setSobEntryId(empId);
				axelaSob.setSobEntryDate(stringToDate(toLongDate(kknow())));
				// axelaSob.setSobModifiedDate("");
				axelaSob.setSobModifiedId(0);
			} else if (!sobId.equals("0") && requestType.equals("update")) {
				axelaSob.setSobModifiedId(empId);
				axelaSob.setSobModifiedDate(stringToDate(toLongDate(kknow())));
			}
			String sobId = sobRepository.save(axelaSob).getSobId() + "";
			if (!sobId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("sobId", sobId);
				output.put("successmsg", "SOB Added Successfully!");
			} else if (!sobId.equals("0") && requestType.equals("update")) {
				output.put("successmsg", "SOB Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String sobId) {
		sobRepository.delete(Integer.parseInt(sobId));
		output.put("successmsg", "SOB Deleted Successfully!");
	}

	public Map populateData(String input) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("sobId")) {
			sobId = PadQuotes(CNumeric(inputObj.getString("sobId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!sobId.equals("0")) {
			AxelaSob sob = sobRepository.findBySobId(Integer.parseInt(sobId));
			HashMap map = new HashMap();
			map.put("sobId", sobId);
			map.put("sobName", String.valueOf(sob.getSobName()));
			if (sob.getSobEntryId() != 0) {
				map.put("sobEntryDate", strToShortDate(sob.getSobEntryDate()));
				map.put("sobEntryId", String.valueOf(sob.getSobEntryId()));
				map.put("sobEntryBy", empRepository.findEmpName(sob.getSobEntryId()));
			}
			if (sob.getSobModifiedId() != 0) {
				map.put("sobModifiedDate", strToShortDate(sob.getSobModifiedDate()));
				map.put("sobModifiedId", String.valueOf(sob.getSobModifiedId()));
				map.put("sobModifiedBy", empRepository.findEmpName(sob.getSobModifiedId()));
			}
			list.add(map);
		}
		output.put("populateData", list);
		return output;
	}
	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		String strSearch = "";
		String strOrderBy = "";
		if (empId != 0) {
			page = 0;
			output = new LinkedHashMap<String, String>();
			String customerType = "";
			List<AxelaCustomer> customerList = null;
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			PageRequest request = null;
			if (!inputObj.isNull("requestType")) {
				requestType = PadQuotes((inputObj.getString("requestType")));
			}
			if (!inputObj.isNull("sortField")) {
				orderByField = PadQuotes((inputObj.getString("sortField")));
			}
			if (!inputObj.isNull("pageIndex")) {
				page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
			}
			if (!inputObj.isNull("sortDirection")) {
				orderType = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
			}
			perPage = CNumeric(getSession("empRecperpage", session));
			if (orderType.equals("")) {
				orderType = "DESC";
			}
			if (orderByField.equals("")) {
				orderByField = "sobId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strOrderBy = " ORDER BY sob." + orderByField + " " + orderType + "";
			List<AxelaSob> resultSet = portalFilterImpl.findSob(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			String length = portalFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("SOB Details", "sobName", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaSob obj : resultSet) {
				ArrayList paramArr = new ArrayList();
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
				// details.
				type.add(false);
				value.add(String.valueOf(obj.getSobName()));
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// End Body data
				mapData.put("td", listData);
				ArrayList actionParam = new ArrayList();
				actionParam.add("updateSob");
				actionParam.add(PadQuotes(String.valueOf(obj.getSobId())));
				mapAction.put("td", produceActionData(actionParam));
				listAction.add(mapAction);
				listBody.add(mapData);
			}
			output.put("meta", mapNavi);
			output.put("action", listAction);
			output.put("tdalign", listBodyAlign);
			output.put("thead", listHeader);
			output.put("tbody", listBody);
		}
		return output;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<HashMap> produceActionData(ArrayList<String> Param) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update SOB");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "sob.*"));
		list.add(buildSmartArr(" SOB ID", "numeric", "sob.sobId"));
		list.add(buildSmartArr(" SOB Name", "numeric", "sob.sobName"));
		// list.add(buildSmartArr("Entry By", "numeric", "oppr.soeEntryBy"));
		list.add(buildSmartArr(" Entry Date", "Date", "sob.sobEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "oppr.opprContactId"));
		list.add(buildSmartArr("Modified Date", "Date", "sob.sobModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}
}
