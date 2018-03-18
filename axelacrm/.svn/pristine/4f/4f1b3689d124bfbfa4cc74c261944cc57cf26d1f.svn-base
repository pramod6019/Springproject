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
import axela.portal.model.AxelaAccWfDoc;
import axela.portal.repository.AccWfDocRepository;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;

@Service
public class WFDocService extends Connect
{
	@Autowired
	private AccWfDocRepository accwfdocrepository;
	@Autowired
	private EmpRepository empRepository;
	@Autowired
	private PortalFilterImpl portalFilterImpl;

	public String docId = "0";
	public String docDaynos = "0";
	public String docEffective = "0";
	public String docEntryDate = "";
	public String docEntryId = "0";
	public String docModifiedDate = "";
	public String docModifiedId = "0";
	public String docWfTitle = "";
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

	public Map wfdocService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
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
					docId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "update" :
					docId = "0";
					getValues(inputObj);
					addFields(response);
					break;

				case "delete" :
					if (!inputObj.isNull("docId")) {
						docId = inputObj.getString("docId");
					}
					if (!docId.equals("0")) {
						deleteFields(docId);
					}
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("docId")) {
			docId = CNumeric(inputObj.getString("docId"));
		}
		if (!inputObj.isNull("docDaynos")) {
			docDaynos = CNumeric(inputObj.getString("docDaynos"));
		}
		if (!inputObj.isNull("docEffective")) {
			docEffective = CNumeric(inputObj.getString("docEffective"));
		}
		if (!inputObj.isNull("docWfTitle")) {
			docWfTitle = PadQuotes(inputObj.getString("docWfTitle"));
		}
	}

	public void validateFields() {
		if (docWfTitle.equals("")) {
			msg += "Enter  title!";
		}
		if (docDaynos.equals("")) {
			msg += "Enter  no.of days!";
		}
		if (docEffective.equals("")) {
			msg += "Enter Select Effective Form!";
		}
	}

	public void addFields(HttpServletResponse response) throws JSONException, ParseException {
		validateFields();
		output = new HashMap();
		if (msg.equals("")) {
			AxelaAccWfDoc axelaaccwfdoc = null;
			if (!docId.equals("0")) {
				axelaaccwfdoc = accwfdocrepository.findByDocId(Integer.parseInt(docId));
			} else {
				axelaaccwfdoc = new AxelaAccWfDoc();
			}
			axelaaccwfdoc.setDocId(Integer.parseInt(docId));
			axelaaccwfdoc.setDocDaynos(Integer.parseInt(docDaynos));
			axelaaccwfdoc.setDocEffective(Integer.parseInt(docEffective));
			axelaaccwfdoc.setDocWfTitle(docWfTitle);
			if (docId.equals("0") && requestType.equals("add")) {
				axelaaccwfdoc.setDocEntryId(empId);
				axelaaccwfdoc.setDocEntryDate(stringToDate(toLongDate(kknow())));
				// axelaaccwfdoc.setDocModifiedDate("");
				axelaaccwfdoc.setDocModifiedId(0);
			} else if (!docId.equals("0") && requestType.equals("update")) {
				axelaaccwfdoc.setDocModifiedId(empId);
				axelaaccwfdoc.setDocModifiedDate(stringToDate(toLongDate(kknow())));
			}
			String docId = accwfdocrepository.save(axelaaccwfdoc).getDocId() + "";
			if (!docId.equals("0") && requestType.equals("add")) {
				output.put("docId", docId);
				output.put("successmsg", "Document Added Successfully!");
			}
			else if (!docId.equals("0") && requestType.equals("update")) {
				output.put("docId", docId);
				output.put("successmsg", "Document Updated Successfully");
			}
		}
		else {
			response.setStatus(400);
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String docId) throws JSONException {
		accwfdocrepository.delete(Integer.parseInt(docId));
		output.put("successmsg", "Document Deleted Successfully");
	}

	public Map populateData(String input) throws JSONException, ParseException {
		output = new HashMap();
		inputObj = new JSONObject(input);
		if (!inputObj.isNull("docId")) {
			docId = PadQuotes(CNumeric(inputObj.getString("docId")));
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!docId.equals("0")) {
			AxelaAccWfDoc WfDoc = accwfdocrepository.findByDocId(Integer.parseInt(docId));
			HashMap map = new HashMap();
			map.put("docId", docId);
			map.put("docDaynos", String.valueOf(WfDoc.getDocDaynos()));
			map.put("docEffective", String.valueOf(WfDoc.getDocEffective()));
			map.put("docWfTitle", String.valueOf(WfDoc.getDocWfTitle()));
			if (WfDoc.getDocEntryId() != 0) {
				map.put("docEntryDate", strToShortDate(WfDoc.getDocEntryDate()));
				map.put("docEntryId", String.valueOf(WfDoc.getDocEntryId()));
				map.put("docEntryBy", empRepository.findEmpName(WfDoc.getDocEntryId()));
			}
			if (WfDoc.getDocModifiedId() != 0) {
				map.put("docModifiedDate", strToShortDate(WfDoc.getDocModifiedDate()));
				map.put("docModifiedId", String.valueOf(WfDoc.getDocModifiedId()));
				map.put("docModifiedBy", empRepository.findEmpName(WfDoc.getDocModifiedId()));
			}
			list.add(map);
		}
		output.put("populateData", list);
		return output;
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		String strSearch = "";
		String strOrderBy = "";
		if (empId != 0) {
			page = 0;
			output = new LinkedHashMap<String, String>();
			String customerType = "";
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
				orderByField = "docId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strOrderBy = " ORDER BY doc." + orderByField + " " + orderType + "";
			List<AxelaAccWfDoc> resultSet = portalFilterImpl.findWfDocs(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			String length = portalFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Title", "docWfTitle", "center"));
			listHeader.add(produceHeaderData("Effective From", "docEffective", "center"));
			listHeader.add(produceHeaderData("Days", "docDaynos", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaAccWfDoc obj : resultSet) {
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
				// Title.
				type.add(false);
				value.add(String.valueOf(obj.getDocWfTitle()));
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Effective From.
				type.add(false);
				StringBuilder effective = new StringBuilder();
				if (obj.getDocEffective() == 1) {
					effective.append("Sales Order Date");
				} else {
					effective.append("Delivery Date");
				}
				value.add(effective);
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Days.
				type.add(false);
				value.add(String.valueOf(obj.getDocDaynos()));
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// End Body data
				mapData.put("td", listData);
				ArrayList actionParam = new ArrayList();
				actionParam.add("updateDocument");
				actionParam.add(PadQuotes(String.valueOf(obj.getDocId())));

				ArrayList actionParam1 = new ArrayList();
				actionParam1.add("updateTitle");
				actionParam1.add(PadQuotes(String.valueOf(obj.getDocId())));
				mapAction.put("td", produceActionData(actionParam, actionParam1));
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
	public ArrayList<HashMap> produceActionData(ArrayList<String> Param, ArrayList<String> Param1) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Document");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Update Title");
		mapBodyData.put("param", Param1);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "doc.*"));
		list.add(buildSmartArr("Doc ID", "numeric", "doc.docId"));
		list.add(buildSmartArr("Title", "text", "doc.docWfTitle"));
		list.add(buildSmartArr("No. of Days", "numeric", "doc.docDaynos"));
		list.add(buildSmartArr("Effective From", "numeric", "doc.docEffective"));
		// list.add(buildSmartArr("Entry By", "text", "doc_entry_id in (select emp_id from compdb.axela_emp where emp_name"));
		list.add(buildSmartArr("Entry Date", "date", "doc.docEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "docModifiedId in (select emp_id from compdb.axela_emp where emp_name"));
		list.add(buildSmartArr("Modified Date", "date", "doc.docModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

}
