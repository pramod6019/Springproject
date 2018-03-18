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
import axela.inventory.model.AxelaInventoryItemModel;
import axela.inventory.repository.InventoryItemModelFilterImp;
import axela.inventory.repository.InventoryItemModelRepository;
import axela.inventory.repository.InventoryItemRepository;
import axela.portal.repository.EmpRepository;
import axela.sales.repository.OpprRepository;

@Service
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class InventoryItemModelService extends Connect {
	@Autowired
	InventoryItemModelRepository inventoryItemModelRepository;
	@Autowired
	InventoryItemModelFilterImp inventoryItemModelFilterImp;
	@Autowired
	InventoryItemRepository inventoryItemRepository;
	@Autowired
	EmpRepository empRepository;
	@Autowired
	OpprRepository opprRepository;

	// fields
	public String modelId = "0";
	public String modelActive = "0";
	public String modelDesc = "";
	public String modelEntryDate = "";
	public String modelEntryId = "0";
	public String modelModifiedDate = "";
	public String modelModifiedId = "0";
	public String modelName = "";
	public String msg = "";
	public int page = 0;
	public String perPage = "0";
	public String sort = "Desc";
	public int empId = 0;
	public String field = "", value = "";
	// configuration
	public String configInventoryLocationName = "";
	public String configSalesOpprName = "";
	public String branchAccess = "", exeAccess = "";
	public String ExeAccess = "";
	public String empFormatDate = "";
	public String keyword = "";
	private String orderByField = "";
	private String orderType = "";
	public String pageNumber = "";
	public String property = "";
	public String strSearch = "";
	public int totalCount = 0;
	public String requesttype = "";
	public String requestType = "";
	public int compId = 0;
	public String perpage = "0";
	public String strOrderBy = "";

	LinkedHashMap output = null;
	JSONObject inputObj = null;

	public Map itemModelService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		configSalesOpprName = getSession("configSalesOpprName", session);
		perPage = getSession("perPage", session);
		perPage = CNumeric(getSession("empRecperpage", session));
		if (empId != 0) {
			if (!returnPerm(compId + ",emp_role_id", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			inputObj = new JSONObject(input);
			output = new LinkedHashMap();
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			switch (requestType) {
				case "add" : // add
					modelId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;
				case "update" :// update
					modelId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;
				case "delete" :// delete
					if (!inputObj.isNull("modelId")) {
						modelId = inputObj.getString("modelId");
					}
					if (!modelId.equals("0")) {
						deleteFields(modelId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("modelId")) {
			modelId = CNumeric(inputObj.getString("modelId"));
		}
		if (!inputObj.isNull("modelActive")) {
			modelActive = CNumeric(inputObj.getString("modelActive"));
		}
		if (!inputObj.isNull("modelDesc")) {
			modelDesc = PadQuotes(inputObj.getString("modelDesc"));
		}
		if (!inputObj.isNull("modelName")) {
			modelName = PadQuotes(inputObj.getString("modelName"));
		}
	}

	public void validateFields() {
		List<AxelaInventoryItemModel> obj = null;
		if (modelName.equals("")) {
			msg += "Enter SOE Name!";
		} else {
			if (requestType.equals("add")) {
				obj = inventoryItemModelRepository.findByModelName(modelName);
			}
			else if (requestType.equals("update")) {
				obj = inventoryItemModelRepository.findModelName(Integer.parseInt(modelId), modelName);
			}
			if (!obj.isEmpty()) {
				msg += "<br>Similar Item Model Found!";
			}
		}
		if (modelDesc.equals("")) {
			msg = msg + "<br>Enter Description!";
		}

		if (modelDesc.length() > 255) {
			modelDesc = modelDesc.substring(0, 254);
		}
	}

	public void addFields(HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		validateFields();
		output = new LinkedHashMap();
		if (msg.equals("")) {
			AxelaInventoryItemModel axelaInventoryItemModel = null;
			if (!modelId.equals("0")) {
				axelaInventoryItemModel = inventoryItemModelRepository.findByModelId(Integer.parseInt(modelId));
			} else {
				axelaInventoryItemModel = new AxelaInventoryItemModel();
			}
			axelaInventoryItemModel.setModelId(Integer.parseInt(modelId));
			axelaInventoryItemModel.setModelActive(modelActive);
			axelaInventoryItemModel.setModelDesc(modelDesc);
			axelaInventoryItemModel.setModelName(modelName);
			if (modelId.equals("0") && requestType.equals("add")) {
				axelaInventoryItemModel.setModelEntryId(empId);
				axelaInventoryItemModel.setModelEntryDate(getTimeByZone(session));
				axelaInventoryItemModel.setModelModifiedDate(stringToDate(""));
				axelaInventoryItemModel.setModelModifiedId(0);
			} else if (!modelId.equals("0") && requestType.equals("update")) {
				axelaInventoryItemModel.setModelModifiedId(empId);
				axelaInventoryItemModel.setModelModifiedDate(getTimeByZone(session));
			}
			String modelId = inventoryItemModelRepository.save(axelaInventoryItemModel).getModelId() + "";
			if (!modelId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("modelId", modelId);
				output.put("successmsg", "Item Model Added Successfully!");
			} else if (!modelId.equals("0") && requestType.equals("update")) {
				output.put("modelId", modelId);
				output.put("successmsg", "Item Model Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String modelId) {
		msg = "";
		String strSearch = "";
		int resultModelId = 0;
		int resultOpprId = 0;

		if (!modelId.equals("0")) {
			resultModelId = inventoryItemRepository.itemModelchecking(Integer.parseInt(modelId));
			if (resultModelId != 0) {
				msg = msg + "Model is associated with a Item(s)!";
			}
			resultOpprId = opprRepository.opprModelCheking(Integer.parseInt(modelId));
			if (resultOpprId != 0) {
				msg = msg + "Model is associated with a " + configSalesOpprName + "!";
			}
		}
		if (modelId.equals("1")) {
			msg = msg + "<br>Cannot delete first record!";
		}
		if (msg.equals("")) {
			inventoryItemModelRepository.delete(Integer.parseInt(modelId));
			output.put("successmsg", "Item Model Deleted Successfully!");
		} else {
			output.put("msg", msg);
		}
	}

	public Map populateData(String input, HttpSession session) throws JSONException, ParseException {
		output = new LinkedHashMap();
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		if (empId != 0)
		{
			if (!returnPerm(compId + ",emp_role_id", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			if (!inputObj.isNull("modelId")) {
				modelId = PadQuotes(CNumeric(inputObj.getString("modelId")));
			}
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			if (!modelId.equals("0")) {
				AxelaInventoryItemModel axelaInventoryItemModel = inventoryItemModelRepository.findByModelId(Integer.parseInt(modelId));
				HashMap map = new HashMap();
				map.put("modelId", modelId);
				map.put("modelActive", String.valueOf(axelaInventoryItemModel.getModelActive()));
				map.put("modelDesc", String.valueOf(axelaInventoryItemModel.getModelDesc()));
				map.put("modelName", String.valueOf(axelaInventoryItemModel.getModelName()));
				if (axelaInventoryItemModel.getModelEntryId() != 0) {
					map.put("ModelEntryDate", strToShortDate(axelaInventoryItemModel.getModelEntryDate()));
					map.put("ModelEntryId", String.valueOf(axelaInventoryItemModel.getModelEntryId()));
					map.put("ModelEntryBy", empRepository.findEmpName(axelaInventoryItemModel.getModelEntryId()));
				}
				if (axelaInventoryItemModel.getModelModifiedId() != 0) {
					map.put("ModelModifiedDate", strToShortDate(axelaInventoryItemModel.getModelModifiedDate()));
					map.put("ModelModifiedId", String.valueOf(axelaInventoryItemModel.getModelModifiedId()));
					map.put("ModelModifiedBy", empRepository.findEmpName(axelaInventoryItemModel.getModelModifiedId()));
				}
				list.add(map);
			}
			output.put("populateData", list);
		}

		return output;
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		page = 0;
		modelId = "0";
		// SOP("input"+input)
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		perPage = CNumeric(getSession("empRecperPage", session));
		configInventoryLocationName = PadQuotes(getSession("empId", session));
		String strSearch = "";
		String strOrderBy = "";
		if (empId != 0) {
			if (!returnPerm(compId + ",emp_role_id", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			// branchAccess = getSession("branchAccess", session).replaceAll("branchId", "itemModal.customerBranchId");
			// exeAccess = getSession("exeAccess", session).replaceAll("empId", "itemModal.customerEmpId");
			List<AxelaInventoryItemModel> itemModalList = null;
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			PageRequest request = null;
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
			if (!inputObj.isNull("modelId")) {
				modelId = CNumeric(PadQuotes((inputObj.getString("modelId"))));
			}
			perPage = "25";
			if (perPage.equals("0")) {
				perPage = "25";
			}
			if (orderType.equals("")) {
				orderType = "DESC";
			}
			if (orderByField.equals("")) {
				orderByField = "modelId";
			}
			if (!modelId.equals("0")) {
				strSearch = " AND itemModel.modelId=" + modelId;
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			strOrderBy = " ORDER BY itemModel." + orderByField + " " + orderType;
			itemModalList = inventoryItemModelFilterImp.findAll(strSearch, strOrderBy, page, Integer.parseInt(CNumeric(perPage)));
			String length = inventoryItemModelFilterImp.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("ID", "modalId", "center"));
			listHeader.add(produceHeaderData("Model Details", "modalName", "center"));
			// End Header Data
			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align
			for (AxelaInventoryItemModel obj : itemModalList) {
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
				value.add(obj.getModelId());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Name
				type.add(false);
				value.add(obj.getModelName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// End Of The Body
				mapData.put("td", listData);
				ArrayList<String> modalUpdateAction = new ArrayList<String>();
				modalUpdateAction.add("updateModel");
				modalUpdateAction.add(PadQuotes(String.valueOf(obj.getModelId())));
				mapAction.put("td", produceActionData(modalUpdateAction));
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
	private ArrayList<HashMap> produceActionData(ArrayList<String> modalUpdateAction) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Model");
		mapBodyData.put("param", modalUpdateAction);
		listAction.add((HashMap) mapBodyData.clone());

		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "itemModel.*"));
		list.add(buildSmartArr("Model ID", "numeric", "itemModel.modelId"));
		list.add(buildSmartArr("Name", "text", "itemModel.modelName"));
		list.add(buildSmartArr("Desc", "text", "itemModel.modelDesc"));
		// list.add(buildSmartArr("Entry By", "text", "itemModel.modelEntryId in (SELECT emp_id FROM compdb.axela_emp WHERE emp_name"));
		list.add(buildSmartArr("Entry Date", "date", "itemModel.modelEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "itemModel.modelModifiedId in (SELECT emp_id FROM compdb.axela_emp WHERE emp_name"));
		list.add(buildSmartArr("Modified Date", "date", "itemModel.modelModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

}
