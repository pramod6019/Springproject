package axela.helpdesk.service;

import java.text.DecimalFormat;
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
import axela.helpdesk.model.AxelaHelpDeskTicketQueue;
import axela.helpdesk.repository.AxelaTicketQueueRepository;
import axela.helpdesk.repository.TicketQueueFilterImpl;
import axela.helpdesk.repository.TicketRepository;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.PortalFilterImpl;
@Service
public class TicketQueueService extends Connect {

	@Autowired
	private AxelaTicketQueueRepository axelaticketqueuerepository;

	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	PortalFilterImpl portalFilterImpl;

	@Autowired
	TicketQueueFilterImpl ticketQueueFilterImpl;

	@Autowired
	EmpRepository empRepository;

	private final static int PAGESIZE = 25;
	public String ticketqueueId = "0";
	public String ticketqueueName = "";
	public String ticketqueueDesc = "";
	public String ticketqueueDuehrs = "";
	public String ticketqueueRank = "";
	public String ticketqueueBusinessHrs = "";
	public String ticketqueueTrigger1Hrs = "";
	public String ticketqueueTrigger2Hrs = "";
	public String ticketqueueTrigger3Hrs = "";
	public String ticketqueueTrigger4Hrs = "";
	public String ticketqueueTrigger5Hrs = "";
	public String startTime = "00:00";
	public String endTime = "00:00";
	public String starttime = "0.0";
	public String endtime = "0.0";
	public String start = "";
	public String end = "";
	public String perPage = "0";
	public String ticketqueueSun = "0";
	public String ticketqueueMon = "0";
	public String ticketqueueTue = "0";
	public String ticketqueueWed = "0";
	public String ticketqueueThu = "0";
	public String ticketqueueFri = "0";
	public String ticketqueueSat = "0";
	public String ticketqueueEntryId = "0";
	public String ticketqueueEntryDate = "";
	public String ticketqueueModifiedId = "0";
	public String ticketqueueModifiedDate = "";
	public String entryBy = "";
	public String entryDate = "";
	public String modifiedBy = "";
	public String modifiedDate = "";
	public String ticketqueueStarttime = "";
	public String ticketqueueEndtime = "";
	public String QueryString = "";
	public int count = 0;
	public String empFormatdate = "";
	public String empFormattime = "";
	public DecimalFormat deci = new DecimalFormat("0.00");
	public String requestType = "";
	public String orderType = "";
	public String msg = "";
	public String pageNumber = "";
	public String empId = "0";
	public String compId = "0";
	public String formattimeTimepicker = "";
	public String strSql = "";
	public String orderByField = "";
	public int page = 0;
	HashMap output = null;
	JSONObject inputObj = null;

	public Map ticketQueueService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("inputObj========ticketQueueService==========" + inputObj.toString(1));
		}
		output = new HashMap<String, String>();
		empId = CNumeric(PadQuotes(getSession("empId", session)));
		compId = CNumeric(getSession("compId", session));
		empFormatdate = getSession("formatdateName", session);
		empFormattime = getSession("formattimeName", session);
		SOP("empFormattime===" + empFormattime);
		formattimeTimepicker = getSession("formattimeTimepicker", session);
		if (!empId.equals("0")) {
			if (!returnPerm("comp_id,emp_role_id", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			if (!inputObj.isNull("requestType")) {
				requestType = inputObj.getString("requestType");
			}
			switch (requestType) {
				case "add" : // add a TicketQueue.
					getValues(inputObj);
					SOP("=============");
					addFields(response, session);
					break;
				case "update" : // update a TicketQueue.
					getValues(inputObj);
					addFields(response, session);
					break;
				case "delete" :// delete a TicketQueue.
					if (!inputObj.isNull("ticketqueueId")) {
						ticketqueueId = inputObj.getString("ticketqueueId");
					}
					if (!ticketqueueId.equals("0")) {
						deleteFields(ticketqueueId);
					}
					break;
				case "moveup" :// cheking for move up
					if (!inputObj.isNull("activitytypeId")) {
						ticketqueueId = inputObj.getString("activitytypeId");
					}
					if (!ticketqueueId.equals("0")) {
						moveUp(ticketqueueId);
					}
					break;

				case "movedown" :// cheking for move down
					if (!inputObj.isNull("activitytypeId")) {
						ticketqueueId = inputObj.getString("activitytypeId");
					}
					if (!ticketqueueId.equals("0")) {
						moveDown(ticketqueueId);
					}
					break;
			}
		}
		if (AppRun().equals("0")) {
			SOP("output========ticketQueueService==========" + output);
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("ticketqueueId")) {
			ticketqueueId = CNumeric(inputObj.getString("ticketqueueId"));
		}

		if (!inputObj.isNull("ticketqueueName")) {
			ticketqueueName = PadQuotes(inputObj.getString("ticketqueueName"));
		}
		if (!inputObj.isNull("ticketqueueDesc")) {
			ticketqueueDesc = PadQuotes(inputObj.getString("ticketqueueDesc"));
		}
		if (!inputObj.isNull("ticketqueueRank")) {
			ticketqueueRank = CNumeric(inputObj.getString("ticketqueueRank"));
		}
		if (!inputObj.isNull("ticketqueueDuehrs")) {
			ticketqueueDuehrs = PadQuotes(inputObj.getString("ticketqueueDuehrs"));
		}
		if (!inputObj.isNull("ticketqueueTrigger1Hrs")) {
			ticketqueueTrigger1Hrs = PadQuotes(inputObj.getString("ticketqueueTrigger1Hrs"));
		}
		if (!inputObj.isNull("ticketqueueTrigger2Hrs")) {
			ticketqueueTrigger2Hrs = PadQuotes(inputObj.getString("ticketqueueTrigger2Hrs"));
		}
		if (!inputObj.isNull("ticketqueueTrigger3Hrs")) {
			ticketqueueTrigger3Hrs = PadQuotes(inputObj.getString("ticketqueueTrigger3Hrs"));
		}
		if (!inputObj.isNull("ticketqueueTrigger4Hrs")) {
			ticketqueueTrigger4Hrs = PadQuotes(inputObj.getString("ticketqueueTrigger4Hrs"));
		}
		if (!inputObj.isNull("ticketqueueTrigger5Hrs")) {
			ticketqueueTrigger5Hrs = PadQuotes(inputObj.getString("ticketqueueTrigger5Hrs"));
		}
		if (ticketqueueTrigger1Hrs.equals("")) {
			SOP("========ticketqueueTrigger1Hrs========");
			ticketqueueTrigger1Hrs = "0:00";
		}
		if (ticketqueueTrigger2Hrs.equals("")) {
			ticketqueueTrigger2Hrs = "0:00";
		}
		if (ticketqueueTrigger3Hrs.equals("")) {
			ticketqueueTrigger3Hrs = "0:00";
		}
		if (ticketqueueTrigger4Hrs.equals("")) {
			ticketqueueTrigger4Hrs = "0:00";
		}
		if (ticketqueueTrigger5Hrs.equals("")) {
			ticketqueueTrigger5Hrs = "0:00";
		}
		if (!inputObj.isNull("ticketqueueBusinessHrs")) {
			ticketqueueBusinessHrs = PadQuotes(inputObj.getString("ticketqueueBusinessHrs"));
		}
		if (ticketqueueBusinessHrs.equals("1")) {
			if (!inputObj.isNull("ticketqueueStarttime")) {
				startTime = PadQuotes(inputObj.getString("ticketqueueStarttime"));
			}
			if (!inputObj.isNull("ticketqueueEndtime")) {
				endTime = PadQuotes(inputObj.getString("ticketqueueEndtime"));
			}
			if (!inputObj.isNull("ticketqueueSun")) {
				ticketqueueSun = PadQuotes(inputObj.getString("ticketqueueSun"));
			}
			if (!inputObj.isNull("ticketqueueMon")) {
				ticketqueueMon = PadQuotes(inputObj.getString("ticketqueueMon"));
			}

			if (!inputObj.isNull("ticketqueueTue")) {
				ticketqueueTue = PadQuotes(inputObj.getString("ticketqueueTue"));
			}

			if (!inputObj.isNull("ticketqueueWed")) {
				ticketqueueWed = PadQuotes(inputObj.getString("ticketqueueWed"));
			}
			if (!inputObj.isNull("ticketqueueThu")) {
				ticketqueueThu = PadQuotes(inputObj.getString("ticketqueueThu"));
			}
			if (!inputObj.isNull("ticketqueueFri")) {
				ticketqueueFri = PadQuotes(inputObj.getString("ticketqueueFri"));
			}
			if (!inputObj.isNull("ticketqueueSat")) {
				ticketqueueSat = PadQuotes(inputObj.getString("ticketqueueSat"));
			}
		} else {
			starttime = "00.00";
			endtime = "00.00";
			ticketqueueSun = "0";
			ticketqueueMon = "0";
			ticketqueueTue = "0";
			ticketqueueWed = "0";
			ticketqueueThu = "0";
			ticketqueueFri = "0";
			ticketqueueSat = "0";
		}

		if (!inputObj.isNull("ticketqueueEntryId")) {
			ticketqueueEntryId = CNumeric(inputObj.getString("ticketqueueEntryId"));
		}
		if (!inputObj.isNull("ticketqueueEntryDate")) {
			ticketqueueEntryDate = PadQuotes(inputObj.getString("ticketqueueEntryDate"));
		}
		if (!inputObj.isNull("ticketqueueModifiedId")) {
			ticketqueueModifiedId = CNumeric(inputObj.getString("ticketqueueModifiedId"));
		}
		if (!inputObj.isNull("ticketqueueModifiedDate")) {
			ticketqueueModifiedDate = PadQuotes(inputObj.getString("ticketqueueModifiedDate"));
		}
	}

	public void validateFields() throws ParseException {
		String ticketqueue = "";
		if (ticketqueueName.equals("")) {
			msg = "<br>Enter Queue Name!";
		} else {
			if (requestType.equals("add")) {
				ticketqueue = axelaticketqueuerepository.findByticketqueueName(ticketqueueName);
			} else if (requestType.equals("update")) {
				ticketqueue = axelaticketqueuerepository.findByNameAndId(Integer.parseInt(ticketqueueId), ticketqueueName);
			}
			if (!ticketqueue.equals("")) {
				msg += "<br>Similar Queue Name Found!";
			}
		}

		if (ticketqueueDesc.equals("")) {
			msg += "<br>Enter Description!";
		}

		if (ticketqueueDuehrs.equals("")) {
			msg = msg + "<br>Enter Due Hours!";
		} else {
			String hrs = null;
			ticketqueueDuehrs = deci.format(Double.parseDouble(ticketqueueDuehrs.replaceAll(":", "\\.")));
			if (ticketqueueDuehrs.equals("0:00")) {
				msg = msg + "<br>Due Hours should be greater than zero!";
			}
		}
		if (!ticketqueueTrigger5Hrs.equals("0:00")) {
			SOP("========11111111111========");
			if (Double.parseDouble(ticketqueueTrigger5Hrs.replaceAll(":", "\\.")) < Double.parseDouble(ticketqueueTrigger4Hrs.replaceAll(":", "\\."))
					|| Double.parseDouble(ticketqueueTrigger5Hrs.replaceAll(":", "\\.")) < Double.parseDouble(ticketqueueTrigger3Hrs.replaceAll(":", "\\."))
					|| Double.parseDouble(ticketqueueTrigger5Hrs.replaceAll(":", "\\.")) < Double.parseDouble(ticketqueueTrigger2Hrs.replaceAll(":", "\\."))
					|| Double.parseDouble(ticketqueueTrigger5Hrs.replaceAll(":", "\\.")) < Double.parseDouble(ticketqueueTrigger1Hrs.replaceAll(":", "\\."))) {
				msg += "<br> Level-5 hours should be more than previous Levels hours";
			}
		}
		if (!ticketqueueTrigger4Hrs.equals("0:00")) {
			SOP("========2222222222222222========");
			if (Double.parseDouble(ticketqueueTrigger4Hrs.replaceAll(":", "\\.")) < Double.parseDouble(ticketqueueTrigger3Hrs.replaceAll(":", "\\."))
					|| Double.parseDouble(ticketqueueTrigger4Hrs.replaceAll(":", "\\.")) < Double.parseDouble(ticketqueueTrigger2Hrs.replaceAll(":", "\\."))
					|| Double.parseDouble(ticketqueueTrigger4Hrs.replaceAll(":", "\\.")) < Double.parseDouble(ticketqueueTrigger1Hrs.replaceAll(":", "\\."))) {
				msg += "<br> Level-4 hours should be more than previous Levels hours";
			}
		}
		if (!ticketqueueTrigger3Hrs.equals("0:00")) {
			SOP("========333333333333333========");
			if (Double.parseDouble(ticketqueueTrigger3Hrs.replaceAll(":", "\\.")) < Double.parseDouble(ticketqueueTrigger2Hrs.replaceAll(":", "\\."))
					|| Double.parseDouble(ticketqueueTrigger3Hrs.replaceAll(":", "\\.")) < Double.parseDouble(ticketqueueTrigger1Hrs.replaceAll(":", "\\."))) {
				msg += "<br> Level-3 hours should be more than previous Levels hours";
			}
		}
		if (!ticketqueueTrigger2Hrs.equals("0:00")) {
			SOP("========44444444444444========");
			if (Double.parseDouble(ticketqueueTrigger2Hrs.replaceAll(":", "\\.")) < Double.parseDouble(ticketqueueTrigger1Hrs.replaceAll(":", "\\."))) {
				msg += "<br> Level-2 hours should be more than previous Level hours";
			}
		}
		if (ticketqueueBusinessHrs.equals("1")) {
			if (startTime.equals("")) {
				msg += "<br>Enter Start Time!";
			} else if (startTime.equals("00:00") || startTime.equals("0:00") || startTime.equals("0")) {
				msg += "<br>Start Time should be greater than Zero!";
			} else if (isNumeric(startTime)) {
				if (Integer.parseInt(startTime) == 0) {
					msg += "<br>Start Time should be greater than Zero!";
				}
			} else if (!startTime.equals("")) {
				SOP("empFormattime======" + empFormattime);
				startTime = formatDateStr(startTime, empFormattime);
				SOP("startTime======" + startTime);
				startTime = startTime.substring(12, 13) + "." + startTime.substring(15, 16);
				SOP("starttime======" + startTime);
			}

			if (endTime.equals("")) {
				msg += "<br>Enter End Time!";
			} else if (endTime.equals("00:00") || endTime.equals("0:00") || endTime.equals("0")) {
				msg += "<br>End Time should be greater than Zero!";
			} else if (isNumeric(endTime)) {
				if (Integer.parseInt(endTime) == 0) {
					msg += "<br>End Time should be greater than Zero!";
				}
			} else if (!endTime.equals("")) {
				SOP("empFormattime==111111====" + empFormattime);
				endTime = formatDateStr(endTime, empFormattime);
				SOP("endTime======" + endTime);
				endTime = endTime.substring(12, 13) + "." + endTime.substring(15, 16);
				SOP("endTime======" + endTime);
			}

			if (!startTime.equals("") && !endTime.equals("")) {
				if (Double.parseDouble(endTime) <= Double.parseDouble(startTime)) {
					msg = msg + "<br>End Time Should be greater than Start Time!";
				}
			}
		}
	}
	public void addFields(HttpServletResponse response, HttpSession session) throws ParseException {
		output = new HashMap();
		validateFields();
		AxelaHelpDeskTicketQueue axelaserviceticketqueue = null;
		ticketqueueTrigger1Hrs = ticketqueueTrigger1Hrs.replaceAll(":", "\\.");
		ticketqueueTrigger2Hrs = ticketqueueTrigger2Hrs.replaceAll(":", "\\.");
		ticketqueueTrigger3Hrs = ticketqueueTrigger3Hrs.replaceAll(":", "\\.");
		ticketqueueTrigger4Hrs = ticketqueueTrigger4Hrs.replaceAll(":", "\\.");
		ticketqueueTrigger5Hrs = ticketqueueTrigger5Hrs.replaceAll(":", "\\.");
		if (msg.equals("")) {
			if (!ticketqueueId.equals("0")) {
				axelaserviceticketqueue = axelaticketqueuerepository.findOne(Integer.parseInt(ticketqueueId));
			} else {
				axelaserviceticketqueue = new AxelaHelpDeskTicketQueue();
			}
			axelaserviceticketqueue.setTicketqueueId(Integer.parseInt(ticketqueueId));
			axelaserviceticketqueue.setTicketqueueName(ticketqueueName);
			axelaserviceticketqueue.setTicketqueueDesc(ticketqueueDesc);
			axelaserviceticketqueue.setTicketqueueDuehrs(Double.parseDouble(ticketqueueDuehrs));
			if (ticketqueueBusinessHrs.equals("1")) {
				axelaserviceticketqueue.setTicketqueueBusinessHrs(ticketqueueBusinessHrs);
				axelaserviceticketqueue.setTicketqueueEndtime(Double.parseDouble(endtime));
				axelaserviceticketqueue.setTicketqueueStarttime(Double.parseDouble(starttime));
				axelaserviceticketqueue.setTicketqueueSun(ticketqueueSun);
				axelaserviceticketqueue.setTicketqueueMon(ticketqueueMon);
				axelaserviceticketqueue.setTicketqueueTue(ticketqueueTue);
				axelaserviceticketqueue.setTicketqueueWed(ticketqueueWed);
				axelaserviceticketqueue.setTicketqueueThu(ticketqueueThu);
				axelaserviceticketqueue.setTicketqueueFri(ticketqueueFri);
				axelaserviceticketqueue.setTicketqueueSat(ticketqueueSat);
			}
			SOP("coming========");
			axelaserviceticketqueue.setTicketqueueTrigger1Hrs(Double.parseDouble(ticketqueueTrigger1Hrs));
			SOP("coming111111111111========");
			axelaserviceticketqueue.setTicketqueueTrigger2Hrs(Double.parseDouble(ticketqueueTrigger2Hrs));
			axelaserviceticketqueue.setTicketqueueTrigger3Hrs(Double.parseDouble(ticketqueueTrigger3Hrs));
			axelaserviceticketqueue.setTicketqueueTrigger4Hrs(Double.parseDouble(ticketqueueTrigger4Hrs));
			axelaserviceticketqueue.setTicketqueueTrigger5Hrs(Double.parseDouble(ticketqueueTrigger5Hrs));
			axelaserviceticketqueue.setTicketqueueRank(axelaticketqueuerepository.findRank());
			if (requestType.equals("add")) {
				axelaserviceticketqueue.setTicketqueueEntryDate(getTimeByZone(session));
				axelaserviceticketqueue.setTicketqueueEntryId(Integer.parseInt(empId));
				axelaserviceticketqueue.setTicketqueueModifiedId(0);
				axelaserviceticketqueue.setTicketqueueModifiedDate(stringToDate(""));
			} else {
				axelaserviceticketqueue.setTicketqueueEntryDate(axelaserviceticketqueue.getTicketqueueEntryDate());
				axelaserviceticketqueue.setTicketqueueEntryId(axelaserviceticketqueue.getTicketqueueEntryId());
				axelaserviceticketqueue.setTicketqueueModifiedId(Integer.parseInt(empId));
				axelaserviceticketqueue.setTicketqueueModifiedDate((getTimeByZone(session)));
			}
			AxelaHelpDeskTicketQueue result = null;
			result = axelaticketqueuerepository.save(axelaserviceticketqueue);
			if (result != null && requestType.equals("add")) {
				output.put("successmsg", "TicketQueue Added Successfully!");
				output.put("ticketQueueId", result.getTicketqueueId() + "");
			} else if (result != null && requestType.equals("update")) {
				output.put("successmsg", "TicketQueue Updated Successfully!");
				output.put("ticketQueueId", result.getTicketqueueId() + "");
			}
		}
		else {
			output.put("errormsg", msg);
		}
	}
	public Map populateData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		LinkedHashMap map = new LinkedHashMap();

		empId = CNumeric(PadQuotes(getSession("empId", session)));
		compId = CNumeric(getSession("compId", session));
		empFormatdate = getSession("formatdateName", session);
		empFormattime = getSession("formattimeName", session);
		SOP("empFormattime===" + empFormattime);
		formattimeTimepicker = getSession("formattimeTimepicker", session);

		if (!inputObj.isNull("ticketqueueId")) {
			ticketqueueId = CNumeric(PadQuotes(inputObj.getString("ticketqueueId")));
		}
		if (!ticketqueueId.equals("0")) {
			List<AxelaHelpDeskTicketQueue> queue = axelaticketqueuerepository.populateData(Integer.parseInt(ticketqueueId));
			for (AxelaHelpDeskTicketQueue results : queue) {
				SOP("ticketqueueName=====================" + results.getTicketqueueName());
				map.put("ticketqueueName", results.getTicketqueueName());
				map.put("ticketqueueDesc", results.getTicketqueueDesc());
				map.put("ticketqueueDuehrs", results.getTicketqueueDuehrs());
				map.put("ticketqueueTrigger1Hrs", results.getTicketqueueTrigger1Hrs());
				map.put("ticketqueueTrigger2Hrs", results.getTicketqueueTrigger2Hrs());
				map.put("ticketqueueTrigger3Hrs", results.getTicketqueueTrigger3Hrs());
				map.put("ticketqueueTrigger4Hrs", results.getTicketqueueTrigger4Hrs());
				map.put("ticketqueueTrigger5Hrs", results.getTicketqueueTrigger5Hrs());
				map.put("ticketqueueBusinessHrs", results.getTicketqueueBusinessHrs());

				startTime = results.getTicketqueueStarttime() + "";
				if (!startTime.contains(".")) {
					startTime = startTime + ".00";
				}
				String start[] = startTime.split("\\.");
				if (start[0].length() < 2) {
					start[0] = "0" + start[0];
				}
				if (start[1].length() < 2) {
					start[1] = start[1] + "0";
				}
				startTime = start[0] + ":" + start[1];
				SOP("startTime=111=" + startTime);
				startTime = formatDate(convertTimeToStr(startTime), empFormattime);
				SOP("startTime=222=" + startTime);
				map.put("startTime", startTime);

				endTime = results.getTicketqueueEndtime() + "";
				if (!endTime.contains(".")) {
					endTime = endTime + ".00";
				}
				String end[] = endTime.split("\\.");
				if (end[0].length() < 2) {
					end[0] = "0" + end[0];
				}
				if (end[1].length() < 2) {
					end[1] = end[1] + "0";
				}
				endTime = end[0] + ":" + end[1];
				SOP("endTime=111=" + endTime);
				endTime = formatDate(convertTimeToStr(endTime), empFormattime);
				SOP("endTime=222=" + endTime);

				map.put("endTime", "" + endTime);

				map.put("ticketqueueSun", results.getTicketqueueSun());
				map.put("ticketqueueMon", results.getTicketqueueMon());
				map.put("ticketqueueTue", results.getTicketqueueTue());
				map.put("ticketqueueWed", results.getTicketqueueWed());
				map.put("ticketqueueThu", results.getTicketqueueThu());
				map.put("ticketqueueFri", results.getTicketqueueFri());
				map.put("ticketqueueSat", results.getTicketqueueSat());
				if (results.getTicketqueueEntryId() != 0) {
					map.put("ticketqueueEntryDate", strToShortDate(results.getTicketqueueEntryDate()));
					map.put("ticketqueueEntryId", results.getTicketqueueEntryId());
					map.put("ticketEntryBy", empRepository.findEmpName(Integer.parseInt(String.valueOf(results.getTicketqueueEntryId()))));
				}
				SOP("getTicketqueueModifiedId=====" + results.getTicketqueueModifiedId());
				if (results.getTicketqueueModifiedId() != 0) {
					map.put("ticketqueueModifiedDate", strToShortDate(results.getTicketqueueModifiedDate()));
					map.put("ticketqueueModifiedId", String.valueOf(results.getTicketqueueModifiedId()));
					map.put("ticketqueueModifiedBy", empRepository.findEmpName(Integer.parseInt(String.valueOf(results.getTicketqueueModifiedId()))));
				}
				list.add(map);
			}
			output.put("populateData", list);
		}
		return output;
	}

	public void deleteFields(String ticketqueueId) {
		strSql = CNumeric(PadQuotes(String.valueOf(ticketRepository.findByTicketQueueId(Integer.parseInt(ticketqueueId)))));
		if (!strSql.equals("0")) {
			msg += "TicketQueue is associated with  ticket!";
		}
		if (msg.equals("")) {
			axelaticketqueuerepository.delete(Integer.parseInt(ticketqueueId));
			output.put("succesmsg", "TicketQueue Deleted Successfully!");
		}
	}

	public Map listData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		empId = CNumeric(PadQuotes(getSession("empId", session)));
		compId = CNumeric(PadQuotes(getSession("compId", session)));
		String strSearch = "";
		String strOrderBy = "";
		requestType = "";
		if (!empId.equals("0")) {
			if (!returnPerm("comp_id,emp_role_id", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			page = 0;

			output = new LinkedHashMap<String, String>();
			perPage = CNumeric(getSession("empRecperpage", session));
			List<AxelaHelpDeskTicketQueue> ticketQueueList = null;
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
			if (!inputObj.isNull("sortDirection")) {
				orderType = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
			}
			perPage = "25";
			if (orderType.equals("")) {
				orderType = "DESC";
			}
			if (orderByField.equals("")) {
				orderByField = "queue.ticketqueueRank";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strOrderBy = " ORDER BY " + orderByField + " " + orderType + "";
			ticketQueueList = ticketQueueFilterImpl.findTicketQueue(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			String length = ticketQueueFilterImpl.totalCount;
			Map mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Queue Details", "queue.ticketqueueName", "center"));
			listHeader.add(produceHeaderData("Order", "queue.ticketqueueRank", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align

			StringBuilder dataString = null;
			for (AxelaHelpDeskTicketQueue obj : ticketQueueList) {
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
				// Queue Details.
				type.add(false);
				value.add(String.valueOf(obj.getTicketqueueName()));
				listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// order
				type.add(true);
				type.add(true);
				value.add(String.valueOf("up"));
				value.add(String.valueOf("down"));
				paramSubArr.add(obj.getTicketqueueId() + "");
				paramSubArr.add("up");
				paramArr.add((ArrayList) paramSubArr.clone());
				paramSubArr.clear();
				paramSubArr.add(obj.getTicketqueueId() + "");
				paramSubArr.add("down");
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				paramSubArr.clear();
				paramArr.clear();
				type.clear();
				value.clear();
				// End Body data
				ArrayList<String> actionParam = new ArrayList<String>();
				mapData.put("td", listData);
				actionParam.add("updateQueue");
				actionParam.add(PadQuotes(String.valueOf(obj.getTicketqueueId())));
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
		if (AppRun().equals("0")) {
			SOP("output==========AssetService==========" + output.toString());
		}
		return output;
	}

	private ArrayList<HashMap> produceActionData(ArrayList<String> Param) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Queue");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart(HttpSession session) {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "queue.*"));
		list.add(buildSmartArr("Queue ID", "numeric", "queue.ticketqueueId"));
		list.add(buildSmartArr("Desc", "text", "queue.ticketqueueDesc"));
		list.add(buildSmartArr("Rank", "numeric", "queue.ticketqueueRank"));
		list.add(buildSmartArr("DueHrs", "numeric", "queue.ticketqueueDuehrs"));
		list.add(buildSmartArr("Trigger1", "numeric", "queue.ticketqueueTrigger1Frs"));
		list.add(buildSmartArr("Trigger2", "numeric", "queue.ticketqueueTrigger2Frs"));
		list.add(buildSmartArr("Trigger3", "numeric", "queue.ticketqueueTrigger3Frs"));
		list.add(buildSmartArr("Trigger4", "numeric", "queue.ticketqueueTrigger4Frs"));
		list.add(buildSmartArr("Trigger5", "numeric", "queue.ticketqueueTrigger5Frs"));
		// list.add(buildSmartArr("Entry By", "text", "ticketqueue_entry_id in (select emp_id from compdb.axela_emp where emp_name"));
		list.add(buildSmartArr("Entry Date", "date", "queue.ticketqueueEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "ticketqueue_modified_id in (select emp_id from compdb.axela_emp where emp_name"));
		list.add(buildSmartArr("Modified Date", "date", "queue.ticketqueueModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

	public void moveUp(String ticketqueueId) {
		output = new LinkedHashMap();
		int tempRank;
		int delStatusRank = 0;
		delStatusRank = axelaticketqueuerepository.findRankfromTicketQueueId(Integer.parseInt(ticketqueueId));
		tempRank = axelaticketqueuerepository.findMinRank();
		if (tempRank != 0 && delStatusRank != 0) {
			if (delStatusRank != tempRank) {
				tempRank = delStatusRank - 1;
				int updateCount1 = portalFilterImpl.updatePriority(delStatusRank, tempRank, "AxelaHelpDeskTicketQueue Queue", " Queue.ticketqueueRank");
				int updateCount2 = portalFilterImpl.updatePriorityById(delStatusRank, tempRank, "Queue.ticketqueueId", Integer.parseInt(ticketqueueId), "AxelaHelpDeskTicketQueue Queue",
						"Queue.ticketqueueRank");
				output.put("msg", "Ticket Queue  moved up successfully!");
			}
		} else {
			output.put("errormsg", "not possible");

		}
	}

	public void moveDown(String ticketqueueId) {
		output = new LinkedHashMap();
		int tempRank;
		int delstatusRank = 0;
		delstatusRank = axelaticketqueuerepository.findRankfromTicketQueueId(Integer.parseInt(ticketqueueId));
		tempRank = axelaticketqueuerepository.findMaxRank();
		if (tempRank != 0 && delstatusRank != 0) {
			if (delstatusRank != tempRank) {
				tempRank = delstatusRank + 1;
				int updateCount1 = portalFilterImpl.updatePriority(delstatusRank, tempRank, "AxelaHelpDeskTicketQueue Queue", " Queue.ticketqueueRank");
				int updateCount2 = portalFilterImpl.updatePriorityById(delstatusRank, tempRank, "Queue.ticketqueueId", Integer.parseInt(ticketqueueId), "AxelaHelpDeskTicketQueue Queue",
						"Queue.ticketqueueRank");
				output.put("msg", "Ticket Queue moved Down successfully!");
			}
		} else {
			output.put("errormsg", "not possible");
		}
	}
}
