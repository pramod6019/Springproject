package axela.customer.service;

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
import axela.portal.model.AxelaTitle;
import axela.portal.repository.AxelaTitleRepository;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;
@Service
public class TitleService extends Connect
{

	private final static int PAGESIZE = 25;
	public String titleId = "0";
	public String titleDesc = "";
	public String titleEntryDate = "";
	public String groupModifiedDate = "";
	public String titleEntryId = "0";
	public String titleGender = "0";
	public String titleModifiedDate = "";
	public String titleModifiedId = "0";
	public String titleRank = "0";
	public String requestType = "";
	public String msg = "";
	public String pageNumber = "";
	public int empId = 0;
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
	JSONObject inputObj = null;
	int compId = 0;
	@Autowired
	private AxelaTitleRepository axelaTitleRepository;

	@Autowired
	PortalFilterImpl portalFilterImpl;

	@Autowired
	EmpRepository empRepository;

	public Map<String, String> titleService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();

		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		switch (requestType) {
			case "add" :
				titleId = "0";
				getValues(inputObj);
				addFields(response, session);
				break;

			case "update" :
				titleId = "0";
				getValues(inputObj);
				addFields(response, session);
				break;

			case "delete" :
				if (!inputObj.isNull("titleId")) {
					titleId = inputObj.getString("titleId");
				}
				if (!titleId.equals("0")) {
					deleteFields(titleId);
				}
				break;
		}
		return output;
	}
	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("titleId")) {
			titleId = CNumeric(inputObj.getString("titleId"));
		}
		if (!inputObj.isNull("titleDesc")) {
			titleDesc = PadQuotes(inputObj.getString("titleDesc"));
		}
		if (!inputObj.isNull("titleEntryDate")) {
			titleEntryDate = PadQuotes(inputObj.getString("titleEntryDate"));
		}
		if (!inputObj.isNull("titleEntryId")) {
			titleEntryId = CNumeric(inputObj.getString("titleEntryId"));
		}
		if (!inputObj.isNull("titleModifiedDate")) {
			titleModifiedDate = PadQuotes(inputObj.getString("titleModifiedDate"));
		}
		if (!inputObj.isNull("titleGender")) {
			titleGender = PadQuotes(inputObj.getString("titleGender"));
		}
		if (!inputObj.isNull("titleModifiedId")) {
			titleModifiedId = CNumeric(inputObj.getString("titleModifiedId"));
		}
		if (!inputObj.isNull("titleRank")) {
			titleRank = CNumeric(inputObj.getString("titleRank"));
		}
	}

	public void checkForm() {
		if (titleDesc.equals("")) {
			msg += "Enter Desc!";
		}
	}

	public void addFields(HttpServletResponse response, HttpSession session) throws ParseException {
		checkForm();
		output = new HashMap();
		if (msg.equals("")) {
			AxelaTitle axelaTitle = null;
			if (!titleId.equals("0")) {
				axelaTitle = axelaTitleRepository.findOne(Integer.parseInt(titleId));
			} else {
				axelaTitle = new AxelaTitle();
			}
			axelaTitle.setTitleId(Integer.parseInt(titleId));
			axelaTitle.setTitleDesc(titleDesc);
			axelaTitle.setTitleRank(Integer.parseInt(titleRank));
			axelaTitle.setTitleGender(titleGender);
			if (titleId.equals("0") && requestType.equals("add")) {
				axelaTitle.setTitleEntryId(empId);
				axelaTitle.setTitleEntryDate(getTimeByZone(session));
				// axelaTitle.setTitleModifiedDate("");
				axelaTitle.setTitleModifiedId(0);
			} else if (!titleId.equals("0") && requestType.equals("update")) {
				axelaTitle.setTitleModifiedId(empId);
				axelaTitle.setTitleModifiedDate(getTimeByZone(session));
			}
			titleId = axelaTitleRepository.save(axelaTitle).getTitleId() + "";
			if (!titleId.equals("0") && requestType.equals("add")) {
				output.put("successmsg", "Title Added Successfully!");
			} else if (!titleId.equals("0") && requestType.equals("update")) {
				output.put("successmsg", "Title Updated Successfully!");
			}
		} else {
			response.setStatus(400);
			output.put("errormsg", msg);
		}
	}
	public void deleteFields(String titleId) {
		axelaTitleRepository.delete(Integer.parseInt(titleId));
		output.put("successmsg", "Title Deleted Successfully!");
	}

	public Map<String, List> populateData(String input) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		LinkedHashMap map = new LinkedHashMap();
		if (!inputObj.isNull("titleId")) {
			titleId = CNumeric(PadQuotes(inputObj.getString("titleId")));
		}
		if (!titleId.equals("0")) {
			AxelaTitle axelaTitle = axelaTitleRepository.findOne(Integer.parseInt(titleId));
			if (axelaTitle != null) {
				map.put("titleDesc", axelaTitle.getTitleDesc());
				AxelaEmp axelaEmp = empRepository.findByEmpId(axelaTitle.getTitleEntryId());
				if (axelaTitle.getTitleEntryId() != 0) {
					map.put("titleEntryDate", strToShortDate(axelaTitle.getTitleEntryDate()));
					map.put("titleEntryBy", empRepository.findEmpName(axelaTitle.getTitleEntryId()));
					map.put("titleEntryId", axelaTitle.getTitleEntryId());
				}
				if (axelaTitle.getTitleModifiedId() != 0) {
					map.put("titleModifiedBy", empRepository.findEmpName(axelaTitle.getTitleModifiedId()));
					map.put("titleModifiedDate", strToShortDate(axelaTitle.getTitleModifiedDate()));
					map.put("titleModifiedId", axelaTitle.getTitleModifiedId());
				}
				list.add(map);
				output.put("populateData", list);
			}
		}
		return output;
	}

	public Map listData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		page = 0;
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			List<AxelaTitle> titleList = null;
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
				sortField = "titleId";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			String strOrderBy = " ORDER BY title." + sortField + " " + sortDirection;
			titleList = portalFilterImpl.findAllTitle(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			totalCount = Integer.parseInt(PortalFilterImpl.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;

			// Start Header Data
			listHeader.add(produceHeaderData("Title Details", "titleDesc", "center"));
			// End Header Data

			// Start Body Align
			// listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaTitle obj : titleList) {
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
				value.add(obj.getTitleDesc());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				mapData.put("td", listData);
				actionParam.add("updateTitle");
				actionParam.add(obj.getTitleId() + "");
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
		mapBodyData.put("value", "Update Title");
		mapBodyData.put("param", actionParam);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		//
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "title.*"));
		list.add(buildSmartArr("Title ID", "numeric", "title.titleId"));
		list.add(buildSmartArr("Title Desc", "text", "title.titleName"));
		// list.add(buildSmartArr("Entry By", "text", "title.titleEntryId)"));
		list.add(buildSmartArr("Entry Date", "date", "title.titleEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "title.titleModifiedId"));
		list.add(buildSmartArr("Modified Date", "date", "title.titleModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}
}
