package axela.service.service;

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
import axela.portal.model.AxelaEmp;
import axela.portal.repository.EmpRepository;
import axela.service.model.AxelaServiceJcCheck;
import axela.service.repository.ServiceJcCheckFilterImpl;
import axela.service.repository.ServiceJcCheckRepository;

@Service
public class JobCardCheckListService extends Connect {

	private final static int PAGESIZE = 25;
	public String checkId = "0";
	public String checkItemId = "0";
	public String itemModelId = "0";
	public String checkName = "";
	public String checkType = "";
	public String checkEntryId = "0";
	public String checkEntryDate = "";
	public String checkModifiedId = "0";
	public String checkModifiedDate = "";

	public String requestType = "";

	public String msg = "";
	public int empId = 0;
	public int compId = 0;
	public String pageNumber = "";
	HashMap output = null;
	JSONObject inputObj = null;
	public String sortField = "";
	public String sortDirection = "";
	public int page = 0;
	public String perPage = "0";
	String branches = "";
	public String strSearch = "";
	public String branchAccess = "";
	public String exeAccess = "";
	public int length = 0;
	public int totalCount = 0;

	@Autowired
	private ServiceJcCheckRepository serviceJcCheckRepository;

	@Autowired
	ServiceJcCheckFilterImpl serviceJcCheckFilterImpl;

	@Autowired
	EmpRepository empRepository;

	public Map<String, String> jcCheckListService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();

		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		switch (requestType) {
			case "add" :
				checkId = "0";
				getValues(inputObj);
				addFields(response, session);
				break;

			case "update" :
				checkId = "0";
				getValues(inputObj);
				addFields(response, session);
				break;

			case "delete" :
				if (!inputObj.isNull("checkId")) {
					checkId = inputObj.getString("checkId");
				}
				if (!checkId.equals("0")) {
					deleteFields(checkId);
				}
				break;

		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("checkId")) {
			checkId = CNumeric(PadQuotes(inputObj.getString("checkId")));
		}
		if (!inputObj.isNull("checkItemId")) {
			checkItemId = CNumeric(PadQuotes(inputObj.getString("checkItemId")));
		}
		if (!inputObj.isNull("itemModelId")) {
			itemModelId = CNumeric(PadQuotes(inputObj.getString("itemModelId")));
		}
		if (!inputObj.isNull("checkName")) {
			checkName = inputObj.getString("checkName");
		}
		if (!inputObj.isNull("checkType")) {
			checkType = inputObj.getString("checkType");
		}
		if (!inputObj.isNull("checkEntryId")) {
			checkEntryId = CNumeric(PadQuotes(inputObj.getString("checkEntryId")));
		}
		if (!inputObj.isNull("checkEntryDate")) {
			checkEntryDate = inputObj.getString("checkEntryDate");
		}
		if (!inputObj.isNull("checkModifiedId")) {
			checkModifiedId = CNumeric(PadQuotes(inputObj.getString("checkModifiedId")));
		}
		if (!inputObj.isNull("checkModifiedDate")) {
			checkModifiedDate = inputObj.getString("checkModifiedDate");
		}

	}

	public void validateFields() {
		msg = "";
		List<AxelaServiceJcCheck> axelaServiceJcCheck = null;

		if (checkName.equals("")) {
			msg = "<br>Enter Job Card Check Name!";
		} else {
			axelaServiceJcCheck = serviceJcCheckRepository.findJcCheckNameExcludingCurrentId(Integer.parseInt(checkId), checkName);
			if (!axelaServiceJcCheck.isEmpty()) {
				msg += "<br>Similar Job Card Check found!";
			}
		}

		if (checkItemId.equals("0")) {
			msg = msg + "<br>Select Job Card Check Item!";
		}
	}
	public void addFields(HttpServletResponse response, HttpSession session) throws ParseException {
		validateFields();
		AxelaServiceJcCheck axelaServiceJcCheck = null;
		if (msg.equals("")) {
			if (!checkId.equals("0")) {
				axelaServiceJcCheck = serviceJcCheckRepository.findOne(Integer.parseInt(checkId));
			} else {
				axelaServiceJcCheck = new AxelaServiceJcCheck();
			}
			axelaServiceJcCheck.setCheckId(Integer.parseInt(checkId));
			axelaServiceJcCheck.setCheckItemId(Integer.parseInt(checkItemId));
			axelaServiceJcCheck.setItemModelId(Integer.parseInt(itemModelId));
			axelaServiceJcCheck.setCheckName(checkName);
			axelaServiceJcCheck.setCheckType(checkType);
			if (checkId.equals("0") && requestType.equals("add")) {
				axelaServiceJcCheck.setCheckEntryId(empId);
				axelaServiceJcCheck.setCheckEntryDate(getTimeByZone(session));
			} else if (!checkId.equals("0") && requestType.equals("update")) {
				axelaServiceJcCheck.setCheckEntryId(axelaServiceJcCheck.getCheckEntryId());
				axelaServiceJcCheck.setCheckEntryDate(axelaServiceJcCheck.getCheckEntryDate());
				axelaServiceJcCheck.setCheckModifiedId(empId);
				axelaServiceJcCheck.setCheckModifiedDate(getTimeByZone(session));
			}
			checkId = String.valueOf(serviceJcCheckRepository.save(axelaServiceJcCheck).getCheckId());
			if (!checkId.equals("0") && requestType.equals("add")) {
				output.put("checkId", checkId);
				output.put("successmsg", "Job Card Check List Added successfully!");
			} else if (!checkId.equals("0") && requestType.equals("update")) {
				output.put("checkId", checkId);
				output.put("successmsg", "Job Card Check List Updated successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String checkId) {
		serviceJcCheckRepository.delete(Integer.parseInt(checkId));
		output.put("successmsg", "Job Card Status Deleted successfully!");
	}

	public Map<String, List> populateData(String input) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		LinkedHashMap map = new LinkedHashMap();
		if (!inputObj.isNull("checkId")) {
			checkId = CNumeric(PadQuotes(inputObj.getString("checkId")));
		}
		if (!checkId.equals("0")) {
			AxelaServiceJcCheck axelaServiceJcCheck = serviceJcCheckRepository.findByCheckId(Integer.parseInt(checkId));

			if (axelaServiceJcCheck != null) {
				map.put("checkItemId", axelaServiceJcCheck.getCheckItemId());
				map.put("checkModelId", axelaServiceJcCheck.getItemModelId());
				map.put("checkName", axelaServiceJcCheck.getCheckName());
				AxelaEmp axelaEmp = empRepository.findByEmpId(axelaServiceJcCheck.getCheckEntryId());
				if (axelaServiceJcCheck.getCheckEntryId() != 0) {
					map.put("checkEntryDate", strToShortDate(axelaServiceJcCheck.getCheckEntryDate()));
					map.put("checkEntryBy", empRepository.findEmpName(axelaServiceJcCheck.getCheckEntryId()));
					map.put("checkEntryId", axelaServiceJcCheck.getCheckEntryId());
				}
				if (axelaServiceJcCheck.getCheckModifiedId() != 0) {
					map.put("checkModifiedDate", strToShortDate(axelaServiceJcCheck.getCheckModifiedDate()));
					map.put("checkModifiedBy", empRepository.findEmpName(axelaServiceJcCheck.getCheckModifiedId()));
					map.put("checkModifiedId", axelaServiceJcCheck.getCheckModifiedId());
				}
				list.add(map);
				output.put("populateData", list);
			}
		}
		return output;
	}

	public Map listData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		page = 0;
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			perPage = CNumeric(getSession("empRecperpage", session));
			List<AxelaServiceJcCheck> statusList = null;
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			PageRequest request = null;
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			if (!inputObj.isNull("sortField")) {
				sortField = PadQuotes((inputObj.getString("sortField")));
			}
			if (!inputObj.isNull("pageIndex")) {
				page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
			}
			if (!inputObj.isNull("sortDirection")) {
				sortDirection = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
			}
			// perPage = CNumeric(getSession("emp_recperpage", session));
			if (perPage.equals("0")) {
				perPage = "25";
			}
			if (sortDirection.equals("")) {
				sortDirection = "DESC";
			}
			if (sortField.equals("")) {
				sortField = "checkId";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			String strOrderBy = " ORDER BY jccheck." + sortField + " " + sortDirection;
			statusList = serviceJcCheckFilterImpl.findAllJcCheck(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			totalCount = Integer.parseInt(serviceJcCheckFilterImpl.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("ID", "checkId", "center"));
			listHeader.add(produceHeaderData("Job Card Check Details", "checkName", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaServiceJcCheck obj : statusList) {
				ArrayList<String> param = new ArrayList<String>();
				ArrayList type = new ArrayList();
				ArrayList value = new ArrayList();
				ArrayList<String> actionParam = new ArrayList<String>();
				ArrayList<ArrayList> paramArr = new ArrayList<ArrayList>();
				ArrayList<String> paramSubArr = new ArrayList<String>();
				HashMap<String, List<HashMap>> mapData = new HashMap<String, List<HashMap>>();
				HashMap<String, List<HashMap>> mapAction = new HashMap<String, List<HashMap>>();
				HashMap<String, List<String>> mapBodyData = new HashMap<String, List<String>>();
				List<HashMap> listData = new ArrayList<HashMap>();
				count++;

				type.add(false);
				value.add(count);
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				type.add(false);
				value.add(obj.getCheckId());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				type.add(false);
				value.add(obj.getCheckName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				mapData.put("td", listData);
				actionParam.add("updateJCCheck");
				actionParam.add(obj.getCheckId() + "");
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
				SOP("output==========Service==========" + output.toString());
			}
		}
		return output;
	}
	private ArrayList<HashMap> produceActionData(ArrayList<String> actionParam) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Job Card Check");
		mapBodyData.put("param", actionParam);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart(HttpSession session) {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		String customerName = getSession("configCustomerName", session);
		output = new LinkedHashMap();

		list.add(buildSmartArr("Keyword", "text", "jccheck.*"));
		list.add(buildSmartArr("Check ID", "numeric", "jccheck.checkId"));
		list.add(buildSmartArr("Check Name", " text", "jccheck.checkName"));
		// list.add(buildSmartArr("Entry By", "text", "customerEntryId in (select empId from compdb.axela_emp where emp_name"));
		list.add(buildSmartArr("Entry Date", "date", "jccheck.checkEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "customerModifiedId in (select emp_id from compdb.axela_emp where emp_name"));
		list.add(buildSmartArr("Modified Date", "date", "jccheck.checkModifiedDate"));
		// list.add(buildSmartArr("Custom Fields", "text", "customer_id IN (SELECT cftrans_row_id FROM compdb.axela_cf_trans WHERE cftrans_submodule_id = 1 and cftrans_value"));
		output.put("drSmart", list.toArray());
		return output;
	}

}
