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
import axela.portal.model.AxelaFinanceComp;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.FinancecompanyRepository;
import axela.portal.repository.PortalFilterImpl;

@Service
public class FinancecompanyService extends Connect {

	@Autowired
	FinancecompanyRepository financecompanyRepository;
	@Autowired
	EmpRepository empRepository;
	@Autowired
	PortalFilterImpl portalFilterImpl;

	public String fincompId = "0";
	public String fincompEntryDate = "";
	public String fincompEntryId = "0";
	public String fincompModifiedDate = "";
	public String fincompModifiedId = "0";
	public String fincompActive = "0";
	public String fincompName = "";
	public String requestType = "";
	public String msg = "";
	public String pageNumber = "";
	public int empId = 0;
	public int compId = 0;
	public int page = 0;
	public String perpage = "0";
	public String sort = "";
	public String field = "";
	public static int length = 0;
	public String branchAccess = "";
	public String perPage = "0";
	public String strSearch = "";
	public String orderType = "";
	public String orderByField = "";
	public String strOrderBy = "";

	HashMap output = null;
	JSONObject inputObj = null;

	public Map<String, String> financecompanyService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
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
					SOP("coming ");
					fincompId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "update" :// update
					fincompId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "delete" :// delete
					if (!inputObj.isNull("fincompId")) {
						fincompId = inputObj.getString("fincompId");
					}
					if (!fincompId.equals("0")) {
						deleteFields(fincompId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("fincompId")) {
			fincompId = CNumeric(inputObj.getString("fincompId"));
		}
		if (!inputObj.isNull("fincompName")) {
			fincompName = PadQuotes(inputObj.getString("fincompName"));
		}
		if (!inputObj.isNull("fincompActive")) {
			fincompActive = (inputObj.getString("fincompActive")) + "";
		}
	}

	public void validateFields() {
		if (fincompName.equals("")) {
			msg += "Enter Name!";
		}
		else {
			List<AxelaFinanceComp> obj = null;
			if (requestType.equals("add")) {
				obj = financecompanyRepository.findByFincompName(fincompName);
			}
			else if (requestType.equals("update")) {
				obj = financecompanyRepository.findFincompName(Integer.parseInt(fincompId), fincompName);
			}
			if (!obj.isEmpty()) {
				msg += "<br>Similar Finance Company Name found!";
			}
		}
	}

	public void addFields(HttpServletResponse response) throws ParseException {
		validateFields();
		if (msg.equals("")) {
			AxelaFinanceComp AxelaFinanceComp = null;
			if (!fincompId.equals("0")) {
				AxelaFinanceComp = financecompanyRepository.findByFincompId(Integer.parseInt(fincompId));
			} else {
				AxelaFinanceComp = new AxelaFinanceComp();
			}
			AxelaFinanceComp.setFincompId(Integer.parseInt(fincompId));
			AxelaFinanceComp.setFincompName(fincompName);
			AxelaFinanceComp.setFincompActive(fincompActive);
			if (fincompId.equals("0") && requestType.equals("add")) {
				AxelaFinanceComp.setFincompEntryId(empId);
				AxelaFinanceComp.setFincompEntryDate(stringToDate(toLongDate(kknow())));
				AxelaFinanceComp.setFincompModifiedId(0);
			} else if (!fincompId.equals("0") && requestType.equals("update")) {
				AxelaFinanceComp.setFincompModifiedId(empId);
				AxelaFinanceComp.setFincompModifiedDate(stringToDate(toLongDate(kknow())));
			}
			String fincompId = financecompanyRepository.save(AxelaFinanceComp).getFincompId() + "";

			if (!fincompId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("fincompId", fincompId);
				output.put("successmsg", "Finance Company Added Successfully!");
			} else if (!fincompId.equals("0") && requestType.equals("update")) {
				output.put("successmsg", "Finance Company Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String fincompId) {
		financecompanyRepository.delete(Integer.parseInt(fincompId));
		output.put("successmsg", "Finance Company Deleted Successfully!");
	}

	public Map populateData(String input) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("fincompId")) {
			fincompId = PadQuotes(CNumeric(inputObj.getString("fincompId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!fincompId.equals("0")) {
			AxelaFinanceComp financeComp = financecompanyRepository.findByFincompId(Integer.parseInt(fincompId));
			HashMap map = new HashMap();
			map.put("fincompId", fincompId);
			map.put("fincompName", String.valueOf(financeComp.getFincompName()));
			map.put("fincompActive", (Integer.parseInt(financeComp.getFincompActive())));
			if (financeComp.getFincompEntryId() != 0) {
				map.put("fincompEntryDate", strToShortDate(financeComp.getFincompEntryDate()));
				map.put("fincompEntryId", String.valueOf(financeComp.getFincompEntryId()));
				map.put("fincompEntryBy", empRepository.findEmpName(financeComp.getFincompEntryId()));
			}
			if (financeComp.getFincompModifiedId() != 0) {
				map.put("fincompModifiedDate", strToShortDate(financeComp.getFincompModifiedDate()));
				map.put("fincompModifiedId", String.valueOf(financeComp.getFincompModifiedId()));
				map.put("fincompModifiedBy", empRepository.findEmpName(financeComp.getFincompModifiedId()));
			}
			list.add(map);
		}
		output.put("populateData", list);
		return output;
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		String strSearch = "";
		String strOrderBy = "";
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
				orderByField = "fincompId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strOrderBy = " ORDER BY comp." + orderByField + " " + orderType + "";
			List<AxelaFinanceComp> resultSet = portalFilterImpl.findfincompName(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			String length = portalFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Finance Company Name", "fincompName", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaFinanceComp obj : resultSet) {
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
				// Activity details.
				type.add(false);
				value.add(String.valueOf(obj.getFincompName()));
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// End Body data
				mapData.put("td", listData);
				ArrayList actionParam = new ArrayList();
				actionParam.add("updateFincomp");
				actionParam.add(PadQuotes(String.valueOf(obj.getFincompId())));
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
		mapBodyData.put("value", "Update Finance Company");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "comp.*"));
		list.add(buildSmartArr("Finance Company ID", "numeric", "comp.fincompId"));
		list.add(buildSmartArr("Finance Company Name", "text", "comp.fincompName"));
		list.add(buildSmartArr("Active", "boolean", "comp.fincompActive"));
		// list.add(buildSmartArr("Entry By", "text", "comp.industryEntryId in (select emp_id from compdb.axela_emp where emp_name"));
		list.add(buildSmartArr("Entry Date", "date", "comp.industryEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "comp.industryModifiedId in (select emp_id from compdb.axela_emp where emp_name"));
		list.add(buildSmartArr("Modified Date", "date", "comp.industryModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

}
