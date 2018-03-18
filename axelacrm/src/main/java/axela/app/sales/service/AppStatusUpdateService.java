package axela.app.sales.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.portal.repository.EmpRepository;

@Service
public class AppStatusUpdateService extends Connect {
	public int empId = 0;
	public String compId = "0";
	public String empStatus = "";
	ArrayList<String> list = new ArrayList<String>();
	HashMap output = new HashMap();
	private JSONObject inputObj = null;
	public String status = "";
	Map map = new HashMap();

	@Autowired
	public EmpRepository emprepository;
	public Map statusUpdate(String input, HttpSession session, HttpServletRequest request) throws JSONException {
		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
		}
		int result = 0;
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		if (empId != 0) {
			if (!inputObj.isNull("empStatus")) {
				empStatus = PadQuotes((inputObj.getString("empStatus")));
			}
			result = emprepository.updateExestatus(empStatus, empId);
			output.put("msg", "Status Updated Successfully!");
		}
		return output;
	}

}
