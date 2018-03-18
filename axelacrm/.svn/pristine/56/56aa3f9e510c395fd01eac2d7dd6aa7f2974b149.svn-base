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
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;
import axela.sales.model.AxelaSalesOpprFollowupDesc;
import axela.sales.repository.FollowupDescRepository;
@Service
public class FollowupDescService extends Connect {

	@Autowired
	private FollowupDescRepository followupdescrepository;
	@Autowired
	private EmpRepository empRepository;
	@Autowired
	private PortalFilterImpl portalFilterImpl;

	public String followupdescId = "0";
	public String followupdescName = "";
	public String followupdescEntryDate = "";
	public String followupdescEntryId = "0";
	public String followupdescModifiedDate = "";
	public String followupdescModifiedId = "0";
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

	public Map followupDescService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
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
				case "add" :
					followupdescId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "update" :
					followupdescId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "delete" :
					if (!inputObj.isNull("followupdescId")) {
						followupdescId = inputObj.getString("followupdescId");
					}
					if (!followupdescId.equals("0")) {
						deleteFields(followupdescId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("followupdescId")) {
			followupdescId = CNumeric(inputObj.getString("followupdescId"));
		}
		if (!inputObj.isNull("followupdescName")) {
			followupdescName = PadQuotes(inputObj.getString("followupdescName"));
		}
	}

	public void validateFields() {
		List<AxelaSalesOpprFollowupDesc> obj = null;
		if (followupdescName.equals("")) {
			msg += "Enter  Name!";
		} else {
			if (requestType.equals("add")) {
				obj = followupdescrepository.findByFollowupdescName(followupdescName);
			}
			else if (requestType.equals("update")) {
				obj = followupdescrepository.findFollowupdescName(Integer.parseInt(followupdescId), followupdescName);
			}
			if (!obj.isEmpty()) {
				msg += "<br>Similar Name found!";
			}
		}
	}

	public void addFields(HttpServletResponse response) throws JSONException, ParseException {
		validateFields();
		if (msg.equals("")) {
			AxelaSalesOpprFollowupDesc axelasalesopprfollowupdesc = null;
			if (!followupdescId.equals("0")) {
				axelasalesopprfollowupdesc = followupdescrepository.findByFollowupdescId(Integer.parseInt(followupdescId));
			} else {
				axelasalesopprfollowupdesc = new AxelaSalesOpprFollowupDesc();
			}
			axelasalesopprfollowupdesc.setFollowupdescId(Integer.parseInt(followupdescId));;
			axelasalesopprfollowupdesc.setFollowupdescName(followupdescName);
			if (followupdescId.equals("0") && requestType.equals("add")) {
				axelasalesopprfollowupdesc.setFollowupdescEntryId(empId);
				axelasalesopprfollowupdesc.setFollowupdescEntryDate(stringToDate(toLongDate(kknow())));
				axelasalesopprfollowupdesc.setFollowupdescModifiedId(0);
			} else if (!followupdescId.equals("0") && requestType.equals("update")) {
				axelasalesopprfollowupdesc.setFollowupdescModifiedId(empId);
				axelasalesopprfollowupdesc.setFollowupdescModifiedDate(stringToDate(toLongDate(kknow())));
			}
			String followupdescId = followupdescrepository.save(axelasalesopprfollowupdesc).getFollowupdescId() + "";
			if (!followupdescId.equals("0") && requestType.equals("add")) {
				output.put("followupdescId", followupdescId);
				output.put("successmsg", "Follow-Up Description Added Successfully");
			}
			else if (!followupdescId.equals("0") && requestType.equals("update")) {
				output.put("followupdescId", followupdescId);
				output.put("successmsg", "Follow-Up Description Updated Successfully");
			}
		}
		else {
			response.setStatus(400);
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String followupdescId) throws JSONException {
		followupdescrepository.delete(Integer.parseInt(followupdescId));
		output.put("successmsg", "Follow-Up Description Deleted Successfully");
	}

	public Map populateData(String input) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("followupdescId")) {
			followupdescId = PadQuotes(CNumeric(inputObj.getString("followupdescId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!followupdescId.equals("0")) {
			AxelaSalesOpprFollowupDesc followupDesc = followupdescrepository.findByFollowupdescId(Integer.parseInt(followupdescId));
			HashMap map = new HashMap();
			map.put("followupdescId", followupdescId);
			map.put("followupdescName", String.valueOf(followupDesc.getFollowupdescName()));
			if (followupDesc.getFollowupdescEntryId() != 0) {
				map.put("followupdescEntryDate", strToShortDate(followupDesc.getFollowupdescEntryDate()));
				map.put("followupdescEntryId", String.valueOf(followupDesc.getFollowupdescEntryId()));
				map.put("followupdescEntryBy", empRepository.findEmpName(followupDesc.getFollowupdescEntryId()));
			}
			if (followupDesc.getFollowupdescModifiedId() != 0) {
				map.put("followupdescModifiedDate", strToShortDate(followupDesc.getFollowupdescModifiedDate()));
				map.put("followupdescModifiedId", String.valueOf(followupDesc.getFollowupdescModifiedId()));
				map.put("followupdescModifiedBy", empRepository.findEmpName(followupDesc.getFollowupdescModifiedId()));
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
				orderByField = "followupdescId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strOrderBy = " ORDER BY follow." + orderByField + " " + orderType + "";
			List<AxelaSalesOpprFollowupDesc> resultSet = portalFilterImpl.findFolloeupDescription(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			String length = portalFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Follow-Up Description Details", "groupName", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaSalesOpprFollowupDesc obj : resultSet) {
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
				// Followup Desc Name.
				type.add(false);
				value.add(String.valueOf(obj.getFollowupdescName()));
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// End Body data
				mapData.put("td", listData);
				ArrayList actionParam = new ArrayList();
				actionParam.add("updateFollowupDesc");
				actionParam.add(PadQuotes(String.valueOf(obj.getFollowupdescId())));
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
		mapBodyData.put("value", "Update Follow-Up Description");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "desc.*"));
		list.add(buildSmartArr("Follow-up Desc ID", "numeric", "desc.followupdescId"));
		list.add(buildSmartArr("Follow-up Desc Name", "text", "desc.followupdescName"));
		// list.add(buildSmartArr("Entry By", "text", "desc.followupdesc_entry_id in (select emp_id from compdb.axela_emp where emp_name"));
		list.add(buildSmartArr("Entry Date", "date", "desc.followupdescEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "followupdesc_modified_id in (select emp_id from compdb.axela_emp where emp_name"));
		list.add(buildSmartArr("Modified Date", "date", "desc.followupdescModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

}
