package com.ryang.bookdemo.chapter12;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: renyang
 * @Date: 2019/7/3 19:17
 * @Description:
 */
public class LocalDateTimeTest {

    /**
     * Description: 创建LocalTime实例的方式
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/3 19:19
     */
    @Test
    public void creat() {
        // 1.获取当前时间
        LocalDateTime dateTime1 = LocalDateTime.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTime1.format(formatter1));
        System.out.println(dateTime1.toString());

        // 2.指定时间创建对象
        LocalDateTime dateTime2 = LocalDateTime.of(2019, Month.JULY, 18, 19, 30, 30);
        System.out.println(dateTime2);

        // 3.使用LocalDate、LocalTime创建
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime3 = LocalDateTime.of(date, time);
        System.out.println("date " + date + "\n" + "time " + time + "\n" + dateTime3);

        // 4.根据日期字符串创建(默认时间格式为yyyy-MM-ddTHH:mm:ss)
        LocalDateTime dateTime4 = LocalDateTime.parse("2019-07-03T19:45:30");
        System.out.println(dateTime4);

        // 5.根据日期字符串创建，且指定时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime5 = LocalDateTime.parse("2019-07-03 19:45:30",formatter);
        System.out.println(dateTime5.format(formatter));

        // 6.将Date转换为LocalDateTime
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(new Date().toInstant(), zoneId);
        System.out.println("将Date转换为LocalDateTime");
        System.out.println(localDateTime);
        LocalDate endDate = localDateTime.with(TemporalAdjusters.lastDayOfMonth()).toLocalDate();
        System.out.println(endDate.toString());
    }

    /**
     * Description: 计算两个时间的时间差
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/4 11:41
     */
    @Test
    public void compare() {
        // 获取当前时间
        LocalDateTime dateTime1 = LocalDateTime.now();
        System.out.println(dateTime1);
        // 将当前时间增加12小时
        LocalDateTime dateTime2 = dateTime1.plus(200, ChronoUnit.DAYS);
        System.out.println(dateTime2);

        // 1.使用带时间单位的until()直接返回指定单位的时间差，这里的时间单位可以是年、月、日、星期、时、分、秒等
        long differHours = dateTime1.until(dateTime2, ChronoUnit.HOURS);
        System.out.println("相差" + differHours + "个小时");
        long differDays = dateTime1.until(dateTime2, ChronoUnit.DAYS);
        System.out.println("相差" + differDays + "天");
        long diffWeeks = dateTime1.until(dateTime2, ChronoUnit.WEEKS);
        System.out.println("相差" + diffWeeks + "个星期");

        // 2.使用Duration类的相关API，Duration类模型的数量或在秒和纳秒的时间量。它可以使用其他基于时间的单位，如分钟和小时访问
        Duration duration = Duration.between(dateTime1, dateTime2);
        long diffHours = duration.toHours();// 相差小时数
        System.out.println(diffHours);
        System.out.println(duration.toDays());// 相差天数

        // 使用Duration的get()相关方法，获取相差的秒、毫秒数
        long diffSeconds = duration.get(ChronoUnit.SECONDS);
        System.out.println(diffSeconds);// 相差秒数
    }

    @Test
    public void test1() {
        int dayOfYear = LocalDate.now().getYear();
        LocalDateTime nowDateTime = LocalDateTime.parse(dayOfYear + "-" + "10-22 13:37", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        LocalDateTime targetDateTime = LocalDateTime.parse(dayOfYear + "-" + "10-22 13:38", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.println(targetDateTime.isAfter(nowDateTime));
    }


}
