/**
 * 
 */
package axela.accounting.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import axela.accounting.model.AxelaAccVoucher;
import axela.accounting.repository.VoucherFilterImpl;
import axela.config.Connect;
import axela.sales.model.AxelaSalesOppr;

/**
 * @author Sharath
 *
 */
@Service
public class VoucherService extends Connect {

	Map output = new HashMap();
	private JSONObject inputObj;
	private int empId;
	private String perPage = "";
	public String app = "";
	@Autowired
	VoucherFilterImpl voucherFilterImpl;

	public Map voucherUpdate(String input, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws JSONException {

		return output;

	}

	public Map listData(String input, HttpSession session) throws JSONException {
		// checkPerm("emp_voucher_access", session);
		SOP("checkPerm(emp_voucher_access, session)==============" + checkPerm("emp_voucher_access,emp_voucher_add,emp_voucher_edit,emp_export_access", session) + "");
		// if (AppRun().equals("0")) {
		// SOP("input========================" + new JSONObject(input));
		// }
		String customerName = getSession("configCustomerName", session);
		String configSalesOpprName = getSession("configSalesOpprName", session);
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		String strSearch = "";
		String strOrderBy = "";
		String requestType = "";
		int page = 0;
		String branchAccess = "";
		String exeAccess = "";
		String orderType = "";
		String orderByField = "";
		DecimalFormat df = new DecimalFormat("0.00");
		String voucherTypeId = "0", voucherClassId = "0";
		ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
		List<HashMap> listBody = new ArrayList<HashMap>();
		List<HashMap> listAction = new ArrayList<HashMap>();
		ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		output = new LinkedHashMap<String, String>();
		if (empId != 0) {
			String access = "";
			if (!returnPerm("emp_acc_voucher_access", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			page = 0;
			if (!inputObj.isNull("requestType")) {
				requestType = PadQuotes((inputObj.getString("requestType")));
			}
			if (!inputObj.isNull("sortField")) {
				orderByField = PadQuotes((inputObj.getString("sortField")));
			}
			if (!inputObj.isNull("pageIndex")) {
				page = Integer.parseInt(CNumeric(PadQuotes((inputObj.getString("pageIndex")))));
			}
			if (!inputObj.isNull("sortDirection")) {
				orderType = PadQuotes((inputObj.getString("sortDirection"))).toUpperCase();
			}
			perPage = CNumeric(getSession("empRecperpage", session));
			if (orderType.equals("")) {
				orderType = "DESC";
			}
			if (orderByField.equals("")) {
				orderByField = "voucherId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			if (!inputObj.isNull("voucherTypeId")) {
				voucherTypeId = CNumeric(PadQuotes((inputObj.getString("voucherTypeId"))));
			}
			if (!inputObj.isNull("voucherClassId")) {
				voucherClassId = CNumeric(PadQuotes((inputObj.getString("voucherClassId"))));
			}
			page++;
			// Start Header Data
			listHeader.add(produceHeaderData("ID", "voucherId", "center"));
			listHeader.add(produceHeaderData("No.", "voucherNo", "center"));
			listHeader.add(produceHeaderData("Voucher", "opprRefNo", "center"));
			// listHeader.add(produceHeaderData("Ledger", "voucherCustomerId", "center"));
			listHeader.add(produceHeaderData("Customer", "voucherContactId", "center"));
			listHeader.add(produceHeaderData("Ref.No", "voucherRefNo", "center"));
			listHeader.add(produceHeaderData("Narration", "voucherNarration", "center"));
			listHeader.add(produceHeaderData("Date", "voucherDate", "center"));
			listHeader.add(produceHeaderData("Amount", "voucherAmount", "center"));
			listHeader.add(produceHeaderData("Executive", "emp.empName", "center"));
			listHeader.add(produceHeaderData("Branch", "branch.branchName", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			// listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("Center"));
			listBodyAlign.add(produceBodyAlign("Right"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align

			branchAccess = getSession("branchAccess", session).replaceAll("branchId", "voucher.voucherBranchId");
			exeAccess = getSession("exeAccess", session).replaceAll("empId", "voucher.voucherEmpId");
			if (!voucherTypeId.equals("0")) {
				strSearch += " AND voucher.voucherVouchertypeId = " + voucherTypeId;
				strSearch += branchAccess + exeAccess;
				strOrderBy = " ORDER BY voucher." + orderByField + " " + orderType + "";
				List<AxelaAccVoucher> resultSet = voucherFilterImpl.findAll(voucherTypeId, strSearch, strOrderBy, page, Integer.parseInt(perPage), app);
				SOP("resultSet================" + resultSet.indexOf(0));
				int count = 0;
				StringBuilder dataString = null;
				String totalCount = voucherFilterImpl.totalCount;
				Map<String, String> mapNavi = pageNavi(Integer.parseInt(totalCount), input, perPage);
				for (AxelaAccVoucher obj : resultSet) {
					ArrayList<String> paramSubArr = new ArrayList<String>();
					ArrayList<ArrayList> paramArr = new ArrayList<ArrayList>();
					ArrayList type = new ArrayList();
					ArrayList value = new ArrayList();
					HashMap<String, List<HashMap>> mapData = new HashMap<String, List<HashMap>>();
					HashMap<String, List<HashMap>> mapAction = new HashMap<String, List<HashMap>>();
					HashMap<String, List<String>> mapBodyData = new HashMap<String, List<String>>();
					List<HashMap> listData = new ArrayList<HashMap>();
					count++;
					// Start Body data
					// count
					type.add(false);
					value.add(count);
					listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					// VoucherId
					type.add(true);
					value.add(obj.getVoucherId());
					if (voucherTypeId.equals("4")) {
						paramSubArr.add("salesOrder");
						paramSubArr.add(obj.getVoucherId() + "");
						paramSubArr.add(obj.getVoucherVouchertypeId() + "");
						paramSubArr.add(voucherClassId);
						paramArr.add(paramSubArr);
						paramSubArr.clear();
					} else if (voucherTypeId.equals("5")) {
						paramSubArr.add("quote");
						paramSubArr.add(obj.getVoucherId() + "");
						paramSubArr.add(obj.getVoucherVouchertypeId() + "");
						paramSubArr.add(voucherClassId);
						paramArr.add(paramSubArr);
						paramSubArr.clear();
					} else if (voucherTypeId.equals("6")) {
						paramSubArr.add("salesInvoice");
						paramSubArr.add(obj.getVoucherId() + "");
						paramSubArr.add(obj.getVoucherVouchertypeId() + "");
						paramSubArr.add(voucherClassId);
						paramArr.add(paramSubArr);
						paramSubArr.clear();
					} else if (voucherTypeId.equals("9")) {
						paramSubArr.add("receipt");
						paramSubArr.add(obj.getVoucherId() + "");
						paramSubArr.add(obj.getVoucherVouchertypeId() + "");
						paramSubArr.add(voucherClassId);
						paramArr.add(paramSubArr);
						paramSubArr.clear();
					} else if (voucherTypeId.equals("7")) {
						paramSubArr.add("bill");
						paramSubArr.add(obj.getVoucherId() + "");
						paramSubArr.add(obj.getVoucherVouchertypeId() + "");
						paramSubArr.add(voucherClassId);
						paramArr.add(paramSubArr);
						paramSubArr.clear();
					}
					listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					paramArr.clear();
					// voucherNo
					type.add(true);
					value.add(obj.getVoucherId());
					paramSubArr.add("voucherList");
					paramSubArr.add(obj.getVoucherId() + "");
					paramArr.add(paramSubArr);
					paramSubArr.clear();
					listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					paramArr.clear();
					// voucher
					if (voucherClassId.equals("4")) {
						type.add(true);
						value.add(obj.getVouchertypeName());
						if (obj.getVoucherAuthorize().equals("1")) {
							value.add("<font color=\"#ff0000\">[Authorized]</font>");
						} else {
							value.add("<font color=\"#ff0000\">[Inactive]</font>");
						}
						paramSubArr.add("salesorderDash");
						paramSubArr.add(obj.getVoucherId() + "");
						paramArr.add(paramSubArr);
						paramSubArr.clear();
						listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
						type.clear();
						value.clear();
						paramArr.clear();
					} else {
						type.add(false);
						value.add(obj.getVouchertypeName());
						if (obj.getVoucherAuthorize().equals("1")) {
							value.add("<font color=\"#ff0000\">[Authorized]</font>");
						} else {
							value.add("<font color=\"#ff0000\">[Inactive]</font>");
						}
						listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
						type.clear();
						value.clear();
						paramArr.clear();
					}
					// Ledger
					// type.add(true);
					// value.add(obj.getVoucherId());
					// paramSubArr.add("voucherList");
					// paramSubArr.add(obj.getVoucherId() + "");
					// paramArr.add(paramSubArr);
					// paramSubArr.clear();
					// listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					// type.clear();
					// value.clear();
					// paramArr.clear();
					// Customer
					if (obj.getVoucherCustomerId() != 0) {
						type.add(true);
						value.add(obj.getCustomerName());
						paramSubArr.add("customerList");
						paramSubArr.add(obj.getVoucherCustomerId() + "");
						paramArr.add(paramSubArr);
						paramSubArr.clear();
					}
					if (obj.getVoucherContactId() != 0) {
						type.add(true);
						value.add(obj.getContactFname() + obj.getContactLname());
						paramSubArr.add("contactList");
						paramSubArr.add(obj.getVoucherContactId() + "");
						paramArr.add(paramSubArr);
						paramSubArr.clear();
					}
					if (!obj.getContactMobile1().equals("")) {
						type.add(false);
						value.add(obj.getContactMobile1());
						paramArr.add(paramSubArr);
					}
					if (!obj.getContactMobile2().equals("")) {
						type.add(false);
						value.add(obj.getContactMobile2());
						paramArr.add(paramSubArr);
					}
					if (!obj.getContactEmail1().equals("")) {
						type.add(false);
						value.add(obj.getContactEmail1());
						paramArr.add(paramSubArr);
					}
					if (!obj.getContactEmail2().equals("")) {
						type.add(false);
						value.add(obj.getContactEmail2());
						paramArr.add(paramSubArr);
					}
					listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					paramArr.clear();
					// voucher ref.no
					type.add(false);
					value.add(obj.getVoucherRefNo());
					listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					paramArr.clear();
					// voucher Narration
					type.add(false);
					value.add(obj.getVoucherNarration());
					listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					paramArr.clear();
					// voucher Date
					type.add(false);
					value.add(obj.getVoucherDate());
					listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					paramArr.clear();
					// voucher ammount
					type.add(false);
					value.add(obj.getVoucherAmount());
					listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					paramArr.clear();
					// voucher Executive
					type.add(true);
					value.add(obj.getEmpName());
					paramSubArr.add("executiveSummary");
					paramSubArr.add(obj.getEmpId() + "");
					paramArr.add(paramSubArr);
					listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					paramArr.clear();
					// voucher Branch
					type.add(true);
					value.add(obj.getEmpName());
					paramSubArr.add("branchSummary");
					paramSubArr.add(obj.getEmpId() + "");
					paramArr.add(paramSubArr);
					listData.add(produceBodyData(false, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
					type.clear();
					value.clear();
					paramArr.clear();
					mapData.put("td", listData);
					ArrayList actionParam = new ArrayList();
					actionParam.add("updateVoucher");
					actionParam.add(voucherTypeId);
					actionParam.add(voucherClassId);
					actionParam.add(obj.getVoucherId());
					mapAction.put("td", produceActionData(actionParam));
					listAction.add(mapAction);
					listBody.add(mapData);
				}
				output.put("meta", mapNavi);
				output.put("action", listAction);
				output.put("tdalign", listBodyAlign);
				output.put("thead", listHeader);
				output.put("tbody", listBody);
			}
		}
		return output;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<HashMap> produceActionData(ArrayList<String> Param) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Opportunity");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Add Quote");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());

		mapBodyData.put("value", "Add Sales Order");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());

		return listAction;
	}
}
