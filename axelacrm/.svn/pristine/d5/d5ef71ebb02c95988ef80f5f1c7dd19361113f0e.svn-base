package axela.portal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.portal.model.AxelaFinanceComp;
import axela.portal.repository.customerHeadRepository;

@Service
public class customersHeadService extends Connect {
	private final static int PAGESIZE = 25;
	public String fincomp_id = "0";
	public String fincomp_active = "";
	public String fincomp_entry_date = "";
	public String fincomp_entry_id = "0";
	public String fincomp_modified_date = "";
	public String fincomp_modified_id = "0";
	public String fincomp_name = "";
	public String requesttype = "";
	public String msg = "";
	public String pageNumber = "";

	HashMap<String, String> output = null;
	JSONObject inputObj = null;
	@Autowired
	private customerHeadRepository customerHeadRepository;

	public Map<String, String> customerHeadService(String input, HttpServletResponse response) throws JSONException {
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();

		if (!inputObj.isNull("requesttype")) {
			requesttype = inputObj.getString("requesttype");
		}

		switch (requesttype) {

			case "add" : // add an soe.
				getValues(inputObj);
				addFields(response);
				break;

			case "update" :// update an customer.
				getValues(inputObj);
				addFields(response);
				break;

			case "delete" :// delete an customer.
				if (!inputObj.isNull("fincomp_id")) {
					fincomp_id = inputObj.getString("fincomp_id");
				}
				if (!fincomp_id.equals("0")) {
					deleteFields(fincomp_id);
				}
				break;

		}
		return output;
	}
	public void getValues(JSONObject inputObj) throws JSONException {

		msg = "";

		if (!inputObj.isNull("fincomp_id")) {
			fincomp_id = CNumeric(inputObj.getString("fincomp_id"));
		}

		if (!inputObj.isNull("fincomp_active")) {
			fincomp_active = PadQuotes(inputObj.getString("fincomp_active"));
		}
		if (!inputObj.isNull("fincomp_entry_date")) {
			fincomp_entry_date = PadQuotes(inputObj.getString("fincomp_entry_date"));
		}
		if (!inputObj.isNull("fincomp_entry_id")) {
			fincomp_entry_id = CNumeric(inputObj.getString("fincomp_entry_id"));
		}
		if (!inputObj.isNull("fincomp_modified_date")) {
			fincomp_modified_date = PadQuotes(inputObj.getString("fincomp_modified_date"));
		}

		if (!inputObj.isNull("fincomp_modified_id")) {
			fincomp_modified_id = CNumeric(inputObj.getString("fincomp_modified_id"));
		}
		if (!inputObj.isNull("fincomp_name")) {
			fincomp_name = PadQuotes(inputObj.getString("fincomp_name"));
		}
	}
	public void checkForm() {
		if (fincomp_name.equals("")) {
			msg = msg + "<br>Enter Fincomp Name!";
		}
		else {
			List<AxelaFinanceComp> obj = customerHeadRepository.findByName(fincomp_name);
			if (!obj.isEmpty()) {
				msg += "<br>Similar Item Group found!";
			}
		}
	}

	public void addFields(HttpServletResponse response) {

		checkForm();
		SOP("addFields");
		if (msg.equals("")) {
			AxelaFinanceComp axelafinancecomp = new AxelaFinanceComp();

			axelafinancecomp.setFincompId(Integer.parseInt(fincomp_id));
			axelafinancecomp.setFincompActive(fincomp_active);
			// axelafinancecomp.setFincompEntryDate(fincomp_entry_date);
			axelafinancecomp.setFincompEntryId(Integer.parseInt(fincomp_entry_id));
			// axelafinancecomp.setFincompModifiedDate(fincomp_modified_date);
			axelafinancecomp.setFincompModifiedId(Integer.parseInt(fincomp_modified_id));
			axelafinancecomp.setFincompName(fincomp_name);
			customerHeadRepository.save(axelafinancecomp);

			if (fincomp_id.equals("0")) { // if id = 0 -> add mode else update mode
				output.put("successmsg", "fincomp Added Successfully!");
			} else {
				output.put("successmsg", "findcomp Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}

	}
	public void deleteFields(String soe_id) {
		customerHeadRepository.delete(Integer.parseInt(fincomp_id));
		output.put("succesmsg", "findcomp Deleted Successfully!");
	}
	public ArrayList<HashMap<String, String>> listData(int pageNumber) {
		System.out.println("lisData");
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (pageNumber >= 11) {
			output.put("msg", "No Records Found!");
		} else {
			PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.ASC, "fincompId");
			for (AxelaFinanceComp obj : customerHeadRepository.findAll(request).getContent()) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("fincomp_id", String.valueOf(obj.getFincompId()));
				map.put("fincomp_name", String.valueOf(obj.getFincompName()));

				list.add(map);
			}

		}
		return list;
	}

}
