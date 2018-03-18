package axela.portal.service;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.support.SessionStatus;

import axela.config.Connect;
import axela.portal.controller.Controller_Portal;
import axela.portal.model.AxelaEmp;
import axela.portal.repository.Signin_Repository;
//@SessionAttributes({"username", "password"})
@Service
public class Signin_Service {
	public String sessionid = "";
	Connect cnt = new Connect();
	@Autowired
	Controller_Portal controllerportal;

	@Autowired
	Signin_Repository loginrepository;

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;

	@PersistenceContext
	EntityManager entitymanager;
	public Map<String, String> SigninService(String input) throws UnknownHostException, JSONException {
		Map<String, String> output = new HashMap<String, String>();
		try {
			String username = "", password = "";
			JSONObject inputObj = new JSONObject(input);
			if (!inputObj.isNull("email")) {
				username = inputObj.getString("email");
			}
			if (!inputObj.isNull("password")) {
				password = inputObj.getString("password");
			}
			AxelaEmp axelaEmp = loginrepository.findByEmpEmail1AndEmpUpass(username, password);
			if (axelaEmp != null) {
				sessionid = session.getId();
				System.out.println("sessionis====signin==" + sessionid);
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				cnt.getcompsession(request, response);
				System.out.println("111");
				String comp_id = cnt.CNumeric(cnt.GetSession("comp_id", request)) + "";
				int empId = axelaEmp.getEmpId();
				String empUname = axelaEmp.getEmpUname();
				String empEmail1 = axelaEmp.getEmpEmail1();
				String empName = axelaEmp.getEmpName();
				String empAllExe = axelaEmp.getEmpAllExe();
				int empThemeId = axelaEmp.getEmpThemeId();
				String empRecperpage = axelaEmp.getEmpRecperpage() + "";
				String empIpAccess = axelaEmp.getEmpIpAccess();
				int emp_timeout = axelaEmp.getEmpTimeout();
				cnt.AssignSession(empId + "", "4", "1", empAllExe, empRecperpage, emp_timeout, comp_id, request);
				String logRemoteHost = request.getRemoteHost() + "";
				String logRemoteAgent = request.getHeader("User-Agent");
				Cookie cookie = new Cookie("axelatheme", empThemeId + "");
				cookie.setMaxAge(60 * 60 * 24 * 30 * 60);
				cookie.setPath(request.getContextPath());
				response.addCookie(cookie);
				int logAttemptcount = 0;
				if (!cnt.GetSession("signincount", request).equals("")) {
					logAttemptcount = Integer.parseInt(cnt.GetSession("signincount", request));
				}
				loginrepository.deleteByEmpId(empId);
				loginrepository.updateByEmpId(empId, cnt.toLongDate(cnt.kknow()), logRemoteHost, logRemoteAgent);
				loginrepository.saveLog(empId, cnt.toLongDate(cnt.kknow()) + "", sessionid, logRemoteHost, logRemoteAgent, logAttemptcount);
				loginrepository.saveUser(empId, cnt.toLongDate(cnt.kknow()), logRemoteHost, logRemoteAgent, sessionid);
				output.put("msg", "yes");
				output.put("emp_uname", empUname);
				output.put("emp_id", empId + "");
				output.put("emp_name", empName);
				output.put("comp_id", comp_id);
				// controllerportal.session = session;
				output.put("sessionid", sessionid);
			}
			else {
				output.put("msg", "Username Or Password that you have entered is invalid!");
			}
		} catch (Exception ex) {
			System.out.println("springboot-ws-jpa==" + this.getClass().getName());
			System.out.println("Error in " + new Exception().getStackTrace()[0].getMethodName() + ": " + ex);
		}
		return output;
	}

	public String SigninTest(String input, HttpSession session, Model model) throws JSONException {
		Map<String, String> output = new HashMap<String, String>();
		System.out.println("session====signtest====sessionid======" + session.getId());
		System.out.println("session====signtest====username======" + session.getAttribute("username"));
		System.out.println("session====signtest======password====" + session.getAttribute("password"));
		return "success successfull======" + session.getAttribute("password") + "===" + session.getAttribute("username");
	}

	public String SignOut(SessionStatus status, HttpSession session) throws JSONException {
		System.out.println("session====signout==========" + session.getId());
		session.invalidate();
		return "Signout Successfully!";
	}
}