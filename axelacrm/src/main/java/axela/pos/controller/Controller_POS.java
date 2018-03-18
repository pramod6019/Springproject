//sharath 
package axela.pos.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pos")
public class Controller_POS {

	@RequestMapping("/test")
	public Map<String, String> JSONTest() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("message", "AxelaCRM POS test successfull!");
		return map;
	}
}
