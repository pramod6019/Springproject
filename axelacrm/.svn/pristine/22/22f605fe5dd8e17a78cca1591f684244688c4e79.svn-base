package axela.app.sales.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.inventory.model.AxelaInventoryItemModel;
import axela.inventory.repository.InventoryItemModelRepository;
import axela.portal.model.AxelaBranch;
import axela.portal.repository.BranchRepository;

@Service
public class AppOpprFilter extends Connect {

	private JSONObject inputObj = null;
	private HashMap output = null;
	private int empId = 0;
	private String requestType = "";

	@Autowired
	InventoryItemModelRepository inventoryItemModelRepository;

	@Autowired
	private BranchRepository branchRepository;

	public Map opprServiceUpdate(String input, HttpServletResponse response, HttpSession session) throws JSONException {
		inputObj = new JSONObject(input);
		if (AppRun().equals("0")) {
			SOP("inputObj==========OpprDashService==========" + inputObj.toString(1));
		}
		output = new HashMap();
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		SOP("empId====================" + empId);
		// if (empId != 0) {
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}

		switch (requestType) {
			case "branch" :
				populateBranch(input, session);// populate Branch
				break;

			case "2" :// populate Branch
				break;

			case "3" :// populate Branch
				break;

			case "4" :// populate Branch
				break;
			case "5" :// populate Branch
				break;
		}
		// }
		return output;
	}

	public Map<String, String> populateBranch(String input, HttpSession session) throws JSONException {
		inputObj = new JSONObject(input);
		SOP("inputObj===============" + inputObj.toString(2));
		output = new HashMap();
		empId = 0;
		List<AxelaBranch> axelaBranch = null;
		String branchAccess = PadQuotes(getSession("branchAccess", session));
		axelaBranch = branchRepository.findAll();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (AxelaBranch branch : axelaBranch) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("axelaBranch.branchId", "" + branch.getBranchId());
			map.put("axelaBranch.branchName", branch.getBranchName());
			list.add(map);
		}
		output.put("populateBranch", list);
		if (AppRun().equals("0")) {
			SOP("inputObj===============" + output);
		}
		return output;
	}

	public Map<String, List> populateOpportunityModel(String input) throws JSONException {
		inputObj = new JSONObject(input);
		output = new HashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		List<AxelaInventoryItemModel> axelaInventoryItemModel = null;
		axelaInventoryItemModel = inventoryItemModelRepository.findAllByOder();
		for (AxelaInventoryItemModel axelaInventoryItemModels : axelaInventoryItemModel) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("key", "" + axelaInventoryItemModels.getModelId());
			map.put("name", axelaInventoryItemModels.getModelName());
			list.add(map);
		}
		output.put("populateOpportunityModel", list);
		if (AppRun().equals("0")) {
			SOP("inputObj===============" + output);
		}
		return output;
	}
}
