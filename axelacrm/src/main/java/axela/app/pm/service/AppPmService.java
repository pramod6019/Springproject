package axela.app.pm.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.pm.model.AxelaPm;
import axela.pm.repository.PmExeRepository;
import axela.pm.service.PmService;
import axela.portal.repository.PmFilterImpl;
import axela.portal.repository.PmRepository;
@Service
public class AppPmService extends Connect {

	@Autowired
	public PmFilterImpl pmFilterImpl;
	@Autowired
	PmRepository pmRepository;
	@Autowired
	public PmExeRepository pmexerepository;
	public JSONObject inputObj = null;
	public HashMap output = null;
	public String requestType = "";
	public String branchAccess;
	public String exeAccess;
	public int empId = 0;
	private int compId;
	public String pmId = "0";
	public String customerId = "0";
	public String pageNumber = "";
	public String msg = "";
	public int page = 0;
	public String perpage = "0";
	public String sort = "";
	public String field = "";
	public String perPage = "0";
	public String strSearch = "";
	public String orderType = "";
	public String orderByField = "";
	public String strOrderBy = "";
	public String pmActive = "";
	public String pmBudget = "0";
	public String pmComplete = "";
	public String pmCompleteComments = "";
	public String pmCompletePerc = "0";
	public String pmCustomerId = "0";
	public String pmPmstatusId = "0";
	public String pmEndDate = "";
	public String pmExpense = "0";
	public String pmNotes = "";
	public String pmStartDate = "";
	public String pmPmtypeId = "0";
	public String pmTitle = "";
	public JSONArray pmexeEmpIds = new JSONArray();
	public String configCustomerName = "";
	LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

	public Map<String, String> pmAdd(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, SQLException, ParseException {
		if (AppRun().equals("0")) {
			SOP("input==WS_jobcadrt_Add===" + input);
		}
		inputObj = new JSONObject(input);
		output = new LinkedHashMap();
		exeAccess = GetSession("ExeAccess", request);
		branchAccess = GetSession("BranchAccess", request);
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (empId != 0) {
			switch (requestType) {
				case "add" : //
					getValues(inputObj);
					addFields(response, request);
					break;
			}
			if (AppRun().equals("0")) {
				SOP("output========WS_jobcradaddd===========" + output.toString());
			}
		}
		else
		{
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("customerId")) {
			customerId = CNumeric(inputObj.getString("customerId"));
		}
		if (!inputObj.isNull("pmTitle")) {
			pmTitle = PadQuotes(inputObj.getString("pmTitle"));
		}
		if (!inputObj.isNull("pmPmtypeId")) {
			pmPmtypeId = CNumeric(inputObj.getString("pmPmtypeId"));
		}
		if (!inputObj.isNull("pmPmstatusId")) {
			pmPmstatusId = CNumeric(inputObj.getString("pmPmstatusId"));
		}
		if (!inputObj.isNull("pmBudget")) {
			pmBudget = PadQuotes(inputObj.getString("pmBudget"));
		}
		if (!inputObj.isNull("pmStartDate")) {
			pmStartDate = PadQuotes(inputObj.getString("pmStartDate"));
		}
		if (!inputObj.isNull("pmEndDate")) {
			pmEndDate = PadQuotes(inputObj.getString("pmEndDate"));
		}

		if (!inputObj.isNull("pmexeEmpIds")) {
			if (inputObj.get("pmexeEmpIds") instanceof JSONArray)
				pmexeEmpIds = inputObj.getJSONArray("pmexeEmpIds");
		}
		// if (!input.isNull("pmexe_emp_ids")) {
		// pmexe_emp_ids = PadQuotes((String) input.get("pmexe_emp_ids"));
		// }
		if (!inputObj.isNull("pmComplete")) {
			pmComplete = PadQuotes(inputObj.getString("pmComplete"));
		}
		if (!inputObj.isNull("pmActive")) {
			pmActive = PadQuotes(inputObj.getString("pmActive"));
		}
		if (!inputObj.isNull("pmCompleteComments")) {
			pmCompleteComments = PadQuotes(inputObj.getString("pmCompleteComments"));
		}
		if (!inputObj.isNull("pmNotes")) {
			pmNotes = PadQuotes(inputObj.getString("pmNotes"));
		}
	}

	public void addFields(HttpServletResponse response, HttpServletRequest request) throws SQLException, JSONException, ParseException {
		PmService pm = new PmService();
		pm.pmActive = pmActive;
		pm.pmBudget = pmBudget;
		pm.pmComplete = pmComplete;
		pm.pmCompleteComments = pmCompleteComments;
		pm.pmCompletePerc = pmCompletePerc;
		pm.pmCustomerId = customerId;
		pm.pmEndDate = pmEndDate;
		pm.pmExpense = pmExpense;
		pm.pmNotes = pmNotes;
		pm.pmPmstatusId = pmPmstatusId;
		pm.pmPmtypeId = pmPmtypeId;
		pm.pmStartDate = pmStartDate;
		pm.pmTitle = pmTitle;
		pm.empId = empId;
		pm.requestType = requestType;
		pm.pmRepository = pmRepository;
		pm.pmexeEmpIds = pmexeEmpIds;
		pm.pmexerepository = pmexerepository;
		pm.addFields(response, request);
		String msg = pm.msg;
		if (msg.equals("")) {
			output.put("successmsg", "Project Added Successfully!");
			output.put("pmId", pm.pmId + "");
		} else {
			response.setStatus(201);
			output.put("errormsg", msg);
		}
	}

	public Map listData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		String sort = "";
		String strOrderBy = "";
		String perPage = "0";
		String strSearch = "";
		String requestType = "";
		inputObj = new JSONObject(input);

		// if (empId.equals("0")) {
		output = new LinkedHashMap<String, String>();
		// branchAccess = getSession("branchAccess", session).replaceAll("branchId", "oppr.opprBranchId");
		// exeAccess = getSession("exeAccess", session).replaceAll("empId", "oppr.opprEmpId");
		int page = 0;
		if (!inputObj.isNull("pageIndex")) {
			page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
		}
		perPage = CNumeric(getSession("empRecperpage", session));
		if (sort.equals("")) {
			sort = "DESC";
		}
		if (strOrderBy.equals("")) {
			strOrderBy = "pmId";
		}
		if (perPage.equals("0")) {
			perPage = "25";
		}
		page++;
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (requestType.equals("filter")) {
			strSearch += appBuildSmartSearch(input);
		}
		SOP("inputObj==================" + inputObj.toString());
		// strSearch += branchAccess + exeAccess;
		strOrderBy = " ORDER BY pm." + strOrderBy + " " + sort + "";
		ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();
		List<AxelaPm> resultSet = pmFilterImpl.findAll(strSearch, strOrderBy, page, Integer.parseInt(perPage), "yes");
		String totalCount = pmFilterImpl.totalCount;
		if (!totalCount.equals("0")) {
			for (AxelaPm obj : resultSet) {
				map.clear();
				map.put("pmId", obj.getPmId() + "");
				map.put("customerName", obj.getCustomerName());
				map.put("pmTitle", obj.getPmTitle());
				map.put("pmtypeName", obj.getPmtypeName());
				map.put("pmCompletePerc", obj.getPmCompletePerc() + "");
				map.put("pmActive", obj.getPmActive());
				map.put("pmBudget", obj.getPmBudget() + "");
				list.add((HashMap<String, String>) map.clone());
			}
			output.put("listData", list);
			response.setStatus(201);
		}
		else
		{
			output.put("msg", "No Records Found!");
		}
		if (AppRun().equals("0")) {
			SOP("output =========Axela listData============== " + output);
		}
		return output;
	}

}
