package axela.portal.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import axela.accounting.repository.AccVoucherRepository;
import axela.config.Connect;
import axela.customer.repository.CustomerRepository;
import axela.portal.model.AxelaBranch;
import axela.portal.repository.AssetContractRepository;
import axela.portal.repository.AxelaholiRepository;
import axela.portal.repository.BillCounterRepository;
import axela.portal.repository.BranchRepository;
import axela.portal.repository.CompRepository;
import axela.portal.repository.EmpRepository;
import axela.portal.repository.NewsBranchRepository;
import axela.portal.repository.PortalBranchFilterImpl;
import axela.sales.repository.OpprRepository;
import axela.service.repository.JCRepository;
import axela.service.repository.ProdJobCardRepository;
import axela.service.repository.ServiceContractRepository;

@Service
public class BranchService extends Connect {

	@Autowired
	PortalBranchFilterImpl portalbranchFilterImpl;
	@Autowired
	BranchRepository branchRepository;
	@Autowired
	CompRepository axelaCompRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	OpprRepository opprRepository;
	@Autowired
	AccVoucherRepository accVoucherRepository;
	@Autowired
	JCRepository jCRepository;
	@Autowired
	BillCounterRepository billCounterRepository;
	@Autowired
	ServiceContractRepository serviceContractRepository;
	@Autowired
	AssetContractRepository assetContractRepository;
	@Autowired
	EmpRepository empRepository;
	@Autowired
	AxelaholiRepository axelaholiRepository;
	@Autowired
	NewsBranchRepository newsBranchRepository;
	@Autowired
	ProdJobCardRepository prodJobCardRepository;

	public String branchId = "0";
	public String branchActive = "1";
	public String active = "";
	public String branchAdd = "";
	public String branchBillFooter = "";
	public String branchBillHeader = "";
	public String branchBillPrefix = "";
	public String branchBranchtypeId = "0";
	public String branchCityId = "0";
	public String branchCode = "";
	public String branchSoPrefix = "";
	public int empId = 0;
	public String compId = "0";
	public String branchInvoicePrefix = "";
	public String branchInvoiceSuffix = "";
	public String configCustomerName = "";
	public String empFormatdate = "";
	public String empFormattime = "";
	public String requestType = "";
	public String branchCst = "";
	public String branchEmail1 = "";
	public String branchEmail2 = "";
	public String branchReceiptPrefix = "";
	public String branchReceiptSuffix = "";
	public String branchEntryDate = "";
	public String branchEntryId = "0";
	public String branchFranchiseeId = "0";
	public String branchGst = "";
	public String branchJcPrefix = "";
	public String branchInvoiceDesc = "";
	public String branchInvoiceName = "";
	public String branchInvoiceTerms = "";
	public String branchLocationId = "0";
	public String branchMailPassword = "";
	public String branchMailPort = "";
	public String branchMailServer = "";
	public String branchMailSsl = "";
	public String branchMailUsername = "";
	public String branchMobile1 = "";
	public String branchMobile2 = "";
	public String branchModifiedDate = "";
	public String branchModifiedId = "0";
	public String branchName = "";
	public String branchNotes = "";
	public String branchPanNo = "";
	public String branchPhone1 = "";
	public String branchPhone2 = "";
	public String branchPin = "";
	public String branchQuoteDesc = "";
	public String branchQuoteTerms = "";
	public String branchRateclassId = "0";
	public String branchReceiptDesc = "";
	public String branchServiceTaxNo = "";
	public String branchSoDesc = "";
	public String branchSoTerms = "";
	public String branchTanNo = "";
	public String branchTinNo = "";
	public String perPage = "0";
	public String branchAccess = "";
	public String exeAccess = "";
	public String field = "";
	public int page = 0;
	public String group = "";
	public String tag = "Branch";
	public String sort = "";
	public String strSearch = "";
	public String msg = "";
	public int activeBranchcount = 0;
	public int branchCount = 0;
	public String length = "";
	public String branchVat = "";
	public String StrSql = "";
	public String pageNumber = "";
	public String perpage = "0";
	public String orderType = "";
	public String orderByField = "";
	public String strOrderBy = "";

	HashMap output = null;
	JSONObject inputObj = null;

	public Map<String, String> branchService(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		if (AppRun().equals("0")) {
			SOP("input==========BranchService===============" + input);
		}
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		configCustomerName = getSession("configCustomerName", session);
		branchId = CNumeric(PadQuotes(getSession("empBranchId", session)));
		empFormatdate = getSession("empFormatdate", session);
		empFormattime = getSession("empFormattime", session);
		inputObj = new JSONObject(input);
		output = new HashMap<String, String>();
		if (!inputObj.isNull("requestType")) {
			requestType = inputObj.getString("requestType");
		}
		populateConfigDetails();
		if (empId != 0) {
			if (!returnPerm("emp_role_id", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			switch (requestType) {

				case "add" : // add
					if (!returnPerm("emp_role_id", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					branchId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;

				case "update" :// update
					if (!returnPerm("emp_role_id", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					branchId = "0";
					getValues(inputObj);
					addFields(response, session);
					break;

				case "delete" :// delete
					if (!returnPerm("emp_role_id", session)) {
						output.put("errorPage", "Access denied. Please contact system administrator!");
						return output;
					}
					if (!inputObj.isNull("branchId")) {
						branchId = CNumeric(PadQuotes(inputObj.getString("branchId")));
					}
					if (!branchId.equals("0")) {
						deleteFields(Integer.parseInt(branchId));
					}
					break;
			}
		}
		if (AppRun().equals("0")) {
			SOP("output==========BranchService===============" + output);
		}
		return output;
	}

	public void getValues(JSONObject inputObj) throws JSONException {
		msg = "";
		if (!inputObj.isNull("branchId")) {
			branchId = CNumeric(PadQuotes(inputObj.getString("branchId")));
		}
		if (!inputObj.isNull("branchName")) {
			branchName = PadQuotes(inputObj.getString("branchName"));
		}
		if (!inputObj.isNull("branchInvoiceName")) {
			branchInvoiceName = PadQuotes(inputObj.getString("branchInvoiceName"));
		}
		if (!inputObj.isNull("branchCode")) {
			branchCode = PadQuotes(inputObj.getString("branchCode"));
		}
		if (!inputObj.isNull("branchGst")) {
			branchGst = PadQuotes(inputObj.getString("branchGst"));
		}
		if (!inputObj.isNull("branchVat")) {
			branchVat = PadQuotes(inputObj.getString("branchVat"));
		}
		if (!inputObj.isNull("branchCst")) {
			branchCst = PadQuotes(inputObj.getString("branchCst"));
		}
		if (!inputObj.isNull("branchBranchtypeId")) {
			branchBranchtypeId = CNumeric(PadQuotes(inputObj.getString("branchBranchtypeId")));
		}
		if (!inputObj.isNull("branchFranchiseeId")) {
			branchFranchiseeId = CNumeric(PadQuotes(inputObj.getString("branchFranchiseeId")));
		}
		if (!inputObj.isNull("branchRateclassId")) {
			branchRateclassId = CNumeric(PadQuotes(inputObj.getString("branchRateclassId")));
		}
		if (!inputObj.isNull("branchLocationId")) {
			branchLocationId = CNumeric(PadQuotes(inputObj.getString("branchLocationId")));
		}
		if (!inputObj.isNull("branchPhone1")) {
			branchPhone1 = PadQuotes(inputObj.getString("branchPhone1"));
		}
		if (!inputObj.isNull("branchPhone2")) {
			branchPhone2 = PadQuotes(inputObj.getString("branchPhone2"));
		}
		if (!inputObj.isNull("branchMobile1")) {
			branchMobile1 = PadQuotes(inputObj.getString("branchMobile1"));
		}
		if (!inputObj.isNull("branchMobile2")) {
			branchMobile2 = PadQuotes(inputObj.getString("branchMobile2"));
		}
		if (!inputObj.isNull("branchEmail1")) {
			branchEmail1 = PadQuotes(inputObj.getString("branchEmail1"));
		}
		if (!inputObj.isNull("branchEmail2")) {
			branchEmail2 = PadQuotes(inputObj.getString("branchEmail2"));
		}
		if (!inputObj.isNull("branchAdd")) {
			branchAdd = PadQuotes(inputObj.getString("branchAdd"));
		}
		if (!inputObj.isNull("branchCityId")) {
			branchCityId = CNumeric(PadQuotes(inputObj.getString("branchCityId")));
		}
		if (!inputObj.isNull("branchPin")) {
			branchPin = PadQuotes(inputObj.getString("branchPin"));
		}
		if (!inputObj.isNull("branchPanNo")) {
			branchPanNo = PadQuotes(inputObj.getString("branchPanNo"));
		}
		if (!inputObj.isNull("branchNotes")) {
			branchNotes = PadQuotes(inputObj.getString("branchNotes"));
			if (branchNotes.length() > 5000) {
				branchNotes = branchNotes.substring(0, 4999);
			}
		}
		if (!inputObj.isNull("branchTanNo")) {
			branchTanNo = PadQuotes(inputObj.getString("branchTanNo"));
		}
		if (!inputObj.isNull("branchTinNo")) {
			branchTinNo = PadQuotes(inputObj.getString("branchTinNo"));
		}
		if (!inputObj.isNull("branchServiceTaxNo")) {
			branchServiceTaxNo = PadQuotes(inputObj.getString("branchServiceTaxNo"));
		}
		if (!inputObj.isNull("branchActive")) {
			branchActive = (inputObj.getString("branchActive")) + "";
		}
		if (!inputObj.isNull("branchQuoteDesc")) {
			branchQuoteDesc = PadQuotes(inputObj.getString("branchQuoteDesc"));
		}
		if (!inputObj.isNull("branchQuoteTerms")) {
			branchQuoteTerms = PadQuotes(inputObj.getString("branchQuoteTerms"));
		}
		if (!inputObj.isNull("branchSoDesc")) {
			branchSoDesc = PadQuotes(inputObj.getString("branchSoDesc"));
		}
		if (!inputObj.isNull("branchSoTerms")) {
			branchSoTerms = PadQuotes(inputObj.getString("branchSoTerms"));
		}
		if (!inputObj.isNull("branchInvoiceDesc")) {
			branchInvoiceDesc = PadQuotes(inputObj.getString("branchInvoiceDesc"));
		}
		if (!inputObj.isNull("branchInvoiceTerms")) {
			branchInvoiceTerms = PadQuotes(inputObj.getString("branchInvoiceTerms"));
		}
		if (!inputObj.isNull("branchReceiptDesc")) {
			branchReceiptDesc = PadQuotes(inputObj.getString("branchReceiptDesc"));
		}
		if (!inputObj.isNull("branchBillHeader")) {
			branchBillHeader = PadQuotes(inputObj.getString("branchBillHeader"));
		}
		if (!inputObj.isNull("branchBillFooter")) {
			branchBillFooter = PadQuotes(inputObj.getString("branchBillFooter"));
		}
		if (!inputObj.isNull("branchBillPrefix")) {
			branchBillPrefix = PadQuotes(inputObj.getString("branchBillPrefix"));
		}
		if (!inputObj.isNull("branchInvoicePrefix")) {
			branchInvoicePrefix = PadQuotes(inputObj.getString("branchInvoicePrefix"));
		}
		if (!inputObj.isNull("branchInvoiceSuffix")) {
			branchInvoiceSuffix = PadQuotes(inputObj.getString("branchInvoiceSuffix"));
		}
		if (!inputObj.isNull("branchJcPrefix")) {
			branchJcPrefix = PadQuotes(inputObj.getString("branchJcPrefix"));
		}
		if (!inputObj.isNull("branchReceiptSuffix")) {
			branchReceiptSuffix = PadQuotes(inputObj.getString("branchReceiptSuffix"));
		}
		if (!inputObj.isNull("branchReceiptPrefix")) {
			branchReceiptPrefix = PadQuotes(inputObj.getString("branchReceiptPrefix"));
		}

		if (!inputObj.isNull("branchSoPrefix")) {
			branchSoPrefix = PadQuotes(inputObj.getString("branchSoPrefix"));
		}

	}

	public void validateFields() {
		msg = "";
		if (requestType.equals("add")) {
			if (activeBranchcount >= branchCount) {
				msg += "<br>Maximum branch count reached!";
			}
		} else if (requestType.equals("Update")) {
			if (active.equals("0") && branchActive.equals("1") && branchCount <= activeBranchcount) {
				msg += "<br>Maximum Branch count reached!";
			}
		}
		if (branchName.equals("")) {
			msg += "<br>Enter Name!";
		} else if (branchName.length() < 3) {
			msg += "<br>Enter Minimum of 3 caharacters for Branch Name!";
		} else if (branchName.length() >= 3) {
			List<AxelaBranch> obj = branchRepository.findByBranchName(branchName, Integer.parseInt(branchId));
			if (!obj.isEmpty()) {
				msg += "<br>Similar Branch Name Found!";
			}
		}
		if (branchInvoiceName.equals("")) {
			msg += "<br>Enter Name on Invoice!";
		}
		if (branchCode.equals("")) {
			msg += "<br>Enter Branch Code!";
		} else {
			List<AxelaBranch> obj = branchRepository.findByBranchCode(branchName, Integer.parseInt(branchId));
			if (!obj.isEmpty()) {
				msg += "<br>Similar Branch Code Found!";
			}
		}
		if (branchGst.equals("")) {
			msg = msg + "<br>Enter GST No!";

		} else if (!branchGst.equals("") && !branchGst.matches("\\d{2}[a-zA-Z]{5}\\d{4}[a-zA-Z]{1}[a-zA-Z0-9]{3}")) {
			msg = msg + "<br>Enter Valid GST No !";
		}
		if (branchVat.equals("")) {
			msg = msg + "<br>Enter Vat!";
		}
		if (branchCst.equals("")) {
			msg = msg + "<br>Enter Cst!";
		}
		if (branchBranchtypeId.equals("0")) {
			msg += "<br>Select Type!";
		}
		if (branchFranchiseeId.equals("0")) {
			msg += "<br>Select Franchisee!";
		}
		if (branchRateclassId.equals("0")) {
			msg += "<br>Select Class!";
		}
		if (branchMobile1.equals("")) {
			msg += "<br>Enter Mobile1!";
		} else if (!IsValidMobileNo(branchMobile1)) {
			msg += "<br>Mobile1 is Invalid!";
		}
		if (!branchMobile2.equals("") && !IsValidMobileNo(branchMobile2)) {
			msg += "<br>Mobile2 is Invalid!";
		}
		if (branchPhone1.equals("")) {
			msg += "<br>Enter Phone1!";
		} else if (!IsValidPhoneNo(branchPhone1)) {
			msg += "<br>Phone1 is Invalid!";
		}
		if (!branchPhone2.equals("") && !IsValidPhoneNo(branchPhone2)) {
			msg += "<br>Phone2 is Invalid!";
		}
		if (branchEmail1.equals("")) {
			msg += "<br>Enter Email1!";
		} else if (!IsValidEmail(branchEmail1)) {
			msg += "<br>Enter Valid Email 1!";
		}
		if (!branchEmail2.equals("") && !IsValidEmail(branchEmail2)) {
			msg += "<br>Enter Valid Email 2!";
		}
		if (branchAdd.equals("")) {
			msg += "<br>Enter Address!";
		}
		if (branchCityId.equals("0")) {
			msg += "<br>Select City!";
		}
		if (branchPin.equals("")) {
			msg += "<br>Enter Pin Code!";
		} else if (!branchPin.equals("") && !isNumeric(branchPin)) {
			msg += "<br>Pin Code: Enter Numeric!";
		}
	}

	public void addFields(HttpServletResponse response, HttpSession session) throws ParseException {
		validateFields();
		AxelaBranch axelabranch = null;
		if (msg.equals("")) {
			if (!branchId.equals("0")) {
				axelabranch = branchRepository.findOne(Integer.parseInt(branchId));
			} else {
				axelabranch = new AxelaBranch();
			}
			if (requestType.equals("add")) {
				branchId = CheckCurrentId(branchRepository.findMaxBranchId()) + "";
			}
			axelabranch.setBranchId(Integer.parseInt(branchId));
			axelabranch.setBranchName(branchName);
			axelabranch.setBranchActive(branchActive);
			axelabranch.setBranchInvoiceName(branchInvoiceName);
			axelabranch.setBranchCode(branchCode);
			axelabranch.setBranchGst(branchGst);
			axelabranch.setBranchVat(branchVat);
			axelabranch.setBranchCst(branchCst);
			axelabranch.setBranchBranchtypeId(Integer.parseInt(branchBranchtypeId));
			axelabranch.setBranchFranchiseeId(Integer.parseInt(branchFranchiseeId));;
			axelabranch.setBranchRateclassId(Integer.parseInt(branchRateclassId));
			axelabranch.setBranchLocationId(Integer.parseInt(branchLocationId));
			axelabranch.setBranchPhone1(branchPhone1);
			axelabranch.setBranchPhone2(branchPhone2);
			axelabranch.setBranchMobile1(branchMobile1);
			axelabranch.setBranchMobile2(branchMobile2);
			axelabranch.setBranchEmail1(branchEmail1);
			axelabranch.setBranchEmail2(branchEmail2);
			axelabranch.setBranchAdd(branchAdd);
			axelabranch.setBranchCityId(Integer.parseInt(branchCityId));
			axelabranch.setBranchMailPassword(branchMailPassword);
			axelabranch.setBranchMailPort(branchMailPort);
			axelabranch.setBranchPin(branchPin);
			axelabranch.setBranchMailSsl(branchMailSsl);
			axelabranch.setBranchMailServer(branchMailServer);
			axelabranch.setBranchMailUsername(branchMailUsername);
			axelabranch.setBranchPanNo(branchPanNo);
			axelabranch.setBranchTanNo(branchTanNo);
			axelabranch.setBranchTinNo(branchTinNo);
			axelabranch.setBranchServiceTaxNo(branchServiceTaxNo);
			axelabranch.setBranchBillFooter(branchBillFooter);
			axelabranch.setBranchBillHeader(branchBillHeader);
			axelabranch.setBranchQuoteDesc(branchQuoteDesc);
			axelabranch.setBranchQuoteTerms(branchQuoteTerms);
			axelabranch.setBranchSoDesc(branchSoDesc);
			axelabranch.setBranchSoTerms(branchSoTerms);
			axelabranch.setBranchInvoiceDesc(branchInvoiceDesc);
			axelabranch.setBranchInvoiceTerms(branchInvoiceTerms);
			axelabranch.setBranchReceiptDesc(branchReceiptDesc);
			axelabranch.setBranchNotes(branchNotes);
			axelabranch.setBranchBillPrefix(branchBillPrefix);
			axelabranch.setBranchInvoicePrefix(branchInvoicePrefix);
			axelabranch.setBranchInvoiceSuffix(branchInvoiceSuffix);
			axelabranch.setBranchJcPrefix(branchJcPrefix);
			axelabranch.setBranchReceiptPrefix(branchReceiptPrefix);
			axelabranch.setBranchReceiptSuffix(branchReceiptSuffix);
			axelabranch.setBranchSoPrefix(branchSoPrefix);
			if (!branchId.equals("0") && requestType.equals("add")) {
				axelabranch.setBranchEntryDate(getTimeByZone(session));
				axelabranch.setBranchEntryId(empId);
				axelabranch.setBranchModifiedId(0);
			} else if (!branchId.equals("0") && requestType.equals("update")) {
				axelabranch.setBranchModifiedId(empId);
				axelabranch.setBranchModifiedDate(getTimeByZone(session));
			}
			String branchId = branchRepository.save(axelabranch).getBranchId() + "";
			if (!branchId.equals("0") && requestType.equals("add")) {
				output.put("successmsg", "Branch Added Successfully!");
				output.put("branchId", branchId);
			} else if (!branchId.equals("0") && requestType.equals("update")) {
				output.put("successmsg", "Branch update Successfully!");
				output.put("branchId", branchId);
			}
		} else {
			response.setStatus(400); // Bad request since missing mandatory fields from client.
			output.put("errormsg", msg);
		}
	}
	public Map<String, String> populateBranchData(String input, HttpSession session, HttpServletResponse response) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		output = new LinkedHashMap<String, String>();
		empId = Integer.parseInt(CNumeric(PadQuotes(getSession("empId", session))));
		if (empId != 0) {
			if (!returnPerm("emp_role_id", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			AxelaBranch axelaBranch = null;
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			LinkedHashMap map = new LinkedHashMap();
			if (!inputObj.isNull("branchId")) {
				branchId = CNumeric(PadQuotes(inputObj.getString("branchId")));
			}
			if (!branchId.equals("0")) {
				AxelaBranch branchs = branchRepository.findByBranchId(Integer.parseInt(branchId));
				map.put("branchName", branchs.getBranchName());
				map.put("branchInvoiceName", branchs.getBranchInvoiceName());
				map.put("branchCode", "" + branchs.getBranchCode());
				map.put("branchGst", "" + branchs.getBranchGst());
				map.put("branchVat", "" + branchs.getBranchVat());
				map.put("branchCst", "" + branchs.getBranchCst());
				map.put("branchBranchtypeId", "" + branchs.getBranchBranchtypeId());
				map.put("branchFranchiseeId", "" + branchs.getBranchFranchiseeId());
				map.put("branchRateclassId", "" + branchs.getBranchRateclassId());
				map.put("branchLocationId", "" + branchs.getBranchLocationId());
				map.put("branchPhone1", "" + branchs.getBranchPhone1());
				map.put("branchPhone2", branchs.getBranchPhone2());
				map.put("branchMobile1", branchs.getBranchMobile1());
				map.put("branchMobile2", branchs.getBranchMobile2());
				map.put("branchEmail1", branchs.getBranchEmail1());
				map.put("branchEmail2", "" + branchs.getBranchEmail2());
				map.put("branchAdd", "" + branchs.getBranchAdd());
				map.put("branchCityId", "" + branchs.getBranchCityId());
				map.put("branchPin", "" + branchs.getBranchPin());
				map.put("branchPanNo", "" + branchs.getBranchPanNo());
				map.put("branchTanNo", "" + branchs.getBranchTanNo());
				map.put("branchTinNo", "" + branchs.getBranchTinNo());
				map.put("branchServiceTaxNo", "" + branchs.getBranchServiceTaxNo());
				map.put("branchBillHeader", "" + branchs.getBranchBillHeader());
				map.put("branchBillFooter", "" + branchs.getBranchBillFooter());
				map.put("branchQuoteDesc", "" + branchs.getBranchQuoteDesc());
				map.put("branchQuoteTerms", branchs.getBranchQuoteTerms());
				map.put("branchSoDesc", "" + branchs.getBranchSoDesc());
				map.put("branchSoTerms", branchs.getBranchSoTerms());
				map.put("branchInvoiceDesc", "" + branchs.getBranchInvoiceDesc());
				map.put("branchInvoiceTerms", "" + branchs.getBranchInvoiceTerms());
				map.put("branchReceiptDesc", "" + branchs.getBranchReceiptDesc());
				map.put("branchNotes", branchs.getBranchNotes());
				map.put("branchActive", branchs.getBranchActive());
				map.put("branchBillPrefix", branchs.getBranchBillPrefix());
				map.put("branchInvoicePrefix", "" + branchs.getBranchInvoicePrefix());
				map.put("branchInvoiceSuffix", "" + branchs.getBranchInvoiceSuffix());
				map.put("branchJcPrefix", "" + branchs.getBranchJcPrefix());
				map.put("branchReceiptPrefix", branchs.getBranchReceiptPrefix());
				map.put("branchReceiptSuffix", branchs.getBranchReceiptSuffix());
				map.put("branchSoPrefix", branchs.getBranchSoPrefix());
				if (branchs.getBranchEntryId() != 0) {
					map.put("branchEntryDate", strToShortDate(branchs.getBranchEntryDate()));
					map.put("branchEntryId", String.valueOf(branchs.getBranchEntryId()));
					map.put("branchEntryBy", empRepository.findByEmp(branchs.getBranchEntryId()));
				}
				if (branchs.getBranchModifiedId() != 0) {
					map.put("branchModifiedDate", strToShortDate(branchs.getBranchModifiedDate()));
					map.put("branchModifiedId", String.valueOf(branchs.getBranchModifiedId()));
					map.put("branchModifiedBy", empRepository.findByEmp(branchs.getBranchModifiedId()));
				}
				list.add(map);
				output.put("populateData", list);
			}
		}
		return output;
	}
	public Map<String, String> populateConfigDetails() {
		output = new LinkedHashMap<String, String>();
		List<Object[]> object = axelaCompRepository.findByCompBranchCount();
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (Object[] objects : object) {
			HashMap<String, String> map = new HashMap<String, String>();
			branchCount = Integer.parseInt(String.valueOf(objects[0]));
			SOP("branchCount========" + branchCount);
			// activeBranchcount = Integer.parseInt(String.valueOf(objects[1]));
			SOP("activeBranchcount========" + activeBranchcount);
			list.add(map);
		}
		return output;
	}
	public void deleteFields(int branchId) {
		msg = "";
		// association for ConfigCustomerName
		StrSql = CNumeric(PadQuotes(String.valueOf(customerRepository.findByCustomerBranchId(branchId))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with ConfigCustomerName !";
		}
		// association for Opportunity
		StrSql = CNumeric(PadQuotes(String.valueOf(opprRepository.findByOpprBranchId(branchId))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with Opportunity!";
		}
		// association for Voucher
		StrSql = CNumeric(PadQuotes(String.valueOf(accVoucherRepository.findByVoucherBranchId(branchId))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with Voucher!";
		}
		// association for Sales Order
		StrSql = CNumeric(PadQuotes(String.valueOf(accVoucherRepository.findByVoucherVouchertypeId(branchId))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with Sales Order!";
		}
		// association for Receipt
		StrSql = CNumeric(PadQuotes(String.valueOf(accVoucherRepository.findByReciept(branchId))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with Receipt!";
		}
		// association for Payment
		StrSql = CNumeric(PadQuotes(String.valueOf(accVoucherRepository.findByPayment(branchId))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with Payment!";
		}
		// association for Job Card
		StrSql = CNumeric(PadQuotes(String.valueOf(jCRepository.findByJcBranchId(branchId))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with Job Card!";
		}
		// association for Bill
		StrSql = CNumeric(PadQuotes(String.valueOf(accVoucherRepository.findByBill(branchId))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with Bill!";
		}
		// association for Bill Counter
		StrSql = CNumeric(PadQuotes(String.valueOf(billCounterRepository.findByCounterBranchId(branchId))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with Bill Counter!";
		}
		// association for Contract
		StrSql = CNumeric(PadQuotes(String.valueOf(serviceContractRepository.findByContractBranchId(branchId))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with Contract!";
		}
		// association for assetContract
		StrSql = CNumeric(PadQuotes(String.valueOf(assetContractRepository.findByContractbranchId(branchId))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with assetContract!";
		}
		// association for Executives
		StrSql = CNumeric(PadQuotes(String.valueOf(empRepository.findByEmpBranchId(branchId))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with Executives!";
		}
		// association for Holidays
		StrSql = CNumeric(PadQuotes(String.valueOf(axelaholiRepository.findByholiBranchId(branchId))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with Holidays!";
		}
		// association for News
		StrSql = CNumeric(PadQuotes(String.valueOf(newsBranchRepository.findByNewsBranchId(branchId))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with News!";
		}
		// association for Production Jobcard
		StrSql = CNumeric(PadQuotes(String.valueOf(prodJobCardRepository.findByjobCardBranchId(branchId))));
		if (!StrSql.equals("0")) {
			msg += "<br>" + tag + " is associated with Production Jobcard!";
		}
		if (msg.equals("")) {
			branchRepository.delete(branchId);
			output.put("successmsg", "Branch Deleted Successfully!");
		}
		else {
			output.put("errormsg", msg);
		}
	}

	public Map listData(String input, HttpSession session) throws JSONException, ParseException {
		inputObj = new JSONObject(input);
		empId = Integer.parseInt(CNumeric(getSession("empId", session)));
		configCustomerName = getSession("configCustomerName", session);
		String strSearch = "";
		String strOrderBy = "";
		requestType = "";
		if (empId != 0) {
			if (!returnPerm("emp_role_id", session)) {
				output.put("errorPage", "Access denied. Please contact system administrator!");
				return output;
			}
			page = 0;
			branchAccess = getSession("branchAccess", session).replaceAll("branchId", "a.contractBranchId");
			exeAccess = getSession("exeAccess", session).replaceAll("exeAccess", "a.contractEmpId");
			output = new LinkedHashMap<String, String>();
			ArrayList<HashMap<String, String>> listHeader = new ArrayList<HashMap<String, String>>();
			List<HashMap> listBody = new ArrayList<HashMap>();
			List<HashMap> listAction = new ArrayList<HashMap>();
			ArrayList<HashMap> listBodyAlign = new ArrayList<HashMap>();
			ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			PageRequest request = null;
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
				orderByField = "branchId";
			}
			if (perPage.equals("0")) {
				perPage = "25";
			}
			page++;
			if (requestType.equals("filter")) {
				strSearch = buildSmartSearch(input);
			}
			strOrderBy = " ORDER BY branch." + orderByField + " " + orderType + "";
			List<AxelaBranch> resultSet = portalbranchFilterImpl.findAll(strSearch, strOrderBy, page, Integer.parseInt(perPage));
			String length = portalbranchFilterImpl.totalCount;
			Map<String, String> mapNavi = pageNavi(Integer.parseInt(length), input, perPage);
			int count = 0;
			// Start Header Data
			listHeader.add(produceHeaderData("Branch Details", "branchName", "center"));
			listHeader.add(produceHeaderData("contacts", "branchPhone1", "center"));
			listHeader.add(produceHeaderData("Address", "branchAdd", "center"));
			listHeader.add(produceHeaderData("Notes", "branchNotes", "center"));
			// End Header Data

			// Start Body Align
			listBodyAlign.add(produceBodyAlign("center"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			listBodyAlign.add(produceBodyAlign("left"));
			// End Body Align
			StringBuilder dataString = null;
			for (AxelaBranch obj : resultSet) {
				ArrayList<String> paramSubArr = new ArrayList<String>();
				ArrayList paramArr = new ArrayList();
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

				// Branch Details
				type.add(false);
				type.add(false);
				type.add(false);
				if (obj.getBranchActive().equals("0")) {
					active = "<font color=red>[Inactive]</font><br>";
				} else {
					active = "";
				}
				value.add(String.valueOf(obj.getBranchName()) + " " + active);
				value.add("Franchisee: " + String.valueOf(obj.getFranchiseeName()));
				value.add("Class: " + String.valueOf(obj.getRateclassName()));
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();

				// details.
				if (!obj.getBranchPhone1().equals("")) {
					type.add(false);
					value.add(String.valueOf(obj.getBranchPhone1()));
				}
				if (!obj.getBranchPhone2().equals("")) {
					type.add(false);
					value.add(String.valueOf(obj.getBranchPhone2()));
				}
				if (!obj.getBranchMobile1().equals("")) {
					type.add(false);
					value.add(String.valueOf(obj.getBranchMobile1()));
				}
				if (!obj.getBranchMobile2().equals("")) {
					type.add(false);
					value.add(String.valueOf(obj.getBranchMobile2()));
				}
				if (!obj.getBranchEmail1().equals("")) {
					type.add(false);
					value.add("<a href ='mailto: " + String.valueOf(obj.getBranchEmail1()) + "</a>");
				}
				if (!obj.getBranchEmail2().equals("")) {
					type.add(false);
					value.add("<a href ='mailto: " + String.valueOf(obj.getBranchEmail2()) + "</a>");
				}
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				type.clear();
				value.clear();
				// Address
				type.add(false);
				type.add(false);
				value.add(String.valueOf(obj.getBranchAdd()));
				value.add(String.valueOf(obj.getCityName()) + " - " + String.valueOf(obj.getBranchPin()));
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				paramArr.clear();
				type.clear();
				value.clear();

				type.add(false);
				value.add(String.valueOf(obj.getBranchNotes()));
				paramArr.add((ArrayList) paramSubArr.clone());
				listData.add(produceBodyData(true, ((ArrayList) type.clone()), ((ArrayList) value.clone()), ((ArrayList) paramArr.clone())));
				paramArr.clear();
				type.clear();
				value.clear();

				// End Body data
				mapData.put("td", listData);
				ArrayList actionParam = new ArrayList();
				actionParam.add("updateBranch");
				actionParam.add(PadQuotes(String.valueOf(obj.getBranchId())));
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
		return output;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<HashMap> produceActionData(ArrayList<String> Param) {
		ArrayList<HashMap> listAction = new ArrayList<HashMap>();
		HashMap mapBodyData = new HashMap();
		mapBodyData.put("value", "Update Branch");
		mapBodyData.put("param", Param);
		listAction.add((HashMap) mapBodyData.clone());
		return listAction;
	}

	public Map populateDrSmart() {
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		output = new LinkedHashMap();
		list.add(buildSmartArr("Keyword", "text", "branch.*"));
		list.add(buildSmartArr("Branch ID", "numeric", "branch.branchId"));
		list.add(buildSmartArr("Branch Name", "text", "branch.branchName"));
		list.add(buildSmartArr("Branch Code", "text", "branch.branchCode"));
		list.add(buildSmartArr("Branch Phone1", "text", "branch.branchPhone1"));
		list.add(buildSmartArr("Branch Phone2", "text", "branch.branchPhone2"));
		list.add(buildSmartArr("Branch Mobile1", "text", "branch.branchMobile1"));
		list.add(buildSmartArr("Branch Mobile2", "text", "branch.branchMobile2"));
		list.add(buildSmartArr("Branch Email1", "text", "branch.branchEmail1"));
		list.add(buildSmartArr("Branch Email2", "text", "branch.branchEmail2"));
		list.add(buildSmartArr("Branch Address", "text", "branch.branchAdd"));
		list.add(buildSmartArr("Branch Pin", "text", "branch.branchPin"));
		list.add(buildSmartArr("Pan No.", "text", "branch.branchPanNo"));
		list.add(buildSmartArr("Tan No.", "text", "branch.branchTanNo"));
		list.add(buildSmartArr("Tin No.", "text", "branch.branchTinNo"));
		list.add(buildSmartArr("Service Tax No.", "text", "branch.branchServiceTaxNo"));
		list.add(buildSmartArr("Active", "boolean", "branch.branchActive"));
		list.add(buildSmartArr("Branch Notes", "text", "branch.branchNotes"));
		// list.add(buildSmartArr("Entry By", "text", "branch_entry_id in (SELECT emp_id FROM compdb.axela_emp WHERE emp_name"));
		list.add(buildSmartArr("Entry Date", "date", "branch.branchEntryDate"));
		// list.add(buildSmartArr("Modified By", "text", "branch_modified_id in (SELECT emp_id FROM compdb.axela_emp WHERE emp_name"));
		list.add(buildSmartArr("Modified Date", "date", "branch.branchModifiedDate"));
		output.put("drSmart", list.toArray());
		return output;
	}

}
