package axela.customer.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.customer.model.AxelaCustomer;
import axela.customer.model.AxelaCustomerContact;
import axela.customer.repository.CustomerFilterImpl;

@Service
public class CustomerDashService extends Connect {

	@Autowired
	CustomerFilterImpl customerFilterImpl;

	public String branchAccess = "";
	int customerId = 0;
	JSONObject inputObj = null;
	public String exeAccess = "";
	String strSearch = "";
	List output = null;
	List obj = null;
	Map data = null;
	List rec = null;

	public List customerDashService(String input, HttpSession session, HttpServletResponse response) throws ParseException, JSONException {
		branchAccess = PadQuotes(getSession("branchAccess", session)).replaceAll("branchId", "branch.branchId");
		exeAccess = PadQuotes(getSession("exeAccess", session)).replaceAll("empId", "emp.empId");
		inputObj = new JSONObject(input);
		output = new ArrayList();
		strSearch = branchAccess + branchAccess;
		if (!inputObj.isNull("customerId")) {
			customerId = Integer.parseInt(CNumeric(inputObj.getString("customerId")));
		}
		AxelaCustomer axelaCustomer = customerFilterImpl.findAllDashCustomerDetail(strSearch, customerId);
		data = new HashMap();
		if (axelaCustomer != null) {
			data.put("branchName", axelaCustomer.getBranchName() + " (" + axelaCustomer.getBranchCode() + ")");
			data.put("branchId", axelaCustomer.getBranchId());
			data.put("customerAddress1", axelaCustomer.getCustomerAddress1());
			data.put("customerLandmark", axelaCustomer.getCustomerLandmark());
			data.put("customerPhone1", axelaCustomer.getCustomerPhone1());
			data.put("customerPhone2", axelaCustomer.getCustomerPhone2());
			data.put("customerPhone3", axelaCustomer.getCustomerPhone3());
			data.put("customerEmail1", axelaCustomer.getCustomerEmpId());
			data.put("customerEmpId", axelaCustomer.getCustomerEmpId());
			data.put("customerWebsite1", axelaCustomer.getCustomerWebsite1());
			data.put("customerWebsite2", axelaCustomer.getCustomerWebsite2());
			data.put("customerPin", axelaCustomer.getCustomerPin());
			data.put("customerNotes", axelaCustomer.getCustomerNotes());
			data.put("customerActive", axelaCustomer.getCustomerActive());
			data.put("cityName", axelaCustomer.getCityName());
			data.put("countryName", axelaCustomer.getCountryName());
			data.put("empName", axelaCustomer.getEmpName());
		}
		output.add(data);

		List<AxelaCustomerContact> axelaCustomerContact = customerFilterImpl.findAllDashContactList(strSearch, customerId);
		if (axelaCustomer != null) {
			rec = new ArrayList();
			for (AxelaCustomerContact obj : axelaCustomerContact) {
				data = new HashMap();
				data.put("contactId", obj.getContactId());
				data.put("contactCustomerId", obj.getContactCustomerId());
				// data.put("titleDesc", obj.getTitleId());
				// data.put("contactFname", obj.getContactFname());
				// data.put("contactLname", obj.getContactLname());
				data.put("contactName", obj.getTitleId() + ". " + obj.getContactFname() + " " + obj.getContactLname());
				data.put("contactJobtitle", obj.getContactJobtitle());
				data.put("contactLocation", obj.getContactLocation());
				data.put("contactPhone1", obj.getContactPhone1());
				data.put("contactPhone2", obj.getContactPhone2());
				data.put("contactMobile1", obj.getContactMobile1());
				data.put("contactMobile2", obj.getContactMobile2());
				data.put("contactAnniversary", obj.getContactAnniversary());
				data.put("contactEmail1", obj.getContactEmail1());
				data.put("contactEmail2", obj.getContactEmail2());
				data.put("contactYahoo", obj.getContactYahoo());
				data.put("contactMsn", obj.getContactMsn());
				data.put("contactAol", obj.getContactAol());
				data.put("contactAddress", obj.getContactAddress());
				data.put("contactPin", obj.getContactPin());
				data.put("contactLandmark", obj.getContactLandmark());
				data.put("contactDob", obj.getContactDob());
				data.put("contactActive", obj.getContactActive());
				data.put("cityName", obj.getCityName());
				data.put("countryName", obj.getCountryName());
				data.put("customerId", obj.getCustomerId());
				data.put("customerName", obj.getCustomerName());
				data.put("branchName", obj.getBranchName() + " (" + axelaCustomer.getBranchCode() + ")");
				// data.put("branchCode", obj.getBranchCode());
				rec.add(data);
			}
		}
		output.add(rec);

		List<Object[]> customerDetailList = customerFilterImpl.findAllDashCustomerDetailsList(strSearch, customerId);
		if (customerDetailList.isEmpty() == false) {
			System.out.println("=============================");
			data = new HashMap();
			System.out.println("customerDetailList=====================" + customerDetailList);
			data.put("contactcount", customerDetailList.get(0));
			data.put("projectcount", customerDetailList.get(1));
			// data.put("opprcount", customerDetailList.get(2));
			// data.put("quotecount", customerDetailList.get(3));
			// data.put("socount", customerDetailList.get(4) + "k");
			// data.put("invoicecount", customerDetailList.get(5) + "k");
			// data.put("receiptcount", customerDetailList.get(6) + "k");
			// data.put("ticketcount", customerDetailList.get(7) + "k");
			// data.put("servicecontractcount", customerDetailList.get(8) + "k");
			// data.put("billcount", customerDetailList.get(9) + "k");
			// data.put("assetcontractcount", customerDetailList.get(10));
			output.add(data);

		}
		return output;
	}
}
