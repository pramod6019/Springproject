package axela.portal.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import axela.config.Connect;
import axela.portal.model.AxelaEmp;
import axela.portal.model.AxelaEmpExe;

public class Session_Repository_imple extends Connect implements Session_Repository {

	@PersistenceContext
	EntityManager em;

	@Override
	public AxelaEmp findId(String emp_id, String comp_id) {
		Query query = em.createQuery("SELECT emp_branch_id"
				+ " FROM " + compdb(comp_id) + "axela_emp_branch"
				+ " INNER JOIN " + compdb(comp_id) + "axela_branch ON branch_id = emp_branch_id"
				+ " WHERE branch_active = 1"
				+ " AND emp_id = " + emp_id + "");
		return (AxelaEmp) query.getSingleResult();
	}

	@Override
	public AxelaEmpExe findExeId(String emp_id, String comp_id) {
		Query query = em.createQuery("SELECT empexe_id FROM " + compdb(comp_id) + "axela_emp_exe" + " WHERE empexe_emp_id = " + emp_id + "");
		return (AxelaEmpExe) query.getSingleResult();
	}

	@Override
	public List<Object[]> findAll(String comp_id, String emp_id) {
		Query query = em.createQuery("SELECT channel_logo, channel_name, channel_self_branding, channel_self_support,"
				+ " comp_pic, comp_name, comp_module_activity, comp_module_customer, comp_module_pm,"
				+ " comp_module_marketing, comp_module_sales, comp_module_pos, comp_module_service,"
				+ " comp_module_inventory, comp_module_invoice, comp_module_accounting,"
				+ " comp_module_production, comp_module_asset,comp_module_hcm,comp_module_payroll, comp_module_social,"
				+ " comp_module_website, comp_module_productcatalogue, comp_module_portal,"
				+ " comp_businesstype_id, comp_email_enable, comp_sms_enable, config_customer_name,"
				+ " config_sales_oppr_name, config_inventory_current_stock,"
				+ " config_inventory_location_name, config_format_decimal," + " currency_name,"
				+ " currency_symbol, currency_country, formatdate_name, formatdate_datepicker,"
				+ " formattime_name, formattime_timepicker, formatdigit_id"
				+ " FROM "
				// + compdb(comp_id) + "axela_emp"
				// + " INNER JOIN " + compdb(comp_id) + "axela_jobtitle ON jobtitle_id = emp_jobtitle_id,"
				+ " " + compdb(comp_id) + "axela_comp,"
				+ " " + compdb(comp_id) + "axela_config,"
				+ " " + maindb() + "channel,"
				+ " " + maindb() + "currency,"
				+ " " + maindb() + "formatdate,"
				+ " " + maindb() + "formattime,"
				+ " " + maindb() + "formatdigit"
				+ " WHERE emp_active = '1'"
				+ " AND emp_id = " + emp_id + ""
				+ " AND comp_id = " + comp_id + ""
				+ " AND comp_active = '1'"
				+ " AND channel_id = comp_channel_id"
				+ " AND config_currency_id = currency_id"
				+ " AND emp_formatdate_id = formatdate_id"
				+ " AND emp_formattime_id = formattime_id"
				+ " AND emp_formatdigit_id = formatdigit_id");
		return query.getResultList();
	}

}
