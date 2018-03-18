package axela.service.service;

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
import axela.portal.model.AxelaEmp;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;
import axela.service.model.AxelaServiceContractAssetType;
import axela.service.repository.ServiceContractAssetTypeRepository;

@Service
public class AssetTypeService extends Connect {

	private final static int PAGESIZE = 25;
	String contractassettypeId = "0";
	String contractassettypeName = "";
	String contractassettypeEntryId = "0";
	String contractassettypeEntryDate = "";
	String contractassettypeModifiedId = "0";
	String contractassettypeModifiedDate = "";

	public String requestType = "";
	public String msg = "";
	public String pageNumber = "";
	public int empId = 0;
	public String sortField = "";
	public String sortDirection = "";
	public int page = 0;
	public String perPage = "0";
	String branches = "";
	public String strSearch = "";
	public String branchAccess = "";
	public String exeAccess = "";
	public int length = 0;
	public int totalCount = 0;
	HashMap output = null;
	int compId = 0;

	JSONObject inputObj = null;

	@Autowired
	ServiceContractAssetTypeRepository serviceContractAssetTypeRepository;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	PortalFilterImpl portalFilterImpl;

	public Map<String, String> assetTypeService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		switch (requestType) {
			case "add" :
				contractassettypeId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "update" :
				contractassettypeId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "delete" :
				if (!inputObj.isNull("contractassettypeId")) {
					contractassettypeId = inputObj.getString("contractassettypeId");
				}
				if (!contractassettypeId.equals("0")) {
					deleteFields(contractassettypeId);
				}
				break;
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";

		if (!inputObj.isNull("contractassettypeId")) {
			contractassettypeId = CNumeric(inputObj.getString("contractassettypeId"));
		}
		if (!inputObj.isNull("contractassettypeName")) {
			contractassettypeName = PadQuotes(inputObj.getString("contractassettypeName"));
		}
		if (!inputObj.isNull("contractassettypeEntryId")) {
			contractassettypeEntryId = PadQuotes(inputObj.getString("contractassettypeEntryId"));
		}
		if (!inputObj.isNull("contractassettypeEntryDate")) {
			contractassettypeEntryDate = CNumeric(inputObj.getString("contractassettypeEntryDate"));
		}
		if (!inputObj.isNull("contractassettypeModifiedId")) {
			contractassettypeModifiedId = PadQuotes(inputObj.getString("contractassettypeModifiedId"));
		}
		if (!inputObj.isNull("contractassettypeModifiedDate")) {
			contractassettypeModifiedDate = CNumeric(inputObj.getString("contractassettypeModifiedDate"));
		}
	}

	public void checkForm() {
		if (contractassettypeName.equals("")) {
			msg += "Enter Asset Type Name!";
		}
	}

	public void addFields(HttpServletResponse response) throws ParseException {
		checkForm();

		AxelaServiceContractAssetType axelaServiceContractAssetType = null;
		if (msg.equals("")) {
			if (!contractassettypeId.equals("0")) {
				axelaServiceContractAssetType = serviceContractAssetTypeRepository.findOne(Integer.parseInt(contractassettypeId));
			} else {
				axelaServiceContractAssetType = new AxelaServiceContractAssetType();
			}
			axelaServiceContractAssetType.setContractassettypeId(Integer.parseInt(contractassettypeId));
			axelaServiceContractAssetType.setContractassettypeName(contractassettypeName);
			if (contractassettypeId.equals("0") && requestType.equals("add")) {
				axelaServiceContractAssetType.setContractassettypeEntryDate(stringToDate(toLongDate(kknow())));;
				axelaServiceContractAssetType.setContractassettypeEntryId(empId);
				axelaServiceContractAssetType.setContractassettypeModifiedId(0);
				axelaServiceContractAssetType.setContractassettypeModifiedDate(stringToDate(""));
			} else if (!contractassettypeId.equals("0") && requestType.equals("update")) {
				axelaServiceContractAssetType.setContractassettypeModifiedId(empId);
				axelaServiceContractAssetType.setContractassettypeModifiedDate(stringToDate(toLongDate(kknow())));
			}
			contractassettypeId = serviceContractAssetTypeRepository.save(axelaServiceContractAssetType).getContractassettypeId() + "";
			if (contractassettypeId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("successmsg", "Asset Type Added Successfully!");
			} else if (!contractassettypeId.equals("0") && requestType.equals("update")) {
				output.put("successmsg", "Asset Type Updated Successfully!");
			}
			contractassettypeId = "0";
		} else {
			response.setStatus(400);
			output.put("errormsg", msg);
		}

	}

	public Map<String, List> populateData(String input) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		LinkedHashMap map = new LinkedHashMap();
		if (!inputObj.isNull("contractassettypeId")) {
			contractassettypeId = CNumeric(PadQuotes(inputObj.getString("contractassettypeId")));
		}
		if (!contractassettypeId.equals("0")) {
			AxelaServiceContractAssetType axelaServiceContractAssetType = serviceContractAssetTypeRepository.findOne(Integer.parseInt(contractassettypeId));
			if (axelaServiceContractAssetType != null) {
				map.put("contractassettypeName", axelaServiceContractAssetType.getContractassettypeName());
				AxelaEmp axelaEmp = empRepository.findByEmpId(axelaServiceContractAssetType.getContractassettypeEntryId());
				if (axelaServiceContractAssetType.getContractassettypeEntryId() != 0) {
					map.put("contractassettypeEntryDate", strToShortDate(axelaServiceContractAssetType.getContractassettypeEntryDate()));
					map.put("contractassettypeEntryBy", empRepository.findEmpName(axelaServiceContractAssetType.getContractassettypeEntryId()));
					map.put("contractassettypeEntryId", axelaServiceContractAssetType.getContractassettypeEntryId());
				}
				if (axelaServiceContractAssetType.getContractassettypeModifiedId() != 0) {
					map.put("contractassettypeModifiedDate", strToShortDate(axelaServiceContractAssetType.getContractassettypeModifiedDate()));
					map.put("contractassettypeModifiedBy", empRepository.findEmpName(axelaServiceContractAssetType.getContractassettypeModifiedId()));
					map.put("contractassettypeModifiedId", axelaServiceContractAssetType.getContractassettypeModifiedId());
				}
				list.add(map);
				output.put("populateData", list);
			}
		}
		return output;
	}

	public void deleteFields(String contractassettypeId) {
		serviceContractAssetTypeRepository.delete(Integer.parseInt(contractassettypeId));
		output.put("successmsg", "Asset Type Deleted Successfully!");
	}

	public Map listData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		page = 0;
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			List<AxelaServiceContractAssetType> assetTypeList = null;
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			PageRequest request = null;
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			if (!inputObj.isNull("sortField")) {
				sortField = PadQuotes((inputObj.getString("sortField")));
			}
			if (!inputObj.isNull("pageIndex")) {
				page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
			}
			if (!inputObj.isNull("sortDirection")) {
				sortDirection = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
			}

			if (perPage.equals("0")) {
				perPage = "25";
			}
			if (sortDirection.equals("")) {
				sortDirection = "DESC";
			}
			if (sortField.equals("")) {
				sortField = "contractassettypeId";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			String strOrderBy = " ORDER BY type." + sortField + " " + sortDirection;
			System.out.println("strOrderBy=============" + strOrderBy);
			assetTypeList = portalFilterImpl.findAllAssetType(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			totalCount = Integer.parseInt(PortalFilterImpl.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Asset Type Details", "contractassettypeName", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaServiceContractAssetType obj : assetTypeList) {
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
				value.add(obj.getContractassettypeName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				mapData.put("td", listData);
				actionParam.add("updateAssetType");
				actionParam.add(obj.getContractassettypeId() + "");
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
				SOP("output==========Service==========" + output.toString());
			}
		}
		return output;
	}
	private ArrayList<HashMap> produceActionData(ArrayList<String> actionParam) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Asset Type");
		mapBodyData.put("param", actionParam);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		//

		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "type.*"));
		list.add(buildSmartArr("Asset Brand ID", "numeric", "type.assetbrandId"));
		list.add(buildSmartArr("Asset Brand Name", "text", "type.assetbrandName"));
		// list.add(buildSmartArr("Entry By", "text", "type.assetbrandEntryId)"));
		list.add(buildSmartArr("Entry Date", "date", "type.assetbrandEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "type.assetbrandModifiedId"));
		list.add(buildSmartArr("Modified Date", "date", "type.assetbrandModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}
}
