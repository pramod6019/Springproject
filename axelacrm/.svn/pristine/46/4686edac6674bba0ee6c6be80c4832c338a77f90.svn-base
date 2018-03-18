package axela.inventory.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import axela.config.Connect;
import axela.inventory.model.AxelaInventoryItem;
import axela.inventory.model.AxelaInventoryItemPrice;
import axela.inventory.repository.InventoryBinItemRepository;
import axela.inventory.repository.InventoryFilterImp;
import axela.inventory.repository.InventoryItemOptionRepository;
import axela.inventory.repository.InventoryItemPriceRepository;
import axela.inventory.repository.InventoryItemRepository;
import axela.portal.model.AxelaEmp;
import axela.portal.repository.AccVoucherTranRepository;
import axela.portal.repository.EmpRepository;

@Service
public class InventoryItemService extends Connect {

	@Autowired
	InventoryItemRepository inventoryItemRepository;

	@Autowired
	InventoryItemPriceRepository inventoryItemPriceRepository;

	@Autowired
	AccVoucherTranRepository accVoucherTransRepository;

	@Autowired
	InventoryItemOptionRepository inventoryItemOptionRepository;

	@Autowired
	InventoryBinItemRepository inventoryBinItemRepository;

	@Autowired
	InventoryFilterImp inventoryFilterImp;

	@Autowired
	EmpRepository empRepository;

	public String updateB = "";
	public String StrSql = "";
	public String StrJoin = "";
	public int totalCount = 0;
	public int compId = 0;
	public String entryDate = "";
	public String modifiedDate = "";
	public int empId = 0;
	public String branchAccess = "";
	public String exeAccess = "";
	public String QueryString = "";
	public String empFormatDate = "";
	public String formatdate_datepicker = "";
	public String emp_formattime = "";
	public String voucher_rateclass_id = "0";
	// / Item variable
	public String itemId = "0";
	public String itemName = "";
	public String itemCode = "";
	public String itemImg = " ";
	public String itemCatId = "0";
	public String itemSmallDesc = "";
	public String itemBigDesc = "";
	public String itemPerishable = "";
	public String itemStock = "";
	public String itemReorderAuto = "0";
	public String auto_reorder_display = "";
	public String itemReorderLeaddays = "0";
	public String reorder_leaddays_display = "";
	public String itemBatchno = "0";
	public String itemSerial = "0";
	public String itemItemtypeId = "0";
	public String itemLoyaltycardId = "0";
	public String itemFeatured = "";
	public static String loyaltycardId = "0";
	public String itemDurtype = "0";
	public String itemDurcount = "0";
	public String itemUomId = "0";
	public String itemEoq = "0";
	public String itemActive = " ";
	public String itemNotes = "";
	public String itemEntryDate = "";
	public String itemEntryId = "0";
	public String itemEntryBy = "";
	public String itemModifiedBy = "";
	public String itemTicketqueueId = "0";
	public String itemCosttypeId = "0";
	public String itemModelId = "0";
	public String opprItemId = "0";
	public String salescatId = "0";
	// / sales price
	private String itemSalesMaxDisc = "0.0";
	private String itemSalesDiscType = "";
	public String itemSalesRateClass = "0";
	public String itemSalesLedgerId = "1";
	public String itemSalesdiscountLedgerId = "2";
	public String itemSalestax1LedgerId = "0";
	public String itemSalestax2LedgerId = "0";
	public String itemSalestax3LedgerId = "0";
	public String itemSalestax2Aftertax1 = "0", itemSalestax3Aftertax2 = "0";
	public String itemSalesPriceAmt = "0";
	public String salesPriceDiscType = "0";
	// purchase price
	private String itemPurchaseMaxDisc = "0.0";
	public String itemPurchaseRateClass = "0";
	public String itemPurchaseLedgerId = "5";
	public String itemPurchasediscountLedgerId = "6";
	public String itemPurchasetax1LedgerId = "0";
	public String itemPurchasetax2LedgerId = "0";
	public String itemPurchasetax3LedgerId = "0";
	public String itemPurchasetax2Aftertax1 = "0", itemPurchasetax3Aftertax2 = "0";
	public String itemPurchasePriceAmt = "0";
	public String purchasePriceDiscType = "0";
	public String compModulePos = "0";
	// / config variable
	public String configSalesOpprName = "", configCustomerName = "";
	public String requestType = "", property = "";
	public String msg = "", value = "";
	public String pageNumber = "";
	private String orderByField = "";
	private String orderType = "";
	// new
	public String itemLaundryProcessId = "";
	public String itemModifiedId = "";
	public String itemModifiedDate = "";
	public String itemPic = "";
	private Date timeZone = null;
	// other global varriable
	String field = "", perpage = "", perPage = "0", sort = "", strSearch = "";
	String itemNonstock = " ", priceVariable = "0";
	public int page = 0;

	LinkedHashMap output = null;
	JSONObject inputObj = null;

	public Map<String, String> inventoryItemService(String input, HttpSession session, HttpServletResponse response) throws Exception {
		itemId = "0";
		requestType = "";
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		compId = Integer.parseInt(CNumeric(getSession("compId", session)));
		if (empId != 0) {
			if (!returnPerm(",emp_item_access, emp_sales_item_access, emp_pos_item_access,"
					+ " emp_invoice_item_access, emp_prod_item_access, emp_service_item_access,", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			timeZone = getTimeByZone(session);
			switch (requestType) {
				case "add" : // add
					if (!returnPerm(", emp_item_add, emp_sales_item_add, emp_pos_item_add,"
							+ " emp_invoice_item_add, emp_prod_item_add, emp_service_item_add", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					itemId = "0";
					getValues(inputObj);
					addFields(session, response);
					break;

				case "update" :// update
					if (!returnPerm(",emp_item_edit, emp_sales_item_edit, emp_pos_item_edit,"
							+ " emp_invoice_item_edit, emp_prod_item_edit, emp_service_item_edit", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					itemId = "0";
					getValues(inputObj);
					addFields(session, response);
					break;

				case "delete" :// delete
					if (!returnPerm(",emp_item_delete, emp_sales_item_delete, emp_pos_item_delete,"
							+ " emp_invoice_item_delete, emp_prod_item_delete, emp_service_item_delete", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					if (!inputObj.isNull("itemId")) {
						itemId = inputObj.getString("itemId");
					}
					if (!itemId.equals("0")) {
						deleteFields(itemId, response);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("itemId")) {
			itemId = CNumeric(inputObj.getString("itemId"));
		}
		if (!inputObj.isNull("itemName")) {
			itemName = inputObj.getString("itemName");
		}
		if (!inputObj.isNull("itemCode")) {
			itemCode = inputObj.getString("itemCode");
		}
		if (!inputObj.isNull("itemCatId")) {
			itemCatId = CNumeric(inputObj.getString("itemCatId"));
		}
		if (!inputObj.isNull("itemItemtypeId")) {
			itemItemtypeId = CNumeric(inputObj.getString("itemItemtypeId"));
		}
		if (!inputObj.isNull("itemModelId")) {
			itemModelId = CNumeric(inputObj.getString("itemModelId"));
		}
		if (!inputObj.isNull("itemSmallDesc")) {
			itemSmallDesc = inputObj.getString("itemSmallDesc");
		}
		if (!inputObj.isNull("itemBigDesc")) {
			itemBigDesc = inputObj.getString("itemBigDesc");
		}
		if (!inputObj.isNull("itemPerishable")) {
			itemPerishable = inputObj.getString("itemPerishable");
		}
		if (!inputObj.isNull("itemTrackStock")) {
			itemStock = inputObj.getString("itemTrackStock");
		}
		if (!inputObj.isNull("itemReorderLevels")) {
			itemReorderAuto = CNumeric(inputObj.getString("itemReorderLevels"));
		}
		if (!inputObj.isNull("itemReorderLeaddays")) {
			itemReorderLeaddays = inputObj.getString("itemReorderLeaddays");
		}
		if (requestType.equals("add")) {
			if (!inputObj.isNull("itemLoyaltycardId")) {
				itemLoyaltycardId = CNumeric(inputObj.getString("itemLoyaltycardId"));
			}
		} else {
			itemLoyaltycardId = loyaltycardId;
		}
		if (!inputObj.isNull("itemDurtype")) {
			itemDurtype = CNumeric(inputObj.getString("itemDurtype"));
		}
		if (!inputObj.isNull("itemDurcount")) {
			itemDurcount = CNumeric(inputObj.getString("itemDurcount"));
		}
		if (!inputObj.isNull("itemBatchno")) {
			itemBatchno = CNumeric(inputObj.getString("itemBatchno"));
		}
		if (!inputObj.isNull("itemSerial")) {
			itemSerial = CNumeric(inputObj.getString("itemSerial"));
		}
		if (!inputObj.isNull("itemTicketqueueId")) {
			itemTicketqueueId = CNumeric(inputObj.getString("itemTicketqueueId"));
		}
		if (!inputObj.isNull("itemTicketqueueId")) {
			itemTicketqueueId = CNumeric(inputObj.getString("itemTicketqueueId"));
		}
		if (!inputObj.isNull("itemCosttypeId")) {
			itemCosttypeId = CNumeric(inputObj.getString("itemCosttypeId"));
		}
		if (!inputObj.isNull("itemUomId")) {
			itemUomId = CNumeric(inputObj.getString("itemUomId"));
		}
		if (!inputObj.isNull("itemEoq")) {
			itemEoq = CNumeric(inputObj.getString("itemEoq"));
		}
		if (!inputObj.isNull("itemActive")) {
			itemActive = CNumeric(inputObj.getString("itemActive"));
		}
		if (!inputObj.isNull("itemNotes")) {
			itemNotes = inputObj.getString("itemNotes");
		}
		if (itemNotes.length() > 5000) {
			itemNotes = itemNotes.substring(0, 4999);
		}
		// Start Sales Price
		if (!inputObj.isNull("itemSalesRateClass")) {
			itemSalesRateClass = CNumeric(inputObj.getString("itemSalesRateClass"));
		}
		if (!inputObj.isNull("itemSalesMaxDisc")) {
			itemSalesMaxDisc = CNumeric(inputObj.getString("itemSalesMaxDisc"));
		}
		if (!inputObj.isNull("itemSalesDiscType")) {
			itemSalesDiscType = CNumeric(inputObj.getString("itemSalesDiscType"));
		}
		if (!inputObj.isNull("itemSalesPriceAmt")) {
			itemSalesPriceAmt = inputObj.getString("itemSalesPriceAmt");
		}
		if (!inputObj.isNull("itemSalesLedgerId")) {
			itemSalesLedgerId = CNumeric(inputObj.getString("itemSalesLedgerId"));
		}
		if (!inputObj.isNull("itemSalesdiscountLedgerId")) {
			itemSalesdiscountLedgerId = CNumeric(inputObj.getString("itemSalesdiscountLedgerId"));
		}
		if (!inputObj.isNull("itemSalestax1LedgerId")) {
			itemSalestax1LedgerId = CNumeric(inputObj.getString("itemSalestax1LedgerId"));
		}
		if (!inputObj.isNull("itemSalestax2LedgerId")) {
			itemSalestax2LedgerId = CNumeric(inputObj.getString("itemSalestax2LedgerId"));
		}
		if (!inputObj.isNull("itemSalestax2Aftertax1")) {
			itemSalestax2Aftertax1 = CNumeric(inputObj.getString("itemSalestax2Aftertax1"));
		}
		if (!inputObj.isNull("itemSalestax3LedgerId")) {
			itemSalestax3LedgerId = CNumeric(inputObj.getString("itemSalestax3LedgerId"));
		}
		if (!inputObj.isNull("itemSalestax3Aftertax2")) {
			itemSalestax3Aftertax2 = CNumeric(inputObj.getString("itemSalestax3Aftertax2"));
		}
		if (!inputObj.isNull("itemSalesPriceDiscType")) {
			salesPriceDiscType = inputObj.getString("salesPriceDiscType");
		}
		// end Sales Price

		// Start
		if (!inputObj.isNull("itemPurchaseRateClass")) {
			itemPurchaseRateClass = CNumeric(inputObj.getString("itemPurchaseRateClass"));
		}
		if (!inputObj.isNull("itemPurchaseMaxDisc")) {
			itemPurchaseMaxDisc = CNumeric(inputObj.getString("itemPurchaseMaxDisc"));
		}
		if (!inputObj.isNull("itemPurchasePriceAmt")) {
			itemPurchasePriceAmt = inputObj.getString("itemPurchasePriceAmt");
		}
		if (!inputObj.isNull("itemPurchaseLedgerId")) {
			itemPurchaseLedgerId = CNumeric(inputObj.getString("itemPurchaseLedgerId"));
		}
		if (!inputObj.isNull("itemPurchasediscountLedgerId")) {
			itemPurchasediscountLedgerId = CNumeric(inputObj.getString("itemPurchasediscountLedgerId"));
		}
		if (!inputObj.isNull("itemPurchasetax1LedgerId")) {
			itemPurchasetax1LedgerId = CNumeric(inputObj.getString("itemPurchasetax1LedgerId"));
		}
		if (!inputObj.isNull("itemPurchasetax2LedgerId")) {
			itemPurchasetax2LedgerId = CNumeric(inputObj.getString("itemPurchasetax2LedgerId"));
		}
		if (!inputObj.isNull("itemPurchasetax2Aftertax1")) {
			itemPurchasetax2Aftertax1 = CheckBoxValue(inputObj.getString("itemPurchasetax2Aftertax1"));
		}
		if (!inputObj.isNull("itemPurchasetax3LedgerId")) {
			itemPurchasetax3LedgerId = CNumeric(inputObj.getString("itemPurchasetax3LedgerId"));
		}
		if (!inputObj.isNull("itemPurchasetax3Aftertax2")) {
			itemPurchasetax3Aftertax2 = CNumeric(inputObj.getString("itemPurchasetax3Aftertax2"));
		}
		if (!inputObj.isNull("purchasePriceDiscType")) {
			purchasePriceDiscType = inputObj.getString("purchasePriceDiscType");
		}
		if (!inputObj.isNull("priceVariable")) {
			priceVariable = inputObj.getString("priceVariable");
		}
	}

	public void validateFields() throws Exception {
		List<AxelaInventoryItem> obj = new ArrayList<AxelaInventoryItem>();
		List<AxelaInventoryItem> obj2 = new ArrayList<AxelaInventoryItem>();;
		msg = "";
		if (itemName.equals("")) {
			msg += "<br>Enter Name!";
		} else {
			if (requestType.equals("add")) {
				obj = inventoryItemRepository.findItemName(itemName);
			} else if (requestType.equals("update")) {
				obj = inventoryItemRepository.findItemName(Integer.parseInt(itemId), itemName);
			}
			if (!obj.isEmpty()) {
				msg += "<br>Similar Item Name found!";
			}
		}
		if (!itemCode.equals("")) {
			if (requestType.equals("add")) {
				obj2 = inventoryItemRepository.findByItemCode(itemCode);
			} else if (requestType.equals("update")) {
				obj2 = inventoryItemRepository.findItemCode(Integer.parseInt(itemId), itemCode);
			}
			if (!obj2.isEmpty()) {
				msg += "<br>Similar Item Code found!";
			}
		}
		if (itemCatId.equals("0")) {
			msg += "<br>Select Category!";
		}
		if (itemItemtypeId.equals("0")) {
			msg += "<br>Select Type!";
		}
		if (itemUomId.equals("0")) {
			msg += "<br>Select Unit of Measurement!";
		}
		if (itemLoyaltycardId.equals("1")) {
			if (itemDurcount.equals("0")) {
				msg += "<br>Duration should be greater than 0!";
			}
			if (itemDurtype.equals("0")) {
				msg += "<br>Select Duration!";
			}
		}
		if (!itemEoq.equals("") && !isNumeric(itemEoq)
				&& itemStock.equals("0")) {
			msg += "<br>EOQ: Enter Numeric!";
		}
		if (itemSmallDesc.length() > 255) {
			itemSmallDesc = itemSmallDesc.substring(0, 254);
		}
		if (itemBigDesc.length() > 2000) {
			itemBigDesc = itemBigDesc.substring(0, 1999);
		}
		if (itemNotes.length() > 8000) {
			itemNotes = itemNotes.substring(0, 7999);
		}
		if (requestType.equals("add")) {
			if (!itemSalesRateClass.equals("0")) {
				if (itemSalesLedgerId.equals("0")) {
					msg += "<br>Select Sales Ledger!";
				}
				if (itemSalesdiscountLedgerId.equals("0")) {
					msg += "<br>Select Sales Discount Ledger!";
				}
			}
			if (!itemSalestax1LedgerId.equals("0")
					&& !itemSalestax2LedgerId.equals("0")) {
				if (itemSalestax2LedgerId.equals(itemSalestax1LedgerId)
						|| itemSalestax3LedgerId.equals(itemSalestax1LedgerId)
						|| itemSalestax3LedgerId.equals(itemSalestax2LedgerId)) {
					msg += "<br>Similer Sales Tax Found!";
				}
			}
			if (!itemPurchaseRateClass.equals("0")) {
				if (itemPurchaseLedgerId.equals("0")) {
					msg += "<br>Select Purchase Ledger!";
				}
				if (itemPurchasediscountLedgerId.equals("0")) {
					msg += "<br>Select Purchase Discount Ledger!";
				}
			}
			if (!itemPurchasetax1LedgerId.equals("0")
					&& !itemPurchasetax2LedgerId.equals("0")) {

				if (itemPurchasetax2LedgerId.equals(itemPurchasetax1LedgerId)
						|| itemPurchasetax3LedgerId.equals(itemPurchasetax1LedgerId)
						|| itemPurchasetax3LedgerId.equals(itemPurchasetax2LedgerId)) {
					msg += "<br>Similer Purchase Tax Found!";
				}
			}
		}
		if (itemStock.equals("0") && itemReorderAuto.equals("1")
				&& itemReorderLeaddays.equals("0")) {
			msg += "<br>Enter Reorder Lead Days!";
		}
	}

	@Transactional
	public void addFields(HttpSession session, HttpServletResponse response) throws Exception {
		validateFields();
		AxelaInventoryItem axelaInventoryItem = new AxelaInventoryItem();
		AxelaInventoryItemPrice inventoryItemPrice = new AxelaInventoryItemPrice();
		if (msg.equals("")) {
			// Start Item add & update
			if (!itemId.equals("0")) {
				axelaInventoryItem = inventoryItemRepository.findByItemIdDetail(Integer.parseInt(CNumeric(itemId)));
			}
			else {
				axelaInventoryItem = new AxelaInventoryItem();
			}
			if (itemStock.equals("1")) {
				itemEoq = "0";
			}
			if (itemSerial.equals("1") && itemStock.equals("1")) {
				itemTicketqueueId = "0";
			}
			axelaInventoryItem.setItemId(Integer.parseInt(itemId));
			axelaInventoryItem.setItemName(itemName);
			axelaInventoryItem.setItemCode(itemCode);
			axelaInventoryItem.setItemImg(itemImg);
			axelaInventoryItem.setItemCatId(Integer.parseInt(itemCatId));
			axelaInventoryItem.setItemItemtypeId(Integer.parseInt(itemItemtypeId));
			axelaInventoryItem.setItemModelId(Integer.parseInt(itemModelId));
			axelaInventoryItem.setItemSmallDesc(itemSmallDesc);
			axelaInventoryItem.setItemBigDesc(itemBigDesc);
			axelaInventoryItem.setItemPerishable(itemPerishable);
			axelaInventoryItem.setItemNonstock(itemNonstock);
			axelaInventoryItem.setItemStock(itemStock);
			axelaInventoryItem.setItemReorderAuto(itemReorderAuto);
			axelaInventoryItem.setItemReorderLeaddays(Integer.parseInt(itemReorderLeaddays));
			axelaInventoryItem.setItemLoyaltycardId(Integer.parseInt(itemLoyaltycardId));
			axelaInventoryItem.setItemDurtype(Integer.parseInt(itemDurtype));
			axelaInventoryItem.setItemDurcount(Integer.parseInt((itemDurcount)));
			axelaInventoryItem.setItemBatchno(itemBatchno);
			axelaInventoryItem.setItemSerial(itemSerial);
			axelaInventoryItem.setItemCosttypeId(Integer.parseInt(itemCosttypeId));
			axelaInventoryItem.setItemUomId(Integer.parseInt(itemUomId));
			axelaInventoryItem.setItemEoq(Integer.parseInt(itemEoq));
			axelaInventoryItem.setItemSalesLedgerId(Integer.parseInt(itemSalesLedgerId));
			axelaInventoryItem.setItemSalesdiscountLedgerId(Integer.parseInt(itemSalesdiscountLedgerId));
			axelaInventoryItem.setItemSalestax1LedgerId(Integer.parseInt(itemSalestax1LedgerId));
			axelaInventoryItem.setItemSalestax2LedgerId(Integer.parseInt(itemSalestax2LedgerId));
			axelaInventoryItem.setItemSalestax2Aftertax1(Integer.parseInt(itemSalestax2Aftertax1));
			axelaInventoryItem.setItemSalestax3LedgerId(Integer.parseInt(itemSalestax3LedgerId));
			axelaInventoryItem.setItemSalestax3Aftertax2(Integer.parseInt(itemSalestax3Aftertax2));
			axelaInventoryItem.setItemPurchaseLedgerId(Integer.parseInt(itemPurchaseLedgerId));
			axelaInventoryItem.setItemPurchasediscountLedgerId(Integer.parseInt(itemPurchasediscountLedgerId));
			axelaInventoryItem.setItemPurchasetax1LedgerId(Integer.parseInt(itemPurchasetax1LedgerId));
			axelaInventoryItem.setItemPurchasetax2LedgerId(Integer.parseInt(itemPurchasetax2LedgerId));
			axelaInventoryItem.setItemPurchasetax2Aftertax1(Integer.parseInt(itemPurchasetax2Aftertax1));
			axelaInventoryItem.setItemPurchasetax2LedgerId(Integer.parseInt(itemPurchasetax3LedgerId));
			axelaInventoryItem.setItemPurchasetax3Aftertax2(Integer.parseInt(itemPurchasetax3Aftertax2));
			axelaInventoryItem.setItemFeatured("");
			axelaInventoryItem.setItemActive(itemActive);
			axelaInventoryItem.setItemNotes(itemNotes);
			if (itemId.equals("0") && requestType.equals("add")) {
				axelaInventoryItem.setItemEntryId(empId);
				axelaInventoryItem.setItemEntryDate(timeZone);
				axelaInventoryItem.setItemModifiedId(0);
			} else if (!itemId.equals("0") && requestType.equals("update")) {
				axelaInventoryItem.setItemModifiedId(empId);
				axelaInventoryItem.setItemModifiedDate(timeZone);
			}
			itemId = inventoryItemRepository.save(axelaInventoryItem).getItemId() + "";
			// end Item add & update
			// Start Item Price add
			if (!itemId.equals("0") && requestType.equals("add")) {
				if (!itemSalesRateClass.equals("0") && !itemSalesLedgerId.equals("0")) {
					inventoryItemPrice.setPriceRateclassId(Integer.parseInt(CNumeric(itemSalesRateClass)));
					inventoryItemPrice.setPriceItemId(Integer.parseInt(itemId));
					inventoryItemPrice.setPriceAmt(Integer.parseInt(CNumeric(itemSalesPriceAmt)));
					inventoryItemPrice.setPriceDisc(Double.parseDouble(itemSalesMaxDisc));
					inventoryItemPrice.setPriceSalesCustomerId(Integer.parseInt(itemSalesLedgerId));
					inventoryItemPrice.setPriceDiscount1CustomerId(Integer.parseInt(itemSalesdiscountLedgerId));
					inventoryItemPrice.setPriceDiscType(Short.parseShort(salesPriceDiscType));
					inventoryItemPrice.setPriceVariable(priceVariable);
					inventoryItemPrice.setPriceEffectiveFrom(timeZone);
					inventoryItemPrice.setPriceActive("1");
					inventoryItemPrice.setPriceEntryId(empId);
					inventoryItemPrice.setPriceDesc(itemNotes);
					inventoryItemPrice.setPriceEntryDate(timeZone);
					String ItemPriceDb = inventoryItemPriceRepository.save(inventoryItemPrice).getPriceId() + "";
				}
				// end Item Price add
				// Start Item purchase price
				if (!itemPurchaseRateClass.equals("0") && !itemPurchaseLedgerId.equals("0")) {
					inventoryItemPrice = new AxelaInventoryItemPrice();
					inventoryItemPrice.setPriceRateclassId(Integer.parseInt(CNumeric(itemPurchaseRateClass)));
					inventoryItemPrice.setPriceItemId(Integer.parseInt(itemId));
					inventoryItemPrice.setPriceAmt(Integer.parseInt(CNumeric(itemPurchasePriceAmt)));
					inventoryItemPrice.setPriceDisc(Double.parseDouble(itemPurchaseMaxDisc));
					inventoryItemPrice.setPriceSalesCustomerId(Integer.parseInt(itemPurchaseLedgerId));
					inventoryItemPrice.setPriceDiscount1CustomerId(Integer.parseInt(itemPurchasediscountLedgerId));
					inventoryItemPrice.setPriceDiscType(Short.parseShort(purchasePriceDiscType));
					inventoryItemPrice.setPriceVariable(priceVariable);
					inventoryItemPrice.setPriceEffectiveFrom(timeZone);
					inventoryItemPrice.setPriceActive("1");
					inventoryItemPrice.setPriceDesc(itemNotes);
					inventoryItemPrice.setPriceEntryId(Integer.parseInt(CNumeric(itemEntryId)));
					inventoryItemPrice.setPriceEntryDate(timeZone);
					inventoryItemPrice.setPriceModifiedDate(timeZone);
					inventoryItemPriceRepository.save(inventoryItemPrice);
				}
				// end Item purchase price
			}
			if (!itemId.equals("0") && requestType.equals("add")) {
				output.put("successmsg", "Item Added Successfully!");
				output.put("itemId", itemId);
			} else if (!itemId.equals("0") && requestType.equals("update")) {
				output.put("itemId", itemId);
				output.put("successmsg", "Item Updated Successfully!");
			}
		} else {
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String itemId, HttpServletResponse response) {
		msg = "";

		int accVoucherTrans1 = accVoucherTransRepository.findByvouchertransItemId(Integer.parseInt(itemId));
		if (accVoucherTrans1 != 0) {
			msg += "<br>Item is associated with Voucher!";
		}

		int inventoryItemOption = inventoryItemOptionRepository.findByOptionItemId(Integer.parseInt(itemId));
		if (inventoryItemOption != 0) {
			msg += "<br>Item is configured for an Item!";
		}
		int axelaInventoryBinItem = inventoryBinItemRepository.findBybinitemItemId(Integer.parseInt(itemId));
		if (axelaInventoryBinItem != 0) {
			msg += "<br>Item is associated with Bin Item!";
		}
		// Delete records
		if (msg.equals("")) {
			inventoryItemPriceRepository.deleteByItemId(Integer.parseInt(CNumeric(itemId)));
			inventoryItemRepository.delete(Integer.parseInt(CNumeric(itemId)));
			output.put("successmsg", "Item Deleted Successfully!");
		} else {
			response.setStatus(400);
			output.put("errormsg", msg);
		}
	}

	public Map inventoryPopulateFields(@RequestBody String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		output = new LinkedHashMap();
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		if (empId != 0) {
			if (!returnPerm(compId + ",emp_item_access, emp_sales_item_access, emp_pos_item_access, emp_invoice_item_access, emp_prod_item_access, emp_service_item_access,", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			AxelaEmp emp = null;
			HashMap map = new HashMap();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			if (!inputObj.isNull("itemId")) {
				itemId = inputObj.getString("itemId");
			}
			if (!itemId.equals("0")) {
				AxelaInventoryItem axelaInventoryItem = inventoryItemRepository.findByItemIdDetail(Integer.parseInt(itemId));

				if (axelaInventoryItem != null) {
					map.put("itemId", itemId);
					map.put("itemName", axelaInventoryItem.getItemName());
					map.put("itemCode", axelaInventoryItem.getItemCode());
					map.put("itemCatId", "" + axelaInventoryItem.getItemCatId());
					map.put("itemItemtypeId", "" + axelaInventoryItem.getItemItemtypeId());
					map.put("itemModelId", "" + axelaInventoryItem.getItemModelId());
					map.put("itemSmallDesc", axelaInventoryItem.getItemSmallDesc());
					map.put("itemBigDesc", axelaInventoryItem.getItemBigDesc());
					map.put("itemUomId", "" + axelaInventoryItem.getItemUomId());
					map.put("itemEoq", "" + axelaInventoryItem.getItemEoq());
					map.put("itemPerishable", axelaInventoryItem.getItemPerishable());
					map.put("itemStock", axelaInventoryItem.getItemStock());
					map.put("itemReorderAuto", axelaInventoryItem.getItemReorderAuto());
					map.put("itemReorderLeaddays", "" + axelaInventoryItem.getItemReorderLeaddays());
					map.put("itemSalesLedgerId", "" + axelaInventoryItem.getItemSalesLedgerId());
					map.put("itemSalesdiscountLedgerId", "" + axelaInventoryItem.getItemSalesdiscountLedgerId());
					map.put("itemSalestax1LedgerId", "" + axelaInventoryItem.getItemSalestax1LedgerId());
					map.put("itemSalestax2LedgerId", "" + axelaInventoryItem.getItemSalestax2LedgerId());
					map.put("itemSalestax2Aftertax1", "" + axelaInventoryItem.getItemSalestax2Aftertax1());
					map.put("itemSalestax3LedgerId", "" + axelaInventoryItem.getItemSalestax3LedgerId());
					map.put("itemSalestax3Aftertax2", "" + axelaInventoryItem.getItemSalestax3Aftertax2());
					map.put("itemPurchaseLedgerId", "" + axelaInventoryItem.getItemPurchaseLedgerId());
					map.put("itemPurchasediscountLedgerId", "" + axelaInventoryItem.getItemPurchasediscountLedgerId());
					map.put("itemPurchasetax1LedgerId", "" + axelaInventoryItem.getItemPurchasetax1LedgerId());
					map.put("itemPurchasetax2LedgerId", "" + axelaInventoryItem.getItemPurchasetax2LedgerId());
					map.put("itemPurchasetax2Aftertax1", "" + axelaInventoryItem.getItemPurchasetax2Aftertax1());
					map.put("itemPurchasetax3LedgerId", "" + axelaInventoryItem.getItemPurchasetax3Aftertax2());
					map.put("itemLoyaltycardId", "" + axelaInventoryItem.getItemLoyaltycardId());
					map.put("loyaltycardId", "" + axelaInventoryItem.getItemLoyaltycardId());
					map.put("itemDurtype", "" + axelaInventoryItem.getItemDurtype());
					map.put("itemDurcount", "" + axelaInventoryItem.getItemDurcount());
					map.put("itemBatchno", "" + axelaInventoryItem.getItemBatchno());
					map.put("itemSerial", "" + axelaInventoryItem.getItemSerial());
					map.put("itemTicketqueueId", "" + axelaInventoryItem.getItemTicketqueueId());
					map.put("itemCosttypeId", "" + axelaInventoryItem.getItemCosttypeId());
					map.put("itemActive", "" + axelaInventoryItem.getItemActive());
					map.put("itemNotes", axelaInventoryItem.getItemNotes());
					map.put("itemNotes", axelaInventoryItem.getItemNotes());
					if (axelaInventoryItem.getItemEntryId() != 0) {
						map.put("itemEntryBy", empRepository.findEmpName(axelaInventoryItem.getItemEntryId()));
						map.put("itemEntryId", String.valueOf(axelaInventoryItem.getItemEntryId()));
						map.put("itemEntryDate", strToShortDate(axelaInventoryItem.getItemEntryDate()));
					}
					if (axelaInventoryItem.getItemModifiedId() != 0) {
						emp = empRepository.findByEmpId(axelaInventoryItem.getItemModifiedId());
						map.put("itemModifyId", String.valueOf(axelaInventoryItem.getItemModifiedId()));
						map.put("itemModifyBy", empRepository.findEmpName(axelaInventoryItem.getItemModifiedId()));
						map.put("itemModifyDate", strToShortDate(axelaInventoryItem.getItemModifiedDate()));
					}
					list.add(map);
					output.put("populateData", list);
				}
				else {
					output.put("errormsg", "No Data Found");
				}
			}
		}
		return output;
	}

	public Map<String, String> populateInventoryConfigDetails(String input, HttpSession session, HttpServletResponse response) throws JSONException {
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		String empId = "0";
		output = new LinkedHashMap();
		inputObj = new JSONObject(input);
		String ledger_id = "0";
		empId = getSession("empId", session);
		if (!empId.equals("0")) {
			List<Object[]> object = inventoryItemRepository.findInventoryItemConfigFields(Integer.parseInt(CNumeric(empId)));
			for (Object[] objects : object) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("compBusinesstypeId", "" + objects[0]);
				map.put("compModuleAccounting", "" + objects[1]);
				map.put("empRoleId", "" + objects[2]);
				map.put("configInventoryCurrentStock", "" + objects[3]);
				list.add(map);
			}
			output.put("populateInventoryConfigDetails", list.toString());
		} else {
			output.put("erromsg", "No Data Found!");
		}
		return output;
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		perPage = CNumeric(getSession("empRecperPage", session));
		String strSearch = "";
		String strOrderBy = "";
		itemCatId = "0";
		salescatId = "0";
		page = 0;
		if (empId != 0) {
			if (!returnPerm(compId + ",emp_item_access, emp_sales_item_access, emp_pos_item_access, emp_invoice_item_access, emp_prod_item_access, emp_service_item_access,", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			branchAccess = getSession("branchAccess", session).replaceAll("branchId", "a.customerBranchId");
			exeAccess = getSession("exeAccess", session).replaceAll("empId", "a.customerEmpId");
			String customerType = "";
			List<AxelaInventoryItem> itemList = null;
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

			if (!inputObj.isNull("compModulePos")) {
				compModulePos = PadQuotes((inputObj.getString("compModulePos"))).toUpperCase();
			}
			if (!inputObj.isNull("salescatId")) {
				salescatId = CNumeric(PadQuotes((inputObj.getString("salescatId"))));
			}

			if (!inputObj.isNull("catId")) {
				itemCatId = CNumeric(PadQuotes((inputObj.getString("catId"))));
			}

			if (!inputObj.isNull("itemId")) {
				itemId = CNumeric(PadQuotes((inputObj.getString("itemId"))));
			}
			if (!inputObj.isNull("requestType")) {
				requestType = PadQuotes((inputObj.getString("requestType")));
			}
			// for joinin trans table axelaInventorySalescatTran
			if (salescatId.equals("1")) {
				StrJoin = "JOIN item.axelaInventorySalescatTran";
			}
			// filtering data from category
			if (!itemCatId.equals("0")) {
				strSearch += " AND item.itemCatId=" + itemCatId + " ";
			}
			// for filtering item
			if (!itemId.equals("0")) {
				strSearch += " AND item.itemId=" + itemId + " ";
			}
			perPage = "25";
			if (perPage.equals("0")) {
				perPage = "25";
			}
			if (orderType.equals("")) {
				orderType = "DESC";
			}
			if (orderByField.equals("")) {
				orderByField = "itemId";
			}
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			page++;
			strSearch += branchAccess + exeAccess;
			strOrderBy = " ORDER BY item." + orderByField + " " + orderType + "";
			itemList = inventoryFilterImp.findAll(strSearch, strOrderBy, StrJoin, page, Integer.parseInt(CNumeric(perPage)));
			String totalCount = inventoryFilterImp.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(totalCount), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("ID", "itemId", "center"));
			listHeader.add(produceHeaderData("Items", "itemName", "center"));
			listHeader.add(produceHeaderData("Model", "axelaInventoryItemModel.modelName", "center"));
			listHeader.add(produceHeaderData("Description", "itemSmallDesc", "left"));
			listHeader.add(produceHeaderData("UOM", "axelaInventoryUom.uomName", "uomName"));
			listHeader.add(produceHeaderData("EOQ", "itemEoq", "right"));
			listHeader.add(produceHeaderData("Category", "axelaInventoryCat.catName", "left"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaInventoryItem obj : itemList) {
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
				value.add(obj.getItemId());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Items
				type.add(false);
				value.add(PadQuotes(String.valueOf(obj.getItemName())));
				if (!PadQuotes(String.valueOf(obj.getItemCode())).equals("")) {
					type.add(false);
					value.add(" Code: " + " " + PadQuotes(String.valueOf(obj.getItemCode())));
				}
				if (!obj.getItemImg().equals("")) {
					type.add(false);
					value.add("<img src=../Thumbnail.do?itemId=" + CNumeric(PadQuotes(String.valueOf(obj.getItemId())))
							+ "&image_type=item"
							+ "&width=100 alt=" + PadQuotes(String.valueOf(obj.getItemName())));
				} else {
					itemImg = "";
				}
				if (CNumeric(PadQuotes(String.valueOf(obj.getItemActive()))).equals("0")) {
					type.add(false);
					value.add("<font color=\"red\">[Inactive]</font></br>");
				} else {
					itemActive = "";
				}
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Model
				type.add(false);
				value.add(obj.getModelName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Description
				type.add(false);
				value.add(obj.getItemSmallDesc());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Uom
				type.add(false);
				value.add(obj.getUomName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// EOQ
				type.add(false);
				value.add(obj.getItemEoq());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Category
				if (obj.getCatId() != 0) {
					type.add(false);
					value.add(obj.getCatName());
				}
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				mapData.put("td", listData);
				ArrayList<String> updateItem = new ArrayList<String>();
				ArrayList<String> listItemPrice = new ArrayList<String>();
				ArrayList<String> serviceCheckList = new ArrayList<String>();
				ArrayList<String> configureProduct = new ArrayList<String>();
				ArrayList<String> manageprepaidcardItems = new ArrayList<String>();
				// for item add
				updateItem.add("updateItem");
				updateItem.add(PadQuotes(String.valueOf(obj.getItemId())));
				// for item add
				listItemPrice.add("listItemPrice");
				listItemPrice.add(PadQuotes(String.valueOf(obj.getItemId())));
				// for service CheckList
				serviceCheckList.add("serviceCheckList");
				serviceCheckList.add(PadQuotes(String.valueOf(obj.getItemId())));
				// for service configureProduct
				configureProduct.add("configureProduct");
				configureProduct.add(PadQuotes(String.valueOf(obj.getItemId())));
				// for service configureProduct
				manageprepaidcardItems.add("manageprepaidcardItems");
				manageprepaidcardItems.add(PadQuotes(String.valueOf(obj.getItemId())));
				itemItemtypeId = CNumeric(String.valueOf(obj.getItemItemtypeId()));
				mapAction.put("td", produceActionData(updateItem, listItemPrice, serviceCheckList, configureProduct, manageprepaidcardItems, itemItemtypeId));
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

	private ArrayList<HashMap> produceActionData(ArrayList<String> updateItem, ArrayList<String> listItemPrice, ArrayList<String> serviceCheckList, ArrayList<String> configureProduct,
			ArrayList<String> manageprepaidcardItems, String itemItemtypeId) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Item");
		mapBodyData.put("param", updateItem);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "List Item Price");
		mapBodyData.put("param", listItemPrice);
		listAction.add((HashMap) mapBodyData.clone());

		if (itemItemtypeId.equals("1")) {
			mapBodyData.put("value", "Service CheckList");
			mapBodyData.put("param", serviceCheckList);
			listAction.add((HashMap) mapBodyData.clone());
		}

		if (itemItemtypeId.equals("1")) {
			mapBodyData.put("value", "Configure Product");
			mapBodyData.put("param", configureProduct);
			listAction.add((HashMap) mapBodyData.clone());
		}

		if (itemItemtypeId.equals("1") && compModulePos.equals("1")) {
			mapBodyData.put("value", "Manage Prepaid Card Items");
			mapBodyData.put("param", manageprepaidcardItems);
			listAction.add((HashMap) mapBodyData.clone());
		}
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "item.*"));
		list.add(buildSmartArr("Item ID", "numeric", "item.itemId"));
		list.add(buildSmartArr("Name", "text", "item.itemName"));
		list.add(buildSmartArr("Code", "text", "item.itemCode"));
		list.add(buildSmartArr("Type", "text", "item.itemtypeName"));
		list.add(buildSmartArr("Category", "text", "COALESCE(item.axelaInventoryCat.catName, '')"));
		list.add(buildSmartArr("Model", "text", "COALESCE(item.axelaInventoryItemModel.modelName, '')"));
		list.add(buildSmartArr("Small Description", "text", "item.itemSmallDesc"));
		list.add(buildSmartArr("Big Description", "text", "item.itemBigDesc"));
		list.add(buildSmartArr("Perishable", "boolean", "item.itemPerishable"));
		list.add(buildSmartArr("Non Stock", "boolean", "item.itemStock"));
		list.add(buildSmartArr("Loyalty Card", "text", "item.itemLoyaltycardId"));
		list.add(buildSmartArr("UOM", "text", "COALESCE(item.axelaInventoryUom.uomName, '')"));
		list.add(buildSmartArr("EOQ", "numeric", "item.itemEoq"));
		list.add(buildSmartArr("Featured", "boolean", "item.itemFeatured"));
		list.add(buildSmartArr("Active", "boolean", "item.itemActive"));
		list.add(buildSmartArr("Notes", "text", "item.itemNotes"));
		// list.add(buildSmartArr("Entry By", "text", "item.itemEntryId IN (SELECT emp_id FROM compdb.axela_emp WHERE emp_name"));
		list.add(buildSmartArr("Entry Date", "text", "item.itemEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "item.itemModifiedId in (SELECT emp_id FROM compdb.axela_emp WHERE emp_name"));
		list.add(buildSmartArr("Modified Date", "text", "item.itemModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}
}
