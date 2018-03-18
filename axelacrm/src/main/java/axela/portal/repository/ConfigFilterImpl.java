package axela.portal.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import axela.config.Connect;
import axela.config.ConnectDate;
import axela.portal.model.AxelaConfig;

@Repository
@Transactional(readOnly = true)
public class ConfigFilterImpl {
	Connect connect = new Connect();
	ConnectDate connectDate = new ConnectDate();
	// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	@PersistenceContext
	EntityManager em;

	// public Date gettimebyzone(HttpSession session) {
	// System.out.println("heyu111111uu");
	// int hours = 0;
	// int seconds = 00;
	// int minute = 0;
	// double days = 0.0;
	// String output = "";
	// // String query = "SELECT "
	// // + " a.axelaTimezone.timezoneValue  AS time"
	// // + " FROM AxelaConfig a"
	// // + " INNER JOIN a.axelaTimezone";
	// // TypedQuery<Integer> typedQuery = em.createQuery(query, Integer.class);
	// // em.clear();
	// minute = Integer.parseInt(connect.PadQuotes(connect.getSession("timeZoneValue", session)));// Integer.parseInt(connect.PadQuotes(String.valueOf(typedQuery.getResultList().get(0))));
	// System.out.println("minute======" + minute);
	// hours = minute / 60;
	// System.out.println("hours======" + hours);
	// minute = minute - hours * 60;
	// System.out.println("minute==11111====" + minute);
	// if (String.valueOf(hours).length() == 1) {
	// output = "0" + hours;
	// }
	// else {
	// output = hours + "";
	// }
	// if (String.valueOf(minute).length() == 1) {
	// output = output + "0" + minute;
	// }
	// else {
	// output = output + minute;
	// }
	// output = output + "00";
	// System.out.println("output===output1========" + output);
	// Date date = connect.kknow();
	// System.out.println("output===output1========" + date);
	// Date date1 = connectDate.addHoursDate(date, days, hours, minute);
	// // long date2 = Long.parseLong(connect.CNumeric(connect.PadQuotes(connectDate.toLongDate(connect.kknow()))));
	// // long date2 = date1.getTime();
	// // System.out.println("date===date========" + date2);
	// // output = String.valueOf(date2 + Integer.parseInt(output));
	// // System.out.println("output===========" + output);
	// return date1;
	// }

	public List<AxelaConfig> populateConfigDetails(int ticketEntryId, int empId) {
		String Query = "SELECT NEW AxelaConfig("
				+ " a.configServiceContract,"
				+ " a.configServiceTicketCat,"
				+ " a.configServiceTicketType, "
				+ " b.compModulePm,"
				+ " admin.empRoleId AS empRoleId,"
				+ " a.configServiceTicketRefno,"
				+ " a.configTicketFollowupEmailEnable,"
				+ " a.configTicketFollowupEmailSub,"
				+ " a.configTicketFollowupEmailFormat, "
				+ " a.configAdminEmail,"
				+ " a.configEmailEnable,"
				+ " a.configSmsEnable,"
				+ " a.configTicketFollowupSmsFormat, "
				+ " b.compSmsEnable,"
				+ " b.compEmailEnable,"
				+ " a.configTicketFollowupSmsEnable,"
				+ " a.configTicketFollowupEmailExeSub,"
				+ " a.configTicketFollowupEmailExeFormat,"
				+ " a.configTicketFollowupSmsExeFormat,"
				+ " COALESCE(admin.empEmail1,'') AS entryempEmail,"
				+ " COALESCE(admin.empEmail1,'') AS empEmail)"
				+ " FROM AxelaConfig a,"
				+ " AxelaComp b,"
				+ " AxelaEmp admin"
				// + " LEFT JOIN AxelaEmp ticketentry ON ticketentry.empId = " + ticketEntryId + ""
				+ " WHERE admin.empId = " + empId;

		TypedQuery<AxelaConfig> typedquery = em.createQuery(Query, AxelaConfig.class);
		em.clear();
		return typedquery.getResultList();

	}

}
