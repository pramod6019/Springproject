package axela.inventory.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.inventory.model.AxelaInventoryItem;
import axela.inventory.repository.ReportCurrentStockImpl;
@Service
public class ReportCurrentStockService extends Connect {
	@Autowired
	ReportCurrentStockImpl reportCurrentStockImpl;

	public String requestType = "";
	public String strSearch = "";
	public String strOrderBy = "";
	public String msg = "";
	public String branchAccess = "";
	public int empId = 0;
	public int compId = 0;
	public String configInventoryLocationName = "";
	public String compModuleSales = "";
	public String empFormatdate = "";
	public String date = "";
	public String param = "";
	public String fileName = "";
	public String export = "";
	public String branchId = "0";
	public String locationId = "0";
	public String catId = "0";
	public String strHTML = "0";
	public double nettAvailable = 0.0;
	public double shortFall = 0.0;
	public double orderToBePlaced = 0.0;
	public Map output = null;
	public JSONObject inputObj = null;

	public Map reportCurrentStockDash(String input, HttpSession session, HttpServletRequest request) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("inputObj========ticketService==========" + inputObj.toString(1));
		}
		strSearch = "";
		requestType = "";
		empId = Integer.parseInt(getSession("empId", session));
		compId = Integer.parseInt(getSession("compId", session));
		if (empId != 0) {

			if (!inputObj.isNull("requestType")) {
				requestType = PadQuotes(inputObj.getString("requestType"));
			}
			branchAccess = getSession("branchAccess", session);
			configInventoryLocationName = getSession("configInventoryLocationName", session);
			compModuleSales = getSession("compModuleSales", session);
			empFormatdate = getSession("formatdateName", session);
			date = formatDate(String.valueOf(getTimeByZone(session)), empFormatdate);
			getValues(inputObj);
			validateFields();
			if (msg.equals("")) {
				if (param.equals("currentstock")) {
					fileName = "Current Stock Report";
				} else if (param.equals("criticalstock")) {
					fileName = " Critical Stock Report";
				} else {
					fileName = "Reorder Report";
				}

				if (!locationId.equals("0")) {
					strSearch += " AND loc.locationId = " + locationId + "";
				}

				if (!catId.equals("0")) {
					strSearch += " AND item.itemCatId = " + catId + "";
				}

				if (!strSearch.equals("") && !locationId.equals("0")) {
					StockDetails(param, strSearch);
				}

				if (!strSearch.equals("") && export.equals("yes")) {
					StockReorderDetailsExport(param, strSearch);
				}
			} else {
				output.put("errormsg", msg);
			}
		}
		if (AppRun().equals("0")) {
			SOP("inputObj========ticketService==========" + output);
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException, ParseException {
		if (!inputObj.isNull("param")) {
			param = PadQuotes(inputObj.getString("param"));
		}
		if (!inputObj.isNull("export")) {
			export = PadQuotes(inputObj.getString("export"));
		}
		if (!inputObj.isNull("branchId")) {
			branchId = CNumeric(PadQuotes(inputObj.getString("branchId")));
		}
		if (!inputObj.isNull("locationId")) {
			locationId = CNumeric(PadQuotes(inputObj.getString("locationId")));
		}
		if (!inputObj.isNull("catId")) {
			catId = CNumeric(PadQuotes(inputObj.getString("catId")));
		}
	}

	public void validateFields() throws ParseException {
		msg = "";
		if (branchId.equals("0")) {
			msg = "Select Branch!<br>";
		}

		if (locationId.equals("0")) {
			msg += "Select " + configInventoryLocationName + "!<br>";
		}
	}

	private void StockDetails(String param, String strSearch) {
		SOP("param=============" + param);
		int count = 0;
		if (param.equals("criticalstock")) {
			strSearch += " AND  (CASE WHEN ( stock.stockReorderlevel - ( stock.stockCurrentQty + stock.stockStockinorder - stock.stockStockindemand ) ) > stock.stockReorderlevel THEN(stock.stockReorderlevel - ( stock.stockCurrentQty + stock.stockStockinorder - stock.stockStockindemand ) )ELSE stock.stockReorderlevel END) > 0";
		}
		strSearch += branchAccess;
		strOrderBy = " ORDER BY item.itemName";
		int page = 1;
		int perPage = 1000;
		List<AxelaInventoryItem> axelaInventoryItem = reportCurrentStockImpl.reportCurrentStockDetail(strSearch, strOrderBy, page, perPage);
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap map1 = new HashMap();
		for (AxelaInventoryItem obj : axelaInventoryItem) {
			count++;
			HashMap map = new HashMap();
			nettAvailable = obj.getStockCurrentQty() + (obj.getStockStockinorder() - obj.getStockStockindemand());
			shortFall = obj.getStockReorderlevel() - nettAvailable;
			if (shortFall > obj.getStockReorderlevel())
			{
				orderToBePlaced = shortFall;
			} else {
				orderToBePlaced = obj.getStockReorderlevel();
			}
			map.put("count", count);
			map.put("itemId", String.valueOf(obj.getItemId()));
			map.put("itemName", String.valueOf(obj.getItemName()));
			map.put("itemCode", String.valueOf(obj.getItemCode()));
			map.put("uomName", String.valueOf(obj.getUomName()));
			map.put("stockCurrentQty", String.valueOf(obj.getStockCurrentQty()));
			map.put("stockStockinorder", String.valueOf(obj.getStockStockinorder()));
			map.put("stockStockindemand", String.valueOf(obj.getStockStockindemand()));
			map.put("nettavailable", String.valueOf(nettAvailable));
			map.put("stockUnitCost", String.valueOf(obj.getStockUnitCost()));
			map.put("stockOnhandvalue", String.valueOf(obj.getStockOnhandvalue()));
			map.put("stockReorderlevel", String.valueOf(obj.getStockReorderlevel()));
			map.put("shortfall", String.valueOf(shortFall));
			map.put("itemEoq", String.valueOf(obj.getItemEoq()));
			map.put("orderToBePlaced", String.valueOf(orderToBePlaced));
			list.add(map);
		}
		map1.put("pageIndex", page + "");
		map1.put("pageSize", perPage + "");
		output.put("metaData", map1);

		output.put("currentStockDetails", list);

	}

	private void StockReorderDetailsExport(String param2, String strSearch2) {
		// TODO Auto-generated method stub

	}
}
