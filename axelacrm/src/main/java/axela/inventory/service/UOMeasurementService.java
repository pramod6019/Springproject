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
import axela.inventory.model.AxelaInventoryUom;
import axela.inventory.repository.InventoryItemRepository;
import axela.inventory.repository.UOMRepository;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.UomFilterImpl;

@Service
public class UOMeasurementService extends Connect {
	private final static int PAGESIZE = 25;
	public String uomId = "0";
	public String uomEntryDate = "";
	public String uomEntryId = "0";
	public String uomModifiedDate = "";
	public String uomModifiedId = "0";
	public String uomName = "";
	public int empId = 0;
	public String uomParentId = "0";
	public String uomRatio = "0.0";
	public String uomShortname = "";
	public String requestType = "";
	public String msg = "";
	public String pageNumber = "";
	public String perPage = "";
	public String tag = "UOM";
	public String orderByField = "";
	public int page = 0;
	public String orderType = "";
	public String StrSql = "";
	HashMap output = null;
	JSONObject inputObj = null;
	@Autowired
	private UOMRepository uomrepository;

	@Autowired
	InventoryItemRepository inventoryItemRepository;

	@Autowired
	UomFilterImpl uomFilterImpl;

	@Autowired
	EmpRepository empRepository;

	public Map<String, String> uoMeasurementService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			switch (requestType) {
				case "add" : // add an uom.
					uomId = "0";
					getValues(inputObj);
					addFields(response);
					break;
				case "update" :// update an uom.
					uomId = "0";
					getValues(inputObj);
					addFields(response);
					break;
				case "delete" :// delete an uom.
					if (!inputObj.isNull("uomId")) {
						uomId = inputObj.getString("uomId");
					}
					if (!uomId.equals("0")) {
						deleteFields(uomId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("uomId")) {
			uomId = CNumeric(PadQuotes(inputObj.getString("uomId")));
		}
		if (!inputObj.isNull("uomEntryDate")) {
			uomEntryDate = PadQuotes(inputObj.getString("uomEntryDate"));
		}
		if (!inputObj.isNull("uomEntryId")) {
			uomEntryId = CNumeric(PadQuotes(inputObj.getString("uomEntryId")));
		}
		if (!inputObj.isNull("uomModifiedDate")) {
			uomModifiedDate = PadQuotes(inputObj.getString("uomModifiedDate"));
		}
		if (!inputObj.isNull("uomModifiedId")) {
			uomModifiedId = CNumeric(PadQuotes(inputObj.getString("uomModifiedId")));
		}
		if (!inputObj.isNull("uomName")) {
			uomName = PadQuotes(inputObj.getString("uomName"));
		}
		if (!inputObj.isNull("uomParentId")) {
			uomParentId = CNumeric(PadQuotes(inputObj.getString("uomParentId")));
		}

		if (!inputObj.isNull("uomRatio")) {
			uomRatio = PadQuotes(inputObj.getString("uomRatio"));
		}
		if (!inputObj.isNull("uomShortname")) {
			uomShortname = PadQuotes(inputObj.getString("uomShortname"));
		}
	}

	public void validateFields() {
		msg = "";
		if (uomName.equals("")) {
			msg += "Enter Name!<br>";
		}
		else {
			SOP("uomName=========" + uomName);
			SOP("uomId=========" + uomId);
			String obj = uomrepository.findByUomName(uomName, Integer.parseInt(uomId));
			SOP("obj=====" + obj);
			if (!obj.equals("0")) {
				msg = msg + "Similar UOM Found!<br>";
			}
		}
		if (uomShortname.equals("")) {
			msg += "Enter Short Name!<br>";
		}
		if (!uomParentId.equals("0")) {
			if (uomRatio.equals("")) {
				msg += "Enter Ratio!<br>";
			}
		} else {
			uomRatio = "1";
		}
	}

	public void addFields(HttpServletResponse response) throws ParseException {
		validateFields();
		AxelaInventoryUom axelainventoryuom = null;
		if (msg.equals("")) {
			if (!uomId.equals("0")) {
				axelainventoryuom = uomrepository.findOne(Integer.parseInt(uomId));
			} else {
				axelainventoryuom = new AxelaInventoryUom();
			}
			axelainventoryuom.setUomId(Integer.parseInt(uomId));
			axelainventoryuom.setUomName(uomName);
			axelainventoryuom.setUomParentId(Integer.parseInt(uomParentId));
			axelainventoryuom.setUomRatio(Double.parseDouble(uomRatio));
			axelainventoryuom.setUomShortname(uomShortname);
			if (requestType.equals("add")) {
				axelainventoryuom.setUomEntryDate(stringToDate(toLongDate(kknow())));
				axelainventoryuom.setUomEntryId(empId);
				axelainventoryuom.setUomModifiedId(0);
			} else {
				axelainventoryuom.setUomEntryDate(axelainventoryuom.getUomEntryDate());
				axelainventoryuom.setUomEntryId(axelainventoryuom.getUomEntryId());
				axelainventoryuom.setUomModifiedId(empId);
				axelainventoryuom.setUomModifiedDate(stringToDate(toLongDate(kknow())));
			}
			AxelaInventoryUom result = null;
			result = uomrepository.save(axelainventoryuom);
			if (result != null && requestType.equals("add")) {
				output.put("successmsg", "UOM Added Successfully!");
				output.put("uomId", result.getUomId() + "");
			} else if (result != null && requestType.equals("update")) {
				output.put("successmsg", "UOM Updated Successfully!");
				output.put("uomId", result.getUomId() + "");
			}
		} else {
			response.setStatus(400);
			output.put("errormsg", msg);
		}
	}

	public Map populateData(String input, HttpSession session, HttpServletResponse respose) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		if (AppRun().equals("0")) {
			SOP("inputObj=====populateData======" + inputObj.toString(2));
		}
		if (!inputObj.isNull("uomId")) {
			uomId = PadQuotes(CNumeric(inputObj.getString("uomId")));
		}
		if (!uomId.equals("0")) {
			List<AxelaInventoryUom> obj = uomFilterImpl.findAllpopulate(Integer.parseInt(uomId));
			for (AxelaInventoryUom axelainventoryuom : obj) {
				map.put("uomName", "" + axelainventoryuom.getUomName());
				map.put("uomShortname", String.valueOf(axelainventoryuom.getUomShortname()));
				map.put("uomRatio", String.valueOf(axelainventoryuom.getUomRatio()));
				if (uomRatio.equals("0.00")) {
					uomRatio = "";
				}
				map.put("uomParentId", String.valueOf(axelainventoryuom.getUomParentId()));
				if (axelainventoryuom.getUomEntryId() != 0) {
					map.put("uomEntryDate", strToShortDate(axelainventoryuom.getUomEntryDate()));
					map.put("uomEntryId", String.valueOf(axelainventoryuom.getUomEntryId()));
					map.put("uomEntryBy", empRepository.findEmpName((axelainventoryuom.getUomEntryId())));
				}
				if (axelainventoryuom.getUomModifiedId() != 0) {
					map.put("uomModifiedDate", strToShortDate(axelainventoryuom.getUomModifiedDate()));
					map.put("uomModifiedId", String.valueOf(axelainventoryuom.getUomModifiedId() + ""));
					map.put("uomModifiedBy", empRepository.findEmpName(axelainventoryuom.getUomModifiedId()));
				}
				list.add(map);
			}
			output.put("populateData", list);
		}
		return output;
	}
	public void deleteFields(String uomId) {
		StrSql = CNumeric(PadQuotes(String.valueOf(uomrepository.findByUomParentId(Integer.parseInt(uomId)))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with Another Uom!";
		}
		StrSql = CNumeric(PadQuotes(String.valueOf(inventoryItemRepository.findByitemUomId(Integer.parseInt(uomId)))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with Item!";
		}
		if (msg.equals("")) {
			uomrepository.delete(Integer.parseInt(uomId));
			output.put("succesmsg", "UOM Deleted Successfully!");
		}
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		perPage = CNumeric(getSession("empRecperpage", session));
		String strOrderBy = "";
		String strSearch = "";
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			List<AxelaInventoryUom> axelainventoryuom = null;
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
			if (orderType.equals("")) {
				orderType = "DESC";
			}
			if (orderByField.equals("")) {
				orderByField = "uomId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;

			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strOrderBy = " ORDER BY uom." + orderByField + " " + orderType + "";
			axelainventoryuom = uomFilterImpl.findAll(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			String length = uomFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Name", "uomName", "center"));
			listHeader.add(produceHeaderData("Parent", "uomParentName", "center"));
			listHeader.add(produceHeaderData("Ratio", "uomRatio", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaInventoryUom obj : axelainventoryuom) {
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
				// UomName
				type.add(false);
				value.add(String.valueOf(obj.getUomName()));
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// uomParentName
				type.add(false);
				value.add(String.valueOf(obj.getUomParentName()));
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// uomRatio
				type.add(false);
				value.add(String.valueOf(obj.getUomRatio()));
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// End Body data
				ArrayList actionParam = new ArrayList();
				mapData.put("td", listData);
				actionParam.add("updateUOM");
				actionParam.add(PadQuotes(String.valueOf(obj.getUomId())));
				mapAction.put("td", produceActionData(actionParam));
				listAction.add(mapAction);
				listBody.add(mapData);
			}
			output.put("meta", mapNavi);
			output.put("thead", listHeader);
			output.put("tdalign", listBodyAlign);
			output.put("tbody", listBody);
			output.put("action", listAction);
			if (AppRun().equals("0")) {
				SOP("output==========UOMService==========" + output.toString());
			}
		}
		return output;
	}

	private ArrayList<HashMap> produceActionData(ArrayList<String> Param) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update UOM");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "uom.*"));
		list.add(buildSmartArr("Measurment ID", "numeric", "uom.uomId"));
		list.add(buildSmartArr("Name", "text", "uom.uomName"));
		list.add(buildSmartArr("Parent ID", "numeric", "uom.uomParentId"));
		// list.add(buildSmartArr("Entry By", "text", "uom.uomEntryId IN(select emp.empId from AxelaEmp emp where emp.empName)"));
		list.add(buildSmartArr("Entry Date", "date", "uom.uomEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "uom.uomModifiedId in (select empId from AxelaEmp emp where emp.empName"));
		list.add(buildSmartArr("Modified Date", "date", "uom.uomModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

}
