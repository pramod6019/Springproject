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
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.inventory.model.AxelaInventoryItem;
import axela.inventory.model.AxelaInventoryStock;
import axela.inventory.repository.InventoryLocationRepository;
import axela.inventory.repository.InventoryReOrderRepository;
import axela.inventory.repository.InventoryReorderFilterImp;
import axela.portal.repository.EmpRepository;

@Service
public class InventoryReorderLevelService extends Connect {

	@Autowired
	InventoryReorderFilterImp inventoryReorderFilterImp;
	@Autowired
	InventoryReOrderRepository inventoryReOrderRepository;
	@Autowired
	InventoryLocationRepository inventoryLocationRepository;

	@Autowired
	EmpRepository empRepository;
	public String stockId = "0";
	public String stockLocationId = "0";
	public String stockCurrentQty = "0.0";
	public String stockEntryDate = "";
	public String stockEntryId = "0";
	public String stockItemId = "0";
	public String stockOnhandvalue = "0";
	public String stockReorderlevel = "0";
	public String stockStockindemand = "0";
	public String stockStockinorder = "0";
	public String stockUnitCost = "0.0";
	public String branchId = "0";
	public String catId = "0";
	// configuration
	public int empId = 0;
	public String ExeAccess = "";
	public String requestType = "";
	public String configInventoryLocationName = "";
	public String msg = "";
	public String pageNumber = "";
	public int compId = 0;
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

	public Map inventoryReorderLevelService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		configInventoryLocationName = getSession("configInventoryLocationName", session);
		branchAccess = getSession("BranchAccess", session);
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		if (empId != 0) {
			if (!returnPerm(compId + ",emp_reorder_level_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			inputObj = new JSONObject(input);
			output = new HashMap();
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			switch (requestType) {
				case "update" :// update
					if (!returnPerm(compId + ",emp_reorder_level_edit", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					stockLocationId = "0";
					getValues();
					addFields(session, response);
					break;
			}
		}
		return output;
	}

	private void getValues() throws JSONException {
		msg = "";
		if (!inputObj.isNull("stockLocationId")) {
			stockLocationId = CNumeric(inputObj.getString("stockLocationId"));
		}
		if (!inputObj.isNull("stockCurrentQty")) {
			stockCurrentQty = CNumeric(inputObj.getString("stockCurrentQty"));
		}
		if (!inputObj.isNull("stockItemId")) {
			stockItemId = CNumeric(inputObj.getString("stockItemId"));
		}
		if (!inputObj.isNull("stockOnhandvalue")) {
			stockOnhandvalue = CNumeric(inputObj.getString("stockOnhandvalue"));
		}
		if (!inputObj.isNull("stockReorderlevel")) {
			stockReorderlevel = CNumeric(inputObj.getString("stockReorderlevel"));
		}
		if (!inputObj.isNull("stockStockindemand")) {
			stockStockindemand = CNumeric(inputObj.getString("stockStockindemand"));
		}
		if (!inputObj.isNull("stockStockinorder")) {
			stockStockinorder = CNumeric(inputObj.getString("stockStockinorder"));
		}
		if (!inputObj.isNull("stockUnitCost")) {
			stockUnitCost = CNumeric(inputObj.getString("stockUnitCost"));
		}
		if (!inputObj.isNull("branchId")) {
			branchId = CNumeric(inputObj.getString("branchId"));
		}
		if (!inputObj.isNull("catId")) {
			catId = CNumeric(inputObj.getString("catId"));
		}
	}

	private void ValidateFields() {
		msg = "";
		int temp = 0;
		if (branchId.equals("0")) {
			msg += "<br>Select Branch!";
		}
		if (stockLocationId.equals("0")) {
			msg += "<br>Select " + configInventoryLocationName + "!";
		}
		while (temp > 0) {
			if (!isNumeric(stockReorderlevel)) {
				msg += "<br>Stock Reorder Level must be Numeric!";
				break;
			}
			temp--;
		}
	}

	private void addFields(HttpSession session, HttpServletResponse response) throws ParseException {
		ValidateFields();
		if (msg.equals("")) {
			if (!stockId.equals("0")) {
				AxelaInventoryStock axelaInventoryStock = inventoryReOrderRepository.findByStockId(Integer.parseInt(stockId));
				if (!stockLocationId.equals("0") && !stockReorderlevel.equals("0") && stockItemId.equals("0")) {
					axelaInventoryStock.setStockId(Integer.parseInt(stockId));
					axelaInventoryStock.setStockLocationId(Integer.parseInt(stockLocationId));
					axelaInventoryStock.setStockCurrentQty(Double.parseDouble(stockCurrentQty));
					axelaInventoryStock.setStockItemId(Integer.parseInt(stockItemId));
					axelaInventoryStock.setStockReorderlevel(Integer.parseInt(stockReorderlevel));
					axelaInventoryStock.setStockEntryId(empId);
					axelaInventoryStock.setStockEntryDate(getTimeByZone(session));
					String stockId = inventoryReOrderRepository.save(axelaInventoryStock).getStockId() + "";
					if (!stockId.equals("0") && requestType.equals("update")) { // if id = 0 -> add mode else update mode
						output.put("stockId", stockId);
						output.put("successmsg", "Reorder Level Updated Successfully!");
					}
				} else if (!stockLocationId.equals("0") && !stockReorderlevel.equals("0") && !stockItemId.equals("0")) {
					strSearch = "";
					strSearch = " WHERE stock.stockItemId = " + stockItemId + " "
							+ " AND stock.stockLocationId=" + stockLocationId;
					String updateStock = inventoryReorderFilterImp.updateStock(strSearch, Integer.parseInt(stockReorderlevel)) + "";
					if (!updateStock.equals("0") && requestType.equals("update")) { // if id = 0 -> add mode else update mode
						output.put("successmsg", "Reorder Level Updated Successfully!");
					}
				}
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public Map populateData(String input, HttpSession session) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		if (empId != 0) {
			if (!returnPerm(compId + ",emp_reorder_level_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			if (!inputObj.isNull("stockLocationId")) {
				stockLocationId = PadQuotes(CNumeric(inputObj.getString("stockLocationId")));
			}
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			if (!stockLocationId.equals("0")) {
				AxelaInventoryStock axelaInventoryStock = inventoryReOrderRepository.findByStockId(Integer.parseInt(stockLocationId));
				if (axelaInventoryStock != null) {
					HashMap map = new HashMap();
					map.put("stockLocationId", stockLocationId);
					map.put("stockCurrentQty", String.valueOf(axelaInventoryStock.getStockCurrentQty()));
					map.put("stockItemId", String.valueOf(axelaInventoryStock.getStockItemId()));
					map.put("stockOnhandvalue", String.valueOf(axelaInventoryStock.getStockOnhandvalue()));
					map.put("stockReorderlevel", String.valueOf(axelaInventoryStock.getStockReorderlevel()));
					map.put("stockStockindemand", String.valueOf(axelaInventoryStock.getStockStockindemand()));
					map.put("stockStockinorder", String.valueOf(axelaInventoryStock.getStockStockinorder()));
					map.put("stockUnitCost", String.valueOf(axelaInventoryStock.getStockUnitCost()));
					if (axelaInventoryStock.getStockEntryId() != 0) {
						map.put("stockEntryDate", strToShortDate(axelaInventoryStock.getStockEntryDate()));
						map.put("stockEntryId", String.valueOf(axelaInventoryStock.getStockEntryId()));
						map.put("stockEntryBy", empRepository.findEmpName(axelaInventoryStock.getStockEntryId()));
					}
					list.add(map);
					output.put("populateData", list);
				} else {
					output.put("msg", "Invalid!");
				}
			}
		}
		return output;
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		compId = Integer.parseInt(CNumeric(getSession("compId", session)));
		branchAccess = getSession("branchAccess", session);
		String strSearch = "";
		String strOrderBy = "";
		requestType = "";
		if (empId != 0) {
			if (!returnPerm(compId + ",emp_reorder_level_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			page = 0;
			output = new LinkedHashMap<String, String>();
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			PageRequest request = null;
			if (!inputObj.isNull("stockLocationId")) {
				stockLocationId = PadQuotes((inputObj.getString("stockLocationId")));
			}
			if (!inputObj.isNull("catId")) {
				catId = PadQuotes((inputObj.getString("catId")));
			}
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
				orderByField = " axelaInventoryCatPop.catName , item.itemName ";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (!stockLocationId.equals("0")) {
				strSearch += " AND stock.stockLocationId = " + stockLocationId + "";
				branchId = inventoryLocationRepository.getBranchId(Integer.parseInt(stockLocationId)) + "";

			}

			if (!catId.equals("0")) {
				strSearch += " AND item.itemCatId = " + catId + "";
			}

			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += " AND item.itemStock = 1 "
					+ " AND item.itemReorderAuto = 0" + branchAccess + "";
			strOrderBy += " ORDER BY item." + orderByField + " " + orderType + "";
			List<AxelaInventoryItem> resultSet = inventoryReorderFilterImp.findReorderLevel(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			String length = inventoryReorderFilterImp.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Category", "axelaInventoryCatPop.catName", "center"));
			listHeader.add(produceHeaderData("Item", "itemName", "center"));
			listHeader.add(produceHeaderData("Reorder Level", "axelaInventoryStock.stockReorderlevel", "center"));
			listHeader.add(produceHeaderData("Current Qty", "axelaInventoryStock.stockCurrentQty", "center"));
			listHeader.add(produceHeaderData("UOM", "axelaInventoryUom.uomName", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaInventoryItem obj : resultSet) {
				ArrayList<String> paramSubArr = new ArrayList<String>();
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

				// Category
				type.add(true);
				value.add(obj.getCatName());
				paramSubArr.add("inventory-cat-list");
				paramSubArr.add(obj.getCatId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				paramSubArr.clear();
				paramArr.clear();
				type.clear();
				value.clear();

				// Item
				type.add(true);
				if (!obj.getItemCode().equals("")) {
					value.add(String.valueOf(obj.getItemName()) + " (" + String.valueOf(obj.getItemCode()) + ")");
				} else {
					value.add(String.valueOf(obj.getItemName()));
				}
				paramSubArr.add("inventory-item-list");
				paramSubArr.add(obj.getItemId() + "");
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// reorder
				type.add(false);
				value.add(String.valueOf(obj.getStockReorderlevel()) + " (" + String.valueOf(obj.getStockItemId() + ")"));
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// Current Qty
				type.add(false);
				value.add(String.valueOf(obj.getStockCurrentQty()));
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// uom
				type.add(false);
				value.add(String.valueOf(obj.getUomName()));
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// End Body data
				mapData.put("td", listData);
				ArrayList actionParam = new ArrayList();
				actionParam.add("updateReorderlevel");
				actionParam.add(PadQuotes(String.valueOf(obj.getStockLocationId())));
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
		mapBodyData.put("value", "Update Reorderlevel");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "item.*"));
		list.add(buildSmartArr("Location ID", "numeric", "item.axelaInventoryStock.axelaInventoryLocation.locationId"));
		output.put("drSmart", list.toArray());
		return output;
	}

}
