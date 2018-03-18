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
import axela.customer.model.AxelaCustomer;
import axela.inventory.repository.InventoryTaxFilterImpl;
import axela.portal.model.AxelaTax;
import axela.portal.model.TaxRepository;
import axela.portal.repository.EmpRepository;
@Service
public class TaxService extends Connect {

	@Autowired
	InventoryTaxFilterImpl inventoryTaxFilterImpl;
	@Autowired
	TaxRepository taxRepository;
	@Autowired
	EmpRepository empRepository;

	public String taxId = "0";
	private String taxEntryDate = "";
	public String taxEntryId = "0";
	private String taxModifiedDate = "";
	public String taxModifiedId = "0";
	private String taxName = "";
	public String taxValue = "0.0";
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

	public Map taxService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		perPage = getSession("perPage", session);
		perPage = CNumeric(getSession("empRecperpage", session));
		if (empId != 0) {
			if (!returnPerm(compId + ", emp_role_id", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			inputObj = new JSONObject(input);
			output = new HashMap();
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			switch (requestType) {
				case "add" : // add
					taxId = "0";
					getValues(inputObj);
					addFields(session, response);
					break;
				case "update" :// update
					taxId = "0";
					getValues(inputObj);
					addFields(session, response);
					break;
				case "delete" :// delete
					if (!inputObj.isNull("taxId")) {
						taxId = inputObj.getString("taxId");
					}
					if (!taxId.equals("0")) {
						deleteFields(taxId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("taxId")) {
			taxId = CNumeric(inputObj.getString("taxId"));
		}
		if (!inputObj.isNull("taxName")) {
			taxName = PadQuotes(inputObj.getString("taxName"));
		}
		if (!inputObj.isNull("taxValue")) {
			taxValue = CNumeric(inputObj.getString("taxValue"));
		}

	}

	public void validateFields() {
		msg = "";
		List<AxelaTax> obj = null;
		if (taxName.equals("")) {
			msg = msg + "<br>Enter Name!";
		} else {

			if (requestType.equals("add")) {
				obj = taxRepository.findByTaxName(taxName);
			}
			else if (requestType.equals("update")) {
				obj = taxRepository.findTaxName(Integer.parseInt(taxId), taxName);
			}
			if (!obj.isEmpty()) {
				msg += "<br>Similar Name found!";
			}
		}
		if (taxValue.equals("")) {
			msg = msg + "<br>Enter Value!";
		}
		if (!isNumeric(taxValue)) {
			msg = msg + "<br>Tax Value Must be Numeric!";
		}
	}
	public void addFields(HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		validateFields();
		output = new HashMap();
		if (msg.equals("")) {
			AxelaTax axelaTax = null;
			if (!taxId.equals("0")) {
				axelaTax = taxRepository.findByTaxId(Integer.parseInt(taxId));
			} else {
				axelaTax = new AxelaTax();
			}
			axelaTax.setTaxId(Integer.parseInt(taxId));
			axelaTax.setTaxName(taxName);
			axelaTax.setTaxValue(Double.parseDouble(taxValue));
			if (taxId.equals("0") && requestType.equals("add")) {
				axelaTax.setTaxEntryId(empId);
				axelaTax.setTaxEntryDate(getTimeByZone(session));
				axelaTax.setTaxModifiedDate(stringToDate(""));
				axelaTax.setTaxModifiedId(0);
			} else if (!taxId.equals("0") && requestType.equals("update")) {
				axelaTax.setTaxModifiedId(empId);
				axelaTax.setTaxModifiedDate(getTimeByZone(session));
			}
			String taxId = taxRepository.save(axelaTax).getTaxId() + "";
			if (!taxId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("taxId", taxId);
				output.put("successmsg", "Tax Added Successfully!");
			} else if (!taxId.equals("0") && requestType.equals("update")) {
				output.put("taxId", taxId);
				output.put("successmsg", "Tax Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String taxId) {
		taxRepository.delete(Integer.parseInt(taxId));
		output.put("successmsg", "Tax Deleted Successfully!");

	}

	public Map populateData(String input, HttpSession session) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			if (!returnPerm(compId + ", emp_role_id", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			if (!inputObj.isNull("taxId")) {
				taxId = PadQuotes(CNumeric(inputObj.getString("taxId")));
			}
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			if (!taxId.equals("0")) {
				AxelaTax axelaTax = taxRepository.findByTaxId(Integer.parseInt(taxId));
				HashMap map = new HashMap();
				map.put("taxId", taxId);
				map.put("taxName", String.valueOf(axelaTax.getTaxName()));
				map.put("taxValue", String.valueOf(axelaTax.getTaxValue()));
				if (axelaTax.getTaxEntryId() != 0) {
					map.put("taxEntryDate", strToShortDate(axelaTax.getTaxEntryDate()));
					map.put("taxEntryId", String.valueOf(axelaTax.getTaxEntryId()));
					map.put("taxEntryBy", empRepository.findEmpName(axelaTax.getTaxEntryId()));
				}
				if (axelaTax.getTaxModifiedId() != 0) {
					map.put("taxModifiedDate", strToShortDate(axelaTax.getTaxModifiedDate()));
					map.put("taxModifiedId", String.valueOf(axelaTax.getTaxModifiedId()));
					map.put("taxModifiedBy", empRepository.findEmpName(axelaTax.getTaxModifiedId()));
				}
				list.add(map);
			}
			output.put("populateData", list);
		}
		return output;
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		String strSearch = "";
		String strOrderBy = "";
		if (empId != 0) {
			if (!returnPerm(compId + ", emp_role_id", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
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
				orderByField = "taxId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strOrderBy = " ORDER BY tax." + orderByField + " " + orderType + "";
			List<AxelaTax> resultSet = inventoryTaxFilterImpl.findTax(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			String length = inventoryTaxFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Tax Details", "taxName", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaTax obj : resultSet) {
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
				// details.
				type.add(false);
				value.add(String.valueOf(obj.getTaxName()));
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// End Body data
				mapData.put("td", listData);
				ArrayList actionParam = new ArrayList();
				actionParam.add("updateTax");
				actionParam.add(PadQuotes(String.valueOf(obj.getTaxId())));
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

	@SuppressWarnings("unchecked")
	public ArrayList<HashMap> produceActionData(ArrayList<String> Param) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Tax");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "tax.*"));
		list.add(buildSmartArr("Tax ID", "numeric", "tax.taxId"));
		list.add(buildSmartArr("Tax Name", "text", "tax.taxName"));
		list.add(buildSmartArr("Tax Value", "text", "tax.taxValue"));
		// list.add(buildSmartArr("Entry By", "text", "tax.tax_entry_id in (SELECT emp_id FROM compdb.axela_emp WHERE emp_name"));
		list.add(buildSmartArr("Entry Date", "date", "tax.taxEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "tax.tax_modified_id in (SELECT emp_id FROM compdb.axela_emp WHERE emp_name"));
		list.add(buildSmartArr("Modified Date", "date", "tax.taxModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

}
