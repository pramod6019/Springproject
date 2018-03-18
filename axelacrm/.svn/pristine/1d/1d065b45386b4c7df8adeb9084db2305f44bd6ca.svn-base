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
public class ReportTopCustomersService extends Connect {
	@Autowired
	CustomerFilterImpl customerFilterImpl;

	public String startTime = "";
	public String endTime = "";
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
	public int count = 0;

	public Map output = new HashMap();

	public String startDate = "";
	public String endDate = "";
	public String franchiseeIds = "";
	public String exeIds = "";
	public String teamIds = "";
	public String branchIds = "";

	public Map reportTopCustomersDash(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		strSearch = "";
		requestType = "";
		startDate = "";
		endDate = "";
		franchiseeIds = "";
		branchIds = "";
		teamIds = "";
		exeIds = "";

		branchAccess = PadQuotes(getSession("branchAccess", session)).replaceAll("branchId", "branch.customerBranchId");
		exeAccess = PadQuotes(getSession("exeAccess", session)).replaceAll("empId", "customer.customerEmpId");
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
		if (!inputObj.isNull("franchiseeIds")) {
			if (inputObj.get("franchiseeIds") instanceof JSONArray)
				franchiseeIds = jsonArrayToString(inputObj.getJSONArray("franchiseeIds"));
		}

		if (!inputObj.isNull("branchIds")) {
			if (inputObj.get("branchIds") instanceof JSONArray)
				branchIds = jsonArrayToString(inputObj.getJSONArray("branchIds"));
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
	protected void validateFields() throws ParseException {
		msg = "";
		if (startDate.equals("")) {
			msg = msg + "Select Start Date!";
		}
		if (!startDate.equals("")) {
			if (!isValidDateFormatShort(startDate)) {
				msg = msg + "Enter Valid Start Date!";
				startDate = "";
			}
		}

		if (endDate.equals("")) {
			msg = msg + "Select End Date!";
		}
		if (!endDate.equals("")) {
			if (isValidDateFormatShort(endDate)) {
				if (!startDate.equals("") && !endDate.equals("")) {
					if (stringToDate(startDate).after(stringToDate(endDate))) {
						msg = msg + "Start Date should be less than End date!";
					}
				}
			} else {
				msg = msg + "Enter Valid End Date!";
				endDate = "";
			}
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
				strSearch += " AND voucher.voucherDate >=" + compableDateToString(startDate);
			}
			if (!endDate.equals("")) {
				strSearch += " AND voucher.voucherDate <=" + compableDateToString(endDate);
			}

			if (!franchiseeIds.equals("")) {
				strSearch += " AND branch.branchFranchiseeId IN (" + franchiseeIds + ")";
			}
			if (!branchIds.equals("")) {
				strSearch += " AND branch.branchId IN (" + branchIds + ")";
			}

			if (!teamIds.equals("")) {
				strSearch += " AND team.teamId IN (" + teamIds + ")";
			}

			if (!exeIds.equals("")) {
				strSearch += " AND emp.empId IN (" + exeIds + ")";
			}

			strSearch += branchAccess
					+ exeAccess
					+ " AND branch.branchActive=1";

			List<AxelaCustomer> salesList = customerFilterImpl.findAllSales(strSearch);
			rec = new ArrayList();
			if (salesList != null) {
				for (AxelaCustomer obj : salesList) {
					data = new HashMap();
					data.put("count", count++);
					data.put("customerId", obj.getCustomerId());
					data.put("customerName", obj.getCustomerName());
					data.put("sales", obj.getVoucherAmount());
					rec.add(data);
				}
				output.put("salesSegment", rec);
			}
			rec = new ArrayList();
			List<AxelaCustomer> invoiceList = customerFilterImpl.findAllInvoice(strSearch);
			count = 0;
			if (invoiceList != null) {
				for (AxelaCustomer obj : invoiceList) {
					data = new HashMap();
					data.put("count", count++);
					data.put("customerId", obj.getCustomerId());
					data.put("customerName", obj.getCustomerName());
					data.put("invoices", obj.getVoucherAmount());
					rec.add(data);
				}
				output.put("invoiceSegment", rec);
			}

			rec = new ArrayList();
			List<AxelaCustomer> recieptsList = customerFilterImpl.findAllReciepts(strSearch);
			count = 0;
			if (invoiceList != null) {
				for (AxelaCustomer obj : recieptsList) {
					data = new HashMap();
					data.put("count", count++);
					data.put("customerId", obj.getCustomerId());
					data.put("customerName", obj.getCustomerName());
					data.put("receipts", obj.getVoucherAmount());
					rec.add(data);
				}
				output.put("recieptsSegment", rec);
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
