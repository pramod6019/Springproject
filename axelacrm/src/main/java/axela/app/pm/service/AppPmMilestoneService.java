package axela.app.pm.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.pm.repository.PmMilestonesRepository;
import axela.pm.service.PmmilestoneService;
@Service
public class AppPmMilestoneService extends Connect {
	@Autowired
	public PmMilestonesRepository pmMilestonesRepository;
	HashMap output = null;
	JSONObject inputObj = null;
	public int empId = 0;
	public String requestType = "";
	public String pmmilestone_id = "0";
	public String pmmilestoneName = "";
	public String pmmilestoneDueDate = "";
	public String pmmilestoneDesc = "";
	public String pmmilestoneRank = "0";
	public String pmmilestonePmId = "0";
	public String pmmilestone_entry_id = "0";
	public String pmmilestone_entry_date = "";
	public String pmmilestone_modified_id = "0";
	public String pmmilestone_modified_date = "";
	public String pmmilestoneActive = "1";
	public int pmmilestoneId = 0;
	public String msg = "";
	public Map pmmService(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException, SQLException {
		inputObj = new JSONObject(input);
		output = new HashMap();
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}

			switch (requestType) {
				case "add" :
					pmmilestoneId = 0;
					getValues(inputObj);
					addFields(response, request);
					break;

			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("pmmilestoneName")) {
			pmmilestoneName = PadQuotes(inputObj.getString("pmmilestoneName"));
		}
		if (!inputObj.isNull("pmmilestoneDesc")) {
			pmmilestoneDesc = PadQuotes(inputObj.getString("pmmilestoneDesc"));
		}
		if (!inputObj.isNull("pmmilestoneDueDate")) {
			pmmilestoneDueDate = CNumeric(inputObj.getString("pmmilestoneDueDate"));
		}
		if (!inputObj.isNull("pmmilestoneActive")) {
			pmmilestoneActive = PadQuotes(inputObj.getString("pmmilestoneActive"));
		}
		if (!inputObj.isNull("pmmilestonePmId")) {
			pmmilestonePmId = CNumeric(inputObj.getString("pmmilestonePmId"));
		}
		if (!inputObj.isNull("pmmilestoneRank")) {
			pmmilestoneRank = PadQuotes(inputObj.getString("pmmilestoneRank"));
		}
	}

	public void addFields(HttpServletResponse response, HttpServletRequest request) throws SQLException, JSONException, ParseException {
		PmmilestoneService pm = new PmmilestoneService();
		pm.pmmilestoneName = pmmilestoneName;
		pm.pmmilestoneDesc = pmmilestoneDesc;
		pm.pmmilestoneDueDate = pmmilestoneDueDate;
		pm.pmmilestoneActive = pmmilestoneActive;
		pm.pmmilestonePmId = pmmilestonePmId;
		pm.pmmilestoneRank = pmmilestoneRank;
		pm.empId = empId;
		pm.requestType = requestType;
		pm.pmMilestonesRepository = pmMilestonesRepository;
		pm.addFields(response, request);
		String msg = pm.msg;
		if (msg.equals("")) {
			output.put("successmsg", "Milestone Added Successfully!");
			output.put("pmmilestoneId", pm.pmmilestoneId + "");
		} else {
			response.setStatus(201);
			output.put("errormsg", msg);
		}
	}

}
