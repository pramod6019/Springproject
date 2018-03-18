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
import axela.portal.repository.PortalFilterImpl;
import axela.portal.repository.ServiceJcPriorityRepository;
import axela.service.model.AxelaServiceJcPriority;
import axela.service.repository.JcPriorityFilterImpl;
import axela.service.repository.jobCartPriorityRepository;

@Service
public class JobCardPriorityService extends Connect {
	private final static int PAGESIZE = 25;
	public String priorityjcId = "0";
	public String priorityjcDesc = "";
	public String priorityjcDuehrs = "0.0";
	public String priorityjcEntryDate = "";
	public String priorityjcEntryId = "0";
	public String priorityjcModifiedDate = "";
	public String priorityjcModifiedId = "0";
	public String priorityjcName = "";
	public String priorityjcRank = "0";
	public String priorityjcTrigger1Hrs = "0.0";
	public String priorityjcTrigger2Hrs = "0.0";
	public String priorityjcTrigger3Hrs = "0.0";
	public String priorityjcTrigger4Hrs = "0.0";
	public String priorityjcTrigger5Hrs = "0.0";
	public String pageNumber = "";
	public int empId = 0;
	public int compId = 0;
	public String msg = "";
	public String perpage = "0";
	public String sort = "";
	public String field = "";
	public String orderType = "";
	public String orderByField = "";
	public String strOrderBy = "";
	public String sortField = "";
	public String sortDirection = "";
	public int page = 0;
	public String perPage = "0";
	String branches = "";
	public String requestType = "";
	public String strSearch = "";
	public String branchAccess = "";
	public String exeAccess = "";
	public int length = 0;
	public int totalCount = 0;
	HashMap output = null;

	JSONObject inputObj = null;
	@Autowired
	private jobCartPriorityRepository jobcartpriorityrepository;

	@Autowired
	ServiceJcPriorityRepository serviceJcPriorityRepository;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	PortalFilterImpl portalFilterImpl;

	@Autowired
	JcPriorityFilterImpl jcPriorityFilterImpl;

	public Map<String, String> jcPriorityService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		switch (requestType) {
			case "add" :
				priorityjcId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "update" :
				priorityjcId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "delete" :
				if (!inputObj.isNull("priorityjcId")) {
					priorityjcId = inputObj.getString("priorityjcId");
				}
				if (!priorityjcId.equals("0")) {
					deleteFields(priorityjcId);
				}
				break;

			case "moveup" :
				if (!inputObj.isNull("priorityjcId")) {
					priorityjcId = inputObj.getString("priorityjcId");
				}
				if (!priorityjcId.equals("0")) {
					moveUp(priorityjcId);
				}
				break;

			case "movedown" :
				if (!inputObj.isNull("priorityjcId")) {
					priorityjcId = inputObj.getString("priorityjcId");
				}
				if (!priorityjcId.equals("0")) {
					moveDown(priorityjcId);
				}
				break;
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("priorityjcId")) {
			priorityjcId = inputObj.getString("priorityjcId");
		}
		if (!inputObj.isNull("priorityjcDesc")) {
			priorityjcDesc = inputObj.getString("priorityjcDesc");
		}
		if (!inputObj.isNull("priorityjcDuehrs")) {
			priorityjcDuehrs = inputObj.getString("priorityjcDuehrs");
		}
		if (!inputObj.isNull("priorityjcEntryDate")) {
			priorityjcEntryDate = inputObj.getString("priorityjcEntryDate");
		}
		if (!inputObj.isNull("priorityjcEntryId")) {
			priorityjcEntryId = inputObj.getString("priorityjcEntryId");
		}
		if (!inputObj.isNull("priorityjcModifiedDate")) {
			priorityjcModifiedDate = inputObj.getString("priorityjcModifiedDate");
		}
		if (!inputObj.isNull("priorityjcModifiedId")) {
			priorityjcModifiedId = inputObj.getString("priorityjcModifiedId");
		}
		if (!inputObj.isNull("priorityjcName")) {
			priorityjcName = inputObj.getString("priorityjcName");
		}
		if (!inputObj.isNull("priorityjcRank")) {
			priorityjcRank = inputObj.getString("priorityjcRank");
		}
		if (!inputObj.isNull("priorityjcTrigger1Hrs")) {
			priorityjcTrigger1Hrs = inputObj.getString("priorityjcTrigger1Hrs");
		}
		if (!inputObj.isNull("priorityjcTrigger2Hrs")) {
			priorityjcTrigger2Hrs = inputObj.getString("priorityjcTrigger2Hrs");
		}
		if (!inputObj.isNull("priorityjcTrigger3Hrs")) {
			priorityjcTrigger3Hrs = inputObj.getString("priorityjcTrigger3Hrs");
		}
		if (!inputObj.isNull("priorityjcTrigger4Hrs")) {
			priorityjcTrigger4Hrs = inputObj.getString("priorityjcTrigger4Hrs");
		}
		if (!inputObj.isNull("priorityjcTrigger5Hrs")) {
			priorityjcTrigger5Hrs = inputObj.getString("priorityjcTrigger5Hrs");
		}
	}

	public void checkForm() {
		msg = "";
		if (priorityjcName.equals("")) {
			msg = "<br>Enter Priority!";
		}
		// else {
		// List<AxelaServiceJcPriority> obj = jobcartpriorityrepository.findByPriorityName(priorityjc_name);
		// if (!obj.isEmpty()) {
		// msg += "<br>Similar priority found!";
		// }
		// }
		if (priorityjcDesc.equals("")) {
			msg = msg + "<br>Enter Description!";
		}
		if (priorityjcDuehrs.equals("")) {
			msg = msg + "<br>Enter Due Hours!";
		}
	}

	public void addFields(HttpServletResponse response) throws ParseException {
		checkForm();

		if (msg.equals("")) {
			AxelaServiceJcPriority axelaServiceJcPriority = null;
			if (!priorityjcId.equals("0")) {
				axelaServiceJcPriority = jobcartpriorityrepository.findOne(Integer.parseInt(priorityjcId));
			} else {
				axelaServiceJcPriority = new AxelaServiceJcPriority();
			}
			axelaServiceJcPriority.setPriorityjcId(Integer.parseInt(priorityjcId));
			axelaServiceJcPriority.setPriorityjcDesc(priorityjcDesc);
			axelaServiceJcPriority.setPriorityjcDuehrs(priorityjcDuehrs);
			axelaServiceJcPriority.setPriorityjcName(priorityjcName);
			axelaServiceJcPriority.setPriorityjcRank(jobcartpriorityrepository.findrank());
			axelaServiceJcPriority.setPriorityjcTrigger1Hrs(priorityjcTrigger1Hrs);
			axelaServiceJcPriority.setPriorityjcTrigger2Hrs(priorityjcTrigger2Hrs);
			axelaServiceJcPriority.setPriorityjcTrigger3Hrs(priorityjcTrigger3Hrs);
			axelaServiceJcPriority.setPriorityjcTrigger4Hrs(priorityjcTrigger4Hrs);
			axelaServiceJcPriority.setPriorityjcTrigger5Hrs(priorityjcTrigger5Hrs);
			if (priorityjcId.equals("0") && requestType.equals("add")) {
				axelaServiceJcPriority.setPriorityjcEntryId(empId);
				axelaServiceJcPriority.setPriorityjcEntryDate(stringToDate(toLongDate(kknow())));
				axelaServiceJcPriority.setPriorityjcModifiedDate(stringToDate(""));
				axelaServiceJcPriority.setPriorityjcModifiedId(0);
			} else if (!priorityjcId.equals("0") && requestType.equals("update")) {
				axelaServiceJcPriority.setPriorityjcModifiedId(empId);
				axelaServiceJcPriority.setPriorityjcModifiedDate(stringToDate(toLongDate(kknow())));
			}
			priorityjcId = jobcartpriorityrepository.save(axelaServiceJcPriority).getPriorityjcId() + "";
			if (!priorityjcId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("priorityjcId", priorityjcId);
				output.put("successmsg", "Priority Added Successfully!");
			} else if (!priorityjcId.equals("0") && requestType.equals("update")) {
				output.put("priorityjcId", priorityjcId);
				output.put("successmsg", "Priority Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String priorityjcId) {
		jobcartpriorityrepository.delete(Integer.parseInt(priorityjcId));
		output.put("successmsg", "Priority Deleted Successfully!");
	}

	public Map<String, List> populateData(String input) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		LinkedHashMap map = new LinkedHashMap();
		if (!inputObj.isNull("priorityjcId")) {
			priorityjcId = CNumeric(PadQuotes(inputObj.getString("priorityjcId")));
		}
		if (!priorityjcId.equals("0")) {
			AxelaServiceJcPriority axelaServiceJcPriority = serviceJcPriorityRepository.findOne(Integer.parseInt(priorityjcId));
			if (axelaServiceJcPriority != null) {
				map.put("priorityjcId", axelaServiceJcPriority.getPriorityjcId());
				map.put("priorityjcName", axelaServiceJcPriority.getPriorityjcName());
				map.put("priorityjcDuehrs", axelaServiceJcPriority.getPriorityjcDuehrs());
				map.put("priorityjcDesc", axelaServiceJcPriority.getPriorityjcDesc());
				map.put("priorityjcRank", axelaServiceJcPriority.getPriorityjcRank());
				map.put("priorityjcTrigger1Hrs", axelaServiceJcPriority.getPriorityjcTrigger1Hrs());
				map.put("priorityjcTrigger2Hrs", axelaServiceJcPriority.getPriorityjcTrigger2Hrs());
				map.put("priorityjcTrigger3Hrs", axelaServiceJcPriority.getPriorityjcTrigger3Hrs());
				map.put("priorityjcTrigger4Hrs", axelaServiceJcPriority.getPriorityjcTrigger4Hrs());
				map.put("priorityjcTrigger5Hrs", axelaServiceJcPriority.getPriorityjcTrigger5Hrs());
				AxelaEmp axelaEmp = empRepository.findByEmpId(axelaServiceJcPriority.getPriorityjcEntryId());
				if (axelaServiceJcPriority.getPriorityjcEntryId() != 0) {
					map.put("priorityjcEntryDate", strToShortDate(axelaServiceJcPriority.getPriorityjcEntryDate()));
					map.put("priorityjcEntryBy", empRepository.findEmpName(axelaServiceJcPriority.getPriorityjcEntryId()));
					map.put("priorityjcEntryId", axelaServiceJcPriority.getPriorityjcEntryId());
				}
				if (axelaServiceJcPriority.getPriorityjcModifiedId() != 0) {
					map.put("priorityjcModifiedDate", strToShortDate(axelaServiceJcPriority.getPriorityjcModifiedDate()));
					map.put("priorityjcModifiedBy", empRepository.findEmpName(axelaServiceJcPriority.getPriorityjcModifiedId()));
					map.put("priorityjcModifiedId", axelaServiceJcPriority.getPriorityjcModifiedId());
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
			List<AxelaServiceJcPriority> priorityList = null;
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
				sortField = "priorityjcId";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			String strOrderBy = " ORDER BY Priority." + sortField + " " + sortDirection;
			System.out.println("strOrderBy=============" + strOrderBy);
			priorityList = jcPriorityFilterImpl.findAllJcPriority(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			totalCount = Integer.parseInt(jcPriorityFilterImpl.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;
			// Start Header Data
			// listHeader.add(produceHeaderData("#", "Sl.no", "center"));
			listHeader.add(produceHeaderData("Job Card Priority Details", "priorityjcName", "center"));
			listHeader.add(produceHeaderData("Order", "priorityjcRank", "center"));
			// End Header Data

			// Start Body Align
			// listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaServiceJcPriority obj : priorityList) {
				ArrayList<String> paramSubArr = new ArrayList<String>();
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
				value.add(obj.getPriorityjcName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				type.add(true);
				type.add(true);
				value.add(String.valueOf("up"));
				value.add(String.valueOf("down"));
				paramSubArr.add(obj.getPriorityjcId() + "");
				paramSubArr.add("up");
				paramArr.add((ArrayList) paramSubArr.clone());
				paramSubArr.clear();
				paramSubArr.add(obj.getPriorityjcId() + "");
				paramSubArr.add("down");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				paramSubArr.clear();
				paramArr.clear();
				type.clear();
				value.clear();

				mapData.put("td", listData);
				actionParam.add("updateJCPriority");
				actionParam.add(obj.getPriorityjcId() + "");
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
		mapBodyData.put("value", "Update Job Card Priority");
		mapBodyData.put("param", actionParam);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public void moveUp(String priorityopprId) {
		output = new LinkedHashMap();
		int tempRank;
		int delstatusRank = 0;
		delstatusRank = serviceJcPriorityRepository.findRankfromPriorityjcId(Integer.parseInt(priorityopprId));
		tempRank = serviceJcPriorityRepository.findMinRank();
		if (tempRank != 0 && delstatusRank != 0) {
			if (delstatusRank != tempRank) {
				tempRank = delstatusRank - 1;
				int updateCount1 = portalFilterImpl.updatePriority(delstatusRank, tempRank, "AxelaServiceJcPriority priority", "priority.priorityjcRank");
				int updateCount2 = portalFilterImpl.updatePriorityById(delstatusRank, tempRank, "priority.priorityjcId", Integer.parseInt(priorityjcId), "AxelaServiceJcPriority priority",
						"priority.priorityjcRank");
				output.put("msg", "Priority moved up successfully!");
			}
		} else {
			output.put("errormsg", "not possible");
		}
	}

	public void moveDown(String priorityopprId) {
		output = new LinkedHashMap();
		int tempRank;
		int delstatusRank = 0;
		delstatusRank = serviceJcPriorityRepository.findRankfromPriorityjcId(Integer.parseInt(priorityopprId));
		tempRank = serviceJcPriorityRepository.findMaxRank();
		if (tempRank != 0 && delstatusRank != 0) {
			if (delstatusRank != tempRank) {
				tempRank = delstatusRank + 1;
				int updateCount1 = portalFilterImpl.updatePriority(delstatusRank, tempRank, "AxelaServiceJcPriority priority", "priority.priorityjcRank");
				int updateCount2 = portalFilterImpl.updatePriorityById(delstatusRank, tempRank, "priority.priorityjcId", Integer.parseInt(priorityjcId), "AxelaServiceJcPriority priority",
						"priority.priorityjcRank");
				output.put("msg", "Priority moved Down successfully!");
			}
		} else {
			output.put("errormsg", "not possible");
		}
	}

}
