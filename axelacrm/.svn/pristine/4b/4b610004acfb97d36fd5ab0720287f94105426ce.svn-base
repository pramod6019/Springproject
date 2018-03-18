package axela.customer.service;

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

@Service
public class CustomerDashBoardService extends Connect {

	public String branchAccess = "";
	public String exeAccess = "";
	String strSearch = "";
	@Autowired
	CustomerFilterImpl customerFilterImpl;
	List output = null;
	List obj = null;
	Map data = null;
	List rec = null;

	public List customerDashBoardService(String input, HttpSession session) throws JSONException {
		branchAccess = getSession("branchAccess", session).replaceAll("branchId", "customer.customerBranchId");
		exeAccess = getSession("exeAccess", session).replaceAll("empId", "customer.customerEmpId");
		strSearch += branchAccess + exeAccess;
		output = new ArrayList();
		rec = new ArrayList();

		// recent customer
		List<AxelaCustomer> recentCustomerList = customerFilterImpl.findAllRecentCustomer(strSearch);
		if (recentCustomerList != null) {
			for (AxelaCustomer obj : recentCustomerList) {
				data = new HashMap();
				data.put("customerId", obj.getCustomerId());
				data.put("customerName", obj.getCustomerName());
				data.put("voucherAmount", obj.getVoucherAmount());
				rec.add(data);
			}
		}
		output.add(rec);

		// top customer
		List<AxelaCustomer> topCustomerList = customerFilterImpl.findAllTopCustomer(strSearch);
		rec = new ArrayList();
		if (topCustomerList != null) {
			for (AxelaCustomer obj : topCustomerList) {
				data = new HashMap();
				data.put("customerId", obj.getCustomerId());
				data.put("customerName", obj.getCustomerName());
				data.put("voucherAmount", obj.getVoucherAmount());
				rec.add(data);
			}
		}
		output.add(rec);
		return output;
	}

}
