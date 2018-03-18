package axela.inventory.service;
//shekespeare
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
import axela.inventory.model.AxelaInventoryBin;
import axela.inventory.model.AxelaInventoryBinItem;
import axela.inventory.model.AxelaInventoryBinPop;
import axela.inventory.repository.InventoryBinFilterImp;
import axela.inventory.repository.InventoryBinItemRepository;
import axela.inventory.repository.InventoryBinPopRepository;
import axela.inventory.repository.InventoryBinRepository;
import axela.portal.model.AxelaEmp;
import axela.portal.repository.EmpRepository;

@Service
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class InventoryBinService extends Connect {

	@Autowired
	InventoryBinFilterImp inventoryBinFilterImp;
	@Autowired
	InventoryBinRepository inventoryBinRepository;
	@Autowired
	EmpRepository empRepository;
	@Autowired
	InventoryBinPopRepository inventoryBinPopRepository;
	@Autowired
	InventoryBinItemRepository inventoryBinItemRepository;

	public String msg = "";
	public int page = 0;
	public String perPage = "0";
	public String sort = "Desc";
	public int empId = 0;
	public int compId = 0;
	public String field = "", value = "";
	public String empRoleId = "0";
	public String binId = "0", binParentId = "0";
	public String binLocationId = "0";
	private String orderByField = "";
	private String orderType = "";
	public String binName = "";
	public String binPid = "";
	public String branchName = "";
	public String binActive = "";
	public String locationName = "";
	public String binEntryId = "0", entry_by = "";
	public String binEntryDate = "";
	public String binModifiedId = "0", modifiedBy = "";
	public String binModifiedDate = "";
	public String branchId = "";
	// configuration
	public String configInventoryLocationName = "";
	public String branchAccess = "", exeAccess = "";
	public String ExeAccess = "";
	public String empFormatDate = "";
	public String keyword = "";
	public int length = 0;
	public String pageNumber = "";
	public String property = "";
	public int totalCount = 0;
	public String strSearch = "";
	public String requestType = "";

	LinkedHashMap output = null;
	JSONObject inputObj = null;

	public Map<String, String> inventoryBinService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		configInventoryLocationName = PadQuotes(getSession("configInventoryLocationName", session));
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		if (empId != 0) {
			if (!returnPerm(compId + ", emp_item_access, emp_sales_item_access, emp_pos_item_access, emp_invoice_item_access, emp_prod_item_access, emp_service_item_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			switch (requestType) {

				case "add" : // add
					if (!returnPerm(compId + ", emp_item_add, emp_sales_item_add, emp_pos_item_add, emp_invoice_item_add, emp_prod_item_add, emp_service_item_add", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					binId = "0";
					getValues(inputObj);
					addFields(session, response);
					break;

				case "update" :// update
					if (!returnPerm(compId + ", emp_item_edit, emp_sales_item_edit, emp_pos_item_edit, emp_invoice_item_edit, emp_prod_item_edit, emp_service_item_edit", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					binId = "0";
					getValues(inputObj);
					addFields(session, response);
					break;

				case "delete" :// delete
					if (!returnPerm(compId + ", emp_item_delete, emp_sales_item_delete, emp_pos_item_delete, emp_invoice_item_delete, emp_prod_item_delete, emp_service_item_delete", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					if (!inputObj.isNull("binId")) {
						binId = CNumeric(PadQuotes(inputObj.getString("binId")));
						deleteFields(binId, response);
					}
					break;
			}
		}
		return output;
	}

	private void addFields(HttpSession session, HttpServletResponse response) throws ParseException {
		validateFields();
		AxelaInventoryBin axelaInventoryBin = null;
		if (msg.equals("")) {
			if (!CNumeric(binId).equals("0")) {
				axelaInventoryBin = inventoryBinRepository.findOne(Integer.parseInt(CNumeric(binId)));
			} else {
				axelaInventoryBin = new AxelaInventoryBin();
			}
			axelaInventoryBin.setBinId(Integer.parseInt(binId));
			axelaInventoryBin.setBinLocationId(Integer.parseInt(binLocationId));
			axelaInventoryBin.setBinName(binName);
			axelaInventoryBin.setBinParentId(Integer.parseInt(binParentId));
			axelaInventoryBin.setBinActive(binActive);
			if (requestType.equals("add")) {
				axelaInventoryBin.setBinEntryId(empId);
				axelaInventoryBin.setBinEntryDate(getTimeByZone(session));
				axelaInventoryBin.setBinModifiedId(0);
			}
			if (requestType.equals("update")) {
				axelaInventoryBin.setBinModifiedId(empId);
				axelaInventoryBin.setBinModifiedDate(getTimeByZone(session));
			}
			if (!binLocationId.equals("0")) {
				inventoryBinRepository.save(axelaInventoryBin);
			}
			inventoryBinPopRepository.deleteAllBinPop();
			UpdateBinPop("0");
			if (binId.equals("0")) {
				output.put("successmsg", "Bin Added Successfully!");
				output.put("binId", axelaInventoryBin.getBinId() + "");
			} else {
				output.put("binId", axelaInventoryBin.getBinId() + "");
				output.put("successmsg", "Bin Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public Map populateField(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		output = new LinkedHashMap<String, String>();
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		if (empId != 0) {
			if (!returnPerm(compId + ", emp_item_access, emp_sales_item_access, emp_pos_item_access, emp_invoice_item_access, emp_prod_item_access, emp_service_item_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			AxelaEmp emp = null;
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			List<AxelaInventoryBin> obj = null;
			if (!inputObj.isNull("binId")) {
				binId = inputObj.getString("binId");
			}
			if (!binId.equals("0")) {
				strSearch = " AND bin.binId=" + binId;
				obj = inventoryBinFilterImp.populateField(strSearch);
			}
			for (AxelaInventoryBin axelaInventoryBin : obj) {
				HashMap<String, String> map = new HashMap<>();
				map.put("binName", axelaInventoryBin.getBinName());
				map.put("binLocationId", "" + axelaInventoryBin.getBinLocationId());
				map.put("binParentId", "" + axelaInventoryBin.getBinParentId());
				map.put("branchName", axelaInventoryBin.getBranchName());
				map.put("branchId", "" + axelaInventoryBin.getBranchId());
				if (!axelaInventoryBin.getLocationCode().equals("")) {
					map.put("locationName", axelaInventoryBin.getLocationName() + "(" + axelaInventoryBin.getLocationCode() + ")");
				} else {
					map.put("locationName", axelaInventoryBin.getLocationName());
				}
				if (axelaInventoryBin.getBinEntryId() != 0 && !axelaInventoryBin.getBinEntryDate().equals("")) {
					map.put("binEntryId", String.valueOf(axelaInventoryBin.getBinEntryId()));
					map.put("binEntryBy", empRepository.findEmpName(Integer.parseInt(String.valueOf(axelaInventoryBin.getBinEntryId()))));
					map.put("binEntryDate", strToShortDate(axelaInventoryBin.getBinEntryDate()));
				}
				if (axelaInventoryBin.getBinModifiedId() != 0 && !axelaInventoryBin.getBinModifiedDate().equals("")) {
					map.put("binModifiedId", String.valueOf(axelaInventoryBin.getBinModifiedId()));
					map.put("binModifiedBy", empRepository.findEmpName(Integer.parseInt(String.valueOf(axelaInventoryBin.getBinModifiedId()))));
					map.put("binModifiedDate", strToShortDate(axelaInventoryBin.getBinModifiedDate()));
				}
				list.add(map);
			}
			output.put("populateData", list);
		}
		return output;
	}

	private void validateFields() {
		msg = "";
		if (binLocationId.equals("0")) {
			msg += "<br>Select " + configInventoryLocationName + "!";
		}
		if (binName.equals("")) {
			msg += "<br>Enter Name!";
		} else if (!binLocationId.equals("0")) {
			strSearch = " AND binName = '" + binName + "'"
					+ " AND bin.binId != " + CNumeric(binId) + ""
					+ " AND bin.binLocationId = " + binLocationId + "";

			List<AxelaInventoryBin> axelaInventoryBin = inventoryBinFilterImp.findBinName(strSearch);
			if (!axelaInventoryBin.isEmpty()) {
				msg += "<br>Similar Name found!";
			}
		}
	}

	private void getValues(JSONObject inputObj) throws JSONException {
		if (!inputObj.isNull("binId")) {
			binId = inputObj.getString("binId");
		}
		if (!inputObj.isNull("branchId")) {
			branchId = inputObj.getString("branchId");
		}
		if (!inputObj.isNull("branchName")) {
			branchName = inputObj.getString("branchName");
		}
		if (!inputObj.isNull("locationName")) {
			locationName = inputObj.getString("locationName");
		}
		if (!inputObj.isNull("binName")) {
			binName = inputObj.getString("binName");
		}
		if (!inputObj.isNull("binParentId")) {
			binParentId = inputObj.getString("binParentId");
		}
		if (!inputObj.isNull("binLocationId")) {
			binLocationId = inputObj.getString("binLocationId");
		}
	}

	protected void deleteFields(String binId, HttpServletResponse response) {
		msg = "";
		if (binId.equals("1")) {
			msg = "<br>Cannot delete First Record!";
		}
		List<AxelaInventoryBin> axelaInventoryBin = inventoryBinRepository.findBybinParentId(Integer.parseInt(binId));
		if (!axelaInventoryBin.isEmpty()) {
			msg += "<br>Bin has Sub Bin(s)!";
		}
		List<AxelaInventoryBinItem> axelaInventoryBinItem = inventoryBinItemRepository.findBybinitemBinId(Integer.parseInt(binId));
		if (!axelaInventoryBinItem.isEmpty()) {
			msg += "<br>Bin is associated with a Bin Items!";
		}
		if (msg.equals("")) {
			inventoryBinRepository.delete(Integer.parseInt(binId));
			inventoryBinPopRepository.deleteByBinId(Integer.parseInt(binId));
			output.put("successmsg", "Bin Deleted Successfully");
		} else {
			response.setStatus(400);
			output.put("errormsg", msg);
		}
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		page = 0;
		binId = "0";
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		perPage = CNumeric(getSession("empRecperPage", session));
		configInventoryLocationName = PadQuotes(getSession("empId", session));
		String strSearch = "";
		String strOrderBy = "";
		if (empId != 0) {
			if (!returnPerm(compId + ", emp_item_access, emp_sales_item_access, emp_pos_item_access, emp_invoice_item_access, emp_prod_item_access, emp_service_item_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			List<AxelaInventoryBin> binList = null;
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
			if (!inputObj.isNull("binId")) {
				binId = CNumeric(PadQuotes((inputObj.getString("binId"))));
			}
			if (!inputObj.isNull("requestType")) {
				requestType = PadQuotes((inputObj.getString("requestType")));
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
				orderByField = "binId";
			}
			if (!binId.equals("0")) {
				strSearch = " AND bin.binId=" + binId;
			}
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			page++;
			strSearch += branchAccess + exeAccess;
			strOrderBy = " ORDER BY bin." + orderByField + " " + orderType;
			binList = inventoryBinFilterImp.findAll(strSearch, strOrderBy, page, Integer.parseInt(CNumeric(perPage)));
			totalCount = Integer.parseInt(inventoryBinFilterImp.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("ID", "binId", "center"));
			listHeader.add(produceHeaderData("Item", "binName", "center"));
			listHeader.add(produceHeaderData(configInventoryLocationName, "axelaInventoryLocation.locationName", "center"));
			listHeader.add(produceHeaderData("Branch", "axelaInventoryLocation.axelaBranch.branchId", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaInventoryBin obj : binList) {
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
				value.add(obj.getBinId());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Bin
				type.add(false);
				value.add(obj.getBinName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Warehouse
				type.add(true);
				value.add(obj.getLocationName());
				paramSubArr.add("locationList");
				paramSubArr.add(obj.getLocationId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// Branch
				type.add(true);
				value.add(obj.getBranchName());
				paramSubArr.add("branch-summary");
				paramSubArr.add(obj.getBranchId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// End Of Body
				mapData.put("td", listData);
				ArrayList<String> binUpdateAction = new ArrayList<String>();
				ArrayList<String> itemListAction = new ArrayList<String>();
				ArrayList<String> binItemList = new ArrayList<String>();
				binUpdateAction.add("updateBin");
				binUpdateAction.add(PadQuotes(String.valueOf(obj.getBinId())));
				binItemList.add("binItemList");
				binItemList.add("" + obj.getBinId());
				mapAction.put("td", produceActionData(binUpdateAction, itemListAction, binItemList));
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

	private ArrayList<HashMap> produceActionData(ArrayList<String> updatePrice, ArrayList<String> itemListAction, ArrayList<String> binItemList) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Bin");
		mapBodyData.put("param", updatePrice);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Bin Item List");
		mapBodyData.put("param", binItemList);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public void UpdateBinPop(String binParentId) {
		String StrSql = "", binName = "";
		int rank = 0;
		List<AxelaInventoryBinPop> listaxelaInventoryBinPop = new ArrayList<AxelaInventoryBinPop>();
		StrSql = "SELECT NEW AxelaInventoryBin("
				+ " bin.binId, bin.binName, bin.binLocationId, bin.binParentId, bin.binActive)"
				+ " FROM AxelaInventoryBin bin"
				+ " WHERE 1=1"
				+ " AND bin.binParentId = " + binParentId + ""
				+ " ORDER BY bin.binName";
		List<AxelaInventoryBin> listBins = inventoryBinFilterImp.UpdateBinPop(StrSql);
		for (AxelaInventoryBin bins : listBins) {
			rank++;
			binParentId = "" + bins.getBinId();
			if (binParentId.equals("0")) {
				binName = bins.getBinName();
			} else {
				binName = PopulateBinStr("" + bins.getBinId());
			}
			AxelaInventoryBinPop axelaInventoryBinPop = new AxelaInventoryBinPop();
			axelaInventoryBinPop.setBinId(bins.getBinId());
			axelaInventoryBinPop.setBinLocationId(bins.getBinLocationId());
			axelaInventoryBinPop.setBinName(binName);
			axelaInventoryBinPop.setBinRank(rank);
			axelaInventoryBinPop.setBinActive(bins.getBinActive());
			listaxelaInventoryBinPop.add(axelaInventoryBinPop);
			UpdateBinPop(binParentId);
		}
		inventoryBinPopRepository.save(listaxelaInventoryBinPop);
	}

	public String PopulateBinStr(String binId) {
		String binName = "", StrSql = "", binParentId = "0";
		if (!CNumeric(binId).equals("0")) {
			StrSql = "SELECT NEW AxelaInventoryBin("
					+ " bin.binId, bin.binName, bin.binParentId)"
					+ " FROM AxelaInventoryBin bin"
					+ " WHERE 1=1 "
					+ " AND bin.binId = " + binId + "";
			List<AxelaInventoryBin> listBins = inventoryBinFilterImp.GetBinName(StrSql);
			for (AxelaInventoryBin bin : listBins) {
				binName += bin.getBinName();
				binParentId = "" + bin.getBinParentId();
				if (!binParentId.equals("0")) {
					while (!binParentId.equals("0")) {
						StrSql = "SELECT NEW AxelaInventoryBin("
								+ " bin.binId, bin.binName, bin.binParentId)"
								+ " FROM AxelaInventoryBin bin"
								+ " WHERE 1=1 "
								+ " AND  bin.binId = " + binParentId + "";

						List<AxelaInventoryBin> listBinsParent = inventoryBinFilterImp.GetBinName(StrSql);
						for (AxelaInventoryBin bins : listBinsParent) {
							binName += bins.getBinName() + " > " + binName;
							binParentId = "" + bins.getBinParentId();
						}
					}
				}
			}
		}
		return binName;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "bin.*"));
		list.add(buildSmartArr("Bin ID", "numeric", "bin.binId"));
		output.put("drSmart", list.toArray());
		return output;
	}

}
