package axela.app.sales.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.portal.repository.EmpRepository;

@Service
public class AppExecutiveImageService extends Connect {
	HashMap output = new HashMap();

	@Autowired
	public EmpRepository emprepository;

	public HashMap uploadExeImage(byte[] empPhoto, HttpServletResponse response, String empId, String compId) throws JSONException {
		int result = 0;
		result = emprepository.updateExePhoto(empPhoto, Integer.parseInt(empId));
		if (result == 1)
		{
			output.put("successmsg", "Image Uploaded Successfully");
		} else
		{
			output.put("msg", "error");
		}
		return output;
	}

}
