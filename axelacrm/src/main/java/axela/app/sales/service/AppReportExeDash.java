package axela.app.sales.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.app.sales.repository.AppReportExecutiveDashImpl;
import axela.config.Connect;

@Service
public class AppReportExeDash extends Connect {
	private JSONObject inputObj = null;
	HashMap output = null;
	private String empId = "0";
	private String empUuid = "";
	private String compModuleSales = "1";
	private String compModuleService = "";
	private String compModuleAccounting = "";
	private String branchAccess = "";
	private String exeAccess = "";
	private String strSearch = "";
	private String branchId = "0";
	Map map = new HashMap();

	@Autowired
	AppReportExecutiveDashImpl appreportexecutivedashimpl;

	ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

	public Map executiveData(String input, HttpSession session, HttpServletRequest request) throws JSONException {
		inputObj = new JSONObject(input);
		output = new HashMap();
		List<HashMap> list = new ArrayList<HashMap>();
		SOP("inputObj===================" + inputObj);
		SOP("coming inside homedata");
		if (!inputObj.isNull("empId")) {
			empId = PadQuotes((inputObj.getString("empId")));
		}
		if (!inputObj.isNull("empUuid")) {
			empUuid = PadQuotes((inputObj.getString("empUuid")));
		}
		// CheckAppSession(emp_uuid, comp_id, request);
		compModuleSales = GetSession("compModuleSales", request);
		compModuleService = GetSession("compModuleService", request);
		compModuleAccounting = GetSession("compModuleAccounting", request);
		branchAccess = GetSession("branchAccess", request);
		exeAccess = GetSession("exeAccess", request);
		if (!empId.equals("0")) {
			if (!inputObj.isNull("branchId")) {
				branchId = CNumeric((String) inputObj.getString("branchId"));
			}
			SOP("inputObj=========1==========" + inputObj);
			SOP("compModuleSales=" + compModuleSales);

			// if (compModuleSales.equals("1")) {
			SOP("inputObj=======3============" + branchId);
			SOP("empId=======3============" + empId);
			String axelaSalesOppr = appreportexecutivedashimpl.findexeopprCount(Integer.parseInt(empId), strSearch, toLongDate(kknow()), branchId);
			String axelaServicejc = appreportexecutivedashimpl.findexejcCount(Integer.parseInt(empId), strSearch, toLongDate(kknow()), branchId);
			String axelaServiceticket = appreportexecutivedashimpl.findexeticketCount(Integer.parseInt(empId), strSearch, toLongDate(kknow()), branchId);

			output.put("opportunities", axelaSalesOppr);
			output.put("jobcards", axelaServicejc);
			output.put("tickets", axelaServiceticket);

		}
		// }
		return output;
	}

}
