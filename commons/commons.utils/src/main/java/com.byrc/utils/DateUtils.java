package com.byrc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class DateUtils {

	public static final String DEFAULT_FORMAT = "yyyy-MM-dd";
	public static final String DEFAULT_FORMAT_INFO = "yyyy年MM月dd日";
	public static final String YYYY_MM_DD_HHmmss = "yyyy-MM-dd HH:mm:ss";

	/**
	 * yyyyMMdd
	 */
	public static String FORMAT = "yyMMdd";
	public static String FORMAT1 = "yyyyMMdd";
	public static String timePattern2 = "yyyyMMddHHmmss";
	public static String dateTimePattern = "yyyy-MM-dd HH:mm:ss";
	private static String timePattern = "HH:mm";
	private static String timePattern3 = "HH";
	private static String[] parsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss",
			"yyyy.MM.dd HH:mm", "yyyy.MM"};

	public static Date now() {
		return new Date();
	}

	public static long getDays(Date from, Date to) {
		long fromTime = from.getTime();
		long toTime = to.getTime();
		return (toTime - fromTime) / (1000 * 60 * 60 * 24);
	}

	public static Date getFirstDay(int year, int month) {
		String _month = month > 9 ? "" + month : "0" + month;
		Date firstDay = DateUtils.now();
		String startDt = year + "-" + _month + "-" + "01";
		try {
			firstDay = new SimpleDateFormat("yyyy-MM-dd").parse(startDt);
		} catch (Exception e) {
		}
		return firstDay;
	}

	public static Date getLastDay(int year, int month) {
		String _month = month > 9 ? "" + month : "0" + month;
		int days = DateUtils.getDaysByYearMonth(year, month);
		String _days = days > 9 ? "" + days : "0" + days;
		Date lastDay = DateUtils.now();
		String endDt = year + "-" + _month + "-" + _days;
		try {
			lastDay = new SimpleDateFormat("yyyy-MM-dd").parse(endDt);
		} catch (Exception e) {
		}
		return lastDay;

	}
	
	public static Date getDateByDays(int days) {
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.DATE, days);
		todayStart.set(Calendar.HOUR, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.set(Calendar.MILLISECOND, 0);
		return todayStart.getTime();
	}

	public static Date getDateBeforeHour(Date date, int hour) {
		if (date == null)
			date = now();
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.HOUR, now.get(Calendar.HOUR) - hour);
		return now.getTime();
	}

	public static Date getDateBefore(Date date, int days) {
		if (date == null)
			date = now();
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - days);
		return now.getTime();
	}

	public static Date getDateBeforeMonth(Date date, int months) {
		if (date == null)
			date = now();
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.MONTH, now.get(Calendar.MONTH) - months);
		return now.getTime();
	}

	public static Date getDateAfter(Date date, int days) {
		if (date == null)
			date = now();
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + days);
		return now.getTime();
	}

	public static Date getDateAfterYear(Date date, int year) {
		if (date == null)
			date = now();
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.YEAR, now.get(Calendar.YEAR) + year);
		return now.getTime();
	}
	
	public static Date getDateAfterHour(Date date, int hour) {
		if (date == null)
			date = now();
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.HOUR, now.get(Calendar.HOUR) + hour);
		return now.getTime();
	}

	
	public static String getDate(Date date, String format) {
		if (date == null)
			date = now();
		return new SimpleDateFormat(format).format(date);
	}

	public static String getCurrentDate(String format) {
		return getDate(new Date(), format);
	}

	public static String getCurrentDate() {
		return getCurrentDate("yyyy-MM-dd");
	}
	
	public static String getCurrentDateFt() {
		return getCurrentDate("yyyyMMdd");
	}
	
	public static String getCurrentDateAll() {
		return getCurrentDate("yyyyMMddHHmmss");
	}

	public static String getCurrentDateAllOther() {
		return getCurrentDate("yyMMddHHmmss");
	}
	
	public static String getCurrentDateOther() {
		return getCurrentDate("MMddHHmmss");
	}
	public static String getCurrentDateMD() {
		return getCurrentDate("MMdd");
	}
	public static String getCurrentDateHMS() {
		return getCurrentDate("HHmmss");
	}
	
	
	/**
	 * 自定义格式化时间
	 * 
	 * @param date
	 *            时间
	 * @param formatStr
	 *            格式化字符串，默�?MM/dd/yyyy
	 * @return 格式化的时间字符�?
	 */
	public static String formartDate(Date date, String formatStr) {
		if (date == null)
			date = now();
		if (StringUtils.isEmpty(formatStr)) {
			formatStr = "MM/dd/yyyy";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(date);
	}

	public static String formartDate2(Date date, String formatStr) {
		if (date == null) {
			return "";
		}
		if (StringUtils.isEmpty(formatStr)) {
			formatStr = "MM/dd/yyyy";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		return sdf.format(date);
	}

	/**
	 * 将带时间格式字符转换成时间类�?
	 * 
	 * @param dateStr
	 *            带时间格式的字符�?
	 * @param pattern
	 *            格式化字符串
	 * @return 转换后时间类型数�?
	 */
	public static Date formDate(String dateStr, String formatStr) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 转成siebel需要的时间格式
	 * 
	 * @param date
	 *            时间
	 * @return 格式化的时间字符
	 */
	public static String formartSiebelDate(Date date) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		return sdf.format(date);
	}
	
	/**
	 * 获取时间中的年月
	 * 
	 * @param date
	 *            时间
	 * @return 格式化的时间字符
	 */
	public static String getYearMonth(Date date) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		
		return sdf.format(date);
	}

	/**
	 * 获取当天�?��时间
	 * 
	 * @return
	 */
	public static Date getStartTime() {
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.HOUR, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.set(Calendar.MILLISECOND, 0);
		// return todayStart.getTime().getTime();
		return todayStart.getTime();
	}

	public static Date getStartTime(Date dt) {
		if (dt == null) {
			return null;
		}
		Calendar todayStart = Calendar.getInstance();
		todayStart.setTime(dt);
		todayStart.set(Calendar.HOUR, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.set(Calendar.MILLISECOND, 0);
		// return todayStart.getTime().getTime();
		return todayStart.getTime();
	}

	/**
	 * 获取未来的时�?
	 * 
	 * @return
	 */
	public static Date getEndTime() {
		Calendar todayEnd = Calendar.getInstance();
		todayEnd.set(Calendar.YEAR, 4028);
		todayEnd.set(Calendar.HOUR_OF_DAY, 23);
		todayEnd.set(Calendar.MINUTE, 59);
		todayEnd.set(Calendar.SECOND, 59);
		todayEnd.set(Calendar.MILLISECOND, 999);
		return todayEnd.getTime();
	}

	public static Date getEndTime(Date dt) {
		if (dt == null) {
			return null;
		}
		Calendar todayEnd = Calendar.getInstance();
		todayEnd.setTime(dt);
		todayEnd.set(Calendar.HOUR_OF_DAY, 23);
		todayEnd.set(Calendar.MINUTE, 59);
		todayEnd.set(Calendar.SECOND, 59);
		todayEnd.set(Calendar.MILLISECOND, 999);
		return todayEnd.getTime();
	}

	/**
	 * 比较两个时间�?
	 * 
	 * @param start
	 *            �?��时间
	 * @param end
	 *            结束时间
	 * @return 两个时间�?
	 * @throws ParseException
	 */

	public static long timeCompare(Date start, Date end) {
		Calendar aCalendar = Calendar.getInstance();

		aCalendar.setTime(start);

		int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);

		aCalendar.setTime(end);

		int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);

		return day2 - day1;

	}

	/**
	 * 比较两个时间大小
	 * 
	 * @param start
	 * @param end
	 * @return end - start > 0 true ,否则 false
	 */
	public static boolean compare(Date start, Date end) {
		Calendar aCalendar = Calendar.getInstance();

		aCalendar.setTime(start);

		int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);

		aCalendar.setTime(end);

		int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);

		return day2 - day1 >= 0 ? true : false;

	}

	public static int getYear() {
		Calendar a = Calendar.getInstance();
		return a.get(Calendar.YEAR);
	}

	public static int getMonth() {
		Calendar a = Calendar.getInstance();
		return a.get(Calendar.MONTH) + 1;
	}

	public static int getDate() {
		Calendar a = Calendar.getInstance();
		return a.get(Calendar.DATE);
	}
	
	public static String getYearMonth() {

		return getYear() + "" + getMonth();
	}

	public static Date getDateWithOverTime(Date dt) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	/**
	 * 根据年月获取对应月份的天�?
	 */
	public static int getDaysByYearMonth(int year, int month) {

		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}
	
	/**
	 * 时间加一个月
	 * @param date
	 * @return
	 */
	public static String add1Month(String date){//YYYYMM
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		
		Calendar calendar = Calendar.getInstance();
		
		try {
			
			calendar.setTime(format.parse(date));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		calendar.add(Calendar.MONTH, 2);
		
		int month = calendar.get(Calendar.MONTH);
		
		return calendar.get(Calendar.YEAR) + "" + (month < 10 ? ("0" + month) : month);
	}
	
	/**
	 * 时间加一个月
	 * @param date
	 * @return
	 */
	public static Date addMonth(Date date, int offset){//YYYYMM
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(date);
		
		calendar.add(Calendar.MONTH, offset);
		
		return calendar.getTime();
	}

	/**
	 * 返回最近三年的年份与月份
	 * @return
	 */
	public static List lately3YearMonth()
	{	
		List result = new ArrayList(); 
		
		Calendar ca = Calendar.getInstance(); 
		int curYear = ca.get(Calendar.YEAR);
		int curMonth = ca.get(Calendar.MONTH) + 1;
		int year;
		JSONObject temp;
		
		for (int i = 0; i < 3; i++) {
			
			ca.setTime(new Date());
			ca.add(Calendar.YEAR, -i);
			
			year = ca.get(Calendar.YEAR);
			
			for (int j = 12; j >= 1; j--) {
				
				if(year - curYear == 0 && j > curMonth) continue;
				
				temp = new JSONObject();
				temp.put("id", year + "" + (j < 10 ? "0" + j : j));
				temp.put("name", temp.get("id"));
				
				result.add(temp);
			}
		}
		
		return result;
	}
	
	/**
	 * 时间增加指定天数
	 */
	public static String addDays(Integer days){
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.add(Calendar.DATE, days);
		
		return formartDate(calendar.getTime(), "yyyyMMdd");
	}
	
	/**
	 * 时间增加指定天数
	 */
	public static Date addDays(Date date, Integer days){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		calendar.add(Calendar.DATE, days);
		
		return calendar.getTime();
	}
	
	public static Date getMonthStartTime(int month) {
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.MONTH,month);
		todayStart.set(Calendar.DATE,1);
		todayStart.set(Calendar.HOUR, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.set(Calendar.MILLISECOND, 0);
		todayStart.set(Calendar.AM_PM, 0);
		// return todayStart.getTime().getTime();
		return todayStart.getTime();
	}

	public static Date getMonthEndTime(int month) {
		Calendar todayEnd = Calendar.getInstance();
		todayEnd.set(Calendar.MONTH,month);
		todayEnd.set(Calendar.DATE,todayEnd.getActualMaximum(Calendar.DATE));
		todayEnd.set(Calendar.HOUR_OF_DAY, 23);
		todayEnd.set(Calendar.MINUTE, 59);
		todayEnd.set(Calendar.SECOND, 59);
		todayEnd.set(Calendar.MILLISECOND, 999);
		return todayEnd.getTime();
	}

	
	public static void main(String[] args) {
		System.out.println(formartSiebelDate(getMonthEndTime(10)));
	}

}
