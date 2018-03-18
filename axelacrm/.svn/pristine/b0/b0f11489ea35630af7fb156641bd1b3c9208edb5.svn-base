package axela.service.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import axela.portal.repository.BranchRepository;
import axela.service.model.AxelaServiceJc;
import axela.service.model.AxelaServiceJcBayTran;
import axela.service.repository.ServiceJcBayTransRepository;
import axela.service.repository.ServiceJcFilterImpl;
import axela.service.repository.ServiceJcRepository;

@Service
public class ManHourService extends Connect {

	@Autowired
	ServiceJcRepository serviceJcRepository;

	@Autowired
	BranchRepository branchRepository;

	@Autowired
	ServiceJcFilterImpl serviceJcFilterImpl;

	@Autowired
	ServiceJcBayTransRepository serviceJcBayTransRepository;

	public int empId = 0;
	public String compId = "0";
	public String StrSql = "";
	public String msg = "";
	public String requestType = "";
	public String bayName = "";
	public String bayBranchId = "0";
	public String baytransStartEntryId = "0";
	public Date baytransStartTime = null;
	public String baytransBayId = "0";
	public String baytransJcId = "0";
	public String baytransEmpId = "0";
	public Date baytransEndTime = null;
	public String baytransEndEntryId = "0";
	public String start = "";
	public String jc = "";
	public String jcId = "0";
	public String jcJcbranchId = "0";
	public String branchName = "";
	public String jcBranchId = "0";
	public String jcTimeReady = "";
	public String jcEmpId = "0";
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public String baytransId = "0";
	HashMap output = null;
	JSONObject inputObj = null;

	public Map<String, String> manHoursService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = CNumeric(PadQuotes(getSession("compId", session)));
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		if (AppRun().equals("0")) {
			SOP("inputObj========ticketService==========" + inputObj.toString(1));
		}

		if (!inputObj.isNull("bayBranchId")) {
			bayBranchId = CNumeric(inputObj.getString("bayBranchId"));
		}
		if (!inputObj.isNull("jc")) {
			jc = CNumeric(inputObj.getString("jc"));
		}
		if (!inputObj.isNull("jcId")) {
			jcId = CNumeric(inputObj.getString("jcId"));
		}
		if (jc.equals("yes")) {
			jcJcbranchId = serviceJcRepository.findByJcBranchId(jcId);
			branchName = branchRepository.findByBranchName(jcJcbranchId);
		}
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (empId != 0) {
			switch (requestType) {
				case "START" : // Start a ManHours.
					baytransId = "0";
					getValues(inputObj);
					baytransStartEntryId = String.valueOf(empId);
					baytransStartTime = getTimeByZone(session);
					addFields(response, session);
					break;

				case "STOP" :// Stop a ManHours.
					baytransId = "0";
					if (!inputObj.isNull("jcId")) {
						baytransJcId = CNumeric(inputObj.getString("jcId"));
					}
					baytransEndEntryId = String.valueOf(empId);
					baytransEndTime = getTimeByZone(session);
					getValues(inputObj);
					addFields(response, session);
					break;
			}
		}

		if (AppRun().equals("0")) {
			SOP("output========ticketService==========" + output);
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		if (!inputObj.isNull("baytransBayId")) {
			baytransBayId = CNumeric(inputObj.getString("baytransBayId"));
		}
		if (!inputObj.isNull("baytransJcId")) {
			baytransJcId = CNumeric(inputObj.getString("baytransJcId"));
		}
		if (!inputObj.isNull("baytransEmpId")) {
			baytransEmpId = CNumeric(inputObj.getString("baytransEmpId"));
		}
		if (!inputObj.isNull("baytransId")) {
			baytransId = CNumeric(inputObj.getString("baytransId"));
		}
	}

	public void validateFields() throws ParseException {
		String bayEmpId = "";
		msg = "";
		if (bayBranchId.equals("0")) {
			msg = "<br>Select Branch!";
		}
		if (baytransBayId.equals("0")) {
			msg += "<br>Select Bay!";
		}
		if (baytransJcId.equals("0") && requestType.equals("START")) {
			msg += "<br>Enter Job Card Id!";
		}
		if (baytransEmpId.equals("0")) {
			msg += "<br>Enter User Id!";
		}
		if (!baytransJcId.equals("0")) {
			List<AxelaServiceJc> obj = serviceJcRepository.findByJcBranchIdAndJcTimeReady(Integer.parseInt(baytransJcId), Integer.parseInt(baytransEmpId));
			for (AxelaServiceJc result : obj) {
				jcBranchId = result.getJcBranchId() + "";
				jcTimeReady = sdf.format(result.getJcTimeReady());
				jcEmpId = result.getEmpId() + "";
			}
		}
		if (!bayBranchId.equals(jcBranchId)) {
			msg += "<br>Invalid Branch for Job Card!";
		}
		if (requestType.equals("START") && !jcTimeReady.equals("") && !jcTimeReady.equals("09/06/2014")) { // Logic to be corrected
			msg += "<br>Job Card is already ready!";
		}
		if (jcEmpId.equals("0")) {
			msg += "<br>Invalid User for Job Card!";
		}
		bayEmpId = String.valueOf(serviceJcFilterImpl.findByBayTransEmpId(baytransJcId, baytransBayId));
		if (!bayEmpId.equals("0") && !bayEmpId.equals(baytransEmpId)) {
			msg += "<br>Bay Already Occupied!";
		}
	}
	public void addFields(HttpServletResponse response, HttpSession session) throws ParseException {
		validateFields();
		SOP("yessss");
		AxelaServiceJcBayTran axelaServiceJcBayTran = null;
		if (msg.equals("")) {
			if (requestType.equals("START")) {
				baytransEndTime = stringToDate(sdf1.format(getTimeByZone(session)));
				StrSql = serviceJcBayTransRepository.updateByBaytransEndTime(Integer.parseInt(baytransEmpId), baytransEndTime) + "";
			}
			if (!baytransId.equals("0")) {
				axelaServiceJcBayTran = serviceJcBayTransRepository.findOne(Integer.parseInt(baytransId));
			} else {
				axelaServiceJcBayTran = new AxelaServiceJcBayTran();
			}
			// baytransEndTime = "";
			axelaServiceJcBayTran.setBaytransBayId(Integer.parseInt(baytransBayId));
			axelaServiceJcBayTran.setBaytransJcId(Integer.parseInt(baytransJcId));
			axelaServiceJcBayTran.setBaytransEmpId(Integer.parseInt(baytransEmpId));
			axelaServiceJcBayTran.setBaytransStartTime((baytransStartTime));
			axelaServiceJcBayTran.setBaytransStartEntryId(Integer.parseInt(baytransStartEntryId));
			axelaServiceJcBayTran.setBaytransEndTime(stringToDate(""));
			axelaServiceJcBayTran.setBaytransEndEntryId(0);
			if (requestType.equals("STOP")) {
				axelaServiceJcBayTran.setBaytransEndTime(baytransEndTime);
				axelaServiceJcBayTran.setBaytransEndEntryId(Integer.parseInt(baytransEndEntryId));
			}
			AxelaServiceJcBayTran result = null;
			result = serviceJcBayTransRepository.save(axelaServiceJcBayTran);
			if (result != null && requestType.equals("START")) {
				output.put("successmsg", "ManHours Started Successfully!");
				output.put("baytransId", result.getBaytransId() + "");
			} else if (result != null && requestType.equals("STOP")) {
				output.put("successmsg", "ManHours Stop Successfully!");
				output.put("baytransId", result.getBaytransId() + "");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

}
