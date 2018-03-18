package axela.inventory.service;
//shekespeare
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
import axela.inventory.model.AxelaInventoryItemPrice;
import axela.inventory.model.AxelaInventoryItemPriceTran;
import axela.inventory.repository.InventoryItemPriceFilterImpl;
import axela.inventory.repository.InventoryItemPriceRepository;
import axela.inventory.repository.InventoryItemPriceTranRepository;
import axela.inventory.repository.InventoryItemRepository;
import axela.portal.repository.EmpRepository;

@Service
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class InventoryItemPriceService extends Connect {

	@Autowired
	InventoryItemRepository inventoryItemRepository;
	@Autowired
	InventoryItemPriceRepository inventoryItemPriceRepository;
	@Autowired
	InventoryItemPriceFilterImpl inventoryItemPriceFilterImpl;
	@Autowired
	InventoryItemPriceTranRepository inventoryItemPriceTranRepository;
	@Autowired
	EmpRepository empRepository;

	public String msg = "";
	public int page = 0;
	public String perPage = "0";
	public String sort = "Desc";
	public int empId = 0;
	public String field = "", value = "";
	// new price varriable
	public String priceId = "0";
	public Date priceEntryDate = null;
	public String itemId = "0";
	public String priceItemId = "0";
	public String pricetransVariable = "0";
	public String itemName = "";
	public String priceAmt = "0.0";
	public String priceDiscType = "0";
	public String priceDisc = "0.0", priceDesc = "", priceMargin = "0.0";
	public String priceActive = "0";
	public String priceVariable = "0";
	public String priceEffectiveFrom = "";
	public String priceEntryId = "", priceEntryBy = "", priceModifiedId = "0";
	public String priceModifiedBy = "";
	public String priceModifiedDate = "";
	public String priceRateclassId = "";
	public String rateclassType = "";
	public String priceSalesCustomerId = "0";
	// price Trans data
	public String PriceTransPriceId = "0";// to checking for configAddpriceItem
	public String pricetransPriceId = "0";
	public String pricetransItemId = "0";
	public String pricetransAmt = "0.0";
	// + " (pricetransPriceId,"
	// + " pricetransItemId,"
	// + " pricetransAmt)"
	// configuration
	public String configCustomerName = "";
	public String branchId = "";
	public String branchAccess = "", exeAccess = "";
	public String ExeAccess = "";
	public String empFormatDate = "", empFormattime = "", formatdateDatepicker = "";
	public String empFormatdate = "";
	public String effectiveFrom = "";
	public String keyword = "";
	public int length = 0;
	public String pageNumber = "";
	public String property = "";
	public String strSearch = "", StrSql = "";
	public String compBusinesstypeId = "0";
	public String compModuleAccounting = "0";
	public String empRoleId = "0";
	public String configInventoryCurrentStock = "0";
	public String requestType = "";
	public int compId = 0;
	public String perpage = "0";
	public String orderType = "";
	public String orderByField = "";
	public String strOrderBy = "";

	LinkedHashMap output = null;
	JSONObject inputObj = null;

	public Map<String, String> inventoryItemPriceService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		configCustomerName = getSession("configCustomerName", session);
		branchId = CNumeric(getSession("empBranchId", session));
		empFormatdate = getSession("formatdateName", session);
		empFormattime = getSession("formattimeName", session);
		formatdateDatepicker = getSession("formatdateDatepicker", session);
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, String>();
		if (empId != 0) {
			if (!returnPerm(compId + ", emp_item_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			List<Object[]> object = inventoryItemRepository.findInventoryItemConfigFields(empId);
			for (Object[] obj : object) {
				compBusinesstypeId = obj[0].toString();
				compModuleAccounting = obj[1].toString();
				empRoleId = obj[2].toString();
				configInventoryCurrentStock = obj[3].toString();
			}
			if (!priceItemId.equals("0")) {
				itemName = inventoryItemRepository.findByItemCodeDetail(Integer.parseInt(priceItemId));
			}
			switch (requestType) {

				case "add" : // add
					if (!returnPerm(compId + ",emp_item_add", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					priceEntryId = getSession("emp_id", session);
					priceEntryDate = getTimeByZone(session);
					getValues(inputObj);
					addFields(session, response);
					break;

				case "update" :// update
					if (!returnPerm(compId + ",emp_item_edit", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					getValues(inputObj);
					addFields(session, response);
					break;

				case "delete" :// delete
					if (!returnPerm(compId + ",emp_item_delete", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					if (!inputObj.isNull("priceId")) {
						priceId = inputObj.getString("priceId");
					}
					if (!priceId.equals("0")) {
						deleteFields(priceId);
					}
					break;
			}
		}
		return output;
	}
	private void getValues(JSONObject inputObj) throws JSONException {
		if (!inputObj.isNull("priceItemId")) {
			priceItemId = inputObj.getString("priceItemId");
		}
		if (!inputObj.isNull("priceId")) {
			priceId = inputObj.getString("priceId");
			PriceTransPriceId = priceId;
		}
		if (!inputObj.isNull("priceRateclassId")) {
			priceRateclassId = inputObj.getString("priceRateclassId");
		}
		if (!inputObj.isNull("priceAmt")) {
			priceAmt = CNumeric(inputObj.getString("priceAmt"));
		}
		if (!inputObj.isNull("priceMargin")) {
			priceMargin = CNumeric(inputObj.getString("priceMargin"));
		}
		if (!inputObj.isNull("priceActive")) {
			priceActive = inputObj.getString("priceActive");
		}
		if (!inputObj.isNull("rateclassType")) {
			rateclassType = CNumeric(inputObj.getString("rateclassType"));

		}
		if (!inputObj.isNull("priceDiscType")) {
			priceDiscType = inputObj.getString("priceDiscType");
		}
		if (!inputObj.isNull("priceVariable")) {
			priceVariable = inputObj.getString("priceVariable");
		}
		if (!inputObj.isNull("priceDisc")) {
			priceDisc = inputObj.getString("priceDisc");
		}
		if (!inputObj.isNull("priceDesc")) {
			priceDesc = inputObj.getString("priceDesc");
		}
		if (!inputObj.isNull("priceEffectiveFrom")) {
			priceEffectiveFrom = inputObj.getString("priceEffectiveFrom");
		}
		if (!inputObj.isNull("pricetransPriceId")) {
			pricetransPriceId = CNumeric(inputObj.getString("pricetransPriceId"));
		}
		if (!inputObj.isNull("pricetransItemId")) {
			pricetransItemId = CNumeric(inputObj.getString("pricetransItemId"));
		}
		if (!inputObj.isNull("pricetransAmt")) {
			pricetransAmt = CNumeric(inputObj.getString("pricetransAmt"));
		}
	}

	private void validateFields() throws ParseException {
		msg = "";
		if (priceRateclassId.equals("0")) {
			msg += "<br>Select Rate Class!";
		}
		if (priceAmt.equals("0")) {
			msg += "<br>Enter Amount!";
		}
		String strSearch = "";
		if (requestType.equals("update")) {
			strSearch =
					" AND itemPrice.priceEffectiveFrom = '"
							+ priceEffectiveFrom
							+ "'"
							+ " AND itemPrice.priceItemId = "
							+ priceItemId
							+ " AND itemPrice.priceRateclassId = "
							+ priceRateclassId
							+ ""
							+ " AND itemPrice.priceId != "
							+ priceId + "";
		} else if (requestType.equals("add")) {
			strSearch = " AND itemPrice.priceEffectiveFrom = '"
					+ priceEffectiveFrom
					+ "'"
					+ " AND itemPrice.priceRateclassId="
					+ priceRateclassId
					+ "" + " AND itemPrice.priceItemId = " + priceItemId + "";
		}
		if (inventoryItemPriceFilterImpl.findItemPriceDate(strSearch) != 0) {
			msg += "<br>Item Price already updated this Date!";
		}
		if (!priceAmt.equals("") && !isNumeric(priceAmt)) {
			msg += "<br>Amount: Enter Numeric!";
		}
		if (priceDisc.equals("")) {
			msg += "<br>Enter Discount!";
		}
		if (!priceDisc.equals("") && !isNumeric(priceDisc)) {
			msg += "<br>Discount: Enter Numeric!";
		}
		if (!priceDisc.equals("") && isNumeric(priceDisc) && !priceAmt.equals("") && isNumeric(priceAmt) && Double.parseDouble(priceDisc) > Double.parseDouble(priceAmt)) {
			msg += "<br>Discount should be less than Amount!";
		}
		if (!priceDisc.equals("") && isNumeric(priceDisc) && !priceAmt.equals("") && isNumeric(priceAmt)) {
			if (priceDiscType.equals("1")) {
				if (Double.parseDouble(priceDisc) > Double.parseDouble(priceAmt)) {
					msg += "<br>Discount should be less than Amount!";
				}
			}
			if (priceDiscType.equals("2")) {
				if (Double.parseDouble(priceDisc) > 100) {
					msg += "<br>Discount can not be more than 100%!";
				}
			}
		}
		if (!priceEffectiveFrom.equals("")) {
			if (isValidDateFormat(priceEffectiveFrom, empFormatdate)) {
				priceEffectiveFrom = formatDateStr(priceEffectiveFrom, empFormatdate);
				effectiveFrom = formatDate(priceEffectiveFrom, empFormatdate);
			} else {
				effectiveFrom = priceEffectiveFrom;
			}
		} else {
			msg += "<br>Enter Effective From!";
			effectiveFrom = priceEffectiveFrom;
		}
	}

	private void addFields(HttpSession session, HttpServletResponse response) throws ParseException, NumberFormatException, JSONException {
		validateFields();
		AxelaInventoryItemPrice axelaInventoryItemPrice = null;
		if (msg.equals("")) {
			if (!CNumeric(priceId).equals("0")) {
				axelaInventoryItemPrice = inventoryItemPriceFilterImpl.findUpdateDetail(Integer.parseInt(CNumeric(priceId)));
			} else {
				axelaInventoryItemPrice = new AxelaInventoryItemPrice();
			}
			axelaInventoryItemPrice.setPriceRateclassId(Integer.parseInt(priceRateclassId));
			axelaInventoryItemPrice.setPriceEffectiveFrom(stringToDate(priceEffectiveFrom));
			axelaInventoryItemPrice.setPriceItemId(Integer.parseInt(priceItemId));
			axelaInventoryItemPrice.setPriceDesc(priceDesc);
			axelaInventoryItemPrice.setPriceAmt(Double.parseDouble(priceAmt));
			axelaInventoryItemPrice.setPriceDisc(Double.parseDouble(priceDisc));
			axelaInventoryItemPrice.setPriceDiscType(Integer.parseInt(priceDiscType));
			axelaInventoryItemPrice.setPriceMargin(Double.parseDouble(priceMargin));
			axelaInventoryItemPrice.setPriceVariable(priceVariable);
			axelaInventoryItemPrice.setPriceActive(priceActive);

			if (priceId.equals("0") && requestType.equals("add")) {
				axelaInventoryItemPrice.setPriceEntryId(empId);
				axelaInventoryItemPrice.setPriceEntryDate(getTimeByZone(session));
				axelaInventoryItemPrice.setPriceModifiedDate(stringToDate(""));
				axelaInventoryItemPrice.setPriceModifiedId(0);
			} else if (!priceId.equals("0") && requestType.equals("update")) {
				axelaInventoryItemPrice.setPriceModifiedId(empId);
				axelaInventoryItemPrice.setPriceModifiedDate(getTimeByZone(session));
			}
			// AddConfigItemPrice=======
			String strSql = inventoryItemRepository.findItemItemtypeId(Integer.parseInt(priceItemId));
			SOP("strSql=====11111111==" + strSql);
			if (strSql.equals("1")) {
				SOP("strSql=======" + strSql);
				// if (!priceId.equals("0") && inventoryItemRepository.findItemItemtypeId(Integer.parseInt(priceItemId)) == 1) {
				AddConfigItemPrice(inputObj);
			}
			String priceId = inventoryItemPriceRepository.save(axelaInventoryItemPrice).getPriceId() + "";
			if (!priceId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("successmsg", "Price  Added Successfully!");
				output.put("priceId", priceId);
			} else if (!priceId.equals("0") && requestType.equals("update")) {
				output.put("successmsg", "Price Updated Successfully!");
				output.put("priceId", priceId);
			}
		} else {
			output.put("errormsg", msg);
		}
	}

	private void deleteFields(String priceId) {
		inventoryItemPriceRepository.delete(Integer.parseInt(priceId));
		output.put("successmsg", "Price  Deleted Successfully!");
	}

	public Map populateData(String input, HttpSession session) throws JSONException, ParseException {
		output = new LinkedHashMap();
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		if (empId != 0) {
			if (!returnPerm(compId + ", emp_item_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			if (!inputObj.isNull("priceId")) {
				priceId = PadQuotes(CNumeric(inputObj.getString("priceId")));
			}
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			if (!priceId.equals("0")) {

				List<AxelaInventoryItemPrice> obj = inventoryItemPriceFilterImpl.findPopulateData(Integer.parseInt(priceId));
				for (AxelaInventoryItemPrice itemPrice : obj) {
					HashMap map = new LinkedHashMap();
					map.put("priceId", priceId);
					map.put("priceActive", String.valueOf(itemPrice.getPriceActive()));
					map.put("priceAmt", String.valueOf(itemPrice.getPriceAmt()));
					map.put("priceDesc", String.valueOf(itemPrice.getPriceDesc()));
					map.put("priceDisc", String.valueOf(itemPrice.getPriceDisc()));
					map.put("priceDiscType", String.valueOf(itemPrice.getPriceDiscType()));
					map.put("priceEffectiveFrom", strToShortDate(itemPrice.getPriceEffectiveFrom()));
					map.put("priceItemId", String.valueOf(itemPrice.getPriceItemId()));
					map.put("priceMargin", String.valueOf(itemPrice.getPriceMargin()));
					map.put("priceRateclassId", String.valueOf(itemPrice.getPriceRateclassId()));
					map.put("priceVariable", String.valueOf(itemPrice.getPriceVariable()));
					map.put("rateclassType", itemPrice.getRateclassType());
					if (itemPrice.getPriceEntryId() != 0) {
						map.put("priceEntryDate", strToShortDate(itemPrice.getPriceEntryDate()));
						map.put("priceEntryId", String.valueOf(itemPrice.getPriceEntryId()));
						map.put("priceEntryBy", empRepository.findEmpName(itemPrice.getPriceEntryId()));
					}
					if (itemPrice.getPriceModifiedId() != 0) {
						map.put("priceModifiedDate", strToShortDate(itemPrice.getPriceModifiedDate()));
						map.put("priceModifiedId", String.valueOf(itemPrice.getPriceModifiedId()));
						map.put("priceModifiedBy", empRepository.findEmpName(itemPrice.getPriceModifiedId()));
					}
					list.add(map);
				}
				output.put("populateData", list);
			}
		}
		return output;
	}

	public Map populateItemName(String input, HttpSession session) throws JSONException, ParseException {
		output = new LinkedHashMap();
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		if (!inputObj.isNull("itemId")) {
			itemId = PadQuotes(CNumeric(inputObj.getString("itemId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap map = new LinkedHashMap();
		if (!itemId.equals("0")) {
			String obj = inventoryItemRepository.findItemNameAndId(Integer.parseInt(itemId));
			map.put("itemName", obj);
		}
		output.put("populateItemName", map);
		return output;
	}

	public void AddConfigItemPrice(JSONObject inputObj) throws NumberFormatException, JSONException {
		AxelaInventoryItemPriceTran axelaInventoryItemPriceTran = new AxelaInventoryItemPriceTran();
		int configItemCount = 0;
		if (!inputObj.isNull("configItemCount")) {
			configItemCount = Integer.parseInt(CNumeric(PadQuotes(inputObj.getString("configItemCount"))));
		}
		String pricetransItemId = "", pricetransAmt = "";
		if (configItemCount > 0) {
			for (int i = 1; i <= configItemCount; i++) {
				if (!inputObj.isNull("pricetransItemId")) {
					pricetransItemId = CNumeric(PadQuotes(inputObj.getString("pricetransItemId")));
				}
				if (!inputObj.isNull("pricetransAmt")) {
					pricetransAmt = CNumeric(PadQuotes(inputObj.getString("pricetransAmt")));
				}
				axelaInventoryItemPriceTran.setPricetransItemId(Integer.parseInt(pricetransItemId));
				axelaInventoryItemPriceTran.setPricetransPriceId(Integer.parseInt(priceId));
				axelaInventoryItemPriceTran.setPricetransAmt(Double.parseDouble(pricetransAmt));
			}
			inventoryItemPriceTranRepository.save(axelaInventoryItemPriceTran);
		}
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		String strSearch = "";
		String strOrderBy = "";
		if (empId != 0) {
			if (!returnPerm(compId + ",emp_item_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			page = 0;
			output = new LinkedHashMap<String, String>();
			String customerType = "";
			List<AxelaInventoryItemPrice> itemPriceList = null;
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			PageRequest request = null;
			if (!inputObj.isNull("priceItemId")) {
				priceItemId = CNumeric(PadQuotes((inputObj.getString("priceItemId"))));
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
				orderByField = "priceId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			if (!priceItemId.equals("0")) {
				strSearch += " AND itemPrice.priceItemId=" + priceItemId + " ";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strOrderBy = " ORDER BY itemPrice." + orderByField + " " + orderType + "";
			itemPriceList = inventoryItemPriceFilterImpl.findAll(strSearch, strOrderBy, page, Integer.parseInt(CNumeric(perPage)));
			String length = inventoryItemPriceFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Item", "itemName", "center"));
			listHeader.add(produceHeaderData("Class", "rateClassName", "left"));
			listHeader.add(produceHeaderData("Amount", "priceAmount", "left"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align
			for (AxelaInventoryItemPrice obj : itemPriceList) {
				String amt = "", st = "0", cst = "0", vat = "0", active = "";
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
				// Item.
				type.add(true);
				if (obj.getPriceActive().equals("0")) {
					active = "<br /><font color=red>[Inactive]</font>";
				}
				value.add(String.valueOf(obj.getItemName()) + active);
				paramSubArr.add("itemList");
				paramSubArr.add("" + obj.getPriceItemId());
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				paramSubArr.clear();
				paramArr.clear();
				type.clear();
				value.clear();
				// Class.
				type.add(false);
				value.add(String.valueOf(obj.getRateclassName()));
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Amount.
				type.add(false);
				StringBuilder amount = new StringBuilder();
				StringBuilder discount = new StringBuilder();
				StringBuilder total = new StringBuilder();
				amount.append("Amount: ").append(IndFormat(String.valueOf(obj.getPriceAmt()))).append("<br>");
				discount.append("Discount: ").append(IndFormat("" + obj.getPriceDisc()));
				if (obj.getPriceDiscType() == 1) {
					amt = String.valueOf(obj.getPriceAmt() - obj.getPriceDisc());// Double.toString
					amt = String.valueOf(Double.parseDouble(amt) + Double.parseDouble(st) + Double.parseDouble(cst) + Double.parseDouble(vat));
				}
				if (obj.getPriceDiscType() == 2) {
					amt = Double.toString(obj.getPriceAmt() - (obj.getPriceAmt() * obj.getPriceDisc() / 100));
					amt = Double.toString(Double.parseDouble(amt) + Double.parseDouble(st) + Double.parseDouble(cst) + Double.parseDouble(vat));
				}
				if (!amt.equals("")) {
					total.append("Total: ").append(IndFormat(amt));
				}
				if (!amount.equals("0.0") && !discount.equals("0.0") && !total.equals("0.0")) {
					value.add(PadQuotes(String.valueOf(amount)));
					value.add(PadQuotes(String.valueOf(discount)));
					value.add(String.valueOf(total));
				} else {
					value.add(PadQuotes(String.valueOf(0.0)));
					value.add(PadQuotes(String.valueOf(0.0)));
					value.add(PadQuotes(String.valueOf(0.0)));
				}
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// // End Body data
				mapData.put("td", listData);
				ArrayList actionParam = new ArrayList();
				actionParam.add("updatePrice");
				actionParam.add(PadQuotes(String.valueOf(obj.getPriceId())));
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

	public ArrayList<HashMap> produceActionData(ArrayList<String> Param) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Price");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

}
