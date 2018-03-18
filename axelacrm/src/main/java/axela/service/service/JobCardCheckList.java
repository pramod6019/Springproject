//package axela.service.service;
//
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.codehaus.jettison.json.JSONException;
//import org.codehaus.jettison.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Service;
//
//import axela.config.Connect;
//import axela.portal.repository.EmpRepository;
//import axela.portal.repository.PortalFilterImpl;
//import axela.service.model.AxelaServiceJcCat;
//import axela.service.model.AxelaServiceJcCheck;
//
//@Service
//public class JobCardCheckList extends Connect {
//	private final static int PAGESIZE = 25;
//	public String checkId = "0";
//	public String checkItemId = "0";
//	public String checkName = "";
//	public String checkType = "";
//	public String checkEntryId = "0";
//	public String checkEntryDate = "";
//	public String checkModifiedId = "0";
//	public String checkModifiedDate = "";
//
//	public String requestType = "";
//	JSONObject inputObj = null;
//	public String msg = "";
//	public String pageNumber = "";
//	public int empId = 0;
//	public int compId = 0;
//	public String sortField = "";
//	public String sortDirection = "";
//	public int page = 0;
//	public String perPage = "0";
//	String branches = "";
//	public String strSearch = "";
//	public String branchAccess = "";
//	public String exeAccess = "";
//	public int length = 0;
//	public int totalCount = 0;
//	HashMap output = null;
//
//	// @Autowired
//	// private ServiceJcCheckRepository serviceJcCheckRepository;
//
//	@Autowired
//	EmpRepository empRepository;
//
//	@Autowired
//	PortalFilterImpl portalFilterImpl;
//
//	public Map<String, String> jcCategoryService(String input, HttpSession session, HttpServletResponse response) throws JSONException {
//		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
//		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
//		inputObj = new JSONObject(input);
//		output = new HashMap<String, String>();
//
//		if (!inputObj.isNull("requestType")) {
//			requestType = inputObj.getString("requestType");
//		}
//
//		switch (requestType) {
//
//			case "add" : // add an soe.
//				getValues(inputObj);
//				addFields(response);
//				break;
//
//			case "update" :// update an customer.
//				getValues(inputObj);
//				addFields(response);
//				break;
//
//			case "delete" :// delete an customer.
//				if (!inputObj.isNull("checkId")) {
//					checkId = inputObj.getString("checkId");
//				}
//				if (!checkId.equals("0")) {
//					deleteFields(checkId);
//				}
//				break;
//		}
//		return output;
//	}
//
//	public void getValues(JSONObject inputObj) throws JSONException {
//		msg = "";
//		if (!inputObj.isNull("checkId")) {
//			checkId = inputObj.getString("checkId");
//		}
//		if (!inputObj.isNull("checkEntryDate")) {
//			checkEntryDate = inputObj.getString("checkEntryDate");
//		}
//		if (!inputObj.isNull("checkEntryId")) {
//			checkEntryId = inputObj.getString("checkEntryId");
//		}
//		if (!inputObj.isNull("checkModifiedDate")) {
//			checkModifiedDate = inputObj.getString("checkModifiedDate");
//		}
//		if (!inputObj.isNull("checkModifiedId")) {
//			checkModifiedId = inputObj.getString("checkModifiedId");
//		}
//		if (!inputObj.isNull("checkName")) {
//			checkName = inputObj.getString("checkName");
//		}
//		if (!inputObj.isNull("checkItemId")) {
//			checkItemId = inputObj.getString("checkItemId");
//		}
//		if (!inputObj.isNull("checkType")) {
//			checkType = inputObj.getString("checkType");
//		}
//	}
//
//	public void checkForm() {
//		if (checkName.equals("")) {
//			msg = "<br>Enter Job Card Ckeck Name!";
//		}
//		// else {
//		// List<AxelaServiceJcCat> obj = jccategoryrepository.findByCategory(jccatName);
//		// if (!obj.isEmpty()) {
//		// msg += "<br>Similar Item Group found!";
//		// }
//		// }
//	}
//
//	public void addFields(HttpServletResponse response) {
//
//		checkForm();
//		output = new HashMap();
//		if (msg.equals("")) {
//			AxelaServiceJcCheck axelaServiceJcCheck = null;
//			if (!checkId.equals("0")) {
//				// axelaServiceJcCheck = serviceJcCheckRepository.findOne(Integer.parseInt(checkId));
//			} else {
//				axelaServiceJcCheck = new AxelaServiceJcCheck();
//			}
//			axelaServiceJcCheck.setCheckId(Integer.parseInt(checkId));
//			axelaServiceJcCheck.setCheckName(checkName);
//			axelaServiceJcCheck.setCheckType(checkType);
//			axelaServiceJcCheck.setCheckItemId(Integer.parseInt(checkItemId));
//			if (checkId.equals("0") && requestType.equals("add")) {
//				axelaServiceJcCheck.setCheckEntryId(empId);
//				axelaServiceJcCheck.setCheckEntryDate(toLongDate(kknow()));
//				axelaServiceJcCheck.setCheckModifiedDate("");
//				axelaServiceJcCheck.setCheckModifiedId(0);
//			} else if (!checkId.equals("0") && requestType.equals("update")) {
//				axelaServiceJcCheck.setCheckModifiedId(empId);
//				axelaServiceJcCheck.setCheckModifiedDate(toLongDate(kknow()));
//			}
//
//			// String checkId = serviceJcCheckRepository.save(axelaServiceJcCheck).getCheckId() + "";
//			if (!checkId.equals("0") && requestType.equals("add")) { // if id = 0 -> add mode else update mode
//				output.put("checkId", checkId);
//				output.put("successmsg", "Check Added Successfully!");
//			} else if (!checkId.equals("0") && requestType.equals("update")) {
//				output.put("checkId", checkId);
//				output.put("successmsg", "Check Updated Successfully!");
//			}
//		} else {
//			response.setStatus(400); // Bad request since missing mandatory fields from client.
//			output.put("errormsg", msg);
//		}
//	}
//
//	public void deleteFields(String checkId) {
//		// serviceJcCheckRepository.delete(Integer.parseInt(checkId));
//		output.put("succesmsg", "Check Deleted Successfully!");
//	}
//
//	public Map populateData(String input) throws JSONException {
//		output = new HashMap();
//		inputObj = new JSONObject(input);
//		if (!inputObj.isNull("checkId")) {
//			checkId = PadQuotes(CNumeric(inputObj.getString("checkId")));
//		}
//		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
//		// if (!checkId.equals("0")) {
//		// AxelaServiceJcCheck axelaServiceJcCheck = serviceJcCheckRepository.findOne(Integer.parseInt(checkId));
//		// HashMap map = new HashMap();
//		// map.put("checkId", axelaServiceJcCheck.getCheckId());
//		// map.put("jccatName", axelaServiceJcCheck.getCheckItemId());
//		// map.put("jccatName", axelaServiceJcCheck.getCheckName());
//		// map.put("jccatName", axelaServiceJcCheck.getCheckType());
//		// if (axelaServiceJcCheck.getCheckEntryId() != 0) {
//		// map.put("entryDate", strToShortDate(String.valueOf(axelaServiceJcCheck.getCheckEntryDate())));
//		// map.put("entryBy", empRepository.findEmpName(axelaServiceJcCheck.getCheckEntryId()));
//		// }
//		// if (axelaServiceJcCheck.getCheckModifiedId() != 0) {
//		// map.put("modifiedDate", strToShortDate(String.valueOf(axelaServiceJcCheck.getCheckModifiedDate())));
//		// map.put("modifiedBy", empRepository.findEmpName(axelaServiceJcCheck.getCheckModifiedId()));
//		// }
//		// list.add(map);
//		// }
//		output.put("populateData", list);
//		return output;
//	}
//
//	// public String checkId = "0";
//	// public String checkItemId = "0";
//	// public String checkName = "";
//	// public String checkType = "";
//	// public String checkEntryId = "0";
//	// public String checkEntryDate = "";
//	// public String checkModifiedId = "0";
//	// public String checkModifiedDate = "";
//	// serviceJcCheckRepository
//	// AxelaServiceJcCheck
//	public Map listData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
//		page = 0;
//		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
//		if (empId != 0) {
//			inputObj = new JSONObject(input);
//			output = new LinkedHashMap<String, String>();
//			List<AxelaServiceJcCat> categoryList = null;
//			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
//			List<HashMap> listBody = new ArrayList<HashMap>();
//			List<HashMap> listAction = new ArrayList<HashMap>();
//			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
//			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
//			PageRequest request = null;
//			if (!inputObj.isNull("requestType")) {
//				requestType = inputObj.getString("requestType");
//			}
//			if (!inputObj.isNull("sortField")) {
//				sortField = PadQuotes((inputObj.getString("sortField")));
//			}
//			if (!inputObj.isNull("pageIndex")) {
//				page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
//			}
//			if (!inputObj.isNull("sortDirection")) {
//				sortDirection = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
//			}
//			// perPage = CNumeric(getSession("emp_recperpage", session));
//			if (perPage.equals("0")) {
//				perPage = "25";
//			}
//			if (sortDirection.equals("")) {
//				sortDirection = "DESC";
//			}
//			if (sortField.equals("")) {
//				sortField = "checkId";
//			}
//			page++;
//			if (requestType.equals("filter")) {
//				strSearch = buildSmartSearch(input);
//			}
//			strSearch += branchAccess + exeAccess;
//			String strOrderBy = " ORDER BY jccat." + sortField + " " + sortDirection;
//			categoryList = portalFilterImpl.findAllJcCategory(strSearch, strOrderBy, page, Integer.parseInt(perPage));
//			totalCount = Integer.parseInt(PortalFilterImpl.totalCount);
//			Map<String, String> mapNavi = pageNavi(totalCount, input, perPage);
//			int count = 0;
//			// Start Header Data
//			// listHeader.add(produceHeaderData("#", "Sl.no", "center"));
//			listHeader.add(produceHeaderData("Job Card Category Details", "jccatName", "center"));
//			// End Header Data
//
//			// Start Body Align
//			// listBodyAlign.add(produceBodyAlign("center"));
//			listBodyAlign.add(produceBodyAlign("center"));
//			// End Body Align
//
//			// public String checkId = "0";
//			// public String checkEntryDate = "";
//			// public String checkEntryId = "0";
//			// public String checkModifiedDate = "";
//			// public String jccatModifiedId = "0";
//			// public String jccatName = "";
//			// AxelaServiceJcCat
//			// jccategoryrepository
//			StringBuilder dataString = null;
//			for (AxelaServiceJcCat obj : categoryList) {
//				ArrayList<String> param = new ArrayList<String>();
//				ArrayList type = new ArrayList();
//				ArrayList value = new ArrayList();
//				ArrayList<String> actionParam = new ArrayList<String>();
//				ArrayList<ArrayList> paramArr = new ArrayList<ArrayList>();
//				HashMap<String, List<HashMap>> mapData = new HashMap<String, List<HashMap>>();
//				HashMap<String, List<HashMap>> mapAction = new HashMap<String, List<HashMap>>();
//				HashMap<String, List<String>> mapBodyData = new HashMap<String, List<String>>();
//				List<HashMap> listData = new ArrayList<HashMap>();
//				count++;
//
//				type.add(false);
//				value.add(count);
//				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
//				type.clear();
//				value.clear();
//
//				type.add(false);
//				value.add(obj.getJccatName());
//				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
//				type.clear();
//				value.clear();
//
//				mapData.put("td", listData);
//				actionParam.add("updateJobCardCategory");
//				actionParam.add(obj.getJccatId() + "");
//				mapAction.put("td", produceActionData(actionParam));
//
//				listAction.add(mapAction);
//				listBody.add(mapData);
//			}
//			output.put("meta", mapNavi);
//			output.put("thead", listHeader);
//			output.put("tdalign", listBodyAlign);
//			output.put("tbody", listBody);
//			output.put("action", listAction);
//			if (AppRun().equals("0")) {
//				SOP("output==========Service==========" + output.toString());
//			}
//		}
//		return output;
//	}
//	private ArrayList<HashMap> produceActionData(ArrayList<String> actionParam) {
//		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
//		HashMap mapBodyData = new HashMap();
//		mapBodyData.put("value", "Update Job Card Category");
//		mapBodyData.put("param", actionParam);
//		listAction.add((HashMap) mapBodyData.clone());
//		return listAction;
//	}
//
//	public Map populateDrSmart() {
//		ArrayList<HashMap> list = new ArrayList<HashMap>();
//		output = new LinkedHashMap();
//		list.add(buildSmartArr("Keyword", "text", "jccat.*"));
//		list.add(buildSmartArr("Category ID", "numeric", "jccat.titleId"));
//		list.add(buildSmartArr("Category Name", "text", "jccat.titleName"));
//		// list.add(buildSmartArr("Entry By", "text", "jccat.titleEntryId)"));
//		list.add(buildSmartArr("Entry Date", "date", "jccat.titleEntryDate"));
//		// list.add(buildSmartArr("Modified By", "text", "jccat.titleModifiedId"));
//		list.add(buildSmartArr("Modified Date", "date", "jccat.titleModifiedDate"));
//		output.put("drSmart", list.toArray());
//		return output;
//	}
//
// }
