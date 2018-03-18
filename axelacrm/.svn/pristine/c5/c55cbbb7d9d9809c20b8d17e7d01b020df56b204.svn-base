package axela.activities.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.activities.repository.ActivityFilterImpl;
import axela.config.Connect;

@Service
public class ActivitiesDashService extends Connect {

	@Autowired
	ActivityFilterImpl activityFilterImpl;
	List output = null;
	public JSONObject inputObj = null;

	public Map activitiesDashService(String input, HttpSession session, HttpServletResponse response) throws JSONException {
		inputObj = new JSONObject(input);

		output = new ArrayList();

		for (Object[] event : activityFilterImpl.findAllActivityEvent("")) {
			// if(event!=null)
			// HashMap<String, String> map = new HashMap<String, String>();
			// map.put("contractCustomerId", "" + contact[0]);
			// map.put("contactId", "" + contact[1]);
			// map.put("customerName", "" + contact[2]);
			// map.put("contactName", "" + contact[3]);
			// map.put("contactEmail1", "" + contact[4]);
			// map.put("contactMobile1", "" + contact[5]);
			// list.add(map);

		}

		List<Object[]> fallowup = activityFilterImpl.findAllActivityOpprFollowup("");
		List<Object[]> birthday = activityFilterImpl.findAllActivityBirthday("");
		// output.add(event);
		output.add(fallowup);
		output.add(birthday);

		return null;

	}
}
