package com.stock.trendline;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 日期类型与字符串类型相互转换
 */
public class DateUtil {

	/**
	 * Base ISO 8601 Date format yyyyMMdd i.e., 20021225 for the 25th day of
	 * December in the year 2002
	 */
	public static final String ISO_DATE_FORMAT = "yyyy-MM-dd";

	/**
	 * Expanded ISO 8601 Date format yyyy-MM-dd i.e., 2002-12-25 for the 25th
	 * day of December in the year 2002
	 */
	public static final String ISO_EXPANDED_DATE_FORMAT = "yyyy-MM-dd";

	/**
	 * yyyy-MM-dd hh:mm:ss
	 */
	public static String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static String GMT_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss'+00:00'";

	/**
	 * Default lenient setting for getDate.
	 */
	private static boolean LENIENT_DATE = false;

	/**
	 * 暂时不用
	 * 
	 * @param JD
	 * @return
	 */
	protected static final float normalizedJulian(float JD) {

		float f = Math.round(JD + 0.5f) - 0.5f;

		return f;
	}

	/**
	 * 浮点值转换成日期格式<br>
	 * 暂时不撁 Returns the Date from a julian. The Julian date will be converted to
	 * noon GMT, such that it matches the nearest half-integer (i.e., a julian
	 * date of 1.4 gets changed to 1.5, and 0.9 gets changed to 0.5.)
	 * 
	 * @param JD
	 *            the Julian date
	 * @return the Gregorian date
	 */
	public static final Date toDate(float JD) {

		/*
		 * To convert a Julian Day Number to a Gregorian date, assume that it is
		 * for 0 hours, Greenwich time (so that it ends in 0.5). Do the
		 * following calculations, again dropping the fractional part of all
		 * multiplicatons and divisions. Note: This method will not give dates
		 * accurately on the Gregorian Proleptic Calendar, i.e., the calendar
		 * you get by extending the Gregorian calendar backwards to years
		 * earlier than 1582. using the Gregorian leap year rules. In
		 * particular, the method fails if Y<400.
		 */
		float Z = (normalizedJulian(JD)) + 0.5f;
		float W = (int) ((Z - 1867216.25f) / 36524.25f);
		float X = (int) (W / 4f);
		float A = Z + 1 + W - X;
		float B = A + 1524;
		float C = (int) ((B - 122.1) / 365.25);
		float D = (int) (365.25f * C);
		float E = (int) ((B - D) / 30.6001);
		float F = (int) (30.6001f * E);
		int day = (int) (B - D - F);
		int month = (int) (E - 1);

		if (month > 12) {
			month = month - 12;
		}

		int year = (int) (C - 4715); // (if Month is January or February) or
		// C-4716 (otherwise)

		if (month > 2) {
			year--;
		}

		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1); // damn 0 offsets
		c.set(Calendar.DATE, day);

		return c.getTime();
	}

	/**
	 * Returns the days between two dates. Positive values indicate that the
	 * second date is after the first, and negative values indicate, well, the
	 * opposite. Relying on specific times is problematic.
	 * 
	 * @param early
	 *            the "first date"
	 * @param late
	 *            the "second date"
	 * @return the days between the two dates
	 */
	public static final int daysBetween(Date early, Date late) {

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(early);
		c2.setTime(late);

		return daysBetween(c1, c2);
	}

	/**
	 * Returns the days between two dates. Positive values indicate that the
	 * second date is after the first, and negative values indicate, well, the
	 * opposite.
	 * 
	 * @param early
	 * @param late
	 * @return the days between two dates.
	 */
	public static final int daysBetween(Calendar early, Calendar late) {

		return (int) (toJulian(late) - toJulian(early));
	}

	/**
	 * Return a Julian date based on the input parameter. This is based from
	 * calculations found at <a
	 * href="http://quasar.as.utexas.edu/BillInfo/JulianDatesG.html">Julian Day
	 * Calculations (Gregorian Calendar)</a>, provided by Bill Jeffrys.
	 * 
	 * @param c
	 *            a calendar instance
	 * @return the julian day number
	 */
	public static final float toJulian(Calendar c) {

		int Y = c.get(Calendar.YEAR);
		int M = c.get(Calendar.MONTH);
		int D = c.get(Calendar.DATE);
		int A = Y / 100;
		int B = A / 4;
		int C = 2 - A + B;
		float E = (int) (365.25f * (Y + 4716));
		float F = (int) (30.6001f * (M + 1));
		float JD = C + D + E + F - 1524.5f;

		return JD;
	}

	/**
	 * 暂时不用 Return a Julian date based on the input parameter. This is based
	 * from calculations found at <a
	 * href="http://quasar.as.utexas.edu/BillInfo/JulianDatesG.html">Julian Day
	 * Calculations (Gregorian Calendar)</a>, provided by Bill Jeffrys.
	 * 
	 * @param date
	 * @return the julian day number
	 */
	public static final float toJulian(Date date) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);

		return toJulian(c);
	}

	/**
	 * 日期增加
	 * 
	 * @param isoString
	 *            日期字符??
	 * @param fmt
	 *            格式
	 * @param field
	 *            ??/??/?? Calendar.YEAR/Calendar.MONTH/Calendar.DATE
	 * @param amount
	 *            增加数量
	 * @return
	 * @throws ParseException
	 */
	public static final String dateIncrease(String isoString, String fmt,
			int field, int amount) {

		try {
			Calendar cal = GregorianCalendar.getInstance(TimeZone
					.getTimeZone("GMT"));
			cal.setTime(stringToDate(isoString, fmt, true));
			cal.add(field, amount);

			return dateToString(cal.getTime(), fmt);

		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 * Time Field Rolling function. Rolls (up/down) a single unit of time on the
	 * given time field.
	 * 
	 * @param isoString
	 * @param field
	 *            the time field.
	 * @param up
	 *            Indicates if rolling up or rolling down the field value.
	 * @param expanded
	 *            use formating char's
	 * @exception ParseException
	 *                if an unknown field value is given.
	 */
	public static final String roll(String isoString, String fmt, int field,
			boolean up) throws ParseException {

		Calendar cal = GregorianCalendar.getInstance(TimeZone
				.getTimeZone("GMT"));
		cal.setTime(stringToDate(isoString, fmt));
		cal.roll(field, up);

		return dateToString(cal.getTime(), fmt);
	}

	/**
	 * Time Field Rolling function. Rolls (up/down) a single unit of time on the
	 * given time field.
	 * 
	 * @param isoString
	 * @param field
	 *            the time field.
	 * @param up
	 *            Indicates if rolling up or rolling down the field value.
	 * @exception ParseException
	 *                if an unknown field value is given.
	 */
	public static final String roll(String isoString, int field, boolean up)
			throws ParseException {

		return roll(isoString, DATETIME_PATTERN, field, up);
	}

	/**
	 * 字符串转换为日期java.util.Date
	 * 
	 * @param dateText
	 *            字符??
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static java.util.Date stringToDate(String dateString, String format) {

		return stringToDate(dateString, format, LENIENT_DATE);
	}

	/**
	 * 字符串转换为日期java.util.Date
	 * 
	 * @param dateText
	 *            字符??
	 */
	public static Date stringToDate(String dateString) {

		return stringToDate(dateString, ISO_EXPANDED_DATE_FORMAT, LENIENT_DATE);
	}

	/**
	 * 字符串转换为日期java.util.Date
	 * 
	 * @param dateText
	 *            字符??
	 */
	public static java.util.Date stringToDateTime(String dateString) {

		if(dateString.trim().length() < 11) dateString = dateString + " 00:00:00";
		return stringToDate(dateString, DATETIME_PATTERN, LENIENT_DATE);
	}

	/**
	 * 字符串转换为日期(不带时间和秒)java.sql.Date
	 * 
	 * @param dateText
	 *            字符??
	 */
	public static java.sql.Date sqlDate(String tringdateString) {

		Date date = stringToDate(tringdateString, ISO_EXPANDED_DATE_FORMAT,
				LENIENT_DATE);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}

	/**
	 * 字符串转换为日期java.util.Date
	 * 
	 * @param dateText
	 *            字符??
	 * @param format
	 *            日期格式
	 * @param lenient
	 *            日期越界标志
	 * @return
	 */
	public static Date stringToDate(String dateText, String format,
			boolean lenient) {

		if (dateText == null) {

			return null;
		}

		DateFormat df = null;

		try {

			if (format == null) {
				df = new SimpleDateFormat();
			} else {
				df = new SimpleDateFormat(format);
			}

			// setLenient avoids allowing dates like 9/32/2001
			// which would otherwise parse to 10/2/2001
			df.setLenient(false);
			return df.parse(dateText);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * java.util.date转换为日??(带时间和??)java.sql.Timestamp
	 * 
	 * @param date
	 *            字符??
	 */
	public static java.sql.Timestamp sqlDatetime(java.util.Date date) {

		Timestamp timeStamp = new Timestamp(date.getTime());
		return timeStamp;
	}

	/**
	 * 字符串转换为日期java.util.Date
	 * 
	 * @param dateText
	 *            字符??
	 */
	public static java.util.Date stringToSQLDate(String dateString) {

		Date date = stringToDate(dateString, DATETIME_PATTERN, LENIENT_DATE);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}

	/**
	 * 根据时间变量返回时间字符??
	 * 
	 * @return 返回时间字符??
	 * @param pattern
	 *            时间字符串样??
	 * @param date
	 *            时间变量
	 */
	public static String dateToString(Date date, String pattern) {
		if (date == null) {
			return null;
		}
		try {
			SimpleDateFormat sfDate = new SimpleDateFormat(pattern);
			sfDate.setLenient(false);
			return sfDate.format(date);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 根据时间变量返回时间字符?? yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		return dateToString(date, ISO_EXPANDED_DATE_FORMAT);
	}

	/**
	 * 返回当前时间
	 * 
	 * @return 返回当前时间(包含时分秒的)
	 */
	public static Date getCurrentDateTime() {
		java.util.Calendar calNow = java.util.Calendar.getInstance();
		java.util.Date dtNow = calNow.getTime();
		// java.sql.Date d = (java.sql.Date)calNow.getTime();
		return dtNow;
	}

	/**
	 * 返回当前时间
	 * 
	 * @return 返回当前时间(不包含时分秒??) 也可以用于数据库中的插入java.sql.Date(不包含时分秒??)
	 */
	public static java.sql.Date getCurrentDate() {
		java.util.Calendar calNow = java.util.Calendar.getInstance();
		java.util.Date dtNow = calNow.getTime();
		java.sql.Date sd = new java.sql.Date(dtNow.getTime());
		return sd;
	}

	public static String getCurrentStringDateTime() {
		return getCurrentDateString(DATETIME_PATTERN);
	}

	/**
	 * 返回当前日期字符??
	 * 
	 * @param pattern
	 *            日期字符串样??
	 * @return
	 */
	public static String getCurrentDateString(String pattern) {
		return dateToString(getCurrentDateTime(), pattern);
	}

	/**
	 * 返回当前日期字符?? yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getCurrentDateString() {
		return dateToString(getCurrentDateTime(), ISO_EXPANDED_DATE_FORMAT);
	}

	/**
	 * 返回当前日期+时间字符?? yyyy-MM-dd hh:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToStringWithTime(Date date) {

		return dateToString(date, DATETIME_PATTERN);
	}
	
	public static String dateToStringWithTime2(Date date) {

		return dateToString(date, "yyyyMMddHHmmss");
	}

	/**
	 * 日期增加-按日增加
	 * 
	 * @param date
	 * @param days
	 * @return java.util.Date
	 */
	public static Date dateIncreaseByDay(Date date, int days) {

		Calendar cal = GregorianCalendar.getInstance(TimeZone
				.getTimeZone("GMT"));
		cal.setTime(date);
		cal.add(Calendar.DATE, days);

		return cal.getTime();
	}

	/**
	 * 日期增加-按月增加
	 * 
	 * @param date
	 * @param days
	 * @return java.util.Date
	 */
	public static Date dateIncreaseByMonth(Date date, int mnt) {

		Calendar cal = GregorianCalendar.getInstance(TimeZone
				.getTimeZone("GMT"));
		cal.setTime(date);
		cal.add(Calendar.MONTH, mnt);

		return cal.getTime();
	}

	/**
	 * 日期增加-按年增加
	 * 
	 * @param date
	 * @param mnt
	 * @return java.util.Date
	 */
	public static Date dateIncreaseByYear(Date date, int mnt) {

		Calendar cal = GregorianCalendar.getInstance(TimeZone
				.getTimeZone("GMT"));
		cal.setTime(date);
		cal.add(Calendar.YEAR, mnt);

		return cal.getTime();
	}

	/**
	 * 日期增加
	 * 
	 * @param date
	 *            日期字符?? yyyy-MM-dd
	 * @param days
	 * @return 日期字符?? yyyy-MM-dd
	 */
	public static String dateIncreaseByDay(String date, int days) {
		return dateIncreaseByDay(date, ISO_DATE_FORMAT, days);
	}

	/**
	 * 日期前几天或者后几天的日?? days我正数是前几?? 为负数是后几??
	 * 
	 * @param date
	 *            日期字符??
	 * @param fmt
	 *            日期格式
	 * @param days
	 * @return
	 */
	public static String dateIncreaseByDay(String date, String fmt, int days) {
		return dateIncrease(date, fmt, Calendar.DATE, days);
	}

	/**
	 * 日期前几小时或???后几小?? days我正数是前几小时 为负数是后几小时
	 * 
	 * @param datetime
	 *            日期字符??
	 * @param fmt
	 *            日期格式
	 * @param days
	 * @return
	 */
	public static String dateTimeRollHours(String datetime, int hours) {
		// return dateIncrease(datetime, DATETIME_PATTERN, Calendar.DATE,
		// hours);
		try {
			Calendar cal = GregorianCalendar.getInstance(TimeZone
					.getTimeZone("GMT"));
			cal.setTime(stringToDate(datetime, DATETIME_PATTERN, true));
			cal.add(Calendar.HOUR, hours);
			return dateToString(cal.getTime(), DATETIME_PATTERN);

		} catch (Exception ex) {
			return null;
		}

	}

	/**
	 * 日期字符串格式转??
	 * 
	 * @param src
	 *            日期字符??
	 * @param srcfmt
	 *            源日期格??
	 * @param desfmt
	 *            目标日期格式
	 * @return
	 */
	public static String stringToString(String src, String srcfmt, String desfmt) {
		return dateToString(stringToDate(src, srcfmt), desfmt);
	}

	/**
	 * 根据??给日期返回两日期相差的秒??
	 * 
	 * @param d1
	 * @param d2
	 * @return 返回两个日期间隔的毫秒数
	 */
	public static long getSecond(Date d1, Date d2) {
		long a1 = d1.getTime();
		long a2 = d2.getTime();
		long a3 = (a2 - a1) / 1000;

		return a3;
	}

	/**
	 * 根据??秒数,计算相差的时间并??**??**??**秒返??
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static String getBeapartDate(long m) {
		String beapartdate = "";
		int nDay = (int) m / (24 * 60 * 60);
		int nHour = (int) (m - nDay * 24 * 60 * 60) / (60 * 60);
		int nMinute = (int) (m - nDay * 24 * 60 * 60 - nHour * 60 * 60) / 60;
		int nSecond = (int) m - nDay * 24 * 60 * 60 - nHour * 60 * 60 - nMinute
				* 60;
		beapartdate = nDay + "??" + nHour + "小时" + nMinute + "??" + nSecond + "??";

		return beapartdate;
	}

	/**
	 * 
	 * @param begindate
	 * @param endate
	 * @return
	 */
	public static int getBetweenDay(Date begindate, Date endate) {

		long a1 = begindate.getTime();
		long a2 = endate.getTime();
		long m = (a2 - a1) / 1000;
		int nDay = (int) (m / (60 * 60 * 24));
		return nDay;
	}

	/**
	 * 根据??秒数,计算相差的时间并??**时返??
	 * 
	 * @param begindate
	 * @param endate
	 * @return
	 */
	public static int getBetweenHour(Date begindate, Date endate) {

		long a1 = begindate.getTime();
		long a2 = endate.getTime();
		long m = (a2 - a1) / 1000;
		int nHour = (int) (m / (60 * 60));
		return nHour;
	}

	/**
	 * 根据??秒数,计算相差的时间并以分钟返??
	 * 
	 * @param begindate
	 * @param endate
	 * @return
	 */
	public static int getBetweenMinute(Date begindate, Date endate) {

		long a1 = begindate.getTime();
		long a2 = endate.getTime();
		long m = (a2 - a1) / 1000;
		int nMinute = (int) m / 60;
		return nMinute;
	}

	/**
	 * 把String begindate格林日志时间转化成yyyy-MM-dd HH:mm:ss日期?? 得到相差的小??
	 * 
	 * @param begindate
	 *            String yyyy-MM-dd'T'HH:mm:ss'+00:00'
	 * @param enddate
	 *            java.util.date
	 * @return
	 */
	public static int getBetweenHour(String begindate, Date enddate) {
		Date date1 = DateUtil.stringToDateTime(begindate);
		Date date2 = enddate;
		return DateUtil.getBetweenHour(date1, date2);
	}

	/**
	 * 
	 * @param begindate
	 *            String yyyy-MM-dd HH:mm:ss
	 * @param enddate
	 *            java.util.date
	 * @return
	 */
	public static int getGMTBetweenHour(String begindate, Date enddate) {

		Date date1 = DateUtil.stringToDate(DateUtil.stringToString(begindate,
				"yyyy-MM-dd'T'HH:mm:ss'+00:00'", "yyyy-MM-dd HH:mm:ss"),
				"yyyy-MM-dd HH:mm:ss");
		Date date2 = enddate;
		return DateUtil.getBetweenHour(date1, date2);
	}

	/**
	 * 
	 * 把String格林日志时间转化成yyyy-MM-dd HH:mm:ss日期?? 得到相差的分??
	 */
	public static int getGMTBetweenMinute(String begindate, Date enddate) {
		Date date1 = DateUtil.stringToDate(DateUtil.stringToString(begindate,
				"yyyy-MM-dd'T'HH:mm:ss'+00:00'", "yyyy-MM-dd HH:mm:ss"),
				"yyyy-MM-dd HH:mm:ss");
		Date date2 = enddate;
		return DateUtil.getBetweenMinute(date1, date2);
	}

	public static int getGMTBetweenDay(String begindate, Date enddate) {
		Date date1 = DateUtil.stringToDate(DateUtil.stringToString(begindate,
				"yyyy-MM-dd'T'HH:mm:ss'+00:00'", "yyyy-MM-dd HH:mm:ss"),
				"yyyy-MM-dd HH:mm:ss");
		Date date2 = enddate;
		return DateUtil.getBetweenDay(date1, date2);
	}

	public static String getGMTStringDatetime(String datetime) {
		return stringToString(datetime, GMT_DATE_TIME, DATETIME_PATTERN);
	}

	/*
	 * 从字符串类型的yyyy-MM-dd'T'HH:mm:ss'+00:00'转化成Date类型??"yyyy-MM-dd HH:mm:ss"形式
	 * eg:String类型??2008-01-28T10:30:08+00:00转化成java.util.Date?? 2008-01-28
	 * 10:30:08
	 */
	public static java.util.Date getDatetimeFromGMTDatetime(String gmtString) {
		Date date = DateUtil.stringToDate(DateUtil.stringToString(gmtString,
				"yyyy-MM-dd'T'HH:mm:ss'+00:00'", "yyyy-MM-dd HH:mm:ss"),
				"yyyy-MM-dd HH:mm:ss");
		return date;

	}

	/**
	 * 
	 * 从字符串的格林威治时间转化成字符串的本地的时?? ??2008-01-28T10:30:08+00:00这种格式转化 :2008-01-28
	 * 18:30:08
	 * 
	 * @param gmtDatetimeString
	 * @return
	 */
	public static String getLocalzoneDatetime(String gmtDatetimeString) {
		Date curDate = DateUtil.getDatetimeFromGMTDatetime(gmtDatetimeString);
		// logger.debug("格林威治时间:" + curDate);
		Calendar c = Calendar.getInstance(); // 帮助得到curDate的年,??,??,??,??,??
		c.setTime(curDate);

		TimeZone gmtTimezone = TimeZone.getTimeZone("GMT");// 格林威治

		Calendar gmtCal = Calendar.getInstance(gmtTimezone);
		gmtCal.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c
				.get(Calendar.DATE), c.get(Calendar.HOUR_OF_DAY), c
				.get(Calendar.MINUTE), c.get(Calendar.SECOND));// 2002-09-02
		// logger.debug("本地时间:" + gmtCal.getTime());
		return dateToString(gmtCal.getTime(), DATETIME_PATTERN);

	}

	/**
	 * 
	 * 从字符串的格林威治时间转化成字符串的本地的时?? ??2008-01-28 10:30:08这种格式转化,从数据库中查出来的就是这种格??
	 * :2008-01-28 18:30:08
	 * 
	 * @param gmtDatetimeString
	 * @return
	 */
	public static String getLocalDatetime(String dateString) {
		Date curDate = DateUtil.stringToDateTime(dateString);
		System.out.println("格林威治时间:" + curDate);
		Calendar c = Calendar.getInstance(); // 帮助得到curDate的年,??,??,??,??,??
		c.setTime(curDate);

		TimeZone gmtTimezone = TimeZone.getTimeZone("GMT");// 格林威治

		Calendar gmtCal = Calendar.getInstance(gmtTimezone);
		gmtCal.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c
				.get(Calendar.DATE), c.get(Calendar.HOUR_OF_DAY), c
				.get(Calendar.MINUTE), c.get(Calendar.SECOND));// 2002-09-02
		System.out.println("本地时间:" + gmtCal.getTime());
		return dateToString(gmtCal.getTime(), DATETIME_PATTERN);

	}

	/**
	 * 
	 * 从util.date的格林威治时间转化成字符串的本地的时?? ??2008-01-28 10:30:08这种格式转化,从数据库中查出来的就是这种格??
	 * :2008-01-28 18:30:08
	 * 
	 * @param gmtDatetimeString
	 * @return
	 */
	public static Date getLocalDatetime(Date curDate) {
		System.out.println("格林威治时间1:" + curDate);
		Calendar c = Calendar.getInstance(); // 帮助得到curDate的年,??,??,??,??,??
		c.setTime(curDate);

		TimeZone gmtTimezone = TimeZone.getTimeZone("GMT");// 格林威治

		Calendar gmtCal = Calendar.getInstance(gmtTimezone);
		gmtCal.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c
				.get(Calendar.DATE), c.get(Calendar.HOUR_OF_DAY), c
				.get(Calendar.MINUTE), c.get(Calendar.SECOND));
		System.out.println("本地时间1:" + gmtCal.getTime());
		return gmtCal.getTime();

	}

	/**
	 * 把java.util.date类型转化为java.sql.date (其中)date??(时分秒被截掉)
	 * 
	 * @param date
	 * @return
	 */
	public static java.sql.Date datetimeToDate(java.util.Date date) {
		java.sql.Date sd = new java.sql.Date(date.getTime());
		return sd;
	}

	/**
	 * 得到当前的格林日??, 比东八区(北京时间)??8个小?? 格式: yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getCurrentGMTDate() {
		TimeZone timeZoneGMT = TimeZone.getTimeZone("GMT");
		Date curDate = new Date();
		SimpleDateFormat dateFormatterGMT = new SimpleDateFormat("yyyy-MM-dd");
		dateFormatterGMT.setTimeZone(timeZoneGMT);
		String gmt = dateFormatterGMT.format(curDate);
		return gmt;
	}

	/**
	 * 得到当前的格林日志时??, 比东八区??8个小?? 这是??"yyyy-MM-dd HH:mm:ss"格式以后?? eg:2008-02-26
	 * 12:21:49
	 * 
	 * @return
	 */
	public static String getCurrentGMTDateTime() {
		TimeZone timeZoneGMT = TimeZone.getTimeZone("GMT");
		Date curDate = new Date();
		SimpleDateFormat dateFormatterGMT = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		dateFormatterGMT.setTimeZone(timeZoneGMT);
		String gmt = dateFormatterGMT.format(curDate);
		return gmt;
	}

	/**
	 * 得到当前的格林日志时??(包含时分??) eg;就是北京时间减去8个小??
	 * 
	 * @return java.util.date类型
	 */
	public static Date getCurrentGMTDateAndTime() {
		Date date = stringToDateTime(getCurrentGMTDateTime());
		return date;
	}

	/**
	 * 得到当前的格林日志时??,比东八区??8个小?? 这是??"yyyy-MM-dd'T'HH:mm:ss"格式以后??
	 * eg:2008-02-26T12:21:49+00:00
	 * 
	 * @return
	 */
	public static String getCurrentGMTDateTime1() {
		TimeZone timeZoneGMT = TimeZone.getTimeZone("GMT");
		// SimpleDateFormat dateFormatterChina = new
		// SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date curDate = new Date();
		SimpleDateFormat dateFormatterGMT = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss'+00:00'");
		dateFormatterGMT.setTimeZone(timeZoneGMT);
		// String local = dateFormatterChina.format(curDate);
		String gmt = dateFormatterGMT.format(curDate);
		return gmt;
	}

	public static Date getNextMonthDate() {
		Date stringToDate = DateUtil.stringToDateTime(DateUtil
				.getCurrentGMTDateTime());
		Calendar c = Calendar.getInstance();
		c.setTime(stringToDate);
		c.add(Calendar.MONTH, 1);
		return c.getTime();
	}

	public static Date getNextMonthDate(Date date) {
		// Date stringToDate = DateUtil.stringToDate(DateUtil
		// .getCurrentGMTDate());
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, 1);
		return c.getTime();
	}

	public static Date getPreviosMonthDate(Date date) {
		// Date stringToDate = DateUtil.stringToDate(DateUtil
		// .getCurrentGMTDate());
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, -1);
		return c.getTime();
	}

	/**
	 * 得到本月的第???? 待完??
	 * 
	 * @return
	 */
	public static String getMonthFirstDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, calendar
				.getActualMinimum(Calendar.DAY_OF_MONTH));

		// return dateFormat("yyyy-MM-dd", calendar.getTime());
		return null;
	}

	/**
	 * 得到本月的最后一?? 待完??
	 * 
	 * @return
	 */
	public static String getMonthLastDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, calendar
				.getActualMaximum(Calendar.DAY_OF_MONTH));
		// return dateFormat("yyyy-MM-dd", calendar.getTime());
		return null;
	}

	public static void main(String[] args) throws ParseException {

		// Date date = DateUtil.getCurrentDate();
		// System.err.println(date);
		//		
		// Date dated = DateUtil.sqlDate("2009-2-6");
		// System.err.println(dated);
		// int day = DateUtil.getBetweenDay(date, dated);
		// System.err.println(day);
		// int i = day%3;
		// System.err.println(i);
		// System.out.println(DateUtil.dateIncreaseByDay(DateUtil.getCurrentDate(),3-i));

		// System.err.println(DateUtil.dateIncreaseByDay(DateUtil.getCurrentGMTDate(),
		// 3));

		// System.out.println(DateUtil.dateIncreaseByDay(DateUtil
		// .stringToDateTime(DateUtil.getCurrentGMTDateTime()),
		// ExpireLimit.BILLDATE_CYCLE));

		System.out.println(new Date());
	}
}
