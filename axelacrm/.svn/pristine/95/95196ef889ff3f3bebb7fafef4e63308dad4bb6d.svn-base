//Sharath
package axela.accounting.controller;

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
import org.springframework.web.bind.annotation.RestController;

import axela.accounting.service.VoucherService;

@RestController
@RequestMapping("/accounting")
@CrossOrigin("*")
public class Controller_Accounting {

	@Autowired
	public VoucherService voucherService;

	@RequestMapping("/test")
	public Map<String, String> JSONTest(HttpSession session) {
		System.out.println("test");
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "AxelaCRM Accounting test successfull!");
		return map;
	}

	// Vouncher List
	@RequestMapping("/voucher-list")
	public Map Customer(@RequestBody String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException {
		return voucherService.listData(input, session);
	}
}
