package axela.inventory.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.inventory.model.AxelaInventoryItem;
import axela.inventory.model.AxelaInventoryItemOption;
import axela.inventory.repository.InventoryGroupRepository;
import axela.inventory.repository.InventoryItemOptionsRepository;
import axela.inventory.repository.InventoryItemRepository;
import axela.inventory.repository.ItemOptionsFilterImpl;
@Service
public class InventoryItemOptionsService extends Connect {

	@Autowired
	ItemOptionsFilterImpl itemOptionsFilterImpl;

	@Autowired
	InventoryItemRepository inventoryItemRepository;

	@Autowired
	InventoryGroupRepository inventoryGroupRepository;

	@Autowired
	InventoryItemOptionsRepository inventoryItemOptionsRepository;

	public String itemName = "", optionTypeName = "", groupType = "";
	public String groupTypeName = "", itemId = "", itemDeatil = "";
	// option entiry
	public String optionGroupId = "0";
	public String optionId = "0";
	public String optionItemId = "0";
	public String optionQty = "0";
	public String optionSelect = "";
	public Date optionValidfrom = null;
	public Date optionValidtill = null;
	public String optionItemmasterId = "0";
	public String requestType = "";
	public String pageNumber = "";
	public int empId = 0;
	public int compId = 0;
	public String msg = "";
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

	public Map itemOptionsService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		perPage = getSession("perPage", session);
		perPage = CNumeric(getSession("empRecperpage", session));
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new HashMap();
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			switch (requestType) {
				case "add" : // add
					getValues();
					addFields(response);
					break;
				case "update" :// update
					getValues();
					addFields(response);
					break;
				case "delete" :// delete
					if (!inputObj.isNull("optionId")) {
						optionId = CNumeric(inputObj.getString("optionId"));
					}
					if (!inputObj.isNull("optionItemmasterId")) {
						optionItemmasterId = CNumeric(inputObj.getString("optionItemmasterId"));
					}
					if (!inputObj.isNull("itemId")) {
						itemId = CNumeric(inputObj.getString("itemId"));
					}

					if (!optionId.equals("0") || (itemId.equals(optionItemmasterId) && !optionId.equals("0"))) {
						deleteFields(optionId);
					}
					break;

				case "onchange" :// search
					if (!inputObj.isNull("searchName")) {
						itemDeatil = PadQuotes(inputObj.getString("searchName"));
					}
					onchangeSearch(itemDeatil);
					break;
			}
		}
		return output;
	}

	public void getValues() throws JSONException, ParseException {
		msg = "";
		if (!inputObj.isNull("optionId")) {
			optionId = CNumeric(inputObj.getString("optionId"));
		}
		if (!inputObj.isNull("optionGroupId")) {
			optionGroupId = CNumeric(inputObj.getString("optionGroupId"));
		}
		if (!inputObj.isNull("optionItemId")) {
			optionItemId = CNumeric(inputObj.getString("optionItemId"));
		}
		if (!inputObj.isNull("optionQty")) {
			optionQty = CNumeric(inputObj.getString("optionQty"));
		}
		if (!inputObj.isNull("optionSelect")) {
			optionSelect = PadQuotes(inputObj.getString("optionSelect"));
		}
		if (!inputObj.isNull("optionValidfrom")) {
			optionValidfrom = stringToDate(inputObj.getString("optionValidfrom"));
		}
		if (!inputObj.isNull("optionItemmasterId")) {
			optionItemmasterId = PadQuotes(inputObj.getString("optionItemmasterId"));
		}
		if (!inputObj.isNull("optionValidtill")) {
			optionValidtill = stringToDate(inputObj.getString("optionValidtill"));
		}
	}

	public void validateFields() throws ParseException {
		boolean validFrom = false, validTill = false;
		optionTypeName = "";
		int itemdetail = 0;
		int optionItemdetail = 0;
		String groupTypeDetail = "";
		if (optionItemId.equals("0")) {
			msg = msg + "<br>Select Item to add!";
		}
		if (!optionItemId.equals("0")) {
			itemdetail = inventoryItemOptionsRepository.optionItemDetails(Integer.parseInt(optionItemId), Integer.parseInt(optionItemmasterId));
			if (itemdetail != 0) {
				msg = msg + "<br>Item already present!";
			} else {
				if (optionGroupId.equals("0")) {
					msg = msg + "<br>Select Group!";
				}

				if (!optionItemId.equals("0") && !optionGroupId.equals("0")) {
					optionItemdetail = inventoryItemOptionsRepository.optionItemdetailBygroupId(Integer.parseInt(optionItemId), Integer.parseInt(optionGroupId), Integer.parseInt(optionItemmasterId));
					if (optionItemdetail != 0) {
						msg = msg + "<br>This item already added for this group!";
					}
				}

				if (groupType != null && groupType.equals("1") && !optionGroupId.equals("0")) { // For 'Default' Option Type
					strSearch = "";
					if (optionSelect.equals("1")) {
						strSearch = " WHERE invgroup.groupType = 1"
								+ " AND option.optionGroupId = "
								+ optionGroupId
								+ " AND option.optionItemmasterId = "
								+ optionItemmasterId + " ";
						itemOptionsFilterImpl.updateOptionBasedOnGroupId(strSearch, 0);
					} else {

						strSearch = " AND group_type = 1"
								+ " AND optionGroupId = "
								+ optionGroupId
								+ " "
								+ " AND optionItemmasterId = "
								+ optionItemmasterId
								+ " ";
						groupTypeDetail = itemOptionsFilterImpl.groupTypeDetail(strSearch);
						if (groupTypeDetail.equals("")) {
							optionSelect = "1";
						}
					}
				}
				if (!optionItemId.equals("")) {
					itemName = inventoryItemRepository.findByItemCodeDetail(Integer.parseInt(optionItemId));
				}
				if (!optionGroupId.equals("0")) {
					groupType = "1";// inventoryGroupRepository.groupType(Integer.parseInt(optionGroupId));
				}
				if (groupType.equals("1")) {
					groupTypeName = "Default";
				} else if (groupType.equals("2")) {
					groupTypeName = "All Selected";
				} else if (groupType.equals("3")) {
					groupTypeName = "Multi Select";
				}
				if (groupType.equals("2") && optionSelect.equals("0")) { // For 'All Selected' Option Type
					optionSelect = "1";
				}

				if (optionQty.equals("")) {
					msg = msg + "<br>Enter Option Quantity!";
				}

				if (!optionValidfrom.equals("")) {
					validFrom = isValidDateFormatShort(strToShortDate(optionValidfrom));
					if (validFrom == true) {
						optionValidfrom = stringToDate(dateToShortDate(optionValidfrom));
					} else if (validFrom == false) {
						msg = msg + "<br>Enter Valid 'From Date'!";
					}
				} else {
					msg = msg + "<br>Enter 'From Date'!";
				}

				if (!optionValidtill.equals("")) {
					validTill = isValidDateFormatShort(strToShortDate(optionValidtill));
					if (validTill == true) {
						optionValidtill = stringToDate(dateToShortDate(optionValidtill));// convertShortDateToStr(optionValidtill);
					} else if (validTill == false) {
						msg += "<br>Enter Valid 'Till Date'!";
					}
				} else {
					msg += "<br>Enter 'Till Date'!";
				}

				if (validFrom == true && validTill == true) {
					if (optionValidfrom.after(optionValidtill)) {
						msg += "<br>'Till Date' must be greater than the 'From date'";
					}
				}
			}
		}
		if (!msg.equals("")) {
			msg = "Error!" + msg;
		}
	}
	public void addFields(HttpServletResponse response) throws JSONException, ParseException {
		validateFields();
		output = new HashMap();
		if (msg.equals("")) {
			AxelaInventoryItemOption axelaInventoryItemOption = null;
			if (!optionId.equals("0")) {
				axelaInventoryItemOption = inventoryItemOptionsRepository.findByOptionId(Integer.parseInt(optionId));
			} else {
				axelaInventoryItemOption = new AxelaInventoryItemOption();
			}
			axelaInventoryItemOption.setOptionId(Integer.parseInt(optionId));
			axelaInventoryItemOption.setOptionGroupId(Integer.parseInt(optionGroupId));
			axelaInventoryItemOption.setOptionQty(Integer.parseInt(optionQty));
			axelaInventoryItemOption.setOptionItemId(Integer.parseInt(optionItemId));
			axelaInventoryItemOption.setOptionItemmasterId(Integer.parseInt(optionItemmasterId));
			axelaInventoryItemOption.setOptionSelect(optionSelect);
			axelaInventoryItemOption.setOptionValidfrom(optionValidfrom);
			axelaInventoryItemOption.setOptionValidtill(optionValidtill);
			String optionId = inventoryItemOptionsRepository.save(axelaInventoryItemOption).getOptionId() + "";
			if (!optionId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("optionId", optionId);
				output.put("successmsg", "Item Added Successfully!");
			} else if (!optionId.equals("0") && requestType.equals("update")) {
				output.put("optionId", optionId);
				output.put("successmsg", "Item Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String optionId) {
		inventoryItemOptionsRepository.delete(Integer.parseInt(optionId));
		output.put("successmsg", "SOE Deleted Successfully!");

	}

	public Map populateData(String input, HttpSession session) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("itemId")) {
			optionId = CNumeric(PadQuotes(inputObj.getString("itemId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		SOP("optionId==============" + optionId);
		if (!optionId.equals("0")) {
			SOP("comingggg===222222222222222222====");
			AxelaInventoryItemOption axelaInventoryItemOption = inventoryItemOptionsRepository.findByOptionId(Integer.parseInt(optionId));
			SOP("comingggg====333333333333333===");
			HashMap map = new HashMap();
			map.put("optionId", optionId);
			SOP("comingggg=======");
			map.put("optionGroupId", axelaInventoryItemOption.getOptionGroupId());
			SOP("comingggg===11111111111====");
			map.put("optionValidfrom", strToShortDate(axelaInventoryItemOption.getOptionValidfrom()));
			map.put("optionValidtill", strToShortDate(axelaInventoryItemOption.getOptionValidtill()));
			map.put("optionItemId", String.valueOf(axelaInventoryItemOption.getOptionItemId()));
			map.put("optionQty", String.valueOf(axelaInventoryItemOption.getOptionQty()));
			map.put("optionSelect", String.valueOf(axelaInventoryItemOption.getOptionSelect()));
			map.put("optionItemmasterId", String.valueOf(axelaInventoryItemOption.getOptionItemmasterId()));
			list.add(map);
		}
		output.put("populateData", list);
		return output;
	}

	public Map populateConfigureProductListData(String input, HttpSession session) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);

		if (!inputObj.isNull("optionItemmasterId")) {
			optionItemmasterId = CNumeric(inputObj.getString("optionItemmasterId"));
		}
		if (!(optionItemmasterId.equals("0"))) {
			strSearch = " AND option.optionItemmasterId = " + optionItemmasterId + "";
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

		if (!optionItemmasterId.equals("0")) {
			List<AxelaInventoryItemOption> obj = itemOptionsFilterImpl.findItemOptionList(strSearch, strOrderBy);
			int count = 1;
			for (AxelaInventoryItemOption axelaInventoryItemOption : obj) {
				HashMap map = new HashMap();
				map.put("count", count);
				map.put("Item", String.valueOf(axelaInventoryItemOption.getItemName()) + " (" + String.valueOf(axelaInventoryItemOption.getItemCode()) + ") ");
				if (String.valueOf(axelaInventoryItemOption.getGroupType()).equals("1")) {
					optionTypeName += "Default";
				} else if (String.valueOf(axelaInventoryItemOption.getGroupType()).equals("2")) {
					optionTypeName += "All Selected";
				} else if (String.valueOf(axelaInventoryItemOption.getGroupType()).equals("3")) {
					optionTypeName += "Multi Select";
				}
				map.put("Type", optionTypeName);
				if (String.valueOf(axelaInventoryItemOption.getOptionSelect()).equals("1")) {
					optionSelect += "Selected";
				} else {
					optionSelect += "";
				}
				map.put("Selected", optionSelect);
				map.put("Qty", String.valueOf(axelaInventoryItemOption.getOptionQty()));
				map.put("Valid From", strToShortDate(axelaInventoryItemOption.getOptionValidfrom()));
				map.put("Valid Till", strToShortDate(axelaInventoryItemOption.getOptionValidtill()));
				count++;
				list.add(map);
			}
		}
		output.put("populateConfigureProductListData", list);
		return output;
	}

	private void onchangeSearch(String itemDeatil) {
		output = new HashMap();
		strSearch = " AND (item.itemId LIKE '%" + itemDeatil + "%'"
				+ " OR item.itemName LIKE '%" + itemDeatil + "%'"
				+ " OR item.itemCode LIKE '%" + itemDeatil + "%'"
				+ " OR item.axelaInventoryCatPop.catName LIKE '%" + itemDeatil + "%')";
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!strSearch.equals("0")) {
			List<AxelaInventoryItem> obj = itemOptionsFilterImpl.findItemDetail(strSearch);
			int count = 0;
			for (AxelaInventoryItem axelaInventoryBinItem : obj) {
				SOP("count=====for====loop");
				HashMap map = new HashMap();
				map.put("count", count);
				map.put("itemId", String.valueOf(axelaInventoryBinItem.getItemId()));
				map.put("itemName", String.valueOf(axelaInventoryBinItem.getItemName() + " (" + String.valueOf(axelaInventoryBinItem.getItemCode() + ")")));
				map.put("Category", String.valueOf(axelaInventoryBinItem.getCatName()));
				list.add(map);
				count++;
			}
		}
		output.put("populateOnchangeSearch", list);
	}
	// public Map listData(String input, HttpSession session) throws JSONException, ParseException {
	// inputObj = new JSONObject(input);
	// empId = Integer.parseInt(CNumeric(getSession("empId", session)));
	// String strSearch = "";
	// String strOrderBy = "";
	// if (empId != 0) {
	// page = 0;
	// output = new LinkedHashMap<String, String>();
	// String customerType = "";
	// List<AxelaCustomer> customerList = null;
	// ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
	// List<HashMap> listBody = new ArrayList<HashMap>();
	// List<HashMap> listAction = new ArrayList<HashMap>();
	// ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
	// ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	// PageRequest request = null;
	// if (!inputObj.isNull("requestType")) {
	// requestType = PadQuotes((inputObj.getString("requestType")));
	// }
	// if (!inputObj.isNull("sortField")) {
	// orderByField = PadQuotes((inputObj.getString("sortField")));
	// }
	// if (!inputObj.isNull("optionItemmasterId")) {
	// optionItemmasterId = PadQuotes((inputObj.getString("optionItemmasterId")));
	// }
	// if (!inputObj.isNull("pageIndex")) {
	// page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
	// }
	// if (!inputObj.isNull("sortDirection")) {
	// orderType = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
	// }
	// perPage = CNumeric(getSession("empRecperpage", session));
	// if (!(optionItemmasterId.equals("0"))) {
	// strSearch = " AND option.optionItemmasterId = " + optionItemmasterId + "";
	// }
	// if (orderType.equals("")) {
	// orderType = "DESC";
	// }
	// if (orderByField.equals("")) {
	// orderByField = "axelaInventoryGroup.groupRank, option.axelaInventoryGroup.groupName";
	// }
	// if (perPage.equals("0")) {
	// perPage = "25";
	// }
	// page++;
	// if (requestType.equals("filter")) {
	// strSearch = buildSmartSearch(input);
	// }
	// strOrderBy = " ORDER BY option." + orderByField + " " + orderType + "";
	// List<AxelaInventoryItemOption> resultSet = itemOptionsFilterImpl.findItemOptionList(strSearch, strOrderBy, page, Integer.parseInt(perPage));
	// String length = itemOptionsFilterImpl.totalCount;
	// Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
	// int count = 0;
	// // Start Header Data
	// listHeader.add(produceHeaderData("Item", "axelaInventoryItem.itemName", "center"));
	// listHeader.add(produceHeaderData("Type", "axelaInventoryGroup.groupType", "center"));
	// listHeader.add(produceHeaderData("Selected", "optionSelect", "center"));
	// listHeader.add(produceHeaderData("Qty", "optionQty", "center"));
	// listHeader.add(produceHeaderData("Valid From", "optionValidfrom", "center"));
	// listHeader.add(produceHeaderData("Valid Till", "optionValidtill", "center"));
	// // End Header Data
	//
	// // Start Body Align
	// listBodyAlign.add(produceBodyAlign("center"));
	// listBodyAlign.add(produceBodyAlign("left"));
	// listBodyAlign.add(produceBodyAlign("left"));
	// listBodyAlign.add(produceBodyAlign("left"));
	// listBodyAlign.add(produceBodyAlign("center"));
	// listBodyAlign.add(produceBodyAlign("center"));
	// // End Body Align
	// String optionTypeName = "";
	// String optionSelect = "";
	// for (AxelaInventoryItemOption obj : resultSet) {
	// ArrayList paramArr = new ArrayList();
	// ArrayList type = new ArrayList();
	// ArrayList value = new ArrayList();
	// HashMap<String, List<HashMap>> mapData = new HashMap<String, List<HashMap>>();
	// HashMap<String, List<HashMap>> mapAction = new HashMap<String, List<HashMap>>();
	// HashMap<String, List<String>> mapBodyData = new HashMap<String, List<String>>();
	// List<HashMap> listData = new ArrayList<HashMap>();
	// count++;
	// // Start Body data
	//
	// // count
	// type.add(false);
	// value.add(count);
	// listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
	// type.clear();
	// value.clear();
	// // Item.
	// type.add(false);
	// value.add(String.valueOf(obj.getItemName()));
	// value.add("Code:" + String.valueOf(obj.getItemCode()));
	// listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
	// type.clear();
	// value.clear();
	// // Type.
	// type.add(false);
	//
	// if (String.valueOf(obj.getGroupType()).equals("1")) {
	// optionTypeName += "Default";
	// } else if (String.valueOf(obj.getGroupType()).equals("2")) {
	// optionTypeName += "All Selected";
	// } else if (String.valueOf(obj.getGroupType()).equals("3")) {
	// optionTypeName += "Multi Select";
	// }
	// value.add(optionTypeName);
	// listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
	// type.clear();
	// value.clear();
	// // Selected.
	// type.add(false);
	// if (String.valueOf(obj.getOptionSelect()).equals("1")) {
	// optionSelect += "Selected";
	// } else {
	// optionSelect += "";
	// }
	// value.add(optionSelect);
	// listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
	// type.clear();
	// value.clear();
	// // Qty
	// type.add(false);
	// value.add(String.valueOf(obj.getOptionQty()));
	// listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
	// type.clear();
	// value.clear();
	// // Valid From
	// type.add(false);
	// value.add(strToShortDate(obj.getOptionValidfrom()));
	// listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
	// type.clear();
	// value.clear();
	// // Valid Till
	// type.add(false);
	// value.add(strToShortDate(obj.getOptionValidtill()));
	// listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
	// type.clear();
	// value.clear();
	// // End Body data
	// mapData.put("td", listData);
	// ArrayList actionParam = new ArrayList();
	// actionParam.add("deleteItem");
	// actionParam.add(PadQuotes(String.valueOf(obj.getItemId())));
	// actionParam.add(PadQuotes(String.valueOf(obj.getOptionItemmasterId())));
	// actionParam.add(PadQuotes(String.valueOf(obj.getOptionId())));
	// mapAction.put("td", produceActionData(actionParam));
	// listAction.add(mapAction);
	// listBody.add(mapData);
	// }
	// output.put("meta", mapNavi);
	// output.put("action", listAction);
	// output.put("tdalign", listBodyAlign);
	// output.put("thead", listHeader);
	// output.put("tbody", listBody);
	// }
	// return output;
	// }
	// @SuppressWarnings("unchecked")
	// public ArrayList<HashMap> produceActionData(ArrayList<String> Param) {
	// ArrayList<HashMap> listAction = new ArrayList<HashMap>();
	// HashMap mapBodyData = new HashMap();
	// mapBodyData.put("value", "Delete Item");
	// mapBodyData.put("param", Param);
	// listAction.add((HashMap) mapBodyData.clone());
	// return listAction;
	// }

}
