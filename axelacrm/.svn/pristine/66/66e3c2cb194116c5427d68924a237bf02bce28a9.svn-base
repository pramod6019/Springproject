package axela.sales.service;

import java.sql.Connection;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import axela.config.Connect;
import axela.customer.model.AxelaCustomer;
import axela.customer.repository.CustomerFilterImpl;
import axela.customer.repository.CustomerRepository;
import axela.portal.repository.AxelaCityRepository;
import axela.portal.repository.AxelaCountryRepository;
import axela.portal.repository.AxelaCustomerItstatusRepository;
import axela.portal.repository.AxelaSobRepository;
import axela.portal.repository.AxelaSoeRepository;
import axela.portal.repository.AxelaStateRepository;
import axela.portal.repository.BranchRepository;
import axela.portal.repository.EmpRepository;

@Service
public class SalesService extends Connect {

	private final static int PAGESIZE = 25;
	public String addB = "";
	public String msg = "";
	public String emp_opportunity_edit = "";
	public String oppr_id = "0";
	public String oppr_no = "";
	public String oppr_branch_id = "0";
	public String lead_branch_id = "0";
	public int len = 0;
	public String lead_id = "0";
	public String lead_title_id = "0";
	public String oppr_customer_id = "0";
	public String oppr_contact_id = "0";
	public String oppr_title = "";
	public String oppr_desc = "";
	public String opprdate = "", oppr_date = "";
	public String oppr_close_date = "", close_date = "";
	public String oppr_travel_fromdate = "", travel_fromdate = "";
	public String oppr_travel_todate = "", travel_todate = "";
	public String oppr_traveltype_id = "";
	public String oppr_travel_rooms = "";
	public String oppr_travel_adults = "";
	public String oppr_travel_children = "";
	public String oppr_emp_id = "0";
	public String oppr_campaign_id = "0";
	public String oppr_soe_id = "0";
	public String oppr_sob_id = "0";
	public String oppr_pm_id = "0";
	public String oppr_refno = "";
	public String oppr_notes = "";
	public String oppr_entry_id = "0", oppr_entry_date = "";
	public String entry_by = "", entry_date = "";
	public String branch_id = "0";
	public String branch_name = "";
	public String city_id = "0";
	public String emp_id = "0";
	public String emp_name = "";
	public String emp_email = "";
	public String emp_mobile = "";
	public String lead_fname = "";
	public String lead_lname = "";
	public String title_desc = "";
	public String contact_name = "";
	public String contact_info = "";
	public String lead_jobtitle = "";
	public String contact_mobile1 = "";
	public String contact_email1 = "";
	public String contact_mobile2 = "";
	public String contact_phone1 = "";
	public String contact_phone2 = "";
	public String contact_email2 = "";
	public String emp_mobile1 = "";
	public String emp_mobile2 = "";
	public String emp_email1 = "";
	public String emp_email2 = "";
	public String emp_email_formail = "";
	public String contact_address = "";
	public String contact_city_id = "0";
	public String contact_pin = "";
	public String contact_dnd = "0";
	// public String lead_empcount_id = "0";
	public String customer_name = "";
	public String customer_info = "";
	public String customer_website = "";
	public Connection conntx = null;
	public Statement stmttx = null;
	public String BranchAccess = "";
	public String team_id = "0";
	public String config_oppr_email_enable = "";
	public String config_oppr_email_sub = "";
	public String config_oppr_email_format = "";
	public String config_oppr_email_exe_sub = "";
	public String config_oppr_email_exe_format = "";
	public String config_oppr_sms_enable = "";
	public String config_oppr_sms_exe_format = "";
	public String config_oppr_sms_format = "";
	public String branch_email1 = "";
	public String config_email_enable = "";
	public String config_sms_enable = "";
	public String config_sales_lead_for_oppr = "";
	public String config_customer_dupnames = "";
	public String comp_email_enable = "";
	public String comp_sms_enable = "";
	public String config_customer_address = "";
	public String config_sales_oppr_refno = "";
	public String config_sales_oppr_model = "";
	public String config_sales_oppr_item = "";
	public String config_sales_campaign = "";
	public String config_sales_soe = "";
	public String emp_role_id = "";
	public String config_sales_sob = "";
	public String comp_module_pm = "";
	public String comp_businesstype_id = "";
	public String config_sales_oppr_name = "";
	public String StrSql = "";
	public String oppr_model_id = "0";
	public String oppr_item_id = "0";
	public String model_name = "0";
	public String ExeAccess = "";
	public String config_customer_name = "";
	// Brochure variables
	public String attachment = "";
	public String config_oppr_brochure_email_enable = "";
	public String config_oppr_brochure_email_format = "";
	public String config_oppr_brochure_email_sub = "";
	// End of Brochure variables

	public String config_oppr_projbrochure_email_enable = "";
	public String config_oppr_projbrochure_email_format = "";
	public String config_oppr_projbrochure_email_sub = "";
	// End of Project Brochure variables

	public String crm_emp_id = "0";
	// public String presf_manager_id = "0";
	public String send_contact_email = "";
	public String config_sales_oppr_project;
	public String config_sales_oppr_budget;
	public String emp_formatdate = "";
	public String formatdate_datepicker = "";
	public String emp_formattime = "";
	public String opprcity = "";
	public String customer_empcount_id = "0";
	public String current_date = "";
	public String[] trans_destination_id = new String[10];
	public String requesttype = "";
	HashMap output = null;
	JSONObject inputObj = null;
	// @Autowired
	// private PopulateService populateService;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerFilterImpl customerFilter;

	@Autowired
	private EmpRepository empRepository;

	@Autowired
	private AxelaCustomerItstatusRepository axelaCustomerItstatusRepository;

	@Autowired
	private AxelaCityRepository axelaCityRepository;

	@Autowired
	private AxelaStateRepository axelaStateRepository;

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private AxelaSoeRepository axelaSoeRepository;

	@Autowired
	private AxelaSobRepository axelaSobRepository;

	@Autowired
	private AxelaCountryRepository axelaCountryRepository;
	private String exeAccess;
	private String comp_id;

	// @Autowired
	// private HttpSession session;

	public Map<String, String> customerService(String input, HttpServletRequest request, HttpServletResponse response) throws JSONException {
		SOP("inputObj===" + new JSONObject(input));
		comp_id = CNumeric(GetSession("comp_id", request)) + "";
		inputObj = new JSONObject(input);
		output = new HashMap();
		if (!inputObj.isNull("requesttype")) {
			requesttype = inputObj.getString("requesttype");
		}
		switch (requesttype) {
			case "add" : // add an customer.
				// SOP("inputObj==========");
				getValues(inputObj);
				validateFields();
				addFields(response);
				break;

			case "update" :// update an customer.
				getValues(inputObj);
				validateFields();
				addFields(response);
				break;

			case "delete" :// delete an customer.
				break;
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
	}

	public void validateFields() {

	}

	public void addFields(HttpServletResponse response) {
		AxelaCustomer axelaCustomer = null;
		if (msg.equals("")) {

			if (oppr_id.equals("0")) { // if id = 0 -> add mode else update mode
				output.put("successmsg", "Customer Added Successfully!");
			} else {
				output.put("successmsg", "Customer Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String customer_id) {
		output.put("succesmsg", "Customer Deleted Successfully!");
	}

	public Map<String, String> listData(WebRequest webrequest, String input, HttpSession session) throws JSONException {
		return output;
	}
}