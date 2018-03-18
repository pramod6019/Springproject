package axela.app.sales.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import axela.app.sales.service.AppActivityList;
import axela.app.sales.service.AppExecutiveImageService;
import axela.app.sales.service.AppHomeService;
import axela.app.sales.service.AppOpprService;
import axela.app.sales.service.AppReportExeDash;
import axela.app.sales.service.AppSigninService;
import axela.app.sales.service.AppStatusUpdateService;
import axela.app.service.service.AppJobcardImgService;

@RestController
@RequestMapping("/app-sales")
@CrossOrigin("*")
public class Controller_App_Sales {

	@Autowired
	private AppOpprService AppOpprService;

	@Autowired
	AppSigninService appService;

	@Autowired
	private AppHomeService homeService;

	@Autowired
	private AppActivityList appActivityList;

	@Autowired
	private AppReportExeDash appReportExeDash;

	@Autowired
	private AppJobcardImgService appJobcardimgservice;

	@Autowired
	private AppStatusUpdateService appStatusupdateservice;

	@Autowired
	private AppExecutiveImageService appExecutiveimageservice;

	@RequestMapping("/")
	public Map<String, String> test() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "AxelaCRM App Sales test successfull!");
		return map;
	}

	@RequestMapping("/homedata")
	public Map HomeData(@RequestBody String input, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws JSONException, ParseException {
		response.setStatus(201);
		return homeService.homeData(input, session, request, response);
	}
	@RequestMapping("/opportunity")
	public Map OpportunityUpdate(@RequestBody String input, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws JSONException, ParseException {
		response.setStatus(201);
		return AppOpprService.opprServiceUpdate(input, response, request, session);
	}

	@RequestMapping("/opportunity-list")
	public Map OpportunityList(@RequestBody String input, HttpServletResponse response, HttpSession session) throws JSONException, ParseException {
		return AppOpprService.listData(input, session, response);
	}

	@RequestMapping("/opportunity-dash")
	public Map OpportunityDash(@RequestBody String input, HttpServletResponse response, HttpSession session, HttpServletRequest request) throws JSONException, ParseException {
		return AppOpprService.opprDashPage(input, session, response, request);
	}

	@RequestMapping("/signin")
	public Map TicketList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws Exception {
		return appService.listData(input, session, response);
	}

	@RequestMapping("/activity-list")
	public Map ActivityList(@RequestBody String input, HttpSession session, HttpServletResponse response) throws Exception {
		return appActivityList.ActivityList(input, session, response);
	}

	@RequestMapping("/executive-dash")
	public Map exeList(@RequestBody String input, HttpSession session, HttpServletRequest request) throws JSONException {
		return appReportExeDash.executiveData(input, session, request);
	}

	@RequestMapping("/status-update")
	public Map statusUpdate(@RequestBody String input, HttpSession session, HttpServletRequest request) throws JSONException {
		return appStatusupdateservice.statusUpdate(input, session, request);
	}

	@RequestMapping(value = "/uploadjobcardimg", method = RequestMethod.POST, consumes = "multipart/form-data")
	public Map uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("empId") String empId, @RequestParam("jcId") String jcId, @RequestParam("imgTitle") String imgTitle,
			@RequestParam("compId") String compId, HttpServletResponse response, HttpSession session) throws IOException, JSONException, ParseException {
		System.out.println("file=======" + file);
		System.out.println("file stream======" + file.getBytes());
		return appJobcardimgservice.UploadJobCardImage(file.getBytes(), response, empId, jcId, imgTitle, compId, session);

	}

	@RequestMapping(value = "/uploadexeimg", method = RequestMethod.POST, consumes = "multipart/form-data")
	public Map uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("empId") String empId,
			@RequestParam("compId") String compId, HttpServletResponse response) throws IOException, JSONException {
		System.out.println("file=======" + file);
		System.out.println("file stream======" + file.getBytes());
		return appExecutiveimageservice.uploadExeImage(file.getBytes(), response, empId, compId);

	}

}
