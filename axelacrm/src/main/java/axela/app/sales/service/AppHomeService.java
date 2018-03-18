package axela.app.sales.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.app.sales.repository.HomeSalesFilterImpl;
import axela.config.Connect;
import axela.helpdesk.model.AxelaHelpDeskTicket;
import axela.pm.model.AxelaPm;
import axela.pm.model.AxelaPmTask;
import axela.portal.repository.AxelaUniEmpRepository;
import axela.portal.repository.AxelaUniEmpRepositoryImpl;
import axela.portal.repository.BranchRepository;
import axela.portal.repository.FranchiseeRepository;
import axela.sales.model.AxelaSalesOppr;
import axela.service.model.AxelaServiceContract;
import axela.service.model.AxelaServiceJc;

@Service
public class AppHomeService extends Connect {
	public JSONObject inputObj = null;
	HashMap output = null;
	public String empId = "0";
	public String empUuid = "";
	public String compModuleSales = "0";
	public String compModuleService = "0";
	public String compModuleAccounting = "0";
	public String compModuleHelpdesk = "0";
	public String compModulePm = "0";
	public String branchAccess = "";
	public String exeAccess = "";
	public String strSearch = "";
	public String branchId = "0";
	public String type = "";
	public Date timeZone = null;
	ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

	@Autowired
	AxelaUniEmpRepositoryImpl axelaUniEmpRepository;

	@Autowired
	AxelaUniEmpRepository AxelaUniEmpRepository;

	@Autowired
	HomeSalesFilterImpl homeSalesFilterImpl;

	@Autowired
	FranchiseeRepository franchiseeRepository;

	@Autowired
	BranchRepository branchRepository;

	public Map homeData(String input, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws JSONException {
		inputObj = new JSONObject(input);
		Map map = new HashMap();
		output = new HashMap();
		strSearch = "";
		type = "";
		branchId = "0";

		SOP("inputObj===================" + inputObj);
		SOP("coming inside homedata");
		if (!inputObj.isNull("empId")) {
			empId = PadQuotes((inputObj.getString("empId")));
		}

		empId = CNumeric(PadQuotes(getSession("empId", session)));
		// CheckAppSession(emp_uuid, comp_id, request);
		compModuleSales = GetSession("compModuleSales", request);
		compModuleService = GetSession("compModuleService", request);
		compModuleHelpdesk = GetSession("compModuleHelpdesk", request);
		compModulePm = GetSession("compModulePm", request);
		compModuleAccounting = GetSession("compModuleAccounting", request);
		branchAccess = GetSession("branchAccess", request);
		exeAccess = GetSession("exeAccess", request);
		SOP("empId==============" + empId);
		if (!empId.equals("0")) {
			if (!inputObj.isNull("branchId")) {
				branchId = CNumeric((String) inputObj.getString("branchId"));
			}
			if (!inputObj.isNull("type")) {
				type = PadQuotes((inputObj.getString("type")));
			}
			int result = 0;
			result = franchiseeRepository.populateByfranchiseeId();
			map.put("franchiseeCount", CNumeric("" + result));

			result = branchRepository.populateBybranchId();
			map.put("branchCount", CNumeric("" + result));

			map.put("empActive", CNumeric("" + AxelaUniEmpRepository.findEmpactive(Integer.parseInt(empId))));

			if (type.equals("sales")) {
				if (compModuleSales.equals("1")) {
					List<AxelaSalesOppr> axelaSalesOppr = homeSalesFilterImpl.findSalesCount(Integer.parseInt(empId), dateToString(kknow()), branchId);
					for (AxelaSalesOppr obj : axelaSalesOppr) {
						map.put("monthOpportunities", CNumeric("" + obj.getMonthOpportunities()));
						map.put("todayOpportunities", CNumeric("" + obj.getTodayOpportunities()));
						map.put("totalOpportunities", CNumeric("" + obj.getTotalOpportunities()));
						map.put("level1oppr", CNumeric("" + obj.getLevel1oppr()));
						map.put("level2oppr", CNumeric("" + obj.getLevel2oppr()));
						map.put("level3oppr", CNumeric("" + obj.getLevel3oppr()));
						map.put("level4oppr", CNumeric("" + obj.getLevel4oppr()));
						map.put("level5oppr", CNumeric("" + obj.getLevel5oppr()));
					}
					// List<AxelaAccVoucher> axelaaccvoucher = homeSalesFilterImpl.findacccountCount(Integer.parseInt(empId), toLongDate(kknow()), branchId);
					// for (AxelaAccVoucher obj : axelaaccvoucher) {
					// map.put("todayInvoices", CNumeric(""+obj.getTodayinvoices()));
					// map.put("todayReceipts", CNumeric(""+obj.getTodayreceipts()));
					// map.put("monthInvoices", CNumeric(""+obj.getMonthinvoices()));
					// map.put("monthReceipts", CNumeric(""+obj.getMonthreceipts()));
					// map.put("todaySo", CNumeric(""+obj.getTodayso()));
					// map.put("totalSo", CNumeric(""+obj.getTotalso()));
					// map.put("monthSo", CNumeric(""+obj.getMonthso()));
					//
					// }
					map.put("todayInvoices", "0");
					map.put("todayReceipts", "0");
					map.put("monthInvoices", "0");
					map.put("monthReceipts", "0");
					map.put("todaySo", "0");
					map.put("totalSo", "0");
					map.put("monthSo", "0");
				}
			}
			if (type.equals("service")) {
				if (compModuleService.equals("1")) {
					List<AxelaServiceContract> axelaservicecontract = homeSalesFilterImpl.findContractCount(Integer.parseInt(empId), dateToString(kknow()), branchId);
					for (AxelaServiceContract obj : axelaservicecontract) {
						map.put("monthContract", CNumeric("" + obj.getMonthContract()));
						map.put("todayContract", CNumeric("" + obj.getTodayContract()));
					}

					List<AxelaServiceJc> axelaservicejc = homeSalesFilterImpl.findjobcardCount(Integer.parseInt(empId), dateToString(kknow()), branchId);
					for (AxelaServiceJc obj : axelaservicejc) {
						map.put("monthJc", CNumeric("" + obj.getMonthjc()));
						map.put("todayJc", CNumeric("" + obj.getTodayjc()));
						map.put("totalJc", CNumeric("" + obj.getTotaljc()));
						map.put("level1Jc", CNumeric("" + obj.getLevel1jc()));
						map.put("level2Jc", CNumeric("" + obj.getLevel2jc()));
						map.put("level3Jc", CNumeric("" + obj.getLevel3jc()));
						map.put("level4Jc", CNumeric("" + obj.getLevel4jc()));
						map.put("level5Jc", CNumeric("" + obj.getLevel5jc()));
					}
				}
			}
			if (type.equals("helpdesk")) {
				if (compModuleHelpdesk.equals("1")) {
					SOP("compModuleHelpdesk===xxcvxv=" + compModuleHelpdesk);
					List<AxelaHelpDeskTicket> axelaserviceticket = homeSalesFilterImpl.findticketCount(Integer.parseInt(empId), dateToString(kknow()), branchId);
					for (AxelaHelpDeskTicket obj : axelaserviceticket) {
						map.put("monthTicket", CNumeric("" + obj.getMonthticket()));
						map.put("todayTicket", CNumeric("" + obj.getTodayticket()));
						map.put("totalTicket", CNumeric("" + obj.getTotalticket()));
						map.put("todayOpenTicket", CNumeric("" + obj.getTodayOpenticket()));
						map.put("monthOpenTicket", CNumeric("" + obj.getMonthOpenticket()));
						map.put("level1ticket", CNumeric("" + obj.getLevel1ticket()));
						map.put("level2ticket", CNumeric("" + obj.getLevel2ticket()));
						map.put("level3ticket", CNumeric("" + obj.getLevel3ticket()));
						map.put("level4ticket", CNumeric("" + obj.getLevel4ticket()));
						map.put("level5ticket", CNumeric("" + obj.getLevel5ticket()));
					}
				}
			}

			if (type.equals("pm")) {
				if (compModulePm.equals("1")) {
					List<AxelaPm> axelaPm = homeSalesFilterImpl.findpmCount(Integer.parseInt(empId), dateToString(kknow()), branchId);
					for (AxelaPm obj : axelaPm) {
						map.put("monthPm", CNumeric("" + obj.getMonthPm()));
						map.put("todayPm", CNumeric("" + obj.getTodayPm()));
						map.put("totalPm", CNumeric("" + obj.getTotalPm()));

					}
					List<AxelaPmTask> axelaPmTask = homeSalesFilterImpl.findTaskCount(Integer.parseInt(empId), dateToString(kknow()), branchId);
					for (AxelaPmTask obj : axelaPmTask) {
						map.put("todayTask", CNumeric("" + obj.getTodayTask()));
						map.put("totalTask", CNumeric("" + obj.getTotalTask()));
						map.put("monthTask", CNumeric("" + obj.getMonthTask()));

					}
				}
			}
			output.put("homeData", map);
			SOP("output===================" + output);

		} else {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			// output.put("response", HttpServletResponse.SC_FORBIDDEN);
		}
		return output;
	}
}
