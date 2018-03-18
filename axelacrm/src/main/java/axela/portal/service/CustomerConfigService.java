package axela.portal.service;

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
import axela.portal.model.AxelaConfig;
import axela.portal.repository.ConfigRepository;

@Service
public class CustomerConfigService extends Connect {

	@Autowired
	ConfigRepository configRepository;

	public String configId = "0";
	public String configCustomerSoe = "";
	public String configCustomerSob = "";
	public String configCustomerAddress = "";
	public String configCustomerDupnames = "";
	public String configCustomerName = "";
	public String requestType = "";
	public String pageNumber = "";
	public int empId = 0;
	public int compId = 0;
	public String msg = "";
	public int page = 0;
	public String perpage = "0";
	public String sort = "";
	public String field = "";
	public String branchAccess = "";
	public String perPage = "0";
	public String strSearch = "";
	public String orderType = "";
	public String orderByField = "";
	public String strOrderBy = "";

	HashMap output = null;
	JSONObject inputObj = null;

	public Map customerConfigService(String input, HttpSession session, HttpServletResponse response) throws JSONException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		perPage = getSession("perPage", session);
		perPage = CNumeric(getSession("empRecperpage", session));
		if (empId != 0) {
			inputObj = new JSONObject(input);
			SOP("inputObj==================" + inputObj);
			output = new HashMap();
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			switch (requestType) {
				case "add" : // add
					configId = "0";
					getValues(inputObj);
					addFields(response);
					break;
				case "update" :// update
					SOP("update==================" + inputObj);
					configId = "0";
					getValues(inputObj);
					addFields(response);
					break;
				case "delete" :// delete
					if (!inputObj.isNull("soeId")) {
						configId = inputObj.getString("soeId");
					}
					if (!configId.equals("0")) {
						deleteFields(configId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		SOP("getValues==================" + inputObj);
		msg = "";
		if (!inputObj.isNull("configId")) {
			configId = CNumeric(inputObj.getString("configId"));
		}
		if (!inputObj.isNull("configCustomerName")) {
			configCustomerName = PadQuotes(inputObj.getString("configCustomerName"));
		}
		if (!inputObj.isNull("configCustomerSoe")) {
			configCustomerSoe = (inputObj.getString("configCustomerSoe")) + "";
		}
		if (!inputObj.isNull("configCustomerSob")) {
			configCustomerSob = (inputObj.getString("configCustomerSob")) + "";
		}
		if (!inputObj.isNull("configCustomerAddress")) {
			configCustomerAddress = (inputObj.getString("configCustomerAddress")) + "";
		}
		if (!inputObj.isNull("configCustomerDupnames")) {
			configCustomerDupnames = (inputObj.getString("configCustomerDupnames")) + "";
		}
	}

	public void validateFields() {
		msg = "";
		if (configCustomerName.equals("")) {
			msg += "<br>Enter Customer Name!";
		} else {
			// SOP("special characters = " + config_customer_name.matches("[a-zA-Z ]*"));
			if (configCustomerName.matches("[a-zA-Z ]*")) {
				msg += "<br>Customer Name cannot contain special characters or numbers!";
			}
			if (configCustomerName.length() < 4) {
				msg += "<br>Customer Name should contain atleast 4 characters!";
			}
		}
	}

	public void addFields(HttpServletResponse response) throws JSONException {
		// validateFields();
		output = new HashMap();
		if (msg.equals("")) {
			AxelaConfig axelaConfig = null;
			if (!configId.equals("0")) {
				axelaConfig = configRepository.findOne(Integer.parseInt(configId));
			}
			axelaConfig.setConfigCustomerSoe(configCustomerSoe);
			axelaConfig.setConfigCustomerSob(configCustomerSob);
			axelaConfig.setConfigCustomerAddress(configCustomerAddress);
			axelaConfig.setConfigCustomerDupnames(configCustomerDupnames);
			axelaConfig.setConfigCustomerName(configCustomerName);
			SOP("" + axelaConfig);
			String configId = configRepository.save(axelaConfig).getConfigId() + "";
			if (!configId.equals("0") && requestType.equals("update")) { // if id = 0 -> add mode else update mode
				output.put("ConfigId", configId);
				output.put("successmsg", "Configuration details Updated Successfully for Customers!");
			} else {
				response.setStatus(400); // Bad request since missing mandatory fields from client.
				output.put("errormsg", msg);
			}
		}
	}

	public void deleteFields(String configId) {
		configRepository.delete(Integer.parseInt(configId));
		output.put("successmsg", "Configuration details  Deleted Successfully!");

	}

	public Map populateData(String input) throws JSONException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("configId")) {
			configId = PadQuotes(CNumeric(inputObj.getString("configId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!configId.equals("0")) {
			AxelaConfig config = configRepository.findOne(Integer.parseInt(configId));
			HashMap map = new HashMap();
			map.put("configId", configId);
			map.put("configCustomerSoe", (Integer.parseInt(config.getConfigCustomerSoe())));
			map.put("configCustomerSob", (Integer.parseInt(config.getConfigCustomerSob())));
			map.put("configCustomerAddress", (Integer.parseInt(config.getConfigCustomerAddress())));
			map.put("configCustomerDupnames", (Integer.parseInt(config.getConfigCustomerDupnames())));
			map.put("configCustomerName", String.valueOf(config.getConfigCustomerName()));
			list.add(map);
		}
		output.put("populateData", list);
		return output;
	}
}
