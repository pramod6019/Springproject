package axela.service.service;

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

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.helpdesk.repository.TicketRepository;
import axela.portal.repository.EmpRepository;
import axela.service.model.AxelaServiceContractAsset;
import axela.service.repository.AssetFilterImpl;
import axela.service.repository.ServiceContractAssetRepository;
import axela.service.repository.ServiceContractAssetTransRepository;

@Service
public class AssetService extends Connect {

	@Autowired
	ServiceContractAssetRepository serviceContractAssetRepository;

	@Autowired
	ServiceContractAssetTransRepository serviceContractAssetTransRepository;

	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	AssetFilterImpl assetFilterImpl;

	@Autowired
	EmpRepository axelaEmpRepository;

	private final static int PAGESIZE = 25;
	public String assetId = "0";
	private String contractId = "0";
	public String assetAssetbrandId = "0";
	public String assetContractassettypeId = "0";
	public String assetContractlocId = "0";
	public String assetCustomerId = "0";
	public String assetDesc = "";
	public String assetEntryDate = "";
	private String tag = "asset";
	private String StrSql = "";
	public String assetEntryId = "0";
	public String assetModifiedDate = "";
	public String assetModifiedId = "0";
	public String assetNotes = "";
	public String assetName = "";
	public int recPerPage = 0;
	public String configInventoryLocationName = "";
	public String assetPurchaseDate = "";
	public String assetSerial = "";
	public String assetTag = "";
	public int empId = 0;
	public int compId = 0;
	public String field = "";
	public int page = 0;
	public String configCustomerName = "";
	public String branchAccess = "";
	public String requestType = "";
	public String msg = "";
	public String perPage = "0";
	public int length = 0;
	public String group = "";
	public String strSearch = "";
	public String assetAction = "";
	public String pageNumber = "";
	public String empFormatdate = "";
	public String assetpurchasedate = "";
	public String orderByField = "";
	public String orderType = "";
	public String exeAccess = "";
	public String asset_purchase_date = "";
	private String starttime = "";
	private String endtime = "";
	private String drBranchId = "0";
	private String startTime = "";
	private String endTime = "";
	private String branchId = "0";
	HashMap output = null;
	JSONObject inputObj = null;

	public Map assetsService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		configInventoryLocationName = getSession("configInventoryLocationName", session);
		empFormatdate = PadQuotes(getSession("formatdateName", session));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (empId != 0) {
			switch (requestType) {
				case "add" : // add an asset.
					if (!returnPerm("emp_asset_add", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					assetId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;

				case "update" :// update an asset.
					assetId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;

				case "delete" :// delete an asset.
					if (!returnPerm("emp_asset_delete", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					if (!inputObj.isNull("assetId")) {
						assetId = inputObj.getString("assetId");
					}
					if (!inputObj.isNull("contractId")) {
						contractId = inputObj.getString("contractId");
					}
					if (!assetId.equals("0")) {
						deleteFields(assetId);
					}
					break;

				case "landing" :// delete an asset.
					if (!inputObj.isNull("startTime")) {
						startTime = PadQuotes(inputObj.getString("startTime"));
					}
					if (!inputObj.isNull("endTime")) {
						endTime = PadQuotes(inputObj.getString("endTime"));
					}
					String date = "";
					if (startTime.equals("") || endTime.equals("")) {
						date = sdf.format(getTimeByZone(session));
					}
					SOP("empFormatdate==========" + empFormatdate);
					if (startTime.equals("")) {
						startTime = ReportStartdate(date, empFormatdate);
					}
					if (endTime.equals("")) {
						endTime = formatDate(date, empFormatdate);
					}

					if (branchId.equals("0")) {
						if (!inputObj.isNull("drBranchId")) {
							drBranchId = PadQuotes(inputObj.getString("drBranchId"));
						}
						if (drBranchId.equals("")) {
							drBranchId = "0";
						}
					} else {
						drBranchId = branchId;
					}
					populateLandingData(input, session, response);
					break;
			}
		}
		return output;
	}
	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("assetId")) {
			assetId = CNumeric(inputObj.getString("assetId"));
		}
		if (!inputObj.isNull("assetAssetbrandId")) {
			assetAssetbrandId = CNumeric(inputObj.getString("assetAssetbrandId"));
		}
		if (!inputObj.isNull("assetContractassettypeId")) {
			assetContractassettypeId = CNumeric(inputObj.getString("assetContractassettypeId"));
		}
		if (!inputObj.isNull("assetContractlocId")) {
			assetContractlocId = CNumeric(inputObj.getString("assetContractlocId"));
		}
		if (!inputObj.isNull("assetCustomerId")) {
			assetCustomerId = CNumeric(inputObj.getString("assetCustomerId"));
		}
		if (!inputObj.isNull("assetDesc")) {
			assetDesc = PadQuotes(inputObj.getString("assetDesc"));
		}
		if (!inputObj.isNull("assetModifiedDate")) {
			assetModifiedDate = PadQuotes(inputObj.getString("assetModifiedDate"));
		}
		if (!inputObj.isNull("assetModifiedId")) {
			assetModifiedId = CNumeric(inputObj.getString("assetModifiedId"));
		}
		if (!inputObj.isNull("assetName")) {
			assetName = PadQuotes(inputObj.getString("assetName"));
		}
		if (!inputObj.isNull("assetPurchaseDate")) {
			assetPurchaseDate = PadQuotes(inputObj.getString("assetPurchaseDate"));
		}
		if (!inputObj.isNull("assetSerial")) {
			assetSerial = PadQuotes(inputObj.getString("assetSerial"));
		}
		if (!inputObj.isNull("assetEntryDate")) {
			assetEntryDate = PadQuotes(inputObj.getString("assetEntryDate"));
		}
		if (!inputObj.isNull("assetEntryId")) {
			assetEntryId = CNumeric(PadQuotes(inputObj.getString("assetEntryId")));
		}
		if (!inputObj.isNull("contractId")) {
			contractId = CNumeric(PadQuotes(inputObj.getString("contractId")));
		}
		if (!inputObj.isNull("assetTag")) {
			assetTag = PadQuotes(inputObj.getString("assetTag"));
		}
		if (!inputObj.isNull("assetNotes")) {
			assetNotes = PadQuotes(inputObj.getString("assetNotes"));
			if (assetNotes.length() > 5000) {
				assetNotes = assetNotes.substring(0, 4999);
			}
		}
	}

	public void validateFields() throws ParseException {
		if (assetCustomerId.equals("0")) {
			msg += "<br>Select Customer!";
		}
		if (!assetCustomerId.equals("0")) {
			if (assetContractlocId.equals("0")) {
				msg += "<br>Select Location!";
			}
		}
		if (assetName.equals("")) {
			msg += "<br>Enter Asset Name!";
		}
		if (assetSerial.equals("")) {
			msg += "<br>Enter Serial!";
		}
		if (!assetSerial.equals("") && !assetSerial.equals("0")) {
			Object obj = serviceContractAssetRepository.findBySerial(Integer.parseInt(contractId), assetSerial);
			if (requestType.equals("update")) {
				Object axelaServiceContractAsset = serviceContractAssetRepository.findBySerialUpdate(Integer.parseInt(contractId), assetSerial, Integer.parseInt(assetId));
			}
			if (obj != null) {
				msg += "<br>Similar Serial Found! ";
			}
		}
		if (assetContractassettypeId.equals("0")) {
			msg += "<br>Select Type!";
		}
		if (assetAssetbrandId.equals("0")) {
			msg += "<br>Select Brand!";
		}
		if (assetPurchaseDate.equals("")) {
			msg += "<br>Select Date!";

		} else if (isValidDateFormat(assetPurchaseDate, empFormatdate)) {
			assetPurchaseDate = assetPurchaseDate;
		} else {
			asset_purchase_date = assetpurchasedate;
			msg += "<br>Enter Valid Acquired Date!";
			assetpurchasedate = "";
		}
	}

	public void addFields(HttpServletResponse response, HttpSession session) throws ParseException {
		validateFields();
		AxelaServiceContractAsset Axelaservicecontractasset = null;
		if (msg.equals("")) {
			if (!assetId.equals("0")) {
				Axelaservicecontractasset = serviceContractAssetRepository.findOne(Integer.parseInt(assetId));
			} else {
				Axelaservicecontractasset = new AxelaServiceContractAsset();
			}
			Axelaservicecontractasset.setAssetId(Integer.parseInt(assetId));
			Axelaservicecontractasset.setAssetAssetbrandId(Integer.parseInt(assetAssetbrandId));
			Axelaservicecontractasset.setAssetContractassettypeId(Integer.parseInt(assetContractassettypeId));
			Axelaservicecontractasset.setAssetContractlocId(Integer.parseInt(assetContractlocId));
			Axelaservicecontractasset.setAssetCustomerId(Integer.parseInt(assetCustomerId));
			Axelaservicecontractasset.setAssetDesc(assetDesc);
			Axelaservicecontractasset.setAssetName(assetName);
			Axelaservicecontractasset.setAssetNotes(assetNotes);
			Axelaservicecontractasset.setAssetPurchaseDate(stringToDate(assetPurchaseDate));
			Axelaservicecontractasset.setAssetSerial(assetSerial);
			Axelaservicecontractasset.setAssetTag(assetTag);
			if (requestType.equals("add")) {
				Axelaservicecontractasset.setAssetEntryDate(getTimeByZone(session));
				Axelaservicecontractasset.setAssetEntryId(empId);
				Axelaservicecontractasset.setAssetModifiedId(0);

			} else {
				Axelaservicecontractasset.setAssetEntryDate(Axelaservicecontractasset.getAssetEntryDate());
				Axelaservicecontractasset.setAssetEntryId(Axelaservicecontractasset.getAssetEntryId());
				Axelaservicecontractasset.setAssetModifiedId(empId);
				Axelaservicecontractasset.setAssetModifiedDate(getTimeByZone(session));
			}
			AxelaServiceContractAsset result = null;
			result = serviceContractAssetRepository.save(Axelaservicecontractasset);
			if (result != null && requestType.equals("add")) {
				output.put("successmsg", "Asset Added Successfully!");
				output.put("assetId", result.getAssetId() + "");
			} else if (result != null && requestType.equals("update")) {
				output.put("successmsg", "Asset Updated Successfully!");
				output.put("assetId", result.getAssetId() + "");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}
	public Map<String, String> populateAssetData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap();
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			if (!returnPerm("emp_asset_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			LinkedHashMap map = new LinkedHashMap();
			if (!inputObj.isNull("assetId")) {
				assetId = CNumeric(PadQuotes(inputObj.getString("assetId")));
			}
			if (!assetId.equals("0")) {
				List<Object[]> asset = assetFilterImpl.findBypopulate(assetId, session);
				AxelaServiceContractAsset axelaServiceContractAsset = new AxelaServiceContractAsset();
				for (Object[] results : asset) {
					map.put("assetCustomerId", String.valueOf(results[0]));
					map.put("assetContractlocId", String.valueOf(results[1]));
					map.put("assetName", "" + results[2]);
					map.put("assetContractassettypeId", String.valueOf(results[3]));
					map.put("assetAssetbrandId", String.valueOf(results[4]));
					map.put("assetSerial", "" + results[5]);
					map.put("assetTag", "" + results[6]);
					map.put("assetDesc", "" + results[7]);
					map.put("assetPurchaseDate", "" + strToShortDate((Date) results[8]));
					map.put("assetNotes", "" + results[9]);
					if (!results[18].equals("0")) {
						map.put("assetEntryDate", strToShortDate((Date) results[19]));
						map.put("assetEntryId", String.valueOf(results[18]));
						map.put("assetEntryBy", axelaEmpRepository.findEmpName(Integer.parseInt(String.valueOf(results[18]))));
					}
					if (!results[20].equals("0")) {
						map.put("assetModifiedDate", strToShortDate((Date) results[17]));
						map.put("assetModifiedId", String.valueOf(results[20]));
						map.put("assetModifiedBy", axelaEmpRepository.findEmpName(Integer.parseInt(String.valueOf(results[20]))));
					}
					list.add(map);
				}
				output.put("populateData", list);
			}
		}
		return output;
	}
	public Map populateAssetDetails(String input, HttpServletResponse response) throws JSONException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, String>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (!inputObj.isNull("empId")) {
			empId = Integer.parseInt(CNumeric(PadQuotes(inputObj.getString("empId"))));
		}
		if (empId != 0) {
			int empRoleId = serviceContractAssetRepository.findEmpId(empId);
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("empRoleId", String.valueOf(empId));
			list.add(map);
			output.put("successMsg", list);
		}
		return output;
	}

	public void deleteFields(String assetId) {
		serviceContractAssetTransRepository.deleteByAssetTransAssetIdAndAssetTransContractId(Integer.parseInt(assetId), Integer.parseInt(contractId));
		StrSql = CNumeric(PadQuotes(String.valueOf(ticketRepository.findByTicketAssetId(Integer.parseInt(assetId)))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + "is associated with  ticket!";
		}
		if (msg.equals("")) {
			serviceContractAssetRepository.delete(Integer.parseInt(assetId));
			output.put("successmsg", "Assest Deleted Successfully!");
		}
	}

	public Map<String, String> populateLandingData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap();
		String strSearch = "";
		long grandTotal = 0L;
		branchAccess = getSession("branchAccess", session).replaceAll("branchId", "asset.axelaCustomers.axelaBranch.BranchId");
		if (!starttime.equals("")) {
			strSearch = " and asset.assetPurchaseDate >= '" + compableDateToString(starttime) + "'";
		}
		if (!endtime.equals("")) {
			strSearch = strSearch + " and asset.assetPurchaseDate < '" + compableDateToString(endtime) + "'";
		}
		if (!drBranchId.equals("0")) {
			strSearch = strSearch + " and asset.axelaCustomers.axelaBranch.branchId=" + drBranchId;
		}
		strSearch = strSearch + "  and asset.axelaCustomers.axelaBranch.branchActive='1' ";
		strSearch += branchAccess;
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<Object[]> contract = assetFilterImpl.findAssetSummary(strSearch, session);
		for (Object[] results : contract) {
			LinkedHashMap map = new LinkedHashMap<String, String>();
			map.put("branchName", String.valueOf(results[0]));
			map.put("branchId", String.valueOf(results[1]));
			map.put("assetCount", Long.parseLong(String.valueOf(results[2])));
			grandTotal += Long.parseLong(String.valueOf(results[2]));
			list.add(map);
		}
		output.put("populateLandingData", list);
		output.put("grandTotal", grandTotal);
		return output;
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		requestType = "";
		if (empId != 0) {
			if (!returnPerm("emp_asset_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			page = 0;
			String strSearch = "";
			String strOrderBy = "";
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			perPage = CNumeric(getSession("empRecperpage", session));
			configCustomerName = PadQuotes(getSession("configCustomerName", session));
			branchAccess = PadQuotes(getSession("branchAccess", session).replaceAll("branchId", "branch.branchId"));
			List<AxelaServiceContractAsset> assetList = null;
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
			if (!inputObj.isNull("requestType")) {
				requestType = PadQuotes((inputObj.getString("requestType")));
			}
			if (!inputObj.isNull("group")) {
				group = CNumeric(PadQuotes((inputObj.getString("group"))));
			}
			if (!inputObj.isNull("sortDirection")) {
				orderType = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
			}
			perPage = "25";
			if (orderType.equals("")) {
				orderType = "DESC";
			}
			if (orderByField.equals("")) {
				orderByField = "asset.assetId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			if (!branchAccess.equals("")) {
				strSearch += branchAccess;
			}
			strOrderBy = " ORDER BY " + orderByField + " " + orderType + "";
			assetList = assetFilterImpl.findAll(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			String length = assetFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("ID", "asset.assetId", "center"));
			listHeader.add(produceHeaderData("Asset", "asset.assetName", "left"));
			listHeader.add(produceHeaderData(configCustomerName, "customers.customerName", "left"));
			listHeader.add(produceHeaderData("Serial", "asset.assetSerial", "left"));
			listHeader.add(produceHeaderData("Tag", "asset.assetTag", "left"));
			listHeader.add(produceHeaderData("Type", "type.contractassettypeName", "left"));
			listHeader.add(produceHeaderData("Brand", "brand.assetbrandName", "left"));
			listHeader.add(produceHeaderData("Location", "location.contractlocName", "left"));
			listHeader.add(produceHeaderData("Branch", "branch.branchName", "left"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaServiceContractAsset obj : assetList) {
				ArrayList<String> paramSubArr = new ArrayList<String>();
				ArrayList<ArrayList> paramArr = new ArrayList<ArrayList>();
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
				// ID
				type.add(false);
				value.add(obj.getAssetId());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// AssetName
				type.add(false);
				value.add(obj.getAssetName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// CustomerName
				type.add(false);
				value.add(obj.getcustomerName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// assetSerial
				type.add(false);
				value.add(obj.getAssetSerial());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// assetTag
				type.add(false);
				value.add(obj.getAssetTag());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Type
				type.add(false);
				value.add(obj.getContractassettypeName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Brand
				type.add(false);
				value.add(obj.getAssetBrandname());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// location
				type.add(true);
				value.add(obj.getContractlocName());
				paramSubArr.add("loacationList");
				paramSubArr.add(obj.getAssetContractlocId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// branchSummary
				type.add(true);
				value.add(obj.getAssetBranchName());
				paramSubArr.add("branchSummary");
				paramSubArr.add(obj.getAssetBranchId() + "");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				paramArr.clear();
				paramSubArr.clear();
				// End Body data
				ArrayList<String> actionParam = new ArrayList<String>();
				ArrayList<String> actionParam1 = new ArrayList<String>();
				mapData.put("td", listData);
				actionParam.add("updateAsset");
				actionParam.add(PadQuotes(String.valueOf(obj.getAssetId())));
				actionParam1.add("ticketList");
				actionParam1.add(PadQuotes(String.valueOf(obj.getContactId())));
				actionParam1.add(PadQuotes(String.valueOf(obj.getAssetCustomerId())));
				actionParam1.add(PadQuotes(String.valueOf(obj.getAssetId())));
				mapAction.put("td", produceActionData(actionParam, actionParam1));
				listAction.add(mapAction);
				listBody.add(mapData);
			}
			output.put("meta", mapNavi);
			output.put("thead", listHeader);
			output.put("tdalign", listBodyAlign);
			output.put("tbody", listBody);
			output.put("action", listAction);
			if (AppRun().equals("0")) {
				SOP("output==========AssetService==========" + output.toString());
			}
		}
		return output;
	}

	private ArrayList<HashMap> produceActionData(ArrayList<String> Param, ArrayList<String> Param1) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Asset");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "List Tickets");
		mapBodyData.put("param", Param1);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart(HttpSession session) {
		configCustomerName = getSession("configCustomerName", session);
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "asset.*"));
		list.add(buildSmartArr("Asset ID", "numeric", "asset.assetId"));
		list.add(buildSmartArr("Asset", "text", "asset.assetName"));
		list.add(buildSmartArr(configCustomerName + " ID", "text", "asset.assetCustomerId"));
		list.add(buildSmartArr("Serial", "text", "asset.assetSerial"));
		list.add(buildSmartArr("Type Name", "text", "type.contractassettypeName"));
		list.add(buildSmartArr("Brand", "text", "asset.assetAssetbrandId"));
		list.add(buildSmartArr("Location", "text", "asset.assetContractlocId"));
		// list.add(buildSmartArr("Entry By", "text", "asset.assetEntryId"));
		list.add(buildSmartArr("Entry Date", "date", "asset.assetEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "asset.assetModifiedId"));
		list.add(buildSmartArr("Modified Date", "date", "asset.assetModifiedDate"));
		// list.add(buildSmartArr("Custom Fields", "text", "asset_id IN (SELECT cftrans_row_id FROM compdb.axela_cf_trans WHERE cftrans_submodule_id = 20 and cftrans_value"));
		output.put("drSmart", list.toArray());
		return output;
	}
	public String compableDateToString(String date) {
		String data = "";
		String[] arr = date.split("/");
		for (int i = arr.length - 1; i >= 0; i--) {
			data += arr[i];
		}
		return data + "000000";
	}
}
