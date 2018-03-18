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
import axela.portal.repository.BranchRepository;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;
import axela.service.model.AxelaServiceJcBay;
import axela.service.repository.JcBayFilterImpl;
import axela.service.repository.jcBayRepository;

@Service
public class JobCardBayService extends Connect {
	private final static int PAGESIZE = 25;
	public String bayId = "0";
	public String bayActive = "";
	public String bayBranchId = "0";
	public String bayEntryDate = "";
	public String bayEntryId = "0";
	public String bayModifiedDate = "";
	public String bayModifiedId = "0";
	public String bayName = "";
	public String bayNotes = "";
	public String bayOpen = "";
	public String bayRank = "0";
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
	private jcBayRepository jcbayrepository;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	PortalFilterImpl portalFilterImpl;

	@Autowired
	BranchRepository branchRepository;

	@Autowired
	JcBayFilterImpl jcBayFilterImpl;

	public Map<String, String> jcBayService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		switch (requestType) {
			case "add" :
				bayId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "update" :
				bayId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "delete" :
				if (!inputObj.isNull("bayId")) {
					bayId = inputObj.getString("bayId");
				}
				if (!bayId.equals("0")) {
					deleteFields(bayId);
				}
				break;

			case "moveup" :
				if (!inputObj.isNull("bayId")) {
					bayId = inputObj.getString("bayId");
				}
				if (!bayId.equals("0")) {
					// moveUp(bayId);
				}
				break;

			case "movedown" :
				if (!inputObj.isNull("bayId")) {
					bayId = inputObj.getString("bayId");
				}
				if (!bayId.equals("0")) {
					// moveDown(bayId);
				}
				break;

		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		System.out.println("===============getvalues");
		if (!inputObj.isNull("bayId")) {

			bayId = inputObj.getString("bayId");
			System.out.println("bayId=================" + bayId);
		}

		if (!inputObj.isNull("bayActive")) {
			bayActive = (inputObj.getString("bayActive")) + "";
		}
		if (!inputObj.isNull("bayBranchId")) {
			bayBranchId = inputObj.getString("bayBranchId");
		}
		if (!inputObj.isNull("bayEntryDate")) {
			bayEntryDate = inputObj.getString("bayEntryDate");
		}
		if (!inputObj.isNull("bayEntryId")) {
			bayEntryId = inputObj.getString("bayEntryId");
		}
		if (!inputObj.isNull("bayModifiedDate")) {
			bayModifiedDate = inputObj.getString("bayModifiedDate");
		}

		if (!inputObj.isNull("bayModifiedId")) {
			bayModifiedId = inputObj.getString("bayModifiedId");
		}

		if (!inputObj.isNull("bayName")) {
			bayName = inputObj.getString("bayName");
		}

		if (!inputObj.isNull("bayNotes")) {
			bayNotes = inputObj.getString("bayNotes");
		}

		if (!inputObj.isNull("bayOpen")) {
			bayOpen = (inputObj.getString("bayOpen")) + "";
		}
		if (!inputObj.isNull("bayRank")) {
			bayRank = inputObj.getString("bayRank");
		}
	}

	public void checkForm() {
		msg = "";
		System.out.println("====================checkform");
		if (bayName.equals("")) {
			msg = "<br>Enter Job Card Bay Name!";
		}
	}

	public void addFields(HttpServletResponse response) throws ParseException {
		checkForm();
		AxelaServiceJcBay axelaServiceJcBay = null;
		if (msg.equals("")) {
			if (!bayId.equals("0")) {
				axelaServiceJcBay = jcbayrepository.findOne(Integer.parseInt(bayId));
			} else {
				axelaServiceJcBay = new AxelaServiceJcBay();
			}
			axelaServiceJcBay.setBayId(Integer.parseInt(bayId));
			axelaServiceJcBay.setBayActive(bayActive);
			axelaServiceJcBay.setBayBranchId(Integer.parseInt(bayBranchId));
			axelaServiceJcBay.setBayName(bayName);
			axelaServiceJcBay.setBayNotes(bayNotes);
			axelaServiceJcBay.setBayOpen(bayOpen);
			axelaServiceJcBay.setBayRank(Integer.parseInt(bayRank));
			if (bayId.equals("0") && requestType.equals("add")) {
				axelaServiceJcBay.setBayEntryDate(stringToDate(toLongDate(kknow())));
				axelaServiceJcBay.setBayEntryId(empId);
				axelaServiceJcBay.setBayModifiedId(0);
			} else if (!bayId.equals("0") && requestType.equals("update")) {
				axelaServiceJcBay.setBayModifiedDate(stringToDate(toLongDate(kknow())));
				axelaServiceJcBay.setBayModifiedId(empId);
			}
			String bayId = jcbayrepository.save(axelaServiceJcBay).getBayId() + "";
			if (bayId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("successmsg", "Bay Added Successfully!");
				output.put("bayId", bayId);
			} else {
				output.put("successmsg", "Bay Updated Successfully!");
				output.put("bayId", bayId);
			}
			bayId = "0";
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String bayId) {
		jcbayrepository.delete(Integer.parseInt(bayId));
		output.put("succesmsg", "Bay Deleted Successfully!");
	}

	public Map<String, List> populateData(String input) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		LinkedHashMap map = new LinkedHashMap<String, String>();
		if (!inputObj.isNull("bayId")) {
			bayId = CNumeric(PadQuotes(inputObj.getString("bayId")));
		}
		if (!bayId.equals("0")) {
			AxelaServiceJcBay axelaServiceJcBay = jcbayrepository.findOne(Integer.parseInt(bayId));
			if (axelaServiceJcBay != null) {
				map.put("bayId", axelaServiceJcBay.getBayId() + "");
				map.put("bayActive", (Integer.parseInt(axelaServiceJcBay.getBayActive())));
				map.put("bayBranchId", axelaServiceJcBay.getBayBranchId() + "");
				map.put("bayName", axelaServiceJcBay.getBayName() + "");
				map.put("bayNotes", axelaServiceJcBay.getBayNotes() + "");
				map.put("bayOpen", (Integer.parseInt(axelaServiceJcBay.getBayOpen())));
				map.put("bayRank", axelaServiceJcBay.getBayRank() + "");

				AxelaEmp axelaEmp = empRepository.findByEmpId(axelaServiceJcBay.getBayEntryId());
				if (axelaServiceJcBay.getBayEntryId() != 0) {
					map.put("entryDate", strToShortDate(axelaServiceJcBay.getBayEntryDate()));
					map.put("entryBy", empRepository.findEmpName(axelaServiceJcBay.getBayEntryId()));
				}
				if (axelaServiceJcBay.getBayModifiedId() != 0) {
					map.put("modifiedDate", strToShortDate(axelaServiceJcBay.getBayModifiedDate()));
					map.put("modifiedBy", empRepository.findEmpName(axelaServiceJcBay.getBayModifiedId()));
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
			List<AxelaServiceJcBay> bayList = null;
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
				sortField = "bayId";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			String strOrderBy = " ORDER BY bay." + sortField + " " + sortDirection;
			bayList = jcBayFilterImpl.findAllJcBay(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			totalCount = Integer.parseInt(PortalFilterImpl.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;
			// Start Header Data
			// listHeader.add(produceHeaderData("#", "Sl.no", "center"));
			listHeader.add(produceHeaderData("Job Card Bay Details", "bayName", "center"));
			listHeader.add(produceHeaderData("Branch", "", "center"));
			listHeader.add(produceHeaderData("Order", "", "center"));
			// End Header Data

			// Start Body Align
			// listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaServiceJcBay obj : bayList) {
				ArrayList<String> param = new ArrayList<String>();
				ArrayList<String> paramSubArr = new ArrayList<String>();
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
				value.add(obj.getBayBranchId());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				type.add(true);
				// value.add(branchRepository.findBranchName(obj.getBayBranchId()));
				paramSubArr.add(obj.getBayBranchId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				paramSubArr.clear();
				paramArr.clear();
				type.clear();
				value.clear();

				type.add(true);
				type.add(true);
				value.add(String.valueOf("up"));
				value.add(String.valueOf("down"));
				paramSubArr.add(obj.getBayId() + "");
				paramSubArr.add("up");
				paramArr.add((ArrayList) paramSubArr.clone());
				paramSubArr.clear();
				paramSubArr.add(obj.getBayId() + "");
				paramSubArr.add("down");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				paramSubArr.clear();
				paramArr.clear();
				type.clear();
				value.clear();

				mapData.put("td", listData);
				actionParam.add("updateJobCardBay");
				actionParam.add(obj.getBayId() + "");
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
		mapBodyData.put("value", "Update Job Card Bay");
		mapBodyData.put("param", actionParam);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	// public void moveUp(String delstatusId) {
	// output = new LinkedHashMap();
	// SOP("priorityopprId======11111=====" + delstatusId);
	// int tempRank;
	// int delstatusRank = 0;
	// delstatusRank = jcbayrepository.findRankfromBayId(Integer.parseInt(delstatusId));
	// tempRank = jcbayrepository.findMinRank();
	// SOP("delstatus_rank=1111=" + delstatusRank + " tempRank=11111=" + tempRank);
	// if (tempRank != 0 && delstatusRank != 0) {
	// SOP("delstatus_rank=222=" + delstatusRank + " tempRank=2222222=" + tempRank);
	// if (delstatusRank != tempRank) {
	// tempRank = delstatusRank - 1;
	// int updateCount1 = portalFilterImpl.updatePriority(delstatusRank, tempRank, "AxelaServiceJcBay bay", "bay.bayRank");
	// SOP("updateCount1======11111=====" + updateCount1);
	//
	// SOP("updatePriority======22=====");
	// int updateCount2 = portalFilterImpl.updatePriorityById(delstatusRank, tempRank, "bay.bayId", Integer.parseInt(delstatusId), "AxelaServiceJcBay bay",
	// "delstatus.delstatusRank");
	// SOP("updateCount2======11111=====" + updateCount2);
	// SOP("updatePriorityById======11111=====");
	// output.put("moveUp", "Bay moved up successfully!");
	// }
	// } else {
	// output.put("errormsg", "not possible");
	// }
	// }

	// public void moveDown(String delstatusId) {
	// output = new LinkedHashMap();
	// SOP("priorityopprId======11111=====" + delstatusId);
	// int tempRank;
	// int delstatusRank = 0;
	// delstatusRank = jcbayrepository.findRankfromBayId(Integer.parseInt(delstatusId));
	// tempRank = jcbayrepository.findMaxRank();
	// SOP("delstatus_rank=1111=" + delstatusRank + " tempRank=11111=" + tempRank);
	// if (tempRank != 0 && delstatusRank != 0) {
	// SOP("delstatus_rank=222=" + delstatusRank + " tempRank=2222222=" + tempRank);
	// if (delstatusRank != tempRank) {
	// tempRank = delstatusRank + 1;
	// int updateCount1 = portalFilterImpl.updatePriority(delstatusRank, tempRank, "AxelaServiceJcBay bay", "bay.bayRank");
	// SOP("updateCount1======11111=====" + updateCount1);
	// SOP("updatePriority======22=====");
	// int updateCount2 = portalFilterImpl.updatePriorityById(delstatusRank, tempRank, "bay.bayId", Integer.parseInt(delstatusId), "AxelaServiceJcBay bay",
	// "delstatus.delstatusRank");
	// SOP("updateCount2======11111=====" + updateCount2);
	// SOP("updatePriorityById======11111=====");
	// output.put("moveDown", "Bay moved Down successfully!");
	// }
	// } else {
	// output.put("errormsg", "not possible");
	// }
	// }
}
