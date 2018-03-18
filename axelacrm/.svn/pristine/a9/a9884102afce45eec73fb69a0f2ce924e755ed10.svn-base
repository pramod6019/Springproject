package axela.sales.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.portal.model.AxelaEmp;
import axela.portal.model.AxelaSalesCampaignBranch;
import axela.portal.repository.EmpRepository;
import axela.sales.model.AxelaSalesCampaign;
import axela.sales.repository.CampaignFilterImpl;
import axela.sales.repository.SalesCampaignBranchRepository;
import axela.sales.repository.SalesCampaignRepository;

@Service
public class CampaignService extends Connect {

	@Autowired
	SalesCampaignRepository salesCampaignRepository;

	@Autowired
	SalesCampaignBranchRepository salesCampaignBranchRepository;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	CampaignFilterImpl campaignFilterImpl;

	public String strSearch = "";
	// private String StrSql = "";
	public int length = 0;

	public String add = "";
	public String update = "";
	public String delete = "";
	public String addB = "";
	public String updateB = "";
	public String status = "";
	public String msg = "";
	public JSONArray branchName = new JSONArray();
	public String branchId = "0";
	public String campaignId = "0";
	public String campaignType = "0";
	public String campaignName = "";
	public String campaignBranchId = "";
	public String campaignCampaigntypeId = "0";
	public String camptypeId = "0";
	public String campatypeIesc = "";
	public String campaignDesc = "";
	public String campaignStartdate = "";
	public String campaignEnddate = "";
	public String campaignBudget = "";
	public String campaignActive = "";
	public String campaignNotes = "";
	public String campaignEntryId = "0";
	public String campaignEntryDate = "";
	public String campaignModifiedId = "0";
	public String campaignModifiedDate = "";
	public String date = "";
	public String pageNumber = "";
	public String perpage = "0";
	public String sort = "";
	public String field = "";
	public String orderType = "";
	public String strOrderBy = "";
	public String prodFeedbackemail = "";
	public String checkperm = "";
	public String entryBy = "", entryDate = "", modifiedBy = "", modifiedDate = "";
	public int empId = 0;
	public String empRoleId = "0";
	public String compId = "0";
	public String[] listBranchTrans = new String[10];
	public String QueryString = "";
	public String trans = "";
	public String configSalesOpprName = "";
	public String empFormatdate = "";
	public String empFormattime = "";
	public String formatdateDatepicker = "";
	public String requestType = "";
	public String groupId = "0";
	public String branchAccess = "";
	public String exeAccess = "";
	public String orderByField = "";
	public String orderByType = "";
	public int page = 0;
	public String perPage = "0";
	private String startDate = "";
	private String endDate = "";
	private Date timeZone = null;
	private String empFormatTime = "";
	public String empFormatDate = "";

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	HashMap output = null;
	JSONObject inputObj = null;

	public Map campaignService(String input, HttpSession session, HttpServletResponse response) throws Exception {
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		compId = CNumeric(getSession("compId", session));
		empFormatdate = getSession("formatdateName", session);
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (empId != 0) {
			if (!returnPerm("emp_campaign_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			timeZone = getTimeByZone(session);
			branchAccess = getSession("branchAccess", session).replaceAll("branchId", "oppr.opprBranchId");
			exeAccess = getSession("exeAccess", session).replaceAll("empId", "oppr.opprEmpId");
			empFormatDate = PadQuotes(getSession("formatdateDatepicker", session));
			empFormatTime = PadQuotes(getSession("formattimeTimepicker", session));
			switch (requestType) {
				case "add" : // add a campaign.
					if (!returnPerm("emp_campaign_add", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					campaignId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "update" :// update a campaign.
					if (!returnPerm("emp_campaign_edit", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					campaignId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "delete" :// delete a campaign..
					if (!returnPerm("emp_campaign_delete", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					if (!inputObj.isNull("campaignId")) {
						campaignId = PadQuotes(inputObj.getString("campaignId"));
					}
					if (!campaignId.equals("0")) {
						deleteFields(campaignId);
					}
					break;

				case "landing" :// landing page an customer.
					populateLandingDetails(input);
					break;
			}
		}
		return output;
	}

	protected void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("campaignId")) {
			campaignId = CNumeric((inputObj.getString("campaignId")));
		}
		if (!inputObj.isNull("campaignCampaigntypeId")) {
			campaignCampaigntypeId = PadQuotes(inputObj.getString("campaignCampaigntypeId"));
		}
		if (!inputObj.isNull("campaignName")) {
			campaignName = PadQuotes(inputObj.getString("campaignName"));
		}
		if (!inputObj.isNull("branchName")) {
			if (inputObj.get("branchName") instanceof JSONArray)
				branchName = inputObj.getJSONArray("branchName");
		}
		if (!inputObj.isNull("campaignDesc")) {
			campaignDesc = PadQuotes(inputObj.getString("campaignDesc"));
		}
		if (!inputObj.isNull("campaignStartdate")) {
			campaignStartdate = PadQuotes(inputObj.getString("campaignStartdate"));
		}
		if (!inputObj.isNull("campaignEnddate")) {
			campaignEnddate = (PadQuotes(inputObj.getString("campaignEnddate")));
		}
		if (!inputObj.isNull("campaignBudget")) {
			campaignBudget = PadQuotes(inputObj.getString("campaignBudget"));
		}
		if (!inputObj.isNull("campaignActive")) {
			campaignActive = inputObj.get("campaignActive") + "";
		}
		if (!inputObj.isNull("campaignNotes")) {
			campaignNotes = PadQuotes(inputObj.getString("campaignNotes"));
			if (campaignNotes.length() > 5000) {
				campaignNotes = campaignNotes.substring(0, 4999);
			}
		}
		if (!inputObj.isNull("entryDate")) {
			entryDate = PadQuotes(inputObj.getString("entryDate"));
		}
		if (!inputObj.isNull("modifiedBy")) {
			modifiedBy = PadQuotes(inputObj.getString("modifiedBy"));
		}
		if (!inputObj.isNull("modifiedDate")) {
			modifiedDate = PadQuotes(inputObj.getString("modifiedDate"));
		}
	}

	protected void validateFields() throws NumberFormatException, ParseException {
		msg = "";
		if (campaignName.equals("")) {
			msg = msg + "<br>Enter Campaign Name!";
		}
		if (campaignCampaigntypeId.equals("0")) {
			msg = msg + "<br>Select a Campaign Type!";
		}
		if (campaignDesc.equals("")) {
			msg = msg + "<br>Enter Description!";
		} else if (campaignDesc.length() > 1000) {
			campaignDesc = campaignDesc.substring(0, 1000);
		}
		if (campaignStartdate.equals("")) {
			msg = msg + "<br>Select Start Date!";
		}
		if (campaignEnddate.equals("")) {
			msg = msg + "<br>Select End Date!";
		}
		if (branchName.length() == 0) {
			msg = msg + "<br>Select Branch!";
		}

		if (!campaignStartdate.equals("") && isValidDateFormat(campaignStartdate, empFormatdate) && !campaignEnddate.equals("") && isValidDateFormat(campaignEnddate, empFormatdate)) {
			// if (Long.parseLong(formatDateStr(campaignStartdate, empFormatdate)) > Long.parseLong(formatDateStr(campaignEnddate, empFormatdate))) {
			// msg = msg + "<br>Start Date should be less than End date!";
			// }
		}
		if (campaignBudget.equals("")) {
			msg = msg + "<br>Enter Budget!";
		}
		if (campaignBudget.equals("") && !isNumeric(campaignBudget)) {
			msg = msg + "<br>Entered Budget should be Numareic!";
		}
		if (campaignNotes.length() > 8000) {
			campaignNotes = campaignNotes.substring(0, 7999);
		}
	}

	protected void addFields(HttpServletResponse response) throws JSONException, ParseException {
		validateFields();
		if (msg.equals("")) {
			AxelaSalesCampaign axelaSalesCampaign = null;
			AxelaSalesCampaignBranch axelaSalesCampaignBranch = null;
			SOP("campaignId====================" + campaignId);
			if (!campaignId.equals("0")) {
				axelaSalesCampaign = salesCampaignRepository.findOne(Integer.parseInt(campaignId));
			} else {
				axelaSalesCampaign = new AxelaSalesCampaign();
			}
			axelaSalesCampaign.setCampaignId(Integer.parseInt(campaignId));
			axelaSalesCampaign.setCampaignName(campaignName);
			axelaSalesCampaign.setCampaignCampaigntypeId(Integer.parseInt(campaignCampaigntypeId));
			axelaSalesCampaign.setCampaignStartdate(stringToDate(""));
			axelaSalesCampaign.setCampaignEnddate(stringToDate(""));
			axelaSalesCampaign.setCampaignBudget(Integer.parseInt(campaignBudget));
			axelaSalesCampaign.setCampaignDesc(campaignDesc);
			axelaSalesCampaign.setCampaignActive(campaignActive);
			axelaSalesCampaign.setCampaignNotes(campaignNotes);
			if (requestType.equals("add")) {
				axelaSalesCampaign.setCampaignEntryId(empId);
				axelaSalesCampaign.setCampaignEntryDate(kknow());
				axelaSalesCampaign.setCampaignModifiedId(0);
			} else if (requestType.equals("update")) {
				axelaSalesCampaign.setCampaignModifiedId(empId);
				axelaSalesCampaign.setCampaignModifiedDate(timeZone);
				axelaSalesCampaign.setCampaignEntryId(axelaSalesCampaign.getCampaignEntryId());// from the object
				axelaSalesCampaign.setCampaignEntryDate(axelaSalesCampaign.getCampaignEntryDate());// from the object
			}
			salesCampaignRepository.save(axelaSalesCampaign).getCampaignId();
			campaignId = salesCampaignRepository.save(axelaSalesCampaign).getCampaignId() + "";
			if (!campaignId.equals("0") && requestType.equals("update")) {
				salesCampaignBranchRepository.deletebyCampId(Integer.parseInt(campaignId));
			}
			for (int i = 0; i < branchName.length(); i++) {
				axelaSalesCampaignBranch = new AxelaSalesCampaignBranch();
				axelaSalesCampaignBranch.setCamptransCampaignId(Integer.parseInt(campaignId));
				axelaSalesCampaignBranch.setCamptransBranchId(branchName.getInt(i));
				salesCampaignBranchRepository.save(axelaSalesCampaignBranch);
			}
			if (!campaignId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("successmsg", "Campaign Added Successfully!");
				output.put("campaignId", campaignId);
			} else if (!campaignId.equals("0") && requestType.equals("update")) {
				output.put("successmsg", "Campaign Updated Successfully!");
				output.put("campaignId", campaignId);
			}
		} else {
			output.put("errormsg", msg);
		}
	}

	public Map<String, List> populateData(String input, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, List>();
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		if (empId != 0) {
			if (!returnPerm("emp_campaign_edit", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			LinkedHashMap map = new LinkedHashMap();
			if (!inputObj.isNull("campaignId")) {
				campaignId = CNumeric(PadQuotes(inputObj.getString("campaignId")));
			}
			if (!campaignId.equals("0")) {
				AxelaSalesCampaign axelaSalesCampaign = salesCampaignRepository.findByCampaignId(Integer.parseInt(campaignId));
				if (axelaSalesCampaign != null) {
					map.put("campaignId", String.valueOf(axelaSalesCampaign.getCampaignId()));
					map.put("campaignName", String.valueOf(axelaSalesCampaign.getCampaignName()));
					map.put("campaignDesc", "" + axelaSalesCampaign.getCampaignDesc());
					map.put("campaignStartdate", strToShortDate(axelaSalesCampaign.getCampaignStartdate()));
					map.put("campaignEnddate", strToShortDate((axelaSalesCampaign.getCampaignEnddate())));
					map.put("campaignBudget", axelaSalesCampaign.getCampaignBudget() + "");
					map.put("campaignCampaigntypeId", axelaSalesCampaign.getCampaignCampaigntypeId() + "");
					map.put("campaignActive", (Integer.parseInt(axelaSalesCampaign.getCampaignActive())));
					map.put("campaignNotes", axelaSalesCampaign.getCampaignNotes());

					List<AxelaSalesCampaignBranch> branchs = salesCampaignBranchRepository.findBranch(Integer.parseInt(campaignId));
					StringBuilder branches = new StringBuilder();
					for (AxelaSalesCampaignBranch axelaSalesCampaignBranchs : branchs) {
						branches.append(axelaSalesCampaignBranchs.getCamptransBranchId()).append(",");
					}
					branches = branches.deleteCharAt(branches.length() - 1);
					map.put("branchId", branches);
					AxelaEmp axelaEmp = empRepository.findByEmpId(axelaSalesCampaign.getCampaignEntryId());
					map.put("campaignEntryBy", axelaEmp.getEmpName() + " (" + axelaEmp.getEmpRefNo() + ")");
					map.put("campaignEntryId", axelaSalesCampaign.getCampaignEntryId() + "");
					map.put("campaignEntryDate", strToShortDate(axelaSalesCampaign.getCampaignEntryDate()));
					if (axelaSalesCampaign.getCampaignModifiedId() != 0) {
						axelaEmp = empRepository.findByEmpId(axelaSalesCampaign.getCampaignModifiedId());
						map.put("campaignModifiedId", axelaSalesCampaign.getCampaignModifiedId() + "");
						map.put("campaignModifiedBy", axelaEmp.getEmpName() + " (" + axelaEmp.getEmpRefNo() + ")");
						map.put("campaignModifiedDate", strToShortDate(axelaSalesCampaign.getCampaignModifiedDate()));
					}
					list.add(map);
					output.put("populateData", list);
				}
			}
		}
		return output;
	}

	public void deleteFields(String campaignId) throws JSONException {
		salesCampaignRepository.delete(Integer.parseInt(campaignId));
		salesCampaignBranchRepository.deletebyCampId(Integer.parseInt(campaignId));
		output.put("successmsg", "Campaign Deleted Successfully!");
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		String configSalesOpprName = getSession("configSalesOpprName", session);
		String strSearch = "";
		String strOrderBy = "";
		if (empId != 0) {
			if (!returnPerm("emp_campaign_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			page = 0;
			orderType = "";
			orderByField = "";
			output = new LinkedHashMap<String, String>();
			String customerType = "";
			List<AxelaSalesCampaign> campaignList = null;
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			PageRequest request = null;
			if (!inputObj.isNull("requestType")) {
				requestType = PadQuotes((inputObj.getString("requestType")));
			}
			if (!inputObj.isNull("sortField")) {
				orderByField = PadQuotes((inputObj.getString("sortField")));
			}
			if (!inputObj.isNull("pageIndex")) {
				page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
			}
			if (!inputObj.isNull("sortDirection")) {
				orderType = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
			}
			perPage = CNumeric(getSession("empRecperpage", session));
			if (orderType.equals("")) {
				orderType = "DESC";
			}
			if (orderByField.equals("")) {
				orderByField = "campaignId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			strOrderBy = " ORDER BY campaign." + orderByField + " " + orderType;
			campaignList = campaignFilterImpl.findAllCampaign(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			String length = CampaignFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("ID", "campaignId", "center"));
			listHeader.add(produceHeaderData("Campaign Detail", "campaignName", "center"));
			listHeader.add(produceHeaderData("Period", "campaignStartdate", "center"));
			listHeader.add(produceHeaderData(configSalesOpprName + " Count", "campaignDesc", "center"));

			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaSalesCampaign obj : campaignList) {
				ArrayList paramArr = new ArrayList();
				ArrayList type = new ArrayList();
				ArrayList value = new ArrayList();
				HashMap<String, List<HashMap>> mapData = new HashMap<String, List<HashMap>>();
				HashMap<String, List<HashMap>> mapAction = new HashMap<String, List<HashMap>>();
				HashMap<String, List<String>> mapBodyData = new HashMap<String, List<String>>();
				List<HashMap> listData = new ArrayList<HashMap>();
				count++;
				// Start Body data

				// count
				type.add(false);
				value.add(count);
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// ID details.
				type.add(false);
				value.add(String.valueOf(obj.getCampaignId()));
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Campaign Detail details.
				type.add(false);
				type.add(false);
				value.add(String.valueOf(obj.getCampaignName()));
				value.add(String.valueOf(obj.getCamptypeDesc()));
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Period Detail details.
				type.add(false);
				value.add(String.valueOf(strToShortDate(obj.getCampaignStartdate())) + " - " + strToShortDate(obj.getCampaignEnddate()));
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Opportunity Count details.
				type.add(false);
				value.add(String.valueOf(obj.getCampaignOpprcount()));
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// End Body data
				mapData.put("td", listData);
				ArrayList actionParam = new ArrayList();
				actionParam.add("updateCampaign");
				actionParam.add(PadQuotes(String.valueOf(obj.getCampaignId())));
				mapAction.put("td", produceActionData(actionParam));
				listAction.add(mapAction);
				listBody.add(mapData);
			}
			output.put("meta", mapNavi);
			output.put("action", listAction);
			output.put("tdalign", listBodyAlign);
			output.put("thead", listHeader);
			output.put("tbody", listBody);
		}
		return output;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<HashMap> produceActionData(ArrayList<String> Param) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Campaign");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "oppr.*"));
		list.add(buildSmartArr("Campaign ID", "numeric", "campaign.campaignId"));
		list.add(buildSmartArr("Campaign Name", "text", "campaign.campaignName"));
		list.add(buildSmartArr("Campaign Description", "text", "campaign.campaignDesc"));
		list.add(buildSmartArr("Campaign budget", "text", "campaign.campaignBudget"));
		list.add(buildSmartArr("Campaign Notes", "text", "campaign.campaign_notes"));
		list.add(buildSmartArr("Active", "boolean", "campaign.campaignActive"));
		list.add(buildSmartArr("Campaign StartDate", "date", "campaign.campaignStartdate"));
		list.add(buildSmartArr("Campaign EndDate", "date", "campaign.campaignEnddate"));
		list.add(buildSmartArr("Entry By", "text", "campaign.campaignEntryId)"));
		list.add(buildSmartArr("Entry Date", "date", "campaign.campaignEntryDate"));
		list.add(buildSmartArr("Modified By", "text", "campaign.campaignModifiedId"));
		list.add(buildSmartArr("Modified Date", "date", "campaign.campaign_modified_date"));
		output.put("drSmart", list.toArray());
		return output;
	}

	private void populateLandingDetails(String input) throws ParseException, JSONException {
		msg = "";
		startDate = "";
		endDate = "";
		campaignBranchId = "0";
		output = new HashMap();
		String strSearch = "";
		JSONObject inputJson = new JSONObject(input);
		if (!AppRun().equals(1)) {
			SOP("populateLandingDetails===========================" + inputJson.toString(1));
		}
		if (!inputJson.isNull("startDate")) {
			startDate = PadQuotes(inputJson.getString("startDate"));
		}
		if (!inputJson.isNull("endDate")) {
			endDate = PadQuotes(inputJson.getString("endDate"));
		}
		if (!inputJson.isNull("campaignBranchId")) {
			campaignBranchId = PadQuotes(inputJson.getString("campaignBranchId"));
		}
		landingValidation();
		if (msg.equals("")) {
			if (!startDate.equals("")) {
				strSearch += " AND SUBSTRING(campaign.campaignStartdate,1,10) >= SUBSTRING('" + dateToString(stringToDate(startDate)) + "',1,10) ";
			}
			if (!endDate.equals("")) {
				strSearch += " AND SUBSTRING(campaign.campaignStartdate,1,10) <= SUBSTRING('" + dateToString(stringToDate(endDate)) + "',1,10) ";
			}
			if (!campaignBranchId.equals("0")) {
				strSearch += " AND campaign.campaignBranchId=" + campaignBranchId;
			}
			strSearch += " AND branch.branchActive = '1'"
					+ branchAccess + exeAccess;
			List<Object[]> result = campaignFilterImpl.findCampaignLandingDetails(strSearch);
			List list = new ArrayList<Map>();
			int total = 0;
			for (Object[] obj : result) {
				Map map = new HashMap();
				map.put("campaignStartDate", obj[0] + "");
				map.put("campaignCount", obj[1] + "");
				total += Integer.parseInt(obj[1] + "");
				list.add(map);
			}
			output.put("total", total + "");
			output.put("populateLandingDetails", list);
		} else {
			output.put("errormsg", msg);
		}
	}

	private void landingValidation() throws ParseException {

		if (startDate.equals("")) {
			msg = msg + "<br>Select Start Date!";
		}
		if (!startDate.equals("")) {
			if (isValidDateFormat(startDate, empFormatDate)) {
				// startDate = formatDateStr(startDate, empFormatDate + " " + empFormatTime);
			} else {
				msg = msg + "<br>Enter Valid Start Date!";
			}
		}
		if (endDate.equals("")) {
			msg = msg + "<br>Select End Date!";
		}
		if (!endDate.equals("")) {
			if (isValidDateFormat(endDate, empFormatDate)) {
				// endDate = formatDateStr(endDate, empFormatDate + " " + empFormatTime);
			} else {
				msg = msg + "<br>Enter Valid End Date!";
			}
		}
		if (msg.equals("")) {
			if (!startDate.equals("") && !endDate.equals("")) {
				if (stringToDate(startDate).compareTo(stringToDate(endDate)) > 0) {
					msg = msg + "<br>Start Date should be less than End date!";
				}
			}
		}
	}

}
