package axela.app.sales.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import axela.config.Connect;
import axela.portal.repository.AxelaUniEmpRepository;
import axela.portal.repository.AxelaUniEmpRepositoryImpl;
import axela.portal.repository.EmpRepository;
//import axela.portal.repository.AxelaUniEmpRepositoryImpl;
import axela.sales.model.AxelaUniEmp;

@Component
public class AppSigninService extends Connect {
	JSONObject output = new JSONObject();
	@Autowired
	private AxelaUniEmpRepositoryImpl axelauniemprepositoryimpl;
	@Autowired
	private EmpRepository axelaEmpRepository;
	@Autowired
	AxelaUniEmpRepository AxelaUniEmpRepository;

	public Map<String, List> listData(String input, HttpSession session, HttpServletResponse response) throws JSONException {
		String signinid = "";
		String password = "";
		String empDeviceId = "";
		String empDeviceActive = "no";
		HashMap output = null;
		JSONObject inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("input========Axela listData===========" + inputObj.toString(1));
		}
		output = new HashMap<String, List>();
		List<AxelaUniEmp> uniemplist = null;
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		// LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

		if (!inputObj.isNull("signinid")) {
			signinid = PadQuotes((inputObj.getString("signinid")));
		}
		if (!inputObj.isNull("password")) {
			password = PadQuotes((inputObj.getString("password")));
		}
		if (!inputObj.isNull("empDeviceId")) {
			empDeviceId = PadQuotes((inputObj.getString("empDeviceId")));
		}
		uniemplist = axelauniemprepositoryimpl.findAll(signinid, password);

		if (uniemplist != null && uniemplist.size() > 0) {
			for (AxelaUniEmp result : uniemplist) {
				output.put("empId", CNumeric(String.valueOf(result.getempId())));
				output.put("compId", CNumeric(String.valueOf(result.getcompId())));
				output.put("compName", PadQuotes((result.getCompName())));
				output.put("empUuid", PadQuotes((result.getEmpUuid())));
				output.put("empStatus", axelaEmpRepository.findEmpstatus((result.getempId())));
				output.put("compModuleSales", CNumeric(String.valueOf(result.getCompModuleSales())));
				output.put("compModulePm", CNumeric(String.valueOf(result.getCompModulePm())));
				output.put("compModuleHelpdesk", CNumeric(String.valueOf(result.getCompModuleHelpdesk())));
				output.put("compModuleService", CNumeric(String.valueOf(result.getCompModuleService())));
				output.put("compModuleAccounting", CNumeric(String.valueOf(result.getCompModuleAccounting())));
				if (result.getempId() != 1) {

					if (!result.getEmpDeviceId().equals(""))
					{
						AxelaUniEmpRepository.findEmpdevice(empDeviceId, result.getempId());
					}
					else {
						if (!result.getEmpDeviceId().equals(empDeviceId)) {
							empDeviceActive = "yes";
						}
					}
				}
				output.put("empDeviceActive", empDeviceActive);
				// End Device Active Logic
				String comp_id = CNumeric(String.valueOf(result.getcompId()));
				assignSession(CNumeric(String.valueOf(result.getempId())), result.getEmpBranchId() + "", result.getEmpRoleId() + "", result.getEmpAllExe(), result.getEmpRecperpage()
						+ "",
						(500), comp_id, session);

			}

		} else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			output.put("empId", "0");
		}

		if (AppRun().equals("0")) {
			SOP("output =========Axelauniemp listData============== " + output);
		}
		return output;

	}
}
