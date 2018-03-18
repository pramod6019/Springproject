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
import org.springframework.stereotype.Repository;

import axela.config.Connect;
import axela.portal.model.AxelaEmp;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;
import axela.service.model.AxelaServiceContractType;
import axela.service.repository.ServiceContractTypeRepository;

@Repository
public class ContractTypeService extends Connect {
	private final static int PAGESIZE = 25;
	public String contracttypeId = "0";
	public String contracttypeName = "";
	public String contracttypeEntryId = "0";
	public String contracttypeEntryDate = "";
	public String contracttypeModifiedId = "0";
	public String contracttypeModifiedDate = "";
	public String msg = "";
	public String pageNumber = "";
	public int empId = 0;
	public String sortField = "";
	public String sortDirection = "";
	public int page = 0;
	public String perPage = "0";
	String branches = "";
	public String requestType = "";
	public String strSearch = "";
	public String branchAccess = "";
	public String exeAccess = "";
	public int length = 0;
	public int totalCount = 0;
	HashMap output = null;
	JSONObject inputObj = null;
	int compId = 0;

	@Autowired
	PortalFilterImpl portalFilterImpl;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	ServiceContractTypeRepository serviceContractTypeRepository;

	public Map<String, String> contractTypeService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		switch (requestType) {
			case "add" :
				contracttypeId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "update" :
				contracttypeId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "delete" :
				if (!inputObj.isNull("contracttypeId")) {
					contracttypeId = inputObj.getString("contracttypeId");
				}
				if (!contracttypeId.equals("0")) {
					deleteFields(contracttypeId);
				}
				break;
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("contracttypeId")) {
			contracttypeId = CNumeric(inputObj.getString("contracttypeId"));
		}
		if (!inputObj.isNull("contracttypeName")) {
			contracttypeName = PadQuotes(inputObj.getString("contracttypeName"));
		}
		if (!inputObj.isNull("contracttypeEntryId")) {
			contracttypeEntryId = PadQuotes(inputObj.getString("contracttypeEntryId"));
		}
		if (!inputObj.isNull("contracttypeEntryDate")) {
			contracttypeEntryDate = CNumeric(inputObj.getString("contracttypeEntryDate"));
		}
		if (!inputObj.isNull("contracttypeModifiedId")) {
			contracttypeModifiedId = PadQuotes(inputObj.getString("contracttypeModifiedId"));
		}
		if (!inputObj.isNull("contracttypeModifiedDate")) {
			contracttypeModifiedDate = CNumeric(inputObj.getString("contracttypeModifiedDate"));
		}
	}

	public void checkForm() {
		if (contracttypeName.equals("")) {
			msg += "Enter Contract Type Name!";
		}
	}

	public void addFields(HttpServletResponse response) throws ParseException {
		checkForm();
		AxelaServiceContractType axelaServiceContractType = null;
		if (msg.equals("")) {
			if (!contracttypeId.equals("0")) {
				axelaServiceContractType = serviceContractTypeRepository.findOne(Integer.parseInt(contracttypeId));
			} else {
				axelaServiceContractType = new AxelaServiceContractType();
			}
			axelaServiceContractType.setContracttypeId(Integer.parseInt(contracttypeId));
			axelaServiceContractType.setContracttypeName(contracttypeName);
			if (contracttypeId.equals("0") && requestType.equals("add")) {
				axelaServiceContractType.setContracttypeEntryDate(stringToDate(toLongDate(kknow())));;
				axelaServiceContractType.setContracttypeEntryId(empId);
				axelaServiceContractType.setContracttypeModifiedId(0);
				axelaServiceContractType.setContracttypeModifiedDate(stringToDate(""));
			} else if (!contracttypeId.equals("0") && requestType.equals("update")) {
				axelaServiceContractType.setContracttypeModifiedId(empId);
				axelaServiceContractType.setContracttypeModifiedDate(stringToDate(toLongDate(kknow())));
			}
			contracttypeId = serviceContractTypeRepository.save(axelaServiceContractType).getContracttypeId() + "";
			if (contracttypeId.equals("0") && requestType.equals("add")) {
				output.put("successmsg", "Contract Type Added Successfully!");
			} else if (!contracttypeId.equals("0") && requestType.equals("update")) {
				output.put("successmsg", "Contract Type Updated Successfully!");
			}
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
		if (!inputObj.isNull("contracttypeId")) {
			contracttypeId = CNumeric(PadQuotes(inputObj.getString("contracttypeId")));
		}

		if (!contracttypeId.equals("0")) {
			AxelaServiceContractType axelaServiceContractType = serviceContractTypeRepository.findOne(Integer.parseInt(contracttypeId));
			if (axelaServiceContractType != null) {
				map.put("contracttypeName", axelaServiceContractType.getContracttypeName());
				AxelaEmp axelaEmp = empRepository.findByEmpId(axelaServiceContractType.getContracttypeEntryId());
				map.put("contracttypeEntryId", axelaServiceContractType.getContracttypeId());
				map.put("contracttypeEntryBy", axelaEmp.getEmpName());
				map.put("contracttypeEntryDate", strToShortDate(axelaServiceContractType.getContracttypeEntryDate()));
				if (axelaServiceContractType.getContracttypeModifiedId() != 0) {
					map.put("contracttypeModifiedBy", axelaEmp.getEmpName());
					map.put("contracttypeModifiedId", axelaServiceContractType.getContracttypeModifiedId());
					map.put("contracttypeModifiedDate", strToShortDate(axelaServiceContractType.getContracttypeModifiedDate()));
				}
				list.add(map);
				output.put("populateData", list);
			}
		}
		return output;
	}

	public void deleteFields(String soeId) {
		serviceContractTypeRepository.delete(Integer.parseInt(contracttypeId));
		output.put("successmsg", "Contract Type Deleted Successfully!");
	}

	public Map listData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		page = 0;
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			perPage = CNumeric(getSession("empRecperpage", session));
			List<AxelaServiceContractType> contractTypeList = null;
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
				sortField = "contracttypeId";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			String strOrderBy = " ORDER BY type." + sortField + " " + sortDirection;
			contractTypeList = portalFilterImpl.findAllContractType(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			totalCount = Integer.parseInt(PortalFilterImpl.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Contract Type Details", "contracttypeName", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));

			// start Body Align
			StringBuilder dataString = null;
			for (AxelaServiceContractType obj : contractTypeList) {
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
				value.add(obj.getContracttypeName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				mapData.put("td", listData);
				actionParam.add("updateContractType");
				actionParam.add(obj.getContracttypeId() + "");
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
		mapBodyData.put("value", "Update Contract Type");
		mapBodyData.put("param", actionParam);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "type.*"));
		list.add(buildSmartArr("Contract ID", "numeric", "type.contracttypeId"));
		list.add(buildSmartArr("Contract Name", "text", "type.contracttypeName"));
		// list.add(buildSmartArr("Entry By", "text", "type.contracttypeEntryId)"));
		list.add(buildSmartArr("Entry Date", "date", "type.contracttypeEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "type.contracttypeModifiedId"));
		list.add(buildSmartArr("Modified Date", "date", "type.contracttypeModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

}
