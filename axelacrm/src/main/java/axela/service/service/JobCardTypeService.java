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
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;
import axela.service.model.AxelaServiceJcType;
import axela.service.repository.jcTypeRepository;

@Service
public class JobCardTypeService extends Connect {
	private final static int PAGESIZE = 25;
	public String jctypeId = "0";
	public String jctypeEntryDate = "";
	public String jctypeEntryId = "0";
	public String jctypeModifiedDate = "";
	public String jctypeModifiedId = "0";
	public String jctypeName = "";
	public String requestType = "";
	public String pageNumber = "";
	public String msg = "";
	public int empId = 0;
	public int compId = 0;
	public String strSearch = "";
	public String branchAccess = "";
	public String exeAccess = "";
	public String sortField = "";
	public String sortDirection = "";
	public int page = 0;
	public String perPage = "0";
	public int totalCount = 0;
	HashMap output = null;
	JSONObject inputObj = null;

	@Autowired
	private jcTypeRepository jctyperepository;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	PortalFilterImpl portalFilterImpl;

	public Map<String, String> jcTypeService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();

		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}

		switch (requestType) {

			case "add" :
				jctypeId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "update" :
				jctypeId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "delete" :
				if (!inputObj.isNull("jctypeId")) {
					jctypeId = inputObj.getString("jctypeId");
				}
				if (!jctypeId.equals("0")) {
					deleteFields(jctypeId);
				}
				break;

		}
		return output;
	}
	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("jctypeId")) {
			jctypeId = CNumeric(inputObj.getString("jctypeId"));
		}
		if (!inputObj.isNull("jctypeEntryDate")) {
			jctypeEntryDate = PadQuotes(inputObj.getString("jctypeEntryDate"));
		}
		if (!inputObj.isNull("jctypeEntryId")) {
			jctypeEntryId = CNumeric(inputObj.getString("jctypeEntryId"));
		}
		if (!inputObj.isNull("jctypeModifiedDate")) {
			jctypeModifiedDate = PadQuotes(inputObj.getString("jctypeModifiedDate"));
		}
		if (!inputObj.isNull("jctypeModifiedId")) {
			jctypeModifiedId = CNumeric(inputObj.getString("jctypeModifiedId"));
		}

		if (!inputObj.isNull("jctypeName")) {
			jctypeName = PadQuotes(inputObj.getString("jctypeName"));
		}
	}

	public void checkForm() {
		if (jctypeName.equals("")) {
			msg = "<br>Enter Job Card Type Name!";
		}
	}

	public void addFields(HttpServletResponse response) throws ParseException {
		checkForm();
		AxelaServiceJcType axelaServiceJcType = null;
		if (msg.equals("")) {
			if (!jctypeId.equals("0")) {
				axelaServiceJcType = jctyperepository.findOne(Integer.parseInt(jctypeId));
			} else {
				axelaServiceJcType = new AxelaServiceJcType();
			}
			axelaServiceJcType.setJctypeId(Integer.parseInt(jctypeId));
			axelaServiceJcType.setJctypeName(jctypeName);
			if (jctypeId.equals("0") && requestType.equals("add")) {
				axelaServiceJcType.setJctypeEntryDate(stringToDate(toLongDate(kknow())));
				axelaServiceJcType.setJctypeEntryId(empId);
				axelaServiceJcType.setJctypeModifiedDate(stringToDate(""));
				axelaServiceJcType.setJctypeModifiedId(0);
			} else if (!jctypeId.equals("0") && requestType.equals("update")) {
				axelaServiceJcType.setJctypeModifiedDate(stringToDate(toLongDate(kknow())));
				axelaServiceJcType.setJctypeModifiedId(empId);
			}
			String jctypeId = jctyperepository.save(axelaServiceJcType).getJctypeId() + "";

			if (jctypeId.equals("0") && requestType.equals("add")) {
				output.put("successmsg", "Job Card Type Added Successfully!");
			} else {
				output.put("successmsg", "Job Card Type Updated Successfully!");
			}
			jctypeId = "0";
		} else {
			response.setStatus(400);
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String jctypeId) {
		jctyperepository.delete(Integer.parseInt(jctypeId));
		output.put("successmsg", "Job Card Type Deleted Successfully!");
	}

	public Map populateData(String input) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("jctypeId")) {
			jctypeId = PadQuotes(CNumeric(inputObj.getString("jctypeId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!jctypeId.equals("0")) {
			AxelaServiceJcType axelaServiceJcType = jctyperepository.findOne(Integer.parseInt(jctypeId));
			HashMap map = new HashMap();
			map.put("jctypeName", axelaServiceJcType.getJctypeName());
			if (axelaServiceJcType.getJctypeEntryId() != 0) {
				map.put("jctypeEntryDate", strToShortDate(axelaServiceJcType.getJctypeEntryDate()));
				map.put("jctypeEntryBy", empRepository.findEmpName(axelaServiceJcType.getJctypeEntryId()));
				map.put("jctypeEntryId", axelaServiceJcType.getJctypeEntryId());
			}
			if (axelaServiceJcType.getJctypeModifiedId() != 0) {
				map.put("jctypeModifiedDate", strToShortDate(axelaServiceJcType.getJctypeModifiedDate()));
				map.put("jctypeModifiedBy", empRepository.findEmpName(axelaServiceJcType.getJctypeModifiedId()));
				map.put("jctypeModifiedId", axelaServiceJcType.getJctypeModifiedId());
			}
			list.add(map);
		}
		output.put("populateData", list);
		return output;
	}

	public Map listData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		page = 0;
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			List<AxelaServiceJcType> typeList = null;
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
				sortField = "jctypeId";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			String strOrderBy = " ORDER BY type." + sortField + " " + sortDirection;
			typeList = portalFilterImpl.findAllJcType(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			totalCount = Integer.parseInt(PortalFilterImpl.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Job Card Type Details", "jctypeId", "center"));
			// End Header Data

			// Start Body Align
			// listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaServiceJcType obj : typeList) {
				ArrayList<String> param = new ArrayList<String>();
				ArrayList type = new ArrayList();
				ArrayList value = new ArrayList();
				ArrayList<String> actionParam = new ArrayList<String>();
				ArrayList<ArrayList> paramArr = new ArrayList<ArrayList>();
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
				value.add(obj.getJctypeName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				mapData.put("td", listData);
				actionParam.add("updateJCType");
				actionParam.add(obj.getJctypeId() + "");
				mapAction.put("td", produceActionData(actionParam));

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
	private ArrayList<HashMap> produceActionData(ArrayList<String> actionParam) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Job Card Type");
		mapBodyData.put("param", actionParam);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "type.*"));
		list.add(buildSmartArr("Type ID", "numeric", "type.jctypeId"));
		list.add(buildSmartArr("Type Name", "text", "type.jctypeName"));
		// list.add(buildSmartArr("Entry By", "text", "type.groupEntryId)"));
		list.add(buildSmartArr("Entry Date", "date", "type.groupEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "type.groupModifiedId"));
		list.add(buildSmartArr("Modified Date", "date", "type.groupModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}
}
