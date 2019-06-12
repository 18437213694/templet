package com.reactx.selection.models.base.util;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期操作辅助类
 * 
 * @author ShenHuaJie
 * @version $Id: DateUtil.java, v 0.1 2014年3月28日 上午8:58:11 ShenHuaJie Exp $
 */
public final class DateUtil {
	private DateUtil() {
	}

	/** 日期格式 **/
	public interface DATE_PATTERN {
		String HHMMSS = "HHmmss";

		String HH_MM_SS = "HH:mm:ss";

		String YYYYMMDD = "yyyyMMdd";

		String YYYY_MM_DD = "yyyy-MM-dd";

		String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";

		String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

		String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";

		String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

		String YYMMDD = "yyyyMMdd";
	}

	public static String getYearsMonth() {
		SimpleDateFormat fomat = new SimpleDateFormat(DATE_PATTERN.YYMMDD);
		return fomat.format(new Date());
	}

	/**
	 * 获得当前时间的int值
	 * 
	 * @return
	 */
	public static int getCurrentTimeStamp() {
		return Integer.parseInt(System.currentTimeMillis() / 1000 + "");
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static final String format(Object date) {
		return format(date, DATE_PATTERN.YYYY_MM_DD);
	}

	/**
	 * 字符串转化为时间
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static final Date parse(String dateStr, String pattern) {
		if (StringUtils.isBlank(dateStr) || StringUtils.isBlank(pattern)) {
			return null;
		}
		try {
			return new SimpleDateFormat(pattern).parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 格式化日期
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static final String format(Object date, String pattern) {
		if (date == null) {
			return null;
		}
		if (pattern == null) {
			return format(date);
		}
		return new SimpleDateFormat(pattern).format(date);
	}

	/**
	 * 获取日期
	 * 
	 * @return
	 */
	public static final String getDate() {
		return format(new Date());
	}

	/**
	 * 获取日期
	 * 
	 * @return
	 */
	public static final Date getNowDate() {
		return new Date();
	}

	/**
	 * 获取日期时间
	 * 
	 * @return
	 */
	public static final String getDateTime() {
		return format(new Date(), DATE_PATTERN.YYYY_MM_DD_HH_MM_SS);
	}

	/*	*//**
			 * 获取日期
			 * 
			 * @param pattern
			 * @return
			 *//*
				 * public static final String getDateTime(String pattern) { return format(new
				 * Date(), pattern); }
				 */

	/**
	 * 日期计算
	 * 
	 * @param date
	 * @param field
	 * @param amount
	 * @return
	 */
	public static final Date addDate(Date date, int field, int amount) {
		if (date == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, amount);
		return calendar.getTime();
	}

	/**
	 * 字符串转换为日期:不支持yyM[M]d[d]格式
	 * 
	 * @param date
	 * @return
	 */
	public static final Date stringToDate(String date) {
		if (date == null) {
			return null;
		}
		String separator = String.valueOf(date.charAt(4));
		String pattern = "yyyyMMdd";
		if (!separator.matches("\\d*")) {
			pattern = "yyyy" + separator + "MM" + separator + "dd";
			if (date.length() < 10) {
				pattern = "yyyy" + separator + "M" + separator + "d";
			}
		} else if (date.length() < 8) {
			pattern = "yyyyMd";
		}
		pattern += " HH:mm:ss.SSS";
		pattern = pattern.substring(0, Math.min(pattern.length(), date.length()));
		try {
			return new SimpleDateFormat(pattern).parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 间隔天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static final Integer getDayBetween(Date startDate, Date endDate) {
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		start.set(Calendar.HOUR_OF_DAY, 0);
		start.set(Calendar.MINUTE, 0);
		start.set(Calendar.SECOND, 0);
		start.set(Calendar.MILLISECOND, 0);
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		end.set(Calendar.HOUR_OF_DAY, 0);
		end.set(Calendar.MINUTE, 0);
		end.set(Calendar.SECOND, 0);
		end.set(Calendar.MILLISECOND, 0);

		long n = end.getTimeInMillis() - start.getTimeInMillis();
		return (int) (n / (60 * 60 * 24 * 1000l));
	}

	/**
	 * 间隔月
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static final Integer getMonthBetween(Date startDate, Date endDate) {
		if (startDate == null || endDate == null || !startDate.before(endDate)) {
			return null;
		}
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		int year1 = start.get(Calendar.YEAR);
		int year2 = end.get(Calendar.YEAR);
		int month1 = start.get(Calendar.MONTH);
		int month2 = end.get(Calendar.MONTH);
		int n = (year2 - year1) * 12;
		n = n + month2 - month1;
		return n;
	}

	/**
	 * 间隔月，多一天就多算一个月
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static final Integer getMonthBetweenWithDay(Date startDate, Date endDate) {
		if (startDate == null || endDate == null || !startDate.before(endDate)) {
			return null;
		}
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);
		int year1 = start.get(Calendar.YEAR);
		int year2 = end.get(Calendar.YEAR);
		int month1 = start.get(Calendar.MONTH);
		int month2 = end.get(Calendar.MONTH);
		int n = (year2 - year1) * 12;
		n = n + month2 - month1;
		int day1 = start.get(Calendar.DAY_OF_MONTH);
		int day2 = end.get(Calendar.DAY_OF_MONTH);
		if (day1 <= day2) {
			n++;
		}
		return n;
	}

	public static Date getTomorrow(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}
	public static Date getNextMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 1);
		return cal.getTime();
	}

	public static Date getToDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}
	public static Date getFirstDayInMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	public static Date getToDay() {
		return getToDay(new Date());
	}

	public static Map getFirstDayAndEndDay(String time) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(time));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		calendar.set(Calendar.DAY_OF_MONTH, 1);
			//将小时至0
		calendar.set(Calendar.HOUR_OF_DAY, 0);
			//将分钟至0
		calendar.set(Calendar.MINUTE, 0);
			//将秒至0
		calendar.set(Calendar.SECOND,0);
			//将毫秒至0
		calendar.set(Calendar.MILLISECOND, 0);
			//获得当前月第一天
		Date startDate = calendar.getTime();
			//将当前月加1；
		calendar.add(Calendar.MONTH, 1);
			//在当前月的下一月基础上减去1毫秒
		calendar.add(Calendar.MILLISECOND, -1);
			//获得当前月最后一天
		Date endDate = calendar.getTime();
		Map map = new HashMap();
		map.put("startDate",startDate);
		map.put("endDate",endDate);
		return map;
	}

	/**
	 * 两个时间相差分钟
	 * 
	 * @param startDate
	 * @param endDate
	 * @return 分钟
	 */
	public static Long getDiffMin(Date startDate, Date endDate) {
		long nh = 1000 * 60; // 分钟
		long startMill = startDate.getTime();
		long endMill = endDate.getTime();
		return (endMill - startMill) / nh;
	}

	public static String getTime(Date date) {
		SimpleDateFormat fomat = new SimpleDateFormat("HH:mm");
		return fomat.format(date);
	}

	public static Date getTime(String date) throws ParseException {
		SimpleDateFormat fomat = new SimpleDateFormat("HH:mm");
		return fomat.parse(date);
	}

	public static String getDate(Date date) {
		SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
		return fomat.format(date);
	}

	public static Date getDate(String date) throws ParseException {
		SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd");
		return fomat.parse(date);
	}

	public static String getDateTime(Date date) {
		SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return fomat.format(date);
	}

	public static Date getDateTime(String date) throws ParseException {
		SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return fomat.parse(date);
	}

	public static Date getYesterday() throws ParseException {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获得自定义格式日期
	 * 
	 * @param fmt
	 * @return
	 */
	public static String getFormatDate(String fmt) {
		SimpleDateFormat fomat = new SimpleDateFormat(fmt);
		return fomat.format(new Date());
	}

	/**
	 * 获得系统年
	 * 
	 * @return
	 */
	public static String getSysYear() {
		Calendar date = Calendar.getInstance();
		String year = String.valueOf(date.get(Calendar.YEAR));
		return year + "年";
	}

	/**
	 * 获得小时
	 * 
	 * @return
	 */
	public static int getHour() {
		SimpleDateFormat fomat = new SimpleDateFormat("HH");
		String string = String.valueOf(fomat.format(getNowDate()));
		return Integer.parseInt(string);
	}
	
	public static void main(String[] args) {
		System.out.println(getHour());
	}

	/**
	 * 两个日期是否相等
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean eqDate(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return false;
		}
		String str = format(date1, DATE_PATTERN.YYYY_MM_DD);
		String str2 = format(date2, DATE_PATTERN.YYYY_MM_DD);
		return str.equals(str2);
	}

}
