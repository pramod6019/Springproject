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
import axela.service.model.AxelaServiceContractAssetBrand;
import axela.service.repository.ServiceContractAssetBrandRepository;

@Service
public class AssetBrandService extends Connect {
	private final static int PAGESIZE = 25;

	public String assetbrandId = "0";
	public String assetbrandName = "";
	public String assetbrandEntryId = "0";
	public String assetbrandEntryDate = "";
	public String assetbrandModifiedId = "0";
	public String assetbrandModifiedDate = "0";
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
	int compId = 0;

	JSONObject inputObj = null;

	@Autowired
	ServiceContractAssetBrandRepository serviceContractAssetBrandRepository;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	PortalFilterImpl portalFilterImpl;

	public Map<String, String> assetBrand(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		switch (requestType) {
			case "add" :
				assetbrandId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "update" :
				assetbrandId = "0";
				getValues(inputObj);
				addFields(response);
				break;

			case "delete" :
				if (!inputObj.isNull("assetbrandId")) {
					assetbrandId = inputObj.getString("assetbrandId");
				}
				if (!assetbrandId.equals("0")) {
					deleteFields(assetbrandId);
				}
				break;
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("assetbrandId")) {
			assetbrandId = inputObj.getString("assetbrandId");
		}
		if (!inputObj.isNull("assetbrandName")) {
			assetbrandName = PadQuotes(inputObj.getString("assetbrandName"));
		}
		if (!inputObj.isNull("assetbrandEntryId")) {
			assetbrandEntryId = PadQuotes(inputObj.getString("assetbrandEntryId"));
		}
		if (!inputObj.isNull("assetbrandEntryDate")) {
			assetbrandEntryDate = CNumeric(inputObj.getString("assetbrandEntryDate"));
		}
		if (!inputObj.isNull("assetbrandModifiedId")) {
			assetbrandModifiedId = PadQuotes(inputObj.getString("assetbrandModifiedId"));
		}
		if (!inputObj.isNull("assetbrandModifiedDate")) {
			assetbrandModifiedDate = CNumeric(inputObj.getString("assetbrandModifiedDate"));
		}
	}

	public void checkForm() {
		if (assetbrandName.equals("")) {
			msg += "Enter Asset Brand Name!";
		}
	}

	public void addFields(HttpServletResponse response) throws ParseException {
		checkForm();
		AxelaServiceContractAssetBrand axelaServiceContractAssetBrand = null;
		if (msg.equals("")) {
			if (!assetbrandId.equals("0")) {
				axelaServiceContractAssetBrand = serviceContractAssetBrandRepository.findOne(Integer.parseInt(assetbrandId));
			} else {
				axelaServiceContractAssetBrand = new AxelaServiceContractAssetBrand();
			}
			axelaServiceContractAssetBrand.setAssetbrandId(Integer.parseInt(assetbrandId));
			axelaServiceContractAssetBrand.setAssetbrandName(assetbrandName);
			if (assetbrandId.equals("0") && requestType.equals("add")) {
				axelaServiceContractAssetBrand.setAssetbrandEntryDate(stringToDate(toLongDate(kknow())));;
				axelaServiceContractAssetBrand.setAssetbrandEntryId(empId);
				axelaServiceContractAssetBrand.setAssetbrandModifiedId(0);
				axelaServiceContractAssetBrand.setAssetbrandModifiedDate(stringToDate(""));
			} else if (!assetbrandId.equals("0") && requestType.equals("update")) {
				axelaServiceContractAssetBrand.setAssetbrandModifiedId(empId);
				axelaServiceContractAssetBrand.setAssetbrandModifiedDate(stringToDate(toLongDate(kknow())));
			}
			assetbrandId = serviceContractAssetBrandRepository.save(axelaServiceContractAssetBrand).getAssetbrandId() + "";
			if (assetbrandId.equals("0") && requestType.equals("add")) {
				output.put("successmsg", "Asset Brand Added Successfully!");
			} else if (!assetbrandId.equals("0") && requestType.equals("update")) {
				output.put("successmsg", "Asset Brand Updated Successfully!");
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
		if (!inputObj.isNull("assetbrandId")) {
			assetbrandId = CNumeric(PadQuotes(inputObj.getString("assetbrandId")));
		}
		if (!assetbrandId.equals("0")) {
			AxelaServiceContractAssetBrand axelaServiceContractAssetBrand = serviceContractAssetBrandRepository.findOne(Integer.parseInt(assetbrandId));
			if (axelaServiceContractAssetBrand != null) {
				map.put("assetbrandName", axelaServiceContractAssetBrand.getAssetbrandName());
				AxelaEmp axelaEmp = empRepository.findByEmpId(axelaServiceContractAssetBrand.getAssetbrandEntryId());
				if (axelaServiceContractAssetBrand.getAssetbrandEntryId() != 0) {
					map.put("assetbrandEntryId", axelaServiceContractAssetBrand.getAssetbrandEntryId());
					map.put("assetbrandEntryBy", axelaEmp.getEmpName());
					map.put("assetbrandEntryDate", strToShortDate(axelaServiceContractAssetBrand.getAssetbrandEntryDate()));
				}
				if (axelaServiceContractAssetBrand.getAssetbrandModifiedId() != 0) {
					map.put("assetbrandModifiedId", axelaServiceContractAssetBrand.getAssetbrandModifiedId());
					map.put("assetbrandModifiedBy", axelaEmp.getEmpName());
					map.put("assetbrandModifiedDate", strToShortDate(axelaServiceContractAssetBrand.getAssetbrandModifiedDate()));
				}
				list.add(map);
				output.put("populateData", list);
			}
		}
		return output;
	}

	public void deleteFields(String assetbrandId) {
		serviceContractAssetBrandRepository.delete(Integer.parseInt(assetbrandId));
		output.put("successmsg", "Asset Brand Deleted Successfully!");
	}

	public Map listData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		page = 0;
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			List<AxelaServiceContractAssetBrand> assetBrandList = null;
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
			// perPage = CNumeric(getSession("emp_recperpage", session));
			if (perPage.equals("0")) {
				perPage = "25";
			}
			if (sortDirection.equals("")) {
				sortDirection = "DESC";
			}
			if (sortField.equals("")) {
				sortField = "assetbrandId";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			String strOrderBy = " ORDER BY brand." + sortField + " " + sortDirection;
			assetBrandList = portalFilterImpl.findAllAssetBrand(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			totalCount = Integer.parseInt(PortalFilterImpl.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Asset Brand Details", "assetbrandName", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaServiceContractAssetBrand obj : assetBrandList) {
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
				value.add(obj.getAssetbrandName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				mapData.put("td", listData);
				actionParam.add("updateAssetBrand");
				actionParam.add(obj.getAssetbrandId() + "");
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
		mapBodyData.put("value", "Update Asset Brand");
		mapBodyData.put("param", actionParam);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "brand.*"));
		list.add(buildSmartArr("Asset Brand ID", "numeric", "brand.assetbrandId"));
		list.add(buildSmartArr("Asset Brand Name", "text", "brand.assetbrandName"));
		// list.add(buildSmartArr("Entry By", "text", "brand.assetbrandEntryId)"));
		list.add(buildSmartArr("Entry Date", "date", "brand.assetbrandEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "brand.assetbrandModifiedId"));
		list.add(buildSmartArr("Modified Date", "date", "brand.assetbrandModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

}
