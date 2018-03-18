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
import axela.service.model.AxelaServiceJcCat;
import axela.service.repository.jcCategoryRepository;

@Service
public class JobCardCategoryService extends Connect {
	private final static int PAGESIZE = 25;
	public String jccatId = "0";
	public String jccatEntryDate = "";
	public String jccatEntryId = "0";
	public String jccatModifiedDate = "";
	public String jccatModifiedId = "0";
	public String jccatName = "";
	JSONObject inputObj = null;
	public String requestType = "";
	public String msg = "";
	public String pageNumber = "";
	public int empId = 0;
	public int compId = 0;
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
	HashMap output = null;

	@Autowired
	private jcCategoryRepository jccategoryrepository;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	PortalFilterImpl portalFilterImpl;

	public Map<String, String> jcCategoryService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();

		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}

		switch (requestType) {

			case "add" :
				jccatId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "update" :
				jccatId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "delete" :
				if (!inputObj.isNull("jccatId")) {
					jccatId = inputObj.getString("jccatId");
				}
				if (!jccatId.equals("0")) {
					deleteFields(jccatId);
				}
				break;
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("jccatId")) {
			jccatId = inputObj.getString("jccatId");
		}
		if (!inputObj.isNull("jccatEntryDate")) {
			jccatEntryDate = inputObj.getString("jccatEntryDate");
		}
		if (!inputObj.isNull("jccatEntryId")) {
			jccatEntryId = inputObj.getString("jccatEntryId");
		}
		if (!inputObj.isNull("jccatModifiedDate")) {
			jccatModifiedDate = inputObj.getString("jccatModifiedDate");
		}
		if (!inputObj.isNull("jccatModifiedId")) {
			jccatModifiedId = inputObj.getString("jccatModifiedId");
		}
		if (!inputObj.isNull("jccatName")) {
			jccatName = inputObj.getString("jccatName");
		}
	}

	public void checkForm() {
		if (jccatName.equals("")) {
			msg = "<br>Enter Job Card Category Name!";
		}
	}

	public void addFields(HttpServletResponse response) throws ParseException {

		checkForm();
		output = new HashMap();
		if (msg.equals("")) {
			AxelaServiceJcCat axelaServiceJcCat = null;
			if (!jccatId.equals("0")) {
				axelaServiceJcCat = jccategoryrepository.findOne(Integer.parseInt(jccatId));
			} else {
				axelaServiceJcCat = new AxelaServiceJcCat();
			}
			axelaServiceJcCat.setJccatId(Integer.parseInt(jccatId));
			axelaServiceJcCat.setJccatName(jccatName);
			if (jccatId.equals("0") && requestType.equals("add")) {
				axelaServiceJcCat.setJccatEntryId(empId);
				axelaServiceJcCat.setJccatEntryDate(stringToDate(toLongDate(kknow())));
				axelaServiceJcCat.setJccatModifiedId(0);
			} else if (!jccatId.equals("0") && requestType.equals("update")) {
				axelaServiceJcCat.setJccatModifiedId(empId);
				axelaServiceJcCat.setJccatModifiedDate(stringToDate(toLongDate(kknow())));
			}
			jccatId = jccategoryrepository.save(axelaServiceJcCat).getJccatId() + "";
			if (jccatId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("successmsg", "Job Card Category Added Successfully!");
			} else if (!jccatId.equals("0") && requestType.equals("update")) {
				output.put("successmsg", "Job Card Category Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String jccatId) {
		jccategoryrepository.delete(Integer.parseInt(jccatId));
		output.put("successmsg", "Job Card Category Deleted Successfully!");
	}

	public Map populateData(String input) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("jccatId")) {
			jccatId = PadQuotes(CNumeric(inputObj.getString("jccatId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!jccatId.equals("0")) {
			AxelaServiceJcCat axelaServiceJcCat = jccategoryrepository.findOne(Integer.parseInt(jccatId));
			HashMap map = new HashMap();
			map.put("jccatId", jccatId);
			map.put("jccatName", axelaServiceJcCat.getJccatName());
			if (axelaServiceJcCat.getJccatEntryId() != 0) {
				map.put("jccatEntryDate", strToShortDate(axelaServiceJcCat.getJccatEntryDate()));
				map.put("jccatEntryBy", empRepository.findEmpName(axelaServiceJcCat.getJccatEntryId()));
				map.put("jccatEntryId", axelaServiceJcCat.getJccatEntryId());
			}
			if (axelaServiceJcCat.getJccatModifiedId() != 0) {
				map.put("jccatModifiedDate", strToShortDate(axelaServiceJcCat.getJccatModifiedDate()));
				map.put("jccatModifiedBy", empRepository.findEmpName(axelaServiceJcCat.getJccatModifiedId()));
				map.put("jccatModifiedId", axelaServiceJcCat.getJccatModifiedId());
			}
			list.add(map);
		}
		output.put("populateData", list);
		return output;
	}

	public Map listData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		page = 0;
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			List<AxelaServiceJcCat> categoryList = null;
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
				sortField = "jccatId";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			String strOrderBy = " ORDER BY jccat." + sortField + " " + sortDirection;
			categoryList = portalFilterImpl.findAllJcCategory(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			totalCount = Integer.parseInt(PortalFilterImpl.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Job Card Category Details", "jccatName", "center"));
			// End Header Data

			// Start Body Align
			// listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaServiceJcCat obj : categoryList) {
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
				value.add(obj.getJccatName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				mapData.put("td", listData);
				actionParam.add("updateJCCategory");
				actionParam.add(obj.getJccatId() + "");
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
		mapBodyData.put("value", "Update Job Card Category");
		mapBodyData.put("param", actionParam);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "jccat.*"));
		list.add(buildSmartArr("Category ID", "numeric", "jccat.titleId"));
		list.add(buildSmartArr("Category Name", "text", "jccat.titleName"));
		// list.add(buildSmartArr("Entry By", "text", "jccat.titleEntryId)"));
		list.add(buildSmartArr("Entry Date", "date", "jccat.titleEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "jccat.titleModifiedId"));
		list.add(buildSmartArr("Modified Date", "date", "jccat.titleModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

}
