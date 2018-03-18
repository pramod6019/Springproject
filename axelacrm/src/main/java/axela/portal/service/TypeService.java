package axela.portal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.portal.model.AxelaPmType;
import axela.portal.repository.PmTypeRepository;
@Service
public class TypeService extends Connect
{
	private final static int PAGESIZE = 25;
	public String pmtype_id = "0";
	public String pmtype_entry_date = "";
	public String pmtype_entry_id = "0";
	public String pmtype_modified_date = "";
	public String pmtype_modified_id = "0";
	public String pmtype_name = "";
	public String requesttype = "";
	public String msg = "";
	public String pagenumber = "";
	public String emp_formattime = "";
	public String emp_formatdate = "";

	HashMap<String, String> output = null;
	JSONObject inputObj = null;

	@Autowired
	private PmTypeRepository axelapmtyperepository;

	public Map<String, String> typeService(String input, HttpServletRequest request, HttpServletResponse response) throws JSONException {
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		emp_formatdate = GetSession("formatdate_name", request);
		emp_formattime = GetSession("formattime_name", request);

		if (!inputObj.isNull("requesttype")) {
			requesttype = inputObj.getString("requesttype");
		}

		switch (requesttype) {
			case "add" :
				SOP("coming");
				getValues(inputObj);
				addFields(response);
				break;

			case "update" :
				getValues(inputObj);
				addFields(response);
				break;

			case "delete" :
				if (!inputObj.isNull("pmtype_id")) {
					pmtype_id = inputObj.getString("pmtype_id");
				}
				if (!pmtype_id.equals("0")) {
					deleteFields(pmtype_id);
				}
				break;
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("pmtype_id")) {
			pmtype_id = CNumeric(inputObj.getString("pmtype_id"));
		}
		if (!inputObj.isNull("pmtype_entry_date")) {
			pmtype_entry_date = PadQuotes(inputObj.getString("pmtype_entry_date"));
		}
		if (!inputObj.isNull("pmtype_entry_id")) {
			pmtype_entry_id = CNumeric(inputObj.getString("pmtype_entry_id"));
		}
		if (!inputObj.isNull("pmtype_modified_date")) {
			pmtype_modified_date = PadQuotes(inputObj.getString("pmtype_modified_date"));
		}
		if (!inputObj.isNull("pmtype_modified_id")) {
			pmtype_modified_id = CNumeric(inputObj.getString("pmtype_modified_id"));
		}
		if (!inputObj.isNull("pmtype_name")) {
			pmtype_name = PadQuotes(inputObj.getString("pmtype_name"));
		}
	}

	public void chechForm() {
		if (pmtype_name.equals("")) {
			msg += "Enter Project Name!";
		}
	}

	public void addFields(HttpServletResponse response) throws JSONException {
		chechForm();
		if (msg.equals("")) {
			AxelaPmType axelapmtype = new AxelaPmType();
			axelapmtype.setPmtypeId(Integer.parseInt(pmtype_id));
			axelapmtype.setPmtypeEntryDate(pmtype_entry_date);
			axelapmtype.setPmtypeEntryId(Integer.parseInt(pmtype_entry_id));
			axelapmtype.setPmtypeModifiedDate(pmtype_modified_date);
			axelapmtype.setPmtypeModifiedId(Integer.parseInt(pmtype_modified_id));
			axelapmtype.setPmtypeName(pmtype_name);
			axelapmtyperepository.save(axelapmtype);
			if (pmtype_id.equals("0")) {
				output.put("successmsg", "Type Added Successfully");
			}
			else {
				output.put("successmsg", "Type updated Successfully");
			}
		}
		else {
			response.setStatus(400);
			output.put("errormsg", msg);
		}
	}

	public void deleteFields(String pmtype_id) throws JSONException {
		axelapmtyperepository.delete(Integer.parseInt(pmtype_id));
		output.put("successmsg", "type deleted successfully");
	}

	public ArrayList<HashMap<String, String>> listData(int pageNumber) {
		System.out.println("listData");
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

		PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.ASC, "pmtypeId");
		for (AxelaPmType obj : axelapmtyperepository.findAll(request).getContent()) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("pmtype_id", String.valueOf(obj.getPmtypeId()));
			map.put("pmtype_name", String.valueOf(obj.getPmtypeName()));
			list.add(map);
		}

		return list;
	}

}
