package axela.helpdesk.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import axela.helpdesk.model.AxelaHelpDeskTicketFaq;
import axela.helpdesk.repository.FaqFilterImpl;
import axela.helpdesk.repository.FaqRepository;
import axela.portal.repository.EmpRepository;
@Service
public class FaqService extends Connect {

	@Autowired
	FaqFilterImpl faqFilterImpl;
	@Autowired
	FaqRepository faqRepository;
	@Autowired
	EmpRepository empRepository;

	public String ticketfaqId = "0";
	public String ticketfaqActive = "0";
	public String ticketfaqAnswer = "";
	public String ticketfaqEntryDate = "";
	public String ticketfaqEntryId = "0";
	public String ticketfaqFaqserviceId = "0";
	public String ticketfaqModifiedDate = "";
	public String ticketfaqModifiedId = "0";
	public String ticketfaqQuestion = "";
	public String faqserviceTicketqueueId = "0";
	public String requestType = "";
	public String StrSql = "";
	public int empId = 0;
	public int compId = 0;
	public String empFormatdate = "";
	public String empFormattime = "";
	public int branchId = 0;
	public String branchName = "";
	public String msg = "";
	public int page = 0;
	public String perpage = "0";
	public String sort = "";
	public String field = "";
	public String pageNumber = "";
	public String branchAccess = "";
	public String perPage = "0";
	public String strSearch = "";
	public String strOrderBy = "";
	public String orderType = "";
	public String orderByField = "";
	public String faqserviceName = "";
	public String ticketqueueName = "";
	public String exeAccess = "";
	public String starttime = "";
	public String endtime = "";
	HashMap output = null;
	JSONObject inputObj = null;
	private String startTime = "";
	private String endTime = "";
	private String drBranchId = "";

	public Map faqService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if (empId != 0) {
			inputObj = new JSONObject(input);
			output = new HashMap();
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			switch (requestType) {

				case "add" : // add an Faq.
					if (!returnPerm("emp_helpdesk_faq_add", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					ticketfaqId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;

				case "update" :// update an Faq.
					ticketfaqId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;

				case "delete" :// delete an customer.
					if (!returnPerm("emp_helpdesk_faq_delete", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					if (!inputObj.isNull("ticketfaqId")) {
						ticketfaqId = inputObj.getString("ticketfaqId");
					}
					if (!ticketfaqId.equals("0")) {
						deleteFields(ticketfaqId);
					}
					break;

				case "landing" :// delete an customer.
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
					if (startTime.equals("")) {
						startTime = ReportStartdate(date, empFormatdate);
					}
					if (endTime.equals("")) {
						endTime = formatDate(date, empFormatdate);
					}

					if (branchId != 0) {
						if (!inputObj.isNull("drBranchId")) {
							drBranchId = PadQuotes(inputObj.getString("drBranchId"));
						}
						if (drBranchId.equals("")) {
							drBranchId = "0";
						}
					} else {
						drBranchId = String.valueOf(branchId);
					}
					populateLandingDetails(input, session, response);
					break;
			}
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("ticketfaqId")) {
			ticketfaqId = CNumeric(PadQuotes(inputObj.getString("ticketfaqId")));
		}
		if (!inputObj.isNull("ticketfaqActive")) {
			ticketfaqActive = PadQuotes(inputObj.getString("ticketfaqActive"));
		}
		if (!inputObj.isNull("ticketfaqAnswer")) {
			ticketfaqAnswer = PadQuotes(inputObj.getString("ticketfaqAnswer"));
		}
		if (!inputObj.isNull("ticketfaqFaqserviceId")) {
			ticketfaqFaqserviceId = CNumeric(PadQuotes(inputObj.getString("ticketfaqFaqserviceId")));
		}
		if (!inputObj.isNull("ticketfaqQuestion")) {
			ticketfaqQuestion = PadQuotes(inputObj.getString("ticketfaqQuestion"));
		}
		if (!inputObj.isNull("ticketfaqEntryId")) {
			ticketfaqEntryId = PadQuotes(inputObj.getString("ticketfaqEntryId"));
		}
		if (!inputObj.isNull("ticketfaqEntryDate")) {
			ticketfaqEntryDate = PadQuotes(inputObj.getString("ticketfaqEntryDate"));
		}
		if (!inputObj.isNull("ticketfaqModifiedId")) {
			ticketfaqModifiedId = PadQuotes(inputObj.getString("ticketfaqModifiedId"));
		}
		if (!inputObj.isNull("ticketfaqModifiedDate")) {
			ticketfaqModifiedDate = PadQuotes(inputObj.getString("ticketfaqModifiedDate"));
		}
		if (!inputObj.isNull("faqserviceTicketqueueId")) {
			faqserviceTicketqueueId = CNumeric(PadQuotes(inputObj.getString("faqserviceTicketqueueId")));
		}
		if (!inputObj.isNull("faqserviceName")) {
			faqserviceName = PadQuotes(inputObj.getString("faqserviceName"));
		}
		if (!inputObj.isNull("ticketqueueName")) {
			ticketqueueName = PadQuotes(inputObj.getString("ticketqueueName"));
		}
	}

	public void validateFields() {
		msg = "";
		int result = 0;

		if (faqserviceTicketqueueId.equals("0")) {
			msg += "Select Queue!<br>";
		}
		if (ticketfaqFaqserviceId.equals("0")) {
			msg += "Select Category!<br>";
		}
		if (ticketfaqQuestion.equals("")) {
			msg += "Enter Question!<br>";
		}
		if (!ticketfaqQuestion.equals("") && !ticketfaqFaqserviceId.equals("0")) {
			if (requestType.equals("add")) {
				result = Integer.parseInt(CNumeric(PadQuotes(String.valueOf((faqRepository.findByTicketQuetion(ticketfaqQuestion))))));
			}
			if (requestType.equals("update")) {
				result = Integer.parseInt(CNumeric(PadQuotes(String.valueOf(faqRepository.findByTicketId(ticketfaqQuestion, Integer.parseInt(ticketfaqId))))));
			}
			if (result != 0) {
				msg += "Similar Question found!<br>";
			}
		}
		if (ticketfaqAnswer.equals("")) {
			msg = msg + "Enter Answer!<br>";
		}
	}

	public void addFields(HttpServletResponse response, HttpSession session) throws ParseException {
		validateFields();
		output = new HashMap();
		AxelaHelpDeskTicketFaq axelaHelpDeskticketfaq = null;
		if (msg.equals("")) {
			if (!ticketfaqId.equals("0")) {
				axelaHelpDeskticketfaq = faqRepository.findOne(Integer.parseInt(ticketfaqId));
			} else {
				axelaHelpDeskticketfaq = new AxelaHelpDeskTicketFaq();
			}
			axelaHelpDeskticketfaq.setTicketfaqId(Integer.parseInt(ticketfaqId));
			axelaHelpDeskticketfaq.setTicketfaqActive(ticketfaqActive);
			axelaHelpDeskticketfaq.setTicketfaqAnswer(ticketfaqAnswer);
			axelaHelpDeskticketfaq.setTicketfaqFaqserviceId(Integer.parseInt(ticketfaqFaqserviceId));
			axelaHelpDeskticketfaq.setFaqserviceTicketqueueId(Integer.parseInt(faqserviceTicketqueueId));
			axelaHelpDeskticketfaq.setTicketfaqQuestion(ticketfaqQuestion);
			axelaHelpDeskticketfaq.setTicketqueueName(ticketqueueName);
			axelaHelpDeskticketfaq.setFaqserviceName(faqserviceName);
			if (ticketfaqId.equals("0") && requestType.equals("add")) {
				axelaHelpDeskticketfaq.setTicketfaqEntryDate(getTimeByZone(session));
				axelaHelpDeskticketfaq.setTicketfaqEntryId(empId);
				axelaHelpDeskticketfaq.setTicketfaqModifiedId(0);
			} else {
				axelaHelpDeskticketfaq.setTicketfaqEntryDate(axelaHelpDeskticketfaq.getTicketfaqEntryDate());
				axelaHelpDeskticketfaq.setTicketfaqEntryId(axelaHelpDeskticketfaq.getTicketfaqEntryId());
				axelaHelpDeskticketfaq.setTicketfaqModifiedId(empId);
				axelaHelpDeskticketfaq.setTicketfaqModifiedDate(getTimeByZone(session));
			}
			AxelaHelpDeskTicketFaq result = null;
			result = faqRepository.save(axelaHelpDeskticketfaq);
			if (result != null && requestType.equals("add")) {
				output.put("successmsg", "FAQ Added Successfully!");
				output.put("ticketfaqId", result.getTicketfaqId() + "");
			} else if (result != null && requestType.equals("update")) {
				output.put("successmsg", "FAQ Updated Successfully!");
				output.put("ticketfaqId", result.getTicketfaqId() + "");
			}
		} else {
			response.setStatus(400);
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String ticketfaqId) {
		faqRepository.delete(Integer.parseInt(ticketfaqId));
		output.put("successmsg", "FAQ Deleted Successfully!");
	}

	public Map<String, String> populateLandingDetails(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap();
		String strSearch = "";
		long grandTotal = 0L;
		branchAccess = getSession("branchAccess", session).replaceAll("branchId", "ticket.axelaCustomers.customerBranchId");
		exeAccess = getSession("exeAccess", session).replaceAll("empId", "ticket.axelaEmp.EmpId");
		if (!starttime.equals("")) {
			strSearch = " and substr(faq.ticketfaqEntryDate,1,8) >= substr('" + starttime + "',1,8) ";
		}
		if (!endtime.equals("")) {
			strSearch = strSearch + " and substr(faq.ticketfaqEntryDate,1,8) <= substr('" + endtime + "',1,8) ";
		}
		if (!msg.equals("")) {
			msg = "<br>Error!" + msg;
		}
		strSearch += branchAccess + "" + exeAccess + "";
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<AxelaHelpDeskTicketFaq> contract = faqFilterImpl.findFaqSummary(strSearch, session);
		for (AxelaHelpDeskTicketFaq results : contract) {
			LinkedHashMap map = new LinkedHashMap<String, String>();
			map.put("Total", results.getTotal());
			map.put("Active", results.getActive());
			map.put("Inactive", results.getInactive());
			list.add(map);
		}
		output.put("populateLandingDetails", list);
		return output;
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		compId = Integer.parseInt(CNumeric(PadQuotes(getSession("compId", session))));
		perPage = getSession("perPage", session);
		perPage = CNumeric(getSession("empRecperpage", session));
		String strSearch = "";
		String strOrderBy = "";
		requestType = "";
		page = 0;
		if (empId != 0) {
			if (!returnPerm("emp_helpdesk_faq_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			inputObj = new JSONObject(input);
			output = new LinkedHashMap<String, String>();
			List<AxelaHelpDeskTicketFaq> serviceTicketFaq = null;
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
				orderByField = "ticketfaqId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strSearch += branchAccess;
			strOrderBy = " ORDER BY ticketFaq." + orderByField + " " + orderType + "";
			serviceTicketFaq = faqFilterImpl.findFaqDetails(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			String length = faqFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("FAQ Detail", "ticketfaqQuestion", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaHelpDeskTicketFaq obj : serviceTicketFaq) {
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
				// faqDetails
				if (!obj.getTicketfaqQuestion().equals("")) {
					type.add(true);
					value.add(String.valueOf(obj.getTicketfaqQuestion()));
					paramSubArr.add("faqDetails");
					paramSubArr.add(("<a href ='javascript:ToggleDisplay(" + count + ");'>:"));
					paramArr.add((ArrayList) paramSubArr.clone());
					paramSubArr.clear();
					type.add(false);
					value.add("[" + String.valueOf(obj.getFaqserviceName()) + "] [" + String.valueOf(obj.getTicketqueueName()) + "]");
					paramArr.add((ArrayList) paramSubArr.clone());
					listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					paramArr.clear();
				}
				// End Body data
				mapData.put("td", listData);
				ArrayList actionParam = new ArrayList();
				ArrayList actionParam1 = new ArrayList();
				actionParam.add("Update FAQ");
				actionParam.add(PadQuotes(String.valueOf(obj.getTicketfaqId())));
				actionParam1.add("listDocuments");
				actionParam1.add(PadQuotes(String.valueOf(obj.getTicketfaqId())));
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
				SOP("output==========FAQService==========" + output.toString());
			}
		}
		return output;
	}

	private ArrayList<HashMap> produceActionData(ArrayList<String> Param, ArrayList<String> Param1) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update FAQ");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "List Documents");
		mapBodyData.put("param", Param1);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateData(String input, HttpSession session, HttpServletResponse respose) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap();
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (!returnPerm("emp_helpdesk_faq_access", session)) {
			output.put("errorPage", "Access denied. Please contact system administrator!");
			return output;
		}
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		if (AppRun().equals("0")) {
			SOP("inputObj=====populateData======" + inputObj.toString(2));
		}
		if (!inputObj.isNull("ticketfaqId")) {
			ticketfaqId = PadQuotes(CNumeric(inputObj.getString("ticketfaqId")));
		}
		if (!ticketfaqId.equals("0")) {
			String strSearch = "AND ticketFaq.ticketfaqId= " + ticketfaqId;
			List<AxelaHelpDeskTicketFaq> obj = faqFilterImpl.findAllpopulate(strSearch);
			for (AxelaHelpDeskTicketFaq ticketFaq : obj) {
				map.put("ticketfaqId", "" + ticketFaq.getTicketfaqId());
				map.put("ticketfaqActive", ticketFaq.getTicketfaqActive());
				map.put("ticketfaqAnswer", String.valueOf(ticketFaq.getTicketfaqAnswer()));
				map.put("ticketfaqFaqserviceId", String.valueOf(ticketFaq.getTicketfaqFaqserviceId()));
				map.put("ticketfaqQuestion", String.valueOf(ticketFaq.getTicketfaqQuestion()));
				map.put("faqserviceTicketqueueId", String.valueOf(ticketFaq.getFaqserviceTicketqueueId()));
				map.put("faqserviceName", String.valueOf(ticketFaq.getFaqserviceName()));
				map.put("ticketqueueName", String.valueOf(ticketFaq.getTicketqueueName()));
				if (ticketFaq.getTicketfaqEntryId() != 0) {
					map.put("ticketfaqEntryDate", strToShortDate(ticketFaq.getTicketfaqEntryDate()));
					map.put("ticketfaqEntryId", String.valueOf(ticketFaq.getTicketfaqEntryId()));
					map.put("ticketfaqEntryBy", empRepository.findEmpName(ticketFaq.getTicketfaqEntryId()));
				}
				if (ticketFaq.getTicketfaqModifiedId() != 0) {
					map.put("ticketfaqModifiedDate", strToShortDate(ticketFaq.getTicketfaqModifiedDate()));
					map.put("ticketfaqModifiedId", String.valueOf(ticketFaq.getTicketfaqModifiedId() + ""));
					map.put("ticketfaqModifiedBy", empRepository.findEmpName(ticketFaq.getTicketfaqModifiedId()));
				}
				list.add(map);
			}
			output.put("populateData", list);
		}
		if (AppRun().equals("0")) {
			SOP("output===========" + output);
		}
		return output;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "ticketFaq.*"));
		list.add(buildSmartArr("FAQ ID", "numeric", "ticketFaq.ticketfaqId"));
		list.add(buildSmartArr("Category ", "text", "faqService.faqserviceName"));
		list.add(buildSmartArr("FAQ Question", "text", "ticketFaq.ticketfaqQuestion"));
		list.add(buildSmartArr("FAQ Answer", "text", "ticketFaq.ticketfaqAnswer"));
		list.add(buildSmartArr("Active", "boolean", "ticketFaq.ticketfaqActive"));
		// list.add(buildSmartArr("Entry By", "text", "ticketFaq.TicketfaqEntryId"));
		list.add(buildSmartArr("Entry Date", "Date", "ticketFaq.ticketfaqEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "ticketFaq.ticketfaqModifiedId"));
		list.add(buildSmartArr("Modified Date", "Date", "ticketFaq.ticketfaqModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

}
