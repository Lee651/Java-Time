package top.rectorlee;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author Lee
 * @description java 时间处理方式
 * @date 2023-02-13  17:42:42
 */
public class JavaTime {
    public static void main(String[] args) {
        // methodOne();
        // methodTwo();
        // methodThree();
        // methodFour();
        // methodFive();
        // methodSix();
        // methodSeven();
        // methodEight();
        // methodNine();
        // methodTen();
        // methodEleven();
    }

    /**
     * java 8 获取当前日期(不含时分秒)
     */
    public static void methodOne() {
        LocalDate today = LocalDate.now();
        System.out.println("今天的日期: " + today);
    }

    /**
     * java 8 获取当前时间(不含年月日)
     */
    public static void methodTwo() {
        LocalTime now = LocalTime.now();

        System.out.println("获取当前时间(不含日期): " + now);
    }

    /**
     * java 8 获取当前年、月、日
     */
    public static void methodThree() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        Month month1 = today.getMonth();
        DayOfWeek dayOfWeek = today.getDayOfWeek();
        int dayOfYear = today.getDayOfYear();

        System.out.println("year: " + year);
        System.out.println("month: " + month);
        System.out.println("day: " + day);
        System.out.println("month1: " + month1);
        System.out.println("dayOfWeek: " + dayOfWeek);
        System.out.println("dayOfYear: " + dayOfYear);
    }

    /**
     * java 8 创建任意日期
     */
    public static void methodFour() {
        LocalDate date = LocalDate.of(1678, 12, 31);

        System.out.println("自定义日期: " + date);
    }

    /**
     * java 8 判断两个日期是否相等
     */
    public static void methodFive() {
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.of(2023, 2, 13);

        String flag = now.equals(date) ? "时间相等" : "时间不相等";

        System.out.println(flag);
    }

    /**
     * java 8 时间加减
     */
    public static void methodSix() {
        // LocalTime now = LocalTime.now();
        // LocalDate date = LocalDate.now();

        // LocalTime localTimed = now.plusHours(-3);
        // System.out.println("三个小时前的时间为: " + localTimed);

        // LocalDate nextWeekTime = date.plus(1, ChronoUnit.WEEKS);
        // System.out.println("一周后的时间为: " + nextWeekTime);

        // LocalDate lastYearDate = date.minus(-1, ChronoUnit.YEARS);
        // System.out.println("一年前的时间为: " + lastYearDate);

        LocalDate date = LocalDate.now();

        LocalDate lastYearDate1 = LocalDate.of(1993, 5, 29);
        Period between = Period.between(lastYearDate1, date);
        int days = between.getDays();
        System.out.println("2022-2-13 距今的天数为: " + days);
        int months = between.getMonths();
        System.out.println("2022-2-13 距今的月数为: " + months);
        int years = between.getYears();
        System.out.println("2022-2-13 距今的年数为: " + years);

    }

    /**
     * java 8 获取当前时间戳
     */
    public static void methodSeven() {
        long millis = Clock.systemUTC().millis();
        System.out.println("当前时间戳为: " + millis);

        long millis1 = Clock.systemDefaultZone().millis();
        System.out.println("当前时间戳为: " + millis1);

        long millis2 = Instant.now().toEpochMilli();
        System.out.println("当前时间戳为: " + millis2);
    }

    /**
     * java 8 时区处理
     */
    public static void methodEight() {
        ZoneId america = ZoneId.of("America/New_York");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now: " + now);

        ZonedDateTime AmericaTime = ZonedDateTime.of(now, america);
        System.out.println("AmericaTime: " + AmericaTime);
    }

    /**
     * java 8 检查闰年
     */
    public static void methodNine() {
        LocalDate now = LocalDate.now();
        String flag = now.isLeapYear() == true ? "当前年份是闰年" : "当前年份不是闰年";

        System.out.println(flag);
    }

    /**
     * java 8 任意日期格式化
     */
    public static void methodTen() {
        String time = "20220213";
        LocalDate date = LocalDate.parse(time, DateTimeFormatter.BASIC_ISO_DATE);

        System.out.println("格式化后的日期为: " + date);
    }

    /**
     * java 8 字符串、日期互转
     */
    public static void methodEleven() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String stringDate = now.format(formatter);

        System.out.println("日期转字符串为: " + stringDate);

        LocalDateTime date = LocalDateTime.parse(stringDate, formatter);
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        int hour = date.getHour();
        int minute = date.getMinute();
        int second = date.getSecond();

        System.out.println("字符串转日期为: " + year + "-0" + month + "-" + day + " " + hour + ":" + minute + ":" + second);
    }
}
