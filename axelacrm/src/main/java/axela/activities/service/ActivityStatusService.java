package axela.activities.service;

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
import axela.portal.model.AxelaActivityStatus;
import axela.portal.repository.ActivityStatusRepository;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;
@Service
public class ActivityStatusService extends Connect {

	@Autowired
	private ActivityStatusRepository activityStatusRepository;
	@Autowired
	private EmpRepository empRepository;
	@Autowired
	private PortalFilterImpl portalFilterImpl;

	public String statusId = "0";
	public String statusDesc = "";
	public String statusEntryDate = "";
	public String statusModifiedDate = "";
	public String statusEntryId = "0";
	public String statusModifiedId = "0";
	public String requestType = "";
	public String msg = "";
	public String pageNumber = "";
	public int empId = 0;
	public int compId = 0;
	public String perPage = "0";
	public String branchAccess = "";
	public String exeAccess = "";
	public int page = 0;
	public String perpage = "0";
	public String orderType = "";
	public String orderByField = "";

	HashMap output = null;
	JSONObject inputObj = null;

	public Map<String, String> activityStatusService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
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
					statusId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;

				case "update" :// update
					statusId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;

				case "delete" :// delete
					if (!inputObj.isNull("statusId")) {
						statusId = inputObj.getString("statusId");
					}
					if (!statusId.equals("0")) {
						deleteFields(statusId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("statusId")) {
			statusId = CNumeric(inputObj.getString("statusId"));
		}
		if (!inputObj.isNull("statusDesc")) {
			statusDesc = PadQuotes(inputObj.getString("statusDesc"));
		}
	}

	public void validateFields() {
		if (statusDesc.equals("")) {
			msg += "Enter status description!";
		} else {
			List<AxelaActivityStatus> obj = null;
			if (requestType.equals("add")) {
				obj = activityStatusRepository.findByStatusDesc(statusDesc);
			}
			else if (requestType.equals("update")) {
				obj = activityStatusRepository.findStatusDesc(Integer.parseInt(statusId), statusDesc);
			}
			if (!obj.isEmpty()) {
				msg += "<br>Similar Activity Status found!";
			}
		}
	}

	public void addFields(HttpServletResponse response, HttpSession session) throws ParseException {
		validateFields();
		output = new HashMap();
		if (msg.equals("")) {
			AxelaActivityStatus axelaActivityStatus = null;
			if (!statusId.equals("0")) {
				axelaActivityStatus = activityStatusRepository.findByStatusId(Integer.parseInt(statusId));
			} else {
				axelaActivityStatus = new AxelaActivityStatus();
			}
			axelaActivityStatus.setStatusId(Integer.parseInt(statusId));
			axelaActivityStatus.setStatusDesc(statusDesc);
			if (statusId.equals("0") && requestType.equals("add")) {
				axelaActivityStatus.setStatusEntryId(empId);
				axelaActivityStatus.setStatusEntryDate(getTimeByZone(session));
				// axelaActivityStatus.setStatusModifiedDate("");
				axelaActivityStatus.setStatusModifiedId(0);
			} else if (!statusId.equals("0") && requestType.equals("update")) {
				axelaActivityStatus.setStatusModifiedId(empId);
				axelaActivityStatus.setStatusModifiedDate(getTimeByZone(session));
			}
			String statusId = activityStatusRepository.save(axelaActivityStatus).getStatusId() + "";
			if (!statusId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("statusId", statusId + "");
				output.put("successmsg", "Activity Status Added Successfully!");
			} else if (!statusId.equals("0") && requestType.equals("update")) {
				output.put("successmsg", "Activity Status Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String statusId) {
		activityStatusRepository.delete(Integer.parseInt(statusId));
		output.put("successmsg", "Activity Status Deleted Successfully!");

	}

	public Map populateData(String input) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("statusId")) {
			statusId = PadQuotes(CNumeric(inputObj.getString("statusId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!statusId.equals("0")) {
			AxelaActivityStatus soe = activityStatusRepository.findByStatusId(Integer.parseInt(statusId));
			HashMap map = new HashMap();
			map.put("statusId", statusId);
			map.put("statusDesc", String.valueOf(soe.getStatusDesc()));
			if (soe.getStatusEntryId() != 0) {
				map.put("statusEntryDate", strToShortDate(soe.getStatusEntryDate()));
				map.put("statusEntryId", String.valueOf(soe.getStatusEntryId()));
				map.put("statusEntryBy", empRepository.findEmpName(soe.getStatusEntryId()));
			}
			if (soe.getStatusModifiedId() != 0) {
				map.put("statusModifiedDate", strToShortDate(soe.getStatusModifiedDate()));
				map.put("statusModifiedId", String.valueOf(soe.getStatusModifiedId()));
				map.put("statusModifiedBy", empRepository.findEmpName(soe.getStatusModifiedId()));
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
		requestType = "";
		if (empId != 0) {
			page = 0;
			output = new LinkedHashMap<String, String>();
			branchAccess = getSession("branchAccess", session).replaceAll("branchId", "oppr.opprBranchId");
			exeAccess = getSession("exeAccess", session).replaceAll("empId", "oppr.opprEmpId");
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
				orderByField = "statusId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strOrderBy = " ORDER BY status." + orderByField + " " + orderType + "";
			List<AxelaActivityStatus> resultSet = portalFilterImpl.findActivityStatusDetail(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			String length = portalFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("ID", "statusId", "center"));
			listHeader.add(produceHeaderData("Activity Status Details.", "statusDesc", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaActivityStatus obj : resultSet) {
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

				// Id
				type.add(false);
				value.add(obj.getStatusId());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// details.
				type.add(false);
				value.add(String.valueOf(obj.getStatusDesc()));
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// End Body data

				mapData.put("td", listData);
				ArrayList actionParam = new ArrayList();
				actionParam.add("updateStatus");
				actionParam.add(PadQuotes(String.valueOf(obj.getStatusId())));
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
		mapBodyData.put("value", "Update Activity Status");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "status.*"));
		list.add(buildSmartArr(" status ID", "numeric", "status.statusId"));
		list.add(buildSmartArr(" status Name", "text", "status.statusDesc"));
		// list.add(buildSmartArr("Entry By", "numeric", "oppr.soeEntryBy"));
		list.add(buildSmartArr(" Entry Date", "Date", "status.statusEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "oppr.opprContactId"));
		list.add(buildSmartArr("Modified Date", "Date", "status.statusModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}
}
