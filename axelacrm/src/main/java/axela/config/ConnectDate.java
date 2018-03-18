//sharath
package axela.config;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ConnectDate {

	public ConnectDate() {
	}
	final Logger logger = Logger.getLogger(this.getClass());
	public boolean isValidDateFormatShort(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date testdate = null;
		try {
			testdate = sdf.parse(date);// String to date
		} catch (ParseException e) {
			return false;
		}
		if (!sdf.format(testdate).equals(date)) {
			return false;
		}
		return true;
	}
	// req
	public boolean isValidDateFormatLong(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date testdate = null;
		try {
			testdate = sdf.parse(date);// String to date
		} catch (ParseException e) {
			return false;
		}
		if (!sdf.format(testdate).equals(date)) {
			return false;
		}
		return true;
	}

	public boolean isValidDateFormatStr(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date testdate = null;
		try {
			System.out.println("date==isValidDateFormatStr==" + date);
			testdate = sdf.parse(date);// String to date
		} catch (ParseException e) {
			return false;
		}

		if (!sdf.format(testdate).equals(date)) {
			return false;
		}
		return true;
	}
	// req
	public boolean isValidDateFormat(String date, String format) {
		format = format.trim();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date testdate = null;
		try {
			System.out.println("testdate=========" + testdate);
			testdate = sdf.parse(date);// String to date
			System.out.println("testdate====after=====" + testdate);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	// public String ToLongDate(Date dtDateTime) {
	// try {
	// String strOutDt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dtDateTime);
	// return strOutDt;
	// } catch (Exception ex) {
	// logger.error(this.getClass().getName());
	// logger.error("ToLongDate error--" + ex);
	// return " " + ex;
	// }
	// }

	public String toLongDate(Date dtDateTime) {
		String strOutDt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dtDateTime);
		return strOutDt;
	}

	public String toShortDate(Date dtDateTime) {
		String strOutDt = new SimpleDateFormat("yyyyMMdd").format(dtDateTime);
		return strOutDt + "000000";
	}

	public String dateToShortDate(Date dtDateTime) {
		String strOutDt = new SimpleDateFormat("dd/MM/yyyy").format(dtDateTime);
		return strOutDt;
	}

	// public String strToLongDate(String strDateTime) {
	// String strOutDt = "";
	// try {
	// if (strDateTime != null && !strDateTime.equals("")) {
	// Date dttemp = new SimpleDateFormat("yyyyMMddHHmmss").parse(strDateTime);
	// strOutDt = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(dttemp);
	// }
	// return strOutDt;
	// } catch (Exception ex) {
	// logger.error(this.getClass().getName());
	// logger.error("strToLongDate error --" + ex);
	// return " " + ex;
	// }
	// }

	// public String strToShortDate(String strDateTime) {
	// String strOutDt = "";
	// try {
	// if (strDateTime != null && !strDateTime.equals("")) {
	// Date dttemp = new SimpleDateFormat("yyyyMMddHHmmss").parse(strDateTime);
	// strOutDt = new SimpleDateFormat("dd/MM/yyyy").format(dttemp);
	// }
	// return strOutDt;
	// } catch (Exception ex) {
	// logger.error(this.getClass().getName());
	// logger.error("strToShortDate error --" + ex);
	// return " " + ex;
	// }
	// }

	// public String checkDate(Date date) {
	// if (date.toString().equals("0000-00-00 00:00:00")) {
	// return "";
	// } else {
	// return date.toString();
	// }
	// }

	public String strToShortDate(Date dateTime) throws ParseException {
		String strOutDt = "";
		if (dateTime != null) {
			strOutDt = new SimpleDateFormat("dd/MM/yyyy").format(dateTime);
			if (dateTime.equals("0000-00-00 00:00:00")) {
				strOutDt = "";
			}
		}
		return strOutDt;
	}

	public String strToLongDate(Date dateTime) throws ParseException {
		String strOutDt = "";
		if (dateTime != null) {
			strOutDt = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(dateTime);
			if (dateTime.equals("0000-00-00 00:00:00")) {
				strOutDt = "";
			}
		}
		return strOutDt;

	}

	public String convertLongDateToStr(String strDateTime) throws ParseException {
		Date dttemp;
		String strOutDt = "";
		if (strDateTime != null && !strDateTime.equals("")) {
			dttemp = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(strDateTime);
			strOutDt = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(dttemp);
		}
		return strOutDt;
	}

	public String convertShortDateToStr(String strDateTime) throws ParseException {
		// System.out.println("strDateTime======="+strDateTime);
		Date dttemp;
		String strOutDt = "";
		if (strDateTime != null && !strDateTime.equals("")) {
			dttemp = new SimpleDateFormat("dd/MM/yyyy").parse(strDateTime);
			strOutDt = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(dttemp);
		}
		return strOutDt;
	}

	public String convertTimeToStr(String strDateTime) throws ParseException {
		// System.out.println("strDateTime======="+strDateTime);
		Date dttemp;
		String strOutDt = "";
		if (strDateTime != null && !strDateTime.equals("")) {
			dttemp = new SimpleDateFormat("HH:mm").parse(strDateTime);
			strOutDt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dttemp);
		}
		return strOutDt;
	}

	public String convertLongDate(String strDateTime) throws ParseException {
		// System.out.println("strDateTime======="+strDateTime);
		Date dttemp;
		String strOutDt = "";
		if (strDateTime != null && !strDateTime.equals("")) {
			dttemp = new SimpleDateFormat("yyyyMMddHHmmss").parse(strDateTime);
			strOutDt = new SimpleDateFormat("dd MMMM, yyyy EEEE").format(dttemp);
		}
		return strOutDt;
	}

	public String fmt1tofmt2(String strDateTime) throws ParseException {
		Date dttemp;
		String strOutDt = "";
		if (strDateTime != null && !strDateTime.equals("")) {
			dttemp = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(strDateTime);
			strOutDt = new SimpleDateFormat("MM/dd/yyyy HH:mm").format(dttemp);
		}
		return strOutDt;
	}

	public String fmtShr1tofmtShr2(String strDateTime) throws ParseException {
		Date dttemp;
		String strOutDt = "";
		if (strDateTime != null && !strDateTime.equals("")) {
			dttemp = new SimpleDateFormat("dd/MM/yyyy").parse(strDateTime);
			strOutDt = new SimpleDateFormat("MM/dd/yyyy").format(dttemp);
		}
		return strOutDt;

	}

	public double getHoursBetween(Date first, Date second) {
		double milliElapsed = second.getTime() - first.getTime();
		System.out.println("milliElapsed========" + milliElapsed);
		double hoursElapsed = (milliElapsed / 3600F / 1000F);
		System.out.println("hoursElapsed========" + hoursElapsed);
		return (Math.round(hoursElapsed * 100F) / 100F);
	}

	public double getMinBetween(Date first, Date second) {
		double milliElapsed = second.getTime() - first.getTime();
		double hoursElapsed = (milliElapsed / 60F / 1000F);
		return (Math.round(hoursElapsed) % 60F);
	}

	public double getSecBetween(Date first, Date second) {
		double milliElapsed = second.getTime() - first.getTime();
		double secElapsed = (milliElapsed / 1000F);
		return (Math.round(secElapsed));
	}

	public String ConvertMintoHrsMins(long totalmin) {
		System.out.println("coming========");
		DecimalFormat deci = new DecimalFormat("#");
		String output = "0";
		System.out.println("totalmin========" + totalmin);
		if (totalmin == 0) {
			return "0";
		}

		String hours = deci.format(Math.floor(totalmin / 60));
		System.out.println("hours========" + hours);
		String min = deci.format(Math.floor(totalmin % 60));
		System.out.println("min========" + min);
		if (!hours.equals("0")) {
			output = hours + " Hrs ";
		}
		if (!min.equals("0")) {
			output = output + min + " Mins";
		}
		System.out.println("output=======" + output);
		return output;
	}

	// public String splitMonth(String strDateTime) {
	// String sm = "";
	// try {
	// if (strDateTime != null && !strDateTime.equals("")) {
	// Date date = new SimpleDateFormat("yyyyMMddHHmmss").parse(strDateTime);
	// sm = new SimpleDateFormat("MM").format(date);
	// }
	// return sm;
	// } catch (Exception ex) {
	// logger.error(this.getClass().getName());
	//
	// return "";
	// }
	// }

	public String splitMonth(Date dateTime) {
		String sm = "";
		if (dateTime != null && !dateTime.equals("")) {
			sm = new SimpleDateFormat("MM").format(dateTime);
		}
		return sm;
	}

	// public String splitHourMin(String strDateTime) {
	// String sm = "";
	// try {
	// if (strDateTime != null && !strDateTime.equals("")) {
	// Date date = new SimpleDateFormat("yyyyMMddHHmmss").parse(strDateTime);
	// sm = new SimpleDateFormat("HH:mm").format(date);
	// }
	// return sm;
	// } catch (Exception ex) {
	// logger.error(this.getClass().getName());
	// logger.error("SplitHourMin error --" + ex);
	// return "";
	// }
	// }

	public String splitHourMin(Date dateTime) {
		String sm = "";
		if (dateTime != null && !dateTime.equals("")) {
			sm = new SimpleDateFormat("HH:mm").format(dateTime);
		}
		return sm;
	}

	// public String splitDate(String strDateTime) {
	// String sd = "";
	// try {
	// if (strDateTime != null && !strDateTime.equals("")) {
	// Date date = new SimpleDateFormat("yyyyMMddHHmmss").parse(strDateTime);
	// sd = new SimpleDateFormat("dd").format(date);
	// }
	// return sd;
	// } catch (Exception ex) {
	// logger.error(this.getClass().getName());
	// logger.error("SplitDate error --" + ex);
	// return "";
	// }
	// }

	public String splitDate(Date dateTime) {
		String sd = "";
		if (dateTime != null) {
			sd = new SimpleDateFormat("dd").format(dateTime);
		}
		return sd;
	}

	// public String splitYear(String strDateTime) {
	// String sy = "";
	// try {
	// if (strDateTime != null && !strDateTime.equals("")) {
	// Date date = new SimpleDateFormat("yyyyMMddHHmmss").parse(strDateTime);
	// sy = new SimpleDateFormat("yyyy").format(date);
	// }
	// return sy;
	// } catch (Exception ex) {
	// logger.error(this.getClass().getName());
	// logger.error("SplitYear error --" + ex);
	// return "";
	// }
	// }

	public String splitYear(Date dateTime) {
		String sy = "";
		if (dateTime != null) {
			sy = new SimpleDateFormat("yyyy").format(dateTime);
		}
		return sy;
	}

	public String dateToString(Date dateTime) {
		String sy = "";
		if (dateTime != null) {
			sy = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateTime);
		}
		return sy;
	}

	public String dateToStringStr(Date dateTime) {
		String sy = "";
		if (dateTime != null) {
			sy = new SimpleDateFormat("dd/MM/yyyy").format(dateTime);
		}
		return sy;
	}

	// public Date stringToDate(String str) throws ParseException {
	// Date dtTmp;
	// if (str.length() == 10)
	// {
	// str = str + " " + "00:00:00";
	// }
	// if (str.length() == 16)
	// {
	// str = str + ":00";
	// }
	// System.out.println("Sting=============" + str);
	// if (!str.equals("")) {
	// dtTmp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(str);
	// } else {
	// dtTmp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("00/00/0000 00:00:00");
	// }
	// System.out.println("dtTmp=============" + dtTmp);
	// return dtTmp;
	//
	// }

	// WIP
	public Date stringToDate(String str) throws ParseException {
		Date dtTmp;

		if (str.length() == 10) {
			str = str + " " + "00:00:00";
		}

		if (str.length() == 16) {
			str = str + ":00";
		}

		if (!str.equals("")) {
			System.out.println("Sting=============" + str);
			dtTmp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(str);
			System.out.println("dtTmp=============" + dtTmp);
		}
		else {
			dtTmp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("01/01/1900 01:01:01");
		}
		return dtTmp;
	}

	public Date addHoursDate(Date first, double days, double hours, double minutes) {
		double additionalTime = (days * 24F * 3600F * 1000F) + (hours * 3600F * 1000F) + (minutes * 60 * 1000);
		// System.out.println("AddHoursDate====first=====" + first);
		// System.out.println("AddHoursDate====Mathsr=====" + Math.round((double) first.getTime() + additionalTime));
		// System.out.println("AddHoursDate====new=====" + new Date(Math.round((double) first.getTime() + additionalTime)));
		return new Date(Math.round((double) first.getTime() + additionalTime));
	}

	public String addDayMonthYear(Date fromdate, int days, int week, int month, int year) throws ParseException {
		String Str = "";
		Date date;
		Calendar c1 = Calendar.getInstance();

		if (fromdate != null) {
			c1.setTime(fromdate);
			c1.add(Calendar.DATE, days);
			c1.add(Calendar.WEDNESDAY, week);
			c1.add(Calendar.MONTH, month);
			c1.add(Calendar.YEAR, year);
			Str = strToShortDate(new SimpleDateFormat("dd/MM/yyyy").parse(toLongDate(c1.getTime())));
			return Str;
		}
		return Str;
	}

	// public double getDaysBetween(String first, String second) {
	// try {
	// Date First = new SimpleDateFormat("yyyyMMddHHmmss").parse(first);
	// Date Second = new SimpleDateFormat("yyyyMMddHHmmss").parse(second);
	//
	// double milliElapsed = Second.getTime() - First.getTime();
	// double daysElapsed = (milliElapsed / 24F / 3600F / 1000F);
	//
	// return (Math.round(daysElapsed * 100F) / 100F);
	// } catch (Exception ex) {
	// logger.error(this.getClass().getName());
	// logger.error("Error in getDaysBetween: " + ex);
	// return 0;
	// }
	// }

	public int getDaysBetween(Date first, Date second) {
		Date First = first;
		Date Second = second;
		double milliElapsed = Second.getTime() - First.getTime();
		double daysElapsed = (milliElapsed / 24F / 3600F / 1000F);
		return (int) (Math.round(daysElapsed * 100F) / 100F);
	}

	// public String getMonthsBetween(String first, String second) {
	// try {
	// Date First = new SimpleDateFormat("yyyyMMddHHmmss").parse(first);
	// Date Second = new SimpleDateFormat("yyyyMMddHHmmss").parse(second);
	// double milliElapsed = Second.getTime() - First.getTime();
	// double avgmonth = 365.24 * 24 * 60 * 60 * 1000 / 12;
	// double MonthsElapsed = (milliElapsed / avgmonth);
	// // System.out.println("MonthsElapsed==="+MonthsElapsed);
	// if (MonthsElapsed < 0) {
	// MonthsElapsed = 0;
	// }
	// return (Math.round((MonthsElapsed * 100F) / 100F)) + "";
	// } catch (Exception ex) {
	// logger.error(this.getClass().getName());
	// logger.error("Error in getMonthsBetween: " + ex);
	// return "0";
	// }
	// }

	public String getMonthsBetween(Date first, Date second) {
		double milliElapsed = second.getTime() - first.getTime();
		double avgmonth = 365.24 * 24 * 60 * 60 * 1000 / 12;
		double MonthsElapsed = (milliElapsed / avgmonth);
		// System.out.println("MonthsElapsed==="+MonthsElapsed);
		if (MonthsElapsed < 0) {
			MonthsElapsed = 0;
		}
		return (Math.round((MonthsElapsed * 100F) / 100F)) + "";
	}

	// public String getYearBetween(String first, String second) {
	// try {
	// Date First = new SimpleDateFormat("yyyyMMddHHmmss").parse(first);
	// Date Second = new SimpleDateFormat("yyyyMMddHHmmss").parse(second);
	// double milliElapsed = Second.getTime() - First.getTime();
	// double avgyear = 365.24 * 24 * 60 * 60 * 1000;
	// double YearsElapsed = (milliElapsed / avgyear);
	// // System.out.println("MonthsElapsed==="+MonthsElapsed);
	// if (YearsElapsed < 0) {
	// YearsElapsed = 0;
	// }
	// return (Math.round((YearsElapsed * 100F) / 100F)) + "";
	// } catch (Exception ex) {
	// logger.error(this.getClass().getName());
	// logger.error("Error in getYearBetween: " + ex);
	// return "0";
	// }
	// }

	public String getYearBetween(Date first, Date second) {
		double milliElapsed = second.getTime() - first.getTime();
		double avgyear = 365.24 * 24 * 60 * 60 * 1000;
		double YearsElapsed = (milliElapsed / avgyear);
		// System.out.println("MonthsElapsed==="+MonthsElapsed);
		if (YearsElapsed < 0) {
			YearsElapsed = 0;
		}
		return (Math.round((YearsElapsed * 100F) / 100F)) + "";
	}

	public String textMonth(int id) {
		switch (id) {
			case 0 :
				return "January";

			case 1 :
				return "February";

			case 2 :
				return "March";

			case 3 :
				return "April";

			case 4 :
				return "May";

			case 5 :
				return "June";

			case 6 :
				return "July";

			case 7 :
				return "August";

			case 8 :
				return "September";

			case 9 :
				return "October";

			case 10 :
				return "November";

			case 11 :
				return "December";

			default :
				return null;
		}
	}

	public String textDayOfWeek(int id) {
		switch (id) {
			case 1 :
				return "Sunday";

			case 2 :
				return "Monday";

			case 3 :
				return "Tuesday";

			case 4 :
				return "Wednesday";

			case 5 :
				return "Thursday";

			case 6 :
				return "Friday";

			case 7 :
				return "Saturday";

			case 9 :
				return "Include Holidays";

			default :
				return null;
		}
	}

	public String diffDaystoDate(String id) {
		Connect ct = new Connect();
		String days = id;
		double duehrs = Double.valueOf(days).doubleValue();
		days = toLongDate(addHoursDate(ct.kknow(), -duehrs, 0, 0));
		return days;
	}

	public String formatDate(String date, String format) throws ParseException {

		format = format.trim();
		System.out.println("isValidDateFormatStr(date)===" + isValidDateFormatStr(date));
		if (isValidDateFormatStr(date)) {
			System.out.println("format==" + format);
			DateFormat formatter = new SimpleDateFormat(format);
			Date date1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(date);
			System.out.println("date1==" + date1);
			String dt = formatter.format(date1);
			return dt;
		} else {
			return "";
		}
	}

	public String formatDateStr(String date, String format) throws ParseException {

		format = format.trim();
		if (isValidDateFormat(date, format)) {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date1 = new SimpleDateFormat(format).parse(date);
			String dt = formatter.format(date1);
			System.out.println("dt=======" + dt);
			return dt;
		} else {
			return "";
		}
	}

	public String periodTime(String starttime, String endtime, String format, HttpServletRequest request, HttpServletResponse response) throws ParseException {
		Connect ct = new Connect();
		format = format.trim();
		String periodtime = "";
		String emp_formatdate = ct.GetSession("formatdate_name", request);
		String emp_formattime = ct.GetSession("formattime_name", request);

		if (format.equals("1")) {
			periodtime = formatDate(starttime, emp_formatdate + " " + emp_formattime) + " - " + formatDate(endtime, emp_formattime);
		} else if (format.equals("2")) {
			periodtime = formatDate(starttime, emp_formattime) + " - " + formatDate(endtime, emp_formattime);
		} else if (format.equals("3")) {
			periodtime = formatDate(starttime, emp_formatdate) + "<br>" + formatDate(starttime, emp_formattime) + "-" + formatDate(endtime, emp_formattime);
		} else if (format.equals("4")) {
			if (getHoursBetween(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(starttime), new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(endtime)) > 12) {
				periodtime = formatDate(starttime, emp_formatdate + " " + emp_formattime) + "<br>" + formatDate(endtime, emp_formatdate + " " + emp_formattime);
			} else {
				periodtime = formatDate(starttime, emp_formatdate) + "<br>" + formatDate(starttime, emp_formattime) + " - " + formatDate(endtime, emp_formattime);
			}
		}
		return periodtime;
	}

	public String periodTime1(String starttime, String endtime, String format) throws ParseException {
		String periodtime = "";
		format = format.trim();

		if (format.equals("1")) {
			periodtime = formatDate(starttime, "dd/MM/yyyy HH:mm") + " - " + formatDate(endtime, "HH:mm");
		} else if (format.equals("2")) {
			periodtime = formatDate(starttime, "HH:mm") + " - " + formatDate(endtime, "HH:mm");
		} else if (format.equals("3")) {
			periodtime = formatDate(starttime, "dd/MM/yyyy") + "<br>" + formatDate(starttime, "HH:mm") + "-" + formatDate(endtime, "HH:mm");
		} else if (format.equals("4")) {
			if (getHoursBetween(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(starttime), new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(endtime)) > 12) {
				periodtime = formatDate(starttime, "dd/MM/yyyy HH:mm") + "<br>" + formatDate(endtime, "dd/MM/yyyy HH:mm");
			} else {
				periodtime = formatDate(starttime, "dd/MM/yyyy") + "<br>" + formatDate(starttime, "HH:mm") + " - " + formatDate(endtime, "HH:mm");
			}
		}
		return periodtime;
	}

	public String calcYearMonth(String month) {
		int yr = 0, mth = 0;
		String yearmonth = "";
		try {
			if (!month.equals("")) {
				mth = Integer.parseInt(month) % 12;
				yr = Integer.parseInt(month) / 12;
				if (yr > 1) {
					yearmonth = (yr + "") + " Years ";
				} else {
					yearmonth = (yr + "") + " Year ";
				}
				if (mth > 1) {
					yearmonth = yearmonth + (mth + "") + " Months";
				} else {
					yearmonth = yearmonth + (mth + "") + " Month";
				}
			}
			return yearmonth;
		} catch (Exception ex) {
			return "";
		}
	}

	// public String addMonth(String fromdate, int month) {
	// String Str = "";
	// Date date;
	// Calendar c1 = Calendar.getInstance();
	// try {
	// if (fromdate != null && !fromdate.equals("")) {
	// date = new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
	// c1.setTime(date);
	// c1.add(Calendar.MONTH, month);
	// Str = strToShortDate(ToLongDate(c1.getTime()));
	// return Str;
	// }
	// } catch (Exception ex) {
	// logger.error(this.getClass().getName());
	// logger.error("AddMonth error --" + ex);
	// return "";
	// }
	// return Str;
	// }

	public String addMonth(Date fromdate, int month) throws ParseException {
		String Str = "";
		Date date;
		Calendar c1 = Calendar.getInstance();
		if (fromdate != null) {
			c1.setTime(fromdate);
			c1.add(Calendar.MONTH, month);
			Str = strToLongDate(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(toLongDate(c1.getTime())));
			return Str;
		}
		return Str;
	}

	// public boolean isSunday(String date) {
	// boolean result = false;
	// int day;
	// Calendar cal = new GregorianCalendar();
	// cal.setTime(stringToDate(date));
	// day = cal.get(cal.DAY_OF_WEEK);
	// if (day == 1) {
	// result = true;
	// }
	// // System.out.println("result--"+result+" for date--"+date);
	// return result;
	// }

	public boolean isSunday(Date date) {
		boolean result = false;
		int day;
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		day = cal.get(cal.DAY_OF_WEEK);
		if (day == 1) {
			result = true;
		}
		// System.out.println("result--"+result+" for date--"+date);
		return result;
	}

	// public int returnDayOfWeek(String date) {
	// int day = 0;
	// Calendar cal = new GregorianCalendar();
	// cal.setTime(stringToDate(date));
	// day = cal.get(Calendar.DAY_OF_WEEK);
	// return day;
	// }
	public int returnDayOfWeek(Date date) {
		int day = 0;
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		day = cal.get(Calendar.DAY_OF_WEEK);
		return day;
	}

	public String textDayOfWeek(int id, int chop) {
		switch (id) {
			case 1 :
				return "Sunday".substring(0, chop);

			case 2 :
				return "Monday".substring(0, chop);

			case 3 :
				return "Tuesday".substring(0, chop);

			case 4 :
				return "Wednesday".substring(0, chop);

			case 5 :
				return "Thursday".substring(0, chop);

			case 6 :
				return "Friday".substring(0, chop);

			case 7 :
				return "Saturday".substring(0, chop);

			case 9 :
				return "Include Holidays";

			default :
				return null;
		}
	}

	// public String strShorttoMonthYear(String strDateTime) {
	// // System.out.println("strDateTime======="+strDateTime);
	// Date dttemp;
	// String strOutDt = "";
	// try {
	// if (strDateTime != null && !strDateTime.equals("")) {
	// dttemp = new SimpleDateFormat("dd/MM/yyyy").parse(strDateTime);
	// strOutDt = new SimpleDateFormat("MMMM yyyy").format(dttemp);
	// }
	// return strOutDt;
	// } catch (Exception ex) {
	// logger.error(this.getClass().getName());
	// logger.error("StrShorttoMonthYear error --" + ex);
	// return "";
	// }
	// }

	// public String strShorttoMonthYear(String strDateTime) {
	// // System.out.println("strDateTime======="+strDateTime);
	// Date dttemp;
	// String strOutDt = "";
	// try {
	// if (strDateTime != null && !strDateTime.equals("")) {
	// dttemp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strDateTime);
	// strOutDt = new SimpleDateFormat("MMMM yyyy").format(dttemp);
	// }
	// return strOutDt;
	// } catch (Exception ex) {
	// logger.error(this.getClass().getName());
	// logger.error("StrShorttoMonthYear error --" + ex);
	// return "";
	// }
	// }

	public String strShorttoMonthYear(Date dateTime) {
		// System.out.println("strDateTime======="+strDateTime);
		Date dttemp;
		String strOutDt = "";
		if (dateTime != null) {
			strOutDt = new SimpleDateFormat("MMMM yyyy").format(dateTime);
		}
		return strOutDt;
	}

	// public String StrShorttoYearMonth(String strDateTime) {
	// // System.out.println("strDateTime======="+strDateTime);
	// Date dttemp;
	// String strOutDt = "";
	// try {
	// if (strDateTime != null && !strDateTime.equals("")) {
	// dttemp = new SimpleDateFormat("dd/MM/yyyy").parse(strDateTime);
	// strOutDt = new SimpleDateFormat("yyyy - MMMM").format(dttemp);
	// }
	// return strOutDt;
	// } catch (Exception ex) {
	// logger.error(this.getClass().getName());
	// logger.error("Error in " + new Exception().getStackTrace()[0].getMethodName() + ": " + ex);
	// return "";
	// }
	// }

	// public String LongtoYearMonth(Date strDateTime) {
	// // System.out.println("strDateTime======="+strDateTime);
	// Date dttemp;
	// String strOutDt = "";
	// try {
	// if (strDateTime != null && !strDateTime.equals("")) {
	// dttemp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(strDateTime);
	// strOutDt = new SimpleDateFormat("yyyy - MMMM").format(dttemp);
	// }
	// return strOutDt;
	// } catch (Exception ex) {
	// logger.error(this.getClass().getName());
	// logger.error("Error in " + new Exception().getStackTrace()[0].getMethodName() + ": " + ex);
	// return "";
	// }
	// }

	public String longToYearMonth(Date dateTime) {
		// System.out.println("strDateTime======="+strDateTime);
		Date dttemp;
		String strOutDt = "";
		if (dateTime != null) {
			strOutDt = new SimpleDateFormat("yyyy - MMMM").format(dateTime);
		}
		return strOutDt;
	}

	public String ConvertHoursToDaysHrsMins(double hours) {
		String hrs = hours + "";
		String split_hours[] = hrs.split("\\.");
		String StrDays = "";
		if (!split_hours[0].equals("0")) {
			if (Integer.parseInt(split_hours[0]) < 24) {
				StrDays = Integer.parseInt(split_hours[0]) + " Hrs ";
			} else {
				StrDays = (Integer.parseInt(split_hours[0]) / 24) + " Days ";
				if ((Integer.parseInt(split_hours[0]) % 24) != 0) {
					StrDays = StrDays + (Integer.parseInt(split_hours[0]) % 24) + " Hrs ";
				}
			}
		}
		if (Integer.parseInt(split_hours[1]) != 0) {
			StrDays = StrDays + Integer.parseInt(split_hours[1]) + " Mins";
		}
		return StrDays;
	}

	// public String ConvertHoursToDays(int hours) {
	// String StrDays = "";
	// if (hours < 24) {
	// StrDays = hours + " hrs";
	// } else {
	// StrDays = (hours / 24) + " Days ";
	// if ((hours % 24) != 0) {
	// StrDays = StrDays + (hours % 24) + " Hrs";
	// }
	// }
	// return StrDays;
	// }
	// public String splitHour(String strDateTime) {
	// String sm = "";
	// try {
	// if (strDateTime != null && !strDateTime.equals("")) {
	// Date date = new SimpleDateFormat("yyyyMMddHHmmss").parse(strDateTime);
	// sm = new SimpleDateFormat("HH").format(date);
	// }
	// return sm;
	// } catch (Exception ex) {
	// return "";
	// }
	// }

	public String splitHour(Date dateTime) {
		String sm = "";
		try {
			if (dateTime != null && !dateTime.equals("")) {
				sm = new SimpleDateFormat("hh").format(dateTime);
				System.out.println("in connect=====" + sm);
			}
			return sm;
		} catch (Exception ex) {
			return "";
		}
	}

	// public String splitMin(String strDateTime) {
	// String sm = "";
	// try {
	// if (strDateTime != null && !strDateTime.equals("")) {
	// Date date = new SimpleDateFormat("yyyyMMddHHmmss").parse(strDateTime);
	// sm = new SimpleDateFormat("mm").format(date);
	// }
	// return sm;
	// } catch (Exception ex) {
	// return "";
	// }
	// }

	public String splitMin(Date dateTime) {
		String sm = "";
		try {
			if (dateTime != null && !dateTime.equals("")) {
				sm = new SimpleDateFormat("mm").format(dateTime);
			}
			return sm;
		} catch (Exception ex) {
			return "";
		}
	}

	// public long convertHoursToMins(String hours) {
	// long StrMins = (long) 0;
	// System.out.println("hours======" + hours);
	// if (!hours.equals("0") && hours.contains(":")) {
	// String splithours[] = hours.split(":");
	// System.out.println("splitlenth===" + splithours.length);
	// if (splithours.length != 0 && !splithours[0].equals("0")) {
	// StrMins = (Long.parseLong(hours) * 60);
	// }

	// if (splithours.length > 1 && !splithours[1].equals("0")) {
	// StrMins += Long.parseLong(splithours[1]);
	// }
	// }
	// return StrMins;
	// }
	public long convertHoursToMins(String hours) {
		long StrMins = (long) 0;
		System.out.println("hours======" + hours);
		StrMins = (Long.parseLong(hours) * 60);
		return StrMins;
	}

	public long ConvertHoursToMins(String hours) {
		long StrMins = (long) 0;
		if (!hours.equals("0") && hours.contains(":")) {
			String splithours[] = hours.split(":");
			if (splithours.length != 0 && !splithours[0].equals("0")) {
				StrMins = (Long.parseLong(splithours[0]) * 60);
			}

			if (splithours.length > 1 && !splithours[1].equals("0")) {
				StrMins += Long.parseLong(splithours[1]);
			}
		}
		return StrMins;
	}

	// public String diffBetweenDates(String first, String second) {
	// try {
	// String diff = "";
	// Date First = new SimpleDateFormat("yyyyMMddHHmmss").parse(first);
	// Date Second = new SimpleDateFormat("yyyyMMddHHmmss").parse(second);
	// // SOP
	//
	// // SOP("Second.getTime()--" + Second.getTime());
	// // SOP
	//
	// // SOP("First.getTime()--" + First.getTime());
	// long milliElapsed = Second.getTime() - First.getTime();
	//
	// long diffYear = Math.round((milliElapsed / (365.24 * 24 * 60 * 60 * 1000)));
	// if (diffYear > 0) {
	// diff += " " + diffYear + " years.";
	// }
	//
	// long diffMonth = Math.round((milliElapsed / (365.24 * 24 * 60 * 60 * 1000 / 12)));
	// if (diffMonth > 0) {
	// diff += " " + diffMonth + " months.";
	// }
	//
	// long diffDays = Math.round((milliElapsed / (24 * 60 * 60 * 1000)));
	// if (diffDays > 0) {
	// diff += " " + diffDays + " days.";
	// }
	//
	// long diffHours = Math.round((milliElapsed / (60 * 60 * 1000) % 24));
	// if (diffHours > 0) {
	// diff += " " + diffHours + " hrs.";
	// }
	//
	// long diffMinutes = (milliElapsed / (60 * 1000) % 60);
	// if (diffMinutes > 0) {
	// diff += " " + diffMinutes + " mins.";
	// }
	//
	// // long diffSeconds = (milliElapsed / 1000 % 60);
	// // if (diffSeconds > 0) {
	// // diff += " " + diffSeconds + " secs.";
	// // }
	//
	// return (diff);
	// } catch (Exception ex) {
	// logger.error("ProjectManager===" + this.getClass().getName());
	// logger.error("Error in " + new Exception().getStackTrace()[0].getMethodName() + ": " + ex);
	// return "0";
	// }
	// }

	public String diffBetweenDates(Date first, Date second) {
		String diff = "";
		long milliElapsed = second.getTime() - first.getTime();

		long diffYear = Math.round((milliElapsed / (365.24 * 24 * 60 * 60 * 1000)));
		if (diffYear > 0) {
			diff += " " + diffYear + " years.";
		}

		long diffMonth = Math.round((milliElapsed / (365.24 * 24 * 60 * 60 * 1000 / 12)));
		if (diffMonth > 0) {
			diff += " " + diffMonth + " months.";
		}

		long diffDays = Math.round((milliElapsed / (24 * 60 * 60 * 1000)));
		if (diffDays > 0) {
			diff += " " + diffDays + " days.";
		}

		long diffHours = Math.round((milliElapsed / (60 * 60 * 1000) % 24));
		if (diffHours > 0) {
			diff += " " + diffHours + " hrs.";
		}

		long diffMinutes = (milliElapsed / (60 * 1000) % 60);
		if (diffMinutes > 0) {
			diff += " " + diffMinutes + " mins.";
		}

		// long diffSeconds = (milliElapsed / 1000 % 60);
		// if (diffSeconds > 0) {
		// diff += " " + diffSeconds + " secs.";
		// }
		return (diff);
	}

	public int DaysInMonth(int year, int month) {
		Calendar cal = new GregorianCalendar();
		cal.set(year, month - 1, 1);
		return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

}
