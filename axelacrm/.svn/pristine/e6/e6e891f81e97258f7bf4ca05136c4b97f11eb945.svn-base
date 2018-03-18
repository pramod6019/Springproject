package axela.portal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.portal.repository.AxelaRateClassRepository;
import axela.portal.repository.BranchTypeRepository;
import axela.portal.repository.FranchiseeRepository;

@Service
public class PortalPopulateService extends Connect {
	HashMap output = null;
	JSONObject inputObj = null;

	@Autowired
	BranchTypeRepository branchTypeRepository;

	@Autowired
	FranchiseeRepository franchiseeRepository;

	@Autowired
	AxelaRateClassRepository axelaRateClassRepository;

	public Map<String, List> populateBranchType() {
		output = new HashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (Object[] BranchType : branchTypeRepository.populateByBranchTypeIdAndName()) {
			HashMap map = new HashMap();
			map.put("key", BranchType[0] + "");
			map.put("name", BranchType[1] + "");
			list.add(map);
		}
		output.put("populateBranchType", list);
		return output;
	}
	public Map<String, List> populateFranchisee() {
		output = new HashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (Object[] Franchisee : franchiseeRepository.populateByfranchiseeIdAndFranchiseeName()) {
			HashMap map = new HashMap();
			map.put("key", Franchisee[0].toString());
			map.put("name", Franchisee[1].toString());
			list.add(map);
		}
		output.put("populateFranchisee", list);
		return output;
	}
	public Map<String, List> populateClass() {
		output = new HashMap<String, List>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (Object[] Class : axelaRateClassRepository.populateByRateclassIdAndRateClassName()) {
			HashMap map = new HashMap();
			map.put("key", Class[0].toString());
			map.put("name", Class[1].toString());
			list.add(map);
		}
		output.put("populateClass", list);
		return output;
	}
}
