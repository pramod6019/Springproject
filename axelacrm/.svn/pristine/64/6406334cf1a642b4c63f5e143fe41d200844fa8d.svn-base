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
import axela.service.model.AxelaServiceJcStatus;
import axela.service.repository.JcStatusFilterImpl;
import axela.service.repository.JcStatusRepository;

@Service
public class JobCardStatusService extends Connect {
	private final static int PAGESIZE = 25;
	public String jcstatusId = "0";
	public String jcstatusColour = "";
	public String jcstatusDesc = "";
	public String jcstatusDuehrs = "0.0";
	public String requestType = "";
	public String jcstatusEntryId = "0";
	public String jcstatusModifiedDate = "";
	public String jcstatusModifiedId = "0";
	public String jcstatusName = "";
	public String jcstatusRank = "0";
	public String jcstatusTrigger1Hrs = "0.0";
	public String jcstatusTrigger2Hrs = "0.0";
	public String jcstatusTrigger3Hrs = "0.0";
	public String jcstatusTrigger4Hrs = "0.0";
	public String jcstatusTrigger5Hrs = "0.0";
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
	private JcStatusRepository jcstatusrepository;

	@Autowired
	PortalFilterImpl portalFilterImpl;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	JcStatusFilterImpl jcStatusFilterImpl;

	public Map<String, String> jcStatusService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();

		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		switch (requestType) {
			case "add" :
				jcstatusId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "update" :
				jcstatusId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "delete" :
				if (!inputObj.isNull("jcstatusId")) {
					jcstatusId = inputObj.getString("jcstatusId");
				}
				if (!jcstatusId.equals("0")) {
					deleteFields(jcstatusId);
				}
				break;

			case "moveup" :
				if (!inputObj.isNull("jcstatusId")) {
					jcstatusId = inputObj.getString("jcstatusId");
				}
				if (!jcstatusId.equals("0")) {
					moveUp(jcstatusId);
				}
				break;

			case "movedown" :
				if (!inputObj.isNull("jcstatusId")) {
					jcstatusId = inputObj.getString("jcstatusId");
				}
				if (!jcstatusId.equals("0")) {
					moveDown(jcstatusId);
				}
				break;
		}
		return output;
	}
	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("jcstatusId")) {
			jcstatusId = inputObj.getString("jcstatusId");
		}
		if (!inputObj.isNull("jcstatusColour")) {
			jcstatusColour = inputObj.getString("jcstatusColour");
		}
		if (!inputObj.isNull("jcstatusDesc")) {
			jcstatusDesc = inputObj.getString("jcstatusDesc");
		}
		if (!inputObj.isNull("jcstatusDuehrs")) {
			jcstatusDuehrs = inputObj.getString("jcstatusDuehrs");
		}
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (!inputObj.isNull("jcstatusEntryId")) {
			jcstatusEntryId = inputObj.getString("jcstatusEntryId");
		}

		if (!inputObj.isNull("jcstatusModifiedDate")) {
			jcstatusModifiedDate = inputObj.getString("jcstatusModifiedDate");
		}

		if (!inputObj.isNull("jcstatusModifiedId")) {
			jcstatusModifiedId = inputObj.getString("jcstatusModifiedId");
		}

		if (!inputObj.isNull("jcstatusName")) {
			jcstatusName = inputObj.getString("jcstatusName");
		}

		if (!inputObj.isNull("jcstatusRank")) {
			jcstatusRank = inputObj.getString("jcstatusRank");
		}
		if (!inputObj.isNull("jcstatusTrigger1Hrs")) {
			jcstatusTrigger1Hrs = inputObj.getString("jcstatusTrigger1Hrs");
		}
		if (!inputObj.isNull("jcstatusTrigger2Hrs")) {
			jcstatusTrigger2Hrs = inputObj.getString("jcstatusTrigger2Hrs");
		}
		if (!inputObj.isNull("jcstatusTrigger3Hrs")) {
			jcstatusTrigger3Hrs = inputObj.getString("jcstatusTrigger3Hrs");
		}
		if (!inputObj.isNull("jcstatusTrigger4Hrs")) {
			jcstatusTrigger4Hrs = inputObj.getString("jcstatusTrigger4Hrs");
		}
		if (!inputObj.isNull("jcstatusTrigger5Hrs")) {
			jcstatusTrigger5Hrs = inputObj.getString("jcstatusTrigger5Hrs");
		}
	}

	public void checkForm() {
		msg = "";
		if (jcstatusName.equals("")) {
			msg = "<br>Enter Job Card Status Name!";
		}

		if (jcstatusDesc.equals("")) {
			msg = msg + "<br>Enter Description!";
		}

		if (jcstatusDuehrs.equals("")) {
			msg = msg + "<br>Enter Due Hours!";
		}
	}
	public void addFields(HttpServletResponse response) throws ParseException {
		checkForm();
		AxelaServiceJcStatus axelaServiceJcStatus = null;
		if (msg.equals("")) {
			if (!jcstatusId.equals("0")) {
				axelaServiceJcStatus = jcstatusrepository.findOne(Integer.parseInt(jcstatusId));
			} else {
				axelaServiceJcStatus = new AxelaServiceJcStatus();
			}
			axelaServiceJcStatus.setJcstatusId(Integer.parseInt(jcstatusId));
			axelaServiceJcStatus.setJcstatusColour(jcstatusColour);
			axelaServiceJcStatus.setJcstatusDesc(jcstatusDesc);
			axelaServiceJcStatus.setJcstatusDuehrs(jcstatusDuehrs);
			axelaServiceJcStatus.setJcstatusName(jcstatusName);
			axelaServiceJcStatus.setJcstatusRank(jcstatusrepository.findrank());
			axelaServiceJcStatus.setJcstatusTrigger1Hrs(jcstatusTrigger1Hrs);
			axelaServiceJcStatus.setJcstatusTrigger2Hrs(jcstatusTrigger2Hrs);
			axelaServiceJcStatus.setJcstatusTrigger3Hrs(jcstatusTrigger3Hrs);
			axelaServiceJcStatus.setJcstatusTrigger4Hrs(jcstatusTrigger4Hrs);
			axelaServiceJcStatus.setJcstatusTrigger5Hrs(jcstatusTrigger5Hrs);
			if (jcstatusId.equals("0") && requestType.equals("add")) {
				axelaServiceJcStatus.setJcstatusEntryId(empId);
				axelaServiceJcStatus.setJcstatusEntryDate(stringToDate(toLongDate(kknow())));
				axelaServiceJcStatus.setJcstatusModifiedDate(stringToDate(("")));
				axelaServiceJcStatus.setJcstatusModifiedId(0);
			} else if (!jcstatusId.equals("0") && requestType.equals("update")) {
				axelaServiceJcStatus.setJcstatusModifiedId(empId);
				axelaServiceJcStatus.setJcstatusModifiedDate(stringToDate(toLongDate(kknow())));
			}
			jcstatusId = jcstatusrepository.save(axelaServiceJcStatus).getJcstatusId() + "";
			System.out.println("jcstatusId===============" + jcstatusId);
			System.out.println("requestType============" + requestType);
			if (!jcstatusId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("jcstatusId", jcstatusId);
				output.put("successmsg", "Job Card Status Added successfully!");
			} else if (!jcstatusId.equals("0") && requestType.equals("update")) {
				output.put("jcstatusId", jcstatusId);
				output.put("successmsg", "Job Card Status Updated successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String jcstatusId) {
		jcstatusrepository.delete(Integer.parseInt(jcstatusId));
		output.put("successmsg", "Job Card Status Deleted successfully!");
	}

	public Map<String, List> populateData(String input) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		LinkedHashMap map = new LinkedHashMap();
		if (!inputObj.isNull("jcstatusId")) {
			jcstatusId = CNumeric(PadQuotes(inputObj.getString("jcstatusId")));
		}
		if (!jcstatusId.equals("0")) {
			AxelaServiceJcStatus axelaServiceJcStatus = jcstatusrepository.findOne(Integer.parseInt(jcstatusId));
			if (axelaServiceJcStatus != null) {
				map.put("jcstatusId", axelaServiceJcStatus.getJcstatusId());
				map.put("jcstatusName", axelaServiceJcStatus.getJcstatusName());
				map.put("jcstatusDuehrs", axelaServiceJcStatus.getJcstatusDuehrs());
				map.put("jcstatusDesc", axelaServiceJcStatus.getJcstatusDesc());
				map.put("jcstatusRank", axelaServiceJcStatus.getJcstatusRank());
				map.put("jcstatusTrigger1Hrs", axelaServiceJcStatus.getJcstatusTrigger1Hrs());
				map.put("jcstatusTrigger2Hrs", axelaServiceJcStatus.getJcstatusTrigger2Hrs());
				map.put("jcstatusTrigger3Hrs", axelaServiceJcStatus.getJcstatusTrigger3Hrs());
				map.put("jcstatusTrigger4Hrs", axelaServiceJcStatus.getJcstatusTrigger4Hrs());
				map.put("jcstatusTrigger5Hrs", axelaServiceJcStatus.getJcstatusTrigger5Hrs());
				AxelaEmp axelaEmp = empRepository.findByEmpId(axelaServiceJcStatus.getJcstatusEntryId());
				if (axelaServiceJcStatus.getJcstatusEntryId() != 0) {
					map.put("jcstatusEntryDate", strToShortDate(axelaServiceJcStatus.getJcstatusEntryDate()));
					map.put("jcstatusEntryBy", empRepository.findEmpName(axelaServiceJcStatus.getJcstatusEntryId()));
					map.put("jcstatusEntryId", axelaServiceJcStatus.getJcstatusEntryId());
				}
				if (axelaServiceJcStatus.getJcstatusModifiedId() != 0) {
					map.put("jcstatusModifiedDate", strToShortDate(axelaServiceJcStatus.getJcstatusModifiedDate()));
					map.put("jcstatusModifiedBy", empRepository.findEmpName(axelaServiceJcStatus.getJcstatusModifiedId()));
					map.put("jcstatusModifiedId", axelaServiceJcStatus.getJcstatusModifiedId());
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
			List<AxelaServiceJcStatus> statusList = null;
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
				sortField = "jcstatusId";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			String strOrderBy = " ORDER BY status." + sortField + " " + sortDirection;
			statusList = jcStatusFilterImpl.findAllJcStatus(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			totalCount = Integer.parseInt(jcStatusFilterImpl.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Job Card Status Details", "jcstatusName", "center"));
			listHeader.add(produceHeaderData("Order", "jcstatusRank", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaServiceJcStatus obj : statusList) {
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
				value.add(obj.getJcstatusName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				type.add(true);
				type.add(true);
				value.add(String.valueOf("up"));
				value.add(String.valueOf("down"));
				paramSubArr.add(obj.getJcstatusId() + "");
				paramSubArr.add("up");
				paramArr.add((ArrayList) paramSubArr.clone());
				paramSubArr.clear();
				paramSubArr.add(obj.getJcstatusId() + "");
				paramSubArr.add("down");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				paramSubArr.clear();
				paramArr.clear();
				type.clear();
				value.clear();

				mapData.put("td", listData);
				actionParam.add("updateJCStatus");
				actionParam.add(obj.getJcstatusId() + "");
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
		mapBodyData.put("value", "Update Job Card Status");
		mapBodyData.put("param", actionParam);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public void moveUp(String delstatusId) {
		output = new LinkedHashMap();
		int tempRank;
		int delstatusRank = 0;
		delstatusRank = jcstatusrepository.findRankfromJcstatusId(Integer.parseInt(delstatusId));
		tempRank = jcstatusrepository.findMinRank();
		if (tempRank != 0 && delstatusRank != 0) {
			SOP("delstatus_rank=222=" + delstatusRank + " tempRank=2222222=" + tempRank);
			if (delstatusRank != tempRank) {
				tempRank = delstatusRank - 1;
				int updateCount1 = portalFilterImpl.updatePriority(delstatusRank, tempRank, "AxelaServiceJcStatus status", "status.jcstatusRank");
				int updateCount2 = portalFilterImpl.updatePriorityById(delstatusRank, tempRank, "status.jcstatusId", Integer.parseInt(delstatusId), "AxelaServiceJcStatus status",
						"delstatus.delstatusRank");
				output.put("moveUp", "Job Card Status moved up successfully!");
			}
		} else {
			output.put("errormsg", "not possible");
		}
	}

	public void moveDown(String delstatusId) {
		output = new LinkedHashMap();
		int tempRank;
		int delstatusRank = 0;
		delstatusRank = jcstatusrepository.findRankfromJcstatusId(Integer.parseInt(delstatusId));
		tempRank = jcstatusrepository.findMaxRank();
		if (tempRank != 0 && delstatusRank != 0) {
			if (delstatusRank != tempRank) {
				tempRank = delstatusRank + 1;
				int updateCount1 = portalFilterImpl.updatePriority(delstatusRank, tempRank, "AxelaServiceJcStatus status", "status.jcstatusRank");
				int updateCount2 = portalFilterImpl.updatePriorityById(delstatusRank, tempRank, "status.jcstatusId", Integer.parseInt(delstatusId), "AxelaServiceJcStatus status",
						"delstatus.delstatusRank");
				output.put("moveDown", "Job Card Status moved Down successfully!");
			}
		} else {
			output.put("errormsg", "not possible");
		}
	}

}
