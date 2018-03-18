package axela.service.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.service.model.AxelaModuleReport;
import axela.service.repository.ModuleReportFilterImpl;
import axela.service.repository.ModuleReportRepository;

@Service
public class ServiceIndex extends Connect {

	@Autowired
	ModuleReportRepository moduleReportRepository;

	@Autowired
	ModuleReportFilterImpl moduleReportFilterImpl;

	public String msg = "";
	public String StrSql = "";
	public String empId = "0";
	public String branchId = "0";
	public String compId = "0";
	public String StrLibrary = "";
	public String ExeAccess = "";
	public String StrSearch = "";
	public String smart = "";
	public String BranchAccess = "";
	public String ticketchartData = "";
	// public String jcprioritychart_data = "";
	public String jcchartData = "";
	public int TotalRecords = 0;
	public String jcprioritychartData = "";
	public String jcstagechartData = "";
	HashMap output = null;
	JSONObject inputObj = null;
	public String requestType = "";

	public Map<String, String> serviceIndex(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = CNumeric(PadQuotes(getSession("empId", session)));
		compId = CNumeric(PadQuotes(getSession("compId", session)));
		branchId = CNumeric(getSession("empBranchId", session));
		ExeAccess = getSession("exeAccess", session);
		BranchAccess = getSession("branchAccess", session);
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (!inputObj.isNull("smart")) {
			smart = inputObj.getString("smart");
			if (smart == null) {
				smart = "";
			}
			if (msg.equals("")) {
				// TicketEscStatus();
				// JCPriorityEscStatus();
				// JCStageEscStatus();
				if (smart.equals("yes")) {
				} else {
					setSession("ticketstrsql", StrSearch, session);
				}
			}
		}
		return output;
	}

	public Map populateDashBoardDetails() throws JSONException, ParseException {
		HashMap output = new HashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (AxelaModuleReport obj : moduleReportFilterImpl.findAll()) {
			HashMap map = new HashMap();
			map.put("reportId", obj.getReportId());
			map.put("reportName", obj.getReportName());
			map.put("reportUrl", obj.getReportUrl());
			list.add(map);
		}
		output.put("populateDashBoardDetails", list);
		return output;
	}

}
