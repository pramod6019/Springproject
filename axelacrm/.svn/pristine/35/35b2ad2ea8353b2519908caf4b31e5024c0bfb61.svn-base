package axela.app.service.service;

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
import org.springframework.stereotype.Component;

import axela.accounting.model.AxelaAccVoucher;
import axela.config.Connect;
import axela.service.repository.VoucherRepositoryImpl;

@Component
public class WS_VoucherService extends Connect {
	public String vouchertypeId = "0";
	@Autowired
	private VoucherRepositoryImpl voucherrepositoryimpl;
	public Map<String, List> listData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		vouchertypeId = "0";
		String pageIndex = "";
		HashMap output = null;
		JSONObject inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("input========AxelavoucherlistService listData===========" + inputObj.toString(1));
		}
		output = new HashMap<String, List>();
		List<AxelaAccVoucher> vocherlist = null;
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		// List<AxelaAccVoucher> jobcard = new ArrayList<AxelaAccVoucher>();
		if (!inputObj.isNull("pageIndex")) {
			pageIndex = PadQuotes((inputObj.getString("pageIndex")));
		}
		String page = "0";
		String sort = "DESC";

		// String field = "id";
		if (!inputObj.isNull("pageIndex")) {
			page = CNumeric(PadQuotes((inputObj.getString("pageIndex"))));
		}
		if (!inputObj.isNull("vouchertypeId")) {
			vouchertypeId = CNumeric(PadQuotes((inputObj.getString("vouchertypeId"))));
		}
		String perPage = CNumeric(getSession("emp_recperpage", session));
		String strsearch = "";
		if (perPage.equals("0")) {
			perPage = "25";
		}
		if (page.equals("0")) {
			page = "1";
		}
		if (!vouchertypeId.equals("0")) {
			strsearch += " AND voucher.axelaAccvouchertype.vouchertypeId=" + vouchertypeId;
		}
		vocherlist = voucherrepositoryimpl.findAllVoucher(strsearch);
		if (vocherlist != null && vocherlist.size() > 0) {
			for (AxelaAccVoucher result : vocherlist) {
				LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
				map.put("voucherId", CNumeric(String.valueOf(result.getVoucherId())));
				map.put("voucherAmount", (PadQuotes(result.getVoucherAmount() + "")));
				// map.put("voucherDate", strToShortDate(stringToDate(result.getVoucherDate())));
				// map.put("voucherAuthorize", (PadQuotes(result.getVoucherAuthorize())));
				map.put("customerId", CNumeric(String.valueOf(result.getCustomerId())));
				map.put("ledgerName", PadQuotes(result.getCustomerName()));
				map.put("contactMobile1", PadQuotes(result.getContactMobile1()));
				map.put("contactMobile2", PadQuotes(result.getContactMobile2()));
				map.put("contactEmail2", PadQuotes(result.getContactEmail2()));
				map.put("contactMobile2", PadQuotes(result.getContactMobile2()));
				map.put("contactName", PadQuotes(result.getContactName()));
				map.put("empName", PadQuotes(result.getEmpName()));
				// map.put("voucherClassId", CNumeric(String.valueOf(result.getVoucherclassId())));
				map.put("voucherTypeName", PadQuotes(result.getVouchertypeName()));
				list.add(map);
			}
			output.put("listData", list);
		}
		else
		{
			output.put("msg", "No Records Found!");
		}

		if (AppRun().equals("0")) {
			SOP("output =========AxelavoucherlistService listData============== " + output);
		}
		return output;

	}
}
