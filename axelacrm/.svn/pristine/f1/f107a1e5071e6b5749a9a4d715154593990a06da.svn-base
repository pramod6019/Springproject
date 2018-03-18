package axela.sales.service;
//Shekespeare
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.portal.repository.EmpRepository;
import axela.sales.model.AxelaSalesTeam;
import axela.sales.model.AxelaSalesTeamExe;
import axela.sales.repository.SalesTeamRepository;
import axela.sales.repository.SalesTeamexeRepository;
import axela.sales.repository.TeamFilterImpl;
@Service
public class TeamService extends Connect {

	@Autowired
	SalesTeamRepository salesteamrepository;

	@Autowired
	SalesTeamexeRepository salesteamexerepository;

	@Autowired
	TeamFilterImpl teamFilter;

	@Autowired
	EmpRepository empRepository;

	// ======configuration====
	public String requestType = "";
	public String msg = "";
	public int page = 0;
	public String perpage = "0";
	public String orderType = "";
	public String orderByField = "";
	// ===============from session====
	public int empId = 0;
	public int compId = 0;
	public String empFormatdate = "";
	public String empFormattime = "";
	public int branchId = 0;
	public String branchName = "";
	// FROM CLIENT
	public String teamId = "0";
	public String teamBranchId = "0";
	public String teamCrmEmpId = "0";
	public String teamEmpId = "0";
	public String teamEntryDate = "";
	public String teamEntryId = "0";
	public String teamModifiedDate = "";
	public String teamModifiedId = "0";
	public String teamName = "";
	public String teamPbfEmpId = "0";
	public String teamPsfEmpId = "0";
	// =============multi select=====
	public JSONArray teamtransEmpId;
	public static int length = 0;
	public String pageNumber = "";
	public String perPage = "0";
	public String strSearch = "";

	private String startDate = "";
	private String endDate = "";
	public String branchAccess = "";
	public String exeAccess = "";

	HashMap output = null;
	JSONObject inputObj = null;

	public Map salesTeam(String input, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		// CheckPerm(String.valueOf(compId), "empCustomerAccess", request, response);
		empFormatdate = PadQuotes(getSession("empFormatdate", session));
		empFormattime = PadQuotes(getSession("empFormattime", session));
		branchId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		// ===========branchName=====
		if (empId != 0) {
			branchAccess = getSession("branchAccess", session).replaceAll("branchId", "team.teamBranchId");
			exeAccess = getSession("exeAccess", session).replaceAll("empId", "team.teamEmpId");
			inputObj = new JSONObject(input);
			if (AppRun().equals("0")) {
				SOP("output==========TeamService==========" + inputObj.toString(1));
			}
			output = new HashMap();
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			switch (requestType) {

				case "add" : // add an customer.
					teamId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "update" :// update an customer.
					teamId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "delete" :// delete an customer.
					if (!inputObj.isNull("teamId")) {
						teamId = CNumeric(inputObj.getString("teamId"));
					}
					if (!teamId.equals("0")) {
						deleteFields(teamId);
					}
					break;

				case "landing" :// landing page an customer.
					populateLandingDetails(input);
					break;
			}

		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("teamId")) {
			teamId = CNumeric(inputObj.getString("teamId"));
		}
		if (!inputObj.isNull("teamBranchId")) {
			teamBranchId = CNumeric(inputObj.getString("teamBranchId"));
		}
		if (!inputObj.isNull("teamCrmEmpId")) {
			teamCrmEmpId = CNumeric(inputObj.getString("teamCrmEmpId"));
		}
		if (!inputObj.isNull("teamEmpId")) {
			teamEmpId = CNumeric(inputObj.getString("teamEmpId"));
		}
		if (!inputObj.isNull("teamName")) {
			teamName = PadQuotes(inputObj.getString("teamName"));
		}
		if (!inputObj.isNull("teamPbfEmpId")) {
			teamPbfEmpId = CNumeric(inputObj.getString("teamPbfEmpId"));
		}
		if (!inputObj.isNull("teamPsfEmpId")) {
			teamPsfEmpId = CNumeric(inputObj.getString("teamPsfEmpId"));
		}
		// ==================================================Multiselect .......

		if (!inputObj.isNull("teamtransEmpId")) {
			teamtransEmpId = inputObj.getJSONArray("teamtransEmpId");
		}
		if (!inputObj.isNull("teamtransEmpId")) {
			JSONArray inputArray = inputObj.getJSONArray("teamtransEmpId");
			// for (int i = 0; i < inputArray.length(); i++) {
			// teamtransEmpId = inputArray.getString(i) + ",";
			// }
			// if (teamtransEmpId.length() > 0) {
			// teamtransEmpId = teamtransEmpId.substring(0, teamtransEmpId.length() - 1);
			// }
		}
	}

	public void validateFields() {
		msg = "";
		if (teamName.equals("")) {
			msg += "<br>Enter Team Name!";
		} else {
			if (!requestType.equals("update")) {
				if (salesteamrepository.findByTeamNameAndTeamBranchId(teamName, Integer.parseInt(teamBranchId)) != null) {
					msg += "<br>Similar Team Found! ";
				}
			} else {
				if (salesteamrepository.findByTeamIdAndTeamName(Integer.parseInt(teamId), teamName) == null) {
					msg += "<br>Similar Team Found! ";
				}
			}
		}

		if (teamBranchId.equals("0")) {
			msg = msg + "<br>Select Branch!";
		}

		if (teamEmpId.equals("0")) {
			msg += "<br>Select Team Manager!";
		}
		// =====multiple select====
		if (teamtransEmpId.length() == 0) {
			msg += "<br>Select Executive(s) for the Team!";
		}
	}

	public void addFields(HttpServletResponse response) throws ParseException, NumberFormatException, JSONException {
		validateFields();
		AxelaSalesTeam axelasalesteam = null;
		AxelaSalesTeamExe salesteamexe = null;
		output = new HashMap();
		if (msg.equals("")) {
			if (!teamId.equals("0")) {
				axelasalesteam = salesteamrepository.getOne(Integer.parseInt(teamId));
			} else {
				axelasalesteam = new AxelaSalesTeam();
			}
			axelasalesteam.setTeamId(Integer.parseInt(teamId));
			axelasalesteam.setTeamBranchId(Integer.parseInt(teamBranchId));
			axelasalesteam.setTeamCrmEmpId(Integer.parseInt(teamCrmEmpId));
			axelasalesteam.setTeamEmpId(Integer.parseInt(teamEmpId));
			axelasalesteam.setTeamName(teamName);
			axelasalesteam.setTeamPbfEmpId(Integer.parseInt(teamPbfEmpId));
			axelasalesteam.setTeamPsfEmpId(Integer.parseInt(teamPsfEmpId));
			// =============trans multiple=================
			if (teamId.equals("0") && requestType.equals("add")) {
				axelasalesteam.setTeamEntryDate(kknow());
				axelasalesteam.setTeamEntryId(empId);
				axelasalesteam.setTeamModifiedDate(stringToDate(""));
				axelasalesteam.setTeamModifiedId(0);

			} else {
				axelasalesteam.setTeamModifiedId(empId);
				axelasalesteam.setTeamModifiedDate(kknow());
			}
			// String[] teamTransEmpIds = null;
			// teamTransEmpIds = teamtransEmpId.split(",");
			teamId = salesteamrepository.save(axelasalesteam).getTeamId() + "";
			SOP("teamId=========" + teamId);
			if (requestType.equals("update")) {
				if (!teamId.equals("0")) {
					salesteamexerepository.deletebyTeamId(Integer.parseInt(teamId));
				}
			}
			SOP("teamId=====00====" + teamId);
			if (!teamId.equals("0")) {
				if (teamtransEmpId.length() > 0) {
					for (int i = 0; i < teamtransEmpId.length(); i++) {
						salesteamexe = new AxelaSalesTeamExe();
						salesteamexe.setTeamtransTeamId(Integer.parseInt(teamId));
						salesteamexe.setTeamtransEmpId(Integer.valueOf(teamtransEmpId.get(i) + ""));
						salesteamexerepository.save(salesteamexe);
					}
				}
			}
			SOP("teamId=====11====" + teamId);
			if (!teamId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("successmsg", "Sales Team Added Successfully!");
				output.put("teamId", teamId);

			} else if (!teamId.equals("0") && requestType.equals("update")) {
				output.put("successmsg", "Sales Team Updated Successfully!");
				output.put("teamId", teamId);
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String teamId) {
		String teamtransTeamId = teamId;
		salesteamexerepository.deletebyTeamId(Integer.parseInt(teamId));
		salesteamrepository.delete(Integer.parseInt(teamId));
		output.put("succesmsg", "Sales Team  Deleted Successfully!");

	}

	public Map<String, List> populateData(String input) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("teamId")) {
			teamId = CNumeric(inputObj.getString("teamId"));
		}

		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!teamId.equals("0")) {
			AxelaSalesTeam salesTeam = salesteamrepository.findByTeamId(Integer.parseInt(teamId));
			HashMap map = new HashMap();
			map.put("teamId", salesTeam.getTeamId());
			map.put("teamBranchId", String.valueOf(salesTeam.getTeamBranchId()));
			map.put("teamCrmEmpId", String.valueOf(salesTeam.getTeamCrmEmpId()));
			map.put("teamEmpId", String.valueOf(salesTeam.getTeamEmpId()));
			map.put("teamName", String.valueOf(salesTeam.getTeamName()));
			map.put("teamPbfEmpId", String.valueOf(salesTeam.getTeamPbfEmpId()));
			map.put("teamPsfEmpId", String.valueOf(salesTeam.getTeamPsfEmpId()));
			if (salesTeam.getTeamEntryId() != 0) {
				map.put("teamEntryDate", strToShortDate(salesTeam.getTeamEntryDate()));
				map.put("teamEntryId", String.valueOf(salesTeam.getTeamEntryId()));
				map.put("teamEntryBy", empRepository.findByEmp(salesTeam.getTeamEntryId()));
			}
			if (salesTeam.getTeamModifiedId() != 0) {
				map.put("teamModifiedDate", strToShortDate(salesTeam.getTeamModifiedDate()));
				map.put("teamModifiedId", String.valueOf(salesTeam.getTeamModifiedId()));
				map.put("teamModifiedBy", empRepository.findByEmp(salesTeam.getTeamModifiedId()));
			}
			List salesteamexe = salesteamexerepository.findByTeamtransId(Integer.parseInt(teamId));
			List teamexe = new ArrayList<String>();
			for (Object result : salesteamexe) {
				teamexe.add(result + "");
			}
			map.put("teamtransEmpId", teamexe);

			list.add(map);
		}
		output.put("populateData", list);
		return output;
	}

	public Map listData(String input, HttpSession session) throws JSONException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		String strSearch = "";
		String strOrderBy = "";
		if (empId != 0) {
			page = 0;
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			List<AxelaSalesTeam> salesTeamList = null;
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			PageRequest request = null;
			if (!inputObj.isNull("sortField")) {
				orderByField = PadQuotes((inputObj.getString("sortField")));
			}
			if (!inputObj.isNull("pageIndex")) {
				page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
			}
			if (!inputObj.isNull("sortDirection")) {
				orderType = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
			}
			if (!inputObj.isNull("teamBranchId")) {
				teamBranchId = PadQuotes((inputObj.getString("teamBranchId")));
			}
			perPage = CNumeric(getSession("empRecperpage", session));
			if (orderType.equals("")) {
				orderType = "DESC";
			}
			if (orderByField.equals("")) {
				orderByField = "teamName";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (!teamBranchId.equals("0")) {
				strSearch = " AND team.teamBranchId='" + teamBranchId + "'";
			}

			strOrderBy = " ORDER BY team." + orderByField + " " + orderType;
			salesTeamList = teamFilter.findAll(strSearch, strOrderBy, page, Integer.parseInt(perPage));

			String length = teamFilter.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Team", "teamName", "center"));
			listHeader.add(produceHeaderData("Manager", "teamId", "center"));
			listHeader.add(produceHeaderData("Executive Count", "empCount", "center"));
			// End Header Data
			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			// End Body Align
			for (AxelaSalesTeam obj : salesTeamList) {
				ArrayList<String> paramSubArr = new ArrayList<String>();
				ArrayList<ArrayList> paramArr = new ArrayList<ArrayList>();
				ArrayList type = new ArrayList();
				ArrayList value = new ArrayList();
				HashMap<String, List<HashMap>> mapData = new HashMap<String, List<HashMap>>();
				HashMap<String, List<HashMap>> mapAction = new HashMap<String, List<HashMap>>();
				HashMap<String, List<String>> mapBodyData = new HashMap<String, List<String>>();
				List<HashMap> listData = new ArrayList<HashMap>();
				count++;
				// count
				type.add(false);
				value.add(count);
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// team
				type.add(false);
				value.add(String.valueOf(obj.getTeamName()));
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Manager
				type.add(false);
				value.add(String.valueOf(obj.getEmpName() + "(" + obj.getEmpRefNo() + ")"));
				paramSubArr.add("executiveSummary");
				paramSubArr.add(obj.getEmpId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// executive count
				type.add(false);
				value.add(String.valueOf(obj.getEmpCount()));
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				ArrayList actionParam = new ArrayList();
				actionParam.add("updateTeam");
				actionParam.add(PadQuotes(String.valueOf(obj.getTeamId())));
				actionParam.add(PadQuotes(String.valueOf(obj.getTeamBranchId())) + "");
				// End Body data
				mapData.put("td", listData);
				mapAction.put("td", produceActionData(actionParam));
				listAction.add(mapAction);
				listBody.add(mapData);
			}
			output.put("meta", mapNavi);
			output.put("thead", listHeader);
			output.put("tdalign", listBodyAlign);
			output.put("tbody", listBody);
			output.put("action", listAction);
			if (AppRun().equals("0")) {
				SOP("output==========TeamService==========" + output.toString());
			}
		}
		return output;
	}
	private ArrayList<HashMap> produceActionData(ArrayList<String> Param) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Team");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());

		return listAction;
	}

	private void populateLandingDetails(String input) throws ParseException, JSONException {
		msg = "";
		startDate = "";
		endDate = "";
		output = new HashMap<String, String>();
		String strSearch = "";
		JSONObject inputJson = new JSONObject(input);
		if (!AppRun().equals(1)) {
			SOP("populateLandingDetails===========================" + inputJson.toString(1));
		}
		strSearch += " AND team.teamActive = '1'"
				+ branchAccess + exeAccess;
		List<Object[]> result = teamFilter.findTeamLandingDetails(strSearch);
		List list = new ArrayList<Map>();
		int total = 0;
		for (Object[] obj : result) {
			Map map = new HashMap<String, String>();
			map.put("branchId", obj[0]);
			map.put("teamName", obj[1]);
			map.put("teamBranchId", obj[2]);
			map.put("teamEmpId", obj[3]);
			map.put("empName", obj[4]);
			map.put("empcount", obj[5]);
			total += Integer.parseInt(obj[2] + "");
			list.add(map);
		}
		output.put("total", total + "");
		output.put("populateLandingDetails", list);
	}
}
