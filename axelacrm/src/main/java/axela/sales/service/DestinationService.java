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
import axela.portal.model.AxelaSalesOpprDestination;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;
import axela.portal.repository.SalesOpprDestinationRepository;

@Service
public class DestinationService extends Connect
{
	@Autowired
	private SalesOpprDestinationRepository salesOpprDestinationRepository;
	@Autowired
	private EmpRepository empRepository;
	@Autowired
	PortalFilterImpl portalFilterImpl;

	public String destinationId = "0";
	public String destinationEntryDate = "";
	public String destinationEntryId = "0";
	public String destinationModifiedDate = "";
	public String destinationModifiedId = "0";
	public String destinationName = "";
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

	public Map DestinationService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
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
					destinationId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "update" :// update
					destinationId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "delete" :// delete
					if (!inputObj.isNull("destinationId")) {
						destinationId = inputObj.getString("destinationId");
					}
					if (!destinationId.equals("0")) {
						deleteFields(destinationId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("destinationId")) {
			destinationId = CNumeric(inputObj.getString("destinationId"));
		}
		if (!inputObj.isNull("destinationName")) {
			destinationName = PadQuotes(inputObj.getString("destinationName"));
		}
	}

	public void validateFields() {
		if (destinationName.equals("")) {
			msg += "Enter Destination Name!";
		} else {
			List<AxelaSalesOpprDestination> obj = null;
			if (requestType.equals("add")) {
				obj = salesOpprDestinationRepository.findByDestinationName(destinationName);
			}
			else if (requestType.equals("update")) {
				obj = salesOpprDestinationRepository.findDestinationName(Integer.parseInt(destinationId), destinationName);
			}
			if (!obj.isEmpty()) {
				msg += "<br>Similar Destination Name found!";
			}
		}
	}

	public void addFields(HttpServletResponse response) throws ParseException {
		validateFields();
		output = new HashMap();
		if (msg.equals("")) {
			AxelaSalesOpprDestination axelaSalesOpprDestination = null;
			if (!destinationId.equals("0")) {
				axelaSalesOpprDestination = salesOpprDestinationRepository.findByDestinationId(Integer.parseInt(destinationId));
			} else {
				axelaSalesOpprDestination = new AxelaSalesOpprDestination();
			}
			axelaSalesOpprDestination.setDestinationId(Integer.parseInt(destinationId));
			axelaSalesOpprDestination.setDestinationName(destinationName);
			if (destinationId.equals("0") && requestType.equals("add")) {
				axelaSalesOpprDestination.setDestinationEntryId(empId);
				axelaSalesOpprDestination.setDestinationEntryDate(stringToDate(toLongDate(kknow())));
				axelaSalesOpprDestination.setDestinationModifiedId(0);
			} else if (!destinationId.equals("0") && requestType.equals("update")) {
				axelaSalesOpprDestination.setDestinationModifiedId(empId);
				axelaSalesOpprDestination.setDestinationModifiedDate(stringToDate(toLongDate(kknow())));
			}
			String destinationId = salesOpprDestinationRepository.save(axelaSalesOpprDestination).getDestinationId() + "";
			if (!destinationId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("destinationId", destinationId);
				output.put("successmsg", "Destination  Added Successfully!");
			} else if (!destinationId.equals("0") && requestType.equals("update")) {
				output.put("destinationId", destinationId);
				output.put("successmsg", "Destination  Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String destinationId) {
		salesOpprDestinationRepository.delete(Integer.parseInt(destinationId));
		output.put("successmsg", "Destination Deleted Successfully!");
	}

	public Map populateData(String input) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("destinationId")) {
			destinationId = PadQuotes(CNumeric(inputObj.getString("destinationId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!destinationId.equals("0")) {
			AxelaSalesOpprDestination soe = salesOpprDestinationRepository.findByDestinationId(Integer.parseInt(destinationId));
			HashMap map = new HashMap();
			map.put("destinationId", destinationId);
			map.put("destinationName", String.valueOf(soe.getDestinationName()));
			if (soe.getDestinationEntryId() != 0) {
				map.put("destinationEntryDate", strToShortDate(soe.getDestinationEntryDate()));
				map.put("destinationEntryId", String.valueOf(soe.getDestinationEntryId()));
				map.put("destinationEntryBy", empRepository.findEmpName(soe.getDestinationEntryId()));
			}
			if (soe.getDestinationModifiedId() != 0) {
				map.put("destinationModifiedDate", strToShortDate(soe.getDestinationModifiedDate()));
				map.put("destinationModifiedId", String.valueOf(soe.getDestinationModifiedId()));
				map.put("destinationModifiedBy", empRepository.findEmpName(soe.getDestinationModifiedId()));
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
				orderByField = "destinationId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strOrderBy = " ORDER BY destination." + orderByField + " " + orderType + "";
			List<AxelaSalesOpprDestination> resultSet = portalFilterImpl.findDestination(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			String length = portalFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Destination Details", "destinationName", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaSalesOpprDestination obj : resultSet) {
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
				value.add(String.valueOf(obj.getDestinationName()));
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// End Body data
				mapData.put("td", listData);
				ArrayList actionParam = new ArrayList();
				actionParam.add("updateDestination");
				actionParam.add(PadQuotes(String.valueOf(obj.getDestinationId())));
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
		mapBodyData.put("value", "Update Destination");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "destination.*"));
		list.add(buildSmartArr(" Destination ID", "numeric", "destination.destinationId"));
		list.add(buildSmartArr(" Destination Name", "numeric", "destination.destinationName"));
		// list.add(buildSmartArr("Entry By", "numeric", "oppr.soeEntryBy"));
		list.add(buildSmartArr(" Entry Date", "Date", "destination.destinationEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "oppr.opprContactId"));
		list.add(buildSmartArr("Modified Date", "Date", "destination.destinationModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

}