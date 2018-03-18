package axela.inventory.service;

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
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.inventory.model.AxelaInventoryLocation;
import axela.inventory.repository.InventoryLocationFilter;
import axela.inventory.repository.InventoryLocationRepository;
import axela.inventory.repository.InventoryStocklFilterImp;
import axela.portal.model.AxelaEmp;
import axela.portal.repository.EmpRepository;

@Service
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class InventoryLocationService extends Connect {

	@Autowired
	InventoryLocationFilter inventoryLocationFilter;
	@Autowired
	InventoryLocationRepository inventoryLocationRepository;
	@Autowired
	EmpRepository axelaEmpRepository;
	@Autowired
	InventoryStocklFilterImp inventoryStocklFilterImp;

	public String StrSql = "";
	public String msg = "";
	public int page = 0;
	public String perPage = "0";
	public String sort = "Desc";
	public int empId = 0;
	public String field = "", value = "";
	public int branchId = 0;
	// location Fields
	String locationId = "0";
	String locationAddress = "";
	String locationBranchId = "0";
	String locationName = "";
	String locationCode = "";
	String locationPhone1 = "";
	public int totalCount = 0;
	String locationPhone2 = "";
	String locationMobile1 = "";
	String locationMobile2 = "";
	String locationAdd = "";
	String stateId = "";
	String locationCityId = "0";
	String locationEntryId = "0";
	String locationEntryDate = "";
	String locationPin = "";
	String entryDate = "";
	String modifiedDate = "";
	String locationEntryBy = "";
	String locationModifiedBy = "";
	// config Fields
	String configInventoryLocationName = "";
	// configuration
	public String branchAccess = "", exeAccess = "";
	public String ExeAccess = "";
	public int compId = 0;
	public String empFormatDate = "";
	private String orderByField = "";
	private String orderType = "";
	public String strSearch = "";
	public String requestType = "";

	HashMap output = null;
	JSONObject inputObj = null;

	public Map<String, String> inventoryLocationService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		locationId = "0";
		configInventoryLocationName = getSession("configInventoryLocationName", session);
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			if (!returnPerm("compId,emp_item_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			inputObj = new JSONObject(input);
			output = new HashMap<String, String>();
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			switch (requestType) {
				case "add" : // add
					if (!returnPerm("emp_item_add", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					locationId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "update" :// update
					if (!returnPerm("emp_item_edit", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					locationId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "delete" :// delete
					if (!returnPerm("emp_item_delete", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					if (!inputObj.isNull("locationId")) {
						locationId = CNumeric(PadQuotes(inputObj.getString("locationId")));
						if (!inputObj.isNull("catId")) {
							locationId = inputObj.getString("locationId");
						}
						if (!locationId.equals("0")) {
							deleteFields(locationId);
						}
					}
					break;
			}
		}
		return output;
	}

	private void getValues(JSONObject inputObj) throws JSONException {
		if (!inputObj.isNull("locationId")) {
			locationId = CNumeric(PadQuotes(inputObj.getString("locationId")));
		}
		if (!inputObj.isNull("locationBranchId")) {
			locationBranchId = CNumeric(PadQuotes(inputObj.getString("locationBranchId")));
		}
		if (!inputObj.isNull("locationName")) {
			locationName = PadQuotes(inputObj.getString("locationName"));
		}
		if (!inputObj.isNull("locationCode")) {
			locationCode = PadQuotes(inputObj.getString("locationCode"));
		}
		if (!inputObj.isNull("locationPhone1")) {
			locationPhone1 = PadQuotes(inputObj.getString("locationPhone1"));
		}
		if (!inputObj.isNull("locationPhone2")) {
			locationPhone2 = PadQuotes(inputObj.getString("locationPhone2"));
		}
		if (!inputObj.isNull("locationMobile1")) {
			locationMobile1 = PadQuotes(inputObj.getString("locationMobile1"));
		}
		if (!inputObj.isNull("locationMobile2")) {
			locationMobile2 = PadQuotes(inputObj.getString("locationMobile2"));
		}
		if (!inputObj.isNull("locationAddress")) {
			locationAddress = PadQuotes(inputObj.getString("locationAddress"));
		}
		if (!inputObj.isNull("stateId")) {
			stateId = PadQuotes(inputObj.getString("stateId"));
		}
		if (!inputObj.isNull("locationCityId")) {
			locationCityId = CNumeric(PadQuotes(inputObj.getString("locationCityId")));
		}
		if (!inputObj.isNull("locationPin")) {
			locationPin = CNumeric(PadQuotes(inputObj.getString("locationPin")));
		}
	}

	private void addFields(HttpServletResponse response) throws ParseException {
		ValidateFields();
		AxelaInventoryLocation axelaInventoryLocation = null;
		if (msg.equals("")) {
			if (!locationId.equals("0")) {
				axelaInventoryLocation = inventoryLocationRepository.findOne(Integer.parseInt(locationId));
			} else {
				axelaInventoryLocation = new AxelaInventoryLocation();
			}
			axelaInventoryLocation.setLocationId(Integer.parseInt(locationId));
			axelaInventoryLocation.setLocationBranchId(Integer.parseInt(locationBranchId));
			axelaInventoryLocation.setLocationName(locationName);
			axelaInventoryLocation.setLocationCode(locationCode);
			axelaInventoryLocation.setLocationAddress(locationAddress);
			axelaInventoryLocation.setLocationCityId(Integer.parseInt(locationCityId));
			axelaInventoryLocation.setLocationPin(locationPin);
			axelaInventoryLocation.setLocationPhone1(locationPhone1);
			axelaInventoryLocation.setLocationPhone2(locationPhone2);
			axelaInventoryLocation.setLocationMobile1(locationMobile1);
			axelaInventoryLocation.setLocationMobile2(locationMobile2);
			if (requestType.equals("add") && locationId.equals("0")) {
				axelaInventoryLocation.setLocationEntryId(empId);
				axelaInventoryLocation.setLocationEntryDate(kknow());
				axelaInventoryLocation.setLocationModifiedId(0);
				axelaInventoryLocation.setLocationModifiedDate(stringToDate(""));
			} else if (requestType.equals("update") && !locationId.equals("0")) {
				axelaInventoryLocation.setLocationModifiedId(empId);
				axelaInventoryLocation.setLocationModifiedDate(kknow());
			}
			String locationId = inventoryLocationRepository.save(axelaInventoryLocation).getLocationId() + "";
			if (!locationId.equals("0") && requestType.equals("add")) {
				// CheckStockLocation("0", locationId);
				// CalCurrentStock("0", locationId);// if id = 0 -> add mode else update mode
				output.put("successmsg", "Location Added Successfully!");
				output.put("locationId", locationId);
			} else if (!locationId.equals("0") && requestType.equals("update")) {
				// CheckStockLocation("0", locationId);
				// CalCurrentStock("0", locationId);
				output.put("locationId", locationId);
				output.put("successmsg", "Location Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	private void ValidateFields() {
		msg = "";
		if (locationBranchId.equals("0")) {
			msg += "<br>Select Branch!";
		}

		if (locationName.equals("")) {
			msg += "<br>Enter Name!";
		} else {

			StrSql = " AND location.locationName = '" + locationName + "'";
			if (requestType.equals("update")) {
				StrSql += " AND location.locationId != " + locationId + "";
			}

			List<AxelaInventoryLocation> axelaInventoryLocation = inventoryLocationFilter.findLocationName(StrSql);
			if (!axelaInventoryLocation.isEmpty()) {
				msg += "<br>Similar " + configInventoryLocationName + " Name found!";
			}
		}
		if (locationCode.equals("")) {
			msg += "<br>Enter Code!";
		} else {

			StrSql = " AND location.locationCode = '" + locationCode + "'";
			if (requestType.equals("update")) {
				StrSql += " AND location.locationId != " + locationId + "";
			}
			List<AxelaInventoryLocation> axelaInventoryLocation = inventoryLocationFilter.findLocationCode(StrSql);
			if (!axelaInventoryLocation.isEmpty()) {
				msg += "<br>Similar " + configInventoryLocationName + " Code found!";
			}
		}
		if (!locationPhone1.equals("") && !IsValidPhoneNo(locationPhone1)) {
			msg += "<br>Phone1 is Invalid!";
		}
		if (!locationPhone2.equals("") && !IsValidPhoneNo(locationPhone2)) {
			msg += "<br>Phone2 is Invalid!";
		}
		if (!locationMobile1.equals("") && !IsValidMobileNo(locationMobile1)) {
			msg += "<br>Mobile1 is Invalid!";
		}
		if (!locationMobile2.equals("") && !IsValidMobileNo(locationMobile2)) {
			msg += "<br>Mobile2 is Invalid!";
		}
		if (locationAddress.equals("")) {
			msg += "<br>Enter Address!";
		}
		if (stateId.equals("0")) {
			msg = msg + "<br>Select State!";
		}
		if (locationCityId.equals("0")) {
			msg += "<br>Select City!";
		}
		if (locationPin.equals("")) {
			msg += "<br>Enter Pin Code!";
		} else if (!locationPin.equals("") && !isNumeric(locationPin)) {
			msg += "<br>Pin Code: Enter Numeric!";
		}
		if (locationAdd.length() > 255) {
			locationAdd = locationAdd.substring(0, 254);
		}
	}

	private void deleteFields(String locationId) {
		inventoryLocationRepository.delete(Integer.parseInt((locationId)));
		output.put("successmsg", "Location Deleted successfully");
	}

	public Map locationPopulateFields(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			if (!returnPerm("emp_item_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			HashMap<String, String> map = new HashMap<String, String>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			AxelaEmp emp = null;
			String locationId = "0";
			if (!inputObj.isNull("locationId")) {
				locationId = inputObj.getString("locationId");
			}
			if (!locationId.equals("0")) {
				List<AxelaInventoryLocation> axelaInventoryLocation = inventoryLocationFilter.populateFields(Integer.parseInt(locationId));
				if (axelaInventoryLocation != null && !axelaInventoryLocation.isEmpty()) {
					for (AxelaInventoryLocation inventoryLocation : axelaInventoryLocation) {
						map.put("locationBranchId", "" + inventoryLocation.getLocationBranchId());
						map.put("locationName", "" + inventoryLocation.getLocationName());
						map.put("locationCode", "" + inventoryLocation.getLocationCode());
						map.put("locationPhone1", "" + inventoryLocation.getLocationPhone1());
						map.put("locationPhone2", inventoryLocation.getLocationPhone2());
						map.put("locationMobile1", inventoryLocation.getLocationMobile1());
						map.put("locationMobile2", inventoryLocation.getLocationMobile2());
						map.put("locationAddress", inventoryLocation.getLocationAddress());
						map.put("locationCityId", "" + inventoryLocation.getLocationCityId());
						map.put("locationPin", "" + inventoryLocation.getLocationPin());
						if (inventoryLocation.getLocationEntryId() != 0) {
							emp = axelaEmpRepository.findByEmpId(inventoryLocation.getLocationEntryId());
							map.put("locationEntryBy", PadQuotes(emp.getEmpName()));
							map.put("locationEntryId", inventoryLocation.getLocationEntryId() + "");
						}
						map.put("locationEntryDate", strToShortDate(inventoryLocation.getLocationEntryDate()));
						if (inventoryLocation.getLocationModifiedId() != 0) {
							emp = axelaEmpRepository.findByEmpId(inventoryLocation.getLocationModifiedId());
							map.put("locationModifiedId", inventoryLocation.getLocationModifiedId() + "");
							map.put("locationModifiedBy", PadQuotes(emp.getEmpName()));
							map.put("locationModifiedDate", strToShortDate(inventoryLocation.getLocationModifiedDate()));
						}
					}
					list.add(map);
					output.put("populateData", list);
				}
				output.put("msg", "Invalid!");
			}
		}
		return output;
	}
	public void CheckStockLocation(String itemId, String locationId) {
		String StrSql = "";
		StrSql = "DELETE FROM AxelaInventoryStock stock"
				+ " WHERE 1 = 1";
		if (!itemId.equals("0")) {
			StrSql += " AND stock.stockItemId = " + itemId;
		}
		if (!locationId.equals("0")) {
			StrSql += " AND stock.stockLocationId = " + locationId;
		}
		inventoryStocklFilterImp.updateQuery(StrSql);
		// INSERT INTO axela_2.axela_inventory_stock (
		// stock_item_id,
		// stock_location_id
		// ) SELECT
		// item_id,
		// location_id
		// FROM
		// (
		// SELECT
		// item_id,
		// location_id
		// FROM
		// axela_2.axela_inventory_item,
		// axela_2.axela_inventory_location
		// WHERE
		// item_active = 1
		// AND item_stock = 1
		// ) AS item
		// LEFT JOIN axela_2.axela_inventory_stock ON CONCAT(
		// stock_item_id,
		// stock_location_id
		// ) = CONCAT(item_id, location_id)
		StrSql = "INSERT INTO AxelaInventoryStock stock"
				+ " ("
				+ "	stockItemId,"
				+ " stock.stock_location_id"
				+ "	)"
				+ " SELECT item_id, location_id"
				+ " FROM (SELECT item.itemId, locationId"
				+ " FROM AxelaInventoryItem item,AxelaInventoryLocation location"
				+ " WHERE item.itemActive = 1" + " AND item.itemStock = 1";
		if (!itemId.equals("0")) {
			StrSql += " AND item_id = " + itemId;
		}
		StrSql += ") AS item"
				+ " LEFT JOIN axela_inventory_stock"
				+ " ON CONCAT(stock_item_id," + " stock_location_id) = CONCAT(item_id, location_id)";
		// + " WHERE stock_location_id IS NULL";
		// SOPInfo("StrSql==stockloc==" + StrSqlBreaker(StrSql));
		updateQuery(StrSql);
	}

	public void CalCurrentStock(String item_id, String location_id) {
		try {
			String StrSql = "UPDATE axela_inventory_stock"
					+ " INNER JOIN axela_inventory_item ON item_id = stock_item_id"
					+ " SET stock_current_qty = \n" + " @stockcount:= \n"
					+ " COALESCE((SELECT SUM(IF(voucherclass_inventory_traffic = 1, vouchertrans_qty, -vouchertrans_qty))\n"
					+ " FROM  axela_acc_voucher_trans\n"
					+ " INNER JOIN axela_acc_voucher ON voucher_id = vouchertrans_voucher_id\n"
					+ " INNER JOIN axela_acc_voucher_type ON vouchertype_id = voucher_vouchertype_id\n"
					+ " INNER JOIN axela.axela_acc_voucher_class ON voucherclass_id = vouchertype_voucherclass_id\n"
					+ " WHERE vouchertrans_item_id = stock_item_id \n"
					+ " AND vouchertrans_location_id = stock_location_id \n"
					+ " AND vouchertype_affects_inventory = 1 AND voucher_active = 1),0)"
					+ " WHERE item_active = 1"
					+ " AND item_stock = 1";

			if (!item_id.equals("")) {
				StrSql += item_id;
			}

			if (!CNumeric(location_id).equals("0")) {
				StrSql += " AND stock_location_id = " + location_id + "";
			}
			updateQuery(StrSql);
		} catch (Exception ex) {
			SOPError(this.getClass().getName());
			SOPError("Error in "
					+ new Exception().getStackTrace()[0].getMethodName() + ": "
					+ ex);
		}
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		page = 0;
		String strSearch = "";
		String strOrderBy = "";
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		perPage = CNumeric(getSession("empRecperPage", session));
		field = "";
		if (empId != 0) {
			if (!returnPerm("emp_item_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			inputObj = new JSONObject(input);
			configInventoryLocationName = getSession("configInventoryLocationName", session);
			output = new LinkedHashMap<String, String>();
			List<AxelaInventoryLocation> locationList = null;
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
			if (!inputObj.isNull("sortDirection")) {
				orderType = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
			}

			if (!inputObj.isNull("locationId")) {
				locationId = CNumeric(PadQuotes((inputObj.getString("locationId"))));
			}
			if (!locationId.equals("0")) {
				strSearch = " AND location.locationId=" + locationId;
			}
			if (!inputObj.isNull("requestType")) {
				requestType = PadQuotes((inputObj.getString("requestType")));
			}
			perPage = "25";
			if (perPage.equals("0")) {
				perPage = "25";
			}
			if (orderType.equals("")) {
				orderType = "DESC";
			}
			if (orderByField.equals("")) {
				orderByField = "locationId";
			}
			if (configInventoryLocationName.equals("")) {
				configInventoryLocationName = "Location";
			}
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			page++;
			strSearch += "";
			strOrderBy = " ORDER BY location." + orderByField + " " + orderType;
			locationList = inventoryLocationFilter.findAll(strSearch, strOrderBy, page, Integer.parseInt(CNumeric(perPage)));
			totalCount = Integer.parseInt(inventoryLocationFilter.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("ID", "locationId", "center"));
			listHeader.add(produceHeaderData(configInventoryLocationName, "locationName", "left"));
			listHeader.add(produceHeaderData("Branch", "axelaBranch.branchName", "center"));
			listHeader.add(produceHeaderData("Contacts", "locationPhone1", "left"));
			listHeader.add(produceHeaderData("Address", "locationAddress", "center"));
			// End Header Data
			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaInventoryLocation obj : locationList) {
				ArrayList<String> param = new ArrayList<String>();
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
				value.add(obj.getLocationId());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Warehouse
				type.add(false);
				value.add(obj.getLocationName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Branch
				type.add(true);
				value.add(obj.getBranchName());
				paramSubArr.add("branch-summary");
				paramSubArr.add(obj.getBranchId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// Contacts
				if (!obj.getLocationPhone1().equals("")) {
					type.add(false);
					value.add(PadQuotes(obj.getLocationPhone1()));
				}

				if (!obj.getLocationPhone2().equals("")) {
					type.add(false);
					value.add(PadQuotes(obj.getLocationPhone2()));
				}

				if (!obj.getLocationMobile1().equals("")) {
					type.add(false);
					value.add(PadQuotes(obj.getLocationMobile1()));
				}

				if (!obj.getLocationMobile2().equals("")) {
					type.add(false);
					value.add(PadQuotes(obj.getLocationMobile2()));
				}
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Address
				if (!obj.getLocationAddress().equals("")) {
					type.add(false);
					value.add(PadQuotes(obj.getLocationAddress() + "-" + obj.getLocationPin()));
				}
				type.add(false);
				value.add(PadQuotes(obj.getStateName()) + ", " + PadQuotes(obj.getCountryName()) + ".");
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				mapData.put("td", listData);
				ArrayList<String> locationParam = new ArrayList<String>();
				locationParam.add("update" + configInventoryLocationName);
				locationParam.add(PadQuotes(String.valueOf(obj.getLocationId())));
				mapAction.put("td", produceActionData(locationParam));
				listAction.add(mapAction);
				listBody.add(mapData);
			}
			output.put("meta", mapNavi);
			output.put("thead", listHeader);
			output.put("tdalign", listBodyAlign);
			output.put("tbody", listBody);
			output.put("action", listAction);
		}
		return output;
	}

	private ArrayList<HashMap> produceActionData(ArrayList<String> locationParam) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();

		mapBodyData.put("value", "Update " + configInventoryLocationName);
		mapBodyData.put("routingLink", "");
		// inventory/location
		mapBodyData.put("param", locationParam);
		listAction.add((HashMap) mapBodyData.clone());

		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "location.*"));
		list.add(buildSmartArr("Location ID", "numeric", "location.locationId"));
		output.put("drSmart", list.toArray());
		return output;
	}

	public Map inventoryConfigDetails(String input, HttpSession session, HttpServletResponse response) throws JSONException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		configInventoryLocationName = PadQuotes(getSession("configInventoryLocationName", session));
		if (empId != 0) {
			if (!returnPerm("emp_item_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("locationName", "" + configInventoryLocationName);
			output.put("populateInventoryConfigDetails", map);
		}
		return output;
	}
}
