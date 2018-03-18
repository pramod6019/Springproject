package axela.service.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import axela.service.model.AxelaServiceContractAsset;

@Service
public class ServiceConfigService extends Connect {

	@Autowired
	ConfigRepository configRepository;

	public String compId = "0";
	public String StrSql = "";
	public String msg = "";
	public String name = "";
	public String configJcNewEmailEnable = "0";
	public String configJcNewEmailFormat = "";
	public String configJcNewSmsEnable = "0";

	public String configJcNewEmailSub = "";
	public String configJcNewSmsFormat = "0";

	public String configJcReadyEmail_sub = "";
	public String configJcReadySmsFormat = "0";

	public String configJcDeliveredEmailSub = "";
	public String configJcDeliveredEmailFormat = "0";

	public String configJcReadyEmailEnable = "0";
	public String configJcReadyEmailFormat = "";
	public String configJcReadySmsEnable = "0";

	public String configJcDeliveredEmailEnable = "0";
	public String configJcDeliveredSmsEnable = "0";
	public String configJcDeliveredSmsFormat = "0";

	public String configServiceTicket = "";
	public String configServiceContract = "";
	public String configServiceTicketCat = "";
	public String configServiceTicketType = "";
	public String configServiceJobcardCat = "";
	public String configServiceJobcardType = "";

	public String configServiceContractRefno = "";
	public String configServiceTicketRefno = "";
	public String configServiceJobcardRefno = "";
	public String configServiceJobcardSerialnoMandatory = "";
	public String configTicketNewEmailEnable = "";
	public String configTicketNewEmailSub = "";
	public String configTicketNewEmailFormat = "";
	public String configTicketNewEmailExeSub = "";
	public String configTicketNewEmailExeFormat = "";
	public String configTicketNewSmsEnable = "";
	public String configTicketNewSmsFormat = "";
	public String configTicketNewSmsExeFormat = "";
	public String configTicketFollowupEmailEnable = "";
	public String configTicketFollowupEmailSub = "";
	public String configTicketFollowupEmail_format = "";
	public String configTicketFollowupEmailExeSub = "";
	public String configTicketFollowupEmailExeFormat = "";
	public String configTicketFollowupSmsEnable = "";
	public String configTicketFollowupSmsFormat = "";
	public String configTicketFollowupSmsExeFormat = "";
	public String configTicketClosedEmailEnable = "";
	public String configTicketClosedEmailSub = "";
	public String configTicketClosedEmailFormat = "";
	public String configTicketClosedEmailExeSub = "";
	public String configTicketClosedEmailExeFormat = "";
	public String configTicketClosedSmsEnable = "";
	public String requestType = "";
	public String empId = "";
	public String configId = "0";
	public String configTicketClosedSmsFormat = "";
	public JSONObject inputObj;

	public Map output = new HashMap();

	public Map serviceConfigService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("inputObj========ServiceConfig==========" + inputObj.toString(1));
		}
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		empId = CNumeric(PadQuotes(getSession("empId", session)));
		compId = CNumeric(PadQuotes(getSession("compId", session)));
		if (!empId.equals("0")) {
			if (requestType.equals("update")) {
				if (!returnPerm("comp_id , emp_role_id", session)) {
					output.put("errorPage", "Access denied. Please contact system administrator!");
					return output;
				}
				SOP("coming=====");
				getValues(inputObj);
				SOP("coming=====");
				updateFields(response, session);
			}

		} else {
			output.put("errormsg", msg);
		}
		if (AppRun().equals("0")) {
			SOP("inputObj========ServiceConfig==========" + output);
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException, ParseException {
		msg = "";
		if (!inputObj.isNull("configServiceContract")) {
			configServiceContract = PadQuotes(inputObj.getString("configServiceContract"));
		}

		if (!inputObj.isNull("configServiceJobcardCat")) {
			configServiceJobcardCat = PadQuotes(inputObj.getString("configServiceJobcardCat"));
		}

		if (!inputObj.isNull("configServiceJobcardType")) {
			configServiceJobcardType = PadQuotes(inputObj.getString("configServiceJobcardType"));
		}

		if (!inputObj.isNull("configServiceContractRefno")) {
			configServiceContractRefno = PadQuotes(inputObj.getString("configServiceContractRefno"));
		}

		if (!inputObj.isNull("configServiceJobcardRefno")) {
			configServiceJobcardRefno = PadQuotes(inputObj.getString("configServiceJobcardRefno"));
		}
		if (!inputObj.isNull("configServiceJobcardSerialnoMandatory")) {
			configServiceJobcardSerialnoMandatory = PadQuotes(inputObj.getString("configServiceJobcardSerialnoMandatory"));
		}

		if (!inputObj.isNull("configJcNewEmailEnable")) {
			configJcNewEmailEnable = PadQuotes(inputObj.getString("configJcNewEmailEnable"));
		}

		if (!inputObj.isNull("configJcReadyEmailEnable")) {
			configJcReadyEmailEnable = PadQuotes(inputObj.getString("configJcReadyEmailEnable"));
		}
		if (!inputObj.isNull("configJcNewSmsEnable")) {
			configJcNewSmsEnable = PadQuotes(inputObj.getString("configJcNewSmsEnable"));
		}
		if (!inputObj.isNull("configJcReadySmsEnable")) {
			configJcReadySmsEnable = PadQuotes(inputObj.getString("configJcReadySmsEnable"));
		}
		if (!inputObj.isNull("configJcDeliveredEmailEnable")) {
			configJcDeliveredEmailEnable = PadQuotes(inputObj.getString("configJcDeliveredEmailEnable"));
		}
		if (!inputObj.isNull("configJcDeliveredSmsEnable")) {
			configJcDeliveredSmsEnable = PadQuotes(inputObj.getString("configJcDeliveredSmsEnable"));
		}
	}

	public void updateFields(HttpServletResponse response, HttpSession session) throws ParseException {
		SOP("COMING+1111111111");
		output = new HashMap();
		if (msg.equals("")) {
			AxelaConfig axelaConfig = configRepository.findAllInventoryUpdate();
			if (axelaConfig != null) {
				axelaConfig.setConfigServiceContract(configServiceContract);
				axelaConfig.setConfigServiceJobcardCat(configServiceJobcardCat);
				axelaConfig.setConfigServiceJobcardType(configServiceJobcardType);
				axelaConfig.setConfigServiceContractRefno(configServiceContractRefno);
				axelaConfig.setConfigServiceJobcardRefno(configServiceJobcardRefno);
				axelaConfig.setConfigServiceJobcardSerialnoMandatory(configServiceJobcardSerialnoMandatory);
				axelaConfig.setConfigJcNewEmailEnable(configJcNewEmailEnable);
				axelaConfig.setConfigJcNewSmsEnable(configJcNewSmsEnable);
				axelaConfig.setConfigJcReadySmsEnable(configJcReadySmsEnable);
				axelaConfig.setConfigJcReadyEmailEnable(configJcReadyEmailEnable);
				axelaConfig.setConfigJcDeliveredEmailEnable(configJcDeliveredEmailEnable);
				axelaConfig.setConfigJcDeliveredSmsEnable(configJcDeliveredSmsEnable);
				String configId = configRepository.save(axelaConfig).getConfigId() + "";
				if (requestType.equals("update")) {
					output.put("configId", configId);
					output.put("successmsg", "Service Config Updated Successfully!");
				}
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}
	public Map<String, String> populateData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap();
		empId = CNumeric(PadQuotes(getSession("empId", session)));
		if (!empId.equals("0")) {
			if (!returnPerm("emp_role_id", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			LinkedHashMap map = new LinkedHashMap();
			List<AxelaConfig> config = configRepository.findByServiceConfig();
			AxelaServiceContractAsset axelaServiceContractAsset = new AxelaServiceContractAsset();
			for (AxelaConfig results : config) {
				map.put("configServiceContract", String.valueOf(results.getConfigServiceContract()));
				map.put("configServiceJobcardCat", String.valueOf(results.getConfigServiceJobcardCat()));
				map.put("configServiceJobcardType", "" + results.getConfigServiceJobcardType());
				map.put("configServiceContractRefno", String.valueOf(results.getConfigServiceContractRefno()));
				map.put("configServiceJobcardRefno", String.valueOf(results.getConfigServiceJobcardRefno()));
				map.put("configServiceJobcardSerialnoMandatory", "" + results.getConfigServiceJobcardSerialnoMandatory());
				map.put("configJcNewEmailEnable", "" + results.getConfigJcNewEmailEnable());
				map.put("configJcNewSmsEnable", "" + results.getConfigJcNewSmsEnable());
				map.put("configJcReadyEmailEnable", "" + results.getConfigJcReadyEmailEnable());
				map.put("configJcReadySmsEnable", "" + results.getConfigJcReadySmsEnable());
				map.put("configJcDeliveredEmailEnable", "" + results.getConfigJcDeliveredEmailEnable());
				map.put("configJcDeliveredSmsEnable", "" + results.getConfigJcDeliveredSmsEnable());
			}
			list.add(map);
			output.put("populateData", list);
		}
		return output;
	}
}
