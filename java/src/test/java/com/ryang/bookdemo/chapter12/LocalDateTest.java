package com.ryang.bookdemo.chapter12;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @Auther: renyang
 * @Date: 2019/7/3 09:57
 * @Description:
 */
public class LocalDateTest {

    /**
     * Description: 创建LocalDate实例的方式
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/3 14:38
     */
    @Test
    public void creat(){
        // 1. 指定年月日创建对象
        LocalDate date1 = LocalDate.of(2019,7, 1);
        System.out.println(date1);

        // 2. 获取当前日期
        LocalDate date2 = LocalDate.now();
        System.out.println(date2);

        // 3. 根据日期字符串创建LocalDate对象
        LocalDate date3 = LocalDate.parse("2019-07-03");
        System.out.println(date3);

        // 4. 根据日期字符串创建LocalDate对象，且使用日期格式化对象进行格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        LocalDate date4 = LocalDate.parse("2019年07月04日",formatter);
        System.out.println(date4);

        // 5. 从LocalDateTime获取
        LocalDateTime dateTime1 = LocalDateTime.now();
        System.out.println(dateTime1.toString());
        LocalDate date5 = dateTime1.toLocalDate();
        System.out.println(date5);
    }

    /**
     * Description: 获取LocalDate对象中的年、月、日等值
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/3 14:37
     */
    @Test
    public void getLOcalDateValue(){
        // 创建指定日期的日期对象
        LocalDate date = LocalDate.now();
        System.out.println(date);

        System.out.println(date.getYear());// 得到当前年份
        Month month = date.getMonth();// 得到当前月份枚举值对象
        int monthValue = month.getValue();// 根据ordinal(枚举值序号，从0开始)来确定枚举的值
        System.out.println(monthValue);
        System.out.println(date.getDayOfMonth());// 获取当前月份值
        DayOfWeek dayOfWeek = date.getDayOfWeek();// 获取当前星期枚举值对象
        System.out.println(dayOfWeek.getValue());// 根绝星期枚举值对象得到星期几

        // 使用TemporalField读取LocalDate的值
        int year = date.get(ChronoField.YEAR);
        System.out.println(year);

        // 将日期以指定格式的字符串形式返回
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String s = date.format(formatter);
        System.out.println(s);
    }

    /**
     * Description: 利用with相关API操纵LocalDate对象，返回新的LocalDate对象(LocalDate为不可变类)
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/3 15:00
     */
    @Test
    public void changeLocalDateByWith() {
        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalDate date1 = date.withYear(2020);// 修改年的值
        System.out.println(date1);
        LocalDate date2 = date.withDayOfMonth(1);// 月日期的更改
        System.out.println(date2);
        LocalDate date3 = date.withDayOfYear(111);// 年日期的更改
        System.out.println(date3);

        // 使用第一个参数为TemporalField对象的with方法操纵日期对象得到新的日期对象
        LocalDate date4 = date.withMonth(8);
        System.out.println(date4);
        LocalDate date5 = date4.with(ChronoField.DAY_OF_WEEK, 2);
        System.out.println(date5);
    }

    /**
     * Description: 使用重载版的with方法，；利用TemporalAdjuster对象作为参数操纵日期对象，
     *              可以参考API中TemporalAdjusters类的静态方法
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/3 16:19
     */
    @Test
    public void changeLocalDateByTemporalAdjuster() {
        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalDate date1 = date.with(TemporalAdjusters.firstDayOfMonth());// 获得当前日期月份的第一天
        System.out.println(date1);

        LocalDate date2 = date.with(TemporalAdjusters.firstDayOfNextMonth());// // 获得当前日期下月份第一天
        System.out.println(date2);

        // 定制的TemporalAdjuster实现计算下一个工作日
        TemporalAdjuster adjuster = (temporal -> {
            DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToadd = 1;
            if (dayOfWeek == DayOfWeek.FRIDAY) dayToadd = 3;// 若为星期五，则加3天
            else if (dayOfWeek == DayOfWeek.SATURDAY) dayToadd = 2;// 若为礼拜6，则加2天
            return temporal.plus(dayToadd, ChronoUnit.DAYS);
        });
        LocalDate date3 = date.plus(2, ChronoUnit.DAYS).with(adjuster);
        System.out.println(date3);
    }

    /**
     * Description: 对LocalDate对象加减指定日、周、月、年
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/3 15:38
     */
    @Test
    public void increaseOrDecreaseLocalDate() {
        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalDate date1 = date.minusDays(3);// 当前日期减3天
        System.out.println(date1);
        LocalDate date2 = date.plusMonths(6);// 当前日期加6个月
        System.out.println(date2);
        // 使用带TemporalUnit对象指定计时单位的方法对日期进行加减
        LocalDate date3 = date.plus(6, ChronoUnit.MONTHS);
        System.out.println(date3);
    }

    /**
     * Description:两个日期进行比较
     * @auther: renyang
     * @param:
     * @return:
     * @date: 2019/7/3 20:57
     */
    @Test
    public void compare(){
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = date1.plusDays(666);
        /*
        * 1.使用LocalDate对象的compareTo()方法，
        *   先比较年份，若年份不一致，该方法返回年份差值，反之再比较月份
        *   年份一致，比较月份，月份不一致，返回月份差值，反正比较日。依次类推
        * */
        int differs = date2.compareTo(date1);// date2 - date1
        System.out.println(differs);

        // 2.直接使用含时间单位参数的until()方法，直接返回以指定单位做时间度量单位的long型数值，不能整除的直接断尾
        long differMonths = date1.until(date2, ChronoUnit.MONTHS);// until()方法，参数中的date2- data1
        System.out.println("相差月数：" + differMonths);
        long differDays = date1.until(date2, ChronoUnit.DAYS);
        System.out.println("相差天数：" + differDays);

        /*
        * 3.使用until方法得到返回的Period类对象，再使用Period类的API获取相差的年、月、日。
        *   Period类模型的数量或数量的时间，在几年，几个月和几天。表示为j年k月l天这种单元格式。
        *   若使用get相关方法获取时，若使用getDays()，则返回对应day单元的值l，表示年月余下的天数，不是两个时间之间完整的天数
        * */
        Period period2 = date1.until(date2);
        System.out.println(period2.getDays());// 这里的天是相差年、月后余下的天数，值不会超过月最大天数

        // 4.使用Period类进行比较
        Period period1 = Period.between(date1, date2);
        System.out.println(period1.getYears());// 相差几年
        System.out.println(period1.getMonths());// 相差几月
        System.out.println(period1.getDays());// 相差几日
        // 也可以使用get(),在方法内指定单元
        System.out.println(period1.get(ChronoUnit.DAYS));
    }

    @Test
    public void test1() {
        String dayYear = "2019-09";
        LocalDate openClassDate = LocalDate.parse(dayYear + "-01");
        // 第一阶段结束时间
        String level1Enddate = openClassDate.plusMonths(3).with(TemporalAdjusters.lastDayOfMonth()).toString();
        System.out.println(level1Enddate);
        // 第二阶段结束时间
        String level2Enddate = openClassDate.plusMonths(6).with(TemporalAdjusters.lastDayOfMonth()).toString();
        System.out.println(level2Enddate);
        // 第三阶段结束时间
        String level3Enddate = openClassDate.plusMonths(7).with(TemporalAdjusters.lastDayOfMonth()).toString();
        System.out.println(level3Enddate);
    }
}
