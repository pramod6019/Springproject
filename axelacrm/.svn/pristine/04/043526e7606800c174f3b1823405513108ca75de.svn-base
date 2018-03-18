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
import axela.portal.model.AxelaSoe;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;
import axela.portal.repository.SoeRepository;

@Service
public class SoeService extends Connect
{
	@Autowired
	private SoeRepository soeRepository;
	@Autowired
	private EmpRepository EmpRepository;
	@Autowired
	private PortalFilterImpl portalFilterImpl;

	public String soeId = "0";
	public String soeEntryDate = "";
	public String soeEntryId = "0";
	public String soeModifiedDate = "";
	public String soeModifiedId = "0";
	public String soeName = "";
	public String requestType = "";
	public String pageNumber = "";
	public int empId = 0;
	public int compId = 0;
	public String msg = "";
	public int page = 0;
	public String perpage = "0";
	public String sort = "";
	public String field = "";
	public String branchAccess = "";
	public String perPage = "0";
	public String strSearch = "";
	public String orderType = "";
	public String orderByField = "";
	public String strOrderBy = "";

	HashMap output = null;
	JSONObject inputObj = null;

	public Map soeService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
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
					soeId = "0";
					getValues(inputObj);
					addFields(response);
					break;
				case "update" :// update
					soeId = "0";
					getValues(inputObj);
					addFields(response);
					break;
				case "delete" :// delete
					if (!inputObj.isNull("soeId")) {
						soeId = inputObj.getString("soeId");
					}
					if (!soeId.equals("0")) {
						deleteFields(soeId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("soeId")) {
			soeId = CNumeric(inputObj.getString("soeId"));
		}
		if (!inputObj.isNull("soeName")) {
			soeName = PadQuotes(inputObj.getString("soeName"));
		}
	}

	public void validateFields() {
		List<AxelaSoe> obj = null;
		if (soeName.equals("")) {
			msg += "Enter SOE Name!";
		} else {

			if (requestType.equals("add")) {
				obj = soeRepository.findBySoeName(soeName);
			}
			else if (requestType.equals("update")) {
				obj = soeRepository.findSoeName(Integer.parseInt(soeId), soeName);
			}
			if (!obj.isEmpty()) {
				msg += "<br>Similar SOE found!";
			}
		}
	}

	public void addFields(HttpServletResponse response) throws JSONException, ParseException {
		validateFields();
		output = new HashMap();
		if (msg.equals("")) {
			AxelaSoe axelaSoe = null;
			if (!soeId.equals("0")) {
				axelaSoe = soeRepository.findBySoeId(Integer.parseInt(soeId));
			} else {
				axelaSoe = new AxelaSoe();
			}
			axelaSoe.setSoeId(Integer.parseInt(soeId));
			axelaSoe.setSoeName(soeName);
			if (soeId.equals("0") && requestType.equals("add")) {
				axelaSoe.setSoeEntryId(empId);
				axelaSoe.setSoeEntryDate(stringToDate(toLongDate(kknow())));
				// axelaSoe.setSoeModifiedDate("");
				axelaSoe.setSoeModifiedId(0);
			} else if (!soeId.equals("0") && requestType.equals("update")) {
				axelaSoe.setSoeModifiedId(empId);
				axelaSoe.setSoeModifiedDate(stringToDate(toLongDate(kknow())));
			}
			String soeId = soeRepository.save(axelaSoe).getSoeId() + "";
			if (!soeId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("soeId", soeId);
				output.put("successmsg", "SOE Added Successfully!");
			} else if (!soeId.equals("0") && requestType.equals("update")) {
				output.put("soeId", soeId);
				output.put("successmsg", "SOE Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String soeId) {
		soeRepository.delete(Integer.parseInt(soeId));
		output.put("successmsg", "SOE Deleted Successfully!");

	}

	public Map populateData(String input) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("soeId")) {
			soeId = PadQuotes(CNumeric(inputObj.getString("soeId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!soeId.equals("0")) {
			AxelaSoe soe = soeRepository.findBySoeId(Integer.parseInt(soeId));
			HashMap map = new HashMap();
			map.put("soeId", soeId);
			map.put("soeName", String.valueOf(soe.getSoeName()));
			if (soe.getSoeEntryId() != 0) {
				map.put("soeEntryDate", strToShortDate(soe.getSoeEntryDate()));
				map.put("soeEntryId", String.valueOf(soe.getSoeEntryId()));
				map.put("soeEntryBy", EmpRepository.findEmpName(soe.getSoeEntryId()));
			}
			if (soe.getSoeModifiedId() != 0) {
				map.put("soeModifiedDate", strToShortDate(soe.getSoeModifiedDate()));
				map.put("soeModifiedId", String.valueOf(soe.getSoeModifiedId()));
				map.put("soeModifiedBy", EmpRepository.findEmpName(soe.getSoeModifiedId()));
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
				orderByField = "soeId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strOrderBy = " ORDER BY soe." + orderByField + " " + orderType + "";
			List<AxelaSoe> resultSet = portalFilterImpl.findSoe(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			String length = portalFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("SOE Details", "soeName", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaSoe obj : resultSet) {
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
				value.add(String.valueOf(obj.getSoeName()));
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// End Body data
				mapData.put("td", listData);
				ArrayList actionParam = new ArrayList();
				actionParam.add("updateSoe");
				actionParam.add(PadQuotes(String.valueOf(obj.getSoeId())));
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
		mapBodyData.put("value", "Update SOE");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "soe.*"));
		list.add(buildSmartArr(" Soe ID", "numeric", "soe.soeId"));
		list.add(buildSmartArr(" Soe Name", "numeric", "soe.soeName"));
		// list.add(buildSmartArr("Entry By", "numeric", "oppr.soeEntryBy"));
		list.add(buildSmartArr(" Entry Date", "Date", "soe.soeEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "oppr.opprContactId"));
		list.add(buildSmartArr("Modified Date", "Date", "soe.soeModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

}
