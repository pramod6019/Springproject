package axela.inventory.service;

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
import axela.portal.model.AxelaConfig;
import axela.portal.repository.ConfigRepository;
@Service
public class ConfigureInventoryService extends Connect {
	@Autowired
	public ConfigRepository configRepository;

	public String requestType = "";
	public String pageNumber = "";
	public int empId = 0;
	public int compId = 0;
	public String msg = "";
	public String configInventoryCurrentStock = "0";
	public String configInventoryPoRefno = "0";
	public String configInventoryLocationName = "";

	HashMap output = null;
	JSONObject inputObj = null;

	public Map configureInventoryService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new HashMap();
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			switch (requestType) {
				case "update" :// update
					getValues();
					addFields(response);
					setSession("configInventoryCurrentStock", configInventoryCurrentStock, session);
					break;
			}
		}
		return output;
	}

	public void getValues() throws JSONException {
		msg = "";
		if (!inputObj.isNull("configInventoryPoRefno")) {
			configInventoryPoRefno = CNumeric(inputObj.getString("configInventoryPoRefno"));
		}
		if (!inputObj.isNull("configInventoryLocationName")) {
			configInventoryLocationName = PadQuotes(inputObj.getString("configInventoryLocationName"));
		}
		if (!inputObj.isNull("configInventoryCurrentStock")) {
			configInventoryCurrentStock = CNumeric(inputObj.getString("configInventoryCurrentStock"));
		}
	}

	public void validateFields() {
		if (configInventoryLocationName.equals("")) {
			msg += "<br>Enter Opportunity Name!";
		} else {
			if (!configInventoryLocationName.matches("[a-zA-Z ]*")) {
				msg += "<br>Opportunity Name cannot contain special characters or numbers!";
			}
			if (configInventoryLocationName.length() < 4) {
				msg += "<br>Opportunity Name should contain atleast 4 characters!";
			}
		}
	}

	public void addFields(HttpServletResponse response) throws JSONException, ParseException {
		validateFields();
		output = new HashMap();
		if (msg.equals("")) {
			AxelaConfig axelaConfig = configRepository.findAllInventoryUpdate();
			if (axelaConfig != null) {
				axelaConfig.setConfigId(axelaConfig.getConfigId());
				axelaConfig.setConfigInventoryCurrentStock(configInventoryCurrentStock);
				axelaConfig.setConfigInventoryPoRefno(configInventoryPoRefno);
				axelaConfig.setConfigInventoryLocationName(configInventoryLocationName);
				String ConfigId = configRepository.save(axelaConfig).getConfigId() + "";
				if (!ConfigId.equals("0") && requestType.equals("update")) {
					output.put("ConfigId", ConfigId);
					output.put("successmsg", "Configuration Details Updated Successfully for Inventory!");
				}
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public Map populateData(String input, HttpSession session) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		List<Object[]> configDetail = configRepository.findInventoryConfigDetails();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (configDetail != null) {
			for (Object[] obj : configDetail) {
				HashMap map = new HashMap();
				map.put("configInventoryCurrentStock", String.valueOf(obj[0]));// obj.getConfigInventoryCurrentStock()
				map.put("configInventoryPoRefno", String.valueOf(obj[1]));// obj.getConfigInventoryPoRefno()
				map.put("configInventoryLocationName", String.valueOf(obj[2]));// obj.getConfigInventoryLocationName(
				list.add(map);
			}
			output.put("populateData", list);
		}

		return output;
	}

}
