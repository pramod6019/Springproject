package axela.portal.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import axela.portal.model.AxelaEmp;
import axela.portal.repository.CompRepository;
import axela.portal.repository.EmpLogRepository;
import axela.portal.repository.EmpUserRepository;
import axela.portal.repository.SigninRepository;
//@SessionAttributes({"username", "password"})
@Service
public class SigninService extends Connect {
	public String sessionid = "";
	public Long empexe_id;
	public Date timeZone = null;
	// Connect cnt = new Connect();
	@Autowired
	private Connect connect;

	@Autowired
	private SigninRepository signinRepository;

	@Autowired
	private CompRepository axelaCompRepository;

	@Autowired
	private HttpSession session;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpServletResponse response;

	@Autowired
	private EmpLogRepository empLogRepository;

	@Autowired
	private EmpUserRepository empUserRepository;

	@PersistenceContext
	EntityManager entitymanager;

	public Map<String, String> SigninService(String input) throws Exception {
		Map<String, String> output = new HashMap<String, String>();
		String username = "", password = "";
		JSONObject inputObj = new JSONObject(input);
		if (!inputObj.isNull("email")) {
			username = inputObj.getString("email");
		}
		if (!inputObj.isNull("password")) {
			password = inputObj.getString("password");
		}

		AxelaEmp axelaEmp = signinRepository.findByEmpEmail1AndEmpUpass(username, password);
		if (axelaEmp != null) {
			sessionid = session.getId();
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			// getcompsession(request, response);
			String comp_id = connect.CNumeric(connect.getSession("comp_id", session)) + "";
			comp_id = "1";
			String branch_id = "";
			assignSession(axelaEmp.getEmpId() + "", axelaEmp.getEmpBranchId() + "", axelaEmp.getEmpRoleId(), axelaEmp.getEmpAllExe(), axelaEmp.getEmpRecperpage()
					+ "",
					axelaEmp.getEmpTimeout(), comp_id, session);
			String logRemoteHost = request.getRemoteHost() + "";
			String logRemoteAgent = request.getHeader("User-Agent");
			Cookie cookie = new Cookie("axelatheme", axelaEmp.getEmpThemeId() + "");
			cookie.setMaxAge(60 * 60 * 24 * 30 * 60);
			cookie.setPath(request.getContextPath());
			response.addCookie(cookie);
			int logAttemptcount = 0;
			if (!getSession("signincount", session).equals("")) {
				logAttemptcount = Integer.parseInt(connect.getSession("signincount", session));
			}
			timeZone = getTimeByZone(session);
			// if (AppRun().equals("1")) {
			// signinRepository.deleteUserByEmpId(axelaEmp.getEmpId());
			// signinRepository.addUserByEmpId(axelaEmp.getEmpId(), timeZone, logRemoteHost, logRemoteAgent);
			// AxelaEmpLog axelaEmpLog = new AxelaEmpLog();
			// axelaEmpLog.setLogEmpId(axelaEmp.getEmpId());
			// axelaEmpLog.setLogSigninTime(timeZone);
			// axelaEmpLog.setLogSessionId(sessionid);
			// axelaEmpLog.setLogRemoteAgent(logRemoteAgent);
			// axelaEmpLog.setLogRemoteHost(logRemoteHost);
			// axelaEmpLog.setLogAttemptcount((byte) logAttemptcount);
			// empLogRepository.save(axelaEmpLog);
			// AxelaEmpUser axelaEmpUser = new AxelaEmpUser();
			// axelaEmpUser.setUserJsessionid(sessionid);
			// axelaEmpUser.setUserLogintime(timeZone);
			// axelaEmpUser.setUserIp(logRemoteHost);
			// axelaEmpUser.setUserAgent(logRemoteAgent);
			// axelaEmpUser.setUserEmpId(axelaEmp.getEmpId());
			// empUserRepository.save(axelaEmpUser);
			// }
			output.put("successmsg", "Signin Successfull!");
			output.put("emp_jobtitle", axelaEmp.getAxelaJobtitle().getJobtitleDesc());
			output.put("emp_id", axelaEmp.getEmpId() + "");
			output.put("emp_name", axelaEmp.getEmpName());
			output.put("emp_role_id", axelaEmp.getEmpRoleId());
			output.put("empThemeId", String.valueOf(axelaEmp.getEmpThemeId()));
			output.put("emp_mis_access", axelaEmp.getEmpMisAccess());
			output.put("comp_id", comp_id);
			List<Object[]> axelaComp = axelaCompRepository.findAllModule(Integer.parseInt(comp_id));
			for (Object[] results : axelaComp) {
				output.put("compName", results[0].toString());
				output.put("compModuleActivity", results[1].toString());
				output.put("compModuleCustomer", results[2].toString());
				output.put("compModulePm", results[3].toString());
				output.put("compModuleMarketing", results[4].toString());
				output.put("compModuleSales", results[5].toString());
				output.put("compModuleService", results[6].toString());
				output.put("compModulePos", results[7].toString());
				output.put("compModuleInventory", results[8].toString());
				output.put("compModuleInvoice", results[9].toString());
				output.put("compModuleAccounting", results[10].toString());
				output.put("compModuleProduction", results[11].toString());
				output.put("compModuleAsset", results[12].toString());
				output.put("compModuleHcm", results[13].toString());
				output.put("compModulePayroll", results[14].toString());
				output.put("compModuleSocial", results[15].toString());
				output.put("compModuleWebsite", results[16].toString());
				output.put("compModuleProductcatalogue", results[17].toString());
				output.put("compModulePortal", results[18].toString());
				output.put("compModuleEmailEnable", results[19].toString());
				output.put("compModuleSmsEnable", results[20].toString());
				output.put("compModuleHelpdesk", results[21].toString());
				output.put("compBranchCount", results[22].toString());
				output.put("compFranchiseeCount", results[23].toString());
			}
		} else {
			output.put("emp_id", "0");
		}
		return output;
	}
	public String SigninTest(String input, HttpSession session, Model model) throws JSONException {
		Map<String, String> output = new HashMap<String, String>();
		System.out.println("signtest====sessionid======" + session.getId());
		System.out.println("signtest====username======" + session.getAttribute("username"));
		System.out.println("signtest======password====" + session.getAttribute("password"));
		return "success successfull======" + session.getAttribute("password") + "===" + session.getAttribute("username");
	}

	public Map<String, String> SignOut(SessionStatus status, HttpSession session) throws JSONException {
		System.out.println("session====signout==========" + session.getId());
		session.invalidate();
		Map<String, String> output = new HashMap<String, String>();
		output.put("msg", "Signout Successfully!");
		output.put("emp_id", "0");
		return output;
	}

	public String sessionTest() throws JSONException {
		System.out.println("comp_name=======sessionTest====" + connect.getSession("comp_name", session));
		System.out.println("ExeAccess=======sessionTest====" + connect.getSession("exeAccess", session));
		System.out.println("BranchAccess=======sessionTest====" + connect.getSession("branchAccess", session));
		return "Session Test Successfully!";
	}
}