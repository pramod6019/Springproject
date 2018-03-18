package axela.service.service;

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
import org.springframework.stereotype.Repository;

import axela.config.Connect;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;
import axela.service.model.AxelaServiceContractServiceType;
import axela.service.repository.ServiceContractServiceTypeRepository;

@Repository
public class ContractServiceTypeService extends Connect {
	private final static int PAGESIZE = 25;
	public String servicetypeId = "0";
	public String servicetypeName = "";
	public String servicetypeEntryId = "0";
	public String servicetypeEntryDate = "";
	public String servicetypeModifiedId = "0";
	public String servicetypeModifiedDate = "";
	public String msg = "";
	public String pageNumber = "";
	public int empId = 0;
	public String sortField = "";
	public String sortDirection = "";
	public int page = 0;
	public String perPage = "0";
	String branches = "";
	public String requestType = "";
	public String strSearch = "";
	public String branchAccess = "";
	public String exeAccess = "";
	public int length = 0;
	public int totalCount = 0;
	HashMap output = null;
	String strOrderBy = "";
	int compId = 0;

	JSONObject inputObj = null;

	@Autowired
	PortalFilterImpl portalFilterImpl;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	ServiceContractServiceTypeRepository serviceContractServiceTypeRepository;

	public Map<String, String> contractServiceTypeService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		switch (requestType) {
			case "add" :
				servicetypeId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "update" :
				servicetypeId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "delete" :
				if (!inputObj.isNull("servicetypeId")) {
					servicetypeId = inputObj.getString("servicetypeId");
				}
				if (!servicetypeId.equals("0")) {
					deleteFields(servicetypeId);
				}
				break;
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("servicetypeId")) {
			servicetypeId = CNumeric(inputObj.getString("servicetypeId"));
		}
		if (!inputObj.isNull("servicetypeName")) {
			servicetypeName = PadQuotes(inputObj.getString("servicetypeName"));
		}
	}

	public void validateFields() {
		List<AxelaServiceContractServiceType> obj = null;
		if (servicetypeName.equals("")) {
			msg += "Enter Service Type Name!";
		}

	}

	public void addFields(HttpServletResponse response) throws ParseException {
		validateFields();
		output = new HashMap();
		if (msg.equals("")) {
			AxelaServiceContractServiceType axelaServiceContractServiceType = null;
			if (!servicetypeId.equals("0")) {
				axelaServiceContractServiceType = serviceContractServiceTypeRepository.findOne(Integer.parseInt(servicetypeId));
			} else {
				axelaServiceContractServiceType = new AxelaServiceContractServiceType();
			}
			axelaServiceContractServiceType.setServicetypeId(Integer.parseInt(servicetypeId));
			axelaServiceContractServiceType.setServicetypeName(servicetypeName);
			if (servicetypeId.equals("0") && requestType.equals("add")) {
				axelaServiceContractServiceType.setServicetypeEntryId(empId);
				axelaServiceContractServiceType.setServicetypeEntryDate(stringToDate(toLongDate(kknow())));
				axelaServiceContractServiceType.setServicetypeModifiedDate(stringToDate(""));
				axelaServiceContractServiceType.setServicetypeModifiedId(0);
			} else if (!servicetypeId.equals("0") && requestType.equals("update")) {
				axelaServiceContractServiceType.setServicetypeModifiedId(empId);
				axelaServiceContractServiceType.setServicetypeModifiedDate(stringToDate(toLongDate(kknow())));
			}
			String servicetypeId = serviceContractServiceTypeRepository.save(axelaServiceContractServiceType).getServicetypeId() + "";
			if (!servicetypeId.equals("0") && requestType.equals("add")) {
				output.put("servicetypeId", servicetypeId);
				output.put("successmsg", "Contract Service Type Added Successfully!");
			} else if (!servicetypeId.equals("0") && requestType.equals("update")) {
				output.put("servicetypeId", servicetypeId);
				output.put("successmsg", "Contract Service Type Updated Successfully!");
			}
		} else {
			response.setStatus(400);
			output.put("errormsg", msg);
		}
	}

	public Map<String, List> populateData(String input) throws JSONException, ParseException {

		output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("servicetypeId")) {
			servicetypeId = PadQuotes(CNumeric(inputObj.getString("servicetypeId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!servicetypeId.equals("0")) {
			AxelaServiceContractServiceType axelaServiceContractServiceType = serviceContractServiceTypeRepository.findOne(Integer.parseInt(servicetypeId));
			HashMap map = new HashMap();
			map.put("servicetypeId", servicetypeId);
			map.put("servicetypeName", String.valueOf(axelaServiceContractServiceType.getServicetypeName()));
			if (axelaServiceContractServiceType.getServicetypeEntryId() != 0) {
				map.put("servicetypeEntryDate", strToShortDate(axelaServiceContractServiceType.getServicetypeEntryDate()));
				map.put("servicetypeEntryBy", empRepository.findEmpName(axelaServiceContractServiceType.getServicetypeEntryId()));
				map.put("servicetypeEntryId", axelaServiceContractServiceType.getServicetypeEntryId());
			}
			if (axelaServiceContractServiceType.getServicetypeModifiedId() != 0) {
				map.put("servicetypeModifiedDate", strToShortDate(axelaServiceContractServiceType.getServicetypeModifiedDate()));
				map.put("servicetypeModifiedBy", empRepository.findEmpName(axelaServiceContractServiceType.getServicetypeModifiedId()));
				map.put("servicetypeModifiedId", axelaServiceContractServiceType.getServicetypeModifiedId());
			}
			list.add(map);
		}
		output.put("populateData", list);
		return output;
	}

	public void deleteFields(String servicetypeId) {
		serviceContractServiceTypeRepository.delete(Integer.parseInt(servicetypeId));
		output.put("successmsg", "Contract Service Type Deleted Successfully!");
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		inputObj = new JSONObject(input);
		page = 0;
		output = new LinkedHashMap<String, String>();
		ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
		List<HashMap> listBody = new ArrayList<HashMap>();
		List<HashMap> listAction = new ArrayList<HashMap>();
		ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		PageRequest request = null;
		if (!inputObj.isNull("pageIndex")) {
			page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
		}
		if (!inputObj.isNull("sortDirection")) {
			sortDirection = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
		}
		perPage = CNumeric(getSession("empRecperpage", session));
		if (sortDirection.equals("")) {
			sortDirection = "DESC";
		}
		if (sortField.equals("")) {
			sortField = "servicetypeId";
		}
		if (perPage.equals("0")) {
			perPage = "25";
		}
		page++;
		if (requestType.equals("filter")) {
			strSearch = buildSmartSearch(input);
		}
		strSearch += branchAccess + exeAccess;
		String strOrderBy = " ORDER BY type." + sortField + " " + sortDirection;
		strOrderBy = " ORDER BY type." + sortField + " " + sortDirection + "";
		List<AxelaServiceContractServiceType> resultSet = portalFilterImpl.findAllContractServiceType(strSearch, strOrderBy, page, Integer.parseInt(perPage));
		String length = portalFilterImpl.totalCount;
		Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
		int count = 0;
		// Start Header Data
		listHeader.add(produceHeaderData("Service Type Details", "servicetypeName", "center"));
		// End Header Data

		// Start Body Align
		listBodyAlign.add(produceBodyAlign("center"));
		listBodyAlign.add(produceBodyAlign("left"));
		listBodyAlign.add(produceBodyAlign("left"));
		// End Body Align
		for (AxelaServiceContractServiceType obj : resultSet) {
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
			value.add(obj.getServicetypeName());
			listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
			type.clear();
			value.clear();

			mapData.put("td", listData);
			actionParam.add("updateServiceType");
			actionParam.add(obj.getServicetypeId() + "");
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
		return output;
	}

	private ArrayList<HashMap> produceActionData(ArrayList<String> actionParam) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Service Type");
		mapBodyData.put("param", actionParam);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "type.*"));
		list.add(buildSmartArr("Service Type ID", "numeric", "type.servicetypeId"));
		list.add(buildSmartArr("Service Type Name", "text", "type.servicetypeName"));
		// list.add(buildSmartArr("Entry By", "text", "type.servicetypeEntryId)"));
		list.add(buildSmartArr("Entry Date", "date", "type.servicetypeEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "type.servicetypeModifiedId"));
		list.add(buildSmartArr("Modified Date", "date", "type.servicetypeModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}
}
