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
import axela.inventory.model.AxelaInventoryBinItem;
import axela.inventory.repository.BinItemRepository;
import axela.inventory.repository.InventoryBinItemFilterImp;

@Service
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class InventoryBinItemService extends Connect {

	@Autowired
	InventoryBinItemFilterImp inventoryBinItemFilterImp;

	@Autowired
	BinItemRepository binItemRepository;

	public String modelId = "0";
	public String itemId = "0";
	public String prevItemId = "0";
	public String binName = "";
	public String branchName = "";
	public String locationName = "";
	public String branchId = "0";
	public String locationId = "0";
	public String binitemId = "0";
	public String binitemBinId = "0";
	public String binitemItemId = "0";
	public String msg = "";
	public int page = 0;
	public String perPage = "0";
	public String sort = "Desc";
	public int empId = 0;
	public int compId = 0;
	public String field = "", value = "";
	// configuration
	public String configInventoryLocationName = "";
	public String branchAccess = "", exeAccess = "";
	public String ExeAccess = "";
	public String orderByField = "";
	public String orderType = "";
	public String empFormatDate = "";
	public String keyword = "";
	public String requestType = "";
	public int length = 0;
	public String pageNumber = "";
	public String property = "";
	public int PAGESIZE = 25;
	public String strSearch = "";
	public int totalCount = 0;
	public String requesttype = "";

	JSONObject inputObj = null;
	Map output = null;

	public Map binItemService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		if (empId != 0) {
			if (!returnPerm(compId + ", emp_item_access, emp_sales_item_access, emp_pos_item_access, emp_invoice_item_access, emp_prod_item_access, emp_service_item_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			inputObj = new JSONObject(input);
			output = new HashMap();
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			switch (requestType) {
				case "add" : // add
					if (!returnPerm(compId + ", emp_item_add, emp_pos_item_add", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					binitemId = "0";
					getValues();
					addFields(response);
					break;
				case "update" :// update
					if (!returnPerm(compId + ",emp_item_edit, emp_pos_item_edit", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					binitemId = "0";
					getValues();
					addFields(response);
					break;
				case "delete" :// delete
					if (!returnPerm(compId + ",emp_item_delete, emp_pos_item_delete", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					if (!inputObj.isNull("binitemId")) {
						binitemId = inputObj.getString("binitemId");
					}
					if (!binitemId.equals("0")) {
						deleteFields(binitemId);
					}
					break;
				case "populateData" :// update
					if (!returnPerm(compId + ", emp_item_access, emp_sales_item_access, emp_pos_item_access, emp_invoice_item_access, emp_prod_item_access, emp_service_item_access", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					if (!inputObj.isNull("binitemId")) {
						binitemId = inputObj.getString("binitemId");
					}
					if (!inputObj.isNull("binitemBinId")) {
						binitemBinId = inputObj.getString("binitemBinId");
					}

					if (!binitemId.equals("0")) {
						binDetail(binitemId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues() throws JSONException {
		msg = "";
		if (!inputObj.isNull("binitemId")) {
			binitemId = CNumeric(inputObj.getString("binitemId"));
		}
		if (!inputObj.isNull("binitemBinId")) {
			binitemBinId = CNumeric(inputObj.getString("binitemBinId"));
		}
		if (!inputObj.isNull("binitemItemId")) {
			binitemItemId = CNumeric(inputObj.getString("binitemItemId"));
		}
		if (!inputObj.isNull("modelId")) {
			modelId = CNumeric(inputObj.getString("modelId"));
		}
		if (!inputObj.isNull("itemId")) {
			itemId = CNumeric(inputObj.getString("itemId"));
		}
		if (!inputObj.isNull("prevItemId")) {
			prevItemId = CNumeric(inputObj.getString("prevItemId"));
		}
		if (!inputObj.isNull("locationName")) {
			locationName = PadQuotes(inputObj.getString("locationName"));
		}
		if (!inputObj.isNull("branchName")) {
			branchName = PadQuotes(inputObj.getString("branchName"));
		}
		if (!inputObj.isNull("branchId")) {
			branchId = CNumeric(inputObj.getString("branchId"));
		}
		if (!inputObj.isNull("locationId")) {
			locationId = CNumeric(inputObj.getString("locationId"));
		}
	}

	public void validateFields() {
		msg = "";
		strSearch = "";
		if (modelId.equals("0")) {
			msg += "<br>Select Model!";
		}
		if (itemId.equals("0")) {
			msg += "<br>Select Item!";
		} else {
			strSearch = " AND binItem.binitemItemId = " + itemId
					+ " AND binItem.binitemBinId = " + binitemBinId + ""
					+ " AND binItem.binitemItemId != " + prevItemId + "";
			Long item = inventoryBinItemFilterImp.getItemDetail(strSearch);
			if (item != 0) {
				msg += "<br>Item Already Added!";
			}
		}
	}

	public void addFields(HttpServletResponse response) throws JSONException, ParseException {
		validateFields();
		if (msg.equals("")) {
			AxelaInventoryBinItem axelaInventoryBinItem = null;
			if (!binitemId.equals("0")) {
				axelaInventoryBinItem = binItemRepository.findByBinitemId(Integer.parseInt(binitemId));
			} else {
				axelaInventoryBinItem = new AxelaInventoryBinItem();
			}
			axelaInventoryBinItem.setBinitemId(Integer.parseInt(binitemId));
			axelaInventoryBinItem.setBinitemBinId(Integer.parseInt(binitemBinId));
			axelaInventoryBinItem.setBinitemItemId(Integer.parseInt(binitemItemId));
			String binitemId = binItemRepository.save(axelaInventoryBinItem).getBinitemId() + "";
			if (!binitemId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("binitemId", binitemId);
				output.put("successmsg", "Bin Item Added Successfully!");
			} else if (!binitemId.equals("0") && requestType.equals("update")) {
				output.put("binitemId", binitemId);
				output.put("successmsg", "Bin Item Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String binitemId) {
		binItemRepository.delete(Integer.parseInt(binitemId));
		output.put("successmsg", "Bin Item Deleted Successfully!");

	}

	public Map populateData(String input, HttpSession session) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		strSearch = "";
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			if (!returnPerm(compId + ", emp_item_access, emp_sales_item_access, emp_pos_item_access, emp_invoice_item_access, emp_prod_item_access, emp_service_item_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			if (!inputObj.isNull("binitemId")) {
				binitemId = PadQuotes(CNumeric(inputObj.getString("binitemId")));
			}
			if (!inputObj.isNull("binitemItemId")) {
				binitemItemId = PadQuotes(CNumeric(inputObj.getString("binitemItemId")));
			}
			if (!inputObj.isNull("binitemBinId")) {
				binitemBinId = PadQuotes(CNumeric(inputObj.getString("binitemBinId")));
			}

			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			if (!binitemId.equals("0")) {
				strSearch += " AND binItem.binitemItemId = "
						+ CNumeric(binitemItemId)
						+ " AND binItem.binitemBinId = "
						+ CNumeric(binitemBinId);
				List<AxelaInventoryBinItem> obj = inventoryBinItemFilterImp.findPopulateDataBinItem(Integer.parseInt(binitemId), strSearch);
				for (AxelaInventoryBinItem axelaInventoryBinItem : obj) {
					HashMap map = new HashMap();
					map.put("binitemId", binitemId);
					map.put("binName", String.valueOf(axelaInventoryBinItem.getBinName()));
					map.put("binitemBinId", String.valueOf(axelaInventoryBinItem.getBinitemBinId()));
					map.put("binitemItemId", String.valueOf(axelaInventoryBinItem.getBinitemItemId()));
					map.put("itemId", String.valueOf(axelaInventoryBinItem.getItemId()));
					map.put("prevItemId", String.valueOf(axelaInventoryBinItem.getItemId()));
					map.put("itemName", String.valueOf(axelaInventoryBinItem.getItemName() + " (" + axelaInventoryBinItem.getItemCode() + ") "));
					map.put("modelId", String.valueOf(axelaInventoryBinItem.getModelId()));
					map.put("branchId", String.valueOf(axelaInventoryBinItem.getBranchId()));
					map.put("branchName", String.valueOf(axelaInventoryBinItem.getBranchName() + " (" + axelaInventoryBinItem.getBranchCode() + ") "));
					map.put("locationId", String.valueOf(axelaInventoryBinItem.getLocationId()));
					map.put("locationName", String.valueOf(axelaInventoryBinItem.getLocationName() + " (" + axelaInventoryBinItem.getLocationCode() + ") "));
					list.add(map);
				}
			}
			output.put("populateData", list);
		}
		return output;
	}

	private void binDetail(String binitemId) {
		output = new HashMap();
		strSearch = "";
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!binitemId.equals("0")) {
			List<AxelaInventoryBinItem> obj = inventoryBinItemFilterImp.findBinDetail(Integer.parseInt(binitemId));
			for (AxelaInventoryBinItem axelaInventoryBinItem : obj) {
				SOP("binDetail=====for====loop");
				HashMap map = new HashMap();
				map.put("binName", String.valueOf(axelaInventoryBinItem.getBinName()));
				map.put("branchName", String.valueOf(axelaInventoryBinItem.getBranchName() + " (" + axelaInventoryBinItem.getBranchCode() + ") "));
				map.put("locationName", String.valueOf(axelaInventoryBinItem.getLocationName() + " (" + axelaInventoryBinItem.getLocationCode() + ") "));
				list.add(map);
			}
		}
		output.put("populateBinDetails", list);
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		page = 0;
		String itemName = "";
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
			branchAccess = getSession("branchAccess", session).replaceAll("branchId", "binItem.customerBranchId");
			exeAccess = getSession("exeAccess", session).replaceAll("empId", "binItem.customerEmpId");
			List<AxelaInventoryBinItem> binItemList = null;
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			PageRequest request = null;
			if (!inputObj.isNull("binitemBinId")) {
				binitemBinId = PadQuotes((inputObj.getString("binitemBinId")));
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
				orderByField = "binitemBinId";
			}
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			page++;
			strSearch += branchAccess + exeAccess;
			strOrderBy = " ORDER BY binItem." + orderByField + " " + orderType;
			binItemList = inventoryBinItemFilterImp.findAll(strSearch, strOrderBy, page, Integer.parseInt(CNumeric(perPage)));
			totalCount = Integer.parseInt(inventoryBinItemFilterImp.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Model", "axelaInventoryItem.axelaInventoryItemModel.modelName", "center"));
			listHeader.add(produceHeaderData("Item", "axelaInventoryItem.itemName", "center"));
			listHeader.add(produceHeaderData("Bins", "axelaInventoryBinPop.binName", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaInventoryBinItem obj : binItemList) {
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

				// Count
				type.add(false);
				value.add(count);
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Model
				type.add(true);
				value.add(obj.getModelName());
				paramSubArr.add("itemModel");
				paramSubArr.add(obj.getModelId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// Item
				type.add(true);
				value.add(obj.getItemName());
				if (!obj.getItemCode().equals("")) {
					type.add(false);
					value.add("(" + PadQuotes(obj.getItemCode()) + ")");
				}
				paramSubArr.add("itemList");
				paramSubArr.add(obj.getItemId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// Bins
				type.add(true);
				value.add(obj.getBinName());
				paramSubArr.add("inventoryBinList");
				paramSubArr.add(obj.getBinId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// End Of The Body
				mapData.put("td", listData);
				ArrayList<String> binItemUpdateAction = new ArrayList<String>();
				binItemUpdateAction.add("inventoryBinItemUpdate");
				binItemUpdateAction.add(PadQuotes(String.valueOf(obj.getBinitemId())));
				binItemUpdateAction.add(PadQuotes(String.valueOf(obj.getBinitemBinId())));
				binItemUpdateAction.add(PadQuotes(String.valueOf(obj.getBinitemItemId())));
				mapAction.put("td", produceActionData(binItemUpdateAction));
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

	private ArrayList<HashMap> produceActionData(ArrayList<String> binItemUpdateAction) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Item Bin");
		mapBodyData.put("param", binItemUpdateAction);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "binItem.*"));
		list.add(buildSmartArr("Item ID", "numeric", "binItem.binitemBinId"));
		list.add(buildSmartArr("Item Name", "text", "binItem.axelaInventoryBinPop.binName"));
		list.add(buildSmartArr("Model Name", "text", "binItem.axelaInventoryItem.axelaInventoryItemModel.modelName"));
		output.put("drSmart", list.toArray());
		return output;
	}
}
