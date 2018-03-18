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
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.portal.repository.EmpRepository;
import axela.service.model.AxelaServiceContractLocation;
import axela.service.repository.ServiceContractAssetRepository;
import axela.service.repository.ServiceContractLocationFilterImpl;
import axela.service.repository.ServiceContractLocationRepository;

@Service
public class ContractLocationService extends Connect {

	@Autowired
	ServiceContractLocationRepository serviceContractLocationRepositorty;

	@Autowired
	ServiceContractLocationFilterImpl serviceContractLocationFilterImpl;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	ServiceContractAssetRepository serviceContractAssetRepository;

	public int empId = 0;
	public static String msg = "";
	public int StrSql = 0;
	public String contractlocId = "0";
	int compId = 0, contractlocCustomerId = 0;
	public String contractlocName = "";
	public String contractlocAddress = "";
	public String contractlocCityId = "0";
	public String contractlocPin = "", contractlocLat = "", contractlocLong = "", contractlocNotes = "";
	public String contractlocEntryId = "0";
	public String contractlocEntryDate = "";
	public String contractlocModifiedId = "0";
	public String contractlocModifiedDate = "";
	public String configCustomerName = "";
	public int page = 0;
	public String perpage = "0";
	public String sort = "Desc";
	public String pageNumber = "";
	public String perPage = "";
	public String branchAccess = "";
	public String exeAccess = "";
	public String orderByField = "";
	public String orderType = "";
	public String property = "";
	public String field = "", value = "";
	int PAGESIZE = 25;
	String strSearch = "";

	public String requestType = "";
	public String tag = "contractloc";
	public String entryBy = "", entryDate = "", modifiedBy = "", modifiedDate = "";
	HashMap output = null;
	JSONObject inputObj = null;

	public Map locationService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		configCustomerName = PadQuotes(getSession("configCustomerName", session));
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (empId != 0) {
			switch (requestType) {
				case "add" : // add an contractloc.
					contractlocId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "update" :// update an contractloc.
					contractlocId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "delete" :// delete an contractloc.
					if (!inputObj.isNull("contractlocId")) {
						contractlocId = CNumeric(PadQuotes(inputObj.getString("contractlocId")));
					}
					if (!contractlocId.equals("0")) {
						deleteFields(contractlocId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("contractlocId")) {
			contractlocId = CNumeric(PadQuotes(inputObj.getString("contractlocId")));
		}
		if (!inputObj.isNull("contractlocCustomerId")) {
			contractlocCustomerId = Integer.parseInt(CNumeric(PadQuotes(inputObj.getString("contractlocCustomerId"))));
		}
		if (!inputObj.isNull("contractlocName")) {
			contractlocName = PadQuotes(inputObj.getString("contractlocName"));
		}
		if (!inputObj.isNull("contractlocAddress")) {
			contractlocAddress = PadQuotes(inputObj.getString("contractlocAddress"));
		}
		if (!inputObj.isNull("contractlocCityId")) {
			contractlocCityId = PadQuotes(inputObj.getString("contractlocCityId"));
		}
		if (!inputObj.isNull("contractlocPin")) {
			contractlocPin = PadQuotes(inputObj.getString("contractlocPin"));
		}
		if (!inputObj.isNull("contractlocLat")) {
			contractlocLat = PadQuotes(inputObj.getString("contractlocLat"));
		}
		if (!inputObj.isNull("contractlocLong")) {
			contractlocLong = PadQuotes(inputObj.getString("contractlocLong"));
		}
		if (!inputObj.isNull("contractlocNotes")) {
			contractlocNotes = PadQuotes(inputObj.getString("contractlocNotes"));
			if (contractlocNotes.length() > 5000) {
				contractlocNotes = contractlocNotes.substring(0, 4999);
			}
		}
	}

	public void validateFields() {
		msg = "";

		if (contractlocCustomerId == 0) {
			msg += "<br>Select Customer!";
		}

		if (contractlocName.equals("")) {
			msg += "<br>Select Name!";
		}

		if (contractlocAddress.equals("")) {
			msg += "<br>Enter  Address!";
		}

		if (contractlocCityId.equals("0")) {
			msg += "<br>Select City!";
		}

		if (contractlocAddress.equals("") && contractlocPin.equals("")) {
			msg += "<br>Enter Contact Pin!";
		} else if (!contractlocPin.equals("") && !isNumeric(contractlocPin)) {
			msg += "<br>Contract Pin: Enter Numeric!";
		}

	}

	public void addFields(HttpServletResponse response) throws ParseException {
		validateFields();
		AxelaServiceContractLocation axelaServiceContractLocation = null;
		if (msg.equals("")) {
			if (!contractlocId.equals("0")) {
				axelaServiceContractLocation = serviceContractLocationRepositorty.findOne(Integer.parseInt(contractlocId));
			} else {
				axelaServiceContractLocation = new AxelaServiceContractLocation();
			}
			axelaServiceContractLocation.setContractlocId(Integer.parseInt(String.valueOf(contractlocId)));
			axelaServiceContractLocation.setContractlocCustomerId(Integer.parseInt(String.valueOf(contractlocCustomerId)));
			axelaServiceContractLocation.setContractlocName(contractlocName);
			axelaServiceContractLocation.setContractlocAddress(contractlocAddress);
			axelaServiceContractLocation.setContractlocCityId(contractlocCityId);
			axelaServiceContractLocation.setContractlocPin(contractlocPin);
			axelaServiceContractLocation.setContractlocLat(contractlocLat);
			axelaServiceContractLocation.setContractlocLong(contractlocLong);
			axelaServiceContractLocation.setContractlocNotes(contractlocNotes);
			if (requestType.equals("add")) {
				axelaServiceContractLocation.setContractlocEntryDate(kknow());
				axelaServiceContractLocation.setContractlocEntryId(empId);
				axelaServiceContractLocation.setContractlocModifiedId(0);
			} else {
				axelaServiceContractLocation.setContractlocEntryDate(axelaServiceContractLocation.getContractlocEntryDate());
				axelaServiceContractLocation.setContractlocEntryId(axelaServiceContractLocation.getContractlocEntryId());
				axelaServiceContractLocation.setContractlocModifiedId(empId);
				axelaServiceContractLocation.setContractlocModifiedDate(kknow());
			}
			AxelaServiceContractLocation result = null;
			result = serviceContractLocationRepositorty.save(axelaServiceContractLocation);
			if (result != null && requestType.equals("add")) {
				output.put("successmsg", "Contract Location Added Successfully!");
				output.put("contractlocId", result.getContractlocId() + "");
			} else if (result != null && requestType.equals("update")) {
				output.put("successmsg", "Contract Location Updated Successfully!");
				output.put("contractlocId", result.getContractlocId() + "");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public Map<String, String> populateData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		LinkedHashMap map = new LinkedHashMap();
		if (!inputObj.isNull("contractlocId")) {
			contractlocId = CNumeric(PadQuotes(inputObj.getString("contractlocId")));
		}
		if (!contractlocId.equals("0")) {
			List<AxelaServiceContractLocation> location = serviceContractLocationFilterImpl.findBypopulate(String.valueOf(contractlocId));
			for (AxelaServiceContractLocation results : location) {
				map.put("contractlocId", String.valueOf(results.getContractlocId()));
				map.put("contractlocCustomerId", String.valueOf(results.getContractlocCustomerId()));
				map.put("contractlocName", "" + results.getContractlocName());
				map.put("contractlocAddress", String.valueOf(results.getContractlocAddress()));
				map.put("contractlocPin", String.valueOf(results.getContractlocPin()));
				map.put("contractlocCityId", "" + results.getContractlocCityId());
				map.put("contractlocLat", "" + results.getContractlocLat());
				map.put("contractlocLong", "" + results.getContractlocLong());
				map.put("contractlocNotes", "" + results.getContractlocNotes());
				if (results.getContractlocEntryId() != 0) {
					map.put("contractlocEntryDate", strToShortDate(results.getContractlocEntryDate()));
					map.put("contractlocEntryId", String.valueOf(results.getContractlocEntryId()));
					map.put("contractlocEntryBy", empRepository.findEmpName(Integer.parseInt(String.valueOf(results.getContractlocEntryId()))));
				}
				if (results.getContractlocModifiedId() != 0) {
					map.put("contractlocModifiedDate", strToShortDate(results.getContractlocModifiedDate()));
					map.put("contractlocModifiedId", String.valueOf(results.getContractlocModifiedId()));
					map.put("contractlocModifiedBy", empRepository.findEmpName(Integer.parseInt(String.valueOf(results.getContractlocModifiedId()))));
				}
				list.add(map);
			}
			output.put("populateData", list);
		}
		return output;
	}

	public void deleteFields(String contractlocId) {
		msg = "";
		SOP("contractlocId=======" + contractlocId);
		StrSql = serviceContractAssetRepository.findByAssetContractlocId(Integer.parseInt(contractlocId));
		SOP("StrSql=======" + StrSql);
		if (StrSql != 0) {
			msg += "<br>" + tag + " is associated with  Asset!";
		}

		if (msg.equals("")) {
			serviceContractLocationRepositorty.delete(Integer.parseInt(contractlocId));
			output.put("successmsg", "Contract Location Deleted Successfully!");
		} else {
			output.put("errormsg", msg);
		}
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		page = 0;
		field = "";
		sort = "";
		configCustomerName = "";
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		perPage = CNumeric(getSession("empRecperpage", session));
		configCustomerName = getSession("configCustomerName", session);
		String strSearch = "";
		String strOrderBy = "";
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			// branchAccess = getSession("branchAccess", session).replaceAll("branchId", "salescat.customerBranchId");
			// exeAccess = getSession("exeAccess", session).replaceAll("empId", "salescat.customerEmpId");
			String customerType = "";
			List<AxelaServiceContractLocation> ContractLocationList = null;
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			PageRequest request = null;
			if (!inputObj.isNull("sortField")) {
				orderByField = PadQuotes((inputObj.getString("sortField")));
			}
			if (!inputObj.isNull("pageIndex")) {
				page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
			}
			if (!inputObj.isNull("requestType")) {
				requestType = PadQuotes((inputObj.getString("requestType")));
			}
			if (!inputObj.isNull("sortDirection")) {
				orderType = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			if (orderType.equals("")) {
				orderType = "DESC";
			}
			if (orderByField.equals("")) {
				orderByField = "contractlocId";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			strOrderBy = "ORDER BY contractLocation." + orderByField + " " + orderType + "";
			ContractLocationList = serviceContractLocationFilterImpl.findAll(strSearch, strOrderBy, page, Integer.parseInt(CNumeric(perPage)));
			String length = serviceContractLocationFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("ID", "contractlocId", "center"));
			listHeader.add(produceHeaderData(configCustomerName, "axelaCustomer.customerName", "center"));
			listHeader.add(produceHeaderData("Contract Location", "contractlocName", "center"));
			listHeader.add(produceHeaderData("Address", "contractlocAddress", "center"));
			listHeader.add(produceHeaderData("City", "contractlocCity", "center"));
			listHeader.add(produceHeaderData("Pin", "contractlocPin", "center"));
			listHeader.add(produceHeaderData("Latitude.", "contractlocLat", "center"));
			listHeader.add(produceHeaderData("Longitude.", "contractlocLong", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align
			if (ContractLocationList != null) {
				for (AxelaServiceContractLocation obj : ContractLocationList) {
					String conLoc = "";
					boolean conLocStatus = true;
					String con_action = "";
					ArrayList<String> paramSubArr = new ArrayList<String>();
					ArrayList<ArrayList> paramArr = new ArrayList<ArrayList>();
					ArrayList type = new ArrayList();
					ArrayList value = new ArrayList();
					long saleItemCount = 0;
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
					value.add(obj.getContractlocId());
					listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					// Client
					type.add(true);
					value.add(obj.getCustomerName());
					paramSubArr.add("customerList");
					paramSubArr.add(obj.getContractlocCustomerId() + "");
					paramArr.add((ArrayList) paramSubArr.clone());
					listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					paramArr.clear();
					paramSubArr.clear();
					// Contract Location
					type.add(false);
					value.add(obj.getContractlocName());
					type.add(true);
					value.add("Location Map");
					paramSubArr.add("locationMap");
					paramSubArr.add(obj.getContractlocName());
					paramSubArr.add(obj.getContractlocLat());
					paramSubArr.add(obj.getContractlocLong());
					paramArr.add((ArrayList) paramSubArr.clone());
					listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					paramArr.clear();
					paramSubArr.clear();
					// Address
					type.add(false);
					value.add(obj.getContractlocAddress());
					listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					// City
					type.add(false);
					value.add(obj.getContractlocCityId());
					listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					// Pin
					type.add(false);
					value.add(obj.getContractlocPin());
					listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					// Latitude
					type.add(false);
					value.add(obj.getContractlocLat());
					listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					// Longitute
					type.add(false);
					value.add(obj.getContractlocLong());
					listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					// End Body data
					mapData.put("td", listData);
					ArrayList<String> updateLocationAction = new ArrayList<String>();
					ArrayList<String> listAssetsAction = new ArrayList<String>();
					// for updateLocation
					updateLocationAction.add("updateLocation");
					updateLocationAction.add(PadQuotes(String.valueOf(obj.getContractlocId())));
					// ListAssets
					listAssetsAction.add("ListAssets");
					listAssetsAction.add(PadQuotes(String.valueOf(obj.getContractlocId())));
					mapAction.put("td", produceActionData(updateLocationAction, listAssetsAction));
					listAction.add(mapAction);
					listBody.add(mapData);
				}
				output.put("meta", mapNavi);
				output.put("thead", listHeader);
				output.put("tdalign", listBodyAlign);
				output.put("tbody", listBody);
				output.put("action", listAction);
				if (AppRun().equals("0")) {
					SOP("output==========contractlocService==========" + output.toString());
				}
			}
		}
		return output;
	}

	private ArrayList<HashMap> produceActionData(ArrayList<String> updateLocationAction, ArrayList<String> listAssetsAction) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();

		mapBodyData.put("value", "Update Location");
		mapBodyData.put("param", updateLocationAction);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "List Assets");
		mapBodyData.put("param", listAssetsAction);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}
	public Map populateDrSmart(HttpSession session) {
		configCustomerName = getSession("configCustomerName", session);
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "contractLocation.*"));
		list.add(buildSmartArr("Location ID", "numeric", "contractLocation.contractlocId"));
		list.add(buildSmartArr(configCustomerName + "ID", "text", "contractLocation.contractlocCustomerId"));
		list.add(buildSmartArr("Contract Location", "text", "contractLocation.contractlocName"));
		list.add(buildSmartArr("Address", "text", "contractLocation.contractlocAddress"));
		list.add(buildSmartArr("City", "text", "contractLocation.contractlocCity"));
		list.add(buildSmartArr("Pin", "date", "contractLocation.contractlocPin"));
		list.add(buildSmartArr("Latitude", "date", "contractLocation.contractlocLat"));
		list.add(buildSmartArr("Longitude", "date", "contractLocation.contractlocLong"));
		// list.add(buildSmartArr("Entry By", "text", "contractloc_entry_id IN (SELECT emp_id FROM compdb.axela_emp WHERE emp_name"));
		list.add(buildSmartArr("Entry Date", "date", "contractLocation.contractlocEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "contractloc_modified_id IN (SELECT emp_id FROM compdb.axela_emp WHERE emp_name"));
		list.add(buildSmartArr("Modified Date", "date", "contractLocation.contractlocModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}
}
