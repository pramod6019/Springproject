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
import axela.customer.model.AxelaCustomerContact;
import axela.customer.repository.CustomerFilterImpl;

@Service
public class ReportContactAnniversaryService extends Connect {

	@Autowired
	CustomerFilterImpl customerFilterImpl;

	public String branchId = "";
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
	public String exeIds = "";
	public String teamIds = "";
	public String branchIds = "";

	public Map reportContactAnniversaryService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		branchAccess = PadQuotes(getSession("branchAccess", session)).replaceAll("branchId", "branch.customerBranchId");
		exeAccess = PadQuotes(getSession("exeAccess", session)).replaceAll("empId", "customer.customerEmpId");
		inputObj = new JSONObject(input);
		strSearch = "";
		requestType = "";
		inputObj = new JSONObject(input);
		getValues(inputObj);
		validateFields();
		listData();
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		if (!inputObj.isNull("startDate")) {
			startDate = PadQuotes(inputObj.getString("startDate"));
		}
		if (!inputObj.isNull("endDate")) {
			endDate = PadQuotes(inputObj.getString("endDate"));
		}

		if (!inputObj.isNull("branchId")) {
			branchId = PadQuotes(inputObj.getString("branchId"));
		}

	}
	protected void validateFields() {
		msg = "";
		if (startDate.equals("")) {
			msg = msg + "Select Start Date!";
		}

		if (endDate.equals("")) {
			msg = msg + "Select End Date!";
		}
	}

	public Map listData() throws ParseException {
		strSearch = "";
		if (msg.equals("")) {
			Map data = null;
			// List rec = new ArrayList();
			ArrayList rec = null;
			output = new HashMap();

			if (!startDate.equals("")) {
				strSearch += " AND contact.contactAnniversary >=" + compableDateToString(startDate);
			}
			if (!endDate.equals("")) {
				strSearch += " AND contact.contactAnniversary <=" + compableDateToString(endDate);
			}
			if (!branchId.equals("")) {
				strSearch += " AND branch.branchId IN (" + branchId + ")";
			}

			strSearch += branchAccess
					+ " AND branch.branchActive=1";

			List<AxelaCustomerContact> birthdayList = customerFilterImpl.findAllContactAnniversary(strSearch);
			rec = new ArrayList();
			if (birthdayList != null) {
				for (AxelaCustomerContact obj : birthdayList) {
					data = new HashMap();
					data.put("contactId", obj.getContactId());
					data.put("contactName", obj.getContactName());
					data.put("contactJobtitle", obj.getContactJobtitle());
					data.put("contactAnniversary", strToShortDate(obj.getContactAnniversary()));
					data.put("customerId", obj.getCustomerId());
					data.put("customerName", obj.getCustomerName());
					data.put("branchId", obj.getBranchId());
					data.put("branchName", obj.getBranchName() + " (" + obj.getBranchCode() + ")");
					rec.add(data);
				}
				output.put("contactAnniversary", rec);
			}
		}
		return output;

	}
	public String compableDateToString(String date) {
		String data = "";
		String[] arr = date.split("/");
		for (int i = arr.length - 1; i >= 0; i--) {
			data += arr[i];
		}
		return data + "000000";
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
