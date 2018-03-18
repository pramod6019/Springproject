package axela.sales.service;

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
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;
import axela.sales.model.AxelaSalesCampaignType;
import axela.sales.repository.SalesCampaignRepository;
import axela.sales.repository.SalesCampaignTypeRepository;
@Service
public class CampaignTypeService extends Connect
{

	@Autowired
	SalesCampaignTypeRepository salesCampaignTypeRepository;
	@Autowired
	EmpRepository empRepository;
	@Autowired
	PortalFilterImpl portalFilterImpl;
	@Autowired
	SalesCampaignRepository salesCampaignRepository;

	public String camptypeId = "0";
	public String camptypeDesc = "";
	public String camptypeEntryDate = "";
	public String camptypeEntryId = "0";
	public String camptypeModifiedDate = "";
	public String camptypeModifiedId = "0";
	public String requestType = "";
	public String pageNumber = "";
	public int empId = 0;
	public int compId = 0;
	public String msg = "";
	public int page = 0;
	public String perpage = "0";
	public String sort = "";
	public String field = "";
	public String branchAccess = "";
	public String perPage = "0";
	public String strSearch = "";
	public String orderType = "";
	public String orderByField = "";
	public String strOrderBy = "";

	HashMap output = null;
	JSONObject inputObj = null;

	public Map campaignTypeService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		perPage = getSession("perPage", session);
		perPage = CNumeric(getSession("empRecperpage", session));
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new HashMap();
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			switch (requestType) {
				case "add" :
					camptypeId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "update" :
					camptypeId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "delete" :
					if (!inputObj.isNull("camptypeId")) {
						camptypeId = inputObj.getString("camptypeId");
					}
					if (!camptypeId.equals("0")) {
						deleteFields(camptypeId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("camptypeId")) {
			camptypeId = CNumeric(inputObj.getString("camptypeId"));
		}
		if (!inputObj.isNull("camptypeDesc")) {
			camptypeDesc = PadQuotes(inputObj.getString("camptypeDesc"));
		}
	}

	public void validateFields() {
		List<AxelaSalesCampaignType> obj = null;
		if (camptypeDesc.equals("")) {
			msg += "Enter  Desc!";
		} else {
			if (requestType.equals("add")) {
				obj = salesCampaignTypeRepository.findByCamptypeDesc(camptypeDesc);
			}
			else if (requestType.equals("update")) {
				obj = salesCampaignTypeRepository.findCamptypeDesc(Integer.parseInt(camptypeId), camptypeDesc);
			}
			if (!obj.isEmpty()) {
				msg += "<br>Similar Campaign Type Desc found!";
			}
		}
	}

	public void addFields(HttpServletResponse response) throws JSONException, ParseException {
		validateFields();
		output = new HashMap();
		if (msg.equals("")) {
			AxelaSalesCampaignType axelasalescampaigntype = null;
			if (!camptypeId.equals("0")) {
				axelasalescampaigntype = salesCampaignTypeRepository.findByCamptypeId(Integer.parseInt(camptypeId));
			} else {
				axelasalescampaigntype = new AxelaSalesCampaignType();
			}
			axelasalescampaigntype.setCamptypeId(Integer.parseInt(camptypeId));
			axelasalescampaigntype.setCamptypeDesc(camptypeDesc);
			if (camptypeId.equals("0") && requestType.equals("add")) {
				axelasalescampaigntype.setCamptypeEntryId(empId);
				axelasalescampaigntype.setCamptypeEntryDate(stringToDate(toLongDate(kknow())));

				axelasalescampaigntype.setCamptypeModifiedId(0);
			} else if (!camptypeId.equals("0") && requestType.equals("update")) {
				axelasalescampaigntype.setCamptypeModifiedId(empId);
				axelasalescampaigntype.setCamptypeModifiedDate(stringToDate(toLongDate(kknow())));
			}
			String camptypeId = salesCampaignTypeRepository.save(axelasalescampaigntype).getCamptypeId() + "";
			if (!camptypeId.equals("0") && requestType.equals("add")) {
				output.put("camptypeId", camptypeId);
				output.put("successmsg", "Campaign Type Added Successfully");
			}
			else if (!camptypeId.equals("0") && requestType.equals("update")) {
				output.put("camptypeId", camptypeId);
				output.put("successmsg", "Campaign Type updated Successfully");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String camptypeId) throws JSONException {
		msg = "";
		if (!camptypeId.equals("")) {
			Integer campaignCampaigntypeId = salesCampaignRepository.findDataBycamptypeId(Integer.parseInt(camptypeId));
			if (campaignCampaigntypeId != null && campaignCampaigntypeId != 0) {
				msg = msg + "<br>Campaign Type is associated with Campaign!";
			}
			if (msg.equals("")) {
				salesCampaignTypeRepository.delete(Integer.parseInt(camptypeId));
				output.put("successmsg", "Campaign Type deleted Successfully");
			} else {
				output.put("errormsg", msg);
			}
		}
	}

	public Map populateData(String input) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("camptypeId")) {
			camptypeId = PadQuotes(CNumeric(inputObj.getString("camptypeId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!camptypeId.equals("0")) {
			AxelaSalesCampaignType axelaSalesCampaignType = salesCampaignTypeRepository.findByCamptypeId(Integer.parseInt(camptypeId));
			HashMap map = new HashMap();
			map.put("camptypeId", camptypeId);
			map.put("camptypeDesc", String.valueOf(axelaSalesCampaignType.getCamptypeDesc()));
			if (axelaSalesCampaignType.getCamptypeEntryId() != 0) {
				map.put("camptypeEntryDate", strToShortDate(axelaSalesCampaignType.getCamptypeEntryDate()));
				map.put("camptypeEntryId", String.valueOf(axelaSalesCampaignType.getCamptypeEntryId()));
				map.put("camptypeEntryBy", empRepository.findEmpName(axelaSalesCampaignType.getCamptypeEntryId()));
			}
			if (axelaSalesCampaignType.getCamptypeModifiedId() != 0) {
				map.put("camptypeModifiedDate", strToShortDate(axelaSalesCampaignType.getCamptypeModifiedDate()));
				map.put("camptypeModifiedId", String.valueOf(axelaSalesCampaignType.getCamptypeModifiedId()));
				map.put("camptypeModifiedBy", empRepository.findEmpName(axelaSalesCampaignType.getCamptypeModifiedId()));
			}
			list.add(map);
			output.put("populateData", list);
		}
		return output;
	}

	public Map listData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		page = 0;
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
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
				orderByField = "camptypeId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}

			strOrderBy = " ORDER BY type." + orderByField + " " + orderType + "";
			List<AxelaSalesCampaignType> resultSet = portalFilterImpl.findAllCampaignType(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			String length = portalFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Campaign Type Details", "camptypeDesc", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaSalesCampaignType obj : resultSet) {
				ArrayList<String> param = new ArrayList<String>();
				ArrayList type = new ArrayList();
				ArrayList value = new ArrayList();
				ArrayList<String> actionParam = new ArrayList<String>();
				ArrayList<ArrayList> paramArr = new ArrayList<ArrayList>();
				HashMap<String, List<HashMap>> mapData = new HashMap<String, List<HashMap>>();
				HashMap<String, List<HashMap>> mapAction = new HashMap<String, List<HashMap>>();
				HashMap<String, List<String>> mapBodyData = new HashMap<String, List<String>>();
				List<HashMap> listData = new ArrayList<HashMap>();
				count++;

				type.add(false);
				value.add(count);
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				type.add(false);
				value.add(obj.getCamptypeDesc());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				mapData.put("td", listData);
				actionParam.add("updateCampaignType");
				actionParam.add(obj.getCamptypeId() + "");
				mapAction.put("td", produceActionData(actionParam));

				listAction.add(mapAction);
				listBody.add(mapData);
			}
			output.put("meta", mapNavi);
			output.put("thead", listHeader);
			output.put("tdalign", listBodyAlign);
			output.put("tbody", listBody);
			output.put("action", listAction);
		}
		return output;
	}

	private ArrayList<HashMap> produceActionData(ArrayList<String> actionParam) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Campaign Type");
		mapBodyData.put("param", actionParam);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "type.*"));
		list.add(buildSmartArr("Camptype ID", "numeric", "type.camptypeId"));
		list.add(buildSmartArr("Camptype Desc", "text", "type.camptypeDesc"));
		list.add(buildSmartArr("Entry By", "text", "type.camptypeEntryId)"));
		list.add(buildSmartArr("Entry Date", "date", "type.camptypeEntryDate"));
		list.add(buildSmartArr("Modified By", "text", "type.camptypeModifiedId"));
		list.add(buildSmartArr("Modified Date", "date", "type.camptypeModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

}
