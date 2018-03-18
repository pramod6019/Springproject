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
import axela.portal.model.AxelaCustomerGroup;
import axela.portal.model.AxelaEmp;
import axela.portal.repository.AxelaCustomerGroupRepository;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;

@Service
public class GroupService extends Connect {
	private final static int PAGESIZE = 25;
	public String groupId = "0";
	public String groupDesc = "";
	public String groupEntryDate = "";
	public String groupModifiedDate = "";
	public String groupEntryId = "0";
	public String groupModifiedId = "0";
	public String requesttype = "";
	public String msg = "";
	public String pageNumber = "";
	public int empId = 0;
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
	public int compId = 0;

	JSONObject inputObj = null;

	@Autowired
	private AxelaCustomerGroupRepository axelaCustomerGroupRepository;

	@Autowired
	PortalFilterImpl portalFilterImpl;

	@Autowired
	EmpRepository empRepository;

	public Map<String, String> groupService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		switch (requestType) {
			case "add" : // add an soe.
				groupId = "0";
				getValues(inputObj);
				addFields(response, session);
				break;

			case "update" :// update an customer.
				groupId = "0";
				getValues(inputObj);
				addFields(response, session);
				break;

			case "delete" :// delete an customer.
				if (!inputObj.isNull("groupId")) {
					groupId = inputObj.getString("groupId");
				}
				if (!groupId.equals("0")) {
					deleteFields(groupId);
				}
				break;
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("groupId")) {
			groupId = CNumeric(inputObj.getString("groupId"));
		}
		if (!inputObj.isNull("groupDesc")) {
			groupDesc = PadQuotes(inputObj.getString("groupDesc"));
		}
		if (!inputObj.isNull("groupEntryDate")) {
			groupEntryDate = PadQuotes(inputObj.getString("groupEntryDate"));
		}
		if (!inputObj.isNull("groupEntryId")) {
			groupEntryId = CNumeric(inputObj.getString("groupEntryId"));
		}
		if (!inputObj.isNull("groupModifiedDate")) {
			groupModifiedDate = PadQuotes(inputObj.getString("groupModifiedDate"));
		}
		if (!inputObj.isNull("group_modified_id")) {
			groupModifiedId = CNumeric(inputObj.getString("groupModifiedId"));
		}
	}

	public void checkForm() {
		if (groupDesc.equals("")) {
			msg += "Enter groupDesc!";
		}
	}

	public void addFields(HttpServletResponse response, HttpSession session) throws ParseException {
		checkForm();
		output = new HashMap();
		if (msg.equals("")) {
			AxelaCustomerGroup axelaCustomerGroup = null;
			if (!groupId.equals("0")) {
				axelaCustomerGroup = axelaCustomerGroupRepository.findOne(Integer.parseInt(groupId));
			} else {
				axelaCustomerGroup = new AxelaCustomerGroup();
			}
			axelaCustomerGroup.setGroupId(Integer.parseInt(groupId));
			axelaCustomerGroup.setGroupDesc(groupDesc);;
			if (groupId.equals("0") && requestType.equals("add")) {
				axelaCustomerGroup.setGroupEntryId(empId);
				axelaCustomerGroup.setGroupEntryDate(getTimeByZone(session));
				// axelaCustomerGroup.setGroupModifiedDate("");
				axelaCustomerGroup.setGroupModifiedId(0);
			} else if (!groupId.equals("0") && requestType.equals("update")) {
				axelaCustomerGroup.setGroupModifiedId(empId);
				axelaCustomerGroup.setGroupModifiedDate(getTimeByZone(session));
			}
			groupId = axelaCustomerGroupRepository.save(axelaCustomerGroup).getGroupId() + "";
			if (!groupId.equals("0") && requestType.equals("add")) {
				output.put("successmsg", "Group Added Successfully!");
			} else if (!groupId.equals("0") && requestType.equals("update")) {
				output.put("successmsg", "Group Updated Successfully!");
			}
		} else {
			response.setStatus(400);
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String groupId) {
		axelaCustomerGroupRepository.delete(Integer.parseInt(groupId));
		output.put("successmsg", "Group Deleted Successfully!");
	}

	public Map<String, List> populateData(String input) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap map = new HashMap();
		if (!inputObj.isNull("groupId")) {
			groupId = CNumeric(PadQuotes(inputObj.getString("groupId")));
		}
		if (!groupId.equals("0")) {
			AxelaCustomerGroup axelaCustomerGroup = axelaCustomerGroupRepository.findOne(Integer.parseInt(groupId));
			if (axelaCustomerGroup != null) {
				map.put("groupDesc", axelaCustomerGroup.getGroupDesc());
				AxelaEmp axelaEmp = empRepository.findByEmpId(axelaCustomerGroup.getGroupEntryId());
				if (axelaCustomerGroup.getGroupEntryId() != 0) {
					map.put("groupEntryDate", strToShortDate(axelaCustomerGroup.getGroupEntryDate()));
					map.put("groupEntryBy", empRepository.findEmpName(axelaCustomerGroup.getGroupEntryId()));
					map.put("groupEntryId", axelaCustomerGroup.getGroupEntryId());
				}
				if (axelaCustomerGroup.getGroupModifiedId() != 0) {
					map.put("groupModifiedDate", strToShortDate(axelaCustomerGroup.getGroupModifiedDate()));
					map.put("groupModifiedBy", empRepository.findEmpName(axelaCustomerGroup.getGroupModifiedId()));
					map.put("groupModifiedId", axelaCustomerGroup.getGroupModifiedId());
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
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			List<AxelaCustomerGroup> groupList = null;
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
				sortField = "groupId";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			String strOrderBy = " ORDER BY groups." + sortField + " " + sortDirection;
			groupList = portalFilterImpl.findAllGroup(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			totalCount = Integer.parseInt(PortalFilterImpl.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;
			// Start Header Data
			// listHeader.add(produceHeaderData("#", "Sl.no", "center"));
			listHeader.add(produceHeaderData("Group Details", "groupDesc", "center"));
			// End Header Data

			// Start Body Align
			// listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaCustomerGroup obj : groupList) {
				ArrayList<String> param = new ArrayList<String>();
				ArrayList type = new ArrayList();
				ArrayList value = new ArrayList();
				ArrayList actionParam = new ArrayList();
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
				value.add(obj.getGroupDesc());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				mapData.put("td", listData);
				actionParam.add("updateGroup");
				actionParam.add(obj.getGroupId());
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
		mapBodyData.put("value", "Update Group");
		mapBodyData.put("param", actionParam);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		//
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "group.*"));
		list.add(buildSmartArr("Group ID", "numeric", "group.groupId"));
		list.add(buildSmartArr("Group Desc", "text", "group.groupName"));
		// list.add(buildSmartArr("Entry By", "text", "group.groupEntryId)"));
		list.add(buildSmartArr("Entry Date", "date", "group.groupEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "group.groupModifiedId"));
		list.add(buildSmartArr("Modified Date", "date", "group.groupModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}
}
