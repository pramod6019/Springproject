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
import axela.inventory.model.AxelaInventoryCat;
import axela.inventory.model.AxelaInventoryCatPop;
import axela.inventory.repository.InventoryCatFilterImp;
import axela.inventory.repository.InventoryCatPopRepository;
import axela.inventory.repository.InventoryCatRepository;
import axela.inventory.repository.InventoryItemRepository;
import axela.portal.model.AxelaEmp;
import axela.portal.repository.EmpRepository;

@Service
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class InventoryCatService extends Connect {

	@Autowired
	InventoryCatFilterImp inventoryCatFilterImp;
	@Autowired
	InventoryCatRepository inventoryCatRepository;
	@Autowired
	InventoryCatPopRepository inventoryCatPopRepository;
	@Autowired
	InventoryItemRepository inventoryItemRepository;
	@Autowired
	EmpRepository axelaEmpRepository;

	InventoryCatService() {
	}

	public String listpage = "";
	public String add = "";
	public String update = "";
	public String deleteB = "";
	public String addB = "";
	public String updateB = "";
	public String status = "";
	public String StrSql = "";
	public String msg = "";
	public int totalCount = 0;
	public int page = 0;
	public String perPage = "0";
	public String sort = "Desc";
	public int empId = 0;
	public int compId = 0;
	public String field = "", value = "";
	public int branchId = 0;
	public String catId;
	public String catActive = "";
	private String orderByField = "";
	private String orderType = "";
	public String catEntryDate = "";
	public String catEntryId = "0";
	public String catModifiedDate = "";
	public String catModifiedId = "0";
	public String catName = "";
	public String catParentId = "0";
	// configuration
	public String branchAccess = "", exeAccess = "";
	public String ExeAccess = "";
	public String empFormatDate = "";
	public String keyword = "";
	public int length = 0;
	public String pageNumber = "";
	public String property = "";
	public String requestType = "";

	LinkedHashMap output = null;
	JSONObject inputObj = null;

	public Map<String, String> inventoryCategoryService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		output = new LinkedHashMap<String, String>();
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		if (empId != 0) {
			if (!returnPerm(compId + ", emp_item_access, emp_sales_item_access, emp_pos_item_access, emp_invoice_item_access, emp_prod_item_access, emp_service_item_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			inputObj = new JSONObject(input);
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			switch (requestType) {

				case "add" : // add
					if (!returnPerm(compId + ", emp_item_add, emp_sales_item_add, emp_pos_item_add, emp_invoice_item_add, emp_prod_item_add, emp_service_item_add", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					catId = "0";
					getValues(inputObj);
					addFields(session, response);
					break;

				case "update" :// update
					if (!returnPerm(compId + ", emp_item_edit, emp_sales_item_edit, emp_pos_item_edit, emp_invoice_item_edit, emp_prod_item_edit, emp_service_item_edit", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					catId = "0";
					getValues(inputObj);
					addFields(session, response);
					break;

				case "delete" :// delete
					if (!returnPerm(compId + ", emp_item_delete, emp_sales_item_delete, emp_pos_item_delete, emp_invoice_item_delete, emp_prod_item_delete, emp_service_item_delete", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					if (!inputObj.isNull("catId")) {
						catId = CNumeric(PadQuotes(inputObj.getString("catId")));
						if (!inputObj.isNull("catId")) {
							catId = inputObj.getString("catId");
						}
						if (!catId.equals("0")) {
							deleteFields(catId, response);
						}
					}
					break;
			}
		}
		return output;
	}

	private void getValues(JSONObject inputObj) throws JSONException {
		if (!inputObj.isNull("catId")) {
			catId = CNumeric(PadQuotes(inputObj.getString("catId")));
		}
		if (!inputObj.isNull("catName")) {
			catName = PadQuotes(inputObj.getString("catName"));
		}
		if (!inputObj.isNull("catParentId")) {
			catParentId = CNumeric(PadQuotes(inputObj.getString("catParentId")));
		}
	}

	private void validateFields() {
		msg = "";
		if (catParentId.equals("0")) {
			msg += "<br>Enter Parent Category!";
		}
		if (catName.equals("")) {
			msg += "<br>Enter Name!";
		}
		StrSql += " AND catParentId = " + catParentId;
		StrSql += " AND  catName = '" + catName + "'";
		if (requestType.equals("update")) {
			StrSql += " AND catId != " + catId + "";
		}
		if (inventoryCatFilterImp.findItemName(StrSql) != null) {
			List<AxelaInventoryCat> axelaInventoryCat = inventoryCatFilterImp.findItemName(StrSql);
			if (!axelaInventoryCat.isEmpty()) {
				for (AxelaInventoryCat objects : axelaInventoryCat) {
					if (objects.getCatName().equals(catName)) {
						msg += "<br>Similar Name found!";
						break;
					}
				}
			}
		}
	}

	private void addFields(HttpSession session, HttpServletResponse response) throws ParseException {
		validateFields();
		AxelaInventoryCat axelaInventorycat = null;
		AxelaInventoryCatPop axelaInventoryCatPop = null;
		String[] updateInventoryCatPop = null;
		if (msg.equals("")) {
			if (!catId.equals("0")) {
				axelaInventorycat = inventoryCatRepository.findOne(Integer.parseInt(catId));
				axelaInventoryCatPop = inventoryCatPopRepository.findByCatId(Integer.parseInt(catId));
			} else {
				axelaInventorycat = new AxelaInventoryCat();
				axelaInventoryCatPop = new AxelaInventoryCatPop();
			}
			axelaInventorycat.setCatId(Integer.parseInt(catId));
			axelaInventorycat.setCatParentId(Integer.parseInt(catParentId));
			axelaInventorycat.setCatName(catName);
			axelaInventorycat.setCatActive(catActive);
			if (catId.equals("0") && requestType.equals("add")) {
				axelaInventorycat.setCatEntryId(empId);
				axelaInventorycat.setCatEntryDate(getTimeByZone(session));
				axelaInventorycat.setCatModifiedId(0);
			} else if (!catId.equals("0") && requestType.equals("update")) {
				axelaInventorycat.setCatModifiedId(empId);
				axelaInventorycat.setCatModifiedDate(getTimeByZone(session));
			}
			String catId = inventoryCatRepository.save(axelaInventorycat).getCatId() + "";
			if (!catId.equals("0")) {
				inventoryCatPopRepository.deleteAll();
				updateCatPop("0");
			}

			if (!catId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("successmsg", "Category Added Successfully!");
				output.put("catId", axelaInventorycat.getCatId() + "");
			} else if (!catId.equals("0") && requestType.equals("update")) {
				output.put("catId", axelaInventorycat.getCatId() + "");
				output.put("successmsg", "Category Updated Successfully!");
			}

		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}
	private void deleteFields(String catId, HttpServletResponse response) {
		msg = "";
		int axelaInventoryCat = 0;
		List<AxelaInventoryCat> findChildCategory = null;
		String findtitemCategory = "0";
		if (catId.equals("1")) {
			msg = "<br>Cannot Delete First Record!";
		}
		else {
			axelaInventoryCat = inventoryCatRepository.findAssociationCatParentId(Integer.parseInt(catId));
			findChildCategory = inventoryCatFilterImp.findCategoryAssociatedwitChild(catId);
			findtitemCategory = inventoryItemRepository.findItemItemtypeId(Integer.parseInt(catId));
			if (axelaInventoryCat != 0) {
				msg = msg + "<br>Category has Sub Category(s)!";
			}
			if (!findChildCategory.isEmpty()) {
				msg = msg + "<br>Category is a Child Category!";
			}
			if (!findtitemCategory.equals("0")) {
				msg = msg + "<br>Category is associated with a Product!";
			}
			if (msg.equals("")) {
				inventoryCatRepository.delete(Integer.parseInt(catId));
				inventoryCatPopRepository.delete(Integer.parseInt((catId)));
				output.put("successmsg", "Category Deleted Successfully");
			} else {
				response.setStatus(400);
				output.put("errormsg", msg);
			}
		}
	}

	public Map categoryPOpulateFields(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		output = new LinkedHashMap();
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		if (empId != 0) {
			if (!returnPerm(compId + ", emp_item_access, emp_sales_item_access, emp_pos_item_access, emp_invoice_item_access, emp_prod_item_access, emp_service_item_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			HashMap<String, String> map = new HashMap<String, String>();
			AxelaEmp emp = null;
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			String catId = "0";
			if (!inputObj.isNull("catId")) {
				catId = inputObj.getString("catId");
			}
			if (!catId.equals("0")) {
				AxelaInventoryCat axelaInventoryCat = inventoryCatRepository.findOne(Integer.parseInt(catId));
				if (axelaInventoryCat != null) {
					map.put("catName", axelaInventoryCat.getCatName());
					map.put("catParentId", "" + axelaInventoryCat.getCatParentId());
					map.put("catParentId", "" + axelaInventoryCat.getCatParentId());
					if (axelaInventoryCat.getCatEntryId() != 0 && axelaInventoryCat.getCatEntryDate().equals("")) {
						emp = axelaEmpRepository.findByEmpId(axelaInventoryCat.getCatEntryId());
						map.put("catEntryId", axelaInventoryCat.getCatEntryId() + "");
						map.put("catEntryBy", PadQuotes(emp.getEmpName()));
						map.put("catEntryDate", strToShortDate(axelaInventoryCat.getCatEntryDate()));
					}
					if (axelaInventoryCat.getCatModifiedId() != 0 && !axelaInventoryCat.getCatModifiedDate().equals("")) {
						emp = axelaEmpRepository.findByEmpId(axelaInventoryCat.getCatModifiedId());
						map.put("catModifiedId", axelaInventoryCat.getCatModifiedId() + "");
						map.put("catModifiedBy", PadQuotes(emp.getEmpName()));
						map.put("catModifiedDate", strToShortDate(axelaInventoryCat.getCatModifiedDate()));
					}
				}
				list.add(map);
				output.put("populateData", list);
			}
		}
		return output;
	}

	public Map<String, String> PopulateInventoryConfigDetails(String input, HttpServletResponse response) throws JSONException {
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		String empId = "0";
		page = 0;
		output = new LinkedHashMap();
		inputObj = new JSONObject(input);
		String ledger_id = "0";
		if (!inputObj.isNull("empId")) {
			empId = inputObj.getString("empId");
		}
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
			output.put("PopulateInventoryConfigDetails", list.toString());
		} else {
			output.put("erromsg", "No Data Found!");
		}
		return output;
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		perPage = CNumeric(getSession("empRecperPage", session));
		if (empId != 0) {
			if (!returnPerm(compId + ", emp_item_access, emp_sales_item_access, emp_pos_item_access, emp_invoice_item_access, emp_prod_item_access, emp_service_item_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			String customerType = "";
			String strOrderBy = "";
			String strSearch = "";
			List<AxelaInventoryCat> categoryList = null;
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
			if (!inputObj.isNull("requestType")) {
				requestType = PadQuotes((inputObj.getString("requestType")));
			}
			perPage = CNumeric(getSession("emp_recperpage", session));
			if (perPage.equals("0")) {
				perPage = "25";
			}
			if (orderType.equals("")) {
				orderType = "DESC";
			}
			if (orderByField.equals("")) {
				orderByField = "catId";
			}
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			page++;
			strSearch += branchAccess + exeAccess;
			strOrderBy = " ORDER BY cat." + orderByField + " " + orderType;
			categoryList = inventoryCatFilterImp.findAll(strSearch, strOrderBy, page, Integer.parseInt(CNumeric(perPage)));
			totalCount = Integer.parseInt(inventoryCatFilterImp.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("ID", "catId", "center"));
			listHeader.add(produceHeaderData("Categories", "catName", "left"));
			// End Header Data
			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaInventoryCat obj : categoryList) {
				ArrayList<String> paramSubArr = new ArrayList<String>();
				ArrayList<ArrayList> paramArr = new ArrayList<ArrayList>();
				ArrayList type = new ArrayList();
				ArrayList value = new ArrayList();
				long itemCountParam = Long.parseLong(PadQuotes(String.valueOf((obj.getItemCount()))));
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
				value.add(PadQuotes(String.valueOf(obj.getCatId())));
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Categories
				type.add(false);
				value.add(PadQuotes(String.valueOf(obj.getCatName())));
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// End Body Data
				mapData.put("td", listData);
				ArrayList<String> catUpdateAction = new ArrayList<String>();
				ArrayList<String> itemList = new ArrayList<String>();
				catUpdateAction.add("updateCategory");
				catUpdateAction.add(PadQuotes(String.valueOf(obj.getCatId())));
				itemList.add("itemLIst");
				itemList.add(PadQuotes(String.valueOf(obj.getCatId())));
				mapAction.put("td", produceActionData(catUpdateAction, itemList, itemCountParam));
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

	private ArrayList<HashMap> produceActionData(ArrayList<String> catUpdateAction, ArrayList<String> itemList, long itemCount) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();

		mapBodyData.put("value", "Update Category");
		mapBodyData.put("param", catUpdateAction);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "List Items(" + itemCount + ")");
		mapBodyData.put("param", itemList);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "cat.*"));
		list.add(buildSmartArr("Cat ID", "numeric", "cat.catId"));
		list.add(buildSmartArr("Name", "text", "cat.catName"));
		list.add(buildSmartArr("Active", "boolean", "cat.catActive"));
		// list.add(buildSmartArr("Entry By", "text", "cat.catEntryId IN (SELECT emp_id FROM compdb.axela_emp WHERE emp_name"));
		list.add(buildSmartArr("Entry Date", "date", "cat.catEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "cat.catModifiedId IN (SELECT emp_id FROM compdb.axela_emp WHERE emp_name"));
		list.add(buildSmartArr("Modified Date", "date", "cat.catModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

	public void updateCatPop(String catParentId) {
		String StrSql = "", binName = "";
		int rank = 0;
		List<AxelaInventoryCatPop> listaxelaInventoryCatPop = new ArrayList<AxelaInventoryCatPop>();
		StrSql = "SELECT NEW AxelaInventoryCat("
				+ " catId,"
				+ " catActive,"
				+ " catName,"
				+ " catParentId)"
				+ " FROM AxelaInventoryCat cat "
				+ " WHERE cat.catParentId ="
				+ catParentId
				+ " order by cat.catName ";
		List<AxelaInventoryCat> listCat = inventoryCatFilterImp.UpdateCatPop(StrSql);
		for (AxelaInventoryCat cats : listCat) {
			rank++;
			catParentId = "" + cats.getCatId();
			if (catParentId.equals("0")) {
				binName = cats.getCatName();
			} else {
				binName = populateCatStr("" + cats.getCatId());
			}
			AxelaInventoryCatPop axelaInventoryCatPop = new AxelaInventoryCatPop();
			axelaInventoryCatPop.setCatId(cats.getCatId());
			axelaInventoryCatPop.setCatName(cats.getCatName());
			axelaInventoryCatPop.setCatRank(rank);
			axelaInventoryCatPop.setCatActive(cats.getCatActive());
			listaxelaInventoryCatPop.add(axelaInventoryCatPop);
			updateCatPop(catParentId);
		}
		inventoryCatPopRepository.save(listaxelaInventoryCatPop);
	}

	public String populateCatStr(String catId) {
		String catName = "", StrSql = "", catParentId = "0";
		if (!CNumeric(catId).equals("0")) {
			StrSql = "SELECT NEW AxelaInventoryCat("
					+ "cat.catId,"
					+ " cat.catName,"
					+ " cat.catParentId)"
					+ " FROM AxelaInventoryCat cat"
					+ " WHERE cat.catId =" + catId + "";
			List<AxelaInventoryCat> listCats = inventoryCatFilterImp.GetCatName(StrSql);
			for (AxelaInventoryCat cats : listCats) {
				catName += cats.getCatName();
				catParentId = "" + cats.getCatParentId();
				if (!catParentId.equals("0")) {
					while (!catParentId.equals("0")) {
						StrSql = "SELECT NEW AxelaInventoryCat("
								+ "cat.catId,"
								+ " cat.catName,"
								+ " cat.catParentId)"
								+ " FROM AxelaInventoryCat cat"
								+ " WHERE cat.catId =" + catParentId + "";

						List<AxelaInventoryCat> listCatsParent = inventoryCatFilterImp.GetCatName(StrSql);
						for (AxelaInventoryCat bins : listCatsParent) {
							catName += bins.getCatName() + " > " + catName;
							catParentId = "" + bins.getCatParentId();
						}
					}
				}
			}
		}
		return catName;
	}
}
