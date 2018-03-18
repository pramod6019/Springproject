package axela.portal.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.config.Connect;
import axela.portal.model.AxelaEmpAccess;
import axela.portal.model.AxelaModuleAccess;
import axela.portal.repository.EmpAccessRepository;
import axela.portal.repository.EmpFilterImpl;
import axela.portal.repository.ModuleRepository;
import axela.portal.repository.PortalFilterImpl;

@Service
public class ExecutiveAccessService extends Connect {

	public String empId = "0";
	public StringBuilder str = new StringBuilder();
	public String strSearch = "";
	public static List<String> compModule = new ArrayList<String>();
	public static List<String> modulesNameArr = new ArrayList<String>();

	@Autowired
	ModuleRepository moduleRepository;

	@Autowired
	EmpFilterImpl empFilterImpl;

	@Autowired
	PortalFilterImpl portalFilterImpl;

	@Autowired
	EmpAccessRepository empAccessRepository;

	public List listData(String input, HttpSession session) throws JSONException {
		JSONObject inputObj = new JSONObject(input);
		String executiveId = "0";
		List<Map> list1 = new ArrayList<Map>();
		if (AppRun().equals("0")) {
			SOP("inputObj==========opprServiceUpdate==========" + inputObj.toString(1));
		}
		empId = CNumeric(getSession("empId", session));

		if (!empId.equals("0")) {
			if (!inputObj.isNull("executiveId")) {
				executiveId = inputObj.getString("executiveId");
			}
			if (!executiveId.equals("0")) {
				String modSearch = "";
				str = new StringBuilder();
				modSearch = "";
				compModule = new ArrayList<String>();
				modulesNameArr = new ArrayList<String>();
				empFilterImpl.findTopAccess(1);
				compModule = moduleRepository.FindAllModuleNames();
				for (int i = 0; i < compModule.size(); i++) {
					str.append("comp.").append(compModule.get(i)).append(", ");
				}
				modulesNameArr = moduleRepository.FindAllOnlyModuleNames();
				strSearch = str.toString();
				strSearch = strSearch.replace("POS", "Pos");
				strSearch = strSearch.replace("PM", "Pm");
				strSearch = strSearch.replace("HCM", "Hcm");
				strSearch = strSearch.replace("Catalogue", "catalogue");
				strSearch = strSearch.replace("HelpDesk", "Helpdesk");
				strSearch = strSearch.substring(0, strSearch.lastIndexOf(","));
				Object[] list = portalFilterImpl.findModulesAccess(strSearch);
				str = new StringBuilder();
				int inc = 0;
				str.append(" AND (");
				for (Object object : list) {
					if ((object + "").equals("1")) {
						str.append("module.moduleName='").append(modulesNameArr.get(inc));
						str.append("' OR ");
					}
					inc++;
				}
				str.append(")");
				modSearch = str.toString();
				List listmodule = new ArrayList();
				List listsubmodule = new ArrayList();
				modSearch = modSearch.substring(0, modSearch.lastIndexOf("OR")) + " )";
				List<AxelaModuleAccess> axelaModuleAccess = portalFilterImpl.findAllAccessRights(Integer.parseInt(executiveId), modSearch);
				for (AxelaModuleAccess obj : axelaModuleAccess) {
					Map map1 = null;
					Map map2 = null;
					Map map3 = new LinkedHashMap();
					ArrayList<Map> list2 = null;
					ArrayList list3 = null;
					String module = obj.getModuleName();
					String subModuleId = toTitleCase(obj.getAccessName().substring(obj.getAccessName().indexOf("_") + 1, obj.getAccessName().lastIndexOf("_")).replace("_", " "));
					if (listmodule.contains(module)) {
						for (Map m : list1) {
							if (m.get("module").equals(module)) {
								map1 = m;
								list2 = (ArrayList) map1.get("subModule");
								if (listsubmodule.contains(subModuleId)) {
									for (Map m1 : list2) {
										if (m1.get("name").equals(subModuleId)) {
											map2 = m1;
											list3 = (ArrayList<Map>) map2.get("accessFields");
											break;
										}
									}
								} else {
									listsubmodule.add(subModuleId);
									list3 = new ArrayList();
									map2 = new LinkedHashMap();
									map2.put("name", subModuleId);
									map2.put("accessFields", list3);
									list2.add(map2);
								}
								break;
							}
						}
					} else {
						list2 = new ArrayList();
						list3 = new ArrayList();
						map2 = new LinkedHashMap();
						map1 = new LinkedHashMap();
						listmodule.add(module);
						listsubmodule.add(subModuleId);
						map2.put("name", subModuleId);
						map2.put("accessFields", list3);
						list2.add(map2);
						map1.put("module", module);
						map1.put("subModule", list2);
						list1.add(map1);
					}
					if (map1 == null) {
						listmodule.add(module);
						map1 = new LinkedHashMap();
						list2 = new ArrayList();
						map1.put("module", module);
						map1.put("subModule", list2);
						list1.add(map1);
					}
					if (list2 == null) {
						list2 = new ArrayList();
						listmodule.add(module);
						map1.put("module", module);
						map1.put("subModule", list2);
					}
					if (map2 == null) {
						map2 = new LinkedHashMap();
						map2.put("name", subModuleId);
						list2.add(map2);
					}
					if (list3 == null) {
						list3 = new ArrayList();
						listsubmodule.add(subModuleId);
						map2.put("name", subModuleId);
						map2.put("accessFields", list3);
					}
					map3.put("fieldName", toTitleCase(obj.getAccessName().substring(obj.getAccessName().lastIndexOf("_") + 1, obj.getAccessName().length())));
					if (CNumeric(obj.getEmpaccessAccessId() + "").equals("0")) {
						map3.put("value", "0");
					} else {
						map3.put("value", "1");
					}
					map3.put("name", obj.getAccessId());
					list3.add(map3);
				}
			}
		}
		return list1;
	}

	public Map updateExecutive(String input, HttpSession session) throws JSONException {
		Map output = new HashMap<String, String>();
		JSONObject inputObj = new JSONObject(input);
		String requestType = "";
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		if (requestType.equals("update")) {
			output = UpdateAccessRight(input);
		}
		return output;
	}

	private Map UpdateAccessRight(String input) throws JSONException {
		Map map = new HashMap();
		JSONArray acessRightsArr = new JSONArray();
		String executiveId = "0";
		JSONObject inputObj = new JSONObject(input);
		if (!inputObj.isNull("acessRightsArr")) {
			if (inputObj.get("acessRightsArr") instanceof JSONArray)
				acessRightsArr = inputObj.getJSONArray("acessRightsArr");
		}
		if (!inputObj.isNull("executiveId")) {
			executiveId = inputObj.getString("executiveId");
		}
		if (!executiveId.equals("0")) {
			empAccessRepository.deleteByEmpId(Integer.parseInt(executiveId));
			for (int i = 0; i < acessRightsArr.length(); i++) {
				AxelaEmpAccess axelaEmpAccess = new AxelaEmpAccess();
				JSONObject obj = acessRightsArr.getJSONObject(i);
				axelaEmpAccess.setEmpaccessEmpId(Integer.parseInt(executiveId));
				axelaEmpAccess.setEmpaccessAccessId(Integer.parseInt(CNumeric(obj.get("name") + "")));
				empAccessRepository.save(axelaEmpAccess);
			}
			if (!executiveId.equals("0")) {
				map.put("successmsg", "Executive Access Rights Updated Successfully!");
			}

		} else {
			map.put("errormsg", "Invalid Executive ID");
		}
		return map;
	}
}
