package org.interesting.cypress.common.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * java8 date library
 *
 * Instant：时间戳 <br/>
 * Duration：持续时间 ，时间差 <br/>
 * LocalDate：只包含日期，比如：2016-10-20<br/>
 * LocalTime：只包含时间，比如：23:12:10 <br/>
 * LocalDateTime：包含日期和时间，比如：2016-10-20 23:14:21<br/>
 * Period：时间段 ZoneOffset：时区偏移量，比如：+8:00 <br/>
 * ZonedDateTime：带时区的时间<br/>
 * Clock：时钟，比如获取目前美国纽约的时间
 * 
 * @author vv
 * @since 2017/8/13.
 */
public class DateUtil {

    public static final String PTN_DATE = "yyyy-MM-dd";

    public static final String PTN_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    private static final ZoneId ZONE_ID = ZoneId.of("Asia/Shanghai");

    private static final DateTimeFormatter DATE_TIME = DateTimeFormatter.ofPattern(PTN_DATE_TIME);

    /**
     * 得到当前毫秒数
     * 
     * @return 毫秒数
     */
    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 得到当前纳秒数
     * 
     * @return 纳秒数
     */
    public static long nanoTime() {
        return System.nanoTime();
    }

    /**
     * 获取今天日期
     * 
     * @return yyyy-MM-dd
     */
    public static String today() {
        return LocalDate.now().toString();
    }

    /**
     * 获取昨天日期
     * 
     * @return yyyy-MM-dd
     */
    public static String yesterday() {
        return LocalDate.now().minusDays(1).toString();
    }

    /**
     * 根据指定格式得到当前日期的字符串
     * 
     * @param pattern
     * @return
     */
    public static String now(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String day(long milliseconds) {
        LocalDate date = Instant.ofEpochMilli(milliseconds).atZone(ZONE_ID).toLocalDate();
        return date.toString();
    }

    public static String dayTime(long milliseconds) {
        return Instant.ofEpochMilli(milliseconds).atZone(ZONE_ID).format(DATE_TIME);
    }

    /**
     * 根据日期字符串和指定格式得到日期(年月日时分秒)
     *
     * @param date
     * @param pattern
     * @return
     */
    public static LocalDateTime parseToDateTime(String date, String pattern) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    public static long parseToMillis(String date, String pattern) {
        return parseToDateTime(date, pattern).atZone(ZONE_ID).toInstant().toEpochMilli();
    }

    /**
     * 根据日期字符串和指定格式得到日期(年月日)
     *
     * @param date
     * @param pattern
     * @return
     */
    public static LocalDate parseToDate(String date, String pattern) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    public static String format(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String format(LocalDateTime date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 获取当月的开始日期
     *
     * @param localDate 日期
     * @return 开始日期
     */
    public static LocalDate getFirstDayOfMonth(LocalDate localDate) {
        LocalDate firstDay = localDate.with(TemporalAdjusters.firstDayOfMonth());
        return firstDay;
    }

    /**
     * 获取当月的最后一天
     *
     * @param localDate 日期
     * @return 最后一天
     */
    public static LocalDate getLastDayOfMonth(LocalDate localDate) {
        LocalDate lastDay = localDate.with(TemporalAdjusters.lastDayOfMonth());
        return lastDay;
    }

    /**
     * 获取当月的最后一天
     * 
     * @param year 年
     * @param month 月
     * @return 最后一天
     */
    public static String getLastDayOfMonth(int year, int month) {
        LocalDate firstDate = LocalDate.of(year, month, 1);
        return getLastDayOfMonth(firstDate).toString();
    }

    /**
     * 根据日期字符串和指定格式得到日期(时分秒)
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static LocalTime getTime(String date, String pattern) {
        return LocalTime.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 判断给定的字符串日期是否是周末(周六和周日)
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static boolean isWeekends(String date, String pattern) {
        int value = LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern)).getDayOfWeek().getValue();
        // 周六(6)和周日(7)
        if (value == 6 || value == 7) {
            return true;
        }
        return false;
    }

    /**
     * 根据给定的字符串日期和指定的格式得到是星期几(1:周一;2:周二;3:周三;4:周四;5:周五;6:周六;7:周日)
     * 
     * @param date
     * @param pattern
     * @return
     */
    public static int getDayOfWeek(String date, String pattern) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern)).getDayOfWeek().getValue();
    }

    /**
     * 两时间早晚比较(年月日时分秒)
     * 
     * @param localDateTime1
     * @param localDateTime2
     * @return
     */
    public static boolean isBefore(LocalDateTime localDateTime1, LocalDateTime localDateTime2) {
        return localDateTime1.isBefore(localDateTime2);
    }

    /**
     * 两时间早晚比较(年月日)
     * 
     * @param localDate1
     * @param localDate2
     * @return
     */
    public static boolean isBefore(LocalDate localDate1, LocalDate localDate2) {
        return localDate1.isBefore(localDate2);
    }

    /**
     * 两时间早晚比较(时分秒)
     * 
     * @param localTime1
     * @param localTime2
     * @return
     */
    public static boolean isBefore(LocalTime localTime1, LocalTime localTime2) {
        return localTime1.isBefore(localTime2);
    }

}
