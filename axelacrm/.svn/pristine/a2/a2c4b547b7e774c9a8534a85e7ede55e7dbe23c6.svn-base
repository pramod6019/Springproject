package axela.pm.service;

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
import axela.pm.model.AxelaPmMilestone;
import axela.pm.repository.PmMilestonesRepository;

@Service
public class PmmilestoneService extends Connect {

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

	public Map pmmService(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		SOP("paaaaaa");
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
					SOP("paaaaaa22222");
					getValues(inputObj);
					addFields(response, request);
					break;

				case "update" :
					pmmilestoneId = 0;
					getValues(inputObj);
					addFields(response, request);
					break;

				case "delete" :
					if (!inputObj.isNull("pmmilestoneId")) {
						pmmilestoneId = Integer.parseInt(inputObj.getString("pmmilestoneId"));
					}
					if (pmmilestoneId != 0) {
						deleteFields(pmmilestoneId);
					}
					break;
			}
		}
		return output;
	}
	protected void validateFields(HttpServletRequest request) {
		msg = "";

		if (pmmilestoneName.equals("")) {
			msg += "<br>Enter Name!";
		}

		if (pmmilestoneDueDate.equals("")) {
			msg += "<br>Enter Duedate!";
		}

	}

	public void deleteFields(int pmmilestoneId) {
		pmMilestonesRepository.delete(pmmilestoneId);
		output.put("successmsg", "Milestone  Deleted Successfully!");
	}

	public void addFields(HttpServletResponse response, HttpServletRequest request) throws JSONException, ParseException {
		validateFields(request);
		output = new HashMap();
		AxelaPmMilestone axelaPmMilestone = null;
		if (msg.equals("")) {
			if (pmmilestoneId == 0) {
				axelaPmMilestone = new AxelaPmMilestone();
			} else {
				axelaPmMilestone = pmMilestonesRepository.findByPmmilestoneId(pmmilestoneId);
			}
			axelaPmMilestone.setPmmilestoneId(pmmilestoneId);
			axelaPmMilestone.setPmmilestoneActive(pmmilestoneActive);
			axelaPmMilestone.setPmmilestoneDesc(pmmilestoneDesc);
			axelaPmMilestone.setPmmilestoneName(pmmilestoneName);
			axelaPmMilestone.setPmmilestoneDueDate(stringToDate(pmmilestoneDueDate));
			axelaPmMilestone.setPmmilestonePmId(Integer.parseInt(pmmilestonePmId));
			axelaPmMilestone.setPmmilestoneRank(Integer.parseInt(pmmilestoneRank));
			if (requestType.equals("add")) {
				axelaPmMilestone.setPmmilestoneEntryDate(kknow());
				axelaPmMilestone.setPmmilestoneEntryId(empId);
			} else if (requestType.equals("update")) {
				axelaPmMilestone.setPmmilestoneModifiedDate(kknow());
				axelaPmMilestone.setPmmilestoneModifiedId(empId);
			}
			pmmilestoneId = pmMilestonesRepository.save(axelaPmMilestone).getPmmilestoneId();
			if (pmmilestoneId != 0 && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("successmsg", "Milestone Added Successfully!<br>");
				output.put("pmmilestoneId", pmmilestoneId + "");
			} else if (pmmilestoneId != 0 && requestType.equals("update")) {
				output.put("successmsg", "Milestone Updated Successfully!<br>");
				output.put("pmmilestoneId", pmmilestoneId + "");
			}

		}
		else {
			// response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
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

}
