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
import axela.inventory.model.AxelaInventoryGroup;
import axela.inventory.repository.AxelaItemGroupRepository;

@Service
public class ItemGroupService extends Connect {
	private final static int PAGESIZE = 25;
	public String group_id = "0";
	public String group_active = "";
	public String group_desc = "";
	public String group_entry_date = "";
	public String group_entry_id = "0";
	public String group_img = "";
	public String group_modified_date = "";
	public String group_modified_id = "0";
	public String group_name = "";
	public String group_rank = "0";
	public String group_type = "0";
	public String requesttype = "";
	public String msg = "";
	public String pageNumber = "";

	HashMap<String, String> output = null;
	JSONObject inputObj = null;
	@Autowired
	private AxelaItemGroupRepository axelaitemgrouprepository;

	public Map<String, String> ItemGroupsService(String input, HttpServletResponse response) throws JSONException {
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
				if (!inputObj.isNull("group_id")) {
					group_id = inputObj.getString("group_id");
				}
				if (!group_id.equals("0")) {
					deleteFields(group_id);
				}
				break;

		}
		return output;
	}
	public void getValues(JSONObject inputObj) throws JSONException {

		msg = "";

		if (!inputObj.isNull("group_id")) {
			group_id = CNumeric(inputObj.getString("group_id"));
		}

		if (!inputObj.isNull("group_active")) {
			group_active = PadQuotes(inputObj.getString("group_active"));
		}
		if (!inputObj.isNull("group_desc")) {
			group_desc = PadQuotes(inputObj.getString("group_desc"));
		}
		if (!inputObj.isNull("group_entry_date")) {
			group_entry_date = PadQuotes(inputObj.getString("group_entry_date"));
		}
		if (!inputObj.isNull("group_entry_id")) {
			group_entry_id = CNumeric(inputObj.getString("group_entry_id"));
		}

		if (!inputObj.isNull("group_img")) {
			group_img = PadQuotes(inputObj.getString("group_img"));
		}
		if (!inputObj.isNull("group_modified_date")) {
			group_modified_date = PadQuotes(inputObj.getString("group_modified_date"));
		}
		if (!inputObj.isNull("group_modified_id")) {
			group_modified_id = CNumeric(inputObj.getString("group_modified_id"));
		}
		if (!inputObj.isNull("group_name")) {
			group_name = PadQuotes(inputObj.getString("group_name"));
		}

		if (!inputObj.isNull("group_rank")) {
			group_rank = CNumeric(inputObj.getString("group_rank"));
		}
		if (!inputObj.isNull("group_type")) {
			group_type = CNumeric(inputObj.getString("group_type"));
		}

	}

	public void checkForm() {

		if (group_name.equals("")) {
			msg += "<br>Enter the Item Group Name!";
		} else {
			List<AxelaInventoryGroup> obj = axelaitemgrouprepository.findByGroupName(group_name);
			if (!obj.isEmpty()) {
				msg += "<br>Similar Item Group found!";
			}
		}
		if (group_type.equals("0")) {
			msg += "<br>Select Item Group Type!";
		}
	}

	public void addFields(HttpServletResponse response) {

		checkForm();
		if (msg.equals("")) {
			AxelaInventoryGroup axelainventorygroup = new AxelaInventoryGroup();

			axelainventorygroup.setGroupId(Integer.parseInt(group_id));
			axelainventorygroup.setGroupActive(group_active);
			axelainventorygroup.setGroupDesc(group_desc);
			axelainventorygroup.setGroupEntryDate(group_entry_date);
			axelainventorygroup.setGroupEntryId(Integer.parseInt(group_entry_id));
			axelainventorygroup.setGroupModifiedDate(group_modified_date);
			axelainventorygroup.setGroupModifiedId(Integer.parseInt(group_modified_id));
			axelainventorygroup.setGroupName(group_name);
			axelainventorygroup.setGroupRank(axelaitemgrouprepository.findrank());
			axelainventorygroup.setGroupType(Integer.parseInt(group_type));
			axelaitemgrouprepository.save(axelainventorygroup);

			if (group_id.equals("0")) { // if id = 0 -> add mode else update mode
				output.put("successmsg", "group Added Successfully!");
			} else {
				output.put("successmsg", "group Updated Successfully!");
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}

	}
	public void deleteFields(String soe_id) {
		axelaitemgrouprepository.delete(Integer.parseInt(group_id));
		output.put("succesmsg", "group Deleted Successfully!");
	}
	public ArrayList<HashMap<String, String>> listData(int pageNumber) {
		System.out.println("lisData");
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		if (pageNumber >= 11) {
			output.put("msg", "No Records Found!");
		} else {
			PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.ASC, "groupId");
			for (AxelaInventoryGroup obj : axelaitemgrouprepository.findAll(request).getContent()) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("group_id", String.valueOf(obj.getGroupId()));
				map.put("group_name", String.valueOf(obj.getGroupName()));

				list.add(map);
			}

		}
		return list;
	}

}
