//package axela.sales.service;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.codehaus.jettison.json.JSONArray;
//import org.codehaus.jettison.json.JSONException;
//import org.codehaus.jettison.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Service;
//
//import axela.config.Connect;
//import axela.customer.service.PopulateService;
//import axela.inventory.model.AxelaInventorySalescat;
//import axela.inventory.model.AxelaInventorySalescatTran;
//import axela.inventory.repository.InventoryFilterImp;
//import axela.inventory.repository.InventorySalCatFilterImp;
//import axela.inventory.repository.InventorySalescatRepository;
//import axela.inventory.repository.InventorySalescatTransRepository;
//import axela.portal.repository.EmpRepository;
//import axela.sales.model.AxelaSalesTarget;
//import axela.sales.repository.SalesTargetFilterImpl;
//import axela.sales.repository.SalesTargetRepository;
//
//@Service
//public class TargetService extends Connect {
//
//	LinkedHashMap output = null;
//	public String msg = "";
//	public String page = "0";
//	public String perpage = "0";
//	public String sort = "Desc";
//	public int empId = 0;
//	public String field = "", value = "";
//	// configuration
//
//	public String salescatId = "0";
//	public String salescatName = "";
//	public String salescatEntryId = "0", entryBy = "";
//	public String salescatEntryDate = "", entryDate = "";
//	public String salescatModifiedId = "0", modifiedBy = "";
//	public String salescatModifiedDate = "", modifiedDate = "";
//
//	public String inventoryItemTrans = "";
//
//	public int branchId = 0;
//	public String branchAccess = "", exeAccess = "";
//	public String ExeAccess = "";
//	public String empFormatDate = "";
//	public String keyword = "";
//	public int length = 0;
//	JSONObject inputObj = null;
//	public String pageNumber = "";
//	public String perPage = "";
//	public String property = "";
//	int PAGESIZE = 25;
//	String strSearch = "";
//
//	//
//	public String requestType = "";
//
//	@Autowired
//	PopulateService populateService;
//
//	@Autowired
//	InventorySalCatFilterImp inventorySalCatFilterImp;
//
//	@Autowired
//	InventorySalescatRepository inventorySalescatRepository;
//
//	@Autowired
//	InventorySalescatTransRepository inventorySalescatTransRepository;
//
//	@Autowired
//	EmpRepository empRepository;
//
//	@Autowired
//	InventoryFilterImp inventoryFilterImp;
//
//	@Autowired
//	SalesTargetRepository salesTargetRepository;
//
//	@Autowired
//	SalesTargetFilterImpl salesTargetFilterImpl;
//
//	public Map<String, String> targetService(String input, HttpSession session, HttpServletResponse response) throws JSONException {
//		inventoryItemTrans = "";
//		salescatId = "0";
//		// compId = getSession("compId", session);
//		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
//		if (empId != 0) {
//			inputObj = new JSONObject(input);
//			output = new LinkedHashMap<String, String>();
//			if (!inputObj.isNull("requestType")) {
//				requestType = inputObj.getString("requestType");
//			}
//			switch (requestType) {
//
//				case "add" : // add an customer.
//					getValues(inputObj);
//					addFields(response);
//					break;
//
//				case "update" :// update an customer.
//					getValues(inputObj);
//					addFields(response);
//					break;
//
//				case "delete" :// delete an customer.
//					if (!inputObj.isNull("salescatId")) {
//						salescatId = inputObj.getString("salescatId");
//					}
//					if (!salescatId.equals("0")) {
//						deleteFields(salescatId);
//					}
//					SOP("salescatId" + salescatId);
//
//					break;
//
//			}
//		}
//		return output;
//	}
//
//	private void deleteFields(String salescatId) {
//		// TODO Auto-generated method stub
//		inventorySalescatRepository.delete(Integer.parseInt(salescatId));
//		output.put("successmsg", "Sales Category Deleted Successfully");
//	}
//
//	private void addFields(HttpServletResponse response) {
//		String transSalescatId = "0";
//		checkForm();
//		AxelaInventorySalescat axelaInventorySalescat = null;
//		if (msg.equals("")) {
//			if (!salescatId.equals("0")) {
//				axelaInventorySalescat = inventorySalescatRepository.findOne(Integer.parseInt(CNumeric(salescatId)));
//			} else {
//				axelaInventorySalescat = new AxelaInventorySalescat();
//			}
//			axelaInventorySalescat.setSalescatId(Integer.parseInt(CNumeric(salescatId)));
//			axelaInventorySalescat.setSalescatName(salescatName);
//			if (requestType.equals("add")) {
//				axelaInventorySalescat.setSalescatEntryId(empId);
//				axelaInventorySalescat.setSalescatEntryDate(ToLongDate(kknow()));
//				axelaInventorySalescat.setSalescatModifiedId(0);
//				axelaInventorySalescat.setSalescatModifiedDate("");
//			}
//			if (requestType.equals("update")) {
//				axelaInventorySalescat.setSalescatModifiedId(empId);
//				axelaInventorySalescat.setSalescatModifiedDate(ToLongDate(kknow()));
//			}
//			inventorySalescatRepository.save(axelaInventorySalescat);
//			transSalescatId = CNumeric("" + axelaInventorySalescat.getSalescatId());
//
//			if (!transSalescatId.equals("0")) {
//				UpdateList(transSalescatId);
//			}
//
//			if (salescatId.equals("0")) { // if id = 0 -> add mode else update mode
//				output.put("successmsg", "Sales Category Added Successfully!");
//			} else {
//				output.put("successmsg", "Sales Category Updated Successfully!");
//			}
//
//		} else {
//			response.setStatus(400); // Bad request since missing mandatory fields from client.
//			output.put("errormsg", msg);
//		}
//		// inventorySalescatRepository.save();
//
//	}
//	private void getValues(JSONObject inputObj) throws JSONException {
//
//		if (!inputObj.isNull("salescatId")) {
//			salescatId = inputObj.getString("salescatId");
//		}
//		if (!inputObj.isNull("salescatName")) {
//			salescatName = inputObj.getString("salescatName");
//		}
//
//		if (!inputObj.isNull("inventoryItemTrans")) {
//			JSONArray inputArray = inputObj.getJSONArray("inventoryItemTrans");
//			for (int i = 0; i < inputArray.length(); i++) {
//				inventoryItemTrans = inputArray.getString(i) + ",";
//			}
//			if (inventoryItemTrans.length() > 0) {
//				inventoryItemTrans = inventoryItemTrans.substring(0, inventoryItemTrans.length() - 1);
//			}
//		}
//
//	}
//
//	private void UpdateList(String transSalescatId) {
//		AxelaInventorySalescatTran axelaInventorySalescatTran = null;
//		inventorySalescatTransRepository.deleteByTransSalescatId(Integer.parseInt(CNumeric(transSalescatId)));
//		if (!inventoryItemTrans.equals("")) {
//			String items[] = inventoryItemTrans.split(",");
//			for (int i = 0; i < items.length; i++) {
//				axelaInventorySalescatTran = new AxelaInventorySalescatTran();
//				axelaInventorySalescatTran.setTransSalescatId(Integer.parseInt(CNumeric(transSalescatId)));
//				axelaInventorySalescatTran.setTransItemId(Integer.parseInt(CNumeric(items[i])));
//				inventorySalescatTransRepository.saveAndFlush(axelaInventorySalescatTran);
//			}
//		}
//	}
//
//	public void checkForm() {
//
//		msg = "";
//		if (salescatName.equals("")) {
//			msg += "<br>Enter Name!";
//		} else {
//			List<AxelaInventorySalescat> axelaInventorySalescat = inventorySalescatRepository.findBysalescatName(salescatName);
//			if (!axelaInventorySalescat.isEmpty()) {
//				msg += "<br>Similar Name found!";
//			}
//		}
//	}
//
//	public Map listData(String input, HttpSession session) throws JSONException {
//		page = "0";
//		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
//
//		// for testing
//		if (empId == 0) {
//			empId = 1;
//		}
//		if (empId != 0) {
//			inputObj = new JSONObject(input);
//			output = new LinkedHashMap<String, String>();
//			// branchAccess = getSession("branchAccess", session).replaceAll("branchId", "salescat.customerBranchId");
//			// exeAccess = getSession("exeAccess", session).replaceAll("empId", "salescat.customerEmpId");
//			String customerType = "";
//			List<AxelaInventorySalescat> salesCatList = null;
//			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
//			List<HashMap> listBody = new ArrayList<HashMap>();
//			List<HashMap> listAction = new ArrayList<HashMap>();
//			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
//			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
//			PageRequest request = null;
//			if (!inputObj.isNull("sortField")) {
//				field = PadQuotes((inputObj.getString("sortField")));
//			}
//			if (!inputObj.isNull("pageIndex")) {
//				page = CNumeric(PadQuotes((inputObj.getString("pageIndex"))));
//			}
//			if (!inputObj.isNull("sortDirection")) {
//				sort = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
//			}
//
//			perPage = CNumeric(getSession("emp_recperpage", session));
//			if (perPage.equals("0")) {
//				perPage = "25";
//			}
//			if (sort.equals("")) {
//				sort = "DESC";
//			}
//			if (field.equals("")) {
//				field = "salescatId";
//			}
//
//			page = "" + (Integer.parseInt(page) + 1);
//
//			strSearch = branchAccess + exeAccess + " ORDER BY salescat." + field + " " + sort;
//			salesCatList = inventorySalCatFilterImp.findAll(strSearch, Integer.parseInt(CNumeric(page)), Integer.parseInt(CNumeric(perPage)));
//			length = inventorySalCatFilterImp.saleCatLength;
//
//			Map<String, String> mapNavi = pageNavi(length, input, perPage);
//			int count = 0;
//
//			// listTh.add("Actions");
//			// listFormat.add("left");
//
//			// Start Header Data
//
//			listHeader.add(produceHeaderData("#", "Sl.no", "center"));
//			// listHeader.add(produceHeaderData("ID", "catId", "center"));
//			listHeader.add(produceHeaderData("Sales Categories", "catName", "left"));
//			// End Header Data
//
//			// Start Body Align
//			listBodyAlign.add(produceBodyAlign("center"));
//			// listBodyAlign.add(produceBodyAlign("center"));
//			listBodyAlign.add(produceBodyAlign("left"));
//			// End Body Align
//			SOP("salesCatList========" + salesCatList.isEmpty());
//			for (AxelaInventorySalescat obj : salesCatList) {
//
//				SOP("obj=========" + obj.getItemCount());
//				ArrayList<String> param = new ArrayList<String>();
//				ArrayList<String> updateSalesCategory = new ArrayList<String>();
//				ArrayList<String> itemList = new ArrayList<String>();
//
//				long saleItemCount = 0;
//				HashMap<String, List<HashMap>> mapData = new HashMap<String, List<HashMap>>();
//				HashMap<String, List<HashMap>> mapAction = new HashMap<String, List<HashMap>>();
//				HashMap<String, List<String>> mapBodyData = new HashMap<String, List<String>>();
//				List<HashMap> listData = new ArrayList<HashMap>();
//
//				count++;
//
//				// Start Body data
//
//				saleItemCount = obj.getItemCount();
//
//				// for updateSalesCategory
//				updateSalesCategory.add("updateSalesCategory");
//				updateSalesCategory.add(PadQuotes(String.valueOf(obj.getSalescatId())));
//
//				// for updateSalesCategory
//				itemList.add("itemList");
//				itemList.add(PadQuotes(String.valueOf(obj.getSalescatId())));
//
//				listData.add(produceBodyData(new StringBuilder(PadQuotes(String.valueOf(count))), false, "", (ArrayList<String>) param.clone()));
//
//				listData.add(produceBodyData(new StringBuilder(PadQuotes(String.valueOf(obj.getSalescatName()))), false, "", (ArrayList<String>) param.clone()));
//
//				// listData.add(produceBodyData(new StringBuilder(String.valueOf(obj.getCatName())), false, "", (ArrayList<String>) param.clone()));
//
//				mapData.put("td", listData);
//				mapAction.put("td", produceActionData(updateSalesCategory, itemList, saleItemCount));
//				listAction.add(mapAction);
//				listBody.add(mapData);
//			}
//			output.put("meta", mapNavi);
//			output.put("thead", listHeader);
//			output.put("tdalign", listBodyAlign);
//			output.put("tbody", listBody);
//			output.put("action", listAction);
//			if (AppRun().equals("0")) {
//				SOP("output==========catService==========" + output.toString());
//			}
//		}
//		return output;
//	}
//	private ArrayList<HashMap> produceActionData(ArrayList<String> updateSalesCategory, ArrayList<String> itemList, long saleItemCount) {
//		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
//		HashMap mapBodyData = new HashMap();
//
//		mapBodyData.put("value", "Update Sales Category");
//		mapBodyData.put("routingLink", "");
//		// /inventory/sales-category
//		mapBodyData.put("param", updateSalesCategory);
//		listAction.add((HashMap) mapBodyData.clone());
//
//		mapBodyData.put("value", "List Items(" + saleItemCount + ")");
//		mapBodyData.put("routingLink", "");
//		// /inventory/item-list
//		mapBodyData.put("param", itemList);
//		listAction.add((HashMap) mapBodyData.clone());
//
//		return listAction;
//	}
//
//	public List<AxelaSalesTarget> targetList(String input, HttpSession session) throws JSONException {
//		// TODO Auto-generated method stub
//		output = new LinkedHashMap<String, String>();
//		inputObj = new JSONObject(input);
//		String empId = "", year = "", StrSql = "";
//		if (!inputObj.isNull("empId")) {
//			empId = inputObj.getString("empId");
//		}
//		if (!inputObj.isNull("year")) {
//			year = inputObj.getString("year");
//		}
//
//		StrSql = "SELECT NEW AxelaSalesTarget(target.targetId,"
//				+ " COALESCE(target.targetStartdate, '') AS targetStartdate,"
//				+ " COALESCE(target.targetEnddate, '') AS targetEnddate,"
//				+ " COALESCE(target.targetOpprCount, 0) AS targetOpprCount,"
//				+ " COALESCE(target.targetOpprCallsCount, 0) AS targetOpprCallsCount,"
//				+ " COALESCE(target.targetOpprMeetingsCount, 0) AS targetOpprMeetingsCount,"
//				+ " COALESCE(target.targetOpprDemosCount, 0) AS targetOpprDemosCount,"
//				+ " COALESCE(target.targetOpprHotCount, 0) AS targetOpprHotCount,"
//				+ " COALESCE(target.targetSoCount, 0) AS targetSoCount,"
//				+ " COALESCE(target.targetSoAmount, 0) AS targetSoAmount)";
//
//		// CountSql = "SELECT COUNT(DISTINCT target_id)";
//
//		StrSql += " FROM AxelaSalesTarget target"
//				+ " WHERE target.targetEmpId = " + empId + ""
//				+ " AND SUBSTRING(target.targetStartdate, 1, 8) >= " + year + "0101"
//				+ " AND SUBSTRING(target.targetEnddate, 1, 8) <= " + year + "1231";
//
//		List<AxelaSalesTarget> target = salesTargetFilterImpl.findTargetList(StrSql);
//
//		return target;
//	}
// }
