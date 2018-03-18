package axela.service.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.helpdesk.model.AxelaHelpDeskTicketFaqService;
import axela.service.repository.CatagoriesFilterImpl;

@Service
public class CatagoriesService extends Connect {
	public String listpage = "no";
	public String add = "";
	public int empId = 0;
	public String compId = "0";
	public String update = "";
	public String deleteB = "";
	public String addB = "";
	public String updateB = "";
	public String status = "";
	public String StrSql = "";
	public String msg = "";
	public String serviceId = "0";
	public String serviceName = "";
	public String serviceEntryId = "0";
	public String entryBy = "";
	public String serviceEntryDate = "";
	public String entryDate = "";
	public String serviceModifiedId = "0";
	public String modifiedBy = "";
	public String serviceModifiedDate = "";
	public String modifiedDate = "";
	public String chkPermMsg = "";
	public String ticketTicketqueueId = "0";
	public String QueryString = "";
	public String empFormatdate = "";
	public String formatdateDatepicker = "";
	public String empFormattime = "";
	public String branchAccess = "";
	public String exeAccess = "";
	public String sortField = "";
	public String sortDirection = "";
	public int pageIndex = 0;
	public String pageSize = "0";
	public String strSearch = "";
	public int length = 0;

	@Autowired
	CatagoriesFilterImpl catagoriesFilterImpl;
	HashMap output = null;
	JSONObject inputObj = null;

	public Map listData(String input, HttpSession session) throws JSONException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			List<AxelaHelpDeskTicketFaqService> catagoriesList = null;
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			pageSize = CNumeric(getSession("empRecperpage", session));
			if (!inputObj.isNull("sortField")) {
				sortField = PadQuotes((inputObj.getString("sortField")));
			}
			if (!inputObj.isNull("pageIndex")) {
				pageIndex = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
			}
			if (!inputObj.isNull("sortDirection")) {
				sortDirection = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
			}

			if (pageSize.equals("0")) {
				pageSize = "25";
			}
			if (sortDirection.equals("")) {
				sortDirection = "DESC";
			}
			if (sortField.equals("")) {
				sortField = "faqserviceId";
			}
			pageIndex++;
			strSearch = branchAccess + exeAccess + " ORDER BY a." + sortField + " " + sortDirection;
			catagoriesList = catagoriesFilterImpl.findAllCaragories(strSearch, pageIndex, Integer.parseInt(pageSize));
			length = catagoriesFilterImpl.listLength;
			Map<String, String> mapNavi = pageNavi(length, input, pageSize);
			int count = 0;

			// Start Header Data
			listHeader.add(produceHeaderData("#", "Sl.no", "center"));
			listHeader.add(produceHeaderData("Categories", "faqserviceName", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaHelpDeskTicketFaqService obj : catagoriesList) {
				ArrayList<String> param = new ArrayList<String>();
				ArrayList<String> actionParam = new ArrayList<String>();
				HashMap<String, List<HashMap>> mapData = new HashMap<String, List<HashMap>>();
				HashMap<String, List<HashMap>> mapAction = new HashMap<String, List<HashMap>>();
				HashMap<String, List<String>> mapBodyData = new HashMap<String, List<String>>();
				List<HashMap> listData = new ArrayList<HashMap>();
				count++;
				// Start Body data
				actionParam.add("updateCatagories");
				actionParam.add("" + obj.getFaqserviceId());
				// listData.add(produceBodyData(new StringBuilder(PadQuotes(String.valueOf(count))), false, "", (ArrayList<String>) param.clone()));
				// listData.add(produceBodyData(new StringBuilder(PadQuotes(String.valueOf(obj.getFaqserviceName()))), false, "", (ArrayList<String>) param.clone()));
				param.clear();
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
				SOP("output==========CampaignService==========" + output.toString());
			}
		}
		return output;
	}

	private ArrayList<HashMap> produceActionData(ArrayList<String> actionParam) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Campaign");
		mapBodyData.put("param", actionParam);
		listAction.add((HashMap) mapBodyData.clone());

		return listAction;
	}

}
