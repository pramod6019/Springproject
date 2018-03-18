package axela.portal.service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.portal.model.AxelaEmp;
import axela.portal.repository.EmpRepository;
@Service
public class SystemThemeService extends Connect {

	public int empId = 0;
	public byte themeId = 0;
	public String requestType = "";
	public String msg = "";
	HashMap output = null;
	JSONObject inputObj = null;
	int compId = 0;

	@Autowired
	EmpRepository empRepository;

	public Map<String, String> systemThemeService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}

		switch (requestType) {
			case "update" :
				themeId = 0;
				getValues(inputObj);
				addFields(response);
				break;
		}
		return output;
	}

	public void getValues(JSONObject inputObj) {
		try {
			msg = "";
			if (!inputObj.isNull("themeId")) {
				themeId = Byte.parseByte(inputObj.getString("themeId"));
			}
		} catch (Exception ex) {
			System.out.println("Axela CRM====" + this.getClass().getName());
			System.out.println("Error in " + new Exception().getStackTrace()[0].getMethodName() + ": " + ex);
		}
	}

	public void addFields(HttpServletResponse response) throws ParseException {
		output = new HashMap();
		if (msg.equals("")) {
			AxelaEmp axelaEmp = null;
			if (empId != 0) {
				axelaEmp = empRepository.findOne(empId);
			}
			axelaEmp.setEmpThemeId(themeId);
			empRepository.save(axelaEmp);
			if (themeId != 0 && requestType.equals("update")) {
				output.put("successmsg", "Theme Updated Successfully!");
			}
		} else {
			response.setStatus(400);
			output.put("errormsg", msg);
		}
	}
}
