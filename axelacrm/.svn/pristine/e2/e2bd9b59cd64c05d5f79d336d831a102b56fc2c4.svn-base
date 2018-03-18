package axela.customer.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.customer.model.AxelaCustomer;
import axela.customer.repository.CustomerFilterImpl;
import axela.service.model.AxelaModuleReport;

@Service
public class CustomerIndexService extends Connect {
	DecimalFormat deci = new DecimalFormat("0.00");
	public String branchAccess = "";
	public String exeAccess = "";
	String strSearch = "";
	@Autowired
	CustomerFilterImpl customerFilterImpl;
	Map output = null;
	List obj = null;
	Map data = null;
	List rec = null;
	Map kn = null;
	Map map = null;

	public Map customerIndexService(String input, HttpSession session) throws JSONException {
		branchAccess = getSession("branchAccess", session).replaceAll("branchId", "customer.customerBranchId");
		exeAccess = getSession("exeAccess", session).replaceAll("empId", "customer.customerEmpId");
		strSearch += branchAccess + exeAccess;
		output = new HashMap();
		rec = new ArrayList();
		map = new HashMap();

		// recent customer
		List<AxelaCustomer> recentCustomerList = customerFilterImpl.findAllRecentCustomer(strSearch);
		kn = new HashMap();
		if (recentCustomerList != null) {
			for (AxelaCustomer obj : recentCustomerList) {
				data = new HashMap();
				data.put("customerId", obj.getCustomerId());
				data.put("customerName", obj.getCustomerName());
				data.put("voucherAmount", deci.format(obj.getVoucherAmount()));
				rec.add(data);
			}
		}
		output.put("recentCustomers", rec);

		// top customer
		List<AxelaCustomer> topCustomerList = customerFilterImpl.findAllTopCustomer(strSearch);
		rec = new ArrayList();
		kn = new HashMap();

		if (topCustomerList != null) {
			for (AxelaCustomer obj : topCustomerList) {
				data = new HashMap();
				data.put("customerId", obj.getCustomerId());
				data.put("customerName", obj.getCustomerName());
				data.put("voucherAmount", deci.format(obj.getVoucherAmount()));
				rec.add(data);
			}
		}
		output.put("topCustomers", rec);

		// dashboard report details
		rec = new ArrayList();
		kn = new HashMap();

		for (AxelaModuleReport obj : customerFilterImpl.findModuleUrls()) {
			data = new HashMap();
			data.put("reportId", obj.getReportId());
			data.put("reportName", obj.getReportName());
			data.put("reportUrl", obj.getReportUrl());
			rec.add(data);
		}
		output.put("customerReports", rec);
		return output;
	}

}
