package axela.sales.service;

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
import axela.customer.model.AxelaCustomer;
import axela.portal.model.AxelaSalesOpprBrochure;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;
import axela.sales.repository.BrochureRepository;

@Service
public class BrochureService extends Connect
{

	@Autowired
	BrochureRepository brochureRepository;
	@Autowired
	EmpRepository empRepository;
	@Autowired
	PortalFilterImpl portalFilterImpl;

	public String brochureId = "0";
	public String brochureBranchId = "0";
	public String brochureData = "";
	public String brochureEntryDate = "";
	public String brochureEntryId = "0";
	public String brochureTitle = "";
	public String brochureModifiedDate = "";
	public String brochureItemId = "0";
	public String modelName = "";
	public String brochureModifiedId = "0";
	public String brochureRank = "0";
	public String brochureValue = "";
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
	public String branchId = "0";
	public String modelId = "0";
	public String itemId = "0";
	HashMap output = null;
	JSONObject inputObj = null;

	public Map<String, String> brochureService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
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

				case "add" : // add an brochure.
					getValues(inputObj);
					addFields(response);
					break;

				case "update" :// update an brochure.
					getValues(inputObj);
					addFields(response);
					break;

				case "delete" :// delete an brochure.
					if (!inputObj.isNull("brochureId")) {
						brochureId = inputObj.getString("brochureId");
					}
					if (!brochureId.equals("0")) {
						deleteFields(brochureId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("brochureId")) {
			brochureId = CNumeric(inputObj.getString("brochureId"));
		}
		if (!inputObj.isNull("brochureBranchId")) {
			brochureBranchId = CNumeric(inputObj.getString("brochureBranchId"));
		}
		if (!inputObj.isNull("brochureData")) {
			brochureData = PadQuotes(inputObj.getString("brochureData"));
		}
		if (!inputObj.isNull("brochureTitle")) {
			brochureTitle = PadQuotes(inputObj.getString("brochureTitle"));
		}
		if (!inputObj.isNull("brochureItemId")) {
			brochureItemId = CNumeric(inputObj.getString("brochureItemId"));
		}
		if (!inputObj.isNull("modelName")) {
			modelName = PadQuotes(inputObj.getString("modelName"));
		}
		if (!inputObj.isNull("brochureValue")) {
			brochureValue = PadQuotes(inputObj.getString("brochureValue"));
		}
	}

	public void validateFields() {

		if (brochureId.equals("0")) {
			msg += "Enter  Id!";
		}
	}

	public String validateListFields() {
		msg = "";
		if (branchId.equals("0")) {
			msg += "Enter Branch !";
		}
		if (modelId.equals("0")) {
			msg += "Enter Model !";
		}
		return msg;
	}

	public void addFields(HttpServletResponse response) throws ParseException {
		// validateFields();
		output = new HashMap();
		if (msg.equals("")) {
			AxelaSalesOpprBrochure axelasalesopprbrochure = null;
			if (!brochureId.equals("0")) {
				axelasalesopprbrochure = brochureRepository.findByBrochureId(Integer.parseInt(brochureId));
			} else {
				axelasalesopprbrochure = new AxelaSalesOpprBrochure();
			}
			axelasalesopprbrochure.setBrochureId(Integer.parseInt(brochureId));
			axelasalesopprbrochure.setBrochureBranchId(Integer.parseInt(brochureBranchId));
			axelasalesopprbrochure.setBrochureData((brochureData).getBytes());
			axelasalesopprbrochure.setBrochureRank(brochureRepository.findRank());
			axelasalesopprbrochure.setBrochureValue(brochureValue);
			axelasalesopprbrochure.setBrochureTitle(brochureTitle);
			if (brochureId.equals("0") && requestType.equals("add")) {
				axelasalesopprbrochure.setBrochureEntryId(empId);
				axelasalesopprbrochure.setBrochureEntryDate(stringToDate(toLongDate(kknow())));
				axelasalesopprbrochure.setBrochureModifiedDate(stringToDate(""));
				axelasalesopprbrochure.setBrochureModifiedId(0);
			} else if (!brochureId.equals("0") && requestType.equals("update")) {
				axelasalesopprbrochure.setBrochureModifiedId(empId);
				axelasalesopprbrochure.setBrochureModifiedDate(stringToDate(toLongDate(kknow())));
			}
			String brochureId = brochureRepository.save(axelasalesopprbrochure).getBrochureId() + "";
			if (!brochureId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("brochureId", brochureId);
				output.put("successmsg", "Brochure Added Successfully!");
			} else if (!brochureId.equals("0") && requestType.equals("update")) {
				output.put("brochureId", brochureId);
				output.put("successmsg", "Brochure Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String brochureId) {
		brochureRepository.delete(Integer.parseInt(brochureId));
		output.put("successmsg", "Brochure Deleted Successfully!");
	}

	public Map populateData(String input) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("brochureId")) {
			brochureId = PadQuotes(CNumeric(inputObj.getString("brochureId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!brochureId.equals("0")) {
			AxelaSalesOpprBrochure axelasalesopprbrochure = brochureRepository.findByBrochureId(Integer.parseInt(brochureId));
			HashMap map = new HashMap();
			map.put("brochureId", brochureId);
			map.put("brochureBranchId", String.valueOf(axelasalesopprbrochure.getBrochureBranchId()));
			map.put("brochureData", String.valueOf(axelasalesopprbrochure.getBrochureData()));
			map.put("brochureTitle", String.valueOf(axelasalesopprbrochure.getBrochureTitle()));
			map.put("brochureItemId", String.valueOf(axelasalesopprbrochure.getBrochureItemId()));
			map.put("brochureValue", String.valueOf(axelasalesopprbrochure.getBrochureValue()));
			if (axelasalesopprbrochure.getBrochureEntryId() != 0) {
				map.put("brochureEntryDate", strToShortDate(axelasalesopprbrochure.getBrochureEntryDate()));
				map.put("brochureEntryId", String.valueOf(axelasalesopprbrochure.getBrochureEntryId()));
				map.put("brochureEntryBy", empRepository.findEmpName(axelasalesopprbrochure.getBrochureEntryId()));
			}
			if (axelasalesopprbrochure.getBrochureModifiedId() != 0) {
				map.put("brochureModifiedDate", strToShortDate(axelasalesopprbrochure.getBrochureModifiedDate()));
				map.put("brochureModifiedId", String.valueOf(axelasalesopprbrochure.getBrochureModifiedId()));
				map.put("brochureModifiedBy", empRepository.findEmpName(axelasalesopprbrochure.getBrochureModifiedId()));
			}
			list.add(map);
		}
		output.put("populateData", list);
		return output;
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		modelId = "0";
		itemId = "0";
		branchId = "0";
		requestType = "";
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		strOrderBy = "";
		if (empId != 0) {
			page = 0;
			output = new LinkedHashMap<String, String>();
			String customerType = "";
			List<AxelaCustomer> customerList = null;
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			PageRequest request = null;
			if (!inputObj.isNull("requestType")) {
				requestType = PadQuotes((inputObj.getString("requestType")));
			}
			if (!inputObj.isNull("branchId")) {
				branchId = CNumeric((inputObj.getString("branchId")));
			}
			if (!inputObj.isNull("modelId")) {
				modelId = CNumeric((inputObj.getString("modelId")));
			}
			if (!inputObj.isNull("itemId")) {
				itemId = CNumeric((inputObj.getString("itemId")));
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
				orderByField = "brochureId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			strSearch = "";
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			if (validateListFields().equals(""))
			{
				if (modelId.equals("0") && itemId.equals("0")) {
					strSearch += " AND (brochure.brochureItemId=0)";
				} else if (!modelId.equals("0") && itemId.equals("0")) {
					strSearch += " AND (item.itemModelId = " + modelId + ")";
				} else if (!modelId.equals("0") && !itemId.equals("0")) {
					strSearch = " AND (brochure.brochureItemId = " + itemId + ") ";
				} else if (modelId.equals("0") && !itemId.equals("0")) {
					strSearch += " AND (brochure.brochureItemId =0)";
				}
				strSearch += " AND brochure.brochureBranchId = " + branchId;
				strOrderBy = " ORDER BY brochure." + orderByField + " " + orderType + "";
				List<AxelaSalesOpprBrochure> resultSet = portalFilterImpl.findBoucherDetail(strSearch, strOrderBy, page, Integer.parseInt(perPage));
				String length = portalFilterImpl.totalCount;
				Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
				int count = 0;
				// Start Header Data
				listHeader.add(produceHeaderData("Model", "modelName", "center"));
				listHeader.add(produceHeaderData("Item", "itemName", "center"));
				listHeader.add(produceHeaderData("Brochure", "brochureData", "center"));
				// End Header Data

				// Start Body Align
				listBodyAlign.add(produceBodyAlign("left"));
				listBodyAlign.add(produceBodyAlign("left"));
				listBodyAlign.add(produceBodyAlign("left"));
				listBodyAlign.add(produceBodyAlign("left"));
				// End Body Align
				StringBuilder dataString = null;
				for (AxelaSalesOpprBrochure obj : resultSet) {
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
					// Model
					type.add(false);
					value.add(String.valueOf(obj.getModelName()));
					listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					// Item
					type.add(false);
					value.add(String.valueOf(obj.getItemName()));
					listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					// Brochure
					type.add(false);
					type.add(false);
					type.add(true);
					value.add(obj.getBrochureId() + "");
					value.add(obj.getBrochureTitle());
					value.add(obj.getBrochureData() + "");
					paramArr.add((ArrayList) paramSubArr.clone());
					listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					paramSubArr.clear();
					// End Body data
					mapData.put("td", listData);
					ArrayList actionParam = new ArrayList();
					actionParam.add("updateBrochure");
					actionParam.add(PadQuotes(String.valueOf(obj.getBrochureId())));
					ArrayList actionParam1 = new ArrayList();
					actionParam.add("updateTitle");
					actionParam.add(PadQuotes(String.valueOf(obj.getBrochureId())));
					mapAction.put("td", produceActionData(actionParam, actionParam1));
					listAction.add(mapAction);
					listBody.add(mapData);
				}
				output.put("meta", mapNavi);
				output.put("action", listAction);
				output.put("tdalign", listBodyAlign);
				output.put("thead", listHeader);
				output.put("tbody", listBody);
			} else {
				output.put("errormsg", msg);
			}
		}
		return output;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<HashMap> produceActionData(ArrayList<String> Param, ArrayList<String> Param1) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Brochure");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		mapBodyData.put("value", "Update Title");
		mapBodyData.put("param", Param1);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}
}
