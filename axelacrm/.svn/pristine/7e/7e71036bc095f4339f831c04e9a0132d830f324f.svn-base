//sharath 
package axela.portal.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import axela.portal.service.SigninService;
//import axela.portal.SignIn_Service;

@RestController
@EnableAutoConfiguration
@RequestMapping("/signin")
@CrossOrigin("*")
public class Controller_Signin {

	@Autowired
	SigninService signinService;

	@RequestMapping("/test")
	public Map<String, String> JSONTest() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "AxelaCRM Portal test successfull!");
		return map;
	}

	@GetMapping("/all")
	public String hello() {
		return "Hello Youtube";
	}

	@GetMapping("/secured/all")
	public String securedHello() {
		return "Secured Hello";
	}

	@GetMapping("/secured/alternate")
	public String alternate() {
		return "alternate";
	}

	// @RequestMapping(value = "/login", method = RequestMethod.POST)
	// public Map<String, String> signin(@RequestBody String input, Model model, HttpSession session) throws JSONException, UnknownHostException {
	// return loginService.LoginService(input, model, session);
	// }
}
