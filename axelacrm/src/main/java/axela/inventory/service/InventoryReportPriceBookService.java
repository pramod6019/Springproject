package axela.inventory.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import axela.inventory.repository.InventoryIndexImpl;
@Service
public class InventoryReportPriceBookService extends Connect {

	@Autowired
	InventoryIndexImpl inventoryIndexImpl;

	private int branchId = 0;
	private String branchAccess = "";
	private String ExeAccess = "";
	private String empAllExe = "";
	public String requestType = "";
	public String pageNumber = "";
	public int empId = 0;
	public String compId = "0";
	public String msg = "";
	public String modelId = "0";
	public String catId = "0";
	public String strSearch = "";
	public String rateclassId = "0";
	public String itemId = "0";

	HashMap output = null;
	JSONObject inputObj = null;
	public Map reportPriceBookService(String input, HttpSession session, HttpServletRequest request) throws JSONException, ParseException {

		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("inputObj==========OpprDashService==========" + inputObj.toString(1));
		}
		strSearch = "";
		requestType = "";
		int franchiseeCount = 0;
		output = new HashMap();
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		// if (empId != 0) {
		if (!inputObj.isNull("requestType")) {
			requestType = PadQuotes(inputObj.getString("requestType"));
		}
		if (requestType.equals("count")) {
			output.put("branchCount", getSession("branchCount", session));
			output.put("franchiseeCount", getSession("franchiseeCount", session));
		} else {
			branchId = Integer.parseInt(CNumeric(getSession("branchId", session)));
			branchAccess = PadQuotes(getSession("BranchAccess", session));
			ExeAccess = PadQuotes(getSession("ExeAccess", session));
			empAllExe = PadQuotes(getSession("empAllExe", session));
			getValues();
			// validateFollowUp();
			if (msg.equals("")) {
				if (!modelId.equals("0")) {
					strSearch += " AND itemModelId = " + modelId + "";
				}
				if (!catId.equals("0")) {
					strSearch += " AND itemCatId = " + catId + "";
				}
				itemPriceDetails(session);
				// preparePieChart();
				// opprCloseSummary();
			} else {
				output.put("errormsg", msg);
			}

			// }
		}
		SOP("output======================" + output);
		return output;

		// inputObj = new JSONObject(input);
		// empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		// compId = CNumeric(getSession("compId", session));
		// String strSearch = "";
		// String strOrderBy = "";
		// if (empId != 0) {
		// validateFields();
		// output = new LinkedHashMap<String, String>();
		// ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
		// List<HashMap> listBody = new ArrayList<HashMap>();
		// List<HashMap> listAction = new ArrayList<HashMap>();
		// ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
		// ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		//
		// if (!inputObj.isNull("itemId")) {
		// itemId = CNumeric((inputObj.getString("itemId")));
		// }
		// if (!inputObj.isNull("rateclassId")) {
		// rateclassId = CNumeric((inputObj.getString("rateclassId")));
		// }
		// if (!inputObj.isNull("modelId")) {
		// modelId = CNumeric((inputObj.getString("modelId")));
		// }
		// if (!inputObj.isNull("catId")) {
		// catId = CNumeric((inputObj.getString("catId")));
		// }
		// if (!modelId.equals("0")) {
		// strSearch += " AND itemModelId = " + modelId + "";
		// }
		// if (!catId.equals("0")) {
		// strSearch += " AND itemCatId = " + catId + "";
		// }
		// SetSession("pricebooksql", strSearch, request);
		// List<AxelaInventoryItem> resultSet = inventoryIndexImpl.findPriceBookReport(strSearch, strOrderBy, compId, rateclassId, itemId);
		// output.put("action", listAction);
		// output.put("tdalign", listBodyAlign);
		// output.put("thead", listHeader);
		// output.put("tbody", listBody);
		// }
		// return output;
	}
	public void getValues() throws JSONException {
		if (!inputObj.isNull("itemId")) {
			itemId = CNumeric((inputObj.getString("itemId")));
		}
		if (!inputObj.isNull("rateclassId")) {
			rateclassId = CNumeric((inputObj.getString("rateclassId")));
		}
		if (!inputObj.isNull("modelId")) {
			modelId = CNumeric((inputObj.getString("modelId")));
		}
		if (!inputObj.isNull("catId")) {
			catId = CNumeric((inputObj.getString("catId")));
		}
		// if (!inputObj.isNull("branchIds")) {
		// if (inputObj.get("branchIds") instanceof JSONArray)
		// branchIds = jsonArrayToString(inputObj.getJSONArray("branchIds"));
		// }
	}

	protected void validateFields() {
		msg = "";
		if (rateclassId.equals("0")) {
			msg = msg + "<br>Select Rate Class!";
		}
	}

	public void itemPriceDetails(HttpSession session) throws ParseException {
		String strOrderBy = "";

		List list = new ArrayList();
		list.add("#");
		list.add("Item Name");
		list.add("Item Code");
		list.add("Description");
		list.add("Variable");
		list.add("Effective");
		list.add("Price");
		list.add("Per");
		list.add("Discount");
		list.add("Tax1");
		list.add("Tax2");
		list.add("Tax3");
		output.put("priceBookHeader", ((ArrayList) list).clone());
		Map map = new LinkedHashMap();
		list = new ArrayList();
		int count = 1;
		List<AxelaInventoryItem> resultSet = inventoryIndexImpl.findPriceBookReport(strSearch, strOrderBy, session, compId, rateclassId, itemId);
		for (AxelaInventoryItem obj : resultSet) {
			SOP("obj==111===" + obj);
			List priceBookList = new ArrayList();
			priceBookList.add(count);
			priceBookList.add(obj.getCatId());
			priceBookList.add(obj.getItemName());
			priceBookList.add(obj.getItemCode());
			priceBookList.add(obj.getPriceDesc());
			if (String.valueOf(obj.getPriceVariable()).equals("1")) {
				priceBookList.add("Yes");
			} else {
				priceBookList.add("No");
			}
			priceBookList.add(obj.getPriceEffectiveFrom());
			priceBookList.add(obj.getPriceAmt());
			priceBookList.add(obj.getUomShortname());
			if (String.valueOf(obj.getPriceDiscType()).equals("1")) {
				priceBookList.add(String.valueOf(obj.getPriceDisc()));
			} else if (String.valueOf(obj.getPriceDiscType()).equals("2")) {
				priceBookList.add(String.valueOf(obj.getPriceDisc()) + "%");
			}
			priceBookList.add(obj.getTaxRate1());
			priceBookList.add(obj.getTaxRate2());
			priceBookList.add(obj.getTaxRate3());
			count++;
			map.put("td", priceBookList);
			list.add(map);
			SOP("newlist========" + list);
		}
		output.put("priceBook", list);

		// if (rs.getString("price_disc_type").equals("1")) {
		// Str.append("<td align=right valign=top>").append(df.format(Double.parseDouble(rs.getString("price_disc")))).append("</td>");
		// } else if (rs.getString("price_disc_type").equals("2")) {
		// Str.append("<td align=right valign=top>").append(df.format(Double.parseDouble(rs.getString("price_disc"))) + "%").append("</td>");
		// }
		// Str.append("<td align=right valign=top>").append(df.format(Double.parseDouble(rs.getString("tax_rate1")))).append("</td>");
		// Str.append("<td align=right valign=top>").append(df.format(Double.parseDouble(rs.getString("tax_rate2")))).append("</td>");
		// Str.append("<td align=right valign=top>").append(df.format(Double.parseDouble(rs.getString("tax_rate3")))).append("</td>");
		// if (rs.getString("price_disc_type").equals("1")) {
		// price = (rs.getDouble("price_amt") - rs.getDouble("price_disc")) + "";
		// } else if (rs.getString("price_disc_type").equals("2")) {
		// price = (rs.getDouble("price_amt") - (rs.getDouble("price_amt") * rs.getDouble("price_disc") / 100)) + "";
		// }
		// totalamount = PopulateTotal(price, CalServiceTax(price, (rs.getDouble("tax_rate1") + rs.getDouble("tax_rate2") + rs.getDouble("tax_rate3")) + ""));
		// Str.append("<td align=right valign=top>").append(df.format(Double.parseDouble(totalamount))).append("</td>");
		// Str.append("</tr>");
		// Str.append("<th data-toggle=\"true\" height=\"20\" align=\"center\"><b>#</b></th>\n");
		// Str.append("<th data-hide=\"phone\"><span class=\"footable-toggle\"></span> <b>ID</b></th>\n");
		// Str.append("<th data-hide=\"phone\"><b>Item Name</b></th>\n");
		// Str.append("<th data-hide=\"phone\"><b>Item Code</b></th>\n");
		// Str.append("<th data-hide=\"phone\"><b>Description</b></th>\n");
		// Str.append("<th data-hide=\"phone\"><b>Variable</b></th>\n");
		// Str.append("<th data-hide=\"phone\"><b>Effective</b></th>\n");
		// Str.append("<th data-hide=\"phone\"><b>Price</b></th>\n");
		// Str.append("<th data-hide=\"phone\"><b>Per</b></th>\n");
		// Str.append("<th data-hide=\"phone\"><b>Discount</b></th>\n");
		// Str.append("<th data-hide=\"phone\"><b>Tax1 %</b></th>\n");
		// Str.append("<th data-hide=\"phone\"><b>Tax2 %</b></th>\n");
		// Str.append("<th data-hide=\"phone\"><b>Tax3 %</b></th>\n");

	}
}
