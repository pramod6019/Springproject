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
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;
import axela.service.model.AxelaServiceContractPriority;
import axela.service.repository.ContractPriorityFilterImpl;
import axela.service.repository.ServiceContractPriorityRepository;

@Service
public class ContractPriorityService extends Connect {
	public String contractpriorityId = "0";
	public String contractpriorityName = "";
	public String contractpriorityDesc = "";
	public String contractpriorityRank = "";
	public String contractpriorityDuehrs = "";
	public String contractpriorityTrigger1Hrs = "";
	public String contractpriorityTrigger2Hrs = "";
	public String contractpriorityTrigger3Hrs = "";
	public String contractpriorityTrigger4Hrs = "";
	public String contractpriorityTrigger5Hrs = "";
	public String contractpriorityBusinessHrs = "0";
	public String contractpriorityStarttime = "00:00";
	public String contractpriorityEndtime = "00:00";
	public String contractprioritySun = "0";
	public String contractpriorityMon = "0";
	public String contractpriorityTue = "0";
	public String contractpriorityWed = "0";
	public String contractpriorityThu = "0";
	public String contractpriorityFri = "0";
	public String contractprioritySat = "0";
	public String contractpriorityEntryId = "0";
	public String contractpriorityEntryDate = "";
	public String contractpriorityModifiedId = "0";
	public String contractpriorityModifiedDate = "";
	private String startTime = "00:00";
	private String endTime = "00:00";
	public String requestType = "";
	public String msg = "";
	public String pageNumber = "";
	public int empId = 0;
	public int compId = 0;
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
	JSONObject inputObj = null;

	// @Autowired
	// AxelaServiceContractPriority axelaServiceContractPriority;

	@Autowired
	ServiceContractPriorityRepository serviceContractPriorityRepository;

	@Autowired
	EmpRepository empRepository;

	@Autowired
	PortalFilterImpl portalFilterImpl;

	@Autowired
	ContractPriorityFilterImpl contractPriorityFilterImpl;

	public Map<String, String> contractPriorityService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}

		switch (requestType) {

			case "add" :
				getValues(inputObj);
				addFields(response, session);
				break;

			case "update" :
				getValues(inputObj);
				addFields(response, session);
				break;

			case "delete" :
				if (!inputObj.isNull("contractpriorityId")) {
					contractpriorityId = inputObj.getString("contractpriorityId");
				}
				if (!contractpriorityId.equals("0")) {
					deleteFields(contractpriorityId);
				}
				break;

			case "moveup" :
				if (!inputObj.isNull("contractpriorityId")) {
					contractpriorityId = inputObj.getString("contractpriorityId");
				}
				if (!contractpriorityId.equals("0")) {
					moveUp(contractpriorityId);
				}
				break;

			case "movedown" :
				if (!inputObj.isNull("contractpriorityId")) {
					contractpriorityId = inputObj.getString("contractpriorityId");
				}
				if (!contractpriorityId.equals("0")) {
					moveDown(contractpriorityId);
				}
				break;
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("contractpriorityId")) {
			contractpriorityId = CNumeric(inputObj.getString("contractpriorityId"));
		}
		if (!inputObj.isNull("contractpriorityName")) {
			contractpriorityName = PadQuotes(inputObj.getString("contractpriorityName"));
		}
		if (!inputObj.isNull("contractpriorityDesc")) {
			contractpriorityDesc = PadQuotes(inputObj.getString("contractpriorityDesc"));
		}
		if (!inputObj.isNull("contractpriorityDuehrs")) {
			contractpriorityDuehrs = CNumeric(inputObj.getString("contractpriorityDuehrs"));
		}

		if (!inputObj.isNull("contractpriorityRank")) {
			contractpriorityRank = PadQuotes(inputObj.getString("contractpriorityRank"));
		}
		if (!inputObj.isNull("contractpriorityTrigger1Hrs")) {
			contractpriorityTrigger1Hrs = CNumeric(inputObj.getString("contractpriorityTrigger1Hrs"));
			if (contractpriorityTrigger1Hrs.equals("")) {
				contractpriorityTrigger1Hrs = "0:00";
			}
		}
		if (!inputObj.isNull("contractpriorityTrigger2Hrs")) {
			contractpriorityTrigger2Hrs = PadQuotes(inputObj.getString("contractpriorityTrigger2Hrs"));
			if (contractpriorityTrigger2Hrs.equals("")) {
				contractpriorityTrigger2Hrs = "0:00";
			}
		}
		if (!inputObj.isNull("contractpriorityTrigger3Hrs")) {
			contractpriorityTrigger3Hrs = CNumeric(inputObj.getString("contractpriorityTrigger3Hrs"));
			if (contractpriorityTrigger3Hrs.equals("")) {
				contractpriorityTrigger3Hrs = "0:00";
			}
		}
		if (!inputObj.isNull("contractpriorityTrigger4Hrs")) {
			contractpriorityTrigger4Hrs = CNumeric(inputObj.getString("contractpriorityTrigger4Hrs"));
			if (contractpriorityTrigger4Hrs.equals("")) {
				contractpriorityTrigger4Hrs = "0:00";
			}
		}
		if (!inputObj.isNull("contractpriorityTrigger5Hrs")) {
			contractpriorityTrigger5Hrs = CNumeric(inputObj.getString("contractpriorityTrigger5Hrs"));
			if (contractpriorityTrigger5Hrs.equals("")) {
				contractpriorityTrigger5Hrs = "0:00";
			}
		}

		if (!inputObj.isNull("contractpriorityBusinessHrs")) {
			contractpriorityBusinessHrs = PadQuotes(inputObj.getString("contractpriorityBusinessHrs"));
			if (contractpriorityBusinessHrs.equals("1")) {
				if (!inputObj.isNull("startTime")) {
					startTime = CNumeric(inputObj.getString("startTime"));
				}
				if (startTime.contains(":") && !startTime.equals("")) {
					startTime = startTime.replace(':', '.');
				}
				if (!inputObj.isNull("endTime")) {
					endTime = CNumeric(inputObj.getString("endTime"));
				}
				if (endTime.contains(":") && !endTime.equals("")) {
					endTime = endTime.replace(':', '.');
				}
				if (!inputObj.isNull("contractprioritySun")) {
					contractprioritySun = String.valueOf(inputObj.getString("contractprioritySun"));
				}
				if (!inputObj.isNull("contractpriorityMon")) {
					contractpriorityMon = String.valueOf(inputObj.getString("contractpriorityMon"));
				}
				if (!inputObj.isNull("contractpriorityTue")) {
					contractpriorityTue = String.valueOf(inputObj.getString("contractpriorityTue"));
				}
				if (!inputObj.isNull("contractpriorityWed")) {
					contractpriorityWed = String.valueOf(inputObj.getString("contractpriorityWed"));
				}
				if (!inputObj.isNull("contractpriorityThu")) {
					contractpriorityThu = String.valueOf(inputObj.getString("contractpriorityThu"));
				}
				if (!inputObj.isNull("contractpriorityFri")) {
					contractpriorityFri = String.valueOf(inputObj.getString("contractpriorityFri"));
				}
				if (!inputObj.isNull("contractprioritySat")) {
					contractprioritySat = String.valueOf(inputObj.getString("contractprioritySat"));
				}
			} else {
				startTime = "00.00";
				endTime = "00.00";
				contractprioritySun = "0";
				contractpriorityMon = "0";
				contractpriorityTue = "0";
				contractpriorityWed = "0";
				contractpriorityThu = "0";
				contractpriorityFri = "0";
				contractprioritySat = "0";
			}
		}
		if (!inputObj.isNull("contractpriorityEntryDate")) {
			contractpriorityEntryDate = PadQuotes(inputObj.getString("contractpriorityEntryDate"));
		}
		if (!inputObj.isNull("contractpriorityEntryId")) {
			contractpriorityEntryId = CNumeric(PadQuotes(inputObj.getString("contractpriorityEntryId")));
		}
		if (!inputObj.isNull("contractpriorityModifiedDate")) {
			contractpriorityModifiedDate = PadQuotes(inputObj.getString("contractpriorityModifiedDate"));
		}
		if (!inputObj.isNull("contractpriorityModifiedDate")) {
			contractpriorityModifiedId = CNumeric(PadQuotes(inputObj.getString("contractpriorityModifiedDate")));
		}
	}

	public void validateFields(HttpServletResponse response) {

		if (contractpriorityName.equals("")) {
			msg += "Enter Contract Priority Name!";
		}
		if (contractpriorityDesc.equals("")) {
			msg += "Enter description!";
		}
		if (contractpriorityDuehrs.equals("0.0")) {
			msg += "Enter duehrs!";
		}
		if ((!contractpriorityTrigger5Hrs.equals("0:00"))) {
			if (Double.parseDouble(contractpriorityTrigger5Hrs.replaceAll(":", "\\.")) < Double.parseDouble(contractpriorityTrigger4Hrs.replaceAll(":", "\\."))
					|| Double.parseDouble(contractpriorityTrigger5Hrs.replaceAll(":", "\\.")) < Double.parseDouble(contractpriorityTrigger3Hrs.replaceAll(":", "\\."))
					|| Double.parseDouble(contractpriorityTrigger5Hrs.replaceAll(":", "\\.")) < Double.parseDouble(contractpriorityTrigger2Hrs.replaceAll(":", "\\."))
					|| Double.parseDouble(contractpriorityTrigger5Hrs.replaceAll(":", "\\.")) < Double.parseDouble(contractpriorityTrigger1Hrs.replaceAll(":", "\\."))) {
				msg = msg + "<br> Level-5 hours should be more than previous Levels hours";
			}
		}
		if (!contractpriorityTrigger4Hrs.equals("0:00")) {
			if (Double.parseDouble(contractpriorityTrigger4Hrs.replaceAll(":", "\\.")) < Double.parseDouble(contractpriorityTrigger3Hrs.replaceAll(":", "\\."))
					|| Double.parseDouble(contractpriorityTrigger4Hrs.replaceAll(":", "\\.")) < Double.parseDouble(contractpriorityTrigger2Hrs.replaceAll(":", "\\."))
					|| Double.parseDouble(contractpriorityTrigger4Hrs.replaceAll(":", "\\.")) < Double.parseDouble(contractpriorityTrigger1Hrs.replaceAll(":", "\\."))) {
				msg = msg + "<br> Level-4 hours should be more than previous Levels hours";
			}
		}
		if (!contractpriorityTrigger3Hrs.equals("0:00")) {
			if (Double.parseDouble(contractpriorityTrigger3Hrs.replaceAll(":", "\\.")) < Double.parseDouble(contractpriorityTrigger2Hrs.replaceAll(":", "\\."))
					|| Double.parseDouble(contractpriorityTrigger3Hrs.replaceAll(":", "\\.")) < Double.parseDouble(contractpriorityTrigger1Hrs.replaceAll(":", "\\."))) {
				msg = msg + "<br> Level-3 hours should be more than previous Levels hours";
			}
		}
		if (!contractpriorityTrigger2Hrs.equals("0:00")) {
			if (Double.parseDouble(contractpriorityTrigger2Hrs.replaceAll(":", "\\.")) < Double.parseDouble(contractpriorityTrigger2Hrs.replaceAll(":", "\\."))) {
				msg = msg + "<br> Level-2 hours should be more than previous Level hours";
			}
		}
		if (contractpriorityBusinessHrs.equals("1")) {
			if (startTime.equals("")) {
				msg = msg + "<br>Enter Start Time!";
			} else if (startTime.equals("00:00") || startTime.equals("0:00") || startTime.equals("0")) {
				msg = msg + "<br>Start Time should be greater than Zero!";
			} else if (isNumeric(startTime)) {
				if (Integer.parseInt(startTime) == 0) {
					msg = msg + "<br>Start Time should be greater than Zero!";
				}
			}
			if (endTime.equals("")) {
				msg = msg + "<br>Enter End Time!";
			} else if (endTime.equals("00:00") || endTime.equals("0:00") || endTime.equals("0")) {
				msg = msg + "<br>End Time should be greater than Zero!";
			} else if (isNumeric(endTime)) {
				if (Integer.parseInt(endTime) == 0) {
					msg = msg + "<br>End Time should be greater than Zero!";
				}
			}
			if (startTime.contains(":") && !startTime.equals("0") && endTime.contains(":") && !endTime.equals("0")) {
				if (Integer.parseInt(startTime.replace(":", "")) < Integer.parseInt(startTime.replace(":", ""))) {
					msg = msg + "<br>End Time Should be greater than Start Time!";
				}
			}
		}
	}

	public void addFields(HttpServletResponse response, HttpSession session) throws ParseException {
		validateFields(response);
		AxelaServiceContractPriority axelaServiceContractPriority = null;
		if (msg.equals("")) {
			if (!contractpriorityId.equals("0")) {
				axelaServiceContractPriority = serviceContractPriorityRepository.findOne(Integer.parseInt(contractpriorityId));
			} else {
				axelaServiceContractPriority = new AxelaServiceContractPriority();
			}
			axelaServiceContractPriority.setContractpriorityId(Integer.parseInt(contractpriorityId));
			axelaServiceContractPriority.setContractpriorityDesc(contractpriorityDesc);
			axelaServiceContractPriority.setContractpriorityName(contractpriorityName);
			axelaServiceContractPriority.setContractpriorityDuehrs(contractpriorityDuehrs);
			axelaServiceContractPriority.setContractpriorityRank(serviceContractPriorityRepository.findMaxRank());
			axelaServiceContractPriority.setContractpriorityTrigger1Hrs(contractpriorityTrigger1Hrs);
			axelaServiceContractPriority.setContractpriorityTrigger2Hrs(contractpriorityTrigger2Hrs);
			axelaServiceContractPriority.setContractpriorityTrigger3Hrs(contractpriorityTrigger3Hrs);
			axelaServiceContractPriority.setContractpriorityTrigger4Hrs(contractpriorityTrigger4Hrs);
			axelaServiceContractPriority.setContractpriorityTrigger5Hrs(contractpriorityTrigger5Hrs);
			SOP("contractpriorityBusinessHrs==========" + contractpriorityBusinessHrs);
			if (contractpriorityBusinessHrs.equals("1")) {
				axelaServiceContractPriority.setContractpriorityBusinessHrs(contractpriorityBusinessHrs);
				axelaServiceContractPriority.setContractpriorityStarttime(Double.parseDouble(startTime));
				axelaServiceContractPriority.setContractpriorityEndtime(Double.parseDouble(startTime));
				axelaServiceContractPriority.setContractprioritySun(contractprioritySun);
				axelaServiceContractPriority.setContractpriorityMon(contractpriorityMon);
				axelaServiceContractPriority.setContractpriorityTue(contractpriorityTue);
				axelaServiceContractPriority.setContractpriorityWed(contractpriorityWed);
				axelaServiceContractPriority.setContractpriorityThu(contractpriorityThu);
				axelaServiceContractPriority.setContractpriorityFri(contractpriorityFri);
				axelaServiceContractPriority.setContractprioritySat(contractprioritySat);
			} else {
				axelaServiceContractPriority.setContractpriorityBusinessHrs("0");
				axelaServiceContractPriority.setContractpriorityStarttime(Double.parseDouble(startTime));
				axelaServiceContractPriority.setContractpriorityEndtime(Double.parseDouble(endTime));
				axelaServiceContractPriority.setContractprioritySun(contractprioritySun);
				axelaServiceContractPriority.setContractpriorityMon(contractpriorityMon);
				axelaServiceContractPriority.setContractpriorityTue(contractpriorityTue);
				axelaServiceContractPriority.setContractpriorityWed(contractpriorityWed);
				axelaServiceContractPriority.setContractpriorityThu(contractpriorityThu);
				axelaServiceContractPriority.setContractpriorityFri(contractpriorityFri);
				axelaServiceContractPriority.setContractprioritySat(contractprioritySat);
			}
			if (contractpriorityId.equals("0") && requestType.equals("add")) {
				axelaServiceContractPriority.setContractpriorityEntryId(empId);
				axelaServiceContractPriority.setContractpriorityEntryDate(getTimeByZone(session));
				axelaServiceContractPriority.setContractpriorityModifiedDate(stringToDate(""));
				axelaServiceContractPriority.setContractpriorityModifiedId(0);
			} else if (!contractpriorityId.equals("0") && requestType.equals("update")) {
				axelaServiceContractPriority.setContractpriorityEntryId(axelaServiceContractPriority.getContractpriorityEntryId());
				axelaServiceContractPriority.setContractpriorityEntryDate(axelaServiceContractPriority.getContractpriorityEntryDate());
				axelaServiceContractPriority.setContractpriorityModifiedId(empId);
				axelaServiceContractPriority.setContractpriorityModifiedDate(getTimeByZone(session));
			}
			contractpriorityId = serviceContractPriorityRepository.save(axelaServiceContractPriority).getContractpriorityId() + "";
			if (!contractpriorityId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
				output.put("contractpriorityId", contractpriorityId);
				output.put("successmsg", "Contract Priority Added successfully!");
			} else if (!contractpriorityId.equals("0") && requestType.equals("update")) {
				output.put("contractpriorityId", contractpriorityId);
				output.put("successmsg", "Contract Priority Updated successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String contractpriorityId) {
		serviceContractPriorityRepository.delete(Integer.parseInt(contractpriorityId));
		output.put("successmsg", "Contract Priority Deleted successfully!");
	}

	public Map<String, List> populateData(String input) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		LinkedHashMap map = new LinkedHashMap();
		if (!inputObj.isNull("contractpriorityId")) {
			contractpriorityId = CNumeric(PadQuotes(inputObj.getString("contractpriorityId")));
		}
		if (!contractpriorityId.equals("0")) {
			AxelaServiceContractPriority axelaServiceContractPriority = serviceContractPriorityRepository.findOne(Integer.parseInt(contractpriorityId));
			if (axelaServiceContractPriority != null) {
				map.put("contractpriorityName", axelaServiceContractPriority.getContractpriorityName());
				map.put("contractpriorityDesc", axelaServiceContractPriority.getContractpriorityDesc());
				map.put("contractpriorityDuehrs", axelaServiceContractPriority.getContractpriorityDuehrs());
				map.put("contractpriorityTrigger1Hrs", axelaServiceContractPriority.getContractpriorityTrigger1Hrs());
				map.put("contractpriorityTrigger2Hrs", axelaServiceContractPriority.getContractpriorityTrigger2Hrs());
				map.put("contractpriorityTrigger3Hrs", axelaServiceContractPriority.getContractpriorityTrigger3Hrs());
				map.put("contractpriorityTrigger4Hrs", axelaServiceContractPriority.getContractpriorityTrigger4Hrs());
				map.put("contractpriorityTrigger5Hrs", axelaServiceContractPriority.getContractpriorityTrigger5Hrs());
				map.put("contractpriorityStarttime", axelaServiceContractPriority.getContractpriorityStarttime());
				map.put("contractpriorityEndtime", axelaServiceContractPriority.getContractpriorityEndtime());
				map.put("contractprioritySun", Integer.parseInt(axelaServiceContractPriority.getContractprioritySun()));
				map.put("contractpriorityMon", Integer.parseInt(axelaServiceContractPriority.getContractpriorityMon()));
				map.put("contractpriorityTue", Integer.parseInt(axelaServiceContractPriority.getContractpriorityTue()));
				map.put("contractpriorityWed", Integer.parseInt(axelaServiceContractPriority.getContractpriorityWed()));
				map.put("contractpriorityThu", Integer.parseInt(axelaServiceContractPriority.getContractpriorityThu()));
				map.put("contractpriorityFri", Integer.parseInt(axelaServiceContractPriority.getContractpriorityFri()));
				map.put("contractprioritySat", Integer.parseInt(axelaServiceContractPriority.getContractprioritySat()));
				if (axelaServiceContractPriority.getContractpriorityEntryId() != 0) {
					map.put("contractpriorityEntryDate", strToShortDate(axelaServiceContractPriority.getContractpriorityEntryDate()));
					map.put("contractpriorityEntryBy", empRepository.findEmpName(axelaServiceContractPriority.getContractpriorityEntryId()));
					map.put("contractpriorityEntryId", axelaServiceContractPriority.getContractpriorityEntryId());
				}
				if (axelaServiceContractPriority.getContractpriorityModifiedId() != 0) {
					map.put("contractpriorityModifiedDate", strToShortDate(axelaServiceContractPriority.getContractpriorityModifiedDate()));
					map.put("contractpriorityModifiedBy", empRepository.findEmpName(axelaServiceContractPriority.getContractpriorityModifiedId()));
					map.put("contractpriorityModifiedId", axelaServiceContractPriority.getContractpriorityModifiedId());
				}
				list.add(map);
				output.put("populateData", list);
			}
		}
		return output;
	}

	public Map listData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		page = 0;
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			perPage = CNumeric(getSession("empRecperpage", session));
			List<AxelaServiceContractPriority> priorityList = null;
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
				sortField = "contractpriorityId";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess + exeAccess;
			String strOrderBy = " ORDER BY Priority." + sortField + " " + sortDirection;
			priorityList = contractPriorityFilterImpl.findAllContractPriority(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			totalCount = Integer.parseInt(contractPriorityFilterImpl.totalCount);
			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Contract Priority Details", "contractpriorityName", "center"));
			listHeader.add(produceHeaderData("Order", "contractpriorityRank", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaServiceContractPriority obj : priorityList) {
				ArrayList<String> param = new ArrayList<String>();
				ArrayList type = new ArrayList();
				ArrayList value = new ArrayList();
				ArrayList<String> actionParam = new ArrayList<String>();
				ArrayList<ArrayList> paramArr = new ArrayList<ArrayList>();
				ArrayList<String> paramSubArr = new ArrayList<String>();
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
				value.add(obj.getContractpriorityName());
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				type.add(true);
				value.add("Up-Down");
				paramSubArr.add(obj.getContractpriorityId() + "");
				paramArr.add(paramArr);
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				paramArr.clear();
				paramSubArr.clear();
				value.clear();

				mapData.put("td", listData);
				actionParam.add("updateContractPriority");
				actionParam.add(obj.getContractpriorityId() + "");
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
		mapBodyData.put("value", "Update Contract Priority");
		mapBodyData.put("param", actionParam);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "priority.*"));
		list.add(buildSmartArr("Priority ID", "numeric", "priority.prioritycontractId"));
		list.add(buildSmartArr("Name", "text", "priority.prioritycontractName"));
		list.add(buildSmartArr("Desc", "text", "priority.prioritycontractDesc"));
		list.add(buildSmartArr("Rank", "numeric", "priority.prioritycontractRank"));
		list.add(buildSmartArr("DueHrs", "numeric", "priority.prioritycontractDuehrs"));
		list.add(buildSmartArr("Trigger1", "numeric", "priority.prioritycontractTrigger1Hrs"));
		list.add(buildSmartArr("Trigger2", "numeric", "priority.prioritycontractTrigger1Hrs"));
		list.add(buildSmartArr("Trigger3", "numeric", "priority.prioritycontractTrigger1Hrs"));
		list.add(buildSmartArr("Trigger4", "numeric", "priority.prioritycontractTrigger1Hrs"));
		list.add(buildSmartArr("Trigger5", "numeric", "priority.prioritycontractTrigger1Hrs"));
		// list.add(buildSmartArr("Entry By", "text", "priority.groupEntryId)"));
		list.add(buildSmartArr("Entry Date", "date", "priority.groupEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "priority.groupModifiedId"));
		list.add(buildSmartArr("Modified Date", "date", "priority.groupModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

	public void moveUp(String contractpriorityId) {
		output = new LinkedHashMap();
		int tempRank;
		int delstatusRank = 0;
		delstatusRank = serviceContractPriorityRepository.findRankfromContractPriorityId(Integer.parseInt(contractpriorityId));
		tempRank = serviceContractPriorityRepository.findMinRank();
		if (tempRank != 0 && delstatusRank != 0) {
			if (delstatusRank != tempRank) {
				tempRank = delstatusRank - 1;
				int updateCount1 = portalFilterImpl.updatePriority(delstatusRank, tempRank, "AxelaServiceContractPriority priority", "priority.contractpriorityRank");
				int updateCount2 = portalFilterImpl.updatePriorityById(delstatusRank, tempRank, "priority.contractpriorityId", Integer.parseInt(contractpriorityId),
						"AxelaServiceContractPriority priority",
						"type.activitytypeRank");
				output.put("msg", "Contract Priority  moved up successfully!");
			}
		} else {
			output.put("errormsg", "not possible");
		}
	}

	public void moveDown(String contractpriorityId) {
		output = new LinkedHashMap();
		int tempRank;
		int delstatusRank = 0;
		delstatusRank = serviceContractPriorityRepository.findRankfromContractPriorityId(Integer.parseInt(contractpriorityId));
		tempRank = serviceContractPriorityRepository.findMaxRank();
		if (tempRank != 0 && delstatusRank != 0) {
			if (delstatusRank != tempRank) {
				tempRank = delstatusRank + 1;
				int updateCount1 = portalFilterImpl.updatePriority(delstatusRank, tempRank, "AxelaServiceContractPriority priority", "priority.contractpriorityRank");
				int updateCount2 = portalFilterImpl.updatePriorityById(delstatusRank, tempRank, "priority.contractpriorityId", Integer.parseInt(contractpriorityId),
						"AxelaServiceContractPriority priority",
						"type.activitytypeRank");
				output.put("msg", "Contract Priority moved Down successfully!");
			}
		} else {
			output.put("errormsg", "not possible");
		}
	}

}
