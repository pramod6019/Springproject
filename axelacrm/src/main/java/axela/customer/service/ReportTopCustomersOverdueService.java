package axela.customer.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.customer.model.AxelaCustomer;
import axela.customer.repository.CustomerFilterImpl;

@Service
public class ReportTopCustomersOverdueService extends Connect {

	@Autowired
	CustomerFilterImpl customerFilterImpl;

	public String startTime = "";
	public String endTime = "";
	public String branchId = "0";
	public String branchAccess = "";
	public String exeAccess = "";
	public JSONObject inputObj = null;
	public String strSearch = "";
	public String requestType = "";
	public String contactBranchId = "0";
	public String msg = "";
	public String teamId = "";
	public String exeId = "";
	public String franchiseeId = "";
	public int total = 0;
	public Map output = new HashMap();

	public String startDate = "";
	public String endDate = "";
	public String franchiseeIds = "";
	public String exeIds = "";
	public String teamIds = "";
	public String branchIds = "";
	public Map data = null;
	public ArrayList rec = null;

	public Map reportTopCustomersOverdueService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		branchAccess = PadQuotes(getSession("branchAccess", session)).replaceAll("branchId", "branch.customerBranchId");
		exeAccess = PadQuotes(getSession("exeAccess", session)).replaceAll("empId", "customer.customerEmpId");
		inputObj = new JSONObject(input);
		inputObj = new JSONObject(input);
		strSearch = "";
		getValues(inputObj);
		listData();
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		if (!inputObj.isNull("branchId")) {
			branchId = PadQuotes(inputObj.getString("branchId"));
		}
		if (!inputObj.isNull("teamIds")) {
			if (inputObj.get("teamIds") instanceof JSONArray)
				teamIds = jsonArrayToString(inputObj.getJSONArray("teamIds"));
		}
		if (!inputObj.isNull("exeIds")) {
			if (inputObj.get("exeIds") instanceof JSONArray)
				exeIds = jsonArrayToString(inputObj.getJSONArray("exeIds"));
		}

	}

	public Map listData() throws ParseException {
		strSearch = "";
		if (msg.equals("")) {
			output = new HashMap();

			if (!branchId.equals("0")) {
				strSearch += " AND (emp.empBranchId =" + branchId + ""
						+ " OR emp.empId = 1"
						+ " OR emp.empId IN(SELECT empbr.empId"
						+ " FROM  AxelaEmpBranch empbr"
						+ " WHERE emp.empId = empbr.empId"
						+ " AND empbr.empBranchId = " + branchId + "))";
			}

			if (!teamIds.equals("")) {
				strSearch += " AND emp.empId IN (SELECT exe.teamtransEmpId"
						+ " FROM  AxelaSalesTeamExe exe"
						+ " WHERE exe.teamtransTeamId IN (" + teamIds + "))";
			}

			if (!exeIds.equals("")) {
				strSearch += " AND emp.empId IN (" + exeIds + ")";
			}

			strSearch += branchAccess
					+ exeAccess
					+ " customer.customerActive=1";

			List<AxelaCustomer> salesList = customerFilterImpl.findAllTopCustomerOverdues(strSearch);
			rec = new ArrayList();
			if (salesList != null) {
				for (AxelaCustomer obj : salesList) {
					data = new HashMap();
					data.put("customerId", obj.getCustomerId());
					data.put("customerName", obj.getCustomerName());
					data.put("ammount", obj.getCustomerCurrBal());
					rec.add(data);
				}
				output.put("overdue", rec);
			}
		}
		return output;
	}

	public String jsonArrayToString(JSONArray jsonarray) throws JSONException {
		StringBuilder str = new StringBuilder();
		if (jsonarray.length() > 1) {
			str.append(jsonarray.getInt(0));
			SOP("jsonarray.length()" + jsonarray.length());
			for (int i = 1; i < jsonarray.length(); i++) {
				str.append(",").append(jsonarray.getInt(i));
			}
		} else if (jsonarray.length() == 1) {
			str.append(jsonarray.getInt(0));
		}
		return str.toString();
	}

}
