package axela.sales.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.service.repository.ModuleReportRepository;

@Service
public class SalesDashBoardService extends Connect {

	public Map output = new HashMap();
	public JSONObject inputObj = new JSONObject();

	public int empId = 0;
	public String branchAccess = "";
	public String exeAccess = "";

	@Autowired
	ModuleReportRepository moduleReportRepository;

	public Map SalesIndex(HttpSession session, HttpServletRequest request, HttpServletResponse response, String input) throws JSONException {
		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("inputObj==========opprServiceUpdate==========" + inputObj.toString(1));
		}
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		// if (empId != 0) {
		if (!returnPerm("emp_lead_access, emp_opportunity_access,"
				+ " emp_quote_access, emp_sales_order_access", session)) {
			output.put("errorPage", "Access denied. Please contact system administrator!");
			return output;
		}
		branchAccess = getSession("branchAccess", session).replaceAll("branchId", "oppr.opprBranchId");
		exeAccess = getSession("exeAccess", session).replaceAll("empId", "oppr.opprEmpId");
		ListReports();
		// }
		return output;
	}

	private void ListReports() {
		List<Object[]> result = moduleReportRepository.findListReports();
		List list = new ArrayList<HashMap>();
		for (Object[] obj : result) {
			Map map = new HashMap();
			map.put("reportId", obj[0]);
			map.put("reportName", obj[1]);
			map.put("reportUrl", obj[2]);
			list.add(map);
		}
		output.put("listReports", list);
	}
}
